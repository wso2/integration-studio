/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.base.usermgt.ui.controls;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.usermgt.model.RegistryUserPermissionContainer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserPermissionTreeContentProvider implements ITreeContentProvider{

	private Shell shell;
	
	public UserPermissionTreeContentProvider(Shell shell){
		this.shell = shell;
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    
    public void dispose() {
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    
    public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    
    public Object[] getChildren(Object parentElement) {
    	List<RegistryResourceNode> newResourcePathList = new ArrayList<RegistryResourceNode>();
    	if(parentElement instanceof RegistryUserPermissionContainer){
		  return ((RegistryUserPermissionContainer) parentElement).getRegistryContent().toArray();
    	}else if (parentElement instanceof RegistryResourceNode) {
			RegistryResourceNode regResourcePathData = (RegistryResourceNode) parentElement;
			ArrayList<RegistryResourceNode> resourcePathList = null;
			try {
				if (regResourcePathData.isAllowExapand())
					resourcePathList = regResourcePathData
							.getResourceNodeList();
			} catch (Exception e) {
				regResourcePathData.setError(true);
				MessageDialog.openError(shell,
						"Connection Establish error",
						"Cannot establish the connection with given URL");
				// exceptionHandler.showMessage(getShell(),
				// "Cannot establish the connection with given URL");
			}
			if (resourcePathList != null) {
				for (int i = 0; i < resourcePathList.size(); i++) {
					newResourcePathList.add(resourcePathList.get(i));
				}
			}
			return newResourcePathList.toArray();
    	}
    	return newResourcePathList.toArray();
//	    return null;
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
     */
    
    public Object[] getElements(Object parentElement) {
	    return getChildren(parentElement);
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    
    public Object getParent(Object arg0) {
	    return null;
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    
    public boolean hasChildren(Object element) {
    	if (element instanceof RegistryContentContainer) {
			return ((RegistryContentContainer) element).getRegistryContent()
					.size() > 0;
    	}else if (element instanceof RegistryResourceNode) {
			RegistryResourceNode ele = (RegistryResourceNode) element;
			if (!(ele.isAllowExapand()) || ele.getResourceType()==RegistryResourceType.UNDEFINED) {
				return false;
			} else {
				try {
					return ele.getResourceNodeList().size() > 0;
				} catch (Exception e) {
					ele.setError(true);
					return false;
				}
			}
		}
	    return false;
    }

}
