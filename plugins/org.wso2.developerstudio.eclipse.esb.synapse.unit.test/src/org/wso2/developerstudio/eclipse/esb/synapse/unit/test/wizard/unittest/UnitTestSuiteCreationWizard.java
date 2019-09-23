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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.unittest;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.Activator;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.RegistryResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.propertytester.UnitTestResourceTester;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * Class responsible for creation of new or import Synapse unit test suite.
 */
public class UnitTestSuiteCreationWizard extends Wizard implements IExportWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private final String WINDOW_TITLE = "New Unit Test Suite";
    private final String SUPPORTIVE_ARTIFACTS_SELECTION_TITLE = "Supportive Artifacts";
    private final String SUPPORTIVE_ARTIFACTS_SELECTION_DESCRIPTION = "Select supportive artifacts which are used in the test artifact";
    private final String MOCK_SERVICES_SELECTION_TITLE = "Mock Services";
    private final String MOCK_SERVICES_SELECTION_DESCRIPTION = "Select mock services which are want to replace the defined endpoints";

    private UnitTestSuiteMethodSelectionPage suiteSelectionPage;
    private UnitTestSuiteDetailPage suiteNewDetailPage;
    private UnitTestSuiteImportPage suiteImportDetailPage;
    private UnitTestSuiteSupportiveArtifactsSelectionPage selectSupportiveArtifactsPage;
    private UnitTestSuiteMockServicesSelectionPage selectMockServicesPage;
    SynapseUnitTest unitTestData = new SynapseUnitTest();

    private boolean initError = false;
    private boolean isPageSelection;
    private IProject project;
    private File destFile;
    private StringWriter writer;

    /**
     * Class constructor.
     */
    public UnitTestSuiteCreationWizard() {
    }

    /**
     * Class constructor.
     */
    public UnitTestSuiteCreationWizard(IProject project) {
        this.project = project;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        isPageSelection = UnitTestResourceTester.isPageSelection();

        try {
            if (project == null) {
                project = getSelectedProject(selection);
            }
        } catch (Exception e) {
            log.error("Error reading project", e);
        }

        if (!isPageSelection) {
            suiteSelectionPage = new UnitTestSuiteMethodSelectionPage(workbench, selection);
        }

        suiteNewDetailPage = new UnitTestSuiteDetailPage(workbench, selection, unitTestData, project, isPageSelection);
        suiteImportDetailPage = new UnitTestSuiteImportPage(workbench, selection, project);

        selectSupportiveArtifactsPage = new UnitTestSuiteSupportiveArtifactsSelectionPage(
                SUPPORTIVE_ARTIFACTS_SELECTION_TITLE, SUPPORTIVE_ARTIFACTS_SELECTION_DESCRIPTION, unitTestData);

        selectMockServicesPage = new UnitTestSuiteMockServicesSelectionPage(MOCK_SERVICES_SELECTION_TITLE,
                MOCK_SERVICES_SELECTION_DESCRIPTION, selection, unitTestData);
    }

    @Override
    public boolean canFinish() {
        if (getContainer().getCurrentPage() == selectMockServicesPage
                || getContainer().getCurrentPage() == suiteImportDetailPage
                        && getContainer().getCurrentPage().isPageComplete()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean performFinish() {
        try {
            String unitTestConfiguration;
            IFile unitTestFile;
            String location;

            IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
            if (isPageSelection) {
                unitTestData.setTestArtifact(UnitTestResourceTester.getSelectedFilePath());
            }

            if (!isPageSelection && suiteSelectionPage.isImportSuiteChecked) {
                unitTestConfiguration = new String(
                        Files.readAllBytes(Paths.get(suiteImportDetailPage.getSuiteImportPath())));
                String fileSeperatePattern = Pattern.quote(System.getProperty(Constants.FILE_SEPERATOR));
                String[] filePathSplitter = suiteImportDetailPage.getSuiteImportPath().split(fileSeperatePattern);
                String importFileName = filePathSplitter[filePathSplitter.length - 1].toLowerCase();
                IContainer unitTestsLocation = wroot.getFolder(new Path(suiteImportDetailPage.getSuiteExportPath()));
                unitTestFile = unitTestsLocation.getFile(new Path(importFileName));
                location = suiteImportDetailPage.getSuiteExportPath() + File.separator;

            } else {
                IContainer unitTestsLocation = wroot.getFolder(new Path(suiteNewDetailPage.getSuiteExportPath()));
                unitTestConfiguration = createUnitTestTemplate(unitTestData);
                unitTestFile = unitTestsLocation
                        .getFile(new Path(suiteNewDetailPage.getSuiteName() + "." + Constants.XML_EXTENSION));
                location = suiteNewDetailPage.getSuiteExportPath() + File.separator;
            }

            destFile = unitTestFile.getLocation().toFile();
            FileUtils.createFile(destFile, unitTestConfiguration);
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            String source = FileUtils.getContentAsString(destFile);
            Openable openable = ESBGraphicalEditor.getOpenable();
            openable.editorOpen(destFile.getName(), "SYNAPSE_UNIT_TEST", location, source);

        } catch (IOException e) {
            log.error("IOException error while creating the unit test file", e);
        } catch (CoreException e) {
            log.error("CoreException error while creating the unit test file", e);
        } catch (Exception e) {
            log.error("Exception error while creating the unit test file", e);
        }
        return true;
    }

    /**
     * Method for creating the template of unit test suite.
     * 
     * @return created template as a string
     */
    public String createUnitTestTemplate(SynapseUnitTest unitTestData) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element synapseRoot = doc.createElement(Constants.SYNAPSE_UNIT_TEST);
            doc.appendChild(synapseRoot);

            // Add test artifact data
            Element artifacts = doc.createElement(Constants.ARTIFACTS);
            synapseRoot.appendChild(artifacts);
            Element testArtifact = doc.createElement(Constants.TEST_ARTIFACT);
            artifacts.appendChild(testArtifact);

            Element artifactTest = doc.createElement(Constants.ARTIFACT);
            artifactTest.appendChild(doc.createTextNode(unitTestData.getTestArtifact()));
            testArtifact.appendChild(artifactTest);

            // Add supportive artifact data
            Element supportiveArtifacts = doc.createElement(Constants.SUPPORTIVE_ARTIFACTS);
            artifacts.appendChild(supportiveArtifacts);

            for (String supportivePath : unitTestData.getSupportiveArtifacts()) {
                Element artifactSupportive = doc.createElement(Constants.ARTIFACT);
                artifactSupportive.appendChild(doc.createTextNode(supportivePath));
                supportiveArtifacts.appendChild(artifactSupportive);
            }

            // Add registry artifact data
            Element registryArtifacts = doc.createElement(Constants.REGISTRY_RESOURCES);
            artifacts.appendChild(registryArtifacts);

            for (Map.Entry<String, RegistryResource> resource : unitTestData.getRegistryResource().entrySet()) {
                Element registryResource = doc.createElement(Constants.REGISTRY_RESOURCE);
                Element resourceName = doc.createElement(Constants.REGISTRY_NAME);
                Element resourceArtifact = doc.createElement(Constants.ARTIFACT);
                Element resourcePath = doc.createElement(Constants.REGISTRY_PATH);
                Element resourceMediaType = doc.createElement(Constants.REGISTRY_MEDIA_TYPE);

                registryArtifacts.appendChild(registryResource);
                resourceName.appendChild(doc.createTextNode(resource.getValue().getFileName()));
                registryResource.appendChild(resourceName);
                resourceArtifact.appendChild(doc.createTextNode(resource.getValue().getAbsolutePath()));
                registryResource.appendChild(resourceArtifact);
                resourcePath.appendChild(doc.createTextNode(resource.getValue().getFilePath()));
                registryResource.appendChild(resourcePath);
                resourceMediaType.appendChild(doc.createTextNode(resource.getValue().getMediaType()));
                registryResource.appendChild(resourceMediaType);
            }

            // Add connector resource data
            Element connectorResources = doc.createElement(Constants.CONNECTOR_RESOURCES);
            artifacts.appendChild(connectorResources);

            for (String resourcePath : unitTestData.getConnectorFiles()) {
                Element connectorResource = doc.createElement(Constants.CONNECTOR_RESOURCE);
                connectorResource.appendChild(doc.createTextNode(resourcePath));
                connectorResources.appendChild(connectorResource);
            }

            // Add mock services to the suite
            Element mockServices = doc.createElement(Constants.MOCK_SERVICES);
            for (String mockServicePath : unitTestData.getMockServices()) {
                Element mockService = doc.createElement(Constants.MOCK_SERVICE);
                mockService.appendChild(doc.createTextNode(mockServicePath));
                mockServices.appendChild(mockService);;
            }
            synapseRoot.appendChild(mockServices);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String xmlSource = writer.getBuffer().toString();

            return CommonUtil.replaceUnscapeCharacters(xmlSource);

        } catch (ParserConfigurationException e) {
            log.error("Error occured while creating source of unit test suite", e);
        } catch (TransformerException e) {
            log.error("Error occured while transforming the source of unit test suite", e);
        } finally {
            closeWriter();
        }

        return null;
    }

    public void addPages() {
        if (!initError) {
            if (!isPageSelection) {
                addPage(suiteSelectionPage);
            }
            addPage(suiteNewDetailPage);
            addPage(suiteImportDetailPage);
            addPage(selectSupportiveArtifactsPage);
            addPage(selectMockServicesPage);
            super.addPages();
        }
    }

    @Override
    public IWizardPage getNextPage(IWizardPage currentPage) {
        if (currentPage == suiteSelectionPage && suiteSelectionPage.isCreateNewSuiteChecked) {
            return suiteNewDetailPage;
        }

        if (currentPage == suiteSelectionPage && suiteSelectionPage.isImportSuiteChecked) {
            return suiteImportDetailPage;
        }

        if (currentPage == suiteNewDetailPage) {
            selectSupportiveArtifactsPage.refreshSupportiveArtifactTree();
            return selectSupportiveArtifactsPage;
        }

        if (currentPage == selectSupportiveArtifactsPage) {
            return selectMockServicesPage;
        }
        return null;
    }

    /**
     * Method of closing string writer.
     */
    private void closeWriter() {
        try {
            writer.close();
        } catch (IOException e) {
            log.error("Error occured while closing string writer", e);
        }
    }

    /**
     * Method for getting current project from IStructuredSelection.
     * 
     * @param obj
     *            IStructuredSelection as an object
     * @return IProject
     */
    public static IProject getSelectedProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getSelectedProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }
}
