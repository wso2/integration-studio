/*
 * Copyright (c) 2014- 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.security.project.ui.dialog;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.*;
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormMessageConstants;
import org.wso2.developerstudio.eclipse.security.project.utils.UserManagerUtils;

public class UserRolesDialog extends Dialog {

    private static final String COMMA_SEPARATOR = ",";

    private Text inlineUserRolesText;
    private Text serverUrlText;
    private Text userNameText;
    private Text passwordText;
    private Text roleNamePatternText;
    private Button getRolesFromServerEnableButton;
    private Button getRolesButton;
    private Table userRolesTable;

    private List<String> selectedRoles;
    private List<String> originalRoleSet;

    public UserRolesDialog(Shell parentShell, List<String> selectedRoles) {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
        this.selectedRoles = selectedRoles;

        this.originalRoleSet = new ArrayList<String>();
        this.originalRoleSet.addAll(selectedRoles);
    }

    /**
     * {@inheritDoc}
     */
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        // Set title.
        newShell.setText("User Roles");
    }

    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        FormLayout mainLayout = new FormLayout();
        mainLayout.marginHeight = 5;
        mainLayout.marginWidth = 5;
        container.setLayout(mainLayout);

        inlineUserRolesText = new Text(container, SWT.SINGLE | SWT.BORDER);
        {
            FormData inlineUserRolesTextLayoutData = new FormData(100, SWT.DEFAULT);
            inlineUserRolesTextLayoutData.top = new FormAttachment(0, 20);
            inlineUserRolesTextLayoutData.left = new FormAttachment(30);
            inlineUserRolesTextLayoutData.right = new FormAttachment(100, -5);
            inlineUserRolesText.setLayoutData(inlineUserRolesTextLayoutData);
            inlineUserRolesText.setText(getUserRolesInLine(selectedRoles));
        }

        Label inlineUserRolesLabel = new Label(container, SWT.NONE);
        {
            inlineUserRolesLabel.setText("User Roles: ");
            FormData inlineUserRolesLabelLayoutData = new FormData(20, SWT.DEFAULT);
            inlineUserRolesLabelLayoutData.top = new FormAttachment(inlineUserRolesText, 0, SWT.CENTER);
            inlineUserRolesLabelLayoutData.right = new FormAttachment(inlineUserRolesText, -5);
            inlineUserRolesLabelLayoutData.left = new FormAttachment(0);
            inlineUserRolesLabel.setLayoutData(inlineUserRolesLabelLayoutData);
        }

        getRolesFromServerEnableButton = new Button(container, SWT.CHECK);
        {
            getRolesFromServerEnableButton.setText("Get Roles from Server");
            FormData inlineRadioButtonLayoutData = new FormData();
            inlineRadioButtonLayoutData.top = new FormAttachment(inlineUserRolesLabel, 10);
            inlineRadioButtonLayoutData.left = new FormAttachment(0);
            getRolesFromServerEnableButton.setLayoutData(inlineRadioButtonLayoutData);

            getRolesFromServerEnableButton.addListener(SWT.Selection, new Listener() {
                public void handleEvent(Event event) {
                    updateServerRolesUI(getRolesFromServerEnableButton.getSelection());
                }
            });
        }

        serverUrlText = new Text(container, SWT.SINGLE | SWT.BORDER);
        {
            FormData serverUrlTextLayoutData = new FormData(100, SWT.DEFAULT);
            serverUrlTextLayoutData.top = new FormAttachment(inlineUserRolesText, 35);
            serverUrlTextLayoutData.left = new FormAttachment(inlineUserRolesText, 0, SWT.LEFT);
            serverUrlTextLayoutData.right = new FormAttachment(100, -5);
            serverUrlText.setLayoutData(serverUrlTextLayoutData);

            serverUrlText.addListener(SWT.KeyUp, new Listener() {
                public void handleEvent(Event event) {
                    validateServerInfo();
                }
            });
        }

        Label serverUrlLabel = new Label(container, SWT.NONE);
        {
            serverUrlLabel.setText("URL: ");
            FormData serverUrlLabelLayoutData = new FormData(20, SWT.DEFAULT);
            serverUrlLabelLayoutData.top = new FormAttachment(serverUrlText, 0, SWT.CENTER);
            serverUrlLabelLayoutData.right = new FormAttachment(serverUrlText, -5);
            serverUrlLabelLayoutData.left = new FormAttachment(0);
            serverUrlLabel.setLayoutData(serverUrlLabelLayoutData);
        }

        userNameText = new Text(container, SWT.SINGLE | SWT.BORDER);
        {
            FormData userNameTextLayoutData = new FormData(100, SWT.DEFAULT);
            userNameTextLayoutData.top = new FormAttachment(serverUrlText, 5);
            userNameTextLayoutData.left = new FormAttachment(serverUrlText, 0, SWT.LEFT);
            userNameTextLayoutData.right = new FormAttachment(100, -5);
            userNameText.setLayoutData(userNameTextLayoutData);

            userNameText.addListener(SWT.KeyUp, new Listener() {
                public void handleEvent(Event event) {
                    validateServerInfo();
                }
            });
        }

        Label userNameLabel = new Label(container, SWT.NONE);
        {
            userNameLabel.setText("Username: ");
            FormData userNameLabelLayoutData = new FormData(25, SWT.DEFAULT);
            userNameLabelLayoutData.top = new FormAttachment(userNameText, 0, SWT.CENTER);
            userNameLabelLayoutData.right = new FormAttachment(userNameText, -5);
            userNameLabelLayoutData.left = new FormAttachment(0);
            userNameLabel.setLayoutData(userNameLabelLayoutData);
        }

        passwordText = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
        {
            FormData passwordTextLayoutData = new FormData(100, SWT.DEFAULT);
            passwordTextLayoutData.top = new FormAttachment(userNameText, 5);
            passwordTextLayoutData.left = new FormAttachment(userNameText, 0, SWT.LEFT);
            passwordTextLayoutData.right = new FormAttachment(100, -5);
            passwordText.setLayoutData(passwordTextLayoutData);

            passwordText.addListener(SWT.KeyUp, new Listener() {
                public void handleEvent(Event event) {
                    validateServerInfo();
                }
            });
        }

        Label passwordLabel = new Label(container, SWT.None);
        {
            passwordLabel.setText("Password: ");
            FormData passwordLabelLayoutData = new FormData(25, SWT.DEFAULT);
            passwordLabelLayoutData.top = new FormAttachment(passwordText, 0, SWT.CENTER);
            passwordLabelLayoutData.right = new FormAttachment(passwordText, -5);
            passwordLabelLayoutData.left = new FormAttachment(0);
            passwordLabel.setLayoutData(passwordLabelLayoutData);
        }

        roleNamePatternText = new Text(container, SWT.SINGLE | SWT.BORDER);
        {
            FormData roleNamePatternTextLayoutData = new FormData(100, SWT.DEFAULT);
            roleNamePatternTextLayoutData.top = new FormAttachment(passwordText, 5);
            roleNamePatternTextLayoutData.left = new FormAttachment(passwordText, 0, SWT.LEFT);
            roleNamePatternTextLayoutData.right = new FormAttachment(100, -5);
            roleNamePatternText.setLayoutData(roleNamePatternTextLayoutData);
        }

        Label roleNamePatternLabel = new Label(container, SWT.NONE);
        {
            roleNamePatternLabel.setText("Role name pattern (* for all):");
            FormData roleNamePatternLabelLayoutData = new FormData(25, SWT.DEFAULT);
            roleNamePatternLabelLayoutData.top = new FormAttachment(roleNamePatternText, 0,
                    SWT.CENTER);
            roleNamePatternLabelLayoutData.right = new FormAttachment(roleNamePatternText, -5);
            roleNamePatternLabelLayoutData.left = new FormAttachment(0);
            roleNamePatternLabel.setLayoutData(roleNamePatternLabelLayoutData);
        }

        Label rolesLabel = new Label(container, SWT.NONE);
        {
            rolesLabel.setText("Roles:");
            FormData rolesLabelLayoutData = new FormData(25, SWT.DEFAULT);
            rolesLabelLayoutData.top = new FormAttachment(roleNamePatternText, 10);
            rolesLabelLayoutData.left = new FormAttachment(0);
            rolesLabelLayoutData.right = new FormAttachment(100, -5);
            rolesLabel.setLayoutData(rolesLabelLayoutData);
        }

        getRolesButton = new Button(container, SWT.NONE);
        {
            getRolesButton.setText("Get Roles");
            FormData getRolesButtonLayoutData = new FormData(80, SWT.DEFAULT);
            getRolesButtonLayoutData.top = new FormAttachment(rolesLabel, 10);
            getRolesButtonLayoutData.right = new FormAttachment(100, -5);
            getRolesButton.setLayoutData(getRolesButtonLayoutData);

            getRolesButton.addListener(SWT.Selection, new Listener() {
                public void handleEvent(Event event) {
                    listRoles();
                }
            });
        }

        userRolesTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION
                | SWT.CHECK);
        {
            TableColumn nameColumn = new TableColumn(userRolesTable, SWT.LEFT);

            nameColumn.setText("Name");
            nameColumn.setWidth(495);

            userRolesTable.setHeaderVisible(true);
            userRolesTable.setLinesVisible(true);

            FormData userRolesTableLayoutData = new FormData(500, 150);
            userRolesTableLayoutData.top = new FormAttachment(getRolesButton, 0, SWT.TOP);
            userRolesTableLayoutData.left = new FormAttachment(0);
            userRolesTableLayoutData.right = new FormAttachment(getRolesButton, -5);
            userRolesTableLayoutData.bottom = new FormAttachment(100);
            userRolesTable.setLayoutData(userRolesTableLayoutData);
        }

        {
            // Set default values.
            serverUrlText.setText("https://localhost:9443/");
            userNameText.setText("admin");
            passwordText.setText("admin");
            roleNamePatternText.setText("*");

            updateServerRolesUI(false);
        }

        return container;
    }

    @Override
    protected void okPressed() {
        String inlineUserRoles = inlineUserRolesText.getText().trim();
        selectedRoles.clear();
        if (StringUtils.isNotBlank(inlineUserRoles)) {
            String[] roles = inlineUserRoles.split(COMMA_SEPARATOR);
            for (String role : roles) {
                if (StringUtils.isNotBlank(role)) {
                    selectedRoles.add(role);
                }
            }
        }
        super.okPressed();
    }

    @Override
    protected void cancelPressed() {
        selectedRoles.clear();
        selectedRoles.addAll(originalRoleSet);
        super.cancelPressed();
    }

    private void listRoles() {
        // clear table.
        userRolesTable.removeAll();

        UserManagerUtils.getInstance().init(serverUrlText.getText().trim(),
                userNameText.getText().trim(), passwordText.getText().trim());

        String filter;
        if (StringUtils.isNotBlank(roleNamePatternText.getText())) {
            filter = roleNamePatternText.getText().trim();
        } else {
            filter = "*";
        }

        List<String> roles;
        try {
            roles = UserManagerUtils.getInstance().getRoles(filter, 1000);
        } catch (Exception e) {
            //If the server connection fails due to connectivity issues or invalid credentials, showing an error message
            MessageBox msg = new MessageBox(getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.SERVER_CONNECTION_FAILURE_MESSAGE);
            msg.open();
            return;
        }

        for (final String role : roles) {
            if (!role.equals("false")) {
                TableItem item = new TableItem(userRolesTable, SWT.RIGHT);
                item.setText(new String[]{role, role});
                if (selectedRoles.contains(role)) {
                    item.setChecked(true);
                }
            }
        }

        userRolesTable.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                updateSelectedRolesFromServer(event);
            }
        });
    }

    private void updateSelectedRolesFromServer(Event event) {
        syncInlineRolesWithSelectedRoles();
        if (event.detail == SWT.CHECK) {
            TableItem selectedRole = (TableItem) event.item;
            if (selectedRole.getChecked() && !selectedRoles.contains(selectedRole.getText(0).trim())) {
                selectedRoles.add(selectedRole.getText(0).trim());
            } else if (!selectedRole.getChecked() && selectedRoles.contains(selectedRole.getText(0).trim())) {
                selectedRoles.remove(selectedRole.getText(0).trim());
            }
            updateUserRolesInLine();
        }
    }

    private void syncInlineRolesWithSelectedRoles() {
        String inlineUserRoles = inlineUserRolesText.getText().trim();
        selectedRoles.clear();
        if (StringUtils.isNotBlank(inlineUserRoles)) {
            String[] roles = inlineUserRoles.split(COMMA_SEPARATOR);
            for (String role : roles) {
                selectedRoles.add(role.trim());
            }
        }
    }

    private void updateUserRolesInLine() {
        String rolesInLine = "";
        for (int i = 0; i < selectedRoles.size(); i++) {
            if (i == selectedRoles.size() - 1) {
                rolesInLine += selectedRoles.get(i);
            } else {
                rolesInLine += selectedRoles.get(i) + COMMA_SEPARATOR;
            }
        }
        inlineUserRolesText.setText(rolesInLine);
        inlineUserRolesText.setFocus();
    }

    private void validateServerInfo() {
        if (serverUrlText.getText().isEmpty() || userNameText.getText().isEmpty() || passwordText.getText().isEmpty()) {
            getRolesButton.setEnabled(false);
        } else {
            getRolesButton.setEnabled(true);
        }
    }

    private void updateServerRolesUI(boolean enable) {
        serverUrlText.setEnabled(enable);
        userNameText.setEnabled(enable);
        passwordText.setEnabled(enable);
        roleNamePatternText.setEnabled(enable);
        userRolesTable.setEnabled(enable);
        getRolesButton.setEnabled(enable);
    }

    /**
     * Get allow roles in role1,role2, format.
     *
     * @return roles
     */
    private String getUserRolesInLine(List<String> userRoles) {
        String allowRoles = "";

        for (int i = 0; i < userRoles.size(); i++) {
            if (i == userRoles.size() - 1) {
                allowRoles += userRoles.get(i);
            } else {
                allowRoles += userRoles.get(i) + ",";
            }
        }
        return allowRoles;
    }
}
