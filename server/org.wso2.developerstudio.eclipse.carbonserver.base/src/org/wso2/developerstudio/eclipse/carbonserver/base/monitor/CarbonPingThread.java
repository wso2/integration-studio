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

package org.wso2.developerstudio.eclipse.carbonserver.base.monitor;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.jst.server.generic.core.internal.GenericServerBehaviour;
import org.eclipse.jst.server.generic.core.internal.PingThread;
import org.eclipse.jst.server.generic.core.internal.Trace;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.internal.Server;
import org.eclipse.wst.server.core.util.SocketUtil;
import org.wso2.developerstudio.eclipse.carbonserver.base.impl.CarbonServerBehaviour;

public class CarbonPingThread extends PingThread {
	private static final int PING_DELAY = 10000;

	// delay between pings
	private static final int PING_INTERVAL = 250;

	// maximum number of pings before giving up
	private int maxPings = 56; // total: 16 seconds + connection time

	private boolean stop;
	private String[] fUrl;
	private IServer fServer;
	private CarbonServerBehaviour fGenericServer;
	
	public CarbonPingThread(IServer server, String[] url,
			CarbonServerBehaviour genericServer) {
		super(server, url[0], genericServer);
		this.fServer = server;
		this.fUrl = url;
		this.maxPings = guessMaxPings(genericServer);
		this.fGenericServer = genericServer;
		Thread t = new Thread() {
			public void run() {
				ping();
			}
		};
		t.setDaemon(true);
		t.start();
	}
	
	@SuppressWarnings("restriction")
	private int guessMaxPings(GenericServerBehaviour server)
    {
    	int maxpings=-1;
    	int startTimeout = ((Server)server.getServer()).getStartTimeout() * 1000;
    	if(startTimeout>0)
    		maxpings=startTimeout/PING_INTERVAL;
    	return maxpings;
    }
	
	private boolean isRemote(){
		return (fServer.getServerType().supportsRemoteHosts()&& !SocketUtil.isLocalhost(fServer.getHost()) );
	}
	
	
	@SuppressWarnings("restriction")
	protected void ping() {
		int count = 0;
		try {
			Thread.sleep(PING_DELAY);
		} catch (Exception e) {
			// ignore
		}
		while (!stop) {
			try {
				if (count == maxPings && !isRemote()) {
					try {
						//fGenericServer.revertServerXmlSettings();
						fServer.stop(false);
					} catch (Exception e) {
						Trace.trace(Trace.FINEST, "Ping: could not stop server"); //$NON-NLS-1$
					}
					stop = true;
					break;
				}
				if(!isRemote()){
					count++;
				}
				
				Trace.trace(Trace.FINEST, "Ping: pinging"); //$NON-NLS-1$
				for (String url : fUrl) {
					URL pingUrl = new URL(url);
					URLConnection conn = pingUrl.openConnection();
					
					int responseCode;
                    try {
	                    responseCode = ((HttpURLConnection)conn).getResponseCode();
                    } catch (Exception e) {
                    	((HttpURLConnection)conn).disconnect();
						Thread.sleep(PING_DELAY);
	                    continue;
                    }
					if (responseCode!=200 && responseCode!=302){
						//throw new Exception("WSAS Server still starting up");
						Thread.sleep(PING_DELAY);
						continue;
					}
					// ping worked - server is up
					if (!stop) {
						Trace.trace(Trace.FINEST, "Ping: success"); //$NON-NLS-1$
						Thread.sleep(PING_DELAY);
						fGenericServer.setServerStarted();
					}
					if(!isRemote()){
						stop = true;
					}
                }
			} catch (FileNotFoundException fe) {
				try {
					Thread.sleep(PING_INTERVAL);
				} catch (Exception e) {
					// ignore
				}
				fGenericServer.setServerStarted();
				if(!isRemote()){
					stop = true;
				}
			} catch (Exception e) {
				Trace.trace(Trace.FINEST, "Ping: failed: "+ e); //$NON-NLS-1$
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
	}
	
	/**
	 * Tell the pinging to stop.
	 */
	@SuppressWarnings("restriction")
	public void stop() {
		Trace.trace(Trace.FINEST, "Ping: stopping"); //$NON-NLS-1$
		stop = true;
	}
}
