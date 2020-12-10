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

package org.wso2.integrationstudio.esb.form.editors.article.providers;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

public class ConfigureEndpointDialog extends WizardPage {

    private final String[] ENDPOINT_TYPES = new String[] { "INLINE", "STATIC" };

    private Combo cmbEndpointTypes;
    private Text endpointNameText;
    private Text endpointText;

    private Label endpointNameLabel;
    private Label endpointLabel;
    private EndpointTableEntry endpointTableEntry;
    private boolean isEdit = false;

    protected ConfigureEndpointDialog(String pageName) {
        super(pageName);
        setTitle("Creating an Endpoint");
        setDescription("You can either define an endpoint line, or refer it as a static value.");
    }

    protected ConfigureEndpointDialog(String pageName, EndpointTableEntry endpointTableEntry) {
        super(pageName);
        setTitle("Creating an Endpoint");
        setDescription("You can either define an endpoint line, or refer it as a static value.");

        this.isEdit = true;
        this.endpointTableEntry = endpointTableEntry;

    }

    protected ConfigureEndpointDialog(IWorkbench wb, IStructuredSelection selection) {
        super("");
    }

    @Override
    public void createControl(Composite parent) {

        parent.setLayout(new GridLayout(2, false));
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(2, false));

        Label lblEndpointType = new Label(container, SWT.NONE);
        GridData lblEndpointTypeGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblEndpointTypeGridData.widthHint = 140;
        lblEndpointType.setLayoutData(lblEndpointTypeGridData);
        lblEndpointType.setText("Endpoint Type : ");

        cmbEndpointTypes = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        cmbEndpointTypes.setItems(ENDPOINT_TYPES);
        cmbEndpointTypes.select(0);
        cmbEndpointTypes.setFocus();

        cmbEndpointTypes.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (cmbEndpointTypes.getSelectionIndex() == 0) {
                    endpointNameLabel.setVisible(false);
                    endpointNameText.setVisible(false);
                    endpointLabel.setVisible(true);
                    endpointText.setVisible(true);
                } else {
                    endpointNameLabel.setVisible(true);
                    endpointNameText.setVisible(true);
                    endpointLabel.setVisible(false);
                    endpointText.setVisible(false);
                }
            }
        });
        
        cmbEndpointTypes.addListener(SWT.MouseVerticalWheel, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.doit = false;
            }
        });

        endpointNameLabel = new Label(container, SWT.NONE);
        GridData gd_lblName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_lblName.widthHint = 140;
        endpointNameLabel.setLayoutData(gd_lblName);
        endpointNameLabel.setText("Name : ");

        endpointNameText = new Text(container, SWT.BORDER);
        GridData gd_text = new GridData(184, 20);
        endpointNameText.setLayoutData(gd_text);
        endpointNameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent evt) {

            }
        });

        endpointNameLabel.setVisible(false);
        endpointNameText.setVisible(false);

        endpointLabel = new Label(container, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
        gd.widthHint = 200;
        endpointLabel.setLayoutData(gd);
        endpointLabel.setText("Endpoint Config : ");

        endpointText = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.WRAP);
        GridData gd_endpoint = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
        gd_endpoint.widthHint = 600;
        gd_endpoint.heightHint = 300;
        endpointText.setLayoutData(gd_endpoint);
        endpointText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {

            }
        });

        if (isEdit) {
            if (endpointTableEntry.isInline()) {
                cmbEndpointTypes.select(0);
                endpointText.setText(endpointTableEntry.getEndpointValue());
                endpointText.setVisible(true);
                endpointLabel.setVisible(true);
                if (endpointNameText != null) {
                    endpointNameText.setVisible(false);
                    endpointNameLabel.setVisible(false);
                }
            } else {
                cmbEndpointTypes.select(1);
                endpointNameText.setText(endpointTableEntry.getEndpointValue());
                endpointNameText.setVisible(true);
                endpointNameLabel.setVisible(true);
                if (endpointText != null) {
                    endpointText.setVisible(false);
                    endpointLabel.setVisible(false);
                }
            }
        }

    }

    public String getEndpointType() {
        if (cmbEndpointTypes != null) {
            return cmbEndpointTypes.getText();
        } else {
            return "INLINE";
        }
    }

    public String getInlineEndpoint() {
        return this.endpointText.getText();
    }

    public String getStaticEndpoint() {
        return this.endpointNameText.getText();
    }

    public void setEndpointNameText(String name) {
        this.endpointNameText.setText(name);
    }

    public void setEndpointText(String endpoint) {
        this.endpointText.setText(endpoint);
    }

}
