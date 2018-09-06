/*
 *     Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PlatformUI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TemplateWizardUtil {

    /**
     * Will initialize file contents with a sample text.
     *
     * @param taskName This gives the taskName of the changed task
     * @param tnsName  This gives the target namespace of the changed element
     * @return InputStream
     * @throws IOException
     * @throws CoreException
     */
    public InputStream openContentStream(String taskName, String tnsName) throws IOException, CoreException {
        String contents = changeXMLName(readTemplateHT(), taskName, tnsName);
        return new ByteArrayInputStream(contents.getBytes(TemplateProjectConstants.UTF8_STRING));
    }

    /**
     * Will initialize file contents with a dummy wsdl.
     *
     * @return InputStream which contains WSDL contents
     * @throws IOException
     */
    public InputStream openWSDLStream() throws IOException {
        String contents = readTemplateWSDL();
        return new ByteArrayInputStream(contents.getBytes(TemplateProjectConstants.UTF8_STRING));
    }

    /**
     * Will initialize file contents with a dummy org schema.
     *
     * @return InputStream which contains organization schema's content
     * @throws IOException
     */
    public InputStream openOrgSchemaStream() throws IOException {
        String contents = readTemplateOrgSchema();
        return new ByteArrayInputStream(contents.getBytes(TemplateProjectConstants.UTF8_STRING));
    }

    /**
     * This will open file contents of Template pom file
     *
     * @param containerName
     * @return InputStream which contains the pom contents
     * @throws IOException
     * @throws CoreException
     */
    public InputStream openPomStream(String containerName) throws IOException, CoreException {
        String contents = changePOMName(containerName, readTemplatePomSchema());
        return new ByteArrayInputStream(contents.getBytes(TemplateProjectConstants.UTF8_STRING));
    }

    /**
     * This will open file contents of template HT Config file
     *
     * @return InputStream which contains the HT Config contents
     * @throws IOException
     */
    public InputStream openHTConfigStream() throws IOException {
        String contents = readTemplateHtConfig();
        return new ByteArrayInputStream(contents.getBytes(TemplateProjectConstants.UTF8_STRING));
    }

    /**
     * Read dummy ht file which is needed to initialize a new ht file
     *
     * @return A string of Template HumanTask File Contents
     * @throws IOException
     */
    public String readTemplateHT() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(TemplateProjectConstants.DUMMY_HT_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(inputStream, TemplateProjectConstants.UTF8_STRING))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append(TemplateProjectConstants.NEWLINE_CHAR);
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    TemplateProjectConstants.ERROR_MESSAGE, TemplateProjectConstants.ERROR_READING_FROM_PROJECT_MESSAGE,
                    editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read template WSDL file which is needed to initialize a new WSDL file
     *
     * @return A string of Template WSDL File Contents
     * @throws IOException
     */
    public String readTemplateWSDL() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(TemplateProjectConstants.DUMMY_WSDL_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(inputStream, TemplateProjectConstants.UTF8_STRING))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append(TemplateProjectConstants.NEWLINE_CHAR);
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    TemplateProjectConstants.ERROR_MESSAGE, TemplateProjectConstants.ERROR_READING_FROM_PROJECT_MESSAGE,
                    editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read template Organization Schema file which is needed to initialize a new OrganizationSchema file
     *
     * @return A string of Template Org Schema File Contents
     * @throws IOException
     */
    public String readTemplateOrgSchema() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(TemplateProjectConstants.DUMMY_ORG_SCHEMA_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(inputStream, TemplateProjectConstants.UTF8_STRING))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append(TemplateProjectConstants.NEWLINE_CHAR);
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    TemplateProjectConstants.ERROR_MESSAGE, TemplateProjectConstants.ERROR_READING_FROM_PROJECT_MESSAGE,
                    editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read template POM file which is needed to initialize a new POM file for the new project
     *
     * @return A string of Template POM File Contents
     * @throws IOException
     */
    public String readTemplatePomSchema() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(TemplateProjectConstants.DUMMY_POM_SCHEMA_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(inputStream, TemplateProjectConstants.UTF8_STRING))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append(TemplateProjectConstants.NEWLINE_CHAR);
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    TemplateProjectConstants.ERROR_MESSAGE, TemplateProjectConstants.ERROR_READING_FROM_PROJECT_MESSAGE,
                    editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read template HTConfig file which is needed to initialize a new HtConfig.xml file
     *
     * @return A string of Template HTConfig File Contents
     * @throws IOException
     */
    public String readTemplateHtConfig() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(TemplateProjectConstants.DUMMY_HTCONFIG_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(inputStream, TemplateProjectConstants.UTF8_STRING))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append(TemplateProjectConstants.NEWLINE_CHAR);
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    TemplateProjectConstants.ERROR_MESSAGE, TemplateProjectConstants.ERROR_READING_FROM_PROJECT_MESSAGE,
                    editorStatus);
        }
        return sb.toString();
    }

    /**
     * This method changes the relevant XML Namespaces and tags accordingly
     *
     * @param content  content of the xml file
     * @param taskName currently Processing Task Name
     * @param tnsName  Target Namespace
     * @return String which contains the modified XML file content
     * @throws CoreException
     */
    public String changeXMLName(String content, String taskName, String tnsName) throws CoreException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        String xmlString = null;
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(content));
            dom = db.parse(is);
            NodeList taskList = dom.getElementsByTagName(TemplateProjectConstants.QUALIFIED_TASK_NODE_NAME);
            NodeList tnsList = dom
                    .getElementsByTagName(TemplateProjectConstants.QUALIFIED_HUMAN_INTERACTIONS_NODE_NAME);
            tnsList.item(0).getAttributes().getNamedItem(TemplateProjectConstants.XMLNS_TNS).setNodeValue(tnsName);
            tnsList.item(0).getAttributes().getNamedItem(TemplateProjectConstants.TARGET_NAMESPACE)
                    .setNodeValue(tnsName);
            for (int taskIndex = 0; taskIndex < taskList.getLength(); taskIndex++) {
                Node task = taskList.item(taskIndex);
                task.getAttributes().getNamedItem(TemplateProjectConstants.TASK_NAME_ATTRIBUTE).setNodeValue(taskName);
            }
            TransformerFactory transfactory = TransformerFactory.newInstance();
            Transformer transformer = transfactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, TemplateProjectConstants.XML_OUTPUT_METHOD);
            transformer.setOutputProperty(OutputKeys.INDENT, TemplateProjectConstants.XML_INDENT_YES);
            transformer.setOutputProperty(TemplateProjectConstants.XML_OUTPUT_PROPERTY_NAME, Integer.toString(2));

            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            DOMSource source = new DOMSource(dom.getDocumentElement());

            transformer.transform(source, result);
            xmlString = stringWriter.toString();
        } catch (ParserConfigurationException | SAXException pce) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_PARSING_XML, pce);
        } catch (IOException ioe) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_FILE_IO, ioe);
        } catch (TransformerConfigurationException e) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_TRANSFORM_CONFIG, e);
        } catch (TransformerException e) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_TRANSFORMING_XML_TO_TEXT, e);
        }
        return xmlString;
    }

    /**
     * This method changes namespaces and relevant tags of the pom file accrodingly
     *
     * @param containerName Project name
     * @param content       Content of the pom file
     * @return String of modified pom file content
     * @throws CoreException
     */
    public String changePOMName(String containerName, String content) throws CoreException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        String xmlString = null;
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(content));
            dom = db.parse(is);
            Node groupID = dom.getElementsByTagName(TemplateProjectConstants.GROUP_ID_TEXT).item(0);
            Node artifactID = dom.getElementsByTagName(TemplateProjectConstants.ARTIFACT_ID_TEXT).item(0);
            Node name = dom.getElementsByTagName(TemplateProjectConstants.TASK_NAME_ATTRIBUTE).item(0);
            Node description = dom.getElementsByTagName(TemplateProjectConstants.DESCRIPTION_TEXT).item(0);
            groupID.appendChild(dom.createTextNode(TemplateProjectConstants.HUMANTASK_PACKAGE_PREFIX + containerName));
            artifactID.appendChild(dom.createTextNode(containerName));
            name.appendChild(dom.createTextNode(containerName));
            description.appendChild(dom.createTextNode(containerName));
            TransformerFactory transfactory = TransformerFactory.newInstance();
            Transformer transformer = transfactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, TemplateProjectConstants.XML_OUTPUT_METHOD);
            transformer.setOutputProperty(OutputKeys.INDENT, TemplateProjectConstants.XML_INDENT_YES);
            transformer.setOutputProperty(TemplateProjectConstants.XML_OUTPUT_PROPERTY_NAME, Integer.toString(2));

            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            DOMSource source = new DOMSource(dom.getDocumentElement());

            transformer.transform(source, result);
            xmlString = stringWriter.toString();
        } catch (ParserConfigurationException | SAXException pce) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_PARSING_XML, pce);
        } catch (IOException ioe) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_FILE_IO, ioe);
        } catch (TransformerConfigurationException e) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_TRANSFORM_CONFIG, e);
        } catch (TransformerException e) {
            throwCoreException(TemplateProjectConstants.EXCEPTION_OCCURED_IN_TRANSFORMING_XML_TO_TEXT, e);
        }
        return xmlString;
    }

    /**
     * Create a new project nature for the new project
     *
     * @param project The IProject instance of the new project
     * @throws CoreException
     */
    public void addNature(IProject project, String natureID) throws CoreException {
        if (!project.hasNature(natureID)) {
            IProjectDescription description = project.getDescription();
            String[] prevNatures = description.getNatureIds();
            String[] newNatures = new String[prevNatures.length + 1];
            System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
            newNatures[prevNatures.length] = natureID;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);
        }
    }

    /**
     * This method creates a new coreexception and throws it
     *
     * @param message   The exception message that should be printed
     * @param exception The nested exception that should be included in the throwable
     * @throws CoreException
     */
    public void throwCoreException(String message, Throwable exception) throws CoreException {
        IStatus status = new Status(IStatus.ERROR, TemplateProjectConstants.PLUGIN_ID, IStatus.OK, message, exception);
        throw new CoreException(status);
    }
}
