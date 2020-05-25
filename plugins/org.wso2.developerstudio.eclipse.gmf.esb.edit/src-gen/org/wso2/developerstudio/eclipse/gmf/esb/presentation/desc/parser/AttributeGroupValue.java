package org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser;

import java.util.ArrayList;

public class AttributeGroupValue extends Value{
    
    String groupName;
    ArrayList<Element> elements;
    
    public AttributeGroupValue() {
        super();
        setElements(new ArrayList<Element>());
    }
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    private void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
    
    public void addElement(Element element) {
       getElements().add(element);
    }

    public void removeElement(Element element) {
        getElements().remove(element);
     }
}
