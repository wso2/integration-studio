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

import org.eclipse.emf.common.notify.Notification;

/**
 * A version of MultiObjectAdapter which separates notification into two phases:
 * (1) the notification(s) that are generated during a given user operation are delivered
 * one by one to the adapter, and then (2) the finish() method is called when the user
 * operation is finished.
 * 
 * This solves the problem of clients receiving notifications while the model is in an
 * unusable state--clients receive notifications immediately and can inspect them to see
 * whether the notification applies to them.  However, they can defer any updating or
 * refreshing actions until the finish() method is called, at which time model changes
 * are complete and the model is in a consistent state again.
 */
public abstract class BatchedMultiObjectAdapter extends MultiObjectAdapter implements IBatchedAdapter {

	@Override
	protected void doNotify(Notification n) {
		if (CommandStackChangeBatcher.isBatchingChanges()) {
			CommandStackChangeBatcher.registerBatchChange(this);
			super.doNotify(n);
		} else {
			super.doNotify(n);
			finish();
		}
	}	
	
	/**
	 * Subclasses must override this.
	 * @param n the notification
	 */
	
	@Override
	public abstract void notify(Notification n); 

	/**
	 * Subclasses must override this.
	 */
	public abstract void finish();
}
