/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.DataMapperDiagram#getInput <em>Input</em>}</li>
 *   <li>{@link dataMapper.DataMapperDiagram#getOutput <em>Output</em>}</li>
 *   <li>{@link dataMapper.DataMapperDiagram#getConcat <em>Concat</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getDataMapperDiagram()
 * @model
 * @generated
 */
public interface DataMapperDiagram extends DataMapperNode {
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
	 * @see dataMapper.DataMapperPackage#getDataMapperDiagram_Input()
	 * @model containment="true"
	 * @generated
	 */
	Input getInput();

	/**
	 * Sets the value of the '{@link dataMapper.DataMapperDiagram#getInput <em>Input</em>}' containment reference.
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
	 * @see dataMapper.DataMapperPackage#getDataMapperDiagram_Output()
	 * @model containment="true"
	 * @generated
	 */
	Output getOutput();

	/**
	 * Sets the value of the '{@link dataMapper.DataMapperDiagram#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Output value);

	/**
	 * Returns the value of the '<em><b>Concat</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.Concat}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concat</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concat</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getDataMapperDiagram_Concat()
	 * @model containment="true"
	 * @generated
	 */
	EList<Concat> getConcat();

} // DataMapperDiagram
