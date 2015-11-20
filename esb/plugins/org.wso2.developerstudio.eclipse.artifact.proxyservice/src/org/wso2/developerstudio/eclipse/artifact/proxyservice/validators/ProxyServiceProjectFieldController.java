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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.validators;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.model.ProxyServiceModel;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.model.ProxyServiceModel.TargetEPType;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.PsArtifactConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import java.util.List;

public class ProxyServiceProjectFieldController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		boolean optWsdlbasedProxy = false;
		boolean optCustomProxy  = false;
		ArtifactTemplate selectedTemplate = (ArtifactTemplate)model.getModelPropertyValue("ps.type"); 
		if(selectedTemplate!=null){
			optWsdlbasedProxy = selectedTemplate.getId().equalsIgnoreCase(PsArtifactConstants.WSDL_BASED_PROXY_TEMPL_ID);
			optCustomProxy = (selectedTemplate.isCustom() || selectedTemplate.getId()
					.equalsIgnoreCase(PsArtifactConstants.CUSTOM_PROXY_TEMPL_ID));
		}
		if (modelProperty.equals("ps.name")) {
			CommonFieldValidator.validateArtifactName(value);
			if (value != null) {
				String resource = value.toString();
				ProxyServiceModel proxyModel = (ProxyServiceModel) model;
				if (proxyModel != null) {
					IContainer resLocation = proxyModel.getProxyServiceSaveLocation();
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
		}  else if (modelProperty.equals("proxy.target.ep.type")) {
		/** //TODO: 
			if((((ProxyServiceModel)model).getTargetEPType()==TargetEPType.URL) && !(optWsdlbasedProxy||optCustomProxy)){
				throw new FieldValidationException("Specified Target Endpoint");	
			}**/
		} else if (modelProperty.equals("templ.common.ps.epurl")) {
			if(((ProxyServiceModel)model).getTargetEPType()==TargetEPType.URL && !(optWsdlbasedProxy||optCustomProxy)){
				if(value==null || value.toString().equals("")){
					throw new FieldValidationException("Specified Target Endpoint URL");
				} else{
					CommonFieldValidator.isValidUrl(value.toString().trim(), "Endpoint URL");
				}	
			}		
		} else if (modelProperty.equals("templ.common.ps.epkey")) {
			if((((ProxyServiceModel)model).getTargetEPType()==TargetEPType.REGISTRY) && (value==null || value.toString().equals("")) && !(optWsdlbasedProxy||optCustomProxy)){
				throw new FieldValidationException("Specified Target Endpoint key");
			}			
		} else if (modelProperty.equals("templ.secure.ps.secpolicy")) {
						
		} else if (modelProperty.equals("templ.wsdl.ps.wsdlurl")) {
			if(optWsdlbasedProxy){
				if(value==null || value.toString().equals("")){
					throw new FieldValidationException("Specified Target WSDL URL");
				} else{
					CommonFieldValidator.isValidUrl(value.toString().trim(), "WSDL URL");
				}	
			}
		} else if (modelProperty.equals("templ.wsdl.ps.wsdlservice")) {
			if(optWsdlbasedProxy  && (value==null || value.toString().equals(""))){
				throw new FieldValidationException("Specified Target WSDL service");
			}					
		} else if (modelProperty.equals("templ.wsdl.ps.wsdlport")) {
			if(optWsdlbasedProxy  && (value==null || value.toString().equals(""))){
				throw new FieldValidationException("Specified Target WSDL port");
			}					
		} else if (modelProperty.equals("templ.wsdl.ps.publishsame")) {
									
		} else if (modelProperty.equals("templ.logging.ps.reqloglevel")) {
									
		} else if (modelProperty.equals("templ.logging.ps.resloglevel")) {
									
		} else if (modelProperty.equals("templ.transformer.ps.xslt")) {
			if(selectedTemplate.getId().equalsIgnoreCase(PsArtifactConstants.TRANSFORMER_PROXY_TEMPL_ID)){
				if(value==null || StringUtils.isBlank(value.toString())){
					throw new FieldValidationException("Specified XSLT key");
				}
			}	
		} else if (modelProperty.equals("templ.common.ps.eplist")) {
			if((((ProxyServiceModel)model).getTargetEPType()==TargetEPType.PREDEFINED) && (value==null || value.toString().equals(""))){
				throw new FieldValidationException("Specified Target Predefined Endpoint key");
			}							
		} else if (modelProperty.equals("save.file")) {
			IResource resource = (IResource)value;
			if(resource==null || !resource.exists())	
				throw new FieldValidationException("Specified project or path doesn't exist");
		} else if (modelProperty.equals("templ.transformer.ps.transformresponses")) {
			if(selectedTemplate.getId().equalsIgnoreCase(PsArtifactConstants.TRANSFORMER_PROXY_TEMPL_ID)){
				if((Boolean)value && ((ProxyServiceModel)model).getResponseXSLT().equals("")){
					throw new FieldValidationException("Specified Response XSLT key");
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
		if (modelProperty.equals("import.file")) {
			updateFields.add("available.ps");
		} else if (modelProperty.equals("create.esb.prj")) {
			updateFields.add("save.file");
		} else if (modelProperty.equals("ps.type")) {
			updateFields.add("proxy.AdvancedConfig");
		}
		return updateFields;
	}

	
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);

		if (modelProperty.equals("available.ps")) {
			List<OMElement> availableEPList = ((ProxyServiceModel) model).getAvailablePSList();
			visibleField = (availableEPList != null && availableEPList.size() > 0);
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
