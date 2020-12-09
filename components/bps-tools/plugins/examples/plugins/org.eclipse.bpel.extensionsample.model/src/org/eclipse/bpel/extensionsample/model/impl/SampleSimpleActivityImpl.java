/**
 * <copyright>
 * </copyright>
 *
 * $Id: SampleSimpleActivityImpl.java,v 1.1 2008/09/15 15:44:28 smoser Exp $
 */
package org.eclipse.bpel.extensionsample.model.impl;

import org.eclipse.bpel.extensionsample.model.ModelPackage;
import org.eclipse.bpel.extensionsample.model.SampleSimpleActivity;

import org.eclipse.bpel.model.impl.ExtensionActivityImpl;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sample Simple Activity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.bpel.extensionsample.model.impl.SampleSimpleActivityImpl#getSampleExtensionAttribute
 * <em>Sample Extension Attribute</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SampleSimpleActivityImpl extends ExtensionActivityImpl implements SampleSimpleActivity {
	/**
	 * The default value of the '{@link #getSampleExtensionAttribute()
	 * <em>Sample Extension Attribute</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getSampleExtensionAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String SAMPLE_EXTENSION_ATTRIBUTE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSampleExtensionAttribute()
	 * <em>Sample Extension Attribute</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getSampleExtensionAttribute()
	 * @generated
	 * @ordered
	 */
	protected String sampleExtensionAttribute = SAMPLE_EXTENSION_ATTRIBUTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SampleSimpleActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SAMPLE_SIMPLE_ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSampleExtensionAttribute() {
		return sampleExtensionAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @customized
	 */
	public void setSampleExtensionAttribute(String newSampleExtensionAttribute) {
		String oldSampleExtensionAttribute = sampleExtensionAttribute;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, ModelPackage.eINSTANCE
					.getSampleSimpleActivity_SampleExtensionAttribute().getName(),
					newSampleExtensionAttribute);
		}
		sampleExtensionAttribute = newSampleExtensionAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE,
					oldSampleExtensionAttribute, sampleExtensionAttribute));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE:
			return getSampleExtensionAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE:
			setSampleExtensionAttribute((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelPackage.SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE:
			setSampleExtensionAttribute(SAMPLE_EXTENSION_ATTRIBUTE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelPackage.SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE:
			return SAMPLE_EXTENSION_ATTRIBUTE_EDEFAULT == null ? sampleExtensionAttribute != null
					: !SAMPLE_EXTENSION_ATTRIBUTE_EDEFAULT.equals(sampleExtensionAttribute);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (SampleExtensionAttribute: ");
		result.append(sampleExtensionAttribute);
		result.append(')');
		return result.toString();
	}

} // SampleSimpleActivityImpl
