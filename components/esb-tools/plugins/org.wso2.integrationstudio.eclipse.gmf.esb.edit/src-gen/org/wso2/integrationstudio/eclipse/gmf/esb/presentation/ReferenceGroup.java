/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * 
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.presentation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.integrationstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorDescriptorParser;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;

public class ReferenceGroup extends ReferencesTable {
    
    private FormToolkit widgetFactory;
    private Object input;
    private PropertyParameterRenderer propertyRenderer;
    private String schemaName;
    private ConnectionParameterRenderer connectionRenderer;

    

    public ReferenceGroup(String labeltoDisplay, PropertyParameterRenderer propertyRenderer) {
        super(labeltoDisplay, null);
        this.propertyRenderer = propertyRenderer;
    }
    
    public ReferenceGroup(String labeltoDisplay, PropertyParameterRenderer propertyRenderer, String schemaName) {
        super(labeltoDisplay, null);
        this.propertyRenderer = propertyRenderer;
        this.schemaName = schemaName;
    }
    
    public ReferenceGroup(ConnectionParameterRenderer conenctionRenderer) {
    	super("", null);
        this.connectionRenderer = conenctionRenderer;
    }
    
    @Override
    public void createControls(Composite parent) {
        
        ConnectorRoot connectorRoot = ConnectorSchemaHolder.getInstance().getConnectorOperationSchema(getSchemaName());
        propertyRenderer.generate(widgetFactory, parent.getParent(), connectorRoot);
        
    }
    
    public HashMap<String, Control> createControls(Composite parent, ConnectorRoot root,
            Map<String, String> updateConfigMap, AttributeValue allowedConnectionTypes, String connectorName) {
        return connectionRenderer.generate(parent, root, updateConfigMap, allowedConnectionTypes, connectorName);
    }
    
    @Override
    public void createControls(Composite parent, FormToolkit widgetFactory) {
        this.widgetFactory = widgetFactory;
        createControls(parent);
    }
    
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
    
    public String getSchemaName() {
        return this.schemaName;
    }
    
    /**
     * input of viewer
     * 
     * @param input
     */
    public void setInput(Object input, EObject dataObject) {
        this.input = input;
        propertyRenderer.fillData(dataObject);
    }
}
