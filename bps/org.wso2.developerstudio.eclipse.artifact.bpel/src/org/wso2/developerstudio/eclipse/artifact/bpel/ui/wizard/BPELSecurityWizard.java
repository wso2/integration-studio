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
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.w3c.dom.Attr;
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
import org.xml.sax.SAXException;

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
	private static final String SERVICE_GROUP_TAG = "serviceGroup";

	private IStructuredSelection selection;
	private BPELSecurityWizardPage securityPage;
	private IProject activeProject;
	private File serviceXML;

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
			serviceXML = activeProject.getFolder(BPEL_CONTENT).getFile(SERVICE_XML_FILE).getLocation().toFile();
			if (serviceXML.exists()) {
				openFile = updateServicesXMLFile(serviceXML);
			} else {
				createServiceXML(serviceXML);
				openFile = updateServicesXMLFile(serviceXML);
			}
			activeProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			IFile serviceFile = ResourcesPlugin.getWorkspace().getRoot()
					.getFileForLocation(Path.fromOSString(openFile.getAbsolutePath()));
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), serviceFile);
		} catch (ParserConfigurationException | TransformerException | XPathExpressionException | SAXException
				| IOException e) {
			log.error(BPELMessageConstants.ERROR_PROCESSING_SERVICE_XML, e);
		} catch (Exception e) {
			log.error(BPELMessageConstants.ERROR_UPDATING_SERVICE_XML, e);
			Throwable realException = e.getCause();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * Creates the service.xml file if it is not available
	 * 
	 * @param serviceXML
	 * @return
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	private void createServiceXML(File serviceXML) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root element
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement(SERVICE_GROUP_TAG);
		doc.appendChild(rootElement);

		List<String> serviceList = securityPage.getServicesFromWSDLs();
		for (String service : serviceList) {
			Element serviceElement = doc.createElement(SERVICE_NODE);
			rootElement.appendChild(serviceElement);

			Attr attr = doc.createAttribute(NAME_ATTRIBUTE);
			attr.setValue(service);
			serviceElement.setAttributeNode(attr);

		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(serviceXML);
		transformer.transform(source, result);
	}

	/**
	 * Updates the service.xml content
	 * 
	 * @param project
	 * 
	 * @return new Service.xml content
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws TransformerException
	 * @throws XPathExpressionException
	 * @throws Exception
	 */
	private File updateServicesXMLFile(File serviceXML) throws ParserConfigurationException, SAXException, IOException,
			TransformerException, XPathExpressionException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(serviceXML);

		removingEmptyTextNodes(doc);

		NodeList childNodes = doc.getElementsByTagName(SERVICE_NODE);
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node service = childNodes.item(i);
			NamedNodeMap attr = ((Node) service).getAttributes();
			Node nodeAttr = attr.getNamedItem(NAME_ATTRIBUTE);
			if (StringUtils.isNotEmpty(securityPage.getPolicyPath())
					&& nodeAttr.getNodeValue().equals(securityPage.getServiceName())) {
				NodeList serviceChildren = service.getChildNodes();
				if (serviceChildren.getLength() == 0) {
					// Creates a node for policy and rampart module
					createPolicyElement(doc, service);
					createRampartModuleElement(doc, service);
				} else {
					boolean policyReplaced = false;
					boolean moduleReplaced = false;
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
							createPolicyElement(doc, service);
							policyReplaced = true;
						}
						if (policyNode.getNodeName().equals(MODULE)) {
							NamedNodeMap attribute = policyNode.getAttributes();
							Node nodeAttribute = attribute.getNamedItem(REF);
							if (nodeAttribute.getNodeValue().equals(RAMPART)) {
								moduleReplaced = true;
							}

						}

					}

					if (!policyReplaced && !moduleReplaced) {
						createPolicyElement(doc, service);
					} else if (!policyReplaced && moduleReplaced) {
						// Creates a node for policy if it is not already there
						createPolicyElement(doc, service);

					}
				}

			} else if (StringUtils.isEmpty(securityPage.getPolicyPath())
					&& nodeAttr.getNodeValue().equals(securityPage.getServiceName())) {
				/*
				 * remove policy element from the source when it is removed via
				 * the wizard
				 */
				NodeList serviceChildren = service.getChildNodes();

				for (int x = 0; x < serviceChildren.getLength(); x++) {
					Node node = serviceChildren.item(x);
					if (node.getNodeName().equals(POLICY)) {
						// removes the policy node
						((Node) service).removeChild(node);
					}
				}

			}
		}

		// write the content into service xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(serviceXML);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);

		return serviceXML;
	}

	/**
	 * creates a node for policy
	 * 
	 * @param doc
	 *            document
	 * @param service
	 *            service Node
	 */
	private void createPolicyElement(Document doc, Node service) {
		Element policy = doc.createElement(POLICY);
		policy.setAttribute(KEY, securityPage.getPolicyPath());
		((Node) service).appendChild(policy);
	}

	/**
	 * creates a node for rampart module
	 * 
	 * @param doc
	 *            document
	 * @param service
	 *            service Node
	 */
	private void createRampartModuleElement(Document doc, Node service) {
		Element module = doc.createElement(MODULE);
		module.setAttribute(REF, RAMPART);
		((Node) service).appendChild(module);
	}

	/**
	 * Removing empty text nodes
	 * 
	 * @param doc
	 * @throws XPathExpressionException
	 */
	private void removingEmptyTextNodes(Document doc) throws XPathExpressionException {
		XPathFactory xpathFactory = XPathFactory.newInstance();
		// XPath to find empty text nodes.
		XPathExpression xpathExp = xpathFactory.newXPath().compile("//text()[normalize-space(.) = '']");
		NodeList emptyTextNodes = (NodeList) xpathExp.evaluate(doc, XPathConstants.NODESET);

		// Remove each empty text node from document.
		for (int i = 0; i < emptyTextNodes.getLength(); i++) {
			Node emptyTextNode = emptyTextNodes.item(i);
			emptyTextNode.getParentNode().removeChild(emptyTextNode);
		}
	}

	public boolean needsPreviousAndNextButtons() {
		return super.needsPreviousAndNextButtons();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		IResource resource = (IResource) selection.getFirstElement();
		activeProject = resource.getProject();
		setWindowTitle("Apply Security");
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
