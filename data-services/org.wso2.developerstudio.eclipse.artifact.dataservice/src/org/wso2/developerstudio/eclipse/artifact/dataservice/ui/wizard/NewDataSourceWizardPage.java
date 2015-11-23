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

import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.RegistryTreeBrowserDialog;
import org.wso2.developerstudio.eclipse.artifact.dataservice.model.DataServiceModel;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;


public class NewDataSourceWizardPage extends WizardPage {
	
	public static final int SELECTED_REGISTRY_RESOURCE = 8;
	private static final String SYMBOLIC_NAME = "org.wso2.developerstudio.eclipse.artifact.dataservice";
	
	private Text txtDataSourceId;
	private CTabFolder tabConfig;
	/* avalable datasource types */
	private static String[] dataSourceType = new String[] {"RDBMS", "Cassandra", "CSV", "EXCEL", "RDF", "JNDI Datasource", "Google Spreadsheet", "Carbon Data Source", "Web Data Source"};
	private static String[] rdbmsType = new String[] {"MySQL", "Apache Derby", "Microsoft SQL Server", "Oracle", "IBM DB2", "HSQLDB", "Informix", "PostgreSQL", "Sybase ASE", "H2", "Generic"};
	private static HashMap<String,String[]> rdbmsConfig = new HashMap<String,String[]>();
	private DataServiceModel model;
	
	private CTabItem tbtmRDBMS;
	private CTabItem tbtmCASSANDRA;
	private CTabItem tbtmCSV;
	private CTabItem tbtmEXCEL;
	private CTabItem tbtmRDF;
	private CTabItem tbtmJNDI;
	private CTabItem tbtmGSS;
	private CTabItem tbtmCDS;
	private CTabItem tbtmWDS;
	
	private Composite cWDS;
	
	/* RDBMS DS controls */
	private Text txtXADatasourceClass;
	private Text txtDriverClass;
	private Text txtJdbcUrl;
	private Text txtUserName;
	private Text txtPassword;
	
	/* Cassandra DS controls */
	private Text txtCassandraServerUrl;
	private Text txtCassandraUserName;
	private Text txtCassandraPassword;		
	
	/* CSV DS controls*/
	private Text txtCsvFileLocation;
	private Text txtStartReadingFromRow;
	private Text txtColumnSeperator;
	private Text txtMaxRowsTo;
	
	/* Excel DS controls*/
	private Text txtExcelFileLocation;
	
	/*RDF DS controls */
	private Text txtRDFFileLocation;
	
	/* JNDI DS controls*/
	private Text txtJndiContextClass;
	private Text txtProviderUrl;
	private Text txtResourceName;
	private Text txtJndiPassword;
	
	/* Google Spreadsheet controls */
	private Text txtlblGoogleSpreadsheetUrl;
	private Text txtGoogleUserName;
	private Text txtGooglePassword;
	private Text txtCarbonDataSourceName;
	
	/* Web Data source controls*/
	private Text txtWebConfigPath;
	private Text txtWebConfigText;

	private ModifyListener rdbmsFieldListener;
	private ModifyListener cassandraFieldListener;
	private ModifyListener csvFieldListener;
	private ModifyListener jndiFieldListener;
	private ModifyListener gspreadFieldListener;
	private SelectionListener gspreadOptListener;
	private ModifyListener webConfigFieldListener;
	private ModifyListener excelFieldListener;
	private ModifyListener rdfFieldListener;
	private ModifyListener carbonFieldListener;

	public NewDataSourceWizardPage() {
		super("New Data Source Wizard");
		setTitle("Data Source Wizard");
		setDescription("Create New Data Source Configuration");
		rdbmsConfig.put(rdbmsType[0], new String[]{"jdbc:mysql://[machine-name/ip]:[port]/[database-name]","com.mysql.jdbc.Driver","com.mysql.jdbc.jdbc2.optional.MysqlXADataSource"});
		rdbmsConfig.put(rdbmsType[1], new String[]{"jdbc:derby:[path-to-data-file]","org.apache.derby.jdbc.EmbeddedDriver","org.apache.derby.jdbc.EmbeddedXADataSource"});
		rdbmsConfig.put(rdbmsType[2], new String[]{"jdbc:sqlserver://[HOST]:[PORT1433];databaseName=[DB]","com.microsoft.sqlserver.jdbc.SQLServerDriver","com.microsoft.sqlserver.jdbc.SQLServerXADataSource"});
		rdbmsConfig.put(rdbmsType[3], new String[]{"jdbc:oracle:[drivertype]:[username/password]@[host]:[port]/[database]","oracle.jdbc.driver.OracleDriver","oracle.jdbc.xa.client.OracleXADataSource"});
		rdbmsConfig.put(rdbmsType[4], new String[]{"jdbc:db2:[database]","com.ibm.db2.jcc.DB2Driver","com.ibm.db2.jcc.DB2XADataSource"});
		rdbmsConfig.put(rdbmsType[5], new String[]{"jdbc:hsqldb:[path]","org.hsqldb.jdbcDriver","org.hsqldb.jdbc.pool.JDBCXADataSource"});
		rdbmsConfig.put(rdbmsType[6], new String[]{"jdbc:informix-sqli://[HOST]:[PORT]/[database]:INFORMIXSERVER=[server-name]","com.informix.jdbc.IfxDriver","com.informix.jdbc.jdbc2.optional.InformixXADataSource"});
		rdbmsConfig.put(rdbmsType[7], new String[]{"jdbc:postgresql://[HOST]:[PORT5432]/[database]","org.postgresql.Driver","org.postgresql.xa.PGXADataSource"});
		rdbmsConfig.put(rdbmsType[8], new String[]{"jdbc:sybase:Tds:[HOST]:[PORT2048]/[database]","com.sybase.jdbc3.jdbc.SybDriver","com.sybase.jdbc3.jdbc.SybXADataSource"});
		rdbmsConfig.put(rdbmsType[9], new String[]{"jdbc:h2:tcp:[HOST]:[PORT]/[database]","org.h2.Driver","org.h2.jdbcx.JdbcDataSource"});
		rdbmsConfig.put(rdbmsType[10], new String[]{"Generic","Generic","Generic"});
	}


	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		model = (DataServiceModel) ((DataServiceCreationWizard)getWizard()).getModel();
		
