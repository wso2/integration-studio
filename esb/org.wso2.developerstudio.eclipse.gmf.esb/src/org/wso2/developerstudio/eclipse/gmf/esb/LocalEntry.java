/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getEntryName <em>Entry Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getLocalEntryType <em>Local Entry Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getValueLiteral <em>Value Literal</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getValueXML <em>Value XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getValueURL <em>Value URL</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLocalEntry()
 * @model
 * @generated
 */
public interface LocalEntry extends EsbElement {

	/**
	 * Returns the value of the '<em><b>Entry Name</b></em>' attribute.
	 * The default value is <code>"entry_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Name</em>' attribute.
	 * @see #setEntryName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLocalEntry_EntryName()
	 * @model default="entry_name"
	 * @generated
	 */
	String getEntryName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getEntryName <em>Entry Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Name</em>' attribute.
	 * @see #getEntryName()
	 * @generated
	 */
	void setEntryName(String value);

	/**
	 * Returns the value of the '<em><b>Local Entry Type</b></em>' attribute.
	 * The default value is <code>"In-lined Text Entry"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntryValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Entry Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Entry Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LocalEntryValueType
	 * @see #setLocalEntryType(LocalEntryValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLocalEntry_LocalEntryType()
	 * @model default="In-lined Text Entry"
	 * @generated
	 */
	LocalEntryValueType getLocalEntryType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getLocalEntryType <em>Local Entry Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Entry Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LocalEntryValueType
	 * @see #getLocalEntryType()
	 * @generated
	 */
	void setLocalEntryType(LocalEntryValueType value);

	/**
	 * Returns the value of the '<em><b>Value Literal</b></em>' attribute.
	 * The default value is <code>"entry_value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Literal</em>' attribute.
	 * @see #setValueLiteral(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLocalEntry_ValueLiteral()
	 * @model default="entry_value"
	 * @generated
	 */
	String getValueLiteral();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getValueLiteral <em>Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Literal</em>' attribute.
	 * @see #getValueLiteral()
	 * @generated
	 */
	void setValueLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Value XML</b></em>' attribute.
	 * The default value is <code>"<value/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value XML</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value XML</em>' attribute.
	 * @see #setValueXML(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLocalEntry_ValueXML()
	 * @model default="<value/>"
	 * @generated
	 */
	String getValueXML();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getValueXML <em>Value XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value XML</em>' attribute.
	 * @see #getValueXML()
	 * @generated
	 */
	void setValueXML(String value);

	/**
	 * Returns the value of the '<em><b>Value URL</b></em>' attribute.
	 * The default value is <code>"file:/path/to/resource.ext"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value URL</em>' attribute.
	 * @see #setValueURL(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLocalEntry_ValueURL()
	 * @model default="file:/path/to/resource.ext"
	 * @generated
	 */
	String getValueURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry#getValueURL <em>Value URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value URL</em>' attribute.
	 * @see #getValueURL()
	 * @generated
	 */
	void setValueURL(String value);
} // LocalEntry
