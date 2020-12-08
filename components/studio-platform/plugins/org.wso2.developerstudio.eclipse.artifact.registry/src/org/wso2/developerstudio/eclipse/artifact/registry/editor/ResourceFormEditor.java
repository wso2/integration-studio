/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.artifact.registry.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
 

public class ResourceFormEditor extends FormEditor  {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private  RegistryResourcePage resourcePage;
    private  boolean isDirty;
    
	public ResourceFormEditor() {
		 super();
	}

	protected void addPages() {
		resourcePage = new RegistryResourcePage(
				this,
				"org.wso2.developerstudio.eclipse.artifact.registry.editor.FormEditor",
				"Design");
		 try {
			 addPage(resourcePage);

		} catch (PartInitException e) {
			log.error("Editor cannot be initialized", e);
		}
	}
	
	public  void updateDirtyState() {
		isDirty = resourcePage.isDirty();
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();	    
    }

	public boolean isDirty() {

		return isDirty;
	} 

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

	public void doSave(IProgressMonitor monitor) {
		
		resourcePage.doPageSave();
	 	}

	public void doSaveAs() {
		
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public void setResourceEditor(RegistryResourcePage resourceEditor) {
		this.resourcePage = resourceEditor;
	}

	public RegistryResourcePage getResourceEditor() {
		return resourcePage;
	}

}
