/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.swagger;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.view.WebEngineUtils;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;
import org.wso2.developerstudio.eclipse.webui.core.exception.WebUIException;

// Represents the DSS visual editor page
public class EsbSwaggerEditor extends AbstractWebBasedEditor {
    private static final String WEB_APP_PATH = "swagger-editor";
    private static final String INDEX_HTML_FILE_NAME = "index.html";
    public static final int EMBEDDED_JETTY_SERVER_PORT = 7774;

    public EsbSwaggerEditor() {
        super();
    }

    public EsbSwaggerEditor(MultiPageEditorPart multiPageEditor) {
        super(multiPageEditor);
    }

    @Override
    public String getEditorName() {
        return "Swagger Editor";
    }

    @Override
    public String getEditorTitleToolTip() {
        return "Swagger Editor";
    }

    @Override
    public String getEditorURL() throws WebUIException {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL webAppURL = bundle.getEntry(WEB_APP_PATH);
        File resolvedWebAppFolder;
        File resolvedWebAppIndex;
        try {
            URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
            URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
            resolvedWebAppFolder = new File(resolvedFolderURI);
            resolvedWebAppIndex = new File(resolvedWebAppFolder, INDEX_HTML_FILE_NAME);

            return resolvedWebAppIndex.getAbsolutePath() + "?port=" + getJettyPort();
        } catch (IOException | URISyntaxException e) {
            throw new WebUIException("Error while resolving the file path of web app.", e);
        }

    }

    private String getJettyPort() {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        return rootNode.get("portDetails", String.valueOf(EMBEDDED_JETTY_SERVER_PORT));
    }

    @Override
    public void createPartControl(Composite parent) {
        browser = createBrowser(parent);
        String port = getPortValueForJS();
        browser.setUrl("http://127.0.0.1:" + port + "/swagger-editor" + "?port=" + getJettyPort() + "&nocache=1");
    }

    private Browser createBrowser(Composite parent) {
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        parent.setLayout(gridLayout);
        Browser browser = new Browser(parent, WebEngineUtils.getBrowserType());
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.horizontalSpan = 1;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        browser.setLayoutData(data);
        return browser;
    }

    /**
     * This method gets port value retrieved from preferences
     * 
     * @param browser
     *            started browser instance
     */
    private String getPortValueForJS() {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        return rootNode.get("portDetails", String.valueOf(FunctionServerConstants.EMBEDDED_SERVER_PORT));
    }

}