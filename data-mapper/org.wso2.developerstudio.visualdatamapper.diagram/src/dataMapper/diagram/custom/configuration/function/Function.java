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

import dataMapper.TreeNode;

public class Function {

	private String declaration;
	private TreeNode inputParameter;
	private TreeNode outputParameter;
	private FunctionBody functionBody;
	private String returnStatement;

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
	
	public void createMainFunction() {
		String mainFunctionDeclaration = 	"function map_S_" + getInputParameter().getName() + "_S_"
											+ getOutputParameter().getName() + "(" + getInputParameter().getName() + ", "
											+ getOutputParameter().getName() + "){\n";
		
		setDeclaration(mainFunctionDeclaration);
		
		setReturnStatement("return " + getOutputParameter().getName() + ";\n" +"}");
		
	}
	
	@Override
	public String toString() {
		StringBuilder functionToString =  new StringBuilder(getDeclaration()+"\n"+getFunctionBody()+"\n"+getReturnStatement());
	return functionToString.toString();
	}
	
	
	
	
}