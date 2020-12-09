/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.adapters;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 23, 2007
 *
 */
public interface AdapterNotification {
	
	/**
	 * Notification that markers are stale.
	 */
	
	int NOTIFICATION_MARKERS_STALE   = 2100;
	
	/**
	 * Notification that a marker have changed.
	 */	
	int NOTIFICATION_MARKER_CHANGED = 2101;

	/**
	 * Notification that a marker was added.
	 */	
	int NOTIFICATION_MARKER_ADDED = 2102;

	/**
	 * Notification that a marker was deleted.
	 */	

	int NOTIFICATION_MARKER_DELETED = 2103;
	
	/** 
	 * Notification group is notification id / 100
	 */
	
	int NOTIFICATION_MARKERS_CHANGED_GROUP = 21;
	
	
}
