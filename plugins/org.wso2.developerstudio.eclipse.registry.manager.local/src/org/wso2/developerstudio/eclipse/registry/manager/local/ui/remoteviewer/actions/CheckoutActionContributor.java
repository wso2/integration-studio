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

package org.wso2.developerstudio.eclipse.registry.manager.local.ui.remoteviewer.actions;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.wso2.carbon.registry.synchronization.SynchronizationException;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryAction;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public class CheckoutActionContributor implements IRegistryAction {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private Action checkoutAction;
	private RegistryResourceNode selectedObj;
	private Shell shell;

	/**
	 * CheckoutActionContributor constructor
	 */
	public CheckoutActionContributor() {
	}

	/**
	 * create checkout action for the selected object
	 */
	public Action createAction(Shell shell, Object selected) {
		setShell(shell);
		setSelectedObj((RegistryResourceNode) selected);
		if (checkoutAction == null) {
			checkoutAction = new Action("Checkout...") {
				public void run() {
					try {
						checkoutRegistryPath();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			checkoutAction.setImageDescriptor(ImageUtils
											 .getImageDescriptor(ImageUtils.ACTION_CHECK_OUT_MENU));
		}
		return checkoutAction;
	}

	/**
	 * check whether the selected object is set enabled
	 */
	public boolean isEnabled(Object selected) {
		if (selected instanceof RegistryResourceNode) {
			RegistryResourceNode r = (RegistryResourceNode) selected;
			return (r.getResourceType()==RegistryResourceType.COLLECTION || 
					r.getResourceType() == RegistryResourceType.RESOURCE) && !r.isError();
		}
		return false;
	}

	/**
	 * isVisible check for the selected object
	 */
	public boolean isVisible(Object selected) {
		if (selected instanceof RegistryResourceNode) {
			RegistryResourceNode r = (RegistryResourceNode) selected;
			return (r.getResourceType()==RegistryResourceType.COLLECTION || 
					r.getResourceType() == RegistryResourceType.RESOURCE) && !r.isError();
		}
		return false;
	}

	/**
	 * check out RegistryPath
	 * @throws Exception 
	 */
	private void checkoutRegistryPath() throws Exception {
		String checkoutPath = "";
		RegistryResourceNode r = (RegistryResourceNode) getSelectedObj();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		ContainerSelectionDialog dialog =
		                                  new ContainerSelectionDialog(getShell(), root, false,
		                                                               "Select location to checkout");
		while (true) {
			if (dialog.open() == ContainerSelectionDialog.OK) {
				Object[] result = dialog.getResult();
				if (result.length == 1) {
					IPath path = ((Path) result[0]);
					if (root.exists(path)) {
						String chkoutFolder;
						if (r.getResourceType() == RegistryResourceType.RESOURCE) {
							chkoutFolder = r.getRegistryResourceNodeParent().getLastSegmentInPath();
							checkoutPath =
							               r.getRegistryResourceNodeParent()
							                .getRegistryResourcePath();
						} else if (r.getResourceType() == RegistryResourceType.UNDEFINED) {
							throw new Exception("Resource not Defined");
						} else {
							chkoutFolder = r.getLastSegmentInPath();
							checkoutPath = r.getRegistryResourcePath();
						}
						if (chkoutFolder.equals("/")) {
							chkoutFolder = "ROOT";
						}
						path = path.append(chkoutFolder);
						IProject project = root.getProject(path.segment(0));
						path = root.getLocation().append(path);
						try {
							if (RegistryCheckInClientUtils.isCheckoutPathValid(path.toOSString())) {
								(new File(path.toOSString())).mkdirs();
								try {
									RegistryCheckInClientUtils.checkout(r.getConnectionInfo()
									                                     .getUsername(),
									                                    r.getConnectionInfo()
									                                     .getPassword(),
									                                    path.toOSString(),
									                                    r.getConnectionInfo()
									                                     .getUrl().toString(),
									                                    checkoutPath);
								} catch (SynchronizationException e1) {
									e1.printStackTrace();
								}
								try {
									project.refreshLocal(IResource.DEPTH_INFINITE,
									                     new NullProgressMonitor());
								} catch (CoreException e) {
									log.error(e);
								}
							}
						} catch (Exception e1) {
							MessageDialog.openError(getShell(), "Error in checkout path",
							                        e1.getMessage());
							continue;
						}

					}
				}
			}
			break;
		}
	}

	/**
	 * set selected registry resource node
	 * @param selectedObj
	 */
	public void setSelectedObj(RegistryResourceNode selectedObj) {
		this.selectedObj = selectedObj;
	}

	/**
	 * get selected registry resource node
	 * @return
	 */
	public RegistryResourceNode getSelectedObj() {
		return selectedObj;
	}

	/**
	 * set shell
	 * @param shell
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/**
	 * get shell
	 * @return
	 */
	public Shell getShell() {
		return shell;
	}

}
