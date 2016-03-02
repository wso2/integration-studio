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

import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Template Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateMediatorImpl#getAvailableTemplates <em>Available Templates</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateMediatorImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CallTemplateMediatorImpl#getTargetTemplate <em>Target Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallTemplateMediatorImpl extends MediatorImpl implements CallTemplateMediator {
	/**
	 * The default value of the '{@link #getAvailableTemplates() <em>Available Templates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableTemplates()
	 * @generated
	 * @ordered
	 */
	protected static final String AVAILABLE_TEMPLATES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAvailableTemplates() <em>Available Templates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableTemplates()
	 * @generated
	 * @ordered
	 */
	protected String availableTemplates = AVAILABLE_TEMPLATES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<CallTemplateParameter> templateParameters;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected CallTemplateMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected CallTemplateMediatorOutputConnector outputConnector;

	/**
	 * The default value of the '{@link #getTargetTemplate() <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTemplate()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String TARGET_TEMPLATE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTargetTemplate() <em>Target Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTemplate()
	 * @generated
	 * @ordered
	 */
	protected String targetTemplate = TARGET_TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallTemplateMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAvailableTemplates() {
		return availableTemplates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailableTemplates(String newAvailableTemplates) {
		String oldAvailableTemplates = availableTemplates;
		availableTemplates = newAvailableTemplates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES, oldAvailableTemplates, availableTemplates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CallTemplateParameter> getTemplateParameters() {
		if (templateParameters == null) {
			templateParameters = new EObjectContainmentEList<CallTemplateParameter>(CallTemplateParameter.class, this, EsbPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS);
		}
		return templateParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTemplateMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(CallTemplateMediatorInputConnector newInputConnector, NotificationChain msgs) {
		CallTemplateMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(CallTemplateMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTemplateMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(CallTemplateMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		CallTemplateMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(CallTemplateMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetTemplate() {
		return targetTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTemplate(String newTargetTemplate) {
		String oldTargetTemplate = targetTemplate;
		targetTemplate = newTargetTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE, oldTargetTemplate, targetTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES:
				return getAvailableTemplates();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				return getTemplateParameters();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				return getTargetTemplate();
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
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES:
				setAvailableTemplates((String)newValue);
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				getTemplateParameters().addAll((Collection<? extends CallTemplateParameter>)newValue);
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CallTemplateMediatorInputConnector)newValue);
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CallTemplateMediatorOutputConnector)newValue);
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				setTargetTemplate((String)newValue);
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
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES:
				setAvailableTemplates(AVAILABLE_TEMPLATES_EDEFAULT);
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((CallTemplateMediatorInputConnector)null);
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((CallTemplateMediatorOutputConnector)null);
				return;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				setTargetTemplate(TARGET_TEMPLATE_EDEFAULT);
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
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__AVAILABLE_TEMPLATES:
				return AVAILABLE_TEMPLATES_EDEFAULT == null ? availableTemplates != null : !AVAILABLE_TEMPLATES_EDEFAULT.equals(availableTemplates);
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS:
				return templateParameters != null && !templateParameters.isEmpty();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE:
				return TARGET_TEMPLATE_EDEFAULT == null ? targetTemplate != null : !TARGET_TEMPLATE_EDEFAULT.equals(targetTemplate);
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
		result.append(" (availableTemplates: ");
		result.append(availableTemplates);
		result.append(", targetTemplate: ");
		result.append(targetTemplate);
		result.append(')');
		return result.toString();
	}

} //CallTemplateMediatorImpl
