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


import org.eclipse.jdt.internal.ui.wizards.dialogfields.ComboDialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.LayoutUtil;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.SelectionButtonDialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.StringDialogField;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.CTabFolder;
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
	private Text txtSecretAliasPassword;
	
	/* Cassandra DS controls */
	private Text txtCassandraServerUrl;
	private Text txtCassandraUserName;
	private Text txtCassandraPassword;
	private Text txtCassandraSecretAliasPassword;
	
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
	private Text txtJndiSecretAliasPassword;
	
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
    private FieldDecoration fd;
    private Composite mainContainer;
    private FormLayout layout;

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


	@SuppressWarnings("restriction")
    public void createControl(Composite parent) {
//		Composite container = new Composite(parent, SWT.NULL);
		
		
		final Composite composite= new Composite(parent, SWT.NULL);
        composite.setFont(parent.getFont());
        composite.setLayout(initGridLayout(new GridLayout(1, false), true));
        composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
        
//        Control nameControl= createNameControl(composite);
        
//        Label lblDataSourceId = new Label(composite, SWT.BORDER);
//      lblDataSourceId.setText("DataSource Id");
        
		StringDialogField fNameField= new StringDialogField();
        fNameField.setLabelText("DataSource Id");
//        fNameField.setDialogFieldListener(this);
        
        Composite nameComposite= new Composite(composite, SWT.NONE);
        nameComposite.setFont(composite.getFont());
        nameComposite.setLayout(new GridLayout(2, false));
        nameComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//        
        fNameField.doFillIntoGrid(nameComposite, 2);
        LayoutUtil.setHorizontalGrabbing(fNameField.getTextControl(null));
        
        
        ControlDecoration cdtxtDataSourceId = new ControlDecoration(fNameField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
        fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
        cdtxtDataSourceId.setImage(fd.getImage());
        
        
        final ComboDialogField dstype= new ComboDialogField(SWT.READ_ONLY);
        dstype.setLabelText("Data Source Type ");
        dstype.setItems(dataSourceType);
        dstype.doFillIntoGrid(nameComposite, 2);
//        LayoutUtil.setHorizontalGrabbing(dstype.getTextControl(null));
        
        ControlDecoration cdcmbDataSourceType = new ControlDecoration(dstype.getComboControl(null), SWT.LEFT | SWT.TOP);
        cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
        cdcmbDataSourceType.setImage(fd.getImage());
        
        IDialogFieldListener listner = new IDialogFieldListener() {

            @Override
            public void dialogFieldChanged(DialogField field) {
                // TODO Auto-generated method stub
                System.out.println(dataSourceType[dstype.getSelectionIndex()]);
            }};
        dstype.setDialogFieldListener(listner);
        
        
        Composite rdbmsContainer = new Composite(composite,SWT.NONE);
        rdbmsContainer.setLayout(new GridLayout(4, false));
        
        
        final ComboDialogField dbEngineType= new ComboDialogField(SWT.READ_ONLY);
        dbEngineType.setLabelText("Database Engine  ");
        dbEngineType.setItems(dataSourceType);
        dbEngineType.doFillIntoGrid(rdbmsContainer, 2);
        
        ControlDecoration cdcmbDatabaseEngine = new ControlDecoration(dbEngineType.getComboControl(null), SWT.LEFT | SWT.TOP);
        cdcmbDatabaseEngine.setDescriptionText("Select Database Engine");
        cdcmbDatabaseEngine.setImage(fd.getImage());
        
        Button configure = new Button(rdbmsContainer, SWT.NONE);
        configure.setText("Configure");
        
        SelectionButtonDialogField xa = new SelectionButtonDialogField(SWT.CHECK);
        xa.setLabelText("XA-Datasource class");
        xa.doFillIntoGrid(rdbmsContainer,1);
        
        
        StringDialogField driverClassField= new StringDialogField();
        driverClassField.setLabelText("Driver Class");
        driverClassField.doFillIntoGrid(rdbmsContainer, 4);
        LayoutUtil.setHorizontalGrabbing(driverClassField.getTextControl(null));
        
        
        
        final ControlDecoration cdtxtDriverClass = new ControlDecoration(driverClassField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtDriverClass.setDescriptionText("JDBC Driver Required");
        cdtxtDriverClass.setImage(fd.getImage());
        
        StringDialogField jdbcURLField= new StringDialogField();
        jdbcURLField.setLabelText("JDBC URL");
        jdbcURLField.doFillIntoGrid(rdbmsContainer, 4);
        LayoutUtil.setHorizontalGrabbing(jdbcURLField.getTextControl(null));
        
        
        ControlDecoration cdtxtJdbcUrl = new ControlDecoration(jdbcURLField.getTextControl(null), SWT.LEFT | SWT.TOP);
        cdtxtJdbcUrl.setDescriptionText("JDBC Url Required");
        cdtxtJdbcUrl.setImage(fd.getImage());
        
        
        StringDialogField usernameField= new StringDialogField();
        usernameField.setLabelText("Username");
       
        usernameField.doFillIntoGrid(rdbmsContainer, 2);
        LayoutUtil.setHorizontalGrabbing(usernameField.getTextControl(null));
        
//        StringDialogField emptyField= new StringDialogField();
//        emptyField.setLabelText("JDBC URL");
//        emptyField.doFillIntoGrid(rdbmsContainer, 2);
//        LayoutUtil.setHorizontalGrabbing(emptyField.getTextControl(null));
      
        StringDialogField passwordField= new StringDialogField();
        passwordField.setLabelText("Password");
        passwordField.createEmptySpace(rdbmsContainer,2);
        passwordField.doFillIntoGrid(rdbmsContainer, 2);
        LayoutUtil.setHorizontalGrabbing(passwordField.getTextControl(null));
        
//        SelectionListener sl = SelectionListener(new SelectionAdapter() {
//          
//          public void widgetSelected(SelectionEvent e) {
//              setPageComplete(false);
//              
//              int selectedIndex = ((Combo)e.widget).getSelectionIndex();
//              if( rdbmsType.length > selectedIndex && selectedIndex!=-1 ){
//                  tabConfig.setSelection(selectedIndex);
//                  model.setDataSourceConfig(selectedIndex);
//              switch (selectedIndex) {
//              case 0:
//                  rdbmsFieldListener.modifyText(null);
//                  break;                  
//              case 1:
//                  cassandraFieldListener.modifyText(null);
//                  break;                  
//              case 2:
//                  csvFieldListener.modifyText(null);
//                  break;
//              case 3:
//                  excelFieldListener.modifyText(null);
//                  break;
//              case 4:
//                  rdfFieldListener.modifyText(null);
//                  break;
//              case 5:
//                  jndiFieldListener.modifyText(null);
//                  break;
//              case 6:
//                  gspreadFieldListener.modifyText(null);
//                  break;
//              case 7:
//                  carbonFieldListener.modifyText(null);
//                  break;
//              case 8:
//                  webConfigFieldListener.modifyText(null);
//                  break;
//              default:
//                  setPageComplete(false);
//                  break;
//              }
//              }
//          }
//      });
        
        
        
        
        setControl(composite);
//
//		setControl(container);
//		
		model = (DataServiceModel) ((DataServiceCreationWizard)getWizard()).getModel();
//		
//		layout = new FormLayout();
//		
//		container.setLayout(layout);
//
////		GridData gd_leftcol = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
////		gd_leftcol.widthHint = 130;
//		
//		mainContainer = new Composite(container,SWT.NONE);
//        mainContainer.setLayout(layout);
//       
//		Label lblDataSourceId = new Label(mainContainer, SWT.NONE);
//		lblDataSourceId.setText("DataSource Id");
//		
//		{
//            FormData layoutData = new FormData();
//            layoutData.top = new FormAttachment(container,15);
//            layoutData.left = new FormAttachment(1);
//            layoutData.right = new FormAttachment(20);
//            lblDataSourceId.setLayoutData(layoutData);
//		}
//		
//		txtDataSourceId = new Text(mainContainer, SWT.BORDER);
//		txtDataSourceId.setText("");
//		model.setDataSourceId("");
//		
//		{
//		    FormData layoutData = new FormData();
//            layoutData.top = new FormAttachment(container,10);
//            layoutData.left = new FormAttachment(lblDataSourceId);
//            layoutData.right = new FormAttachment(99);
//            txtDataSourceId.setLayoutData(layoutData);
//		}
//
//		ControlDecoration cdtxtDataSourceId = new ControlDecoration(txtDataSourceId, SWT.LEFT | SWT.TOP);
//		cdtxtDataSourceId.setDescriptionText("DataSource ID Required");
//		fd = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION);
//		cdtxtDataSourceId.setImage(fd.getImage());
//		
//		Label lblDataSourceType = new Label(mainContainer, SWT.NONE);
//		lblDataSourceType.setText("Data Source Type");
//		{
//            FormData layoutData = new FormData();
//            layoutData.top = new FormAttachment(lblDataSourceId,15);
//            layoutData.left = new FormAttachment(1);
//            layoutData.right = new FormAttachment(20);
//            lblDataSourceType.setLayoutData(layoutData);
//        }
//
//		Combo cmbDataSourceType = new Combo(mainContainer, SWT.READ_ONLY);
//		cmbDataSourceType.setItems(dataSourceType);
//		cmbDataSourceType.setText("RDBMS");
//		ControlDecoration cdcmbDataSourceType = new ControlDecoration(cmbDataSourceType, SWT.LEFT | SWT.TOP);
//		cdcmbDataSourceType.setDescriptionText("Data Source Type Required");
//		cdcmbDataSourceType.setImage(fd.getImage());
//		{
//            FormData layoutData = new FormData();
//            layoutData.top = new FormAttachment(txtDataSourceId,5);
//            layoutData.left = new FormAttachment(lblDataSourceType);
//            layoutData.right = new FormAttachment(99);
//            layoutData.bottom = new FormAttachment(tabConfig);
//            cmbDataSourceType.setLayoutData(layoutData);
//        }
//		
//		tabConfig = new CTabFolder(container, SWT.NONE);
//		tabConfig.setTabHeight(0);
//		
//		tabConfig.setSingle(true);
//		tabConfig.setBorderVisible(false);
//		tabConfig.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
//		tabConfig.setLayout(layout);
//
//        {
//            FormData layoutData = new FormData();
//            layoutData.top = new FormAttachment(mainContainer, 10);
//            layoutData.left = new FormAttachment(0);
//            layoutData.right = new FormAttachment(99);
//            tabConfig.setLayoutData(layoutData);
//        }
//		
//     
//        createRDBMSComponents();
//		
//		createCassandraComponents();
//
//		createCSVComponents();
//        
//		createExcelComponents();
//		
//		createRDFComponents();
//		
//		createJNDIComponents();
//		
//		createGoogleSpreadSheetComponents();
//		
//		createCarbonDataSourceComponents();
//		
//		createWebDataServiceComponents();
//		
//		tabConfig.setSelection(0);
//		model.setDataSourceConfig(0);
//	
//		cmbDataSourceType.addSelectionListener(new SelectionAdapter() {
//			
//			public void widgetSelected(SelectionEvent e) {
//				setPageComplete(false);
//				
//				int selectedIndex = ((Combo)e.widget).getSelectionIndex();
//				if( rdbmsType.length > selectedIndex && selectedIndex!=-1 ){
//					tabConfig.setSelection(selectedIndex);
//					model.setDataSourceConfig(selectedIndex);
//				switch (selectedIndex) {
//				case 0:
//					rdbmsFieldListener.modifyText(null);
//					break;					
//				case 1:
//					cassandraFieldListener.modifyText(null);
//					break;					
//				case 2:
//					csvFieldListener.modifyText(null);
//					break;
//				case 3:
//					excelFieldListener.modifyText(null);
//					break;
//				case 4:
//					rdfFieldListener.modifyText(null);
//					break;
//				case 5:
//					jndiFieldListener.modifyText(null);
//					break;
//				case 6:
//					gspreadFieldListener.modifyText(null);
//					break;
//				case 7:
//					carbonFieldListener.modifyText(null);
//					break;
//				case 8:
//					webConfigFieldListener.modifyText(null);
//					break;
//				default:
//					setPageComplete(false);
//					break;
//				}
//				}
//			}
//		});
//				
//		txtDataSourceId.addModifyListener(new ModifyListener() {
//			
//			public void modifyText(ModifyEvent evt) {
//				model.setDataSourceId(txtDataSourceId.getText());
//				if(txtDataSourceId.getText().trim().equals("") ){
//					setPageComplete(false);
//					setErrorMessage("DataSource Id Required");
//				}else{
//					setPageComplete(true);
//					setErrorMessage(null);
//				}
//				
//			}
//		});
//		
		setPageComplete(false);
		
	}
	
    private GridLayout initGridLayout(GridLayout layout, boolean margins) {
        layout.horizontalSpacing= convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        layout.verticalSpacing= convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        if (margins) {
            layout.marginWidth= convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
            layout.marginHeight= convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        } else {
            layout.marginWidth= 0;
            layout.marginHeight= 0;
        }
        return layout;
    }


    private void createWebDataServiceComponents() {
        tbtmWDS = new CTabItem(tabConfig, SWT.NONE);

        // Web Data source configuration controls
        cWDS = new Composite(tabConfig, SWT.NONE);
        tbtmWDS.setControl(cWDS);
        cWDS.setLayout(layout);

        final Button OptWebHarvestConfig = new Button(cWDS, SWT.RADIO);
        OptWebHarvestConfig.setSelection(true);
        OptWebHarvestConfig.setText("Web Harvest Config File Path");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cWDS, 5);
            layoutData.left = new FormAttachment(20);
            layoutData.right = new FormAttachment(50);
            OptWebHarvestConfig.setLayoutData(layoutData);
        }

        final Button btnInlineWebHarvest = new Button(cWDS, SWT.RADIO);
        btnInlineWebHarvest.setText("Inline Web Harvest Config ");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cWDS, 5);
            layoutData.left = new FormAttachment(OptWebHarvestConfig);
            layoutData.right = new FormAttachment(99);
            btnInlineWebHarvest.setLayoutData(layoutData);
        }

        final Label lblWebConfigPath = new Label(cWDS, SWT.NONE);
        lblWebConfigPath.setText("Config Path");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(OptWebHarvestConfig, 5);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblWebConfigPath.setLayoutData(layoutData);
        }

        txtWebConfigPath = new Text(cWDS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(btnInlineWebHarvest, 5);
            layoutData.left = new FormAttachment(lblWebConfigPath);
            layoutData.right = new FormAttachment(99);
            txtWebConfigPath.setLayoutData(layoutData);
        }

        final ControlDecoration cdtxtWebConfigPath = new ControlDecoration(txtWebConfigPath, SWT.LEFT | SWT.TOP);
        cdtxtWebConfigPath.setDescriptionText("WebConfig Path required");
        cdtxtWebConfigPath.setImage(fd.getImage());

        txtWebConfigText = new Text(cWDS, SWT.BORDER | SWT.WRAP | SWT.MULTI);
        txtWebConfigText.setVisible(false);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(btnInlineWebHarvest, 5);
            layoutData.left = new FormAttachment(lblWebConfigPath);
            layoutData.right = new FormAttachment(99);
            layoutData.bottom = new FormAttachment(80);
            txtWebConfigText.setLayoutData(layoutData);
        }

        final ControlDecoration cdtxtWebConfigText = new ControlDecoration(txtWebConfigText, SWT.LEFT | SWT.TOP);
        cdtxtWebConfigText.setDescriptionText("WebConfig Text required");
        cdtxtWebConfigText.setImage(fd.getImage());

        Label lblWebConfigHidden = new Label(cWDS, SWT.NONE);
        lblWebConfigHidden.setText("");

        btnInlineWebHarvest.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                boolean visible = (((Button) e.widget).getSelection());
                lblWebConfigPath.setText((visible) ? "Config:" : "Config Path");
                txtWebConfigPath.setVisible(!visible);
                txtWebConfigText.setVisible(visible);
            }
        });

        OptWebHarvestConfig.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                if (OptWebHarvestConfig.getSelection()) {
                    txtWebConfigPath.setText("");
                    cdtxtWebConfigText.hide();
                    cdtxtWebConfigPath.show();
                } else {
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
                model.getWebDataSourceConfig().setWebConfigInlineText(
                        txtWebConfigText.getText().replaceAll(txtWebConfigText.getLineDelimiter(), "&#xd;"));
                model.getWebDataSourceConfig().setWebConfigPath(txtWebConfigPath.getText());
                if (btnInlineWebHarvest.getSelection()) {
                    if (txtWebConfigText.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing or invalid");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                } else {
                    if (txtWebConfigPath.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing or invalid");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                }
            }
        };

        txtWebConfigPath.addModifyListener(webConfigFieldListener);
        txtWebConfigText.addModifyListener(webConfigFieldListener);

    }


    private void createCarbonDataSourceComponents() {
        tbtmCDS = new CTabItem(tabConfig, SWT.NONE);

        // Carbon Data source configuration controls
        Composite cCDS = new Composite(tabConfig, SWT.NONE);
        tbtmCDS.setControl(cCDS);
        cCDS.setLayout(layout);

        Label lblDataSourceName = new Label(cCDS, SWT.NONE);
        lblDataSourceName.setText("Data Source Name");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCDS, 10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblDataSourceName.setLayoutData(layoutData);
        }
        txtCarbonDataSourceName = new Text(cCDS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCDS, 5);
            layoutData.left = new FormAttachment(lblDataSourceName);
            layoutData.right = new FormAttachment(99);
            txtCarbonDataSourceName.setLayoutData(layoutData);
        }
        ControlDecoration cdtxtCarbonDataSourceName = new ControlDecoration(txtCarbonDataSourceName,
                SWT.LEFT | SWT.TOP);
        cdtxtCarbonDataSourceName.setDescriptionText("Carbon DataSource name required");
        cdtxtCarbonDataSourceName.setImage(fd.getImage());

        Label lblCarbonHidden = new Label(cCDS, SWT.NONE);
        lblCarbonHidden.setText("");
        
        carbonFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                model.getCarbonDataConfig().setCarbonDataSourceName(txtCarbonDataSourceName.getText());
                if (txtCarbonDataSourceName.getText().trim().equals("")
                        || txtDataSourceId.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
            }
        };

        txtCarbonDataSourceName.addModifyListener(carbonFieldListener);
    }


    private void createGoogleSpreadSheetComponents() {
        // Google Spreadsheet Data source configuration controls
        tbtmGSS = new CTabItem(tabConfig, SWT.NONE);

        Composite cGSS = new Composite(tabConfig, SWT.NONE);
        tbtmGSS.setControl(cGSS);
        cGSS.setLayout(layout);

        Label lblGoogleSpreadsheetUrl = new Label(cGSS, SWT.NONE);
        lblGoogleSpreadsheetUrl.setText("Spreadsheet URL");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cGSS, 10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblGoogleSpreadsheetUrl.setLayoutData(layoutData);
        }

        txtlblGoogleSpreadsheetUrl = new Text(cGSS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cGSS, 5);
            layoutData.left = new FormAttachment(lblGoogleSpreadsheetUrl);
            layoutData.right = new FormAttachment(99);
            txtlblGoogleSpreadsheetUrl.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtlblGoogleSpreadsheetUrl = new ControlDecoration(txtlblGoogleSpreadsheetUrl,
                SWT.LEFT | SWT.TOP);
        cdtxtlblGoogleSpreadsheetUrl.setDescriptionText("Spreadsheet Url required");
        cdtxtlblGoogleSpreadsheetUrl.setImage(fd.getImage());

        Label lblVisibility = new Label(cGSS, SWT.NONE);
        lblVisibility.setText("Visibility");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblGoogleSpreadsheetUrl, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblVisibility.setLayoutData(layoutData);
        }

        final Button optPublic = new Button(cGSS, SWT.RADIO);
        optPublic.setSelection(true);
        optPublic.setText("public");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtlblGoogleSpreadsheetUrl, 10);
            layoutData.left = new FormAttachment(lblVisibility);
            layoutData.right = new FormAttachment(40);
            optPublic.setLayoutData(layoutData);
        }

        final Button optPrivate = new Button(cGSS, SWT.RADIO);
        optPrivate.setText("Private");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtlblGoogleSpreadsheetUrl, 10);
            layoutData.left = new FormAttachment(optPublic);
            layoutData.right = new FormAttachment(50);
            optPrivate.setLayoutData(layoutData);
        }

        final Label lblGoogleUsername = new Label(cGSS, SWT.NONE);
        lblGoogleUsername.setText("User Name");
        lblGoogleUsername.setVisible(false);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblVisibility, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblGoogleUsername.setLayoutData(layoutData);
        }

        txtGoogleUserName = new Text(cGSS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(optPublic, 5);
            layoutData.left = new FormAttachment(lblGoogleUsername);
            layoutData.right = new FormAttachment(50);
            txtGoogleUserName.setLayoutData(layoutData);
        }
        // txtGoogleUserName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        txtGoogleUserName.setVisible(false);

        final ControlDecoration cdtxtGoogleUserName = new ControlDecoration(txtGoogleUserName, SWT.LEFT | SWT.TOP);
        cdtxtGoogleUserName.setDescriptionText("UserName required");
        cdtxtGoogleUserName.setImage(fd.getImage());

        final Label lblGooglePassword = new Label(cGSS, SWT.NONE);
        lblGooglePassword.setText("Password");
        lblGooglePassword.setVisible(false);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblGoogleUsername, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblGooglePassword.setLayoutData(layoutData);
        }

        txtGooglePassword = new Text(cGSS, SWT.BORDER | SWT.PASSWORD);
        txtGooglePassword.setVisible(false);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtGoogleUserName, 5);
            layoutData.left = new FormAttachment(lblGooglePassword);
            layoutData.right = new FormAttachment(50);
            txtGooglePassword.setLayoutData(layoutData);
        }

        final ControlDecoration cdtxtGooglePassword = new ControlDecoration(txtGooglePassword, SWT.LEFT | SWT.TOP);
        cdtxtGooglePassword.setDescriptionText("password required");
        cdtxtGooglePassword.setImage(fd.getImage());

        Label lblgHidden = new Label(cGSS, SWT.NONE);
        lblgHidden.setText("");

        optPrivate.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                boolean visible = (((Button) e.widget).getSelection());
                lblGoogleUsername.setVisible(visible);
                txtGoogleUserName.setVisible(visible);
                lblGooglePassword.setVisible(visible);
                txtGooglePassword.setVisible(visible);
            }
        });

        gspreadFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                model.getGoogleSpreadsheetConfig().setSpreadsheetURL(txtlblGoogleSpreadsheetUrl.getText());
                model.getGoogleSpreadsheetConfig().setPublicVisible(optPublic.getSelection());
                model.getGoogleSpreadsheetConfig().setUserName(txtGoogleUserName.getText());
                model.getGoogleSpreadsheetConfig().setPassword(txtGooglePassword.getText());
                if (optPublic.getSelection()) {
                    cdtxtGoogleUserName.hide();
                    cdtxtGooglePassword.hide();
                    if (txtlblGoogleSpreadsheetUrl.getText().trim().equals("")
                            || txtDataSourceId.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                } else {
                    cdtxtGoogleUserName.show();
                    cdtxtGooglePassword.show();
                    if (txtlblGoogleSpreadsheetUrl.getText().trim().equals("")
                            || txtGoogleUserName.getText().trim().equals("")
                            || txtGooglePassword.getText().trim().equals("")
                            || txtDataSourceId.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
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

    }


    private void createJNDIComponents() {
        // JNDI Data source configuration controls
        tbtmJNDI = new CTabItem(tabConfig, SWT.NONE);

        final Composite cJNDI = new Composite(tabConfig, SWT.NONE);
        tbtmJNDI.setControl(cJNDI);
        cJNDI.setLayout(layout);

        Label lblJndiContextClass = new Label(cJNDI, SWT.NONE);
        lblJndiContextClass.setText("JNDI Context Class");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cJNDI, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblJndiContextClass.setLayoutData(layoutData);
        }

        txtJndiContextClass = new Text(cJNDI, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cJNDI, 5);
            layoutData.left = new FormAttachment(lblJndiContextClass);
            layoutData.right = new FormAttachment(99);
            txtJndiContextClass.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtJndiContextClass = new ControlDecoration(txtJndiContextClass, SWT.LEFT | SWT.TOP);
        cdtxtJndiContextClass.setDescriptionText("JNDI Context Class required");
        cdtxtJndiContextClass.setImage(fd.getImage());

        Label lblProviderUrl = new Label(cJNDI, SWT.NONE);
        lblProviderUrl.setText("Provider URL");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblJndiContextClass, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblProviderUrl.setLayoutData(layoutData);
        }

        txtProviderUrl = new Text(cJNDI, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtJndiContextClass, 5);
            layoutData.left = new FormAttachment(lblProviderUrl);
            layoutData.right = new FormAttachment(99);
            txtProviderUrl.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtProviderUrl = new ControlDecoration(txtProviderUrl, SWT.LEFT | SWT.TOP);
        cdtxtProviderUrl.setDescriptionText("Provider URL required");
        cdtxtProviderUrl.setImage(fd.getImage());

        Label lblResourceName = new Label(cJNDI, SWT.NONE);
        lblResourceName.setText("Resource Name");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblProviderUrl, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblResourceName.setLayoutData(layoutData);
        }

        txtResourceName = new Text(cJNDI, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtProviderUrl, 5);
            layoutData.left = new FormAttachment(lblResourceName);
            layoutData.right = new FormAttachment(99);
            txtResourceName.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtResourceName = new ControlDecoration(txtResourceName, SWT.LEFT | SWT.TOP);
        cdtxtResourceName.setDescriptionText("Resource Name required");
        cdtxtResourceName.setImage(fd.getImage());

        Label lblJndiPassword = new Label(cJNDI, SWT.NONE);
        lblJndiPassword.setText("Password");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblResourceName, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblJndiPassword.setLayoutData(layoutData);
        }

        txtJndiPassword = new Text(cJNDI, SWT.BORDER | SWT.PASSWORD);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtResourceName, 5);
            layoutData.left = new FormAttachment(lblJndiPassword);
            layoutData.right = new FormAttachment(50);
            txtJndiPassword.setLayoutData(layoutData);
        }

        final ControlDecoration cdtxtJndiPassword = new ControlDecoration(txtJndiPassword, SWT.LEFT | SWT.TOP);
        cdtxtJndiPassword.setDescriptionText("password required");
        cdtxtJndiPassword.setImage(fd.getImage());

        txtJndiSecretAliasPassword = new Text(cJNDI, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtResourceName, 5);
            layoutData.left = new FormAttachment(lblJndiPassword);
            layoutData.right = new FormAttachment(50);
            txtJndiSecretAliasPassword.setLayoutData(layoutData);
        }
        txtJndiSecretAliasPassword.setVisible(false);

        final ControlDecoration cdtxtJNDISecretAliasPassword = new ControlDecoration(txtJndiSecretAliasPassword,
                SWT.LEFT | SWT.TOP);
        cdtxtJNDISecretAliasPassword.setDescriptionText("Secret alias name is required for JNDI");

        final Button checkJNDISecretAlias = new Button(cJNDI, SWT.CHECK);
        checkJNDISecretAlias.setText("Use as Secret Alias");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtResourceName, 5);
            layoutData.left = new FormAttachment(txtJndiPassword);
            layoutData.right = new FormAttachment(70);
            checkJNDISecretAlias.setLayoutData(layoutData);
        }

        Label lblJndiHidden = new Label(cJNDI, SWT.NONE);
        lblJndiHidden.setText("");

        checkJNDISecretAlias.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                boolean isEnabled = (((Button) e.widget).getSelection());
                txtJndiPassword.setVisible(!isEnabled);
                txtJndiPassword.setText("");

                txtJndiSecretAliasPassword.setVisible(isEnabled);
                txtJndiSecretAliasPassword.setText("");
                if (isEnabled) {
                    cdtxtJNDISecretAliasPassword.show();
                    cdtxtJndiPassword.hide();
                } else {
                    cdtxtJNDISecretAliasPassword.hide();
                    cdtxtJndiPassword.show();
                }
                cJNDI.layout();
            }
        });

        jndiFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                model.getJndiConfig().setJndiContextClass(txtJndiContextClass.getText());
                model.getJndiConfig().setProvideUrl(txtProviderUrl.getText());
                model.getJndiConfig().setResourceName(txtResourceName.getText());
                boolean isSecretAliasEnabled = checkJNDISecretAlias.getSelection();
                model.getJndiConfig().setSecretAlias(isSecretAliasEnabled);
                if (isSecretAliasEnabled) {
                    model.getJndiConfig().setPassword(txtJndiSecretAliasPassword.getText());
                } else {
                    model.getJndiConfig().setPassword(txtJndiPassword.getText());
                }
                if (txtJndiContextClass.getText().trim().equals("") || txtProviderUrl.getText().trim().equals("")
                        || txtResourceName.getText().trim().equals("") || txtJndiPassword.getText().trim().equals("")
                        || txtDataSourceId.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }

            }
        };

        txtJndiContextClass.addModifyListener(jndiFieldListener);
        txtProviderUrl.addModifyListener(jndiFieldListener);
        txtResourceName.addModifyListener(jndiFieldListener);
        txtJndiPassword.addModifyListener(jndiFieldListener);
    }


    private void createRDFComponents() {
        // RDF Data source configuration controls
        tbtmRDF = new CTabItem(tabConfig, SWT.NONE);

        Composite cRDF = new Composite(tabConfig, SWT.NONE);
        tbtmRDF.setControl(cRDF);
        cRDF.setLayout(layout);

        Label lblRDFFileLocation = new Label(cRDF, SWT.NONE);
        lblRDFFileLocation.setText("RDF File Location");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDF, 10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblRDFFileLocation.setLayoutData(layoutData);
        }

        txtRDFFileLocation = new Text(cRDF, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDF, 5);
            layoutData.left = new FormAttachment(lblRDFFileLocation);
            layoutData.right = new FormAttachment(80);
            txtRDFFileLocation.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtRDFFileLocation = new ControlDecoration(txtRDFFileLocation, SWT.LEFT | SWT.TOP);
        cdtxtRDFFileLocation.setDescriptionText("RDF file location required");
        cdtxtRDFFileLocation.setImage(fd.getImage());

        Button cmdRdfKeyConRegBrowse = new Button(cRDF, SWT.NONE);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDF, 7);
            layoutData.left = new FormAttachment(txtRDFFileLocation,5);
            layoutData.right = new FormAttachment(85);
            cmdRdfKeyConRegBrowse.setLayoutData(layoutData);
        }
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
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDF, 7);
            layoutData.left = new FormAttachment(cmdRdfKeyConRegBrowse,5);
            layoutData.right = new FormAttachment(90);
            cmdRdfKeyGovRegBrowse.setLayoutData(layoutData);
        }
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

        rdfFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                model.getRdfConfig().setRdfFileLocation(txtRDFFileLocation.getText());
                if (txtRDFFileLocation.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
            }
        };

        txtRDFFileLocation.addModifyListener(rdfFieldListener);
    }


    private void createExcelComponents() {
        tbtmEXCEL = new CTabItem(tabConfig, SWT.NONE);

        // Excel Data source configuration controls
        Composite cEXCEL = new Composite(tabConfig, SWT.NONE);
        tbtmEXCEL.setControl(cEXCEL);
        cEXCEL.setLayout(layout);;

        Label lblExcelFileLocation = new Label(cEXCEL, SWT.NONE);
        lblExcelFileLocation.setText("EXCEL File Location");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cEXCEL, 10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblExcelFileLocation.setLayoutData(layoutData);
        }

        txtExcelFileLocation = new Text(cEXCEL, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cEXCEL, 5);
            layoutData.left = new FormAttachment(lblExcelFileLocation);
            layoutData.right = new FormAttachment(80);
            txtExcelFileLocation.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtExcelFileLocation = new ControlDecoration(txtExcelFileLocation, SWT.LEFT | SWT.TOP);
        cdtxtExcelFileLocation.setDescriptionText("Excel file location required");
        cdtxtExcelFileLocation.setImage(fd.getImage());

        Button cmdExcelKeyConRegBrowse = new Button(cEXCEL, SWT.NONE);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cEXCEL, 7);
            layoutData.left = new FormAttachment(txtExcelFileLocation,5);
            layoutData.right = new FormAttachment(85);
            cmdExcelKeyConRegBrowse.setLayoutData(layoutData);
        }
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
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cEXCEL, 7);
            layoutData.left = new FormAttachment(cmdExcelKeyConRegBrowse,5);
            layoutData.right = new FormAttachment(90);
            cmdExcelKeyGovRegBrowse.setLayoutData(layoutData);
        }
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

        excelFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                model.getExcelConfig().setExcelFileLocation(txtExcelFileLocation.getText());
                if (txtExcelFileLocation.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
            }
        };
        
        txtExcelFileLocation.addModifyListener(excelFieldListener);

    }


    private void createCSVComponents() {

        // CSV Data source configuration controls
        tbtmCSV = new CTabItem(tabConfig, SWT.NONE);

        Composite cCSV = new Composite(tabConfig, SWT.NONE);
        tbtmCSV.setControl(cCSV);
        cCSV.setLayout(layout);

        Label lblCsvFileLocation = new Label(cCSV, SWT.NONE);
        lblCsvFileLocation.setText("CSV File Location");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCSV, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblCsvFileLocation.setLayoutData(layoutData);
        }

        txtCsvFileLocation = new Text(cCSV, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCSV, 5);
            layoutData.left = new FormAttachment(lblCsvFileLocation);
            layoutData.right = new FormAttachment(80);
            txtCsvFileLocation.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtCsvFileLocation = new ControlDecoration(txtCsvFileLocation, SWT.LEFT | SWT.TOP);
        cdtxtCsvFileLocation.setDescriptionText("CSV file location required");
        cdtxtCsvFileLocation.setImage(fd.getImage());

        Button cmdCsvKeyConRegBrowse = new Button(cCSV, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCSV, 7);
            layoutData.left = new FormAttachment(txtCsvFileLocation,5);
            layoutData.right = new FormAttachment(85);
            cmdCsvKeyConRegBrowse.setLayoutData(layoutData);
        }
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
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCSV, 7);
            layoutData.left = new FormAttachment(cmdCsvKeyConRegBrowse,5);
            layoutData.right = new FormAttachment(90);
            cmdCsvKeyGovRegBrowse.setLayoutData(layoutData);
        }
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
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblCsvFileLocation, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblColumnSeperator.setLayoutData(layoutData);
        }

        txtColumnSeperator = new Text(cCSV, SWT.BORDER);
        txtColumnSeperator.setText(",");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtCsvFileLocation, 5);
            layoutData.left = new FormAttachment(lblColumnSeperator);
            layoutData.right = new FormAttachment(99);
            txtColumnSeperator.setLayoutData(layoutData);
        }

        Label lblStartReadingFrom = new Label(cCSV, SWT.NONE);
        lblStartReadingFrom.setText("Start From Row");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblColumnSeperator, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblStartReadingFrom.setLayoutData(layoutData);
        }

        txtStartReadingFromRow = new Text(cCSV, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtColumnSeperator, 5);
            layoutData.left = new FormAttachment(lblStartReadingFrom);
            layoutData.right = new FormAttachment(99);
            txtStartReadingFromRow.setLayoutData(layoutData);
        }

        Label lblMaxRowsTo = new Label(cCSV, SWT.NONE);
        lblMaxRowsTo.setText("Max Rows To Read");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblStartReadingFrom, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblMaxRowsTo.setLayoutData(layoutData);
        }

        txtMaxRowsTo = new Text(cCSV, SWT.BORDER);
        txtMaxRowsTo.setText("-1");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtStartReadingFromRow, 5);
            layoutData.left = new FormAttachment(lblMaxRowsTo);
            layoutData.right = new FormAttachment(99);
            txtMaxRowsTo.setLayoutData(layoutData);
        }

        Label lblColumnHeaderRow = new Label(cCSV, SWT.NONE);
        lblColumnHeaderRow.setText("Contains Column \nHeader Row");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblMaxRowsTo, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblColumnHeaderRow.setLayoutData(layoutData);
        }

        final Button chkColumnHeaderRow = new Button(cCSV, SWT.CHECK);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtMaxRowsTo, 10);
            layoutData.left = new FormAttachment(lblColumnHeaderRow);
            layoutData.right = new FormAttachment(25);
            chkColumnHeaderRow.setLayoutData(layoutData);
        }

        Label lblCsvHidden = new Label(cCSV, SWT.NONE);
        lblCsvHidden.setText("");

      
        
        chkColumnHeaderRow.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                model.getCsvConfig().setContainsColumnHeaderRow(chkColumnHeaderRow.getSelection());
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);

            }
        });

        csvFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent text) {
                model.getCsvConfig().setCsvFileLocation(txtCsvFileLocation.getText());
                model.getCsvConfig().setColumnSeperator(txtColumnSeperator.getText());
                try {
                    model.getCsvConfig().setStartReadingFromRow(Integer.parseInt(txtStartReadingFromRow.getText()));
                    model.getCsvConfig().setMaxRowsToRead(Integer.parseInt(txtMaxRowsTo.getText()));
                } catch (NumberFormatException e) {
                    if (!(txtStartReadingFromRow.getText().trim().equals("")
                            || txtMaxRowsTo.getText().trim().equals(""))) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing or invalid");
                        return;
                    }
                }
                if (txtCsvFileLocation.getText().trim().equals("") || txtDataSourceId.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }
            }
        };

        txtCsvFileLocation.addModifyListener(csvFieldListener);
        txtColumnSeperator.addModifyListener(csvFieldListener);
        txtStartReadingFromRow.addModifyListener(csvFieldListener);
        txtMaxRowsTo.addModifyListener(csvFieldListener);
    }


    private void createCassandraComponents() {
        tbtmCASSANDRA = new CTabItem(tabConfig, SWT.NONE);

        final Composite cCassandra = new Composite(tabConfig, SWT.NONE);
        tbtmCASSANDRA.setControl(cCassandra);
        cCassandra.setLayout(layout);

        Label lblCassandraServerUrl = new Label(cCassandra, SWT.NONE);
        lblCassandraServerUrl.setText("Server URL");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCassandra, 10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblCassandraServerUrl.setLayoutData(layoutData);
        }

        txtCassandraServerUrl = new Text(cCassandra, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cCassandra, 5);
            layoutData.left = new FormAttachment(lblCassandraServerUrl);
            layoutData.right = new FormAttachment(99);
            txtCassandraServerUrl.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtCassandraServerUrl = new ControlDecoration(txtCassandraServerUrl, SWT.LEFT | SWT.TOP);
        cdtxtCassandraServerUrl.setDescriptionText("Cassandra Server URL required");
        cdtxtCassandraServerUrl.setImage(fd.getImage());
        
        Label lblCassandraUserName = new Label(cCassandra, SWT.NONE);
        lblCassandraUserName.setText("User Name");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblCassandraServerUrl, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblCassandraUserName.setLayoutData(layoutData);
        }
        
        txtCassandraUserName = new Text(cCassandra, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtCassandraServerUrl,5);
            layoutData.left = new FormAttachment(lblCassandraUserName);
            layoutData.right = new FormAttachment(50);
            txtCassandraUserName.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtCassandraUserName = new ControlDecoration(txtCassandraUserName, SWT.LEFT | SWT.TOP);
        cdtxtCassandraUserName.setDescriptionText("User Name required");
        cdtxtCassandraUserName.setImage(fd.getImage());

        Label lblCassandraPassword = new Label(cCassandra, SWT.NONE);
        lblCassandraPassword.setText("Password");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(lblCassandraUserName, 15);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblCassandraPassword.setLayoutData(layoutData);
        }

        txtCassandraPassword = new Text(cCassandra, SWT.BORDER | SWT.PASSWORD);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtCassandraUserName,5);
            layoutData.left = new FormAttachment(lblCassandraUserName);
            layoutData.right = new FormAttachment(50);
            txtCassandraPassword.setLayoutData(layoutData);
        }

        final ControlDecoration cdtxtCassandraPassword = new ControlDecoration(txtCassandraPassword,
                SWT.LEFT | SWT.TOP);
        cdtxtCassandraPassword.setDescriptionText("Password required");
        cdtxtCassandraPassword.setImage(fd.getImage());

        txtCassandraSecretAliasPassword = new Text(cCassandra, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtCassandraUserName,5);
            layoutData.left = new FormAttachment(lblCassandraUserName);
            layoutData.right = new FormAttachment(50);
            txtCassandraSecretAliasPassword.setLayoutData(layoutData);
        }
        txtCassandraSecretAliasPassword.setVisible(false);

        final ControlDecoration cd_txtCassandraSecretAliasPassword = new ControlDecoration(
                txtCassandraSecretAliasPassword, SWT.LEFT | SWT.TOP);
        cd_txtCassandraSecretAliasPassword.setDescriptionText("Secret alias name for Cassandra db is required");

        final Button checkSecretAliasCassandra = new Button(cCassandra, SWT.CHECK);
        checkSecretAliasCassandra.setText("Use as Secret Alias");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtCassandraUserName, 5);
            layoutData.left = new FormAttachment(txtCassandraSecretAliasPassword);
            layoutData.right = new FormAttachment(70);
            checkSecretAliasCassandra.setLayoutData(layoutData);
        }
        
        Label lblCassandraHidden = new Label(cCassandra, SWT.NONE);
        lblCassandraHidden.setText("");

        checkSecretAliasCassandra.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                boolean isEnabled = (((Button) e.widget).getSelection());
                txtCassandraPassword.setVisible(!isEnabled);
                txtCassandraPassword.setText("");
                txtCassandraSecretAliasPassword.setVisible(isEnabled);
                txtCassandraSecretAliasPassword.setText("");
                if (isEnabled) {
                    cd_txtCassandraSecretAliasPassword.show();
                    cdtxtCassandraPassword.hide();
                } else {
                    cd_txtCassandraSecretAliasPassword.hide();
                    cdtxtCassandraPassword.show();
                }
                cCassandra.layout();
            }
        });

        cassandraFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent text) {

                model.getCassandraConfig().setServerURL(txtCassandraServerUrl.getText());
                model.getCassandraConfig().setUserName(txtCassandraUserName.getText());
                boolean isSecretAliasEnabled = true;
                model.getCassandraConfig().setSecretAlias(isSecretAliasEnabled);
                if (isSecretAliasEnabled) {
                    model.getCassandraConfig().setPassword(txtCassandraSecretAliasPassword.getText());
                } else {
                    model.getCassandraConfig().setPassword(txtCassandraPassword.getText());
                }
                if (txtCassandraServerUrl.getText().trim().equals("")
                        || txtCassandraUserName.getText().trim().equals("")
                        || txtCassandraPassword.getText().trim().equals("")) {
                    setPageComplete(false);
                    setErrorMessage("Required Field(s) are missing or invalid");
                } else {
                    setPageComplete(true);
                    setErrorMessage(null);
                }

            }
        };

        txtCassandraServerUrl.addModifyListener(cassandraFieldListener);
        txtCassandraUserName.addModifyListener(cassandraFieldListener);
        txtCassandraPassword.addModifyListener(cassandraFieldListener);
        txtCassandraSecretAliasPassword.addModifyListener(cassandraFieldListener);
    }


    private void createRDBMSComponents() {
        tbtmRDBMS = new CTabItem(tabConfig, SWT.NONE);

        final Composite cRDBMS = new Composite(tabConfig, SWT.NONE);
        tbtmRDBMS.setControl(cRDBMS);
        {
            cRDBMS.setLayout(layout);
        }

        Label lblDatabaseEngine = new Label(cRDBMS, SWT.NONE);
        lblDatabaseEngine.setText("Database Engine");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDBMS,10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblDatabaseEngine.setLayoutData(layoutData);
        }

        Combo cmbDatabaseEngine = new Combo(cRDBMS, SWT.READ_ONLY);

        cmbDatabaseEngine.setItems(rdbmsType);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDBMS,5);
            layoutData.left = new FormAttachment(lblDatabaseEngine,1);
            layoutData.right = new FormAttachment(60);
            cmbDatabaseEngine.setLayoutData(layoutData);
        }

        ControlDecoration cdcmbDatabaseEngine = new ControlDecoration(cmbDatabaseEngine, SWT.LEFT | SWT.TOP);
        cdcmbDatabaseEngine.setDescriptionText("Select Database Engine");
        cdcmbDatabaseEngine.setImage(fd.getImage());

        cmbDatabaseEngine.setText(rdbmsType[0]);

        final Button configure = new Button(cRDBMS, SWT.NONE);
        configure.setText("Configure");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDBMS,5);
            layoutData.left = new FormAttachment(cmbDatabaseEngine,1);
            layoutData.right = new FormAttachment(80);
            configure.setLayoutData(layoutData);
        }

        final Button chkXADatasource = new Button(cRDBMS, SWT.CHECK);
        chkXADatasource.setText("XA-Datasource");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cRDBMS,5);
            layoutData.left = new FormAttachment(configure,1);
            layoutData.right = new FormAttachment(99);
            chkXADatasource.setLayoutData(layoutData);
        }

        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(0);
            layoutData.left = new FormAttachment(0);
            layoutData.right = new FormAttachment(99);
            layoutData.bottom = new FormAttachment(tabConfig);
            mainContainer.setLayoutData(layoutData);

        }

        final Label lblDriverClass = new Label(cRDBMS, SWT.NONE);
        lblDriverClass.setText("Driver Class");

        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cmbDatabaseEngine,10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblDriverClass.setLayoutData(layoutData);
        }

        txtDriverClass = new Text(cRDBMS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cmbDatabaseEngine,5);
            layoutData.left = new FormAttachment(lblDriverClass,1);
            layoutData.right = new FormAttachment(99);
            txtDriverClass.setLayoutData(layoutData);
            txtDriverClass.setText("driver");
        }

        final Label lblXADatasourceClass = new Label(cRDBMS, SWT.NONE);
        lblXADatasourceClass.setText("XA-Datasource class");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtDriverClass,10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblXADatasourceClass.setLayoutData(layoutData);
        }
        lblXADatasourceClass.setVisible(false);
        txtXADatasourceClass = new Text(cRDBMS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(cmbDatabaseEngine,5);
            layoutData.left = new FormAttachment(lblDriverClass,1);
            layoutData.right = new FormAttachment(99);
            txtXADatasourceClass.setLayoutData(layoutData);
            txtXADatasourceClass.setText("datasourceClass");
        }
        txtXADatasourceClass.setVisible(false);

        final ControlDecoration cdtxtXADatasourceClass = new ControlDecoration(txtXADatasourceClass,
                SWT.LEFT | SWT.TOP);
        cdtxtXADatasourceClass.setDescriptionText("XA-Datasource Required");
        cdtxtXADatasourceClass.setImage(fd.getImage());
        cdtxtXADatasourceClass.hide();

        final ControlDecoration cdtxtDriverClass = new ControlDecoration(txtDriverClass, SWT.LEFT | SWT.TOP);
        cdtxtDriverClass.setDescriptionText("JDBC Driver Required");
        cdtxtDriverClass.setImage(fd.getImage());
        
        Label lblJdbcUrl = new Label(cRDBMS, SWT.NONE);
        lblJdbcUrl.setText("JDBC URL");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtXADatasourceClass,10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblJdbcUrl.setLayoutData(layoutData);
        }
        
        txtJdbcUrl = new Text(cRDBMS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtDriverClass,5);
            layoutData.left = new FormAttachment(lblJdbcUrl,1);
            layoutData.right = new FormAttachment(99);
            txtJdbcUrl.setLayoutData(layoutData);
        }

        ControlDecoration cdtxtJdbcUrl = new ControlDecoration(txtJdbcUrl, SWT.LEFT | SWT.TOP);
        cdtxtJdbcUrl.setDescriptionText("JDBC Url Required");
        cdtxtJdbcUrl.setImage(fd.getImage());
        
        Label lblUserName = new Label(cRDBMS, SWT.NONE);
        lblUserName.setText("User Name");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtJdbcUrl,10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblUserName.setLayoutData(layoutData);
        }
        
        txtUserName = new Text(cRDBMS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtJdbcUrl,5);
            layoutData.left = new FormAttachment(lblUserName,1);
            layoutData.right = new FormAttachment(50);
            txtUserName.setLayoutData(layoutData);
        }

        Label lblPassword = new Label(cRDBMS, SWT.NONE);
        lblPassword.setText("Password");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtUserName,10);
            layoutData.left = new FormAttachment(1);
            layoutData.right = new FormAttachment(20);
            lblPassword.setLayoutData(layoutData);
        }

        txtPassword = new Text(cRDBMS, SWT.BORDER | SWT.PASSWORD);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtUserName,5);
            layoutData.left = new FormAttachment(lblPassword,1);
            layoutData.right = new FormAttachment(50);
            txtPassword.setLayoutData(layoutData);
        }
        final ControlDecoration cd_txtPassword = new ControlDecoration(txtPassword, SWT.LEFT | SWT.TOP);
        cd_txtPassword.setDescriptionText("Password is required");

        txtSecretAliasPassword = new Text(cRDBMS, SWT.BORDER);
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtUserName,5);
            layoutData.left = new FormAttachment(lblPassword,1);
            layoutData.right = new FormAttachment(50);
            txtSecretAliasPassword.setLayoutData(layoutData);
        }
        txtSecretAliasPassword.setVisible(false);
        
        final ControlDecoration cd_txtSecretAliasPassword = new ControlDecoration(txtSecretAliasPassword,
                SWT.LEFT | SWT.TOP);
        cd_txtSecretAliasPassword.setDescriptionText("Secret alias name is required");
        
        // add Secret Alias check box
        final Button checkSecretAlias = new Button(cRDBMS, SWT.CHECK);
        checkSecretAlias.setText("Use as Secret Alias");
        {
            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(txtUserName,5);
            layoutData.left = new FormAttachment(txtPassword,1);
            layoutData.right = new FormAttachment(70);
            checkSecretAlias.setLayoutData(layoutData);
        }

        chkXADatasource.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                boolean visible = (((Button) e.widget).getSelection());
                txtXADatasourceClass.setVisible(visible);
                lblXADatasourceClass.setVisible(visible);

                lblDriverClass.setVisible(!visible);
                txtDriverClass.setVisible(!visible);
                if (visible) {
                    cdtxtXADatasourceClass.show();
                    cdtxtDriverClass.hide();
                } else {
                    cdtxtXADatasourceClass.hide();
                    cdtxtDriverClass.show();
                }
                cRDBMS.layout();
            }
        });
        
        checkSecretAlias.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                boolean isEnabled = (((Button) e.widget).getSelection());
                txtPassword.setVisible(!isEnabled);
                txtPassword.setText("");
                txtSecretAliasPassword.setVisible(isEnabled);
                txtSecretAliasPassword.setText("");
                if (isEnabled) {
                    cd_txtSecretAliasPassword.show();
                    cd_txtPassword.hide();
                } else {
                    cd_txtSecretAliasPassword.hide();
                    cd_txtPassword.show();
                }
                cRDBMS.layout();
            }
        });

        cmbDatabaseEngine.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                int selectedIndex = ((Combo) e.widget).getSelectionIndex();
                if (rdbmsType.length > selectedIndex && selectedIndex != -1) {
                    if (rdbmsConfig.containsKey(rdbmsType[selectedIndex])) {
                        txtJdbcUrl.setText(rdbmsConfig.get(rdbmsType[selectedIndex])[0]);
                        txtDriverClass.setText(rdbmsConfig.get(rdbmsType[selectedIndex])[1]);
                        txtXADatasourceClass.setText(rdbmsConfig.get(rdbmsType[selectedIndex])[2]);
                    }
                }
            }
        });

        rdbmsFieldListener = new ModifyListener() {

            public void modifyText(ModifyEvent text) {
                boolean isXA = chkXADatasource.getSelection();
                model.getRdbmsConfig().setDriverClass(txtDriverClass.getText());
                model.getRdbmsConfig().setXaDsClass(txtXADatasourceClass.getText());
                model.getRdbmsConfig().setJdbcUrl(txtJdbcUrl.getText());
                model.getRdbmsConfig().setJdbcUser(txtUserName.getText());
                boolean isSecretAliasEnabled = checkSecretAlias.getSelection();
                model.getRdbmsConfig().setSecretAlias(isSecretAliasEnabled);
                if (isSecretAliasEnabled) {
                    model.getRdbmsConfig().setJdbcPassword(txtSecretAliasPassword.getText());
                } else {
                    model.getRdbmsConfig().setJdbcPassword(txtPassword.getText());
                }
                if (isXA) {
                    if (txtXADatasourceClass.getText().trim().equals("") || txtJdbcUrl.getText().trim().equals("")
                            || txtDataSourceId.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                } else {
                    if (txtDriverClass.getText().trim().equals("") || txtJdbcUrl.getText().trim().equals("")
                            || txtDataSourceId.getText().trim().equals("")) {
                        setPageComplete(false);
                        setErrorMessage("Required Field(s) are missing");
                    } else {
                        setPageComplete(true);
                        setErrorMessage(null);
                    }
                }

            }
        };

        chkXADatasource.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent evt) {
                model.getRdbmsConfig().setXaDs(chkXADatasource.getSelection());
                rdbmsFieldListener.modifyText(null);
            }

            public void widgetDefaultSelected(SelectionEvent evt) {
                widgetSelected(evt);
            }
        });

        txtXADatasourceClass.addModifyListener(rdbmsFieldListener);
        txtDriverClass.addModifyListener(rdbmsFieldListener);
        txtJdbcUrl.addModifyListener(rdbmsFieldListener);
        txtUserName.addModifyListener(rdbmsFieldListener);
        txtPassword.addModifyListener(rdbmsFieldListener);
        txtSecretAliasPassword.addModifyListener(rdbmsFieldListener);

        txtJdbcUrl.setText(rdbmsConfig.get(rdbmsType[0])[0]);
        txtDriverClass.setText(rdbmsConfig.get(rdbmsType[0])[1]);
        txtXADatasourceClass.setText(rdbmsConfig.get(rdbmsType[0])[2]);
        
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
