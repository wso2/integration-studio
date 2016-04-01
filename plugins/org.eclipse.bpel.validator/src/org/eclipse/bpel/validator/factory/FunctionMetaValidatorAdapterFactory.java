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

import org.eclipse.bpel.fnmeta.model.util.FMAdapterFactory;
import org.eclipse.bpel.model.adapters.AdapterProvider;
import org.eclipse.bpel.validator.adapters.FunctionAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;


/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 15, 2006
 *
 */

@SuppressWarnings("nls")

public class FunctionMetaValidatorAdapterFactory extends FMAdapterFactory {

	/**  */
	static public final FunctionMetaValidatorAdapterFactory INSTANCE = new FunctionMetaValidatorAdapterFactory();
		
	AdapterProvider provider;
	

	private FunctionMetaValidatorAdapterFactory () {
		provider = new AdapterProvider( "org.eclipse.bpel.validator.adapters" );
	}
		
	
	
	/**
	 * @see org.eclipse.bpel.fnmeta.model.util.FMAdapterFactory#createFunctionAdapter()
	 */
	@Override
	public Adapter createFunctionAdapter() {
		return provider.getAdapter(FunctionAdapter.class);
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
	
}
