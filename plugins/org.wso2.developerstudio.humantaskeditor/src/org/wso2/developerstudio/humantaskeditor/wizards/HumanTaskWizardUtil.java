package org.wso2.developerstudio.humantaskeditor.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.logging.Level;

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
import org.wso2.developerstudio.humantaskeditor.Activator;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class HumanTaskWizardUtil {
    
    /**
     * Will initialize file contents with a sample text.
     *
     * @throws IOException
     * @throws CoreException
     */

    public InputStream openContentStream(String taskName, String tnsName) throws IOException, CoreException {
        String contents = changeXMLName(readDummyHT(), taskName, tnsName);
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * Will initialize file contents with a dummy wsdl.
     *
     * @throws IOException
     */

    public InputStream openWSDLStream() throws IOException {
        String contents = readDummyWSDL();
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * Will initialize file contents with a dummy org schema.
     *
     * @throws IOException
     */

    public InputStream openOrgSchemaStream() throws IOException {
        String contents = readDummyOrgSchema();
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * Will initialize file contents with a dummy pom schema.
     *
     * @throws IOException
     * @throws CoreException
     */

    public InputStream openPomStream(String containerName) throws IOException, CoreException {
        String contents = changePOMName(containerName, readDummyPomSchema());
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * Will initialize file contents with a dummy htconfig.
     *
     * @throws IOException
     */

    public InputStream openHTConfigStream() throws IOException {
        String contents = readDummyHtConfig();
        return new ByteArrayInputStream(contents.getBytes());
    }

    /**
     * Read dummy ht file which is needed to initialize a new ht file
     *
     * @throws IOException
     */
    public String readDummyHT() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(HumantaskEditorConstants.DUMMY_HT_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append("\n");
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read dummy ht file which is needed to initialize a new ht file
     *
     * @throws IOException
     */
    public String readDummyWSDL() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(HumantaskEditorConstants.DUMMY_WSDL_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append("\n");
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read dummy org schema file which is needed to initialize a new ht file
     *
     * @throws IOException
     */
    public String readDummyOrgSchema() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(HumantaskEditorConstants.DUMMY_ORG_SCHEMA_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append("\n");
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }

    /**
     * Read dummy pom file which is needed to initialize a new ht file
     *
     * @throws IOException
     */
    public String readDummyPomSchema() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(HumantaskEditorConstants.DUMMY_POM_SCHEMA_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append("\n");
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }

    public String readDummyHtConfig() throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(HumantaskEditorConstants.DUMMY_HTCONFIG_LOCATION);
        try (InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append("\n");
            }
        } catch (IOException e) {
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE, "Error reading from project", editorStatus);
        }
        return sb.toString();
    }
    
    public String changeXMLName(String content, String taskName, String tnsName) throws CoreException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        String xmlString = null;
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(content));
            dom = db.parse(is);
            NodeList taskList = dom.getElementsByTagName(HumantaskEditorConstants.QUALIFIED_TASK_NODE_NAME);
            NodeList tnsList = dom
                    .getElementsByTagName(HumantaskEditorConstants.QUALIFIED_HUMAN_INTERACTIONS_NODE_NAME);
            tnsList.item(0).getAttributes().getNamedItem(HumantaskEditorConstants.XMLNS_TNS).setNodeValue(tnsName);
            tnsList.item(0).getAttributes().getNamedItem(HumantaskEditorConstants.TARGET_NAMESPACE)
                    .setNodeValue(tnsName);
            for (int i = 0; i < taskList.getLength(); i++) {
                Node task = taskList.item(i);
                task.getAttributes().getNamedItem(HumantaskEditorConstants.TASK_NAME_ATTRIBUTE).setNodeValue(taskName);
            }
            TransformerFactory transfactory = TransformerFactory.newInstance();
            Transformer transformer = transfactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, HumantaskEditorConstants.XML_OUTPUT_METHOD);
            transformer.setOutputProperty(OutputKeys.INDENT, HumantaskEditorConstants.XML_INDENT_YES);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            DOMSource source = new DOMSource(dom.getDocumentElement());

            transformer.transform(source, result);
            xmlString = stringWriter.toString();
        } catch (ParserConfigurationException | SAXException pce) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_PARSING_XML);
        } catch (IOException ioe) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_FILE_IO);
        } catch (TransformerConfigurationException e) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_TRANSFORM_CONFIG);
        } catch (TransformerException e) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_TRANSFORMING_XML_TO_TEXT);
        }
        return xmlString;
    }

    public String changePOMName(String containerName, String content) throws CoreException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom;
        String xmlString = null;
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(content));
            dom = db.parse(is);
            Node groupID = dom.getElementsByTagName("groupId").item(0);
            Node artifactID = dom.getElementsByTagName("artifactId").item(0);
            Node name = dom.getElementsByTagName("name").item(0);
            Node description = dom.getElementsByTagName("description").item(0);
            groupID.appendChild(dom.createTextNode("com.humantask." + containerName));
            artifactID.appendChild(dom.createTextNode(containerName));
            name.appendChild(dom.createTextNode(containerName));
            description.appendChild(dom.createTextNode(containerName));
            TransformerFactory transfactory = TransformerFactory.newInstance();
            Transformer transformer = transfactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, HumantaskEditorConstants.XML_OUTPUT_METHOD);
            transformer.setOutputProperty(OutputKeys.INDENT, HumantaskEditorConstants.XML_INDENT_YES);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            DOMSource source = new DOMSource(dom.getDocumentElement());

            transformer.transform(source, result);
            xmlString = stringWriter.toString();
        } catch (ParserConfigurationException | SAXException pce) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_PARSING_XML);
        } catch (IOException ioe) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_FILE_IO);
        } catch (TransformerConfigurationException e) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_TRANSFORM_CONFIG);
        } catch (TransformerException e) {
            throwCoreException(HumantaskEditorConstants.EXCEPTION_OCCURED_IN_TRANSFORMING_XML_TO_TEXT);
        }
        return xmlString;
    }
    
    public void throwCoreException(String message) throws CoreException {
        IStatus status = new Status(IStatus.ERROR, HumantaskEditorConstants.PLUGIN_ID, IStatus.OK, message, null);
        throw new CoreException(status);
    }

    public static void addNature(IProject project) throws CoreException {
        if (!project.hasNature(HumanTaskNature.NATURE_ID)) {
            IProjectDescription description = project.getDescription();
            String[] prevNatures = description.getNatureIds();
            String[] newNatures = new String[prevNatures.length + 1];
            System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
            newNatures[prevNatures.length] = HumanTaskNature.NATURE_ID;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);
        }
    }
}
