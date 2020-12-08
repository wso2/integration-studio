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

package org.wso2.developerstudio.eclipse.capp.registry.connector.provider;

import java.net.MalformedURLException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.wso2.developerstudio.eclipse.capp.registry.connector.Activator;
import org.wso2.developerstudio.eclipse.capp.registry.connector.model.RegistryConnectionNode;
import org.wso2.developerstudio.eclipse.capp.registry.connector.model.RegistryConnectionsNode;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RegistryConnectionContentProvider implements ICommonContentProvider, IResourceChangeListener{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private static final QualifiedName REGISTRY_CONNECTION_KEY=new QualifiedName("reg","registry connections");
	private Viewer viewer;
	public void init(ICommonContentExtensionSite arg0) {
		
	}
	public RegistryConnectionContentProvider() {
		 ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
    }
	
    public RegistryConnectionsNode getRegistryConnectionsNode(IProject project) throws CoreException, MalformedURLException{
		RegistryConnectionsNode registryConnectionsNode;
		Object sessionProperty = project.getSessionProperty(REGISTRY_CONNECTION_KEY);
		if (sessionProperty==null || !(sessionProperty instanceof RegistryConnectionsNode)){
			registryConnectionsNode = new RegistryConnectionsNode(project);
			project.setSessionProperty(REGISTRY_CONNECTION_KEY, registryConnectionsNode);
		}else{
			registryConnectionsNode=(RegistryConnectionsNode)sessionProperty;
		}
		if (registryConnectionsNode.getRegistryConnections().size()==0){
			registryConnectionsNode = null;
		}
		
		return registryConnectionsNode;
		
	}
	
	public Object[] getChildren(Object obj) {
    	if (obj instanceof IProject){
    		IProject project=(IProject)obj;
    		try {
    			RegistryConnectionsNode registryConnectionsNode = getRegistryConnectionsNode(project);
    			if (registryConnectionsNode!=null){
    				return new Object[]{registryConnectionsNode};
    			}
            } catch (MalformedURLException e) {
	            log.error(e);
            } catch (CoreException e) {
	            log.error(e);
            }
    	}else if (obj instanceof RegistryConnectionsNode){
    		RegistryConnectionsNode node=(RegistryConnectionsNode)obj;
    		return node.getRegistryConnections().toArray();
    	}
	    return new Object[]{};
	}
	
	public Object getParent(Object arg0) {
		return null;
	}

	public boolean hasChildren(Object obj) {
    	if (obj instanceof IProject){
    		RegistryConnectionsNode registryConnectionsNode;
            try {
	            registryConnectionsNode = getRegistryConnectionsNode((IProject)obj);
	    		return (registryConnectionsNode!=null);
            } catch (MalformedURLException e) {
	            log.error(e);
            } catch (CoreException e) {
	            log.error(e);
            }
    	}else if (obj instanceof RegistryConnectionsNode){
    		return true;
    	}
    	return false;
	}

	public Object[] getElements(Object obj) {
		return getChildren(obj);
	}

	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}

	public void inputChanged(Viewer viewer, Object arg1, Object arg2) {
		this.viewer = viewer;
	}

	public void restoreState(IMemento arg0) {
		
	}

	public void saveState(IMemento arg0) {
		
	}
	
    public void resourceChanged(IResourceChangeEvent arg0) {
    	Display.getDefault().asyncExec(new Runnable(){
            public void run() {
				if (!viewer.getControl().isDisposed()) {
					viewer.refresh();
				}
            }
    		
    	});
    }

}
