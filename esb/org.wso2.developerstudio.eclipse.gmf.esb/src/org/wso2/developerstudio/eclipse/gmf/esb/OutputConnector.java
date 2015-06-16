/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector#getOutgoingLink <em>Outgoing Link</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector#getCommentMediators <em>Comment Mediators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getOutputConnector()
 * @model abstract="true"
 * @generated
 */
public interface OutputConnector extends EsbConnector {
	/**
	 * Returns the value of the '<em><b>Outgoing Link</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Link</em>' containment reference.
	 * @see #setOutgoingLink(EsbLink)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getOutputConnector_OutgoingLink()
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbLink#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EsbLink getOutgoingLink();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector#getOutgoingLink <em>Outgoing Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Link</em>' containment reference.
	 * @see #getOutgoingLink()
	 * @generated
	 */
	void setOutgoingLink(EsbLink value);

	/**
	 * Returns the value of the '<em><b>Comment Mediators</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.CommentMediator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment Mediators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment Mediators</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getOutputConnector_CommentMediators()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommentMediator> getCommentMediators();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean shouldConnect(InputConnector targetEnd);

} // OutputConnector
