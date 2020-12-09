/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.integrationstudio.eclipse.apim.endpoint.central.wizard;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.wso2.integrationstudio.eclipse.apim.endpoint.central.resources.EndpointCentralServletConstants;
import org.wso2.integrationstudio.eclipse.templates.dashboard.web.view.WebEngineUtils;

/**
 * WizardPage of the Endpoint Central Wizard.
 */
public class EndpointCentralPage extends WizardPage {

    private static final String DIALOG_TITLE = "Service Catalog";
    protected Browser browser;

    protected EndpointCentralPage() {
        super(DIALOG_TITLE);
    }

    @Override
    public void createControl(Composite parent) {
        browser = createBrowser(parent);
        String port = getPortValueForJS();
        browser.setUrl(EndpointCentralServletConstants.SERVLET_HOST + port
                + EndpointCentralServletConstants.Startup.ENDPOINT_CENTRAL_CONTEXT_PATH 
                + EndpointCentralServletConstants.Startup.APIM_CTL_LOGIN_PATH + "?port=" + port);
    }

    /**
     * This method create a browser in the wizard control.
     * 
     * @param parent parent composite
     * @return created browser
     */
    private Browser createBrowser(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        container.getShell().setText(DIALOG_TITLE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        container.setLayout(gridLayout);
        setControl(container);
        Browser browser = new Browser(container, WebEngineUtils.getBrowserType());
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.horizontalSpan = 1;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        data.heightHint = 800;
        data.widthHint = 1200;
        browser.setLayoutData(data);
        return browser;
    }

    /**
     * Get server port from the preferences.
     * 
     * @return server port
     */
    private String getPortValueForJS() {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        return rootNode.get("portDetails", EndpointCentralServletConstants.EMBEDDED_SERVER_PORT);
    }
}
