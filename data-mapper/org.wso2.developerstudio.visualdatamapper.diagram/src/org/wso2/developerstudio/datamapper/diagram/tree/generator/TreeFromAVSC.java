package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperCreationWizardPage;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Element;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;

public class TreeFromAVSC {

	public static boolean multipleData;
	public static List<String> multipleChunk;

	/**
	 * read *.avro file convert into java tree view. return tree
	 */

	@SuppressWarnings({ "static-access", "deprecation", "null" })
	public Tree generateInputTree() {
		multipleChunk = new ArrayList<String>();
		Tree root = new Tree(); // root tree for Tree data struture
		try {
			String path = DataMapperCreationWizardPage.avroFilePathIn;

			File avsc = new File(path);
			@SuppressWarnings("resource")
			String entireFileText = new Scanner(avsc).useDelimiter("\\A").next();

			Schema schm = Schema.parse(entireFileText);
			multipleData = false;
			root.setName(schm.getName());

			List<Field> fieldsList = schm.getFields();

			for (Field field : fieldsList)
				fetchToTree(field, root);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return root;

	}

	public static Tree generateInputTreeFromFile(String path) {
		multipleChunk = new ArrayList<String>();

		Tree root = new Tree(); // root tree for Tree data struture
		try {

			File avsc = new File(path);
			@SuppressWarnings("resource")
			String entireFileText = new Scanner(avsc).useDelimiter("\\A").next();

			Schema schm = Schema.parse(entireFileText);

			root.setName(schm.getName());
			root.setSchemaType(schm.getType());

			List<Field> fieldsList = schm.getFields();

			for (Field field : fieldsList)
				fetchToTree(field, root, multipleChunk);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return root;
	}

	/**
	 * @param schemaAvro schema that is used to parse to tree     
	 * @return
	 */
	public static Tree generateInputTreeFromSchema(Schema schema) {
		multipleChunk = new ArrayList<String>();

		// root node for Tree data structure
		Tree root = new Tree();
		root.setName(schema.getName());
		root.setSchemaType(schema.getType());

		List<Field> fieldsList = schema.getFields();

		for (Field field : fieldsList)
			fetchToTree(field, root, multipleChunk);

		return root;
	}

	private static void fetchToTree(Field field, Tree parent, List<String> multipleChunk) {
		Type fieldType = field.schema().getType();
		if (fieldType.toString().equalsIgnoreCase("RECORD")) {

			Tree child = new Tree(parent);
			child.setName(field.name());
			child.setSchemaType(fieldType);

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
			Element elementNew = new Element(parent);
			elementNew.setName(field.name());
			elementNew.setSchemaType(fieldType);
			parent.getElements().add(elementNew);
		}

	}

	/**
	 * for each avro field, search for nested schema. if field is nested, create
	 * tree and recursive else fetch field as a element
	 * 
	 * @param field
	 * @param parent
	 */
	private static void fetchToTree(Field field, Tree parent) {
		Type fieldType = field.schema().getType();
		if (fieldType.toString().equalsIgnoreCase("RECORD")) {

			Tree child = new Tree(parent);
			child.setName(field.name());

			List<Field> list = field.schema().getFields();

			for (Field it : list)
				fetchToTree(it, child);

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

		}

		else {
			Element elementNew = new Element(parent);
			elementNew.setName(field.name());
			parent.getElements().add(elementNew);
		}

	}

	/**
	 * @return Method for create OutPut tree FIXME This should direct a XSD,XML
	 */
	public Tree generateOutputTree() {

		Tree root = new Tree(); // root tree for Tree data struture
		try {

			String path = DataMapperCreationWizardPage.avroFilePathOut;
			File avsc = new File(path);
			@SuppressWarnings("resource")
			String entireFileText = new Scanner(avsc).useDelimiter("\\A").next();

			Schema schm = Schema.parse(entireFileText);
			root.setName(schm.getName());

			List<Field> fieldList = schm.getFields();
			//
			for (Field field : fieldList)
				fetchToTree(field, root);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return root;

	}

}
