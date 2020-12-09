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
 * $Id: MessagepropertiesFactoryImpl.java,v 1.4 2011/03/30 18:54:26 rbrodt Exp $
 */
package org.eclipse.bpel.model.messageproperties.impl;

import org.eclipse.bpel.model.messageproperties.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MessagepropertiesFactoryImpl extends EFactoryImpl implements
		MessagepropertiesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MessagepropertiesFactory init() {
		try {
			MessagepropertiesFactory theMessagepropertiesFactory = (MessagepropertiesFactory) EPackage.Registry.INSTANCE
					.getEFactory(MessagepropertiesPackage.eNS_URI);
			if (theMessagepropertiesFactory != null) {
				return theMessagepropertiesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MessagepropertiesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessagepropertiesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MessagepropertiesPackage.PROPERTY:
			return createProperty();
		case MessagepropertiesPackage.PROPERTY_ALIAS:
			return createPropertyAlias();
		case MessagepropertiesPackage.QUERY:
			return createQuery();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAlias createPropertyAlias() {
		PropertyAliasImpl propertyAlias = new PropertyAliasImpl();
		return propertyAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQuery() {
		QueryImpl query = new QueryImpl();
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessagepropertiesPackage getMessagepropertiesPackage() {
		return (MessagepropertiesPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MessagepropertiesPackage getPackage() {
		return MessagepropertiesPackage.eINSTANCE;
	}

} //MessagepropertiesFactoryImpl
