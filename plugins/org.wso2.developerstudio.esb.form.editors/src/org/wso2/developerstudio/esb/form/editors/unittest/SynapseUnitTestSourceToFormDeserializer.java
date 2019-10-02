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
package org.wso2.developerstudio.esb.form.editors.unittest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.developerstudio.esb.form.editors.Activator;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.Constants;
import org.wso2.developerstudio.esb.form.editors.unittest.commons.SchemaValidator;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.Assertion;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.InputProperty;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.RegistryResource;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Class responsible to deserialize the source to form view.
 */
public class SynapseUnitTestSourceToFormDeserializer {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Method of updating the source file using source code.
     * 
     * @param xmlSource
     *            source code
     * @param unitTestFile
     *            storing file
     * @return IFile with the source code
     */
    public static IFile updateSourceFile(String xmlSource, IFile unitTestFile) {

        try {
            InputStream is = new ByteArrayInputStream(xmlSource.getBytes());
            unitTestFile.setContents(is, true, true, null);
        } catch (CoreException e) {
            log.error("Synapse unit test configuration data reading failed ", e);
        }

        return unitTestFile;
    }

    /**
     * Method of generating form view using source code.
     * 
     * @param formEditorPage
     *            formPage currently open
     * @param unitTestFile
     *            source code contains file
     * @param isInitial
     *            checking the generating in first time or not
     */
    public static void generateFormView(FormPage formEditorPage, IFile unitTestFile, boolean isInitial) {
        try {
            InputStream inputStream = unitTestFile.getContents();
            StringWriter writer = new StringWriter();

            IOUtils.copy(inputStream, writer, unitTestFile.getCharset());
            inputStream.close();
            String configurationAsString = writer.toString();
            OMElement importedXMLFile = AXIOMUtil.stringToOM(configurationAsString);

            SynapseUnitTestFormPage formPage = (SynapseUnitTestFormPage) formEditorPage;
            processAndUpdateSynapseUnitTestForm(formPage, importedXMLFile, isInitial);

        } catch (CoreException e) {
            log.error("Error in converting mock service file to string ", e);
        } catch (IOException | XMLStreamException e) {
            log.error("Synapse unit test configuration data reading failed ", e);
        }
    }

    /**
     * Method of generating form view using source code.
     * 
     * @param formEditorPage
     *            formPage currently open
     * @param unitTestSource
     *            source code
     * @param isInitial
     *            checking the generating in first time or not
     */
    public static void generateFormView(FormPage formEditorPage, String unitTestSource, boolean isInitial) {
        SchemaValidator.isValidUnitTestConfigurationXML(unitTestSource);
        try {
            OMElement importedXMLFile = AXIOMUtil.stringToOM(unitTestSource);

            SynapseUnitTestFormPage formPage = (SynapseUnitTestFormPage) formEditorPage;
            formPage.getUnitTestDataHolder().clearDataHolders();
            processAndUpdateSynapseUnitTestForm(formPage, importedXMLFile, isInitial);

        } catch (IOException | XMLStreamException e) {
            log.error("Synapse unit test configuration data reading failed ", e);
        }
    }

    /**
     * Method of generating form view using source code.
     * 
     * @param formPage
     *            SynapseUnitTestFormPage currently open
     * @param importedXML
     *            source code as in OMElement
     * @param isInitial
     *            checking the generating in first time or not
     */
    private static void processAndUpdateSynapseUnitTestForm(SynapseUnitTestFormPage formPage, OMElement importedXML,
            boolean isInitial) throws IOException, XMLStreamException {
        IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
        
        // Read artifact from descriptor data
        QName qualifiedArtifacts = new QName("", Constants.ARTIFACTS, "");
        OMElement artifactsNode = importedXML.getFirstChildWithName(qualifiedArtifacts);
        readAndStoreArtifactData(artifactsNode, formPage, wroot);

        // Set test case count as zero
        int testCasesCount = 0;

        // Read test cases from descriptor data
        QName qualifiedTestCases = new QName("", Constants.TEST_CASES, "");
        OMElement testCasesNode = importedXML.getFirstChildWithName(qualifiedTestCases);

        // Iterate through test-cases in descriptor data
        Iterator<?> testCaseIterator = Collections.emptyIterator();
        if (testCasesNode != null) {
            testCaseIterator = testCasesNode.getChildElements();
        }

        while (testCaseIterator.hasNext()) {
            TestCase testCase = new TestCase();
            OMElement testCaseNode = (OMElement) (testCaseIterator.next());
            String testCaseName = testCaseNode.getAttributeValue(new QName(Constants.NAME));
            if (testCaseName != null) {
                testCase.setTestCaseName(testCaseName);
            }

            // Read input child from test-case node
            QName qualifiedInput = new QName("", Constants.INPUT, "");
            OMElement testCaseInputNode = testCaseNode.getFirstChildWithName(qualifiedInput);

            // Read input node data of payload and properties if not null
            if (testCaseInputNode != null) {
                readTestCaseInputData(testCaseInputNode, testCase);
            }

            // Read assertions of test-case node
            QName qualifiedAssertions = new QName("", Constants.ASSERTIONS, "");
            OMElement testCaseAssertionNode = testCaseNode.getFirstChildWithName(qualifiedAssertions);

            readTestCaseAssertions(testCaseAssertionNode, testCase);
            testCase.setTestCaseCode(testCasesCount);
            formPage.getUnitTestDataHolder().addTestCases(testCasesCount, testCase);

            testCasesCount++;
        }
        formPage.getUnitTestDataHolder().setTestCaseCount(testCasesCount);

        QName qualifiedMockServices = new QName("", Constants.MOCK_SERVICES, "");
        OMElement mockServicesNode = importedXML.getFirstChildWithName(qualifiedMockServices);
        readAndStoreMockServiceData(mockServicesNode, formPage, wroot);

        if (!isInitial) {
            formPage.reloadFormPage();
        }
    }

