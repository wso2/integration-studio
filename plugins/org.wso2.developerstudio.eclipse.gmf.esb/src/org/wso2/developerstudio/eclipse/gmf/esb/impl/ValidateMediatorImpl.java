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
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediatorOnFailOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateOnFailBranch;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateSchema;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validate Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getSchemas <em>Schemas</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getOnFailOutputConnector <em>On Fail Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ValidateMediatorImpl#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidateMediatorImpl extends MediatorImpl implements ValidateMediator {
	/**
	 * The cached value of the '{@link #getSourceXpath() <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceXpath()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty sourceXpath;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidateFeature> features;

	/**
	 * The cached value of the '{@link #getSchemas() <em>Schemas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemas()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidateSchema> schemas;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected ValidateMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ValidateMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getOnFailOutputConnector() <em>On Fail Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnFailOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected ValidateMediatorOnFailOutputConnector onFailOutputConnector;

	/**
	 * The cached value of the '{@link #getMediatorFlow() <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediatorFlow()
	 * @generated
	 * @ordered
	 */
	protected MediatorFlow mediatorFlow;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidateResource> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ValidateMediatorImpl() {
		super();
		NamespacedProperty sourceXPath = EsbFactoryImpl.eINSTANCE
				.createNamespacedProperty();
		sourceXPath.setPrettyName("Source XPath");
		sourceXPath.setPropertyName("source");
		setSourceXpath(sourceXPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.VALIDATE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getSourceXpath() {
		return sourceXpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceXpath(NamespacedProperty newSourceXpath, NotificationChain msgs) {
		NamespacedProperty oldSourceXpath = sourceXpath;
		sourceXpath = newSourceXpath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, oldSourceXpath, newSourceXpath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceXpath(NamespacedProperty newSourceXpath) {
		if (newSourceXpath != sourceXpath) {
			NotificationChain msgs = null;
			if (sourceXpath != null)
				msgs = ((InternalEObject)sourceXpath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, null, msgs);
			if (newSourceXpath != null)
				msgs = ((InternalEObject)newSourceXpath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, null, msgs);
			msgs = basicSetSourceXpath(newSourceXpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH, newSourceXpath, newSourceXpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidateFeature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<ValidateFeature>(ValidateFeature.class, this, EsbPackage.VALIDATE_MEDIATOR__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidateSchema> getSchemas() {
		if (schemas == null) {
			schemas = new EObjectContainmentEList<ValidateSchema>(ValidateSchema.class, this, EsbPackage.VALIDATE_MEDIATOR__SCHEMAS);
		}
		return schemas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(ValidateMediatorInputConnector newInputConnector, NotificationChain msgs) {
		ValidateMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(ValidateMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(ValidateMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		ValidateMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(ValidateMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediatorOnFailOutputConnector getOnFailOutputConnector() {
		return onFailOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnFailOutputConnector(ValidateMediatorOnFailOutputConnector newOnFailOutputConnector, NotificationChain msgs) {
		ValidateMediatorOnFailOutputConnector oldOnFailOutputConnector = onFailOutputConnector;
		onFailOutputConnector = newOnFailOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR, oldOnFailOutputConnector, newOnFailOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnFailOutputConnector(ValidateMediatorOnFailOutputConnector newOnFailOutputConnector) {
		if (newOnFailOutputConnector != onFailOutputConnector) {
			NotificationChain msgs = null;
			if (onFailOutputConnector != null)
				msgs = ((InternalEObject)onFailOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR, null, msgs);
			if (newOnFailOutputConnector != null)
				msgs = ((InternalEObject)newOnFailOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOnFailOutputConnector(newOnFailOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR, newOnFailOutputConnector, newOnFailOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorFlow getMediatorFlow() {
		return mediatorFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediatorFlow(MediatorFlow newMediatorFlow, NotificationChain msgs) {
		MediatorFlow oldMediatorFlow = mediatorFlow;
		mediatorFlow = newMediatorFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediatorFlow(MediatorFlow newMediatorFlow) {
		if (newMediatorFlow != mediatorFlow) {
			NotificationChain msgs = null;
			if (mediatorFlow != null)
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidateResource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<ValidateResource>(ValidateResource.class, this, EsbPackage.VALIDATE_MEDIATOR__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				return basicSetSourceXpath(null, msgs);
			case EsbPackage.VALIDATE_MEDIATOR__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case EsbPackage.VALIDATE_MEDIATOR__SCHEMAS:
				return ((InternalEList<?>)getSchemas()).basicRemove(otherEnd, msgs);
			case EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR:
				return basicSetOnFailOutputConnector(null, msgs);
			case EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
			case EsbPackage.VALIDATE_MEDIATOR__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				return getSourceXpath();
			case EsbPackage.VALIDATE_MEDIATOR__FEATURES:
				return getFeatures();
			case EsbPackage.VALIDATE_MEDIATOR__SCHEMAS:
				return getSchemas();
			case EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR:
				return getOnFailOutputConnector();
			case EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW:
				return getMediatorFlow();
			case EsbPackage.VALIDATE_MEDIATOR__RESOURCES:
				return getResources();
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
			case EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)newValue);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends ValidateFeature>)newValue);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__SCHEMAS:
				getSchemas().clear();
				getSchemas().addAll((Collection<? extends ValidateSchema>)newValue);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ValidateMediatorInputConnector)newValue);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ValidateMediatorOutputConnector)newValue);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR:
				setOnFailOutputConnector((ValidateMediatorOnFailOutputConnector)newValue);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends ValidateResource>)newValue);
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
			case EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				setSourceXpath((NamespacedProperty)null);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__FEATURES:
				getFeatures().clear();
				return;
			case EsbPackage.VALIDATE_MEDIATOR__SCHEMAS:
				getSchemas().clear();
				return;
			case EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((ValidateMediatorInputConnector)null);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((ValidateMediatorOutputConnector)null);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR:
				setOnFailOutputConnector((ValidateMediatorOnFailOutputConnector)null);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
				return;
			case EsbPackage.VALIDATE_MEDIATOR__RESOURCES:
				getResources().clear();
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
			case EsbPackage.VALIDATE_MEDIATOR__SOURCE_XPATH:
				return sourceXpath != null;
			case EsbPackage.VALIDATE_MEDIATOR__FEATURES:
				return features != null && !features.isEmpty();
			case EsbPackage.VALIDATE_MEDIATOR__SCHEMAS:
				return schemas != null && !schemas.isEmpty();
			case EsbPackage.VALIDATE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.VALIDATE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.VALIDATE_MEDIATOR__ON_FAIL_OUTPUT_CONNECTOR:
				return onFailOutputConnector != null;
			case EsbPackage.VALIDATE_MEDIATOR__MEDIATOR_FLOW:
				return mediatorFlow != null;
			case EsbPackage.VALIDATE_MEDIATOR__RESOURCES:
				return resources != null && !resources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ValidateMediatorImpl
