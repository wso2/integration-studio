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

package org.wso2.developerstudio.eclipse.capp.registry.connector.handler;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
//import org.wso2.developerstudio.eclipse.capp.artifact.registry.utils.RegistryResourceUtils;
import org.wso2.carbon.registry.synchronization.SynchronizationException;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.RegistryTreeBrowserDialog;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryData;
import org.wso2.developerstudio.eclipse.capp.core.utils.Constants;
import org.wso2.developerstudio.eclipse.capp.registry.connector.Activator;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.RegistryHandlerUtils;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.ResourceMetaData;
import org.wso2.developerstudio.eclipse.capp.registry.connector.wizards.NewRegistryConnectionWizard;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.base.util.FilterMethods;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.RegistryContentRetrieveException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;
import org.wso2.developerstudio.eclipse.registry.libraries.utils.LibraryUtils;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;
import org.wso2.developerstudio.eclipse.registry.manager.remote.views.RegistryBrowserView;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;

public class RegistryHandler implements IRegistryHandler {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private static RegistryHandler INSTANCE;
	private HashMap<File, String> resourceList;
	private static final String RESOURCE = "resource";
	private static final String COLLECTION = "collection";
	public RegistryHandler() {
    }
	
	public static RegistryHandler getInstance(){
		if (INSTANCE==null){
			INSTANCE=new RegistryHandler();
		}
		return INSTANCE;
	}
	
	public List<IRegistryConnection> getRegistryConnections(IProject project) {
		return RegistryHandlerUtils.getRegistryConnections(project);
	}

	public void importRegistryPathToFileSystem(IRegistryData registryData, File toPath) {
		try {
	        RegistryCheckInClientUtils.checkout(registryData.getUsername(), registryData.getPassword(), toPath.toString(), registryData.getURL().toString(), registryData.getPath());
        } catch (SynchronizationException e) {
	        log.error(e);
        }
	}

