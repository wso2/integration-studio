package org.wso2.developerstudio.eclipse.maven.executor;

public interface IMavenDefiniton {

	public abstract String getGroupId();

	public abstract String getArtifactId();

	public abstract String getVersion();

	public abstract MavenExecuteMode getExecuteMode();

	public String getMavenArtifactId();
}