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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorFailOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorPassOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Filter Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getConditionType <em>Condition Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getPassOutputConnector <em>Pass Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getFailOutputConnector <em>Fail Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getXpath <em>Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FilterMediatorImpl#getFilterContainer <em>Filter Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilterMediatorImpl extends MediatorImpl implements FilterMediator {
	/**
	 * The default value of the '{@link #getConditionType() <em>Condition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionType()
	 * @generated
	 * @ordered
	 */
	protected static final FilterMediatorConditionType CONDITION_TYPE_EDEFAULT = FilterMediatorConditionType.SOURCE_REGEX;

	/**
	 * The cached value of the '{@link #getConditionType() <em>Condition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionType()
	 * @generated
	 * @ordered
	 */
	protected FilterMediatorConditionType conditionType = CONDITION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String REGEX_EDEFAULT = "default_regex";

	/**
	 * The cached value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected String regex = REGEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected FilterMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
    protected FilterMediatorOutputConnector outputConnector;

    /**
	 * The cached value of the '{@link #getPassOutputConnector() <em>Pass Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected FilterMediatorPassOutputConnector passOutputConnector;

	/**
	 * The cached value of the '{@link #getFailOutputConnector() <em>Fail Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected FilterMediatorFailOutputConnector failOutputConnector;

	/**
	 * The cached value of the '{@link #getXpath() <em>Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty xpath;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty source;

	/**
	 * The cached value of the '{@link #getFilterContainer() <em>Filter Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFilterContainer()
	 * @generated
	 * @ordered
	 */
    protected FilterContainer filterContainer;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected FilterMediatorImpl() {
		super();
		
		// xpath.
		NamespacedProperty xpath = EsbFactory.eINSTANCE.createNamespacedProperty();
		xpath.setPrettyName("Filter Source XPath");
		xpath.setPropertyName("filterSourceXpath");
		xpath.setPropertyValue(DEFAULT_XPATH_PROPERTY_VALUE);		
		setXpath(xpath);
		
		// Source.
		NamespacedProperty source = EsbFactory.eINSTANCE.createNamespacedProperty();
		source.setPrettyName("Filter Source");
		source.setPropertyName("source");
		source.setPropertyValue("get-property('To')");
		setSource(source);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.FILTER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorConditionType getConditionType() {
		return conditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionType(FilterMediatorConditionType newConditionType) {
		FilterMediatorConditionType oldConditionType = conditionType;
		conditionType = newConditionType == null ? CONDITION_TYPE_EDEFAULT : newConditionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__CONDITION_TYPE, oldConditionType, conditionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(NamespacedProperty newSource, NotificationChain msgs) {
		NamespacedProperty oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(NamespacedProperty newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FilterContainer getFilterContainer() {
		return filterContainer;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetFilterContainer(FilterContainer newFilterContainer, NotificationChain msgs) {
		FilterContainer oldFilterContainer = filterContainer;
		filterContainer = newFilterContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER, oldFilterContainer, newFilterContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFilterContainer(FilterContainer newFilterContainer) {
		if (newFilterContainer != filterContainer) {
			NotificationChain msgs = null;
			if (filterContainer != null)
				msgs = ((InternalEObject)filterContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER, null, msgs);
			if (newFilterContainer != null)
				msgs = ((InternalEObject)newFilterContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER, null, msgs);
			msgs = basicSetFilterContainer(newFilterContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER, newFilterContainer, newFilterContainer));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegex() {
		return regex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegex(String newRegex) {
		String oldRegex = regex;
		regex = newRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__REGEX, oldRegex, regex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getXpath() {
		return xpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXpath(NamespacedProperty newXpath, NotificationChain msgs) {
		NamespacedProperty oldXpath = xpath;
		xpath = newXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__XPATH, oldXpath, newXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXpath(NamespacedProperty newXpath) {
		if (newXpath != xpath) {
			NotificationChain msgs = null;
			if (xpath != null)
				msgs = ((InternalEObject)xpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__XPATH, null, msgs);
			if (newXpath != null)
				msgs = ((InternalEObject)newXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__XPATH, null, msgs);
			msgs = basicSetXpath(newXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__XPATH, newXpath, newXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(FilterMediatorInputConnector newInputConnector, NotificationChain msgs) {
		FilterMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(FilterMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FilterMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetOutputConnector(FilterMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		FilterMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setOutputConnector(FilterMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorPassOutputConnector getPassOutputConnector() {
		return passOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPassOutputConnector(FilterMediatorPassOutputConnector newPassOutputConnector, NotificationChain msgs) {
		FilterMediatorPassOutputConnector oldPassOutputConnector = passOutputConnector;
		passOutputConnector = newPassOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR, oldPassOutputConnector, newPassOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassOutputConnector(FilterMediatorPassOutputConnector newPassOutputConnector) {
		if (newPassOutputConnector != passOutputConnector) {
			NotificationChain msgs = null;
			if (passOutputConnector != null)
				msgs = ((InternalEObject)passOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR, null, msgs);
			if (newPassOutputConnector != null)
				msgs = ((InternalEObject)newPassOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetPassOutputConnector(newPassOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR, newPassOutputConnector, newPassOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorFailOutputConnector getFailOutputConnector() {
		return failOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFailOutputConnector(FilterMediatorFailOutputConnector newFailOutputConnector, NotificationChain msgs) {
		FilterMediatorFailOutputConnector oldFailOutputConnector = failOutputConnector;
		failOutputConnector = newFailOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR, oldFailOutputConnector, newFailOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailOutputConnector(FilterMediatorFailOutputConnector newFailOutputConnector) {
		if (newFailOutputConnector != failOutputConnector) {
			NotificationChain msgs = null;
			if (failOutputConnector != null)
				msgs = ((InternalEObject)failOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR, null, msgs);
			if (newFailOutputConnector != null)
				msgs = ((InternalEObject)newFailOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetFailOutputConnector(newFailOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR, newFailOutputConnector, newFailOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR:
				return basicSetPassOutputConnector(null, msgs);
			case EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR:
				return basicSetFailOutputConnector(null, msgs);
			case EsbPackage.FILTER_MEDIATOR__XPATH:
				return basicSetXpath(null, msgs);
			case EsbPackage.FILTER_MEDIATOR__SOURCE:
				return basicSetSource(null, msgs);
			case EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER:
				return basicSetFilterContainer(null, msgs);
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
			case EsbPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				return getConditionType();
			case EsbPackage.FILTER_MEDIATOR__REGEX:
				return getRegex();
			case EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR:
				return getPassOutputConnector();
			case EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR:
				return getFailOutputConnector();
			case EsbPackage.FILTER_MEDIATOR__XPATH:
				return getXpath();
			case EsbPackage.FILTER_MEDIATOR__SOURCE:
				return getSource();
			case EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER:
				return getFilterContainer();
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
			case EsbPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				setConditionType((FilterMediatorConditionType)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__REGEX:
				setRegex((String)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((FilterMediatorInputConnector)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((FilterMediatorOutputConnector)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR:
				setPassOutputConnector((FilterMediatorPassOutputConnector)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR:
				setFailOutputConnector((FilterMediatorFailOutputConnector)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__XPATH:
				setXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__SOURCE:
				setSource((NamespacedProperty)newValue);
				return;
			case EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER:
				setFilterContainer((FilterContainer)newValue);
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
			case EsbPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				setConditionType(CONDITION_TYPE_EDEFAULT);
				return;
			case EsbPackage.FILTER_MEDIATOR__REGEX:
				setRegex(REGEX_EDEFAULT);
				return;
			case EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((FilterMediatorInputConnector)null);
				return;
			case EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((FilterMediatorOutputConnector)null);
				return;
			case EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR:
				setPassOutputConnector((FilterMediatorPassOutputConnector)null);
				return;
			case EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR:
				setFailOutputConnector((FilterMediatorFailOutputConnector)null);
				return;
			case EsbPackage.FILTER_MEDIATOR__XPATH:
				setXpath((NamespacedProperty)null);
				return;
			case EsbPackage.FILTER_MEDIATOR__SOURCE:
				setSource((NamespacedProperty)null);
				return;
			case EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER:
				setFilterContainer((FilterContainer)null);
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
			case EsbPackage.FILTER_MEDIATOR__CONDITION_TYPE:
				return conditionType != CONDITION_TYPE_EDEFAULT;
			case EsbPackage.FILTER_MEDIATOR__REGEX:
				return REGEX_EDEFAULT == null ? regex != null : !REGEX_EDEFAULT.equals(regex);
			case EsbPackage.FILTER_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.FILTER_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.FILTER_MEDIATOR__PASS_OUTPUT_CONNECTOR:
				return passOutputConnector != null;
			case EsbPackage.FILTER_MEDIATOR__FAIL_OUTPUT_CONNECTOR:
				return failOutputConnector != null;
			case EsbPackage.FILTER_MEDIATOR__XPATH:
				return xpath != null;
			case EsbPackage.FILTER_MEDIATOR__SOURCE:
				return source != null;
			case EsbPackage.FILTER_MEDIATOR__FILTER_CONTAINER:
				return filterContainer != null;
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
		result.append(" (conditionType: ");
		result.append(conditionType);
		result.append(", regex: ");
		result.append(regex);
		result.append(')');
		return result.toString();
	}

} //FilterMediatorImpl
