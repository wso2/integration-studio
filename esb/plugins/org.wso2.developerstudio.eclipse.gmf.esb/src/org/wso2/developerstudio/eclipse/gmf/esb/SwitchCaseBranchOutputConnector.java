/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Case Branch Output Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector#getCaseRegex <em>Case Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchCaseBranchOutputConnector()
 * @model
 * @generated
 */
public interface SwitchCaseBranchOutputConnector extends OutputConnector {
	/**
	 * Returns the value of the '<em><b>Case Regex</b></em>' attribute.
	 * The default value is <code>".*+"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Regex</em>' attribute.
	 * @see #setCaseRegex(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSwitchCaseBranchOutputConnector_CaseRegex()
	 * @model default=".*+"
	 * @generated
	 */
	String getCaseRegex();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector#getCaseRegex <em>Case Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Regex</em>' attribute.
	 * @see #getCaseRegex()
	 * @generated
	 */
	void setCaseRegex(String value);

} // SwitchCaseBranchOutputConnector
