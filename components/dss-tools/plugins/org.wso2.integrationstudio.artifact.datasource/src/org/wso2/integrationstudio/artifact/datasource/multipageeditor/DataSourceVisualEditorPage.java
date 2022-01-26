/*
* Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.artifact.datasource.multipageeditor;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.wso2.integrationstudio.webui.core.editor.AbstractWebBasedEditor;
import org.wso2.integrationstudio.webui.core.exception.WebUIException;

public class DataSourceVisualEditorPage extends AbstractWebBasedEditor {
    private static final String WEB_APP_PATH = "DataSourceEditor";
    public static final int EMBEDDED_JETTY_SERVER_PORT = 7774;

    public DataSourceVisualEditorPage() {
        super();
    }

    public DataSourceVisualEditorPage(MultiPageEditorPart multiPageEditor) {
        super(multiPageEditor);
    }

    @Override
    public String getEditorName() {
        return DataSourceVisualEditorConstants.General.DATASOURCE_EDITOR;
    }

    @Override
    public String getEditorTitleToolTip() {
        return DataSourceVisualEditorConstants.General.DATASOURCE_EDITOR;
    }

    @Override
    public String getEditorURL() throws WebUIException {
        URL webAppURL = DataSourceEditorPlugin.getPlugin().getBundle().getEntry(WEB_APP_PATH);
        File resolvedWebAppFolder;
        File resolvedWebAppIndex;
        try {
            URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
            URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
            resolvedWebAppFolder = new File(resolvedFolderURI);
            resolvedWebAppIndex = new File(resolvedWebAppFolder,
                    DataSourceVisualEditorConstants.WebApp.INDEX_HTML_FILE_NAME);

            return resolvedWebAppIndex.getAbsolutePath() + "?port=" + getJettyPort();
        } catch (IOException | URISyntaxException e) {
            throw new WebUIException("Error while resolving the file path of web app.", e);
        }
    }

    private String getJettyPort() {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        return rootNode.get("portDetails", String.valueOf(EMBEDDED_JETTY_SERVER_PORT));
    }

}
