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

import java.util.Set;

/**
 * Base type for all Avro schema types.
 *
 */
public abstract class AvroType {
	protected String defaultValue;

	/**
	 * Returns a set of fully qualified dependency names (ie namespace + '.' + name).
	 * This is used when building the sorted set of schema types.
	 *
	 * @return a set of dependent type names
	 */
	public abstract Set<String> getDependencies();

	/**
	 * The default value for this avro type. The string can be user-defined, or
	 * use a fixed value specific to the type.
	 *
	 * @see <a href="http://avro.apache.org/docs/current/spec.html#schema_record">avro record docs</a>
	 * @return the default value for the type
	 */
	public final String getDefaultValue() {
		return defaultValue;
	}

	public final void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
