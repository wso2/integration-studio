/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distributionproject.module.utils;

import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.distributionproject.module.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.apache.maven.project.MavenProject;

public class CAppPropertyTester extends PropertyTester  {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(receiver instanceof IProject){
			try {
				IProject project = (IProject) receiver;
				if(project.hasNature(Constants.CAPP_NATURE_ID)){
					IFile pomFile = project.getFile("pom.xml");
					if(pomFile.exists()){
						MavenProject mavenProject = MavenUtils
								.getMavenProject(pomFile.getLocation().toFile());
						List dependencies = mavenProject.getDependencies();
						if(dependencies.size()>0){
							return true;
						}
					}
				}
			} catch (Exception e) {
				log.error("An exception has occurred", e);
			}
		}
		return false;
	}

}
