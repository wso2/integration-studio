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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.PropertyKeyValuePair;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SchemaTransformer implements ISchemaTransformer {

	private static final String JSON_SCHEMA_TITLE = "title";
	private static final String JSON_SCHEMA_ITEMS = "items";
	private static final String JSON_SCHEMA_ARRAY = "array";
	private static final String JSON_SCHEMA_REQUIRED = "required";
	private static final String JSON_SCHEMA_SCHEMA_VALUE = "$schema";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_PROPERTIES = "properties";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_OBJECT = "object";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_ID = "items_id";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_TYPE = "items_type";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_REQUIRED = "items_required";
	private static final String PREFIX = "@";

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
			displayUserError("WARNING", "Invalid schema, schema title not found");
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
				displayUserError("WARNING", "Invalid schema, Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_TYPE);
				throw new IllegalArgumentException("Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_TYPE);
			}
		} else {
			log.error("Invalid input schema, schema type not found.");
			displayUserError("WARNING", "Invalid schema, Given schema does not contain value under key : " + JSON_SCHEMA_TYPE);
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
				displayUserError("WARNING", "Invalid schema, Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_SCHEMA_VALUE);
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
				displayUserError("WARNING", "Invalid schema, Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_ID);
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
				return value;
			} else {
				log.error("Invalid input schema, invalid required value found");
				displayUserError("WARNING", "Invalid schema, Illegal format " + type.getClass() + " value found under key : "
						+ JSON_SCHEMA_REQUIRED);
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
			displayUserError("WARNING", " Invalid schema,Given schema does not contain value under key : "
					+ JSON_SCHEMA_PROPERTIES);
			throw new IllegalArgumentException("Given schema does not contain value under key : "
					+ JSON_SCHEMA_PROPERTIES);
		}
	}

	/**
	 * Gets schema items
	 * 
	 * @param schema
	 *            schema
	 * @return item map
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<String, Object> getSchemaItems(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_ITEMS)) {	
			Map<String, Object> itemsSchema = null;
			//If items block starts with [{ and ends with }] then convert the arraylist into a Map and then use
			if(jsonSchemaMap.get(JSON_SCHEMA_ITEMS) instanceof ArrayList){
				itemsSchema = new HashMap<String, Object>();
				ArrayList<Object> items = (ArrayList<Object>) jsonSchemaMap.get(JSON_SCHEMA_ITEMS);
				for (Object item : items) {
					itemsSchema.putAll((Map)item);
				}
			}else{
				// If items block doesn't starts with [ and ends with ] then get the Map directly
				itemsSchema = (Map<String, Object>) jsonSchemaMap.get(JSON_SCHEMA_ITEMS);
			}
			return itemsSchema;
		} else {
			log.error("Invalid input schema, items value not found");
			displayUserError("WARNING", " Invalid schema,Given schema does not contain value under key : "
					+ JSON_SCHEMA_ITEMS);
			throw new IllegalArgumentException("Given schema does not contain value under key : " + JSON_SCHEMA_ITEMS);
		}
	}

	/**
	 * Sets the properties
	 * 
	 * @param jsonSchemaMap
	 *            schema
	 * @param inputRootTreeNode
	 *            treenode
	 * @param count
	 *            leve;
	 * @return tree node
	 */
	private TreeNode setProperties(Map<String, Object> jsonSchemaMap, TreeNode inputRootTreeNode, int count) {
		// Gets the schema properties
		Map<String, Object> propertyMap = getSchemaProperties(jsonSchemaMap);
		Map<String, Object> attributeMap = new LinkedHashMap<String, Object>();
		Map<String, Object> sortedMap = getAttributeMap(propertyMap, attributeMap);
		//If there is an attribute, add the rest of the elements to the map after the attribute
		if (sortedMap.size() > 0) {
			sortedMap.putAll(propertyMap);
		} else {
			sortedMap = propertyMap;
		}
		Set<String> elementKeys = sortedMap.keySet();

		TreeNode treeNode = null;
		//org.wso2.developerstudio.datamapper.Element element;
		count++;
		for (String elementKey : elementKeys) {
			@SuppressWarnings("unchecked")
			Map<String, Object> subSchema = (Map<String, Object>) sortedMap.get(elementKey);
			// Gets the schema type of the sub schema
			String schemaType = getSchemaType(subSchema);
			if (JSON_SCHEMA_OBJECT.equals(schemaType)) {
				// Creates the tree node
				treeNode = createTreeNode(null, count, elementKey, subSchema, schemaType);
				inputRootTreeNode.getNode().add(treeNode);
				setProperties(subSchema, treeNode, count);
			} else if (JSON_SCHEMA_ARRAY.equals(schemaType)) {
				treeNode = createTreeNode(null, count, elementKey, subSchema, schemaType);
				inputRootTreeNode.getNode().add(treeNode);
				setProperties(getSchemaItems(subSchema), treeNode, count);
			} else {
				//When there is an attribute,
				if (elementKey.startsWith(PREFIX)) {
					treeNode = createTreeNode(null, count, elementKey, subSchema, schemaType);
					inputRootTreeNode.getNode().add(treeNode);
					//element = createElement(count, elementKey, subSchema, schemaType);
					//inputRootTreeNode.getElement().add(element);
				} else {
					treeNode = createTreeNode(null, count, elementKey, subSchema, schemaType);
					inputRootTreeNode.getNode().add(treeNode);
					//If an element contained properties eg: attribute 
					if(subSchema.get(JSON_SCHEMA_PROPERTIES) != null){
					 setProperties(subSchema, treeNode, count);
					}
				}

			}
		}
		return inputRootTreeNode;

	}

	/**
	 * Gets the attribute mape
	 * 
	 * @param propertyMap
	 *            property map
	 * @param sortedMap
	 *            attribute map
	 * @return attribute map
	 */
	private Map<String, Object> getAttributeMap(Map<String, Object> propertyMap, Map<String, Object> sortedMap) {
		for (Iterator<Map.Entry<String, Object>> it = propertyMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Object> entry = it.next();
			if (entry.getKey().startsWith(PREFIX)) {
				//If there is an attribute, remove it from the property map and add it to the sorted map
				it.remove();
				sortedMap.put(entry.getKey(), entry.getValue());
			}
		}
		return sortedMap;
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
		EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();
		element.setName(elementKey);
		element.setLevel(count);
		setPropertyKeyValuePairforElements(element,propertyValueList,JSON_SCHEMA_TYPE, schemaType);
		setPropertyKeyValuePairforElements(element,propertyValueList,JSON_SCHEMA_TYPE, schemaType);
		// Sets the id value if available
		if (getIDValue(subSchema) != null) {
			setPropertyKeyValuePairforElements(element,propertyValueList,JSON_SCHEMA_ID, getIDValue(subSchema));
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private TreeNode createTreeNode(TreeNode inputRootTreeNode, int count, String elementKey,
			Map<String, Object> subSchema, String schemaType) {
		TreeNode treeNode;
		EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();
		if (inputRootTreeNode == null) {
			treeNode = DataMapperFactory.eINSTANCE.createTreeNode();
		} else {
			treeNode = inputRootTreeNode;
		}
		treeNode.setName(elementKey);
		treeNode.setLevel(count);
		
        setPropertyKeyValuePairforTreeNodes(treeNode,propertyValueList,JSON_SCHEMA_TYPE, schemaType);
		// Sets the schema key if available
		if (getSchemaValue(subSchema) != null) {
	        setPropertyKeyValuePairforTreeNodes(treeNode,propertyValueList,JSON_SCHEMA_SCHEMA_VALUE, getSchemaValue(subSchema));
		}
		// Sets the id value if available
		if (getIDValue(subSchema) != null) {
	        setPropertyKeyValuePairforTreeNodes(treeNode,propertyValueList,JSON_SCHEMA_ID, getIDValue(subSchema));
		}
		// Sets the required value
		if (getRequiredValue(subSchema) != null) {
			setPropertyKeyValuePairforTreeNodes(treeNode,propertyValueList,JSON_SCHEMA_REQUIRED, getRequiredValue(subSchema));
		}
		
		if (schemaType.equals(JSON_SCHEMA_ARRAY)) {
			//Handle id, type, and required fields in the items block
			if (subSchema.get(JSON_SCHEMA_ITEMS) != null) {
				Map<String, Object> itemsSchema = null;
				//If items block starts with [{ and ends with }] then convert the arraylist into a Map and then use
				if(subSchema.get(JSON_SCHEMA_ITEMS) instanceof ArrayList){
					itemsSchema = new HashMap<String, Object>();
					ArrayList<Object> items = (ArrayList<Object>) subSchema.get(JSON_SCHEMA_ITEMS);
					for (Object item : items) {
						itemsSchema.putAll((Map)item);
					}
				}else{
					// If items block doesn't starts with [ and ends with ] then get the Map directly
					itemsSchema = (Map<String, Object>) subSchema.get(JSON_SCHEMA_ITEMS);
				}
				setPropertyKeyValuePairforTreeNodes(treeNode,propertyValueList,JSON_SCHEMA_ARRAY_ITEMS_ID, itemsSchema.get(JSON_SCHEMA_ID).toString());
				setPropertyKeyValuePairforTreeNodes(treeNode,propertyValueList,JSON_SCHEMA_ARRAY_ITEMS_TYPE, itemsSchema.get(JSON_SCHEMA_TYPE).toString());
				setPropertyKeyValuePairforTreeNodes(treeNode,propertyValueList,JSON_SCHEMA_ARRAY_ITEMS_REQUIRED, getRequiredValue(itemsSchema));
			}
		}
		return treeNode;
	}

	/**
	 * Gets the key and value
	 * @param treeNode
	 * @param keyValuePair 
	 * @param propertyValueList 
	 * @param jsonSchemaType
	 * @param schemaType 
	 */
	private void setPropertyKeyValuePairforTreeNodes(TreeNode treeNode, EList<PropertyKeyValuePair> propertyValueList,
			String key, String value) {
		PropertyKeyValuePair keyValuePair = DataMapperFactory.eINSTANCE.createPropertyKeyValuePair();
		if (treeNode.getProperties().size() > 0) {
			// If the key is already there add the new value
			if (treeNode.getProperties().contains(key)) {
				for (PropertyKeyValuePair keyValue : treeNode.getProperties()) {
					if (keyValue.getKey().equals(key)) {
						keyValue.setValue(value);
						propertyValueList.add(keyValue);
					}
				}
			} else {
				// If the key is not there add a new key value
				keyValuePair.setKey(key);
				keyValuePair.setValue(value);
				propertyValueList.add(keyValuePair);

			}
			treeNode.getProperties().addAll(propertyValueList);
		} else {
			// Initially if there are no properties add the initial property
			keyValuePair.setKey(key);
			keyValuePair.setValue(value);
			propertyValueList.add(keyValuePair);
			treeNode.getProperties().addAll(propertyValueList);
		}
	}
	
	/**
	 * Gets the key and value
	 * @param treeNode
	 * @param jsonSchemaType
	 * @param schemaType 
	 */
	private void setPropertyKeyValuePairforElements(org.wso2.developerstudio.datamapper.Element element,EList<PropertyKeyValuePair> propertyValueList, String key, String value) {
		PropertyKeyValuePair keyValuePair = DataMapperFactory.eINSTANCE.createPropertyKeyValuePair();
		if (element.getProperties().size() > 0) {
			// If the key is already there add the new value
			if (element.getProperties().contains(key)) {
				for (PropertyKeyValuePair keyValue : element.getProperties()) {
					if (keyValue.getKey().equals(key)) {
						keyValue.setValue(value);
						propertyValueList.add(keyValue);
					}
				}
			} else {
				// If the key is not there add a new key value
				keyValuePair.setKey(key);
				keyValuePair.setValue(value);
				propertyValueList.add(keyValuePair);

			}
			element.getProperties().addAll(propertyValueList);
		} else {
			// Initially if there are no properties add the initial property
			keyValuePair.setKey(key);
			keyValuePair.setValue(value);
			propertyValueList.add(keyValuePair);
			element.getProperties().addAll(propertyValueList);
		}
	}
	
	/**
	 * Gets the property value for Treenodes
	 * @param treeNodeModel
	 * @param key
	 * @return value
	 */
	private String getPropertyKeyValuePairforTreeNodeImpls(TreeNodeImpl treeNodeModel, String key){
		String value = null;
		for (PropertyKeyValuePair keyValue : treeNodeModel.getProperties()) {
			//If the key is already there add the new value
			   if(keyValue.getKey().equals(key)){
				   value = keyValue.getValue();
				   break;
			   }
		}
		return value;
		
	}
	
	/**
	 * Gets the property value for Treenodes
	 * @param treeNodeModel
	 * @param key
	 * @return value
	 */
	private String getPropertyKeyValuePairforTreeNode(TreeNode treeNode, String key){
		String value = null;
		for (PropertyKeyValuePair keyValue : treeNode.getProperties()) {
			//If the key is already there add the new value
			   if(keyValue.getKey().equals(key)){
				   value = keyValue.getValue();
				   break;
			   }
		}
		return value;
		
	}
	
	/**
	 * Gets the property value for elements
	 * @param treeNodeModel
	 * @param key
	 * @return value
	 */
	private String getPropertyKeyValuePairforElements(Element element, String key){
		String value = null;
		for (PropertyKeyValuePair keyValue : element.getProperties()) {
			//If the key is already there add the new value
			   if(keyValue.getKey().equals(key)){
				   value = keyValue.getValue();
				   break;
			   }
		}
		return value;
		
	}
	
	@Override
	public String getSchemaContentFromFile(String path) {
		File jschema = new File(path);
		String entireFileText = null;
		try {
			entireFileText = new Scanner(jschema).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			log.error(ERROR_TEXT, e);
		}
		return entireFileText;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel, File writeToFile) {

		JSONObject root = new JSONObject();
		JSONObject propertiesObject = new JSONObject();
		if (StringUtils.isNotEmpty(treeNodeModel.getName()) && treeNodeModel.getProperties() != null) {
	        
			root.put(JSON_SCHEMA_SCHEMA_VALUE, getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel,JSON_SCHEMA_SCHEMA_VALUE));
			root.put(JSON_SCHEMA_TITLE, treeNodeModel.getName());
			insetIFTypeForJsonObject(treeNodeModel, root);
			root.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
			insertRequiredArray(root, treeNodeModel, false);
			recursiveTreeGenerator(treeNodeModel, propertiesObject);
		}
		return root.toJSONString();
	}

	@SuppressWarnings("unchecked")
	private void recursiveTreeGenerator(TreeNodeImpl treeNodeModel, JSONObject parent) {
		if (treeNodeModel != null) {
			EList<Element> elemList = treeNodeModel.getElement();
			EList<TreeNode> nodeList = treeNodeModel.getNode();
			for (TreeNode node : nodeList) {
				String schemaType = getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel,JSON_SCHEMA_TYPE);
				String schemaArrayItemsID = getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel,JSON_SCHEMA_ARRAY_ITEMS_ID);
				String schemaArrayItemsType = getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel,JSON_SCHEMA_ARRAY_ITEMS_TYPE);
				String schemaID = getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel,JSON_SCHEMA_ID);
				if (schemaType != null
						&& schemaType.equals(JSON_SCHEMA_OBJECT)) {
					JSONObject nodeObject = new JSONObject();
					JSONObject propertiesObject = new JSONObject();
					insetIFTypeForJsonObject(node, nodeObject);
					nodeObject.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
					parent.put(node.getName(), nodeObject);
					insertRequiredArray(nodeObject, node, false);
					recursiveTreeGenerator((TreeNodeImpl) node, propertiesObject);
				} else if (schemaType != null
						&& schemaType.equals(JSON_SCHEMA_ARRAY)) {
					JSONObject arrayObject = new JSONObject();
					JSONObject itemsObject = new JSONObject();
					JSONArray arrayItemsObject = new JSONArray();
					JSONObject itemProperties = new JSONObject();
					insetIFTypeForJsonObject(node, arrayObject);
					if (schemaArrayItemsID != null) {
						itemProperties.put(JSON_SCHEMA_ID,
								schemaArrayItemsID.replace("\\", ""));
					} else {
						itemProperties.put(JSON_SCHEMA_ID, "");
					}
					itemsObject.put(JSON_SCHEMA_TYPE,schemaArrayItemsType);
					insertRequiredArray(arrayObject, node, false);
					insertRequiredArray(itemProperties, node, true);
					parent.put(node.getName(), arrayObject);
					arrayItemsObject.add(itemProperties);
					arrayObject.put(JSON_SCHEMA_ITEMS, arrayItemsObject);
					itemProperties.put(JSON_SCHEMA_PROPERTIES, itemsObject);
					recursiveTreeGenerator((TreeNodeImpl) node, itemsObject);
				} else if (schemaType != null) {
					JSONObject elemObject = new JSONObject();
					if (schemaID != null) {
					elemObject.put(JSON_SCHEMA_ID, schemaID.replace("\\", ""));
					} else {
						elemObject.put(JSON_SCHEMA_ID, "");
					}
					elemObject.put(JSON_SCHEMA_TYPE,schemaType);
					parent.put(node.getName(), elemObject);
					if (node.getNode() != null) {
						JSONObject propertiesObject = new JSONObject();
						elemObject.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
						recursiveTreeGenerator((TreeNodeImpl) node, propertiesObject);
					}
					
				}
			}
			for (Element elem : elemList) {
				
				String schemaType = getPropertyKeyValuePairforElements(elem,JSON_SCHEMA_TYPE);
				String schemaID = getPropertyKeyValuePairforElements(elem,JSON_SCHEMA_ID);
				if (schemaType != null) {
					JSONObject elemObject = new JSONObject();
					if (schemaID != null) {
					elemObject.put(JSON_SCHEMA_ID, schemaID.replace("\\", ""));
					} else {
						elemObject.put(JSON_SCHEMA_ID, "");
					}
					elemObject.put(JSON_SCHEMA_TYPE, schemaType);
					parent.put(elem.getName(), elemObject);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void insetIFTypeForJsonObject(TreeNode node, JSONObject nodeObject) {
		String schemaType = getPropertyKeyValuePairforTreeNode(node,JSON_SCHEMA_TYPE);
		String schemaID = getPropertyKeyValuePairforTreeNode(node,JSON_SCHEMA_ID);
		if (schemaID!= null) {
			nodeObject.put(JSON_SCHEMA_ID, schemaID.replace("\\", ""));
		} else {
			nodeObject.put(JSON_SCHEMA_ID, "");
		}
		nodeObject.put(JSON_SCHEMA_TYPE, schemaType);
	}

	@SuppressWarnings({ "unchecked" })
	private void insertRequiredArray(JSONObject parent, TreeNode node, boolean isItems) {
		String requiredString = null;
		JSONArray requiredArray = new JSONArray();
		String schemaRequired = getPropertyKeyValuePairforTreeNode(node,JSON_SCHEMA_REQUIRED);
		String schemaArrayItemsRequired = getPropertyKeyValuePairforTreeNode(node,JSON_SCHEMA_ARRAY_ITEMS_REQUIRED);
		if (schemaRequired != null) {
			requiredString = schemaRequired;
		}
		if (schemaArrayItemsRequired != null && isItems) {
			requiredString = schemaArrayItemsRequired;
		}
		if (requiredString != null) {
			if (requiredString.contains(",")) {
				String[] requiredStringArr  = requiredString.split(",");
				for (String retuiredItem : requiredStringArr) {
					requiredArray.add(retuiredItem);
				}
			} else {
				requiredArray.add(requiredString);
			}
			
			parent.put(JSON_SCHEMA_REQUIRED, requiredArray);
		}
	}

	@Override
	public void updateSchemaFile(String content, File file) {
		try {
			// check of content is null to prevent object mapper throwing exceptions due to empty content
			if (content != null && !content.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			Object json = mapper.readValue(content, Object.class);
			FileUtils.writeStringToFile(file, mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
			} else {
				FileUtils.writeStringToFile(file, "");
			}
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
	
	/**
	 * Warning Dialog
	 * @param reason
	 * @param message
	 */
	private void displayUserError(String reason, String message) {
		MessageDialog.openWarning(Display.getCurrent().getActiveShell(), reason, message);
	}

}
