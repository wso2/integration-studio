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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.generic.GenericRecord;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.wso2.datamapper.engine.inputAdapters.XmlInputReader;
import org.wso2.datamapper.engine.models.MappingConfigModel;

public class DataMapper {
	
	public String doMap(File configFile, InputStream inStream, File inputSchema,File outputSchema) throws IOException, IllegalAccessException, InstantiationException, JSONException {
		
		InputStream inputStream = inStream;
		
		Schema inputAvroSchema = new Parser().parse(inputSchema);
		Schema outputAvroSchema = new Parser().parse(outputSchema);
		
		XmlInputReader inputReader = new XmlInputReader();
		inputReader.setInptStream(inputStream);
		
		Context context = Context.enter();
		context.setOptimizationLevel(-1);
		Scriptable scope = context.initStandardObjects();
		
		BufferedReader configReader = new BufferedReader(new FileReader(configFile));
		MappingHandler mappingHandler = new MappingHandler(inputAvroSchema,outputAvroSchema,scope,inputReader,context);	
		
		String configLine = "";
		String configScript= "";
		Pattern functionIdPattern = Pattern.compile("function map_(L|S)_([a-zA-Z]+)_(L|S)_([a-zA-Z]+)");
		
		HashMap<String, MappingConfigModel> mappingModelMap = new HashMap<String, MappingConfigModel>();
		MappingConfigModel mappingModel;
		
		while ((configLine = configReader.readLine()) != null) {
			configScript = configScript.concat(configLine);			
			Matcher matcher = functionIdPattern.matcher(configLine);
			mappingModel = new MappingConfigModel();

			if(matcher.find()){
				mappingModel.setMappingFunctionType(matcher.group(1));
				mappingModel.setOutputDataType(matcher.group(4));
				mappingModelMap.put(matcher.group(2), mappingModel);
			}
		}
		
		context.evaluateString(scope, configScript ,"", 1, null);
		GenericRecord outputRecord = null;	
		
		try {
			outputRecord = mappingHandler.executeMappingFunctions(mappingModelMap);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		configReader.close();
		
		OutputJsonBuilder outJsonBuilder = new OutputJsonBuilder();
		JSONObject resultJson = outJsonBuilder.getOutPut(outputRecord, outputAvroSchema.getName());
		
		return resultJson.toString();
		
	}

}
