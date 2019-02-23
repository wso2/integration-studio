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

package org.wso2.developerstudio.eclipse.esb.cloud.job;

import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NotFoundException;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Application;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Version;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudServiceConstants;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Represents a background job to generate the Docker image.
 *
 */
public class CloudDeploymentJob extends Job {

    private String name;
    private String description;
    private String version;
    private String carbonFileName;
    private String carbonFileLocation;
    private String iconLocation;
    private List<Map<String, String>> tags;
    private IntegrationCloudServiceClient client;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public CloudDeploymentJob(String name, String description, String version, String carbonFileName, String carbonFileLocation, String iconLocation, List<Map<String, String>> tags) {
        super("Deploying to Integration Cloud...");
        client = IntegrationCloudServiceClient.getInstance();
        this.name = name;
        this.description = description;
        this.version = version;
        this.carbonFileName = carbonFileName;
        this.carbonFileLocation = carbonFileLocation;
        this.iconLocation = iconLocation;
        this.tags = tags;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {

        String operationText = "Preparing files... ";
        monitor.beginTask(operationText, 100);

        operationText = "Copying files...";
        monitor.subTask(operationText);
        monitor.worked(10);

        try {
            
            operationText = "Deploying the application to the Integration Cloud...";
            monitor.subTask(operationText);
            monitor.worked(20);

            client.createApplication(name, description, version, carbonFileName, carbonFileLocation, iconLocation, tags);
            
//            if (client.getApplication("TestAppCarbonApplication")) {
//                System.out.println("Returned");
//            }
            
//            Application app = client.getApplication("TestAppCarbonApplication");
//            
//            System.out.println(app.getVersions());
            
            operationText = "Fetching the endpoints...";
            monitor.subTask(operationText);
            monitor.worked(50);
            
//           DeploymentStatusPoller te1=new DeploymentStatusPoller();
//           Timer t=new Timer();
//           t.scheduleAtFixedRate(te1, 0,5*1000);
           
            String[] response = {""};
            
            ScheduledExecutorService scheduledExecutorService =
                    Executors.newScheduledThreadPool(5);

            ScheduledFuture<?> scheduledFuture =
                scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                    public void run(){
                        try {
                        Application app = client.getApplication("TestAppCarbonApplication");
                        System.out.println("Returned" + app.getVersions());
                        
                        Map<String, Version> versions = app.getVersions();
                        
                        for (Map.Entry<String, Version> version : versions.entrySet()) {
                            response[0] = client.getApplicationEndpoints(app.getApplicationType(), version.getValue().getDeploymentURL(), version.getValue().getVersionId());
                            if(null != response[0] &&  !"null".equals(response[0])) {
//                                return response;
                                scheduledExecutorService.shutdownNow();
                            }
                        }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
//                        return null;
                    }
                },
                0,
                5,
                TimeUnit.SECONDS);

            System.out.println("result = " + response[0]);
            scheduledExecutorService.awaitTermination(200, TimeUnit.SECONDS);

        } catch (NotFoundException | InterruptedException e) {
            log.error(CloudServiceConstants.ErrorMessages.DEPLOY_TO_CLOUD_FAILED_MESSAGE, e);
            showMessageBox(CloudServiceConstants.ErrorMessages.DEPLOY_TO_CLOUD_FAILED_TITLE,
                    CloudServiceConstants.ErrorMessages.DEPLOY_TO_CLOUD_INTERNAL_ERROR_MSG, SWT.ICON_ERROR);
           
            operationText = e.getMessage();
            monitor.beginTask(operationText, 100);
            monitor.worked(0);
            monitor.setCanceled(true);
        }

        monitor.worked(100);
        monitor.done();

        showMessageBox(CloudServiceConstants.SuccessMessages.SUCCESSFUL_TITLE,
                CloudServiceConstants.SuccessMessages.DEPLOY_TO_CLOUD_SUCCESS_MESSAGE,
                SWT.ICON_INFORMATION);

        return Status.OK_STATUS;
    }

    private void showMessageBox(String title, String message, int style) {

        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg = new MessageBox(shell, style);
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                exportMsg.open();
            }
        });
    }

}
