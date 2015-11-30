/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExtensionActivity.java,v 1.4 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.bpel.model.BPELPackage#getExtensionActivity()
 * @model
 * @generated
 */
public interface ExtensionActivity extends Activity {

	/**
	 * <!-- begin-user-doc -->
	 * Bug 120110 - added this method so extensions can update name references to
	 * other model objects (e.g. Variables)
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateElementReferences(EObject object, String attrName,
			String attrValue);

} // ExtensionActivity
