/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Route Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch#getEvaluatorExpression <em>Evaluator Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch#getTargetSequence <em>Target Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouteBranch()
 * @model
 * @generated
 */
public interface ConditionalRouteBranch extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Break After Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break After Route</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break After Route</em>' attribute.
	 * @see #setBreakAfterRoute(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouteBranch_BreakAfterRoute()
	 * @model
	 * @generated
	 */
	boolean isBreakAfterRoute();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch#isBreakAfterRoute <em>Break After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break After Route</em>' attribute.
	 * @see #isBreakAfterRoute()
	 * @generated
	 */
	void setBreakAfterRoute(boolean value);

	/**
	 * Returns the value of the '<em><b>Evaluator Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluator Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluator Expression</em>' containment reference.
	 * @see #setEvaluatorExpression(EvaluatorExpressionProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouteBranch_EvaluatorExpression()
	 * @model containment="true"
	 * @generated
	 */
	EvaluatorExpressionProperty getEvaluatorExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch#getEvaluatorExpression <em>Evaluator Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluator Expression</em>' containment reference.
	 * @see #getEvaluatorExpression()
	 * @generated
	 */
	void setEvaluatorExpression(EvaluatorExpressionProperty value);

	/**
	 * Returns the value of the '<em><b>Target Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Sequence</em>' containment reference.
	 * @see #setTargetSequence(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getConditionalRouteBranch_TargetSequence()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getTargetSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouteBranch#getTargetSequence <em>Target Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Sequence</em>' containment reference.
	 * @see #getTargetSequence()
	 * @generated
	 */
	void setTargetSequence(RegistryKeyProperty value);

} // ConditionalRouteBranch
