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

package org.wso2.developerstudio.eclipse.registry.base.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserManagerContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRole;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRoleContainer;

public class RegistryTreeContentProvider implements ITreeContentProvider {

	private ExceptionHandler exceptionHandler;
	private Shell shell;

	private boolean showUserCategory = true;
	private boolean showRepositoryCategory = true;

	public RegistryTreeContentProvider(ExceptionHandler exceptionHandler,
			Shell shell, boolean showUserCategory,
			boolean showRepositoryCategory) {
		this.exceptionHandler = exceptionHandler;
		this.setShell(shell);
		setShowRepositoryCategory(showRepositoryCategory);
		setShowUserCategory(showUserCategory);
	}

	public RegistryTreeContentProvider(ExceptionHandler exceptionHandler,
			Shell shell) {
		this(exceptionHandler, shell, true, true);
	}

	public Object[] getChildren(Object parentElement) {
		List<RegistryNode> newList = new ArrayList<RegistryNode>();
		List<RegistryResourceNode> newResourcePathList = new ArrayList<RegistryResourceNode>();
		if (parentElement instanceof RegistryURLNode) {
			RegistryURLNode regUrlData = (RegistryURLNode) parentElement;
			List<RegistryNode> list = (ArrayList<RegistryNode>) regUrlData
					.getUrlInfoList();
//			for (int i = 0; i < list.size(); i++) {
//				newList.add(list.get(i));
//			}
			return (list!=null)?list.toArray():newList.toArray();

		} else if (parentElement instanceof RegistryNode) {
			RegistryNode regData = (RegistryNode) parentElement;
			if (regData.isEnabled()) {
				List<Object> children=new ArrayList<Object>();
				if (isShowUserCategory()){
					children.add(regData.getUserManagerContent());
				}
				if (isShowRepositoryCategory()){
					children.add(regData.getRegistryContainer());
				}
				return children.toArray();
			}
			return new Object[] {};
		} else if (parentElement instanceof RegistryContentContainer) {
			RegistryContentContainer regContent = (RegistryContentContainer) parentElement;
			return regContent.getRegistryContent().toArray();
		} else if (parentElement instanceof RegistryUserManagerContainer) {
			RegistryUserManagerContainer regContent = (RegistryUserManagerContainer) parentElement;
			return new Object[] { regContent.getUserRoleContent(),
					regContent.getUserContent() };
		} else if (parentElement instanceof RegistryUserContainer) {
			RegistryUserContainer regContent = (RegistryUserContainer) parentElement;
			return regContent.getUsers().toArray();
		} else if (parentElement instanceof RegistryUserRoleContainer) {
			RegistryUserRoleContainer regContent = (RegistryUserRoleContainer) parentElement;
			return regContent.getUserRoles().toArray();
		} else if (parentElement instanceof RegistryUserRole) {
			RegistryUserRole regContent = (RegistryUserRole) parentElement;
			return regContent.getUsers().toArray();
		} else if (parentElement instanceof RegistryResourceNode
				&& showRepositoryCategory) {
			RegistryResourceNode regResourcePathData = (RegistryResourceNode) parentElement;
			ArrayList<RegistryResourceNode> resourcePathList = null;
			try {
				if (regResourcePathData.isAllowExapand())
					resourcePathList = regResourcePathData
							.getResourceNodeList();
			} catch (Exception e) {
				regResourcePathData.setError(true);
				MessageDialog.openError(getShell(),
						"Connection Establish error",
						"Cannot establish the connection with given URL");
				// exceptionHandler.showMessage(getShell(),
				// "Cannot establish the connection with given URL");
			}
//			if (resourcePathList != null) {
//				for (int i = 0; i < resourcePathList.size(); i++) {
//					newResourcePathList.add(resourcePathList.get(i));
//				}
//			}
			return (resourcePathList!=null)?resourcePathList.toArray():newResourcePathList.toArray();
		} else {
			return null;
		}

	}

	public Object getParent(Object arg0) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof RegistryResourceNode) {
			RegistryResourceNode ele = (RegistryResourceNode) element;
			if (!(ele.isAllowExapand()) || ele.getResourceType()==RegistryResourceType.UNDEFINED) {
				return false;
			} else {
				try {
					return ele.getResourceNodeList().size() > 0 && ele.getResourceType()==RegistryResourceType.COLLECTION;
				} catch (Exception e) {
					ele.setError(true);
					return false;
				}
			}
		}else if (element instanceof RegistryNode) {
			return ((RegistryNode) element).isEnabled();
		} else if (element instanceof RegistryContentContainer) {
			return ((RegistryContentContainer) element).getRegistryContent()
					.size() > 0;
		} else if (element instanceof RegistryUserManagerContainer) {
			return true;
		} else if (element instanceof RegistryUserContainer) {
			return ((RegistryUserContainer) element).getUsers().size() > 0;
		} else if (element instanceof RegistryUserRoleContainer) {
			return ((RegistryUserRoleContainer) element).getUserRoles().size() > 0;
		} else if (element instanceof RegistryUserRole) {
			return ((RegistryUserRole) element).getUsers().size() > 0;
		} else if (element instanceof RegistryURLNode) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * get Elements of the selected tree item implementation of method in
	 * interface ITreeContentProvider
	 */
	public Object[] getElements(Object arg0) {
		return getChildren(arg0);
	}

	/**
	 *
	 */
	public void dispose() {

	}

	/**
	 * things to do when input has changed in the tree
	 */
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}

	/**
	 * set the shell
	 *
	 * @param shell
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/**
	 * get the current shell
	 *
	 * @return
	 */
	public Shell getShell() {
		return shell;
	}

	public void setShowRepositoryCategory(boolean showRepositoryCategory) {
		this.showRepositoryCategory = showRepositoryCategory;
	}

	public boolean isShowRepositoryCategory() {
		return showRepositoryCategory;
	}

	public void setShowUserCategory(boolean showUserCategory) {
		this.showUserCategory = showUserCategory;
	}

	public boolean isShowUserCategory() {
		return showUserCategory;
	}
}
