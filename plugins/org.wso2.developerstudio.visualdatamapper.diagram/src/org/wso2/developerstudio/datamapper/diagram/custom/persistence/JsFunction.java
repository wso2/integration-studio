package org.wso2.developerstudio.datamapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;


public class JsFunction {
	private String functionStart;
	private String functionReturn;
	private String functionEnd;
	private String indexer;
	private String inputObjectExpression;
	private String outputObjectExpression;
	private List<String> assignmentStatements;
	private List<JsFunction> functions;
	private int indentation = 0;
	private boolean recursive;
	
	
	public JsFunction(int indentation){
		assignmentStatements = new ArrayList<String>();
		functions =  new ArrayList<JsFunction>();
		this.indentation = indentation;
		this.functionEnd = "}\n";
		this.recursive = false;
	}
	
	public String getFunctionStart() {
		return functionStart;
	}

	public void setFunctionStart(String functionStart) {
		this.functionStart = functionStart;
	}

	public String getFunctionReturn() {
		return functionReturn;
	}

	public void setFunctionReturn(String functionReturn) {
		this.functionReturn = functionReturn;
	}

	public String getFunctionEnd() {
		return functionEnd;
	}

	public void setFunctionEnd(String functionEnd) {
		this.functionEnd = functionEnd;
	}

	public List<String> getAssignmentStatements() {
		return assignmentStatements;
	}

	public void setAssignmentStatements(List<String> assignmentStatements) {
		this.assignmentStatements = assignmentStatements;
	}

	public List<JsFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(List<JsFunction> functions) {
		this.functions = functions;
	}

	public int getIndentation() {
		return indentation;
	}

	public void setIndentation(int indentation) {
		this.indentation = indentation;
	}
	
	public boolean isRecursive() {
		return recursive;
	}

	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

	public String getIndxer() {
		return indexer;
	}

	public void setIndexer(String indexer) {
		this.indexer = indexer;
	}
	
	public String getInputObjectExpression() {
		return inputObjectExpression;
	}

	public void setInputObjectExpression(String inputObjectExpression) {
		this.inputObjectExpression = inputObjectExpression;
	}

	public String getOutputObjectExpression() {
		return outputObjectExpression;
	}

	public void setOutputObjectExpression(String outputObjectExpression) {
		this.outputObjectExpression = outputObjectExpression;
	}

	public String toString() {
		
		if (StringUtils.isEmpty(functionReturn) && assignmentStatements.isEmpty() && functions.isEmpty()) {
			return "";
		}
		
		String indentationSpace = getIndentationSpace();
		
		String full = indentationSpace + functionStart;
		full += indentationSpace + "\n";
		
		for (String statement : assignmentStatements) {
			full += indentationSpace + statement;
		}
		
		for (JsFunction function : functions) {
			full += indentationSpace + function.toString();
		} 
		//full += indentationSpace + "\n";
		if (functionReturn != null ) {
			full += "\t" + functionReturn;
		}
		full += indentationSpace + functionEnd;
		return full;
	}
	

	private String getIndentationSpace() {
		String space = "";
		for (int i=0; i< indentation; i++) {
			space += "\t";
		}
		return space;
	}
}
