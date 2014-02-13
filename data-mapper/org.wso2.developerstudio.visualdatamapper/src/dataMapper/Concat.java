/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.Concat#getInNode <em>In Node</em>}</li>
 *   <li>{@link dataMapper.Concat#getOutNode <em>Out Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getConcat()
 * @model
 * @generated
 */
public interface Concat extends EObject {
	/**
	 * Returns the value of the '<em><b>In Node</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.InNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Node</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getConcat_InNode()
	 * @model containment="true"
	 * @generated
	 */
	EList<InNode> getInNode();

	/**
	 * Returns the value of the '<em><b>Out Node</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.OutNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Node</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getConcat_OutNode()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutNode> getOutNode();

} // Concat
