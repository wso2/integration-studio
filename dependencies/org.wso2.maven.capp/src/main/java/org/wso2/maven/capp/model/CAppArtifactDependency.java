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

package org.wso2.maven.capp.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.capp.utils.CAppArtifactPriorityMapping;

public class CAppArtifactDependency implements Comparable<CAppArtifactDependency> {
	
	private CAppArtifact cAppArtifact;
	private Dependency mavenDependency;
	private File[] artifactFiles;
	private boolean dummyDependency=false;
	
	public CAppArtifactDependency(Dependency mavenDependency,String serverRole) throws MojoExecutionException {
		setMavenDependency(mavenDependency);
		Artifact resolvedArtifactPom = CAppMavenUtils.getResolvedArtifactPom(mavenDependency, CAppMavenUtils.getArtifactFactory(), CAppMavenUtils.getRemoteRepositories(), CAppMavenUtils.getLocalRepository(), CAppMavenUtils.getResolver());
		MavenProject mavenProject = CAppMavenUtils.getMavenProject(resolvedArtifactPom.getFile());
		setcAppArtifact(new CAppArtifact(mavenProject,serverRole));
	}
	
	public CAppArtifactDependency(MavenProject project, String type, String serverRole) {
		setcAppArtifact(new CAppArtifact(project,serverRole));
		getMavenDependency().setType(type);
	}
	
	public String getDependencyId(){
		return cAppArtifact.getId();
	}
	
	public String getName() {
			return cAppArtifact.getName();
	}

	public String getVersion() {
			return cAppArtifact.getVersion();
	}

	private Dependency createMavenDependency() {
		Dependency mavenDependency = new Dependency();
		MavenProject project = cAppArtifact.getProject();
		mavenDependency.setGroupId(project.getGroupId());
		mavenDependency.setArtifactId(project.getArtifactId());
		mavenDependency.setVersion(project.getVersion());
		mavenDependency.setScope(CAppMavenUtils.CAPP_SCOPE_PREFIX);
		return mavenDependency;
	}

	public void setArtifactFiles(File[] artifactFiles) {
		this.artifactFiles = artifactFiles;
	}
	
	public File[] getCappArtifactFile() throws MojoExecutionException, IOException{
		if (artifactFiles == null) {
			Artifact resolvedArtifact;
			if (null != getMavenDependency().getScope()) {
				String artifactSystemPath = getArtifactSystemPath();
				if (null != artifactSystemPath) {
					resolvedArtifact = CAppMavenUtils.getResolvedArtifact(getMavenDependency(), CAppMavenUtils
							.getArtifactFactory(), CAppMavenUtils.getRemoteRepositories(), CAppMavenUtils
							.getLocalRepository(), CAppMavenUtils.getResolver(), getMavenDependency().getScope(),
							artifactSystemPath);
				} else {
					resolvedArtifact = CAppMavenUtils.getResolvedArtifact(getMavenDependency(), CAppMavenUtils
							.getArtifactFactory(), CAppMavenUtils.getRemoteRepositories(), CAppMavenUtils
							.getLocalRepository(), CAppMavenUtils.getResolver(), getMavenDependency().getScope(),
							getMavenDependency().getSystemPath());
				}
			} else {
				resolvedArtifact = CAppMavenUtils.getResolvedArtifact(getMavenDependency(),
						CAppMavenUtils.getArtifactFactory(), CAppMavenUtils.getRemoteRepositories(),
						CAppMavenUtils.getLocalRepository(), CAppMavenUtils.getResolver(),
						CAppMavenUtils.CAPP_SCOPE_PREFIX, null);
			}

			File mavenArtifact = resolvedArtifact.getFile();
			String[] split = mavenArtifact.getName().split("\\.");
			if (getcAppArtifact().getType().equals("registry/resource")) {
				File tempDirectory = FileUtils.createTempDirectory();
				FileUtils.extract(mavenArtifact, tempDirectory);
				File[] listFiles = tempDirectory.listFiles();
				for (File file : listFiles) {
					if (file.isFile()
							&& file.getName().toLowerCase().endsWith(".xml")) {
						getcAppArtifact().setFile(file.getName());
					}
				}
				artifactFiles=listFiles;
			} else {
				getcAppArtifact().setFile(mavenArtifact.getName());
				artifactFiles = new File[] { mavenArtifact };
			}
		}
		return artifactFiles;
	}

