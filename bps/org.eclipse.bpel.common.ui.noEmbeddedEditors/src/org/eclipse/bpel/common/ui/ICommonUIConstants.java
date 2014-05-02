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
package org.eclipse.bpel.common.ui;


/**
 * General constants for the common.ui plug-in.
 */
public interface ICommonUIConstants {

	// Image path
	public final String ICON_PATH = "icons/"; //$NON-NLS-1$

	//-----------------------------------------------------------------------------------

	// tray icons
	public final String ICON_TRAY_CATEGORY_ADD_BUTTON = "obj16/add_exe.gif"; //$NON-NLS-1$
	public final String ICON_TRAY_CATEGORY_REMOVE_BUTTON = "obj16/remove_exe.gif"; //$NON-NLS-1$
	public final String ICON_TRAY_EXPAND_ARROW = "obj/tray_expand.png"; //$NON-NLS-1$
	public final String ICON_KEY_TRAY_EXPAND_BUTTON = "expandTray"; //$NON-NLS-1$
	public final String ICON_KEY_TRAY_COLLAPSE_BUTTON = "collapseTray"; //$NON-NLS-1$

	//-----------------------------------------------------------------------------------
	// Message icons
	public final String ICON_SM_BLANK = "obj/sm_blank.gif"; //$NON-NLS-1$
	public final String ICON_SM_INFO = "obj/sm_info.gif"; //$NON-NLS-1$
	public final String ICON_SM_WARN = "obj/sm_warn.gif"; //$NON-NLS-1$
	public final String ICON_SM_ERROR = "obj/sm_error.gif"; //$NON-NLS-1$

	//-----------------------------------------------------------------------------------
	// image keys
	
	// marker icons
	public final String ICON_ERROR = "ovr/error.gif"; //$NON-NLS-1$
	public final String ICON_WARNING = "ovr/warning.gif"; //$NON-NLS-1$
	public final String ICON_INFO = "ovr/info.gif"; //$NON-NLS-1$
	
	// The color of the corners selection handle
	public final String COLOR_SELECTION_HANDLE_CORNER = "selectionHandlerCorner"; //$NON-NLS-1$
	
	// actions
	public final String ICON_SHOW_PROP_VIEW_D = "dlcl16/showproperties_obj.gif"; //$NON-NLS-1$
	public final String ICON_SHOW_PROP_VIEW_E = "elcl16/showproperties_obj.gif"; //$NON-NLS-1$

	public final String ICON_SHOW_PALETTE_VIEW_D = "dlcl16/palette.gif"; //$NON-NLS-1$
	public final String ICON_SHOW_PALETTE_VIEW_E = "elcl16/palette.gif"; //$NON-NLS-1$

	// tools icons
	public final String ICON_ZOOM_IN_TOOL = "elcl16/zoomin.gif"; //$NON-NLS-1$
	public final String ICON_ZOOM_OUT_TOOL = "elcl16/zoomout.gif"; //$NON-NLS-1$

	public final String ICON_ZOOM_IN_TOOL_DISABLED = "dlcl16/zoomin.gif"; //$NON-NLS-1$
	public final String ICON_ZOOM_OUT_TOOL_DISABLED = "dlcl16/zoomout.gif"; //$NON-NLS-1$
}