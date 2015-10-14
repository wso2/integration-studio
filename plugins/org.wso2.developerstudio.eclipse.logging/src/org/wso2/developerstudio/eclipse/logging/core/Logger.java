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

package org.wso2.developerstudio.eclipse.logging.core;

import java.util.HashMap;
import java.util.Map;

import org.wso2.developerstudio.eclipse.logging.internal.impl.DeveloperStudioLog;

public class Logger {
	private static Map<String,IDeveloperStudioLog> pluginLogs;
	private static Map<Class<Object>,IDeveloperStudioLog> classLogs;
	
	public static IDeveloperStudioLog getLog(String pluginId){
		return getPluginLog(pluginId);
	}

	public static IDeveloperStudioLog getLog(String pluginId, Class<Object> classObj){
		return getClassLog(pluginId, classObj);
	}

	public static Map<String,IDeveloperStudioLog> getPluginLogs() {
		if (pluginLogs==null){
			pluginLogs=new HashMap<String, IDeveloperStudioLog>();
		}
	    return pluginLogs;
    }

	public static Map<Class<Object>,IDeveloperStudioLog> getClassLogs() {
		if (classLogs==null){
			classLogs=new HashMap<Class<Object>, IDeveloperStudioLog>();
		}
	    return classLogs;
    }
	
	private static IDeveloperStudioLog getPluginLog(String pluginId){
		if (!getPluginLogs().containsKey(pluginId)){
			getPluginLogs().put(pluginId, new DeveloperStudioLog(pluginId));
		}
		return getPluginLogs().get(pluginId);
	}
	
	private static IDeveloperStudioLog getClassLog(String pluginId, Class<Object> classObj){
		if (!getClassLogs().containsKey(classObj)){
			getClassLogs().put(classObj, new DeveloperStudioLog(pluginId,classObj));
		}
		return getClassLogs().get(classObj);
	}
}
