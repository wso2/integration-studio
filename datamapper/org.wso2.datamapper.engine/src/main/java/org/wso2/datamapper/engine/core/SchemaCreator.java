/*
 * Copyright 2005,2013 WSO2, Inc. http://www.wso2.org
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
package org.wso2.datamapper.engine.core;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;

public class SchemaCreator {

	private Map<String, Schema> schemaMap;
	private Map<String, String> avroArrayMap;
	private String fieldName;
	
	public Map<String, String> getAvroArrayMap() {
		return avroArrayMap;
	}

	public SchemaCreator(){
		this.schemaMap = new LinkedHashMap<String, Schema>();
		this.avroArrayMap = new LinkedHashMap<String, String>();
	}
	
	public void setSchema(Schema schema) {

		if(schema.getType() == Schema.Type.ARRAY){
			schemaMap.put(fieldName, schema);
			avroArrayMap.put(schema.getElementType().getName() , fieldName);
			fieldName = null;
			setSchema(schema.getElementType());
			
		} else if(schema.getType() == Schema.Type.RECORD){
			
			schemaMap.put(schema.getName(), schema);
			Iterator<Field> fieldItr = schema.getFields().listIterator();
			Schema.Field field;
			
			while (fieldItr.hasNext()) {
				field = (Schema.Field) fieldItr.next();
				fieldName = field.name();
				setSchema(field.schema());
			}
		}
	}

	public Map<String, Schema> getSchemaMap() {
		return schemaMap;
	}

}
