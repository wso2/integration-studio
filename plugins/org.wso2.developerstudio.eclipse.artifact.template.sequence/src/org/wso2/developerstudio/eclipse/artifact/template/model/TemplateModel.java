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

package org.wso2.developerstudio.eclipse.artifact.template.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.template.Activator;
import org.wso2.developerstudio.eclipse.artifact.template.validators.HttpMethodList.HttpMethodType;
import org.wso2.developerstudio.eclipse.artifact.template.validators.TemplateList;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;

public class TemplateModel extends ProjectDataModel {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private ArtifactTemplate selectedTemplate;
	private String templateName;
	private String selectedLocalEntryType;
    private boolean isImportArtifact=false;
	private IContainer templateSaveLocation;
	private List<OMElement> selectedTempSequenceList=new ArrayList<OMElement>();
	private List<OMElement> availableSeqList;
	private String addressEPURI;
	private String wsdlEPURI;
	private String wsdlEPService;
	private String wsdlEPPort;
	private String httpUriTemplate;
	private HttpMethodType httpMethod;

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals("save.file")) {
				IContainer container= getTemplateSaveLocation();
				if(container != null && container instanceof IFolder){
					IFolder templatesFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("templates");
					modelPropertyValue = templatesFolder;
				}else{
					modelPropertyValue = container;
				}
			}  
			if(key.equals("temp.type")){
				modelPropertyValue = getSelectedTemplate();
			}
		}
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		if (key.equals("import.file")) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableSequences = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(),
					                                        SynapseEntryType.TEMPLATE)) {
						availableSequences =
						        SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
						                                               SynapseEntryType.TEMPLATE);
						setAvailableSeqList(availableSequences);
					} else {
						setAvailableSeqList(new ArrayList<OMElement>());
					}
					returnResult = false;
				} catch (OMException e) {
					log.error("Error reading object model", e);
				} catch (XMLStreamException e) {
					log.error("XML stream error", e);
				} catch (IOException e) {
					log.error("I/O error has occurred", e);
				} catch (Exception e) {
					log.error("An unexpected error has occurred", e);
				}
			}
		} else if (key.equals("temp.type")) {
			ArtifactTemplate template = (ArtifactTemplate) data;
			setSelectedTemplate(template);
		}else if (key.equals("save.file")) {
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder templateFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("templates");
				setTemplateSaveLocation(templateFolder);
			}else{
				setTemplateSaveLocation(container);
			}
		} else if (key.equals("create.esb.prj")) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				IProject esbProject = ESBProjectUtils.createESBProject(shell,getLocation());
				if(esbProject!=null){
					setTemplateSaveLocation(esbProject);
				}
		}else if(key.equals("temp.name")){
			setTemplateName(data.toString());
		}else if(key.equals("templ.address.ep.uri")){
			setAddressEPURI(data.toString());
		}else if(key.equals("templ.wsdl.ep.uri")){
			setWsdlEPURI(data.toString());
		}else if(key.equals("templ.wsdl.ep.service")){
			setWsdlEPService(data.toString());
		}else if(key.equals("templ.wsdl.ep.port")){
			setWsdlEPPort(data.toString());
		}else if (key.equals("templ.http.ep.uritemplate")) {
			setHttpUriTemplate(data.toString());
		}else if (key.equals("templ.http.ep.method")) {
			setHttpMethod((HttpMethodType)data);
		}
		return returnResult;
	}

	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getTemplateSaveLocation() == null && absolutionPath != null) {
			IContainer newEndpointSaveLocation =
			        getContainer(absolutionPath,"org.wso2.developerstudio.eclipse.esb.project.nature");
			setTemplateSaveLocation(newEndpointSaveLocation);
		}
	}
	
	public static IContainer getContainer(File absolutionPath, String projectNature) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		int length = 0;
		IProject currentSelection = null;
		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.hasNature(projectNature)) {
					File projectLocation = project.getLocation().toFile();
					int projectLocationLength = projectLocation.toString().length();
					if (projectLocationLength > length &&
					    projectLocationLength <= absolutionPath.toString().length()) {
						if (absolutionPath.toString().startsWith(projectLocation.toString())) {
							length = projectLocationLength;
							currentSelection = project;
						}
					}
				}
			} catch (CoreException e) {
				log.error("An unexpected error has occurred", e);
			}
		}
		IContainer newTemplateSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newTemplateSaveLocation = currentSelection;
			} else {
				newTemplateSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newTemplateSaveLocation;
	}
	
	public ArtifactTemplate getSelectedTemplate() {
		if(selectedTemplate == null){
			ArtifactTemplate[] artifactTemplates =TemplateList.getArtifactTemplates();
			if (artifactTemplates.length > 0) {
				selectedTemplate = artifactTemplates[0];
			} else {
				return null;
			}
		}
		return selectedTemplate;
	}
	
	public void setNewArtifact(boolean isNewArtifact) {
		this.isImportArtifact = isNewArtifact;
	}

	public boolean isImportArtifact() {
		return isImportArtifact;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateSaveLocation(IContainer templateSaveLocation) {
		this.templateSaveLocation = templateSaveLocation;
	}

	public IContainer getTemplateSaveLocation() {
		return templateSaveLocation;
	}

	public void setSelectedTempSequenceList(List<OMElement> selectedTempSequenceList) {
		this.selectedTempSequenceList = selectedTempSequenceList;
	}

	public List<OMElement> getSelectedTempSequenceList() {
		return selectedTempSequenceList;
	}

	public void setAvailableSeqList(List<OMElement> availableSeqList) {
		this.availableSeqList = availableSeqList;
	}

	public List<OMElement> getAvailableSeqList() {
		return availableSeqList;
	}

	public void setSelectedTemplate(ArtifactTemplate selectedTemplate) {
		this.selectedTemplate = selectedTemplate;
	}

	public void setAddressEPURI(String addressEPURI) {
		this.addressEPURI = addressEPURI;
	}

	public String getAddressEPURI() {
		return addressEPURI;
	}

	public void setWsdlEPURI(String wsdlEPURI) {
		this.wsdlEPURI = wsdlEPURI;
	}

	public String getWsdlEPURI() {
		return wsdlEPURI;
	}

	public void setWsdlEPService(String wsdlEPService) {
		this.wsdlEPService = wsdlEPService;
	}

	public String getWsdlEPService() {
		return wsdlEPService;
	}

	public void setWsdlEPPort(String wsdlEPPort) {
		this.wsdlEPPort = wsdlEPPort;
	}

	public String getWsdlEPPort() {
		return wsdlEPPort;
	}

	public String getHttpUriTemplate() {
		return httpUriTemplate;
	}

	public void setHttpUriTemplate(String httpUriTemplate) {
		this.httpUriTemplate = httpUriTemplate;
	}

	public HttpMethodType getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HttpMethodType httpMethod) {
		this.httpMethod = httpMethod;
	}
	
	public String getSelectedLocalEntryType() {
		return selectedLocalEntryType;
	}

	public void setSelectedLocalEntryType(String localEntryType) {
		this.selectedLocalEntryType = localEntryType;
	}
}
