package org.wso2.maven.bpel.artifact;

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.maven.bpel.artifact.utils.FileUtils;

/**
 * Create a bpel artifact from Maven project
 *
 * @goal bpel
 * @phase package
 * @description build an bpel artifact
 */
public class BPELMojo extends AbstractMojo {

	/**
	 * @parameter default-value="${project.basedir}"
	 */
	private File path;
	
	/**
	 * @parameter default-value="zip"
	 */
	private String type;

	/**
	 * @parameter default-value="false"
	 */
	private boolean enableArchive;

	/**
	 * @parameter default-value="${project}"
	 */
	private MavenProject mavenProject;

	/**
	 * Maven ProjectHelper.
	 * 
	 * @component
	 */
	private MavenProjectHelper projectHelper;

	public void execute() throws MojoExecutionException, MojoFailureException {
		File project = path;
		try {
	        createZip(project);
        } catch (Exception e) {
	        e.printStackTrace();
        }
	}

	public void createZip(File project) throws MojoExecutionException {
		try {
			String bpelArtifactFullPath = getBPELProjectName(project);
			File bpelArtifactFile = new File(bpelArtifactFullPath);
			String artifactType = getType();
			String artifactName=mavenProject.getArtifactId() + "-" + mavenProject.getVersion() + "." + artifactType; 
			File archive = FileUtils.createArchive(project, bpelArtifactFile, artifactName);
			if (archive != null && archive.exists()) {
				mavenProject.getArtifact().setFile(archive);
			} else {
				throw new MojoExecutionException(archive + " is null or doesn't exist");
			}
		} catch (Exception e) {
			throw new MojoExecutionException("Error while creating bpel archive",e);
		}

	}

	public String getBPELProjectName(File project) {
		List<File> fileList = FileUtils.getAllFilesPresentInFolder(project);
		String bpelProjectName = project.getName();
		for (int i = 0; i < fileList.size(); i++) {
			File file = fileList.get(i);
			if (!file.isDirectory()) {
				try {
					if (file.getName().toLowerCase().endsWith(".bpel")) {
						bpelProjectName = file.getParent();
						return bpelProjectName;
					}
				} catch (Exception e) {
				}
			}
		}
		return bpelProjectName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setEnableArchive(boolean enableArchive) {
		this.enableArchive = enableArchive;
	}

	public boolean isEnableArchive() {
		return enableArchive;
	}

}
