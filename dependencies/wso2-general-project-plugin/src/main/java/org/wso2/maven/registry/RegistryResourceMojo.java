package org.wso2.maven.registry;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * This is the Maven Mojo used for rule service to be copied to the output
 * directory in the resource-process phase.
 *
 * @goal package-registry
 *
 */
public class RegistryResourceMojo extends AbstractMojo{
	/**
	 * @parameter default-value="${project}"
	 */
	private MavenProject project;

	/**
	 * Maven ProjectHelper.
	 * 
	 * @component
	 */
	private MavenProjectHelper projectHelper;

	/**
	 * The path of the existing artifact
	 * 
	 * @parameter expression="${deploy-file.artifact}"
	 * @required
	 */
	private File artifact;

	/**
	 * The resulting extension of the file
	 * 
	 * @parameter expression="${deploy-file.extension}
	 */
	private String extension;

	/**
	 * The resulting extension of the file
	 * 
	 * @parameter expression="${deploy-file.fileName}
	 */
	private String fileName;

	/**
	 * If the file should be archived
	 * 
	 * @parameter expression="${deploy-file.enableArchive}" default-value=false
	 */
	private boolean enableArchive;

	public void execute() throws MojoExecutionException, MojoFailureException {
		if (!artifact.exists()) {
			throw new MojoExecutionException(artifact.getAbsolutePath() + " doesn't exist.");
		}
		
		File targetFolder = new File(project.getBuild().getDirectory());
		File sourceResourcesFolder = new File(artifact.getParentFile(), "resources");
		
		File allRegResources = new File(targetFolder, "all-reg-resources");
		File destinatiopnResourceFolder = new File(allRegResources,"resources");

		if(allRegResources.exists()){
			deleteDir(allRegResources);
		}
		
		allRegResources.mkdirs();
		
		File zipFile;
		try {
			//Copy the required content to the archive directory
			FileUtils.copyDirectory(sourceResourcesFolder, destinatiopnResourceFolder);
			FileUtils.copy(artifact, new File(allRegResources,artifact.getName()));
			
			zipFile = new File(targetFolder,"resources.zip");
			ArchiveManipulator archiveManupulator = new ArchiveManipulator();
			archiveManupulator.archiveDir(zipFile, allRegResources);
		} catch (IOException e) {
			throw new MojoExecutionException("Error when copying " + artifact.getName() + " to " +
					destinatiopnResourceFolder.getName() + "\n" + e.getMessage());
		}

		if (zipFile != null && zipFile.exists()) {
			project.getArtifact().setFile(zipFile);
		} else {
			throw new MojoExecutionException(destinatiopnResourceFolder
					+ " is null or doesn't exist");
		}

		if (enableArchive) {
			// TODO make the zip file
		}
	}
	
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
    
        // The directory is now empty so delete it
        return dir.delete();
    }
	
	public void copyAllRegResources(File resourceParent) throws IOException{
		File regResourceFile = new File(resourceParent, artifact.getName());
		File[] regFiles = artifact.getParentFile().listFiles();
		FileUtils.copy(artifact, regResourceFile);
		for (File file : regFiles) {
			File destinationFile  = new File(resourceParent, file.getName()); 
			if(file.getName().equals("resources") && file.isDirectory()){
				FileUtils.copyDirectory(file, destinationFile);
				
			}
		}
	}

}
