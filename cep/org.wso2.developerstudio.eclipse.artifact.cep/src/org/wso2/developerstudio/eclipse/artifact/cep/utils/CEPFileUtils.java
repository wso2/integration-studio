package org.wso2.developerstudio.eclipse.artifact.cep.utils;


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

public class CEPFileUtils {

	private static String getLocalTagName(CEPEntryType type) {
		switch (type) {
		case EVENTSTREAM:
			return "stream";
		case EVENTPUBLISHER:
			return "publisher";
		case RECIEVER:
			return "receiver";
		case EXECUTIONPLAN:
			return "execution-plan";
		case ALL:
			return "";
		default:
			return "";
		}
	}

	public static List<OMElement> cepFileProcessing(String cepFilePath,
			CEPEntryType type) throws XMLStreamException, IOException,
			OMException, Exception {

		File file = new File(cepFilePath);
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
		if (localName.equals("cep") || localName.equals("definitions")) {
			while (children.hasNext()) {
				OMElement childnode = (OMElement) children.next();
				if (type.name().equals("ALL")) {
					if (childnode.getLocalName().equals("stream")) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}
					} else if (childnode.getLocalName().equals("publisher")) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}

					} else if (childnode.getLocalName().equals("reciever")) {
						if (!editorList.contains(childnode)) {
							editorList.add(childnode);
						}

					} else if (childnode.getLocalName().equals("execution-plan")) {
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
	
	public static boolean isCepConfGiven(File cepFile, CEPEntryType type)
			throws XMLStreamException, IOException, OMException, Exception {

		if (cepFile.getName().endsWith(".xml")) {
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(cepFile))
					.getDocumentElement();

			String localTagName = getLocalTagName(type);
			String localName = documentElement.getLocalName();
			if (localName.equals(localTagName)) {
				return false;
			}
			if (localName.equals("cep") || localName.equals("definitions")) {
				return true;
			}
		}
		return false;

	}
}
