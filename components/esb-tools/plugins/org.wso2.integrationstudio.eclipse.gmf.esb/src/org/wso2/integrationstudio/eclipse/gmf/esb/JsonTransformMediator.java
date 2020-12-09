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
package org.wso2.integrationstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Json Transform Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator#getJsonTransformProperties <em>Json Transform Properties</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator#getSchema <em>Schema</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getJsonTransformMediator()
 * @model
 * @generated
 */
public interface JsonTransformMediator extends Mediator {
    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(JsonTransformMediatorInputConnector)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getJsonTransformMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    JsonTransformMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(JsonTransformMediatorInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(JsonTransformMediatorOutputConnector)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getJsonTransformMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
    JsonTransformMediatorOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
    void setOutputConnector(JsonTransformMediatorOutputConnector value);

    /**
     * Returns the value of the '<em><b>Json Transform Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediatorProperty}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Json Transform Properties</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Json Transform Properties</em>' containment reference list.
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getJsonTransformMediator_JsonTransformProperties()
     * @model containment="true"
     * @generated
     */
    EList<JsonTransformMediatorProperty> getJsonTransformProperties();

    /**
     * Returns the value of the '<em><b>Schema</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Schema</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Schema</em>' containment reference.
     * @see #setSchema(RegistryKeyProperty)
     * @see org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage#getJsonTransformMediator_Schema()
     * @model containment="true"
     * @generated
     */
    RegistryKeyProperty getSchema();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.eclipse.gmf.esb.JsonTransformMediator#getSchema <em>Schema</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Schema</em>' containment reference.
     * @see #getSchema()
     * @generated
     */
    void setSchema(RegistryKeyProperty value);

} // JsonTransformMediator
