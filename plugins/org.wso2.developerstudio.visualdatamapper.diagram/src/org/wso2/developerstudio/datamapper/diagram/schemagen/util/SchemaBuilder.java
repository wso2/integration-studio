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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class SchemaBuilder {

	private static final String HTTP_WSO2JSONSCHEMA_ORG = "http://wso2jsonschema.org";
	private static final String HTTP_JSON_SCHEMA_ORG_DRAFT_04_SCHEMA = "http://json-schema.org/draft-04/schema#";
	private static final String ARRAY = "array";
	private static final String OBJECT = "object";
	private static final String ID = "id";
	private static final String TYPE = "type";
	private static final String PROPERTIES = "properties";
	private static final String ELEMENT_IDENTIFIER_ARRAY_NAME = "arrayName";
	private static final String ROOT_TITLE = "root";
	protected static final String AT_PREFIX = "@";
	protected static final String DOLLLAR_AT_PREFIX = "$@";
	protected static final String HASHCONTENT = "#@content";
	protected JsonSchema root;
	Map<String, JsonElement> objectMap = new HashMap<>();
	String arrayKey = null;
	Map<String, String> elementIdentifierMap = new HashMap<>();
	Map<String, String> elementIdentifierArrayNameMap = new HashMap<>();

	public SchemaBuilder() {
	}

	public String createSchema(String jsonString) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonString); // TODO
																			// handle
																			// parsing
																			// exception
		JsonObject firstObject = null;
		String title = ROOT_TITLE;
		Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
		if (entrySet.size() == 1) {
			for (Entry<String, JsonElement> entry : entrySet) {
				title = entry.getKey();
				JsonElement element = entry.getValue();
				firstObject = element.getAsJsonObject();
				break;
			}
		} else {
			firstObject = jsonObject;
		}

		root = new JsonSchema();
		root.setDolarSchema(HTTP_JSON_SCHEMA_ORG_DRAFT_04_SCHEMA);
		root.setTitle(title);
		root.setId(HTTP_WSO2JSONSCHEMA_ORG);
		root.setType(OBJECT);
		createSchemaForObject(firstObject, root);
		return root.getAsJsonObject().toString();
	}

	private boolean isAPrimitiveWithAttributes(JsonObject object) {

		Set<Entry<String, JsonElement>> entrySet = object.entrySet();
		for (Entry<String, JsonElement> entry : entrySet) {
			String id = entry.getKey();
			if (!(id.startsWith(AT_PREFIX) || id.equals(HASHCONTENT))) {
				return false;
			}
		}
		return true;
	}

	public String createSchemaForObject(JsonObject jsonObject, JsonSchema parent) {

		String elementIdentifierValue = null;
		String identifierKey = null;
		Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
		for (Entry<String, JsonElement> entry : entrySet) {

			String id = entry.getKey();
			// If it's an element identifier then save the value
			if (id.startsWith("$")) {
				String entryValue = entry.getValue().toString().replace("\"", "");
				elementIdentifierValue = id.substring(2) + "=" + entryValue;
				identifierKey = getKeyOfElementIdentifier(id);
				elementIdentifierMap.put(identifierKey, id.substring(2));
			}
			JsonElement element = entry.getValue();
			TypeEnum propertyValueType = RealTypeOf(element);

			if (propertyValueType == TypeEnum.OBJECT) {
				if (isAPrimitiveWithAttributes(element.getAsJsonObject())) {
					addAttributedPrimitiveToParent(parent, id, element);
				} else {
					JsonSchema schema = addObjectToParent(parent, id);
					createSchemaForObject(element.getAsJsonObject(), schema);
					// If the element contains the array key(if the child of
					// this element holds an element identifier) then remove the
					// child
					// from the json object and adds the new child
					if (StringUtils.isNotEmpty(arrayKey)) {
						JsonObject arrayObj = new JsonObject();
						if (!objectMap.isEmpty()) {
							JsonObject proObj = createNewPropertiesObject();
							// adss the properties object to the root
							arrayObj.add(PROPERTIES, proObj);
							// Adds it and type for the newly created object
							Set<Entry<String, JsonElement>> idTypeSet = schema.getAsJsonObject().entrySet();
							for (Entry<String, JsonElement> idType : idTypeSet) {
								if (idType.getKey().equals(ID)) {
									arrayObj.add(ID, idType.getValue());
								} else if (idType.getKey().equals(TYPE)) {
									arrayObj.add(TYPE, idType.getValue());
								}
							}
						}

						parent.getCustomObject(PROPERTIES).remove(id);
						parent.getCustomObject(PROPERTIES).add(id, arrayObj);
						arrayKey = null;
						objectMap.clear();
					}
				}
			} else if (propertyValueType == TypeEnum.ARRAY) {

				JsonObject newObject = null;
				for (JsonElement childElement : element.getAsJsonArray()) {
					JsonSchema schemaArray = addArrayToParent(parent, id);
					elementIdentifierArrayNameMap.put(ELEMENT_IDENTIFIER_ARRAY_NAME, id);
					newObject = createSchemaForArray(childElement, schemaArray, id, jsonObject);
					if (newObject.entrySet().size() > 0) {
						Set<Entry<String, JsonElement>> entrySets = newObject.entrySet();
						String key = null;
						JsonElement value = null;
						for (Entry<String, JsonElement> entryNew : entrySets) {
							key = entryNew.getKey();
							value = entryNew.getValue();
						}
						// Adds the newly created object with element identifier
						// appended to the name, to the map
						objectMap.put(key, value);
						// Saves the key of the array which has element identifiers
						arrayKey = entry.getKey();
					}
				}

			} else {
				addPrimitiveToParent(parent, id, element.getAsString(), propertyValueType, elementIdentifierMap);
			}
		}
		return elementIdentifierValue;
	}

	/**
	 * Creates a new properties object
	 * 
	 * @param propertiesObject
	 */
	private JsonObject createNewPropertiesObject() {
		// creates the properties object
		JsonObject propertiesObject = new JsonObject();
		for (Entry<String, JsonElement> object : objectMap.entrySet()) {
			String newKey = object.getKey();
			JsonElement ele = object.getValue();
			// add values to the properties object
			propertiesObject.add(newKey, ele);
		}
		return propertiesObject;
	}

	/**
	 * Gets the key of element idenfier
	 * 
	 * @param id
	 */
	private String getKeyOfElementIdentifier(String id) {
		String key = null;
		// $@xsi:type
		if (id.contains(":")) {
			String[] identifier = id.split(":");
			// $@xsi
			key = identifier[0];
			if (key.startsWith(DOLLLAR_AT_PREFIX)) {
				key = key.substring(2);
			}
		}
		return key;
	}

	/**
	 * Edit the json object to create the new object
	 * 
	 * @param jsonObject
	 * @param schema
	 * @return
	 */
	private JsonObject editJsonObject(JsonObject jsonObject, JsonSchema schema) {
		Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
		for (Entry<String, JsonElement> entry : entrySet) {
			// FIXME - check this if part is working properly
			if (entry.getKey().equals(arrayKey)) {
				if (jsonObject.entrySet().contains(arrayKey)) {
					jsonObject.getAsJsonObject().remove(entry.getKey());
				}
			} else {
				if (entry.getValue() instanceof JsonObject) {
					Set<Entry<String, JsonElement>> entrySetChild = ((JsonObject) entry.getValue()).entrySet();
					for (Entry<String, JsonElement> entryChild : entrySetChild) {
						if (entryChild.getKey().equals(arrayKey)) {
							jsonObject.getAsJsonObject(entry.getKey()).remove(entryChild.getKey());
						}
					}
				} else {
					if (entry.getValue() instanceof JsonArray) {
						// TODO if the element identifier is inside an array (
						// array inside an array)
					}
				}
			}
		}
		return jsonObject;
	}

	public JsonObject createSchemaForArray(JsonElement childElement, JsonSchema parent, String id,
			JsonObject jsonObject) {
		JsonObject newJObj = new JsonObject();
		parent.createItemsArray();
		TypeEnum propertyValueType = RealTypeOf(childElement);
		if (propertyValueType == TypeEnum.OBJECT) {
			if (isAPrimitiveWithAttributes(childElement.getAsJsonObject())) {
				addAttributedPrimitiveToParentItemsArray(parent, id, childElement);
			} else {
				JsonSchema schema = addObjectToParentItemsArray(parent, "0");
				String identifierValue = createSchemaForObject(childElement.getAsJsonObject(), schema);

				// If the element contains the array key(if the child of this
				// element holds an element identifier) then remove it from the
				// json object and adds the new object
				if (StringUtils.isNotEmpty(arrayKey)) {
					/*
					 * editJsonObject(jsonObject,schema); JsonObject arrayObj =
					 * new JsonObject(); if (!objectMap.isEmpty()) { JsonObject
					 * proObj = createNewPropertiesObject(); //adss the
					 * properties object to the root arrayObj.add(PROPERTIES,
					 * proObj); //Adds it and type for the newly created object
					 * Set<Entry<String, JsonElement>> idTypeSet =
					 * schema.getAsJsonObject().entrySet(); for (Entry<String,
					 * JsonElement> idType : idTypeSet) { if
					 * (idType.getKey().equals(ID)) { arrayObj.add(ID,
					 * idType.getValue()); } else
					 * if(idType.getKey().equals(TYPE)) { arrayObj.add(TYPE,
					 * idType.getValue()); } } }
					 * 
					 * parent.getCustomObject(PROPERTIES).remove(id);
					 * parent.getCustomObject(PROPERTIES).add(id, jsonObject);
					 * arrayKey = null; objectMap.clear();
					 */

					// FIXME Handle this when element identifier array is inside
					// another array

				}
				JsonElement value = parent.getAsJsonObject();
				// If an element contains an identifier value then create a new
				// object appending the identifier to the name
				if (StringUtils.isNotEmpty(identifierValue)) {
					String name = null;
					if (elementIdentifierArrayNameMap.containsKey(ELEMENT_IDENTIFIER_ARRAY_NAME)) {
						name = elementIdentifierArrayNameMap.get(ELEMENT_IDENTIFIER_ARRAY_NAME) + "," + identifierValue;
					}
					newJObj.add(name, value);
				}
			}
		} else {
			addPrimitiveToParentItemsArray(parent, "0", propertyValueType);
		}
		return newJObj;
	}

	private void addAttributedPrimitiveToParent(JsonSchema parent, String id, JsonElement element) {
		JsonSchema primitive = addPrimitiveToParent(parent, id, "", TypeEnum.NULL, elementIdentifierMap); // TypeEnum
																											// (null)
																											// will
																											// be
																											// replaced
																											// later
		Set<Entry<String, JsonElement>> attributeEntrySet = element.getAsJsonObject().entrySet();
		for (Entry<String, JsonElement> attributeEntry : attributeEntrySet) {
			String attributeId = attributeEntry.getKey();
			JsonElement attributeElement = attributeEntry.getValue();
			TypeEnum attributeValueType = RealTypeOf(attributeElement);
			if (attributeId.startsWith(AT_PREFIX)) {
				JsonSchema leaf = new JsonSchema();
				String idwithoutAtSign = attributeId.substring(1);
				leaf.setId(parent.getId() + "/" + idwithoutAtSign);
				leaf.setType(attributeValueType.toString().toLowerCase());
				primitive.addAttribute(idwithoutAtSign, leaf);
			} else {
				primitive.setType(attributeValueType.toString().toLowerCase());
			}
		}
	}

	private void addAttributedPrimitiveToParentItemsArray(JsonSchema parent, String id, JsonElement element) {
		JsonSchema primitive = addPrimitiveToParentItemsArray(parent, id, TypeEnum.NULL); // TypeEnum
																							// (null)
																							// will
																							// be
																							// replaced
																							// later
		Set<Entry<String, JsonElement>> attributeEntrySet = element.getAsJsonObject().entrySet();
		for (Entry<String, JsonElement> attributeEntry : attributeEntrySet) {
			String attributeId = attributeEntry.getKey();
			JsonElement attributeElement = attributeEntry.getValue();
			TypeEnum attributeValueType = RealTypeOf(attributeElement);
			if (attributeId.startsWith(AT_PREFIX)) {
				JsonSchema leaf = new JsonSchema();
				String idwithoutAtSign = attributeId.substring(1);
				leaf.setId(parent.getId() + "/" + idwithoutAtSign);
				leaf.setType(attributeValueType.toString().toLowerCase());
				primitive.addAttribute(idwithoutAtSign, leaf);
			} else if (attributeId.equals(HASHCONTENT)) {
				JsonObject object = new JsonObject();
				object.addProperty("type", attributeValueType.toString().toLowerCase());
				primitive.setType(TypeEnum.OBJECT.toString().toLowerCase());
				primitive.addCustomObject("value", object);
			} else {
				primitive.setType(attributeValueType.toString().toLowerCase());
			}
		}
	}

	protected JsonSchema addObjectToParent(JsonSchema parent, String id) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType(OBJECT);
		parent.addObject(id, schema);
		return schema;
	}

	protected JsonSchema addArrayToParent(JsonSchema parent, String id) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType(ARRAY);
		parent.addArray(id, schema);
		return schema;
	}

	protected JsonSchema addPrimitiveToParent(JsonSchema parent, String id, String value, TypeEnum propertyValueType,
			Map<String, String> elementIdentifierMap) {
		JsonSchema leaf = new JsonSchema();
		leaf.setId(parent.getId() + "/" + id);
		leaf.setType(propertyValueType.toString().toLowerCase());
		parent.addPrimitive(id, leaf);
		return leaf;
	}

	protected JsonSchema addObjectToParentItemsArray(JsonSchema parent, String id) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType(OBJECT);
		parent.addArrayItem(id, schema);
		return schema;
	}

	protected JsonSchema addPrimitiveToParentItemsArray(JsonSchema parent, String id, TypeEnum propertyValueType) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType(propertyValueType.toString().toLowerCase());
		parent.addArrayItem(id, schema);
		return schema;
	}

	private static TypeEnum RealTypeOf(JsonElement element) {
		if (element == null || element.isJsonNull()) {
			return TypeEnum.NULL;
		} else if (element.isJsonArray()) {
			return TypeEnum.ARRAY;
		} else if (element.isJsonObject()) {
			return TypeEnum.OBJECT;
		} else if (element.isJsonPrimitive()) {
			JsonPrimitive p = element.getAsJsonPrimitive();
			if (p.isNumber()) {
				return TypeEnum.NUMBER;
			} else if (p.isBoolean()) {
				return TypeEnum.BOOLEAN;
			} else if (p.isString()) {
				return TypeEnum.STRING;
			}
		}
		return TypeEnum.UNDEFINED;
	}

	public enum TypeEnum {
		STRING, NUMBER, BOOLEAN, OBJECT, ARRAY, NULL, ANY, UNDEFINED
	}
}
