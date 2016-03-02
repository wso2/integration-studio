/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.Connector;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.GMFPluginDetails;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.IUpdateGMFPlugin;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

public class CloudConnectorImportWizard extends AbstractWSO2ProjectCreationWizard {

	private static final int BUFFER_SIZE = 4096;
	private ImportCloudConnectorWizardPage storeWizardPage;
	private RemoveCloudConnectorWizardPage removeWizardPage;
	private ImportRemoveSelectionWizardPage selectionPage;
	private static final String DIR_DOT_METADATA = ".metadata";
	private static final String DIR_CONNECTORS = ".Connectors";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public CloudConnectorImportWizard() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
			if (selection != null) {
				selectionPage = new ImportRemoveSelectionWizardPage(selection);
				storeWizardPage = new ImportCloudConnectorWizardPage(selection);
				removeWizardPage = new RemoveCloudConnectorWizardPage(selection);
				setWindowTitle("Add or Remove Connectors");
			}
		}
	}

	/**
	 * Adding wizard pages
	 */
	public void addPages() {
		addPage(selectionPage);
		addPage(storeWizardPage);
		addPage(removeWizardPage);
	}

	/**
	 * Importing connector zip file to Developer Studio either from fileSystem or connector store.
	 */
	public boolean performFinish() {
		if (storeWizardPage.equals(getContainer().getCurrentPage())) {
			if (storeWizardPage.getConnectorStore().getSelection()) {
				return performFinishStore();
			} else if (storeWizardPage.getFileSystem().getSelection()) {
				return performFinishFileSystem();
			}
		} else if (removeWizardPage.equals(getContainer().getCurrentPage())) {
			return performFinishRemove();
		}
		return false;
	}

	/**
	 * This method will download the connector zip file and extract it to the relevant location when user has selected
	 * import from connector store option.
	 */
    private boolean performFinishStore() {
        final List<Connector> selectedConnectors = new ArrayList<>();
        for (TableItem tableItem : storeWizardPage.getTable().getItems()) {
            if (tableItem.getChecked()) {
                selectedConnectors.add((Connector) tableItem.getData());
            }
        }
        Job downloadJob = new Job("Downloading Connectors") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                int noOfConnectors = selectedConnectors.size();
                int count = 1;
                monitor.beginTask("Downloading connector", noOfConnectors);
                for (Connector connector : selectedConnectors) {
                    monitor.subTask(count + " of " + noOfConnectors + " : "
                            + connector.getAttributes().getOverview_name() + " connector");
                    String downloadLink = connector.getAttributes().getOverview_downloadlink();
                    downloadConnectorAndUpdateProjects(downloadLink);
                    monitor.worked(1);
                    count++;
                }
                monitor.done();
                return Status.OK_STATUS;
            }
        };
        downloadJob.schedule();
        return true;
    }
	

	/**
	 * This method will extract connector zip file to the relevant location when user has selected import from file
	 * system option.
	 */
	private boolean performFinishFileSystem() {
		String source = storeWizardPage.getCloudConnectorPath();
		try {
			String parentDirectoryPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
					+ File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
			File parentDirectory = new File(parentDirectoryPath);
			if (!parentDirectory.exists()) {
				parentDirectory.mkdir();
			}
			File file = new File(source);
			FileUtils.copyFileToDirectory(file, parentDirectory);

			updateProjects(source);
		} catch (ZipException e) {
			log.error("Error while extracting the connector zip : " + source, e);
		} catch (CoreException e) {
			log.error("Cannot refresh the project", e);
		} catch (IOException e) {
			log.error("Error while copying the connector zip : " + source, e);
		}
		return true;
	}

	/**
	 * This method will remove selected connectors from the file system.
	 */
	private boolean performFinishRemove() {
		for (TableItem tableItem : removeWizardPage.getTable().getItems()) {
			if (tableItem.getChecked()) {
				String filePath = ((org.wso2.developerstudio.eclipse.esb.project.ui.wizard.Connector) tableItem
						.getData()).getConnectorFilePath();
				try {
					FileUtils.deleteDirectory(new File(filePath));
				} catch (IOException e) {
					log.error("Error while deleting the connector : " + filePath, e);
				}
			}
		}
		try {
			IUpdateGMFPlugin updateGMFPlugin = GMFPluginDetails.getiUpdateGMFPlugin();
			if (updateGMFPlugin != null) {
				updateGMFPlugin.updateOpenedEditors();
			}
			// Refresh the project.
			removeWizardPage.getSelectedProject().refreshLocal(IResource.DEPTH_INFINITE, null);
			return true;
		} catch (CoreException e) {
			log.error("Error while refreshing projects after deleting connectors ", e);
		}
		return false;
	}

	private void updateProjects(String source) throws ZipException, CoreException {
		ZipFile zipFile = new ZipFile(source);
		String[] segments = source.split(Pattern.quote(File.separator));
		String zipFileName = segments[segments.length - 1].split(".zip")[0];
		String parentDirectoryPath = storeWizardPage.getSelectedProject().getWorkspace().getRoot().getLocation()
				.toOSString()
				+ File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
		File parentDirectory = new File(parentDirectoryPath);
		if (!parentDirectory.exists()) {
			parentDirectory.mkdir();
		}
		String zipDestination = parentDirectoryPath + File.separator + zipFileName;
		zipFile.getFile();
		zipFile.extractAll(zipDestination);
		IUpdateGMFPlugin updateGMFPlugin = GMFPluginDetails.getiUpdateGMFPlugin();
		if (updateGMFPlugin != null) {
			updateGMFPlugin.updateOpenedEditors();
		}
		/*
		 * Refresh the project.
		 */
		storeWizardPage.getSelectedProject().refreshLocal(IResource.DEPTH_INFINITE, null);
	}

	private boolean downloadConnectorAndUpdateProjects(String downloadLink) {
		String zipDestination = null;
		try {
			URL url = new URL(downloadLink);
			String[] segments = downloadLink.split("/");
			String zipFileName = segments[segments.length - 1];
			String parentDirectoryPath = storeWizardPage.getSelectedProject().getWorkspace().getRoot().getLocation()
					.toOSString()
					+ File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
			File parentDirectory = new File(parentDirectoryPath);
			if (!parentDirectory.exists()) {
				parentDirectory.mkdir();
			}
			zipDestination = parentDirectoryPath + File.separator + zipFileName;
			InputStream is = url.openStream();
			File targetFile = new File(zipDestination);
			targetFile.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(targetFile);
			int bytesRead = -1;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((bytesRead = is.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.close();
			is.close();
			updateProjects(zipDestination);
			return true;
		} catch (ZipException e) {
			log.error("Error while extracting the connector zip : " + zipDestination, e);
		} catch (CoreException e) {
			log.error("Cannot refresh the project", e);
		} catch (MalformedURLException malformedURLException) {
			log.error("Malformed connector URL provided : " + downloadLink, malformedURLException);
		} catch (IOException e) {
			log.error("Error while downloading connector : " + downloadLink, e);
		}
		return false;
	}

	public ImportCloudConnectorWizardPage getStoreWizardPage() {
		return storeWizardPage;
	}

	public void setStoreWizardPage(ImportCloudConnectorWizardPage storeWizardPage) {
		this.storeWizardPage = storeWizardPage;
	}

	public RemoveCloudConnectorWizardPage getRemoveWizardPage() {
		return removeWizardPage;
	}

	public void setRemoveWizardPage(RemoveCloudConnectorWizardPage removeWizardPage) {
		this.removeWizardPage = removeWizardPage;
	}

	@Override
	public IResource getCreatedResource() {
		return null;
	}
}
