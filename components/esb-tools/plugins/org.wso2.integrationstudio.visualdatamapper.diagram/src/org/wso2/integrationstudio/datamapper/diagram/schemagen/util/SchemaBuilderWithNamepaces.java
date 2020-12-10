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

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.wso2.integrationstudio.datamapper.diagram.schemagen.util.SchemaBuilder.TypeEnum;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class SchemaBuilderWithNamepaces extends SchemaBuilder {

	private static final String NAMESPACES = "namespaces";
	private static final String XMLNS = "xmlns:";
	private static final String ELEMENT_IDENTIFIERS = "elementIdentifiers";
	private static final String DEFAULT_NAMESPACE = "xmlns";
	private static final String TYPE = "type";
	private static final String VALUE = "value";
	private static final String PREFIX = "prefix";
	private static final String URL = "url";
	private static final String STRING = "string";
	private static final String NULL = "null";
	private static final String DOLLLAR_AT_PREFIX = "$@";

	@Override
	protected JsonSchema addPrimitiveToParent(JsonSchema parent, String id, String value, TypeEnum propertyValueType,
			Map<String, String> elementIdentifierMap) {
		if (id.contains(XMLNS)) {
			String prefix = id.substring(XMLNS.length());
			JsonObject obj = new JsonObject();
			obj.addProperty(PREFIX, prefix);
			obj.addProperty(URL, value);
			JsonArray namespaces = root.getCustomArray(NAMESPACES);
			if (namespaces != null) {
				namespaces.add(obj);
			} else {
				root.addCustomArray(NAMESPACES);
				namespaces = root.getCustomArray(NAMESPACES);
				namespaces.add(obj);
			}
			// Create element identifier block
			if (elementIdentifierMap.containsKey(prefix)) {
				JsonArray identifiers = root.getCustomArray(ELEMENT_IDENTIFIERS);
				JsonObject identifierObj = new JsonObject();
				identifierObj.addProperty(TYPE, elementIdentifierMap.get(prefix));
				if (identifiers != null) {
					identifiers.add(identifierObj);
				} else {
					root.addCustomArray(ELEMENT_IDENTIFIERS);
					identifiers = root.getCustomArray(ELEMENT_IDENTIFIERS);
					identifiers.add(identifierObj);
				}
				elementIdentifierMap.clear();
			}
			return null;
		} else if (id.startsWith(DOLLLAR_AT_PREFIX)) {
			JsonSchema leaf = new JsonSchema();
			String idwithoutAtSign = id.substring(2);
			leaf.setId(parent.getId() + "/" + idwithoutAtSign);
			leaf.setType(propertyValueType.toString().toLowerCase());
			parent.addAttribute(idwithoutAtSign, leaf);
			return leaf;
		} else if (id.startsWith(AT_PREFIX)) {
			JsonSchema leaf = new JsonSchema();
			String idwithoutAtSign = id.substring(1);
			leaf.setId(parent.getId() + "/" + idwithoutAtSign);
			leaf.setType(value);
			parent.addAttribute(idwithoutAtSign, leaf);
			return leaf;
		} else if (id.equals(HASHCONTENT)) {
			JsonParser jsonParser = new JsonParser();
			if (StringUtils.isNotEmpty(value)) {
				if (jsonParser.parse(value) instanceof JsonObject) {
					JsonObject valueObject = (JsonObject) jsonParser.parse(value);
					addValueObject(parent, valueObject);
				}
				if (jsonParser.parse(value) instanceof JsonPrimitive) {
					JsonPrimitive valueObject = (JsonPrimitive) jsonParser.parse(value);
					addValueObject(parent, valueObject);
				}
			}
			return null;
		} else if (id.equals(DEFAULT_NAMESPACE)) {
			return null;
		} else {
			return super.addPrimitiveToParent(parent, id, value, propertyValueType, elementIdentifierMap);
		}
	}

	/**
	 * Adds the value object
	 * 
	 * @param parent
	 * @param valueObject
	 */
	private void addValueObject(JsonSchema parent, JsonElement valueObject) {
		if (valueObject instanceof JsonObject) {
			Set<Entry<String, JsonElement>> contentEntrySet = valueObject.getAsJsonObject().entrySet();
			for (Entry<String, JsonElement> contentEntry : contentEntrySet) {
				String contentKey = contentEntry.getKey();
				if (contentKey.equals(CONTENT)) {
					TypeEnum propertyType = RealTypeOf(contentEntry.getValue());
					if (!propertyType.toString().toLowerCase().equals(NULL)) {
						JsonObject object = new JsonObject();
						object.addProperty(TYPE, propertyType.toString().toLowerCase());
						parent.addCustomObject(VALUE, object);
					}
				}
			}
		} else if (valueObject instanceof JsonPrimitive) {
			TypeEnum propertyType = RealTypeOf(valueObject);
			if (!propertyType.toString().toLowerCase().equals(NULL)) {
				JsonObject object = new JsonObject();
				object.addProperty(TYPE, propertyType.toString().toLowerCase());
				parent.addCustomObject(VALUE, object);
			}
		}

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
}
