/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelFactory.java,v 1.1 2008/09/15 15:44:28 smoser Exp $
 */
package org.eclipse.bpel.extensionsample.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.extensionsample.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = org.eclipse.bpel.extensionsample.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sample Simple Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample Simple Activity</em>'.
	 * @generated
	 */
	SampleSimpleActivity createSampleSimpleActivity();

	/**
	 * Returns a new object of class '<em>Sample Structured Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample Structured Activity</em>'.
	 * @generated
	 */
	SampleStructuredActivity createSampleStructuredActivity();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
