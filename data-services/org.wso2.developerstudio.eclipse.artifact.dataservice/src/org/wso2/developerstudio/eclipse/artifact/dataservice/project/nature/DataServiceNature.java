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
package org.wso2.developerstudio.eclipse.artifact.dataservice.project.nature;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;

public class DataServiceNature extends AbstractWSO2ProjectNature {

	private static final String POM_FILE = "pom.xml";

	public void configure() throws CoreException, JavaModelException {
		try {
			updatePom();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deconfigure() throws CoreException {
	}

	public void updatePom() throws Exception {
		File mavenProjectPomLocation = getProject().getFile(POM_FILE).getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}
}
