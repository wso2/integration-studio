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

package org.wso2.developerstudio.eclipse.artifact.mediator.project.export;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.storagemanager.StorageManager;
import org.wso2.developerstudio.eclipse.platform.core.manifest.BundleManifest;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.logging.core.*;
import org.wso2.developerstudio.eclipse.maven.Activator;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class MediatorExportHandler extends ProjectArtifactHandler {

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public List<IResource> exportArtifact(IProject project) throws Exception {
		List<IResource> exportResources = new ArrayList<IResource>();
	
			ArchiveManipulator archiveManipulator = new ArchiveManipulator();
			NullProgressMonitor nullProgressMonitor = new NullProgressMonitor();
			//cleaning target directory 
			clearTarget(project);
		    IJavaProject javaProject = JavaCore.create(project);

            List<String> exportPac =getExportPackages(javaProject);
		    BundleManifest manifest = new BundleManifest();	   
		    manifest.setBundleName(project.getName());
		    manifest.setBundleSymbolicName(project.getName());
		    manifest.setBundleDescription(project.getName());
		    manifest.setBundleVersion("2.0");
		    manifest.setExportPackagesList(exportPac);
			IPath outPutPath =  buildJavaProject(project);
			  //Let's create a temp project 
	        IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(".temp"+System.currentTimeMillis());
	        tempProject.create(nullProgressMonitor);
	        tempProject.open(nullProgressMonitor);
	        tempProject.setHidden(true);  
	        org.eclipse.osgi.storagemanager.StorageManager manager=new StorageManager(tempProject.getLocation().toFile(), "false");
	        
	        File mediatorResource = manager.createTempFile("mediator_resources");
	        mediatorResource.delete();
	        mediatorResource.mkdir();
	        FileUtils.copyDirectoryContents(outPutPath.toFile(), mediatorResource); // copy binaries 
	        
	        ///////////////////////Create the Bundle*********************************

	        File metainfPath = new File(mediatorResource,"META-INF");
	        metainfPath.mkdir();
	        File manifestFile=new File(metainfPath,"MANIFEST.MF");
	        FileUtils.createFile(manifestFile, manifest.toString());	
	        
//	        Copy the folder resources/META-INF/services to META-INF
	        IFolder manifestFolder=project.getFolder("src"+File.separator+"main"+File.separator+"resources"+File.separator+"META-INF"+File.separator+"services");
	        if (manifestFolder.exists()) {
	        	File destinationServices=new File(metainfPath, "services");
				FileUtils.copyDirectory(manifestFolder.getLocation().toFile(),destinationServices);
			}
	        
			File tmpArchive = new File(tempProject.getLocation().toFile(),project.getName().concat(".jar"));
	        archiveManipulator.archiveDir(tmpArchive.toString(), mediatorResource.toString());
	        IFolder binaries = project.getFolder("target");
	        if(!binaries.exists()) {
	        	binaries.create(true, true, nullProgressMonitor);
	        	binaries.setHidden(true);
	        }
	        IFile serviceArchive = project.getFile("target"+ File.separator +  project.getName().concat(".jar"));
	        FileUtils.copy(tmpArchive, serviceArchive.getLocation().toFile());
	        exportResources.add((IResource)serviceArchive); 
	        //cleaning temp project
	        tempProject.delete(true, nullProgressMonitor);
			
		return exportResources;
	}
		
	private List<String> getExportPackages(IJavaProject javaProject) throws CoreException,
	JavaModelException, Exception {
	ArrayList<String> exportedPackagesList = new ArrayList<String>();
	IPackageFragment[] packages = javaProject.getPackageFragments();
    if (packages != null) {
		for (IPackageFragment iPackageFragment : packages) {
			iPackageFragment.getElementName();
			if (iPackageFragment.getKind() == IPackageFragmentRoot.K_SOURCE) {
				if (iPackageFragment.hasChildren()) {
					exportedPackagesList.add(iPackageFragment.getElementName());
				}
			}
		}
	}
	MavenProject mavenProject =  MavenUtils.getMavenProject(javaProject.getProject().getFile("pom.xml")
            .getLocation().toFile());
	List<Plugin> plugins = mavenProject.getBuild().getPlugins();
	for (Plugin plugin : plugins) {
		if("maven-bundle-plugin".equalsIgnoreCase(plugin.getArtifactId())){
			Xpp3Dom configurationNode = (Xpp3Dom) plugin.getConfiguration();
			Xpp3Dom[] instructions = configurationNode.getChildren("instructions");
			if(instructions.length==1){
				Xpp3Dom[] exportPackage = instructions[0].getChildren("Export-Package");
				if(exportPackage.length==1){
					exportedPackagesList.clear(); //clear default configuration (All packages by default)
					String exportpackages = exportPackage[0].getValue();
					if(packages!=null){
						exportedPackagesList.addAll(Arrays.asList(exportpackages.split(",")));
					}
				} else{
					log.warn("Invalid configuration for <Export-Package> entry"
							+ " using default configuration for <Export-Package>");
				}
			} else{
				log.warn("Invalid instructions configuration for plugin : maven-bundle-plugin"
						+ " using default configuration for <Export-Package>");
			}
			break; //not considering multiple versions of the maven-bundle-plugin
		}
	}
    return exportedPackagesList;
}
	
}
