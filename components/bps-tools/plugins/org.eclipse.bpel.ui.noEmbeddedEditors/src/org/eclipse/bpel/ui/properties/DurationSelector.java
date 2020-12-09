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
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.ui.forms.widgets.FormToolkit;



/**
 * Collection of widgets for specifying a duration.
 * 
 * TODO: rewrite this to be independent of serialization format.  Move that code elsewhere.
 */
public class DurationSelector extends Composite {

	/** The id of the text widget (property) */
	static final String ID    = "id";  //$NON-NLS-1$
	
	/** The text of the widget, tracked in focus listener */
	static final String TEXT  = "text"; //$NON-NLS-1$
	
	
	protected Composite topComposite;
	protected Composite[] composite;
	protected Label[] label;
	protected Text[] text;

	protected Object lastWidgetChanged;

	protected static final int YEAR=0, MONTH=1, DAY=2, HOUR=3, MINUTE=4, SECOND=5; 
	protected static final String[] labelStrings = {
		Messages.DurationSelector_Years_1, Messages.DurationSelector_Months_1, Messages.DurationSelector_Days_2, Messages.DurationSelector_Hours_3, Messages.DurationSelector_Minutes_4, Messages.DurationSelector_Seconds_5
	};
	
//	private Label timeSep, timeSep2;
//	
//	protected String dateSepText = "/";
//	protected String timeSepText = ":";
	
	private FormToolkit wf;

	public DurationSelector(FormToolkit toolkit, Composite parent, int style) {
		super(parent, style);
		this.wf = toolkit;
		setLayout(new FillLayout());
		createControls(this);
	}
	
	private void createControls(Composite parent){
		FlatFormData data;

		topComposite = wf.createComposite(parent);
		GridLayout gridLayout = new GridLayout(3, true);
		gridLayout.marginWidth = gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = IDetailsAreaConstants.VSPACE;
		gridLayout.horizontalSpacing = IDetailsAreaConstants.HSPACE;
		topComposite.setLayout(gridLayout);

		composite = new Composite[6];
		text = new Text[6];
		label = new Label[6];

		for (int i = 0; i<6; i++) {
			composite[i] = wf.createComposite(topComposite);
			composite[i].setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			FlatFormLayout formLayout = new FlatFormLayout();
			formLayout.marginWidth = formLayout.marginHeight = 0;
			composite[i].setLayout(formLayout);
			
			// Accessibility: create each Label right before the corresponding Text.
			label[i] = wf.createLabel(composite[i], labelStrings[i], SWT.CENTER);
			text[i] = wf.createText(composite[i], "0"); //$NON-NLS-1$
			text[i].setData(ID, Integer.valueOf( i ));
			
			data = new FlatFormData();
			data.left = new FlatFormAttachment(0,0);
			data.right = new FlatFormAttachment(100,0);
			data.top = new FlatFormAttachment(0,0); 
			label[i].setLayoutData(data);

			data = new FlatFormData();
			data.left = new FlatFormAttachment(0,0);
			data.right = new FlatFormAttachment(100,0);
			data.top = new FlatFormAttachment(label[i], IDetailsAreaConstants.VSPACE);
			text[i].setLayoutData(data);
		}

//		timeSep  = wf.createLabel(composite, timeSepText, SWT.CENTER);
//		timeSep2 = wf.createLabel(composite, timeSepText, SWT.CENTER);
		
		addListeners();
		layout(true);
	}
	
	private void addListeners() {
		// TODO: if we use text widgets, we need to support committers.
		// when spinners are implemented we might still need to support committers..
		
		/**
		 * We use a focus listener to track modifications in the widgets. Only when one
		 * of the text widgets is truly modified we fire up a change event to whoever 
		 * is listening on us. 
		 */
		
		FocusListener focusListener = new FocusListener() {
			
			public void focusGained(FocusEvent e) {
				Text w = (Text) e.widget;				
				w.setData(TEXT,w.getText().trim());
			}

			public void focusLost(FocusEvent e) {
				
				Text w = (Text) e.widget;
				String cv = w.getText();
				String ct = cv.trim();
				String ov = (String) w.getData(TEXT);
				
				if (isValidValue (ct, (Integer) w.getData(ID) ) == false) {
					w.setText(ov);
					return ;
				}
				
				
				// ignore any spaces around the text
				if (ct.equals ( cv ) == false ) {
					w.setText(ct);
				}
				
				// if the trimmed value is different from the original one, then we
				// do have a change.
				
				if (ct.equals(ov) == false) {
					lastWidgetChanged = w.getData( ID );
					selectionChanged();
				}				
			}			
		};
		
		for (int i = 0; i<6; i++)  {			
			text[i].addFocusListener(focusListener);
		}
	}
	
	/**
	 * Determines if the value entered is valid for this type of field. 
	 * 
	 * @param value the value as string.
	 * @param type the type 
	 * @return true/false
	 */
	
	boolean isValidValue ( String value, Integer type ) {
		int n = numberValue(value);
		
		if (n < 0) {
			return false;
		}
		
		switch ( type.intValue()) {
		case YEAR :
			return  n < 999;
		case MONTH :
			return n < 12;
		case DAY : 
			return n < 31;
		case HOUR : 
			return n < 24;
		case MINUTE :
		case SECOND :
			return n < 59 ;
		default : 
			return false;
		}
		
	}
	
	protected int numberValue(String s)  {
		int result = 0;
		try {
			result = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			// do nothing
		}
		return result;
	}

	/**
	 * Return the values as a 6 element string.
	 * @return the values present in this "editor"
	 */
	
	public int[] getValues() {
		int[] result = new int[6];
		for (int i = 0; i<6; i++) {
			result[i] = numberValue(text[i].getText());
		}
		return result;
	}
	
	
	/**
	 *  Sets the values of the duration in the editor.
	 *  
	 * @param duration
	 * @return true on success 
	 */
	public boolean setValues(int[] duration) {
		
		for (int i = 0; i<6; i++)  {
			text[i].setText(String.valueOf(duration[i]));
		}
		return true;
	}
	
	void selectionChanged() {
		Event e = new Event();
		e.type = SWT.Selection;
		e.widget = this;
		e.widget.notifyListeners(e.type, e);
	}
	
	/**
	 * @param listener
	 */
	public void addSelectionListener (SelectionListener listener ) {
		
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Selection,typedListener);
	}

	/**
	 * Return the user context for this editor. This will help restore the editor
	 * to the previous state when activated again.
	 * 
	 * @return the user context 
	 */
	
	public Object getUserContext() {
		return lastWidgetChanged;
	}
	
	
	/**
	 * Restore the user context, restore editor to the last state.
	 * @param userContext
	 */
	public void restoreUserContext(Object userContext) {
		
		int i = ((Integer)userContext).intValue();
		
		if (i >= 0) {
			text[i].setFocus();
		}
	}

	
	/** 
	 * Enable this editor.
	 * 
	 * @see org.eclipse.swt.widgets.Control#setEnabled(boolean)
	 */
	
	@Override
	public void setEnabled(boolean enabled) {
		
		super.setEnabled(enabled);
		for (int i = 0; i < text.length; i++) {
			text[i].setEnabled(enabled);
		}
	}
}
