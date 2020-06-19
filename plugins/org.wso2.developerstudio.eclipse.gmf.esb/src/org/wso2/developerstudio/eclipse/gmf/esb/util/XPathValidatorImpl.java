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

package org.wso2.developerstudio.eclipse.gmf.esb.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathExecutable;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;

/**
 * This utility class is used to validate and evaluate XPath 1.0 and 2.0 expressions
 *
 */
public class XPathValidatorImpl implements XPathValidator {

    private static XPathValidator instance = new XPathValidatorImpl();
    
    private static final String FORMAT_PRETTY_PRINT = "format-pretty-print";
    
    private static IDeveloperStudioLog log = Logger.getLog("org.wso2.developerstudio.eclipse.gmf.esb.util");

    private XPathValidatorImpl() {
    }

    public static XPathValidator getInstance() {
        return instance;
    }

    @Override
    public String getEvaluatedResult(File file, String xpath, Map<String, String> namespaces) {
        Iterable<XdmItem> itemListItr = evaluate(file, xpath, namespaces);

        return getItemListAsString(itemListItr);
    }
    
    @Override
    public String getEvaluatedResult(String xml, String xpath, Map<String, String> namespaces) {
        return getItemListAsString(getIterableXpathResult(xml, xpath, namespaces));
    }

    @Override
    public boolean isValidExpression(File file, String xpath, Map<String, String> namespaces) {
        Iterable<XdmItem> itemListItr = evaluate(file, xpath, namespaces);
        if (itemListItr != null) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean isValidXML(String xml) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder builder = null;
        InputSource inputSource = new InputSource(new StringReader(xml));
        
        try {
            builder = factory.newDocumentBuilder();
            builder.parse(inputSource);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            log.error("Could not parse XML String", e);
            return false;
        }
        
        return true;
    }
    
    @Override
    public Document parseXML(String xml) {
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder builder = null;
        InputSource inputSource = new InputSource(new StringReader(xml));
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(inputSource);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error("Could not parse XML string", e);
        }
        return document;
    }
    
    @Override
    public String getFormattedXMLStringFromDoc(Document document) {
        DOMImplementation domImplementation = document.getImplementation();
        if (domImplementation.hasFeature("LS", "3.0") && domImplementation.hasFeature("Core", "2.0")) {
            DOMImplementationLS domImplementationLS = (DOMImplementationLS) domImplementation.getFeature("LS", "3.0");
            LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
            DOMConfiguration domConfiguration = lsSerializer.getDomConfig();
            
            if (domConfiguration.canSetParameter(FORMAT_PRETTY_PRINT, Boolean.TRUE)) {
                lsSerializer.getDomConfig().setParameter(FORMAT_PRETTY_PRINT, Boolean.TRUE);
                StringWriter stringWriter = new StringWriter();
                
                LSOutput lsOutput = domImplementationLS.createLSOutput();
                lsOutput.setEncoding(StandardCharsets.UTF_8.name());
                lsOutput.setCharacterStream(stringWriter);
                lsSerializer.write(document, lsOutput);
                
                return stringWriter.toString();
            } else {
                throw new UnsupportedOperationException("DOMConfiguration 'format-pretty-print' parameter isn't settable.");
            }
            
        } else {
            throw new UnsupportedOperationException("DOM 3.0 LS and/or DOM 2.0 Core not supported.");
        }
    }
    
    @Override
    public String getFormattedXMLStringFromString(String xmlStr) {
        Document document = parseXML(xmlStr);
        
        DOMImplementation domImplementation = document.getImplementation();
        if (domImplementation.hasFeature("LS", "3.0") && domImplementation.hasFeature("Core", "2.0")) {
            DOMImplementationLS domImplementationLS = (DOMImplementationLS) domImplementation.getFeature("LS", "3.0");
            LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
            DOMConfiguration domConfiguration = lsSerializer.getDomConfig();
            
            if (domConfiguration.canSetParameter(FORMAT_PRETTY_PRINT, Boolean.TRUE)) {
                lsSerializer.getDomConfig().setParameter(FORMAT_PRETTY_PRINT, Boolean.TRUE);
                StringWriter stringWriter = new StringWriter();
                
                LSOutput lsOutput = domImplementationLS.createLSOutput();
                lsOutput.setEncoding(StandardCharsets.UTF_8.name());
                lsOutput.setCharacterStream(stringWriter);
                lsSerializer.write(document, lsOutput);
                
                return stringWriter.toString();
            } else {
                throw new UnsupportedOperationException("DOMConfiguration 'format-pretty-print' parameter isn't settable.");
            }
            
        } else {
            throw new UnsupportedOperationException("DOM 3.0 LS and/or DOM 2.0 Core not supported.");
        }
    }

    private Iterable<XdmItem> evaluate(File file, String xpath, Map<String, String> namespaces) {
        Processor processor = new Processor(false);
        XPathCompiler compiler = processor.newXPathCompiler();
        Iterable<XdmItem> itemListItr = null;
        
        for (String nsURI : namespaces.keySet()) {
            compiler.declareNamespace(nsURI, namespaces.get(nsURI));
        }

        try {
            XdmNode document = processor.newDocumentBuilder().build(file);
            XPathExecutable executable = compiler.compile(xpath);
            XPathSelector selector = executable.load();

            selector.setContextItem(document);
            itemListItr = selector.evaluate();
        } catch (SaxonApiException e) {
            log.error("Could not evaluate XPath expression", e);
        }
        
        return itemListItr;
    }

    private String getItemListAsString(Iterable<XdmItem> itemList) {
        String outputStr = "";
        Iterator<XdmItem> itr = itemList.iterator();

        while (itr.hasNext()) {
            XdmItem element = (XdmItem) itr.next();
            outputStr += element.toString();
        }
        
        return outputStr;
    }

    private Iterable<XdmItem> getIterableXpathResult(String xmlString, String xpathExpression,
            Map<String, String> namespaces) {
        Processor proc = new Processor(false);
        XPathCompiler compiler = proc.newXPathCompiler();

        for (String nsURI : namespaces.keySet()) {
            compiler.declareNamespace(nsURI, namespaces.get(nsURI));
        }

        DocumentBuilder documentBuilder = proc.newDocumentBuilder();
        StringReader reader = new StringReader(xmlString);
        XPathSelector selector = null;
        try {
            XdmNode item = documentBuilder.build(new StreamSource(reader));
            selector = compiler.compile(xpathExpression).load();
            selector.setContextItem(item);
        } catch (SaxonApiException e) {
            log.error("Could not evaluate XPath expression", e);
        }

        return selector;
    }

}
