/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.esb.project.controller;

import java.util.List;

import org.wso2.developerstudio.eclipse.esb.project.model.ESBSolutionProjectModel;
import static org.wso2.developerstudio.eclipse.esb.project.utils.SolutionProjectArtifactConstants.*;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class ESBSolutionProjectFieldController extends ESBProjectFieldController {

	@Override
	public void validate(String modelProperty, Object value, ProjectDataModel model) throws FieldValidationException {
		super.validate(modelProperty, value, model);
	}

	@Override
	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if (modelProperty.equals(ESB_PROJECT_NAME)) {
			updateFields.add(REGISTRY_RESOURCES_PROJECT_NAME);
			updateFields.add(CONNECTOR_EXPORTER_PROJECT_NAME);
			updateFields.add(COMPOSITE_APPLICATION_PROJECT_NAME);
		} else if (modelProperty.equals(REGISTRY_PROJECT_CHECKED)) {
			updateFields.add(REGISTRY_RESOURCES_PROJECT_NAME);
		} else if (modelProperty.equals(CONNECTOR_EXPORTER_PROJECT_CHECKED)) {
			updateFields.add(CONNECTOR_EXPORTER_PROJECT_NAME);
		} else if (modelProperty.equals(CAPP_PROJECT_CHECKED)) {
			updateFields.add(COMPOSITE_APPLICATION_PROJECT_NAME);
		}
		return updateFields;
	}

	@Override
	public boolean isEnableField(String modelProperty, ProjectDataModel model) {
		boolean enable = super.isEnableField(modelProperty, model);
		boolean registryEnabled = ((ESBSolutionProjectModel) model).isRegistryProjectChecked();
		boolean connectorEnabled = ((ESBSolutionProjectModel) model).isConnectorExporterProjectChecked();
		boolean cappEnabled = ((ESBSolutionProjectModel) model).isCappProjectChecked();
		if (modelProperty.equals(REGISTRY_RESOURCES_PROJECT_NAME)) {
			enable = registryEnabled;
		} else if (modelProperty.equals(CONNECTOR_EXPORTER_PROJECT_NAME)) {
			enable = connectorEnabled;
		} else if (modelProperty.equals(COMPOSITE_APPLICATION_PROJECT_NAME)) {
			enable = cappEnabled;
		}
		return enable;
	}
}
