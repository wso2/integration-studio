package org.wso2.developerstudio.eclipse.gmf.esb.diagram.sheet;

public class XMLTag {
	/**
	 * Tag type 
	 * 1 s <abc> 1234 
	 * 2 e </abc> 1234 
	 * 3 se <abc/> 1234 
	 * 4 s <log level="ab" 567 
	 * 5 e level="abc" /> 1234 
	 * 6 level="abc"> 1234 
	 * 7 level="abc" => no tags 2567
	 * 8 <?xml version=\"1.0\" encoding=\"UTF-8\"?> 134
	 */

	int tagType; // tag type
	String value; // string value
	int line; // line number
	int startIndex; // tag starting
	int endIndex; // tag ending
	String qName = ""; // tag qName
	boolean hasAttributes;
	boolean hasNamespace;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public boolean isHasAttributes() {
		return hasAttributes;
	}

	public int getTagType() {
		return tagType;
	}

	public void setTagType(int tagType) {
		this.tagType = tagType;
	}

	public void setHasAttributes(boolean hasAttributes) {
		this.hasAttributes = hasAttributes;
	}

	public boolean isHasNamespace() {
		return hasNamespace;
	}

	public void setHasNamespace(boolean hasNamespace) {
		this.hasNamespace = hasNamespace;
	}

	public boolean isEndTag() {
		if (this.tagType == 2 || this.tagType == 5) {
			return true;
		}
		return false;
	}

	public boolean isStartTag() {
		if (this.tagType == 1 || this.tagType == 4) {
			return true;
		}

		return false;
	}
}
