/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.general.project.refactor;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class RefactorUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static Dependency getDependencyForTheProject(IProject project) {
		MavenProject mavenProject = getMavenProject(project);

		Dependency dependency = new Dependency();
		
		if (mavenProject != null) {
			dependency.setGroupId(mavenProject.getGroupId() + ".resource");
			dependency.setArtifactId(mavenProject.getArtifactId());
			dependency.setVersion(mavenProject.getVersion());
		}
		return dependency;
	}

	public static MavenProject getMavenProject(IProject project) {
		try {
				return MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
		} catch (Exception e) {
			log.error("Failed to retrieve the maven project for the given project", e);
		}
		return null;
	}

	public static boolean isDependenciesEqual(Dependency source, Dependency target) {
		return (source.getGroupId().equalsIgnoreCase(target.getGroupId()) &&
		        source.getArtifactId().equalsIgnoreCase(target.getArtifactId()) && source.getVersion()
		                                                                                 .equalsIgnoreCase(target.getVersion()));
	}
	
	public static int charsOnTheLine(String line) {
		// Here we need to add one to represent the newline character
		return line.length()+1;
	}

}
