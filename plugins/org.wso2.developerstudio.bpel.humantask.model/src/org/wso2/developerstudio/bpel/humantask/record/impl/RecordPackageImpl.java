/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.bpel.humantask.record.impl;

import org.eclipse.bpel.model.BPELPackage;

import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;

import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.wst.wsdl.WSDLPackage;

import org.wso2.developerstudio.bpel.humantask.record.ExtensionElement;
import org.wso2.developerstudio.bpel.humantask.record.RecordFactory;
import org.wso2.developerstudio.bpel.humantask.record.RecordPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecordPackageImpl extends EPackageImpl implements RecordPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionElementEClass = null;

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
	 * @see org.wso2.developerstudio.bpel.humantask.record.RecordPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RecordPackageImpl() {
		super(eNS_URI, RecordFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RecordPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RecordPackage init() {
		if (isInited) return (RecordPackage)EPackage.Registry.INSTANCE.getEPackage(RecordPackage.eNS_URI);

		// Obtain or create and register package
		RecordPackageImpl theRecordPackage = (RecordPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RecordPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RecordPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BPELPackage.eINSTANCE.eClass();
		PartnerlinktypePackage.eINSTANCE.eClass();
		MessagepropertiesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRecordPackage.createPackageContents();

		// Initialize created meta-data
		theRecordPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRecordPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RecordPackage.eNS_URI, theRecordPackage);
		return theRecordPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionElement() {
		return extensionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordFactory getRecordFactory() {
		return (RecordFactory)getEFactoryInstance();
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
		extensionElementEClass = createEClass(EXTENSION_ELEMENT);
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
		BPELPackage theBPELPackage = (BPELPackage)EPackage.Registry.INSTANCE.getEPackage(BPELPackage.eNS_URI);
		WSDLPackage theWSDLPackage = (WSDLPackage)EPackage.Registry.INSTANCE.getEPackage(WSDLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extensionElementEClass.getESuperTypes().add(theBPELPackage.getBPELExtensibleElement());

		// Initialize classes and features; add operations and parameters
		initEClass(extensionElementEClass, ExtensionElement.class, "ExtensionElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(extensionElementEClass, theWSDLPackage.getDOMElement(), "fixElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theWSDLPackage.getDOMDocument(), "document", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RecordPackageImpl
