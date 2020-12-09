/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.bpel.connector.utils;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.developerstudio.eclipse.bpel.core.handler.IBPELHandler;
import org.eclipse.developerstudio.eclipse.bpel.core.handler.IBPELHandlerRequester;
import org.wso2.developerstudio.eclipse.bpel.connector.handler.BPELHandler;

public class BPELExtensionPointHandler {
	private static final String BPEL_HANDLER_REQUESTER_EXTENSION="org.wso2.developerstudio.eclipse.bpel.connector";
	
	public static void setBPELArtifactHandlers(List<IBPELHandler> bpelHandlers){
		bpelHandlers.clear();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(BPEL_HANDLER_REQUESTER_EXTENSION);
		for (IConfigurationElement e : config) {		
			try {
				IBPELHandlerRequester hadlerReq = (IBPELHandlerRequester)e.createExecutableExtension("class");
				hadlerReq.setBPELHandler(new BPELHandler());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
