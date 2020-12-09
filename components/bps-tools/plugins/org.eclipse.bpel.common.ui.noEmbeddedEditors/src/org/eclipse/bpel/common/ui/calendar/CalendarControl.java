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

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;


/**
 * Creates a control that allows the user to select a date from a visual 
 * calendar control.  The control displays a month in a given year as well as
 * a list of days for that month.  Users can select a date by clicking on a day
 * or navigating around the calendar with the arrow keys.
 * 
 * The text graphic below outlines the key features of the calendar control.
 * 
 * <pre>
 *  |-----------------------|
 *  | <|    Month Year   |> |
 *  |-----------------------|
 *  |  S  M  T  W  T  F  S  |
 *  | |------------------|  |
 *  | |                  |  |
 *  | |                  |  |
 *  | |       Days       |  |
 *  | |                  |  |
 *  | |                  |  |
 *  | |------------------|  |
 *  |-----------------------|
 * </pre>
 *
 * These features include:
 *  <ul>
 *		<li> arrow buttons to move to the previous/next month
 *		<li> a title showing the month and year that is displayed in the calendar
 *		<li> a list of the names of each day of the week
 *		<li> a day matrix allowing the user to select days in the current month
 *			 or the last/first days of the next/previous month.
 *	</ul>
 *
 * The length of the day names can be set to a long name (3 characters long) or a 
 * short name (1 character long).  The setLongDayNames provides this functionality.
 */
public class CalendarControl extends Canvas {
	/** The dayMargin size when long day names are used */
	private static final int LONG_DAY_MARGIN = 1;
	
	/** The dayMargin size when short day names are used */
	private static final int SHORT_DAY_MARGIN = 5;

	/** The default number of rows to display in the calendar*/
	private static final int ROW_COUNT = 6;
	
	/** The number of pixels off the edge of the title the next/previous 
	 * arrows will be drawn*/
	private static final int ARROW_OFFSET = 5;
	
	/** The number of pixels between rows in the day matrix */
	private static final int ROW_SPACING = 5;
	
	/** The width of the line separating each column in the day matrix */
	private static final int LINE_WIDTH = 1;
	
	/** The margin size around the days of the week */
	private static final int DAY_MARGIN = 3;	
	
	/** The margin size around the month name*/
	private static final int MONTH_MARGIN = 4;
		
	Calendar calendar = Calendar.getInstance();
	
	private ArrayList<SelectionListener> selectionListeners = new ArrayList<SelectionListener>();
	private CalendarPainter painter;
	private CalendarMouseAdapter mouseListener;
		
	int cellWidth;
	int cellHeight;
	int titleHeight;
	int width;
	int height;
	int lineStart;
	int lineEnd;
	int dayOfMonthMin;
	int dayOfMonthMax; 
	int dayOfWeekMax;
	int startDayOfWeek; 
	int lastDayOfPreviousMonth;
	int[] previousMonth;
	int[] nextMonth;
	
	String title;
	String[] days;
	private String[] months;

	/** The width used to separate day names */
	private int dayMargin;

	/** The selected day of the month */
	int day;
	
	public CalendarControl(Composite parent) {
		super(parent, SWT.NO_BACKGROUND);

		initializeControlContents();
		hookControlListener();
				
		updateVisuals();
	}
	
	public void setTimeZone(String tz) {
		calendar.setTimeZone(TimeZone.getTimeZone(tz));
	}
	
