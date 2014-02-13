 /* Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.qos.project.ui.dashboard;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.qos.Activator;
import org.eclipse.ui.part.FileEditorInput;

public class QoSDashboard extends FormEditor {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private QoSDashboardPage dashbordPage;
	private File file;

	
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site, input);
		try{
			if(input instanceof FileEditorInput){
					FileEditorInput ifleEditor =(FileEditorInput)input;
					file = ifleEditor.getFile().getLocation().toFile();
			}
		}catch(Exception e){
			/*Exception ignore*/
	   }
	}
	
	protected void addPages() {
		dashbordPage = new QoSDashboardPage(this,Activator.PLUGIN_ID,"QoSDashboard");
		dashbordPage.setMetaFile(file);
		try {
			addPage(dashbordPage);
			
		} catch (PartInitException e) {
			log.error("Cannot initialize QoSDashboard page",e);
		}
	}

	public void doSave(IProgressMonitor pm) {
		//nothing to do
	}


	public void doSaveAs() {
		//nothing to do
	}


	public boolean isSaveAsAllowed() {
		return false;
	}
}
