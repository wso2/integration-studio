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


package org.wso2.developerstudio.esb.form.editors.article.rcp;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MessageProcessorFormPage extends FormPage {
	/**
	 * @param id
	 * @param title
	 */
	
	private String[] messageProcessorTypes = {"Message Sampling Processor", "Scheduled Message Forwarding Processor", "Scheduled Failover Message Forwarding Processor", "Custom Message Processor"};
	private MessageProcessor currentMessageProcessor = null;
	private ArrayList<Section> sectionsList = new ArrayList<Section>();
	
	public MessageProcessorFormPage(FormEditor editor) {
		super(editor, "messageProcessorForm", Messages.getString("MessageProcessorPage.sectionMainTitle"));
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("MessageProcessorPage.sectionMainTitle")); 
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

		ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);

		// Only show basic
		createFormBasicSection(form, toolkit);
		
	}
	
	private void createFormBasicSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Basic Section */
		Section basicSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		basicSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		basicSection.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(basicSection);
		
		basicSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		basicSection.setText(Messages.getString("MessageProcessorPage.section.basic"));
		
		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(basicSectionClient, "Message Processor Name");
		Text processorName = toolkit.createText(basicSectionClient, "");
		processorName.setBackground(new Color(null, 229,236,253));
		processorName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(basicSectionClient, "Message Processor Type");
		Combo processorType = new Combo(basicSectionClient, SWT.DROP_DOWN);
		processorType.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] triggerTypes = messageProcessorTypes;
		processorType.setItems(triggerTypes);
		processorType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Create message stores
				if (processorType.getText().equals("Message Sampling Processor")) {
					currentMessageProcessor = new Sampling();
				} else if (processorType.getText().equals("Scheduled Message Forwarding Processor")) {
					currentMessageProcessor = new ScheduledForwarding();
				} else if (processorType.getText().equals("Scheduled Failover Message Forwarding Processor")) {
					currentMessageProcessor = new ScheduledFailoverForwarding();
				} else if (processorType.getText().equals("Custom Message Processor")) {
					currentMessageProcessor = new CustomProcessor();
				}
				
				if (currentMessageProcessor != null) {
					
					// dispose and clear sections, if already existing
					for (Section sec:sectionsList) {
						sec.dispose();
					}
					sectionsList.clear();
					

					// if identified message store, show the rest
					createFormMiscSection(form, toolkit);
					createFormParameterSection(form, toolkit);
					
				}
			}
		});
		
		
		toolkit.createLabel(basicSectionClient, "Message Store Name");
		Text storeName = toolkit.createText(basicSectionClient, "");
		storeName.setBackground(new Color(null, 229,236,253));
		storeName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		
		basicSection.setClient(basicSectionClient);
		
	}
	
	
	private void createFormMiscSection(final ScrolledForm form, FormToolkit toolkit) {

		
		if(!currentMessageProcessor.hasMisc()) return;
		
		 /* Connection Section */ 
		Section connSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
		
		Composite connSectionClient = toolkit.createComposite(connSection);
		connSectionClient.setLayout(new TableWrapLayout());
		
		
		currentMessageProcessor.createMiscSectionFields(form, toolkit, connSectionClient);
		
		connSection.setClient(connSectionClient);
		
		sectionsList.add(connSection);
		
	}
	
	
	private void createFormParameterSection(final ScrolledForm form, FormToolkit toolkit) {
		
		if(!currentMessageProcessor.hasParameters()) return;
		
		/* Trigger Information */ 
		Section parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.parameter"));
		
		Composite parameterSectionClient = toolkit.createComposite(parameterSection);
		parameterSectionClient.setLayout(new TableWrapLayout());

		currentMessageProcessor.createParameterSectionFields(form, toolkit, parameterSectionClient);
		
		parameterSection.setClient(parameterSectionClient);
		sectionsList.add(parameterSection);
	}
	
	private Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {
		
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

}




interface MessageProcessor {
	
	public void createMiscSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient);
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient);
	
	public boolean hasMisc();
	public boolean hasParameters();	
}

class Sampling implements MessageProcessor {

