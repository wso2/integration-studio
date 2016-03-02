/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getInput <em>Input</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getOutput <em>Output</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperRoot()
 * @model
 * @generated
 */
public interface DataMapperRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(Input)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperRoot_Input()
	 * @model containment="true"
	 * @generated
	 */
	Input getInput();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Input value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(Output)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperRoot_Output()
	 * @model containment="true"
	 * @generated
	 */
	Output getOutput();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.DataMapperRoot#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Output value);

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.Operator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperRoot_Operators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operator> getOperators();

} // DataMapperRoot
