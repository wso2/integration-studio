/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URL Rewrite Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteMediatorImpl#getUrlRewriteRules <em>Url Rewrite Rules</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteMediatorImpl#getInProperty <em>In Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteMediatorImpl#getOutProperty <em>Out Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.URLRewriteMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLRewriteMediatorImpl extends MediatorImpl implements URLRewriteMediator {
	/**
	 * The cached value of the '{@link #getUrlRewriteRules() <em>Url Rewrite Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlRewriteRules()
	 * @generated
	 * @ordered
	 */
	protected EList<URLRewriteRule> urlRewriteRules;

	/**
	 * The default value of the '{@link #getInProperty() <em>In Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInProperty() <em>In Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInProperty()
	 * @generated
	 * @ordered
	 */
	protected String inProperty = IN_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutProperty() <em>Out Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String OUT_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutProperty() <em>Out Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutProperty()
	 * @generated
	 * @ordered
	 */
	protected String outProperty = OUT_PROPERTY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected URLRewriteMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected URLRewriteMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected URLRewriteMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.URL_REWRITE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URLRewriteRule> getUrlRewriteRules() {
		if (urlRewriteRules == null) {
			urlRewriteRules = new EObjectContainmentEList<URLRewriteRule>(URLRewriteRule.class, this, EsbPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES);
		}
		return urlRewriteRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInProperty() {
		return inProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInProperty(String newInProperty) {
		String oldInProperty = inProperty;
		inProperty = newInProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY, oldInProperty, inProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutProperty() {
		return outProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutProperty(String newOutProperty) {
		String oldOutProperty = outProperty;
		outProperty = newOutProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY, oldOutProperty, outProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLRewriteMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(URLRewriteMediatorInputConnector newInputConnector, NotificationChain msgs) {
		URLRewriteMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(URLRewriteMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLRewriteMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(URLRewriteMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		URLRewriteMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(URLRewriteMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				return ((InternalEList<?>)getUrlRewriteRules()).basicRemove(otherEnd, msgs);
			case EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
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
			case EsbPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				return getUrlRewriteRules();
			case EsbPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				return getInProperty();
			case EsbPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				return getOutProperty();
			case EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				getUrlRewriteRules().clear();
				getUrlRewriteRules().addAll((Collection<? extends URLRewriteRule>)newValue);
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				setInProperty((String)newValue);
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				setOutProperty((String)newValue);
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((URLRewriteMediatorInputConnector)newValue);
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((URLRewriteMediatorOutputConnector)newValue);
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
			case EsbPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				getUrlRewriteRules().clear();
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				setInProperty(IN_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				setOutProperty(OUT_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((URLRewriteMediatorInputConnector)null);
				return;
			case EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((URLRewriteMediatorOutputConnector)null);
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
			case EsbPackage.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES:
				return urlRewriteRules != null && !urlRewriteRules.isEmpty();
			case EsbPackage.URL_REWRITE_MEDIATOR__IN_PROPERTY:
				return IN_PROPERTY_EDEFAULT == null ? inProperty != null : !IN_PROPERTY_EDEFAULT.equals(inProperty);
			case EsbPackage.URL_REWRITE_MEDIATOR__OUT_PROPERTY:
				return OUT_PROPERTY_EDEFAULT == null ? outProperty != null : !OUT_PROPERTY_EDEFAULT.equals(outProperty);
			case EsbPackage.URL_REWRITE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.URL_REWRITE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (InProperty: ");
		result.append(inProperty);
		result.append(", outProperty: ");
		result.append(outProperty);
		result.append(')');
		return result.toString();
	}

} //URLRewriteMediatorImpl
