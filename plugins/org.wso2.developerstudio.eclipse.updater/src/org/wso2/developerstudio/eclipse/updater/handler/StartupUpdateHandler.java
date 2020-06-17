/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.updater.handler;

import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;

public class StartupUpdateHandler implements IStartup {

    protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

     @Override
     public void earlyStartup() {
         // check if user has set startup updates
         // Read updater preferences
         // Let updater wait a minute till workspace preferences are initialized

         // UpdaterRootJob updaterRootJob = new UpdaterRootJob("Running Integration Studio updater Tool");
         // updaterRootJob.schedule();
         
         RunUpdaterRootJob updaterRootJob = new RunUpdaterRootJob("Running Integration Studio Updater Tool");
         updaterRootJob.schedule();
     }
}
