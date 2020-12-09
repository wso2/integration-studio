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

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
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
import org.wso2.integrationstudio.eclipse.gmf.esb.MessageProcessorParameter;
import org.wso2.integrationstudio.esb.form.editors.article.providers.ConfigureMessageProcessorParametersDialog;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.Messages;

public class CustomProcessor implements IMessageProcessor {
    public Text custom_providerClass;
    public Button custom_customParameters;
    public List<MessageProcessorParameter> messageProcessorParameterList;
    
    private AbstractEsbFormPage esbFormPage;
    ScrolledForm form;
    FormToolkit toolkit;
    
    Section miscSection;
    Section parameterSection;
    
	public CustomProcessor(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
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

        toolkit.createLabel(miscSectionClient, "Message Processor Provider");
        custom_providerClass = toolkit.createText(miscSectionClient, "");
        custom_providerClass.setBackground(new Color(null, 229,236,253));
        custom_providerClass.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        custom_providerClass.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
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

        custom_customParameters = toolkit.createButton(parameterSectionClient, " Add Custom Parameters", SWT.PUSH);
        custom_customParameters.setBackground(new Color(null, 229,236,253));
        custom_customParameters.addSelectionListener(new SelectionListener() {
			
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
