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
 * A representation of the model object '<em><b>Rule Facts Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFactsConfiguration#getFacts <em>Facts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFactsConfiguration()
 * @model
 * @generated
 */
public interface RuleFactsConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Facts</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.RuleFact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facts</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRuleFactsConfiguration_Facts()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuleFact> getFacts();

} // RuleFactsConfiguration
