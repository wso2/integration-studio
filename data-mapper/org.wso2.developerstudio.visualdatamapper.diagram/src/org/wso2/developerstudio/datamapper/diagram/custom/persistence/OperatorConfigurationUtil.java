/*
 * Copyright 2014 WSO2, Inc. (http://wso2.com)
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

import org.apache.commons.lang.WordUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.ForLoop;
import org.wso2.developerstudio.datamapper.diagram.custom.configuration.function.Function;

public class OperatorConfigurationUtil {
	
	private static final String INDEX = "[i]";
	
	public static String oneToOneMapping(Object input) {
		return null;

	}
	
	
	public static String concatMapping(Object input) {
		return null;
	}

	/**util method for get mapped output tree element
	 * @param inputElement input tree element which is mapped
	 * @return	element
	 */
	public static Element getSimpleMapOutputElement(Element inputElement) {
		return inputElement.getOutNode().getOutgoingLink().get(0).getInNode().getElementParent();
	}
	

	/**util method for get mapped output array tree element
	 * @param inputElement input tree element which is mapped
	 * @return	element
	 */
	public static TreeNode getSimpleArrayMapOutputParent(Element inputElement) {
		Element outputElement = getSimpleMapOutputElement(inputElement);
		TreeNode outputParent = outputElement.getFieldParent();
		
		if(inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY) && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))){
			while(outputParent.getFieldParent() != null && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))){
				outputParent = outputParent.getFieldParent();
			}
		}
		
		return outputParent;
				
	}

	/**util method for get tree hierarchy to the given element 
	 * @param element which is child element of tree hierarchy
	 * @return	String which gives tree hierarchy
	 */
	public static String getElementHierarchy(Element element) {
		return getSuperparentName(element.getFieldParent()) +"."+element.getName();
	}
	
	/**util method for get one to one map assignment statement
	 * @param inputElement input tree element which is mapped
	 * @return	String one to one map assignment statement
	 */
	public static String getSimpleMappingStatement(Element inputElement) {
		if(isSimpleMap(inputElement)){
			return getElementParentName(getSimpleMapOutputElement(inputElement))+"." +  getSimpleMapOutputElement(inputElement).getName()+ " = " + inputElement.getFieldParent().getName()+ "."+ inputElement.getName()+";";
		}
		return null;
	}
	
	/**util method for check whether an element in one to one map 
	 * @param inputElement element which need to be check for map 
	 * @return	boolean is it one to one map or not
	 */
	public static boolean isSimpleMap(Element inputElement) {
		if(isMaped(inputElement)){
			if(inputElement.getOutNode().getOutgoingLink().get(0).getInNode().getElementParent() != null)
				return true;
		}
		
		return false;
	}
	
	
	public static String getElementParentName(Element element) {
		return element.getFieldParent().getName();
	}
	
	/**util method for find wheather an element is mapped
	 * @param inputElement element which need to be check for map 
	 * @return	boolean is it maped or not
	 */
	public static boolean isMaped(Element inputElement) {
		if(inputElement.getOutNode().getOutgoingLink().size() != 0)
			return true;
		return false;
	}

	
	private static String getSuperparentName(TreeNode node) {
		String paramName = "";
		if (node.getFieldParent() != null) {
			paramName = node.getName();
			while (node.getFieldParent() != null) {
				String name = node.getFieldParent().getName();
				paramName = name + "." + paramName;
				node = node.getFieldParent();
			}
		} else {
			paramName = node.getName();
		}

		return paramName;
	}
	
	public static String jsFunction(String input, String output, ArrayList<String> assignments, boolean recursive) {
		if(recursive){
			StringBuilder function = new StringBuilder();
			function.append("function map_L_").append(input).append("_L_").append(output).append("(" ).append( input ).append( ", " ).append( output ).append( "){\n");
			for(String assignment : assignments){
				function.append(assignment).append("\n");
			}
			function.append("}");
			return function.toString();
		}
		

		StringBuilder function = new StringBuilder();
		function.append("function map_S_").append(input).append("_S_").append(output).append("(" ).append( input ).append( ", " ).append( output ).append( "){\n");
		for(String assignment : assignments){
			function.append(assignment).append("\n");
		}
		function.append("}");
		return function.toString();
	}
	
	public static String getForLoop() {
		return null;
	}

	
	/**util method for find wheather  child-elements/child-tree is mapped of a tree node
	 * @param tree  node which need to be check for map 
	 * @return	boolean is it maped or not
	 */
	public static boolean isChildrenMaped(TreeNode tree) {
		for(Element element : tree.getElement()){
			if (isMaped(element)){
				return true;
			}
		}
		EList<TreeNode> trees = tree.getNode();
		for(TreeNode childTree : trees){
			if(isChildrenMaped(childTree)){
				return true;
			}
		}
		
		return false;
	}
	
	/**util method for find wheather  child-elements is mapped of a tree node
	 * @param tree  node which need to be check for map 
	 * @return	boolean is it maped or not
	 */
	public static boolean isChildrenElementMaped(TreeNode tree) {
		for(Element element : tree.getElement()){
			if (isMaped(element)){
				return true;
			}
		}
		return false;
	}
	

	public static EObject getOperatorClass(Element element) {
		return element.getOutNode().getOutgoingLink().get(0).getInNode().eContainer().eContainer().eContainer().eContainer();
	}
	
	/**util method for find whether exist faunction for a specific tree node mapping
	 * @param functionForElement  new function created
	 * @param functionListForTree all exisiting functions
	 * @return null if does not exisit, else return equal function 
	 */
	public static  Function isFunctionExist(Function functionForElement,
			List<Function> functionListForTree) {
		for(Function function : functionListForTree){
			if((function.getInputParameter().getName().equals(functionForElement.getInputParameter().getName()) )&& (function.getOutputParameter().getName().equals(functionForElement.getOutputParameter().getName()))){
				return function;
			}
			
		}
		return null;
	}
	
	/** Util method for create simple map statement with indexing
	 * @param element input tree node child element which one to one map
	 * @return	assignment statement with array indexed for each in/out nodes
	 */
	public static String getSimpleArrayMappingStatement(Element inputElement) {
		if(isSimpleMap(inputElement)){
			Element outputElement = getSimpleMapOutputElement(inputElement);
			TreeNode outputParent = outputElement.getFieldParent();
			String outputParentName = getElementParentName(getSimpleMapOutputElement(inputElement));
			String inputParentName = inputElement.getFieldParent().getName();
			
			if(inputElement.getFieldParent().getSchemaDataType().equals(SchemaDataType.ARRAY) && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))){
				while(outputParent.getFieldParent() != null && !(outputParent.getSchemaDataType().equals(SchemaDataType.ARRAY))){
					outputParent = outputParent.getFieldParent();
				}
			}
			
			/*
			 * If input parameter and output parameter names are identical,
			 * append term 'output' to the output parameter as a convention.
			 */
			if (inputParentName.equals(outputParentName)) {
				outputParentName = "output" + WordUtils.capitalize(outputParentName);
			}
			
			return getTreeHierarchy(outputElement.getFieldParent(), outputParent) + "."+  getSimpleMapOutputElement(inputElement).getName()+ " = " + inputParentName + "[i]."+ inputElement.getName() + ";";
		}
		return null;
	}
	
	/**util method for get mapped operator eObject of a element
	 * @param element  which is mapped to operator
	 * @return	eObject operator object
	 */
	public static Operator getMappingOperator(Element inputElement) {
		EObject eObject = inputElement.getOutNode().getOutgoingLink().get(0).getInNode().eContainer().eContainer().eContainer().eContainer();
		Operator opertor = (Operator) eObject;
		return opertor;
	}
	
	private static String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			hierarchy.insert(0, tree.getName());
			hierarchy.insert(0, ".");
			tree = tree.getFieldParent();
		}
		
		if(tree.getSchemaDataType().equals(SchemaDataType.ARRAY)){
			hierarchy.insert(0, (tree.getName()+INDEX));
		}
		else {
			hierarchy.insert(0, tree.getName());
		}

		return hierarchy.toString();

	}

	/**
	 * there can be multiple for loops in a function. When new assignment or function call needs to be set to a for-loop,
	 * it needs to find exist for-loop.
	 * @param loop	list of exist for loops
	 * @param parentTreeNode the array treenode of a for-loop (which would be the ID)
	 * @return	matching for-loop if exisit or null
	 */
	public static ForLoop isForLoopCreated(List<ForLoop> loop, TreeNode parentTreeNode){
		for(ForLoop eachLoop : loop){
			if(eachLoop.getArrayTree().equals(parentTreeNode)){
				return eachLoop;
			}
		}
		
		return null;
	}
	

}
