/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.esb.project.ui.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.synapse.api.API;
import org.apache.synapse.config.xml.rest.APIFactory;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.wso2.integrationstudio.esb.project.Activator;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.utils.file.FileUtils;

public class GenerateAPIMetadataAction implements IActionDelegate {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private IStructuredSelection selection;

    public void run(IAction action) {
        openProgressDialogBox();
    }

    class GenerateAPIMetadataProgress implements IRunnableWithProgress {

        private static final int TOTAL_TIME = 100000;
        private boolean indeterminate;
        private int TIME_INTERVAL = 1;
        private IProgressMonitor monitor;
        private ScheduledExecutorService scheduledExecutorService;
        private Shell currentShell = MetadataGenerationUtil.getShell();

        public GenerateAPIMetadataProgress(boolean indeterminate) {
            this.indeterminate = indeterminate;
        }

        @Override
        public void run(IProgressMonitor mon) throws InvocationTargetException, InterruptedException {
            monitor = mon;
            monitor.beginTask("Generating API Metadata", indeterminate ? IProgressMonitor.UNKNOWN : TOTAL_TIME);
            Thread.sleep(500);

            scheduledExecutorService = Executors.newScheduledThreadPool(1);

            ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    try {
                        IProject esbProject = MetadataGenerationUtil.getSelectedProject(selection);
                        if (esbProject == null) {
                            throw new Exception();
                        }
                        IFolder metadataLocation = esbProject.getFolder("src/main/resources/metadata");
                        boolean isMetadataLocationExists = true;
                        // create resources/metadata folder if not exists
                        if (!metadataLocation.exists()) {
                            isMetadataLocationExists = false;
                            String parentPath = esbProject.getLocation().toOSString();
                            File metadataFolder = new File(parentPath + File.separator + "src" + File.separator + "main"
                                    + File.separator + "resources" + File.separator + "metadata");
                            metadataFolder.mkdirs();
                        }

                        // read artifact.xml file
                        ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
                        esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
                        List<ESBArtifact> artifactEntries = esbProjectArtifact.getAllESBArtifacts();
                        boolean isESBArtifactEntriesChanged = false;

                        // iterate through existing apis and create metadata files
                        IContainer apiLocation = esbProject.getFolder("src/main/synapse-config/api");
                        IResource[] apiArtifacts = apiLocation.members();
                        for (IResource artifact : apiArtifacts) {
                            String artifactName = FilenameUtils.removeExtension(artifact.getName());
                            IFile metadataFiles = metadataLocation.getFile(artifactName + "_metadata.yaml");
                            IFile swaggerFiles = metadataLocation.getFile(artifactName + "_swagger.yaml");
                            if (isMetadataLocationExists && metadataFiles.exists() && swaggerFiles.exists()) {
                                continue;
                            } else
                                // get groupId and version of the artifact
                                for (ESBArtifact entry : artifactEntries) {
                                    if (entry.getName().equals(artifactName)) {
                                        isESBArtifactEntriesChanged = true;

                                        // read api artifact
                                        File file = artifact.getLocation().toFile();
                                        String fileContent = FileUtils.getContentAsString(file);
                                        OMElement omElement = AXIOMUtil.stringToOM(fileContent);
                                        API synapseApi = APIFactory.createAPI(omElement);
                                        if (!metadataFiles.exists()) {
                                            // create metadata file
                                            MetadataGenerationUtil.createMedataFile(metadataLocation, synapseApi,
                                                    artifactName);
                                            // create artifact.xml entry for metadata
                                            MetadataGenerationUtil.createArtifactXMLEntryForAPIMetadata(
                                                    esbProjectArtifact, esbProject, metadataLocation, artifactName,
                                                    entry.getGroupId() + ".metadata", entry.getVersion(), false);
                                        }

                                        if (!swaggerFiles.exists()) {
                                            // create swagger file
                                            MetadataGenerationUtil.createSwaggerYAMLForAPIs(metadataLocation,
                                                    synapseApi, artifactName);
                                            // create artifact.xml entry for swagger
                                            MetadataGenerationUtil.createArtifactXMLEntryForAPIMetadata(
                                                    esbProjectArtifact, esbProject, metadataLocation, artifactName,
                                                    entry.getGroupId() + ".metadata", entry.getVersion(), true);
                                        }
                                        break;
                                    }
                                }
                        }

                        String message;
                        // write changes to artifact.xml
                        if (isESBArtifactEntriesChanged) {
                            esbProjectArtifact.toFile();
                            message = "Metadata artifacts generated for the APIs successfully";
                        } else {
                            message = "Metadata artifacts already exists for the APIs";
                        }
                        esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                        Display.getDefault().syncExec(new Runnable() {
                            public void run() {
                                MessageDialog.openInformation(currentShell, "Generating Metadata Artifacts", message);

                            }
                        });
                    } catch (Exception e) {
                        String message = "Error while generating metadata for API artifacts" + e.getMessage();
                        if (currentShell != null) {
                            Display.getDefault().syncExec(new Runnable() {
                                public void run() {
                                    MessageDialog.openError(currentShell, "Generating Metadata Artifacts", message);

                                }
                            });
                        }
                        log.error(message, e);
                    }
                    scheduledExecutorService.shutdown();
                }
            }, 0, TIME_INTERVAL, TimeUnit.SECONDS);
            scheduledExecutorService.awaitTermination(120, TimeUnit.SECONDS);
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        }
    }

    private void openProgressDialogBox() {
        ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(MetadataGenerationUtil.getShell());
        try {
            progressMonitorDialog.run(true, true, new GenerateAPIMetadataProgress(true));
        } catch (Exception e) {
            log.error("Exception", e);
        }
    }
}
