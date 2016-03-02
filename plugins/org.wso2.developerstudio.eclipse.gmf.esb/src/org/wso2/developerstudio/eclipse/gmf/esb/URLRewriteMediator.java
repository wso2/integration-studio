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
 * A representation of the model object '<em><b>URL Rewrite Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getUrlRewriteRules <em>Url Rewrite Rules</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getInProperty <em>In Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getOutProperty <em>Out Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteMediator()
 * @model
 * @generated
 */
public interface URLRewriteMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Url Rewrite Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Rewrite Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Rewrite Rules</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteMediator_UrlRewriteRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<URLRewriteRule> getUrlRewriteRules();

	/**
	 * Returns the value of the '<em><b>In Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Property</em>' attribute.
	 * @see #setInProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteMediator_InProperty()
	 * @model
	 * @generated
	 */
	String getInProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getInProperty <em>In Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Property</em>' attribute.
	 * @see #getInProperty()
	 * @generated
	 */
	void setInProperty(String value);

	/**
	 * Returns the value of the '<em><b>Out Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Property</em>' attribute.
	 * @see #setOutProperty(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteMediator_OutProperty()
	 * @model
	 * @generated
	 */
	String getOutProperty();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getOutProperty <em>Out Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Property</em>' attribute.
	 * @see #getOutProperty()
	 * @generated
	 */
	void setOutProperty(String value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(URLRewriteMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	URLRewriteMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(URLRewriteMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(URLRewriteMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getURLRewriteMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	URLRewriteMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(URLRewriteMediatorOutputConnector value);

} // URLRewriteMediator
