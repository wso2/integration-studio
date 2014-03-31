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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericData.Array;
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

	@SuppressWarnings("unchecked")
	public void setInptStream(InputStream inputStream) throws IOException {
		
		InputStream in = inputStream;
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(in);
		this.documentElement = builder.getDocumentElement();
		childElementIter = this.documentElement.getChildElements();
		
		in.close();

	}
	
public GenericRecord getChildRecord(Schema input) {
	  GenericRecord childRecord = null;
	  childRecord =  getChild(input, this.documentElement.getChildElements());
	
	/*	OMElement childElement = null;
		String childName;	
			
		childElement = childElementIter.next();
		childName = childElement.getLocalName();
		
		if((childIter == null) || (!childIter.hasNext())){
			childIter = childElement.getChildElements();
		}
		
		 
		Schema schema = inputSchemaMap.get(childElement.getLocalName());
		if(schema instanceof Schema){
			childRecord =  getChild(input, this.documentElement.getChildElements());
		}
		
			
		if ((childRecord == null) && (arrayChildList == null)) {	
			rootRecord.put(childName, childElement.getText());
		}*/
		return childRecord;
	}

	private GenericRecord getChild(Schema schema, Iterator<OMElement> iter) {
		GenericRecord record = new GenericData.Record(schema);
        
		while (iter.hasNext()) {
			OMElement element = iter.next();
			String localName = element.getLocalName();
			Field field = schema.getField(localName);
			 
			//schema.g
			if(field!=null){
				if(field.schema().getType().equals(Type.ARRAY)){
					Iterator childElements = element.getChildElements();
					GenericRecord child = getChild(field.schema().getElementType(), childElements);
					Object object = record.get(localName);
					if(object==null){
						 // FIXME: I know this is bad, 32 just used for save the time  
						 Array<GenericRecord> childArray = new GenericData.Array<GenericRecord>(32,field.schema());
						 childArray.add(child);
						 record.put(localName,childArray);
					} else{
						 Array<GenericRecord> childArray = (Array<GenericRecord>) object;
						 childArray.add(child);
					}
				} else if(field.schema().getType().equals(Type.RECORD)){
					Iterator childElements = element.getChildElements();
					GenericRecord child = getChild(field.schema(), childElements);
					record.put(localName, child);
				} else{
					record.put(localName, element.getText());
					//TODO: fix for other types too... !(ARRAY||RECORD) != primitive type
				}
			} else{
			}

		}
		return record;
	}
}