		GridData gd_leftcol = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_leftcol.widthHint = 130;
		
		Label lblDataSourceId = new Label(container, SWT.NONE);
		lblDataSourceId.setBounds(15, 17, 115, 20);
		lblDataSourceId.setText("DataSource Id");
		
		txtDataSourceId = new Text(container, SWT.BORDER);
		txtDataSourceId.setBounds(150, 13, 151, 25);
		txtDataSourceId.setText("");
		model.setDataSourceId("");
		
		ControlDecoration cdtxtDataSourceId = new ControlDecoration(txtDataSourceId, SWT.LEFT | SWT.TOP);
		cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
		FieldDecoration fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
		cdtxtDataSourceId.setImage(fd.getImage());
		//controlDecoration.hide();
		
		
		Label lblDataSourceType = new Label(container, SWT.NONE);
		lblDataSourceType.setBounds(15, 47, 115, 15);
		lblDataSourceType.setText("Data Source Type");
		
		Combo cmbDataSourceType = new Combo(container, SWT.READ_ONLY);
		cmbDataSourceType.setItems(dataSourceType);
		cmbDataSourceType.setText("RDBMS");
		cmbDataSourceType.setBounds(150, 44, 152, 23);
		ControlDecoration cdcmbDataSourceType = new ControlDecoration(cmbDataSourceType, SWT.LEFT | SWT.TOP);
		cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
		cdcmbDataSourceType.setImage(fd.getImage());
		
		tabConfig = new CTabFolder(container, SWT.FLAT);
		tabConfig.setTabHeight(0);
		tabConfig.setSingle(true);
		tabConfig.setBorderVisible(false);
		tabConfig.setBounds(10, 71, 542, 206);
		tabConfig.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		
		tbtmRDBMS = new CTabItem(tabConfig, SWT.NONE);
		
		//RDBMS  Data source configuration controls
		final Composite cRDBMS = new Composite(tabConfig, SWT.NONE);
		tbtmRDBMS.setControl(cRDBMS);
		GridLayout gridLayout = new GridLayout(3, false);
		cRDBMS.setLayout(gridLayout);
		
		Label lblDatabaseEngine = new Label(cRDBMS, SWT.NONE);
		lblDatabaseEngine.setText("Database Engine");
		
		Combo cmbDatabaseEngine = new Combo(cRDBMS, SWT.READ_ONLY);

		cmbDatabaseEngine.setItems(rdbmsType);
		GridData gd_cmbDatabaseEngine = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_cmbDatabaseEngine.widthHint = 110;
		cmbDatabaseEngine.setLayoutData(gd_cmbDatabaseEngine);
		
		ControlDecoration cdcmbDatabaseEngine = new ControlDecoration(cmbDatabaseEngine, SWT.LEFT | SWT.TOP);
		cdcmbDatabaseEngine.setDescriptionText("Select Database Engine");
		cdcmbDatabaseEngine.setImage(fd.getImage());
		
		cmbDatabaseEngine.setText(rdbmsType[0]);
		
		final Button chkXADatasource = new Button(cRDBMS, SWT.CHECK);
		chkXADatasource.setText("XA-Datasource");
		
		final Label lblXADatasourceClass = new Label(cRDBMS, SWT.NONE);
		lblXADatasourceClass.setText("XA-Datasource class");
		final GridData gd_lblXADatasourceClass = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblXADatasourceClass.exclude=true;
		lblXADatasourceClass.setLayoutData(gd_lblXADatasourceClass);
		lblXADatasourceClass.setVisible(false);
		
		txtXADatasourceClass = new Text(cRDBMS, SWT.BORDER);
		final GridData gd_txtXADatasourceClass = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_txtXADatasourceClass.widthHint = 300;
		gd_txtXADatasourceClass.exclude=true;
		txtXADatasourceClass.setLayoutData(gd_txtXADatasourceClass);
		txtXADatasourceClass.setVisible(false);
		
		final ControlDecoration cdtxtXADatasourceClass = new ControlDecoration(txtXADatasourceClass, SWT.LEFT | SWT.TOP);
		cdtxtXADatasourceClass.setDescriptionText("XA-Datasource Required");
		cdtxtXADatasourceClass.setImage(fd.getImage());
		cdtxtXADatasourceClass.hide();
		
		final Label lblDriverClass = new Label(cRDBMS, SWT.NONE);
		lblDriverClass.setText("Driver Class");
		final GridData gd_lblDriverClass = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		lblDriverClass.setLayoutData(gd_lblDriverClass);
		
		txtDriverClass = new Text(cRDBMS, SWT.BORDER);
		GridData gd_txtDriverClass = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_txtDriverClass.widthHint = 300;
		txtDriverClass.setLayoutData(gd_txtDriverClass);
		
		final ControlDecoration cdtxtDriverClass = new ControlDecoration(txtDriverClass, SWT.LEFT | SWT.TOP);
		cdtxtDriverClass.setDescriptionText("JDBC Driver Required");
		cdtxtDriverClass.setImage(fd.getImage());
		
		Label lblJdbcUrl = new Label(cRDBMS, SWT.NONE);
		lblJdbcUrl.setText("JDBC URL");
		
