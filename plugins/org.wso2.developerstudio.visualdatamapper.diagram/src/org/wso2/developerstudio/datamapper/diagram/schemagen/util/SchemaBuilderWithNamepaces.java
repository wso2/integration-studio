package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import com.google.gson.JsonObject;

public class SchemaBuilderWithNamepaces extends SchemaBuilder {

	@Override
	protected void addPrimitiveToParent(JsonSchema parent, String id, String value, TypeEnum propertyValueType) {
		if (id.contains("xmlns:")) {
			String prefix = id.substring("xmlns:".length());
			if (root.getCustomArray("namespaces") == null); {
				root.addCustomArray("namespaces");
			}
			JsonObject obj = new JsonObject();
			obj.addProperty("prefix", prefix);
			obj.addProperty("url", value);
			root.getCustomArray("namespaces").add(obj);
		} else {
			super.addPrimitiveToParent(parent, id, value, propertyValueType);
		}
	}
}
