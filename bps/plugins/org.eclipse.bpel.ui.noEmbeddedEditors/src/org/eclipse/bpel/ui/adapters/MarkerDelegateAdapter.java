/*
 * Copyright (c) 2010, 2012 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.ui.adapters;

import java.util.ArrayList;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.bpel.model.impl.AssignImpl;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A UI adapter for model objects that are not activities, but may have error markers
 * created on them by the validator. The error notifications are forwared to the
 * containing parent activity. For example, an <assign> has one or more <copy>
 * elements, each of which have <from> and <to> elements, and so on.
 * 
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
 * @see https://jira.jboss.org/browse/JBIDE-7497
 * @author Bob Brodt
 * @date Nov 5, 2010
 */
public class MarkerDelegateAdapter extends AbstractStatefulAdapter implements IMarkerHolder, AdapterNotification {
	
	static IMarker [] EMPTY_MARKERS = {};
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.adapters.IMarkerHolder#getMarkers(java.lang.Object)
	 *
	 * https://jira.jboss.org/browse/JBIDE-7526
	 * We don't own any markers since we delegate to MarkerHolderAdapter
	 * TODO: do we need to get markers from parent adapter?
	 */
	public IMarker[] getMarkers (Object object) {
		
		return EMPTY_MARKERS;
	}
	
	protected boolean isMarkerEvent(Notification notification) {
		int type = notification.getEventType();
		if (type==NOTIFICATION_MARKERS_STALE || 
			type==NOTIFICATION_MARKER_ADDED ||
			type==NOTIFICATION_MARKER_DELETED) {
			return true;
		}
		return false;
	}

	
	@Override
	public void notifyChanged(Notification notification) {
		if (isMarkerEvent(notification) && target instanceof EObject) {
			EObject parent = ((EObject)target).eContainer();
			if (parent != null)
				parent.eNotify(notification);
		}
	}
}
