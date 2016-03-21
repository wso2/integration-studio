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
package org.eclipse.bpel.validator.factory;

import org.eclipse.bpel.model.adapters.AdapterProvider;
import org.eclipse.bpel.model.util.BPELAdapterFactory;
import org.eclipse.bpel.validator.adapters.BasicAdapter;
import org.eclipse.bpel.validator.adapters.PartnerActivityAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;


/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 15, 2006
 *
 */

@SuppressWarnings("nls")

public class BPELValidatorAdapterFactory extends BPELAdapterFactory {

	/** */
	static public final BPELValidatorAdapterFactory INSTANCE = new BPELValidatorAdapterFactory();
		
	AdapterProvider provider;
	

	private BPELValidatorAdapterFactory () {
		provider = new AdapterProvider( "org.eclipse.bpel.validator.adapters" );
	}
	
	
	/** 
	 * Return the generic EObjectAdapter ...
	 * @return the generic EObject adapter.
	 *   
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createEObjectAdapter()
	 */
	
	@Override
	public Adapter createEObjectAdapter() {
		return provider.getAdapter(BasicAdapter.class);
	}
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.model.util.BPELAdapterFactory#createPartnerActivityAdapter()
	 */
	
	@Override
	public Adapter createPartnerActivityAdapter() {
		return provider.getAdapter ( PartnerActivityAdapter.class );
	}
	

	/**
	 * Adapt a new object to the type given.
	 * @param target the target to adapt.
	 * @param type the type to which it should be adapted.
	 * 
	 * @return an suitable adapter
	 */
	
	@Override
	public Adapter adaptNew ( Notifier target, Object type ) {
	
		Adapter adapter = createAdapter(target, type);
		if (adapter != null && adapter.isAdapterForType(type)) {
			associate(adapter, target);
			return adapter;
		}
		return null;
		
	}
	
	@Override
	protected Object resolve(Object object, Object type) {
		return null;
	}

	
    @Override
	protected Adapter createAdapter (Notifier target, Object type) {
    	    	
//    	if (BPELUtil.isCustomActivity(target)) {
//            // If we have a custom activity that did not provide a
//            // custom adapter we create a default adapter. 
//            return createCustomActivityAdapter();
//    	}
    	
        return super.createAdapter(target, type);
    }

	
}
