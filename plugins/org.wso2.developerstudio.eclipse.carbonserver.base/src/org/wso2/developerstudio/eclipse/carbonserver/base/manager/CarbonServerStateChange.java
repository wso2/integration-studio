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

package org.wso2.developerstudio.eclipse.carbonserver.base.manager;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.wst.server.core.IServer;

public class CarbonServerStateChange implements IRunnableWithProgress {
	IServer server;
	int stateChangeFrom = -1;
	int stateChangeTo = -1;
	int timeOut = 300000;
	int delay = 100;
	String msg;

	public CarbonServerStateChange(IServer server, int stateChangeFrom, int stateChangeTo, int timeOut, String msg) {
		this.server = server;
		this.stateChangeFrom = stateChangeFrom;
		this.stateChangeTo = stateChangeTo;
		if (timeOut <= 1)
			timeOut = 60000;
		this.timeOut = timeOut;
		this.msg = msg;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		monitor.beginTask(msg, IProgressMonitor.UNKNOWN);
		int startTime = 0;
		if (stateChangeFrom != -1) {
			while (!monitor.isCanceled() && startTime < timeOut) {
				Thread.sleep(delay);
				startTime = startTime + delay;
				// monitor.worked(Math.round(100*startTime/timeOut));
				if (server.getServerState() != stateChangeFrom)
					break;
			}
		}
		if (stateChangeTo != -1) {
			while (!monitor.isCanceled() && startTime < timeOut) {
				Thread.sleep(delay);
				startTime = startTime + delay;
				if (server.getServerState() == stateChangeTo)
					break;
			}
		}
		monitor.done();
	}

}
