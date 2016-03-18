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

	public SchemaBuilder() {
	}

	public String createSchema(String jsonString) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject) jsonParser.parse(jsonString);
		JsonSchema root = new JsonSchema();
		root.setDolarSchema("http://json-schema.org/draft-04/schema#");
		root.setTitle(getTitle(jo));
		root.setId("http://jsonschema.net");
		root.setType("object");
		createSchema4Object(jo, root);
		System.out.println(root.getAsJsonObject().toString());
		return root.getAsJsonObject().toString();
	}

	private String getTitle(JsonObject jo) {
		Set<Entry<String, JsonElement>> entrySet = jo.entrySet();
		String title = "";
		for (Entry<String, JsonElement> entry : entrySet) {
			title = entry.getKey();
		}
		return title;
	}

	public void createSchema4Object(JsonObject jo, JsonSchema parent) {

		Set<Entry<String, JsonElement>> entrySet = jo.entrySet();
		for (Entry<String, JsonElement> entry : entrySet) {

			String id = entry.getKey();
			JsonElement element = entry.getValue();
			TypeEnum propertyValueType = RealTypeOf(element);

			if (propertyValueType == TypeEnum.OBJECT) {
				JsonSchema schema = addObjectToParent(parent, id);
				createSchema4Object(element.getAsJsonObject(), schema);
			} else if (propertyValueType == TypeEnum.ARRAY) {
				JsonSchema schemaArray = addArrayToParent(parent, id);
				createSchema4Array(element.getAsJsonArray(), schemaArray, id);
			} else {
				parent.addLeafProperty(id, parent.getId() + "/" + id, propertyValueType.toString().toLowerCase());
			}
		}
	}

	public void createSchema4Array(JsonArray aJsonArray, JsonSchema parent, String id) {
		if (aJsonArray.size() == 0) {
			parent.addEmptyItemArray();
		} else if (aJsonArray.size() == 1) {
			parent.setId(id);
			JsonElement element = aJsonArray.get(0);
			TypeEnum propertyValueType = RealTypeOf(element);
			if (propertyValueType == TypeEnum.OBJECT) {
				JsonSchema schema = addObjectToParentItemsObject(parent, "0");
				createSchema4Object(element.getAsJsonObject(), schema);
			} else {
				addValueToParentItemsObject(parent, "0", propertyValueType);
			}
		} else if (aJsonArray.size() > 1) {
			Iterator<JsonElement> keys = aJsonArray.iterator();
			while (keys.hasNext()) {
				JsonElement element = keys.next();
				TypeEnum propertyValueType = RealTypeOf(element);
				if (propertyValueType == TypeEnum.OBJECT) {
					JsonSchema schema = addObjectToParentItemsArrayObject(parent, "0");
					createSchema4Object(element.getAsJsonObject(), schema);
				} else {
					addValueToParentItemsArrayObject(parent, "0", propertyValueType);
				}
			}
		}
	}

	private JsonSchema addObjectToParent(JsonSchema parent, String propertyKey) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + propertyKey);
		schema.setType("object");
		parent.addProperty(propertyKey, schema.getAsJsonObject());
		return schema;
	}

	private JsonSchema addObjectToParentItemsArrayObject(JsonSchema parent, String propertyKey) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + propertyKey);
		schema.setType("object");
		parent.addToItemArray(propertyKey, schema.getAsJsonObject());
		return schema;
	}

	private JsonSchema addObjectToParentItemsObject(JsonSchema parent, String propertyKey) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + propertyKey);
		schema.setType("object");
		parent.addItem(schema.getAsJsonObject());
		return schema;
	}

	private JsonSchema addValueToParentItemsArrayObject(JsonSchema parent, String id, TypeEnum propertyValueType) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType(propertyValueType.toString().toLowerCase());
		parent.addToItemArray(id, schema.getAsJsonObject());
		return schema;
	}

	private void addValueToParentItemsObject(JsonSchema parent, String id, TypeEnum propertyValueType) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType(propertyValueType.toString().toLowerCase());
		parent.addItem(schema.getAsJsonObject());
	}

	private JsonSchema addArrayToParent(JsonSchema parent, String propertyKey) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + propertyKey);
		schema.setType("array");
		parent.getAsJsonObject().add(propertyKey, schema.getAsJsonObject());
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
