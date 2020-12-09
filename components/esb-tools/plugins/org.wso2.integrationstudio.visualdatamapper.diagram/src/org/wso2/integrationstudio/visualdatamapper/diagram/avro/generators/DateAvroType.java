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

package org.wso2.integrationstudio.visualdatamapper.diagram.avro.generators;

import org.codehaus.jackson.annotate.JsonValue;
import org.wso2.integrationstudio.visualdatamapper.diagram.avro.generator.util.AvroPrimitive;
import org.wso2.integrationstudio.visualdatamapper.diagram.avro.generator.util.AvroRecord;
import org.wso2.integrationstudio.visualdatamapper.diagram.avro.generator.util.AvroType;

import java.util.Collections;
import java.util.Set;

/**
 * 
 * A special type supporting dates.
 * The dates are intended to be stored as long values, as milliseconds in UTC time.
 */
public class DateAvroType extends AvroType {
	public static final String name = "_Date";
	public final String namespace;

	public DateAvroType(String namespace) {
		this.namespace = namespace;
	}

	@JsonValue
	public String jsonValue() {
		return namespace + "." + name;
	}

	@Override
	public Set<String> getDependencies() {
		return Collections.emptySet();
	}

	public static AvroRecord getSchema(String namespace) {
		AvroType type = AvroPrimitive.PrimitiveType.LONG.newInstance();
		AvroRecord record = new AvroRecord();
		record.addField("timestamp", type, type.getDefaultValue());
		record.setDocs("A date stored as a timestamp, in ms UTC.");
		record.name = name;
		record.namespace = namespace;

		return record;
	}	
}
