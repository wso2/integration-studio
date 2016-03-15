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
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
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

public class SchemaTransformer implements ISchemaTransformer {

	private static final String JSON_SCHEMA_TITLE = "title";
	private static final String JSON_SCHEMA_ITEMS = "items";
	private static final String JSON_SCHEMA_STRING = "string";
	private static final String JSON_SCHEMA_ARRAY = "array";
	private static final String JSON_SCHEMA_REQUIRED = "required";
	private static final String JSON_SCHEMA_SCHEMA_VALUE = "$schema";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_NAME = "name";
	private static final String JSON_SCHEMA_PROPERTIES = "properties";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_OBJECT = "object";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static String ERROR_TEXT = "File cannot be found ";
	private static String ERROR_WRITING_SCHEMA_FILE = "Error writing to schema file";

	 Map<String, Object> jsonSchemaMap;
	
	@SuppressWarnings("unchecked")
	@Override
	public TreeNode generateTree(String content, TreeNode inputRootTreeNode) throws NullPointerException,
	IllegalArgumentException, IOException {
		
		InputStream schema = new ByteArrayInputStream(content.getBytes());
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonSchemaMap = objectMapper.readValue(schema, Map.class);
		} catch (JsonParseException e) {
			log.error("error in parsing the JSONSchema", e);
		} catch (JsonMappingException e) {
			log.error("error in mapping the JSONSchema", e);
		} catch (IOException e) {
			log.error("error in processing the JSONSchema", e);
		}
		// Creates the root element
		int count = 1;
		inputRootTreeNode = createTreeNode(inputRootTreeNode, count, getName(jsonSchemaMap), jsonSchemaMap,
				getSchemaType(jsonSchemaMap));
		// Creates the tree by adding tree node and elements
		inputRootTreeNode = setProperties(jsonSchemaMap, inputRootTreeNode, count);

