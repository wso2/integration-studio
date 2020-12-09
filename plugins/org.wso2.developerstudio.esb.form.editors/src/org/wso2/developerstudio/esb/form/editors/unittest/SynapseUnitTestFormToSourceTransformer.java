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
package org.wso2.developerstudio.esb.form.editors.unittest;

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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.forms.editor.FormPage;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.Assertion;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.InputProperty;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.RegistryResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.esb.form.editors.Activator;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.Constants;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.SchemaValidator;

/**
 * Class responsible for transform form view data to source code.
 */
public class SynapseUnitTestFormToSourceTransformer {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static StringWriter writer;

    /**
     * Method of generating unit test suite source view from form view.
     * 
     * @param currently
     *            selected formEditorPage
     * @return source view
     */
    public static String generateUnitTestTemplate(FormPage formEditorPage) {
        SynapseUnitTestFormPage formPage = (SynapseUnitTestFormPage) formEditorPage;
        SynapseUnitTest unitTestData = formPage.getUnitTestDataHolder();
        IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();

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

            IResource testArtifactResource = wroot.findMember(new Path(formPage.getTestArtifactPath()));
            if (testArtifactResource == null) {
                throw new RuntimeException("Specified \'" + formPage.getTestArtifactPath()
                        + "\' test artifact file doesn't exist in given location");
            }
            Element artifactTest = doc.createElement(Constants.ARTIFACT);
            String testArtifactPath = formPage.getTestArtifactPath().replace(Constants.WINDOWS_PATH_PREFIX,
                    Constants.PATH_PREFIX);
            artifactTest.appendChild(doc.createTextNode(testArtifactPath));
            testArtifact.appendChild(artifactTest);

            // Add supportive artifact data
            Element supportiveArtifacts = doc.createElement(Constants.SUPPORTIVE_ARTIFACTS);
            artifacts.appendChild(supportiveArtifacts);

            for (String supportivePath : unitTestData.getSupportiveArtifacts()) {
                supportivePath = supportivePath.replace(Constants.WINDOWS_PATH_PREFIX,Constants.PATH_PREFIX);
                IResource supportiveArtifactResource = wroot.findMember(new Path(supportivePath));
                if (supportiveArtifactResource == null) {
                    throw new RuntimeException("Specified \'" + supportivePath
                            + "\' supportive artifact file doesn't exist in given location");
                }
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
                resourcePath = resourcePath.replace(Constants.WINDOWS_PATH_PREFIX,Constants.PATH_PREFIX);
                Element connectorResource = doc.createElement(Constants.CONNECTOR_RESOURCE);
                connectorResource.appendChild(doc.createTextNode(resourcePath));
                connectorResources.appendChild(connectorResource);
            }

            // Add test cases to the unit test suite
            Element testCases = doc.createElement(Constants.TEST_CASES);
            synapseRoot.appendChild(testCases);

            for (Map.Entry<Integer, TestCase> entry : unitTestData.getTestCases().entrySet()) {
                TestCase testCaseData = entry.getValue();
                Element testCase = doc.createElement(Constants.TEST_CASE);
                Attr testCaseName = doc.createAttribute(Constants.NAME);
                testCaseName.setValue(testCaseData.getTestCaseName());
                testCase.setAttributeNode(testCaseName);
                testCases.appendChild(testCase);

                // Add input of the test case
                if (testCaseData.getRequestPath() != null || testCaseData.getRequestMethod() != null
                        || testCaseData.getInputPayload() != null || testCaseData.getPropertyMap().size() > 0) {
                    Element input = doc.createElement(Constants.INPUT);

                    // Check artifact type if api and append resource path and method
                    if (unitTestData.getTestArtifactType().equals(Constants.API_ARTIFACT)) {
                        Element requestPath = doc.createElement(Constants.REQUEST_PATH);
                        Element requestMethod = doc.createElement(Constants.REQUEST_METHOD);
                        requestPath.appendChild(doc.createTextNode(testCaseData.getRequestPath()));
                        requestMethod.appendChild(doc.createTextNode(testCaseData.getRequestMethod()));
                        input.appendChild(requestPath);
                        input.appendChild(requestMethod);
                    }

                    // Add input payload if exist
                    if (testCaseData.getInputPayload() != null && !testCaseData.getInputPayload().isEmpty()) {
                        Element payload = doc.createElement(Constants.PAYLOAD);
                        payload.appendChild(doc.createTextNode(testCaseData.getInputPayload()));
                        input.appendChild(payload);
                    }

                    // Add input properties if exist
                    if (testCaseData.getPropertyMap().size() > 0) {
                        Element properties = doc.createElement(Constants.PROPERTIES);
                        for (Map.Entry<String, InputProperty> propertyNode : testCaseData.getPropertyMap().entrySet()) {
                            InputProperty prop = propertyNode.getValue();
                            Element property = doc.createElement(Constants.PROPERTY);

                            Attr propName = doc.createAttribute(Constants.NAME);
                            propName.setValue(prop.getName());
                            property.setAttributeNode(propName);

                            if (!prop.getScope().equals(Constants.SYNAPSE_LEVEL)) {
                                Attr propScope = doc.createAttribute(Constants.PROPERTY_SCOPE);
                                propScope.setValue(prop.getScope());
                                property.setAttributeNode(propScope);
                            }

                            Attr propValue = doc.createAttribute(Constants.VALUE);
                            propValue.setValue(prop.getValue());
                            property.setAttributeNode(propValue);

                            properties.appendChild(property);
                        }
                        input.appendChild(properties);
                    }
                    testCase.appendChild(input);
                }

                // Add assertion types
                if (testCaseData.getAssertions().size() > 0) {
                    Element assertions = doc.createElement(Constants.ASSERTIONS);

                    for (Map.Entry<String, Assertion> assertion : testCaseData.getAssertions().entrySet()) {
                        Assertion assertElement = assertion.getValue();

                        if (assertElement.getAssertType().equals(Constants.ASSERT_EQUAL_TYPE)) {
                            Element assertEquals = doc.createElement(Constants.ASSERT_EQUALS);

                            Element assertActual = doc.createElement(Constants.ASSERT_ACTUAL);
                            Element assertExpected = doc.createElement(Constants.ASSERT_EXPECTED);
                            Element assertMessage = doc.createElement(Constants.ASSERT_MESSAGE);
                            assertActual.appendChild(doc.createTextNode(assertElement.getActual()));
                            assertExpected.appendChild(doc.createTextNode(assertElement.getExpected()));
                            assertMessage.appendChild(doc.createTextNode(assertElement.getMessage()));
                            assertEquals.appendChild(assertActual);
                            assertEquals.appendChild(assertExpected);
                            assertEquals.appendChild(assertMessage);
                            assertions.appendChild(assertEquals);

                        } else if (assertElement.getAssertType().equals(Constants.ASSERT_NOTNULL_TYPE)) {
                            Element assertNotNull = doc.createElement(Constants.ASSERT_NOTNULL);

                            Element assertActual = doc.createElement(Constants.ASSERT_ACTUAL);
                            Element assertMessage = doc.createElement(Constants.ASSERT_MESSAGE);
                            assertActual.appendChild(doc.createTextNode(assertElement.getActual()));
                            assertMessage.appendChild(doc.createTextNode(assertElement.getMessage()));
                            assertNotNull.appendChild(assertActual);
                            assertNotNull.appendChild(assertMessage);
                            assertions.appendChild(assertNotNull);
                        }
                    }
                    testCase.appendChild(assertions);
                }
                testCases.appendChild(testCase);
            }

            // Add mock services to the suite
            Element mockServices = doc.createElement(Constants.MOCK_SERVICES);
            for (String mockServicePath : unitTestData.getMockServices()) {
                mockServicePath = mockServicePath.replace(Constants.WINDOWS_PATH_PREFIX,Constants.PATH_PREFIX);
                IResource mockServiceData = wroot.findMember(new Path(mockServicePath));
                if (mockServiceData == null) {
                    throw new RuntimeException("Specified \'" + mockServicePath
                            + "\' mock service configuration file doesn't exist in given location");
                }
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

            SchemaValidator.isValidUnitTestConfigurationXML(xmlSource);

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
