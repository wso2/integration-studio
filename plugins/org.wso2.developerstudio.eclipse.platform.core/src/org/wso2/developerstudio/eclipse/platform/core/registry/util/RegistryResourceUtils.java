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

package org.wso2.developerstudio.eclipse.platform.core.registry.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.carbon.registry.synchronization.SynchronizationException;
import org.wso2.carbon.registry.synchronization.Utils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.xml.sax.SAXException;

import static org.wso2.developerstudio.eclipse.platform.core.registry.util.Constants.REGISTRY_COLLECTION;
import static org.wso2.developerstudio.eclipse.platform.core.registry.util.Constants.REGISTRY_DUMP;
import static org.wso2.developerstudio.eclipse.platform.core.registry.util.Constants.REGISTRY_RESOURCE;
import static org.wso2.developerstudio.eclipse.platform.core.registry.util.Constants.REGISTRY_UNDEFINED;

public class RegistryResourceUtils {

	public static class RegistryState {
		public static int ADDED = 1;
		public static int COMMITED = 2;
		public static int MODIFIED = 3;
		public static int UPDATED = 4;
	}

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public RegistryResourceUtils() {
	}

	public static void addRegistryResourceInfo(File inputFile, RegistryResourceInfoDoc regResInfoDoc, File base,
	                                           String path) {
		addRegistryResourceInfo(inputFile, regResInfoDoc, base, path, REGISTRY_UNDEFINED);
	}

	public static void addRegistryResourceInfo(File inputFile, RegistryResourceInfoDoc regResInfoDoc, File base,
	                                           String path, int type) {
		String relativePath = inputFile.getAbsolutePath().substring(base.getParent().length() + 1);

		if (type == REGISTRY_DUMP) {
			regResInfoDoc.addRegistryResourceInfoDoc(path, inputFile, REGISTRY_DUMP, base, "");
		} else {
			if (inputFile.isFile()) {
				regResInfoDoc.addRegistryResourceInfoDoc(path, inputFile, REGISTRY_RESOURCE, base, "");
			} else {
				path = path.endsWith("/") ? path : path + "/";
				path += inputFile.getName();
				regResInfoDoc.addRegistryResourceInfoDoc(path, inputFile, REGISTRY_COLLECTION, base, relativePath);
			}
		}

	}

