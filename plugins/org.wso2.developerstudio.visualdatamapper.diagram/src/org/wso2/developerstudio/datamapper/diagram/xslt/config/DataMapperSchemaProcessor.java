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
package org.wso2.developerstudio.datamapper.diagram.xslt.config;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class read the datamapper schema file
 *
 */
public class DataMapperSchemaProcessor {

    private Document document;

    public DataMapperSchemaProcessor(InputStream inputStream)
            throws SAXException, IOException, ParserConfigurationException {
        readyFile(inputStream);
    }

    /**
     * This method generate a document from the datamapper schema file
     * 
     * @param inputStream input stream of the datamapper schema file
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    private void readyFile(InputStream inputStream) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        this.document = documentBuilder.parse(inputStream);
    }

    public Document getDocument() {
        return this.document;
    }

}