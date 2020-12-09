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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import org.xml.sax.InputSource;

/**
 * Class responsible for handling the XML data in source views.
 */
public class CommonUtil {

    /**
     * Method for adding CDATA tag for the input payloads if string is a valid XML.
     * 
     * @param inputPayload
     *            input texts
     * @return CDATA tag added payload string
     */
    public static String addCDATATagToPayloads(String inputPayload) {
        inputPayload = inputPayload.trim();
        inputPayload = removeCDATAFromPayload(inputPayload);
        inputPayload = String.format("<![CDATA[%s]]>", inputPayload);
        return inputPayload;
    }

    /**
     * Check the input string is a XML type or not.
     *
     * @param domString
     *            inputString which about to convert
     * @return string is a XML or not
     */
    private static boolean isValidXMLDocument(String domString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(domString)));
            return true;
        } catch (Exception e) {
            if (domString.matches(".*<(\\w+)[^>]*>.*") || domString.matches(".*</*(\\w+)[^>]>.*")) {
                return true;
            }

            return false;
        }
    }

    /**
     * Method for removing CDATA tag from the input payloads.
     * 
     * @param inputPayload
     *            input texts
     * @return CDATA tag removed payload string
     */
    public static String removeCDATAFromPayload(String inputPayload) {
        if (inputPayload.startsWith("<![CDATA[")) {
            inputPayload = inputPayload.substring(9);
            int i = inputPayload.indexOf("]]>");
            if (i == -1)
                throw new IllegalStateException("argument starts with <![CDATA[ but cannot find pairing ]]>");
            inputPayload = inputPayload.substring(0, i);
        }

        return inputPayload;
    }

    /**
     * Method of replacing unescaped characters from source.
     * 
     * @param inputString
     *            input string
     */
    public static String replaceUnscapeCharacters(String inputString) {
        inputString = inputString.replaceAll("&lt;", "<");
        inputString = inputString.replaceAll("&gt;", ">");

        return inputString;
    }
}
