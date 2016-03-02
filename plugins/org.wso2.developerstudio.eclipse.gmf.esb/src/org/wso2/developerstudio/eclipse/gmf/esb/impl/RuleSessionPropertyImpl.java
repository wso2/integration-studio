/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.ecore.EClass;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSessionProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Session Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RuleSessionPropertyImpl extends AbstractNameValuePropertyImpl implements RuleSessionProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RuleSessionPropertyImpl() {
		super();
		setPropertyName("property_name");
		setPropertyValue("property_value");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.RULE_SESSION_PROPERTY;
	}

} //RuleSessionPropertyImpl
