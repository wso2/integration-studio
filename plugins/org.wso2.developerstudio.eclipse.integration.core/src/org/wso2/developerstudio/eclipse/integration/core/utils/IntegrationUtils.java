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

package org.wso2.developerstudio.eclipse.integration.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

public class IntegrationUtils {

	private static final String ADDITIONAL_FOLDERS = "default";
//	public static final String NS_1_4="http://ws.apache.org/ns/synapse";
//	public static final String NS_2_0="http://synapse.apache.org/ns/2010/04/configuration";

//	public static String[] getSynapseNamespaces() {
//		return new String[] { NS_1_4, NS_2_0 };
//	}

	private static String getLocalTagName(IntegrationEntryType type) {
		switch (type) {
		case INTEGRATION_TEMPLATE:
			return "integration-template";
		case CONNECTION:
			return "connection";	
		case ALL:
			return "";
		default:
			return "";
		}
	}

	public static List<OMElement> integrationConfigFolderContentProcessing( String integrationConfigFolderPath) 
			throws XMLStreamException, IOException, OMException, Exception {

		List<OMElement> editorList = new ArrayList<OMElement>();
		File rootDir = new File(integrationConfigFolderPath + "/"+ ADDITIONAL_FOLDERS); //TODO do we require a default folder?
		
		if(!rootDir.exists()){
			//throw new Exception("Please provide a valid synapse-configs directory"); TODO
			rootDir = new File(integrationConfigFolderPath);
		}
		File[] dirs = rootDir.listFiles();
		int dirCount = dirs.length;
		for (int i = 0; i < dirCount; ++i) {
			String name=dirs[i].getName();
			if(name.equals("integration-templates")){
				processFiles(editorList, rootDir + "/integration-template", IntegrationEntryType.INTEGRATION_TEMPLATE);
			}else if(name.equals("connections")){
				processFiles(editorList, rootDir + "/endpoints",IntegrationEntryType.CONNECTION);
			}
		}
		return editorList;
	}

	private static void processFiles(List<OMElement> editorList, String dirPath, IntegrationEntryType type) 
			throws XMLStreamException, IOException, OMException, Exception {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		int fileCount = files.length;
		for (int j = 0; j < fileCount; ++j) {
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(files[j])).getDocumentElement();

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
