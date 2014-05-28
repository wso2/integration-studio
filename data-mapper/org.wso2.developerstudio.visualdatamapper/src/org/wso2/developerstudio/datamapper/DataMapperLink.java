/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.DataMapperLink#getInNode <em>In Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.DataMapperLink#getOutNode <em>Out Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperLink()
 * @model
 * @generated
 */
public interface DataMapperLink extends EObject {
	/**
	 * Returns the value of the '<em><b>In Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.InNode#getIncomingLink <em>Incoming Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Node</em>' reference.
	 * @see #setInNode(InNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperLink_InNode()
	 * @see org.wso2.developerstudio.datamapper.InNode#getIncomingLink
	 * @model opposite="incomingLink"
	 * @generated
	 */
	InNode getInNode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.DataMapperLink#getInNode <em>In Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Node</em>' reference.
	 * @see #getInNode()
	 * @generated
	 */
	void setInNode(InNode value);

	/**
	 * Returns the value of the '<em><b>Out Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.datamapper.OutNode#getOutgoingLink <em>Outgoing Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Node</em>' container reference.
	 * @see #setOutNode(OutNode)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getDataMapperLink_OutNode()
	 * @see org.wso2.developerstudio.datamapper.OutNode#getOutgoingLink
	 * @model opposite="outgoingLink" transient="false"
	 * @generated
	 */
	OutNode getOutNode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.DataMapperLink#getOutNode <em>Out Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Node</em>' container reference.
	 * @see #getOutNode()
	 * @generated
	 */
	void setOutNode(OutNode value);

} // DataMapperLink
