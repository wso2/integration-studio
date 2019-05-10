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
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.CloudDeploymentException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NetworkUnavailableException;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudDeploymentWizardConstants;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudServiceConstants;
import org.wso2.developerstudio.eclipse.esb.cloud.util.CloudDeploymentWizardUtils;
import org.wso2.developerstudio.eclipse.esb.cloud.util.UserSessionManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Wizard page for Login.
 *
 */
public class LoginWizardPage extends WizardPage {

    private static final String DIALOG_TITLE = "WSO2 Integration Cloud - Authentication";
    private static final String TITLE = "Integration Cloud Credentials";

    private static final String EMPTY_STRING = "";

    // Label Texts
    private static final String LOGIN_SUCCESSFUL_MSG = "You have been successfully logged in! Click 'Next' to continue.";
    private static final String LOGIN_FAILED_MSG = "Failed to authenticate user - Invalid credentials!";
    private static final String INTEGRATION_CLOUD_SINGUP_LINK = "https://wso2.com/integration/cloud/";
    private static final String LABEL_USERNAME_TEXT = "Email";
    private static final String LABEL_PASSWORD_TEXT = "Password";
    private static final String LABEL_TENANT_TEXT = "Organization Key";
    private static final String SIGN_UP_LABEL_TEXT = "Don't have an account? <a href=\"https://wso2.com/integration/cloud/\">Sign up</a>";

    private static final String ORG_ID_TOOLTIP_TEXT = "Organization key can be obtained from the Manage page of the WSO2 Integration Cloud.";

    // Elements
    private Text txtUsername;
    private Text txtPassword;
    private Text txtTenant;
    private Button btnLogin;
    private Label lblLoginStatus;

    // Initial values
    private String username = EMPTY_STRING;
    private String password = EMPTY_STRING;
    private String tenant = EMPTY_STRING;
    private String initialUsername = EMPTY_STRING;
    private String initialPassword = EMPTY_STRING;

    private IntegrationCloudServiceClient client;

