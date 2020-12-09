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
package org.wso2.developerstudio.eclipse.artifact.dataservice.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.maven.execution.MavenExecutionRequest;
import org.apache.maven.execution.MavenExecutionResult;
import org.apache.maven.lifecycle.LifecycleExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.IMaven;
import org.eclipse.m2e.core.internal.MavenPluginActivator;
import org.eclipse.m2e.core.internal.project.registry.MavenProjectManager;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.ResolverConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
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
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.carbon.tools.converter.BundleGeneratorTool;
import org.wso2.developerstudio.eclipse.artifact.dataservice.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.SAXException;

public class DependencyProvider extends Dialog {

    public static final String OS_NAME = "os.name";
    public static final String SYSTEM_PROPERTY_TYPE_GENERIC = "generic";
    public static final String OS_TYPE_MAC = "mac";
    public static final String OS_TYPE_DARWIN = "darwin";
    public static final String EMPTY_STRING = "";
    public static final String OS_TYPE_LINUX = "linux";
    public static final String OS_TYPE_WINDOWS = "windows";
    private static final String microesbLibPath = "runtime" + File.separator + "microesb" + File.separator + "lib";
    public static final String EI_TOOLING_HOME_MACOS = File.separator + "Applications" + File.separator
            + "IntegrationStudio.app" + File.separator + "Contents" + File.separator + "Eclipse";
    public static final String POM_XML = "pom.xml";
    public static final String TARGET = "target";
    public static final String MYSQL = "MYSQL";
    public static final String MSSQL = "MSSQL";
    public static final String POSTGRESQL = "POSTGRESQL";
    public static final String ORACLE = "ORACLE";
    public static final String INFORMIX = "Informix";
    public static final String IBMDB2 = "IBM DB2";
    public static final String HSQLDB = "HSQLDB";
    public static final String ApacheDerby = "Apache Derby";
    public static final String SYBASE_ASE = "Sybase ASE";
    public static final String H2 = "H2";
    public static final String GENERIC = "Generic";
    public static final String DEPENDENCIES = "dependencies";
    private Font font;
    private Combo versionComboBox;
    private String groupId;
    private String artifactId;
    private Text jarLocationText;
    private String eclipseWorkspace;
    private String activeProjectName;
    private String jarOutputPath;
    private String jdbcDriver;
    private String databaseConnectionPrefix;
    private String databaseURL;
    private String jdbcBundledConnectivityJar;
    private String dependencyDir;
    private Button downloadButton;
    private boolean jarProvided;
    private ConnectionObj connectionObj;
    private Composite connectionComposite;
    private Label conectionTypeLabel;
    private Combo connectiontypeComboBox;
    private Group selectDriverGroup;
    private Button serverRadioButton;
    private Button browseFileRadioButton;
    private Composite serverComposite;
    private Label versionLabel;
    private Label infoLabel;
    private Composite browseLocalComposite;
    private Label browseLabel;
    private Button browseButton;
    private Composite connectionDetailsComposite;
    private Group connectionDetailsGroup;
    private Label hostLabel;
    private Text hostTextField;
    private Label portLabel;
    private Text portTextField;
    private Label userNameLabel;
    private Label passwordLabel;
    private Text passwordTextField;
    private Label databaseLabel;
    private Text databaseTextField;
    private Label emptyLabel;
    private Button testConnectionButton;
    private Button saveButton;
    private Button cancelButton;
    private Text userNameTextField;
    private ProgressMonitorDialog progressMonitorDialog;
    private String databaseArr[] = new String[] { "Select Connection Type", "MYSQL", "MSSQL", "ORACLE", "POSTGRESQL" };
    private String mysqlVersionArr[] = new String[] { "Select Version", "8.0.15", "8.0.14", "5.1.47", "5.1.46" };
    private String mssqlVersionArr[] = new String[] { "Select Version", "6.4.0.jre8", "7.2.0.jre8" };
    private String postgresSqlVersionArr[] = new String[] { "Select Version", "42.2.5" };
    private Shell dialogShell;
    private String OS_TYPE;
    private String[] connectionURLArray;
    private String serverName = "server";
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public DependencyProvider(Shell parent, int style, String activeProjectName, String[] dataBaseTypes) {
        super(parent, style);
        eclipseWorkspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
        IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (dataBaseTypes != null) {
            this.databaseArr = dataBaseTypes;
        }
        if (activeProjectName != null) {
            this.activeProjectName = activeProjectName;
        } else {
            if (editorPart != null) {
                IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
                IFile file = input.getFile();
                IProject activeProject = file.getProject();
                this.activeProjectName = activeProject.getName();
            }
        }
        jarOutputPath = eclipseWorkspace + File.separator + this.activeProjectName + File.separator + DEPENDENCIES;
        dependencyDir = eclipseWorkspace + File.separator + this.activeProjectName + File.separator + DEPENDENCIES;
        OS_TYPE = System.getProperty(OS_NAME, SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);
    }

