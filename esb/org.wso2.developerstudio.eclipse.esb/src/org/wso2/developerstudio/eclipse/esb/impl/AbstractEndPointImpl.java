/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.impl;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.esb.EndPointTimeOutAction;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#isReliableMessagingEnabled <em>Reliable Messaging Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#isSecurityEnabled <em>Security Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#isAddressingEnabled <em>Addressing Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getAddressingVersion <em>Addressing Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#isAddressingSeparateListener <em>Addressing Separate Listener</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getTimeOutDuration <em>Time Out Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getTimeOutAction <em>Time Out Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getRetryErrorCodes <em>Retry Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getRetryCount <em>Retry Count</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getRetryDelay <em>Retry Delay</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getSuspendErrorCodes <em>Suspend Error Codes</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getSuspendInitialDuration <em>Suspend Initial Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getSuspendMaximumDuration <em>Suspend Maximum Duration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getSuspendProgressionFactor <em>Suspend Progression Factor</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getReliableMessagingPolicy <em>Reliable Messaging Policy</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractEndPointImpl#getSecurityPolicy <em>Security Policy</em>}</li>
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
    protected static final EndPointTimeOutAction TIME_OUT_ACTION_EDEFAULT = EndPointTimeOutAction.DISCARD;

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
    protected static final long SUSPEND_INITIAL_DURATION_EDEFAULT = 0L;

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
    protected static final float SUSPEND_PROGRESSION_FACTOR_EDEFAULT = 1.0F;

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
	 * The cached value of the '{@link #getReliableMessagingPolicy() <em>Reliable Messaging Policy</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReliableMessagingPolicy()
	 * @generated
	 * @ordered
	 */
    protected RegistryKeyProperty reliableMessagingPolicy;

    /**
	 * The cached value of the '{@link #getSecurityPolicy() <em>Security Policy</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSecurityPolicy()
	 * @generated
	 * @ordered
	 */
    protected RegistryKeyProperty securityPolicy;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected AbstractEndPointImpl() {
		super();
	}
    
    /**
     * Loads this {@link AbstractEndPointImpl} from the specified {@link Element}. 
     * 
     * @param contentElem content element that holds the definition of this {@link AbstractEndPointImpl}.
     * @throws Exception if an error occurs while populating this {@link AbstractEndPointImpl}.
     */
    protected void loadContent(Element contentElem) throws Exception {
    	// Reliable messaging.
	    Element reliableMessagingElem = getChildElement(contentElem, "enableRM");
	    if (null != reliableMessagingElem) {
	    	setReliableMessagingEnabled(true);
	    	String policy = reliableMessagingElem.getAttribute("policy");
	    	if (!StringUtils.isBlank(policy)) {
	    		getReliableMessagingPolicy().load(reliableMessagingElem);
	    	}
	    }
	    
	    // Security.
	    Element securityElem = getChildElement(contentElem, "enableSec");
	    if (null != securityElem) {
	    	setSecurityEnabled(true);
	    	String policy = securityElem.getAttribute("policy");
	    	if (!StringUtils.isBlank(policy)) {
	    		getSecurityPolicy().load(securityElem);
	    	}
	    }
	    
	    // Addressing.
	    Element addressingElem = getChildElement(contentElem, "enableAddressing");
	    if (null != addressingElem) {
	    	setAddressingEnabled(true);
	    	
	    	// Version.
	    	EndPointAddressingVersion version = 
	    		EndPointAddressingVersion.get(addressingElem.getAttribute("version"));
	    	if (null != version) {
	    		setAddressingVersion(version);
	    	}
	    	
	    	// Listener.
	    	if (addressingElem.getAttribute("separateListener").equals(Boolean.toString(Boolean.TRUE))) {
	    		setAddressingSeparateListener(true);
	    	}
	    }
	    
	    // Timeout.
	    Element timeOutElem = getChildElement(contentElem, "timeout");
	    if (null != timeOutElem) {	    		    	
	    	// Duration.
	    	Element durationElem = getChildElement(timeOutElem, "duration");
	    	if (null != durationElem) {
	    		try {
	    			setTimeOutDuration(Long.parseLong(durationElem.getTextContent()));
	    		} catch (Exception ex) {
	    			// TODO: Log here.
	    		}
	    	}	    		    	
	    	
	    	// Action.
	    	Element actionElem = getChildElement(timeOutElem, "responseAction");
	    	if (null != actionElem) {
	    		String actionString = actionElem.getTextContent();
	    		EndPointTimeOutAction action = EndPointTimeOutAction.get(actionString);
	    		if (null != action) {
	    			setTimeOutAction(action);
	    		}
	    	}
	    }
	    
	    // Retry.
	    Element retryElem = getChildElement(contentElem, "markForSuspension");
	    if (null != retryElem) {
	    	// Error codes.
	    	Element errorCodesElem = getChildElement(retryElem, "errorCodes");
	    	if (null != errorCodesElem) {
	    		setRetryErrorCodes(errorCodesElem.getTextContent());
	    	}
	    	
	    	// Retry count.
	    	Element retryCountElem = getChildElement(retryElem, "retriesBeforeSuspension");
	    	if (null != retryCountElem) {
	    		try {
	    			setRetryCount(Integer.parseInt(retryCountElem.getTextContent()));
	    		} catch (Exception ex) {
	    			// TODO: Log here.
	    		} 	    		 
	    	}
	    	
	    	// Retry delay.
	    	Element retryDelayElem = getChildElement(retryElem, "retryDelay");
	    	if (null != retryDelayElem) {
	    		try {
	    			setRetryDelay(Long.parseLong(retryDelayElem.getTextContent()));
	    		} catch (Exception ex) {
	    			// TODO: Log here.
	    		} 	    		 
	    	}
	    }
	    
	    // Suspend.
	    Element suspendElem = getChildElement(contentElem, "suspendOnFailure");
	    if (null != suspendElem) {
	    	// Error codes.
	    	Element errorCodesElem = getChildElement(suspendElem, "errorCodes");
	    	if (null != errorCodesElem) {
	    		setSuspendErrorCodes(errorCodesElem.getTextContent());
	    	}
	    	
	    	// Initial duration.
	    	Element initialDurationElem = getChildElement(suspendElem, "initialDuration");
	    	if (null != initialDurationElem) {
	    		try {
	    			setSuspendInitialDuration(Long.parseLong(initialDurationElem.getTextContent()));
	    		} catch (Exception ex) {
	    			// TODO: Log here.
	    		} 
	    	}
	    	
	    	// Maximum duration.
	    	Element maximumDurationElem = getChildElement(suspendElem, "maximumDuration");
	    	if (null != maximumDurationElem) {
	    		try {
	    			setSuspendMaximumDuration(Long.parseLong(maximumDurationElem.getTextContent()));
	    		} catch (Exception ex) {
	    			// TODO: Log here.
	    		} 
	    	}
	    	
	    	// Progression factor.
	    	Element progressionFactorElem = getChildElement(suspendElem, "progressionFactor");
	    	if (null != progressionFactorElem) {
	    		try {
	    			setSuspendProgressionFactor(Float.parseFloat(progressionFactorElem.getTextContent()));
	    		}  catch (Exception ex) {
	    			// TODO: Log here.
	    		} 
	    	}
	    }
    }
    
    /**
     * Stores the state of this {@link AbstractEndPointImpl} into the specified element.
     * 
     * @param contentElem {@link Element} into which the state of this {@link AbstractEndPointImpl} is to be written.
     * @throws Exception if an error occurs while saving content.
     */
    protected void storeContent(Element contentElem) throws Exception {
    	// Reliable messaging.
    	if (isReliableMessagingEnabled()) {
    		Element reliableMessagingElem = createChildElement(contentElem, "enableRM");
    		if (null != getReliableMessagingPolicy()) {
    			getReliableMessagingPolicy().save(reliableMessagingElem);
    		}
    	}
    	
    	// Security.
    	if (isSecurityEnabled()) {
    		Element securityElem = createChildElement(contentElem, "enableSec");
    		if (null != getSecurityPolicy()) {
    			getSecurityPolicy().save(securityElem);
    		}
    	}
    	
    	// Addressing.
    	if (isAddressingEnabled()) {
    		Element addressingElem = createChildElement(contentElem, "enableAddressing");
    		
    		// Version.
    		addressingElem.setAttribute("version", getAddressingVersion().getLiteral());
    		
    		// Listener.
    		boolean separateListener = isAddressingSeparateListener();
    		if (separateListener) {
    			addressingElem.setAttribute("separateListener", Boolean.toString(separateListener));
    		}
    	}
    	
    	// Timeout.
    	{
    		Element timeOutElem = createChildElement(contentElem, "timeout");
    		
    		// Duration.
    		Element durationElem = createChildElement(timeOutElem, "duration");
    		durationElem.setTextContent(Long.toString(getTimeOutDuration()));
    		
    		// Action
    		Element actionElem = createChildElement(timeOutElem, "responseAction");
    		actionElem.setTextContent(getTimeOutAction().getLiteral());
    	}
    	
    	// Retry.
    	{
    		Element retryElem = createChildElement(contentElem, "markForSuspension");
    		
    		// Error codes.
    		String errorCodes = getRetryErrorCodes();
    		if (!StringUtils.isBlank(errorCodes)) {
    			Element errorCodesElem = createChildElement(retryElem, "errorCodes");
    			errorCodesElem.setTextContent(errorCodes);
    		}
    		
    		// Retry count.
    		{
    			Element retryCountElem = createChildElement(retryElem, "retriesBeforeSuspension");
    			retryCountElem.setTextContent(Integer.toString(getRetryCount()));
    		}
    		
    		// Retry delay.
    		{
    			Element retryDelayElem = createChildElement(retryElem, "retryDelay");
    			retryDelayElem.setTextContent(Long.toString(getRetryDelay()));
    		}
    	}
    	
    	// Suspend.
    	{
    		Element suspendElem = createChildElement(contentElem, "suspendOnFailure");
    		
    		// Error codes.
    		String errorCodes = getSuspendErrorCodes();
    		if (!StringUtils.isBlank(errorCodes)) {
    			Element errorCodesElem = createChildElement(suspendElem, "errorCodes");
    			errorCodesElem.setTextContent(errorCodes);
    		}
    		
    		// Initial duration.
    		{
    			Element initialDurationElem = createChildElement(suspendElem, "initialDuration");
    			initialDurationElem.setTextContent(Long.toString(getSuspendInitialDuration()));
    		}
    		
    		// Maximum duration.
    		{
    			Element maximumDurationElem = createChildElement(suspendElem, "maximumDuration");
    			maximumDurationElem.setTextContent(Long.toString(getSuspendMaximumDuration()));
    		}
    		
    		// Progression factor.
    		{
    			Element progressionFactorElem = createChildElement(suspendElem, "progressionFactor");
    			progressionFactorElem.setTextContent(Float.toString(getSuspendProgressionFactor()));
    		}
    	}
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
    public RegistryKeyProperty getReliableMessagingPolicy() {
		if (reliableMessagingPolicy != null && reliableMessagingPolicy.eIsProxy()) {
			InternalEObject oldReliableMessagingPolicy = (InternalEObject)reliableMessagingPolicy;
			reliableMessagingPolicy = (RegistryKeyProperty)eResolveProxy(oldReliableMessagingPolicy);
			if (reliableMessagingPolicy != oldReliableMessagingPolicy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, oldReliableMessagingPolicy, reliableMessagingPolicy));
			}
		}
		return reliableMessagingPolicy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public RegistryKeyProperty basicGetReliableMessagingPolicy() {
		return reliableMessagingPolicy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setReliableMessagingPolicy(RegistryKeyProperty newReliableMessagingPolicy) {
		RegistryKeyProperty oldReliableMessagingPolicy = reliableMessagingPolicy;
		reliableMessagingPolicy = newReliableMessagingPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, oldReliableMessagingPolicy, reliableMessagingPolicy));
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
    public RegistryKeyProperty getSecurityPolicy() {
		if (securityPolicy != null && securityPolicy.eIsProxy()) {
			InternalEObject oldSecurityPolicy = (InternalEObject)securityPolicy;
			securityPolicy = (RegistryKeyProperty)eResolveProxy(oldSecurityPolicy);
			if (securityPolicy != oldSecurityPolicy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY, oldSecurityPolicy, securityPolicy));
			}
		}
		return securityPolicy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public RegistryKeyProperty basicGetSecurityPolicy() {
		return securityPolicy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSecurityPolicy(RegistryKeyProperty newSecurityPolicy) {
		RegistryKeyProperty oldSecurityPolicy = securityPolicy;
		securityPolicy = newSecurityPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY, oldSecurityPolicy, securityPolicy));
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
				if (resolve) return getReliableMessagingPolicy();
				return basicGetReliableMessagingPolicy();
			case EsbPackage.ABSTRACT_END_POINT__SECURITY_POLICY:
				if (resolve) return getSecurityPolicy();
				return basicGetSecurityPolicy();
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
		result.append(')');
		return result.toString();
	}

} //AbstractEndPointImpl
