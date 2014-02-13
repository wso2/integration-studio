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

package org.wso2.developerstudio.eclipse.artifact.endpoint.validators;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.artifact.endpoint.Activator;
import org.wso2.developerstudio.eclipse.artifact.endpoint.model.EndpointModel;
import org.wso2.developerstudio.eclipse.artifact.endpoint.utils.EpArtifactConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;

public class EndpointProjectFieldController extends AbstractFieldController {
	
	private static IDeveloperStudioLog log =Logger.getLog(Activator.PLUGIN_ID);

	IProject project =null;
	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		EndpointModel epModel = (EndpointModel) model; 
		String templateName = new String();
		if(epModel!=null && epModel.getSelectedTemplate()!=null){
			templateName = epModel.getSelectedTemplate().getName();
		}
		boolean isAddressEP = EpArtifactConstants.ADDRESS_EP.equals(templateName);
		boolean isWSDlEP = EpArtifactConstants.WSDL_EP.equals(templateName);
		boolean isHttpEP = EpArtifactConstants.HTTP_EP.equals(templateName);
		
	   if (modelProperty.equals("ep.name")) {
			CommonFieldValidator.validateArtifactName(value);	
			if (value != null) {
				String resource = value.toString();
				EndpointModel endpointModel = (EndpointModel) model;
				if (endpointModel != null) {
					IContainer resLocation = endpointModel.getEndpointSaveLocation();
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
		}else if (modelProperty.equals("import.file")) {
			CommonFieldValidator.validateImportFile(value);
		}else if (modelProperty.equals("save.file")) {
				IResource resource = (IResource)value;
				if(resource==null || !resource.exists()){	
					throw new FieldValidationException("Specified project or path doesn't exist");
				}						
		}else if (modelProperty.equals("templ.address.ep.uri") && isAddressEP) {	
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException("Address url cannot be empty");				
			} else{
				CommonFieldValidator.isValidUrl(value.toString().trim(), "Address url");
			}
		} else if (modelProperty.equals("templ.http.ep.uritemplate") && isHttpEP) {	
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException("URI Template cannot be empty");				
			} 
			//Identified as irrelevant
			//else{
			//	CommonFieldValidator.isValidUrl(value.toString().trim(), "URI Template");
			//}
		} else if (modelProperty.equals("templ.wsdl.ep.uri") && isWSDlEP) {	
			if (value == null || value.toString().trim().isEmpty()) {		
				throw new FieldValidationException("WSDL url cannot be empty");				
			} else{
				CommonFieldValidator.isValidUrl(value.toString().trim(), "WSDL url");
			}
		} else if (modelProperty.equals("templ.wsdl.ep.service") && isWSDlEP) {	
			if (value == null || value.toString().trim().isEmpty()) {				
				throw new FieldValidationException("WSDL service cannot be empty");				
			} 
		} else if (modelProperty.equals("templ.wsdl.ep.port") && isWSDlEP) {	
			if (value == null || value.toString().trim().isEmpty()) {			    
				throw new FieldValidationException("WSDL port cannot be empty");				
			} 
		} else if(modelProperty.equals("registry.browser")){
			if(epModel.getSelectedOption_DynamicEP()){
				if(null==value || value.toString().trim().isEmpty()){					
					throw new FieldValidationException("Registry path cannot be empty");			
				}
			}
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
		
		if (modelProperty.equals("dynamic.ep")) {
			updateFields.add("reg.path");
			updateFields.add("registry.browser");
			updateFields.add("save.file");			
		}else if(modelProperty.equals("static.ep")){
			updateFields.add("reg.path");
			updateFields.add("registry.browser");
			updateFields.add("save.file");		
		}else if (modelProperty.equals("import.file")) {
			updateFields.add("available.eps");
		} else if (modelProperty.equals("create.esb.prj")) {
			updateFields.add("save.file");
		}else if (modelProperty.equals("ep.type")) {
			Map<String, List<String>> templateFieldProperties = getTemplateFieldProperties();
			for (List<String> fields : templateFieldProperties.values()) {
				updateFields.addAll(fields);
			}		
	     }		
		else if (modelProperty.equals("reg.path")) {
			updateFields.add("registry.browser");
		} else if (modelProperty.equals("save.file")){
	     updateFields.add("templ.target.availabletemplates");
			
		}else if (modelProperty.equals("templ.target.availabletemplates")){
			updateFields.add("templ.target.template");
		}		
		return updateFields;
	}

	
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {		
		boolean visibleField = super.isVisibleField(modelProperty, model);	
        if(modelProperty.equals("reg.path")){
        	boolean dynamic = ((EndpointModel)model).getSelectedOption_DynamicEP();
        	boolean statep = ((EndpointModel)model).getSelectedOption_StaticEP();
        	if(dynamic){
        		visibleField = true;
        	}else if(statep){
        		visibleField = false;
        	}
        }
		
        if (modelProperty.equals("registry.browser")){
        	boolean dynamic = ((EndpointModel)model).getSelectedOption_DynamicEP();
        	boolean statep = ((EndpointModel)model).getSelectedOption_StaticEP();
        	if(dynamic){
        		visibleField = true;
        	}else if(statep){
        		visibleField = false;
        	}
        }
		
		if (modelProperty.startsWith("templ.")) {
			Map<String, List<String>> templateFieldProperties = getTemplateFieldProperties();
			List<String> list =
			        templateFieldProperties.get(((EndpointModel) model).getSelectedTemplate()
			                .getId());
			
			visibleField = false;
			if (list != null) {
				if (list.contains(modelProperty)) {
					visibleField = true;
				} 
			}
		}

		if (modelProperty.equals("available.eps")) {
			List<OMElement> availableEPList = ((EndpointModel) model).getAvailableEPList();
			visibleField = (availableEPList != null && availableEPList.size() > 0);
		}
		return visibleField;

	}

	private Map<String, List<String>> getTemplateFieldProperties() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("org.wso2.developerstudio.eclipse.esb.template.ep2", Arrays.asList(new String[] {}));
		map.put("org.wso2.developerstudio.eclipse.esb.template.ep1", Arrays.asList(new String[] { "templ.address.ep.uri" }));
		map.put("org.wso2.developerstudio.eclipse.esb.template.ep5", Arrays.
				asList(new String[] { "templ.wsdl.ep.uri", "templ.wsdl.ep.service", "templ.wsdl.ep.port" }));
		map.put("org.wso2.developerstudio.eclipse.esb.template.ep3", Arrays.asList(new String[] {}));
		map.put("org.wso2.developerstudio.eclipse.esb.template.ep4", Arrays.asList(new String[] {}));
		map.put("org.wso2.developerstudio.eclipse.esb.template.ep7", Arrays
		        .asList(new String[] { "templ.template.ep.uri", "templ.target.template","templ.target.availabletemplates"}));
		map.put("org.wso2.developerstudio.eclipse.esb.template.ep8", Arrays
		        .asList(new String[] { "templ.http.ep.uritemplate", "templ.http.ep.method"}));
		return map;

	}
	
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals("save.file")) {
			readOnlyField = true;
		} else if (modelProperty.equals("registry.browser")) {
			readOnlyField = true;
		} 
	    return readOnlyField;
	}
	
	
	}