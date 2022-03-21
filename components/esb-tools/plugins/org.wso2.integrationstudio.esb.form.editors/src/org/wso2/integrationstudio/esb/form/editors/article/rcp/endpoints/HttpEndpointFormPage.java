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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.esb.form.editors.article.providers.ConfigureEndPointPropertiesDialog;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.Messages;
import org.wso2.integrationstudio.esb.form.editors.ui.widgets.CompositeElements;

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
    public StyledText basicAuthUsernameExp;
    public Button basicAuthUsernameExpToggle;
    public Composite basicAuthUsernameComposite;
    protected NamespacedProperty basicAuthUsernameNamespacedProperty;
    public Label basicAuthPasswordLabel;
    public Text basicAuthPassword;
    public StyledText basicAuthPasswordExp;
    public Button basicAuthPasswordExpToggle;
    public Composite basicAuthPasswordComposite;
    protected NamespacedProperty basicAuthPasswordNamespacedProperty;
    public Label httpEP_OAuthTypeLabel;
    public Combo httpEP_OAuthType;
    public Label httpEP_OAuthAuthenticationModeLabel;
    public Combo httpEP_OAuthAuthenticationMode;
    public Label oAuthClientIdLabel;
    public Text oAuthClientId;
    public StyledText oAuthClientIdExp;
    public Button oAuthClientIdExpToggle;
    public Composite oAuthClientIdComposite;
    protected NamespacedProperty oAuthClientIdNamespacedProperty;
    public Label oAuthClientSecretLabel;
    public Text oAuthClientSecret;
    public StyledText oAuthClientSecretExp;
    public Button oAuthClientSecretExpToggle;
    public Composite oAuthClientSecretComposite;
    protected NamespacedProperty oAuthClientSecretNamespacedProperty;
    public Label oAuthTokenUrlLabel;
    public Text oAuthTokenUrl;
    public StyledText oAuthTokenUrlExp;
    public Button oAuthTokenUrlExpToggle;
    public Composite oAuthTokenUrlComposite;
    protected NamespacedProperty oAuthTokenUrlNamespacedProperty;
    public Label oAuthRefreshTokenLabel;
    public Text oAuthRefreshToken;
    public StyledText oAuthRefreshTokenExp;
    public Button oAuthRefreshTokenExpToggle;
    public Composite oAuthRefreshTokenComposite;
    protected NamespacedProperty oAuthRefreshTokenNamespacedProperty;
    public Label oAuthUsernameLabel;
    public Text oAuthUsername;
    public StyledText oAuthUsernameExp;
    public Button oAuthUsernameExpToggle;
    public Composite oAuthUsernameComposite;
    protected NamespacedProperty oAuthUsernameNamespacedProperty;
    public Label oAuthPasswordLabel;
    public Text oAuthPassword;
    public StyledText oAuthPasswordExp;
    public Button oAuthPasswordExpToggle;
    public Composite oAuthPasswordComposite;
    protected NamespacedProperty oAuthPasswordNamespacedProperty;

    public List<EndPointProperty> endpointPropertyList;

    Section basicSection;
    Section miscSection;
    Section authSection;

    Label oAuthParameterLabel;
    Button oAuthParameterAddButton;
    protected Composite oAuthParameterListComposite;

    public static final String PLUGIN_ID = "org.wso2.integrationstudio.gmf.esb.form.editors.ui.widgets";
    private static IIntegrationStudioLog log = Logger.getLog(PLUGIN_ID);

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

		GridData oauthSectionGridData = new GridData();
		oauthSectionGridData.horizontalSpan = 3;
		oauthSectionGridData.horizontalAlignment = GridData.FILL;
		oauthSectionGridData.grabExcessHorizontalSpace = true;
		authSection.setLayoutData(oauthSectionGridData);

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
                    enableOAuthAuthorizationCodeFields();;
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

        // Add new toggle expression widget
        basicAuthUsernameLabel = toolkit.createLabel(authSectionClient, "Basic Auth Username :");
        basicAuthUsernameLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
        basicAuthUsernameComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                basicAuthUsernameNamespacedProperty);
        basicAuthUsername = (Text) basicAuthUsernameComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        basicAuthUsernameExp = (StyledText) basicAuthUsernameComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        basicAuthUsernameExpToggle = (Button) basicAuthUsernameComposite
                .getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        basicAuthUsernameExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        basicAuthUsername.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        basicAuthUsernameExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        basicAuthPasswordLabel = toolkit.createLabel(authSectionClient, "Basic Auth Password :");
        basicAuthPasswordLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
        basicAuthPasswordComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                basicAuthPasswordNamespacedProperty);
        basicAuthPassword = (Text) basicAuthPasswordComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        basicAuthPasswordExp = (StyledText) basicAuthPasswordComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        basicAuthPasswordExpToggle = (Button) basicAuthPasswordComposite
                .getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        basicAuthPasswordExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        basicAuthPassword.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        basicAuthPasswordExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        httpEP_OAuthTypeLabel = toolkit.createLabel(authSectionClient, "OAuth Grant Type :");
		httpEP_OAuthType = new Combo(authSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		String[] oAuthTypes = { "Authorization Code", "Client Credentials", "Password" };
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
				} else if (httpEP_OAuthType.getSelectionIndex() == 2) {
                    enableOAuthPasswordFields();
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
				} else if (httpEP_OAuthType.getSelectionIndex() == 2) {
                    enableOAuthPasswordFields();
                }
			}
		});

        httpEP_OAuthAuthenticationModeLabel = toolkit.createLabel(authSectionClient, "OAuth Authorization Mode :");
        httpEP_OAuthAuthenticationMode = new Combo(authSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
        String[] oAuthAutorizationModes = { "Header", "Payload" };
        httpEP_OAuthAuthenticationMode.setItems(oAuthAutorizationModes);
        httpEP_OAuthAuthenticationMode.select(0);
        httpEP_OAuthAuthenticationMode.setBackground(new Color(null, 229, 236, 253));
        GridData httpEPOAuthAuthorizationModeGridData = new GridData();
        httpEPOAuthAuthorizationModeGridData.horizontalSpan = 3;
        httpEPOAuthAuthorizationModeGridData.horizontalAlignment = GridData.FILL;
        httpEPOAuthAuthorizationModeGridData.grabExcessHorizontalSpace = true;
        httpEP_OAuthAuthenticationMode.setLayoutData(httpEPOAuthAuthorizationModeGridData);

        httpEP_OAuthAuthenticationMode.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        httpEP_OAuthAuthenticationMode.addListener(SWT.MouseVerticalWheel, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.doit = false;
            }
        });

        oAuthClientIdLabel = toolkit.createLabel(authSectionClient, "Client Id :");
        oAuthClientIdLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
        oAuthClientIdComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                oAuthClientIdNamespacedProperty);
        oAuthClientId = (Text) oAuthClientIdComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        oAuthClientIdExp = (StyledText) oAuthClientIdComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        oAuthClientIdExpToggle = (Button) oAuthClientIdComposite.getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        oAuthClientIdExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthClientId.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthClientIdExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthClientSecretLabel = toolkit.createLabel(authSectionClient, "Client Secret :");
        oAuthClientSecretComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                oAuthClientSecretNamespacedProperty);
        oAuthClientSecret = (Text) oAuthClientSecretComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        oAuthClientSecretExp = (StyledText) oAuthClientSecretComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        oAuthClientSecretExpToggle = (Button) oAuthClientSecretComposite
                .getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        oAuthClientSecretExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthClientSecret.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthClientSecretExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthRefreshTokenLabel = toolkit.createLabel(authSectionClient, "Refresh Token :");
        oAuthRefreshTokenComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                oAuthRefreshTokenNamespacedProperty);
        oAuthRefreshToken = (Text) oAuthRefreshTokenComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        oAuthRefreshTokenExp = (StyledText) oAuthRefreshTokenComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        oAuthRefreshTokenExpToggle = (Button) oAuthRefreshTokenComposite
                .getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        oAuthRefreshTokenExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthRefreshToken.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthRefreshTokenExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthUsernameLabel = toolkit.createLabel(authSectionClient, "Username :");
        oAuthUsernameComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                oAuthUsernameNamespacedProperty);
        oAuthUsername = (Text) oAuthUsernameComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        oAuthUsernameExp = (StyledText) oAuthUsernameComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        oAuthUsernameExpToggle = (Button) oAuthUsernameComposite.getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        oAuthUsernameExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthUsername.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthUsernameExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthPasswordLabel = toolkit.createLabel(authSectionClient, "Password :");
        oAuthPasswordComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                oAuthPasswordNamespacedProperty);
        oAuthPassword = (Text) oAuthPasswordComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        oAuthPasswordExp = (StyledText) oAuthPasswordComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        oAuthPasswordExpToggle = (Button) oAuthPasswordComposite.getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        oAuthPasswordExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthPassword.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthPasswordExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthTokenUrlLabel = toolkit.createLabel(authSectionClient, "Token Url :");
        oAuthTokenUrlComposite = CompositeElements.createTextBoxFieldWithButton(toolkit, authSectionClient,
                oAuthTokenUrlNamespacedProperty);
        oAuthTokenUrl = (Text) oAuthTokenUrlComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        oAuthTokenUrlExp = (StyledText) oAuthTokenUrlComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        oAuthTokenUrlExpToggle = (Button) oAuthTokenUrlComposite.getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

        oAuthTokenUrlExpToggle.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthTokenUrl.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthTokenUrlExp.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        oAuthParameterLabel = toolkit.createLabel(authSectionClient, "OAuth Parameters :");
        oAuthParameterListComposite = CompositeElements.createComposite(toolkit, authSectionClient, 1, 0);

        oAuthParameterAddButton = toolkit.createButton(authSectionClient, "Add OAuth Parameter", SWT.PUSH);
        oAuthParameterAddButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                addOAuthParameterListItem(toolkit, oAuthParameterListComposite, null, null);
                enbaleVisualizingOAuthFields();
            }
        });

    }

    protected void addOAuthParameterListItem(FormToolkit toolkit, Composite parent, String key, String value) {
        Composite listItemComposite = CompositeElements.createOAuthParameterListItem(toolkit, parent);
        Text keyText = (Text) listItemComposite.getData(CompositeElements.KEY_TEXT_BOX);
        Text valueText = (Text) listItemComposite.getData(CompositeElements.VALUE_TEXT_BOX);
        StyledText expressionText = (StyledText) listItemComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
        Button toggleButton = (Button) listItemComposite.getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);
        Button removeButton = (Button) listItemComposite.getData(CompositeElements.REMOVE_ITEM_BUTTON);

        keyText.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        toggleButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        valueText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        expressionText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                setSave(true);
                updateDirtyState();
            }
        });

        removeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent arg0) {
                listItemComposite.dispose();
                enbaleVisualizingOAuthFields();
                setSave(true);
                updateDirtyState();
            }
        });

        if (key != null)
            keyText.setText(key);
        if (value != null) {
            if (isExpression(value)) {
                expressionText.setText(getValueFromExpression(value));
                toggleButton.setSelection(true);
            } else {
                valueText.setText(value);
                toggleButton.setSelection(false);
            }
            toggleButton.notifyListeners(SWT.Selection, new Event());
        }
    }

    public Map<String, String> getOAuthParameters() {
        Map<String, String> map = new HashMap<String, String>();

        for (Control listItemComposite : oAuthParameterListComposite.getChildren()) {
            Text keyText = (Text) listItemComposite.getData(CompositeElements.KEY_TEXT_BOX);
            Text valueText = (Text) listItemComposite.getData(CompositeElements.VALUE_TEXT_BOX);
            StyledText expressionText = (StyledText) listItemComposite.getData(CompositeElements.EXPRESSION_TEXT_BOX);
            Button toggleButton = (Button) listItemComposite.getData(CompositeElements.EXPRESSION_TOGGLE_BUTTON);

            String parameterKey = keyText.getText();
            String parameterValue = valueText.getText();
            if (toggleButton.getSelection()) {
                parameterValue = getExpressionFromText(expressionText.getText());
            }

            map.put(parameterKey, parameterValue);
        }

        return map;
    }

    protected String getExpressionFromText(String text) {
        return "{" + text + "}";
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
        setOAuthUserCredentialVisibility(false);
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

    private void enableOAuthClientCredentialsFields() {
        setOAuthCommonFieldsVisibility(true);
        setOAuthRefreshTokenVisibility(false);
        setOAuthUserCredentialVisibility(false);
        enbaleVisualizingOAuthFields();
    }

    private void enableOAuthAuthorizationCodeFields() {
        setOAuthCommonFieldsVisibility(true);
        setOAuthRefreshTokenVisibility(true);
        setOAuthUserCredentialVisibility(false);
        enbaleVisualizingOAuthFields();
    }

    private void enableOAuthPasswordFields() {
        setOAuthCommonFieldsVisibility(true);
        setOAuthRefreshTokenVisibility(false);
        setOAuthUserCredentialVisibility(true);
        enbaleVisualizingOAuthFields();
    }

    private void setBasicAuthCommonFieldsVisibility(boolean visible) {
        setFieldVisibility(basicAuthUsernameComposite, visible);
        setFieldVisibility(basicAuthUsernameLabel, visible);
        setFieldVisibility(basicAuthPasswordComposite, visible);
        setFieldVisibility(basicAuthPasswordLabel, visible);
    }

    private void setOAuthParentFieldsVisibility(boolean visible) {
        setFieldVisibility(httpEP_OAuthTypeLabel, visible);
        setFieldVisibility(httpEP_OAuthType, visible);
        setFieldVisibility(httpEP_OAuthAuthenticationModeLabel, visible);
        setFieldVisibility(httpEP_OAuthAuthenticationMode, visible);
    }

    private void setOAuthCommonFieldsVisibility(boolean visible) {
        setFieldVisibility(oAuthClientIdLabel, visible);
        setFieldVisibility(oAuthClientIdComposite, visible);
        setFieldVisibility(oAuthClientSecretLabel, visible);
        setFieldVisibility(oAuthClientSecretComposite, visible);
        setFieldVisibility(oAuthTokenUrlLabel, visible);
        setFieldVisibility(oAuthTokenUrlComposite, visible);
        setFieldVisibility(oAuthParameterLabel, visible);
        setFieldVisibility(oAuthParameterAddButton, visible);
        setFieldVisibility(oAuthParameterListComposite, visible);
    }

    private void setOAuthRefreshTokenVisibility(boolean visible) {
        setFieldVisibility(oAuthRefreshTokenLabel, visible);
        setFieldVisibility(oAuthRefreshTokenComposite, visible);
    }

    private void setOAuthUserCredentialVisibility(boolean visible) {
        setFieldVisibility(oAuthUsernameLabel, visible);
        setFieldVisibility(oAuthUsernameComposite, visible);
        setFieldVisibility(oAuthPasswordLabel, visible);
        setFieldVisibility(oAuthPasswordComposite, visible);
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

    /**
     * Validate the given attribute to identify whether it is static or dynamic key
     * If the name is in the {} format then it is dynamic key(XPath)
     * Otherwise just a static name
     *
     * @param attributeValue string to validate as the attribute
     * @return isDynamicAttribute representing the attribute type
     */
    private boolean isExpression(String value) {
        if (value.length() < 2) {
            return false;
        }

        final char startExpression = '{';
        final char endExpression = '}';

        char firstChar = value.charAt(0);
        char lastChar = value.charAt(value.length() - 1);

        return (startExpression == firstChar && endExpression == lastChar);
    }

    private String getValueFromExpression(String expression) {
        return expression.substring(1, expression.length() - 1);
    }

    public void setOAuthClientId(String clientId) {
        if (isExpression(clientId)) {
            oAuthClientIdExp.setText(getValueFromExpression(clientId));
            oAuthClientIdExpToggle.setSelection(true);
        } else {
            oAuthClientId.setText(clientId);
            oAuthClientIdExpToggle.setSelection(false);
        }
        oAuthClientIdExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void setOAuthClientSecret(String clientSecret) {
        if (isExpression(clientSecret)) {
            oAuthClientSecretExp.setText(getValueFromExpression(clientSecret));
            oAuthClientSecretExpToggle.setSelection(true);
            oAuthClientIdExpToggle.notifyListeners(SWT.Selection, new Event());
        } else {
            oAuthClientSecret.setText(clientSecret);
            oAuthClientSecretExpToggle.setSelection(false);
        }
        oAuthClientSecretExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void setOAuthRefreshToken(String refreshToken) {
        if (isExpression(refreshToken)) {
            oAuthRefreshTokenExp.setText(getValueFromExpression(refreshToken));
            oAuthRefreshTokenExpToggle.setSelection(true);

        } else {
            oAuthRefreshToken.setText(refreshToken);
            oAuthRefreshTokenExpToggle.setSelection(false);
        }
        oAuthRefreshTokenExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void setOAuthTokenUrl(String tokenUrl) {
        if (isExpression(tokenUrl)) {
            oAuthTokenUrlExp.setText(getValueFromExpression(tokenUrl));
            oAuthTokenUrlExpToggle.setSelection(true);
        } else {
            oAuthTokenUrl.setText(tokenUrl);
            oAuthTokenUrlExpToggle.setSelection(false);
        }
        oAuthTokenUrlExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void getOAuthUsername(String username) {
        if (isExpression(username)) {
            oAuthUsernameExp.setText(getValueFromExpression(username));
            oAuthUsernameExpToggle.setSelection(true);
        } else {
            oAuthUsername.setText(username);
            oAuthUsernameExpToggle.setSelection(false);
        }
        oAuthUsernameExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void getOAuthPassword(String password) {
        if (isExpression(password)) {
            oAuthPasswordExp.setText(getValueFromExpression(password));
            oAuthPasswordExpToggle.setSelection(true);
        } else {
            oAuthPassword.setText(password);
            oAuthPasswordExpToggle.setSelection(false);
        }
        oAuthPasswordExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void setBasicAuthUsername(String username) {
        if (isExpression(username)) {
            basicAuthUsernameExp.setText(getValueFromExpression(username));
            basicAuthUsernameExpToggle.setSelection(true);
        } else {
            basicAuthUsername.setText(username);
            basicAuthUsernameExpToggle.setSelection(false);
        }
        basicAuthUsernameExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void setBasicAuthPassword(String password) {
        if (isExpression(password)) {
            basicAuthPasswordExp.setText(getValueFromExpression(password));
            basicAuthPasswordExpToggle.setSelection(true);
        } else {
            basicAuthPassword.setText(password);
            basicAuthPasswordExpToggle.setSelection(false);
        }
        basicAuthPasswordExpToggle.notifyListeners(SWT.Selection, new Event());
    }

    public void setOAuthParameters(Map<String, String> oAuthParameterMap) {
        // Remove all oAuth parameters from UI
        for (Control listItemComposite : oAuthParameterListComposite.getChildren()) {
            ((Composite) listItemComposite).dispose();
        }

        // Populate oAuth parameters
        if (oAuthParameterMap != null) {

            for (Entry<String, String> entry : oAuthParameterMap.entrySet()) {
                addOAuthParameterListItem(toolkit, oAuthParameterListComposite, entry.getKey(), entry.getValue());
            }
        }
        oAuthParameterListComposite.layout();
        enbaleVisualizingOAuthFields();
    }
}
