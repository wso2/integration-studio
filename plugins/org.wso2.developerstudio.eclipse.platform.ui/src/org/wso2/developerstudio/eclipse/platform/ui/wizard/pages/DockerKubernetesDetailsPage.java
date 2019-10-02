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

import java.util.Observable;
import java.util.Observer;

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
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PlatformUIConstants;
import org.wso2.developerstudio.eclipse.platform.ui.utils.UserInputValidator;

public class DockerKubernetesDetailsPage extends WizardPage implements Observer {

	private static final String DEFAULT_REMOTE_REPOSITORY = "wso2/micro-integrator";
	private static final String DEFAULT_REMOTE_TAG = "latest";
	private static final String CONTAINER_PROJECT = "Docker/Kubernetes Project";
	private static final String DEFAULT_REPLICA_COUNT = "1";
	private static final String DEFAULT_EXPOSE_PORT = "8290";

	private Text txtRemoteRepository;
	private Text txtRemoteTag;
	private Text txtTargetRepository;
	private Text txtTargetTag;
	private Text txtContainerName;
	private Text txtReplicaCount;
	private Text txtKubeRemoteRepository;
	private Text txtKubeRemoteTag;
	private Text txtKubeTargetRepository;
	private Text txtKubeTargetTag;
	private Text txtExposePort;
	private Table tblParameters;
	private Button btnRemove;
	private Button btnAdd;
	private Combo containerTypeDropDown;

	private final ProjectDataModel dataModel;
	private final MavenInfo mavenProjectInfo;
	private Group grpContainers;

	private Composite dockerContainer;
	private Composite kubernetsContainer;

