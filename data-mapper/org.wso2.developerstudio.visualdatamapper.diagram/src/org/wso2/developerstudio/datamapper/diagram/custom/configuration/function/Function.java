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

package org.wso2.developerstudio.datamapper.diagram.custom.configuration.function;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class Function {

	private String declaration;
	private TreeNode inputParameter;
	private TreeNode outputParameter;
	private FunctionBody functionBody;
	private String returnStatement;
	private String functionCall;
	private boolean single;
	private Function parentFunction;
	private boolean mainFunction;

	private static final String LIST_FLAG = "L";
	private static final String SINGLE_FLAG = "S";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public Function() {
		this.functionBody = new FunctionBody();
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

	public String getFunctionCall() {
		setFunctionCall(createFunctionCall());
		return functionCall;
	}

	private String getFlag() {
		String flag = LIST_FLAG;
		if (this.single) {
			flag = SINGLE_FLAG;
		}
		return flag;
	}

	public void setFunctionCall(String functionCall) {
		this.functionCall = functionCall;
	}

	private String createFunctionCall() {
		String inputSection = getInputParameter().getName();
		String outputSection = getOutputParameter().getName();
		
		String inputParameter = getInputTreeHierarchy();
		String outputParameter = getOutputTreeHierarchy();
		
		if (inputSection.equals(outputSection)) {
			outputSection = "output" + WordUtils.capitalize(outputSection);
		}
		
		/*
		 * If input parameter and output parameter names are identical,
		 * append term 'output' to the output parameter as a convention.
		 */
		if (inputParameter.equals(outputParameter)) {
			outputParameter = "output" + WordUtils.capitalize(outputParameter);
		}
		
		String functinCall = "map_" + getFlag() + "_" + inputSection + "_"
				+ getFlag() + "_" + outputSection + "(" + inputParameter
				+ ", " + outputParameter + ");";

		return functinCall;
	}

	private String getOutputTreeHierarchy() {
		return getTreeHierarchy(this.getOutputParameter(), this.getParentFunction()
				.getOutputParameter());
	}

	private String getInputTreeHierarchy() {
		return getTreeHierarchy(this.getInputParameter(), this.getParentFunction()
				.getInputParameter());
	}

	private void createMainFunction() {
		try {
			String inputParameter = getInputParameter().getName();
			String outputParameter = getOutputParameter().getName();
			
			/*
			 * If input parameter and output parameter names are identical,
			 * append term 'output' to the output parameter as a convention.
			 */
			if (inputParameter.equals(outputParameter)) {
				outputParameter = "output" + WordUtils.capitalize(outputParameter);
			}
			
			String mainFunctionDeclaration = "function map_" + getFlag() + "_" + inputParameter
					+ "_" + getFlag() + "_" + outputParameter + "(" + inputParameter + ", "
					+ outputParameter + ") {";

			setDeclaration(mainFunctionDeclaration);
			
			if (mainFunction) {
				setReturnStatement("return " + getOutputParameter().getName() + ";");
			} else {
				setReturnStatement("");
			}
		} catch (Exception e) {
			log.error("Exception while creating main function decleration", e);
		}
	}

	@Override
	public String toString() {
		createMainFunction();
		StringBuilder functionBuilder = new StringBuilder();
		try {
			functionBuilder.append(System.lineSeparator());
			functionBuilder.append(getDeclaration());
			functionBuilder.append(System.lineSeparator());
			functionBuilder.append(getFunctionBody().toString());

			if (StringUtils.isNotBlank(getReturnStatement())) {
				functionBuilder.append("\t");
				functionBuilder.append(getReturnStatement());
				functionBuilder.append(System.lineSeparator());
			}

			functionBuilder.append("}");
			functionBuilder.append(System.lineSeparator());

		} catch (Exception e) {
			log.error("Exception while building function ", e);
		}
		return functionBuilder.toString();
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
			hierarchy.insert(0, tree.getName());
			hierarchy.insert(0, ".");
			tree = tree.getFieldParent();
		}

		hierarchy.insert(0, tree.getName());

		return hierarchy.toString();

	}

	public boolean isMainFunction() {
		return mainFunction;
	}

	public void setMainFunction(boolean mainFunction) {
		this.mainFunction = mainFunction;
	}

}