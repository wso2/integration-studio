/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.extensions;

import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.UnknownExtensionSerializer;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.apache.xerces.util.DOMUtil;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.wst.wsdl.UnknownExtensibilityElement;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ibm.wsdl.util.xml.DOM2Writer;

public class BPELUnknownExtensionSerializer extends UnknownExtensionSerializer implements BPELExtensionSerializer {
	
	public void marshall(Class parentType, QName elementType, ExtensibilityElement extension, Node parentNode, Process process, ExtensionRegistry extReg, BPELWriter bpelWriter) throws WSDLException {
		Map<String,String> nsMap = BPELUtils.getNamespaceMap(process);
		Element unknownElement = null;
		
		if (elementType.getLocalPart().equals("extensibilityAttributes")) {
            UnknownExtensibilityElement unknownExt = (UnknownExtensibilityElement) extension;
			DOMUtil.copyInto(unknownExt.getElement(), parentNode);
		} else {
			UnknownExtensibilityElement unknownExt = (UnknownExtensibilityElement) extension;
			unknownElement = unknownExt.getElement();	
		}	
		
		if (unknownElement != null) {
			StringWriter writer = new StringWriter();
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");									
			DOM2Writer.serializeAsXML(unknownElement, writer);
			Document document = load(writer);
			Element element = document.getDocumentElement();
			
			// remove any ns prefix that has already existed in the process level
			removeRepeatedNamespaceDecl(element, nsMap);			
			DOMUtil.copyInto(element, parentNode);
		}			
	}
	
	protected void removeRepeatedNamespaceDecl(Element element, Map nsMap) {
		List removeList = new ArrayList();						
		NamedNodeMap nodeMap = element.getAttributes();
		for (int i=0; i < nodeMap.getLength(); i++) {
			Attr attr = (Attr)nodeMap.item(i);
			String nsURI = attr.getNamespaceURI();
			String name = attr.getLocalName();
			String value = attr.getValue();
			if (XSDConstants.XMLNS_URI_2000.equals(nsURI)) {
				if (nsMap.containsKey(name) && value.equals(nsMap.get(name)))
					removeList.add(attr); 						
			}				
		}
		for (int i=0; i < removeList.size(); i++) {
			element.removeAttributeNode((Attr)removeList.get(i));
		}
		
		NodeList children = element.getChildNodes();
		for (int i=0; i < children.getLength(); i++) {
			if (children.item(i) instanceof Element)
				removeRepeatedNamespaceDecl((Element)children.item(i), nsMap);
		}
	}		
		
	protected Document load(StringWriter writer) {
		// Create DOM document
		DocumentBuilderFactory factory = new DocumentBuilderFactoryImpl();
		factory.setNamespaceAware(true);
		factory.setValidating(false);
				
		try {
			StringBufferInputStream stream = new StringBufferInputStream(writer.getBuffer().toString());
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputStreamReader reader = new InputStreamReader(stream, "UTF8");
			InputSource source = new InputSource(reader);
			source.setEncoding("UTF8");
			Document document = builder.parse(source);
			return document;
		}
		catch (Exception e) {
			return null;
		}		
	}
}
