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

package org.wso2.developerstudio.eclipse.platform.core.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.wsdl.Definition;
import javax.wsdl.extensions.schema.Schema;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.util.XMLUtils;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.apache.axiom.om.util.AXIOMUtil;

public class XMLUtil {
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

	public static String prettify(OMElement wsdlElement) throws Exception {
		OutputStream out = new ByteArrayOutputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		wsdlElement.serialize(baos);

		Source stylesheetSource = new StreamSource(new ByteArrayInputStream(prettyPrintStylesheet.getBytes()));
		Source xmlSource = new StreamSource(new ByteArrayInputStream(baos.toByteArray()));

		TransformerFactory tf = TransformerFactory.newInstance();
		Templates templates = tf.newTemplates(stylesheetSource);
		Transformer transformer = templates.newTransformer();
		transformer.transform(xmlSource, new StreamResult(out));
		return out.toString();
	}

	/**
	 * Prettify XML content
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String prettify(String content) throws Exception {
		OMElement om = AXIOMUtil.stringToOM(content);
		return prettify(om);
	}

	/**
	 * Prettify OMElement
	 * 
	 * @param docRoot
	 * @param out
	 * @throws Exception
	 */
	public static void prettify(OMElement docRoot, OutputStream out) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		docRoot.serialize(baos);

		Source stylesheetSource = new StreamSource(new ByteArrayInputStream(prettyPrintStylesheet.getBytes()));
		Source xmlSource = new StreamSource(new ByteArrayInputStream(baos.toByteArray()));

		TransformerFactory tf = TransformerFactory.newInstance();
		Templates templates = tf.newTemplates(stylesheetSource);
		Transformer transformer = templates.newTransformer();
		transformer.transform(xmlSource, new StreamResult(out));
	}

	public static String getSchemaString(Schema schema) throws Exception {
		Element element = schema.getElement();
		return getElementString(element);
	}

	public static String getElementString(Element element) throws Exception {
		OMElement om = XMLUtils.toOM(element);
		return XMLUtil.prettify(om);
	}

	public static void writeSchema(Schema schema, OutputStream outputStream) throws Exception {
		FileUtils.createFile(getSchemaString(schema), outputStream);
	}

	public static void writeSchema(Schema schema, File file) throws Exception {
		writeSchema(schema, new FileOutputStream(file));
	}
}
