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
package org.eclipse.bpel.ui;

public interface IHelpContextIds {
	public static final String PREFIX = BPELUIPlugin.PLUGIN_ID + "."; //$NON-NLS-1$

	// Preferences
	public static final String PREFERENCES_PAGE = PREFIX + "preferences_page_context"; //$NON-NLS-1$
	
	// Editor
	public static final String EDITOR_CANVAS = PREFIX + "editor_canvas_context"; //$NON-NLS-1$
	public static final String EDITOR_PALETTE = PREFIX + "editor_palette_context"; //$NON-NLS-1$
	
	// Dialogs
	public static final String PROPERTY_DIALOG = PREFIX + "property_dialog_context"; //$NON-NLS-1$
	public static final String PROPERTY_ALIAS_DIALOG = PREFIX + "property_alias_dialog_context"; //$NON-NLS-1$
	
	// Tray
	public static final String TRAY_DESCRIPTION = PREFIX + "TRY010"; //$NON-NLS-1$
	
	// Property Pages
	public static final String PROPERTY_PAGE_FAULT = PREFIX + "FLT060"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_PARTNER_IMPLEMENTATION = PREFIX + "IMP030"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_EMPTY_IMPLEMENTATION = PREFIX + "IMP040"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_SCOPE_IMPLEMENTATION = PREFIX + "IMP050"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_PICK_IMPLEMENTATION = PREFIX + "IMP070"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_INVOKE_IMPLEMENTATION = PREFIX + "IMP080"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_COMPENSATE_IMPLEMENTATION = PREFIX + "IMP090"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_ONEVENT_IMPLEMENTATION = PREFIX + "IMP100"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_BPEL_IMPORTS = PREFIX + "IMT010"; //$NON-NLS-1$
	// Bugzilla 324162
	public static final String PROPERTY_PAGE_BPEL_NAMESPACE_PREFIXES = PREFIX + "NST010"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_REPEAT_ALARM = PREFIX + "RPT010"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_WAIT_DATE = PREFIX + "WAT010"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_WAIT_DURATION = PREFIX + "WAT020"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_PROCESS_DETAILS = PREFIX + "DTS010"; //$NON-NLS-1$
	public static final String PROPERTY_PAGE_VALIDATE_DETAILS = PREFIX + "DTS020"; //$NON-NLS-1$

	public static final String PROPERTY_PAGE_NAME = "TODO_1";
	public static final String PROPERTY_PAGE_WAIT = "TODO_2";

}
