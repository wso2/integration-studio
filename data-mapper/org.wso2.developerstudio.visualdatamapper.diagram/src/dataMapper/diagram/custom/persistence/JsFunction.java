package dataMapper.diagram.custom.persistence;

import java.util.ArrayList;
import java.util.List;


public class JsFunction {
	String functionStart;
	String functionReturn;
	String functionEnd;
	List<String> assignmentStatements;
	List<JsFunction> functions;
	
	
	public JsFunction(){
		assignmentStatements = new ArrayList<String>();
		functions =  new ArrayList<JsFunction>();
	}
	
	public String getString() {
		
		String full = functionStart;
		full += "\n";
		
		for (String statement : assignmentStatements) {
			full += statement;
		}
		
		for (JsFunction function : functions) {
			full += function.getString();
		} 
		if (functionReturn != null ) {
			full += functionReturn;
		}
		full += functionEnd;
		return full;
	}
}
