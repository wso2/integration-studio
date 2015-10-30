package org.wso2.developerstudio.eclipse.esb.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

public class SynapseFileUtils {

	private static String getLocalTagName(SynapseEntryType type) {
		switch (type) {
		case END_POINT:
			return "endpoint";
		case SEQUENCE:
			return "sequence";
		case PROXY_SERVICE:
			return "proxy";
		case LOCAL_ENTRY:
			return "localEntry";
		case TASK:
			return "task";
		case API:
			return "api";	
		case TEMPLATE:
			return "template";	
		case MESSAGE_STORE:
			return "messageStore";
		case MESSAGE_PROCESSOR:
			return "messageProcessor";
		case INBOUND_ENDPOINT:
			return "inboundEndpoint";
		case ALL:
			return "";
		default:
			return "";
		}
	}

	public static List<OMElement> synapseFileProcessing(String synapseFilePath,
			SynapseEntryType type) throws XMLStreamException, IOException,
			OMException, Exception {

		File file = new File(synapseFilePath);
		List<OMElement> editorList = new ArrayList<OMElement>();
		OMElement documentElement = new StAXOMBuilder(new FileInputStream(file))
				.getDocumentElement();
		
		Iterator<?> children;
		String localTagName = getLocalTagName(type);
		children = documentElement.getChildElements();
		
		
//		if (localTagName.equals("")) {
//			children = documentElement.getChildElements();
//		}
//		else {
//			children = documentElement.getChildrenWithLocalName(localTagName);
//		}
		String localName = documentElement.getLocalName();
		if(localName.equals(localTagName)){
			if (!editorList.contains(documentElement)) {
				editorList.add(documentElement);
			}
		}
		if (localName.equals("synapse") || localName.equals("definitions")) {
			while (children.hasNext()) {
				OMElement childnode = (OMElement) children.next();
				if (type.name().equals("ALL")) {
					if (childnode.getLocalName().equals("endpoint")) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if (childnode.getLocalName().equals("sequence")) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}

					} else if (childnode.getLocalName().equals("proxy")) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}

					} else if (childnode.getLocalName().equals("localEntry")) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if(childnode.getLocalName().equals("task")){
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if(childnode.getLocalName().equals("api")){
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if(childnode.getLocalName().equals("template")){
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if(childnode.getLocalName().equals("messageStore")){
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if(childnode.getLocalName().equals("messageProcessor")){
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if(childnode.getLocalName().equals("inboundEndpoint")){
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					}else{
						
					}
				} else {
					if (childnode.getLocalName().equals(localTagName)) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					}
				}
			}
		}
		return editorList;
	}
	
	public static boolean isSynapseConfGiven(File synapseFile, SynapseEntryType type)
			throws XMLStreamException, IOException, OMException, Exception {

		if (synapseFile.getName().endsWith(".xml")) {
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(synapseFile))
					.getDocumentElement();

			String localTagName = getLocalTagName(type);
			String localName = documentElement.getLocalName();
			if (localName.equals(localTagName)) {
				return false;
			}
			if (localName.equals("synapse") || localName.equals("definitions")) {
				return true;
			}
		}
		return false;

	}
}