/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactsConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Facts Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RuleFactsConfigurationImpl#getFacts <em>Facts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleFactsConfigurationImpl extends EObjectImpl implements RuleFactsConfiguration {
	/**
	 * The cached value of the '{@link #getFacts() <em>Facts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacts()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleFact> facts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleFactsConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.RULE_FACTS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RuleFact> getFacts() {
		if (facts == null) {
			facts = new EObjectContainmentEList<RuleFact>(RuleFact.class, this, EsbPackage.RULE_FACTS_CONFIGURATION__FACTS);
		}
		return facts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.RULE_FACTS_CONFIGURATION__FACTS:
				return ((InternalEList<?>)getFacts()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.RULE_FACTS_CONFIGURATION__FACTS:
				return getFacts();
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
			case EsbPackage.RULE_FACTS_CONFIGURATION__FACTS:
				getFacts().clear();
				getFacts().addAll((Collection<? extends RuleFact>)newValue);
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
			case EsbPackage.RULE_FACTS_CONFIGURATION__FACTS:
				getFacts().clear();
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
			case EsbPackage.RULE_FACTS_CONFIGURATION__FACTS:
				return facts != null && !facts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RuleFactsConfigurationImpl
