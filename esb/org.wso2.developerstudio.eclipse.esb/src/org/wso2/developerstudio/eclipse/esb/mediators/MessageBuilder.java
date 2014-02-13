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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.ModelObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Builder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getBuilderClass <em>Builder Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getFormatterClass <em>Formatter Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getMessageBuilder()
 * @model
 * @generated
 */
public interface MessageBuilder extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Content Type</b></em>' attribute.
	 * The default value is <code>"application/xml"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type</em>' attribute.
	 * @see #setContentType(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getMessageBuilder_ContentType()
	 * @model default="application/xml"
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * Returns the value of the '<em><b>Builder Class</b></em>' attribute.
	 * The default value is <code>"org.apache.axis2.builder.ApplicationXMLBuilder"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Builder Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Builder Class</em>' attribute.
	 * @see #setBuilderClass(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getMessageBuilder_BuilderClass()
	 * @model default="org.apache.axis2.builder.ApplicationXMLBuilder"
	 * @generated
	 */
	String getBuilderClass();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getBuilderClass <em>Builder Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Builder Class</em>' attribute.
	 * @see #getBuilderClass()
	 * @generated
	 */
	void setBuilderClass(String value);

	/**
	 * Returns the value of the '<em><b>Formatter Class</b></em>' attribute.
	 * The default value is <code>"org.apache.axis2.transport.http.ApplicationXMLFormatter"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formatter Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formatter Class</em>' attribute.
	 * @see #setFormatterClass(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getMessageBuilder_FormatterClass()
	 * @model default="org.apache.axis2.transport.http.ApplicationXMLFormatter"
	 * @generated
	 */
	String getFormatterClass();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getFormatterClass <em>Formatter Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formatter Class</em>' attribute.
	 * @see #getFormatterClass()
	 * @generated
	 */
	void setFormatterClass(String value);

} // MessageBuilder
