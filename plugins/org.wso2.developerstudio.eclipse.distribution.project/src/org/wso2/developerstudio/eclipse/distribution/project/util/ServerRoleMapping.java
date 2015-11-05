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

public class ServerRoleMapping {
	private static final String SERVER_ROLE = "serverRole";
	private static final String ARTIFACT_TYPE = "artifactType";
	private static final String REGISTER_SERVER_ROLE_EXTENSION_ID = "org.wso2.developerstudio.register.server.role";
	// this should also be taken via an extension point
	private static Map<String, String> serverRole = new HashMap<String, String>();

	public ServerRoleMapping() {
		DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
		IConfigurationElement[] confElems = devStudioUtils
				.getExtensionPointmembers(REGISTER_SERVER_ROLE_EXTENSION_ID);

		for (IConfigurationElement elem : confElems) {
			serverRole.put(elem.getAttribute(ARTIFACT_TYPE),
					elem.getAttribute(SERVER_ROLE));
		}
	}

	public String getServerRole(String packaging) {
		String value = "";
		if (serverRole.containsKey(packaging)) {
			value = serverRole.get(packaging);
		}
		return value;
	}

}
