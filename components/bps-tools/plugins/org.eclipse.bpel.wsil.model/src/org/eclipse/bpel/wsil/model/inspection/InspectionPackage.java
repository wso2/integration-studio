/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.wsil.model.inspection;

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
 * <!-- begin-model-doc -->
 * 
 *    See http://www.w3.org/XML/1998/namespace.html and
 *    http://www.w3.org/TR/REC-xml for information about this namespace.
 * 
 *     This schema document describes the XML namespace, in a form
 *     suitable for import by other schema documents.  
 * 
 *     Note that local names in this namespace are intended to be defined
 *     only by the World Wide Web Consortium or its subgroups.  The
 *     following names are currently defined in this namespace and should
 *     not be used with conflicting semantics by any Working Group,
 *     specification, or document instance:
 * 
 *     base (as an attribute name): denotes an attribute whose value
 *          provides a URI to be used as the base for interpreting any
 *          relative URIs in the scope of the element on which it
 *          appears; its value is inherited.  This name is reserved
 *          by virtue of its definition in the XML Base specification.
 * 
 *     id   (as an attribute name): denotes an attribute whose value
 *          should be interpreted as if declared to be of type ID.
 *          The xml:id specification is not yet a W3C Recommendation,
 *          but this attribute is included here to facilitate experimentation
 *          with the mechanisms it proposes.  Note that it is _not_ included
 *          in the specialAttrs attribute group.
 * 
 *     lang (as an attribute name): denotes an attribute whose value
 *          is a language code for the natural language of the content of
 *          any element; its value is inherited.  This name is reserved
 *          by virtue of its definition in the XML specification.
 *   
 *     space (as an attribute name): denotes an attribute whose
 *          value is a keyword indicating what whitespace processing
 *          discipline is intended for the content of the element; its
 *          value is inherited.  This name is reserved by virtue of its
 *          definition in the XML specification.
 * 
 *     Father (in any context at all): denotes Jon Bosak, the chair of 
 *          the original XML Working Group.  This name is reserved by 
 *          the following decision of the W3C XML Plenary and 
 *          XML Coordination groups:
 * 
 *              In appreciation for his vision, leadership and dedication
 *              the W3C XML Plenary on this 10th day of February, 2000
 *              reserves for Jon Bosak in perpetuity the XML name
 *              xml:Father
 *   
 * This schema defines attributes and an attribute group
 *         suitable for use by
 *         schemas wishing to allow xml:base, xml:lang, xml:space or xml:id
 *         attributes on elements they define.
 * 
 *         To enable this, such a schema must import this schema
 *         for the XML namespace, e.g. as follows:
 *         &lt;schema . . .&gt;
 *          . . .
 *          &lt;import namespace="http://www.w3.org/XML/1998/namespace"
 *                     schemaLocation="http://www.w3.org/2001/xml.xsd"/&gt;
 * 
 *         Subsequently, qualified reference to any of the attributes
 *         or the group defined below will have the desired effect, e.g.
 * 
 *         &lt;type . . .&gt;
 *          . . .
 *          &lt;attributeGroup ref="xml:specialAttrs"/&gt;
 *  
 *          will define a type which will schema-validate an instance
 *          element with any of those attributes
 * In keeping with the XML Schema WG's standard versioning
 *    policy, this schema document will persist at
 *    http://www.w3.org/2005/08/xml.xsd.
 *    At the date of issue it can also be found at
 *    http://www.w3.org/2001/xml.xsd.
 *    The schema document at that URI may however change in the future,
 *    in order to remain compatible with the latest version of XML Schema
 *    itself, or with the XML namespace itself.  In other words, if the XML
 *    Schema or XML namespaces change, the version of this document at
 *    http://www.w3.org/2001/xml.xsd will change
 *    accordingly; the version at
 *    http://www.w3.org/2005/08/xml.xsd will not change.
 *   
 * <!-- end-model-doc -->
 * @see org.eclipse.bpel.wsil.model.inspection.InspectionFactory
 * @model kind="package"
 * @generated
 */
