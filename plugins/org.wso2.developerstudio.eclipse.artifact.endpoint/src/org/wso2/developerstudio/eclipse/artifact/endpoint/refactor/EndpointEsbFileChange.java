/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.endpoint.refactor;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.wso2.developerstudio.eclipse.artifact.endpoint.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.namespace.QName;

public class EndpointEsbFileChange extends TextFileChange {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private final String ESB_GRAPHICAL_ESB_DIAGRAM="Diagram";
	private final String ESB_GRAPHICAL_ESB="EsbDiagram";
	
	private final String ENTRY_NAME="entryName";
	private final String STORE_NAME="storeName";
	private final String PROCESSOR_NAME="processorName";
	private final String TASK_NAME="taskName";
	private final String API_NAME="apiName";
	private final String ENDPOINT_NAME="endPointName";
	private final String GENERAL_NAME="name";
	
	private final String LOCAL_ENTRY_TYPE="LOCAL_ENTRY";
	private final String MESSAGE_STORE_TYPE="MESSAGE_STORE";
	private final String MESSAGE_PROCESSOR_TYPE="MESSAGE_PROCESSOR";
	private final String TASK_TYPE="TASK";
	private final String API_TYPE="API";
	private final String ENDPOINT_TYPE="ENDPOINT";
	
	private IFile esbFile;
	private String match;
	private String replace;
	private String match2;
	private String replace2;

	public EndpointEsbFileChange(String name, IFile file, String originalName, String newName) {
		super(name, file);
		esbFile = file;
		prepareMatchAndReplace(originalName,newName);
		addTextEdits();
	}
	
	private void prepareMatchAndReplace(String originalName, String newName) {
		String root=null;	
		OMElement documentElement = null;
		InputStream in = null;
		try {
			in = esbFile.getContents(true);
			OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(in);
			documentElement = builder.getDocumentElement();
			root = documentElement.getLocalName();
		if(ESB_GRAPHICAL_ESB_DIAGRAM.equals(root)){
			match = originalName+".esb";
			replace = newName+".esb";
		}else if (ESB_GRAPHICAL_ESB.equals(root)){
			OMElement server = null;
			String name=null;
			String name2="";
			Iterator<?> childrenWithLocalName = documentElement.getChildrenWithLocalName("server");
			while(childrenWithLocalName.hasNext()){
				server = (OMElement) childrenWithLocalName.next();
			}
			String serverType=server.getAttributeValue(new QName("type"));
			if(LOCAL_ENTRY_TYPE.equals(serverType)){
				name=ENTRY_NAME;
			}else if(MESSAGE_STORE_TYPE.equals(serverType)){
				name=STORE_NAME;
			}else if(MESSAGE_PROCESSOR_TYPE.equals(serverType)){
				name=PROCESSOR_NAME;
			}else if(TASK_TYPE.equals(serverType)){
				name=TASK_NAME;
			}else if(API_TYPE.equals(serverType)){
				name=API_NAME;
				//Http Endpoint has an attribute named endPointName
			}else if(ENDPOINT_TYPE.equals(serverType)){
				name = GENERAL_NAME;
				name2 = ENDPOINT_NAME;

				match2 = name2 + "=\"" + originalName + "\"";
				replace2 = name2 + "=\"" + newName + "\"";
			}else{
				name=GENERAL_NAME;
			}
			match = name+"=\""+originalName+"\"";
			replace = name+"=\""+newName+"\"";
		}		
		} catch (CoreException e) {
			log.error("Error while parsing the content", e);
		}finally{
			try {
				if(in !=null){
					in.close();
				}
			} catch (IOException e) {
				log.error("Error while closing the input Stream", e);
			}
		}
	}

	private void addTextEdits() {
		MultiTextEdit multiTextEdit = new MultiTextEdit();
		setEdit(multiTextEdit);
		setSaveMode(FORCE_SAVE);

		try {
			if (esbFile.exists()) {
				identifyReplaces();
			}
		} catch (IOException e) {
			log.error("Encountered an IO Error trying to manipulate the file", e);
		}
	}

	private void identifyReplaces() throws IOException {
		String fileContent =
		                     FileUtils.readFileToString(new File(esbFile.getRawLocation()
		                                                                .toString()));
		int i = 0;
		while ((i = (fileContent.indexOf(match, i) + 1)) > 0) {
			addEdit(new ReplaceEdit(i - 1, match.length(), replace));
		}

		if (match2 != null && !match2.equals("")) {
			i = 0;
			while ((i = (fileContent.indexOf(match2, i) + 1)) > 0) {
				addEdit(new ReplaceEdit(i - 1, match2.length(), replace2));
			}
		}
	}
}
