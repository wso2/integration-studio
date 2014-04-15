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
package dataMapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import dataMapper.Element;
import dataMapper.TreeNode;
import dataMapper.diagram.custom.configuration.function.Function;

public class OperatorConfigurationUtil {
	public static String oneToOneMapping(Object input) {
		return null;

	}
	public static String concatMapping(Object input) {
		return null;
	}

	public static Element getSimpleMapOutputElement(Element inputElement) {
		return inputElement.getOutNode().getOutgoingLink().get(0).getInNode()
				.getElementParent();
	}

	public static String getElementHierarchy(Element element) {
		return getSuperparentName(element.getFieldParent()) +"."+element.getName();
	}
	
	public static String getSimpleMappingStatement(Element inputElement) {
		if(isSimpleMap(inputElement)){
			return "\t" +  getElementParentName(getSimpleMapOutputElement(inputElement))+"." +  getSimpleMapOutputElement(inputElement).getName()+ " = " + inputElement.getFieldParent().getName()+ "."+ inputElement.getName()+";\n";
		}
		return null;
	}
	
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

			String function = "function map_L_"+input+"_L_"+output+"(" + input + ", " + output + "){\n";
			for(String assignment : assignments){
				function.concat(assignment).concat("\n");
			}
			return function.concat("}");
		}
		

		String function = "function map_S_"+input+"_S_"+output+"(" + input + ", " + output + "){\n";
		for(String assignment : assignments){
			function.concat(assignment).concat("\n");
		}
		return function.concat("}");
	}
	
	public static String getForLoop() {
		return null;
	}

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
	
	public static  Function isFunctionExisit(Function functionForElement,
			List<Function> functionListForTree) {
		for(Function function : functionListForTree){
			if((function.getInputParameter().getName().equals(functionForElement.getInputParameter().getName()) )&& (function.getOutputParameter().getName().equals(functionForElement.getOutputParameter().getName()))){
				return function;
			}
			
		}
		return null;
	}
	
	/**
	 * @param element input tree node child element which one to one map
	 * @return	assignment statement with arrya indexed for each in/out nodes
	 */
	public static String getSimpleArrayMappingStatement(Element element) {
		if(isSimpleMap(element)){
			return "\t" +  getElementParentName(getSimpleMapOutputElement(element))+"[i]." +  getSimpleMapOutputElement(element).getName()+ " = " + element.getFieldParent().getName()+ "[i]."+ element.getName()+";\n";
		}
		return null;
	}

}
