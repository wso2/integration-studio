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

package org.wso2.developerstudio.eclipse.artifact.sequence.model;

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
import org.wso2.developerstudio.eclipse.artifact.sequence.Activator;
import org.wso2.developerstudio.eclipse.artifact.sequence.validators.ProjectFilter;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class SequenceModel extends ProjectDataModel {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static final String CONF_REG_ID = "2";
	public static final String GOV_REG_ID = "3";

	private boolean saveAsDynamic = false;
	private String registryPathID = GOV_REG_ID;
	private String dynamicSeqRegistryPath;
	private List<OMElement> availableSeqList;
	private IContainer sequenceSaveLocation;
	private String sequenceName;
	private String onErrorSequence = "";
	private String selectedEP = "";
	private List<OMElement> selectedSeqList;

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals("dynamic.sequence")) {
				modelPropertyValue = isSaveAsDynamic();
			} else if (key.equals("reg.path")) {
				modelPropertyValue = getRegistryPathID();
			} else if (key.equals("save.file")) {
				IContainer container = getSequenceSaveLocation();
				if (container != null && container instanceof IFolder) {
					IFolder sequenceFolder =
					                         container.getProject().getFolder("src").getFolder("main")
					                                  .getFolder("synapse-config").getFolder("sequences");
					modelPropertyValue = sequenceFolder;
				} else {
					modelPropertyValue = container;
				}
			} else if (key.equals("reg.browse")) {
				modelPropertyValue = getDynamicSeqRegistryPath();
			} else if (key.equals("available.sequences")) {
				if (selectedSeqList != null) {
					modelPropertyValue = selectedSeqList.toArray();
				}
			}
		}
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		selectedSeqList = new ArrayList<OMElement>();
		if (key.equals("import.file")) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableSequences = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(), SynapseEntryType.SEQUENCE)) {
						availableSequences =
						                     SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
						                                                            SynapseEntryType.SEQUENCE);
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
		} else if (key.equals("dynamic.sequence")) {
			setSaveAsDynamic((Boolean) data);
			ProjectFilter.setShowGeneralProjects((Boolean) data);
			setSequenceSaveLocation("");
		} else if (key.equals("reg.path")) {
			setDynamicSeqRegistryPath("");
			setRegistryPathID(data.toString());
		} else if (key.equals("save.file")) {
			IContainer container = (IContainer) data;
			if (container != null && container instanceof IFolder) {
				IFolder sequenceFolder =
				                         container.getProject().getFolder("src").getFolder("main")
				                                  .getFolder("synapse-config").getFolder("sequences");
				setSequenceSaveLocation(sequenceFolder);
			} else {
				setSequenceSaveLocation(container);
			}
		} else if (key.equals("create.esb.prj")) {
			if (isSaveAsDynamic()) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				IProject generalProject = GeneralProjectUtils.createGeneralProject(shell, getLocation());
				if (generalProject != null) {
					setSequenceSaveLocation(generalProject);
				}

			} else {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				IProject esbProject = ESBProjectUtils.createESBProject(shell, getLocation());
				if (esbProject != null) {
					setSequenceSaveLocation(esbProject);
				}
			}
		} else if (key.equals("sequence.name")) {
			setSequenceName(data.toString());
		} else if (key.equals("on.error.sequence")) {
			String seqName = ProjectUtils.fileNameWithoutExtension((new File(data.toString())).getName());
			setOnErrorSequence(seqName);
		} else if (key.equals("available.eps")) {
			String epName = "";
			File file = (new File(data.toString()));
			if (file.exists()) {
				if (file.getParent().contains("synapse-config")) {
					epName = ProjectUtils.fileNameWithoutExtension(file.getName());
				}
			} else {
				epName = data.toString();
			}
			setSelectedEP(epName);
		} else if (key.equals("available.sequences")) {
			Object[] selectedSequencess = (Object[]) data;
			for (Object object : selectedSequencess) {
				if (object instanceof OMElement) {
					if (!selectedSeqList.contains((OMElement) object)) {
						selectedSeqList.add((OMElement) object);
					}
				}
			}
		} else if (key.equals("reg.browse")) {
			if (null != data) {
				setDynamicSeqRegistryPath(data.toString());
			}
		}

		return returnResult;
	}

	public void setSaveAsDynamic(boolean saveAsDynamic) {
		this.saveAsDynamic = saveAsDynamic;
	}

	public boolean isSaveAsDynamic() {
		return saveAsDynamic;
	}

	public void setSequenceSaveLocation(String sequenceSaveLocation) {
		this.setSequenceSaveLocation(ResourcesPlugin.getWorkspace().getRoot()
		                                            .getContainerForLocation(new Path(sequenceSaveLocation)));
	}

	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getSequenceSaveLocation() == null && absolutionPath != null) {
			IContainer newEndpointSaveLocation =
			                                     getContainer(absolutionPath,
			                                                  "org.wso2.developerstudio.eclipse.esb.project.nature");
			setSequenceSaveLocation(newEndpointSaveLocation);
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
					if (projectLocationLength > length && projectLocationLength <= absolutionPath.toString().length()) {
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
		IContainer newSequenceSaveLocation = null;
		if (currentSelection != null) {
			String path =
			              absolutionPath.toString().substring(currentSelection.getLocation().toFile().toString()
			                                                                  .length());

			if (path.equals("")) {
				newSequenceSaveLocation = currentSelection;
			} else {
				newSequenceSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newSequenceSaveLocation;
	}

	public void setAvailableSeqList(List<OMElement> availableSeqList) {
		this.availableSeqList = availableSeqList;
	}

	public List<OMElement> getAvailableSeqList() {
		return availableSeqList;
	}

	public void setSequenceSaveLocation(IContainer sequenceSaveLocation) {
		this.sequenceSaveLocation = sequenceSaveLocation;
	}

	public IContainer getSequenceSaveLocation() {
		return sequenceSaveLocation;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	public String getSequenceName() {
		return sequenceName;
	}

	public void setRegistryPathID(String RegistryPathID) {
		this.registryPathID = RegistryPathID;
	}

	public String getRegistryPathID() {
		return registryPathID;
	}

	public void setOnErrorSequence(String onErrorSequence) {
		if (!onErrorSequence.equals("")) {
			onErrorSequence = "onError=\"" + onErrorSequence + "\"";
		}
		this.onErrorSequence = onErrorSequence;
	}

	public String getOnErrorSequence() {
		return onErrorSequence;
	}

	public void setSelectedEP(String selectedEP) {
		if (!selectedEP.equals("")) {
			selectedEP = "><send><endpoint key=\"" + selectedEP + "\" /></send></sequence>";
		}
		this.selectedEP = selectedEP;
	}

	public String getSelectedEP() {
		return selectedEP;
	}

	public void setSelectedSeqList(List<OMElement> selectedSeqList) {
		this.selectedSeqList = selectedSeqList;
	}

	public List<OMElement> getSelectedSeqList() {
		return selectedSeqList;
	}

	public void setDynamicSeqRegistryPath(String dynamicSeqRegistryPath) {
		this.dynamicSeqRegistryPath = dynamicSeqRegistryPath;
	}

	public String getDynamicSeqRegistryPath() {
		return dynamicSeqRegistryPath;
	}

}
