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

	JsonSchema root;
	
	public SchemaBuilder() {
	}

	public String createSchema(String jsonString) {
		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject) jsonParser.parse(jsonString);
		root = new JsonSchema();
		root.setDolarSchema("http://json-schema.org/draft-04/schema#");
		root.setTitle(getTitle(jo));
		root.setId("http://jsonschema.net");
		root.setType("object");
		createSchema4Object(jo, root);
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
				addPrimitiveToParent(parent, id, element.getAsString(), propertyValueType);
			}
		}
	}

	public void createSchema4Array(JsonArray aJsonArray, JsonSchema parent, String id) {
		parent.createItemsArray();
		Iterator<JsonElement> keys = aJsonArray.iterator();
		while (keys.hasNext()) {
			JsonElement element = keys.next();
			TypeEnum propertyValueType = RealTypeOf(element);
			if (propertyValueType == TypeEnum.OBJECT) {
				JsonSchema schema = addObjectToParentItemsArray(parent, "0");
				createSchema4Object(element.getAsJsonObject(), schema);
			} else {
				addPrimitiveToParentItemsArray(parent, "0", propertyValueType);
			}
		}
	}


	protected JsonSchema addObjectToParent(JsonSchema parent, String id) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType("object");
		parent.addObject(id, schema);
		return schema;
	}
	
	protected JsonSchema addArrayToParent(JsonSchema parent, String id) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType("array");
		parent.addArray(id, schema);
		return schema;
	}
	
	
	protected void addPrimitiveToParent(JsonSchema parent, String id, String value, TypeEnum propertyValueType) {
		JsonSchema leaf = new JsonSchema();
		leaf.setId(parent.getId() + "/" + id);
		leaf.setType(propertyValueType.toString().toLowerCase());
		parent.addPrimitive(id, leaf);
	}
	

	protected JsonSchema addObjectToParentItemsArray(JsonSchema parent, String id) {
		JsonSchema schema = new JsonSchema();
		schema.setId(parent.getId() + "/" + id);
		schema.setType("object");
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
