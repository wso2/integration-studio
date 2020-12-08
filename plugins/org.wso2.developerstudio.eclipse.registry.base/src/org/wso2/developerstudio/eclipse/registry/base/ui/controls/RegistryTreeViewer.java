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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;

public class RegistryTreeViewer extends TreeViewer implements Observer {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private ExceptionHandler exceptionHandler;
	private RegistryURLNode registryUrlNode;
	private List<RegistryNode> selectedRegistry;
	private List<RegistryResourceNode> selectedRegistryPathCollections;
	private List<RegistryResourceNode> selectedRegistryPathResources;
	private int selectionState = SELECTED_NONE;
	public static final int SELECTED_NONE = 1;
	public static final int SELECTED_REGISTRY = 2;
	public static final int SELECTED_REGISTRY_PATH = 4;
	public static final int SELECTED_REGISTRY_RESOURCE = 8;
	private List<IRegistryTreeItemSelectionListener> registryTreeSelectionListeners;
	private boolean showUserCategory=true;
	private boolean showRepositoryCategory=true;

	/**
	 * RegistryTreeViewer constructor
	 * extends org.eclipse.jface.viewers.TreeViewer class
	 * implements java.util.Observer
	 * @param parent
	 * @param style
	 * @param exceptionHandler
	 */
	public RegistryTreeViewer(Composite parent, int style,ExceptionHandler exceptionHandler, boolean showUserCategory, boolean showRepositoryCategory) {
		super(parent, style);
		this.setExceptionHandler(exceptionHandler);
		setShowRepositoryCategory(showRepositoryCategory);
		setShowUserCategory(showUserCategory);
		setupProviders();
		setupListeners();
		setupInput();
		
	}

	public RegistryTreeViewer(Composite parent, int style,ExceptionHandler exceptionHandler) {
		this(parent, style, exceptionHandler, true, true);
	}
	
//	@Override
//	public boolean isExpandable(Object element) {
//	    // TODO Auto-generated method stub
//	    return true;
//	}
	
	/**
	 * set up input for the tree view
	 */
	private void setupInput() {
		setInput(getRegistryUrlNode());
		getRegistryUrlNode().addObserver(this);
	}

