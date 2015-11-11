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

package org.wso2.developerstudio.eclipse.server.base.interfaces;

import java.net.URL;

public interface IWSO2Server {
	public static final int SERVER_STATE_UNKNOWN = -1;
	public static final int SERVER_STATE_STOPPED = 0;
	public static final int SERVER_STATE_STARTING = 1;
	public static final int SERVER_STATE_STARTED = 2;
	public static final int SERVER_STATE_STOPPING = 3;
	public static final int SERVER_STATE_ERROR = 4;

	public URL getURL();

	public int getState();

	public void startServer();

	public void stopServer(boolean force);
}
