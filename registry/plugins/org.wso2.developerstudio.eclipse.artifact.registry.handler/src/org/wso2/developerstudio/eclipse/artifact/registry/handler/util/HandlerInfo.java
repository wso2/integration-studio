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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.Activator;
import org.wso2.developerstudio.eclipse.capp.core.manifest.AbstractXMLDoc;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class HandlerInfo extends AbstractXMLDoc {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private String handlerClass;
	private String filterClass;
	private List<String> selectedMethods;
	private Map<String, PropertyData> filterProperties;
	private Map<String, PropertyData> handlerProperties;

	// private String propertyName;
	// private String propertyVal;
	// private String type;

	public String getHandlerClass() {
		return handlerClass;
	}

	public void setHandlerClass(String handlerClass) {
		this.handlerClass = handlerClass;
	}

	public String getFilterClass() {
		return filterClass;
	}

	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}

	public List<String> getSelectedMethods() {
		if (selectedMethods == null) {
			selectedMethods = new ArrayList<String>();
		}
		return selectedMethods;
	}

	public void setSelectedMethods(List<String> selectedMethods) {
		this.selectedMethods = selectedMethods;
	}

	public Map<String, PropertyData> getFilterProperties() {
		if (filterProperties == null) {
			filterProperties = new HashMap<String, PropertyData>();
		}
		return filterProperties;
	}

	public void setFilterProperties(Map<String, PropertyData> filterProperties) {
		this.filterProperties = filterProperties;
	}

	protected String getDefaultName() {
		return null;
	}

	public String toString() {
		return serialize();
	}

	public String serialize() {
		String result = null;
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		document.addChild(documentElement);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			prettify(documentElement, outputStream);
		} catch (XMLStreamException e) {
			log.error(e);
			return null;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		result = outputStream.toString();
		return result;
	}

	public void deserialize(OMElement documentElement) {
		List<OMElement> childElements = getChildElements(documentElement,
				"handler");
		if (childElements.size() > 0) {
			OMElement handlerElement = childElements.get(0);
			setHandlerClass(getAttribute(handlerElement, "class"));
			String methodsString = getAttribute(handlerElement, "methods");
			if (methodsString != null) {
				setSelectedMethods(getStringList(methodsString));
			}
			List<OMElement> propertyElements = getChildElements(handlerElement,
					"property");
			for (OMElement element : propertyElements) {
				DataType type = DataType.STRING;
				String propertyName = getAttribute(element, "name");
				String typeAttr = getAttribute(element, "type");
				if (typeAttr!=null){
					type = typeAttr
							.equalsIgnoreCase("string") ? DataType.STRING
							: DataType.XML;
				}
				PropertyData propertyData;
				if (type == DataType.STRING) {
					propertyData = new PropertyData(type, element.getText());
				} else {
					propertyData = new PropertyData(type, element
							.getFirstElement().toString());
				}
				getHandlerProperties().put(propertyName, propertyData);
			}

			List<OMElement> filterElements = getChildElements(handlerElement,
					"filter");
			if (filterElements.size() > 0) {
				OMElement filterElement = filterElements.get(0);
				setFilterClass(getAttribute(filterElement, "class"));
				propertyElements = getChildElements(filterElement, "property");
				for (OMElement element : propertyElements) {
					DataType type = DataType.STRING;
					String propertyName = getAttribute(element, "name");
					String typeAttr = getAttribute(element, "type");
					if (typeAttr!=null){
						type = typeAttr
								.equalsIgnoreCase("string") ? DataType.STRING
								: DataType.XML;
					}
					PropertyData propertyData;
					if (type == DataType.STRING) {
						propertyData = new PropertyData(type, element.getText());
					} else {
						propertyData = new PropertyData(type, element
								.getFirstElement().toString());
					}
					getFilterProperties().put(propertyName, propertyData);
				}
			}
		}
	}

	public OMElement getDocumentElement() {
		// Creating root element
		OMElement documentElement = getElement("handlerartifact", "");

		// Creating handler element
		OMElement handlerElement = getElement("handler", "");
		addAttribute(handlerElement, "class", getHandlerClass());
		addAttribute(handlerElement, "methods",
				getCommaSeparateString(getSelectedMethods()));

		// Creating handler property
		Map<String, PropertyData> handlerProperties = getHandlerProperties();
		for (String propertyName : handlerProperties.keySet()) {
			if (propertyName != null && !propertyName.equals("")) {
				OMElement propertyElement;
				PropertyData propertyData = handlerProperties.get(propertyName);
				DataType type = propertyData.type;
				if (type == DataType.STRING) {
					propertyElement = getElement("property", propertyData.data);
				} else {
					OMElement element;
					try {
						element = getElement(propertyData.data);
						propertyElement = getElement("property", "");
						propertyElement.addChild(element);
					} catch (XMLStreamException e) {
						propertyElement = getElement("property",
								propertyData.data);
						type = DataType.STRING;
					}
				}
				addAttribute(propertyElement, "name", propertyName);
				addAttribute(propertyElement, "type",
						type == DataType.XML ? "xml" : "string");
				handlerElement.addChild(propertyElement);
			}

		}

		// Creating filter element
		OMElement filterElement = getElement("filter", "");
		addAttribute(filterElement, "class", getFilterClass());

		// Creating filter properties
		for (String propertyName : getFilterProperties().keySet()) {
			if (propertyName != null && !propertyName.equals("")) {
				OMElement propertyElement;
				PropertyData propertyData = getFilterProperties().get(
						propertyName);
				DataType type = propertyData.type;
				if (type == DataType.STRING) {
					propertyElement = getElement("property", propertyData.data);
				} else {
					OMElement element;
					try {
						element = getElement(propertyData.data);
						propertyElement = getElement("property", "");
						propertyElement.addChild(element);
					} catch (XMLStreamException e) {
						propertyElement = getElement("property",
								propertyData.data);
						type = DataType.STRING;
					}
				}
				addAttribute(propertyElement, "name", propertyName);
				addAttribute(propertyElement, "type",
						type == DataType.XML ? "xml" : "string");
				filterElement.addChild(propertyElement);
			}
		}

		handlerElement.addChild(filterElement);
		documentElement.addChild(handlerElement);

		return documentElement;
	}

	private String getCommaSeparateString(List<String> list) {
		StringBuffer sb=new StringBuffer();
		if (list != null && !list.isEmpty()) {
			sb.append(list.get(0));
			for (int i = 1; i < list.size(); i++) {
				sb.append(",").append(list.get(i));
			}
		}
		return sb.toString();
	}

	private List<String> getStringList(String commaSeparatedString) {
		ArrayList<String> stringArrayList = new ArrayList<String>();
		String[] strings = commaSeparatedString.split(",");
		for (String s : strings) {
			String value = s.trim();
			if (!value.equals("")){
				stringArrayList.add(value);
			}
		}
		return stringArrayList;
	}

	public Map<String, PropertyData> getHandlerProperties() {
		if (handlerProperties == null) {
			handlerProperties = new HashMap<String, PropertyData>();
		}
		return handlerProperties;
	}

	public enum DataType {
		STRING, XML
	}

	public static class PropertyData {

		public DataType type;
		public String data;

		public PropertyData(DataType type, String data) {
			this.type = type;
			this.data = data;
		}
	}

	public void addFilterProperty(String propertyName, DataType propertyType,
			String propertyData) {
		addProperty(getFilterProperties(), propertyName, propertyType,
				propertyData);

	}

	public void addHandlerProperty(String propertyName, DataType propertyType,
			String propertyData) {
		addProperty(getHandlerProperties(), propertyName, propertyType,
				propertyData);

	}

	private void addProperty(Map<String, PropertyData> propertyMap,
			String propertyName, DataType propertyType, String propertyData) {
		propertyMap.put(propertyName, new PropertyData(propertyType,
				propertyData));

	}
}
