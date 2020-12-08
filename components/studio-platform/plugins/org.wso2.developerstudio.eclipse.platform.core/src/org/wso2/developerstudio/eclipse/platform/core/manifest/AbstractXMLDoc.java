/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.manifest;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.core.internal.runtime.Log;
import org.eclipse.core.resources.IFile;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public abstract class AbstractXMLDoc extends AbstractManifest {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	public static OMFactory factory = OMAbstractFactory.getOMFactory();

	protected List<OMElement> getChildElements(OMElement parentElement, String tagName) {
		List<OMElement> elements = new ArrayList<OMElement>();
		Iterator children = parentElement.getChildren();
		while (children.hasNext()) {
			Object o = children.next();
			if (o instanceof OMElement) {
				OMElement child = (OMElement) o;
				if (tagName == null || tagName.trim().equals("") || child.getLocalName().equals(tagName)) {
					elements.add(child);
				}
			}
		}
		return elements;
	}

	protected String getAttribute(OMElement element, String attributeName) {
		return element.getAttributeValue(new QName(attributeName));
	}

	protected OMElement getElement(String localName, String text) {
		OMElement element = factory.createOMElement(new QName(localName));
		element.setText(text);
		return element;
	}

	protected OMElement getElement(String xmlString) throws XMLStreamException {
		return AXIOMUtil.stringToOM(xmlString);
	}

	protected OMElement addAttribute(OMElement element, String attributeName, String attributeValue) {
		element.addAttribute(attributeName, attributeValue, null);
		return element;
	}

	private static final String prettyPrintStylesheet =
	                                                    "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0' "
	                                                            + " xmlns:xalan='http://xml.apache.org/xslt' "
	                                                            + " exclude-result-prefixes='xalan'>"
	                                                            + "  <xsl:output method='xml' indent='yes' xalan:indent-amount='4'/>"
	                                                            + "  <xsl:strip-space elements='*'/>"
	                                                            + "  <xsl:template match='/'>"
	                                                            + "    <xsl:apply-templates/>"
	                                                            + "  </xsl:template>"
	                                                            + "  <xsl:template match='node() | @*'>"
	                                                            + "        <xsl:copy>"
	                                                            + "          <xsl:apply-templates select='node() | @*'/>"
	                                                            + "        </xsl:copy>" + "  </xsl:template>"
	                                                            + "</xsl:stylesheet>";

	protected static void prettify(OMElement wsdlElement, OutputStream out) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		wsdlElement.serialize(baos);

		Source stylesheetSource = new StreamSource(new ByteArrayInputStream(prettyPrintStylesheet.getBytes()));
		Source xmlSource = new StreamSource(new ByteArrayInputStream(baos.toByteArray()));

		TransformerFactory tf = TransformerFactory.newInstance();
		Templates templates = tf.newTemplates(stylesheetSource);
		Transformer transformer = templates.newTransformer();
		transformer.transform(xmlSource, new StreamResult(out));
	}

	protected String getPretifiedString(OMElement documentElement) throws Exception {
		String result;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		prettify(documentElement, outputStream);
		result = outputStream.toString();
		return result;
	}

	public void deserialize(File file) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(file);
		deserialize(fileInputStream);
		try {
			fileInputStream.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void deserialize(IFile file) throws Exception {
		deserialize(file.getContents());
	}

	public void deserialize(InputStream stream) throws Exception {
		XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(stream);
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement = builder.getDocumentElement();
		deserialize(documentElement);
	}

	public void deserialize(String xml) throws Exception {
		XMLStreamReader parser =
		                         XMLInputFactory.newInstance()
		                                        .createXMLStreamReader(new ByteArrayInputStream(xml.getBytes()));
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement = builder.getDocumentElement();
		deserialize(documentElement);
	}

	protected abstract void deserialize(OMElement documentElement) throws Exception;

	protected abstract String serialize();

	public String toString() {
		return serialize();
	}

}
