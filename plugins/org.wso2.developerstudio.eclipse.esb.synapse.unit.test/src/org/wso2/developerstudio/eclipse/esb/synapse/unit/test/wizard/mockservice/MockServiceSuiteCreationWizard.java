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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.mockservice;

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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.Activator;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockService;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * Class responsible for creation of wizard for mock services.
 */
public class MockServiceSuiteCreationWizard extends Wizard implements IExportWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private final String WINDOW_TITLE = "New Mock Service";
    private IProject project;
    private File destFile;

    private boolean initError = false;
    MockServiceMethodSelectionPage mockServiceMethodSelectionPage;
    MockServiceImportPage mockServiceImportPage;
    MockServiceDetailPage mockServiceDetailPage;

    private StringWriter writer;
    private MockService mockServiceDataHolder = new MockService();

    /**
     * Class constructor.
     */
    public MockServiceSuiteCreationWizard() {
    }

    /**
     * Class constructor.
     */
    public MockServiceSuiteCreationWizard(IProject project) {
        this.project = project;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        try {
            if (project == null) {
                project = getSelectedProject(selection);
            }
        } catch (Exception e) {
            log.error("Error reading project", e);
        }

        setWindowTitle(WINDOW_TITLE);
        mockServiceMethodSelectionPage = new MockServiceMethodSelectionPage(workbench, selection);
        mockServiceImportPage = new MockServiceImportPage(workbench, selection, project);
        mockServiceDetailPage = new MockServiceDetailPage(workbench, selection, project, mockServiceDataHolder);
    }

    @Override
    public boolean canFinish() {
        boolean enableFinish = false;

        if (getContainer().getCurrentPage() == mockServiceDetailPage) {
            if (mockServiceDetailPage.isPageComplete()) {
                enableFinish = true;
            }
        } else if (getContainer().getCurrentPage() == mockServiceImportPage) {
            if (mockServiceImportPage.isPageComplete()) {
                enableFinish = true;
            }
        }
        return enableFinish;
    }

    @Override
    public boolean performFinish() {
        try {
            String mockServiceConfiguration;
            IFile mockServiceFile;

            IContainer mockServicelocation = project.getFolder(Constants.TEST_FOLDER + File.separator
                    + Constants.SERVICE_RESOURCES + File.separator + Constants.MOCK_SERVICES);

            if (mockServiceMethodSelectionPage.isImportMockServiceChecked) {
                mockServiceConfiguration = new String(
                        Files.readAllBytes(Paths.get(mockServiceImportPage.getSuiteImportPath())));
                String fileSeperatePattern = Pattern.quote(System.getProperty(Constants.FILE_SEPERATOR));
                String[] filePathSplitter = mockServiceImportPage.getSuiteImportPath().split(fileSeperatePattern);
                String importFileName = filePathSplitter[filePathSplitter.length - 1].toLowerCase();
                mockServiceFile = mockServicelocation.getFile(new Path(importFileName));

            } else {
                mockServiceConfiguration = createMockServiceTemplate();
                mockServiceFile = mockServicelocation
                        .getFile(new Path(mockServiceDetailPage.getSuiteName() + "." + Constants.XML_EXTENSION));
            }

            destFile = mockServiceFile.getLocation().toFile();
            FileUtils.createFile(destFile, mockServiceConfiguration);
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            String location = mockServiceDetailPage.getSuiteExportPath() + File.separator;
            String source = FileUtils.getContentAsString(destFile);
            Openable openable = ESBGraphicalEditor.getOpenable();
            openable.editorOpen(destFile.getName(), "MOCK_SERVICE", location, source);

        } catch (IOException e) {
            log.error("IOException error while creating the mock service file", e);
        } catch (CoreException e) {
            log.error("CoreException error while creating the mock service file", e);
        } catch (Exception e) {
            log.error("Exception error while creating the mock service file", e);
        }

        return true;
    }

    /**
     * Method for creating the template of mock service.
     * 
     * @return created template as a string
     */
    private String createMockServiceTemplate() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element mockServiceRoot = doc.createElement(Constants.MOCK_SERVICE);
            doc.appendChild(mockServiceRoot);

            // Add mock service basic data
            Element serviceName = doc.createElement(Constants.SERVICE_NAME);
            mockServiceRoot.appendChild(serviceName);
            serviceName.appendChild(doc.createTextNode(mockServiceDetailPage.getServiceName()));

            Element servicePort = doc.createElement(Constants.SERVICE_PORT);
            mockServiceRoot.appendChild(servicePort);
            servicePort.appendChild(doc.createTextNode(mockServiceDetailPage.getServicePort()));

            Element serviceContext = doc.createElement(Constants.SERVICE_CONTEXT);
            mockServiceRoot.appendChild(serviceContext);
            serviceContext.appendChild(doc.createTextNode(mockServiceDetailPage.getServiceContext()));

            // Add mock service resources tag
            Element serviceResources = doc.createElement(Constants.SERVICE_RESOURCES);
            mockServiceRoot.appendChild(serviceResources);

            // Add mock service resource tags
            Map<String, MockServiceResource> mockResources = mockServiceDataHolder.getMockResources();
            for (Map.Entry<String, MockServiceResource> entry : mockResources.entrySet()) {
                MockServiceResource resource = entry.getValue();
                Element serviceResource = doc.createElement(Constants.SERVICE_RESOURCE);
                serviceResources.appendChild(serviceResource);

                Element resourceSubContext = doc.createElement(Constants.SERVICE_RESOURCE_SUB_CONTEXT);
                serviceResource.appendChild(resourceSubContext);
                resourceSubContext.appendChild(doc.createTextNode(resource.getSubContext()));

                Element resourceMethod = doc.createElement(Constants.SERVICE_RESOURCE_METHOD);
                serviceResource.appendChild(resourceMethod);
                resourceMethod.appendChild(doc.createTextNode(resource.getMethod()));

                // Add request headers and payload to the resource
                if ((resource.getRequestPayload() != null && !resource.getRequestPayload().isEmpty())
                        || (resource.getRequestHeaders() != null && resource.getRequestHeaders().size() > 0)) {
                    Element resourceRequest = doc.createElement(Constants.SERVICE_RESOURCE_REQUEST);

                    if (resource.getRequestPayload() != null && !resource.getRequestPayload().isEmpty()) {
                        Element requestPayload = doc.createElement(Constants.PAYLOAD);
                        resourceRequest.appendChild(requestPayload);
                        requestPayload.appendChild(doc.createTextNode(resource.getRequestPayload()));
                    }

                    if (resource.getRequestHeaders().size() > 0) {
                        Element requestHeaders = doc.createElement(Constants.SERVICE_RESOURCE_HEADERS);
                        resourceRequest.appendChild(requestHeaders);

                        for (Map.Entry<String, String> headerEntry : resource.getRequestHeaders().entrySet()) {
                            Element requestHeader = doc.createElement(Constants.SERVICE_RESOURCE_HEADER);

                            Attr headerName = doc.createAttribute(Constants.NAME);
                            headerName.setValue(headerEntry.getKey());
                            requestHeader.setAttributeNode(headerName);

                            Attr headerValue = doc.createAttribute(Constants.VALUE);
                            headerValue.setValue(headerEntry.getValue());
                            requestHeader.setAttributeNode(headerValue);

                            requestHeaders.appendChild(requestHeader);
                        }
                    }
                    serviceResource.appendChild(resourceRequest);
                }

                // Add response headers, status code and payload to the resource
                if ((resource.getResponsePayload() != null && !resource.getResponsePayload().isEmpty())
                        || (resource.getRequestHeaders() != null && resource.getResponseHeaders().size() > 0)) {
                    Element resourceResponse = doc.createElement(Constants.SERVICE_RESOURCE_RESPONSE);

                    String statusCode = Integer.toString(resource.getStatusCode());
                    Element responseCode = doc.createElement(Constants.SERVICE_RESOURCE_RESPONSE_CODE);
                    resourceResponse.appendChild(responseCode);
                    responseCode.appendChild(doc.createTextNode(statusCode));

                    if (!resource.getResponsePayload().isEmpty()) {
                        Element responsePayload = doc.createElement(Constants.PAYLOAD);
                        resourceResponse.appendChild(responsePayload);
                        responsePayload.appendChild(doc.createTextNode(resource.getResponsePayload()));
                    }

                    if (resource.getResponseHeaders().size() > 0) {
                        Element responseHeaders = doc.createElement(Constants.SERVICE_RESOURCE_HEADERS);
                        resourceResponse.appendChild(responseHeaders);

                        for (Map.Entry<String, String> headerEntry : resource.getResponseHeaders().entrySet()) {
                            Element responseHeader = doc.createElement(Constants.SERVICE_RESOURCE_HEADER);

                            Attr headerName = doc.createAttribute(Constants.NAME);
                            headerName.setValue(headerEntry.getKey());
                            responseHeader.setAttributeNode(headerName);

                            Attr headerValue = doc.createAttribute(Constants.VALUE);
                            headerValue.setValue(headerEntry.getValue());
                            responseHeader.setAttributeNode(headerValue);

                            responseHeaders.appendChild(responseHeader);
                        }
                    }
                    serviceResource.appendChild(resourceResponse);
                }
            }

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
            log.error("Error occured while creating source of mock service suite", e);
        } catch (TransformerException e) {
            log.error("Error occured while transforming the source of mock service suite", e);
        } finally {
            closeWriter();
        }

        return null;
    }

    public void addPages() {
        if (!initError) {
            addPage(mockServiceMethodSelectionPage);
            addPage(mockServiceImportPage);
            addPage(mockServiceDetailPage);
            super.addPages();
        }
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

    @Override
    public IWizardPage getNextPage(IWizardPage currentPage) {
        if (currentPage == mockServiceMethodSelectionPage
                && mockServiceMethodSelectionPage.isImportMockServiceChecked) {
            return mockServiceImportPage;
        }

        if (currentPage == mockServiceMethodSelectionPage
                && mockServiceMethodSelectionPage.isCreateNewMockServiceChecked) {
            return mockServiceDetailPage;
        }

        return null;
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

        IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
        return wroot.getProject();
    }
}
