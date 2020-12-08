/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.samples.contributor;

import java.io.File;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;

public interface IDeveloperStudioSampleContributor {
	String getCaption();
	String getToolTip();
	boolean isCustomCreateSample();
	ImageDescriptor getImage();
	void addSampleTo(IProject project) throws Exception;
	void addSampleTo(File location) throws Exception;
	void addSampleTo(IFolder workspaceLocation) throws Exception;
	void createSample(Shell shell) throws Exception;
	String getProjectName();
	void setProjectName(String projectName);
	ImageDescriptor getWizardPageImage();
	String getResourceRelativePath();
}
