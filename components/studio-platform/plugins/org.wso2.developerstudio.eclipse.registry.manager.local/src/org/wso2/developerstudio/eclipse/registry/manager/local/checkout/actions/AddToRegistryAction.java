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

package org.wso2.developerstudio.eclipse.registry.manager.local.checkout.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.SSLHandshakeException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.synchronization.SynchronizationException;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.SWTControlUtils;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.MediaManager;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.dialog.CheckingToRegistryDialog;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public class AddToRegistryAction extends BaseRegistryAction {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	

	/**
	 * execute File
	 */
	protected void executeFile(IFile file, IAction action) {
		
		CheckingToRegistryDialog checkingToRegistryDialog = new CheckingToRegistryDialog(
				Display.getCurrent().getActiveShell(), (IContainer) file.getParent());
		if (checkingToRegistryDialog.open() == Window.OK) {
			String url = checkingToRegistryDialog.getServerUrl();
			String path = checkingToRegistryDialog.getPath();
			
			if(isRegistryUrlValid(url)){
				Credentials credentials = RegistryCredentialData.getInstance().getCredentials(url);
				if(credentials != null){
					if (!(credentials.getUsername() != null && 
							credentials.getPassword() != null && 
							MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
									"Credentials", 
									"Check-in as user '" + 
									credentials.getUsername() + "'?"))) {
										credentials = SWTControlUtils.requestCredentials(
										   Display.getCurrent().getActiveShell(), 
										   url, 
										   credentials.getUsername() == null ?
										   "" : credentials.getUsername());
										if (credentials == null){
											return;
										}
								}
							Registry registry = new Registry(credentials.getUsername(), 
															credentials.getPassword(), 
															url);
							Resource resource;
							try {
								resource = registry.newResource();
								resource.setContentStream(getFileContent(file.getLocation().toOSString()));
								resource.setMediaType(MediaManager.getMediaType(new File(file.getLocation().toOSString())));
								registry.put(path + "/" + file.getName(), resource);
							} catch (InvalidRegistryURLException e) {
								e.printStackTrace();
							} catch (UnknownRegistryException e) {
								e.printStackTrace();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (RegistryException e) {
								e.printStackTrace();
							}
							
					}
				}
		}

	}
	
	public InputStream getFileContent(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		InputStream inStr = new FileInputStream(file);
		return inStr;
	}
	
	private boolean isRegistryUrlValid(String url) {
		
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		    con.connect();
//		    if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
//		    	return true;
//		    }
		} catch (MalformedURLException e) {
			log.error(e);
			return false;
		} catch (SSLHandshakeException e) {
			log.error(e);
			return true;
		}catch (IOException e) {
			log.error(e);
		    return false;
		} 
		catch (Exception e) {
			log.error(e);
		    return false;
		 }
		return true;
		
	}

	/**
	 * execute Folder
	 */
	protected void executeFolder(IFolder folder, IAction action) {
		boolean registryCheckinSuccessful = false;
		CheckingToRegistryDialog checkingToRegistryDialog = new CheckingToRegistryDialog(
															Display.getCurrent().getActiveShell(), 
															folder);
		if (checkingToRegistryDialog.open() == Window.OK) {
			String url = checkingToRegistryDialog.getServerUrl();
			String path = checkingToRegistryDialog.getPath();
			if(isRegistryUrlValid(url)){
				Credentials credentials = RegistryCredentialData.getInstance().getCredentials(url);
				if(credentials != null){
					if (!(credentials.getUsername() != null && 
						  credentials.getPassword() != null && 
						  MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
													"Credentials", 
													"Check-in as user '" + 
													credentials.getUsername() + "'?"))) {
														credentials = SWTControlUtils.requestCredentials(
																	   Display.getCurrent().getActiveShell(), 
																	   url, 
																	   credentials.getUsername() == null ?
																	   "" : credentials.getUsername());
														if (credentials == null){
															return;
														}
												}
					try {
						RegistryCheckInClientUtils.checkin(url, path, folder.getLocation()
						                                                    .toOSString(),
						                                   credentials.getUsername(),
						                                   credentials.getPassword());
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Check-in Info",
						                              "Successfully check-in the changes..");
						registryCheckinSuccessful = true;
					} catch (SynchronizationException e) {
						log.error(e);
					} finally {
						action.setEnabled(!registryCheckinSuccessful);
					}
				}else{
					try {
						credentials =
						              SWTControlUtils.requestCredentials(Display.getCurrent()
						                                                        .getActiveShell(),
						                                                 url, "");
						if (credentials == null) {
							return;
						}
						RegistryCheckInClientUtils.checkin(url, path, folder.getLocation()
						                                                    .toOSString(),
						                                   credentials.getUsername(),
						                                   credentials.getPassword());
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						                              "Check-in Info",
						                              "Successfully check-in the changes..");
						registryCheckinSuccessful = true;
					} catch (SynchronizationException e) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(),
						                        "Check-in Info", "Failed to check-in the changes..");
						log.error(e);
					} finally {
						action.setEnabled(!registryCheckinSuccessful);
					}
				}
			}else{
				MessageDialog.openError(Display.getCurrent().getActiveShell(), 
						"Check-in Info", "Failed to check-in the changes. Selected Registy instance may not be " +
								"available.");
			}
 
			
		}
		
	}

	/**
	 * execute Resource
	 */
	protected void executeResource(IResource resource, IAction action) {

	}

	/**
	 * selected File
	 */
	protected void selectedFile(IFile file, IAction action) {

	}

    /**
     * selected Folder
     */
	protected void selectedFolder(IFolder folder, IAction action) {

	}

	/**
	 * selected Resource
	 */
	protected void selectedResource(IResource resource, IAction action) {
		if (RegistryCheckInClientUtils.isRegistryResource(resource.getLocation().toOSString()) || 
				RegistryCheckInClientUtils.getResourceState(
					resource.getLocation().toOSString()) == RegistryCheckInClientUtils.RESOURCE_STATE_NEW){
			action.setEnabled(false);
		}
	}

}
