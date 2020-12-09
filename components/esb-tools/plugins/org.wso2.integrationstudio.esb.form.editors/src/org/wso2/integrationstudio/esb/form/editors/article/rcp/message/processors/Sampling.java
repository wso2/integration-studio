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


public class Sampling implements IMessageProcessor {
    public Text sampling_sequence;
    public Button sampling_add_sequence;
    public Combo sampling_state;
    public Text sampling_interval;
    public Text sampling_concurrency;
    public Text sampling_quartzConfigFilePath;
    public Text sampling_cronExpression;
    public Button sampling_customParameters;
    public List<MessageProcessorParameter> messageProcessorParameterList;
    public String sequenceKey;
    
    private AbstractEsbFormPage esbFormPage;
    
    ScrolledForm form;
    FormToolkit toolkit;
    
    Section miscSection;
    Section parameterSection;
    
    

    public Sampling(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
    	this.form = form;
    	this.toolkit = toolkit;
    	this.esbFormPage = esbFormPage;
    	
	}

    @Override
    public void createMiscSectionFields() {
    	/* Connection Section */ 
		miscSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
    	 
    	Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new TableWrapLayout());
		miscSection.setClient(miscSectionClient);
		
		miscSection.setVisible(false);
		
    	
        toolkit.createLabel(miscSectionClient, "Sequence");
        sampling_sequence = toolkit.createText(miscSectionClient, "");
        sampling_sequence.setBackground(new Color(null, 229,236,253));
        sampling_sequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        sampling_sequence.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
        
        sampling_add_sequence = toolkit.createButton(miscSectionClient, "Add a Sequence Key", SWT.PUSH);
        sampling_add_sequence.setBackground(new Color(null, 229,236,253));
        sampling_add_sequence.addSelectionListener(new SelectionListener() {
			
 			@Override
 			public void widgetSelected(SelectionEvent e) {
 				Shell shell = Display.getDefault().getActiveShell();
 				RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
 				RegistryKeyPropertyEditorDialog dialog =
 				                                         new RegistryKeyPropertyEditorDialog(shell, SWT.NULL,
 				                                                                             registryKeyProperty, new ArrayList<NamedEntityDescriptor>(), sampling_sequence.getText()); 
 				int open = dialog.open();
 				if (open == Window.OK) {
 				    sequenceKey = registryKeyProperty.getKeyValue();
 					sampling_sequence.setText(sequenceKey);
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
    	
    	/* Parameter Section */
		parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.parameter"));
    	
		Composite parameterSectionClient = toolkit.createComposite(parameterSection);
		parameterSectionClient.setLayout(new TableWrapLayout());
		parameterSection.setClient(parameterSectionClient);
		
		parameterSection.setVisible(false);
    	
    	
        toolkit.createLabel(parameterSectionClient, "Processor State");
        sampling_state = new Combo(parameterSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
        sampling_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] states = {"Active", "Deactive"};
        sampling_state.setItems(states);
        sampling_state.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(SelectionEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
        	}
        });

        sampling_state.addListener(SWT.MouseVerticalWheel, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.doit = false;
            }
        });
        
        toolkit.createLabel(parameterSectionClient, "Sampling Interval");
        sampling_interval = toolkit.createText(parameterSectionClient, "");
        sampling_interval.setBackground(new Color(null, 229,236,253));
        sampling_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        sampling_interval.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        toolkit.createLabel(parameterSectionClient, "Sampling Concurrency");
        sampling_concurrency = toolkit.createText(parameterSectionClient, "");
        sampling_concurrency.setBackground(new Color(null, 229,236,253));
        sampling_concurrency.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        sampling_concurrency.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Quartz Config File Path");
        sampling_quartzConfigFilePath = toolkit.createText(parameterSectionClient, "");
        sampling_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
        sampling_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        sampling_quartzConfigFilePath.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        toolkit.createLabel(parameterSectionClient, "Cron Expression");
        sampling_cronExpression = toolkit.createText(parameterSectionClient, "");
        sampling_cronExpression.setBackground(new Color(null, 229,236,253));
        sampling_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        sampling_cronExpression.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

        addSeparator(form, toolkit, parameterSectionClient);

        sampling_customParameters = toolkit.createButton(parameterSectionClient, "Add Custom Parameters",SWT.PUSH);
        sampling_customParameters.setBackground(new Color(null, 229,236,253));
        sampling_customParameters.addSelectionListener(new SelectionListener() {
			
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
