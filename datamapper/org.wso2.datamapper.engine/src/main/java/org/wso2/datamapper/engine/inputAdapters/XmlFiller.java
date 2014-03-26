package org.wso2.datamapper.engine.inputAdapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericData.Array;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;

public class XmlFiller implements InputDataReaderAdapter{
	
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
	
	public GenericRecord getFinalRecord(Schema schema){

	      GenericRecord root = new GenericData.Record(schema);
	      List<Field> fields = schema.getFields();
	      Map<String,Type> schemaTypeMap = new HashMap<String, Type>();
	      for (Field field : fields) {
	    	  schemaTypeMap.put(field.name(), field.schema().getType());
	      }
	      
			 Iterator childElements = documentElement.getChildElements();
			 ArrayList<GenericRecord> GenericRecordlist = new ArrayList<GenericRecord>();
			 Schema schemaArray=null;
			 String arrayName=null;
			 while(childElements.hasNext()){
			    	OMElement next = (OMElement)childElements.next();
			    	Type type = schemaTypeMap.get(next.getLocalName());
			    	if(type==Schema.Type.RECORD){
			    		Schema schema2 = schema.getField(next.getLocalName()).schema();
			    		GenericRecord rootrec = new GenericData.Record(schema2);
			    		GenericRecord childRecord = getChildRecord(childElements, rootrec);
			    		root.put(next.getLocalName(), childRecord);
			    	}else if(type==Schema.Type.ARRAY){
			    		   schemaArray = schema.getField(next.getLocalName()).schema();
			    		   arrayName = next.getLocalName();
			    		   Iterator<OMElement> childElements2 = next.getChildElements();
			    		   GenericRecord child = getChild(next, childElements2);
			    		   GenericRecordlist.add(child);
			    	}else{
			    		 root.put(next.getLocalName(), next.getText());
			    	}			    
			    }
			 	if(schemaArray!=null){
			 			if(0<GenericRecordlist.size()){
					 
			 					Array<GenericRecord> employeeArray = new GenericData.Array<GenericRecord>(GenericRecordlist.size(),schemaArray);
			 						for (GenericRecord genericRecord : GenericRecordlist) {
			 								employeeArray.add(genericRecord) ;
			 							}
			 						root.put(arrayName, employeeArray);
			 			}
			 	}
	     
 
			  return root;
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

 public GenericRecord getChildRecord(Iterator<OMElement> childIter,GenericRecord rootRecord) {
		
		OMElement childElement = null;
		String childName;	
			
		childElement = childIter.next();
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
	private GenericRecord getChild(OMElement element, Iterator<OMElement> childIter) {
		
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
