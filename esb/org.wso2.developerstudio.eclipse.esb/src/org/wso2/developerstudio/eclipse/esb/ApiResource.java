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
package org.wso2.developerstudio.eclipse.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Api Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getInSequenceConfiguration <em>In Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getOutSequenceConfiguration <em>Out Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getFaultSequenceConfiguration <em>Fault Sequence Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getUrlStyle <em>Url Style</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getUriTemplate <em>Uri Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getUrlMapping <em>Url Mapping</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowGet <em>Allow Get</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowPost <em>Allow Post</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowPut <em>Allow Put</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowDelete <em>Allow Delete</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowOptions <em>Allow Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource()
 * @model
 * @generated
 */
public interface ApiResource extends ModelObject {
	/**
	 * Returns the value of the '<em><b>In Sequence Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence Configuration</em>' containment reference.
	 * @see #setInSequenceConfiguration(ApiInSequenceConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_InSequenceConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ApiInSequenceConfiguration getInSequenceConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getInSequenceConfiguration <em>In Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence Configuration</em>' containment reference.
	 * @see #getInSequenceConfiguration()
	 * @generated
	 */
	void setInSequenceConfiguration(ApiInSequenceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Out Sequence Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence Configuration</em>' containment reference.
	 * @see #setOutSequenceConfiguration(ApiOutSequenceConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_OutSequenceConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ApiOutSequenceConfiguration getOutSequenceConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getOutSequenceConfiguration <em>Out Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence Configuration</em>' containment reference.
	 * @see #getOutSequenceConfiguration()
	 * @generated
	 */
	void setOutSequenceConfiguration(ApiOutSequenceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Fault Sequence Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Sequence Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Sequence Configuration</em>' containment reference.
	 * @see #setFaultSequenceConfiguration(ApiFaultSequenceConfiguration)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_FaultSequenceConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ApiFaultSequenceConfiguration getFaultSequenceConfiguration();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getFaultSequenceConfiguration <em>Fault Sequence Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Sequence Configuration</em>' containment reference.
	 * @see #getFaultSequenceConfiguration()
	 * @generated
	 */
	void setFaultSequenceConfiguration(ApiFaultSequenceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Url Style</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.ApiResourceUrlStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Style</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ApiResourceUrlStyle
	 * @see #setUrlStyle(ApiResourceUrlStyle)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_UrlStyle()
	 * @model default="0" required="true"
	 * @generated
	 */
	ApiResourceUrlStyle getUrlStyle();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getUrlStyle <em>Url Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Style</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ApiResourceUrlStyle
	 * @see #getUrlStyle()
	 * @generated
	 */
	void setUrlStyle(ApiResourceUrlStyle value);

	/**
	 * Returns the value of the '<em><b>Uri Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Template</em>' attribute.
	 * @see #setUriTemplate(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_UriTemplate()
	 * @model
	 * @generated
	 */
	String getUriTemplate();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getUriTemplate <em>Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Template</em>' attribute.
	 * @see #getUriTemplate()
	 * @generated
	 */
	void setUriTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Url Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Mapping</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Mapping</em>' attribute.
	 * @see #setUrlMapping(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_UrlMapping()
	 * @model
	 * @generated
	 */
	String getUrlMapping();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#getUrlMapping <em>Url Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Mapping</em>' attribute.
	 * @see #getUrlMapping()
	 * @generated
	 */
	void setUrlMapping(String value);

	/**
	 * Returns the value of the '<em><b>Allow Get</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Get</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Get</em>' attribute.
	 * @see #setAllowGet(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_AllowGet()
	 * @model
	 * @generated
	 */
	boolean isAllowGet();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowGet <em>Allow Get</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Get</em>' attribute.
	 * @see #isAllowGet()
	 * @generated
	 */
	void setAllowGet(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Post</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Post</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Post</em>' attribute.
	 * @see #setAllowPost(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_AllowPost()
	 * @model
	 * @generated
	 */
	boolean isAllowPost();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowPost <em>Allow Post</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Post</em>' attribute.
	 * @see #isAllowPost()
	 * @generated
	 */
	void setAllowPost(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Put</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Put</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Put</em>' attribute.
	 * @see #setAllowPut(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_AllowPut()
	 * @model
	 * @generated
	 */
	boolean isAllowPut();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowPut <em>Allow Put</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Put</em>' attribute.
	 * @see #isAllowPut()
	 * @generated
	 */
	void setAllowPut(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Delete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Delete</em>' attribute.
	 * @see #setAllowDelete(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_AllowDelete()
	 * @model
	 * @generated
	 */
	boolean isAllowDelete();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowDelete <em>Allow Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Delete</em>' attribute.
	 * @see #isAllowDelete()
	 * @generated
	 */
	void setAllowDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Options</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Options</em>' attribute.
	 * @see #setAllowOptions(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getApiResource_AllowOptions()
	 * @model
	 * @generated
	 */
	boolean isAllowOptions();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ApiResource#isAllowOptions <em>Allow Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Options</em>' attribute.
	 * @see #isAllowOptions()
	 * @generated
	 */
	void setAllowOptions(boolean value);

} // ApiResource
