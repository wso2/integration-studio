/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.bpel.ui.wizard;

import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.artifact.bpel.Activator;
import org.wso2.developerstudio.eclipse.artifact.bpel.model.BpelModel;
import org.wso2.developerstudio.eclipse.artifact.bpel.utils.BPELImageUtils;
import org.wso2.developerstudio.eclipse.artifact.bpel.utils.BPELMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class BPELSecurityWizard extends Wizard implements INewWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String APPLY_SECURITY_LABEL = "Apply Security";
	private static final String BPEL_CONTENT = "bpelContent";
	private static final String SERVICE_XML_FILE = "service.xml";
	private static final String SERVICE_NODE = "service";
	private static final String NAME_ATTRIBUTE = "name";
	private static final String KEY = "key";
	private static final String POLICY = "policy";
	private static final String MODULE = "module";
	private static final String REF = "ref";
	private static final String RAMPART = "rampart";

	private IStructuredSelection selection;
	private BPELSecurityWizardPage securityPage;
	private IProject activeProject;

	private BpelModel model;
	private String policyFileLocation;

	private int modelGeneratingType;
	private IPackageFragmentRoot sourceFolder;

	public int getModelGeneratingType() {
		return modelGeneratingType;
	}

	public void setModelGeneratingType(int modelGeneratingType) {
		this.modelGeneratingType = modelGeneratingType;
	}

	public String getPolicyFile() {
		return policyFileLocation;
	}

	public void setPolicyFile(String policyFile) {
		this.policyFileLocation = policyFile;
	}

	public BPELSecurityWizard() {
	}

	public BPELSecurityWizard(String policyFileLocation, int type, IPackageFragmentRoot sourceFolderLocation) {
		setPolicyFile(policyFileLocation);
		setModelGeneratingType(type);
		this.sourceFolder = sourceFolderLocation;
	}

	public boolean performFinish() {

		File openFile = null;
		IResource resource = (IResource) selection.getFirstElement();
		activeProject = resource.getProject();
		try {
			openFile = updateServicesXMLFile(activeProject);
			activeProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			IFile serviceFile = ResourcesPlugin.getWorkspace().getRoot()
					.getFileForLocation(Path.fromOSString(openFile.getAbsolutePath()));
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), serviceFile);
		} catch (Exception e) {
			log.error(BPELMessageConstants.ERROR_SERVICE_XML_UPDATE_ERROR, e);
		}

		return true;
	}

	/**
	 * Updates the service.xml content
	 * 
	 * @param project
	 * 
	 * @return new Service.xml content
	 * @throws Exception
	 */
	private File updateServicesXMLFile(IProject activeProject) throws Exception {

		File serviceXML = activeProject.getFolder(BPEL_CONTENT).getFile(SERVICE_XML_FILE).getLocation().toFile();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(serviceXML);

		NodeList childNodes = doc.getElementsByTagName(SERVICE_NODE);
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node service = childNodes.item(i);
			NamedNodeMap attr = ((Node) service).getAttributes();
			Node nodeAttr = attr.getNamedItem(NAME_ATTRIBUTE);
			if (StringUtils.isNotEmpty(securityPage.getPolicyPath())
					&& nodeAttr.getNodeValue().equals(securityPage.getServiceName())) {
				NodeList serviceChildren = service.getChildNodes();
				if (serviceChildren.getLength() == 0) {
					/* creates a node for policy if it is not already
					*available
					*/
					Element module = doc.createElement(MODULE);
					module.setAttribute(REF, RAMPART);
					((Node) service).appendChild(module);

					Element policy = doc.createElement(POLICY);
					policy.setAttribute(KEY, securityPage.getPolicyPath());
					((Node) service).appendChild(policy);
				} else {
					for (int x = 0; x < serviceChildren.getLength(); x++) {
						Node policyNode = serviceChildren.item(x);
						if (policyNode.getNodeName().equals(POLICY)) {
							/*
							 * remove the policy node if it is already available
							 * and replace with new value
							 */
							if (policyNode != null) {
								((Node) service).removeChild(policyNode);
							}
							Element policy = doc.createElement(POLICY);
							policy.setAttribute(KEY, securityPage.getPolicyPath());
							((Node) service).appendChild(policy);
						}
					}
				}

			} else if (StringUtils.isEmpty(securityPage.getPolicyPath())
					&& nodeAttr.getNodeValue().equals(securityPage.getServiceName())) {
				/*
				 * remove policy element from the source when it is removed via
				 * the wizard
				 */
				NodeList serviceChildren = service.getChildNodes();
				int length = serviceChildren.getLength();
				if (serviceChildren.getLength() > 0) {
					for (int y = 0; y < length; y++) {
						Node node = serviceChildren.item(0);
						if (node != null) {
							((Node) service).removeChild(node);
						}
					}
				}
			}
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(serviceXML);
		transformer.transform(source, result);

		return serviceXML;
	}

	public boolean needsPreviousAndNextButtons() {
		return super.needsPreviousAndNextButtons();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		IResource resource = (IResource) selection.getFirstElement();
		activeProject = resource.getProject();
	}

	public void addPages() {

		if (policyFileLocation == null) {
			securityPage = new BPELSecurityWizardPage(APPLY_SECURITY_LABEL, model, activeProject);
			securityPage.setImageDescriptor(BPELImageUtils.getInstance().getImageDescriptor("bpel-wizard.png"));
			addPage(securityPage);
		}
	}

	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (nextPage != null) {
			nextPage.setImageDescriptor(BPELImageUtils.getInstance().getImageDescriptor("bpel-wizard.png"));
		}
		return nextPage;

	}

	public void setInitializationData(IConfigurationElement arg0, String arg1, Object arg2) throws CoreException {
		setModelGeneratingType(Integer.parseInt(((Map) arg2).get("type").toString()));
	}
}
