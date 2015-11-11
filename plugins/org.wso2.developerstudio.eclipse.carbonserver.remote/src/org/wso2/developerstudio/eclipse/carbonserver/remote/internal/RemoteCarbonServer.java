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

package org.wso2.developerstudio.eclipse.carbonserver.remote.internal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.model.ServerDelegate;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerUtils;

public class RemoteCarbonServer extends ServerDelegate {
	public IStatus canModifyModules(IModule[] arg0, IModule[] arg1) {
		return Status.OK_STATUS;
	}

	public IModule[] getChildModules(IModule[] module) {
		return new IModule[0];
	}

	public IModule[] getRootModules(IModule module) throws CoreException {
		return new IModule[] { module };
	}

	@SuppressWarnings("unchecked")
	public void modifyModules(IModule[] add, IModule[] remove, IProgressMonitor monitor) throws CoreException {
		String CONST_MODULE_LIST = "RCS_MODULES_LIST";
		List<String> modules = (List<String>) this.getAttribute(CONST_MODULE_LIST, (List<String>) null);

		if (add != null && add.length > 0) {
			if (modules == null) {
				modules = new ArrayList<String>(add.length);
			}
			for (int i = 0; i < add.length; i++) {

				if (modules.contains(add[i].getId()) == false)
					modules.add(add[i].getId());
			}
		}
		if (remove != null && remove.length > 0 && modules != null) {
			for (int i = 0; i < remove.length; i++) {
				modules.remove(remove[i].getId());
			}
		}
		if (modules != null)
			setAttribute(CONST_MODULE_LIST, modules);
	}

	private static final String ATTR_USERNAME = "USERNAME";
	private static final String ATTR_PASSWORD = "PASSWORD";
	private static final String ATTR_URL = "SERVER_URL";

	public String getUsername() {
		return getAttribute(ATTR_USERNAME, "admin");
	}

	public String getPassword() {
		return getAttribute(ATTR_PASSWORD, "admin");
	}

	public URL getServerURL() {
		String urlAttr = getAttribute(ATTR_URL, "");
		try {
			URL url = new URL(urlAttr);
			return url;
		} catch (Exception e) {
			return null;
		}
	}

	public void setUsername(String username) {
		setAttribute(ATTR_USERNAME, username);
	}

	public void setPassword(String password) {
		setAttribute(ATTR_PASSWORD, password);
	}

	public void setServerURL(String url) throws MalformedURLException {
		setServerURL(new URL(url));
	}

	public void setServicePath(String servicePath) {
		CarbonServerUtils.setRemoteServicePath(servicePath);
	}

	public void setServerURL(URL url) throws MalformedURLException {
		if (url == null) {
			setAttribute(ATTR_URL, "");
		} else {
			if (getServerURL() == null || !getServerURL().toString().equals(url.toString())) {
				String[] paths = url.getPath().split("/");
				String firstPath = "";
				if (paths.length == 2) {
					firstPath = paths[1];
					if (firstPath != null &&
					    (firstPath.equalsIgnoreCase("carbon") || firstPath.equalsIgnoreCase("registry") || firstPath.equalsIgnoreCase("services"))) {
						firstPath = "";
					}
				} else {
					firstPath = url.getPath();
				}
				if (firstPath.startsWith("/")) {
					firstPath = firstPath.substring(1, firstPath.length());
				}
				URL serverURL = new URL(url.getProtocol(), url.getHost(), url.getPort(), "/" + firstPath);
				setAttribute(ATTR_URL, serverURL.toString());
				RemoteCarbonServerBehavior rcsb =
				                                  (RemoteCarbonServerBehavior) getServer().loadAdapter(RemoteCarbonServerBehavior.class,
				                                                                                       null);
				if (rcsb != null) {
					rcsb.stopPingThread();
					rcsb.startPingThread();
				}

			}

		}
	}

}
