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
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.io.IOUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.maven.capp.model.CAppArtifactDependency;

/**
 * A specialization of {@link ArtifactBundleCreator} used to explode synapse
 * configuration artifacts into multiple artifacts at car generation.
 */
public class SynapseArtifactBundleCreator{
	/**
	 * Dependent artifact exporter factory.
	 */
	private SynapseDependentArtifactExporterFactory exporterFactory;
	
	private CAppArtifactDependency artifact;
	
	/**
	 * Creates a new {@link SynapseArtifactBundleCreator} instance.
	 * 
	 * @param artifact
	 *            synapse configuration artifact.
	 * @param location
	 *            parent directory which contains the synapse artifact.
	 * @param parentApplication
	 */
	public SynapseArtifactBundleCreator(CAppArtifactDependency artifact) {
		setArtifact(artifact);
		exporterFactory = SynapseDependentArtifactExporterFactory.getInstance();
	}

	/**
	 * Exports any dependent artifacts that can be extracted from this synapse
	 * configuration artifacts.
	 * 
	 * @param synapseXmlFile
	 *            synapse.xml file.
	 * @param synapseArtifactClone
	 *            clone of the original synapse artifact.
	 * @param targetDir
	 *            location where dependent artifacts are to be exported.
	 * @throws Exception
	 *             if an error is encountered while performing the explode
	 *             operation.
	 */
	public List<CAppArtifactDependency> exportDependentArtifacts(File synapseXmlFile, CAppArtifactDependency synapseArtifactClone)
			throws Exception {
		FileInputStream fis = null;
		List<CAppArtifactDependency> list=new ArrayList<CAppArtifactDependency>();
		try {
			// Parse the synapse.xml file into an OMDocument.
			fis = new FileInputStream(synapseXmlFile);
			StAXOMBuilder builder = new StAXOMBuilder(fis);
			OMElement documentElement = builder.getDocumentElement();
			documentElement.build();

			// Iterate through all the top level elements looking for sub
			// artifacts that can be extracted.
			Iterator<?> iter = documentElement.getChildElements();
			while (iter.hasNext()) {
				OMElement childElement = (OMElement) iter.next();
				SynapseDependentArtifactExporter exporter = exporterFactory.getExporter(childElement.getLocalName());
				if (null != exporter) {
					// Create a working directory only if we have at least one
					// exporter.
					File workDir = FileUtils.createTempDirectory();
					try {
						CAppArtifactDependency dependency = exporter.export(childElement, synapseArtifactClone, workDir);
						if (dependency!=null) {
							list.add(dependency);
						}
					} catch (Exception ex) {
					}
				}
			}
		} finally {
			// Close file input stream.
			IOUtils.closeQuietly(fis);
		}
		return list;
	}

	public void setArtifact(CAppArtifactDependency artifact) {
		this.artifact = artifact;
	}

	public CAppArtifactDependency getArtifact() {
		return artifact;
	}

}
