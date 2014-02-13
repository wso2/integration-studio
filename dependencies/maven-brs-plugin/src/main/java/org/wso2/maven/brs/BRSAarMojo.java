/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.maven.brs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.maven.archiver.MavenArchiveConfiguration;
import org.apache.maven.archiver.MavenArchiver;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.artifact.resolver.filter.ScopeArtifactFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.archiver.ArchiverException;
import org.codehaus.plexus.archiver.jar.JarArchiver;
import org.codehaus.plexus.archiver.jar.ManifestException;
import org.codehaus.plexus.util.FileUtils;


/**
 *
 * @goal aar
 * @phase package
 *
 */
public class BRSAarMojo extends AbstractMojo{

	/**
	 * The projects base directory.
	 *
	 * @parameter expression="${project.basedir}"
	 * @required
	 * @readonly
	 */
	protected File baseDir;
	
	/**
	 * The projects base directory.
	 *
	 * @parameter expression="${project.basedir}/src/main/ruleservice"
	 * @required
	 * @readonly
	 */
	protected File ruleserviceDir;

	/**
	 * The maven project.
	 *
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	protected MavenProject project;

	/**
	 * The directory containing generated classes.
	 *
	 * @parameter expression="${project.build.outputDirectory}"
	 * @required
	 */
	private File classesDirectory;

	/**
	 * The directory where the aar is built.
	 *
	 * @parameter expression="${project.build.directory}/aar"
	 * @required
	 */
	protected File aarDirectory;
	
	/**
	 * The directory where the facts jar is built.
	 *
	 * @parameter expression="${project.build.directory}/facts"
	 * @required
	 */
	protected File factsDirectory;

	/**
	 * Whether the dependency jars should be included in the aar
	 *
	 * @parameter expression="${includeDependencies}" default-value="true"
	 */
	private boolean includeDependencies;


	/**
	 * The directory for the generated aar.
	 *
	 * @parameter expression="${project.build.directory}"
	 * @required
	 */
	private String outputDirectory;

	/**
	 * The name of the generated aar.
	 *
	 * @parameter expression="${project.build.finalName}"
	 * @required
	 */
	private String aarName;

	/**
	 * The Jar archiver.
	 *
	 * @parameter expression="${component.org.codehaus.plexus.archiver.Archiver#jar}"
	 * @required
	 */
	private JarArchiver jarArchiver;

	/**
	 * The maven archive configuration to use.
	 *
	 * @parameter
	 */
	private MavenArchiveConfiguration archive = new MavenArchiveConfiguration();

	/**
	 * Classifier to add to the artifact generated. If given, the artifact will be an attachment
	 * instead.
	 *
	 * @parameter
	 */
	private String classifier;

	/**
	 * Whether this is the main artifact being built. Set to <code>false</code> if you don't want to
	 * install or deploy it to the local repository instead of the default one in an execution.
	 *
	 * @parameter expression="${primaryArtifact}" default-value="true"
	 */
	private boolean primaryArtifact;

	/** @component */
	private MavenProjectHelper projectHelper;


	/**
	 * Executes the AarMojo on the current project.
	 *
	 * @throws MojoExecutionException if an error occured while building the webapp
	 */

	public void execute() throws MojoExecutionException, MojoFailureException {
		File aarFile = new File(outputDirectory, aarName + ".aar");

		try {
			performPackaging(aarFile);
		}
		catch (Exception e) {
			throw new MojoExecutionException("Error assembling aar", e);
		}
	}

	/**
	 * Generates the aar.
	 *
	 * @param aarFile the target aar file
	 * @throws IOException
	 * @throws ArchiverException
	 * @throws ManifestException
	 * @throws DependencyResolutionRequiredException
	 *
	 */
	private void performPackaging(File aarFile)
	throws IOException, ArchiverException, ManifestException,
	DependencyResolutionRequiredException,
	MojoExecutionException {

		buildExplodedAar();

		// generate aar file
		getLog().info("Generating aar " + aarFile.getAbsolutePath());
		
		MavenArchiver archiver = new MavenArchiver();
		archiver.setArchiver(jarArchiver);
		archiver.setOutputFile(aarFile);
		
		jarArchiver.addDirectory(aarDirectory);
		
		// create archive
		archiver.createArchive(project, archive);

		if (classifier != null) {
			projectHelper.attachArtifact(project, "aar", classifier, aarFile);
		} else {
			Artifact artifact = project.getArtifact();

			if (primaryArtifact) {
				artifact.setFile(aarFile);
			} else if (artifact.getFile() == null || artifact.getFile().isDirectory()) {
				artifact.setFile(aarFile);
			} else {
				projectHelper.attachArtifact(project, "aar", aarFile);
			}
		}
	}

