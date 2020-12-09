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
import org.eclipse.bpel.model.partnerlinktype.util.PartnerlinktypeAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;


/**
 * BPELUIPartnerLinkTypeAdapterFactory for generating adapters.
 * 
 * We use an instance of AdapterProvider that caches singleton adapters.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 23, 2007
 *
 */
public class BPELUIPartnerLinkTypeAdapterFactory extends PartnerlinktypeAdapterFactory {

	static BPELUIPartnerLinkTypeAdapterFactory instance;
		
	AdapterProvider provider;
	
	/**
	 * There is only 1 instance of this class, so the default constructor
	 * is private.
	 *
	 */
	private BPELUIPartnerLinkTypeAdapterFactory () {
		provider = new AdapterProvider ();
	}
	
	/**
	 * Get the instance of this factory.
	 * 
	 * @return an instance of this factory.
	 */
	
	public static BPELUIPartnerLinkTypeAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BPELUIPartnerLinkTypeAdapterFactory();
		}
		return instance;
	}
	
	
	
	/**
	 * @see org.eclipse.bpel.model.partnerlinktype.util.PartnerlinktypeAdapterFactory#createPartnerLinkTypeAdapter()
	 */
	@Override
	public Adapter createPartnerLinkTypeAdapter() {
		return provider.getAdapter ( PartnerLinkTypeAdapter.class );
	}
	
	/**
	 * @see org.eclipse.bpel.model.partnerlinktype.util.PartnerlinktypeAdapterFactory#createRoleAdapter()
	 */
	@Override
	public Adapter createRoleAdapter() {
		return provider.getAdapter( RoleAdapter.class );
	}
	
	
	/**
	 * @return PortType adapter.
	 */
	
	public Adapter createRolePortTypeAdapter() {
		return provider.getAdapter( PortTypeAdapter.class );		
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
	protected Object resolve(Object object, Object type) {
		return null;
	}
}
