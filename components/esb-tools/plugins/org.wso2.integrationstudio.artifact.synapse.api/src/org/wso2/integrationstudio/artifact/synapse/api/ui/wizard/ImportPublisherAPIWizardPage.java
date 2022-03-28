/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.synapse.api.ui.wizard;

import java.awt.Event;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JRadioButton;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Rectangle;
import org.wso2.integrationstudio.artifact.synapse.api.Activator;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.APIMConnectException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.HttpClientException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.InvalidTokenException;
import org.wso2.integrationstudio.artifact.synapse.api.model.APIMAPIArtifactModel;
import org.wso2.integrationstudio.artifact.synapse.api.model.PublisherAPI;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

public class ImportPublisherAPIWizardPage extends WizardPage  {
    
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    
    private final APIMAPIArtifactModel artifactModel;
    Text userNameText;
    Text passwordText;
    Button listAPIBtn;
    Text text;
    Text txtUserName;
    Text txtPassword;
    Text txtAPIMHostUrl;
    private ArrayList<PublisherAPI> apiList;
    HashMap<Integer, String> tableAPIMapper;
    String selectedApi;
    
    public ImportPublisherAPIWizardPage(APIMAPIArtifactModel artifactModel) {
        super("importPublisherApi");
        setTitle("Import API from API Manager");
        setDescription("Import API from API Manager");       
        this.artifactModel = artifactModel;
    }

