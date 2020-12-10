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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class which represents an Avro union type.
 * http://avro.apache.org/docs/current/spec.html#Unions
 *
 */
public class AvroUnion extends AvroType {
	public final AvroType[] types;

	public AvroUnion(AvroType...types) {
		if (types != null) {
//			Set<AvroType> typeSet = mergeUnions(types);
//			this.types = typeSet.toArray(new AvroType[typeSet.size()]);
			this.types = types;
		} else {
			this.types = new AvroType[]{};
		}

		defaultValue = _getDefaultValue();
	}

	public AvroUnion(List<AvroType> types) {
		this(types.toArray(new AvroType[types.size()]));
	}

	@JsonValue
	private AvroType[] jsonValue() {
		return types;
	}

	@Override
	public Set<String> getDependencies() {
		Set<String> dependencies = new HashSet<String>();

		for (AvroType type : types) {
			dependencies.addAll(type.getDependencies());
		}

		return dependencies;
	}

	/**
	 * From the avro spec:
	 * <pre>
	 *     Default values for union fields correspond to the first schema in the union.
	 * </pre>
	 */
	private String _getDefaultValue() {
		if (types.length == 0) {
			return null;
		} else {
			return types[0].getDefaultValue();
		}
	}

	// this is a bit hackish, but nested unions are not allowed
	// better would be to prevent them from being created in the first place
	private Set<AvroType> mergeUnions(AvroType...types) {
		Set<AvroType> retval = new HashSet<AvroType>();
		Set<String> seen = new HashSet<String>();

		for (AvroType type : types) {
			if (type instanceof AvroUnion) {
				retval.addAll(mergeUnions(((AvroUnion) type).types));
			} else {
				if (type instanceof AvroType)
				retval.add(type);
			}
		}

		return retval;
	}
}
