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
package org.wso2.developerstudio.eclipse.webui.core.editor.function;

import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractEditorFunctionExecutor;
import org.wso2.developerstudio.eclipse.webui.core.editor.Constants;


public class CustomEditorFunction extends AbstractWebEditorFunction {

	public CustomEditorFunction(AbstractWebBasedEditor editor) {
		super(editor, Constants.CUSTOM_EDITOR_FUNCTION);
	}

	@Override
	public Object function(Object[] arguments) {
		 AbstractEditorFunctionExecutor functionExecutor = editor.getEditorFunctionExecutor();
		 if (functionExecutor != null && arguments != null && arguments.length > 0) {
			 return functionExecutor.executeFunction((String)arguments[0], arguments);
		 }
		 return null;
	}
}
