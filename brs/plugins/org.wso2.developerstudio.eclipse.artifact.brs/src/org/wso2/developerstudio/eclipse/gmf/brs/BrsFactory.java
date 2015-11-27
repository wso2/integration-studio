/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.brs;

import org.eclipse.emf.ecore.EFactory;
import org.wso2.developerstudio.eclipse.artifact.brs.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.BrsPackage.EsbPackage
 * @generated
 */
public interface BrsFactory extends EFactory {
	
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BrsFactory eINSTANCE = org.wso2.developerstudio.eclipse.gmf.brs.impl.BrsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Registry Key Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registry Key Property</em>'.
	 * @generated
	 */
	RegistryKeyProperty createRegistryKeyProperty();
	

} //EsbFactory
