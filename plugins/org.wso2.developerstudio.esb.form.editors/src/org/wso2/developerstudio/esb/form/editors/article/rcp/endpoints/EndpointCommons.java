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

package org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints;

import java.util.ArrayList;

import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.esb.form.editors.article.providers.NamedEntityDescriptor;
import org.wso2.developerstudio.esb.form.editors.article.providers.RegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class EndpointCommons {

	private AbstractEsbFormPage esbFormPage;

	public EndpointCommons(EndpointFormPage esbFormPage) {
		this.esbFormPage = esbFormPage;
	}

	public Combo getEndpointSecurity() {
		return endpointSecurity;
	}

	public void setEndpointSecurity(Combo endpointSecurity) {
		this.endpointSecurity = endpointSecurity;
	}

	public Text getEndpointSecurityInboundPolicyKey() {
		return endpointSecurityInboundPolicyKey;
	}

	public void setEndpointSecurityInboundPolicyKey(Text endpointSecurityInboundPolicyKey) {
		this.endpointSecurityInboundPolicyKey = endpointSecurityInboundPolicyKey;
	}

	public Text getEndpointSecurityOutboundPolicyKey() {
		return endpointSecurityOutboundPolicyKey;
	}

	public void setEndpointSecurityOutboundPolicyKey(Text endpointSecurityOutboundPolicyKey) {
		this.endpointSecurityOutboundPolicyKey = endpointSecurityOutboundPolicyKey;
	}

	public Text getEndpointWSPolicyKey() {
		return endpointWSPolicyKey;
	}

	public void setEndpointWSPolicyKey(Text endpointWSPolicyKey) {
		this.endpointWSPolicyKey = endpointWSPolicyKey;
	}

	public Combo getEndpointAddressing() {
		return endpointAddressing;
	}

	public void setEndpointAddressing(Combo endpointAddressing) {
		this.endpointAddressing = endpointAddressing;
	}

	public Combo getEndpointVersion() {
		return endpointVersion;
	}

	public void setEndpointVersion(Combo endpointVersion) {
		this.endpointVersion = endpointVersion;
	}

	public Combo getEndpointSeparateListner() {
		return endpointSeparateListner;
	}

	public void setEndpointSeparateListner(Combo endpointSeparateListner) {
		this.endpointSeparateListner = endpointSeparateListner;
	}

	public Text getEndpointSuspendErrorCodes() {
		return endpointSuspendErrorCodes;
	}

	public void setEndpointSuspendErrorCodes(Text endpointSuspendErrorCodes) {
		this.endpointSuspendErrorCodes = endpointSuspendErrorCodes;
	}

	public Text getEndpointSuspendInitialDuration() {
		return endpointSuspendInitialDuration;
	}

	public void setEndpointSuspendInitialDuration(Text endpointSuspendInitialDuration) {
		this.endpointSuspendInitialDuration = endpointSuspendInitialDuration;
	}

	public Text getEndpointSuspendMaxDuration() {
		return endpointSuspendMaxDuration;
	}

	public void setEndpointSuspendMaxDuration(Text endpointSuspendMaxDuration) {
		this.endpointSuspendMaxDuration = endpointSuspendMaxDuration;
	}

	public Text getEndpointSuspendProgressFactor() {
		return endpointSuspendProgressFactor;
	}

	public void setEndpointSuspendProgressFactor(Text endpointSuspendProgressFactor) {
		this.endpointSuspendProgressFactor = endpointSuspendProgressFactor;
	}

	public Text getEndpointRetryErrorCodes() {
		return endpointRetryErrorCodes;
	}

	public void setEndpointRetryErrorCodes(Text endpointRetryErrorCodes) {
		this.endpointRetryErrorCodes = endpointRetryErrorCodes;
	}

	public Text getEndpointRetryCount() {
		return endpointRetryCount;
	}

	public void setEndpointRetryCount(Text endpointRetryCount) {
		this.endpointRetryCount = endpointRetryCount;
	}

	public Text getEndpointRetryDelay() {
		return endpointRetryDelay;
	}

	public void setEndpointRetryDelay(Text endpointRetryDelay) {
		this.endpointRetryDelay = endpointRetryDelay;
	}

	public Text getEndpointTimeoutDuration() {
		return endpointTimeoutDuration;
	}

	public void setEndpointTimeoutDuration(Text endpointTimeoutDuration) {
		this.endpointTimeoutDuration = endpointTimeoutDuration;
	}

	public Combo getEndpointTimeoutAction() {
		return endpointTimeoutAction;
	}

	public void setEndpointTimeoutAction(Combo endpointTimeoutAction) {
		this.endpointTimeoutAction = endpointTimeoutAction;
	}

	public Combo endpointSecurity;
	public Combo endpointAddressing;

	public Label endpointVersionLabel;
	public Combo endpointVersion;
	public Label endpointSeparateListnerLabel;
	public Combo endpointSeparateListner;

	public Button endpointInboundAndOutboundCheckBox;
	public Button endpointPolicyKey;
	public Text endpointWSPolicyKey;
	public Label endpointInboundPolicyLabel;
	public Text endpointSecurityInboundPolicyKey;
	public Label endpointOutboundPolicyLabel;
	public Text endpointSecurityOutboundPolicyKey;
	public Button endpointInboundPolicyKey;
	public Button endpointOutboundPolicyKey;
	public String inboundPolicyKey;
	public String outboundPolicyKey;
	public String policyKey;

	public Text endpointSuspendErrorCodes;
	public Text endpointSuspendInitialDuration;
	public Text endpointSuspendMaxDuration;
	public Text endpointSuspendProgressFactor;

	public Text endpointRetryErrorCodes;
	public Text endpointRetryCount;
	public Text endpointRetryDelay;

	public Text endpointTimeoutDuration;
	public Combo endpointTimeoutAction;

	Section qosSection;

	public void createFormQosSection(final ScrolledForm form, FormToolkit toolkit) {

		/* QOS Information */
		qosSection = createSection(form, toolkit,
				Messages.getString("EndpointPage.section.qos"));
		qosSection.setExpanded(false);
		GridData taskImplGridData = new GridData();
		taskImplGridData.horizontalSpan = 3;
		taskImplGridData.horizontalAlignment = GridData.FILL;
		taskImplGridData.grabExcessHorizontalSpace = true;
		qosSection.setLayoutData(taskImplGridData);
		// triggerSection.setLayoutData(new TableWrapData(TableWrapData.FILL));

		final Composite qosSectionClient = toolkit.createComposite(qosSection);
		qosSectionClient.setLayout(new GridLayout());

		toolkit.createLabel(qosSectionClient, "Addressing Enabled :");
		endpointAddressing = new Combo(qosSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		// endpointAddressing.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		String[] states2 = { "True", "False" };
		endpointAddressing.setItems(states2);
		endpointAddressing.select(1);
		GridData endpointAdressingGridData = new GridData();
		endpointAdressingGridData.horizontalSpan = 3;
		endpointAdressingGridData.horizontalAlignment = GridData.FILL;
		endpointAdressingGridData.grabExcessHorizontalSpace = true;
		endpointAddressing.setLayoutData(endpointAdressingGridData);

		endpointAddressing.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (endpointAddressing.getSelectionIndex() == 0) {
					enableAddressingFields();
				} else {
					disabeAddressingFields();
				}
				
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		endpointAddressing.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		endpointVersionLabel = toolkit.createLabel(qosSectionClient, "Addressing Version :");
		endpointVersionLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		endpointVersion = new Combo(qosSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		// endpointVersion.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		String[] version = { "final", "submission" };
		endpointVersion.setItems(version);
		GridData endpointVersionGridData = new GridData();
		endpointVersionGridData.horizontalSpan = 3;
		endpointVersionGridData.horizontalAlignment = GridData.FILL;
		endpointVersionGridData.grabExcessHorizontalSpace = true;
		endpointVersion.setLayoutData(endpointVersionGridData);
		
		endpointVersion.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		endpointVersion.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		endpointSeparateListnerLabel = toolkit.createLabel(qosSectionClient, "Addressing Separate Listener :");
		endpointSeparateListnerLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		endpointSeparateListner = new Combo(qosSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		// endpointSeparateListner.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		String[] separateListner = { "True", "False" };
		endpointSeparateListner.setItems(separateListner);
		GridData endpointSeparateListenerGridData = new GridData();
		endpointSeparateListenerGridData.horizontalSpan = 3;
		endpointSeparateListenerGridData.horizontalAlignment = GridData.FILL;
		endpointSeparateListenerGridData.grabExcessHorizontalSpace = true;
		endpointSeparateListner.setLayoutData(endpointSeparateListenerGridData);
		
		endpointSeparateListner.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		endpointSeparateListner.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		disabeAddressingFields();

		toolkit.createLabel(qosSectionClient, "Security Enabled :");
		endpointSecurity = new Combo(qosSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		// endpointSecurity.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		String[] states1 = { "True", "False" };
		endpointSecurity.setItems(states1);
		endpointSecurity.select(1);
		GridData endpointSecurityGridData = new GridData();
		endpointSecurityGridData.horizontalSpan = 3;
		endpointSecurityGridData.horizontalAlignment = GridData.FILL;
		endpointSecurityGridData.grabExcessHorizontalSpace = true;
		endpointSecurity.setLayoutData(endpointSecurityGridData);

		endpointSecurity.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (endpointSecurity.getSelectionIndex() == 0) {
					enableWSFields();
					enablePolicyFields();
				} else {
					disableWSFields();
					disableInOutFields();
					disablePolicyFields();
					endpointWSPolicyKey.setText("");
					endpointSecurityInboundPolicyKey.setText("");
					endpointSecurityOutboundPolicyKey.setText("");
				}
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		endpointSecurity.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		toolkit.createLabel(qosSectionClient, null);
		endpointInboundAndOutboundCheckBox = toolkit.createButton(qosSectionClient,
				"Specify as Inbound and Outbound Policies", SWT.CHECK);
		endpointInboundAndOutboundCheckBox.setBackground(new Color(null, 169, 169, 169));
		endpointInboundAndOutboundCheckBox.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		endpointInboundAndOutboundCheckBox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (endpointInboundAndOutboundCheckBox.getSelection()) {
					enablebleInOutFields();
					disablePolicyFields();
				} else {
					enablePolicyFields();
					disableInOutFields();
				}
				
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		disableWSFields();
		endpointWSPolicyKey = toolkit.createText(qosSectionClient, "");
		endpointWSPolicyKey.setEditable(false);
		endpointWSPolicyKey.setBackground(new Color(null, 229, 236, 253));
		// endpointSecurityInboundPolicyKey.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointWSPolicyKeyGridData = new GridData();
		endpointWSPolicyKeyGridData.horizontalSpan = 3;
		endpointWSPolicyKeyGridData.horizontalAlignment = GridData.FILL;
		endpointWSPolicyKeyGridData.grabExcessHorizontalSpace = true;
		endpointWSPolicyKey.setLayoutData(endpointWSPolicyKeyGridData);
		
		endpointWSPolicyKey.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		endpointPolicyKey = toolkit.createButton(qosSectionClient, "Add Policy Key", SWT.PUSH);
		endpointPolicyKey.setBackground(new Color(null, 229, 236, 253));
		endpointPolicyKey.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		endpointPolicyKey.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
						registryKeyProperty, new ArrayList<NamedEntityDescriptor>(), endpointWSPolicyKey.getText());
				int open = dialog.open();
				if (open == Window.OK) {
					policyKey = registryKeyProperty.getKeyValue();
					endpointWSPolicyKey.setText(policyKey);
					endpointSecurityOutboundPolicyKey.setText("");
					endpointSecurityInboundPolicyKey.setText("");
				}
				
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		disablePolicyFields();

		/*
		 * endpointInboundPolicyLabel = toolkit.createLabel(qosSectionClient,
		 * "Inbound Policy :"); endpointInboundPolicyLabel.setLayoutData(new
		 * GridData(GridData.FILL_BOTH));
		 */
		endpointSecurityInboundPolicyKey = toolkit.createText(qosSectionClient, "");
		endpointSecurityInboundPolicyKey.setEditable(false);
		endpointSecurityInboundPolicyKey.setBackground(new Color(null, 229, 236, 253));
		// endpointSecurityInboundPolicyKey.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointInboundPolicyKeyGridData = new GridData();
		endpointInboundPolicyKeyGridData.horizontalSpan = 3;
		endpointInboundPolicyKeyGridData.horizontalAlignment = GridData.FILL;
		endpointInboundPolicyKeyGridData.grabExcessHorizontalSpace = true;
		endpointSecurityInboundPolicyKey.setLayoutData(endpointInboundPolicyKeyGridData);
		
		endpointSecurityInboundPolicyKey.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		endpointInboundPolicyKey = toolkit.createButton(qosSectionClient, "Add Inbound Policy Key", SWT.PUSH);
		endpointInboundPolicyKey.setBackground(new Color(null, 229, 236, 253));
		endpointInboundPolicyKey.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		endpointInboundPolicyKey.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
						registryKeyProperty, new ArrayList<NamedEntityDescriptor>(),
						endpointSecurityInboundPolicyKey.getText());
				int open = dialog.open();
				if (open == Window.OK) {
					inboundPolicyKey = registryKeyProperty.getKeyValue();
					endpointSecurityInboundPolicyKey.setText(inboundPolicyKey);
					endpointWSPolicyKey.setText("");
				}
				
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		/*
		 * endpointOutboundPolicyLabel = toolkit.createLabel(qosSectionClient,
		 * "Outbound Policy :"); endpointOutboundPolicyLabel.setLayoutData(new
		 * GridData(GridData.FILL_BOTH));
		 */
		endpointSecurityOutboundPolicyKey = toolkit.createText(qosSectionClient, "");
		endpointSecurityOutboundPolicyKey.setEditable(false);
		endpointSecurityOutboundPolicyKey.setBackground(new Color(null, 229, 236, 253));
		// endpointSecurityOutboundPolicyKey.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointOutboundPolicyKeyGridData = new GridData();
		endpointOutboundPolicyKeyGridData.horizontalSpan = 3;
		endpointOutboundPolicyKeyGridData.horizontalAlignment = GridData.FILL;
		endpointOutboundPolicyKeyGridData.grabExcessHorizontalSpace = true;
		endpointSecurityOutboundPolicyKey.setLayoutData(endpointOutboundPolicyKeyGridData);
		
		endpointSecurityOutboundPolicyKey.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});


		endpointOutboundPolicyKey = toolkit.createButton(qosSectionClient, "Add Outbound Policy Key", SWT.PUSH);
		endpointOutboundPolicyKey.setBackground(new Color(null, 229, 236, 253));
		endpointOutboundPolicyKey.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		endpointOutboundPolicyKey.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
						registryKeyProperty, new ArrayList<NamedEntityDescriptor>(),
						endpointSecurityOutboundPolicyKey.getText());
				int open = dialog.open();
				if (open == Window.OK) {
					outboundPolicyKey = registryKeyProperty.getKeyValue();
					endpointSecurityOutboundPolicyKey.setText(outboundPolicyKey);
					endpointWSPolicyKey.setText("");
				}
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		disableInOutFields();

		qosSection.setClient(qosSectionClient);
	}

	private void disabeAddressingFields() {
		GridData versionlbl = (GridData) endpointVersionLabel.getLayoutData();
		versionlbl.exclude = true;
		GridData versionCmb = (GridData) endpointVersion.getLayoutData();
		versionCmb.exclude = true;
		GridData separatelbl = (GridData) endpointSeparateListnerLabel.getLayoutData();
		separatelbl.exclude = true;
		GridData separateCmb = (GridData) endpointSeparateListner.getLayoutData();
		separateCmb.exclude = true;
		endpointVersionLabel.setVisible(false);
		endpointVersion.setVisible(false);
		endpointSeparateListnerLabel.setVisible(false);
		endpointSeparateListner.setVisible(false);
		enbaleVisualizingAdditionalQOSFields();
	}

	private void enableAddressingFields() {
		GridData versionlbl = (GridData) endpointVersionLabel.getLayoutData();
		versionlbl.exclude = false;
		GridData versionCmb = (GridData) endpointVersion.getLayoutData();
		versionCmb.exclude = false;
		GridData separatelbl = (GridData) endpointSeparateListnerLabel.getLayoutData();
		separatelbl.exclude = false;
		GridData separateCmb = (GridData) endpointSeparateListner.getLayoutData();
		separateCmb.exclude = false;
		endpointVersionLabel.setVisible(true);
		endpointVersion.setVisible(true);
		endpointSeparateListnerLabel.setVisible(true);
		endpointSeparateListner.setVisible(true);
		enbaleVisualizingAdditionalQOSFields();
	}

	public void setAddressingFields(boolean check) {
		if (check) {
			enableAddressingFields();
		}

	}

	public void enableWSFields() {
		GridData chkBtn = (GridData) endpointInboundAndOutboundCheckBox.getLayoutData();
		chkBtn.exclude = false;
		endpointInboundAndOutboundCheckBox.setVisible(true);
		enbaleVisualizingAdditionalQOSFields();
	}

	public void disableWSFields() {
		GridData chkBtn = (GridData) endpointInboundAndOutboundCheckBox.getLayoutData();
		chkBtn.exclude = true;
		endpointInboundAndOutboundCheckBox.setVisible(false);
		enbaleVisualizingAdditionalQOSFields();
	}

	public void setWSFields(boolean check) {
		if (check) {
			enableWSFields();
			endpointInboundAndOutboundCheckBox.setSelection(false);
			enablePolicyFields();
			disableInOutFields();
		}
	}

	public void setInoutFields(boolean check) {
		if (check) {
			enableWSFields();
			endpointInboundAndOutboundCheckBox.setSelection(true);
			enablebleInOutFields();
			disablePolicyFields();
		}
	}

	public void enablePolicyFields() {
		GridData policyTxt = (GridData) endpointWSPolicyKey.getLayoutData();
		policyTxt.exclude = false;
		GridData policyBtn = (GridData) endpointPolicyKey.getLayoutData();
		policyBtn.exclude = false;
		endpointPolicyKey.setVisible(true);
		endpointWSPolicyKey.setVisible(true);
		enbaleVisualizingAdditionalQOSFields();
	}

	public void disablePolicyFields() {
		GridData policyTxt = (GridData) endpointWSPolicyKey.getLayoutData();
		policyTxt.exclude = true;
		GridData policyBtn = (GridData) endpointPolicyKey.getLayoutData();
		policyBtn.exclude = true;
		endpointPolicyKey.setVisible(false);
		endpointWSPolicyKey.setVisible(false);
		enbaleVisualizingAdditionalQOSFields();
	}

	public void disableInOutFields() {
		/*
		 * GridData inlbl = (GridData)
		 * endpointInboundPolicyLabel.getLayoutData(); inlbl.exclude = true;
		 */
		GridData inBtn = (GridData) endpointInboundPolicyKey.getLayoutData();
		inBtn.exclude = true;
		GridData inTxt = (GridData) endpointSecurityInboundPolicyKey.getLayoutData();
		inTxt.exclude = true;
		/*
		 * GridData outlbl = (GridData)
		 * endpointOutboundPolicyLabel.getLayoutData(); outlbl.exclude = true;
		 */
		GridData outBtn = (GridData) endpointOutboundPolicyKey.getLayoutData();
		outBtn.exclude = true;
		GridData outTxt = (GridData) endpointSecurityOutboundPolicyKey.getLayoutData();
		outTxt.exclude = true;
		// endpointInboundPolicyLabel.setVisible(false);
		endpointInboundPolicyKey.setVisible(false);
		endpointSecurityInboundPolicyKey.setVisible(false);
		// endpointOutboundPolicyLabel.setVisible(false);
		endpointOutboundPolicyKey.setVisible(false);
		endpointSecurityOutboundPolicyKey.setVisible(false);
		enbaleVisualizingAdditionalQOSFields();
	}

	private void enbaleVisualizingAdditionalQOSFields() {
		if (qosSection.isExpanded() == true) {
		qosSection.setExpanded(false);
		qosSection.setExpanded(true);
		}
	}

	public void enablebleInOutFields() {
		/*
		 * GridData inlbl = (GridData)
		 * endpointInboundPolicyLabel.getLayoutData(); inlbl.exclude = false;
		 */
		GridData inBtn = (GridData) endpointInboundPolicyKey.getLayoutData();
		inBtn.exclude = false;
		GridData inTxt = (GridData) endpointSecurityInboundPolicyKey.getLayoutData();
		inTxt.exclude = false;
		/*
		 * GridData outlbl = (GridData)
		 * endpointOutboundPolicyLabel.getLayoutData(); outlbl.exclude = false;
		 */
		GridData outBtn = (GridData) endpointOutboundPolicyKey.getLayoutData();
		outBtn.exclude = false;
		GridData outTxt = (GridData) endpointSecurityOutboundPolicyKey.getLayoutData();
		outTxt.exclude = false;
		// endpointInboundPolicyLabel.setVisible(true);
		endpointInboundPolicyKey.setVisible(true);
		endpointSecurityInboundPolicyKey.setVisible(true);
		// endpointOutboundPolicyLabel.setVisible(true);
		endpointOutboundPolicyKey.setVisible(true);
		endpointSecurityOutboundPolicyKey.setVisible(true);
		enbaleVisualizingAdditionalQOSFields();
	}

	public void createFormErrorHandlingSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Error handling */

		Section errorHandlingSection = createSection(form, toolkit,
				Messages.getString("EndpointPage.section.errorHandling"));
		errorHandlingSection.setExpanded(false);
		GridData errorSectionGridData = new GridData();
		errorSectionGridData.horizontalSpan = 3;
		errorSectionGridData.horizontalAlignment = GridData.FILL;
		errorSectionGridData.grabExcessHorizontalSpace = true;
		errorHandlingSection.setLayoutData(errorSectionGridData);

		Composite errorHandlingSectionClient = toolkit.createComposite(errorHandlingSection);
		errorHandlingSectionClient.setLayout(new GridLayout());

		/*
		 * Composite errorHandlingSectionClient =
		 * toolkit.createComposite(errorHandlingSection);
		 * errorHandlingSectionClient.setLayout(new TableWrapLayout());
		 */

		/* Endpoint Suspend State */
		toolkit.createLabel(errorHandlingSectionClient, "Endpoint Suspend State");
		toolkit.createLabel(errorHandlingSectionClient, null);

		toolkit.createLabel(errorHandlingSectionClient, "Suspend Error Codes :");
		endpointSuspendErrorCodes = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendErrorCodes.setBackground(new Color(null, 229, 236, 253));
		// endpointSuspendErrorCodes.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointSuspendCodesGridData = new GridData();
		endpointSuspendCodesGridData.horizontalSpan = 3;
		endpointSuspendCodesGridData.horizontalAlignment = GridData.FILL;
		endpointSuspendCodesGridData.grabExcessHorizontalSpace = true;
		endpointSuspendErrorCodes.setLayoutData(endpointSuspendCodesGridData);
		
		endpointSuspendErrorCodes.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});


		toolkit.createLabel(errorHandlingSectionClient, "Suspend Initial Duration :");
		endpointSuspendInitialDuration = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendInitialDuration.setBackground(new Color(null, 229, 236, 253));
		// endpointSuspendInitialDuration.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointSuspendInitialDurationGridData = new GridData();
		endpointSuspendInitialDurationGridData.horizontalSpan = 3;
		endpointSuspendInitialDurationGridData.horizontalAlignment = GridData.FILL;
		endpointSuspendInitialDurationGridData.grabExcessHorizontalSpace = true;
		endpointSuspendInitialDuration.setLayoutData(endpointSuspendInitialDurationGridData);
		
		endpointSuspendInitialDuration.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		toolkit.createLabel(errorHandlingSectionClient, "Suspend Maximum Duration :");
		endpointSuspendMaxDuration = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendMaxDuration.setBackground(new Color(null, 229, 236, 253));
		// endpointSuspendMaxDuration.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointSuspendMaxDurationGridData = new GridData();
		endpointSuspendMaxDurationGridData.horizontalSpan = 3;
		endpointSuspendMaxDurationGridData.horizontalAlignment = GridData.FILL;
		endpointSuspendMaxDurationGridData.grabExcessHorizontalSpace = true;
		endpointSuspendMaxDuration.setLayoutData(endpointSuspendMaxDurationGridData);
		
		endpointSuspendMaxDuration.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});


		toolkit.createLabel(errorHandlingSectionClient, "Suspend Progression Factor :");
		endpointSuspendProgressFactor = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendProgressFactor.setBackground(new Color(null, 229, 236, 253));
		// endpointSuspendProgressFactor.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointSuspendProgressFactorGridData = new GridData();
		endpointSuspendProgressFactorGridData.horizontalSpan = 3;
		endpointSuspendProgressFactorGridData.horizontalAlignment = GridData.FILL;
		endpointSuspendProgressFactorGridData.grabExcessHorizontalSpace = true;
		endpointSuspendProgressFactor.setLayoutData(endpointSuspendProgressFactorGridData);
		
		endpointSuspendProgressFactor.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		addSeparator(form, toolkit, errorHandlingSectionClient);

		/* Endpoint Timeout State */
		toolkit.createLabel(errorHandlingSectionClient, "Endpoint Timeout State");
		toolkit.createLabel(errorHandlingSectionClient, null);

		toolkit.createLabel(errorHandlingSectionClient, "Retry Error Codes :");
		endpointRetryErrorCodes = toolkit.createText(errorHandlingSectionClient, "");
		endpointRetryErrorCodes.setBackground(new Color(null, 229, 236, 253));
		// endpointRetryErrorCodes.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointEntryCodesGridData = new GridData();
		endpointEntryCodesGridData.horizontalSpan = 3;
		endpointEntryCodesGridData.horizontalAlignment = GridData.FILL;
		endpointEntryCodesGridData.grabExcessHorizontalSpace = true;
		endpointRetryErrorCodes.setLayoutData(endpointEntryCodesGridData);
		
		endpointRetryErrorCodes.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});


		toolkit.createLabel(errorHandlingSectionClient, "Retry Count :");
		endpointRetryCount = toolkit.createText(errorHandlingSectionClient, "");
		endpointRetryCount.setBackground(new Color(null, 229, 236, 253));
		// endpointRetryCount.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointRetryCountGridData = new GridData();
		endpointRetryCountGridData.horizontalSpan = 3;
		endpointRetryCountGridData.horizontalAlignment = GridData.FILL;
		endpointRetryCountGridData.grabExcessHorizontalSpace = true;
		endpointRetryCount.setLayoutData(endpointRetryCountGridData);
		
		endpointRetryCount.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		toolkit.createLabel(errorHandlingSectionClient, "Retry Delay :");
		endpointRetryDelay = toolkit.createText(errorHandlingSectionClient, "");
		endpointRetryDelay.setBackground(new Color(null, 229, 236, 253));
		// endpointRetryDelay.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointRetryDelayGridData = new GridData();
		endpointRetryDelayGridData.horizontalSpan = 3;
		endpointRetryDelayGridData.horizontalAlignment = GridData.FILL;
		endpointRetryDelayGridData.grabExcessHorizontalSpace = true;
		endpointRetryDelay.setLayoutData(endpointRetryDelayGridData);
		
		endpointRetryDelay.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		addSeparator(form, toolkit, errorHandlingSectionClient);

		/* Endpoint Timeout */
		toolkit.createLabel(errorHandlingSectionClient, "Timeout");
		toolkit.createLabel(errorHandlingSectionClient, null);

		toolkit.createLabel(errorHandlingSectionClient, "Timeout Duration :");
		endpointTimeoutDuration = toolkit.createText(errorHandlingSectionClient, "");
		endpointTimeoutDuration.setBackground(new Color(null, 229, 236, 253));
		// endpointTimeoutDuration.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointTimeoutDurationGridData = new GridData();
		endpointTimeoutDurationGridData.horizontalSpan = 3;
		endpointTimeoutDurationGridData.horizontalAlignment = GridData.FILL;
		endpointTimeoutDurationGridData.grabExcessHorizontalSpace = true;
		endpointTimeoutDuration.setLayoutData(endpointTimeoutDurationGridData);
		
		endpointTimeoutDuration.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		toolkit.createLabel(errorHandlingSectionClient, "Timeout Action :");
		endpointTimeoutAction = new Combo(errorHandlingSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		// endpointTimeoutAction.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));
		String[] timeoutActions = { "Never", "Discard", "Fault" };
		endpointTimeoutAction.setItems(timeoutActions);

		GridData endpointTimeoutActionGridData = new GridData();
		endpointTimeoutActionGridData.horizontalSpan = 3;
		endpointTimeoutActionGridData.horizontalAlignment = GridData.FILL;
		endpointTimeoutActionGridData.grabExcessHorizontalSpace = true;
		endpointTimeoutDuration.setLayoutData(endpointTimeoutActionGridData);
		
		endpointTimeoutDuration.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		endpointTimeoutAction.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		errorHandlingSection.setClient(errorHandlingSectionClient);
	}

	@SuppressWarnings("deprecation")
	public Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {

		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);

		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setText(heading);

		return section;
	}

	public void addSeparator(final ScrolledForm form, FormToolkit toolkit, Composite client) {
		Label padBefore = toolkit.createLabel(client, null);
		/*
		 * TableWrapData padData = new TableWrapData(); padData.maxWidth = 0;
		 * padBefore.setLayoutData(padData);
		 */
		GridData padData = new GridData();
		padData.horizontalSpan = 0;
		padData.horizontalAlignment = GridData.FILL;
		padData.grabExcessHorizontalSpace = true;
		padBefore.setLayoutData(padData);
		Label separator = new Label(client, SWT.SEPARATOR + SWT.HORIZONTAL);
		/*
		 * TableWrapData separatorData = new TableWrapData();
		 * separatorData.align = TableWrapData.FILL;
		 * separatorData.grabHorizontal = true; separatorData.maxHeight = 1;
		 * separatorData.valign = TableWrapData.MIDDLE;
		 * separator.setLayoutData(separatorData);
		 */
		GridData separatorData = new GridData();
		separatorData.horizontalSpan = 0;
		separatorData.horizontalAlignment = GridData.FILL;
		separatorData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(separatorData);
		Label padAfter = toolkit.createLabel(client, null);
		padAfter.setLayoutData(padData);
	}

	public String getTimeOutActionValue() {
		if (getEndpointTimeoutAction().getSelectionIndex() == 0) {
			return "Never";
		} else if (getEndpointTimeoutAction().getSelectionIndex() == 1) {
			return "Discard";
		} else {
			return "Fault";
		}
	}
}