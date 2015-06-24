/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.Connector;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.ConnectorData;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.ConnectorStore;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ImportCloudConnectorWizardPage extends WizardPage {
	private Text txtCloudConnectorPath;
	private Text txtConnectorStoreURL;
	private String cloudConnectorPath;
	private IProject selectedProject;
	private ConnectorData connectorData;
	private Table table;
	private Button connectorStore;
	private Button fileSystem;	

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	protected ImportCloudConnectorWizardPage(IStructuredSelection selection) {
		super("import");
		setTitle("Import connector");
		setDescription("Import a connector from connector store or file system.");
		IProject project = getProject(selection);
		if (project != null) {
			setSelectedProject(project);
		}
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		fileSystem = new Button(container, SWT.RADIO);
		fileSystem.setText("Connector location");
		fileSystem.setSelection(true);

		txtCloudConnectorPath = new Text(container, SWT.BORDER);
		GridData gd_txtPath1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtPath1.widthHint = 300;
		txtCloudConnectorPath.setLayoutData(gd_txtPath1);
		txtCloudConnectorPath.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setCloudConnectorPath(txtCloudConnectorPath.getText());
				txtCloudConnectorPath.setFocus();
				int charcount = txtCloudConnectorPath.getCharCount();
				txtCloudConnectorPath.setSelection(charcount);
				validate();
			}
		});
		if (cloudConnectorPath != null) {
			txtCloudConnectorPath.setText(cloudConnectorPath);
		} else {
			setPageComplete(false);
		}

		final Button btnBrowse1 = new Button(container, SWT.NONE);
		btnBrowse1.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDlg = new FileDialog(getShell());
				String fileName = fileDlg.open();
				if (fileName != null) {
					txtCloudConnectorPath.setText(fileName);
				}
				validate();
			}
		});
		btnBrowse1.setText("Browse..");

		connectorStore = new Button(container, SWT.RADIO);
		connectorStore.setText("Connector Store location");
		txtConnectorStoreURL = new Text(container, SWT.BORDER);
		GridData gd_txtPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtPath.widthHint = 300;
		txtConnectorStoreURL.setLayoutData(gd_txtPath);
		txtConnectorStoreURL.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setCloudConnectorPath(txtConnectorStoreURL.getText());
				txtConnectorStoreURL.setFocus();
				int charcount = txtConnectorStoreURL.getCharCount();
				txtConnectorStoreURL.setSelection(charcount);
				setErrorMessage(null);
				setPageComplete(true);
				// validate();
			}
		});
		if (cloudConnectorPath != null) {
			txtConnectorStoreURL.setText(cloudConnectorPath);
		} else {
			// setPageComplete(false);
		}
		txtConnectorStoreURL.setEnabled(false);

		final Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.setEnabled(false);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		gridData.verticalSpan = 7;
		gridData.grabExcessVerticalSpace = true;
		gridData.heightHint = 400;
		gridData.widthHint = 250;

		table = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setEnabled(false);
		table.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				setErrorMessage(null);
				setPageComplete(true);
			}
		});
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		TableColumn tc2 = new TableColumn(table, SWT.CENTER);
		tc1.setText("Name");
		tc2.setText("Version");
		tc1.setWidth(350);
		tc2.setWidth(70);
		table.setHeaderVisible(true);
		table.setLayoutData(gridData);
		btnBrowse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				connectorData = new ConnectorStore().getConnectorInfo(txtConnectorStoreURL.getText());
				for (Connector connector : connectorData.getConnector()) {
					URL url = null;
					String imageLocation = null;
					TableItem item = new TableItem(table, SWT.NONE);
					try {
						// Adding thumbnail image for the table item. 
						imageLocation = txtConnectorStoreURL.getText() + "/store/storage/esbconnector/"
								+ connector.getId() + "/" + connector.getAttributes().getImages_thumbnail();
						url = new URL(imageLocation);
						Image checkedImage = ImageDescriptor.createFromURL(url).createImage();
						Image scaled = new Image(Display.getDefault(), 55, 50);
						GC gc = new GC(scaled);
						gc.setAntialias(SWT.ON);
						gc.setInterpolation(SWT.HIGH);
						gc.drawImage(checkedImage, 0, 0, checkedImage.getBounds().width, checkedImage.getBounds().height,
								0, 0, 55, 50);
						gc.dispose();
						checkedImage.dispose();
						item.setImage(scaled);
					} catch (MalformedURLException malformedURLException) {
						log.error("Malformed connector URL provided : " + imageLocation, malformedURLException);
					}
					item.setText(new String[] { connector.getAttributes().getOverview_name(),
							connector.getAttributes().getOverview_version() });
					item.setData(connector);
				}

			}
		});
		btnBrowse.setText("Connect");

		fileSystem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				txtCloudConnectorPath.setEnabled(true);
				btnBrowse1.setEnabled(true);

				txtConnectorStoreURL.setEnabled(false);
				btnBrowse.setEnabled(false);
				table.setEnabled(false);
			}
		});

		connectorStore.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				txtConnectorStoreURL.setEnabled(true);
				btnBrowse.setEnabled(true);
				table.setEnabled(true);

				txtCloudConnectorPath.setEnabled(false);
				btnBrowse1.setEnabled(false);
			}
		});
	}

	public static IProject getProject(Object obj){
		if (obj == null) {
			return null;
		}
		if (obj instanceof IResource) {
			return ((IResource) obj).getProject();
		} else if (obj instanceof IStructuredSelection) {
			return getProject(((IStructuredSelection) obj).getFirstElement());
		}
		return null;
	}

	private void validate() {
		if ((getCloudConnectorPath() == null || getCloudConnectorPath().equals(""))) {
			setErrorMessage("Please specify a connector path");
			setPageComplete(false);
			return;
		}
		setErrorMessage(null);
		setPageComplete(true);
	}

	public String getCloudConnectorPath() {
		return cloudConnectorPath;
	}

	public void setCloudConnectorPath(String cloudConnectorPath) {
		this.cloudConnectorPath = cloudConnectorPath;
	}

	public IProject getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}

	public ConnectorData getConnectorData() {
		return connectorData;
	}

	public void setConnectorData(ConnectorData connectorData) {
		this.connectorData = connectorData;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Button getConnectorStore() {
		return connectorStore;
	}

	public void setConnectorStore(Button connectorStore) {
		this.connectorStore = connectorStore;
	}

	public Button getFileSystem() {
		return fileSystem;
	}

	public void setFileSystem(Button fileSystem) {
		this.fileSystem = fileSystem;
	}
}
