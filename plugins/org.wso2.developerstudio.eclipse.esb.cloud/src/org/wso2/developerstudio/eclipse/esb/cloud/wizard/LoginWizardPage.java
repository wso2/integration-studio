/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.developerstudio.eclipse.esb.cloud.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NotFoundException;
import org.wso2.developerstudio.eclipse.esb.cloud.util.UserSessionManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Wizard page for CAR file generation.
 *
 */
public class LoginWizardPage extends WizardPage {

    private static final String DIALOG_TITLE = "WSO2 Platform Distribution - Deploy application to Integration Cloud";
    private static final String EMPTY_STRING = "";

    private Text txtUsername;
    private Text txtPassword;
    private Button btnTestCredentialsButton;

    private String username = EMPTY_STRING;
    private String password = EMPTY_STRING;
    private String initialUsername = EMPTY_STRING;
    private String initialPassword = EMPTY_STRING;
    
    IntegrationCloudServiceClient client;

    private boolean isPageDirty = false;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    protected LoginWizardPage() {
        super(DIALOG_TITLE);
        client = IntegrationCloudServiceClient.getInstance();
        setTitle(DIALOG_TITLE);
        
        // TODO: Set false
        setPageComplete(true);
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        
        GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        data.exclude = false;
        container.setLayoutData(data);

        setControl(container);
        container.setLayout(new GridLayout(3, false));
        container.setVisible(true);

        Group grpCredentials = new Group(container, SWT.NONE);
        grpCredentials.setText("Credentials");
        grpCredentials.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
        grpCredentials.setLayout(new GridLayout(2, false));

        Label lblUsername = new Label(grpCredentials, SWT.NONE);
        GridData gd_lblUsername = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_lblUsername.widthHint = 75;
        lblUsername.setLayoutData(gd_lblUsername);
        lblUsername.setText("Username");

        txtUsername = new Text(grpCredentials, SWT.BORDER);
        txtUsername.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setUsername(txtUsername.getText());
                validate();
            }
        });
        GridData gd_txtAdmin_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_txtAdmin_1.widthHint = 600;
        txtUsername.setLayoutData(gd_txtAdmin_1);

        Label lblPassword = new Label(grpCredentials, SWT.NONE);
        lblPassword.setText("Password");

        txtPassword = new Text(grpCredentials, SWT.BORDER | SWT.PASSWORD);
        txtPassword.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setPassword(txtPassword.getText());
                validate();
            }
        });
        txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        new Label(grpCredentials, SWT.NONE);

        btnTestCredentialsButton = new Button(grpCredentials, SWT.NONE);
        btnTestCredentialsButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String title = "Integration Cloud Credentials";
                try {
                    if (validateCredentials()) {
                        UserSessionManager.createSession(getUsername(), client.getCookieStore().getCookies().get(0));
                        setPageComplete(true);
                        MessageDialog.openInformation(getShell(), title, "User authentication was successful!");
                    } else {
                        MessageDialog.openError(getShell(), title, "Failed to authenticate user!");
                    }
                    
                } catch (Exception e1) {
                    MessageDialog.openError(getShell(), title, e1.getMessage());
                }
            }
        });
        GridData gd_btnTestCredentialsButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_btnTestCredentialsButton.widthHint = 100;
        btnTestCredentialsButton.setLayoutData(gd_btnTestCredentialsButton);
        btnTestCredentialsButton.setText("Login...");

    }

    private boolean validateCredentials() {
        
        try {
            return (client.login(getUsername(), getPassword()));
        } catch (NotFoundException e) {
            System.out.println("Not found");
        }
        return false;
    }

    private void validate() {
        if ((getUsername() == null || getUsername().equals(EMPTY_STRING)) || getPassword() == null
                || getPassword().equals(EMPTY_STRING)) {
            setErrorMessage("Please enter credentials.");
            setPageComplete(false);
            return;
        }

        setPageDirtyState();
        setErrorMessage(null);
    }

    private void setPageDirtyState() {
        if (getUsername().equals(initialUsername) && getPassword().equals(initialPassword)) {
            isPageDirty = false;
        } else {
            isPageDirty = true;
        }
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public static IProject getProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
