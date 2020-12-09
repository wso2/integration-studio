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

package org.wso2.integrationstudio.visualdatamapper.diagram.avro.generator.util;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Collections;
import java.util.Set;

/**
 * Class which represents an Avro fixed type.
 * http://avro.apache.org/docs/current/spec.html#Fixed
 *
 */
public class AvroFixed extends AvroType {
	@JsonProperty
	public final String type = "fixed";

	@JsonProperty
	public String name;

	@JsonProperty
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String namespace;


	@JsonProperty
	private final int size;

	public AvroFixed(int size) {
		this.size = size;

		/*
		 * From the avro docs:
	     *     Default values for bytes and fixed fields are JSON strings, where
	     *     Unicode code points 0-255 are mapped to unsigned 8-bit byte values 0-255.
		 */
		defaultValue = "\\u00FF";
	}

	@Override
	public Set<String> getDependencies() {
		return Collections.emptySet();
	}
}
