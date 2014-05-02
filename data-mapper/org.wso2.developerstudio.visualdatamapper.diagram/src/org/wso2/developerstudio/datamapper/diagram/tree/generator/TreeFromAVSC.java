package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperCreationWizardPage;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Element;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;





public class TreeFromAVSC{

	public static boolean multipleData;
	public static List<String> multipleChunk;
	


	/**
	 * @param args
	 * 
	 * read *.avro file convert into java tree view.
	 * return tree 
	 */

	@SuppressWarnings({ "static-access", "deprecation", "null" })
	public  Tree generateInputTree(){
		multipleChunk = new ArrayList<String>();
		//GenericDatumReader<GenericData> genericReader = new GenericDatumReader<GenericData>();

		//DataFileReader <GenericData> dataFileReader;
		Tree root = new Tree(); //root tree for Tree data struture
		try {

			///home/lali/old/svn/trunck/eclipse/data-mapper/org.wso2.developerstudio.datamapper.diagram/resource/inputs.avro
			String path = DataMapperCreationWizardPage.avroFilePathIn; // path for avro file selected in Create Datamapper Diagram swizard		 

			File avsc = new File(path);
			@SuppressWarnings("resource")
			String entireFileText = new Scanner(avsc).useDelimiter("\\A").next();
			 
			
			Schema schm = Schema.parse(entireFileText);
			multipleData =false;
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
		//GenericDatumReader<GenericData> genericReader = new GenericDatumReader<GenericData>();

		//DataFileReader <GenericData> dataFileReader;
		Tree root = new Tree(); //root tree for Tree data struture
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
	 * @param schema
	 *            Avro schema that is used to parse to tree
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

	private static  void fetchToTree(Field field, Tree parent, List<String>  multipleChunk) {
		Type fieldType = field.schema().getType();
		if (fieldType.toString().equalsIgnoreCase("RECORD")) {		
			
			Tree child = new Tree(parent);
			child.setName(field.name());
			child.setSchemaType(fieldType);

			List<Field> list = field.schema().getFields();
			
			for(Field it : list)
				fetchToTree(it, child, multipleChunk);

			parent.getTrees().add(child);
		}

		else if(fieldType.getName().equalsIgnoreCase("ARRAY")){
//				if (field.schema().getElementType().getType().name().toString().equalsIgnoreCase("RECORD")) {
//					if (!multipleData)
//						multipleData = true;
					
					Schema arraySchema = field.schema().getElementType();
					Tree childParent = new Tree(parent);
					List<Field> fieldList = arraySchema.getFields();
					childParent.setName(arraySchema.getName()); //employee
					childParent.setSchemaType(fieldType);
					multipleChunk.add(arraySchema.getName());
//					parent.getTrees().add(childParent);
//					Tree child = new Tree(childParent);
//					child.setName(arraySchema.getName());//employeerecord


					for (Field fieldOfField: fieldList)
						fetchToTree(fieldOfField, childParent, multipleChunk);

					parent.getTrees().add(childParent);
//				}
		}
		else{	
			Element elementNew=new Element(parent);
			elementNew.setName(field.name());
			elementNew.setSchemaType(fieldType);
			parent.getElements().add(elementNew);
		}
//		return parent;
	}

	/*
	 * for each avro field, search for nested schema.
	 * if field is nested, create tree and recursive
	 * else fetch field as a element
	 */
	private static  void fetchToTree(Field field, Tree parent) {
		Type fieldType = field.schema().getType();
		if (fieldType.toString().equalsIgnoreCase("RECORD")) {		
			
			Tree child = new Tree(parent);
			child.setName(field.name());

			List<Field> list = field.schema().getFields();
			
			for(Field it : list)
				fetchToTree(it, child);

			parent.getTrees().add(child);
		}

		else if(fieldType.getName().equalsIgnoreCase("ARRAY")){
//				if (field.schema().getElementType().getType().name().toString().equalsIgnoreCase("RECORD")) {
//					if (!multipleData)
//						multipleData = true;
					
					Schema arraySchema = field.schema().getElementType();
					Tree childParent = new Tree(parent);
					List<Field> fieldList = arraySchema.getFields();
					childParent.setName(arraySchema.getName()); //employee
					multipleChunk.add(arraySchema.getName());
//					parent.getTrees().add(childParent);
//					Tree child = new Tree(childParent);
//					child.setName(arraySchema.getName());//employeerecord


					for (Field fieldOfField: fieldList)
						fetchToTree(fieldOfField, childParent);

					parent.getTrees().add(childParent);
//				}
		}
		else{	
				Element elementNew=new Element(parent);
			elementNew.setName(field.name());
			parent.getElements().add(elementNew);
		}
//		return parent;
	}
	
/*	private  void treePrint(Tree parent){
//		System.out.println(parent.getName());
		Iterator<Tree> it = parent.getTrees().iterator();
		while(it.hasNext()){
			treePrint(it.next());
		}
		
		Iterator<Element> itElement = parent.getElements().iterator();
		while(itElement.hasNext()){
//			System.out.println(itElement.next().getName());
		}
		
		
	}*/
	
	
	
	/**
	 * @return	Method for create OutPut tree
	 * FIXME This should direct a XSD,XML 
	 */
	public Tree generateOutputTree(){
		

		//GenericDatumReader<GenericData> genericReader = new GenericDatumReader<GenericData>();

		//DataFileReader <GenericData> dataFileReader;
		Tree root = new Tree(); //root tree for Tree data struture
		try {

			
			String path = DataMapperCreationWizardPage.avroFilePathOut; // path for avro file selected in Create Datamapper Diagram swizard


			File avsc = new File(path);
			@SuppressWarnings("resource")
			String entireFileText = new Scanner(avsc).useDelimiter("\\A").next();

			 
			
			Schema schm = Schema.parse(entireFileText);
//			multipleData =false;
			root.setName(schm.getName());

			List<Field> fieldList = schm.getFields();
//			
			for(Field field : fieldList)
				fetchToTree(field, root);


		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return root;

	
	}
	


}
