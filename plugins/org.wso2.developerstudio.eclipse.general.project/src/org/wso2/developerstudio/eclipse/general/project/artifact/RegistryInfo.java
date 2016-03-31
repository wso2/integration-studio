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

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryCollection;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.stream.FactoryConfigurationError;

/**
 * <resources>
    <item>
        <file>AdminService.wsdl</file>
        <path>/_system/config/repository/wso2con/wsdl</path>
    </item>
        <item>
        <file>AdminService.wsdl</file>
        <path>/_system/config/repository/wso2con/wsdl</path>
    </item>
        <item>
        <file>AdminService.wsdl</file>
        <path>/_system/config/repository/wso2con/wsdl</path>
    </item>
</resources>
 * Oct 28, 2011
 *
 */
public class RegistryInfo extends AbstractXMLDoc implements Observer{
	
	List<RegistryElement> registryArtifacts=new ArrayList<RegistryElement>();
	
	private File source;

	public void update(Observable o, Object arg) {
	}

	protected void deserialize(OMElement documentElement) {
		List<OMElement> artifactElements = getChildElements(documentElement, "item");

		for (OMElement omElement : artifactElements) {
			RegistryItem item = new RegistryItem();
			item.setFile(getChildElements(omElement, "file").get(0).getText());
			item.setPath(getChildElements(omElement, "path").get(0).getText());
			registryArtifacts.add(item);
		}

		List<OMElement> itemElements1 = getChildElements(documentElement, "collection");

		for (OMElement omElement2 : itemElements1) {
			RegistryCollection item = new RegistryCollection();
			item.setDirectory(getChildElements(omElement2, "directory").get(0).getText());
			item.setPath(getChildElements(omElement2, "path").get(0).getText());
			registryArtifacts.add(item);
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
	
	public void addESBArtifact(RegistryItem artifact){
		registryArtifacts.add(artifact);
	}
	
	public boolean removeESBArtifact(RegistryArtifact artifact){
		return registryArtifacts.remove(artifact);
	}
	
	public List<RegistryElement> getAllESBArtifacts(){
		return Collections.unmodifiableList(registryArtifacts);
	}
	
	public OMElement getDocumentElement() {
		OMElement documentElement = getElement("resources", "");
		
//		for (RegistryElement esbArtifact : registryArtifacts) {
//				OMElement element = getElement("item", "");
//				
//				OMElement element2 = getElement("file", esbArtifact.getFile());
//				OMElement element3 = getElement("path", esbArtifact.getPath());
//
//				element.addChild(element2);
//				element.addChild(element3);
//
//				documentElement.addChild(element);
//        }
		
		for (RegistryElement item : registryArtifacts) {
			if (item instanceof RegistryItem) {
                OMElement element = getElement("item", "");
                OMElement element2 = getElement("file", ((RegistryItem)item).getFile());
                OMElement element3 = getElement("path", item.getPath());
                element.addChild(element2);
                element.addChild(element3);
                documentElement.addChild(element);
            }else if(item instanceof RegistryCollection){
            	 OMElement element = getElement("collection", "");
	                OMElement element2 = getElement("directory", ((RegistryCollection)item).getDirectory());
	                OMElement element3 = getElement("path", item.getPath());
	                element.addChild(element2);
	                element.addChild(element3);
	                documentElement.addChild(element);
            }
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
