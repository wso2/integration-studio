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
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.platform.core.utils.Validator;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PlatformUIConstants;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PluginImageUtils;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UserInputValidator;

public class KubernetesDetailsPage extends WizardPage {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String CONTAINER_PROJECT = "Kubernetes Exporter - Integration CR Details";
	private static final String HELP_ICON = "/icons/help.png";
	private static final String TARGET_REPOSITORY_DESCRIPTION = "This parameter is used to specify a name for the Docker image. "
			+ "This value should be in convention of {registry-url}/{username}/{repository} or {username}/{repository} pattern";
	private static final String TARGET_TAG_DESCRIPTION = "This parameter is used to specify a version for the Docker image.";
	private static final String DEFAULT_REPLICA_COUNT = "1";
	private static final String IS_NUMBER_EXPRESSION = "-?\\d+(\\.\\d+)?";

	private Text txtProjectName;
	private Text txtContainerName;
	private Text txtReplicaCount;
	private Text txtKubeRemoteRepository;
	private Text txtKubeRemoteTag;
	private Text txtKubeTargetRepository;
	private Text txtKubeTargetTag;
	private Table tblEnvParameters;
	private Table tblPortParameters;
	private Button btnEnvRemove;
	private Button btnEnvAdd;
	private Button btnPortRemove;
	private Button btnPortAdd;
	private Button btnDeploymentTomlEnableChecker;

	private final ProjectDataModel dataModel;
	private Group kubernetsContainer;

