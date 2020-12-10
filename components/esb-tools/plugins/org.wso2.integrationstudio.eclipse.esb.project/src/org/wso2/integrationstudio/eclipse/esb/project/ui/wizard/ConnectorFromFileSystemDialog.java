/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.integrationstudio.eclipse.esb.project.ui.wizard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/**
 * Dialog that allows to add connectors to project from the file system
 *
 */
public class ConnectorFromFileSystemDialog extends Dialog {

    private Composite compositeType;
    private Label lblTitleLabel;
    private Text txtCloudConnectorPath;

    private String cloudConnectorPath;

    private ImportCloudConnectorWizardPage wizard;

    private static final String DIALOG_TITLE = "Add File from System";

    public ConnectorFromFileSystemDialog(Shell parent, ImportCloudConnectorWizardPage wizard) {
        super(parent);
        setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.OK | SWT.APPLICATION_MODAL);
        this.wizard = wizard;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        GridLayout gd_container = new GridLayout(2, false);
        gd_container.marginLeft = 15;
        gd_container.marginBottom = 5;
        gd_container.marginHeight = 5;
        gd_container.marginRight = 15;
        container.setLayout(gd_container);

        compositeType = new Composite(container, SWT.NONE);
        GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        compositeType.setLayoutData(gd_composite_2);
        compositeType.setLayout(new GridLayout(6, false));

        lblTitleLabel = new Label(container, SWT.NONE);
        lblTitleLabel.setText("Browse from File System");
        GridData gd_titlelbl = new GridData();
        gd_titlelbl.horizontalAlignment = GridData.FILL;
        gd_titlelbl.verticalAlignment = SWT.TOP;
        gd_titlelbl.grabExcessHorizontalSpace = true;
        gd_titlelbl.grabExcessVerticalSpace = false;
        gd_titlelbl.horizontalSpan = 2;
        lblTitleLabel.setLayoutData(gd_titlelbl);

        txtCloudConnectorPath = new Text(container, SWT.BORDER);
        GridData gd_txtPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_txtPath.widthHint = 300;
        txtCloudConnectorPath.setLayoutData(gd_txtPath);
        txtCloudConnectorPath.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setCloudConnectorPath(txtCloudConnectorPath.getText());
                txtCloudConnectorPath.setFocus();
                int charcount = txtCloudConnectorPath.getCharCount();
                txtCloudConnectorPath.setSelection(charcount);
                validate();
            }
        });

        if (cloudConnectorPath != null) {
            txtCloudConnectorPath.setText(cloudConnectorPath);
            setCloudConnectorPath(txtCloudConnectorPath.getText());
        }

        final Button btnBrowse = new Button(container, SWT.NONE);
        btnBrowse.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                FileDialog fileDlg = new FileDialog(getShell(), SWT.MULTI);
                String fileName = fileDlg.open();

                if (fileName != null) {
                    // Store the file names in an array
                    String[] connectorPaths = fileDlg.getFileNames();
                    String displayText = "";

                    String path = fileDlg.getFilterPath() + File.separator;
                    for (int i=0; i < connectorPaths.length; i++) {
                        if (i!=0) {
                            displayText += ", " + path + connectorPaths[i];
                        } else {
                            displayText += path + connectorPaths[i]; 
                        }
                    }
                    txtCloudConnectorPath.setText(displayText);
                }
                validate();
            }
        });
        btnBrowse.setText("Browse..");
        return container;
    }

    public String getCloudConnectorPath() {
        return cloudConnectorPath;
    }

    public void setCloudConnectorPath(String cloudConnectorPath) {
        this.cloudConnectorPath = cloudConnectorPath;
    }

    private void validate() {
        if ((getCloudConnectorPath() == null || getCloudConnectorPath().equals(""))) {
            showErrorMessage("Please specify a connector path", "");
            return;
        }
    }

    private void showErrorMessage(String message, String title) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg = new MessageBox(shell, SWT.ICON_ERROR);
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                exportMsg.open();
            }
        });
    }

    @Override
    public void okPressed() {
        wizard.setCloudConnectorPath(cloudConnectorPath);
        this.close();
        wizard.getWizard().performFinish();
        wizard.getWizard().getContainer().getShell().close();
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(DIALOG_TITLE);
    }

}
