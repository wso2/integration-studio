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
		schema.addProperty("$schema", namespaceURl);
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
		if (schema.get("$schema") != null) {
			return schema.get("$schema").getAsString();
		}
		return "";
	}
	
	public String getTitle(String title) {
		if (schema.get("title") != null) {
			return schema.get("title").getAsString();
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
	
	public JsonObject getPropertiesObject(){
		if (schema.get("properties") == null) {
			schema.add("properties", new JsonObject());
		} 
		return schema.get("properties").getAsJsonObject();
	}
	
	public JsonObject getAttributesObject(){
		if (schema.get("attributes") == null) {
			schema.add("attributes", new JsonObject());
		} 
		return schema.get("attributes").getAsJsonObject();
	}
	
	public JsonArray getRequiredObject(){
		if (schema.get("required") == null) {
			schema.add("required", new JsonArray());
		}
		return schema.get("required").getAsJsonArray();
	}
	
	public JsonArray getItemsArrayObject(){
		if (schema.get("items") == null) {
			schema.add("items", new JsonArray());
		}
		return schema.get("items").getAsJsonArray();
	}

	
	public void addObject(String name, JsonSchema obj) {
		JsonObject propertiesObj = this.getPropertiesObject();
		propertiesObj.add(name, obj.getAsJsonObject());
	}
	
	public void addAttribute(String name, JsonSchema obj) {
		JsonObject attribObj = this.getAttributesObject();
		attribObj.add(name, obj.getAsJsonObject());
	}

	public void addArray(String name, JsonSchema obj) {
		JsonObject propertiesObj = this.getPropertiesObject();
		propertiesObj.getAsJsonObject().add(name, obj.getAsJsonObject());
	}
	
	public void addPrimitive(String name, JsonSchema leaf) {
		JsonObject propertiesObj = this.getPropertiesObject();
		propertiesObj.add(name, leaf.getAsJsonObject());
	}
	
	public void createItemsArray(){
		getItemsArrayObject();
	}
	
	public void addArrayItem(String name, JsonSchema obj) {
		JsonArray itemsObj = this.getItemsArrayObject();
		itemsObj.add(obj.getAsJsonObject());
	}
	
	public void addCustomArray(String name) {
		schema.add(name, new JsonArray());
	}
	
	public void addCustomObject(String name, JsonObject jsonObject) {
		schema.add(name, jsonObject);
	}

	public JsonArray getCustomArray(String name) {
		if (schema.get(name) != null) {
			return schema.get(name).getAsJsonArray();
		}
		return null;
	}
	
	public JsonObject getCustomObject(String name) {
		if (schema.get(name) != null) {
			return schema.get(name).getAsJsonObject();
		}
		return null;
	}
}