	private void initializeControlContents() {		
		dayOfWeekMax = calendar.getActualMaximum(Calendar.DAY_OF_WEEK);
		
		DateFormatSymbols symbols = new DateFormatSymbols();
		months = symbols.getMonths();
		setLongDayNames(true);
	
		GC gc = new GC(this);
		Point dayMax = findMaximumSize(gc, days);
		Point monthMax = findMaximumSize(gc, months);
		gc.dispose();
		
		cellWidth = dayMax.x + (dayMargin * 2) + LINE_WIDTH;
		cellHeight = dayMax.y + ROW_SPACING;
		
		titleHeight = monthMax.y + (MONTH_MARGIN * 2);
		
		width = dayOfWeekMax * cellWidth;
		
		height = (MONTH_MARGIN * 2) + monthMax.y
			+ (DAY_MARGIN * 2) + dayMax.y
			+ ROW_COUNT * (dayMax.y + ROW_SPACING);
		
		lineStart = titleHeight + dayMax.y + (DAY_MARGIN * 2);
		lineEnd = lineStart + ((dayMax.y + ROW_SPACING) * 6);
		
		// Calculate the length of the lines that make up
		// the triangle button.
		int lineLength = titleHeight - (ARROW_OFFSET * 2); 
		
		// Calculate points of previous button polygon
		previousMonth = new int[6];
		previousMonth[0] = ARROW_OFFSET;
		previousMonth[1] = titleHeight / 2;
		previousMonth[2] = ARROW_OFFSET + (lineLength / 2);
		previousMonth[3] = ARROW_OFFSET;
		previousMonth[4] = ARROW_OFFSET + (lineLength / 2);
		previousMonth[5] = ARROW_OFFSET + lineLength;
		
		// Calculate points of next button polygon
		nextMonth = new int[6];
		nextMonth[0] = width - ARROW_OFFSET;
		nextMonth[1] = titleHeight / 2;
		nextMonth[2] = width - ARROW_OFFSET - (lineLength / 2);
		nextMonth[3] = ARROW_OFFSET;
		nextMonth[4] = width - ARROW_OFFSET - (lineLength / 2);
		nextMonth[5] = ARROW_OFFSET + lineLength;
	}
	
	private void hookControlListener() {
		addKeyListener(new CalendarKeyAdapter());
		
		mouseListener = new CalendarMouseAdapter();
		addMouseListener(mouseListener);
		
		painter = new CalendarPainter(getDisplay());
		addPaintListener(painter);
	}

	private Point findMaximumSize(GC gc, String[] displayStrings) {
		Point max = new Point(0, 0);
		for (int i = 0; i < displayStrings.length; i++) {
			Point size = gc.stringExtent(displayStrings[i]);			
			if (size.x > max.x) {
				max.x = size.x;
			}
			if (size.y > max.y) {
				max.y = size.y;
			}
		}
		return max;
	}
	
	int getMatrixIndex(int x, int y) {
		if (lineStart <= y && lineEnd >= y && x >= 0 && x <= width) {
			int row = (y - lineStart) / cellHeight;
			int col = x / cellWidth;
			
			return (row * dayOfWeekMax) + col + 1;	
		}
		return -1;
	}
	
	void changeMonth(boolean next) {
		if (day > dayOfMonthMax) {
			day = dayOfMonthMax;
		} else if (day < dayOfMonthMin) {
			day = dayOfMonthMin;
		}
		
		if (next) {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		} else {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		}
		updateVisuals();
	}
		
	void updateVisuals() {		
		// Set calendar to first day of month so no wrapping occurs
		// whem the month is set
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonthMin);
		
