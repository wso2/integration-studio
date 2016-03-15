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

package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.io.FileUtils;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.odysseus.staxon.json.JsonXMLOutputFactory;

public class SchemaTransformer implements ISchemaTransformer {

	private static final String JSON_SCHEMA_TITLE = "title";
	private static final String JSON_SCHEMA_ITEMS = "items";
	private static final String JSON_SCHEMA_STRING = "string";
	private static final String JSON_SCHEMA_ARRAY = "array";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_NAME = "name";
	private static final String JSON_SCHEMA_PROPERTIES = "properties";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_OBJECT = "object";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static String ERROR_TEXT = "File cannot be found ";
	private static String ERROR_WRITING_SCHEMA_FILE = "Error writing to schema file";

	 Map<String, Object> jsonSchemaMap;

	private static final String PROPERTIES_KEY = "properties";
	private static final String TYPE_KEY = "type";
	private static final String TITLE_KEY = "title";
	private static final String ITEMS_KEY = "items";
	private static final String OBJECT_ELEMENT_TYPE = "object";
	private static final String ARRAY_ELEMENT_TYPE = "array";
	
	
	@SuppressWarnings("unchecked")
	@Override
	public TreeNode generateTree(String content, TreeNode inputRootTreeNode) throws JsonParseException, JsonMappingException, IOException  {
		
		InputStream schema = new ByteArrayInputStream(content.getBytes());
		ObjectMapper objectMapper = new ObjectMapper();
        jsonSchemaMap = objectMapper.readValue(schema, Map.class);
        //Sets the name of the root
        inputRootTreeNode.setName(getName(jsonSchemaMap));
        //Sets the level for the root
        inputRootTreeNode.setLevel(1);
        //Sets the type of the root
        if (inputRootTreeNode.getProperties().containsKey(TYPE_KEY)){
        	//treeNode.getProperties().get("type")
        } else  {
        	inputRootTreeNode.getProperties().put(TYPE_KEY, getSchemaType(jsonSchemaMap));
        }
        int count =1;
        inputRootTreeNode = setProperties(jsonSchemaMap,inputRootTreeNode,count);
	            
		return inputRootTreeNode;
		 
	}
	
	/**
	 * Gets the schema name
	 * @param jsonSchemaMap
	 * @return
	 */
	public String getName(Map<String, Object> jsonSchemaMap) {
        String schemaName = (String) jsonSchemaMap.get(TITLE_KEY);
        if (schemaName != null) {
            return schemaName;
        } else {
            log.error("Invalid input schema, schema name not found.");
            throw new NullPointerException("Invalid input schema, schema name not found.");
        }
    }
	
	/**
	 * Gets the schema type
	 * @param schema
	 * @return
	 */
	 private String getSchemaType(Map<String, Object> jsonSchemaMap) {
	        if (jsonSchemaMap.containsKey(TYPE_KEY)) {
	            Object type = jsonSchemaMap.get(TYPE_KEY);
	            if (type instanceof String) {
	                return (String) type;
	            } else {
	                throw new IllegalArgumentException("Illegal format " + type.getClass() + " value found under key : " + TYPE_KEY);
	            }
	        } else {
	            throw new IllegalArgumentException("Given schema does not contain value under key : " + TYPE_KEY);
	        }
	    }
	 
	 /**
	  * Gets the schema properties
	  * @param schema
	  * @return
	  */
	 private Map<String, Object> getSchemaProperties(Map<String, Object> jsonSchemaMap) {
	        if (jsonSchemaMap.containsKey(PROPERTIES_KEY)) {
	            return (Map<String, Object>) jsonSchemaMap.get(PROPERTIES_KEY);
	        } else {
	        	throw new IllegalArgumentException("Given schema does not contain value under key : " + PROPERTIES_KEY);
	        }
	    }
	 
