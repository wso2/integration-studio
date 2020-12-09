/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.dataserviceProject.artifact;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

/**
 * This class represents the .artifact.xml file which keeps the metadata of the
 * artifacts included in an DSS project. Structure of the file is as follows.
 * 
 * <?xml version="1.0" encoding="UTF-8"?> <artifacts> <artifact
 * name="testDataService_1" version="1.0.0" type="service/dataservice"
 * serverRole="DataServicesServer" groupId="org.wso2.carbon.myapp">
 * <file>src\main\dataservice\testDataService_1.dbs</file> </artifact> <artifact
 * name="testDataService_2" version="1.0.0" type="service/dataservice"
 * serverRole="DataServicesServer" groupId="org.wso2.carbon.myapp">
 * <file>src\main\dataservice\testDataService_2.dbs</file> </artifact>
 * </artifacts>
 * 
 */
public class DSSProjectArtifact extends AbstractXMLDoc implements Observer {
	List<DSSArtifact> dssArtifacts = new ArrayList<DSSArtifact>();

	private static final String NAME = "name";
	private static final String VERSION = "version";
	private static final String TYPE = "type";
	private static final String SERVER_ROLE = "serverRole";
	private static final String GROUP_ID = "groupId";
	private static final String FILE = "file";
	private static final String ARTIFACTS = "artifacts";
	private static final String ARTIFACT = "artifact";

	private File source;

	public void update(Observable o, Object arg) {

	}

	protected void deserialize(OMElement documentElement) {
		List<OMElement> artifactElements = getChildElements(documentElement, ARTIFACT);
		for (OMElement omElement : artifactElements) {
			DSSArtifact artifact = new DSSArtifact();
			artifact.setName(getAttribute(omElement, NAME));
			artifact.setVersion(getAttribute(omElement, VERSION));
			artifact.setType(getAttribute(omElement, TYPE));
			artifact.setServerRole(getAttribute(omElement, SERVER_ROLE));
			artifact.setGroupId(getAttribute(omElement, GROUP_ID));
			artifact.setFile(getChildElements(omElement, FILE).size() > 0 ? getChildElements(
					omElement, FILE).get(0).getText() : null);

			dssArtifacts.add(artifact);
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

	public void addDSSArtifact(DSSArtifact artifact) {
		dssArtifacts.add(artifact);
	}

	public boolean removeDSSArtifact(DSSArtifact artifact) {
		return dssArtifacts.remove(artifact);
	}

	public List<DSSArtifact> getAllDSSArtifacts() {
		return Collections.unmodifiableList(dssArtifacts);
	}

	public OMElement getDocumentElement() {
		OMElement documentElement = getElement(ARTIFACTS, "");

		for (DSSArtifact dssArtifact : dssArtifacts) {
			OMElement artifactElement = getElement(ARTIFACT, "");

			if (!dssArtifact.isAnonymous()) {
				addAttribute(artifactElement, NAME, dssArtifact.getName());
			}

			if (!dssArtifact.isAnonymous() && dssArtifact.getGroupId() != null) {
				addAttribute(artifactElement, GROUP_ID, dssArtifact.getGroupId());
			}

			if (!dssArtifact.isAnonymous() && dssArtifact.getVersion() != null) {
				addAttribute(artifactElement, VERSION, dssArtifact.getVersion());
			}

			if (dssArtifact.getType() != null) {
				addAttribute(artifactElement, TYPE, dssArtifact.getType());
			}

			if (dssArtifact.getServerRole() != null) {
				addAttribute(artifactElement, SERVER_ROLE, dssArtifact.getServerRole());
			}

			if (dssArtifact.getFile() != null) {
				artifactElement.addChild(getElement(FILE, dssArtifact.getFile()));
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

	public File toFile() throws Exception {
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
