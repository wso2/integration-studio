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

package org.wso2.developerstudio.eclipse.artifact.template.integration.validators;

import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.artifact.template.integration.model.IntegrationTemplateModel;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationArtifact;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationProjectArtifact;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import static org.wso2.developerstudio.eclipse.artifact.template.integration.utils.IntegrationTemplateConstants.NAME_FIELD_ID;
import static org.wso2.developerstudio.eclipse.artifact.template.integration.utils.IntegrationTemplateConstants.ARTIFACT_XML_FILE_NAME;

public class IntegrationTemplateProjectFieldController {// extends
                                                        // TemplateProjectFieldController
                                                        // {

    public IntegrationTemplateProjectFieldController() {
        // super();
    }

    public void validate(String modelProperty, Object propertyValue,
                         ProjectDataModel dataModel) throws FieldValidationException {
        // super.validate();
        IntegrationTemplateModel integrationTemplateModel = (IntegrationTemplateModel) dataModel;

        if (modelProperty.equals(NAME_FIELD_ID)) {
            CommonFieldValidator.validateArtifactName(propertyValue);
            String resource = propertyValue.toString();
            if (integrationTemplateModel != null) {
                IContainer saveLocation = integrationTemplateModel.getTemplateSaveLocation();
                if (saveLocation != null) {
                    IProject project = saveLocation.getProject();
                    IntegrationProjectArtifact integrationProjectArtifact =
                                                                          new IntegrationProjectArtifact();
                    try {
                        integrationProjectArtifact.fromFile(project.getFile(ARTIFACT_XML_FILE_NAME)
                                                                   .getLocation().toFile());
                        List<IntegrationArtifact> allArtifacts =
                                                               integrationProjectArtifact.getAllIntegrationArtifacts();
                        for (IntegrationArtifact artifact : allArtifacts) {
                            if (resource.equals(artifact.getName())) {
                                throw new FieldValidationException("Artifact name already exists");
                            }
                        }
                    } catch (Exception e) {
                        throw new FieldValidationException("Unexpected error occurred while validating artifact name",
                                                           e);
                    }
                }
            }
        }
    }

}
