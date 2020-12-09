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
 * $Id: UnknownExtensibilityAttributeImpl.java,v 1.5 2008/05/04 11:05:46 odanilov Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.UnknownExtensibilityAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.wst.wsdl.internal.impl.UnknownExtensibilityElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unknown Extensibility Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UnknownExtensibilityAttributeImpl extends
		UnknownExtensibilityElementImpl implements
		UnknownExtensibilityAttribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnknownExtensibilityAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.UNKNOWN_EXTENSIBILITY_ATTRIBUTE;
	}

} //UnknownExtensibilityAttributeImpl
