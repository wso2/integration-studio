/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.cep.utils;

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
 * artifacts included in an CEP project.
 * Structure of the file is as follows.
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <artifacts>
 * 	<artifact name="testEndpoint2" version="1.0.0" type="synapse/endpoint"
 * 			serverRole="EnterpriseServiceBus"
 * 			groupId="org.wso2.carbon.myapp">
 * 		<file>src\main\synapse-config\endpoints\testEndpoint2.xml</file>
 * 	</artifact>
 * 	<artifact name="testEndpoint3" version="1.0.0" type="synapse/endpoint"
 * 			serverRole="EnterpriseServiceBus"
 * 			groupId="org.wso2.carbon.myapp">
 * 		<file>src\main\synapse-config\endpoints\testEndpoint3.xml</file>
 * 	</artifact>
 * </artifacts>
 * 
 * Oct 21, 2011
 * 
 */
public class CEPProjectArtifact extends AbstractXMLDoc implements Observer{
	List<CEPArtifact> cepArtifacts=new ArrayList<CEPArtifact>();
	
	private File source;

	public void update(Observable o, Object arg) {
		
	}

	protected void deserialize(OMElement documentElement) {
		List<OMElement> artifactElements = getChildElements(documentElement, "artifact");
		for (OMElement omElement : artifactElements) {
	        CEPArtifact artifact=new CEPArtifact();
	        artifact.setName(getAttribute(omElement, "name"));
	        artifact.setVersion(getAttribute(omElement, "version"));
	        artifact.setType(getAttribute(omElement, "type"));
	        artifact.setServerRole(getAttribute(omElement, "serverRole"));
	        artifact.setGroupId(getAttribute(omElement, "groupId"));
	        artifact.setFile(getChildElements(omElement, "file").size()>0?getChildElements(omElement, "file").get(0).getText():null);
	        
	        cepArtifacts.add(artifact);
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
	
	public void addCEPArtifact(CEPArtifact artifact){
		cepArtifacts.add(artifact);
	}
	
	public boolean removeCEPArtifact(CEPArtifact artifact){
		return cepArtifacts.remove(artifact);
	}
	
	public List<CEPArtifact> getAllCEPArtifacts(){
		return Collections.unmodifiableList(cepArtifacts);
	}
	
	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("artifacts", "");
		
		for (CEPArtifact cepArtifact : cepArtifacts) {
			OMElement artifactElement = getElement("artifact", "");
			
			if (!cepArtifact.isAnonymous()){
				addAttribute(artifactElement, "name", cepArtifact.getName());
			}
			
			if (!cepArtifact.isAnonymous() && cepArtifact.getGroupId() != null){
				addAttribute(artifactElement, "groupId", cepArtifact.getGroupId());
			}
	        
			if (!cepArtifact.isAnonymous() && cepArtifact.getVersion() != null){
				addAttribute(artifactElement, "version", cepArtifact.getVersion());
			}
			
			if (cepArtifact.getType() != null){
				addAttribute(artifactElement, "type", cepArtifact.getType());
			}
			
			if (cepArtifact.getServerRole() != null){
				addAttribute(artifactElement, "serverRole", cepArtifact.getServerRole());
			}
			
			if (cepArtifact.getFile() != null){
				artifactElement.addChild(getElement("file", cepArtifact.getFile()));
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

	public void fromFile(File file) throws FactoryConfigurationError, Exception{
		setSource(file);
		if (getSource().exists()){
    		deserialize(getSource());
		}
	}

}