    /**
     * Method of reading artifact data from source code.
     * 
     * @param formPage
     *            SynapseUnitTestFormPage currently open
     * @param artifactsNode
     *            source code as in OMElement
     * @param wroot workspace root
     */
    private static void readAndStoreArtifactData(OMElement artifactsNode, SynapseUnitTestFormPage formPage,
            IWorkspaceRoot wroot) {
        QName qualifiedTestArtifact = new QName("", Constants.TEST_ARTIFACT, "");
        OMElement testArtifactNode = artifactsNode.getFirstChildWithName(qualifiedTestArtifact);

        QName qualifiedArtifact = new QName("", Constants.ARTIFACT, "");
        OMElement testArtifactDataNode = testArtifactNode.getFirstChildWithName(qualifiedArtifact);
        String testArtifactData = testArtifactDataNode.getText();
        testArtifactData = testArtifactData.replace(Constants.WINDOWS_PATH_PREFIX, Constants.PATH_PREFIX);

        // Read test artifact type from synapse test data
        String fileSeperatePattern = Pattern.quote(Constants.PATH_PREFIX);
        String[] pathTypes = testArtifactData.split(fileSeperatePattern);
        String folderType = pathTypes[pathTypes.length - 2];
        formPage.getUnitTestDataHolder().setTestArtifact(testArtifactData);
        formPage.getUnitTestDataHolder().setTestArtifactType(folderType); 

        // Read supportive test cases data
        QName qualifiedSupportiveTestArtifact = new QName("", Constants.SUPPORTIVE_ARTIFACTS, "");
        OMElement supportiveArtifactsNode = artifactsNode.getFirstChildWithName(qualifiedSupportiveTestArtifact);
        Iterator<?> artifactIterator = Collections.emptyIterator();

        if (supportiveArtifactsNode != null) {
            artifactIterator = supportiveArtifactsNode.getChildElements();
        }

        while (artifactIterator.hasNext()) {
            OMElement artifact = (OMElement) artifactIterator.next();

            // Read supportive artifact from synapse test data
            String supportiveArtifactData = artifact.getText();
            IResource supportiveArtifactResource = wroot.findMember(new Path(supportiveArtifactData));
            if (supportiveArtifactResource != null) {
                supportiveArtifactData = supportiveArtifactData.replace(Constants.WINDOWS_PATH_PREFIX, Constants.PATH_PREFIX);
                formPage.getUnitTestDataHolder().addSupportiveArtifacts(supportiveArtifactData);
            } 
        }

        // Read registry data
        QName qualifiedRegistryArtifact = new QName("", Constants.REGISTRY_RESOURCES, "");
        OMElement registryArtifactsNode = artifactsNode.getFirstChildWithName(qualifiedRegistryArtifact);
        Iterator<?> registryIterator = Collections.emptyIterator();

        if (registryArtifactsNode != null) {
            registryIterator = registryArtifactsNode.getChildElements();
        }

        while (registryIterator.hasNext()) {
            OMElement resource = (OMElement) registryIterator.next();

            // Read registry artifact from synapse test data
            QName qualifiedRegistryArtifactFileName = new QName("", Constants.REGISTRY_NAME, "");
            OMElement registryArtifactsNameNode = resource.getFirstChildWithName(qualifiedRegistryArtifactFileName);
            String resourceName = registryArtifactsNameNode.getText();

            QName qualifiedRegistryArtifactFilePath = new QName("", Constants.REGISTRY_PATH, "");
            OMElement registryArtifactsPathNode = resource.getFirstChildWithName(qualifiedRegistryArtifactFilePath);
            String resourcePath = registryArtifactsPathNode.getText();

            QName qualifiedRegistryArtifactFile = new QName("", Constants.ARTIFACT, "");
            OMElement registryArtifactsFileNode = resource.getFirstChildWithName(qualifiedRegistryArtifactFile);
            String resourceArtifact = registryArtifactsFileNode.getText();

            QName qualifiedRegistryArtifactMediaType = new QName("", Constants.REGISTRY_MEDIA_TYPE, "");
            OMElement registryArtifactsMediaTypeNode = resource
                    .getFirstChildWithName(qualifiedRegistryArtifactMediaType);
            String resourceMediaType = registryArtifactsMediaTypeNode.getText();

            RegistryResource registryResource = new RegistryResource();
            registryResource.setFileName(resourceName);
            registryResource.setAbsolutePath(resourceArtifact);
            registryResource.setFilePath(resourcePath);
            registryResource.setMediaType(resourceMediaType);
            formPage.getUnitTestDataHolder().addRegistryResource(registryResource);
        }

        // Add connector resource data
        QName qualifiedConnectorResources = new QName("", Constants.CONNECTOR_RESOURCES, "");
        OMElement connectorResourcesNode = artifactsNode.getFirstChildWithName(qualifiedConnectorResources);
        Iterator<?> connectorIterator = Collections.emptyIterator();

        if (connectorResourcesNode != null) {
            connectorIterator = connectorResourcesNode.getChildElements();
        }

        while (connectorIterator.hasNext()) {
            OMElement resource = (OMElement) connectorIterator.next();
            String connectorResourceFile = resource.getText();
            connectorResourceFile = connectorResourceFile.replace(Constants.WINDOWS_PATH_PREFIX, Constants.PATH_PREFIX);
            formPage.getUnitTestDataHolder().addConnectorFile(connectorResourceFile);
        }
    }