	/**
	 * set up listeners for tree viewer actions
	 */
	private void setupListeners() {
		addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object obj = event.getSelection();
				if (obj instanceof TreeSelection) {
					TreePath[] paths = ((TreeSelection) obj).getPaths();
					int state = 0;
					getSelectedRegistry().clear();
					getSelectedRegistryPathResources().clear();
					getSelectedRegistryPathCollections().clear();
					for (TreePath treePath : paths) {
						Object object = treePath.getLastSegment();
						if (object instanceof RegistryNode) {
							addSelectedRegistry((RegistryNode) object);
							state = state | SELECTED_REGISTRY;
						} else if (object instanceof RegistryResourceNode) {
							RegistryResourceNode rrpd = (RegistryResourceNode) object;
							RegistryResourceType resourceType = rrpd.getResourceType();
							if (resourceType == RegistryResourceType.RESOURCE) {
								addSelectedRegistryPathResources(rrpd);
								state = state | SELECTED_REGISTRY_RESOURCE;
							} else if (resourceType == RegistryResourceType.COLLECTION) {
								addSelectedRegistryPathCollections(rrpd);
								state = state | SELECTED_REGISTRY_PATH;
							} else if (resourceType == RegistryResourceType.SYMLINK) {
								addSelectedRegistryPathResources(rrpd);
								state = state | SELECTED_REGISTRY_RESOURCE;
							} else if (resourceType == RegistryResourceType.REMOTELINK) {
								addSelectedRegistryPathResources(rrpd);
								state = state | SELECTED_REGISTRY_RESOURCE;
							} else if (resourceType == RegistryResourceType.UNDEFINED) {
								addSelectedRegistryPathCollections(null);
								state = SELECTED_NONE;
							}
						}
					}
					if (getSelectedRegistry().isEmpty()
							&& getSelectedRegistryPathResources().isEmpty()
							&& getSelectedRegistryPathCollections().isEmpty()) {
						state = SELECTED_NONE;
					}
					setSelectionState(state);
					triggerRegistryTreeSelectionListeners();
				}
			}
		});

	}

	/**
	 * get current shell
	 * @return
	 */
	protected Shell getShell() {
		return getTree().getShell();
	}

	/**
	 * set content provider and label provider
	 */
	private void setupProviders() {
		setContentProvider(new RegistryTreeContentProvider(exceptionHandler,getShell(), isShowUserCategory(),isShowRepositoryCategory()));
		setLabelProvider(new RegistryTreeLabelProvider());

	}

	/**
	 * set ExceptionHandler
	 * @param exceptionHandler
	 */
	public void setExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	/**
	 * get ExceptionHandler
	 * @return
	 */
	public ExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}

	/***
	 * add selected registry to viewer
	 * @param selectedRegistry
	 */
	public void addSelectedRegistry(RegistryNode selectedRegistry) {
		getSelectedRegistry().add(selectedRegistry);
	}

	/**
	 *  get selected registry from the tree viewer
	 * @return
	 */
	public List<RegistryNode> getSelectedRegistry() {
		if (selectedRegistry == null){
			selectedRegistry = new ArrayList<RegistryNode>();
		}
		return selectedRegistry;
	}

	/**
	 * add RegistryResourceNode to selected collection node  list
	 * @param selectedRegistryPath
	 */
	public void addSelectedRegistryPathCollections(RegistryResourceNode selectedRegistryPath) {
		getSelectedRegistryPathCollections().add(selectedRegistryPath);
	}

	/**
	 * get Registry resource node  list
	 * @return
	 */
	public List<RegistryResourceNode> getSelectedRegistryPathCollections() {
		if (selectedRegistryPathCollections == null){
			selectedRegistryPathCollections = new ArrayList<RegistryResourceNode>();
		}
		return selectedRegistryPathCollections;
	}

	
	/**
	 * add RegistryResourceNode to selected resource node  list
	 * @param selectedRegistryPath
	 */
	public void addSelectedRegistryPathResources(RegistryResourceNode selectedRegistryPath) {
		getSelectedRegistryPathResources().add(selectedRegistryPath);
	}

	/**
	 * get selected registry resource nodes list
	 * @return
	 */
	public List<RegistryResourceNode> getSelectedRegistryPathResources() {
		if (selectedRegistryPathResources == null){
			selectedRegistryPathResources = new ArrayList<RegistryResourceNode>();
		}
		return selectedRegistryPathResources;
	}

	/**
	 * set selection state
	 * @param selectionState
	 */
	public void setSelectionState(int selectionState) {
		this.selectionState = selectionState;
	}

	/**
	 * get the selection state
	 * @return
	 */
	public int getSelectionState() {
		return selectionState;
	}

	/**
	 * expand the tree
	 * @param regData
	 * @param pathToExpand
	 */
	public void expandTree(RegistryNode regData, String pathToExpand) {
		String txt = pathToExpand;
		String[] s;
		if (txt.equalsIgnoreCase("")){
			s = new String[] {};
		}
		else if (txt.equalsIgnoreCase("/")){
			s = new String[] { "" };
		}
		else{
			s = txt.split("/");
		}
		String path = "";
		RegistryResourceNode r;
		setSelection(new StructuredSelection(regData), true);
		expandToLevel(regData, 1);
		refresh(regData, false);

		setSelection(new StructuredSelection(regData.getRegistryContainer()),	true);
		expandToLevel(regData.getRegistryContainer(), 1);
		refresh(regData.getRegistryContainer(), false);

		r = regData.getRegistryContainer().getRegistryContent().get(0);
		String rootPath = r.getRegistryResourcePath();
		String[] k;
		if (rootPath.equalsIgnoreCase("")){
			k = new String[] {};
		}
		else if (rootPath.equalsIgnoreCase("/")){
			k = new String[] { "" };
		}
		else{
			k = rootPath.split("/");
		}
		boolean rootMatched = false;
		String restOfTheText = "";
		for (int i = 0; i < s.length; i++) {
			String p = s[i];
			if (path.endsWith("/")){
				path = path + p;
			}
			else{
				path = path + "/" + p;
			}
			try {
				if (!rootMatched) {
					if (rootPath.startsWith(path)) {
						setSelection(new StructuredSelection(r), true);
						expandToLevel(r, 1);
						refresh(r, false);
						restOfTheText = rootPath.substring(path.length());
						if (i >= (k.length - 1)){
							rootMatched = true;
						}
					}
					continue;
				}
				List<RegistryResourceNode> b = r.getResourceNodeList();
				r = null;
				for (RegistryResourceNode rp : b) {
					if (i == (s.length - 1)) {
						if (rp.getRegistryResourcePath().startsWith(path)) {
							expandToLevel(rp, 1);
							r = rp;
							break;
						}
					} else {
						if (rp.getRegistryResourcePath().equals(path)) {
							expandToLevel(rp, 1);
							r = rp;
							break;
						}
					}
				}
				if (r == null) {
					break;
				} else {
					setSelection(new StructuredSelection(r), true);
					refresh(r, false);
					restOfTheText = r.getRegistryResourcePath().substring(path.length());
				}

			} catch (Exception e) {
				log.error(e);
			}
		}
	}

	/**
	 * add registry 
	 * @param registryUrl
	 * @param path
	 * @param username
	 * @param password
	 * @param persist
	 * @return
	 */
	public RegistryNode addRegistry(URL registryUrl, 
									String path,
									String username, 
									String password, 
									boolean persist) {
		RegistryURLInfo registryURLInfo = new RegistryURLInfo();
		registryURLInfo.setPersist(persist);
		registryURLInfo.setUrl(registryUrl);
		registryURLInfo.setUsername(username);
		registryURLInfo.setPath(path);
		if (username == null) {
			username = "null";
		}
	 
		RegistryUrlStore.getInstance().addRegistryUrl(registryUrl, username, path,false);
		return getRegistryUrlNode().addRegistry(registryURLInfo, password);
	}

	/**
	 * remove registry
	 * @param registryNode
	 */
	public void removeRegistry(RegistryNode registryNode) {
		getRegistryUrlNode().removeRegistry(registryNode);
	}

	/**
	 *set registryUrlNode 
	 * @param registryUrlNode
	 */
	public void setRegistryUrlNode(RegistryURLNode registryUrlNode) {
		this.registryUrlNode = registryUrlNode;
	}

	/**
	 * get registryUrlNode
	 * @return
	 */
	public RegistryURLNode getRegistryUrlNode() {
		if (registryUrlNode == null){
			registryUrlNode = new RegistryURLNode();
		}
		return registryUrlNode;
	}

	/**
	 * update observers
	 */
	public void update(Observable arg0, Object arg1) {
		if(!isBusy()){
			refresh(getRegistryUrlNode().isRefreshExisting());
		}

	}

	/**
	 * get registry tree listeners
	 * @return
	 */
	public List<IRegistryTreeItemSelectionListener> getRegistryTreeSelectionListeners() {
		if (registryTreeSelectionListeners == null){
			registryTreeSelectionListeners = new ArrayList<IRegistryTreeItemSelectionListener>();
		}
		return registryTreeSelectionListeners;
	}

	/**
	 * add registryTreeItem selection listener
	 * @param registryTreeItemSelectionListener
	 */
	public void addRegistryTreeSelectionListener(
							IRegistryTreeItemSelectionListener registryTreeItemSelectionListener) {
		if (registryTreeItemSelectionListener != null){
			getRegistryTreeSelectionListeners().add(registryTreeItemSelectionListener);
		}
	}

	/**
	 * remove registryTreeItem selection listener
	 * @param registryTreeItemSelectionListener
	 */
	public void removeRegistryTreeSelectionListener(
							IRegistryTreeItemSelectionListener registryTreeItemSelectionListener) {
		if (registryTreeItemSelectionListener != null){
			getRegistryTreeSelectionListeners().remove(registryTreeItemSelectionListener);
		}
	}

	/**
	 * 
	 * interface IRegistryTreeItemSelectionListener
	 *
	 */
	public static interface IRegistryTreeItemSelectionListener {
		public void registrySelected(RegistryNode[] registryNode);

		public void registryPathSelected(RegistryResourceNode[] registryResourceNode);

		public void registryResourceSelected(RegistryResourceNode[] registryResourceNode);

		public void selectionLost();
	}

	/**
	 * trigger RegistryTreeSelectionListeners
	 */
	private void triggerRegistryTreeSelectionListeners() {
		for (IRegistryTreeItemSelectionListener r : getRegistryTreeSelectionListeners()) {
			try {
				if ((getSelectionState() & SELECTED_NONE) == SELECTED_NONE){
					r.selectionLost();
				}
				else if ((getSelectionState() & SELECTED_REGISTRY) == SELECTED_REGISTRY){
					r.registrySelected(getSelectedRegistry().toArray(new RegistryNode[] {}));
				}
				else if ((getSelectionState() & SELECTED_REGISTRY_PATH) == SELECTED_REGISTRY_PATH){
					r.registryPathSelected(getSelectedRegistryPathCollections()
														.toArray(new RegistryResourceNode[] {}));
				}
				else if((getSelectionState() & SELECTED_REGISTRY_RESOURCE) == SELECTED_REGISTRY_RESOURCE){
					r.registryResourceSelected(getSelectedRegistryPathCollections()
															.toArray(new RegistryResourceNode[] {}));
				}
			} catch (Exception e) {
				log.error(e);
			}
		}
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
