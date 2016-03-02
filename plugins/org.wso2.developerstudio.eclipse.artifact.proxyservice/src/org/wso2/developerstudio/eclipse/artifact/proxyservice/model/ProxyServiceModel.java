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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.model;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.Activator;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.PsArtifactConstants;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

public class ProxyServiceModel extends ProjectDataModel {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private ArtifactTemplate selectedTemplate;
	private List<OMElement> availablePSList;
	private IContainer proxyServiceSaveLocation;
	private String proxyServiceName="";
	private String endPointUrl="";
	private String endPointKey="";
	private String secPolicy="";
	private String wsdlUri="";
	private String wsdlService="";
	private String wsdlPort="";
	private boolean publishSameService;
	private String requestLogLevel="none";
	private String responseLogLevel="none";
	private String requestXSLT="";
	private String responseXSLT="";
	private boolean transformResponses;
	private boolean predefinedEP;
	private String predefinedEndPoint;
	List<OMElement> selectedProxyList=new ArrayList<OMElement>();
	private TargetEPType targetEPType=TargetEPType.URL;
	
	
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals(PsArtifactConstants.WIZARD_OPTION_PS_TYPE)) {
				modelPropertyValue = getSelectedTemplate();
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_SAVE_LOCATION)) {
				IContainer container= getProxyServiceSaveLocation();
				if(container != null && container instanceof IFolder){
					IFolder proxyFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("proxy-services");
					modelPropertyValue = proxyFolder;
				}else{
					modelPropertyValue = container;
				}
			} else if (key.equals("proxy.target.ep.type")) {
				modelPropertyValue = getTargetEPType();
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPURL)) {
				modelPropertyValue = getEndPointUrl();
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPKEY)) {
				modelPropertyValue = getEndPointkey();
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_SECURE_PS_SECPOLICY)) {
				modelPropertyValue = getSecPolicy();
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLURL)) {
				modelPropertyValue = getWsdlUri();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLSERVICE)) {
				modelPropertyValue = getWsdlService();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLPORT)) {
				modelPropertyValue = getWsdlPort();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_PUBLISHSAME)) {
				modelPropertyValue = isPublishSameService();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_LOGGING_PS_REQLOGLEVEL)) {
				modelPropertyValue = getRequestLogLevel();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_LOGGING_PS_RESLOGLEVEL)) {
				modelPropertyValue = getResponseLogLevel();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_XSLT)) {
				modelPropertyValue = getRequestXSLT();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_TRANSFORMRESPONSES)) {
				modelPropertyValue = isTransformResponses();			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_RESXSLT)){
				modelPropertyValue = getResponseXSLT();
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_PREDEFINED)) {
				modelPropertyValue = predefinedEP;			
			} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPLIST)) {
				modelPropertyValue = getPredefinedEndPoint();			
			} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_AVAILABLE_PS)){
				if(selectedProxyList!=null){
				modelPropertyValue = selectedProxyList.toArray();
				}
			}

		}
		return modelPropertyValue;
	}

	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		if (key.equals(PsArtifactConstants.WIZARD_OPTION_IMPORT_FILE)) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableProxies = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(),
					                                        SynapseEntryType.PROXY_SERVICE)) {
						availableProxies =
						        SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
						                                               SynapseEntryType.PROXY_SERVICE);
						setAvailablePSList(availableProxies);
					} else {
						setAvailablePSList(new ArrayList<OMElement>());
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
		} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_PS_TYPE)) {
			ArtifactTemplate template = (ArtifactTemplate) data;
			setSelectedTemplate(template);
		} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_SAVE_LOCATION)) {
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder proxyFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("proxy-services");
				setProxyServiceSaveLocation(proxyFolder);
			}else{
				setProxyServiceSaveLocation(container);
			}
		} else if (key.equals(PsArtifactConstants.WIZARD_OPTION_CREATE_ESB_PROJECT)) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject esbProject = ESBProjectUtils.createESBProject(shell,getLocation());
			if(esbProject!=null){
				setProxyServiceSaveLocation(esbProject);
			}
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_PS_NAME)){
			setProxyServiceName(data.toString());
		} else if (key.equals("proxy.target.ep.type")) {
			setTargetEPType((TargetEPType)data);
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPURL)){
			setEndPointUrl(data.toString());
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPKEY)){
			setEndPointKey(data.toString());
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_SECURE_PS_SECPOLICY)){
			setSecPolicy(data.toString());
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLURL)){
			setWsdlUri(data.toString());		
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLSERVICE)){
			setWsdlService(data.toString())	;	
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLPORT)){
			setWsdlPort(data.toString());
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_PUBLISHSAME)){
			setPublishSameService((Boolean)data);	
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_LOGGING_PS_REQLOGLEVEL)){
			setRequestLogLevel(data.toString());
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_LOGGING_PS_RESLOGLEVEL)){
			setResponseLogLevel(data.toString());		
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_XSLT)){
			setRequestXSLT(data.toString())	;
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_TRANSFORMRESPONSES)){
			setTransformResponses((Boolean)data);		
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_RESXSLT)) {
			setResponseXSLT(data.toString());
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPLIST)){
			setPredefinedEndPoint(data.toString());		
		} else if(key.equals(PsArtifactConstants.WIZARD_OPTION_AVAILABLE_PS)){
			Object[] selectedEPs = (Object[])data;
			if(selectedProxyList!=null ) selectedProxyList.clear();
			for (Object object : selectedEPs) {
				if(object instanceof OMElement){
					selectedProxyList.add((OMElement)object);
				}
			}
			setSelectedProxyList(selectedProxyList);
		}
		return returnResult;
	}
	
	public void setEndPointUrl(String endPointUrl){
		this.endPointUrl = endPointUrl;
	}
	
	public String getEndPointUrl(){
		return this.endPointUrl;
	}

	public void setEndPointKey(String endPointKey){
		this.endPointKey = endPointKey;
	}
	
	public String getEndPointkey(){
		return endPointKey;
	}
	
	public void setSecPolicy(String secPolicy){
		this.secPolicy=secPolicy;
	}

	public String getSecPolicy(){
		return secPolicy;
	}

	public void setWsdlUri(String wsdlUri){
		this.wsdlUri=wsdlUri;
	}

	public String getWsdlUri(){
		return wsdlUri;
	}

	public void setWsdlService(String wsdlservice){
		this.wsdlService=wsdlservice;
	}

	public String getWsdlService(){
		return wsdlService;
	}

	public void setWsdlPort(String wsdlPort){
		this.wsdlPort=wsdlPort;
	}

	public String getWsdlPort(){
		return wsdlPort;
	}

	public void setPublishSameService(boolean publishSameService){
		this.publishSameService=publishSameService;
	}

	public boolean isPublishSameService(){
		return publishSameService;
	}

	public void setRequestLogLevel(String requestLogLevel){
		this.requestLogLevel=requestLogLevel;
	}

	public String getRequestLogLevel(){
		return requestLogLevel.toLowerCase();
	}

	public void setResponseLogLevel(String responseLogLevel){
		this.responseLogLevel=responseLogLevel;
	}

	public String getResponseLogLevel(){
		return responseLogLevel.toLowerCase();
	}

	public void setRequestXSLT(String requestXSLT){
		this.requestXSLT=requestXSLT;
	}
	
	public String getPredefinedEndPoint(){
		return predefinedEndPoint;
	}

	public void setPredefinedEndPoint(String predefinedEndPoint){
		this.predefinedEndPoint=predefinedEndPoint;
	}

	public String getRequestXSLT(){
		return requestXSLT;
	}

	public void setTransformResponses(boolean transformResponses){
		this.transformResponses=transformResponses;
	}

	public boolean isTransformResponses(){
		return transformResponses;
	}
	
	public void setSelectedTemplate(ArtifactTemplate selectedTemplate) {
		this.selectedTemplate = selectedTemplate;
	}

	public ArtifactTemplate getSelectedTemplate() {
		return selectedTemplate;
	}

	public void setAvailablePSList(List<OMElement> availablePSList) {
		this.availablePSList = availablePSList;
	}

	public List<OMElement> getAvailablePSList() {
		return availablePSList;
	}

	public void setProxyServiceSaveLocation(IContainer proxyServiceSaveLocation) {
		this.proxyServiceSaveLocation = proxyServiceSaveLocation;
	}

	public void setProxyServiceSaveLocation(String proxyServiceSaveLocation) {
		this.proxyServiceSaveLocation =
		        ResourcesPlugin.getWorkspace().getRoot()
		                .getContainerForLocation(new Path(proxyServiceSaveLocation));
	}

	public IContainer getProxyServiceSaveLocation() {
		return proxyServiceSaveLocation;
	}

	
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getProxyServiceSaveLocation() == null && absolutionPath != null) {
			IContainer newEndpointSaveLocation =
			        getContainer(absolutionPath, PsArtifactConstants.ESB_PROJECT_NATURE);
			setProxyServiceSaveLocation(newEndpointSaveLocation);
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
				e.printStackTrace();
			}
		}
		IContainer newProxyServiceSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newProxyServiceSaveLocation = currentSelection;
			} else {
				newProxyServiceSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newProxyServiceSaveLocation;
	}

	public void setProxyServiceName(String psName) {
		this.proxyServiceName = psName;
	}

	public String getProxyServiceName() {
		return proxyServiceName;
	}
	
	public void setSelectedProxyList(List<OMElement> selectedProxyList) {
		this.selectedProxyList = selectedProxyList;
	}

	public List<OMElement> getSelectedProxyList() {
		return selectedProxyList;
	}
	
	public void setTargetEPType(TargetEPType targetEPType) {
		this.targetEPType = targetEPType;
	}


	public TargetEPType getTargetEPType() {
		return targetEPType;
	}

	public String getResponseXSLT() {
		return responseXSLT;
	}

	public void setResponseXSLT(String responseXSLT) {
		this.responseXSLT = responseXSLT;
	}

	public enum TargetEPType {
		URL,PREDEFINED,REGISTRY
	}
}
