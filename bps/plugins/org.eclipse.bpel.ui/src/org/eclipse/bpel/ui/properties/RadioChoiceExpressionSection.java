/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.expressions.IExpressionEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


/**
 * An abstract ExpressionDetails which supports the selection of one or more
 * radio buttons, and passes the IDs of the selected buttons to the expression
 * editor as context info. 
 */
public abstract class RadioChoiceExpressionSection extends ExpressionSection {

	protected Composite radioComposite;
	protected Button[] radioButtons;
	
	protected int fButtonCount ;
	protected int fCurrentButtonIndex;
	
	@Override
	protected String getExpressionType() { 
		return getButtonExprType(fCurrentButtonIndex); 
	}
	
	protected abstract String[] getButtonLabels();
	protected abstract String getButtonExprType(int buttonIndex);	
	
	protected abstract int getButtonIndexFromModel();
	
	/** 
	 * Change the input.
	 * 
	 */
	
	@Override
	protected void basicSetInput(EObject newInput) {
		
		super.basicSetInput(newInput);
		fCurrentButtonIndex = getButtonIndexFromModel();
		
		updateWidgets();
	}
	
	// TODO: call this at the proper time
	protected void calculateEnablement() {
		
		IExpressionEditor exEditor = getExpressionEditor();
		if (exEditor == null) {
			throw new IllegalStateException();
		}
		
		for (int i = 0; i < radioButtons.length; i++) {
			String btnType = getButtonExprType(i);			
			boolean enabled = fEditor.supportsExpressionType(btnType);
			radioButtons[i].setEnabled(enabled);
		}
	}
	
	/**
	 * Update the Radio button widgets according to the state of the model.
	 *
	 */
	
	protected void updateRadioButtonWidgets() {
		
		if (hasEditor() == false) {
		    radioComposite.setVisible(false);			
		} else {		
			radioComposite.setVisible(true);
    	    FlatFormData data = (FlatFormData) fEditorArea.getLayoutData();
    	    data.top = new FlatFormAttachment(radioComposite, IDetailsAreaConstants.VSPACE);
			
			calculateEnablement();
			fCurrentButtonIndex = getButtonIndexFromModel();
			if (fCurrentButtonIndex >= 0) radioButtons[fCurrentButtonIndex].setSelection(true);
			for (int i = 0; i<radioButtons.length; i++) {
				if (i != fCurrentButtonIndex) {
					radioButtons[i].setSelection(false);
				}
			}
			
		}
		
	    fParentComposite.layout(true);
	}
	
	@Override
	protected void updateWidgets() {
		super.updateWidgets();
		updateRadioButtonWidgets();
	}
	
	/**
	 * Creates the radio button widgets.
	 * <p>
	 * NB: There is a dependency on the parent class here that is not obvious. Super classes will
	 * defined getButtonLabels(), this information is used to create the radio buttons, but prior to
	 * do that create
	 * @param parent
	 */
	protected void createRadioButtonWidgets(Composite parent) {
		
		String[] labels = getButtonLabels();
		fButtonCount = labels.length;
		
		FlatFormData data;
		radioComposite = createFlatFormComposite(parent);		
		
		radioButtons = new Button[ fButtonCount ];
		
		FlatFormAttachment lastLeft = new FlatFormAttachment(0, BPELPropertySection.STANDARD_LABEL_WIDTH_LRG);
		for (int i = 0; i < fButtonCount; i++) {
			
			radioButtons[i] = fWidgetFactory.createButton(radioComposite, labels[i], SWT.RADIO);
			data = new FlatFormData();
			data.left = lastLeft;
			data.top = new FlatFormAttachment(0, 0);
			radioButtons[i].setLayoutData(data);
			lastLeft = new FlatFormAttachment(radioButtons[i], IDetailsAreaConstants.HSPACE);
			final int index = i;
			
			radioButtons[i].addSelectionListener(new SelectionListener() {
				public void widgetSelected (SelectionEvent e) {
					radioButtonSelected(index,radioButtons[index]);
				}
				public void widgetDefaultSelected(SelectionEvent e) { }
			});
			
		}
		
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(expressionLanguageViewer.getControl(), IDetailsAreaConstants.VSPACE + 2);
		radioComposite.setLayoutData(data);
	}

	protected abstract void radioButtonSelected (int index, Button button) ;

	
	@Override
	protected void createClient(Composite parent) {
		super.createClient(parent);	
		createRadioButtonWidgets(fParentComposite);
	}
	
	protected boolean showRadioButtons() { 
		return hasEditor(); 
	}

    
	/**
	 * Allow the editor in the combo if *any* of the radio buttons would be supported
	 * by that editor.  (calculateEnabled() will decide which radio buttons to actually
	 * enable for the selected editor).
	 */
	@Override
	protected boolean isEditorSupported(IExpressionEditor exEditor) {
				
		for (int i = 0; i< fButtonCount; i++) {
			
			String btnType = getButtonExprType(i);			
			
			if (exEditor.supportsExpressionType(btnType)) {
				return true;
			}
		}
		return false;
	}
}
