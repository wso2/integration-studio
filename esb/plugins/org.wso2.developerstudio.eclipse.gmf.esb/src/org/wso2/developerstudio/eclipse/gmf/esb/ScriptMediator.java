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
 * A representation of the model object '<em><b>Script Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptType <em>Script Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptLanguage <em>Script Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getMediateFunction <em>Mediate Function</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptDynamicKey <em>Script Dynamic Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptBody <em>Script Body</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getKeyType <em>Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptStaticKey <em>Script Static Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptKeys <em>Script Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator()
 * @model
 * @generated
 */
public interface ScriptMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Script Type</b></em>' attribute.
	 * The default value is <code>"REGISTRY_REFERENCE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ScriptType
	 * @see #setScriptType(ScriptType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_ScriptType()
	 * @model default="REGISTRY_REFERENCE"
	 * @generated
	 */
	ScriptType getScriptType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptType <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ScriptType
	 * @see #getScriptType()
	 * @generated
	 */
	void setScriptType(ScriptType value);

	/**
	 * Returns the value of the '<em><b>Script Language</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptLanguage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Language</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ScriptLanguage
	 * @see #setScriptLanguage(ScriptLanguage)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_ScriptLanguage()
	 * @model
	 * @generated
	 */
	ScriptLanguage getScriptLanguage();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptLanguage <em>Script Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Language</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.ScriptLanguage
	 * @see #getScriptLanguage()
	 * @generated
	 */
	void setScriptLanguage(ScriptLanguage value);

	/**
	 * Returns the value of the '<em><b>Mediate Function</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediate Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediate Function</em>' attribute.
	 * @see #setMediateFunction(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_MediateFunction()
	 * @model default=""
	 * @generated
	 */
	String getMediateFunction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getMediateFunction <em>Mediate Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediate Function</em>' attribute.
	 * @see #getMediateFunction()
	 * @generated
	 */
	void setMediateFunction(String value);

	/**
	 * Returns the value of the '<em><b>Script Dynamic Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Dynamic Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Dynamic Key</em>' containment reference.
	 * @see #setScriptDynamicKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_ScriptDynamicKey()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getScriptDynamicKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptDynamicKey <em>Script Dynamic Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Dynamic Key</em>' containment reference.
	 * @see #getScriptDynamicKey()
	 * @generated
	 */
	void setScriptDynamicKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Script Body</b></em>' attribute.
	 * The default value is <code>"script_code"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Body</em>' attribute.
	 * @see #setScriptBody(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_ScriptBody()
	 * @model default="script_code"
	 * @generated
	 */
	String getScriptBody();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptBody <em>Script Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Body</em>' attribute.
	 * @see #getScriptBody()
	 * @generated
	 */
	void setScriptBody(String value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(ScriptMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ScriptMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(ScriptMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(ScriptMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	ScriptMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(ScriptMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum
	 * @see #setKeyType(scriptKeyTypeEnum)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_KeyType()
	 * @model
	 * @generated
	 */
	scriptKeyTypeEnum getKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getKeyType <em>Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.scriptKeyTypeEnum
	 * @see #getKeyType()
	 * @generated
	 */
	void setKeyType(scriptKeyTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Script Static Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Static Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Static Key</em>' containment reference.
	 * @see #setScriptStaticKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_ScriptStaticKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getScriptStaticKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator#getScriptStaticKey <em>Script Static Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Static Key</em>' containment reference.
	 * @see #getScriptStaticKey()
	 * @generated
	 */
	void setScriptStaticKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Script Keys</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Keys</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Keys</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getScriptMediator_ScriptKeys()
	 * @model containment="true"
	 * @generated
	 */
	EList<RegistryKeyProperty> getScriptKeys();

} // ScriptMediator
