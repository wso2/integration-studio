/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.security.project.ui.form;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormConstants;
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.security.Activator;
import org.wso2.developerstudio.eclipse.security.project.model.Policy2;
import org.wso2.developerstudio.eclipse.security.project.ui.dialog.UserRolesDialog;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityPolicies;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityPolicyUtils;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityTemplateUtil;
import org.xml.sax.SAXException;
import org.eclipse.swt.widgets.Control;

public class SecurityFormPage extends FormPage {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	boolean pageDirty;
	
	// Messages
	private static final String TIP_MESSAGE = "Description not available";

	public IProject project;
	private Policy2 policyObject;
	private InputStream policyTemplateStream;
	File policyTemplateFile;
	private File inputFile;
	private String policyFileName;
	private static String selectedPolicy;
	private Document doc;
	private Element rampart;
	private Element secElement;
	private String policyID;
	private Display display;
	private static String allowRoles;

	private FormToolkit toolkit;
	private ScrolledForm form;
	private Composite body;
	private Object[] resultService;
	private Object[] enresult;
	private Object[] signresult;
	private Object[] keberosResult;

	private static Map<String, String> rampartDataMap;
	private static Map<String, String> encryptDataMap;
	private static Map<String, String> signDataMap;

	private static Map<String, String> carbonSecAuthDataMap;
	private static Map<String, String> carbonSecTrustDataMap;
	private static Map<String, String> carbonSecKerberosDataMap;

	private Map<String, Text> encryptControlMap;
	private Map<String, Text> signControlMap;
	private Map<String, Object> rampartControlMap;
	private static Map<String, String> carbonSecAuthControlMap;

	private Map<String, Text> carbonSecTrustControlMap;
	private Map<String, Text> carbonSecKerberosControlMap;

	private Map<String, Button> policyeMap;

	private static List<String> utRoles;

	SecurityFormEditor formEditor;

	// UI components
	private Button policyOneUserRolesButton;
	private Button policySevenUserRolesButton;
	private Button policyEightUserRolesButton;
	private Button policyFourteenUserRolesButton;
	private Button policyFifteenUserRolesButton;
	private Text txtPrivateStore;
	private Text txtPrincipalName;
	private Text txtPrincipalPassword;
	private Text txtRampartTimestampMaxSkew;
	private Text txtRampartUser;
	private Text txtRampartEncryptionUser;
	private Text txtRampartMinTTL;
	private Text txtRampartTokenStoreClass;
	private Text txtRampartNonceLifeTime;
	private Combo cmbRampartTimestampStrict;
	private Combo cmbRampartTimestampPrecision;

