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

package org.wso2.developerstudio.eclipse.artifact.synapse.validators;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.artifact.synapse.model.SynapseModel;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class SynapseFieldsController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		if (modelProperty.equals("config.name")) {
			if (value == null) {
				throw new FieldValidationException("Synapse configuration name cannot be empty");
			}
			String projectName = value.toString();
			if (projectName.trim().equals("")) {
				throw new FieldValidationException("Synapse configuration name cannot be empty");
			}
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

			if (project.exists()) {
				throw new FieldValidationException("Synapse configuration name cannot be match with the project name ");
			}	
		
		}  else if (modelProperty.equals("save.file")) {
			IResource resource = (IResource)value;
			if(resource==null || !resource.exists())	
				throw new FieldValidationException("Specified project or path doesn't exist");
		} else if(modelProperty.equals("import.file") || modelProperty.equals("available.af")){
			SynapseModel synapseModel = (SynapseModel)model;
				if(null==synapseModel.getSelectedArtifacts() || synapseModel.getSelectedArtifacts().size() <=0){
					throw new FieldValidationException("Please select at least one artifact");
				}
		}
	}
	
    public List<String> getUpdateFields(String modelProperty,ProjectDataModel model) {
    	List<String> updateFields = super.getUpdateFields(modelProperty, model);
    	if(modelProperty.equals("create.esb.prj")){
    		updateFields.add("save.file");
    	} else if(modelProperty.equals("create.esb.af")){
    		updateFields.add("available.af"); 
    	} else if (modelProperty.equals("import.file")) {
			updateFields.add("available.af");
		} 
    	return updateFields;
    }
       
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals("save.file")) {
			readOnlyField = true;
		}
	    return readOnlyField;
	}
}
