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

public interface IDeveloperStudioLog {

	public void setPluginId(String pluginId);

	public String getPluginId();

	public void setClassObj(Class<Object> classObj);

	public Class<Object> getClassObj();

	public void info(String message);

	public void info(String message, Exception e);

	public void warn(String message);

	public void warn(String message, Exception e);

	public void error(String message);

	public void error(Exception e);
	
	public void error(String message, Exception e);

	public void error(Throwable e);

	public void error(String message, Throwable e);

	public void info(Throwable e);

	public void info(String message, Throwable e);

	public void warn(Throwable e);

	public void warn(String message, Throwable e);

}