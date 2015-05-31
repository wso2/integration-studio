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

import java.util.List;
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

	private final String TYPE_HTTP = "HTTP";
	private final String TYPE_FILE = "File";
	private final String TYPE_JMS = "JMS";
	private final String TYPE_CUSTOM = "Custom";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public void validate(String modelProperty, Object value, ProjectDataModel model) throws FieldValidationException {
		InboundEndpointModel inboundEndpointModel = (InboundEndpointModel) model;
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
							log.error("Validation failure - Error while reading artifact.xml", e);
							throw new FieldValidationException("Validation failure - Error while reading artifact.xml",
									e);
						}
					}
				}
			}

		} else if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportOption)) {
			CommonFieldValidator.validateImportFile(value);

		} else if (InboundEndpointArtifactProperties.wizardOptionSaveLocation.equals(modelProperty)) {
			IResource resource = (IResource) value;
			if (resource == null || !resource.exists()) {
				throw new FieldValidationException("Specified project or path doesn't exist");
			}
		} //FIXME
		/*else if (InboundEndpointArtifactProperties.wizardOptionSequence.equals(modelProperty)) {
			String resource = value.toString();
			if (resource == null || "".equals(resource)) {
				throw new FieldValidationException("Sequence value cannot be empty");
			}
		} else if (InboundEndpointArtifactProperties.wizardOptionErrorSequence.equals(modelProperty)) {
			String resource = value.toString();
			if (resource == null || "".equals(resource)) {
				throw new FieldValidationException("Error sequence value cannot be empty");
			}
		} else if (InboundEndpointArtifactProperties.wizardOptionInboundHTTPPort.equals(modelProperty)) {
			if (InboundEndpointArtifactProperties.typeHTTP.equals(selectedInboundEndpointType)) {
				String resource = value.toString();
				if (resource == null || "".equals(resource)) {
					throw new FieldValidationException("Inbound http port value cannot be empty");
				}
			}
		}*/
	}

	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);
		if (modelProperty.startsWith("type.file.")) {
			visibleField = ((InboundEndpointModel) model).getSelectedInboundEndpointType().equals(TYPE_FILE);
		} else if (modelProperty.startsWith("type.jms.")) {
			visibleField = ((InboundEndpointModel) model).getSelectedInboundEndpointType().equals(TYPE_JMS);
		} else if (modelProperty.equals("inbound.http.port")) {
			visibleField = ((InboundEndpointModel) model).getSelectedInboundEndpointType().equals(TYPE_HTTP);
		} else if (modelProperty.equals("class")) {
			visibleField = ((InboundEndpointModel) model).getSelectedInboundEndpointType().equals(TYPE_CUSTOM);
		} else if (modelProperty.equals("interval")) {
			visibleField = ((InboundEndpointModel) model).getSelectedInboundEndpointType().matches(
					TYPE_FILE + "|" + TYPE_JMS + "|" + TYPE_CUSTOM);
		} else if (modelProperty.equals("sequential|coordination")) {
			visibleField = ((InboundEndpointModel) model).getSelectedInboundEndpointType().matches(
					TYPE_FILE + "|" + TYPE_CUSTOM);
		}
		return visibleField;
	}

	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updatedList = super.getUpdateFields(modelProperty, model);

		if (modelProperty.equals("inboundendpoint.type")) {
			updatedList.add("type.file.transport.vfs.FileURI");
			updatedList.add("type.file.transport.vfs.ContentType");
			updatedList.add("type.file.transport.vfs.FileNamePattern");
			updatedList.add("type.file.transport.vfs.FileProcessInterval");
			updatedList.add("type.file.transport.vfs.FileProcessCount");
			updatedList.add("type.file.transport.vfs.Locking");
			updatedList.add("type.file.transport.vfs.MaxRetryCount");
			updatedList.add("type.file.transport.vfs.ReconnectTimeout");
			updatedList.add("type.file.transport.vfs.ActionAfterProcess");
			updatedList.add("type.file.transport.vfs.MoveAfterProcess");
			updatedList.add("type.file.transport.vfs.ActionAfterErrors");
			updatedList.add("type.file.transport.vfs.MoveAfterErrors");
			updatedList.add("type.file.transport.vfs.ActionAfterFailure");
			updatedList.add("type.file.transport.vfs.MoveAfterFailure");
			updatedList.add("type.file.transport.vfs.AutoLockRelease");
			updatedList.add("type.file.transport.vfs.AutoLockReleaseInterval");
			updatedList.add("type.file.transport.vfs.LockReleaseSameNode");
			updatedList.add("type.file.transport.vfs.DistributedLock");
			updatedList.add("type.file.transport.vfs.DistributedTimeout");
			updatedList.add("type.jms.java.naming.factory.initial");
			updatedList.add("type.jms.java.naming.provider.url");
			updatedList.add("type.jms.transport.jms.ConnectionFactoryJNDIName");
			updatedList.add("type.jms.transport.jms.ConnectionFactoryType");
			updatedList.add("type.jms.transport.jms.Destination");
			updatedList.add("type.jms.transport.jms.SessionTransacted");
			updatedList.add("type.jms.transport.jms.SessionAcknowledgement");
			updatedList.add("type.jms.transport.jms.CacheLevel");
			updatedList.add("type.jms.transport.jms.UserName");
			updatedList.add("type.jms.transport.jms.Password");
			updatedList.add("type.jms.transport.jms.JMSSpecVersion");
			updatedList.add("type.jms.transport.jms.SubscriptionDurable");
			updatedList.add("type.jms.transport.jms.DurableSubscriberClientID");
			updatedList.add("type.jms.transport.jms.MessageSelector");
			updatedList.add("interval");
			updatedList.add("inbound.http.port");
			updatedList.add("sequential");
			updatedList.add("coordination");
			updatedList.add("class");

		} else if (modelProperty.equals("create.esb.prj")) {
			updatedList.add("save.location");
		} else if (modelProperty.equals("import.file")) {
			updatedList.add("available.processors");
		}

		return updatedList;
	}

	public boolean isEnableField(String modelProperty, ProjectDataModel model) {
		boolean enableField = super.isEnableField(modelProperty, model);
		if (modelProperty.equals(InboundEndpointArtifactProperties.wizardOptionImportFilePath)) {
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
