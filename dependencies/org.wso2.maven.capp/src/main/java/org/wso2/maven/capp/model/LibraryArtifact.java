package org.wso2.maven.capp.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.wso2.maven.capp.utils.CAppMavenUtils;

public class LibraryArtifact {
	private static final String SCOPE_SYSTEM = "system";
	
	private String groupId;
	private String artifactId;
	private String version;
	private File artifactFile;
	private String scope;
	private List<String> packages;
	
	public LibraryArtifact() {
	}
	
	public LibraryArtifact(String groupId, String artifactId, String version, File artifactFile) {
		setGroupId(groupId);
		setArtifactId(artifactId);
		setVersion(version);
		setArtifactFile(artifactFile);
	}

	public LibraryArtifact(String groupId, String artifactId, String version) {
		this(groupId,artifactId,version,null);
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
	public File getArtifactFile() throws MojoExecutionException {
		if (artifactFile==null){
			Artifact resolvedArtifact = CAppMavenUtils.getResolvedArtifact(getGroupId(), getArtifactId(), getVersion(), "jar", "compile");
			artifactFile=resolvedArtifact.getFile();
		}
		return artifactFile;
	}
	public void setArtifactFile(File artifactFile) {
		scope=artifactFile==null? null:SCOPE_SYSTEM;
		this.artifactFile = artifactFile;
	}

	public List<String> getPackages() {
		if (packages==null){
			packages=new ArrayList<String>();
		}
		return packages;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getScope() {
		return scope;
	}

	public boolean isLocal(){
		return SCOPE_SYSTEM.equals(getScope());
	}
}
