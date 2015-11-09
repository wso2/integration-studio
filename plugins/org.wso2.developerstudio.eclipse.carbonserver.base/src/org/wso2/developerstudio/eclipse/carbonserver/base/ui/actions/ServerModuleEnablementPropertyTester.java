/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.ui.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.ui.IServerModule;

/**
 * This class is used to test the property to enable the Redeploy option for
 * 
 * Carbon Server modules.
 * 
 */
public class ServerModuleEnablementPropertyTester extends PropertyTester {

	private static final String WSO2_CARBON_MODULE = "org.wso2.developerstudio.eclipse.carbon.module";

	public boolean test(Object arg0, String arg1, Object[] arg2, Object arg3) {

		if (arg0 instanceof IServerModule) {
			IModule[] modules = (IModule[]) ((IServerModule) arg0).getModule();
			for (IModule iModule : modules) {
				String moduleType = iModule.getModuleType().getId();
				if (WSO2_CARBON_MODULE.equals(moduleType) &&
				    ((IServerModule) arg0).getServer().getServerState() == IServer.STATE_STARTED) {
					return true;
				}
			}
		}
		return false;
	}

}
