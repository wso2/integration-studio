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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SchemaBuilderWithNamepaces extends SchemaBuilder {

	private static final String NAMESPACES = "namespaces";
	private static final String XMLNS = "xmlns:";


	@Override
	protected JsonSchema addPrimitiveToParent(JsonSchema parent, String id, String value, TypeEnum propertyValueType) {
		if (id.contains(XMLNS)) {
			String prefix = id.substring(XMLNS.length());
			JsonObject obj = new JsonObject();
			obj.addProperty("prefix", prefix);
			obj.addProperty("url", value);
			JsonArray namespaces = root.getCustomArray(NAMESPACES);
			if (namespaces != null) {
				namespaces.add(obj);
			} else {
				root.addCustomArray(NAMESPACES);
				namespaces = root.getCustomArray(NAMESPACES);
				namespaces.add(obj);
			}
			return null;
		} else if (id.startsWith(AT_PREFIX)) {
			JsonSchema leaf = new JsonSchema();
		    String idwithoutAtSign = id.substring(1);
			leaf.setId(parent.getId() + "/" + idwithoutAtSign);
			leaf.setType(propertyValueType.toString().toLowerCase());
			parent.addAttribute(idwithoutAtSign, leaf);
			return leaf;
		} else if (id.equals(HASHCONTENT)) {
		   JsonObject object = new JsonObject();
		   object.addProperty("type", propertyValueType.toString().toLowerCase());
		   parent.addCustomObject("value", object);	
		   return null;	
		} else {
		   return super.addPrimitiveToParent(parent, id, value, propertyValueType);
		}
	}

}
