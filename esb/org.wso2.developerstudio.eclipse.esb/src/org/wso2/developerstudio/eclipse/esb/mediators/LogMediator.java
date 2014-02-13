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

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.esb.Mediator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogCategory <em>Log Category</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogLevel <em>Log Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogSeparator <em>Log Separator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getLogMediator()
 * @model
 * @generated
 */
public interface LogMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Log Category</b></em>' attribute.
	 * The default value is <code>"INFO"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.LogCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Category</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogCategory
	 * @see #setLogCategory(LogCategory)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getLogMediator_LogCategory()
	 * @model default="INFO"
	 * @generated
	 */
	LogCategory getLogCategory();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogCategory <em>Log Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Category</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogCategory
	 * @see #getLogCategory()
	 * @generated
	 */
	void setLogCategory(LogCategory value);

	/**
	 * Returns the value of the '<em><b>Log Level</b></em>' attribute.
	 * The default value is <code>"FULL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.LogLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Level</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogLevel
	 * @see #setLogLevel(LogLevel)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getLogMediator_LogLevel()
	 * @model default="FULL"
	 * @generated
	 */
	LogLevel getLogLevel();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogLevel <em>Log Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Level</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogLevel
	 * @see #getLogLevel()
	 * @generated
	 */
	void setLogLevel(LogLevel value);

	/**
	 * Returns the value of the '<em><b>Log Separator</b></em>' attribute.
	 * The default value is <code>","</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Separator</em>' attribute.
	 * @see #setLogSeparator(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getLogMediator_LogSeparator()
	 * @model default=","
	 * @generated
	 */
	String getLogSeparator();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogSeparator <em>Log Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Separator</em>' attribute.
	 * @see #getLogSeparator()
	 * @generated
	 */
	void setLogSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.LogProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getLogMediator_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<LogProperty> getProperties();

} // LogMediator
