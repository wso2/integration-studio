/**
 * <copyright>
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: ReferencePartnerLinksImpl.java,v 1.2 2007/08/09 02:02:13 mchmielewski Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.impl;

import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Partner Links</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ReferencePartnerLinksImpl extends EObjectImpl implements ReferencePartnerLinks {
	PartnerLinks partnerLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferencePartnerLinksImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiextensionmodelPackage.Literals.REFERENCE_PARTNER_LINKS;
	}

	public PartnerLinks getPartnerLinks() {
		return partnerLinks;
	}
	public void setPartnerLinks(PartnerLinks partnerLinks) {
		this.partnerLinks = partnerLinks;
	}

} //ReferencePartnerLinksImpl
