package org.wso2.developerstudio.datamapper.diagram.tree.model;

public class Attribute {
	
	private String name;
	private String value;
	private Tree parent;
	private int count;
	private Element parentEle;
	
	public  Attribute(Tree parent) {
		this.parent=parent;
		count=parent.getCount()+1;
	}
	
	public Attribute(Element ele) {
		this.parentEle=ele;
		count=ele.getCount()+1;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public Tree getParent(){
		return this.parent;
	}
	
	public void setCount(int value){
		this.count=value;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setValue(String value) {
		this.value=value;
	}
	

}
