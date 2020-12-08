/*
 *     Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *     WSO2 Inc. licenses this file to you under the Apache License,
 *     Version 2.0 (the "License"); you may not use this file except
 *     in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
package org.wso2.developerstudio.eclipse.templates.dashboard.help;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TemplateGuideView extends ViewPart {

	private static final String NO_CACHE = "?nocache=1";
    private Browser browser;

    @Override
    public void createPartControl(Composite arg0) {
        browser = new Browser(arg0, SWT.NONE);

        try {
            browser.setUrl(getDefaultPage());
        } catch (Exception ex) {
        }

    }

    private String getDefaultPage() throws URISyntaxException, IOException {
        String PLUGIN_ID = "org.wso2.developerstudio.eclipse.esb.dashboard.templates";
        String INDEX_HTML = "DefaultReadMe.html";
        Bundle bundle = Platform.getBundle(PLUGIN_ID);
        if (bundle == null) {
            return null;
        }
        URL webAppURL = bundle.getEntry("NewSamples");
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);
        File resolvedWebAppIndex = new File(resolvedWebAppFolder, INDEX_HTML);
        return resolvedWebAppIndex.getAbsolutePath() + NO_CACHE;
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }

    public void setURL(URL url) {
        browser.setUrl(url.toString() + NO_CACHE);
    }

}
