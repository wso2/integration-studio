package org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.validators;

import org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.model.CarbonUiModel;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

public class UIbundleFieldsController extends AbstractFieldController {

	public void validate(String modelProperty, Object value,
			ProjectDataModel model) throws FieldValidationException {
		if (modelProperty.equals("project.name")) {
			CommonFieldValidator.validateProjectField(value);
		}  else if (modelProperty.equals("uibundle.id")){
			String id = value.toString();
			if ("".equals(id)) {
				throw new FieldValidationException("Id is not set");
			}
		    if((id.indexOf(".") == 0)||(id.indexOf(".")== id.length()-1)){
				throw new FieldValidationException("Invalid ID.  Legal characters are A-Z a-z 0-9 . _ -");
			}
		} else if(modelProperty.equals("uibundle.version")){
			String id = value.toString();
			if ("".equals(id)) {
				throw new FieldValidationException("Version: A value must be specified");
			}
		    if((id.indexOf(".") == 0)||(id.indexOf(".")== id.length()-1)){
				throw new FieldValidationException("Version: The specified version does not have the" +
						" correct format (major.minor.micro.qualifier) or contains invalid characters");
			}
		} else if(modelProperty.equals("import.project.list")){
			if ((value == null)||(value.equals(""))) {
				throw new FieldValidationException("No vaild projets available in workspace");
			}
		} else if(modelProperty.equals("deploy.path")){
			if ((value == null)||(value.equals(""))) {
				throw new FieldValidationException("Deploy path must be specified");
			}
		} 
		
	}

	public boolean isEnableField(String modelProperty, ProjectDataModel model) {
		boolean enableField = super.isEnableField(modelProperty, model);
		if(modelProperty.equals("activator.class")){
			enableField = ((CarbonUiModel)model).isActivatorRequired();
		}
		return enableField;
	}
}
