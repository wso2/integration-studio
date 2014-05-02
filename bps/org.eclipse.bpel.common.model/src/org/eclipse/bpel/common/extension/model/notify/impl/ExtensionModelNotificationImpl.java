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
/*
 * Created on Jan 26, 2005
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.eclipse.bpel.common.extension.model.notify.impl;

import org.eclipse.bpel.common.extension.model.notify.ExtensionModelNotification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EObject;


public class ExtensionModelNotificationImpl extends NotificationImpl implements ExtensionModelNotification {

	private EObject notifier = null;
	private int featureID;
	private Object arg1 = null;
	private Object arg2 = null;
	
	/**
	 * @param notifier - the EObject brodcasting the event
	 * @param eventType 
	 * @param feature 
	 * @param oldValue 
	 * @param newValue
	 * @param isSetChange
	 */
	public ExtensionModelNotificationImpl(EObject notifier, int eventType, int featureID, Object arg1, Object arg2){
		super(eventType,null, null);
		this.featureID = featureID;
		this.notifier = notifier;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Notification#getFeatureID(java.lang.Class)
	 */
	@Override
	public int getFeatureID(Class expectedClass) {
		return featureID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Notification#getNotifier()
	 */
	@Override
	public Object getNotifier() {
		return notifier;
	}

	public Object getArg1() {
		return arg1;
	}

	public Object getArg2() {
		return arg2;
	}

}
