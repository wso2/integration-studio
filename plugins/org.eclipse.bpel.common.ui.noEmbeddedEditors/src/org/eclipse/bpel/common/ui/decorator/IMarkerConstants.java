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
package org.eclipse.bpel.common.ui.decorator;
 
import org.eclipse.draw2d.PositionConstants;

/**
 * Useful constants for markers and for the DecorationLayout
 */
public interface IMarkerConstants {
	/**
	 * @deprecated use IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR
	 */
	@Deprecated
	public final String MARKER_ANCHORPOINT = "anchorPoint"; //$NON-NLS-1$

	// The following anchor point values should be used for the 
	// IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR
	// marker attribute
	public final String MARKER_ANCHORPOINT_TOP_CENTRE = "TOP_CENTRE"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_BOTTOM_CENTRE = "BOTTOM_CENTRE"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_LEFT = "LEFT"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_RIGHT = "RIGHT"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_CENTRE = "CENTRE"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_TOP_LEFT = "TOP_LEFT"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_TOP_RIGHT = "TOP_RIGHT"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_BOTTOM_LEFT = "BOTTOM_LEFT"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_BOTTOM_RIGHT = "BOTTOM_RIGHT"; //$NON-NLS-1$
	// Marker attributes for connections
	public final String MARKER_ANCHORPOINT_SOURCE = "SOURCE"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_TARGET = "TARGET"; //$NON-NLS-1$
	
	public static final Integer CENTER = Integer.valueOf( PositionConstants.CENTER);
	public static final Integer TOP = Integer.valueOf( PositionConstants.TOP);
	public static final Integer BOTTOM = Integer.valueOf( PositionConstants.BOTTOM);
	public static final Integer LEFT = Integer.valueOf( PositionConstants.LEFT);
	public static final Integer RIGHT = Integer.valueOf( PositionConstants.RIGHT);
	public static final Integer TOP_LEFT = Integer.valueOf( PositionConstants.TOP | PositionConstants.LEFT);
	public static final Integer TOP_RIGHT = Integer.valueOf( PositionConstants.TOP | PositionConstants.RIGHT);
	public static final Integer BOTTOM_LEFT = Integer.valueOf( PositionConstants.BOTTOM | PositionConstants.LEFT);
	public static final Integer BOTTOM_RIGHT = Integer.valueOf( PositionConstants.BOTTOM | PositionConstants.RIGHT);
	
	// The following priority values may be used for the 
	// IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR
	// marker attribute
	// Clients may define their own
	public static final int PRIORITY_CURRENT_EXECUTION_INDICATOR = 80;
	public static final int PRIORITY_STATUS_EXECUTION_INDICATOR = 70;
	public static final int PRIORITY_ERROR_INDICATOR = 60;
	public static final int PRIORITY_WARNING_INDICATOR = 50;
	public static final int PRIORITY_OCCURANCE_INDICATOR = 40;
	public static final int PRIORITY_BREAKPOINT_INDICATOR = 30;
	public static final int PRIORITY_INFO_INDICATOR = 20;
	public static final int PRIORITY_SEARCH_RESULT_INDICATOR = 10;
	public static final int PRIORITY_DEFAULT = 5;  //  priority used if marker has no priority attribute value
	public static final int PRIORITY_NONE = 0;
}
