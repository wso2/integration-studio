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

package org.wso2.developerstudio.eclipse.carbonserver.base.impl;

import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerMonitor;

public class CarbonServerMonitorAdapter implements ICarbonServerMonitor {

	public void beforePublishing(IServer server, IModule[] modules, Object data) {
	}

	public void beforeRestart(IServer server) {
	}

	public void beforeStart(IServer server) {
	}

	public void beforeStop(IServer server) {
	}

	public void published(IServer server, IModule[] modules, Object data) {
	}

	public void publishing(IServer server, IModule[] modules, Object data) {
	}

	public void restarted(IServer server) {
	}

	public void restarting(IServer server) {
	}

	public void started(IServer server) {
	}

	public void starting(IServer server) {
	}

	public void stopped(IServer server) {
	}

	public void stopping(IServer server) {
	}

	public void serverRecognized(IServer server) {
	}

}
