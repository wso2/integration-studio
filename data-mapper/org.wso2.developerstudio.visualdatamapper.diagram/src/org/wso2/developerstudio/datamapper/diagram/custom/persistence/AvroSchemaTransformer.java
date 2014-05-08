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

import java.util.ArrayList;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;

/**
 * Transform utils for Avro schema
 */
public class AvroSchemaTransformer {

	/**
	 * Transforms the modified TreeNodeImpl model to avro schema
	 * 
	 * @param treeNodeModel
	 *            TreeNodeImpl respective to input/output edit part
	 * @return
	 */
	public Schema transform(TreeNodeImpl treeNodeModel) {
		// Schema of the root element
		Schema schema = Schema.createRecord(treeNodeModel.getName(), null, null, false);
		List<Field> fields = new ArrayList<Field>();

		if (!treeNodeModel.getNode().isEmpty()) {
			for (TreeNode node : treeNodeModel.getNode()) {
				if (node.getSchemaDataType().equals(SchemaDataType.RECORD)) {
					fields.add(createRecord(node));
				} else {
					// handles the case of schemaDataType.ARRAY
					fields.add(createArray(node));
				}
			}
		}
		if (!treeNodeModel.getElement().isEmpty()) {
			for (Element element : treeNodeModel.getElement()) {
				/*
				 * SchemaDataType can be either BOOLEAN, BYTES, DOUBLE, FLOAT,
				 * INT, LONG, STRING
				 */
				fields.add(createField(element));
			}
		}
		/*
		 * setFields() is locked after first assignment of fields. Call only
		 * once per schema
		 */
		schema.setFields(fields);

		return schema;
	}

	private Field createRecord(TreeNode node) {
		// Schema for the field
		Schema schema1 = Schema.createRecord(node.getName(), null, null, false);
		List<Field> fields1 = new ArrayList<Field>();

		if (!node.getNode().isEmpty()) {
			for (TreeNode node1 : node.getNode()) {
				if (node1.getSchemaDataType().equals(SchemaDataType.RECORD)) {
					fields1.add(createRecord(node1));
				} else {
					// handles the case of schemaDataType.ARRAY
					fields1.add(createArray(node1));
				}
			}
		}
		if (!node.getElement().isEmpty()) {
			for (Element element : node.getElement()) {
				/*
				 * SchemaDataType can be either BOOLEAN, BYTES, DOUBLE, FLOAT,
				 * INT, LONG, STRING
				 */
				fields1.add(createField(element));
			}
		}
		schema1.setFields(fields1);

		// This is added as a field for the parent RECORD
		Field field = new Field(node.getName(), schema1, null, null);
		return field;
	}

	private Field createArray(TreeNode node) {
		/*
		 * FIXME modify ecore model to define the element type for ARRAY. RECORD
		 * is set as the default element type for ARRAY. Schema for the RECORD
		 * under ARRAY
		 */
		Schema recordSchema = Schema.createRecord(node.getName(), null, null, false);
		/*
		 * FIXME Appends the suffix "Item" to identify as the RECORD under ARRAY
		 * Schema recordSchema = Schema.createRecord(node.getName() +
		 * EditorUtils.AVRO_ARRAY_ITEM_SUFFIX, null, null, false);
		 */
		List<Field> fieldsForRecord = new ArrayList<Field>();

		// check whether any records or fields exist as children
		if (!node.getNode().isEmpty() || !node.getElement().isEmpty()) {
			if (!node.getNode().isEmpty()) {
				for (TreeNode node1 : node.getNode()) {
					if (node1.getSchemaDataType().equals(SchemaDataType.RECORD)) {
						fieldsForRecord.add(createRecord(node1));
					} else {
						// handles the case of schemaDataType.ARRAY
						fieldsForRecord.add(createArray(node1));
					}
				}
			}
			if (!node.getElement().isEmpty()) {
				for (Element element : node.getElement()) {
					/*
					 * SchemaDataType can be either BOOLEAN, BYTES, DOUBLE,
					 * FLOAT, INT, LONG, STRING
					 */
					fieldsForRecord.add(createField(element));
				}
			}
		} else { // create a null array
			Schema nullSchema = Schema.create(Type.NULL);
			Schema nullArraySchema = Schema.createArray(nullSchema);
			return new Field(node.getName(), nullArraySchema, null, null);
		}

		recordSchema.setFields(fieldsForRecord);

		// Schema for ARRAY type
		Schema arraySchema = Schema.createArray(recordSchema);
		// New field including ARRAY type schema
		Field field = new Field(node.getName(), arraySchema, null, null);
		return field;
	}

	private Field createField(Element element) {
		Type fieldDatatype = null;

		switch (element.getSchemaDataType().getValue()) {

		case SchemaDataType.BOOLEAN_VALUE:
			fieldDatatype = Type.BOOLEAN;
			break;
		case SchemaDataType.BYTES_VALUE:
			fieldDatatype = Type.BYTES;
			break;
		case SchemaDataType.DOUBLE_VALUE:
			fieldDatatype = Type.DOUBLE;
			break;
		case SchemaDataType.FLOAT_VALUE:
			fieldDatatype = Type.FLOAT;
			break;
		case SchemaDataType.INT_VALUE:
			fieldDatatype = Type.INT;
			break;
		case SchemaDataType.LONG_VALUE:
			fieldDatatype = Type.LONG;
			break;
		case SchemaDataType.STRING_VALUE:
			fieldDatatype = Type.STRING;
			break;
		case SchemaDataType.NULL_VALUE:
			fieldDatatype = Type.NULL;
			break;
		// Following types are not supported yet : ENUM, FIXED, MAP, UNION
		default:
			break;

		}
		// Schema for type:field
		Schema schema1 = Schema.create(fieldDatatype);
		Field field = new Field(element.getName(), schema1, null, null);
		return field;
	}
}
