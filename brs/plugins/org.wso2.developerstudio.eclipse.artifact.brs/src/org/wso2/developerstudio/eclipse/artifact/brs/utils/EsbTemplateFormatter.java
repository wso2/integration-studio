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

package org.wso2.developerstudio.eclipse.artifact.brs.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * ESB Template formatter will format the inputed template content to an well-formed XML
 */
public class EsbTemplateFormatter {
	
	private static Map<String,String> parameterValues = new HashMap<String,String>(); 
	
	static{
		String endPointDef = "<endpoint\n";
		endPointDef +="\t\tname=\"endpoint_urn_uuid_";
		endPointDef +=UUID.randomUUID().toString();
		endPointDef +="\">\n\t\t<address uri=\"";
		endPointDef += "http://localhost:9000/services/SimpleStockQuoteService";
		endPointDef +="\" />\n\t\t</endpoint>";
		
		parameterValues.put("ep.name", "{0}");
		parameterValues.put("address.uri", "http://localhost:9000/services/SimpleStockQuoteService");
		parameterValues.put("ep.template", "default1");
		parameterValues.put("ep.uri", "http://localhost:9000/services/SimpleStockQuoteService");
		parameterValues.put("wsdl.uri", "http://localhost:9000/services/SimpleStockQuoteService?wsdl");
		parameterValues.put("service.name", "SimpleStockQuoteService");
		parameterValues.put("service.port", "SimpleStockQuoteServiceHttpSoap11Endpoint");
		parameterValues.put("proxy.name", "{0}");
		parameterValues.put("endpoint.key.def", "");
		parameterValues.put("endpoint.def", endPointDef);
		parameterValues.put("xslt.key", "/key/default");
		parameterValues.put("wsdl.service", "SimpleStockQuoteService");
		parameterValues.put("wsdl.port", "SimpleStockQuoteServiceHttpSoap11Endpoint");
		parameterValues.put("wsdl.url", "http://localhost:9000/services/SimpleStockQuoteService?wsdl");
		parameterValues.put("0", "{0}");
		parameterValues.put("reqloglevel", "info");
		parameterValues.put("resloglevel", "info");
		parameterValues.put("sec.policy", "/key/default");
		parameterValues.put("xsltres.key.def", "");
	}

	/**
	 * Strip Parameters from template content and replace with sample values 
	 * @param content
	 * @param name
	 * @return
	 */
	public static String stripParameters(String content,String name){
		List<String> parameters = getParameters(content);
		for (String parameter : parameters) {
			String searchString = "{" + parameter + "}";
			if(parameterValues.containsKey(parameter)){
				String value = parameterValues.get(parameter);
				if(value.equals("{0}")){
					content = StringUtils.replace(content, searchString, name.replaceAll(".xml$",""));
				} else{
					content = StringUtils.replace(content, searchString, value);
				}
			} else{
				content = StringUtils.replace(content, searchString, "default");
			}
		}
		return content;
	}
	
	private static List<String> getParameters(String content) {
		ArrayList<String> parameters = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\{(.*?)\\}");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			parameters.add(matcher.group(1));
		}
		return parameters;
	}
}
