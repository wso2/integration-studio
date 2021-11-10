/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.esb.form.editors.article.providers.ConfigureEndPointPropertiesDialog;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.Messages;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class HttpEndpointFormPage extends EndpointFormPage {

	public Text httpEP_UriTemplate;
	public Combo httpEP_Method;
	public Button httpEP_Properties;

	public Combo httpEP_AuthType;
	public Label basicAuthUsernameLabel;
	public Text basicAuthUsername;
	public Label basicAuthPasswordLabel;
	public Text basicAuthPassword;
	public Label httpEP_OAuthTypeLabel;
	public Combo httpEP_OAuthType;
	public Label oAuthClientIdLabel;
	public Text oAuthClientId;
	public Label oAuthClientSecretLabel;
	public Text oAuthClientSecret;
	public Label oAuthTokenUrlLabel;
	public Text oAuthTokenUrl;
	public Label oAuthRefreshTokenLabel;
	public Text oAuthRefreshToken;

	public List<EndPointProperty> endpointPropertyList;
	
    Section basicSection;
    Section miscSection;
    Section authSection;

    public HttpEndpointFormPage(FormEditor editor, boolean isTemplate) {
		super(editor);
		this.isTemplate = isTemplate;
	}

	protected void createFormContent(IManagedForm managedForm) {

		super.createFormContent(managedForm);
		if (isTemplate()) {
			form.setText(Messages.getString("HttpEndpointTemplatePage.sectionMainTitle"));
		} else {
			form.setText(Messages.getString("HttpEndpointPage.sectionMainTitle"));
		}
		
	}
	
	@Override
	public void createFormBasicSection() {
		/* Basic Section */
		basicSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.basic"));
			
		GridData samplegridData = new GridData();
		samplegridData.horizontalSpan = 3;
		samplegridData.horizontalAlignment = SWT.FILL;
		samplegridData.grabExcessHorizontalSpace = true;
		basicSection.setLayoutData(samplegridData);
		// section.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new GridLayout());
		basicSection.setClient(basicSectionClient);
					
		/*Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new TableWrapLayout());
		basicSection.setClient(basicSectionClient);*/
		
		toolkit.createLabel(basicSectionClient, "Name :");
		endpointName = toolkit.createText(basicSectionClient, "");
		endpointName.setBackground(new Color(null, 229,236,253));
		//endpointName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointNameGridData = new GridData();
		endpointNameGridData.horizontalSpan = 3;
		endpointNameGridData.horizontalAlignment = GridData.FILL;
		endpointNameGridData.grabExcessHorizontalSpace = true;
		endpointName.setLayoutData(endpointNameGridData);
		
		endpointName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(basicSectionClient, "Trace Enabled :");
		endpointTrace = new Combo(basicSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		//endpointTrace.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] tracingStates = {"True", "False"};
		endpointTrace.setItems(tracingStates);
		GridData endpointTraceGridData = new GridData();
		endpointTraceGridData.horizontalSpan = 3;
		endpointTraceGridData.horizontalAlignment = GridData.FILL;
		endpointTraceGridData.grabExcessHorizontalSpace = true;
		endpointTrace.setLayoutData(endpointTraceGridData);
		
		endpointTrace.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		endpointTrace.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		toolkit.createLabel(basicSectionClient, "Statistics Enabled :");
		endpointStatistics = new Combo(basicSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		//endpointStatistics.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] statisticsStates = {"True", "False"};
		endpointStatistics.setItems(statisticsStates);
		GridData endpointStatisticsGridData = new GridData();
		endpointStatisticsGridData.horizontalSpan = 3;
		endpointStatisticsGridData.horizontalAlignment = GridData.FILL;
		endpointStatisticsGridData.grabExcessHorizontalSpace = true;
		endpointStatistics.setLayoutData(endpointStatisticsGridData);
		
		endpointStatistics.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		endpointStatistics.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
	}

	public void createFormMiscSection() {

		 /* Misc Section */ 
	    miscSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.misc"));
		
		GridData miscSectionGridData = new GridData();
		miscSectionGridData.horizontalSpan = 3;
		miscSectionGridData.horizontalAlignment = GridData.FILL;
		miscSectionGridData.grabExcessHorizontalSpace = true;
		miscSection.setLayoutData(miscSectionGridData);
		// miscSection.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new GridLayout());
		miscSection.setClient(miscSectionClient);	
		
		toolkit.createLabel(miscSectionClient, "URI Template :");
		httpEP_UriTemplate = toolkit.createText(miscSectionClient, "");
		httpEP_UriTemplate.setBackground(new Color(null, 229,236,253));
		//httpEP_UriTemplate.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData httpEPUriGridData = new GridData();
		httpEPUriGridData.horizontalSpan = 3;
		httpEPUriGridData.horizontalAlignment = GridData.FILL;
		httpEPUriGridData.grabExcessHorizontalSpace = true;
		httpEP_UriTemplate.setLayoutData(httpEPUriGridData);
		
		httpEP_UriTemplate.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(miscSectionClient, "HTTP Method :");
		httpEP_Method = new Combo (miscSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		String[] httpMethods = {"LEAVE_AS_IS", "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PATCH"};
		httpEP_Method.setItems(httpMethods);
		httpEP_Method.setBackground(new Color(null, 229,236,253));
		//httpEP_Method.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData httpEPMethodGridData = new GridData();
		httpEPMethodGridData.horizontalSpan = 3;
		httpEPMethodGridData.horizontalAlignment = GridData.FILL;
		httpEPMethodGridData.grabExcessHorizontalSpace = true;
		httpEP_Method.setLayoutData(httpEPMethodGridData);
		
		httpEP_Method.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		httpEP_Method.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
	
		toolkit.createLabel(miscSectionClient, "Description :");
		eP_Description = toolkit.createText(miscSectionClient, "");
		eP_Description.setBackground(new Color(null, 229,236,253));
		//httpEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData httpEPDescriptionGridData = new GridData();
		httpEPDescriptionGridData.horizontalSpan = 3;
		httpEPDescriptionGridData.horizontalAlignment = GridData.FILL;
		httpEPDescriptionGridData.grabExcessHorizontalSpace = true;
		eP_Description.setLayoutData(httpEPDescriptionGridData);
		
		eP_Description.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(miscSectionClient, "Properties :");
		httpEP_Properties = toolkit.createButton(miscSectionClient, "Add Properties", SWT.PUSH);
		httpEP_Properties.setBackground(new Color(null, 229,236,253));
		httpEP_Properties.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				ConfigureEndPointPropertiesDialog paramDialog = new ConfigureEndPointPropertiesDialog(shell,endpointPropertyList);
				paramDialog.setBlockOnOpen(true);
				paramDialog.open();
				endpointPropertyList = paramDialog.getEndpointPropertyList();		
				setSave(true);
				updateDirtyState();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	public void createFormAuthSection() {

		/* Auth Section */
		authSection = endpointCommons.createSection(form, toolkit, "Auth Configuration");

		GridData authSectionGridData = new GridData();
		authSectionGridData.horizontalSpan = 3;
		authSectionGridData.horizontalAlignment = GridData.FILL;
		authSectionGridData.grabExcessHorizontalSpace = true;
		authSection.setLayoutData(authSectionGridData);

		Composite authSectionClient = toolkit.createComposite(authSection);
		authSectionClient.setLayout(new GridLayout());
		authSection.setClient(authSectionClient);
		
		toolkit.createLabel(authSectionClient, "Auth Type :");
		httpEP_AuthType = new Combo(authSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		String[] authTypes = { "None", "Basic Auth", "OAuth" };
		httpEP_AuthType.setItems(authTypes);
		httpEP_AuthType.select(0);
		httpEP_AuthType.setBackground(new Color(null, 229, 236, 253));
		GridData httpEPAuthTypeGridData = new GridData();
		httpEPAuthTypeGridData.horizontalSpan = 3;
		httpEPAuthTypeGridData.horizontalAlignment = GridData.FILL;
		httpEPAuthTypeGridData.grabExcessHorizontalSpace = true;
		httpEP_AuthType.setLayoutData(httpEPAuthTypeGridData);

		httpEP_AuthType.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (httpEP_AuthType.getSelectionIndex() == 1) {
					enableBasicAuthAuthorizationCodeFields();
					disableOAuthParentFields();
					disabeOAuthFields();
				} else if (httpEP_AuthType.getSelectionIndex() == 2) {
					disableBasicAuthAuthorizationCodeFields();
					enableOAuthParentFields();
					enableOAuthAuthorizationCodeFields();
					;
				} else {
					disableBasicAuthAuthorizationCodeFields();
					disableOAuthParentFields();
					disabeOAuthFields();
				}
				setSave(true);
				updateDirtyState();
			}
		});

		httpEP_AuthType.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		basicAuthUsernameLabel = toolkit.createLabel(authSectionClient, "Basic Auth Username :");
		basicAuthUsernameLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		basicAuthUsername = toolkit.createText(authSectionClient, "");
		basicAuthUsername.setBackground(new Color(null, 229, 236, 253));
		setGridLayout(basicAuthUsername);

		basicAuthUsername.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		basicAuthPasswordLabel = toolkit.createLabel(authSectionClient, "Basic Auth Password :");
		basicAuthPasswordLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		basicAuthPassword = toolkit.createText(authSectionClient, "");
		basicAuthPassword.setBackground(new Color(null, 229, 236, 253));
		setGridLayout(basicAuthPassword);

		basicAuthPassword.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		httpEP_OAuthTypeLabel = toolkit.createLabel(authSectionClient, "OAuth Grant Type :");
		httpEP_OAuthType = new Combo(authSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		String[] oAuthTypes = { "Authorization Code", "Client Credentials" };
		httpEP_OAuthType.setItems(oAuthTypes);
		httpEP_OAuthType.select(0);
		httpEP_OAuthType.setBackground(new Color(null, 229, 236, 253));
		GridData httpEPOAuthTypeGridData = new GridData();
		httpEPOAuthTypeGridData.horizontalSpan = 3;
		httpEPOAuthTypeGridData.horizontalAlignment = GridData.FILL;
		httpEPOAuthTypeGridData.grabExcessHorizontalSpace = true;
		httpEP_OAuthType.setLayoutData(httpEPOAuthTypeGridData);

		httpEP_OAuthType.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			    enableOAuthParentFields();
			    disableBasicAuthAuthorizationCodeFields();
				if (httpEP_OAuthType.getSelectionIndex() == 0) {
					enableOAuthAuthorizationCodeFields();
				} else if (httpEP_OAuthType.getSelectionIndex() == 1) {
					enableOAuthClientCredentialsFields();
				}
				setSave(true);
				updateDirtyState();
			}
		});

		httpEP_OAuthType.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		httpEP_OAuthType.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
			    enableOAuthParentFields();
			    disableBasicAuthAuthorizationCodeFields();
				if (httpEP_OAuthType.getSelectionIndex() == 0) {
					enableOAuthAuthorizationCodeFields();
				} else if (httpEP_OAuthType.getSelectionIndex() == 1) {
					enableOAuthClientCredentialsFields();
				}
			}
		});

		oAuthClientIdLabel = toolkit.createLabel(authSectionClient, "Client Id :");
		oAuthClientIdLabel.setLayoutData(new GridData(GridData.FILL_BOTH));

		oAuthClientId = toolkit.createText(authSectionClient, "");
		oAuthClientId.setBackground(new Color(null, 229, 236, 253));
		setGridLayout(oAuthClientId);
		
		oAuthClientId.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		oAuthClientSecretLabel = toolkit.createLabel(authSectionClient, "Client Secret :");
		oAuthClientSecretLabel.setLayoutData(new GridData(GridData.FILL_BOTH));

		oAuthClientSecret = toolkit.createText(authSectionClient, "");
		oAuthClientSecret.setBackground(new Color(null, 229, 236, 253));
		setGridLayout(oAuthClientSecret);

		oAuthClientSecret.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		oAuthRefreshTokenLabel = toolkit.createLabel(authSectionClient, "Refresh Token :");
		oAuthRefreshTokenLabel.setLayoutData(new GridData(GridData.FILL_BOTH));

		oAuthRefreshToken = toolkit.createText(authSectionClient, "");
		oAuthRefreshToken.setBackground(new Color(null, 229, 236, 253));
		setGridLayout(oAuthRefreshToken);

		oAuthRefreshToken.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		oAuthTokenUrlLabel = toolkit.createLabel(authSectionClient, "Token Url :");
		oAuthTokenUrlLabel.setLayoutData(new GridData(GridData.FILL_BOTH));

		oAuthTokenUrl = toolkit.createText(authSectionClient, "");
		oAuthTokenUrl.setBackground(new Color(null, 229, 236, 253));
		setGridLayout(oAuthTokenUrl);

		oAuthTokenUrl.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
	}
	
	public void setAuthenticationFields() {
	    if (httpEP_AuthType.getSelectionIndex() == 1) {
	        disableOAuthParentFields();
	        disabeOAuthFields();
	    } else if (httpEP_AuthType.getSelectionIndex() == 2) {
	        disableBasicAuthAuthorizationCodeFields();
	        if (httpEP_OAuthType.getSelectionIndex() == 1) {
	            setOAuthRefreshTokenVisibility(false);
	        }
	    } else {
	        disableBasicAuthAuthorizationCodeFields();
	        disableOAuthParentFields();
	        disabeOAuthFields();
	    }
	}

	public void createFormQosSection() {
		endpointCommons.createFormQosSection(form, toolkit);
	}
	
	public void createFormErrorHandlingSection() {
		endpointCommons.createFormErrorHandlingSection(form, toolkit);
	}

	public EndpointCommons getEndpointCommons() {
		return endpointCommons;
	}
	
	private void enableOAuthParentFields() {
	    setOAuthParentFieldsVisibility(true);
        enbaleVisualizingOAuthFields();
    }
	
	private void disableOAuthParentFields() {
        setOAuthParentFieldsVisibility(false);
        enbaleVisualizingOAuthFields();
    }

	private void disabeOAuthFields() {
		setOAuthCommonFieldsVisibility(false);
		setOAuthRefreshTokenVisibility(false);
		enbaleVisualizingOAuthFields();
	}

	private void enableOAuthClientCredentialsFields() {
		setOAuthCommonFieldsVisibility(true);
		setOAuthRefreshTokenVisibility(false);
		enbaleVisualizingOAuthFields();
	}
	
	private void enableBasicAuthAuthorizationCodeFields() {
		setBasicAuthCommonFieldsVisibility(true);
		enbaleVisualizingOAuthFields();
	}

	private void disableBasicAuthAuthorizationCodeFields() {
		setBasicAuthCommonFieldsVisibility(false);
		enbaleVisualizingOAuthFields();
	}

	private void enableOAuthAuthorizationCodeFields() {
		setOAuthCommonFieldsVisibility(true);
		setOAuthRefreshTokenVisibility(true);
		enbaleVisualizingOAuthFields();
	}
	
	private void setBasicAuthCommonFieldsVisibility(boolean visible) {
		setFieldVisibility(basicAuthUsername, visible);
		setFieldVisibility(basicAuthUsernameLabel, visible);
		setFieldVisibility(basicAuthPassword, visible);
		setFieldVisibility(basicAuthPasswordLabel, visible);
	}

	private void setOAuthParentFieldsVisibility(boolean visible) {
		setFieldVisibility(httpEP_OAuthTypeLabel, visible);
		setFieldVisibility(httpEP_OAuthType, visible);
	}

	private void setOAuthCommonFieldsVisibility(boolean visible) {
		setFieldVisibility(oAuthClientIdLabel, visible);
		setFieldVisibility(oAuthClientId, visible);
		setFieldVisibility(oAuthClientSecretLabel, visible);
		setFieldVisibility(oAuthClientSecret, visible);
		setFieldVisibility(oAuthTokenUrlLabel, visible);
		setFieldVisibility(oAuthTokenUrl, visible);
	}

	private void setOAuthRefreshTokenVisibility(boolean visible) {
		setFieldVisibility(oAuthRefreshTokenLabel, visible);
		setFieldVisibility(oAuthRefreshToken, visible);
	}

	private void enbaleVisualizingOAuthFields() {
		if (authSection.isExpanded() == true) {
			authSection.setExpanded(false);
			authSection.setExpanded(true);
		}
	}

	private void setGridLayout(Text text) {
		GridData gridData = new GridData();
		gridData.horizontalSpan = 3;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		text.setLayoutData(gridData);
	}

	private void setFieldVisibility(Control control, boolean visible) {
		GridData gridData = (GridData) control.getLayoutData();
		gridData.exclude = !visible;
		control.setVisible(visible);
	}
}
