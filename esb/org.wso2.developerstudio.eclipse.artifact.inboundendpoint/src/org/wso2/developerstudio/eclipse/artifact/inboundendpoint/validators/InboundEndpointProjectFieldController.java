/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.inboundendpoint.validators;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.Activator;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.model.InboundEndpointModel;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.utils.InboundEndpointArtifactProperties;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

public class InboundEndpointProjectFieldController extends AbstractFieldController {

	private final String TYPE_CUSTOM = "Custom";
	private final String ARTIFACT_XML_FILE = "artifact.xml";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public void validate(String modelProperty, Object value, ProjectDataModel model) throws FieldValidationException {
		InboundEndpointModel inboundEndpointModel = (InboundEndpointModel) model;
		String selectedInboundEndpointType = inboundEndpointModel.getSelectedInboundEndpointType();
		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionIEName)) {
			CommonFieldValidator.validateArtifactName(value);
			if (value != null) {
				String resource = value.toString();
				InboundEndpointModel inboundendpointModel = (InboundEndpointModel) model;
				if (inboundendpointModel != null) {
					IContainer saveLocation = inboundendpointModel.getInboundEndpointSaveLocation();
					if (saveLocation != null) {
						IProject project = saveLocation.getProject();
						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
						try {
							esbProjectArtifact.fromFile(project.getFile(ARTIFACT_XML_FILE).getLocation().toFile());
						} catch (Exception e) {
							log.error(InboundEndpointArtifactProperties.validationReadingFile, e);
							throw new FieldValidationException(InboundEndpointArtifactProperties.validationReadingFile,
									e);
						}
						List<ESBArtifact> allArtifacts = esbProjectArtifact.getAllESBArtifacts();
						for (ESBArtifact artifact : allArtifacts) {
							if (resource.equals(artifact.getName())) {
								throw new FieldValidationException(InboundEndpointArtifactProperties.errorNameExists);
							}
						}
					}
				}
			}

		} else if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportOption)) {
			CommonFieldValidator.validateImportFile(value);

		} else if (InboundEndpointArtifactProperties.wizardOptionSaveLocation.equals(modelProperty)) {
			IResource resource = (IResource) value;
			if (resource == null || !resource.exists()) {
				throw new FieldValidationException(InboundEndpointArtifactProperties.errorProjectPath);
			}
		} else if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionClass)) {
			if (((InboundEndpointModel) model).getSelectedInboundEndpointType().equals(TYPE_CUSTOM)) {
				if (value == null || value.equals("")) {
					throw new FieldValidationException(InboundEndpointArtifactProperties.errorClass);
				}
			}
		}
	}

	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);
		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionClass)) {
			if (((InboundEndpointModel) model).getSelectedInboundEndpointType().equals(TYPE_CUSTOM)) {
				visibleField = true;
			} else {
				visibleField = false;
			}
		}
		return visibleField;
	}

	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updatedList = super.getUpdateFields(modelProperty, model);

		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionIEType)) {
			updatedList.add(InboundEndpointArtifactProperties.wizardOptionClass);
		} else if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionCreateESBProject)) {
			updatedList.add(InboundEndpointArtifactProperties.wizardOptionSaveLocation);
		} else if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportFilePath)) {
			updatedList.add(InboundEndpointArtifactProperties.wizardOptionAvailableInboundEndpoints);
		}

		return updatedList;
	}

	public boolean isEnableField(String modelProperty, ProjectDataModel model) {
		boolean enableField = super.isEnableField(modelProperty, model);
		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportFilePath)) {
			enableField = true;
		}
		return enableField;
	}

	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionSaveLocation)) {
			readOnlyField = true;
		}
		return readOnlyField;
	}
}