		// Find first and last days of month
		dayOfMonthMin = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		dayOfMonthMax = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// Find the day which the first of the month falls on
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonthMin);
		startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		// Find the last day of the previous month
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		lastDayOfPreviousMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
						
		// Reset the day of the month.  If the day is greater
		// than the last day in the month (i.e. current day is 31
		// and switched to a month with 30 days), set day to the
		// last day of the month.
		if (day > dayOfMonthMax) {
			day = dayOfMonthMax;
		}

		// Cache new title and title width
		title = NLS.bind(Messages.CalendarControl_title, (new Object[] { months[calendar.get(Calendar.MONTH)], String.valueOf(calendar.get(Calendar.YEAR)) })); 
		
		// Redraw the calendar
		CalendarControl.this.redraw();
	}
	
	void fireSelectionChanged() {
		Event e = new Event();
		e.widget = this;
		e.data = getSelectedDate();
		
		for (int i = 0; i < selectionListeners.size(); i++) {
			SelectionListener listener = selectionListeners.get(i);
			SelectionEvent se = new SelectionEvent(e);
			listener.widgetSelected(se);
			
			if (!se.doit) break;
		}
	}
	
	/**
	 * Adds the listener to the collection of listeners who will be notified when the 
	 * receiver's selection changes, by sending it one of the messages defined in the 
	 * SelectionListener interface.
	 * 
	 * @param listener the listener which should be notified 
	 */
	public void addSelectionListener(SelectionListener listener) {
		if (listener != null && !selectionListeners.contains(listener)) {
			selectionListeners.add(listener);
		}
	}
	
	/**
	 * Removes the listener from the collection of listeners who will be notified when
	 * the receiver's selection changes. 
	 * 
	 * @param listener the listener which should no longer be notified 
	 */
	public void removeSelectionListener(SelectionListener listener) {
		if (listener != null) {
			selectionListeners.remove(listener);
		}
	}
	
	/**
	 * Returns the date selected in the calendar control.
	 * 
	 * @return the date selected in the calendar control.
	 */
	public Date getSelectedDate() {
		calendar.set(Calendar.DAY_OF_MONTH, day);
		Date date = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonthMin);
		
		return date;
	}
	
	/**
	 * Sets the date that is selected in the calendar control. If the date is null
	 * the current date will be used as the selected date.
	 * 
	 * @param the new selected date for the calendar.
	 */
	public void setSelectedDate(Date selectedDate) {
		if (selectedDate == null) {
			selectedDate = new Date();
		}
		calendar.setTime(selectedDate);
		
		day = calendar.get(Calendar.DAY_OF_MONTH);
		
		updateVisuals();
	}
	
	/**
	 * Determines whether the calendar is set to use short or long 
	 * day names.
	 * 
	 * A short day name is the first character of a day name.  For example,
	 * the short day name for Saturday would be S. Long day names are a compressed 
	 * form of the full day name. For example, the long day name for Saturday would
	 * be Sat.
	 * 
	 * @return Returns true if the calendar is displaying long names or false if it
	 * 		   is displaying short names.
	 */
	public boolean isLongDayNames() {
		return dayMargin == LONG_DAY_MARGIN;
	}
	
	/**
	 * Configures the calendar to use either short or long day names.
	 * 
	 * @param useLongDayNames If useLongDayNames is true, the calendar will display
	 * 						  long day names, else it will display short day names.
	 */
	public void setLongDayNames(boolean useLongDayNames) {
		DateFormatSymbols symbols = new DateFormatSymbols();
		days = symbols.getShortWeekdays();
		
		if (useLongDayNames) {
			dayMargin = LONG_DAY_MARGIN;
		} else {
			dayMargin = SHORT_DAY_MARGIN;
			
			for (int i = 0; i < days.length; i++) {
				if (days[i].length() != 0) {
					days[i] = days[i].substring(0, 1);	
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {	
		painter.dispose();
		mouseListener.dispose();
		
		super.dispose();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#computeSize(int, int, boolean)
	 */
	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		return new Point(width, height);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#computeSize(int, int)
	 */
	@Override
	public Point computeSize(int wHint, int hHint) {
		return new Point(width, height);
	}
	

	/**
	 * Responsible for handling all keyboard events of the calendar. The following
	 * are a list of commands the key adapter listens for and their associated actions.
	 * 
	 * <ul>
	 * 	<li>Shift+Left - Change the calendar month to the previous month.
	 *  <li>Shift+Right - Change the calendar month to the next month.
	 *  <li>Up/Down - Move the day selection in the calendar up or down.
	 *  <li>Left/Right - Move the day selection in the calendar left or right.
	 * </ul>
	 * 
	 * If the new day that is selected is in the next/previous month, the calendar will
	 * change its display to show that month.
	 */
	private class CalendarKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int dayChange = 0;
			int monthChange = 0;
			
			switch (e.keyCode) {
				case SWT.ARROW_UP:
					if (day - dayOfWeekMax >= dayOfMonthMin) {
						dayChange -= dayOfWeekMax;
					} else {
						calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
						int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); 
						calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
						
						day = (day - dayOfWeekMax) + lastDay;

						monthChange = -1;
					}
					break;
				case SWT.ARROW_DOWN:
					if (day + dayOfWeekMax <= dayOfMonthMax) {
						dayChange += dayOfWeekMax;
					} else {
						day = (day + dayOfWeekMax) - dayOfMonthMax;
						monthChange = 1;
					}
					break;
				case SWT.ARROW_LEFT:
					if ((e.stateMask & SWT.SHIFT) != 0) {
						changeMonth(false);
					} else {
						if (day != dayOfMonthMin) {
							dayChange--;
						} else {
							calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
							day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); 
							calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
							
							monthChange = -1;
						}
					}
					break;
				case SWT.ARROW_RIGHT:
					if ((e.stateMask & SWT.SHIFT) != 0) {
						changeMonth(true);
					} else {
						if (day != dayOfMonthMax) {
							dayChange++;
						} else {
							day = dayOfMonthMin;
							monthChange = 1;
						}	
					}
					break;
			}
			
			if (dayChange != 0) {
				day += dayChange;
				CalendarControl.this.redraw();
			}
			
			if (monthChange != 0) {
				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + monthChange);
				updateVisuals();
			}
			
			if (dayChange != 0 || monthChange != 0) {
				fireSelectionChanged();
			}
		}
	}
	
	/**
	 * Responsible for handling all mouse events of the calendar.  The mouse adapter 
	 * implements the following behaviour:
	 * 
	 * <ul>
	 * 	<li>On mouse down on the left/right arrows in the title, the month displayed
	 * 		on the calendar will shift to the previous/next month.
	 * 	<li>On mouse down on a day, the day that is clicked is selected.
	 * </ul>  
	 * 
	 * Note: dispose must be called on this object to release operating system 
	 * 		 resources.
	 */
	private class CalendarMouseAdapter extends MouseAdapter {
		private Region previousRegion;
		private Region nextRegion;
		
		public CalendarMouseAdapter() {
			previousRegion = new Region();
			previousRegion.add(previousMonth);
			
			nextRegion = new Region();
			nextRegion.add(nextMonth);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
		 */
		@Override
		public void mouseDown(MouseEvent e) {
			boolean selectionChanged = false;
			
			if (e.y > lineStart && e.y < lineEnd) {
				int offset = (startDayOfWeek == calendar.getFirstDayOfWeek()) ? dayOfWeekMax : 0;
				
				int selectedDay = getMatrixIndex(e.x, e.y) - startDayOfWeek + 1 - offset;
				if (selectedDay > dayOfMonthMax) {
					day = selectedDay - dayOfMonthMax;
					changeMonth(true);
				} else if (selectedDay < dayOfMonthMin) {
					calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
					day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + selectedDay;
					calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
					changeMonth(false);
				} else {
					day = selectedDay;
				}
				
				selectionChanged = true;
				CalendarControl.this.redraw();
			} else if (nextRegion.contains(e.x, e.y)) {
				calendar.set(Calendar.MONTH,
						calendar.get(Calendar.MONTH) + 1);
				updateVisuals();
				selectionChanged = true;
			} else if (previousRegion.contains(e.x, e.y)) {
				calendar.set(Calendar.MONTH, 
						calendar.get(Calendar.MONTH) - 1);
				updateVisuals();
				selectionChanged = true;
			}
			
			if (selectionChanged) {
				fireSelectionChanged();
			}
		}
		
		public void dispose() {
			if (previousRegion != null) {
				previousRegion.dispose();
				previousRegion = null;
			}
			
			if (nextRegion != null) {
				nextRegion.dispose();
				nextRegion = null;
			}
		}
	}
	
	/**
	 * The paint listener for the control.  It is responsible for drawing the 
	 * calendar control on the canvas.  It is also responsible for creating and
	 * disposing of the resources (i.e. colours, fonts, images) that are required
	 * for drawing the control.
	 * 
	 * Note: dispose must be called on this object to release operating system 
	 * 		 resources.
	 */
	private class CalendarPainter implements PaintListener {

		private int currentDay;
		private int currentMonth;
		private int currentYear;
		
		private Color background;
		private Color foreground;
		private Color titleBackground;
		private Color titleForeground;
		private Color lineForeground;
		private Color disabledForeground;
		private Font currentDayFont;
		private Image buffer;
				
		public CalendarPainter(Display display) {
			currentDay = calendar.get(Calendar.DAY_OF_MONTH);
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
			
			foreground = display.getSystemColor(SWT.COLOR_LIST_FOREGROUND);
			background = display.getSystemColor(SWT.COLOR_LIST_BACKGROUND);
			titleBackground = display.getSystemColor(SWT.COLOR_LIST_SELECTION);
			titleForeground = display.getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT);
			
			// FIXME The SWT.COLOR_GRAY should be replaced with the disabled color for text.
			//		 Bug 72207 requests this color constant (https://bugs.eclipse.org/bugs/show_bug.cgi?id=72207)
			lineForeground = display.getSystemColor(SWT.COLOR_GRAY);
			disabledForeground = display.getSystemColor(SWT.COLOR_GRAY);
			currentDayFont = createBoldFont(getFont());
			
			buffer = new Image(display, width, height);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
		 */
		public void paintControl(PaintEvent e) {
			GC gc = new GC(buffer);
			gc.setBackground(background);
			gc.setForeground(foreground);
			gc.fillRectangle(0, 0, width, height);
			
			drawMonthName(gc);
			drawDayNames(gc);
			
			int predayCount = (startDayOfWeek == calendar.getFirstDayOfWeek()) ? dayOfWeekMax : startDayOfWeek - 1;
			
			drawDayRange(gc, 0, lastDayOfPreviousMonth - predayCount + 1, predayCount, true);				
			drawDayRange(gc, predayCount, dayOfMonthMin, dayOfMonthMax, false);
			drawDayRange(gc, dayOfMonthMax + predayCount, 1, (ROW_COUNT * dayOfWeekMax) - predayCount - dayOfMonthMax, true);
			
			drawDayLines(gc);
			
			e.gc.drawImage(buffer, 0, 0);
			gc.dispose();
		}
		
		public void dispose() {
			if (currentDayFont != null) {
				currentDayFont.dispose();
				currentDayFont = null;
			}
			
			if (buffer != null) {
				buffer.dispose();
				buffer = null;
			}
		}
		
		private void drawMonthName(GC gc) {
			Color gcBackground = gc.getBackground();
			Color gcForeground = gc.getForeground();

			// Draw title rectangle and month name
			gc.setBackground(titleBackground);
			gc.setForeground(titleForeground);		
			gc.fillRectangle(0, 0, width, titleHeight);
			gc.drawString(title, (width - gc.stringExtent(title).x) / 2, MONTH_MARGIN);
			gc.setBackground(gcBackground);
			gc.setForeground(gcForeground);

			// Draw next/previous month arrows
			gc.fillPolygon(previousMonth);
			gc.fillPolygon(nextMonth);
		}
		
		private void drawDayNames(GC gc) {
			int x = 0;
			int y = titleHeight + DAY_MARGIN;

			int i = calendar.getFirstDayOfWeek();
			do {
				if (days[i] != null && days[i].length() != 0) {
					Point size = gc.stringExtent(days[i]);
					
					gc.drawString(days[i], ((cellWidth - size.x) / 2) + 1 + x, y);
					x += cellWidth;
				}
				i = (i + 1) % days.length;
			} while (i != calendar.getFirstDayOfWeek());
		}
		
		private void drawDayRange(GC gc, int index, int startDay, int length, boolean disabled) {
			int x = (index % dayOfWeekMax) * cellWidth;
			int y = (index / dayOfWeekMax) * cellHeight + lineStart;
			int dayOfWeek = (index % dayOfWeekMax) + 1;
			
			Color gcBackground = gc.getBackground();
			Color gcForeground = gc.getForeground();
			Font gcFont = gc.getFont();
					
			if (disabled) {
				gc.setForeground(disabledForeground);
			}
			
			for (int i = startDay; i < startDay + length; i++) {
				String displayString = String.valueOf(i);
				
				if (!disabled && i == day) {
					gc.setBackground(titleBackground);
					gc.setForeground(titleForeground);
				}
				if (!disabled && currentDay == i && currentMonth == calendar.get(Calendar.MONTH) && currentYear == calendar.get(Calendar.YEAR)) {
					gc.setFont(currentDayFont);
				}
				
				Point size = gc.stringExtent(displayString);			
				gc.drawString(displayString, ((cellWidth - size.x) / 2) + 1 + x, y);

				if (!disabled && i == day) {
					gc.setBackground(gcBackground);
					gc.setForeground(gcForeground);
				}
				if (!disabled && currentDay == i && currentMonth == calendar.get(Calendar.MONTH) && currentYear == calendar.get(Calendar.YEAR)) {
					gc.setFont(gcFont);
				}
				
				if (dayOfWeek % dayOfWeekMax == 0 && i != dayOfMonthMax) {
					y += cellHeight;
					x = 0;
				} else {
					x += cellWidth;
				}
				dayOfWeek = (dayOfWeek + 1) % dayOfWeekMax;
			}
			
			if (disabled) {
				gc.setForeground(gcForeground);	
			}
		}
		
		private void drawDayLines(GC gc) {
			int x = cellWidth;
			Color gcForeground = gc.getForeground();
			
			gc.setForeground(lineForeground);
			for (int i = 1; i < dayOfWeekMax; i++) {
				gc.drawLine(x, lineStart, x, lineEnd);
				x += cellWidth;
			}
			gc.setForeground(gcForeground);
		}
		
		private Font createBoldFont(Font font) {
			FontData[] data = font.getFontData();
			for (int i = 0; i < data.length; i++) {
				data[i].setStyle(data[i].getStyle() | SWT.BOLD);
			}
			return new Font(Display.getCurrent(), data);
		}
	}
}