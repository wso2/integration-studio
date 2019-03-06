package org.wso2.developerstudio.eclipse.esb.cloud.notification;

import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
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

/**
 * Notification shown when application is successfully deployed
 *
 */
public class EndpointNotificationPopup extends AbstractNotificationPopup {

    private EndpointData endpoints;

    private static final String DEPLOYMENT_SUCCESS_TITLE = "Deployment Status";
    private static final String REST_ENDPOINTS_LABEL_TEXT = "REST endpoints";
    private static final String SOAP_ENDPOINTS_LABEL_TEXT = "SOAP endpoints";
    private static final String SWAGGER_ENDPOINTS_LABEL_TEXT = "SWAGGER endpoints";

    public EndpointNotificationPopup(Display display, EndpointData endpoints) {
        super(display);
        this.endpoints = endpoints;
    }

    @Override
    protected void createContentArea(Composite parent) {

        Composite container = new Composite(parent, SWT.NULL);

        GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        container.setLayoutData(data);

        container.setLayout(new GridLayout(1, false));

        Label successMsg = new Label(container, SWT.NULL);
        successMsg.setText(CloudDeploymentWizardConstants.SuccessMessages.DEPLOY_TO_CLOUD_SUCCESS_MESSAGE);

        if (this.endpoints != null) {
            Label tryItMsg = new Label(container, SWT.NULL);
            tryItMsg.setText(CloudDeploymentWizardConstants.SuccessMessages.TRY_IT_MESSAGE);

            if (endpoints.getRestEndpoints() != null) {
                // REST endpoints
                new Label(container, SWT.NONE);
                Label lblRestEp = new Label(container, SWT.NONE);
                lblRestEp.setText(REST_ENDPOINTS_LABEL_TEXT);
                FontData fontData = lblRestEp.getFont().getFontData()[0];
                Font font = new Font(Display.getCurrent(),
                        new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
                lblRestEp.setFont(font);

                for (Endpoint endpoint : endpoints.getRestEndpoints()) {
                    Link restEP = new Link(container, SWT.WRAP | SWT.LEFT);
                    restEP.setText(createUrl(endpoint.getUrl()));
                    GridData linkData = new GridData();
                    linkData.widthHint = 400;
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
                new Label(container, SWT.NONE);
                Label lblSoapEp = new Label(container, SWT.BOLD);
                lblSoapEp.setText(SOAP_ENDPOINTS_LABEL_TEXT);
                FontData fontData = lblSoapEp.getFont().getFontData()[0];
                Font font = new Font(Display.getCurrent(),
                        new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
                lblSoapEp.setFont(font);

                for (Endpoint endpoint : endpoints.getSoapEndpoints()) {
                    Link soapEP = new Link(container, SWT.WRAP | SWT.LEFT);
                    soapEP.setText(createUrl(endpoint.getWsdl()));
                    GridData linkData = new GridData();
                    linkData.widthHint = 400;
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
                new Label(container, SWT.NONE);
                Label lblSwaggerEp = new Label(container, SWT.BOLD);
                lblSwaggerEp.setText(SWAGGER_ENDPOINTS_LABEL_TEXT);
                FontData fontData = lblSwaggerEp.getFont().getFontData()[0];
                Font font = new Font(Display.getCurrent(),
                        new FontData(fontData.getName(), fontData.getHeight(), SWT.BOLD));
                lblSwaggerEp.setFont(font);

                for (Endpoint endpoint : endpoints.getSwaggerEndpoints()) {
                    Link swaggerEp = new Link(container, SWT.WRAP | SWT.LEFT);
                    swaggerEp.setText(createUrl(endpoint.getUrl()));
                    GridData linkData = new GridData();
                    linkData.widthHint = 400;
                    swaggerEp.setLayoutData(linkData);

                    swaggerEp.addSelectionListener(new SelectionAdapter() {

                        @Override
                        public void widgetSelected(SelectionEvent e) {
                            Program.launch(endpoint.getUrl());
                        }

                    });
                }
            }
            new Label(container, SWT.NONE);
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