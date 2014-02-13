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

package org.wso2.maven.registry;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.maven.core.model.AbstractXMLDoc;
import org.wso2.maven.registry.beans.RegistryCollection;
import org.wso2.maven.registry.beans.RegistryElement;
import org.wso2.maven.registry.beans.RegistryItem;

/**
 * This class represents the .artifact.xml file which keeps the metadata of the
 * artifacts included in an ESB project.
 * Structure of the file is as follows.
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <artifacts>
 * 	<artifact name="testEndpoint2" version="1.0.0" type="synapse/endpoint"
 * 			serverRole="EnterpriseServiceBus">
 * 		<file>src\main\synapse-config\endpoints\testEndpoint2.xml</file>
 * 	</artifact>
 * 	<artifact name="testEndpoint3" version="1.0.0" type="synapse/endpoint"
 * 			serverRole="EnterpriseServiceBus">
 * 		<file>src\main\synapse-config\endpoints\testEndpoint3.xml</file>
 * 	</artifact>
 * </artifacts>
 * 
 * Oct 21, 2011
 * 
 */
public class GeneralProjectArtifact extends AbstractXMLDoc implements Observer{
	List<RegistryArtifact> registryArtifacts=new ArrayList<RegistryArtifact>();
	
	private File source;

	public void update(Observable o, Object arg) {
		
	}

	protected void deserialize(OMElement documentElement) throws Exception {
		List<OMElement> artifactElements = getChildElements(documentElement, "artifact");
		for (OMElement omElement : artifactElements) {
	        RegistryArtifact artifact=new RegistryArtifact();
	        artifact.setName(getAttribute(omElement, "name"));
	        artifact.setVersion(getAttribute(omElement, "version"));
	        artifact.setType(getAttribute(omElement, "type"));
	        artifact.setServerRole(getAttribute(omElement, "serverRole"));
	        artifact.setGroupId(getAttribute(omElement, "groupId"));
	        
	        List<OMElement> itemElements = getChildElements(omElement, "item");
	        
	        for (OMElement omElement2 : itemElements) {
	            RegistryItem item=new RegistryItem();
	            item.setFile(getChildElements(omElement2, "file").get(0).getText());
	            item.setPath(getChildElements(omElement2, "path").get(0).getText());
	            List<OMElement> mediaTypeElements = getChildElements(omElement2, "mediaType");
				if(mediaTypeElements.size()>0){
	            	item.setMediaType(mediaTypeElements.get(0).getText());
	            }
	            artifact.addRegistryElement(item);
            }
	        
	        List<OMElement> itemElements1 = getChildElements(omElement, "collection");
	        
	        for (OMElement omElement2 : itemElements1) {
	            RegistryCollection item=new RegistryCollection();
	            item.setDirectory(getChildElements(omElement2, "directory").get(0).getText());
	            item.setPath(getChildElements(omElement2, "path").get(0).getText());
	            artifact.addRegistryElement(item);
            }
	        
	        registryArtifacts.add(artifact);
        }
	}

	protected String serialize() throws Exception {
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
	
	public void addESBArtifact(RegistryArtifact artifact){
		registryArtifacts.add(artifact);
	}
	
	public boolean removeESBArtifact(RegistryArtifact artifact){
		return registryArtifacts.remove(artifact);
	}
	
	public List<RegistryArtifact> getAllESBArtifacts(){
		return Collections.unmodifiableList(registryArtifacts);
	}
	
	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("artifacts", "");
		
		for (RegistryArtifact esbArtifact : registryArtifacts) {
			OMElement artifactElement = getElement("artifact", "");
			
			if (!esbArtifact.isAnonymous()){
				addAttribute(artifactElement, "name", esbArtifact.getName());
			}
			
			if (!esbArtifact.isAnonymous() && esbArtifact.getGroupId() != null) {
				addAttribute(artifactElement, "groupId", esbArtifact.getGroupId());
			}
	        
			if (!esbArtifact.isAnonymous() && esbArtifact.getVersion() != null){
				addAttribute(artifactElement, "version", esbArtifact.getVersion());
			}
			
			if (esbArtifact.getType() != null){
				addAttribute(artifactElement, "type", esbArtifact.getType());
			}
			
			if (esbArtifact.getServerRole() != null){
				addAttribute(artifactElement, "serverRole", esbArtifact.getServerRole());
			}
			

			for (RegistryElement item : esbArtifact.getAllRegistryItems()) {
				if (item instanceof RegistryItem) {
	                OMElement element = getElement("item", "");
	                OMElement element2 = getElement("file", ((RegistryItem)item).getFile());
	                OMElement element3 = getElement("path", item.getPath());
	                OMElement element4 = getElement("mediaType", ((RegistryItem) item).getMediaType());
	                element.addChild(element2);
	                element.addChild(element3);
	                element.addChild(element4);
	                artifactElement.addChild(element);
                }else if(item instanceof RegistryCollection){
                	 OMElement element = getElement("collection", "");
 	                OMElement element2 = getElement("directory", ((RegistryCollection)item).getDirectory());
 	                OMElement element3 = getElement("path", item.getPath());
 	                element.addChild(element2);
 	                element.addChild(element3);
 	                artifactElement.addChild(element);
                }
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
