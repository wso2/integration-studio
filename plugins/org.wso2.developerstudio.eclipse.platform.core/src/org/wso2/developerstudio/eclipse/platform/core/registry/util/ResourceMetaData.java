/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.registry.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.wso2.developerstudio.eclipse.platform.core.MediaManager;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class ResourceMetaData extends AbstractXMLDoc {

	protected String getDefaultName() {
		return null;
	}

	public File createElement(File resourceFile, String checkOutPath, boolean isResource, File metaFolderPath,
	                          boolean overwrite) throws FactoryConfigurationError, Exception {
		File metadataFile;
		if (isResource) {
			metadataFile = new File(metaFolderPath, "~" + resourceFile.getName() + ".xml");
		} else {
			metadataFile = new File(metaFolderPath, "~" + ".xml");
		}
		if (metadataFile.exists() && !overwrite) {
			return metadataFile;
		}
		String mediaType = MediaManager.getMediaType(resourceFile);
		StringBuffer content = new StringBuffer();
		FileOutputStream fos;
		if (isResource) {
			fos = new FileOutputStream(metadataFile);
			// carbon 4.2 format
			content.append("<resource name=");
			content.append("\"" + resourceFile.getName() + "\"");
			content.append(" isCollection=" + "\"false\"");
			content.append(" path=" + "\"" + checkOutPath + "/" + resourceFile.getName() + "\"");
			content.append(" registryUrl=" + "\"" + "https://localhost:9443/registry" + "\"");
			content.append(" status=\"added\">");
			if (mediaType != null && !mediaType.trim().isEmpty() /*
																  * cannot use
																  * apache
																  * commons-lang
																  * from here
																  */) {
				content.append("<mediaType>" + mediaType + "</mediaType>");
			}
			content.append("</resource>");
		} else {
			fos = new FileOutputStream(metadataFile);
			content.append("<resource name=");
			content.append("\"" + resourceFile.getName() + "\"");
			content.append(" isCollection=" + "\"true\"");
			content.append(" path=" + "\"" + checkOutPath + "\"");
			content.append(" registryUrl=" + "\"" + "https://localhost:9443/registry" + "\"");
			content.append(" status=\"added\"/>");
		}

		XMLStreamReader parser =
		                         XMLInputFactory.newInstance()
		                                        .createXMLStreamReader(new ByteArrayInputStream(content.toString()
		                                                                                               .getBytes()));
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement = builder.getDocumentElement();
		prettify(documentElement, fos);
		return metadataFile;
	}

	protected void deserialize(OMElement documentElement) {
		// TODO
	}

	protected String serialize() {
		// TODO refactor this class
		return null;
	}

}
