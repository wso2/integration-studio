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

package org.wso2.developerstudio.eclipse.registry.base.ui.dialog;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.wso2.developerstudio.eclipse.registry.base.heartbeat.RegistryHeartBeatTester;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRoleContainer;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.RegistryTreeViewer;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.RegistryTreeViewer.IRegistryTreeItemSelectionListener;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;

public class RegistryTreeBrowserDialog extends Dialog {
	private RegistryTreeViewer treeViewer;
	private RegistryNode selectedRegistryNode;
	private RegistryResourceNode selectedRegistryResourceNode;
	private RegistryResourceNode selectedRegistryResourceNodeaResource;
	private RegistryHeartBeatTester registryHeartBeatTester;

	private int requiredSelection;
	private String defaultSelectPath;
	private String defaultSelectRegistry;

	private String title="Registry Tree Browser";
	private String message;
	
	public static final int SELECT_NONE = RegistryTreeViewer.SELECTED_NONE;
	public static final int SELECT_REGISTRY = RegistryTreeViewer.SELECTED_REGISTRY;
	public static final int SELECT_REGISTRY_PATH = RegistryTreeViewer.SELECTED_REGISTRY_PATH;
	public static final int SELECT_REGISTRY_RESOURCE = RegistryTreeViewer.SELECTED_REGISTRY_RESOURCE;
	
	private URL serverURL;
	private String uname;
	private String pwd;
	private int dialogSelection = 0;
	private Button removeRegistry;
	private int defaultPathId = 0;
	
	/**
	 * RegistryTreeBrowserDialog dialog
	 * this is the seperate dialog for browse registry
	 * @param parentShell
	 * @param requiredSelection
	 */
	public RegistryTreeBrowserDialog(Shell parentShell, int requiredSelection) {
		super(parentShell);
		setRequiredSelection(requiredSelection);
	}
	
	public RegistryTreeBrowserDialog(Shell parentShell, int requiredSelection,int defaultPathId ) {
		super(parentShell);
		setRequiredSelection(requiredSelection);
		setDefaultPathId(defaultPathId);
	}
	
	private void initHeartBeatTester(){
		registryHeartBeatTester = new RegistryHeartBeatTester(treeViewer.getRegistryUrlNode());
		new Thread(registryHeartBeatTester).start();
	}

	public int getDialogSelection() {
		return dialogSelection;
	}

	public void setDialogSelection(int dialogSelection) {
		this.dialogSelection = dialogSelection;
	}
	
