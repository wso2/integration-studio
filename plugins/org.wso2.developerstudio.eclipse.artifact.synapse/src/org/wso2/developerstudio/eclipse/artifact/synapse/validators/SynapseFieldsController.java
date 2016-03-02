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

import java.io.File;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.artifact.synapse.model.SynapseModel;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class SynapseFieldsController extends AbstractFieldController {

	private static final String SYNAPSE_CONFIG_NAME_EMPTY_ERROR = "Synapse configuration name cannot be empty";
	private static final String CONFIG_NAME_MODEL_PROPERTY = "config.name";
	private static final String SYNAPSE_CONFIG_NAME_MATCHED_PROJECT_NAME_ERROR = "Synapse configuration name cannot be match with the project name ";
	private static final String SAVE_FILE_MODEL_PROPERTY = "save.file";
	private static final String PROJECT_OR_PATH_DOES_NOT_EXIST_ERROR = "Specified project or path doesn't exist";
	private static final String IMPORT_FILE_MODEL_PROPERTY = "import.file";
	private static final String AVAILABLE_MODEL_PROPERTY = "available.af";
	private static final String CONFIG_FILE_LOCATION_INVALID_ERROR = "Specified configuration file location is invalid";
	private static final String CONFIG_FILE_DOES_NOT_EXIST_ERROR = "Specified configuration file doesn't exist";
	private static final String SELECT_ATLEAST_ONE_ARTIFACT_ERROR = "Please select at least one artifact";
	private static final String CREATE_ESB_PROJECT_MODEL_PROPERTY = "create.esb.prj";
	private static final String CREATE_ESB_AF_MODEL_PROPERTY = "create.esb.af";
	
	@Override
	public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		if (CONFIG_NAME_MODEL_PROPERTY.equals(modelProperty)) {
			if (value == null) {
				throw new FieldValidationException(SYNAPSE_CONFIG_NAME_EMPTY_ERROR);
			}
			String projectName = value.toString();
			if (StringUtils.isBlank(projectName)) {
				throw new FieldValidationException(SYNAPSE_CONFIG_NAME_EMPTY_ERROR);
			}
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

			if (project.exists()) {
				throw new FieldValidationException(SYNAPSE_CONFIG_NAME_MATCHED_PROJECT_NAME_ERROR);
			}	
		
		} else if (SAVE_FILE_MODEL_PROPERTY.equals(modelProperty)) {
			IResource resource = (IResource) value;
			if (resource == null || !resource.exists()) {
				throw new FieldValidationException(PROJECT_OR_PATH_DOES_NOT_EXIST_ERROR);
			}
		} else if (IMPORT_FILE_MODEL_PROPERTY.equals(modelProperty) || AVAILABLE_MODEL_PROPERTY.equals(modelProperty)) {
			SynapseModel synapseModel = (SynapseModel) model;

			if (java.io.File.class.equals(value.getClass())) {
				String name = value.toString();
				if (StringUtils.isBlank(name)) {
					throw new FieldValidationException(CONFIG_FILE_LOCATION_INVALID_ERROR);
				} else {
					File configFile = (File) value;
					if (!configFile.exists()) {
						throw new FieldValidationException(CONFIG_FILE_DOES_NOT_EXIST_ERROR);
					}
				}
			}
			if (synapseModel.getSelectedArtifacts().isEmpty()) {
				throw new FieldValidationException(SELECT_ATLEAST_ONE_ARTIFACT_ERROR);
			}
		}
	}
	
	@Override
    public List<String> getUpdateFields(String modelProperty,ProjectDataModel model) {
    	List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if (CREATE_ESB_PROJECT_MODEL_PROPERTY.equals(modelProperty)) {
			updateFields.add(SAVE_FILE_MODEL_PROPERTY);
		} else if (CREATE_ESB_AF_MODEL_PROPERTY.equals(modelProperty)) {
			updateFields.add(AVAILABLE_MODEL_PROPERTY);
		} else if (IMPORT_FILE_MODEL_PROPERTY.equals(modelProperty)) {
			updateFields.add(AVAILABLE_MODEL_PROPERTY);
		}
    	return updateFields;
    }

	@Override
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals(SAVE_FILE_MODEL_PROPERTY)) {
			readOnlyField = true;
		}
	    return readOnlyField;
	}
}
