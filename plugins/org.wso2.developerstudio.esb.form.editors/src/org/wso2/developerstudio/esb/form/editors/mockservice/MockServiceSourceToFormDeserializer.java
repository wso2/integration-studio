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
package org.wso2.developerstudio.esb.form.editors.mockservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.developerstudio.esb.form.editors.Activator;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.Constants;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.SchemaValidator;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Class responsible to deserialize the source to form view.
 */
public class MockServiceSourceToFormDeserializer {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Method of updating the source file using source code.
     * 
     * @param xmlSource
     *            source code
     * @param mockFile
     *            storing file
     * @return IFile with the source code
     */
    public static IFile updateSourceFile(String xmlSource, IFile mockFile) {

        try {
            InputStream is = new ByteArrayInputStream(xmlSource.getBytes());
            mockFile.setContents(is, true, true, null);
        } catch (CoreException e) {
            log.error("Mock service configuration data reading failed ", e);
        }

        return mockFile;
    }

    /**
     * Method of generating form view using source code.
     * 
     * @param formEditorPage
     *            formPage currently open
     * @param mockFile
     *            source code contains file
     * @param isInitial
     *            checking the generating in first time or not
     */
    public static void generateFormView(FormPage formEditorPage, IFile mockFile, boolean isInitial) {
        try {
            InputStream inputStream = mockFile.getContents();
            StringWriter writer = new StringWriter();

            IOUtils.copy(inputStream, writer, mockFile.getCharset());
            inputStream.close();
            String mockConfigurationAsString = writer.toString();
            OMElement importedXMLFile = AXIOMUtil.stringToOM(mockConfigurationAsString);

            MockServiceFormPage formPage = (MockServiceFormPage) formEditorPage;
            processAndUpdateMockServiceForm(formPage, importedXMLFile, isInitial);

        } catch (CoreException e) {
            log.error("Error in converting mock service file to string ", e);
        } catch (IOException | XMLStreamException e) {
            log.error("Mock service configuration data reading failed ", e);
        }
    }

    /**
     * Method of generating form view using source code.
     * 
     * @param formEditorPage
     *            formPage currently open
     * @param mockSource
     *            source code
     * @param isInitial
     *            checking the generating in first time or not
     */
    public static void generateFormView(FormPage formEditorPage, String mockSource, boolean isInitial) {
        SchemaValidator.isValidMockServiceConfigurationXML(mockSource);
        try {
            OMElement importedXMLFile = AXIOMUtil.stringToOM(mockSource);

            MockServiceFormPage formPage = (MockServiceFormPage) formEditorPage;
            formPage.getResourceDataHolder().clearAllMockResources();
            processAndUpdateMockServiceForm(formPage, importedXMLFile, isInitial);

        } catch (IOException | XMLStreamException e) {
            log.error("Mock service configuration data reading failed ", e);
        }
    }

