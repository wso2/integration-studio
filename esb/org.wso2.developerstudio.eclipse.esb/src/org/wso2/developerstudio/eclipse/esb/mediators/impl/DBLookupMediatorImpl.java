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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.mediators.DBLookupMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB Lookup Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DBLookupMediatorImpl extends AbstractSqlExecutorMediatorImpl implements DBLookupMediator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DBLookupMediatorImpl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doLoad(Element self) throws Exception {
		// Connection.
		Element connectionElem = getChildElement(self, "connection");
		if (null != connectionElem) {
			loadConnection(connectionElem);
		} else {
			throw new Exception("Expected connection element.");
		}
		
		// Statements.
		loadObjects(self, "statement", SqlStatement.class, new ObjectHandler<SqlStatement>() {
			public void handle(SqlStatement object) {
				object.setResultsEnabled(true);
				getSqlStatements().add(object);
			}			
		});
		super.doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Element doSave(Element parent) throws Exception {
		Element self = createChildElement(parent, "dblookup");
		
		// Connection.
		Element connectionElem = createChildElement(self, "connection");
		saveConnection(connectionElem);
		
		// Statements.
		for (SqlStatement statement : getSqlStatements()) {
			statement.save(self);
		}
		if(description!=null)
			description.save(self);
		
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
		return MediatorsPackage.Literals.DB_LOOKUP_MEDIATOR;
	}

	
    public Map<String, ObjectValidator> validate() {
    	ObjectValidator objectValidator = new ObjectValidator();
 		Map<String, String> validateMap = new HashMap<String, String>();
 		Map<String, ObjectValidator> mediatorValidateMap = new HashMap<String, ObjectValidator>();
 		if (getConnectionType().equals(SqlExecutorConnectionType.DB_CONNECTION)) {
			if (null == getConnectionDbDriver()|| getConnectionDbDriver().trim().isEmpty()) {
				validateMap.put("Database driver", "Database driver is empty");
			}
		} else {			
			if (getConnectionDsType().equals(SqlExecutorDatasourceType.EXTERNAL)) {
				if (null == getConnectionDsInitialContext()|| getConnectionDsInitialContext().trim().isEmpty()) {
		 			validateMap.put("Initial Context", "Initial Context is empty");
				}
			}
			if (null == getConnectionDsName()|| getConnectionDsName().trim().isEmpty()) {
	 			validateMap.put("Initial Context", "Initial Context is empty");
			}
		}
		
		if (!getConnectionDsType().equals(SqlExecutorDatasourceType.CARBON)) {

			if (null == getConnectionURL()|| getConnectionURL().trim().isEmpty()) {
	 			validateMap.put("Connection URL", "Connection URL Context is empty");
			}
			if (null == getConnectionUsername()|| getConnectionUsername().trim().isEmpty()) {
	 			validateMap.put("Connection username", "Connection username is empty");
			}
			if (null == getConnectionPassword()|| getConnectionPassword().trim().isEmpty()) {
	 			validateMap.put("Connection password", "Connection password is empty");
			}
		}		
 	    objectValidator.setMediatorErrorMap(validateMap);
 	    mediatorValidateMap.put("DBLookup Mediator", objectValidator);
 	    return mediatorValidateMap;
    }

} //DBLookupMediatorImpl
