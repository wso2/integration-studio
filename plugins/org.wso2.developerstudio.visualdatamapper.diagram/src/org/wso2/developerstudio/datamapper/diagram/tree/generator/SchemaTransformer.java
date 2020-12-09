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
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
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
	private static final String JSON_SCHEMA_NAMESPACES = "namespaces";
	private static final String JSON_SCHEMA_ELEMENT_IDENTIFIERS = "elementIdentifiers";
	private static final String JSON_SCHEMA_SCHEMA_VALUE = "$schema";
	private static final String JSON_SCHEMA_ID = "id";
	private static final String JSON_SCHEMA_PROPERTIES = "properties";
	private static final String JSON_SCHEMA_VALUE = "value";
	private static final String JSON_SCHEMA_ATTRIBUTES = "attributes";
	private static final String JSON_SCHEMA_TYPE = "type";
	private static final String JSON_SCHEMA_NULLABLE = "nullable";
	private static final String JSON_SCHEMA_OBJECT = "object";
	private static final String FALSE = "false";
	private static final String TRUE = "true";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_ID = "items_id";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_TYPE = "items_type";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE = "items_value_type";
	private static final String JSON_SCHEMA_OBJECT_VALUE_TYPE = "object_value_type";
	private static final String JSON_SCHEMA_ATTRIBUTE_ID = "attribute_id";
	private static final String JSON_SCHEMA_ATTRIBUTE_TYPE = "attribute_type";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_ID = "added_attribute_id";
	private static final String JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE = "added_attribute_type";
	private static final String JSON_SCHEMA_PROPERTIES_ID = "properties_id";
	private static final String JSON_SCHEMA_ADDED_PROPERTIES_ID = "added_properties_id";
	private static final String JSON_SCHEMA_ARRAY_ITEMS_REQUIRED = "items_required";
	private static final String JSON_SCHEMA_OBJECT_NAMESPACES = "objectNamespaces";
	private static final String JSON_SCHEMA_ARRAY_NAMESPACES = "arrayNamespaces";
	private static final String JSON_SCHEMA_ATTRIBUTE_NAMESPACES = "attributeNamespaces";
	private static final String JSON_SCHEMA_FIELD_NAMESPACES = "fieldNamespaces";
	private static final String JSON_SCHEMA_ADDED_ARRAY_ITEMS_TYPE = "added_items_type";
	private static final String PREFIX = "@";
	private static final String NAMESPACE_PREFIX = "prefix";
	private static final String NAMESPACE_URL = "url";
	private static final String ELEMENT_IDENTIFIER = "type";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS = "objectElementIdentifiers";
	private static final String JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL = "objectElementIdentifiersURL";
	private static final String JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS = "arrayElementIdentifiers";
	private static final String JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS_URL = "arrayElementIdentifiersURL";
	private static final String JSON_SCHEMA_FIELD_ELEMENT_IDENTIFIERS = "fieldElementIdentifiers";
	private static final String JSON_SCHEMA_FIELD_ELEMENT_IDENTIFIERS_URL = "fieldElementIdentifiersURL";
	private static final String ERROR = "Error";
	private static final String ERROR_IN_PARSING_JSONSCHEMA = "Error in parsing the JSONSchema";
	private static final String ERROR_IN_MAPPING_JSONSCHEMA = "Error in mapping the JSONSchema";
	private static final String ERROR_IN_PROCESSING_JSONSCHEMA = "Error in processing the JSONSchema";
	private static final String DEFAULT_ARRAY_NAME = "_";
	private static final String UNAMED = "unnamed";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static String ERROR_TEXT = "File cannot be found ";
	private static String ERROR_WRITING_SCHEMA_FILE = "Error writing to schema file";

	Map<String, Object> jsonSchema;
	ArrayList<String> namespaceList = new ArrayList<String>();
	ArrayList<String> elementIdentifierList = new ArrayList<String>();
	private boolean isAttribute = false;
	private boolean hasAttributes = false;
	private boolean addedObjectHasAttributes = false;
	private boolean addedObjectHasProperties = false;
	private String addedObjectElementIdentifiers = null;
	private String addedObjectNamespaces = null;

	/**
	 * Generates the tree
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public TreeNode generateTree(String content, TreeNode inputRootTreeNode)
			throws NullPointerException, IllegalArgumentException, IOException {
		jsonSchema = getJsonSchema(content);
		// Creates the root element
		int count = 1;
		HashMap<String, String> namespaceMap = null;
		HashMap<String, String> elementIdentifiersmap = null;
		// Sets the namesapces value
		if (getNamespaces(jsonSchema) != null) {
			// creates the namespaces map
			namespaceMap = createNamespacesMap(jsonSchema);
		}
		// Sets the element identifiers
		if (getElementIdentifiers(jsonSchema) != null) {
			// creates the identifiers map
			elementIdentifiersmap = createElementIdentifiersMap(jsonSchema);
		}

		inputRootTreeNode = createTreeNode(inputRootTreeNode, count, getName(jsonSchema), jsonSchema,
				getSchemaType(jsonSchema), namespaceMap, elementIdentifiersmap);
		// Set Attributes of the root element
		setAttributesForElements(jsonSchema, count, namespaceMap, inputRootTreeNode);
		isAttribute = false;

		if (getSchemaType(jsonSchema).equals(JSON_SCHEMA_ARRAY)) {
			ArrayList<Object> items = getSchemaItemsMap(jsonSchema);

			List<Map> list = new ArrayList();
			for (Object item : items) {
				jsonSchema = (Map) item;
				if (list.contains(jsonSchema)) {
					break;
				} else {
					list.add(jsonSchema);
					if (jsonSchema.containsKey(JSON_SCHEMA_PROPERTIES)) {
						// Creates the tree by adding tree node and elements when
						// the root is an array
						inputRootTreeNode = setProperties(jsonSchema, inputRootTreeNode, count, namespaceMap);
					}
				}
			}
		} else {
			// Creates the tree by adding tree node and elements
			inputRootTreeNode = setProperties(jsonSchema, inputRootTreeNode, count, namespaceMap);
		}

		return inputRootTreeNode;

	}

	/**
	 * Sets attributes for elements
	 * 
	 * @param jsonSchema
	 *            schema
	 * @param count
	 *            level
	 * @param namespaceMap
	 *            namespace
	 * @param treeNode
	 *            tree node
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setAttributesForElements(Map<String, Object> jsonSchema, int count,
			HashMap<String, String> namespaceMap, TreeNode treeNode) {
		if (jsonSchema.get(JSON_SCHEMA_ATTRIBUTES) != null) {
			EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();
			Map<String, List<String>> attIDMap = new HashMap<String, List<String>>();
			Map<String, List<String>> attTypeMap = new HashMap<String, List<String>>();
			List<String> idValues = new ArrayList<String>();
			List<String> typeValues = new ArrayList<String>();
			for (String key : getAttributes(jsonSchema).keySet()) {
				isAttribute = true;
				Map<String, Object> newAttributeMap = new LinkedHashMap<String, Object>();
				// creates a map containing the attribute
				newAttributeMap.put(key, getAttributes(jsonSchema).get(key));
				// sets additional properties to be used in the
				// serialization
				idValues.add(getIDValue((Map) getAttributes(jsonSchema).get(key)));
				typeValues.add(getSchemaType((Map) getAttributes(jsonSchema).get(key)));
				setProperties(newAttributeMap, treeNode, count, namespaceMap);
			}
			attIDMap.put(JSON_SCHEMA_ATTRIBUTE_ID, idValues);
			attTypeMap.put(JSON_SCHEMA_ATTRIBUTE_TYPE, typeValues);
			// Bind these values to the treenode
			setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_ATTRIBUTE_ID,
					attIDMap.toString());
			setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_ATTRIBUTE_TYPE,
					attTypeMap.toString());

		}
	}

	/**
	 * Check for xsi:nil
	 * 
	 * @param jsonSchema
	 *            schema
	 * @return
	 */
	private boolean checkXsiNilForElements(Map<String, Object> jsonSchema) {
		boolean hasXsiNil = false;
		if (jsonSchema.get(JSON_SCHEMA_ATTRIBUTES) != null) {
			for (String key : getAttributes(jsonSchema).keySet()) {
				if (key.equals("xsi:nil")) {
					hasXsiNil = true;
					break;
				}
			}

		}
		return hasXsiNil;
	}

	/**
	 * Gets the json schema
	 * 
	 * @param content
	 *            string content
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getJsonSchema(String content) {
		Map<String, Object> jsonSchemaMap = null;
		InputStream schema = new ByteArrayInputStream(content.getBytes());
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonSchemaMap = objectMapper.readValue(schema, Map.class);
		} catch (JsonParseException e) {
			log.error("error in parsing the JSONSchema", e);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), ERROR, ERROR_IN_PARSING_JSONSCHEMA);
		} catch (JsonMappingException e) {
			log.error("error in mapping the JSONSchema", e);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), ERROR, ERROR_IN_MAPPING_JSONSCHEMA);
		} catch (IOException e) {
			log.error("error in processing the JSONSchema", e);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), ERROR, ERROR_IN_PROCESSING_JSONSCHEMA);
		}
		return jsonSchemaMap;
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
			}
		} else {
			log.error("Invalid input schema, schema type not found.");
			displayUserError("WARNING",
					"Invalid schema, Given schema does not contain value under key : " + JSON_SCHEMA_TYPE);
			throw new IllegalArgumentException("Given schema does not contain value under key : " + JSON_SCHEMA_TYPE);
		}
		return null;
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
			}
		}
		return null;
	}
	
	/**
	 * Get Nullable value
	 * @param jsonSchemaMap
	 * @return
	 */
	private String getNullableValue(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_NULLABLE)) {
			Object type = jsonSchemaMap.get(JSON_SCHEMA_NULLABLE);
			if (type instanceof String) {
				return (String) type;
			}
		}
		return null;
	}

	/**
	 * Gets the namespaces value
	 * 
	 * @param jsonSchemaMap
	 *            schema
	 * @return value
	 */
	@SuppressWarnings("unchecked")
	private String getNamespaces(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_NAMESPACES)) {
			ArrayList<HashMap<String, String>> namespaces = (ArrayList<HashMap<String, String>>) jsonSchemaMap
					.get(JSON_SCHEMA_NAMESPACES);
			if (namespaces instanceof ArrayList) {
				String value = StringUtils.join(namespaces, ',');
				return value;
			} else {
				log.error("Invalid input schema, invalid namespaces value found");
				displayUserError("WARNING", "Invalid schema, Illegal format " + namespaces.getClass()
						+ " value found under key : " + JSON_SCHEMA_NAMESPACES);
				throw new IllegalArgumentException("Illegal format " + namespaces.getClass()
						+ " value found under key : " + JSON_SCHEMA_NAMESPACES);
			}
		}
		return null;
	}

	/**
	 * Gets the elementIdentifiers value
	 * 
	 * @param jsonSchemaMap
	 *            schema
	 * @return value
	 */
	@SuppressWarnings("unchecked")
	private String getElementIdentifiers(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_ELEMENT_IDENTIFIERS)) {
			ArrayList<String> identifiers = (ArrayList<String>) jsonSchemaMap.get(JSON_SCHEMA_ELEMENT_IDENTIFIERS);
			if (identifiers instanceof ArrayList) {
				String value = StringUtils.join(identifiers, ',');
				return value;
			} else {
				log.error("Invalid input schema, invalid element identifiers value found");
				displayUserError("WARNING", "Invalid schema, Illegal format " + identifiers.getClass()
						+ " value found under key : " + JSON_SCHEMA_ELEMENT_IDENTIFIERS);
				throw new IllegalArgumentException("Illegal format " + identifiers.getClass()
						+ " value found under key : " + JSON_SCHEMA_ELEMENT_IDENTIFIERS);
			}

		}
		return null;
	}

	/**
	 * creates the namespaces map
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	private HashMap<String, String> createNamespacesMap(Map<String, Object> jsonSchemaMap) {
		ArrayList<LinkedHashMap<String, String>> namespaces = (ArrayList<LinkedHashMap<String, String>>) jsonSchemaMap
				.get(JSON_SCHEMA_NAMESPACES);
		HashMap<String, String> namespaceMap = new HashMap<String, String>();
		for (LinkedHashMap<String, String> namespace : namespaces) {
			namespaceMap.put(namespace.get(NAMESPACE_PREFIX), namespace.get(NAMESPACE_URL));
		}
		return namespaceMap;
	}

	/**
	 * creates the element identifiers map
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	private HashMap<String, String> createElementIdentifiersMap(Map<String, Object> jsonSchemaMap) {
		ArrayList<LinkedHashMap<String, String>> elementIdentifiers = (ArrayList<LinkedHashMap<String, String>>) jsonSchemaMap
				.get(JSON_SCHEMA_ELEMENT_IDENTIFIERS);
		HashMap<String, String> identifierMap = new HashMap<String, String>();
		for (LinkedHashMap<String, String> identifier : elementIdentifiers) {
			identifierMap.put(identifier.get(ELEMENT_IDENTIFIER), identifier.get(ELEMENT_IDENTIFIER));
		}
		return identifierMap;
	}

	/**
	 * Gets the required value
	 * 
	 * @param jsonSchemaMap
	 *            schema
	 * @return value
	 */
	@SuppressWarnings("rawtypes")
	private String getRequiredValue(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_REQUIRED)) {
			ArrayList type = (ArrayList) jsonSchemaMap.get(JSON_SCHEMA_REQUIRED);
			if (type instanceof ArrayList) {
				String value = StringUtils.join(type, ',');
				return value;
			} else {
				log.error("Invalid input schema, invalid required value found");
				displayUserError("WARNING", "Invalid schema, Illegal format " + type.getClass()
						+ " value found under key : " + JSON_SCHEMA_REQUIRED);
				throw new IllegalArgumentException(
						"Illegal format " + type.getClass() + " value found under key : " + JSON_SCHEMA_REQUIRED);
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
			displayUserError("WARNING",
					" Invalid schema,Given schema does not contain value under key : " + JSON_SCHEMA_PROPERTIES);
			throw new IllegalArgumentException(
					"Given schema does not contain value under key : " + JSON_SCHEMA_PROPERTIES);
		}
	}

	/**
	 * Gets the schema attributes
	 * 
	 * @param schema
	 *            schema
	 * @return property map
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getAttributes(Map<String, Object> jsonSchemaMap) {
		Map<String, Object> attributeMap = null;
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_ATTRIBUTES)) {
			attributeMap = (Map<String, Object>) jsonSchemaMap.get(JSON_SCHEMA_ATTRIBUTES);
		}
		return attributeMap;
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
			// If items block starts with [{ and ends with }] then convert the
			// arraylist into a Map and then use
			if (jsonSchemaMap.get(JSON_SCHEMA_ITEMS) instanceof ArrayList) {
				itemsSchema = new HashMap<String, Object>();
				ArrayList<Object> items = (ArrayList<Object>) jsonSchemaMap.get(JSON_SCHEMA_ITEMS);
				for (Object item : items) {
					itemsSchema.putAll((Map) item);
				}
			} else {
				// If items block doesn't starts with [ and ends with ] then get
				// the Map directly
				itemsSchema = (Map<String, Object>) jsonSchemaMap.get(JSON_SCHEMA_ITEMS);
			}
			return itemsSchema;
		} else {
			log.error("Invalid input schema, items value not found");
			displayUserError("WARNING",
					" Invalid schema,Given schema does not contain value under key : " + JSON_SCHEMA_ITEMS);
			throw new IllegalArgumentException("Given schema does not contain value under key : " + JSON_SCHEMA_ITEMS);
		}
	}

	/**
	 * Gets schema items map
	 * 
	 * @param schema
	 *            schema
	 * @return item map
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<Object> getSchemaItemsMap(Map<String, Object> jsonSchemaMap) {
		if (jsonSchemaMap.containsKey(JSON_SCHEMA_ITEMS)) {
			ArrayList<Object> items = null;
			// If items block starts with [{ and ends with }] then convert the
			// arraylist into a Map and then use
			if (jsonSchemaMap.get(JSON_SCHEMA_ITEMS) instanceof ArrayList) {
				items = (ArrayList<Object>) jsonSchemaMap.get(JSON_SCHEMA_ITEMS);
			} else {
				// If items block doesn't starts with [ and ends with ] then get
				// the Map directly
				items = (ArrayList<Object>) jsonSchemaMap.get(JSON_SCHEMA_ITEMS);
			}
			return items;
		} else {
			log.error("Invalid input schema, items value not found");
			displayUserError("WARNING",
					" Invalid schema,Given schema does not contain value under key : " + JSON_SCHEMA_ITEMS);
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
	 * @param namespaceMap
	 * @return tree node
	 */
	@SuppressWarnings({ "unchecked" })
	private TreeNode setProperties(Map<String, Object> jsonSchemaMap, TreeNode inputRootTreeNode, int count,
			HashMap<String, String> namespaceMap) {
		Map<String, Object> propertyMap = null;
		Map<String, Object> sortedMap = new LinkedHashMap<String, Object>();
		EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();
		String name = null;
		String schemaType = null;
		if (jsonSchemaMap.size() > 0) {
			// Gets the schema properties if it contains a properties section
			if (jsonSchemaMap.containsKey(JSON_SCHEMA_PROPERTIES)) {
				propertyMap = getSchemaProperties(jsonSchemaMap);
			}
			// Gets the schema attributes map if it contains attributes section
			if (isAttribute) {
				sortedMap.putAll(jsonSchemaMap);
				// Then add rest of the properties to the map
				if (propertyMap != null && propertyMap.size() > 0) {
					sortedMap.putAll(propertyMap);
				}
			} else {
				// If there are no attributes then add the properties to the map
				sortedMap = propertyMap;
			}
		}

		Set<String> elementKeys = sortedMap.keySet();

		TreeNode treeNode = null;
		count++;
		for (String elementKey : elementKeys) {
			// Gets the subschema based on the key
			Map<String, Object> subSchema = (Map<String, Object>) sortedMap.get(elementKey);
			if (subSchema.size() > 0 && subSchema.containsKey(JSON_SCHEMA_TYPE)) {
				// Gets the schema type of the sub schema
				schemaType = getSchemaType(subSchema);
			}
			if (JSON_SCHEMA_OBJECT.equals(schemaType)) {
				// If the element is an attribute then adds the prefix @
				name = addPrefixForAttributes(elementKey);
				treeNode = createTreeNode(null, count, name, subSchema, schemaType, namespaceMap, null);
				inputRootTreeNode.getNode().add(treeNode);
				// If object has attributes
				if (subSchema.get(JSON_SCHEMA_ATTRIBUTES) != null) {
					setAttributesForElements(subSchema, count, namespaceMap, treeNode);
				}
				if (subSchema.containsKey(JSON_SCHEMA_PROPERTIES)) {
					// Fixing DEVTOOLESB-151
					setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_PROPERTIES_ID,
							getSchemaProperties(subSchema).toString());
					setProperties(subSchema, treeNode, count, namespaceMap);
				}
			} else if (JSON_SCHEMA_ARRAY.equals(schemaType)) {
				// If the element is an attribute then adds the prefix @
				name = addPrefixForAttributes(elementKey);
				treeNode = createTreeNode(null, count, name, subSchema, schemaType, namespaceMap, null);
				inputRootTreeNode.getNode().add(treeNode);

				// If array has items section
				if (getSchemaItems(subSchema).size() > 0) {
					// If array has attributes
					if (getSchemaItems(subSchema).get(JSON_SCHEMA_ATTRIBUTES) != null) {
						setAttributesForElements(getSchemaItems(subSchema), count, namespaceMap, treeNode);
					}
					if (getSchemaItems(subSchema).containsKey(JSON_SCHEMA_PROPERTIES)) {
						// bind values to tree node
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_PROPERTIES_ID,
								getSchemaProperties(getSchemaItems(subSchema)).toString());
						setProperties(getSchemaItems(subSchema), treeNode, count, namespaceMap);
					} else if (subSchema.containsKey(JSON_SCHEMA_ITEMS)) {
						// if the array has an array, then it has no properties and only items
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList,
								JSON_SCHEMA_PROPERTIES_ID,
								subSchema.get(JSON_SCHEMA_ITEMS).toString());
						setItemsToArray(getSchemaItems(subSchema), treeNode, count, 
								namespaceMap);
					}
				}
			} else {
				// If the element is an attribute then adds the prefix @
				name = addPrefixForAttributes(elementKey);
				treeNode = createTreeNode(null, count, name, subSchema, schemaType, namespaceMap, null);
				inputRootTreeNode.getNode().add(treeNode);
				// If an element contains attributes
				if (subSchema.get(JSON_SCHEMA_ATTRIBUTES) != null) {
					setAttributesForElements(subSchema, count, namespaceMap, treeNode);
				}
			}
		}
		return inputRootTreeNode;

	}
	
	/**
	 * Set items to the array.
	 * 
	 * @param jsonSchemaMap array schema
	 * @param inputRootTreeNode 
	 * @param level level of the parent
	 * @param namespaceMap name space map
	 * @return treenode of the array
	 */
	private TreeNode setItemsToArray(Map<String, Object> jsonSchemaMap, TreeNode inputRootTreeNode, int level,
			HashMap<String, String> namespaceMap) {
		EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();
		level++;
		String schemaType = getSchemaType(jsonSchemaMap);
		TreeNode treeNode = createTreeNode(null, level, DEFAULT_ARRAY_NAME, jsonSchemaMap, schemaType, 
				namespaceMap, null);
		setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, UNAMED, TRUE);
		inputRootTreeNode.getNode().add(treeNode);
		if (getSchemaItems(jsonSchemaMap).size() > 0) {
			// If array has attributes
			if (getSchemaItems(jsonSchemaMap).get(JSON_SCHEMA_ATTRIBUTES) != null) {
				setAttributesForElements(getSchemaItems(jsonSchemaMap), level, namespaceMap, treeNode);
			}
			if (getSchemaItems(jsonSchemaMap).containsKey(JSON_SCHEMA_PROPERTIES)) {
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList,
						JSON_SCHEMA_PROPERTIES_ID,
						getSchemaProperties(getSchemaItems(jsonSchemaMap)).toString());
				setProperties(getSchemaItems(jsonSchemaMap), treeNode, level, namespaceMap);
			} else if (jsonSchemaMap.containsKey(JSON_SCHEMA_ITEMS)) {
				// if the array has an array, then it has no properties and only items
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList,
						JSON_SCHEMA_PROPERTIES_ID,
						jsonSchemaMap.get(JSON_SCHEMA_ITEMS).toString());
				setItemsToArray(getSchemaItems(jsonSchemaMap), treeNode, level, namespaceMap);
			}
		}
		return inputRootTreeNode;
	}

	/**
	 * Adds the prefix for attributes
	 * 
	 * @param elementKey
	 * @return new name
	 */
	private String addPrefixForAttributes(String elementKey) {
		String name;
		if (isAttribute) {
			name = PREFIX + elementKey;
			isAttribute = false;
		} else {
			name = elementKey;
		}
		return name;
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
	 * @param namespaceMap
	 *            namespacemap
	 * @param elementIdentifiersmap
	 * @return tree node
	 */

	private TreeNode createTreeNode(TreeNode inputRootTreeNode, int count, String elementKey,
			Map<String, Object> subSchema, String schemaType, HashMap<String, String> namespaceMap,
			HashMap<String, String> elementIdentifiersmap) {
		TreeNode treeNode;
		EList<PropertyKeyValuePair> propertyValueList = new BasicEList<PropertyKeyValuePair>();
		if (inputRootTreeNode == null) {
			treeNode = DataMapperFactory.eINSTANCE.createTreeNode();
		} else {
			treeNode = inputRootTreeNode;
		}
		setBasicTreeNodeValues(subSchema, schemaType, propertyValueList, count, namespaceMap, elementKey, treeNode,
				elementIdentifiersmap);
		return treeNode;
	}

	/**
	 * Sets the basic tree node values
	 * 
	 * @param subSchema
	 * @param schemaType
	 * @param propertyValueList
	 * @param count
	 * @param namespaceMap
	 * @param elementKey
	 * @param treeNode
	 * @param elementIdentifiersmap
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private TreeNode setBasicTreeNodeValues(Map<String, Object> subSchema, String schemaType,
			EList<PropertyKeyValuePair> propertyValueList, int count, HashMap<String, String> namespaceMap,
			String elementKey, TreeNode treeNode, HashMap<String, String> elementIdentifiersmap) {
		// If the node is a root element then sets the element identifiers value
		if (getElementIdentifiers(subSchema) != null) {
			setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_ELEMENT_IDENTIFIERS,
					getElementIdentifiers(subSchema));
		}
		// If the node is a root element then sets the namesapces value
		if (getNamespaces(subSchema) != null) {
			setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NAMESPACES,
					getNamespaces(subSchema));
		}
		// checks the namespace prefix
		if (namespaceMap != null && namespaceMap.size() > 0) {
			// Iterates through the namespaces map and validates the prefix and
			// sets the name
			String name = validatePrefix(elementKey, namespaceMap, treeNode, propertyValueList);
			treeNode.setName(name);
		} else {
			// Sets the name if there are no namespaces
			treeNode.setName(elementKey);
		}
		treeNode.setLevel(count);

		// Sets the schema type
		setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_TYPE, schemaType);
		// Sets the schema type in SchemaDataType
		setSchemaDataType(treeNode, schemaType);
		// Sets the schema key if available
		if (getSchemaValue(subSchema) != null) {
			setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_SCHEMA_VALUE,
					getSchemaValue(subSchema));
		}
		// Sets the id value if available
		if (getIDValue(subSchema) != null) {
			setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_ID, getIDValue(subSchema));
		}
		// Sets the required value
		if (getRequiredValue(subSchema) != null) {
			setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_REQUIRED,
					getRequiredValue(subSchema));
		}

		if (schemaType.equals(JSON_SCHEMA_ARRAY)) {
			// Handle id, type, and required fields in the items block
			if (subSchema.get(JSON_SCHEMA_ITEMS) != null) {
				Map<String, Object> itemsSchema = null;
				// If items block starts with [{ and ends with }] then convert
				// the arraylist into a Map and then use
				if (subSchema.get(JSON_SCHEMA_ITEMS) instanceof ArrayList) {
					itemsSchema = new HashMap<String, Object>();
					ArrayList<Object> items = (ArrayList<Object>) subSchema.get(JSON_SCHEMA_ITEMS);
					for (Object item : items) {
						itemsSchema.putAll((Map) item);
					}
				} else {
					// If items block doesn't starts with [ and ends with ] then
					// get the Map directly
					itemsSchema = (Map<String, Object>) subSchema.get(JSON_SCHEMA_ITEMS);
				}
				if (itemsSchema.size() > 0) {
					if (itemsSchema.containsKey(JSON_SCHEMA_ID)) {
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_ARRAY_ITEMS_ID,
								itemsSchema.get(JSON_SCHEMA_ID).toString());
					}
					if (itemsSchema.containsKey(JSON_SCHEMA_TYPE)) {
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_ARRAY_ITEMS_TYPE,
								itemsSchema.get(JSON_SCHEMA_TYPE).toString());
					}
					if (itemsSchema.containsKey(JSON_SCHEMA_REQUIRED)) {
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList,
								JSON_SCHEMA_ARRAY_ITEMS_REQUIRED, getRequiredValue(itemsSchema));
					}
					// If item has a value block then save the type
					if (itemsSchema.containsKey(JSON_SCHEMA_VALUE)) {
						Map<String, Object> valueMap = (Map<String, Object>) itemsSchema.get(JSON_SCHEMA_VALUE);
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList,
								JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE, valueMap.get(JSON_SCHEMA_TYPE).toString());
					}
					
					
					
					// Check if there is xsi:nil attribute and then add the nullable value
					boolean hasXsiNil = checkXsiNilForElements(itemsSchema);
					if (hasXsiNil) {
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, TRUE);
					} else if(getNullableValue(itemsSchema) != null){
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, getNullableValue(subSchema));
					}else{
						setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, FALSE);
					}
				}
			}
		} else if (schemaType.equals(JSON_SCHEMA_OBJECT)) {
			// If object has a value block then save ID and type
			if (subSchema.containsKey(JSON_SCHEMA_VALUE)) {
				Map<String, Object> valueMap = (Map<String, Object>) subSchema.get(JSON_SCHEMA_VALUE);
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_OBJECT_VALUE_TYPE,
						valueMap.get(JSON_SCHEMA_TYPE).toString());
			}
			// Check if there is xsi:nil attribute and then add the nullable value
			boolean hasXsiNil = checkXsiNilForElements(subSchema);
			if (hasXsiNil) {
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, TRUE);
			}else if(getNullableValue(subSchema) != null){
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, getNullableValue(subSchema));
			}else {
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, FALSE);
			}
			
			
		} else {
			// Check if there is xsi:nil attribute and then add the nullable value
			boolean hasXsiNil = checkXsiNilForElements(subSchema);
			if (hasXsiNil) {
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, TRUE);
			} else if(getNullableValue(subSchema) != null){
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, getNullableValue(subSchema));
			}else {
				setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NULLABLE, FALSE);
			}
			
	
		}
		return treeNode;
	}

	/**
	 * Sets the schema data type
	 * 
	 * @param treeNode
	 * @param schemaType
	 */
	private void setSchemaDataType(TreeNode treeNode, String schemaType) {
		if (StringUtils.isNotEmpty(schemaType)) {
			switch (schemaType) {
			case "array":
				treeNode.setSchemaDataType(SchemaDataType.ARRAY);
				break;
			case "boolean":
				treeNode.setSchemaDataType(SchemaDataType.BOOLEAN);
				break;
			case "bytes":
				treeNode.setSchemaDataType(SchemaDataType.BYTES);
				break;
			case "double":
				treeNode.setSchemaDataType(SchemaDataType.DOUBLE);
				break;
			case "enum":
				treeNode.setSchemaDataType(SchemaDataType.ENUM);
				break;
			case "fixed":
				treeNode.setSchemaDataType(SchemaDataType.FIXED);
				break;
			case "float":
				treeNode.setSchemaDataType(SchemaDataType.FLOAT);
				break;
			case "int":
				treeNode.setSchemaDataType(SchemaDataType.INT);
				break;
			case "long":
				treeNode.setSchemaDataType(SchemaDataType.LONG);
				break;
			case "map":
				treeNode.setSchemaDataType(SchemaDataType.MAP);
				break;
			case "null":
				treeNode.setSchemaDataType(SchemaDataType.NULL);
				break;
			case "object":
				treeNode.setSchemaDataType(SchemaDataType.OBJECT);
				break;
			case "string":
				treeNode.setSchemaDataType(SchemaDataType.STRING);
				break;
			case "union":
				treeNode.setSchemaDataType(SchemaDataType.UNION);
				break;
			case "number":
				treeNode.setSchemaDataType(SchemaDataType.NUMBER);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Validates the prefix and sets the name
	 * 
	 * @param elementKey
	 * @param namespaceMap
	 * @param treeNode
	 * @param propertyValueList
	 */
	private String validatePrefix(String element, HashMap<String, String> namespaceMap, TreeNode treeNode,
			EList<PropertyKeyValuePair> propertyValueList) {
		String elementKey = null;
		String[] name = null;
		String nodeName = null;
		// If the element contains a xsi:type then split from ',' and get the
		// name with the prefix
		if (element.contains(",")) {
			name = element.split(",");
			elementKey = name[0];
			if (elementKey.contains(":")) {
				// If element contains both xsi:type and namespace prefix
				String nameWithPrefix = checkValidity(namespaceMap, nodeName, elementKey, treeNode, propertyValueList);
				nodeName = nameWithPrefix + "," + name[1];
			} else {
				// If element contains only the xsi:type
				nodeName = element;
			}
			// If the element is an element identifier @xsi:type
		} else if (element.contains(":") && element.startsWith(PREFIX)) {
			String[] fullName = element.split(":");
			String firstPart = fullName[0];
			String prefix = firstPart.substring(1);
			nodeName = checkValidity(namespaceMap, nodeName, prefix, treeNode, propertyValueList);
			nodeName = PREFIX + nodeName + ":" + fullName[1];
		} else if (element.contains(":")) {
			// If element conatains a namespace prefix
			nodeName = checkValidity(namespaceMap, nodeName, element, treeNode, propertyValueList);
		} else {
			// If element doesn't contains a namespace prefix or xsi:type
			nodeName = element;
		}
		return nodeName;

	}

	private String checkValidity(HashMap<String, String> namespaceMap, String nodeName, String elementKey,
			TreeNode treeNode, EList<PropertyKeyValuePair> propertyValueList) {
		String prefix;
		boolean isValid = false;
		if (namespaceMap != null && namespaceMap.size() > 0) {
			String[] split = elementKey.split(":");
			prefix = split[0];
			for (Map.Entry<String, String> entry : namespaceMap.entrySet()) {
				if (entry.getKey().equals(prefix)) {
					String namespace = createNamespaceArray(entry.getKey().toString(), entry.getValue().toString());
					setPropertyKeyValuePairforTreeNodes(treeNode, propertyValueList, JSON_SCHEMA_NAMESPACES, namespace);
					isValid = true;
				}
			}
			if (isValid) {
				nodeName = elementKey;
			} else {
				log.error("Invalid input schema, incorrect namespace prefix");
				displayUserError("WARNING", " Invalid schema,Given schema contains an invalid namespace prefix under : "
						+ JSON_SCHEMA_TITLE);
				throw new IllegalArgumentException(
						"Given schema contains an incorrect value under key : " + JSON_SCHEMA_TITLE);
			}
		}
		return nodeName;
	}

	/**
	 * Creates namespace array for identifiers
	 * 
	 * @param identifierType
	 * @param identifierURL
	 * @return
	 */
	private String createNamespaceArray(String prefix, String url) {
		ArrayList<String> namespacesList = new ArrayList<String>();
		String prefixItem = NAMESPACE_PREFIX + "=" + prefix;
		String urlItem = NAMESPACE_URL + "=" + url;
		String[] namespaceItem = { prefixItem, urlItem };
		String namespaceArrayAsString = Arrays.toString(namespaceItem).substring(1,
				Arrays.toString(namespaceItem).length() - 1);
		namespacesList.add("{" + namespaceArrayAsString + "}");
		String value = StringUtils.join(namespacesList, ',');
		return value;
	}

	/**
	 * Gets the key and value
	 * 
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
	 * Gets the property value for Treenodes
	 * 
	 * @param treeNodeModel
	 * @param key
	 * @return value
	 */
	private String getPropertyKeyValuePairforTreeNodeImpls(TreeNodeImpl treeNodeModel, String key) {
		String value = null;
		for (PropertyKeyValuePair keyValue : treeNodeModel.getProperties()) {
			// If the key is already there add the new value
			if (keyValue.getKey().equals(key)) {
				value = keyValue.getValue();
				if (key.contains("_id") && StringUtils.isEmpty(value)) {
					return "default/" + treeNodeModel.getName();
				}
				break;
			}
		}
		return value;

	}

	/**
	 * Gets the property value for Treenodes
	 * 
	 * @param treeNodeModel
	 * @param key
	 * @return value
	 */
	private String getPropertyKeyValuePairforTreeNode(TreeNode treeNode, String key) {
		String value = null;
		for (PropertyKeyValuePair keyValue : treeNode.getProperties()) {
			// If the key is already there add the new value
			if (keyValue.getKey().equals(key)) {
				value = keyValue.getValue();
				if (key.contains("_id") && StringUtils.isEmpty(value)) {
					return "default/" + treeNode.getName();
				}
				break;
			}
		}
		return value;
	}

	/**
	 * Gets the property value for elements
	 * 
	 * @param treeNodeModel
	 * @param key
	 * @return value
	 */
	private String getPropertyKeyValuePairforElements(Element element, String key) {
		String value = null;
		for (PropertyKeyValuePair keyValue : element.getProperties()) {
			// If the key is already there add the new value
			if (keyValue.getKey().equals(key)) {
				value = keyValue.getValue();
				if (key.contains("_id") && StringUtils.isEmpty(value)) {
					return "default/" + element.getName();
				}
				break;
			}
		}
		return value;

	}

	/**
	 * Gets the schema content
	 */
	@SuppressWarnings("resource")
	@Override
    public String getSchemaContentFromFile(String path) {
        File jschema = new File(path);
        String entireFileText = null;
        try (Scanner scanner = new Scanner(jschema)) {
            entireFileText = scanner.useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            log.error(ERROR_TEXT, e);
		}
		return entireFileText;
	}

	/**
	 * Gets the schema content from the model
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel, File writeToFile, boolean isInput, String type) {

		JSONObject root = new JSONObject();
		Map propertiesObject = new LinkedHashMap<>();
		JSONArray arrayItems = new JSONArray();
		Map itemsObject = new LinkedHashMap<>();
		Map attributesObject = new LinkedHashMap<>();
		JSONArray namespaceArray = new JSONArray();
		JSONArray elementIdentifiersArray = new JSONArray();
		Map valueObject = new LinkedHashMap<>();	
		if (namespaceList.size() > 0 || elementIdentifierList.size() > 0) {
			namespaceList.clear();
			elementIdentifierList.clear();
		}
		if (StringUtils.isNotEmpty(treeNodeModel.getName()) && treeNodeModel.getProperties() != null) {

			EList<TreeNode> nodeList = treeNodeModel.getNode();
			for (TreeNode node : nodeList) {
				if (node.getName().startsWith(PREFIX)) {
					hasAttributes = true;
					break;
				}
			}
			root.put(JSON_SCHEMA_SCHEMA_VALUE,
					getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel, JSON_SCHEMA_SCHEMA_VALUE));
			root.put(JSON_SCHEMA_TITLE, treeNodeModel.getName());
			insetIDAndTypeForJsonObject(treeNodeModel, root);
			if (isInput) {
				root.put("inputType", type);
			} else {
				root.put("outputType", type);
			}
			String schemaType = getPropertyKeyValuePairforTreeNode(treeNodeModel, JSON_SCHEMA_TYPE);
			if(TRUE.equals(getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel, JSON_SCHEMA_NULLABLE))){
			root.put(JSON_SCHEMA_NULLABLE,
					getPropertyKeyValuePairforTreeNodeImpls(treeNodeModel, JSON_SCHEMA_NULLABLE));
			}
			if (schemaType.equals(JSON_SCHEMA_OBJECT)) {
				root.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
			} else if (schemaType.equals(JSON_SCHEMA_ARRAY)) {
				root.put(JSON_SCHEMA_ITEMS, arrayItems);
			}
			// sets the attribute values
			if (hasAttributes) {
				root.put(JSON_SCHEMA_ATTRIBUTES, attributesObject);
				recursiveSchemaGenerator(treeNodeModel, root, root);
				hasAttributes = false;
			}
			insertRequiredArray(root, treeNodeModel, false);
			// Sets the namespaces value
			insertNamespacesArray(root, treeNodeModel, false);
			// Sets the element identifiers value
			insertElementIdentifiersArray(root, treeNodeModel, false);
			if (schemaType.equals(JSON_SCHEMA_OBJECT)) {
				// If root has a value then append it to the root element
				String objectValueBlockType = getPropertyKeyValuePairforTreeNode(treeNodeModel,
						JSON_SCHEMA_OBJECT_VALUE_TYPE);
				if (StringUtils.isNotEmpty(objectValueBlockType)) {
					valueObject.put(JSON_SCHEMA_TYPE, objectValueBlockType);
					root.put(JSON_SCHEMA_VALUE, valueObject);
				}
				recursiveSchemaGenerator(treeNodeModel, propertiesObject, root);
			} else if (schemaType.equals(JSON_SCHEMA_ARRAY)) {
				// If the root is an array then add the items block
				String schemaArrayItemsID = getPropertyKeyValuePairforTreeNode(treeNodeModel,
						JSON_SCHEMA_ARRAY_ITEMS_ID);
				String schemaArrayItemsType = getPropertyKeyValuePairforTreeNode(treeNodeModel,
						JSON_SCHEMA_ARRAY_ITEMS_TYPE);
				// When the root element have children
				if (((TreeNodeImpl) treeNodeModel).getNode().size() > 0) {
					// When generating the tree by loading the payload
					if (StringUtils.isNotEmpty(schemaArrayItemsType)) {
						processChildrenOfRootArray(treeNodeModel, root, propertiesObject, itemsObject,
								schemaArrayItemsID, schemaArrayItemsType);
					} else {
						// When creating the tree by hand, look for items id and
						// type in the child nodes- first child
						String schemaArrayItemID = getPropertyKeyValuePairforTreeNode(
								((TreeNodeImpl) treeNodeModel).getNode().get(0), JSON_SCHEMA_ARRAY_ITEMS_ID);
						/*
						 * Type sets as object because, when the array is an object array then the type of items block
						 * should be object and also when a root array has elements then also it should be included
						 * inside properties block. Therefore the type of the items block should be object in that case
						 * as well
						 */
						String schemaArrayItemType = JSON_SCHEMA_OBJECT;
						processChildrenOfRootArray(treeNodeModel, root, propertiesObject, itemsObject,
								schemaArrayItemID, schemaArrayItemType);
					}
				} else {
					// When the root element doesn't have children
					insertIDandTypeforItemsBlock(itemsObject, schemaArrayItemsID, schemaArrayItemsType);
					insertRequiredArray(itemsObject, treeNodeModel, false);
				}
				String arrayElementIdentifier = getPropertyKeyValuePairforTreeNode(treeNodeModel,
						JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS_URL);
				if (StringUtils.isNotEmpty(addedObjectNamespaces)) {
					// If namespaces are available when creating the
					// tree by hand then add those to the root
					// elements
					if (!namespaceList.contains(addedObjectNamespaces)) {
						namespaceList.add(addedObjectNamespaces);
					}
				}

				if (StringUtils.isNotEmpty(addedObjectElementIdentifiers)) {
					// If element identifiers are available when creating the
					// tree by hand then add those to the root
					// elements
					if (!elementIdentifierList.contains(addedObjectElementIdentifiers)) {
						elementIdentifierList.add(addedObjectElementIdentifiers);
					}
				}
				if (StringUtils.isNotEmpty(arrayElementIdentifier)) {
					// If identifiers are available when creating the
					// tree by hand then add those to the root
					// elements
					if (!namespaceList.contains(arrayElementIdentifier)) {
						namespaceList.add(arrayElementIdentifier);
					}
				}

				// If root has a value then append it to the root element
				String objectValueBlockType = getPropertyKeyValuePairforTreeNode(treeNodeModel,
						JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE);
				if (StringUtils.isNotEmpty(objectValueBlockType)) {
					valueObject.put(JSON_SCHEMA_TYPE, objectValueBlockType);
					itemsObject.put(JSON_SCHEMA_VALUE, valueObject);
				}
				arrayItems.add(itemsObject);
			}
			// Adds all the namespaces to the root element
			String newNamespaceArray = StringUtils.join(namespaceList, ',');
			if (newNamespaceArray.startsWith(",")) {
				newNamespaceArray = newNamespaceArray.substring(1);
			}
			JSONArray nameArray = getJSONArray(namespaceArray, newNamespaceArray);
			if (nameArray.size() > 0) {
				root.put(JSON_SCHEMA_NAMESPACES, nameArray);
			}
			// Adds element identifiers to the root element
			String newElementIdentifiersArray = StringUtils.join(elementIdentifierList, ',');
			if (newElementIdentifiersArray.startsWith(",")) {
				newElementIdentifiersArray = newElementIdentifiersArray.substring(1);
			}
			JSONArray identifierArray = getJSONArray(elementIdentifiersArray, newElementIdentifiersArray);
			if (identifierArray.size() > 0) {
				root.put(JSON_SCHEMA_ELEMENT_IDENTIFIERS, identifierArray);
			}
		}
		return root.toJSONString();
	}

	/**
	 * Process the child of the root array, object and primitives
	 * 
	 * @param treeNodeModel
	 * @param root
	 * @param propertiesObject
	 * @param itemsObject
	 * @param schemaArrayItemsID
	 * @param schemaArrayItemsType
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void processChildrenOfRootArray(TreeNodeImpl treeNodeModel, JSONObject root, Map propertiesObject,
			Map itemsObject, String schemaArrayItemsID, String schemaArrayItemsType) {
		if (schemaArrayItemsType.equals(JSON_SCHEMA_OBJECT)) {
			itemsObject.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
			insertIDandTypeforItemsBlock(itemsObject, schemaArrayItemsID, schemaArrayItemsType);
			insertRequiredArray(itemsObject, treeNodeModel, false);
			recursiveSchemaGenerator(treeNodeModel, propertiesObject, root);
		} else {
			// If the child is an primitive then also it should include inside a properties block
			itemsObject.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
			insertIDandTypeforItemsBlock(itemsObject, schemaArrayItemsID, schemaArrayItemsType);
			insertRequiredArray(itemsObject, treeNodeModel, false);
		}
	}

	/**
	 * Insert ID and Type for items block
	 * 
	 * @param itemsObject
	 * @param schemaArrayItemsID
	 * @param schemaArrayItemsType
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertIDandTypeforItemsBlock(Map itemsObject, String schemaArrayItemsID,
			String schemaArrayItemsType) {
		if (schemaArrayItemsID != null) {
			itemsObject.put(JSON_SCHEMA_ID, schemaArrayItemsID.replace("\\", ""));
		} else {
			itemsObject.put(JSON_SCHEMA_ID, "");
		}
		itemsObject.put(JSON_SCHEMA_TYPE, schemaArrayItemsType);
	}

	/**
	 * Check for attributes in the child nodes
	 * 
	 * @param node
	 */
	private boolean checkForAttributes(TreeNode node) {
		EList<TreeNode> nodeList = node.getNode();
		for (TreeNode treeNode : nodeList) {
			String attributeID = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_ADDED_ATTRIBUTE_ID);
			String attributeType = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE);
			if (attributeID != null && attributeType != null) {
				addedObjectHasAttributes = true;
				break;
			}

		}
		return addedObjectHasAttributes;

	}

	/**
	 * Check for properties in the child nodes
	 * 
	 * @param treeNodeModel
	 */
	private boolean checkForProperties(TreeNode node) {
		EList<TreeNode> nodeList = node.getNode();
		for (TreeNode treeNode : nodeList) {
			String propertiesID = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_ADDED_PROPERTIES_ID);
			if (propertiesID != null) {
				addedObjectHasProperties = true;
				break;
			}

		}
		return addedObjectHasProperties;

	}

	/**
	 * Check for values in the child nodes
	 * 
	 * @param treeNodeModel
	 */
	private String checkValueFromPropertyKeyValuePair(TreeNode node, String key) {
		return getPropertyKeyValuePairforTreeNode(node, key);
	}

	/**
	 * generate the schema recursively
	 * 
	 * @param treeNodeModel
	 * @param parent
	 * @param root
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void recursiveSchemaGenerator(TreeNodeImpl treeNodeModel, Map parent, JSONObject root) {
		if (treeNodeModel != null) {
			EList<Element> elemList = treeNodeModel.getElement();
			EList<TreeNode> nodeList = treeNodeModel.getNode();
			for (TreeNode node : nodeList) {
				String name = node.getName();
				String nullableValue = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_NULLABLE);
				String schemaType = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_TYPE);
				String schemaArrayItemsID = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ARRAY_ITEMS_ID);
				String schemaArrayItemsType = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ARRAY_ITEMS_TYPE);
				String schemaID = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ID);
				String attributeID = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ATTRIBUTE_ID);
				String attributeType = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ATTRIBUTE_TYPE);
				String propertiesId = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_PROPERTIES_ID);
				String objectValueBlockType = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_OBJECT_VALUE_TYPE);
				String objectElementIdentifier = getPropertyKeyValuePairforTreeNode(node,
						JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS_URL);
				String objectAddedAttributeID = getPropertyKeyValuePairforTreeNode(node,
						JSON_SCHEMA_ADDED_ATTRIBUTE_ID);
				String objectAddedAttributeType = getPropertyKeyValuePairforTreeNode(node,
						JSON_SCHEMA_ADDED_ATTRIBUTE_TYPE);
				String arrayValueBlockType = getPropertyKeyValuePairforTreeNode(node,
						JSON_SCHEMA_ARRAY_ITEMS_VALUE_TYPE);
				if (schemaType != null && schemaType.equals(JSON_SCHEMA_OBJECT)) {
					
					Map nodeObject = new LinkedHashMap<>();
					Map propertiesObject = new LinkedHashMap<>();
					Map attributeObject = new LinkedHashMap<>();
					Map valueObject = new LinkedHashMap<>();
					
					// Check if there are attributes in the child nodes of an
					// object when creating the tree by hand
					addedObjectHasAttributes = checkForAttributes(node);
					// Check if there are properties in the child nodes of an
					// object when creating the tree by hand
					addedObjectHasProperties = checkForProperties(node);
					// Check if there are namespaces in the object when creating
					// the tree by hand
					addedObjectNamespaces = checkValueFromPropertyKeyValuePair(node, JSON_SCHEMA_OBJECT_NAMESPACES);
					// Check if there are element identifiers in the object when
					// creating
					// the tree by hand
					addedObjectElementIdentifiers = checkValueFromPropertyKeyValuePair(node,
							JSON_SCHEMA_OBJECT_ELEMENT_IDENTIFIERS);
					// If the iteration happens not because of attributes (
					// properties), then
					// handle the other elements the object
					if (!hasAttributes) {
						insetIDAndTypeForJsonObject(node, nodeObject);
						// If object contains a value block then handle it (
						// when generating and creating tree)
						if (objectValueBlockType != null) {
							valueObject.put(JSON_SCHEMA_TYPE, objectValueBlockType);
							nodeObject.put(JSON_SCHEMA_VALUE, valueObject);
						}
						if (TRUE.equals(nullableValue)) {
							nodeObject.put(JSON_SCHEMA_NULLABLE, nullableValue);
						}
						// If an object doesn't contain properties, then avoid
						// serializing the properties field
						EList<TreeNode> childList = node.getNode();
						if (childList.size() > 0) {
							nodeObject.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
						}
						parent.put(node.getName(), nodeObject);
						insertRequiredArray(nodeObject, node, false);
						// Handles attributes
						if (attributeID != null && attributeType != null) {
							hasAttributes = true;
							nodeObject.put(JSON_SCHEMA_ATTRIBUTES, attributeObject);
							parent.put(node.getName(), nodeObject);
							recursiveSchemaGenerator((TreeNodeImpl) node, nodeObject, root);
							hasAttributes = false;
						}
						// Handle properties when creating tree by hand
						if (addedObjectHasProperties) {
							// Fixing DEVTOOLESB-154
							if (((TreeNodeImpl) node).getNode().size() > 0) {
								nodeObject.put(JSON_SCHEMA_PROPERTIES, propertiesObject);
							}
						}
						if (StringUtils.isNotEmpty(addedObjectNamespaces)) {
							// If namespaces are available when creating the
							// tree by hand then add those to the root elements
							if (!namespaceList.contains(addedObjectNamespaces)) {
								namespaceList.add(addedObjectNamespaces);
							}
						}

						if (StringUtils.isNotEmpty(objectElementIdentifier)) {
							// If element identifiers are available when
							// creating the
							// tree by hand then add those to the root elements
							if (!namespaceList.contains(objectElementIdentifier)) {
								namespaceList.add(objectElementIdentifier);
							}
						}

						if (StringUtils.isNotEmpty(addedObjectElementIdentifiers)) {
							// If element identifiers are available when
							// creating the
							// tree by hand then add those to the root elements
							if (!elementIdentifierList.contains(addedObjectElementIdentifiers)) {
								elementIdentifierList.add(addedObjectElementIdentifiers);
							}
						}
						// Handle attributes when creating tree by hand
						if (addedObjectHasAttributes) {
							// Fixing DEVTOOLESB-154
							if (((TreeNodeImpl) node).getNode().size() > 0) {
								hasAttributes = true;
								nodeObject.put(JSON_SCHEMA_ATTRIBUTES, attributeObject);
								parent.put(node.getName(), nodeObject);
								recursiveSchemaGenerator((TreeNodeImpl) node, nodeObject, root);
								hasAttributes = false;
							}
						}

						recursiveSchemaGenerator((TreeNodeImpl) node, propertiesObject, root);
					}

				} else if (schemaType != null && schemaType.equals(JSON_SCHEMA_ARRAY)) {
			
					Map arrayObject = new LinkedHashMap<>();
					Map itemsObject = new LinkedHashMap<>();
					JSONArray arrayItemsObject = new JSONArray();
					Map attributeObject = new LinkedHashMap<>();
					Map itemProperties = new LinkedHashMap<>();
					Map valueObject = new LinkedHashMap<>();

					// Check if there are attributes in the child nodes of the
					// array when creating the tree by hand
					addedObjectHasAttributes = checkForAttributes(node);
					// Check if there are properties in the child nodes of the
					// array when creating the tree by hand
					addedObjectHasProperties = checkForProperties(node);
					// Check if there are namespaces in the array when creating
					// the tree by hand
					addedObjectNamespaces = checkValueFromPropertyKeyValuePair(node, JSON_SCHEMA_ARRAY_NAMESPACES);
					// Check if there are element identifiers in the array when
					// creating
					// the tree by hand
					addedObjectElementIdentifiers = checkValueFromPropertyKeyValuePair(node,
							JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS);
					String arrayElementIdentifier = getPropertyKeyValuePairforTreeNode(node,
							JSON_SCHEMA_ARRAY_ELEMENT_IDENTIFIERS_URL);
					// If the iteration happens not because of attributes (
					// properties), then
					// handle the other elements in the array
					if (!hasAttributes) {
						insetIDAndTypeForJsonObject(node, arrayObject);
						if (schemaArrayItemsID != null) {
							itemProperties.put(JSON_SCHEMA_ID, schemaArrayItemsID.replace("\\", ""));
						}
						if (schemaArrayItemsType != null) {
							itemProperties.put(JSON_SCHEMA_TYPE, schemaArrayItemsType);
						}
						insertRequiredArray(arrayObject, node, false);
						insertRequiredArray(itemProperties, node, true);
						parent.put(node.getName(), arrayObject);
						if (itemProperties.size() > 0) {
							arrayItemsObject.add(itemProperties);
						}
						if (TRUE.equals(nullableValue)) {
							arrayObject.put(JSON_SCHEMA_NULLABLE, nullableValue);
						}
						arrayObject.put(JSON_SCHEMA_ITEMS, arrayItemsObject);
						if (((TreeNodeImpl) node).getNode().size() > 0) {
							// Handle properties in array
							// if (propertiesId != null) {
							itemProperties.put(JSON_SCHEMA_PROPERTIES, itemsObject);
							recursiveSchemaGenerator((TreeNodeImpl) node, itemsObject, root);
							// }
							// Handle attributes in array
							if (attributeID != null && attributeType != null) {
								hasAttributes = true;
								itemProperties.put(JSON_SCHEMA_ATTRIBUTES, attributeObject);
								recursiveSchemaGenerator((TreeNodeImpl) node, attributeObject, root);
								hasAttributes = false;
							}
							// handle value block ( when generating and creating
							// tree)
							if (arrayValueBlockType != null) {
								valueObject.put(JSON_SCHEMA_TYPE, arrayValueBlockType);
								itemProperties.put(JSON_SCHEMA_VALUE, valueObject);
							}

							/*
							 * Handle type in items block based on the value block when creating tree by hand "items":
							 * [{ "id": "http://wso2jsonschema.org/phone/0", "type": "object", "value":{ "type":
							 * "number" }, "properties": { "ext": { "id": "http://wso2jsonschema.org/phone/0/ext",
							 * "type": "number" } }]}
							 */
							if (addedObjectHasAttributes || addedObjectHasProperties) {
								itemProperties.put(JSON_SCHEMA_TYPE, JSON_SCHEMA_OBJECT);
							}

							if (StringUtils.isNotEmpty(addedObjectNamespaces)) {
								// If namespaces are available when creating the
								// tree by hand then add those to the root
								// elements
								if (!namespaceList.contains(addedObjectNamespaces)) {
									namespaceList.add(addedObjectNamespaces);
								}
							}
							if (StringUtils.isNotEmpty(arrayElementIdentifier)) {
								// If identifiers are available when creating
								// the
								// tree by hand then add those to the root
								// elements
								if (!namespaceList.contains(arrayElementIdentifier)) {
									namespaceList.add(arrayElementIdentifier);
								}
							}

							if (StringUtils.isNotEmpty(addedObjectElementIdentifiers)) {
								// If element identifiers are available when
								// creating the
								// tree by hand then add those to the root
								// elements
								if (!elementIdentifierList.contains(addedObjectElementIdentifiers)) {
									elementIdentifierList.add(addedObjectElementIdentifiers);
								}

							}
							// Handle properties when creating tree by hand
							if (addedObjectHasProperties) {
								itemProperties.put(JSON_SCHEMA_PROPERTIES, itemsObject);
								recursiveSchemaGenerator((TreeNodeImpl) node, itemsObject, root);
							}

							// Handle attributes when creating tree by hand
							if (addedObjectHasAttributes) {
								hasAttributes = true;
								itemProperties.put(JSON_SCHEMA_ATTRIBUTES, attributeObject);
								recursiveSchemaGenerator((TreeNodeImpl) node, attributeObject, root);
								hasAttributes = false;
							}

						} else {
							/*
							 * If array item doesn't contain attributes or properties then set the user entered type as
							 * the item's type "items": [{ "id": "http://wso2jsonschema.org/phone/phone", "type"
							 * :"number" }]
							 */
							if (!itemProperties.containsKey(JSON_SCHEMA_TYPE)) {
								itemProperties.put(JSON_SCHEMA_TYPE, arrayValueBlockType);
							}

							if (StringUtils.isNotEmpty(addedObjectNamespaces)) {
								// If namespaces are available when creating the
								// tree by hand then add those to the root
								// elements
								if (!namespaceList.contains(addedObjectNamespaces)) {
									namespaceList.add(addedObjectNamespaces);
								}
							}

							if (StringUtils.isNotEmpty(addedObjectElementIdentifiers)) {
								// If element identifiers are available when
								// creating the
								// tree by hand then add those to the root
								// elements
								if (!elementIdentifierList.contains(addedObjectElementIdentifiers)) {
									elementIdentifierList.add(addedObjectElementIdentifiers);
								}
							}
							if (StringUtils.isNotEmpty(arrayElementIdentifier)) {
								// If identifiers are available when creating
								// the
								// tree by hand then add those to the root
								// elements
								if (!namespaceList.contains(arrayElementIdentifier)) {
									namespaceList.add(arrayElementIdentifier);
								}
							}
						}
					}
				} else if (schemaType != null) {
					String fieldElementIdentifier = getPropertyKeyValuePairforTreeNode(node,
							JSON_SCHEMA_FIELD_ELEMENT_IDENTIFIERS_URL);
					// Adds attributes
					if (hasAttributes) {
						Map elemObject = null;
						// If the attribute is an element identifier then set
						// the id and type
						if (objectAddedAttributeID != null && objectAddedAttributeType != null) {
							elemObject = new LinkedHashMap<>();
							elemObject.put(JSON_SCHEMA_ID, objectAddedAttributeID);
							elemObject.put(JSON_SCHEMA_TYPE, objectAddedAttributeType);
							if(TRUE.equals(nullableValue)){
							elemObject.put(JSON_SCHEMA_NULLABLE, nullableValue);
							}
						} else {
							elemObject = createElementObject(schemaID);
							elemObject.put(JSON_SCHEMA_TYPE, schemaType);
					        if(TRUE.equals(nullableValue)){
							elemObject.put(JSON_SCHEMA_NULLABLE, nullableValue);
					        }
						}

						// ignore other elements comes from attribute iteration
						if (name.startsWith(PREFIX)) {
							// Check if there are namespaces in the attributes
							// when creating the tree by hand
							addedObjectNamespaces = checkValueFromPropertyKeyValuePair(node,
									JSON_SCHEMA_ATTRIBUTE_NAMESPACES);
							if (StringUtils.isNotEmpty(addedObjectNamespaces)) {
								// If namespaces are available add those to the
								// root elements
								if (!namespaceList.contains(addedObjectNamespaces)) {
									namespaceList.add(addedObjectNamespaces);
								}
							}
							if (StringUtils.isNotEmpty(fieldElementIdentifier)) {
								// If identifiers are available when creating
								// the
								// tree by hand then add those to the root
								// elements
								if (!namespaceList.contains(fieldElementIdentifier)) {
									namespaceList.add(fieldElementIdentifier);
								}
							}
							addedObjectElementIdentifiers = checkValueFromPropertyKeyValuePair(node,
									JSON_SCHEMA_FIELD_ELEMENT_IDENTIFIERS);
							if (StringUtils.isNotEmpty(addedObjectElementIdentifiers)) {
								// If element identifiers are available when
								// creating the
								// tree by hand then add those to the root
								// elements
								if (!elementIdentifierList.contains(addedObjectElementIdentifiers)) {
									elementIdentifierList.add(addedObjectElementIdentifiers);
								}
							}
							// Removes the @prefix
							String nodeName = node.getName().substring(1);
							if ((parent.get(JSON_SCHEMA_ATTRIBUTES)) != null) {
								((HashMap) parent.get(JSON_SCHEMA_ATTRIBUTES)).put(nodeName, elemObject);
							} else {
								parent.put(nodeName, elemObject);
							}
						}
					} else {
						Map elemObject = createElementObject(schemaID);
						elemObject.put(JSON_SCHEMA_TYPE, schemaType);
						if(TRUE.equals(nullableValue)){
						elemObject.put(JSON_SCHEMA_NULLABLE, nullableValue);
						}
						// ignore attributes comes with property iteration
						if (!name.startsWith(PREFIX)) {
							// Check if there are namespaces in the fields when
							// creating the tree by hand
							addedObjectNamespaces = checkValueFromPropertyKeyValuePair(node,
									JSON_SCHEMA_FIELD_NAMESPACES);
							if (StringUtils.isNotEmpty(addedObjectNamespaces)) {
								// If namespaces are available add those to the
								// root elements
								if (!namespaceList.contains(addedObjectNamespaces)) {
									namespaceList.add(addedObjectNamespaces);
								}
							}
							addedObjectElementIdentifiers = checkValueFromPropertyKeyValuePair(node,
									JSON_SCHEMA_FIELD_ELEMENT_IDENTIFIERS);
							if (StringUtils.isNotEmpty(addedObjectElementIdentifiers)) {
								// If element identifiers are available when
								// creating the
								// tree by hand then add those to the root
								// elements
								if (!elementIdentifierList.contains(addedObjectElementIdentifiers)) {
									elementIdentifierList.add(addedObjectElementIdentifiers);
								}
							}
							if (StringUtils.isNotEmpty(fieldElementIdentifier)) {
								// If identifiers are available when creating
								// the
								// tree by hand then add those to the root
								// elements
								if (!namespaceList.contains(fieldElementIdentifier)) {
									namespaceList.add(fieldElementIdentifier);
								}
							}
							parent.put(name, elemObject);
							if (node.getNode() != null) {
								// check if it contains attributes object
								if (((TreeNodeImpl) node).getNode().size() > 0) {
									JSONObject attributesObject = new JSONObject();
									hasAttributes = true;
									elemObject.put(JSON_SCHEMA_ATTRIBUTES, attributesObject);
									recursiveSchemaGenerator((TreeNodeImpl) node, elemObject, root);
									hasAttributes = false;
								}
							}
						}
					}

				}
			}
			for (Element elem : elemList) {

				String schemaType = getPropertyKeyValuePairforElements(elem, JSON_SCHEMA_TYPE);
				String schemaID = getPropertyKeyValuePairforElements(elem, JSON_SCHEMA_ID);
				if (schemaType != null) {
					Map elemObject = createElementObject(schemaID);
					elemObject.put(JSON_SCHEMA_TYPE, schemaType);
					parent.put(elem.getName(), elemObject);
				}
			}
		}
	}

	/**
	 * Creates element object
	 * 
	 * @param schemaID
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map createElementObject(String schemaID) {
		Map elemObject = new LinkedHashMap<>();
		if (schemaID != null) {
			elemObject.put(JSON_SCHEMA_ID, schemaID.replace("\\", ""));
		} else {
			elemObject.put(JSON_SCHEMA_ID, schemaID + "/0");
		}
		return elemObject;
	}

	/**
	 * Inserts Id and type
	 * 
	 * @param node
	 * @param nodeObject
	 */
	@SuppressWarnings("rawtypes")
	private void insetIDAndTypeForJsonObject(TreeNode node, Map nodeObject) {
		String schemaType = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_TYPE);
		String schemaID = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ID);
		insertIDandTypeforItemsBlock(nodeObject, schemaID, schemaType);
	}

	/**
	 * Inserts element identifiers array
	 * 
	 * @param parent
	 * @param node
	 * @param isItems
	 */
	private void insertElementIdentifiersArray(JSONObject parent, TreeNode node, boolean isItems) {
		String elementIdentifiers = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ELEMENT_IDENTIFIERS);
		elementIdentifierList.add(elementIdentifiers);
	}

	/**
	 * Inserts the namespace array
	 * 
	 * @param parent
	 * @param node
	 * @param isItems
	 */
	private void insertNamespacesArray(JSONObject parent, TreeNode node, boolean isItems) {
		String schemaNamespace = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_NAMESPACES);
		EList<TreeNode> nodeList = node.getNode();
		// Use to update the namespaces field with added namespaces in creating
		// the tree by hand
		if (nodeList.size() > 0) {
			updateNamespaceList(nodeList);
		}

		String namespacesValue = StringUtils.join(namespaceList, ',');
		if (StringUtils.isNotEmpty(namespacesValue) && StringUtils.isNotEmpty(schemaNamespace)) { 
			// Appends the newly added namespaces to the root element
			schemaNamespace = schemaNamespace + ", " + namespacesValue;
		}

		if (schemaNamespace != null) {
			// Adds the available
			namespaceList.add(schemaNamespace);
		}
	}

	/**
	 * Updates the namespace list recursively
	 * 
	 * @param nodeList
	 */
	private void updateNamespaceList(EList<TreeNode> nodeList) {
		for (TreeNode treeNode : nodeList) {
			String objectNamespace = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_OBJECT_NAMESPACES);
			String arrayNamespace = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_ARRAY_NAMESPACES);
			String fieldNamespace = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_FIELD_NAMESPACES);
			String attributeNamespace = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_ATTRIBUTE_NAMESPACES);
			String namespace = getPropertyKeyValuePairforTreeNode(treeNode, JSON_SCHEMA_NAMESPACES);
			if (StringUtils.isNotEmpty(objectNamespace)) {
				namespaceList.add(objectNamespace);
			}
			if (StringUtils.isNotEmpty(arrayNamespace)) {
				namespaceList.add(arrayNamespace);
			}
			if (StringUtils.isNotEmpty(fieldNamespace)) {
				namespaceList.add(fieldNamespace);
			}
			if (StringUtils.isNotEmpty(attributeNamespace)) {
				namespaceList.add(attributeNamespace);
			}
			if (StringUtils.isNotEmpty(namespace)) {
				namespaceList.add(namespace);
			}
			if (treeNode.getNode().size() > 0) {
				updateNamespaceList(treeNode.getNode());
			}
		}
	}

	/**
	 * Gets the required array
	 * 
	 * @param requiredArayArray
	 * @param schemaElement
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JSONArray getJSONArray(JSONArray requiredArayArray, String schemaElement) {
		JSONObject jsonObj;
		Pattern logEntry = Pattern.compile("\\{(.*?)\\}");
		Matcher matchPattern = logEntry.matcher(schemaElement);
		while (matchPattern.find()) {
			jsonObj = new JSONObject();
			String value = matchPattern.group(1);
			String[] stringArrs = value.split(",");
			for (String stringArr : stringArrs) {
				if (stringArr.contains("=")) {
					String[] array = stringArr.split("=");
					String firstElement = array[0].trim();
					String secondElement = array[1].trim();
					if (firstElement.contains("\\") || secondElement.contains("\\")) {
						String first = firstElement.replace("\\", "");
						String second = secondElement.replace("\\", "");
						jsonObj.put(first, second);
					} else {
						jsonObj.put(firstElement, secondElement);
					}
				}
			}
			// Adds the object if it doesn't already available in the array
			if (!requiredArayArray.contains(jsonObj)) {
				requiredArayArray.add(jsonObj);
			}
		}
		return requiredArayArray;
	}

	/**
	 * Inserts required array
	 * 
	 * @param itemsObject
	 * @param node
	 * @param isItems
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertRequiredArray(Map parent, TreeNode node, boolean isItems) {
		String requiredString = null;
		JSONArray requiredArray = new JSONArray();
		String schemaRequired = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_REQUIRED);
		String schemaArrayItemsRequired = getPropertyKeyValuePairforTreeNode(node, JSON_SCHEMA_ARRAY_ITEMS_REQUIRED);
		if (schemaRequired != null) {
			requiredString = schemaRequired;
		}
		if (schemaArrayItemsRequired != null && isItems) {
			requiredString = schemaArrayItemsRequired;
		}
		if (requiredString != null) {
			if (requiredString.contains(",")) {
				String[] requiredStringArr = requiredString.split(",");
				for (String retuiredItem : requiredStringArr) {
					requiredArray.add(retuiredItem);
				}
			} else {
				requiredArray.add(requiredString);
			}

			parent.put(JSON_SCHEMA_REQUIRED, requiredArray);
		}
	}

	/**
	 * Updates schema file
	 */
	@Override
	public void updateSchemaFile(String content, File file) {
		try {
			// check of content is null to prevent object mapper throwing
			// exceptions due to empty content
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
	 * 
	 * @param reason
	 * @param message
	 */
	private void displayUserError(String reason, String message) {
		MessageDialog.openWarning(Display.getCurrent().getActiveShell(), reason, message);
	}

	@Override
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel, File schemaFile) {
		// TODO Auto-generated method stub
		return null;
	}

}