		txtJdbcUrl = new Text(cRDBMS, SWT.BORDER);
		GridData gd_txtJdbcUrl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_txtJdbcUrl.widthHint = 300;
		txtJdbcUrl.setLayoutData(gd_txtJdbcUrl);
		
		ControlDecoration cdtxtJdbcUrl = new ControlDecoration(txtJdbcUrl, SWT.LEFT | SWT.TOP);
		cdtxtJdbcUrl.setDescriptionText("JDBC Url Required");
		cdtxtJdbcUrl.setImage(fd.getImage());
		
		Label lblUserName = new Label(cRDBMS, SWT.NONE);
		lblUserName.setText("User Name");
		
		txtUserName = new Text(cRDBMS, SWT.BORDER);
		GridData gd_txtUserName = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_txtUserName.widthHint = 100;
		txtUserName.setLayoutData(gd_txtUserName);
		new Label(cRDBMS, SWT.NONE);
		
		Label lblPassword = new Label(cRDBMS, SWT.NONE);
		lblPassword.setText("Password");
		lblPassword.setLayoutData(gd_leftcol);
		
		txtPassword = new Text(cRDBMS, SWT.BORDER | SWT.PASSWORD);
		GridData gd_txtPassword = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtPassword.widthHint = 100;
		txtPassword.setLayoutData(gd_txtPassword);
		new Label(cRDBMS, SWT.NONE);
			
		
		//Cassandra Data source configuration controls
		tbtmCASSANDRA = new CTabItem(tabConfig, SWT.NONE);
		
		Composite cCassandra = new Composite(tabConfig, SWT.NONE);
		tbtmCASSANDRA.setControl(cCassandra);
		cCassandra.setLayout(new GridLayout(2, false));
		
		Label lblCassandraServerUrl = new Label(cCassandra, SWT.NONE);
		lblCassandraServerUrl.setText("Server URL");
		
		txtCassandraServerUrl = new Text(cCassandra, SWT.BORDER);
		GridData gd_txtCassandraServerUrl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtCassandraServerUrl.widthHint = 315;
		txtCassandraServerUrl.setLayoutData(gd_txtCassandraServerUrl);
		
		ControlDecoration cdtxtCassandraServerUrl = new ControlDecoration(txtCassandraServerUrl, SWT.LEFT | SWT.TOP);
		cdtxtCassandraServerUrl.setDescriptionText("Cassandra Server URL required");
		cdtxtCassandraServerUrl.setImage(fd.getImage());		
		
		Label lblCassandraUserName = new Label(cCassandra, SWT.NONE);
		lblCassandraUserName.setText("User Name");
		
		txtCassandraUserName = new Text(cCassandra, SWT.BORDER);
		GridData gd_txtCassandraUserName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtCassandraUserName.widthHint = 140;
		txtCassandraUserName.setLayoutData(gd_txtCassandraUserName);
		
		ControlDecoration cdtxtCassandraUserName = new ControlDecoration(txtCassandraUserName, SWT.LEFT | SWT.TOP);
		cdtxtCassandraUserName.setDescriptionText("User Name required");
		cdtxtCassandraUserName.setImage(fd.getImage());
				
		Label lblCassandraPassword = new Label(cCassandra, SWT.NONE);
		lblCassandraPassword.setText("Password");
		
		txtCassandraPassword = new Text(cCassandra, SWT.BORDER | SWT.PASSWORD);
		GridData gd_txtCassandraPassword = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtCassandraPassword.widthHint = 140;
		txtCassandraPassword.setLayoutData(gd_txtCassandraPassword);
		
		ControlDecoration cdtxtCassandraPassword = new ControlDecoration(txtCassandraPassword, SWT.LEFT | SWT.TOP);
		cdtxtCassandraPassword.setDescriptionText("Password required");
		cdtxtCassandraPassword.setImage(fd.getImage());		
		
		Label lblCassandraHidden = new Label(cCassandra, SWT.NONE);
		lblCassandraHidden.setText("");
		lblCassandraHidden.setLayoutData(gd_leftcol);

		//CSV Data source configuration controls
		tbtmCSV = new CTabItem(tabConfig, SWT.NONE);
		
		Composite cCSV = new Composite(tabConfig, SWT.NONE);
		tbtmCSV.setControl(cCSV);
		cCSV.setLayout(new GridLayout(4, false));
		
		Label lblCsvFileLocation = new Label(cCSV, SWT.NONE);
		lblCsvFileLocation.setText("CSV File Location");
		
		txtCsvFileLocation = new Text(cCSV, SWT.BORDER);
		GridData gd_txtCsvFileLocation = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtCsvFileLocation.widthHint = 300;
		txtCsvFileLocation.setLayoutData(gd_txtCsvFileLocation);
		
		ControlDecoration cdtxtCsvFileLocation = new ControlDecoration(txtCsvFileLocation, SWT.LEFT | SWT.TOP);
		cdtxtCsvFileLocation.setDescriptionText("CSV file location required");
		cdtxtCsvFileLocation.setImage(fd.getImage());
		
