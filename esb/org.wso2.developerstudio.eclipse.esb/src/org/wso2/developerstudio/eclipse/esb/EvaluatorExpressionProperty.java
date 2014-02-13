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
 * A representation of the model object '<em><b>Evaluator Expression Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty#getPrettyName <em>Pretty Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty#getEvaluatorName <em>Evaluator Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty#getEvaluatorValue <em>Evaluator Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getEvaluatorExpressionProperty()
 * @model
 * @generated
 */
public interface EvaluatorExpressionProperty extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Pretty Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pretty Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pretty Name</em>' attribute.
	 * @see #setPrettyName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getEvaluatorExpressionProperty_PrettyName()
	 * @model
	 * @generated
	 */
	String getPrettyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty#getPrettyName <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pretty Name</em>' attribute.
	 * @see #getPrettyName()
	 * @generated
	 */
	void setPrettyName(String value);

	/**
	 * Returns the value of the '<em><b>Evaluator Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluator Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluator Name</em>' attribute.
	 * @see #setEvaluatorName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getEvaluatorExpressionProperty_EvaluatorName()
	 * @model
	 * @generated
	 */
	String getEvaluatorName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty#getEvaluatorName <em>Evaluator Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluator Name</em>' attribute.
	 * @see #getEvaluatorName()
	 * @generated
	 */
	void setEvaluatorName(String value);

	/**
	 * Returns the value of the '<em><b>Evaluator Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluator Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluator Value</em>' attribute.
	 * @see #setEvaluatorValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getEvaluatorExpressionProperty_EvaluatorValue()
	 * @model
	 * @generated
	 */
	String getEvaluatorValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty#getEvaluatorValue <em>Evaluator Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluator Value</em>' attribute.
	 * @see #getEvaluatorValue()
	 * @generated
	 */
	void setEvaluatorValue(String value);

} // EvaluatorExpressionProperty
