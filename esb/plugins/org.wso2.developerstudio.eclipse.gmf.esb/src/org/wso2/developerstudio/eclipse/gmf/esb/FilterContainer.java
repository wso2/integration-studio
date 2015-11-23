/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterContainer#getPassContainer <em>Pass Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterContainer#getFailContainer <em>Fail Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterContainer()
 * @model
 * @generated
 */
public interface FilterContainer extends EsbNode {
    /**
	 * Returns the value of the '<em><b>Pass Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pass Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Pass Container</em>' containment reference.
	 * @see #setPassContainer(FilterPassContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterContainer_PassContainer()
	 * @model containment="true"
	 * @generated
	 */
    FilterPassContainer getPassContainer();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterContainer#getPassContainer <em>Pass Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pass Container</em>' containment reference.
	 * @see #getPassContainer()
	 * @generated
	 */
    void setPassContainer(FilterPassContainer value);

    /**
	 * Returns the value of the '<em><b>Fail Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fail Container</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Fail Container</em>' containment reference.
	 * @see #setFailContainer(FilterFailContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFilterContainer_FailContainer()
	 * @model containment="true"
	 * @generated
	 */
    FilterFailContainer getFailContainer();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FilterContainer#getFailContainer <em>Fail Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fail Container</em>' containment reference.
	 * @see #getFailContainer()
	 * @generated
	 */
    void setFailContainer(FilterFailContainer value);

} // FilterContainer