	public void createMetaDataForFolder(String checkoutPath, File fromPath){
		ResourceMetaData resMetaData = new ResourceMetaData();
		if (fromPath.getName().equals(".meta")) return;
		try {
			if (fromPath.isFile()){
				File metaFolderPath = createMetaFolder(fromPath.getParentFile());
				resMetaData.createElement(fromPath, checkoutPath, true, metaFolderPath, false);
			}else{
				File metaFolderPath = createMetaFolder(fromPath);
				resMetaData.createElement(fromPath, checkoutPath, false, metaFolderPath, false);
				File[] listFiles = fromPath.listFiles();
				for (File file : listFiles) {
					createMetaDataForFolder(checkoutPath+"/"+fromPath.getName(), file);
				}
			}
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] getFilterMethods(){
		FilterMethods filtermethods = new FilterMethods();
		return filtermethods.getFilterMethodList();
	}
	
	private File createMetaFolder(File resourceFile){
		File metaFolder = new File(resourceFile ,  ".meta");
		metaFolder.mkdirs();
		return metaFolder; 
	}
	
	public void searchDir(File file){
		resourceList = new HashMap<File, String>();
		if(file.isDirectory()){
			if(!resourceList.containsKey(file)){
				resourceList.put(file, COLLECTION);
			}
			File[] listFiles = file.listFiles();
			if(listFiles != null){
				for (File file2 : listFiles) {
					if(file2.isDirectory()){
						searchDir(file2);
					}else{
						if(!resourceList.containsKey(file2)){
							resourceList.put(file2, RESOURCE);
						}
					}
				}
			}else{
				if(!resourceList.containsKey(file)){
					resourceList.put(file, COLLECTION);
				}
					
			}
		}
	}
	
	public IRegistryData selectRegistryPath(IRegistryConnection[] registryConnections, String title,
	                                        String message, int type){
		RegistryTreeBrowserDialog dialog = new RegistryTreeBrowserDialog(getShell(),type);
		if (title!=null) dialog.setTitle(title);
		if (message!=null) dialog.setMessage(message);
		dialog.create();
		for (IRegistryConnection data : registryConnections) {
	        dialog.addRegistry(data.getURL(), data.getPath(), data.getUsername(), data.getPassword());
        }
		if (dialog.open() == Window.OK){
			RegistryData regData = new RegistryData();
			RegistryResourceNode node=dialog.getSelectedRegistryResourceNodeResource();
			
			if (node==null){
				node=dialog.getSelectedRegistryResourceNode();
			}
			if (node!=null){
				if(node.getResourceType()==RegistryResourceType.RESOURCE){
					regData.setType(Constants.REGISTRY_RESOURCE);
				}else if(node.getResourceType()==RegistryResourceType.COLLECTION){
					regData.setType(Constants.REGISTRY_COLLECTION);
				}else{
					log.error("Resource not defined");
				}
				
				regData.setURL(node.getConnectionInfo().getUrl());
				regData.setPath(node.getRegistryResourcePath());
				regData.setUsername(node.getConnectionInfo().getUsername());
				regData.setPassword(node.getConnectionInfo().getPassword());
			}else{
				RegistryNode registryNode = dialog.getSelectedRegistryNode();
				regData.setType(Constants.REGISTRY_ROOT);
				regData.setURL(registryNode.getUrl());
				regData.setUsername(registryNode.getUsername());
				regData.setPassword(registryNode.getPassword());
				regData.setPath(registryNode.getRegistryStartingPath());
			}
			return regData;
		}
		
		
		return null;
		
	}
	
	private Shell getShell(){
		return Display.getDefault().getActiveShell();
	}

    public IRegistryConnection createNewRegistryConnection(IProject project, boolean createRegistryConnectionAtTheFinish) {
    	NewRegistryConnectionWizard wizard = new NewRegistryConnectionWizard();
    	wizard.setCreateRegistryConnectionAtTheEnd(createRegistryConnectionAtTheFinish);
    	WizardDialog dialog = new WizardDialog(getShell(), wizard);
    	wizard.init(PlatformUI.getWorkbench(), new StructuredSelection(project));
    	if (dialog.open()==Window.OK){
    		return wizard.getRegistryConnection();
    	}
	    return null;
    }

    public void createNewRegistryConnection(IProject project, IRegistryConnection registryConnection) {
//    	RegistryHandlerUtils.addNewRegistryConnection(project, registryConnection);
    }

    public void openRegistryBrowserView(IRegistryData registryData) {
		boolean found=false;
		try {
			if (!found){
				PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().showView("org.wso2.developerstudio.registry.remote.registry.view");
			}
		} catch (PartInitException e1) {
			e1.printStackTrace();
		}
		RegistryBrowserView view = RegistryBrowserView.lastInstance;
		if (view != null) {
			view.traverseRegistryBrowser(registryData.getURL().toString(),registryData.getPath());
		}
    }
    
    public void hideRegistryBrowserView(String url, String path){
		boolean found=false;
		try {
			if (!found){
				PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().showView("org.wso2.developerstudio.registry.remote.registry.view");
			}
		} catch (PartInitException e1) {
			e1.printStackTrace();
		}
		RegistryBrowserView view = RegistryBrowserView.lastInstance;
		if (view != null) {
			view.removeRegistryNode(url,path);
		}
    }

    public boolean isRegistryConnectionPresent(IProject project, String connectionName) {
    	List<IRegistryConnection> registryConnections = RegistryHandlerUtils.getRegistryConnections(project);
    	for (IRegistryConnection connection : registryConnections) {
	        if (connection.getConnectionName().equals(connectionName)){
	        	return true;
	        }
        }
	    return false;
    }

    public boolean isRegistryConnectionPresent(IProject project, IRegistryConnection connection) {
	    return isRegistryConnectionPresent(project, connection.getConnectionName());
    }

    public void importRegistryResourceToFileSystem(IRegistryData registryData, File toFile) throws InvalidRegistryURLException, UnknownRegistryException, RegistryContentRetrieveException, IOException{
    	RegistryCheckInClientUtils.download(registryData.getUsername(), registryData.getPassword(), toFile.toString(), registryData.getURL().toString(), registryData.getPath());
    }

	public File getRegistryCoreLibraryPath() {
		return LibraryUtils.getRegistryCoreLibraryPath();
	}

	public void createArtifact(IProject project, String name, String deployPathToRegistry, String serverRole, boolean openResource, File... resources) throws IOException, CoreException, Exception {
//		RegistryResourceUtils.createRegistryResourceArtifact(project, name, serverRole, deployPathToRegistry, true, false, openResource, resources[0]);
	}

	public IRegistryConnection[] getRegistryConnections() {
		List<IRegistryConnection> connectionList = new ArrayList<IRegistryConnection>();
		List<RegistryURLInfo> allRegistryUrls = RegistryUrlStore.getInstance().getAllRegistryUrls();
		for (RegistryURLInfo registryURLInfo : allRegistryUrls) {

			RegistryConnection registryConnection = new RegistryConnection();
			registryConnection.setURL(registryURLInfo.getUrl());
			registryConnection.setPath(registryURLInfo.getPath());
			registryConnection.setUsername(registryURLInfo.getUsername());

			// Fixing TOOLS-467
			boolean isExist = false;

			for (IRegistryConnection registryCon : connectionList) {
				
				String registryConUrl = registryCon.getURL().toString().trim();
				if(!registryConUrl.endsWith("/")){
					registryConUrl=registryConUrl.concat("/");
				}
				
				String registryConnectionUrl = registryConnection.getURL().toString().trim();
				if(!registryConnectionUrl.endsWith("/")){
					registryConnectionUrl=registryConnectionUrl.concat("/");
				}
				
				if ((registryConUrl.equalsIgnoreCase(registryConnectionUrl)) &&
				    (registryCon.getPath().equals(registryConnection.getPath())) &&
				    (registryCon.getUsername().equals(registryConnection.getUsername()))) {
					isExist = true;
					break;
				}
			}

			if (!isExist) {
				connectionList.add(registryConnection);
			}
		}
		return connectionList.toArray(new IRegistryConnection[] {});
	}

}
