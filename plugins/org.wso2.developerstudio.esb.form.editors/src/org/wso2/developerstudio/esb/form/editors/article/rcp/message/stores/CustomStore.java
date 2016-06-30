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

package org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores;

import java.util.List;

import org.eclipse.swt.SWT;
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
import org.wso2.developerstudio.esb.form.editors.article.rcp.ConfigureMessageStoreParametersDialog;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStoreParameter;

public class CustomStore implements IMessageStore {
	
	public Text custom_providerClass;
	public Button custom_parameters;
	public List<MessageStoreParameter> messageStoreParameterList;
	
	ScrolledForm form;
	FormToolkit toolkit;
	
	Section connSection;
    Section parameterSection;
	
	public CustomStore(ScrolledForm form, FormToolkit toolkit) {
		this.form = form;
		this.toolkit = toolkit;
	}

	@Override
 	public void createConnectionSectionFields() {
		
		connSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
	   	 
    	Composite connSectionClient = toolkit.createComposite(connSection);
		connSectionClient.setLayout(new TableWrapLayout());
		connSection.setClient(connSectionClient);
		
		connSection.setVisible(false);
		
 		toolkit.createLabel(connSectionClient, "Provider Class");
 		custom_providerClass = toolkit.createText(connSectionClient, "");
 		custom_providerClass.setBackground(new Color(null, 229,236,253));
 		custom_providerClass.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
 	}
 
 	@Override
 	public void createParameterSectionFields() {
 		
 		parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
	   	 
    	Composite paramSectionClient = toolkit.createComposite(parameterSection);
    	paramSectionClient.setLayout(new TableWrapLayout());
    	parameterSection.setClient(paramSectionClient);
		
    	parameterSection.setVisible(false);
 		
   		custom_parameters = toolkit.createButton(paramSectionClient, "Message Store Parameters",SWT.PUSH);
 		custom_parameters.setBackground(new Color(null, 229,236,253));
 		custom_parameters.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				ConfigureMessageStoreParametersDialog paramDialog = new ConfigureMessageStoreParametersDialog(shell,messageStoreParameterList);
				paramDialog.setBlockOnOpen(true);
				paramDialog.open();
				messageStoreParameterList = paramDialog.getMessageStorePropertyList();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
 	}
 	
 	@Override
 	public boolean hasGuaranteedDelivery() {
 		return false;
 	}
 
 	@Override
 	public boolean hasParameters() {
 		return true;
 	}
 
 	@Override
 	public boolean hasConnection() {
 		return true;
 	}

	@Override
	public void hideGuaranteedDeliverySection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideParametersSection() {
		 parameterSection.setVisible(false);
		 parameterSection.setExpanded(false);
	}

	@Override
	public void hideConnectionSection() {
		connSection.setVisible(false);
		connSection.setExpanded(false);
	}

	@Override
	public void showGuaranteedDeliverySection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showParametersSection() {
		 parameterSection.setVisible(true);
		 parameterSection.setExpanded(true);
	}

	@Override
	public void showConnectionSection() {
		connSection.setVisible(true);
		connSection.setExpanded(true);
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
