package dataMapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import dataMapper.Concat;
import dataMapper.DataMapperLink;
import dataMapper.Element;
import dataMapper.InNode;
import dataMapper.OutNode;
import dataMapper.TreeNode;
import dataMapper.diagram.tree.generator.TreeFromAVSC;
import dataMapper.diagram.tree.generator.TreeFromAvro;

public class DataMapperConfigurationGenerator {
	
	private static ArrayList<Integer> OPERATION_LIST = new ArrayList<Integer>();
	/*
	 * 
	 * generated NOT go through each tree ,element, attribute of InPut and find
	 * for link if link exist, find connected Output element, attribute for it
	 * get the tree list of OutPut element hirachy
	 */
	// FIXME if link connected to operator, aware of that and build relavent
	// configuration script
	public static ArrayList<String> findForAction(EList<TreeNode> eList) {

		Iterator<TreeNode> treeNodeIterator = eList.iterator();
		ArrayList<String> functionListForTree = new ArrayList<String>();
		ArrayList<String> actionList = new ArrayList<String>();
		OPERATION_LIST.clear();
		while (treeNodeIterator.hasNext()) {
			// for tree
			TreeNode eListObject = treeNodeIterator.next();
			ArrayList<String> tempList = findForAction(eListObject.getNode());
			functionListForTree.addAll(tempList);
			// actionList.addAll(tempList);

			/*
			 * get A/E , gets its outnode., check for links connected to tht
			 * node, if connected gets links Innode, get Innode connected A/E,
			 * gets A/E parent tree, get hierachical tree of tht until get
			 * Output.
			 */

			/*
			 * // for atribute Iterator<Attribute> attributeIterator =
			 * eListObject.getAttribute() .iterator(); while
			 * (attributeIterator.hasNext()) { Attribute attributeIteratorObject
			 * = attributeIterator.next(); EList<DataMapperLink>
			 * attributeLinkList = attributeIteratorObject
			 * .getOutNode().getOutgoingLink();
			 * 
			 * Iterator<DataMapperLink> mapperLinkIterator = attributeLinkList
			 * .iterator(); while (mapperLinkIterator.hasNext()) {
			 * DataMapperLink mapperLinkObject = mapperLinkIterator.next(); if
			 * (mapperLinkObject.getInNode() != null) {
			 * 
			 * // atribute -----> element if
			 * (mapperLinkObject.getInNode().getElementParent() != null) {
			 * Element outputElement = mapperLinkObject
			 * .getInNode().getElementParent();
			 * 
			 * // tree.attribute --------> tree.element String action =
			 * createActionScript(outputElement .getName().split(",")[1],
			 * attributeIteratorObject.getName() .split(",")[1]); //
			 * goUpOnOutputTree
			 * (outputElement.getFieldParent())+outputElement.getName
			 * ().split(",")[1]+"="+ //
			 * goUpOnInputTree(eListObject)+attributeIteratorObject
			 * .getName().split(",")[1]; actionList.add(action);
			 * 
			 * } // atribute -----> attribute else if
			 * (mapperLinkObject.getInNode() .getAttributeParent() != null) {
			 * Attribute outputAttribute = mapperLinkObject
			 * .getInNode().getAttributeParent();
			 * 
			 * // tree.attribute --------> tree.attribute String action =
			 * createActionScript(outputAttribute .getName().split(",")[1],
			 * attributeIteratorObject.getName() .split(",")[1]); //
			 * goUpOnOutputTree
			 * (outputAttribute.getFieldParent())+outputAttribute
			 * .getName().split(",")[1]+"="+ //
			 * goUpOnInputTree(eListObject)+attributeIteratorObject
			 * .getName().split(",")[1]; actionList.add(action); }
			 * 
			 * } }// end itrt links atribute }// end iterat attribut
			 */

			// for ELEMENT

			// boolean firstScriptLine = true;

			Iterator<Element> elementIterator = eListObject.getElement().iterator();
			while (elementIterator.hasNext()) {
				Element elementIteratorObject = elementIterator.next();
				EList<DataMapperLink> elementLinkList = elementIteratorObject.getOutNode().getOutgoingLink();
				Iterator<DataMapperLink> mapperLinkIterator = elementLinkList.iterator();

				while (mapperLinkIterator.hasNext()) {
					DataMapperLink mapperLinkObject = mapperLinkIterator.next();
					if (mapperLinkObject.getInNode() != null) {

						// element -----> element
						if (mapperLinkObject.getInNode().getElementParent() != null) {
							Element outputElement = mapperLinkObject.getInNode().getElementParent();

							// tree.element --------> tree.element

							String action = outputElement.getFieldParent().getName().split(",")[1] + ","
									+ createActionScript(outputElement.getName().split(",")[1], elementIteratorObject.getName().split(",")[1]);
							// goUpOnOutputTree(outputElement.getFieldParent())+outputElement.getName().split(",")[1]+" = "+
							// goUpOnInputTree(eListObject)+elementIteratorObject.getName().split(",")[1];
							actionList.add(action);

						}

						/*
						 * // element -----> attribute else if
						 * (mapperLinkObject.getInNode() .getAttributeParent()
						 * != null) { Attribute outputAttribute =
						 * mapperLinkObject .getInNode().getAttributeParent();
						 * 
						 * // tree.element --------> tree.attribute String
						 * action = createActionScript(
						 * outputAttribute.getName().split(",")[1],
						 * elementIteratorObject.getName().split(",")[1]);
						 * 
						 * //
						 * goUpOnOutputTree(outputAttribute.getFieldParent())+
						 * outputAttribute.getName().split(",")[1]+" = "+ //
						 * goUpOnInputTree
						 * (eListObject)+elementIteratorObject.getName
						 * ().split(",")[1]; actionList.add(action);
						 * 
						 * }
						 */

						// element --- concat -- element
						
						
						if (mapperLinkObject.getInNode().getConcatParent() != null && !OPERATION_LIST.contains(mapperLinkObject.getInNode().getConcatParent().hashCode())) {
							Concat concat = mapperLinkObject.getInNode().getConcatParent();
							OPERATION_LIST.add(concat.hashCode());
							EList<InNode> concatIn = concat.getInNode();
							EList<OutNode> concatOut = concat.getOutNode();

							String action = "";
							boolean first = true;
							for (InNode in : concatIn) {
								if (first) {
									action = " input." + in.getIncomingLink().get(0).getOutNode().getElementParent().getName().split(",")[1];
									first = false;
								} else {
									action = action + ".concat( \" \" + input."
											+ in.getIncomingLink().get(0).getOutNode().getElementParent().getName().split(",")[1]+" )";
								}

							}

							Element outputElement = concatOut.get(0).getOutgoingLink().get(0).getInNode().getElementParent();
							action = "output." + outputElement.getName().split(",")[1] + " = " + action;
							action = outputElement.getFieldParent().getName().split(",")[1] + "," + action;
							actionList.add(action);

						}

					}// end if linkobject element
				}// end itrt links element
			}// end itrt element

			// create function String

			functionListForTree.addAll(createFunctionScript(eListObject.getName().split(",")[1], actionList));
		}// tree
		return functionListForTree;
	}// findForAction

