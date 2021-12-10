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

package org.wso2.integrationstudio.artifact.synapse.api.ui.wizard;

import java.awt.Event;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.APIMConnectException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.HttpClientException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.InvalidTokenException;
import org.wso2.integrationstudio.artifact.synapse.api.model.APIMAPIArtifactModel;
import org.wso2.integrationstudio.artifact.synapse.api.model.PublisherAPI;

public class ImportPublisherAPIWizardPage extends WizardPage  {
    
    private final APIMAPIArtifactModel artifactModel;
    Text userNameText;
    Text passwordText;
    Button listAPIBtn;
    Text text;
    Text txtUserName;
    Text txtPassword;
    Text txtAPIMHostUrl;
    private ArrayList<PublisherAPI> apiList;

    public ImportPublisherAPIWizardPage(APIMAPIArtifactModel artifactModel) {
        super("importPublisherApi");
        setTitle("Import API from APIM Publisher");
        setDescription("Import API from API Manager Publisher");       
        this.artifactModel = artifactModel;
        // TODO Auto-generated constructor stub
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
        data.top = new FormAttachment(credentialsContainer, 10);
        data.width = 120;
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
        data.width = 120;
        data.left = new FormAttachment(3);
        labelPassword.setLayoutData(data);
        
        txtPassword = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(txtUserName, 10);
        data.left = new FormAttachment(labelPassword, 10);
        data.right = new FormAttachment(98);
        txtPassword.setLayoutData(data);
        artifactModel.setPassword(txtPassword.getText());
        
        labelAPIMHostUrl = new Label(container, SWT.NONE);
        labelAPIMHostUrl.setText("APIM Host Url *");
        data = new FormData();
        data.top = new FormAttachment(labelPassword, 20);
        data.width = 120;
        data.left = new FormAttachment(3);
        labelAPIMHostUrl.setLayoutData(data);
        
        txtAPIMHostUrl = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(txtPassword, 10);
        data.left = new FormAttachment(labelAPIMHostUrl, 10);
        data.right = new FormAttachment(98);
        txtAPIMHostUrl.setLayoutData(data);
        artifactModel.setApimHostUrl(txtAPIMHostUrl.getText());
        
        //Label labelPadding = new Label(container, SWT.NONE);
        //data = new FormData();
        //data.top = new FormAttachment(labelUserName, 5);
        //labelPadding.setLayoutData(data);
        
        
        
        
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
        
       /* Group tableListGroup = new Group(container, SWT.NONE);
        {
           
            
            
            
            
            
        }
        
        FormLayout groupLayout = new FormLayout();
        tableListGroup.setLayout(groupLayout);
        
        tblDataTables = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
        
        data = new FormData();
        data.top = new FormAttachment(listAPIBtn, 5, 5);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        data.height = 120;
        data.width = 350;
        
        tblDataTables.setLayoutData(data);       
        tblDataTables.setLinesVisible(true);
        tblDataTables.setHeaderVisible(true);
        //tblDataTables.setVisible(true);
        
        
        TableColumn tblclmnGet = new TableColumn(tblDataTables,  SWT.NONE);
        tblclmnGet.setText("Select API");
        
        TableColumn tblclmnName = new TableColumn(tblDataTables,  SWT.NONE);
        tblclmnName.setText("API Name");
        
        TableColumn tblclmnName2 = new TableColumn(tblDataTables,  SWT.NONE);
        tblclmnName2.setText("API Version");
        
        TableColumn tblclmnName3 = new TableColumn(tblDataTables,  SWT.NONE);
        tblclmnName3.setText("API Context");
        
        */
        
        Table table = new Table(
                container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.MULTI
        );
        
        data = new FormData();
        data.top = new FormAttachment(listAPIBtn, 10);
        //data.width = 800;
        data.left = new FormAttachment(3);
        table.setLayoutData(data);
        data.height = 200;
        data.width = 500;
        
        //TableEditor editor = new TableEditor(table);
        //editor.horizontalAlignment = SWT.LEFT;
        //editor.grabHorizontal = true;
        table.setLinesVisible(true);
        table.setHeaderVisible(true);
        
        table.setLayoutData(data);
        table.setBounds(25, 25, 220, 200);
        
        
        //tblDataTables.setVisible(true);
        
        /*TableColumn column = new TableColumn(table, SWT.CENTER, 0);
        column.setText("Select API");
        column.setWidth(100); */
        TableColumn column1 = new TableColumn(table, SWT.CENTER, 0);
        column1.setText("API Name");
        column1.setWidth(250);
        TableColumn column2 = new TableColumn(table, SWT.LEFT, 1);
        column2.setText("API Version");
        column2.setWidth(125);
        TableColumn column3 = new TableColumn(table, SWT.LEFT, 2);
        column3.setText("API Context");
        column3.setWidth(125);
        
        
        
        
        
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
               
               for(int i=0; i< apiList.size(); i++) {
                   String apiName = apiList.get(i).getApiName();
                   String apiVersion = apiList.get(i).getApiVersion();
                   String apiContext = apiList.get(i).getApiContext();
                   new TableItem(table, SWT.NONE).setText(new String[] { apiName , apiVersion, apiContext });
                 
               }
               
               
           } catch (HttpClientException | URISyntaxException | InvalidTokenException | APIMConnectException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
            }

