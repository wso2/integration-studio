/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.views;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

/**
 * Datamapper test window ViewPart
 * 
 * @author lahiru
 *
 */
public class RealtimeDatamapperView extends ViewPart {

    public static final int EMBEDDED_SERVER_PORT = 7774;
    private static final String NO_CACHE = "&nocache=1";
    private Browser browser;

    @Override
    public void createPartControl(Composite arg0) {
        browser = new Browser(arg0, SWT.NONE);
        String port = getPortValueForJS();
        browser.setUrl("http://localhost:" + port + "/dataMapper?port=" + port + NO_CACHE);
    }

    public void closeBrowser() {
        browser.close();
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }

    public void setURL(URL url) {
        browser.setUrl(url.toString() + NO_CACHE);
    }

    public void setURL() {
        String port = getPortValueForJS();
        browser.setUrl("http://localhost:" + port + "/dataMapper?port=" + port + NO_CACHE);
        browser.refresh();
    }

    /**
     * setURL method which sends input and output payload types along with the URL
     * @param inputSchema input payload type
     * @param outputSchema output payload type
     */
    public void setURL(String inputSchema, String outputSchema) {
        String port = getPortValueForJS();
        browser.setUrl("http://localhost:" + port + "/dataMapper?port=" + port + "&inputtype=" + inputSchema
                + "&outputtype=" + outputSchema + NO_CACHE);
    }

    /**
     * This method gets port value retrieved from preferences
     * 
     * @param browser started browser instance
     */
    private String getPortValueForJS() {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        return rootNode.get("portDetails", String.valueOf(EMBEDDED_SERVER_PORT));
    }
}
