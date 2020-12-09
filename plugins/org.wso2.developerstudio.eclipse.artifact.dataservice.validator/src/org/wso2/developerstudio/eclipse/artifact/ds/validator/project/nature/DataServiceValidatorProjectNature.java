/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.ds.validator.project.nature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.artifact.ds.validator.ui.wizard.DataServiceValidatorCreationWizard;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.maven.util.ProjectDependencyConstants;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryBean;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaLibraryUtil;

public class DataServiceValidatorProjectNature extends AbstractWSO2ProjectNature {

	
	public void configure() {
		try {
			this.updatePom();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	  
	
	public void updatePom() throws Exception {
        ResourceBundle mediatorPropetiesBundle = ResourceBundle.getBundle("dsValidator");
		String groupId = mediatorPropetiesBundle.getString("Plugin_groupId");
		String artifactId = mediatorPropetiesBundle.getString("Plugin_artficatId");
		String version = mediatorPropetiesBundle.getString("Plugin_version");
		
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		mavenProject.getModel().getProperties().put("CApp.type", "lib/dataservice/validator");
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject,groupId,artifactId,version, true);
		PluginExecution pluginExecution;
		pluginExecution = new PluginExecution();
		plugin.addExecution(pluginExecution);
		
		String name = DataServiceValidatorCreationWizard.getCustomMediatorModel().getValidatorClass();
		Xpp3Dom configNode = MavenUtils.createXpp3Node("configuration");
		Xpp3Dom instructionNode = MavenUtils.createXpp3Node(configNode,"instructions");
		Xpp3Dom sybundleNode = MavenUtils.createXpp3Node(instructionNode,"Bundle-SymbolicName");
		sybundleNode.setValue(name);
		Xpp3Dom bundleNode = MavenUtils.createXpp3Node(instructionNode,"Bundle-Name");
		bundleNode.setValue(name);
		Xpp3Dom pacNode = MavenUtils.createXpp3Node(instructionNode,"Export-Package");
		pacNode.setValue(DataServiceValidatorCreationWizard.getCustomMediatorModel().getValidatorClassPackage());
		Xpp3Dom impNode = MavenUtils.createXpp3Node(instructionNode,"DynamicImport-Package");
		impNode.setValue("*");
		plugin.setConfiguration(configNode);
		
		List<Dependency> dependencyList = new ArrayList<Dependency>();
		Map<String, JavaLibraryBean> dependencyInfoMap = JavaLibraryUtil.getDependencyInfoMap(getProject());
		Map<String, String> map = ProjectDependencyConstants.DEPENDENCY_MAP;
		for (JavaLibraryBean bean : dependencyInfoMap.values()) {
			if (bean.getVersion().contains("${")) {
				for (String path : map.keySet()) {
					bean.setVersion(bean.getVersion().replace(path,
							map.get(path)));
				}
			}
			Dependency dependency = new Dependency();
			dependency.setArtifactId(bean.getArtifactId());
			dependency.setGroupId(bean.getGroupId());
			dependency.setVersion(bean.getVersion());
			dependencyList.add(dependency);
		}
		MavenUtils.addMavenDependency(mavenProject, dependencyList);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}
}
