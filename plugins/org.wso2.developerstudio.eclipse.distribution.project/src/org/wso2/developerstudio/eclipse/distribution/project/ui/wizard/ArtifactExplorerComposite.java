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

package org.wso2.developerstudio.eclipse.distribution.project.ui.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.apache.maven.model.Dependency;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.model.DistributionProjectModel;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.distribution.project.validator.ProjectList;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractComposite;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class ArtifactExplorerComposite extends AbstractComposite {
	private DistributionProjectModel model;
	private Tree trDependencies;
	private Map<String,TreeItem>  nodesWithSubNodes = new HashMap<String,TreeItem>();
	private Map<String,DependencyData> projectList = new HashMap<String, DependencyData>();
	private Map<String,DependencyData> selectedProjects = new HashMap<String, DependencyData>();
	
	
	public ArtifactExplorerComposite(Composite parent, int style,
			ProjectDataModel model, ProjectOptionData optionData,
			WizardPage wizardPage) {
		super(parent, style, model, optionData, wizardPage);
		setLayout(new GridLayout(3, false));
		setModel((DistributionProjectModel) getProjectModel());
		trDependencies = new Tree(this, SWT.CHECK|SWT.V_SCROLL|SWT.BORDER);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, true, true, 3, 1);
		gridData.heightHint= 180;
		trDependencies.setLayoutData(gridData);
		trDependencies.setHeaderVisible(true);
		
		TreeColumn trclmnArtifact = new TreeColumn(trDependencies, SWT.NONE);
		trclmnArtifact.setWidth(600);
		trclmnArtifact.setText("Dependencies");
		
		Label lblEmpty = new Label(this, SWT.NONE);
		GridData gdEmpty = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdEmpty.widthHint = 400;
		lblEmpty.setLayoutData(gdEmpty);
		
		GridData gdBtn = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gdBtn.widthHint = 100;
		
		Button btnSelectAll = new Button(this,SWT.NONE);
		btnSelectAll.setText("Select All");
		btnSelectAll.setLayoutData(gdBtn);
		btnSelectAll.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event evt) {
				selectedProjects = (Map<String, DependencyData>)((HashMap)getProjectList()).clone();
				setSelectAll(true);
				updateModel();
			}
		});
		
		Button btnDeselectAll = new Button(this,SWT.NONE);
		btnDeselectAll.setText("Deselect All");
		btnDeselectAll.setLayoutData(gdBtn);
		
		btnDeselectAll.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event evt) {
				selectedProjects = new HashMap<String, DependencyData>();
				setSelectAll(false);
				updateModel();
			}
		});
	
		trDependencies.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				final TreeItem item = (TreeItem) evt.item;
				if (item != null) {
					if (evt.detail == SWT.CHECK) {
						handleTreeItemChecked(item);
					} 
				}
			}

			public void widgetDefaultSelected(SelectionEvent evt) {

			}
		});
		createTreeContent();
	}
	
	/**
	 * Create content of tree control 
	 */
	protected void createTreeContent() {
		ProjectList projectListProvider = new ProjectList();
		List<ListData> projectListData = projectListProvider.getListData(null, null);
		for (ListData data : projectListData) {
			DependencyData dependencyData = (DependencyData)data.getData();
			projectList.put(data.getCaption(), dependencyData);
		}
		for (String project : getProjectList().keySet()) {
			DependencyData dependencyData = getProjectList().get(project);
			Object parent = dependencyData.getParent();
			Object self = dependencyData.getSelf();
			if((parent==null) && (self!=null)){
				if(self instanceof IProject){
					createNode(trDependencies, dependencyData);
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
						createNode(parentNode, dependencyData);
					}
					updateCheckState(parentNode);
				}
			}
		}

		trDependencies.layout();
	}
	
	/**
	 * Create a subItem for a project
	 * @param parent Parent treeItem
	 * @param project Project dependency 
	 * @return new TreeItem
	 */
	TreeItem createNode(TreeItem parent, final DependencyData project){
		TreeItem item= new TreeItem(parent, SWT.NONE);
		String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project.getDependency());
		item.setText(0,DistProjectUtils.getMavenInfoAsString(artifactInfo));
		NodeData nodeData = new NodeData(project);
		item.setData(nodeData);
		
		item.setImage(0, SWTResourceManager.getImage(this.getClass(),
		"/icons/artifact.png"));
	
		return item;
	}
	
	/**
	 * Create a Item for a dependency
	 * @param parent Parent tree control
	 * @param project Project dependency  
	 * @return new TreeItem
	 */
	TreeItem createNode(Tree parent, final DependencyData project){
		TreeItem item= new TreeItem(parent, SWT.NONE);
		final String artifactInfo = DistProjectUtils.getArtifactInfoAsString(project.getDependency());
		item.setText(0,DistProjectUtils.getMavenInfoAsString(artifactInfo));
		NodeData nodeData = new NodeData(project);
		item.setData(nodeData);

		item.setImage(0, SWTResourceManager.getImage(this.getClass(),
				"/icons/artifact.png"));
		return item;
		
	}
	
	/**
	 * Create a tree Item for a project
	 * @param parent  Parent tree control
	 * @param project eclipse project
	 * @return  new TreeItem
	 */
	TreeItem createNode(Tree parent, final IProject project) {
		TreeItem item = new TreeItem(parent, SWT.NONE);
		item.setText(0, project.getName());
		item.setText(1, "--");
		NodeData nodeData = new NodeData(project);
		item.setData(project);

		nodeData.setHaschildren(true);
		item.setData(nodeData);

		item.setImage(0, SWTResourceManager.getImage(
		              this.getClass(), "/icons/projects.gif"));
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
	private boolean isNameConflict(NodeData nodeData) {
		Dependency dependency = nodeData.getDependencyData().getDependency();
		for (DependencyData entry : selectedProjects.values()) {
			if (entry.getDependency().getArtifactId().equalsIgnoreCase(dependency.getArtifactId())) {
				return true;
			}
		}
		return false;
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
			if (i == item.getItemCount()  && i != 0) {
				item.setGrayed(false);
				item.setChecked(true);
			} else if (i < item.getItemCount() && i > 0) {
				item.setChecked(true);
				item.setGrayed(true);

			} else {
				item.setGrayed(false);
				item.setChecked(false);
			}
		}
	}
	
	/**
	 * Remove a project dependencies from the model
	 * @param nodeData NodeData of selected treeitem
	 */
	private void removeDependency(NodeData nodeData){
		DependencyData project = nodeData.getDependencyData();
		String artifactInfo = DistProjectUtils
		.getArtifactInfoAsString(project.getDependency());
		
		if (getSelectedProjects().containsKey(artifactInfo)) {
			getSelectedProjects().remove(artifactInfo);
			updateModel();
		}
	}
	
	/**
	 * Add a project dependencies to the model
	 * @param nodeData NodeData of selected treeitem
	 */
	private void addDependency(NodeData nodeData){
		DependencyData project = nodeData.getDependencyData();;
		String artifactInfo = DistProjectUtils
		.getArtifactInfoAsString(project.getDependency());
		
		if (!getSelectedProjects().containsKey(artifactInfo)) {
			getSelectedProjects().put(artifactInfo, project);
			updateModel();
		}
	}
	
	private void setSelectAll(boolean checked){
		TreeItem[] items = trDependencies.getItems();
		for (TreeItem treeItem : items) {
			treeItem.setChecked(checked);
			TreeItem[] subItems = treeItem.getItems();
			for (TreeItem subItem : subItems) {
				subItem.setChecked(checked);
            }
			NodeData nodeData = (NodeData) treeItem.getData(); 
			if(nodeData.hasChildren()){
				updateCheckState(treeItem);
			}
			
        }
	}
	
	private void updateModel(){
		List<DependencyData> dependencyList = new ArrayList<DependencyData>(getSelectedProjects().values());
		getModel().setSelectedProjects(dependencyList);
		
	}

	public void update(Observable o, Object arg) {
		trDependencies.layout();
	}


	public List<String> getCustomFields() {
		return null;
	}

	public void setModel(DistributionProjectModel model) {
	    this.model = model;
    }

	public DistributionProjectModel getModel() {
	    return model;
    }


	public Map<String,DependencyData> getProjectList() {
	    return projectList;
    }
	

	public Map<String,DependencyData> getSelectedProjects() {
	    return selectedProjects;
    }

	class NodeData {
		public NodeData(Object data){
			if(data instanceof DependencyData){
				dependencyData = (DependencyData) data;
			}
			else if (data instanceof IProject) {
				project  = (IProject) data;
				setHaschildren(true);

			}
		}

		public boolean hasChildren() {
			return hasChildren;
		}
		public void setHaschildren(boolean hasChildren) {
			this.hasChildren = hasChildren;
		}
		public DependencyData getDependencyData() {
			return dependencyData;
		}
		public void setDependency(DependencyData dependencyData) {
			this.dependencyData = dependencyData;
			this.project=null;
		}
		public IProject getProject() {
			return project;
		}
		public void setProject(IProject project) {
			this.project = project;
		}
		
		private boolean hasChildren;
		private DependencyData dependencyData;
		private IProject project;
	}

}
