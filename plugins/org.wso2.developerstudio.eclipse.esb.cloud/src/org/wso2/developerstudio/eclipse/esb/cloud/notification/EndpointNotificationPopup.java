package org.wso2.developerstudio.eclipse.esb.cloud.notification;

import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Endpoint;
import org.wso2.developerstudio.eclipse.esb.cloud.model.EndpointData;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudDeploymentWizardConstants;

public class EndpointNotificationPopup extends AbstractNotificationPopup {

    private EndpointData endpoints;

    private static final String DEPLOYMENT_SUCCESS_TITLE = "Deployment Status";
    private static final String REST_ENDPOINTS_LABEL_TEXT = "REST endpoints";
    private static final String SOAP_ENDPOINTS_LABEL_TEXT = "SOAP endpoints";
    private static final String SWAGGER_ENDPOINTS_LABEL_TEXT = "SWAGGER endpoints";

    private static final int DELAY = 100 * 1000;

    private static final String CLOSE_LABEL = "×";

    public EndpointNotificationPopup(Display display, EndpointData endpoints) {
        super(display, DELAY);
        this.endpoints = endpoints;
    }

    @Override
    protected void createContentArea(Composite parent) {
        parent.setLayout(new GridLayout(1, false));
        GridData layoutData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
        layoutData.widthHint = 600;
        parent.setLayoutData(layoutData);
        
        Label successMsg = new Label(parent, SWT.NULL);
        successMsg.setText(CloudDeploymentWizardConstants.SuccessMessages.DEPLOY_TO_CLOUD_SUCCESS_MESSAGE);

        if (this.endpoints != null) {

            if (endpoints.getRestEndpoints() != null) {
                // REST endpoints
                new Label(parent, SWT.NONE);
                Label lblRestEp = new Label(parent, SWT.NONE);
                lblRestEp.setText(REST_ENDPOINTS_LABEL_TEXT);
                FontData fontData = lblRestEp.getFont().getFontData()[0];
                Font font = new Font(Display.getCurrent(),
                        new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
                lblRestEp.setFont(font);

                for (Endpoint endpoint : endpoints.getRestEndpoints()) {
                    Link restEP = new Link(parent, SWT.WRAP | SWT.LEFT);
                    restEP.setText(createUrl(endpoint.getUrl()));
                    GridData linkData = new GridData();
                    linkData.widthHint = 450;
                    restEP.setLayoutData(linkData);
                    restEP.addSelectionListener(new SelectionAdapter() {

                        @Override
                        public void widgetSelected(SelectionEvent e) {
                            Program.launch(endpoint.getUrl());
                        }

                    });
                }
            } else if (endpoints.getSoapEndpoints() != null) {
                // SOAP endpoints
                new Label(parent, SWT.NONE);
                Label lblSoapEp = new Label(parent, SWT.BOLD);
                lblSoapEp.setText(SOAP_ENDPOINTS_LABEL_TEXT);
                FontData fontData = lblSoapEp.getFont().getFontData()[0];
                Font font = new Font(Display.getCurrent(),
                        new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
                lblSoapEp.setFont(font);

                for (Endpoint endpoint : endpoints.getSoapEndpoints()) {
                    Link soapEP = new Link(parent, SWT.WRAP | SWT.LEFT);
                    soapEP.setText(createUrl(endpoint.getWsdl()));
                    GridData linkData = new GridData();
                    linkData.widthHint = 450;
                    soapEP.setLayoutData(linkData);

                    soapEP.addSelectionListener(new SelectionAdapter() {

                        @Override
                        public void widgetSelected(SelectionEvent e) {
                            Program.launch(endpoint.getWsdl());
                        }

                    });
                }
            }
            if (endpoints.getSwaggerEndpoints() != null) {
                // Swagger endpoints
                new Label(parent, SWT.NONE);
                Label lblSwaggerEp = new Label(parent, SWT.BOLD);
                lblSwaggerEp.setText(SWAGGER_ENDPOINTS_LABEL_TEXT);
                FontData fontData = lblSwaggerEp.getFont().getFontData()[0];
                Font font = new Font(Display.getCurrent(),
                        new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
                lblSwaggerEp.setFont(font);

                for (Endpoint endpoint : endpoints.getSwaggerEndpoints()) {
                    Link swaggerEp = new Link(parent, SWT.WRAP | SWT.LEFT);
                    swaggerEp.setText(createUrl(endpoint.getUrl()));
                    GridData linkData = new GridData();
                    linkData.widthHint = 450;
                    swaggerEp.setLayoutData(linkData);

                    swaggerEp.addSelectionListener(new SelectionAdapter() {

                        @Override
                        public void widgetSelected(SelectionEvent e) {
                            Program.launch(endpoint.getUrl());
                        }

                    });
                }
            }
            new Label(parent, SWT.NONE);
        }
    }

    @Override
    protected String getPopupShellTitle() {
        return DEPLOYMENT_SUCCESS_TITLE;
    }

    private String createUrl(String endpoint) {
        return "<a href=\"" + endpoint + "\">" + endpoint + "</a>";
    }

}