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
 * A representation of the model object '<em><b>Switch Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getSourceXpath <em>Source Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getSource <em>Source</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getNamespacePrefix <em>Namespace Prefix</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getCaseBranches <em>Case Branches</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getDefaultBranch <em>Default Branch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getSwitchContainer <em>Switch Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator()
 * @model
 * @generated
 */
public interface SwitchMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Xpath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Xpath</em>' containment reference.
	 * @see #setSourceXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_SourceXpath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSourceXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getSourceXpath <em>Source Xpath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Xpath</em>' containment reference.
	 * @see #getSourceXpath()
	 * @generated
	 */
	void setSourceXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Namespace Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace Prefix</em>' attribute.
	 * @see #setNamespacePrefix(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_NamespacePrefix()
	 * @model
	 * @generated
	 */
	String getNamespacePrefix();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getNamespacePrefix <em>Namespace Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Prefix</em>' attribute.
	 * @see #getNamespacePrefix()
	 * @generated
	 */
	void setNamespacePrefix(String value);

	/**
	 * Returns the value of the '<em><b>Case Branches</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Branches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Branches</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_CaseBranches()
	 * @model containment="true"
	 * @generated
	 */
	EList<SwitchCaseBranchOutputConnector> getCaseBranches();

	/**
	 * Returns the value of the '<em><b>Default Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Branch</em>' containment reference.
	 * @see #setDefaultBranch(SwitchDefaultBranchOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_DefaultBranch()
	 * @model containment="true"
	 * @generated
	 */
	SwitchDefaultBranchOutputConnector getDefaultBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getDefaultBranch <em>Default Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Branch</em>' containment reference.
	 * @see #getDefaultBranch()
	 * @generated
	 */
	void setDefaultBranch(SwitchDefaultBranchOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(SwitchMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	SwitchMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(SwitchMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(SwitchMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	SwitchMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(SwitchMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Switch Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch Container</em>' containment reference.
	 * @see #setSwitchContainer(SwitchMediatorContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchMediator_SwitchContainer()
	 * @model containment="true"
	 * @generated
	 */
	SwitchMediatorContainer getSwitchContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator#getSwitchContainer <em>Switch Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch Container</em>' containment reference.
	 * @see #getSwitchContainer()
	 * @generated
	 */
	void setSwitchContainer(SwitchMediatorContainer value);

} // SwitchMediator
