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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
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
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.security.Activator;
import org.wso2.developerstudio.eclipse.security.project.model.Parameter;
import org.wso2.developerstudio.eclipse.security.project.model.Policy2;
import org.wso2.developerstudio.eclipse.security.project.model.Service;
import org.wso2.developerstudio.eclipse.security.project.ui.dialog.UserRolesDialog;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityPolicies;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityPolicyUtils;
import org.wso2.developerstudio.eclipse.security.project.utils.SecurityTemplateUtil;
import org.xml.sax.SAXException;

public class SecurityFormPage extends FormPage {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	boolean isSave = false;

	private static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS = "org.wso2.carbon.security.crypto.alias";
	private static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES = "org.wso2.carbon.security.crypto.truststores";
	private static final String ORG_WSO2_STRATOS_TENANT_ID = "org.wso2.stratos.tenant.id";
	private static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE = "org.wso2.carbon.security.crypto.privatestore";
	private static final String REGISTRY_POLICY_PARAMETER = "secPolicyRegistryPath";
	private static final String ALLOW_ROLES_PARAMETER = "allowRoles";

	// Constants for Rampart Config
	private static final String KERBEROSSIGNANDENCRYPT = "kerberossignandencrypt";
	private static final String RAMPART_CONFIG_USER = "rampart.config.user";
	private static final String RAMPART_CONFIG = "rampart:RampartConfig";
	private static final String RAMPART_USER = "rampart:user";
	private static final String RAMPART_ENCRYPTION_USER = "rampart:encryptionUser";
	private static final String RAMPART_NONCE_LIFE_TIME = "rampart:nonceLifeTime";
	private static final String RAMPART_TOKEN_STORE_CLASS = "rampart:tokenStoreClass";
	private static final String RAMPART_TIMESTAMP_STRICT = "rampart:timestampStrict";
	private static final String RAMPART_TIMESTAMP_MAX_SKEW = "rampart:timestampMaxSkew";
	private static final String RAMPART_TIMESTAMP_TTL = "rampart:timestampTTL";
	private static final String RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS = "rampart:timestampPrecisionInMilliseconds";
	private static final String RAMPART_ENCRYPTION_CRYPTO = "rampart:encryptionCrypto";
	private static final String RAMPART_SIGNATURE_CRYPTO = "rampart:signatureCrypto";
	private static final String RAMPART_KERBEROS_CONFIG = "rampart:kerberosConfig";
	private static final String RAMPART_CRYPTO = "rampart:crypto";
	private static final String RAMPART_PROPERTY = "rampart:property";
	private static final String RAMPART_ENCRYPTION_USER_VALUE = "useReqSigCert";
	private static final String RAMPART_TOKEN_STORE_CLASS_VALUE = "org.wso2.carbon.security.util.SecurityTokenStore";
	private static final String RAMPART_PROPERTY_NAME = "name";
	private static final String RAMPART_TIME_VALUE = "300";
	private static final String USER_ROLE = "User Roles";
	private static final String RAMPART_TENANT_VALUE = "-1234";

	// Private Store Constants
	private static final String WSO2_PRIVATESTORE = "wso2carbon.jks";
	private static final String WSO2_PRIVATESTORE_ALIAS = "wso2carbon";

	// Category Names
	private static final String BASIC_SCENARIOS = "Basic Scenarios";
	private static final String ADVANCED_SCENARIOS = "Advanced Scenarios";
	private static final String ADVANCE_CONFIGURATION = "Advance Configuration(Rampart)";

	// Label Names
	private static final String LABEL_USER = "User :";
	private static final String LABEL_ENCRYPTION_USER = "encryptionUser :";
	private static final String LABEL_PRECISION = "PrecisionInMilliseconds :";
	private static final String LABEL_TIMESTAMP_TTL = "timestampTTL :";
	private static final String LABEL_TIMESTAMP_MAX = "timestampMaxSkew :";
	private static final String LABEL_TIMESTAMP_STRICT = "timestampStrict :";
	private static final String LABEL_TOKEN_STORE_CLASS = "tokenStoreClass :";
	private static final String LABEL_NONCELIFETIME = "nonceLifeTime :";
	private static final String LABEL_PRIVATE_STORE = "Privatestore :";
	private static final String EDITOR_TITLE = "WS-Policy for Service";
	private static final String VALUE_TRUE = "true";
	private static final String VALUE_FALSE = "false";
	private static final String FILE_PREFIX = "scenario";
	private static final String FILE_POSTFIX = "-policy.xml";
	private static final String SANS ="Sans";

	// Section Names
	private static final String SECTION_SERVICE_INFO = "Service Info";
	private static final String SECTION_SECURITY_SERVICE = "Security for the service";
	private static final String SECTION_RAMPART_CONFIGURATION = "Rampart Configuration";
	private static final String SECTION_ENCRYPTION_PROPERTIES = "Encryption Properties";
	private static final String SECTION_SIGNATURE_PROPOERTIES = "Signature Properties";

	// Rampart Configs
	private static final String ALIAS = ":Alias";
	private static final String PRIVATESTORE = ":Privatestore";
	private static final String TRUSTSTORES = ":Truststores";
	private static final String TENANT_ID = ":Tenant id";
	private static final String USER = ":User";
	private static final String EN = "en";
	private static final String SIGN = "sign";
	private static final String POLICIES = "policies/";

	// Messages
	private static final String TIP_MESSAGE = "Description not available";

	public IProject project;
	private Policy2 policyFile; // Instance of a new policy
	private File inputFile;
	private String policyFileName;
	private String selectedPolicy;
	private Document doc;
	private Element rampart;
	private String policyID;

	private static Map<String, String> configMap;
	private static Map<String, String> encryptMap;
	private static Map<String, String> signMap;
	private Map<String, Text> enControlMap;
	private Map<String, Text> signControlMap;
	private Map<String, Object> basicRampartControlMap;
	private Map<String, Button> policyeMap;
	private static List<String> utRoles;
	private Service service;
	SecurityFormEditor formEditor;

	// UI components
	private Button policyOneUserRolesButton;
	private Button policySevenUserRolesButton;
	private Button policyEightUserRolesButton;
	private Button policyFourteenUserRolesButton;
	private Button policyFifteenUserRolesButton;
	private Text keysText;
	private Text timestampMaxSkew;
	private Text rmUser;
	private Text encryptionUser;
	private Text timestampTTL;
	private Text tokenStoreClass;
	private Text nonceLifeTime;