    /**
     * Method of reading test case input data from source code.
     * 
     * @param testCase
     *            test case data object
     * @param testCaseInputNode
     *            source code as in OMElement
     */
    private static void readTestCaseInputData(OMElement testCaseInputNode, TestCase testCase) {
        QName qualifiedInputPayload = new QName("", Constants.PAYLOAD, "");
        OMElement testCaseInputPayloadNode = testCaseInputNode.getFirstChildWithName(qualifiedInputPayload);

        if (testCaseInputPayloadNode != null) {
            String inputPayload = testCaseInputPayloadNode.getText();
            if (inputPayload != null && !inputPayload.isEmpty()) {
                inputPayload = CommonUtil.addCDATATagToPayloads(inputPayload);
            }
            testCase.setInputPayload(inputPayload);
        }

        QName qualifiedInputRequestPath = new QName("", Constants.REQUEST_PATH, "");
        OMElement testCaseRequestPathNode = testCaseInputNode.getFirstChildWithName(qualifiedInputRequestPath);

        if (testCaseRequestPathNode != null) {
            String requestPath = testCaseRequestPathNode.getText();
            testCase.setRequestPath(requestPath);
        }

        QName qualifiedInputRequestMethod = new QName("", Constants.REQUEST_METHOD, "");
        OMElement testCaseRequestMethodNode = testCaseInputNode.getFirstChildWithName(qualifiedInputRequestMethod);

        if (testCaseRequestMethodNode != null) {
            String requestMethod = testCaseRequestMethodNode.getText();
            testCase.setRequestMethod(requestMethod);
        }

        QName qualifiedInputProperties = new QName("", Constants.PROPERTIES, "");
        OMElement testCaseInputPropertyNode = testCaseInputNode.getFirstChildWithName(qualifiedInputProperties);

        if (testCaseInputPropertyNode != null) {
            Iterator<?> propertyIterator = testCaseInputPropertyNode.getChildElements();

            while (propertyIterator.hasNext()) {
                OMElement propertyNode = (OMElement) (propertyIterator.next());

                String propName = propertyNode.getAttributeValue(new QName(Constants.NAME));
                String propValue = propertyNode.getAttributeValue(new QName(Constants.VALUE));
                String propScope = null;

                if (propertyNode.getAttributeValue(new QName(Constants.PROPERTY_SCOPE)) != null) {
                    propScope = propertyNode.getAttributeValue(new QName(Constants.PROPERTY_SCOPE));
                } else {
                    propScope = Constants.SYNAPSE_LEVEL;
                }

                InputProperty property = new InputProperty();
                property.setName(propName);;
                property.setValue(propValue);
                property.setScope(propScope);

                testCase.addPropertyMap(propName, property);
            }
        }
    }

