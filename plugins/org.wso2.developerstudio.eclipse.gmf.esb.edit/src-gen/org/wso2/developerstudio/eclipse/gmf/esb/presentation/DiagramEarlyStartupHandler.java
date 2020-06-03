package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorDescriptorParser;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;

public class DiagramEarlyStartupHandler implements IStartup {

    @Override
    public void earlyStartup() {
        loadConnectorSchemas();
    }
    
    /**
     * This method removes connector palettes from editor if the connector is not in the workspace.
     * 
     * @param editorPart editor from which palettes should be removed
     * @param esbPaletteFactory PaletteFactory of the editor
     */
    private void loadConnectorSchemas() {
        String connectorDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + File.separator
                + ".metadata" + File.separator + ".Connectors";
        File directory = new File(connectorDirectory);
        ConnectorSchemaHolder schemaHolder = ConnectorSchemaHolder.getInstance();
        if (directory.isDirectory()) {
            File[] children = directory.listFiles();
            for (int childIndex = 0; childIndex < children.length; ++childIndex) {
                if (children[childIndex].isDirectory()) {
                    String jsonSchemaDirPath = children[childIndex].getAbsolutePath() + File.separator + "uischema";
                    File jsonSchemaDir = new File(jsonSchemaDirPath);
                    if (jsonSchemaDir.isDirectory()) {
                        File[] jsonSchemaChildren = jsonSchemaDir.listFiles();
                        for (int jsonSchemaIndex = 0; jsonSchemaIndex < jsonSchemaChildren.length; ++jsonSchemaIndex) {
                            String jsonSchemaName = jsonSchemaChildren[jsonSchemaIndex].getName();
                            if(jsonSchemaName.endsWith(".json")) {
                                schemaHolder.putConnectorSchema(jsonSchemaName.split(".json")[0], createConnectorRoot(jsonSchemaChildren[jsonSchemaIndex]));
//                                ConnectorRoot cr = createConnectorRoot(jsonSchemaChildren[jsonSchemaIndex]);
//                                schemaHolder.putConnectorSchema(cr.getConnectorName() + "-" + cr.getOperationName() , cr);
                            }
                        }
                    }
                }
            }
        }

        
        //rootNode.get("portDetails", String.valueOf(FunctionServerConstants.EMBEDDED_SERVER_PORT));
    }
    
    private ConnectorRoot createConnectorRoot(File jsonSchemafile) {
        String content = "";

        try {
            content = new String(Files.readAllBytes(
                    Paths.get(jsonSchemafile.getAbsolutePath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConnectorDescriptorParser cdp = new ConnectorDescriptorParser();
        ConnectorRoot connectorRoot = new ConnectorRoot();
        try {
            connectorRoot = cdp.createObject(content);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return connectorRoot;
    }

}


