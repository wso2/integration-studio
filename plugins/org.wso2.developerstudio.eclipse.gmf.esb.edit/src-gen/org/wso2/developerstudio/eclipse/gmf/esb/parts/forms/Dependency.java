package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

public class Dependency {

	String groupId;
	String artifactId;
	String version;

	public Dependency(String groupId, String artifactId, String version) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getVersion() {
		return version;
	}

}
