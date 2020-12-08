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

import org.eclipse.core.runtime.IConfigurationElement;
import org.wso2.developerstudio.eclipse.carbonserver.base.util.CarbonUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

public final class ArtifactTypeMapping {
	private static final String ARTIFACT_TYPE = "artifactType";
	private static final String FILE_EXTENSION = "fileExtension";
	private static final String REGISTER_ARTIFACT_MAPPING_EXTENSION_ID = "org.wso2.developerstudio.register.artifact.mapping";
	private static Map<String, String> type = new HashMap<String, String>();
	private static Map<String, String> subType = new HashMap<String, String>();
	
	public ArtifactTypeMapping(){
		DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
		IConfigurationElement[] artifactMappings = devStudioUtils.getExtensionPointmembers(REGISTER_ARTIFACT_MAPPING_EXTENSION_ID);
		for (IConfigurationElement artifactmapping : artifactMappings){
			  type.put(artifactmapping.getAttribute(ARTIFACT_TYPE), artifactmapping.getAttribute(FILE_EXTENSION));
		}
		subType.put("jar","jar");
		subType.put("bundle","jar");
		
	}
	
	public boolean isValidArtifactType(final String str) {
		return type.containsKey(str);
	}
	
	public String getType(final String packaging) {
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
	
	public String getArtifactTypes(){
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
