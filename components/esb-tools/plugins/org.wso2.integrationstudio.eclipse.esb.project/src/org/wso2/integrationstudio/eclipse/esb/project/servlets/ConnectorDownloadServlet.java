/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.eclipse.esb.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.eclipse.esb.project.connector.store.Connector;
import org.wso2.integrationstudio.eclipse.esb.project.exception.ConnectorException;
import org.wso2.integrationstudio.eclipse.esb.project.utils.WizardDialogUtils;

import com.google.gson.Gson;

/**
 * Servlet that handles connector downloads
 * 
 */
public class ConnectorDownloadServlet extends HttpServlet {

    private static String DOWNLOADING_CONNECTOR_MSG = "Download Connector";
    private static String DOWNLOADING_CONNECTOR_FAILED_MSG = "Failed to add connector to project!";

    /**
     * Downloads the specified connector
     * 
     * Response contains the container to be downloaded as {"data":{"id": "xx", "attributes": []}}
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String function = request.getParameter("data");
        Connector connector = new Gson().fromJson(function, Connector.class);
        
        int isCanceled = WizardDialogUtils.showSuccessMessage(
                "Click 'OK' to download the " + connector.getAttributes().getOverview_name() + " connector to the workspace.",
                DOWNLOADING_CONNECTOR_MSG, true);

        // check user action is CANCEL or not
        if (isCanceled == SWT.CANCEL) {
            return;
        }

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("{ \"status\": \"ok\"}");
        new Thread(new Runnable() {
            public void run() {
                Display.getDefault().asyncExec(new Runnable() {
                    public void run() {
                        Job downloadJob = new Job(DOWNLOADING_CONNECTOR_MSG) {
                            @Override
                            protected IStatus run(IProgressMonitor monitor) {
                                monitor.beginTask(DOWNLOADING_CONNECTOR_MSG, 100);
                                monitor.subTask(connector.getAttributes().getOverview_name() + " connector");
                                String downloadLink = connector.getAttributes().getOverview_downloadlink();
                                try {
                                    if (ConnectorServletUtil.downloadConnectorAndUpdateProjects(downloadLink)) {
                                        monitor.worked(100);
                                        monitor.done();
                                        
                                        WizardDialogUtils.showSuccessMessage(connector.getAttributes().getOverview_name()
                                                + " connector is downloaded Successfully.", DOWNLOADING_CONNECTOR_MSG, false);
                                        return Status.OK_STATUS;
                                    }
                                } catch (ConnectorException e) {
                                    WizardDialogUtils.showErrorMessage(e.getMessage(), DOWNLOADING_CONNECTOR_FAILED_MSG);
                                }
                                monitor.worked(100);
                                monitor.done();
                                return Status.CANCEL_STATUS;
                            }
                        };
                        downloadJob.schedule();
                    }
                });
            }
        }).start();
    }
}
