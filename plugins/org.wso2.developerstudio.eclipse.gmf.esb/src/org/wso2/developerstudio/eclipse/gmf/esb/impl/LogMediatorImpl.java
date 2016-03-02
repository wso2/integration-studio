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
import org.wso2.developerstudio.eclipse.gmf.esb.LogCategory;
import org.wso2.developerstudio.eclipse.gmf.esb.LogLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Log Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LogMediatorImpl#getLogCategory <em>Log Category</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LogMediatorImpl#getLogLevel <em>Log Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LogMediatorImpl#getLogSeparator <em>Log Separator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LogMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LogMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.LogMediatorImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogMediatorImpl extends MediatorImpl implements LogMediator {
	/**
	 * The default value of the '{@link #getLogCategory() <em>Log Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogCategory()
	 * @generated
	 * @ordered
	 */
	protected static final LogCategory LOG_CATEGORY_EDEFAULT = LogCategory.INFO;

	/**
	 * The cached value of the '{@link #getLogCategory() <em>Log Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogCategory()
	 * @generated
	 * @ordered
	 */
	protected LogCategory logCategory = LOG_CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogLevel() <em>Log Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogLevel()
	 * @generated
	 * @ordered
	 */
	protected static final LogLevel LOG_LEVEL_EDEFAULT = LogLevel.SIMPLE;

	/**
	 * The cached value of the '{@link #getLogLevel() <em>Log Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogLevel()
	 * @generated
	 * @ordered
	 */
	protected LogLevel logLevel = LOG_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogSeparator() <em>Log Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogSeparator() <em>Log Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogSeparator()
	 * @generated
	 * @ordered
	 */
	protected String logSeparator = LOG_SEPARATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected LogMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected LogMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<LogProperty> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.LOG_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogCategory getLogCategory() {
		return logCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogCategory(LogCategory newLogCategory) {
		LogCategory oldLogCategory = logCategory;
		logCategory = newLogCategory == null ? LOG_CATEGORY_EDEFAULT : newLogCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOG_MEDIATOR__LOG_CATEGORY, oldLogCategory, logCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogLevel getLogLevel() {
		return logLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogLevel(LogLevel newLogLevel) {
		LogLevel oldLogLevel = logLevel;
		logLevel = newLogLevel == null ? LOG_LEVEL_EDEFAULT : newLogLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOG_MEDIATOR__LOG_LEVEL, oldLogLevel, logLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogSeparator() {
		return logSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogSeparator(String newLogSeparator) {
		String oldLogSeparator = logSeparator;
		logSeparator = newLogSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOG_MEDIATOR__LOG_SEPARATOR, oldLogSeparator, logSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(LogMediatorInputConnector newInputConnector, NotificationChain msgs) {
		LogMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(LogMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(LogMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		LogMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(LogMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<LogProperty>(LogProperty.class, this, EsbPackage.LOG_MEDIATOR__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.LOG_MEDIATOR__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.LOG_MEDIATOR__LOG_CATEGORY:
				return getLogCategory();
			case EsbPackage.LOG_MEDIATOR__LOG_LEVEL:
				return getLogLevel();
			case EsbPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				return getLogSeparator();
			case EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.LOG_MEDIATOR__PROPERTIES:
				return getProperties();
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
			case EsbPackage.LOG_MEDIATOR__LOG_CATEGORY:
				setLogCategory((LogCategory)newValue);
				return;
			case EsbPackage.LOG_MEDIATOR__LOG_LEVEL:
				setLogLevel((LogLevel)newValue);
				return;
			case EsbPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				setLogSeparator((String)newValue);
				return;
			case EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((LogMediatorInputConnector)newValue);
				return;
			case EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((LogMediatorOutputConnector)newValue);
				return;
			case EsbPackage.LOG_MEDIATOR__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends LogProperty>)newValue);
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
			case EsbPackage.LOG_MEDIATOR__LOG_CATEGORY:
				setLogCategory(LOG_CATEGORY_EDEFAULT);
				return;
			case EsbPackage.LOG_MEDIATOR__LOG_LEVEL:
				setLogLevel(LOG_LEVEL_EDEFAULT);
				return;
			case EsbPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				setLogSeparator(LOG_SEPARATOR_EDEFAULT);
				return;
			case EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((LogMediatorInputConnector)null);
				return;
			case EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((LogMediatorOutputConnector)null);
				return;
			case EsbPackage.LOG_MEDIATOR__PROPERTIES:
				getProperties().clear();
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
			case EsbPackage.LOG_MEDIATOR__LOG_CATEGORY:
				return logCategory != LOG_CATEGORY_EDEFAULT;
			case EsbPackage.LOG_MEDIATOR__LOG_LEVEL:
				return logLevel != LOG_LEVEL_EDEFAULT;
			case EsbPackage.LOG_MEDIATOR__LOG_SEPARATOR:
				return LOG_SEPARATOR_EDEFAULT == null ? logSeparator != null : !LOG_SEPARATOR_EDEFAULT.equals(logSeparator);
			case EsbPackage.LOG_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.LOG_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.LOG_MEDIATOR__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
		result.append(" (logCategory: ");
		result.append(logCategory);
		result.append(", logLevel: ");
		result.append(logLevel);
		result.append(", logSeparator: ");
		result.append(logSeparator);
		result.append(')');
		return result.toString();
	}

} //LogMediatorImpl
