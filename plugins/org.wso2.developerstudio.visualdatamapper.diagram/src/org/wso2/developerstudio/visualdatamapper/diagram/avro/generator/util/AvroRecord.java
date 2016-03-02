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

package org.wso2.developerstudio.visualdatamapper.diagram.avro.generator.util;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class which represents an avro record type.
 * http://avro.apache.org/docs/current/spec.html#schema_record
 *
 * To add individual fields, use the {@link #addField(String, AvroType, String)} method.
 *
 */
@SuppressWarnings("unchecked")
public class AvroRecord extends NamedAvroType {
	@JsonProperty
	public final String type = "record";

	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String doc;

	@JsonProperty
	private final List<AvroRecordField> fields = new ArrayList<AvroRecordField>();


	public AvroRecord() {
		defaultValue = "{}";
	}

	public void addField(String name, AvroType type, String defaultValue) {
		AvroRecordField field = new AvroRecordField();
		field.name = name;
		field.type = type;
		field.defaultValue = defaultValue;

		fields.add(field);
	}

	public static class AvroRecordField {
		@JsonProperty
		public String name;

		@JsonProperty
		public AvroType type;

		@JsonProperty
		@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
		public String doc;
		
		@JsonProperty("default")
		@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
		public String defaultValue;
	}

	public void setDocs(String doc) {
		this.doc = doc;
	}

	@Override
	public Set<String> getDependencies() {
		Set<String> dependencies = new HashSet<String>();	
	
		for (AvroRecordField field : fields) {
			dependencies.addAll(field.type.getDependencies());
		}
		
		return dependencies;
	}
}
