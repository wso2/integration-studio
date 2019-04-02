/*
*  Copyright (c) Mar 19, 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.carbon.tools.converter.BundleGeneratorTool;
import org.xml.sax.SAXException;

public class DependencyProvider extends Dialog {

    public static final String OS_NAME = "os.name";
    public static final String SYSTEM_PROPERTY_TYPE_GENERIC = "generic";
    public static final String OS_TYPE_MAC = "mac";
    public static final String OS_TYPE_DARWIN = "darwin";
    public static final String EI_TOOLING_HOME_MACOS = "/Applications/DeveloperStudio.app/Contents/MacOS";
    public static final String EMPTY_STRING = "";

    private Shell shell;
    private Display display;
    private Combo connectiontype;
    private Combo version;
    private String groupId;
    private String artifactId;
    private Text hostText;
    private Text portText;
    private Text userNameText;
    private Text passwordText;
    private Text databaseText;
    private Text jarLocationText;
    private String eclipseWorkspace;
    private String activeProjectName;
    private String jarOutputPath;
    private String jdbcDriver;
    private String databaseConnectionPrefix;
    private String databaseURL;
    private String jdbcConnectivityJar;
    private String dependencyDir;
    private Label lblConnectionValidate;
    private Button btnDownload;
    private Button testConnectionBtn;
    private Button okBtn;
    private Button btnServer;
    private Button btnBrowse;
    private Button cancelBtn;
    private Button btnLocate;
    private GridData versionOptiongridData;
    private GridData browseOptionGridData;
    private GridData downloadInfoGridData;
    private GridLayout gridLayout;
    private GridLayout downloadInfoGridLayout;
    private GridLayout optionLayout;
    private Composite compositeMain;
    private Composite versionOptionComposite;
    private Composite downloadInfoComposite;
    private Composite browseOptionComposite;
    private FocusListener focusListener;
    private Group optionGroup;
    private boolean jarProvided;
    private ConnectionObj connectionObj;

    private ProgressMonitorDialog progressMonitorDialog;
    private ArrayList<Dependency> dependencyList;

    private String databaseArr[] = new String[] { "MYSQL", "MSSQL", "ORACLE", "POSTGRESQL" };
    private String mysqlVersionArr[] = new String[] { "Select Version", "8.0.15", "8.0.14", "5.1.47", "5.1.46" };
    private String mssqlVersionArr[] = new String[] { "Select Version", "6.4.0.jre8", "7.2.0.jre8" };
    private String postgresSqlVersionArr[] = new String[] { "Select Version", "42.2.5" };
    private String oracleVersionArr[] = new String[] { "Select Version", "10.2.0.4.0" };

    private static final String microesbLibPath = "runtime" + File.separator + "microesb" + File.separator + "lib";

    public DependencyProvider(Shell parent) {
        super(parent);
        eclipseWorkspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
        IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        if (editorPart != null) {
            IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
            IFile file = input.getFile();
            IProject activeProject = file.getProject();
            activeProjectName = activeProject.getName();
        }
        jarOutputPath = eclipseWorkspace + File.separator + activeProjectName + File.separator + "dependancies";
        dependencyDir = eclipseWorkspace + File.separator + activeProjectName + File.separator + "dependancies";
    }

    void open(ConnectionObj connectionObj) {
        this.connectionObj = connectionObj;

        display = PlatformUI.getWorkbench().getDisplay();
        shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        shell.setText("Database Configuration");
        shell.setLayout(new FillLayout());

        Color ashColor = new Color(display, 245, 245, 245);
        Color whiteColor = new Color(display, 255, 255, 255);

        Font font = new Font(display, "Arial", 8, SWT.NULL);

        FormToolkit toolkit = new FormToolkit(display);
        Form form = toolkit.createForm(shell);

        form.setBackground(ashColor);
        form.getBody().setLayout(new GridLayout());
        form.getHead().setForeground(new Color(display, 0, 0, 0));
        form.getBody().setForeground(new Color(display, 0, 0, 0));

        GridData gridData = new GridData();
        gridData.grabExcessHorizontalSpace = true;
        gridData.horizontalSpan = 8;

        gridLayout = new GridLayout(9, false);
        gridLayout.marginLeft = 5;
        gridLayout.marginRight = 5;
        gridLayout.marginBottom = 10;

        compositeMain = new Composite(form.getBody(), SWT.BORDER);
        compositeMain.setBackground(ashColor);
        compositeMain.setLayout(gridLayout);

        Label connectionLabel = new Label(compositeMain, SWT.NULL);
        connectionLabel.setText("Connection Type: *");
        gridData = new GridData();
        gridData.widthHint = 190;
        connectionLabel.setLayoutData(gridData);

        gridData = new GridData();
        gridData.widthHint = 15;

        lblConnectionValidate = new Label(compositeMain, SWT.NULL);
        lblConnectionValidate.setLayoutData(gridData);

        gridData = new GridData();
        gridData.widthHint = 250;
        gridData.horizontalIndent = -50;
        gridData.horizontalAlignment = SWT.FILL;
        gridData.horizontalSpan = 7;
        gridData.grabExcessHorizontalSpace = true;

        connectiontype = new Combo(compositeMain, SWT.READ_ONLY);
        connectiontype.setItems(new String[] { "Select Connection Type" });
        connectiontype.setText("Select Connection Type");
        connectiontype.setItems(databaseArr);
        connectiontype.setLayoutData(gridData);

        optionGroup = new Group(compositeMain, SWT.BORDER);
        optionLayout = new GridLayout(4, false);
        optionLayout.marginBottom = -40;

        gridData = new GridData();
        gridData.horizontalSpan = 9;
        gridData.widthHint = 418;

        optionGroup.setLayout(optionLayout);
        optionGroup.setText("Select driver");
        optionGroup.setLayoutData(gridData);

        gridData = new GridData();
        gridData.horizontalSpan = 2;
        gridData.widthHint = 220;
        gridData.grabExcessHorizontalSpace = false;

        btnServer = new Button(optionGroup, SWT.RADIO);
        btnServer.setText("Get from the server");
        btnServer.setLayoutData(gridData);

        gridData = new GridData();
        gridData.horizontalSpan = 2;
        gridData.widthHint = 140;
        gridData.grabExcessHorizontalSpace = true;

        btnBrowse = new Button(optionGroup, SWT.RADIO);
        btnBrowse.setText("Browse local");
        btnBrowse.setLayoutData(gridData);

        versionOptionComposite = new Composite(optionGroup, SWT.NULL);
        versionOptionComposite.setBackground(ashColor);

        versionOptiongridData = new GridData();
        versionOptiongridData.horizontalSpan = 4;

        GridLayout versionOptionLayout = new GridLayout(3, false);
        versionOptionComposite.setLayout(versionOptionLayout);
        versionOptionComposite.setLayoutData(versionOptiongridData);

        Label versionLabel = new Label(versionOptionComposite, SWT.NULL);
        versionLabel.setText("Version:");

        GridData versionComboGridData = new GridData();
        versionComboGridData.widthHint = 190;

        version = new Combo(versionOptionComposite, SWT.READ_ONLY);
        version.setItems(new String[] { "Select Version" });
        version.setLayoutData(versionComboGridData);

        btnDownload = new Button(versionOptionComposite, SWT.NULL);
        btnDownload.setText("Download Jar");

        downloadInfoComposite = new Composite(optionGroup, SWT.NULL);
        downloadInfoComposite.setBackground(ashColor);

        downloadInfoGridData = new GridData();
        downloadInfoGridLayout = new GridLayout(4, false);

        downloadInfoGridData.horizontalSpan = 4;
        downloadInfoGridLayout.marginBottom = -5;
        downloadInfoComposite.setLayoutData(downloadInfoGridData);
        downloadInfoComposite.setLayout(downloadInfoGridLayout);

        Label downloadInfoLabel = new Label(downloadInfoComposite, SWT.NULL);
        downloadInfoLabel.setText("* Selected driver is already downloaded");
        downloadInfoLabel.setFont(font);
        downloadInfoLabel.setLayoutData(downloadInfoGridData);

        downloadInfoComposite.setVisible(false);

        browseOptionComposite = new Composite(optionGroup, SWT.NULL);
        browseOptionComposite.setBackground(ashColor);

        GridLayout browseOptionGridLayout = new GridLayout(3, false);

        browseOptionGridData = new GridData();
        browseOptionGridData.horizontalSpan = 4;

        browseOptionComposite.setLayoutData(browseOptionGridData);
        browseOptionComposite.setLayout(browseOptionGridLayout);

        Label browseLabel = new Label(browseOptionComposite, SWT.NULL);
        browseLabel.setText("Browse:");

        versionComboGridData = new GridData();
        versionComboGridData.widthHint = 190;

        jarLocationText = new Text(browseOptionComposite, SWT.BORDER);
        jarLocationText.setBackground(whiteColor);
        jarLocationText.setText("");
        jarLocationText.setLayoutData(versionComboGridData);

        btnLocate = new Button(browseOptionComposite, SWT.BORDER);
        btnLocate.setText(" Browse File ");

        browseOptionComposite.setVisible(false);
        btnServer.setSelection(true);

        focusListener = new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                testConnectionBtn.setEnabled(false);
                okBtn.setEnabled(false);

                version.select(0);
                jarLocationText.setText("");

                jarProvided = false;
                userNameText.setEnabled(false);
                passwordText.setEnabled(false);
                hostText.setEnabled(false);
                portText.setEnabled(false);
                databaseText.setEnabled(false);

                gridLayout.marginBottom = 0;
                optionLayout.marginBottom = 10;

                browseOptionGridData.exclude = true;
                browseOptionComposite.setVisible(false);
                browseOptionComposite.pack();

                versionOptiongridData.exclude = false;
                versionOptionComposite.setVisible(true);
                versionOptionComposite.pack();

                downloadInfoGridData.exclude = true;
                downloadInfoComposite.setVisible(false);
                downloadInfoComposite.pack();

                shell.pack();
            }
        };

        btnBrowse.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                btnServer.setEnabled(true);
                btnServer.removeFocusListener(focusListener);
                btnServer.addFocusListener(focusListener);

                version.select(0);
                testConnectionBtn.setEnabled(false);
                okBtn.setEnabled(false);

                jarProvided = true;
                userNameText.setEnabled(false);
                passwordText.setEnabled(false);
                hostText.setEnabled(false);
                portText.setEnabled(false);
                databaseText.setEnabled(false);

                gridLayout.marginBottom = 0;
                optionLayout.marginBottom = 10;

                versionOptiongridData.exclude = true;
                versionOptionComposite.setVisible(false);
                versionOptionComposite.pack();

                browseOptionGridData.exclude = false;
                browseOptionComposite.setVisible(true);
                browseOptionComposite.pack();

                downloadInfoGridData.exclude = true;
                downloadInfoComposite.setVisible(false);
                downloadInfoComposite.pack();

                shell.pack();
            }
        });

        gridLayout = new GridLayout(1, false);
        gridLayout.marginLeft = 5;
        gridLayout.marginRight = 5;
        gridLayout.marginBottom = 0;
        Composite connectionDataComposite = new Composite(form.getBody(), SWT.BORDER);
        connectionDataComposite.setLayout(gridLayout);

        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridLayout = new GridLayout(4, false);
        gridLayout.marginBottom = 5;

        Group connectionDataGroup = new Group(connectionDataComposite, SWT.NULL);
        connectionDataGroup.setText("Connection");
        connectionDataComposite.setBackground(ashColor);
        connectionDataGroup.setLayoutData(gridData);
        connectionDataGroup.setLayout(gridLayout);

        gridData = new GridData();
        gridData.grabExcessHorizontalSpace = true;

        Label hostLabel = new Label(connectionDataGroup, SWT.NULL);
        hostLabel.setSize(50, 50);
        hostLabel.setText("Host : *");
        hostLabel.setLayoutData(gridData);

        gridData = new GridData();
        gridData.widthHint = 85;
        gridData.horizontalAlignment = SWT.FILL;
        gridData.grabExcessHorizontalSpace = true;

        hostText = new Text(connectionDataGroup, SWT.BORDER);
        hostText.setText("");
        hostText.setBackground(whiteColor);
        hostText.setLayoutData(gridData);

        Label portLabel = new Label(connectionDataGroup, SWT.NULL);
        portLabel.setText("Port : *");

        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        gridData.grabExcessHorizontalSpace = true;
        gridData.widthHint = 83;

        portText = new Text(connectionDataGroup, SWT.BORDER);
        portText.setText("");
        portText.setBackground(whiteColor);
        portText.setLayoutData(gridData);

        Label userNameLabel = new Label(connectionDataGroup, SWT.NULL);
        userNameLabel.setText("UserName : ");

        gridData = new GridData();
        gridData.widthHint = 85;
        gridData.horizontalAlignment = SWT.FILL;
        gridData.grabExcessHorizontalSpace = true;

        userNameText = new Text(connectionDataGroup, SWT.BORDER);
        userNameText.setBackground(whiteColor);
        userNameText.setLayoutData(gridData);
        userNameText.setText("");

        Label passwordLabel = new Label(connectionDataGroup, SWT.NULL);
        passwordLabel.setText("Password :");

        gridData = new GridData();
        gridData.widthHint = 83;
        gridData.horizontalAlignment = SWT.FILL;
        gridData.grabExcessHorizontalSpace = true;

        passwordText = new Text(connectionDataGroup, SWT.BORDER);
        passwordText.setBackground(whiteColor);
        passwordText.setLayoutData(gridData);
        passwordText.setText("");

        Label databaseLabel = new Label(connectionDataGroup, SWT.NULL);
        databaseLabel.setText("Database : *");

        gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        gridData.grabExcessHorizontalSpace = true;
        gridData.widthHint = 85;

        databaseText = new Text(connectionDataGroup, SWT.BORDER);
        databaseText.setBackground(whiteColor);
        databaseText.setLayoutData(gridData);
        databaseText.setText("");

        gridData = new GridData();
        gridData.horizontalIndent = 280;

        Label infoLabel = new Label(connectionDataComposite, SWT.NULL);
        infoLabel.setText("( * ) fields are required");
        infoLabel.setFont(font);
        infoLabel.setLayoutData(gridData);

        gridLayout = new GridLayout(3, false);
        gridLayout.horizontalSpacing = 1;
        gridLayout.marginLeft = 145;
        gridLayout.marginRight = -5;
        connectionDataComposite = new Composite(form.getBody(), SWT.APPLICATION_MODAL);
        connectionDataComposite.setLayout(gridLayout);
        connectionDataComposite.setBackground(ashColor);

        gridData = new GridData(GridData.END, GridData.END, false, false);
        testConnectionBtn = new Button(connectionDataComposite, SWT.NULL);
        testConnectionBtn.setText("Test Connection");
        testConnectionBtn.setLayoutData(gridData);

        gridData = new GridData(GridData.END, GridData.END, false, false);
        okBtn = new Button(connectionDataComposite, SWT.NULL);
        okBtn.setText("  Save  ");
        okBtn.setLayoutData(gridData);

        gridData = new GridData(GridData.END, GridData.END, false, false);
        cancelBtn = new Button(connectionDataComposite, SWT.NULL);
        cancelBtn.setText("Cancel");
        cancelBtn.setLayoutData(gridData);

        userNameText.setEnabled(false);
        passwordText.setEnabled(false);
        hostText.setEnabled(false);
        portText.setEnabled(false);
        databaseText.setEnabled(false);

        version.setEnabled(false);
        jarLocationText.setEnabled(false);
        btnDownload.setEnabled(false);
        btnBrowse.setEnabled(false);
        btnServer.setEnabled(false);
        btnServer.setSelection(true);

        connectiontype.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {

                version.setEnabled(true);
                jarLocationText.setEnabled(true);
                btnLocate.setEnabled(true);
                btnBrowse.setEnabled(true);
                btnServer.setEnabled(true);

                testConnectionBtn.setEnabled(false);
                okBtn.setEnabled(false);

                downloadInfoGridData.exclude = true;
                downloadInfoComposite.setVisible(false);
                downloadInfoComposite.pack();
                downloadInfoComposite.getParent().getParent().getParent().pack();
                shell.pack();

                switch (connectiontype.getText()) {
                case "MYSQL":
                    version.setItems(mysqlVersionArr);
                    groupId = "mysql";
                    artifactId = "mysql-connector-java";
                    jdbcDriver = "com.mysql.jdbc.Driver";
                    setDefaults("localhost", "3306", "root", "password", "database");
                    databaseConnectionPrefix = "jdbc:mysql://";
                    break;

                case "MSSQL":
                    version.setItems(mssqlVersionArr);
                    groupId = "com.microsoft.sqlserver";
                    artifactId = "mssql-jdbc";
                    jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                    setDefaults("localhost", "1433", "root", "password", "database");
                    databaseConnectionPrefix = "jdbc:sqlserver://";
                    break;

                case "ORACLE":
                    btnDownload.setEnabled(false);
                    version.setItems(oracleVersionArr);
                    groupId = "com.oracle";
                    artifactId = "ojdbc14";
                    jdbcDriver = "com.oracle.jdbc.Driver";
                    setDefaults("SERVER_NAME", "PORT", "root", "password", "SID");
                    databaseConnectionPrefix = "jdbc:oracle:thin:@";

                    btnServer.removeFocusListener(focusListener);
                    btnServer.addFocusListener(focusListener);
                    btnBrowse.setSelection(true);
                    btnServer.setSelection(false);
                    jarProvided = true;
                    userNameText.setEnabled(false);
                    passwordText.setEnabled(false);
                    hostText.setEnabled(false);
                    portText.setEnabled(false);
                    databaseText.setEnabled(false);
                    version.setEnabled(false);
                    btnDownload.setEnabled(false);

                    gridLayout.marginBottom = 0;
                    optionLayout.marginBottom = 10;
                    versionOptiongridData.exclude = true;
                    versionOptionComposite.setVisible(false);
                    versionOptionComposite.pack();

                    browseOptionGridData.exclude = false;
                    browseOptionComposite.setVisible(true);
                    browseOptionComposite.pack();
                    browseOptionComposite.getParent().getParent().getParent().pack();

                    break;

                case "POSTGRESQL":
                    version.setItems(postgresSqlVersionArr);
                    groupId = "org.postgresql";
                    artifactId = "postgresql";
                    jdbcDriver = "com.postgres.jdbc.Driver";
                    setDefaults("localhost", "5432", "root", "password", "database");
                    databaseConnectionPrefix = "jdbc:postgresql://";
                    break;

                }
                jarLocationText.setText("");
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });

        version.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                downloadInfoGridData.exclude = true;
                downloadInfoComposite.setVisible(false);
                downloadInfoComposite.pack();
                downloadInfoComposite.getParent().getParent().getParent().pack();
                compositeMain.pack();
                shell.pack();

                if (version.getText() != null || !version.getText().isEmpty()) {
                    userNameText.setEnabled(true);
                    passwordText.setEnabled(true);
                    hostText.setEnabled(true);
                    portText.setEnabled(true);
                    databaseText.setEnabled(true);
                    btnDownload.setEnabled(true);

                    File file = new File(dependencyDir + File.separator
                            + getDownlodedJarByName(connectiontype.getText(), version.getText()));
                    if (file.exists()) {
                        btnDownload.setEnabled(false);
                        testConnectionBtn.setEnabled(true);
                        okBtn.setEnabled(true);
                        jarProvided = true;
                        jarLocationText.setText(file.getPath());
                        downloadInfoGridData.exclude = false;
                        downloadInfoComposite.setVisible(true);
                        downloadInfoComposite.pack();
                        downloadInfoComposite.getParent().getParent().getParent().pack();
                        shell.pack();
                    }
                }

                if (version.getText().equals("Select Version")) {
                    userNameText.setEnabled(false);
                    passwordText.setEnabled(false);
                    hostText.setEnabled(false);
                    portText.setEnabled(false);
                    databaseText.setEnabled(false);
                    btnDownload.setEnabled(false);
                    testConnectionBtn.setEnabled(false);
                    okBtn.setEnabled(false);
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
            }

        });

        ModifyListener listener = new ModifyListener() {
            /** {@inheritDoc} */
            public void modifyText(ModifyEvent e) {
                if (jarLocationText.getText() != null && !jarLocationText.getText().isEmpty()
                        && !jarLocationText.getText().equals("")) {
                    userNameText.setEnabled(true);
                    passwordText.setEnabled(true);
                    hostText.setEnabled(true);
                    portText.setEnabled(true);
                    databaseText.setEnabled(true);
                } else {
                    if (jarLocationText.getText() == "" || jarLocationText.getText().isEmpty()) {
                        userNameText.setEnabled(false);
                        passwordText.setEnabled(false);
                        hostText.setEnabled(false);
                        portText.setEnabled(false);
                        databaseText.setEnabled(false);
                    }
                }
            }
        };

        jarLocationText.addModifyListener(listener);

        ModifyListener modListener = new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (((Text) e.getSource()).getText().isEmpty() || ((Text) e.getSource()).getText().equals("")
                        && ((version.getText().isEmpty() && !btnServer.getSelection())
                                || (jarLocationText.getText().isEmpty() && !btnBrowse.getSelection()))) {
                    testConnectionBtn.setEnabled(false);
                    okBtn.setEnabled(false);

                } else if (!((Text) e.getSource()).getText().isEmpty() && !((Text) e.getSource()).getText().equals("")
                        && ((Text) e.getSource()).isEnabled()) {
                    testConnectionBtn.setEnabled(true);
                    okBtn.setEnabled(true);

                }
            }
        };

        hostText.addModifyListener(modListener);
        portText.addModifyListener(modListener);
        databaseText.addModifyListener(modListener);

        btnLocate.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                FileDialog dialog = new FileDialog(shell, SWT.NULL);
                dialog.setFilterExtensions(new String[] { "*.jar" });
                String path = dialog.open();
                creatBundleFromJar(path);
            }
        });

        btnDownload.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                if (!version.getText().equals("Select Version")) {
                    List<Dependency> denpendency = new ArrayList<Dependency>();
                    denpendency.add(new Dependency(groupId, artifactId, version.getText()));
                    createPOM(denpendency, dependencyDir, jarOutputPath);
                    progressMonitorDialog = new ProgressMonitorDialog(shell);
                    try {
                        progressMonitorDialog.run(true, true, new LongRunningOperation(true, shell));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    showMessage("Please select required version to download");
                }
            }
        });

        okBtn.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {

                fillConnectionObj();
                try {
                    File file = new File(eclipseWorkspace + File.separator + activeProjectName + File.separator
                            + "dependancies" + File.separator
                            + getDownlodedJarByName(connectiontype.getText(), version.getText()));

                    if (file.exists()) {
                        FileUtils.copyFile(file, new File(getWorkingDirectory() + File.separator + microesbLibPath
                                + File.separator + file.getName()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                remove(jdbcConnectivityJar);

                shell.dispose();
            }
        });

        testConnectionBtn.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                testConnecton();
            }
        });

        cancelBtn.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                remove(dependencyDir + "/target");
                remove(dependencyDir + "/pom.xml");
                shell.dispose();
            }
        });

        shell.addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {

            }
        });

        connectiontype.select(getDatabaseIndex(databaseArr, connectionObj.getDbType()));
        userNameText.setText(connectionObj.getUserName());
        passwordText.setText(connectionObj.getPassword());
        jarLocationText.setText(connectionObj.getJarPath());

        testConnectionBtn.setEnabled(false);
        okBtn.setEnabled(false);

        setInfo();

        downloadInfoGridData.exclude = true;
        downloadInfoComposite.setVisible(false);
        downloadInfoComposite.pack();

        version.select(0);
        shell.setSize(450, 400);
        shell.pack();

        Monitor primary = display.getPrimaryMonitor();

        /** get the size of the screen */
        Rectangle bounds = primary.getBounds();

        /** get the size of the window */
        Rectangle rect = shell.getBounds();

        /** calculate the centre */
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;

        /** set the new location */
        shell.setLocation(x, y);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    private void setInfo() {
        if (connectionObj.getUrl() != null && !connectionObj.getUrl().equals("")) {
            if (connectiontype.getText().equals("MYSQL") || connectiontype.getText().equals("POSTGRESQL")) {

                String m[] = connectionObj.getUrl().split("/");

                hostText.setText(m[2].split(":")[0]);
                portText.setText(m[2].split(":")[1]);
                databaseText.setText(m[3]);

            } else if (connectiontype.getText().equals("MSSQL")) {

                String m[] = connectionObj.getUrl().split("/");

                hostText.setText(m[2].split(":")[0]);
                portText.setText(m[2].split(":")[1].split(";")[0]);
                databaseText.setText(m[2].split(":")[1].split(";")[1].split("=")[1]);

            } else if (connectiontype.getText().equals("ORACLE")) {

                String m[] = connectionObj.getUrl().split("@");

                hostText.setText(m[1].split(":")[0]);
                portText.setText(m[1].split(":")[1].split("/")[0]);
                databaseText.setText(m[1].split(":")[1].split("/")[1]);
            }
        }
    }

    private void fillConnectionObj() {
        connectionObj.setDbType(connectiontype.getText());
        connectionObj.setDbDriver(jdbcDriver);
        connectionObj.setUserName(userNameText.getText());
        connectionObj.setPassword(passwordText.getText());
        databaseURL = generateDbUrl(connectiontype.getText());
        connectionObj.setUrl(databaseURL);
    }

    private boolean creatBundleFromJar(String path) {
        if (path != null) {
            File file = new File(path);
            if (file.isFile() && file.getName().endsWith(".jar")) {
                String fileName = file.getName().replaceAll("-", "_");
                String pluginName = fileName.substring(0, fileName.length() - 4) + "_1.0.0.jar";
                jarLocationText.setText(path);
                BundleGeneratorTool bcg = new BundleGeneratorTool();
                String p[] = { path, dependencyDir, dependencyDir };
                bcg.execute(p);

                jdbcConnectivityJar = dependencyDir + File.separator + pluginName;
                return true;
            }
            if (!file.getName().endsWith(".jar")) {
                showMessage("Please select a valid .jar file");
                return false;
            }
            if (!file.exists()) {
                showMessage("Please download or browse driver.");
                return false;
            }
        }
        return false;
    }

    private void remove(String path) {
        if (path != null) {
            File dir = new File(path);
            if (dir.exists()) {
                try {
                    FileUtils.forceDelete(new File(path));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    private void setDefaults(String host, String port, String user, String password, String database) {
        hostText.setText(host);
        portText.setText(port);
        userNameText.setText(user);
        passwordText.setText(password);
        databaseText.setText(database);
    }

    private String getDownlodedJarByName(String connectionType, String version) {

        switch (connectionType) {
        case "MYSQL":
            return "mysql-connector-java-" + version + ".jar";

        case "MSSQL":
            return "mssql-jdbc-" + version + ".jar";

        case "POSTGRESQL":
            return "postgresql-" + version + ".jar";
        }
        return null;
    }

    private String generateDbUrl(String dbType) {
        if (dbType.equals("MSSQL")) {
            return databaseConnectionPrefix + hostText.getText() + ":" + portText.getText() + ";databaseName="
                    + databaseText.getText() + ";";
        } else {
            return databaseConnectionPrefix + hostText.getText() + ":" + portText.getText() + "/"
                    + databaseText.getText();
        }
    }

    private void testConnecton() {

        boolean jarCreated = false;
        if (jarProvided) {
            jarCreated = creatBundleFromJar(jarLocationText.getText());
        } else {
            jarCreated = creatBundleFromJar(dependencyDir + File.separator
                    + getDownlodedJarByName(connectiontype.getText(), version.getText()));
        }

        if (jarCreated) {
            String path = "file://" + jdbcConnectivityJar;
            Connection conn = null;
            try {
                Bundle bundle = Platform.getBundle("org.wso2.developerstudio.eclipse.gmf.esb.edit");
                Bundle newBundle;
                databaseURL = generateDbUrl(connectiontype.getText());
                switch (connectiontype.getText()) {
                case "MYSQL":
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    if (version.getText().equals("8.0.15") || version.getText().equals("8.0.14")) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } else {
                        Class.forName("com.mysql.jdbc.Driver");
                    }
                    break;
                case "MSSQL":
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    break;
                case "POSTGRESQL":
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName("org.postgresql.Driver");
                    break;
                case "ORACLE":
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    break;
                default:
                    break;
                }
                conn = DriverManager.getConnection(databaseURL, userNameText.getText(), passwordText.getText());
                if (conn != null) {
                    showMessage("Connection Successful");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
            } catch (BundleException e) {
                e.printStackTrace();
                ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
            } catch (Exception e) {
                e.printStackTrace();
                ErrorDialog.openError(shell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    private void showMessage(String msg) {

        int style = SWT.ICON_INFORMATION | SWT.OK;
        MessageBox dia = new MessageBox(this.getParent(), style);
        dia.setText("Information");
        dia.setMessage(msg);
        int rc = dia.open();

    }

    public void buildPOM(String dependencyDir) {

        try {
            File dir = new File(dependencyDir);
            Process p = Runtime.getRuntime().exec("mvn install clean", null, dir);
            p.destroy();
            File sourceDirectory = new File(dependencyDir);

            remove(dependencyDir + File.separator + "pom.xml");
            File[] sourceFiles = sourceDirectory.listFiles();

            for (File file : sourceFiles) {
                if (file.getName().endsWith(".jar")) {
                    FileUtils.copyFile(file, new File(getWorkingDirectory() + File.separator + microesbLibPath
                            + File.separator + file.getName()));
                }
            }

        } catch (IOException e) {
            ErrorDialog.openError(shell, "Error", "An error has occourred",
                    createMultiStatus(e.getLocalizedMessage(), e));
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void createPOM(List<Dependency> dependencyList, String dependencyDir, String jarOutputPath) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            File dir = new File(dependencyDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File pomXML = new File(dependencyDir + File.separator + "pom.xml");

            if (pomXML.exists()) {
                document = documentBuilder.parse(pomXML);
                document.getDocumentElement().normalize();
                NodeList nList = document.getElementsByTagName("dependencies");
                Node node = nList.item(0);
                addDepencisToPOM(dependencyList, node, document);
            } else {
                document.setXmlStandalone(true);
                Element root = document.createElement("project");
                document.appendChild(root);

                Attr xmlns = document.createAttribute("xmlns");
                xmlns.setValue("http://maven.apache.org/POM/4.0.0");
                root.setAttributeNode(xmlns);

                Attr xmlnsXsi = document.createAttribute("xmlns:xsi");
                xmlnsXsi.setValue("http://www.w3.org/2001/XMLSchema-instance");
                root.setAttributeNode(xmlnsXsi);

                Attr xsiSchemaLocation = document.createAttribute("xsi:schemaLocation");
                xsiSchemaLocation
                        .setValue("http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");
                root.setAttributeNode(xsiSchemaLocation);

                Element modelVersion = document.createElement("modelVersion");
                modelVersion.appendChild(document.createTextNode("4.0.0"));
                root.appendChild(modelVersion);

                Element groupId = document.createElement("groupId");
                groupId.appendChild(document.createTextNode("com.wso2.test"));
                root.appendChild(groupId);

                Element artifactId = document.createElement("artifactId");
                artifactId.appendChild(document.createTextNode("test"));
                root.appendChild(artifactId);

                Element version = document.createElement("version");
                version.appendChild(document.createTextNode("1.0-SNAPSHOT"));
                root.appendChild(version);

                Element dependencies = document.createElement("dependencies");
                root.appendChild(dependencies);

                addDepencisToPOM(dependencyList, dependencies, document);

                Element build = document.createElement("build");
                root.appendChild(build);

                Element plugins = document.createElement("plugins");
                build.appendChild(plugins);

                Element plugin = document.createElement("plugin");
                plugins.appendChild(plugin);

                Element pGroupId = document.createElement("groupId");
                pGroupId.appendChild(document.createTextNode("org.apache.maven.plugins"));
                plugin.appendChild(pGroupId);

                Element pArtifactId = document.createElement("artifactId");
                pArtifactId.appendChild(document.createTextNode("maven-dependency-plugin"));
                plugin.appendChild(pArtifactId);

                Element pVersion = document.createElement("version");
                pVersion.appendChild(document.createTextNode("3.1.1"));
                plugin.appendChild(pVersion);

                Element executions = document.createElement("executions");
                plugin.appendChild(executions);

                Element execution = document.createElement("execution");
                executions.appendChild(execution);

                Element eId = document.createElement("id");
                eId.appendChild(document.createTextNode("copy-dependencies"));
                execution.appendChild(eId);

                Element phase = document.createElement("phase");
                phase.appendChild(document.createTextNode("package"));
                execution.appendChild(phase);

                Element goals = document.createElement("goals");
                execution.appendChild(goals);

                Element goal = document.createElement("goal");
                goal.appendChild(document.createTextNode("copy-dependencies"));
                goals.appendChild(goal);

                Element configuration = document.createElement("configuration");
                execution.appendChild(configuration);

                Element excludeArtifactIds = document.createElement("excludeArtifactIds");
                excludeArtifactIds.appendChild(document.createTextNode("protobuf-java"));
                configuration.appendChild(excludeArtifactIds);

                Element outputDirectory = document.createElement("outputDirectory");
                outputDirectory.appendChild(document.createTextNode(jarOutputPath));
                configuration.appendChild(outputDirectory);

                Element overWriteReleases = document.createElement("overWriteReleases");
                overWriteReleases.appendChild(document.createTextNode("false"));
                configuration.appendChild(overWriteReleases);

                Element overWriteSnapshots = document.createElement("overWriteSnapshots");
                overWriteSnapshots.appendChild(document.createTextNode("false"));
                configuration.appendChild(overWriteSnapshots);

                Element overWriteIfNewer = document.createElement("overWriteIfNewer");
                overWriteIfNewer.appendChild(document.createTextNode("true"));
                configuration.appendChild(overWriteIfNewer);

                Element cleanPlugin = document.createElement("plugin");
                plugins.appendChild(cleanPlugin);

                Element cArtifactId = document.createElement("artifactId");
                cArtifactId.appendChild(document.createTextNode("maven-clean-plugin"));
                cleanPlugin.appendChild(cArtifactId);

                Element cVersion = document.createElement("version");
                cVersion.appendChild(document.createTextNode("3.1.0"));
                cleanPlugin.appendChild(cVersion);

                Element cConfiguration = document.createElement("configuration");
                cleanPlugin.appendChild(cConfiguration);

                Element filesets = document.createElement("filesets");
                cConfiguration.appendChild(filesets);

                Element fileset = document.createElement("fileset");
                filesets.appendChild(fileset);

                Element directory = document.createElement("directory");
                directory.appendChild(document.createTextNode(dependencyDir));
                fileset.appendChild(directory);

                Element includes = document.createElement("includes");
                fileset.appendChild(includes);

                Element include = document.createElement("include");
                include.appendChild(document.createTextNode(dependencyDir + File.separator + "pom.xml"));
                includes.appendChild(include);

                Element followSymlinks = document.createElement("followSymlinks");
                followSymlinks.appendChild(document.createTextNode("false"));
                fileset.appendChild(followSymlinks);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(dependencyDir + File.separator + "pom.xml"));
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void addDepencisToPOM(List<Dependency> dependencyList, Node node, Document document) {

        for (Dependency d : dependencyList) {

            Element dependency = document.createElement("dependency");
            node.appendChild(dependency);

            Element dGroupId = document.createElement("groupId");
            dGroupId.appendChild(document.createTextNode(d.getGroupId()));
            dependency.appendChild(dGroupId);

            Element dArtifactId = document.createElement("artifactId");
            dArtifactId.appendChild(document.createTextNode(d.getArtifactId()));
            dependency.appendChild(dArtifactId);

            Element dVersion = document.createElement("version");
            dVersion.appendChild(document.createTextNode(d.getVersion()));
            dependency.appendChild(dVersion);

        }
    }

    private String getWorkingDirectory() {
        String workingDirectory = null;
        String OS = System.getProperty(OS_NAME, SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);

        if ((OS.indexOf(OS_TYPE_MAC) >= 0) || (OS.indexOf(OS_TYPE_DARWIN) >= 0)) {
            String eiToolingHomeForMac = EI_TOOLING_HOME_MACOS;
            File macOSEIToolingAppFile = new File(eiToolingHomeForMac);

            if (macOSEIToolingAppFile.exists()) {
                workingDirectory = eiToolingHomeForMac;
            } else {
                Path path = Paths.get(EMPTY_STRING);
                workingDirectory = (path).toAbsolutePath().toString();
            }
        } else {
            java.nio.file.Path path = Paths.get(EMPTY_STRING);
            workingDirectory = (path).toAbsolutePath().toString();
        }

        return workingDirectory;
    }

    private static MultiStatus createMultiStatus(String msg, Throwable t) {

        List<Status> childStatuses = new ArrayList<>();
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();

        for (StackTraceElement stackTrace : stackTraces) {
            Status status = new Status(IStatus.ERROR, "org.wso2.developerstudio.eclipse.gmf.esb.edit",
                    stackTrace.toString());
            childStatuses.add(status);
        }

        MultiStatus ms = new MultiStatus("org.wso2.developerstudio.eclipse.gmf.esb.edit", IStatus.ERROR,
                childStatuses.toArray(new Status[] {}), t.toString(), t);
        return ms;
    }

    public int getDatabaseIndex(String arr[], String dbType) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(dbType)) {
                return i;
            }
        }
        return 0;
    }

    class LongRunningOperation implements IRunnableWithProgress {
        private static final int TOTAL_TIME = 1000000000;
        private boolean indeterminate;
        private Shell shell;

        protected boolean downloadSuccess = true;;

        public LongRunningOperation(boolean indeterminate, Shell shell) {
            this.indeterminate = indeterminate;
            this.shell = shell;
        }

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

            monitor.beginTask("Downloading Required Dependency JAR",
                    indeterminate ? IProgressMonitor.UNKNOWN : TOTAL_TIME);
            Thread.sleep(500);

            String output = "";
            try {
                File dir = new File(dependencyDir);

                final Process p = Runtime.getRuntime().exec("mvn install clean", null, dir);

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

                while ((output = stdInput.readLine()) != null) {
                    if (monitor.isCanceled()) {
                        p.destroy();
                        Display.getDefault().syncExec(new Runnable() {
                            public void run() {
                                downloadSuccess = false;
                                remove(dependencyDir + "/target");
                                remove(dependencyDir + "/pom.xml");
                                MessageDialog.openInformation(shell, "Cancelled",
                                        "JDBC driver download operation was cancelled");
                            }
                        });
                        throw new InterruptedException("JDBC driver download operation was cancelled");
                    }
                    monitor.worked(100);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            monitor.done();

            if (downloadSuccess) {
                remove(dependencyDir + File.separator + "pom.xml");
                Display.getDefault().syncExec(new Runnable() {
                    public void run() {
                        MessageDialog.openInformation(shell, "Success",
                                "JDBC driver was downloaded sucessfuly "
                                        + "\n\nDownloaded driver is located in the dependencies directory."
                                        + "\nPlease see that the downloaded drivers are not deployed with the CApp.");
                        creatBundleFromJar(dependencyDir + File.separator
                                + getDownlodedJarByName(connectiontype.getText(), version.getText()));
                    }
                });
            }

        }
    }
}
