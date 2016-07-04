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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class EndpointCommons {
	
	public Combo endpointReliableMessaging;
	public Combo getEndpointReliableMessaging() {
		return endpointReliableMessaging;
	}

	public void setEndpointReliableMessaging(Combo endpointReliableMessaging) {
		this.endpointReliableMessaging = endpointReliableMessaging;
	}

	public Combo getEndpointSecurity() {
		return endpointSecurity;
	}

	public void setEndpointSecurity(Combo endpointSecurity) {
		this.endpointSecurity = endpointSecurity;
	}

	public Combo getEndpointAddressing() {
		return endpointAddressing;
	}

	public void setEndpointAddressing(Combo endpointAddressing) {
		this.endpointAddressing = endpointAddressing;
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
	
	
	public Text endpointSuspendErrorCodes;
	public Text endpointSuspendInitialDuration;
	public Text endpointSuspendMaxDuration;
	public Text endpointSuspendProgressFactor;

	public Text endpointRetryErrorCodes;
	public Text endpointRetryCount;
	public Text endpointRetryDelay;

	public Text endpointTimeoutDuration;
	public Combo endpointTimeoutAction;
	
	
	public void createFormQosSection(final ScrolledForm form, FormToolkit toolkit) {
		
		/* QOS Information */ 
		Section qosSection = createSection(form, toolkit, Messages.getString("EndpointPage.section.qos"));
		
		Composite qosSectionClient = toolkit.createComposite(qosSection);
		qosSectionClient.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(qosSectionClient, "Reliable Messaging Enabled");
		endpointReliableMessaging = new Combo(qosSectionClient, SWT.DROP_DOWN);
		endpointReliableMessaging.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] states = {"True", "False"};
		endpointReliableMessaging.setItems(states);
		
		toolkit.createLabel(qosSectionClient, "Security Enabled");
		endpointSecurity = new Combo(qosSectionClient, SWT.DROP_DOWN);
		endpointSecurity.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] states1 = {"True", "False"};
		endpointSecurity.setItems(states1);
		
		toolkit.createLabel(qosSectionClient, "Addressing Enabled");
		endpointAddressing = new Combo(qosSectionClient, SWT.DROP_DOWN);
		endpointAddressing.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] states2 = {"True", "False"};
		endpointAddressing.setItems(states2);
		
		qosSection.setClient(qosSectionClient);
	}

	public void createFormErrorHandlingSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Error handling */
		Section errorHandlingSection = createSection(form, toolkit, Messages.getString("EndpointPage.section.errorHandling"));
		
		Composite errorHandlingSectionClient = toolkit.createComposite(errorHandlingSection);
		errorHandlingSectionClient.setLayout(new TableWrapLayout());
		
		/* Endpoint Suspend State */
		toolkit.createLabel(errorHandlingSectionClient, "Endpoint Suspend State");
		toolkit.createLabel(errorHandlingSectionClient, null);
		
		toolkit.createLabel(errorHandlingSectionClient, "Suspend Error Codes");
		endpointSuspendErrorCodes = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendErrorCodes.setBackground(new Color(null, 229,236,253));
		endpointSuspendErrorCodes.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(errorHandlingSectionClient, "Suspend Initial Duration");
		endpointSuspendInitialDuration = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendInitialDuration.setBackground(new Color(null, 229,236,253));
		endpointSuspendInitialDuration.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(errorHandlingSectionClient, "Suspend Maximum Duration");
		endpointSuspendMaxDuration = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendMaxDuration.setBackground(new Color(null, 229,236,253));
		endpointSuspendMaxDuration.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(errorHandlingSectionClient, "Suspend Progression Factor");
		endpointSuspendProgressFactor = toolkit.createText(errorHandlingSectionClient, "");
		endpointSuspendProgressFactor.setBackground(new Color(null, 229,236,253));
		endpointSuspendProgressFactor.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		addSeparator(form, toolkit, errorHandlingSectionClient);
		
		/* Endpoint Timeout State */
		toolkit.createLabel(errorHandlingSectionClient, "Endpoint Timeout State");
		toolkit.createLabel(errorHandlingSectionClient, null);
		
		toolkit.createLabel(errorHandlingSectionClient, "Retry Error Codes");
		endpointRetryErrorCodes = toolkit.createText(errorHandlingSectionClient, "");
		endpointRetryErrorCodes.setBackground(new Color(null, 229,236,253));
		endpointRetryErrorCodes.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(errorHandlingSectionClient, "Retry Count");
		endpointRetryCount = toolkit.createText(errorHandlingSectionClient, "");
		endpointRetryCount.setBackground(new Color(null, 229,236,253));
		endpointRetryCount.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(errorHandlingSectionClient, "Retry Delay");
		endpointRetryDelay = toolkit.createText(errorHandlingSectionClient, "");
		endpointRetryDelay.setBackground(new Color(null, 229,236,253));
		endpointRetryDelay.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		
		addSeparator(form, toolkit, errorHandlingSectionClient);
		
		/* Endpoint Timeout */
		toolkit.createLabel(errorHandlingSectionClient, "Timeout");
		toolkit.createLabel(errorHandlingSectionClient, null);
		
		toolkit.createLabel(errorHandlingSectionClient, "Timeout Duration");
		endpointTimeoutDuration = toolkit.createText(errorHandlingSectionClient, "");
		endpointTimeoutDuration.setBackground(new Color(null, 229,236,253));
		endpointTimeoutDuration.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(errorHandlingSectionClient, "Timeout Action");
		endpointTimeoutAction = new Combo(errorHandlingSectionClient, SWT.DROP_DOWN);
		endpointTimeoutAction.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] timeoutActions = {"Never", "Discard", "Fault"};
		endpointTimeoutAction.setItems(timeoutActions);

		errorHandlingSection.setClient(errorHandlingSectionClient);
	}

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
		TableWrapData padData = new TableWrapData();
		padData.maxWidth = 0;
		padBefore.setLayoutData(padData);
		Label separator = new Label(client, SWT.SEPARATOR + SWT.HORIZONTAL);
		TableWrapData separatorData = new TableWrapData();
		separatorData.align = TableWrapData.FILL;
		separatorData.grabHorizontal = true;
		separatorData.maxHeight = 1;
		separatorData.valign = TableWrapData.MIDDLE;
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
