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

package org.wso2.developerstudio.esb.form.editors.article.rcp.message.processors;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;


public class Sampling implements IMessageProcessor {
    public Text sampling_sequence;
    public Combo sampling_state;
    public Text sampling_interval;
    public Text sampling_concurrency;
    public Text sampling_quartzConfigFilePath;
    public Text sampling_cronExpression;
//    public Text sampling_customParameters;
    
    ScrolledForm form;
    FormToolkit toolkit;
    
    Section miscSection;
    Section parameterSection;
    
    

    public Sampling(ScrolledForm form, FormToolkit toolkit) {
    	this.form = form;
    	this.toolkit = toolkit;
    	
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
        sampling_state = new Combo(parameterSectionClient, SWT.DROP_DOWN);
        sampling_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] states = {"Active", "Deactive"};
        sampling_state.setItems(states);

        toolkit.createLabel(parameterSectionClient, "Sampling Interval");
        sampling_interval = toolkit.createText(parameterSectionClient, "");
        sampling_interval.setBackground(new Color(null, 229,236,253));
        sampling_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Sampling Concurrency");
        sampling_concurrency = toolkit.createText(parameterSectionClient, "");
        sampling_concurrency.setBackground(new Color(null, 229,236,253));
        sampling_concurrency.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Quartz Config File Path");
        sampling_quartzConfigFilePath = toolkit.createText(parameterSectionClient, "");
        sampling_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
        sampling_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Cron Expression");
        sampling_cronExpression = toolkit.createText(parameterSectionClient, "");
        sampling_cronExpression.setBackground(new Color(null, 229,236,253));
        sampling_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

//        addSeparator(form, toolkit, sectionClient);
//
//        toolkit.createLabel(sectionClient, "Custom Parameters");
//        sampling_customParameters = toolkit.createText(sectionClient, "");
//        sampling_customParameters.setBackground(new Color(null, 229,236,253));
//        sampling_customParameters.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        
        
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
