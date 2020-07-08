/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.Activator;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.CommonArtifactDataNode;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.RegistryResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.propertytester.UnitTestResourceTester;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * Class responsible for create resource tree.
 */
public class DependencyTree {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private TreeEditor editor;
    private Tree trDependencies;
    private SynapseUnitTest unitTestDataHolder;
    private String treeType;
    private IProject selectedProject;
    private Map<IPath, String> childElements = new HashMap<IPath, String>();
    private Map<IPath, String> connectorElements = new HashMap<IPath, String>();
    private Map<String, RegistryResource> registryElements = new HashMap<String, RegistryResource>();

    private String[] acceptTestArtifactFolders = { "api", "sequences", "proxy-services" };
    private String[] acceptSupportiveArtifactFolders = { "api", "proxy-services", "sequences", "endpoints",
            "local-entries", "templates" };
    private String childTreeItemIcon = "/icons/artifact.png";
    private String parentTreeItemIcon = "/icons/root-folder.png";
    private String parentRegistryTreeItemIcon = "/icons/registry_project.png";
    private String parentConnectorTreeItemIcon = "/icons/connector_project.png";

    /**
     * Class constructor.
     */
    public DependencyTree(SynapseUnitTest unitTestData, IProject project, String archType) {
        this.unitTestDataHolder = unitTestData;
        this.treeType = archType;
        this.selectedProject = project;
    }

    /**
     * Method of creating resource tree view.
     * 
     * @param parent
     *            composite layout
     * @param mainTitle
     *            main title of the tree
     * @return Tree widget
     */
    public Tree createResourcesTree(Composite parent, String mainTitle) {
        trDependencies = new Tree(parent, SWT.CHECK | SWT.V_SCROLL | SWT.BORDER);
        trDependencies.setHeaderVisible(true);

        TreeColumn trclmnArtifact = new TreeColumn(trDependencies, SWT.NONE);
        trclmnArtifact.setWidth(200);
        trclmnArtifact.setText(mainTitle);

        TreeColumn trclmnLocation = new TreeColumn(trDependencies, SWT.NONE);
        trclmnLocation.setWidth(410);
        trclmnLocation.setText("Location");

        editor = new TreeEditor(trDependencies);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;

        if (mainTitle.equals("Test Artifacts")) {
            createProjectTreeContent();
        } else {
            createTreeContent();
        }
        expandParentNodes();

        return trDependencies;
    }

    /**
     * Method of expanding the created tree parent items.
     */
    public void expandParentNodes() {
        for (final TreeItem item : trDependencies.getItems()) {
            item.setExpanded(true);
        }
    }

    /**
     * Method of creating tree contents for all projects.
     */
    public void createTreeContent() {
        trDependencies.removeAll();
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject[] projects = workspaceRoot.getProjects();

        // iterate through all projects in the workspace
        for (IProject project : projects) {
            childElements.clear();
            registryElements.clear();
            connectorElements.clear();

            try {
                if (project.isOpen() && project instanceof IProject
                        && (project.hasNature(Constants.ESB_PROJECT_NATURE)
                                || project.hasNature(Constants.REGISTRY_PROJECT_NATURE)
                        || project.hasNature(Constants.CONNECTOR_PROJECT_NATURE))) {
                    if (treeType.equals(Constants.SUPPORTIVE_ARTIFACT_TYPE)) {
                        processContainerChilds(project);
                    } else if (treeType.equals(Constants.MOCK_SERVICE_TYPE)) {
                        getContainerMockServices(project);
                    }

                    TreeItem parentNode = null;
                    if (childElements.size() > 0) {
                        parentNode = createNode(trDependencies, project, Constants.ESB_PROJECT);
                    }
                    if (registryElements.size() > 0) {
                        parentNode = createNode(trDependencies, project, Constants.REGISTRY_PROJECT);
                    }
                    if (connectorElements.size() > 0) {
                        parentNode = createNode(trDependencies, project, Constants.CONNECTOR_PROJECT);
                    }

                    if (childElements.size() > 0) {
                        for (Map.Entry<IPath, String> child : childElements.entrySet()) {
                            createNode(parentNode, child);
                        }
                    }
                    if (registryElements.size() > 0) {
                        for (Map.Entry<String, RegistryResource> child : registryElements.entrySet()) {
                            createRegistryNode(parentNode, child);
                        }
                    }
                    if (connectorElements.size() > 0) {
                        for (Map.Entry<IPath, String> child : connectorElements.entrySet()) {
                            createConnectorNode(parentNode, child);
                        }
                    }
                    updateCheckState(parentNode);
                }
            } catch (CoreException e) {
                log.error("CoreException while creating nodes in resource tree", e);
            }
        }
        trDependencies.layout();
    }

