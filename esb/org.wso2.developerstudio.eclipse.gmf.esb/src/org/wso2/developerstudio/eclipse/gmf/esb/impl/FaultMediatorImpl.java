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
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap11;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeSoap12;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultCodeType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultDetailType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultReasonType;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultSoapVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultStringType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fault Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getSoapVersion <em>Soap Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#isSerializeResponse <em>Serialize Response</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#isMarkAsResponse <em>Mark As Response</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultCodeSoap11 <em>Fault Code Soap11</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultCodeType <em>Fault Code Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultCodeExpression <em>Fault Code Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultStringType <em>Fault String Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultStringValue <em>Fault String Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultStringExpression <em>Fault String Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultActor <em>Fault Actor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultCodeSoap12 <em>Fault Code Soap12</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultReasonType <em>Fault Reason Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultReasonValue <em>Fault Reason Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultReasonExpression <em>Fault Reason Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getRoleName <em>Role Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultDetailType <em>Fault Detail Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultDetailValue <em>Fault Detail Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getFaultDetailExpression <em>Fault Detail Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.FaultMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FaultMediatorImpl extends MediatorImpl implements FaultMediator {
	/**
	 * The default value of the '{@link #getSoapVersion() <em>Soap Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapVersion()
	 * @generated
	 * @ordered
	 */
	protected static final FaultSoapVersion SOAP_VERSION_EDEFAULT = FaultSoapVersion.SOAP_11;

	/**
	 * The cached value of the '{@link #getSoapVersion() <em>Soap Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapVersion()
	 * @generated
	 * @ordered
	 */
	protected FaultSoapVersion soapVersion = SOAP_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isSerializeResponse() <em>Serialize Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerializeResponse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SERIALIZE_RESPONSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSerializeResponse() <em>Serialize Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerializeResponse()
	 * @generated
	 * @ordered
	 */
	protected boolean serializeResponse = SERIALIZE_RESPONSE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMarkAsResponse() <em>Mark As Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMarkAsResponse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MARK_AS_RESPONSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMarkAsResponse() <em>Mark As Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMarkAsResponse()
	 * @generated
	 * @ordered
	 */
	protected boolean markAsResponse = MARK_AS_RESPONSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultCodeSoap11() <em>Fault Code Soap11</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap11()
	 * @generated
	 * @ordered
	 */
	protected static final FaultCodeSoap11 FAULT_CODE_SOAP11_EDEFAULT = FaultCodeSoap11.VERSION_MISSMATCH;

	/**
	 * The cached value of the '{@link #getFaultCodeSoap11() <em>Fault Code Soap11</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap11()
	 * @generated
	 * @ordered
	 */
	protected FaultCodeSoap11 faultCodeSoap11 = FAULT_CODE_SOAP11_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultCodeType() <em>Fault Code Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultCodeType FAULT_CODE_TYPE_EDEFAULT = FaultCodeType.VALUE;

	/**
	 * The cached value of the '{@link #getFaultCodeType() <em>Fault Code Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeType()
	 * @generated
	 * @ordered
	 */
	protected FaultCodeType faultCodeType = FAULT_CODE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultCodeExpression() <em>Fault Code Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty faultCodeExpression;

	/**
	 * The default value of the '{@link #getFaultStringType() <em>Fault String Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultStringType FAULT_STRING_TYPE_EDEFAULT = FaultStringType.VALUE;

	/**
	 * The cached value of the '{@link #getFaultStringType() <em>Fault String Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringType()
	 * @generated
	 * @ordered
	 */
	protected FaultStringType faultStringType = FAULT_STRING_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultStringValue() <em>Fault String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_STRING_VALUE_EDEFAULT = "fault_string";

	/**
	 * The cached value of the '{@link #getFaultStringValue() <em>Fault String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringValue()
	 * @generated
	 * @ordered
	 */
	protected String faultStringValue = FAULT_STRING_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultStringExpression() <em>Fault String Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultStringExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty faultStringExpression;

	/**
	 * The default value of the '{@link #getFaultActor() <em>Fault Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultActor()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_ACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultActor() <em>Fault Actor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultActor()
	 * @generated
	 * @ordered
	 */
	protected String faultActor = FAULT_ACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultCodeSoap12() <em>Fault Code Soap12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap12()
	 * @generated
	 * @ordered
	 */
	protected static final FaultCodeSoap12 FAULT_CODE_SOAP12_EDEFAULT = FaultCodeSoap12.VERSION_MISSMATCH;

	/**
	 * The cached value of the '{@link #getFaultCodeSoap12() <em>Fault Code Soap12</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultCodeSoap12()
	 * @generated
	 * @ordered
	 */
	protected FaultCodeSoap12 faultCodeSoap12 = FAULT_CODE_SOAP12_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultReasonType() <em>Fault Reason Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultReasonType FAULT_REASON_TYPE_EDEFAULT = FaultReasonType.VALUE;

	/**
	 * The cached value of the '{@link #getFaultReasonType() <em>Fault Reason Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonType()
	 * @generated
	 * @ordered
	 */
	protected FaultReasonType faultReasonType = FAULT_REASON_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultReasonValue() <em>Fault Reason Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_REASON_VALUE_EDEFAULT = "fault_reason";

	/**
	 * The cached value of the '{@link #getFaultReasonValue() <em>Fault Reason Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonValue()
	 * @generated
	 * @ordered
	 */
	protected String faultReasonValue = FAULT_REASON_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultReasonExpression() <em>Fault Reason Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultReasonExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty faultReasonExpression;

	/**
	 * The default value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleName()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoleName() <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleName()
	 * @generated
	 * @ordered
	 */
	protected String roleName = ROLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected String nodeName = NODE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultDetailType() <em>Fault Detail Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailType()
	 * @generated
	 * @ordered
	 */
	protected static final FaultDetailType FAULT_DETAIL_TYPE_EDEFAULT = FaultDetailType.VALUE;

	/**
	 * The cached value of the '{@link #getFaultDetailType() <em>Fault Detail Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailType()
	 * @generated
	 * @ordered
	 */
	protected FaultDetailType faultDetailType = FAULT_DETAIL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultDetailValue() <em>Fault Detail Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_DETAIL_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultDetailValue() <em>Fault Detail Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailValue()
	 * @generated
	 * @ordered
	 */
	protected String faultDetailValue = FAULT_DETAIL_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultDetailExpression() <em>Fault Detail Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultDetailExpression()
	 * @generated
	 * @ordered
	 */
	protected NamespacedProperty faultDetailExpression;

	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected FaultMediatorInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected FaultMediatorOutputConnector outputConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected FaultMediatorImpl() {
		super();
		// Fault reason expression.
		NamespacedProperty faultReasonExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		faultReasonExpression.setPrettyName("Fault Reason");
		faultReasonExpression.setPropertyName("expression");
		faultReasonExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setFaultReasonExpression(faultReasonExpression);
		
		// Fault string expression.
		NamespacedProperty faultStringExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		faultStringExpression.setPrettyName("Fault String");
		faultStringExpression.setPropertyName("expression");
		faultStringExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setFaultStringExpression(faultStringExpression);
		
		// Fault detail expression.
		NamespacedProperty faultDetailExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		faultDetailExpression.setPrettyName("Fault Detail");
		faultDetailExpression.setPropertyName("expression");
		faultDetailExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setFaultDetailExpression(faultDetailExpression);
		
		// Fault Code expression.
		NamespacedProperty faultCodeExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
		faultCodeExpression.setPrettyName("Fault Code");
		faultCodeExpression.setPropertyName("expression");
		faultCodeExpression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
		setFaultCodeExpression(faultCodeExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.FAULT_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultSoapVersion getSoapVersion() {
		return soapVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoapVersion(FaultSoapVersion newSoapVersion) {
		FaultSoapVersion oldSoapVersion = soapVersion;
		soapVersion = newSoapVersion == null ? SOAP_VERSION_EDEFAULT : newSoapVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__SOAP_VERSION, oldSoapVersion, soapVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSerializeResponse() {
		return serializeResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerializeResponse(boolean newSerializeResponse) {
		boolean oldSerializeResponse = serializeResponse;
		serializeResponse = newSerializeResponse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__SERIALIZE_RESPONSE, oldSerializeResponse, serializeResponse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMarkAsResponse() {
		return markAsResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarkAsResponse(boolean newMarkAsResponse) {
		boolean oldMarkAsResponse = markAsResponse;
		markAsResponse = newMarkAsResponse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__MARK_AS_RESPONSE, oldMarkAsResponse, markAsResponse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeSoap11 getFaultCodeSoap11() {
		return faultCodeSoap11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultCodeSoap11(FaultCodeSoap11 newFaultCodeSoap11) {
		FaultCodeSoap11 oldFaultCodeSoap11 = faultCodeSoap11;
		faultCodeSoap11 = newFaultCodeSoap11 == null ? FAULT_CODE_SOAP11_EDEFAULT : newFaultCodeSoap11;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11, oldFaultCodeSoap11, faultCodeSoap11));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeType getFaultCodeType() {
		return faultCodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultCodeType(FaultCodeType newFaultCodeType) {
		FaultCodeType oldFaultCodeType = faultCodeType;
		faultCodeType = newFaultCodeType == null ? FAULT_CODE_TYPE_EDEFAULT : newFaultCodeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_CODE_TYPE, oldFaultCodeType, faultCodeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFaultCodeExpression() {
		return faultCodeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultCodeExpression(NamespacedProperty newFaultCodeExpression, NotificationChain msgs) {
		NamespacedProperty oldFaultCodeExpression = faultCodeExpression;
		faultCodeExpression = newFaultCodeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION, oldFaultCodeExpression, newFaultCodeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultCodeExpression(NamespacedProperty newFaultCodeExpression) {
		if (newFaultCodeExpression != faultCodeExpression) {
			NotificationChain msgs = null;
			if (faultCodeExpression != null)
				msgs = ((InternalEObject)faultCodeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION, null, msgs);
			if (newFaultCodeExpression != null)
				msgs = ((InternalEObject)newFaultCodeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION, null, msgs);
			msgs = basicSetFaultCodeExpression(newFaultCodeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION, newFaultCodeExpression, newFaultCodeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultStringType getFaultStringType() {
		return faultStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultStringType(FaultStringType newFaultStringType) {
		FaultStringType oldFaultStringType = faultStringType;
		faultStringType = newFaultStringType == null ? FAULT_STRING_TYPE_EDEFAULT : newFaultStringType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE, oldFaultStringType, faultStringType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultStringValue() {
		return faultStringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultStringValue(String newFaultStringValue) {
		String oldFaultStringValue = faultStringValue;
		faultStringValue = newFaultStringValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE, oldFaultStringValue, faultStringValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFaultStringExpression() {
		return faultStringExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultStringExpression(NamespacedProperty newFaultStringExpression, NotificationChain msgs) {
		NamespacedProperty oldFaultStringExpression = faultStringExpression;
		faultStringExpression = newFaultStringExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, oldFaultStringExpression, newFaultStringExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultStringExpression(NamespacedProperty newFaultStringExpression) {
		if (newFaultStringExpression != faultStringExpression) {
			NotificationChain msgs = null;
			if (faultStringExpression != null)
				msgs = ((InternalEObject)faultStringExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, null, msgs);
			if (newFaultStringExpression != null)
				msgs = ((InternalEObject)newFaultStringExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, null, msgs);
			msgs = basicSetFaultStringExpression(newFaultStringExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION, newFaultStringExpression, newFaultStringExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultActor() {
		return faultActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultActor(String newFaultActor) {
		String oldFaultActor = faultActor;
		faultActor = newFaultActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_ACTOR, oldFaultActor, faultActor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeSoap12 getFaultCodeSoap12() {
		return faultCodeSoap12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultCodeSoap12(FaultCodeSoap12 newFaultCodeSoap12) {
		FaultCodeSoap12 oldFaultCodeSoap12 = faultCodeSoap12;
		faultCodeSoap12 = newFaultCodeSoap12 == null ? FAULT_CODE_SOAP12_EDEFAULT : newFaultCodeSoap12;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12, oldFaultCodeSoap12, faultCodeSoap12));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultReasonType getFaultReasonType() {
		return faultReasonType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultReasonType(FaultReasonType newFaultReasonType) {
		FaultReasonType oldFaultReasonType = faultReasonType;
		faultReasonType = newFaultReasonType == null ? FAULT_REASON_TYPE_EDEFAULT : newFaultReasonType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE, oldFaultReasonType, faultReasonType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultReasonValue() {
		return faultReasonValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultReasonValue(String newFaultReasonValue) {
		String oldFaultReasonValue = faultReasonValue;
		faultReasonValue = newFaultReasonValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE, oldFaultReasonValue, faultReasonValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFaultReasonExpression() {
		return faultReasonExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultReasonExpression(NamespacedProperty newFaultReasonExpression, NotificationChain msgs) {
		NamespacedProperty oldFaultReasonExpression = faultReasonExpression;
		faultReasonExpression = newFaultReasonExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, oldFaultReasonExpression, newFaultReasonExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultReasonExpression(NamespacedProperty newFaultReasonExpression) {
		if (newFaultReasonExpression != faultReasonExpression) {
			NotificationChain msgs = null;
			if (faultReasonExpression != null)
				msgs = ((InternalEObject)faultReasonExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, null, msgs);
			if (newFaultReasonExpression != null)
				msgs = ((InternalEObject)newFaultReasonExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, null, msgs);
			msgs = basicSetFaultReasonExpression(newFaultReasonExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION, newFaultReasonExpression, newFaultReasonExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleName(String newRoleName) {
		String oldRoleName = roleName;
		roleName = newRoleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__ROLE_NAME, oldRoleName, roleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeName(String newNodeName) {
		String oldNodeName = nodeName;
		nodeName = newNodeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__NODE_NAME, oldNodeName, nodeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultDetailType getFaultDetailType() {
		return faultDetailType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultDetailType(FaultDetailType newFaultDetailType) {
		FaultDetailType oldFaultDetailType = faultDetailType;
		faultDetailType = newFaultDetailType == null ? FAULT_DETAIL_TYPE_EDEFAULT : newFaultDetailType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE, oldFaultDetailType, faultDetailType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultDetailValue() {
		return faultDetailValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultDetailValue(String newFaultDetailValue) {
		String oldFaultDetailValue = faultDetailValue;
		faultDetailValue = newFaultDetailValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE, oldFaultDetailValue, faultDetailValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty getFaultDetailExpression() {
		return faultDetailExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultDetailExpression(NamespacedProperty newFaultDetailExpression, NotificationChain msgs) {
		NamespacedProperty oldFaultDetailExpression = faultDetailExpression;
		faultDetailExpression = newFaultDetailExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, oldFaultDetailExpression, newFaultDetailExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultDetailExpression(NamespacedProperty newFaultDetailExpression) {
		if (newFaultDetailExpression != faultDetailExpression) {
			NotificationChain msgs = null;
			if (faultDetailExpression != null)
				msgs = ((InternalEObject)faultDetailExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, null, msgs);
			if (newFaultDetailExpression != null)
				msgs = ((InternalEObject)newFaultDetailExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, null, msgs);
			msgs = basicSetFaultDetailExpression(newFaultDetailExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION, newFaultDetailExpression, newFaultDetailExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(FaultMediatorInputConnector newInputConnector, NotificationChain msgs) {
		FaultMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(FaultMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(FaultMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		FaultMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(FaultMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION:
				return basicSetFaultCodeExpression(null, msgs);
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				return basicSetFaultStringExpression(null, msgs);
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				return basicSetFaultReasonExpression(null, msgs);
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				return basicSetFaultDetailExpression(null, msgs);
			case EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.FAULT_MEDIATOR__SOAP_VERSION:
				return getSoapVersion();
			case EsbPackage.FAULT_MEDIATOR__SERIALIZE_RESPONSE:
				return isSerializeResponse();
			case EsbPackage.FAULT_MEDIATOR__MARK_AS_RESPONSE:
				return isMarkAsResponse();
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				return getFaultCodeSoap11();
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_TYPE:
				return getFaultCodeType();
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION:
				return getFaultCodeExpression();
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				return getFaultStringType();
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				return getFaultStringValue();
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				return getFaultStringExpression();
			case EsbPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				return getFaultActor();
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				return getFaultCodeSoap12();
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				return getFaultReasonType();
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				return getFaultReasonValue();
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				return getFaultReasonExpression();
			case EsbPackage.FAULT_MEDIATOR__ROLE_NAME:
				return getRoleName();
			case EsbPackage.FAULT_MEDIATOR__NODE_NAME:
				return getNodeName();
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				return getFaultDetailType();
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				return getFaultDetailValue();
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				return getFaultDetailExpression();
			case EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR:
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
			case EsbPackage.FAULT_MEDIATOR__SOAP_VERSION:
				setSoapVersion((FaultSoapVersion)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__SERIALIZE_RESPONSE:
				setSerializeResponse((Boolean)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__MARK_AS_RESPONSE:
				setMarkAsResponse((Boolean)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				setFaultCodeSoap11((FaultCodeSoap11)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_TYPE:
				setFaultCodeType((FaultCodeType)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION:
				setFaultCodeExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				setFaultStringType((FaultStringType)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				setFaultStringValue((String)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				setFaultStringExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				setFaultActor((String)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				setFaultCodeSoap12((FaultCodeSoap12)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				setFaultReasonType((FaultReasonType)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				setFaultReasonValue((String)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				setFaultReasonExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__ROLE_NAME:
				setRoleName((String)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__NODE_NAME:
				setNodeName((String)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				setFaultDetailType((FaultDetailType)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				setFaultDetailValue((String)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				setFaultDetailExpression((NamespacedProperty)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((FaultMediatorInputConnector)newValue);
				return;
			case EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((FaultMediatorOutputConnector)newValue);
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
			case EsbPackage.FAULT_MEDIATOR__SOAP_VERSION:
				setSoapVersion(SOAP_VERSION_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__SERIALIZE_RESPONSE:
				setSerializeResponse(SERIALIZE_RESPONSE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__MARK_AS_RESPONSE:
				setMarkAsResponse(MARK_AS_RESPONSE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				setFaultCodeSoap11(FAULT_CODE_SOAP11_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_TYPE:
				setFaultCodeType(FAULT_CODE_TYPE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION:
				setFaultCodeExpression((NamespacedProperty)null);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				setFaultStringType(FAULT_STRING_TYPE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				setFaultStringValue(FAULT_STRING_VALUE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				setFaultStringExpression((NamespacedProperty)null);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				setFaultActor(FAULT_ACTOR_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				setFaultCodeSoap12(FAULT_CODE_SOAP12_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				setFaultReasonType(FAULT_REASON_TYPE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				setFaultReasonValue(FAULT_REASON_VALUE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				setFaultReasonExpression((NamespacedProperty)null);
				return;
			case EsbPackage.FAULT_MEDIATOR__ROLE_NAME:
				setRoleName(ROLE_NAME_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__NODE_NAME:
				setNodeName(NODE_NAME_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				setFaultDetailType(FAULT_DETAIL_TYPE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				setFaultDetailValue(FAULT_DETAIL_VALUE_EDEFAULT);
				return;
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				setFaultDetailExpression((NamespacedProperty)null);
				return;
			case EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((FaultMediatorInputConnector)null);
				return;
			case EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((FaultMediatorOutputConnector)null);
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
			case EsbPackage.FAULT_MEDIATOR__SOAP_VERSION:
				return soapVersion != SOAP_VERSION_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__SERIALIZE_RESPONSE:
				return serializeResponse != SERIALIZE_RESPONSE_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__MARK_AS_RESPONSE:
				return markAsResponse != MARK_AS_RESPONSE_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP11:
				return faultCodeSoap11 != FAULT_CODE_SOAP11_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_TYPE:
				return faultCodeType != FAULT_CODE_TYPE_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_EXPRESSION:
				return faultCodeExpression != null;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_TYPE:
				return faultStringType != FAULT_STRING_TYPE_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_VALUE:
				return FAULT_STRING_VALUE_EDEFAULT == null ? faultStringValue != null : !FAULT_STRING_VALUE_EDEFAULT.equals(faultStringValue);
			case EsbPackage.FAULT_MEDIATOR__FAULT_STRING_EXPRESSION:
				return faultStringExpression != null;
			case EsbPackage.FAULT_MEDIATOR__FAULT_ACTOR:
				return FAULT_ACTOR_EDEFAULT == null ? faultActor != null : !FAULT_ACTOR_EDEFAULT.equals(faultActor);
			case EsbPackage.FAULT_MEDIATOR__FAULT_CODE_SOAP12:
				return faultCodeSoap12 != FAULT_CODE_SOAP12_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_TYPE:
				return faultReasonType != FAULT_REASON_TYPE_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_VALUE:
				return FAULT_REASON_VALUE_EDEFAULT == null ? faultReasonValue != null : !FAULT_REASON_VALUE_EDEFAULT.equals(faultReasonValue);
			case EsbPackage.FAULT_MEDIATOR__FAULT_REASON_EXPRESSION:
				return faultReasonExpression != null;
			case EsbPackage.FAULT_MEDIATOR__ROLE_NAME:
				return ROLE_NAME_EDEFAULT == null ? roleName != null : !ROLE_NAME_EDEFAULT.equals(roleName);
			case EsbPackage.FAULT_MEDIATOR__NODE_NAME:
				return NODE_NAME_EDEFAULT == null ? nodeName != null : !NODE_NAME_EDEFAULT.equals(nodeName);
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_TYPE:
				return faultDetailType != FAULT_DETAIL_TYPE_EDEFAULT;
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_VALUE:
				return FAULT_DETAIL_VALUE_EDEFAULT == null ? faultDetailValue != null : !FAULT_DETAIL_VALUE_EDEFAULT.equals(faultDetailValue);
			case EsbPackage.FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION:
				return faultDetailExpression != null;
			case EsbPackage.FAULT_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.FAULT_MEDIATOR__OUTPUT_CONNECTOR:
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
		result.append(" (soapVersion: ");
		result.append(soapVersion);
		result.append(", serializeResponse: ");
		result.append(serializeResponse);
		result.append(", markAsResponse: ");
		result.append(markAsResponse);
		result.append(", faultCodeSoap11: ");
		result.append(faultCodeSoap11);
		result.append(", faultCodeType: ");
		result.append(faultCodeType);
		result.append(", faultStringType: ");
		result.append(faultStringType);
		result.append(", faultStringValue: ");
		result.append(faultStringValue);
		result.append(", faultActor: ");
		result.append(faultActor);
		result.append(", faultCodeSoap12: ");
		result.append(faultCodeSoap12);
		result.append(", faultReasonType: ");
		result.append(faultReasonType);
		result.append(", faultReasonValue: ");
		result.append(faultReasonValue);
		result.append(", roleName: ");
		result.append(roleName);
		result.append(", nodeName: ");
		result.append(nodeName);
		result.append(", faultDetailType: ");
		result.append(faultDetailType);
		result.append(", faultDetailValue: ");
		result.append(faultDetailValue);
		result.append(')');
		return result.toString();
	}

} //FaultMediatorImpl
