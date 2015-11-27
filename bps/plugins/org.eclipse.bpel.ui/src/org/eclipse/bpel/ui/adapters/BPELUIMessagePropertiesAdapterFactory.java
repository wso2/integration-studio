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
import org.eclipse.bpel.model.messageproperties.util.MessagepropertiesAdapterFactory;
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

public class BPELUIMessagePropertiesAdapterFactory extends MessagepropertiesAdapterFactory {
	
	static BPELUIMessagePropertiesAdapterFactory instance;
	
	AdapterProvider provider;
	
	private BPELUIMessagePropertiesAdapterFactory () {
		provider = new AdapterProvider();
	}
	
	/**
	 * Get the instance of this factory.
	 * 
	 * @return an instance of this factory.
	 */
	
	public static BPELUIMessagePropertiesAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BPELUIMessagePropertiesAdapterFactory();
		}
		return instance;
	}

	/**
	 * @see org.eclipse.bpel.model.messageproperties.util.MessagepropertiesAdapterFactory#createPropertyAdapter()
	 */
	@Override
	public Adapter createPropertyAdapter() {
		return provider.getAdapter( PropertyAdapter.class );
	}
	
	/**
	 * @see org.eclipse.bpel.model.messageproperties.util.MessagepropertiesAdapterFactory#createPropertyAdapter()
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	 * https://jira.jboss.org/browse/JBIDE-7107
	 * This adds the INamespace adapter to PropertyAlias objects (required for the XPath expression editor)
	 */
	@Override
	public Adapter createPropertyAliasAdapter() {
		return provider.getAdapter( PropertyAliasAdapter.class );
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
