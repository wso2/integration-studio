package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonSchema {
	
	JsonObject schema;
	
	public JsonObject getAsJsonObject() {
		return schema;
	}

	public JsonSchema() {
		schema = new JsonObject();
	}
	
	//Will be only used by root schema object
	public void setDolarSchema(String namespaceURl) {
		schema.addProperty("$Schema", namespaceURl);
	}
	
	//Will be only used by root schema object
	public void setTitle(String title) {
		schema.addProperty("title", title);
	}
	
	public void setId(String id) {
		schema.addProperty("id", id);
	}
	
	public void setType(String type) {
		schema.addProperty("type", type);
	}
	
	
	public String getDolarSchema() {
		if (schema.get("$Schema") != null) {
			return schema.get("$Schema").getAsString();
		}
		return "";
	}
	
	public String getId() {
		if (schema.get("id") != null) {
			return schema.get("id").getAsString();
		}
		return "";
	}
	
	public String getType() {
		if (schema.get("type") != null) {
			return schema.get("type").getAsString();
		}
		return "";
	}
	
	private void addPropertiesObject(){
		schema.add("properties", new JsonObject());
	}
	
	public void addRequiredObject(){
		JsonArray requiredObject = new JsonArray();
		schema.add("required", requiredObject);
	}
	
	
	public JsonObject getPropertiesObject(){
		if (schema.get("properties") == null) {
			addPropertiesObject();
		} 
		return schema.get("properties").getAsJsonObject();
	}
	
	public JsonArray getItemsArrayObject(){
		if (schema.get("items") == null) {
			schema.add("items", new JsonArray());
		}
		return schema.get("items").getAsJsonArray();
	}
	
	public JsonObject getItemsObject(){
		if (schema.get("items") == null) {
			schema.add("items", new JsonObject());
		}
		return schema.get("items").getAsJsonObject();
	}
	
	public JsonArray getRequiredObject(){
		if (schema.get("required") != null) {
			return schema.get("required").getAsJsonArray();
		}
		return null;
	}
	
	public void addProperty(String name, JsonObject obj) {
		JsonObject propertiesObj = this.getPropertiesObject();
		propertiesObj.add(name, obj);
	}
	
	public void addLeafProperty(String name, String id, String type) {
		JsonObject propertiesObj = this.getPropertiesObject();
		JsonSchema leaf = new JsonSchema();
		leaf.setId(id);
		leaf.setType(type);
		propertiesObj.add(name, leaf.getAsJsonObject());
	}
	
	public void addToItemArray(String name, JsonObject obj) {
		JsonArray itemsObj = this.getItemsArrayObject();
		itemsObj.add(obj);
	}
	
	public void addEmptyItemArray() {
		this.getItemsArrayObject();
	}
	
	public void addItem(JsonObject obj) {
		schema.add("items", obj);
	}
	
	public void addLeafItem(String id, String type) {
		JsonArray itemsObj = this.getItemsArrayObject();
		JsonSchema leaf = new JsonSchema();
		leaf.setId(id);
		leaf.setType(type);
		itemsObj.add(leaf.getAsJsonObject());
	}
	
}
