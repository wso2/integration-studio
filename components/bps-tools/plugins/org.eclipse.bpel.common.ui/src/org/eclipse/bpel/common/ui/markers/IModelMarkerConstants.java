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
package org.eclipse.bpel.common.ui.markers;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.decorator.IMarkerConstants;



public interface IModelMarkerConstants {
    
    /**
     * The unique ID for the base UI marker.
     */
    public static final String DECORATION_MARKER_ID = CommonUIPlugin.PLUGIN_ID + ".uiModelMarker";	 //$NON-NLS-1$
    
    public static final String DECORATION_GRAPHICAL_MARKER_ID = CommonUIPlugin.PLUGIN_ID + ".graphicalMarker";	 //$NON-NLS-1$
    
    public static final String DECORATION_TEXT_MARKER_ID = CommonUIPlugin.PLUGIN_ID + ".textMarker";	 //$NON-NLS-1$
    
    public static final String DECORATION_JAVABREAKPOINT_MARKER_ID = CommonUIPlugin.PLUGIN_ID + ".javaLineBreakpointMarker";	 //$NON-NLS-1$
    
    /**
	 * The unique id of the model object that this marker references in the
	 * marker resource.
	 * 
	 * The value of the objectId attribute uniquely identifies the
	 * model element associated with the marker.  The scheme used by the
	 * objectId attribute is determined by the model associated with the
	 * resource on which the marker is placed.  For example, some resources
	 * may use an EMF URI fragment as the value of the objectId attribute.
	 */
	public static final String DECORATION_MARKER_OBJECTID_ATTR = DECORATION_MARKER_ID + ".objectId";	 //$NON-NLS-1$
    
    public static final String DECORATION_MARKER_PRIORITY_ATTR = DECORATION_MARKER_ID + ".priority";	 //$NON-NLS-1$
    
    public static final int DECORATION_MARKER_PRIORITY_ATTR_DEFAULT = IMarkerConstants.PRIORITY_DEFAULT; 
    
    public static final String DECORATION_MARKER_VISIBLE_ATTR = DECORATION_MARKER_ID + ".visible";	 //$NON-NLS-1$
    
    public static final String DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR = DECORATION_GRAPHICAL_MARKER_ID + ".anchorPoint";	 //$NON-NLS-1$
    
    public static final String DECORATION_TEXT_MARKER_LINE_ATTR = DECORATION_TEXT_MARKER_ID + ".lineNumInObject";	 //$NON-NLS-1$
    
    public static final String DECORATION_MARKER_ACTIVE_ATTR = DECORATION_GRAPHICAL_MARKER_ID + ".active";	 //$NON-NLS-1$
    
    public static final String DECORATION_MARKER_INSTALLED_ATTR = DECORATION_GRAPHICAL_MARKER_ID + ".installed";	 //$NON-NLS-1$
    
}