	public static void createMetaDataForFolder(String checkoutPath, File fromPath) {
		ResourceMetaData resMetaData = new ResourceMetaData();
		if (fromPath.getName().equals(".meta"))
			return;
		try {
			if (fromPath.isFile()) {
				File metaFolderPath = createMetaFolder(fromPath.getParentFile());
				resMetaData.createElement(fromPath, checkoutPath, true, metaFolderPath, false);
			} else {
				File metaFolderPath = createMetaFolder(fromPath);
				resMetaData.createElement(fromPath, checkoutPath, false, metaFolderPath, false);
				File[] listFiles = fromPath.listFiles();
				for (File file : listFiles) {
					createMetaDataForFolder(checkoutPath.replaceAll("/$", "") + "/" + fromPath.getName(), file);
				}
			}
		} catch (FactoryConfigurationError e) {
			log.error("XML FactoryConfiguration Error", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
	}

	private static File createMetaFolder(File resourceFile) {
		File metaFolder = new File(resourceFile, ".meta");
		metaFolder.mkdirs();
		return metaFolder;
	}

	public static void updateMetaData(String resourcePath, int newState) {
		String metaFolderPath = "";
		File resourceFile = new File(resourcePath);
		if (resourceFile.exists()) {
			if (resourceFile.isFile()) {
				metaFolderPath = resourceFile.getParent() + File.separator + ".meta";
				File metadataFile = new File(metaFolderPath, "~" + resourceFile.getName() + ".xml");
				if (metadataFile.exists()) {
					updateRegistryState(metadataFile.getAbsolutePath(), newState);
				}
			} else if (resourceFile.isDirectory()) {
				metaFolderPath = resourceFile.getAbsolutePath() + File.separator + ".meta";
				File metaFolder = new File(metaFolderPath);
				if (metaFolder.exists()) {
					File[] listFiles = metaFolder.listFiles();
					for (File file : listFiles) {
						if (file.isFile()) {
							updateRegistryState(file.getAbsolutePath(), newState);
						} else if (file.isDirectory()) {
							updateMetaData(file.getAbsolutePath(), newState);
						}
					}
				}
			}
		}
	}

	private static void updateRegistryState(String filepath, int newState) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			if (doc != null) {
				Node root = doc.getFirstChild();
				NodeList list = root.getChildNodes();
				Node stateNode = null;

				NamedNodeMap attr = root.getAttributes();
				Node nodeAttr = attr.getNamedItem("md5");
				File dataFile = new File(filepath);
				String datafolder = dataFile.getParentFile().getParent();
				String fileNameWithOutExt = dataFile.getName().replaceFirst("[.][^.]+$", "");
				fileNameWithOutExt = fileNameWithOutExt.replaceFirst("~", "");
				dataFile = new File(datafolder + File.separator + fileNameWithOutExt);
				if (dataFile.exists() && dataFile.isFile()) {
					String md5 = Utils.getMD5(Utils.getBytesFromFile(dataFile));
					if (nodeAttr != null) {
						nodeAttr.setTextContent(md5);
					} else {
						// forcefully adds a md5 even if the file is empty
						Node md5AttrNode = doc.createAttribute("md5");
						md5AttrNode.setTextContent(md5);
						attr.setNamedItem(md5AttrNode);
					}
				}

				for (int i = 0; i < list.getLength(); i++) {
					Node node = list.item(i);
					if ("registryState".equals(node.getNodeName())) {
						node.setTextContent(Integer.toString(newState));
						stateNode = node;
					}
					if ("lastModified".equals(node.getNodeName())) {
						node.setTextContent("" + System.currentTimeMillis());
					}
				}

				if (stateNode == null) {
					stateNode = doc.createElement("registryState");
					stateNode.appendChild(doc.createTextNode(Integer.toString(newState)));
					root.appendChild(stateNode);
				}

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				transformer.transform(source, new StreamResult(new File(filepath)));
			}

		} catch (ParserConfigurationException pce) {
			log.error("Error reading meta data", pce);
		} catch (TransformerException tfe) {
			log.error("Error reading meta data", tfe);
		} catch (IOException ioe) {
			log.error("Error reading meta data", ioe);
		} catch (SAXException sae) {
			log.error("Error reading meta data", sae);
		} catch (SynchronizationException e) {
			log.error("Error reading meta data", e);
		}
	}

	public static int getRegistryState(String resourcePath) {

		int state = -1;
		File metadataFile = null;
		File resourceFile = new File(resourcePath);
		if (resourceFile.exists()) {

			if (resourceFile.isFile()) {
				String metaFolderPath = resourceFile.getParent() + File.separator + ".meta";
				metadataFile = new File(metaFolderPath, "~" + resourceFile.getName() + ".xml");
			} else if (resourceFile.isDirectory()) {
				metadataFile =
				               new File(resourceFile.getAbsolutePath() + File.separator + ".meta" + File.separator +
				                        "~.xml");
			}

			if (metadataFile != null) {
				if (metadataFile.exists()) {
					try {
						DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
						Document doc = docBuilder.parse(metadataFile.getAbsolutePath());

						if (doc != null) {
							Node root = doc.getFirstChild();
							NodeList list = root.getChildNodes();
							for (int i = 0; i < list.getLength(); i++) {
								Node node = list.item(i);
								if ("registryState".equals(node.getNodeName())) {
									state = Integer.parseInt(node.getTextContent());
									break;
								}
							}
						}
					} catch (ParserConfigurationException pce) {
						log.error("Error reading meta data", pce);
					} catch (IOException ioe) {
						log.error("Error reading meta data", ioe);
					} catch (SAXException sae) {
						log.error("Error reading meta data", sae);
					}
				}
			}
		}
		return state;
	}
}
