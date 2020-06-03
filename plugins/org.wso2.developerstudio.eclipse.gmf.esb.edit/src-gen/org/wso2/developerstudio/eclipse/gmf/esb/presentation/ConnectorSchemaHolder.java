package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.HashMap;

import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorConnectionRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorOperationRoot;

public class ConnectorSchemaHolder {

    private static HashMap<String, ConnectorConnectionRoot> connectorConnectionSchemaMap;
    private static HashMap<String, ConnectorOperationRoot> connectorOperationSchemaMap;
    private static ConnectorSchemaHolder holder;
    
    public static ConnectorSchemaHolder getInstance() {
        if(holder == null) {
            holder = new ConnectorSchemaHolder();
            connectorConnectionSchemaMap = new HashMap<String, ConnectorConnectionRoot>();
            connectorOperationSchemaMap = new HashMap<String, ConnectorOperationRoot>();
        }
        return holder;
    }
    
    private ConnectorSchemaHolder(){}
    
    public HashMap<String, ConnectorConnectionRoot> getConnectorConnectionSchemaMap() {
        return connectorConnectionSchemaMap;
    }

    public void putConnectorConnectionSchema(String key, ConnectorConnectionRoot value) {
        connectorConnectionSchemaMap.put(key, value);
    }
    
    public ConnectorConnectionRoot getConnectorConnectionSchema(String key) {
        return connectorConnectionSchemaMap.get(key);
    }
    
    public boolean hasConnectorConnectionSchema(String key) {
        return connectorConnectionSchemaMap.containsKey(key);
    }
    
    public HashMap<String, ConnectorOperationRoot> getConnectorOperationSchemaMap() {
        return connectorOperationSchemaMap;
    }

    public void putConnectorOperationSchema(String key, ConnectorOperationRoot value) {
        connectorOperationSchemaMap.put(key, value);
    }
    
    public ConnectorOperationRoot getConnectorOperationSchema(String key) {
        return connectorOperationSchemaMap.get(key);
    }
    
    public boolean hasConnectorOperationSchema(String key) {
        return connectorOperationSchemaMap.containsKey(key);
    }

}
