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

package org.wso2.developerstudio.eclipse.platform.ui.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Parent;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard.MvnMultiModuleModel;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class MavenParentProjectList extends AbstractListDataProvider {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		boolean requiredParent = ((MvnMultiModuleModel) model).isRequiredParent();
		boolean updateMode = ((MvnMultiModuleModel) model).isUpdateMode();
		if (requiredParent && !updateMode) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot root = workspace.getRoot();
			IProject[] projects = root.getProjects();
			for (IProject project : projects) {
				try {
					if (project.isOpen()) {
						File pomFile = project.getFile("pom.xml").getLocation().toFile();
						if (pomFile.exists()) {
							MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
							if (mavenProject.getPackaging().equals("pom")) {
								Parent parent = new Parent();
								parent.setArtifactId(mavenProject.getArtifactId());
								parent.setGroupId(mavenProject.getGroupId());
								parent.setVersion(mavenProject.getVersion());
								try {
									String relativePath = FileUtils.getRelativePath(model.getLocation(), pomFile);
									parent.setRelativePath(relativePath);
									ListData data = new ListData(parent.getArtifactId(), parent);
									list.add(data);
								} catch (Exception e) {
									log.error(e.getMessage(), e);
								}

							}
						}
					}
				} catch (Exception e) {
					log.error("Error reading project list", e);
				}
			}
		}
		return list;
	}

}
