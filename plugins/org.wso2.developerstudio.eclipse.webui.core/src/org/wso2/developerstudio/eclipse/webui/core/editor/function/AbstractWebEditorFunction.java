/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.webui.core.WebUICorePlugin;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractWebBasedEditor;

public abstract class AbstractWebEditorFunction extends BrowserFunction {

	protected AbstractWebBasedEditor editor;
	protected FileEditorInput editorInput;
	protected static IDeveloperStudioLog log = Logger.getLog(WebUICorePlugin.PLUGIN_ID);

	public AbstractWebEditorFunction(AbstractWebBasedEditor editor, String name) {
		this(editor.getBrowser(), name);
		this.editor = editor;
		if (editor.getEditorInput() instanceof FileEditorInput) {
			this.editorInput = (FileEditorInput) editor.getEditorInput();
		}
	}

	public AbstractWebEditorFunction(Browser browser, String name) {
		super(browser, name);
	}
}
