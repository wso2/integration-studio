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

import org.eclipse.emf.common.util.EList;

import org.wso2.developerstudio.eclipse.esb.Mediator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URL Rewrite Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getUrlRewriteRules <em>Url Rewrite Rules</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getInProperty <em>In Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getOutProperty <em>Out Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteMediator()
 * @model
 * @generated
 */
public interface URLRewriteMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Url Rewrite Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Rewrite Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Rewrite Rules</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteMediator_UrlRewriteRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<URLRewriteRule> getUrlRewriteRules();

	/**
	 * Returns the value of the '<em><b>In Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Property</em>' attribute.
	 * @see #setInProperty(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteMediator_InProperty()
	 * @model
	 * @generated
	 */
	String getInProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getInProperty <em>In Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Property</em>' attribute.
	 * @see #getInProperty()
	 * @generated
	 */
	void setInProperty(String value);

	/**
	 * Returns the value of the '<em><b>Out Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Property</em>' attribute.
	 * @see #setOutProperty(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getURLRewriteMediator_OutProperty()
	 * @model
	 * @generated
	 */
	String getOutProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getOutProperty <em>Out Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Property</em>' attribute.
	 * @see #getOutProperty()
	 * @generated
	 */
	void setOutProperty(String value);

} // URLRewriteMediator
