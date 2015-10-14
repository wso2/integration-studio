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

package org.wso2.developerstudio.eclipse.utils.project;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class ProjectUtils {
	public static void addNatureToProject(IProject project, boolean addToEnd, String...natureId) throws CoreException{
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		ArrayList<String> arrayList = new ArrayList<String>();
		if (addToEnd){
    		arrayList.addAll(Arrays.asList(natures));
    		arrayList.addAll(Arrays.asList(natureId));
		}else{
    		arrayList.addAll(Arrays.asList(natureId));
    		arrayList.addAll(Arrays.asList(natures));
		}
		String[] list=new String[arrayList.size()];
		list = arrayList.toArray(list);
		description.setNatureIds(list);
		project.setDescription(description, null);
	}
	
	public static void addBuildSpecificationsToProject(IProject project, String...buildCommandList) throws CoreException{
		IProjectDescription description = project.getDescription();
		ICommand[] buildSpecifications = new BuildCommand[buildCommandList.length];
		
		int i = 0;
		for (ICommand buildCommand : buildSpecifications) {
			buildCommand = new BuildCommand();
			buildCommand.setBuilderName(buildCommandList[i]);
			buildSpecifications[i] = buildCommand;
			i++;
		}
		
		
//		int i = 0;
//		for (String buildCommand : buildCommandList) {
//			new bui
//			buildSpecifications[i].setBuilderName(buildCommand);
//			i++;
//		}
		
		description.setBuildSpec(buildSpecifications);
		project.setDescription(description, null);
	}
	
	public static IProject[] getProjectReferencesForService(IProject project)  throws CoreException {
        IProject[] projects = project.getDescription().getReferencedProjects();
        return projects;
	}
	
	public static boolean createFolder(IFolder folder) throws CoreException{
		if (folder.exists()){
			return true;
		}else{
			if (folder.getParent()!=null && folder.getParent().exists()){
				folder.create(true, true, null);
				return true;
			}else if (folder.getParent() instanceof IFolder && createFolder((IFolder)folder.getParent())){
				folder.create(true, true, null);
				return true;
			}
		}
		return false;
	}
	
	public static void buildProject(IProject project) throws CoreException{
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
		project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
	}
	
	public static URL getPluginResource(Bundle bundle, String resourcePath){
		return bundle.getResource(resourcePath);
	}
	
	public static URL getPluginResource(String bundleSymbolicName, String resourcePath){
		return getPluginResource(Platform.getBundle(bundleSymbolicName),resourcePath);
	}
	
	public static String fileNameWithoutExtension(String fileName){
	    File file = new File(fileName);
	    if (file.isDirectory()) return fileName;
	    String name = file.getName();
	    final int lastPeriodPos = name.lastIndexOf('.', name.length() - 1);
	    if (lastPeriodPos == -1){
	        return fileName;
	    }
	    else {
	        File nameWithoutExt = new File(file.getParent(), name.substring(0, lastPeriodPos));
	        return nameWithoutExt.getPath();
	    }

	}
	
	public static String fileNameWithExtension(String fileName){
	    File file = new File(fileName);
	    if (file.isDirectory()) return fileName;
	    String name = file.getName();
	    final int lastPeriodPos = name.lastIndexOf('.', name.length() - 1);
	    if (lastPeriodPos == -1){
	        return fileName;
	    }
	    else {
	        File nameWithoutExt = new File(file.getParent(), name.substring(0, lastPeriodPos)+"_"+name.substring(lastPeriodPos+1).toLowerCase());
	        return nameWithoutExt.getPath();
	    }

	}
	
	/**
	 * folderNameList should be {"src", "main", "java"}
	 * parentFolder will be src
	 * leafFolder will be java
	 * @param folderNamePath
	 * @param project
	 * @return
	 */
	public static IFolder getWorkspaceFolder(IProject project, String...folderNamePath){
		IFolder parentFolder = project.getFolder(folderNamePath[0]);
		List<String> folderPath = new ArrayList<String>(Arrays.asList(folderNamePath));
		folderPath.remove(0);
		String[] newFolderNamePath=folderPath.toArray(new String[]{});
		return getWorkspaceFolder(parentFolder, newFolderNamePath);
	}

	public static IFolder getWorkspaceFolder(IFolder parentFolder,
			String...newFolderNamePath) {
		IFolder leafFolder = parentFolder;
		for (String pathElement:newFolderNamePath) {
			leafFolder = parentFolder.getFolder(pathElement);
			parentFolder = leafFolder;
		}
		return leafFolder;
	}
	
//	public static IProject createGeneralProject(Shell shell){
//		IWizardDescriptor wizardDesc = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard("org.eclipse.ui.wizards.new.project");
//		if (wizardDesc!=null) {
//			try {
//				BasicNewProjectResourceWizard basicProjectWizard = (BasicNewProjectResourceWizard) wizardDesc.createWizard();
////			IStructuredSelection selection = (IStructuredSelection) PlatformUI
////					.getWorkbench().getActiveWorkbenchWindow()
////					.getSelectionService().getSelection();
////			esbProjectWizard.init(PlatformUI.getWorkbench(), selection);
//				WizardDialog dialog = new WizardDialog(shell, basicProjectWizard);
//				dialog.create();
//				dialog.open();
//				IProject newProject = basicProjectWizard.getNewProject();
//				return newProject;
//			} catch (CoreException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
	
}
