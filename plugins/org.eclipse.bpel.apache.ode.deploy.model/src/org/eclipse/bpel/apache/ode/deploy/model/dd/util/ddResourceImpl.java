/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.model.dd.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.util.ddResourceFactoryImpl
 * @generated
 */
public class ddResourceImpl extends XMLResourceImpl {
		
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public ddResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	protected XMLHelper createXMLHelper() {
		return new DDXMLHelperImpl();
	}

} //ddResourceImpl
