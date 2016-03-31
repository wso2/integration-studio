package org.wso2.developerstudio.eclipse.capp.maven;

public class MavenPluginContributor {
	private String id;
	private String artifactType;
	private String extension;
	private IMavenPluginContributorProvider provider;
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setArtifactType(String artifactType) {
		this.artifactType = artifactType;
	}
	public String getArtifactType() {
		return artifactType;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getExtension() {
		return extension;
	}
	public void setProvider(IMavenPluginContributorProvider provider) {
		this.provider = provider;
	}
	public IMavenPluginContributorProvider getProvider() {
		return provider;
	}
}
