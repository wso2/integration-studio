/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

public class ArtifactPriorityMapping {

	private static final String ARTIFACT_TYPE = "artifactType";
	private static final String PRIORITY2 = "priority";
	private static final String REGISTER_ARTIFACT_PRIORITY_MAPPING_EXTENSION_ID = "org.wso2.developerstudio.register.artifact.priority.mapping";
	private static Map<String, Integer> priority = new HashMap<String, Integer>();
	public static final int DEFAULT_PRIORITY = 5;

	public ArtifactPriorityMapping() {
		DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
		IConfigurationElement[] registeredPriorityMappings = devStudioUtils.getExtensionPointmembers(REGISTER_ARTIFACT_PRIORITY_MAPPING_EXTENSION_ID);
		for (IConfigurationElement priorityMapping : registeredPriorityMappings){
			priority.put(priorityMapping.getAttribute(ARTIFACT_TYPE), Integer.valueOf(priorityMapping.getAttribute(PRIORITY2)));
		}
				
	}

	public static boolean isValidArtifactType(final String type) {
		return priority.containsKey(type);
	}

	public int getPriority(String type) {
		try {
			if (isValidArtifactType(type)) {
				return priority.get(type);
			} else {
				return DEFAULT_PRIORITY;
			}
		} catch (NullPointerException e) {
			// Priority hasn't been defined for the given artifact type.
			return DEFAULT_PRIORITY;
		}
	}

}
