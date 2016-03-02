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

package org.wso2.developerstudio.eclipse.artifact.inboundendpoint.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.Activator;
import org.wso2.developerstudio.eclipse.artifact.inboundendpoint.utils.InboundEndpointArtifactProperties;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseEntryType;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseFileUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class InboundEndpointModel extends ProjectDataModel {

	private String selectedInboundEndpointType;
	private String classImpl;
	private String fileName;
	private String injectingSequence;
	private String name;
	private String onErrorSequence;
	private String protocol;
	private String suspend;
	private String interval;
	private String sequential;
	private String coordination;
	private String sourceURL;
	private String vfsContentType;
	private String vfsFileNamePattern;
	private String vfsFileProcessInterval;
	private String vfsFileProcessCount;
	private String vfsLocking;
	private String vfsMaxRetryCount;
	private String vfsReconnectTimeout;
	private String vfsActionAfterProcess;
	private String vfsMoveAfterProcess;
	private String vfsActionAfterErrors;
	private String vfsMoveAfterErrors;
	private String vfsActionAfterFailure;
	private String vfsMoveAfterFailure;
	private String vfsAutoLockRelease;
	private String vfsAutoLockReleaseInterval;
	private String vfsLockReleaseSameNode;
	private String vfsDistributedLock;
	private String vfsDistributedTimeout;

	private List<OMElement> availableLEList;
	private IContainer inboundEndpointSaveLocation;
	private List<OMElement> selectedLEList = new ArrayList<OMElement>();

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals(InboundEndpointArtifactProperties.wizardOptionIEType)) {
				modelPropertyValue = getSelectedInboundEndpointType();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionSaveLocation)) {
				IContainer container = getInboundEndpointSaveLocation();
				if (container instanceof IFolder) {
					IFolder inboundEndpointFolder = container.getProject().getFolder("src").getFolder("main")
							.getFolder("synapse-config").getFolder("inbound-endpoints");
					modelPropertyValue = inboundEndpointFolder;
				} else {
					modelPropertyValue = container;
				}
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionImportSourceUrlIEUrl)) {
				modelPropertyValue = getSourceURL();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionSequence)) {
				modelPropertyValue = getInjectingSequence();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionClass)) {
				modelPropertyValue = getClassImpl();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionIEName)) {
				modelPropertyValue = getName();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionErrorSequence)) {
				modelPropertyValue = getOnErrorSequence();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionProtocol)) {
				modelPropertyValue = getProtocol();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionSequential)) {
				modelPropertyValue = getSequential();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionCoordination)) {
				modelPropertyValue = getCoordination();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSContentType)) {
				modelPropertyValue = getVfsContentType();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileNamePattern)) {
				modelPropertyValue = getVfsFileNamePattern();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileProcessInterval)) {
				modelPropertyValue = getVfsFileProcessInterval();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileProcessCount)) {
				modelPropertyValue = getVfsFileProcessCount();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSLocking)) {
				modelPropertyValue = getVfsLocking();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMaxRetryCount)) {
				modelPropertyValue = getVfsMaxRetryCount();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSReconnectTimeout)) {
				modelPropertyValue = getVfsReconnectTimeout();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSActionAfterProcess)) {
				modelPropertyValue = getVfsActionAfterProcess();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMoveAfterProcess)) {
				modelPropertyValue = getVfsMoveAfterProcess();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSActionAfterErrors)) {
				modelPropertyValue = getVfsActionAfterErrors();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMoveAfterErrors)) {
				modelPropertyValue = getVfsMoveAfterErrors();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSActionAfterFailure)) {
				modelPropertyValue = getVfsActionAfterFailure();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMoveAfterFailure)) {
				modelPropertyValue = getVfsMoveAfterFailure();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSAutoLockRelease)) {
				modelPropertyValue = getVfsAutoLockRelease();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSAutoLockReleaseInterval)) {
				modelPropertyValue = getVfsAutoLockReleaseInterval();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSLockReleaseSameNode)) {
				modelPropertyValue = getVfsLockReleaseSameNode();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSDistributedLock)) {
				modelPropertyValue = getVfsDistributedLock();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSDistributedTimeout)) {
				modelPropertyValue = getVfsDistributedTimeout();
			} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionAvailableIEs)) {
				modelPropertyValue = selectedLEList.toArray();
			}
		}
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		if (key.equals(InboundEndpointArtifactProperties.wizardOptionImportFilePath)) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				try {
					List<OMElement> availableLEs = new ArrayList<OMElement>();
					if (SynapseFileUtils.isSynapseConfGiven(getImportFile(), SynapseEntryType.INBOUND_ENDPOINT)) {
						availableLEs = SynapseFileUtils.synapseFileProcessing(getImportFile().getPath(),
								SynapseEntryType.INBOUND_ENDPOINT);
						setAvailableLEList(availableLEs);
						getSelectedLEList().clear();
						getSelectedLEList().addAll(availableLEs);
					} else {
						setAvailableLEList(new ArrayList<OMElement>());
					}
					returnResult = false;
				} catch (Exception e) {
					log.error(e);
					throw new ObserverFailedException(e);
				}
			}
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionIEType)) {
			setSelectedInboundEndpointType(data.toString());
			setProtocol(data.toString().toLowerCase());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionSaveLocation)) {
			IContainer container = (IContainer) data;
			if (container instanceof IFolder) {
				IFolder localEntryFolder = container.getProject().getFolder("src").getFolder("main")
						.getFolder("synapse-config").getFolder("inbound-endpoints");
				setInboundEndpointSaveLocation(localEntryFolder);
			} else {
				setInboundEndpointSaveLocation(container);
			}
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionIEName)) {
			setName(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionAvailableIEs)) {
			Object[] selectedLEs = (Object[]) data;
			selectedLEList.clear();
			for (Object object : selectedLEs) {
				if (object instanceof OMElement) {
					selectedLEList.add((OMElement) object);
				}
			}
			setSelectedLEList(selectedLEList);
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionImportSourceUrlIEUrl)) {
			setSourceURL(createFileURL(data.toString()));
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionSequence)) {
			setInjectingSequence(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionClass)) {
			setClassImpl(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionErrorSequence)) {
			setOnErrorSequence(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionInterval)) {
			setInterval(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionSequential)) {
			setSequential(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionCoordination)) {
			setCoordination(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileURI)) {
			setFileName(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSContentType)) {
			setVfsContentType(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileNamePattern)) {
			setVfsFileNamePattern(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileProcessInterval)) {
			setVfsFileProcessInterval(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSFileProcessCount)) {
			setVfsFileProcessCount(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSLocking)) {
			setVfsLocking(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMaxRetryCount)) {
			setVfsMaxRetryCount(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSReconnectTimeout)) {
			setVfsReconnectTimeout(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSActionAfterProcess)) {
			setVfsActionAfterProcess(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMoveAfterProcess)) {
			setVfsMoveAfterProcess(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSActionAfterErrors)) {
			setVfsActionAfterErrors(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMoveAfterErrors)) {
			setVfsMoveAfterErrors(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSActionAfterFailure)) {
			setVfsActionAfterFailure(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSMoveAfterFailure)) {
			setVfsMoveAfterFailure(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSAutoLockRelease)) {
			setVfsAutoLockRelease(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSAutoLockReleaseInterval)) {
			setVfsAutoLockReleaseInterval(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSLockReleaseSameNode)) {
			setVfsLockReleaseSameNode(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSDistributedLock)) {
			setVfsDistributedLock(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionVFSDistributedTimeout)) {
			setVfsDistributedTimeout(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionSuspend)) {
			setSuspend(data.toString());
		} else if (key.equals(InboundEndpointArtifactProperties.wizardOptionCreateESBProject)) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject esbProject = ESBProjectUtils.createESBProject(shell,getLocation());
			if (esbProject != null) {
				setInboundEndpointSaveLocation(esbProject);
			}
		}
		return returnResult;
	}

	private String createFileURL(String fullFilePath) {
		String fileURL = "";
		if (fullFilePath != null && !fullFilePath.equals("")) {
			if (fullFilePath.startsWith("/")) {
				fileURL = "file:" + fullFilePath;
			} else if (!fullFilePath.startsWith("file")) {
				fileURL = "file:/" + fullFilePath;
			} else {
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

	public void setInboundEndpointSaveLocation(IContainer localEntrySaveLocation) {
		this.inboundEndpointSaveLocation = localEntrySaveLocation;
	}

	public void setInboundEndpointSaveLocation(String localEntrySaveLocation) {
		this.inboundEndpointSaveLocation = ResourcesPlugin.getWorkspace().getRoot()
				.getContainerForLocation(new Path(localEntrySaveLocation));
	}

	public IContainer getInboundEndpointSaveLocation() {
		return inboundEndpointSaveLocation;
	}

	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getInboundEndpointSaveLocation() == null && absolutionPath != null) {
			IContainer newEndpointSaveLocation = getContainer(absolutionPath,
					InboundEndpointArtifactProperties.esbProjectNature);
			setInboundEndpointSaveLocation(newEndpointSaveLocation);
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
				log.error(e);
			}
		}
		IContainer newInboundEndpointSaveLocation = null;
		if (currentSelection != null) {
			String path = absolutionPath.toString().substring(
					currentSelection.getLocation().toFile().toString().length());

			if ("".equals(path)) {
				newInboundEndpointSaveLocation = currentSelection;
			} else {
				newInboundEndpointSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newInboundEndpointSaveLocation;
	}

	public String getSourceURL() {
		return sourceURL;
	}

	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public String getClassImpl() {
		return classImpl;
	}

	public void setClassImpl(String classImpl) {
		this.classImpl = classImpl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getInjectingSequence() {
		return injectingSequence;
	}

	public void setInjectingSequence(String injectingSequence) {
		this.injectingSequence = injectingSequence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnErrorSequence() {
		return onErrorSequence;
	}

	public void setOnErrorSequence(String onErrorSequence) {
		this.onErrorSequence = onErrorSequence;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSuspend() {
		return suspend;
	}

	public void setSuspend(String suspend) {
		this.suspend = suspend;
	}

	public String getSelectedInboundEndpointType() {
		return selectedInboundEndpointType;
	}

	public void setSelectedInboundEndpointType(String localEntryType) {
		this.selectedInboundEndpointType = localEntryType;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getVfsContentType() {
		return vfsContentType;
	}

	public void setVfsContentType(String vfsContentType) {
		this.vfsContentType = vfsContentType;
	}

	public String getVfsFileNamePattern() {
		return vfsFileNamePattern;
	}

	public void setVfsFileNamePattern(String vfsFileNamePattern) {
		this.vfsFileNamePattern = vfsFileNamePattern;
	}

	public String getVfsFileProcessInterval() {
		return vfsFileProcessInterval;
	}

	public void setVfsFileProcessInterval(String vfsFileProcessInterval) {
		this.vfsFileProcessInterval = vfsFileProcessInterval;
	}

	public String getVfsFileProcessCount() {
		return vfsFileProcessCount;
	}

	public void setVfsFileProcessCount(String vfsFileProcessCount) {
		this.vfsFileProcessCount = vfsFileProcessCount;
	}

	public String getVfsLocking() {
		return vfsLocking;
	}

	public void setVfsLocking(String vfsLocking) {
		this.vfsLocking = vfsLocking;
	}

	public String getVfsMaxRetryCount() {
		return vfsMaxRetryCount;
	}

	public void setVfsMaxRetryCount(String vfsMaxRetryCount) {
		this.vfsMaxRetryCount = vfsMaxRetryCount;
	}

	public String getVfsReconnectTimeout() {
		return vfsReconnectTimeout;
	}

	public void setVfsReconnectTimeout(String vfsReconnectTimeout) {
		this.vfsReconnectTimeout = vfsReconnectTimeout;
	}

	public String getVfsActionAfterProcess() {
		return vfsActionAfterProcess;
	}

	public void setVfsActionAfterProcess(String vfsActionAfterProcess) {
		this.vfsActionAfterProcess = vfsActionAfterProcess;
	}

	public String getVfsMoveAfterProcess() {
		return vfsMoveAfterProcess;
	}

	public void setVfsMoveAfterProcess(String vfsMoveAfterProcess) {
		this.vfsMoveAfterProcess = vfsMoveAfterProcess;
	}

	public String getVfsActionAfterErrors() {
		return vfsActionAfterErrors;
	}

	public void setVfsActionAfterErrors(String vfsActionAfterErrors) {
		this.vfsActionAfterErrors = vfsActionAfterErrors;
	}

	public String getVfsMoveAfterErrors() {
		return vfsMoveAfterErrors;
	}

	public void setVfsMoveAfterErrors(String vfsMoveAfterErrors) {
		this.vfsMoveAfterErrors = vfsMoveAfterErrors;
	}

	public String getVfsActionAfterFailure() {
		return vfsActionAfterFailure;
	}

	public void setVfsActionAfterFailure(String vfsActionAfterFailure) {
		this.vfsActionAfterFailure = vfsActionAfterFailure;
	}

	public String getVfsMoveAfterFailure() {
		return vfsMoveAfterFailure;
	}

	public void setVfsMoveAfterFailure(String vfsMoveAfterFailure) {
		this.vfsMoveAfterFailure = vfsMoveAfterFailure;
	}

	public String getVfsAutoLockRelease() {
		return vfsAutoLockRelease;
	}

	public void setVfsAutoLockRelease(String vfsAutoLockRelease) {
		this.vfsAutoLockRelease = vfsAutoLockRelease;
	}

	public String getVfsAutoLockReleaseInterval() {
		return vfsAutoLockReleaseInterval;
	}

	public void setVfsAutoLockReleaseInterval(String vfsAutoLockReleaseInterval) {
		this.vfsAutoLockReleaseInterval = vfsAutoLockReleaseInterval;
	}

	public String getVfsLockReleaseSameNode() {
		return vfsLockReleaseSameNode;
	}

	public void setVfsLockReleaseSameNode(String vfsLockReleaseSameNode) {
		this.vfsLockReleaseSameNode = vfsLockReleaseSameNode;
	}

	public String getVfsDistributedLock() {
		return vfsDistributedLock;
	}

	public void setVfsDistributedLock(String vfsDistributedLock) {
		this.vfsDistributedLock = vfsDistributedLock;
	}

	public String getVfsDistributedTimeout() {
		return vfsDistributedTimeout;
	}

	public void setVfsDistributedTimeout(String vfsDistributedTimeout) {
		this.vfsDistributedTimeout = vfsDistributedTimeout;
	}

	public String getSequential() {
		return sequential;
	}

	public void setSequential(String sequential) {
		this.sequential = sequential;
	}

	public String getCoordination() {
		return coordination;
	}

	public void setCoordination(String coordination) {
		this.coordination = coordination;
	}

}