    /**
     * Method of creating tree contents for a projects.
     */
    public void createProjectTreeContent() {
        trDependencies.removeAll();
        childElements.clear();

        try {
            if (selectedProject.hasNature(Constants.ESB_PROJECT_NATURE)) {
                for (String folder : acceptTestArtifactFolders) {
                    TreeItem parentNode = null;
                    processFolderContainerChilds(selectedProject, folder);

                    if (childElements.size() > 0) {
                        parentNode = createParentNode(trDependencies,
                                selectedProject.getName() + File.separator + folder);
                    }

                    if (childElements.size() > 0) {
                        for (Map.Entry<IPath, String> child : childElements.entrySet()) {
                            createNode(parentNode, child);
                        }
                    }
                    updateCheckState(parentNode);
                    childElements.clear();
                }
            }
        } catch (CoreException e) {
            log.error("CoreException while creating nodes in resource tree", e);
        }

        trDependencies.layout();
    }

    /**
     * Method of creating tree child items as nodes.
     * 
     * @param parent
     *            parent tree node
     * @param child
     *            list of children
     * @param available
     *            status
     */
    private TreeItem createNode(TreeItem parent, Map.Entry<IPath, String> child) {
        TreeItem item = new TreeItem(parent, SWT.NONE);
        String childName = child.getValue();
        String childLocation = child.getKey().toOSString();

        item.setText(0, childName);
        item.setText(1, childLocation);
        CommonArtifactDataNode nodeData = new CommonArtifactDataNode(child);
        item.setData(nodeData);
        item.setImage(0, SWTResourceManager.getImage(this.getClass(), childTreeItemIcon));

        return item;
    }

    /**
     * Method of creating tree registry child items as nodes.
     * 
     * @param parent
     *            parent tree node
     * @param child
     *            list of children
     * @param available
     *            status
     */
    private TreeItem createRegistryNode(TreeItem parent, Map.Entry<String, RegistryResource> child) {
        TreeItem item = new TreeItem(parent, SWT.NONE);
        String childName = child.getValue().getFileName();
        String childLocation = child.getValue().getFilePath();

        item.setText(0, childName);
        item.setText(1, childLocation);
        CommonArtifactDataNode nodeData = new CommonArtifactDataNode(child, Constants.REGISTRY_PROJECT);
        item.setData(nodeData);
        item.setImage(0, SWTResourceManager.getImage(this.getClass(), childTreeItemIcon));

        return item;
    }

    /**
     * Method of creating tree connector child items as nodes.
     * 
     * @param parent
     *            parent tree node
     * @param child
     *            list of children
     * @param available
     *            status
     */
    private TreeItem createConnectorNode(TreeItem parent, Map.Entry<IPath, String> child) {
        TreeItem item = new TreeItem(parent, SWT.NONE);
        String childName = child.getValue();
        String childLocation = child.getKey().toOSString();

        item.setText(0, childName);
        item.setText(1, childLocation);
        CommonArtifactDataNode nodeData = new CommonArtifactDataNode(child, Constants.CONNECTOR_PROJECT);
        item.setData(nodeData);
        item.setImage(0, SWTResourceManager.getImage(this.getClass(), childTreeItemIcon));

        return item;
    }

    /**
     * Method of creating tree child items as nodes.
     * 
     * @param parent
     *            parent tree node
     * @param project
     *            project data
     */
    private TreeItem createNode(Tree parent, final IProject project, String projectType) {
        TreeItem item = new TreeItem(parent, SWT.NONE);

        try {
            item.setText(0, project.getName());
            CommonArtifactDataNode nodeData = new CommonArtifactDataNode(project);
            item.setData(project);

            nodeData.setHasChildren(true);
            item.setData(nodeData);

            if (projectType.equals(Constants.ESB_PROJECT)) {
                item.setImage(0, SWTResourceManager.getImage(this.getClass(), parentTreeItemIcon));
            } else if (projectType.equals(Constants.REGISTRY_PROJECT)) {
                item.setImage(0, SWTResourceManager.getImage(this.getClass(), parentRegistryTreeItemIcon));
            } else if (projectType.equals(Constants.CONNECTOR_PROJECT)) {
                item.setImage(0, SWTResourceManager.getImage(this.getClass(), parentConnectorTreeItemIcon));
            }
        } catch (Exception e) {
            return null;
        }
        return item;
    }

