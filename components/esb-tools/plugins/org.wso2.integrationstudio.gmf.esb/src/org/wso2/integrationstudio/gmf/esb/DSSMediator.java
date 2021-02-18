/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSS Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator()
 * @model
 * @generated
 */
public interface DSSMediator extends Mediator {
    /**
     * Returns the value of the '<em><b>Service Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Name</em>' attribute.
     * @see #setServiceName(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator_ServiceName()
     * @model
     * @generated
     */
    String getServiceName();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getServiceName <em>Service Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Name</em>' attribute.
     * @see #getServiceName()
     * @generated
     */
    void setServiceName(String value);

    /**
     * Returns the value of the '<em><b>Source Type</b></em>' attribute.
     * The default value is <code>"INLINE"</code>.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.gmf.esb.DSSSourceType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.DSSSourceType
     * @see #setSourceType(DSSSourceType)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator_SourceType()
     * @model default="INLINE"
     * @generated
     */
    DSSSourceType getSourceType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getSourceType <em>Source Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.DSSSourceType
     * @see #getSourceType()
     * @generated
     */
    void setSourceType(DSSSourceType value);

    /**
     * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.integrationstudio.gmf.esb.DSSoperationProperty}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operations</em>' containment reference list.
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator_Operations()
     * @model containment="true"
     * @generated
     */
    EList<DSSoperationProperty> getOperations();

    /**
     * Returns the value of the '<em><b>Target Type</b></em>' attribute.
     * The default value is <code>"BODY"</code>.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.gmf.esb.DSSTargetType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.DSSTargetType
     * @see #setTargetType(DSSTargetType)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator_TargetType()
     * @model default="BODY"
     * @generated
     */
    DSSTargetType getTargetType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getTargetType <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.DSSTargetType
     * @see #getTargetType()
     * @generated
     */
    void setTargetType(DSSTargetType value);

    /**
     * Returns the value of the '<em><b>Target Property</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Property</em>' attribute.
     * @see #setTargetProperty(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator_TargetProperty()
     * @model
     * @generated
     */
    String getTargetProperty();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getTargetProperty <em>Target Property</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Property</em>' attribute.
     * @see #getTargetProperty()
     * @generated
     */
    void setTargetProperty(String value);

    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(DSSMediatorInputConnector)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    DSSMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(DSSMediatorInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(DSSMediatorOutputConnector)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
    DSSMediatorOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.DSSMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
    void setOutputConnector(DSSMediatorOutputConnector value);

} // DSSMediator
