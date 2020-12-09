/*
 * Copyright (c) 2019 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.article.providers.ComplexEndpointWizardUtils;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureEndPointPropertiesDialog;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureEndpointsDialog;
import org.wso2.developerstudio.esb.form.editors.article.providers.EndpointTableEntry;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class FailoverEndpointFormPage extends EndpointFormPage {
    
    protected Combo endpointBuildMessage;

    protected Button failoverEP_Properties;
    protected Button failoverEP_Endpoints;
    protected Button failoverEP_Members;

    private List<EndPointProperty> endpointPropertyList;
    private List<EndpointTableEntry> endpointsList;
    private List<Endpoint> synapseEndpointList;

    private Section basicSection;
    private Section miscSection;

    public FailoverEndpointFormPage(FormEditor editor) {
        super(editor);
    }

    protected void createFormContent(IManagedForm managedForm) {
        form = managedForm.getForm();
        toolkit = managedForm.getToolkit();
        form.setText(Messages.getString("EndpointPage.sectionMainTitle"));
        form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

        GridLayout layout = new GridLayout();
        layout.marginLeft = 20;
        layout.marginRight = 20;
        layout.marginTop = 10;
        layout.numColumns = 1;
        layout.makeColumnsEqualWidth = true;

        form.getBody().setLayout(layout);
        GridData formGridData = new GridData();
        formGridData.horizontalSpan = 6;
        formGridData.grabExcessHorizontalSpace = true;
        form.setLayoutData(formGridData);

        createFailoverFormBasicSection();
        createFailoverFormMiscSection();

        form.setText(Messages.getString("FailoverEndpointPage.sectionMainTitle"));
    }

    public void createFailoverFormBasicSection() {
        basicSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.basic"));

        GridData samplegridData = new GridData();
        samplegridData.horizontalSpan = 3;
        samplegridData.horizontalAlignment = SWT.FILL;
        samplegridData.grabExcessHorizontalSpace = true;
        basicSection.setLayoutData(samplegridData);

        Composite basicSectionClient = toolkit.createComposite(basicSection);
        basicSectionClient.setLayout(new GridLayout());
        basicSection.setClient(basicSectionClient);

        toolkit.createLabel(basicSectionClient, "Name :");
        endpointName = toolkit.createText(basicSectionClient, "");
        endpointName.setBackground(new Color(null, 229, 236, 253));
        GridData endpointNameGridData = new GridData();
        endpointNameGridData.horizontalSpan = 3;
        endpointNameGridData.horizontalAlignment = GridData.FILL;
        endpointNameGridData.grabExcessHorizontalSpace = true;
        endpointName.setLayoutData(endpointNameGridData);

        endpointName.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(basicSectionClient, "Build Message :");
        endpointBuildMessage = new Combo(basicSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
        String[] buildMessageStates = { "True", "False" };
        endpointBuildMessage.setItems(buildMessageStates);
        GridData endpointBuildMessageGridData = new GridData();
        endpointBuildMessageGridData.horizontalSpan = 3;
        endpointBuildMessageGridData.horizontalAlignment = GridData.FILL;
        endpointBuildMessageGridData.grabExcessHorizontalSpace = true;
        endpointBuildMessage.setLayoutData(endpointBuildMessageGridData);

        endpointBuildMessage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (Boolean.parseBoolean(endpointBuildMessage.getText())) {
                    endpointBuildMessage.select(0);
                }
                setSave(true);
                updateDirtyState();
            }
        });
        
        endpointBuildMessage.addListener(SWT.MouseVerticalWheel, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.doit = false;
            }
        });

        toolkit.createLabel(basicSectionClient, "Endpoints :");

        failoverEP_Endpoints = toolkit.createButton(basicSectionClient, "Add Endpoints", SWT.PUSH);
        failoverEP_Endpoints.setBackground(new Color(null, 229, 236, 253));
        failoverEP_Endpoints.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Shell shell = Display.getDefault().getActiveShell();
                ConfigureEndpointsDialog endpointsDialog = new ConfigureEndpointsDialog(shell, endpointsList);
                endpointsDialog.setBlockOnOpen(true);
                endpointsDialog.open();
                if (endpointsDialog.isOk()) {
                    endpointsList = endpointsDialog.getEndpointsList();
                    setSave(true);
                    updateDirtyState();
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void createFailoverFormMiscSection() {

        miscSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.misc"));

        GridData miscSectionGridData = new GridData();
        miscSectionGridData.horizontalSpan = 3;
        miscSectionGridData.horizontalAlignment = GridData.FILL;
        miscSectionGridData.grabExcessHorizontalSpace = true;
        miscSection.setLayoutData(miscSectionGridData);

        Composite miscSectionClient = toolkit.createComposite(miscSection);
        miscSectionClient.setLayout(new GridLayout());
        miscSection.setClient(miscSectionClient);

        toolkit.createLabel(miscSectionClient, "Description :");
        eP_Description = toolkit.createText(miscSectionClient, "");
        eP_Description.setBackground(new Color(null, 229, 236, 253));
        GridData addressEPDescriptionGridData = new GridData();
        addressEPDescriptionGridData.horizontalSpan = 3;
        addressEPDescriptionGridData.horizontalAlignment = GridData.FILL;
        addressEPDescriptionGridData.grabExcessHorizontalSpace = true;
        eP_Description.setLayoutData(addressEPDescriptionGridData);

        eP_Description.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        toolkit.createLabel(miscSectionClient, "Properties :");

        failoverEP_Properties = toolkit.createButton(miscSectionClient, "Add Properties", SWT.PUSH);
        failoverEP_Properties.setBackground(new Color(null, 229, 236, 253));
        failoverEP_Properties.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Shell shell = Display.getDefault().getActiveShell();
                ConfigureEndPointPropertiesDialog paramDialog = new ConfigureEndPointPropertiesDialog(shell,
                        endpointPropertyList);
                paramDialog.setBlockOnOpen(true);
                paramDialog.open();
                endpointPropertyList = paramDialog.getEndpointPropertyList();

                if (paramDialog.isOk()) {
                    setSave(true);
                    updateDirtyState();
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }
        });

    }

    public Combo getEndpointBuildMessage() {
        return endpointBuildMessage;
    }

    public void setEndpointBuildMessage(Combo endpointBuildMessage) {
        this.endpointBuildMessage = endpointBuildMessage;
    }

    public List<EndpointTableEntry> getEndpointList() {
        return this.endpointsList;
    }

    public void setEndpointList(List<EndpointTableEntry> list) {
        this.endpointsList = list;
    }

    public List<EndPointProperty> getEndPointPropertyList() {
        return this.endpointPropertyList;
    }

    public void setEndPointPropertyList(List<EndPointProperty> propList) {
        this.endpointPropertyList = propList;
    }

    public Button getFailoverEP_Properties() {
        return failoverEP_Properties;
    }

    public void setFailoverEP_Properties(Button addressEP_Properties) {
        this.failoverEP_Properties = addressEP_Properties;
    }

    public List<Endpoint> getSynapseEndpointList() {
        this.synapseEndpointList = ComplexEndpointWizardUtils.getEndpointList(this.endpointsList);
        return this.synapseEndpointList;
    }
}
