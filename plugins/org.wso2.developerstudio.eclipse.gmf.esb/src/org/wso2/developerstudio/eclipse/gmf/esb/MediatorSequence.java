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
 * A representation of the model object '<em><b>Mediator Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#isAnonymous <em>Anonymous</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#getSequenceName <em>Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#getMediators <em>Mediators</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#getOnError <em>On Error</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMediatorSequence()
 * @model
 * @generated
 */
public interface MediatorSequence extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Anonymous</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anonymous</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous</em>' attribute.
	 * @see #setAnonymous(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMediatorSequence_Anonymous()
	 * @model default="false"
	 * @generated
	 */
	boolean isAnonymous();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#isAnonymous <em>Anonymous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous</em>' attribute.
	 * @see #isAnonymous()
	 * @generated
	 */
	void setAnonymous(boolean value);

	/**
	 * Returns the value of the '<em><b>Sequence Name</b></em>' attribute.
	 * The default value is <code>"sequence_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Name</em>' attribute.
	 * @see #setSequenceName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMediatorSequence_SequenceName()
	 * @model default="sequence_name"
	 * @generated
	 */
	String getSequenceName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#getSequenceName <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Name</em>' attribute.
	 * @see #getSequenceName()
	 * @generated
	 */
	void setSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Mediators</b></em>' reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.Mediator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediators</em>' reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMediatorSequence_Mediators()
	 * @model
	 * @generated
	 */
	EList<Mediator> getMediators();

	/**
	 * Returns the value of the '<em><b>On Error</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Error</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Error</em>' reference.
	 * @see #setOnError(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMediatorSequence_OnError()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getOnError();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#getOnError <em>On Error</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Error</em>' reference.
	 * @see #getOnError()
	 * @generated
	 */
	void setOnError(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMediatorSequence_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // MediatorSequence
