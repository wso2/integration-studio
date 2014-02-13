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

package org.wso2.developerstudio.eclipse.utils.wst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.SAXException;

public class Axis2ServiceUtils {
	public static Map<IFolder,IProject> getServiceFolders() throws CoreException{
		HashMap<IFolder, IProject> map = new HashMap<IFolder, IProject>();
		for(IProject project:ResourcesPlugin.getWorkspace().getRoot().getProjects()){
			if (WebUtils.isDynamicWebProject(project)){
				final IFolder servicesFolder;
                try {
	                servicesFolder = WebUtils.getAxis2WebContainerWEB_INFServicesFolderPath(project);
                } catch (Exception e1) {
                	//some error occured meaning that this isn't a project type we are looking for
	                continue;
                }
				final List<IFolder> folders=new ArrayList<IFolder>();
				try {
	                if (servicesFolder.exists()) {
	                    servicesFolder.accept(new IResourceVisitor() {
		                    public boolean visit(IResource resource) throws CoreException {
			                    if (resource.getLocation().toOSString()
			                            .equals(servicesFolder.getLocation().toOSString())) {
				                    return true;
			                    } else {
				                    if (resource instanceof IFolder) {
					                    folders.add((IFolder) resource);
				                    }
			                    }
			                    return false;
		                    }

	                    });
                    }
                } catch (CoreException e) {
	                throw e;
                }
                for (IFolder folder : folders) {
	                map.put(folder, project);
                }
			}
		}
		return map;
	}
	public static String getServiceNameFromFolder(String folderPath) throws Exception{
		String serviceName=null;
		String path=FileUtils.addNodesToPath(folderPath, new String[]{"META-INF","services.xml"});
		try {
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parser.parse(new FileInputStream(new File(path)));
		    serviceName = getServiceNameFromDoc(document);
		} catch (Exception e) {
			throw e;
		}
		return serviceName;
	}
	
	public static String getServiceNameFromFile(String filePath) throws Exception{
		String serviceName=null;
		try {
    		ZipFile zf = new ZipFile(filePath);
    		InputStream in = zf.getInputStream(new ZipEntry("META-INF/services.xml"));
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parser.parse(in);
		    serviceName = getServiceNameFromDoc(document);
		    in.close();
		    zf.close();
		} catch (Exception e) {
			throw e;
		}
		return serviceName;
	}
	public static String getServiceClassNameFromFolder(String folderPath) throws Exception{
		String serviceName=null;
		String path=FileUtils.addNodesToPath(folderPath, new String[]{"META-INF","services.xml"});
		try {
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parser.parse(new FileInputStream(new File(path)));
		    serviceName = getServiceClassNameFromDoc(document);
		} catch (Exception e) {
			throw e;
		}
		return serviceName;
	}
	
	public static String getServiceClassNameFromFile(String filePath) throws Exception{
		String serviceName=null;
		try {
    		ZipFile zf = new ZipFile(filePath);
    		InputStream in = zf.getInputStream(new ZipEntry("META-INF/services.xml"));
			serviceName = getServiceClassNameFromServicesXMLStream(in);
			in.close();
			zf.close();
		} catch (Exception e) {
			throw e;
		}
		return serviceName;
	}
	
	public static String getServiceClassNameFromServicesXML(File servicesXml) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException{
		return getServiceClassNameFromServicesXMLStream(new FileInputStream(servicesXml));
	}
			
	public static String getServiceClassNameFromServicesXMLStream(
			InputStream in) throws ParserConfigurationException, SAXException,
			IOException {
		String serviceName;
		DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = parser.parse(in);
		serviceName = getServiceClassNameFromDoc(document);
		return serviceName;
	}
	private static String getServiceNameFromDoc(Document document) {
	    String serviceName;
	    serviceName = document.getDocumentElement().getAttribute("name");
	    if (serviceName==null || serviceName.equals("")){
	    	NodeList nodes = document.getDocumentElement().getElementsByTagName("service");
	    	if(nodes.getLength() != 0){
	    		serviceName=nodes.item(0).getAttributes().getNamedItem("name").getNodeValue();
	    	}
	    }
	    if(serviceName==null || serviceName.equals("")){
	    	String serviceClassName = getServiceClassNameFromDoc(document);
	    	String[] split = serviceClassName.split(".");
	    	serviceName=split[split.length-1];
	    }
	    return serviceName;
    }
	
	private static String getServiceClassNameFromDoc(Document document) {
	    String serviceClassName = null;
		NodeList serviceChildNodes = null;
	    if (document.getDocumentElement().getNodeName().equals("service")){
	    	serviceChildNodes=document.getDocumentElement().getChildNodes();
	    }else{
	    	NodeList childNodes = document.getDocumentElement().getChildNodes();
	    	for(int i = 0; i< childNodes.getLength(); i++){
	    		if(childNodes.item(i).getNodeName().equals("service")){
	    			serviceChildNodes = childNodes.item(i).getChildNodes();
	    			break;
	    		}
	    	}
	    }
    	if (serviceChildNodes!=null){
        	for(int j =0 ; j < serviceChildNodes.getLength(); j++){
    			Node node = serviceChildNodes.item(j);
				if(node.getAttributes() != null){
					if (node.getNodeName().equalsIgnoreCase("parameter")){
        				Node attribute = node.getAttributes().getNamedItem("name");
    					if(attribute!=null && attribute.getNodeValue().equals("ServiceClass")){
        					serviceClassName = node.getTextContent();
        					break;
        				}
					}
    			}
    			
    		}
    	}
	    return serviceClassName;
    }

}
