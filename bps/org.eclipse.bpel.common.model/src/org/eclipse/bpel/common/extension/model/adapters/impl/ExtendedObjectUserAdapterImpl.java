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

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.extension.model.adapters.ExtendedObjectUserAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;


/**
 * This adapter is associated to an ExtensionMap and it's responsible for
 * cleaning up once an Extension is removed from the ExtensionMap's list.
 */
public class ExtendedObjectUserAdapterImpl extends AdapterImpl implements ExtendedObjectUserAdapter {

	private ExtensionMap extensionMap = null;
	
	/**
	 * Constructor for ExtensionAdapterImpl.
	 */
	public ExtendedObjectUserAdapterImpl() {
		super();
	}
			
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return EObjectImpl.class.equals(type);
	}
	
	public void setExtensionMap(ExtensionMap extensionMap) {
			this.extensionMap = extensionMap;
	}

	public Object get(Object extendedObject) {
		try{
			return extensionMap.get(extendedObject);
		} catch (NullPointerException npe){
			return null;
		}		
	}

	public String getNamespace() {
		return extensionMap.getNamespace();
	}
}
