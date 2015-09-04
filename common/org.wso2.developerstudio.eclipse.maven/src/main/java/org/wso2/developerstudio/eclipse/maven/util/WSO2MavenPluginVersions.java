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

package org.wso2.developerstudio.eclipse.maven.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This class maintains all the WSO2 developer studio related
 * maven plugins and their versions.  
 */
public class WSO2MavenPluginVersions {
	
	private static final Map<String, String> PLUGIN_VERSIONS = new HashMap<String, String>();
	
	static {
		PLUGIN_VERSIONS.put("maven-axis2-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-bpel-plugin", "2.1.0");

		PLUGIN_VERSIONS.put("maven-carbon-ui-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-cep-plugin", "1.1.0");
		PLUGIN_VERSIONS.put("maven-dataservice-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-ds-validator-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-endpoint-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-gadget-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-inboundendpoint-plugin", "1.0.0");
		PLUGIN_VERSIONS.put("maven-jaxws-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-library-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-localentry-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-proxy-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-registry-filter-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-registry-handler-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-registry-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-sequence-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-stratos-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-synapse-mediator-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-synapse-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("maven-war-plugin", "2.1.0");

		PLUGIN_VERSIONS.put("wso2-esb-api-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-endpoint-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-inboundendpoint-plugin", "1.0.0");
		PLUGIN_VERSIONS.put("wso2-esb-localentry-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-proxy-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-sequence-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-synapse-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-task-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-template-plugin", "2.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-messageprocessor-plugin", "1.1.0");
		PLUGIN_VERSIONS.put("wso2-esb-messagestore-plugin", "1.1.0");

		PLUGIN_VERSIONS.put("wso2-general-project-plugin", "2.1.0");

		PLUGIN_VERSIONS.put("maven-qos-plugin", "1.1.0");

		PLUGIN_VERSIONS.put("maven-car-deploy-plugin", "1.1.0");
		PLUGIN_VERSIONS.put("maven-car-plugin", "2.1.0");
	}
	
	private WSO2MavenPluginVersions(){
		
	}
	
	public static String getPluginVersion(String artifactID) {
		return PLUGIN_VERSIONS.get(artifactID);
	}

}
