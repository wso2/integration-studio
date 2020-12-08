/*
 * Copyright (c) 2019 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software He	
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.wso2.developerstudio.eclipse.platform.ui.wizard.pages;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.platform.core.utils.Validator;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PlatformUIConstants;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PluginImageUtils;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UserInputValidator;

public class DockerDetailsPage extends WizardPage {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String CONTAINER_PROJECT = "Docker Image Details";
	private static final String HELP_ICON = "/icons/help.png";
	private static final String TARGET_REPOSITORY_DESCRIPTION = "This parameter is used to specify a name for the Docker image. "
			+ "This value should be in convention of {registry-url}/{username}/{repository} or {username}/{repository} pattern";
	private static final String TARGET_TAG_DESCRIPTION = "This parameter is used to specify a version for the Docker image.";

	private Text txtProjectName;
	private Text txtRemoteRepository;
	private Text txtRemoteTag;
	private Text txtTargetRepository;
	private Text txtTargetTag;
	private Table tblParameters;
	private Button btnRemove;
	private Button btnAdd;
	private Button btnDeploymentTomlEnableChecker;

	private final ProjectDataModel dataModel;
	private Group dockerContainer;

	/**
	 * Create the wizard.
	 */
	public DockerDetailsPage(ProjectDataModel projectDataModel) {
		super("wizardPage");
		setTitle("Docker Exporter Information");
		setDescription("Docker image information for the project");
		setImageDescriptor(PluginImageUtils.getInstance().getImageDescriptor("Docker64x64.png"));
		this.dataModel = projectDataModel;
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

		// project name enter section
		Composite projectNameContainer = new Composite(container, SWT.NULL);
		projectNameContainer.setLayout(new FormLayout());
		data = new FormData();
		data.top = new FormAttachment(1);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		projectNameContainer.setLayoutData(data);

		Label lblDockerProjectName = new Label(projectNameContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(container, 10);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblDockerProjectName.setLayoutData(data);
		lblDockerProjectName.setText("Docker Exporter Name");

		txtProjectName = new Text(projectNameContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(container, 10);
		data.left = new FormAttachment(lblDockerProjectName, 0);
		data.right = new FormAttachment(97);
		txtProjectName.setLayoutData(data);
		txtProjectName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				try {
					dataModel.setProjectName(txtProjectName.getText());
				} catch (ObserverFailedException e) {
					log.error("Failed to set project name for project model", e);
				}
				updatePageStatus();
			}
		});

		// Create a horizontal separator
		Label separator = new Label(projectNameContainer, SWT.HORIZONTAL | SWT.SEPARATOR);
		data = new FormData();
		data.top = new FormAttachment(lblDockerProjectName, 25);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		separator.setLayoutData(data);

		// section for docker project details
		dockerContainer = new Group(container, SWT.BORDER);
		dockerContainer.setText(CONTAINER_PROJECT);
		dockerContainer.setLayout(new FormLayout());

		// check project needs the project name entering section
		data = new FormData();
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		if (dataModel.isDirectContainerProjectCreation()) {
			data.top = new FormAttachment(projectNameContainer, 20);
			projectNameContainer.setVisible(true);
		} else {
			projectNameContainer.setVisible(false);
			data.top = new FormAttachment(1);
		}
		dockerContainer.setLayoutData(data);

		Label lblRemoteRepository = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(dockerContainer, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblRemoteRepository.setLayoutData(data);
		lblRemoteRepository.setText("Base Image Repository");

		txtRemoteRepository = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(dockerContainer, 20);
		data.left = new FormAttachment(lblRemoteRepository, 0);
		data.right = new FormAttachment(97);
		txtRemoteRepository.setLayoutData(data);
		txtRemoteRepository.setText(PlatformUIConstants.DOCKER_DEFAULT_BASE_REPOSITORY);
		dataModel.setDockerRemoteRepository(PlatformUIConstants.DOCKER_DEFAULT_BASE_REPOSITORY);
		txtRemoteRepository.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setDockerRemoteRepository(txtRemoteRepository.getText());
				updatePageStatus();
			}
		});

		Label lblRemoteTag = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblRemoteRepository, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblRemoteTag.setLayoutData(data);
		lblRemoteTag.setText("Base Image Tag");

		txtRemoteTag = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblRemoteRepository, 20);
		data.left = new FormAttachment(lblRemoteTag, 0);
		data.right = new FormAttachment(97);
		txtRemoteTag.setLayoutData(data);
		txtRemoteTag.setText(PlatformUIConstants.DOCKER_DEFAULT_BASE_TAG);
		dataModel.setDockerRemoteTag(PlatformUIConstants.DOCKER_DEFAULT_BASE_TAG);
		txtRemoteTag.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setDockerRemoteTag(txtRemoteTag.getText());
				updatePageStatus();
			}
		});

		Label lblTargetRepository = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblRemoteTag, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblTargetRepository.setLayoutData(data);
		lblTargetRepository.setText("Target Image Repository");

		txtTargetRepository = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblRemoteTag, 20);
		data.left = new FormAttachment(lblTargetRepository, 0);
		data.right = new FormAttachment(90);
		txtTargetRepository.setLayoutData(data);
		txtTargetRepository.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setDockerTargetRepository(txtTargetRepository.getText());
				updatePageStatus();
			}
		});
		
		Label targetRepoHelpLabel = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		targetRepoHelpLabel.setImage(SWTResourceManager.getImage(this.getClass(), HELP_ICON));
		data.top = new FormAttachment(lblRemoteTag, 22);
		data.left = new FormAttachment(txtTargetRepository, 0);
		data.right = new FormAttachment(99);
		targetRepoHelpLabel.setLayoutData(data);
		targetRepoHelpLabel.setToolTipText(TARGET_REPOSITORY_DESCRIPTION);

		Label lblTargetTag = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblTargetRepository, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblTargetTag.setLayoutData(data);
		lblTargetTag.setText("Target Image Tag");

		txtTargetTag = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblTargetRepository, 20);
		data.left = new FormAttachment(lblTargetTag, 0);
		data.right = new FormAttachment(90);
		txtTargetTag.setLayoutData(data);
		txtTargetTag.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setDockerTargetTag(txtTargetTag.getText());
				updatePageStatus();
			}
		});
		
		Label targetTagHelpLabel = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		targetTagHelpLabel.setImage(SWTResourceManager.getImage(this.getClass(), HELP_ICON));
		data.top = new FormAttachment(lblTargetRepository, 22);
		data.left = new FormAttachment(txtTargetTag, 0);
		data.right = new FormAttachment(99);
		targetTagHelpLabel.setLayoutData(data);
		targetTagHelpLabel.setToolTipText(TARGET_TAG_DESCRIPTION);

		btnDeploymentTomlEnableChecker = new Button(dockerContainer, SWT.CHECK);
		data = new FormData();
		btnDeploymentTomlEnableChecker
				.setText("Automatically deploy configurations (supports Micro-Integrator-1.1.0 upwards)");
		data.top = new FormAttachment(lblTargetTag, 20);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(95);
		btnDeploymentTomlEnableChecker.setSelection(true);
		dataModel.setDeploymentTomlEnabled(true);
		btnDeploymentTomlEnableChecker.setLayoutData(data);

		btnDeploymentTomlEnableChecker.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnDeploymentTomlEnableChecker.getSelection()) {
					dataModel.setDeploymentTomlEnabled(true);
				} else {
					dataModel.setDeploymentTomlEnabled(false);
				}
				updatePageStatus();
			}
		});

		// Environment variable table
		Label lblParameters = new Label(dockerContainer, SWT.NONE);
		lblParameters.setText("Environment Variables");
		data = new FormData();
		data.top = new FormAttachment(btnDeploymentTomlEnableChecker, 20);
		data.left = new FormAttachment(2);
		lblParameters.setLayoutData(data);

		btnAdd = new Button(dockerContainer, SWT.NONE);
		data = new FormData();
		data.width = 100;
		data.top = new FormAttachment(lblParameters, 10);
		data.left = new FormAttachment(2);
		btnAdd.setLayoutData(data);
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(tblParameters, SWT.NONE);
				item.setText(0, "Env-" + tblParameters.getItemCount());
				item.setText(1, "value");
				tblParameters.select(tblParameters.indexOf(item));
				updateParameters();
			}
		});

		btnRemove = new Button(dockerContainer, SWT.NONE);
		data = new FormData();
		data.width = 100;
		data.top = new FormAttachment(lblParameters, 10);
		data.left = new FormAttachment(btnAdd, 5);
		btnRemove.setLayoutData(data);
		btnRemove.setText("Remove");
		btnRemove.setEnabled(false);
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblParameters.getSelectionIndex();
				if (-1 != selectedIndex) {
					tblParameters.remove(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < tblParameters.getItemCount()) {
						tblParameters.select(selectedIndex);
					} else {
						tblParameters.select(selectedIndex - 1);
					}
				}
				btnRemove.setEnabled(tblParameters.getItemCount() > 0);
				updateParameters();
			}
		});

		tblParameters = new Table(dockerContainer, SWT.BORDER | SWT.FULL_SELECTION);
		data = new FormData();
		data.top = new FormAttachment(btnAdd, 7);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(97);
		data.height = 200;
		tblParameters.setLayoutData(data);
		tblParameters.setHeaderVisible(true);
		tblParameters.setLinesVisible(true);

		TableColumn tblclmnName = new TableColumn(tblParameters, SWT.CENTER);
		tblclmnName.setWidth(270);
		tblclmnName.setText("Name");

		TableColumn tblclmnValue = new TableColumn(tblParameters, SWT.CENTER);
		tblclmnValue.setWidth(270);
		tblclmnValue.setText("Value");

		tblParameters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnRemove.setEnabled(tblParameters.getItemCount() > 0);
			}
		});
		tblParameters.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateParameters();
			}
		});

		// In-line editing of properties.
		setupTableEditor(tblParameters);
		setControl(container);
		updatePageStatus();
		TrayDialog.setDialogHelpAvailable(false);
	}

	/**
	 * Validate the wizard page field data and update the page when the validate is
	 * failed.
	 */
	private void updatePageStatus() {
		String projectName = dataModel.getProjectName();
		if (dataModel.isDirectContainerProjectCreation()) {
			String inValidReason = Validator.validateProjectName(projectName, "Docker Exporter");
			if (inValidReason != null) {
				updatePageStatus(inValidReason);
				return;
			}
		}
		String targetRepo = dataModel.getDockerTargetRepository();
		if (targetRepo == null || targetRepo.isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_TARGET_REPO_MESSAGE);
			return;
		} else if (!UserInputValidator.isRepositoryValid(targetRepo)) {
			updatePageStatus(PlatformUIConstants.INVALID_TARGET_REPO_MESSAGE);
			return;
		} else if (dataModel.getDockerTargetRepository() != null
				&& (dataModel.getDockerTargetRepository().split("/").length != 2
						&& dataModel.getDockerTargetRepository().split("/").length != 3)) {
			updatePageStatus(PlatformUIConstants.TARGET_REPOSITORY_INVALID);
			return;
		}
		String targetTag = dataModel.getDockerTargetTag();
		if (targetTag == null || targetTag.isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_TARGET_TAG_MESSAGE);
			return;
		} else if (!UserInputValidator.isTagValid(targetTag)) {
			updatePageStatus(PlatformUIConstants.INVALID_TARGET_TAG_MESSAGE);
			return;
		}
		String remoteRepo = dataModel.getDockerRemoteRepository();
		if (remoteRepo == null || remoteRepo.isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_REMOTE_REPOSITORY_MESSAGE);
			return;
		}
		String remoteTag = dataModel.getDockerRemoteTag();
		if (remoteTag == null || remoteTag.isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_REMOTE_TAG_MESSAGE);
			return;
		}
		updatePageStatus(null);
	}

	/**
	 * Update the page state.
	 *
	 * @param msg
	 *            error message
	 */
	private void updatePageStatus(String msg) {
		setErrorMessage(msg);
		setPageComplete(msg == null);
	}

	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table
	 *            table against which a table editor is setup.
	 */
	private void setupTableEditor(final Table table) {
		final TableEditor cellEditor = new TableEditor(table);
		cellEditor.grabHorizontal = true;
		cellEditor.minimumWidth = 50;
		table.addMouseListener(new MouseAdapter() {
			/**
			 * Setup a new cell editor control at double click event.
			 */
			public void mouseDoubleClick(MouseEvent e) {
				// Dispose the old editor control (if one is setup).
				Control oldEditorControl = cellEditor.getEditor();
				if (oldEditorControl != null) {
					oldEditorControl.dispose();
				}
				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);

				// Grab the selected row.
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (item == null) {
					return;
				}
				// Determine which column was selected.
				int selectedColumn = -1;
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					if (item.getBounds(i).contains(mouseLocation)) {
						selectedColumn = i;
						break;
					}
				}

				// Setup a new editor control.
				if (selectedColumn != -1) {
					Text editorControl = new Text(table, SWT.NONE);
					final int editorControlColumn = selectedColumn;
					editorControl.setText(item.getText(selectedColumn));
					editorControl.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							Text text = (Text) cellEditor.getEditor();
							cellEditor.getItem().setText(editorControlColumn, text.getText());
						}
					});
					editorControl.selectAll();
					editorControl.setFocus();
					cellEditor.setEditor(editorControl, item, selectedColumn);
				}
			}

			/**
			 * Dispose cell editor control at mouse down (otherwise the control keep
			 * showing).
			 */
			public void mouseDown(MouseEvent e) {
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl)
					oldEditorControl.dispose();
				updateParameters();
			}
		});
	}

	/**
	 * Update the parameters map using table items.
	 */
	private void updateParameters() {
		dataModel.getDockerEnvParameters().clear();
		for (TableItem item : tblParameters.getItems()) {
			dataModel.getDockerEnvParameters().put(item.getText(0), item.getText(1));
		}
	}
}
