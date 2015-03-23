/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.maven.plugin.localentry;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * This is the Maven Mojo used for localentry resources to be copied to the output
 * directory in the resource-process phase.
 *
 * @goal package-localentry
 *
 */
public class LocalEntryMojo extends AbstractMojo {

	/**
	 * @parameter default-value="${project}"
	 */
	private MavenProject project;

	/**
	 * Maven ProjectHelper.
	 *
	 * @component
	 */
	private MavenProjectHelper projectHelper;

	/**
	 * The path of the existing artifact
	 *
	 * @parameter expression="${package-file.artifact}"
	 * @required
	 */
	private File artifact;

	/**
	 * The resulting extension of the file
	 *
	 * @parameter expression="${package-file.extension}
	 */
	private String extension;

	/**
	 * The resulting extension of the file
	 *
	 * @parameter expression="${package-file.fileName}
	 */
	private String fileName;

	/**
	 * If the file should be archived
	 *
	 * @parameter expression="${package-file.enableArchive}" default-value=false
	 */
	private boolean enableArchive;

	public void execute() throws MojoExecutionException, MojoFailureException {

		File destFolder = new File(project.getBuild().getDirectory());
		String newPath = null;

		if (fileName != null) { // if the user gave a name for the file
			newPath = destFolder.getAbsolutePath() + File.separator + fileName;
		} else {
			if (extension != null) { // if the user provided the extension
				String fileNameWithoutExtension = (artifact.getName().split("\\."))[0];
				newPath =
				          destFolder.getAbsolutePath() + File.separator + fileNameWithoutExtension +
				              "." + extension;
			} else {
				newPath = destFolder.getAbsolutePath() + File.separator + artifact.getName();
			}
		}

		File result = new File(newPath);

		if (!artifact.exists()) {
			throw new MojoExecutionException(artifact.getAbsolutePath() + " doesn't exist.");
		}

		try {
			FileUtils.copyFile(artifact, result);
		} catch (IOException e) {
			throw new MojoExecutionException("Error when copying " + artifact.getName() + " to " +
			                                 result.getName() + "\n" + e.getMessage());
		}

		if (result != null && result.exists()) {
			project.getArtifact().setFile(result);
//			projectHelper.attachArtifact(project, extension, null, result);
		} else {
			throw new MojoExecutionException(result + " is null or doesn't exist");
		}

		if (enableArchive) {
			// TODO make the zip file
		}

	}

}
