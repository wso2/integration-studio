/**
 */
package dataMapper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataMapper.InNode#getIncomingLink <em>Incoming Link</em>}</li>
 *   <li>{@link dataMapper.InNode#getElementParent <em>Element Parent</em>}</li>
 *   <li>{@link dataMapper.InNode#getAttributeParent <em>Attribute Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataMapper.DataMapperPackage#getInNode()
 * @model
 * @generated
 */
public interface InNode extends EObject {

	/**
	 * Returns the value of the '<em><b>Incoming Link</b></em>' reference list.
	 * The list contents are of type {@link dataMapper.DataMapperLink}.
	 * It is bidirectional and its opposite is '{@link dataMapper.DataMapperLink#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Link</em>' reference list.
	 * @see dataMapper.DataMapperPackage#getInNode_IncomingLink()
	 * @see dataMapper.DataMapperLink#getInNode
	 * @model opposite="inNode"
	 * @generated
	 */
	EList<DataMapperLink> getIncomingLink();

	/**
	 * Returns the value of the '<em><b>Element Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link dataMapper.Element#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Parent</em>' container reference.
	 * @see #setElementParent(Element)
	 * @see dataMapper.DataMapperPackage#getInNode_ElementParent()
	 * @see dataMapper.Element#getInNode
	 * @model opposite="inNode" transient="false"
	 * @generated
	 */
	Element getElementParent();

	/**
	 * Sets the value of the '{@link dataMapper.InNode#getElementParent <em>Element Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Parent</em>' container reference.
	 * @see #getElementParent()
	 * @generated
	 */
	void setElementParent(Element value);

	/**
	 * Returns the value of the '<em><b>Attribute Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link dataMapper.Attribute#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Parent</em>' container reference.
	 * @see #setAttributeParent(Attribute)
	 * @see dataMapper.DataMapperPackage#getInNode_AttributeParent()
	 * @see dataMapper.Attribute#getInNode
	 * @model opposite="inNode" transient="false"
	 * @generated
	 */
	Attribute getAttributeParent();

	/**
	 * Sets the value of the '{@link dataMapper.InNode#getAttributeParent <em>Attribute Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Parent</em>' container reference.
	 * @see #getAttributeParent()
	 * @generated
	 */
	void setAttributeParent(Attribute value);
} // InNode