public interface InspectionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "inspection";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schemas.xmlsoap.org/ws/2001/10/inspection/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "inspection";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InspectionPackage eINSTANCE = org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.ItemWithAbstractsImpl <em>Item With Abstracts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.ItemWithAbstractsImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getItemWithAbstracts()
	 * @generated
	 */
	int ITEM_WITH_ABSTRACTS = 3;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_WITH_ABSTRACTS__ABSTRACT = 0;

	/**
	 * The number of structural features of the '<em>Item With Abstracts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_WITH_ABSTRACTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.TypeOfAbstractImpl <em>Type Of Abstract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.TypeOfAbstractImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getTypeOfAbstract()
	 * @generated
	 */
	int TYPE_OF_ABSTRACT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.ReferenceImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ABSTRACT = ITEM_WITH_ABSTRACTS__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LOCATION = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__REFERENCED_NAMESPACE = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.DescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.DescriptionImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getDescription()
	 * @generated
	 */
	int DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__ABSTRACT = REFERENCE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__LOCATION = REFERENCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Referenced Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__REFERENCED_NAMESPACE = REFERENCE__REFERENCED_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__ANY = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.WSILDocumentImpl <em>WSIL Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.WSILDocumentImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getWSILDocument()
	 * @generated
	 */
	int WSIL_DOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSIL_DOCUMENT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSIL_DOCUMENT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSIL_DOCUMENT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Inspection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSIL_DOCUMENT__INSPECTION = 3;

	/**
	 * The number of structural features of the '<em>WSIL Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSIL_DOCUMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.InspectionImpl <em>Inspection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getInspection()
	 * @generated
	 */
	int INSPECTION = 2;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTION__ABSTRACT = ITEM_WITH_ABSTRACTS__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTION__GROUPS = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTION__SERVICES = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTION__LINKS = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Inspection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSPECTION_FEATURE_COUNT = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.LinkImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 4;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__ABSTRACT = REFERENCE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__LOCATION = REFERENCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Referenced Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__REFERENCED_NAMESPACE = REFERENCE__REFERENCED_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__ANY = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.NameImpl <em>Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.NameImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getName_()
	 * @generated
	 */
	int NAME = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__LANG = 1;

	/**
	 * The number of structural features of the '<em>Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.ServiceImpl
	 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 7;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ABSTRACT = ITEM_WITH_ABSTRACTS__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = ITEM_WITH_ABSTRACTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OF_ABSTRACT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OF_ABSTRACT__LANG = 1;

	/**
	 * The number of structural features of the '<em>Type Of Abstract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OF_ABSTRACT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.ItemWithAbstracts <em>Item With Abstracts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item With Abstracts</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.ItemWithAbstracts
	 * @generated
	 */
	EClass getItemWithAbstracts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.wsil.model.inspection.ItemWithAbstracts#getAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstract</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.ItemWithAbstracts#getAbstract()
	 * @see #getItemWithAbstracts()
	 * @generated
	 */
	EReference getItemWithAbstracts_Abstract();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract <em>Type Of Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Of Abstract</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract
	 * @generated
	 */
	EClass getTypeOfAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract#getValue()
	 * @see #getTypeOfAbstract()
	 * @generated
	 */
	EAttribute getTypeOfAbstract_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.TypeOfAbstract#getLang()
	 * @see #getTypeOfAbstract()
	 * @generated
	 */
	EAttribute getTypeOfAbstract_Lang();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Description
	 * @generated
	 */
	EClass getDescription();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.wsil.model.inspection.Description#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Description#getAny()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_Any();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.WSILDocument <em>WSIL Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WSIL Document</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.WSILDocument
	 * @generated
	 */
	EClass getWSILDocument();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.wsil.model.inspection.WSILDocument#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.WSILDocument#getMixed()
	 * @see #getWSILDocument()
	 * @generated
	 */
	EAttribute getWSILDocument_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.bpel.wsil.model.inspection.WSILDocument#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.WSILDocument#getXMLNSPrefixMap()
	 * @see #getWSILDocument()
	 * @generated
	 */
	EReference getWSILDocument_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.bpel.wsil.model.inspection.WSILDocument#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.WSILDocument#getXSISchemaLocation()
	 * @see #getWSILDocument()
	 * @generated
	 */
	EReference getWSILDocument_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.wsil.model.inspection.WSILDocument#getInspection <em>Inspection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inspection</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.WSILDocument#getInspection()
	 * @see #getWSILDocument()
	 * @generated
	 */
	EReference getWSILDocument_Inspection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.Inspection <em>Inspection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inspection</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Inspection
	 * @generated
	 */
	EClass getInspection();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.wsil.model.inspection.Inspection#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Groups</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Inspection#getGroups()
	 * @see #getInspection()
	 * @generated
	 */
	EAttribute getInspection_Groups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.wsil.model.inspection.Inspection#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Inspection#getServices()
	 * @see #getInspection()
	 * @generated
	 */
	EReference getInspection_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.wsil.model.inspection.Inspection#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Inspection#getLinks()
	 * @see #getInspection()
	 * @generated
	 */
	EReference getInspection_Links();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.wsil.model.inspection.Link#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Link#getAny()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Any();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Name
	 * @generated
	 */
	EClass getName_();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.wsil.model.inspection.Name#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Name#getValue()
	 * @see #getName_()
	 * @generated
	 */
	EAttribute getName_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.wsil.model.inspection.Name#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Name#getLang()
	 * @see #getName_()
	 * @generated
	 */
	EAttribute getName_Lang();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.wsil.model.inspection.Reference#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Reference#getLocation()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.wsil.model.inspection.Reference#getReferencedNamespace <em>Referenced Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referenced Namespace</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Reference#getReferencedNamespace()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_ReferencedNamespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.wsil.model.inspection.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.wsil.model.inspection.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Name</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.wsil.model.inspection.Service#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Description</em>'.
	 * @see org.eclipse.bpel.wsil.model.inspection.Service#getDescription()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InspectionFactory getInspectionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.ItemWithAbstractsImpl <em>Item With Abstracts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.ItemWithAbstractsImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getItemWithAbstracts()
		 * @generated
		 */
		EClass ITEM_WITH_ABSTRACTS = eINSTANCE.getItemWithAbstracts();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM_WITH_ABSTRACTS__ABSTRACT = eINSTANCE.getItemWithAbstracts_Abstract();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.TypeOfAbstractImpl <em>Type Of Abstract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.TypeOfAbstractImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getTypeOfAbstract()
		 * @generated
		 */
		EClass TYPE_OF_ABSTRACT = eINSTANCE.getTypeOfAbstract();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_OF_ABSTRACT__VALUE = eINSTANCE.getTypeOfAbstract_Value();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_OF_ABSTRACT__LANG = eINSTANCE.getTypeOfAbstract_Lang();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.DescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.DescriptionImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getDescription()
		 * @generated
		 */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__ANY = eINSTANCE.getDescription_Any();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.WSILDocumentImpl <em>WSIL Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.WSILDocumentImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getWSILDocument()
		 * @generated
		 */
		EClass WSIL_DOCUMENT = eINSTANCE.getWSILDocument();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WSIL_DOCUMENT__MIXED = eINSTANCE.getWSILDocument_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WSIL_DOCUMENT__XMLNS_PREFIX_MAP = eINSTANCE.getWSILDocument_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WSIL_DOCUMENT__XSI_SCHEMA_LOCATION = eINSTANCE.getWSILDocument_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Inspection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WSIL_DOCUMENT__INSPECTION = eINSTANCE.getWSILDocument_Inspection();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.InspectionImpl <em>Inspection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getInspection()
		 * @generated
		 */
		EClass INSPECTION = eINSTANCE.getInspection();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSPECTION__GROUPS = eINSTANCE.getInspection_Groups();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSPECTION__SERVICES = eINSTANCE.getInspection_Services();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSPECTION__LINKS = eINSTANCE.getInspection_Links();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.LinkImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__ANY = eINSTANCE.getLink_Any();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.NameImpl <em>Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.NameImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getName_()
		 * @generated
		 */
		EClass NAME = eINSTANCE.getName_();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME__VALUE = eINSTANCE.getName_Value();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME__LANG = eINSTANCE.getName_Lang();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.ReferenceImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__LOCATION = eINSTANCE.getReference_Location();

		/**
		 * The meta object literal for the '<em><b>Referenced Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__REFERENCED_NAMESPACE = eINSTANCE.getReference_ReferencedNamespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.wsil.model.inspection.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.ServiceImpl
		 * @see org.eclipse.bpel.wsil.model.inspection.impl.InspectionPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__DESCRIPTION = eINSTANCE.getService_Description();

	}

} //InspectionPackage
