/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.general.project.artifact;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.integrationstudio.general.project.Activator;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryCollection;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryDump;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryElement;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryItem;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.manifest.AbstractXMLDoc;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.xml.stream.FactoryConfigurationError;

public abstract class RegistryInfoProvider extends AbstractXMLDoc implements Observer {

    private static final IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private File source;
    private static final String FILE = "file";
    private static final String PATH = "path";
    private static final String MEDIA_TYPE = "mediaType";
    private static final String DIRECTORY = "directory";
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY = "property";
    private static final String KEY = "key";
    private static final String VALUE = "value";
    static final String ITEM = "item";
    static final String COLLECTION = "collection";
    static final String DUMP = "dump";
    static final String EMPTY_STRING = "";

    public void update(Observable o, Object arg) {
    }

    /**
     * Create RegistryItem object from the details in the given OMElement.
     *
     * @param omElement OMElement instance
     * @return RegistryItem instance
     */
    public RegistryItem getRegistryItem(OMElement omElement) {
        RegistryItem item = new RegistryItem();
        item.setFile(getChildElements(omElement, FILE).get(0).getText());
        item.setPath(getChildElements(omElement, PATH).get(0).getText());
        List<OMElement> mediaTypeElements = getChildElements(omElement, MEDIA_TYPE);
        if (!mediaTypeElements.isEmpty()) {
            item.setMediaType(mediaTypeElements.get(0).getText());
        }
        setPropertiesToRegistryElement(omElement, item);
        return item;
    }

    /**
     * Create RegistryCollection object from the details in the given OMElement.
     *
     * @param omElement OMElement instance
     * @return RegistryCollection instance
     */
    public RegistryCollection getRegistryCollection(OMElement omElement) {
        RegistryCollection collection = new RegistryCollection();
        collection.setDirectory(getChildElements(omElement, DIRECTORY).get(0).getText());
        collection.setPath(getChildElements(omElement, PATH).get(0).getText());
        setPropertiesToRegistryElement(omElement, collection);
        return collection;
    }

    /**
     * Create RegistryDump object from the details in the given OMElement.
     *
     * @param omElement OMElement instance
     * @return RegistryDump instance
     */
    public RegistryDump getRegistryDump(OMElement omElement) {
        RegistryDump dump = new RegistryDump();
        dump.setFile(getChildElements(omElement, FILE).get(0).getText());
        dump.setPath(getChildElements(omElement, PATH).get(0).getText());
        return dump;
    }


    /**
     * Set registry resource properties to the given RegistryElement.
     *
     * @param omElement OMElement instance
     * @param element RegistryElement instance
     */
    private void setPropertiesToRegistryElement(OMElement omElement, RegistryElement element) {
        List<OMElement> propertiesElement = getChildElements(omElement, PROPERTIES);
        if (propertiesElement.isEmpty()) {
            return;
        }
        OMElement properties = propertiesElement.get(0);
        List<OMElement> propertyList = getChildElements(properties, PROPERTY);
        for (OMElement property : propertyList) {
            element.addProperty(getAttribute(property, KEY), getAttribute(property, VALUE));
        }
    }

    /**
     * Get the OMElement form of the given RegistryElement object.
     *
     * @param item RegistryElement instance to be converted to an OMElement
     * @return OMElement representation of the RegistryElement object
     */
    OMElement getRegistryElementInfo(RegistryElement item) {
        OMElement element = null;
        if (item instanceof RegistryItem) {
            element = getElement(ITEM, EMPTY_STRING);
            OMElement element2 = getElement(FILE, ((RegistryItem) item).getFile());
            OMElement element3 = getElement(PATH, item.getPath());
            OMElement element4 = getElement(MEDIA_TYPE, ((RegistryItem) item).getMediaType());
            element.addChild(element2);
            element.addChild(element3);
            element.addChild(element4);
        } else if (item instanceof RegistryCollection) {
            element = getElement(COLLECTION, EMPTY_STRING);
            OMElement element2 = getElement(DIRECTORY, ((RegistryCollection) item).getDirectory());
            OMElement element3 = getElement(PATH, item.getPath());
            element.addChild(element2);
            element.addChild(element3);
        } else if (item instanceof RegistryDump) {
            element = getElement(DUMP, EMPTY_STRING);
            OMElement fileElement = getElement(FILE, ((RegistryDump) item).getFile());
            OMElement pathElement = getElement(PATH, item.getPath());
            element.addChild(fileElement);
            element.addChild(pathElement);
        }
        if (element != null) {
            OMElement propertiesElement = getElement(PROPERTIES, EMPTY_STRING);

            Map<String, String> registryPropertyList = item.getProperties();
            for (Map.Entry<String, String> registryProperty : registryPropertyList.entrySet()) {
                OMElement propertyElement = getElement(PROPERTY, EMPTY_STRING);
                addAttribute(propertyElement, KEY, registryProperty.getKey());
                addAttribute(propertyElement, VALUE, registryProperty.getValue());
                propertiesElement.addChild(propertyElement);
            }
            element.addChild(propertiesElement);
        }
        return element;
    }

    protected abstract void deserialize(OMElement documentElement) throws Exception;

    protected String serialize() {
        String result = null;
        OMDocument document = factory.createOMDocument();
        OMElement documentElement = getDocumentElement();
        document.addChild(documentElement);
        try {
            result = getPretifiedString(documentElement);
        } catch (Exception e) {
            log.error("Error occurred while prettifying the OMElement. ", e);
            return null;
        }
        return result;
    }

    protected String getDefaultName() {
        return null;
    }

    public void setSource(File source) {
        this.source = source;
    }

    public File getSource() {
        return source;
    }

    public File toFile() throws Exception {
        return new File(toFile(getSource()).toString());
    }

    public void fromFile(File file) throws FactoryConfigurationError, Exception {
        setSource(file);
        if (getSource().exists()) {
            deserialize(getSource());
        }
    }

    public abstract OMElement getDocumentElement();
}
