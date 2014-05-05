/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.custom.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.datamapper.diagram.Activator;

/**
 * Transform utils to convert json to avro schema
 */
public class JsonToAvroSchemaTransformer {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String ERROR_PARSING_JSON_INPUT = Messages.JsonToAvroSchemaTransformer_errorParsingJsonInput;

	/**
	 * @param jsonString
	 *            Sample json input read from file
	 * @return
	 */
	public Schema transform(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory jsonFactory = mapper.getJsonFactory();
		JsonParser jsonParser;

		// This object is used to traverse and transform
		JsonNode jsonNode;
		try {
			jsonParser = jsonFactory.createJsonParser(jsonString);
			// Top node of json tree is read
			jsonNode = jsonParser.readValueAsTree();
		} catch (IOException e) {
			log.error(ERROR_PARSING_JSON_INPUT, e);
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
			ErrorDialog.openError(Display.getCurrent().getActiveShell(), ERROR_PARSING_JSON_INPUT,
					null, status);
			return null;
		}

		// Consider only first root. Multi-rooted json are not supported
		String firstFieldName = jsonNode.getFieldNames().next();
		jsonNode = jsonNode.get(firstFieldName);

		// Schema of the root element
		Schema schema = Schema.createRecord(firstFieldName, null, null, false);
		List<Field> fields = new ArrayList<Field>();

		Iterator<Entry<String, JsonNode>> jsonFields = jsonNode.getFields();
		while (jsonFields.hasNext()) {
			Entry<String, JsonNode> jsonField = jsonFields.next();

			// Name of the json node
			String jsonFieldKey = jsonField.getKey();
			// Get sub node using node name
			JsonNode subNode = jsonNode.get(jsonFieldKey);

			// Continue only if a sub node is present
			if (null != subNode) {
				if (subNode.isObject()) {
					// handles if child is a record
					fields.add(createRecord(subNode, jsonFieldKey));
				} else if (subNode.isArray()) {
					// handles if child is an array
					fields.add(createArray(subNode, jsonFieldKey));
				} else {
					// handles primitive types
					fields.add(createField(subNode, jsonFieldKey));
				}

			}
		}
		/*
		 * if (jsonNode.has(0)) { // iterate over children of root node
		 * Iterator<JsonNode> elements = jsonNode.getElements(); while
		 * (elements.hasNext()) { JsonNode element = elements.next();
		 * 
		 * if (element.isObject()) { // handles if child is a record
		 * fields.add(createRecord(element)); } else if (element.isArray()) { //
		 * handles if child is an array fields.add(createArray(element)); } else
		 * { // handles primitive types fields.add(createField(element)); } } }
		 */

		/*
		 * setFields() is locked after first assignment of fields. Call only
		 * once per schema
		 */
		schema.setFields(fields);

		return schema;
		/*
		 * //Field Schema schema2 = Schema.create(Type.STRING); Field field2 =
		 * new Field("CCCC", schema2, null, null); //Record Schema schema1 =
		 * Schema.createRecord("BBBB", null, null, false); List<Field> fields1 =
		 * new ArrayList<Field>(); fields1.add(field2);
		 * schema1.setFields(fields1); Field field11 = new Field("DDDD",
		 * schema1, null, null); //Root record Schema schema =
		 * Schema.createRecord("AAAA", null, null, false); List<Field> fields =
		 * new ArrayList<Field>(); fields.add(field11);
		 * schema.setFields(fields);
		 * 
		 * return schema;
		 */
	}

	private Field createRecord(JsonNode node, String nodeFieldKey) {
		// Schema for field
		Schema schema1 = Schema.createRecord(nodeFieldKey, null, null, false);
		List<Field> fields1 = new ArrayList<Field>();

		Iterator<Entry<String, JsonNode>> jsonFields = node.getFields();
		while (jsonFields.hasNext()) {
			Entry<String, JsonNode> jsonField = jsonFields.next();

			// Name of the json node
			String jsonFieldKey = jsonField.getKey();
			// Get sub node using node name
			JsonNode subNode = node.get(jsonFieldKey);

			// Continue only if a sub node is present
			if (null != subNode) {
				if (subNode.isObject()) {
					// handles if child is a record
					fields1.add(createRecord(subNode, jsonFieldKey));
				} else if (subNode.isArray()) {
					// handles if child is an array
					fields1.add(createArray(subNode, jsonFieldKey));
				} else {
					// handles primitive types
					fields1.add(createField(subNode, jsonFieldKey));
				}
			}
		}
		schema1.setFields(fields1);

		// This is added as a field for the parent RECORD
		Field field = new Field(nodeFieldKey, schema1, null, null);
		return field;
	}

	private Field createArray(JsonNode node, String nodeFieldKey) {
		/*
		 * FIXME modify ecore model to define the element type for ARRAY. RECORD
		 * is set as the default element type for ARRAY. Schema for the RECORD
		 * under ARRAY
		 */
		Schema recordSchema = Schema.createRecord(nodeFieldKey, null, null, false);
		/*
		 * FIXME Appends the suffix "Item" to identify as the RECORD under ARRAY
		 * Schema recordSchema = Schema.createRecord(node.getName() +
		 * EditorUtils.AVRO_ARRAY_ITEM_SUFFIX, null, null, false);
		 */
		List<Field> fieldsForRecord = new ArrayList<Field>();

		Iterator<Entry<String, JsonNode>> jsonFields = node.getFields();
		while (jsonFields.hasNext()) {
			Entry<String, JsonNode> jsonField = jsonFields.next();

			// Name of the json node
			String jsonFieldKey = jsonField.getKey();
			// Get sub node using node name
			JsonNode subNode = node.get(jsonFieldKey);

			// Continue only if a sub node is present
			if (null != subNode) {
				if (subNode.isObject()) {
					// handles if child is a record
					fieldsForRecord.add(createRecord(subNode, jsonFieldKey));
				} else if (subNode.isArray()) {
					// handles if child is an array
					fieldsForRecord.add(createArray(subNode, jsonFieldKey));
				} else {
					// handles primitive types
					fieldsForRecord.add(createField(subNode, jsonFieldKey));
				}
			}

		}
		recordSchema.setFields(fieldsForRecord);

		// Schema for ARRAY type
		Schema arraySchema = Schema.createArray(recordSchema);
		// New field including ARRAY type schema
		Field field = new Field(nodeFieldKey, arraySchema, null, null);
		return field;
	}

	private Field createField(JsonNode node, String nodeFieldKey) {
		Type fieldDatatype = null;

		// Conversion from primitive type to avro specification
		if (node.isBoolean()) {
			fieldDatatype = Type.BOOLEAN;
		} else if (node.isDouble()) {
			fieldDatatype = Type.DOUBLE;
		} else if (node.isFloatingPointNumber()) {
			fieldDatatype = Type.FLOAT;
		} else if (node.isInt()) {
			fieldDatatype = Type.INT;
		} else if (node.isLong()) {
			fieldDatatype = Type.LONG;
		} else if (node.isTextual()) {
			fieldDatatype = Type.STRING;
		}
		// No support for Type.BYTES in jackson
		// Following types are not supported yet : ENUM, FIXED, MAP, NULL, UNION

		// Schema for type:field
		if (null != fieldDatatype) {
			Schema schema1 = Schema.create(fieldDatatype);
			Field field = new Field(nodeFieldKey, schema1, null, null);
			return field;
		} else {
			return null;
		}

	}
}