    public void open(ConnectionObj connectionObj) {
        this.connectionObj = connectionObj;

        dialogShell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        dialogShell.setText("Database Configuration");

        // Configure dialog shell internal layout.
        FormLayout dialogShellLayout = new FormLayout();
        dialogShellLayout.marginHeight = 5;
        dialogShellLayout.marginWidth = 2;
        dialogShell.setLayout(dialogShellLayout);

        int offSet = 30;
        int connectionTypeOffset = 10;
        if (OS_TYPE.indexOf(OS_TYPE_WINDOWS) >= 0) {
            font = new Font(dialogShell.getDisplay(), "Arial", 7, SWT.NONE);
            offSet = 25;
        }
        if (OS_TYPE.indexOf(OS_TYPE_LINUX) >= 0) {
            font = new Font(dialogShell.getDisplay(), "Arial", 9, SWT.NONE);
            connectionTypeOffset = 7;
        }

        connectionComposite = new Composite(dialogShell, SWT.NONE);
        {
            FormLayout connectionTypeGroupLayout = new FormLayout();
            connectionComposite.setLayout(connectionTypeGroupLayout);

            FormData connectionTypeGroupLayoutData = new FormData();
            connectionTypeGroupLayoutData.top = new FormAttachment(0);
            connectionTypeGroupLayoutData.left = new FormAttachment(1);
            connectionTypeGroupLayoutData.right = new FormAttachment(100);
            connectionComposite.setLayoutData(connectionTypeGroupLayoutData);

            conectionTypeLabel = new Label(connectionComposite, SWT.NONE);
            {
                conectionTypeLabel.setText("Connection Type : *");

                FormData layoutData = new FormData();
                layoutData.top = new FormAttachment(10);
                layoutData.left = new FormAttachment(0);
                conectionTypeLabel.setLayoutData(layoutData);
            }

            connectiontypeComboBox = new Combo(connectionComposite, SWT.READ_ONLY);
            {
                connectiontypeComboBox.setItems(new String[] { "Select Connection Type" });
                connectiontypeComboBox.setText("Select Connection Type");
                connectiontypeComboBox.setItems(databaseArr);

                FormData layoutData = new FormData();
                layoutData.top = new FormAttachment(connectionTypeOffset);
                layoutData.right = new FormAttachment(99);
                layoutData.left = new FormAttachment(conectionTypeLabel, 10);
                connectiontypeComboBox.setLayoutData(layoutData);
            }

            // input type radio button group
            selectDriverGroup = new Group(connectionComposite, SWT.NONE);
            {
                FormLayout groupLayout = new FormLayout();
                selectDriverGroup.setLayout(groupLayout);

                FormData groupData = new FormData();
                groupData.top = new FormAttachment(conectionTypeLabel, 10);
                groupData.left = new FormAttachment(0);
                groupData.right = new FormAttachment(99);
                selectDriverGroup.setText("Select driver");
                selectDriverGroup.setLayoutData(groupData);

                serverRadioButton = new Button(selectDriverGroup, SWT.RADIO);
                {
                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, 10);
                    layoutData.left = new FormAttachment(3);

                    serverRadioButton.setText("Get from the server");
                    serverRadioButton.setSelection(true);
                    serverRadioButton.setLayoutData(layoutData);

                }
                browseFileRadioButton = new Button(selectDriverGroup, SWT.RADIO);
                {

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, 10);
                    layoutData.left = new FormAttachment(60);
                    layoutData.right = new FormAttachment(90);

                    browseFileRadioButton.setText("Browse local");
                    browseFileRadioButton.setLayoutData(layoutData);
                }

            }

            serverComposite = new Composite(selectDriverGroup, SWT.NONE);
            {

                FormLayout groupLayout = new FormLayout();
                serverComposite.setLayout(groupLayout);

                FormData groupData = new FormData();
                groupData.top = new FormAttachment(selectDriverGroup, 10);
                groupData.left = new FormAttachment(0);
                groupData.right = new FormAttachment(100);

                serverComposite.setLayoutData(groupData);

                versionLabel = new Label(serverComposite, SWT.NONE);
                {
                    versionLabel.setText("Version");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, offSet + 5);
                    layoutData.left = new FormAttachment(4);
                    versionLabel.setLayoutData(layoutData);
                }

