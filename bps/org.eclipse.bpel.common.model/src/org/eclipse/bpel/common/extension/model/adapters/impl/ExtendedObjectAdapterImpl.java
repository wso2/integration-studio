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
package org.eclipse.bpel.common.extension.model.adapters.impl;

import org.eclipse.bpel.common.extension.model.Extension;
import org.eclipse.bpel.common.extension.model.adapters.ExtendedObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * @custom
 */
public class ExtendedObjectAdapterImpl extends AdapterImpl implements ExtendedObjectAdapter {
	
	private Extension extension = null;
	private String namespace = null;
	
	/**
	 * Constructor for ComponentExtensionAdapter.
	 */
	public ExtendedObjectAdapterImpl() {
		super();
	}
	
	/**
	 * Returns the compExtension.
	 * @return ComponentExtension
	 */
	public Extension getExtension() {
		return extension;
	}
	
	/**
	 * Returns the extension object.
	 * @return ComponentExtension
	 */
	public EObject getExtensionObject() {
		if(extension== null)
			return null;
		else
			return extension.getExtensionObject();
	}

	/**
	 * Sets the compExtension.
	 * @param compExtension The compExtension to set
	 */
	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
	}

	/**
	 * @see org.eclipse.bpel.common.extension.model.adapters.ExtendedObjectAdapter#getNamespace()
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @see org.eclipse.bpel.common.extension.model.adapters.ExtendedObjectAdapter#setNamespace()
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return EObjectImpl.class.equals(type);
	}

}
