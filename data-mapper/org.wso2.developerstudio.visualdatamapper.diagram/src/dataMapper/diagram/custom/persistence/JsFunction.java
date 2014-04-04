package dataMapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;


public class JsFunction {
	String functionStart;
	String functionReturn;
	private String functionEnd = "}\n";
	List<String> assignmentStatements;
	List<JsFunction> functions;
	private int indentation = 0;
	
	
	public JsFunction(int indentation){
		assignmentStatements = new ArrayList<String>();
		functions =  new ArrayList<JsFunction>();
		this.indentation = indentation;
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
