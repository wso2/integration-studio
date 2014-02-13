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
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sql Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl#getQueryString <em>Query String</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl#isResultsEnabled <em>Results Enabled</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl#getResults <em>Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SqlStatementImpl extends ModelObjectImpl implements SqlStatement {
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
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Query string.
		Element sqlElem = getChildElement(self, "sql");
		if (null != sqlElem) {
			setQueryString(sqlElem.getTextContent());
		} else {
			throw new Exception("Expected sql element.");
		}
		
		// Parameters.
		loadObjects(self, "parameter", SqlParameterDefinition.class, new ObjectHandler<SqlParameterDefinition>() {
			public void handle(SqlParameterDefinition object) {
				getParameters().add(object);
			}			
		});
		
		// Results.
		loadObjects(self, "result", SqlResultMapping.class, new ObjectHandler<SqlResultMapping>() {
			public void handle(SqlResultMapping object) {
				getResults().add(object);				
			}			
		});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "statement");
		
		// Query string.
		Element sqlElem = createChildElement(self, "sql");
		sqlElem.setTextContent(getQueryString());
		
		// Parameters.
		for (SqlParameterDefinition parameter : getParameters()) {
			parameter.save(self);
		}
		
		// Results.
		for (SqlResultMapping result : getResults()) {
			result.save(self);
		}
		
		addComments(self);
		return self;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return MediatorsPackage.Literals.SQL_STATEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SQL_STATEMENT__QUERY_STRING, oldQueryString, queryString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SqlParameterDefinition> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<SqlParameterDefinition>(SqlParameterDefinition.class, this, MediatorsPackage.SQL_STATEMENT__PARAMETERS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, MediatorsPackage.SQL_STATEMENT__RESULTS_ENABLED, oldResultsEnabled, resultsEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SqlResultMapping> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<SqlResultMapping>(SqlResultMapping.class, this, MediatorsPackage.SQL_STATEMENT__RESULTS);
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
			case MediatorsPackage.SQL_STATEMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case MediatorsPackage.SQL_STATEMENT__RESULTS:
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
			case MediatorsPackage.SQL_STATEMENT__QUERY_STRING:
				return getQueryString();
			case MediatorsPackage.SQL_STATEMENT__PARAMETERS:
				return getParameters();
			case MediatorsPackage.SQL_STATEMENT__RESULTS_ENABLED:
				return isResultsEnabled();
			case MediatorsPackage.SQL_STATEMENT__RESULTS:
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
			case MediatorsPackage.SQL_STATEMENT__QUERY_STRING:
				setQueryString((String)newValue);
				return;
			case MediatorsPackage.SQL_STATEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends SqlParameterDefinition>)newValue);
				return;
			case MediatorsPackage.SQL_STATEMENT__RESULTS_ENABLED:
				setResultsEnabled((Boolean)newValue);
				return;
			case MediatorsPackage.SQL_STATEMENT__RESULTS:
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
			case MediatorsPackage.SQL_STATEMENT__QUERY_STRING:
				setQueryString(QUERY_STRING_EDEFAULT);
				return;
			case MediatorsPackage.SQL_STATEMENT__PARAMETERS:
				getParameters().clear();
				return;
			case MediatorsPackage.SQL_STATEMENT__RESULTS_ENABLED:
				setResultsEnabled(RESULTS_ENABLED_EDEFAULT);
				return;
			case MediatorsPackage.SQL_STATEMENT__RESULTS:
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
			case MediatorsPackage.SQL_STATEMENT__QUERY_STRING:
				return QUERY_STRING_EDEFAULT == null ? queryString != null : !QUERY_STRING_EDEFAULT.equals(queryString);
			case MediatorsPackage.SQL_STATEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case MediatorsPackage.SQL_STATEMENT__RESULTS_ENABLED:
				return resultsEnabled != RESULTS_ENABLED_EDEFAULT;
			case MediatorsPackage.SQL_STATEMENT__RESULTS:
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

	
    public Map<String, ObjectValidator> validate() {
	    // TODO Auto-generated method stub
	    return null;
    }

} //SqlStatementImpl
