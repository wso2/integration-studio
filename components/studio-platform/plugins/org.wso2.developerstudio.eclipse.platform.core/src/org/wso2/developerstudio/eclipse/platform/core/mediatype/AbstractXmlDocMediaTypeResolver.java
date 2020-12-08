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

package org.wso2.developerstudio.eclipse.platform.core.mediatype;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeFromStreamResolver;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public abstract class AbstractXmlDocMediaTypeResolver implements IMediaTypeFromStreamResolver {

	public AbstractXmlDocMediaTypeResolver() {
		super();
	}

	protected boolean isDocumentTag(InputStream dataStream, String tagName) throws FactoryConfigurationError {
		try {
			String content = FileUtils.getContentAsString(dataStream);
			if (content != null) {
				content = content.toLowerCase();
				if (content.contains("<html") && content.contains("</html>")) {
					if (tagName.equals("html")) {
						return true;
					}
				}
				dataStream = new ByteArrayInputStream(content.getBytes());
			}
			OMElement documentElement = getXmlDoc(dataStream);
			String localName = documentElement.getLocalName();
			return localName.equalsIgnoreCase(tagName);
		} catch (Exception e) {
			return false;
		}
	}

	protected OMElement getXmlDoc(InputStream dataStream) throws XMLStreamException, FactoryConfigurationError {
		XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(dataStream);
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement = builder.getDocumentElement();
		return documentElement;
	}

}