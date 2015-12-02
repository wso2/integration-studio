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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
		setTitle("Maven Information");
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

		container.setLayout(new GridLayout(1, false));

		final Group grpMaven = new Group(container, SWT.BORDER);
		grpMaven.setText("Maven Project");
		GridLayout gl_grpMaven = new GridLayout(2, false);
		gl_grpMaven.verticalSpacing = 10;
		gl_grpMaven.horizontalSpacing = 40;
		grpMaven.setLayout(gl_grpMaven);
		GridData gd_grpMaven = new GridData(GridData.FILL_HORIZONTAL);
		gd_grpMaven.heightHint = 325;

		grpMaven.setLayoutData(gd_grpMaven);

		Label lblNewLabel = new Label(grpMaven, SWT.NONE);
		lblNewLabel.setText("Group Id");

		txtGroupId = new Text(grpMaven, SWT.BORDER);
		txtGroupId.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				mavenProjectInfo.setGroupId(txtGroupId.getText());
				dataModel.setMavenInfo(mavenProjectInfo);
				updatePageStatus();
			}
		});

		GridData gd_txtGroupId = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtGroupId.widthHint = 257;
		txtGroupId.setLayoutData(gd_txtGroupId);

		Label lblArtifactId = new Label(grpMaven, SWT.NONE);
		lblArtifactId.setText("Artifact Id");

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
		GridData gd_txtArtifact = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtArtifact.widthHint = 257;
		lblArtifactIdValue.setLayoutData(gd_txtArtifact);

		Label lblNewLabel_1 = new Label(grpMaven, SWT.NONE);
		lblNewLabel_1.setText("Version");

		txtVersion = new Text(grpMaven, SWT.BORDER);
		GridData gd_txtVersion = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtVersion.widthHint = 257;
		txtVersion.setLayoutData(gd_txtVersion);

		txtVersion.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				mavenProjectInfo.setVersion(txtVersion.getText());
				dataModel.setMavenInfo(mavenProjectInfo);
				updatePageStatus();
			}
		});

		btnhasMavenParent = new Button(grpMaven, SWT.CHECK);
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
					String text =
					              preferencesService.getString("org.wso2.developerstudio.eclipse.platform.ui",
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
		GridData gd_parentProjectInfoCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_parentProjectInfoCombo.widthHint = 350;
		parentProjectInfoCombo.setLayoutData(gd_parentProjectInfoCombo);

		lblParentGroupId = new Label(grpMaven, SWT.NONE);
		lblParentGroupId.setText("Parent Group Id");

		txtParentGroupId = new Text(grpMaven, SWT.BORDER);
		txtParentGroupId.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setParentGroupID(txtParentGroupId.getText());
				updatePageStatus();
				updateParent();
			}
		});

		GridData gd_txtParentGroupId = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtParentGroupId.widthHint = 257;
		txtParentGroupId.setLayoutData(gd_txtParentGroupId);

		lblParentArtifactId = new Label(grpMaven, SWT.NONE);
		lblParentArtifactId.setText("Parent Artifact Id");

		txtParentArtifactId = new Text(grpMaven, SWT.BORDER);
		txtParentArtifactId.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				setParentArtifactID(txtParentArtifactId.getText());
				updatePageStatus();
				updateParent();
			}
		});

		GridData gd_txtParentArtifact = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtParentArtifact.widthHint = 257;
		txtParentArtifactId.setLayoutData(gd_txtParentArtifact);

		lblParentVersion = new Label(grpMaven, SWT.NONE);
		lblParentVersion.setText("Parent Version");

		txtParentVersion = new Text(grpMaven, SWT.BORDER);
		GridData gd_txtParentVersion = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtParentVersion.widthHint = 257;
		txtParentVersion.setLayoutData(gd_txtParentVersion);
		txtParentVersion.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				setParentVersion(txtParentVersion.getText());
				updatePageStatus();
				updateParent();
			}
		});

		lblRelativePath = new Label(grpMaven, SWT.NONE);
		lblRelativePath.setText("Relative-path");

		txtRelativePath = new Text(grpMaven, SWT.BORDER);
		GridData gd_txtRelativePath = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtRelativePath.widthHint = 340;
		txtRelativePath.setLayoutData(gd_txtRelativePath);
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

	public void setArtifactIDLabel() {

		if (dataModel.getProjectName() != null && !dataModel.getProjectName().equals("")) {
			MavenInfo newmavenProjectInfo = dataModel.getMavenInfo();
			newmavenProjectInfo.setGroupId(dataModel.getGroupId() + "." + dataModel.getProjectName());
			newmavenProjectInfo.setArtifactId(dataModel.getProjectName());
			txtGroupId.setText(dataModel.getGroupId() + "." + dataModel.getProjectName());
			lblArtifactIdValue.setText(newmavenProjectInfo.getArtifactId());
			txtVersion.setText(newmavenProjectInfo.getVersion());
		}
	}

}
