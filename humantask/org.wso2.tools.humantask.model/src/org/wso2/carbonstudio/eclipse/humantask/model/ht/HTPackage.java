/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht;

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
 *          This name is reserved by virtue of its definition in the
 *          xml:id specification.
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
 *    http://www.w3.org/2007/08/xml.xsd.
 *    At the date of issue it can also be found at
 *    http://www.w3.org/2001/xml.xsd.
 *    The schema document at that URI may however change in the future,
 *    in order to remain compatible with the latest version of XML Schema
 *    itself, or with the XML namespace itself.  In other words, if the XML
 *    Schema or XML namespaces change, the version of this document at
 *    http://www.w3.org/2001/xml.xsd will change
 *    accordingly; the version at
 *    http://www.w3.org/2007/08/xml.xsd will not change.
 *   
 * <!-- end-model-doc -->
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTFactory
 * @model kind="package"
 * @generated
 */
public interface HTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ht";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/WS-HT";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ht";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HTPackage eINSTANCE = org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Business Administrators</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS = 3;

	/**
	 * The feature id for the '<em><b>Excluded Owners</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EXCLUDED_OWNERS = 4;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__GROUP = 5;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__GROUPS = 6;

	/**
	 * The feature id for the '<em><b>Human Interactions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HUMAN_INTERACTIONS = 7;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IMPORT = 8;

	/**
	 * The feature id for the '<em><b>Logical People Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS = 9;

	/**
	 * The feature id for the '<em><b>Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NOTIFICATION = 10;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NOTIFICATIONS = 11;

	/**
	 * The feature id for the '<em><b>Organizational Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY = 12;

	/**
	 * The feature id for the '<em><b>People Assignments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS = 13;

	/**
	 * The feature id for the '<em><b>Potential Owners</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POTENTIAL_OWNERS = 14;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PRIORITY = 15;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RECIPIENTS = 16;

	/**
	 * The feature id for the '<em><b>Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK = 17;

	/**
	 * The feature id for the '<em><b>Task Initiator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK_INITIATOR = 18;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASKS = 19;

	/**
	 * The feature id for the '<em><b>Task Stakeholders</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK_STAKEHOLDERS = 20;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__USER = 21;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__USERS = 22;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 23;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl <em>TExtensible Mixed Content Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtensibleMixedContentElements()
	 * @generated
	 */
	int TEXTENSIBLE_MIXED_CONTENT_ELEMENTS = 13;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION = 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>TExtensible Mixed Content Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TArgumentImpl <em>TArgument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TArgumentImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTArgument()
	 * @generated
	 */
	int TARGUMENT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGUMENT__MIXED = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGUMENT__DOCUMENTATION = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGUMENT__ANY = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGUMENT__ANY_ATTRIBUTE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGUMENT__EXPRESSION_LANGUAGE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGUMENT__NAME = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TArgument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGUMENT_FEATURE_COUNT = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExpressionImpl <em>TExpression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExpressionImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExpression()
	 * @generated
	 */
	int TEXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPRESSION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPRESSION__ANY = 1;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPRESSION__EXPRESSION_LANGUAGE = 2;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPRESSION__ANY_ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>TExpression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXPRESSION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TBooleanExprImpl <em>TBoolean Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TBooleanExprImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTBooleanExpr()
	 * @generated
	 */
	int TBOOLEAN_EXPR = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBOOLEAN_EXPR__MIXED = TEXPRESSION__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBOOLEAN_EXPR__ANY = TEXPRESSION__ANY;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBOOLEAN_EXPR__EXPRESSION_LANGUAGE = TEXPRESSION__EXPRESSION_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBOOLEAN_EXPR__ANY_ATTRIBUTE = TEXPRESSION__ANY_ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>TBoolean Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBOOLEAN_EXPR_FEATURE_COUNT = TEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleElementsImpl <em>TExtensible Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleElementsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtensibleElements()
	 * @generated
	 */
	int TEXTENSIBLE_ELEMENTS = 12;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ELEMENTS__DOCUMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ELEMENTS__ANY = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>TExtensible Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ELEMENTS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineImpl <em>TDeadline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDeadline()
	 * @generated
	 */
	int TDEADLINE = 3;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>For</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE__FOR = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Until</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE__UNTIL = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Escalation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE__ESCALATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TDeadline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineExprImpl <em>TDeadline Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineExprImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDeadlineExpr()
	 * @generated
	 */
	int TDEADLINE_EXPR = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE_EXPR__MIXED = TEXPRESSION__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE_EXPR__ANY = TEXPRESSION__ANY;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE_EXPR__EXPRESSION_LANGUAGE = TEXPRESSION__EXPRESSION_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE_EXPR__ANY_ATTRIBUTE = TEXPRESSION__ANY_ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>TDeadline Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINE_EXPR_FEATURE_COUNT = TEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlinesImpl <em>TDeadlines</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlinesImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDeadlines()
	 * @generated
	 */
	int TDEADLINES = 5;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINES__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINES__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINES__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Start Deadline</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINES__START_DEADLINE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Completion Deadline</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINES__COMPLETION_DEADLINE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TDeadlines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEADLINES_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDelegationImpl <em>TDelegation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDelegationImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDelegation()
	 * @generated
	 */
	int TDELEGATION = 6;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDELEGATION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDELEGATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDELEGATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDELEGATION__FROM = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Potential Delegatees</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDELEGATION__POTENTIAL_DELEGATEES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TDelegation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDELEGATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDescriptionImpl <em>TDescription</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDescriptionImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDescription()
	 * @generated
	 */
	int TDESCRIPTION = 7;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDESCRIPTION__MIXED = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDESCRIPTION__DOCUMENTATION = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDESCRIPTION__ANY = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDESCRIPTION__ANY_ATTRIBUTE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDESCRIPTION__CONTENT_TYPE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDESCRIPTION__LANG = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TDescription</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDESCRIPTION_FEATURE_COUNT = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDocumentationImpl <em>TDocumentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDocumentationImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDocumentation()
	 * @generated
	 */
	int TDOCUMENTATION = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTATION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTATION__ANY = 1;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTATION__LANG = 2;

	/**
	 * The number of structural features of the '<em>TDocumentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDurationExprImpl <em>TDuration Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDurationExprImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDurationExpr()
	 * @generated
	 */
	int TDURATION_EXPR = 9;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDURATION_EXPR__MIXED = TEXPRESSION__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDURATION_EXPR__ANY = TEXPRESSION__ANY;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDURATION_EXPR__EXPRESSION_LANGUAGE = TEXPRESSION__EXPRESSION_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDURATION_EXPR__ANY_ATTRIBUTE = TEXPRESSION__ANY_ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>TDuration Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDURATION_EXPR_FEATURE_COUNT = TEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl <em>TEscalation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTEscalation()
	 * @generated
	 */
	int TESCALATION = 10;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__CONDITION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__TO_PARTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__NOTIFICATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local Notification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__LOCAL_NOTIFICATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reassignment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__REASSIGNMENT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>TEscalation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESCALATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionImpl <em>TExtension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtension()
	 * @generated
	 */
	int TEXTENSION = 14;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Must Understand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSION__MUST_UNDERSTAND = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSION__NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TExtension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionsImpl <em>TExtensions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtensions()
	 * @generated
	 */
	int TEXTENSIONS = 15;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIONS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIONS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIONS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIONS__EXTENSION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TExtensions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIONS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl <em>TFrom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTFrom()
	 * @generated
	 */
	int TFROM = 16;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__MIXED = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__DOCUMENTATION = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__ANY = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__ANY_ATTRIBUTE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__ARGUMENT = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__LITERAL = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__EXPRESSION_LANGUAGE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Logical People Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__LOGICAL_PEOPLE_GROUP = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>TFrom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM_FEATURE_COUNT = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGenericHumanRoleImpl <em>TGeneric Human Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGenericHumanRoleImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTGenericHumanRole()
	 * @generated
	 */
	int TGENERIC_HUMAN_ROLE = 17;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGENERIC_HUMAN_ROLE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGENERIC_HUMAN_ROLE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGENERIC_HUMAN_ROLE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGENERIC_HUMAN_ROLE__FROM = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TGeneric Human Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGENERIC_HUMAN_ROLE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGrouplistImpl <em>TGrouplist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGrouplistImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTGrouplist()
	 * @generated
	 */
	int TGROUPLIST = 18;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGROUPLIST__GROUP = 0;

	/**
	 * The number of structural features of the '<em>TGrouplist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TGROUPLIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl <em>THuman Interactions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTHumanInteractions()
	 * @generated
	 */
	int THUMAN_INTERACTIONS = 19;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__EXTENSIONS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__IMPORT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Logical People Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__TASKS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__NOTIFICATIONS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Query Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__QUERY_LANGUAGE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS__TARGET_NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>THuman Interactions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THUMAN_INTERACTIONS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TImportImpl <em>TImport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TImportImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTImport()
	 * @generated
	 */
	int TIMPORT = 20;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Import Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__IMPORT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__LOCATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TImport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLiteralImpl <em>TLiteral</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLiteralImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLiteral()
	 * @generated
	 */
	int TLITERAL = 21;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLITERAL__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLITERAL__ANY = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLITERAL__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>TLiteral</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLITERAL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLocalNotificationImpl <em>TLocal Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLocalNotificationImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLocalNotification()
	 * @generated
	 */
	int TLOCAL_NOTIFICATION = 22;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOCAL_NOTIFICATION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOCAL_NOTIFICATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOCAL_NOTIFICATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOCAL_NOTIFICATION__PRIORITY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>People Assignments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOCAL_NOTIFICATION__REFERENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TLocal Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOCAL_NOTIFICATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupImpl <em>TLogical People Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLogicalPeopleGroup()
	 * @generated
	 */
	int TLOGICAL_PEOPLE_GROUP = 23;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUP__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUP__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUP__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUP__PARAMETER = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUP__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUP__REFERENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TLogical People Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUP_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupsImpl <em>TLogical People Groups</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLogicalPeopleGroups()
	 * @generated
	 */
	int TLOGICAL_PEOPLE_GROUPS = 24;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUPS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUPS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUPS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Logical People Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TLogical People Groups</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLOGICAL_PEOPLE_GROUPS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl <em>TNotification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTNotification()
	 * @generated
	 */
	int TNOTIFICATION = 25;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__INTERFACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__PRIORITY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>People Assignments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__PEOPLE_ASSIGNMENTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Presentation Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__PRESENTATION_ELEMENTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Renderings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__RENDERINGS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>TNotification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationInterfaceImpl <em>TNotification Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationInterfaceImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTNotificationInterface()
	 * @generated
	 */
	int TNOTIFICATION_INTERFACE = 26;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION_INTERFACE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION_INTERFACE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION_INTERFACE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION_INTERFACE__OPERATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION_INTERFACE__PORT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TNotification Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATION_INTERFACE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationsImpl <em>TNotifications</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTNotifications()
	 * @generated
	 */
	int TNOTIFICATIONS = 27;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATIONS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATIONS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATIONS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Notification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATIONS__NOTIFICATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TNotifications</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TNOTIFICATIONS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TOrganizationalEntityImpl <em>TOrganizational Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TOrganizationalEntityImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTOrganizationalEntity()
	 * @generated
	 */
	int TORGANIZATIONAL_ENTITY = 28;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TORGANIZATIONAL_ENTITY__USERS = 0;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TORGANIZATIONAL_ENTITY__GROUPS = 1;

	/**
	 * The number of structural features of the '<em>TOrganizational Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TORGANIZATIONAL_ENTITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TParameterImpl <em>TParameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TParameterImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTParameter()
	 * @generated
	 */
	int TPARAMETER = 29;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAMETER__MIXED = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAMETER__DOCUMENTATION = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAMETER__ANY = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAMETER__ANY_ATTRIBUTE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAMETER__NAME = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAMETER__TYPE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TParameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAMETER_FEATURE_COUNT = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPeopleAssignmentsImpl <em>TPeople Assignments</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPeopleAssignmentsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPeopleAssignments()
	 * @generated
	 */
	int TPEOPLE_ASSIGNMENTS = 30;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Generic Human Role</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__GENERIC_HUMAN_ROLE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Potential Owners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__POTENTIAL_OWNERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Excluded Owners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__EXCLUDED_OWNERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Task Initiator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__TASK_INITIATOR = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Task Stakeholders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__TASK_STAKEHOLDERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Business Administrators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__BUSINESS_ADMINISTRATORS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Recipients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS__RECIPIENTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>TPeople Assignments</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPEOPLE_ASSIGNMENTS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl <em>TPresentation Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPresentationElements()
	 * @generated
	 */
	int TPRESENTATION_ELEMENTS = 31;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Presentation Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS__SUBJECT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS__DESCRIPTION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>TPresentation Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_ELEMENTS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParameterImpl <em>TPresentation Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParameterImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPresentationParameter()
	 * @generated
	 */
	int TPRESENTATION_PARAMETER = 32;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETER__MIXED = TPARAMETER__MIXED;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETER__DOCUMENTATION = TPARAMETER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETER__ANY = TPARAMETER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETER__ANY_ATTRIBUTE = TPARAMETER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETER__NAME = TPARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETER__TYPE = TPARAMETER__TYPE;

	/**
	 * The number of structural features of the '<em>TPresentation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETER_FEATURE_COUNT = TPARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParametersImpl <em>TPresentation Parameters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParametersImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPresentationParameters()
	 * @generated
	 */
	int TPRESENTATION_PARAMETERS = 33;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETERS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETERS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETERS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Presentation Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETERS__PRESENTATION_PARAMETER = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETERS__EXPRESSION_LANGUAGE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TPresentation Parameters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRESENTATION_PARAMETERS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPriorityImpl <em>TPriority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPriorityImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPriority()
	 * @generated
	 */
	int TPRIORITY = 34;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRIORITY__MIXED = TEXPRESSION__MIXED;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRIORITY__ANY = TEXPRESSION__ANY;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRIORITY__EXPRESSION_LANGUAGE = TEXPRESSION__EXPRESSION_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRIORITY__ANY_ATTRIBUTE = TEXPRESSION__ANY_ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>TPriority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPRIORITY_FEATURE_COUNT = TEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TQueryImpl <em>TQuery</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TQueryImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTQuery()
	 * @generated
	 */
	int TQUERY = 35;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TQUERY__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TQUERY__ANY = 1;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TQUERY__PART = 2;

	/**
	 * The feature id for the '<em><b>Query Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TQUERY__QUERY_LANGUAGE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TQUERY__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>TQuery</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TQUERY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TReassignmentImpl <em>TReassignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TReassignmentImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTReassignment()
	 * @generated
	 */
	int TREASSIGNMENT = 36;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREASSIGNMENT__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREASSIGNMENT__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREASSIGNMENT__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Potential Owners</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREASSIGNMENT__POTENTIAL_OWNERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TReassignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREASSIGNMENT_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingImpl <em>TRendering</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTRendering()
	 * @generated
	 */
	int TRENDERING = 37;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERING__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERING__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERING__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERING__TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TRendering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERING_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingsImpl <em>TRenderings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTRenderings()
	 * @generated
	 */
	int TRENDERINGS = 38;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERINGS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERINGS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERINGS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Rendering</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERINGS__RENDERING = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TRenderings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRENDERINGS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskImpl <em>TTask</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTTask()
	 * @generated
	 */
	int TTASK = 39;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__INTERFACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__PRIORITY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>People Assignments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__PEOPLE_ASSIGNMENTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__DELEGATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Presentation Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__PRESENTATION_ELEMENTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outcome</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__OUTCOME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Search By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__SEARCH_BY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Renderings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__RENDERINGS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Deadlines</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__DEADLINES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>TTask</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl <em>TTask Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTTaskInterface()
	 * @generated
	 */
	int TTASK_INTERFACE = 40;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE__OPERATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE__PORT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Response Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE__RESPONSE_OPERATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Response Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE__RESPONSE_PORT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>TTask Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASK_INTERFACE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTasksImpl <em>TTasks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTasksImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTTasks()
	 * @generated
	 */
	int TTASKS = 41;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASKS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASKS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASKS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Task</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASKS__TASK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TTasks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTASKS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTextImpl <em>TText</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTextImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTText()
	 * @generated
	 */
	int TTEXT = 42;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTEXT__MIXED = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTEXT__DOCUMENTATION = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTEXT__ANY = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTEXT__ANY_ATTRIBUTE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTEXT__LANG = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TText</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTEXT_FEATURE_COUNT = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartImpl <em>TTo Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTToPart()
	 * @generated
	 */
	int TTO_PART = 43;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PART__MIXED = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PART__DOCUMENTATION = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PART__ANY = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PART__ANY_ATTRIBUTE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PART__EXPRESSION_LANGUAGE = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PART__NAME = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TTo Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PART_FEATURE_COUNT = TEXTENSIBLE_MIXED_CONTENT_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartsImpl <em>TTo Parts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartsImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTToParts()
	 * @generated
	 */
	int TTO_PARTS = 44;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PARTS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PARTS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PARTS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>To Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PARTS__TO_PART = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TTo Parts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTO_PARTS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TUserlistImpl <em>TUserlist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TUserlistImpl
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTUserlist()
	 * @generated
	 */
	int TUSERLIST = 45;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUSERLIST__USER = 0;

	/**
	 * The number of structural features of the '<em>TUserlist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUSERLIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean <em>TBoolean</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTBoolean()
	 * @generated
	 */
	int TBOOLEAN = 46;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees <em>TPotential Delegatees</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPotentialDelegatees()
	 * @generated
	 */
	int TPOTENTIAL_DELEGATEES = 47;

	/**
	 * The meta object id for the '<em>TBoolean Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTBooleanObject()
	 * @generated
	 */
	int TBOOLEAN_OBJECT = 48;

	/**
	 * The meta object id for the '<em>TGroup</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTGroup()
	 * @generated
	 */
	int TGROUP = 49;

	/**
	 * The meta object id for the '<em>TPotential Delegatees Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPotentialDelegateesObject()
	 * @generated
	 */
	int TPOTENTIAL_DELEGATEES_OBJECT = 50;

	/**
	 * The meta object id for the '<em>TUser</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTUser()
	 * @generated
	 */
	int TUSER = 51;


	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getBusinessAdministrators <em>Business Administrators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Business Administrators</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getBusinessAdministrators()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BusinessAdministrators();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getExcludedOwners <em>Excluded Owners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Excluded Owners</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getExcludedOwners()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ExcludedOwners();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroup()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Group();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Groups</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getGroups()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Groups();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getHumanInteractions <em>Human Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Human Interactions</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getHumanInteractions()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_HumanInteractions();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Import</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getImport()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Import();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getLogicalPeopleGroups <em>Logical People Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Logical People Groups</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getLogicalPeopleGroups()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LogicalPeopleGroups();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Notification</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotification()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Notification();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotifications <em>Notifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Notifications</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getNotifications()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Notifications();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getOrganizationalEntity <em>Organizational Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Organizational Entity</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getOrganizationalEntity()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_OrganizationalEntity();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPeopleAssignments <em>People Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>People Assignments</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPeopleAssignments()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PeopleAssignments();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPotentialOwners <em>Potential Owners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Potential Owners</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPotentialOwners()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PotentialOwners();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Priority</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getPriority()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Priority();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getRecipients <em>Recipients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Recipients</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getRecipients()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Recipients();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTask()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Task();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskInitiator <em>Task Initiator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Initiator</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskInitiator()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TaskInitiator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tasks</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTasks()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Tasks();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskStakeholders <em>Task Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Stakeholders</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getTaskStakeholders()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TaskStakeholders();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUser()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_User();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Users</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot#getUsers()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Users();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument <em>TArgument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TArgument</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument
	 * @generated
	 */
	EClass getTArgument();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument#getExpressionLanguage()
	 * @see #getTArgument()
	 * @generated
	 */
	EAttribute getTArgument_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument#getName()
	 * @see #getTArgument()
	 * @generated
	 */
	EAttribute getTArgument_Name();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TBooleanExpr <em>TBoolean Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TBoolean Expr</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBooleanExpr
	 * @generated
	 */
	EClass getTBooleanExpr();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline <em>TDeadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDeadline</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline
	 * @generated
	 */
	EClass getTDeadline();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline#getFor <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>For</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline#getFor()
	 * @see #getTDeadline()
	 * @generated
	 */
	EReference getTDeadline_For();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline#getUntil <em>Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Until</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline#getUntil()
	 * @see #getTDeadline()
	 * @generated
	 */
	EReference getTDeadline_Until();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline#getEscalation <em>Escalation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Escalation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline#getEscalation()
	 * @see #getTDeadline()
	 * @generated
	 */
	EReference getTDeadline_Escalation();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlineExpr <em>TDeadline Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDeadline Expr</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlineExpr
	 * @generated
	 */
	EClass getTDeadlineExpr();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines <em>TDeadlines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDeadlines</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines
	 * @generated
	 */
	EClass getTDeadlines();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines#getStartDeadline <em>Start Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Start Deadline</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines#getStartDeadline()
	 * @see #getTDeadlines()
	 * @generated
	 */
	EReference getTDeadlines_StartDeadline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines#getCompletionDeadline <em>Completion Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Completion Deadline</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines#getCompletionDeadline()
	 * @see #getTDeadlines()
	 * @generated
	 */
	EReference getTDeadlines_CompletionDeadline();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation <em>TDelegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDelegation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation
	 * @generated
	 */
	EClass getTDelegation();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getFrom()
	 * @see #getTDelegation()
	 * @generated
	 */
	EReference getTDelegation_From();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getPotentialDelegatees <em>Potential Delegatees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Potential Delegatees</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation#getPotentialDelegatees()
	 * @see #getTDelegation()
	 * @generated
	 */
	EAttribute getTDelegation_PotentialDelegatees();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription <em>TDescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDescription</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription
	 * @generated
	 */
	EClass getTDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription#getContentType()
	 * @see #getTDescription()
	 * @generated
	 */
	EAttribute getTDescription_ContentType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription#getLang()
	 * @see #getTDescription()
	 * @generated
	 */
	EAttribute getTDescription_Lang();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation <em>TDocumentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDocumentation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation
	 * @generated
	 */
	EClass getTDocumentation();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation#getMixed()
	 * @see #getTDocumentation()
	 * @generated
	 */
	EAttribute getTDocumentation_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation#getAny()
	 * @see #getTDocumentation()
	 * @generated
	 */
	EAttribute getTDocumentation_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation#getLang()
	 * @see #getTDocumentation()
	 * @generated
	 */
	EAttribute getTDocumentation_Lang();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDurationExpr <em>TDuration Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDuration Expr</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDurationExpr
	 * @generated
	 */
	EClass getTDurationExpr();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation <em>TEscalation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEscalation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation
	 * @generated
	 */
	EClass getTEscalation();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getCondition()
	 * @see #getTEscalation()
	 * @generated
	 */
	EReference getTEscalation_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getToParts <em>To Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>To Parts</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getToParts()
	 * @see #getTEscalation()
	 * @generated
	 */
	EReference getTEscalation_ToParts();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getNotification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Notification</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getNotification()
	 * @see #getTEscalation()
	 * @generated
	 */
	EReference getTEscalation_Notification();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getLocalNotification <em>Local Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Notification</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getLocalNotification()
	 * @see #getTEscalation()
	 * @generated
	 */
	EReference getTEscalation_LocalNotification();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getReassignment <em>Reassignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reassignment</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getReassignment()
	 * @see #getTEscalation()
	 * @generated
	 */
	EReference getTEscalation_Reassignment();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation#getName()
	 * @see #getTEscalation()
	 * @generated
	 */
	EAttribute getTEscalation_Name();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression <em>TExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExpression</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression
	 * @generated
	 */
	EClass getTExpression();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getMixed()
	 * @see #getTExpression()
	 * @generated
	 */
	EAttribute getTExpression_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getAny()
	 * @see #getTExpression()
	 * @generated
	 */
	EAttribute getTExpression_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getExpressionLanguage()
	 * @see #getTExpression()
	 * @generated
	 */
	EAttribute getTExpression_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression#getAnyAttribute()
	 * @see #getTExpression()
	 * @generated
	 */
	EAttribute getTExpression_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements <em>TExtensible Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtensible Elements</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements
	 * @generated
	 */
	EClass getTExtensibleElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documentation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements#getDocumentation()
	 * @see #getTExtensibleElements()
	 * @generated
	 */
	EReference getTExtensibleElements_Documentation();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements#getAny()
	 * @see #getTExtensibleElements()
	 * @generated
	 */
	EAttribute getTExtensibleElements_Any();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements#getAnyAttribute()
	 * @see #getTExtensibleElements()
	 * @generated
	 */
	EAttribute getTExtensibleElements_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements <em>TExtensible Mixed Content Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtensible Mixed Content Elements</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements
	 * @generated
	 */
	EClass getTExtensibleMixedContentElements();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getMixed()
	 * @see #getTExtensibleMixedContentElements()
	 * @generated
	 */
	EAttribute getTExtensibleMixedContentElements_Mixed();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documentation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getDocumentation()
	 * @see #getTExtensibleMixedContentElements()
	 * @generated
	 */
	EReference getTExtensibleMixedContentElements_Documentation();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getAny()
	 * @see #getTExtensibleMixedContentElements()
	 * @generated
	 */
	EAttribute getTExtensibleMixedContentElements_Any();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements#getAnyAttribute()
	 * @see #getTExtensibleMixedContentElements()
	 * @generated
	 */
	EAttribute getTExtensibleMixedContentElements_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension <em>TExtension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtension</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension
	 * @generated
	 */
	EClass getTExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension#getMustUnderstand <em>Must Understand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Must Understand</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension#getMustUnderstand()
	 * @see #getTExtension()
	 * @generated
	 */
	EAttribute getTExtension_MustUnderstand();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension#getNamespace()
	 * @see #getTExtension()
	 * @generated
	 */
	EAttribute getTExtension_Namespace();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions <em>TExtensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtensions</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions
	 * @generated
	 */
	EClass getTExtensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions#getExtension()
	 * @see #getTExtensions()
	 * @generated
	 */
	EReference getTExtensions_Extension();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom <em>TFrom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFrom</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom
	 * @generated
	 */
	EClass getTFrom();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getArgument()
	 * @see #getTFrom()
	 * @generated
	 */
	EReference getTFrom_Argument();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getLiteral()
	 * @see #getTFrom()
	 * @generated
	 */
	EReference getTFrom_Literal();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getExpressionLanguage()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getLogicalPeopleGroup <em>Logical People Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logical People Group</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom#getLogicalPeopleGroup()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_LogicalPeopleGroup();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole <em>TGeneric Human Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TGeneric Human Role</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole
	 * @generated
	 */
	EClass getTGenericHumanRole();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole#getFrom()
	 * @see #getTGenericHumanRole()
	 * @generated
	 */
	EReference getTGenericHumanRole_From();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist <em>TGrouplist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TGrouplist</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist
	 * @generated
	 */
	EClass getTGrouplist();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist#getGroup()
	 * @see #getTGrouplist()
	 * @generated
	 */
	EAttribute getTGrouplist_Group();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions <em>THuman Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>THuman Interactions</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions
	 * @generated
	 */
	EClass getTHumanInteractions();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extensions</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExtensions()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EReference getTHumanInteractions_Extensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getImport()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EReference getTHumanInteractions_Import();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getLogicalPeopleGroups <em>Logical People Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Logical People Groups</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getLogicalPeopleGroups()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EReference getTHumanInteractions_LogicalPeopleGroups();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tasks</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTasks()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EReference getTHumanInteractions_Tasks();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getNotifications <em>Notifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Notifications</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getNotifications()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EReference getTHumanInteractions_Notifications();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getExpressionLanguage()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EAttribute getTHumanInteractions_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getQueryLanguage <em>Query Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getQueryLanguage()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EAttribute getTHumanInteractions_QueryLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTargetNamespace <em>Target Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Namespace</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions#getTargetNamespace()
	 * @see #getTHumanInteractions()
	 * @generated
	 */
	EAttribute getTHumanInteractions_TargetNamespace();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TImport <em>TImport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TImport</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TImport
	 * @generated
	 */
	EClass getTImport();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TImport#getImportType <em>Import Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TImport#getImportType()
	 * @see #getTImport()
	 * @generated
	 */
	EAttribute getTImport_ImportType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TImport#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TImport#getLocation()
	 * @see #getTImport()
	 * @generated
	 */
	EAttribute getTImport_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TImport#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TImport#getNamespace()
	 * @see #getTImport()
	 * @generated
	 */
	EAttribute getTImport_Namespace();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral <em>TLiteral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLiteral</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral
	 * @generated
	 */
	EClass getTLiteral();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral#getMixed()
	 * @see #getTLiteral()
	 * @generated
	 */
	EAttribute getTLiteral_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral#getAny()
	 * @see #getTLiteral()
	 * @generated
	 */
	EAttribute getTLiteral_Any();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral#getAnyAttribute()
	 * @see #getTLiteral()
	 * @generated
	 */
	EAttribute getTLiteral_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification <em>TLocal Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLocal Notification</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification
	 * @generated
	 */
	EClass getTLocalNotification();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Priority</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification#getPriority()
	 * @see #getTLocalNotification()
	 * @generated
	 */
	EReference getTLocalNotification_Priority();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification#getPeopleAssignments <em>People Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>People Assignments</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification#getPeopleAssignments()
	 * @see #getTLocalNotification()
	 * @generated
	 */
	EReference getTLocalNotification_PeopleAssignments();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification#getReference()
	 * @see #getTLocalNotification()
	 * @generated
	 */
	EAttribute getTLocalNotification_Reference();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup <em>TLogical People Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLogical People Group</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup
	 * @generated
	 */
	EClass getTLogicalPeopleGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup#getParameter()
	 * @see #getTLogicalPeopleGroup()
	 * @generated
	 */
	EReference getTLogicalPeopleGroup_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup#getName()
	 * @see #getTLogicalPeopleGroup()
	 * @generated
	 */
	EAttribute getTLogicalPeopleGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup#getReference()
	 * @see #getTLogicalPeopleGroup()
	 * @generated
	 */
	EAttribute getTLogicalPeopleGroup_Reference();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups <em>TLogical People Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLogical People Groups</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups
	 * @generated
	 */
	EClass getTLogicalPeopleGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups#getLogicalPeopleGroup <em>Logical People Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Logical People Group</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups#getLogicalPeopleGroup()
	 * @see #getTLogicalPeopleGroups()
	 * @generated
	 */
	EReference getTLogicalPeopleGroups_LogicalPeopleGroup();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification <em>TNotification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TNotification</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification
	 * @generated
	 */
	EClass getTNotification();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getInterface()
	 * @see #getTNotification()
	 * @generated
	 */
	EReference getTNotification_Interface();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Priority</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPriority()
	 * @see #getTNotification()
	 * @generated
	 */
	EReference getTNotification_Priority();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPeopleAssignments <em>People Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>People Assignments</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPeopleAssignments()
	 * @see #getTNotification()
	 * @generated
	 */
	EReference getTNotification_PeopleAssignments();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPresentationElements <em>Presentation Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Presentation Elements</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getPresentationElements()
	 * @see #getTNotification()
	 * @generated
	 */
	EReference getTNotification_PresentationElements();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getRenderings <em>Renderings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Renderings</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getRenderings()
	 * @see #getTNotification()
	 * @generated
	 */
	EReference getTNotification_Renderings();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification#getName()
	 * @see #getTNotification()
	 * @generated
	 */
	EAttribute getTNotification_Name();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface <em>TNotification Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TNotification Interface</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface
	 * @generated
	 */
	EClass getTNotificationInterface();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface#getOperation()
	 * @see #getTNotificationInterface()
	 * @generated
	 */
	EAttribute getTNotificationInterface_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface#getPortType()
	 * @see #getTNotificationInterface()
	 * @generated
	 */
	EAttribute getTNotificationInterface_PortType();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications <em>TNotifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TNotifications</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications
	 * @generated
	 */
	EClass getTNotifications();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications#getNotification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notification</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications#getNotification()
	 * @see #getTNotifications()
	 * @generated
	 */
	EReference getTNotifications_Notification();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity <em>TOrganizational Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOrganizational Entity</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity
	 * @generated
	 */
	EClass getTOrganizationalEntity();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Users</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity#getUsers()
	 * @see #getTOrganizationalEntity()
	 * @generated
	 */
	EReference getTOrganizationalEntity_Users();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Groups</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity#getGroups()
	 * @see #getTOrganizationalEntity()
	 * @generated
	 */
	EReference getTOrganizationalEntity_Groups();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter <em>TParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TParameter</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter
	 * @generated
	 */
	EClass getTParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter#getName()
	 * @see #getTParameter()
	 * @generated
	 */
	EAttribute getTParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter#getType()
	 * @see #getTParameter()
	 * @generated
	 */
	EAttribute getTParameter_Type();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments <em>TPeople Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPeople Assignments</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments
	 * @generated
	 */
	EClass getTPeopleAssignments();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getGenericHumanRole <em>Generic Human Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Generic Human Role</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getGenericHumanRole()
	 * @see #getTPeopleAssignments()
	 * @generated
	 */
	EAttribute getTPeopleAssignments_GenericHumanRole();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getPotentialOwners <em>Potential Owners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Potential Owners</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getPotentialOwners()
	 * @see #getTPeopleAssignments()
	 * @generated
	 */
	EReference getTPeopleAssignments_PotentialOwners();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getExcludedOwners <em>Excluded Owners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Excluded Owners</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getExcludedOwners()
	 * @see #getTPeopleAssignments()
	 * @generated
	 */
	EReference getTPeopleAssignments_ExcludedOwners();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getTaskInitiator <em>Task Initiator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Initiator</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getTaskInitiator()
	 * @see #getTPeopleAssignments()
	 * @generated
	 */
	EReference getTPeopleAssignments_TaskInitiator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getTaskStakeholders <em>Task Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Stakeholders</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getTaskStakeholders()
	 * @see #getTPeopleAssignments()
	 * @generated
	 */
	EReference getTPeopleAssignments_TaskStakeholders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getBusinessAdministrators <em>Business Administrators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Business Administrators</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getBusinessAdministrators()
	 * @see #getTPeopleAssignments()
	 * @generated
	 */
	EReference getTPeopleAssignments_BusinessAdministrators();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getRecipients <em>Recipients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Recipients</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments#getRecipients()
	 * @see #getTPeopleAssignments()
	 * @generated
	 */
	EReference getTPeopleAssignments_Recipients();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements <em>TPresentation Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPresentation Elements</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements
	 * @generated
	 */
	EClass getTPresentationElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getName()
	 * @see #getTPresentationElements()
	 * @generated
	 */
	EReference getTPresentationElements_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getPresentationParameters <em>Presentation Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Presentation Parameters</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getPresentationParameters()
	 * @see #getTPresentationElements()
	 * @generated
	 */
	EReference getTPresentationElements_PresentationParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subject</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getSubject()
	 * @see #getTPresentationElements()
	 * @generated
	 */
	EReference getTPresentationElements_Subject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Description</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements#getDescription()
	 * @see #getTPresentationElements()
	 * @generated
	 */
	EReference getTPresentationElements_Description();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameter <em>TPresentation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPresentation Parameter</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameter
	 * @generated
	 */
	EClass getTPresentationParameter();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters <em>TPresentation Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPresentation Parameters</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters
	 * @generated
	 */
	EClass getTPresentationParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters#getPresentationParameter <em>Presentation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Presentation Parameter</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters#getPresentationParameter()
	 * @see #getTPresentationParameters()
	 * @generated
	 */
	EReference getTPresentationParameters_PresentationParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters#getExpressionLanguage()
	 * @see #getTPresentationParameters()
	 * @generated
	 */
	EAttribute getTPresentationParameters_ExpressionLanguage();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority <em>TPriority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPriority</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority
	 * @generated
	 */
	EClass getTPriority();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery <em>TQuery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TQuery</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery
	 * @generated
	 */
	EClass getTQuery();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getMixed()
	 * @see #getTQuery()
	 * @generated
	 */
	EAttribute getTQuery_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getAny()
	 * @see #getTQuery()
	 * @generated
	 */
	EAttribute getTQuery_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getPart()
	 * @see #getTQuery()
	 * @generated
	 */
	EAttribute getTQuery_Part();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getQueryLanguage <em>Query Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getQueryLanguage()
	 * @see #getTQuery()
	 * @generated
	 */
	EAttribute getTQuery_QueryLanguage();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery#getAnyAttribute()
	 * @see #getTQuery()
	 * @generated
	 */
	EAttribute getTQuery_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment <em>TReassignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TReassignment</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment
	 * @generated
	 */
	EClass getTReassignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment#getPotentialOwners <em>Potential Owners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Potential Owners</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment#getPotentialOwners()
	 * @see #getTReassignment()
	 * @generated
	 */
	EReference getTReassignment_PotentialOwners();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering <em>TRendering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TRendering</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering
	 * @generated
	 */
	EClass getTRendering();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering#getType()
	 * @see #getTRendering()
	 * @generated
	 */
	EAttribute getTRendering_Type();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings <em>TRenderings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TRenderings</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings
	 * @generated
	 */
	EClass getTRenderings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings#getRendering <em>Rendering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rendering</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings#getRendering()
	 * @see #getTRenderings()
	 * @generated
	 */
	EReference getTRenderings_Rendering();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask <em>TTask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTask</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask
	 * @generated
	 */
	EClass getTTask();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getInterface()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_Interface();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Priority</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPriority()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_Priority();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPeopleAssignments <em>People Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>People Assignments</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPeopleAssignments()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_PeopleAssignments();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDelegation <em>Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Delegation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDelegation()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_Delegation();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPresentationElements <em>Presentation Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Presentation Elements</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getPresentationElements()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_PresentationElements();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getOutcome <em>Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outcome</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getOutcome()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_Outcome();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getSearchBy <em>Search By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Search By</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getSearchBy()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_SearchBy();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getRenderings <em>Renderings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Renderings</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getRenderings()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_Renderings();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDeadlines <em>Deadlines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deadlines</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getDeadlines()
	 * @see #getTTask()
	 * @generated
	 */
	EReference getTTask_Deadlines();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask#getName()
	 * @see #getTTask()
	 * @generated
	 */
	EAttribute getTTask_Name();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface <em>TTask Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTask Interface</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface
	 * @generated
	 */
	EClass getTTaskInterface();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getOperation()
	 * @see #getTTaskInterface()
	 * @generated
	 */
	EAttribute getTTaskInterface_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getPortType()
	 * @see #getTTaskInterface()
	 * @generated
	 */
	EAttribute getTTaskInterface_PortType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponseOperation <em>Response Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Operation</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponseOperation()
	 * @see #getTTaskInterface()
	 * @generated
	 */
	EAttribute getTTaskInterface_ResponseOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponsePortType <em>Response Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Port Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface#getResponsePortType()
	 * @see #getTTaskInterface()
	 * @generated
	 */
	EAttribute getTTaskInterface_ResponsePortType();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks <em>TTasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTasks</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks
	 * @generated
	 */
	EClass getTTasks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks#getTask()
	 * @see #getTTasks()
	 * @generated
	 */
	EReference getTTasks_Task();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TText <em>TText</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TText</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TText
	 * @generated
	 */
	EClass getTText();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TText#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TText#getLang()
	 * @see #getTText()
	 * @generated
	 */
	EAttribute getTText_Lang();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart <em>TTo Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTo Part</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart
	 * @generated
	 */
	EClass getTToPart();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart#getExpressionLanguage()
	 * @see #getTToPart()
	 * @generated
	 */
	EAttribute getTToPart_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart#getName()
	 * @see #getTToPart()
	 * @generated
	 */
	EAttribute getTToPart_Name();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts <em>TTo Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTo Parts</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts
	 * @generated
	 */
	EClass getTToParts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts#getToPart <em>To Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>To Part</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts#getToPart()
	 * @see #getTToParts()
	 * @generated
	 */
	EReference getTToParts_ToPart();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist <em>TUserlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TUserlist</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist
	 * @generated
	 */
	EClass getTUserlist();

	/**
	 * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>User</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist#getUser()
	 * @see #getTUserlist()
	 * @generated
	 */
	EAttribute getTUserlist_User();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean <em>TBoolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TBoolean</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean
	 * @generated
	 */
	EEnum getTBoolean();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees <em>TPotential Delegatees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TPotential Delegatees</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
	 * @generated
	 */
	EEnum getTPotentialDelegatees();

	/**
	 * Returns the meta object for data type '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean <em>TBoolean Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TBoolean Object</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean
	 * @model instanceClass="org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean"
	 *        extendedMetaData="name='tBoolean:Object' baseType='tBoolean'"
	 * @generated
	 */
	EDataType getTBooleanObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>TGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TGroup</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='tGroup' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
	 * @generated
	 */
	EDataType getTGroup();

	/**
	 * Returns the meta object for data type '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees <em>TPotential Delegatees Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TPotential Delegatees Object</em>'.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
	 * @model instanceClass="org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees"
	 *        extendedMetaData="name='tPotentialDelegatees:Object' baseType='tPotentialDelegatees'"
	 * @generated
	 */
	EDataType getTPotentialDelegateesObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>TUser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TUser</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='tUser' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
	 * @generated
	 */
	EDataType getTUser();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HTFactory getHTFactory();

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
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.DocumentRootImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Business Administrators</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS = eINSTANCE.getDocumentRoot_BusinessAdministrators();

		/**
		 * The meta object literal for the '<em><b>Excluded Owners</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EXCLUDED_OWNERS = eINSTANCE.getDocumentRoot_ExcludedOwners();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__GROUP = eINSTANCE.getDocumentRoot_Group();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__GROUPS = eINSTANCE.getDocumentRoot_Groups();

		/**
		 * The meta object literal for the '<em><b>Human Interactions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HUMAN_INTERACTIONS = eINSTANCE.getDocumentRoot_HumanInteractions();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__IMPORT = eINSTANCE.getDocumentRoot_Import();

		/**
		 * The meta object literal for the '<em><b>Logical People Groups</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS = eINSTANCE.getDocumentRoot_LogicalPeopleGroups();

		/**
		 * The meta object literal for the '<em><b>Notification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__NOTIFICATION = eINSTANCE.getDocumentRoot_Notification();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__NOTIFICATIONS = eINSTANCE.getDocumentRoot_Notifications();

		/**
		 * The meta object literal for the '<em><b>Organizational Entity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY = eINSTANCE.getDocumentRoot_OrganizationalEntity();

		/**
		 * The meta object literal for the '<em><b>People Assignments</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS = eINSTANCE.getDocumentRoot_PeopleAssignments();

		/**
		 * The meta object literal for the '<em><b>Potential Owners</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__POTENTIAL_OWNERS = eINSTANCE.getDocumentRoot_PotentialOwners();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PRIORITY = eINSTANCE.getDocumentRoot_Priority();

		/**
		 * The meta object literal for the '<em><b>Recipients</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RECIPIENTS = eINSTANCE.getDocumentRoot_Recipients();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASK = eINSTANCE.getDocumentRoot_Task();

		/**
		 * The meta object literal for the '<em><b>Task Initiator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASK_INITIATOR = eINSTANCE.getDocumentRoot_TaskInitiator();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASKS = eINSTANCE.getDocumentRoot_Tasks();

		/**
		 * The meta object literal for the '<em><b>Task Stakeholders</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASK_STAKEHOLDERS = eINSTANCE.getDocumentRoot_TaskStakeholders();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__USER = eINSTANCE.getDocumentRoot_User();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__USERS = eINSTANCE.getDocumentRoot_Users();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TArgumentImpl <em>TArgument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TArgumentImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTArgument()
		 * @generated
		 */
		EClass TARGUMENT = eINSTANCE.getTArgument();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGUMENT__EXPRESSION_LANGUAGE = eINSTANCE.getTArgument_ExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGUMENT__NAME = eINSTANCE.getTArgument_Name();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TBooleanExprImpl <em>TBoolean Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TBooleanExprImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTBooleanExpr()
		 * @generated
		 */
		EClass TBOOLEAN_EXPR = eINSTANCE.getTBooleanExpr();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineImpl <em>TDeadline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDeadline()
		 * @generated
		 */
		EClass TDEADLINE = eINSTANCE.getTDeadline();

		/**
		 * The meta object literal for the '<em><b>For</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEADLINE__FOR = eINSTANCE.getTDeadline_For();

		/**
		 * The meta object literal for the '<em><b>Until</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEADLINE__UNTIL = eINSTANCE.getTDeadline_Until();

		/**
		 * The meta object literal for the '<em><b>Escalation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEADLINE__ESCALATION = eINSTANCE.getTDeadline_Escalation();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineExprImpl <em>TDeadline Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlineExprImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDeadlineExpr()
		 * @generated
		 */
		EClass TDEADLINE_EXPR = eINSTANCE.getTDeadlineExpr();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlinesImpl <em>TDeadlines</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDeadlinesImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDeadlines()
		 * @generated
		 */
		EClass TDEADLINES = eINSTANCE.getTDeadlines();

		/**
		 * The meta object literal for the '<em><b>Start Deadline</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEADLINES__START_DEADLINE = eINSTANCE.getTDeadlines_StartDeadline();

		/**
		 * The meta object literal for the '<em><b>Completion Deadline</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEADLINES__COMPLETION_DEADLINE = eINSTANCE.getTDeadlines_CompletionDeadline();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDelegationImpl <em>TDelegation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDelegationImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDelegation()
		 * @generated
		 */
		EClass TDELEGATION = eINSTANCE.getTDelegation();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDELEGATION__FROM = eINSTANCE.getTDelegation_From();

		/**
		 * The meta object literal for the '<em><b>Potential Delegatees</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDELEGATION__POTENTIAL_DELEGATEES = eINSTANCE.getTDelegation_PotentialDelegatees();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDescriptionImpl <em>TDescription</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDescriptionImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDescription()
		 * @generated
		 */
		EClass TDESCRIPTION = eINSTANCE.getTDescription();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDESCRIPTION__CONTENT_TYPE = eINSTANCE.getTDescription_ContentType();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDESCRIPTION__LANG = eINSTANCE.getTDescription_Lang();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDocumentationImpl <em>TDocumentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDocumentationImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDocumentation()
		 * @generated
		 */
		EClass TDOCUMENTATION = eINSTANCE.getTDocumentation();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDOCUMENTATION__MIXED = eINSTANCE.getTDocumentation_Mixed();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDOCUMENTATION__ANY = eINSTANCE.getTDocumentation_Any();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDOCUMENTATION__LANG = eINSTANCE.getTDocumentation_Lang();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDurationExprImpl <em>TDuration Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TDurationExprImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTDurationExpr()
		 * @generated
		 */
		EClass TDURATION_EXPR = eINSTANCE.getTDurationExpr();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl <em>TEscalation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TEscalationImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTEscalation()
		 * @generated
		 */
		EClass TESCALATION = eINSTANCE.getTEscalation();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESCALATION__CONDITION = eINSTANCE.getTEscalation_Condition();

		/**
		 * The meta object literal for the '<em><b>To Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESCALATION__TO_PARTS = eINSTANCE.getTEscalation_ToParts();

		/**
		 * The meta object literal for the '<em><b>Notification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESCALATION__NOTIFICATION = eINSTANCE.getTEscalation_Notification();

		/**
		 * The meta object literal for the '<em><b>Local Notification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESCALATION__LOCAL_NOTIFICATION = eINSTANCE.getTEscalation_LocalNotification();

		/**
		 * The meta object literal for the '<em><b>Reassignment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESCALATION__REASSIGNMENT = eINSTANCE.getTEscalation_Reassignment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESCALATION__NAME = eINSTANCE.getTEscalation_Name();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExpressionImpl <em>TExpression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExpressionImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExpression()
		 * @generated
		 */
		EClass TEXPRESSION = eINSTANCE.getTExpression();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXPRESSION__MIXED = eINSTANCE.getTExpression_Mixed();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXPRESSION__ANY = eINSTANCE.getTExpression_Any();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXPRESSION__EXPRESSION_LANGUAGE = eINSTANCE.getTExpression_ExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXPRESSION__ANY_ATTRIBUTE = eINSTANCE.getTExpression_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleElementsImpl <em>TExtensible Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleElementsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtensibleElements()
		 * @generated
		 */
		EClass TEXTENSIBLE_ELEMENTS = eINSTANCE.getTExtensibleElements();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTENSIBLE_ELEMENTS__DOCUMENTATION = eINSTANCE.getTExtensibleElements_Documentation();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_ELEMENTS__ANY = eINSTANCE.getTExtensibleElements_Any();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE = eINSTANCE.getTExtensibleElements_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl <em>TExtensible Mixed Content Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensibleMixedContentElementsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtensibleMixedContentElements()
		 * @generated
		 */
		EClass TEXTENSIBLE_MIXED_CONTENT_ELEMENTS = eINSTANCE.getTExtensibleMixedContentElements();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED = eINSTANCE.getTExtensibleMixedContentElements_Mixed();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION = eINSTANCE.getTExtensibleMixedContentElements_Documentation();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY = eINSTANCE.getTExtensibleMixedContentElements_Any();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE = eINSTANCE.getTExtensibleMixedContentElements_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionImpl <em>TExtension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtension()
		 * @generated
		 */
		EClass TEXTENSION = eINSTANCE.getTExtension();

		/**
		 * The meta object literal for the '<em><b>Must Understand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSION__MUST_UNDERSTAND = eINSTANCE.getTExtension_MustUnderstand();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSION__NAMESPACE = eINSTANCE.getTExtension_Namespace();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionsImpl <em>TExtensions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TExtensionsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTExtensions()
		 * @generated
		 */
		EClass TEXTENSIONS = eINSTANCE.getTExtensions();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTENSIONS__EXTENSION = eINSTANCE.getTExtensions_Extension();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl <em>TFrom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TFromImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTFrom()
		 * @generated
		 */
		EClass TFROM = eINSTANCE.getTFrom();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFROM__ARGUMENT = eINSTANCE.getTFrom_Argument();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFROM__LITERAL = eINSTANCE.getTFrom_Literal();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__EXPRESSION_LANGUAGE = eINSTANCE.getTFrom_ExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Logical People Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__LOGICAL_PEOPLE_GROUP = eINSTANCE.getTFrom_LogicalPeopleGroup();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGenericHumanRoleImpl <em>TGeneric Human Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGenericHumanRoleImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTGenericHumanRole()
		 * @generated
		 */
		EClass TGENERIC_HUMAN_ROLE = eINSTANCE.getTGenericHumanRole();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TGENERIC_HUMAN_ROLE__FROM = eINSTANCE.getTGenericHumanRole_From();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGrouplistImpl <em>TGrouplist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TGrouplistImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTGrouplist()
		 * @generated
		 */
		EClass TGROUPLIST = eINSTANCE.getTGrouplist();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TGROUPLIST__GROUP = eINSTANCE.getTGrouplist_Group();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl <em>THuman Interactions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.THumanInteractionsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTHumanInteractions()
		 * @generated
		 */
		EClass THUMAN_INTERACTIONS = eINSTANCE.getTHumanInteractions();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THUMAN_INTERACTIONS__EXTENSIONS = eINSTANCE.getTHumanInteractions_Extensions();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THUMAN_INTERACTIONS__IMPORT = eINSTANCE.getTHumanInteractions_Import();

		/**
		 * The meta object literal for the '<em><b>Logical People Groups</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS = eINSTANCE.getTHumanInteractions_LogicalPeopleGroups();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THUMAN_INTERACTIONS__TASKS = eINSTANCE.getTHumanInteractions_Tasks();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THUMAN_INTERACTIONS__NOTIFICATIONS = eINSTANCE.getTHumanInteractions_Notifications();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE = eINSTANCE.getTHumanInteractions_ExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Query Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THUMAN_INTERACTIONS__QUERY_LANGUAGE = eINSTANCE.getTHumanInteractions_QueryLanguage();

		/**
		 * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THUMAN_INTERACTIONS__TARGET_NAMESPACE = eINSTANCE.getTHumanInteractions_TargetNamespace();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TImportImpl <em>TImport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TImportImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTImport()
		 * @generated
		 */
		EClass TIMPORT = eINSTANCE.getTImport();

		/**
		 * The meta object literal for the '<em><b>Import Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMPORT__IMPORT_TYPE = eINSTANCE.getTImport_ImportType();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMPORT__LOCATION = eINSTANCE.getTImport_Location();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMPORT__NAMESPACE = eINSTANCE.getTImport_Namespace();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLiteralImpl <em>TLiteral</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLiteralImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLiteral()
		 * @generated
		 */
		EClass TLITERAL = eINSTANCE.getTLiteral();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLITERAL__MIXED = eINSTANCE.getTLiteral_Mixed();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLITERAL__ANY = eINSTANCE.getTLiteral_Any();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLITERAL__ANY_ATTRIBUTE = eINSTANCE.getTLiteral_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLocalNotificationImpl <em>TLocal Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLocalNotificationImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLocalNotification()
		 * @generated
		 */
		EClass TLOCAL_NOTIFICATION = eINSTANCE.getTLocalNotification();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLOCAL_NOTIFICATION__PRIORITY = eINSTANCE.getTLocalNotification_Priority();

		/**
		 * The meta object literal for the '<em><b>People Assignments</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS = eINSTANCE.getTLocalNotification_PeopleAssignments();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLOCAL_NOTIFICATION__REFERENCE = eINSTANCE.getTLocalNotification_Reference();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupImpl <em>TLogical People Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLogicalPeopleGroup()
		 * @generated
		 */
		EClass TLOGICAL_PEOPLE_GROUP = eINSTANCE.getTLogicalPeopleGroup();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLOGICAL_PEOPLE_GROUP__PARAMETER = eINSTANCE.getTLogicalPeopleGroup_Parameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLOGICAL_PEOPLE_GROUP__NAME = eINSTANCE.getTLogicalPeopleGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLOGICAL_PEOPLE_GROUP__REFERENCE = eINSTANCE.getTLogicalPeopleGroup_Reference();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupsImpl <em>TLogical People Groups</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TLogicalPeopleGroupsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTLogicalPeopleGroups()
		 * @generated
		 */
		EClass TLOGICAL_PEOPLE_GROUPS = eINSTANCE.getTLogicalPeopleGroups();

		/**
		 * The meta object literal for the '<em><b>Logical People Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP = eINSTANCE.getTLogicalPeopleGroups_LogicalPeopleGroup();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl <em>TNotification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTNotification()
		 * @generated
		 */
		EClass TNOTIFICATION = eINSTANCE.getTNotification();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TNOTIFICATION__INTERFACE = eINSTANCE.getTNotification_Interface();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TNOTIFICATION__PRIORITY = eINSTANCE.getTNotification_Priority();

		/**
		 * The meta object literal for the '<em><b>People Assignments</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TNOTIFICATION__PEOPLE_ASSIGNMENTS = eINSTANCE.getTNotification_PeopleAssignments();

		/**
		 * The meta object literal for the '<em><b>Presentation Elements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TNOTIFICATION__PRESENTATION_ELEMENTS = eINSTANCE.getTNotification_PresentationElements();

		/**
		 * The meta object literal for the '<em><b>Renderings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TNOTIFICATION__RENDERINGS = eINSTANCE.getTNotification_Renderings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNOTIFICATION__NAME = eINSTANCE.getTNotification_Name();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationInterfaceImpl <em>TNotification Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationInterfaceImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTNotificationInterface()
		 * @generated
		 */
		EClass TNOTIFICATION_INTERFACE = eINSTANCE.getTNotificationInterface();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNOTIFICATION_INTERFACE__OPERATION = eINSTANCE.getTNotificationInterface_Operation();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TNOTIFICATION_INTERFACE__PORT_TYPE = eINSTANCE.getTNotificationInterface_PortType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationsImpl <em>TNotifications</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TNotificationsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTNotifications()
		 * @generated
		 */
		EClass TNOTIFICATIONS = eINSTANCE.getTNotifications();

		/**
		 * The meta object literal for the '<em><b>Notification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TNOTIFICATIONS__NOTIFICATION = eINSTANCE.getTNotifications_Notification();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TOrganizationalEntityImpl <em>TOrganizational Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TOrganizationalEntityImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTOrganizationalEntity()
		 * @generated
		 */
		EClass TORGANIZATIONAL_ENTITY = eINSTANCE.getTOrganizationalEntity();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TORGANIZATIONAL_ENTITY__USERS = eINSTANCE.getTOrganizationalEntity_Users();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TORGANIZATIONAL_ENTITY__GROUPS = eINSTANCE.getTOrganizationalEntity_Groups();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TParameterImpl <em>TParameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TParameterImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTParameter()
		 * @generated
		 */
		EClass TPARAMETER = eINSTANCE.getTParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARAMETER__NAME = eINSTANCE.getTParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARAMETER__TYPE = eINSTANCE.getTParameter_Type();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPeopleAssignmentsImpl <em>TPeople Assignments</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPeopleAssignmentsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPeopleAssignments()
		 * @generated
		 */
		EClass TPEOPLE_ASSIGNMENTS = eINSTANCE.getTPeopleAssignments();

		/**
		 * The meta object literal for the '<em><b>Generic Human Role</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPEOPLE_ASSIGNMENTS__GENERIC_HUMAN_ROLE = eINSTANCE.getTPeopleAssignments_GenericHumanRole();

		/**
		 * The meta object literal for the '<em><b>Potential Owners</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPEOPLE_ASSIGNMENTS__POTENTIAL_OWNERS = eINSTANCE.getTPeopleAssignments_PotentialOwners();

		/**
		 * The meta object literal for the '<em><b>Excluded Owners</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPEOPLE_ASSIGNMENTS__EXCLUDED_OWNERS = eINSTANCE.getTPeopleAssignments_ExcludedOwners();

		/**
		 * The meta object literal for the '<em><b>Task Initiator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPEOPLE_ASSIGNMENTS__TASK_INITIATOR = eINSTANCE.getTPeopleAssignments_TaskInitiator();

		/**
		 * The meta object literal for the '<em><b>Task Stakeholders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPEOPLE_ASSIGNMENTS__TASK_STAKEHOLDERS = eINSTANCE.getTPeopleAssignments_TaskStakeholders();

		/**
		 * The meta object literal for the '<em><b>Business Administrators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPEOPLE_ASSIGNMENTS__BUSINESS_ADMINISTRATORS = eINSTANCE.getTPeopleAssignments_BusinessAdministrators();

		/**
		 * The meta object literal for the '<em><b>Recipients</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPEOPLE_ASSIGNMENTS__RECIPIENTS = eINSTANCE.getTPeopleAssignments_Recipients();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl <em>TPresentation Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationElementsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPresentationElements()
		 * @generated
		 */
		EClass TPRESENTATION_ELEMENTS = eINSTANCE.getTPresentationElements();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPRESENTATION_ELEMENTS__NAME = eINSTANCE.getTPresentationElements_Name();

		/**
		 * The meta object literal for the '<em><b>Presentation Parameters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS = eINSTANCE.getTPresentationElements_PresentationParameters();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPRESENTATION_ELEMENTS__SUBJECT = eINSTANCE.getTPresentationElements_Subject();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPRESENTATION_ELEMENTS__DESCRIPTION = eINSTANCE.getTPresentationElements_Description();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParameterImpl <em>TPresentation Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParameterImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPresentationParameter()
		 * @generated
		 */
		EClass TPRESENTATION_PARAMETER = eINSTANCE.getTPresentationParameter();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParametersImpl <em>TPresentation Parameters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPresentationParametersImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPresentationParameters()
		 * @generated
		 */
		EClass TPRESENTATION_PARAMETERS = eINSTANCE.getTPresentationParameters();

		/**
		 * The meta object literal for the '<em><b>Presentation Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPRESENTATION_PARAMETERS__PRESENTATION_PARAMETER = eINSTANCE.getTPresentationParameters_PresentationParameter();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPRESENTATION_PARAMETERS__EXPRESSION_LANGUAGE = eINSTANCE.getTPresentationParameters_ExpressionLanguage();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPriorityImpl <em>TPriority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TPriorityImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPriority()
		 * @generated
		 */
		EClass TPRIORITY = eINSTANCE.getTPriority();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TQueryImpl <em>TQuery</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TQueryImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTQuery()
		 * @generated
		 */
		EClass TQUERY = eINSTANCE.getTQuery();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TQUERY__MIXED = eINSTANCE.getTQuery_Mixed();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TQUERY__ANY = eINSTANCE.getTQuery_Any();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TQUERY__PART = eINSTANCE.getTQuery_Part();

		/**
		 * The meta object literal for the '<em><b>Query Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TQUERY__QUERY_LANGUAGE = eINSTANCE.getTQuery_QueryLanguage();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TQUERY__ANY_ATTRIBUTE = eINSTANCE.getTQuery_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TReassignmentImpl <em>TReassignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TReassignmentImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTReassignment()
		 * @generated
		 */
		EClass TREASSIGNMENT = eINSTANCE.getTReassignment();

		/**
		 * The meta object literal for the '<em><b>Potential Owners</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREASSIGNMENT__POTENTIAL_OWNERS = eINSTANCE.getTReassignment_PotentialOwners();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingImpl <em>TRendering</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTRendering()
		 * @generated
		 */
		EClass TRENDERING = eINSTANCE.getTRendering();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRENDERING__TYPE = eINSTANCE.getTRendering_Type();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingsImpl <em>TRenderings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TRenderingsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTRenderings()
		 * @generated
		 */
		EClass TRENDERINGS = eINSTANCE.getTRenderings();

		/**
		 * The meta object literal for the '<em><b>Rendering</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRENDERINGS__RENDERING = eINSTANCE.getTRenderings_Rendering();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskImpl <em>TTask</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTTask()
		 * @generated
		 */
		EClass TTASK = eINSTANCE.getTTask();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__INTERFACE = eINSTANCE.getTTask_Interface();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__PRIORITY = eINSTANCE.getTTask_Priority();

		/**
		 * The meta object literal for the '<em><b>People Assignments</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__PEOPLE_ASSIGNMENTS = eINSTANCE.getTTask_PeopleAssignments();

		/**
		 * The meta object literal for the '<em><b>Delegation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__DELEGATION = eINSTANCE.getTTask_Delegation();

		/**
		 * The meta object literal for the '<em><b>Presentation Elements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__PRESENTATION_ELEMENTS = eINSTANCE.getTTask_PresentationElements();

		/**
		 * The meta object literal for the '<em><b>Outcome</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__OUTCOME = eINSTANCE.getTTask_Outcome();

		/**
		 * The meta object literal for the '<em><b>Search By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__SEARCH_BY = eINSTANCE.getTTask_SearchBy();

		/**
		 * The meta object literal for the '<em><b>Renderings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__RENDERINGS = eINSTANCE.getTTask_Renderings();

		/**
		 * The meta object literal for the '<em><b>Deadlines</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASK__DEADLINES = eINSTANCE.getTTask_Deadlines();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTASK__NAME = eINSTANCE.getTTask_Name();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl <em>TTask Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTTaskInterface()
		 * @generated
		 */
		EClass TTASK_INTERFACE = eINSTANCE.getTTaskInterface();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTASK_INTERFACE__OPERATION = eINSTANCE.getTTaskInterface_Operation();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTASK_INTERFACE__PORT_TYPE = eINSTANCE.getTTaskInterface_PortType();

		/**
		 * The meta object literal for the '<em><b>Response Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTASK_INTERFACE__RESPONSE_OPERATION = eINSTANCE.getTTaskInterface_ResponseOperation();

		/**
		 * The meta object literal for the '<em><b>Response Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTASK_INTERFACE__RESPONSE_PORT_TYPE = eINSTANCE.getTTaskInterface_ResponsePortType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTasksImpl <em>TTasks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTasksImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTTasks()
		 * @generated
		 */
		EClass TTASKS = eINSTANCE.getTTasks();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTASKS__TASK = eINSTANCE.getTTasks_Task();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTextImpl <em>TText</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTextImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTText()
		 * @generated
		 */
		EClass TTEXT = eINSTANCE.getTText();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTEXT__LANG = eINSTANCE.getTText_Lang();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartImpl <em>TTo Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTToPart()
		 * @generated
		 */
		EClass TTO_PART = eINSTANCE.getTToPart();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTO_PART__EXPRESSION_LANGUAGE = eINSTANCE.getTToPart_ExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTO_PART__NAME = eINSTANCE.getTToPart_Name();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartsImpl <em>TTo Parts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TToPartsImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTToParts()
		 * @generated
		 */
		EClass TTO_PARTS = eINSTANCE.getTToParts();

		/**
		 * The meta object literal for the '<em><b>To Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTO_PARTS__TO_PART = eINSTANCE.getTToParts_ToPart();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TUserlistImpl <em>TUserlist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TUserlistImpl
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTUserlist()
		 * @generated
		 */
		EClass TUSERLIST = eINSTANCE.getTUserlist();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUSERLIST__USER = eINSTANCE.getTUserlist_User();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean <em>TBoolean</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTBoolean()
		 * @generated
		 */
		EEnum TBOOLEAN = eINSTANCE.getTBoolean();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees <em>TPotential Delegatees</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPotentialDelegatees()
		 * @generated
		 */
		EEnum TPOTENTIAL_DELEGATEES = eINSTANCE.getTPotentialDelegatees();

		/**
		 * The meta object literal for the '<em>TBoolean Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTBooleanObject()
		 * @generated
		 */
		EDataType TBOOLEAN_OBJECT = eINSTANCE.getTBooleanObject();

		/**
		 * The meta object literal for the '<em>TGroup</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTGroup()
		 * @generated
		 */
		EDataType TGROUP = eINSTANCE.getTGroup();

		/**
		 * The meta object literal for the '<em>TPotential Delegatees Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTPotentialDelegateesObject()
		 * @generated
		 */
		EDataType TPOTENTIAL_DELEGATEES_OBJECT = eINSTANCE.getTPotentialDelegateesObject();

		/**
		 * The meta object literal for the '<em>TUser</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.impl.HTPackageImpl#getTUser()
		 * @generated
		 */
		EDataType TUSER = eINSTANCE.getTUser();

	}

} //HTPackage
