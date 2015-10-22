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

package org.wso2.developerstudio.eclipse.platform.core.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

public class Validator {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static KeyStore cacerts = null;

	private static boolean isCertValid(X509Certificate certificate) {
		try {
			X509Certificate receivedCert = certificate;
			if (cacerts == null) {
				String cacertsPath = null;
				InputStream cacertsIs = null;
				cacertsPath = System.getProperty("java.home") + "/lib/security/cacerts";
				cacertsIs = new FileInputStream(cacertsPath);
				cacerts = KeyStore.getInstance(KeyStore.getDefaultType());
				cacerts.load(cacertsIs, "changeit".toCharArray());
				cacertsIs.close();
			}

			Principal issuer = null;
			Enumeration<String> aliasEnum = null;

			issuer = receivedCert.getIssuerDN();
			String issuerRDNStr = issuer.getName();
			aliasEnum = cacerts.aliases();

			while (aliasEnum.hasMoreElements()) {
				String alilas = null;

				alilas = (String) aliasEnum.nextElement();
				if (cacerts.isCertificateEntry(alilas)) {
					X509Certificate cert = null;
					cert = (X509Certificate) cacerts.getCertificate(alilas);
					String certRDNStr = cert.getSubjectDN().getName();
					if (issuerRDNStr.equals(certRDNStr)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return false;
	}

	public static boolean isCertChainValid(X509Certificate[] certs) {
		boolean trusted = false;
		for (X509Certificate certificate : certs) {
			trusted = isCertValid(certificate);
			if (trusted)
				break;
		}
		return trusted;
	}
}