    /**
     * Method of creating tree parent items as nodes.
     * 
     * @param parent
     *            parent tree node
     * @param folder
     *            parent folder
     */
    private TreeItem createParentNode(Tree parent, String folder) {
        TreeItem item = new TreeItem(parent, SWT.NONE);

        try {
            item.setText(0, folder);
            CommonArtifactDataNode nodeData = new CommonArtifactDataNode(folder);
            item.setData(folder);

            nodeData.setHasChildren(true);
            item.setData(nodeData);
            item.setImage(0, SWTResourceManager.getImage(this.getClass(), parentTreeItemIcon));

        } catch (Exception e) {
            return null;
        }
        return item;
    }

    /**
     * Method of updating checked status of tree items.
     * 
     * @param item
     *            selected tree item
     */
    private void updateCheckState(TreeItem item) {
        if (item != null) {
            TreeItem[] subItems = item.getItems();
            int i = 0;
            for (TreeItem subItem : subItems) {
                if (subItem.getChecked()) {
                    i++;
                }
            }
            if (i == item.getItemCount()) {
                item.setGrayed(false);
                item.setChecked(true);
            } else if (i < item.getItemCount() && i > 0) {
                item.setChecked(true);
                item.setGrayed(true);

            } else {
                item.setGrayed(false);
                item.setChecked(false);
            }
        }
    }

    /**
     * Method of processing container child for workspace projects.
     * 
     * @param container
     *            project as a container
     */
    private void processContainerChilds(IContainer container) {
        try {
            if (container.getProject().hasNature(Constants.REGISTRY_PROJECT_NATURE)) {
                addRegistryElements(container);
            } else if (container.getProject().hasNature(Constants.CONNECTOR_PROJECT_NATURE)) {
                addConnectorElements(container);
            } else {
                IResource[] members = container.members();
                for (IResource member : members) {
                    if (member instanceof IContainer) {
                        processContainerChilds((IContainer) member);
                    } else if (member instanceof IFile
                            && member.getFileExtension().toLowerCase().equals(Constants.XML_EXTENSION)
                            && validArtifact((IFile) member)) {
                        childElements.put(member.getFullPath(), member.getName());
                    }
                }
            }
        } catch (CoreException e) {
            log.error("CoreException error while adding child elements", e);
        }
    }

