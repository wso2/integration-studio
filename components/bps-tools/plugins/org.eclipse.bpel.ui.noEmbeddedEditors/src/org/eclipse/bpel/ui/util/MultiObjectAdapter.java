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
package org.eclipse.bpel.ui.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

/**
 * An adapter which automatically keeps track of the notifiers it has been added to
 * (so it may be conveniently removed).
 */
public abstract class MultiObjectAdapter implements Adapter {

	// TODO: this was a Set before, I changed it to a List to work around unexpected
	// behavior (eAdapter() lists can contain the same adapter more than once).
	// 
	
	List<Notifier> addedTo = new ArrayList<Notifier>();
	
	/**
	 * Subclasses must override this.
	 * @param n Notification
	 */
	public abstract void notify(Notification n); 
	
	/**
	 * Subclasses may override this (e.g. to add other adapters)
	 * @param target the target
	 */
	public void addedTo(Object target) { }

	/**
	 * Subclasses may override this (e.g. to remove other adapters)
	 * @param target removed from target 
	 */
	public void removedFrom(Object target) { }

	/**
	 * Subclasses may use this helper to add themselves as a listener to a target object.
	 * addToObject() only adds this adapter if it has not already been added to target.
	 *  
	 * @param target 
	 */
		
	
	public void addToObject (Notifier target) {	
		if (addedTo.contains(target)) {
			return ;
		}
		target.eAdapters().add(this);
	}
	
	
	static Notifier [] EMPTY = {};

	/**
	 * Removes this adapter from all notifiers it has been added to.
	 */

	public final void removeFromAll() {
				
		for(Notifier n : addedTo.toArray( EMPTY )) {
			n.eAdapters().remove(this);
		}
		
		if (addedTo.isEmpty() == false)  {			
			throw new IllegalStateException();
		}		
	}
	
	/* Adapter */

	// this is meant for implementation use (i.e. BatchedMultiObjectAdapter).
	// if you override in a subclass, call the super implementation.
	
	protected void doNotify(Notification n) { 
		notify(n); 
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	
	public final void notifyChanged (Notification n) {
		if (n == null)  {
			throw new IllegalStateException();
		}
		if (n.getEventType() == Notification.REMOVING_ADAPTER) {
			Object notifier = n.getNotifier();
			addedTo.remove(notifier);
			removedFrom(notifier);
		} else {
			doNotify(n);
		}
	}
	
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	
	public final boolean isAdapterForType (Object type) { 
		return false; 
	}
	
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public final Notifier getTarget() { 
		return null; 
	}
	
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	public final void setTarget(Notifier newTarget) {
		addedTo.add(newTarget);  // <--- hack
		addedTo(newTarget);
	}
}