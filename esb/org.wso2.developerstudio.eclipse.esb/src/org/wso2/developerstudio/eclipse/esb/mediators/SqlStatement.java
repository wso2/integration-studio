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
import org.wso2.developerstudio.eclipse.esb.ModelObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sql Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getQueryString <em>Query String</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#isResultsEnabled <em>Results Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSqlStatement()
 * @model
 * @generated
 */
public interface SqlStatement extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Query String</b></em>' attribute.
	 * The default value is <code>"sql_query"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query String</em>' attribute.
	 * @see #setQueryString(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSqlStatement_QueryString()
	 * @model default="sql_query"
	 * @generated
	 */
	String getQueryString();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getQueryString <em>Query String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query String</em>' attribute.
	 * @see #getQueryString()
	 * @generated
	 */
	void setQueryString(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSqlStatement_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<SqlParameterDefinition> getParameters();

	/**
	 * Returns the value of the '<em><b>Results Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results Enabled</em>' attribute.
	 * @see #setResultsEnabled(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSqlStatement_ResultsEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isResultsEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#isResultsEnabled <em>Results Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Results Enabled</em>' attribute.
	 * @see #isResultsEnabled()
	 * @generated
	 */
	void setResultsEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSqlStatement_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<SqlResultMapping> getResults();

} // SqlStatement
