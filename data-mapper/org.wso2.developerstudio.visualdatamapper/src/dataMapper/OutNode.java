/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.OutNode#getOutgoingLink <em>Outgoing Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getOutNode()
 * @model
 * @generated
 */
public interface OutNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Link</b></em>' containment reference list.
	 * The list contents are of type {@link dataMapper.DataMapperLink}.
	 * It is bidirectional and its opposite is '{@link dataMapper.DataMapperLink#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Link</em>' containment reference list.
	 * @see dataMapper.DataMapperPackage#getOutNode_OutgoingLink()
	 * @see dataMapper.DataMapperLink#getOutNode
	 * @model opposite="outNode" containment="true"
	 * @generated
	 */
	EList<DataMapperLink> getOutgoingLink();

} // OutNode
