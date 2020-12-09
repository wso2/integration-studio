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
import org.codehaus.jackson.annotate.JsonValue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Exposes its type as a string. Therefore, when set as the type of another
 * object, the JSON value will simply be the string as originally set.
 *
 */
public class DummyAvroType extends AvroType {
	public final String type;

	public DummyAvroType(String type) {
		this.type = type;
	}
	
	@JsonValue
	private String jsonValue() {
		return type;
	}

	@Override
	public Set<String> getDependencies() {
		if (type != null) {
			Set<String> dependencies = new HashSet<String>();
			dependencies.add(type);
			return dependencies;
		} else {
			return Collections.emptySet();
		}
	}
}
