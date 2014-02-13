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

package org.wso2.developerstudio.eclipse.esb.project.provider;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.part.FileEditorInput;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * Custom NavigatorActionProvider for handling editor switching for ESB files
 * 
 */
public class NavigatorActionProvider extends CommonActionProvider {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);	
	private static final String SEQUENCE="sequence";
	private static final String ENDPOINT="endpoint";
	private static final String PROXY="proxy";
	private static final String LOCAL_ENTRY="localentry";
	private static final String TEMPLATE="template";
	private static final String TASK="task";
	private static final String API="api";
	private static final String MESSAGE_STORE="messageStore";
	private static final String MESSAGE_PROCESSOR="messageProcessor";
	
	private OpenEditorAction openEditorAction;
	private static Map<String,String> prefixMap = new HashMap<String,String>();

	static{
		prefixMap.put("application/vnd.wso2.sequence","sequence_");
		prefixMap.put("application/vnd.wso2.esb.endpoint","endpoint_");
		
	}
	@Override
	public void fillActionBars(IActionBars actionBars) {
		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			Object firstElement = treeSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				IFile file = (IFile) firstElement;
				try {
					IContentDescription contentDescription = file.getContentDescription();
					if (contentDescription != null) {
						IContentType contentType = contentDescription.getContentType();
						if (contentType.getId() != null) {
							if ("org.wso2.developerstudio.eclipse.esb.contenttype.esbconfxml"
									.equals(contentType.getId())) {
								openEditorAction.setSelection(file);
								actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
										openEditorAction);
							}
						}
					}
					
				} catch (CoreException e) {
					/* ignore */
				}
			}
		}
	}

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		openEditorAction = new OpenEditorAction();
	}

	private static class OpenEditorAction extends Action {

		private IFile selection;

		@Override
		public void run() {
			IFile fileTobeOpen = null;
			String synFilePath = selection.getFullPath().toOSString();
			synFilePath=synFilePath.replaceAll(Pattern.quote("\\"), "/");
			String diagramFilePath = synFilePath
					.replaceFirst("/synapse-config/", "/graphical-synapse-config/")
					.replaceFirst("/endpoints/", "/endpoints/endpoint_")
					.replaceFirst("/local-entries/", "/local-entries/localentry_")
					.replaceFirst("/proxy-services/", "/proxy-services/proxy_")
					.replaceFirst("/sequences/", "/sequences/sequence_")
					.replaceFirst("/tasks/", "/tasks/task_")
					.replaceFirst("/templates/","/templates/template_")
					.replaceFirst("/api/","/api/api_")
					.replaceFirst("/message-stores/","/message-stores/messageStore_")
					.replaceFirst("/message-processors/","/message-processors/messageProcessor_")
					.replaceAll(".xml$", ".esb_diagram");

			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();

			try {
				if (selection.getWorkspace().getRoot().getFile(new Path(diagramFilePath)).exists()) {
					fileTobeOpen = selection.getWorkspace().getRoot()
							.getFile(new Path(diagramFilePath));
					IDE.openEditor(page, fileTobeOpen);
				} else{
					Path path = new Path(getGraphicalResource(selection));
					if (selection.getWorkspace().getRoot().getFile(path).exists()) {
						fileTobeOpen = selection.getWorkspace().getRoot()
						.getFile(path);
							IDE.openEditor(page, fileTobeOpen);
					} else {							
						String[] type=getType(selection.getLocation().toOSString());
						if(type.length==0 || "full-synapse".equals(type[0])){							
							fileTobeOpen = selection.getWorkspace().getRoot().getFile(new Path(synFilePath));
							page.openEditor(new FileEditorInput(fileTobeOpen),"org.wso2.developerstudio.eclipse.esb.presentation.EsbEditor");
						}else{
							String location=selection.getLocation().toOSString();				
							String source = FileUtils.getContentAsString(new File(location));
							String name =selection.getName().split("\\.")[0];													
							String fullPath=selection.getFullPath().removeLastSegments(1).toOSString()+"/";
							Openable openable = ESBGraphicalEditor.getOpenable();
							openable.editorOpen(name,type[0],fullPath+type[1]+"_", source);
						}
					}
				}
			}catch (Exception e) {
				log.error("Can't open " + fileTobeOpen, e);
			}
		}

		public void setSelection(IFile selection) {
			this.selection = selection;
		}
		
		private String getGraphicalResource(IFile selection){
			String synFilePath = selection.getFullPath().toOSString();
			synFilePath=synFilePath.replaceAll(Pattern.quote("\\"), "/");
			String graphicalResource = synFilePath.replaceAll(".xml$",".esb_diagram");
			try {
				GeneralProjectArtifact artifact=new GeneralProjectArtifact();
				IProject project = selection.getProject();
				IFile file = project.getFile("artifact.xml");
				artifact.deserialize(file);
				List<RegistryArtifact> allArtifacts = artifact.getAllArtifacts();
				ALL:
				for (RegistryArtifact registryArtifact : allArtifacts) {
					if(registryArtifact.getName().equals(selection.getName().replaceAll(".xml$",""))){
						List<RegistryElement> allRegistryItems = registryArtifact.getAllRegistryItems();
						for (RegistryElement registryElement : allRegistryItems) {
							if(registryElement instanceof RegistryItem){
								RegistryItem item = (RegistryItem) registryElement;
								if(synFilePath.endsWith(item.getFile())){
									if(prefixMap.containsKey(item.getMediaType())){
										String prefix = prefixMap.get(item.getMediaType());
										String name = selection.getName().replaceAll(".xml$",".esb_diagram");;
										graphicalResource = graphicalResource.replaceAll(name+"$",prefix +name);
									} 
									break ALL;
								}
							}
						}
					}
				}
			} catch (Exception e) {
				
			}
			
			return graphicalResource;
		}
		
		/*
		 * This method will return the type of the artifact(sequence, endpoint etc.) by reading the .xml file 
		 */
		private String[] getType(String path) throws Exception {
			List<String> lines;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			/*
			 * Here we are using two approaches to get the correct synapse type
			 * from the .xml file. 
			 * 1. Use org.apache.commons.io.FileUtils.readLines(File) to read xml
			 * basically and identify the correct type.
			 * 2. If further investigation required other than step 1, use dom parser to parse
			 * whole xml to get nested informations for evaluate for advanced
			 * types such as main_sequence, template.endpoints etc.
			 * 
			 * 'type' is required in this stage due to architectural problem. So
			 * we have to get-rid of following code after fixing the
			 * architectural issues.
			 */
			lines = org.apache.commons.io.FileUtils.readLines(new File(path));
			int lineCount = lines.size();
			for (int i = 0; i < lineCount; ++i) {
				String currentLine = lines.get(i);
				if (currentLine.contains("<sequence")) {
					Document doc = dBuilder.parse(new File(path));
					NodeList nodes = doc.getElementsByTagName("sequence");
					if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nodes.item(0);
						if ("main".equals(eElement.getAttribute("name"))) {
							return new String[] { "main_sequence", SEQUENCE };
						} else {
							return new String[] { "sequence", SEQUENCE };
						}
					}
				} else if (currentLine.contains("<proxy")) {
					return new String[] { "proxy", PROXY };
				} else if (currentLine.contains("<endpoint")) {
					Document doc = dBuilder.parse(new File(path));
					Node node = doc.getElementsByTagName("endpoint").item(0);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;
						NodeList endpointChildNodes = eElement.getChildNodes();
						for (int j = 0; j < endpointChildNodes.getLength(); ++j) {
							if ("default".equals(endpointChildNodes.item(j)
									.getNodeName())) {
								return new String[] { "endpoint-0", ENDPOINT };
							} else if ("address".equals(endpointChildNodes
									.item(j).getNodeName())) {
								return new String[] { "endpoint-1", ENDPOINT };
							} else if ("wsdl".equals(endpointChildNodes.item(j)
									.getNodeName())) {
								return new String[] { "endpoint-2", ENDPOINT };
							} else if ("loadbalance".equals(endpointChildNodes
									.item(j).getNodeName())) {
								return new String[] { "endpoint-3", ENDPOINT };
							} else if ("failover".equals(endpointChildNodes
									.item(j).getNodeName())) {
								return new String[] { "endpoint-4", ENDPOINT };
							} else if ("recipientlist"
									.equals(endpointChildNodes.item(j)
											.getNodeName())) {
								return new String[] { "endpoint-5", ENDPOINT };
							} else if ("http".equals(endpointChildNodes.item(j)
									.getNodeName())) {
								return new String[] { "endpoint-6", ENDPOINT };
							} 
						}
						if (currentLine.contains("template")) {
							return new String[] { "endpoint-7", ENDPOINT };
						}
					}
				} else if (currentLine.contains("<localEntry")) {
					return new String[] { "localentry", LOCAL_ENTRY };
				} else if (currentLine.contains("<template")) {
					Document doc = dBuilder.parse(new File(path));
					Node template = doc.getElementsByTagName("template").item(0);
					if (template.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) template;
						NodeList templateChildNodes = eElement.getChildNodes();
						for (int j = 0; j < templateChildNodes.getLength(); ++j) {
							if ("sequence".equals(templateChildNodes.item(j).getNodeName())) {
								return new String[] { "template.sequence",TEMPLATE };
							} else if ("endpoint".equals(templateChildNodes.item(j).getNodeName())) {
								NodeList endpointChildNodes = templateChildNodes.item(j).getChildNodes();
								for (int k = 0; k < endpointChildNodes.getLength(); ++k) {
									if ("default".equals(endpointChildNodes.item(k).getNodeName())) {
										return new String[] {"template.endpoint-0",TEMPLATE };
									} else if ("address".equals(endpointChildNodes.item(k).getNodeName())) {
										return new String[] {"template.endpoint-1",TEMPLATE };
									} else if ("wsdl".equals(endpointChildNodes.item(k).getNodeName())) {
										return new String[] {"template.endpoint-2",TEMPLATE };
									} else if ("http".equals(endpointChildNodes.item(k).getNodeName())) {
										return new String[] {"template.endpoint-3",TEMPLATE };
									}
								}
							}
						}
					}
				} else if (currentLine.contains("<task")) {
					return new String[] { "task", TASK };
				} else if (currentLine.contains("<api")) {
					return new String[] { "api", API };
				} else if (currentLine.contains("<messageStore")) {
					return new String[] { MESSAGE_STORE, MESSAGE_STORE };
				} else if (currentLine.contains("<messageProcessor")) {
					return new String[] { MESSAGE_PROCESSOR, MESSAGE_PROCESSOR };
				} else if (currentLine.contains("<definitions")) {
					return new String[] { "full-synapse", "full-synapse" };
				}
			}
			return new String[] {};
		}
	}
}