	@Override
	public void createMiscSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Sequence");
		Text sampling_sequence = toolkit.createText(sectionClient, "");
		sampling_sequence.setBackground(new Color(null, 229,236,253));
		sampling_sequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Processor State");
		Combo sampling_state = new Combo(sectionClient, SWT.DROP_DOWN);
		sampling_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] states = {"Active", "Deactive"};
		sampling_state.setItems(states);
		
		toolkit.createLabel(sectionClient, "Sampling Interval");
		Text sampling_interval = toolkit.createText(sectionClient, "");
		sampling_interval.setBackground(new Color(null, 229,236,253));
		sampling_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Sampling Concurrency");
		Text sampling_concurrency = toolkit.createText(sectionClient, "");
		sampling_concurrency.setBackground(new Color(null, 229,236,253));
		sampling_concurrency.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		Label separator1 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Quartz Config File Path");
		Text sampling_quartzConfigFilePath = toolkit.createText(sectionClient, "");
		sampling_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
		sampling_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Cron Expression");
		Text sampling_cronExpression = toolkit.createText(sectionClient, "");
		sampling_cronExpression.setBackground(new Color(null, 229,236,253));
		sampling_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		Label separator2 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator2.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Custom Parameters");
		Text sampling_customParameters = toolkit.createText(sectionClient, "");
		sampling_customParameters.setBackground(new Color(null, 229,236,253));
		sampling_customParameters.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
	}

	@Override
	public boolean hasMisc() {
		return true;
	}

	@Override
	public boolean hasParameters() {
		return true;
	}
	
}

class ScheduledForwarding implements MessageProcessor {

	@Override
	public void createMiscSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Endpoint Name");
		Text forwarding_endpoint = toolkit.createText(sectionClient, "");
		forwarding_endpoint.setBackground(new Color(null, 229,236,253));
		forwarding_endpoint.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Processor State");
		Combo forwarding_state = new Combo(sectionClient, SWT.DROP_DOWN);
		forwarding_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] states = {"Active", "Deactive"};
		forwarding_state.setItems(states);
		
		toolkit.createLabel(sectionClient, "Forwarding Interval");
		Text forwarding_interval = toolkit.createText(sectionClient, "");
		forwarding_interval.setBackground(new Color(null, 229,236,253));
		forwarding_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Retry Interval");
		Text forwarding_retryInterval = toolkit.createText(sectionClient, "");
		forwarding_retryInterval.setBackground(new Color(null, 229,236,253));
		forwarding_retryInterval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Non Retry Http Status Codes (eg - 304, 305)");
		Text forwarding_nonRetryHttpCodes = toolkit.createText(sectionClient, "");
		forwarding_nonRetryHttpCodes.setBackground(new Color(null, 229,236,253));
		forwarding_nonRetryHttpCodes.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Max Delivery Attempts");
		Text forwarding_maxDeliveryAttempts = toolkit.createText(sectionClient, "");
		forwarding_maxDeliveryAttempts.setBackground(new Color(null, 229,236,253));
		forwarding_maxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Drop Message After Maximum Delivery Attempts");
		Combo forwarding_dropMessageAfterMaxDeliveryAttempts = new Combo(sectionClient, SWT.DROP_DOWN);
		forwarding_dropMessageAfterMaxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] dropConditions = {"True", "False"};
		forwarding_dropMessageAfterMaxDeliveryAttempts.setItems(dropConditions);
		
		Label separator1 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Axis2 Client Repository");
		Text forwarding_axis2ClientRepo = toolkit.createText(sectionClient, "");
		forwarding_axis2ClientRepo.setBackground(new Color(null, 229,236,253));
		forwarding_axis2ClientRepo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		
		toolkit.createLabel(sectionClient, "Axis2 Configuration");
		Text forwarding_axis2Config = toolkit.createText(sectionClient, "");
		forwarding_axis2Config.setBackground(new Color(null, 229,236,253));
		forwarding_axis2Config.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		Label separator2 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator2.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Reply Sequence Name");
		Text forwarding_replySequence = toolkit.createText(sectionClient, "");
		forwarding_replySequence.setBackground(new Color(null, 229,236,253));
		forwarding_replySequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		
		toolkit.createLabel(sectionClient, "Fault Sequence Name");
		Text forwarding_faultSequence = toolkit.createText(sectionClient, "");
		forwarding_faultSequence.setBackground(new Color(null, 229,236,253));
		forwarding_faultSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Deactivate Sequence Name");
		Text forwarding_deactiveSequence = toolkit.createText(sectionClient, "");
		forwarding_deactiveSequence.setBackground(new Color(null, 229,236,253));
		forwarding_deactiveSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		Label separator3 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator3.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Quartz Config File Path");
		Text forwarding_quartzConfigFilePath = toolkit.createText(sectionClient, "");
		forwarding_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
		forwarding_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Cron Expression");
		Text forwarding_cronExpression = toolkit.createText(sectionClient, "");
		forwarding_cronExpression.setBackground(new Color(null, 229,236,253));
		forwarding_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Task Count");
		Text forwarding_taskCount = toolkit.createText(sectionClient, "");
		forwarding_taskCount.setBackground(new Color(null, 229,236,253));
		forwarding_taskCount.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		Label separator4 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator4.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Custom Parameters");
		Text forwarding_customParameters = toolkit.createText(sectionClient, "");
		forwarding_customParameters.setBackground(new Color(null, 229,236,253));
		forwarding_customParameters.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));		
		
		
	}

	@Override
	public boolean hasMisc() {
		return true;
	}

	@Override
	public boolean hasParameters() {
		return true;
	}
	
}

