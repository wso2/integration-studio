/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediatorOutputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spring Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SpringMediatorImpl#getBeanName <em>Bean Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SpringMediatorImpl#getConfigurationKey <em>Configuration Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SpringMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SpringMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpringMediatorImpl extends MediatorImpl implements SpringMediator {
	/**
	 * The default value of the '{@link #getBeanName() <em>Bean Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeanName()
	 * @generated
	 * @ordered
	 */
	protected static final String BEAN_NAME_EDEFAULT = "bean_name";

	/**
	 * The cached value of the '{@link #getBeanName() <em>Bean Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeanName()
	 * @generated
	 * @ordered
	 */
	protected String beanName = BEAN_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfigurationKey() <em>Configuration Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty configurationKey;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected SpringMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected SpringMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SpringMediatorImpl() {
		super();		
		
		// Spring configuration pointer.
		RegistryKeyProperty configurationKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		configurationKey.setPrettyName("Spring Configuration");
		configurationKey.setKeyName("key");
		configurationKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setConfigurationKey(configurationKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SPRING_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBeanName() {
		return beanName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeanName(String newBeanName) {
		String oldBeanName = beanName;
		beanName = newBeanName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SPRING_MEDIATOR__BEAN_NAME, oldBeanName, beanName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getConfigurationKey() {
		return configurationKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurationKey(RegistryKeyProperty newConfigurationKey, NotificationChain msgs) {
		RegistryKeyProperty oldConfigurationKey = configurationKey;
		configurationKey = newConfigurationKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY, oldConfigurationKey, newConfigurationKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationKey(RegistryKeyProperty newConfigurationKey) {
		if (newConfigurationKey != configurationKey) {
			NotificationChain msgs = null;
			if (configurationKey != null)
				msgs = ((InternalEObject)configurationKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY, null, msgs);
			if (newConfigurationKey != null)
				msgs = ((InternalEObject)newConfigurationKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY, null, msgs);
			msgs = basicSetConfigurationKey(newConfigurationKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY, newConfigurationKey, newConfigurationKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpringMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(SpringMediatorInputConnector newInputConnector, NotificationChain msgs) {
		SpringMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(SpringMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpringMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(SpringMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		SpringMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(SpringMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY:
				return basicSetConfigurationKey(null, msgs);
			case EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.SPRING_MEDIATOR__BEAN_NAME:
				return getBeanName();
			case EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY:
				return getConfigurationKey();
			case EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
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
			case EsbPackage.SPRING_MEDIATOR__BEAN_NAME:
				setBeanName((String)newValue);
				return;
			case EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY:
				setConfigurationKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((SpringMediatorInputConnector)newValue);
				return;
			case EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((SpringMediatorOutputConnector)newValue);
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
			case EsbPackage.SPRING_MEDIATOR__BEAN_NAME:
				setBeanName(BEAN_NAME_EDEFAULT);
				return;
			case EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY:
				setConfigurationKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((SpringMediatorInputConnector)null);
				return;
			case EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((SpringMediatorOutputConnector)null);
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
			case EsbPackage.SPRING_MEDIATOR__BEAN_NAME:
				return BEAN_NAME_EDEFAULT == null ? beanName != null : !BEAN_NAME_EDEFAULT.equals(beanName);
			case EsbPackage.SPRING_MEDIATOR__CONFIGURATION_KEY:
				return configurationKey != null;
			case EsbPackage.SPRING_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.SPRING_MEDIATOR__OUTPUT_CONNECTOR:
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
		result.append(" (beanName: ");
		result.append(beanName);
		result.append(')');
		return result.toString();
	}

} //SpringMediatorImpl
