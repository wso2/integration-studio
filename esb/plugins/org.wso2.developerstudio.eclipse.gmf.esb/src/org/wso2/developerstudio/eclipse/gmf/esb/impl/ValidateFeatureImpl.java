/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.ecore.EClass;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validate Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ValidateFeatureImpl extends AbstractBooleanFeatureImpl implements ValidateFeature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ValidateFeatureImpl() {
		super();
		
		setFeatureName("feature_name");
		setFeatureEnabled(true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.VALIDATE_FEATURE;
	}

} //ValidateFeatureImpl
