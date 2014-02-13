/*
 * Copyright 2005,2013 WSO2, Inc. http://www.wso2.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.datamapper.engine.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.wso2.datamapper.engine.inputAdapters.InputDataReaderAdapter;
import org.wso2.datamapper.engine.models.MappingConfigModel;

public class MappingHandler {

	private Schema inputSchema;
	private Schema outputSchema;
	private Scriptable scope;
	private InputDataReaderAdapter inputDataReader;
	private Context context;
	private JSONObject outputJson;
	private Map<String, Schema> inputSchemaMap;
	private Map<String, Schema> outputSchemaMap;
	private HashMap<String, MappingConfigModel> mappingModelMap;

	public MappingHandler(Schema inSchema, Schema outSchema, Scriptable scope,
			InputDataReaderAdapter inputDataReader, Context context) {
		
		this.inputSchema = inSchema;
		this.outputSchema = outSchema;
		this.scope = scope;
		this.inputDataReader = inputDataReader;
		this.context = context;
		
	}

	public GenericRecord executeMappingFunctions(HashMap<String, MappingConfigModel> mappingTypes) throws JSONException {
		
		SchemaCreator inputSchemaCreator = new SchemaCreator();	
		inputSchemaCreator.setSchema(inputSchema);
		inputSchemaMap = inputSchemaCreator.getSchemaMap();
			
		SchemaCreator outputSchemaCreator = new SchemaCreator();	
		outputSchemaCreator.setSchema(outputSchema);
		outputSchemaMap = outputSchemaCreator.getSchemaMap();		
		
		Map<String, String> outputAvroArrayMap = outputSchemaCreator.getAvroArrayMap();
		Map<String, String> inputAvroArrayMap = inputSchemaCreator.getAvroArrayMap();
		inputDataReader.setInputSchemaMap(inputSchemaMap);
		
		mappingModelMap = mappingTypes;
		FunctionExecuter funcExecuter = new FunctionExecuter(mappingModelMap, scope, outputSchemaMap, context, inputAvroArrayMap);	
		
		GenericRecord inputRecord = new GenericData.Record(inputSchema);
		GenericRecord outputRecord = new GenericData.Record(outputSchema);
		GenericRecord childRecord = null;
		GenericRecord resultRecord = null;
		
		String arrayId = null;
		GenericData.Array<GenericRecord> recArray =null;
		
		inputDataReader.setRootRecord(inputRecord);
		
		List<GenericRecord> outRecordList = null;
		Map<String, List<GenericRecord>> outRecordMap = new HashMap<String, List<GenericRecord>>();
		String outSchemaName = null;
		GenericRecord rootRecord;
		List<GenericRecord> inChildRecordList = new ArrayList<GenericRecord>();
		List<GenericRecord> arrayChildList;
		
		while (inputDataReader.hasChildRecords()) {
			
			childRecord = inputDataReader.getChildRecord();
			arrayChildList = inputDataReader.getArrayChildList();
			
			if(childRecord != null){	
				resultRecord = funcExecuter.execute(childRecord.getSchema().getName(), childRecord);	
				
				 if(resultRecord != null) {
					arrayId = outputAvroArrayMap.get(resultRecord.getSchema().getName());

					if(arrayId != null){		
						if((outSchemaName != null) && (arrayId.equals(outSchemaName))){
							outRecordList.add(resultRecord);
							outRecordMap.put(resultRecord.getSchema().getName(), outRecordList);
						}else{
							outSchemaName = arrayId;
							outRecordList = new ArrayList<GenericRecord>();
							outRecordList.add(resultRecord);	
						}
					}else{
						outRecordList = new ArrayList<GenericRecord>();
						outRecordList.add(resultRecord);
						outRecordMap.put(resultRecord.getSchema().getName(), outRecordList);
					}
				}else{
					inChildRecordList.add(childRecord);
				}
				
			}else if(arrayChildList != null){
				
				outRecordList = new ArrayList<GenericRecord>();	
				String recordId = null;
				for (GenericRecord arrayChild : arrayChildList) {
					recordId = arrayChild.getSchema().getName();
					if(inputAvroArrayMap.containsKey(recordId)){
						resultRecord = funcExecuter.execute(recordId, arrayChild);
					}else{
						resultRecord = funcExecuter.execute(inputAvroArrayMap.get(recordId), arrayChild);
					}	
					outRecordList.add(resultRecord);
				}
				String resultrecordId = resultRecord.getSchema().getName();
				if(recordId != null){
					outRecordMap.put(resultrecordId, outRecordList);
				}
			}
		}
		
		rootRecord = inputDataReader.getRootRecord();
		
		for (GenericRecord genericRecord : inChildRecordList) {
			rootRecord.put(genericRecord.getSchema().getName(), genericRecord);
		}
		
		outputRecord = funcExecuter.execute(inputDataReader.getRootRecord().getSchema().getName(), rootRecord);
		
		if (outputRecord == null) {
			outputRecord = new GenericData.Record(outputSchema);
		}
		
		Iterator<String> outRecordKeySet = outRecordMap.keySet().iterator();
		String key;
		List<GenericRecord> recList;
		
		while (outRecordKeySet.hasNext()) {
			key = outRecordKeySet.next();
			Schema tempsc = null;
			
			if(outputAvroArrayMap.containsKey(key)){
				tempsc = outputSchemaMap.get(outputAvroArrayMap.get(key));
			}else{
				tempsc = outputSchemaMap.get(key);
			}
			recList = outRecordMap.get(key);
			
			if (tempsc.getType() == Schema.Type.RECORD) {
				for (GenericRecord genericRecord : recList) {
					outputRecord.put(key, genericRecord);
				}	
			}else if (tempsc.getType() == Schema.Type.ARRAY) {
				recArray = new GenericData.Array<GenericRecord>(recList.size(), tempsc);
				
				for (GenericRecord genericRecord : recList) {
					recArray.add(genericRecord);
				}	
				outputRecord.put(outputAvroArrayMap.get(key), recArray);
			}
		}	

		return outputRecord;
	}
	
	public void endmapping() throws IOException{
				
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File("./resources/output.json")));
		outputWriter.write(outputJson.toString());
		outputWriter.flush();
		outputWriter.close();
		
		System.out.println("end writing");
	}

}
