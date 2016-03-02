/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sql Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement#getQueryString <em>Query String</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement#isResultsEnabled <em>Results Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSqlStatement()
 * @model
 * @generated
 */
public interface SqlStatement extends EObject {
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSqlStatement_QueryString()
	 * @model default="sql_query"
	 * @generated
	 */
	String getQueryString();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement#getQueryString <em>Query String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query String</em>' attribute.
	 * @see #getQueryString()
	 * @generated
	 */
	void setQueryString(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSqlStatement_Parameters()
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSqlStatement_ResultsEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isResultsEnabled();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement#isResultsEnabled <em>Results Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Results Enabled</em>' attribute.
	 * @see #isResultsEnabled()
	 * @generated
	 */
	void setResultsEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.SqlResultMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSqlStatement_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<SqlResultMapping> getResults();

} // SqlStatement
