/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throttle On Reject Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectBranch#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectBranch#getSequenceKey <em>Sequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleOnRejectBranch()
 * @model
 * @generated
 */
public interface ThrottleOnRejectBranch extends EObject {
	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The default value is <code>"ANONYMOUS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType
	 * @see #setSequenceType(ThrottleSequenceType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleOnRejectBranch_SequenceType()
	 * @model default="ANONYMOUS"
	 * @generated
	 */
	ThrottleSequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectBranch#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(ThrottleSequenceType value);

	/**
	 * Returns the value of the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Key</em>' containment reference.
	 * @see #setSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleOnRejectBranch_SequenceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleOnRejectBranch#getSequenceKey <em>Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' containment reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

} // ThrottleOnRejectBranch
