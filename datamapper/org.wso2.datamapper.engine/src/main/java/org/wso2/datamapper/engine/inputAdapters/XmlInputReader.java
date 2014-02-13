/*
 * Copyright 2005,2013 WSO2, Inc. http://www.wso2.org
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
package org.wso2.datamapper.engine.inputAdapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;

public class XmlInputReader implements InputDataReaderAdapter{

	private OMElement documentElement;	
	private Iterator<OMElement> childElementIter;
	private Map<String, Schema> inputSchemaMap;
	private GenericRecord rootRecord;
	private Iterator<OMElement> childIter;
	private boolean hasComplexChilds;
	private List<GenericRecord> arrayChildList;

	public boolean hasChildRecords() {
		
		if(hasComplexChilds){
			return hasComplexChilds;
		}	
		return childElementIter.hasNext();
	}

	public List<GenericRecord> getArrayChildList() {
		return arrayChildList;
	}

	public void setInputSchemaMap(Map<String, Schema> inputSchemaMap) {
		this.inputSchemaMap = inputSchemaMap;
	}

	public GenericRecord getRootRecord() {
		return rootRecord;
	}

	public void setRootRecord(GenericRecord rootRecord) {
		this.rootRecord = rootRecord;
	}

	public void setInptStream(InputStream inputStream) throws IOException {
		
		InputStream in = inputStream;
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(in);
		this.documentElement = builder.getDocumentElement();
		childElementIter = this.documentElement.getChildElements();
		
		in.close();

	}
	
	public GenericRecord getChildRecord() {
		
		OMElement childElement = null;
		String childName;	
			
		childElement = childElementIter.next();
		childName = childElement.getLocalName();
		
		if((childIter == null) || (!childIter.hasNext())){
			childIter = childElement.getChildElements();
		}
		
		GenericRecord childRecord = getChild(childElement,childIter);
			
		if ((childRecord == null) && (arrayChildList == null)) {	
			rootRecord.put(childName, childElement.getText());
		}
	
		return childRecord;
	}

	public GenericRecord getChild(OMElement element, Iterator<OMElement> childIter) {
		
		GenericRecord childRec = null;
		OMElement parentElement = element;	
		String parentId = parentElement.getLocalName();
		Schema sc = inputSchemaMap.get(parentId);	
		boolean isArray = false;
				
		if(sc != null) {
			OMElement childElement = null;
			
			if( sc.getType() == Schema.Type.RECORD){
				childRec = new GenericData.Record(sc);							
			}else if(sc.getType() == Schema.Type.ARRAY){
				if(this.arrayChildList == null){
					this.arrayChildList = new ArrayList<GenericRecord>();	
				}
				childRec = new GenericData.Record(sc.getElementType());
				isArray = true;
			}	
			
			while (childIter.hasNext()) {
				childElement = childIter.next();
				GenericRecord tempRec = getChild(childElement, childElement.getChildElements());
				
				if(tempRec != null){
					if(!isArray){
						childRec.put(childElement.getLocalName(), tempRec);
					}else{
						arrayChildList.add(tempRec);
					}
				}else{
					childRec.put(childElement.getLocalName(), childElement.getText());
				}
			}
			if(isArray){
				return null;
			}
		}
		
		return childRec;
	}
}
