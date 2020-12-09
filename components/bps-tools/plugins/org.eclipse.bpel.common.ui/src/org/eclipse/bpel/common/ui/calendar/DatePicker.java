/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Creates a control that allows a user to either enter a date in a text 
 * field or use a popup calendar to select a date.  The image used in the 
 * show calendar button and the date format style used to format/parse the 
 * date are configurable.
 */
public class DatePicker extends Composite {
	
	/** Default date format style used to format date */
	private static final int DEFAULT_DATE_STYLE = DateFormat.SHORT;
	
	private int dateStyle;
	
	Text dateDisplayField;
	private Button showCalendarButton;
	
	public DatePicker(Composite parent) {	
		super(parent, SWT.NONE);
		
		dateStyle = DEFAULT_DATE_STYLE;
		
		createControls();
		hookControlListeners();
	}
	
	private void createControls() {
		GridLayout gl = new GridLayout(2, false);
		gl.horizontalSpacing = 3;
		setLayout(gl);

		dateDisplayField = new Text(this, SWT.BORDER | SWT.SINGLE);
		dateDisplayField.setText(getDateDisplayString(new Date()));
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		dateDisplayField.setLayoutData(gd);

		showCalendarButton = new Button(this, SWT.PUSH);
		showCalendarButton.setText(Messages.DatePicker_button_text); 
		gd = new GridData();
		gd.grabExcessHorizontalSpace = false;
		gd.horizontalAlignment = GridData.BEGINNING;
		showCalendarButton.setLayoutData(gd);
	}
	
	private void hookControlListeners() {
		showCalendarButton.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) {
				setDate(CalendarPopup.openCalendarPopup(dateDisplayField, getDate()));
			}
		});
	}
	
	private String getDateDisplayString(Date date) {
		if (date != null) {
			DateFormat formatter = DateFormat.getDateInstance(dateStyle);
			return formatter.format(date);	
		} else {
			return Messages.DatePicker_noDateSelected; 
		}
	}
		
	/**
	 * Returns the date format style that the date picker uses to 
	 * display its date. This value is style constant from the
	 * java.text.DateFormat class.  The default style is DateFormat.SHORT. 
	 * 
	 * @return Returns the date format style which is used to format the date.
	 */
	public int getDateStyle() {
		return dateStyle;
	}
	
	/**
	 * Sets the date format style that the picker users to display
	 * its date. This value is style constant from the 
	 * java.text.DateFormat class.
	 * 
	 * @param style The date format style to be used to format the date
	 */
	public void setDateStyle(int style) {
		dateStyle = style;
	}
	
	/**
	 * Returns the image that is displayed in the show calendar button.
	 * 
	 * @return the image that is displayed in the show calendar button.
	 */
	public Image getImage() {
		return showCalendarButton.getImage();
	}
	
	/**
	 * Sets the image that is display in the show calendar button.  If null
	 * is specified, the existing image is removed and the button text is set
	 * to "..."
	 *  
	 * @param image The image to display in the show calendar button or null
	 * 				if no image should be displayed.
	 */
	public void setImage(Image image) {
		showCalendarButton.setImage(image);
		
		if (image != null) {
			showCalendarButton.setText( "" );
		} else {
			showCalendarButton.setText(Messages.DatePicker_button_text); 
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {	
		super.dispose();
	}
	
	/**
	 * Returns the current date entered in the picker or null if no date or
	 * an invalid date is entered.
	 * 
	 * @return the date of the picker
	 */
	public Date getDate() {
		try {
			// TODO Should we possibbly attempt to parse the string with
			//		other date format styles?  That way, a user would be 
			//		able to enter a valid date that does not conform to 
			//		the format used by the control 
			DateFormat formatter = DateFormat.getDateInstance(dateStyle);
			return formatter.parse(dateDisplayField.getText());	
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * Sets the date of the picker or if null is specified, sets the selected
	 * date to "None"
	 * 
	 * @param date The new selected date for the picker
	 */
	public void setDate(Date date) {	
		dateDisplayField.setText(getDateDisplayString(date));
	}
}