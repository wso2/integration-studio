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
 * $Id: ExpressionImpl.java,v 1.14 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.internal.impl.ExtensibilityElementImpl;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ExpressionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ExpressionImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ExpressionImpl#getOpaque <em>Opaque</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends ExtensibilityElementImpl implements
		Expression {
	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final Object BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Object body = BODY_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * This is true if the Expression Language attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean expressionLanguageESet;

	/**
	 * The default value of the '{@link #getOpaque() <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpaque()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean OPAQUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOpaque() <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpaque()
	 * @generated
	 * @ordered
	 */
	protected Boolean opaque = OPAQUE_EDEFAULT;

	/**
	 * This is true if the Opaque attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean opaqueESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setBody(Object newBody) {
		Object oldBody = body;

		BPELExtensibleElementImpl parent = ((BPELExtensibleElementImpl) eContainer());
		boolean transparent = BPELUtils.isTransparent(eContainer(), this);

		if ((!transparent && !isReconciling)
				|| (transparent && !parent.isReconciling())) {
			ReconciliationHelper.replaceText(transparent ? parent : this,
					newBody);
		}
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.EXPRESSION__BODY, oldBody, body));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionLanguage() {
		return expressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setExpressionLanguage(String newExpressionLanguage) {
		String oldExpressionLanguage = expressionLanguage;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(BPELUtils.isTransparent(
					eContainer(), this) ? (WSDLElement) eContainer() : this,
					BPELConstants.AT_EXPRESSIONLANGUAGE, newExpressionLanguage);
		}
		expressionLanguage = newExpressionLanguage;
		boolean oldExpressionLanguageESet = expressionLanguageESet;
		expressionLanguageESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.EXPRESSION__EXPRESSION_LANGUAGE,
					oldExpressionLanguage, expressionLanguage,
					!oldExpressionLanguageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetExpressionLanguage() {
		String oldExpressionLanguage = expressionLanguage;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(BPELUtils.isTransparent(
					eContainer(), this) ? ((WSDLElement) eContainer()) : this,
					BPELConstants.AT_EXPRESSIONLANGUAGE, (String) null);
		}
		boolean oldExpressionLanguageESet = expressionLanguageESet;
		expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;
		expressionLanguageESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.EXPRESSION__EXPRESSION_LANGUAGE,
					oldExpressionLanguage, EXPRESSION_LANGUAGE_EDEFAULT,
					oldExpressionLanguageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpressionLanguage() {
		return expressionLanguageESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getOpaque() {
		return opaque;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setOpaque(Boolean newOpaque) {
		Boolean oldOpaque = opaque;
		if (!isReconciling && getElement() != null) {
			ReconciliationHelper.replaceAttribute(BPELUtils.isTransparent(
					eContainer(), this) ? ((WSDLElement) eContainer()) : this,
					BPELConstants.AT_OPAQUE, BPELUtils.boolean2XML(newOpaque));
		}
		opaque = newOpaque;
		boolean oldOpaqueESet = opaqueESet;
		opaqueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.EXPRESSION__OPAQUE, oldOpaque, opaque,
					!oldOpaqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetOpaque() {
		Boolean oldOpaque = opaque;
		if (!isReconciling && getElement() != null) {
			ReconciliationHelper.replaceAttribute(BPELUtils.isTransparent(
					eContainer(), this) ? ((WSDLElement) eContainer()) : this,
					BPELConstants.AT_OPAQUE, (String) null);
		}
		boolean oldOpaqueESet = opaqueESet;
		opaque = OPAQUE_EDEFAULT;
		opaqueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.EXPRESSION__OPAQUE, oldOpaque, OPAQUE_EDEFAULT,
					oldOpaqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOpaque() {
		return opaqueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.EXPRESSION__BODY:
			return getBody();
		case BPELPackage.EXPRESSION__EXPRESSION_LANGUAGE:
			return getExpressionLanguage();
		case BPELPackage.EXPRESSION__OPAQUE:
			return getOpaque();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BPELPackage.EXPRESSION__BODY:
			setBody(newValue);
			return;
		case BPELPackage.EXPRESSION__EXPRESSION_LANGUAGE:
			setExpressionLanguage((String) newValue);
			return;
		case BPELPackage.EXPRESSION__OPAQUE:
			setOpaque((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case BPELPackage.EXPRESSION__BODY:
			setBody(BODY_EDEFAULT);
			return;
		case BPELPackage.EXPRESSION__EXPRESSION_LANGUAGE:
			unsetExpressionLanguage();
			return;
		case BPELPackage.EXPRESSION__OPAQUE:
			unsetOpaque();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case BPELPackage.EXPRESSION__BODY:
			return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT
					.equals(body);
		case BPELPackage.EXPRESSION__EXPRESSION_LANGUAGE:
			return isSetExpressionLanguage();
		case BPELPackage.EXPRESSION__OPAQUE:
			return isSetOpaque();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (body: "); //$NON-NLS-1$
		result.append(body);
		result.append(", expressionLanguage: "); //$NON-NLS-1$
		if (expressionLanguageESet)
			result.append(expressionLanguage);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", opaque: "); //$NON-NLS-1$
		if (opaqueESet)
			result.append(opaque);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	@Override
	protected void reconcile(Element changedElement) {
		ReconciliationHelper.getInstance().reconcile(this, changedElement);
	}
} //ExpressionImpl
