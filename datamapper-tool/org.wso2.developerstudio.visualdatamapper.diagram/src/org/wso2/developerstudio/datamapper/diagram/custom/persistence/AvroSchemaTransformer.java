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
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Field.Order;
import org.apache.avro.Schema.Type;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
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
		String doc = null;
		String namespace = null;
		if(StringUtils.isNotEmpty(treeNodeModel.getDoc())){
			doc = treeNodeModel.getDoc();
		}
		if(StringUtils.isNotEmpty(treeNodeModel.getNamespace())){
			namespace = treeNodeModel.getNamespace();
		}
        
		Schema schema = Schema.createRecord(treeNodeModel.getName(), doc, namespace, false);
		
		for(String aliase : treeNodeModel.getAliases()){
			schema.addAlias(aliase);
		}
		List<Field> fields = new ArrayList<Field>();

		if (!treeNodeModel.getNode().isEmpty()) {
			for (TreeNode nodeInRoot : treeNodeModel.getNode()) {
				if (nodeInRoot.getSchemaDataType().equals(SchemaDataType.RECORD)) {
					fields.add(createRecord(nodeInRoot));
				} else {
					// handles the case of schemaDataType.ARRAY
					fields.add(createArray(nodeInRoot));
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
		JsonNode defaultValue = null;
		String docValue = null;
		Order order = null;
		String doc = null;
		String namespace = null;
		Field field = null;
		
		if(StringUtils.isNotEmpty(node.getDoc())){
			doc = node.getDoc();
		}
		if(StringUtils.isNotEmpty(node.getNamespace())){
			namespace = node.getNamespace();
		}
		
		// Schema for the field
		Schema schemaForRecord = Schema.createRecord(node.getName(), doc, namespace, false);
		
		for(String aliase : node.getAliases()){
			schemaForRecord.addAlias(aliase);
		}
		List<Field> fieldsforRecord = new ArrayList<Field>();

		if (!node.getNode().isEmpty()) {
			for (TreeNode nodeInRecord : node.getNode()) {
				if (nodeInRecord.getSchemaDataType().equals(SchemaDataType.RECORD)) {
					fieldsforRecord.add(createRecord(nodeInRecord));
				} else {
					// handles the case of schemaDataType.ARRAY
					fieldsforRecord.add(createArray(nodeInRecord));
				}
			}
		}
		if (!node.getElement().isEmpty()) {
			for (Element element : node.getElement()) {
		
				Field createdField = createField(element);
				if(createdField.defaultValue() != null ){
					defaultValue = createdField.defaultValue();
				}
				if(StringUtils.isNotEmpty(createdField.doc())){
					docValue = createdField.doc();
				}
				if(createdField.order() != null){
					order = createdField.order();
				}
				fieldsforRecord.add(createdField);	
			}
		}
		schemaForRecord.setFields(fieldsforRecord);
		
		//Fixing the NullPointer Exception in Schema
		if(docValue == null && defaultValue == null){
			field = new Field(node.getName(),schemaForRecord, null, null);

		}else{
			field = new Field(node.getName(), schemaForRecord, docValue,defaultValue, order);
		}
		return field;
	}

	private Field createArray(TreeNode node) {
		/*
		 * FIXME modify ecore model to define the element type for ARRAY. RECORD
		 * is set as the default element type for ARRAY. Schema for the RECORD
		 * under ARRAY
		 */
		
		String doc = null;
		String namespace = null;
		
		if(StringUtils.isNotEmpty(node.getDoc())){
			doc = node.getDoc();
		}
		if(StringUtils.isNotEmpty(node.getNamespace())){
			namespace = node.getNamespace();
		}
		
		Schema schemaForArray = Schema.createRecord(node.getName(), doc, namespace, false);
		
		for(String aliase : node.getAliases()){
			schemaForArray.addAlias(aliase);
		}
		/*
		 * FIXME Appends the suffix "Item" to identify as the RECORD under ARRAY
		 * Schema recordSchema = Schema.createRecord(node.getName() +
		 * EditorUtils.AVRO_ARRAY_ITEM_SUFFIX, null, null, false);
		 */
		List<Field> fieldsForArray = new ArrayList<Field>();

		// check whether any records or fields exist as children
		if (!node.getNode().isEmpty() || !node.getElement().isEmpty()) {
			if (!node.getNode().isEmpty()) {
				for (TreeNode nodeInArray : node.getNode()) {
					if (nodeInArray.getSchemaDataType().equals(SchemaDataType.RECORD)) {
						fieldsForArray.add(createRecord(nodeInArray));
					} else {
						// handles the case of schemaDataType.ARRAY
						fieldsForArray.add(createArray(nodeInArray));
					}
				}
			}
			if (!node.getElement().isEmpty()) {
				for (Element element : node.getElement()) {
					/*
					 * SchemaDataType can be either BOOLEAN, BYTES, DOUBLE,
					 * FLOAT, INT, LONG, STRING
					 */
					fieldsForArray.add(createField(element));
				}
			}
		} else { // create a null array
			Schema nullSchema = Schema.create(Type.NULL);
			Schema nullArraySchema = Schema.createArray(nullSchema);
			return new Field(node.getName(), nullArraySchema, null, null);
		}

		schemaForArray.setFields(fieldsForArray);

		// Schema for ARRAY type
		Schema arraySchema = Schema.createArray(schemaForArray);
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
		case SchemaDataType.UNION_VALUE:
			fieldDatatype = Type.STRING; //TODO fix this, may need to revisit how this types is assinged and used
			break;
		// Following types are not supported yet : ENUM, FIXED, MAP, UNION
		default:
			break;

		}
		// Schema for type:field
		Schema schemaForField = Schema.create(fieldDatatype);
		Field field = null ;
		ObjectMapper mapper = new ObjectMapper();
		String defaultValue = null;
		String order = null;
		JsonNode defaultValueNode = null;
        Order orderValue = null;
        String docValue = null;
        
        if(StringUtils.isNotEmpty(element.getDoc())){
        	docValue = element.getDoc();
        }
		
		if(StringUtils.isNotEmpty(element.getDefault())){
			defaultValue = element.getDefault();
			try {
				defaultValueNode = mapper.readTree(defaultValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isNotEmpty(element.getOrder())){
			order = element.getOrder();
			orderValue = Order.valueOf(order);
		}
		
		//Fixing the NullPointer Exception in Schema
		if(docValue == null && defaultValue == null){
			field = new Field(element.getName(),schemaForField, null, null);

		}else{
			field = new Field(element.getName(), schemaForField, docValue,defaultValueNode, orderValue);
		}
		
		for(String aliase : element.getAliases()){
			field.addAlias(aliase);
		}
		return field;
	}
}