            public void widgetDefaultSelected(SelectionEvent event) {
                // userNameText.setText("No worries!");
              text.setText("No worries!");
            }
          });
        
        
        table.addListener( SWT.Selection, new Listener() {
           
            @Override
            public void handleEvent(org.eclipse.swt.widgets.Event event) {
                if ( event.detail == SWT.CHECK ) {
                    System.out.println( "You checked " + event.item );
                    if( table.indexOf( ( TableItem )event.item ) == table.getSelectionIndex() ) {
                      TableItem ti = ( TableItem )event.item;
                      // ti.setChecked( !ti.getChecked() );
                   
                  } else {
                    System.out.println( "You selected " + event.item);
                    TableItem ti = ( TableItem )event.item;
                    // ti.setChecked( !ti.getChecked() );
                  }
                  }
               
            }
 
        });


        
        
        
     
        
        
        
        
        
        
        
        
        
        
        
        
        
    
      
        
        
        
         
        
         
         
         
         
         
     
        
         
    
         
         
         /*Table t = new Table(composite, SWT.BORDER);
         
         TableColumn tc1 = new TableColumn(t, SWT.CENTER);
         TableColumn tc2 = new TableColumn(t, SWT.CENTER);
         TableColumn tc3 = new TableColumn(t, SWT.CENTER);
         tc1.setText("API Name");
         tc2.setText("API version");
         tc3.setText("Context");
         tc1.setWidth(100);
         tc2.setWidth(100);
         tc3.setWidth(100);
         tc1.setToolTipText("Tooltip");;
         
         t.setHeaderVisible(true);
         
         
         
         GridData gd = new GridData(GridData.FILL_HORIZONTAL);
         gd = new GridData(GridData.FILL_HORIZONTAL);
         t.setLayoutData(gd);
         // setControl(composite);
         
         
         
         listAPIBtn.addSelectionListener(new SelectionListener() {
                 
             @Override
             public void widgetSelected(SelectionEvent event) {
                 
               try {
                artifactModel.getAPIs("admin", "admin", "https://127.0.0.1:9443");
                apiList = artifactModel.getAPIList();
                userNameText.setText(apiList.get(0).getApiName());
                for(int i=0; i< apiList.size(); i++) {
                    String apiName = apiList.get(i).getApiName();
                    String apiVersion = apiList.get(i).getApiVersion();
                    String apiContext = apiList.get(i).getApiContext();
                    new TableItem(table, SWT.NONE).setText(new String[] { apiName , apiVersion, apiContext });;
                  
                }
                
                
            } catch (HttpClientException | URISyntaxException | InvalidTokenException | APIMConnectException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             }

             public void widgetDefaultSelected(SelectionEvent event) {
                 // userNameText.setText("No worries!");
               text.setText("No worries!");
             }
           }); 
           
           */
         
         
         
         
      
    }
    

     
    

}
