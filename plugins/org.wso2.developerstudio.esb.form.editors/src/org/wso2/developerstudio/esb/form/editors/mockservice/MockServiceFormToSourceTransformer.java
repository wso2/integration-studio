/*
 Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.esb.form.editors.mockservice;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.ui.forms.editor.FormPage;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.MockServiceResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.ComboItems;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.esb.form.editors.Activator;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.Constants;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.SchemaValidator;

/**
 * Class responsible for transform form view data to source code.
 */
public class MockServiceFormToSourceTransformer {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static StringWriter writer;

    /**
     * Method of generating unit test suite source view from form view.
     * 
     * @param currently
     *            selected formEditorPage
     * @return source view
     */
    public static String generateMockServiceTemplate(FormPage formEditorPage) {
        MockServiceFormPage formPage = (MockServiceFormPage) formEditorPage;
        String port = formPage.getServicePort();
        String context = formPage.getServiceContext();

        if (!port.matches(Constants.PORT_REGEX) || Integer.parseInt(port) > 65535) {
            throw new RuntimeException("Please specify a valid integer port less than or equal to 65535");
        } else if (context.isEmpty() || !context.startsWith("/")) {
            throw new RuntimeException("Please specify a context path starts with / symbol");
        } else if (context.contains(Constants.WHITESPACE)) {
            throw new RuntimeException("Please specify a service context without whitespaces");
        } else if (formPage.getServiceName().contains(Constants.WHITESPACE)) {
            throw new RuntimeException("Please specify a end point name which want to mock without whitespaces");
        } else if (context.endsWith(Constants.PATH_PREFIX)) {
            throw new RuntimeException("Please specify service context without having '/' in the end");
        } else if (context.matches(Constants.CONTEXT_VALIDATE_REGEX)) {
            throw new RuntimeException("Please specify service context without having '/' repeatedly");
        }

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element mockServiceRoot = doc.createElement(Constants.MOCK_SERVICE);
            doc.appendChild(mockServiceRoot);

            // Add mock service basic data
            Element serviceName = doc.createElement(Constants.SERVICE_NAME);
            mockServiceRoot.appendChild(serviceName);
            serviceName.appendChild(doc.createTextNode(formPage.getServiceName()));

            Element servicePort = doc.createElement(Constants.SERVICE_PORT);
            mockServiceRoot.appendChild(servicePort);
            servicePort.appendChild(doc.createTextNode(formPage.getServicePort()));

            Element serviceContext = doc.createElement(Constants.SERVICE_CONTEXT);
            mockServiceRoot.appendChild(serviceContext);
            serviceContext.appendChild(doc.createTextNode(formPage.getServiceContext()));

            // Add mock service resources tag
            Element serviceResources = doc.createElement(Constants.SERVICE_RESOURCES);
            mockServiceRoot.appendChild(serviceResources);

            // Add mock service resource tags
            Map<String, MockServiceResource> mockResources = formPage.getResourceDataHolder().getMockResources();
            for (Map.Entry<String, MockServiceResource> entry : mockResources.entrySet()) {
                MockServiceResource resource = entry.getValue();
                Element serviceResource = doc.createElement(Constants.SERVICE_RESOURCE);
                serviceResources.appendChild(serviceResource);

                if (resource.getSubContext().isEmpty() || !resource.getSubContext().startsWith(Constants.PATH_PREFIX)) {
                    throw new RuntimeException("Please specify a sub context path starts with / symbol or base path /");
                }

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
                if ((resource.getResponsePayload() != null)
                        || (resource.getRequestHeaders() != null && resource.getResponseHeaders().size() > 0)) {
                    Element resourceResponse = doc.createElement(Constants.SERVICE_RESOURCE_RESPONSE);

                    String statusCode = Integer.toString(resource.getStatusCode());
                    if (!isValidStatusCode(statusCode)) {
                        throw new RuntimeException(
                                "Please specify a valid status code according to the given code list");
                    }

                    Element responseCode = doc.createElement(Constants.SERVICE_RESOURCE_RESPONSE_CODE);
                    resourceResponse.appendChild(responseCode);
                    responseCode.appendChild(doc.createTextNode(statusCode));

                    Element responsePayload = doc.createElement(Constants.PAYLOAD);
                    resourceResponse.appendChild(responsePayload);
                    responsePayload.appendChild(doc.createTextNode(resource.getResponsePayload()));

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
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String xmlSource = writer.getBuffer().toString();

            SchemaValidator.isValidMockServiceConfigurationXML(xmlSource);
            formPage.refreshResourceTable();

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

    /**
     * Method of checking the response status code is valid or not.
     * 
     * @param inputCode
     *            entered status code
     * @return isValid or not
     */
    private static boolean isValidStatusCode(String inputCode) {
        boolean isFound = false;
        for (String code : ComboItems.getStatusCodes()) {
            if (code.split(Constants.WHITESPACE)[0].equals(inputCode)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    /**
     * Method of closing string writer.
     */
    private static void closeWriter() {
        try {
            writer.close();
        } catch (IOException e) {
            log.error("Error occured while closing string writer", e);
        }
    }
}
