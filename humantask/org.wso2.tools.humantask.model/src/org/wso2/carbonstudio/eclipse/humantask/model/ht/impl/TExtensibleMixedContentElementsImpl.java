/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TExtensible Mixed Content Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TExtensibleMixedContentElementsImpl extends EObjectImpl implements TExtensibleMixedContentElements {
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
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TExtensibleMixedContentElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TDocumentation> getDocumentation() {
		return getMixed().list(HTPackage.Literals.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getMixed().<FeatureMap.Entry>list(HTPackage.Literals.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION:
				return ((InternalEList<?>)getDocumentation()).basicRemove(otherEnd, msgs);
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION:
				return getDocumentation();
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION:
				getDocumentation().clear();
				getDocumentation().addAll((Collection<? extends TDocumentation>)newValue);
				return;
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED:
				getMixed().clear();
				return;
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION:
				getDocumentation().clear();
				return;
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY:
				getAny().clear();
				return;
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED:
				return mixed != null && !mixed.isEmpty();
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION:
				return !getDocumentation().isEmpty();
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY:
				return !getAny().isEmpty();
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //TExtensibleMixedContentElementsImpl
