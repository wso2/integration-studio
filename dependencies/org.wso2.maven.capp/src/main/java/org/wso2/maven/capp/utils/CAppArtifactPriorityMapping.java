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

package org.wso2.maven.capp.utils;

import java.util.HashMap;
import java.util.Map;

public class CAppArtifactPriorityMapping {

	private static Map<String, Integer> priority = new HashMap<String, Integer>();

	public static final int DEFAULT_PRIORITY = 5;

	static {
		// Registry resources get highest priority.
		priority.put("registry/resource", 1);

		// Local entries get second priority.
		priority.put("synapse/local-entry", 2);

		// Custom mediators get third priority.
		priority.put("lib/synapse/mediator", 3);

		// Message stores get fourth priority.
		priority.put("synapse/message-store", 4);

		// Equal priority.
		priority.put("jaggery/app", 5);
		priority.put("bpel/workflow", 5);
		priority.put("lib/registry/filter", 5);
		priority.put("webapp/jaxws", 5);
		priority.put("lib/library/bundle", 5);
		priority.put("service/dataservice", 5);
		priority.put("cep/bucket", 5);
		priority.put("synapse/proxy-service", 5);
		priority.put("carbon/application", 5);
		priority.put("lib/dataservice/validator", 5);
		priority.put("synapse/endpoint", 5);
		priority.put("web/application", 5);
		priority.put("lib/carbon/ui", 5);
		priority.put("service/axis2", 5);
		priority.put("synapse/sequence", 5);
		priority.put("synapse/configuration", 5);
		priority.put("synapse/api", 5);
		priority.put("synapse/template", 5);
		priority.put("synapse/sequenceTemplate", 5);
		priority.put("synapse/endpointTemplate", 5);
		priority.put("synapse/event-source", 5);
		priority.put("synapse/message-processors", 5);
		priority.put("synapse/priority-executor", 5);
		priority.put("wso2/gadget", 5);
		priority.put("lib/registry/handlers", 5);
		priority.put("service/rule", 5);
		priority.put("service/meta", 5);
		priority.put("jaggery/app", 5);

		// Tasks get least priority.
		priority.put("synapse/task", 6);
	}

	private CAppArtifactPriorityMapping() {

	}

	public static boolean isValidArtifactType(final String type) {
		return priority.containsKey(type);
	}

	public static int getPriority(String type) {
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
