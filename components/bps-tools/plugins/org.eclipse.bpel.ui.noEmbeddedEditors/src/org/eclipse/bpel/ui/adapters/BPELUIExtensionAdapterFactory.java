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

import org.eclipse.bpel.model.adapters.AdapterProvider;
import org.eclipse.bpel.ui.uiextensionmodel.util.UiextensionmodelAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;



/**
 * BPELUIMessagePropertiesAdapterFactory for generating adapters.
 * 
 * We use an instance of AdapterProvider that caches singleton adapters.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 23, 2007
 *
 */

public class BPELUIExtensionAdapterFactory extends UiextensionmodelAdapterFactory {
			
	static BPELUIExtensionAdapterFactory instance = null;
	
	AdapterProvider provider = new AdapterProvider();
	
	private BPELUIExtensionAdapterFactory () {
		provider = new AdapterProvider();
	}
	
	/**
	 * Get the instance of this factory.
	 * 
	 * @return an instance of this factory.
	 */
		
	public static BPELUIExtensionAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BPELUIExtensionAdapterFactory();
		}
		return instance;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.uiextensionmodel.util.UiextensionmodelAdapterFactory#createStartNodeAdapter()
	 */
	@Override
	public Adapter createStartNodeAdapter() {
		return provider.getAdapter( StartNodeAdapter.class);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.uiextensionmodel.util.UiextensionmodelAdapterFactory#createEndNodeAdapter()
	 */
	@Override
	public Adapter createEndNodeAdapter() {
		return provider.getAdapter( EndNodeAdapter.class);
	}
	
	
	/**
	 * @see org.eclipse.bpel.ui.uiextensionmodel.util.UiextensionmodelAdapterFactory#createReferencePartnerLinksAdapter()
	 */
	@Override
	public Adapter createReferencePartnerLinksAdapter() {
		return provider.getAdapter( ReferencePartnerLinksAdapter.class );
	}

	
	
	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterFactoryImpl#adaptNew(org.eclipse.emf.common.notify.Notifier, java.lang.Object)
	 */
	@Override
	public Adapter adaptNew(Notifier target, Object type) {
		Adapter adapter = createAdapter(target, type);
		// Bugzilla 330519
		// only associate the adapter with the target (i.e. add it to the
		// target's eAdapters list) if the adapter is for the requested type
		if (adapter!=null && adapter.isAdapterForType(type)) {
			associate(adapter,target);
			return adapter;
		}
		return null;		
	}
	
	@Override
	protected Object resolve (Object object, Object type) {
		return null;
	}
}
