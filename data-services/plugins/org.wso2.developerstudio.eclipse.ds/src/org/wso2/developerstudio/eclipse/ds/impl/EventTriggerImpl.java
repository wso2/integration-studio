/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.EventSubscriptionList;
import org.wso2.developerstudio.eclipse.ds.EventTrigger;
import org.wso2.developerstudio.eclipse.ds.Expression;
import org.wso2.developerstudio.eclipse.ds.TargetTopic;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl#getTargetTopic <em>Target Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl#getSubscriptions <em>Subscriptions</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventTriggerImpl extends EObjectImpl implements EventTrigger {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	protected EClass eStaticClass() {
		return DsPackage.Literals.EVENT_TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DsPackage.EVENT_TRIGGER__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)getMixed().get(DsPackage.Literals.EVENT_TRIGGER__EXPRESSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.EVENT_TRIGGER__EXPRESSION, newExpression, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.EVENT_TRIGGER__EXPRESSION, newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetTopic getTargetTopic() {
		return (TargetTopic)getMixed().get(DsPackage.Literals.EVENT_TRIGGER__TARGET_TOPIC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetTopic(TargetTopic newTargetTopic, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.EVENT_TRIGGER__TARGET_TOPIC, newTargetTopic, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTopic(TargetTopic newTargetTopic) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.EVENT_TRIGGER__TARGET_TOPIC, newTargetTopic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSubscriptionList getSubscriptions() {
		return (EventSubscriptionList)getMixed().get(DsPackage.Literals.EVENT_TRIGGER__SUBSCRIPTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubscriptions(EventSubscriptionList newSubscriptions,
	                                               NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DsPackage.Literals.EVENT_TRIGGER__SUBSCRIPTIONS, newSubscriptions, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscriptions(EventSubscriptionList newSubscriptions) {
		((FeatureMap.Internal)getMixed()).set(DsPackage.Literals.EVENT_TRIGGER__SUBSCRIPTIONS, newSubscriptions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.EVENT_TRIGGER__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DsPackage.EVENT_TRIGGER__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
	                                        NotificationChain msgs) {
		switch (featureID) {
			case DsPackage.EVENT_TRIGGER__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case DsPackage.EVENT_TRIGGER__EXPRESSION:
				return basicSetExpression(null, msgs);
			case DsPackage.EVENT_TRIGGER__TARGET_TOPIC:
				return basicSetTargetTopic(null, msgs);
			case DsPackage.EVENT_TRIGGER__SUBSCRIPTIONS:
				return basicSetSubscriptions(null, msgs);
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
			case DsPackage.EVENT_TRIGGER__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DsPackage.EVENT_TRIGGER__EXPRESSION:
				return getExpression();
			case DsPackage.EVENT_TRIGGER__TARGET_TOPIC:
				return getTargetTopic();
			case DsPackage.EVENT_TRIGGER__SUBSCRIPTIONS:
				return getSubscriptions();
			case DsPackage.EVENT_TRIGGER__ID:
				return getId();
			case DsPackage.EVENT_TRIGGER__LANGUAGE:
				return getLanguage();
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
			case DsPackage.EVENT_TRIGGER__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DsPackage.EVENT_TRIGGER__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case DsPackage.EVENT_TRIGGER__TARGET_TOPIC:
				setTargetTopic((TargetTopic)newValue);
				return;
			case DsPackage.EVENT_TRIGGER__SUBSCRIPTIONS:
				setSubscriptions((EventSubscriptionList)newValue);
				return;
			case DsPackage.EVENT_TRIGGER__ID:
				setId((String)newValue);
				return;
			case DsPackage.EVENT_TRIGGER__LANGUAGE:
				setLanguage((String)newValue);
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
			case DsPackage.EVENT_TRIGGER__MIXED:
				getMixed().clear();
				return;
			case DsPackage.EVENT_TRIGGER__EXPRESSION:
				setExpression((Expression)null);
				return;
			case DsPackage.EVENT_TRIGGER__TARGET_TOPIC:
				setTargetTopic((TargetTopic)null);
				return;
			case DsPackage.EVENT_TRIGGER__SUBSCRIPTIONS:
				setSubscriptions((EventSubscriptionList)null);
				return;
			case DsPackage.EVENT_TRIGGER__ID:
				setId(ID_EDEFAULT);
				return;
			case DsPackage.EVENT_TRIGGER__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
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
			case DsPackage.EVENT_TRIGGER__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DsPackage.EVENT_TRIGGER__EXPRESSION:
				return getExpression() != null;
			case DsPackage.EVENT_TRIGGER__TARGET_TOPIC:
				return getTargetTopic() != null;
			case DsPackage.EVENT_TRIGGER__SUBSCRIPTIONS:
				return getSubscriptions() != null;
			case DsPackage.EVENT_TRIGGER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DsPackage.EVENT_TRIGGER__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(", id: ");
		result.append(id);
		result.append(", language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}

} // EventTriggerImpl
