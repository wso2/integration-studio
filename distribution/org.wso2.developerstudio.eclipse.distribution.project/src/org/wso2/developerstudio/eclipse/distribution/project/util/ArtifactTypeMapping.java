/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.util;

import java.util.HashMap;
import java.util.Map;

public final class ArtifactTypeMapping {
	private static Map<String, String> type = new HashMap<String, String>();
	private static Map<String, String> subType = new HashMap<String, String>();
	
	static {
		type.put("jaggery/app","zip");
		type.put("bpel/workflow","zip");
		type.put("lib/registry/filter","jar");
		type.put("webapp/jaxws","war");
		type.put("lib/library/bundle","jar");
		type.put("service/dataservice","dbs");
		type.put("cep/bucket","xml");
		type.put("synapse/local-entry","xml");
		type.put("synapse/proxy-service","xml");
		type.put("carbon/application","car");
		type.put("registry/resource","zip");
		type.put("lib/dataservice/validator","jar");
		type.put("synapse/endpoint","xml");
		type.put("web/application","war");
		type.put("lib/carbon/ui","jar");
		type.put("service/axis2","aar");
		type.put("synapse/sequence","xml");
		type.put("synapse/configuration","xml");
		type.put("synapse/task","xml");
		type.put("synapse/api","xml");
		type.put("synapse/template","xml");
		type.put("synapse/sequenceTemplate","xml");
		type.put("synapse/endpointTemplate","xml");
		type.put("synapse/message-store","xml");
		type.put("synapse/event-source","xml");
		type.put("synapse/message-processors","xml");
		type.put("synapse/priority-executor","xml");
		type.put("wso2/gadget","dar");
		type.put("lib/registry/handlers","jar");
		type.put("lib/synapse/mediator","jar");
		type.put("service/rule", "aar");
		type.put("service/meta","xml");
		type.put("jaggery/app", "zip");
		type.put("synapse/inbound-endpoint", "xml");
		type.put("synapse/lib", "zip");
		
		subType.put("jar","jar");
		subType.put("bundle","jar");
	}
	
	private ArtifactTypeMapping(){
		
	}
	
	public static boolean isValidArtifactType(final String str) {
		return type.containsKey(str);
	}
	
	public static String getType(final String packaging) {
		String value = "";
		if (type.containsKey(packaging)) {
			value = type.get(packaging);
		} else {
			if (subType.containsKey(packaging)) {
				value = subType.get(packaging);
			} else {
				value = packaging.replaceAll("/", "_");
			}
		}
		return value;
	}
	
	public static String getArtifactTypes(){
		StringBuffer artifactTypes = new StringBuffer();
		for(String key: type.keySet()){
			artifactTypes.append(key);
			artifactTypes.append("=");
			artifactTypes.append(type.get(key));
			artifactTypes.append(',');
		}
		return artifactTypes.toString().replaceAll(",$","");
	}
	
}
