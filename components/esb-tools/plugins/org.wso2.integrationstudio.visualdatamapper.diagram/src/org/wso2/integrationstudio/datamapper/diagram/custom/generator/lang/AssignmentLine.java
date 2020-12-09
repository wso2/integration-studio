package org.wso2.integrationstudio.datamapper.diagram.custom.generator.lang;

public class AssignmentLine extends LanguageLine{
	String left;
	String right;
	
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}

	public AssignmentLine(String left, String right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return String.format("%s = %s;", left, right);
	}
}