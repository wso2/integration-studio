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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;


/**
 * Default implementation of marker behavior for a connection edit part. 
 * 
 */
public class LinkEditPartMarkerDecorator extends EditPartMarkerDecorator {
	
	private Connection fConnection;
	private List<IFigure> fMarkerFigures = new ArrayList<IFigure>();
	
	/**
	 * Brand new shiny LinkEditPartMarkerDecorator
	 * @param aModelObject
	 * @param aConnection
	 */
	
	public LinkEditPartMarkerDecorator(EObject aModelObject, Connection aConnection) {
		super(aModelObject);
		this.fConnection = aConnection;
	}
	
	/**
	 * May be overridden by subclasses.
	 * 
	 * @param marker 
	 * @return a layout constraint
	 */
	
	@Override
	protected Object getConstraint(IMarker marker) {
		try {
			if (marker.isSubtypeOf(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ID)) {
				String anchorString = (String)marker.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR);
				if (anchorString != null) {
					if (anchorString.equals(IMarkerConstants.MARKER_ANCHORPOINT_SOURCE)) {
						ConnectionEndpointLocator locator = new ConnectionEndpointLocator(fConnection, false);
						locator.setUDistance(4);
						locator.setVDistance(0);
						return locator;
					}
					if (anchorString.equals(IMarkerConstants.MARKER_ANCHORPOINT_TARGET)) {
						ConnectionEndpointLocator locator = new ConnectionEndpointLocator(fConnection, true);
						locator.setUDistance(4);
						locator.setVDistance(0);
						return locator;
					}
					if (anchorString.equals(IMarkerConstants.MARKER_ANCHORPOINT_CENTRE)) return new ConnectionLocator(fConnection, ConnectionLocator.MIDDLE);
				}
			}
		} catch (CoreException e) {
			// ignore this exception since the marker may no longer exist
		}

		// default
		return new ConnectionLocator(fConnection, ConnectionLocator.MIDDLE);
	}

	/**
	 * 
	 */
	public void removeAllMarkerFigures() {
		for (IFigure figure : fMarkerFigures) {
			fConnection.remove(figure);
		}
		fMarkerFigures.clear();
	}
	
	/**
	 * Add marker figure.
	 * 
	 * @param figure
	 */
	
	public void addMarkerFigure(IFigure figure){
		fMarkerFigures.add(figure);
	}
	
	/**
	 * @return Returns the conn.
	 */
	public Connection getConnection() {
		return fConnection;
	}
	
	
	/**
	 * Draws the markers. This method should be called from the EditPart's refreshVisuals()
	 * method.
	 */
	@Override
	protected void refreshMarkers() {
		//	Refresh any decorations on this edit part
		 if(getConnection() != null) {
		 	 removeAllMarkerFigures();
	
		 	 Map<Object, IMarker> constraintToMarkerMap = getMarkerMap();
			 for(Iterator iter = constraintToMarkerMap.entrySet().iterator(); iter.hasNext(); ) {
			 	Map.Entry entry = (Map.Entry) iter.next();
			 	Object constraint = entry.getKey();
			 	IMarker marker = (IMarker) entry.getValue();
			 	IFigure markerFigure = createFigureForMarker(marker);
			 	if (markerFigure != null) {
			 		addMarkerFigure(markerFigure);
			 		getConnection().add(markerFigure, constraint);
			 	}
			 }
		 }
	}
}
