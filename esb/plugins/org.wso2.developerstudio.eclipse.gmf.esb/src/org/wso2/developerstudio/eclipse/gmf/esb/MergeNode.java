/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Merge Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MergeNode#getFirstInputConnector <em>First Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MergeNode#getSecondInputConnector <em>Second Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MergeNode#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMergeNode()
 * @model
 * @generated
 */
public interface MergeNode extends Mediator {
	/**
	 * Returns the value of the '<em><b>First Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Input Connector</em>' containment reference.
	 * @see #setFirstInputConnector(MergeNodeFirstInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMergeNode_FirstInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	MergeNodeFirstInputConnector getFirstInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MergeNode#getFirstInputConnector <em>First Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Input Connector</em>' containment reference.
	 * @see #getFirstInputConnector()
	 * @generated
	 */
	void setFirstInputConnector(MergeNodeFirstInputConnector value);

	/**
	 * Returns the value of the '<em><b>Second Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Input Connector</em>' containment reference.
	 * @see #setSecondInputConnector(MergeNodeSecondInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMergeNode_SecondInputConnector()
	 * @model containment="true"
	 * @generated
	 */
	MergeNodeSecondInputConnector getSecondInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MergeNode#getSecondInputConnector <em>Second Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Input Connector</em>' containment reference.
	 * @see #getSecondInputConnector()
	 * @generated
	 */
	void setSecondInputConnector(MergeNodeSecondInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(MergeNodeOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMergeNode_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	MergeNodeOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MergeNode#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(MergeNodeOutputConnector value);

} // MergeNode
