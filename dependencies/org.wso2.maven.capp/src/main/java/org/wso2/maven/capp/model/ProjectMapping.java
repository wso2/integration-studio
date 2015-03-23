package org.wso2.maven.capp.model;


public class ProjectMapping {
	/**
	 * project name
	 * 
	 * @parameter
	 * @required
	 */
	public String projectName;
	
	/**
	 * maven group id
	 * 
	 * @parameter
	 * @required
	 */
	public String groupId;

	/**
	 * maven artifact id
	 * 
	 * @parameter
	 * @required
	 */
	public String artifactId;
	
	/**
	 * maven version
	 * 
	 * @parameter
	 * @required
	 */
	public String version;
	
	public ProjectMapping(String projectName, String groupId, String artifactId, String version) {
		setProjectName(projectName);
		setGroupId(groupId);
		setArtifactId(artifactId);
		setVersion(version);
	}

	public ProjectMapping(String projectName) {
		this(projectName,null,null,null);
	}

	public ProjectMapping() {
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public static ProjectMapping getMapping(String mappingString) throws Exception{
		String[] mappingData = mappingString.split(":");
		if (mappingData.length!=4){
			throw new Exception("Invalid mapping data. It should be of the form <projectName>:<groupId>:<artifactId>:<version>");
		}
		ProjectMapping projectMapping = new ProjectMapping(mappingData[0],mappingData[1],mappingData[2],mappingData[3]);
		return projectMapping;
	}
}
