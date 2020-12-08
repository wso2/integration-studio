package org.wso2.integrationstudio.eclipse.project.extensions.handlers;

public class WSO2ProjectNature {
	
	String projectNature;
	boolean isMultipleArtifactProject;
	boolean isCappSupported;
	
	
	public boolean isCappSupported() {
		return isCappSupported;
	}
	public void setCappSupported(boolean isCappSupported) {
		this.isCappSupported = isCappSupported;
	}
	public String getProjectNature() {
		return projectNature;
	}
	public void setProjectNature(String projectNature) {
		this.projectNature = projectNature;
	}
	public boolean isMultipleArtifactProject() {
		return isMultipleArtifactProject;
	}
	public void setMultipleArtifactProject(boolean isMultipleArtifactProject) {
		this.isMultipleArtifactProject = isMultipleArtifactProject;
	}

}
