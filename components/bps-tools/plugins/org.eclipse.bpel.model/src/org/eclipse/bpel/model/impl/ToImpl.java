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
 * $Id: ToImpl.java,v 1.14 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.AbstractAssignBound;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.proxy.PartProxy;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ToImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ToImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ToImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ToImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ToImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ToImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToImpl extends BPELExtensibleElementImpl implements To {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected Part part;

	/**
	 * The deserialized value of the part name.
	 * @customized
	 */
	protected String partName = null;

	/**
	 * The cached value of the '{@link #getPartnerLink() <em>Partner Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected PartnerLink partnerLink;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected Query query;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.TO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject) variable;
			variable = (Variable) eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.TO__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_VARIABLE, newVariable == null ? null
							: newVariable.getName());
		}
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO__VARIABLE, oldVariable, variable));
	}

	/**
	 * Customizes {@link #getPartGen()} to lazy-resolve the part name.
	 * @customized
	 */
	public Part getPart() {
		if (part == null && partName != null) {
			Variable aVar = getVariable();
			if (variable != null) {
				Message message = aVar.getMessageType();
				if (message != null) {
					// Create an part proxy with the deserialized part name.
					part = new PartProxy(eResource(), message, partName);
					partName = null;
				}
			}
		}
		return getPartGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getPartGen() {
		if (part != null && part.eIsProxy()) {
			InternalEObject oldPart = (InternalEObject) part;
			part = (Part) eResolveProxy(oldPart);
			if (part != oldPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.TO__PART, oldPart, part));
			}
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetPart() {
		return part;
	}

	/**
	 * Set the deserialized value of the part name.
	 * @customized
	 */
	public void setPartName(String newPartName) {

		partName = newPartName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPart(Part newPart) {
		Part oldPart = part;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, BPELConstants.AT_PART,
					newPart == null ? null : newPart.getName());
		}
		part = newPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO__PART, oldPart, part));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLink getPartnerLink() {
		if (partnerLink != null && partnerLink.eIsProxy()) {
			InternalEObject oldPartnerLink = (InternalEObject) partnerLink;
			partnerLink = (PartnerLink) eResolveProxy(oldPartnerLink);
			if (partnerLink != oldPartnerLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.TO__PARTNER_LINK, oldPartnerLink,
							partnerLink));
			}
		}
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLink basicGetPartnerLink() {
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPartnerLink(PartnerLink newPartnerLink) {
		PartnerLink oldPartnerLink = partnerLink;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_PARTNER_LINK,
					newPartnerLink == null ? null : newPartnerLink.getName());
		}
		partnerLink = newPartnerLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO__PARTNER_LINK, oldPartnerLink, partnerLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject) property;
			property = (Property) eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.TO__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_PROPERTY, newProperty == null ? null
							: newProperty.getQName());
		}
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetQuery(Query newQuery,
			NotificationChain msgs) {
		Query oldQuery = query;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldQuery, newQuery);
		}
		query = newQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.TO__QUERY, oldQuery, newQuery);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(Query newQuery) {
		if (newQuery != query) {
			NotificationChain msgs = null;
			if (query != null)
				msgs = ((InternalEObject) query).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.TO__QUERY, null,
						msgs);
			if (newQuery != null)
				msgs = ((InternalEObject) newQuery).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.TO__QUERY, null,
						msgs);
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO__QUERY, newQuery, newQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetExpression(Expression newExpression,
			NotificationChain msgs) {
		Expression oldExpression = expression;
		if (!isReconciling) {
			ReconciliationHelper.replaceExpression(this, newExpression);
		}
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.TO__EXPRESSION,
					oldExpression, newExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject) expression).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.TO__EXPRESSION,
						null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.TO__EXPRESSION,
						null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.TO__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BPELPackage.TO__QUERY:
			return basicSetQuery(null, msgs);
		case BPELPackage.TO__EXPRESSION:
			return basicSetExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BPELPackage.TO__VARIABLE:
			if (resolve)
				return getVariable();
			return basicGetVariable();
		case BPELPackage.TO__PART:
			if (resolve)
				return getPart();
			return basicGetPart();
		case BPELPackage.TO__PARTNER_LINK:
			if (resolve)
				return getPartnerLink();
			return basicGetPartnerLink();
		case BPELPackage.TO__PROPERTY:
			if (resolve)
				return getProperty();
			return basicGetProperty();
		case BPELPackage.TO__QUERY:
			return getQuery();
		case BPELPackage.TO__EXPRESSION:
			return getExpression();
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
		case BPELPackage.TO__VARIABLE:
			setVariable((Variable) newValue);
			return;
		case BPELPackage.TO__PART:
			setPart((Part) newValue);
			return;
		case BPELPackage.TO__PARTNER_LINK:
			setPartnerLink((PartnerLink) newValue);
			return;
		case BPELPackage.TO__PROPERTY:
			setProperty((Property) newValue);
			return;
		case BPELPackage.TO__QUERY:
			setQuery((Query) newValue);
			return;
		case BPELPackage.TO__EXPRESSION:
			setExpression((Expression) newValue);
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
		case BPELPackage.TO__VARIABLE:
			setVariable((Variable) null);
			return;
		case BPELPackage.TO__PART:
			setPart((Part) null);
			return;
		case BPELPackage.TO__PARTNER_LINK:
			setPartnerLink((PartnerLink) null);
			return;
		case BPELPackage.TO__PROPERTY:
			setProperty((Property) null);
			return;
		case BPELPackage.TO__QUERY:
			setQuery((Query) null);
			return;
		case BPELPackage.TO__EXPRESSION:
			setExpression((Expression) null);
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
		case BPELPackage.TO__VARIABLE:
			return variable != null;
		case BPELPackage.TO__PART:
			return part != null;
		case BPELPackage.TO__PARTNER_LINK:
			return partnerLink != null;
		case BPELPackage.TO__PROPERTY:
			return property != null;
		case BPELPackage.TO__QUERY:
			return query != null;
		case BPELPackage.TO__EXPRESSION:
			return expression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractAssignBound.class) {
			switch (derivedFeatureID) {
			case BPELPackage.TO__VARIABLE:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE;
			case BPELPackage.TO__PART:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__PART;
			case BPELPackage.TO__PARTNER_LINK:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK;
			case BPELPackage.TO__PROPERTY:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY;
			case BPELPackage.TO__QUERY:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY;
			case BPELPackage.TO__EXPRESSION:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractAssignBound.class) {
			switch (baseFeatureID) {
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE:
				return BPELPackage.TO__VARIABLE;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__PART:
				return BPELPackage.TO__PART;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK:
				return BPELPackage.TO__PARTNER_LINK;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY:
				return BPELPackage.TO__PROPERTY;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY:
				return BPELPackage.TO__QUERY;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION:
				return BPELPackage.TO__EXPRESSION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ToImpl
