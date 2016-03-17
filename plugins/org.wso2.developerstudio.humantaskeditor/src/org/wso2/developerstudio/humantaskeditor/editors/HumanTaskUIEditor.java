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

import org.eclipse.ui.part.MultiPageEditorPart;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;

public class HumanTaskUIEditor extends AbstractWebBasedEditor {

    public HumanTaskUIEditor() {
        super();
    }

    public HumanTaskUIEditor(MultiPageEditorPart multiPageEditor) {
        super(multiPageEditor);
    }

    @Override
    public String getWebAppID() {
        return "HumanTaskEditorApp";
    }

    @Override
    public String getEditorName() {
        return "Human Task Editor";
    }

    @Override
    public String getEditorTitleToolTip() {
        return "Human Task Editor";
    }

}
