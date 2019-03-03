package org.wso2.developerstudio.eclipse.esb.cloud.wizard;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Endpoint;
import org.wso2.developerstudio.eclipse.esb.cloud.model.EndpointData;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudDeploymentWizardConstants;

public class DeploymentStatusDialog extends Dialog {
    
    private EndpointData endpoints;
    
    private static final String REST_ENDPOINTS_LABEL_TEXT = "REST endpoints";
    private static final String SOAP_ENDPOINTS_LABEL_TEXT = "SOAP endpoints";
    private static final String SWAGGER_ENDPOINTS_LABEL_TEXT = "SWAGGER endpoints";

    public DeploymentStatusDialog(Shell parentShell, EndpointData endpoints) {
        super(parentShell);
        this.endpoints = endpoints;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        
        Composite container = (Composite) super.createDialogArea(parent);
        

        container.setLayout(new GridLayout(1, false));
        
        Label successMsg = new Label(container, SWT.NULL);
        successMsg.setText(CloudDeploymentWizardConstants.SuccessMessages.DEPLOY_TO_CLOUD_SUCCESS_MESSAGE);

        if (this.endpoints != null) {
           if (endpoints.getRestEndpoints() != null) {
               new Label(container, SWT.NONE);
               Label lblRestEp = new Label(container, SWT.NONE);
               lblRestEp.setText(REST_ENDPOINTS_LABEL_TEXT);
               FontData fontData = lblRestEp.getFont().getFontData()[0];
               Font font = new Font(Display.getCurrent(), new FontData(fontData.getName(), fontData
                   .getHeight(), SWT.BOLD));
               lblRestEp.setFont(font);
               
               for (Endpoint endpoint: endpoints.getRestEndpoints()) {
                   Link restEP = new Link(container, SWT.WRAP | SWT.LEFT);
                   restEP.setText(createUrl(endpoint.getUrl()));
                   GridData linkData = new GridData();
                   linkData.widthHint = 450;
                   restEP.setLayoutData(linkData);
                   restEP.addSelectionListener(new SelectionAdapter()  {
                    
                       @Override
                       public void widgetSelected(SelectionEvent e) {
                           Program.launch(endpoint.getUrl());
                       }
                        
                   });
               }
           } else if (endpoints.getSoapEndpoints() != null) {
               new Label(container, SWT.NONE);
               Label lblSoapEp = new Label(container, SWT.BOLD);
               lblSoapEp.setText(SOAP_ENDPOINTS_LABEL_TEXT);
               FontData fontData = lblSoapEp.getFont().getFontData()[0];
               Font font = new Font(Display.getCurrent(), new FontData(fontData.getName(), fontData
                   .getHeight(), SWT.BOLD));
               lblSoapEp.setFont(font);
               
               for (Endpoint endpoint: endpoints.getSoapEndpoints()) {
                   Link soapEP = new Link(container, SWT.WRAP | SWT.LEFT);
                   soapEP.setText(createUrl(endpoint.getWsdl()));
                   GridData linkData = new GridData();
                   linkData.widthHint = 450;
                   soapEP.setLayoutData(linkData);
                   
                   soapEP.addSelectionListener(new SelectionAdapter()  {
                       
                       @Override
                       public void widgetSelected(SelectionEvent e) {
                           Program.launch(endpoint.getWsdl());
                       }
                        
                   });
               }
           } else if (endpoints.getSwaggerEndpoints() != null) {
               new Label(container, SWT.NONE);
               Label lblSwaggerEp = new Label(container, SWT.BOLD);
               lblSwaggerEp.setText(SWAGGER_ENDPOINTS_LABEL_TEXT);
               FontData fontData = lblSwaggerEp.getFont().getFontData()[0];
               Font font = new Font(Display.getCurrent(), new FontData(fontData.getName(), fontData
                   .getHeight(), SWT.BOLD));
               lblSwaggerEp.setFont(font);
               
               for (Endpoint endpoint: endpoints.getSwaggerEndpoints()) {
                   Link swaggerEp = new Link(container, SWT.WRAP | SWT.LEFT);
                   swaggerEp.setText(createUrl(endpoint.getContext()));
                   GridData linkData = new GridData ();
                   linkData.widthHint = 450;
                   swaggerEp.setLayoutData(linkData);
                   
                   swaggerEp.addSelectionListener(new SelectionAdapter()  {
                       
                       @Override
                       public void widgetSelected(SelectionEvent e) {
                           Program.launch(endpoint.getContext());
                       }
                        
                   });
               }
           }
        }
        return container;
    }
    
    private String createUrl(String endpoint) {
        return "<a href=\"" + endpoint + "\">" + endpoint + "</a>";
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(CloudDeploymentWizardConstants.SUCCESS_DIALOG_TITLE_TEXT);
    }

    @Override
    protected Point getInitialSize() {
        return new Point(460, 300);
    }

}