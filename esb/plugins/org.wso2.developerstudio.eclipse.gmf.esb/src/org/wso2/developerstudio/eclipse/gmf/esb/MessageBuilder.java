/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Builder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder#getBuilderClass <em>Builder Class</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder#getFormatterClass <em>Formatter Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageBuilder()
 * @model
 * @generated
 */
public interface MessageBuilder extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type</em>' attribute.
	 * @see #setContentType(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageBuilder_ContentType()
	 * @model
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * Returns the value of the '<em><b>Builder Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Builder Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Builder Class</em>' attribute.
	 * @see #setBuilderClass(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageBuilder_BuilderClass()
	 * @model
	 * @generated
	 */
	String getBuilderClass();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder#getBuilderClass <em>Builder Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Builder Class</em>' attribute.
	 * @see #getBuilderClass()
	 * @generated
	 */
	void setBuilderClass(String value);

	/**
	 * Returns the value of the '<em><b>Formatter Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formatter Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formatter Class</em>' attribute.
	 * @see #setFormatterClass(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getMessageBuilder_FormatterClass()
	 * @model
	 * @generated
	 */
	String getFormatterClass();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder#getFormatterClass <em>Formatter Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formatter Class</em>' attribute.
	 * @see #getFormatterClass()
	 * @generated
	 */
	void setFormatterClass(String value);

} // MessageBuilder
