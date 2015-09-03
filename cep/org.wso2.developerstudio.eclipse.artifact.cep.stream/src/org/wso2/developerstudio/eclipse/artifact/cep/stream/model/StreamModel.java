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

package org.wso2.developerstudio.eclipse.artifact.cep.stream.model;

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
//import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.cep.stream.Activator;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPEntryType;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPFileUtils;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class StreamModel extends ProjectDataModel {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public static final String CONF_REG_ID = "2";
	public static final String GOV_REG_ID = "3";

	private String registryPathID = GOV_REG_ID;
	
	private List<OMElement> availableReceiveList;
	private IContainer streamSaveLocation;
	private String streamName;
	private String selectedR = "";
	private List<OMElement> selectedStreamList;

	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals("save.file")) {
				IContainer container= getStreamSaveLocation();
				if(container != null && container instanceof IFolder){
					IFolder streamFolder = container.getProject().getFolder("src").getFolder("main").getFolder("stream");
					modelPropertyValue = streamFolder;
				}else{
					modelPropertyValue = container;
				}	
			}else if(key.equals("available.eventstream")){
				if(selectedStreamList!=null){
					modelPropertyValue = selectedStreamList.toArray();
					}
			}
		}
		return modelPropertyValue;
	
	}

	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		selectedStreamList = new ArrayList<OMElement>();	
		if (key.equals("import.file")) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableStream = new ArrayList<OMElement>();
					if (CEPFileUtils.isCepConfGiven(getImportFile(),
					                                        CEPEntryType.RECIEVER)) {
						availableStream =
						        CEPFileUtils.cepFileProcessing(getImportFile().getPath(),
						                                               CEPEntryType.RECIEVER);
						setAvailableStreamList(availableStream);
					} else {
						setAvailableStreamList(new ArrayList<OMElement>());
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
		} else if (key.equals("save.file")) {
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder streamFolder = container.getProject().getFolder("src").getFolder("main").getFolder("stream");
				setStreamSaveLocation(streamFolder);
			}else{
				setStreamSaveLocation(container);
			}
		} else if (key.equals("create.cep.prj")) {
			
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				IProject cepProject = CEPProjectUtils.createCEPProject(shell,getLocation());
				if(cepProject!=null){
					setStreamSaveLocation(cepProject);
				}
				
		}else if(key.equals("project.name")){
			setStreamName(data.toString());
					
		}
		return returnResult;
	}
	
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getStreamSaveLocation() == null && absolutionPath != null) {
			IContainer newStreamSaveLocation =
			        getContainer(absolutionPath, "org.wso2.developerstudio.eclipse.artifact.cep.project.nature");
			setStreamSaveLocation(newStreamSaveLocation);
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
		IContainer newStreamSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newStreamSaveLocation = currentSelection;
			} else {
				newStreamSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newStreamSaveLocation;
	}

	public void setAvailableStreamList(List<OMElement> availableSeqList) {
		this.availableReceiveList = availableSeqList;
	}

	public List<OMElement> getAvailableEventstreamList() {
		return availableReceiveList;
	}

	public void setStreamSaveLocation(IContainer sequenceSaveLocation) {
		this.streamSaveLocation = sequenceSaveLocation;
	}

	public IContainer getStreamSaveLocation() {
		return streamSaveLocation;
	}

	public void setStreamName(String eventstreamName) {
		this.streamName = eventstreamName;
	}

	public String getStreamName() {
		return streamName;
	}
	
	public void setRegistryPathID(String RegistryPathID) {
		this.registryPathID = RegistryPathID;
	}

	public String getRegistryPathID() {
		return registryPathID;
	}
	
	public void setSelectedES(String selectedES) {
		if(!selectedES.equals("")){
			selectedES = "><send><endpoint key=\"" +  selectedES + "\" /></send></sequence>";
		}
		this.selectedR = selectedES;
	}

	public String getSelectedR() {
		return selectedR;
	}

	public List<OMElement> getSelectedStreamList() {
		return selectedStreamList;
	}

}
