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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint;
import org.wso2.developerstudio.eclipse.esb.EndPointAttachmentOptimization;
import org.wso2.developerstudio.eclipse.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.esb.EndPointMessageFormatRestType;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Address End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractDefaultEndPointImpl#getMessageFormat <em>Message Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractDefaultEndPointImpl#getAttachmentOptimization <em>Attachment Optimization</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractDefaultEndPointImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractDefaultEndPointImpl#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractDefaultEndPointImpl#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.AbstractDefaultEndPointImpl#getRestType <em>Rest Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractDefaultEndPointImpl extends AbstractEndPointImpl implements AbstractDefaultEndPoint {
    /**
	 * The default value of the '{@link #getMessageFormat() <em>Message Format</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getMessageFormat()
	 * @generated
	 * @ordered
	 */
    protected static final EndPointMessageFormat MESSAGE_FORMAT_EDEFAULT = EndPointMessageFormat.LEAVE_AS_IS;

    /**
	 * The cached value of the '{@link #getMessageFormat() <em>Message Format</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getMessageFormat()
	 * @generated
	 * @ordered
	 */
    protected EndPointMessageFormat messageFormat = MESSAGE_FORMAT_EDEFAULT;

    /**
	 * The default value of the '{@link #getAttachmentOptimization() <em>Attachment Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAttachmentOptimization()
	 * @generated
	 * @ordered
	 */
    protected static final EndPointAttachmentOptimization ATTACHMENT_OPTIMIZATION_EDEFAULT = EndPointAttachmentOptimization.LEAVE_AS_IS;

    /**
	 * The cached value of the '{@link #getAttachmentOptimization() <em>Attachment Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAttachmentOptimization()
	 * @generated
	 * @ordered
	 */
    protected EndPointAttachmentOptimization attachmentOptimization = ATTACHMENT_OPTIMIZATION_EDEFAULT;

    /**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
    protected static final String ENCODING_EDEFAULT = "UTF-8";

    /**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
    protected String encoding = ENCODING_EDEFAULT;

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
	 * The default value of the '{@link #getRestType() <em>Rest Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRestType()
	 * @generated
	 * @ordered
	 */
    protected static final EndPointMessageFormatRestType REST_TYPE_EDEFAULT = EndPointMessageFormatRestType.GET;

    /**
	 * The cached value of the '{@link #getRestType() <em>Rest Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRestType()
	 * @generated
	 * @ordered
	 */
    protected EndPointMessageFormatRestType restType = REST_TYPE_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected AbstractDefaultEndPointImpl() {
		super();
	}

    /**
     * {@inheritDoc}
     */
    protected void loadContent(Element contentElem) throws Exception {    	    	
    	// Message format.
    	String messageFormat = contentElem.getAttribute("format");
    	if("get".equalsIgnoreCase(messageFormat) || "rest".equalsIgnoreCase(messageFormat)){
    		setMessageFormat(EndPointMessageFormat.get("get"));
    		setRestType(EndPointMessageFormatRestType.get(messageFormat));
    	} else{
    		setMessageFormat(EndPointMessageFormat.get(contentElem.getAttribute("format")));
    	}
    	
    	// Attachment optimization.
    	setAttachmentOptimization(EndPointAttachmentOptimization.get(contentElem.getAttribute("optimize")));
    	
    	// Encoding.
    	setEncoding(contentElem.getAttribute("encoding"));
    	
    	// Trace.
    	if (contentElem.getAttribute("trace").equals("enable")) {
    		setTraceEnabled(true);
    	}
    	
    	// Statistics.
    	if (contentElem.getAttribute("statistics").equals("enable")) {
    		setStatisticsEnabled(true);
    	}    		    
    	
    	super.loadContent(contentElem);
    }

	/**
	 * {@inheritDoc}
	 */
    protected void storeContent(Element contentElem) throws Exception {
    	// Message format.
		if (!getMessageFormat().equals(EndPointMessageFormat.LEAVE_AS_IS)) {
			if(getMessageFormat().equals(EndPointMessageFormat.GET)){
				contentElem.setAttribute("format", getRestType().getLiteral());
			} else{
				contentElem.setAttribute("format", getMessageFormat().getLiteral());
			}
		}
		
		// Attachment optimization.
		if (!getAttachmentOptimization().equals(EndPointAttachmentOptimization.LEAVE_AS_IS)) {
			contentElem.setAttribute("optimize", getAttachmentOptimization().getLiteral());
		}
		
		// Encoding.
		if (!StringUtils.isBlank(getEncoding())) {
			contentElem.setAttribute("encoding", getEncoding());
		}
		
		// Trace.
		{
			String trace = "disable";
			if (isTraceEnabled()) {
				trace = "enable";
			}
			contentElem.setAttribute("trace", trace);
		}
		
		// Statistics.
		{
			String statistics = "disable";
			if (isStatisticsEnabled()) {
				statistics = "enable";
			}
			contentElem.setAttribute("statistics", statistics);
		}
    	
	    super.storeContent(contentElem);
    }

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				protected EClass eStaticClass() {
		return EsbPackage.Literals.ABSTRACT_DEFAULT_END_POINT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EndPointMessageFormat getMessageFormat() {
		return messageFormat;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setMessageFormat(EndPointMessageFormat newMessageFormat) {
		EndPointMessageFormat oldMessageFormat = messageFormat;
		messageFormat = newMessageFormat == null ? MESSAGE_FORMAT_EDEFAULT : newMessageFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT, oldMessageFormat, messageFormat));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EndPointAttachmentOptimization getAttachmentOptimization() {
		return attachmentOptimization;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setAttachmentOptimization(EndPointAttachmentOptimization newAttachmentOptimization) {
		EndPointAttachmentOptimization oldAttachmentOptimization = attachmentOptimization;
		attachmentOptimization = newAttachmentOptimization == null ? ATTACHMENT_OPTIMIZATION_EDEFAULT : newAttachmentOptimization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION, oldAttachmentOptimization, attachmentOptimization));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getEncoding() {
		return encoding;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setEncoding(String newEncoding) {
		String oldEncoding = encoding;
		encoding = newEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_DEFAULT_END_POINT__ENCODING, oldEncoding, encoding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED, oldStatisticsEnabled, statisticsEnabled));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED, oldTraceEnabled, traceEnabled));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EndPointMessageFormatRestType getRestType() {
		return restType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRestType(EndPointMessageFormatRestType newRestType) {
		EndPointMessageFormatRestType oldRestType = restType;
		restType = newRestType == null ? REST_TYPE_EDEFAULT : newRestType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_DEFAULT_END_POINT__REST_TYPE, oldRestType, restType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT:
				return getMessageFormat();
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION:
				return getAttachmentOptimization();
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ENCODING:
				return getEncoding();
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED:
				return isStatisticsEnabled();
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED:
				return isTraceEnabled();
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__REST_TYPE:
				return getRestType();
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
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT:
				setMessageFormat((EndPointMessageFormat)newValue);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION:
				setAttachmentOptimization((EndPointAttachmentOptimization)newValue);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ENCODING:
				setEncoding((String)newValue);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED:
				setStatisticsEnabled((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED:
				setTraceEnabled((Boolean)newValue);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__REST_TYPE:
				setRestType((EndPointMessageFormatRestType)newValue);
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
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT:
				setMessageFormat(MESSAGE_FORMAT_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION:
				setAttachmentOptimization(ATTACHMENT_OPTIMIZATION_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ENCODING:
				setEncoding(ENCODING_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED:
				setStatisticsEnabled(STATISTICS_ENABLED_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED:
				setTraceEnabled(TRACE_ENABLED_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__REST_TYPE:
				setRestType(REST_TYPE_EDEFAULT);
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
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT:
				return messageFormat != MESSAGE_FORMAT_EDEFAULT;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION:
				return attachmentOptimization != ATTACHMENT_OPTIMIZATION_EDEFAULT;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__ENCODING:
				return ENCODING_EDEFAULT == null ? encoding != null : !ENCODING_EDEFAULT.equals(encoding);
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED:
				return statisticsEnabled != STATISTICS_ENABLED_EDEFAULT;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED:
				return traceEnabled != TRACE_ENABLED_EDEFAULT;
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT__REST_TYPE:
				return restType != REST_TYPE_EDEFAULT;
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
		result.append(" (messageFormat: ");
		result.append(messageFormat);
		result.append(", attachmentOptimization: ");
		result.append(attachmentOptimization);
		result.append(", encoding: ");
		result.append(encoding);
		result.append(", statisticsEnabled: ");
		result.append(statisticsEnabled);
		result.append(", traceEnabled: ");
		result.append(traceEnabled);
		result.append(", restType: ");
		result.append(restType);
		result.append(')');
		return result.toString();
	}

} //AddressEndPointImpl
