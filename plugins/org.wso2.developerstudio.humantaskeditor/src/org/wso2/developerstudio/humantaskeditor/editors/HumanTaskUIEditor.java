/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.humantaskeditor.editors;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;
import org.wso2.developerstudio.eclipse.webui.core.exception.WebUIException;
import org.wso2.developerstudio.humantaskeditor.Activator;

public class HumanTaskUIEditor extends AbstractWebBasedEditor {

    private static final String WEB_APP_PATH = "HumanTaskEditor";
    private static final String WEB_APP_INDEX_PATH = "HumanTaskEditor/index.html";

    public HumanTaskUIEditor() {
        super();
    }

    public HumanTaskUIEditor(MultiPageEditorPart multiPageEditor) {
        super(multiPageEditor);
    }

    @Override
    public String getEditorName() {
        return "Human Task Editor";
    }

    @Override
    public String getEditorTitleToolTip() {
        return "Human Task Editor";
    }

    @Override
    public String getEditorURL() throws WebUIException {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL webAppURL = bundle.getEntry(WEB_APP_PATH);
        File resolvedWebAppFolder = null;
        File resolvedWebAppIndex = null;
        try {
            URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
            URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
            resolvedWebAppFolder = new File(resolvedFolderURI);
            resolvedWebAppIndex = new File(resolvedWebAppFolder, "index.html");
            return resolvedWebAppIndex.getAbsolutePath();
        } catch (IOException | URISyntaxException ex) {
            throw new WebUIException("Error while resolving the file path of web app.", ex);
        }

    }

}
