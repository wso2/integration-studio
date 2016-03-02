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

package org.wso2.developerstudio.eclipse.esb.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

public class SynapseUtils {

	private static String ADDITIONAL_FOLDERS = "default";

	public static String[] getSynapseNamespaces() {
		return new String[] { SynapseConstants.NS_1_4, SynapseConstants.NS_2_0 };
	}

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
		case ALL:
			return "";
		default:
			return "";
		}
	}

	public static List<OMElement> synapseConfigFolderContentProcessing(
			String synapseConfigFolderPath) throws XMLStreamException,
			IOException, OMException, Exception {

		List<OMElement> editorList = new ArrayList<OMElement>();
		File rootDir = new File(synapseConfigFolderPath + "/"
				+ ADDITIONAL_FOLDERS);
		
		if(!rootDir.exists()){
			//throw new Exception("Please provide a valid synapse-configs directory");
			rootDir = new File(synapseConfigFolderPath);
		}
		File[] dirs = rootDir.listFiles();
		int dirCount = dirs.length;
		for (int i = 0; i < dirCount; ++i) {
			String name=dirs[i].getName();
			if(name.equals("api")){
				processFiles(editorList, rootDir + "/api", SynapseEntryType.API);
			}else if(name.equals("endpoints")){
				processFiles(editorList, rootDir + "/endpoints",SynapseEntryType.END_POINT);
			}else if(name.equals("local-entries")){
				processFiles(editorList, rootDir + "/local-entries",SynapseEntryType.LOCAL_ENTRY);
			}else if(name.equals("proxy-services")){
				processFiles(editorList, rootDir + "/proxy-services",SynapseEntryType.PROXY_SERVICE);
			}else if(name.equals("sequences")){
				processFiles(editorList, rootDir + "/sequences",SynapseEntryType.SEQUENCE);
			}else if(name.equals("tasks")){
				processFiles(editorList, rootDir + "/tasks", SynapseEntryType.TASK);
			}else if(name.equals("templates")){
				processFiles(editorList, rootDir + "/templates",SynapseEntryType.TEMPLATE);
			} else if(name.equals("message-stores")){
				processFiles(editorList,rootDir + "/message-stores",SynapseEntryType.MESSAGE_STORE);
			} else if(name.equals("message-processors")){
				processFiles(editorList, rootDir + "/message-processors",SynapseEntryType.MESSAGE_PROCESSOR);
			}
		}
		return editorList;
	}

	private static void processFiles(List<OMElement> editorList,
			String dirPath, SynapseEntryType type) throws XMLStreamException,
			IOException, OMException, Exception {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		int fileCount = files.length;
		for (int j = 0; j < fileCount; ++j) {
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(
					files[j])).getDocumentElement();

			String localTagName = getLocalTagName(type);

			String localName = documentElement.getLocalName();
			if (localName.equals(localTagName)) {
				if (!editorList.contains(documentElement)) {
					editorList.add(documentElement);
				}
			}
		}
	}
}
