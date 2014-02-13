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
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AddressEndPoint#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAddressEndPoint()
 * @model
 * @generated
 */
public interface AddressEndPoint extends AbstractDefaultEndPoint {
    /**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * The default value is <code>"http://default/address/endpoint/uri"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAddressEndPoint_Uri()
	 * @model default="http://default/address/endpoint/uri"
	 * @generated
	 */
    String getUri();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AddressEndPoint#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
    void setUri(String value);

} // AddressEndPoint
