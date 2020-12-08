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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
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
	
	/**
     * Validate the project name of the Docker project.
     * 
     * @param projectName name of the project
     * @return invalidReason as a string
     */
	public static String validateProjectName(String projectName) {
	    String invalidReason = null;
        if (projectName == null) {
            invalidReason = "Project name cannot be null";
        } else if (projectName.trim().equals("")) {
            invalidReason = "Project name cannot be empty";
        } else if (projectName.indexOf(32) != -1) {
            invalidReason = "Project name cannot contain spaces";
        } else if (!isValidArtifactName(projectName)) {
            invalidReason =  "Project name cannot contain invalid characters(^/ : ; * # $ ? \" <> + $)";
        } else {
            IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
            if (project.exists()) {
                invalidReason = "Project with the name '" + projectName + "' already exists";
            }
        }
        return invalidReason;
    }

	public static String validateProjectName(String projectName, String moduleName) {
		String invalidReason = null;
		if (projectName == null) {
			invalidReason = moduleName + " name cannot be null";
		} else if (projectName.trim().equals("")) {
			invalidReason = moduleName + " name cannot be empty";
		} else if (projectName.indexOf(32) != -1) {
			invalidReason = moduleName + " name cannot contain spaces";
		} else if (!isValidArtifactName(projectName)) {
			invalidReason = moduleName + " name cannot contain invalid characters(^/ : ; * # $ ? \" <> + $)";
		} else {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (project.exists()) {
				invalidReason = moduleName + " with the name '" + projectName + "' already exists";
			}
		}
		return invalidReason;
	}
    
    /**
     * Check the name is a valid artifact or not.
     * 
     * @param name name of the project
     * @return isValid or not
     */
	public static boolean isValidArtifactName(String name) {
        Pattern pattern = Pattern.compile("^[^/\\ \\\\:@%\\^+;,=\\[\\{\\]\\}*#\\$?\"<>|\\(\\)]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
