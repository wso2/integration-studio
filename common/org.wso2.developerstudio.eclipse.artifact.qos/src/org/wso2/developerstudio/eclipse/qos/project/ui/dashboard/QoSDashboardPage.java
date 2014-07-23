 /* Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.qos.project.ui.dashboard;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Enumeration;
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
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWizard;
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
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.ClientTrustStorePreferencePage;
import org.wso2.developerstudio.eclipse.qos.Activator;
import org.wso2.developerstudio.eclipse.qos.project.model.Association;
import org.wso2.developerstudio.eclipse.qos.project.model.Binding;
import org.wso2.developerstudio.eclipse.qos.project.model.Bindings;
import org.wso2.developerstudio.eclipse.qos.project.model.Module;
import org.wso2.developerstudio.eclipse.qos.project.model.Parameter;
import org.wso2.developerstudio.eclipse.qos.project.model.Policies;
import org.wso2.developerstudio.eclipse.qos.project.model.Policy;
import org.wso2.developerstudio.eclipse.qos.project.model.Policy2;
import org.wso2.developerstudio.eclipse.qos.project.model.Service;
import org.wso2.developerstudio.eclipse.qos.project.model.ServiceGroup;
import org.wso2.developerstudio.eclipse.qos.project.ui.dialog.NamedEntityDescriptor;
import org.wso2.developerstudio.eclipse.qos.project.ui.dialog.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.qos.project.ui.dialog.RegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.qos.project.ui.dialog.UserRolesDialog;
import org.wso2.developerstudio.eclipse.qos.project.ui.wizard.QOSProjectWizard;
import org.wso2.developerstudio.eclipse.qos.project.utils.QoSTemplateUtil;
import org.wso2.developerstudio.eclipse.qos.project.utils.RegistryUtils;
import org.wso2.developerstudio.eclipse.qos.project.utils.SecurityPolicies;
import org.wso2.developerstudio.eclipse.qos.project.utils.SecurityPolicyUtils;
import org.xml.sax.SAXException;


public class QoSDashboardPage extends FormPage {
	
	private static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS = "org.wso2.carbon.security.crypto.alias";

	private static final String RAMPART_CONFIG_USER = "rampart.config.user";

	private static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES = "org.wso2.carbon.security.crypto.truststores";

	private static final String ORG_WSO2_STRATOS_TENANT_ID = "org.wso2.stratos.tenant.id";

	private static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE = "org.wso2.carbon.security.crypto.privatestore";

	private static final String RAMPART_NONCE_LIFE_TIME = "rampart:nonceLifeTime";

	private static final String RAMPART_TOKEN_STORE_CLASS = "rampart:tokenStoreClass";

	private static final String RAMPART_TIMESTAMP_STRICT = "rampart:timestampStrict";

	private static final String RAMPART_TIMESTAMP_MAX_SKEW = "rampart:timestampMaxSkew";

	private static final String RAMPART_TIMESTAMP_TTL = "rampart:timestampTTL";

	private static final String RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS = "rampart:timestampPrecisionInMilliseconds";

	private static final String RAMPART_ENCRYPTION_USER = "rampart:encryptionUser";

	private static final String RAMPART_USER = "rampart:user";

	private static final String QOS_WIZARD_ID = "org.wso2.developerstudio.eclipse.artifact.newqosproject";

	private static final String PROJECT_EXPLORER_PARTID = "org.eclipse.ui.navigator.ProjectExplorer";
	
	private static final String PACKAGE_EXPLORER_PARTID = "org.eclipse.jdt.ui.PackageExplorer";
	
	private static final String REGISTRY_POLICY_PARAMETER = "secPolicyRegistryPath";
	
	private static final String ALLOW_ROLES_PARAMETER = "allowRoles";
	
	private static final String RAMPART_MODULE_VERSION = "1.61-wso2v12";
	
	private static final String RAHAS_MODULE_VERSION = "1.61-wso2v12";
	
	public static String serviceName;
	public static IProject metaProject;
	public static String metaFileName;
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	

	private File metaFile;
	private String policyFileName;
	private String selectedPolicy;
	private Document doc;
	private Element rampart;
	private Map<String,String> configMap;
	private Map<String,Text> enControlMap;
	private Map<String,Text> singControlMap;
	private Map<String,Object> basicRampartControlMap;
	private Map<String,String> keyStoreMap;
	private Map<String,Button> policyeMap;
	private boolean policySelected;
	private ISelectionListener selectionListener = null;
	private ISelection selection = null;
	private boolean kerberossignandencrypt = true;
	
	private List<String> utRoles;
	
	private static IPreferencesService preferenceStore;

	private Button saveButton;
	
	private Button registryBrowser;
	
	private Button policyOneUserRolesButton;
	
	private Button policySevenUserRolesButton;
	
	private Button policyEightUserRolesButton;
	
	private Button policyFourteenUserRolesButton;
	
	private Button policyFifteenUserRolesButton;
	
	private Button policyTwentyOneUserRolesButton;
	
	private Text policyPathText;

	private Combo keysCombo;

	private Section secSecurity;

	private Combo serviceNameText;

	private Combo enableSecCombo;

	private Service service;

	private ServiceGroup serviceGroup;

	private File serviceMetaFile;
	
	private RegistryKeyProperty registryKey;
	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public QoSDashboardPage(String id, String title) {
		super(id, title);
		policySelected = false;
	}

	static{
		preferenceStore = Platform.getPreferencesService();
	}

	/**
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @param project
	 */

	public QoSDashboardPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		configMap = new HashMap<String,String>();
		enControlMap = new HashMap<String,Text>();
		singControlMap = new HashMap<String,Text>();
		keyStoreMap =new HashMap<String,String>();
		keyStoreMap.put("wso2carbon.jks", "wso2carbon");
		basicRampartControlMap =  new HashMap<String,Object>();
		policyeMap = new HashMap<String,Button>();
		//serviceList = getServiceList();
		policySelected = false;
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	protected void createFormContent(IManagedForm managedForm) {
		
		//setting initial selection
		ISelection initialSelection = getSite().getWorkbenchWindow().getSelectionService()
				.getSelection(PROJECT_EXPLORER_PARTID);
		if (initialSelection != null) {
			selection = initialSelection;
		} else {
			initialSelection = getSite().getWorkbenchWindow().getSelectionService()
					.getSelection(PACKAGE_EXPLORER_PARTID);
			if (initialSelection != null) {
				selection = initialSelection;
			}
		}
		
		selectionListener = new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart workbenchPart, ISelection sel) {
				selection = sel;
			}
		};
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(PROJECT_EXPLORER_PARTID,selectionListener);
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(PACKAGE_EXPLORER_PARTID,selectionListener);

		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Quality of Service (QoS)");
		final Composite body = form.getBody();
		GridLayout gridParentLayout = new GridLayout(1,true);
		 
		body.setLayout(gridParentLayout);
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		
		Object[] result = CreateMainSection(managedForm, body,"Service Info",10, 70, 600, 30, true);
		Composite serviceInfoMainComposite = (Composite)result[1];
		GridLayout gridserviceLayout = new GridLayout();
		serviceInfoMainComposite.setLayout(gridserviceLayout);
		
		Composite  compositeBasicInfo = new Composite(serviceInfoMainComposite, SWT.NULL);
		GridLayout BasicInfoLayout = new GridLayout(3,false);
		compositeBasicInfo.setLayout(BasicInfoLayout);
		Composite compositeAdvaceInfo = new Composite(serviceInfoMainComposite, SWT.NULL);
				
		managedForm.getToolkit().createLabel(compositeBasicInfo, "Services List :");
		serviceNameText = new Combo(compositeBasicInfo, SWT.FLAT | SWT.READ_ONLY);
		managedForm.getToolkit().adapt(serviceNameText,true,true);
		
		GridData combolayoutData = new GridData();
		combolayoutData.minimumWidth =200;
		combolayoutData.horizontalAlignment = SWT.FILL;
		combolayoutData.grabExcessHorizontalSpace = true;
		serviceNameText.setLayoutData(combolayoutData);
		// Set<String> keySet = serviceList.keySet();
		/* String[] array = keySet.toArray(new String[0]);
		 serviceName.setItems(array);
		 serviceName.select(0);
		 QoSDashboardPage.serviceName =serviceName.getItem(serviceName.getSelectionIndex());
		 serviceName.addSelectionListener(new SelectionAdapter() {
		        @Override
		   public void widgetSelected(SelectionEvent e) {
		        	QoSDashboardPage.serviceName =serviceName.getItem(serviceName.getSelectionIndex());
	 	   }
		 });*/
		
		 if(QoSDashboardPage.serviceName!=null){
			     String[] array = new String[1];
				 array[0] = QoSDashboardPage.serviceName;
				 serviceNameText.setItems(array); 
				 serviceNameText.select(0);
		 }
		 
		 new Label(compositeBasicInfo, SWT.None);
	
		/* managedForm.getToolkit().createLabel(compositeBasicInfo, "Project name :");
		 Text projectNameText = managedForm.getToolkit().createText(compositeBasicInfo,"", SWT.READ_ONLY);
		    GridData layoutData = new GridData();
			layoutData.minimumWidth =200;
			layoutData.horizontalAlignment = SWT.FILL;
			layoutData.grabExcessHorizontalSpace = true;
		    projectNameText.setLayoutData(layoutData);
		   if(QoSDashboardPage.metaProject != null){
			   projectNameText.setText(QoSDashboardPage.metaProject.getName());
		   } 
		    
         //managedForm.getToolkit().createButton(compositeBasicInfo, "browser",SWT.FLAT);
		
	    Hyperlink createHyperlink = managedForm.getToolkit().createHyperlink(compositeBasicInfo,
	    		"Select project", SWT.NONE);
		createHyperlink.addHyperlinkListener(new HyperlinkAdapter(){
			  @Override
			public void linkActivated(HyperlinkEvent e) {
				   IWizard openWizard = openWizard(QOS_WIZARD_ID);
				   QOSProjectWizard qosProjectWizard = (QOSProjectWizard) openWizard; 
			}		  
		  });
		*/
		
         readKeyStore();
            
         String[] keys = keyStoreMap.keySet().toArray(new String[0]);
        
		 managedForm.getToolkit().createLabel(compositeBasicInfo, "Privatestore :");
		 //keysCombo = new Combo(compositeBasicInfo, SWT.FLAT | SWT.READ_ONLY);
		 keysCombo = new Combo(compositeBasicInfo, SWT.FLAT);
		 keysCombo.setItems(keys);
		 keysCombo.select(0);
		 GridData keyslayoutData = new GridData();
		 keyslayoutData.minimumWidth =200;
		 keyslayoutData.horizontalAlignment = SWT.FILL;
		 keyslayoutData.grabExcessHorizontalSpace = true;
		 keysCombo.setLayoutData(keyslayoutData);
	 	 
		 // selection listener 
		 keysCombo.addSelectionListener(new SelectionAdapter() {
			 @Override
			public void widgetSelected(SelectionEvent e) {
			  updateRampartUI();
			}
		 }); 
	 	 
		 // text modification listener
	 	 keysCombo.addModifyListener(new ModifyListener() {		
			@Override
			public void modifyText(ModifyEvent e) {
				updateRampartUI();
			}
		});
		 
		 new Label(compositeBasicInfo, SWT.None);
		
		 String[] secEnable = new String[]{"No","yes"};
		 managedForm.getToolkit().createLabel(compositeBasicInfo, "Enable Security :");
		 enableSecCombo = new Combo(compositeBasicInfo, SWT.FLAT | SWT.READ_ONLY);
		 enableSecCombo.setItems(secEnable);
		 enableSecCombo.select(0);
		 GridData enableSeclayoutData = new GridData();
		 enableSeclayoutData.minimumWidth =200;
		 enableSeclayoutData.horizontalAlignment = SWT.FILL;
		 enableSeclayoutData.grabExcessHorizontalSpace = true;
		 enableSecCombo.setLayoutData(enableSeclayoutData);
		 enableSecCombo.addSelectionListener(new SelectionAdapter() {
			 @Override
			public void widgetSelected(SelectionEvent e) {
				 int selectionIndex = enableSecCombo.getSelectionIndex();
				if (selectionIndex == 0) {
					if (saveButton != null) {
						saveButton.setEnabled(false);
						if (secSecurity != null) {
							secSecurity.setEnabled(false);
						}
					}
				} else {
					if (saveButton != null && policySelected) {
						saveButton.setEnabled(true);
					}
					if (secSecurity != null) {
						secSecurity.setEnabled(true);
					}
				}
			}
		});

		 saveButton = managedForm.getToolkit().createButton(compositeBasicInfo, "Save",SWT.FLAT| Window.getDefaultOrientation());
		 GridData enableSecBtnlayoutData = new GridData();
		 enableSecBtnlayoutData.horizontalAlignment = SWT.FILL;
		 enableSecBtnlayoutData.grabExcessHorizontalSpace = true;
		 saveButton.setLayoutData(enableSecBtnlayoutData);
		 saveButton.setEnabled(false);
		 saveButton.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) { 
				    try {
				    	save();
					} catch (Exception e1) {
						 log.error("cannot load service meta file", e1);
					}
				}
			});
		 
		result = CreateMainSection(managedForm, body,"Security for the service", 10, 70, 600, 30, false);
	    secSecurity = (Section) result[0];
	    secSecurity.setEnabled(false);
		final Composite seccomposite = (Composite) result[1];
		GridLayout gridSecLayout = new GridLayout(5, false);
		seccomposite.setLayout(gridSecLayout);
		
		createCategory(managedForm, seccomposite, "Basic Scenarios");
		createSecurityItems(seccomposite, SecurityPolicyUtils.getInstance().getBasicSecurityScenarios(), managedForm,0);

		createCategory(managedForm, seccomposite, "Advanced Scenarios");
		createSecurityItems(seccomposite, SecurityPolicyUtils.getInstance().getAdvancedSecurityScenarios(), managedForm,4);

		createCategory(managedForm, seccomposite, "Policy From Registry");
		createSecurityItems(seccomposite, SecurityPolicyUtils.getInstance().getRegistrySecurityScenarios(), managedForm,20);
        
		Object[] aAdresult = CreateMainSection(managedForm, body,"Advance Configuration(Rampart)",10, 15, 600, 30, true);
		Composite rmaportInfComposite = (Composite)aAdresult[1];
		GridLayout ramportlayout = new GridLayout();
		rmaportInfComposite.setLayout(ramportlayout);
		
		Object[] ramBasicresult = CreateMainSection(managedForm, rmaportInfComposite,"Rampart Configuration",10, 20, 600, 30, true);
		Composite rampartBasic = (Composite)ramBasicresult[1];
		GridLayout ramparlayout = new GridLayout(2,false);
		rampartBasic.setLayout(ramparlayout);
		Section ramBasicSec = (Section)ramBasicresult[0];
		ramBasicSec.setExpanded(false);
		
		
	/*	Composite rampartBasic = new Composite(rmaportInfComposite, SWT.NULL);
		GridLayout rampartBasiclayout = new GridLayout(2,false);
		rampartBasic.setLayout(rampartBasiclayout);*/
		
		 managedForm.getToolkit().createLabel(rampartBasic, "User :");
		 Text rmUser = managedForm.getToolkit().createText(rampartBasic, " ");
		 GridData rmUserlayoutData = new GridData();
		 rmUserlayoutData.minimumWidth =200;
		 rmUserlayoutData.horizontalAlignment = SWT.FILL;
		 rmUserlayoutData.grabExcessHorizontalSpace = true;
		 rmUser.setLayoutData(rmUserlayoutData);
		 basicRampartControlMap.put(RAMPART_USER, rmUser);
		
		 managedForm.getToolkit().createLabel(rampartBasic, "encryptionUser :");
		 Text encryptionUser = managedForm.getToolkit().createText(rampartBasic, " ");
		 GridData encryptionUserlayoutData = new GridData();
		 encryptionUserlayoutData.minimumWidth =200;
		 encryptionUserlayoutData.horizontalAlignment = SWT.FILL;
		 encryptionUserlayoutData.grabExcessHorizontalSpace = true;
		 encryptionUser.setLayoutData(encryptionUserlayoutData);
		 basicRampartControlMap.put(RAMPART_ENCRYPTION_USER, encryptionUser);
		 
		 
		 String[] values = new String[]{"false","true"};
		 managedForm.getToolkit().createLabel(rampartBasic, "PrecisionInMilliseconds :");
		 Combo timestampPrecisionInMilliseconds = new Combo(rampartBasic, SWT.READ_ONLY);
		 timestampPrecisionInMilliseconds.setItems(values);
		 GridData timestampPrecisionInMillisecondslayoutData = new GridData();
		 timestampPrecisionInMillisecondslayoutData.minimumWidth =200;
		 timestampPrecisionInMillisecondslayoutData.horizontalAlignment = SWT.FILL;
		 timestampPrecisionInMillisecondslayoutData.grabExcessHorizontalSpace = true;
		 timestampPrecisionInMilliseconds.setLayoutData(timestampPrecisionInMillisecondslayoutData);
		 basicRampartControlMap.put(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS, timestampPrecisionInMilliseconds);
		 
		 
		 managedForm.getToolkit().createLabel(rampartBasic, "timestampTTL :");
		 Text timestampTTL = managedForm.getToolkit().createText(rampartBasic, " ");
		 GridData timestampTTLlayoutData = new GridData();
		 timestampTTLlayoutData.minimumWidth =200;
		 timestampTTLlayoutData.horizontalAlignment = SWT.FILL;
		 timestampTTLlayoutData.grabExcessHorizontalSpace = true;
		 timestampTTL.setLayoutData(timestampTTLlayoutData);
		 basicRampartControlMap.put(RAMPART_TIMESTAMP_TTL, timestampTTL);
		 
		 managedForm.getToolkit().createLabel(rampartBasic, "timestampMaxSkew :");
		 Text timestampMaxSkew = managedForm.getToolkit().createText(rampartBasic, " ");
		 GridData timestampMaxSkewlayoutData = new GridData();
		 timestampMaxSkewlayoutData.minimumWidth =200;
		 timestampMaxSkewlayoutData.horizontalAlignment = SWT.FILL;
		 timestampMaxSkewlayoutData.grabExcessHorizontalSpace = true;
		 timestampMaxSkew.setLayoutData(timestampMaxSkewlayoutData);
		 basicRampartControlMap.put(RAMPART_TIMESTAMP_MAX_SKEW, timestampMaxSkew);
		 
		 managedForm.getToolkit().createLabel(rampartBasic, "timestampStrict :");
		 Combo timestampStrict = new Combo(rampartBasic, SWT.READ_ONLY);
		 timestampStrict.setItems(values);
		 GridData timestampStrictlayoutData = new GridData();
		 timestampStrictlayoutData.minimumWidth =200;
		 timestampStrictlayoutData.horizontalAlignment = SWT.FILL;
		 timestampStrictlayoutData.grabExcessHorizontalSpace = true;
		 timestampStrict.setLayoutData(timestampStrictlayoutData);
		 basicRampartControlMap.put(RAMPART_TIMESTAMP_STRICT, timestampStrict);
		 
		 
		 managedForm.getToolkit().createLabel(rampartBasic, "tokenStoreClass :");
		 Text tokenStoreClass = managedForm.getToolkit().createText(rampartBasic, " ");
		 GridData tokenStoreClasslayoutData = new GridData();
		 tokenStoreClasslayoutData.minimumWidth =200;
		 tokenStoreClasslayoutData.horizontalAlignment = SWT.FILL;
		 tokenStoreClasslayoutData.grabExcessHorizontalSpace = true;
		 tokenStoreClass.setLayoutData(tokenStoreClasslayoutData);
		 basicRampartControlMap.put(RAMPART_TOKEN_STORE_CLASS, tokenStoreClass);
		 
		 	 
		 managedForm.getToolkit().createLabel(rampartBasic, "nonceLifeTime :");
		 Text nonceLifeTime = managedForm.getToolkit().createText(rampartBasic, " ");
		 GridData nonceLifeTimelayoutData = new GridData();
		 nonceLifeTimelayoutData.minimumWidth =200;
		 nonceLifeTimelayoutData.horizontalAlignment = SWT.FILL;
		 nonceLifeTimelayoutData.grabExcessHorizontalSpace = true;
		 nonceLifeTime.setLayoutData(nonceLifeTimelayoutData);
		 basicRampartControlMap.put(RAMPART_NONCE_LIFE_TIME, nonceLifeTime);
		 
	    Object[] enresult = CreateMainSection(managedForm, rmaportInfComposite,"Encryption Properties",10, 20, 600, 30, true);
	    Composite enComposite = (Composite)enresult[1];
	    GridLayout enlayout = new GridLayout(2,false);
	    enComposite.setLayout(enlayout);
	    Section enSec = (Section)enresult[0];
	    enSec.setExpanded(false);
	    
	    Object[] signresult = CreateMainSection(managedForm, rmaportInfComposite,"Signature Properties",10, 30, 600, 30, true);
	    Composite signComposite = (Composite)signresult[1];
	    GridLayout signlayout = new GridLayout(2,false);
	    signComposite.setLayout(signlayout);
	    Section signSec = (Section)signresult[0];
	    signSec.setExpanded(false);
	    
	    String[] rmpartConfigs = new  String[] {
	    		ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS+":Alias",
	    		ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE+":Privatestore",
	    		ORG_WSO2_STRATOS_TENANT_ID+":Tenant id",
	    		ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES+":Truststores",
	    		RAMPART_CONFIG_USER+":User"};
	  		for (String name : rmpartConfigs) {
	  			 createRampartProperties(managedForm, enComposite, name,"en");
	  			 createRampartProperties(managedForm, signComposite, name,"sign");
	  		}
	  		

     /*  CreateMainSection(managedForm, body,"Policies",10, 30, 600, 30, false);
		 CreateMainSection(managedForm, body,"Response Caching",10, 50, 600, 30, false);
		 CreateMainSection(managedForm, body,"Access Throttling",10, 60, 600, 30, false);
		 CreateMainSection(managedForm, body,"MTOM",10, 70, 600, 30, false);
		 CreateMainSection(managedForm, body,"Transports",10, 80, 600, 30, false);
		 CreateMainSection(managedForm, body,"Modules",10, 90, 600, 30, false);
		 CreateMainSection(managedForm, body,"Operations",10, 100, 600, 30, false);
		 CreateMainSection(managedForm, body,"Parameters",10, 110, 600, 30, false);
		 
		 */
	  updateRampartUI();
	  if(metaFile!=null){
		  	updateSecuritySecUI(metaFile);
	  }
	}
	
	private void save(){
		try {
			addPolicy();
			saveTofile();
			getRampartConfig(serviceMetaFile);
			saveRampartConifgUserValues();
			setRampartConfig();
		    saveRampartConfigToFile(serviceMetaFile);
		    RefreshProject();
		} catch (Exception e) {
			log.error("Saving Error");
			e.printStackTrace();
		} 
	}
	
	private void updateRampartUI(){
		if(enControlMap.size()>0){
			if (StringUtils.isNotBlank(keysCombo.getText())) {
				//String keyName = keysCombo.getItem(keysCombo.getSelectionIndex());	
				String keyName = keysCombo.getText();		
				String alise = "";
				
				if (keyStoreMap.get(keyName) != null) {
					alise = keyStoreMap.get(keyName);
				}
				
				// encryption properties
				enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText(alise);
				enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(keyName);
				enControlMap.get(ORG_WSO2_STRATOS_TENANT_ID).setText("-1234");
				enControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(keyName);
				enControlMap.get(RAMPART_CONFIG_USER).setText(alise);
				
				// signature properties
				singControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS).setText(alise);
				singControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE).setText(keyName);
				singControlMap.get(ORG_WSO2_STRATOS_TENANT_ID).setText("-1234");
				singControlMap.get(ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES).setText(keyName);
				singControlMap.get(RAMPART_CONFIG_USER).setText(alise);
				
				// rampart configuration
				Text txt = (Text)basicRampartControlMap.get(RAMPART_USER);
				txt.setText(alise);
				
			    txt =(Text)basicRampartControlMap.get(RAMPART_ENCRYPTION_USER);
				txt.setText("useReqSigCert");
				
				txt =(Text)basicRampartControlMap.get(RAMPART_TIMESTAMP_TTL);
				txt.setText("300");
				
				txt =(Text)basicRampartControlMap.get(RAMPART_TIMESTAMP_MAX_SKEW);
				txt.setText("300");
				
				txt =(Text)basicRampartControlMap.get(RAMPART_TOKEN_STORE_CLASS);
				txt.setText("org.wso2.carbon.security.util.SecurityTokenStore");
				
				txt =(Text)basicRampartControlMap.get(RAMPART_NONCE_LIFE_TIME);
				txt.setText("300");
				
				Combo	co =(Combo)basicRampartControlMap.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS);
				co.select(1);
				
				co =(Combo)basicRampartControlMap.get(RAMPART_TIMESTAMP_STRICT);
				co.select(0);
			}
		}
	}
	
    private void updateSecuritySecUI(File file){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ServiceGroup.class);
			Unmarshaller uUnmarshaller = jaxbContext.createUnmarshaller();
			serviceGroup = (ServiceGroup) uUnmarshaller.unmarshal(file);

			List<Service> services = serviceGroup.getService();
			for (Service sService : services) {
					service = sService;
					break;
			}
			 serviceNameText.setItems(new String[]{service.getName()});
			 serviceNameText.select(0);
			 Policies policies = service.getPolicies();
			if (policies != null) {
				List<Policy> policy = policies.getPolicy();
				for (Policy policy2 : policy) {
					Button button = policyeMap.get(policy2.getPolicyUUID());
					if (button != null) {
						button.setSelection(true);
						setPolicyFileName((String) button.getData());
						selectedPolicy = SecurityPolicyUtils.getInstance()
								.getPolicyTypeFromPolicyUUID(policy2.getPolicyUUID());
						break;
					}
				}
				enableSecCombo.select(1);
				secSecurity.setEnabled(true);
				saveButton.setEnabled(true);
				enableButtons(selectedPolicy);
			}
			
			 serviceMetaFile = file;
		} catch (Exception e) {
			 log.error("File loading error", e);
		}

	}
	
	private void createRampartProperties(IManagedForm managedForm,
			Composite enComposite, String fullname,String prefix) {
		String[] split = fullname.split(":");
		String name = split[1];
		managedForm.getToolkit().createLabel(enComposite, name+":");
		 Text en = managedForm.getToolkit().createText(enComposite, " ");
		 GridData enlayoutData = new GridData();
		 enlayoutData.minimumWidth =200;
		 enlayoutData.horizontalAlignment = SWT.FILL;
		 enlayoutData.grabExcessHorizontalSpace = true;
		 en.setLayoutData(enlayoutData);
		 en.setData(name, split[0]);
		// en.setd
		 if("en".equals(prefix)){
			 enControlMap.put(split[0], en);
		 }else{
			 singControlMap.put(split[0], en);
		 }
		 
	}

	private void readKeyStore() {
		try{
			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

			String filePath = preferenceStore.getString("org.wso2.developerstudio.eclipse.platform.ui",
					ClientTrustStorePreferencePage.TRUST_STORE_LOCATION,null,null);

			String password = preferenceStore.getString("org.wso2.developerstudio.eclipse.platform.ui",
					ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD,null,null);

			//Fixing TOOLS-2272 - checked filePath and password for null
			if (filePath != null && password != null) {
				keyStore.load(new FileInputStream(new File(filePath)),
						password.toCharArray());

				String[] split = filePath.split(File.separator);
				String alis = null;
				Enumeration<String> aliases = keyStore.aliases();
				while (aliases.hasMoreElements()) {
					alis = (String) aliases.nextElement();
					break;
				}

				keyStoreMap.put(split[split.length - 1], alis);
			}
			
		} catch (Exception e) {
			log.error("Custom Key-store not found", e);
		}
	}
	
	private void addPolicy() throws JAXBException, IOException,
			PropertyException, CoreException, ParserConfigurationException, SAXException, TransformerException {
		if(service == null) {
		
         serviceMetaFile = QoSDashboardPage.metaProject.getFile("src/main/resources/" + QoSDashboardPage.metaFileName)
				.getLocation().toFile();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ServiceGroup.class);
		Unmarshaller uUnmarshaller = jaxbContext.createUnmarshaller();
		serviceGroup = (ServiceGroup) uUnmarshaller.unmarshal(serviceMetaFile);

		List<Service> services = serviceGroup.getService();
		for (Service sService : services) {
			if (QoSDashboardPage.serviceName.equals(sService.getName())) {
				service = sService;
				break;
			}
		}
       }
		if (service != null) {
			QoSTemplateUtil qoSTemplateUtil = new QoSTemplateUtil();
			String filename = "";
			File resourceFile = null;
			
			filename = "policies/" + getPolicyFileName();
			resourceFile = qoSTemplateUtil.getResourceFile(filename);
						
			if (resourceFile != null) {
				JAXBContext pjaxbContext = JAXBContext
						.newInstance(Policy2.class);
				Unmarshaller pUnmarshaller = pjaxbContext.createUnmarshaller();
				Policy2 policy2 = (Policy2) pUnmarshaller
						.unmarshal(resourceFile);

				Policy policy = new Policy();
				policy.setPolicy(policy2);
				policy.setPolicyType(BigInteger.valueOf(9l));
				policy.setPolicyUUID(policy2.getId());
				Policies policies = new Policies();
				policies.getPolicy().add(policy);
				service.setPolicies(policies);
				
				//Define roles in UsernameToken based security policies.
				if (StringUtils.isNotBlank(selectedPolicy)
						&& utRoles != null
						&& utRoles.size() > 0
						&& (SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy)
								|| SecurityPolicies.POLICY_TYPE_7.equals(selectedPolicy)
								|| SecurityPolicies.POLICY_TYPE_8.equals(selectedPolicy)
								|| SecurityPolicies.POLICY_TYPE_14.equals(selectedPolicy) 
								|| SecurityPolicies.POLICY_TYPE_15.equals(selectedPolicy))) {
					
					String allowRoles = getAllowRoles();
					if(StringUtils.isNotBlank(allowRoles)) {
						addParameter(ALLOW_ROLES_PARAMETER, allowRoles, null);
					}
		
					List<String> remove = new ArrayList<String>();
					remove.add(REGISTRY_POLICY_PARAMETER);
					removeParameters(remove);

				} else if (StringUtils.isNotBlank(selectedPolicy)
						&& SecurityPolicies.POLICY_TYPE_21.equals(selectedPolicy)) {
					
					addParameter(REGISTRY_POLICY_PARAMETER, policyPathText.getText().trim(), new BigInteger("1"));
					
					String allowRoles = getAllowRoles();
					if(StringUtils.isNotBlank(allowRoles)) {
						addParameter(ALLOW_ROLES_PARAMETER, allowRoles, null);
					}

				} else {
					List<String> remove = new ArrayList<String>();
					remove.add(REGISTRY_POLICY_PARAMETER);
					remove.add(ALLOW_ROLES_PARAMETER);
					removeParameters(remove);
				}
				
				Bindings bindings = service.getBindings();
				if (bindings != null) {
					List<Binding> bindingList = bindings.getBinding();
					for (Binding binding : bindingList) {
						if (StringUtils.isNotBlank(binding.getName())) {
							binding.setPolicyUUID(policy2.getId());
						}
					}
				}
				
				service.setBindings(bindings);
				
				configureAssociation();
				configureRampartRahasModules();
			}
		}
	}

	private void saveTofile() throws JAXBException,
			PropertyException, CoreException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ServiceGroup.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(serviceGroup, serviceMetaFile);

		RefreshProject();
	}

	private void RefreshProject() throws CoreException {
		if (QoSDashboardPage.metaProject != null) {
			QoSDashboardPage.metaProject.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		}
	}

	private void getRampartConfig(File serviceMeta) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	 	doc = dBuilder.parse(serviceMeta);
		
	 	Node policies = doc.getElementsByTagName("policies").item(0);
	 	Element  epolicies= (Element) policies;	
	 	Node policy = epolicies.getElementsByTagName("policy").item(0);
	 	Element  epolicy= (Element) policy;	
	 	Node policyUUID = epolicy.getElementsByTagName("policyUUID").item(0);
	 	
	 	kerberossignandencrypt = policyUUID.getTextContent().equals("kerberossignandencrypt");
		Node nrampart = epolicy.getElementsByTagName("rampart:RampartConfig").item(0);
		rampart = (Element) nrampart;	
		
		if (!kerberossignandencrypt) {
			Node user = rampart.getElementsByTagName(RAMPART_USER).item(0);
			if(user != null) {
				configMap.put(RAMPART_USER, user.getTextContent());
			}
			
			Node encryptionUser = rampart.getElementsByTagName(RAMPART_ENCRYPTION_USER).item(0);
			if(encryptionUser != null) {
				configMap.put(RAMPART_ENCRYPTION_USER, encryptionUser.getTextContent());
			}
			
		}
		
		Node timestampPrecisionInMilliseconds = rampart.getElementsByTagName(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
		if(timestampPrecisionInMilliseconds != null) {
			configMap.put(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS, timestampPrecisionInMilliseconds.getTextContent());
		}
		
		Node timestampTTL = rampart.getElementsByTagName(RAMPART_TIMESTAMP_TTL).item(0);
		if(timestampTTL != null) {
			configMap.put(RAMPART_TIMESTAMP_TTL, timestampTTL.getTextContent());
		}
			
		Node timestampMaxSkew = rampart.getElementsByTagName(RAMPART_TIMESTAMP_MAX_SKEW).item(0);
		if(timestampMaxSkew != null) {
			configMap.put(RAMPART_TIMESTAMP_MAX_SKEW, timestampMaxSkew.getTextContent());
		}
		
		Node timestampStrict = rampart.getElementsByTagName(RAMPART_TIMESTAMP_STRICT).item(0);
		if(timestampStrict != null) {
			configMap.put(RAMPART_TIMESTAMP_STRICT, timestampStrict.getTextContent());
		}
		
		if (!kerberossignandencrypt) {
			Node tokenStoreClass = rampart.getElementsByTagName(RAMPART_TOKEN_STORE_CLASS).item(0);
			if(tokenStoreClass != null) {
				configMap.put(RAMPART_TOKEN_STORE_CLASS, tokenStoreClass.getTextContent());
			}
		}
		
		Node nonceLifeTime = rampart.getElementsByTagName(RAMPART_NONCE_LIFE_TIME).item(0);
		if(nonceLifeTime != null) {
			configMap.put(RAMPART_NONCE_LIFE_TIME, nonceLifeTime.getTextContent());
		}
		
		if (!kerberossignandencrypt) {
			// rampart:encryptionCrypto
		    Node encryptionCrypto = rampart.getElementsByTagName("rampart:encryptionCrypto").item(0);
		    if(encryptionCrypto != null) {
		    	addRampartCryptoProperties(encryptionCrypto);
		    }
		   
		    // rampart:signatureCrypto
		    Node signatureCrypto = rampart.getElementsByTagName("rampart:signatureCrypto").item(0);
		    if(signatureCrypto != null) {
		    	addRampartCryptoProperties(signatureCrypto);
		    }
		} else {
			// rampart:kerberosConfig
			Node kerberosConfig = rampart.getElementsByTagName("rampart:kerberosConfig").item(0);
			if(kerberosConfig != null) {
				addRampartKerberosConfigPropertis(kerberosConfig);
			}
		}

	}

	/**
	 * Add rampart:encryptionCrypto or rampart:signatureCrypto properties.
	 * @param crypto
	 */
	private void addRampartCryptoProperties(Node crypto) {
		Node encrypto = ((Element) crypto).getElementsByTagName("rampart:crypto").item(0);
	    
	    NodeList list = ((Element) encrypto).getChildNodes();
	    
	    for (int i = 0; i < list.getLength(); i++) {
	 		   Node node = list.item(i);
	 		  if("rampart:property".equals(node.getNodeName())){
	 			 Element eElement = (Element) node;
					 String attribute = eElement.getAttribute("name");
					 configMap.put(attribute, eElement.getTextContent());
	 		  }
	       }
	}
	
	/**
	 * Add rampart:kerberosConfig properties.
	 * @param kerberosConfig
	 */
	private void addRampartKerberosConfigPropertis(Node kerberosConfig) {
				
		NodeList list = ((Element) kerberosConfig).getChildNodes();
	    
		for (int i = 0; i < list.getLength(); i++) {
		 	Node node = list.item(i);
	 		if("rampart:property".equals(node.getNodeName())){
	 			 Element eElement = (Element) node;
					 String attribute = eElement.getAttribute("name");
					 configMap.put(attribute, eElement.getTextContent());
	       }
	    }
	}
	
	private Map<String,String> setRampartConfig() {
		
		if (!kerberossignandencrypt) {
			Node user = rampart.getElementsByTagName(RAMPART_USER).item(0);
			if(user != null) {
				user.setTextContent(configMap.get(RAMPART_USER));
			}
			
			Node encryptionUser = rampart.getElementsByTagName(RAMPART_ENCRYPTION_USER).item(0);
			if(encryptionUser != null && StringUtils.isNotBlank(configMap.get(RAMPART_ENCRYPTION_USER))){
				encryptionUser.setTextContent(configMap.get(RAMPART_ENCRYPTION_USER));
			}
		}
		
		Node timestampPrecisionInMilliseconds = rampart.getElementsByTagName(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS).item(0);
		if(timestampPrecisionInMilliseconds != null && StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS))) {
			timestampPrecisionInMilliseconds.setTextContent(configMap.get(RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS));
		}
		
		Node timestampTTL = rampart.getElementsByTagName(RAMPART_TIMESTAMP_TTL).item(0);
		if(timestampTTL != null && StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_TTL))) {
			timestampTTL.setTextContent(configMap.get(RAMPART_TIMESTAMP_TTL));
		}
		
		Node timestampMaxSkew = rampart.getElementsByTagName(RAMPART_TIMESTAMP_MAX_SKEW).item(0);
		if(timestampMaxSkew != null && StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_MAX_SKEW))) {
			timestampMaxSkew.setTextContent(configMap.get(RAMPART_TIMESTAMP_MAX_SKEW));
		}
		
		Node timestampStrict = rampart.getElementsByTagName(RAMPART_TIMESTAMP_STRICT).item(0);
		if(timestampStrict != null && StringUtils.isNotBlank(configMap.get(RAMPART_TIMESTAMP_STRICT))) {
			timestampStrict.setTextContent(configMap.get(RAMPART_TIMESTAMP_STRICT));
		}
		
		if (!kerberossignandencrypt) {
			Node tokenStoreClass = rampart.getElementsByTagName(RAMPART_TOKEN_STORE_CLASS).item(0);
			tokenStoreClass.setTextContent(configMap.get(RAMPART_TOKEN_STORE_CLASS));
		}
		
		Node nonceLifeTime = rampart.getElementsByTagName(RAMPART_NONCE_LIFE_TIME).item(0);
		if(nonceLifeTime != null && StringUtils.isNotBlank(configMap.get(RAMPART_NONCE_LIFE_TIME))) {
			nonceLifeTime.setTextContent(configMap.get(RAMPART_NONCE_LIFE_TIME));
		}

		if (!kerberossignandencrypt) {
		    Node encryptionCrypto = rampart.getElementsByTagName("rampart:encryptionCrypto").item(0);
		    if (encryptionCrypto != null) {
		    	setenCryto(encryptionCrypto);
		    }
		    
		    Node signatureCrypto = rampart.getElementsByTagName("rampart:signatureCrypto").item(0);
		    if(signatureCrypto != null) {
		    	setenCryto(signatureCrypto);
		    }
		} else {
			Node kerberosConfig = rampart.getElementsByTagName("rampart:kerberosConfig").item(0);
			if(kerberosConfig != null) {
				setKerberosConfig(kerberosConfig);
			}
		}
	    
		return configMap;
	}
	
	private void setenCryto(Node encryptionCrypto) {
		Node encrypto = ((Element) encryptionCrypto).getElementsByTagName("rampart:crypto").item(0);

		NodeList list = ((Element) encrypto).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && "rampart:property".equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute("name");
				if(StringUtils.isNotBlank(attribute)) {
					node.setTextContent(configMap.get(attribute));
				}
			}
		}
	}
	
		
	private void setKerberosConfig(Node kerberosConfig) {

		NodeList list = ((Element) kerberosConfig).getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node != null && "rampart:property".equals(node.getNodeName())) {
				Element eElement = (Element) node;
				String attribute = eElement.getAttribute("name");
				if(StringUtils.isNotBlank(attribute)) {
					node.setTextContent(configMap.get(attribute));
				}
			}
		}
	}

	private void saveRampartConfigToFile(File file) throws TransformerException{
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);
	}
  
	private void saveRampartConifgUserValues(){
		
      Set<String> keySet = basicRampartControlMap.keySet();
               for (String key : keySet) {
            	   Object control = basicRampartControlMap.get(key);
            	   if(control instanceof Text){
            		  Text  controlText  = (Text)control;
            		  configMap.put(key, controlText.getText());
            	   }else if(control instanceof Combo){
            		   Combo  controlCombo  = (Combo)control;
            		   configMap.put(key, controlCombo.getItem(controlCombo.getSelectionIndex())); 
            	   }
			   }
              keySet = enControlMap.keySet();
              for (String key : keySet) {
           	   Object control = enControlMap.get(key);
           	   if(control instanceof Text){
           		  Text  controlText  = (Text)control;
           		  configMap.put(key, controlText.getText());
           	   }
			 }  
             keySet = singControlMap.keySet();
              for (String key : keySet) {
           	   Object control = singControlMap.get(key);
           	   if(control instanceof Text){
           		  Text  controlText  = (Text)control;
           		  configMap.put(key, controlText.getText());
           	   }
			}   
	 }
	
	private void createSecurityItems(Composite seccomposite ,String[] names,IManagedForm managedForm,int i) {
		
		for (String name : names) {
			i++;
			final Button secBtn = new Button(seccomposite, SWT.RADIO);
			 secBtn.setText("");
			 secBtn.setToolTipText(name);
			 String fileName ="scenario"+i+"-policy.xml";
			 secBtn.setData(fileName);
			 secBtn.addSelectionListener(new SelectionAdapter() {
				 @Override
				public void widgetSelected(SelectionEvent e) {
					 String pfile = (String) secBtn.getData();
					 setPolicyFileName(pfile);
					 selectedPolicy = secBtn.getToolTipText();
					 policySelected = true;
					 saveButton.setEnabled(true);
					 
					// Enable/Disable buttons.
					if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_21)) {
						policyOneUserRolesButton.setVisible(false);
						policySevenUserRolesButton.setVisible(false);
						policyEightUserRolesButton.setVisible(false);
						policyFourteenUserRolesButton.setVisible(false);
						policyFifteenUserRolesButton.setVisible(false);
						policyTwentyOneUserRolesButton.setVisible(true);
						registryBrowser.setVisible(true);
						
					} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_1)) {
						policyOneUserRolesButton.setVisible(true);
						policySevenUserRolesButton.setVisible(false);
						policyEightUserRolesButton.setVisible(false);
						policyFourteenUserRolesButton.setVisible(false);
						policyFifteenUserRolesButton.setVisible(false);
						policyTwentyOneUserRolesButton.setVisible(false);
						registryBrowser.setVisible(false);
						
					} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_7)) {
						policyOneUserRolesButton.setVisible(false);
						policySevenUserRolesButton.setVisible(true);
						policyEightUserRolesButton.setVisible(false);
						policyFourteenUserRolesButton.setVisible(false);
						policyFifteenUserRolesButton.setVisible(false);	
						policyTwentyOneUserRolesButton.setVisible(false);
						registryBrowser.setVisible(false);
						
					} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_8)) {
						policyOneUserRolesButton.setVisible(false);
						policySevenUserRolesButton.setVisible(false);
						policyEightUserRolesButton.setVisible(true);
						policyFourteenUserRolesButton.setVisible(false);
						policyFifteenUserRolesButton.setVisible(false);
						policyTwentyOneUserRolesButton.setVisible(false);
						registryBrowser.setVisible(false);
						
					} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_14)) {
						policyOneUserRolesButton.setVisible(false);
						policySevenUserRolesButton.setVisible(false);
						policyEightUserRolesButton.setVisible(false);
						policyFourteenUserRolesButton.setVisible(true);
						policyFifteenUserRolesButton.setVisible(false);
						policyTwentyOneUserRolesButton.setVisible(false);
						registryBrowser.setVisible(false);
						
					} else if (secBtn.getToolTipText().equals(SecurityPolicies.POLICY_TYPE_15)) {
						policyOneUserRolesButton.setVisible(false);
						policySevenUserRolesButton.setVisible(false);
						policyEightUserRolesButton.setVisible(false);
						policyFourteenUserRolesButton.setVisible(false);
						policyFifteenUserRolesButton.setVisible(true);
						policyTwentyOneUserRolesButton.setVisible(false);
						registryBrowser.setVisible(false);
						
					} else {
						policyOneUserRolesButton.setVisible(false);
						policySevenUserRolesButton.setVisible(false);
						policyEightUserRolesButton.setVisible(false);
						policyFourteenUserRolesButton.setVisible(false);
						policyFifteenUserRolesButton.setVisible(false);
						policyTwentyOneUserRolesButton.setVisible(false);
						registryBrowser.setVisible(false);

					}
				}
			});
			 
			try {
				String filename = "policies/" + fileName;
				QoSTemplateUtil qoSTemplateUtil = new QoSTemplateUtil();
				File resourceFile = qoSTemplateUtil.getResourceFile(filename);
				if (resourceFile != null) {
					JAXBContext pjaxbContext = JAXBContext.newInstance(Policy2.class);
					Unmarshaller pUnmarshaller = pjaxbContext.createUnmarshaller();
					Policy2 policy2 = (Policy2) pUnmarshaller.unmarshal(resourceFile);
					policyeMap.put(policy2.getId(), secBtn);
				}

			} catch (Exception e) {
				/* Ignore */
				log.error("policy file reading", e);
			}
			
     		 final ToolTip tip = new ToolTip(seccomposite.getShell(), SWT.BALLOON | SWT.ICON_INFORMATION);
			 tip.setMessage("Description not available");

			  Hyperlink createHyperlink = managedForm.getToolkit().createHyperlink(seccomposite, name, SWT.RADIO);
			  createHyperlink.addHyperlinkListener(new HyperlinkAdapter(){
				  @Override
				public void linkActivated(HyperlinkEvent e) {
					 //Fixing TOOLS-2293.
					  //tip.setVisible(true);
				}
				  
			  });
			  
			if (SecurityPolicies.POLICY_TYPE_21.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = false;
				createHyperlink.setLayoutData(policyLinkGrdiData);
				
				policyPathText = new Text(seccomposite, SWT.NONE);
				policyPathText.setEnabled(false);
				GridData policyPathTextGridData = new GridData();
				policyPathTextGridData.horizontalAlignment = GridData.FILL;
				policyPathTextGridData.grabExcessHorizontalSpace = true;
				policyPathTextGridData.minimumWidth = 200;
				policyPathText.setLayoutData(policyPathTextGridData);
				
				registryBrowser = new Button(seccomposite, SWT.NONE);
				registryBrowser.setText("Browse From Registry");
				registryBrowser.setVisible(false);
				registryBrowser.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openRegistryDialog();
					}
				});
				GridData browseButtonGridData = new GridData();
				browseButtonGridData.horizontalAlignment = GridData.END;
				browseButtonGridData.grabExcessHorizontalSpace = false;
				registryBrowser.setLayoutData(browseButtonGridData);
				
				policyTwentyOneUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyTwentyOneUserRolesButton.setText("User Roles");
				policyTwentyOneUserRolesButton.setVisible(false);
				policyTwentyOneUserRolesButton.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						openUserRolesDialog();
					}
				});
				GridData userRolesButtonGridData = new GridData();
				userRolesButtonGridData.horizontalAlignment = GridData.BEGINNING;
				userRolesButtonGridData.grabExcessHorizontalSpace = false;
				policyTwentyOneUserRolesButton.setLayoutData(userRolesButtonGridData);
				
			} else if(SecurityPolicies.POLICY_TYPE_1.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);
				
				policyOneUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyOneUserRolesButton.setText("User Roles");
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
			} else if(SecurityPolicies.POLICY_TYPE_7.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);
				
				policySevenUserRolesButton = new Button(seccomposite, SWT.NONE);
				policySevenUserRolesButton.setText("User Roles");
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
			} else if(SecurityPolicies.POLICY_TYPE_8.equals(name)) {
				GridData policyLinkGrdiData = new GridData();
				policyLinkGrdiData.horizontalAlignment = GridData.BEGINNING;
				policyLinkGrdiData.grabExcessHorizontalSpace = true;
				policyLinkGrdiData.horizontalSpan = 3;
				createHyperlink.setLayoutData(policyLinkGrdiData);
				
				policyEightUserRolesButton = new Button(seccomposite, SWT.NONE);
				policyEightUserRolesButton.setText("User Roles");
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
				policyFourteenUserRolesButton.setText("User Roles");
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
				policyFifteenUserRolesButton.setText("User Roles");
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

	private Object[] CreateMainSection(IManagedForm managedForm,final Composite body,
			String sectionName,final int x, final int y, final int width, final int height, boolean expand) {
		 Object[] comp = new Object[2];
		final Section sctnCreate = managedForm.getToolkit().createSection(body, Section.TWISTIE | Section.TITLE_BAR);
		sctnCreate.setBounds(x, y, width, height);
		managedForm.getToolkit().paintBordersFor(sctnCreate);
		sctnCreate.setText(sectionName);
		sctnCreate.setExpanded(expand);
		/*GridData layoutData = new GridData();
		layoutData.minimumWidth = 600;
		layoutData.horizontalAlignment = SWT.FILL;
		layoutData.grabExcessHorizontalSpace = true;
		sctnCreate.setLayoutData(layoutData);*/
		sctnCreate.addExpansionListener(new IExpansionListener() {
			
			@Override
			public void expansionStateChanging(ExpansionEvent e) {
			}		
			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				if(!e.getState()){
			/*	sctnCreate.setBounds(x, y, width, height);	 
				GridData layoutData = (GridData)sctnCreate.getLayoutData();
				layoutData.minimumWidth = 600;
				layoutData.horizontalAlignment = SWT.FILL;
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.heightHint = sctnCreate.getBounds().height;
				body.layout();*/
				 
				}else{
			 /*   sctnCreate.setBounds(x, y, width, height*10);
			    GridData layoutData = (GridData)sctnCreate.getLayoutData();
			    layoutData.minimumWidth = 600;
			    layoutData.horizontalAlignment = SWT.FILL;
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.heightHint = sctnCreate.getBounds().height;
			    body.layout();*/
				}
			}
		});	
		comp[0]=sctnCreate;
		Composite composite = managedForm.getToolkit().createComposite(sctnCreate, SWT.NULL);
		managedForm.getToolkit().paintBordersFor(composite);
		sctnCreate.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		comp[1] = composite;
		
		return comp;
	}
	
	
	/**
	 * Create contents of category
	 * @param managedForm
	 * @param composite
	 * @param category
	 */
	private void createCategory(IManagedForm managedForm,Composite composite, String category){
		Label lblcategory = managedForm.getToolkit().createLabel(composite, category, SWT.NONE);
		lblcategory.setFont(SWTResourceManager.getFont("Sans", 10, SWT.BOLD));
		GridData gd_category = new GridData(SWT.FILL, SWT.CENTER, true, false,5, 1);
		gd_category.verticalIndent=10;
		lblcategory.setLayoutData(gd_category);
		 
	}
 
	/**
	 * Open a project wizard
	 * @param id 
	 */
	private IWizard openWizard(String id) {
		 IWizardDescriptor descriptor = PlatformUI.getWorkbench()
		   .getNewWizardRegistry().findWizard(id);
		 
		 try {
		   if (null != descriptor) {
			 IWorkbenchWizard wizard = descriptor.createWizard();
			 wizard.init(PlatformUI.getWorkbench(), getCurrentSelection());
		     WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), wizard);
		     wd.setTitle(wizard.getWindowTitle());
		     QOSProjectWizard qosProjectWizard = (QOSProjectWizard) wizard; 
		    // qosProjectWizard.setServiceName(QoSDashboardPage.serviceName);
           //  Service service = serviceList.get(QoSDashboardPage.serviceName);
             //qosProjectWizard.setService(service);
		     wd.open();
		///     metaProject = (IProject) qosProjectWizard.getCreatedResource();
		  //   metaFileName = qosProjectWizard.getMetaFileName();
		     return wizard;
		   }
 
		 } catch (CoreException e) {
					   log.error("Cannot open wizard",e);
		 }
		 return null;
		}
	
	/**
	 * Get current selection
	 * @return
	 */
	private IStructuredSelection getCurrentSelection() {
		if (selection instanceof IStructuredSelection) {
			return (IStructuredSelection) selection;
		}
		return new StructuredSelection();
	}
	
	public void dispose() {
		ISelectionService selectionService = getSite().getWorkbenchWindow()
				.getSelectionService();
		selectionService.removeSelectionListener(selectionListener);
		super.dispose();
	}

 
    public String getPolicyFileName() {
		return policyFileName;
	}

	public File getMetaFile() {
		return metaFile;
	}

	public void setMetaFile(File metaFile) {
		this.metaFile = metaFile;
	}

	public void setPolicyFileName(String policyFileName) {
		this.policyFileName = policyFileName;
	}

	private class MethodVisitor extends ASTVisitor {
	    List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();

	    @Override
	    public boolean visit(MethodDeclaration node) {
	            methods.add(node);
	            return super.visit(node);
	    }
	   
	    /**
	     *
	     * @return
	     */
	    public List<MethodDeclaration> getMethods() {
	            return methods;
	    }
	   
	}
	
	/**
	 * Open Registry browse dialog for Registry policy.
	 */
	private void openRegistryDialog() {
		if (registryKey == null) {
			registryKey = new RegistryKeyProperty();
		}

		RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getShell(), PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell().getStyle(),
				new ArrayList<NamedEntityDescriptor>(), registryKey);
		dialog.open();

		if (StringUtils.isNotBlank(registryKey.getKeyValue())) {
			policyPathText.setText(registryKey.getKeyValue());

			//String tmpPolicyFile = registryKey.getTempPolicyFilePath() + File.separator
			//		+ registryKey.getPolicyFileName();
			//setPolicyFileName(tmpPolicyFile);
		}

	}
	
	/**
	 * Open User Roles dialog for UT policy.
	 */
	private void openUserRolesDialog() {
		if(utRoles == null) {
			utRoles = new ArrayList<String>();
		} else {
			utRoles.clear();
		}
		
		UserRolesDialog dialog = new UserRolesDialog(PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getShell(), utRoles);
		dialog.open();
	}
	
	private void deleteTempFiles() {
		if (registryKey != null) {
			RegistryUtils.getInstance().deleteTempFiles(registryKey);
		}		
	}
	
	/**
	 * Add parameter to the service.
	 * @param parameterName
	 * @param parameterValue
	 * @param type
	 */
	private void addParameter(String parameterName, String parameterValue, BigInteger type) {
		Parameter newParameter = null;
		for(Object parameter : service.getModuleOrParameterOrPolicyUUID()){
			if (parameter instanceof Parameter
					&& StringUtils.isNotBlank(((Parameter) parameter).getName())
					&& ((Parameter) parameter).getName().equals(parameterName)) {
				// Set new value to the existing parameter. 
				newParameter = (Parameter) parameter;
				newParameter.setValue(parameterValue);
				break;
			}
		}
		
		if(newParameter == null) {
			// Create new parameter since it is not available.
			newParameter = new Parameter();
			newParameter.setName(parameterName);
			newParameter.setValue(parameterValue);
			if(type != null) {
				newParameter.setType(type);
			}
			
			// add parameter to the policy.
			service.getModuleOrParameterOrPolicyUUID().add(newParameter);
		}
	}
	
	/**
	 * Removes parameters from service.
	 * @param parameters
	 */
	private void removeParameters(List<String> parameters) {
		if (service != null) {
			List<Object> remove = new ArrayList<Object>();
			for (Object parameter : service.getModuleOrParameterOrPolicyUUID()) {
				if (parameter instanceof Parameter
						&& StringUtils.isNotBlank(((Parameter) parameter).getName())
						&& parameters.contains(((Parameter) parameter).getName())) {
					remove.add(parameter);
				}
			}
			
			for(Object parameter : remove) {
				service.getModuleOrParameterOrPolicyUUID().remove(parameter);
			}
		}
	}
	
	/**
	 * Get allow roles in role1,role2, format.
	 * @return
	 */
	private String getAllowRoles() {
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
	private void configureAssociation() {
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
			exposedTransportsAssociation
					.setDestinationPath("/repository/transports/https/listener");
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
	}
	
	/**
	 * Configure rampart and rahas modules.
	 */
	private void configureRampartRahasModules() {
		List<Object> moduleParamOrasociationList = service.getModuleOrParameterOrPolicyUUID();
		boolean rampartModuleFound = false;
		boolean rahasModuleFound = false;
		Object rahasModule = null;
		
		for (Object object : moduleParamOrasociationList) {
			if (object instanceof Module) {
				Module module = (Module)object;
				if (module.getName().equals("rampart")) {
					rampartModuleFound = true;
				} else if (module.getName().equals("rahas")) {
					if((SecurityPolicies.POLICY_TYPE_1.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_2.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_3.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_4.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_5.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_6.equals(selectedPolicy)
						|| SecurityPolicies.POLICY_TYPE_7.equals(selectedPolicy) 
						|| SecurityPolicies.POLICY_TYPE_8.equals(selectedPolicy))) {
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
						|| SecurityPolicies.POLICY_TYPE_7.equals(selectedPolicy) 
						|| SecurityPolicies.POLICY_TYPE_8.equals(selectedPolicy))) {
			Module module = new Module();
			module.setName("rahas");
			module.setVersion(RAHAS_MODULE_VERSION);
			module.setType("engagedModules");
			service.getModuleOrParameterOrPolicyUUID().add(module);
		} 
		
		if(!rampartModuleFound) {
			Module module = new Module();
			module.setName("rampart");
			module.setVersion(RAMPART_MODULE_VERSION);
			module.setType("engagedModules");
			service.getModuleOrParameterOrPolicyUUID().add(module);
		}
		
		if(rahasModule != null) {
			service.getModuleOrParameterOrPolicyUUID().remove(rahasModule);
		}
	}
	
	/**
	 * Enable buttons based on the selected policy.
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
			} else if (SecurityPolicies.POLICY_TYPE_21.equals(policyType)) {
				policyTwentyOneUserRolesButton.setVisible(true);
				registryBrowser.setVisible(true);
			}
		}
	}
	
}



