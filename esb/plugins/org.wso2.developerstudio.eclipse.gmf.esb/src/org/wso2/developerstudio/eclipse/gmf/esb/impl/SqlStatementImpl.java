/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDefinition;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlResultMapping;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sql Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SqlStatementImpl#getQueryString <em>Query String</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SqlStatementImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SqlStatementImpl#isResultsEnabled <em>Results Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SqlStatementImpl#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SqlStatementImpl extends EObjectImpl implements SqlStatement {
	/**
	 * The default value of the '{@link #getQueryString() <em>Query String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryString()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_STRING_EDEFAULT = "sql_query";

	/**
	 * The cached value of the '{@link #getQueryString() <em>Query String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryString()
	 * @generated
	 * @ordered
	 */
	protected String queryString = QUERY_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<SqlParameterDefinition> parameters;

	/**
	 * The default value of the '{@link #isResultsEnabled() <em>Results Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResultsEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESULTS_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResultsEnabled() <em>Results Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResultsEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean resultsEnabled = RESULTS_ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<SqlResultMapping> results;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SqlStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SQL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryString(String newQueryString) {
		String oldQueryString = queryString;
		queryString = newQueryString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SQL_STATEMENT__QUERY_STRING, oldQueryString, queryString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SqlParameterDefinition> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<SqlParameterDefinition>(SqlParameterDefinition.class, this, EsbPackage.SQL_STATEMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResultsEnabled() {
		return resultsEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultsEnabled(boolean newResultsEnabled) {
		boolean oldResultsEnabled = resultsEnabled;
		resultsEnabled = newResultsEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SQL_STATEMENT__RESULTS_ENABLED, oldResultsEnabled, resultsEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SqlResultMapping> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<SqlResultMapping>(SqlResultMapping.class, this, EsbPackage.SQL_STATEMENT__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SQL_STATEMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case EsbPackage.SQL_STATEMENT__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.SQL_STATEMENT__QUERY_STRING:
				return getQueryString();
			case EsbPackage.SQL_STATEMENT__PARAMETERS:
				return getParameters();
			case EsbPackage.SQL_STATEMENT__RESULTS_ENABLED:
				return isResultsEnabled();
			case EsbPackage.SQL_STATEMENT__RESULTS:
				return getResults();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.SQL_STATEMENT__QUERY_STRING:
				setQueryString((String)newValue);
				return;
			case EsbPackage.SQL_STATEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends SqlParameterDefinition>)newValue);
				return;
			case EsbPackage.SQL_STATEMENT__RESULTS_ENABLED:
				setResultsEnabled((Boolean)newValue);
				return;
			case EsbPackage.SQL_STATEMENT__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends SqlResultMapping>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.SQL_STATEMENT__QUERY_STRING:
				setQueryString(QUERY_STRING_EDEFAULT);
				return;
			case EsbPackage.SQL_STATEMENT__PARAMETERS:
				getParameters().clear();
				return;
			case EsbPackage.SQL_STATEMENT__RESULTS_ENABLED:
				setResultsEnabled(RESULTS_ENABLED_EDEFAULT);
				return;
			case EsbPackage.SQL_STATEMENT__RESULTS:
				getResults().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.SQL_STATEMENT__QUERY_STRING:
				return QUERY_STRING_EDEFAULT == null ? queryString != null : !QUERY_STRING_EDEFAULT.equals(queryString);
			case EsbPackage.SQL_STATEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case EsbPackage.SQL_STATEMENT__RESULTS_ENABLED:
				return resultsEnabled != RESULTS_ENABLED_EDEFAULT;
			case EsbPackage.SQL_STATEMENT__RESULTS:
				return results != null && !results.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (queryString: ");
		result.append(queryString);
		result.append(", resultsEnabled: ");
		result.append(resultsEnabled);
		result.append(')');
		return result.toString();
	}

} //SqlStatementImpl
