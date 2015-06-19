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

package org.wso2.developerstudio.eclipse.artifact.jaxrs.project.nature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.artifact.jaxrs.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.maven.util.ProjectDependencyConstants;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryBean;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryUtil;

public class JaxrsProjectNature  extends AbstractWSO2ProjectNature  {
private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public void configure() throws CoreException {
		try {
			updatePom();
		} catch (Exception e) {
			log.error("Cannot configure JAX-RS project",e);
		}
	}

	public void updatePom() throws Exception {
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		
		addMavenCompilerPlugin(mavenProject);
		addMavenWarPlugin(mavenProject);
		
		Properties properties = mavenProject.getModel().getProperties();
		
		properties.put("CApp.type", "webapp/jaxws");
		/* we are using same cApp type for both jaxws and jaxrs  */
		
		mavenProject.getModel().setProperties(properties);
		
		List<Dependency> dependencyList = new ArrayList<Dependency>();
		
		Map<String, JavaLibraryBean> dependencyInfoMap = JavaLibraryUtil.getDependencyInfoMap(getProject());
		Map<String, String> map = ProjectDependencyConstants.DEPENDENCY_MAP;
		for (JavaLibraryBean bean : dependencyInfoMap.values()) {
			if (bean.getVersion().contains("${")){
				for(String path: map.keySet()) {
					bean.setVersion(bean.getVersion().replace(path, map.get(path)));
				}
			}
			Dependency dependency = new Dependency();
			dependency.setArtifactId(bean.getArtifactId());
			dependency.setGroupId(bean.getGroupId());
			dependency.setVersion(bean.getVersion());
			dependency.setScope("provided");
			dependencyList.add(dependency);
		}
		MavenUtils.addMavenDependency(mavenProject, dependencyList);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
		
	}

	public void deconfigure() throws CoreException {
		
		
	}
	
	private void addMavenCompilerPlugin(MavenProject mavenProject) {
		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.apache.maven.plugins", "maven-compiler-plugin",
				"2.3.2");
		if(!pluginExists){
			MavenUtils.addMavenCompilerPlugin(mavenProject);
		}	
	}
	
	private void addMavenWarPlugin(MavenProject mavenProject) {
		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				"org.apache.maven.plugins", "maven-war-plugin",
				"2.2");
		if(pluginExists){
			return ;
		}
		
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins",
				"maven-war-plugin", "2.2", false);
		Xpp3Dom createMainConfigurationNode = MavenUtils.createMainConfigurationNode(plugin);
		Xpp3Dom createWebXmlNode = MavenUtils.createXpp3Node(createMainConfigurationNode, "webXml");
		createWebXmlNode.setValue("${basedir}/src/main/webapp/WEB-INF/web.xml");
		Xpp3Dom createExcludesNode = MavenUtils.createXpp3Node(createMainConfigurationNode,
				"packagingExcludes");
		Xpp3Dom createWarNameNode = MavenUtils.createXpp3Node(createMainConfigurationNode,
				"warName");
		createWarNameNode.setValue("${project.artifactId}");
	}

}
