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

import java.util.Collections;
import java.util.Set;

/**
 * Class which represents an Avro map type.
 * http://avro.apache.org/docs/current/spec.html#Maps
 *
 */
public class AvroMap extends AvroType {
	@JsonProperty
	public final String type = "map";

	@JsonProperty
	private final AvroType values;

	public AvroMap(AvroType valuesType) {
		this.values = valuesType;
		defaultValue = "{}";
	}

	@Override
	public Set<String> getDependencies() {
		if (values != null) {
			return values.getDependencies();
		} else {
			return Collections.emptySet();
		}
	}
}
