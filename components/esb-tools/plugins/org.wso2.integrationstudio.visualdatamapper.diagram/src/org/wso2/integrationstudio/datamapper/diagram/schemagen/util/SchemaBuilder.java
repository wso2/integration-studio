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

package org.wso2.integrationstudio.datamapper.diagram.schemagen.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class SchemaBuilder {

	private static final String HTTP_WSO2JSONSCHEMA_ORG = "http://wso2jsonschema.org";
	private static final String HTTP_JSON_SCHEMA_ORG_DRAFT_04_SCHEMA = "http://wso2.org/json-schema/wso2-data-mapper-v5.0.0/schema#";
	private static final String ARRAY = "array";
	private static final String OBJECT = "object";
	private static final String ID = "id";
	private static final String TYPE = "type";
	private static final String PROPERTIES = "properties";
	private static final String ELEMENT_IDENTIFIER_ARRAY_NAME = "arrayName";
	private static final String ROOT_TITLE = "root";
	protected static final String AT_PREFIX = "@";
	protected static final String DOLLLAR_AT_PREFIX = "$@";
	protected static final String DOLLAR_PREFIX = "@#$";
	protected static final String HASHCONTENT = "#@content";
	protected static final String CONTENT = "content";
	protected static final String XSI_TYPE_OLD = "_$@xsi:type_";
	protected static final String XSI_TYPE_READABLE = ",xsi:type=";
	private static final String NAMESPACES = "namespaces";
	private static final String STRING = "string";
	private static final String XSI_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema-instance";
	private static final String XML = "xml";
	private static final String JSON = "json";
	private static final String ZERO = "0";
	

	protected JsonSchema root;
	Map<String, JsonElement> objectMap = new HashMap<>();
	String arrayKey = null;
	Map<String, String> elementIdentifierMap = new HashMap<>();
	Map<String, String> elementIdentifierArrayNameMap = new HashMap<>();
	private List<String> elementsToModified = new ArrayList<>();
	boolean isRootJSON = false;

	public SchemaBuilder() {
	}

	public String createSchema(String jsonString, FileType type) {
		JsonParser jsonParser = new JsonParser();
		JsonObject firstObject = null;
		String title = ROOT_TITLE;
		JsonObject jsonObject = null;
		JsonArray jsonArray = null;

		root = new JsonSchema();
		root.setDolarSchema(HTTP_JSON_SCHEMA_ORG_DRAFT_04_SCHEMA);
		root.setId(HTTP_WSO2JSONSCHEMA_ORG);

		if (jsonParser.parse(jsonString) instanceof JsonObject) {
			// TODO handle parsing exception
			jsonObject = (JsonObject) jsonParser.parse(jsonString); 
			Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
			if(type.toString().toLowerCase().equals(XML)){
				//If type is xml, then check if it has a root element
				if (entrySet.size() == 1) {
					for (Entry<String, JsonElement> entry : entrySet) {
						JsonElement element = entry.getValue();
						if (element instanceof JsonObject) {
							title = entry.getKey();
							firstObject = element.getAsJsonObject();
							break;
						} else {
							// If the json has a single parameter DEVTOOLESB-224
							firstObject = jsonObject;
						}
					}
				} else {
					firstObject = jsonObject;
				}
			}else{
				//If type is json then wrap the content with a root element, DEVTOOLESB-373
				firstObject = jsonObject;
			}
			
			root.setType(OBJECT);
			createSchemaForObject(firstObject, root);

		} else {
			jsonArray = (JsonArray) jsonParser.parse(jsonString);
			root.setType(ARRAY);
			createSchemaForArrayRoot(jsonArray, root);
		}

		Pattern identifierPattern = Pattern.compile("(_.+:type)");
		title = findAndModifyElements(identifierPattern, title, title);
		root.setTitle(title);
		String content = root.getAsJsonObject().toString();
		// rename to a readable xsi:type format
		for (String element : elementsToModified) {
			content = findAndModifyElements(identifierPattern, content, element);
		}
		elementsToModified.clear();
		return content;
	}

	private String findAndModifyElements(Pattern identifierPattern, String content, String element) {
		Matcher matcher = identifierPattern.matcher(element);
		while (matcher.find()) {
			String s = matcher.group(0);
			String prefix = s.split(":")[0].substring(3);
			if (root.getCustomArray(NAMESPACES) != null) {
				JsonArray jsonArray = root.getCustomArray(NAMESPACES);
				for (int i = 0; i < jsonArray.size(); ++i) {
					JsonElement jsonElement = jsonArray.get(i);
					if (XSI_NAMESPACE_URI.equals(jsonElement.getAsJsonObject().get("url").getAsString())) {
						content = content.replace("_$@" + prefix + ":type_", "," + prefix + ":type=");
						break;
					}
				}
			}
		}
		return content;
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
			if (id.startsWith(DOLLAR_PREFIX)) {
				String entryValue = entry.getValue().toString().replace("\"", "");
				elementIdentifierValue = id.substring(2) + "=" + entryValue;
				identifierKey = getKeyOfElementIdentifier(id);
				elementIdentifierMap.put(identifierKey, id.substring(2));
			}
			// find xsi:type ids and put them in a list
			Pattern identifierPattern = Pattern.compile("(_.+:type)");
			Matcher matcher = identifierPattern.matcher(id);
			while (matcher.find()) {
				elementsToModified.add(id);
			}

			JsonElement element = entry.getValue();
			TypeEnum propertyValueType = RealTypeOf(element);

			if (entry.getKey().equals(HASHCONTENT)) {
				addPrimitiveToParent(parent, id, entry.getValue().toString(), propertyValueType, elementIdentifierMap);
			} else if (entry.getKey().startsWith(AT_PREFIX)) {
				if (!element.isJsonNull()) {
					if (element instanceof JsonObject) {
						Set<Entry<String, JsonElement>> contentEntrySet = element.getAsJsonObject().entrySet();
						for (Entry<String, JsonElement> contentEntry : contentEntrySet) {
							String contentKey = contentEntry.getKey();
							if (contentKey.equals(CONTENT)) {
								TypeEnum propertyType = RealTypeOf(contentEntry.getValue());
								addPrimitiveToParent(parent, id, propertyType.toString().toLowerCase(), propertyValueType,
										elementIdentifierMap);
							}
						}
					} else {
						TypeEnum propertyType = RealTypeOf(entry.getValue());
						addPrimitiveToParent(parent, id, propertyType.toString().toLowerCase(), propertyValueType,
								elementIdentifierMap);
					}
				}
			} else {
				if (propertyValueType == TypeEnum.OBJECT) {
					if (isAPrimitiveWithAttributes(element.getAsJsonObject())) {
						addAttributedPrimitiveToParent(parent, id, element);
					} else {
						JsonSchema schema = addObjectToParent(parent, id);
						createSchemaForObject(element.getAsJsonObject(), schema);
						/*If the element contains the array key(if the child of
						* this element holds an element identifier) then remove
						* the
						* child
						*from the json object and adds the new child
						**/
						if (StringUtils.isNotEmpty(arrayKey)) {
							JsonObject arrayObj = new JsonObject();
							if (!objectMap.isEmpty()) {
								JsonObject proObj = createNewPropertiesObject();
								// adss the properties object to the root
								arrayObj.add(PROPERTIES, proObj);
								// Adds id and type for the newly created object
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
							/*Adds the newly created object with element
							* identifier
							* appended to the name, to the map
							* */
							objectMap.put(key, value);
							/*Saves the key of the array which has element
							* identifiers
							* */
							arrayKey = entry.getKey();
						}
					}

				} else {
					if (element instanceof JsonNull) {
						// Fixing DEVTOOLESB-225
						addPrimitiveToParent(parent, id, null, propertyValueType, elementIdentifierMap);
					} else {
						addPrimitiveToParent(parent, id, element.getAsString(), propertyValueType,
								elementIdentifierMap);
					}
				}
			}

		}
		return elementIdentifierValue;
	}

	/**
	 * Creates the schema when the root is an array
	 * 
	 * @param jsonArray
	 * @param parent
	 */
	public void createSchemaForArrayRoot(JsonArray jsonArray, JsonSchema parent) {

		String id = ROOT_TITLE;
		JsonObject newJObj = new JsonObject();
		for (JsonElement childElement : jsonArray) {
			TypeEnum propertyValueType = RealTypeOf(childElement);
			if (propertyValueType == TypeEnum.OBJECT) {
				if (isAPrimitiveWithAttributes(childElement.getAsJsonObject())) {
					addAttributedPrimitiveToParentItemsArray(parent, id, childElement);
				} else {
					JsonSchema schema = addObjectToParentItemsArray(parent, "0");
					String identifierValue = createSchemaForObject(childElement.getAsJsonObject(), schema);
					JsonElement value = parent.getAsJsonObject();
					/* If an element contains an identifier value then create a
					 * new
					 * object appending the identifier to the name
					 * */
					if (StringUtils.isNotEmpty(identifierValue)) {
						String name = null;
						if (elementIdentifierArrayNameMap.containsKey(ELEMENT_IDENTIFIER_ARRAY_NAME)) {
							name = elementIdentifierArrayNameMap.get(ELEMENT_IDENTIFIER_ARRAY_NAME) + ","
									+ identifierValue;
						}
						newJObj.add(name, value);
					}
				}
			} else {
				addPrimitiveToParentItemsArray(parent, "0", propertyValueType);
			}

		}
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
		} else if (propertyValueType == TypeEnum.ARRAY) {
			for (JsonElement subChildElement : childElement.getAsJsonArray()) {
				JsonSchema schemaArray = addArrayToParentItemsArray(parent, ZERO);
				createSchemaForArray(subChildElement, schemaArray, ZERO, jsonObject);
				break;
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
				String type = getAttributeType(attributeElement);
				leaf.setType(type);
				primitive.setType(TypeEnum.OBJECT.toString().toLowerCase());
				primitive.addAttribute(idwithoutAtSign, leaf);
			}else if (attributeId.startsWith(HASHCONTENT)) {
				addValueObject(primitive, attributeElement); 
				primitive.setType(TypeEnum.OBJECT.toString().toLowerCase());
			}else {
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
				String type = getAttributeType(attributeElement);
				leaf.setType(type);
				primitive.addAttribute(idwithoutAtSign, leaf);
				primitive.setType(TypeEnum.OBJECT.toString().toLowerCase());
			} else if (attributeId.equals(HASHCONTENT)) {
			    addValueObject(primitive, attributeElement); 
				primitive.setType(TypeEnum.OBJECT.toString().toLowerCase());
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
	
	/**
	 * Add an array type object into parents items array.
	 * 
	 * @param parent parent schema
	 * @param id identifier of the new object
	 * @return new schema
	 */
	protected JsonSchema addArrayToParentItemsArray(JsonSchema parent, String id) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType(ARRAY);
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
				String value = p.getAsString();
				if (StringUtils.isNotEmpty(value)) {
					return TypeEnum.STRING;
				} else {
					return TypeEnum.NULL;
				}
			}
		}
		return TypeEnum.UNDEFINED;
	}

	public enum TypeEnum {
		STRING, NUMBER, BOOLEAN, OBJECT, ARRAY, NULL, ANY, UNDEFINED
	}
	
	/**
	 * Adds the value object
	 * @param parent
	 * @param valueObject
	 */
	private void addValueObject(JsonSchema parent, JsonElement valueObject) {
		if(valueObject instanceof JsonObject){
			Set<Entry<String, JsonElement>> contentEntrySet = valueObject.getAsJsonObject().entrySet();
			for (Entry<String, JsonElement> contentEntry : contentEntrySet) {
				String contentKey = contentEntry.getKey();
				if (contentKey.equals(CONTENT)) {
					TypeEnum propertyType = RealTypeOf(contentEntry.getValue());
					JsonObject object = new JsonObject();
					object.addProperty("type", propertyType.toString().toLowerCase());
					parent.addCustomObject("value", object);	
				}
			}
		}else if(valueObject instanceof JsonPrimitive){
			TypeEnum propertyType = RealTypeOf(valueObject);
			JsonObject object = new JsonObject();
			object.addProperty("type", propertyType.toString().toLowerCase());
			parent.addCustomObject("value", object);
		}
		
	}
	
	/**
	 * Adds the value object
	 * @param parent
	 * @param valueObject
	 */
	private String getAttributeType(JsonElement attrObject) {
		TypeEnum propertyType = null;
		if(attrObject instanceof JsonObject){
		Set<Entry<String, JsonElement>> contentEntrySet = attrObject.getAsJsonObject().entrySet();
			for (Entry<String, JsonElement> contentEntry : contentEntrySet) {
				String contentKey = contentEntry.getKey();
				if (contentKey.equals(CONTENT)) {
					propertyType = RealTypeOf(contentEntry.getValue());
	
				}
			}
		}else if(attrObject instanceof JsonPrimitive){
			propertyType = RealTypeOf(attrObject);
		}
		return propertyType.toString().toLowerCase();
	}
	
}
