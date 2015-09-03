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

package org.wso2.developerstudio.eclipse.artifact.cep.stream.validators;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.cep.stream.model.StreamModel;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifact;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import java.util.List;

public class StreamFieldController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		if (modelProperty.equals("project.name")) {
		     CommonFieldValidator.validateArtifactName(value);
			if (value != null) {
				String resource = value.toString();
				StreamModel esModel = (StreamModel) model;
				if (esModel != null) {
					IContainer resLocation = esModel.getStreamSaveLocation();
					if (resLocation != null) {
						IProject project = resLocation.getProject();
						CEPProjectArtifact cepProjectArtifact = new CEPProjectArtifact();
						try {
							cepProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
							List<CEPArtifact> allArtifacts = cepProjectArtifact.getAllCEPArtifacts();
							for (CEPArtifact artifact : allArtifacts) {
								if (resource.equals(artifact.getName())) {
									throw new FieldValidationException("");
								}
							}

						} catch (Exception e) {
							throw new FieldValidationException("Artifact name already exsits");
						}
					}
				}		 	 
			}     
		} else if (modelProperty.equals("import.file")) {
			 CommonFieldValidator.validateImportFile(value);
		}  else if (modelProperty.equals("save.file")) {
			IResource resource = (IResource)value;
			if(null== resource || !resource.exists())	
				throw new FieldValidationException("Specified project or path doesn't exist");
		}

	}

	
	public boolean isEnableField(String modelProperty, ProjectDataModel model) {
		boolean enableField = super.isEnableField(modelProperty, model);
		if (modelProperty.equals("import.file")) {
			enableField = true;
		}
		return enableField;
	}

	
	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if (modelProperty.equals("import.file")) {
			updateFields.add("available.eventstream");
		} else if (modelProperty.equals("create.esb.prj")) {
			updateFields.add("save.file");
		}
		return updateFields;
	}

	
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);
		if (modelProperty.equals("available.eventstream")) {
			List<OMElement> availableEventstreamList = ((StreamModel) model).getAvailableEventstreamList();
			visibleField = (availableEventstreamList != null && availableEventstreamList.size() > 0);
		}
		return visibleField;

	}
	
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals("save.file")) {
			readOnlyField = true;
		}
	    return readOnlyField;
	}

}
