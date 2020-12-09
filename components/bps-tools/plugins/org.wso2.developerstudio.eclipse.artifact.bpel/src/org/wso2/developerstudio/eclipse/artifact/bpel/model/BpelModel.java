package org.wso2.developerstudio.eclipse.artifact.bpel.model;

import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class BpelModel extends ProjectDataModel {

	private String processName;
	private String processNS = "http://wso2.org/bps/sample";
	private String selectedTemplate;
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals("process.name")) {
				modelPropertyValue = getProcessName();
			}else if(key.equals("process.ns")){
				modelPropertyValue = getProcessNS();
			}
		}
		return modelPropertyValue;
	}

	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnValue = super.setModelPropertyValue(key, data);
		if (key.equals("import.file")) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				setProjectName(ProjectUtils.fileNameWithoutExtension(getImportFile().getName()));
			}
		}else if(key.equals("process.name")){
			setProcessName(data.toString());
		}else if(key.equals("process.ns")){
			setProcessNS(data.toString());
		}else if(key.equals("process.template")){
			setSelectedTemplate(data.toString());
		}
		return returnValue;
	}

	public void setProcessNS(String processNS) {
		this.processNS = processNS;
	}

	public String getProcessNS() {
		return processNS;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}


	public String getProcessName() {
		return processName;
	}
	
	public void setProjectName(String projectName) throws ObserverFailedException {
		if (getProjectName() != null && getProjectName().equals(getProcessName())) {
			setProcessName(projectName);
		}
		super.setProjectName(projectName);
	}
	
	public void setSelectedTemplate(String selectedTemplate) {
		this.selectedTemplate = selectedTemplate;
	}

	public String getSelectedTemplate() {
		return selectedTemplate;
	}
	

}
