/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.dataservice.ui.wizard;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.ComboDialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.LayoutUtil;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.SelectionButtonDialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.StringDialogField;
import org.eclipse.jface.bindings.keys.SWTKeyLookup;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.RegistryTreeBrowserDialog;
import org.wso2.developerstudio.eclipse.artifact.dataservice.model.DataServiceModel;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.ConnectionObj;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DependencyProvider;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class NewDataSourceWizardPage extends WizardPage {

    public static final int SELECTED_REGISTRY_RESOURCE = 8;
    private static final String SYMBOLIC_NAME = "org.wso2.developerstudio.eclipse.artifact.dataservice";

    /* avalable datasource types */
    private static String[] dataSourceType = new String[] { "RDBMS", "Cassandra", "CSV", "EXCEL", "RDF",
            "JNDI Datasource", "Google Spreadsheet", "Carbon Data Source", "Web Data Source" };
    private static String[] rdbmsType = new String[] { "MYSQL", "Apache Derby", "MSSQL", "ORACLE",
            "IBM DB2", "HSQLDB", "Informix", "PostgreSQL", "Sybase ASE", "H2", "Generic" };
    private static HashMap<String, String[]> rdbmsConfig = new HashMap<String, String[]>();
    private DataServiceModel model;

    /* RDF DS controls */

    private FieldDecoration fd;
    private Composite rdbmsContainer;
    private Composite cassandraContainer;
    private Composite composite;
    private Composite csvContainer;
    protected String dataSourceId = "";
    private Object[] cassandraControls;
    private Object[] rdbmsControls;
    private Object[] csvControls;
    private Composite excelContainer;
    private Object[] excelControls;
    private Composite rdfContainer;
    private Object[] rdfControls;
    private Composite cDataSourceContainer;
    private Object[] cDataSourceComponents;
    private Composite jndiContainer;
    private Object[] jndiControls;
    private Composite gSpreadSheetContainer;
    private Object[] gSpreadSheetControls;
    private Composite webDataSourceContainer;
    private Object[] webDataSourceControls;
    private File projectLocation;
    
	public NewDataSourceWizardPage() {
        super("New Data Source Wizard");
        setTitle("Data Source Wizard");
        setDescription("Create New Data Source Configuration");
        rdbmsConfig.put(rdbmsType[0], new String[] { "jdbc:mysql://[machine-name/ip]:[port]/[database-name]",
                "com.mysql.jdbc.Driver", "com.mysql.jdbc.jdbc2.optional.MysqlXADataSource" });
        rdbmsConfig.put(rdbmsType[1], new String[] { "jdbc:derby:[path-to-data-file]",
                "org.apache.derby.jdbc.EmbeddedDriver", "org.apache.derby.jdbc.EmbeddedXADataSource" });
        rdbmsConfig.put(rdbmsType[2], new String[] { "jdbc:sqlserver://[HOST]:[PORT1433];databaseName=[DB]",
                "com.microsoft.sqlserver.jdbc.SQLServerDriver", "com.microsoft.sqlserver.jdbc.SQLServerXADataSource" });
        rdbmsConfig.put(rdbmsType[3],
                new String[] { "jdbc:oracle:[drivertype]:[username/password]@[host]:[port]/[database]",
                        "oracle.jdbc.driver.OracleDriver", "oracle.jdbc.xa.client.OracleXADataSource" });
        rdbmsConfig.put(rdbmsType[4],
                new String[] { "jdbc:db2:[database]", "com.ibm.db2.jcc.DB2Driver", "com.ibm.db2.jcc.DB2XADataSource" });
        rdbmsConfig.put(rdbmsType[5], new String[] { "jdbc:hsqldb:[path]", "org.hsqldb.jdbcDriver",
                "org.hsqldb.jdbc.pool.JDBCXADataSource" });
        rdbmsConfig.put(rdbmsType[6],
                new String[] { "jdbc:informix-sqli://[HOST]:[PORT]/[database]:INFORMIXSERVER=[server-name]",
                        "com.informix.jdbc.IfxDriver", "com.informix.jdbc.jdbc2.optional.InformixXADataSource" });
        rdbmsConfig.put(rdbmsType[7], new String[] { "jdbc:postgresql://[HOST]:[PORT5432]/[database]",
                "org.postgresql.Driver", "org.postgresql.xa.PGXADataSource" });
        rdbmsConfig.put(rdbmsType[8], new String[] { "jdbc:sybase:Tds:[HOST]:[PORT2048]/[database]",
                "com.sybase.jdbc3.jdbc.SybDriver", "com.sybase.jdbc3.jdbc.SybXADataSource" });
        rdbmsConfig.put(rdbmsType[9], new String[] { "jdbc:h2:tcp:[HOST]:[PORT]/[database]", "org.h2.Driver",
                "org.h2.jdbcx.JdbcDataSource" });
        rdbmsConfig.put(rdbmsType[10], new String[] { "Generic", "Generic", "Generic" });
        
    }

    @SuppressWarnings({ "restriction", "static-access" })
    public void createControl(Composite parent) {
          
        model = (DataServiceModel) ((DataServiceCreationWizard) getWizard()).getModel();
        model.setDataSourceConfig(0);
        composite = new Composite(parent, SWT.NONE);
        composite.setFont(parent.getFont());
        composite.setLayout(initGridLayout(new GridLayout(1, false), true));
        composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

        createRDBMSComponents();
        rdbmsContainer.setVisible(true);

        createCassandraComponents();
        cassandraContainer.setVisible(false);

        createCSVComponents();
        csvContainer.setVisible(false);

        createExcelComponents();
        excelContainer.setVisible(false);

        createRDFComponents();
        rdfContainer.setVisible(false);
        
        createDataSourceComponents();
        cDataSourceContainer.setVisible(false);
        
        createJNDIcomponents();
        jndiContainer.setVisible(false);
        
        createGSpreadSheetComponents();
        gSpreadSheetContainer.setVisible(false);
        
        createWebDataSource();
        webDataSourceContainer.setVisible(false);
        
        setVisible(cassandraContainer, false);
        setVisible(csvContainer, false);
        setVisible(rdfContainer, false);
        setVisible(cDataSourceContainer, false);
        setVisible(jndiContainer, false);
        setVisible(gSpreadSheetContainer, false);
        setVisible(webDataSourceContainer, false);
        
        setControl(composite);
        setPageComplete(false);getContainer().updateButtons();

    }

    @SuppressWarnings("restriction")
    private void createDataSourceTypeComponent(final StringDialogField dataSourceIdField,
            final ComboDialogField dataSourceTypeField, final int selectionIndex) {

        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {

                hideAllComposites();

                int selectedIndex = dataSourceTypeField.getComboControl(null).getSelectionIndex();
                if (rdbmsType.length > selectedIndex && selectedIndex != -1) {
                    model.setDataSourceConfig(selectedIndex);
                    switch (selectedIndex) {
                    case 0:
                        ((GridData) rdbmsContainer.getLayoutData()).exclude = false;
                        rdbmsContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) rdbmsControls[0]).setText(dataSourceId);
                        break;
                    case 1:
                        ((GridData) cassandraContainer.getLayoutData()).exclude = false;
                        cassandraContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) cassandraControls[0]).setText(dataSourceId);
                        break;
                    case 2:
                        ((GridData) csvContainer.getLayoutData()).exclude = false;
                        csvContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) csvControls[0]).setText(dataSourceId);
                        break;
                    case 3:
                        ((GridData) excelContainer.getLayoutData()).exclude = false;
                        excelContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) excelControls[0]).setText(dataSourceId);
                        break;
                    case 4:
                        ((GridData) rdfContainer.getLayoutData()).exclude = false;
                        rdfContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) rdfControls[0]).setText(dataSourceId);
                        break;
                    case 5:
                        ((GridData) jndiContainer.getLayoutData()).exclude = false;
                        jndiContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) jndiControls[0]).setText(dataSourceId);
                        break;
                    case 6:
                        ((GridData) gSpreadSheetContainer.getLayoutData()).exclude = false;
                        gSpreadSheetContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) gSpreadSheetControls[0]).setText(dataSourceId);
                        break;
                    case 7:
                        ((GridData) cDataSourceContainer.getLayoutData()).exclude = false;
                        cDataSourceContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) cDataSourceComponents[0]).setText(dataSourceId);
                        break;
                    case 8:
                        ((GridData) webDataSourceContainer.getLayoutData()).exclude = false;
                        webDataSourceContainer.setVisible(true);
                        composite.layout();
                        ((StringDialogField) webDataSourceControls[0]).setText(dataSourceId);
                        break;
                    default:
                        setPageComplete(false);
                        break;
                    }

                }
                dataSourceTypeField.getComboControl(null).select(selectionIndex);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
        dataSourceTypeField.getComboControl(null).addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
    }
    
    @SuppressWarnings({ "restriction", "static-access" })
    private void createRDBMSComponents() {
        rdbmsContainer = new Composite(composite, SWT.NONE);
        rdbmsContainer.setFont(composite.getFont());
        rdbmsContainer.setLayout(new GridLayout(8, false));
        rdbmsContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(rdbmsContainer, 8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(0);
        dataSourceTypeField.doFillIntoGrid(rdbmsContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 0);
        
        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final ComboDialogField dbEngineType = new ComboDialogField(SWT.READ_ONLY);
        dbEngineType.setLabelText("Database Engine  ");
        dbEngineType.setItems(rdbmsType);
        dbEngineType.doFillIntoGrid(rdbmsContainer, 5);
        dbEngineType.getComboControl(null).addListener(SWT.MouseVerticalWheel, new Listener() {

            @Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });

        ControlDecoration cdcmbDatabaseEngine = new ControlDecoration(dbEngineType.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDatabaseEngine.setDescriptionText("Select Database Engine");
        cdcmbDatabaseEngine.setImage(fd.getImage());

        Button configure = new Button(rdbmsContainer, SWT.NONE);
        configure.setText("Configure");

        final SelectionButtonDialogField chkXADatasource = new SelectionButtonDialogField(SWT.CHECK);
        chkXADatasource.setLabelText("XA-Datasource");
        chkXADatasource.doFillIntoGrid(rdbmsContainer, 2);

        final StringDialogField driverClassField = new StringDialogField();
        driverClassField.setLabelText("Driver Class");
        driverClassField.doFillIntoGrid(rdbmsContainer, 8);
        LayoutUtil.setHorizontalGrabbing(driverClassField.getTextControl(null));

        final StringDialogField xaDataSourceClassField = new StringDialogField();
        xaDataSourceClassField.setLabelText("XA-Datasource\n Class");
        xaDataSourceClassField.doFillIntoGrid(rdbmsContainer, 8);
        LayoutUtil.setHorizontalGrabbing(driverClassField.getTextControl(null));
        setVisible(xaDataSourceClassField, false);

        final ControlDecoration cdtxtXADatasourceClass = new ControlDecoration(
                xaDataSourceClassField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtXADatasourceClass.setDescriptionText("XA-Datasource Required");
        cdtxtXADatasourceClass.setImage(fd.getImage());
        cdtxtXADatasourceClass.hide();

        final ControlDecoration cdtxtDriverClass = new ControlDecoration(driverClassField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDriverClass.setDescriptionText("JDBC Driver Required");
        cdtxtDriverClass.setImage(fd.getImage());

        final StringDialogField jdbcURLField = new StringDialogField();
        jdbcURLField.setLabelText("JDBC URL");
        jdbcURLField.doFillIntoGrid(rdbmsContainer, 8);
        LayoutUtil.setHorizontalGrabbing(jdbcURLField.getTextControl(null));

        ControlDecoration cdtxtJdbcUrl = new ControlDecoration(jdbcURLField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtJdbcUrl.setDescriptionText("JDBC Url Required");
        cdtxtJdbcUrl.setImage(fd.getImage());

        final StringDialogField usernameField = new StringDialogField();
        usernameField.setLabelText("Username");
        usernameField.doFillIntoGrid(rdbmsContainer, 3);
        LayoutUtil.setHorizontalGrabbing(usernameField.getTextControl(null));

        final ControlDecoration cdtxtUserName = new ControlDecoration(usernameField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtUserName.setDescriptionText("UserName required");
        cdtxtUserName.setImage(fd.getImage());

        final StringDialogField passwordField = new StringDialogField();
        passwordField.setLabelText("Password");
        passwordField.createEmptySpace(rdbmsContainer, 5);
        passwordField.doFillIntoGrid(rdbmsContainer, 3);
        passwordField.getTextControl(null).setEchoChar('*');
        LayoutUtil.setHorizontalGrabbing(passwordField.getTextControl(null));

        final ControlDecoration cd_txtPassword = new ControlDecoration(passwordField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cd_txtPassword.setDescriptionText("Password is required");
        cd_txtPassword.setImage(fd.getImage());

        final StringDialogField secretAliasPasswordField = new StringDialogField();
        secretAliasPasswordField.setLabelText("Password");
        secretAliasPasswordField.doFillIntoGrid(rdbmsContainer, 3);
        LayoutUtil.setHorizontalGrabbing(secretAliasPasswordField.getTextControl(null));
        setVisible(secretAliasPasswordField, false);

        final ControlDecoration cd_txtSecretAliasPassword = new ControlDecoration(
                secretAliasPasswordField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cd_txtSecretAliasPassword.setDescriptionText("Secret alias name is required");
        cd_txtSecretAliasPassword.setImage(fd.getImage());
        cd_txtSecretAliasPassword.hide();

        final SelectionButtonDialogField checkSecretAliasField = new SelectionButtonDialogField(SWT.CHECK);
        checkSecretAliasField.setLabelText("Use as Secret Alias");
        checkSecretAliasField.doFillIntoGrid(rdbmsContainer, 2);
        checkSecretAliasField.createEmptySpace(rdbmsContainer, 6);

        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		usernameField.setText(""); 
                passwordField.setText(""); 
                secretAliasPasswordField.setText(""); 
                xaDataSourceClassField.setText("");
                chkXADatasource.setSelection(false);
                
                dbEngineType.selectItem(0);
                checkSecretAliasField.setSelection(false);
        	}
		});
        
        checkSecretAliasField.getSelectionButton(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
                if (checkSecretAliasField.isSelected()) {
                    cd_txtSecretAliasPassword.show();
                    cd_txtPassword.hide();

                    setVisible(passwordField, false);
                    setVisible(secretAliasPasswordField, true);

                    rdbmsContainer.layout();

                } else {
                    cd_txtPassword.show();
                    cd_txtSecretAliasPassword.hide();

                    setVisible(passwordField, true);
                    setVisible(secretAliasPasswordField, false);

                    rdbmsContainer.layout();
                }
        	}
		});
        
        chkXADatasource.getSelectionButton(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		if (chkXADatasource.isSelected()) {
                    cdtxtXADatasourceClass.show();
                    cdtxtDriverClass.hide();

                    setVisible(driverClassField, false);
                    setVisible(xaDataSourceClassField, true);

                    rdbmsContainer.layout();

                } else {
                    cdtxtDriverClass.show();
                    cdtxtXADatasourceClass.hide();

                    setVisible(driverClassField, true);
                    setVisible(xaDataSourceClassField, false);

                    rdbmsContainer.layout();
                }
        	}
		});
        
        dbEngineType.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		int selectedIndex = dbEngineType.getSelectionIndex();
                if (rdbmsType.length > selectedIndex && selectedIndex != -1) {
                    if (rdbmsConfig.containsKey(rdbmsType[selectedIndex])) {
                        jdbcURLField.getTextControl(null).setText(rdbmsConfig.get(rdbmsType[selectedIndex])[0]);
                        driverClassField.getTextControl(null).setText(rdbmsConfig.get(rdbmsType[selectedIndex])[1]);
                        xaDataSourceClassField.getTextControl(null)
                                .setText(rdbmsConfig.get(rdbmsType[selectedIndex])[2]);
                    }
                }
        	}
		});

        configure.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
				Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();
                DependencyProvider dp = new DependencyProvider(shell, SWT.NONE, getProjectLocation().getName(), rdbmsType);
                ConnectionObj obj = new ConnectionObj();
                obj.setDbDriver("");
                obj.setDbType(dbEngineType.getText().isEmpty() ? ""
                        : dbEngineType.getText());
                obj.setPassword("");
                obj.setUrl("");
                obj.setUserName("");
                obj.setJarPath("");
                dp.open(obj);
                jdbcURLField.setText(obj.getUrl());
                usernameField.setText(obj.getUserName());
                passwordField.setText(obj.getPassword());
        	}
		});

        ModifyListener rdbmsFieldListener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				boolean isXA = chkXADatasource.isSelected();
                model.getRdbmsConfig()
                        .setDriverClass(driverClassField.getText() == null ? "" : driverClassField.getText());
                model.getRdbmsConfig()
                        .setXaDsClass(xaDataSourceClassField.getText() == null ? "" : xaDataSourceClassField.getText());
                model.getRdbmsConfig().setJdbcUrl(jdbcURLField.getText() == null ? "" : jdbcURLField.getText());
                model.getRdbmsConfig().setJdbcUser(usernameField.getText() == null ? "" : usernameField.getText());
                boolean isSecretAliasEnabled = checkSecretAliasField.isSelected();
                model.getRdbmsConfig().setSecretAlias(isSecretAliasEnabled);
                if (isSecretAliasEnabled) {
                    model.getRdbmsConfig().setJdbcPassword(secretAliasPasswordField.getText());
                } else {
                    model.getRdbmsConfig().setJdbcPassword(passwordField.getText());
                }
                if (isXA) {
                    if (xaDataSourceClassField.getText().trim().equals("") || jdbcURLField.getText().trim().equals("")
                            || dataSourceIdField.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                } else {
                    if (driverClassField.getText().trim().equals("") || jdbcURLField.getText().trim().equals("")
                            || dataSourceIdField.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                }
			}};
        
       
        jdbcURLField.getTextControl(null).setText(rdbmsConfig.get(rdbmsType[0])[0]);
        driverClassField.getTextControl(null).setText(rdbmsConfig.get(rdbmsType[0])[1]);
        xaDataSourceClassField.getTextControl(null).setText(rdbmsConfig.get(rdbmsType[0])[2]);

        dbEngineType.getComboControl(null).addModifyListener(rdbmsFieldListener);
        xaDataSourceClassField.getTextControl(null).addModifyListener(rdbmsFieldListener);
        driverClassField.getTextControl(null).addModifyListener(rdbmsFieldListener);
        jdbcURLField.getTextControl(null).addModifyListener(rdbmsFieldListener);
        usernameField.getTextControl(null).addModifyListener(rdbmsFieldListener);
        passwordField.getTextControl(null).addModifyListener(rdbmsFieldListener);
        secretAliasPasswordField.getTextControl(null).addModifyListener(rdbmsFieldListener);

        dbEngineType.selectItem(0);

        rdbmsControls = new DialogField[] { dataSourceIdField, dataSourceTypeField, checkSecretAliasField,
                usernameField, passwordField, secretAliasPasswordField, dbEngineType, jdbcURLField, driverClassField,
                chkXADatasource, xaDataSourceClassField };

    }
    
    @SuppressWarnings({ "restriction", "static-access" })
    private void createCassandraComponents() {
        cassandraContainer = new Composite(composite, SWT.NONE);
        cassandraContainer.setFont(composite.getFont());
        cassandraContainer.setLayout(new GridLayout(8, false));
        cassandraContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(cassandraContainer, 8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(1);
        dataSourceTypeField.doFillIntoGrid(cassandraContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 1);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final StringDialogField cassandraServerUrlField = new StringDialogField();
        cassandraServerUrlField.setLabelText("Server URL");
        cassandraServerUrlField.doFillIntoGrid(cassandraContainer, 8);
        LayoutUtil.setHorizontalGrabbing(cassandraServerUrlField.getTextControl(null));

        ControlDecoration cdtxtCassandraServerUrl = new ControlDecoration(cassandraServerUrlField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtCassandraServerUrl.setDescriptionText("Cassandra Server URL required");
        cdtxtCassandraServerUrl.setImage(fd.getImage());

        final StringDialogField cassandraUserNameField = new StringDialogField();
        cassandraUserNameField.setLabelText("Username");
        cassandraUserNameField.doFillIntoGrid(cassandraContainer, 2);

        StringDialogField emptyField = new StringDialogField();
        emptyField.doFillIntoGrid(cassandraContainer, 3);
        LayoutUtil.setHorizontalGrabbing(emptyField.getTextControl(null));
        emptyField.getTextControl(null).setVisible(false);

        emptyField = new StringDialogField();
        emptyField.setLabelText("");
        emptyField.doFillIntoGrid(cassandraContainer, 3);
        LayoutUtil.setHorizontalGrabbing(emptyField.getTextControl(null));
        emptyField.getTextControl(null).setVisible(false);

        ControlDecoration cdtxtCassandraUserName = new ControlDecoration(cassandraUserNameField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtCassandraUserName.setDescriptionText("User Name required");
        cdtxtCassandraUserName.setImage(fd.getImage());

        final StringDialogField cassandraPasswordField = new StringDialogField();
        cassandraPasswordField.setLabelText("Password");
        cassandraPasswordField.doFillIntoGrid(cassandraContainer, 2);
        cassandraPasswordField.getTextControl(null).setEchoChar('*');
        LayoutUtil.setHorizontalGrabbing(cassandraPasswordField.getTextControl(null));

        final ControlDecoration cdtxtCassandraPassword = new ControlDecoration(
                cassandraPasswordField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtCassandraPassword.setDescriptionText("Password required");
        cdtxtCassandraPassword.setImage(fd.getImage());

        final StringDialogField cassandraSecretAliasPasswordField = new StringDialogField();
        cassandraSecretAliasPasswordField.setLabelText("Password");
        cassandraSecretAliasPasswordField.doFillIntoGrid(cassandraContainer, 2);
        LayoutUtil.setHorizontalGrabbing(cassandraSecretAliasPasswordField.getTextControl(null));
        setVisible(cassandraSecretAliasPasswordField, false);

        final ControlDecoration cd_txtCassandraSecretAliasPassword = new ControlDecoration(
                cassandraSecretAliasPasswordField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cd_txtCassandraSecretAliasPassword.setDescriptionText("Secret alias name for Cassandra db is required");
        cd_txtCassandraSecretAliasPassword.setImage(fd.getImage());
        cd_txtCassandraSecretAliasPassword.hide();

        final SelectionButtonDialogField checkSecretAliasCassandraField = new SelectionButtonDialogField(SWT.CHECK);
        checkSecretAliasCassandraField.setLabelText("Use as Secret Alias");
        checkSecretAliasCassandraField.doFillIntoGrid(cassandraContainer, 3);
        checkSecretAliasCassandraField.createEmptySpace(cassandraContainer, 2);

       
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				cassandraServerUrlField.setText(""); 
                cassandraUserNameField.setText("");
                cassandraPasswordField.setText(""); 
                cassandraSecretAliasPasswordField.setText(""); 
                
                checkSecretAliasCassandraField.setSelection(false);
			}
        });
        
		checkSecretAliasCassandraField.getSelectionButton(null).addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				if (checkSecretAliasCassandraField.isSelected()) {
					cd_txtCassandraSecretAliasPassword.show();
					cdtxtCassandraPassword.hide();

					setVisible(cassandraPasswordField, false);
					setVisible(cassandraSecretAliasPasswordField, true);

					cassandraContainer.layout();

				} else {
					cdtxtCassandraPassword.show();
					cd_txtCassandraSecretAliasPassword.hide();

					setVisible(cassandraPasswordField, true);
					setVisible(cassandraSecretAliasPasswordField, false);

					cassandraContainer.layout();
				}
			}
		});

        ModifyListener cassandraModifyListener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.getCassandraConfig().setServerURL(cassandraServerUrlField.getText());
                model.getCassandraConfig().setUserName(cassandraUserNameField.getText());
                boolean isSecretAliasEnabled = checkSecretAliasCassandraField.isSelected();
                model.getCassandraConfig().setSecretAlias(isSecretAliasEnabled);
                if (isSecretAliasEnabled) {
                    model.getCassandraConfig().setPassword(cassandraSecretAliasPasswordField.getText());
                } else {
                    model.getCassandraConfig().setPassword(cassandraPasswordField.getText());
                }
                if (cassandraServerUrlField.getText().trim().equals("")
                        || cassandraUserNameField.getText().trim().equals("")
                        || cassandraPasswordField.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }

			}};

        cassandraServerUrlField.getTextControl(null).addModifyListener(cassandraModifyListener);
        cassandraUserNameField.getTextControl(null).addModifyListener(cassandraModifyListener);
        cassandraPasswordField.getTextControl(null).addModifyListener(cassandraModifyListener);
        cassandraSecretAliasPasswordField.getTextControl(null).addModifyListener(cassandraModifyListener);

        cassandraControls = new DialogField[] { dataSourceIdField, dataSourceTypeField, checkSecretAliasCassandraField,
                cassandraSecretAliasPasswordField, cassandraServerUrlField, cassandraUserNameField,
                cassandraPasswordField };
    }

    @SuppressWarnings({ "restriction", "static-access" })
    private void createCSVComponents() {
        csvContainer = new Composite(composite, SWT.NONE);
        csvContainer.setFont(composite.getFont());
        csvContainer.setLayout(new GridLayout(8, false));
        csvContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(csvContainer, 8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});
		
        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(2);
        dataSourceTypeField.doFillIntoGrid(csvContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 2);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final StringDialogField csvFileLocationField = new StringDialogField();
        csvFileLocationField.setLabelText("CSV File Location");
        csvFileLocationField.doFillIntoGrid(csvContainer, 6);
        LayoutUtil.setHorizontalGrabbing(csvFileLocationField.getTextControl(null));

        ControlDecoration cdtxtCsvFileLocation = new ControlDecoration(csvFileLocationField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtCsvFileLocation.setDescriptionText("CSV file location required");
        cdtxtCsvFileLocation.setImage(fd.getImage());

        Button cmdCsvKeyConRegBrowse = new Button(csvContainer, SWT.NONE);
        cmdCsvKeyConRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry-16x16.png"));
        cmdCsvKeyConRegBrowse.setToolTipText("Configuration registry");
        cmdCsvKeyConRegBrowse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                selectRegistryResource(csvFileLocationField.getTextControl(null), 2);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });

        Button cmdCsvKeyGovRegBrowse = new Button(csvContainer, SWT.NONE);
        cmdCsvKeyGovRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry_picker.gif"));
        cmdCsvKeyGovRegBrowse.setToolTipText("Governance registry");
        cmdCsvKeyGovRegBrowse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                selectRegistryResource(csvFileLocationField.getTextControl(null), 3);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });

        final StringDialogField columnSeperatorField = new StringDialogField();
        columnSeperatorField.setLabelText("Column Seperator");
        columnSeperatorField.doFillIntoGrid(csvContainer, 2);
        columnSeperatorField.createEmptySpace(csvContainer, 6);

        final StringDialogField startReadingFromField = new StringDialogField();
        startReadingFromField.setLabelText("Start From Row");
        startReadingFromField.doFillIntoGrid(csvContainer, 2);
        startReadingFromField.createEmptySpace(csvContainer, 6);

        final StringDialogField maxRowsToField = new StringDialogField();
        maxRowsToField.setLabelText("Max Rows To Read");
        maxRowsToField.doFillIntoGrid(csvContainer, 2);
        maxRowsToField.createEmptySpace(csvContainer, 6);

        Label lblColumnHeaderRow = new Label(csvContainer, SWT.NONE);
        lblColumnHeaderRow.setText("Contains Column \nHeader Row");

        final Button chkColumnHeaderRow = new Button(csvContainer, SWT.CHECK);
        
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		csvFileLocationField.setText(""); 
                columnSeperatorField.setText("");
                startReadingFromField.setText(""); 
                maxRowsToField.setText(""); 
                
                chkColumnHeaderRow.setSelection(false);
        	}
		});

        chkColumnHeaderRow.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                model.getCsvConfig().setContainsColumnHeaderRow(chkColumnHeaderRow.getSelection());
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);

            }
        });

        ModifyListener csvFieldListener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.getCsvConfig().setCsvFileLocation(csvFileLocationField.getText());
                model.getCsvConfig().setColumnSeperator(columnSeperatorField.getText());
                try {
                    model.getCsvConfig().setStartReadingFromRow(
                            Integer.parseInt(startReadingFromField.getText()));
                    model.getCsvConfig()
                            .setMaxRowsToRead(Integer.parseInt(maxRowsToField.getText()));
                } catch (NumberFormatException nfe) {
                    if (!(startReadingFromField.getText().trim().equals("")
                            || maxRowsToField.getText().trim().equals(""))) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing or invalid");
                        return;
                    }
                }
                if (csvFileLocationField.getText().trim().equals("")
                        || dataSourceIdField.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
			}};
        
        csvFileLocationField.getTextControl(null).addModifyListener(csvFieldListener);
        columnSeperatorField.getTextControl(null).addModifyListener(csvFieldListener);
        startReadingFromField.getTextControl(null).addModifyListener(csvFieldListener);
        maxRowsToField.getTextControl(null).addModifyListener(csvFieldListener);
        
        csvControls = new Object[] { dataSourceIdField, dataSourceTypeField, csvFileLocationField,
                cmdCsvKeyConRegBrowse, cmdCsvKeyGovRegBrowse, columnSeperatorField, startReadingFromField , maxRowsToField , chkColumnHeaderRow};
    }
    
    @SuppressWarnings("restriction")
    private void createExcelComponents() {
        // TODO Auto-generated method stub
        excelContainer = new Composite(composite, SWT.NONE);
        excelContainer.setFont(composite.getFont());
        excelContainer.setLayout(new GridLayout(8, false));
        excelContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        
        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(excelContainer, 8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(3);
        dataSourceTypeField.doFillIntoGrid(excelContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 3);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final StringDialogField excelFileLocationField = new StringDialogField();
        excelFileLocationField.setLabelText("EXCEL File Location");
        excelFileLocationField.doFillIntoGrid(excelContainer, 6);
        LayoutUtil.setHorizontalGrabbing(excelFileLocationField.getTextControl(null));

        ControlDecoration cdtxtExcelFileLocation = new ControlDecoration(excelFileLocationField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtExcelFileLocation.setDescriptionText("Excel file location required");
        cdtxtExcelFileLocation.setImage(fd.getImage());
        
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		excelFileLocationField.setText(""); 
        	}
		});
        
        Button cmdExcelKeyConRegBrowse = new Button(excelContainer, SWT.NONE);
        cmdExcelKeyConRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry-16x16.png"));
        cmdExcelKeyConRegBrowse.setToolTipText("Configuration registry");
        cmdExcelKeyConRegBrowse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                selectRegistryResource(excelFileLocationField.getTextControl(null), 2);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });

        Button cmdExcelKeyGovRegBrowse = new Button(excelContainer, SWT.NONE);
        cmdExcelKeyGovRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry_picker.gif"));
        cmdExcelKeyGovRegBrowse.setToolTipText("Governance registry");
        cmdExcelKeyGovRegBrowse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                selectRegistryResource(excelFileLocationField.getTextControl(null), 3);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });

        excelFileLocationField.getTextControl(null).addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
                model.getExcelConfig().setExcelFileLocation(excelFileLocationField.getText());
                if (excelFileLocationField.getText().trim().equals("") || dataSourceIdField.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
			}
		});
        
        excelControls = new Object [] {dataSourceIdField , dataSourceTypeField , excelFileLocationField , cmdExcelKeyConRegBrowse , cmdExcelKeyGovRegBrowse};

    } 

    @SuppressWarnings("restriction")
    private void createRDFComponents() {
        rdfContainer = new Composite(composite, SWT.NONE);
        rdfContainer.setFont(composite.getFont());
        rdfContainer.setLayout(new GridLayout(8, false));
        rdfContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        
        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(rdfContainer, 8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(4);
        dataSourceTypeField.doFillIntoGrid(rdfContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 4);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final StringDialogField rdfFileLocationField = new StringDialogField();
        rdfFileLocationField.setLabelText("RDF File Location");
        rdfFileLocationField.doFillIntoGrid(rdfContainer, 6);
        LayoutUtil.setHorizontalGrabbing(rdfFileLocationField.getTextControl(null));

        ControlDecoration cdtxtRDFFileLocation = new ControlDecoration(rdfFileLocationField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtRDFFileLocation.setDescriptionText("RDF file location required");
        cdtxtRDFFileLocation.setImage(fd.getImage());
        
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		rdfFileLocationField.setText("");
        	}
		});
        
        Button cmdRdfKeyConRegBrowse = new Button(rdfContainer, SWT.NONE);
        cmdRdfKeyConRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry-16x16.png"));
        cmdRdfKeyConRegBrowse.setToolTipText("Configuration registry");
        cmdRdfKeyConRegBrowse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                selectRegistryResource(rdfFileLocationField.getTextControl(null), 2);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });

        Button cmdRdfKeyGovRegBrowse = new Button(rdfContainer, SWT.NONE);
        cmdRdfKeyGovRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry_picker.gif"));
        cmdRdfKeyGovRegBrowse.setToolTipText("Governance registry");
        cmdRdfKeyGovRegBrowse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                selectRegistryResource(rdfFileLocationField.getTextControl(null), 3);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });
        
        rdfFileLocationField.getTextControl(null).addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
                model.getRdfConfig().setRdfFileLocation(rdfFileLocationField.getText());
                if (rdfFileLocationField.getText().trim().equals("") || dataSourceIdField.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
			}
		});
        
        rdfControls = new Object [] {dataSourceIdField , dataSourceTypeField , cmdRdfKeyConRegBrowse , cmdRdfKeyGovRegBrowse};
    }
    
    @SuppressWarnings({ "restriction", "static-access" })
    private void createJNDIcomponents() {
        // TODO Auto-generated method stub
        jndiContainer = new Composite(composite, SWT.NONE);
        jndiContainer.setFont(composite.getFont());
        jndiContainer.setLayout(new GridLayout(8, false));
        jndiContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(jndiContainer, 8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(5);
        dataSourceTypeField.doFillIntoGrid(jndiContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 5);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final StringDialogField jndiContextClassField = new StringDialogField();
        jndiContextClassField.setLabelText("JNDI Context Class");
        jndiContextClassField.doFillIntoGrid(jndiContainer, 8);
        LayoutUtil.setHorizontalGrabbing(jndiContextClassField.getTextControl(null));
        
        ControlDecoration cdtxtJndiContextClass = new ControlDecoration(jndiContextClassField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtJndiContextClass.setDescriptionText("JNDI Context Class required");
        cdtxtJndiContextClass.setImage(fd.getImage());
        
        final StringDialogField providerURLField = new StringDialogField();
        providerURLField.setLabelText("Provider URL");
        providerURLField.doFillIntoGrid(jndiContainer, 8);
        LayoutUtil.setHorizontalGrabbing(providerURLField.getTextControl(null));
        
        ControlDecoration cdtxtProviderUrl = new ControlDecoration(providerURLField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtProviderUrl.setDescriptionText("Provider URL required");
        cdtxtProviderUrl.setImage(fd.getImage());
        
        final StringDialogField resourceNameField = new StringDialogField();
        resourceNameField.setLabelText("Resource Name");
        resourceNameField.doFillIntoGrid(jndiContainer, 2);

        StringDialogField emptyField = new StringDialogField();
        emptyField.doFillIntoGrid(jndiContainer, 3);
        LayoutUtil.setHorizontalGrabbing(emptyField.getTextControl(null));
        emptyField.getTextControl(null).setVisible(false);

        emptyField = new StringDialogField();
        emptyField.setLabelText("");
        emptyField.doFillIntoGrid(jndiContainer, 3);
        LayoutUtil.setHorizontalGrabbing(emptyField.getTextControl(null));
        emptyField.getTextControl(null).setVisible(false);

        ControlDecoration cdtxtResourceName = new ControlDecoration(resourceNameField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtResourceName.setDescriptionText("Resource Name required");
        cdtxtResourceName.setImage(fd.getImage());

        final StringDialogField jndiPasswordField = new StringDialogField();
        jndiPasswordField.setLabelText("Password");
        jndiPasswordField.doFillIntoGrid(jndiContainer, 2);
        jndiPasswordField.getTextControl(null).setEchoChar('*');
        LayoutUtil.setHorizontalGrabbing(jndiPasswordField.getTextControl(null));

        final ControlDecoration cdtxtJndiPassword = new ControlDecoration(jndiPasswordField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtJndiPassword.setDescriptionText("password required");
        cdtxtJndiPassword.setImage(fd.getImage());

        final StringDialogField jndiSecretAliasPasswordField = new StringDialogField();
        jndiSecretAliasPasswordField.setLabelText("Password");
        jndiSecretAliasPasswordField.doFillIntoGrid(jndiContainer, 2);
        LayoutUtil.setHorizontalGrabbing(jndiSecretAliasPasswordField.getTextControl(null));
        setVisible(jndiSecretAliasPasswordField, false);


        final ControlDecoration cdtxtJNDISecretAliasPassword = new ControlDecoration(jndiSecretAliasPasswordField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtJNDISecretAliasPassword.setDescriptionText("Secret alias name is required for JNDI");

        final SelectionButtonDialogField checkSecretAliasJNDIField = new SelectionButtonDialogField(SWT.CHECK);
        checkSecretAliasJNDIField.setLabelText("Use as Secret Alias");
        checkSecretAliasJNDIField.doFillIntoGrid(jndiContainer, 3);
        checkSecretAliasJNDIField.createEmptySpace(jndiContainer, 2);
        
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		jndiContextClassField.setText(""); 
            	providerURLField.setText("");
            	resourceNameField.setText("");
            	jndiPasswordField.setText("");
            	jndiSecretAliasPasswordField.setText("");
        	}
		});
        
        checkSecretAliasJNDIField.getSelectionButton(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		if (checkSecretAliasJNDIField.isSelected()) {
                    cdtxtJNDISecretAliasPassword.show();
                    cdtxtJndiPassword.hide();

                    setVisible(jndiPasswordField, false);
                    setVisible(jndiSecretAliasPasswordField, true);

                    jndiContainer.layout();

                } else {
                    cdtxtJndiPassword.show();
                    cdtxtJNDISecretAliasPassword.hide();

                    setVisible(jndiPasswordField, true);
                    setVisible(jndiSecretAliasPasswordField, false);

                    jndiContainer.layout();
                }
        	}
        });

        ModifyListener jndiModifyListener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				 model.getJndiConfig().setJndiContextClass(jndiContextClassField.getText());
	                model.getJndiConfig().setProvideUrl(providerURLField.getText());
	                model.getJndiConfig().setResourceName(resourceNameField.getText());
	                boolean isSecretAliasEnabled = checkSecretAliasJNDIField.isSelected();
	                model.getJndiConfig().setSecretAlias(isSecretAliasEnabled);
	                if (isSecretAliasEnabled) {
	                    model.getJndiConfig().setPassword(jndiSecretAliasPasswordField.getText());
	                } else {
	                    model.getJndiConfig().setPassword(jndiPasswordField.getText());
	                }
	                if (jndiContextClassField.getText().trim().equals("") || providerURLField.getText().trim().equals("")
	                        || resourceNameField.getText().trim().equals("") || jndiPasswordField.getText().trim().equals("")
	                        || dataSourceIdField.getText().trim().equals("")) {
	                    setPageComplete(false);
	                    setErrorMessage("Required Field(s) are missing or invalid");
	                } else {
	                    setPageComplete(true);
	                    setErrorMessage(null);
	                }
			}};

        jndiContextClassField.getTextControl(null).addModifyListener(jndiModifyListener);
        providerURLField.getTextControl(null).addModifyListener(jndiModifyListener);
        resourceNameField.getTextControl(null).addModifyListener(jndiModifyListener);
        jndiPasswordField.getTextControl(null).addModifyListener(jndiModifyListener);
        
        jndiControls = new Object[] { dataSourceIdField, dataSourceTypeField, jndiContextClassField, providerURLField,
                resourceNameField, jndiPasswordField, jndiSecretAliasPasswordField, checkSecretAliasJNDIField };
    } 

    @SuppressWarnings({ "restriction", "static-access" })
    private void createGSpreadSheetComponents() {
        // TODO Auto-generated method stub
        gSpreadSheetContainer = new Composite(composite, SWT.NONE);
        gSpreadSheetContainer.setFont(composite.getFont());
        gSpreadSheetContainer.setLayout(new GridLayout(8, false));
        gSpreadSheetContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(gSpreadSheetContainer,8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(6);
        dataSourceTypeField.doFillIntoGrid(gSpreadSheetContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 6);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final StringDialogField googleSpreadsheetUrlField = new StringDialogField();
        googleSpreadsheetUrlField.setLabelText("Spreadsheet URL");
        googleSpreadsheetUrlField.doFillIntoGrid(gSpreadSheetContainer, 8);
        LayoutUtil.setHorizontalGrabbing(googleSpreadsheetUrlField.getTextControl(null));
        
        ControlDecoration cdtxtlblGoogleSpreadsheetUrl = new ControlDecoration(googleSpreadsheetUrlField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtlblGoogleSpreadsheetUrl.setDescriptionText("Spreadsheet Url required");
        cdtxtlblGoogleSpreadsheetUrl.setImage(fd.getImage());
        
        Label lblVisibility = new Label(gSpreadSheetContainer, SWT.NONE);
        lblVisibility.setText("Visibility");
        
        final SelectionButtonDialogField optPublicField = new SelectionButtonDialogField(SWT.RADIO);
        optPublicField.setLabelText("Public");
        optPublicField.doFillIntoGrid(gSpreadSheetContainer, 1);
        
        final SelectionButtonDialogField optPrivate = new SelectionButtonDialogField(SWT.RADIO);
        optPrivate.setLabelText("Private");
        optPrivate.doFillIntoGrid(gSpreadSheetContainer, 1);
        optPrivate.createEmptySpace(gSpreadSheetContainer, 5);
        
        final StringDialogField googleUserNameField = new StringDialogField();
        googleUserNameField.setLabelText("User Name");
        googleUserNameField.doFillIntoGrid(gSpreadSheetContainer, 3);
        googleUserNameField.createEmptySpace(gSpreadSheetContainer, 5);
        
        googleUserNameField.getTextControl(null).setVisible(false);
        googleUserNameField.getLabelControl(null).setVisible(false);

        final ControlDecoration cdtxtGoogleUserName = new ControlDecoration(googleUserNameField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtGoogleUserName.setDescriptionText("UserName required");
        cdtxtGoogleUserName.setImage(fd.getImage());

        final StringDialogField googlePasswordField = new StringDialogField();
        googlePasswordField.setLabelText("Password");
        
        googlePasswordField.doFillIntoGrid(gSpreadSheetContainer, 3);
        googlePasswordField.createEmptySpace(gSpreadSheetContainer, 5);
        googlePasswordField.getTextControl(null).setEchoChar('*');
        googlePasswordField.getTextControl(null).setVisible(false);
        googlePasswordField.getLabelControl(null).setVisible(false);
        
        final ControlDecoration cdtxtGooglePassword = new ControlDecoration(googlePasswordField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtGooglePassword.setDescriptionText("password required");
        cdtxtGooglePassword.setImage(fd.getImage());
        
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		googleSpreadsheetUrlField.setText("");
            	googlePasswordField.setText("");
            	googleUserNameField.setText("");
        	}
		});

        final ModifyListener gSpreadSheetModifyListener = new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                // TODO Auto-generated method stub
                model.getGoogleSpreadsheetConfig().setSpreadsheetURL(googleSpreadsheetUrlField.getText());
                model.getGoogleSpreadsheetConfig().setPublicVisible(optPublicField.isSelected());
                model.getGoogleSpreadsheetConfig().setUserName(googleUserNameField.getText());
                model.getGoogleSpreadsheetConfig().setPassword(googlePasswordField.getText());
                if (optPublicField.isSelected()) {
                    cdtxtGoogleUserName.hide();
                    cdtxtGooglePassword.hide();
                    if (googleSpreadsheetUrlField.getText().trim().equals("")
                            || dataSourceIdField.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                } else {
                    cdtxtGoogleUserName.show();
                    cdtxtGooglePassword.show();
                    if (googleSpreadsheetUrlField.getText().trim().equals("")
                            || googleUserNameField.getText().trim().equals("")
                            || googlePasswordField.getText().trim().equals("")
                            || dataSourceIdField.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                }
            }
        };
        
        optPrivate.getSelectionButton(null).addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                boolean visible = (((Button) e.widget).getSelection());
                setVisible(googleUserNameField, visible);
                setVisible(googlePasswordField, visible);
                gSpreadSheetContainer.layout();
                gSpreadSheetContainer.getParent().layout();
            }
        });

        googleSpreadsheetUrlField.getTextControl(null).addModifyListener(gSpreadSheetModifyListener);
        googleUserNameField.getTextControl(null).addModifyListener(gSpreadSheetModifyListener);
        googlePasswordField.getTextControl(null).addModifyListener(gSpreadSheetModifyListener);
        
        optPrivate.getSelectionButton(null).addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                gSpreadSheetModifyListener.modifyText(null);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });
        
        optPublicField.getSelectionButton(null).setSelection(true);

        gSpreadSheetControls = new Object[] { dataSourceIdField, dataSourceTypeField, googleSpreadsheetUrlField,
                optPublicField, optPrivate, googleUserNameField, googlePasswordField
                };

    }

    @SuppressWarnings("restriction")
    private void createDataSourceComponents(){
        cDataSourceContainer = new Composite(composite, SWT.NONE);
        cDataSourceContainer.setFont(composite.getFont());
        cDataSourceContainer.setLayout(new GridLayout(8, false));
        cDataSourceContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        
        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(cDataSourceContainer, 8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(7);
        dataSourceTypeField.doFillIntoGrid(cDataSourceContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 7);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());

        final StringDialogField cDataSourceNameField = new StringDialogField();
        cDataSourceNameField.setLabelText("Data Source Name");
        cDataSourceNameField.doFillIntoGrid(cDataSourceContainer, 8);
        LayoutUtil.setHorizontalGrabbing(cDataSourceNameField.getTextControl(null));

        ControlDecoration cdtxtCarbonDataSourceName = new ControlDecoration(cDataSourceNameField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtCarbonDataSourceName.setDescriptionText("Carbon DataSource name required");
        cdtxtCarbonDataSourceName.setImage(fd.getImage());
        
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		cDataSourceNameField.setText("");
        	}
		});
        
        cDataSourceNameField.getTextControl(null).addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
                model.getCarbonDataConfig().setCarbonDataSourceName(cDataSourceNameField.getText());
                if (cDataSourceNameField.getText().trim().equals("")
                        || dataSourceIdField.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
			}
		});
        
        cDataSourceComponents = new Object [] {dataSourceIdField , dataSourceTypeField ,cDataSourceNameField};
    }
 
    @SuppressWarnings({ "restriction", "static-access" })
    private void createWebDataSource() {
        // TODO Auto-generated method stub
        webDataSourceContainer = new Composite(composite, SWT.NONE);
        webDataSourceContainer.setFont(composite.getFont());
        webDataSourceContainer.setLayout(new GridLayout(8, false));
        webDataSourceContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        final StringDialogField dataSourceIdField = new StringDialogField();
        dataSourceIdField.setLabelText("DataSource Id");
        dataSourceIdField.doFillIntoGrid(webDataSourceContainer,8);
        LayoutUtil.setHorizontalGrabbing(dataSourceIdField.getTextControl(null));

		dataSourceIdField.getTextControl(null).addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				model.setDataSourceId(dataSourceIdField.getText());
				dataSourceId = (dataSourceIdField.getText());
				if (dataSourceIdField.getText().trim().equals("")) {
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				} else {
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		});

        ControlDecoration cdtxtDataSourceId = new ControlDecoration(dataSourceIdField.getTextControl(null),
                SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());

        ComboDialogField dataSourceTypeField = new ComboDialogField(SWT.READ_ONLY);
        dataSourceTypeField.setLabelText("Data Source Type");
        dataSourceTypeField.setItems(dataSourceType);
        dataSourceTypeField.selectItem(8);
        dataSourceTypeField.doFillIntoGrid(webDataSourceContainer, 8);

        createDataSourceTypeComponent(dataSourceIdField, dataSourceTypeField, 8);

        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dataSourceTypeField.getComboControl(null),
                SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());
        
        final SelectionButtonDialogField OptWebHarvestConfigField = new SelectionButtonDialogField(SWT.RADIO);
        OptWebHarvestConfigField.setLabelText("Web Harvest Config File Path");
        OptWebHarvestConfigField.createEmptySpace(webDataSourceContainer, 1);
        OptWebHarvestConfigField.doFillIntoGrid(webDataSourceContainer, 1);
     
        
        final SelectionButtonDialogField optInlineWebHarvestField = new SelectionButtonDialogField(SWT.RADIO);
        optInlineWebHarvestField.setLabelText("Inline Web Harvest Config");
        optInlineWebHarvestField.doFillIntoGrid(webDataSourceContainer, 1);
        optInlineWebHarvestField.createEmptySpace(webDataSourceContainer, 5);
        
        
        final StringDialogField webConfigPathField = new StringDialogField();
        webConfigPathField.setLabelText("Config Path");
        webConfigPathField.doFillIntoGrid(webDataSourceContainer,8);
        LayoutUtil.setHorizontalGrabbing(webConfigPathField.getTextControl(null));

        final Label configLabel = new Label(webDataSourceContainer,SWT.NONE);
        configLabel.setText("Inline Config");
        
        final Text txtWebConfigText = new Text(webDataSourceContainer , SWT.BORDER | SWT.WRAP | SWT.MULTI);
        GridData gd = new GridData();
        gd.horizontalAlignment= GridData.FILL;
        gd.verticalAlignment= GridData.FILL;
        gd.horizontalSpan= 7;
        gd.verticalSpan=60;
        txtWebConfigText.setLayoutData(gd);
  
        webDataSourceContainer.layout();
        
        configLabel.setVisible(false);
        txtWebConfigText.setVisible(false);
        
        dataSourceTypeField.getComboControl(null).addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
        		webConfigPathField.setText("");
            	txtWebConfigText.setText("");
        	}
		});
        
        optInlineWebHarvestField.getSelectionButton(null).addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
 
                setVisible(webConfigPathField,false);
                
                setVisible(configLabel,true);
                setVisible(txtWebConfigText,true);
                
                webDataSourceContainer.layout();
                webDataSourceContainer.getParent().layout();
            }
        });

        OptWebHarvestConfigField.getSelectionButton(null).addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                
                setVisible(configLabel,false);
                setVisible(txtWebConfigText,false);
                
                setVisible(webConfigPathField,true);
                
                webDataSourceContainer.layout();
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });

        
        ModifyListener webConfigFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
				// TODO Auto-generated method stub
			  model.getWebDataSourceConfig().setInlineConfig(optInlineWebHarvestField.isSelected());
              model.getWebDataSourceConfig().setWebConfigInlineText(
                      txtWebConfigText.getText().replaceAll(txtWebConfigText.getLineDelimiter(), "&#xd;"));
              model.getWebDataSourceConfig().setWebConfigPath(webConfigPathField.getText());
              if (optInlineWebHarvestField.isSelected()) {
                  if (txtWebConfigText.getText().trim().equals("") || dataSourceIdField.getText().trim().equals("")) {
                      setPageComplete(false);
                      setErrorMessage("Required Field(s) are missing or invalid");
                  } else {
                      setPageComplete(true);
                      setErrorMessage(null);
                  }
              } else {
                  if (webConfigPathField.getText().trim().equals("") || dataSourceIdField.getText().trim().equals("")) {
                      setPageComplete(false);
                      setErrorMessage("Required Field(s) are missing or invalid");
                  } else {
                      setPageComplete(true);
                      setErrorMessage(null);
                  }
              }
				
			}
		};

		webConfigPathField.getTextControl(null).addModifyListener(webConfigFieldListener);
		txtWebConfigText.addModifyListener(webConfigFieldListener);
		OptWebHarvestConfigField.setSelection(true);
        
        webDataSourceControls = new Object[] { dataSourceIdField, dataSourceTypeField,
                OptWebHarvestConfigField , optInlineWebHarvestField 
                };
        
    }

    @SuppressWarnings("restriction")
    void setVisible(Object object, boolean visible) {

        if (object instanceof Label) {
            ((GridData) ((Label) object).getLayoutData()).exclude = !visible;
            ((Label) object).setVisible(visible);
        }
        else if (object instanceof Text) {
            ((GridData) ((Text) object).getLayoutData()).exclude = !visible;
            ((Text) object).setVisible(visible);
        }
        else if (object instanceof StringDialogField) {
            ((GridData) ((StringDialogField) object).getTextControl(null).getLayoutData()).exclude = !visible;
            ((GridData) ((StringDialogField) object).getLabelControl(null).getLayoutData()).exclude = !visible;
            ((StringDialogField) object).getTextControl(null).setVisible(visible);
            ((StringDialogField) object).getLabelControl(null).setVisible(visible);
            ((StringDialogField) object).getTextControl(null).setText("");
        }
        else if (object instanceof ComboDialogField) {
            ((GridData) ((ComboDialogField) object).getComboControl(null).getLayoutData()).exclude = !visible;
            ((GridData) ((ComboDialogField) object).getLabelControl(null).getLayoutData()).exclude = !visible;
            ((ComboDialogField) object).getComboControl(null).setVisible(visible);
            ((ComboDialogField) object).getLabelControl(null).setVisible(visible);
        }
        else if (object instanceof Composite) {
            ((GridData) ((Composite) object).getLayoutData()).exclude = !visible;
            ((Composite) object).setVisible(visible);
        }
         else if(object instanceof SelectionButtonDialogField) {
         ((GridData) ((SelectionButtonDialogField)object).getSelectionButton(null).getLayoutData()).exclude =
         !visible;
         ((GridData) ((SelectionButtonDialogField)object).getLabelControl(null).getLayoutData()).exclude = !visible;
         ((SelectionButtonDialogField)object).getSelectionButton(null).setVisible(visible);
         ((SelectionButtonDialogField)object).getLabelControl(null).setVisible(visible);
         }

    }

    private void hideAllComposites() {
        // TODO Auto-generated method stub
        ((GridData) rdbmsContainer.getLayoutData()).exclude = true;
        rdbmsContainer.setVisible(false);

        ((GridData) cassandraContainer.getLayoutData()).exclude = true;
        cassandraContainer.setVisible(false);

        ((GridData) csvContainer.getLayoutData()).exclude = true;
        csvContainer.setVisible(false);
        
        ((GridData) excelContainer.getLayoutData()).exclude = true;
        excelContainer.setVisible(false);
        
        ((GridData) rdfContainer.getLayoutData()).exclude = true;
        rdfContainer.setVisible(false);

        ((GridData) cDataSourceContainer.getLayoutData()).exclude = true;
        cDataSourceContainer.setVisible(false);
        
        ((GridData) jndiContainer.getLayoutData()).exclude = true;
        jndiContainer.setVisible(false);
        
        ((GridData) gSpreadSheetContainer.getLayoutData()).exclude = true;
        gSpreadSheetContainer.setVisible(false);
        
        ((GridData) webDataSourceContainer.getLayoutData()).exclude = true;
        webDataSourceContainer.setVisible(false);
        
    }

    private GridLayout initGridLayout(GridLayout layout, boolean margins) {
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        if (margins) {
            layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
            layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        } else {
            layout.marginWidth = 0;
            layout.marginHeight = 0;
        }
        return layout;
    }

    public File getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(File projectLocation) {
		this.projectLocation = projectLocation;
	}

    /**
     * Select registry resource path form configuration registry or governance
     * registry
     * 
     * @param textBox
     * @param defaultPathId
     *            Conf.Reg=2 and Gov.Reg=3
     */
    private void selectRegistryResource(Text textBox, int defaultPathId) {
        RegistryResourceNode selectedRegistryResourceNode = null;
        RegistryTreeBrowserDialog r = new RegistryTreeBrowserDialog(getShell(),
                RegistryTreeBrowserDialog.SELECT_REGISTRY_RESOURCE, defaultPathId);
        r.create();
        List<RegistryURLInfo> allRegistryUrls = RegistryUrlStore.getInstance().getAllRegistryUrls();
        for (RegistryURLInfo registryURLInfo : allRegistryUrls) {
            r.addRegistryNode(registryURLInfo, null);
        }
        if (r.open() == Window.OK) {
            selectedRegistryResourceNode = r.getSelectedRegistryResourceNodeResource();
            String ResourcePath = selectedRegistryResourceNode.getRegistryResourcePath();
            if (ResourcePath.startsWith("/_system/config")) {
                textBox.setText(ResourcePath.replaceFirst("/_system/config", "conf:"));
            } else if (ResourcePath.startsWith("/_system/governance")) {
                textBox.setText(ResourcePath.replaceFirst("/_system/governance", "gov:"));
            } else {
                MessageBox msgBox = new MessageBox(getShell(), SWT.ICON_INFORMATION);
                msgBox.setMessage("invalid selection.");
                msgBox.open();
            }
        }
    }
}
