/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.brs.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.wso2.developerstudio.eclipse.gmf.brs.BrsFactory;
import org.wso2.developerstudio.eclipse.gmf.brs.BrsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class BrsPackageImpl extends EPackageImpl implements BrsPackage {
	
	String eNAME = "brs";
	String eNS_PREFIX = "brs";



	private BrsPackageImpl() {
		super(eNS_URI, BrsFactory.eINSTANCE);
	}

	private static boolean isInited = false;

	private EClass registryKeyPropertyEClass = null;

	private EClass namespacedPropertyEClass = null;
	
	private EDataType mapEDataType = null;


	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link EsbPackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BrsPackage init() {
		if (isInited)
			return (BrsPackage) EPackage.Registry.INSTANCE
					.getEPackage(BrsPackage.eNS_URI);

		// Obtain or create and register package
		BrsPackageImpl theEsbPackage = (BrsPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof BrsPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new BrsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEsbPackage.createPackageContents();

		// Initialize created meta-data
		theEsbPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEsbPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BrsPackage.eNS_URI, theEsbPackage);
		return theEsbPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {

		registryKeyPropertyEClass = createEClass(REGISTRY_KEY_PROPERTY);
		createEAttribute(registryKeyPropertyEClass,
				REGISTRY_KEY_PROPERTY__PRETTY_NAME);
		createEAttribute(registryKeyPropertyEClass,
				REGISTRY_KEY_PROPERTY__KEY_NAME);
		createEAttribute(registryKeyPropertyEClass,
				REGISTRY_KEY_PROPERTY__KEY_VALUE);
		createEAttribute(registryKeyPropertyEClass,
				REGISTRY_KEY_PROPERTY__FILTERS);

		namespacedPropertyEClass = createEClass(NAMESPACED_PROPERTY);
		createEAttribute(namespacedPropertyEClass,
				NAMESPACED_PROPERTY__PRETTY_NAME);
		createEAttribute(namespacedPropertyEClass,
				NAMESPACED_PROPERTY__PROPERTY_NAME);
		createEAttribute(namespacedPropertyEClass,
				NAMESPACED_PROPERTY__PROPERTY_VALUE);
		createEAttribute(namespacedPropertyEClass,
				NAMESPACED_PROPERTY__NAMESPACES);
		createEAttribute(namespacedPropertyEClass,
				NAMESPACED_PROPERTY__SUPPORTS_DYNAMIC_XPATHS);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__DYNAMIC);

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		addETypeParameter(mapEDataType, "K");
		addETypeParameter(mapEDataType, "V");
	}

	@Override
	public EClass getRegistryKeyProperty() {
		return registryKeyPropertyEClass;
	}

}