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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xsd.util.XSDAdapterFactory;



/**
 * BPELUIXSDAdapterFactory for generating adapters.
 * 
 * We use an instance of AdapterProvider that caches singleton adapters.
 *
 * @auhtor IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 10, 2007
 *
 */

public class BPELUIXSDAdapterFactory extends XSDAdapterFactory {
	
	static private BPELUIXSDAdapterFactory instance;	
	
	AdapterProvider provider;
	
	/**
	 * The AdapterFactory constructor. Private, because there is only
	 * 1 instance of the factory obtainable via getInstance() method below. 
	 */
	
	private BPELUIXSDAdapterFactory () {
		provider = new AdapterProvider();
	}
	
	
	/**
	 * Get the instance of the factory.
	 * 
	 * @return an instance of this WSIL UI factory
	 */
	
	public static BPELUIXSDAdapterFactory getInstance() {
		if (instance == null) {
			instance = new BPELUIXSDAdapterFactory();
		}
		return instance;
	}
	
	/**
	 * @return the simple type definition adapter.
	 */
	
	public Adapter createXSDSimpleTypeDefinitionAdatper () {
		return provider.getAdapter( XSDSimpleTypeDefinitionAdapter.class );		
	}
	
	/**
	 * @see org.eclipse.xsd.util.XSDAdapterFactory#createXSDComplexTypeDefinitionAdapter()
	 */
	@Override
	public Adapter createXSDComplexTypeDefinitionAdapter () {
		return provider.getAdapter( XSDComplexTypeDefinitionAdapter.class );		
	}
	
	/**
	 * @see org.eclipse.xsd.util.XSDAdapterFactory#createXSDTypeDefinitionAdapter()
	 */
	@Override
	public Adapter createXSDTypeDefinitionAdapter() {
		return provider.getAdapter( XSDTypeDefinitionAdapter.class );		
	}
	
	/**
	 * @see org.eclipse.xsd.util.XSDAdapterFactory#createXSDAttributeDeclarationAdapter()
	 */
	@Override
	public Adapter createXSDAttributeDeclarationAdapter() {
		return provider.getAdapter( XSDAttributeDeclarationAdapter.class );		
	}
	
	/**
	 * @see org.eclipse.xsd.util.XSDAdapterFactory#createXSDElementDeclarationAdapter()
	 */
	@Override
	public Adapter createXSDElementDeclarationAdapter() {
		return provider.getAdapter( XSDElementDeclarationAdapter.class );		
	}
		
	/**
	 * @see org.eclipse.xsd.util.XSDAdapterFactory#createXSDSchemaAdapter()
	 */
	@Override
	public Adapter createXSDSchemaAdapter() {
		return provider.getAdapter( XSDSchemaAdapter.class );		
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
