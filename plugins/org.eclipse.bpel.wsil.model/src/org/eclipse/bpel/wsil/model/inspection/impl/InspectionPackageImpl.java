/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.wsil.model.inspection.impl;

import org.eclipse.bpel.wsil.model.inspection.Description;
import org.eclipse.bpel.wsil.model.inspection.Inspection;
import org.eclipse.bpel.wsil.model.inspection.InspectionFactory;
import org.eclipse.bpel.wsil.model.inspection.InspectionPackage;
import org.eclipse.bpel.wsil.model.inspection.ItemWithAbstracts;
import org.eclipse.bpel.wsil.model.inspection.Link;
import org.eclipse.bpel.wsil.model.inspection.Name;
import org.eclipse.bpel.wsil.model.inspection.Reference;
import org.eclipse.bpel.wsil.model.inspection.Service;
import org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract;
import org.eclipse.bpel.wsil.model.inspection.WSILDocument;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InspectionPackageImpl extends EPackageImpl implements InspectionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemWithAbstractsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeOfAbstractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wsilDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inspectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.bpel.wsil.model.inspection.InspectionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InspectionPackageImpl() {
		super(eNS_URI, InspectionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InspectionPackage init() {
		if (isInited) return (InspectionPackage)EPackage.Registry.INSTANCE.getEPackage(InspectionPackage.eNS_URI);

		// Obtain or create and register package
		InspectionPackageImpl theInspectionPackage = (InspectionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof InspectionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new InspectionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLNamespacePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInspectionPackage.createPackageContents();

		// Initialize created meta-data
		theInspectionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInspectionPackage.freeze();

		return theInspectionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItemWithAbstracts() {
		return itemWithAbstractsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemWithAbstracts_Abstract() {
		return (EReference)itemWithAbstractsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeOfAbstract() {
		return typeOfAbstractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeOfAbstract_Value() {
		return (EAttribute)typeOfAbstractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeOfAbstract_Lang() {
		return (EAttribute)typeOfAbstractEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescription() {
		return descriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_Any() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWSILDocument() {
		return wsilDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWSILDocument_Mixed() {
		return (EAttribute)wsilDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSILDocument_XMLNSPrefixMap() {
		return (EReference)wsilDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSILDocument_XSISchemaLocation() {
		return (EReference)wsilDocumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWSILDocument_Inspection() {
		return (EReference)wsilDocumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInspection() {
		return inspectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInspection_Groups() {
		return (EAttribute)inspectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspection_Services() {
		return (EReference)inspectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspection_Links() {
		return (EReference)inspectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Any() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getName_() {
		return nameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getName_Value() {
		return (EAttribute)nameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getName_Lang() {
		return (EAttribute)nameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReference_Location() {
		return (EAttribute)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReference_ReferencedNamespace() {
		return (EAttribute)referenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Name() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Description() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InspectionFactory getInspectionFactory() {
		return (InspectionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		descriptionEClass = createEClass(DESCRIPTION);
		createEAttribute(descriptionEClass, DESCRIPTION__ANY);

		wsilDocumentEClass = createEClass(WSIL_DOCUMENT);
		createEAttribute(wsilDocumentEClass, WSIL_DOCUMENT__MIXED);
		createEReference(wsilDocumentEClass, WSIL_DOCUMENT__XMLNS_PREFIX_MAP);
		createEReference(wsilDocumentEClass, WSIL_DOCUMENT__XSI_SCHEMA_LOCATION);
		createEReference(wsilDocumentEClass, WSIL_DOCUMENT__INSPECTION);

		inspectionEClass = createEClass(INSPECTION);
		createEAttribute(inspectionEClass, INSPECTION__GROUPS);
		createEReference(inspectionEClass, INSPECTION__SERVICES);
		createEReference(inspectionEClass, INSPECTION__LINKS);

		itemWithAbstractsEClass = createEClass(ITEM_WITH_ABSTRACTS);
		createEReference(itemWithAbstractsEClass, ITEM_WITH_ABSTRACTS__ABSTRACT);

		linkEClass = createEClass(LINK);
		createEAttribute(linkEClass, LINK__ANY);

		nameEClass = createEClass(NAME);
		createEAttribute(nameEClass, NAME__VALUE);
		createEAttribute(nameEClass, NAME__LANG);

		referenceEClass = createEClass(REFERENCE);
		createEAttribute(referenceEClass, REFERENCE__LOCATION);
		createEAttribute(referenceEClass, REFERENCE__REFERENCED_NAMESPACE);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__NAME);
		createEReference(serviceEClass, SERVICE__DESCRIPTION);

		typeOfAbstractEClass = createEClass(TYPE_OF_ABSTRACT);
		createEAttribute(typeOfAbstractEClass, TYPE_OF_ABSTRACT__VALUE);
		createEAttribute(typeOfAbstractEClass, TYPE_OF_ABSTRACT__LANG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		XMLNamespacePackage theXMLNamespacePackage = (XMLNamespacePackage)EPackage.Registry.INSTANCE.getEPackage(XMLNamespacePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		descriptionEClass.getESuperTypes().add(this.getReference());
		inspectionEClass.getESuperTypes().add(this.getItemWithAbstracts());
		linkEClass.getESuperTypes().add(this.getReference());
		referenceEClass.getESuperTypes().add(this.getItemWithAbstracts());
		serviceEClass.getESuperTypes().add(this.getItemWithAbstracts());

		// Initialize classes and features; add operations and parameters
		initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescription_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsilDocumentEClass, WSILDocument.class, "WSILDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWSILDocument_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSILDocument_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSILDocument_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWSILDocument_Inspection(), this.getInspection(), null, "inspection", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(inspectionEClass, Inspection.class, "Inspection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInspection_Groups(), ecorePackage.getEFeatureMapEntry(), "groups", null, 0, -1, Inspection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInspection_Services(), this.getService(), null, "services", null, 0, -1, Inspection.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInspection_Links(), this.getLink(), null, "links", null, 0, -1, Inspection.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(itemWithAbstractsEClass, ItemWithAbstracts.class, "ItemWithAbstracts", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getItemWithAbstracts_Abstract(), this.getTypeOfAbstract(), null, "abstract", null, 0, -1, ItemWithAbstracts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLink_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameEClass, Name.class, "Name", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getName_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getName_Lang(), theXMLNamespacePackage.getLangType(), "lang", null, 0, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReference_Location(), theXMLTypePackage.getAnyURI(), "location", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReference_ReferencedNamespace(), theXMLTypePackage.getAnyURI(), "referencedNamespace", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_Name(), this.getName_(), null, "name", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Description(), this.getDescription(), null, "description", null, 1, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeOfAbstractEClass, TypeOfAbstract.class, "TypeOfAbstract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeOfAbstract_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TypeOfAbstract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeOfAbstract_Lang(), theXMLNamespacePackage.getLangType(), "lang", null, 0, 1, TypeOfAbstract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
		addAnnotation
		  (descriptionEClass, 
		   source, 
		   new String[] {
			 "name", "descriptionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDescription_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });		
		addAnnotation
		  (wsilDocumentEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getWSILDocument_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getWSILDocument_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getWSILDocument_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getWSILDocument_Inspection(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "inspection",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (inspectionEClass, 
		   source, 
		   new String[] {
			 "name", "inspection_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInspection_Groups(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:1"
		   });		
		addAnnotation
		  (getInspection_Services(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "service",
			 "namespace", "##targetNamespace",
			 "group", "#group:1"
		   });		
		addAnnotation
		  (getInspection_Links(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link",
			 "namespace", "##targetNamespace",
			 "group", "#group:1"
		   });		
		addAnnotation
		  (itemWithAbstractsEClass, 
		   source, 
		   new String[] {
			 "name", "itemWithAbstracts",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getItemWithAbstracts_Abstract(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "abstract",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (linkEClass, 
		   source, 
		   new String[] {
			 "name", "linkType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLink_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });		
		addAnnotation
		  (nameEClass, 
		   source, 
		   new String[] {
			 "name", "nameType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getName_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });			
		addAnnotation
		  (getName_Lang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lang",
			 "namespace", "http://www.w3.org/XML/1998/namespace"
		   });		
		addAnnotation
		  (referenceEClass, 
		   source, 
		   new String[] {
			 "name", "referenceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getReference_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });		
		addAnnotation
		  (getReference_ReferencedNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "referencedNamespace"
		   });		
		addAnnotation
		  (serviceEClass, 
		   source, 
		   new String[] {
			 "name", "serviceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getService_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getService_Description(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (typeOfAbstractEClass, 
		   source, 
		   new String[] {
			 "name", "typeOfAbstract",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getTypeOfAbstract_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });			
		addAnnotation
		  (getTypeOfAbstract_Lang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lang",
			 "namespace", "http://www.w3.org/XML/1998/namespace"
		   });
	}

} //InspectionPackageImpl