		Button cmdCsvKeyConRegBrowse = new Button(cCSV, SWT.NONE);
		cmdCsvKeyConRegBrowse.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		cmdCsvKeyConRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry-16x16.png"));
		cmdCsvKeyConRegBrowse.setToolTipText("Configuration registry");
		cmdCsvKeyConRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtCsvFileLocation, 2);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});

		Button cmdCsvKeyGovRegBrowse = new Button(cCSV, SWT.NONE);
		cmdCsvKeyGovRegBrowse.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));
		cmdCsvKeyGovRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry_picker.gif"));
		cmdCsvKeyGovRegBrowse.setToolTipText("Governance registry");
		cmdCsvKeyGovRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtCsvFileLocation, 3);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		
		Label lblColumnSeperator = new Label(cCSV, SWT.NONE);
		lblColumnSeperator.setText("Column Seperator");
		
		GridData gd_CsvtxtField = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		gd_CsvtxtField.widthHint = 50;
		
		txtColumnSeperator = new Text(cCSV, SWT.BORDER);
		txtColumnSeperator.setText(",");
		txtColumnSeperator.setLayoutData(gd_CsvtxtField);
		
		Label lblStartReadingFrom = new Label(cCSV, SWT.NONE);
		//lblStartReadingFrom.setText("Start Reading From Row");
		lblStartReadingFrom.setText("Start From Row");
		
		txtStartReadingFromRow = new Text(cCSV, SWT.BORDER);
		txtStartReadingFromRow.setLayoutData(gd_CsvtxtField);
		
		Label lblMaxRowsTo = new Label(cCSV, SWT.NONE);
		lblMaxRowsTo.setText("Max Rows To Read");
		
		txtMaxRowsTo = new Text(cCSV, SWT.BORDER);
		txtMaxRowsTo.setText("-1");
		txtMaxRowsTo.setLayoutData(gd_CsvtxtField);
		
		final Button chkColumnHeaderRow = new Button(cCSV, SWT.CHECK);
		chkColumnHeaderRow.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		chkColumnHeaderRow.setText("Contains Column Header Row");
		
		Label lblCsvHidden = new Label(cCSV, SWT.NONE);
		lblCsvHidden.setText("");
		lblCsvHidden.setLayoutData(gd_leftcol);
		
		tbtmEXCEL = new CTabItem(tabConfig, SWT.NONE);
		
		//Excel Data source configuration controls
		Composite cEXCEL = new Composite(tabConfig, SWT.NONE);
		tbtmEXCEL.setControl(cEXCEL);
		cEXCEL.setLayout(new GridLayout(4, false));
		Label lblExcelFileLocation = new Label(cEXCEL, SWT.NONE);
		lblExcelFileLocation.setText("EXCEL File Location");
		
		txtExcelFileLocation = new Text(cEXCEL, SWT.BORDER);
		GridData gd_txtExcelFileLocation = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtExcelFileLocation.widthHint = 300;
		txtExcelFileLocation.setLayoutData(gd_txtExcelFileLocation);
		
		ControlDecoration cdtxtExcelFileLocation = new ControlDecoration(txtExcelFileLocation, SWT.LEFT | SWT.TOP);
		cdtxtExcelFileLocation.setDescriptionText("Excel file location required");
		cdtxtExcelFileLocation.setImage(fd.getImage());
		
		Button cmdExcelKeyConRegBrowse = new Button(cEXCEL, SWT.NONE);
		cmdExcelKeyConRegBrowse.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		cmdExcelKeyConRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry-16x16.png"));
		cmdExcelKeyConRegBrowse.setToolTipText("Configuration registry");
		cmdExcelKeyConRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtExcelFileLocation, 2);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});

		Button cmdExcelKeyGovRegBrowse = new Button(cEXCEL, SWT.NONE);
		cmdExcelKeyGovRegBrowse.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));
		cmdExcelKeyGovRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry_picker.gif"));
		cmdExcelKeyGovRegBrowse.setToolTipText("Governance registry");
		cmdExcelKeyGovRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtExcelFileLocation, 3);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		
		Label lblExcelHidden = new Label(cEXCEL, SWT.NONE);
		lblExcelHidden.setText("");
		lblExcelHidden.setLayoutData(gd_leftcol);
		
		
		//RDF Data source configuration controls
		tbtmRDF = new CTabItem(tabConfig, SWT.NONE);
		
		Composite cRDF = new Composite(tabConfig, SWT.NONE);
		tbtmRDF.setControl(cRDF);
		cRDF.setLayout(new GridLayout(4, false));
		Label lblRDFFileLocation = new Label(cRDF, SWT.NONE);
		lblRDFFileLocation.setText("RDF File Location");
		
		
		txtRDFFileLocation = new Text(cRDF, SWT.BORDER);
		GridData gd_txtRDFFileLocation = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtRDFFileLocation.widthHint = 300;
		txtRDFFileLocation.setLayoutData(gd_txtRDFFileLocation);
		
		ControlDecoration cdtxtRDFFileLocation = new ControlDecoration(txtRDFFileLocation, SWT.LEFT | SWT.TOP);
		cdtxtRDFFileLocation.setDescriptionText("RDF file location required");
		cdtxtRDFFileLocation.setImage(fd.getImage());
		
		Button cmdRdfKeyConRegBrowse = new Button(cRDF, SWT.NONE);
		cmdRdfKeyConRegBrowse.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		cmdRdfKeyConRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry-16x16.png"));
		cmdRdfKeyConRegBrowse.setToolTipText("Configuration registry");
		cmdRdfKeyConRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtRDFFileLocation, 2);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});

		Button cmdRdfKeyGovRegBrowse = new Button(cRDF, SWT.NONE);
		cmdRdfKeyGovRegBrowse.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));
		cmdRdfKeyGovRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry_picker.gif"));
		cmdRdfKeyGovRegBrowse.setToolTipText("Governance registry");
		cmdRdfKeyGovRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtRDFFileLocation, 3);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		
		Label lblRdfHidden = new Label(cRDF, SWT.NONE);
		lblRdfHidden.setText("");
		lblRdfHidden.setLayoutData(gd_leftcol);
		
		//JNDI Data source configuration controls
		tbtmJNDI = new CTabItem(tabConfig, SWT.NONE);
		
		Composite cJNDI = new Composite(tabConfig, SWT.NONE);
		tbtmJNDI.setControl(cJNDI);
		cJNDI.setLayout(new GridLayout(2, false));
		
		Label lblJndiContextClass = new Label(cJNDI, SWT.NONE);
		lblJndiContextClass.setText("JNDI Context Class");
		
		txtJndiContextClass = new Text(cJNDI, SWT.BORDER);
		GridData gd_txtJndiContextClass = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtJndiContextClass.widthHint = 315;
		txtJndiContextClass.setLayoutData(gd_txtJndiContextClass);
		
		ControlDecoration cdtxtJndiContextClass = new ControlDecoration(txtJndiContextClass, SWT.LEFT | SWT.TOP);
		cdtxtJndiContextClass.setDescriptionText("JNDI Context Class required");
		cdtxtJndiContextClass.setImage(fd.getImage());
		
		Label lblProviderUrl = new Label(cJNDI, SWT.NONE);
		lblProviderUrl.setText("Provider URL");
		
		txtProviderUrl = new Text(cJNDI, SWT.BORDER);
		GridData gd_txtProviderUrl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtProviderUrl.widthHint = 315;
		txtProviderUrl.setLayoutData(gd_txtProviderUrl);
		
		ControlDecoration cdtxtProviderUrl = new ControlDecoration(txtProviderUrl, SWT.LEFT | SWT.TOP);
		cdtxtProviderUrl.setDescriptionText("Provider URL required");
		cdtxtProviderUrl.setImage(fd.getImage());
		
		Label lblResourceName = new Label(cJNDI, SWT.NONE);
		lblResourceName.setText("Resource Name");
		
		txtResourceName = new Text(cJNDI, SWT.BORDER);
		GridData gd_txtResourceName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtResourceName.widthHint = 140;
		txtResourceName.setLayoutData(gd_txtResourceName);
		
		ControlDecoration cdtxtResourceName = new ControlDecoration(txtResourceName, SWT.LEFT | SWT.TOP);
		cdtxtResourceName.setDescriptionText("Resource Name required");
		cdtxtResourceName.setImage(fd.getImage());
		
		Label lblJndiPassword = new Label(cJNDI, SWT.NONE);
		lblJndiPassword.setText("Password");
		
		txtJndiPassword = new Text(cJNDI, SWT.BORDER | SWT.PASSWORD);
		GridData gd_txtJndiPassword = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtJndiPassword.widthHint = 140;
		txtJndiPassword.setLayoutData(gd_txtJndiPassword);
		
		ControlDecoration cdtxtJndiPassword = new ControlDecoration(txtJndiPassword, SWT.LEFT | SWT.TOP);
		cdtxtJndiPassword.setDescriptionText("password required");
		cdtxtJndiPassword.setImage(fd.getImage());
		
		Label lblJndiHidden = new Label(cJNDI, SWT.NONE);
		lblJndiHidden.setText("");
		lblJndiHidden.setLayoutData(gd_leftcol);
		
		//Google Spreadsheet Data source configuration controls
		tbtmGSS = new CTabItem(tabConfig, SWT.NONE);
		
		Composite cGSS = new Composite(tabConfig, SWT.NONE);
		tbtmGSS.setControl(cGSS);
		cGSS.setLayout(gridLayout);
		
		Label lblGoogleSpreadsheetUrl = new Label(cGSS, SWT.NONE);
		lblGoogleSpreadsheetUrl.setText("Spreadsheet URL");
		
		txtlblGoogleSpreadsheetUrl = new Text(cGSS, SWT.BORDER);
		GridData gd_txtlblGoogleSpreadsheetUrl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_txtlblGoogleSpreadsheetUrl.widthHint = 304;
		txtlblGoogleSpreadsheetUrl.setLayoutData(gd_txtlblGoogleSpreadsheetUrl);
		
		ControlDecoration cdtxtlblGoogleSpreadsheetUrl = new ControlDecoration(txtlblGoogleSpreadsheetUrl, SWT.LEFT | SWT.TOP);
		cdtxtlblGoogleSpreadsheetUrl.setDescriptionText("Spreadsheet Url required");
		cdtxtlblGoogleSpreadsheetUrl.setImage(fd.getImage());
		
		Label lblVisibility = new Label(cGSS, SWT.NONE);
		lblVisibility.setText("Visibility");
		
		final Button optPublic = new Button(cGSS, SWT.RADIO);
		optPublic.setSelection(true);
		optPublic.setText("public");
		
		final Button optPrivate = new Button(cGSS, SWT.RADIO);
		optPrivate.setText("Private");
		
		final Label lblGoogleUsername = new Label(cGSS, SWT.NONE);
		lblGoogleUsername.setText("User Name");
		lblGoogleUsername.setVisible(false);
		
		txtGoogleUserName = new Text(cGSS, SWT.BORDER);
		txtGoogleUserName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		txtGoogleUserName.setVisible(false);
		
		final ControlDecoration cdtxtGoogleUserName = new ControlDecoration(txtGoogleUserName, SWT.LEFT | SWT.TOP);
		cdtxtGoogleUserName.setDescriptionText("UserName required");
		cdtxtGoogleUserName.setImage(fd.getImage());
		
		final Label lblGooglePassword = new Label(cGSS, SWT.NONE);
		lblGooglePassword.setText("Password");
		lblGooglePassword.setVisible(false);
		
		txtGooglePassword = new Text(cGSS, SWT.BORDER | SWT.PASSWORD);
		txtGooglePassword.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		txtGooglePassword.setVisible(false);
		
		final ControlDecoration cdtxtGooglePassword = new ControlDecoration(txtGooglePassword, SWT.LEFT | SWT.TOP);
		cdtxtGooglePassword.setDescriptionText("password required");
		cdtxtGooglePassword.setImage(fd.getImage());
		
		Label lblgHidden = new Label(cGSS, SWT.NONE);
		lblgHidden.setText("");
		lblgHidden.setLayoutData(gd_leftcol);
		
		tbtmCDS = new CTabItem(tabConfig, SWT.NONE);
		
		//Carbon Data source configuration controls
		Composite cCDS = new Composite(tabConfig, SWT.NONE);
		tbtmCDS.setControl(cCDS);
		cCDS.setLayout(new GridLayout(2, false));
		
		Label lblDataSourceName = new Label(cCDS, SWT.NONE);
		lblDataSourceName.setText("Data Source Name");
		
		txtCarbonDataSourceName = new Text(cCDS, SWT.BORDER);
		GridData gd_txtCarbonDataSourceName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtCarbonDataSourceName.widthHint = 158;
		txtCarbonDataSourceName.setLayoutData(gd_txtCarbonDataSourceName);
		
		ControlDecoration cdtxtCarbonDataSourceName = new ControlDecoration(txtCarbonDataSourceName, SWT.LEFT | SWT.TOP);
		cdtxtCarbonDataSourceName.setDescriptionText("Carbon DataSource name required");
		cdtxtCarbonDataSourceName.setImage(fd.getImage());
		
		Label lblCarbonHidden = new Label(cCDS, SWT.NONE);
		lblCarbonHidden.setText("");
		lblCarbonHidden.setLayoutData(gd_leftcol);
		
		tbtmWDS = new CTabItem(tabConfig, SWT.NONE);
		
		//Web Data source configuration controls
		cWDS = new Composite(tabConfig, SWT.NONE);
		tbtmWDS.setControl(cWDS);
		cWDS.setLayout(gridLayout);
		
		final Button OptWebHarvestConfig = new Button(cWDS, SWT.RADIO);
		OptWebHarvestConfig.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		OptWebHarvestConfig.setSelection(true);
		OptWebHarvestConfig.setText("Web Harvest Config File Path");
		
		final Button btnInlineWebHarvest = new Button(cWDS, SWT.RADIO);
		btnInlineWebHarvest.setText("Inline Web Harvest Config ");
		
		final Label lblWebConfigPath = new Label(cWDS, SWT.NONE);
		lblWebConfigPath.setText("Config Path");
		
		txtWebConfigPath = new Text(cWDS, SWT.BORDER);
		final GridData gd_txtWebConfigPath = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_txtWebConfigPath.widthHint = 350;
		txtWebConfigPath.setLayoutData(gd_txtWebConfigPath);
		
		final ControlDecoration cdtxtWebConfigPath = new ControlDecoration(txtWebConfigPath, SWT.LEFT | SWT.TOP);
		cdtxtWebConfigPath.setDescriptionText("WebConfig Path required");
		cdtxtWebConfigPath.setImage(fd.getImage());
		
		txtWebConfigText = new Text(cWDS, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData gd_txtWebConfigText = new GridData(SWT.LEFT, SWT.TOP, false, true, 3, 1);
		gd_txtWebConfigText.heightHint = 117;
		gd_txtWebConfigText.widthHint = 474;
		txtWebConfigText.setLayoutData(gd_txtWebConfigText);
		txtWebConfigText.setVisible(false);
		
		final ControlDecoration cdtxtWebConfigText = new ControlDecoration(txtWebConfigText, SWT.LEFT | SWT.TOP);
		cdtxtWebConfigText.setDescriptionText("WebConfig Text required");
		cdtxtWebConfigText.setImage(fd.getImage());
		
		Label lblWebConfigHidden = new Label(cWDS, SWT.NONE);
		lblWebConfigHidden.setText("");
		lblWebConfigHidden.setLayoutData(gd_leftcol);
		
		tabConfig.setSelection(0);
		model.setDataSourceConfig(0);
		txtJdbcUrl.setText(rdbmsConfig.get(rdbmsType[0])[0]);
		txtDriverClass.setText(rdbmsConfig.get(rdbmsType[0])[1]);
		txtXADatasourceClass.setText(rdbmsConfig.get(rdbmsType[0])[2]);
		
		// Listeners
		
		cmbDataSourceType.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(false);
				
				int selectedIndex = ((Combo)e.widget).getSelectionIndex();
				if( rdbmsType.length > selectedIndex && selectedIndex!=-1 ){
					tabConfig.setSelection(selectedIndex);
					model.setDataSourceConfig(selectedIndex);
				switch (selectedIndex) {
				case 0:
					rdbmsFieldListener.modifyText(null);
					break;					
				case 1:
					cassandraFieldListener.modifyText(null);
					break;					
				case 2:
					csvFieldListener.modifyText(null);
					break;
				case 3:
					excelFieldListener.modifyText(null);
					break;
				case 4:
					rdfFieldListener.modifyText(null);
					break;
				case 5:
					jndiFieldListener.modifyText(null);
					break;
				case 6:
					gspreadFieldListener.modifyText(null);
					break;
				case 7:
					carbonFieldListener.modifyText(null);
					break;
				case 8:
					webConfigFieldListener.modifyText(null);
					break;
				default:
					setPageComplete(false);
					break;
				}
				}
			}
		});
		
		chkXADatasource.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				boolean visible = (((Button)e.widget).getSelection());
				txtXADatasourceClass.setVisible(visible);
				((GridData)txtXADatasourceClass.getLayoutData()).exclude=!visible;
				lblXADatasourceClass.setVisible(visible);
				((GridData)lblXADatasourceClass.getLayoutData()).exclude=!visible;
				txtDriverClass.setVisible(!visible);
				((GridData)txtDriverClass.getLayoutData()).exclude=visible;
				lblDriverClass.setVisible(!visible);
				((GridData)lblDriverClass.getLayoutData()).exclude=visible;
				if(visible){
					cdtxtXADatasourceClass.show();
					cdtxtDriverClass.hide();
				} else{
					cdtxtXADatasourceClass.hide();
					cdtxtDriverClass.show();
				}
				cRDBMS.layout();
			}
		});
		
		cmbDatabaseEngine.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = ((Combo)e.widget).getSelectionIndex();
				if ( rdbmsType.length > selectedIndex && selectedIndex!=-1 ){
					if(rdbmsConfig.containsKey(rdbmsType[selectedIndex])){
						txtJdbcUrl.setText(rdbmsConfig.get(rdbmsType[selectedIndex])[0]);
						txtDriverClass.setText(rdbmsConfig.get(rdbmsType[selectedIndex])[1]);
						txtXADatasourceClass.setText(rdbmsConfig.get(rdbmsType[selectedIndex])[2]);
					}
				}
			}
		});
		
		optPrivate.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				boolean visible = (((Button)e.widget).getSelection());
				lblGoogleUsername.setVisible(visible);
				txtGoogleUserName.setVisible(visible);
				lblGooglePassword.setVisible(visible);
				txtGooglePassword.setVisible(visible);
			}
		});
		
		btnInlineWebHarvest.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				boolean visible = (((Button)e.widget).getSelection());
				lblWebConfigPath.setText((visible)?"Config:":"Config Path");
				txtWebConfigPath.setVisible(!visible);
				txtWebConfigText.setVisible(visible);
			}
		});
		

		
		rdbmsFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent text) {
				boolean isXA = chkXADatasource.getSelection();
				model.getRdbmsConfig().setDriverClass(txtDriverClass.getText());
				model.getRdbmsConfig().setXaDsClass(txtXADatasourceClass.getText());
				model.getRdbmsConfig().setJdbcUrl(txtJdbcUrl.getText());
				model.getRdbmsConfig().setJdbcUser(txtUserName.getText());
				model.getRdbmsConfig().setJdbcPassword(txtPassword.getText());
				if(isXA){
					if(txtXADatasourceClass.getText().trim().equals("")||txtJdbcUrl.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("") ){
						setPageComplete(false);
						setErrorMessage("Required Field(s) are missing");
					}else{
						setPageComplete(true);
						setErrorMessage(null);
					}
				} else{
					if(txtDriverClass.getText().trim().equals("")||txtJdbcUrl.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("")){
						setPageComplete(false);
						setErrorMessage("Required Field(s) are missing");
					}else{
						setPageComplete(true);
						setErrorMessage(null);
					}
				}
				
			}
		};
		
		
		
		txtXADatasourceClass.addModifyListener(rdbmsFieldListener);
		txtDriverClass.addModifyListener(rdbmsFieldListener);
		txtJdbcUrl.addModifyListener(rdbmsFieldListener);
		txtUserName.addModifyListener(rdbmsFieldListener);
		txtPassword.addModifyListener(rdbmsFieldListener);

		
		cassandraFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent text) {
				
				model.getCassandraConfig().setServerURL(txtCassandraServerUrl.getText());
				model.getCassandraConfig().setUserName(txtCassandraUserName.getText());
				model.getCassandraConfig().setPassword(txtCassandraPassword.getText());
				if(txtCassandraServerUrl.getText().trim().equals("")|| txtCassandraUserName.getText().trim().equals("")|| txtCassandraPassword.getText().trim().equals("")){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
				
			}
		};
		
		txtCassandraServerUrl.addModifyListener(cassandraFieldListener);
		txtCassandraUserName.addModifyListener(cassandraFieldListener);
		txtCassandraPassword.addModifyListener(cassandraFieldListener);
		
		csvFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent text) {
				model.getCsvConfig().setCsvFileLocation(txtCsvFileLocation.getText());
				model.getCsvConfig().setColumnSeperator(txtColumnSeperator.getText());
				try {
					model.getCsvConfig().setStartReadingFromRow(Integer.parseInt(txtStartReadingFromRow.getText()));
					model.getCsvConfig().setMaxRowsToRead(Integer.parseInt(txtMaxRowsTo.getText()));
				} catch (NumberFormatException e) {
					if(!(txtStartReadingFromRow.getText().trim().equals("") || txtMaxRowsTo.getText().trim().equals(""))){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
					return;
					}
				}
				if(txtCsvFileLocation.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("") ){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		};
		
		txtCsvFileLocation.addModifyListener(csvFieldListener);
		txtColumnSeperator.addModifyListener(csvFieldListener);
		txtStartReadingFromRow.addModifyListener(csvFieldListener);
		txtMaxRowsTo.addModifyListener(csvFieldListener);
		
		chkColumnHeaderRow.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent evt) {
			model.getCsvConfig().setContainsColumnHeaderRow(chkColumnHeaderRow.getSelection());	
			}
			
			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
				
			}
		});
		
		excelFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				model.getExcelConfig().setExcelFileLocation(txtExcelFileLocation.getText());
				if(txtExcelFileLocation.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("") ){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		};
		
		txtExcelFileLocation.addModifyListener(excelFieldListener);
		
		rdfFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				model.getRdfConfig().setRdfFileLocation(txtRDFFileLocation.getText());
				if(txtRDFFileLocation.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("") ){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		};
		
		txtRDFFileLocation.addModifyListener(rdfFieldListener);
		
		
		jndiFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				model.getJndiConfig().setJndiContextClass(txtJndiContextClass.getText());
				model.getJndiConfig().setProvideUrl(txtProviderUrl.getText());
				model.getJndiConfig().setResourceName(txtResourceName.getText());
				model.getJndiConfig().setPassword(txtJndiPassword.getText());
				if(txtJndiContextClass.getText().trim().equals("")|| txtProviderUrl.getText().trim().equals("")|| txtResourceName.getText().trim().equals("")|| txtJndiPassword.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("") ){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
				
			}
		}; 
		
		txtJndiContextClass.addModifyListener(jndiFieldListener);
		txtProviderUrl.addModifyListener(jndiFieldListener);
		txtResourceName.addModifyListener(jndiFieldListener);
		txtJndiPassword.addModifyListener(jndiFieldListener);
		
		gspreadFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				model.getGoogleSpreadsheetConfig().setSpreadsheetURL(txtlblGoogleSpreadsheetUrl.getText());
				model.getGoogleSpreadsheetConfig().setPublicVisible(optPublic.getSelection());
				model.getGoogleSpreadsheetConfig().setUserName(txtGoogleUserName.getText());
				model.getGoogleSpreadsheetConfig().setPassword(txtGooglePassword.getText());
				if(optPublic.getSelection()){
					cdtxtGoogleUserName.hide();
					cdtxtGooglePassword.hide();
					if(txtlblGoogleSpreadsheetUrl.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("") ){
						setPageComplete(false);
						setErrorMessage("Required Field(s) are missing");
					}else{
						setPageComplete(true);
						setErrorMessage(null);
					}
				} else{
					cdtxtGoogleUserName.show();
					cdtxtGooglePassword.show();
					if(txtlblGoogleSpreadsheetUrl.getText().trim().equals("")||txtGoogleUserName.getText().trim().equals("") ||txtGooglePassword.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("")){
						setPageComplete(false);
						setErrorMessage("Required Field(s) are missing");
					}else{
						setPageComplete(true);
						setErrorMessage(null);
					}
				}	
			}
		};
		
		txtlblGoogleSpreadsheetUrl.addModifyListener(gspreadFieldListener);
		txtGoogleUserName.addModifyListener(gspreadFieldListener);
		txtGooglePassword.addModifyListener(gspreadFieldListener);
		
		gspreadOptListener = new SelectionListener() {
			
			public void widgetSelected(SelectionEvent evt) {
				gspreadFieldListener.modifyText(null);
			}
			
			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		};
		
		optPrivate.addSelectionListener(gspreadOptListener);
		
		carbonFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				model.getCarbonDataConfig().setCarbonDataSourceName(txtCarbonDataSourceName.getText());
				if(txtCarbonDataSourceName.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("") ){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
			}
		};
		
		txtCarbonDataSourceName.addModifyListener(carbonFieldListener);

		OptWebHarvestConfig.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent evt) {
				if(OptWebHarvestConfig.getSelection()){
					txtWebConfigPath.setText("");
					cdtxtWebConfigText.hide();
					cdtxtWebConfigPath.show();
				} else{
					txtWebConfigText.setText("");
					cdtxtWebConfigText.show();
					cdtxtWebConfigPath.hide();
				}
				model.getWebDataSourceConfig().setInlineConfig(btnInlineWebHarvest.getSelection());
				webConfigFieldListener.modifyText(null);
			}
			
			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		
		webConfigFieldListener = new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				model.getWebDataSourceConfig().setInlineConfig(btnInlineWebHarvest.getSelection());
				model.getWebDataSourceConfig().setWebConfigInlineText(txtWebConfigText.getText().replaceAll(txtWebConfigText.getLineDelimiter(), "&#xd;"));
				model.getWebDataSourceConfig().setWebConfigPath(txtWebConfigPath.getText());
				if(btnInlineWebHarvest.getSelection()){
					if( txtWebConfigText.getText().trim().equals("")|| txtDataSourceId.getText().trim().equals("") ){
						setPageComplete(false);
						setErrorMessage("Required Field(s) are missing or invalid");
					}else{
						setPageComplete(true);
						setErrorMessage(null);
					}
				} else {
				if( txtWebConfigPath.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("") ){
					setPageComplete(false);
					setErrorMessage("Required Field(s) are missing or invalid");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
				}
			}
		};
		
		txtWebConfigPath.addModifyListener(webConfigFieldListener);
		txtWebConfigText.addModifyListener(webConfigFieldListener);

		chkXADatasource.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent evt) {
				model.getRdbmsConfig().setXaDs(chkXADatasource.getSelection());
				rdbmsFieldListener.modifyText(null);
			}
			
			public void widgetDefaultSelected(SelectionEvent evt) {		
				widgetSelected(evt);
			}
		});
		
		txtDataSourceId.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				model.setDataSourceId(txtDataSourceId.getText());
				if(txtDataSourceId.getText().trim().equals("") ){
					setPageComplete(false);
					setErrorMessage("DataSource Id Required");
				}else{
					setPageComplete(true);
					setErrorMessage(null);
				}
				
			}
		});
		
		setPageComplete(false);
		
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
				RegistryTreeBrowserDialog.SELECT_REGISTRY_RESOURCE,
				defaultPathId);
		r.create();
		List<RegistryURLInfo> allRegistryUrls = RegistryUrlStore.getInstance()
				.getAllRegistryUrls();
		for (RegistryURLInfo registryURLInfo : allRegistryUrls) {
			r.addRegistryNode(registryURLInfo, null);
		}
		if (r.open() == Window.OK) {
			selectedRegistryResourceNode = r
					.getSelectedRegistryResourceNodeResource();
			String ResourcePath = selectedRegistryResourceNode
					.getRegistryResourcePath();
			if (ResourcePath.startsWith("/_system/config")) {
				textBox.setText(ResourcePath.replaceFirst("/_system/config",
						"conf:"));
			} else if (ResourcePath.startsWith("/_system/governance")) {
				textBox.setText(ResourcePath.replaceFirst(
						"/_system/governance", "gov:"));
			} else {
				MessageBox msgBox = new MessageBox(getShell(),
						SWT.ICON_INFORMATION);
				msgBox.setMessage("invalid selection.");
				msgBox.open();
			}
		}
	}
	
	
	public boolean isPageComplete() {
		return super.isPageComplete();
	}
	
	
}
