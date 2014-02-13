/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.task.validator;

import java.util.List;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.task.model.TaskModel;
import org.wso2.developerstudio.eclipse.artifact.task.validator.TriggerTypeList.TriggerType;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;
import static org.wso2.developerstudio.eclipse.artifact.task.util.ArtifactConstants.*;

/**
 * The controller class for task artifact wizard specific fields.
 */
public class ProjectFieldController extends AbstractFieldController {

	@Override
	public void validate(String modelProperty, Object value, ProjectDataModel model)
			throws FieldValidationException {
		TaskModel taskModel = (TaskModel) model;
		boolean triggerSimple = taskModel.getTriggerType() == TriggerType.SIMPLE;
		if (modelProperty.equals(Task_Name)) {
			CommonFieldValidator.validateArtifactName(value);
		} else if (modelProperty.equals(Task_Group)) {
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException(Err_Msg_Empty_Group);
			}
		} else if (modelProperty.equals(Task_Implementation)) {
			if (value == null || value.toString().trim().isEmpty()) {
				throw new FieldValidationException(Err_Msg_Empty_Impl);
			}
		} else if (modelProperty.equals(Task_Trigger_Count)) {
			if (triggerSimple) {
				if (value != null && value.toString().length() > 0) {
					try {
						int count = Integer.parseInt(value.toString());
						if (count < -1) {
							throw new Exception();
						} else {
							if (count > 1 && taskModel.getInterval() <= 0) {
								throw new Exception(Err_Msg_Simple_Trigger);
							}
							if (count ==-1 && taskModel.getInterval() <= 0) {
								throw new Exception(Err_Msg_Simple_Trigger);
							}
							if (count ==0 && taskModel.getInterval() == 0) {
								throw new Exception(Err_Msg_Simple_zero_Trigger);
							}
						}
						} catch (NumberFormatException e) {
						throw new FieldValidationException(Err_Msg_Count);
					} catch (Exception e) {
						throw new FieldValidationException(
								(e.getMessage() != null) ? e.getMessage() : Err_Msg_Count);
					}
				}
			}
		} else if (modelProperty.equals(Task_Trigger_Interval)) {
			if (triggerSimple) {
				if (value != null && value.toString().length() > 0) {
					try {
						long interval = Long.parseLong(value.toString());
						if (interval < 0) {
							throw new Exception();
						} else {
							if (taskModel.getCount() > 1 && interval == 0) {
								throw new Exception(Err_Msg_Simple_Trigger);
							}
						}
					} catch (NumberFormatException e) {
						throw new FieldValidationException(Err_Msg_Count);
					} catch (Exception e) {
						throw new FieldValidationException(
								(e.getMessage() != null) ? e.getMessage() : Err_Msg_Interval);
					}
				}
			}
		} else if (modelProperty.equals(Task_Cron)) {
			if (!triggerSimple) {
				if (value == null || value.toString().trim().isEmpty()) {
					throw new FieldValidationException(Err_Msg_Cron);
				} else{
					//FIXME: validate CRON expression 
				}
			}
		} else if (modelProperty.equals(Task_Pinned_Servers)) {
			//FIXME: validate pinned servers
		} else if (modelProperty.equals(Task_Save_location)) {
			IResource resource = (IResource) value;
			if (resource == null || !resource.exists())
				throw new FieldValidationException(Err_Msg_Empty_Path);
		}else if (modelProperty.equals("import.file")) {
			 CommonFieldValidator.validateImportFile(value);
		}  else if(modelProperty.equals("available.tasks")){
			TaskModel apiModel = (TaskModel) model; 
			if(null!=apiModel.getAvailableTaskslist() && apiModel.getAvailableTaskslist().size()>0){
				if(null==apiModel.getSelectedTasksList() || apiModel.getSelectedTasksList().size() <=0){
					throw new FieldValidationException("Please select at least one artifact");
			 }
		  }
	  }
	}

	@Override
	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if (modelProperty.equals(Task_Trigger_Type)) {
			updateFields.add(Task_Trigger_Count);
			updateFields.add(Task_Trigger_Interval);
			updateFields.add(Task_Cron);
		} else if (modelProperty.equals(Task_Create_Project)) {
			updateFields.add(Task_Save_location);
		}else if (modelProperty.equals("import.file")) {
			updateFields.add("available.tasks"); 
		}
		return updateFields;
	}

	@Override
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);
		boolean triggerSimple = ((TaskModel) model).getTriggerType() == TriggerType.SIMPLE;

		if (modelProperty.equals(Task_Trigger_Count)) {
			visibleField = triggerSimple;
		} else if (modelProperty.equals(Task_Trigger_Interval)) {
			visibleField = triggerSimple;
		}
		if (modelProperty.equals(Task_Cron)) {
			visibleField = !triggerSimple;
		}
		if (modelProperty.equals("available.tasks")) {
			List<OMElement> availableTasksList = ((TaskModel) model).getAvailableTaskslist();
			visibleField = (availableTasksList != null && availableTasksList.size() > 0);
		}
		return visibleField;
	}

	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals(Task_Save_location)) {
			readOnlyField = true;
		}
		return readOnlyField;
	}

}
