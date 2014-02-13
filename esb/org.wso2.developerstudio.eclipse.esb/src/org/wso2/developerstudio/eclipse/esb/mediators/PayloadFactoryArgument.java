/**
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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Payload Factory Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentType <em>Argument Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentValue <em>Argument Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentExpression <em>Argument Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPayloadFactoryArgument()
 * @model
 * @generated
 */
public interface PayloadFactoryArgument extends ModelObject {
    /**
	 * Returns the value of the '<em><b>Argument Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Argument Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType
	 * @see #setArgumentType(PayloadFactoryArgumentType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPayloadFactoryArgument_ArgumentType()
	 * @model
	 * @generated
	 */
    PayloadFactoryArgumentType getArgumentType();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentType <em>Argument Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType
	 * @see #getArgumentType()
	 * @generated
	 */
    void setArgumentType(PayloadFactoryArgumentType value);

    /**
	 * Returns the value of the '<em><b>Argument Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Argument Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument Value</em>' attribute.
	 * @see #setArgumentValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPayloadFactoryArgument_ArgumentValue()
	 * @model
	 * @generated
	 */
    String getArgumentValue();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentValue <em>Argument Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument Value</em>' attribute.
	 * @see #getArgumentValue()
	 * @generated
	 */
    void setArgumentValue(String value);

    /**
	 * Returns the value of the '<em><b>Argument Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Argument Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument Expression</em>' reference.
	 * @see #setArgumentExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getPayloadFactoryArgument_ArgumentExpression()
	 * @model
	 * @generated
	 */
    NamespacedProperty getArgumentExpression();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentExpression <em>Argument Expression</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument Expression</em>' reference.
	 * @see #getArgumentExpression()
	 * @generated
	 */
    void setArgumentExpression(NamespacedProperty value);

} // PayloadFactoryArgument
