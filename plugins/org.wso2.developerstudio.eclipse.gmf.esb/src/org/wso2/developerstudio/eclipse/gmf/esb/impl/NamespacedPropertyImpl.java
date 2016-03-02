/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Namespaced Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamespacedPropertyImpl#getPrettyName <em>Pretty Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamespacedPropertyImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamespacedPropertyImpl#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamespacedPropertyImpl#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamespacedPropertyImpl#isSupportsDynamicXPaths <em>Supports Dynamic XPaths</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.NamespacedPropertyImpl#isDynamic <em>Dynamic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamespacedPropertyImpl extends EsbNodeImpl implements NamespacedProperty {
	/**
	 * The default value of the '{@link #getPrettyName() <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrettyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRETTY_NAME_EDEFAULT = "Namespaced Property";

	/**
	 * The cached value of the '{@link #getPrettyName() <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrettyName()
	 * @generated
	 * @ordered
	 */
	protected String prettyName = PRETTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_EDEFAULT = "propertyName";

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyValue() <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String PROPERTY_VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPropertyValue() <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected String propertyValue = PROPERTY_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNamespaces() <em>Namespaces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaces()
	 * @generated
	 * @ordered
	 */
	protected Map<String, String> namespaces;

	/**
	 * The default value of the '{@link #isSupportsDynamicXPaths() <em>Supports Dynamic XPaths</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSupportsDynamicXPaths()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPORTS_DYNAMIC_XPATHS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSupportsDynamicXPaths() <em>Supports Dynamic XPaths</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSupportsDynamicXPaths()
	 * @generated
	 * @ordered
	 */
	protected boolean supportsDynamicXPaths = SUPPORTS_DYNAMIC_XPATHS_EDEFAULT;

	/**
	 * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamic = DYNAMIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected NamespacedPropertyImpl() {
		super();
		setNamespaces(new HashMap<String, String>());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.NAMESPACED_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrettyName() {
		return prettyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrettyName(String newPrettyName) {
		String oldPrettyName = prettyName;
		prettyName = newPrettyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMESPACED_PROPERTY__PRETTY_NAME, oldPrettyName, prettyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName) {
		String oldPropertyName = propertyName;
		propertyName = newPropertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMESPACED_PROPERTY__PROPERTY_NAME, oldPropertyName, propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyValue(String newPropertyValue) {
		String oldPropertyValue = propertyValue;
		propertyValue = newPropertyValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMESPACED_PROPERTY__PROPERTY_VALUE, oldPropertyValue, propertyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, String> getNamespaces() {
		return namespaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespaces(Map<String, String> newNamespaces) {
		Map<String, String> oldNamespaces = namespaces;
		namespaces = newNamespaces;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMESPACED_PROPERTY__NAMESPACES, oldNamespaces, namespaces));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSupportsDynamicXPaths() {
		return supportsDynamicXPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupportsDynamicXPaths(boolean newSupportsDynamicXPaths) {
		boolean oldSupportsDynamicXPaths = supportsDynamicXPaths;
		supportsDynamicXPaths = newSupportsDynamicXPaths;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS, oldSupportsDynamicXPaths, supportsDynamicXPaths));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamic(boolean newDynamic) {
		boolean oldDynamic = dynamic;
		dynamic = newDynamic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NAMESPACED_PROPERTY__DYNAMIC, oldDynamic, dynamic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.NAMESPACED_PROPERTY__PRETTY_NAME:
				return getPrettyName();
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_NAME:
				return getPropertyName();
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_VALUE:
				return getPropertyValue();
			case EsbPackage.NAMESPACED_PROPERTY__NAMESPACES:
				return getNamespaces();
			case EsbPackage.NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS:
				return isSupportsDynamicXPaths();
			case EsbPackage.NAMESPACED_PROPERTY__DYNAMIC:
				return isDynamic();
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
			case EsbPackage.NAMESPACED_PROPERTY__PRETTY_NAME:
				setPrettyName((String)newValue);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_VALUE:
				setPropertyValue((String)newValue);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__NAMESPACES:
				setNamespaces((Map<String, String>)newValue);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS:
				setSupportsDynamicXPaths((Boolean)newValue);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__DYNAMIC:
				setDynamic((Boolean)newValue);
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
			case EsbPackage.NAMESPACED_PROPERTY__PRETTY_NAME:
				setPrettyName(PRETTY_NAME_EDEFAULT);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_EDEFAULT);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_VALUE:
				setPropertyValue(PROPERTY_VALUE_EDEFAULT);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__NAMESPACES:
				setNamespaces((Map<String, String>)null);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS:
				setSupportsDynamicXPaths(SUPPORTS_DYNAMIC_XPATHS_EDEFAULT);
				return;
			case EsbPackage.NAMESPACED_PROPERTY__DYNAMIC:
				setDynamic(DYNAMIC_EDEFAULT);
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
			case EsbPackage.NAMESPACED_PROPERTY__PRETTY_NAME:
				return PRETTY_NAME_EDEFAULT == null ? prettyName != null : !PRETTY_NAME_EDEFAULT.equals(prettyName);
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_NAME:
				return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
			case EsbPackage.NAMESPACED_PROPERTY__PROPERTY_VALUE:
				return PROPERTY_VALUE_EDEFAULT == null ? propertyValue != null : !PROPERTY_VALUE_EDEFAULT.equals(propertyValue);
			case EsbPackage.NAMESPACED_PROPERTY__NAMESPACES:
				return namespaces != null;
			case EsbPackage.NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS:
				return supportsDynamicXPaths != SUPPORTS_DYNAMIC_XPATHS_EDEFAULT;
			case EsbPackage.NAMESPACED_PROPERTY__DYNAMIC:
				return dynamic != DYNAMIC_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(getPropertyValue());
		return result.toString();
	}

} //NamespacedPropertyImpl
