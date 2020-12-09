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
package org.eclipse.bpel.ui.util.marker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.common.ui.decorator.EditPartMarkerDecorator;
import org.eclipse.bpel.common.ui.decorator.IMarkerConstants;
import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.util.BPELDecorationLayout;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.Layer;
import org.eclipse.emf.ecore.EObject;


/**
 * 
 * @author IBM
 * @date May 23, 2007
 *
 */
public class BPELEditPartMarkerDecorator extends EditPartMarkerDecorator {
	
	protected List<MarkerMotionListener> listeners = new ArrayList<MarkerMotionListener>();
	
	/**
	 * Marker Motion Listener.
	 * @author IBM
	 * @date May 23, 2007
	 */
	
	public interface MarkerMotionListener {
		/**
		 * Marker has been entered ...
		 * @param marker
		 */
		
		public void markerEntered(IMarker marker);
	}
	
	/**
	 * Brand new shiny BPELEditPartMarkerDecorator ...
	 * 
	 * @param aModelObject the model object
	 * @param decorationLayout 
	 */
	public BPELEditPartMarkerDecorator (EObject aModelObject, BPELDecorationLayout decorationLayout) {
		
		super(aModelObject, null, decorationLayout);
		
		decorationLayout.addAnchorMotionListener(new BPELDecorationLayout.AnchorMotionListener() {
			
			public void anchorEntered(int position) {
				// Look up the marker for the anchor and fire the listeners
				for(IMarker marker : getMarkers()) {
					Object constraint = getConstraint(marker);
					if (constraint instanceof Integer) {
						int value = ((Integer)constraint).intValue();
						if (value == position) {
							fireMarkerMotionListeners(marker);
							return;
						}
					}
				}
			}
		});
	}
	
	
	@Override
	protected IMarker[] getMarkers () {
		
		IMarkerHolder holder = BPELUtil.adapt(modelObject, IMarkerHolder.class);
		
		if (holder != null) {
			return holder.getMarkers(modelObject);
		}
		
		return super.getMarkers();
	}
	
	/**
	 * Add marker motion listener.
	 * 
	 * @param listener
	 */
	
	public void addMarkerMotionListener(MarkerMotionListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Remove marker motion listener.
	 * @param listener
	 */
	
	public void removeMarkerMotionListener(MarkerMotionListener listener) {
		listeners.remove(listener);
	}
	
	protected void fireMarkerMotionListeners(IMarker marker) {
		for(MarkerMotionListener listener : listeners) {
			listener.markerEntered(marker);
		}
	}
	
	/**
	 * Return the decoration layer.
	 * 
	 * @return return the decoration layer.
	 */
	
	public Layer getDecorationLayer() {
		if(decorationLayer == null) {
			decorationLayer = new Layer();
		}
		return decorationLayer;
	}

	
	@Override
	protected boolean isAcceptable (IMarker marker) {
		boolean isVisible = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, true);
		if (!isVisible) {
			return false;
		}
		
		// If the marker isn't for this decorator, skip it.
		String anchorString = marker.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR, ""); //$NON-NLS-1$
		if (anchorString.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_BOTTOM)
				|| anchorString.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_TOP)) {
			return false;
		}
		
		return super.isAcceptable(marker);
	}
	
	
	@Override
	protected Object getConstraint(IMarker marker) {
		try {
			// problem markers are always placed in the top left
			if (marker.isSubtypeOf(IMarker.PROBLEM)) {
				return IMarkerConstants.BOTTOM_LEFT;
			}
		} catch (CoreException e) {
			BPELUIPlugin.log(e);
		}
		return super.getConstraint(marker);
	}
	
	
	@Override
	protected Object convertAnchorKeyToConstraint(String key) {
		if (key.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_TOP)) {
			return Integer.valueOf( 64 );
		}
		if (key.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_BOTTOM)) {
			return Integer.valueOf( 128 );
		}
		return super.convertAnchorKeyToConstraint(key);
	}
}