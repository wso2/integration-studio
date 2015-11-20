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
 * A representation of the model object '<em><b>Log Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getLogCategory <em>Log Category</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getLogLevel <em>Log Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getLogSeparator <em>Log Separator</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLogMediator()
 * @model
 * @generated
 */
public interface LogMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Log Category</b></em>' attribute.
	 * The default value is <code>"INFO"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.LogCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Category</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LogCategory
	 * @see #setLogCategory(LogCategory)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLogMediator_LogCategory()
	 * @model default="INFO"
	 * @generated
	 */
	LogCategory getLogCategory();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getLogCategory <em>Log Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Category</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LogCategory
	 * @see #getLogCategory()
	 * @generated
	 */
	void setLogCategory(LogCategory value);

	/**
	 * Returns the value of the '<em><b>Log Level</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.LogLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Level</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LogLevel
	 * @see #setLogLevel(LogLevel)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLogMediator_LogLevel()
	 * @model
	 * @generated
	 */
	LogLevel getLogLevel();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getLogLevel <em>Log Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Level</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.LogLevel
	 * @see #getLogLevel()
	 * @generated
	 */
	void setLogLevel(LogLevel value);

	/**
	 * Returns the value of the '<em><b>Log Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Separator</em>' attribute.
	 * @see #setLogSeparator(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLogMediator_LogSeparator()
	 * @model
	 * @generated
	 */
	String getLogSeparator();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getLogSeparator <em>Log Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Separator</em>' attribute.
	 * @see #getLogSeparator()
	 * @generated
	 */
	void setLogSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(LogMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLogMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	LogMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(LogMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(LogMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLogMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	LogMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(LogMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.LogProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getLogMediator_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<LogProperty> getProperties();

} // LogMediator
