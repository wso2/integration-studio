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

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.eclipse.wst.server.core.IServer;

public class CarbonPingThread implements Runnable {
	private static final int PING_DELAY = 2000;

	// delay between pings
	private static final int PING_INTERVAL = 250;

	// maximum number of pings before giving up
	private int maxPings = 56; // total: 16 seconds + connection time

	private boolean stop;
	private URL url;

	private RemoteCarbonServerBehavior serverBehaviour;

	public CarbonPingThread(URL url, RemoteCarbonServerBehavior serverBehaviour) {
		this.url = url;
		this.serverBehaviour = serverBehaviour;

	}

	public void startPing() {
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	private void ping() {
		int count = 0;
		try {
			Thread.sleep(PING_DELAY);
		} catch (Exception e) {
			// ignore
		}
		while (!stop) {
			try {
				if (count == maxPings) {
					try {
						if (serverBehaviour.isServerStarting()) {
							serverBehaviour.setServerStopped();
						}
					} catch (Exception e) {
					}
				} else {
					count++;
				}
				URL pingUrl = url;
				URLConnection conn = pingUrl.openConnection();

				int responseCode;
				try {
					responseCode = ((HttpsURLConnection) conn).getResponseCode();
				} catch (Exception e) {
					((HttpURLConnection) conn).disconnect();
					if (serverBehaviour.isServerStarted()) {
						serverBehaviour.setServerStopped();
					}
					Thread.sleep(2000);
					continue;
				}
				if (responseCode != 200 && responseCode != 302) {
					Thread.sleep(2000);
					if (serverBehaviour.isServerStarted()) {
						serverBehaviour.setServerStopped();
					}
					continue;
				}
				// ping worked - server is up
				if (!stop) {
					Thread.sleep(2000);
					serverBehaviour.setServerStarted();
				}
				// stop = true;
			} catch (FileNotFoundException fe) {
				try {
					Thread.sleep(PING_INTERVAL);
				} catch (Exception e) {
					// ignore
				}
				serverBehaviour.setServerStarted();
				// stop = true;
			} catch (Exception e) {
				// pinging failed
				if (!stop) {
					try {
						Thread.sleep(PING_INTERVAL);
					} catch (InterruptedException e2) {
						// ignore
					}
				}
			}
		}
		if (serverBehaviour.isServerStarting()) {
			serverBehaviour.setServerStopped();
		}
	}

	/**
	 * Tell the pinging to stop.
	 */
	public void stop() {
		stop = true;
	}

	public void run() {
		ping();
	}
}
