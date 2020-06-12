/*
 * Copyright (c) 2014-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;
import org.wso2.developerstudio.datamapper.impl.TreeNodeImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.Element;

public class AvroSchemaTransformer implements ISchemaTransformer {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static String ERROR_TEXT = "File cannot be found ";
	private static String ERROR_WRITING_SCHEMA_FILE = "Error writing to schema file";
	public static List<String> multipleChunk;


	@Override
	public String getSchemaContentFromFile(String path) {
        File avsc = new File(path);
        String entireFileText = null;
        try (Scanner scanner = new Scanner(avsc)) {
            entireFileText = scanner.useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
			log.error(ERROR_TEXT, e);
		}
		return entireFileText;
	}

	@Override
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel, File file) {
		// Schema of the root element
				String name = null;
				String doc = null;
				String namespace = null;
				
				if(StringUtils.isNotEmpty(treeNodeModel.getName())){
					if(treeNodeModel.getName().contains (":")){
						String[] fullName = treeNodeModel.getName().split(":");
						name = fullName[1];
						namespace = fullName[0];
					    
					}else{
						name = treeNodeModel.getName();
					}
					
				}
			
				/*if(StringUtils.isNotEmpty(treeNodeModel.getDoc())){
					doc = treeNodeModel.getDoc();
				}
				if(StringUtils.isNotEmpty(treeNodeModel.getNamespace())){
					namespace = treeNodeModel.getNamespace();
				}*/
		        
				Schema schema = Schema.createRecord(name, doc, namespace, false);
				
				/*for(String aliase : treeNodeModel.getAliases()){
					schema.addAlias(aliase);
				}*/
				List<Field> fields = new ArrayList<Field>();
				
				if (!treeNodeModel.getNode().isEmpty()) {
					for (TreeNode nodeInRoot : treeNodeModel.getNode()) {
						if (nodeInRoot.getSchemaDataType().equals(SchemaDataType.OBJECT)) {
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

				return schema.toString();
	}

	private Field createRecord(TreeNode node) {
		
		String name = null;
		String doc = null;
		String namespace = null;
		Field field = null;
		
		if(StringUtils.isNotEmpty(node.getName())){
			if(node.getName().contains (":")){
				String[] fullName = node.getName().split(":");
				name = fullName[1];
				namespace = fullName[0];
			    
			}else{
				name = node.getName();
			}			
		}
	
		/*if(StringUtils.isNotEmpty(node.getDoc())){
			doc = node.getDoc();
		}
		
		if(StringUtils.isNotEmpty(node.getNamespace())){
			namespace = node.getNamespace();
		}*/
	
		// FIXME "namespace" : "" is added when the namespace is null
		Schema schemaForRecord = Schema.createRecord(name, doc, namespace, false);
		
		/*for(String aliase : node.getAliases()){
			schemaForRecord.addAlias(aliase);
		}*/
		List<Field> fieldsforRecord = new ArrayList<Field>();

		if (!node.getNode().isEmpty()) {
			for (TreeNode nodeInRecord : node.getNode()) {
				if (nodeInRecord.getSchemaDataType().equals(SchemaDataType.OBJECT)) {
					fieldsforRecord.add(createRecord(nodeInRecord));
				} else {
					// handles the case of schemaDataType.ARRAY
					fieldsforRecord.add(createArray(nodeInRecord));
				}
			}
		}
		if (!node.getElement().isEmpty()) {
			for (Element element : node.getElement()) {
				fieldsforRecord.add(createField(element));
			}
		}
		schemaForRecord.setFields(fieldsforRecord);
		
		field = new Field(name,schemaForRecord, null, null);
	
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
		
		/*if(StringUtils.isNotEmpty(node.getDoc())){
			doc = node.getDoc();
		}
		if(StringUtils.isNotEmpty(node.getNamespace())){
			namespace = node.getNamespace();
		}*/
		
		Schema schemaForArray = Schema.createRecord(node.getName(), doc, namespace, false);
		/*
		for(String aliase : node.getAliases()){
			schemaForArray.addAlias(aliase);
		}*/
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
					if (nodeInArray.getSchemaDataType().equals(SchemaDataType.OBJECT)) {
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
		Field field = null ;
		//JsonNode defaultValueObject = null;
		//ObjectMapper mapper = new ObjectMapper();
		String order = null;
       // Order orderValue = null;
        String docValue = null;

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
        
       /* if(StringUtils.isNotEmpty(element.getDoc())){
        	docValue = element.getDoc();
        }
        
		if(StringUtils.isNotEmpty(element.getOrder())){
			order = element.getOrder();
			orderValue = Order.valueOf(order);
		}
	
		defaultValueObject = getDefaultValue(element.getDefault(), mapper);
		
		// Fixing the NullPointer Exception in Schema. 
		//FIXME handle this when order is present
		if (docValue == null && defaultValueObject == null) {
			field = new Field(element.getName(), schemaForField, null, null);
		} else if (docValue == null && defaultValueObject != null) {
			field = new Field(element.getName(), schemaForField, null, defaultValueObject);
		} else if (defaultValueObject == null && docValue != null) {
			field = new Field(element.getName(), schemaForField, docValue, null);
		} else {	
		    field = new Field(element.getName(), schemaForField, docValue,defaultValueObject);
		}*/
		
		field = new Field(element.getName(), schemaForField, null, null);
		
		/*for(String aliase : element.getAliases()){
			field.addAlias(aliase);
		}*/
		return field;
	}

	@Override
	public void updateSchemaFile(String content, File file) {
		try {
			FileUtils.writeStringToFile(file, content);
		} catch (IOException e) {
			log.error(ERROR_WRITING_SCHEMA_FILE + file.getName(), e);
			return;
		}

	}
	
	@Override
	public Tree generateTreeFromFile(String path) {
		multipleChunk = new ArrayList<String>();

		Tree root = new Tree(); // root tree for Tree data struture
		try {

			File avsc = new File(path);
			@SuppressWarnings("resource")
			String entireFileText = new Scanner(avsc).useDelimiter("\\A").next();

			Schema schm = Schema.parse(entireFileText);

			if (StringUtils.isNotEmpty(schm.getNamespace())) {
				root.setName(schm.getNamespace() + ":" + schm.getName());
			} else {
				root.setName(schm.getName());
			}
			root.setSchemaType(schm.getType());
			root.setDoc(schm.getDoc());
			root.setAliases(schm.getAliases());

			List<Field> fieldsList = schm.getFields();

			for (Field field : fieldsList)
				fetchToTree(field, root, multipleChunk);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return root;
	}

	private static void fetchToTree(Field field, Tree parent, List<String> multipleChunk) {

		Type fieldType = field.schema().getType();
		if (fieldType.toString().equalsIgnoreCase("RECORD")) {

			Tree child = new Tree(parent);

			if (StringUtils.isNotEmpty(field.schema().getNamespace())) {
				child.setName(field.schema().getNamespace() + ":" + field.name());
			} else {
				child.setName(field.name());
			}
			child.setSchemaType(fieldType);
			child.setDoc(field.schema().getDoc());
			child.setAliases(field.schema().getAliases());

			List<Field> list = field.schema().getFields();

			for (Field it : list) {
				fetchToTree(it, child, multipleChunk);
			}
			parent.getTrees().add(child);
		}

		else if (fieldType.getName().equalsIgnoreCase("ARRAY")) {

			Schema arraySchema = field.schema().getElementType();
			Tree childParent = new Tree(parent);
			// when array type is null we assign array name to treenode and move
			// to its sibling treenode creation
			if (arraySchema.getType().getName().equalsIgnoreCase("null")) {
				childParent.setName(field.name()); // employee
				childParent.setSchemaType(fieldType);
				parent.getTrees().add(childParent);
			} else {
				List<Field> fieldList = arraySchema.getFields();
				childParent.setName(arraySchema.getName()); // employee
				childParent.setSchemaType(fieldType);
				multipleChunk.add(arraySchema.getName());

				for (Field fieldOfField : fieldList)
					fetchToTree(fieldOfField, childParent, multipleChunk);

				parent.getTrees().add(childParent);

			}

		} else {
			org.wso2.developerstudio.datamapper.diagram.tree.model.Element elementNew = new org.wso2.developerstudio.datamapper.diagram.tree.model.Element(parent);
			elementNew.setName(field.name());
			elementNew.setSchemaType(fieldType);
			elementNew.setDoc(field.doc());
			elementNew.setOrder(field.order());
			elementNew.setDefault(field.defaultValue());
			elementNew.setAliases(field.aliases());
			parent.getElements().add(elementNew);
		}

	}

	@Override
	public TreeNode generateTree(String content, TreeNode treeNode) throws NullPointerException,
			IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSchemaContentFromModel(TreeNodeImpl treeNodeModel, File schemaFile, boolean isInput, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
