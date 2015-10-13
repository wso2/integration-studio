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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.Connector;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.ConnectorStore;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ImportCloudConnectorWizardPage extends WizardPage {
	private Text txtCloudConnectorPath;
	private Text txtConnectorStoreURL;
	private String cloudConnectorPath;
	private IProject selectedProject;
	private List<Connector> connectorList;
	private Table table;
	private Button connectorStore;
	private Button fileSystem;	
	private static final String DIR_DOT_METADATA = ".metadata";
	private static final String DIR_CACHE = ".cache";
	private static final String CONNECTOR_STORE_URL = "https://store.wso2.com";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	protected ImportCloudConnectorWizardPage(IStructuredSelection selection) {
		super("import");
		setTitle("Import connector");
		setDescription("Import a connector from connector store or file system.");
		IProject project = getProject(selection);
		if (project != null) {
			setSelectedProject(project);
		}
		connectorList = new ArrayList<>();
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
				((CloudConnectorImportWizard) getWizard()).getRemoveWizardPage().setPageComplete(true);
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
				((CloudConnectorImportWizard) getWizard()).getRemoveWizardPage().setPageComplete(true);
				setPageComplete(true);
			}
		});
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		TableColumn tc2 = new TableColumn(table, SWT.CENTER);
		tc1.setText("Name");
		tc2.setText("Version");
		tc1.setWidth(390);
		tc2.setWidth(120);
		table.setHeaderVisible(true);
		table.setLayoutData(gridData);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				listConnectors();
				container.forceFocus();
			}
		});
		btnBrowse.setText("Connect");

		fileSystem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				txtCloudConnectorPath.setEnabled(true);
				btnBrowse1.setEnabled(true);

				txtConnectorStoreURL.setText("");
				txtConnectorStoreURL.setEnabled(false);
				btnBrowse.setEnabled(false);
				table.setEnabled(false);
			}
		});

		connectorStore.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				txtConnectorStoreURL.setText(CONNECTOR_STORE_URL);
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
		((CloudConnectorImportWizard) getWizard()).getRemoveWizardPage().setPageComplete(true);
		setPageComplete(true);
	}
		
	/*
	 * List available connectors
	 */
	private void listConnectors() {
		IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
		try {
			progressService.runInUI(PlatformUI.getWorkbench().getProgressService(), new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {					
					try {
						String iconCacheDirPath = getSelectedProject().getWorkspace().getRoot().getLocation().toOSString()
								+ File.separator + DIR_DOT_METADATA + File.separator + DIR_CACHE;
						File iconCacheDir = new File(iconCacheDirPath);
						if (!iconCacheDir.exists()) {
							iconCacheDir.mkdir();
						}
						int page = 1;
                        monitor.beginTask("Fetching list of connectors", 1000);
                        monitor.subTask("Searching connectors in store : page " + page);
                        List<Connector> tmpList = ConnectorStore.getConnectorInfo(txtConnectorStoreURL.getText(), page);
						while (tmpList != null && !tmpList.isEmpty()) {
                            connectorList.addAll(tmpList);
                            monitor.worked(25);
                            ++page;
                            monitor.subTask("Searching connectors in store : page " + page);
                            tmpList = ConnectorStore.getConnectorInfo(txtConnectorStoreURL.getText(), page);
						}
						int workUnit = (1000 - (25*page))/connectorList.size();
						for (Connector connector : connectorList) {
                            monitor.subTask("Fetching details of " + connector.getAttributes().getOverview_name()
                                    + " connector.");
                            String imageLocation = null;
                            TableItem item = new TableItem(table, SWT.NONE);
                            imageLocation = txtConnectorStoreURL.getText()
                                    + connector.getAttributes().getImages_thumbnail();
                            String[] segments = imageLocation.split("/");
                            String imageFileName = segments[segments.length - 1];
                            try {
                                String imageFilePath = iconCacheDir + File.separator + imageFileName;
                                File imageFile = new File(imageFilePath);
                                if (!imageFile.exists()) {
                                    // Download the thumbnail image if it is not there in the filesystem.
                                    downloadThumbnailImage(imageLocation, imageFilePath);
                                }
                                Image image = new Image(Display.getDefault(), imageFilePath);
                                Image scaled = new Image(Display.getDefault(), 55, 50);
                                GC gc = new GC(scaled);
                                gc.setAntialias(SWT.ON);
                                gc.setInterpolation(SWT.HIGH);
                                gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0,
                                        55, 50);
                                gc.dispose();
                                image.dispose();
                                item.setImage(scaled);
                            } catch (IOException e) {
                                log.error("Error while downloading " + imageFileName, e);
                            }
                            item.setText(new String[] { connector.getAttributes().getOverview_name(),
                                    connector.getAttributes().getOverview_version() });
                            item.setData(connector);
                            monitor.worked(workUnit);
                        }
                        monitor.done();
					} catch (KeyManagementException | NoSuchAlgorithmException | IOException e1) {
						log.error("Error while listing connectors", e1);
						IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e1.getMessage());
						ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error while listing connectors", e1.getMessage(), editorStatus);
                        monitor.done();
					}
				}
			}, getSelectedProject().getWorkspace().getRoot());
		} catch (InvocationTargetException | InterruptedException e) {
			log.error("Error while listing connectors", e);
		}
	}
	
	/*
	 * Download the thumbnail image from the provided URL.
	 */
	private void downloadThumbnailImage(String location, String file) throws IOException {
		URL url = new URL(location);
		InputStream in = new BufferedInputStream(url.openStream());
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));

		for (int i; (i = in.read()) != -1;) {
			out.write(i);
		}
		in.close();
		out.close();
	}
	
	@Override
	public IWizardPage getNextPage() {
		return null;
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
	
	public List<Connector> getConnectorList() {
		return connectorList;
	}

	public void setConnectorList(List<Connector> connectorList) {
		this.connectorList = connectorList;
	}
}
