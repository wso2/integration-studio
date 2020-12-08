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

package org.wso2.developerstudio.eclipse.capp.core.model;

import java.net.MalformedURLException;
import java.net.URL;

import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RegistryConnection implements IRegistryConnection {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private URL url;
	private String username;
	private String password;
	private String path;
	private String id;
	private String connectionName;
	
	public String getConnectionName() {
    	return connectionName;
    }
	public void setConnectionName(String connectionName) {
    	this.connectionName = connectionName;
    }
	public String getUsername() {
    	return username;
    }
	public void setUsername(String username) {
    	this.username = username;
    }
	public String getPassword() {
    	return password;
    }
	public void setPassword(String password) {
    	this.password = password;
    }
	public String getPath() {
    	return path;
    }
	public void setPath(String path) {
    	this.path = path;
    }
	public void setURL(URL url) {
	    this.url = url;
    }
	public URL getURL() {
	    return url;
    }
	public String getId() {
	    return id;
    }
	public void setId(String id) {
		this.id=id;
    }

	public String getCaption() {
	    try {
	        return getConnectionName() + " - " + new URL(getURL().toString()+getPath()).toString();
        } catch (MalformedURLException e) {
	        log.error(e);
        }
        return getConnectionName() + " - " + getURL().toString();
    }
}
