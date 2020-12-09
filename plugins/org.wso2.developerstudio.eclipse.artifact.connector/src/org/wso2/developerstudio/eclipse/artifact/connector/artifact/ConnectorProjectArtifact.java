/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.connector.artifact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;
/**
 * This class represents the .artifact.xml file which keeps the metadata of the artifacts included in an ESB project.
 * Structure of the file is as follows.
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <artifacts> 
 *   <artifact name="confluence-connector" groupId="com.example.connector" version="1.0.0" type="synapse/lib" 
 *   serverRole="EnterpriseServiceBus">
 *     <file>confluence-connector-1.0.0.zip</file>
 *   </artifact>
 *   <artifact name="wordpress-connector" groupId="com.example.connector" version="1.0.0" type="synapse/lib"
 *   serverRole="EnterpriseServiceBus">
 *     <file>wordpress-connector-1.0.0.zip</file>
 *   </artifact>
 * </artifacts>
 * 
 */
public class ConnectorProjectArtifact extends AbstractXMLDoc implements Observer {
	List<ConnectorArtifact> esbArtifacts = new ArrayList<ConnectorArtifact>();
	private File source;
	
	public void update(Observable o, Object arg) {

	}

	protected void deserialize(OMElement documentElement) {
		List<OMElement> artifactElements = getChildElements(documentElement, "artifact");
		for (OMElement omElement : artifactElements) {
			ConnectorArtifact artifact = new ConnectorArtifact();
			artifact.setName(getAttribute(omElement, "name"));
			artifact.setVersion(getAttribute(omElement, "version"));
			artifact.setType(getAttribute(omElement, "type"));
			artifact.setServerRole(getAttribute(omElement, "serverRole"));
			artifact.setGroupId(getAttribute(omElement, "groupId"));
			artifact.setFile(getChildElements(omElement, "file").size() > 0 ? getChildElements(omElement, "file")
					.get(0).getText() : null);

			esbArtifacts.add(artifact);
		}
	}

	protected String serialize() {
		String result = null;
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		document.addChild(documentElement);
		try {
			result = getPretifiedString(documentElement);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	protected String getDefaultName() {
		return null;
	}

	public void addESBArtifact(ConnectorArtifact artifact) {
		esbArtifacts.add(artifact);
	}

	public boolean removeESBArtifact(ConnectorArtifact artifact) {
		return esbArtifacts.remove(artifact);
	}

	public List<ConnectorArtifact> getAllESBArtifacts() {
		return Collections.unmodifiableList(esbArtifacts);
	}

	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("artifacts", "");

		for (ConnectorArtifact esbArtifact : esbArtifacts) {
			OMElement artifactElement = getElement("artifact", "");

			if (!esbArtifact.isAnonymous()) {
				addAttribute(artifactElement, "name", esbArtifact.getName());
			}

			if (!esbArtifact.isAnonymous() && esbArtifact.getGroupId() != null) {
				addAttribute(artifactElement, "groupId", esbArtifact.getGroupId());
			}

			if (!esbArtifact.isAnonymous() && esbArtifact.getVersion() != null) {
				addAttribute(artifactElement, "version", esbArtifact.getVersion());
			}

			if (esbArtifact.getType() != null) {
				addAttribute(artifactElement, "type", esbArtifact.getType());
			}

			if (esbArtifact.getServerRole() != null) {
				addAttribute(artifactElement, "serverRole", esbArtifact.getServerRole());
			}

			if (esbArtifact.getFile() != null) {
				artifactElement.addChild(getElement("file", esbArtifact.getFile()));
			}

			documentElement.addChild(artifactElement);
		}

		return documentElement;
	}

	public void setSource(File source) {
		this.source = source;
	}

	public File getSource() {
		return source;
	}

	public File toFile() throws IOException {
		File savedFile = new File(toFile(getSource()).toString());
		return savedFile;
	}

	public void fromFile(File file) throws FactoryConfigurationError, Exception {
		setSource(file);
		if (getSource().exists()) {
			deserialize(getSource());
		}
	}

}