    /**
     * Method of generating form view using source code.
     * 
     * @param formPage
     *            MockServiceFormPage currently open
     * @param artifactsNode
     *            source code as in OMElement
     * @param isInitial
     *            checking the generating in first time or not
     */
    private static void processAndUpdateMockServiceForm(MockServiceFormPage formPage, OMElement artifactsNode,
            boolean isInitial) throws IOException, XMLStreamException {

        QName qualifiedMockServiceName = new QName("", Constants.SERVICE_NAME, "");
        OMElement mockServiceNameNode = artifactsNode.getFirstChildWithName(qualifiedMockServiceName);

        if (mockServiceNameNode != null) {
            String serviceName = mockServiceNameNode.getText();
            if (serviceName != null && !serviceName.isEmpty()) {
                formPage.setServiceName(serviceName);
            }
        }

        QName qualifiedMockServicePort = new QName("", Constants.SERVICE_PORT, "");
        OMElement mockServicePortNode = artifactsNode.getFirstChildWithName(qualifiedMockServicePort);

        if (mockServiceNameNode != null) {
            String servicePort = mockServicePortNode.getText();
            if (servicePort != null && !servicePort.isEmpty()) {
                formPage.setServicePort(servicePort);
            }
        }

        QName qualifiedMockServiceContext = new QName("", Constants.SERVICE_CONTEXT, "");
        OMElement mockServiceContextNode = artifactsNode.getFirstChildWithName(qualifiedMockServiceContext);

        if (mockServiceContextNode != null) {
            String serviceContext = mockServiceContextNode.getText();
            if (serviceContext != null && !serviceContext.isEmpty()) {
                formPage.setServiceContext(serviceContext);
            }
        }

        QName qualifiedMockServiceResources = new QName("", Constants.SERVICE_RESOURCES, "");
        OMElement mockServiceResourcesNode = artifactsNode.getFirstChildWithName(qualifiedMockServiceResources);

        // Iterate through the mock service resources
        Iterator<?> resourceIterator = Collections.emptyIterator();
        if (mockServiceResourcesNode != null) {
            resourceIterator = mockServiceResourcesNode.getChildElements();
        }

        while (resourceIterator.hasNext()) {
            OMElement resource = (OMElement) resourceIterator.next();
            MockServiceResource mockResource = new MockServiceResource();

            QName qualifiedMockServiceSubContext = new QName("", Constants.SERVICE_RESOURCE_SUB_CONTEXT, "");
            OMElement mockServiceSubContextNode = resource.getFirstChildWithName(qualifiedMockServiceSubContext);

            if (mockServiceSubContextNode != null) {
                String subContext = mockServiceSubContextNode.getText();
                mockResource.setSubContext(subContext);
            }

            QName qualifiedMockServiceMethod = new QName("", Constants.SERVICE_RESOURCE_METHOD, "");
            OMElement mockServiceMethodNode = resource.getFirstChildWithName(qualifiedMockServiceMethod);

            if (mockServiceMethodNode != null) {
                String method = mockServiceMethodNode.getText();
                mockResource.setMethod(method);
            }

            // Mock service request details
            QName qualifiedMockServiceRequest = new QName("", Constants.SERVICE_RESOURCE_REQUEST, "");
            OMElement mockServiceRequestNode = resource.getFirstChildWithName(qualifiedMockServiceRequest);

            QName qualifiedMockServicePayload = new QName("", Constants.PAYLOAD, "");
            QName qualifiedMockServiceHeaders = new QName("", Constants.SERVICE_RESOURCE_HEADERS, "");
            Iterator<?> headerIterator = Collections.emptyIterator();

            if (mockServiceRequestNode != null) {
                OMElement mockServiceReqPayloadNode = mockServiceRequestNode
                        .getFirstChildWithName(qualifiedMockServicePayload);

                if (mockServiceReqPayloadNode != null) {
                    String reqPayload = mockServiceReqPayloadNode.getText();
                    if (reqPayload != null && !reqPayload.isEmpty()) {
                        reqPayload = CommonUtil.addCDATATagToPayloads(reqPayload);
                    }
                    mockResource.setRequestPayload(reqPayload);
                }

                OMElement mockServiceReqHeadersNode = mockServiceRequestNode
                        .getFirstChildWithName(qualifiedMockServiceHeaders);

                if (mockServiceReqHeadersNode != null) {
                    headerIterator = mockServiceReqHeadersNode.getChildElements();
                }

                while (headerIterator.hasNext()) {
                    OMElement resourceHeader = (OMElement) headerIterator.next();

                    String headerName = resourceHeader.getAttributeValue(new QName(Constants.NAME));
                    String headerValue = resourceHeader.getAttributeValue(new QName(Constants.VALUE));
                    mockResource.addRequestHeaders(headerName, headerValue);
                }
            }

            // Mock service response details
            QName qualifiedMockServiceResponse = new QName("", Constants.SERVICE_RESOURCE_RESPONSE, "");
            OMElement mockServiceResponseNode = resource.getFirstChildWithName(qualifiedMockServiceResponse);

            QName qualifiedMockServiceResponseCode = new QName("", Constants.SERVICE_RESOURCE_RESPONSE_CODE, "");
            OMElement mockServiceResCodeNode = mockServiceResponseNode
                    .getFirstChildWithName(qualifiedMockServiceResponseCode);
            if (mockServiceResCodeNode != null) {
                String statusCode = mockServiceResCodeNode.getText();
                mockResource.setStatusCode(Integer.parseInt(statusCode));
            }

            OMElement mockServiceResPayloadNode = mockServiceResponseNode
                    .getFirstChildWithName(qualifiedMockServicePayload);
            if (mockServiceResPayloadNode != null) {
                String resPayload = mockServiceResPayloadNode.getText();
                if (resPayload != null) {
                    resPayload = CommonUtil.addCDATATagToPayloads(resPayload);
                }
                mockResource.setResponsePayload(resPayload);
            }

            OMElement mockServiceResHeadersNode = mockServiceResponseNode
                    .getFirstChildWithName(qualifiedMockServiceHeaders);
            if (mockServiceResHeadersNode != null) {
                headerIterator = mockServiceResHeadersNode.getChildElements();
            }

            while (headerIterator.hasNext()) {
                OMElement resourceHeader = (OMElement) headerIterator.next();

                String headerName = resourceHeader.getAttributeValue(new QName(Constants.NAME));
                String headerValue = resourceHeader.getAttributeValue(new QName(Constants.VALUE));
                mockResource.addResponseHeaders(headerName, headerValue);
            }

            formPage.getResourceDataHolder().addMockResources(mockResource.getSubContext() + mockResource.getMethod(),
                    mockResource);
        }

        if (!isInitial) {
            formPage.reloadFormPage();
        }

    }
}
