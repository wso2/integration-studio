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
 * A representation of the model object '<em><b>XQuery Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getTargetXPath <em>Target XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getScriptKeyType <em>Script Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getStaticScriptKey <em>Static Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getDynamicScriptKey <em>Dynamic Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getQueryKey <em>Query Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator()
 * @model
 * @generated
 */
public interface XQueryMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<XQueryVariable> getVariables();

	/**
	 * Returns the value of the '<em><b>Target XPath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target XPath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target XPath</em>' containment reference.
	 * @see #setTargetXPath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_TargetXPath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getTargetXPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getTargetXPath <em>Target XPath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target XPath</em>' containment reference.
	 * @see #getTargetXPath()
	 * @generated
	 */
	void setTargetXPath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Script Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #setScriptKeyType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_ScriptKeyType()
	 * @model
	 * @generated
	 */
	KeyType getScriptKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getScriptKeyType <em>Script Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #getScriptKeyType()
	 * @generated
	 */
	void setScriptKeyType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Static Script Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Script Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Script Key</em>' containment reference.
	 * @see #setStaticScriptKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_StaticScriptKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getStaticScriptKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getStaticScriptKey <em>Static Script Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Script Key</em>' containment reference.
	 * @see #getStaticScriptKey()
	 * @generated
	 */
	void setStaticScriptKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Dynamic Script Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Script Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Script Key</em>' containment reference.
	 * @see #setDynamicScriptKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_DynamicScriptKey()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getDynamicScriptKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getDynamicScriptKey <em>Dynamic Script Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Script Key</em>' containment reference.
	 * @see #getDynamicScriptKey()
	 * @generated
	 */
	void setDynamicScriptKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Query Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Key</em>' containment reference.
	 * @see #setQueryKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_QueryKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getQueryKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getQueryKey <em>Query Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Key</em>' containment reference.
	 * @see #getQueryKey()
	 * @generated
	 */
	void setQueryKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(XQueryMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	XQueryMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(XQueryMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(XQueryMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getXQueryMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	XQueryMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(XQueryMediatorOutputConnector value);

} // XQueryMediator