	/**
	 * Builds the exploded AAR file.
	 *
	 * @throws MojoExecutionException
	 */

	protected void buildExplodedAar()
	throws MojoExecutionException {

		getLog().debug("Exploding aar...");
		aarDirectory.mkdirs();
		getLog().debug("Assembling aar " + project.getArtifactId() + " in " + aarDirectory);
		
		
		final File libDir = new File(aarDirectory, "lib");

		try {
			if (classesDirectory.exists() && (!classesDirectory.equals(factsDirectory))) {
				FileUtils.copyDirectoryStructure(classesDirectory, factsDirectory);
			}
			
			if(ruleserviceDir.exists()){
				FileUtils.copyDirectoryStructure(ruleserviceDir, aarDirectory);
			}
			
			File factsJar = new File(libDir, project.getArtifactId() + "-" + project.getVersion()  + ".jar");
			
			JarArchiver factsArchiver = new JarArchiver();
			MavenArchiver archiver = new MavenArchiver();
		
			archiver.setArchiver(factsArchiver);
			archiver.setOutputFile(factsJar);
			
			factsArchiver.addDirectory(factsDirectory);
			
			archiver.createArchive(project, archive);
		
		
		 if (includeDependencies) {
         
             Set artifacts = project.getArtifacts();
         	
             List duplicates = findDuplicates(artifacts);
             
             for (Iterator iter = artifacts.iterator(); iter.hasNext();) {
            	
                 Artifact artifact = (Artifact)iter.next();
                 String targetFileName = getDefaultFinalName(artifact);

                 getLog().debug("Processing: " + targetFileName);

                 if (duplicates.contains(targetFileName)) {
                     getLog().debug("Duplicate found: " + targetFileName);
                     targetFileName = artifact.getGroupId() + "-"
                             + targetFileName;
                     getLog().debug("Renamed to: " + targetFileName);
                 }

                 // TODO: utilise appropriate methods from project builder
                 ScopeArtifactFilter filter = new ScopeArtifactFilter(
                         Artifact.SCOPE_RUNTIME);
                 if (!artifact.isOptional() && filter.include(artifact)) {
                     String type = artifact.getType();
                     if ("jar".equals(type)) {
                         copyFileIfModified(artifact.getFile(), new File(
                                 libDir, targetFileName));
                     }
                 }
             }
         }
		
		} catch (IOException e) {
			throw new MojoExecutionException("Could not explode aar...", e);
		} catch (Exception e) {
			throw new MojoExecutionException("Error assembling aar", e);
		} 
		
			
		
	}
	
	/**
     * Searches a set of artifacts for duplicate filenames and returns a list of duplicates.
     *
     * @param artifacts set of artifacts
     * @return List of duplicated artifacts
     */
    private List findDuplicates(Set artifacts) {
        List duplicates = new ArrayList();
        List identifiers = new ArrayList();
        for (Iterator iter = artifacts.iterator(); iter.hasNext();) {
            Artifact artifact = (Artifact)iter.next();
            String candidate = getDefaultFinalName(artifact);
            if (identifiers.contains(candidate)) {
                duplicates.add(candidate);
            } else {
                identifiers.add(candidate);
            }
        }
        return duplicates;
    }
    
    /**
     * Converts the filename of an artifact to artifactId-version.type format.
     *
     * @param artifact
     * @return converted filename of the artifact
     */
    private String getDefaultFinalName(Artifact artifact) {
        return artifact.getArtifactId() + "-" + artifact.getVersion() + "." +
                artifact.getArtifactHandler().getExtension();
    }
    
    /**
     * Copy file from source to destination only if source timestamp is later than the destination
     * timestamp. The directories up to <code>destination</code> will be created if they don't
     * already exist. <code>destination</code> will be overwritten if it already exists.
     *
     * @param source      An existing non-directory <code>File</code> to copy bytes from.
     * @param destination A non-directory <code>File</code> to write bytes to (possibly
     *                    overwriting).
     * @throws IOException                   if <code>source</code> does not exist,
     *                                       <code>destination</code> cannot be written to, or an IO
     *                                       error occurs during copying.
     * @throws java.io.FileNotFoundException if <code>destination</code> is a directory
     *                                       <p/>
     *                                       TO DO: Remove this method when Maven moves to
     *                                       plexus-utils version 1.4
     */
    private void copyFileIfModified(File source, File destination)
            throws IOException {
        // TO DO: Remove this method and use the method in WarFileUtils when Maven 2 changes
        // to plexus-utils 1.2.
        if (destination.lastModified() < source.lastModified()) {
            FileUtils.copyFile(source.getCanonicalFile(), destination);
            // preserve timestamp
            destination.setLastModified(source.lastModified());
        }
    }

}
