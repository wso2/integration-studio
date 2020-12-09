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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.bpel.apache.ode.deploy.ui.util.DeployUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.artifact.bpel.Activator;
import org.wso2.developerstudio.eclipse.artifact.bpel.model.BpelModel;
import org.wso2.developerstudio.eclipse.artifact.bpel.utils.BPELMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.SAXException;

public class BPELSecurityWizardPage extends WizardPage {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String APPLY_SECURITY_LABEL = "Apply Security";
	private static final String SERVICE_LIST_LABEL = "Services";
	private static final String POLICY_FILE_LABEL = "Policy File";
	private static final String BROWSE_LABEL = "Browse";

	private static final String BPEL_CONTENT = "bpelContent";
	private static final String SERVICE_XML_FILE = "service.xml";
	private static final String SERVICE_NODE = "service";
	private static final String NAME_ATTRIBUTE = "name";
	private static final String KEY = "key";
	private static final String POLICY = "policy";

	private Combo cmbServiceList;
	private Text txtPolicyFile;
	private Button btnBrowsePolicyFile;
	private String value;

	private BpelModel model;
	private boolean isDataCompleted = false;
	private String keyValue;
	private String serviceName;
	private IProject activeProject;
	List<String> localPartList;

	public boolean isDataCompleted() {
		return isDataCompleted;
	}

	public IWizardPage getNextPage() {

		return super.getNextPage();
	}

	protected BPELSecurityWizardPage(String pageName, BpelModel model, IProject activeProject) {
		super(pageName);
		setTitle(pageName);
		setDescription("Apply Security for BPEL Processes");
		this.model = model;
		this.activeProject = activeProject;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		Label lblServiceLabel = new Label(container, SWT.NONE);
		lblServiceLabel.setBounds(20, 10, 70, 17);
		lblServiceLabel.setText(SERVICE_LIST_LABEL);

		cmbServiceList = new Combo(container, SWT.READ_ONLY);
		cmbServiceList.setBounds(100, 5, 366, 15);
		fillComboBoxWithServices();

		cmbServiceList.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				serviceName = cmbServiceList.getText();
				value = getPolicyFromTheSource();
				if (StringUtils.isNotEmpty(value)) {
					txtPolicyFile.setText(value);
				} else {
					txtPolicyFile.setText("");
				}
				setPageComplete(true);
				isDataCompleted = true;
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		Label lblPolicyLabel = new Label(container, SWT.NONE);
		lblPolicyLabel.setBounds(20, 50, 70, 20);
		lblPolicyLabel.setText(POLICY_FILE_LABEL);

		txtPolicyFile = new Text(container, SWT.BORDER);
		txtPolicyFile.setBounds(100, 45, 366, 30);
		value = getPolicyFromTheSource();
		if (StringUtils.isNotEmpty(value)) {
			txtPolicyFile.setText(value);
		} else {
			txtPolicyFile.setText("");
		}

		btnBrowsePolicyFile = new Button(container, SWT.NONE);
		btnBrowsePolicyFile.setText(BROWSE_LABEL);
		btnBrowsePolicyFile.setBounds(470, 45, 100, 27);

		btnBrowsePolicyFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selectRegistryResource(txtPolicyFile);
				setPageComplete(true);
				isDataCompleted = true;
			}

		});

		txtPolicyFile.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				if (StringUtils.isNotBlank(txtPolicyFile.getText())) {
					keyValue = txtPolicyFile.getText();
				} else {
					keyValue = null;
				}
			}
		});

	}

	/**
	 * Gets the policy from the source
	 * 
	 */
	private String getPolicyFromTheSource() {

		String policy = null;
		File serviceXML = activeProject.getFolder(BPEL_CONTENT).getFile(SERVICE_XML_FILE).getLocation().toFile();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		Document doc = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			if (serviceXML.exists()) {
				doc = docBuilder.parse(serviceXML);
				NodeList childNodes = doc.getElementsByTagName(SERVICE_NODE);
				for (int i = 0; i < childNodes.getLength(); i++) {
					Node service = childNodes.item(i);
					NamedNodeMap attr = ((Node) service).getAttributes();
					Node nodeAttr = attr.getNamedItem(NAME_ATTRIBUTE);
					if (nodeAttr.getNodeValue().equals(serviceName)) {

						NodeList serviceChildren = service.getChildNodes();
						if (serviceChildren.getLength() > 0) {
							for (int x = 0; x < serviceChildren.getLength(); x++) {
								Node policyNode = serviceChildren.item(x);
								if (policyNode.getNodeName().equals(POLICY)) {
									NamedNodeMap atr = policyNode.getAttributes();
									Node nodeAtr = atr.getNamedItem(KEY);
									policy = nodeAtr.getNodeValue();
								}
							}
						}
					}
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			log.error(BPELMessageConstants.ERROR_PROCESSING_SERVICE_XML);
		}

		return policy;
	}

	/**
	 * Fills the Combo with services
	 * 
	 */
	private void fillComboBoxWithServices() {

		List<String> serviceList = getServicesFromWSDLs();

		for (String service : serviceList) {
			cmbServiceList.add(service);
		}

		if (cmbServiceList.getSelectionIndex() == -1) {
			cmbServiceList.select(0);
			if (cmbServiceList.getItemCount() > 0) {
				serviceName = cmbServiceList.getItem(0);
			}else{
				setPageComplete(false);
				isDataCompleted = false;
			}
		}

	}

	/**
	 * Reads wsdls and get the available services
	 */
	public List<String> getServicesFromWSDLs() {
		localPartList = new ArrayList<String>();
		ResourceSetImpl resourceSet = new ResourceSetImpl();

		List<Definition> wsdlDefs = DeployUtils.loadAllWSDLFromProject(activeProject, resourceSet);
		for (Definition current : wsdlDefs) {
			Map services = current.getServices();
			if (!services.isEmpty()) {
				@SuppressWarnings("rawtypes")
				Collection values = services.values();
				for (Object name : values) {
					QName serviceName = ((Service) name).getQName();
					if (serviceName != null) {
						localPartList.add(serviceName.getLocalPart());
					}
				}
			}
		}
		return localPartList;
	}

	protected void selectRegistryResource(Text txtPolicyFile) {
		RegistryResourceBrowserDialog dialog = new RegistryResourceBrowserDialog(getShell(), SWT.NULL,
				new ArrayList<NamedEntityDescriptor>(), txtPolicyFile);
		int dialogOpen = dialog.open();
		if (dialogOpen == Window.OK) {
			keyValue = dialog.getPolicyKey();
			txtPolicyFile.setText(keyValue);
		}

	}

	public String getPolicyPath() {
		return keyValue;
	}

	public String getServiceName() {
		return serviceName;

	}
}