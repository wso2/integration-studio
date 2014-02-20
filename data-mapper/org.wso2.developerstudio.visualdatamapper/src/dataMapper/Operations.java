/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.Operations#getConcat <em>Concat</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getOperations()
 * @model
 * @generated
 */
public interface Operations extends DataMapperNode {
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
	 * @see dataMapper.DataMapperPackage#getOperations_Concat()
	 * @model containment="true"
	 * @generated
	 */
	EList<Concat> getConcat();

} // Operations
