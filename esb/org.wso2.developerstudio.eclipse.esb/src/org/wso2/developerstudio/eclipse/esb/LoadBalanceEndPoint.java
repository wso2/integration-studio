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
package org.wso2.developerstudio.eclipse.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Balance End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint#getSessionType <em>Session Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint#getSessionTimeout <em>Session Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getLoadBalanceEndPoint()
 * @model
 * @generated
 */
public interface LoadBalanceEndPoint extends ParentEndPoint {
    /**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * The default value is <code>"org.apache.synapse.endpoints.algorithms.RoundRobin"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Algorithm</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm
	 * @see #setAlgorithm(LoadBalanceAlgorithm)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getLoadBalanceEndPoint_Algorithm()
	 * @model default="org.apache.synapse.endpoints.algorithms.RoundRobin"
	 * @generated
	 */
    LoadBalanceAlgorithm getAlgorithm();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm
	 * @see #getAlgorithm()
	 * @generated
	 */
    void setAlgorithm(LoadBalanceAlgorithm value);

    /**
	 * Returns the value of the '<em><b>Session Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.LoadBalanceSessionType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Session Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.LoadBalanceSessionType
	 * @see #setSessionType(LoadBalanceSessionType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getLoadBalanceEndPoint_SessionType()
	 * @model default="NONE"
	 * @generated
	 */
    LoadBalanceSessionType getSessionType();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint#getSessionType <em>Session Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.LoadBalanceSessionType
	 * @see #getSessionType()
	 * @generated
	 */
    void setSessionType(LoadBalanceSessionType value);

    /**
	 * Returns the value of the '<em><b>Session Timeout</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Session Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Timeout</em>' attribute.
	 * @see #setSessionTimeout(long)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getLoadBalanceEndPoint_SessionTimeout()
	 * @model default="0"
	 * @generated
	 */
    long getSessionTimeout();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint#getSessionTimeout <em>Session Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Timeout</em>' attribute.
	 * @see #getSessionTimeout()
	 * @generated
	 */
    void setSessionTimeout(long value);

} // LoadBalanceEndPoint
