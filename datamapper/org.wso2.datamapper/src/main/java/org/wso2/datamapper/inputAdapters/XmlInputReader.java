/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.datamapper.inputAdapters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.axiom.om.xpath.AXIOMXPath;
import org.jaxen.JaxenException;

public class XmlInputReader implements InputDataReaderAdapter {

	private OMElement documentElement;
	private List<GenericRecord> inputRecords;	
	
	@Override
	public void setInputReader(File inputFile) {
		try {
			InputStream in = new FileInputStream(inputFile);
			OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(in);
			this.documentElement = builder.getDocumentElement();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OMElement getRootElement() {
		return this.documentElement;
	}

	@Override
	public Iterator<GenericRecord> getChildItr(String xpath, Schema schema) {
		this.inputRecords = new ArrayList<GenericRecord>();
		GenericRecord inputRecord;
		try {
			AXIOMXPath xpathExpression = new AXIOMXPath (xpath);
			Iterator<OMElement> machinElementsItr = xpathExpression.selectNodes(this.documentElement).listIterator();
			
			while (machinElementsItr.hasNext()) {
				OMElement element = machinElementsItr.next();				
				
				Iterator<OMElement> childs = element.getChildElements();
				inputRecord = new GenericData.Record(schema);	
				
				while (childs.hasNext()) {
					OMElement childElement = childs.next();
					inputRecord.put(childElement.getLocalName(), childElement.getText());
				}
				this.inputRecords.add(inputRecord);
			}
			
		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return this.inputRecords.listIterator();
	}
	
}
