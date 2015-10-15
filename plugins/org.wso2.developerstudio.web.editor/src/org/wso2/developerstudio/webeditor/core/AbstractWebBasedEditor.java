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
package org.wso2.developerstudio.webeditor.core;

import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.UndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.webeditor.AbstractWebEditorPlugin;
import org.wso2.developerstudio.webeditor.function.ExecuteUndoableTaskFunction;
import org.wso2.developerstudio.webeditor.function.GetDirtyContentFunction;
import org.wso2.developerstudio.webeditor.function.GetFileContentFunction;
import org.wso2.developerstudio.webeditor.function.SaveContentFunction;
import org.wso2.developerstudio.webeditor.function.SetDirtyContentFunction;
import org.wso2.developerstudio.webeditor.function.SetDirtyFunction;
import org.wso2.developerstudio.webeditor.function.SetFocusToEditorPartFunction;
import org.wso2.developerstudio.webeditor.handler.BrowserCopyActionHandler;
import org.wso2.developerstudio.webeditor.model.BrowserScript;
import org.wso2.developerstudio.webeditor.util.ScriptFactory;

public abstract class AbstractWebBasedEditor extends EditorPart {

	protected Browser browser;
	protected ObjectUndoContext editorUndoContext;
	protected FileEditorInput editorInput;
	protected AbstractWebBasedEditor editorInstance;
	protected String dirtyContent;
	protected MultiPageEditorPart parentEditor;
	protected boolean isDirty;
	
	private static IDeveloperStudioLog log = Logger.getLog(AbstractWebEditorPlugin.PLUGIN_ID);

	public AbstractWebBasedEditor() {
		this.editorInstance = this;
		this.editorUndoContext = new ObjectUndoContext(this);
	}
	
	public AbstractWebBasedEditor(MultiPageEditorPart parent){
		this();
		this.parentEditor = parent;
	}

	public abstract String getWebAppURL();

	public abstract String getEditorName();

	public abstract String getEditorTitleToolTip();

	@Override
	public void doSave(IProgressMonitor arg0) {
		executeScriptOnBrowser(ScriptFactory.INVOKE_FN_SAVE_FILE);
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		editorInput = (FileEditorInput) input;
		initActionHandlers();
	}

	protected void initActionHandlers() {
		IEditorSite site = (IEditorSite) getSite();
		IActionBars actionBars = site.getActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
				new UndoActionHandler(site, editorUndoContext));
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
				new RedoActionHandler(site, editorUndoContext));
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(),
				new BrowserCopyActionHandler());
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
		browser = new Browser(parent, SWT.NONE);
		browser.setUrl(getWebAppURL());
		browser.addControlListener(new ControlListener() {
			public void controlResized(ControlEvent e) {
			}

			public void controlMoved(ControlEvent e) {
			}
		});
		browser.addProgressListener(new ProgressListener() {

			@Override
			public void completed(ProgressEvent arg0) {
				executeScriptOnBrowser(ScriptFactory.INVOKE_FN_LOAD_FILE_CONTENT);
			}

			@Override
			public void changed(ProgressEvent arg0) {

			}
		});
		browser.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				editorInstance.setFocus();
			}
		});
		injectCustomJSFunctions();
		setPartName(getEditorName());
	}

	protected void injectCustomJSFunctions() {
		if (browser != null) {
			new SaveContentFunction(editorInstance);
			new SetDirtyFunction(editorInstance);
			new ExecuteUndoableTaskFunction(editorInstance);
			new GetFileContentFunction(editorInstance);
			new SetFocusToEditorPartFunction(editorInstance);
			new GetDirtyContentFunction(editorInstance);
			new SetDirtyContentFunction(editorInstance);
		} else {
			throw new IllegalStateException("Browser is not yet instantiated.");
		}
	}

	@Override
	public void setFocus() {
		if(parentEditor == null){
			getEditorSite().getPage().activate(this);
		}
		else{
			parentEditor.getEditorSite().getPage().activate(parentEditor);
		}
	}

	@Override
	public String getTitleToolTip() {
		return getEditorTitleToolTip();
	}

	public boolean executeScriptOnBrowser(BrowserScript script) {
		if (browser != null) {
			return browser.execute(script.getScript());
		}
		return false;
	}

	@Override
	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
		firePropertyChange(PROP_DIRTY);
	}

	public boolean sendUndoMessage(String uniqueOperationID) {
		return false;
	}

	public boolean sendRedoMessage(String uniqueOperationID) {
		return false;
	}

	public Browser getBrowser() {
		return browser;
	}

	public UndoContext getUndoContext() {
		return editorUndoContext;
	}

	public String getDirtyContent() {
		return dirtyContent;
	}

	public void setDirtyContent(String dirtyContent) {
		this.dirtyContent = dirtyContent;
	}
	
	public void fetchDirtyContentFromWebApp(){
		executeScriptOnBrowser(ScriptFactory.INVOKE_FN_SET_IDE_DIRTY_CONTENT);
	}
	
	public void loadDirtyContentToWebApp(){
		executeScriptOnBrowser(ScriptFactory.INVOKE_FN_LOAD_IDE_DIRTY_CONTENT);
	}
}
