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
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.Invoke;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;


public class CustomActivityAdapter extends ActivityAdapter {

	/* INamedElement */

	@Override
	public String getName(Object object) {
		if (!(object instanceof Invoke) && object instanceof EObject) {
			object = ((EObject)object).eContainer();
		}
		return super.getName(object);
	}

	@Override
	public void setName(Object object, String name) {
		if (!(object instanceof Invoke) && object instanceof EObject) {
			object = ((EObject)object).eContainer();
		}
		super.setName(object, name);
	}

	@Override
	public boolean isNameAffected(Object object, Notification n) {
		if (!(object instanceof Invoke) && object instanceof EObject) {
			object = ((EObject)object).eContainer();
		}
		return super.isNameAffected(object, n);
	}
}