/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.ui.wizard;

import java.util.HashMap;
import java.util.Map;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.model.NodeData;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class DistributionProjectExportWizardPage extends WizardPage {
	private MavenProject mavenProject;
	private Map<String,Dependency> dependencyList;
	private Map<String,DependencyData> projectList;
	private Map<String,Dependency> missingDependencyList;
	private Map<String,String> serverRoleList = new HashMap<String, String>();
	private Tree trDependencies;
	private TreeEditor editor;
	private Map<String,TreeItem>  nodesWithSubNodes = new HashMap<String,TreeItem>();
	private boolean pageDirty = false;
	private boolean controlCreated = false;
	// need to get the server roles via an extension point without hard-coding
	private final String[] serverRoles = new String[] { "GovernanceRegistry",
			"BusinessProcessServer", "GadgetServer",
			"EnterpriseServiceBus", "MashupServer",
			"ApplicationServer", "DataServicesServer",
			"BusinessRulesServer", "IdentityServer",
			"BusinessActivityMonitor" };
	
	public Map<String, Dependency> getDependencyList() {
		return dependencyList;
	}

	public Map<String, DependencyData> getProjectList() {
		return projectList;
	}

	public Map<String, Dependency> getMissingDependencyList() {
		return missingDependencyList;
	}
	
	public void setDependencyList(Map<String, Dependency> dependencyList) {
		this.dependencyList = dependencyList;
	}

	public void setServerRoleList(Map<String,String> serverRoleList) {
		this.serverRoleList = serverRoleList;
	}

	public Map<String,String> getServerRoleList() {
		return serverRoleList;
	}

	public void setProjectList(Map<String, DependencyData> projectList) {
		this.projectList = projectList;
	}

	public void setMissingDependencyList(Map<String, Dependency> missingDependencyList) {
		this.missingDependencyList = missingDependencyList;
	}
	
	
	/**
	 * Create the wizard.
	 */
	public DistributionProjectExportWizardPage(MavenProject project) {
		super("WSO2 Platform Distribution");
		this.mavenProject = project;
		setTitle("WSO2 Platform Distribution");
		setDescription("Create an deployable CAR file");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(3, false));
		
		Label lblstaticText1 = new Label(container, SWT.NONE);
		lblstaticText1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblstaticText1.setText("Artifacts to include in the CAR");
		new Label(container, SWT.NONE);
		
		trDependencies = new Tree(container, SWT.CHECK|SWT.V_SCROLL|SWT.BORDER);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, true, true, 3, 1);
		gridData.heightHint= 300;
		trDependencies.setLayoutData(gridData);
		trDependencies.setHeaderVisible(true);
		
		TreeColumn trclmnArtifact = new TreeColumn(trDependencies, SWT.NONE);
		trclmnArtifact.setWidth(400);
		trclmnArtifact.setText("Artifact");
		
		TreeColumn trclmnServerRole = new TreeColumn(trDependencies, SWT.NONE);
		trclmnServerRole.setWidth(200);
		trclmnServerRole.setText("Server Role");
		
		TreeColumn trclmnVersion = new TreeColumn(trDependencies, SWT.NONE);
		trclmnVersion.setWidth(80);
		trclmnVersion.setText("Version");
		
		editor = new TreeEditor(trDependencies);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		
		trDependencies.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				final TreeItem item = (TreeItem) evt.item;
				if (item != null) {
					if (evt.detail == SWT.CHECK) {
						handleTreeItemChecked(item);
					} else {
						handleTreeItemEdit(item);
					}
				}
				validate();
			}

			public void widgetDefaultSelected(SelectionEvent evt) {

			}
		});
		createTreeContent();
		
		GridData gdBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdBtn.widthHint = 100;
		
		Button btnSelectAll = new Button(container,SWT.NONE);
		btnSelectAll.setText("Select All");
		btnSelectAll.setLayoutData(gdBtn);
		btnSelectAll.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event evt) {
				TreeItem[] items = trDependencies.getItems();
				for (TreeItem item : items) {
					if(!item.getChecked() || item.getGrayed()){
						item.setChecked(true);
		                handleTreeItemChecked(item);
					}
                }
			}
		});
		
		Button btnDeselectAll = new Button(container,SWT.NONE);
		btnDeselectAll.setText("Deselect All");
		btnDeselectAll.setLayoutData(gdBtn);
		
		btnDeselectAll.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event evt) {
				TreeItem[] items = trDependencies.getItems();
				for (TreeItem item : items) {
	                item.setChecked(false);
	                handleTreeItemChecked(item);
                }
			}
		});
		
		Label lblEmpty = new Label(container, SWT.NONE);
		GridData gdEmpty = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		lblEmpty.setLayoutData(gdEmpty);
		
		
		setControl(container);
		controlCreated = true;
		validate();
	}
	
	/**
	 * Update state of treeItem
	 * @param item Selected tree item
	 */
	private void updateCheckState(TreeItem item) {
		if (item != null) {
			TreeItem[] subItems = item.getItems();
			int i = 0;
			for (TreeItem subItem : subItems) {
				if (subItem.getChecked())
					i++;
			}
			if (i == item.getItemCount()) {
				item.setGrayed(false);
				item.setChecked(true);
			} else if (i < item.getItemCount() && i > 0) {
				item.setChecked(true);
				item.setGrayed(true);

			} else {
				item.setGrayed(false);
				item.setChecked(false);
			}
			setPageDirtyState(true);
		}
	}
	
	
	private void setPageDirtyState(boolean value) {
		if (controlCreated){
			pageDirty = value;
		}
	}
	
	public boolean isPageDirty(){
		return pageDirty;
	}

	/**
	 * Create content of tree control 
	 */
	protected void createTreeContent() {
		trDependencies.removeAll();
		nodesWithSubNodes.clear();
		for (String project : getProjectList().keySet()) {
			DependencyData dependencyData = getProjectList().get(project);
			Object parent = dependencyData.getParent();
			Object self = dependencyData.getSelf();
			if((parent==null) && (self!=null)){
				if(self instanceof IProject){
					createNode(trDependencies, dependencyData.getDependency(), true);
				}
			} else if(parent!=null){
				if(parent instanceof IProject){
					IProject prj = (IProject) parent;
					TreeItem parentNode=null; 
					if(nodesWithSubNodes.containsKey(prj.getName())){
						parentNode = nodesWithSubNodes.get(prj.getName());
					} else{
						parentNode = createNode(trDependencies, prj);
						nodesWithSubNodes.put(prj.getName(),parentNode);
					}
					if(parentNode!=null){
						createNode(parentNode, dependencyData.getDependency(), true);
					}
					updateCheckState(parentNode);
				}
			}
		}

		if (getMissingDependencyList().size() > 0) {
			for (String dependency : getMissingDependencyList().keySet()) {
				createNode(trDependencies, getMissingDependencyList().get(dependency), false);
			}
		}
		trDependencies.layout();
	}
	
	/**
	 * Create a subItem for a project
	 * @param parent Parent treeItem
	 * @param project Project dependency
	 * @param available available of dependency in workspace  
	 * @return new TreeItem
	 */
	TreeItem createNode(TreeItem parent, final Dependency project, boolean available){
		TreeItem item= new TreeItem(parent, SWT.NONE);
		String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project);
		String serverRole = DistProjectUtils.getDefaultServerRole(getProjectList(),artifactInfo).replaceAll("^capp/","");
		String version = project.getVersion();
		
		item.setText(0,DistProjectUtils.getMavenInfoAsString(artifactInfo));
		
		item.setText(2,version);
		NodeData nodeData = new NodeData(project);
		nodeData.setServerRole(serverRole);
		item.setData(nodeData);
		
		if (getDependencyList().containsKey(artifactInfo)) {
			item.setChecked(true);
			String role = DistProjectUtils.getServerRole(mavenProject,getDependencyList().get(artifactInfo)).replaceAll("^capp/","");
			item.setText(1,role);
		} else{
			item.setText(1,serverRole);
		}
		
		if (getMissingDependencyList().containsKey(artifactInfo)) {
			getMissingDependencyList().remove(artifactInfo);
		}
		item.setImage(0, SWTResourceManager.getImage(this.getClass(),
		"/icons/artifact.png"));
	
		return item;
	}
	
	/**
	 * Create a Item for a dependency
	 * @param parent Parent tree control
	 * @param project Project dependency
	 * @param available available of dependency in workspace  
	 * @return new TreeItem
	 */
	TreeItem createNode(Tree parent, final Dependency project, boolean available){
		TreeItem item= new TreeItem(parent, SWT.NONE);
		final String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project);
		final String serverRole = DistProjectUtils.getDefaultServerRole(getProjectList(),artifactInfo).replaceAll("^capp/","");
		final String version = project.getVersion();
		
		item.setText(0,DistProjectUtils.getMavenInfoAsString(artifactInfo));
		
		item.setText(2,version);
		
		NodeData nodeData = new NodeData(project);
		nodeData.setServerRole(serverRole);

		item.setData(nodeData);
		
		if(available) {
		if (getDependencyList().containsKey(artifactInfo)) {
			item.setChecked(true);
			String role = DistProjectUtils.getServerRole(mavenProject,getDependencyList().get(artifactInfo)).replaceAll("^capp/","");
			item.setText(1,role);
		} else{
			item.setText(1,serverRole);
		}
		if (getMissingDependencyList().containsKey(artifactInfo)) {
			getMissingDependencyList().remove(artifactInfo);
		}
		
	} else {
		if (getDependencyList().containsKey(artifactInfo)) {
			getDependencyList().remove(artifactInfo);
		}
	}
		if (available) {
		item.setImage(0, SWTResourceManager.getImage(this.getClass(),
				"/icons/artifact.png"));
	} else {
		item.setImage(0, SWTResourceManager.getImage(this.getClass(),
				"/icons/cancel_16.png"));
	}
		return item;
		
	}
	
	/**
	 * Create a tree Item for a project
	 * @param parent  Parent tree control
	 * @param project eclipse project
	 * @return  new TreeItem
	 */
	TreeItem createNode(Tree parent, final IProject project){
		TreeItem item= new TreeItem(parent, SWT.NONE);
		MavenProject mavenProject;
		try {
	        mavenProject = DistProjectUtils.getMavenProject(project);
	        item.setText(0,project.getName());
	        item.setText(1,"--");
			item.setText(2,mavenProject.getModel().getVersion());
			NodeData nodeData = new NodeData(project);
			item.setData(project);
			
			nodeData.setHaschildren(true);
			item.setData(nodeData);
			
			item.setImage(0, SWTResourceManager.getImage(this.getClass(),
			"/icons/projects.gif"));
        } catch (Exception e) {
	     return null;
        }	
		return item;
		
	}
	
	/**
	 * handle tree item check event
	 * @param item Selected tree item
	 */
	private void handleTreeItemChecked(TreeItem item){
		boolean select = item.getChecked();
		NodeData nodeData = (NodeData) item.getData();
		if (nodeData.hasChildren()) {
			TreeItem[] subItems = item.getItems();
			if (select) {
				boolean conflict=false;
				for (TreeItem subitem : subItems) {
					if (!subitem.getChecked()) {
						NodeData subNodeData = (NodeData) subitem.getData();
						if(!isNameConflict(subNodeData)){
							subitem.setChecked(true);
							addDependency(subNodeData);
						} else{
							conflict=true;
						}
					}
				}
				if(conflict){
					MessageDialog.openWarning(new Shell(), "Add dependencies","Cannot add multiple dependencies with same identity");
				}
			} else {
				for (TreeItem subitem : subItems) {
					if (subitem.getChecked()) {
						subitem.setChecked(false);
						NodeData subNodeData = (NodeData) subitem.getData();
						removeDependency(subNodeData);
					}
				}
			}
			updateCheckState(item);
		} else {
			TreeItem parentItem = item.getParentItem();
			if (select) {
				if(!isNameConflict(nodeData)){
					addDependency(nodeData);
				} else{
					item.setChecked(false);
					MessageDialog.openWarning(new Shell(), "Add dependencies","Cannot add multiple dependencies with same identity");
				}
			} else {
				removeDependency(nodeData);
			}
			updateCheckState(parentItem);
		}
	}
	
	/**
	 * Check for conflicts
	 * @param nodeData
	 * @return
	 */
	private boolean isNameConflict(NodeData nodeData){
		Dependency dependency = nodeData.getDependency();
		for(Dependency entry  : getDependencyList().values()){
			if(entry.getArtifactId().equalsIgnoreCase(dependency.getArtifactId())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * handle tree item edit events
	 * @param item Selected tree item
	 */
	private void handleTreeItemEdit(final TreeItem item){
		final NodeData nodeData = (NodeData) item.getData();
		Control lastCtrl = editor.getEditor();
        if (lastCtrl != null){
        	lastCtrl.dispose();  
        }
        if(nodeData.hasChildren() || !item.getChecked()) return;
		final String artifactInfo = DistProjectUtils
		.getArtifactInfoAsString(nodeData.getDependency());
		final Combo cmbServerRole = new Combo(trDependencies, SWT.SINGLE);
		cmbServerRole.setItems(serverRoles);
		cmbServerRole.setText(item.getText(1));
		cmbServerRole.setFocus();
		editor.setEditor(cmbServerRole , item,1);
		trDependencies.redraw();
		
		cmbServerRole.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				String role = cmbServerRole.getText();
				item.setText(1, role);
				nodeData.setServerRole(role);
				if (getDependencyList().containsKey(artifactInfo)) {
						serverRoleList.put(artifactInfo, "capp/" + role);
						setPageDirtyState(true);
				}
			}
		});
//temporary commented out, eclipse freezes when handling dispose()
//		cmbServerRole.addFocusListener(new FocusAdapter() {
//			public void focusLost(FocusEvent e) {
//				String role = cmbServerRole.getText();
//				cmbServerRole.dispose();
//				item.setText(1, role);
//				nodeData.setServerRole(role);
//				if (getDependencyList().containsKey(artifactInfo)) {
//					getDependencyList().get(artifactInfo).setScope("capp/" + role);
//				}
//			}
//		});
	}
	
	/**
	 * Remove a project dependencies from the maven model
	 * @param nodeData NodeData of selected treeitem
	 */
	private void removeDependency(NodeData nodeData){
		Dependency project = nodeData.getDependency();
		String artifactInfo = DistProjectUtils
		.getArtifactInfoAsString(project);
		
		if (getDependencyList().containsKey(artifactInfo)) {
			getDependencyList().remove(artifactInfo);
			if(serverRoleList.containsKey(artifactInfo)){
				serverRoleList.remove(artifactInfo);
			}
		}
	}
	
	/**
	 * Add a project dependencies to the maven model
	 * @param nodeData NodeData of selected treeitem
	 */
	private void addDependency(NodeData nodeData){
		Dependency project = nodeData.getDependency();
		String serverRole = nodeData.getServerRole();
		String artifactInfo = DistProjectUtils
		.getArtifactInfoAsString(project);
		
		if (!getDependencyList().containsKey(artifactInfo)) {
			
			Dependency dependency = new Dependency();
			dependency.setArtifactId(project.getArtifactId());
			dependency.setGroupId(project.getGroupId());
			dependency.setVersion(project.getVersion());
			dependency.setType(project.getType());
			if(!serverRoleList.containsKey(artifactInfo)){
				serverRoleList.put(artifactInfo, "capp/" + serverRole);
			}
			getDependencyList().put(artifactInfo, dependency);
		}
	}
	
	private void validate() {
		if (getDependencyList().size() == 0) {
			setErrorMessage("Please tick/check atleast one artifact from the list");
			setPageComplete(false);
			return;
		} 
		setErrorMessage(null);
		setPageComplete(true);
	}

}
