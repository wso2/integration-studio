package org.wso2.integrationstudio.artifact.ds.validator.validators;

import java.util.List;

import org.wso2.integrationstudio.platform.core.exception.FieldValidationException;
import org.wso2.integrationstudio.platform.core.model.AbstractFieldController;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;
import org.wso2.integrationstudio.platform.ui.validator.CommonFieldValidator;

public class ValidatorFieldsController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		if (modelProperty.equals("project.name")) {
			CommonFieldValidator.validateProjectField(value);
		}
		if(modelProperty.equals("vaildatorClass.package.name")){
			CommonFieldValidator.validateJavaPackageNameField(value);
		}
		if(modelProperty.equals("vaildatorClass.name")){
			CommonFieldValidator.validateJavaClassNameField(value);
		}
		if(modelProperty.equals("import.project.list")){
			if ((value == null)||(value.equals(""))) {
				throw new FieldValidationException("No vaild projets available in workspace");
			}
		}
	}
	
	@Override
	public List<String> getUpdateFields(String modelProperty, ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		
		if (modelProperty.equals("import.project.list")) {
			updateFields.add("project.name");
		}
		
		return updateFields;
	}
}
