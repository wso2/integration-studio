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
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#isAddressingEnabled <em>Addressing Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getAddressingVersion <em>Addressing Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#isAddressingSeparateListener <em>Addressing Separate Listener</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getTimeOutDuration <em>Time Out Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getTimeOutAction <em>Time Out Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getRetryErrorCodes <em>Retry Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getRetryCount <em>Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getRetryDelay <em>Retry Delay</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getSuspendErrorCodes <em>Suspend Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getSuspendInitialDuration <em>Suspend Initial Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getSuspendMaximumDuration <em>Suspend Maximum Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getSuspendProgressionFactor <em>Suspend Progression Factor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getReliableMessagingPolicy <em>Reliable Messaging Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getSecurityPolicy <em>Security Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getOptimize <em>Optimize</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getInboundPolicy <em>Inbound Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractEndPointImpl#getOutboundPolicy <em>Outbound Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractEndPointImpl extends EndPointImpl implements AbstractEndPoint {
	/**
	 * The default value of the '{@link #isReliableMessagingEnabled() <em>Reliable Messaging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReliableMessagingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RELIABLE_MESSAGING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReliableMessagingEnabled() <em>Reliable Messaging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReliableMessagingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean reliableMessagingEnabled = RELIABLE_MESSAGING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSecurityEnabled() <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecurityEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SECURITY_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSecurityEnabled() <em>Security Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecurityEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean securityEnabled = SECURITY_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isAddressingEnabled() <em>Addressing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddressingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADDRESSING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAddressingEnabled() <em>Addressing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddressingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean addressingEnabled = ADDRESSING_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddressingVersion() <em>Addressing Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressingVersion()
	 * @generated
	 * @ordered
	 */
	protected static final EndPointAddressingVersion ADDRESSING_VERSION_EDEFAULT = EndPointAddressingVersion.FINAL;

	/**
	 * The cached value of the '{@link #getAddressingVersion() <em>Addressing Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressingVersion()
	 * @generated
	 * @ordered
	 */
	protected EndPointAddressingVersion addressingVersion = ADDRESSING_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isAddressingSeparateListener() <em>Addressing Separate Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddressingSeparateListener()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADDRESSING_SEPARATE_LISTENER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAddressingSeparateListener() <em>Addressing Separate Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddressingSeparateListener()
	 * @generated
	 * @ordered
	 */
	protected boolean addressingSeparateListener = ADDRESSING_SEPARATE_LISTENER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeOutDuration() <em>Time Out Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOutDuration()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_OUT_DURATION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimeOutDuration() <em>Time Out Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOutDuration()
	 * @generated
	 * @ordered
	 */
	protected long timeOutDuration = TIME_OUT_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeOutAction() <em>Time Out Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOutAction()
	 * @generated
	 * @ordered
	 */
	protected static final EndPointTimeOutAction TIME_OUT_ACTION_EDEFAULT = EndPointTimeOutAction.NEVER;

	/**
	 * The cached value of the '{@link #getTimeOutAction() <em>Time Out Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOutAction()
	 * @generated
	 * @ordered
	 */
	protected EndPointTimeOutAction timeOutAction = TIME_OUT_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRetryErrorCodes() <em>Retry Error Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryErrorCodes()
	 * @generated
	 * @ordered
	 */
	protected static final String RETRY_ERROR_CODES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRetryErrorCodes() <em>Retry Error Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryErrorCodes()
	 * @generated
	 * @ordered
	 */
	protected String retryErrorCodes = RETRY_ERROR_CODES_EDEFAULT;

	/**
	 * The default value of the '{@link #getRetryCount() <em>Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryCount()
	 * @generated
	 * @ordered
	 */
	protected static final int RETRY_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRetryCount() <em>Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryCount()
	 * @generated
	 * @ordered
	 */
	protected int retryCount = RETRY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRetryDelay() <em>Retry Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryDelay()
	 * @generated
	 * @ordered
	 */
	protected static final long RETRY_DELAY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRetryDelay() <em>Retry Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryDelay()
	 * @generated
	 * @ordered
	 */
	protected long retryDelay = RETRY_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspendErrorCodes() <em>Suspend Error Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendErrorCodes()
	 * @generated
	 * @ordered
	 */
	protected static final String SUSPEND_ERROR_CODES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuspendErrorCodes() <em>Suspend Error Codes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendErrorCodes()
	 * @generated
	 * @ordered
	 */
	protected String suspendErrorCodes = SUSPEND_ERROR_CODES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspendInitialDuration() <em>Suspend Initial Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendInitialDuration()
	 * @generated
	 * @ordered
	 */
	protected static final long SUSPEND_INITIAL_DURATION_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getSuspendInitialDuration() <em>Suspend Initial Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendInitialDuration()
	 * @generated
	 * @ordered
	 */
	protected long suspendInitialDuration = SUSPEND_INITIAL_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspendMaximumDuration() <em>Suspend Maximum Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendMaximumDuration()
	 * @generated
	 * @ordered
	 */
	protected static final long SUSPEND_MAXIMUM_DURATION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSuspendMaximumDuration() <em>Suspend Maximum Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendMaximumDuration()
	 * @generated
	 * @ordered
	 */
	protected long suspendMaximumDuration = SUSPEND_MAXIMUM_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspendProgressionFactor() <em>Suspend Progression Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendProgressionFactor()
	 * @generated
	 * @ordered
	 */
	protected static final float SUSPEND_PROGRESSION_FACTOR_EDEFAULT = -1.0F;

	/**
	 * The cached value of the '{@link #getSuspendProgressionFactor() <em>Suspend Progression Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendProgressionFactor()
	 * @generated
	 * @ordered
	 */
	protected float suspendProgressionFactor = SUSPEND_PROGRESSION_FACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReliableMessagingPolicy() <em>Reliable Messaging Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReliableMessagingPolicy()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty reliableMessagingPolicy;

	/**
	 * The cached value of the '{@link #getSecurityPolicy() <em>Security Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityPolicy()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty securityPolicy;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final EndPointMessageFormat FORMAT_EDEFAULT = EndPointMessageFormat.LEAVE_AS_IS;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected EndPointMessageFormat format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptimize() <em>Optimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimize()
	 * @generated
	 * @ordered
	 */
	protected static final EndPointAttachmentOptimization OPTIMIZE_EDEFAULT = EndPointAttachmentOptimization.LEAVE_AS_IS;

	/**
	 * The cached value of the '{@link #getOptimize() <em>Optimize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimize()
	 * @generated
	 * @ordered
	 */
	protected EndPointAttachmentOptimization optimize = OPTIMIZE_EDEFAULT;

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
	 * The cached value of the '{@link #getInboundPolicy() <em>Inbound Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInboundPolicy()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty inboundPolicy;

	/**
	 * The cached value of the '{@link #getOutboundPolicy() <em>Outbound Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutboundPolicy()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty outboundPolicy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected AbstractEndPointImpl() {
		super();
		
		RegistryKeyProperty reliableMessagingPolicy=EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		reliableMessagingPolicy.setKeyName("ReliableMessagingPolicy Key");
		reliableMessagingPolicy.setPrettyName("ReliableMessagingPolicy Key");
		reliableMessagingPolicy.setKeyValue("/default/key");
		setReliableMessagingPolicy(reliableMessagingPolicy);
		
		RegistryKeyProperty securityPolicy=EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		securityPolicy.setKeyName("SecurityPolicy Key");
		securityPolicy.setPrettyName("SecurityPolicy Key");
		securityPolicy.setKeyValue("");
		setSecurityPolicy(securityPolicy);
		
		RegistryKeyProperty inboundPolicy=EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		inboundPolicy.setKeyName("inboundPolicy Key");
		inboundPolicy.setPrettyName("inboundPolicy Key");
		inboundPolicy.setKeyValue("");
		setInboundPolicy(inboundPolicy);
		
		RegistryKeyProperty outboundPolicy=EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		outboundPolicy.setKeyName("obPolicy Key");
		outboundPolicy.setPrettyName("obPolicy Key");
		outboundPolicy.setKeyValue("");
		setOutboundPolicy(outboundPolicy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ABSTRACT_END_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReliableMessagingEnabled() {
		return reliableMessagingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReliableMessagingEnabled(boolean newReliableMessagingEnabled) {
		boolean oldReliableMessagingEnabled = reliableMessagingEnabled;
		reliableMessagingEnabled = newReliableMessagingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED, oldReliableMessagingEnabled, reliableMessagingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSecurityEnabled() {
		return securityEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurityEnabled(boolean newSecurityEnabled) {
		boolean oldSecurityEnabled = securityEnabled;
		securityEnabled = newSecurityEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SECURITY_ENABLED, oldSecurityEnabled, securityEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAddressingEnabled() {
		return addressingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressingEnabled(boolean newAddressingEnabled) {
		boolean oldAddressingEnabled = addressingEnabled;
		addressingEnabled = newAddressingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__ADDRESSING_ENABLED, oldAddressingEnabled, addressingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointAddressingVersion getAddressingVersion() {
		return addressingVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressingVersion(EndPointAddressingVersion newAddressingVersion) {
		EndPointAddressingVersion oldAddressingVersion = addressingVersion;
		addressingVersion = newAddressingVersion == null ? ADDRESSING_VERSION_EDEFAULT : newAddressingVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__ADDRESSING_VERSION, oldAddressingVersion, addressingVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAddressingSeparateListener() {
		return addressingSeparateListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddressingSeparateListener(boolean newAddressingSeparateListener) {
		boolean oldAddressingSeparateListener = addressingSeparateListener;
		addressingSeparateListener = newAddressingSeparateListener;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER, oldAddressingSeparateListener, addressingSeparateListener));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeOutDuration() {
		return timeOutDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeOutDuration(long newTimeOutDuration) {
		long oldTimeOutDuration = timeOutDuration;
		timeOutDuration = newTimeOutDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__TIME_OUT_DURATION, oldTimeOutDuration, timeOutDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointTimeOutAction getTimeOutAction() {
		return timeOutAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeOutAction(EndPointTimeOutAction newTimeOutAction) {
		EndPointTimeOutAction oldTimeOutAction = timeOutAction;
		timeOutAction = newTimeOutAction == null ? TIME_OUT_ACTION_EDEFAULT : newTimeOutAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__TIME_OUT_ACTION, oldTimeOutAction, timeOutAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRetryErrorCodes() {
		return retryErrorCodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryErrorCodes(String newRetryErrorCodes) {
		String oldRetryErrorCodes = retryErrorCodes;
		retryErrorCodes = newRetryErrorCodes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__RETRY_ERROR_CODES, oldRetryErrorCodes, retryErrorCodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRetryCount() {
		return retryCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryCount(int newRetryCount) {
		int oldRetryCount = retryCount;
		retryCount = newRetryCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__RETRY_COUNT, oldRetryCount, retryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRetryDelay() {
		return retryDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryDelay(long newRetryDelay) {
		long oldRetryDelay = retryDelay;
		retryDelay = newRetryDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__RETRY_DELAY, oldRetryDelay, retryDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuspendErrorCodes() {
		return suspendErrorCodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspendErrorCodes(String newSuspendErrorCodes) {
		String oldSuspendErrorCodes = suspendErrorCodes;
		suspendErrorCodes = newSuspendErrorCodes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES, oldSuspendErrorCodes, suspendErrorCodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSuspendInitialDuration() {
		return suspendInitialDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspendInitialDuration(long newSuspendInitialDuration) {
		long oldSuspendInitialDuration = suspendInitialDuration;
		suspendInitialDuration = newSuspendInitialDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION, oldSuspendInitialDuration, suspendInitialDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSuspendMaximumDuration() {
		return suspendMaximumDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspendMaximumDuration(long newSuspendMaximumDuration) {
		long oldSuspendMaximumDuration = suspendMaximumDuration;
		suspendMaximumDuration = newSuspendMaximumDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION, oldSuspendMaximumDuration, suspendMaximumDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSuspendProgressionFactor() {
		return suspendProgressionFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspendProgressionFactor(float newSuspendProgressionFactor) {
		float oldSuspendProgressionFactor = suspendProgressionFactor;
		suspendProgressionFactor = newSuspendProgressionFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR, oldSuspendProgressionFactor, suspendProgressionFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getReliableMessagingPolicy() {
		return reliableMessagingPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReliableMessagingPolicy(RegistryKeyProperty newReliableMessagingPolicy, NotificationChain msgs) {
		RegistryKeyProperty oldReliableMessagingPolicy = reliableMessagingPolicy;
		reliableMessagingPolicy = newReliableMessagingPolicy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, oldReliableMessagingPolicy, newReliableMessagingPolicy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReliableMessagingPolicy(RegistryKeyProperty newReliableMessagingPolicy) {
		if (newReliableMessagingPolicy != reliableMessagingPolicy) {
			NotificationChain msgs = null;
			if (reliableMessagingPolicy != null)
				msgs = ((InternalEObject)reliableMessagingPolicy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, null, msgs);
			if (newReliableMessagingPolicy != null)
				msgs = ((InternalEObject)newReliableMessagingPolicy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, null, msgs);
			msgs = basicSetReliableMessagingPolicy(newReliableMessagingPolicy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, newReliableMessagingPolicy, newReliableMessagingPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getSecurityPolicy() {
		return securityPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecurityPolicy(RegistryKeyProperty newSecurityPolicy, NotificationChain msgs) {
		RegistryKeyProperty oldSecurityPolicy = securityPolicy;
		securityPolicy = newSecurityPolicy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY, oldSecurityPolicy, newSecurityPolicy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurityPolicy(RegistryKeyProperty newSecurityPolicy) {
		if (newSecurityPolicy != securityPolicy) {
			NotificationChain msgs = null;
			if (securityPolicy != null)
				msgs = ((InternalEObject)securityPolicy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY, null, msgs);
			if (newSecurityPolicy != null)
				msgs = ((InternalEObject)newSecurityPolicy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY, null, msgs);
			msgs = basicSetSecurityPolicy(newSecurityPolicy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY, newSecurityPolicy, newSecurityPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointMessageFormat getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(EndPointMessageFormat newFormat) {
		EndPointMessageFormat oldFormat = format;
		format = newFormat == null ? FORMAT_EDEFAULT : newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointAttachmentOptimization getOptimize() {
		return optimize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimize(EndPointAttachmentOptimization newOptimize) {
		EndPointAttachmentOptimization oldOptimize = optimize;
		optimize = newOptimize == null ? OPTIMIZE_EDEFAULT : newOptimize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__OPTIMIZE, oldOptimize, optimize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateParameter> getTemplateParameters() {
		if (templateParameters == null) {
			templateParameters = new EObjectContainmentEList<TemplateParameter>(TemplateParameter.class, this, EsbPackage.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS);
		}
		return templateParameters;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__STATISTICS_ENABLED, oldStatisticsEnabled, statisticsEnabled));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__TRACE_ENABLED, oldTraceEnabled, traceEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getInboundPolicy() {
		return inboundPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInboundPolicy(RegistryKeyProperty newInboundPolicy, NotificationChain msgs) {
		RegistryKeyProperty oldInboundPolicy = inboundPolicy;
		inboundPolicy = newInboundPolicy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY, oldInboundPolicy, newInboundPolicy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInboundPolicy(RegistryKeyProperty newInboundPolicy) {
		if (newInboundPolicy != inboundPolicy) {
			NotificationChain msgs = null;
			if (inboundPolicy != null)
				msgs = ((InternalEObject)inboundPolicy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY, null, msgs);
			if (newInboundPolicy != null)
				msgs = ((InternalEObject)newInboundPolicy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY, null, msgs);
			msgs = basicSetInboundPolicy(newInboundPolicy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY, newInboundPolicy, newInboundPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOutboundPolicy() {
		return outboundPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutboundPolicy(RegistryKeyProperty newOutboundPolicy, NotificationChain msgs) {
		RegistryKeyProperty oldOutboundPolicy = outboundPolicy;
		outboundPolicy = newOutboundPolicy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY, oldOutboundPolicy, newOutboundPolicy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutboundPolicy(RegistryKeyProperty newOutboundPolicy) {
		if (newOutboundPolicy != outboundPolicy) {
			NotificationChain msgs = null;
			if (outboundPolicy != null)
				msgs = ((InternalEObject)outboundPolicy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY, null, msgs);
			if (newOutboundPolicy != null)
				msgs = ((InternalEObject)newOutboundPolicy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY, null, msgs);
			msgs = basicSetOutboundPolicy(newOutboundPolicy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY, newOutboundPolicy, newOutboundPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY:
				return basicSetReliableMessagingPolicy(null, msgs);
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY:
				return basicSetSecurityPolicy(null, msgs);
			case EsbPackage.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS:
				return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
			case EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY:
				return basicSetInboundPolicy(null, msgs);
			case EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY:
				return basicSetOutboundPolicy(null, msgs);
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
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED:
				return isReliableMessagingEnabled();
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_ENABLED:
				return isSecurityEnabled();
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_ENABLED:
				return isAddressingEnabled();
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_VERSION:
				return getAddressingVersion();
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER:
				return isAddressingSeparateListener();
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_DURATION:
				return getTimeOutDuration();
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_ACTION:
				return getTimeOutAction();
			case EsbPackage.ABSTRACT_END_POINT__RETRY_ERROR_CODES:
				return getRetryErrorCodes();
			case EsbPackage.ABSTRACT_END_POINT__RETRY_COUNT:
				return getRetryCount();
			case EsbPackage.ABSTRACT_END_POINT__RETRY_DELAY:
				return getRetryDelay();
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES:
				return getSuspendErrorCodes();
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION:
				return getSuspendInitialDuration();
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION:
				return getSuspendMaximumDuration();
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR:
				return getSuspendProgressionFactor();
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY:
				return getReliableMessagingPolicy();
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY:
				return getSecurityPolicy();
			case EsbPackage.ABSTRACT_END_POINT__FORMAT:
				return getFormat();
			case EsbPackage.ABSTRACT_END_POINT__OPTIMIZE:
				return getOptimize();
			case EsbPackage.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS:
				return getTemplateParameters();
			case EsbPackage.ABSTRACT_END_POINT__STATISTICS_ENABLED:
				return isStatisticsEnabled();
			case EsbPackage.ABSTRACT_END_POINT__TRACE_ENABLED:
				return isTraceEnabled();
			case EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY:
				return getInboundPolicy();
			case EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY:
				return getOutboundPolicy();
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
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED:
				setReliableMessagingEnabled((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_ENABLED:
				setSecurityEnabled((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_ENABLED:
				setAddressingEnabled((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_VERSION:
				setAddressingVersion((EndPointAddressingVersion)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER:
				setAddressingSeparateListener((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_DURATION:
				setTimeOutDuration((Long)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_ACTION:
				setTimeOutAction((EndPointTimeOutAction)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_ERROR_CODES:
				setRetryErrorCodes((String)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_COUNT:
				setRetryCount((Integer)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_DELAY:
				setRetryDelay((Long)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES:
				setSuspendErrorCodes((String)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION:
				setSuspendInitialDuration((Long)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION:
				setSuspendMaximumDuration((Long)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR:
				setSuspendProgressionFactor((Float)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY:
				setReliableMessagingPolicy((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY:
				setSecurityPolicy((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__FORMAT:
				setFormat((EndPointMessageFormat)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__OPTIMIZE:
				setOptimize((EndPointAttachmentOptimization)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				getTemplateParameters().addAll((Collection<? extends TemplateParameter>)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__STATISTICS_ENABLED:
				setStatisticsEnabled((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TRACE_ENABLED:
				setTraceEnabled((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY:
				setInboundPolicy((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY:
				setOutboundPolicy((RegistryKeyProperty)newValue);
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
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED:
				setReliableMessagingEnabled(RELIABLE_MESSAGING_ENABLED_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_ENABLED:
				setSecurityEnabled(SECURITY_ENABLED_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_ENABLED:
				setAddressingEnabled(ADDRESSING_ENABLED_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_VERSION:
				setAddressingVersion(ADDRESSING_VERSION_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER:
				setAddressingSeparateListener(ADDRESSING_SEPARATE_LISTENER_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_DURATION:
				setTimeOutDuration(TIME_OUT_DURATION_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_ACTION:
				setTimeOutAction(TIME_OUT_ACTION_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_ERROR_CODES:
				setRetryErrorCodes(RETRY_ERROR_CODES_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_COUNT:
				setRetryCount(RETRY_COUNT_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_DELAY:
				setRetryDelay(RETRY_DELAY_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES:
				setSuspendErrorCodes(SUSPEND_ERROR_CODES_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION:
				setSuspendInitialDuration(SUSPEND_INITIAL_DURATION_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION:
				setSuspendMaximumDuration(SUSPEND_MAXIMUM_DURATION_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR:
				setSuspendProgressionFactor(SUSPEND_PROGRESSION_FACTOR_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY:
				setReliableMessagingPolicy((RegistryKeyProperty)null);
				return;
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY:
				setSecurityPolicy((RegistryKeyProperty)null);
				return;
			case EsbPackage.ABSTRACT_END_POINT__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__OPTIMIZE:
				setOptimize(OPTIMIZE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS:
				getTemplateParameters().clear();
				return;
			case EsbPackage.ABSTRACT_END_POINT__STATISTICS_ENABLED:
				setStatisticsEnabled(STATISTICS_ENABLED_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__TRACE_ENABLED:
				setTraceEnabled(TRACE_ENABLED_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY:
				setInboundPolicy((RegistryKeyProperty)null);
				return;
			case EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY:
				setOutboundPolicy((RegistryKeyProperty)null);
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
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED:
				return reliableMessagingEnabled != RELIABLE_MESSAGING_ENABLED_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_ENABLED:
				return securityEnabled != SECURITY_ENABLED_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_ENABLED:
				return addressingEnabled != ADDRESSING_ENABLED_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_VERSION:
				return addressingVersion != ADDRESSING_VERSION_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER:
				return addressingSeparateListener != ADDRESSING_SEPARATE_LISTENER_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_DURATION:
				return timeOutDuration != TIME_OUT_DURATION_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__TIME_OUT_ACTION:
				return timeOutAction != TIME_OUT_ACTION_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_ERROR_CODES:
				return RETRY_ERROR_CODES_EDEFAULT == null ? retryErrorCodes != null : !RETRY_ERROR_CODES_EDEFAULT.equals(retryErrorCodes);
			case EsbPackage.ABSTRACT_END_POINT__RETRY_COUNT:
				return retryCount != RETRY_COUNT_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__RETRY_DELAY:
				return retryDelay != RETRY_DELAY_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_ERROR_CODES:
				return SUSPEND_ERROR_CODES_EDEFAULT == null ? suspendErrorCodes != null : !SUSPEND_ERROR_CODES_EDEFAULT.equals(suspendErrorCodes);
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION:
				return suspendInitialDuration != SUSPEND_INITIAL_DURATION_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION:
				return suspendMaximumDuration != SUSPEND_MAXIMUM_DURATION_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR:
				return suspendProgressionFactor != SUSPEND_PROGRESSION_FACTOR_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY:
				return reliableMessagingPolicy != null;
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY:
				return securityPolicy != null;
			case EsbPackage.ABSTRACT_END_POINT__FORMAT:
				return format != FORMAT_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__OPTIMIZE:
				return optimize != OPTIMIZE_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__TEMPLATE_PARAMETERS:
				return templateParameters != null && !templateParameters.isEmpty();
			case EsbPackage.ABSTRACT_END_POINT__STATISTICS_ENABLED:
				return statisticsEnabled != STATISTICS_ENABLED_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__TRACE_ENABLED:
				return traceEnabled != TRACE_ENABLED_EDEFAULT;
			case EsbPackage.ABSTRACT_END_POINT__INBOUND_POLICY:
				return inboundPolicy != null;
			case EsbPackage.ABSTRACT_END_POINT__OUTBOUND_POLICY:
				return outboundPolicy != null;
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
		result.append(" (reliableMessagingEnabled: ");
		result.append(reliableMessagingEnabled);
		result.append(", securityEnabled: ");
		result.append(securityEnabled);
		result.append(", addressingEnabled: ");
		result.append(addressingEnabled);
		result.append(", addressingVersion: ");
		result.append(addressingVersion);
		result.append(", addressingSeparateListener: ");
		result.append(addressingSeparateListener);
		result.append(", timeOutDuration: ");
		result.append(timeOutDuration);
		result.append(", timeOutAction: ");
		result.append(timeOutAction);
		result.append(", retryErrorCodes: ");
		result.append(retryErrorCodes);
		result.append(", retryCount: ");
		result.append(retryCount);
		result.append(", retryDelay: ");
		result.append(retryDelay);
		result.append(", suspendErrorCodes: ");
		result.append(suspendErrorCodes);
		result.append(", suspendInitialDuration: ");
		result.append(suspendInitialDuration);
		result.append(", suspendMaximumDuration: ");
		result.append(suspendMaximumDuration);
		result.append(", suspendProgressionFactor: ");
		result.append(suspendProgressionFactor);
		result.append(", format: ");
		result.append(format);
		result.append(", optimize: ");
		result.append(optimize);
		result.append(", statisticsEnabled: ");
		result.append(statisticsEnabled);
		result.append(", traceEnabled: ");
		result.append(traceEnabled);
		result.append(')');
		return result.toString();
	}

} //AbstractEndPointImpl
