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
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;

public class ReferenceGroup extends ReferencesTable {
    
    private FormToolkit widgetFactory;
    private Object input;
    private PropertyParameterRenderer propertyRenderer;
    

    public ReferenceGroup(String labeltoDisplay, PropertyParameterRenderer propertyRenderer) {
        super(labeltoDisplay, null);
        this.propertyRenderer = propertyRenderer;
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void createControls(Composite parent) {
        
        
        //ppo.getSource();
        propertyRenderer.generate(widgetFactory, parent.getParent(), null);
        
    }
    
    @Override
    public void createControls(Composite parent, FormToolkit widgetFactory) {
        this.widgetFactory = widgetFactory;
        createControls(parent);
    }
    
    /**
     * input of viewer
     * 
     * @param input
     */
    public void setInput(Object input, HashMap<String,String> paramValues, EList parameterList) {
        this.input = input;
        propertyRenderer.fillData(paramValues, parameterList);
    }


}