class ScheduledFailoverForwarding implements MessageProcessor {

	@Override
	public void createMiscSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Target Message Store");
		Text failover_store = toolkit.createText(sectionClient, "");
		failover_store.setBackground(new Color(null, 229,236,253));
		failover_store.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Processor State");
		Combo failover_state = new Combo(sectionClient, SWT.DROP_DOWN);
		failover_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] states = {"Active", "Deactive"};
		failover_state.setItems(states);
		
		toolkit.createLabel(sectionClient, "Forwarding Interval");
		Text failover_interval = toolkit.createText(sectionClient, "");
		failover_interval.setBackground(new Color(null, 229,236,253));
		failover_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Retry Interval");
		Text failover_retryInterval = toolkit.createText(sectionClient, "");
		failover_retryInterval.setBackground(new Color(null, 229,236,253));
		failover_retryInterval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Max Delivery Attempts");
		Text failover_maxDeliveryAttempts = toolkit.createText(sectionClient, "");
		failover_maxDeliveryAttempts.setBackground(new Color(null, 229,236,253));
		failover_maxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Drop Message After Maximum Delivery Attempts");
		Combo failover_dropMessageAfterMaxDeliveryAttempts = new Combo(sectionClient, SWT.DROP_DOWN);
		failover_dropMessageAfterMaxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] dropConditions = {"True", "False"};
		failover_dropMessageAfterMaxDeliveryAttempts.setItems(dropConditions);
		
		Label separator1 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator1.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Fault Sequence Name");
		Text failover_faultSequence = toolkit.createText(sectionClient, "");
		failover_faultSequence.setBackground(new Color(null, 229,236,253));
		failover_faultSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Deactivate Sequence Name");
		Text failover_deactiveSequence = toolkit.createText(sectionClient, "");
		failover_deactiveSequence.setBackground(new Color(null, 229,236,253));
		failover_deactiveSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		Label separator2 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator2.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Quartz Config File Path");
		Text failover_quartzConfigFilePath = toolkit.createText(sectionClient, "");
		failover_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
		failover_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Cron Expression");
		Text failover_cronExpression = toolkit.createText(sectionClient, "");
		failover_cronExpression.setBackground(new Color(null, 229,236,253));
		failover_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Task Count");
		Text failover_taskCount = toolkit.createText(sectionClient, "");
		failover_taskCount.setBackground(new Color(null, 229,236,253));
		failover_taskCount.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		Label separator3 = toolkit.createSeparator(sectionClient, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator3.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Custom Parameters");
		Text failover_customParameters = toolkit.createText(sectionClient, "");
		failover_customParameters.setBackground(new Color(null, 229,236,253));
		failover_customParameters.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public boolean hasMisc() {
		return true;
	}

	@Override
	public boolean hasParameters() {
		return true;
	}
	
}

class CustomProcessor implements MessageProcessor {

	@Override
	public void createMiscSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {

		toolkit.createLabel(sectionClient, "Message Processor Provider");
		Text custom_providerClass = toolkit.createText(sectionClient, "");
		custom_providerClass.setBackground(new Color(null, 229,236,253));
		custom_providerClass.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {

		toolkit.createLabel(sectionClient, "Custom Parameters");
		Text custom_customParameters = toolkit.createText(sectionClient, "");
		custom_customParameters.setBackground(new Color(null, 229,236,253));
		custom_customParameters.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public boolean hasMisc() {
		return true;
	}

	@Override
	public boolean hasParameters() {
		return true;
	}
	
}



