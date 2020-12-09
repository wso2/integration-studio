/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: PartnerlinktypeFactory.java,v 1.4 2007/08/01 21:02:32 mchmielewski Exp $
 */
package org.eclipse.bpel.model.partnerlinktype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage
 * @generated
 */
public interface PartnerlinktypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PartnerlinktypeFactory eINSTANCE = org.eclipse.bpel.model.partnerlinktype.impl.PartnerlinktypeFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Partner Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partner Link Type</em>'.
	 * @generated
	 */
	PartnerLinkType createPartnerLinkType();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	Role createRole();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PartnerlinktypePackage getPartnerlinktypePackage();

} //PartnerlinktypeFactory
