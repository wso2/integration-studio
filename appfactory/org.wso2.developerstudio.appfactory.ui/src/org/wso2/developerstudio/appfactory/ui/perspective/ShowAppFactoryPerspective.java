/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.appfactory.ui.perspective;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.appfactory.core.Activator;
import org.wso2.developerstudio.appfactory.ui.actions.LoginAction;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class ShowAppFactoryPerspective extends Action{
	

	static final String DASHBOARD_VIEW_ID = "org.wso2.developerstudio.eclipse.dashboard";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public void run() {
		 try {
			    hideDashboards();
		    	IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	        	PlatformUI.getWorkbench().showPerspective("org.wso2.developerstudio.appfactory.ui.perspective", window);
				 
				
			} catch (Exception e) {
				log.error("Cannot open AppFactory perspective",e);
			}
	}
	public String getText() {
		return "Switch to App Cloud/ App Factory perspective";
	}
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.createFromImage(SWTResourceManager
				.getImage(this.getClass(), "/icons/appfac.png"));
				 
	}
	public String getDescription() {
		return "Switch to App Cloud/ App Factory perspective";
	}
	
	  private void hideDashboards(){
		  	try {
		  		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
					IWorkbenchPage page = window.getActivePage();
					List<IEditorReference> openEditors = new ArrayList<IEditorReference>();
					IEditorReference[] editorReferences = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage().getEditorReferences();
					for (IEditorReference iEditorReference : editorReferences) {
						if (DASHBOARD_VIEW_ID.equals(iEditorReference.getId())) {
							openEditors.add(iEditorReference);
						}
					}
					if (openEditors.size() > 0) {
						page.closeEditors(openEditors.toArray(new IEditorReference[] {}), false);
					}
				} catch (Exception e) {
					/* safe to ignore */
				}
		  }
}
