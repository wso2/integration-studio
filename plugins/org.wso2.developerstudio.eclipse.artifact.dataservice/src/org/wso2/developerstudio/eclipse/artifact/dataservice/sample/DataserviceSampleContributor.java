/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.artifact.dataservice.sample;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceTemplateUtils;
import org.wso2.developerstudio.eclipse.samples.contributor.AbstractSampleContributor;

public class DataserviceSampleContributor extends AbstractSampleContributor{

	static String caption="Employee Data Service";
	static ImageDescriptor image=DataServiceImageUtils.getInstance().getImageDescriptor("ds-sample-16x16.png");
	static String tooltip="Create a project containing a data service artifact";
	static String dsSampleProjectName = "EmployeeDataService";
	static ImageDescriptor wizardImage = DataServiceImageUtils.getInstance().getImageDescriptor("ds-wizard.png");
	static String resourceRelativePath = "src/main/dataservice/EmployeeDataService.dbs";
	
	public void addSampleTo(IProject project) throws Exception {
		super.addSampleTo(project);
	}
	
	public String getCaption() {
		return caption;
	}

	public String getToolTip() {
		return tooltip;
	}

	public ImageDescriptor getImage() {
		return image;
	}

	protected File getSampleResourceFile() throws IOException {
		return DataServiceTemplateUtils.getInstance().getResourceFile("samples/DataServiceSampleProject.zip");
	}
	
	 public boolean isCustomCreateSample() {
		    return false;
	 }
	 
	public String getProjectName() {
		return dsSampleProjectName;
	}
	
    public ImageDescriptor getWizardPageImage() {
    	return wizardImage ;
    }
    
	public String getResourceRelativePath() {
		return resourceRelativePath;
	}
	
}
