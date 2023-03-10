/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.artifact.dataservice.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.integrationstudio.artifact.dataservice.model.GenerateDataServiceModel;
import org.wso2.integrationstudio.artifact.dataservice.ui.wizard.GenerateDataServicesUtils.Methods;
import org.wso2.integrationstudio.artifact.datasource.artifact.DataSourceArtifact;
import org.wso2.integrationstudio.artifact.datasource.artifact.DataSourceProjectArtifact;
import org.wso2.integrationstudio.ds.presentation.DsEditorPlugin;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.utils.Constants;
import org.wso2.integrationstudio.platform.core.utils.SWTResourceManager;

import org.wso2.integrationstudio.artifact.dataservice.Activator;

public class GenerateDataServicesWizardPage extends WizardPage {
    
    private final GenerateDataServiceModel dataModel;   
    private Map<String, EnumSet<Methods>> selectedTables = new HashMap<String, EnumSet<Methods>>();    
    private Map<String, Boolean> allAvailableTables = new HashMap<String, Boolean>();   
    private Map<String, Document> avalableDatasources = new HashMap<String, Document>();    
    private String selectedDatasource;    
    private Map<Button, String[]> buttonMap = new HashMap<Button, String[]>();    
    private Map<String, List<Button>> buttonTableMap = new HashMap<String, List<Button>>();  
    private Text jarLocationText; 
    private String jarLocation;
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private boolean isDatasourceReadOnly;
    
