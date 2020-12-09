/*
 * Copyright (c) 2019 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software He   
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.wso2.integrationstudio.eclipse.docker.distribution.resources;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.eclipse.docker.distribution.Activator;
import org.wso2.integrationstudio.eclipse.docker.distribution.utils.DockerProjectConstants;

public class K8sUserGuideTemplate extends ViewPart {

    private Browser browser;
    public static final String TEMPLATE_GUIDE_VIEW_ID = "org.wso2.integrationstudio.eclipse.esb.templates.kubernetes.view";
    public static final String ERROR_MESSAGE_OPENING_EDITOR = "Error opening editor";
    private static final String NO_CACHE = "?nocache=1";

    @Override
    public void createPartControl(Composite arg0) {
        browser = new Browser(arg0, SWT.NONE);

        try {
            browser.setUrl(getUserGuidePage());
        } catch (Exception ex) {
        }

    }

    private String getUserGuidePage() throws URISyntaxException, IOException {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        if (bundle == null) {
            return null;
        }
        URL webAppURL = bundle.getEntry(DockerProjectConstants.K8S_USER_GUIDE_PATH);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFile = new File(resolvedFolderURI);
        return resolvedWebAppFile.getAbsolutePath() + NO_CACHE;
    }

    @Override
    public void setFocus() {
    }

    public void setURL(URL url) {
        browser.setUrl(url.toString() + NO_CACHE);
    }
}
