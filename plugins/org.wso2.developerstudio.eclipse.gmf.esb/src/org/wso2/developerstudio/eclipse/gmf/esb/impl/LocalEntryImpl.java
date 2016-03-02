/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntryValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LocalEntryImpl#getEntryName <em>Entry Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LocalEntryImpl#getLocalEntryType <em>Local Entry Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LocalEntryImpl#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LocalEntryImpl#getValueXML <em>Value XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LocalEntryImpl#getValueURL <em>Value URL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalEntryImpl extends EsbElementImpl implements LocalEntry {
	/**
	 * The default value of the '{@link #getEntryName() <em>Entry Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_NAME_EDEFAULT = "entry_name";
	/**
	 * The cached value of the '{@link #getEntryName() <em>Entry Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryName()
	 * @generated
	 * @ordered
	 */
	protected String entryName = ENTRY_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getLocalEntryType() <em>Local Entry Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalEntryType()
	 * @generated
	 * @ordered
	 */
	protected static final LocalEntryValueType LOCAL_ENTRY_TYPE_EDEFAULT = LocalEntryValueType.LITERAL;
	/**
	 * The cached value of the '{@link #getLocalEntryType() <em>Local Entry Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalEntryType()
	 * @generated
	 * @ordered
	 */
	protected LocalEntryValueType localEntryType = LOCAL_ENTRY_TYPE_EDEFAULT;
	/**
	 * The default value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_LITERAL_EDEFAULT = "entry_value";
	/**
	 * The cached value of the '{@link #getValueLiteral() <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected String valueLiteral = VALUE_LITERAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getValueXML() <em>Value XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueXML()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_XML_EDEFAULT = "<value/>";
	/**
	 * The cached value of the '{@link #getValueXML() <em>Value XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueXML()
	 * @generated
	 * @ordered
	 */
	protected String valueXML = VALUE_XML_EDEFAULT;
	/**
	 * The default value of the '{@link #getValueURL() <em>Value URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueURL()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_URL_EDEFAULT = "file:/path/to/resource.ext";
	/**
	 * The cached value of the '{@link #getValueURL() <em>Value URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueURL()
	 * @generated
	 * @ordered
	 */
	protected String valueURL = VALUE_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.LOCAL_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntryName() {
		return entryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryName(String newEntryName) {
		String oldEntryName = entryName;
		entryName = newEntryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__ENTRY_NAME, oldEntryName, entryName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalEntryValueType getLocalEntryType() {
		return localEntryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalEntryType(LocalEntryValueType newLocalEntryType) {
		LocalEntryValueType oldLocalEntryType = localEntryType;
		localEntryType = newLocalEntryType == null ? LOCAL_ENTRY_TYPE_EDEFAULT : newLocalEntryType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__LOCAL_ENTRY_TYPE, oldLocalEntryType, localEntryType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueLiteral() {
		return valueLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueLiteral(String newValueLiteral) {
		String oldValueLiteral = valueLiteral;
		valueLiteral = newValueLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__VALUE_LITERAL, oldValueLiteral, valueLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueXML() {
		return valueXML;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueXML(String newValueXML) {
		String oldValueXML = valueXML;
		valueXML = newValueXML;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__VALUE_XML, oldValueXML, valueXML));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueURL() {
		return valueURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueURL(String newValueURL) {
		String oldValueURL = valueURL;
		valueURL = newValueURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOCAL_ENTRY__VALUE_URL, oldValueURL, valueURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				return getEntryName();
			case EsbPackage.LOCAL_ENTRY__LOCAL_ENTRY_TYPE:
				return getLocalEntryType();
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				return getValueLiteral();
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				return getValueXML();
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				return getValueURL();
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
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				setEntryName((String)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__LOCAL_ENTRY_TYPE:
				setLocalEntryType((LocalEntryValueType)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				setValueLiteral((String)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				setValueXML((String)newValue);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				setValueURL((String)newValue);
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
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				setEntryName(ENTRY_NAME_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__LOCAL_ENTRY_TYPE:
				setLocalEntryType(LOCAL_ENTRY_TYPE_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				setValueLiteral(VALUE_LITERAL_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				setValueXML(VALUE_XML_EDEFAULT);
				return;
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				setValueURL(VALUE_URL_EDEFAULT);
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
			case EsbPackage.LOCAL_ENTRY__ENTRY_NAME:
				return ENTRY_NAME_EDEFAULT == null ? entryName != null : !ENTRY_NAME_EDEFAULT.equals(entryName);
			case EsbPackage.LOCAL_ENTRY__LOCAL_ENTRY_TYPE:
				return localEntryType != LOCAL_ENTRY_TYPE_EDEFAULT;
			case EsbPackage.LOCAL_ENTRY__VALUE_LITERAL:
				return VALUE_LITERAL_EDEFAULT == null ? valueLiteral != null : !VALUE_LITERAL_EDEFAULT.equals(valueLiteral);
			case EsbPackage.LOCAL_ENTRY__VALUE_XML:
				return VALUE_XML_EDEFAULT == null ? valueXML != null : !VALUE_XML_EDEFAULT.equals(valueXML);
			case EsbPackage.LOCAL_ENTRY__VALUE_URL:
				return VALUE_URL_EDEFAULT == null ? valueURL != null : !VALUE_URL_EDEFAULT.equals(valueURL);
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
		result.append(" (entryName: ");
		result.append(entryName);
		result.append(", localEntryType: ");
		result.append(localEntryType);
		result.append(", valueLiteral: ");
		result.append(valueLiteral);
		result.append(", valueXML: ");
		result.append(valueXML);
		result.append(", valueURL: ");
		result.append(valueURL);
		result.append(')');
		return result.toString();
	}

} //LocalEntryImpl
