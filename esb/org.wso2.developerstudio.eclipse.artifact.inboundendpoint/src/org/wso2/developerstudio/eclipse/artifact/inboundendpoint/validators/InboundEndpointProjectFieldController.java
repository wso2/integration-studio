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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;
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

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		InboundEndpointModel inboundEndpointModel =(InboundEndpointModel)model;
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
							esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
							List<ESBArtifact> allArtifacts = esbProjectArtifact.getAllESBArtifacts();
							for (ESBArtifact artifact : allArtifacts) {
								if (resource.equals(artifact.getName())) {
									throw new FieldValidationException("Artifact name already exists");
								}
							}

						} catch (Exception e) {
							log.error("Validation failure - Error while reading artifact.xml",e);
							throw new FieldValidationException("Validation failure - Error while reading artifact.xml",e);
						}
					}
				}		 	 
			}

		} else if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportOption)) {
			CommonFieldValidator.validateImportFile(value);
		
		} else if (InboundEndpointArtifactProperties.wizardOptionSaveLocation.equals(modelProperty)) {
			IResource resource = (IResource)value;
			if(resource==null || !resource.exists()){	
				throw new FieldValidationException("Specified project or path doesn't exist");
			}
		}
		else if(InboundEndpointArtifactProperties.wizardOptionSequence.equals(modelProperty)){
				String resource = value.toString();
				if(resource==null||"".equals(resource)){
					throw new FieldValidationException("Sequence value cannot be empty");
				}				
		}	
		else if(InboundEndpointArtifactProperties.wizardOptionErrorSequence.equals(modelProperty)){
				String resource = value.toString();
				if(resource==null||"".equals(resource)){
					throw new FieldValidationException("Error sequence value cannot be empty");
				}
		}
		else if(InboundEndpointArtifactProperties.wizardOptionInboundHTTPPort.equals(modelProperty)){
			 if(InboundEndpointArtifactProperties.typeHTTP.equals(selectedInboundEndpointType)){
				 String resource = value.toString();
					if(resource==null||"".equals(resource)){
						throw new FieldValidationException("Inbound http port value cannot be empty");
				}
			}
		}
	}
	
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);
		if(modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionSequence) || 
		   modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionErrorSequence)  || 
		   modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionInboundHTTPPort) ||
		   modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionInterval) ||
		   modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionSequential) ||
		   modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileURI) ||
		   modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionClass)){
			Map<String, List<String>> leTypeFieldProperties = getLETypeFieldProperties();
			List<String> list = leTypeFieldProperties.get(((InboundEndpointModel) model).getSelectedInboundEndpointType());
			
			if(list!= null){
				for (String control : list) {
					visibleField = false;
				}
				if (list.contains(modelProperty)) {
					visibleField = true;
				} else {
					visibleField = false;
				}
			}
		}

		
		
		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionAvailableIEs)) {
			List<OMElement> availableLEList = ((InboundEndpointModel) model).getAvailableLEList();
			visibleField = (availableLEList != null && availableLEList.size() > 0);
		}
		
		return visibleField;
	}
	
	private Map<String, List<String>> getLETypeFieldProperties() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put(InboundEndpointArtifactProperties.typeHTTP, Arrays.asList(new String[] {InboundEndpointArtifactProperties.wizardOptionSequence,InboundEndpointArtifactProperties.wizardOptionErrorSequence,InboundEndpointArtifactProperties.wizardOptionInboundHTTPPort}));
		map.put(InboundEndpointArtifactProperties.typeFile, Arrays.asList(new String[] {InboundEndpointArtifactProperties.wizardOptionSequence,InboundEndpointArtifactProperties.wizardOptionErrorSequence,InboundEndpointArtifactProperties.wizardOptionInterval,InboundEndpointArtifactProperties.wizardOptionSequential,InboundEndpointArtifactProperties.wizardOptionVFSFileURI}));
		map.put(InboundEndpointArtifactProperties.typeJMS, Arrays.asList(new String[] {InboundEndpointArtifactProperties.wizardOptionInboundHTTPPort}));
		map.put(InboundEndpointArtifactProperties.typeCustom, Arrays.asList(new String[] {InboundEndpointArtifactProperties.wizardOptionSequence,InboundEndpointArtifactProperties.wizardOptionErrorSequence,InboundEndpointArtifactProperties.wizardOptionClass, InboundEndpointArtifactProperties.wizardOptionInterval, InboundEndpointArtifactProperties.wizardOptionSequential}));
		
		return map;
	}
	
	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionIEType)) {
			Map<String, List<String>> templateFieldProperties = getLETypeFieldProperties();
			for (List<String> fields : templateFieldProperties.values()) {
				updateFields.addAll(fields);
			}
		}else if(modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportSourceUrlIEUrl)){
			updateFields.add(InboundEndpointArtifactProperties.wizardOptionImportSourceUrlIEUrl);
		}else if(modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportFilePath)){
			updateFields.add(InboundEndpointArtifactProperties.wizardOptionAvailableIEs);
		}else if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionCreateESBProject)) {
			updateFields.add(InboundEndpointArtifactProperties.wizardOptionSaveLocation);
		}
		return updateFields;
	}
	
	public boolean isEnableField(String modelProperty, ProjectDataModel model) {
		boolean enableField = super.isEnableField(modelProperty, model);
		if(modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportFilePath)){
			enableField = true;
		}
		return enableField;
	}
	
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals("save.file")) {
			readOnlyField = true;
		}
	    return readOnlyField;
	}
}
