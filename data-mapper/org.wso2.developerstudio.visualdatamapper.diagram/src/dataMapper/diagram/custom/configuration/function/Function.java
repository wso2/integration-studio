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

package dataMapper.diagram.custom.configuration.function;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.visualdatamapper.diagram.Activator;

import dataMapper.TreeNode;

public class Function {

	private String declaration;
	private TreeNode inputParameter;
	private TreeNode outputParameter;
	private FunctionBody functionBody;
	private String returnStatement;
	private AssignmentStatement functionCall;
	private boolean single;
	private Function parentFunction;
	private boolean mainFunction;
	
	private static final String LIST_FLAG = "L";
	private static final String SINGLE_FLAG = "S";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public Function() {
		this.declaration = null;
		this.inputParameter = null;
		this.outputParameter = null;
		this.functionBody = new FunctionBody();
		this.returnStatement = null;
		this.functionCall = new AssignmentStatement();
		this.single = false;
		this.mainFunction = false;
	}

	public String getReturnStatement() {
		return returnStatement;
	}

	public void setReturnStatement(String returnStatement) {
		this.returnStatement = returnStatement;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	public TreeNode getInputParameter() {
		return inputParameter;
	}

	public void setInputParameter(TreeNode inputParameter) {
		this.inputParameter = inputParameter;
	}

	public TreeNode getOutputParameter() {
		return outputParameter;
	}

	public void setOutputParameter(TreeNode outputParameter) {
		this.outputParameter = outputParameter;
	}

	public FunctionBody getFunctionBody() {
		return functionBody;
	}

	public void setFunctionBody(FunctionBody functionBody) {
		this.functionBody = functionBody;
	}
	public AssignmentStatement getFunctionCall() {
		setFunctionCall(createFunctionCall());
		return functionCall;
	}
	private String getFlag(){
		String flag = LIST_FLAG;
		if(this.single){
			flag = SINGLE_FLAG;
		}
		return flag;
	}
	
	public void setFunctionCall(AssignmentStatement functionCall) {
		this.functionCall = functionCall;
	}
	
	private AssignmentStatement createFunctionCall(){

		
		String tempory = "map_"+getFlag()+"_" + getInputParameter().getName() + "_"+getFlag()+"_"
						+ getOutputParameter().getName() + "(" + getInputTreeHierarchy() + ", "
						+ getOutputTreeHierarchy() + ");";
		AssignmentStatement assign = new AssignmentStatement();
		assign.setStatement(tempory);
		return assign;
	}
	
	private String getOutputTreeHierarchy() {
		
		return getTreeHierarchy(this.getOutputParameter(), this.getParentFunction().getOutputParameter());
	}

	private String getInputTreeHierarchy() {

		return getTreeHierarchy(this.getInputParameter(), this.getParentFunction().getInputParameter());
	}

	private void createMainFunction() {
		try {
			String mainFunctionDeclaration = 	"\nfunction map_"+getFlag()+"_" + getInputParameter().getName() + "_"+getFlag()+"_"
												+ getOutputParameter().getName() + "(" + getInputParameter().getName() + ", "
												+ getOutputParameter().getName() + "){\n";
			
			setDeclaration(mainFunctionDeclaration);
			if(mainFunction){
				setReturnStatement("return " + getOutputParameter().getName() + ";\n" +"}\n");			
			}
			else {
				setReturnStatement("}\n");
			}
		} catch (Exception e) {
			log.error("Exception while creating function decleration", e);
		}
	}
	
	@Override
	public String toString() {
		createMainFunction();
		StringBuilder functionToString = new StringBuilder();
		try {
			functionToString.append(getDeclaration()+"\n"+getFunctionBody().toString()+"\n"+getReturnStatement());
		} catch (Exception e) {
			log.error("Exception while converting function to string", e);
		}
	return functionToString.toString();
	}

	public boolean isSingle() {
		return single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}

	public Function getParentFunction() {
		return parentFunction;
	}

	public void setParentFunction(Function parentFunction) {
		this.parentFunction = parentFunction;
	}

	private String getTreeHierarchy(TreeNode tree, TreeNode parent) {
		StringBuilder hierarchy = new StringBuilder();

		while (!(tree.equals(parent))) {
			hierarchy.insert(0,tree.getName());
			hierarchy.insert(0,".");
			tree = tree.getFieldParent();
		}

		hierarchy.insert(0,tree.getName());

		return hierarchy.toString();

	}

	public boolean isMainFunction() {
		return mainFunction;
	}

	public void setMainFunction(boolean mainFunction) {
		this.mainFunction = mainFunction;
	}
	
	
	
	
}