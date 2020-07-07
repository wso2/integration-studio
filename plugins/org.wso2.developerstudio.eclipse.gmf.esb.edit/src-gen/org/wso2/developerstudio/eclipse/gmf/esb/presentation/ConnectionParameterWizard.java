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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorConnectionRoot;

public class ConnectionParameterWizard extends Wizard implements IExportWizard {

    private static final String LOCAL_ENTRY_LOCATION = File.separator + "src" + File.separator + "main" + File.separator
            + "synapse-config" + File.separator + "local-entries";
    private static final String XML_EXTENSION = ".xml";
    private ConnectionParameterWizardPage connectionPage;
    private String connectorName;
    private String connectionNameFromLocalEntry;
    private Map<String, String> updateComponentWidgets = new HashMap<>();
    private ConnectorConnectionRoot connectorRoot;
    private Control valueExpressionCombo;
    private AttributeValue allowedConnectionTypes;
    private FormToolkit widgetFactory;
    private String updatingConnectionType;

    ConnectionParameterWizard(FormToolkit widgetFactory, String connectorName, Control valueExpressionCombo,
            AttributeValue allowedConnectionTypes) {
        setWindowTitle("Connection Configurations");
        this.widgetFactory = widgetFactory;
        this.connectorName = connectorName;
        this.valueExpressionCombo = valueExpressionCombo;
        this.allowedConnectionTypes = allowedConnectionTypes;
    }

    ConnectionParameterWizard(FormToolkit widgetFactory, String connectorName, String connectionNameFromLocalEntry,
            AttributeValue allowedConnectionTypes) {
        this.widgetFactory = widgetFactory;
        this.connectorName = connectorName;
        this.connectionNameFromLocalEntry = connectionNameFromLocalEntry;
        this.allowedConnectionTypes = allowedConnectionTypes;
        setWindowTitle("Connection Configurations");
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        try {
            if (connectionNameFromLocalEntry != null) {
                IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                IEditorPart activeEditor = activePage.getActiveEditor();

                IProject currentProject = null;
                if (activeEditor != null) {
                    IFileEditorInput input = (IFileEditorInput) activeEditor.getEditorInput();
                    IFile file = input.getFile();
                    currentProject = file.getProject();
                }

                String localEntryPath = currentProject.getLocation().toOSString() + LOCAL_ENTRY_LOCATION
                        + File.separator + connectionNameFromLocalEntry + XML_EXTENSION;
                String sourceFromLocalEntry = FileUtils.readFileToString(new File(localEntryPath), "UTF-8");
                deserializeConnector(AXIOMUtil.stringToOM(sourceFromLocalEntry));

                connectorRoot = ConnectorSchemaHolder.getInstance().getConnectorConnectionSchema(
                        connectorName + "-" + updatingConnectionType);
                connectionPage = new ConnectionParameterWizardPage(widgetFactory, connectorRoot, updateComponentWidgets,
                        allowedConnectionTypes, connectorName);
            } else {
                connectorRoot = ConnectorSchemaHolder.getInstance().getConnectorConnectionSchema(
                        connectorName + "-" + allowedConnectionTypes.getAllowedConnectionTypes().get(0));
                connectionPage = new ConnectionParameterWizardPage(widgetFactory, connectorRoot,
                        allowedConnectionTypes, connectorName);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
    }

    @Override
    public boolean performFinish() {
        try {
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
                String localEntryPath = currentProject.getLocation().toOSString() + LOCAL_ENTRY_LOCATION
                        + File.separator;
                serializeConnector(generatedElements, localEntryPath);
                currentProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                EEFPropertyViewUtil.updateArtifact(generatedElements, currentProject);
                return true;
            }
        } catch (CoreException e) {
            e.printStackTrace();
        } catch (FactoryConfigurationError e) {
             e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void serializeConnector(HashMap<String, Control> generatedElements, String localEntryPath) {
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
                    if (elementId.equals("connectionName") && !StringUtils.isEmpty(value)) {
                        localEntryPath = localEntryPath + value + XML_EXTENSION;
                        if (valueExpressionCombo != null) {
                            Combo connectionCombo = (Combo) valueExpressionCombo;
                            connectionCombo.add(value);
                            connectionCombo.select(connectionCombo.getItemCount() - 1);
                        }
                        Attr localEntryKey = doc.createAttribute("key");
                        localEntryKey.setValue(value);
                        localEntryTag.setAttributeNode(localEntryKey);

                        org.w3c.dom.Element configElement = doc.createElement("name");
                        connectorRoot.appendChild(configElement);
                        configElement.appendChild(doc.createTextNode(value));
                    } else if (!StringUtils.isEmpty(value)) {
                        org.w3c.dom.Element configElement = doc.createElement(elementId);
                        connectorRoot.appendChild(configElement);
                        configElement.appendChild(doc.createTextNode(value));
                    } 
                } else if (elementControl instanceof Combo) {
                    String value = ((Combo) elementControl).getText();
                    if (elementId.equals("connectionType")) {
                        Map<String, String> titleMap = (Map)((Combo) elementControl).getData("conenctionTitles");
                        org.w3c.dom.Element configElement = doc.createElement(elementId);
                        connectorRoot.appendChild(configElement);
                        configElement.appendChild(doc.createTextNode(titleMap.get(value)));
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
            StreamResult result = new StreamResult(new File(localEntryPath));
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
        updateComponentWidgets.put("connectionName", connectionName);

        Iterator<?> resourceIterator = localEntryNode.getFirstElement().getChildElements();
        while (resourceIterator.hasNext()) {
            OMElement resource = (OMElement) resourceIterator.next();
            if (resource.getLocalName().equals("connectionType")) {
                updatingConnectionType = resource.getText();
            }
            updateComponentWidgets.put(resource.getLocalName(), resource.getText());
        }
    }

    @Override
    public boolean canFinish() {
        return super.canFinish();
    }

    public void addPages() {
        addPage(connectionPage);
        super.addPages();
    }
}
