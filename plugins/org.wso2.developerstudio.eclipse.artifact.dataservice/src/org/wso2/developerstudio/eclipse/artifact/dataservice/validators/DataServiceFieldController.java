/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.artifact.dataservice.validators;

import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import java.io.File;
import java.util.List;

public class DataServiceFieldController extends AbstractFieldController {

	public void validate(String modelProperty, Object value, ProjectDataModel model)
			throws FieldValidationException {
		if (modelProperty.equals(DataServiceArtifactConstants.WIZARD_OPTION_PROJECT_NAME)) {
			CommonFieldValidator.validateProjectField(value);
		} else if (modelProperty.equals(DataServiceArtifactConstants.WIZARD_OPTION_IMPORT_FILE)) {
			if (value == null) {
				throw new FieldValidationException(DataServiceArtifactConstants.ERROR_DBS_LOCATION);
			}
			File warFile = (File) value;
			if (!warFile.exists()) {
				throw new FieldValidationException(DataServiceArtifactConstants.ERROR_DBS_FILE);
			}
		} else if (modelProperty.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_NAME)) {
			if (value == null || value.equals("")) {
				throw new FieldValidationException(DataServiceArtifactConstants.ERROR_DS_NAME);
			}
		}else if (modelProperty.equals(DataServiceArtifactConstants.WIZARD_OPTION_SAVE_FILE)) {
			if (value == null || value.equals("")) {
				throw new FieldValidationException(DataServiceArtifactConstants.ERROR_DS_PROJECT);
			}
			IResource resource = (IResource)value;
			if(resource==null || !resource.exists())	
				throw new FieldValidationException(DataServiceArtifactConstants.ERROR_DS_PROJECT_PATH);
		}
	}
	
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals(DataServiceArtifactConstants.WIZARD_OPTION_SAVE_FILE)) {
			readOnlyField = true;
		}
	    return readOnlyField;
	}
	
	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		 if (modelProperty.equals(DataServiceArtifactConstants.CREATE_DS_PROJECT)) {
			updateFields.add(DataServiceArtifactConstants.WIZARD_OPTION_SAVE_FILE);
		 }
		return updateFields;
	}
}
