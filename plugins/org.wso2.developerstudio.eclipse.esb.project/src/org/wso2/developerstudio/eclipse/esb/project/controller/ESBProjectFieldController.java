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

package org.wso2.developerstudio.eclipse.esb.project.controller;

import java.io.File;

import org.wso2.developerstudio.eclipse.esb.project.model.ESBSolutionProjectModel;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

public class ESBProjectFieldController extends AbstractFieldController {

    public void validate(String modelProperty, Object value, ProjectDataModel model) throws FieldValidationException {
        if (modelProperty.equals("mmm.project.name")) {
            CommonFieldValidator.validateProjectField(value, "Integration Project");
        } else if (model instanceof ESBSolutionProjectModel) {
            ESBSolutionProjectModel esbSolutionProjectModel = (ESBSolutionProjectModel) model;
            if (modelProperty.equals("project.name")) {
                if (esbSolutionProjectModel.isConfigProjectChecked()) {
                    CommonFieldValidator.validateProjectField(value, "ESB Configs");
                }
            } else if (modelProperty.equals("solution.capp")) {
                if (esbSolutionProjectModel.isCappProjectChecked()) {
                    CommonFieldValidator.validateProjectField(value, "Composite Exporter");
                }
            } else if (modelProperty.equals("solution.registry")) {
                if (esbSolutionProjectModel.isRegistryProjectChecked()) {
                    CommonFieldValidator.validateProjectField(value, "Registry Resources");
                }
            } else if (modelProperty.equals("solution.connector")) {
                if (esbSolutionProjectModel.isConnectorExporterProjectChecked()) {
                    CommonFieldValidator.validateProjectField(value, "Connector Exporter");
                }
            } else if (modelProperty.equals("solution.docker")) {
                if (esbSolutionProjectModel.isDockerExporterProjectChecked()) {
                    CommonFieldValidator.validateProjectField(value, "Docker Exporter");
                }
            } else if (modelProperty.equals("solution.kubernetes")) {
                if (esbSolutionProjectModel.isKubernetesExporterProjectChecked()) {
                    CommonFieldValidator.validateProjectField(value, "Kubernetes Exporter");
                }
            } else if (modelProperty.equals("synapseConfig.location")) {
                if (value == null) {
                    throw new FieldValidationException("Specified folder location is invalid");
                }
                String name = value.toString();
                if (name.trim().equals("")) {
                    throw new FieldValidationException("Specified folder location is invalid");
                } else {
                    File folderLocation = (File) value;
                    if (!folderLocation.exists()) {
                        throw new FieldValidationException("Specified folder doesn't exist");
                    }
                }
            }
            if (doProjectsHaveSameName(modelProperty, value, esbSolutionProjectModel)) {
                throw new FieldValidationException("Two modules cannot have the same name.");
            }
        }
    }

    private boolean doProjectsHaveSameName(String modelProperty, Object value,
            ESBSolutionProjectModel esbSolutionProjectModel) {
        String projectName = value.toString();
        if (!modelProperty.equals("mmm.project.name") && esbSolutionProjectModel.isMMMProjectChecked()
                && projectName.equals(esbSolutionProjectModel.getMMMProjectName())) {
            return true;
        }
        if (!modelProperty.equals("project.name") && esbSolutionProjectModel.isConfigProjectChecked()
                && projectName.equals(esbSolutionProjectModel.getProjectName())) {
            if (!modelProperty.equals("mmm.project.name")
                    || (modelProperty.equals("mmm.project.name") && esbSolutionProjectModel.isMMMProjectChecked())) {
                return true;
            }
        }
        if (!modelProperty.equals("solution.capp") && esbSolutionProjectModel.isCappProjectChecked()
                && projectName.equals(esbSolutionProjectModel.getCompositeApplicationProjectName())) {
            return true;
        }
        if (!modelProperty.equals("solution.registry") && esbSolutionProjectModel.isRegistryProjectChecked()
                && projectName.equals(esbSolutionProjectModel.getRegistryProjectName())) {
            return true;
        }
        if (!modelProperty.equals("solution.connector") && esbSolutionProjectModel.isConnectorExporterProjectChecked()
                && projectName.equals(esbSolutionProjectModel.getConnectorExporterProjectName())) {
            return true;
        }
        if (!modelProperty.equals("solution.docker") && esbSolutionProjectModel.isDockerExporterProjectChecked()
                && projectName.equals(esbSolutionProjectModel.getDockerExporterProjectName())) {
            return true;
        }
        if (!modelProperty.equals("solution.kubernetes") && esbSolutionProjectModel.isKubernetesExporterProjectChecked()
                && projectName.equals(esbSolutionProjectModel.getKubernetesExporterProjectName())) {
            return true;
        }
        return false;
    }
}
