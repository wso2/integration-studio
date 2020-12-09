/**
 * <copyright>
 * </copyright>
 *
 * $Id: OpaqueActivityImpl.java,v 1.8 2009/04/14 10:50:36 smoser Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.OpaqueActivity;

import org.eclipse.bpel.model.impl.ExtensionActivityImpl;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OpaqueActivityImpl extends ActivityImpl implements OpaqueActivity {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.OPAQUE_ACTIVITY;
	}
} //OpaqueActivityImpl
