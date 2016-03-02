/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messageprocessor.validator;

import java.util.List;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;
import org.wso2.developerstudio.eclipse.artifact.messageprocessor.model.MessageProcessorModel;

/**
 * The controller class for message-processor artifact wizard specific fields.
 */
public class MessageProcessorFieldController extends AbstractFieldController {

	@Override
	public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		MessageProcessorModel processModel = (MessageProcessorModel) model;
		boolean isScheduledMessage = processModel.getMessageProcessorType()
				.equals("Scheduled Message Forwarding Processor");
		boolean isSamplingProcessor = processModel.getMessageProcessorType()
				.equals("Message Sampling Processor");
		boolean isCustomProcessor = processModel.getMessageProcessorType()
				.equals("Custom Message Processor");

		if (modelProperty.equals("processor.name")) {
			CommonFieldValidator.validateArtifactName(value);
		} else if (modelProperty.equals("processor.type")) {
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException(
						"Message Store cannot be empty");
			}
		} else if (modelProperty.equals("FSC_processor.store")) {
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException(
						"Message Store cannot be empty ..");
			}
		} else if (modelProperty.equals("Scheduled_Failover_processor.source_store")) {
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException(
						"Source Message Store cannot be empty ..");
			}
		} else if (modelProperty.equals("Scheduled_Failover_processor.target_store")) {
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException(
						"Target Message Store cannot be empty ..");
			}
		} else if (modelProperty.equals("save.location")) {
			IResource resource = (IResource) value;
			if (resource == null || !resource.exists())
				throw new FieldValidationException(
						"Specified project or path doesn't exist.");
		} else if (modelProperty.equals("FS_processor.retry_interval")) {
			if (isScheduledMessage) {
				if (!StringUtils.isNumeric((String) value)) {
					throw new FieldValidationException(
							"Retry interval is not valid");
				}
			}
		} else if (modelProperty
				.equals("FS_processor.forwarding_interval")) {
			if (isScheduledMessage) {
				if (!StringUtils.isNumeric((String) value)) {
					throw new FieldValidationException(
							"Forwarding interval is not valid");
				}
			}
		} else if (modelProperty.equals("sampling_processor.sampling_interval")) {
			if (isSamplingProcessor) {
				if (!StringUtils.isNumeric((String) value)) {
					throw new FieldValidationException(
							"Sampling interval is not valid");
				}
			}
		} else if (modelProperty
				.equals("sampling_processor.sampling_concurrency")) {
			if (isSamplingProcessor) {
				if (!StringUtils.isNumeric((String) value)) {
					throw new FieldValidationException(
							"Sampling concurrency is not valid");
				}
			}
		} else if (modelProperty.equals("sampling_processor.sequence")) {
			if (isSamplingProcessor) {
				if (value == null || value.toString().trim().isEmpty()) {
					throw new FieldValidationException(
							"Sequence cannot be empty");
				}
			}
		} else if (modelProperty.equals("Forwarding_processor.endpoint_name")) {
			if (isScheduledMessage
					&& !processModel.getMessageProcessorName().equals("")) {
				if (value == null || value.toString().trim().isEmpty()) {
					throw new FieldValidationException(
							"Endpoint name cannot be empty");
				}
			}
		} else if (modelProperty.equals("custom_processor.class_FQN")) {
			if (isCustomProcessor) {
				if (value == null || value.toString().trim().isEmpty()) {
					throw new FieldValidationException(
							"Message Processor Provider Class FQN cannot be empty");
				}
			}
		} else if (modelProperty.equals("import.file")) {
			CommonFieldValidator.validateImportFile(value);
		} else if (modelProperty.equals("available.processors")) {
			MessageProcessorModel processorModel = (MessageProcessorModel) model;
			if (processorModel.getAvailableProcessorlist() != null
					&& processorModel.getAvailableProcessorlist().size() > 0) {
				if (processorModel.getSelectedProcessorList() == null
						|| processorModel.getSelectedProcessorList().size() == 0) {
					throw new FieldValidationException(
							"Please select at least one Messge-Processor");
				}
			}
		}
	}

	@Override
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);

		if (modelProperty.startsWith("FSS_processor.")) {
			if (((MessageProcessorModel) model).getMessageProcessorType()
					.equals("Scheduled Message Forwarding Processor")
					|| ((MessageProcessorModel) model)
							.getMessageProcessorType().equals(
									"Message Sampling Processor")
					|| ((MessageProcessorModel) model)
							.getMessageProcessorType()
							.equals("Scheduled Failover Message Forwarding Processor")) {
				visibleField = true;
			} else {
				visibleField = false;
			}
		}
		if (modelProperty.startsWith("FSC_processor.")) {
			if (((MessageProcessorModel) model).getMessageProcessorType()
					.equals("Scheduled Message Forwarding Processor")
					|| ((MessageProcessorModel) model)
							.getMessageProcessorType().equals(
									"Message Sampling Processor")
					|| ((MessageProcessorModel) model)
							.getMessageProcessorType()
							.equals("Custom Message Processor")) {
				visibleField = true;
			} else {
				visibleField = false;
			}
		}
		if (modelProperty.startsWith("FS_processor.")) {
			if (((MessageProcessorModel) model).getMessageProcessorType()
					.equals("Scheduled Message Forwarding Processor")
					|| ((MessageProcessorModel) model)
							.getMessageProcessorType()
							.equals("Scheduled Failover Message Forwarding Processor")) {
				visibleField = true;
			} else {
				visibleField = false;
			}
		} else if (modelProperty.startsWith("Forwarding_processor.")) {
			visibleField = ((MessageProcessorModel) model)
					.getMessageProcessorType().equals(
							"Scheduled Message Forwarding Processor");
		} else if (modelProperty.startsWith("sampling_processor.")) {
			visibleField = ((MessageProcessorModel) model)
					.getMessageProcessorType().equals(
							"Message Sampling Processor");
		} else if (modelProperty.startsWith("custom_processor.")) {
			visibleField = ((MessageProcessorModel) model)
					.getMessageProcessorType().equals(
							"Custom Message Processor");
		} else if (modelProperty.startsWith("Scheduled_Failover_processor.")) {
			visibleField = ((MessageProcessorModel) model)
					.getMessageProcessorType().equals(
							"Scheduled Failover Message Forwarding Processor");
		} else if (modelProperty.equals("available.processors")) {
			List<OMElement> availableProcessors = ((MessageProcessorModel) model)
					.getAvailableProcessorlist();
			visibleField = (availableProcessors != null && availableProcessors
					.size() > 0);
		}

		return visibleField;
	}

	@Override
	public List<String> getUpdateFields(String modelProperty,
			ProjectDataModel model) {
		List<String> updatedList = super.getUpdateFields(modelProperty, model);

		if (modelProperty.equals("processor.type")) {
			updatedList.add("FSS_processor.configuration_file_path");
			updatedList.add("FSS_processor.cron_expression");
			updatedList.add("FSS_processor.processor_state");
			updatedList.add("FSC_processor.store");
			updatedList.add("FS_processor.delivery_attempts");
			updatedList.add("FS_processor.Fault_sequence_name");
			updatedList.add("FS_processor.Deactivate_sequence_name");
			updatedList.add("FS_processor.forwarding_interval");
			updatedList.add("FS_processor.retry_interval");
			updatedList
					.add("FS_processor.drop_message_after_maximum_delivery_attempts");
			updatedList.add("FS_processor.task_count");
			updatedList.add("Forwarding_processor.client_repository");
			updatedList.add("Forwarding_processor.axis2_configuration");
			updatedList.add("Forwarding_processor.endpoint_name");
			updatedList.add("Forwarding_processor.Reply_sequence_name");
			updatedList.add("Forwarding_processor.Fault_reg");
			updatedList.add("Forwarding_processor.non_retry_http_status_codes");
			updatedList.add("sampling_processor.sequence");
			updatedList.add("sampling_processor.sampling_interval");
			updatedList.add("sampling_processor.sampling_concurrency");
			updatedList.add("custom_processor.class_FQN");
			updatedList.add("custom_processor.parameters");
			updatedList.add("Scheduled_Failover_processor.source_store");
			updatedList.add("Scheduled_Failover_processor.target_store");
		} else if (modelProperty.equals("create.esb.prj")) {
			updatedList.add("save.location");
		} else if (modelProperty.equals("import.file")) {
			updatedList.add("available.processors");
		}

		return updatedList;
	}

	@Override
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals("save.location")) {
			readOnlyField = true;
		}
		return readOnlyField;
	}

}
