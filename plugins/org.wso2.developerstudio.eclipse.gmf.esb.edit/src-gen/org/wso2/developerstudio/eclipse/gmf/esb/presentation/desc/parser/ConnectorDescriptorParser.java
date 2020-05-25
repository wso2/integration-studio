package org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser;

public class ConnectorDescriptorParser {
    
    public static ConnectorRoot parse(String jsonString) {
        return new ConnectorRoot();
    }
    
    public static ConnectorRoot demoValue() {
        ConnectorRoot connectorRoot = new ConnectorRoot();
        connectorRoot.setConnectorName("email");
        
        return connectorRoot;
    }

}