                versionComboBox = new Combo(serverComposite, SWT.READ_ONLY);
                {
                    versionComboBox.setItems(new String[] { "Select Version" });

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, offSet);
                    layoutData.left = new FormAttachment(versionLabel, 10);
                    layoutData.right = new FormAttachment(70);
                    versionComboBox.setLayoutData(layoutData);
                }

                downloadButton = new Button(serverComposite, SWT.NONE);
                {
                    downloadButton.setText("Download");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, offSet);
                    layoutData.left = new FormAttachment(versionComboBox, 10);
                    layoutData.right = new FormAttachment(99);
                    downloadButton.setLayoutData(layoutData);
                }

                infoLabel = new Label(serverComposite, SWT.NONE);
                {
                    infoLabel.setText("* Selected driver is already downloaded");
                    infoLabel.setFont(font);

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(versionLabel, offSet - 20);
                    layoutData.left = new FormAttachment(4);
                    infoLabel.setLayoutData(layoutData);
                }

            }

            browseLocalComposite = new Composite(selectDriverGroup, SWT.NONE);
            {

                FormLayout groupLayout = new FormLayout();
                browseLocalComposite.setLayout(groupLayout);

                FormData groupLayoutData = new FormData();
                groupLayoutData.top = new FormAttachment(connectionComposite, 10);
                groupLayoutData.left = new FormAttachment(0);
                groupLayoutData.right = new FormAttachment(100);
                browseLocalComposite.setLayoutData(groupLayoutData);

                browseLabel = new Label(browseLocalComposite, SWT.NONE);
                {
                    browseLabel.setText("Browse");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, offSet + 5);
                    layoutData.left = new FormAttachment(4);

                    browseLabel.setLayoutData(layoutData);
                }

                jarLocationText = new Text(browseLocalComposite, SWT.BORDER);
                {

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, offSet);
                    layoutData.left = new FormAttachment(browseLabel, 10);
                    layoutData.right = new FormAttachment(70);
                    jarLocationText.setLayoutData(layoutData);
                }

                browseButton = new Button(browseLocalComposite, SWT.NONE);
                {
                    browseButton.setText("Browse File");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(selectDriverGroup, offSet);
                    layoutData.left = new FormAttachment(jarLocationText, 10);
                    layoutData.right = new FormAttachment(99);
                    browseButton.setLayoutData(layoutData);
                }

            }

        }

        connectionDetailsComposite = new Composite(dialogShell, SWT.NONE);
        {
            FormLayout connectionDetailsCompositeLayout = new FormLayout();
            connectionDetailsComposite.setLayout(connectionDetailsCompositeLayout);

            FormData connectionDetailsCompositeLayoutData = new FormData();
            connectionDetailsCompositeLayoutData.top = new FormAttachment(connectionComposite, 0);
            connectionDetailsCompositeLayoutData.left = new FormAttachment(1);
            connectionDetailsCompositeLayoutData.right = new FormAttachment(100);
            connectionDetailsComposite.setLayoutData(connectionDetailsCompositeLayoutData);

            connectionDetailsGroup = new Group(connectionDetailsComposite, SWT.NONE);
            {
                FormLayout connectionDetailsGroupLayout = new FormLayout();
                connectionDetailsGroup.setLayout(connectionDetailsGroupLayout);

                FormData connectionDetailsGroupLayoutData = new FormData();
                connectionDetailsGroupLayoutData.top = new FormAttachment(conectionTypeLabel, 10);
                connectionDetailsGroupLayoutData.left = new FormAttachment(0);
                connectionDetailsGroupLayoutData.right = new FormAttachment(99);

                connectionDetailsGroup.setText("Connection");
                connectionDetailsGroup.setLayoutData(connectionDetailsGroupLayoutData);

                hostLabel = new Label(connectionDetailsGroup, SWT.NONE);
                {
                    hostLabel.setText("Host: * ");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(conectionTypeLabel, 10);
                    layoutData.left = new FormAttachment(4);
                    layoutData.right = new FormAttachment(20);
                    hostLabel.setLayoutData(layoutData);
                }

                hostTextField = new Text(connectionDetailsGroup, SWT.BORDER);
                {

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(conectionTypeLabel, 5);
                    layoutData.left = new FormAttachment(hostLabel, 5);
                    layoutData.right = new FormAttachment(50);
                    hostTextField.setLayoutData(layoutData);

                }

                portLabel = new Label(connectionDetailsGroup, SWT.NONE);
                {
                    portLabel.setText("Port: *");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(conectionTypeLabel, 10);
                    layoutData.left = new FormAttachment(hostTextField, 6);
                    portLabel.setLayoutData(layoutData);
                }

                portTextField = new Text(connectionDetailsGroup, SWT.BORDER);
                {

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(conectionTypeLabel, 5);
                    layoutData.left = new FormAttachment(65);
                    layoutData.right = new FormAttachment(99);
                    portTextField.setLayoutData(layoutData);

                }

                userNameLabel = new Label(connectionDetailsGroup, SWT.NONE);
                {
                    userNameLabel.setText("UserName :");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(hostTextField, 10);
                    layoutData.left = new FormAttachment(4);
                    layoutData.right = new FormAttachment(20);
                    userNameLabel.setLayoutData(layoutData);
                }

                userNameTextField = new Text(connectionDetailsGroup, SWT.BORDER);
                {

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(hostTextField, 5);
                    layoutData.left = new FormAttachment(userNameLabel, 5);
                    layoutData.right = new FormAttachment(50);
                    userNameTextField.setLayoutData(layoutData);

                }

                passwordLabel = new Label(connectionDetailsGroup, SWT.NONE);
                {
                    passwordLabel.setText("Password: ");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(portTextField, 10);
                    layoutData.left = new FormAttachment(hostTextField, 4);

                    passwordLabel.setLayoutData(layoutData);
                }

                passwordTextField = new Text(connectionDetailsGroup, SWT.BORDER);
                {

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(portTextField, 5);
                    layoutData.left = new FormAttachment(65);
                    layoutData.right = new FormAttachment(99);
                    passwordTextField.setLayoutData(layoutData);

                }
                databaseLabel = new Label(connectionDetailsGroup, SWT.NONE);
                {
                    databaseLabel.setText("Database: *");

                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(userNameLabel, 10);
                    layoutData.left = new FormAttachment(4);
                    layoutData.right = new FormAttachment(20);
                    databaseLabel.setLayoutData(layoutData);
                }

                databaseTextField = new Text(connectionDetailsGroup, SWT.BORDER);
                {
                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(userNameTextField, 05);
                    layoutData.left = new FormAttachment(databaseLabel, 5);
                    layoutData.right = new FormAttachment(50);

                    databaseTextField.setLayoutData(layoutData);

                }
                emptyLabel = new Label(connectionDetailsGroup, SWT.NONE);// browseLabel
                {
                    FormData layoutData = new FormData();
                    layoutData.top = new FormAttachment(databaseTextField);
                    emptyLabel.setLayoutData(layoutData);
                }
            }
        }

        testConnectionButton = new Button(dialogShell, SWT.BUTTON1);
        {

            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(connectionDetailsComposite, 10);
            layoutData.left = new FormAttachment(50);
            layoutData.right = new FormAttachment(75);
            testConnectionButton.setText("Test Connection");
            testConnectionButton.setLayoutData(layoutData);
        }
        saveButton = new Button(dialogShell, SWT.BUTTON1);
        {

            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(connectionDetailsComposite, 10);
            layoutData.left = new FormAttachment(testConnectionButton, 4);
            layoutData.right = new FormAttachment(85);
            saveButton.setText("Save");
            saveButton.setLayoutData(layoutData);
        }
        cancelButton = new Button(dialogShell, SWT.BUTTON1);
        {

            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(connectionDetailsComposite, 10);
            layoutData.left = new FormAttachment(saveButton, 4);
            layoutData.right = new FormAttachment(99);
            cancelButton.setText("Cancel");
            cancelButton.setLayoutData(layoutData);
        }

        serverRadioButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    infoLabel.setVisible(false);
                    serverComposite.setVisible(true);
                    browseLocalComposite.setVisible(false);

                    testConnectionButton.setEnabled(false);
                    saveButton.setEnabled(false);

                    versionComboBox.select(0);
                    jarLocationText.setText("");

                    jarProvided = false;
                    inputFeildsSetEnabled(false);

                }
            }
        });

        browseFileRadioButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    infoLabel.setVisible(false);
                    browseLocalComposite.setVisible(true);
                    serverComposite.setVisible(false);
                    serverRadioButton.setEnabled(true);

                    jarLocationText.setEnabled(true);
                    jarLocationText.setText("");
                    browseButton.setEnabled(true);

                    testConnectionButton.setEnabled(false);
                    saveButton.setEnabled(false);

                    versionComboBox.select(0);

                    jarProvided = true;
                    inputFeildsSetEnabled(false);

                }
            }
        });

        connectiontypeComboBox.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                versionComboBox.setEnabled(true);
                jarLocationText.setEnabled(true);
                browseButton.setEnabled(true);

                serverRadioButton.setSelection(true);
                serverRadioButton.setEnabled(true);
                browseFileRadioButton.setEnabled(true);
                browseFileRadioButton.setSelection(false);
                serverComposite.setVisible(true);
                browseLocalComposite.setVisible(false);

                testConnectionButton.setEnabled(false);
                saveButton.setEnabled(false);

                switch (connectiontypeComboBox.getText()) {

                case "Select Connection Type":
                    versionComboBox.setEnabled(false);
                    browseButton.setEnabled(false);
                    jarLocationText.setEnabled(false);
                    break;

                case MYSQL:
                    versionComboBox.setItems(mysqlVersionArr);
                    groupId = "mysql";
                    artifactId = "mysql-connector-java";
                    jdbcDriver = "com.mysql.jdbc.Driver";
                    databaseConnectionPrefix = "jdbc:mysql://";
                    setDefaults("localhost", "3306");
                    break;

                case MSSQL:
                    versionComboBox.setItems(mssqlVersionArr);
                    groupId = "com.microsoft.sqlserver";
                    artifactId = "mssql-jdbc";
                    jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                    databaseConnectionPrefix = "jdbc:sqlserver://";
                    setDefaults("localhost", "1433");
                    break;

                case ORACLE:
                    downloadButton.setEnabled(false);
                    jdbcDriver = "com.oracle.jdbc.Driver";
                    setDefaults("SERVER_NAME", "PORT");
                    databaseConnectionPrefix = "jdbc:oracle:thin:@";

                    browseFileRadioButton.setSelection(true);
                    serverRadioButton.setSelection(false);
                    serverRadioButton.setEnabled(false);

                    serverComposite.setVisible(false);
                    browseLocalComposite.setVisible(true);

                    jarProvided = true;

                    inputFeildsSetEnabled(false);

                    versionComboBox.setEnabled(false);
                    downloadButton.setEnabled(false);
                    break;

                case POSTGRESQL:
                    versionComboBox.setItems(postgresSqlVersionArr);
                    groupId = "org.postgresql";
                    artifactId = "postgresql";
                    jdbcDriver = "com.postgres.jdbc.Driver";
                    databaseConnectionPrefix = "jdbc:postgresql://";
                    setDefaults("localhost", "5432");
                    break;

                case SYBASE_ASE:
                    jdbcDriver = "com.sybase.jdbc3.jdbc.SybDriver";
                    databaseConnectionPrefix = "jdbc:sybase:Tds:";
                    setDefaults("localhost", "2048");

                    browseFileRadioButton.setSelection(true);
                    serverRadioButton.setSelection(false);
                    serverRadioButton.setEnabled(false);

                    serverComposite.setVisible(false);
                    browseLocalComposite.setVisible(true);

                    jarProvided = true;

                    inputFeildsSetEnabled(false);

                    versionComboBox.setEnabled(false);
                    downloadButton.setEnabled(false);
                    break;

                case ApacheDerby:
                    versionComboBox.setItems(new String[] { "Select Version", "10.15.1.3" });
                    groupId = "org.apache.derby";
                    artifactId = "derbytools";
                    jdbcDriver = "org.apache.derby.jdbc.EmbeddedDriver";
                    databaseConnectionPrefix = "jdbc:derby://";
                    setDefaults("localhost", "1527");
                    break;

                case HSQLDB:
                    versionComboBox.setItems(new String[] { "Select Version", "2.5.0" });
                    groupId = "org.hsqldb";
                    artifactId = "hsqldb";
                    jdbcDriver = "org.hsqldb.jdbcDriver";
                    databaseConnectionPrefix = "jdbc:hsqldb:";
                    setDefaults("localhost", "5432");
                    break;

                case IBMDB2:
                    versionComboBox.setItems(new String[] { "Select Version", "db2jcc4" });
                    groupId = "com.ibm.db2.jcc";
                    artifactId = "db2jcc";
                    jdbcDriver = "com.ibm.db2.jcc.DB2Driver";
                    databaseConnectionPrefix = "jdbc:db2://";
                    setDefaults("localhost", "50000");
                    break;

                case INFORMIX:
                    versionComboBox.setItems(new String[] { "Select Version", "4.50.1" });
                    groupId = "com.ibm.informix";
                    artifactId = "jdbc";
                    jdbcDriver = "com.informix.jdbc.IfxDriver";
                    databaseConnectionPrefix = "jdbc:informix-sqli://";
                    setDefaults("localhost", "1526");
                    break;

                case H2:
                    jdbcDriver = "org.h2.Driver";
                    databaseConnectionPrefix = "jdbc:h2:tcp:";
                    setDefaults("localhost", "5432");

                    browseFileRadioButton.setSelection(true);
                    serverRadioButton.setSelection(false);
                    serverRadioButton.setEnabled(false);

                    serverComposite.setVisible(false);
                    browseLocalComposite.setVisible(true);

                    jarProvided = true;

                    inputFeildsSetEnabled(false);

                    versionComboBox.setEnabled(false);
                    downloadButton.setEnabled(false);
                    break;

                }
                jarLocationText.setText("");
                versionComboBox.select(0);
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });

        versionComboBox.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                infoLabel.setVisible(false);
                if (versionComboBox.getText() != null || !versionComboBox.getText().isEmpty()) {
                    inputFeildsSetEnabled(true);
                    downloadButton.setEnabled(true);

                    File file = new File(dependencyDir + File.separator
                            + getDownlodedJarByName(connectiontypeComboBox.getText(), versionComboBox.getText()));
                    if (file.exists()) {

                        infoLabel.setVisible(true);
                        downloadButton.setEnabled(false);
                        testConnectionButton.setEnabled(true);
                        saveButton.setEnabled(true);
                        jarProvided = true;
                        jarLocationText.setText(file.getPath());
                    }
                }

                if (versionComboBox.getText().equals("Select Version")) {
                    infoLabel.setVisible(false);
                    inputFeildsSetEnabled(false);

                    downloadButton.setEnabled(false);
                    testConnectionButton.setEnabled(false);
                    saveButton.setEnabled(false);

                } else {
                    enableButtonsIfDataIsAvailable();
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

                    inputFeildsSetEnabled(true);
                    enableButtonsIfDataIsAvailable();

                } else {
                    if (jarLocationText.getText() == "" || jarLocationText.getText().isEmpty()) {
                        inputFeildsSetEnabled(false);
                    }
                }
            }
        };

        jarLocationText.addModifyListener(listener);

        ModifyListener modListener = new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (((Text) e.getSource()).getText().isEmpty() || ((Text) e.getSource()).getText().equals("")
                        && ((versionComboBox.getText().isEmpty() && !serverRadioButton.getSelection())
                                || (jarLocationText.getText().isEmpty() && !browseFileRadioButton.getSelection()))) {
                    testConnectionButton.setEnabled(false);
                    saveButton.setEnabled(false);

                } else if (!((Text) e.getSource()).getText().isEmpty() && !((Text) e.getSource()).getText().equals("")
                        && ((Text) e.getSource()).isEnabled()) {
                    testConnectionButton.setEnabled(true);
                    saveButton.setEnabled(true);

                }
            }
        };

        hostTextField.addModifyListener(modListener);
        portTextField.addModifyListener(modListener);
        databaseTextField.addModifyListener(modListener);

        browseButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                FileDialog dialog = new FileDialog(dialogShell, SWT.NULL);
                dialog.setFilterExtensions(new String[] { "*.jar" });
                String path = dialog.open();
                creatBundleFromJar(path);
            }
        });

        downloadButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                List<Dependency> denpendency = new ArrayList<Dependency>();
                denpendency.add(new Dependency(groupId, artifactId, versionComboBox.getText()));
                createPOM(denpendency, dependencyDir, jarOutputPath);
                progressMonitorDialog = new ProgressMonitorDialog(dialogShell);
                try {
                    progressMonitorDialog.run(true, true, new DownloadProgress(true, dialogShell));
                } catch (Exception e) {
                    log.error("Exception", e);
                }
            }
        });

        saveButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                fillConnectionObj();
                try {
                    File file = new File(eclipseWorkspace + File.separator + activeProjectName + File.separator
                            + DEPENDENCIES + File.separator
                            + getDownlodedJarByName(connectiontypeComboBox.getText(), versionComboBox.getText()));

                    if (file.exists()) {
                        FileUtils.copyFile(file, new File(getWorkingDirectory() + File.separator + microesbLibPath
                                + File.separator + file.getName()));
                    }
                } catch (Exception e) {
                    log.error("Exception while copying files", e);
                }
                dialogShell.dispose();
            }
        });

        testConnectionButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                testConnecton();
            }
        });

        cancelButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                remove(dependencyDir + File.separator + TARGET);
                remove(dependencyDir + File.separator + POM_XML);
                dialogShell.dispose();
            }
        });

        dialogShell.addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {

            }
        });

        {
            testConnectionButton.setEnabled(false);
            saveButton.setEnabled(false);

            jarLocationText.setEnabled(false);
            browseFileRadioButton.setEnabled(true);
            browseFileRadioButton.setSelection(false);
            browseLocalComposite.setVisible(false);

            serverRadioButton.setEnabled(true);
            serverRadioButton.setSelection(true);

            downloadButton.setEnabled(false);

            infoLabel.setVisible(false);

            if (connectiontypeComboBox.getText().equals("")) {
                versionComboBox.setEnabled(false);
                browseButton.setEnabled(false);
                jarLocationText.setEnabled(false);
            }

        }

        setDataFromConnectionObj(connectionObj);

        inputFeildsSetEnabled(false);

        setDefaultsToVersionComboBox();

        setDataFromConnectionURL();

        versionComboBox.select(0);

        dialogShell.layout();
        dialogShell.pack();

        if (OS_TYPE.indexOf(OS_TYPE_WINDOWS) >= 0) {
            dialogShell.setSize(520, 380);
        }
        if (OS_TYPE.indexOf(OS_TYPE_LINUX) >= 0) {
            dialogShell.setSize(720, 430);
        }

        Display display = dialogShell.getDisplay();

        Monitor primary = display.getActiveShell().getMonitor();

        /** get the size of the screen */
        Rectangle bounds = primary.getBounds();

        /** get the size of the window */
        Rectangle rect = dialogShell.getBounds();

        /** calculate the centre */
        int xx = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;

        /** set the new location */
        dialogShell.setLocation(xx, y);
        dialogShell.open();

        while (!dialogShell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    private void setDataFromConnectionObj(ConnectionObj connectionObj) {
        connectiontypeComboBox.select(getDatabaseIndex(databaseArr, connectionObj.getDbType()));
        userNameTextField.setText(connectionObj.getUserName());
        passwordTextField.setText(connectionObj.getPassword());
        jarLocationText.setText(connectionObj.getJarPath());
    }

    private void inputFeildsSetEnabled(boolean isVisible) {
        hostTextField.setEnabled(isVisible);
        portTextField.setEnabled(isVisible);
        userNameTextField.setEnabled(isVisible);
        passwordTextField.setEnabled(isVisible);
        databaseTextField.setEnabled(isVisible);
    }

    private void setDefaultsToVersionComboBox() {
        versionComboBox.setEnabled(true);

        switch (connectiontypeComboBox.getText()) {
        case MYSQL:
            versionComboBox.setItems(mysqlVersionArr);
            groupId = "mysql";
            artifactId = "mysql-connector-java";
            jdbcDriver = "com.mysql.jdbc.Driver";
            databaseConnectionPrefix = "jdbc:mysql://";
            break;

        case MSSQL:
            versionComboBox.setItems(mssqlVersionArr);
            groupId = "com.microsoft.sqlserver";
            artifactId = "mssql-jdbc";
            jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            databaseConnectionPrefix = "jdbc:sqlserver://";
            break;

        case POSTGRESQL:
            versionComboBox.setItems(postgresSqlVersionArr);
            groupId = "org.postgresql";
            artifactId = "postgresql";
            jdbcDriver = "com.postgres.jdbc.Driver";
            databaseConnectionPrefix = "jdbc:postgresql://";
            break;

        case ORACLE:
            databaseConnectionPrefix = "jdbc:postgresql://";
            jdbcDriver = "com.oracle.jdbc.Driver";

            jarLocationText.setEnabled(true);
            browseFileRadioButton.setEnabled(true);
            browseFileRadioButton.setSelection(true);
            browseLocalComposite.setVisible(true);

            serverRadioButton.setEnabled(true);
            serverRadioButton.setSelection(false);
            serverComposite.setVisible(false);

            versionComboBox.setEnabled(false);
            downloadButton.setEnabled(false);
            break;
        }
    }

    private void enableButtonsIfDataIsAvailable() {
        if (hostTextField.getText() != null && !hostTextField.getText().equals("") && portTextField.getText() != null
                && !portTextField.getText().equals("") && databaseTextField.getText() != null
                && !databaseTextField.getText().equals("")) {
            testConnectionButton.setEnabled(true);
            saveButton.setEnabled(true);
        }

        if (hostTextField.getText() == null || hostTextField.getText().equals("") && portTextField.getText() == null
                || portTextField.getText().equals("") && databaseTextField.getText() == null
                || databaseTextField.getText().equals("")) {
            testConnectionButton.setEnabled(false);
            saveButton.setEnabled(false);
        }
    }

    private void setDataFromConnectionURL() {
        if (connectionObj.getUrl() != null && !connectionObj.getUrl().equals("")) {
            if (connectionObj.getDbType().equals(MYSQL) || connectionObj.getDbType().equals(POSTGRESQL)) {

                connectionURLArray = connectionObj.getUrl().split("/");

                hostTextField.setText(connectionURLArray[2].split(":")[0]);
                portTextField.setText(connectionURLArray[2].split(":")[1]);
                databaseTextField.setText(connectionURLArray[3]);

            } else if (connectionObj.getDbType().equals(MSSQL)) {

                connectionURLArray = connectionObj.getUrl().split("/");

                hostTextField.setText(connectionURLArray[2].split(":")[0]);
                portTextField.setText(connectionURLArray[2].split(":")[1].split(";")[0]);
                databaseTextField.setText(connectionURLArray[2].split(":")[1].split(";")[1].split("=")[1]);

            } else if (connectionObj.getDbType().equals(ORACLE)) {

                connectionURLArray = connectionObj.getUrl().split("@");

                hostTextField.setText(connectionURLArray[1].split(":")[0]);
                portTextField.setText(connectionURLArray[1].split(":")[1].split("/")[0]);
                databaseTextField.setText(connectionURLArray[1].split(":")[1].split("/")[1]);
            }
        }
    }

    private void fillConnectionObj() {
        connectionObj.setDbType(connectiontypeComboBox.getText());
        connectionObj.setDbDriver(jdbcDriver);
        connectionObj.setUserName(userNameTextField.getText());
        connectionObj.setPassword(passwordTextField.getText());
        databaseURL = generateDbUrl(connectiontypeComboBox.getText());
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

                jdbcBundledConnectivityJar = dependencyDir + File.separator + pluginName;
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
                    log.error("Exception while deleting file", e);
                }
            }
        }

    }

    private void setDefaults(String host, String port) {
        hostTextField.setText(host);
        portTextField.setText(port);
        userNameTextField.setText("");
        passwordTextField.setText("");
        databaseTextField.setText("");
    }

    private String getDownlodedJarByName(String connectionType, String version) {
        switch (connectionType) {
        case MYSQL:
            return "mysql-connector-java-" + version + ".jar";

        case MSSQL:
            return "mssql-jdbc-" + version + ".jar";

        case POSTGRESQL:
            return "postgresql-" + version + ".jar";

        case ApacheDerby:
            return "derbytools-" + version + ".jar";

        case IBMDB2:
            return "db2jcc-" + version + ".jar";

        case HSQLDB:
            return "hsqldb-" + version + ".jar";

        case INFORMIX:
            return "jdbc-" + version + ".jar";
        }
        return null;
    }

    private String generateDbUrl(String dbType) {
        if (dbType.equals(ApacheDerby)){
            return databaseConnectionPrefix + hostTextField.getText() +":"
                    + portTextField.getText()+"/"+databaseTextField.getText()+";create=true";
        }
        if (dbType.equals(INFORMIX)){
            return databaseConnectionPrefix + hostTextField.getText() +":"
                    + portTextField.getText()+"/"+databaseTextField.getText()+":INFORMIXSERVER="+serverName;
        }
        if (dbType.equals(MSSQL)) {
            return databaseConnectionPrefix + hostTextField.getText() + ":" + portTextField.getText() 
                    + ";databaseName="+ databaseTextField.getText() + ";";
        } else {
            return databaseConnectionPrefix + hostTextField.getText() + ":" + portTextField.getText() + "/"
                    + databaseTextField.getText();
        }
    }

    private void testConnecton() {
        boolean jarCreated = false;
        if (jarProvided) {
            jarCreated = creatBundleFromJar(jarLocationText.getText());
        } else {
            jarCreated = creatBundleFromJar(dependencyDir + File.separator
                    + getDownlodedJarByName(connectiontypeComboBox.getText(), versionComboBox.getText()));
        }

        if (jarCreated) {
            String path = "file://" + jdbcBundledConnectivityJar;
            Connection conn = null;
            try {
                Bundle bundle = Platform.getBundle("org.wso2.developerstudio.eclipse.artifact.dataservice");
                Bundle newBundle;
                databaseURL = generateDbUrl(connectiontypeComboBox.getText());
                switch (connectiontypeComboBox.getText()) {
                case MYSQL:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    if (versionComboBox.getText().equals("8.0.15") || versionComboBox.getText().equals("8.0.14")) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } else {
                        Class.forName("com.mysql.jdbc.Driver");
                    }
                    break;

                case MSSQL:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    break;

                case POSTGRESQL:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName("org.postgresql.Driver");
                    break;

                case ORACLE:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    break;

                case SYBASE_ASE:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName(this.jdbcDriver);
                    break;

                case ApacheDerby:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName(this.jdbcDriver);
                    break;

                case HSQLDB:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName(this.jdbcDriver);
                    break;

                case IBMDB2:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName(this.jdbcDriver);
                    break;

                case INFORMIX:
                    //TODO: need to change UI of dependency provider for ServerName input
                    //TODO: jdbc:informix-sqli://[HOST]:[PORT]/[database]:INFORMIXSERVER=[server-name]
                    //TODO: default serverName will be set to 'server'
                    //TODO: test connection function is available comment off if not required
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName(this.jdbcDriver);
                    break;

                case H2:
                    newBundle = bundle.getBundleContext().installBundle(path);
                    newBundle.start();
                    Class.forName(this.jdbcDriver);
                    break;
                }
                conn = DriverManager.getConnection(databaseURL, userNameTextField.getText(),
                        passwordTextField.getText());
                if (conn != null) {
                    showMessage("Connection Successful");
                }
            } catch (ClassNotFoundException e) {
                ErrorDialog.openError(dialogShell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
                log.error("ClassNotFoundException", e);
            } catch (SQLException e) {
                ErrorDialog.openError(dialogShell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
                log.error("SQLException", e);
            } catch (BundleException e) {
                ErrorDialog.openError(dialogShell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
                log.error("BundleException", e);
            } catch (Exception e) {
                ErrorDialog.openError(dialogShell, "Error", "Error!", createMultiStatus(e.getLocalizedMessage(), e));
                log.error("Exception", e);
            } finally {
                remove(jdbcBundledConnectivityJar);
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        log.error("Exception while closing JDBC connection", ex);
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
        dia.open();

    }

    @SuppressWarnings("deprecation")
	public static MavenExecutionResult runMavenExecution(IFile pomFile, List<String> goals, IProgressMonitor monitor)
            throws Exception {

        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        MavenExecutionResult result = null;
        try {
            MavenPluginActivator.getDefault().setDebugging(true);
            monitor.beginTask("Building: " + pomFile.getName(), 3);
            MavenProjectManager projectManager = MavenPluginActivator.getDefault().getMavenProjectManager();
            IMaven maven = MavenPlugin.getDefault().getMaven();

            IMavenProjectFacade facade = projectManager.create(pomFile, true, new SubProgressMonitor(monitor, 1));
            ResolverConfiguration config = facade.getResolverConfiguration();
            MavenExecutionRequest request = projectManager.createExecutionRequest(pomFile, config,
                    new SubProgressMonitor(monitor, 1));
            request.setGoals(goals);
            request.setShowErrors(true);
            request.setUpdateSnapshots(true);
            result = maven.execute(request, new SubProgressMonitor(monitor, 1));

            return result;

        } catch (Throwable e) {
            log.error("Exception while executing maven task", e);
        } finally {
            monitor.done();
        }
        return result;
    }

    public void buildPOM(String dependencyDirectory) {
        dependencyDir = dependencyDirectory;

        IPath ResourcePath = new org.eclipse.core.runtime.Path(dependencyDir);
        IContainer container = ResourcesPlugin.getWorkspace().getRoot().getContainerForLocation(ResourcePath);

        IFile pomFile = container.getFile(new org.eclipse.core.runtime.Path(POM_XML));
        try {
            MavenExecutionResult mvn = runMavenExecution(pomFile,
                    Arrays.asList("org.apache.maven.plugins:maven-dependency-plugin:2.8:copy-dependencies"), null);

            if (mvn.hasExceptions()) {// throw errors if exists
                remove(dependencyDir + File.separator + POM_XML);
                List<Throwable> rr = mvn.getExceptions();
                for (Throwable t : rr) {
                    throw t;
                }
            } else {// when download of dependencies is success, copy .jars to MicroESB/lib directory
                remove(dependencyDir + File.separator + POM_XML);
                File[] sourceFiles = new File(dependencyDir).listFiles();
                for (File file : sourceFiles) {
                    if (file.getName().endsWith(".jar")) {
                        FileUtils.copyFile(file, new File(getWorkingDirectory() + File.separator + microesbLibPath
                                + File.separator + file.getName()));
                    }
                }
            }

        } catch (LifecycleExecutionException e) {
            log.error("Failed to download dependency from maven check for internet connection", e);
        } catch (IOException e) {
            log.error("Error while copying files", e);
        } catch (Throwable e) {
            log.error("Exception", e);
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

            File pomXML = new File(dependencyDir + File.separator + POM_XML);

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

                Element configuration = document.createElement("configuration");
                plugin.appendChild(configuration);

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
                include.appendChild(document.createTextNode(dependencyDir + File.separator + POM_XML));
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
            StreamResult streamResult = new StreamResult(new File(dependencyDir + File.separator + POM_XML));
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {
            log.error("Could not parse XML String", pce);
        } catch (TransformerException tfe) {
            log.error("Could not transform XML", tfe);
        } catch (SAXException | IOException e) {
            log.error("Could not parse XML String", e);
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
            Status status = new Status(IStatus.ERROR, "org.wso2.developerstudio.eclipse.artifact.dataservice",
                    stackTrace.toString());
            childStatuses.add(status);
        }

        MultiStatus ms = new MultiStatus("org.wso2.developerstudio.eclipse.artifact.dataservice", IStatus.ERROR,
                childStatuses.toArray(new Status[] {}), t.toString(), t);
        return ms;
    }

    private int getDatabaseIndex(String arr[], String dbType) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(dbType)) {
                return i;
            }
        }
        return 0;
    }

    private void createReadME() {

        File readMe = new File(dependencyDir + File.separator + "README.txt");
        if (!readMe.exists()) {
            Writer output = null;
            try {
                readMe.createNewFile();

                String content = "README" + "\n"
                        + "\n===============================================================================\n" + "\n"
                        + "\nThis directory contains downloaded drivers.\n"
                        + "\nDrivers will not get deployed with other artifacts (in your CApp).\n"
                        + "\nBe sure to manually copy the drivers from this directory to <PRODUCT_HOME>/lib/.";

                output = new BufferedWriter(new FileWriter(readMe));
                output.write(content);

            } catch (IOException e) {
                log.error("Error while reading README.txt", e);
            } finally {
                if (output != null)
                    try {
                        output.close();
                    } catch (IOException e) {
                        log.error("Error while closing output stream", e);
                    }
            }
        }
    }

    class DownloadProgress implements IRunnableWithProgress {

        private static final int TOTAL_TIME = 100000;
        private boolean indeterminate;
        private Shell shell;
        private int TIME_INTERVAL = 1;
        private IProgressMonitor monitor;
        private ScheduledExecutorService scheduledExecutorService;

        public DownloadProgress(boolean indeterminate, Shell shell) {
            this.indeterminate = indeterminate;
            this.shell = shell;
        }

        @Override
        public void run(IProgressMonitor mon) throws InvocationTargetException, InterruptedException {
            monitor = mon;
            monitor.beginTask("Downloading Required Dependency JAR",
                    indeterminate ? IProgressMonitor.UNKNOWN : TOTAL_TIME);
            Thread.sleep(500);

            scheduledExecutorService = Executors.newScheduledThreadPool(1);

            ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

                public void run() {

                    IPath ResourcePath = new org.eclipse.core.runtime.Path(dependencyDir);
                    IContainer container = ResourcesPlugin.getWorkspace().getRoot()
                            .getContainerForLocation(ResourcePath);

                    IFile pomFile = container.getFile(new org.eclipse.core.runtime.Path(POM_XML));
                    try {
                        MavenExecutionResult mvn = runMavenExecution(pomFile,
                                Arrays.asList("org.apache.maven.plugins:maven-dependency-plugin:2.8:copy-dependencies"),
                                null);
                        if (monitor.isCanceled()) {
                        	scheduledExecutorService.shutdown();
                            remove(dependencyDir + File.separator + POM_XML);
                            throw new InterruptedException("The download process was canceled");
                        }

                        if (mvn.hasExceptions()) {
                        	scheduledExecutorService.shutdown();
                            List<Throwable> rr = mvn.getExceptions();
                            for (Throwable t : rr) {
                                throw t;
                            }

                        } else {
                            remove(dependencyDir + File.separator + POM_XML);
                            createReadME();
                            Display.getDefault().syncExec(new Runnable() {
                                public void run() {
                                    MessageDialog.openInformation(shell, "Success",
                                            "You have successfully downloaded the driver ("
                                                    + getDownlodedJarByName(connectiontypeComboBox.getText(),
                                                            versionComboBox.getText())
                                                    + ")." + "\n\nNote that the driver will not get deployed with "
                                                    + "other artifacts (in your CApp)."
                                                    + "\nBe sure to manually copy the driver from the \"dependencies\""
                                                    + " directory to \"<PRODUCT_HOME>/lib/\"");

                                }
                            });
                            scheduledExecutorService.shutdown();
                        }
                    } catch (LifecycleExecutionException e) {
                        Display.getDefault().syncExec(new Runnable() {
                            public void run() {
                                remove(dependencyDir + File.separator + TARGET);
                                MessageDialog.openInformation(shell, "An Error has occoured",
                                        "An error occurred when downloading the driver."
                                                + "\nMake sure that you are connected to the internet.");
                            }
                        });
                        log.error("Error while downloading depenency", e);
                        scheduledExecutorService.shutdown();
                    } catch (InterruptedException e) {
                        remove(dependencyDir + File.separator + TARGET);
                        remove(dependencyDir + File.separator + POM_XML);
                        scheduledExecutorService.shutdown();
                        log.error("Download was interrupted", e);
                    } catch (Throwable e) {
                        remove(dependencyDir + File.separator + TARGET);
                        remove(dependencyDir + File.separator + POM_XML);
                        scheduledExecutorService.shutdown();
                        log.error("Exception", e);
                    }
                }
            }, 0, TIME_INTERVAL, TimeUnit.SECONDS);
            scheduledExecutorService.awaitTermination(120, TimeUnit.SECONDS);
        };
    }
}
