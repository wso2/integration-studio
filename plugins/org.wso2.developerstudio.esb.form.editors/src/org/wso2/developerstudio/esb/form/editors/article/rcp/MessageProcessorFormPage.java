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


package org.wso2.developerstudio.esb.form.editors.article.rcp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.article.rcp.message.processors.*;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MessageProcessorFormPage extends AbstractEsbFormPage {
	/**
	 * @param id
	 * @param title
	 */
	
	private String[] messageProcessorTypes = {"Message Sampling Processor", "Scheduled Message Forwarding Processor", "Scheduled Failover Message Forwarding Processor", "Custom Message Processor"};
	public IMessageProcessor currentMessageProcessor = null;
	
	public Text processorName;
	public Combo processorType;
	public Text storeName;
	
	ScrolledForm form ;
	FormToolkit toolkit;
	
	private static final String messageSamplingProcessor = "org.apache.synapse.message.processor.impl.sampler.SamplingProcessor";
	private static final String scheduledMessageForwardingProcessor = "org.apache.synapse.message.processor.impl.forwarder.ScheduledMessageForwardingProcessor";
	private static final String scheduledFailoverMessageForwardingProcessor = "org.apache.synapse.message.processor.impl.failover.FailoverScheduledMessageForwardingProcessor";
	private static final String customProcessor = "customProcessor";
	
	Map<String, IMessageProcessor> processorMap;
	
	
	private org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor messageProcessor;
	

	public MessageProcessorFormPage(FormEditor editor) {
		super(editor, "messageProcessorForm", Messages.getString("MessageProcessorPage.sectionMainTitle"));
	}
	

	protected void createFormContent(IManagedForm managedForm) {
		form = managedForm.getForm();
		toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("MessageProcessorPage.sectionMainTitle")); 
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

		ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);
		
		processorMap = new LinkedHashMap<String, IMessageProcessor>();
		
		
		processorMap.put(messageSamplingProcessor, new Sampling(form, toolkit, this));
		processorMap.put(scheduledMessageForwardingProcessor, new ScheduledForwarding(form, toolkit, this));
		processorMap.put(scheduledFailoverMessageForwardingProcessor, new ScheduledFailoverForwarding(form, toolkit, this));
		processorMap.put(customProcessor, new CustomProcessor(form, toolkit, this));
		

		createFormBasicSection(form, toolkit);
		createFormMiscSection(form, toolkit);
		createFormParameterSection(form, toolkit);
		
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
		
		basicSection.setClient(basicSectionClient);
		
		toolkit.createLabel(basicSectionClient, "Message Processor Name *");
		processorName = toolkit.createText(basicSectionClient, "");
		processorName.setBackground(new Color(null, 229,236,253));
		processorName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		processorName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});


		toolkit.createLabel(basicSectionClient, "Message Processor Type *");
		processorType = new Combo(basicSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		processorType.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] triggerTypes = messageProcessorTypes;
		processorType.setItems(triggerTypes);
		processorType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Create message stores
				if (processorType.getSelectionIndex() == 0) {
					currentMessageProcessor = processorMap.get(messageSamplingProcessor);
				} else if (processorType.getSelectionIndex() == 1) {
					currentMessageProcessor = processorMap.get(scheduledMessageForwardingProcessor);
				} else if (processorType.getSelectionIndex() == 2) {
					currentMessageProcessor = processorMap.get(scheduledFailoverMessageForwardingProcessor);;
				} else if (processorType.getSelectionIndex() == 3) {
					currentMessageProcessor = processorMap.get(customProcessor);
				}
				
				refreshProcessorSettings();
				setSave(true);
				updateDirtyState();
			}
		});
		
		processorType.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		toolkit.createLabel(basicSectionClient, "Message Store Name *");
		storeName = toolkit.createText(basicSectionClient, "");
		storeName.setBackground(new Color(null, 229,236,253));
		storeName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		storeName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
	}
	
	
	private void createFormMiscSection(final ScrolledForm form, FormToolkit toolkit) {
		
		for (IMessageProcessor aProcessor: processorMap.values()){
			aProcessor.createMiscSectionFields();
		}
		
	}
	
	
	private void createFormParameterSection(final ScrolledForm form, FormToolkit toolkit) {
		
		for (IMessageProcessor aProcessor: processorMap.values()){
			aProcessor.createParameterSectionFields();
		}
		
	}


	// Processor getters,setters
	public IMessageProcessor getProcessorImpl(String processorClass) {
		return processorMap.get(processorClass);
	}
	
	
	
	public void refreshProcessorSettings() {
		
		int selectedIndex = processorType.getSelectionIndex();
		
		int index = 0;
		
		for (IMessageProcessor aProcessor: processorMap.values()){
			if (index == selectedIndex) {
				aProcessor.showParameterSectionFields();
				aProcessor.showMiscSectionFields();
			} else {
				aProcessor.hideParameterSectionFields();
				aProcessor.hideMiscSectionFields();
			}
			
			
			index ++;
		}
		
		
		
	}
	
}
