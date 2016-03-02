/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import java.io.StringWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.AbstractEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.EsbDeserializerRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.IEsbNodeDeserializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * 
 */
public class EndPointDuplicator {
	/**
	 * Working project
	 */
	private IProject project;
	
	/**
	 * DeveloperStudio logger
	 * */
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * 
	 * @param project
	 * @param diagramEditor
	 */
	public EndPointDuplicator(IProject project,EsbDiagramEditor diagramEditor) {
		this(project);
		if (AbstractEsbNodeDeserializer.getDiagramEditor()==null) {
			if(diagramEditor!=null){
				 EsbDeserializerRegistry.getInstance().init(diagramEditor);
			} else {
				throw new IllegalArgumentException("diagramEditor cannot be null");
			}
		} 
	}
	
	/**
	 * 
	 * @param project
	 */
	public EndPointDuplicator(IProject project) {
		if (project != null) {
			this.project = project;
		} else {
			throw new IllegalArgumentException("Project cannot be null");
		}
	}
	
	/**
	 * Scan and duplicators endpoints into proxy service diagram 
	 * @param rootCompartment
	 * @param sequenceKey
	 */
	public void duplicateEndPoints(GraphicalEditPart rootCompartment,String sequenceKey){
		List<Endpoint> endpoints = getEndpoints(sequenceKey);
		for (Endpoint endpoint : endpoints) {
			try {
				@SuppressWarnings("rawtypes")
				IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(endpoint);
				if(deserializer!=null){
					AbstractEndPoint endPoint = (AbstractEndPoint) deserializer.createNode(rootCompartment, endpoint);
					//FIXME: set inline
				}
			} catch (NullPointerException e) {
				log.error("EsbDeserializerRegistry must be initialized before it can be used",e);
			}
		}
	}

	private String getFileLocation(String key) {
		IFolder endpointsDir = project.getFolder("src/main/synapse-config/sequences");
		if (endpointsDir.exists()) {
			IFile file = endpointsDir.getFile(key.concat(".xml"));
			if (file.exists()) {
				return file.getLocation().toOSString();
			}
		}
		return null;
	}

	private List<Endpoint> getEndpoints(String key) {
		List<Endpoint> epList = new LinkedList<Endpoint>();
		
		String fileLocation = getFileLocation(key); 
		if(fileLocation==null) {
			log.error("Cannot find sequence '" + key + "'");
			return Collections.EMPTY_LIST;
		}

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		NamespaceContext ctx = new NamespaceContext() {
			public String getNamespaceURI(String prefix) {
				return "http://ws.apache.org/ns/synapse";
			}

			public String getPrefix(String str) {
				return null;
			}

			public Iterator<?> getPrefixes(String str) {
				return null;
			}
		};
		try {
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document doc = builder.parse(fileLocation);
			XPath xpath = XPathFactory.newInstance().newXPath();
			xpath.setNamespaceContext(ctx);
			
			XPathExpression expr = xpath.compile("//:endpoint");

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				try {
					Node item = nodes.item(i);
					StringWriter writer = new StringWriter();
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(new DOMSource(item), new StreamResult(writer));
					OMElement element = AXIOMUtil.stringToOM(writer.toString());
					epList.add(EndpointFactory.getEndpointFromElement(element, false,
							new Properties()));
				} catch (Exception e) {
					//FIXME: log real error message
					log.error("An unexpected error has occurred",e);
				} 
			}
			
			expr = xpath.compile("//:sequence[@key]");

			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				try {
					if(nodes.item(i) instanceof Attr){
						Attr attr = (Attr) nodes.item(i);
						epList.addAll(getEndpoints(attr.getValue()));
					}
				} catch (Exception e) {
					//FIXME: log real error message
					log.error("An unexpected error has occurred",e);
				} 
			}
		} catch (Exception e) {
			//FIXME: log real error message
			log.error("error",e);
		}

		return epList;
	}

}
