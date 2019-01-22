/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.esb.docker.job;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.wso2.developerstudio.eclipse.esb.docker.wizard.ExportAndGenerateDockerImageWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class GenerateDockerImageJob extends Job {

    private String workingDirectory;
    private String serverHome;
    private String deploymentDirectory;
    private String destinationDirectory;
    private String serverLocation;
    private ExportAndGenerateDockerImageWizard callingWizard;
    private File carbonFile;

    public GenerateDockerImageJob(String workingDir, String serverLocation, String serverHome, String deploymentDir,
            String destinationDir, ExportAndGenerateDockerImageWizard callingWizard, File carbonFile) {
        super("Generating Docker Image...");
        this.workingDirectory = workingDir;
        this.serverHome = serverHome;
        this.deploymentDirectory = deploymentDir;
        this.destinationDirectory = destinationDir;
        this.serverLocation = serverLocation;
        this.callingWizard = callingWizard;
        this.carbonFile = carbonFile;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {

        String operationText = "Preparing files... ";
        monitor.beginTask(operationText, 100);
        try {
            operationText = "Copying files...";
            monitor.subTask(operationText);
            monitor.worked(20);
            FileUtils.copyDirectory(new File(serverLocation), new File(workingDirectory));

            operationText = "Copying CAR application...";
            monitor.subTask(operationText);
            monitor.worked(20);

            // Clear the deployment directory
            org.apache.commons.io.FileUtils.cleanDirectory(new File(deploymentDirectory));

            // Copy CAR file to the deployment directory
            FileUtils.copyFile(carbonFile.getAbsolutePath(),
                    deploymentDirectory + File.separator + carbonFile.getName());

            // Remove temporary CAR file
            org.apache.commons.io.FileUtils.deleteQuietly(carbonFile);

            monitor.worked(60);

        } catch (Exception e) {
            operationText = e.getMessage();
            monitor.beginTask(operationText, 100);
            monitor.worked(0);
            monitor.setCanceled(true);
        }

        monitor.worked(100);
        monitor.done();
        return Status.OK_STATUS;
    }

}
