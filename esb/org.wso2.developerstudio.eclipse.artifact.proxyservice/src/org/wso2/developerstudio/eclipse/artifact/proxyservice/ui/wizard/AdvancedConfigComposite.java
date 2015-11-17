/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.ui.wizard;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.NamedEntityDescriptor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;

import static org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants.*;

import org.wso2.developerstudio.eclipse.artifact.proxyservice.model.ProxyServiceModel;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.model.ProxyServiceModel.TargetEPType;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.PsArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.validators.EndPointsList;

import static org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants.*;

import org.wso2.developerstudio.eclipse.platform.core.model.AbstractComposite;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;

import static org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants.*;

import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class AdvancedConfigComposite extends AbstractComposite {

	private static final String SYMBOLIC_NAME = "org.wso2.developerstudio.eclipse.artifact.proxyservice";
	private static final String REG_BROWSE_TOOL_TIP = "browse key from registry, workspace or local entries";
	private ProxyServiceModel model;

	/* common */
	private Label lblTargetEndpoint;
	private Text txtEndPointUrl;
	private Text txtEndPointkey;
	private Label lbltxtEndPointUrl;
	private Label lblEndpoint;
	private Combo cmbPredefinedEP;
	private Label lblEndPointkey;
	private Button cmdEndPointRegBrowse;
	private Button optPredefinedEndpoint;
	private Button optfromRegistry;
	private Button optEnterURL;

	private SelectionListener optListener;

	/* Transformer Proxy */
	private Label lblReqXSLT;
	private Text txtReqXSLT;

	private Button chkTransformResponses;

	private Label lblResponseXSLT;
	private Text txtResponseXSLT;

	private Button cmdReqXSLTRegBrowse;
	private Button cmdResXSLTRegBrowse;

	/* Logging proxy */
	private Label lblReqLogLevel;
	private Combo cmbReqLogLevel;
	private Label lblResLogLevel;
	private Combo cmbResLogLevel;

	private String[] logLevelList = { "None", "Full", "Simple" };

	/* wsdl based proxy */

	private Label lblWsdlUri;
	private Text txtWsdlUri;
	private Label lblWsdlPort;
	private Text txtWsdlPort;
	private Label lblWsdlService;
	private Text txtWsdlService;
	private Button publishSameServiceContract;
	private Button cmdTestUri;

	/* secure proxy */
	private Label lblSecPolicy;
	private Text txtSecPolicy;
	private Button cmdSecPolicyRegBrowse;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param model
	 */
	public AdvancedConfigComposite(Composite parent, int style,
			ProjectDataModel model, ProjectOptionData optionData,
			WizardPage wizardPage) {
		super(parent, style, model, optionData, wizardPage);
		setLayout(new GridLayout(5, false));
		setModel((ProxyServiceModel) getProjectModel());

		/* common */
		lblTargetEndpoint = new Label(this, SWT.NONE);
		lblTargetEndpoint.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		lblTargetEndpoint.setText("Target Endpoint");

		optEnterURL = new Button(this, SWT.RADIO);
		optEnterURL.setSelection(true);

		optListener = new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				if (optEnterURL.getSelection()) {
					hideControls(lblEndPointkey, txtEndPointkey,
							cmdEndPointRegBrowse);
					hideControls(lblEndpoint, cmbPredefinedEP);
					showControls(lbltxtEndPointUrl, txtEndPointUrl);
					setModelPropertyValue("proxy.target.ep.type",
							TargetEPType.URL);
				} else if (optPredefinedEndpoint.getSelection()) {
					hideControls(lblEndPointkey, txtEndPointkey,
							cmdEndPointRegBrowse);
					hideControls(lbltxtEndPointUrl, txtEndPointUrl);
					showControls(lblEndpoint, cmbPredefinedEP);
					setModelPropertyValue("proxy.target.ep.type",
							TargetEPType.PREDEFINED);
				} else if (optfromRegistry.getSelection()) {
					hideControls(lblEndpoint, cmbPredefinedEP);
					hideControls(lbltxtEndPointUrl, txtEndPointUrl);
					showControls(lblEndPointkey, txtEndPointkey,
							cmdEndPointRegBrowse);
					setModelPropertyValue("proxy.target.ep.type",
							TargetEPType.REGISTRY);
				}
				AdvancedConfigComposite.this.layout();
			}
		};

		optEnterURL.setText("Enter URL");

		optPredefinedEndpoint = new Button(this, SWT.RADIO);
		optPredefinedEndpoint.setText("Predefined Endpoint");

		optfromRegistry = new Button(this, SWT.RADIO);

		optfromRegistry.addSelectionListener(optListener);
		optEnterURL.addSelectionListener(optListener);
		optPredefinedEndpoint.addSelectionListener(optListener);

		optfromRegistry.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		optfromRegistry.setText("Pick from Registry");

		lbltxtEndPointUrl = new Label(this, SWT.NONE);
		lbltxtEndPointUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		lbltxtEndPointUrl.setText("EndPoint URL");

		txtEndPointUrl = new Text(this, SWT.BORDER);
		txtEndPointUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 4, 1));
		txtEndPointUrl.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPURL,
						txtEndPointUrl.getText());
			}
		});

		lblEndpoint = new Label(this, SWT.NONE);
		lblEndpoint.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblEndpoint.setText("EndPoint");
		hideControls(lblEndpoint);

		cmbPredefinedEP = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData gd_cmbPredefinedEP = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		gd_cmbPredefinedEP.widthHint = 100;
		cmbPredefinedEP.setLayoutData(gd_cmbPredefinedEP);
		
		EndPointsList epListProvider = new EndPointsList();
		List<ListData> epList = epListProvider.getListData(null,null);
		
		for(ListData listData: epList){
			if(null!=listData.getData()){
			cmbPredefinedEP.add((String) listData.getData());
			}
		}
		cmbPredefinedEP.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPLIST,
						cmbPredefinedEP.getText());

			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);

			}
		});
		hideControls(cmbPredefinedEP);

		// EndPoint key

		lblEndPointkey = new Label(this, SWT.NONE);
		lblEndPointkey.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblEndPointkey.setText("EndPoint key");
		hideControls(lblEndPointkey);

		txtEndPointkey = new Text(this, SWT.BORDER);
		GridData gd_txtEndPointkey = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		txtEndPointkey.setLayoutData(gd_txtEndPointkey);
		txtEndPointkey.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_COMMON_PS_EPKEY,
						txtEndPointkey.getText());

			}
		});
		hideControls(txtEndPointkey);
		
		cmdEndPointRegBrowse = new Button(this, SWT.NONE);
		cmdEndPointRegBrowse.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 2, 1));
		cmdEndPointRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry.png"));
		cmdEndPointRegBrowse.setToolTipText(REG_BROWSE_TOOL_TIP);
		cmdEndPointRegBrowse.setText("Browse...");
		cmdEndPointRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtEndPointkey,MEDIA_TYPE_ENDPOINT);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});

		hideControls(cmdEndPointRegBrowse);

		/* Transformer Proxy */
		lblReqXSLT = new Label(this, SWT.NONE);
		lblReqXSLT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblReqXSLT.setText("Request XSLT");

		txtReqXSLT = new Text(this, SWT.BORDER);
		GridData gd_txtReqXSLT = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		txtReqXSLT.setLayoutData(gd_txtReqXSLT);
		txtReqXSLT.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_XSLT,
						txtReqXSLT.getText());

			}
		});
		
		cmdReqXSLTRegBrowse = new Button(this, SWT.NONE);
		cmdReqXSLTRegBrowse.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 2, 1));
		cmdReqXSLTRegBrowse.setText("Browse...");
		cmdReqXSLTRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtReqXSLT, MEDIA_TYPE_XSLT);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		cmdReqXSLTRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry.png"));
		cmdReqXSLTRegBrowse.setToolTipText(REG_BROWSE_TOOL_TIP);

		chkTransformResponses = new Button(this, SWT.CHECK);
		chkTransformResponses.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 5, 1));
		chkTransformResponses.setText("Transform Responses");
		chkTransformResponses.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_TRANSFORMRESPONSES,
						((Button) e.widget).getSelection());
				if (((Button) e.widget).getSelection()) {
					//showControls(lblResponseXSLT, txtResponseXSLT,
					//		cmdResXSLTRegBrowse);
					enableControls(lblResponseXSLT, txtResponseXSLT,
							cmdResXSLTRegBrowse);
				} else {
					//hideControls(lblResponseXSLT, txtResponseXSLT,
					//		cmdResXSLTRegBrowse);
					disableControls(lblResponseXSLT, txtResponseXSLT,
							cmdResXSLTRegBrowse);
				}
				AdvancedConfigComposite.this.layout();
			}
		});

		lblResponseXSLT = new Label(this, SWT.NONE);
		lblResponseXSLT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblResponseXSLT.setText("Response XSLT");
		//hideControls(lblResponseXSLT);
		disableControls(lblResponseXSLT);

		txtResponseXSLT = new Text(this, SWT.BORDER);
		GridData gd_txtResponseXSLT = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		txtResponseXSLT.setLayoutData(gd_txtResponseXSLT);
		txtResponseXSLT.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_TRANSFORMER_PS_RESXSLT,
						txtResponseXSLT.getText());

			}
		});
		//hideControls(txtResponseXSLT);
		disableControls(txtResponseXSLT);
		
		cmdResXSLTRegBrowse = new Button(this, SWT.NONE);
		cmdResXSLTRegBrowse.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 2, 1));
		cmdResXSLTRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry.png"));
		cmdResXSLTRegBrowse.setToolTipText(REG_BROWSE_TOOL_TIP);
		cmdResXSLTRegBrowse.setText("Browse..");
		cmdResXSLTRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtResponseXSLT, MEDIA_TYPE_XSLT);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		//hideControls(cmdResXSLTRegBrowse);
		disableControls(cmdResXSLTRegBrowse);

		/* logging proxy */
		lblReqLogLevel = new Label(this, SWT.NONE);
		lblReqLogLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblReqLogLevel.setText("Request Log Level");
		hideControls(lblReqLogLevel);

		cmbReqLogLevel = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmbReqLogLevel.setItems(logLevelList);
		cmbReqLogLevel.select(0);
		GridData gd_ReqLogLevel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		gd_ReqLogLevel.widthHint = 100;
		cmbReqLogLevel.setLayoutData(gd_ReqLogLevel);
		cmbReqLogLevel.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_LOGGING_PS_REQLOGLEVEL,
						cmbReqLogLevel.getText());

			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		hideControls(cmbReqLogLevel);

		lblResLogLevel = new Label(this, SWT.NONE);
		lblResLogLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblResLogLevel.setText("Response Log Level");
		hideControls(lblResLogLevel);

		cmbResLogLevel = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmbResLogLevel.setItems(logLevelList);
		cmbResLogLevel.select(0);
		GridData gd_ResLogLevel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		gd_ResLogLevel.widthHint = 100;
		cmbResLogLevel.setLayoutData(gd_ResLogLevel);
		cmbResLogLevel.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_LOGGING_PS_RESLOGLEVEL,
						cmbResLogLevel.getText());

			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);

			}
		});
		hideControls(cmbResLogLevel);

		/* WSDL based */

		lblWsdlUri = new Label(this, SWT.NONE);
		lblWsdlUri.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblWsdlUri.setText("WSDL URI");

		txtWsdlUri = new Text(this, SWT.BORDER);
		GridData gd_txtWsdlUri = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 3, 1);
		gd_txtWsdlUri.widthHint = 250;
		txtWsdlUri.setLayoutData(gd_txtWsdlUri);
		txtWsdlUri.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLURL,
						txtWsdlUri.getText());

			}
		});

		cmdTestUri = new Button(this, SWT.NONE);
		cmdTestUri.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		cmdTestUri.setText(" Test URI ");
		cmdTestUri.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				MessageBox msgBox = new MessageBox(getShell(),
						SWT.ICON_INFORMATION);
				try {
					URL url = new URL(txtWsdlUri.getText());
					URLConnection conn = url.openConnection();
					conn.connect();
					msgBox.setMessage("Successfully connected to the WSDL URI.");
					msgBox.open();
				} catch (Exception e) {
					msgBox.setMessage("Invalid WSDL URI.");
					msgBox.open();
				}

			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});

		lblWsdlService = new Label(this, SWT.NONE);
		lblWsdlService.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblWsdlService.setText("WSDL Service");

		txtWsdlService = new Text(this, SWT.BORDER);
		GridData gd_txtWsdlService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		gd_txtWsdlService.widthHint = 150;
		txtWsdlService.setLayoutData(gd_txtWsdlService);
		txtWsdlService.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLSERVICE,
						txtWsdlService.getText());

			}
		});

		lblWsdlPort = new Label(this, SWT.NONE);
		lblWsdlPort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblWsdlPort.setText("WSDL Port");

		txtWsdlPort = new Text(this, SWT.BORDER);
		GridData gd_txtWsdlPort = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		gd_txtWsdlPort.widthHint = 150;
		txtWsdlPort.setLayoutData(gd_txtWsdlPort);
		txtWsdlPort.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_WSDLPORT,
						txtWsdlPort.getText());

			}
		});

		publishSameServiceContract = new Button(this, SWT.CHECK);
		publishSameServiceContract.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 5, 1));
		publishSameServiceContract.setText("Publish Same Service Contract");
		publishSameServiceContract
				.addSelectionListener(new SelectionListener() {

					public void widgetSelected(SelectionEvent evt) {
						setModelPropertyValue(
								PsArtifactConstants.WIZARD_OPTION_TEMPL_WSDL_PS_PUBLISHSAME,
								publishSameServiceContract.getSelection());

					}

					public void widgetDefaultSelected(SelectionEvent evt) {
						widgetSelected(evt);
					}
				});

		hideControls(lblWsdlUri, txtWsdlUri, lblWsdlPort, txtWsdlPort,
				lblWsdlService, txtWsdlService, publishSameServiceContract,
				cmdTestUri);

		/* Secure */

		lblSecPolicy = new Label(this, SWT.NONE);
		lblSecPolicy.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		lblSecPolicy.setText("Security Policy");
		hideControls(lblSecPolicy);

		txtSecPolicy = new Text(this, SWT.BORDER);
		GridData gd_txtSecPolicy = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		txtSecPolicy.setLayoutData(gd_txtSecPolicy);
		hideControls(txtSecPolicy);
		txtSecPolicy.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(
						PsArtifactConstants.WIZARD_OPTION_TEMPL_SECURE_PS_SECPOLICY,
						txtSecPolicy.getText());

			}
		});
		
		cmdSecPolicyRegBrowse = new Button(this, SWT.NONE);
		cmdSecPolicyRegBrowse.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 2, 1));
		cmdSecPolicyRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry.png"));
		cmdSecPolicyRegBrowse.setToolTipText(REG_BROWSE_TOOL_TIP);
		cmdSecPolicyRegBrowse.setText("Browse...");
		cmdSecPolicyRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtSecPolicy, MEDIA_TYPE_WSPOLICY);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		hideControls(cmdSecPolicyRegBrowse);

	}

	/**
	 * 
	 * @param ctrls
	 */
	void hideControls(Control... ctrls) {
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setVisible(false);
				if (ctrl.getLayoutData() instanceof GridData) {
					((GridData) ctrl.getLayoutData()).exclude = true;
					
				}
			}
		}
	}

	/**
	 * 
	 * @param ctrls
	 */
	void showControls(Control... ctrls) {
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setVisible(true);
				if (ctrl.getLayoutData() instanceof GridData) {
					((GridData) ctrl.getLayoutData()).exclude = false;
				}
			}
		}
	}

	Label createEmptyLabel(Composite parent) {
		Label EmptyLabel = new Label(parent, SWT.NONE);
		EmptyLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		return EmptyLabel;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		
		if(this.isDisposed()){
			return;
		}
		
		ArtifactTemplate selectedTemplate = AdvancedConfigComposite.this
				.getModel().getSelectedTemplate();

		if("new.proxyservice".equalsIgnoreCase(getModel().getSelectedOption())){
		
		String templateId = selectedTemplate.getId();

		if (templateId.equals(PsArtifactConstants.TRANSFORMER_PROXY_TEMPL_ID)) {
			hideControls(lblReqLogLevel, cmbReqLogLevel, lblResLogLevel,
					cmbResLogLevel); // logging
			showControls(lblTargetEndpoint, optPredefinedEndpoint,
					optfromRegistry, optEnterURL);
			hideControls(lblWsdlUri, txtWsdlUri, lblWsdlPort, txtWsdlPort,
					lblWsdlService, txtWsdlService, publishSameServiceContract,
					cmdTestUri);
				hideControls(lblSecPolicy, txtSecPolicy, cmdSecPolicyRegBrowse);
			optListener.widgetSelected(null);
			showControls(cmdReqXSLTRegBrowse,
					lblReqXSLT, txtReqXSLT, chkTransformResponses,
					lblResponseXSLT, txtResponseXSLT, cmdResXSLTRegBrowse);
		} else if (templateId
				.equals(PsArtifactConstants.LOGGING_PROXY_TEMPL_ID)) {
			hideControls(lblSecPolicy, txtSecPolicy,cmdSecPolicyRegBrowse );
			showControls(lblTargetEndpoint, optPredefinedEndpoint,
					optfromRegistry, optEnterURL);
			hideControls(cmdResXSLTRegBrowse,
					txtResponseXSLT, lblResponseXSLT,cmdReqXSLTRegBrowse, lblReqXSLT, txtReqXSLT,
					chkTransformResponses);
			hideControls(lblWsdlUri, txtWsdlUri, lblWsdlPort, txtWsdlPort,
					lblWsdlService, txtWsdlService, publishSameServiceContract,
					cmdTestUri);
			optListener.widgetSelected(null);
			showControls(lblReqLogLevel, cmbReqLogLevel, lblResLogLevel,
					cmbResLogLevel);
		} else if (templateId
				.equals(PsArtifactConstants.PASS_THROUGH_PROXY_TEMPL_ID)) {
			hideControls(lblSecPolicy, txtSecPolicy, cmdSecPolicyRegBrowse);
			hideControls(lblReqLogLevel, cmbReqLogLevel, lblResLogLevel,
					cmbResLogLevel);
			hideControls(lblWsdlUri, txtWsdlUri, lblWsdlPort, txtWsdlPort,
					lblWsdlService, txtWsdlService, publishSameServiceContract,
					cmdTestUri);
				hideControls(cmdResXSLTRegBrowse,
					txtResponseXSLT, lblResponseXSLT, cmdReqXSLTRegBrowse, lblReqXSLT, txtReqXSLT,
					chkTransformResponses);
			showControls(lblTargetEndpoint, optPredefinedEndpoint,
					optfromRegistry, optEnterURL);
			optListener.widgetSelected(null);
		} else if (templateId
				.equals(PsArtifactConstants.WSDL_BASED_PROXY_TEMPL_ID)) {
			hideControls(lblSecPolicy, txtSecPolicy,cmdSecPolicyRegBrowse);
			hideControls(cmdResXSLTRegBrowse,
					txtResponseXSLT, lblResponseXSLT,cmdReqXSLTRegBrowse, lblReqXSLT, txtReqXSLT,
					chkTransformResponses);
			hideControls(lblTargetEndpoint, txtEndPointUrl, txtEndPointkey,
					lbltxtEndPointUrl, lblEndpoint, cmbPredefinedEP,
					lblEndPointkey, cmdEndPointRegBrowse, optPredefinedEndpoint,
					optfromRegistry, optEnterURL);
			hideControls(lblReqLogLevel, cmbReqLogLevel, lblResLogLevel,
					cmbResLogLevel);
			showControls(lblWsdlUri, txtWsdlUri, lblWsdlPort, txtWsdlPort,
					lblWsdlService, txtWsdlService, publishSameServiceContract,
					cmdTestUri);
		} else if (templateId.equals(PsArtifactConstants.SECURE_PROXY_TEMPL_ID)) {
			hideControls(lblReqLogLevel, cmbReqLogLevel, lblResLogLevel,
					cmbResLogLevel);
			hideControls(cmdResXSLTRegBrowse,
					txtResponseXSLT, lblResponseXSLT,cmdReqXSLTRegBrowse, lblReqXSLT, txtReqXSLT,
					chkTransformResponses);
			hideControls(lblWsdlUri, txtWsdlUri, lblWsdlPort, txtWsdlPort,
					lblWsdlService, txtWsdlService, publishSameServiceContract,
					cmdTestUri);
			showControls(lblTargetEndpoint, optPredefinedEndpoint,
					optfromRegistry, optEnterURL);
			showControls(lblSecPolicy, txtSecPolicy,cmdSecPolicyRegBrowse);
			optListener.widgetSelected(null);
		} else if (templateId.equals(PsArtifactConstants.CUSTOM_PROXY_TEMPL_ID) || selectedTemplate.isCustom()) {
			hideControls(lblSecPolicy, txtSecPolicy,cmdSecPolicyRegBrowse );
			hideControls(lblReqLogLevel, cmbReqLogLevel, lblResLogLevel,
					cmbResLogLevel);
			hideControls(cmdResXSLTRegBrowse,
					txtResponseXSLT, lblResponseXSLT,cmdReqXSLTRegBrowse, lblReqXSLT, txtReqXSLT,
					chkTransformResponses);
			hideControls(lblWsdlUri, txtWsdlUri, lblWsdlPort, txtWsdlPort,
					lblWsdlService, txtWsdlService, publishSameServiceContract,
					cmdTestUri);
			hideControls(lblTargetEndpoint, txtEndPointUrl, txtEndPointkey,
					lbltxtEndPointUrl, lblEndpoint, cmbPredefinedEP,
					lblEndPointkey, cmdEndPointRegBrowse, optPredefinedEndpoint,
					optfromRegistry, optEnterURL);
		}
		AdvancedConfigComposite.this.layout();
		}
	}

	/**
	 * Browse key from registry, workspace or local entries
	 * @param textBox 
	 * @param mediaType
	 */
	@SuppressWarnings("unchecked")
	private void selectRegistryResource(Text textBox, String mediaType) {
		RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
		
		DeveloperStudioProviderUtils.addFilter(
				(Map<String, List<String>>) registryKeyProperty.getFilters(),
				FILTER_MEDIA_TYPE,
				mediaType);
		registryKeyProperty.setKeyValue(textBox.getText());
		RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(getShell(), SWT.NULL,
				registryKeyProperty, new ArrayList<NamedEntityDescriptor>());
		int open = dialog.open();
		if(open== Window.OK){
			String keyValue = registryKeyProperty.getKeyValue();
			textBox.setText(keyValue);
		}
	}

	public void setModel(ProxyServiceModel model) {
		this.model = model;
	}

	public ProxyServiceModel getModel() {
		return model;
	}

	public List<String> getCustomFields() {
		List<String> customFields = new ArrayList<String>();
		customFields.add("templ.common.ps.epurl");
		customFields.add("templ.common.ps.epkey");
		customFields.add("templ.secure.ps.secpolicy");
		customFields.add("templ.wsdl.ps.wsdlurl");
		customFields.add("templ.wsdl.ps.wsdlservice");
		customFields.add("templ.wsdl.ps.wsdlport");
		customFields.add("templ.wsdl.ps.publishsame");
		customFields.add("templ.logging.ps.reqloglevel");
		customFields.add("templ.logging.ps.resloglevel");
		customFields.add("templ.transformer.ps.xslt");
		customFields.add("templ.transformer.ps.transformresponses");
		customFields.add("templ.transformer.ps.resxslt");
		customFields.add("templ.common.ps.eplist");
		return customFields;
	}
	
	void enableControls(Control... ctrls){
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setEnabled(true);
			}
		}
	}
	
	void disableControls(Control... ctrls){
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setEnabled(false);
			}
		}
	}

}
