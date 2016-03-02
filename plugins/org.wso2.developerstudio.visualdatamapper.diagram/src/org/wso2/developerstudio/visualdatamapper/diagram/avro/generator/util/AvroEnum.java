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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Class which represents an Avro enumerated type.
 * http://avro.apache.org/docs/current/spec.html#Enums
 *
 */
public class AvroEnum extends NamedAvroType {
	public static final String UNSET = "UNSET";     // added to every enumeration, supporting the default value

	@JsonProperty
	public final String type = "enum";

	@JsonProperty
	private final String[] symbols;


	public AvroEnum(Collection<String> symbols) {
		this(symbols.toArray(new String[symbols.size()]));
	}
	
	public AvroEnum(String...theSymbols) {
		if (theSymbols != null) {
			symbols = Arrays.copyOf(theSymbols, theSymbols.length+1);
			symbols[symbols.length-1] = UNSET;
		} else {
			this.symbols = new String[]{UNSET};
		}

		defaultValue = UNSET;
	}

	@Override
	public Set<String> getDependencies() {
		return Collections.emptySet();
	}
}
