/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorConnectionRoot;

public class ConnectionParameterWizardPage extends WizardPage {
    private static final String DIALOG_TITLE = " Connector Connection Configurations";
    private static final String DIALOG_DESCRIPTION = "Configure your connector connection configurations";

    protected ReferenceGroup connectionParameters;
    private ConnectorConnectionRoot root;
    private HashMap<String, Control> elements;
    private Map<String, String> updateConfigMap;
    private AttributeValue allowedConnectionTypes;
    private FormToolkit widgetFactory;

    protected ConnectionParameterWizardPage(FormToolkit widgetFactory, ConnectorConnectionRoot root,
            AttributeValue allowedConnectionTypes) {
        super(StringUtils.capitalize(root.getConnectionName()) + DIALOG_TITLE);
        setTitle(StringUtils.capitalize(root.getConnectionName()) + DIALOG_TITLE);
        setDescription(DIALOG_DESCRIPTION);
        this.widgetFactory = widgetFactory;
        this.root = root;
        this.allowedConnectionTypes = allowedConnectionTypes;
    }

    protected ConnectionParameterWizardPage(FormToolkit widgetFactory, ConnectorConnectionRoot root,
            Map<String, String> updateConfigMap, AttributeValue allowedConnectionTypes) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DIALOG_DESCRIPTION);
        this.widgetFactory = widgetFactory;
        this.root = root;
        this.updateConfigMap = updateConfigMap;
        this.allowedConnectionTypes = allowedConnectionTypes;
    }

    @Override
    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NO_BACKGROUND);
        GridLayout propertiesGroupLayout = new GridLayout();
        composite.setLayout(propertiesGroupLayout);
        this.connectionParameters = new ReferenceGroup(new ConnectionParameterRenderer(widgetFactory));
        elements = this.connectionParameters.createControls(composite, root, updateConfigMap, allowedConnectionTypes);
        setControl(composite);
    }

    public HashMap<String, Control> getGeneratedElements() {
        return this.elements;
    }
}
