package org.wso2.developerstudio.datamapper.diagram.tree.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.avro.Schema.Field.Order;
import org.apache.avro.Schema.Type;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;

public class Element {

	private String name;
	private String value;
	//private List<Attribute> attributes;
	private Tree parent;
	private int count;
	private Type schemaType;
	private String doc;
	private Set<String> aliases;
	private Order order;
	private JsonNode defaultValue;

	
	public  Element(Tree parent) {
		this.parent=parent;
		count=parent.getCount()+1;
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
	
	public void setOrder(Order order){
		this.order = order;
	}

	public void setDefault(JsonNode jsonNode){
		this.defaultValue = jsonNode;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDoc(){
		return this.doc;
	}
	
	public Order getOrder() {
		return this.order;
	}
	
	public JsonNode getDefault() {
		return this.defaultValue;
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
	
	
	public void setDoc(String doc) {
		this.doc=doc;
	}
	
	
//	public void setAttribute(List<Attribute> attr){
//		this.attributes=attr;
//	}
//	
//	public List<Attribute> getAttribute(){
//		if(attributes == null){
//			attributes = new ArrayList<Attribute>();
//		}
//		return this.attributes;
//	}
	
	public Set<String> getAliases() {
		return this.aliases;
	}
	/**
	 * @return the schemaType
	 */
	public Type getSchemaType() {
		return schemaType;
	}

	/**
	 * @param schemaType the schemaType to set
	 */
	public void setSchemaType(Type schemaType) {
		this.schemaType = schemaType;
	}
	
	public void setAliases(Set<String> aliases) {
		this.aliases = aliases;
	}
	
	public String toString() {
		if (StringUtils.isNotBlank(name) &&
		    (schemaType != null && StringUtils.isNotBlank(schemaType.getName()))) {
			return name + ":" + schemaType.getName();
		} else if (StringUtils.isNotBlank(name)) {
			return name;
		} else {
			return "";
		}
	}
}
