/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.brs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.wso2.developerstudio.eclipse.gmf.BrsFactory.EsbFactory
 * @model kind="package"
 * @generated
 */
public interface BrsPackage extends EPackage {
	
	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BrsPackage eINSTANCE = org.wso2.developerstudio.eclipse.gmf.brs.impl.BrsPackageImpl.init();
	
	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/wso2/developerstudio/eclipse/gmf/esb";
	
	int REGISTRY_KEY_PROPERTY = 80;
	
	int NAMESPACED_PROPERTY = 84;
	
	int ESB_NODE_FEATURE_COUNT = 0;
	
	int REGISTRY_KEY_PROPERTY__PRETTY_NAME = 0;

	int REGISTRY_KEY_PROPERTY__KEY_NAME = 1;

	int REGISTRY_KEY_PROPERTY__KEY_VALUE = 2;

	int REGISTRY_KEY_PROPERTY__FILTERS = 3;

	int REGISTRY_KEY_PROPERTY_FEATURE_COUNT = 4;
	
	int NAMESPACED_PROPERTY__PRETTY_NAME = ESB_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACED_PROPERTY__PROPERTY_NAME = ESB_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACED_PROPERTY__PROPERTY_VALUE = ESB_NODE_FEATURE_COUNT + 2;

	int NAMESPACED_PROPERTY__NAMESPACES = ESB_NODE_FEATURE_COUNT + 3;

	int NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS = ESB_NODE_FEATURE_COUNT + 4;

	int NAMESPACED_PROPERTY__DYNAMIC = ESB_NODE_FEATURE_COUNT + 5;

	int NAMESPACED_PROPERTY_FEATURE_COUNT = ESB_NODE_FEATURE_COUNT + 6;
	
	EClass getRegistryKeyProperty();
	
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
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl <em>Registry Key Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.gmf.esb.impl.RegistryKeyPropertyImpl
		 * @see org.wso2.developerstudio.eclipse.gmf.BrsPackageImpl.impl.EsbPackageImpl#getRegistryKeyProperty()
		 * @generated
		 */
		EClass REGISTRY_KEY_PROPERTY = eINSTANCE.getRegistryKeyProperty();
		
		
	}
	
	
}