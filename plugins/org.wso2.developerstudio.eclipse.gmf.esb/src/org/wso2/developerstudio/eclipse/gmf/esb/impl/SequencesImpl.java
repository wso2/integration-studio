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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorFlow;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.SequencesInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SequencesOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequences</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#isRecieveSequence <em>Recieve Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#getAssociatedProxy <em>Associated Proxy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#getOnError <em>On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SequencesImpl#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequencesImpl extends EsbElementImpl implements Sequences {
	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected SequencesOutputConnector outputConnector;
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected SequencesInputConnector inputConnector;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isRecieveSequence() <em>Recieve Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecieveSequence()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RECIEVE_SEQUENCE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isRecieveSequence() <em>Recieve Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecieveSequence()
	 * @generated
	 * @ordered
	 */
	protected boolean recieveSequence = RECIEVE_SEQUENCE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getAssociatedProxy() <em>Associated Proxy</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedProxy()
	 * @generated
	 * @ordered
	 */
	protected EList<String> associatedProxy;

	/**
	 * The cached value of the '{@link #getOnError() <em>On Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnError()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty onError;

	/**
	 * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateParameter> templateParameters;

	/**
	 * The default value of the '{@link #isTraceEnabled() <em>Trace Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraceEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRACE_ENABLED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isTraceEnabled() <em>Trace Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraceEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean traceEnabled = TRACE_ENABLED_EDEFAULT;
	/**
	 * The default value of the '{@link #isStatisticsEnabled() <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatisticsEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATISTICS_ENABLED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isStatisticsEnabled() <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatisticsEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean statisticsEnabled = STATISTICS_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SequencesImpl() {
		super();
		RegistryKeyProperty sequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		sequenceKey.setKeyName("OnError sequence Key");
		sequenceKey.setPrettyName("OnError sequence Key");
		sequenceKey.setKeyValue("");
		setOnError(sequenceKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SEQUENCES;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__MEDIATOR_FLOW, oldMediatorFlow, newMediatorFlow);
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
				msgs = ((InternalEObject)mediatorFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__MEDIATOR_FLOW, null, msgs);
			if (newMediatorFlow != null)
				msgs = ((InternalEObject)newMediatorFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__MEDIATOR_FLOW, null, msgs);
			msgs = basicSetMediatorFlow(newMediatorFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__MEDIATOR_FLOW, newMediatorFlow, newMediatorFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRecieveSequence() {
		return recieveSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecieveSequence(boolean newRecieveSequence) {
		boolean oldRecieveSequence = recieveSequence;
		recieveSequence = newRecieveSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__RECIEVE_SEQUENCE, oldRecieveSequence, recieveSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAssociatedProxy() {
		if (associatedProxy == null) {
			associatedProxy = new EDataTypeUniqueEList<String>(String.class, this, EsbPackage.SEQUENCES__ASSOCIATED_PROXY);
		}
		return associatedProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOnError() {
		return onError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnError(RegistryKeyProperty newOnError, NotificationChain msgs) {
		RegistryKeyProperty oldOnError = onError;
		onError = newOnError;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__ON_ERROR, oldOnError, newOnError);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnError(RegistryKeyProperty newOnError) {
		if (newOnError != onError) {
			NotificationChain msgs = null;
			if (onError != null)
				msgs = ((InternalEObject)onError).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__ON_ERROR, null, msgs);
			if (newOnError != null)
				msgs = ((InternalEObject)newOnError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__ON_ERROR, null, msgs);
			msgs = basicSetOnError(newOnError, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__ON_ERROR, newOnError, newOnError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateParameter> getTemplateParameters() {
		if (templateParameters == null) {
			templateParameters = new EObjectContainmentEList<TemplateParameter>(TemplateParameter.class, this, EsbPackage.SEQUENCES__TEMPLATE_PARAMETERS);
		}
		return templateParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTraceEnabled() {
		return traceEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceEnabled(boolean newTraceEnabled) {
		boolean oldTraceEnabled = traceEnabled;
		traceEnabled = newTraceEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__TRACE_ENABLED, oldTraceEnabled, traceEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatisticsEnabled() {
		return statisticsEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatisticsEnabled(boolean newStatisticsEnabled) {
		boolean oldStatisticsEnabled = statisticsEnabled;
		statisticsEnabled = newStatisticsEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__STATISTICS_ENABLED, oldStatisticsEnabled, statisticsEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequencesOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(SequencesOutputConnector newOutputConnector, NotificationChain msgs) {
		SequencesOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(SequencesOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequencesInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(SequencesInputConnector newInputConnector, NotificationChain msgs) {
		SequencesInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(SequencesInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEQUENCES__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEQUENCES__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SEQUENCES__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.SEQUENCES__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.SEQUENCES__MEDIATOR_FLOW:
				return basicSetMediatorFlow(null, msgs);
			case EsbPackage.SEQUENCES__ON_ERROR:
				return basicSetOnError(null, msgs);
			case EsbPackage.SEQUENCES__TEMPLATE_PARAMETERS:
				return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.SEQUENCES__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.SEQUENCES__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.SEQUENCES__MEDIATOR_FLOW:
				return getMediatorFlow();
			case EsbPackage.SEQUENCES__NAME:
				return getName();
			case EsbPackage.SEQUENCES__RECIEVE_SEQUENCE:
				return isRecieveSequence();
			case EsbPackage.SEQUENCES__ASSOCIATED_PROXY:
				return getAssociatedProxy();
			case EsbPackage.SEQUENCES__ON_ERROR:
				return getOnError();
			case EsbPackage.SEQUENCES__TEMPLATE_PARAMETERS:
				return getTemplateParameters();
			case EsbPackage.SEQUENCES__TRACE_ENABLED:
				return isTraceEnabled();
			case EsbPackage.SEQUENCES__STATISTICS_ENABLED:
				return isStatisticsEnabled();
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
			case EsbPackage.SEQUENCES__OUTPUT_CONNECTOR:
				setOutputConnector((SequencesOutputConnector)newValue);
				return;
			case EsbPackage.SEQUENCES__INPUT_CONNECTOR:
				setInputConnector((SequencesInputConnector)newValue);
				return;
			case EsbPackage.SEQUENCES__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)newValue);
				return;
			case EsbPackage.SEQUENCES__NAME:
				setName((String)newValue);
				return;
			case EsbPackage.SEQUENCES__RECIEVE_SEQUENCE:
				setRecieveSequence((Boolean)newValue);
				return;
			case EsbPackage.SEQUENCES__ASSOCIATED_PROXY:
				getAssociatedProxy().clear();
				getAssociatedProxy().addAll((Collection<? extends String>)newValue);
				return;
			case EsbPackage.SEQUENCES__ON_ERROR:
				setOnError((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.SEQUENCES__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				getTemplateParameters().addAll((Collection<? extends TemplateParameter>)newValue);
				return;
			case EsbPackage.SEQUENCES__TRACE_ENABLED:
				setTraceEnabled((Boolean)newValue);
				return;
			case EsbPackage.SEQUENCES__STATISTICS_ENABLED:
				setStatisticsEnabled((Boolean)newValue);
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
			case EsbPackage.SEQUENCES__OUTPUT_CONNECTOR:
				setOutputConnector((SequencesOutputConnector)null);
				return;
			case EsbPackage.SEQUENCES__INPUT_CONNECTOR:
				setInputConnector((SequencesInputConnector)null);
				return;
			case EsbPackage.SEQUENCES__MEDIATOR_FLOW:
				setMediatorFlow((MediatorFlow)null);
				return;
			case EsbPackage.SEQUENCES__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsbPackage.SEQUENCES__RECIEVE_SEQUENCE:
				setRecieveSequence(RECIEVE_SEQUENCE_EDEFAULT);
				return;
			case EsbPackage.SEQUENCES__ASSOCIATED_PROXY:
				getAssociatedProxy().clear();
				return;
			case EsbPackage.SEQUENCES__ON_ERROR:
				setOnError((RegistryKeyProperty)null);
				return;
			case EsbPackage.SEQUENCES__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				return;
			case EsbPackage.SEQUENCES__TRACE_ENABLED:
				setTraceEnabled(TRACE_ENABLED_EDEFAULT);
				return;
			case EsbPackage.SEQUENCES__STATISTICS_ENABLED:
				setStatisticsEnabled(STATISTICS_ENABLED_EDEFAULT);
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
			case EsbPackage.SEQUENCES__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.SEQUENCES__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.SEQUENCES__MEDIATOR_FLOW:
				return mediatorFlow != null;
			case EsbPackage.SEQUENCES__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsbPackage.SEQUENCES__RECIEVE_SEQUENCE:
				return recieveSequence != RECIEVE_SEQUENCE_EDEFAULT;
			case EsbPackage.SEQUENCES__ASSOCIATED_PROXY:
				return associatedProxy != null && !associatedProxy.isEmpty();
			case EsbPackage.SEQUENCES__ON_ERROR:
				return onError != null;
			case EsbPackage.SEQUENCES__TEMPLATE_PARAMETERS:
				return templateParameters != null && !templateParameters.isEmpty();
			case EsbPackage.SEQUENCES__TRACE_ENABLED:
				return traceEnabled != TRACE_ENABLED_EDEFAULT;
			case EsbPackage.SEQUENCES__STATISTICS_ENABLED:
				return statisticsEnabled != STATISTICS_ENABLED_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", recieveSequence: ");
		result.append(recieveSequence);
		result.append(", associatedProxy: ");
		result.append(associatedProxy);
		result.append(", traceEnabled: ");
		result.append(traceEnabled);
		result.append(", statisticsEnabled: ");
		result.append(statisticsEnabled);
		result.append(')');
		return result.toString();
	}

} //SequencesImpl