	/**
	 * create dialog area for registry tree browse dialog
	 * creating tree
	 */
	protected Control createDialogArea(final Composite parent) {
		final Composite container = new Composite(parent,SWT.None);
		parent.getShell().setText(getTitle());
		GridLayout layout = new GridLayout();
		layout.numColumns=1;
		layout.marginWidth=10;
		layout.verticalSpacing=5;
		container.setLayout(layout);
		
		if (getMessage()!=null) {
			new Label(container,SWT.None).setText(getMessage());
		}
		
		Composite toolBarBomposite = new Composite(container,SWT.None);
		GridData gd = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		toolBarBomposite.setLayoutData(gd);
		RowLayout flayout = new RowLayout(SWT.HORIZONTAL);
		toolBarBomposite.setLayout(flayout);
		
		Button addRegistry = new Button(toolBarBomposite, SWT.PUSH);
		addRegistry.setImage(ImageUtils.getImageDescriptor("addRegistry.png").createImage());
		addRegistry.setToolTipText("Add New Registry Connection");
		
		removeRegistry = new Button(toolBarBomposite, SWT.PUSH);
		removeRegistry.setImage(ImageUtils.getImageDescriptor("deleteRegistry.png").createImage());
		removeRegistry.setToolTipText("Remove Registry Connection");
		
		Button refreshRegistry = new Button(toolBarBomposite, SWT.PUSH);
		refreshRegistry.setImage(ImageUtils.getImageDescriptor("refresh.png").createImage());
		refreshRegistry.setToolTipText("Refresh Registry Connection");
		

		treeViewer = new RegistryTreeViewer(container, 
											SWT.H_SCROLL | 
											SWT.V_SCROLL | 
											SWT.BORDER, 
											new ExceptionHandler(),false,true);
		Tree tree = treeViewer.getTree();
		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = 450;
		data.heightHint = 250;
		tree.setLayoutData(data);
		treeViewer.addRegistryTreeSelectionListener(new IRegistryTreeItemSelectionListener() {
			public void registryPathSelected(RegistryResourceNode[] registryResourcePathData) {
				updateSelection();
			}

			public void registrySelected(RegistryNode[] registryData) {
				updateSelection();
			}

			public void selectionLost() {
				updateSelection();
			}

			public void registryResourceSelected(
					RegistryResourceNode[] registryResourcePathData) {
				//selectedRegistryResourceNode.isResource();
				updateSelection();
			}

		});
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			
			public void doubleClick(DoubleClickEvent event) {
				Object obj = event.getSelection();
				if (obj instanceof TreeSelection) {
					Object object = ((TreeSelection) obj).getFirstElement();
					if (object instanceof RegistryResourceNode) {
						setSelectedRegistryResourceNodeResource((RegistryResourceNode)object);
					}
					setDialogSelection(Window.OK);
					
				}
				
			}
		});
		
		addRegistry.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				
				CreateRegistryDilaog dialog = new CreateRegistryDilaog(container.getShell(),getDefaultPathId());
				dialog.setBlockOnOpen(true);

				dialog.create();
				dialog.getShell().setSize(350, 174);
				int status = dialog.open();
				
				if (status == dialog.OK) {
					URI pathUri = null;
					try {
						pathUri = new URI(dialog.getServerUrl());
						serverURL = pathUri.toURL();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					} catch (MalformedURLException e) {
						e.printStackTrace();			
					}

					uname = "admin";
					pwd = "admin";
					String url = dialog.getServerUrl();
					String path = dialog.getPath();
					try {
						serverURL = new URL(dialog.getServerUrl());
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
					try{
					addRegistry(serverURL, path, null, null);
					}catch(RuntimeException e){
						e.printStackTrace();
					}
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		removeRegistry.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				List<RegistryNode> selectedRegistry = treeViewer.getSelectedRegistry();
				for (RegistryNode registryNode : selectedRegistry) {
					treeViewer.removeRegistry(registryNode);	
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
		refreshRegistry.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				ISelection selectedObj = treeViewer.getSelection();
				Object firstElement = ((TreeSelection)selectedObj).getFirstElement();
				if (firstElement instanceof RegistryNode) {
					((RegistryNode) firstElement).setIterativeRefresh(true);
				} else if (firstElement instanceof RegistryContentContainer) {
					((RegistryContentContainer) firstElement).setIterativeRefresh(true);
				} else if (firstElement instanceof RegistryResourceNode) {
					((RegistryResourceNode) firstElement).setIterativeRefresh(true);
				} else if (firstElement instanceof RegistryUserContainer) {
					((RegistryUserContainer) firstElement).setIterativeRefresh(true);
				} else if (firstElement instanceof RegistryUserRoleContainer) {
					((RegistryUserRoleContainer) firstElement).setIterativeRefresh(true);
				}
				treeViewer.getRegistryUrlNode().dataChanged(false);
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
		updateSelection();
		initHeartBeatTester();
		return super.createDialogArea(parent);
	}

	/**
	 * update selection of the tree viewer
	 */
	private void updateSelection() {
		Button button = getButton(IDialogConstants.OK_ID);
		if (button != null) {
			if ((getRequiredSelection() & treeViewer.getSelectionState()) == 
																	treeViewer.getSelectionState()){
				button.setEnabled(true);
			}
			else{
				button.setEnabled(false);
			}
		}
		setSelectedRegistryNode(null);
		setSelectedRegistryResourceNode(null);
		setSelectedRegistryResourceNodeResource(null);

		if (!treeViewer.getSelectedRegistry().isEmpty()){
			setSelectedRegistryNode(treeViewer.getSelectedRegistry().get(0));
		}
		if (!treeViewer.getSelectedRegistryPathCollections().isEmpty()){
			setSelectedRegistryResourceNode(treeViewer.
													   getSelectedRegistryPathCollections().get(0));
		}
		if (!treeViewer.getSelectedRegistryPathResources().isEmpty()){
			setSelectedRegistryResourceNodeResource(treeViewer.
														 getSelectedRegistryPathResources().get(0));
		}
		
		removeRegistry.setEnabled(treeViewer.getSelectedRegistry().size()>0);
	}

	/**
	 * add registry to tree viewer
	 * @param registryUrl
	 * @param path
	 * @param username
	 * @param password
	 * @return
	 */
	public RegistryNode addRegistry(URL registryUrl, 
									String path,
									String username, 
									String password) {
		if (treeViewer != null) {
			return treeViewer.addRegistry(registryUrl,
										  path, 
										  username,
										  password, 
										  false);
		}
		return null;
	}

	/**
	 * remove registry from tree viewer
	 * @param registryNode
	 */
	public void removeRegistry(RegistryNode registryNode) {
		if (treeViewer != null) {
			treeViewer.removeRegistry(registryNode);
		}
	}

	/**
	 * set selected RegistryresourceNode 
	 * this can be a collection or resource
	 * @param selectedRegistryResourceNode
	 */
	public void setSelectedRegistryResourceNode(RegistryResourceNode selectedRegistryResourceNode) {
		this.selectedRegistryResourceNode = selectedRegistryResourceNode;
	}

	/**
	 * get selected RegistryresourceNode 
	 * this can be a collection or resource
	 * @return
	 */
	public RegistryResourceNode getSelectedRegistryResourceNode() {
		return selectedRegistryResourceNode;
	}

	/**
	 * get selected RegistryNode (different registry instances) 
	 * @param selectedRegistryNode
	 */
	public void setSelectedRegistryNode(RegistryNode selectedRegistryNode) {
		this.selectedRegistryNode = selectedRegistryNode;
	}

	/**
	 * set selected RegistryNode (different registry instances) 
	 * @return
	 */
	public RegistryNode getSelectedRegistryNode() {
		return selectedRegistryNode;
	}

	/**
	 * set RequiredSelection
	 * @param requiredSelection
	 */
	public void setRequiredSelection(int requiredSelection) {
		this.requiredSelection = requiredSelection;
	}

	/**
	 * get RequiredSelection
	 * @return
	 */
	public int getRequiredSelection() {
		return requiredSelection;
	}

	/**
	 * create buttons for registry tree dialog
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		updateSelection();
	}

	/**
	 * add RegistryNode to tree viewer
	 * @param registryURLInfo
	 * @param password
	 */
	public void addRegistryNode(RegistryURLInfo registryURLInfo, String password) {
		treeViewer.getRegistryUrlNode().addRegistry(registryURLInfo, password);
	}

	/**
	 * set DefaultSelectRegistry in the treeviewer
	 * @param defaultSelectRegistry
	 */
	public void setDefaultSelectRegistry(String defaultSelectRegistry) {
		this.defaultSelectRegistry = defaultSelectRegistry;
	}

	/**
	 * get DefaultSelectRegistry for tree viewer
	 * @return
	 */
	public String getDefaultSelectRegistry() {
		return defaultSelectRegistry;
	}

	/**
	 * set Default resource Path for the tree viewer
	 * @param defaultSelectPath
	 */
	public void setDefaultSelectPath(String defaultSelectPath) {
		this.defaultSelectPath = defaultSelectPath;
	}

	/**
	 * get Default resource Path for the tree viewer
	 * @return
	 */
	public String getDefaultSelectPath() {
		return defaultSelectPath;
	}

	/**
	 * select registry path 
	 * @param registryNode
	 * @param path
	 */
	public void selectRegistryPath(RegistryNode registryNode, String path) {
		treeViewer.expandTree(registryNode, path);
	}

	/**
	 * set SelectedRegistryResourceNode Resource
	 * @param selectedRegistryResourceNodeResource
	 */
	public void setSelectedRegistryResourceNodeResource(
										RegistryResourceNode selectedRegistryResourceNodeResource) {
		this.selectedRegistryResourceNodeaResource = selectedRegistryResourceNodeResource;
	}

	/**
	 * get SelectedRegistryResourceNode Resource
	 * @return
	 */
	public RegistryResourceNode getSelectedRegistryResourceNodeResource() {
		return selectedRegistryResourceNodeaResource;
	}

	public void setTitle(String title) {
	    this.title = title;
    }

	public String getTitle() {
	    return title;
    }

	public void setMessage(String message) {
	    this.message = message;
    }

	public String getMessage() {
	    return message;
    }

	public void setDefaultPathId(int defaultPathId) {
		this.defaultPathId = defaultPathId;
	}

	public int getDefaultPathId() {
		return defaultPathId;
	}
	
	public RegistryTreeViewer getViewer(){
		return treeViewer;
	}
}
