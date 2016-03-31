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

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

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
	private static final String ROOT_TITLE = "root";
	protected static final String AT_PREFIX = "@";
	protected static final String HASHCONTENT = "#@content";
	protected JsonSchema root;
	
	public SchemaBuilder() {
	}

	public String createSchema(String jsonString) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonString); //TODO  handle parsing exception
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

	
	public void createSchemaForObject(JsonObject jsonObject, JsonSchema parent) {

		Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
		for (Entry<String, JsonElement> entry : entrySet) {

			String id = entry.getKey();
			JsonElement element = entry.getValue();
			TypeEnum propertyValueType = RealTypeOf(element);

			if (propertyValueType == TypeEnum.OBJECT) {
				if (isAPrimitiveWithAttributes(element.getAsJsonObject())) {
					addAttributedPrimitiveToParent(parent, id, element);
				} else {
					JsonSchema schema = addObjectToParent(parent, id);
					createSchemaForObject(element.getAsJsonObject(), schema);
				}
			} else if (propertyValueType == TypeEnum.ARRAY) {
				JsonSchema schemaArray = addArrayToParent(parent, id);
				createSchemaForArray(element.getAsJsonArray(), schemaArray, id);
			} else {
				addPrimitiveToParent(parent, id, element.getAsString(), propertyValueType);
			}
		}
	}

	public void createSchemaForArray(JsonArray jsonArray, JsonSchema parent, String id) {
		parent.createItemsArray();
		Iterator<JsonElement> keys = jsonArray.iterator();
		while (keys.hasNext()) {
			JsonElement element = keys.next();
			TypeEnum propertyValueType = RealTypeOf(element);
			if (propertyValueType == TypeEnum.OBJECT) {
				if (isAPrimitiveWithAttributes(element.getAsJsonObject())) {
					addAttributedPrimitiveToParentItemsArray(parent, id, element);
				} else {
					JsonSchema schema = addObjectToParentItemsArray(parent, "0");
					createSchemaForObject(element.getAsJsonObject(), schema);
				}
			} else {
				addPrimitiveToParentItemsArray(parent, "0", propertyValueType);
			}
		}
	}
	
	private void addAttributedPrimitiveToParent(JsonSchema parent, String id, JsonElement element) {
		JsonSchema primitive = addPrimitiveToParent(parent, id, "", TypeEnum.NULL); //TypeEnum (null) will be replaced later
		Set<Entry<String, JsonElement>> attributeEntrySet = element.getAsJsonObject().entrySet();
		for (Entry<String, JsonElement> attributeEntry : attributeEntrySet) {
			String attributeId = attributeEntry.getKey();
			JsonElement attributeElement = attributeEntry.getValue();
			TypeEnum attributeValueType = RealTypeOf(attributeElement);
			if (attributeId.startsWith(AT_PREFIX)){
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
		JsonSchema primitive = addPrimitiveToParentItemsArray(parent, id, TypeEnum.NULL); //TypeEnum (null) will be replaced later
		Set<Entry<String, JsonElement>> attributeEntrySet = element.getAsJsonObject().entrySet();
		for (Entry<String, JsonElement> attributeEntry : attributeEntrySet) {
			String attributeId = attributeEntry.getKey();
			JsonElement attributeElement = attributeEntry.getValue();
			TypeEnum attributeValueType = RealTypeOf(attributeElement);
			if (attributeId.startsWith(AT_PREFIX)){
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
	
	protected JsonSchema addPrimitiveToParent(JsonSchema parent, String id, String value, TypeEnum propertyValueType) {
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
