/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard;

import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

public class MvnMutiModuleFieldsController extends AbstractFieldController {
	
	public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		boolean updateMode = ((MvnMultiModuleModel)model).isUpdateMode();
		boolean requiredParent = ((MvnMultiModuleModel)model).isRequiredParent();
		if (modelProperty.equals("group.id")) {
			if ((value == null)||(value.equals(""))) {
				throw new FieldValidationException("The groupId cannot be empty");
			}
		} else if(modelProperty.equals("project.name")){
			if(updateMode){
				if ((value == null)||(value.equals(""))) {
					throw new FieldValidationException("The artifactId cannot be empty");
				}
			} else{
				CommonFieldValidator.validateProjectField(value);
			}
		} else if (modelProperty.equals("version.id")) {
			if ((value == null)||(value.equals(""))) {
				throw new FieldValidationException("The version cannot be empty");
			}
		} else if(modelProperty.equals("import.project.list")){
			if ((value == null)||(value.equals(""))) {
				throw new FieldValidationException("No vaild projects available in workspace");
			}
		} else if(modelProperty.equals("parent.group")){
			if (requiredParent) {
				if ((value == null) || (value.equals(""))) {
					throw new FieldValidationException("Parent group id cannot be empty");
				}
			}
		} else if(modelProperty.equals("parent.artifact")){
			if (requiredParent) {
				if ((value == null) || (value.equals(""))) {
					throw new FieldValidationException("Parent artifact id cannot be empty");
				}
			}
		} else if(modelProperty.equals("parent.version")){
			if (requiredParent) {
				if ((value == null) || (value.equals(""))) {
					throw new FieldValidationException("Parent version cannot be empty");
				}
			}
		}
	}
	
	@Override
	public List<String> getUpdateFields(String modelProperty,
			ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if(modelProperty.equals("required.parent")){
			updateFields.add("parent.group");
			updateFields.add("parent.artifact");
			updateFields.add("parent.version");
			updateFields.add("parent.list");
			updateFields.add("relative.path");
		} else if (modelProperty.equals("parent.list")){
			updateFields.add("parent.group");
			updateFields.add("parent.artifact");
			updateFields.add("parent.version");
			updateFields.add("relative.path");
		}
		return updateFields;
	}
	
	@Override
	public boolean isVisibleField(String modelProperty, ProjectDataModel model) {
		boolean visibleField = super.isVisibleField(modelProperty, model);
		boolean requiredParent = ((MvnMultiModuleModel)model).isRequiredParent();

		if (modelProperty.equals("parent.group")
				|| modelProperty.equals("parent.artifact")
				|| modelProperty.equals("parent.version")
				|| modelProperty.equals("relative.path")
				|| modelProperty.equals("parent.list")) {
			visibleField = requiredParent;
		}
		return visibleField;
	}
}

