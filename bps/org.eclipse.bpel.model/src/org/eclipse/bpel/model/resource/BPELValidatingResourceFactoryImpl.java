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
package org.eclipse.bpel.model.resource;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;

/**
 * @author IBM Original Contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 19, 2007
 *
 */
public class BPELValidatingResourceFactoryImpl extends BPELResourceFactoryImpl {
	
	// Properties for validating BPEL document
	
	protected boolean fValidating = false;
	protected EntityResolver fEntityResolver = null;
	protected ErrorHandler fErrorHandler = null;
	protected ResourceSet fResourceSet = null;
	
	protected BPELValidatingResourceFactoryImpl() {	
		fValidating = false;
		fEntityResolver = null;
		fErrorHandler = null;
		fResourceSet = null;
	}
	
	/**
	 * @param resourceSet
	 * @param entityResolver
	 * @param errorHandler
	 */
	@SuppressWarnings("nls")
	public BPELValidatingResourceFactoryImpl(ResourceSet resourceSet, EntityResolver entityResolver, ErrorHandler errorHandler) {	
		
		fValidating = true;
		
		fEntityResolver = entityResolver;
		fErrorHandler = errorHandler;
		fResourceSet = resourceSet;
		
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
		resourceFactoryRegistry.getExtensionToFactoryMap().put("bpel", this);
	}
	
	/**
	 * @see org.eclipse.bpel.model.resource.BPELResourceFactoryImpl#createResource(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public Resource createResource(URI uri) {
		try {
			return new BPELResourceImpl(uri, fEntityResolver, fErrorHandler);
		} catch (IOException exc) {
			return null;
		}
	}
}
