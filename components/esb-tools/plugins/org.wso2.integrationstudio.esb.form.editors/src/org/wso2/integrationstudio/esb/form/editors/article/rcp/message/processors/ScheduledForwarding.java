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

package org.wso2.integrationstudio.esb.form.editors.article.rcp.message.processors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
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
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.esb.form.editors.article.providers.ConfigureMessageProcessorParametersDialog;
import org.wso2.integrationstudio.esb.form.editors.article.providers.NamedEntityDescriptor;
import org.wso2.integrationstudio.esb.form.editors.article.providers.RegistryKeyPropertyEditorDialog;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.Messages;

public class ScheduledForwarding implements IMessageProcessor {
    public Text forwarding_endpoint;
    public Button forwarding_add_endpoint;
    public Combo forwarding_state;
    public Text forwarding_interval;
    public Text forwarding_retryInterval;
    public Text forwarding_nonRetryHttpCodes;
    public Text forwarding_maxDeliveryAttempts;
    public Text forwarding_maxStoreConnectionAttempts;
    public Text forwarding_storeConnectionAttemptInterval;
    public Combo forwarding_dropMessageAfterMaxDeliveryAttempts;
    public Text forwarding_axis2ClientRepo;
    public Text forwarding_axis2Config;
    public Text forwarding_replySequence;
    public Button forwarding_add_replySequence;
    public Text forwarding_faultSequence;
    public Button forwarding_add_faultSequence;
    public Text forwarding_deactiveSequence;
    public Button forwarding_add_deactiveSequence;
    public Text forwarding_failMessagesStore;
    public Text forwarding_quartzConfigFilePath;
    public Text forwarding_cronExpression;
    public Text forwarding_taskCount;
    public Button forwarding_customParameters;
    public List<MessageProcessorParameter> messageProcessorParameterList;
    String endpointKey;
    String replySequenceKey;
    String faultSequenceKey;
    String deactiveSequenceKey;
    
    private AbstractEsbFormPage esbFormPage;
    
    private ScrolledForm form;
    private FormToolkit toolkit;
    
    Section miscSection;
    Section parameterSection;

    public ScheduledForwarding(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
    	this.form = form;
    	this.toolkit = toolkit;
    	this.esbFormPage = esbFormPage;
	}

    @Override
    public void createMiscSectionFields() {
    	 /* Misc Section */ 
		miscSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
		
		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new TableWrapLayout());
		miscSection.setClient(miscSectionClient);
		
		miscSection.setVisible(false);
		
        toolkit.createLabel(miscSectionClient, "Endpoint Name");
        forwarding_endpoint = toolkit.createText(miscSectionClient, "");
        forwarding_endpoint.setBackground(new Color(null, 229,236,253));
        forwarding_endpoint.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_endpoint.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        forwarding_add_endpoint = toolkit.createButton(miscSectionClient, "Add an Endpoint Key", SWT.PUSH);
        forwarding_add_endpoint.setBackground(new Color(null, 229,236,253));
        forwarding_add_endpoint.addSelectionListener(new SelectionListener() {
			
 			@Override
 			public void widgetSelected(SelectionEvent e) {
 				Shell shell = Display.getDefault().getActiveShell();
 				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
 				RegistryKeyPropertyEditorDialog dialog =
 				                                         new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
 				                                                                             registryKeyProperty, new ArrayList<NamedEntityDescriptor>(),forwarding_endpoint.getText()); 
 				int open = dialog.open();
 				if (open == Window.OK) {
 					endpointKey = registryKeyProperty.getKeyValue();
 					forwarding_endpoint.setText(endpointKey);
 				}
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
 			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

    }

    @Override
    public void createParameterSectionFields() {
    	
    	parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.parameter"));
		
		Composite parameterSectionClient = toolkit.createComposite(parameterSection);
		parameterSectionClient.setLayout(new TableWrapLayout());
		parameterSection.setClient(parameterSectionClient);
		
		parameterSection.setVisible(false);
    	
        toolkit.createLabel(parameterSectionClient, "Processor State");
        forwarding_state = new Combo(parameterSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
        forwarding_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] states = {"Active", "Deactive"};
        forwarding_state.setItems(states);
		forwarding_state.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
        forwarding_state.addListener(SWT.MouseVerticalWheel, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.doit = false;
            }
        });