	public SecurityFormPage(FormEditor editor, String id, String title, IProject iproject, File file) {
		super(editor, id, title);

		configMap = new HashMap<>();
		encryptMap = new HashMap<>();
		signMap = new HashMap<>();
		enControlMap = new HashMap<>();
		signControlMap = new HashMap<>();
		basicRampartControlMap = new HashMap<>();
		policyeMap = new HashMap<>();
		inputFile = file;
		project = iproject;
		formEditor = (SecurityFormEditor) editor;
	}

	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText(EDITOR_TITLE);
		final Composite body = form.getBody();
		GridLayout gridParentLayout = new GridLayout(1, true);

		body.setLayout(gridParentLayout);
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		Object[] result = CreateMainSection(managedForm, body, SECTION_SECURITY_SERVICE, 10, 70, 600, 30, true);
		Composite seccomposite = (Composite) result[1];
		GridLayout gridSecLayout = new GridLayout(5, false);
		seccomposite.setLayout(gridSecLayout);

		createCategory(managedForm, seccomposite, BASIC_SCENARIOS);

		try {
			createSecurityItems(seccomposite, SecurityPolicyUtils.getInstance().getBasicSecurityScenarios(),
					managedForm, 0);
		} catch (IOException | JAXBException e) {
			log.error("Error in reading policy file", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_POLICYFILE_READ_ERROR);
			msg.open();
		}

		Object[] resultService = CreateMainSection(managedForm, body, SECTION_SERVICE_INFO, 10, 70, 600, 30, true);
		Composite serviceInfoMainComposite = (Composite) resultService[1];
		GridLayout gridserviceLayout = new GridLayout();
		serviceInfoMainComposite.setLayout(gridserviceLayout);

		Composite compositeBasicInfo = new Composite(serviceInfoMainComposite, SWT.NULL);
		GridLayout BasicInfoLayout = new GridLayout(3, false);
		compositeBasicInfo.setLayout(BasicInfoLayout);

		managedForm.getToolkit().createLabel(compositeBasicInfo, LABEL_PRIVATE_STORE);

		keysText = new Text(compositeBasicInfo, SWT.FLAT);
		keysText.setBounds(new org.eclipse.swt.graphics.Rectangle(92, 40, 84, 28));
		keysText.setText(WSO2_PRIVATESTORE);
		GridData keyslayoutData = new GridData();
		keyslayoutData.minimumWidth = 200;
		keyslayoutData.horizontalAlignment = SWT.FILL;
		keyslayoutData.grabExcessHorizontalSpace = true;
		keysText.setLayoutData(keyslayoutData);

