/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeGroupValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Element;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Value;

public class ConnectionParameterWizard extends Wizard implements IExportWizard {
	private ConnectionParameterWizardPage connectionPage;
	private String connectorName;
	private static StringWriter writer;
	private String connectorFileName;
	private Map<String, String> updateConfigMap = new HashMap<>();
	private ConnectorRoot connectorRoot;

	ConnectionParameterWizard() {
		setWindowTitle("Connection Configurations");
	}

	ConnectionParameterWizard(String configName) {
		this.connectorFileName = configName;
		setWindowTitle("Connection Configurations");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		try {
			Bundle bundle = Platform.getBundle("org.wso2.developerstudio.eclipse.gmf.esb.edit");
			URL fileURL = bundle.getEntry("resources/gmail-connection.json");
			URL resolvedFileURL = FileLocator.toFileURL(fileURL);
			URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
			String text = new String(Files.readAllBytes(Paths.get(resolvedURI)), StandardCharsets.UTF_8);
			connectorRoot = parse(text);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (connectorFileName != null) {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorPart activeEditor = activePage.getActiveEditor();

			IProject currentProject = null;
			if (activeEditor != null) {
				IFileEditorInput input = (IFileEditorInput) activeEditor.getEditorInput();
				IFile file = input.getFile();
				currentProject = file.getProject();
			}

			String localEntryPath = currentProject.getLocation().toOSString() + File.separator + "src" + File.separator
					+ "main" + File.separator + "synapse-config" + File.separator + "local-entries" + File.separator
					+ connectorFileName + ".xml";

			try {
				String text = FileUtils.readFileToString(new File(localEntryPath), "UTF-8");
				OMElement importedXMLFile = AXIOMUtil.stringToOM(text);
				deserializeConnector(importedXMLFile);

				connectionPage = new ConnectionParameterWizardPage(connectorRoot, updateConfigMap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			connectionPage = new ConnectionParameterWizardPage(connectorRoot);
		}
	}

	@Override
	public boolean performFinish() {
		HashMap<String, Control> generatedElements = connectionPage.getGeneratedElements();
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart activeEditor = activePage.getActiveEditor();

		IProject currentProject = null;
		if (activeEditor != null) {
			IFileEditorInput input = (IFileEditorInput) activeEditor.getEditorInput();
			IFile file = input.getFile();
			currentProject = file.getProject();
		}

		if (generatedElements.size() > 0 && currentProject != null) {
			String localEntryPath = currentProject.getLocation().toOSString() + File.separator + "src" + File.separator
					+ "main" + File.separator + "synapse-config" + File.separator + "local-entries" + File.separator;
			serializeConnector(generatedElements, localEntryPath);

			try {
				currentProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		return false;
	}

	private void serializeConnector(HashMap<String, Control> generatedElements, String filePath) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			org.w3c.dom.Element localEntryTag = doc.createElement("localEntry");
			doc.appendChild(localEntryTag);

			String connectorRootName = connectorName + ".init";
			org.w3c.dom.Element connectorRoot = doc.createElement(connectorRootName);
			localEntryTag.appendChild(connectorRoot);

			Attr localEntryNamespace = doc.createAttribute("xmlns");
			localEntryNamespace.setValue("http://ws.apache.org/ns/synapse");
			localEntryTag.setAttributeNode(localEntryNamespace);

			for (Map.Entry<String, Control> mapElement : generatedElements.entrySet()) {
				String elementId = mapElement.getKey();
				Control elementControl = mapElement.getValue();

				if (elementControl instanceof Text) {
					String value = ((Text) elementControl).getText();
					if (elementId.equals("connectionName")) {
						filePath = filePath + value + ".xml";
						Attr localEntryKey = doc.createAttribute("key");
						localEntryKey.setValue(value);
						localEntryTag.setAttributeNode(localEntryKey);

					} else if (!StringUtils.isEmpty(value)) {
						org.w3c.dom.Element configElement = doc.createElement(elementId);
						connectorRoot.appendChild(configElement);
						configElement.appendChild(doc.createTextNode(value));
					}
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);

		} catch (ParserConfigurationException | TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deserializeConnector(OMElement localEntryNode) {
		String connectionName = localEntryNode.getAttributeValue(new QName("key"));
		updateConfigMap.put("connectionName", connectionName);

		Iterator<?> resourceIterator = localEntryNode.getFirstElement().getChildElements();
		while (resourceIterator.hasNext()) {
			OMElement resource = (OMElement) resourceIterator.next();
			updateConfigMap.put(resource.getLocalName(), resource.getText());
		}
	}

	@Override
	public boolean canFinish() {
		return true;
	}

	public void addPages() {
		addPage(connectionPage);
		super.addPages();
	}

	public ConnectorRoot parse(String jsonString) throws JSONException {
		ConnectorRoot connectorRoot = new ConnectorRoot();
		JSONObject rootObject = new JSONObject(jsonString);
		connectorName = rootObject.getString("connectorName");
		connectorRoot.setConnectorName(rootObject.getString("connectorName"));
		connectorRoot.setConnectionName(rootObject.getString("connectionName"));
		connectorRoot.setDisplayName(rootObject.getString("displayName"));
		connectorRoot.setHelp(rootObject.getString("help"));
		JSONArray elementsArray = rootObject.getJSONArray("elements");
		for (int i = 0; i < elementsArray.length(); i++) {
			Element element = new Element();
			JSONObject obj = elementsArray.getJSONObject(i);
			element.setType(obj.getString("type"));
			if (element.getType().equalsIgnoreCase("attribute")) {
				AttributeValue value = new AttributeValue();
				JSONObject attrObj = obj.getJSONObject("value");
				value.setName(attrObj.getString("name"));
				value.setDefaultValue(attrObj.getString("default"));
				value.setRequired(Boolean.parseBoolean(attrObj.getString("required")));
				value.setHelpTip(attrObj.getString("helpTip"));
				value.setDisplayName(attrObj.getString("displayName"));
				value.setType(AttributeValueType.STRING); // HardCoded
				element.setValue(value);
			} else {
				AttributeGroupValue groupValue = new AttributeGroupValue();
				JSONObject attrGroupObj = obj.getJSONObject("value");
				groupValue.setGroupName(attrGroupObj.getString("groupName"));
				recursive(attrGroupObj.getJSONArray("elements"), groupValue);
				element.setValue(groupValue);
			}
			connectorRoot.addElement(element);
		}
		return connectorRoot;
	}

	public void recursive(JSONArray elementsArray, Value rootValue) throws JSONException {
		for (int i = 0; i < elementsArray.length(); i++) {
			Element element = new Element();
			JSONObject obj = elementsArray.getJSONObject(i);
			element.setType(obj.getString("type"));
			if (element.getType().equalsIgnoreCase("attribute")) {
				AttributeValue value = new AttributeValue();
				JSONObject attrObj = obj.getJSONObject("value");
				value.setName(attrObj.getString("name"));
				value.setDefaultValue(attrObj.getString("default"));
				value.setRequired(Boolean.parseBoolean(attrObj.getString("required")));
				value.setHelpTip(attrObj.getString("helpTip"));
				value.setDisplayName(attrObj.getString("displayName"));
				value.setType(AttributeValueType.STRING); // HardCoded type
				element.setValue(value);
			} else {
				AttributeGroupValue groupValue = new AttributeGroupValue();
				JSONObject attrGroupObj = obj.getJSONObject("value");
				groupValue.setGroupName(attrGroupObj.getString("groupName"));
				recursive(attrGroupObj.getJSONArray("elements"), groupValue);
				element.setValue(groupValue);
			}
			if (rootValue instanceof AttributeGroupValue) {
				((AttributeGroupValue) rootValue).addElement(element);
			}
		}
	}

	/**
	 * Method of closing string writer.
	 */
	private static void closeWriter() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
