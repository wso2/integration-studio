/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.web.dashboard;

import java.io.File;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.artifact.analytics.ui.wizard.AnalyticsProjectCreationWizard;
import org.wso2.developerstudio.eclipse.general.project.ui.wizard.GeneralProjectWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.model.MavenInfo;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.webui.core.editor.AbstractEditorFunctionExecutor;

public class DashboardFunctionExecutor implements AbstractEditorFunctionExecutor {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	@Override
	public Object executeFunction(String functionName, Object[] args) {
		
		if (functionName.equals("newAnalyticsProject")) {
			AnalyticsProjectCreationWizard wizard = new AnalyticsProjectCreationWizard();
			JSONObject projectObj = null;
			try {
				projectObj = new JSONObject((String)args[1]);
			} catch (JSONException jsonException) {
				log.error("Received invalid (JSON)configuration for the project", jsonException);
				return jsonException.getMessage();
			}
			
			ProjectDataModel analyticsProjectModel = ((AbstractWSO2ProjectCreationWizard)wizard).getModel();
			try {
				analyticsProjectModel.setSelectedOption("new.analyticsProject");
				analyticsProjectModel.setProjectName((String)projectObj.get("name"));
				analyticsProjectModel.setLocation(new File((String)projectObj.get("location")));
				JSONObject mavenObj = (JSONObject) projectObj.get("mavenInfo");
				MavenInfo mavenInfo = new MavenInfo((String)mavenObj.getString("groupId"),
													(String)mavenObj.getString("artifactId"), 
													(String)mavenObj.getString("version"));
				analyticsProjectModel.setMavenInfo(mavenInfo);
				
			} catch (ObserverFailedException | JSONException e) {
				log.error("Invalid (JSON)configuration", e);
				return e.getMessage();
			}
			return wizard.performFinish();
		} if (functionName.equals("getWorkspaceLocation")) {
			String location = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
			return location;
		}if (functionName.equals("newGeneralProject")) {
			GeneralProjectWizard wizard = new GeneralProjectWizard();
			JSONObject projectObj = null;
			try {
				projectObj = new JSONObject((String)args[1]);
			} catch (JSONException jsonException) {
				log.error("Received invalid (JSON)configuration for the project", jsonException);
				return jsonException.getMessage();
			}
			
			ProjectDataModel generalProjectModel = ((AbstractWSO2ProjectCreationWizard)wizard).getModel();
			try {
				//generalProjectModel.setSelectedOption("new.analyticsProject");
				generalProjectModel.setProjectName((String)projectObj.get("name"));
				generalProjectModel.setLocation(new File((String)projectObj.get("location")));
				JSONObject mavenObj = (JSONObject) projectObj.get("mavenInfo");
				MavenInfo mavenInfo = new MavenInfo((String)mavenObj.getString("groupId"),
													(String)mavenObj.getString("artifactId"), 
													(String)mavenObj.getString("version"));
				generalProjectModel.setMavenInfo(mavenInfo);
				
			} catch (ObserverFailedException | JSONException e) {
				log.error("Invalid (JSON)configuration", e);
				return e.getMessage();
			}
			
			return wizard.performFinish();
		}
		return false;
	}

}
