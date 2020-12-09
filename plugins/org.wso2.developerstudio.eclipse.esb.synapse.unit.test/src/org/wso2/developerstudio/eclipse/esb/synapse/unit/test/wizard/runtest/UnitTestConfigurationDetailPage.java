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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.runtest;

import java.io.File;
import java.nio.file.Paths;
import java.util.Locale;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Class responsible for creation of wizard page for mock service resource
 * headers.
 */
public class UnitTestConfigurationDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Unit Test - Run Configuration";
    private static final String WIZARD_DIALOG_TITLE = "Unit Test - Run Configuration";
    private static final String CONFIGURATION_DESCRIPTION = "Choose an option to run the unit tests";
    private static final String LOCAL_SERVER_LABLE = "Local Server Configuration";
    private static final String REMOTE_SERVER_LABLE = "Remote Server Configuration";
    private static final String SERVER_HOST = "Server Remote Host:";
    private static final String SERVER_PORT = "Server Test Port:";
    private static final String SERVER_PATH = "Executable Path:";
    private static final String BROWSE_LABEL_TEXT = "Browse";
    private static final String EMPTY_STRING = "";

    boolean isLocalServerChecked = true;
    boolean isRemoteServerChecked = false;
    private String serverPath;
    private String localServerPort = "9008";
    private String remoteServerPort = "9008";
    private String serverHosth = "127.0.0.1";

    private Text txtServerPath;
    private Text txtLocalServerPort;
    private Text txtRemoteServerPort;
    private Text txtServerHost;
    private Button findServerBtnBrowse;
    private boolean isPageDirty;

    /**
     * Class constructor.
     */
    protected UnitTestConfigurationDetailPage() {
        super(DIALOG_TITLE);
        setTitle(WIZARD_DIALOG_TITLE);
        setDescription(CONFIGURATION_DESCRIPTION);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData data;

        // Local server configuration group
        Button localServerBtn = new Button(container, SWT.RADIO);
        localServerBtn.setSelection(true);
        data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(3);
        localServerBtn.setLayoutData(data);
        localServerBtn.setText(LOCAL_SERVER_LABLE);

        localServerBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    setLocalServerChecked(true);
                    setRemoteServerChecked(false);
                    disableEnableConfigurationGroupType();
                    validate();
                }
            }
        });

        Group grpLocalServerData = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(localServerBtn, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        grpLocalServerData.setLayoutData(data);
        grpLocalServerData.setLayout(new FormLayout());

        Label lblServerPath = new Label(grpLocalServerData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(grpLocalServerData, 10);
        data.left = new FormAttachment(3);
        data.width = 230;
        lblServerPath.setLayoutData(data);
        lblServerPath.setText(SERVER_PATH);

        txtServerPath = new Text(grpLocalServerData, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
        data = new FormData();
        data.top = new FormAttachment(grpLocalServerData, 10);
        data.left = new FormAttachment(lblServerPath, 0);
        data.width = 350;
        data.height = 19;
        txtServerPath.setLayoutData(data);
        txtServerPath.setText(getLocalServerDefaultPath());
        txtServerPath.setSelection(txtServerPath.getText().length());
        setServerPath(txtServerPath.getText());

        txtServerPath.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServerPath(txtServerPath.getText());
                validate();
            }
        });

        findServerBtnBrowse = new Button(grpLocalServerData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(grpLocalServerData, 7);
        data.left = new FormAttachment(txtServerPath, 2);
        data.right = new FormAttachment(97);
        findServerBtnBrowse.setLayoutData(data);
        findServerBtnBrowse.setText(BROWSE_LABEL_TEXT);

        findServerBtnBrowse.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                FileDialog fileDlg = new FileDialog(getShell());
                String[] filterExt = { "*.sh;*.SH;*.bat;*.BAT" };
                fileDlg.setFilterExtensions(filterExt);
                String importFile = fileDlg.open();
                if (importFile != null) {
                    txtServerPath.setText(importFile);
                }
                validate();
            }
        });

        Label lblServerPort = new Label(grpLocalServerData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblServerPath, 15);
        data.left = new FormAttachment(3);
        data.width = 230;
        lblServerPort.setLayoutData(data);
        lblServerPort.setText(SERVER_PORT);

        txtLocalServerPort = new Text(grpLocalServerData, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblServerPath, 15);
        data.left = new FormAttachment(lblServerPort, 0);
        data.bottom = new FormAttachment(90);
        data.right = new FormAttachment(97);
        txtLocalServerPort.setLayoutData(data);
        txtLocalServerPort.setText(getLocalServerPort());

        txtLocalServerPort.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setLocalServerPort(txtLocalServerPort.getText());
                validate();
            }
        });

        // Remote server configuration group
        Button remoteServerBtn = new Button(container, SWT.RADIO);
        data = new FormData();
        data.top = new FormAttachment(grpLocalServerData, 15);
        data.left = new FormAttachment(3);
        remoteServerBtn.setLayoutData(data);
        remoteServerBtn.setText(REMOTE_SERVER_LABLE);

        remoteServerBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    setLocalServerChecked(false);
                    setRemoteServerChecked(true);
                    disableEnableConfigurationGroupType();
                    validate();
                }
            }
        });

        Group grpRemoteServerData = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(remoteServerBtn, 5);
        data.left = new FormAttachment(1);
        data.bottom = new FormAttachment(90);
        data.right = new FormAttachment(99);
        grpRemoteServerData.setLayoutData(data);
        grpRemoteServerData.setLayout(new FormLayout());

        Label lblServerHost = new Label(grpRemoteServerData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(grpRemoteServerData, 10);
        data.left = new FormAttachment(3);
        data.width = 230;
        lblServerHost.setLayoutData(data);
        lblServerHost.setText(SERVER_HOST);

        txtServerHost = new Text(grpRemoteServerData, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(grpRemoteServerData, 10);
        data.left = new FormAttachment(lblServerHost, 0);
        data.right = new FormAttachment(97);
        txtServerHost.setLayoutData(data);
        txtServerHost.setText(getServerHosth());

        txtServerHost.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setServerHosth(txtServerHost.getText());
                validate();
            }
        });

        Label lblRemoteServerPort = new Label(grpRemoteServerData, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblServerHost, 15);
        data.left = new FormAttachment(3);
        data.width = 230;
        lblRemoteServerPort.setLayoutData(data);
        lblRemoteServerPort.setText(SERVER_PORT);

        txtRemoteServerPort = new Text(grpRemoteServerData, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblServerHost, 15);
        data.left = new FormAttachment(lblRemoteServerPort, 0);
        data.bottom = new FormAttachment(90);
        data.right = new FormAttachment(97);
        txtRemoteServerPort.setLayoutData(data);
        txtRemoteServerPort.setText(getRemoteServerPort());

        txtRemoteServerPort.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setRemoteServerPort(txtRemoteServerPort.getText());
                validate();
            }
        });

        setPageComplete(false);
        disableEnableConfigurationGroupType();
        validate();
    }

    /**
     * Method of disable/enable local or remote server configuration layouts.
     */
    private void disableEnableConfigurationGroupType() {
        if (isLocalServerChecked) {
            txtServerPath.setEnabled(true);
            txtLocalServerPort.setEnabled(true);
            txtServerHost.setEnabled(false);
            txtRemoteServerPort.setEnabled(false);
            findServerBtnBrowse.setEnabled(true);
        } else {
            txtServerPath.setEnabled(false);
            txtLocalServerPort.setEnabled(false);
            txtServerHost.setEnabled(true);
            txtRemoteServerPort.setEnabled(true);
            findServerBtnBrowse.setEnabled(false);
        }
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (isLocalServerChecked() && getServerPath().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify an executable server path");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isLocalServerChecked() && getLocalServerPort().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a port for run unit test server");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isLocalServerChecked() && !getLocalServerPort().matches("-?\\d+(\\.\\d+)?")) {
            setErrorMessage("Please specify a port valid testing port");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isLocalServerChecked() && getLocalServerPort().matches("-?\\d+(\\.\\d+)?")
                && Integer.parseInt(getLocalServerPort()) > 65535) {
            setErrorMessage("Please specify a valid testing port less than or equal to 65535");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isRemoteServerChecked() && getServerHosth().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify the remote server IP address");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isRemoteServerChecked() && !isValidServerIP(getServerHosth())) {
            setErrorMessage("Please specify a valid IP address of remote server");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isRemoteServerChecked() && getRemoteServerPort().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a valid valid testing port");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isRemoteServerChecked() && !getRemoteServerPort().matches("-?\\d+(\\.\\d+)?")) {
            setErrorMessage("Please specify a port valid testing port");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (isRemoteServerChecked() && getRemoteServerPort().matches("-?\\d+(\\.\\d+)?")
                && Integer.parseInt(getRemoteServerPort()) > 65535) {
            setErrorMessage("Please specify a valid testing port less than or equal to 65535");
            setPageComplete(false);
            setPageDirty(true);
            return;
        }

        setPageDirty(false);
        setErrorMessage(null);
        setPageComplete(true);
    }

    private String getLocalServerDefaultPath() {

        String microesbPath = "runtime" + File.separator + "microesb";
        // static path for DeveloperStudio for MAC when it is on Application folder
        String eiToolingHomeForMac = "/Applications/IntegrationStudio.app/Contents/Eclipse";

        String windowsPack = File.separator + "bin" + File.separator + "micro-integrator.bat";
        String LinuxMacPack = File.separator + "bin" + File.separator + "micro-integrator.sh";

        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if (OS.indexOf("windows") >= 0) {
            java.nio.file.Path path = Paths.get("");
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + microesbPath + windowsPack;
        } else {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(eiToolingHomeForMac);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = eiToolingHomeForMac + File.separator + microesbPath + LinuxMacPack;
            } else {
                java.nio.file.Path path = Paths.get("");
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + microesbPath + LinuxMacPack;
            }
        }

        return microInteratorPath;
    }

    private boolean isValidServerIP(String ip) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(PATTERN);
    }

    public boolean isLocalServerChecked() {
        return isLocalServerChecked;
    }

    public void setLocalServerChecked(boolean isLocalServerChecked) {
        this.isLocalServerChecked = isLocalServerChecked;
    }

    public boolean isRemoteServerChecked() {
        return isRemoteServerChecked;
    }

    public void setRemoteServerChecked(boolean isRemoteServerChecked) {
        this.isRemoteServerChecked = isRemoteServerChecked;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getLocalServerPort() {
        return localServerPort;
    }

    public void setLocalServerPort(String serverPort) {
        this.localServerPort = serverPort;
    }

    public String getRemoteServerPort() {
        return remoteServerPort;
    }

    public void setRemoteServerPort(String serverPort) {
        this.remoteServerPort = serverPort;
    }

    public String getServerHosth() {
        return serverHosth;
    }

    public void setServerHosth(String serverHosth) {
        this.serverHosth = serverHosth;
    }
}
