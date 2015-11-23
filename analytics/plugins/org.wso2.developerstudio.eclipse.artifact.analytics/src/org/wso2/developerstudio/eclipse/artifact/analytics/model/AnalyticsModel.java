/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.analytics.model;

import java.io.File;

import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class AnalyticsModel extends ProjectDataModel {
	
	private File analyticsProjectLocation;
	private String analyticsProjectName;

	public String getAnalyticsProjectName() {
		return analyticsProjectName;
	}

	public void setAnalyticsProjectName(String analyticsProjectName) {
		this.analyticsProjectName = analyticsProjectName;
	}
	
	public void setAnalyticsProjectLocation(File analyticsProjectLocation) {
		this.analyticsProjectLocation=analyticsProjectLocation;
	}
	
	public File getAnalyticsProjectLocation() {
		return analyticsProjectLocation;
	}
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (key.equals(AnalyticsConstants.WIZARD_OPTION_ANALYTICS_NAME)) {
			modelPropertyValue = getAnalyticsProjectName();
		}else if(key.equals(AnalyticsConstants.WIZARD_OPTION_ANALYTICS_LOCATION)){
			modelPropertyValue = getAnalyticsProjectLocation();
		}
		return modelPropertyValue;
	}
	
	public boolean setModelPropertyValue(String key, Object data)
			throws ObserverFailedException {
		boolean returnValue = super.setModelPropertyValue(key, data);
		if (key.equals(AnalyticsConstants.WIZARD_OPTION_ANALYTICS_LOCATION)) {
			setAnalyticsProjectLocation(new File(data.toString()));
		} else if (key.equals(AnalyticsConstants.WIZARD_OPTION_ANALYTICS_NAME)) {
			setAnalyticsProjectName(data.toString());
		}
		return returnValue;
	}

}
