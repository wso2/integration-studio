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
import org.eclipse.emf.validation.internal.util.Log;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorConnectionRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorDescriptorParser;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorOperationRoot;
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
                            if (jsonSchemaName.endsWith(".json")) {
                                addConnectorRoot(jsonSchemaChildren[jsonSchemaIndex]);
                            }
                        }
                    }
                }
            }
        }
    }

    private void addConnectorRoot(File jsonSchemafile) {
        String content = "";
        ConnectorSchemaHolder schemaHolder = ConnectorSchemaHolder.getInstance();

        try {
            content = new String(Files.readAllBytes(Paths.get(jsonSchemafile.getAbsolutePath())));

            if (ConnectorDescriptorParser.isConnectorConnection(content)) {
                ConnectorConnectionRoot connectorConnectionRoot = ConnectorDescriptorParser
                        .parseConnectionRoot(content);
                String schemaName = connectorConnectionRoot.getConnectorName() + '-'
                        + connectorConnectionRoot.getConnectionName();
                schemaHolder.putConnectorConnectionSchema(schemaName, connectorConnectionRoot);
            } else {
                ConnectorOperationRoot connectorOperationRoot = ConnectorDescriptorParser.parseOperationRoot(content);
                String schemaName = connectorOperationRoot.getConnectorName() + '-'
                        + connectorOperationRoot.getOperationName();
                schemaHolder.putConnectorOperationSchema(schemaName, connectorOperationRoot);
            }
        } catch (IOException | JSONException e) {
            // log.error("Unable to parse the Connector UI descriptor file", e);
            e.printStackTrace();
        }
    }

}
