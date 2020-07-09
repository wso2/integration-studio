/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.apache.synapse.mediators.template.TemplateParam;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.MediatorFactoryUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class CloudConnectorDirectoryTraverser {

    private static final String synapseNS = "http://ws.apache.org/ns/synapse";
    private static final String connectorFileName = "connector.xml";
    private static final String componentFileName = "component.xml";
    private static final String inputSchemaFolderName = "input_schema";
    private static final String outputSchemaFolderName = "output_schema";
    private static final String initFileName = "init.xml";
    private static final String DIR_DOT_METADATA = ".metadata";
    public static final String connectorPathFromWorkspace = DIR_DOT_METADATA + File.separator + ".Connectors";
    private Properties properties = new Properties();
    private static String rootDirectory = null;
    private static CloudConnectorDirectoryTraverser instance = null;
    private Connector connector = null;
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /*
     * Private Constructor
     */
    private CloudConnectorDirectoryTraverser() {
    }

    /*
     * static method for creating an instance of this class
     */
    public static CloudConnectorDirectoryTraverser getInstance(String file) {
        rootDirectory = file;
        if (instance == null) {
            instance = new CloudConnectorDirectoryTraverser();
        }
        return instance;
    }

    public static CloudConnectorDirectoryTraverser getInstance() {
        if (instance == null) {
            instance = new CloudConnectorDirectoryTraverser();
        }
        return instance;
    }

    private void deserializeConnectorXML() throws Exception {
        File artifactsFile = new File(rootDirectory + File.separator + connectorFileName);
        String artifactsContent = FileUtils.getContentAsString(artifactsFile);
        connector = new Connector();
        connector.deserialize(artifactsContent);
    }

    private TemplateMediator readTemplateConfiguration(String fileLocation) throws IOException, XMLStreamException {
        String path = fileLocation;
        String source = FileUtils.getContentAsString(new File(path));
        OMElement element = AXIOMUtil.stringToOM(source);
        TemplateMediator templateMediator = null;

        if (element.getFirstChildWithName(new QName(synapseNS, "sequence", null)) != null) {
            MediatorFactoryUtils.registerFactories();
            TemplateMediatorFactory templateMediatorFactory = new TemplateMediatorFactory();
            templateMediator = (TemplateMediator) templateMediatorFactory.createMediator(element, properties);
        }
        return templateMediator;
    }

    public Collection<TemplateParam> getCloudConnectorConfigurationParameters() throws Exception {
        return readTemplateConfiguration(getConfigurationFileLocation(getOperationFileNamesMap())).getParameters();
    }

    public String getCloudConnectorOperationInputSchemaFilePath(String connectorOperation) throws Exception {
        Map<String, String> operationFileNames = getOperationFileNamesMap();
        return rootDirectory + File.separator + operationFileNames.get(connectorOperation) + File.separator
                + inputSchemaFolderName + File.separator + connectorOperation + ".json";
    }

    public String getCloudConnectorOperationOutputSchemaFilePath(String connectorOperation) throws Exception {
        Map<String, String> operationFileNames = getOperationFileNamesMap();
        return rootDirectory + File.separator + operationFileNames.get(connectorOperation) + File.separator
                + outputSchemaFolderName + File.separator + connectorOperation + ".json";
    }

    public boolean validate(IWorkspace workspace) {
        try {
            String connectorDirectory = workspace.getRoot().getLocation().toOSString() + File.separator
                    + CloudConnectorDirectoryTraverser.connectorPathFromWorkspace;
            File directory = new File(connectorDirectory);
            List<String> errorList = new ArrayList<String>();
            boolean foundConnectors = false;
            if (directory.isDirectory() && directory.listFiles().length > 0) {
                File[] children = directory.listFiles();
                for (int i = 0; i < children.length; ++i) {
                    if (children[i].isDirectory()) {
                        foundConnectors = true;
                        String connectorPath = connectorDirectory + File.separator + children[i].getName();
                        try {
                            File artifactsFile = new File(connectorPath + File.separator + connectorFileName);
                            String artifactsContent = FileUtils.getContentAsString(artifactsFile);
                            connector = new Connector();
                            connector.deserialize(artifactsContent);

                            if (!connector.getConnectorName().equals(children[i].getName().split("-")[0])) {
                                log.error("Connector directory name, \'" + children[i].getName() + "\',"
                                        + " doesn't match with the connector name \'" + connector.getConnectorName() + "\'.");
                                errorList.add("Connector directory name, \'" + children[i].getName() + "\',"
                                        + " doesn't match with the connector name \'" + connector.getConnectorName()
                                        + "\'. Valid connector should have the 'name-connector-1.0.0' format");
                                FileUtils.deleteDirectories(connectorPath);
                                continue;
                            }

                            if (new File(connectorPath 
                                    + File.separator + "icon" + File.separator + "icon-small.gif").exists() || 
                                new File(connectorPath 
                                    + File.separator + "icon" + File.separator + "icon-small.png").exists()
                                && new File(
                                     connectorPath + File.separator + "icon" + File.separator + "icon-large.gif")
                                         .exists() ||
                                     new File(connectorPath + File.separator + "icon" + File.separator 
                                             + "icon-large.png").exists()) {
                                CloudConnectorDirectoryTraverser.getInstance(connectorPath).getOperationsMap();
                            } else {
                                log.error("Missing icons files of " + children[i].getName());
                                errorList.add("Missing icons files of " + children[i].getName());
                                FileUtils.deleteDirectories(connectorPath);
                            }
                        } catch (Exception e) {
                            FileUtils.deleteDirectories(connectorPath);
                            log.error("Error while loading the connector due to  " + e.getMessage(), e);
                            errorList.add("Error while loading the connector due to  " + e.getMessage());
                        }
                    }
                }
            } else {
                return false;
            }

            if (foundConnectors) {
                if (errorList.isEmpty()) {
                    return true;
                } else {
                    String message = "";
                    for (String errorMessgae : errorList) {
                        message = message + errorMessgae + "\n";
                    }
                    MessageDialog.openWarning(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                            "Connector loading error", message);
                    return false;
                }

            }
            return false;

        } catch (Exception e) {
            log.error("Error while validating the connectors", e);
            return false;
        }
    }

    public boolean validate(IProject activeProject) {
        return validate(activeProject.getWorkspace());
    }

    /**
     * Returning Operations map in the Cloud Connector zip. This map contains
     * the name of the component name and the file name of the operation.
     *
     * @return
     * @throws Exception
     */

    public Map<String, String> getOperationFileNamesMap() throws Exception {
        Map<String, String> operationFileNamesMap = new HashMap<String, String>();
        deserializeConnectorXML();
        for (Dependency dependency : connector.getComponentDependencies()) {
            String pathname = rootDirectory + File.separator + dependency.getComponent();
            File artifactFile = new File(pathname + File.separator + componentFileName);
            String artifactContent = FileUtils.getContentAsString(artifactFile);
            Component subComponent = new Component();
            subComponent.deserialize(artifactContent);
            for (SubComponents subComponents : subComponent.getSubComponents()) {
                operationFileNamesMap.put(subComponents.getFileName(), dependency.getComponent());
            }
        }
        return operationFileNamesMap;
    }

    /**
     * Returning Operations map in the Cloud Connector zip. This map contains
     * the name of the operation and the file name of the operation.
     *
     * @return
     * @throws Exception
     */

    public Map<String, String> getOperationsMap() throws Exception {
        Map<String, String> operationNamesAndFileNamesMap = new HashMap<String, String>();
        deserializeConnectorXML();
        for (Dependency dependency : connector.getComponentDependencies()) {
            String pathname = rootDirectory + File.separator + dependency.getComponent();
            File artifactFile = new File(pathname + File.separator + componentFileName);
            String artifactContent = FileUtils.getContentAsString(artifactFile);
            Component subComponent = new Component();
            subComponent.deserialize(artifactContent);
            for (SubComponents subComponents : subComponent.getSubComponents()) {
                if (subComponents.getHidden().equals("false")) {
                    operationNamesAndFileNamesMap.put(subComponents.getName(), subComponents.getFileName());
                }
            }

        }
        return operationNamesAndFileNamesMap;
    }

    /**
     * Returning Operations map in the Cloud Connector zip. This map contains
     * the name of the operation and the name of the cloud connector component.
     *
     * @return
     * @throws Exception
     */

    public Map<String, String> getOperationsConnectorComponentNameMap() throws Exception {
        Map<String, String> operationNamesAndConnectorComponentNameMap = new HashMap<String, String>();
        deserializeConnectorXML();
        for (Dependency dependency : connector.getComponentDependencies()) {
            String pathname = rootDirectory + File.separator + dependency.getComponent();
            File artifactFile = new File(pathname + File.separator + componentFileName);
            String artifactContent = FileUtils.getContentAsString(artifactFile);
            Component subComponent = new Component();
            subComponent.deserialize(artifactContent);
            for (SubComponents subComponents : subComponent.getSubComponents()) {
                operationNamesAndConnectorComponentNameMap.put(subComponents.getName(), connector.getConnectorName());
            }

        }
        return operationNamesAndConnectorComponentNameMap;
    }

    /**
     * Returning Operations map in the Cloud Connector zip. This map contains
     * the name of the operation and the Load class name of the operation for
     * input.
     *
     * @return
     * @throws Exception
     */

    public Map<String, String> getOperationsInputLoadClassesMap() throws Exception {
        Map<String, String> operationNamesAndInputLoadClassesMap = new HashMap<String, String>();
        deserializeConnectorXML();
        for (Dependency dependency : connector.getComponentDependencies()) {
            String pathname = rootDirectory + File.separator + dependency.getComponent();
            File artifactFile = new File(pathname + File.separator + componentFileName);
            String artifactContent = FileUtils.getContentAsString(artifactFile);
            ComponentLoadClassInput subComponent = new ComponentLoadClassInput();
            subComponent.deserialize(artifactContent);
            for (SubComponents subComponents : subComponent.getSubComponents()) {
                operationNamesAndInputLoadClassesMap.put(subComponents.getName(), subComponents.getFileName());
            }

        }
        return operationNamesAndInputLoadClassesMap;
    }

    /**
     * Returning Operations map in the Cloud Connector zip. This map contains
     * the name of the operation and the Load class name of the operation for
     * output.
     *
     * @return
     * @throws Exception
     */

    public Map<String, String> getOperationsOutputLoadClassesMap() throws Exception {
        Map<String, String> operationNamesAndOutputLoadClassesMap = new HashMap<String, String>();
        deserializeConnectorXML();
        for (Dependency dependency : connector.getComponentDependencies()) {
            String pathname = rootDirectory + File.separator + dependency.getComponent();
            File artifactFile = new File(pathname + File.separator + componentFileName);
            String artifactContent = FileUtils.getContentAsString(artifactFile);
            ComponentLoadClassOutput subComponent = new ComponentLoadClassOutput();
            subComponent.deserialize(artifactContent);
            for (SubComponents subComponents : subComponent.getSubComponents()) {
                operationNamesAndOutputLoadClassesMap.put(subComponents.getName(), subComponents.getFileName());
            }

        }
        return operationNamesAndOutputLoadClassesMap;
    }

    /**
     * Returning Operations map in the Cloud Connector zip. This map contains
     * the name of the operation and whether the operation is dynamic or not.
     *
     * @return
     * @throws Exception
     */

    public Map<String, String> getOperationsIsDynamicMap() throws Exception {
        Map<String, String> operationNamesAndLoadClassesMap = new HashMap<String, String>();
        deserializeConnectorXML();
        for (Dependency dependency : connector.getComponentDependencies()) {
            String pathname = rootDirectory + File.separator + dependency.getComponent();
            File artifactFile = new File(pathname + File.separator + componentFileName);
            String artifactContent = FileUtils.getContentAsString(artifactFile);
            ComponentIsDynamic subComponent = new ComponentIsDynamic();
            subComponent.deserialize(artifactContent);
            for (SubComponents subComponents : subComponent.getSubComponents()) {
                operationNamesAndLoadClassesMap.put(subComponents.getName(), subComponents.getFileName());
            }

        }
        return operationNamesAndLoadClassesMap;
    }

    /**
     * Returning the Class name for the operation for input in the Cloud
     * Connector zip.
     *
     * @return
     * @throws Exception
     */

    public String getCloudConnectorOperationInputLoadClass(String connectorOperation) throws Exception {
        if (getOperationsInputLoadClassesMap().containsKey(connectorOperation)) {
            String operationInputLoadClassName = getOperationsInputLoadClassesMap().get(connectorOperation);
            return operationInputLoadClassName;
        } else {
            return "";
        }
    }

    /**
     * Returning the Class name for the operation for output in the Cloud
     * Connector zip.
     *
     * @return
     * @throws Exception
     */

    public String getCloudConnectorOperationOutputLoadClass(String connectorOperation) throws Exception {
        if (getOperationsOutputLoadClassesMap().containsKey(connectorOperation)) {
            String operationOutputLoadClassName = getOperationsOutputLoadClassesMap().get(connectorOperation);
            return operationOutputLoadClassName;
        } else {
            return "";
        }
    }

    /**
     * Returning whether the operation is dynamic or not in the Cloud Connector
     * zip.
     *
     * @return
     * @throws Exception
     */

    public String getCloudConnectorOperationIsDynamic(String connectorOperation) throws Exception {
        if (getOperationsIsDynamicMap().containsKey(connectorOperation)) {
            String operationIsDynamic = getOperationsIsDynamicMap().get(connectorOperation);
            return operationIsDynamic;
        } else {
            return "";
        }
    }
    
    public String getConnectorType() {
        return connector.getConnectorType();
    }

    public String getCloudConnectorName() {
        try {
            deserializeConnectorXML();
        } catch (Exception e) {
            log.error("Error while deserializing the connector", e);
        }
        return connector.getConnectorName();
    }

    public String getCloudConnectorAuthenticationInfo() {
        try {
            deserializeConnectorXML();
        } catch (Exception e) {
            log.error("Error while deserializing the connector", e);
        }
        return connector.getAuthenticationInfo();
    }

    public String getConfigurationFileLocation(Map<String, String> artifactsMap) throws Exception {
        return rootDirectory + File.separator + artifactsMap.get("init") + File.separator + initFileName;
    }

    /**
     * Get connector directory path from connector name.
     *
     * @param workspacePath
     * @param connectorName
     * @return
     */
    public String getConnectorDirectoryPathFromConnectorName(String workspacePath, String connectorName) {
        String connectorDirectoryPath = null;
        workspacePath += File.separator + connectorPathFromWorkspace;
        File directory = new File(workspacePath);
        if (directory.isDirectory()) {
            File[] children = directory.listFiles();
            for (int i = 0; i < children.length; ++i) {
                if (children[i].isDirectory() && connectorName.equalsIgnoreCase(children[i].getName().split("-")[0])) {
                    return children[i].getAbsolutePath();
                }
            }
        }
        return connectorDirectoryPath;
    }

    /**
     * Get all possible parameters of the given connector operation.
     *
     * @param addedConnector
     * @param addedOperation
     * @return
     */
    public Collection<String> getAllParametersOfConnectorOperation(String addedConnector, String addedOperation) {
        String directory = null;
        String operationFileName = null;
        List<String> parameters = new ArrayList<String>();

        IProject activeProject = EditorUtils.getActiveProject();
        String connectorPath = getConnectorDirectoryPathFromConnectorName(
                activeProject.getWorkspace().getRoot().getLocation().toOSString(), addedConnector);
        CloudConnectorDirectoryTraverser cloudConnectorDirectoryTraverser = CloudConnectorDirectoryTraverser
                .getInstance(connectorPath);

        try {
            operationFileName = cloudConnectorDirectoryTraverser.getOperationsMap().get(addedOperation);
            directory = cloudConnectorDirectoryTraverser.getOperationFileNamesMap().get(operationFileName);
        } catch (Exception e1) {
            log.error("Error while retrieving data for connector", e1);
        }
        String path = connectorPath + File.separator + directory + File.separator + operationFileName + ".xml";

        try {
            String source = FileUtils.getContentAsString(new File(path));
            OMElement element = AXIOMUtil.stringToOM(source);

            if (element.getFirstChildWithName(new QName(synapseNS, "sequence", null)) != null) {
                Iterator iterator = element.getChildrenWithLocalName("parameter");
                while (iterator.hasNext()) {
                    OMElement parameterElement = (OMElement) iterator.next();
                    Iterator attributeIterator = parameterElement.getAllAttributes();
                    while (attributeIterator.hasNext()) {
                        OMAttribute attribute = (OMAttribute) attributeIterator.next();
                        if (attribute.getLocalName().equals("name")) {
                            parameters.add(attribute.getAttributeValue());
                            break;
                        }
                    }
                }
            }
        } catch (XMLStreamException e) {
            log.error("Error occurred while parsing selected template file", e);
        } catch (IOException e) {
            log.error("Error occurred while reading selected template file", e);
        }

        return parameters;
    }

    public Map<String, String> getInputDefaultParameterValuesMap(String connectorOperation) {
        Map<String, String> operationFileNames;
        try {
            operationFileNames = getOperationFileNamesMap();
        } catch (Exception e) {
            log.error("Error getting operations file map", e);
            return null;
        }
        String mappingPropertiesFilePath = rootDirectory + File.separator + operationFileNames.get(connectorOperation)
                + File.separator + inputSchemaFolderName + File.separator + connectorOperation + ".properties";

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(mappingPropertiesFilePath));
        } catch (IOException e) {
            log.error("Error getting operations file map", e);
            return null;
        }

        Map<String, String> propertiesMap = new HashMap<String, String>();

        for (Entry<Object, Object> property : properties.entrySet()) {
            propertiesMap.put((String) property.getKey(), (String) property.getValue());
        }

        return propertiesMap;
    }

}
