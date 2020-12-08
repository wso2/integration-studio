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

package org.wso2.developerstudio.eclipse.capp.core.manifest;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CAppArtifactManifest {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private String artifactType;
	private String version;
	private String deployableArtifact;
	private String serverRole;
	private Map<String, OMElement> additionalResources= new HashMap<String, OMElement>();
	private static OMFactory factory = OMAbstractFactory.getOMFactory();

	/**
	 * @return the artifactType
	 */
	public String getArtifactType() {
		return artifactType;
	}

	/**
	 * @param artifactType
	 *            the artifactType to set
	 */
	public void setArtifactType(String artifactType) {
		this.artifactType = artifactType;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the deployableArtifact
	 */
	public String getDeployableArtifact() {
		return deployableArtifact;
	}

	/**
	 * @param deployableArtifact
	 *            the deployableArtifact to set
	 */
	public void setDeployableArtifact(String deployableArtifact) {
		this.deployableArtifact = deployableArtifact;
	}

	/**
	 * @return the serverRole
	 */
	public String getServerRole() {
		return serverRole;
	}

	/**
	 * @param serverRole
	 *            the serverRole to set
	 */
	public void setServerRole(String serverRole) {
		this.serverRole = serverRole;
	}

	/**
	 * @return the additionalResources
	 */
	public Map<String, OMElement> getAdditionalResources() {
		return additionalResources;
	}

	/**
	 * @param additionalResources
	 *            the additionalResources to set
	 */
	public void setAdditionalResources(Map<String, OMElement> additionalResources) {
		this.additionalResources = additionalResources;
	}

	public String toString() {
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = factory.createOMElement(new QName("CappComponent"));
		document.addChild(documentElement);
		documentElement.addChild(getTypeElement());
		documentElement.addChild(getVersionElement());
		documentElement.addChild(getDeployableArtifactElement());
		documentElement.addChild(getDeployedInElement());
		for (OMElement element : additionalResources.values()) {
			documentElement.addChild(element);
		}
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
	        document.serialize(outputStream);
        } catch (XMLStreamException e) {
	        log.error(e);
	        return null;
        }
		return outputStream.toString();
	}

	private OMElement getTypeElement() {
		return getElement("Type", getArtifactType());
	}

	private OMElement getVersionElement() {
		return getElement("Version", getVersion());
	}

	private OMElement getDeployableArtifactElement() {
		return getElement("DeployableArtifact", getDeployableArtifact());
	}

	private OMElement getDeployedInElement() {
		return getElement("DeployedIn", getServerRole());
	}

	private OMElement getElement(String localName, String text) {
		OMElement element = factory.createOMElement(new QName(localName));
		element.setText(text);
		return element;
	}
	    
	/* TODO find any usage, remove if this has not used
	 public static void main (String[] b){
		 CAppArtifactManifest a = new CAppArtifactManifest();
		 a.setArtifactType("mtype");
		 a.setDeployableArtifact("da");
		 a.setServerRole("sr");
		 a.setVersion("1.0.0");
		 System.out.println(a);
	 }
	 */
}