    @Override
    public void createControl(Composite parent) {
        
        Composite container = new Composite(parent, SWT.NULL);
        container.setLayout(new FormLayout());
        FormData data;
        Table tblDataTables;
        Button listAPIsButton;
        Label labelUserName;
        Label labelPassword;
        Label labelAPIMHostUrl;
        Text txtUserName;
        Text txtPassword;
        Text txtAPIMHostUrl;
        Button listAPIBtn;
        
        // create dummy read-only text box to fix:
        // https://github.com/wso2/integration-studio/issues/1057
        Text initilizeText = new Text(container, SWT.NONE | SWT.READ_ONLY);
        data = new FormData();
        data.height = 0;
        data.width = 0;
        initilizeText.setLayoutData(data);
        
        Composite credentialsContainer = new Composite(container, SWT.NULL);
        credentialsContainer.setLayout(new FormLayout());
        data = new FormData();
        data.top = new FormAttachment(1);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        credentialsContainer.setLayoutData(data);
        
        labelUserName = new Label(container, SWT.NONE);
        labelUserName.setText("UserName *");
        data = new FormData();
        data.top = new FormAttachment(credentialsContainer, 20);
        data.width = 155;
        data.left = new FormAttachment(3);
        labelUserName.setLayoutData(data);
        
        txtUserName = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(credentialsContainer, 10);
        data.left = new FormAttachment(labelUserName, 10);
        data.right = new FormAttachment(98);
        txtUserName.setLayoutData(data);
        artifactModel.setUserName(txtUserName.getText());

        labelPassword = new Label(container, SWT.NONE);
        labelPassword.setText("Password *");
        data = new FormData();
        data.top = new FormAttachment(labelUserName, 30);
        data.width = 155;
        data.left = new FormAttachment(3);
        labelPassword.setLayoutData(data);

        txtPassword = new Text(container, SWT.PASSWORD | SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(txtUserName, 25);
        data.left = new FormAttachment(labelPassword, 10);
        data.right = new FormAttachment(98);
        txtPassword.setLayoutData(data);
        artifactModel.setPassword(txtPassword.getText());
        
        labelAPIMHostUrl = new Label(container, SWT.NONE);
        labelAPIMHostUrl.setText("API Manager Host Url *");
        data = new FormData();
        data.top = new FormAttachment(labelPassword, 30);
        data.width = 155;
        data.left = new FormAttachment(3);
        labelAPIMHostUrl.setLayoutData(data);
        
        txtAPIMHostUrl = new Text(container, SWT.BORDER);
        // set an example host value
        txtAPIMHostUrl.setText("https://localhost:9443");
        data = new FormData();
        data.top = new FormAttachment(txtPassword, 25);
        data.left = new FormAttachment(labelAPIMHostUrl, 10);
        data.right = new FormAttachment(98);
        txtAPIMHostUrl.setLayoutData(data);
        artifactModel.setApimHostUrl(txtAPIMHostUrl.getText());

        setControl(credentialsContainer);
        listAPIBtn = new Button(container, SWT.NONE);
        listAPIBtn.setText("List APIs");
        data = new FormData();
        data.top = new FormAttachment(labelAPIMHostUrl, 30);
        data.width = 100;
        data.left = new FormAttachment(3);
        listAPIBtn.setLayoutData(data);

        Integer nrows = 4;
        Integer ncols = 3;
        
        
        Table table = new Table(
                container, SWT.CHECK |  SWT.V_SCROLL
        );
        
        data = new FormData();
        data.top = new FormAttachment(listAPIBtn, 10);
        data.left = new FormAttachment(3);
        table.setLayoutData(data);
        data.height = 200;
        data.width = 500;
       
        table.setLayoutData(data);
        table.setBounds(25, 25, 220, 200);        
        
        TableColumn column1 = new TableColumn(table, SWT.LEFT, 0);
        column1.setWidth(200);
        TableColumn column2 = new TableColumn(table, SWT.LEFT, 1);
        column2.setWidth(130);
        TableColumn column3 = new TableColumn(table, SWT.LEFT, 2);
        column3.setWidth(130);

        listAPIBtn.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent event) {
                artifactModel.setUserName(txtUserName.getText());
                artifactModel.setPassword(txtPassword.getText());
                artifactModel.setApimHostUrl(txtAPIMHostUrl.getText());
              try {
              
               artifactModel.getAPIs(
                       artifactModel.getUserName(),
                       artifactModel.getPassword(),
                       artifactModel.getApimHostUrl());
               apiList = artifactModel.getAPIList();
              
               tableAPIMapper = new HashMap<Integer, String>();;
               
               table.removeAll();
               table.clearAll();
               for(int i=0; i< apiList.size(); i++) {
                   String apiName = apiList.get(i).getApiName();
                   String apiVersion = apiList.get(i).getApiVersion();
                   String apiContext = apiList.get(i).getApiContext();
                   tableAPIMapper.put(i,apiList.get(i).getApiId());
                   new TableItem(table, SWT.NONE).setText(new String[] { apiName , apiVersion, apiContext });
                   
               }
               
               // By default select the first API in the list
               if (!tableAPIMapper.isEmpty()) {
                   selectedApi = tableAPIMapper.get(0);
                   artifactModel.setSelectedApiId(selectedApi);
                   table.getItems()[0].setChecked(true);
               }
               
           } catch (HttpClientException | URISyntaxException | InvalidTokenException | APIMConnectException e) {
               log.error("Exception has occurred while retireving the APIs", e);
           }
            }

            public void widgetDefaultSelected(SelectionEvent event) {
                
            }
          });
        
        table.addListener( SWT.Selection, new Listener() {
           
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                if ( event.detail == SWT.CHECK ) {
                    
                    if( table.indexOf( ( TableItem )event.item ) == table.getSelectionIndex() ) {
                      TableItem ti = ( TableItem )event.item;
                     
                      if (ti.getChecked()) {
                          selectedApi = tableAPIMapper.get(table.getSelectionIndex());
                          artifactModel.setSelectedApiId(selectedApi);
                          
                      }
                      
                      // uncheck all other items
                      for (int m = 0; m < table.getItemCount(); m++) {
                          if (m != table.indexOf( ( TableItem )event.item )) {
                              table.getItems()[m].setChecked(false);
                          } 
                      }
  
                    } else {
                      TableItem ti = ( TableItem )event.item;
                    }
                  }
            }
        });
    }
}

