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
package org.wso2.developerstudio.eclipse.artifact.template.validators;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.template.model.TemplateModel;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import static org.wso2.developerstudio.eclipse.artifact.template.utils.TemplateConstants.*;

/**
 * TemplateProjectFieldController is the class that validates project fields required for an ESB Template project creation
 * It overwrites the methods from AbstractFieldController class
 */
public class TemplateProjectFieldController extends AbstractFieldController {
    private Pattern urlPattern;
    private Matcher matcher;

    public TemplateProjectFieldController() {
        urlPattern = Pattern.compile("\\$.*");
        matcher = urlPattern.matcher("");
    }

    /**
     * {@inheritDoc}
     */
    public void validate(String modelProperty, Object propertyValue,
                         ProjectDataModel dataModel) throws FieldValidationException {
        TemplateModel templateModel = (TemplateModel) dataModel;
        String templateName = "";
        if (templateModel != null && templateModel.getSelectedTemplate() != null) {
            templateName = templateModel.getSelectedTemplate().getName();
        }
        boolean isAddressEndPoint = ADDRESS_ENDPOINT_TEMPLATE_NAME.equals(templateName);
        boolean isWSDLEndPoint = WSDL_ENDPOINT_TEMPLATE_NAME.equals(templateName);
        boolean isHTTPEndPoint = HTTP_ENDPOINT_TEMPLATE_NAME.equals(templateName);

        if (modelProperty.equals(NAME_FIELD_ID)) {
            CommonFieldValidator.validateArtifactName(propertyValue);
            String resource = propertyValue.toString();
            if (templateModel != null) {
                IContainer saveLocation = templateModel.getTemplateSaveLocation();
                if (saveLocation != null) {
                    IProject project = saveLocation.getProject();
                    ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
                    try {
                        esbProjectArtifact.fromFile(project.getFile(ARTIFACT_XML_FILE_NAME).getLocation().toFile());
                        List<ESBArtifact> allArtifacts = esbProjectArtifact.getAllESBArtifacts();
                        for (ESBArtifact artifact : allArtifacts) {
                            if (resource.equals(artifact.getName())) {
                                throw new FieldValidationException("Artifact name already exists");
                            }
                        }
                    } catch (Exception e) {
                        throw new FieldValidationException("Unexpected error occurred while validating artifact name", e);
                    }
                }
            }
        } else if (modelProperty.equals(IMPORT_FILE_FIELD_ID)) {
			CommonFieldValidator.validateImportFile(propertyValue);
			File templateFile = (File) propertyValue;
			if (templateFile.isDirectory()) {
				throw new FieldValidationException(
						"Specified configuration file is a directory");
			}
        } else if (modelProperty.equals(SAVE_FILE_FIELD_ID)) {
            IResource resource = (IResource) propertyValue;
            if (null == resource || !resource.exists()) {
                throw new FieldValidationException("Specified project or path doesn't exist");
            }
        } else if (modelProperty.equals(AVAILABLE_SEQUENCES_ID)) {
            TemplateModel seqModel = (TemplateModel) dataModel;
            if (null != seqModel.getAvailableSeqList() && seqModel.getAvailableSeqList().size() > 0) {
                if (null == seqModel.getSelectedTempSequenceList() || seqModel.getSelectedTempSequenceList().size() <= 0) {
                    throw new FieldValidationException("Please select at least one artifact");
                }
            }
        } else if (modelProperty.equals(ADDRESS_EP_URI_FIELD_ID) && isAddressEndPoint) {
            if (propertyValue == null || propertyValue.toString().trim().isEmpty()) {
                throw new FieldValidationException("Address url cannot be empty");
            } else {
                if (!isParameterized(propertyValue.toString().trim())) {
                    CommonFieldValidator.isValidUrl(propertyValue.toString().trim(), ADDRESS_URL_NAME);
                }
            }
        } else if (modelProperty.equals(WSDL_EP_URI_FIELD_ID) && isWSDLEndPoint) {
            if (propertyValue == null || propertyValue.toString().trim().isEmpty()) {
                throw new FieldValidationException("WSDL url cannot be empty");
            } else {
                CommonFieldValidator.isValidUrl(propertyValue.toString().trim(), WSDL_URL_NAME);
            }
        } else if (modelProperty.equals(WSDL_EP_SERVICE_FIELD_ID) && isWSDLEndPoint) {
            if (propertyValue == null || propertyValue.toString().trim().isEmpty()) {
                throw new FieldValidationException("WSDL service cannot be empty");
            }
        } else if (modelProperty.equals(WSDL_EP_PORT_ID) && isWSDLEndPoint) {
            if (propertyValue == null || propertyValue.toString().trim().isEmpty()) {
                throw new FieldValidationException("WSDL port cannot be empty");
            } else if (!isInteger(propertyValue.toString())) {
                throw new FieldValidationException("WSDL port should be an integer number");
            }
        } else if (modelProperty.equals(HTTP_EP_URI_TEMPLATE_ID) && isHTTPEndPoint) {
            if (propertyValue == null || propertyValue.toString().trim().isEmpty()) {
                throw new FieldValidationException("URI Template cannot be empty");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEnableField(String modelProperty, ProjectDataModel model) {
        boolean enableField = super.isEnableField(modelProperty, model);
        if (modelProperty.equals(IMPORT_FILE_FIELD_ID)) {
            enableField = true;
        }
        return enableField;
    }

    /**
     * {@inheritDoc}
     */
    public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
        List<String> updateFields = super.getUpdateFields(modelProperty, model);
        if (modelProperty.equals(IMPORT_FILE_FIELD_ID)) {
            updateFields.add(AVAILABLE_SEQUENCES_ID);
        } else if (modelProperty.equals(CREATE_ESB_PRJ_ID)) {
            updateFields.add(SAVE_FILE_FIELD_ID);
        } else if (modelProperty.equals(TEMP_TYPE_ID)) {
            Map<String, List<String>> templateFieldProperties = getTemplateFieldProperties();
            for (List<String> fields : templateFieldProperties.values()) {
                updateFields.addAll(fields);
            }
        }
        return updateFields;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
        boolean visibleField = super.isVisibleField(modelProperty, model);
        if (modelProperty.equals(AVAILABLE_SEQUENCES_ID)) {
            List<OMElement> availableSeqList = ((TemplateModel) model).getAvailableSeqList();
            visibleField = (availableSeqList != null && availableSeqList.size() > 0);
        }
        if (modelProperty.startsWith(TEMPL_PREFIX)) {
            Map<String, List<String>> templateFieldProperties = getTemplateFieldProperties();
            List<String> list = templateFieldProperties.get(((TemplateModel) model).getSelectedTemplate().getId());
            if (list.contains(modelProperty)) {
                visibleField = true;
            } else {
                visibleField = false;
            }
        }
        return visibleField;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
        boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
        if (modelProperty.equals(SAVE_FILE_FIELD_ID)) {
            readOnlyField = true;
        }
        return readOnlyField;
    }

    private Map<String, List<String>> getTemplateFieldProperties() {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        map.put("org.wso2.developerstudio.eclipse.esb.template.sq_template",
                Arrays.asList(new String[]{}));
        map.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.default",
                Arrays.asList(new String[]{}));
        map.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.Address",
                Arrays.asList("templ.address.ep.uri"));
        map.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.wsdl",
                Arrays.asList("templ.wsdl.ep.uri", "templ.wsdl.ep.service", "templ.wsdl.ep.port"));
        map.put("org.wso2.developerstudio.eclipse.esb.template.endpoint_templates.http",
                Arrays.asList("templ.http.ep.uritemplate", "templ.http.ep.method"));

        return map;

    }

    private boolean isParameterized(String url) {
        boolean isValid = false;
        matcher.reset(url);
        while (matcher.find()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Method checks whether given String can be passed as an Integer
     * Returns 'true' if given String can be passed as an Integer otherwise returns 'false'
     */
    private boolean isInteger(String stringValue) {
        try {
            Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
