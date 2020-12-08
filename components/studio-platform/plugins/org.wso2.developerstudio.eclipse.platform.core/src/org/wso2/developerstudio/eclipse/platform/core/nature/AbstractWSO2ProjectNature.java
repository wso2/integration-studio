/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.nature;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public abstract class AbstractWSO2ProjectNature implements IProjectNature {

	private IProject selectedProject;

	protected void addJavaProjectNature() throws CoreException {
		IProject project = getProject();
		String[] folderList = new String[] { "src", "main", "java" };
		IFolder sourceFolder = ProjectUtils.getWorkspaceFolder(project, folderList);
		JavaUtils.addJavaSupportAndSourceFolder(project, sourceFolder);
	}

	public IProject getProject() {
		return selectedProject;
	}

	public void setProject(IProject project) {
		this.selectedProject = project;
	}
}
