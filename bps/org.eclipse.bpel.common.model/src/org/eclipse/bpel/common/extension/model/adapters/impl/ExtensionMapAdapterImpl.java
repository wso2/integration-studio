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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.common.extension.model.Extension;
import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.extension.model.ExtensionmodelPackage;
import org.eclipse.bpel.common.extension.model.adapters.ExtendedObjectAdapter;
import org.eclipse.bpel.common.extension.model.adapters.ExtendedObjectUserAdapter;
import org.eclipse.bpel.common.extension.model.impl.ExtensionMapImpl;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * This adapter is associated to an ExtensionMap and it's responsible for
 * cleaning up once an Extension is removed from the ExtensionMap's list.
 */
public class ExtensionMapAdapterImpl extends AdapterImpl {

	/**
	 * Constructor for ExtensionAdapterImpl.
	 */
	public ExtensionMapAdapterImpl() {
		super();
	}
		
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {

		if(notification.getFeatureID(null) == ExtensionmodelPackage.EXTENSION_MAP__EXTENSIONS){
			switch (notification.getEventType()) {
			
				case Notification.REMOVE : // an Extension has been removed
				case Notification.REMOVE_MANY : // an Extension has been removed
					
					List<Extension> extensionList = null;
					if(notification.getEventType() == Notification.REMOVE_MANY)
						extensionList = (List<Extension>) notification.getOldValue();
					else{
						extensionList = new BasicEList();
						extensionList.add((Extension)notification.getOldValue());
					}
						
					for (Iterator<Extension> iter = extensionList.iterator(); iter.hasNext();) {
						Extension extension = iter.next();
						
						EObject extendedObject = extension.getExtendedObject();
						
						// if the exended EObject had an adapter, remove it.
						if(extendedObject != null){
							EList<Adapter> adapters = extendedObject.eAdapters();
							EList<Adapter> removeAdapterList = new BasicEList<Adapter>();							
							for (Iterator<Adapter> iter2 = adapters.iterator();iter2.hasNext();) {
								Adapter adapter = iter2.next();
								
								if((adapter instanceof ExtendedObjectUserAdapter && ((ExtendedObjectUserAdapter)adapter).getNamespace().equals(((ExtensionMap)getTarget()).getNamespace()))||
										adapter instanceof ExtendedObjectAdapter && ((ExtendedObjectAdapter)adapter).getNamespace().equals(((ExtensionMap)getTarget()).getNamespace())){
									removeAdapterList.add(adapter);	
								}
							}	
						   	
						   	for (Iterator<Adapter> iter2 = removeAdapterList.iterator(); iter2.hasNext();) {
						   		Adapter adapter = iter2.next();
						   		try{
						   			((ExtendedObjectAdapter)adapter).setExtension(null);
						   		}catch(ClassCastException e){}
						   		extendedObject.eAdapters().remove(adapter);
							}
						}
						
						// Set the Extension attributes to null.
						if (!(notification.getNotifier() instanceof Extension)){
							if(extension.getExtendedObject() != null)
								extension.setExtendedObject(null);
						
							if(extension.getExtensionObject() != null)	
								extension.setExtensionObject(null);
						}
							
					}
					break;
	
				case Notification.REMOVING_ADAPTER :
				
					ExtensionMap map = (ExtensionMap) notification.getNotifier();		
					Set extendedObjects = map.keySet();
					
					for (Iterator<EObject> iter = extendedObjects.iterator(); iter.hasNext();) {
						EObject element = iter.next();
						
						List<Adapter> remove = new BasicEList<Adapter>();
						for (Iterator<Adapter> iterator = element.eAdapters().iterator(); iterator.hasNext();) {
							Adapter adapter = iterator.next();
							if(adapter instanceof ExtendedObjectUserAdapter ||
									adapter instanceof ExtendedObjectAdapter)
								remove.add(adapter);
						}
						element.eAdapters().removeAll(remove);
					}
					
					break;
				
				default :
					break;
			}
		}
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return ExtensionMapImpl.class.equals(type);
	}

}
