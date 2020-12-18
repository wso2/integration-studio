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

package org.wso2.integrationstudio.logging.core;

import java.util.HashMap;
import java.util.Map;

import org.wso2.integrationstudio.logging.internal.impl.IntegrationStudioLog;

public class Logger {
	private static Map<String,IIntegrationStudioLog> pluginLogs;
	private static Map<Class<Object>,IIntegrationStudioLog> classLogs;
	
	public static IIntegrationStudioLog getLog(String pluginId){
		return getPluginLog(pluginId);
	}

	public static IIntegrationStudioLog getLog(String pluginId, Class<Object> classObj){
		return getClassLog(pluginId, classObj);
	}

	public static Map<String,IIntegrationStudioLog> getPluginLogs() {
		if (pluginLogs==null){
			pluginLogs=new HashMap<String, IIntegrationStudioLog>();
		}
	    return pluginLogs;
    }

	public static Map<Class<Object>,IIntegrationStudioLog> getClassLogs() {
		if (classLogs==null){
			classLogs=new HashMap<Class<Object>, IIntegrationStudioLog>();
		}
	    return classLogs;
    }
	
	private static IIntegrationStudioLog getPluginLog(String pluginId){
		if (!getPluginLogs().containsKey(pluginId)){
			getPluginLogs().put(pluginId, new IntegrationStudioLog(pluginId));
		}
		return getPluginLogs().get(pluginId);
	}
	
	private static IIntegrationStudioLog getClassLog(String pluginId, Class<Object> classObj){
		if (!getClassLogs().containsKey(classObj)){
			getClassLogs().put(classObj, new IntegrationStudioLog(pluginId,classObj));
		}
		return getClassLogs().get(classObj);
	}
}
