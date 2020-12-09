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

import java.util.Date;

import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;


/**
 * The CalendarPopup is designed to easily allow other controls to provide
 * a calendar popup.  The CalendarPopup is responsible for displaying a calendar 
 * control popup.  
 * 
 * The control that uses this class must provide a reference control as an anchor 
 * point to determine where the popup should be displayed.
 */
public class CalendarPopup {
	
	Date date;
	CalendarControl calendar;
	Shell popupShell;
	Shell shell;
	Rectangle bounds;
	int borderWidth;
	
	private Button todayButton;
	private Button noneButton;
	
	/**
	 * 
	 * @param shell shell containing the anchor
	 * @param absoluteBounds anchor bounds relative to the display
	 * @param borderWidth anchor border width
	 * @param initialDate
	 * @return
	 */
	public static Date openCalendarPopup(Shell shell, Rectangle absoluteBounds, int borderWidth, Date initialDate) {
		return openCalendarPopup(shell, absoluteBounds, borderWidth, initialDate, null);
	}
	
	/**
	 * 
	 * @param shell shell containing the anchor
	 * @param absoluteBounds anchor bounds relative to the display
	 * @param borderWidth anchor border width
	 * @param initialDate
	 * @return
	 */
	public static Date openCalendarPopup(Shell shell, Rectangle absoluteBounds, int borderWidth, Date initialDate,
		String timezone) 
	{
		CalendarPopup popup = new CalendarPopup(shell, absoluteBounds, borderWidth, initialDate,
			timezone);
		popup.open();
		 
		Display display = shell.getDisplay();
		while (!popup.popupShell.isDisposed()) {
			if (!display.readAndDispatch()) { 
		 		display.sleep();
		 	}
		}
		
		popup.dispose();
		return popup.date;
	}
	
	public static Date openCalendarPopup(Control anchor, Date initialDate) {
	    Rectangle anchorBounds = anchor.getBounds();
	    Point absolute = anchor.toDisplay(anchorBounds.x, anchorBounds.y);
	    anchorBounds.x = absolute.x;
	    anchorBounds.y = absolute.y;
	    return openCalendarPopup(anchor.getShell(), anchorBounds, anchor.getBorderWidth(), initialDate);
	}
	
	private CalendarPopup(Shell shell, Rectangle bounds, int borderWidth, Date initialDate,
		String timezone) 
	{	
		this.shell = shell;
		this.bounds = bounds;
		this.borderWidth = borderWidth;
		this.date = initialDate;
		
		createShell();
		hookListeners();

		if (timezone != null)
			calendar.setTimeZone(timezone);
		calendar.setSelectedDate(initialDate);
	}
	
	private void createShell() {
		popupShell = new Shell(shell, SWT.ON_TOP);
		popupShell.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		GridLayout gl = new GridLayout(2, true);
		popupShell.setLayout(gl);
		
		calendar = new CalendarControl(popupShell);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		calendar.setLayoutData(gd);
		
		todayButton = new Button(popupShell, SWT.PUSH);
		todayButton.setText(Messages.CalendarPopup_todayButton_text); 
		
		noneButton = new Button(popupShell, SWT.PUSH);
		noneButton.setText(Messages.CalendarPopup_noneButton_text); 

		int width = calculateButtonWidthHint();
		
		gd = new GridData();
		gd.horizontalAlignment = GridData.END;
		gd.widthHint = width;
		todayButton.setLayoutData(gd);
		
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.widthHint = width;
		noneButton.setLayoutData(gd);
		
		popupShell.pack();
	}
	
	private void hookListeners() {
		popupShell.addListener(SWT.Deactivate,new Listener() {
			public void handleEvent(final Event e) {
				e.widget.getDisplay().asyncExec(new Runnable() {
					public void run() {
						Shell activeShell = Display.getCurrent().getActiveShell();
						if(activeShell == null || (activeShell != popupShell)) {
							selectAndClose(date);
						}
					}
				});
			}
		});
		
		popupShell.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				switch (e.keyCode) {
					case SWT.ESC:
						selectAndClose(date);
						e.doit = false;
						break;
				}
			}
		});
		
		calendar.addMouseListener(new MouseAdapter() {
			private int index = -1;
			
			@Override
			public void mouseDown(MouseEvent e) {
				index = calendar.getMatrixIndex(e.x, e.y);
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				if (index != -1 && index == calendar.getMatrixIndex(e.x, e.y)) {
					selectAndClose(calendar.getSelectedDate());
				} else {
					index = -1;
				}
			}
		});
		
		calendar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Is this Platform independent?
				if (e.keyCode == SWT.CR) {
					selectAndClose(calendar.getSelectedDate());
				}
			}
		});
	
		todayButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectAndClose(new Date());
			}
		});
		
		noneButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectAndClose(null);
			}
		});
	}
	
	private int calculateButtonWidthHint() {
		Point todaySize = todayButton.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		Point noneSize = noneButton.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		return (todaySize.x > noneSize.x) ? todaySize.x : noneSize.x;	
	}
	
	void selectAndClose(Date date) {		
		this.date = date;
		close();
	}
		
	/**
	 * Shows a popup that contains the calendar control as well as
	 * "Today" and "None" buttons.
	 * 
	 * The popup is displayed in a position that it is fully visible on the screen.  
	 * It uses the anchor control as a reference point to display the popup.
	 */
	private void open() {		
		calendar.setFocus();
		
		Monitor monitor = shell.getMonitor();
		
		Rectangle size = popupShell.getBounds();
		Rectangle monitorBounds = monitor.getBounds();
		Point location = new Point(bounds.x, bounds.y + bounds.height); 
				
		if (location.x + size.width > monitorBounds.x + monitorBounds.width) {
			location.x = monitorBounds.x + monitorBounds.width - size.width;
		} else if (location.x < monitorBounds.x) {
			location.x = monitorBounds.x;
		} else {
			location.x -= borderWidth;
		}
		
		if (location.y + size.height > monitorBounds.y + monitorBounds.height) {
			location.y = location.y - size.height - bounds.height - (borderWidth * 2);
		} else if (location.y < monitorBounds.y) {
			location.y = monitorBounds.y;
		}
		
		popupShell.setLocation(location.x, location.y);
		popupShell.open();
	}
	
	/**
	 * Hides the calendar popup from view.
	 */
	private void close() {
		if (popupShell == null || popupShell.isDisposed())
			return;
		
		popupShell.setVisible(false);
		popupShell.dispose();
	}
	
	/**
	 * Disposes of the resources used by this class.  This method must be called
	 * when the client is finished with the calendar popup.  
	 */
	private void dispose() {
		if (calendar != null) {
			calendar.dispose();
			calendar = null;
		}
		
		if (popupShell != null) {
			popupShell.dispose();
			popupShell = null;
		}
	}
}