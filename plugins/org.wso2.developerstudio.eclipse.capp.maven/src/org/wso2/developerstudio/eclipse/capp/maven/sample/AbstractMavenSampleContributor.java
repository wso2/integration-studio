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

package org.wso2.developerstudio.eclipse.capp.maven.sample;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenPomGenPluginUtils;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.samples.contributor.AbstractSampleContributor;

public abstract class AbstractMavenSampleContributor extends AbstractSampleContributor{
	
	private static final String PARENT = ".parent";
	private static final String POM = "pom";
	private static final String VERSION = "1.0.0";
	private static final String BUILDER = ".builder";
	private static final String ORG_WSO2_CAPP = "org.wso2.capp";

	protected void addSampleTo(IProject project, boolean isMavenReady) throws Exception {
		super.addSampleTo(project);
		if(!project.isOpen()){
			project.open(new NullProgressMonitor());
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		}
		if (isMavenReady) {
	        generateMavenPOMForSample(project);
	        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        }
	}
	
	
	protected void generateMavenPOMForSample(IProject project) throws Exception {
	    MavenProject selectedProject=generateMavenProject(project);
        MavenPomGenPluginUtils.updateAndSaveMavenCAppProject(selectedProject,project,null,selectedProject.getArtifactId()+ PARENT);
    }
	
    private MavenProject generateMavenProject(IProject eclipseProject){
    	MavenProject project = MavenUtils.createMavenProject(ORG_WSO2_CAPP, eclipseProject.getName() + BUILDER, VERSION, POM);
    	return project;
    }

}
