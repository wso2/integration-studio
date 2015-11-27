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
 * $Id: FromImpl.java,v 1.15 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.AbstractAssignBound;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.EndpointReferenceRole;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.ServiceRef;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.proxy.PartProxy;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationBPELReader;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDTypeDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getOpaque <em>Opaque</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getEndpointReference <em>Endpoint Reference</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getUnsafeLiteral <em>Unsafe Literal</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getServiceRef <em>Service Ref</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.FromImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FromImpl extends BPELExtensibleElementImpl implements From {
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
	 * The default value of the '{@link #getEndpointReference() <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointReference()
	 * @generated
	 * @ordered
	 */
	protected static final EndpointReferenceRole ENDPOINT_REFERENCE_EDEFAULT = EndpointReferenceRole.MY_ROLE_LITERAL;

	/**
	 * The cached value of the '{@link #getEndpointReference() <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointReference()
	 * @generated
	 * @ordered
	 */
	protected EndpointReferenceRole endpointReference = ENDPOINT_REFERENCE_EDEFAULT;

	/**
	 * This is true if the Endpoint Reference attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean endpointReferenceESet;

	/**
	 * The default value of the '{@link #getLiteral() <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLiteral() <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteral()
	 * @generated
	 * @ordered
	 */
	protected String literal = LITERAL_EDEFAULT;

	/**
	 * This is true if the Literal attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean literalESet;

	/**
	 * The default value of the '{@link #getUnsafeLiteral() <em>Unsafe Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsafeLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean UNSAFE_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnsafeLiteral() <em>Unsafe Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnsafeLiteral()
	 * @generated
	 * @ordered
	 */
	protected Boolean unsafeLiteral = UNSAFE_LITERAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getServiceRef() <em>Service Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceRef()
	 * @generated
	 * @ordered
	 */
	protected ServiceRef serviceRef;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected XSDTypeDefinition type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.FROM;
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
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_OPAQUE, BPELUtils.boolean2XML(newOpaque));
		}
		opaque = newOpaque;
		boolean oldOpaqueESet = opaqueESet;
		opaqueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__OPAQUE, oldOpaque, opaque, !oldOpaqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetOpaque() {
		Boolean oldOpaque = opaque;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_OPAQUE, (String) null);
		}
		boolean oldOpaqueESet = opaqueESet;
		opaque = OPAQUE_EDEFAULT;
		opaqueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.FROM__OPAQUE, oldOpaque, OPAQUE_EDEFAULT,
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
	public EndpointReferenceRole getEndpointReference() {
		return endpointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setEndpointReference(EndpointReferenceRole newEndpointReference) {
		EndpointReferenceRole oldEndpointReference = endpointReference;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_ENDPOINT_REFERENCE,
					newEndpointReference == null ? ENDPOINT_REFERENCE_EDEFAULT
							.toString() : newEndpointReference.toString());
		}
		endpointReference = newEndpointReference == null ? ENDPOINT_REFERENCE_EDEFAULT
				: newEndpointReference;
		boolean oldEndpointReferenceESet = endpointReferenceESet;
		endpointReferenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__ENDPOINT_REFERENCE, oldEndpointReference,
					endpointReference, !oldEndpointReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetEndpointReference() {
		EndpointReferenceRole oldEndpointReference = endpointReference;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_ENDPOINT_REFERENCE, (String) null);
		}
		boolean oldEndpointReferenceESet = endpointReferenceESet;
		endpointReference = ENDPOINT_REFERENCE_EDEFAULT;
		endpointReferenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.FROM__ENDPOINT_REFERENCE, oldEndpointReference,
					ENDPOINT_REFERENCE_EDEFAULT, oldEndpointReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEndpointReference() {
		return endpointReferenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setLiteral(String newLiteral) {
		String oldLiteral = literal;
		if (!isReconciling) {
			setUnsafeLiteral(!ReconciliationBPELReader
					.isEmptyOrWhitespace(newLiteral));
			ReconciliationHelper.replaceLiteral(this, newLiteral);
		}
		literal = newLiteral;
		boolean oldLiteralESet = literalESet;
		literalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__LITERAL, oldLiteral, literal,
					!oldLiteralESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetLiteral() {
		String oldLiteral = literal;
		boolean oldLiteralESet = literalESet;
		literal = LITERAL_EDEFAULT;
		literalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.FROM__LITERAL, oldLiteral, LITERAL_EDEFAULT,
					oldLiteralESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLiteral() {
		return literalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getUnsafeLiteral() {
		return unsafeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnsafeLiteral(Boolean newUnsafeLiteral) {
		Boolean oldUnsafeLiteral = unsafeLiteral;
		unsafeLiteral = newUnsafeLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__UNSAFE_LITERAL, oldUnsafeLiteral,
					unsafeLiteral));
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
					Notification.SET, BPELPackage.FROM__EXPRESSION,
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
						EOPPOSITE_FEATURE_BASE - BPELPackage.FROM__EXPRESSION,
						null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.FROM__EXPRESSION,
						null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceRef getServiceRef() {
		return serviceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetServiceRef(ServiceRef newServiceRef,
			NotificationChain msgs) {
		ServiceRef oldServiceRef = serviceRef;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldServiceRef,
					newServiceRef);
		}
		serviceRef = newServiceRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.FROM__SERVICE_REF,
					oldServiceRef, newServiceRef);
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
	public void setServiceRef(ServiceRef newServiceRef) {
		if (newServiceRef != serviceRef) {
			NotificationChain msgs = null;
			if (serviceRef != null)
				msgs = ((InternalEObject) serviceRef).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.FROM__SERVICE_REF,
						null, msgs);
			if (newServiceRef != null)
				msgs = ((InternalEObject) newServiceRef).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.FROM__SERVICE_REF,
						null, msgs);
			msgs = basicSetServiceRef(newServiceRef, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__SERVICE_REF, newServiceRef, newServiceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSDTypeDefinition getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (XSDTypeDefinition) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.FROM__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSDTypeDefinition basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setType(XSDTypeDefinition newType) {
		XSDTypeDefinition oldType = type;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_XSI_TYPE,
					newType == null ? null : newType.getName());
		}
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__TYPE, oldType, type));
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
							BPELPackage.FROM__VARIABLE, oldVariable, variable));
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
					BPELPackage.FROM__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public Part getPartGen() {
		if (part != null && part.eIsProxy()) {
			Part oldPart = part;
			part = (Part) eResolveProxy((InternalEObject) part);
			if (part != oldPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.FROM__PART, oldPart, part));
			}
		}
		return part;
	}

	/**
	 * Customizes {@link #getPartGen()} to lazy-resolve the part name.
	 * @customized
	 */

	public Part getPart() {
		if (part == null && partName != null) {
			Variable aVar = getVariable();
			if (aVar != null) {
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
	 * Set the deserialized value of the part name.
	 * @customized
	 */
	public void setPartName(String newPartName) {
		partName = newPartName;
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
					BPELPackage.FROM__PART, oldPart, part));
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
							BPELPackage.FROM__PARTNER_LINK, oldPartnerLink,
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
					BPELPackage.FROM__PARTNER_LINK, oldPartnerLink, partnerLink));
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
							BPELPackage.FROM__PROPERTY, oldProperty, property));
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
					BPELPackage.FROM__PROPERTY, oldProperty, property));
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
					Notification.SET, BPELPackage.FROM__QUERY, oldQuery,
					newQuery);
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
						EOPPOSITE_FEATURE_BASE - BPELPackage.FROM__QUERY, null,
						msgs);
			if (newQuery != null)
				msgs = ((InternalEObject) newQuery).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.FROM__QUERY, null,
						msgs);
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.FROM__QUERY, newQuery, newQuery));
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
		case BPELPackage.FROM__QUERY:
			return basicSetQuery(null, msgs);
		case BPELPackage.FROM__EXPRESSION:
			return basicSetExpression(null, msgs);
		case BPELPackage.FROM__SERVICE_REF:
			return basicSetServiceRef(null, msgs);
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
		case BPELPackage.FROM__VARIABLE:
			if (resolve)
				return getVariable();
			return basicGetVariable();
		case BPELPackage.FROM__PART:
			if (resolve)
				return getPart();
			return basicGetPart();
		case BPELPackage.FROM__PARTNER_LINK:
			if (resolve)
				return getPartnerLink();
			return basicGetPartnerLink();
		case BPELPackage.FROM__PROPERTY:
			if (resolve)
				return getProperty();
			return basicGetProperty();
		case BPELPackage.FROM__QUERY:
			return getQuery();
		case BPELPackage.FROM__EXPRESSION:
			return getExpression();
		case BPELPackage.FROM__OPAQUE:
			return getOpaque();
		case BPELPackage.FROM__ENDPOINT_REFERENCE:
			return getEndpointReference();
		case BPELPackage.FROM__LITERAL:
			return getLiteral();
		case BPELPackage.FROM__UNSAFE_LITERAL:
			return getUnsafeLiteral();
		case BPELPackage.FROM__SERVICE_REF:
			return getServiceRef();
		case BPELPackage.FROM__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
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
		case BPELPackage.FROM__VARIABLE:
			setVariable((Variable) newValue);
			return;
		case BPELPackage.FROM__PART:
			setPart((Part) newValue);
			return;
		case BPELPackage.FROM__PARTNER_LINK:
			setPartnerLink((PartnerLink) newValue);
			return;
		case BPELPackage.FROM__PROPERTY:
			setProperty((Property) newValue);
			return;
		case BPELPackage.FROM__QUERY:
			setQuery((Query) newValue);
			return;
		case BPELPackage.FROM__EXPRESSION:
			setExpression((Expression) newValue);
			return;
		case BPELPackage.FROM__OPAQUE:
			setOpaque((Boolean) newValue);
			return;
		case BPELPackage.FROM__ENDPOINT_REFERENCE:
			setEndpointReference((EndpointReferenceRole) newValue);
			return;
		case BPELPackage.FROM__LITERAL:
			setLiteral((String) newValue);
			return;
		case BPELPackage.FROM__UNSAFE_LITERAL:
			setUnsafeLiteral((Boolean) newValue);
			return;
		case BPELPackage.FROM__SERVICE_REF:
			setServiceRef((ServiceRef) newValue);
			return;
		case BPELPackage.FROM__TYPE:
			setType((XSDTypeDefinition) newValue);
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
		case BPELPackage.FROM__VARIABLE:
			setVariable((Variable) null);
			return;
		case BPELPackage.FROM__PART:
			setPart((Part) null);
			return;
		case BPELPackage.FROM__PARTNER_LINK:
			setPartnerLink((PartnerLink) null);
			return;
		case BPELPackage.FROM__PROPERTY:
			setProperty((Property) null);
			return;
		case BPELPackage.FROM__QUERY:
			setQuery((Query) null);
			return;
		case BPELPackage.FROM__EXPRESSION:
			setExpression((Expression) null);
			return;
		case BPELPackage.FROM__OPAQUE:
			unsetOpaque();
			return;
		case BPELPackage.FROM__ENDPOINT_REFERENCE:
			unsetEndpointReference();
			return;
		case BPELPackage.FROM__LITERAL:
			unsetLiteral();
			return;
		case BPELPackage.FROM__UNSAFE_LITERAL:
			setUnsafeLiteral(UNSAFE_LITERAL_EDEFAULT);
			return;
		case BPELPackage.FROM__SERVICE_REF:
			setServiceRef((ServiceRef) null);
			return;
		case BPELPackage.FROM__TYPE:
			setType((XSDTypeDefinition) null);
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
		case BPELPackage.FROM__VARIABLE:
			return variable != null;
		case BPELPackage.FROM__PART:
			return part != null;
		case BPELPackage.FROM__PARTNER_LINK:
			return partnerLink != null;
		case BPELPackage.FROM__PROPERTY:
			return property != null;
		case BPELPackage.FROM__QUERY:
			return query != null;
		case BPELPackage.FROM__EXPRESSION:
			return expression != null;
		case BPELPackage.FROM__OPAQUE:
			return isSetOpaque();
		case BPELPackage.FROM__ENDPOINT_REFERENCE:
			return isSetEndpointReference();
		case BPELPackage.FROM__LITERAL:
			return isSetLiteral();
		case BPELPackage.FROM__UNSAFE_LITERAL:
			return UNSAFE_LITERAL_EDEFAULT == null ? unsafeLiteral != null
					: !UNSAFE_LITERAL_EDEFAULT.equals(unsafeLiteral);
		case BPELPackage.FROM__SERVICE_REF:
			return serviceRef != null;
		case BPELPackage.FROM__TYPE:
			return type != null;
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
			case BPELPackage.FROM__VARIABLE:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__VARIABLE;
			case BPELPackage.FROM__PART:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__PART;
			case BPELPackage.FROM__PARTNER_LINK:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK;
			case BPELPackage.FROM__PROPERTY:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY;
			case BPELPackage.FROM__QUERY:
				return BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY;
			case BPELPackage.FROM__EXPRESSION:
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
				return BPELPackage.FROM__VARIABLE;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__PART:
				return BPELPackage.FROM__PART;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__PARTNER_LINK:
				return BPELPackage.FROM__PARTNER_LINK;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__PROPERTY:
				return BPELPackage.FROM__PROPERTY;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__QUERY:
				return BPELPackage.FROM__QUERY;
			case BPELPackage.ABSTRACT_ASSIGN_BOUND__EXPRESSION:
				return BPELPackage.FROM__EXPRESSION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (opaque: "); //$NON-NLS-1$
		if (opaqueESet)
			result.append(opaque);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", endpointReference: "); //$NON-NLS-1$
		if (endpointReferenceESet)
			result.append(endpointReference);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", literal: "); //$NON-NLS-1$
		if (literalESet)
			result.append(literal);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", unsafeLiteral: "); //$NON-NLS-1$
		result.append(unsafeLiteral);
		result.append(')');
		return result.toString();
	}

} //FromImpl
