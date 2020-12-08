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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.apache.maven.model.Parent;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class MavenDetailsPage extends WizardPage implements Observer {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String GLOBAL_PARENT_MAVEN_VERSION = "GLOBAL_MAVEN_VERSION";
	private static final String GLOBAL_PARENT_MAVEN_ARTIFACTID = "GLOBAL_MAVEN_ARTIFACTID";
	private static final String GLOBAL_PARENT_MAVEN_GROUP_ID = "GLOBAL_MAVEN_GROUPID";

	private Text txtGroupId;
	private Text txtVersion;
	private Text txtParentGroupId;
	private Text txtParentArtifactId;
	private Text txtParentVersion;
	private Text txtRelativePath;
	private Label lblParentGroupId;
	private Label lblParentArtifactId;
	private Label lblParentVersion;
	private Label lblRelativePath;
	private Text lblArtifactIdValue;
	private Button btnhasMavenParent;
	private Combo parentProjectInfoCombo;

	private boolean hasParentProject;
	private boolean hasLoadedProjectList;

	private String parentGroupID;
	private String parentArtifactID;
	private String parentVersion;
	private String parentProjectName;
	private String parentRelativePath;
	private final ProjectDataModel dataModel;
	private final MavenInfo mavenProjectInfo;

	private Map<String, Parent> parentProjectlist;

	private IPreferencesService preferencesService = Platform.getPreferencesService();

	/**
	 * Create the wizard.
	 */
	public MavenDetailsPage(ProjectDataModel projectDataModel) {
		super("wizardPage");
		setTitle("Additional Information");
		setDescription("Maven information for the project");
		this.dataModel = projectDataModel;
		this.mavenProjectInfo = projectDataModel.getMavenInfo();
		dataModel.addObserver(this);
		hasParentProject = false;
		parentProjectlist = new HashMap<String, Parent>();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new FormLayout());
		FormData data;

		final Group grpMaven = new Group(container, SWT.BORDER);
		grpMaven.setText("Maven Project");
		data = new FormData();
		data.top = new FormAttachment(1);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		grpMaven.setLayout(new FormLayout());
		grpMaven.setLayoutData(data);

		Label lblNewLabel = new Label(grpMaven, SWT.NONE);
		lblNewLabel.setText("Group Id");
		data = new FormData();
		data.top = new FormAttachment(grpMaven, 5);
		data.left = new FormAttachment(2);
		data.width = 250;
		lblNewLabel.setLayoutData(data);

		txtGroupId = new Text(grpMaven, SWT.BORDER);
		txtGroupId.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				mavenProjectInfo.setGroupId(txtGroupId.getText());
				dataModel.setMavenInfo(mavenProjectInfo);
				updatePageStatus();
			}
		});

		data = new FormData();
		data.top = new FormAttachment(grpMaven, 5);
		data.left = new FormAttachment(lblNewLabel, 0);
		data.right = new FormAttachment(98);
		txtGroupId.setLayoutData(data);

		Label lblArtifactId = new Label(grpMaven, SWT.NONE);
		lblArtifactId.setText("Artifact Id");
		data = new FormData();
		data.top = new FormAttachment(lblNewLabel, 20);
		data.left = new FormAttachment(2);
		data.width = 250;
		lblArtifactId.setLayoutData(data);

		lblArtifactIdValue = new Text(grpMaven, SWT.BORDER);
		lblArtifactIdValue.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				mavenProjectInfo.setArtifactId(lblArtifactIdValue.getText());
				dataModel.setMavenInfo(mavenProjectInfo);
				updatePageStatus();
			}
		});
		if (dataModel.getProjectName() != null) {
			lblArtifactIdValue.setText(dataModel.getProjectName());
			mavenProjectInfo.setArtifactId(dataModel.getProjectName());
			dataModel.setMavenInfo(mavenProjectInfo);
		} else {
			lblArtifactIdValue.setText("");
		}
		data = new FormData();
		data.top = new FormAttachment(lblNewLabel, 20);
		data.left = new FormAttachment(lblArtifactId, 0);
		data.right = new FormAttachment(98);
		lblArtifactIdValue.setLayoutData(data);

		Label lblNewLabel_1 = new Label(grpMaven, SWT.NONE);
		lblNewLabel_1.setText("Version");
		data = new FormData();
		data.top = new FormAttachment(lblArtifactId, 20);
		data.left = new FormAttachment(2);
		data.width = 250;
		lblNewLabel_1.setLayoutData(data);

		txtVersion = new Text(grpMaven, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblArtifactId, 20);
		data.left = new FormAttachment(lblNewLabel_1, 0);
		data.right = new FormAttachment(98);
		txtVersion.setLayoutData(data);

		txtVersion.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				mavenProjectInfo.setVersion(txtVersion.getText());
				dataModel.setMavenInfo(mavenProjectInfo);
				updatePageStatus();
			}
		});

		btnhasMavenParent = new Button(grpMaven, SWT.CHECK);
		data = new FormData();
		data.top = new FormAttachment(lblNewLabel_1, 20);
		data.left = new FormAttachment(2);
		data.width = 250;
		btnhasMavenParent.setLayoutData(data);
		btnhasMavenParent.setText("Specify Parent from Workspace");
		btnhasMavenParent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hasParentProject = btnhasMavenParent.getSelection();
				if (!hasLoadedProjectList || hasParentProject) {
					try {
						loadParentProjectInfo();
					} catch (Exception e1) {
						log.error(e1.getMessage(), e1);
					}
				}

				if (!btnhasMavenParent.getSelection()) {
					// Check whether the global setting is set. If set, user
					// them. otherwise simply null
					String text = preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
							GLOBAL_PARENT_MAVEN_GROUP_ID, null, null);
					if (text == null) {
						mavenProjectInfo.setParentProject(null);
						dataModel.setMavenInfo(mavenProjectInfo);
					} else {
						Parent parent = getParentFromPreferernceStore();
						setParentMavenInfo(parent);
						updateParent();
					}
				}
				updateMavenParentControlState();
			}
		});

		parentProjectInfoCombo = new Combo(grpMaven, SWT.READ_ONLY);
		data = new FormData();
		data.top = new FormAttachment(lblNewLabel_1, 20);
		data.left = new FormAttachment(btnhasMavenParent, 0);
		data.right = new FormAttachment(98);
		parentProjectInfoCombo.setLayoutData(data);

		lblParentGroupId = new Label(grpMaven, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(btnhasMavenParent, 20);
		data.left = new FormAttachment(2);
		data.width = 250;
		lblParentGroupId.setLayoutData(data);
		lblParentGroupId.setText("Parent Group Id");

		txtParentGroupId = new Text(grpMaven, SWT.BORDER);
		txtParentGroupId.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setParentGroupID(txtParentGroupId.getText());
				updatePageStatus();
				updateParent();
			}
		});

		data = new FormData();
		data.top = new FormAttachment(btnhasMavenParent, 20);
		data.left = new FormAttachment(lblParentGroupId, 0);
		data.right = new FormAttachment(98);
		txtParentGroupId.setLayoutData(data);

		lblParentArtifactId = new Label(grpMaven, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblParentGroupId, 20);
		data.left = new FormAttachment(2);
		data.width = 250;
		lblParentArtifactId.setLayoutData(data);
		lblParentArtifactId.setText("Parent Artifact Id");

		txtParentArtifactId = new Text(grpMaven, SWT.BORDER);
		txtParentArtifactId.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setParentArtifactID(txtParentArtifactId.getText());
				updatePageStatus();
				updateParent();
			}
		});

		data = new FormData();
		data.top = new FormAttachment(lblParentGroupId, 20);
		data.left = new FormAttachment(lblParentArtifactId, 0);
		data.right = new FormAttachment(98);
		txtParentArtifactId.setLayoutData(data);

		lblParentVersion = new Label(grpMaven, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblParentArtifactId, 20);
		data.left = new FormAttachment(2);
		data.width = 250;
		lblParentVersion.setLayoutData(data);
		lblParentVersion.setText("Parent Version");

		txtParentVersion = new Text(grpMaven, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblParentArtifactId, 20);
		data.left = new FormAttachment(lblParentVersion, 0);
		data.right = new FormAttachment(98);
		txtParentVersion.setLayoutData(data);
		txtParentVersion.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				setParentVersion(txtParentVersion.getText());
				updatePageStatus();
				updateParent();
			}
		});

		lblRelativePath = new Label(grpMaven, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblParentVersion, 20);
		data.left = new FormAttachment(2);
		data.width = 250;
		lblRelativePath.setLayoutData(data);
		lblRelativePath.setText("Relative-path");

		txtRelativePath = new Text(grpMaven, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblParentVersion, 20);
		data.left = new FormAttachment(lblRelativePath, 0);
		data.right = new FormAttachment(98);
		data.bottom = new FormAttachment(97);
		txtRelativePath.setLayoutData(data);
		txtRelativePath.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				setParentRelativePath(txtRelativePath.getText());
				updatePageStatus();
				updateParent();
			}
		});

		// Trying to get info from preference store
		Parent parent1 = getParentFromPreferernceStore();
		if (parent1.getGroupId() != null) {
			setParentMavenInfo(parent1);
			updateParent();
		}

		parentProjectInfoCombo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				Parent info = parentProjectlist.get(parentProjectInfoCombo.getText());
				if (info != null) {
					setParentMavenInfo(info);
					updateParent();
				} else if (preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
						GLOBAL_PARENT_MAVEN_GROUP_ID, null, null) != null) {
					Parent parentFromPreferernceStore = getParentFromPreferernceStore();
					setParentMavenInfo(parentFromPreferernceStore);
					mavenProjectInfo.setParentProject(parentFromPreferernceStore);
					dataModel.setMavenInfo(mavenProjectInfo);
				} else {
					mavenProjectInfo.setParentProject(null);
					dataModel.setMavenInfo(mavenProjectInfo);
				}
			}

		});

		setControl(container);
		updateMavenDetailsControls();
		updatePageStatus();
		TrayDialog.setDialogHelpAvailable(false);
	}

	private Parent getParentFromPreferernceStore() {
		Parent parent = new Parent();
		parent.setGroupId(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                               GLOBAL_PARENT_MAVEN_GROUP_ID, null, null));
		parent.setArtifactId(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                                  GLOBAL_PARENT_MAVEN_ARTIFACTID, null, null));
		parent.setVersion(preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                               GLOBAL_PARENT_MAVEN_VERSION, null, null));
		parent.setRelativePath(null);
		return parent;
	}

	private void updateParent() {
		Parent parent = new Parent();
		parent.setArtifactId(getParentArtifactID());
		parent.setGroupId(getParentGroupID());
		parent.setVersion(getParentVersion());
		parent.setRelativePath(getParentRelativePath());
		mavenProjectInfo.setParentProject(parent);
		dataModel.setMavenInfo(mavenProjectInfo);
	}

	private void setParentMavenInfo(Parent info) {
		if (info != null) {
			setParentProjectName(info.getArtifactId());
			setParentGroupID(info.getGroupId());
			setParentArtifactID(info.getArtifactId());
			setParentVersion(info.getVersion());
			setParentRelativePath(info.getRelativePath());
			txtParentArtifactId.setText(getParentArtifactID());
			txtParentGroupId.setText(getParentGroupID());
			txtParentVersion.setText(getParentVersion());
			String parentRelativePath2 = getParentRelativePath();
			if (hasParentProject && parentRelativePath2 != null) {
				txtRelativePath.setText(parentRelativePath2);
			} else {
				txtRelativePath.setText("");
			}
		}

	}

	private void loadParentProjectInfo() throws Exception {
		List<Parent> parentMavenProjects = getParentMavenProjects(new ArrayList<Parent>());
		parentProjectInfoCombo.removeAll();
		parentProjectInfoCombo.update();
		for (Parent parent : parentMavenProjects) {
			parentProjectlist.put(parent.getArtifactId(), parent);
			parentProjectInfoCombo.add(parent.getArtifactId());
		}

		if (parentProjectInfoCombo.getSelectionIndex() == -1) {
			parentProjectInfoCombo.select(0);
		}
		hasLoadedProjectList = true;
	}

	private List<Parent> getParentMavenProjects(List<Parent> mavenParentProjects) throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		for (IProject project : projects) {
			try {
				if (project.isOpen()) {
					File pomFile = project.getFile("pom.xml").getLocation().toFile();
					if (pomFile.exists()) {
						MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
						if (mavenProject.getPackaging().equals("pom")) {
							Parent parent = new Parent();
							parent.setArtifactId(mavenProject.getArtifactId());
							parent.setGroupId(mavenProject.getGroupId());
							parent.setVersion(mavenProject.getVersion());
							try {
								String relativePath = FileUtils.getRelativePath(dataModel.getLocation(), pomFile);
								parent.setRelativePath(relativePath);
								mavenParentProjects.add(parent);
							} catch (Exception e) {
								log.error(e.getMessage(), e);
							}
						}
					}
				}
			} catch (Exception e) {
				log.error("Error reading project list", e);
			}
		}

		File parentLocation = dataModel.getLocation();
		return mavenParentProjects;
	}

	private void updateMavenDetailsControls() {
		if (mavenProjectInfo != null) {
			String groupId = mavenProjectInfo.getGroupId();
			if (groupId != null && !groupId.equals("") && txtGroupId != null) {
				txtGroupId.setText(groupId);
			}

			String artifactId = mavenProjectInfo.getArtifactId();
			if (artifactId != null && !artifactId.equals("") && lblArtifactIdValue != null) {
				lblArtifactIdValue.setText(artifactId);
			}

			String version = mavenProjectInfo.getVersion();
			if (version != null && !version.equals("") && txtVersion != null) {
				txtVersion.setText(version);
			}

			if (hasParentProject) {

			} else {

			}
		}
		updateMavenParentControlState();
	}

	private void updateMavenParentControlState() {
		String text =
		              preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
		                                           GLOBAL_PARENT_MAVEN_GROUP_ID, null, null);
		if (btnhasMavenParent != null || text != null) {
			boolean hasParent = btnhasMavenParent.getSelection();
			parentProjectInfoCombo.setEnabled(hasParent);
			lblParentGroupId.setEnabled(hasParent || text != null);
			txtParentGroupId.setEnabled(hasParent || text != null);
			// lnkLoadParentFrom.setEnabled(!isParent);
			lblParentArtifactId.setEnabled(hasParent || text != null);
			txtParentArtifactId.setEnabled(hasParent || text != null);
			lblParentVersion.setEnabled(hasParent || text != null);
			txtParentVersion.setEnabled(hasParent || text != null);
			lblRelativePath.setEnabled(hasParent || text != null);
			txtRelativePath.setEnabled(hasParent || text != null);
		}
	}

	private void updatePageStatus() {
		if (mavenProjectInfo != null) {
			String groupId = mavenProjectInfo.getGroupId();
			if (groupId == null || groupId.equals("")) {
				updatePageStatus("Specify a group id for the maven project");
				return;
			}
			String artifactId = mavenProjectInfo.getArtifactId();
			if (artifactId == null || artifactId.equals("")) {
				updatePageStatus("Specify an artifact id for the maven project");
				return;
			}
			String version = mavenProjectInfo.getVersion();
			if (version == null || version.equals("")) {
				updatePageStatus("Specify a version for the maven project");
				return;
			}

			if (hasParentProject) {
				String parentGroupId = getParentGroupID();
				if (parentGroupId == null || parentGroupId.trim().equals("")) {
					updatePageStatus("Specify a group id for the parent project");
					return;
				}
				String parentArtifactId = getParentArtifactID();
				if (parentArtifactId == null || parentArtifactId.trim().equals("")) {
					updatePageStatus("Specify an artifact id for the parent project");
					return;
				}
				String parentVersion = getParentVersion();
				if (parentVersion == null || parentVersion.trim().equals("")) {
					updatePageStatus("Specify a version for the parent project");
					return;
				}
			}
            updatePageStatus(null);
		}
	}

	private void updatePageStatus(String msg) {
		setErrorMessage(msg);
		setPageComplete(msg == null);
	}

	public Combo getParentProjectInfoCombo() {
		return parentProjectInfoCombo;
	}

	public void setParentProjectInfoCombo(Combo parentProjectInfoCombo) {
		this.parentProjectInfoCombo = parentProjectInfoCombo;
	}

	public String getParentGroupID() {
		return parentGroupID;
	}

	public void setParentGroupID(String parentGroupID) {
		this.parentGroupID = parentGroupID;
	}

	public String getParentArtifactID() {
		return parentArtifactID;
	}

	public void setParentArtifactID(String parentArtifactID) {
		this.parentArtifactID = parentArtifactID;
	}

	public String getParentProjectName() {
		return parentProjectName;
	}

	public void setParentProjectName(String parentProjectName) {
		this.parentProjectName = parentProjectName;
	}

	public void setParentRelativePath(String parentRelativePath) {
		this.parentRelativePath = parentRelativePath;
	}

	public String getParentRelativePath() {
		if (parentRelativePath != null && parentRelativePath.equals("")) {
			return null;
		}
		return parentRelativePath;
	}

	public String getParentVersion() {
		return parentVersion;
	}

	public void setParentVersion(String parentVersion) {
		this.parentVersion = parentVersion;
	}

	public void update(Observable o, Object arg) {
		if (o == dataModel) {
			if (dataModel.getProjectName() != null) {
				setArtifactIDLabel();
			}
		}

	}

	public MavenInfo getMavenInformation() {
		return this.mavenProjectInfo;
	}
	
	public boolean canFlipToNextPage() {
		return false;
	}
	
	public void setArtifactIDLabel() {
		if (dataModel.getProjectName() != null && !dataModel.getProjectName().equals("")) {
			MavenInfo newmavenProjectInfo = dataModel.getMavenInfo();
			newmavenProjectInfo.setGroupId(dataModel.getGroupId());
			newmavenProjectInfo.setArtifactId(dataModel.getProjectName());
			txtGroupId.setText(dataModel.getGroupId());
			lblArtifactIdValue.setText(newmavenProjectInfo.getArtifactId());
			txtVersion.setText(newmavenProjectInfo.getVersion());
		}
	}

	public void updateArtifactId(String artifactId) {
		lblArtifactIdValue.setText(artifactId);
		lblArtifactIdValue.setEditable(false);
		lblArtifactIdValue.setEnabled(false);
	}
}
