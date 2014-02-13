/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.registry.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.wso2.carbon.registry.synchronization.Utils;
import org.wso2.developerstudio.eclipse.platform.core.MediaManager;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class ResourceMetaData extends AbstractXMLDoc{

	protected String getDefaultName() {
		return null;
	}
	
	public File createElement(File resourceFile, String checkOutPath, boolean isResource, File metaFolderPath, boolean overwrite) 
														throws FactoryConfigurationError, Exception{
		File metadataFile;
		if(isResource){
			metadataFile = new File(metaFolderPath, "~" + resourceFile.getName() + ".xml");
		}else{
			metadataFile = new File(metaFolderPath, "~" + ".xml");
		}
		if (metadataFile.exists() && !overwrite){
			return metadataFile;
		}
		String mediaType = MediaManager.getMediaType(resourceFile);
		String content = "";
		FileOutputStream fos;		
		if(isResource){
			String md5 = Utils.getMD5(Utils.getBytesFromFile(resourceFile));
			fos = new FileOutputStream(metadataFile);
			content = "<resource name=" +
						"\"" + resourceFile.getName() + "\"" +
						" isCollection=" + "\"" + !isResource + "\"" + 
						" path=" + "\"" + checkOutPath + "/" + resourceFile.getName() + "\"" +
						" registryUrl=" + "\"" + "https://localhost:9443/registry" + "\"" +
						" md5=" + "\"" + md5 + "\">" + 
						"<mediaType>" + mediaType + "</mediaType>" + 
						"<version>1844</version>" + 
						"<creator>admin</creator>" + 
						"<createdTime>" + System.currentTimeMillis() + "</createdTime>" + 
						"<lastUpdater>admin</lastUpdater>" + 
						"<lastModified>" + System.currentTimeMillis() + "</lastModified> " + 
						"<registryState>" + RegistryResourceUtils.RegistryState.ADDED + "</registryState>" + 
						"<description>" + "" + "</description>" + 
						"</resource>";
		}else{
			fos = new FileOutputStream(metadataFile);
			content = "<resource name=" +
						"\"" + resourceFile.getName() + "\"" +
						" isCollection=" + "\"" + !isResource + "\"" + 
						" path=" + "\"" + checkOutPath + "\"" +
						" registryUrl=" + "\"" + "https://localhost:9443/registry" + "\">" +
						"<mediaType>" + "" + "</mediaType>" + 
						"<version>1844</version>" + 
						"<creator>admin</creator>" + 
						"<createdTime>" + System.currentTimeMillis() + "</createdTime>" + 
						"<lastUpdater>admin</lastUpdater>" + 
						"<lastModified>" + System.currentTimeMillis() + "</lastModified> " + 
						"<registryState>" + RegistryResourceUtils.RegistryState.ADDED + "</registryState>" + 
						"<description>" + "" + "</description>"+ 
						"</resource>";
		}

		XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(new ByteArrayInputStream(content.getBytes()));
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement = builder.getDocumentElement();
		prettify(documentElement, fos);
		return metadataFile;
	}
	
    protected void deserialize(OMElement documentElement) {
	   //TODO 
    }

    protected String serialize() {
    	//TODO refactor this class
	    return null;
    }

}
