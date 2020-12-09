/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.AbstractAssignBound;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Variable;

import org.eclipse.bpel.model.messageproperties.Property;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.wst.wsdl.Part;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Assign Bound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.AbstractAssignBoundImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.AbstractAssignBoundImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.AbstractAssignBoundImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.AbstractAssignBoundImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.AbstractAssignBoundImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.AbstractAssignBoundImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractAssignBoundImpl extends EObjectImpl implements
		AbstractAssignBound {
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
	protected AbstractAssignBoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.ABSTRACT_ASSIGN_BOUND;
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
							BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE,
							oldVariable, variable));
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
	 * @generated
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE, oldVariable,
					variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getPart() {
		if (part != null && part.eIsProxy()) {
			InternalEObject oldPart = (InternalEObject) part;
			part = (Part) eResolveProxy(oldPart);
			if (part != oldPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.ABSTRACT_ASSIGN_BOUND__PART, oldPart,
							part));
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPart(Part newPart) {
		Part oldPart = part;
		part = newPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ABSTRACT_ASSIGN_BOUND__PART, oldPart, part));
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
							BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK,
							oldPartnerLink, partnerLink));
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
	 * @generated
	 */
	public void setPartnerLink(PartnerLink newPartnerLink) {
		PartnerLink oldPartnerLink = partnerLink;
		partnerLink = newPartnerLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK,
					oldPartnerLink, partnerLink));
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
							BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY,
							oldProperty, property));
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
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY, oldProperty,
					property));
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
	 * @generated
	 */
	public NotificationChain basicSetQuery(Query newQuery,
			NotificationChain msgs) {
		Query oldQuery = query;
		query = newQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY,
					oldQuery, newQuery);
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
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY,
						null, msgs);
			if (newQuery != null)
				msgs = ((InternalEObject) newQuery).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY,
						null, msgs);
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY, newQuery,
					newQuery));
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
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression,
			NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION,
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
				msgs = ((InternalEObject) expression)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION,
								null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION,
								null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION,
					newExpression, newExpression));
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
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY:
			return basicSetQuery(null, msgs);
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION:
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
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE:
			if (resolve)
				return getVariable();
			return basicGetVariable();
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PART:
			if (resolve)
				return getPart();
			return basicGetPart();
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK:
			if (resolve)
				return getPartnerLink();
			return basicGetPartnerLink();
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY:
			if (resolve)
				return getProperty();
			return basicGetProperty();
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY:
			return getQuery();
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION:
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
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE:
			setVariable((Variable) newValue);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PART:
			setPart((Part) newValue);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK:
			setPartnerLink((PartnerLink) newValue);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY:
			setProperty((Property) newValue);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY:
			setQuery((Query) newValue);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION:
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
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE:
			setVariable((Variable) null);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PART:
			setPart((Part) null);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK:
			setPartnerLink((PartnerLink) null);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY:
			setProperty((Property) null);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY:
			setQuery((Query) null);
			return;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION:
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
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE:
			return variable != null;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PART:
			return part != null;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK:
			return partnerLink != null;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY:
			return property != null;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY:
			return query != null;
		case BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION:
			return expression != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractAssignBoundImpl
