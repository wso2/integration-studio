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

package org.wso2.developerstudio.eclipse.artifact.registry.validators;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.wso2.developerstudio.eclipse.artifact.registry.model.RegistryArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryTemplate;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;



public class RegistryArtifactFieldController extends AbstractFieldController {
	
 
public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		if (modelProperty.equals(RegistryArtifactConstants.DATA_REG_LOCATION)) {
			if (value == null) {
				throw new FieldValidationException("Registry path cannot be empty");
			}
			String regPath = value.toString();
			if (regPath.trim().equals("")) {
				throw new FieldValidationException("Registry path cannot be empty");
			}
		} else if (modelProperty.equals(RegistryArtifactConstants.DATA_RESOURCE_NAME)) {
			if (value == null) {
				throw new FieldValidationException("Resource name cannot be empty");
			}
			String resource = value.toString();
			if (resource.trim().equals("")) {
				throw new FieldValidationException("Resource name cannot be empty");
			}else{
				if(!CommonFieldValidator.isValidArtifactName(resource)){
					throw new FieldValidationException("Resource name cannot contain invalid characters (/:@%\\^+;,=*#[{]}$?\"<> +)");
				}
			}

		}else if (modelProperty.equals("artifact.name")) {
			 CommonFieldValidator.validateArtifactName(value);
			if (value != null) {
				String resource = value.toString();
				RegistryArtifactModel regModel = (RegistryArtifactModel) model;
				if (regModel != null) {
					IContainer resLocation = regModel.getResourceSaveLocation();
					if (resLocation != null) {
						IProject project = resLocation.getProject();
						GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
						try {
							generalProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
							List<RegistryArtifact> allArtifacts = generalProjectArtifact.getAllArtifacts();
							for (RegistryArtifact registryArtifact : allArtifacts) {
								if (resource.equals(registryArtifact.getName())) {
									throw new FieldValidationException("");
								}
							}
							
						} catch (Exception e) {
							throw new FieldValidationException("Artifact name already exists");
						}
					}
				}
				
				if (regModel != null) {
					IContainer resLocation = regModel.getResourceSaveLocation();
					if (resLocation != null) {
						RegistryTemplate selectedTemplate = regModel.getSelectedTemplate();
						String file = regModel.getResourceName() + "." + selectedTemplate.getTemplateFileName().substring(selectedTemplate.getTemplateFileName().lastIndexOf(".")+1);
						IResource findMember = resLocation.findMember(file);
						if(findMember != null){
							throw new FieldValidationException("A Resource already exist in the same location with same name.");
						}
					}
				}
			}
		}else if (modelProperty.equals(RegistryArtifactConstants.DATA_IMPORT_FILE)) {
			if (value == null) {
				throw new FieldValidationException("Specified resource location is invalid");
			}
			File resource = (File) value;
			if (resource==null || !resource.exists()) {
				throw new FieldValidationException("Specified resource doesn't exist");
			} 
			
			RegistryArtifactModel regModel = (RegistryArtifactModel) model;
			IContainer resLocation = regModel.getResourceSaveLocation();
			if (resLocation != null) {
				IResource findMember = resLocation.findMember(resource.getName());
				if(findMember != null){
					throw new FieldValidationException("A Resource already exist in the same location with same name.");
				}
			}
		} else if (modelProperty.equals("save.file")) {
			IResource resource = (IResource)value;
			if(resource==null || !resource.exists())	
				throw new FieldValidationException("Specified project or path doesn't exist");
		} else if (modelProperty.equals(RegistryArtifactConstants.DATA_CHECKOUT_PATH)) {
			if (value == null) {
				throw new FieldValidationException("Registry path cannot be empty");
			} else{
				if(value instanceof RegistryResourceNode){
					RegistryResourceNode node =(RegistryResourceNode)value;
				} else{
					throw new FieldValidationException("Registry path cannot be empty");
				}
			}
		}
	}
	
public boolean isEnableField(String modelProperty, ProjectDataModel model) {
	boolean enableField = super.isEnableField(modelProperty, model);
	if (modelProperty.equals(RegistryArtifactConstants.DATA_COPY_CONTENT)) {
		File file = (File) model.getModelPropertyValue(RegistryArtifactConstants.DATA_IMPORT_FILE);
		if(file!=null) {
			if(file.isDirectory()){
				enableField=true;	
			}
			else{
				enableField=false;
			}
		}
		else{
			enableField=false;
		}
	
	}
	return enableField;
}

public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
    boolean isReadOnly = super.isReadOnlyField(modelProperty, model);
    if (modelProperty.equals(RegistryArtifactConstants.DATA_CHECKOUT_PATH)) {
    	isReadOnly=true;
    }
    return isReadOnly;
}
	
public List<String> getUpdateFields(String modelProperty,
			ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if (modelProperty.equals(RegistryArtifactConstants.DATA_IMPORT_FILE)) {
			updateFields.add(RegistryArtifactConstants.DATA_COPY_CONTENT);
		}  else if (modelProperty.equals("create.prj")) {
			updateFields.add("save.file");
		}  else if (modelProperty.equals(RegistryArtifactConstants.DATA_RESOURCE_TYPE)) {
			updateFields.add(RegistryArtifactConstants.DATA_REG_LOCATION);
		} 
		
		if (("resource.name".equals(modelProperty))
				|| ("import.file".equals(modelProperty))
				|| ("registry.browser".equals(modelProperty))) {

			RegistryArtifactModel tempmodel = (RegistryArtifactModel) model;
			if (("resource.name".equals(modelProperty))) {
				String resourcesName = tempmodel.getResourceName();
				String oldresourcesName = "";
				if (resourcesName.length() >= 1) {
					oldresourcesName = resourcesName.substring(0,
							resourcesName.length() - 1);
				}
				String artifactName = tempmodel.getArtifactName();
				String oldArtifactName = "";
				if (artifactName.length() >= 1) {
					oldArtifactName = artifactName.substring(0,
							artifactName.length() - 1);
				}
				if (oldresourcesName.equals(tempmodel.getArtifactName())
						|| (resourcesName.equals(oldArtifactName))) {
					tempmodel.setArtifactName(resourcesName);			
					updateFields.add("artifact.name");
				}
			} else if("import.file".equals(modelProperty)){
				if (tempmodel.getImportFile()!=null) {
					String fileNameWithExtension = ProjectUtils.fileNameWithExtension(tempmodel.getImportFile().getName());
					tempmodel.setArtifactName(fileNameWithExtension);
					updateFields.add("artifact.name");
				}
			}else {
				if (tempmodel.getResourceName()!=null) {
					tempmodel.setArtifactName(tempmodel.getResourceName());
					updateFields.add("artifact.name");
				}
			}
		}

		return updateFields;
	}

}
