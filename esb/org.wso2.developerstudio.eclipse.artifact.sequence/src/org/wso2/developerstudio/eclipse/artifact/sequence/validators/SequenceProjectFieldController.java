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

package org.wso2.developerstudio.eclipse.artifact.sequence.validators;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.sequence.model.SequenceModel;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import java.util.List;

public class SequenceProjectFieldController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		if (modelProperty.equals("sequence.name")) {
		     CommonFieldValidator.validateArtifactName(value);
			if (value != null) {
				String resource = value.toString();
				SequenceModel sqModel = (SequenceModel) model;
				if (sqModel != null) {
					IContainer resLocation = sqModel.getSequenceSaveLocation();
					if (resLocation != null) {
						IProject project = resLocation.getProject();
						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
						try {
							esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
							List<ESBArtifact> allArtifacts = esbProjectArtifact.getAllESBArtifacts();
							for (ESBArtifact artifact : allArtifacts) {
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
		} else if(modelProperty.equals("reg.browse")){
			SequenceModel seqModel = (SequenceModel) model; 
			if(seqModel.isSaveAsDynamic()){
				if(null==value || value.toString().trim().isEmpty()){
					throw new FieldValidationException("Registry path cannot be empty");
				}
			}
			
		}  else if(modelProperty.equals("available.sequences")){
			SequenceModel seqModel = (SequenceModel) model; 
			if(null!=seqModel.getAvailableSeqList() && seqModel.getAvailableSeqList().size()>0){
				if(null==seqModel.getSelectedSeqList() || seqModel.getSelectedSeqList().size() <=0){
					throw new FieldValidationException("Please select at least one artifact");
				}
		}
		}

	}

	
	public boolean isEnableField(String modelProperty, ProjectDataModel model) {
		boolean enableField = super.isEnableField(modelProperty, model);
		if (modelProperty.equals("reg.path") || modelProperty.equals("reg.browse")) {
			enableField = ((SequenceModel) model).isSaveAsDynamic();
		} else if (modelProperty.equals("import.file")) {
			enableField = true;
		}
		return enableField;
	}

	
	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if (modelProperty.equals("dynamic.sequence")) {
			updateFields.add("reg.path");
			updateFields.add("reg.browse");
			updateFields.add("save.file");
		} else if (modelProperty.equals("import.file")) {
			updateFields.add("available.sequences");
		} else if (modelProperty.equals("create.esb.prj")) {
			updateFields.add("save.file");
		} else if (modelProperty.equals("reg.path")){
			updateFields.add("reg.browse");
		}
		return updateFields;
	}

	
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);
		if (modelProperty.equals("available.sequences")) {
			List<OMElement> availableSeqList = ((SequenceModel) model).getAvailableSeqList();
			visibleField = (availableSeqList != null && availableSeqList.size() > 0);
		}
		return visibleField;

	}
	
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals("save.file")) {
			readOnlyField = true;
		} else if (modelProperty.equals("reg.browse")) {
			readOnlyField = true;
		} 
	    return readOnlyField;
	}

}