	private static String createActionScript(String output, String input) {
		return "output." + output + " = " + "input." + input;
	}

	private static ArrayList<String> createFunctionScript(String input, ArrayList<String> actionList) {
		ArrayList<String> functionList = new ArrayList<String>();
		ArrayList<String> dummyActionList = new ArrayList<String>();
		dummyActionList.addAll(actionList);
		for (String action : actionList) {
			String output = action.split(",")[0];
			ArrayList<String> tempActionList = new ArrayList<String>();

			/*
			 * for (String otherAction : dummyActionList){
			 * if(output.equalsIgnoreCase(otherAction.split(",")[0])){
			 * tempActionList.add(otherAction.split(",")[1]);
			 * dummyActionList.remove(otherAction); }
			 */
			Iterator<String> it = dummyActionList.iterator();
			while (it.hasNext()) {
				String otherAction = it.next();
				if (output.equalsIgnoreCase(otherAction.split(",")[0])) {
					tempActionList.add(otherAction.split(",")[1]);
					it.remove();
				}
			}

			if (!tempActionList.isEmpty()) {
				String allActions = "";
				for (String temp : tempActionList) {
					allActions = allActions + "\n" + temp + ";";
				}
				// FIXME function LS flag is inaccurate
				String flagLSInput = "S"; // @param for set List or Single flag
											// in configuration
//				if (!TreeFromAvro.multipleData)
//					flagLSInput = "S";
				
				if (TreeFromAVSC.multipleChunk.contains(input))
					flagLSInput = "L";

				String function = "function map_" + flagLSInput + "_" + input.toLowerCase() + "_" + flagLSInput + "_" + output.toLowerCase() + "( ) { " + allActions.toLowerCase() + " \n return output;" + " \n}";
				functionList.add(function);
			}

		}
		/*
		 * String flagLSInput = "S"; // @param for set List or Single flag in
		 * configuration if(TreeFromAvro.multipleData) flagLSInput = "L";
		 * 
		 * String function =
		 * "function map_"+flagLSInput+"_"+input.toLowerCase()+
		 * "_"+flagLSInput+"_"+output.toLowerCase()+"( "+"input"
		 * +" , "+"output"+" ){ \n "+
		 * allActions.toLowerCase()+" \n return output;"+" \n}"; return
		 * function;
		 */
		return functionList;
	}
}