        toolkit.createLabel(parameterSectionClient, "Forwarding Interval");
        forwarding_interval = toolkit.createText(parameterSectionClient, "");
        forwarding_interval.setBackground(new Color(null, 229,236,253));
        forwarding_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_interval.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        toolkit.createLabel(parameterSectionClient, "Retry Interval");
        forwarding_retryInterval = toolkit.createText(parameterSectionClient, "");
        forwarding_retryInterval.setBackground(new Color(null, 229,236,253));
        forwarding_retryInterval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_retryInterval.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        toolkit.createLabel(parameterSectionClient, "Non Retry Http Status Codes (eg - 304, 305)");
        forwarding_nonRetryHttpCodes = toolkit.createText(parameterSectionClient, "");
        forwarding_nonRetryHttpCodes.setBackground(new Color(null, 229,236,253));
        forwarding_nonRetryHttpCodes.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_nonRetryHttpCodes.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        toolkit.createLabel(parameterSectionClient, "Max Redelivery Attempts");
        forwarding_maxDeliveryAttempts = toolkit.createText(parameterSectionClient, "");
        forwarding_maxDeliveryAttempts.setBackground(new Color(null, 229,236,253));
        forwarding_maxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_maxDeliveryAttempts.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        toolkit.createLabel(parameterSectionClient, "Drop Message After Maximum Delivery Attempts");
        forwarding_dropMessageAfterMaxDeliveryAttempts = new Combo(parameterSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
        forwarding_dropMessageAfterMaxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] dropConditions = {"Enabled", "Disabled"};
        forwarding_dropMessageAfterMaxDeliveryAttempts.setItems(dropConditions);
        forwarding_dropMessageAfterMaxDeliveryAttempts.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        forwarding_dropMessageAfterMaxDeliveryAttempts.addListener(SWT.MouseVerticalWheel, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.doit = false;
            }
        });
        
        addSeparator(form, toolkit, parameterSectionClient);
        
        toolkit.createLabel(parameterSectionClient, "Maximum Store Connection Attempts");
        forwarding_maxStoreConnectionAttempts = toolkit.createText(parameterSectionClient, "");
        forwarding_maxStoreConnectionAttempts.setBackground(new Color(null, 229,236,253));
        forwarding_maxStoreConnectionAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_maxStoreConnectionAttempts.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        toolkit.createLabel(parameterSectionClient, "Store Connection Attempt Interval(miliseconds)");
        forwarding_storeConnectionAttemptInterval = toolkit.createText(parameterSectionClient, "");
        forwarding_storeConnectionAttemptInterval.setBackground(new Color(null, 229,236,253));
        forwarding_storeConnectionAttemptInterval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_storeConnectionAttemptInterval.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Axis2 Client Repository");
        forwarding_axis2ClientRepo = toolkit.createText(parameterSectionClient, "");
        forwarding_axis2ClientRepo.setBackground(new Color(null, 229,236,253));
        forwarding_axis2ClientRepo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_axis2ClientRepo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});


        toolkit.createLabel(parameterSectionClient, "Axis2 Configuration");
        forwarding_axis2Config = toolkit.createText(parameterSectionClient, "");
        forwarding_axis2Config.setBackground(new Color(null, 229,236,253));
        forwarding_axis2Config.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_axis2Config.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Reply Sequence Name");
        forwarding_replySequence = toolkit.createText(parameterSectionClient, "");
        forwarding_replySequence.setBackground(new Color(null, 229,236,253));
        forwarding_replySequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_replySequence.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        forwarding_add_replySequence = toolkit.createButton(parameterSectionClient, "Add a Reply Sequence Key", SWT.PUSH);
        forwarding_add_replySequence.setBackground(new Color(null, 229,236,253));
        forwarding_add_replySequence.addSelectionListener(new SelectionListener() {
			
 			@Override
 			public void widgetSelected(SelectionEvent e) {
 				Shell shell = Display.getDefault().getActiveShell();
 				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
 				RegistryKeyPropertyEditorDialog dialog =
 				                                         new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
 				                                                                             registryKeyProperty, new ArrayList<NamedEntityDescriptor>(),forwarding_replySequence.getText()); 
 				int open = dialog.open();
 				if (open == Window.OK) {
 					replySequenceKey = registryKeyProperty.getKeyValue();
 					forwarding_replySequence.setText(replySequenceKey);
 				}
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
 			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });


        toolkit.createLabel(parameterSectionClient, "Fault Sequence Name");
        forwarding_faultSequence = toolkit.createText(parameterSectionClient, "");
        forwarding_faultSequence.setBackground(new Color(null, 229,236,253));
        forwarding_faultSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_faultSequence.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        forwarding_add_faultSequence = toolkit.createButton(parameterSectionClient, "Add a Fault Sequence Key", SWT.PUSH);
        forwarding_add_faultSequence.setBackground(new Color(null, 229,236,253));
        forwarding_add_faultSequence.addSelectionListener(new SelectionListener() {
			
 			@Override
 			public void widgetSelected(SelectionEvent e) {
 				Shell shell = Display.getDefault().getActiveShell();
 				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
 				RegistryKeyPropertyEditorDialog dialog =
 				                                         new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
 				                                                                             registryKeyProperty, new ArrayList<NamedEntityDescriptor>(),forwarding_faultSequence.getText()); 
 				int open = dialog.open();
 				if (open == Window.OK) {
 					faultSequenceKey = registryKeyProperty.getKeyValue();
 					forwarding_faultSequence.setText(faultSequenceKey);
 				}
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
 			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

        toolkit.createLabel(parameterSectionClient, "Deactivate Sequence Name");
        forwarding_deactiveSequence = toolkit.createText(parameterSectionClient, "");
        forwarding_deactiveSequence.setBackground(new Color(null, 229,236,253));
        forwarding_deactiveSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_deactiveSequence.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        forwarding_add_deactiveSequence = toolkit.createButton(parameterSectionClient, "Add a Deactive Sequence Key", SWT.PUSH);
        forwarding_add_deactiveSequence.setBackground(new Color(null, 229,236,253));
        forwarding_add_deactiveSequence.addSelectionListener(new SelectionListener() {
			
 			@Override
 			public void widgetSelected(SelectionEvent e) {
 				Shell shell = Display.getDefault().getActiveShell();
 				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
 				RegistryKeyPropertyEditorDialog dialog =
 				                                         new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
 				                                                                             registryKeyProperty, new ArrayList<NamedEntityDescriptor>(),forwarding_deactiveSequence.getText()); 
 				int open = dialog.open();
 				if (open == Window.OK) {
 					deactiveSequenceKey = registryKeyProperty.getKeyValue();
 					forwarding_deactiveSequence.setText(deactiveSequenceKey);
 				}
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
 			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        toolkit.createLabel(parameterSectionClient, "Fail Messages Store");
        forwarding_failMessagesStore = toolkit.createText(parameterSectionClient, "");
        forwarding_failMessagesStore.setBackground(new Color(null, 229,236,253));
        forwarding_failMessagesStore.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_failMessagesStore.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Quartz Config File Path");
        forwarding_quartzConfigFilePath = toolkit.createText(parameterSectionClient, "");
        forwarding_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
        forwarding_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_quartzConfigFilePath.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        toolkit.createLabel(parameterSectionClient, "Cron Expression");
        forwarding_cronExpression = toolkit.createText(parameterSectionClient, "");
        forwarding_cronExpression.setBackground(new Color(null, 229,236,253));
        forwarding_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_cronExpression.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        toolkit.createLabel(parameterSectionClient, "Task Count");
        forwarding_taskCount = toolkit.createText(parameterSectionClient, "");
        forwarding_taskCount.setBackground(new Color(null, 229,236,253));
        forwarding_taskCount.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        forwarding_taskCount.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

       addSeparator(form, toolkit, parameterSectionClient);
       
       forwarding_customParameters = toolkit.createButton(parameterSectionClient, "Add Custom Parameters",SWT.PUSH);
       forwarding_customParameters.setBackground(new Color(null, 229,236,253));
       forwarding_customParameters.addSelectionListener(new SelectionListener() {
			
    			@Override
    			public void widgetSelected(SelectionEvent e) {
    				Shell shell = Display.getDefault().getActiveShell();
    				ConfigureMessageProcessorParametersDialog paramDialog = new ConfigureMessageProcessorParametersDialog(shell,messageProcessorParameterList);
    				paramDialog.setBlockOnOpen(true);
    				paramDialog.open();
    				messageProcessorParameterList = paramDialog.getMessageProcessorPropertyList();
    				esbFormPage.setSave(true);
    				esbFormPage.updateDirtyState();
    			}
    			
    			@Override
    			public void widgetDefaultSelected(SelectionEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    		});
     	
    }

    @Override
    public boolean hasMisc() {
        return true;
    }

    @Override
    public boolean hasParameters() {
        return true;
    }

    private void addSeparator(final ScrolledForm form, FormToolkit toolkit, Composite client) {
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
    
    @Override
	public void showParameterSectionFields() {
		parameterSection.setVisible(true);
		parameterSection.setExpanded(true);
	}

	@Override
	public void showMiscSectionFields() {
		miscSection.setVisible(true);
		miscSection.setExpanded(true);
	}

	@Override
	public void hideParameterSectionFields() {
		parameterSection.setVisible(false);
		parameterSection.setExpanded(false);
	}

	@Override
	public void hideMiscSectionFields() {
		miscSection.setVisible(false);
		miscSection.setExpanded(false);
	}

}
