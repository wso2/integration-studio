/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.registry.Activator;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryTemplate;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class RegistryArtifactModel extends ProjectDataModel {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private IContainer resourceSaveLocation;
	private RegistryTemplate selectedTemplate;
	private String registryPath="custom/";
	private String registryPartition;
	private String resourceName;
	private String artifactName="";
	private boolean copyContent;
	private RegistryResourceNode checkoutPath;
	private static Map<String, String > registryPrefix = new HashMap<String, String >();
	
	static{
		//FIXME: move hard-coded vales to template ext-point
		registryPrefix.put("custom", "custom/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.sequence", "sequences/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep1", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep2", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep5", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep3", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep4", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep6", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep7", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.ep8", "endpoints/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.smooks", "smooks/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.proxy3", "proxies/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.proxy6", "proxies/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.proxy1", "proxies/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.proxy2", "proxies/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.proxy4", "proxies/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.proxy5", "proxies/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.css", "css/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.html", "html/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.js", "js/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.sql", "sql/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.xsl", "xsl/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.xslt", "xslt/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.wsdl", "wsdl/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.sq_template", "templates/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.Address", "templates/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.default", "templates/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.wsdl", "templates/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.http", "templates/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.template.datamapper", "datamapper/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.esb.localentry", "localEntry/");
		//Adding template for ws-policy
		registryPrefix.put("org.wso2.developerstudio.eclipse.security.ws_policy", "ws-policy/");
		registryPrefix.put("org.wso2.developerstudio.eclipse.sample.xsd", "xsds/");
	}
	
	public RegistryArtifactModel() {
	
		
	}
	
	public void setSelectedTemplate(RegistryTemplate selectedTemplate) {
		this.selectedTemplate = selectedTemplate;
	}

	public RegistryTemplate getSelectedTemplate() {
		return selectedTemplate;
	}
	
	public void setRegistryPath(String registryPath) {
		this.registryPath = registryPath;
	}

	public String getRegistryPath() {
		return registryPath;
	}
	
	public String getCompleteRegistryPath(){
		return getRegistryPartition()+getRegistryPath();
	}
	
	public void setCopyContent(boolean copyContent){
		this.copyContent=copyContent;
	}
	
	public boolean getCopyContent(){
		return copyContent;
	}
	
	
	public boolean setModelPropertyValue(String key, Object data)throws ObserverFailedException {
		boolean returnResult =  super.setModelPropertyValue(key, data);
		if(key.equals(RegistryArtifactConstants.DATA_CREATE_PRJ)){
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject generalProject = GeneralProjectUtils.createGeneralProject(shell,getLocation());
			if(generalProject!=null){
				setResourceSaveLocation(generalProject);
			}
		} else if (key.equals(RegistryArtifactConstants.DATA_RESOURCE_TYPE)) {
			RegistryTemplate template = (RegistryTemplate) data;
			setSelectedTemplate(template);
		} else if (key.equals(RegistryArtifactConstants.DATA_REG_LOCATION)) {
			setRegistryPath(data.toString());
		} else if(key.equals(RegistryArtifactConstants.DATA_RESOURCE_NAME)){
			setResourceName(data.toString());
		} else if (key.equals(RegistryArtifactConstants.DATA_SAVE_FILE)) {
			setResourceSaveLocation((IContainer) data);
		} else if (key.equals(RegistryArtifactConstants.DATA_COPY_CONTENT)) {
			setCopyContent((Boolean) data);
		} else if (key.equals(RegistryArtifactConstants.DATA_CHECKOUT_PATH)) {
			if(data!=null){
				if(data instanceof RegistryResourceNode){
					setCheckoutPath((RegistryResourceNode)data);
				}
			}
		} else if(key.equals(RegistryArtifactConstants.DATA_IMPORT_FILE)){
			if (data != null) {
				File importFile = new File(data.toString());
				int fileExtensionIndex = importFile.getName().lastIndexOf(".");
				if (fileExtensionIndex != -1) {
	                setResourceName(importFile.getName().substring(0, fileExtensionIndex));
                }else{
                	setResourceName(importFile.getName());
                }
			}
		} else if("artifact.name".equals(key)){
			this.setArtifactName(data.toString());
		} else if("reg.partition".equals(key)){
			setRegistryPartition(data.toString());
		}
		return returnResult;
	}
	
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals(RegistryArtifactConstants.DATA_RESOURCE_TYPE)) {
				modelPropertyValue = getSelectedTemplate();
			} else if (key.equals(RegistryArtifactConstants.DATA_REG_LOCATION)) {
				modelPropertyValue = getRegistryPrefix(selectedTemplate); //getRegistryPath();
			} else if (key.equals(RegistryArtifactConstants.DATA_RESOURCE_NAME)) {
				modelPropertyValue = getResourceName();
			} else if (key.equals(RegistryArtifactConstants.DATA_SAVE_FILE)) {
				modelPropertyValue = getResourceSaveLocation();
			} else if (key.equals(RegistryArtifactConstants.DATA_COPY_CONTENT)) {
				modelPropertyValue = getCopyContent();
			} else if (key.equals(RegistryArtifactConstants.DATA_CHECKOUT_PATH)) {
				modelPropertyValue = getCheckoutPath();
			} else if ("artifact.name".equals(key)){
				modelPropertyValue = getArtifactName();
			}else if(key.equals(RegistryArtifactConstants.DATA_REG_PARTITION)){
				modelPropertyValue = getRegistryPartition();
			}
		}
		return modelPropertyValue;
	}
	
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceSaveLocation(IContainer resourceSaveLocation) {
		this.resourceSaveLocation = resourceSaveLocation;
	}
	
	public void setResourceSaveLocation(String resourceSaveLocation) {
		this.resourceSaveLocation =
		        ResourcesPlugin.getWorkspace().getRoot()
		                .getContainerForLocation(new Path(resourceSaveLocation));
	}

	public IContainer getResourceSaveLocation() {
		return resourceSaveLocation;
	}

	
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getResourceSaveLocation() == null && absolutionPath != null) {
			IContainer newResourceSaveLocation =
			        getContainer(absolutionPath,RegistryArtifactConstants.GENERAL_PROJECT_NATURE);
			setResourceSaveLocation(newResourceSaveLocation);
		}
	}

	public static IContainer getContainer(File absolutionPath, String projectNature) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		int length = 0;
		IProject currentSelection = null;
		for (IProject project : projects) {
			try {
				if (project.isOpen()  && project.hasNature(projectNature)) {
					File projectLocation = project.getLocation().toFile();
					int projectLocationLength = projectLocation.toString().length();
					if (projectLocationLength > length &&
					    projectLocationLength <= absolutionPath.toString().length()) {
						if (absolutionPath.toString().startsWith(projectLocation.toString())) {
							length = projectLocationLength;
							currentSelection = project;
						}
					}
				}
			} catch (Exception e) {
				log.warn(e);
			}
		}
		IContainer newResourceSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());
			if ("".equals(path)) {
				newResourceSaveLocation = currentSelection;
			} else{
				newResourceSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newResourceSaveLocation;
	}

	public void setCheckoutPath(RegistryResourceNode checkoutPath) {
	    this.checkoutPath = checkoutPath;
    }

	public RegistryResourceNode getCheckoutPath() {
	    return checkoutPath;
    }

	public void setArtifactName(String artifactName) {
		this.artifactName = artifactName;
	}

	public String getArtifactName() {
		return artifactName;
	}

	/**
	 * @param registryPartition the registryPartition to set
	 */
	public void setRegistryPartition(String registryPartition) {
		this.registryPartition = registryPartition;
	}

	/**
	 * @return the registryPartition
	 */
	public String getRegistryPartition() {
		return registryPartition;
	}
	
	/**
	 * 
	 * @param template
	 * @return the registryPrefix
	 */
	public String getRegistryPrefix(RegistryTemplate template) {
		if (template != null
				&& getSelectedOption().equals(RegistryArtifactConstants.OPTION_NEW_RESOURCE)) {
			if (registryPrefix.containsKey(template.getId())) {
				if (registryPrefix.values().contains(registryPath)) {
					String prefix = registryPrefix.get(template.getId());
					setRegistryPath(prefix);
					return prefix;
				}
			}
		}
		return registryPath;
	}
	
	@Override
	public void setSelectedOption(String selectedOption)
			throws ObserverFailedException {
		if (!RegistryArtifactConstants.OPTION_NEW_RESOURCE.equals(selectedOption)) {
			setRegistryPath("custom/");
		}
		super.setSelectedOption(selectedOption);
	}
	
	
}
