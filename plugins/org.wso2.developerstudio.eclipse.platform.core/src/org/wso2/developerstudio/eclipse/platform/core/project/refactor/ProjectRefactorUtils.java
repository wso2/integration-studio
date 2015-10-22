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

package org.wso2.developerstudio.eclipse.platform.core.project.refactor;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

/**
 * This class is a utility class used with Refactporing.
 * 
 */
public class ProjectRefactorUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * This method is used to generate Maven Dependency from a given Eclipse
	 * Project based on Project pom.xml
	 * 
	 * @param project
	 * @return
	 */
	public static Dependency getDependencyForTheProject(IProject project) {
		MavenProject mavenProject = getMavenProject(project);
		Dependency dependency = null;
		if (mavenProject != null) {
			dependency = new Dependency();
			dependency.setGroupId(mavenProject.getGroupId());
			dependency.setArtifactId(mavenProject.getArtifactId());
			dependency.setVersion(mavenProject.getVersion());
		}
		return dependency;
	}

	/**
	 * This method returns a Maven Project corresponding to the Eclipse Project.
	 * 
	 * @param project
	 * @return
	 */
	public static MavenProject getMavenProject(IProject project) {
		try {
			return MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
		} catch (Exception e) {
			log.error("Failed to retrive the maven project for the given project", e);
			return null;
		}
	}

	/**
	 * This method is evaluating whether 2 Maven dependencies are equal based on
	 * their Maven properties.
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean isDependenciesEqual(Dependency source, Dependency target) {
		return (source.getGroupId().equalsIgnoreCase(target.getGroupId()) &&
		        source.getArtifactId().equalsIgnoreCase(target.getArtifactId()) && source.getVersion()
		                                                                                 .equalsIgnoreCase(target.getVersion()));
	}

	/**
	 * This method is used to generate the Characters on a line on file.
	 * We need to count the number of chars in the line and increase count by 1
	 * for New Line Character.
	 * Need to be careful of platform dependent encoding systems.
	 * 
	 * @param line
	 * @return
	 */
	public static int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		return line.length() + 1;
	}

}
