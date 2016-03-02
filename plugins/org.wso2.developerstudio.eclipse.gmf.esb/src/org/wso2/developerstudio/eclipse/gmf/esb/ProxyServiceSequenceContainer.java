/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Service Sequence Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceContainer#getInSequence <em>In Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceContainer#getOutSequence <em>Out Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceSequenceContainer()
 * @model
 * @generated
 */
public interface ProxyServiceSequenceContainer extends EsbNode {
	/**
	 * Returns the value of the '<em><b>In Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Sequence</em>' containment reference.
	 * @see #setInSequence(ProxyServiceInSequence)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceSequenceContainer_InSequence()
	 * @model containment="true"
	 * @generated
	 */
	ProxyServiceInSequence getInSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceContainer#getInSequence <em>In Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Sequence</em>' containment reference.
	 * @see #getInSequence()
	 * @generated
	 */
	void setInSequence(ProxyServiceInSequence value);

	/**
	 * Returns the value of the '<em><b>Out Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Sequence</em>' containment reference.
	 * @see #setOutSequence(ProxyServiceOutSequence)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceSequenceContainer_OutSequence()
	 * @model containment="true"
	 * @generated
	 */
	ProxyServiceOutSequence getOutSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceContainer#getOutSequence <em>Out Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Sequence</em>' containment reference.
	 * @see #getOutSequence()
	 * @generated
	 */
	void setOutSequence(ProxyServiceOutSequence value);

} // ProxyServiceSequenceContainer
