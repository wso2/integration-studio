/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMText;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.inst2xsd.Inst2XsdOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class SchemaGeneratorForXML extends SchemaGeneratorForJSON implements ISchemaGenerator {
	private static final String TEMP_AVRO_GEN_LOCATION = "tempXSDGenLocation";
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
	private static final String TEMP_OUTPUT = System.getProperty(JAVA_IO_TMPDIR) + File.separator + TEMP_AVRO_GEN_LOCATION;
	
	@Override
	public String getSchemaContent(String content) throws IOException {

		JSONObject xmlJSONObj;
		try {
			xmlJSONObj = XML.toJSONObject(content);
		} catch (JSONException e) {
			throw new IOException(e.getMessage());
		}

		return super.getSchemaContent(xmlJSONObj.toString());
	}


	/*
	private File generateXSDfromXML(String filePath) throws IOException, XmlException {
		
		File outputDirectory = new File(TEMP_OUTPUT);
		if (!outputDirectory.exists()) {
			outputDirectory.mkdir();
		}
		File outputFile = new File(TEMP_OUTPUT  + File.separator + "temp.xsd");
		if (outputFile.exists()) {
			outputFile.delete();
		}
		
	    Inst2XsdOptions options = new Inst2XsdOptions();
        options.setDesign(Inst2XsdOptions.DESIGN_RUSSIAN_DOLL);
        options.setSimpleContentTypes(Inst2XsdOptions.SIMPLE_CONTENT_TYPES_STRING);
        options.setUseEnumerations(Inst2XsdOptions.ENUMERATION_NEVER);
        Reader[] xmlInstance = {new BufferedReader(new FileReader(filePath))};
        SchemaDocument[] xsds = org.apache.xmlbeans.impl.inst2xsd.Inst2Xsd.inst2xsd(xmlInstance, options);
		if(xsds != null && xsds.length > 0) {
			xsds[0].save(outputFile, new  XmlOptions().setSavePrettyPrint());
		}
		 
		return outputFile;
	}
	*/

	@Override
	public String getSchemaResourcePath(String filePath) throws IOException {
		String entireFileText = FileUtils.readFileToString(new File(filePath));
		entireFileText = replaceAttributesWithElements(entireFileText);
		return getSchemaContent(entireFileText);
	}

	private String replaceAttributesWithElements(String entireFileText) throws IOException {
		try {
			OMElement element = AXIOMUtil.stringToOM(entireFileText);
			OMFactory factory = OMAbstractFactory.getOMFactory();
			element = traverseChildrenAndReplaceAttributes(element, factory);
			entireFileText = element.toString();
		} catch (XMLStreamException e) {
			throw new IOException(e);
		}
		return entireFileText;
	}

	private OMElement traverseChildrenAndReplaceAttributes(OMElement element, OMFactory factory) {

		Iterator attributeIterator = element.getAllAttributes();
		List<OMAttribute> removeList = new ArrayList<OMAttribute>();
		List<OMElement> addList = new ArrayList<OMElement>();
		
		while (attributeIterator.hasNext()) {
			OMAttribute atttrib = (OMAttribute) attributeIterator.next();
			//remove attribute and instead add a element with @ infront
			// eg <person age="30"></person> will be replaced by <person><@age>30</@age></person>
			OMElement attributeElement = factory.createOMElement("@"+ atttrib.getLocalName(), null);
			OMText attributeValue = factory.createOMText(atttrib.getAttributeValue());
			attributeElement.addChild(attributeValue);
			// add to list and later remove
			addList.add(attributeElement);
			removeList.add(atttrib);
		}
		
		for (OMAttribute arttribute : removeList ) {
			element.removeAttribute(arttribute);
		}

		if (addList.size() > 0) {
			//remove the inner text and replace it with <#@content></#@content>
			//eg <city listed="true">colombo</city> will be replaced by <city><@listed>true</@listed><#@content>colombo</#@content></city>
			String elementText = element.getText();
			if (!elementText.isEmpty()) {
				element.setText("");
				OMElement contentElement = factory.createOMElement("#@content", null);
				OMText contentValue = factory.createOMText(elementText);
				contentElement.addChild(contentValue);
				element.addChild(contentElement);
			}
			for (OMElement attrElement: addList ) {
				element.addChild(attrElement);
			}
		}
		
		
		Iterator elementIterator = element.getChildren();
		while (elementIterator.hasNext()) {
			OMNode child = (OMNode) elementIterator.next();
			if (child instanceof OMElement) {
				traverseChildrenAndReplaceAttributes((OMElement) child, factory);
			}
		}
		
		return element;
	}
}
