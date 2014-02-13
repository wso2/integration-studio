/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRenderings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings#getRendering <em>Rendering</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTRenderings()
 * @model extendedMetaData="name='tRenderings' kind='elementOnly'"
 * @generated
 */
public interface TRenderings extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Rendering</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rendering</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rendering</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#getTRenderings_Rendering()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='rendering' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TRendering> getRendering();

} // TRenderings
