package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Element;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;

//import org.wso2.developerstudio.datamapper.diagram.edit.commands.ElementCreateCommand;

public class TestTreeModel {

	public static Tree generateInputTree() {
		// TODO generate tree structure from an input XSD file
		Tree tree = new Tree();
		tree.setName("Students");

		Tree innerTree = new Tree(tree);
		innerTree.setName("student");

		/*
		 * Attribute attr=new Attribute(innerTree); attr.setName("name");
		 * innerTree.getAttributes().add(attr);
		 */

		// inner tree2
		Tree tree2 = new Tree(innerTree);
		tree2.setName("Name");
		Element elementNew1 = new Element(tree2);
		elementNew1.setName("Last");
		tree2.getElements().add(elementNew1);

		Element e = new Element(tree2);
		e.setName("First");
		tree2.getElements().add(e);

		innerTree.getTrees().add(tree2);

		Element ele = new Element(innerTree);
		ele.setName("courses");
		innerTree.getElements().add(ele);

		Element ele2 = new Element(innerTree);
		ele2.setName("grades");
		innerTree.getElements().add(ele2);

		Element ele3 = new Element(innerTree);
		ele3.setName("events");
		innerTree.getElements().add(ele3);

		Element ele4 = new Element(innerTree);
		ele4.setName("try1");
		// tree.getTrees().add(innerTree);

		/*
		 * repeating
		 */

		Tree innerTree2 = new Tree(tree);
		innerTree2.setName("unknown");

		/*
		 * Attribute attr=new Attribute(innerTree); attr.setName("name");
		 * innerTree.getAttributes().add(attr);
		 */

		// inner tree2
		Tree tree22 = new Tree(innerTree2);
		tree22.setName("Name");
		Element elementNew11 = new Element(tree22);
		elementNew11.setName("Last");
		tree22.getElements().add(elementNew11);

		Element ee = new Element(tree22);
		ee.setName("First");
		tree22.getElements().add(ee);

		innerTree2.getTrees().add(tree22);

		Element elee = new Element(innerTree2);
		elee.setName("courses");
		innerTree2.getElements().add(elee);

		Element ele22 = new Element(innerTree2);
		ele22.setName("grades");
		innerTree2.getElements().add(ele22);

		Element ele33 = new Element(innerTree2);
		ele33.setName("events");
		innerTree2.getElements().add(ele33);

		Element ele44 = new Element(innerTree2);
		ele44.setName("try1");

		tree.getTrees().add(innerTree2);

		tree.getTrees().add(innerTree);

		// return tree;
		TreeFromAvro test = new TreeFromAvro();
		Tree pass = test.generateInputTree();
		return pass;
	}

	public static Tree generateOutputTree() {
		// TODO generate tree structure from an input XSD file
		Tree tree = new Tree();
		tree.setName("Students");

		Tree innerTree = new Tree(tree);
		innerTree.setName("student");
		Element attrEL = new Element(innerTree);
		attrEL.setName("name");
		innerTree.getElements().add(attrEL);

		Attribute attr2 = new Attribute(innerTree);
		attr2.setName("ID");
		innerTree.getAttributes().add(attr2);
		//
		// Element ele=new Element(innerTree);
		// ele.setName("courses");
		//
		// // Attribute att=new Attribute(ele);
		// // att.setName("cource_id");
		// // ele.getAttribute().add(att);
		//
		// innerTree.getElements().add(ele);

		Element ele2 = new Element(innerTree);
		ele2.setName("grades");
		innerTree.getElements().add(ele2);

		Element ele3 = new Element(innerTree);
		ele3.setName("contacts");
		innerTree.getElements().add(ele3);

		Element ele4 = new Element(innerTree);
		ele4.setName("try1");

		Tree tree2 = new Tree(innerTree);
		tree2.setName("subjects");
		Element e = new Element(tree2);
		e.setName("sub_name");
		tree2.getElements().add(e);
		innerTree.getTrees().add(tree2);

		/*
		 * 
		 */
		Tree tree3 = new Tree(innerTree);
		tree3.setName("address");
		Element e2 = new Element(tree3);
		e2.setName("Zip");
		tree3.getElements().add(e2);

		Element e3 = new Element(tree3);
		e3.setName("city");
		tree3.getElements().add(e3);

		Element e4 = new Element(tree3);
		e4.setName("country");
		tree3.getElements().add(e4);

		innerTree.getTrees().add(tree3);

		tree.getTrees().add(innerTree);
		// tree.getTrees().add(innerTree);
		// Tree innerTree2 = new Tree();
		// innerTree2 = innerTree.clone();
		// innerTree2.setName("student2");

		return tree;
	}

	/*
	 * private void treePrint(Tree parent){
	 * System.out.println(parent.getName()); Iterator<Tree> it =
	 * parent.getTrees().iterator(); while(it.hasNext()){ treePrint(it.next());
	 * }
	 * 
	 * Iterator<Element> itElement = parent.getElements().iterator();
	 * while(itElement.hasNext()){
	 * System.out.println(itElement.next().getName()); } }
	 */

}
