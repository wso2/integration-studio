/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.eclipse.gmf.esb.util;

import java.io.File;
import java.util.Map;

import org.w3c.dom.Document;

/**
 * This is the interface for XPath validation utility classes
 *
 */
public interface XPathValidator {

    /**
     * Returns the output of an evaluated XPath expression on a given XML file.
     * 
     * @param file XML file
     * @param xpath XPath expression
     * @return Evaluated output as a string
     */
    String getEvaluatedResult(File file, String xpath, Map<String, String> namespaces);
    
    /**
     * Returns the output of an evaluated XPath expression on a given XML string.
     * 
     * @param xml XML string
     * @param xpath XPath expression
     * @return Evaluated output as a string
     */
    String getEvaluatedResult(String xml, String xpath, Map<String, String> namespaces);
    
    /**
     * Checks the validity of an XML syntax.
     * 
     * @param xml XML string
     * @return True is valid, False otherwise
     */
    boolean isValidXML(String xml);
    
    /**
     * Returns a pretty-fied XML string from a document. 
     * 
     * @param document Document object
     * @return Pretty-fied XML string
     */
    String getFormattedXMLStringFromDoc(Document document);
    
    /**
     * Returns a pretty-fied XML string from a string. 
     * 
     * @param xmlStr XML string
     * @return Pretty-fied XML string
     */
    String getFormattedXMLStringFromString(String xmlStr);
    
    /**
     * Parses an XML string and creates a Document.
     * 
     * @param xml XML string
     * @return Document object
     */
    Document parseXML(String xml);

    /**
     * Checks if an XPath expression is valid.
     *
     * @param file XML file
     * @param xpath XPath expression
     * @return True if valid, False otherwise
     */
    boolean isValidExpression(File file, String xpath, Map<String, String> namespaces);

}
