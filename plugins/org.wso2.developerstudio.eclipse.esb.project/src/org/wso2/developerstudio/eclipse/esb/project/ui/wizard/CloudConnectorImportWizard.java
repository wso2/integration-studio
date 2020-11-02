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
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.GMFPluginDetails;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.IUpdateGMFPlugin;
import org.wso2.developerstudio.eclipse.esb.project.utils.WizardDialogUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class CloudConnectorImportWizard extends AbstractWSO2ProjectCreationWizard {

    private ImportCloudConnectorWizardPage storeWizardPage;
    private RemoveCloudConnectorWizardPage removeWizardPage;
    private ImportRemoveSelectionWizardPage selectionPage;
    private static final String DIR_DOT_METADATA = ".metadata";
    private static final String DIR_CONNECTORS = ".Connectors";
    private static final String ADD_CONNECTOR_FAILURE_MSG = "Failed to add connector/module";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle("Add or Remove Connectors/Modules");
        selectionPage = new ImportRemoveSelectionWizardPage(selection);
        storeWizardPage = new ImportCloudConnectorWizardPage(selection);
        removeWizardPage = new RemoveCloudConnectorWizardPage(selection);
    }

    /**
     * Adding wizard pages
     */
    public void addPages() {
        addPage(selectionPage);
        addPage(storeWizardPage);
        addPage(removeWizardPage);
        super.addPages();
    }

    /**
     * Importing connector zip file to Developer Studio either from fileSystem or connector store.
     */
    public boolean performFinish() {
        if (storeWizardPage.equals(getContainer().getCurrentPage())) {
            if (null != storeWizardPage.getCloudConnectorPath() && "" != storeWizardPage.getCloudConnectorPath()) {
                return performFinishFileSystem();
            }
        } else if (removeWizardPage.equals(getContainer().getCurrentPage())) {
            return performFinishRemove();
        }
        return true;
    }

    /**
     * This method will extract connector zip file to the relevant location when user has selected import from file
     * system option.
     */
    private boolean performFinishFileSystem() {
        String source = storeWizardPage.getCloudConnectorPath();
        String[] values = source.split(", ");
        try {
            String parentDirectoryPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                    + File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
            File parentDirectory = new File(parentDirectoryPath);
            if (!parentDirectory.exists()) {
                parentDirectory.mkdir();
            }
            for (String value : values) {
                File file = new File(value);
                FileUtils.copyFileToDirectory(file, parentDirectory);
                updateProjects(value);
            }
        } catch (ZipException e) {
            log.error("Error while extracting the connector zip : " + source, e);
            WizardDialogUtils.showErrorMessage("Error while extracting the connector zip : " + source,
                    ADD_CONNECTOR_FAILURE_MSG);
        } catch (CoreException e) {
            log.error("Cannot refresh the project", e);
            WizardDialogUtils.showErrorMessage("Cannot refresh the project", ADD_CONNECTOR_FAILURE_MSG);
        } catch (IOException e) {
            log.error("Error while copying the connector zip : " + source, e);
            WizardDialogUtils.showErrorMessage("Error while copying the connector zip : " + source,
                    ADD_CONNECTOR_FAILURE_MSG);
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

                    // Remove the archived connector.
                    File zipFile = new File(filePath + ".zip");
                    zipFile.delete();
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
                .toOSString() + File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
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
