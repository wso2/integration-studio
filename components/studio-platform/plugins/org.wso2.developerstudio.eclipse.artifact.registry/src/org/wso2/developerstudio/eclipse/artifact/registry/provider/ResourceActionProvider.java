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

package org.wso2.developerstudio.eclipse.artifact.registry.provider;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonActionProvider;
import static org.eclipse.ui.navigator.ICommonActionConstants.*;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.wso2.developerstudio.eclipse.artifact.registry.Activator;
import org.wso2.developerstudio.eclipse.artifact.registry.provider.NavigatorNode;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ResourceActionProvider extends CommonActionProvider implements IAction, ISelectionChangedListener{
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private NavigatorNode navigatorNode;
	
	
	public void init(ICommonActionExtensionSite site) {
	super.init(site);
	site.getStructuredViewer().addSelectionChangedListener(this);
	}

	
	public void fillActionBars(IActionBars actionBars) {
	super.fillActionBars(actionBars);
	actionBars.setGlobalActionHandler(OPEN,this);
	}

	
    public void addPropertyChangeListener(IPropertyChangeListener iPropertyChangeListener) {
	    
    }

	
    public int getAccelerator() {
	    return 0;
    }

	
    public String getActionDefinitionId() {
	    return null;
    }

	
    public String getDescription() {
	    return null;
    }

	
    public ImageDescriptor getDisabledImageDescriptor() {
	    return null;
    }

	
    public HelpListener getHelpListener() {
	    return null;
    }

	
    public ImageDescriptor getHoverImageDescriptor() {
	    return null;
    }

	
    public String getId() {
	    return null;
    }

	
    public ImageDescriptor getImageDescriptor() {
	    return null;
    }

	
    public IMenuCreator getMenuCreator() {
	    return null;
    }

	
    public int getStyle() {
	    return 0;
    }

	
    public String getText() {
	    return null;
    }

	
    public String getToolTipText() {
	    return null;
    }

	
    public boolean isChecked() {
	    return false;
    }

	
    public boolean isEnabled() {
	    return false;
    }

	
    public boolean isHandled() {
	    return false;
    }

	
    public void removePropertyChangeListener(IPropertyChangeListener iPropertyChangeListener) {
	    
    }

	
    public void run() {
		try {
	        if(navigatorNode!=null){
	        	RegistryElement node = navigatorNode.getData();
	        	if(node!=null && node instanceof RegistryItem){
	        		/* TODO:for registry collection see @NavigatorNode.java, getChildren()  */
		        		IProject project = navigatorNode.getProject();
		        		if(project !=null && project.isOpen()){
		        			String filePath = ((RegistryItem)node).getFile();
		        			if (!(null== filePath || filePath.trim().isEmpty())) {
	                            IFile file = project.getFile(filePath);
	                            if (file.exists()) {
	                            	if (file.getFileExtension()!=null && !file.getFileExtension().equals("dump")){
	                            		IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                                                .getActivePage(), file);
	                            	}
	                            } else {
		                            throw new IOException("Cannot find file " +
		                                                  file.getLocation().toFile());
	                            }                            
                            } else{
                            	throw new IOException("file path is empty");
                            }
		        		}
	        	}
	        	
	        }
        } catch (Exception e) {
        	log.warn("Cannot open file with default editor: ", e);
        }    
    }

	
    public void runWithEvent(Event evt) {
	    
    }

	
    public void setAccelerator(int id) {
	    
    }

	
    public void setActionDefinitionId(String id) {
	    
    }

	
    public void setChecked(boolean checked) {
	    
    }

	
    public void setDescription(String description) {
	    
    }

	
    public void setDisabledImageDescriptor(ImageDescriptor imageDescriptor) {
	    
    }

	
    public void setEnabled(boolean enabled) {
	    
    }

	
    public void setHelpListener(HelpListener helpListener) {
	    
    }

	
    public void setHoverImageDescriptor(ImageDescriptor imageDescriptor) {
	    
    }

	
    public void setId(String id) {

	    
    }

	
    public void setImageDescriptor(ImageDescriptor imageDescriptor) {
	    
    }

	
    public void setMenuCreator(IMenuCreator menuCreator) {
	    
    }

	
    public void setText(String text) {
	    
    }

	
    public void setToolTipText(String text) {
	    
    }

	
	public void selectionChanged(SelectionChangedEvent evt) {
		ISelection selection = evt.getSelection();
		if (selection != null && selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			Object item = treeSelection.getFirstElement();
			if (item instanceof NavigatorNode) {
				navigatorNode = (NavigatorNode) item;
			}
		}
	}


}
