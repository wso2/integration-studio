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
 * A representation of the model object '<em><b>Input Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.InputConnector#getIncomingLinks <em>Incoming Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInputConnector()
 * @model abstract="true"
 * @generated
 */
public interface InputConnector extends EsbConnector {
	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.EsbLink}.
	 * It is bidirectional and its opposite is '{@link org.wso2.developerstudio.eclipse.gmf.esb.EsbLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInputConnector_IncomingLinks()
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbLink#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<EsbLink> getIncomingLinks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean shouldConnect(OutputConnector sourceEnd);

} // InputConnector
