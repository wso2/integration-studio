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
package org.wso2.developerstudio.eclipse.artifact.datasource.project.nature;

import java.io.File;
import java.io.IOException;

import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.artifact.datasource.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;

public class DataSourceNature extends AbstractWSO2ProjectNature {

	private static final String POM_FILE = "pom.xml";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);


	public void configure() throws CoreException, JavaModelException {
		try {
			updatePom();
		} catch (IOException | XmlPullParserException e) {
			log.error("Error Updating POM file", e);
		}
	}

	public void deconfigure() throws CoreException {
	}

	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = getProject().getFile(POM_FILE).getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}
}
