/*
 * Copyright (c) 2010 - 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.Activator;
import org.wso2.developerstudio.eclipse.utils.exception.Axis2ServiceUtilsException;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.SAXException;
import static org.wso2.developerstudio.eclipse.utils.wst.Axis2Constants.*;

/**
 * This class provides static utility methods for Axis2 service project management tasks.
 * Such as Axis2 services.xml file manipulation, data extraction etc.
 */
public class Axis2ServiceUtils {
	private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * This method provides logic for getting all Axis2 service folders with related project in workspace.
	 *
	 * @return a map contains all service folders with corresponding project
	 * @throws org.wso2.developerstudio.eclipse.utils.exception.Axis2ServiceUtilsException
	 */
	public static Map<IFolder, IProject> getServiceFolders() throws Axis2ServiceUtilsException {
		Map<IFolder, IProject> map = new HashMap<IFolder, IProject>();
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (WebUtils.isDynamicWebProject(project)) {
				final IFolder servicesFolder;
				servicesFolder = WebUtils.getAxis2WebContainerWEB_INFServicesFolderPath(project);
				final List<IFolder> folders = new ArrayList<IFolder>();
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
					throw new Axis2ServiceUtilsException("Error in getting service folders for Axis2 projects", e);
				}
				for (IFolder folder : folders) {
					map.put(folder, project);
				}
			}
		}
		return map;
	}

	/**
	 * This method provides logic for getting Axis2 service name from given resources folder
	 *
	 * @param folderPath resources folder path
	 * @return Axis2 service name
	 * @throws org.wso2.developerstudio.eclipse.utils.exception.Axis2ServiceUtilsException
	 */
	public static String getServiceNameFromFolder(String folderPath) throws Axis2ServiceUtilsException {
		String path = FileUtils.addNodesToPath(folderPath, new String[]{META_INF_FOLDER_NAME, SERVICES_XML_FILE_NAME});
		DocumentBuilder documentBuilder = getDocumentBuilder();
		Document document;

		try {
			document = documentBuilder.parse(new FileInputStream(new File(path)));
		} catch (SAXException e) {
			throw new Axis2ServiceUtilsException("Error in parsing services.xml File : " + path + ", to a DOM Document", e);
		} catch (FileNotFoundException e) {
			throw new Axis2ServiceUtilsException("Given services XML file not found to parse as a DOM Document, File path : " + path, e);
		} catch (IOException e) {
			throw new Axis2ServiceUtilsException("IO exception occurred while parsing given XML file as a DOM Document, File path : "
					+ path, e);
		}

		return getServiceNameFromDocument(document);
	}

	/**
	 * This method provides logic for getting Axis2 service name from given zip file path
	 *
	 * @param filePath zip file path
	 * @return Axis2 service name
	 * @throws org.wso2.developerstudio.eclipse.utils.exception.Axis2ServiceUtilsException
	 */
	public static String getServiceNameFromFile(String filePath) throws Axis2ServiceUtilsException {
		ZipFile resourcesZipFile;
		InputStream inputStreamOfZipFile;
		DocumentBuilder documentBuilder = getDocumentBuilder();
		Document document;

		try {
			resourcesZipFile = new ZipFile(filePath);
			inputStreamOfZipFile = resourcesZipFile.getInputStream(new ZipEntry
					(META_INF_FOLDER_NAME + File.separator + SERVICES_XML_FILE_NAME));
		} catch (IOException e) {
			throw new Axis2ServiceUtilsException("Unable to create an input stream for given zip file, ZIP file path : " + filePath, e);
		}

		try {
			document = documentBuilder.parse(inputStreamOfZipFile);
		} catch (SAXException e) {
			throw new Axis2ServiceUtilsException("Error in parsing services.xml File : " + filePath + ", to a DOM Document", e);
		} catch (IOException e) {
			throw new Axis2ServiceUtilsException("IO exception occurred while parsing given XML file as a DOM Document, File path : "
					+ filePath, e);
		} finally {
			try {
				inputStreamOfZipFile.close();
				resourcesZipFile.close();
			} catch (IOException e) {
				log.error("Error in closing zip file and input stream, ZIP file : " + filePath, e);
			}
		}

		return getServiceNameFromDocument(document);
	}

	/**
	 * This method provides logic for getting Axis2 service class name from given resources folder
	 *
	 * @param folderPath resources folder path
	 * @return Axis2 service class name
	 * @throws org.wso2.developerstudio.eclipse.utils.exception.Axis2ServiceUtilsException
	 */
	public static String getServiceClassNameFromFolder(String folderPath) throws Axis2ServiceUtilsException {
		String path = FileUtils.addNodesToPath(folderPath, new String[]{META_INF_FOLDER_NAME, SERVICES_XML_FILE_NAME});
		DocumentBuilder documentBuilder = getDocumentBuilder();
		Document document;

		try {
			document = documentBuilder.parse(new FileInputStream(new File(path)));
		} catch (SAXException e) {
			throw new Axis2ServiceUtilsException("Error in parsing services.xml File : " + path + ", to a DOM Document", e);
		} catch (FileNotFoundException e) {
			throw new Axis2ServiceUtilsException("Given services XML file not found to parse as a DOM Document, File path : " + path, e);
		} catch (IOException e) {
			throw new Axis2ServiceUtilsException("IO exception occurred while parsing given XML file as a DOM Document, File path : "
					+ path, e);
		}

		return getServiceClassNameFromDocument(document);
	}

	/**
	 * This method provides logic for getting Axis2 service class name from given zip file path
	 *
	 * @param filePath zip file path
	 * @return Axis2 service class name
	 * @throws org.wso2.developerstudio.eclipse.utils.exception.Axis2ServiceUtilsException
	 */
	public static String getServiceClassNameFromFile(String filePath) throws Axis2ServiceUtilsException {
		ZipFile resourcesZipFile;
		InputStream inputStreamOfZipFile;
		DocumentBuilder documentBuilder = getDocumentBuilder();
		Document document;

		try {
			resourcesZipFile = new ZipFile(filePath);
			inputStreamOfZipFile = resourcesZipFile.getInputStream(new ZipEntry
					(META_INF_FOLDER_NAME + File.separator + SERVICES_XML_FILE_NAME));
		} catch (IOException e) {
			throw new Axis2ServiceUtilsException("Unable to create an input stream for given zip file, ZIP file path : " + filePath, e);
		}

		try {
			document = documentBuilder.parse(inputStreamOfZipFile);
		} catch (SAXException e) {
			throw new Axis2ServiceUtilsException("Error in parsing services.xml File : " + filePath + ", to a DOM Document", e);
		} catch (IOException e) {
			throw new Axis2ServiceUtilsException("IO exception occurred while parsing given XML file as a DOM Document, File path : "
					+ filePath, e);
		} finally {
			try {
				inputStreamOfZipFile.close();
				resourcesZipFile.close();
			} catch (IOException e) {
				log.error("Error in closing zip file and input stream, ZIP file : " + filePath, e);
			}
		}

		return getServiceClassNameFromDocument(document);
	}

	/**
	 * This method provides logic for getting Axis2 service class name from given services xml file
	 *
	 * @param servicesXml xml file
	 * @return Axis2 service class name
	 * @throws javax.xml.parsers.ParserConfigurationException
	 * @throws org.xml.sax.SAXException
	 * @throws java.io.IOException
	 */
	public static String getServiceClassNameFromServicesXML(File servicesXml)
			throws ParserConfigurationException, SAXException, IOException {
		return getServiceClassNameFromServicesXMLStream(new FileInputStream(servicesXml));
	}

	/**
	 * This method provides logic for getting Axis2 service class name from given input stream
	 *
	 * @param in input stream of services.xml file
	 * @return Axis2 service class name
	 * @throws javax.xml.parsers.ParserConfigurationException
	 * @throws org.xml.sax.SAXException
	 * @throws java.io.IOException
	 */
	private static String getServiceClassNameFromServicesXMLStream(InputStream in)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = parser.parse(in);
		return getServiceClassNameFromDocument(document);
	}

	/**
	 * This method provides logic for getting Axis2 service name from given xml Document.
	 * If there are more than one service elements, the service name of first service element will be returned.
	 *
	 * @param document org.w3c.dom.Document element
	 * @return service name
	 */
	private static String getServiceNameFromDocument(Document document) {
		String serviceName;
		//Getting the first service element of given xml Document, So it will return the first service name of the xml Document
		Node service = document.getElementsByTagName(SERVICE_ELEMENT_NAME).item(0);
		Node nameNode = service.getAttributes().getNamedItem(NAME_ATTRIBUTE);
		serviceName = nameNode.getTextContent();

		//If the service name is null or empty, getting the service class name as the service name
		if (serviceName == null || serviceName.isEmpty()) {
			String serviceClassName = getServiceClassNameFromDocument(document);
			String[] split = serviceClassName.split(DOT_SEPARATOR);
			serviceName = split[split.length - 1];
		}
		return serviceName;
	}

	/**
	 * This method provides logic for getting Axis2 service class name from given xml Document.
	 * If there are more than one service elements, the service class name of first service element will be returned.
	 *
	 * @param document org.w3c.dom.Document element
	 * @return service class name
	 */
	private static String getServiceClassNameFromDocument(Document document) {
		String serviceClassName = null;
		//Getting the first service element from xml Document
		Node service = document.getElementsByTagName(SERVICE_ELEMENT_NAME).item(0);
		NodeList serviceChildNodes = service.getChildNodes();

		//Loop through all child nodes to get 'ServiceClass' parameter value
		for (int j = 0; j < serviceChildNodes.getLength(); j++) {
			Node node = serviceChildNodes.item(j);
			if (PARAMETER_ELEMENT_NAME.equals(node.getNodeName())) {
				NamedNodeMap attr = node.getAttributes();
				Node nodeAttr = attr.getNamedItem(NAME_ATTRIBUTE);
				if (nodeAttr.getNodeValue().equals(SERVICE_CLASS_ATTRIBUTE_VALUE)) {
					serviceClassName = node.getTextContent();
				}
			}
		}
		return serviceClassName;
	}

	/**
	 * Method that returns javax.xml.parsers.DocumentBuilder
	 *
	 * @return DocumentBuilder
	 * @throws org.wso2.developerstudio.eclipse.utils.exception.Axis2ServiceUtilsException
	 */
	private static DocumentBuilder getDocumentBuilder() throws Axis2ServiceUtilsException {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new Axis2ServiceUtilsException("Unable to create a DOM Document builder using javax XML builder factory", e);
		}
	}

}
