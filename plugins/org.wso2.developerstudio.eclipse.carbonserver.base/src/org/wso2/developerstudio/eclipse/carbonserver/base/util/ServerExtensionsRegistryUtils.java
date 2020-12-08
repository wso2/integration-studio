/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.IConfigurationElement;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

public class ServerExtensionsRegistryUtils {
	
	private static final String ORG_WSO2_DEVELOPERSTUDIO_CARBON_PRODUCT_SERVER_REGISTRY = "org.wso2.developerstudio.carbon.product.server.registry";
	private static final String ENCODING_UTF8 = "UTF-8";
	
	public InputStream generateInputStream(String displayName, Bundle bundle, String streamLoc)
			throws IOException, UnsupportedEncodingException {
		InputStream inputStream = bundle.getEntry(streamLoc).openStream();
		String inputString = IOUtils.toString(inputStream, ENCODING_UTF8);
		inputString = inputString.replace("\"descr\"", "\"" + displayName + "\"").replace("\"name\"", "\"" + displayName + "\"");
		return new ByteArrayInputStream(inputString.getBytes(ENCODING_UTF8));
	}
	
	public IConfigurationElement[] retrieveRegisteredProductServers() {
		DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
		return devStudioUtils
				.getExtensionPointmembers(ORG_WSO2_DEVELOPERSTUDIO_CARBON_PRODUCT_SERVER_REGISTRY);
	}
	
}
