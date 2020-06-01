package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.HashMap;

import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;

public class ConnectorSchemaHolder {

    private static HashMap<String, ConnectorRoot> connectorSchemaMap;
    private static ConnectorSchemaHolder holder;
    
    public static ConnectorSchemaHolder getInstance() {
        if(holder == null) {
            holder = new ConnectorSchemaHolder();
            connectorSchemaMap = new HashMap<String, ConnectorRoot>();
        }
        return holder;
    }
    
    private ConnectorSchemaHolder(){}
    
    public HashMap<String, ConnectorRoot> getConnectorSchemaMap() {
        return connectorSchemaMap;
    }

    public void putConnectorSchema(String key, ConnectorRoot value) {
        connectorSchemaMap.put(key, value);
    }
    
    public ConnectorRoot getConnectorSchema(String key) {
        return connectorSchemaMap.get(key);
    }
    
    public boolean hasConnectorSchema(String key) {
        return connectorSchemaMap.containsKey(key);
    }
    

}
