package org.wso2.developerstudio.eclipse.artifact.bpel.validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;
import org.wso2.developerstudio.eclipse.artifact.bpel.model.BpelModel;

import java.io.File;
import java.util.List;

public class BPELProjectFieldController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		IProject project;
		if (modelProperty.equals("project.name")) {
			CommonFieldValidator.validateProjectField(value);
		} else if (modelProperty.equals("import.file")) {
			if (value == null) {
				throw new FieldValidationException("Specified war file location is invalid");
			}
			File warFile = (File) value;
			if (!warFile.exists()) {
				throw new FieldValidationException("Specified war file doesn't exist");
			}
		}else if (modelProperty.equals("process.name")) {
			if (value == null) {
				throw new FieldValidationException("Process name cannot be empty");
			}
			String projectName = value.toString();
			if (projectName.trim().equals("")) {
				throw new FieldValidationException("Process name cannot be empty");
			}
			String processName = ((BpelModel)model).getProcessName();
			project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			IFile file = project.getFile(processName + ".bpel");
			if (file.exists()) {
				throw new FieldValidationException("Process with the name '" + projectName +
				                                   "' already exists");
			}
		}else if (modelProperty.equals("process.ns")) {
			if (value == null) {
				throw new FieldValidationException("Process namespace cannot be empty");
			}
			String projectName = value.toString();
			if (projectName.trim().equals("")) {
				throw new FieldValidationException("Process namespace cannot be empty");
			}
		}
	}
	
	public List<String> getUpdateFields(String modelProperty,
			ProjectDataModel model) {
		List<String> updateFields = super.getUpdateFields(modelProperty, model);
		if(modelProperty.equals("project.name")){
			updateFields.add("process.name");
		}
		// TODO Auto-generated method stub
		return updateFields;
	}
	
	

}
