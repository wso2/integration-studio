/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateTargetImpl#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.IterateTargetImpl#getToAddress <em>To Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterateTargetImpl extends AbstractCommonTargetImpl implements IterateTarget {
	/**
	 * The default value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected static final String SOAP_ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected String soapAction = SOAP_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getToAddress() <em>To Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToAddress() <em>To Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToAddress()
	 * @generated
	 * @ordered
	 */
	protected String toAddress = TO_ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected IterateTargetImpl() {
		super();
		
		// Sequence key.
		RegistryKeyProperty sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		//Set filter properties to filter in only sequences media type
		//DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)sequenceKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);

		sequenceKey.setPrettyName("Sequence Key");
		sequenceKey.setKeyName("sequence");
		sequenceKey.setKeyValue("/default/sequence");
		setSequenceKey(sequenceKey);
		
		// Endpoint key.
		RegistryKeyProperty endpointKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		//Set filter properties to filter in only sequences media type
		//DeveloperStudioProviderUtils.addFilter((Map<String, List<String>>)endpointKey.getFilters(), CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_ENDPOINT);

		endpointKey.setPrettyName("Endpoint Key");
		endpointKey.setKeyName("endpoint");
		endpointKey.setKeyValue("/default/endpoint");
		setEndpointKey(endpointKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ITERATE_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSoapAction() {
		return soapAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoapAction(String newSoapAction) {
		String oldSoapAction = soapAction;
		soapAction = newSoapAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_TARGET__SOAP_ACTION, oldSoapAction, soapAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToAddress() {
		return toAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToAddress(String newToAddress) {
		String oldToAddress = toAddress;
		toAddress = newToAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ITERATE_TARGET__TO_ADDRESS, oldToAddress, toAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.ITERATE_TARGET__SOAP_ACTION:
				return getSoapAction();
			case EsbPackage.ITERATE_TARGET__TO_ADDRESS:
				return getToAddress();
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
			case EsbPackage.ITERATE_TARGET__SOAP_ACTION:
				setSoapAction((String)newValue);
				return;
			case EsbPackage.ITERATE_TARGET__TO_ADDRESS:
				setToAddress((String)newValue);
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
			case EsbPackage.ITERATE_TARGET__SOAP_ACTION:
				setSoapAction(SOAP_ACTION_EDEFAULT);
				return;
			case EsbPackage.ITERATE_TARGET__TO_ADDRESS:
				setToAddress(TO_ADDRESS_EDEFAULT);
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
			case EsbPackage.ITERATE_TARGET__SOAP_ACTION:
				return SOAP_ACTION_EDEFAULT == null ? soapAction != null : !SOAP_ACTION_EDEFAULT.equals(soapAction);
			case EsbPackage.ITERATE_TARGET__TO_ADDRESS:
				return TO_ADDRESS_EDEFAULT == null ? toAddress != null : !TO_ADDRESS_EDEFAULT.equals(toAddress);
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
		result.append(" (soapAction: ");
		result.append(soapAction);
		result.append(", toAddress: ");
		result.append(toAddress);
		result.append(')');
		return result.toString();
	}

} //IterateTargetImpl
