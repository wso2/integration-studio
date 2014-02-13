package org.wso2.maven.gadget;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * This is the Maven Mojo used for gadget resources to be copied to the output
 * directory in the resource-process phase.
 *
 * @goal package-gadget
 *
 */
public class GadgetServiceMojo extends AbstractMojo{

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

	private File destFolder;

//	public void execute() throws MojoExecutionException, MojoFailureException {
//		destFolder = new File(project.getBuild().getDirectory());
//		String newPath = null;
//
//		if (fileName != null) { // if the user gave a name for the file
//			newPath = destFolder.getAbsolutePath() + File.separator + fileName;
//		} else {
//			if (extension != null) { // if the user provided the extension
//				String fileNameWithoutExtension = (artifact.getName()
//						.split("\\."))[0];
//				newPath = destFolder.getAbsolutePath() + File.separator
//						+ fileNameWithoutExtension + "." + extension;
//			} else {
//				newPath = destFolder.getAbsolutePath() + File.separator
//						+ artifact.getName();
//			}
//		}
//
//		File result = new File(newPath);
//
//		if (!artifact.exists()) {
//			throw new MojoExecutionException(artifact.getAbsolutePath() + " doesn't exist.");
//		}
//
//		try {
//			FileUtils.copyFile(artifact, result);
//
//		} catch (IOException e) {
//			throw new MojoExecutionException("Error when copying " + artifact.getName() + " to " +
//			                                 result.getName() + "\n" + e.getMessage());
//		}
//
//		if (result != null && result.exists()) {
//			project.getArtifact().setFile(result);
//			//projectHelper.attachArtifact(project, extension, null, result);
//		} else {
//			throw new MojoExecutionException(result
//					+ " is null or doesn't exist");
//		}
//
//		if (enableArchive) {
//			// TODO make the zip file
//		}
//
//	}

	public void execute() throws MojoExecutionException, MojoFailureException {
		if (!artifact.exists()) {
			throw new MojoExecutionException(artifact.getAbsolutePath() + " doesn't exist.");
		}

		File targetFolder = new File(project.getBuild().getDirectory());
		File sourceResourcesFolder = new File(artifact.getParentFile(), "gadget-resources");
		File allResources = new File(targetFolder, "all-resources");
		File destinatiopnResourceFolder = new File(allResources,"gadget-resources");
		if(allResources.exists()){
			deleteDir(allResources);
		}

		allResources.mkdirs();

		File zipFile;
		try {
			//Copy the required content to the archive directory
			FileUtils.copyDirectory(sourceResourcesFolder, destinatiopnResourceFolder);
			FileUtils.copyDirectory(artifact, new File(allResources,artifact.getName()));

//			zipFile = new File(targetFolder,"resources.zip");
			zipFile = new File(targetFolder,project.getArtifactId()+"_"+project.getVersion()+".dar");
			ArchiveManipulator archiveManupulator = new ArchiveManipulator();
			archiveManupulator.archiveDir(zipFile, destinatiopnResourceFolder);
		} catch (IOException e) {
			throw new MojoExecutionException("Error when copying " + artifact.getName() + " to " +
					destinatiopnResourceFolder.getName() + "\n" + e.getMessage());
		}finally{
			FileUtils.deleteDirectories(allResources);
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

	public void copyAllResources(File resourceParent) throws Exception{
		File regResourceFile = new File(resourceParent, artifact.getName());
		File[] regFiles = artifact.getParentFile().listFiles();
		FileUtils.copyFile(artifact.getPath(), regResourceFile.getPath());
		for (File file : regFiles) {
			File destinationFile  = new File(resourceParent, file.getName());
			if(file.getName().equals("resources") && file.isDirectory()){
				FileUtils.copyDirectory(file, destinationFile);
			}
		}
	}

}