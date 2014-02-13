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
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFormatType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Payload Factory Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryMediatorImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryMediatorImpl#getFormatKey <em>Format Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryMediatorImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryMediatorImpl#getMediaType <em>Media Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.PayloadFactoryMediatorImpl#getPayloadFormat <em>Payload Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PayloadFactoryMediatorImpl extends MediatorImpl implements PayloadFactoryMediator {
	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormatKey() <em>Format Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty formatKey;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<PayloadFactoryArgument> args;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected PayloadFactoryMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected PayloadFactoryMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getMediaType() <em>Media Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediaType()
	 * @generated
	 * @ordered
	 */
	protected static final MediaType MEDIA_TYPE_EDEFAULT = MediaType.XML;

	/**
	 * The cached value of the '{@link #getMediaType() <em>Media Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediaType()
	 * @generated
	 * @ordered
	 */
	protected MediaType mediaType = MEDIA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPayloadFormat() <em>Payload Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadFormat()
	 * @generated
	 * @ordered
	 */
	protected static final PayloadFormatType PAYLOAD_FORMAT_EDEFAULT = PayloadFormatType.INLINE;

	/**
	 * The cached value of the '{@link #getPayloadFormat() <em>Payload Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayloadFormat()
	 * @generated
	 * @ordered
	 */
	protected PayloadFormatType payloadFormat = PAYLOAD_FORMAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected PayloadFactoryMediatorImpl() {
		super();
		setFormat("<inline/>");
		
		RegistryKeyProperty payloadFormatKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		payloadFormatKey.setKeyName("Sequence Key");
		payloadFormatKey.setPrettyName("Sequence Key");
		payloadFormatKey.setKeyValue("/default/key");
		setFormatKey(payloadFormatKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PAYLOAD_FACTORY_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getFormatKey() {
		return formatKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormatKey(RegistryKeyProperty newFormatKey, NotificationChain msgs) {
		RegistryKeyProperty oldFormatKey = formatKey;
		formatKey = newFormatKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY, oldFormatKey, newFormatKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormatKey(RegistryKeyProperty newFormatKey) {
		if (newFormatKey != formatKey) {
			NotificationChain msgs = null;
			if (formatKey != null)
				msgs = ((InternalEObject)formatKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY, null, msgs);
			if (newFormatKey != null)
				msgs = ((InternalEObject)newFormatKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY, null, msgs);
			msgs = basicSetFormatKey(newFormatKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY, newFormatKey, newFormatKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PayloadFactoryArgument> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<PayloadFactoryArgument>(PayloadFactoryArgument.class, this, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFactoryMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(PayloadFactoryMediatorInputConnector newInputConnector, NotificationChain msgs) {
		PayloadFactoryMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(PayloadFactoryMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFactoryMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(PayloadFactoryMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		PayloadFactoryMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(PayloadFactoryMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaType getMediaType() {
		return mediaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediaType(MediaType newMediaType) {
		MediaType oldMediaType = mediaType;
		mediaType = newMediaType == null ? MEDIA_TYPE_EDEFAULT : newMediaType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE, oldMediaType, mediaType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFormatType getPayloadFormat() {
		return payloadFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayloadFormat(PayloadFormatType newPayloadFormat) {
		PayloadFormatType oldPayloadFormat = payloadFormat;
		payloadFormat = newPayloadFormat == null ? PAYLOAD_FORMAT_EDEFAULT : newPayloadFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT, oldPayloadFormat, payloadFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY:
				return basicSetFormatKey(null, msgs);
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				return getFormat();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY:
				return getFormatKey();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				return getArgs();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE:
				return getMediaType();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT:
				return getPayloadFormat();
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
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				setFormat((String)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY:
				setFormatKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends PayloadFactoryArgument>)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((PayloadFactoryMediatorInputConnector)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((PayloadFactoryMediatorOutputConnector)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE:
				setMediaType((MediaType)newValue);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT:
				setPayloadFormat((PayloadFormatType)newValue);
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
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY:
				setFormatKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				getArgs().clear();
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((PayloadFactoryMediatorInputConnector)null);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((PayloadFactoryMediatorOutputConnector)null);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE:
				setMediaType(MEDIA_TYPE_EDEFAULT);
				return;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT:
				setPayloadFormat(PAYLOAD_FORMAT_EDEFAULT);
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
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__FORMAT_KEY:
				return formatKey != null;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__ARGS:
				return args != null && !args.isEmpty();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__MEDIA_TYPE:
				return mediaType != MEDIA_TYPE_EDEFAULT;
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR__PAYLOAD_FORMAT:
				return payloadFormat != PAYLOAD_FORMAT_EDEFAULT;
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
		result.append(" (format: ");
		result.append(format);
		result.append(", mediaType: ");
		result.append(mediaType);
		result.append(", payloadFormat: ");
		result.append(payloadFormat);
		result.append(')');
		return result.toString();
	}

} //PayloadFactoryMediatorImpl
