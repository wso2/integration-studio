/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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

package org.wso2.developerstudio.eclipse.carbonserver.base.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jst.ws.internal.common.ResourceUtils;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.constant.CarbonConfigurationConstant;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.SAXException;

public class CarbonUtils {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static String getHostName() {
		String hostName = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			log.error(e);
		}
		return hostName;
	}
	
	public static String getIpAddress() {
		String hostAddress = null;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostAddress = addr.getHostAddress();
		} catch (UnknownHostException e) {
			log.error(e);
		}
		return hostAddress;
	}
	
	
	public static String getWSASHTTPSAddress() {
		String  wsasHTTPSAddress = null;
		wsasHTTPSAddress = CarbonConfigurationConstant.HTTPS_PREFIX + 
							getIpAddress()+":"+
							CarbonConfigurationConstant.WSO2WSAS_HTTPS_PORT;
		return wsasHTTPSAddress;
	}
	
	public static String getWSASHTTPAddress() {
		String  wsasHTTPAddress = null;
		wsasHTTPAddress = CarbonConfigurationConstant.HTTP_PREFIX + 
							getIpAddress()+":"+
							CarbonConfigurationConstant.WSO2WSAS_HTTP_PORT;
		return wsasHTTPAddress;
	}

//	private static Document getXmlDocument(String filename){
//		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder;
//		try {
//			docBuilder = docBuilderFactory.newDocumentBuilder();
//			Document doc = docBuilder.parse (new File(filename));
//			return doc;
//		} catch (ParserConfigurationException e) {
//			return null;
//		} catch (SAXException e) {
//			return null;
//		} catch (IOException e) {
//			return null;
//		}
//	}
	
	public static List getJavaProjectSourceDirectories (IProject project){
			    ArrayList srcPaths = new ArrayList();
			    
			    IJavaProject javaProject;
			    String projectFullPath = project.getFullPath().toOSString();
			    int pathLength = projectFullPath.length();
			    try {
					javaProject = (IJavaProject)project.getNature(JavaCore.NATURE_ID);
					IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
				    for(IClasspathEntry classpathEntry:rawClasspath){
						if (classpathEntry.getEntryKind()==IClasspathEntry.CPE_SOURCE)
				    	srcPaths.add(project.getLocation().append(classpathEntry.getPath().removeFirstSegments(1)).toOSString());
				    }
				} catch (CoreException e) {
				    IPath[] paths = ResourceUtils.getAllJavaSourceLocations(project);
				    for(IPath path:paths){
				    	srcPaths.add(project.getLocation().append(path.removeFirstSegments(1)).toOSString());
				    }		
		 		}
				return srcPaths;
	}
	
}
