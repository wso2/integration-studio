package org.wso2.maven.car.artifact;

public class TopologyMavenArtifact {
	
    /**
     * group id of the topology artifact
     *
     * @required
     * @parameter
     */
	private String groupId;
	
    /**
     * artifact id of the topology artifact
     *
     * @required
     * @parameter
     */
	private String artifactId;

    /**
     * version of the topology artifact
     *
     * @required
     * @parameter
     */
	private String version;
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
	public String getArtifactId() {
		return artifactId;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersion() {
		return version;
	}
}