	/**
	 * Create the wizard.
	 */
	public KubernetesDetailsPage(ProjectDataModel projectDataModel) {
		super("wizardPage");
		setTitle("Kubernetes Exporter Information for K8s EI Operator");
		setDescription("Kubernetes deployment information for the project");
		setImageDescriptor(PluginImageUtils.getInstance().getImageDescriptor("kubernetes64x64.png"));
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
		lblDockerProjectName.setText("Kubernetes Exporter Name");

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

		kubernetsContainer = new Group(container, SWT.BORDER);
		kubernetsContainer.setText(CONTAINER_PROJECT);
		kubernetsContainer.setLayout(new FormLayout());

		data = new FormData();
		if (dataModel.isDirectContainerProjectCreation()) {
			data.top = new FormAttachment(projectNameContainer, 20);
			projectNameContainer.setVisible(true);
		} else {
			projectNameContainer.setVisible(false);
			data.top = new FormAttachment(1);
		}
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		kubernetsContainer.setLayoutData(data);

		// Kubernetes container project details
		Label lblContainerName = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(kubernetsContainer, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblContainerName.setLayoutData(data);
		lblContainerName.setText("Integration Name");

		txtContainerName = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(kubernetsContainer, 20);
		data.left = new FormAttachment(lblContainerName, 0);
		data.right = new FormAttachment(97);
		txtContainerName.setLayoutData(data);
		txtContainerName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeContainerName(txtContainerName.getText());
				updatePageStatus();
			}
		});

		Label lblReplicaCount = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblContainerName, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblReplicaCount.setLayoutData(data);
		lblReplicaCount.setText("Number of Replicas");

		txtReplicaCount = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblContainerName, 20);
		data.left = new FormAttachment(lblReplicaCount, 0);
		data.right = new FormAttachment(98);
		txtReplicaCount.setLayoutData(data);
		txtReplicaCount.setText(DEFAULT_REPLICA_COUNT);
		dataModel.setKubeReplicsas(DEFAULT_REPLICA_COUNT);
		txtReplicaCount.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeReplicsas(txtReplicaCount.getText());
				updatePageStatus();
			}
		});

		Label lblKubeRemoteRepository = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblReplicaCount, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblKubeRemoteRepository.setLayoutData(data);
		lblKubeRemoteRepository.setText("Base Image Repository");

		txtKubeRemoteRepository = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblReplicaCount, 20);
		data.left = new FormAttachment(lblKubeRemoteRepository, 0);
		data.right = new FormAttachment(98);
		txtKubeRemoteRepository.setLayoutData(data);
		txtKubeRemoteRepository.setText(PlatformUIConstants.DOCKER_DEFAULT_BASE_REPOSITORY);
		dataModel.setKubeRemoteRepository(PlatformUIConstants.DOCKER_DEFAULT_BASE_REPOSITORY);
		txtKubeRemoteRepository.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeRemoteRepository(txtKubeRemoteRepository.getText());
				updatePageStatus();
			}
		});

		Label lblKubeRemoteTag = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblKubeRemoteRepository, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblKubeRemoteTag.setLayoutData(data);
		lblKubeRemoteTag.setText("Base Image Tag");

		txtKubeRemoteTag = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblKubeRemoteRepository, 20);
		data.left = new FormAttachment(lblKubeRemoteTag, 0);
		data.right = new FormAttachment(98);
		txtKubeRemoteTag.setLayoutData(data);
		txtKubeRemoteTag.setText(PlatformUIConstants.DOCKER_DEFAULT_BASE_TAG);
		dataModel.setKubeRemoteTag(PlatformUIConstants.DOCKER_DEFAULT_BASE_TAG);
		txtKubeRemoteTag.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeRemoteTag(txtKubeRemoteTag.getText());
				updatePageStatus();
			}
		});

		Label lblKubeTargetRepository = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblKubeRemoteTag, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblKubeTargetRepository.setLayoutData(data);
		lblKubeTargetRepository.setText("Target Image Repository");

		txtKubeTargetRepository = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblKubeRemoteTag, 20);
		data.left = new FormAttachment(lblKubeTargetRepository, 0);
		data.right = new FormAttachment(90);
		txtKubeTargetRepository.setLayoutData(data);
		txtKubeTargetRepository.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeTargetRepository(txtKubeTargetRepository.getText());
				updatePageStatus();
			}
		});
		
		Label targetRepoHelpLabel = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		targetRepoHelpLabel.setImage(SWTResourceManager.getImage(this.getClass(), HELP_ICON));
		data.top = new FormAttachment(lblKubeRemoteTag, 22);
		data.left = new FormAttachment(txtKubeTargetRepository, 0);
		data.right = new FormAttachment(99);
		targetRepoHelpLabel.setLayoutData(data);
		targetRepoHelpLabel.setToolTipText(TARGET_REPOSITORY_DESCRIPTION);

		Label lblKubeTargetTag = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblKubeTargetRepository, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblKubeTargetTag.setLayoutData(data);
		lblKubeTargetTag.setText("Target Image Tag");

		txtKubeTargetTag = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblKubeTargetRepository, 20);
		data.left = new FormAttachment(lblKubeTargetTag, 0);
		data.right = new FormAttachment(90);
		txtKubeTargetTag.setLayoutData(data);
		txtKubeTargetTag.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeTargetTag(txtKubeTargetTag.getText());
				updatePageStatus();
			}
		});
		
		Label targetTagHelpLabel = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		targetTagHelpLabel.setImage(SWTResourceManager.getImage(this.getClass(), HELP_ICON));
		data.top = new FormAttachment(lblKubeTargetRepository, 22);
		data.left = new FormAttachment(txtKubeTargetTag, 0);
		data.right = new FormAttachment(99);
		targetTagHelpLabel.setLayoutData(data);
		targetTagHelpLabel.setToolTipText(TARGET_TAG_DESCRIPTION);

		btnDeploymentTomlEnableChecker = new Button(kubernetsContainer, SWT.CHECK);
		data = new FormData();
		btnDeploymentTomlEnableChecker
				.setText("Automatically deploy configurations (supports Micro-Integrator-1.1.0 upwards)");
		data.top = new FormAttachment(lblKubeTargetTag, 20);
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

		Label lblExposePorts = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(btnDeploymentTomlEnableChecker, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblExposePorts.setLayoutData(data);
		lblExposePorts.setText("Inbound Port(s)");

		// Inbound Ports table

		btnPortAdd = new Button(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.width = 100;
		data.top = new FormAttachment(lblExposePorts, 10);
		data.left = new FormAttachment(2);
		btnPortAdd.setLayoutData(data);
		btnPortAdd.setText("Add");
		btnPortAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(tblPortParameters, SWT.NONE);
				item.setText(0, "800" + tblPortParameters.getItemCount());
				tblPortParameters.select(tblPortParameters.indexOf(item));
				updatePortParameters();
			}
		});

		btnPortRemove = new Button(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.width = 100;
		data.top = new FormAttachment(lblExposePorts, 10);
		data.left = new FormAttachment(btnPortAdd, 5);
		btnPortRemove.setLayoutData(data);
		btnPortRemove.setText("Remove");
		btnPortRemove.setEnabled(false);
		btnPortRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblPortParameters.getSelectionIndex();
				if (-1 != selectedIndex) {
					tblPortParameters.remove(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < tblPortParameters.getItemCount()) {
						tblPortParameters.select(selectedIndex);
					} else {
						tblPortParameters.select(selectedIndex - 1);
					}
				}
				btnPortRemove.setEnabled(tblPortParameters.getItemCount() > 0);
				updatePortParameters();
			}
		});

		tblPortParameters = new Table(kubernetsContainer, SWT.BORDER | SWT.FULL_SELECTION);
		data = new FormData();
		data.top = new FormAttachment(btnPortAdd, 7);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		data.height = 80;
		tblPortParameters.setLayoutData(data);
		tblPortParameters.setHeaderVisible(true);
		tblPortParameters.setLinesVisible(true);

		TableColumn tblclmnPort = new TableColumn(tblPortParameters, SWT.LEFT);
		tblclmnPort.setWidth(540);
		tblclmnPort.setText("Port Number");

		tblPortParameters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnPortRemove.setEnabled(tblPortParameters.getItemCount() > 0);
			}
		});
		tblPortParameters.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updatePortParameters();
			}
		});

		// Environment variable table

		Label lblParameters = new Label(kubernetsContainer, SWT.NONE);
		lblParameters.setText("Environment Variables");
		data = new FormData();
		data.top = new FormAttachment(tblPortParameters, 20);
		data.left = new FormAttachment(2);
		lblParameters.setLayoutData(data);

		btnEnvAdd = new Button(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.width = 100;
		data.top = new FormAttachment(lblParameters, 10);
		data.left = new FormAttachment(2);
		btnEnvAdd.setLayoutData(data);
		btnEnvAdd.setText("Add");
		btnEnvAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(tblEnvParameters, SWT.NONE);
				item.setText(0, "Env-" + tblEnvParameters.getItemCount());
				item.setText(1, "value");
				tblEnvParameters.select(tblEnvParameters.indexOf(item));
				updateEnvParameters();
			}
		});

		btnEnvRemove = new Button(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.width = 100;
		data.top = new FormAttachment(lblParameters, 10);
		data.left = new FormAttachment(btnEnvAdd, 5);
		btnEnvRemove.setLayoutData(data);
		btnEnvRemove.setText("Remove");
		btnEnvRemove.setEnabled(false);
		btnEnvRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblEnvParameters.getSelectionIndex();
				if (-1 != selectedIndex) {
					tblEnvParameters.remove(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < tblEnvParameters.getItemCount()) {
						tblEnvParameters.select(selectedIndex);
					} else {
						tblEnvParameters.select(selectedIndex - 1);
					}
				}
				btnEnvRemove.setEnabled(tblEnvParameters.getItemCount() > 0);
				updateEnvParameters();
			}
		});

		tblEnvParameters = new Table(kubernetsContainer, SWT.BORDER | SWT.FULL_SELECTION);
		data = new FormData();
		data.top = new FormAttachment(btnEnvAdd, 7);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		data.height = 130;
		tblEnvParameters.setLayoutData(data);
		tblEnvParameters.setHeaderVisible(true);
		tblEnvParameters.setLinesVisible(true);

		TableColumn tblclmnName = new TableColumn(tblEnvParameters, SWT.CENTER);
		tblclmnName.setWidth(270);
		tblclmnName.setText("Name");

		TableColumn tblclmnValue = new TableColumn(tblEnvParameters, SWT.CENTER);
		tblclmnValue.setWidth(270);
		tblclmnValue.setText("Value");

		tblEnvParameters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnEnvRemove.setEnabled(tblEnvParameters.getItemCount() > 0);
			}
		});
		tblEnvParameters.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateEnvParameters();
			}
		});

		// In-line editing of properties.
		setupEnvTableEditor(tblEnvParameters);
		setupPortTableEditor(tblPortParameters);

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
			String inValidReason = Validator.validateProjectName(projectName, "Kubernetes Exporter");
			if (inValidReason != null) {
				updatePageStatus(inValidReason);
				return;
			}
		}
		if (dataModel.getKubeContainerName() == null || dataModel.getKubeContainerName().isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_CONTAINER_NAME);
			return;
		} else if (dataModel.getKubeRemoteRepository() == null || dataModel.getKubeRemoteRepository().isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_KUBE_REMOTE_REPOSITORY);
			return;
		} else if (dataModel.getKubeRemoteTag() == null || dataModel.getKubeRemoteTag().isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_KUBE_REMOTE_TAG);
			return;
		} else if (dataModel.getKubeReplicsas() == null || dataModel.getKubeReplicsas().isEmpty()) {
			updatePageStatus(PlatformUIConstants.INVALID_REPLICA_COUNT);
			return;
		} else if (!dataModel.getKubeReplicsas().matches("-?\\d+(\\.\\d+)?")) {
			updatePageStatus(PlatformUIConstants.INVALID_REPLICA_COUNT_NOT_AS_INT);
			return;
		} else if (dataModel.getKubeTargetRepository() == null || dataModel.getKubeTargetRepository().isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_KUBE_TARGET_REPOSITORY);
			return;
		} else if (dataModel.getKubeTargetTag() == null || dataModel.getKubeTargetTag().isEmpty()) {
			updatePageStatus(PlatformUIConstants.NO_TARGET_TAG_ERROR);
			return;
		} else if (!UserInputValidator.isRepositoryValid(dataModel.getKubeTargetRepository())) {
			updatePageStatus(PlatformUIConstants.INVALID_TARGET_REPO_MESSAGE);
			return;
		} else if (!UserInputValidator.isTagValid(dataModel.getKubeTargetTag())) {
			updatePageStatus(PlatformUIConstants.INVALID_TARGET_TAG_MESSAGE);
			return;
		} else if (dataModel.getKubeTargetRepository() != null
				&& (dataModel.getKubeTargetRepository().split("/").length != 2
						&& dataModel.getKubeTargetRepository().split("/").length != 3)) {
			updatePageStatus(PlatformUIConstants.TARGET_REPOSITORY_INVALID);
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
	private void setupEnvTableEditor(final Table table) {
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
				updateEnvParameters();
			}
		});
	}

	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table
	 *            table against which a table editor is setup.
	 */
	private void setupPortTableEditor(final Table table) {
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
				if (null != oldEditorControl)
					oldEditorControl.dispose();

				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);

				// Grab the selected row.
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (null == item)
					return;

				// Determine which column was selected.
				int selectedColumn = -1;
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					if (item.getBounds(i).contains(mouseLocation)) {
						selectedColumn = i;
						break;
					}
				}

				// Setup a new editor control.
				if (-1 != selectedColumn) {
					Text editorControl = new Text(table, SWT.NONE);
					final int editorControlColumn = selectedColumn;
					editorControl.setText(item.getText(selectedColumn));
					editorControl.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							Text text = (Text) cellEditor.getEditor();
							String invalidMessage = isValidInboundPortAdded(text.getText());
							if (invalidMessage != null) {
								updatePageStatus(invalidMessage);
								return;
							}
							updatePageStatus(null);
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
				updatePortParameters();
			}
		});
	}

	/**
	 * Checks the modified port is an valid port.
	 * 
	 * @param modifyPort
	 *            port which modify
	 * @return invalid message of the validation
	 */
	private String isValidInboundPortAdded(String modifyPort) {
		String invalidMessage = null;
		if (!modifyPort.matches(IS_NUMBER_EXPRESSION)) {
			invalidMessage = PlatformUIConstants.INVALID_PORT_TYPE;
		} else if (modifyPort.matches(IS_NUMBER_EXPRESSION) && Integer.parseInt(modifyPort) > 65535) {
			invalidMessage = PlatformUIConstants.INVALID_PORT_RANGE;
		}

		return invalidMessage;
	}

	/**
	 * Update the Env parameters map using table items.
	 */
	private void updateEnvParameters() {
		dataModel.getKubernetesEnvParameters().clear();
		for (TableItem item : tblEnvParameters.getItems()) {
			dataModel.getKubernetesEnvParameters().put(item.getText(0), item.getText(1));
		}
	}

	/**
	 * Update the port parameters map using table items.
	 */
	private void updatePortParameters() {
		dataModel.getKubernetesPortParameters().clear();
		for (TableItem item : tblPortParameters.getItems()) {
			dataModel.getKubernetesPortParameters().put(item.getText(0), item.getText(0));
		}
	}
}
