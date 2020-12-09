/**
 */
package org.wso2.developerstudio.datamapper;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Key Value Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getKey <em>Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getPropertyKeyValuePair()
 * @model
 * @generated
 */
public interface PropertyKeyValuePair extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getPropertyKeyValuePair_Key()
	 * @model required="true"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getPropertyKeyValuePair_Value()
	 * @model default="" required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.datamapper.PropertyKeyValuePair#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // PropertyKeyValuePair