    public GenerateDataServicesWizardPage(GenerateDataServiceModel projectDataModel) {
        super("wizardPage");
        setTitle("Generate DataService");
        setDescription("Generate dataservice from the datasource");       
        this.dataModel = projectDataModel;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        container.setLayout(new FormLayout());
        FormData data;
        Table tblDataTables;
        Label browseLabel;
        Button browseButton;
        Button fetchTablesButton;
        Button selectAllButton;
        Button deselectAllButton;
        Button singleServiceButton;
        Button multipleServiceButton;
        Label labelServiceName;
        Text txtServiceName;

        // project name enter section
        Composite projectNameContainer = new Composite(container, SWT.NULL);
        projectNameContainer.setLayout(new FormLayout());
        data = new FormData();
        data.top = new FormAttachment(1);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        projectNameContainer.setLayoutData(data);
        
        Label lblDatasource = new Label(container, SWT.NONE);
        lblDatasource.setText("Datasource *");
        data = new FormData();
        FormAttachment dataTop;
        if (dataModel.isDirectContainerProjectCreation()) {
            dataTop = new FormAttachment(projectNameContainer, 20);
            projectNameContainer.setVisible(true);
        } else {
            projectNameContainer.setVisible(false);
            dataTop = new FormAttachment(1);
        }
        data.top = dataTop;
        data.width = 200;
        data.left = new FormAttachment(3);
        lblDatasource.setLayoutData(data);

        final Combo comboAvalableDatasources = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        avalableDatasources = getAvailableDatasources();
        String items[] = avalableDatasources.keySet().toArray(new String[avalableDatasources.size()]);
        comboAvalableDatasources.setItems(items);
        comboAvalableDatasources.select(0);
        data = new FormData();
        data.top = dataTop;
        data.left = new FormAttachment(lblDatasource, 0);
        data.right = new FormAttachment(95);
        comboAvalableDatasources.setLayoutData(data);
        updatePageStatus();
        
        Label datasourceHelpLabel = new Label(container, SWT.NONE);
        data = new FormData();
        datasourceHelpLabel.setImage(SWTResourceManager.getImage(this.getClass(), DataServicesWizardConstants.HELP_ICON));
        data.top = dataTop;
        data.left = new FormAttachment(comboAvalableDatasources, 0);
        data.right = new FormAttachment(99);
        datasourceHelpLabel.setLayoutData(data);
        datasourceHelpLabel.setToolTipText(DataServicesWizardConstants.Tooltips.SELECT_DATASOURCE);
        
        // input type radio button group
        Group selectDriverGroup = new Group(container, SWT.NONE);
        {
            FormLayout groupLayout = new FormLayout();
            selectDriverGroup.setLayout(groupLayout);

            FormData groupData = new FormData();
            groupData.top = new FormAttachment(comboAvalableDatasources, 10);
            groupData.left = new FormAttachment(3);
            groupData.right = new FormAttachment(97);
            selectDriverGroup.setText("Select driver to fetch tables");
            selectDriverGroup.setLayoutData(groupData);
            selectDriverGroup.setVisible(false);
        }

        Composite browseLocalComposite = new Composite(selectDriverGroup, SWT.NONE);
        {

            FormLayout groupLayout = new FormLayout();
            browseLocalComposite.setLayout(groupLayout);

            FormData groupLayoutData = new FormData();
            groupLayoutData.top = new FormAttachment(selectDriverGroup, 10);
            groupLayoutData.left = new FormAttachment(0);
            groupLayoutData.right = new FormAttachment(100);
            browseLocalComposite.setLayoutData(groupLayoutData);

            browseLabel = new Label(browseLocalComposite, SWT.NONE);
            {
                browseLabel.setText("Browse");

                FormData layoutData = new FormData();
                layoutData.top = new FormAttachment(selectDriverGroup, 40);
                layoutData.left = new FormAttachment(4);

                browseLabel.setLayoutData(layoutData);
            }

            jarLocationText = new Text(browseLocalComposite, SWT.BORDER);
            {

                FormData layoutData = new FormData();
                layoutData.top = new FormAttachment(selectDriverGroup, 40);
                layoutData.left = new FormAttachment(browseLabel, 10);
                layoutData.right = new FormAttachment(80);
                jarLocationText.setLayoutData(layoutData);
            }

            browseButton = new Button(browseLocalComposite, SWT.NONE);
            {
                browseButton.setText("Browse");

                FormData layoutData = new FormData();
                layoutData.top = new FormAttachment(selectDriverGroup, 35);
                layoutData.left = new FormAttachment(jarLocationText, 10);
                layoutData.right = new FormAttachment(99);
                browseButton.setLayoutData(layoutData);
            }

        }
        
        fetchTablesButton = new Button(selectDriverGroup, SWT.NONE);
        {

            FormData layoutData = new FormData();
            layoutData.top = new FormAttachment(browseLocalComposite, 10);
            layoutData.right = new FormAttachment(99);
            layoutData.width = 150;

            fetchTablesButton.setText("Fetch Tables");
            fetchTablesButton.setLayoutData(layoutData);
            fetchTablesButton.setEnabled(false);
        }

        // input type table group
        Group tableListGroup = new Group(container, SWT.NONE);
        {
            FormLayout groupLayout = new FormLayout();
            tableListGroup.setLayout(groupLayout);

            FormData groupData = new FormData();
            groupData.top = new FormAttachment(selectDriverGroup, 10);
            groupData.left = new FormAttachment(3);
            groupData.right = new FormAttachment(97);
            tableListGroup.setText("Select tables to generate services");
            tableListGroup.setLayoutData(groupData);
            tableListGroup.setVisible(false);
            
            tblDataTables = new Table(tableListGroup, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
            data = new FormData();
            data.top = new FormAttachment(tableListGroup, 5, 5);
            data.left = new FormAttachment(2);
            data.right = new FormAttachment(98);
            data.height = 120;
            data.width = 350;
            
            tblDataTables.setLayoutData(data);       
            tblDataTables.setLinesVisible(false);
            tblDataTables.setHeaderVisible(false);
            tblDataTables.setVisible(false);
            
            TableColumn tblclmnName = new TableColumn(tblDataTables, SWT.CENTER);
            tblclmnName.setText("Table Name");
            
            TableColumn tblclmnGet = new TableColumn(tblDataTables, SWT.CHECK | SWT.CENTER);
            tblclmnGet.setText("GET");
            
            TableColumn tblclmnPost = new TableColumn(tblDataTables, SWT.CHECK | SWT.CENTER);
            tblclmnPost.setText("POST");
            
            TableColumn tblclmnPut = new TableColumn(tblDataTables, SWT.CHECK | SWT.CENTER);
            tblclmnPut.setText("PUT");
            
            TableColumn tblclmnDelete = new TableColumn(tblDataTables, SWT.CHECK | SWT.CENTER);
            tblclmnDelete.setText("DELETE");
            
            tblDataTables.addControlListener(new ControlAdapter() {
                public void controlResized(ControlEvent e) {
                    Rectangle area = tblDataTables.getClientArea();
                    int width = area.width - 25;
                    int firstColumnWidth = width / 3 ;
                    int otherColumnWidth = (width - firstColumnWidth) / 4;
                    tblclmnName.setWidth(firstColumnWidth);
                    tblclmnGet.setWidth(otherColumnWidth);
                    tblclmnPost.setWidth(otherColumnWidth);
                    tblclmnPut.setWidth(otherColumnWidth);
                    tblclmnDelete.setWidth(otherColumnWidth);
                }
            });
            
            selectAllButton = new Button(tableListGroup, SWT.NONE);
            data = new FormData();
            data.top = new FormAttachment(tblDataTables, 5);
            data.left = new FormAttachment(2);
            selectAllButton.setLayoutData(data);
            selectAllButton.setText("Select All");
            selectAllButton.setVisible(false);

            deselectAllButton = new Button(tableListGroup, SWT.NONE);
            data = new FormData();
            data.top = new FormAttachment(tblDataTables, 5);
            data.left = new FormAttachment(selectAllButton, 3);
            deselectAllButton.setLayoutData(data);
            deselectAllButton.setText("Deselect All");
            deselectAllButton.setVisible(false);
        }
        
        selectAllButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                TableItem [] tableItems = tblDataTables.getItems();
                for (TableItem tableItem : tableItems) {
                    String tableName = tableItem.getText();
                    tableItem.setChecked(true);
                    List<Button> buttonsList = buttonTableMap.get(tableName);
                    for (Button bttn : buttonsList) {
                        bttn.setEnabled(true);
                        bttn.setSelection(true);
                        String [] cell = buttonMap.get(bttn);
                        String eventMethod = cell[1];
                        EnumSet<Methods> currentMethods = selectedTables.get(tableName);
                        if (currentMethods == null) {
                            currentMethods = EnumSet.of(Methods.valueOf(eventMethod));  
                        } else {
                            currentMethods.add(Methods.valueOf(eventMethod));
                        }
                        selectedTables.put(tableName, currentMethods);
                    }
                }
                updatePageStatus();
            }
        });

        deselectAllButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                TableItem [] tableItems = tblDataTables.getItems();
                for (TableItem tableItem : tableItems) {
                    String tableName = tableItem.getText();
                    if (tableItem.getChecked()) {
                        tableItem.setChecked(false);
                        List<Button> buttonsList = buttonTableMap.get(tableName);
                        for (Button bttn : buttonsList) {
                            bttn.setEnabled(false);
                            bttn.setSelection(false);
                            selectedTables.remove(tableName);
                        }
                    }
                } 
                updatePageStatus();
            }
        });

        // input type mode group
        Group serviceModeGroup = new Group(container, SWT.NONE);
        {
            
            FormLayout groupLayout = new FormLayout();
            serviceModeGroup.setLayout(groupLayout);

            FormData groupData = new FormData();
            groupData.top = new FormAttachment(tableListGroup, 10);
            groupData.left = new FormAttachment(3);
            groupData.right = new FormAttachment(97);
            serviceModeGroup.setText("Select the service generation mode");
            serviceModeGroup.setLayoutData(groupData);
            serviceModeGroup.setVisible(false);
            
            singleServiceButton = new Button(serviceModeGroup, SWT.RADIO);
            data = new FormData();
            data.top = new FormAttachment(tableListGroup, 20);
            data.left = new FormAttachment(3);
            singleServiceButton.setLayoutData(data);
            singleServiceButton.setText("Generate a single service");
            singleServiceButton.setToolTipText(DataServicesWizardConstants.Tooltips.SINGLE_SERVICE_GENERATION);
            singleServiceButton.setSelection(true);
            singleServiceButton.setVisible(false);
                           
            multipleServiceButton = new Button(serviceModeGroup, SWT.RADIO);
            data = new FormData();
            data.top = new FormAttachment(singleServiceButton, 20);
            data.left = new FormAttachment(3);
            multipleServiceButton.setLayoutData(data);
            multipleServiceButton.setText("Generate multiple services");
            multipleServiceButton.setToolTipText(DataServicesWizardConstants.Tooltips.MULTIPLE_SERVICES_GENERATION);
            multipleServiceButton.setVisible(false);
            
            labelServiceName = new Label(serviceModeGroup, SWT.NONE);
            data = new FormData();
            data.top = new FormAttachment(multipleServiceButton, 20);
            data.left = new FormAttachment(3);
            data.width = 200;
            labelServiceName.setLayoutData(data);
            labelServiceName.setText("Service Name *");      
            labelServiceName.setVisible(false);
            
            txtServiceName = new Text(serviceModeGroup, SWT.BORDER);
            data = new FormData();
            data.top = new FormAttachment(multipleServiceButton, 20);
            data.left = new FormAttachment(labelServiceName, 10);
            data.right = new FormAttachment(98);
            txtServiceName.setLayoutData(data);
            dataModel.setServiceName(txtServiceName.getText());
            
            Label labelPadding = new Label(serviceModeGroup, SWT.NONE);
            data = new FormData();
            data.top = new FormAttachment(labelServiceName, 5);
            labelPadding.setLayoutData(data);
       
        }
        
        txtServiceName.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                dataModel.setServiceName(txtServiceName.getText());
                updatePageStatus();
            }
        });
        
        singleServiceButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                dataModel.setGenerateSingleService(true);
                labelServiceName.setVisible(true);
                txtServiceName.setVisible(true);
            }
        });

        multipleServiceButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                dataModel.setGenerateSingleService(false);
                labelServiceName.setVisible(false);
                txtServiceName.setVisible(false);
            }
        });    

        comboAvalableDatasources.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                //clear data
                selectedTables = new HashMap<String, EnumSet<Methods>>();
                tblDataTables.removeAll();
                Arrays.stream(tblDataTables.getChildren()).filter(Button.class::isInstance).
                        forEach(Control::dispose);
                buttonMap = new HashMap<Button, String[]>();
                buttonTableMap = new HashMap<String, List<Button>>();
                allAvailableTables = new HashMap<String, Boolean>();
                tableListGroup.setVisible(false);
                serviceModeGroup.setVisible(false);
                fetchTablesButton.setEnabled(false);
                jarLocationText.setText("");
                jarLocation = "";
                dataModel.setDatasource(null);
                dataModel.setTables(selectedTables);
                isDatasourceReadOnly = false;
                
                if (comboAvalableDatasources.getSelectionIndex() == 0) {
                    selectedDatasource = null;
                    selectDriverGroup.setVisible(false);                  
                } else {
                    selectedDatasource = (String)avalableDatasources.keySet().toArray()[comboAvalableDatasources.getSelectionIndex()];
                    Document datasourceConfig = avalableDatasources.get(selectedDatasource);
                    dataModel.setDatasource(getElementValue(datasourceConfig, "name"));
                    selectDriverGroup.setVisible(true);
                }              
                updatePageStatus();                     
            }
        });
        
        fetchTablesButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                
                //clear data
                selectedTables = new HashMap<String, EnumSet<Methods>>();
                tblDataTables.removeAll();
                buttonMap = new HashMap<Button, String[]>();
                buttonTableMap = new HashMap<String, List<Button>>();
                allAvailableTables = new HashMap<String, Boolean>();
                Document datasourceConfig = avalableDatasources.get(selectedDatasource);
                allAvailableTables = getAllAvailableTables(datasourceConfig, jarLocation);  
                
                if (allAvailableTables != null && allAvailableTables.size() > 0) {
                    tblDataTables.setVisible(true);
                    tblDataTables.setLinesVisible(true);
                    tblDataTables.setHeaderVisible(true);
                    tableListGroup.setVisible(true);
                    serviceModeGroup.setVisible(true);
                    singleServiceButton.setVisible(true);
                    multipleServiceButton.setVisible(true);
                    labelServiceName.setVisible(true);
                    String dataServiceName = selectedDatasource.split("/")[1] + "_DataService";
                    txtServiceName.setText(dataServiceName);
                    dataModel.setServiceName(dataServiceName);
                    txtServiceName.setVisible(true);
                    selectAllButton.setVisible(true);
                    deselectAllButton.setVisible(true);
                    populateTableWithAllData(tblDataTables);
                    dataModel.setTables(selectedTables);
                }                 
                updatePageStatus();
            }
        });

        browseButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                jarLocationText.setText("");
                jarLocation = "";
                FileDialog dialog = new FileDialog((Shell) container.getShell(), SWT.NULL);
                dialog.setFilterExtensions(new String[] { "*.jar" });
                String path = dialog.open();
                populateJarLocation(path);
                fetchTablesButton.setEnabled(true);     
            }
        });
         
        tblDataTables.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                final TableItem item = (TableItem) event.item;
                if (event.detail == SWT.CHECK && item != null) {
                    if (item.getChecked()) {
                        String table = item.getText();
                        if (allAvailableTables.get(table)) {
                            selectedTables.put(table, EnumSet.allOf(Methods.class));
                        } else {
                            selectedTables.put(table, EnumSet.of(Methods.GET, Methods.POST));                       
                        }
                        dataModel.setTables(selectedTables);
                        List<Button> buttonsList = buttonTableMap.get(table);
                        for (Button bttn : buttonsList) {
                            bttn.setEnabled(true);
                            bttn.setSelection(true);
                        }                       
                    } else {
                        String table = item.getText();
                        selectedTables.remove(table);
                        dataModel.setTables(selectedTables);
                        List<Button> buttonsList = buttonTableMap.get(table);
                        for (Button bttn : buttonsList) {
                            bttn.setSelection(false);
                            bttn.setEnabled(false);
                        }
                    }
                    updatePageStatus();
                } 
            }
        });
        
        setControl(container);
        
    }
    
    private void populateTableWithAllData(Table tblDataTables) {
        for (Map.Entry<String, Boolean> entry : allAvailableTables.entrySet()) {
            String tableName = entry.getKey();
            boolean isPrimaryKey = entry.getValue();
            TableItem row = new TableItem(tblDataTables, SWT.CHECK);
            row.setText(0, tableName);
            row.setChecked(true);
            TableEditor editor = new TableEditor (tblDataTables);
            Button bttnGet = new Button (tblDataTables, SWT.CHECK);
            bttnGet.setSelection(true);
            bttnGet.pack ();
            editor.minimumWidth = bttnGet.getSize ().x;
            editor.horizontalAlignment = SWT.CENTER;
            editor.setEditor(bttnGet, row, 1);
            buttonMap.put(bttnGet, new String[] {tableName, "GET"});
            buttonTableMap.computeIfAbsent(tableName, k -> new ArrayList<>()).add(bttnGet);
            
            bttnGet.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateTablesMap(bttnGet);
                }
            });
            
            editor = new TableEditor (tblDataTables);
            Composite bttnPostComposite = new Composite(tblDataTables, SWT.NONE);
            Button bttnPost = new Button (bttnPostComposite, SWT.CHECK);
            bttnPost.setSelection(!isDatasourceReadOnly);
            bttnPost.setEnabled(!isDatasourceReadOnly);
            bttnPost.pack ();
            editor.minimumWidth = bttnPost.getSize ().x;
            editor.horizontalAlignment = SWT.CENTER;
            editor.setEditor(bttnPostComposite, row, 2);
            if (!isDatasourceReadOnly) {
                buttonMap.put(bttnPost, new String[] {tableName, "POST"});
                buttonTableMap.computeIfAbsent(tableName, k -> new ArrayList<>()).add(bttnPost);
            } else {
                bttnPostComposite.setToolTipText(DataServicesWizardConstants.Tooltips.DISABLE_DUE_TO_READONLY);
            }
            
            bttnPost.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateTablesMap(bttnPost);
                }
            });
            editor = new TableEditor (tblDataTables);
            Composite bttnPutComposite = new Composite(tblDataTables, SWT.NONE);
            Button bttnPut = new Button (bttnPutComposite, SWT.CHECK);
            bttnPut.setSelection(!isDatasourceReadOnly && isPrimaryKey);
            bttnPut.setEnabled(!isDatasourceReadOnly && isPrimaryKey);
            bttnPut.pack ();
            editor.minimumWidth = bttnPut.getSize ().x;
            editor.horizontalAlignment = SWT.CENTER;
            editor.setEditor(bttnPutComposite, row, 3);
            if (!isDatasourceReadOnly && isPrimaryKey) {                
                buttonMap.put(bttnPut, new String[] {tableName, "PUT"});
                buttonTableMap.computeIfAbsent(tableName, k -> new ArrayList<>()).add(bttnPut);
            } else if (!isPrimaryKey) {
                bttnPutComposite.setToolTipText(DataServicesWizardConstants.Tooltips.DISABLE_DUE_TO_PRIMARY_KEY);
            } else {
                bttnPutComposite.setToolTipText(DataServicesWizardConstants.Tooltips.DISABLE_DUE_TO_READONLY);
            }
            
            bttnPut.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateTablesMap(bttnPut);
                }
            });
            
            editor = new TableEditor (tblDataTables);
            Composite bttnDeleteComposite = new Composite(tblDataTables, SWT.NONE);
            Button bttnDelete = new Button (bttnDeleteComposite, SWT.CHECK);
            bttnDelete.setSelection(!isDatasourceReadOnly && isPrimaryKey);
            bttnDelete.setEnabled(!isDatasourceReadOnly && isPrimaryKey);
            bttnDelete.pack ();
            editor.minimumWidth = bttnDelete.getSize ().x;
            editor.horizontalAlignment = SWT.CENTER;
            editor.setEditor(bttnDeleteComposite, row, 4);
            if (!isDatasourceReadOnly && isPrimaryKey) {
                buttonMap.put(bttnDelete, new String[] {tableName, "DELETE"});
                buttonTableMap.computeIfAbsent(tableName, k -> new ArrayList<>()).add(bttnDelete);
            } else if (!isPrimaryKey) {
                bttnDeleteComposite.setToolTipText(DataServicesWizardConstants.Tooltips.DISABLE_DUE_TO_PRIMARY_KEY);
            } else {
                bttnDeleteComposite.setToolTipText(DataServicesWizardConstants.Tooltips.DISABLE_DUE_TO_READONLY);
            }
            
            bttnDelete.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateTablesMap(bttnDelete);
                }
            });
            EnumSet<Methods> avaialbleMethods = EnumSet.of(Methods.GET);
            selectedTables.put(tableName, EnumSet.allOf(Methods.class));  
            if (!isDatasourceReadOnly) {
                avaialbleMethods.add(Methods.POST);    
                if (isPrimaryKey) {
                    avaialbleMethods.add(Methods.PUT);  
                    avaialbleMethods.add(Methods.DELETE);  
                }
            } 
            selectedTables.put(tableName, avaialbleMethods);
        }
        dataModel.setTables(selectedTables);
    }
        
    private boolean populateJarLocation(String path) {
        if (path != null) {
            File file = new File(path);
            if (file.isFile() && file.getName().endsWith(".jar")) {
                jarLocationText.setText(path);
                String filePath = null;
                String osType = System.getProperty(DataServicesWizardConstants.OS_NAME, 
                        DataServicesWizardConstants.SYSTEM_PROPERTY_TYPE_GENERIC).toLowerCase(Locale.ENGLISH);
                if (osType.indexOf(DataServicesWizardConstants.OS_TYPE_WINDOWS) >= 0) {
                    filePath = "file:\\";
                } else {
                    filePath = "file://";
                }
                jarLocation = filePath + path;
                
            }
            if (!file.getName().endsWith(".jar")) {
                showMessage(DataServicesWizardConstants.ErrorMessages.INVALID_JAR);
                return false;
            }
            if (!file.exists()) {
                showMessage(DataServicesWizardConstants.ErrorMessages.EMPTY_JAR_FILE);
                return false;
            }
        }
        return false;
    }
    
    /**
     * Method for generating UI pop up box with custom messages.
     * 
     * @param title message box title
     * @param message message box context
     * @param style icon style
     */
    public static void showMessageBox(final String title, final String message, final int style) {
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg = new MessageBox(shell, style);
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                exportMsg.open();
            }
        });
    }
    
    private void showMessage(String msg) {
        int style = SWT.ICON_INFORMATION | SWT.OK;
        MessageBox dia = new MessageBox(this.getShell(), style);
        dia.setText("Information");
        dia.setMessage(msg);
        dia.open();

    }

    /**
     * Validate the wizard page field data and update the page when the validate is
     * failed.
     */
    private void updatePageStatus() {
        String singleServiceName = dataModel.getServiceName();
        File dataService = new File(dataModel.getLocation().getAbsolutePath() + File.separator + 
                "dataservice" + File.separator + singleServiceName + ".dbs");
        if (avalableDatasources == null || avalableDatasources.size() <= 1) {
            updatePageStatus(DataServicesWizardConstants.ErrorMessages.DATASOURCE_NOT_FOUND);
        } else if (selectedDatasource == null) {
            updatePageStatus(DataServicesWizardConstants.ErrorMessages.DATASOURCE_NOT_SELECTED);
        } else if (allAvailableTables == null || allAvailableTables.size() <= 0) {
            updatePageStatus(DataServicesWizardConstants.ErrorMessages.TABLE_NOT_FOUND);
        } else if (selectedTables == null || selectedTables.size() <= 0) {
            updatePageStatus(DataServicesWizardConstants.ErrorMessages.SELECTED_TABLES_EMPTY);
        } else if (dataService.exists()) {
            updatePageStatus("Data service with the name '" + singleServiceName + "' already exists");
        } else {
            updatePageStatus(null);
        }
    }
    

    /**
     * Update the page state.
     *
     * @param msg
     *            error message
     */
    private void updatePageStatus(String msg) {
        setErrorMessage(msg);
         setPageComplete(msg == null);
    }
    
    private void updateTablesMap(Button selectedButton) {
        if (selectedButton.getSelection()) {
            String [] cell = buttonMap.get(selectedButton);
            String eventTableName = cell[0];
            String eventMethod = cell[1];
            EnumSet<Methods> currentMethods = selectedTables.get(eventTableName);
            currentMethods.add(Methods.valueOf(eventMethod));
            selectedTables.put(eventTableName, currentMethods);
        } else {
            String [] cell = buttonMap.get(selectedButton);
            String eventTableName = cell[0];
            String eventMethod = cell[1];
            EnumSet<Methods> currentMethods = selectedTables.get(eventTableName);
            currentMethods.remove(Methods.valueOf(eventMethod));
            selectedTables.put(eventTableName, currentMethods);
        }
    }
    
    private Map<String, Document> getAvailableDatasources() {
        String datasourceArtifcatCategory = "datasource/datasource";
        Map<String, Document> availableDatasourcesMap = new LinkedHashMap<String, Document>();
        availableDatasourcesMap.put("Select datasource", null);
        IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();    
        File projectPath = null;
        for (IProject workspaceProject : projects) {
            try {
                if (workspaceProject.isOpen() && workspaceProject.hasNature(Constants.DATASOURCE_PROJECT_NATURE)) {
                    DataSourceProjectArtifact datasourceProjectArtifact = new DataSourceProjectArtifact();
                    String projectName = workspaceProject.getFullPath().segment(workspaceProject.getFullPath().segmentCount() -1);
                    projectPath = workspaceProject.getLocation().toFile();
                    try {
                        datasourceProjectArtifact
                                .fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
                        List<DataSourceArtifact> allDatasourceArtifacts = datasourceProjectArtifact.getAllDSSArtifacts();
                        for (DataSourceArtifact datasourceArtifact : allDatasourceArtifacts) {
                            if (datasourceArtifcatCategory.equals(datasourceArtifact.getType())) {
                                File artifact = new File(projectPath, datasourceArtifact.getFile());
                                String name = projectName + "/" + artifact.getName().replaceAll("[.]xml$", "");
                                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                                Document doc = dBuilder.parse(artifact);
                                availableDatasourcesMap.put(name, doc);
                            }
                        }
                    } catch (Exception e) {
                        log.error("Error while getting datasource artifacts from workspace ", e);
                    }
                }
            } catch (CoreException e) {
                log.error("Error while getting datasource project artifacts from workspace ", e);
            }
        }
        return availableDatasourcesMap;
    }

    private Map<String, Boolean> getAllAvailableTables(Document databaseDoc, String driverUrl) {
        String driverClassName = getElementValue(databaseDoc, "driverClassName");
        String connectionURL = getElementValue(databaseDoc, "url");
        String userName = getElementValue(databaseDoc, "username");
        String password = getElementValue(databaseDoc, "password");
        if (password != null && password.startsWith("$secret{")) {
            showMessageBox("Cannot resolve the password", "Please enter a plain text password", SWT.ICON_ERROR);
            return null;
        }
        Connection connection = null;
        if ((connectionURL != null) && (driverClassName != null) && (userName != null) && (password != null)) {
            try {               
                URL url = new URL(driverUrl);
                URLClassLoader classLoader = new URLClassLoader(new URL[] { url });
                Driver driver = (Driver) Class.forName(driverClassName, true, classLoader)
                            .newInstance();
                DriverManager.registerDriver(new DriverShim(driver));            
                if (!userName.isEmpty()) {
                    connection = DriverManager.getConnection(connectionURL, userName, password);
                } else {
                    connection = DriverManager.getConnection(connectionURL);
                }
                return getTableList(connection);
            } catch (ClassNotFoundException | SQLException | InstantiationException | 
                    IllegalAccessException | MalformedURLException e) {
                showMessageBox("Error while retriving tables", e.getMessage(), SWT.ICON_ERROR);
            } 
        }
        return null;   
    }
    
    private Map<String, Boolean> getTableList(Connection connection) throws SQLException {
        Map<String, Boolean> tablesMap = new HashMap<String, Boolean>();
        if (connection != null) {
            DatabaseMetaData mObject = connection.getMetaData();
            dataModel.setMetadata(mObject);
            ResultSet tableNamesList = null;
            String schema = null;
            try {
                String dbType = mObject.getDatabaseProductName();
                isDatasourceReadOnly = mObject.isReadOnly();
                if ("Oracle".equalsIgnoreCase(dbType)) {
                   schema = connection.getSchema(); 
                } else if ("PostgreSQL".equalsIgnoreCase(dbType)) {
                    ResultSet schemas = mObject.getSchemas();
                    while (schemas.next()) {
                        schema = schemas.getString("TABLE_SCHEM");
                    }
                }
                tableNamesList = mObject.getTables(connection.getCatalog(), schema, "%", new String[] { "TABLE" });
                while (tableNamesList.next()) {
                    String tableName = tableNamesList.getString("TABLE_NAME");
                    ResultSet rs = mObject.getPrimaryKeys(null, null, tableName);
                    boolean hasPrimaryKey = rs.next();
                    tablesMap.put(tableName, hasPrimaryKey);                    
                }
            } finally {
                if(tableNamesList != null) {
                    tableNamesList.close();
                }
            }
        }
        return tablesMap;
    }
    
    private String getElementValue(Document doc, String element) {
        NodeList elementNodes = doc.getElementsByTagName(element);
        Node elementNode = elementNodes.item(0).getFirstChild();
        if (elementNode == null) {
            return "";
        }
        return elementNode.getNodeValue();
    }

    public String getLibDirPath() throws URISyntaxException, IOException {
        URL libURL = DsEditorPlugin.getPlugin().getBundle().getEntry("lib");
        URL resolvedFolderURL = FileLocator.toFileURL(libURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedLibFolder = new File(resolvedFolderURI);

        return resolvedLibFolder.getAbsolutePath();
    }

}
