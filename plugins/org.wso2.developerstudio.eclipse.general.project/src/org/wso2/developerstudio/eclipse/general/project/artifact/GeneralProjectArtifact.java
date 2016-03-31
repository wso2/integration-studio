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

package org.wso2.developerstudio.eclipse.general.project.artifact;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.general.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryCollection;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryDump;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

/**
 * This class represents the .artifact.xml file which keeps the metadata of the
 * artifacts included in an registry resource project.
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
public class GeneralProjectArtifact extends AbstractXMLDoc implements Observer{
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	List<RegistryArtifact> registryArtifacts=new ArrayList<RegistryArtifact>();
	
	private File source;

	public void update(Observable o, Object arg) {
		
	}

	protected void deserialize(OMElement documentElement) {
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
	            List<OMElement> mediatypeElements = getChildElements(omElement2, "mediaType");
	            if(mediatypeElements.size()>0){
	            	item.setMediaType(mediatypeElements.get(0).getText());
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
	        
	        List<OMElement> dumpElements = getChildElements(omElement, "dump");
	        
	        for (OMElement dumpElement : dumpElements) {
	            RegistryDump item=new RegistryDump();
	            item.setFile(getChildElements(dumpElement, "file").get(0).getText());
	            item.setPath(getChildElements(dumpElement, "path").get(0).getText());
	            artifact.addRegistryElement(item);
            }
	        
	        registryArtifacts.add(artifact);
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
			log.error("cannot serialize document", e);
			return null;
		}
		return result;
	}

	protected String getDefaultName() {
		return null;
	}
	
	public void addArtifact(RegistryArtifact artifact){
		registryArtifacts.add(artifact);
	}
	
	public boolean removeArtifact(RegistryArtifact artifact){
		return registryArtifacts.remove(artifact);
	}
	
	public List<RegistryArtifact> getAllArtifacts(){
		return Collections.unmodifiableList(registryArtifacts);
	}
	
	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("artifacts", "");
		
		for (RegistryArtifact artifact : registryArtifacts) {
			OMElement artifactElement = getElement("artifact", "");
			
			if (!artifact.isAnonymous()){
				addAttribute(artifactElement, "name", artifact.getName());
			}
			
			if (!artifact.isAnonymous() && artifact.getGroupId() != null) {
				addAttribute(artifactElement, "groupId", artifact.getGroupId());
			}
	        
			if (!artifact.isAnonymous() && artifact.getVersion() != null){
				addAttribute(artifactElement, "version", artifact.getVersion());
			}
			
			if (artifact.getType() != null){
				addAttribute(artifactElement, "type", artifact.getType());
			}
			
			if (artifact.getServerRole() != null){
				addAttribute(artifactElement, "serverRole", artifact.getServerRole());
			}
			

			for (RegistryElement item : artifact.getAllRegistryItems()) {
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
                } else if (item instanceof RegistryDump) {
	                OMElement element = getElement("dump", "");
	                OMElement fileElement = getElement("file", ((RegistryDump)item).getFile());
	                OMElement pathElement = getElement("path", item.getPath());
	                element.addChild(fileElement);
	                element.addChild(pathElement);
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