	 /**
	  * Gets schema items
	  * @param schema
	  * @return
	  */
	 private Map<String, Object> getSchemaItems(Map<String, Object> jsonSchemaMap) {
	        if (jsonSchemaMap.containsKey(ITEMS_KEY)) {
	            return (Map<String, Object>) jsonSchemaMap.get(ITEMS_KEY);
	        } else {
	           throw new IllegalArgumentException("Given schema does not contain value under key : " + ITEMS_KEY);
	        }
	    }
	 
	 
	/**
	 * Sets the properties
	 * @param jsonSchemaMap
	 * @param inputRootTreeNode
	 * @param count
	 * @return
	 */
	 private TreeNode setProperties(Map<String, Object> jsonSchemaMap, TreeNode inputRootTreeNode, int count){
			 Map<String, Object> propertyMap = getSchemaProperties(jsonSchemaMap);
			 Set<String> elementKeys = propertyMap.keySet();
			 TreeNode treeNode = null;
			 count ++;
	         for (String elementKey : elementKeys) {
	             Map<String, Object> subSchema = (Map<String, Object>) propertyMap.get(elementKey);
	             String schemaType = getSchemaType(subSchema);
	             if (OBJECT_ELEMENT_TYPE.equals(schemaType)) {
	            	treeNode = DataMapperFactory.eINSTANCE.createTreeNode();
	            	treeNode.setName(elementKey);
	            	treeNode.setLevel(count);
	            	inputRootTreeNode.getNode().add(treeNode);
	                setProperties(subSchema, treeNode,count);
	             } else if (ARRAY_ELEMENT_TYPE.equals(schemaType)) {
	            	treeNode = DataMapperFactory.eINSTANCE.createTreeNode();
	            	treeNode.setName(elementKey);
	            	treeNode.setLevel(count);
	            	inputRootTreeNode.getNode().add(treeNode);
	                setProperties(getSchemaItems(subSchema),treeNode,count);
	             }else{
	            	 //Creates an element when type is String, int etc
	            	 org.wso2.developerstudio.datamapper.Element element = DataMapperFactory.eINSTANCE.createElement();
	            	 element.setName(elementKey);
					if (element.getProperties().containsKey(elementKey)) {
						// treeNode.getProperties().get(property)
					} else {
						element.getProperties().put(TYPE_KEY, schemaType);
						element.setLevel(count);
						inputRootTreeNode.getElement().add(element);
					}
	             }
	         }
			return inputRootTreeNode;
		 
	 }


	@Override
	public String getSchemaContentFromFile(String path) {
		File avsc = new File(path);
		String entireFileText = null;
		try {
			entireFileText = new Scanner(avsc).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			log.error(ERROR_TEXT, e);
		}
		return entireFileText;
	}

	@Override
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel) {
		String name = null;
		JsonFactory jscksonFactory = new JsonFactory();
		try {
			JsonGenerator jGenerator = jscksonFactory.createGenerator(new File("data/output.json"), JsonEncoding.UTF8);
			if (StringUtils.isNotEmpty(treeNodeModel.getName())) {
				recursiveTreeGenerator(treeNodeModel, jGenerator);
			}
		} catch (IOException | XMLStreamException e) {
			//log error
		}
		return name;
	}

	private void recursiveTreeGenerator(TreeNodeImpl treeNodeModel,
			JsonGenerator jGenerator) throws XMLStreamException, IOException {
		EMap<String, String> propertyMap = treeNodeModel.getProperties();
		EList<Element> elemList = treeNodeModel.getElement();
		EList<TreeNode> nodeList = treeNodeModel.getNode();
		JsonFactory factory = new JsonFactory();
//		jGenerator.close();
		
		if (!propertyMap.get(JSON_SCHEMA_TITLE).isEmpty()
				&& propertyMap.get(JSON_SCHEMA_TITLE) != null)
			jGenerator.writeStringField(JSON_SCHEMA_TITLE, propertyMap.get(JSON_SCHEMA_TITLE)); // "name" : "mkyong"
		jGenerator.writeStringField(JSON_SCHEMA_ID, propertyMap.get(JSON_SCHEMA_ID)); // "name" : "mkyong"
		String schemaValType = propertyMap.get(JSON_SCHEMA_TYPE);
		// if type is Object
		if (schemaValType != null && schemaValType.equals(JSON_SCHEMA_OBJECT)) {
			for (Element elem : elemList) {
				jGenerator.writeStringField(JSON_SCHEMA_TYPE,schemaValType);
				jGenerator.writeFieldName(JSON_SCHEMA_PROPERTIES);
				jGenerator.writeFieldName(JSON_SCHEMA_NAME);
				generateElement(jGenerator, elem);
			}
		} else if (schemaValType != null
				&& schemaValType.equals(JSON_SCHEMA_ARRAY)) {
			jGenerator.writeStringField(JSON_SCHEMA_TYPE,schemaValType);
			jGenerator.writeFieldName(JSON_SCHEMA_ITEMS);
			schemaValType = propertyMap.get(JSON_SCHEMA_TYPE);
			for (TreeNode node : nodeList) {
				recursiveTreeGenerator((TreeNodeImpl) node, jGenerator);
			}
		} else if (schemaValType != null
				&& schemaValType.equals(JSON_SCHEMA_STRING)) {
			jGenerator.writeStringField(JSON_SCHEMA_TYPE,schemaValType);
			jGenerator.writeEndObject();
		}
	}

	private void generateElement(JsonGenerator jGenerator,
			Element elem)
			throws XMLStreamException {
		if (elem.getValue() != null && elem.getValue().equals(JSON_SCHEMA_STRING)) {
			
			try {
				jGenerator.writeStringField(JSON_SCHEMA_ID,elem.getName());
				jGenerator.writeStringField(JSON_SCHEMA_TYPE,elem.getValue());
				jGenerator.writeEndObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//log
			}
			
		}
	}

	@Override
	public void updateSchemaFile(String content, File file) {
		try {
			FileUtils.writeStringToFile(file, content);
		} catch (IOException e) {
			log.error(ERROR_WRITING_SCHEMA_FILE + file.getName(), e);
			return;
		}
	}

	@Override
	public Tree generateTreeFromFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}

}
