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
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.wso2.datamapper.engine.models.MappingConfigModel;

public class FunctionExecuter {
	
	private HashMap<String, MappingConfigModel> mappingModelMap;
	private Scriptable scope;
	private Map<String, Schema> outputSchemaMap;
	private Context context;
	
	public FunctionExecuter(HashMap<String, MappingConfigModel> mappingTypes , Scriptable scope , Map<String, Schema> outputSchemaMap , Context context, Map<String, String> avroArrayMap) {
		this.mappingModelMap = mappingTypes;
		this.scope = scope;
		this.outputSchemaMap = outputSchemaMap;
		this.context = context;
	}

	public GenericRecord execute(String elementId, GenericRecord inRecord) {
		
		GenericRecord inputRecord = inRecord;
		String inElementId = elementId;
		
		GenericRecord resultRecord = null;		
		MappingConfigModel mappingModel = mappingModelMap.get(inElementId);
		
		if (mappingModel != null) {

			String inputDataType = inElementId;
			String outputDataType = mappingModel.getOutputDataType();
			String funcType = mappingModel.getMappingFunctionType();
			
			Schema outputSchema = outputSchemaMap.get(outputDataType);
			GenericRecord  outputRecord = null;
			
			if(outputSchema.getType() == Schema.Type.ARRAY){
				outputRecord = new GenericData.Record(outputSchema.getElementType());
			}else{
				outputRecord = new GenericData.Record(outputSchema);
			}

			ScriptableObjectFactory inputRecordWrapper = new ScriptableObjectFactory(inputRecord);
			ScriptableObjectFactory outputRecordWrapper = new ScriptableObjectFactory(outputRecord);
			
			this.scope.put("input", scope, inputRecordWrapper);
			this.scope.put("output", scope, outputRecordWrapper);
			
			StringBuilder configScript = new StringBuilder("map_"+funcType+"_"+inputDataType+"_"+funcType+"_"+outputDataType+"();");
			Object resultOb = context.evaluateString(scope, configScript.toString(), "", 1, null);

			if(resultOb != ScriptableObject.NOT_FOUND){
				resultRecord = outputRecordWrapper.getRecord();
			}
		}

		return resultRecord;
		
	}
}
