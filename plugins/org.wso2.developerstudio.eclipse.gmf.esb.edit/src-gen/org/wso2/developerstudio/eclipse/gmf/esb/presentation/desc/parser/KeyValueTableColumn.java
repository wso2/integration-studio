package org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser;

import java.util.ArrayList;
import java.util.List;

public class KeyValueTableColumn {

    public String name;
    public String type;
    public List<String> allowedValues;

    public KeyValueTableColumn() {
        super();
        this.allowedValues =  new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<String> allowedValues) {
        this.allowedValues = allowedValues;
    }

    public void addAllowedValues(String allowedValue) {
         this.allowedValues.add(allowedValue);
    }

}
