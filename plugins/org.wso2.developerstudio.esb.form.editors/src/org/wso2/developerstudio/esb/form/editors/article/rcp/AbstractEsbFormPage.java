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

package org.wso2.developerstudio.esb.form.editors.article.rcp;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.esb.form.editors.Activator;

public abstract class AbstractEsbFormPage extends FormPage {

	protected EsbNode esbNode;
	private boolean isSave;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public AbstractEsbFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	public EsbNode getEsbNode() {
		return esbNode;
	}

	public void setEsbNode(EsbNode esbNode) {
		this.esbNode = esbNode;
	}
	
	public void doPageSave(){
		try {
			setSave(false);
			((ESBFormEditor)getEditor()).setDirty(false);
			updateDirtyState();
			((FileEditorInput) getEditorInput()).getFile().getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		 } catch (Exception e) {
			log.error("Cannot save the content", e);
		}
	}
	
	public void updateDirtyState() {
		ESBFormEditor editor = (ESBFormEditor)getEditor();
		editor.setDirty(isSave());
		firePropertyChange(PROP_DIRTY);
		editor.editorDirtyStateChanged();	    
    }
	
	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}

	public boolean isSave() {
		return isSave;
	}

}
