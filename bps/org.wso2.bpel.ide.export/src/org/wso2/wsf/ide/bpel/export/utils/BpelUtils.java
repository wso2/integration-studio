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

package org.wso2.wsf.ide.bpel.export.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IProject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.wsf.ide.bpel.export.WSO2BPELPlugin;
import org.xml.sax.SAXException;

public class BpelUtils {
	private static final String DEPLOY_XML = "deploy.xml";
	private static IDeveloperStudioLog log=Logger.getLog(WSO2BPELPlugin.PLUGIN_ID);

	public static boolean isProjectContainsBpel(IProject p) {
		String prjPath = p.getLocation().toOSString();
		File prjFolder = new File(prjPath);
		List fileList = FileManagementUtil
				.getAllFilesPresentInFolder(prjFolder);
		for (int i = 0; i < fileList.size(); i++) {
			if (fileList.get(i).toString().toLowerCase().endsWith(".bpel")) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isProjectContainsDeploymentDescriptor(IProject p) {
		String prjPath = p.getLocation().toOSString();
		File prjFolder = new File(prjPath);
		List fileList = FileManagementUtil
				.getAllFilesPresentInFolder(prjFolder);
		if(fileList != null && fileList.size() != 0){
			for (int i = 0; i < fileList.size(); i++) {
				if (fileList.get(i).toString().endsWith(DEPLOY_XML.toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static List getBpelValidFileList(String relativePath,String[] fileList){
		List list=new ArrayList();
		List existingWSDL=new ArrayList();
		List requiredWsdl=new ArrayList();
		
		List<String> excludeList=new ArrayList<String>();
		excludeList.add("pom.xml");
		excludeList.add("build.xml");
		excludeList.add(".project");
		excludeList.add(".classpath");
		excludeList.add(".svn");
		excludeList.add("target");
		excludeList.add(".settings");
		
		for (int i = 0; i < fileList.length; i++) {
			String filename = fileList[i];
			File file = new File(filename);
			if (!file.isDirectory()){
				try {
	                if ((filename.toLowerCase().endsWith(".bpel"))&&(isValidBPelFile(filename,requiredWsdl))){
	                	list.add(filename);
	                }else if ((filename.toLowerCase().endsWith(".wsdl")) && (isValidWSDLFile(filename))) {
	                	existingWSDL.add(filename);
	                } else if (!excludeList.contains(file.getName()) && !excludeList.contains(file.getParentFile().getName())) {
	                	list.add(filename);
	                }
                } catch (IOException e) {
	                e.printStackTrace();
                }
//                else if ((filename.toLowerCase().endsWith(".xml"))&&(isValidDeployFile(filename)))
//                	list.add(filename);
//                else if (filename.toLowerCase().endsWith(".xsd") && isValidXSDFile(filename)){
//                	list.add(filename);
//                }else if (filename.toLowerCase().endsWith(".xslt") && isValidXSLTFile(filename)){
//                	list.add(filename);
//                } 
			}
		}

		for (Iterator iterator = existingWSDL.iterator(); iterator.hasNext();) {
			String wsdlFileName = (String) iterator.next();
			if (requiredWsdl.contains(wsdlFileName))
				list.add(wsdlFileName);
		}
		return list;
		
	}
	
	public static boolean isValidBPelFile(String filename,List wsdlList) throws IOException{
		Document xmlDocument = getXmlDocument(filename);
		if (xmlDocument==null)
			return false;
		else{
			if (xmlDocument.getDocumentElement().getNodeName().toLowerCase().endsWith("process")){
				NodeList childNodes = xmlDocument.getDocumentElement().getChildNodes();
				for (int i = 0; i < childNodes.getLength(); i++) {
					Node item = childNodes.item(i);
					if (item.getNodeName().toLowerCase().endsWith("import")){
						Node namedItem = item.getAttributes().getNamedItem("location");
						String nodeValue = namedItem.getNodeValue();
						File fileBpel = new File(filename);
						File parentFile = fileBpel.getParentFile();
						File file = new File(parentFile,nodeValue);
						String path = file.getCanonicalPath();
						wsdlList.add(path);
					}
				}
				return true;
			}else
				return false;
		}
	}
	
	
	
	public static boolean isValidDeployFile(String filename){
		Document xmlDocument = getXmlDocument(filename);
		if (xmlDocument==null)
			return false;
		else
			return xmlDocument.getDocumentElement().getNodeName().equalsIgnoreCase("deploy");

	}
	
	public static boolean isValidXSDFile(String fileName){
		return getXmlDocument(fileName)!= null?true:false;
	}
	
	public static boolean isValidXSLTFile(String fileName){
		return getXmlDocument(fileName)!= null?true:false;
	}
	
	private static Document getXmlDocument(String filename){
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(filename));
			return doc;
		} catch (ParserConfigurationException e) {
			return null;
		} catch (SAXException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	public static boolean isValidWSDLFile(String filename){
		return true;
	}
}
