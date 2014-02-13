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
 * A representation of the model object '<em><b>Address End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getMessageFormat <em>Message Format</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getAttachmentOptimization <em>Attachment Optimization</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#isStatisticsEnabled <em>Statistics Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#isTraceEnabled <em>Trace Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getRestType <em>Rest Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractDefaultEndPoint()
 * @model abstract="true"
 * @generated
 */
public interface AbstractDefaultEndPoint extends AbstractEndPoint {
    /**
	 * Returns the value of the '<em><b>Message Format</b></em>' attribute.
	 * The default value is <code>"LEAVE_AS_IS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.EndPointMessageFormat}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Message Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Format</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointMessageFormat
	 * @see #setMessageFormat(EndPointMessageFormat)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractDefaultEndPoint_MessageFormat()
	 * @model default="LEAVE_AS_IS"
	 * @generated
	 */
    EndPointMessageFormat getMessageFormat();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getMessageFormat <em>Message Format</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Format</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointMessageFormat
	 * @see #getMessageFormat()
	 * @generated
	 */
    void setMessageFormat(EndPointMessageFormat value);

    /**
	 * Returns the value of the '<em><b>Attachment Optimization</b></em>' attribute.
	 * The default value is <code>"LEAVE_AS_IS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.EndPointAttachmentOptimization}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attachment Optimization</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment Optimization</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointAttachmentOptimization
	 * @see #setAttachmentOptimization(EndPointAttachmentOptimization)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractDefaultEndPoint_AttachmentOptimization()
	 * @model default="LEAVE_AS_IS"
	 * @generated
	 */
    EndPointAttachmentOptimization getAttachmentOptimization();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getAttachmentOptimization <em>Attachment Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment Optimization</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointAttachmentOptimization
	 * @see #getAttachmentOptimization()
	 * @generated
	 */
    void setAttachmentOptimization(EndPointAttachmentOptimization value);

    /**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * The default value is <code>"UTF-8"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractDefaultEndPoint_Encoding()
	 * @model default="UTF-8"
	 * @generated
	 */
    String getEncoding();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
    void setEncoding(String value);

    /**
	 * Returns the value of the '<em><b>Statistics Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Statistics Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistics Enabled</em>' attribute.
	 * @see #setStatisticsEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractDefaultEndPoint_StatisticsEnabled()
	 * @model default="false"
	 * @generated
	 */
    boolean isStatisticsEnabled();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#isStatisticsEnabled <em>Statistics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistics Enabled</em>' attribute.
	 * @see #isStatisticsEnabled()
	 * @generated
	 */
    void setStatisticsEnabled(boolean value);

    /**
	 * Returns the value of the '<em><b>Trace Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trace Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Enabled</em>' attribute.
	 * @see #setTraceEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractDefaultEndPoint_TraceEnabled()
	 * @model default="false"
	 * @generated
	 */
    boolean isTraceEnabled();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#isTraceEnabled <em>Trace Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Enabled</em>' attribute.
	 * @see #isTraceEnabled()
	 * @generated
	 */
    void setTraceEnabled(boolean value);

    /**
	 * Returns the value of the '<em><b>Rest Type</b></em>' attribute.
	 * The default value is <code>"get"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.EndPointMessageFormatRestType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rest Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointMessageFormatRestType
	 * @see #setRestType(EndPointMessageFormatRestType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractDefaultEndPoint_RestType()
	 * @model default="get"
	 * @generated
	 */
    EndPointMessageFormatRestType getRestType();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint#getRestType <em>Rest Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointMessageFormatRestType
	 * @see #getRestType()
	 * @generated
	 */
    void setRestType(EndPointMessageFormatRestType value);

} // AddressEndPoint
