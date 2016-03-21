/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.bpel.humantask.record;

import org.eclipse.bpel.model.BPELPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.wso2.developerstudio.bpel.humantask.record.RecordFactory
 * @model kind="package"
 * @generated
 */
public interface RecordPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "record";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.wso2.org/developerstudio/bps/humantask";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RecordPackage eINSTANCE = org.wso2.developerstudio.bpel.humantask.record.impl.RecordPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.bpel.humantask.record.impl.ExtensionElementImpl <em>Extension Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.bpel.humantask.record.impl.ExtensionElementImpl
	 * @see org.wso2.developerstudio.bpel.humantask.record.impl.RecordPackageImpl#getExtensionElement()
	 * @generated
	 */
	int EXTENSION_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Documentation Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__DOCUMENTATION_ELEMENT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__DOCUMENTATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__ELEMENT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>EExtensibility Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__EEXTENSIBILITY_ELEMENTS = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__EEXTENSIBILITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__DOCUMENTATION = BPELPackage.BPEL_EXTENSIBLE_ELEMENT__DOCUMENTATION;

	/**
	 * The number of structural features of the '<em>Extension Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT_FEATURE_COUNT = BPELPackage.BPEL_EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.bpel.humantask.record.ExtensionElement <em>Extension Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Element</em>'.
	 * @see org.wso2.developerstudio.bpel.humantask.record.ExtensionElement
	 * @generated
	 */
	EClass getExtensionElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RecordFactory getRecordFactory();

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
		 * The meta object literal for the '{@link org.wso2.developerstudio.bpel.humantask.record.impl.ExtensionElementImpl <em>Extension Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.bpel.humantask.record.impl.ExtensionElementImpl
		 * @see org.wso2.developerstudio.bpel.humantask.record.impl.RecordPackageImpl#getExtensionElement()
		 * @generated
		 */
		EClass EXTENSION_ELEMENT = eINSTANCE.getExtensionElement();

	}

} //RecordPackage
