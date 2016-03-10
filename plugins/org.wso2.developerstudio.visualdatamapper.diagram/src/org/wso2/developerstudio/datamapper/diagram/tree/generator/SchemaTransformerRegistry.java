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
package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * A registry of schema transformer.
 */
public class SchemaTransformerRegistry {

	private static final String AVRO = "avro";

	/**
	 * Singleton instance.
	 */
	private static SchemaTransformerRegistry singleton;

	/**
	 * transformer map.
	 */
	private Map<String, Class<? extends ISchemaTransformer>> schemaMap;

	private SchemaTransformerRegistry() {

		schemaMap = new HashMap<String, Class<? extends ISchemaTransformer>>();
		schemaMap.put(AVRO, SchemaTransformer.class);

	}

	/**
	 * @return singleton instance.
	 */
	public static SchemaTransformerRegistry getInstance() {
		if (null == singleton) {
			singleton = new SchemaTransformerRegistry();
		}
		return singleton;
	}

	@SuppressWarnings("unchecked")
	public Class<ISchemaTransformer> getSchemaTransformer() {
		Class<ISchemaTransformer> reader = null;
		if (schemaMap.containsKey(AVRO)) {
			reader = (Class<ISchemaTransformer>) schemaMap.get(AVRO);
		} else {
			throw new RuntimeException("No schema transformer found for " + AVRO);
		}
		return reader;
	}

}
