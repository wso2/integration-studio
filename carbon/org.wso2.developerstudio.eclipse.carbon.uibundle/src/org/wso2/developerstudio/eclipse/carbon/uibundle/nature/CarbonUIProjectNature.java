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

package org.wso2.developerstudio.eclipse.carbon.uibundle.nature;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.wso2.developerstudio.eclipse.carbon.uibundle.Activator;

@SuppressWarnings("restriction")
public class CarbonUIProjectNature implements IProjectNature {
	private static Map<IProject,CarbonUIProjectNatureData> projectData;
	private IProject project;
	
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
	
	public void configure() throws CoreException {
		try {
			IFile bundleManifestFile = project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR);
			Manifest manifest = new Manifest(bundleManifestFile.getContents());
			manifest.getMainAttributes().put(new Attributes.Name("Carbon-Component"),"UIBundle");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			manifest.write(byteArrayOutputStream);
			bundleManifestFile.setContents(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), IFile.FORCE, null);
			CarbonUIProjectNatureData data = getProjectData().get(getProject());
			String webFolderPath="web/";
			if (data!=null){
				webFolderPath+=data.getUrlPath();
			}
			IFolder webFolder = project.getFolder(webFolderPath);
			if (!webFolder.exists()){
				createFolder(webFolder);
			}
			
			String[] split = ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR.split("/");
			IFile componentXmlFile = project.getFolder(split[0]).getFile("component.xml");
			if (!componentXmlFile.exists()){
				componentXmlFile.create(new ByteArrayInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<component xmlns=\"http://products.wso2.org/carbon\">\n</component>".toString().getBytes()), true, null);
			}
			
			IFile buildPropertiesfile = project.getFile("build.properties");
			Properties properties = new Properties();
			properties.load(buildPropertiesfile.getContents());
			String property = properties.getProperty("bin.includes");
			String webFolderRoot = webFolder.getProjectRelativePath().toPortableString();
			if (property==null){
				property=webFolderRoot+"/";
			}else{
				property+=","+webFolderRoot+"/";
			}
			properties.setProperty("bin.includes",property);
			byteArrayOutputStream = new ByteArrayOutputStream();
			properties.store(byteArrayOutputStream, null);
			buildPropertiesfile.setContents(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), IFile.FORCE, null);
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR,Activator.PLUGIN_ID,-1,"Error adding project nature",e));
		}

	}

	public void deconfigure() throws CoreException {

	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project=project;
	}
	
	public static void addNatureToProject(IProject project,String natureId) throws CoreException{
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(natureId);
		arrayList.addAll(Arrays.asList(natures));
		description.setNatureIds(arrayList.toArray(new String[]{}));
		project.setDescription(description, null);
	}

	public static Map<IProject,CarbonUIProjectNatureData> getProjectData() {
		if (projectData==null){
			projectData=new HashMap<IProject,CarbonUIProjectNatureData>();
		}
		return projectData;
	}
}
