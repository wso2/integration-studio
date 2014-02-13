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
package org.wso2.developerstudio.eclipse.qos.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.qos.Activator;
import org.wso2.developerstudio.eclipse.qos.project.model.Service;
import org.wso2.developerstudio.eclipse.qos.project.ui.dashboard.QoSDashboard;
import org.wso2.developerstudio.eclipse.qos.project.ui.wizard.QOSProjectWizard;



public class OpenQoSDashboardCommandHandler  extends AbstractHandler {
	
	public static IProject project;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	static final String INTRO_VIEW_ID = "org.eclipse.ui.internal.introview";
	static final String DASHBOARD_VIEW_ID = "org.wso2.developerstudio.eclipse.qos.QoSDashboard";
	static final String J2EE_PERSPECTIVE_ID = "org.eclipse.jst.j2ee.J2EEPerspective";
    static final String QOS_WIZARD_ID = "org.wso2.developerstudio.eclipse.artifact.newqosproject";

    public Object execute(ExecutionEvent event) throws ExecutionException {
		    IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	        IWorkbenchPage page = window.getActivePage();
	        try {
	        	//hideIntroView();
	        //	hideDashboards();
	        	IStructuredSelection selection =
	                    (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
	        	Object element = ((IStructuredSelection)selection).getFirstElement();
	        	 if (element instanceof IResource) {
	         /*   project= ((IResource)element).getProject();
	        	PlatformUI.getWorkbench().showPerspective(J2EE_PERSPECTIVE_ID, window);
				IEditorPart openEditor = page.openEditor(new NullEditorInput(), DASHBOARD_VIEW_ID);
				QoSDashboard dashboard = (QoSDashboard) openEditor;*/
				
				IWorkbenchWizard wizard = openWizard(QOS_WIZARD_ID, selection);
			   

	        	 }
			} catch (Exception e) {
				log.error("Cannot open dashboard", e);
			}
	    return true;
    }
    
    
    private IWorkbenchWizard openWizard(String id,IStructuredSelection selection) {
		 IWizardDescriptor descriptor = PlatformUI.getWorkbench()
		   .getNewWizardRegistry().findWizard(id);
		 
		 try {
		   if (null != descriptor) {
			 IWorkbenchWizard wizard = descriptor.createWizard();
			 wizard.init(PlatformUI.getWorkbench(), selection);
		     WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), wizard);
		     wd.setTitle(wizard.getWindowTitle());
		     wd.open();
		     return wizard;
		   }

		 } catch (CoreException e) {
					   log.error("Cannot open wizard",e);
		 }
         return null;
		}
    
    
    /**
     * hide eclipse welcome page
     */
    private void hideIntroView(){
    	try {
    		 IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    		 IWorkbenchPage page = window.getActivePage();
    		 IViewReference ref = page.findViewReference(INTRO_VIEW_ID);
    		 page.hideView(ref);
		} catch (Exception e) {
			/* safe to ignore */
		}
    }
    
    /**
     * hide open dashboards
     */
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
	
	class NullEditorInput implements IEditorInput {

		public boolean exists() {
		return true;
		}

		public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.getMissingImageDescriptor();
		}

		public String getName() {
		return "Dashboard";
		}

		public IPersistableElement getPersistable() {
		return null;
		}

		public String getToolTipText() {
		return "Developer Studio QoS Editor";
		}

		public Object getAdapter(Class adapter) {
		return null;
		}
		} }
