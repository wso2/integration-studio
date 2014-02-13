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

package org.wso2.developerstudio.eclipse.qos.project.nature;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;
import org.wso2.developerstudio.eclipse.qos.project.ui.wizard.QOSProjectWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.ide.FileExtensionResourcevisitor;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class QOSProjectNature extends AbstractWSO2ProjectNature {
	
	public void configure() throws CoreException {
		IFolder parentFolder =
		        ProjectUtils.getWorkspaceFolder(getProject(), "src", "main", "resources");
		ProjectUtils.createFolder(parentFolder);
		getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		updatePom();
	}

	private void updatePom() {
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject;
        try {
	        mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
	        Plugin pluginEntry = MavenUtils.createPluginEntry(mavenProject, 
	        	"org.wso2.maven", 
	        	"maven-qos-plugin", 
	        	MavenConstants.MAVEN_QOS_PLUGIN_VERSION, 
	        	true);
	        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode(pluginEntry);
	        Xpp3Dom artifactNode = MavenUtils.createXpp3Node(configurationNode, "artifact");
	        artifactNode.setValue("src/main/resources/"+QOSProjectWizard.metaFileName);
//	        if(getServiceMetaFile() != null){
//	        	String fileName = FileUtils.getRelativePath(getProject().getLocation().toFile(),getServiceMetaFile().getLocation().toFile()).replaceAll(Pattern.quote(File.separator), "/");
//	        	artifactNode.setValue(fileName);
//	        }
	        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
	}

	private IFile getServiceMetaFile(){
		try {
	        getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	        FileExtensionResourcevisitor fileExtensionResourceVisitor = new FileExtensionResourcevisitor(".xml", IResource.FILE);
	        getProject().accept(fileExtensionResourceVisitor);
	        List<IResource> resources = fileExtensionResourceVisitor.getResourceList();
	        return resources.size()==0? null: (IFile)resources.get(0);
        } catch (CoreException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		return null;
	}

	
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}
}
