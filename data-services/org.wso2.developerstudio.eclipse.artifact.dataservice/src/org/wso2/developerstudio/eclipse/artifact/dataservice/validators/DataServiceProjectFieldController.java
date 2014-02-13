package org.wso2.developerstudio.eclipse.artifact.dataservice.validators;

import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import java.io.File;

public class DataServiceProjectFieldController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		if (modelProperty.equals("project.name")) {
			CommonFieldValidator.validateProjectField(value);
		} else if (modelProperty.equals("import.file")) {
			if (value == null) {
				throw new FieldValidationException("Specified dbs file location is invalid");
			}
			File warFile = (File) value;
			if (!warFile.exists()) {
				throw new FieldValidationException("Specified dbs file doesn't exist");
			}
		} else if (modelProperty.equals("service.name")) {
			if (value == null || value.equals("")) {
				throw new FieldValidationException("Data service name cannot be empty");
			}
			
		}

	}

}
