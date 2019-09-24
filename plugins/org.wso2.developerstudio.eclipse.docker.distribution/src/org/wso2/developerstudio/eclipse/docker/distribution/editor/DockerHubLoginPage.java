/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.docker.distribution.editor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;

public class DockerHubLoginPage extends WizardPage {

    private static final String DIALOG_TITLE = "Docker Registry Credentials";
    private static final String SUB_DIALOG_TITLE = "Enter Docker Registry Credentials";
    private static final String EMPTY_STRING = "";
    private static final String EMAIL = "Email:";
    private static final String USERNAME = "Username:";
    private static final String PASSWORD = "Password:";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    private String dockerHubUsername = EMPTY_STRING;
    private String dockerHubEmail = EMPTY_STRING;
    private String dockerHubPassword = EMPTY_STRING;

    private Text txtEmail;
    private Text txtUsername;
    private Text txtPassword;

    protected DockerHubLoginPage(IWorkbench wb, IStructuredSelection selection) {
        super(DIALOG_TITLE);
        setTitle(SUB_DIALOG_TITLE);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData data;

        Label lblEmail = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblEmail.setLayoutData(data);
        lblEmail.setText(EMAIL);

        txtEmail = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(lblEmail, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtEmail.setLayoutData(data);

        txtEmail.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setEmailValue(txtEmail.getText());
                validate();
            }
        });

        Label lblUsername = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblEmail, 20);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblUsername.setLayoutData(data);
        lblUsername.setText(USERNAME);

        txtUsername = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblEmail, 20);
        data.left = new FormAttachment(lblUsername, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtUsername.setLayoutData(data);

        txtUsername.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setUsernameValue(txtUsername.getText());
                validate();
            }
        });

        Label lblPassword = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblUsername, 20);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblPassword.setLayoutData(data);
        lblPassword.setText(PASSWORD);

        txtPassword = new Text(container, SWT.PASSWORD | SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblUsername, 20);
        data.left = new FormAttachment(lblPassword, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtPassword.setLayoutData(data);

        txtPassword.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setPasswordValue(txtPassword.getText());
                validate();
            }
        });
        setPageComplete(false);
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getUsernameValue() == null || getUsernameValue().equals(EMPTY_STRING)) {
            setErrorMessage("Please enter the Docker registry username");
            setPageComplete(false);
            return;
        } else if (getPasswordValue() == null || getPasswordValue().equals(EMPTY_STRING)) {
            setErrorMessage("Please enter the Docker registry password");
            setPageComplete(false);
            return;
        } else if (getEmailValue() == null || getEmailValue().equals(EMPTY_STRING)) {
            setErrorMessage("Please enter the Docker registry email");
            setPageComplete(false);
            return;
        } else if (!validateEmail(getEmailValue())) {
            setErrorMessage("Please enter a valid Email address");
            setPageComplete(false);
            return;
        }

        setErrorMessage(null);
        setPageComplete(true);
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public String getUsernameValue() {
        return dockerHubUsername;
    }

    public void setUsernameValue(String username) {
        this.dockerHubUsername = username;
    }

    public String getPasswordValue() {
        return dockerHubPassword;
    }

    public void setPasswordValue(String password) {
        this.dockerHubPassword = password;
    }

    public String getEmailValue() {
        return dockerHubEmail;
    }

    public void setEmailValue(String email) {
        this.dockerHubEmail = email;
    }
}