	private String getArtifactSystemPath() throws IOException {
		Dependency artifactDependency = getMavenDependency();

		if (null != artifactDependency.getSystemPath()) {
			// Generate system path for xml based artifacts
			if (CAppMavenUtils.XML_DEPENDENCY_TYPE.equals(artifactDependency.getType())) {
				String artifactName = artifactDependency.getArtifactId().concat(
						"-" + artifactDependency.getVersion() + "." + CAppMavenUtils.XML_DEPENDENCY_TYPE);
				String pomFileSystemPath = artifactDependency.getSystemPath();
				return pomFileSystemPath.substring(0, pomFileSystemPath.lastIndexOf(CAppMavenUtils.POM_FILE_NAME))
						.concat(CAppMavenUtils.TARGET_DIR_NAME + File.separator + artifactName);
			} else if (CAppMavenUtils.ZIP_DEPENDENCY_TYPE.equals(artifactDependency.getType())) {
				// Generate system path for registry resources
				String artifactName = artifactDependency.getArtifactId().concat("-" + artifactDependency.getVersion());

				String pomFileSystemPath = artifactDependency.getSystemPath();
				String baseDirPath = pomFileSystemPath.substring(0,
						pomFileSystemPath.lastIndexOf(CAppMavenUtils.POM_FILE_NAME));

				String resourcesDirPath = baseDirPath.concat(CAppMavenUtils.RESOURCES_DIR_NAME);
				File resourcesDir = new File(resourcesDirPath);

				String registryInfoFilePath = baseDirPath.concat(CAppMavenUtils.REGISTRY_INFO_FILE_NAME);
				File registryInfoFile = new File(registryInfoFilePath);

				String destinationDirPath = baseDirPath.concat(artifactName);

				// Copy contents to destination directory
				FileUtils.copyDirectory(resourcesDir,
						new File(destinationDirPath.concat(File.separator + CAppMavenUtils.RESOURCES_DIR_NAME)));
				FileUtils.copy(registryInfoFile,
						new File(destinationDirPath.concat(File.separator + CAppMavenUtils.REGISTRY_INFO_FILE_NAME)));

				// Create zip file in the same directory
				String zipFilePath = destinationDirPath.concat("." + CAppMavenUtils.ZIP_DEPENDENCY_TYPE);
				File zipFile = new File(zipFilePath);
				ArchiveManipulator archiveManupulator = new ArchiveManipulator();
				archiveManupulator.archiveDir(zipFile, new File(destinationDirPath));

				// Delete the temp directory
				File destinationDir = new File(destinationDirPath);
				if (destinationDir.exists()) {
					FileUtils.deleteDir(destinationDir);
				}

				return zipFilePath;
			}

		}
		return null;
	}

	public String toString() {
	    return getCaption();
	}
	
	public String getCaption(){
		return getName()+" - "+getVersion();
	}

	public String getType() {
		return getMavenDependency().getType();
	}

	private void setcAppArtifact(CAppArtifact cAppArtifact) {
		this.cAppArtifact = cAppArtifact;
	}

	public CAppArtifact getcAppArtifact() {
		return cAppArtifact;
	}

	public String getServerRole() {
		return cAppArtifact.getServerRole();
	}

	public Dependency getMavenDependency() {
		if (mavenDependency==null){
			mavenDependency=createMavenDependency();
		}
		return mavenDependency;
	}

	public void setMavenDependency(Dependency mavenDependency) {
		this.mavenDependency = mavenDependency;
	}

	public void setDummyDependency(boolean dummyDependency) {
		this.dummyDependency = dummyDependency;
	}

	public boolean isDummyDependency() {
		return dummyDependency;
	}

	public int compareTo(CAppArtifactDependency compareArtifactDependency) {
		return CAppArtifactPriorityMapping.getPriority(this.getcAppArtifact()
				.getType())
				- CAppArtifactPriorityMapping.getPriority(compareArtifactDependency
						.getcAppArtifact().getType());
	}

}
