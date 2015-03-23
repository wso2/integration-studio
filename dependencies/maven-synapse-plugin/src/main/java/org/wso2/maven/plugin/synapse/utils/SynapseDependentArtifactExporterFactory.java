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

import java.util.HashMap;
import java.util.Map;

import org.apache.axiom.om.OMElement;

/**
 * A singleton factory for creating {@link SynapseDependentArtifactExporter}
 * instances.
 */
public class SynapseDependentArtifactExporterFactory {
	/**
	 * Singleton factory.
	 */
	private static SynapseDependentArtifactExporterFactory singleton;
	
	/**
	 * A map of {@link OMElement} local name to corresponding {@link SynapseDependentArtifactExporter} instances.
	 */
	private Map<String, SynapseDependentArtifactExporter> localNameToExportersMap;
	
	/**
	 * Private constructor.
	 */
	private SynapseDependentArtifactExporterFactory() {
		localNameToExportersMap = new HashMap<String, SynapseDependentArtifactExporter>();
		
		// Initialize exporters.
		localNameToExportersMap.put("sequence", new SequenceArtifactExporter());
		localNameToExportersMap.put("endpoint", new EndPointArtifactExporter());
		localNameToExportersMap.put("localEntry", new LocalEntryArtifactExporter());
		localNameToExportersMap.put("proxy", new ProxyServiceArtifactExporter());
	}		
	
	/**
	 * @return singleton factory instance.
	 */
	public static final SynapseDependentArtifactExporterFactory getInstance() {
		if (null == singleton) {
			singleton = new SynapseDependentArtifactExporterFactory();
		}
		
		return singleton;
	}
	
	/**
	 * Returns the {@link SynapseDependentArtifactExporter} corresponding to the
	 * specified local name.
	 * 
	 * @param localName
	 *            local name of the {@link OMElement} which represents the
	 *            serialized form of dependent artifact.
	 * @return {@link SynapseDependentArtifactExporter} corresponding to the
	 *         specified local name or null if no exporter is found.
	 */
	public SynapseDependentArtifactExporter getExporter(String localName) {
		return localNameToExportersMap.get(localName);
	}
}
