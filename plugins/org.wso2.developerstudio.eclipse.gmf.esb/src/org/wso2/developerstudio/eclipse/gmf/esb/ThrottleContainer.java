/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throttle Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleContainer#getOnAcceptContainer <em>On Accept Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleContainer#getOnRejectContainer <em>On Reject Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleContainer()
 * @model
 * @generated
 */
public interface ThrottleContainer extends EsbNode {
    /**
	 * Returns the value of the '<em><b>On Accept Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Accept Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>On Accept Container</em>' containment reference.
	 * @see #setOnAcceptContainer(ThrottleOnAcceptContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleContainer_OnAcceptContainer()
	 * @model containment="true"
	 * @generated
	 */
    ThrottleOnAcceptContainer getOnAcceptContainer();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleContainer#getOnAcceptContainer <em>On Accept Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Accept Container</em>' containment reference.
	 * @see #getOnAcceptContainer()
	 * @generated
	 */
    void setOnAcceptContainer(ThrottleOnAcceptContainer value);

    /**
	 * Returns the value of the '<em><b>On Reject Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Reject Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>On Reject Container</em>' containment reference.
	 * @see #setOnRejectContainer(ThrottleOnRejectContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getThrottleContainer_OnRejectContainer()
	 * @model containment="true"
	 * @generated
	 */
    ThrottleOnRejectContainer getOnRejectContainer();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ThrottleContainer#getOnRejectContainer <em>On Reject Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Reject Container</em>' containment reference.
	 * @see #getOnRejectContainer()
	 * @generated
	 */
    void setOnRejectContainer(ThrottleOnRejectContainer value);

} // ThrottleContainer
