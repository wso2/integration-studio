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
import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.extension.model.impl.ExtensionImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;


/**
 * This adapter  is associated to Extension objects.  It's job is to perform the
 * appropriate clean up if any of the the adapted Extension object features are
 * changed.  It is a stateless adapter.
 */
public class ExtensionAdapterImpl extends AdapterImpl {

	/**
	 * Constructor for ExtensionAdapterImpl.
	 */
	public ExtensionAdapterImpl() {
		super();
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {

		switch (notification.getEventType()) {
			case Notification.SET :  // either the extendedObject or extensionObject was changed.
			
				// need to eliminate this extension object from the ExtensionMap.  If, both the extendedObject
				// and extensionObjects are null and the Extension is cointained by the ExtensionMap then
				// remove it form the list.  
				Extension extension = (Extension) notification.getNotifier();
				
				if(extension.getExtendedObject() == null && extension.getExtensionObject() == null && 
			       extension.eContainer() != null){

					ExtensionMap extensionSet = (ExtensionMap)extension.eContainer();
					
					if(extensionSet != null && extensionSet.getExtensions().contains(extension))
						extensionSet.getExtensions().remove(extension);
				}
							
				// If the extendedObject is not null set it to null now			
				if (extension.getExtendedObject() != null)
					extension.setExtendedObject(null);
				
				//	If the extensionObject is not null set it to null now	
				if (extension.getExtensionObject() != null)
					extension.setExtensionObject(null);
				
				break;
				
			default :
				break;
		}
	}
	
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return ExtensionImpl.class.equals(type);
	}

}
