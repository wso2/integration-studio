/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.ui.actions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.wso2.developerstudio.appfactory.core.client.HttpsJaggeryClient;
import org.wso2.developerstudio.appfactory.core.jag.api.JagApiProperties;
import org.wso2.developerstudio.appfactory.ui.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
 

public class DeployAction implements IActionDelegate{
		
	private IStructuredSelection selection;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
    public void run(IAction action) {
		if (selection != null) {
			try {
				
				
			/*	IViewPart findView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().
				getActivePage().findView("‌​org.wso2.developerstudio.appfactory.ui.views.AppfactoryApplicationListView");
											 
				AppfactoryApplicationListView applist = (AppfactoryApplicationListView) findView;*/
				 
				IProject project = (IProject)selection.getFirstElement();
				File pomfile = project.getFile("pom.xml").getLocation().toFile();
				MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
			final Map<String, String> params = new HashMap<String, String>();
				params.put("action",
						JagApiProperties.App_BUILD_ACTION);
				params.put("stage", "Development");
				params.put("applicationKey", mavenProject.getArtifactId());
				String version =mavenProject.getVersion();
				if("SNAPSHOT".equals(version)){
					version = "trunk";
				}
				params.put("version", version);
				params.put("doDeploy", "true");
				Display.getCurrent().asyncExec(new Runnable() {
					@Override
					public void run() {
						try {
							HttpsJaggeryClient.httpPost(
									JagApiProperties.getBuildApplication(),
									params); 
						} catch (Exception e) {
							log.error("Remote method invocation Error !", e);
						}
					}
				}); 

			   } catch (Exception e) {
				  log.error("Project Pom Error !", e);  
			}
    	}
    }

    public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection;
		}
	  
    }
}
