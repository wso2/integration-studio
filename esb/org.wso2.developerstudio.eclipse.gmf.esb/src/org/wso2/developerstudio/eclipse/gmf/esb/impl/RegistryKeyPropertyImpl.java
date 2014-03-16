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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registry Key Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl#getPrettyName <em>Pretty Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl#getKeyName <em>Key Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl#getKeyValue <em>Key Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistryKeyPropertyImpl extends EObjectImpl implements RegistryKeyProperty {
	/**
	 * The default value of the '{@link #getPrettyName() <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrettyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRETTY_NAME_EDEFAULT = "Registry Key";

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
	 * The default value of the '{@link #getKeyName() <em>Key Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyName()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_NAME_EDEFAULT = "keyName";

	/**
	 * The cached value of the '{@link #getKeyName() <em>Key Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyName()
	 * @generated
	 * @ordered
	 */
	protected String keyName = KEY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyValue() <em>Key Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String KEY_VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getKeyValue() <em>Key Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyValue()
	 * @generated
	 * @ordered
	 */
	protected String keyValue = KEY_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilters() <em>Filters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilters()
	 * @generated
	 * @ordered
	 */
	protected Map<?, ?> filters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RegistryKeyPropertyImpl() {
		super();
		filters=new HashMap<String, String>();
	}

    public void doLoad(Element self) throws Exception {
		setKeyValue(self.getAttribute(getKeyName()));
    }

    public Element doSave(Element parent) throws Exception {
		parent.setAttribute(getKeyName(), getKeyValue());
		return parent;    
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.REGISTRY_KEY_PROPERTY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.REGISTRY_KEY_PROPERTY__PRETTY_NAME, oldPrettyName, prettyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyName() {
		return keyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyName(String newKeyName) {
		String oldKeyName = keyName;
		keyName = newKeyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.REGISTRY_KEY_PROPERTY__KEY_NAME, oldKeyName, keyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyValue() {
		return keyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyValue(String newKeyValue) {
		String oldKeyValue = keyValue;
		keyValue = newKeyValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.REGISTRY_KEY_PROPERTY__KEY_VALUE, oldKeyValue, keyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> getFilters() {
		return filters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilters(Map<?, ?> newFilters) {
		Map<?, ?> oldFilters = filters;
		filters = newFilters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.REGISTRY_KEY_PROPERTY__FILTERS, oldFilters, filters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.REGISTRY_KEY_PROPERTY__PRETTY_NAME:
				return getPrettyName();
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_NAME:
				return getKeyName();
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_VALUE:
				return getKeyValue();
			case EsbPackage.REGISTRY_KEY_PROPERTY__FILTERS:
				return getFilters();
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
			case EsbPackage.REGISTRY_KEY_PROPERTY__PRETTY_NAME:
				setPrettyName((String)newValue);
				return;
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_NAME:
				setKeyName((String)newValue);
				return;
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_VALUE:
				setKeyValue((String)newValue);
				return;
			case EsbPackage.REGISTRY_KEY_PROPERTY__FILTERS:
				setFilters((Map<?, ?>)newValue);
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
			case EsbPackage.REGISTRY_KEY_PROPERTY__PRETTY_NAME:
				setPrettyName(PRETTY_NAME_EDEFAULT);
				return;
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_NAME:
				setKeyName(KEY_NAME_EDEFAULT);
				return;
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_VALUE:
				setKeyValue(KEY_VALUE_EDEFAULT);
				return;
			case EsbPackage.REGISTRY_KEY_PROPERTY__FILTERS:
				setFilters((Map<?, ?>)null);
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
			case EsbPackage.REGISTRY_KEY_PROPERTY__PRETTY_NAME:
				return PRETTY_NAME_EDEFAULT == null ? prettyName != null : !PRETTY_NAME_EDEFAULT.equals(prettyName);
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_NAME:
				return KEY_NAME_EDEFAULT == null ? keyName != null : !KEY_NAME_EDEFAULT.equals(keyName);
			case EsbPackage.REGISTRY_KEY_PROPERTY__KEY_VALUE:
				return KEY_VALUE_EDEFAULT == null ? keyValue != null : !KEY_VALUE_EDEFAULT.equals(keyValue);
			case EsbPackage.REGISTRY_KEY_PROPERTY__FILTERS:
				return filters != null;
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
		result.append(keyValue);
		return result.toString();
	}
	
	private String localPathOfRegistryKey = null;
	public void setLocalPathOfRegistryKey(String localPathOfRegistryKey) {
		this.localPathOfRegistryKey = localPathOfRegistryKey;
	}
	public String getLocalPathOfRegistryKey() {
		return localPathOfRegistryKey;
	}

} //RegistryKeyPropertyImpl
