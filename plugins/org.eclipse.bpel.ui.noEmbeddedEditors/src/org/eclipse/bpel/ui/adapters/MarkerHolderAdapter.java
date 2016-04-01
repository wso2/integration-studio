/*
 * Copyright (c) 2010, 2012 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.ui.adapters;

import java.util.ArrayList;

import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;

/**
 * This class was created out of the duplicated code in a bunch of activity adapters.
 * It manages the markers list and ensures that duplicate markers are not added to
 * the list, and that only valid markers are returned.
 *
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * @see https://jira.jboss.org/browse/JBIDE-7526
 * @author Bob Brodt
 * @date Nov 9, 2010
 */
public class MarkerHolderAdapter extends AbstractStatefulAdapter implements IMarkerHolder, AdapterNotification {

	private class UniqueMarkers extends ArrayList<IMarker> {

		// prevent duplicate marker IDs from being added to the list
		@Override
		public boolean add(IMarker e) {
			for (int i=0; i<size(); ++i) {
				IMarker m = get(i);
				if (m.getId() == e.getId())
					return false;
			}
			return super.add(e);
		}
		
	}
	
	/**
	 * @see org.eclipse.bpel.model.adapters.AbstractAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {		
		super.notifyChanged(notification);
		switch (notification.getEventType()) {
			case NOTIFICATION_MARKERS_STALE : 
				fMarkers.clear();
				break;
			case NOTIFICATION_MARKER_ADDED :
				fMarkers.add ( (IMarker) notification.getNewValue() );
				break;
			case NOTIFICATION_MARKER_DELETED :
				fMarkers.remove ( notification.getOldValue() );
				break;								
		}				
	}
	
	UniqueMarkers fMarkers = new UniqueMarkers();

	static IMarker [] EMPTY_MARKERS = {};
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.IMarkerHolder#getMarkers(java.lang.Object)
	 */
	public IMarker[] getMarkers (Object object) {
		
		if (fMarkers.size() == 0) {
			return EMPTY_MARKERS;
		}
		
		UniqueMarkers removed = new UniqueMarkers();
		for (IMarker m : fMarkers) {
			if (!m.exists())
				removed.add(m);
		}
		
		fMarkers.removeAll(removed);

		return fMarkers.toArray( EMPTY_MARKERS );						
	}
}
