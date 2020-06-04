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

    /**
     * Specifies which fields to change upon the changes of other fields on the wizard.
     */
    @Override
    public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
        List<String> updateFields = super.getUpdateFields(modelProperty, model);
        if (modelProperty.equals(MMM_PROJECT_NAME)) {

            if (model instanceof ESBSolutionProjectModel) {
                ESBSolutionProjectModel esbSolutionModel = (ESBSolutionProjectModel) model;
                if (esbSolutionModel.isConfigProjectChecked()) {
                    updateFields.add(ESB_PROJECT_NAME);
                }
                if (esbSolutionModel.isCappProjectChecked()) {
                    updateFields.add(COMPOSITE_APPLICATION_PROJECT_NAME);
                }
                if (esbSolutionModel.isConnectorExporterProjectChecked()) {
                    updateFields.add(CONNECTOR_EXPORTER_PROJECT_NAME);
                }
                if (esbSolutionModel.isRegistryProjectChecked()) {
                    updateFields.add(REGISTRY_RESOURCES_PROJECT_NAME);
                }
                if (esbSolutionModel.isDockerExporterProjectChecked()) {
                    updateFields.add(DOCKER_EXPORTER_PROJECT_NAME);
                }
                if (esbSolutionModel.isKubernetesExporterProjectChecked()) {
                    updateFields.add(KUBERNETES_EXPORTER_PROJECT_NAME);
                }
            }
        } else if (modelProperty.equals(ESB_PROJECT_CHOICE)) {
            updateFields.add(ESB_PROJECT_NAME);
        } else if (modelProperty.equals(MMM_PROJECT_CHOICE)) {
            updateFields.add(ESB_PROJECT_NAME);
            updateFields.add(ESB_PROJECT_CHOICE);
        } else if (modelProperty.equals(REGISTRY_PROJECT_CHECKED)) {
            updateFields.add(REGISTRY_RESOURCES_PROJECT_NAME);
        } else if (modelProperty.equals(CONNECTOR_EXPORTER_PROJECT_CHECKED)) {
            updateFields.add(CONNECTOR_EXPORTER_PROJECT_NAME);
        } else if (modelProperty.equals(CAPP_PROJECT_CHECKED)) {
            updateFields.add(COMPOSITE_APPLICATION_PROJECT_NAME);
        } else if (modelProperty.equals(DOCKER_EXPORTER_PROJECT_CHECKED)) {
            updateFields.add(DOCKER_EXPORTER_PROJECT_NAME);
        } else if (modelProperty.equals(KUBERNETES_EXPORTER_PROJECT_CHECKED)) {
            updateFields.add(KUBERNETES_EXPORTER_PROJECT_NAME);
        }
        return updateFields;
    }

    /**
     * Defines conditions to enable/disable field on the wizard.
     */
    @Override
    public boolean isEnableField(String modelProperty, ProjectDataModel model) {
        boolean mmmProjectEnabled = ((ESBSolutionProjectModel) model).isMMMProjectChecked();
        if (modelProperty.equals(REGISTRY_RESOURCES_PROJECT_NAME)) {
            return ((ESBSolutionProjectModel) model).isRegistryProjectChecked();
        } else if (modelProperty.equals(CONNECTOR_EXPORTER_PROJECT_NAME)) {
            return ((ESBSolutionProjectModel) model).isConnectorExporterProjectChecked();
        } else if (modelProperty.equals(COMPOSITE_APPLICATION_PROJECT_NAME)) {
            return ((ESBSolutionProjectModel) model).isCappProjectChecked();
        } else if (modelProperty.equals(DOCKER_EXPORTER_PROJECT_NAME)) {
            return ((ESBSolutionProjectModel) model).isDockerExporterProjectChecked();
        } else if (modelProperty.equals(KUBERNETES_EXPORTER_PROJECT_NAME)) {
            return ((ESBSolutionProjectModel) model).isKubernetesExporterProjectChecked();
        } else if (modelProperty.equals(ESB_PROJECT_NAME)) {
            if (!mmmProjectEnabled) {
                return false;
            } else {
                return ((ESBSolutionProjectModel) model).isConfigProjectChecked();
            }
        } else if (modelProperty.equals(ESB_PROJECT_CHOICE) && !mmmProjectEnabled) {
            return false;
        }
        return super.isEnableField(modelProperty, model);
    }
}
