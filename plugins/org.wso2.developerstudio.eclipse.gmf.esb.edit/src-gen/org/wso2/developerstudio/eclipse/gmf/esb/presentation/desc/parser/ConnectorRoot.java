package org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser;

import java.util.ArrayList;

public class ConnectorRoot {

    private String connectorName;
    private String connectionName;
    private String displayName;
    private String help;
    private ArrayList<Element> elements;

    public ConnectorRoot() {
        super();
        setElements(new ArrayList<Element>());
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    private void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }

    public void removeElement(Element element) {
        this.elements.add(element);
    }

}
