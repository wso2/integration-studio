/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb.util;

import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

/**
 * Collection of utility methods.
 */
public class EsbUtils {
	/**
	 * Private instance.
	 */
	private static EsbUtils instance;
	
	/**
	 * Private constructor.
	 */
	private EsbUtils() {
		
	}
	
	/**
	 * Utility method for retrieving a reference to global {@link EsbUtils} instance.
	 * 
	 * @return {@link EsbUtils} singleton.
	 */
	public static EsbUtils getInstance() {
		if (null == instance) {
			instance = new EsbUtils();
		}
		return instance;
	}
	
	/**
	 * Utility method for rendering an {@link Element} into an {@link OutputStream}.
	 * 
	 * @param element {@link Element} to be rendered.
	 * @param os {@link OutputStream} instance.
	 * @param omitXmlDeclaration whether to omit the XML declaration from output.
	 * @throws Exception if an error occurs during serialization.
	 */
	public static void renderElement(Element element, OutputStream os, boolean omitXmlDeclaration) throws Exception {
		OutputStreamWriter writer = new OutputStreamWriter(os);
		renderElement(element, writer, omitXmlDeclaration);
	}
	
	/**
	 * Utility method for rendering an {@link Element} into a string.
	 * 
	 * @param element {@link Element} to be rendered.
	 * @param omitXmlDeclaration whether to omit the XML declaration from output.
	 * @param omitDefaultNs whether to omit the default XML namespace .
	 * @return string serialized form of the given element.
	 * @throws Exception if an error occurs during serialization.
	 */
	public static String renderElement(Element element,  boolean omitXmlDeclaration,boolean omitDefaultNs ) throws Exception {
		StringWriter writer = new StringWriter();
		renderElement(element, writer, omitXmlDeclaration);;
		String xml = writer.toString();
		if(omitDefaultNs){
			xml = xml.replaceFirst(Pattern.quote("xmlns=\"" + element.getNamespaceURI() +"\""),"");
		}
		return xml;
	}
	
	
	/**
	 * Utility method for rendering an {@link Element} into a string.
	 * 
	 * @param element {@link Element} to be rendered.
	 * @param omitXmlDeclaration whether to omit the XML declaration from output.
	 * @return string serialized form of the given element.
	 * @throws Exception if an error occurs during serialization.
	 */
	public static String renderElement(Element element,  boolean omitXmlDeclaration) throws Exception {
		StringWriter writer = new StringWriter();
		renderElement(element, writer, omitXmlDeclaration);
		return writer.toString();
	}
	
	/**
	 * Utility method for rendering an {@link Element} into a {@link Writer}.
	 * 
	 * @param element {@link Element} to be rendered.
	 * @param writer {@link Writer} instance.
	 * @param omitXmlDeclaration whether to omit the XML declaration from output.
	 * @throws Exception if an error occurs during serialization.
	 */
	public static void renderElement(Element element, Writer writer, boolean omitXmlDeclaration) throws Exception {
		DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
		DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
		
		LSSerializer lsSerializer = impl.createLSSerializer();		
		{
			DOMConfiguration domConfiguration = lsSerializer.getDomConfig();
			if (domConfiguration.canSetParameter("format-pretty-print", Boolean.TRUE)) {
				domConfiguration.setParameter("format-pretty-print", Boolean.TRUE);
			}
			
			if (omitXmlDeclaration && domConfiguration.canSetParameter("xml-declaration", Boolean.FALSE)) {
				domConfiguration.setParameter("xml-declaration", Boolean.FALSE);
			}
		}
		
		LSOutput lsOutput = impl.createLSOutput();
		lsOutput.setEncoding("UTF-8");
		lsOutput.setCharacterStream(writer);
		
		lsSerializer.write(element, lsOutput);
	}	
	
	/**
	 * Utility method for parsing an xml string into an {@link Element}.
	 * 
	 * @param xml source string.
	 * @return {@link Element} corresponding to the specified xml string.
	 * @throws Exception if an error occurs while parsing.
	 */
	public static Element parseElement(String xml) throws Exception {
		return parseElement(xml,true);
	}	
	
	/**
	 * Utility method for parsing an xml string into an {@link Element}.
	 * 
	 * @param xml source string.
	 * @param namespaceAware namespace Aware.
	 * @return {@link Element} corresponding to the specified xml string.
	 * @throws Exception if an error occurs while parsing.
	 */
	public static Element parseElement(String xml, boolean namespaceAware) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(namespaceAware);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xml)));
		return document.getDocumentElement();
	}	
	
	/**
	 * Utiliy method for checking if an {@link Element} has a child with the given local name.
	 * 
	 * @param parent parent {@link Element}.
	 * @param localName local name of the child {@link Element}.
	 * @return true if the given parent has a child with the specified local name, false otherwise.
	 */
	public static boolean elementContainsChild(Element parent, String localName) {
		NodeList children = parent.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.getLocalName().equalsIgnoreCase(localName)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Utility method for constructing a {@link Document} from an XML file.
	 * 
	 * @param file
	 *            {@link File} containing the XML string.
	 * @return a {@link Document} instance representing the XML structure.
	 * @throws Exception
	 *             if an error is encountered while reading the file or parsing
	 *             its content.
	 */
	public static Document parseDocument(File file) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(file);
	}
}
