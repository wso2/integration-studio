/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.apache.maven.scm.ScmException;
import org.apache.maven.scm.ScmFile;
import org.apache.maven.scm.ScmFileSet;
import org.apache.maven.scm.command.checkout.CheckOutScmResult;
import org.apache.maven.scm.manager.BasicScmManager;
import org.apache.maven.scm.manager.NoSuchScmProviderException;
import org.apache.maven.scm.manager.ScmManager;
import org.apache.maven.scm.provider.svn.svnexe.SvnExeScmProvider;
import org.apache.maven.scm.repository.ScmRepository;
import org.apache.maven.scm.repository.ScmRepositoryException;
import org.wso2.maven.esb.ESBArtifact;
import org.wso2.maven.esb.ESBProjectArtifact;

/**
 * This is the Maven Mojo used for do post prepare tasks such as update version
 * of artifacts in Artifact.xml etc.
 * 
 * @goal post-prepare
 * 
 */
public class MavenReleasePostPrepareMojo extends AbstractMojo {

	private static final String DEPENDENCY = "dependency.";
	private static final String ARTIFACT_XML_REGEX = "**/artifact.xml";
	private static final String DEVELOPMENT = "development";
	private static final String RELEASE = "release";
	private static final String SCM = "scm:";
	private static final String SCM_URL = "scm.url";
	private static final String SCM_TAG_BASE = "scm.tagBase";
	private static final String SCM_TAG = "scm.tag";
	private static final String POM = "pom";
	private static final String RELEASE_PROPERTIES = "release.properties";
	private static final String ARTIFACT_XML = "artifact.xml";
	private final Log log = getLog();

	/**
	 * @parameter default-value="${project}"
	 */
	private MavenProject project;
	
	/**
	 * @parameter expression="${dryRun}" default-value="false"
	 */
	private boolean dryRun;
	

	private File artifactLocation;

	public File getArtifactLocation() {
		return artifactLocation;
	}

	public void setArtifactLocation(File artifactLocation) {
		this.artifactLocation = artifactLocation;
	}

	public void execute() throws MojoExecutionException, MojoFailureException {
		
		if(dryRun){
			log.warn(" **** wso2-relase-pre-prepare-plugin does not support for dryRun mode **** ");
			return;
		}

		Properties prop = new Properties();
		String baseDirPath = project.getBasedir().getPath();
		File artifactXml = new File(baseDirPath, ARTIFACT_XML);
		String packagingType = project.getPackaging();

		if (!artifactXml.exists() && packagingType.equals(POM)) {
			InputStream input = null;
			try {
				input = new FileInputStream(new File(baseDirPath, RELEASE_PROPERTIES));
				prop.load(input);
				String scmTag = prop.getProperty(SCM_TAG);
				String scmTagBase = prop.getProperty(SCM_TAG_BASE);
				String scmUrl = prop.getProperty(SCM_URL);
				if (scmUrl == null) {
					scmUrl = project.getScm().getConnection();
				}	
				ScmManager scmManager = new BasicScmManager();
				String scmProvider = scmUrl.split(":")[1];
				scmManager.setScmProvider(scmProvider, new SvnExeScmProvider());
				String checkoutUrl = SCM + scmProvider + ":"
						+ scmTagBase.replaceAll("/$", "").concat("/").concat(scmTag);
				checkoutAndCommit(scmManager, prop, scmProvider, checkoutUrl, RELEASE);
				scmTagBase = project.getScm().getConnection();
				checkoutAndCommit(scmManager, prop, scmProvider, scmTagBase, DEVELOPMENT);
				
				ScmFileSet scmFileSet = new ScmFileSet(new File(baseDirPath), ARTIFACT_XML_REGEX, null);	
				ScmRepository scmRepository = scmManager.makeScmRepository(scmUrl);
				scmManager.update(scmRepository, scmFileSet);
				
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new MojoExecutionException(e.getMessage(), e);
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		}
	}

	private void checkoutAndCommit(ScmManager scmManager, Properties prop, String scmProvider, String checkoutUrl, String repoType)
			throws ScmRepositoryException, NoSuchScmProviderException, IOException, ScmException,
			FactoryConfigurationError, Exception {

		ScmRepository scmRepository = scmManager.makeScmRepository(checkoutUrl);
		String scmBaseDir = project.getBuild().getDirectory();
		File targetFile = new File(scmBaseDir, repoType);
		targetFile.mkdirs();
		ScmFileSet scmFileSet = new ScmFileSet(targetFile, ARTIFACT_XML_REGEX, null);
		CheckOutScmResult checkOut = scmManager.checkOut(scmRepository, scmFileSet);
		List<ScmFile> checkedOutFiles = checkOut.getCheckedOutFiles();

		for (ScmFile scmFile : checkedOutFiles) {
			String scmFilePath = scmFile.getPath();
			if (scmFilePath.contains(ARTIFACT_XML)) {
				File modifiedArtifactXml = new File(scmBaseDir, scmFilePath);
				ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
				esbProjectArtifact.fromFile(modifiedArtifactXml);
				for (ESBArtifact esbArtifact : esbProjectArtifact.getAllESBArtifacts()) {
					if (esbArtifact.getVersion() != null && esbArtifact.getType() != null) {
						String releaseVersion = prop.getProperty(DEPENDENCY + esbArtifact.getGroupId() + ":"
								+ esbArtifact.getName() + "." + repoType);
						if (releaseVersion != null) {
							esbArtifact.setVersion(releaseVersion);
						}
					}
				}
				esbProjectArtifact.toFile();
			}
		}
		ScmFileSet scmCheckInFileSet = new ScmFileSet(new File(scmBaseDir), ARTIFACT_XML_REGEX, null);
		scmManager.checkIn(scmRepository, scmCheckInFileSet, "  commited modified artifact.xml file ... ");
	}
}