		keysText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updatePrivateStore();
				setSave(true);
				updateDirtyState();
			}
		});

		createCategory(managedForm, seccomposite, ADVANCED_SCENARIOS);
		try {
			createSecurityItems(seccomposite, SecurityPolicyUtils.getInstance().getAdvancedSecurityScenarios(),
					managedForm, 4);
		} catch (IOException | JAXBException e) {
			log.error("Error in reading policy file", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_POLICYFILE_READ_ERROR);
			msg.open();
		}

		Object[] aAdresult = CreateMainSection(managedForm, body, ADVANCE_CONFIGURATION, 10, 15, 600, 30, true);
		Composite rmaportInfComposite = (Composite) aAdresult[1];
		GridLayout ramportlayout = new GridLayout();
		rmaportInfComposite.setLayout(ramportlayout);

		Object[] ramBasicresult = CreateMainSection(managedForm, rmaportInfComposite, SECTION_RAMPART_CONFIGURATION,
				10, 20, 600, 30, true);
		Composite rampartBasic = (Composite) ramBasicresult[1];
		GridLayout ramparlayout = new GridLayout(2, false);
		rampartBasic.setLayout(ramparlayout);
		Section ramBasicSec = (Section) ramBasicresult[0];
		ramBasicSec.setExpanded(false);

		managedForm.getToolkit().createLabel(rampartBasic, LABEL_USER);
		rmUser = managedForm.getToolkit().createText(rampartBasic, "");
		GridData rmUserlayoutData = new GridData();
		rmUserlayoutData.minimumWidth = 200;
		rmUserlayoutData.horizontalAlignment = SWT.FILL;
		rmUserlayoutData.grabExcessHorizontalSpace = true;
		rmUser.setLayoutData(rmUserlayoutData);
		basicRampartControlMap.put(RAMPART_USER, rmUser);

		rmUser.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, LABEL_ENCRYPTION_USER);
		encryptionUser = managedForm.getToolkit().createText(rampartBasic, "");
		GridData encryptionUserlayoutData = new GridData();
		encryptionUserlayoutData.minimumWidth = 200;
		encryptionUserlayoutData.horizontalAlignment = SWT.FILL;
		encryptionUserlayoutData.grabExcessHorizontalSpace = true;
		encryptionUser.setLayoutData(encryptionUserlayoutData);
		basicRampartControlMap.put(RAMPART_ENCRYPTION_USER, encryptionUser);

		encryptionUser.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		String[] values = new String[] { VALUE_FALSE, VALUE_TRUE };
		managedForm.getToolkit().createLabel(rampartBasic, LABEL_PRECISION);
		Combo timestampPrecisionInMilliseconds = new Combo(rampartBasic, SWT.READ_ONLY);
		timestampPrecisionInMilliseconds.setItems(values);
		GridData timestampPrecisionInMillisecondslayoutData = new GridData();
		timestampPrecisionInMillisecondslayoutData.minimumWidth = 200;
		timestampPrecisionInMillisecondslayoutData.horizontalAlignment = SWT.FILL;
		timestampPrecisionInMillisecondslayoutData.grabExcessHorizontalSpace = true;
		timestampPrecisionInMilliseconds.setLayoutData(timestampPrecisionInMillisecondslayoutData);
		basicRampartControlMap.put(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS, timestampPrecisionInMilliseconds);

		timestampPrecisionInMilliseconds.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, LABEL_TIMESTAMP_TTL);
		timestampTTL = managedForm.getToolkit().createText(rampartBasic, " ");
		GridData timestampTTLlayoutData = new GridData();
		timestampTTLlayoutData.minimumWidth = 200;
		timestampTTLlayoutData.horizontalAlignment = SWT.FILL;
		timestampTTLlayoutData.grabExcessHorizontalSpace = true;
		timestampTTL.setLayoutData(timestampTTLlayoutData);
		basicRampartControlMap.put(RAMPART_TIMESTAMP_TTL, timestampTTL);

		timestampTTL.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, LABEL_TIMESTAMP_MAX);
		timestampMaxSkew = managedForm.getToolkit().createText(rampartBasic, "");
		GridData timestampMaxSkewlayoutData = new GridData();
		timestampMaxSkewlayoutData.minimumWidth = 200;
		timestampMaxSkewlayoutData.horizontalAlignment = SWT.FILL;
		timestampMaxSkewlayoutData.grabExcessHorizontalSpace = true;
		timestampMaxSkew.setLayoutData(timestampMaxSkewlayoutData);
		basicRampartControlMap.put(RAMPART_TIMESTAMP_MAX_SKEW, timestampMaxSkew);

		timestampMaxSkew.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, LABEL_TIMESTAMP_STRICT);
		Combo timestampStrict = new Combo(rampartBasic, SWT.READ_ONLY);
		timestampStrict.setItems(values);
		GridData timestampStrictlayoutData = new GridData();
		timestampStrictlayoutData.minimumWidth = 200;
		timestampStrictlayoutData.horizontalAlignment = SWT.FILL;
		timestampStrictlayoutData.grabExcessHorizontalSpace = true;
		timestampStrict.setLayoutData(timestampStrictlayoutData);
		basicRampartControlMap.put(RAMPART_TIMESTAMP_STRICT, timestampStrict);

		timestampStrict.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, LABEL_TOKEN_STORE_CLASS);
		tokenStoreClass = managedForm.getToolkit().createText(rampartBasic, "");
		GridData tokenStoreClasslayoutData = new GridData();
		tokenStoreClasslayoutData.minimumWidth = 200;
		tokenStoreClasslayoutData.horizontalAlignment = SWT.FILL;
		tokenStoreClasslayoutData.grabExcessHorizontalSpace = true;
		tokenStoreClass.setLayoutData(tokenStoreClasslayoutData);
		basicRampartControlMap.put(RAMPART_TOKEN_STORE_CLASS, tokenStoreClass);

		tokenStoreClass.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		managedForm.getToolkit().createLabel(rampartBasic, LABEL_NONCELIFETIME);
		nonceLifeTime = managedForm.getToolkit().createText(rampartBasic, "");
		GridData nonceLifeTimelayoutData = new GridData();
		nonceLifeTimelayoutData.minimumWidth = 200;
		nonceLifeTimelayoutData.horizontalAlignment = SWT.FILL;
		nonceLifeTimelayoutData.grabExcessHorizontalSpace = true;
		nonceLifeTime.setLayoutData(nonceLifeTimelayoutData);
		basicRampartControlMap.put(RAMPART_NONCE_LIFE_TIME, nonceLifeTime);

		nonceLifeTime.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

		Object[] enresult = CreateMainSection(managedForm, rmaportInfComposite, SECTION_ENCRYPTION_PROPERTIES, 10, 20,
				600, 30, true);
		Composite enComposite = (Composite) enresult[1];
		GridLayout enlayout = new GridLayout(2, false);
		enComposite.setLayout(enlayout);
		Section enSec = (Section) enresult[0];
		enSec.setExpanded(false);

		Object[] signresult = CreateMainSection(managedForm, rmaportInfComposite, SECTION_SIGNATURE_PROPOERTIES, 10,
				30, 600, 30, true);
		Composite signComposite = (Composite) signresult[1];
		GridLayout signlayout = new GridLayout(2, false);
		signComposite.setLayout(signlayout);
		Section signSec = (Section) signresult[0];
		signSec.setExpanded(false);

		String[] rmpartConfigs = new String[] { ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS + ALIAS,
				ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE + PRIVATESTORE,
				ORG_WSO2_STRATOS_TENANT_ID + TENANT_ID,
				ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES + TRUSTSTORES, RAMPART_CONFIG_USER + USER };
		for (String name : rmpartConfigs) {
			createRampartProperties(managedForm, enComposite, name, EN);
			createRampartProperties(managedForm, signComposite, name, SIGN);
		}

		loadRampartUI();

		if (inputFile != null) {
			try {
				updateSecuritySecUI(inputFile);
				updateRampartUIWithChanges(inputFile);
			} catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
				log.error("Error in loading page", e);
				MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
				msg.setMessage(SecurityFormMessageConstants.MESSAGE_PAGE_LOADING_ERROR);
				msg.open();
			}
		}
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
			Thread.sleep(1000);
			
			// Save to the serviceMetaFile
			saveTofile();
			Thread.sleep(1000);
			
			// Gets rampart config values from the created policy file via nodes
			getRampartConfig(inputFile);
			
			// Saves the retrieved values
			saveRampartConifgUserValues();
			
			// Insert values to the map
			setRampartConfig();
			// Saves the final output into the serviceMetaFile
			saveRampartConfigToFile();
			
			RefreshProject();
			
		} catch (JAXBException | IOException | CoreException | ParserConfigurationException | SAXException
				| TransformerException e) {
			log.error("Saving Error", e);
			MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
			msg.setMessage(SecurityFormMessageConstants.MESSAGE_SAVE_ERROR);
			msg.open();
		}
	}

	/**
	 * Updates the Rampart UI
	 */
	private void loadRampartUI() {
		if (enControlMap.size() > 0 && signControlMap.size() >0) {
			if (StringUtils.isNotBlank(keysText.getText())) {

				String keyName = keysText.getText();

				// encryption properties
				enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText(WSO2_PRIVATESTORE_ALIAS);
				enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(keyName);
				enControlMap.get(ORG_WSO2_STRATOS_TENANT_ID).setText(RAMPART_TENANT_VALUE);
				enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(keyName);
				enControlMap.get(RAMPART_CONFIG_USER).setText(WSO2_PRIVATESTORE_ALIAS);

				// signature properties
				signControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText(WSO2_PRIVATESTORE_ALIAS);
				signControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(keyName);
				signControlMap.get(ORG_WSO2_STRATOS_TENANT_ID).setText(RAMPART_TENANT_VALUE);
				signControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(keyName);
				signControlMap.get(RAMPART_CONFIG_USER).setText(WSO2_PRIVATESTORE_ALIAS);

				// rampart configuration
				Text rampartProperties = (Text) basicRampartControlMap.get(RAMPART_USER);
				rampartProperties.setText(WSO2_PRIVATESTORE_ALIAS);

				rampartProperties = (Text) basicRampartControlMap.get(RAMPART_ENCRYPTION_USER);
				rampartProperties.setText(RAMPART_ENCRYPTION_USER_VALUE);

				rampartProperties = (Text) basicRampartControlMap.get(RAMPART_TIMESTAMP_TTL);
				rampartProperties.setText(RAMPART_TIME_VALUE);

				rampartProperties = (Text) basicRampartControlMap.get(RAMPART_TIMESTAMP_MAX_SKEW);
				rampartProperties.setText(RAMPART_TIME_VALUE);

				rampartProperties = (Text) basicRampartControlMap.get(RAMPART_TOKEN_STORE_CLASS);
				rampartProperties.setText(RAMPART_TOKEN_STORE_CLASS_VALUE);

				rampartProperties = (Text) basicRampartControlMap.get(RAMPART_NONCE_LIFE_TIME);
				rampartProperties.setText(RAMPART_TIME_VALUE);

				Combo rampartTimeStampProperty = (Combo) basicRampartControlMap
						.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS);
				rampartTimeStampProperty.select(1); // Index 1

				rampartTimeStampProperty = (Combo) basicRampartControlMap.get(RAMPART_TIMESTAMP_STRICT);
				rampartTimeStampProperty.select(0); // Index 2
			}
		}
	}

	/**
	 * Updates the Private store and trust store
	 */
	private void updatePrivateStore() {
		if (enControlMap.size() > 0 && signControlMap.size() >0) {
			// encryption properties
			enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(keysText.getText());
			enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(keysText.getText());

			// signature properties
			signControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(keysText.getText());
			signControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(keysText.getText());
		}
	}

	/**
	 * Updates the RampartUI with new values
	 * 
	 * @param alise alias value
	 * @param serviceMetaFile Service meta file
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	private void updateRampartUIWithChanges(File serviceMetaFile) throws ParserConfigurationException, SAXException,
			IOException {
		Map<String, String> rampartConfigMap = getRampartConfig(serviceMetaFile);

		// Sets advanced configurations
		Node encryptionCrypto = rampart.getElementsByTagName(RAMPART_ENCRYPTION_CRYPTO).item(0);
		if (encryptionCrypto != null && enControlMap.size() > 0) {
			setAdvancedConfigurationProperties(encryptionCrypto, enControlMap);
		}

		Node signatureCrypto = rampart.getElementsByTagName(RAMPART_SIGNATURE_CRYPTO).item(0);
		if (signatureCrypto != null && signControlMap.size() > 0) {
			setAdvancedConfigurationProperties(signatureCrypto, signControlMap);
		}

		// rampart configuration
		Text rampartProperties = (Text) basicRampartControlMap.get(RAMPART_USER);
		if (rampartConfigMap.get(RAMPART_USER) != null && rampartProperties != null) {
			rampartProperties.setText(rampartConfigMap.get(RAMPART_USER));
		} else if (rampartProperties != null) {
			rampartProperties.setText("");
		}

		rampartProperties = (Text) basicRampartControlMap.get(RAMPART_ENCRYPTION_USER);
		if (rampartConfigMap.get(RAMPART_ENCRYPTION_USER) != null && rampartProperties != null) {
			rampartProperties.setText(rampartConfigMap.get(RAMPART_ENCRYPTION_USER));
		} else if (rampartProperties != null) {
			rampartProperties.setText("");
		}

		rampartProperties = (Text) basicRampartControlMap.get(RAMPART_TIMESTAMP_TTL);
		if (rampartConfigMap.get(RAMPART_TIMESTAMP_TTL) != null && rampartProperties != null) {
			rampartProperties.setText(rampartConfigMap.get(RAMPART_TIMESTAMP_TTL));
		} else if (rampartProperties != null) {
			rampartProperties.setText("");
		}

		rampartProperties = (Text) basicRampartControlMap.get(RAMPART_TIMESTAMP_MAX_SKEW);
		if (rampartConfigMap.get(RAMPART_TIMESTAMP_MAX_SKEW) != null && rampartProperties != null) {
			rampartProperties.setText(rampartConfigMap.get(RAMPART_TIMESTAMP_MAX_SKEW));
		} else if (rampartProperties != null) {
			rampartProperties.setText("");
		}

		rampartProperties = (Text) basicRampartControlMap.get(RAMPART_TOKEN_STORE_CLASS);
		if (rampartConfigMap.get(RAMPART_TOKEN_STORE_CLASS) != null && rampartProperties != null) {
			rampartProperties.setText(rampartConfigMap.get(RAMPART_TOKEN_STORE_CLASS));
		} else if (rampartProperties != null) {
			rampartProperties.setText("");
		}

		rampartProperties = (Text) basicRampartControlMap.get(RAMPART_NONCE_LIFE_TIME);
		if (rampartConfigMap.get(RAMPART_NONCE_LIFE_TIME) != null && rampartProperties != null) {
			rampartProperties.setText(rampartConfigMap.get(RAMPART_NONCE_LIFE_TIME));
		} else if (rampartProperties != null) {
			rampartProperties.setText("");
		}

		Combo rampartTimeStampProperty = (Combo) basicRampartControlMap
				.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS);
		if (rampartConfigMap.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS) != null
				&& rampartTimeStampProperty != null) {
			if (rampartConfigMap.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).equals(VALUE_FALSE)) {
				rampartTimeStampProperty.select(0); // Index 0
			} else {
				rampartTimeStampProperty.select(1); // Index 1
			}
		}

		rampartTimeStampProperty = (Combo) basicRampartControlMap.get(RAMPART_TIMESTAMP_STRICT);
		if (rampartConfigMap.get(RAMPART_TIMESTAMP_STRICT) != null && rampartTimeStampProperty != null) {
			if (rampartConfigMap.get(RAMPART_TIMESTAMP_STRICT).equals(VALUE_FALSE)) {
				rampartTimeStampProperty.select(0); // Index 0
			} else {
				rampartTimeStampProperty.select(1);// Index 1
			}
		}

	}

/**
 * Sets the values for advanced configuration
 * @param cryptoValue crytptoVale
 * @param cryptoMap map
 */
	private void setAdvancedConfigurationProperties(Node cryptoValue, Map<String, Text> cryptoMap) {
		Node crypto = ((Element) cryptoValue).getElementsByTagName(RAMPART_CRYPTO).item(0);
		NodeList list = ((Element) crypto).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(RAMPART_PROPERTY_NAME);
				if (attribute.equals(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE)) {
					String privateStore = eElement.getTextContent();
					keysText.setText(privateStore);
					cryptoMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(privateStore);
					cryptoMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(privateStore);
				}else if (attribute.equals(ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS)) {
					String alias = eElement.getTextContent();
					cryptoMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText(alias);
				}else if (attribute.equals(ORG_WSO2_STRATOS_TENANT_ID)) {
					String tenantID = eElement.getTextContent();
					cryptoMap.get(ORG_WSO2_STRATOS_TENANT_ID).setText(tenantID);
				}else if (attribute.equals(RAMPART_CONFIG_USER)) {
					String user = eElement.getTextContent();
					cryptoMap.get(RAMPART_CONFIG_USER).setText(user);
				}
			}
		}
	}

	/**
	 * Gets the updated serviceMetaFile with changed values
	 * @param file
	 * @throws JAXBException
	 */
	private void updateSecuritySecUI(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Policy2.class);
		Unmarshaller uUnmarshaller = jaxbContext.createUnmarshaller();
		policyFile = (Policy2) uUnmarshaller.unmarshal(file);

		Button button = policyeMap.get(policyFile.getId());
		if (button != null) {
			button.setSelection(true);
			policyFileName = (String) button.getData();
			selectedPolicy = SecurityPolicyUtils.getInstance().getPolicyTypeFromPolicyUUID(policyFile.getId());
		}
		enableButtons(selectedPolicy);
		inputFile = file;
	}

	/**
	 * Creates RampartProperties
	 * 
	 * @param managedForm foem
	 * @param enComposite composite
	 * @param fullname name
	 * @param prefix prefix
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
		if (EN.equals(prefix)) {
			enControlMap.put(split[0], en);
		} else {
			signControlMap.put(split[0], en);
		}
		en.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setSave(true);
				updateDirtyState();
			}
		});

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
		SecurityTemplateUtil qoSTemplateUtil = new SecurityTemplateUtil();
		String filename = "";
		File resourceFile = null;

		filename = POLICIES + policyFileName;
		resourceFile = qoSTemplateUtil.getResourceFile(filename);

		if (resourceFile != null) {
			JAXBContext pjaxbContext = JAXBContext.newInstance(Policy2.class);
			Unmarshaller pUnmarshaller = pjaxbContext.createUnmarshaller();
			policyFile = (Policy2) pUnmarshaller.unmarshal(resourceFile);

			// Define roles in UsernameToken based security policies.
			if (StringUtils.isNotBlank(selectedPolicy)
					&& utRoles != null
					&& utRoles.size() > 0
					&& (SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_7.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_8.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_14.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_15
								.equals(selectedPolicy))) {

				String allowRoles = getAllowRoles();
				if (StringUtils.isNotBlank(allowRoles)) {
					// Removed since this is for the service
					// addParameter(ALLOW_ROLES_PARAMETER, allowRoles, null);
				}

				List<String> remove = new ArrayList<String>();
				remove.add(REGISTRY_POLICY_PARAMETER);
				removeParameters(remove);

			} else {
				List<String> remove = new ArrayList<String>();
				remove.add(REGISTRY_POLICY_PARAMETER);
				remove.add(ALLOW_ROLES_PARAMETER);
				removeParameters(remove);
			}

			 /*configureAssociation();
			 configureRampartRahasModules();*/
			 
		}
	}

	/**
	 * Saves to the file
	 * 
	 * @throws JAXBException
	 * @throws PropertyException
	 * @throws CoreException
	 */
	private void saveTofile() throws JAXBException, PropertyException, CoreException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Policy2.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Adds the namespace prefix
		/*jaxbMarshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper",
		new NamespaceMapper());*/
		jaxbMarshaller.marshal(policyFile, inputFile);
		RefreshProject();
	}

	public void RefreshProject() throws CoreException {
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	/**
	 * Gets the rampart configuration
	 * 
	 * @param serviceMeta service meta file
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private Map<String, String> getRampartConfig(File serviceMeta) throws ParserConfigurationException, SAXException,
			IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(serviceMeta);

		// Gets the ID of the policy
		policyID = policyFile.getId();

		boolean isKerberossignandencrypt = policyID.equals(KERBEROSSIGNANDENCRYPT);

		Node nrampart = doc.getElementsByTagName(RAMPART_CONFIG).item(0);
		rampart = (Element) nrampart;

		if (!isKerberossignandencrypt) {
			Node user = rampart.getElementsByTagName(RAMPART_USER).item(0);
			if (user != null) {
				configMap.put(RAMPART_USER, user.getTextContent());
			}

			Node encryptionUser = rampart.getElementsByTagName(RAMPART_ENCRYPTION_USER).item(0);
			if (encryptionUser != null) {
				configMap.put(RAMPART_ENCRYPTION_USER, encryptionUser.getTextContent());
			}

		}

		Node timestampPrecisionInMilliseconds = rampart.getElementsByTagName(
				RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
		if (timestampPrecisionInMilliseconds != null) {
			configMap.put(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS,
					timestampPrecisionInMilliseconds.getTextContent());
		}

		Node timestampTTL = rampart.getElementsByTagName(RAMPART_TIMESTAMP_TTL).item(0);
		if (timestampTTL != null) {
			configMap.put(RAMPART_TIMESTAMP_TTL, timestampTTL.getTextContent());
		}

		Node timestampMaxSkew = rampart.getElementsByTagName(RAMPART_TIMESTAMP_MAX_SKEW).item(0);
		if (timestampMaxSkew != null) {
			configMap.put(RAMPART_TIMESTAMP_MAX_SKEW, timestampMaxSkew.getTextContent());
		}

		Node timestampStrict = rampart.getElementsByTagName(RAMPART_TIMESTAMP_STRICT).item(0);
		if (timestampStrict != null) {
			configMap.put(RAMPART_TIMESTAMP_STRICT, timestampStrict.getTextContent());
		}

		if (!isKerberossignandencrypt) {
			Node tokenStoreClass = rampart.getElementsByTagName(RAMPART_TOKEN_STORE_CLASS).item(0);
			if (tokenStoreClass != null) {
				configMap.put(RAMPART_TOKEN_STORE_CLASS, tokenStoreClass.getTextContent());
			}
		}

		Node nonceLifeTime = rampart.getElementsByTagName(RAMPART_NONCE_LIFE_TIME).item(0);
		if (nonceLifeTime != null) {
			configMap.put(RAMPART_NONCE_LIFE_TIME, nonceLifeTime.getTextContent());
		}

		if (!isKerberossignandencrypt) {
			Node encryptionCrypto = rampart.getElementsByTagName(RAMPART_ENCRYPTION_CRYPTO).item(0);
			if (encryptionCrypto != null) {
				addRampartCryptoProperties(encryptionCrypto, encryptMap);
			}

			// rampart:signatureCrypto
			Node signatureCrypto = rampart.getElementsByTagName(RAMPART_SIGNATURE_CRYPTO).item(0);
			if (signatureCrypto != null) {
				addRampartCryptoProperties(signatureCrypto, signMap);
			}
		} else {
			// rampart:kerberosConfig
			Node kerberosConfig = rampart.getElementsByTagName(RAMPART_KERBEROS_CONFIG).item(0);
			if (kerberosConfig != null) {
				addRampartKerberosConfigPropertis(kerberosConfig);
			}
		}
		return configMap;

	}

	/**
	 * Add rampart:encryptionCrypto or rampart:signatureCrypto properties.
	 * 
	 * @param crypto crypto node
	 * @param cryptoMap map
	 */
	private static void addRampartCryptoProperties(Node crypto, Map<String, String> cryptoMap) {
		Node encrypto = ((Element) crypto).getElementsByTagName(RAMPART_CRYPTO).item(0);

		NodeList list = ((Element) encrypto).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(RAMPART_PROPERTY_NAME);
				cryptoMap.put(attribute, eElement.getTextContent());
			}
		}
	}

	/**
	 * Add rampart:kerberosConfig properties.
	 * 
	 * @param kerberosConfig kerberos node
	 */
	private static void addRampartKerberosConfigPropertis(Node kerberosConfig) {
		NodeList list = ((Element) kerberosConfig).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(RAMPART_PROPERTY_NAME);
				configMap.put(attribute, eElement.getTextContent());
			}
		}
	}

	/**
	 * Sets the rampart config
	 */
	private void setRampartConfig() {
		boolean isKerberossignandencrypt = policyID.equals(KERBEROSSIGNANDENCRYPT);
		if (!isKerberossignandencrypt) {
			Node user = rampart.getElementsByTagName(RAMPART_USER).item(0);
			if (user != null) {
				user.setTextContent(configMap.get(RAMPART_USER));
			}

			Node encryptionUser = rampart.getElementsByTagName(RAMPART_ENCRYPTION_USER).item(0);
			if (encryptionUser != null && StringUtils.isNotBlank(configMap.get(RAMPART_ENCRYPTION_USER))) {
				encryptionUser.setTextContent(configMap.get(RAMPART_ENCRYPTION_USER));
			}
		}

		Node timestampPrecisionInMilliseconds = rampart.getElementsByTagName(
				RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
		if (timestampPrecisionInMilliseconds != null
				&& StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS))) {
			timestampPrecisionInMilliseconds.setTextContent(configMap.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS));
		}

		Node timestampTTL = rampart.getElementsByTagName(RAMPART_TIMESTAMP_TTL).item(0);
		if (timestampTTL != null && StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_TTL))) {
			timestampTTL.setTextContent(configMap.get(RAMPART_TIMESTAMP_TTL));
		}

		Node timestampMaxSkew = rampart.getElementsByTagName(RAMPART_TIMESTAMP_MAX_SKEW).item(0);
		if (timestampMaxSkew != null && StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_MAX_SKEW))) {
			timestampMaxSkew.setTextContent(configMap.get(RAMPART_TIMESTAMP_MAX_SKEW));
		}

		Node timestampStrict = rampart.getElementsByTagName(RAMPART_TIMESTAMP_STRICT).item(0);
		if (timestampStrict != null && StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_STRICT))) {
			timestampStrict.setTextContent(configMap.get(RAMPART_TIMESTAMP_STRICT));
		}

		if (!isKerberossignandencrypt) {
			Node tokenStoreClass = rampart.getElementsByTagName(RAMPART_TOKEN_STORE_CLASS).item(0);
			tokenStoreClass.setTextContent(configMap.get(RAMPART_TOKEN_STORE_CLASS));
		}

		Node nonceLifeTime = rampart.getElementsByTagName(RAMPART_NONCE_LIFE_TIME).item(0);
		if (nonceLifeTime != null && StringUtils.isNotBlank(configMap.get(RAMPART_NONCE_LIFE_TIME))) {
			nonceLifeTime.setTextContent(configMap.get(RAMPART_NONCE_LIFE_TIME));
		}

		if (!isKerberossignandencrypt) {
			Node encryptionCrypto = rampart.getElementsByTagName(RAMPART_ENCRYPTION_CRYPTO).item(0);
			if (encryptionCrypto != null) {
				setenCryto(encryptionCrypto, encryptMap);
			}

			Node signatureCrypto = rampart.getElementsByTagName(RAMPART_SIGNATURE_CRYPTO).item(0);
			if (signatureCrypto != null) {
				setenCryto(signatureCrypto, signMap);
			}
		} else {
			Node kerberosConfig = rampart.getElementsByTagName(RAMPART_KERBEROS_CONFIG).item(0);
			if (kerberosConfig != null) {
				setKerberosConfig(kerberosConfig);
			}
		}
	}

	/**
	 * Sets the encryption and sign values
	 * @param encryptionCrypto node encrypto
	 * @param cryptoMap map
	 */
	private static void setenCryto(Node encryptionCrypto, Map<String, String> cryptoMap) {
		Node encrypto = ((Element) encryptionCrypto).getElementsByTagName(RAMPART_CRYPTO).item(0);
		NodeList list = ((Element) encrypto).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(RAMPART_PROPERTY_NAME);
				if (StringUtils.isNotBlank(attribute)) {
					node.setTextContent(cryptoMap.get(attribute));
				}
			}
		}
	}

	/**
	 * Sets the kerberos configs
	 * @param kerberosConfig kerbeos config
	 */
	private static void setKerberosConfig(Node kerberosConfig) {	
		NodeList list = ((Element) kerberosConfig).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && RAMPART_PROPERTY.equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute(RAMPART_PROPERTY_NAME);
				if (StringUtils.isNotBlank(attribute)) {
					node.setTextContent(configMap.get(attribute));
				}
			}
		}
	}

	/**
	 * Saves the rampart configurations to the file
	 * 
	 * @param file
	 * @throws TransformerException
	 */
	private void saveRampartConfigToFile() throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(inputFile);
		transformer.transform(source, result);
	}

	/**
	 * Saves the rampart config user values
	 */
	private void saveRampartConifgUserValues() {
		Set<String> keySet = basicRampartControlMap.keySet();
		for (String key : keySet) {
			Object control = basicRampartControlMap.get(key);
			if (control instanceof Text) {
				Text controlText = (Text) control;
				configMap.put(key, controlText.getText());
			} else if (control instanceof Combo) {
				Combo controlCombo = (Combo) control;
				configMap.put(key, controlCombo.getItem(controlCombo.getSelectionIndex()));
			}
		}
		keySet = enControlMap.keySet();
		for (String key : keySet) {
			Object control = enControlMap.get(key);
			if (control instanceof Text) {
				Text controlText = (Text) control;
				encryptMap.put(key, controlText.getText());
			}
		}
		keySet = signControlMap.keySet();
		for (String key : keySet) {
			Object control = signControlMap.get(key);
			if (control instanceof Text) {
				Text controlText = (Text) control;
				signMap.put(key, controlText.getText());
			}
		}
	}

	/**
	 * Creates the security items
	 * 
	 * @param seccomposite
	 * @param names
	 * @param managedForm
	 * @param i
	 */
	private void createSecurityItems(Composite seccomposite, String[] names, IManagedForm managedForm, int i)
			throws IOException, JAXBException {

		for (String name : names) {
			i++;
			final Button secBtn = new Button(seccomposite, SWT.RADIO);
			secBtn.setText("");
			secBtn.setToolTipText(name);

			// Initially set the UsernameToken as the default scenario
			if (inputFile == null && name.equals(SecurityPolicies.POLICY_TYPE_1)) {
				secBtn.setSelection(true);
				// policyOneUserRolesButton.setVisible(true);
			}
			String fileName = FILE_PREFIX + i + FILE_POSTFIX;
			secBtn.setData(fileName);
			secBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					policyFileName = (String) secBtn.getData();
					selectedPolicy = secBtn.getToolTipText();
					setSave(true);
					updateDirtyState();

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
			});

			String filename = POLICIES + fileName;
			SecurityTemplateUtil qoSTemplateUtil = new SecurityTemplateUtil();
			File resourceFile = qoSTemplateUtil.getResourceFile(filename);
			if (resourceFile != null) {
				JAXBContext pjaxbContext = JAXBContext.newInstance(Policy2.class);
				Unmarshaller pUnmarshaller = pjaxbContext.createUnmarshaller();
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
				}

			});

			if (SecurityPolicies.POLICY_TYPE_1.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);

				policyOneUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyOneUserRolesButton.setText(USER_ROLE);
				policyOneUserRolesButton.setVisible(false);
				policyOneUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
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
				policySevenUserRolesButton.setText(USER_ROLE);
				policySevenUserRolesButton.setVisible(false);
				policySevenUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
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
				policyEightUserRolesButton.setText(USER_ROLE);
				policyEightUserRolesButton.setVisible(false);
				policyEightUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
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
				policyFourteenUserRolesButton.setText(USER_ROLE);
				policyFourteenUserRolesButton.setVisible(false);
				policyFourteenUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
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
				policyFifteenUserRolesButton.setText(USER_ROLE);
				policyFifteenUserRolesButton.setVisible(false);
				policyFifteenUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
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

	private Object[] CreateMainSection(IManagedForm managedForm, final Composite body, String sectionName, final int x,
			final int y, final int width, final int height, boolean expand) {
		Object[] comp = new Object[2];
		final Section sctnCreate = managedForm.getToolkit().createSection(body, Section.TWISTIE | Section.TITLE_BAR);
		sctnCreate.setBounds(x, y, width, height);
		managedForm.getToolkit().paintBordersFor(sctnCreate);
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
		Composite composite = managedForm.getToolkit().createComposite(sctnCreate, SWT.NULL);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnCreate.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		comp[1] = composite;

		return comp;
	}

	/**
	 * Create contents of category
	 * 
	 * @param managedForm
	 * @param composite
	 * @param category
	 */
	private void createCategory(IManagedForm managedForm, Composite composite, String category) {
		Label lblcategory = managedForm.getToolkit().createLabel(composite, category, SWT.NONE);
		lblcategory.setFont(SWTResourceManager.getFont(SANS, 10, SWT.BOLD));
		GridData gd_category = new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1);
		gd_category.verticalIndent = 10;
		lblcategory.setLayoutData(gd_category);

	}

	/**
	 * Open Registry browse dialog for Registry policy.
	 *//*
	private void openRegistryDialog() {
		RegistryKeyProperty registryKey = new RegistryKeyProperty();

		RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell()
				.getStyle(), new ArrayList<NamedEntityDescriptor>(), registryKey);
		dialog.open();

		if (StringUtils.isNotBlank(registryKey.getKeyValue())) {
			policyPathText.setText(registryKey.getKeyValue());

			// String tmpPolicyFile = registryKey.getTempPolicyFilePath() +
			// File.separator
			// + registryKey.getPolicyFileName();
			// setPolicyFileName(tmpPolicyFile);
		}

	}*/

	/**
	 * Open User Roles dialog for UT policy.
	 */
	private void openUserRolesDialog() {
		
		if (utRoles == null) {
			utRoles = new ArrayList<String>();
		} else {
			utRoles.clear();
		}

		UserRolesDialog dialog = new UserRolesDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				utRoles);
		dialog.open();
	}

	/*
	 * private void addParameter(String parameterName, String parameterValue,
	 * BigInteger type) { Parameter newParameter = null; for (Object parameter :
	 * service.getModuleOrParameterOrPolicyUUID()) { if (parameter instanceof
	 * Parameter && StringUtils.isNotBlank(((Parameter) parameter).getName()) &&
	 * ((Parameter) parameter).getName().equals(parameterName)) { // Set new
	 * value to the existing parameter. newParameter = (Parameter) parameter;
	 * newParameter.setValue(parameterValue); break; } }
	 * 
	 * if (newParameter == null) { // Create new parameter since it is not
	 * available. newParameter = new Parameter();
	 * newParameter.setName(parameterName);
	 * newParameter.setValue(parameterValue); if (type != null) {
	 * newParameter.setType(type); }
	 * 
	 * // add parameter to the policy.
	 * service.getModuleOrParameterOrPolicyUUID().add(newParameter); } }
	 */
	/**
	 * Removes parameters from service.
	 * 
	 * @param parameters
	 */
	private void removeParameters(List<String> parameters) {
		
		if (service != null) {
			List<Object> remove = new ArrayList<Object>();
			for (Object parameter : service.getModuleOrParameterOrPolicyUUID()) {
				if (parameter instanceof Parameter && StringUtils.isNotBlank(((Parameter) parameter).getName())
						&& parameters.contains(((Parameter) parameter).getName())) {
					remove.add(parameter);
				}
			}

			for (Object parameter : remove) {
				service.getModuleOrParameterOrPolicyUUID().remove(parameter);
			}
		}
	}

	/**
	 * Get allow roles in role1,role2, format.
	 * 
	 * @return
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
	 * Configure associations.
	 */
	/*private void configureAssociation() {
		List<Object> moduleParamOrasociationList = service.getModuleOrParameterOrPolicyUUID();
		List<Object> remove = new ArrayList<Object>();
		boolean exposedTransportsAssociationFound = false;
		boolean keyStoreAssociationFound = false;

		for (Object object : moduleParamOrasociationList) {
			if (object instanceof Association) {
				Association association = (Association) object;
				if (association.getType().equals("service-keystore")
						|| association.getType().equals("trusted-keystore")) {
					if ((SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_16
							.equals(selectedPolicy))) {
						remove.add(object);
					}
					keyStoreAssociationFound = true;
				}
				if (association.getType().equals("exposedTransports")) {
					exposedTransportsAssociationFound = true;
				}
			}
		}

		if (!exposedTransportsAssociationFound) {
			Association exposedTransportsAssociation = new Association();
			exposedTransportsAssociation.setDestinationPath("/repository/transports/https/listener");
			exposedTransportsAssociation.setType("exposedTransports");
			service.getModuleOrParameterOrPolicyUUID().add(exposedTransportsAssociation);
		}

		if (!keyStoreAssociationFound
				&& !(SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_16
						.equals(selectedPolicy))) {
			Association associationKeyStore = new Association();
			associationKeyStore
					.setDestinationPath("/_system/governance/repository/security/key-stores/carbon-primary-ks");
			associationKeyStore.setType("service-keystore");
			service.getModuleOrParameterOrPolicyUUID().add(associationKeyStore);

			Association associationTrustStore = new Association();
			associationTrustStore
					.setDestinationPath("/_system/governance/repository/security/key-stores/carbon-primary-ks");
			associationTrustStore.setType("trusted-keystore");
			service.getModuleOrParameterOrPolicyUUID().add(associationTrustStore);
		}

		for (Object association : remove) {
			// Remove key-store associations from policy 1 and 16.
			service.getModuleOrParameterOrPolicyUUID().remove(association);
		}
	}*/

	/**
	 * Configure rampart and rahas modules.
	 */
	/*private void configureRampartRahasModules() {
		List<Object> moduleParamOrasociationList = service.getModuleOrParameterOrPolicyUUID();
		boolean rampartModuleFound = false;
		boolean rahasModuleFound = false;
		Object rahasModule = null;

		for (Object object : moduleParamOrasociationList) {
			if (object instanceof Module) {
				Module module = (Module) object;
				if (module.getName().equals("rampart")) {
					rampartModuleFound = true;
				} else if (module.getName().equals("rahas")) {
					if ((SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_2.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_3.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_4.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_5.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_6.equals(selectedPolicy)
							|| SecurityPolicies.POLICY_TYPE_7.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_8
								.equals(selectedPolicy))) {
						rahasModule = object;
					}
					rahasModuleFound = true;
				}
			}
		}

		if (!rahasModuleFound
				&& !(SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_2.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_3.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_4.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_5.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_6.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_7.equals(selectedPolicy) || SecurityPolicies.POLICY_TYPE_8
							.equals(selectedPolicy))) {
			Module module = new Module();
			module.setName("rahas");
			module.setVersion(RAHAS_MODULE_VERSION);
			module.setType("engagedModules");
			service.getModuleOrParameterOrPolicyUUID().add(module);
		}

		if (!rampartModuleFound) {
			Module module = new Module();
			module.setName("rampart");
			module.setVersion(RAMPART_MODULE_VERSION);
			module.setType("engagedModules");
			service.getModuleOrParameterOrPolicyUUID().add(module);
		}

		if (rahasModule != null) {
			service.getModuleOrParameterOrPolicyUUID().remove(rahasModule);
		}
	}*/

	/**
	 * Enable buttons based on the selected policy.
	 * 
	 * @param policyType
	 */
	private void enableButtons(String policyType) {
		
		if (policyType != null) {
			if (SecurityPolicies.POLICY_TYPE_1.equals(policyType)) {
				policyOneUserRolesButton.setVisible(true);
			} else if (SecurityPolicies.POLICY_TYPE_7.equals(policyType)) {
				policySevenUserRolesButton.setVisible(true);
			} else if (SecurityPolicies.POLICY_TYPE_8.equals(policyType)) {
				policyEightUserRolesButton.setVisible(true);
			} else if (SecurityPolicies.POLICY_TYPE_14.equals(policyType)) {
				policyFourteenUserRolesButton.setVisible(true);
			} else if (SecurityPolicies.POLICY_TYPE_15.equals(policyType)) {
				policyFifteenUserRolesButton.setVisible(true);
			} /*
			 * else if (SecurityPolicies.POLICY_TYPE_21.equals(policyType)) {
			 * policyTwentyOneUserRolesButton.setVisible(true);
			 * registryBrowser.setVisible(true); }
			 */
		}
	}

	public void doPageSave() {
		
		try {
			setSave(false);
			((SecurityFormEditor) getEditor()).setDirty(false);
			updateDirtyState();
			save();
		} catch (Exception e) {
			log.error("Cannot save the content", e);
		}
	}

	public void updateDirtyState() {	
		formEditor.setDirty(isSave());
		firePropertyChange(PROP_DIRTY);
		formEditor.editorDirtyStateChanged();
	}

	public void setSave(boolean isSave) {
		this.isSave = isSave;
	}

	public boolean isSave() {
		return isSave;
	}

	public void updateUI() {
		if (inputFile != null) {
			try {
				updateSecuritySecUI(inputFile);
				updateRampartUIWithChanges(inputFile);
			} catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
				log.error("Error in loading page", e);
				MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
				msg.setMessage(SecurityFormMessageConstants.MESSAGE_PAGE_LOADING_ERROR);
				msg.open();
			}
		}
	}
}