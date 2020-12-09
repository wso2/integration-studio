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
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.CloudDeploymentException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NetworkUnavailableException;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Application;
import org.wso2.developerstudio.eclipse.esb.cloud.model.EndpointData;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Version;
import org.wso2.developerstudio.eclipse.esb.cloud.notification.NotificationPopup;
import org.wso2.developerstudio.eclipse.esb.cloud.notification.EndpointNotificationPopup;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudDeploymentWizardConstants;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.ResponseMessageConstants;
import org.wso2.developerstudio.eclipse.esb.cloud.util.JsonUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Represents a background job to upload application to the cloud.
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
    private boolean isNewVersion;
    private IntegrationCloudServiceClient client;
    private String response;
    private EndpointData endpointData;
    private NotificationPopup popup;
    private int runtime;

    private static final int POLLING_INTERVAL = 5;
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public CloudDeploymentJob(String name, String description, String version, String carbonFileName,
            String carbonFileLocation, String iconLocation, List<Map<String, String>> tags, boolean isNewVersion,
            int runtime) {
        super("Deploying to Integration Cloud...");
        client = IntegrationCloudServiceClient.getInstance();
        this.name = name;
        this.description = description;
        this.version = version;
        this.carbonFileName = carbonFileName;
        this.carbonFileLocation = carbonFileLocation;
        this.iconLocation = iconLocation;
        this.tags = tags;
        this.isNewVersion = isNewVersion;
        this.runtime = runtime;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {

        String operationText = "Preparing to deploy the application... ";
        monitor.beginTask(operationText, 100);

        operationText = "Sending application data...";
        monitor.subTask(operationText);
        monitor.worked(10);

        try {

            showNotification();

            // Create new application / version. Response is returned once the application is created.
            client.createApplication(name, description, version, carbonFileName, carbonFileLocation, iconLocation, tags,
                    isNewVersion, runtime);

            operationText = "Fetching the endpoints...";
            monitor.subTask(operationText);
            monitor.worked(10);

            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

            Application app = client.getApplication(name);

            // Although the application is created, it takes time to create the endpoints.
            // we will poll every 5 seconds to see if the endpoints are ready.
            ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

                public void run() {
                    try {
                        Map<String, Version> versions = app.getVersions();

                        for (Map.Entry<String, Version> version : versions.entrySet()) {
                            response = client.getApplicationEndpoints(app.getApplicationType(),
                                    version.getValue().getDeploymentURL(), version.getValue().getVersionId());
                            if (null != response && !"null".equals(response)
                                    && !response.equals(ResponseMessageConstants.ErrorMessages.ENDPOINTS_ARE_LOADING)) {
                                endpointData = JsonUtils.getEndpointDataFromJson(response);
                                scheduledExecutorService.shutdown();
                            } else {
                                monitor.subTask("Loading Endpoints...");
                                Random random = new Random();
                                int value = random.nextInt(10);
                                monitor.worked(value);
                            }
                        }
                    } catch (CloudDeploymentException | InvalidTokenException | HttpClientException e) {
                        handleException(monitor, e,
                                CloudDeploymentWizardConstants.ErrorMessages.DEPLOY_TO_CLOUD_FAILED_TITLE);
                        scheduledExecutorService.shutdown();
                    } catch (NetworkUnavailableException e) {
                        handleException(monitor, e,
                                CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE);
                        scheduledExecutorService.shutdown();
                    }
                }
            }, 0, POLLING_INTERVAL, TimeUnit.SECONDS);

            scheduledExecutorService.awaitTermination(120, TimeUnit.SECONDS);

        } catch (NetworkUnavailableException e) {
            return handleException(monitor, e,
                    CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE);
        } catch (CloudDeploymentException | InvalidTokenException | InterruptedException | HttpClientException e) {
            return handleException(monitor, e, e.getMessage());
        }

        monitor.worked(100);
        monitor.done();

        showDeploymentSuccessNotification();

        return Status.OK_STATUS;
    }

    /**
     * Handles progress monitor during an exception
     * 
     * @param monitor
     * @param ex
     * @param message
     * @return status
     */
    private IStatus handleException(IProgressMonitor monitor, Exception ex, String message) {
        log.error(message, ex);
        showMessageBox(CloudDeploymentWizardConstants.ErrorMessages.DEPLOY_TO_CLOUD_FAILED_TITLE, message,
                SWT.ICON_ERROR);
        monitor.beginTask(ex.getMessage(), 100);
        monitor.worked(0);
        monitor.setCanceled(true);
        return Status.CANCEL_STATUS;
    }

    /**
     * Show message box
     * 
     * @param title
     * @param message
     * @param style
     */
    private void showMessageBox(String title, String message, int style) {

        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                popup.close();
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg = new MessageBox(shell, style);
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                exportMsg.open();
            }
        });
    }

    /**
     * Show general notification
     * 
     */
    private void showNotification() {
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                popup = new NotificationPopup(display, CloudDeploymentWizardConstants.IN_PROGRESS_DIALOG_TITLE_TEXT,
                        CloudDeploymentWizardConstants.SuccessMessages.SUCCESS_CREATING_APPLICATION_MSG);
                popup.open();
            }
        });
    }

    /**
     * Show deployment success window with endpoints
     * 
     */
    private void showDeploymentSuccessNotification() {
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                final AbstractNotificationPopup popup = new EndpointNotificationPopup(display, endpointData);
                popup.setFadingEnabled(false);
                popup.setDelayClose(0L);
                popup.open();
            }
        });

    }

}
