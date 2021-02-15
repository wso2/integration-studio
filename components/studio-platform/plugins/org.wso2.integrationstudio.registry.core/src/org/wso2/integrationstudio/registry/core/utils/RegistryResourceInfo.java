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

package org.wso2.integrationstudio.registry.core.utils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.Activator;
import org.wso2.integrationstudio.platform.core.manifest.AbstractXMLDoc;

public class RegistryResourceInfo extends AbstractXMLDoc {
	private String path;
	private int type;
	private File sourceFile;
	private File base;
	private String relativePath;
	private String mediaType;
	private Map<String, String> properties  = new HashMap<>();

	private static final String RESOURCE_TAG_NAME = "item";
	private static final String COLLECTION_TAG_NAME = "collection";
	private static final String DUMP_TAG_NAME = "dump";
	private static final String FILE = "file";
	private static final String PATH = "path";
	private static final String MEDIA_TYPE = "mediaType";
	private static final String DIRECTORY = "directory";
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY = "property";
    private static final String KEY = "key";
    private static final String VALUE = "value";
    static final String EMPTY_STRING = "";

	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public RegistryResourceInfo() {

	}

	public RegistryResourceInfo(String path, File inputFile, int type, File base, String relativePt) {
		setPath(path);
		setType(type);
		setBase(base);
		setRelativePath(relativePt);
		sourceFile = inputFile;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	protected void deserialize(OMElement documentElement) {

		if (documentElement.getLocalName().equals(RESOURCE_TAG_NAME)) {
			setType(Constants.REGISTRY_RESOURCE);
			List<OMElement> childElements = getChildElements(documentElement, FILE);
			if (childElements.size() > 0) {
				setRelativePath(childElements.get(0).getText());
			}

			List<OMElement> childElement = getChildElements(documentElement, MEDIA_TYPE);
			if (childElement.size() > 0) {
				setMediaType(childElements.get(0).getText());
			}
		} else if (documentElement.getLocalName().equals(COLLECTION_TAG_NAME)) {
			setType(Constants.REGISTRY_COLLECTION);
			List<OMElement> childElements = getChildElements(documentElement, DIRECTORY);
			if (childElements.size() > 0) {
				setRelativePath(childElements.get(0).getText());
			}
		} else if (documentElement.getLocalName().equals(DUMP_TAG_NAME)) {
			setType(Constants.REGISTRY_DUMP);
			List<OMElement> childElements = getChildElements(documentElement, FILE);
			if (childElements.size() > 0) {
				setRelativePath(childElements.get(0).getText());
			}
		}
		List<OMElement> childElements = getChildElements(documentElement, PATH);
		if (childElements.size() > 0) {
			setPath(childElements.get(0).getText());
		}
		
		List<OMElement> propertiesElement = getChildElements(documentElement, PROPERTIES);
		if (!propertiesElement.isEmpty()) {
			OMElement properties = propertiesElement.get(0);
			List<OMElement> propertyList = getChildElements(properties, PROPERTY);
			for (OMElement property : propertyList) {
			    addProperty(getAttribute(property, KEY), getAttribute(property, VALUE));
			}
		}
	}

	protected String serialize() {
		OMDocument createOMDocument = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		createOMDocument.addChild(documentElement);
		String pretifiedString;
		try {
			pretifiedString = getPretifiedString(documentElement);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		return pretifiedString;
	}

	private OMElement getDocumentElement() {
		OMElement documentElement;
		// String content = "";
		if (getType() == Constants.REGISTRY_RESOURCE) {
			documentElement = getElement(RESOURCE_TAG_NAME, EMPTY_STRING);
			OMElement fileElement = getElement(FILE, getResourceBaseRelativePath());
			OMElement mediaTypeElement = getElement(MEDIA_TYPE, getMediaType());
			documentElement.addChild(fileElement);
			documentElement.addChild(mediaTypeElement);
			// content = "\t<item>\n\t\t" + "<path>" + getPath()
			// + "</path>\n\t\t" + "<file>" + getResourceBaseRelativePath()
			// + "</file>\n\t" + "</item>";
		} else if (getType() == Constants.REGISTRY_COLLECTION) {
			documentElement = getElement(COLLECTION_TAG_NAME, EMPTY_STRING);
			OMElement fileElement = getElement(DIRECTORY, getResourceBaseRelativePath());
			documentElement.addChild(fileElement);
			// content = "\t<collection>\n\t\t" + "<path>"
			// + getPath() + "</path>\n\t\t"
			// + "<directory>" + getResourceBaseRelativePath()
			// + "</directory>\n\t"
			// + "</collection>\n";

		} else {
			documentElement = getElement(DUMP_TAG_NAME, EMPTY_STRING);
			OMElement fileElement = getElement(FILE, getResourceBaseRelativePath());
			documentElement.addChild(fileElement);
			// content = "\t<item>\n\t\t" + "<path>" + getPath()
			// + "</path>\n\t\t" + "<file>" + getResourceBaseRelativePath()
			// + "</file>\n\t" + "</item>";
		}
		OMElement fileElement = getElement(PATH, getPath());
		documentElement.addChild(fileElement);
		
		OMElement propertiesElement = getElement(PROPERTIES, EMPTY_STRING);

		for (Map.Entry<String, String> property : getProperties().entrySet()) {
			OMElement propertyElement = getElement(PROPERTY, EMPTY_STRING);
			addAttribute(propertyElement, KEY, property.getKey());
			addAttribute(propertyElement, VALUE, property.getValue());
			propertiesElement.addChild(propertyElement);
		}
		documentElement.addChild(propertiesElement);
        
		return documentElement;
	}

	public String getResourceBaseRelativePath() {
		if (sourceFile.equals(getBase())) {
			return getBase().getName();
		}
		return sourceFile.toString().substring(getBase().getPath().length() + 1);
	}

	public String getDeployPath() {
		if (getType() == Constants.REGISTRY_COLLECTION) {
			return getPath().trim();
		} else {
			return getPath().trim().endsWith("/") ? getPath().trim() + getRelativePath() : getPath().trim() + "/" +
			                                                                               getRelativePath();
		}
	}

	protected String getDefaultName() {
		return null;
	}

	public void setBase(File base) {
		this.base = base;
	}

	public File getBase() {
		return base;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaType() {
		return mediaType;
	}
	
	public Map<String, String> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    public void addProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public void removeProperty(String key) {
        this.properties.remove(key);
    }
}
