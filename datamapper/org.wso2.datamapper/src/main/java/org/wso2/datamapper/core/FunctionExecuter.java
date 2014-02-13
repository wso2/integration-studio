/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.datamapper.core;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.wso2.datamapper.model.OutputDataModel;


public class FunctionExecuter{
	
	public GenericRecord executeFunction(GenericRecord inputRecord, OutputDataModel dataModel, Schema outSchema) {
		
		String function = dataModel.getFunction();
		List<String> args = dataModel.getArgList();
		StringBuilder result = new StringBuilder();
		Iterator<String> argItr = args.listIterator();
		GenericRecord outRecord = new GenericData.Record(outSchema);
		
		if(function.equals("concat")){
			while (argItr.hasNext()) {
				result.append(inputRecord.get(getElementName(argItr.next()))+" ");
			}
			outRecord.put(getElementName(dataModel.getOutputElement()),result.toString().trim());
		}
		return outRecord;
	}

	public String getElementName(String element) {
		String value= "";
		StringTokenizer st = new StringTokenizer(element, ".");
		
		while (st.hasMoreTokens()) {
			value = (String)st.nextElement();
		}	
		return value;
	}
	
	
}
