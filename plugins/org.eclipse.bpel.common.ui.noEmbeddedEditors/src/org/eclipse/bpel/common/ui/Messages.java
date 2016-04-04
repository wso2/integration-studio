/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.bpel.common.ui.messages";//$NON-NLS-1$
	

	private Messages() {
		// Do not instantiate
	}

	public static String SynchronizationManager_deleted_title;
	public static String CompositeEditorManager_Could_not_find_editor;
	public static String ModelMarkerUtil_8;
	public static String ModelMarkerUtil_5;
	public static String ModelMarkerUtil_6;
	public static String ModelMarkerUtil_7;
	public static String SynchronizationManager_deleted_message;
	public static String CalendarPopup_todayButton_text;
	public static String EditModelCommandStack_validateEdit_message1;
	public static String EditModelCommandStack_validateEdit_message0;
	public static String EditPartMarkerEectorator_1 ;
	public static String CompositeEditor_3;
	public static String CompositeEditor_2;
	public static String DatePicker_button_text;
	public static String CompositeEditor_0;
	public static String EditModelCommandStack_validateEdit_title;
	public static String CalendarPopup_noneButton_text;
	public static String CalendarControl_title;
	public static String SynchronizationManager_refresh_title;
	public static String CompositeEditor_Cannot_disconnect_active_editor;
	public static String SynchronizationManager_refresh_message;
	public static String SynchronizationManager_saveButtonLabel;
	public static String CompositeEditorManager_5;
	public static String DatePicker_noDateSelected;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}