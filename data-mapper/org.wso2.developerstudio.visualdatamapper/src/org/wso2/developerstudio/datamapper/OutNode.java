/**
 */
package org.wso2.developerstudio.datamapper;

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
 *   <li>{@link org.wso2.developerstudio.datamapper.OutNode#getOutgoingLink <em>Outgoing Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.OutNode#getElementParent <em>Element Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOutNode()
 * @model
 * @generated
 */
public interface OutNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Link</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.DataMapperLink}.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.DataMapperLink#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Link</em>' containment reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOutNode_OutgoingLink()
	 * @see org.wso2.developerstudio.datamapper.DataMapperLink#getOutNode
	 * @model opposite="outNode" containment="true"
	 * @generated
	 */
	EList<DataMapperLink> getOutgoingLink();

	/**
	 * Returns the value of the '<em><b>Element Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.Element#getOutNode <em>Out Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Parent</em>' container reference.
	 * @see #setElementParent(Element)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOutNode_ElementParent()
	 * @see org.wso2.developerstudio.datamapper.Element#getOutNode
	 * @model opposite="outNode" transient="false"
	 * @generated
	 */
	Element getElementParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.OutNode#getElementParent <em>Element Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Parent</em>' container reference.
	 * @see #getElementParent()
	 * @generated
	 */
	void setElementParent(Element value);

} // OutNode
