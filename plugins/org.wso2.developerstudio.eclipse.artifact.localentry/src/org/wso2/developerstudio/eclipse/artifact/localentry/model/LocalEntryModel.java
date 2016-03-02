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

package org.wso2.developerstudio.eclipse.artifact.localentry.model;

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
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.localentry.utils.LocalEntryArtifactConstants;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class LocalEntryModel extends ProjectDataModel {
	private String localENtryName;
	private String selectedLocalEntryType;
	private String inLineTextValue;
	private String inLineXMLValue;
	private String sourceURL;
	private List<OMElement> availableLEList;
	private List<OMElement> selectedLEList=new ArrayList<OMElement>();
	private IContainer localEntrySaveLocation;
	
	
	public String getLocalENtryName() {
		return localENtryName;
	}

	public void setLocalENtryName(String localENtryName) {
		this.localENtryName = localENtryName;
	}

	public String getSelectedLocalEntryType() {
		return selectedLocalEntryType;
	}

	public void setSelectedLocalEntryType(String localEntryType) {
		this.selectedLocalEntryType = localEntryType;
	}

	public String getInLineTextValue() {
		return inLineTextValue;
	}

	public void setInLineTextValue(String inLineTextValue) {
		this.inLineTextValue = inLineTextValue;
	}

	public String getInLineXMLValue() {
		return inLineXMLValue;
	}

	public void setInLineXMLValue(String inLineXMLValue) {
		this.inLineXMLValue = inLineXMLValue;
	}

	public String getSourceURL() {
		return sourceURL;
	}

	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_LE_TYPE)){
				modelPropertyValue = getSelectedLocalEntryType();
			}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_SAVE_LOCATION)){
				IContainer container= getLocalEntrySaveLocation();
				if(container != null && container instanceof IFolder){
					IFolder localEntryFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("local-entries");
					modelPropertyValue = localEntryFolder;
				}else{
					modelPropertyValue = container;
				}
			}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_IMPORT_SOURC_URL_LE_URL)){
				modelPropertyValue = getSourceURL();
			}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_IN_LINE_TEXT_LE_VALUE)){
				modelPropertyValue = getInLineTextValue();
			}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_IN_LINE_XML_LE_VALUE)){
				modelPropertyValue = getInLineXMLValue();
			}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_LE_NAME)){
				modelPropertyValue = getLocalENtryName();
			}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_AVAILABLE_LES)){
				modelPropertyValue = selectedLEList.toArray();
			}
		}
		return modelPropertyValue;
	}
	
	public boolean setModelPropertyValue(String key, Object data)
			throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		if (key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_IMPORT_FILE_PATH)) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement>  availableLEs = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(),
					                                        SynapseEntryType.LOCAL_ENTRY)) {
						availableLEs =
						        SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
						                                               SynapseEntryType.LOCAL_ENTRY);
						setAvailableLEList(availableLEs);
						getSelectedLEList().clear();
						getSelectedLEList().addAll(availableLEs);
					} else {
						setAvailableLEList(new ArrayList<OMElement>());
					}
					returnResult = false;
				} catch (OMException e) {
					e.printStackTrace();
				} catch (XMLStreamException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_LE_TYPE)){
			if(data.toString().equals(LocalEntryArtifactConstants.TYPE_IN_LINE_TEXT_LE)){
				setSelectedLocalEntryType(data.toString());
			}else if(data.toString().equals(LocalEntryArtifactConstants.TYPE_IN_LINE_XML_LE)){
				setSelectedLocalEntryType(data.toString());
			}else{
				setSelectedLocalEntryType(data.toString());
				//make it a file URL
			}
		} else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_SAVE_LOCATION)){
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder localEntryFolder = container.getProject().getFolder("src").getFolder("main").getFolder("synapse-config").getFolder("local-entries");
				setLocalEntrySaveLocation(localEntryFolder);
			}else{
				setLocalEntrySaveLocation(container);
			}
		}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_LE_NAME)){
			setLocalENtryName(data.toString());
		}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_AVAILABLE_LES)){
			Object[] selectedLEs = (Object[])data;
			selectedLEList.clear();
			for (Object object : selectedLEs) {
				if(object instanceof OMElement){
					selectedLEList.add((OMElement)object);
				}
			}
			setSelectedLEList(selectedLEList);
		}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_IMPORT_SOURC_URL_LE_URL)){
			setSourceURL(createFileURL(data.toString()));
		}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_IN_LINE_TEXT_LE_VALUE)){
			setInLineTextValue(data.toString());
		}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_IN_LINE_XML_LE_VALUE)){
			setInLineXMLValue(data.toString());
		}else if(key.equals(LocalEntryArtifactConstants.WIZARD_OPTION_CREATE_ESB_PROJECT)){
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject esbProject = ESBProjectUtils.createESBProject(shell,getLocation());
			if(esbProject!=null){
				setLocalEntrySaveLocation(esbProject);
			}	
		}
		return returnResult;
	}
	
	private String createFileURL(String fullFilePath){
		//check how it happens in windows
		//linux - file:/home/chathuri/Desktop/input.txt
		//windows - file:\C:\WSO2\tooling\endpoint21.xml
		String fileURL = "";
		if(fullFilePath != null && !fullFilePath.equals("")){
			if(fullFilePath.startsWith("/")){
				fileURL = "file:" + fullFilePath;
			}else if(!fullFilePath.startsWith("file")){
				fileURL = "file:/" + fullFilePath;
			}else{
				return fullFilePath;
			}
		}
		return fileURL;
	}

	public void setAvailableLEList(List<OMElement> availableLEList) {
		this.availableLEList = availableLEList;
	}

	public List<OMElement> getAvailableLEList() {
		return availableLEList;
	}

	public void setSelectedLEList(List<OMElement> selectedLEList) {
		this.selectedLEList = selectedLEList;
	}

	public List<OMElement> getSelectedLEList() {
		return selectedLEList;
	}

	public void setLocalEntrySaveLocation(IContainer localEntrySaveLocation) {
		this.localEntrySaveLocation = localEntrySaveLocation;
	}
	
	public void setLocalEntrySaveLocation(String localEntrySaveLocation) {
		this.localEntrySaveLocation =
	        ResourcesPlugin.getWorkspace().getRoot()
	                .getContainerForLocation(new Path(localEntrySaveLocation));
	}

	public IContainer getLocalEntrySaveLocation() {
		return localEntrySaveLocation;
	}
	
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getLocalEntrySaveLocation() == null && absolutionPath != null) {
			IContainer newEndpointSaveLocation =
			        getContainer(absolutionPath, LocalEntryArtifactConstants.ESB_PROJECT_NATURE);
			setLocalEntrySaveLocation(newEndpointSaveLocation);
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
		IContainer newLocalEntrySaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newLocalEntrySaveLocation = currentSelection;
			} else {
				newLocalEntrySaveLocation = currentSelection.getFolder(path);
			}
		}
		return newLocalEntrySaveLocation;
	}
}
