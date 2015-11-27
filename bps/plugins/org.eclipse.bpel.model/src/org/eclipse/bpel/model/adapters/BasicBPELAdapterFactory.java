/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.adapters;

import org.eclipse.bpel.model.util.BPELAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 23, 2007
 *
 */
public class BasicBPELAdapterFactory extends BPELAdapterFactory {
	
	/**
	 * 
	 */
	static public final BasicBPELAdapterFactory INSTANCE = new BasicBPELAdapterFactory();
	
	AdapterProvider provider = new AdapterProvider();
	
	
	BasicBPELAdapterFactory () {
		
	}
					
	/**
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createEObjectAdapter()
	 */
	@Override
	public Adapter createEObjectAdapter() {
		return provider.getAdapter(BasicEObjectaAdapter.class);
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
		
}
