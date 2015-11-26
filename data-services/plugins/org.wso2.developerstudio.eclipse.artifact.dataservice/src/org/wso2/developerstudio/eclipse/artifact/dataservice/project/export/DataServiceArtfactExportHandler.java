/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.artifact.dataservice.project.export;

import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataServiceArtfactExportHandler extends ProjectArtifactHandler {

	private static final String ARTIFACT_XML = "artifact.xml";
	private static final String DBS_FILE_EXTENSION = "dbs";
	private static final String POM_FILE = "pom.xml";
	private static final String GROUP_ID = "org.wso2.maven";
	private static final String ARTIFACT_ID = "maven-dataservice-plugin";
	private static final String ARTIFACT_TAG = "artifact";
	private static final String TARGET = "target";

	public List<IResource> exportArtifact(IProject project) throws Exception {
		String projectPath = project.getLocation().toFile().toString();
		List<IResource> exportResources = new ArrayList<IResource>();
		clearTarget(project);
		IFile pomFile = project.getFile(POM_FILE);
		IFile artifactXMLFile = project.getFile(ARTIFACT_XML);
		if (artifactXMLFile.exists()) {
			if (pomFile.exists()) {
				MavenProject mavenProject = MavenUtils.getMavenProject(pomFile
						.getLocation().toFile());
				List<Plugin> plugins = mavenProject.getBuild().getPlugins();
				for (Plugin plugin : plugins) {
					if (plugin.getArtifactId().equals(ARTIFACT_ID)
							&& plugin.getGroupId().equals(GROUP_ID)) {
						Xpp3Dom[] artifactNodes = ((Xpp3Dom) plugin
								.getConfiguration()).getChildren(ARTIFACT_TAG);
						for (Xpp3Dom artifactNode : artifactNodes) {
							String dbsFile = artifactNode.getValue();
							String[] pathArray = dbsFile.split("/");
							IFile dbsFileRef = project
									.getFolder(
											DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER)
									.getFile(pathArray[pathArray.length - 1]);
							if (dbsFileRef.exists()) {
								exportResources.add((IResource) dbsFileRef);
							}
						}
					}
				}
			} else {
				File[] dbsFiles = FileUtils.getAllMatchingFiles(project
						.getLocation().toString(), null, DBS_FILE_EXTENSION,
						new ArrayList<File>());
				for (File dbsFile : dbsFiles) {
					String filePath = dbsFile.toString();
					// excluded any files inside target dir
					if (!filePath.substring(projectPath.length()).startsWith(
							File.separator + TARGET + File.separator)) {
						IFile dbsFileRef = ResourcesPlugin
								.getWorkspace()
								.getRoot()
								.getFileForLocation(
										Path.fromOSString(dbsFile
												.getAbsolutePath()));
						exportResources.add((IResource) dbsFileRef);
					}
				}
			}
		} else {
			if (pomFile.exists()) {
				MavenProject mavenProject = MavenUtils.getMavenProject(pomFile
						.getLocation().toFile());
				List<Plugin> plugins = mavenProject.getBuild().getPlugins();
				for (Plugin plugin : plugins) {
					if (plugin.getArtifactId().equals(
							"maven-dataservice-plugin")
							&& plugin.getGroupId().equals("org.wso2.maven")) {
						Xpp3Dom artifactNode = ((Xpp3Dom) plugin
								.getConfiguration()).getChild("artifact");
						String dbsFile = artifactNode.getValue();
						String[] pathArray = dbsFile.split("/");
						IFile dbsFileRef = project.getFolder("src")
								.getFolder("main").getFolder("dataservice")
								.getFile(pathArray[pathArray.length - 1]);
						if (dbsFileRef.exists()) {
							exportResources.add((IResource) dbsFileRef);
						}
					}
				}
			} else {
				File[] dbsFiles = FileUtils.getAllMatchingFiles(project
						.getLocation().toString(), null, DBS_FILE_EXTENSION,
						new ArrayList<File>());
				for (File dbsFile : dbsFiles) {
					String filePath = dbsFile.toString();
					// excluded any files inside target dir
					if (!filePath.substring(projectPath.length()).startsWith(
							File.separator + "target" + File.separator)) {
						IFile dbsFileRef = ResourcesPlugin
								.getWorkspace()
								.getRoot()
								.getFileForLocation(
										Path.fromOSString(dbsFile
												.getAbsolutePath()));
						exportResources.add((IResource) dbsFileRef);
					}
				}
			}
		}
		return exportResources;
	}
}