    private boolean isPageDirty = false;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    protected LoginWizardPage() {
        super(DIALOG_TITLE);
        client = IntegrationCloudServiceClient.getInstance();
        setTitle(DIALOG_TITLE);
        setPageComplete(false);
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
        grpCredentials.setText("Enter credentials for WSO2 Integration Cloud");
        grpCredentials.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
        grpCredentials.setLayout(new GridLayout(2, false));

        // Tenant
        Label lblTenant = new Label(grpCredentials, SWT.NONE);
        GridData gd_lblTenant = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_lblTenant.widthHint = 125;
        lblTenant.setLayoutData(gd_lblTenant);
        lblTenant.setText(LABEL_TENANT_TEXT);
        txtTenant = new Text(grpCredentials, SWT.BORDER);
        txtTenant.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setTenant(txtTenant.getText());
                validate();
            }
        });

        GridData gd_txtTenant = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_txtTenant.widthHint = 550;
        txtTenant.setLayoutData(gd_txtTenant);
        txtTenant.setToolTipText(ORG_ID_TOOLTIP_TEXT);

        // Username
        Label lblUsername = new Label(grpCredentials, SWT.NONE);
        GridData gd_lblUsername = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_lblUsername.widthHint = 125;
        lblUsername.setLayoutData(gd_lblUsername);
        lblUsername.setText(LABEL_USERNAME_TEXT);

        txtUsername = new Text(grpCredentials, SWT.BORDER);
        txtUsername.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setUsername(txtUsername.getText());
                validate();
            }
        });

        GridData gd_txtUsername = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_txtUsername.widthHint = 550;
        txtUsername.setLayoutData(gd_txtUsername);

        // Password
        Label lblPassword = new Label(grpCredentials, SWT.NONE);
        lblPassword.setText(LABEL_PASSWORD_TEXT);

        txtPassword = new Text(grpCredentials, SWT.BORDER | SWT.PASSWORD);
        txtPassword.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setPassword(txtPassword.getText());
                validate();
            }
        });
        txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        new Label(grpCredentials, SWT.NONE);

        // Login button
        btnLogin = new Button(grpCredentials, SWT.NONE);
        btnLogin.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                if (validateCredentials()) {
                    UserSessionManager.createSession(getUsername(), client.getCookieStore().getCookies().get(0));
                    setPageComplete(true);
                    lblLoginStatus.setText(LOGIN_SUCCESSFUL_MSG);
                    lblLoginStatus.setForeground(CloudDeploymentWizardConstants.Colors.blue);
                    btnLogin.setEnabled(false);
                    txtTenant.setEnabled(false);
                    txtUsername.setEnabled(false);
                    txtPassword.setEnabled(false);
                    fetchRuntimeData();
                    getContainer().showPage(getNextPage());
                } else {
                    lblLoginStatus.setText(LOGIN_FAILED_MSG);
                    lblLoginStatus.setForeground(CloudDeploymentWizardConstants.Colors.red);
                }
                lblLoginStatus.getParent().layout();
            }
        });
        GridData gd_btnLogin = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_btnLogin.widthHint = 100;
        btnLogin.setLayoutData(gd_btnLogin);
        btnLogin.setText("Login");
        btnLogin.setEnabled(false);

        // To fill the grid layout
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        // Create a Link
        Link signupLink = new Link(container, SWT.NONE);
        signupLink.setText(SIGN_UP_LABEL_TEXT);
        GridData linkGridData = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        signupLink.setLayoutData(linkGridData);

        // To fill the grid layout
        new Label(container, SWT.NONE);
        new Label(container, SWT.NONE);

        // Label that shows whether the authentication was successful or not
        lblLoginStatus = new Label(container, SWT.NONE);
        FontData fontData = lblLoginStatus.getFont().getFontData()[0];
        lblLoginStatus.setFont(new Font(parent.getDisplay(), fontData.getName(), 14, fontData.getStyle()));
        GridData loginStatusGridData = new GridData(SWT.CENTER, SWT.BOTTOM, false, true, 1, 1);
        loginStatusGridData.heightHint = 200;
        lblLoginStatus.setLayoutData(loginStatusGridData);

        // Event handling when users click on link.
        signupLink.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Program.launch(INTEGRATION_CLOUD_SINGUP_LINK);
            }

        });

    }

    /**
     * Validates user credentials
     * 
     * @return
     */
    private boolean validateCredentials() {

        try {
            return (client.login(getUsername(), getPassword(), getTenant()));
        } catch (CloudDeploymentException | HttpClientException e) {
            log.error(CloudDeploymentWizardConstants.ErrorMessages.AUTHENTICATION_EXCEPTION_MESSAGE, e);
            MessageDialog.openError(getShell(), TITLE, e.getMessage());
        } catch (NetworkUnavailableException e) {
            log.error(CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE, e);
            MessageDialog.openError(getShell(), TITLE,
                    CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE);
        }
        return false;
    }

    /**
     * Validate text values
     * 
     */
    private void validate() {
        if ((getUsername() == null || getUsername().equals(EMPTY_STRING)) || getPassword() == null
                || getPassword().equals(EMPTY_STRING) || (getTenant() == null || getTenant().equals(EMPTY_STRING))) {
            setErrorMessage("Please enter credentials.");
            setPageComplete(false);
            btnLogin.setEnabled(false);
            return;
        }

        btnLogin.setEnabled(true);
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

    /**
     * Retrieves runtime data and sets it in the AppDetailsWizardPage combo
     */
    private void fetchRuntimeData() {

        IWizardPage nextPage = getWizard().getNextPage(this);
        AppDetailsWizardPage appPage = (AppDetailsWizardPage) nextPage.getNextPage();

        try {
            appPage.runtimeList = client.getApplicationRuntimes(CloudServiceConstants.AppConfigs.ESB);
            appPage.getCreateAppRuntimeCombo()
                    .setItems(CloudDeploymentWizardUtils.getRuntimeNames(appPage.runtimeList));
            appPage.selectDefaultRuntime(appPage.getCreateAppRuntimeCombo());;
            appPage.getCreateVersionRuntimeCombo()
                    .setItems(CloudDeploymentWizardUtils.getRuntimeNames(appPage.runtimeList));
            appPage.selectDefaultRuntime(appPage.getCreateVersionRuntimeCombo());

        } catch (CloudDeploymentException | InvalidTokenException | HttpClientException ex) {
            log.error(CloudDeploymentWizardConstants.ErrorMessages.RUNTIME_RETRIEVAL_FAILED_MESSAGE, ex);
            setErrorMessage(CloudDeploymentWizardConstants.ErrorMessages.RUNTIME_RETRIEVAL_FAILED_MESSAGE);
            setPageComplete(false);
        } catch (NetworkUnavailableException ex) {
            log.error(CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE, ex);
            setErrorMessage(CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE);
            setPageComplete(false);
        }

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

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

}
