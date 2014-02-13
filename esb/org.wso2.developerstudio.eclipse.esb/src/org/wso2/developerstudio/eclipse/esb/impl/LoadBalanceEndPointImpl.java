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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceSessionType;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Balance End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LoadBalanceEndPointImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LoadBalanceEndPointImpl#getSessionType <em>Session Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.LoadBalanceEndPointImpl#getSessionTimeout <em>Session Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadBalanceEndPointImpl extends ParentEndPointImpl implements LoadBalanceEndPoint {
    /**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
    protected static final LoadBalanceAlgorithm ALGORITHM_EDEFAULT = LoadBalanceAlgorithm.ROUND_ROBIN;

    /**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
    protected LoadBalanceAlgorithm algorithm = ALGORITHM_EDEFAULT;

    /**
	 * The default value of the '{@link #getSessionType() <em>Session Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSessionType()
	 * @generated
	 * @ordered
	 */
    protected static final LoadBalanceSessionType SESSION_TYPE_EDEFAULT = LoadBalanceSessionType.NONE;

    /**
	 * The cached value of the '{@link #getSessionType() <em>Session Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSessionType()
	 * @generated
	 * @ordered
	 */
    protected LoadBalanceSessionType sessionType = SESSION_TYPE_EDEFAULT;

    /**
	 * The default value of the '{@link #getSessionTimeout() <em>Session Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSessionTimeout()
	 * @generated
	 * @ordered
	 */
    protected static final long SESSION_TIMEOUT_EDEFAULT = 0L;

    /**
	 * The cached value of the '{@link #getSessionTimeout() <em>Session Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSessionTimeout()
	 * @generated
	 * @ordered
	 */
    protected long sessionTimeout = SESSION_TIMEOUT_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected LoadBalanceEndPointImpl() {
		super();
	}

    /**
     * {@inheritDoc}
     */
    public void doLoad(Element self) throws Exception {
	    super.doLoad(self);
	    
	    // Get the <loadbalance/> element.
	    Element loadBalanceElem = getChildElement(self, "loadbalance");
	    
	    // Algorithm.
	    LoadBalanceAlgorithm algorithm = 
	    	LoadBalanceAlgorithm.get(loadBalanceElem.getAttribute("algorithm"));
	    if (null != algorithm) {
	    	setAlgorithm(algorithm);
	    }
	    
	    // Check for <session/> sub-element.
	    Element sessionElem = getChildElement(loadBalanceElem, "session");
	    if (null != sessionElem) {	    	
	    	LoadBalanceSessionType sessionType = 
	    		LoadBalanceSessionType.get(sessionElem.getAttribute("type"));
	    	if (null != sessionType) {
	    		setSessionType(sessionType);

	    		// Read session timeout.
	    		Element sessionTimeoutElem = getChildElement(sessionElem, "sessionTimeout");	    		
	    		if (null != sessionTimeoutElem) {
	    			try {
	    				setSessionTimeout(Long.parseLong(sessionTimeoutElem.getTextContent()));
	    			} catch (Exception ex) {
	    				// TODO: Log the exception.
	    			}
	    		}
	    	}
	    }
	    
	    // Children.
	    loadChildren(loadBalanceElem);
    }

    /**
     * {@inheritDoc}
     */
    public Element doSave(Element parent) throws Exception {
	    Element self = super.doSave(parent);
	    
	    // Create the <loadbalance/> element.
	    Element loadBalanceElem = createChildElement(self, "loadbalance");
	    
	    // Algorithm.
	    loadBalanceElem.setAttribute("algorithm", getAlgorithm().getLiteral());
	    
	    // Session.
	    if (!getSessionType().equals(LoadBalanceSessionType.NONE)) {
	    	Element sessionElem = createChildElement(loadBalanceElem, "session");
	    	sessionElem.setAttribute("type", getSessionType().getLiteral());
	    	
	    	// Session timeout.
	    	Element sessionTimeoutElem = createChildElement(sessionElem, "sessionTimeout");
	    	sessionTimeoutElem.setTextContent(Long.toString(getSessionTimeout()));
	    }
	    
	    // Children.
	    storeChildren(loadBalanceElem);
	    	
	    addComments(self);
	    return self;
    }

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				protected EClass eStaticClass() {
		return EsbPackage.Literals.LOAD_BALANCE_END_POINT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public LoadBalanceAlgorithm getAlgorithm() {
		return algorithm;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setAlgorithm(LoadBalanceAlgorithm newAlgorithm) {
		LoadBalanceAlgorithm oldAlgorithm = algorithm;
		algorithm = newAlgorithm == null ? ALGORITHM_EDEFAULT : newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM, oldAlgorithm, algorithm));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public LoadBalanceSessionType getSessionType() {
		return sessionType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSessionType(LoadBalanceSessionType newSessionType) {
		LoadBalanceSessionType oldSessionType = sessionType;
		sessionType = newSessionType == null ? SESSION_TYPE_EDEFAULT : newSessionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE, oldSessionType, sessionType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public long getSessionTimeout() {
		return sessionTimeout;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSessionTimeout(long newSessionTimeout) {
		long oldSessionTimeout = sessionTimeout;
		sessionTimeout = newSessionTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT, oldSessionTimeout, sessionTimeout));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    
    @Override
				public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				return getAlgorithm();
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				return getSessionType();
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				return getSessionTimeout();
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
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				setAlgorithm((LoadBalanceAlgorithm)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				setSessionType((LoadBalanceSessionType)newValue);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				setSessionTimeout((Long)newValue);
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
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				setSessionType(SESSION_TYPE_EDEFAULT);
				return;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				setSessionTimeout(SESSION_TIMEOUT_EDEFAULT);
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
			case EsbPackage.LOAD_BALANCE_END_POINT__ALGORITHM:
				return algorithm != ALGORITHM_EDEFAULT;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TYPE:
				return sessionType != SESSION_TYPE_EDEFAULT;
			case EsbPackage.LOAD_BALANCE_END_POINT__SESSION_TIMEOUT:
				return sessionTimeout != SESSION_TIMEOUT_EDEFAULT;
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
		result.append(" (algorithm: ");
		result.append(algorithm);
		result.append(", sessionType: ");
		result.append(sessionType);
		result.append(", sessionTimeout: ");
		result.append(sessionTimeout);
		result.append(')');
		return result.toString();
	}

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //LoadBalanceEndPointImpl