    /**
     * Method of reading test case assertion data from source code.
     * 
     * @param testCase
     *            test case data object
     * @param testCaseAssertionNode
     *            source code as in OMElement
     */
    private static void readTestCaseAssertions(OMElement testCaseAssertionNode, TestCase testCase) {
        // Read assertions - AssertEquals of test-case node
        Iterator<?> assertEqualsIterator = testCaseAssertionNode
                .getChildrenWithName(new QName(Constants.ASSERT_EQUALS));

        while (assertEqualsIterator.hasNext()) {
            Assertion assertion = new Assertion();
            OMElement assertEqualNode = (OMElement) (assertEqualsIterator.next());

            QName qualifiedAssertActual = new QName("", Constants.ASSERT_ACTUAL, "");
            OMElement assertActualNode = assertEqualNode.getFirstChildWithName(qualifiedAssertActual);
            String actual = assertActualNode.getText();
            assertion.setActual(actual);

            QName qualifiedAssertMessage = new QName("", Constants.ASSERT_MESSAGE, "");
            OMElement assertMessageNode = assertEqualNode.getFirstChildWithName(qualifiedAssertMessage);
            String message = assertMessageNode.getText();
            assertion.setMessage(message);

            QName qualifiedExpectedMessage = new QName("", Constants.ASSERT_EXPECTED, "");
            OMElement assertExpectedNode = assertEqualNode.getFirstChildWithName(qualifiedExpectedMessage);
            String expected = assertExpectedNode.getText();
            if (expected != null && !expected.isEmpty()) {
                expected = CommonUtil.addCDATATagToPayloads(expected);
            }
            assertion.setExpected(expected);
            assertion.setAssertType(Constants.ASSERT_EQUAL_TYPE);

            testCase.addAssertion(Constants.ASSERT_EQUAL_TYPE + "-" + actual, assertion);
        }

        // Read assertions - AssertNotNull of test-case node
        Iterator<?> assertNotNullIterator = testCaseAssertionNode
                .getChildrenWithName(new QName(Constants.ASSERT_NOTNULL));
        while (assertNotNullIterator.hasNext()) {
            Assertion assertion = new Assertion();

            OMElement assertEqualNode = (OMElement) (assertNotNullIterator.next());
            QName qualifiedAssertActual = new QName("", Constants.ASSERT_ACTUAL, "");
            OMElement assertActualNode = assertEqualNode.getFirstChildWithName(qualifiedAssertActual);
            String actual = assertActualNode.getText();
            assertion.setActual(actual);

            QName qualifiedAssertMessage = new QName("", Constants.ASSERT_MESSAGE, "");
            OMElement assertMessageNode = assertEqualNode.getFirstChildWithName(qualifiedAssertMessage);
            String message = assertMessageNode.getText();
            assertion.setMessage(message);
            assertion.setAssertType(Constants.ASSERT_NOTNULL_TYPE);

            testCase.addAssertion(Constants.ASSERT_NOTNULL_TYPE + "-" + actual, assertion);
        }
    }

    /**
     * Method of reading mock service data from source code.
     * 
     * @param formPage
     *            formPage of unit test suite
     * @param mockServicesNode
     *            source code as in OMElement
     * @param wroot workspace root
     */
    private static void readAndStoreMockServiceData(OMElement mockServicesNode, SynapseUnitTestFormPage formPage,
            IWorkspaceRoot wroot) {
        // check whether descriptor data has mock services
        if (mockServicesNode != null) {
            // Iterate through mock-service in descriptor data
            Iterator<?> iterator = mockServicesNode.getChildElements();

            while (iterator.hasNext()) {
                OMElement mockServiceNode = (OMElement) (iterator.next());
                String mockServicePath = mockServiceNode.getText();
                IResource mockServiceResource = wroot.findMember(new Path(mockServicePath));
                if (mockServiceResource != null) {
                    mockServicePath = mockServicePath.replace(Constants.WINDOWS_PATH_PREFIX, Constants.PATH_PREFIX);
                    formPage.getUnitTestDataHolder().addMockServices(mockServicePath);
                }
            }
        }
    }
}
