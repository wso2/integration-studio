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
 * A representation of the model object '<em><b>Wsdl End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getWsdlType <em>Wsdl Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getWsdlURI <em>Wsdl URI</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getWsdlXML <em>Wsdl XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getService <em>Service</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getWsdlEndPoint()
 * @model
 * @generated
 */
public interface WsdlEndPoint extends AbstractEndPoint {
    /**
	 * Returns the value of the '<em><b>Wsdl Type</b></em>' attribute.
	 * The default value is <code>"URI"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.EndPointWsdlType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wsdl Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointWsdlType
	 * @see #setWsdlType(EndPointWsdlType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getWsdlEndPoint_WsdlType()
	 * @model default="URI"
	 * @generated
	 */
    EndPointWsdlType getWsdlType();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getWsdlType <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointWsdlType
	 * @see #getWsdlType()
	 * @generated
	 */
    void setWsdlType(EndPointWsdlType value);

    /**
	 * Returns the value of the '<em><b>Wsdl URI</b></em>' attribute.
	 * The default value is <code>"http://default/wsdl/uri"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wsdl URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl URI</em>' attribute.
	 * @see #setWsdlURI(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getWsdlEndPoint_WsdlURI()
	 * @model default="http://default/wsdl/uri"
	 * @generated
	 */
    String getWsdlURI();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getWsdlURI <em>Wsdl URI</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl URI</em>' attribute.
	 * @see #getWsdlURI()
	 * @generated
	 */
    void setWsdlURI(String value);

    /**
	 * Returns the value of the '<em><b>Wsdl XML</b></em>' attribute.
	 * The default value is <code>"<definitions/>"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wsdl XML</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl XML</em>' attribute.
	 * @see #setWsdlXML(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getWsdlEndPoint_WsdlXML()
	 * @model default="<definitions/>"
	 * @generated
	 */
    String getWsdlXML();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getWsdlXML <em>Wsdl XML</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl XML</em>' attribute.
	 * @see #getWsdlXML()
	 * @generated
	 */
    void setWsdlXML(String value);

    /**
	 * Returns the value of the '<em><b>Service</b></em>' attribute.
	 * The default value is <code>"Service"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' attribute.
	 * @see #setService(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getWsdlEndPoint_Service()
	 * @model default="Service"
	 * @generated
	 */
    String getService();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getService <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' attribute.
	 * @see #getService()
	 * @generated
	 */
    void setService(String value);

    /**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * The default value is <code>"Port"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getWsdlEndPoint_Port()
	 * @model default="Port"
	 * @generated
	 */
    String getPort();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
    void setPort(String value);

} // WsdlEndPoint
