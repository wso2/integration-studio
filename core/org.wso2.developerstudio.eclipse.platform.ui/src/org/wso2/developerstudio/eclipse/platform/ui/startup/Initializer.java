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

package org.wso2.developerstudio.eclipse.platform.ui.startup;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class Initializer {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static void start(){
//		setupCustomTrustManager();
	}
	
//	private static void setupCustomTrustManager(){
//		Display.getDefault().asyncExec(new Runnable(){
////			public void run() {
////				Display.getDefault().timerExec(2000, new Runnable(){
//
//					public void run() {
//						java.security.Security.setProperty("ssl.SocketFactory.provider","abc.DummySSLSocketFactory");
//						
////						EclipseSWTTrustManager.initiate(Display.getDefault().getActiveShell());
//						URL url;
//						try {
//							url = new URL("https://wso2.org");
//							url.openStream();
//						} catch (MalformedURLException e) {
//							// TODO Auto-generated catch block
//							log.error(e);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							log.error(e);
//						}
////						Display.getDefault().timerExec(2000, this);
//					}
//					
////				});				
////			}
//			
//		});
//
//	}
}
