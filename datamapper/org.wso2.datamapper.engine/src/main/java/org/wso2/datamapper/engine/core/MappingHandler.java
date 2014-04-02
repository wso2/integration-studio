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

import java.util.HashMap;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.json.JSONException;
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
		
		Map<String, String> inputAvroArrayMap = inputSchemaCreator.getAvroArrayMap();
		inputDataReader.setInputSchemaMap(inputSchemaMap);
		
		mappingModelMap = mappingTypes;
		FunctionExecuter funcExecuter = new FunctionExecuter(mappingModelMap, scope, outputSchemaMap, context, inputAvroArrayMap);	
		
		GenericRecord inputRecord = new GenericData.Record(inputSchema);
		GenericRecord outputRecord = new GenericData.Record(outputSchema);
		GenericRecord childRecord = null;

		inputDataReader.setRootRecord(inputRecord);
		childRecord = inputDataReader.getChildRecord(inputSchema);
		if(childRecord != null){	
			outputRecord = funcExecuter.execute(childRecord.getSchema().getName(), childRecord);						
		}
		
		return outputRecord;
	}
	
/*	public void endmapping1() throws IOException{
				
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(new File("./resources/output.json")));
		outputWriter.write(outputJson.toString());
		outputWriter.flush();
		outputWriter.close();
	}*/

}
