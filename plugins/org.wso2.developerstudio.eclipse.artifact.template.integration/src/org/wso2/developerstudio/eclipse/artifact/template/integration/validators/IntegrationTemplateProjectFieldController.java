package org.wso2.developerstudio.eclipse.artifact.template.integration.validators;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.template.integration.model.IntegrationTemplateModel;
import org.wso2.developerstudio.eclipse.artifact.template.model.TemplateModel;
import org.wso2.developerstudio.eclipse.artifact.template.validators.*;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationArtifact;
import org.wso2.developerstudio.eclipse.integration.project.artifact.IntegrationProjectArtifact;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import static org.wso2.developerstudio.eclipse.artifact.template.integration.utils.IntegrationTemplateConstants.NAME_FIELD_ID;
import static org.wso2.developerstudio.eclipse.artifact.template.integration.utils.IntegrationTemplateConstants.ARTIFACT_XML_FILE_NAME;


public class IntegrationTemplateProjectFieldController {//extends TemplateProjectFieldController {

    public IntegrationTemplateProjectFieldController() {
        //super();
    }

    public void validate(String modelProperty, Object propertyValue,
                         ProjectDataModel dataModel) throws FieldValidationException {
    	//super.validate();
        IntegrationTemplateModel integrationTemplateModel = (IntegrationTemplateModel) dataModel;
        
        if (modelProperty.equals(NAME_FIELD_ID)) {
            CommonFieldValidator.validateArtifactName(propertyValue);
            String resource = propertyValue.toString();
            if (integrationTemplateModel != null) {
                IContainer saveLocation = integrationTemplateModel.getTemplateSaveLocation();
                if (saveLocation != null) {
                    IProject project = saveLocation.getProject();
                    IntegrationProjectArtifact integrationProjectArtifact = new IntegrationProjectArtifact();
                    try {
                        integrationProjectArtifact.fromFile(project.getFile(ARTIFACT_XML_FILE_NAME).getLocation().toFile());
                        List<IntegrationArtifact> allArtifacts = integrationProjectArtifact.getAllIntegrationArtifacts();
                        for (IntegrationArtifact artifact : allArtifacts) {
                            if (resource.equals(artifact.getName())) {
                                throw new FieldValidationException("Artifact name already exists");
                            }
                        }
                    } catch (Exception e) {
                        throw new FieldValidationException("Unexpected error occurred while validating artifact name", e);
                    }
                }
            }
        }
    }

   

}
