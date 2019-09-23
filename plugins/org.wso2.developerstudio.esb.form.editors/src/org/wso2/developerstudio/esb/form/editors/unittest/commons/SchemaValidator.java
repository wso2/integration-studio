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
package org.wso2.developerstudio.esb.form.editors.unittest.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.esb.form.editors.Activator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * This class represents the XSD validation of the unit test and mock service
 * source view. Checks source is valid with XSD and if not throws a
 * RuntimeException with error
 */
public class SchemaValidator {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    // in-memory loading of XSD
    private static String mockServiceXsdSource = null;
    private static String synapseUnitTestXsdSource = null;

    /**
     * Method of checking source with XSD for mock service configuration.
     *
     * @param xmlSource
     *            xml source as string
     */
    public static void isValidMockServiceConfigurationXML(String xmlSource) throws RuntimeException {
        try {
            if (mockServiceXsdSource == null) {
                URL url = new URL("platform:/plugin" + File.separator + Constants.SCHEMA_VALIDATOR_PLUGIN_ID
                        + File.separator + Constants.SCHEMA_DIR + File.separator + "mockServiceValidation.xsd");
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                mockServiceXsdSource = org.apache.commons.io.IOUtils.toString(in);
                in.close();
            }
            validateXML(xmlSource, mockServiceXsdSource);
        } catch (IOException e) {
            log.error("IOException while validating mock service xsd", e);
        }
    }

    /**
     * Method of checking source with XSD for unit test configuration.
     *
     * @param xmlSource
     *            xml source as string
     */
    public static void isValidUnitTestConfigurationXML(String xmlSource) throws RuntimeException {
        try {
            if (synapseUnitTestXsdSource == null) {
                URL url = new URL("platform:/plugin" + File.separator + Constants.SCHEMA_VALIDATOR_PLUGIN_ID
                        + File.separator + Constants.SCHEMA_DIR + File.separator + "synapseUnitTestValidation.xsd");
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                synapseUnitTestXsdSource = org.apache.commons.io.IOUtils.toString(in);
                in.close();
            }

            validateXML(xmlSource, synapseUnitTestXsdSource);
        } catch (IOException e) {
            log.error("IOException while validating unit test xsd", e);
        }
    }

    /**
     * Method of XSD loading and validation.
     *
     * @param xmlSource
     *            xml source as string
     * @param xsdValidation
     *            xsd as a string
     */
    private static void validateXML(String xmlSource, String xsdValidation) {

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(new StringReader(xsdValidation)));
            Validator validator = schema.newValidator();

            final List<SAXParseException> sourceErrors = new LinkedList<SAXParseException>();
            validator.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    sourceErrors.add(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    sourceErrors.add(exception);
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    sourceErrors.add(exception);
                }
            });

            validator.validate(new StreamSource(new StringReader(xmlSource)));

            if (sourceErrors != null && sourceErrors.size() > 0) {
                throw new RuntimeException(sourceErrors.get(0).getMessage());
            }
        } catch (IOException e) {
            log.error("IOException while validating xsd", e);
        } catch (SAXException e) {
            log.error("SAX Exception while validating xsd", e);
        }
    }
}
