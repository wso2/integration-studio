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
package org.eclipse.bpel.fnmeta.model.proxy;

import org.eclipse.bpel.fnmeta.model.impl.ArgumentImpl;
import org.eclipse.emf.common.util.URI;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 3, 2007
 * 
 */
@SuppressWarnings("nls")
public class ArgumentProxy extends ArgumentImpl {
	
	URI fURI;
	String fName;

	/**
	 * @param baseURI
	 * @param aName
	 */
	public ArgumentProxy (URI baseURI, String aName) {
		fURI = baseURI;
		fName = aName;
	}

	/**
	 * @see org.eclipse.emf.ecore.impl.EObjectImpl#eIsProxy()
	 */
	@Override
	public boolean eIsProxy() {
		return true;
	}

	/**
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#eProxyURI()
	 */
	
	@Override
	public URI eProxyURI() {
		return fURI.appendFragment("argument=" + fName);		
	}

	/**
	 * @see org.eclipse.bpel.fnmeta.model.impl.AssistantImpl#getName()
	 */
	@Override
	public String getName() {
		return fName;
	}

}
