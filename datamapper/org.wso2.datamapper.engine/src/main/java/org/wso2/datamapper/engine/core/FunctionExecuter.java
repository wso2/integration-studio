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
import org.mozilla.javascript.Function;
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
		
 
		GenericRecord resultRecord = null;		
		MappingConfigModel mappingModel = mappingModelMap.get(elementId);
		
		if (mappingModel != null) {

		//	String inputDataType = inElementId;
			String outputDataType = mappingModel.getOutputDataType();
			String funcType = mappingModel.getMappingFunctionType();
			Schema outputSchema = outputSchemaMap.get(outputDataType);

			GenericRecord  outputRecord = new GenericData.Record(outputSchema);
			ScriptableObjectFactory inputRecordWrapper = new ScriptableObjectFactory(inRecord,this.scope);
			ScriptableObjectFactory outputRecordWrapper = new ScriptableObjectFactory(outputRecord,this.scope);
			
			/*Object wrappedOut = Context.javaToJS(System.out, scope);
	        ScriptableObject.putProperty(scope, "out", wrappedOut);*/
			
			 String fnName = "map_"+funcType+"_"+elementId+"_"+funcType+"_"+outputDataType;
			 Function fn = (Function)scope.get(fnName, scope);
			 Object resultOb = fn.call(context, this.scope, this.scope, new Object[] {inputRecordWrapper,outputRecordWrapper});

			if(resultOb != ScriptableObject.NOT_FOUND){
				resultRecord = outputRecordWrapper.getRecord();
			}
		}

		return resultRecord;
		
	}
}