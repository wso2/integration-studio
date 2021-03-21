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
 * A representation of the model object '<em><b>Abstract DSS Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.AbstractDSSOperation#getDSSPrperties <em>DSS Prperties</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.AbstractDSSOperation#getOperationName <em>Operation Name</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getAbstractDSSOperation()
 * @model
 * @generated
 */
public interface AbstractDSSOperation extends EsbNode {
    /**
     * Returns the value of the '<em><b>DSS Prperties</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.integrationstudio.gmf.esb.DSSoperationProperty}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>DSS Prperties</em>' containment reference list.
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getAbstractDSSOperation_DSSPrperties()
     * @model containment="true"
     * @generated
     */
    EList<DSSoperationProperty> getDSSPrperties();

    /**
     * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Name</em>' attribute.
     * @see #setOperationName(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getAbstractDSSOperation_OperationName()
     * @model
     * @generated
     */
    String getOperationName();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.AbstractDSSOperation#getOperationName <em>Operation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Name</em>' attribute.
     * @see #getOperationName()
     * @generated
     */
    void setOperationName(String value);

} // AbstractDSSOperation
