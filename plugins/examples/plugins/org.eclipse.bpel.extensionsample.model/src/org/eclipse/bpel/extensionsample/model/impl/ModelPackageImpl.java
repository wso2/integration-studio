/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelPackageImpl.java,v 1.1 2008/09/15 15:44:28 smoser Exp $
 */
package org.eclipse.bpel.extensionsample.model.impl;

import javax.xml.namespace.QName;

import org.eclipse.bpel.extensionsample.model.ModelFactory;
import org.eclipse.bpel.extensionsample.model.ModelPackage;
import org.eclipse.bpel.extensionsample.model.SampleSimpleActivity;
import org.eclipse.bpel.extensionsample.model.SampleStructuredActivity;
import org.eclipse.bpel.extensionsample.model.util.ExtensionSampleActivityDeserializer;
import org.eclipse.bpel.extensionsample.model.util.ExtensionSampleActivitySerializer;
import org.eclipse.bpel.extensionsample.model.util.ExtensionsampleConstants;

import org.eclipse.bpel.model.BPELPackage;

import org.eclipse.bpel.model.extensions.BPELExtensionRegistry;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;

import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sampleSimpleActivityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sampleStructuredActivityEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.bpel.extensionsample.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @customized
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BPELPackage.eINSTANCE.eClass();
		PartnerlinktypePackage.eINSTANCE.eClass();
		MessagepropertiesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		registerSerializerAndDeserializer();
		
		return theModelPackage;
	}

	private static void registerSerializerAndDeserializer() {
		// Initialize BPEL extension registry
		BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry.getInstance();

		// Initialize our own serializers and deserializers
		ExtensionSampleActivityDeserializer deserializer = new ExtensionSampleActivityDeserializer();
		ExtensionSampleActivitySerializer serializer = new ExtensionSampleActivitySerializer();

		// SampleSimpleActivity
		String name = SampleSimpleActivity.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				ExtensionsampleConstants.ND_SAMPLE_SIMPLE_ACTIVITY), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);

		// SampleStructuredActivity
		name = SampleStructuredActivity.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				ExtensionsampleConstants.ND_SAMPLE_STRUCTURED_ACTIVITY), deserializer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				serializer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSampleSimpleActivity() {
		return sampleSimpleActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSampleSimpleActivity_SampleExtensionAttribute() {
		return (EAttribute)sampleSimpleActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSampleStructuredActivity() {
		return sampleStructuredActivityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSampleStructuredActivity_Activity() {
		return (EReference)sampleStructuredActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sampleSimpleActivityEClass = createEClass(SAMPLE_SIMPLE_ACTIVITY);
		createEAttribute(sampleSimpleActivityEClass, SAMPLE_SIMPLE_ACTIVITY__SAMPLE_EXTENSION_ATTRIBUTE);

		sampleStructuredActivityEClass = createEClass(SAMPLE_STRUCTURED_ACTIVITY);
		createEReference(sampleStructuredActivityEClass, SAMPLE_STRUCTURED_ACTIVITY__ACTIVITY);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BPELPackage theBPELPackage = (BPELPackage)EPackage.Registry.INSTANCE.getEPackage(BPELPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sampleSimpleActivityEClass.getESuperTypes().add(theBPELPackage.getExtensionActivity());
		sampleStructuredActivityEClass.getESuperTypes().add(theBPELPackage.getExtensionActivity());

		// Initialize classes and features; add operations and parameters
		initEClass(sampleSimpleActivityEClass, SampleSimpleActivity.class, "SampleSimpleActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSampleSimpleActivity_SampleExtensionAttribute(), theEcorePackage.getEString(), "SampleExtensionAttribute", null, 0, 1, SampleSimpleActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sampleStructuredActivityEClass, SampleStructuredActivity.class, "SampleStructuredActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSampleStructuredActivity_Activity(), theBPELPackage.getActivity(), null, "activity", null, 1, 1, SampleStructuredActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // ModelPackageImpl
