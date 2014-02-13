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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB Report Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator#isConnectionUseTransaction <em>Connection Use Transaction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getDBReportMediator()
 * @model
 * @generated
 */
public interface DBReportMediator extends AbstractSqlExecutorMediator {

	/**
	 * Returns the value of the '<em><b>Connection Use Transaction</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Use Transaction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Use Transaction</em>' attribute.
	 * @see #setConnectionUseTransaction(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getDBReportMediator_ConnectionUseTransaction()
	 * @model default="false"
	 * @generated
	 */
	boolean isConnectionUseTransaction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator#isConnectionUseTransaction <em>Connection Use Transaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Use Transaction</em>' attribute.
	 * @see #isConnectionUseTransaction()
	 * @generated
	 */
	void setConnectionUseTransaction(boolean value);
} // DBReportMediator
