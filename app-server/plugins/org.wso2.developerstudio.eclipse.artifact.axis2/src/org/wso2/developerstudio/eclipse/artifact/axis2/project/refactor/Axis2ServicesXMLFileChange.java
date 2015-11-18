/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.artifact.axis2.project.refactor;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.artifact.axis2.Activator;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2Utils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * This is the class defining all the changes to be done in services.xml file for an Axis2 service project
 * when a service class is renamed.
 * For example, the corresponding ServiceClass value should be updated accordingly in services.xml when rename the service class.
 */
public class Axis2ServicesXMLFileChange extends TextFileChange {
    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private String previousClassName;
    private String newClassName;

    private static final String SERVICE_ELEMENT_NAME = "service";
    private static final String PARAMETER_ELEMENT_NAME = "parameter";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SERVICE_CLASS_IDENTIFIER = "ServiceClass";
    private static final String ACCEPT_INDICATOR = "yes";

    /**
     * Constructor that handles all the tasks for updating services.xml file when renaming a service class
     */
    public Axis2ServicesXMLFileChange(String textFileChangeName, IFile servicesXMLFile, String previousClassName,
                                      String newClassName) throws CoreException {
        super(textFileChangeName, servicesXMLFile);
        this.previousClassName = Axis2Utils.removeFileExtension(previousClassName);
        this.newClassName = Axis2Utils.removeFileExtension(newClassName);
    }

    /**
     * Method for updating given services.xml file with the new class name
     *
     * @param servicesXMLFile a reference for Axis2 services.xml file
     */
    public void updateServicesXMLFile(IFile servicesXMLFile) throws CoreException {
        IStatus errorStatus = new Status(Status.WARNING, Activator.PLUGIN_ID,
                "Error in updating services.xml file with new class name, Name : " + newClassName);

        String previousXMLContents;
        String updatedXMLContents;
        DocumentBuilder parser;
        Document document;

        try {
            previousXMLContents = IOUtils.toString(new FileInputStream(new File(servicesXMLFile.getLocation().toOSString())), servicesXMLFile.getCharset());
        } catch (IOException e) {
            log.error("Error in reading XML file, File : " + servicesXMLFile.getName(), e);
            throw new CoreException(errorStatus);
        }

        try {
            parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error("Parser configuration exception in creating a DocumentBuilder", e);
            throw new CoreException(errorStatus);
        }

        //Converting services.xml file to a data object model(DOM) document
        try {
            document = parser.parse(new FileInputStream(new File(servicesXMLFile.getLocation().toOSString())));
        } catch (SAXException e) {
            log.error("Unable to parse services.xml file to a DOM document, XML File : " + servicesXMLFile.getName()
                    + ", Location : " + servicesXMLFile.getLocation().toOSString(), e);
            throw new CoreException(errorStatus);
        } catch (IOException e) {
            log.error("Unable to find services.xml file, XML File : " + servicesXMLFile.getName()
                    + ", at Location : " + servicesXMLFile.getLocation().toOSString(), e);
            throw new CoreException(errorStatus);
        }

        updateDocumentWithNewClassName(document);

        //Creating an input stream with updated XML contents
        InputStream updatedInputStream = createInputStreamFromDocument(document);

        try {
            updatedXMLContents = IOUtils.toString(updatedInputStream, servicesXMLFile.getCharset());
        } catch (IOException e) {
            log.error("Error in reading XML file, File : " + servicesXMLFile.getName(), e);
            throw new CoreException(errorStatus);
        }

        //Updating services.xml file with new contents
        setEdit(new MultiTextEdit());
        addEdit(new ReplaceEdit(0, previousXMLContents.length(), updatedXMLContents));

    }

    /**
     * Update DOM Document with new Axis2 service class name
     *
     * @param document a DOM Document
     */
    private void updateDocumentWithNewClassName(Document document) {
        //Getting all service nodes from document
        NodeList serviceList = document.getElementsByTagName(SERVICE_ELEMENT_NAME);

        //Looping through each service node to find which service to update with new class name
        for (int i = 0; i < serviceList.getLength(); i++) {
            Node service = serviceList.item(i);
            NodeList serviceChildNodes = service.getChildNodes();

            //Looping through each child node to find the node named as 'parameter'
            for (int j = 0; j < serviceChildNodes.getLength(); j++) {
                Node node = serviceChildNodes.item(j);
                if (PARAMETER_ELEMENT_NAME.equals(node.getNodeName())) {
                    NamedNodeMap attr = node.getAttributes();
                    Node nodeAttr = attr.getNamedItem(NAME_ATTRIBUTE);
                    //If the 'name' attribute value is 'ServiceClass', then updating the node
                    if (nodeAttr.getNodeValue().equals(SERVICE_CLASS_IDENTIFIER)) {
                        String oldFullyQualifiedClassName = node.getTextContent();
                        String packageName = Axis2Utils.extractPackageName(oldFullyQualifiedClassName);
                        String className = Axis2Utils.extractClassName(oldFullyQualifiedClassName);
                        if (className.equals(previousClassName)) {
                            node.setTextContent(packageName + "." + newClassName);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Create an input stream from a DOM Document
     *
     * @param document a DOM Document to which an input stream should be created
     * @return InputStream representing given DOM Document
     */
    private InputStream createInputStreamFromDocument(Document document) throws CoreException {
        IStatus errorStatus = new Status(Status.WARNING, Activator.PLUGIN_ID,
                "Error in updating services.xml file with new class name, Name : " + newClassName);

        //Creating an output stream to keep the updated DOM temporarily in memory
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DOMSource xmlSource = new DOMSource(document);
        StreamResult outputTarget = new StreamResult(outputStream);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            log.error("Unable to create javax XML Transformer to update Axis2 services.xml file", e);
            throw new CoreException(errorStatus);
        }
        //Setting an optional parameter to transformer that omits xml declaration in services.xml file
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, ACCEPT_INDICATOR);
        try {
            //Updating services.xml file with updated DOM Document
            transformer.transform(xmlSource, outputTarget);
        } catch (TransformerException e) {
            log.error("Unable to transform updated DOM Document to services.xml file, DOM Document : " + document.toString(), e);
            throw new CoreException(errorStatus);
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

}
