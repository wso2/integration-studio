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

import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractEditorFunctionExecutor;

public class EditorContentFunction implements AbstractEditorFunctionExecutor {
    private static String text;

    @Override
    public Object executeFunction(String functionName, Object[] parameters) {
        if (functionName.equals("settext")) {
            EditorContentFunction.setText((String) parameters[1]);
            return null;
        } else if (functionName.equals("gettext")) {
            return EditorContentFunction.getText();
        } else {
            return null;
        }

    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        EditorContentFunction.text = text;
    }

}