	public SecurityFormPage(FormEditor editor, String id, String title, IProject iproject, File file, Display display) {
		super(editor, id, title);

		allowRoles = null;
		utRoles = new ArrayList<String>();
		rampartDataMap = new HashMap<>();
		encryptDataMap = new HashMap<>();
		signDataMap = new HashMap<>();
		carbonSecAuthDataMap = new HashMap<>();
		carbonSecTrustDataMap = new HashMap<>();
		carbonSecKerberosDataMap = new HashMap<>();

		// Fill Data Maps with default values
		rampartDataMap.put(SecurityFormConstants.RAMPART_USER, SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
		rampartDataMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, SecurityFormConstants.RAMPART_ENCRYPTION_USER_VALUE);
		rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, SecurityFormConstants.RAMPART_TIME_VALUE);
		rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, SecurityFormConstants.RAMPART_TIME_VALUE);
		rampartDataMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS_VALUE);
		rampartDataMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, SecurityFormConstants.RAMPART_TIME_VALUE);
		rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,SecurityFormConstants.VALUE_FALSE);
		rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT, SecurityFormConstants.VALUE_FALSE);

		encryptDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS, SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
		encryptDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE, SecurityFormConstants.WSO2_PRIVATESTORE);
		encryptDataMap.put(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID, SecurityFormConstants.RAMPART_TENANT_VALUE);
		encryptDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES, SecurityFormConstants.WSO2_PRIVATESTORE);
		encryptDataMap.put(SecurityFormConstants.RAMPART_CONFIG_USER, SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);

		signDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS, SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
		signDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE, SecurityFormConstants.WSO2_PRIVATESTORE);
		signDataMap.put(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID, SecurityFormConstants.RAMPART_TENANT_VALUE);
		signDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES, SecurityFormConstants.WSO2_PRIVATESTORE);
		signDataMap.put(SecurityFormConstants.RAMPART_CONFIG_USER, SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);

		carbonSecTrustDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS, SecurityFormConstants.WSO2_PRIVATESTORE_ALIAS);
		carbonSecTrustDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE, SecurityFormConstants.WSO2_PRIVATESTORE);
		carbonSecTrustDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES, SecurityFormConstants.WSO2_PRIVATESTORE);

		encryptControlMap = new HashMap<>();
		signControlMap = new HashMap<>();
		rampartControlMap = new HashMap<>();
		carbonSecAuthControlMap = new HashMap<>();
		carbonSecTrustControlMap = new HashMap<>();
		carbonSecKerberosControlMap = new HashMap<>();

		policyeMap = new HashMap<>();
		inputFile = file;
		project = iproject;
		formEditor = (SecurityFormEditor) editor;
		this.display = display;
	}

	protected void createFormContent(IManagedForm managedForm) {

		toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		form.setText(SecurityFormConstants.EDITOR_TITLE);
		body = form.getBody();
		GridLayout gridParentLayout = new GridLayout(1, true);

		body.setLayout(gridParentLayout);
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		Object[] result = CreateMainSection(toolkit, body, SecurityFormConstants.SECTION_SECURITY_SERVICE, 10, 70, 600, 30, true);
		Composite seccomposite = (Composite) result[1];
		GridLayout gridSecLayout = new GridLayout(5, false);
		seccomposite.setLayout(gridSecLayout);

		createCategory(toolkit, seccomposite, SecurityFormConstants.BASIC_SCENARIOS);

		try {
			createSecurityScenarioOptionButtons(seccomposite, SecurityPolicyUtils.getInstance()
					.getBasicSecurityScenarios(), managedForm, 0, body);
		} catch (IOException | JAXBException e) {
			log.error(SecurityFormMessageConstants.MESSAGE_READ_POLICY, e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_POLICYFILE_READ_ERROR);
			msg.open();
		}

		resultService = CreateSecuritySection(toolkit, body, SecurityFormConstants.SECTION_SERVICE_INFO, 10, 70, 600, 30, true);
		Composite serviceInfoMainComposite = (Composite) resultService[1];
		GridLayout gridserviceLayout = new GridLayout();
		serviceInfoMainComposite.setLayout(gridserviceLayout);

		Composite compositeBasicInfo = new Composite(serviceInfoMainComposite, SWT.NULL);
		GridLayout BasicInfoLayout = new GridLayout(3, false);
		compositeBasicInfo.setLayout(BasicInfoLayout);

		toolkit.createLabel(compositeBasicInfo, SecurityFormConstants.LABEL_PRIVATE_STORE);

		txtPrivateStore = new Text(compositeBasicInfo, SWT.BORDER);
		txtPrivateStore.setBounds(new org.eclipse.swt.graphics.Rectangle(92, 40, 84, 28));
		txtPrivateStore.setText(SecurityFormConstants.WSO2_PRIVATESTORE);
		GridData keyslayoutData = new GridData();
		keyslayoutData.minimumWidth = 200;
		keyslayoutData.horizontalAlignment = SWT.FILL;
		keyslayoutData.grabExcessHorizontalSpace = true;
		txtPrivateStore.setLayoutData(keyslayoutData);

		txtPrivateStore.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updatePrivateStore();
				setPageDirty(true);
				updateDirtyState();
			}
		});

		createCategory(toolkit, seccomposite, SecurityFormConstants.ADVANCED_SCENARIOS);
		try {
			createSecurityScenarioOptionButtons(seccomposite, SecurityPolicyUtils.getInstance()
					.getAdvancedSecurityScenarios(), managedForm, 4, body);
		} catch (IOException | JAXBException e) {
			log.error(SecurityFormMessageConstants.MESSAGE_READ_POLICY, e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_POLICYFILE_READ_ERROR);
			msg.open();
		}

		Object[] aAdresult = CreateMainSection(toolkit, body, SecurityFormConstants.ADVANCE_CONFIGURATION, 10, 15, 600, 30, true);
		Composite rmaportInfComposite = (Composite) aAdresult[1];
		GridLayout ramportlayout = new GridLayout();
		rmaportInfComposite.setLayout(ramportlayout);

		Object[] ramBasicresult = CreateMainSection(toolkit, rmaportInfComposite, SecurityFormConstants.SECTION_RAMPART_CONFIGURATION, 10,
				20, 600, 30, true);
		Composite rampartBasic = (Composite) ramBasicresult[1];
		GridLayout ramparlayout = new GridLayout(2, false);
		rampartBasic.setLayout(ramparlayout);
		Section ramBasicSec = (Section) ramBasicresult[0];
		ramBasicSec.setExpanded(false);

		createRampartConfigUIs(managedForm, rampartBasic);

		enresult = CreateRampartSection(toolkit, rmaportInfComposite, SecurityFormConstants.SECTION_ENCRYPTION_PROPERTIES, 10, 20, 600, 30,
				true);
		Composite encryptionComposite = (Composite) enresult[1];
		GridLayout enlayout = new GridLayout(2, false);
		encryptionComposite.setLayout(enlayout);
		Section enSec = (Section) enresult[0];
		enSec.setExpanded(false);

		signresult = CreateRampartSection(toolkit, rmaportInfComposite, SecurityFormConstants.SECTION_SIGNATURE_PROPOERTIES, 10, 30, 600, 30,
				true);
		Composite signComposite = (Composite) signresult[1];
		GridLayout signlayout = new GridLayout(2, false);
		signComposite.setLayout(signlayout);
		Section signSec = (Section) signresult[0];
		signSec.setExpanded(false);

		String[] rmpartConfigs = new String[] { SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS + SecurityFormConstants.ALIAS,
				SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE + SecurityFormConstants.PRIVATESTORE, SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID + SecurityFormConstants.TENANT_ID,
				SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES + SecurityFormConstants.TRUSTSTORES, SecurityFormConstants.RAMPART_CONFIG_USER + SecurityFormConstants.USER };
		for (String name : rmpartConfigs) {
			createRampartProperties(managedForm, encryptionComposite, name, SecurityFormConstants.EN);
			createRampartProperties(managedForm, signComposite, name, SecurityFormConstants.SIGN);
		}

		// UI for Kerberos
		keberosResult = CreateSecuritySection(toolkit, body, SecurityFormConstants.SECTION_KERBEROS, 10, 70, 600, 30, true);
		Composite kerberosMainComposite = (Composite) keberosResult[1];
		GridLayout gridLayout = new GridLayout();
		kerberosMainComposite.setLayout(gridLayout);

		Composite compositeKerberos = new Composite(kerberosMainComposite, SWT.NULL);
		GridLayout basicLayout = new GridLayout(3, false);
		compositeKerberos.setLayout(basicLayout);

		toolkit.createLabel(compositeKerberos, SecurityFormConstants.LABEL_SERVICE_PRINCIPAL_NAME);

		Label nameMark = toolkit.createLabel(compositeKerberos, "*");
		Device device = Display.getCurrent();
		Color red = new Color(device, 255, 0, 0);
		nameMark.setForeground(red);

		txtPrincipalName = new Text(compositeKerberos, SWT.BORDER);
		txtPrincipalName.setBounds(new org.eclipse.swt.graphics.Rectangle(92, 40, 84, 28));
		GridData keylayoutData = new GridData();
		keylayoutData.minimumWidth = 200;
		keylayoutData.horizontalAlignment = SWT.FILL;
		keylayoutData.grabExcessHorizontalSpace = true;
		txtPrincipalName.setLayoutData(keylayoutData);
		txtPrincipalName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				carbonSecKerberosDataMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_NAME, txtPrincipalName.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		toolkit.createLabel(compositeKerberos, SecurityFormConstants.LABEL_SERVICE_PRINCIPAL_PASSWORD);

		Label passMark = toolkit.createLabel(compositeKerberos, "*");
		passMark.setForeground(red);

		txtPrincipalPassword = new Text(compositeKerberos, SWT.BORDER);
		txtPrincipalPassword.setBounds(new org.eclipse.swt.graphics.Rectangle(92, 40, 84, 28));
		GridData keyplayoutData = new GridData();
		keyplayoutData.minimumWidth = 200;
		keyplayoutData.horizontalAlignment = SWT.FILL;
		keyplayoutData.grabExcessHorizontalSpace = true;
		txtPrincipalPassword.setLayoutData(keyplayoutData);
		carbonSecKerberosControlMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD, txtPrincipalPassword);
		txtPrincipalPassword.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				carbonSecKerberosDataMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD, txtPrincipalPassword.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		try {
			String initalContent = convertXMLFileToString(inputFile);
			updateSecurityOptionButtons(initalContent, resultService, enresult, signresult, keberosResult);
			updateRampartUIAndUserRolesWithChanges(initalContent);
			setPageDirty(false);
			updateDirtyState();
		} catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
			log.error(SecurityFormMessageConstants.MESSAGE_LOAD_PAGE, e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_PAGE_LOADING_ERROR);
			msg.open();
		}
	}

	private Object[] CreateRampartSection(FormToolkit toolkit, final Composite body, String sectionName, final int x,
			final int y, final int width, final int height, boolean expand) {

		Object[] comp = new Object[2];
		final Section sctnCreate = toolkit.createSection(body, Section.TWISTIE | Section.TITLE_BAR);
		sctnCreate.setBounds(x, y, width, height);
		toolkit.paintBordersFor(sctnCreate);
		sctnCreate.setText(sectionName);
		sctnCreate.setExpanded(expand);
		sctnCreate.setVisible(false);

		sctnCreate.addExpansionListener(new IExpansionListener() {

			@Override
			public void expansionStateChanging(ExpansionEvent e) {
			}

			@Override
			public void expansionStateChanged(ExpansionEvent e) {

			}
		});
		comp[0] = sctnCreate;
		Composite composite = toolkit.createComposite(sctnCreate, SWT.NULL);
		toolkit.paintBordersFor(composite);
		sctnCreate.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		comp[1] = composite;

		return comp;
	}

	private Object[] CreateSecuritySection(FormToolkit toolkit, final Composite body, String sectionName, final int x,
			final int y, final int width, final int height, boolean expand) {

		Object[] comp = new Object[2];
		final Section sctnCreate = toolkit.createSection(body, Section.TWISTIE | Section.TITLE_BAR);
		sctnCreate.setBounds(x, y, width, height);
		toolkit.paintBordersFor(sctnCreate);
		sctnCreate.setText(sectionName);
		sctnCreate.setExpanded(expand);
		sctnCreate.setVisible(false);

		sctnCreate.addExpansionListener(new IExpansionListener() {

			@Override
			public void expansionStateChanging(ExpansionEvent e) {
			}

			@Override
			public void expansionStateChanged(ExpansionEvent e) {

			}
		});
		comp[0] = sctnCreate;
		Composite composite = toolkit.createComposite(sctnCreate, SWT.NULL);
		toolkit.paintBordersFor(composite);
		sctnCreate.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		comp[1] = composite;

		return comp;
	}

	private void createRampartConfigUIs(IManagedForm managedForm, Composite rampartBasic) {

		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_USER);
		txtRampartUser = managedForm.getToolkit().createText(rampartBasic, "");
		GridData rmUserlayoutData = new GridData();
		rmUserlayoutData.minimumWidth = 200;
		rmUserlayoutData.horizontalAlignment = SWT.FILL;
		rmUserlayoutData.grabExcessHorizontalSpace = true;
		txtRampartUser.setLayoutData(rmUserlayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_USER, txtRampartUser);

		txtRampartUser.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_USER, txtRampartUser.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_ENCRYPTION_USER);
		txtRampartEncryptionUser = managedForm.getToolkit().createText(rampartBasic, "");
		GridData encryptionUserlayoutData = new GridData();
		encryptionUserlayoutData.minimumWidth = 200;
		encryptionUserlayoutData.horizontalAlignment = SWT.FILL;
		encryptionUserlayoutData.grabExcessHorizontalSpace = true;
		txtRampartEncryptionUser.setLayoutData(encryptionUserlayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, txtRampartEncryptionUser);

		txtRampartEncryptionUser.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, txtRampartEncryptionUser.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		String[] values = new String[] { SecurityFormConstants.VALUE_FALSE, SecurityFormConstants.VALUE_TRUE };
		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_PRECISION);
		cmbRampartTimestampPrecision = new Combo(rampartBasic, SWT.READ_ONLY);
		cmbRampartTimestampPrecision.setItems(values);
		GridData timestampPrecisionInMillisecondslayoutData = new GridData();
		timestampPrecisionInMillisecondslayoutData.minimumWidth = 200;
		timestampPrecisionInMillisecondslayoutData.horizontalAlignment = SWT.FILL;
		timestampPrecisionInMillisecondslayoutData.grabExcessHorizontalSpace = true;
		cmbRampartTimestampPrecision.setLayoutData(timestampPrecisionInMillisecondslayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS, cmbRampartTimestampPrecision);

		cmbRampartTimestampPrecision.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,
						cmbRampartTimestampPrecision.getItem(cmbRampartTimestampPrecision.getSelectionIndex()));
				setPageDirty(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TIMESTAMP_TTL);
		txtRampartMinTTL = managedForm.getToolkit().createText(rampartBasic, " ");
		GridData timestampTTLlayoutData = new GridData();
		timestampTTLlayoutData.minimumWidth = 200;
		timestampTTLlayoutData.horizontalAlignment = SWT.FILL;
		timestampTTLlayoutData.grabExcessHorizontalSpace = true;
		txtRampartMinTTL.setLayoutData(timestampTTLlayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, txtRampartMinTTL);

		txtRampartMinTTL.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, txtRampartMinTTL.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TIMESTAMP_MAX);
		txtRampartTimestampMaxSkew = managedForm.getToolkit().createText(rampartBasic, "");
		GridData timestampMaxSkewlayoutData = new GridData();
		timestampMaxSkewlayoutData.minimumWidth = 200;
		timestampMaxSkewlayoutData.horizontalAlignment = SWT.FILL;
		timestampMaxSkewlayoutData.grabExcessHorizontalSpace = true;
		txtRampartTimestampMaxSkew.setLayoutData(timestampMaxSkewlayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, txtRampartTimestampMaxSkew);

		txtRampartTimestampMaxSkew.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, txtRampartTimestampMaxSkew.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TIMESTAMP_STRICT);
		cmbRampartTimestampStrict = new Combo(rampartBasic, SWT.READ_ONLY);
		cmbRampartTimestampStrict.setItems(values);
		GridData timestampStrictlayoutData = new GridData();
		timestampStrictlayoutData.minimumWidth = 200;
		timestampStrictlayoutData.horizontalAlignment = SWT.FILL;
		timestampStrictlayoutData.grabExcessHorizontalSpace = true;
		cmbRampartTimestampStrict.setLayoutData(timestampStrictlayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT, cmbRampartTimestampStrict);

		cmbRampartTimestampStrict.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT,
						cmbRampartTimestampStrict.getItem(cmbRampartTimestampStrict.getSelectionIndex()));
				setPageDirty(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_TOKEN_STORE_CLASS);
		txtRampartTokenStoreClass = managedForm.getToolkit().createText(rampartBasic, "");
		GridData tokenStoreClasslayoutData = new GridData();
		tokenStoreClasslayoutData.minimumWidth = 200;
		tokenStoreClasslayoutData.horizontalAlignment = SWT.FILL;
		tokenStoreClasslayoutData.grabExcessHorizontalSpace = true;
		txtRampartTokenStoreClass.setLayoutData(tokenStoreClasslayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, txtRampartTokenStoreClass);

		txtRampartTokenStoreClass.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, txtRampartTokenStoreClass.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, SecurityFormConstants.LABEL_NONCELIFETIME);
		txtRampartNonceLifeTime = managedForm.getToolkit().createText(rampartBasic, "");
		GridData nonceLifeTimelayoutData = new GridData();
		nonceLifeTimelayoutData.minimumWidth = 200;
		nonceLifeTimelayoutData.horizontalAlignment = SWT.FILL;
		nonceLifeTimelayoutData.grabExcessHorizontalSpace = true;
		txtRampartNonceLifeTime.setLayoutData(nonceLifeTimelayoutData);
		rampartControlMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, txtRampartNonceLifeTime);

		txtRampartNonceLifeTime.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, txtRampartNonceLifeTime.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});
	}

	/**
	 * Saves the configuration to the file
	 * 
	 * @throws InterruptedException
	 */
	private void save() throws InterruptedException {
		try {
			// Adds the policy
			addPolicy();

			// Update data maps with user inputs
			updateDataMapsWithUserInputs();

			// Updates the source view
			updateSourceConfiguration();
			// Saves the final output to the inputFile
			saveFinalConfigToFile();
			
			RefreshProject();

			/*
			 * display.asyncExec(new Runnable() {
			 * 
			 * @Override public void run() { try { RefreshProject(); } catch
			 * (CoreException e) { log.error("Error in refresing the project",
			 * e); } } });
			 */

		} catch (JAXBException | IOException | CoreException | ParserConfigurationException | SAXException
				| TransformerException e) {
			log.error("Saving Error", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_SAVE_ERROR);
			msg.open();
		}
	}

	/**
	 * Updates the source view at page change
	 * 
	 * @throws InterruptedException
	 */
	private void updateSource() throws InterruptedException {

		try {
			// Adds the policy
			addPolicy();
			// Update data maps with user inputs
			updateDataMapsWithUserInputs();
			// Updates the source view
			updateSourceConfiguration();

		} catch (JAXBException | IOException | CoreException | ParserConfigurationException | SAXException
				| TransformerException e) {
			log.error(SecurityFormMessageConstants.MESSAGE_SAVE, e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_SAVE_ERROR);
			msg.open();
		}
	}

	/**
	 * Adds the policy
	 * 
	 * @throws JAXBException
	 * @throws IOException
	 * @throws PropertyException
	 * @throws CoreException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws TransformerException
	 */
	private void addPolicy() throws JAXBException, IOException, PropertyException, CoreException,
			ParserConfigurationException, SAXException, TransformerException {

		SecurityTemplateUtil secTemplateUtil = new SecurityTemplateUtil();
		String filename = SecurityFormConstants.POLICIES + policyFileName;
		policyTemplateFile = secTemplateUtil.getResourceFile(filename);
		String content = convertXMLFileToString(policyTemplateFile);

		policyTemplateStream = new ByteArrayInputStream(content.getBytes());
		closeInputStream(policyTemplateStream);

		if (policyTemplateFile != null) {
			Unmarshaller pUnmarshaller = getUnmarsheller();
			policyObject = (Policy2) pUnmarshaller.unmarshal(policyTemplateStream);

			// Define roles in UsernameToken based security policies.
			if (utRoles != null && utRoles.size() > 0) {
				if (StringUtils.isNotBlank(selectedPolicy)
						&& (SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy)
								|| SecurityPolicies.POLICY_TYPE_7.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_8
									.equals(selectedPolicy))) {

					allowRoles = getAllowRoles();
					if (StringUtils.isNotBlank(allowRoles)) {
						carbonSecAuthControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES, allowRoles);
					}

				}

				if (StringUtils.isNotBlank(selectedPolicy)
						&& (SecurityPolicies.POLICY_TYPE_14.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_15
								.equals(selectedPolicy))) {

					allowRoles = getAllowRoles();
					if (StringUtils.isNotBlank(allowRoles)) {
						carbonSecAuthControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES, allowRoles);
					}

					carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS,
							encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS));
					carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE,
							encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE));
					carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES,
							encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES));

				}

			} else {
				carbonSecAuthControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES, null);
				carbonSecAuthDataMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES, null);
			}

			if (StringUtils.isNotBlank(selectedPolicy) && (SecurityPolicies.POLICY_TYPE_16.equals(selectedPolicy))) {

				if (!StringUtils.isEmpty(txtPrincipalName.getText())) {
					carbonSecKerberosControlMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_NAME, txtPrincipalName);
				} else {
					carbonSecKerberosControlMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD, null);
					carbonSecKerberosDataMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD, null);
				}

				if (!StringUtils.isEmpty(txtPrincipalPassword.getText())) {
					carbonSecKerberosControlMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD, txtPrincipalPassword);
				} else {
					carbonSecKerberosControlMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_NAME, null);
					carbonSecKerberosDataMap.put(SecurityFormConstants.SERVICE_PRINCIPAL_NAME, null);
				}
			}

			if (StringUtils.isNotBlank(selectedPolicy)
					&& (SecurityPolicies.POLICY_TYPE_9.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_10.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_11.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_12.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_13.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_17.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_18.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_19.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_20
								.equals(selectedPolicy))) {

				carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS,
						encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS));
				carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE,
						encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE));
				carbonSecTrustControlMap.put(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES,
						encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES));

			}
		}
	}

	/**
	 * Get allow roles in role1,role2, format.
	 * 
	 * @return roles
	 */
	private static String getAllowRoles() {
		String allowRoles = "";

		for (int i = 0; i < utRoles.size(); i++) {
			if (i == utRoles.size() - 1) {
				allowRoles += utRoles.get(i);
			} else {
				allowRoles += utRoles.get(i) + ",";
			}
		}
		return allowRoles;
	}

	/**
	 * Saves the data maps with user values
	 */
	private void updateDataMapsWithUserInputs() {

		Set<String> keySet = encryptControlMap.keySet();
		for (String key : keySet) {
			Object control = encryptControlMap.get(key);
			if (control instanceof Text) {
				Text controlText = (Text) control;
				encryptDataMap.put(key, controlText.getText());
			}
		}

		keySet = signControlMap.keySet();
		for (String key : keySet) {
			Object control = signControlMap.get(key);
			if (control instanceof Text) {
				Text controlText = (Text) control;
				signDataMap.put(key, controlText.getText());
			}
		}

		keySet = carbonSecAuthControlMap.keySet();
		for (String key : keySet) {
			String control = carbonSecAuthControlMap.get(key);
			if (!StringUtils.isEmpty(control)) {
				carbonSecAuthDataMap.put(key, control);
			}
		}

		keySet = carbonSecTrustControlMap.keySet();
		for (String key : keySet) {
			Object control = carbonSecTrustControlMap.get(key);
			if (control instanceof Text) {
				Text controlText = (Text) control;
				carbonSecTrustDataMap.put(key, controlText.getText());
			}
		}

		keySet = carbonSecKerberosControlMap.keySet();
		for (String key : keySet) {
			Object control = carbonSecKerberosControlMap.get(key);
			if (control instanceof Text) {
				Text controlText = (Text) control;
				carbonSecKerberosDataMap.put(key, controlText.getText());
			}
		}
	}

	/**
	 * Updates the source with changes
	 * 
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private void updateSourceConfiguration() throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilder dBuilder = getDocumentBuilder();
		doc = dBuilder.parse(policyTemplateFile);

		policyID = policyObject.getId();

		boolean isKerberossignandencrypt = policyID.equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT);

		Node nrampart = doc.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG).item(0);
		rampart = (Element) nrampart;

		Node nsec = doc.getElementsByTagName(SecurityFormConstants.CARBONSEC_CONFIG).item(0);
		secElement = (Element) nsec;

		if (!isKerberossignandencrypt) {
			Node user = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_USER).item(0);
			if (user != null) {
				user.setTextContent(rampartDataMap.get(SecurityFormConstants.RAMPART_USER));
			}

			Node encryptionUser = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_ENCRYPTION_USER).item(0);
			if (encryptionUser != null && StringUtils.isNotBlank(rampartDataMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER))) {
				encryptionUser.setTextContent(rampartDataMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER));
			}
		}

		Node timestampPrecisionInMilliseconds = rampart.getElementsByTagName(
				SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
		if (timestampPrecisionInMilliseconds != null
				&& StringUtils.isNotBlank(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS))) {
			timestampPrecisionInMilliseconds.setTextContent(rampartDataMap
					.get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS));
		}

		Node timestampTTL = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_TTL).item(0);
		if (timestampTTL != null && StringUtils.isNotBlank(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL))) {
			timestampTTL.setTextContent(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL));
		}

		Node timestampMaxSkew = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW).item(0);
		if (timestampMaxSkew != null && StringUtils.isNotBlank(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW))) {
			timestampMaxSkew.setTextContent(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW));
		}

		Node timestampStrict = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT).item(0);
		if (timestampStrict != null && StringUtils.isNotBlank(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT))) {
			timestampStrict.setTextContent(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT));
		}

		if (!isKerberossignandencrypt) {
			Node tokenStoreClass = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS).item(0);
			tokenStoreClass.setTextContent(rampartDataMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS));
		}

		Node nonceLifeTime = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME).item(0);
		if (nonceLifeTime != null && StringUtils.isNotBlank(rampartDataMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME))) {
			nonceLifeTime.setTextContent(rampartDataMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME));
		}

		if (!isKerberossignandencrypt) {
			Node encryptionCrypto = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_ENCRYPTION_CRYPTO).item(0);
			if (encryptionCrypto != null) {
				setenCryto(encryptionCrypto, encryptDataMap);
			}

			Node signatureCrypto = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_SIGNATURE_CRYPTO).item(0);
			if (signatureCrypto != null) {
				setenCryto(signatureCrypto, signDataMap);
			}
			if (secElement != null) {
				Node carbonAuth = secElement.getElementsByTagName(SecurityFormConstants.CARBONSEC_AUTHORIZATION).item(0);
				if (carbonAuth != null) {
					setSecAuthorization(carbonAuth, carbonSecAuthDataMap);
				}
				Node carbonTrust = secElement.getElementsByTagName(SecurityFormConstants.CARBONSEC_TRUST).item(0);
				if (carbonTrust != null) {
					setSecTrust(carbonTrust, carbonSecTrustDataMap);
				}
			}

		} else {
			Node kerberosConfig = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_KERBEROS_CONFIG).item(0);
			if (kerberosConfig != null) {
				setKerberosRampartConfig(kerberosConfig, carbonSecKerberosDataMap);
			}

			if (secElement != null) {
				Node kerberosSec = secElement.getElementsByTagName(SecurityFormConstants.CARBON_KEBEROS).item(0);
				if (kerberosSec != null) {
					setKerberosSecConfig(kerberosSec, carbonSecKerberosDataMap);
				}
			}
		}
	}

	/**
	 * Gets the document builder
	 * 
	 * @return dBuilder document builder
	 * @throws ParserConfigurationException
	 */
	private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		return dBuilder;
	}

	/**
	 * Gets the transformer
	 * 
	 * @return transformer transformer
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 */
	private Transformer getTransformer() throws TransformerFactoryConfigurationError, TransformerConfigurationException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		return transformer;
	}

	/**
	 * Closes the input stream
	 * 
	 * @param stream
	 */
	private void closeInputStream(InputStream stream) {

		try {
			stream.close();
		} catch (IOException e) {
			log.error("Error in closing the input stream", e);
		}
	}

	/**
	 * Gets the unmarshaller
	 * 
	 * @return unmarshaller unmarshaller
	 * @throws JAXBException
	 */
	private Unmarshaller getUnmarsheller() throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(Policy2.class);
		Unmarshaller uUnmarshaller = jaxbContext.createUnmarshaller();
		return uUnmarshaller;
	}

	/**
	 * Saves the final configurations to the file
	 * 
	 * @throws TransformerException
	 */
	private void saveFinalConfigToFile() throws TransformerException {

		Transformer transformer = getTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(inputFile);
		transformer.transform(source, result);
	}

	/**
	 * Gets the updated content of the source
	 * 
	 * @return content
	 * @throws TransformerException
	 */
	private String getUpdatedContent() throws TransformerException {

		Transformer transformer = getTransformer();
		StringWriter stw = new StringWriter();
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, new StreamResult(stw));
		return stw.toString();

	}

	/**
	 * Updates the Private store and trust store
	 */
	private void updatePrivateStore() {

		if (encryptControlMap.size() > 0 && signControlMap.size() > 0) {
			// encryption properties
			encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(txtPrivateStore.getText());
			encryptControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(txtPrivateStore.getText());

			// signature properties
			signControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(txtPrivateStore.getText());
			signControlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(txtPrivateStore.getText());
		}
	}

	/**
	 * Updates the RampartUI with new values
	 * 
	 * @param alise
	 *            alias value
	 * @param serviceMetaFile
	 *            Service meta file
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	private void updateRampartUIAndUserRolesWithChanges(String source) throws ParserConfigurationException,
			SAXException, IOException {

		// Gets rampart config values from the source view

		InputStream rampartStream = new ByteArrayInputStream(source.getBytes());
		getRampartValuesFromSource(rampartStream);
		closeInputStream(rampartStream);

		// Gets rampart encryption and sign values from source view
		InputStream cryptotStream = new ByteArrayInputStream(source.getBytes());
		getRampartEncryptionSignUserRoleValuesFromSource(cryptotStream);
		closeInputStream(cryptotStream);

		// Gets Kerberos values from the source view
		InputStream kerberosStream = new ByteArrayInputStream(source.getBytes());
		getKerberosValuesFromSource(kerberosStream);
		closeInputStream(kerberosStream);

		// updates rampart ui
		Text txtRampartProperties = (Text) rampartControlMap.get(SecurityFormConstants.RAMPART_USER);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_USER) != null && txtRampartProperties != null) {
			txtRampartProperties.setText(rampartDataMap.get(SecurityFormConstants.RAMPART_USER));
		} else if (txtRampartProperties != null) {
			txtRampartProperties.setText("");
		}

		txtRampartProperties = (Text) rampartControlMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER) != null && txtRampartProperties != null) {
			txtRampartProperties.setText(rampartDataMap.get(SecurityFormConstants.RAMPART_ENCRYPTION_USER));
		} else if (txtRampartProperties != null) {
			txtRampartProperties.setText("");
		}

		txtRampartProperties = (Text) rampartControlMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL) != null && txtRampartProperties != null) {
			txtRampartProperties.setText(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_TTL));
		} else if (txtRampartProperties != null) {
			txtRampartProperties.setText("");
		}

		txtRampartProperties = (Text) rampartControlMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW) != null && txtRampartProperties != null) {
			txtRampartProperties.setText(rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW));
		} else if (txtRampartProperties != null) {
			txtRampartProperties.setText("");
		}

		txtRampartProperties = (Text) rampartControlMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS) != null && txtRampartProperties != null) {
			txtRampartProperties.setText(rampartDataMap.get(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS));
		} else if (txtRampartProperties != null) {
			txtRampartProperties.setText("");
		}

		txtRampartProperties = (Text) rampartControlMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME) != null && txtRampartProperties != null) {
			txtRampartProperties.setText(rampartDataMap.get(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME));
		} else if (txtRampartProperties != null) {
			txtRampartProperties.setText("");
		}

		Combo cmbRampartTimeStampProperty = (Combo) rampartControlMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS) != null
				&& cmbRampartTimeStampProperty != null) {
			if (rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).equals(SecurityFormConstants.VALUE_FALSE)) {
				cmbRampartTimeStampProperty.select(0); // Index 0
			} else {
				cmbRampartTimeStampProperty.select(1); // Index 1
			}
		}

		cmbRampartTimeStampProperty = (Combo) rampartControlMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT);
		if (rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT) != null && cmbRampartTimeStampProperty != null) {
			if (rampartDataMap.get(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT).equals(SecurityFormConstants.VALUE_FALSE)) {
				cmbRampartTimeStampProperty.select(0); // Index 0
			} else {
				cmbRampartTimeStampProperty.select(1);// Index 1
			}
		}

		// encrypt values
		updateCryptoUIWithChanges(encryptDataMap, encryptControlMap);

		// sign values
		updateCryptoUIWithChanges(signDataMap, signControlMap);

		// kerberos values
		updateKerberosUIWithChanges(carbonSecKerberosDataMap, carbonSecKerberosControlMap);
	}

	/**
	 * Updates crypto UI
	 * 
	 * @param dataMap
	 *            data map
	 * @param controlMap
	 *            ui map
	 */
	private void updateCryptoUIWithChanges(Map<String, String> dataMap, Map<String, Text> controlMap) {
		if (controlMap.size() > 0) {
			if (dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE) != null) {
				controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(
						dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE));
			} else {
				controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText("");

			}
			if (dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES) != null) {
				controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(
						dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES));
			} else {
				controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText("");

			}
			if (dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS) != null) {
				controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText(
						dataMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS));
			} else {
				controlMap.get(SecurityFormConstants.ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText("");

			}
			if (dataMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID) != null) {
				controlMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID).setText(dataMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID));
			} else {
				controlMap.get(SecurityFormConstants.ORG_WSO2_STRATOS_TENANT_ID).setText("");

			}
			if (dataMap.get(SecurityFormConstants.RAMPART_CONFIG_USER) != null) {
				controlMap.get(SecurityFormConstants.RAMPART_CONFIG_USER).setText(dataMap.get(SecurityFormConstants.RAMPART_CONFIG_USER));
			} else {
				controlMap.get(SecurityFormConstants.RAMPART_CONFIG_USER).setText("");
			}
		}
	}

	/**
	 * Updates Kerberos UI
	 * 
	 * @param dataMap
	 *            data map
	 * @param controlMap
	 *            ui map
	 */
	private void updateKerberosUIWithChanges(Map<String, String> dataMap, Map<String, Text> controlMap) {

		if (controlMap.size() > 0 && dataMap.size() > 0) {
			if (!StringUtils.isEmpty(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME))
					&& controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME) != null) {
				controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME).setText(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME));
			} else if (controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME) != null) {
				controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_NAME).setText("");
			}
			if (!StringUtils.isEmpty(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD))
					&& controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD) != null) {
				controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD).setText(dataMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD));
			} else if (controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD) != null) {
				controlMap.get(SecurityFormConstants.SERVICE_PRINCIPAL_PASSWORD).setText("");

			}
		}

	}

	/**
	 * Updates security options on page change
	 * 
	 * @param source
	 *            content
	 * @param keberosResult2
	 * @param signresult2
	 * @param enresult2
	 * @param body
	 *            body
	 * @param toolkit
	 *            managed form
	 * @throws JAXBException
	 */
	private void updateSecurityOptionButtons(String source, Object[] resultService, Object[] enresult,
			Object[] signresult, Object[] keberosResult) throws JAXBException {

		Unmarshaller uUnmarshaller = getUnmarsheller();
		InputStream inputStream = new ByteArrayInputStream(source.getBytes());
		policyObject = (Policy2) uUnmarshaller.unmarshal(inputStream);
		closeInputStream(inputStream);
		if (resultService != null || enresult != null || signresult != null || keberosResult != null) {
			Section result = (Section) resultService[0];
			Section encrypt = (Section) enresult[0];
			Section signResult = (Section) signresult[0];
			Section kebSection = (Section) keberosResult[0];
			// TOOLS-2772
			if (policyObject.getId().equals(SecurityFormConstants.POLICY_OBJECT_UT)) {
				result.setVisible(false);
				encrypt.setVisible(false);
				signResult.setVisible(false);
				kebSection.setVisible(false);
			} else if (policyObject.getId().equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT)) {
				result.setVisible(false);
				encrypt.setVisible(false);
				signResult.setVisible(false);
				kebSection.setVisible(true);
			} else {
				result.setVisible(true);
				encrypt.setVisible(true);
				signResult.setVisible(true);
				kebSection.setVisible(false);
			}
		}
		Button button = policyeMap.get(policyObject.getId());
		if (button != null) {
			button.setSelection(true);
			enableUserRoleButton(button);
			policyFileName = (String) button.getData();
			selectedPolicy = SecurityPolicyUtils.getInstance().getPolicyTypeFromPolicyUUID(policyObject.getId());
		}
	}

	/**
	 * Creates RampartProperties
	 * 
	 * @param managedForm
	 *            form
	 * @param enComposite
	 *            composite
	 * @param fullname
	 *            name
	 * @param prefix
	 *            prefix
	 */
	private void createRampartProperties(IManagedForm managedForm, Composite enComposite, String fullname, String prefix) {

		String[] split = fullname.split(":");
		String name = split[1];
		managedForm.getToolkit().createLabel(enComposite, name + ":");
		Text en = managedForm.getToolkit().createText(enComposite, " ");
		GridData enlayoutData = new GridData();
		enlayoutData.minimumWidth = 200;
		enlayoutData.horizontalAlignment = SWT.FILL;
		enlayoutData.grabExcessHorizontalSpace = true;
		en.setLayoutData(enlayoutData);
		en.setData(name, split[0]);
		// en.setd
		if (SecurityFormConstants.EN.equals(prefix)) {
			encryptControlMap.put(split[0], en);
		} else {
			signControlMap.put(split[0], en);
		}
		en.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setPageDirty(true);
				updateDirtyState();
			}
		});

	}

	/**
	 * Convert XML to string
	 * 
	 * @param resourceFile
	 *            file
	 * @return
	 */
	private String convertXMLFileToString(File resourceFile) {

		StringWriter stw = new StringWriter();
		try {
			DocumentBuilder dBuilder = getDocumentBuilder();
			InputStream inputStream = new FileInputStream(resourceFile);
			org.w3c.dom.Document doc = dBuilder.parse(inputStream);
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			serializer.setOutputProperty("omit-xml-declaration", "yes");
			serializer.transform(new DOMSource(doc), new StreamResult(stw));
		} catch (TransformerException | SAXException | IOException | ParserConfigurationException
				| TransformerFactoryConfigurationError e) {
			log.error(SecurityFormMessageConstants.MESSAGE_XML_ERROR, e);
		}
		return stw.toString();
	}

	/**
	 * Refreshes the project
	 * 
	 * @throws CoreException
	 */
	public void RefreshProject() throws CoreException {
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	/**
	 * Updates the rampart configuration data map
	 * 
	 * @param uiContentStream
	 *            input stream
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void getRampartValuesFromSource(InputStream uiContentStream) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilder dBuilder = getDocumentBuilder();

		doc = dBuilder.parse(uiContentStream);
		policyID = policyObject.getId();

		boolean isKerberossignandencrypt = policyID.equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT);

		Node nrampart = doc.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG).item(0);
		rampart = (Element) nrampart;

		if (!isKerberossignandencrypt) {
			Node user = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_USER).item(0);
			if (user != null) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_USER, user.getTextContent());
			}

			Node encryptionUser = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_ENCRYPTION_USER).item(0);
			if (encryptionUser != null) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_ENCRYPTION_USER, encryptionUser.getTextContent());
			}

		} else {
			// rampart:kerberosConfig
			Node kerberosConfig = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_KERBEROS_CONFIG).item(0);
			if (kerberosConfig != null) {
				addRampartKerberosConfigPropertis(kerberosConfig);
			}
		}

		Node timestampPrecisionInMilliseconds = rampart.getElementsByTagName(
				SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
		if (timestampPrecisionInMilliseconds != null) {
			rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,
					timestampPrecisionInMilliseconds.getTextContent());
		}

		Node timestampTTL = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_TTL).item(0);
		if (timestampTTL != null) {
			rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_TTL, timestampTTL.getTextContent());
		}

		Node timestampMaxSkew = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW).item(0);
		if (timestampMaxSkew != null) {
			rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_MAX_SKEW, timestampMaxSkew.getTextContent());
		}

		Node timestampStrict = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT).item(0);
		if (timestampStrict != null) {
			rampartDataMap.put(SecurityFormConstants.RAMPART_TIMESTAMP_STRICT, timestampStrict.getTextContent());
		}

		if (!isKerberossignandencrypt) {
			Node tokenStoreClass = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS).item(0);
			if (tokenStoreClass != null) {
				rampartDataMap.put(SecurityFormConstants.RAMPART_TOKEN_STORE_CLASS, tokenStoreClass.getTextContent());
			}
		}

		Node nonceLifeTime = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME).item(0);
		if (nonceLifeTime != null) {
			rampartDataMap.put(SecurityFormConstants.RAMPART_NONCE_LIFE_TIME, nonceLifeTime.getTextContent());
		}
	}

	/**
	 * Updates the encryption data map
	 * 
	 * @param uiContentStream
	 *            input stream
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void getRampartEncryptionSignUserRoleValuesFromSource(InputStream uiContentStream)
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilder dBuilder = getDocumentBuilder();
		doc = dBuilder.parse(uiContentStream);
		policyID = policyObject.getId();

		boolean isKerberossignandencrypt = policyID.equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT);

		Node nrampart = doc.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG).item(0);
		rampart = (Element) nrampart;

		Node nsec = doc.getElementsByTagName(SecurityFormConstants.CARBONSEC_CONFIG).item(0);
		secElement = (Element) nsec;

		if (!isKerberossignandencrypt) {
			Node encryptionCrypto = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_ENCRYPTION_CRYPTO).item(0);
			if (encryptionCrypto != null) {
				encryptDataMap = addRampartCryptoProperties(encryptionCrypto);
			}

			// rampart:signatureCrypto
			Node signatureCrypto = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_SIGNATURE_CRYPTO).item(0);
			if (signatureCrypto != null) {
				signDataMap = addRampartCryptoProperties(signatureCrypto);
			}

			if (secElement != null) {
				Node secAuth = secElement.getElementsByTagName(SecurityFormConstants.CARBONSEC_AUTHORIZATION).item(0);
				if (secAuth != null) {
					carbonSecAuthDataMap = addCarbonAuthProperties(secAuth);
				}
			}

		}

	}

	/**
	 * Updates the kerberos data map
	 * 
	 * @param uiContentStream
	 *            input stream
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void getKerberosValuesFromSource(InputStream uiContentStream) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilder dBuilder = getDocumentBuilder();
		doc = dBuilder.parse(uiContentStream);
		policyID = policyObject.getId();

		boolean isKerberossignandencrypt = policyID.equals(SecurityFormConstants.KERBEROSSIGNANDENCRYPT);

		Node nrampart = doc.getElementsByTagName(SecurityFormConstants.RAMPART_CONFIG).item(0);
		rampart = (Element) nrampart;

		Node nsec = doc.getElementsByTagName(SecurityFormConstants.CARBONSEC_CONFIG).item(0);
		secElement = (Element) nsec;

		if (isKerberossignandencrypt) {
			Node rampartKerberos = rampart.getElementsByTagName(SecurityFormConstants.RAMPART_KERBEROS_CONFIG).item(0);
			if (rampartKerberos != null) {
				carbonSecKerberosDataMap = addKerberosProperties(rampartKerberos);
			}

			if (secElement != null) {
				Node secKerberos = secElement.getElementsByTagName(SecurityFormConstants.CARBON_KEBEROS).item(0);
				if (secKerberos != null) {
					carbonSecKerberosDataMap = addKerberosProperties(secKerberos);
				}
			}

		}

	}

	/**
	 * Add rampart:encryptionCrypto or rampart:signatureCrypto properties.
	 * 
	 * @param crypto
	 *            crypto node
	 */
	private static Map<String, String> addRampartCryptoProperties(Node crypto) {

		Map<String, String> cryptoMap = new HashMap<>();
		Node encrypto = ((Element) crypto).getElementsByTagName(SecurityFormConstants.RAMPART_CRYPTO).item(0);

		NodeList list = ((Element) encrypto).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				cryptoMap.put(attribute, eElement.getTextContent());
			}
		}
		return cryptoMap;
	}

	/**
	 * Add rampart:kerberosConfig or rampart:signatureCrypto properties.
	 * 
	 * @param crypto
	 *            crypto node
	 */
	private Map<String, String> addKerberosProperties(Node kerberos) {

		Map<String, String> kerberosMap = new HashMap<>();
		NodeList list = kerberos.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				kerberosMap.put(attribute, eElement.getTextContent());
				if (carbonSecKerberosControlMap.get(attribute) != null) {
					carbonSecKerberosControlMap.get(attribute).setText(eElement.getTextContent());
				}
				if (StringUtils.isEmpty(eElement.getTextContent())) {
					if (attribute.equals(SecurityFormConstants.SERVICE_PRINCIPAL_NAME)) {
						setPageDirty(true);
						updateDirtyState();
						MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
						msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_NAME);
						msgBox.open();
					} else {
						setPageDirty(true);
						updateDirtyState();
						MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
						msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_PASSWORD);
						msgBox.open();

					}
				}
			}
		}
		return kerberosMap;
	}

	/**
	 * Add sec:Authorization properties.
	 * 
	 * @param secAuth
	 *            secAuth node
	 */
	private static Map<String, String> addCarbonAuthProperties(Node secAuth) {

		Map<String, String> secAuthMap = new HashMap<>();

		NodeList list = secAuth.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				/*
				 * Update the relevent maps and role vale when changing the
				 * userRole value from the source view
				 */
				secAuthMap.put(attribute, eElement.getTextContent());
				carbonSecAuthControlMap.put(attribute, eElement.getTextContent());
				if (utRoles == null) {
					utRoles = new ArrayList<String>();
				} else {
					utRoles.clear();
					utRoles.add(eElement.getTextContent());
					allowRoles = getAllowRoles();
				}

				/*
				 * Update the relevent maps and role vale when removing the
				 * userRole value from the source view
				 */
				if (StringUtils.isEmpty(eElement.getTextContent())) {
					utRoles.clear();
					carbonSecAuthControlMap.put(attribute, null);
					carbonSecAuthDataMap.put(attribute, null);
				}
			}
		}
		return secAuthMap;
	}

	/**
	 * Add rampart:kerberosConfig properties.
	 * 
	 * @param kerberosConfig
	 *            kerberos node
	 */
	private static void addRampartKerberosConfigPropertis(Node kerberosConfig) {

		NodeList list = ((Element) kerberosConfig).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				rampartDataMap.put(attribute, eElement.getTextContent());
			}
		}
	}

	/**
	 * Sets the encryption and sign values
	 * 
	 * @param encryptionCrypto
	 *            node encrypto
	 * @param cryptoMap
	 *            map
	 */
	private static void setenCryto(Node encryptionCrypto, Map<String, String> cryptoMap) {

		Node encrypto = ((Element) encryptionCrypto).getElementsByTagName(SecurityFormConstants.RAMPART_CRYPTO).item(0);
		NodeList list = ((Element) encrypto).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				if (StringUtils.isNotBlank(attribute)) {
					node.setTextContent(cryptoMap.get(attribute));
				}
			}
		}
	}

	/**
	 * Sets the security authorization
	 * 
	 * @param carbonSecurity
	 *            node carbonSecurity
	 * @param carbonAuthMap
	 *            map
	 */
	private static void setSecAuthorization(Node carbonSecurity, Map<String, String> carbonAuthMap) {

		NodeList list = carbonSecurity.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				if (StringUtils.isNotBlank(attribute)) {
					if (!StringUtils.isEmpty(carbonAuthMap.get(attribute))) {
						node.setTextContent(carbonAuthMap.get(attribute));
						if (utRoles == null) {
							utRoles.add(carbonAuthMap.get(attribute));
						}
					} else {
						// Remove the sec: tag when User Role value is empty
						if (SecurityPolicies.POLICY_TYPE_14.equals(selectedPolicy)
								|| SecurityPolicies.POLICY_TYPE_15.equals(selectedPolicy)) {
							node.getParentNode().getParentNode().removeChild(carbonSecurity);
							allowRoles = null;
						} else {
							node.getParentNode().getParentNode().getParentNode()
									.removeChild(carbonSecurity.getParentNode());
							allowRoles = null;
						}
					}
				}
			}
		}
	}

	/**
	 * Sets the security trust
	 * 
	 * @param carbonTrust
	 *            node carbonTrust
	 * @param carbonTrustMap
	 *            map
	 */
	private static void setSecTrust(Node carbonTrust, Map<String, String> carbonTrustMap) {

		NodeList list = carbonTrust.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				if (StringUtils.isNotBlank(attribute)) {
					node.setTextContent(carbonTrustMap.get(attribute));
				}
			}
		}
	}

	/**
	 * Sets the security trust
	 * 
	 * @param carbonTrust
	 *            node carbonTrust
	 * @param carbonTrustMap
	 *            map
	 */
	private void setKerberosSecConfig(Node carbonKerberos, Map<String, String> carbonKerberosMap) {

		NodeList list = carbonKerberos.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && SecurityFormConstants.CARBONSEC_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				if (StringUtils.isNotBlank(attribute)) {
					if (!StringUtils.isEmpty(carbonKerberosMap.get(attribute))) {
						node.setTextContent(carbonKerberosMap.get(attribute));
					} else {
						if (attribute.equals(SecurityFormConstants.SERVICE_PRINCIPAL_NAME)) {
							setPageDirty(true);
							updateDirtyState();
							MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
							msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_NAME);
							msgBox.open();

						} else {
							setPageDirty(true);
							updateDirtyState();
							MessageBox msgBox = new MessageBox(getSite().getShell(), SWT.ICON_WARNING);
							msgBox.setMessage(SecurityFormMessageConstants.MESSAGE_KERBEROS_PASSWORD);
							msgBox.open();
						}
						if (node.getParentNode().getParentNode().getParentNode() != null) {
							node.getParentNode().getParentNode().getParentNode()
									.removeChild(carbonKerberos.getParentNode());

						}

					}
				}
			}
		}
	}

	/**
	 * Sets the kerberos configs
	 * 
	 * @param kerberosConfig
	 *            kerbeos config
	 * @param carbonSecKerberosDataMap2
	 */
	private static void setKerberosRampartConfig(Node kerberosConfig, Map<String, String> carbonSecKerberosDataMap) {

		NodeList list = ((Element) kerberosConfig).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && SecurityFormConstants.RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(SecurityFormConstants.PROPERTY_NAME);
				if (StringUtils.isNotBlank(attribute)) {
					node.setTextContent(carbonSecKerberosDataMap.get(attribute));
				}
			}
		}
	}

	/**
	 * Creates the security items
	 * 
	 * @param seccomposite
	 *            composite
	 * @param names
	 *            names
	 * @param managedForm
	 *            form
	 * @param i
	 *            int value
	 */
	private void createSecurityScenarioOptionButtons(final Composite seccomposite, String[] names, IManagedForm managedForm,
			int i, Composite body) throws IOException, JAXBException {

		for (String name : names) {
			i++;
			final Button secBtn = new Button(seccomposite, SWT.RADIO);
			secBtn.setText("");
			secBtn.setToolTipText(name);

			String fileName = SecurityFormConstants.FILE_PREFIX + i + SecurityFormConstants.FILE_POSTFIX;
			secBtn.setData(fileName);
			secBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					selectPolicy(secBtn);
				}
			});

			String filename = SecurityFormConstants.POLICIES + fileName;
			SecurityTemplateUtil qoSTemplateUtil = new SecurityTemplateUtil();
			File resourceFile = qoSTemplateUtil.getResourceFile(filename);
			if (resourceFile != null) {
				Unmarshaller pUnmarshaller = getUnmarsheller();
				Policy2 policy2 = (Policy2) pUnmarshaller.unmarshal(resourceFile);
				policyeMap.put(policy2.getId(), secBtn);
			}

			final ToolTip tip = new ToolTip(seccomposite.getShell(), SWT.BALLOON | SWT.ICON_INFORMATION);
			tip.setMessage(TIP_MESSAGE);

			Hyperlink createHyperlink = managedForm.getToolkit().createHyperlink(seccomposite, name, SWT.RADIO);
			createHyperlink.addHyperlinkListener(new HyperlinkAdapter() {
				@Override
				public void linkActivated(HyperlinkEvent e) {
					// Fixing TOOLS-2293.
					// tip.setVisible(true);

					Control[] children = seccomposite.getChildren();
					for (Control child : children) {
						if (child instanceof Button) {
							((Button) child).setSelection(false);
						}
					}

					secBtn.setSelection(true);
					selectPolicy(secBtn);

				}

			});

			if (SecurityPolicies.POLICY_TYPE_1.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);

				policyOneUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyOneUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
				policyOneUserRolesButton.setVisible(false);
				policyOneUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
						setPageDirty(true);
						updateDirtyState();
					}
				});

				GridData userRolesButtonGridData = new GridData();
				userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
				userRolesButtonGridData.grabExcessHorizontalSpace = false;
				policyOneUserRolesButton.setLayoutData(userRolesButtonGridData);
			} else if (SecurityPolicies.POLICY_TYPE_7.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);

				policySevenUserRolesButton = new Button(seccomposite, SWT.NONE);
				policySevenUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
				policySevenUserRolesButton.setVisible(false);
				policySevenUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
						setPageDirty(true);
						updateDirtyState();
					}
				});

				GridData userRolesButtonGridData = new GridData();
				userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
				userRolesButtonGridData.grabExcessHorizontalSpace = false;
				policySevenUserRolesButton.setLayoutData(userRolesButtonGridData);
			} else if (SecurityPolicies.POLICY_TYPE_8.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);

				policyEightUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyEightUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
				policyEightUserRolesButton.setVisible(false);
				policyEightUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
						setPageDirty(true);
						updateDirtyState();
					}
				});

				GridData userRolesButtonGridData = new GridData();
				userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
				userRolesButtonGridData.grabExcessHorizontalSpace = false;
				policyEightUserRolesButton.setLayoutData(userRolesButtonGridData);
			} else if (SecurityPolicies.POLICY_TYPE_14.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);

				policyFourteenUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyFourteenUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
				policyFourteenUserRolesButton.setVisible(false);
				policyFourteenUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
						setPageDirty(true);
						updateDirtyState();
					}
				});

				GridData userRolesButtonGridData = new GridData();
				userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
				userRolesButtonGridData.grabExcessHorizontalSpace = false;
				policyFourteenUserRolesButton.setLayoutData(userRolesButtonGridData);
			} else if (SecurityPolicies.POLICY_TYPE_15.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);

				policyFifteenUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyFifteenUserRolesButton.setText(SecurityFormConstants.USER_ROLE);
				policyFifteenUserRolesButton.setVisible(false);
				policyFifteenUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
						setPageDirty(true);
						updateDirtyState();
					}
				});

				GridData userRolesButtonGridData = new GridData();
				userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
				userRolesButtonGridData.grabExcessHorizontalSpace = false;
				policyFifteenUserRolesButton.setLayoutData(userRolesButtonGridData);
			} else {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.horizontalSpan = 4;
				createHyperlink.setLayoutData(policyLinkGrdiData);
			}

		}
	}

	/**
	 * Gets the policy when radio button selects
	 * @param secBtn
	 */
	protected void selectPolicy(final Button secBtn) {
		policyFileName = (String) secBtn.getData();
		selectedPolicy = secBtn.getToolTipText();
		setPageDirty(true);
		updateDirtyState();
		if (resultService != null || enresult != null || signresult != null) {
			Section result = (Section) resultService[0];
			Section encrypt = (Section) enresult[0];
			Section signResult = (Section) signresult[0];
			Section kebSection = (Section) keberosResult[0];

			// TOOLS-2772
			if (selectedPolicy.equals(SecurityFormConstants.POLICY_UT)) {
				result.setVisible(false);
				encrypt.setVisible(false);
				signResult.setVisible(false);
				kebSection.setVisible(false);
			} else if (selectedPolicy.equals(SecurityFormConstants.POLICY_KERBEROS)) {
				result.setVisible(false);
				encrypt.setVisible(false);
				signResult.setVisible(false);
				kebSection.setVisible(true);
			} else {
				result.setVisible(true);
				encrypt.setVisible(true);
				signResult.setVisible(true);
				kebSection.setVisible(false);
			}
		}

		enableUserRoleButton(secBtn);
	}

	/**
	 * Enbles the user role button
	 * 
	 * @param secBtn
	 */
	private void enableUserRoleButton(Button secBtn) {
		if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_1)) {
			policyOneUserRolesButton.setVisible(true);
			policySevenUserRolesButton.setVisible(false);
			policyEightUserRolesButton.setVisible(false);
			policyFourteenUserRolesButton.setVisible(false);
			policyFifteenUserRolesButton.setVisible(false);

		} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_7)) {
			policyOneUserRolesButton.setVisible(false);
			policySevenUserRolesButton.setVisible(true);
			policyEightUserRolesButton.setVisible(false);
			policyFourteenUserRolesButton.setVisible(false);
			policyFifteenUserRolesButton.setVisible(false);

		} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_8)) {
			policyOneUserRolesButton.setVisible(false);
			policySevenUserRolesButton.setVisible(false);
			policyEightUserRolesButton.setVisible(true);
			policyFourteenUserRolesButton.setVisible(false);
			policyFifteenUserRolesButton.setVisible(false);

		} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_14)) {
			policyOneUserRolesButton.setVisible(false);
			policySevenUserRolesButton.setVisible(false);
			policyEightUserRolesButton.setVisible(false);
			policyFourteenUserRolesButton.setVisible(true);
			policyFifteenUserRolesButton.setVisible(false);

		} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_15)) {
			policyOneUserRolesButton.setVisible(false);
			policySevenUserRolesButton.setVisible(false);
			policyEightUserRolesButton.setVisible(false);
			policyFourteenUserRolesButton.setVisible(false);
			policyFifteenUserRolesButton.setVisible(true);

		} else {
			policyOneUserRolesButton.setVisible(false);
			policySevenUserRolesButton.setVisible(false);
			policyEightUserRolesButton.setVisible(false);
			policyFourteenUserRolesButton.setVisible(false);
			policyFifteenUserRolesButton.setVisible(false);

		}
	}

	/**
	 * Open User Roles dialog for UT policy.
	 */
	private void openUserRolesDialog() {
		if (utRoles == null) {
			utRoles = new ArrayList<String>();
		} else {
			if (!StringUtils.isEmpty(allowRoles))
				utRoles.clear();
		}

		UserRolesDialog dialog = new UserRolesDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				utRoles, allowRoles);
		dialog.open();
	}

	/**
	 * Create sections
	 * 
	 * @param toolkit
	 *            form
	 * @param body
	 *            body
	 * @param sectionName
	 *            name of the section
	 * @param x
	 *            int
	 * @param y
	 *            int
	 * @param width
	 *            width
	 * @param height
	 *            height
	 * @param expand
	 *            boolean
	 * @return object
	 */
	private Object[] CreateMainSection(FormToolkit toolkit, final Composite body, String sectionName, final int x,
			final int y, final int width, final int height, boolean expand) {

		Object[] comp = new Object[2];
		final Section sctnCreate = toolkit.createSection(body, Section.TWISTIE | Section.TITLE_BAR);
		sctnCreate.setBounds(x, y, width, height);
		toolkit.paintBordersFor(sctnCreate);
		sctnCreate.setText(sectionName);
		sctnCreate.setExpanded(expand);
		/*
		 * GridData layoutData = new GridData(); layoutData.minimumWidth = 600;
		 * layoutData.horizontalAlignment = SWT.FILL;
		 * layoutData.grabExcessHorizontalSpace = true;
		 * sctnCreate.setLayoutData(layoutData);
		 */
		sctnCreate.addExpansionListener(new IExpansionListener() {

			@Override
			public void expansionStateChanging(ExpansionEvent e) {
			}

			@Override
			public void expansionStateChanged(ExpansionEvent e) {

			}
		});
		comp[0] = sctnCreate;
		Composite composite = toolkit.createComposite(sctnCreate, SWT.NULL);
		toolkit.paintBordersFor(composite);
		sctnCreate.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		comp[1] = composite;

		return comp;
	}

	/**
	 * Create contents of category
	 * 
	 * @param toolkit
	 *            form
	 * @param composite
	 *            composite
	 * @param category
	 *            category
	 */
	private void createCategory(FormToolkit toolkit, Composite composite, String category) {

		Label lblcategory = toolkit.createLabel(composite, category, SWT.NONE);
		lblcategory.setFont(SWTResourceManager.getFont(SecurityFormConstants.SANS, 10, SWT.BOLD));
		GridData gd_category = new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1);
		gd_category.verticalIndent = 10;
		lblcategory.setLayoutData(gd_category);

	}

	/**
	 * Saves the content to the file
	 */
	public void doPageSave() {

		try {
			setPageDirty(false);
			save();
		} catch (Exception e) {
			log.error("Cannot save the content", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_SERIALIZATION_SAVE_ERROR);
			msg.open();
		}
	}

	/**
	 * Update the source at page change
	 * 
	 * @return updated source as an input stream
	 * @throws InterruptedException
	 */
	public String doSourceUpdate() {

		String updatedcontent = null;
		try {
			updateSource();
			updatedcontent = getUpdatedContent();
		} catch (InterruptedException | TransformerException e) {
			log.error("Error in updating the source view", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_UPDATE_SOURCE_ERROR);
			msg.open();
		}
		return updatedcontent;
	}

	public void updateDirtyState() {
		((SecurityFormEditor) getEditor()).updateDirtyState();
	}

	public void setPageDirty(boolean isPageDirty) {
		this.pageDirty = isPageDirty;
	}

	@Override
	public boolean isDirty() {
		return isPageDirty();
	}

	public boolean isPageDirty() {
		return pageDirty;
	}
	
	/**
	 * Update the UI at page change
	 * 
	 * @param source
	 * @throws JAXBException
	 */
	public void updateUI(String source) {

		try {
			updateSecurityOptionButtons(source, resultService, enresult, signresult, keberosResult);
			updateRampartUIAndUserRolesWithChanges(source);			
		} catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
			log.error("Error in loading page", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_PAGE_LOADING_ERROR);
			msg.open();
		}
	}
}