/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#getBasicContainer <em>Basic Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.Operator#isSerialized <em>Serialized</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends DataMapperNode {
	/**
	 * Returns the value of the '<em><b>Basic Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Container</em>' containment reference.
	 * @see #setBasicContainer(OperatorBasicContainer)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_BasicContainer()
	 * @model containment="true"
	 * @generated
	 */
	OperatorBasicContainer getBasicContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#getBasicContainer <em>Basic Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Container</em>' containment reference.
	 * @see #getBasicContainer()
	 * @generated
	 */
	void setBasicContainer(OperatorBasicContainer value);

	/**
	 * Returns the value of the '<em><b>Serialized</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serialized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serialized</em>' attribute.
	 * @see #setSerialized(boolean)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getOperator_Serialized()
	 * @model default="false"
	 * @generated
	 */
	boolean isSerialized();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.Operator#isSerialized <em>Serialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serialized</em>' attribute.
	 * @see #isSerialized()
	 * @generated
	 */
	void setSerialized(boolean value);

} // Operator
