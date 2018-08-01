package org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator;

public class SourceError {

	private String exception;
	private int lineNumber;
	private int startChar;
	private int endChar;

	public SourceError(String exception, int lineNumber, int startChar, int endChar) {
		this.exception = exception;
		this.lineNumber = lineNumber;
		this.startChar = startChar;
		this.endChar = endChar;
	}

	public SourceError() {

	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getStartChar() {
		return startChar;
	}

	public void setStartChar(int startChar) {
		this.startChar = startChar;
	}

	public int getEndChar() {
		return endChar;
	}

	public void setEndChar(int endChar) {
		this.endChar = endChar;
	}

}
