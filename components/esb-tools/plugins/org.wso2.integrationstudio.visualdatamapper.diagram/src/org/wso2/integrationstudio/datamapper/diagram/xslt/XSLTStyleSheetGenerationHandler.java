/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.datamapper.diagram.xslt;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.wso2.integrationstudio.datamapper.diagram.xslt.config.DataMapperSchemaProcessor;
import org.wso2.integrationstudio.datamapper.diagram.xslt.config.XSLTStyleSheetWriter;
import org.xml.sax.SAXException;

/**
 * This class handle generation of the xslt stylesheet.
 */
public class XSLTStyleSheetGenerationHandler {

    private static XSLTStyleSheetGenerationHandler instance;

    public static XSLTStyleSheetGenerationHandler getInstance() {
        if (instance == null) {
            instance = new XSLTStyleSheetGenerationHandler();
        }
        return instance;
    }

    /**
     * This method generate xslt stylesheet and handle exception relevant to the generation
     * 
     * @param schemaInPutSource datamapper schema file as an input stream
     * @return content that need to be written to the xslt stylesheet
     * @throws TransformerException 
     * @throws ParserConfigurationException
     * @throws IOException 
     * @throws SAXException 
     */
    public String generate(InputStream schemaInPutSource) throws TransformerException, SAXException, IOException, ParserConfigurationException {
        DataMapperSchemaProcessor inputXML = new DataMapperSchemaProcessor(schemaInPutSource);
        XSLTStyleSheetWriter outputXML = new XSLTStyleSheetWriter();
        XSLTGenerator xsltGenerator = new XSLTGenerator();
        // when there is a custom function operator xslt is not applicable
        boolean xsltApplicable = xsltGenerator.initializeGeneration(inputXML, outputXML);
        if (xsltApplicable) {
            xsltGenerator.generateStyleSheet(outputXML);
        }
        return outputXML.getStyleSheet();
    }

}
