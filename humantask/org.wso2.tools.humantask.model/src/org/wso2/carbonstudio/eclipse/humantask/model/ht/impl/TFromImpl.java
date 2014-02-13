/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import java.util.Collection;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TFrom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl#getLogicalPeopleGroup <em>Logical People Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TFromImpl extends TExtensibleMixedContentElementsImpl implements TFrom {
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
	 * The default value of the '{@link #getLogicalPeopleGroup() <em>Logical People Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalPeopleGroup()
	 * @generated
	 * @ordered
	 */
	protected static final QName LOGICAL_PEOPLE_GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogicalPeopleGroup() <em>Logical People Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalPeopleGroup()
	 * @generated
	 * @ordered
	 */
	protected QName logicalPeopleGroup = LOGICAL_PEOPLE_GROUP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TFromImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TFROM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TArgument> getArgument() {
		return getMixed().list(HTPackage.Literals.TFROM__ARGUMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLiteral getLiteral() {
		return (TLiteral)getMixed().get(HTPackage.Literals.TFROM__LITERAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLiteral(TLiteral newLiteral, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HTPackage.Literals.TFROM__LITERAL, newLiteral, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteral(TLiteral newLiteral) {
		((FeatureMap.Internal)getMixed()).set(HTPackage.Literals.TFROM__LITERAL, newLiteral);
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
	 * @generated
	 */
	public void setExpressionLanguage(String newExpressionLanguage) {
		String oldExpressionLanguage = expressionLanguage;
		expressionLanguage = newExpressionLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TFROM__EXPRESSION_LANGUAGE, oldExpressionLanguage, expressionLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getLogicalPeopleGroup() {
		return logicalPeopleGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalPeopleGroup(QName newLogicalPeopleGroup) {
		QName oldLogicalPeopleGroup = logicalPeopleGroup;
		logicalPeopleGroup = newLogicalPeopleGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TFROM__LOGICAL_PEOPLE_GROUP, oldLogicalPeopleGroup, logicalPeopleGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TFROM__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
			case HTPackage.TFROM__LITERAL:
				return basicSetLiteral(null, msgs);
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
			case HTPackage.TFROM__ARGUMENT:
				return getArgument();
			case HTPackage.TFROM__LITERAL:
				return getLiteral();
			case HTPackage.TFROM__EXPRESSION_LANGUAGE:
				return getExpressionLanguage();
			case HTPackage.TFROM__LOGICAL_PEOPLE_GROUP:
				return getLogicalPeopleGroup();
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
			case HTPackage.TFROM__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends TArgument>)newValue);
				return;
			case HTPackage.TFROM__LITERAL:
				setLiteral((TLiteral)newValue);
				return;
			case HTPackage.TFROM__EXPRESSION_LANGUAGE:
				setExpressionLanguage((String)newValue);
				return;
			case HTPackage.TFROM__LOGICAL_PEOPLE_GROUP:
				setLogicalPeopleGroup((QName)newValue);
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
			case HTPackage.TFROM__ARGUMENT:
				getArgument().clear();
				return;
			case HTPackage.TFROM__LITERAL:
				setLiteral((TLiteral)null);
				return;
			case HTPackage.TFROM__EXPRESSION_LANGUAGE:
				setExpressionLanguage(EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case HTPackage.TFROM__LOGICAL_PEOPLE_GROUP:
				setLogicalPeopleGroup(LOGICAL_PEOPLE_GROUP_EDEFAULT);
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
			case HTPackage.TFROM__ARGUMENT:
				return !getArgument().isEmpty();
			case HTPackage.TFROM__LITERAL:
				return getLiteral() != null;
			case HTPackage.TFROM__EXPRESSION_LANGUAGE:
				return EXPRESSION_LANGUAGE_EDEFAULT == null ? expressionLanguage != null : !EXPRESSION_LANGUAGE_EDEFAULT.equals(expressionLanguage);
			case HTPackage.TFROM__LOGICAL_PEOPLE_GROUP:
				return LOGICAL_PEOPLE_GROUP_EDEFAULT == null ? logicalPeopleGroup != null : !LOGICAL_PEOPLE_GROUP_EDEFAULT.equals(logicalPeopleGroup);
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
		result.append(" (expressionLanguage: ");
		result.append(expressionLanguage);
		result.append(", logicalPeopleGroup: ");
		result.append(logicalPeopleGroup);
		result.append(')');
		return result.toString();
	}

} //TFromImpl
