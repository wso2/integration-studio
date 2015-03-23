/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.maven.plugin.synapse.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.commons.io.IOUtils;
import org.apache.maven.project.MavenProject;
import org.wso2.maven.capp.model.CAppArtifactDependency;
import org.wso2.maven.core.utils.MavenUtils;

/**
 * An abstract implementation of {@link SynapseDependentArtifactExporter}.
 */
public abstract class AbstractSynapseDependentArtifactExporter implements SynapseDependentArtifactExporter {
	/**
	 * {@inheritDoc}
	 */
	public CAppArtifactDependency export(OMElement artifactDefinition, CAppArtifactDependency synapseArtifactClone, File workDir)
			throws Exception {
		// Create the temporary directory.
		workDir.mkdirs();
		// Serialize the sequence definition.
		String artifactName = getArtifactName(artifactDefinition);		
		File artifactContentFile = new File(workDir, String.format("%s.xml", artifactName));
		FileOutputStream fos = null;		
		try {			
			fos = new FileOutputStream(artifactContentFile);
			OMFactory omFactory = OMAbstractFactory.getOMFactory();
			OMDocument omDocument = omFactory.createOMDocument();
			omDocument.addChild(artifactDefinition);			
			omDocument.serialize(fos);
		} finally {
			IOUtils.closeQuietly(fos);
		}		
		
		// Create the sequence artifact.
		MavenProject dummyMavenProject = MavenUtils.createMavenProject(synapseArtifactClone.getcAppArtifact().getProject().getGroupId(), artifactName, synapseArtifactClone.getVersion(), getArtifactType());
		CAppArtifactDependency cAppArtifactDependency = new CAppArtifactDependency(dummyMavenProject, getArtifactType(), synapseArtifactClone.getServerRole());
		cAppArtifactDependency.setDummyDependency(true);
		cAppArtifactDependency.setArtifactFiles(new File[]{artifactContentFile});
		cAppArtifactDependency.getcAppArtifact().setFile(artifactContentFile.getName());
		return cAppArtifactDependency;
	}
	
	/**
	 * Determines the name of the artifact which is to be exported.
	 * 
	 * @param artifactDefinition serialized form of the artifact.
	 * @return artifact name.
	 */
	protected abstract String getArtifactName(OMElement artifactDefinition);
	
	/**
	 * Determines the type of the artifact to be exported.
	 * 
	 * @return artifact type identifier string.
	 */
	protected abstract String getArtifactType();
	
}