	/**
	 * Create the wizard.
	 */
	public DockerKubernetesDetailsPage(ProjectDataModel projectDataModel) {
		super("wizardPage");
		setTitle("Docker/Kubernetes Project Information");
		setDescription("Docker or Kubernetes information for the project");
		this.dataModel = projectDataModel;
		this.mavenProjectInfo = projectDataModel.getMavenInfo();
		dataModel.addObserver(this);
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

		grpContainers = new Group(container, SWT.BORDER);
		grpContainers.setText(CONTAINER_PROJECT);
		grpContainers.setVisible(false);
		grpContainers.setLayout(new FormLayout());

		data = new FormData();
		data.top = new FormAttachment(1);
		data.left = new FormAttachment(2);
		data.right = new FormAttachment(98);
		grpContainers.setLayoutData(data);

		Label lblContainerType = new Label(grpContainers, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(grpContainers, 10);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblContainerType.setLayoutData(data);
		lblContainerType.setText("Container Type:");

		final String[] containerTypes = { "Docker", "Kubernetes" };
		containerTypeDropDown = new Combo(grpContainers, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		data = new FormData();
		data.top = new FormAttachment(grpContainers, 10);
		data.left = new FormAttachment(lblContainerType, 0);
		data.right = new FormAttachment(98);
		containerTypeDropDown.setLayoutData(data);
		containerTypeDropDown.setItems(containerTypes);
		containerTypeDropDown.setText(containerTypes[1]);

		// docker container project details
		dockerContainer = new Composite(grpContainers, SWT.NULL);
		dockerContainer.setLayout(new FormLayout());
		data = new FormData();
		data.top = new FormAttachment(lblContainerType, 5);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		dockerContainer.setLayoutData(data);
		dockerContainer.setVisible(false);

		Label lblRemoteRepository = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(dockerContainer, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblRemoteRepository.setLayoutData(data);
		lblRemoteRepository.setText("Remote Repository");

		txtRemoteRepository = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(dockerContainer, 20);
		data.left = new FormAttachment(lblRemoteRepository, 0);
		data.right = new FormAttachment(97);
		txtRemoteRepository.setLayoutData(data);
		txtRemoteRepository.setText(DEFAULT_REMOTE_REPOSITORY);
		dataModel.setDockerRemoteRepository(DEFAULT_REMOTE_REPOSITORY);
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
		lblRemoteTag.setText("Remote Tag");

		txtRemoteTag = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblRemoteRepository, 20);
		data.left = new FormAttachment(lblRemoteTag, 0);
		data.right = new FormAttachment(97);
		txtRemoteTag.setLayoutData(data);
		txtRemoteTag.setText(DEFAULT_REMOTE_TAG);
		dataModel.setDockerRemoteTag(DEFAULT_REMOTE_TAG);
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
		lblTargetRepository.setText("Target Repository");

		txtTargetRepository = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblRemoteTag, 20);
		data.left = new FormAttachment(lblTargetRepository, 0);
		data.right = new FormAttachment(97);
		txtTargetRepository.setLayoutData(data);
		txtTargetRepository.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setDockerTargetRepository(txtTargetRepository.getText());
				updatePageStatus();
			}
		});

		Label lblTargetTag = new Label(dockerContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblTargetRepository, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblTargetTag.setLayoutData(data);
		lblTargetTag.setText("Target Tag");

		txtTargetTag = new Text(dockerContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblTargetRepository, 20);
		data.left = new FormAttachment(lblTargetTag, 0);
		data.right = new FormAttachment(97);
		txtTargetTag.setLayoutData(data);
		txtTargetTag.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setDockerTargetTag(txtTargetTag.getText());
				updatePageStatus();
			}
		});

		// Kubernetes container project details
		kubernetsContainer = new Composite(grpContainers, SWT.NULL);
		kubernetsContainer.setLayout(new FormLayout());
		data = new FormData();
		data.top = new FormAttachment(lblContainerType, 5);
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		kubernetsContainer.setLayoutData(data);

		Label lblContainerName = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(kubernetsContainer, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblContainerName.setLayoutData(data);
		lblContainerName.setText("Container Name");

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
		data.right = new FormAttachment(97);
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
		lblKubeRemoteRepository.setText("Remote Repository");

		txtKubeRemoteRepository = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblReplicaCount, 20);
		data.left = new FormAttachment(lblKubeRemoteRepository, 0);
		data.right = new FormAttachment(97);
		txtKubeRemoteRepository.setLayoutData(data);
		txtKubeRemoteRepository.setText(DEFAULT_REMOTE_REPOSITORY);
		dataModel.setKubeRemoteRepository(DEFAULT_REMOTE_REPOSITORY);
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
		lblKubeRemoteTag.setText("Remote Tag");

		txtKubeRemoteTag = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblKubeRemoteRepository, 20);
		data.left = new FormAttachment(lblKubeRemoteTag, 0);
		data.right = new FormAttachment(97);
		txtKubeRemoteTag.setLayoutData(data);
		txtKubeRemoteTag.setText(DEFAULT_REMOTE_TAG);
		dataModel.setKubeRemoteTag(DEFAULT_REMOTE_TAG);
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
		lblKubeTargetRepository.setText("Target Repository");

		txtKubeTargetRepository = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblKubeRemoteTag, 20);
		data.left = new FormAttachment(lblKubeTargetRepository, 0);
		data.right = new FormAttachment(97);
		txtKubeTargetRepository.setLayoutData(data);
		txtKubeTargetRepository.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeTargetRepository(txtKubeTargetRepository.getText());
				updatePageStatus();
			}
		});

		Label lblKubeTargetTag = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblKubeTargetRepository, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblKubeTargetTag.setLayoutData(data);
		lblKubeTargetTag.setText("Target Tag");

		txtKubeTargetTag = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblKubeTargetRepository, 20);
		data.left = new FormAttachment(lblKubeTargetTag, 0);
		data.right = new FormAttachment(97);
		txtKubeTargetTag.setLayoutData(data);
		txtKubeTargetTag.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeTargetTag(txtKubeTargetTag.getText());
				updatePageStatus();
			}
		});

		Label lblExposePorts = new Label(kubernetsContainer, SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(lblKubeTargetTag, 20);
		data.left = new FormAttachment(2);
		data.width = 200;
		lblExposePorts.setLayoutData(data);
		lblExposePorts.setText("Expose Port");

		txtExposePort = new Text(kubernetsContainer, SWT.BORDER);
		data = new FormData();
		data.top = new FormAttachment(lblKubeTargetTag, 20);
		data.left = new FormAttachment(lblExposePorts, 0);
		data.right = new FormAttachment(97);
		txtExposePort.setLayoutData(data);
		txtExposePort.setText(DEFAULT_EXPOSE_PORT);
		dataModel.setKubeExposePort(DEFAULT_EXPOSE_PORT);
		txtExposePort.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				dataModel.setKubeExposePort(txtExposePort.getText());
				updatePageStatus();
			}
		});

		// Environment variable table

		Label lblParameters = new Label(kubernetsContainer, SWT.NONE);
		lblParameters.setText("Environment Variables");
		data = new FormData();
		data.top = new FormAttachment(lblExposePorts, 20);
		data.left = new FormAttachment(2);
		lblParameters.setLayoutData(data);

		btnAdd = new Button(kubernetsContainer, SWT.NONE);
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

		btnRemove = new Button(kubernetsContainer, SWT.NONE);
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

		tblParameters = new Table(kubernetsContainer, SWT.BORDER | SWT.FULL_SELECTION);
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

		containerTypeDropDown.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (containerTypeDropDown.getText().equals(containerTypes[0])) {
					dockerContainer.setVisible(true);
					kubernetsContainer.setVisible(false);
					dataModel.setDockerContainerSelected(true);
					updatePageStatus();
				} else {
					dockerContainer.setVisible(false);
					kubernetsContainer.setVisible(true);
					dataModel.setDockerContainerSelected(false);
					updatePageStatus();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		setControl(container);
		updatePageStatus();
		TrayDialog.setDialogHelpAvailable(false);
	}

	/**
	 * Validate the wizard page field data and update the page when the validate is
	 * failed.
	 */
	private void updatePageStatus() {
		if (mavenProjectInfo != null) {
			if (dataModel.isContainerExporterProjectChecked() && dataModel.isDockerContainerSelected()) {
				String targetRepo = dataModel.getDockerTargetRepository();
				if (targetRepo == null || targetRepo.isEmpty()) {
					updatePageStatus(PlatformUIConstants.NO_TARGET_REPO_MESSAGE);
					return;
				} else if (!UserInputValidator.isRepositoryValid(targetRepo)) {
					updatePageStatus(PlatformUIConstants.INVALID_TARGET_REPO_MESSAGE);
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
			} else if (dataModel.isContainerExporterProjectChecked() && !dataModel.isDockerContainerSelected()) {
				if (dataModel.getKubeContainerName() == null || dataModel.getKubeContainerName().isEmpty()) {
					updatePageStatus(PlatformUIConstants.NO_CONTAINER_NAME);
					return;
				} else if (dataModel.getDockerRemoteRepository() == null
						|| dataModel.getDockerRemoteRepository().isEmpty()) {
					updatePageStatus(PlatformUIConstants.NO_KUBE_REMOTE_REPOSITORY);
					return;
				} else if (dataModel.getDockerRemoteTag() == null || dataModel.getDockerRemoteTag().isEmpty()) {
					updatePageStatus(PlatformUIConstants.NO_KUBE_REMOTE_TAG);
					return;
				} else if (dataModel.getKubeReplicsas() == null || dataModel.getKubeReplicsas().isEmpty()) {
					updatePageStatus(PlatformUIConstants.INVALID_REPLICA_COUNT);
					return;
				} else if (!dataModel.getKubeReplicsas().matches("-?\\d+(\\.\\d+)?")) {
					updatePageStatus(PlatformUIConstants.INVALID_REPLICA_COUNT_NOT_AS_INT);
					return;
				} else if (dataModel.getKubeExposePort() == null || dataModel.getKubeExposePort().isEmpty()) {
					updatePageStatus(PlatformUIConstants.INVALID_PORT);
					return;
				} else if (!dataModel.getKubeExposePort().matches("-?\\d+(\\.\\d+)?")) {
					updatePageStatus(PlatformUIConstants.INVALID_PORT_TYPE);
					return;
				} else if (dataModel.getKubeExposePort().matches("-?\\d+(\\.\\d+)?")
						&& Integer.parseInt(dataModel.getKubeExposePort()) > 65535) {
					updatePageStatus(PlatformUIConstants.INVALID_PORT_RANGE);
					return;
				} else if (dataModel.getKubeTargetRepository() == null
						|| dataModel.getKubeTargetRepository().isEmpty()) {
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
					updatePageStatus(PlatformUIConstants.KUBE_TARGET_REPOSITORY_INVALID);
					return;
				}
			}
			updatePageStatus(null);
		}
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

	public void update(Observable observable, Object arg) {
		if (observable == dataModel) {
			if (grpContainers != null) {
				if (dataModel.isContainerExporterProjectChecked()) {
					grpContainers.setVisible(true);
					updatePageStatus();
				} else {
					grpContainers.setVisible(false);
				}
			}
		}
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
		dataModel.getCustomParameters().clear();
		for (TableItem item : tblParameters.getItems()) {
			dataModel.getCustomParameters().put(item.getText(0), item.getText(1));
		}
	}
}
