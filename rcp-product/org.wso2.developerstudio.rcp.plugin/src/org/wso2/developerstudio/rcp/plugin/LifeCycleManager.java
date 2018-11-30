/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.rcp.plugin;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.templates.dashboard.handlers.JettyServerHandler;
import org.wso2.developerstudio.rcp.plugin.utils.RCPPluginHandlerUtils;

/**
 * This class handles the eclipse lifecycle events. In a RCP distribution we can
 * customize this to have pre launch activities before starting the workbench
 */
public class LifeCycleManager {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * This will fire once the workspece is selected in eclipse startup.
     * We use this method to start the Embedded jetty server and java version checker
     * @param appContext Eclipse Application Context
     * @param display Startup display instance
     */
    @PostContextCreate
    void postContextCreate(IApplicationContext appContext, Display display) {
        RCPPluginHandlerUtils rcpUtils = new RCPPluginHandlerUtils();
        rcpUtils.showJavaVersionChecker(display);
        JettyServerHandler.getInstance().startEmbeddedJetty(0);
    }

    @ProcessAdditions
    public void setPerspective() {
    }
}
