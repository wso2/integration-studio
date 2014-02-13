/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutputDataType;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Smooks Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getConfigurationKey <em>Configuration Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getInputType <em>Input Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getInputExpression <em>Input Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getOutputType <em>Output Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getOutputExpression <em>Output Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getOutputProperty <em>Output Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getOutputAction <em>Output Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getOutputMethod <em>Output Method</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SmooksMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SmooksMediatorImpl extends MediatorImpl implements SmooksMediator {
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
	 * The default value of the '{@link #getInputType() <em>Input Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputType()
	 * @generated
	 * @ordered
	 */
	protected static final SmooksIODataType INPUT_TYPE_EDEFAULT = SmooksIODataType.XML;

	/**
	 * The cached value of the '{@link #getInputType() <em>Input Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputType()
	 * @generated
	 * @ordered
	 */
	protected SmooksIODataType inputType = INPUT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputExpression() <em>Input Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty inputExpression;

	/**
	 * The default value of the '{@link #getOutputType() <em>Output Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputType()
	 * @generated
	 * @ordered
	 */
	protected static final SmooksOutputDataType OUTPUT_TYPE_EDEFAULT = SmooksOutputDataType.XML;

	/**
	 * The cached value of the '{@link #getOutputType() <em>Output Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputType()
	 * @generated
	 * @ordered
	 */
	protected SmooksOutputDataType outputType = OUTPUT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutputExpression() <em>Output Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty outputExpression;

	/**
	 * The default value of the '{@link #getOutputProperty() <em>Output Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputProperty()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String OUTPUT_PROPERTY_EDEFAULT = "smooksOutputProperty";

	/**
	 * The cached value of the '{@link #getOutputProperty() <em>Output Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputProperty()
	 * @generated
	 * @ordered
	 */
	protected String outputProperty = OUTPUT_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputAction() <em>Output Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputAction()
	 * @generated
	 * @ordered
	 */
	protected static final ExpressionAction OUTPUT_ACTION_EDEFAULT = ExpressionAction.ADD;

	/**
	 * The cached value of the '{@link #getOutputAction() <em>Output Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputAction()
	 * @generated
	 * @ordered
	 */
	protected ExpressionAction outputAction = OUTPUT_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputMethod() <em>Output Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMethod()
	 * @generated
	 * @ordered
	 */
	protected static final OutputMethod OUTPUT_METHOD_EDEFAULT = OutputMethod.DEFAULT;

	/**
	 * The cached value of the '{@link #getOutputMethod() <em>Output Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMethod()
	 * @generated
	 * @ordered
	 */
	protected OutputMethod outputMethod = OUTPUT_METHOD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected SmooksMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected SmooksMediatorOutputConnector outputConnector;

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SmooksMediatorImpl() {
		super();
		
		RegistryKeyProperty configurationKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		DeveloperStudioProviderUtils
				.addFilter((Map<String, java.util.List<String>>) configurationKey.getFilters(),
						CSProviderConstants.FILTER_MEDIA_TYPE,
						PlatformMediaTypeConstants.MEDIA_TYPE_SMOOKS);
		configurationKey.setPrettyName("Configuration Key");
		configurationKey.setKeyName("config-key");
		configurationKey.setKeyValue(DEFAULT_REGISTRY_KEY);
		setConfigurationKey(configurationKey); 
		NamespacedProperty outputExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		outputExpression.setPrettyName("Expression");
		outputExpression.setPropertyName("expression");
		outputExpression.setPropertyValue("/default/expression");
		setOutputExpression(outputExpression);
		
		NamespacedProperty inputExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		inputExpression.setPrettyName("Expression");
		inputExpression.setPropertyName("expression");
		inputExpression.setPropertyValue("");
		setInputExpression(inputExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SMOOKS_MEDIATOR;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, oldConfigurationKey, newConfigurationKey);
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
				msgs = ((InternalEObject)configurationKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, null, msgs);
			if (newConfigurationKey != null)
				msgs = ((InternalEObject)newConfigurationKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, null, msgs);
			msgs = basicSetConfigurationKey(newConfigurationKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY, newConfigurationKey, newConfigurationKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksIODataType getInputType() {
		return inputType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputType(SmooksIODataType newInputType) {
		SmooksIODataType oldInputType = inputType;
		inputType = newInputType == null ? INPUT_TYPE_EDEFAULT : newInputType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__INPUT_TYPE, oldInputType, inputType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getInputExpression() {
		return inputExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputExpression(NamespacedProperty newInputExpression, NotificationChain msgs) {
		NamespacedProperty oldInputExpression = inputExpression;
		inputExpression = newInputExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION, oldInputExpression, newInputExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputExpression(NamespacedProperty newInputExpression) {
		if (newInputExpression != inputExpression) {
			NotificationChain msgs = null;
			if (inputExpression != null)
				msgs = ((InternalEObject)inputExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION, null, msgs);
			if (newInputExpression != null)
				msgs = ((InternalEObject)newInputExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION, null, msgs);
			msgs = basicSetInputExpression(newInputExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION, newInputExpression, newInputExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksOutputDataType getOutputType() {
		return outputType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputType(SmooksOutputDataType newOutputType) {
		SmooksOutputDataType oldOutputType = outputType;
		outputType = newOutputType == null ? OUTPUT_TYPE_EDEFAULT : newOutputType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_TYPE, oldOutputType, outputType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getOutputExpression() {
		return outputExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputExpression(NamespacedProperty newOutputExpression, NotificationChain msgs) {
		NamespacedProperty oldOutputExpression = outputExpression;
		outputExpression = newOutputExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION, oldOutputExpression, newOutputExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputExpression(NamespacedProperty newOutputExpression) {
		if (newOutputExpression != outputExpression) {
			NotificationChain msgs = null;
			if (outputExpression != null)
				msgs = ((InternalEObject)outputExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION, null, msgs);
			if (newOutputExpression != null)
				msgs = ((InternalEObject)newOutputExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION, null, msgs);
			msgs = basicSetOutputExpression(newOutputExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION, newOutputExpression, newOutputExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputProperty() {
		return outputProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputProperty(String newOutputProperty) {
		String oldOutputProperty = outputProperty;
		outputProperty = newOutputProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_PROPERTY, oldOutputProperty, outputProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAction getOutputAction() {
		return outputAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputAction(ExpressionAction newOutputAction) {
		ExpressionAction oldOutputAction = outputAction;
		outputAction = newOutputAction == null ? OUTPUT_ACTION_EDEFAULT : newOutputAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_ACTION, oldOutputAction, outputAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputMethod getOutputMethod() {
		return outputMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputMethod(OutputMethod newOutputMethod) {
		OutputMethod oldOutputMethod = outputMethod;
		outputMethod = newOutputMethod == null ? OUTPUT_METHOD_EDEFAULT : newOutputMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_METHOD, oldOutputMethod, outputMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(SmooksMediatorInputConnector newInputConnector, NotificationChain msgs) {
		SmooksMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(SmooksMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(SmooksMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		SmooksMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(SmooksMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				return basicSetConfigurationKey(null, msgs);
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION:
				return basicSetInputExpression(null, msgs);
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION:
				return basicSetOutputExpression(null, msgs);
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				return getConfigurationKey();
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_TYPE:
				return getInputType();
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION:
				return getInputExpression();
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_TYPE:
				return getOutputType();
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION:
				return getOutputExpression();
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_PROPERTY:
				return getOutputProperty();
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_ACTION:
				return getOutputAction();
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_METHOD:
				return getOutputMethod();
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				setConfigurationKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_TYPE:
				setInputType((SmooksIODataType)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION:
				setInputExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_TYPE:
				setOutputType((SmooksOutputDataType)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION:
				setOutputExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_PROPERTY:
				setOutputProperty((String)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_ACTION:
				setOutputAction((ExpressionAction)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_METHOD:
				setOutputMethod((OutputMethod)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((SmooksMediatorInputConnector)newValue);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((SmooksMediatorOutputConnector)newValue);
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
			case EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				setConfigurationKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_TYPE:
				setInputType(INPUT_TYPE_EDEFAULT);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION:
				setInputExpression((NamespacedProperty)null);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_TYPE:
				setOutputType(OUTPUT_TYPE_EDEFAULT);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION:
				setOutputExpression((NamespacedProperty)null);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_PROPERTY:
				setOutputProperty(OUTPUT_PROPERTY_EDEFAULT);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_ACTION:
				setOutputAction(OUTPUT_ACTION_EDEFAULT);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_METHOD:
				setOutputMethod(OUTPUT_METHOD_EDEFAULT);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((SmooksMediatorInputConnector)null);
				return;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((SmooksMediatorOutputConnector)null);
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
			case EsbPackage.SMOOKS_MEDIATOR__CONFIGURATION_KEY:
				return configurationKey != null;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_TYPE:
				return inputType != INPUT_TYPE_EDEFAULT;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_EXPRESSION:
				return inputExpression != null;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_TYPE:
				return outputType != OUTPUT_TYPE_EDEFAULT;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_EXPRESSION:
				return outputExpression != null;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_PROPERTY:
				return OUTPUT_PROPERTY_EDEFAULT == null ? outputProperty != null : !OUTPUT_PROPERTY_EDEFAULT.equals(outputProperty);
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_ACTION:
				return outputAction != OUTPUT_ACTION_EDEFAULT;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_METHOD:
				return outputMethod != OUTPUT_METHOD_EDEFAULT;
			case EsbPackage.SMOOKS_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.SMOOKS_MEDIATOR__OUTPUT_CONNECTOR:
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
		result.append(" (inputType: ");
		result.append(inputType);
		result.append(", outputType: ");
		result.append(outputType);
		result.append(", outputProperty: ");
		result.append(outputProperty);
		result.append(", outputAction: ");
		result.append(outputAction);
		result.append(", outputMethod: ");
		result.append(outputMethod);
		result.append(')');
		return result.toString();
	}

} //SmooksMediatorImpl
