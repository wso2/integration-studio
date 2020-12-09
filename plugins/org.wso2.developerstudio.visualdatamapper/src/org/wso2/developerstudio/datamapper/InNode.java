/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.InNode#getIncomingLink <em>Incoming Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.InNode#getElementParent <em>Element Parent</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getInNode()
 * @model
 * @generated
 */
public interface InNode extends EObject {

	/**
	 * Returns the value of the '<em><b>Incoming Link</b></em>' reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.datamapper.DataMapperLink}.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.DataMapperLink#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Link</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Link</em>' reference list.
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getInNode_IncomingLink()
	 * @see org.wso2.developerstudio.datamapper.DataMapperLink#getInNode
	 * @model opposite="inNode"
	 * @generated
	 */
	EList<DataMapperLink> getIncomingLink();

	/**
	 * Returns the value of the '<em><b>Element Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.Element#getInNode <em>In Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Parent</em>' container reference.
	 * @see #setElementParent(Element)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getInNode_ElementParent()
	 * @see org.wso2.developerstudio.datamapper.Element#getInNode
	 * @model opposite="inNode" transient="false"
	 * @generated
	 */
	Element getElementParent();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.InNode#getElementParent <em>Element Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Parent</em>' container reference.
	 * @see #getElementParent()
	 * @generated
	 */
	void setElementParent(Element value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean shouldConnect(OutNode sourceEnd);
} // InNode
