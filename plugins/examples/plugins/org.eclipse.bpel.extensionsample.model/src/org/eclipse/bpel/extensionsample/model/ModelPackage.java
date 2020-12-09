/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelPackage.java,v 1.1 2008/09/15 15:44:28 smoser Exp $
 */
package org.eclipse.bpel.extensionsample.model;

import org.eclipse.bpel.model.BPELPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.extensionsample.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/bpel/extensionsample";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "extensionsample";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.bpel.extensionsample.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.extensionsample.model.impl.SampleSimpleActivityImpl <em>Sample Simple Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.extensionsample.model.impl.SampleSimpleActivityImpl
	 * @see org.eclipse.bpel.extensionsample.model.impl.ModelPackageImpl#getSampleSimpleActivity()
	 * @generated
	 */
	int SAMPLE_SIMPLE_ACTIVITY = 0;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__ELEMENT = BPELPackage.EXTENSION_ACTIVITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSION_ACTIVITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__DOCUMENTATION = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__NAME = BPELPackage.EXTENSION_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__SUPPRESS_JOIN_FAILURE = BPELPackage.EXTENSION_ACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__TARGETS = BPELPackage.EXTENSION_ACTIVITY__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__SOURCES = BPELPackage.EXTENSION_ACTIVITY__SOURCES;

	/**
	 * The feature id for the '<em><b>Sample Extension Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sample Simple Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_SIMPLE_ACTIVITY_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.extensionsample.model.impl.SampleStructuredActivityImpl <em>Sample Structured Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.extensionsample.model.impl.SampleStructuredActivityImpl
	 * @see org.eclipse.bpel.extensionsample.model.impl.ModelPackageImpl#getSampleStructuredActivity()
	 * @generated
	 */
	int SAMPLE_STRUCTURED_ACTIVITY = 1;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__DOCUMENTATION_ELEMENT = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__ELEMENT = BPELPackage.EXTENSION_ACTIVITY__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__EEXTENSIBILITY_ELEMENTS = BPELPackage.EXTENSION_ACTIVITY__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__DOCUMENTATION = BPELPackage.EXTENSION_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__NAME = BPELPackage.EXTENSION_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__SUPPRESS_JOIN_FAILURE = BPELPackage.EXTENSION_ACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__TARGETS = BPELPackage.EXTENSION_ACTIVITY__TARGETS;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__SOURCES = BPELPackage.EXTENSION_ACTIVITY__SOURCES;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY__ACTIVITY = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sample Structured Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_STRUCTURED_ACTIVITY_FEATURE_COUNT = BPELPackage.EXTENSION_ACTIVITY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.extensionsample.model.SampleSimpleActivity <em>Sample Simple Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample Simple Activity</em>'.
	 * @see org.eclipse.bpel.extensionsample.model.SampleSimpleActivity
	 * @generated
	 */
	EClass getSampleSimpleActivity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.extensionsample.model.SampleSimpleActivity#getSampleExtensionAttribute <em>Sample Extension Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sample Extension Attribute</em>'.
	 * @see org.eclipse.bpel.extensionsample.model.SampleSimpleActivity#getSampleExtensionAttribute()
	 * @see #getSampleSimpleActivity()
	 * @generated
	 */
	EAttribute getSampleSimpleActivity_SampleExtensionAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.extensionsample.model.SampleStructuredActivity <em>Sample Structured Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample Structured Activity</em>'.
	 * @see org.eclipse.bpel.extensionsample.model.SampleStructuredActivity
	 * @generated
	 */
	EClass getSampleStructuredActivity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.extensionsample.model.SampleStructuredActivity#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Activity</em>'.
	 * @see org.eclipse.bpel.extensionsample.model.SampleStructuredActivity#getActivity()
	 * @see #getSampleStructuredActivity()
	 * @generated
	 */
	EReference getSampleStructuredActivity_Activity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.extensionsample.model.impl.SampleSimpleActivityImpl <em>Sample Simple Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.extensionsample.model.impl.SampleSimpleActivityImpl
		 * @see org.eclipse.bpel.extensionsample.model.impl.ModelPackageImpl#getSampleSimpleActivity()
		 * @generated
		 */
		EClass SAMPLE_SIMPLE_ACTIVITY = eINSTANCE.getSampleSimpleActivity();

		/**
		 * The meta object literal for the '<em><b>Sample Extension Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE = eINSTANCE.getSampleSimpleActivity_SampleExtensionAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.extensionsample.model.impl.SampleStructuredActivityImpl <em>Sample Structured Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.extensionsample.model.impl.SampleStructuredActivityImpl
		 * @see org.eclipse.bpel.extensionsample.model.impl.ModelPackageImpl#getSampleStructuredActivity()
		 * @generated
		 */
		EClass SAMPLE_STRUCTURED_ACTIVITY = eINSTANCE.getSampleStructuredActivity();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLE_STRUCTURED_ACTIVITY__ACTIVITY = eINSTANCE.getSampleStructuredActivity_Activity();

	}

} //ModelPackage
