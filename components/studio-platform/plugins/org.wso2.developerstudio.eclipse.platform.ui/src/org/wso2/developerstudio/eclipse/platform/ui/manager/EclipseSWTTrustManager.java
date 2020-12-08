/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.manager;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

public class EclipseSWTTrustManager implements X509TrustManager {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private Shell shell;
	private static boolean initiated = false;

	public EclipseSWTTrustManager() {
	}

	public static void initiate() {
		// if (initiated) return;
		SSLContext sc;
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new EclipseSWTTrustManager() };
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		initiated = true;
	}

	public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {

	}

	public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {

	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Shell getShell() {
		if (shell == null) {
			shell = Display.getDefault().getActiveShell();
		}
		return shell;
	}

}
