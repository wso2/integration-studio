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

package org.wso2.developerstudio.eclipse.distributionproject.module.factory;

import org.eclipse.core.resources.IProject;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.model.ModuleArtifactAdapterDelegate;
import org.wso2.developerstudio.eclipse.distributionproject.module.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CarbonModuleArtifactAdapterImpl extends ModuleArtifactAdapterDelegate {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private static CarbonModuleFactory factory;
	
	public IModuleArtifact getModuleArtifact(Object selection) {
		try {
	        if (selection instanceof IProject){
	        	return CarbonModuleArtifactAdapterUtil.getModuleObject(selection);
	        }
        } catch (Exception e) {
        	log.error(e);
        }
		return null;
	}
	
	public static CarbonModuleFactory getFactory() {
		if (factory==null){
			factory = new CarbonModuleFactory();
			factory.initialize();
		}
	    return factory;
    }
}
