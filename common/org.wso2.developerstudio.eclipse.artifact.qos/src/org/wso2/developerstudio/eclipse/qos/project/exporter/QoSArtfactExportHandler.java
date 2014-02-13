/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.qos.project.exporter;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;

public class QoSArtfactExportHandler extends ProjectArtifactHandler {

	@Override
	public List<IResource> exportArtifact(IProject project)
			throws Exception {
    	String projectPath = project.getLocation().toFile().toString();
		List<IResource> exportResources = new ArrayList<IResource>();
    	clearTarget(project);
    	IFile pomFile = project.getFile("pom.xml");
    	
    	if(pomFile.exists()){
    		MavenProject mavenProject = MavenUtils.getMavenProject(pomFile.getLocation().toFile());
    		List<Plugin> plugins = mavenProject.getBuild().getPlugins();
			for (Plugin plugin : plugins) {
				if (plugin.getArtifactId().equals("maven-qos-plugin") &&
				    plugin.getGroupId().equals("org.wso2.maven")) {
					Xpp3Dom artifactNode = ((Xpp3Dom) plugin.getConfiguration()).getChild("artifact");
					String metaFile = artifactNode.getValue();
					String[] pathArray = metaFile.split("/");
					IFile qosFileRef = project.getFolder("src").getFolder("main").getFolder("resources").getFile(pathArray[pathArray.length-1]);
					if (qosFileRef.exists()) {
						exportResources.add((IResource) qosFileRef);
					}
				}
			}
			return exportResources;
    	}
    	return null;
	}	
}