    /**
     * Method of processing container child for selected project.
     * 
     * @param project
     *            project data
     */
    private void processFolderContainerChilds(IProject project, String folder) {
        try {
            IFolder currentFolder = project.getFolder(
                    "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + folder);
            IResource[] members = currentFolder.members();
            for (IResource member : members) {
                if (member instanceof IFile) {
                    childElements.put(member.getFullPath(), member.getName());
                }
            }
        } catch (CoreException e) {
            log.error("CoreException error while adding child elements", e);
        }
    }

    /**
     * Method of checking file is a valid artifact file for the domian.
     * 
     * @param childElement
     *            file details
     * @return valid or not
     */
    private boolean validArtifact(IFile childElement) {
        String childPath = childElement.getFullPath().toOSString();
        String fileSeperatePattern = Pattern.quote(System.getProperty(Constants.FILE_SEPERATOR));
        String[] pathTypes = childPath.split(fileSeperatePattern);
        String folderType = pathTypes[pathTypes.length - 2];
        String selectedFile = unitTestDataHolder.getTestArtifact();
        if (selectedFile == null) {
            selectedFile = UnitTestResourceTester.getSelectedFilePath();
        }

        if (childPath.equals(selectedFile) || childPath.equals(unitTestDataHolder.getTestArtifact())) {
            return false;
        } else {
            return Arrays.stream(acceptSupportiveArtifactFolders).anyMatch(folderType::equals);
        }
    }

    /**
     * Method of getting mock services resources.
     * 
     * @param container
     *            projects as a container
     */
    private void getContainerMockServices(IContainer container) {
        try {
            if (container.getProject().hasNature(Constants.ESB_PROJECT_NATURE)) {
                IFolder mockServiceFolder = container.getFolder(new Path("test/resources/mock-services"));
                IResource[] members = mockServiceFolder.members();

                for (IResource member : members) {
                    if (member instanceof IFile && (member.getFileExtension().equals(Constants.XML_EXTENSION))) {
                        childElements.put(member.getFullPath(), member.getName());
                    }
                }
            }
        } catch (CoreException e) {
            log.error("CoreException error while adding mock child elements", e);
        }
    }

    /**
     * Method of selecting test artifact file from resource tree. Check whether it a
     * project or a file Enable the single checked for whole tree items
     * 
     * @param item
     *            selected tree item
     */
    public void selectArtifactFile(TreeItem item) {
        handleTreeSingleItemChecked(item);

        for (TreeItem parentItem : trDependencies.getItems()) {
            if (parentItem != null) {
                parentItem.setChecked(false);
                for (final TreeItem currentItem : parentItem.getItems()) {
                    currentItem.setChecked(false);;
                }
            }
        }

        for (final TreeItem parentItem : trDependencies.getItems()) {
            if (parentItem != null) {
                for (final TreeItem currentItem : parentItem.getItems()) {
                    String itemPath = currentItem.getText(1);

                    if (unitTestDataHolder.getTestArtifact().equals(itemPath)) {
                        item.setChecked(true);
                        break;
                    }
                }
                parentItem.setChecked(false);
            }
        }
    }

    /**
     * Method of coloring selected items with parent node
     * 
     * @param item
     *            selected tree item
     */
    public void handleTreeItemChecked(TreeItem item) {
        boolean select = item.getChecked();
        boolean isRegistryResource = false;
        boolean isConnectorResource = false;
        if (item.getText(1).startsWith("/_system/")) {
            isRegistryResource = true;
        }
        if (item.getText(1).endsWith(Constants.ZIP_EXTENSION)) {
            isConnectorResource = true;
        }

        CommonArtifactDataNode nodeData = (CommonArtifactDataNode) item.getData();
        nodeData.setRegistryDataNode(isRegistryResource);
        nodeData.setConnectorDataNode(isConnectorResource);

        if (nodeData.hasChildren()) {
            TreeItem[] subItems = item.getItems();
            if (select) {
                for (TreeItem subitem : subItems) {
                    if (!subitem.getChecked()) {
                        CommonArtifactDataNode subNodeData = (CommonArtifactDataNode) subitem.getData();
                        if (subitem.getText(1).startsWith("/_system/")) {
                            isRegistryResource = true;
                        }
                        if (subitem.getText(1).endsWith(Constants.ZIP_EXTENSION)) {
                            isConnectorResource = true;
                        }
                        subNodeData.setRegistryDataNode(isRegistryResource);
                        subNodeData.setConnectorDataNode(isConnectorResource);
                        subitem.setChecked(true);
                        addDependency(subNodeData);
                    }
                }
            } else {
                for (TreeItem subitem : subItems) {
                    if (subitem.getChecked()) {
                        subitem.setChecked(false);
                        CommonArtifactDataNode subNodeData = (CommonArtifactDataNode) subitem.getData();
                        if (subitem.getText(1).startsWith("/_system/")) {
                            isRegistryResource = true;
                        }
                        if (subitem.getText(1).endsWith(Constants.ZIP_EXTENSION)) {
                            isConnectorResource = true;
                        }
                        subNodeData.setRegistryDataNode(isRegistryResource);
                        subNodeData.setConnectorDataNode(isConnectorResource);
                        removeDependency(subNodeData);
                    }
                }
            }
            updateCheckState(item);
        } else {
            TreeItem parentItem = item.getParentItem();
            if (select) {
                addDependency(nodeData);
            } else {
                removeDependency(nodeData);
            }
            updateCheckState(parentItem);
        }
    }

    /**
     * Method of coloring selected item with parent node
     * 
     * @param item
     *            selected tree item
     */
    public void handleTreeSingleItemChecked(TreeItem item) {
        boolean select = item.getChecked();
        CommonArtifactDataNode nodeData = (CommonArtifactDataNode) item.getData();
        if (!nodeData.hasChildren()) {
            TreeItem parentItem = item.getParentItem();
            if (select) {
                addDependency(nodeData);
            } else {
                removeDependency(nodeData);
            }
            updateCheckState(parentItem);
        } else {
            removeDependency(nodeData);
        }
    }

    /**
     * Method of removing item from the dependency list
     * 
     * @param nodeData
     *            selected node
     */
    private void removeDependency(CommonArtifactDataNode nodeData) {
        if (nodeData.isRegistryDataNode()) {
            RegistryResource resource = nodeData.getRegistryDataNode().getValue();
            unitTestDataHolder.getRegistryResource().remove(resource.getFileName());
        } else if (nodeData.isConnectorDataNode()) {
            Map.Entry<IPath, String> child = nodeData.getArtifact();
            String artifactPath = child.getKey().toOSString();
            if (unitTestDataHolder.getConnectorFiles().stream().anyMatch(str -> str.trim().equals(artifactPath))) {
                unitTestDataHolder.getConnectorFiles().remove(artifactPath);
            }
        } else {
            Map.Entry<IPath, String> child = nodeData.getArtifact();
            String artifactPath = child.getKey().toOSString();
            if (treeType.equals(Constants.SUPPORTIVE_ARTIFACT_TYPE)) {
                if (unitTestDataHolder.getSupportiveArtifacts().stream()
                        .anyMatch(str -> str.trim().equals(artifactPath))) {
                    unitTestDataHolder.getSupportiveArtifacts().remove(artifactPath);
                }
            } else if (treeType.equals(Constants.MOCK_SERVICE_TYPE)) {
                if (unitTestDataHolder.getMockServices().stream().anyMatch(str -> str.trim().equals(artifactPath))) {
                    unitTestDataHolder.getMockServices().remove(artifactPath);
                }
            } else if (treeType.equals(Constants.TEST_ARTIFACT_TYPE)) {
                unitTestDataHolder.setTestArtifact("");
            }
        }
    }

    /**
     * Method of adding item to the dependency list
     * 
     * @param nodeData
     *            selected node
     */
    private void addDependency(CommonArtifactDataNode nodeData) {
        if (nodeData.isRegistryDataNode()) {
            RegistryResource resource = nodeData.getRegistryDataNode().getValue();
            unitTestDataHolder.addRegistryResource(resource);
        } else if (nodeData.isConnectorDataNode()) {
            Map.Entry<IPath, String> child = nodeData.getArtifact();
            String artifactPath = child.getKey().toOSString();
            if (!unitTestDataHolder.getConnectorFiles().stream().anyMatch(str -> str.trim().equals(artifactPath))) {
                unitTestDataHolder.getConnectorFiles().add(artifactPath);
            }
        } else {
            Map.Entry<IPath, String> child = nodeData.getArtifact();
            String artifactPath = child.getKey().toOSString();

            if (treeType.equals(Constants.SUPPORTIVE_ARTIFACT_TYPE)) {
                if (!unitTestDataHolder.getSupportiveArtifacts().stream()
                        .anyMatch(str -> str.trim().equals(artifactPath))) {
                    unitTestDataHolder.getSupportiveArtifacts().add(artifactPath);
                }
            } else if (treeType.equals(Constants.MOCK_SERVICE_TYPE)) {
                if (!unitTestDataHolder.getMockServices().stream().anyMatch(str -> str.trim().equals(artifactPath))) {
                    unitTestDataHolder.getMockServices().add(artifactPath);
                }
            } else if (treeType.equals(Constants.TEST_ARTIFACT_TYPE)) {
                unitTestDataHolder.setTestArtifact(artifactPath);
            }
        }
    }

    /**
     * Method of coloring already selected tree items.
     * 
     * @param dependencyList
     *            already selected item list
     */
    public void setCheckedElemets(List<String> dependencyList) {
        for (final TreeItem parentItem : trDependencies.getItems()) {
            if (parentItem != null) {
                for (final TreeItem item : parentItem.getItems()) {
                    item.setChecked(false);
                }
            }
        }

        for (final TreeItem parentItem : trDependencies.getItems()) {
            if (parentItem != null) {
                for (final TreeItem item : parentItem.getItems()) {
                    String itemPath = item.getText(1);

                    if (dependencyList.stream().anyMatch(str -> str.trim().equals(itemPath))) {
                        item.setChecked(true);
                    }
                }
            }
        }
    }

    /**
     * Method of coloring already selected registry tree items.
     * 
     * @param registryList
     *            already selected registry item list
     */
    public void setRegistryCheckedElemets(LinkedHashMap<String, RegistryResource> registryList) {
        for (final TreeItem parentItem : trDependencies.getItems()) {
            if (parentItem != null) {
                for (final TreeItem item : parentItem.getItems()) {
                    String itemName = item.getText(0);

                    if (registryList.containsKey(itemName)) {
                        item.setChecked(true);
                    }
                }
            }
        }
    }

    /**
     * Method of coloring already selected connector tree items.
     * 
     * @param connectorList
     *            already selected connector item list
     */
    public void setConnectorCheckedElemets(List<String> connectorList) {
        for (final TreeItem parentItem : trDependencies.getItems()) {
            if (parentItem != null) {
                for (final TreeItem item : parentItem.getItems()) {
                    String itemPath = item.getText(1);

                    if (connectorList.stream().anyMatch(str -> str.trim().equals(itemPath))) {
                        item.setChecked(true);
                    }
                }
            }
        }
    }

    /**
     * Method of reading registry resources from artifact.xml file.
     * 
     * @param container
     *            registry container
     */
    private void addRegistryElements(IContainer registry) {
        try {
            IFile artifactFile = registry.getFile(new Path(Constants.REGISTRY_RESOURCE_FILE));
            File file = artifactFile.getLocation().toFile();
            String sourceArtifactFile = FileUtils.getContentAsString(file);
            OMElement registryResources = AXIOMUtil.stringToOM(sourceArtifactFile);

            Iterator<?> registryIterator = Collections.emptyIterator();
            if (registryResources != null) {
                registryIterator = registryResources.getChildElements();
            }

            while (registryIterator.hasNext()) {
                OMElement artifact = (OMElement) registryIterator.next();
                RegistryResource resource = new RegistryResource();

                QName registryItem = new QName("", Constants.REGISTRY_ITEM, "");
                QName registryItemFile = new QName("", Constants.REGISTRY_FILE, "");
                QName registryItemPath = new QName("", Constants.REGISTRY_FILE_PATH, "");
                QName registryItemMediaType = new QName("", Constants.REGISTRY_FILE_MEDIA_TYPE, "");

                OMElement registryItemNode = artifact.getFirstChildWithName(registryItem);
                if (registryItemNode != null) {
                    OMElement registryItemFileNode = registryItemNode.getFirstChildWithName(registryItemFile);
                    String fileName = registryItemFileNode.getText();
                    resource.setFileName(fileName);

                    OMElement registryItemFilePathNode = registryItemNode.getFirstChildWithName(registryItemPath);
                    String filePath = registryItemFilePathNode.getText();
                    resource.setFilePath(filePath);

                    OMElement registryItemFileTypeNode = registryItemNode.getFirstChildWithName(registryItemMediaType);
                    String fileType = registryItemFileTypeNode.getText();
                    resource.setMediaType(fileType);

                    String absolutePath = File.separator + registry.getProject().getName() + File.separator + fileName;
                    resource.setAbsolutePath(absolutePath);
                }

                registryElements.put(resource.getFileName(), resource);
            }

        } catch (XMLStreamException e) {
            log.error("Error while reading converting artifact.xml source to OMElement");
        } catch (IOException e) {
            log.error("Error while reading artifact.xml file in registry project");
        }
    }

    /**
     * Method of reading connector resources from connector projects.
     * 
     * @param container
     *            connector container
     */
    private void addConnectorElements(IContainer container) {
        IResource[] members;
        try {
            members = container.members();
            for (IResource member : members) {
                if (member instanceof IContainer) {
                    addConnectorElements((IContainer) member);
                } else if (member instanceof IFile
                        && member.getFileExtension().toLowerCase().equals(Constants.ZIP_EXTENSION)) {
                    connectorElements.put(member.getFullPath(), member.getName());
                }
            }
        } catch (CoreException e) {
            log.error("Error while reading connector file in connector projects");
        }

    }
}
