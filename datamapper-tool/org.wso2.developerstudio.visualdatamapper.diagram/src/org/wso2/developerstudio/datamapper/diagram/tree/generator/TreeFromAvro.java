package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.*;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperCreationWizardPage;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Element;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;





public class TreeFromAvro {

	public static boolean multipleData =false;


	/**
	 * @param args
	 * 
	 * read *.avro file convert into java tree view.
	 * return tree 
	 */

	public  Tree generateInputTree(){
		GenericDatumReader<GenericData> genericReader = new GenericDatumReader<GenericData>();
//		DatumReader inputDatumReader = new SpecificDatumReader(UserInfo.class);
		DataFileReader <GenericData> dataFileReader;
		Tree root = new Tree(); //root tree for Tree data struture
		try {

			///home/lali/old/svn/trunck/eclipse/data-mapper/org.wso2.developerstudio.datamapper.diagram/resource/inputs.avro
			String path = DataMapperCreationWizardPage.avroFilePathIn; // path for avro file selected in Create Datamapper Diagram swizard
			dataFileReader = new DataFileReader<GenericData>(new File(path), genericReader); 

			Schema schm = dataFileReader.getSchema();
			multipleData =false;
			root.setName(schm.getName());

			List<Field> fieldsList = dataFileReader.getSchema().getFields();
//			Iterator<Field> it = list.iterator();

			for (Field field : fieldsList)
				fetchToTree(field, root);

//			while (it.hasNext()) {
//				Field field = it.next();
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return root;

	}

	/*
	 * for each avro field, search for nested schema.
	 * if field is nested, create tree and recursive
	 * else fetch field as a element
	 */
	private static  void fetchToTree(Field field, Tree parent) {
		if (field.schema().getType().toString().equalsIgnoreCase("RECORD")) {
//			if(!multipleData)
//				multipleData = true;
//			
			
			Tree child = new Tree(parent);
			child.setName(field.name());

			List<Field> list = field.schema().getFields();
			Iterator<Field> it = list.iterator();

			while (it.hasNext()) {
				Field fieldOfField = it.next();
				fetchToTree(fieldOfField, child);
			}
			parent.getTrees().add(child);
		}

		else if(field.schema().getType().getName().equalsIgnoreCase("ARRAY")){
				if (field.schema().getElementType().getType().name().toString().equalsIgnoreCase("RECORD")) {
					if (!multipleData)
						multipleData = true;
					
					Schema arraySchema = field.schema().getElementType();
					Tree childParent = new Tree(parent);
					childParent.setName(field.name()); //employee
//					parent.getTrees().add(childParent);
//					Tree child = new Tree(childParent);
//					child.setName(arraySchema.getName());//employeerecord
					List<Field> list = arraySchema.getFields();
					Iterator<Field> it = list.iterator();

					while (it.hasNext()) {
						Field fieldOfField = it.next();
						fetchToTree(fieldOfField, childParent);
					}
					parent.getTrees().add(childParent);
				}
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
		
//		return generateInputTree();
		return TestTreeModel.generateOutputTree();
	}
	


}
