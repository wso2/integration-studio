/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.wizard.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetSelectionDialog;
import org.eclipse.ui.internal.WorkingSet;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.eclipse.swt.widgets.Combo;

public class WorkingSetComposite extends Composite implements Observer {

	private String selectedProject;
	private String currentProjectName;
	private ProjectDataModel projectModel;
	private Combo combo;
	private Button btnCheckButton;
	private IWorkingSetManager workingSetManager;
	private Map<String, Integer> workingSetMap;
	private int index = -1;

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public WorkingSetComposite(Composite parent, int style, ProjectDataModel model) {
		super(parent, style);
		final Shell shell = parent.getShell();
		setProjectModel(model);
		setCurrentProjectName(model.getProjectName());

		workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
		workingSetMap = new HashMap<String, Integer>();

		setLayout(new GridLayout(1, false));
		Group grpLocation = new Group(this, SWT.NONE);
		grpLocation.setText("Working Sets");
		grpLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpLocation.setLayout(new GridLayout(5, false));

		btnCheckButton = new Button(grpLocation, SWT.CHECK);
		btnCheckButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 5, 1));
		btnCheckButton.setText("Add project to working sets");
		btnCheckButton.setSelection(false);

		Label lblNewLabel = new Label(grpLocation, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Working Sets");

		combo = new Combo(grpLocation, SWT.NONE | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.setEnabled(false);
		new Label(grpLocation, SWT.NONE);

		final Button selectButton = new Button(grpLocation, SWT.NONE);
		selectButton.setText("Select..");
		selectButton.setEnabled(false);
		new Label(grpLocation, SWT.NONE);

		IWorkingSet[] recentWorkingSetlist = workingSetManager.getRecentWorkingSets();
		for (IWorkingSet iWorkingSet : recentWorkingSetlist) {
			index++;
			workingSetMap.put(iWorkingSet.getName(), index);
			combo.add(iWorkingSet.getName());
			IWorkingSet[] newSet = new WorkingSet[1];
			newSet[0] = iWorkingSet;
			combo.setData(iWorkingSet.getName(), newSet);
		}
		combo.select(0);

		btnCheckButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				boolean selected = ((Button) event.widget).getSelection();
				selectButton.setEnabled(selected);
				combo.setEnabled(selected);
				if (combo.getItemCount() > 0) {
					getProjectModel().setSelectedWorkingSets(getSelectedWorkingSet());
				}
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		selectButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				IWorkingSetSelectionDialog dialog = workingSetManager.createWorkingSetSelectionDialog(shell, true);
				if (dialog != null) {
					if (combo.getItemCount() > 0) {
						dialog.setSelection(getSelectedWorkingSet());
					}
					dialog.open();
					IWorkingSet[] selected = dialog.getSelection();
					String workingSetName = "";
					for (IWorkingSet iWorkingSet : selected) {
						if (workingSetName.equals("")) {
							workingSetName = iWorkingSet.getName();
						} else {
							workingSetName = workingSetName + "," + iWorkingSet.getName();
						}
					}
					if (!isItemExist(workingSetName)) {
						index++;
						workingSetMap.put(workingSetName, index);
						combo.add(workingSetName);
						combo.setData(workingSetName, selected);
						combo.select(index);
					}
				}
			}

			private boolean isItemExist(String workingSetName) {
				String[] items = combo.getItems();
				for (String name : items) {
					if (workingSetName.equals(name)) {
						combo.select(workingSetMap.get(name));
						return true;
					}
				}
				return false;
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
			}
		});
		combo.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				getProjectModel().setSelectedWorkingSets(getSelectedWorkingSet());
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
			}
		});

		model.addObserver(this);
		if (combo.getItemCount() > 0) {
			getProjectModel().setSelectedWorkingSets(getSelectedWorkingSet());
		}
	}

	private IWorkingSet[] getSelectedWorkingSet() {
		IWorkingSet[] workingSets = null;
		if (btnCheckButton.getSelection()) {
			workingSets = (IWorkingSet[]) combo.getData(combo.getItem(combo.getSelectionIndex()));
		}
		return workingSets;
	}

	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void setCurrentProjectName(String currentProjectName) {
		this.currentProjectName = currentProjectName;
	}

	public String getCurrentProjectName() {
		return currentProjectName;
	}

	public void setProjectModel(ProjectDataModel projectModel) {
		this.projectModel = projectModel;
	}

	public ProjectDataModel getProjectModel() {
		return projectModel;
	}

	public void update(Observable o, Object arg) {
		if (o == getProjectModel()) {
			if (getCurrentProjectName() == null || !getCurrentProjectName().equals(getProjectModel().getProjectName())) {
				setCurrentProjectName(getProjectModel().getProjectName());
			}
		}
	}
}