		return inputRootTreeNode;
		 
	}
	
	/**
	 * Gets the schema name
	 * 
	 * @param jsonSchemaMap
	 *            schema
	 * @return name
	 */
	public String getName(Map<String, Object> jsonSchemaMap) {
		String schemaName = (String) jsonSchemaMap.get(JSON_SCHEMA_TITLE);
		if (schemaName != null) {
			return schemaName;
		} else {
			log.error("Invalid input schema, schema name not found.");
			throw new NullPointerException("Invalid input schema, schema name not found.");
		}
	}

	/**
	 * Gets the schema type
	 * 
	 * @param schema
	 *            schema
	 * @return type
	 */
	private String getSchemaType(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_TYPE)) {
			Object type = jsonSchemaMap.get(JSON_SCHEMA_TYPE);
			if (type instanceof String) {
				return (String) type;
			} else {
				log.error("Invalid input schema, invalid schema type found");
				throw new IllegalArgumentException("Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_TYPE);
			}
		} else {
			log.error("Invalid input schema, schema type not found.");
			throw new IllegalArgumentException("Given schema does not contain value under key : " + JSON_SCHEMA_TYPE);
		}
	}

	/**
	 * Gets the schema key value
	 * 
	 * @param schema
	 *            map
	 * @return schema value
	 */
	private String getSchemaValue(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_SCHEMA_VALUE)) {
			Object type = jsonSchemaMap.get(JSON_SCHEMA_SCHEMA_VALUE);
			if (type instanceof String) {
				return (String) type;
			} else {
				log.error("Invalid input schema, invalid schema value found");
				throw new IllegalArgumentException("Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_SCHEMA_VALUE);
			}
		}
		return null;
	}

	/**
	 * Gets the schema id value
	 * 
	 * @param schema
	 *            map
	 * @return id value
	 */
	private String getIDValue(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_ID)) {
			Object type = jsonSchemaMap.get(JSON_SCHEMA_ID);
			if (type instanceof String) {
				return (String) type;
			} else {
				log.error("Invalid input schema, invalid ID value found");
				throw new IllegalArgumentException("Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_ID);
			}
		}
		return null;
	}

	/**
	 * Gets the required value
	 * 
	 * @param jsonSchemaMap
	 *            schema
	 * @return value
	 */
	private String getRequiredValue(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_REQUIRED)) {
			Object type = jsonSchemaMap.get(JSON_SCHEMA_REQUIRED);
			if (type instanceof ArrayList) {
				@SuppressWarnings("unchecked")
				String value = String.join(",", (ArrayList<String>) type);
				return "[" + value + "]";
			} else {
				log.error("Invalid input schema, invalid required value found");
				throw new IllegalArgumentException("Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_REQUIRED);
			}
		}
		return null;
	}

	/**
	 * Gets the schema properties
	 * 
	 * @param schema
	 *            schema
	 * @return property map
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getSchemaProperties(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_PROPERTIES)) {
			return (Map<String, Object>) jsonSchemaMap.get(JSON_SCHEMA_PROPERTIES);
		} else {
			log.error("Invalid input schema, property value not found");
			throw new IllegalArgumentException("Given schema does not contain value under key : " + JSON_SCHEMA_PROPERTIES);
		}
	}

	/**
	 * Gets schema items
	 * 
	 * @param schema
	 *            schema
	 * @return item map
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getSchemaItems(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_ITEMS)) {
			return (Map<String, Object>) jsonSchemaMap.get(JSON_SCHEMA_ITEMS);
		} else {
			log.error("Invalid input schema, items value not found");
			throw new IllegalArgumentException("Given schema does not contain value under key : " + JSON_SCHEMA_ITEMS);
		}
	}

	private TreeNode setProperties(Map<String, Object> jsonSchemaMap, TreeNode inputRootTreeNode, int count) {
		// Gets the schema properties
		Map<String, Object> propertyMap = getSchemaProperties(jsonSchemaMap);
		Set<String> elementKeys = propertyMap.keySet();
		TreeNode treeNode = null;
		org.wso2.developerstudio.datamapper.Element element = null;
		count++;
		for (String elementKey : elementKeys) {
			@SuppressWarnings("unchecked")
			Map<String, Object> subSchema = (Map<String, Object>) propertyMap.get(elementKey);
			// Gets the schema type of the sub schema
			String schemaType = getSchemaType(subSchema);
			if (JSON_SCHEMA_OBJECT.equals(schemaType)) {
				// Creates the tree node
				treeNode = createTreeNode(null, count, elementKey, subSchema, schemaType);
				// Adds sub tree node to the root tree
				inputRootTreeNode.getNode().add(treeNode);
				setProperties(subSchema, treeNode, count);
			} else if (JSON_SCHEMA_ARRAY.equals(schemaType)) {
				// Creates the tree node
				treeNode = createTreeNode(null, count, elementKey, subSchema, schemaType);
				// Adds sub tree node to the root tree
				inputRootTreeNode.getNode().add(treeNode);
				setProperties(getSchemaItems(subSchema), treeNode, count);
			} else {
				// Creates an element when type is String, int etc
				element = createElement(count, elementKey, subSchema, schemaType);
				// Adds the element to the tree node
				inputRootTreeNode.getElement().add(element);
			}
		}
		return inputRootTreeNode;

	}

	/**
	 * Creates and element
	 * 
	 * @param inputRootTreeNode
	 *            root tree node
	 * @param count
	 *            level
	 * @param elementKey
	 *            element key
	 * @param subSchema
	 *            sub schema
	 * @param schemaType
	 *            schema type
	 * @return element
	 */
	private Element createElement(int count, String elementKey, Map<String, Object> subSchema, String schemaType) {
		org.wso2.developerstudio.datamapper.Element element;
		element = DataMapperFactory.eINSTANCE.createElement();
		element.setName(elementKey);
		element.setLevel(count);
		element.getProperties().put(JSON_SCHEMA_TYPE, schemaType);
		// Sets the id value if available
		if (getIDValue(subSchema) != null) {
			element.getProperties().put(JSON_SCHEMA_ID, getSchemaValue(subSchema));
		}
		return element;
	}

	/**
	 * Creates the inner tree node
	 * 
	 * @param inputRootTreeNode
	 * @param inputRootTreeNode
	 *            root tree node
	 * @param count
	 *            level
	 * @param elementKey
	 *            element
	 * @param subSchema
	 *            sub schema
	 * @param schemaType
	 *            schema type
	 * @return tree node
	 */
	private TreeNode createTreeNode(TreeNode inputRootTreeNode, int count, String elementKey,
			Map<String, Object> subSchema, String schemaType) {
		TreeNode treeNode;
		if (inputRootTreeNode == null) {
			treeNode = DataMapperFactory.eINSTANCE.createTreeNode();
		} else {
			treeNode = inputRootTreeNode;
		}
		treeNode.setName(elementKey);
		treeNode.setLevel(count);
		treeNode.getProperties().put(JSON_SCHEMA_TYPE, schemaType);
		// Sets the schema key if available
		if (getSchemaValue(subSchema) != null) {
			treeNode.getProperties().put(JSON_SCHEMA_SCHEMA_VALUE, getSchemaValue(subSchema));
		}
		// Sets the id value if available
		if (getIDValue(subSchema) != null) {
			treeNode.getProperties().put(JSON_SCHEMA_ID, getSchemaValue(subSchema));
		}
		// Sets the required value
		if (getRequiredValue(subSchema) != null) {
			treeNode.getProperties().put(JSON_SCHEMA_REQUIRED, getRequiredValue(subSchema));
		}
		return treeNode;
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
