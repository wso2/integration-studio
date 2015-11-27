/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExtensionActivityImpl.java,v 1.9 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExtensionActivityImpl extends ActivityImpl implements
		ExtensionActivity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.EXTENSION_ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Bug 120110 - added this method so extensions can update name references to
	 * other model objects (e.g. Variables)
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateElementReferences(EObject object, String attrName,
			String attrValue) {
	}

} //ExtensionActivityImpl
