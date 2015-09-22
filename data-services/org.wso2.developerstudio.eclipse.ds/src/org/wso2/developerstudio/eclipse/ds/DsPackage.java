/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

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
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.ds.DsFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface DsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "ds";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://org/wso2/developerstudio/eclipse/ds";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ds";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	DsPackage eINSTANCE = org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl.init();

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getAttributeMapping()
     * @generated
     */
	int ATTRIBUTE_MAPPING = 0;

	/**
     * The feature id for the '<em><b>Column</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_MAPPING__COLUMN = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_MAPPING__NAME = 1;

	/**
     * The feature id for the '<em><b>Required Roles</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_MAPPING__REQUIRED_ROLES = 2;

	/**
     * The feature id for the '<em><b>Xsd Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_MAPPING__XSD_TYPE = 3;

	/**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_MAPPING__OPTIONAL = 4;

	/**
     * The number of structural features of the '<em>Attribute Mapping</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ATTRIBUTE_MAPPING_FEATURE_COUNT = 5;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.CallQueryImpl <em>Call Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.CallQueryImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getCallQuery()
     * @generated
     */
	int CALL_QUERY = 1;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_QUERY__MIXED = 0;

	/**
     * The feature id for the '<em><b>With Param</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_QUERY__WITH_PARAM = 1;

	/**
     * The feature id for the '<em><b>Href</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_QUERY__HREF = 2;

	/**
     * The number of structural features of the '<em>Call Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_QUERY_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.CallQueryListImpl <em>Call Query List</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.CallQueryListImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getCallQueryList()
     * @generated
     */
	int CALL_QUERY_LIST = 2;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_QUERY_LIST__MIXED = 0;

	/**
     * The feature id for the '<em><b>Call Query</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_QUERY_LIST__CALL_QUERY = 1;

	/**
     * The number of structural features of the '<em>Call Query List</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CALL_QUERY_LIST_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ConfigurationPropertyImpl <em>Configuration Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.ConfigurationPropertyImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getConfigurationProperty()
     * @generated
     */
	int CONFIGURATION_PROPERTY = 3;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_PROPERTY__VALUE = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_PROPERTY__NAME = 1;

	/**
     * The number of structural features of the '<em>Configuration Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONFIGURATION_PROPERTY_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.CustomValidatorImpl <em>Custom Validator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.CustomValidatorImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getCustomValidator()
     * @generated
     */
	int CUSTOM_VALIDATOR = 4;

	/**
     * The feature id for the '<em><b>Class</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CUSTOM_VALIDATOR__CLASS = 0;

	/**
     * The number of structural features of the '<em>Custom Validator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CUSTOM_VALIDATOR_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DataServiceImpl <em>Data Service</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.DataServiceImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDataService()
     * @generated
     */
	int DATA_SERVICE = 5;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__MIXED = 0;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__DESCRIPTION = 1;

	/**
     * The feature id for the '<em><b>Config</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__CONFIG = 2;

	/**
     * The feature id for the '<em><b>Query</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__QUERY = 3;

	/**
     * The feature id for the '<em><b>Event Trigger</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__EVENT_TRIGGER = 4;

	/**
     * The feature id for the '<em><b>Operation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__OPERATION = 5;

	/**
     * The feature id for the '<em><b>Resource</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__RESOURCE = 6;

	/**
     * The feature id for the '<em><b>Base URI</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__BASE_URI = 7;

	/**
     * The feature id for the '<em><b>Enable Batch Requests</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__ENABLE_BATCH_REQUESTS = 8;

	/**
     * The feature id for the '<em><b>Enable Boxcarring</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__ENABLE_BOXCARRING = 9;

	/**
     * The feature id for the '<em><b>Enable DTP</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__ENABLE_DTP = 10;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__NAME = 11;

	/**
     * The feature id for the '<em><b>Service Group</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__SERVICE_GROUP = 12;

	/**
     * The feature id for the '<em><b>Service Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__SERVICE_NAMESPACE = 13;

	/**
     * The feature id for the '<em><b>Service Status</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__SERVICE_STATUS = 14;

	/**
     * The feature id for the '<em><b>Disable Streaming</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__DISABLE_STREAMING = 15;

	/**
     * The feature id for the '<em><b>Enable Sec</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__ENABLE_SEC = 16;

	/**
     * The feature id for the '<em><b>Policy</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__POLICY = 17;

	/**
     * The feature id for the '<em><b>Transports</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__TRANSPORTS = 18;

	/**
     * The feature id for the '<em><b>Feature Allow Roles</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE__FEATURE_ALLOW_ROLES = 19;

	/**
     * The number of structural features of the '<em>Data Service</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE_FEATURE_COUNT = 20;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DataSourceConfigurationImpl <em>Data Source Configuration</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.DataSourceConfigurationImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDataSourceConfiguration()
     * @generated
     */
	int DATA_SOURCE_CONFIGURATION = 6;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SOURCE_CONFIGURATION__MIXED = 0;

	/**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SOURCE_CONFIGURATION__PROPERTY = 1;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SOURCE_CONFIGURATION__ID = 2;

	/**
     * The number of structural features of the '<em>Data Source Configuration</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SOURCE_CONFIGURATION_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DescriptionImpl <em>Description</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.DescriptionImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDescription()
     * @generated
     */
	int DESCRIPTION = 7;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DESCRIPTION__VALUE = 0;

	/**
     * The number of structural features of the '<em>Description</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DESCRIPTION_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDocumentRoot()
     * @generated
     */
	int DOCUMENT_ROOT = 8;

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
     * The feature id for the '<em><b>Call Query</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__CALL_QUERY = 3;

	/**
     * The feature id for the '<em><b>Data</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__DATA = 4;

	/**
     * The feature id for the '<em><b>Hasheader</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__HASHEADER = 5;

	/**
     * The feature id for the '<em><b>Maxrowcount</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__MAXROWCOUNT = 6;

	/**
     * The feature id for the '<em><b>Property</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__PROPERTY = 7;

	/**
     * The feature id for the '<em><b>Sql</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__SQL = 8;

	/**
     * The feature id for the '<em><b>Startingrow</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT__STARTINGROW = 9;

	/**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOCUMENT_ROOT_FEATURE_COUNT = 10;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DoubleRangeValidatorImpl <em>Double Range Validator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.DoubleRangeValidatorImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDoubleRangeValidator()
     * @generated
     */
	int DOUBLE_RANGE_VALIDATOR = 9;

	/**
     * The feature id for the '<em><b>Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOUBLE_RANGE_VALIDATOR__MAXIMUM = 0;

	/**
     * The feature id for the '<em><b>Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOUBLE_RANGE_VALIDATOR__MINIMUM = 1;

	/**
     * The number of structural features of the '<em>Double Range Validator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DOUBLE_RANGE_VALIDATOR_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ElementMappingImpl <em>Element Mapping</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.ElementMappingImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getElementMapping()
     * @generated
     */
	int ELEMENT_MAPPING = 10;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__MIXED = 0;

	/**
     * The feature id for the '<em><b>Column</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__COLUMN = 1;

	/**
     * The feature id for the '<em><b>Export</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__EXPORT = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__NAME = 3;

	/**
     * The feature id for the '<em><b>Required Roles</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__REQUIRED_ROLES = 4;

	/**
     * The feature id for the '<em><b>Export Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__EXPORT_TYPE = 5;

	/**
     * The feature id for the '<em><b>Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__NAMESPACE = 6;

	/**
     * The feature id for the '<em><b>Xsd Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__XSD_TYPE = 7;

	/**
     * The feature id for the '<em><b>Element</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__ELEMENT = 8;

	/**
     * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__ATTRIBUTE = 9;

	/**
     * The feature id for the '<em><b>Call Query</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__CALL_QUERY = 10;

	/**
     * The feature id for the '<em><b>Is Complex Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__IS_COMPLEX_TYPE = 11;

	/**
     * The feature id for the '<em><b>Query Param</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__QUERY_PARAM = 12;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__VALUE = 13;

	/**
     * The feature id for the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__OPTIONAL = 14;

	/**
     * The feature id for the '<em><b>Array Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING__ARRAY_NAME = 15;

	/**
     * The number of structural features of the '<em>Element Mapping</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_MAPPING_FEATURE_COUNT = 16;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.EventSubscriptionListImpl <em>Event Subscription List</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.EventSubscriptionListImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getEventSubscriptionList()
     * @generated
     */
	int EVENT_SUBSCRIPTION_LIST = 11;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_SUBSCRIPTION_LIST__MIXED = 0;

	/**
     * The feature id for the '<em><b>Subscription</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_SUBSCRIPTION_LIST__SUBSCRIPTION = 1;

	/**
     * The number of structural features of the '<em>Event Subscription List</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_SUBSCRIPTION_LIST_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl <em>Event Trigger</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getEventTrigger()
     * @generated
     */
	int EVENT_TRIGGER = 12;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_TRIGGER__MIXED = 0;

	/**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_TRIGGER__EXPRESSION = 1;

	/**
     * The feature id for the '<em><b>Target Topic</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_TRIGGER__TARGET_TOPIC = 2;

	/**
     * The feature id for the '<em><b>Subscriptions</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_TRIGGER__SUBSCRIPTIONS = 3;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_TRIGGER__ID = 4;

	/**
     * The feature id for the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_TRIGGER__LANGUAGE = 5;

	/**
     * The number of structural features of the '<em>Event Trigger</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_TRIGGER_FEATURE_COUNT = 6;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl <em>Excel Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getExcelQuery()
     * @generated
     */
	int EXCEL_QUERY = 13;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXCEL_QUERY__MIXED = 0;

	/**
     * The feature id for the '<em><b>Workbookname</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXCEL_QUERY__WORKBOOKNAME = 1;

	/**
     * The feature id for the '<em><b>Hasheader</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXCEL_QUERY__HASHEADER = 2;

	/**
     * The feature id for the '<em><b>Startingrow</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXCEL_QUERY__STARTINGROW = 3;

	/**
     * The feature id for the '<em><b>Maxrowcount</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXCEL_QUERY__MAXROWCOUNT = 4;

	/**
     * The number of structural features of the '<em>Excel Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXCEL_QUERY_FEATURE_COUNT = 5;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.ExpressionImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getExpression()
     * @generated
     */
	int EXPRESSION = 14;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__VALUE = 0;

	/**
     * The number of structural features of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl <em>GSpread Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getGSpreadQuery()
     * @generated
     */
	int GSPREAD_QUERY = 15;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GSPREAD_QUERY__MIXED = 0;

	/**
     * The feature id for the '<em><b>Worksheetnumber</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GSPREAD_QUERY__WORKSHEETNUMBER = 1;

	/**
     * The feature id for the '<em><b>Startingrow</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GSPREAD_QUERY__STARTINGROW = 2;

	/**
     * The feature id for the '<em><b>Maxrowcount</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GSPREAD_QUERY__MAXROWCOUNT = 3;

	/**
     * The feature id for the '<em><b>Hasheader</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GSPREAD_QUERY__HASHEADER = 4;

	/**
     * The number of structural features of the '<em>GSpread Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GSPREAD_QUERY_FEATURE_COUNT = 5;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.HasHeaderImpl <em>Has Header</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.HasHeaderImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getHasHeader()
     * @generated
     */
	int HAS_HEADER = 16;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HAS_HEADER__VALUE = 0;

	/**
     * The number of structural features of the '<em>Has Header</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HAS_HEADER_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.LengthValidatorImpl <em>Length Validator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.LengthValidatorImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getLengthValidator()
     * @generated
     */
	int LENGTH_VALIDATOR = 17;

	/**
     * The feature id for the '<em><b>Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LENGTH_VALIDATOR__MAXIMUM = 0;

	/**
     * The feature id for the '<em><b>Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LENGTH_VALIDATOR__MINIMUM = 1;

	/**
     * The number of structural features of the '<em>Length Validator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LENGTH_VALIDATOR_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.LongRangeValidatorImpl <em>Long Range Validator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.LongRangeValidatorImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getLongRangeValidator()
     * @generated
     */
	int LONG_RANGE_VALIDATOR = 18;

	/**
     * The feature id for the '<em><b>Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LONG_RANGE_VALIDATOR__MAXIMUM = 0;

	/**
     * The feature id for the '<em><b>Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LONG_RANGE_VALIDATOR__MINIMUM = 1;

	/**
     * The number of structural features of the '<em>Long Range Validator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LONG_RANGE_VALIDATOR_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.MaxRowCountImpl <em>Max Row Count</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.MaxRowCountImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getMaxRowCount()
     * @generated
     */
	int MAX_ROW_COUNT = 19;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAX_ROW_COUNT__VALUE = 0;

	/**
     * The number of structural features of the '<em>Max Row Count</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAX_ROW_COUNT_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.OperationImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getOperation()
     * @generated
     */
	int OPERATION = 20;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION__MIXED = 0;

	/**
     * The feature id for the '<em><b>Call Query</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION__CALL_QUERY = 1;

	/**
     * The feature id for the '<em><b>Call Query Group</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION__CALL_QUERY_GROUP = 2;

	/**
     * The feature id for the '<em><b>Disable Streaming</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION__DISABLE_STREAMING = 3;

	/**
     * The feature id for the '<em><b>Return Request Status</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION__RETURN_REQUEST_STATUS = 4;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION__NAME = 5;

	/**
     * The number of structural features of the '<em>Operation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATION_FEATURE_COUNT = 6;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ParameterMappingImpl <em>Parameter Mapping</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.ParameterMappingImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getParameterMapping()
     * @generated
     */
	int PARAMETER_MAPPING = 21;

	/**
     * The feature id for the '<em><b>Column</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER_MAPPING__COLUMN = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER_MAPPING__NAME = 1;

	/**
     * The feature id for the '<em><b>Query Param</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER_MAPPING__QUERY_PARAM = 2;

	/**
     * The number of structural features of the '<em>Parameter Mapping</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER_MAPPING_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.PatternValidatorImpl <em>Pattern Validator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.PatternValidatorImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getPatternValidator()
     * @generated
     */
	int PATTERN_VALIDATOR = 22;

	/**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PATTERN_VALIDATOR__PATTERN = 0;

	/**
     * The number of structural features of the '<em>Pattern Validator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PATTERN_VALIDATOR_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryImpl <em>Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.QueryImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQuery()
     * @generated
     */
	int QUERY = 23;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__MIXED = 0;

	/**
     * The feature id for the '<em><b>Expression</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__EXPRESSION = 1;

	/**
     * The feature id for the '<em><b>Sql</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__SQL = 2;

	/**
     * The feature id for the '<em><b>Sparql</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__SPARQL = 3;

	/**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__PROPERTIES = 4;

	/**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__RESULT = 5;

	/**
     * The feature id for the '<em><b>Excel</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__EXCEL = 6;

	/**
     * The feature id for the '<em><b>Gspread</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__GSPREAD = 7;

	/**
     * The feature id for the '<em><b>Param</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__PARAM = 8;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__ID = 9;

	/**
     * The feature id for the '<em><b>Input Event Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__INPUT_EVENT_TRIGGER = 10;

	/**
     * The feature id for the '<em><b>Output Event Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__OUTPUT_EVENT_TRIGGER = 11;

	/**
     * The feature id for the '<em><b>Return Generated Keys</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__RETURN_GENERATED_KEYS = 12;

	/**
     * The feature id for the '<em><b>Use Config</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__USE_CONFIG = 13;

	/**
     * The feature id for the '<em><b>Key Columns</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY__KEY_COLUMNS = 14;

	/**
     * The number of structural features of the '<em>Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_FEATURE_COUNT = 15;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryParameterImpl <em>Query Parameter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.QueryParameterImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryParameter()
     * @generated
     */
	int QUERY_PARAMETER = 24;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__MIXED = 0;

	/**
     * The feature id for the '<em><b>Validate Long Range</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__VALIDATE_LONG_RANGE = 1;

	/**
     * The feature id for the '<em><b>Validate Double Range</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE = 2;

	/**
     * The feature id for the '<em><b>Validate Length</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__VALIDATE_LENGTH = 3;

	/**
     * The feature id for the '<em><b>Validate Pattern</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__VALIDATE_PATTERN = 4;

	/**
     * The feature id for the '<em><b>Validate Custom</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__VALIDATE_CUSTOM = 5;

	/**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__DEFAULT_VALUE = 6;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__NAME = 7;

	/**
     * The feature id for the '<em><b>Ordinal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__ORDINAL = 8;

	/**
     * The feature id for the '<em><b>Param Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__PARAM_TYPE = 9;

	/**
     * The feature id for the '<em><b>Sql Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__SQL_TYPE = 10;

	/**
     * The feature id for the '<em><b>Struct Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__STRUCT_TYPE = 11;

	/**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER__TYPE = 12;

	/**
     * The number of structural features of the '<em>Query Parameter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PARAMETER_FEATURE_COUNT = 13;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyImpl <em>Query Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryProperty()
     * @generated
     */
	int QUERY_PROPERTY = 25;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PROPERTY__VALUE = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PROPERTY__NAME = 1;

	/**
     * The number of structural features of the '<em>Query Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PROPERTY_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyListImpl <em>Query Property List</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyListImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryPropertyList()
     * @generated
     */
	int QUERY_PROPERTY_LIST = 26;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PROPERTY_LIST__MIXED = 0;

	/**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PROPERTY_LIST__PROPERTY = 1;

	/**
     * The number of structural features of the '<em>Query Property List</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_PROPERTY_LIST_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ResourceImpl <em>Resource</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.ResourceImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getResource()
     * @generated
     */
	int RESOURCE = 27;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESOURCE__MIXED = 0;

	/**
     * The feature id for the '<em><b>Call Query</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESOURCE__CALL_QUERY = 1;

	/**
     * The feature id for the '<em><b>Method</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESOURCE__METHOD = 2;

	/**
     * The feature id for the '<em><b>Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESOURCE__PATH = 3;

	/**
     * The feature id for the '<em><b>Return Request Status</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESOURCE__RETURN_REQUEST_STATUS = 4;

	/**
     * The number of structural features of the '<em>Resource</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESOURCE_FEATURE_COUNT = 5;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl <em>Result Mapping</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getResultMapping()
     * @generated
     */
	int RESULT_MAPPING = 28;

	/**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__MIXED = 0;

	/**
     * The feature id for the '<em><b>Element</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__ELEMENT = 1;

	/**
     * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__ATTRIBUTE = 2;

	/**
     * The feature id for the '<em><b>Call Query</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__CALL_QUERY = 3;

	/**
     * The feature id for the '<em><b>Default Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__DEFAULT_NAMESPACE = 4;

	/**
     * The feature id for the '<em><b>Element Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__ELEMENT_NAME = 5;

	/**
     * The feature id for the '<em><b>Row Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__ROW_NAME = 6;

	/**
     * The feature id for the '<em><b>Use Column Numbers</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__USE_COLUMN_NUMBERS = 7;

	/**
     * The feature id for the '<em><b>Escape Non Printable Char</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR = 8;

	/**
     * The feature id for the '<em><b>Xslt Path</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING__XSLT_PATH = 9;

	/**
     * The feature id for the '<em><b>Output Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_MAPPING__OUTPUT_TYPE = 10;

    /**
     * The number of structural features of the '<em>Result Mapping</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RESULT_MAPPING_FEATURE_COUNT = 11;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.SparqlImpl <em>Sparql</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.SparqlImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getSparql()
     * @generated
     */
	int SPARQL = 29;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SPARQL__VALUE = 0;

	/**
     * The number of structural features of the '<em>Sparql</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SPARQL_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.SqlImpl <em>Sql</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.SqlImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getSql()
     * @generated
     */
	int SQL = 30;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SQL__VALUE = 0;

	/**
     * The feature id for the '<em><b>Dialect</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SQL__DIALECT = 1;

	/**
     * The number of structural features of the '<em>Sql</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SQL_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryExpressionImpl <em>Query Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.QueryExpressionImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryExpression()
     * @generated
     */
	int QUERY_EXPRESSION = 31;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_EXPRESSION__VALUE = 0;

	/**
     * The number of structural features of the '<em>Query Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_EXPRESSION_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.StartingRowImpl <em>Starting Row</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.StartingRowImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getStartingRow()
     * @generated
     */
	int STARTING_ROW = 32;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STARTING_ROW__VALUE = 0;

	/**
     * The number of structural features of the '<em>Starting Row</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STARTING_ROW_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.SubscriptionImpl <em>Subscription</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.SubscriptionImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getSubscription()
     * @generated
     */
	int SUBSCRIPTION = 33;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION__VALUE = 0;

	/**
     * The number of structural features of the '<em>Subscription</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.TargetTopicImpl <em>Target Topic</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.TargetTopicImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getTargetTopic()
     * @generated
     */
	int TARGET_TOPIC = 34;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TARGET_TOPIC__VALUE = 0;

	/**
     * The number of structural features of the '<em>Target Topic</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TARGET_TOPIC_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.WorkBookNameImpl <em>Work Book Name</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.WorkBookNameImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getWorkBookName()
     * @generated
     */
	int WORK_BOOK_NAME = 35;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WORK_BOOK_NAME__VALUE = 0;

	/**
     * The number of structural features of the '<em>Work Book Name</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WORK_BOOK_NAME_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.WorkSheetNumberImpl <em>Work Sheet Number</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.WorkSheetNumberImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getWorkSheetNumber()
     * @generated
     */
	int WORK_SHEET_NUMBER = 36;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WORK_SHEET_NUMBER__VALUE = 0;

	/**
     * The number of structural features of the '<em>Work Sheet Number</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WORK_SHEET_NUMBER_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.PolicyImpl <em>Policy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.PolicyImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getPolicy()
     * @generated
     */
	int POLICY = 37;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POLICY__KEY = 0;

	/**
     * The number of structural features of the '<em>Policy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int POLICY_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DataServiceParameterImpl <em>Data Service Parameter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.DataServiceParameterImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDataServiceParameter()
     * @generated
     */
	int DATA_SERVICE_PARAMETER = 38;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE_PARAMETER__NAME = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE_PARAMETER__VALUE = 1;

	/**
     * The number of structural features of the '<em>Data Service Parameter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_SERVICE_PARAMETER_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.impl.RegistryKeyPropertyImpl <em>Registry Key Property</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.impl.RegistryKeyPropertyImpl
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getRegistryKeyProperty()
     * @generated
     */
	int REGISTRY_KEY_PROPERTY = 39;

	/**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REGISTRY_KEY_PROPERTY__KEY = 0;

	/**
     * The number of structural features of the '<em>Registry Key Property</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REGISTRY_KEY_PROPERTY_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link org.wso2.developerstudio.eclipse.ds.ServiceStatus <em>Service Status</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.ServiceStatus
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getServiceStatus()
     * @generated
     */
	int SERVICE_STATUS = 40;

	/**
     * The meta object id for the '<em>Service Status Object</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.wso2.developerstudio.eclipse.ds.ServiceStatus
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getServiceStatusObject()
     * @generated
     */
	int SERVICE_STATUS_OBJECT = 41;

	/**
     * The meta object id for the '<em>Map</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see java.util.Map
     * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getMap()
     * @generated
     */
	int MAP = 42;

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping <em>Attribute Mapping</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Mapping</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.AttributeMapping
     * @generated
     */
	EClass getAttributeMapping();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getColumn <em>Column</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.AttributeMapping#getColumn()
     * @see #getAttributeMapping()
     * @generated
     */
	EAttribute getAttributeMapping_Column();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.AttributeMapping#getName()
     * @see #getAttributeMapping()
     * @generated
     */
	EAttribute getAttributeMapping_Name();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getRequiredRoles <em>Required Roles</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Required Roles</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.AttributeMapping#getRequiredRoles()
     * @see #getAttributeMapping()
     * @generated
     */
	EAttribute getAttributeMapping_RequiredRoles();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#getXsdType <em>Xsd Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xsd Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.AttributeMapping#getXsdType()
     * @see #getAttributeMapping()
     * @generated
     */
	EAttribute getAttributeMapping_XsdType();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.AttributeMapping#isOptional <em>Optional</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Optional</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.AttributeMapping#isOptional()
     * @see #getAttributeMapping()
     * @generated
     */
	EAttribute getAttributeMapping_Optional();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.CallQuery <em>Call Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CallQuery
     * @generated
     */
	EClass getCallQuery();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.CallQuery#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CallQuery#getMixed()
     * @see #getCallQuery()
     * @generated
     */
	EAttribute getCallQuery_Mixed();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.CallQuery#getWithParam <em>With Param</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>With Param</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CallQuery#getWithParam()
     * @see #getCallQuery()
     * @generated
     */
	EReference getCallQuery_WithParam();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.CallQuery#getHref <em>Href</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Href</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CallQuery#getHref()
     * @see #getCallQuery()
     * @generated
     */
	EAttribute getCallQuery_Href();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.CallQueryList <em>Call Query List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call Query List</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CallQueryList
     * @generated
     */
	EClass getCallQueryList();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.CallQueryList#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CallQueryList#getMixed()
     * @see #getCallQueryList()
     * @generated
     */
	EAttribute getCallQueryList_Mixed();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.CallQueryList#getCallQuery <em>Call Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Call Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CallQueryList#getCallQuery()
     * @see #getCallQueryList()
     * @generated
     */
	EReference getCallQueryList_CallQuery();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.ConfigurationProperty <em>Configuration Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration Property</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ConfigurationProperty
     * @generated
     */
	EClass getConfigurationProperty();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ConfigurationProperty#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ConfigurationProperty#getValue()
     * @see #getConfigurationProperty()
     * @generated
     */
	EAttribute getConfigurationProperty_Value();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ConfigurationProperty#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ConfigurationProperty#getName()
     * @see #getConfigurationProperty()
     * @generated
     */
	EAttribute getConfigurationProperty_Name();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.CustomValidator <em>Custom Validator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Custom Validator</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CustomValidator
     * @generated
     */
	EClass getCustomValidator();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.CustomValidator#getClass_ <em>Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.CustomValidator#getClass_()
     * @see #getCustomValidator()
     * @generated
     */
	EAttribute getCustomValidator_Class();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.DataService <em>Data Service</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Service</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService
     * @generated
     */
	EClass getDataService();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.DataService#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getMixed()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_Mixed();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DataService#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Description</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getDescription()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_Description();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.DataService#getConfig <em>Config</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Config</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getConfig()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_Config();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.DataService#getQuery <em>Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getQuery()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_Query();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.DataService#getEventTrigger <em>Event Trigger</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Event Trigger</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getEventTrigger()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_EventTrigger();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.DataService#getOperation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Operation</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getOperation()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_Operation();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.DataService#getResource <em>Resource</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Resource</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getResource()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_Resource();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#getBaseURI <em>Base URI</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base URI</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getBaseURI()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_BaseURI();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#isEnableBatchRequests <em>Enable Batch Requests</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enable Batch Requests</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#isEnableBatchRequests()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_EnableBatchRequests();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#isEnableBoxcarring <em>Enable Boxcarring</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enable Boxcarring</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#isEnableBoxcarring()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_EnableBoxcarring();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#isEnableDTP <em>Enable DTP</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enable DTP</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#isEnableDTP()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_EnableDTP();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getName()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_Name();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#getServiceGroup <em>Service Group</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Service Group</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getServiceGroup()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_ServiceGroup();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#getServiceNamespace <em>Service Namespace</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Service Namespace</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getServiceNamespace()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_ServiceNamespace();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#getServiceStatus <em>Service Status</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Service Status</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getServiceStatus()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_ServiceStatus();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#isDisableStreaming <em>Disable Streaming</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Disable Streaming</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#isDisableStreaming()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_DisableStreaming();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#isEnableSec <em>Enable Sec</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enable Sec</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#isEnableSec()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_EnableSec();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DataService#getPolicy <em>Policy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Policy</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getPolicy()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_Policy();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataService#getTransports <em>Transports</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Transports</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getTransports()
     * @see #getDataService()
     * @generated
     */
	EAttribute getDataService_Transports();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DataService#getFeatureAllowRoles <em>Feature Allow Roles</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Feature Allow Roles</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataService#getFeatureAllowRoles()
     * @see #getDataService()
     * @generated
     */
	EReference getDataService_FeatureAllowRoles();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration <em>Data Source Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Source Configuration</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration
     * @generated
     */
	EClass getDataSourceConfiguration();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration#getMixed()
     * @see #getDataSourceConfiguration()
     * @generated
     */
	EAttribute getDataSourceConfiguration_Mixed();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration#getProperty()
     * @see #getDataSourceConfiguration()
     * @generated
     */
	EReference getDataSourceConfiguration_Property();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration#getId()
     * @see #getDataSourceConfiguration()
     * @generated
     */
	EAttribute getDataSourceConfiguration_Id();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Description <em>Description</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Description</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Description
     * @generated
     */
	EClass getDescription();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Description#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Description#getValue()
     * @see #getDescription()
     * @generated
     */
	EAttribute getDescription_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot
     * @generated
     */
	EClass getDocumentRoot();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
	EAttribute getDocumentRoot_Mixed();

	/**
     * Returns the meta object for the map '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
     * Returns the meta object for the map '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getCallQuery <em>Call Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Call Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getCallQuery()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_CallQuery();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getData <em>Data</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Data</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getData()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_Data();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getHasheader <em>Hasheader</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Hasheader</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getHasheader()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_Hasheader();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getMaxrowcount <em>Maxrowcount</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Maxrowcount</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getMaxrowcount()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_Maxrowcount();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Property</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getProperty()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_Property();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getSql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Sql</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getSql()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_Sql();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.DocumentRoot#getStartingrow <em>Startingrow</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Startingrow</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DocumentRoot#getStartingrow()
     * @see #getDocumentRoot()
     * @generated
     */
	EReference getDocumentRoot_Startingrow();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator <em>Double Range Validator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Double Range Validator</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator
     * @generated
     */
	EClass getDoubleRangeValidator();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMaximum <em>Maximum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMaximum()
     * @see #getDoubleRangeValidator()
     * @generated
     */
	EAttribute getDoubleRangeValidator_Maximum();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMinimum <em>Minimum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Minimum</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator#getMinimum()
     * @see #getDoubleRangeValidator()
     * @generated
     */
	EAttribute getDoubleRangeValidator_Minimum();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping <em>Element Mapping</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element Mapping</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping
     * @generated
     */
	EClass getElementMapping();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getMixed()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_Mixed();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getColumn <em>Column</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getColumn()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_Column();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getExport <em>Export</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Export</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getExport()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_Export();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getName()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_Name();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getRequiredRoles <em>Required Roles</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Required Roles</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getRequiredRoles()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_RequiredRoles();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getExportType <em>Export Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Export Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getExportType()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_ExportType();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getNamespace <em>Namespace</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Namespace</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getNamespace()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_Namespace();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getXsdType <em>Xsd Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xsd Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getXsdType()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_XsdType();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Element</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getElement()
     * @see #getElementMapping()
     * @generated
     */
	EReference getElementMapping_Element();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Attribute</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getAttribute()
     * @see #getElementMapping()
     * @generated
     */
	EReference getElementMapping_Attribute();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getCallQuery <em>Call Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Call Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getCallQuery()
     * @see #getElementMapping()
     * @generated
     */
	EReference getElementMapping_CallQuery();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#isIsComplexType <em>Is Complex Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Complex Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#isIsComplexType()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_IsComplexType();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getQueryParam <em>Query Param</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Query Param</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getQueryParam()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_QueryParam();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getValue()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_Value();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#isOptional <em>Optional</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Optional</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#isOptional()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_Optional();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ElementMapping#getArrayName <em>Array Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Array Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ElementMapping#getArrayName()
     * @see #getElementMapping()
     * @generated
     */
	EAttribute getElementMapping_ArrayName();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.EventSubscriptionList <em>Event Subscription List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Subscription List</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventSubscriptionList
     * @generated
     */
	EClass getEventSubscriptionList();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.EventSubscriptionList#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventSubscriptionList#getMixed()
     * @see #getEventSubscriptionList()
     * @generated
     */
	EAttribute getEventSubscriptionList_Mixed();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.EventSubscriptionList#getSubscription <em>Subscription</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Subscription</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventSubscriptionList#getSubscription()
     * @see #getEventSubscriptionList()
     * @generated
     */
	EReference getEventSubscriptionList_Subscription();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.EventTrigger <em>Event Trigger</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Trigger</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventTrigger
     * @generated
     */
	EClass getEventTrigger();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.EventTrigger#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventTrigger#getMixed()
     * @see #getEventTrigger()
     * @generated
     */
	EAttribute getEventTrigger_Mixed();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.EventTrigger#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventTrigger#getExpression()
     * @see #getEventTrigger()
     * @generated
     */
	EReference getEventTrigger_Expression();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.EventTrigger#getTargetTopic <em>Target Topic</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Target Topic</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventTrigger#getTargetTopic()
     * @see #getEventTrigger()
     * @generated
     */
	EReference getEventTrigger_TargetTopic();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.EventTrigger#getSubscriptions <em>Subscriptions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Subscriptions</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventTrigger#getSubscriptions()
     * @see #getEventTrigger()
     * @generated
     */
	EReference getEventTrigger_Subscriptions();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.EventTrigger#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventTrigger#getId()
     * @see #getEventTrigger()
     * @generated
     */
	EAttribute getEventTrigger_Id();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.EventTrigger#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Language</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.EventTrigger#getLanguage()
     * @see #getEventTrigger()
     * @generated
     */
	EAttribute getEventTrigger_Language();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery <em>Excel Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Excel Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ExcelQuery
     * @generated
     */
	EClass getExcelQuery();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ExcelQuery#getMixed()
     * @see #getExcelQuery()
     * @generated
     */
	EAttribute getExcelQuery_Mixed();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getWorkbookname <em>Workbookname</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Workbookname</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ExcelQuery#getWorkbookname()
     * @see #getExcelQuery()
     * @generated
     */
	EReference getExcelQuery_Workbookname();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getHasheader <em>Hasheader</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Hasheader</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ExcelQuery#getHasheader()
     * @see #getExcelQuery()
     * @generated
     */
	EReference getExcelQuery_Hasheader();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getStartingrow <em>Startingrow</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Startingrow</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ExcelQuery#getStartingrow()
     * @see #getExcelQuery()
     * @generated
     */
	EReference getExcelQuery_Startingrow();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.ExcelQuery#getMaxrowcount <em>Maxrowcount</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Maxrowcount</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ExcelQuery#getMaxrowcount()
     * @see #getExcelQuery()
     * @generated
     */
	EReference getExcelQuery_Maxrowcount();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Expression
     * @generated
     */
	EClass getExpression();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Expression#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Expression#getValue()
     * @see #getExpression()
     * @generated
     */
	EAttribute getExpression_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery <em>GSpread Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>GSpread Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.GSpreadQuery
     * @generated
     */
	EClass getGSpreadQuery();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getMixed()
     * @see #getGSpreadQuery()
     * @generated
     */
	EAttribute getGSpreadQuery_Mixed();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getWorksheetnumber <em>Worksheetnumber</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Worksheetnumber</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getWorksheetnumber()
     * @see #getGSpreadQuery()
     * @generated
     */
	EReference getGSpreadQuery_Worksheetnumber();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getStartingrow <em>Startingrow</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Startingrow</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getStartingrow()
     * @see #getGSpreadQuery()
     * @generated
     */
	EReference getGSpreadQuery_Startingrow();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getMaxrowcount <em>Maxrowcount</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Maxrowcount</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getMaxrowcount()
     * @see #getGSpreadQuery()
     * @generated
     */
	EReference getGSpreadQuery_Maxrowcount();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getHasheader <em>Hasheader</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Hasheader</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.GSpreadQuery#getHasheader()
     * @see #getGSpreadQuery()
     * @generated
     */
	EReference getGSpreadQuery_Hasheader();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.HasHeader <em>Has Header</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Has Header</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.HasHeader
     * @generated
     */
	EClass getHasHeader();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.HasHeader#isValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.HasHeader#isValue()
     * @see #getHasHeader()
     * @generated
     */
	EAttribute getHasHeader_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.LengthValidator <em>Length Validator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Length Validator</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.LengthValidator
     * @generated
     */
	EClass getLengthValidator();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.LengthValidator#getMaximum <em>Maximum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.LengthValidator#getMaximum()
     * @see #getLengthValidator()
     * @generated
     */
	EAttribute getLengthValidator_Maximum();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.LengthValidator#getMinimum <em>Minimum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Minimum</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.LengthValidator#getMinimum()
     * @see #getLengthValidator()
     * @generated
     */
	EAttribute getLengthValidator_Minimum();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.LongRangeValidator <em>Long Range Validator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Long Range Validator</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.LongRangeValidator
     * @generated
     */
	EClass getLongRangeValidator();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.LongRangeValidator#getMaximum <em>Maximum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.LongRangeValidator#getMaximum()
     * @see #getLongRangeValidator()
     * @generated
     */
	EAttribute getLongRangeValidator_Maximum();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.LongRangeValidator#getMinimum <em>Minimum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Minimum</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.LongRangeValidator#getMinimum()
     * @see #getLongRangeValidator()
     * @generated
     */
	EAttribute getLongRangeValidator_Minimum();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.MaxRowCount <em>Max Row Count</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Max Row Count</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.MaxRowCount
     * @generated
     */
	EClass getMaxRowCount();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.MaxRowCount#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.MaxRowCount#getValue()
     * @see #getMaxRowCount()
     * @generated
     */
	EAttribute getMaxRowCount_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Operation <em>Operation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operation</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Operation
     * @generated
     */
	EClass getOperation();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.Operation#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Operation#getMixed()
     * @see #getOperation()
     * @generated
     */
	EAttribute getOperation_Mixed();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.Operation#getCallQuery <em>Call Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Call Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Operation#getCallQuery()
     * @see #getOperation()
     * @generated
     */
	EReference getOperation_CallQuery();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.Operation#getCallQueryGroup <em>Call Query Group</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Call Query Group</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Operation#getCallQueryGroup()
     * @see #getOperation()
     * @generated
     */
	EReference getOperation_CallQueryGroup();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Operation#isDisableStreaming <em>Disable Streaming</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Disable Streaming</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Operation#isDisableStreaming()
     * @see #getOperation()
     * @generated
     */
	EAttribute getOperation_DisableStreaming();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Operation#isReturnRequestStatus <em>Return Request Status</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Return Request Status</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Operation#isReturnRequestStatus()
     * @see #getOperation()
     * @generated
     */
	EAttribute getOperation_ReturnRequestStatus();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Operation#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Operation#getName()
     * @see #getOperation()
     * @generated
     */
	EAttribute getOperation_Name();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.ParameterMapping <em>Parameter Mapping</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter Mapping</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ParameterMapping
     * @generated
     */
	EClass getParameterMapping();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ParameterMapping#getColumn <em>Column</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ParameterMapping#getColumn()
     * @see #getParameterMapping()
     * @generated
     */
	EAttribute getParameterMapping_Column();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ParameterMapping#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ParameterMapping#getName()
     * @see #getParameterMapping()
     * @generated
     */
	EAttribute getParameterMapping_Name();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ParameterMapping#getQueryParam <em>Query Param</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Query Param</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ParameterMapping#getQueryParam()
     * @see #getParameterMapping()
     * @generated
     */
	EAttribute getParameterMapping_QueryParam();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.PatternValidator <em>Pattern Validator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pattern Validator</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.PatternValidator
     * @generated
     */
	EClass getPatternValidator();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.PatternValidator#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.PatternValidator#getPattern()
     * @see #getPatternValidator()
     * @generated
     */
	EAttribute getPatternValidator_Pattern();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Query <em>Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query
     * @generated
     */
	EClass getQuery();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.Query#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getMixed()
     * @see #getQuery()
     * @generated
     */
	EAttribute getQuery_Mixed();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.Query#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Expression</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getExpression()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Expression();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.Query#getSql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sql</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getSql()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Sql();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.Query#getSparql <em>Sparql</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sparql</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getSparql()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Sparql();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.Query#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getProperties()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Properties();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.Query#getResult <em>Result</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Result</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getResult()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Result();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.Query#getExcel <em>Excel</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Excel</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getExcel()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Excel();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.Query#getGspread <em>Gspread</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Gspread</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getGspread()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Gspread();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.Query#getParam <em>Param</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Param</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getParam()
     * @see #getQuery()
     * @generated
     */
	EReference getQuery_Param();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Query#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getId()
     * @see #getQuery()
     * @generated
     */
	EAttribute getQuery_Id();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Query#getInputEventTrigger <em>Input Event Trigger</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Input Event Trigger</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getInputEventTrigger()
     * @see #getQuery()
     * @generated
     */
	EAttribute getQuery_InputEventTrigger();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Query#getOutputEventTrigger <em>Output Event Trigger</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Event Trigger</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getOutputEventTrigger()
     * @see #getQuery()
     * @generated
     */
	EAttribute getQuery_OutputEventTrigger();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Query#isReturnGeneratedKeys <em>Return Generated Keys</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Return Generated Keys</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#isReturnGeneratedKeys()
     * @see #getQuery()
     * @generated
     */
	EAttribute getQuery_ReturnGeneratedKeys();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Query#getUseConfig <em>Use Config</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use Config</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getUseConfig()
     * @see #getQuery()
     * @generated
     */
	EAttribute getQuery_UseConfig();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Query#getKeyColumns <em>Key Columns</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key Columns</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Query#getKeyColumns()
     * @see #getQuery()
     * @generated
     */
	EAttribute getQuery_KeyColumns();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter <em>Query Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Parameter</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter
     * @generated
     */
	EClass getQueryParameter();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getMixed()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_Mixed();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLongRange <em>Validate Long Range</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Validate Long Range</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLongRange()
     * @see #getQueryParameter()
     * @generated
     */
	EReference getQueryParameter_ValidateLongRange();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateDoubleRange <em>Validate Double Range</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Validate Double Range</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateDoubleRange()
     * @see #getQueryParameter()
     * @generated
     */
	EReference getQueryParameter_ValidateDoubleRange();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLength <em>Validate Length</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Validate Length</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateLength()
     * @see #getQueryParameter()
     * @generated
     */
	EReference getQueryParameter_ValidateLength();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidatePattern <em>Validate Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Validate Pattern</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidatePattern()
     * @see #getQueryParameter()
     * @generated
     */
	EReference getQueryParameter_ValidatePattern();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateCustom <em>Validate Custom</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Validate Custom</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getValidateCustom()
     * @see #getQueryParameter()
     * @generated
     */
	EReference getQueryParameter_ValidateCustom();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getDefaultValue()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_DefaultValue();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getName()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_Name();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getOrdinal <em>Ordinal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ordinal</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getOrdinal()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_Ordinal();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getParamType <em>Param Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Param Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getParamType()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_ParamType();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getSqlType <em>Sql Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getSqlType()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_SqlType();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getStructType <em>Struct Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Struct Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getStructType()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_StructType();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryParameter#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryParameter#getType()
     * @see #getQueryParameter()
     * @generated
     */
	EAttribute getQueryParameter_Type();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.QueryProperty <em>Query Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Property</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryProperty
     * @generated
     */
	EClass getQueryProperty();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryProperty#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryProperty#getValue()
     * @see #getQueryProperty()
     * @generated
     */
	EAttribute getQueryProperty_Value();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryProperty#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryProperty#getName()
     * @see #getQueryProperty()
     * @generated
     */
	EAttribute getQueryProperty_Name();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.QueryPropertyList <em>Query Property List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Property List</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryPropertyList
     * @generated
     */
	EClass getQueryPropertyList();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.QueryPropertyList#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryPropertyList#getMixed()
     * @see #getQueryPropertyList()
     * @generated
     */
	EAttribute getQueryPropertyList_Mixed();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.QueryPropertyList#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryPropertyList#getProperty()
     * @see #getQueryPropertyList()
     * @generated
     */
	EReference getQueryPropertyList_Property();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Resource <em>Resource</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Resource</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Resource
     * @generated
     */
	EClass getResource();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.Resource#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Resource#getMixed()
     * @see #getResource()
     * @generated
     */
	EAttribute getResource_Mixed();

	/**
     * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.ds.Resource#getCallQuery <em>Call Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Call Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Resource#getCallQuery()
     * @see #getResource()
     * @generated
     */
	EReference getResource_CallQuery();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Resource#getMethod <em>Method</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Method</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Resource#getMethod()
     * @see #getResource()
     * @generated
     */
	EAttribute getResource_Method();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Resource#getPath <em>Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Path</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Resource#getPath()
     * @see #getResource()
     * @generated
     */
	EAttribute getResource_Path();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Resource#isReturnRequestStatus <em>Return Request Status</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Return Request Status</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Resource#isReturnRequestStatus()
     * @see #getResource()
     * @generated
     */
	EAttribute getResource_ReturnRequestStatus();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping <em>Result Mapping</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Result Mapping</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping
     * @generated
     */
	EClass getResultMapping();

	/**
     * Returns the meta object for the attribute list '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getMixed()
     * @see #getResultMapping()
     * @generated
     */
	EAttribute getResultMapping_Mixed();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Element</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getElement()
     * @see #getResultMapping()
     * @generated
     */
	EReference getResultMapping_Element();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Attribute</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getAttribute()
     * @see #getResultMapping()
     * @generated
     */
	EReference getResultMapping_Attribute();

	/**
     * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getCallQuery <em>Call Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Call Query</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getCallQuery()
     * @see #getResultMapping()
     * @generated
     */
	EReference getResultMapping_CallQuery();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getDefaultNamespace <em>Default Namespace</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Namespace</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getDefaultNamespace()
     * @see #getResultMapping()
     * @generated
     */
	EAttribute getResultMapping_DefaultNamespace();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getElementName <em>Element Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Element Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getElementName()
     * @see #getResultMapping()
     * @generated
     */
	EAttribute getResultMapping_ElementName();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getRowName <em>Row Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Row Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getRowName()
     * @see #getResultMapping()
     * @generated
     */
	EAttribute getResultMapping_RowName();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#isUseColumnNumbers <em>Use Column Numbers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Use Column Numbers</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#isUseColumnNumbers()
     * @see #getResultMapping()
     * @generated
     */
	EAttribute getResultMapping_UseColumnNumbers();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#isEscapeNonPrintableChar <em>Escape Non Printable Char</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Escape Non Printable Char</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#isEscapeNonPrintableChar()
     * @see #getResultMapping()
     * @generated
     */
	EAttribute getResultMapping_EscapeNonPrintableChar();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getXsltPath <em>Xslt Path</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xslt Path</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getXsltPath()
     * @see #getResultMapping()
     * @generated
     */
	EAttribute getResultMapping_XsltPath();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.ResultMapping#getOutputType <em>Output Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Type</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ResultMapping#getOutputType()
     * @see #getResultMapping()
     * @generated
     */
    EAttribute getResultMapping_OutputType();

    /**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Sparql <em>Sparql</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sparql</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Sparql
     * @generated
     */
	EClass getSparql();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Sparql#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Sparql#getValue()
     * @see #getSparql()
     * @generated
     */
	EAttribute getSparql_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Sql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sql</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Sql
     * @generated
     */
	EClass getSql();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Sql#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Sql#getValue()
     * @see #getSql()
     * @generated
     */
	EAttribute getSql_Value();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Sql#getDialect <em>Dialect</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dialect</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Sql#getDialect()
     * @see #getSql()
     * @generated
     */
	EAttribute getSql_Dialect();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.QueryExpression <em>Query Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Expression</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryExpression
     * @generated
     */
	EClass getQueryExpression();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.QueryExpression#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.QueryExpression#getValue()
     * @see #getQueryExpression()
     * @generated
     */
	EAttribute getQueryExpression_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.StartingRow <em>Starting Row</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Starting Row</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.StartingRow
     * @generated
     */
	EClass getStartingRow();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.StartingRow#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.StartingRow#getValue()
     * @see #getStartingRow()
     * @generated
     */
	EAttribute getStartingRow_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Subscription <em>Subscription</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Subscription</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Subscription
     * @generated
     */
	EClass getSubscription();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Subscription#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Subscription#getValue()
     * @see #getSubscription()
     * @generated
     */
	EAttribute getSubscription_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.TargetTopic <em>Target Topic</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Target Topic</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.TargetTopic
     * @generated
     */
	EClass getTargetTopic();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.TargetTopic#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.TargetTopic#getValue()
     * @see #getTargetTopic()
     * @generated
     */
	EAttribute getTargetTopic_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.WorkBookName <em>Work Book Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Work Book Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.WorkBookName
     * @generated
     */
	EClass getWorkBookName();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.WorkBookName#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.WorkBookName#getValue()
     * @see #getWorkBookName()
     * @generated
     */
	EAttribute getWorkBookName_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.WorkSheetNumber <em>Work Sheet Number</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Work Sheet Number</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.WorkSheetNumber
     * @generated
     */
	EClass getWorkSheetNumber();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.WorkSheetNumber#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.WorkSheetNumber#getValue()
     * @see #getWorkSheetNumber()
     * @generated
     */
	EAttribute getWorkSheetNumber_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.Policy <em>Policy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Policy</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Policy
     * @generated
     */
	EClass getPolicy();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.Policy#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.Policy#getKey()
     * @see #getPolicy()
     * @generated
     */
	EAttribute getPolicy_Key();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.DataServiceParameter <em>Data Service Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Service Parameter</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataServiceParameter
     * @generated
     */
	EClass getDataServiceParameter();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataServiceParameter#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataServiceParameter#getName()
     * @see #getDataServiceParameter()
     * @generated
     */
	EAttribute getDataServiceParameter_Name();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.DataServiceParameter#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.DataServiceParameter#getValue()
     * @see #getDataServiceParameter()
     * @generated
     */
	EAttribute getDataServiceParameter_Value();

	/**
     * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.ds.RegistryKeyProperty <em>Registry Key Property</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Registry Key Property</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.RegistryKeyProperty
     * @generated
     */
	EClass getRegistryKeyProperty();

	/**
     * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.ds.RegistryKeyProperty#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.RegistryKeyProperty#getKey()
     * @see #getRegistryKeyProperty()
     * @generated
     */
	EAttribute getRegistryKeyProperty_Key();

	/**
     * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.ds.ServiceStatus <em>Service Status</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Service Status</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ServiceStatus
     * @generated
     */
	EEnum getServiceStatus();

	/**
     * Returns the meta object for data type '{@link org.wso2.developerstudio.eclipse.ds.ServiceStatus <em>Service Status Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Service Status Object</em>'.
     * @see org.wso2.developerstudio.eclipse.ds.ServiceStatus
     * @model instanceClass="org.wso2.developerstudio.eclipse.ds.ServiceStatus"
     *        extendedMetaData="name='serviceStatus_._type:Object' baseType='serviceStatus_._type'"
     * @generated
     */
	EDataType getServiceStatusObject();

	/**
     * Returns the meta object for data type '{@link java.util.Map <em>Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Map</em>'.
     * @see java.util.Map
     * @model instanceClass="java.util.Map" typeParameters="K V"
     * @generated
     */
	EDataType getMap();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	DsFactory getDsFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.AttributeMappingImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getAttributeMapping()
         * @generated
         */
		EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

		/**
         * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE_MAPPING__COLUMN = eINSTANCE.getAttributeMapping_Column();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE_MAPPING__NAME = eINSTANCE.getAttributeMapping_Name();

		/**
         * The meta object literal for the '<em><b>Required Roles</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE_MAPPING__REQUIRED_ROLES =
		                                               eINSTANCE.getAttributeMapping_RequiredRoles();

		/**
         * The meta object literal for the '<em><b>Xsd Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE_MAPPING__XSD_TYPE = eINSTANCE.getAttributeMapping_XsdType();

		/**
         * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ATTRIBUTE_MAPPING__OPTIONAL = eINSTANCE.getAttributeMapping_Optional();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.CallQueryImpl <em>Call Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.CallQueryImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getCallQuery()
         * @generated
         */
		EClass CALL_QUERY = eINSTANCE.getCallQuery();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CALL_QUERY__MIXED = eINSTANCE.getCallQuery_Mixed();

		/**
         * The meta object literal for the '<em><b>With Param</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CALL_QUERY__WITH_PARAM = eINSTANCE.getCallQuery_WithParam();

		/**
         * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CALL_QUERY__HREF = eINSTANCE.getCallQuery_Href();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.CallQueryListImpl <em>Call Query List</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.CallQueryListImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getCallQueryList()
         * @generated
         */
		EClass CALL_QUERY_LIST = eINSTANCE.getCallQueryList();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CALL_QUERY_LIST__MIXED = eINSTANCE.getCallQueryList_Mixed();

		/**
         * The meta object literal for the '<em><b>Call Query</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CALL_QUERY_LIST__CALL_QUERY = eINSTANCE.getCallQueryList_CallQuery();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ConfigurationPropertyImpl <em>Configuration Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.ConfigurationPropertyImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getConfigurationProperty()
         * @generated
         */
		EClass CONFIGURATION_PROPERTY = eINSTANCE.getConfigurationProperty();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CONFIGURATION_PROPERTY__VALUE = eINSTANCE.getConfigurationProperty_Value();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CONFIGURATION_PROPERTY__NAME = eINSTANCE.getConfigurationProperty_Name();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.CustomValidatorImpl <em>Custom Validator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.CustomValidatorImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getCustomValidator()
         * @generated
         */
		EClass CUSTOM_VALIDATOR = eINSTANCE.getCustomValidator();

		/**
         * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CUSTOM_VALIDATOR__CLASS = eINSTANCE.getCustomValidator_Class();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DataServiceImpl <em>Data Service</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.DataServiceImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDataService()
         * @generated
         */
		EClass DATA_SERVICE = eINSTANCE.getDataService();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__MIXED = eINSTANCE.getDataService_Mixed();

		/**
         * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__DESCRIPTION = eINSTANCE.getDataService_Description();

		/**
         * The meta object literal for the '<em><b>Config</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__CONFIG = eINSTANCE.getDataService_Config();

		/**
         * The meta object literal for the '<em><b>Query</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__QUERY = eINSTANCE.getDataService_Query();

		/**
         * The meta object literal for the '<em><b>Event Trigger</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__EVENT_TRIGGER = eINSTANCE.getDataService_EventTrigger();

		/**
         * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__OPERATION = eINSTANCE.getDataService_Operation();

		/**
         * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__RESOURCE = eINSTANCE.getDataService_Resource();

		/**
         * The meta object literal for the '<em><b>Base URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__BASE_URI = eINSTANCE.getDataService_BaseURI();

		/**
         * The meta object literal for the '<em><b>Enable Batch Requests</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__ENABLE_BATCH_REQUESTS =
		                                                 eINSTANCE.getDataService_EnableBatchRequests();

		/**
         * The meta object literal for the '<em><b>Enable Boxcarring</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__ENABLE_BOXCARRING = eINSTANCE.getDataService_EnableBoxcarring();

		/**
         * The meta object literal for the '<em><b>Enable DTP</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__ENABLE_DTP = eINSTANCE.getDataService_EnableDTP();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__NAME = eINSTANCE.getDataService_Name();

		/**
         * The meta object literal for the '<em><b>Service Group</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__SERVICE_GROUP = eINSTANCE.getDataService_ServiceGroup();

		/**
         * The meta object literal for the '<em><b>Service Namespace</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__SERVICE_NAMESPACE = eINSTANCE.getDataService_ServiceNamespace();

		/**
         * The meta object literal for the '<em><b>Service Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__SERVICE_STATUS = eINSTANCE.getDataService_ServiceStatus();

		/**
         * The meta object literal for the '<em><b>Disable Streaming</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__DISABLE_STREAMING = eINSTANCE.getDataService_DisableStreaming();

		/**
         * The meta object literal for the '<em><b>Enable Sec</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__ENABLE_SEC = eINSTANCE.getDataService_EnableSec();

		/**
         * The meta object literal for the '<em><b>Policy</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__POLICY = eINSTANCE.getDataService_Policy();

		/**
         * The meta object literal for the '<em><b>Transports</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE__TRANSPORTS = eINSTANCE.getDataService_Transports();

		/**
         * The meta object literal for the '<em><b>Feature Allow Roles</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SERVICE__FEATURE_ALLOW_ROLES = eINSTANCE.getDataService_FeatureAllowRoles();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DataSourceConfigurationImpl <em>Data Source Configuration</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.DataSourceConfigurationImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDataSourceConfiguration()
         * @generated
         */
		EClass DATA_SOURCE_CONFIGURATION = eINSTANCE.getDataSourceConfiguration();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SOURCE_CONFIGURATION__MIXED = eINSTANCE.getDataSourceConfiguration_Mixed();

		/**
         * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_SOURCE_CONFIGURATION__PROPERTY =
		                                                 eINSTANCE.getDataSourceConfiguration_Property();

		/**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SOURCE_CONFIGURATION__ID = eINSTANCE.getDataSourceConfiguration_Id();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DescriptionImpl <em>Description</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.DescriptionImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDescription()
         * @generated
         */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DESCRIPTION__VALUE = eINSTANCE.getDescription_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.DocumentRootImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDocumentRoot()
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
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION =
		                                                eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
         * The meta object literal for the '<em><b>Call Query</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__CALL_QUERY = eINSTANCE.getDocumentRoot_CallQuery();

		/**
         * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__DATA = eINSTANCE.getDocumentRoot_Data();

		/**
         * The meta object literal for the '<em><b>Hasheader</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__HASHEADER = eINSTANCE.getDocumentRoot_Hasheader();

		/**
         * The meta object literal for the '<em><b>Maxrowcount</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__MAXROWCOUNT = eINSTANCE.getDocumentRoot_Maxrowcount();

		/**
         * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__PROPERTY = eINSTANCE.getDocumentRoot_Property();

		/**
         * The meta object literal for the '<em><b>Sql</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__SQL = eINSTANCE.getDocumentRoot_Sql();

		/**
         * The meta object literal for the '<em><b>Startingrow</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DOCUMENT_ROOT__STARTINGROW = eINSTANCE.getDocumentRoot_Startingrow();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DoubleRangeValidatorImpl <em>Double Range Validator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.DoubleRangeValidatorImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDoubleRangeValidator()
         * @generated
         */
		EClass DOUBLE_RANGE_VALIDATOR = eINSTANCE.getDoubleRangeValidator();

		/**
         * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DOUBLE_RANGE_VALIDATOR__MAXIMUM = eINSTANCE.getDoubleRangeValidator_Maximum();

		/**
         * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DOUBLE_RANGE_VALIDATOR__MINIMUM = eINSTANCE.getDoubleRangeValidator_Minimum();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ElementMappingImpl <em>Element Mapping</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.ElementMappingImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getElementMapping()
         * @generated
         */
		EClass ELEMENT_MAPPING = eINSTANCE.getElementMapping();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__MIXED = eINSTANCE.getElementMapping_Mixed();

		/**
         * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__COLUMN = eINSTANCE.getElementMapping_Column();

		/**
         * The meta object literal for the '<em><b>Export</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__EXPORT = eINSTANCE.getElementMapping_Export();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__NAME = eINSTANCE.getElementMapping_Name();

		/**
         * The meta object literal for the '<em><b>Required Roles</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__REQUIRED_ROLES = eINSTANCE.getElementMapping_RequiredRoles();

		/**
         * The meta object literal for the '<em><b>Export Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__EXPORT_TYPE = eINSTANCE.getElementMapping_ExportType();

		/**
         * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__NAMESPACE = eINSTANCE.getElementMapping_Namespace();

		/**
         * The meta object literal for the '<em><b>Xsd Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__XSD_TYPE = eINSTANCE.getElementMapping_XsdType();

		/**
         * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ELEMENT_MAPPING__ELEMENT = eINSTANCE.getElementMapping_Element();

		/**
         * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ELEMENT_MAPPING__ATTRIBUTE = eINSTANCE.getElementMapping_Attribute();

		/**
         * The meta object literal for the '<em><b>Call Query</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ELEMENT_MAPPING__CALL_QUERY = eINSTANCE.getElementMapping_CallQuery();

		/**
         * The meta object literal for the '<em><b>Is Complex Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__IS_COMPLEX_TYPE = eINSTANCE.getElementMapping_IsComplexType();

		/**
         * The meta object literal for the '<em><b>Query Param</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__QUERY_PARAM = eINSTANCE.getElementMapping_QueryParam();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__VALUE = eINSTANCE.getElementMapping_Value();

		/**
         * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__OPTIONAL = eINSTANCE.getElementMapping_Optional();

		/**
         * The meta object literal for the '<em><b>Array Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ELEMENT_MAPPING__ARRAY_NAME = eINSTANCE.getElementMapping_ArrayName();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.EventSubscriptionListImpl <em>Event Subscription List</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.EventSubscriptionListImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getEventSubscriptionList()
         * @generated
         */
		EClass EVENT_SUBSCRIPTION_LIST = eINSTANCE.getEventSubscriptionList();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EVENT_SUBSCRIPTION_LIST__MIXED = eINSTANCE.getEventSubscriptionList_Mixed();

		/**
         * The meta object literal for the '<em><b>Subscription</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_SUBSCRIPTION_LIST__SUBSCRIPTION =
		                                                   eINSTANCE.getEventSubscriptionList_Subscription();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl <em>Event Trigger</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.EventTriggerImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getEventTrigger()
         * @generated
         */
		EClass EVENT_TRIGGER = eINSTANCE.getEventTrigger();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EVENT_TRIGGER__MIXED = eINSTANCE.getEventTrigger_Mixed();

		/**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_TRIGGER__EXPRESSION = eINSTANCE.getEventTrigger_Expression();

		/**
         * The meta object literal for the '<em><b>Target Topic</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_TRIGGER__TARGET_TOPIC = eINSTANCE.getEventTrigger_TargetTopic();

		/**
         * The meta object literal for the '<em><b>Subscriptions</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_TRIGGER__SUBSCRIPTIONS = eINSTANCE.getEventTrigger_Subscriptions();

		/**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EVENT_TRIGGER__ID = eINSTANCE.getEventTrigger_Id();

		/**
         * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EVENT_TRIGGER__LANGUAGE = eINSTANCE.getEventTrigger_Language();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl <em>Excel Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.ExcelQueryImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getExcelQuery()
         * @generated
         */
		EClass EXCEL_QUERY = eINSTANCE.getExcelQuery();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EXCEL_QUERY__MIXED = eINSTANCE.getExcelQuery_Mixed();

		/**
         * The meta object literal for the '<em><b>Workbookname</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXCEL_QUERY__WORKBOOKNAME = eINSTANCE.getExcelQuery_Workbookname();

		/**
         * The meta object literal for the '<em><b>Hasheader</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXCEL_QUERY__HASHEADER = eINSTANCE.getExcelQuery_Hasheader();

		/**
         * The meta object literal for the '<em><b>Startingrow</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXCEL_QUERY__STARTINGROW = eINSTANCE.getExcelQuery_Startingrow();

		/**
         * The meta object literal for the '<em><b>Maxrowcount</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXCEL_QUERY__MAXROWCOUNT = eINSTANCE.getExcelQuery_Maxrowcount();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ExpressionImpl <em>Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.ExpressionImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getExpression()
         * @generated
         */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute EXPRESSION__VALUE = eINSTANCE.getExpression_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl <em>GSpread Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.GSpreadQueryImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getGSpreadQuery()
         * @generated
         */
		EClass GSPREAD_QUERY = eINSTANCE.getGSpreadQuery();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute GSPREAD_QUERY__MIXED = eINSTANCE.getGSpreadQuery_Mixed();

		/**
         * The meta object literal for the '<em><b>Worksheetnumber</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GSPREAD_QUERY__WORKSHEETNUMBER = eINSTANCE.getGSpreadQuery_Worksheetnumber();

		/**
         * The meta object literal for the '<em><b>Startingrow</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GSPREAD_QUERY__STARTINGROW = eINSTANCE.getGSpreadQuery_Startingrow();

		/**
         * The meta object literal for the '<em><b>Maxrowcount</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GSPREAD_QUERY__MAXROWCOUNT = eINSTANCE.getGSpreadQuery_Maxrowcount();

		/**
         * The meta object literal for the '<em><b>Hasheader</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GSPREAD_QUERY__HASHEADER = eINSTANCE.getGSpreadQuery_Hasheader();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.HasHeaderImpl <em>Has Header</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.HasHeaderImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getHasHeader()
         * @generated
         */
		EClass HAS_HEADER = eINSTANCE.getHasHeader();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute HAS_HEADER__VALUE = eINSTANCE.getHasHeader_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.LengthValidatorImpl <em>Length Validator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.LengthValidatorImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getLengthValidator()
         * @generated
         */
		EClass LENGTH_VALIDATOR = eINSTANCE.getLengthValidator();

		/**
         * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LENGTH_VALIDATOR__MAXIMUM = eINSTANCE.getLengthValidator_Maximum();

		/**
         * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LENGTH_VALIDATOR__MINIMUM = eINSTANCE.getLengthValidator_Minimum();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.LongRangeValidatorImpl <em>Long Range Validator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.LongRangeValidatorImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getLongRangeValidator()
         * @generated
         */
		EClass LONG_RANGE_VALIDATOR = eINSTANCE.getLongRangeValidator();

		/**
         * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LONG_RANGE_VALIDATOR__MAXIMUM = eINSTANCE.getLongRangeValidator_Maximum();

		/**
         * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LONG_RANGE_VALIDATOR__MINIMUM = eINSTANCE.getLongRangeValidator_Minimum();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.MaxRowCountImpl <em>Max Row Count</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.MaxRowCountImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getMaxRowCount()
         * @generated
         */
		EClass MAX_ROW_COUNT = eINSTANCE.getMaxRowCount();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MAX_ROW_COUNT__VALUE = eINSTANCE.getMaxRowCount_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.OperationImpl <em>Operation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.OperationImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getOperation()
         * @generated
         */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OPERATION__MIXED = eINSTANCE.getOperation_Mixed();

		/**
         * The meta object literal for the '<em><b>Call Query</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION__CALL_QUERY = eINSTANCE.getOperation_CallQuery();

		/**
         * The meta object literal for the '<em><b>Call Query Group</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OPERATION__CALL_QUERY_GROUP = eINSTANCE.getOperation_CallQueryGroup();

		/**
         * The meta object literal for the '<em><b>Disable Streaming</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OPERATION__DISABLE_STREAMING = eINSTANCE.getOperation_DisableStreaming();

		/**
         * The meta object literal for the '<em><b>Return Request Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OPERATION__RETURN_REQUEST_STATUS = eINSTANCE.getOperation_ReturnRequestStatus();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ParameterMappingImpl <em>Parameter Mapping</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.ParameterMappingImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getParameterMapping()
         * @generated
         */
		EClass PARAMETER_MAPPING = eINSTANCE.getParameterMapping();

		/**
         * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PARAMETER_MAPPING__COLUMN = eINSTANCE.getParameterMapping_Column();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PARAMETER_MAPPING__NAME = eINSTANCE.getParameterMapping_Name();

		/**
         * The meta object literal for the '<em><b>Query Param</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PARAMETER_MAPPING__QUERY_PARAM = eINSTANCE.getParameterMapping_QueryParam();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.PatternValidatorImpl <em>Pattern Validator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.PatternValidatorImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getPatternValidator()
         * @generated
         */
		EClass PATTERN_VALIDATOR = eINSTANCE.getPatternValidator();

		/**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PATTERN_VALIDATOR__PATTERN = eINSTANCE.getPatternValidator_Pattern();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryImpl <em>Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.QueryImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQuery()
         * @generated
         */
		EClass QUERY = eINSTANCE.getQuery();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY__MIXED = eINSTANCE.getQuery_Mixed();

		/**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__EXPRESSION = eINSTANCE.getQuery_Expression();

		/**
         * The meta object literal for the '<em><b>Sql</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__SQL = eINSTANCE.getQuery_Sql();

		/**
         * The meta object literal for the '<em><b>Sparql</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__SPARQL = eINSTANCE.getQuery_Sparql();

		/**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__PROPERTIES = eINSTANCE.getQuery_Properties();

		/**
         * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__RESULT = eINSTANCE.getQuery_Result();

		/**
         * The meta object literal for the '<em><b>Excel</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__EXCEL = eINSTANCE.getQuery_Excel();

		/**
         * The meta object literal for the '<em><b>Gspread</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__GSPREAD = eINSTANCE.getQuery_Gspread();

		/**
         * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY__PARAM = eINSTANCE.getQuery_Param();

		/**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY__ID = eINSTANCE.getQuery_Id();

		/**
         * The meta object literal for the '<em><b>Input Event Trigger</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY__INPUT_EVENT_TRIGGER = eINSTANCE.getQuery_InputEventTrigger();

		/**
         * The meta object literal for the '<em><b>Output Event Trigger</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY__OUTPUT_EVENT_TRIGGER = eINSTANCE.getQuery_OutputEventTrigger();

		/**
         * The meta object literal for the '<em><b>Return Generated Keys</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY__RETURN_GENERATED_KEYS = eINSTANCE.getQuery_ReturnGeneratedKeys();

		/**
         * The meta object literal for the '<em><b>Use Config</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY__USE_CONFIG = eINSTANCE.getQuery_UseConfig();

		/**
         * The meta object literal for the '<em><b>Key Columns</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY__KEY_COLUMNS = eINSTANCE.getQuery_KeyColumns();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryParameterImpl <em>Query Parameter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.QueryParameterImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryParameter()
         * @generated
         */
		EClass QUERY_PARAMETER = eINSTANCE.getQueryParameter();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__MIXED = eINSTANCE.getQueryParameter_Mixed();

		/**
         * The meta object literal for the '<em><b>Validate Long Range</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY_PARAMETER__VALIDATE_LONG_RANGE =
		                                                  eINSTANCE.getQueryParameter_ValidateLongRange();

		/**
         * The meta object literal for the '<em><b>Validate Double Range</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE =
		                                                    eINSTANCE.getQueryParameter_ValidateDoubleRange();

		/**
         * The meta object literal for the '<em><b>Validate Length</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY_PARAMETER__VALIDATE_LENGTH = eINSTANCE.getQueryParameter_ValidateLength();

		/**
         * The meta object literal for the '<em><b>Validate Pattern</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY_PARAMETER__VALIDATE_PATTERN =
		                                               eINSTANCE.getQueryParameter_ValidatePattern();

		/**
         * The meta object literal for the '<em><b>Validate Custom</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY_PARAMETER__VALIDATE_CUSTOM = eINSTANCE.getQueryParameter_ValidateCustom();

		/**
         * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__DEFAULT_VALUE = eINSTANCE.getQueryParameter_DefaultValue();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__NAME = eINSTANCE.getQueryParameter_Name();

		/**
         * The meta object literal for the '<em><b>Ordinal</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__ORDINAL = eINSTANCE.getQueryParameter_Ordinal();

		/**
         * The meta object literal for the '<em><b>Param Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__PARAM_TYPE = eINSTANCE.getQueryParameter_ParamType();

		/**
         * The meta object literal for the '<em><b>Sql Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__SQL_TYPE = eINSTANCE.getQueryParameter_SqlType();

		/**
         * The meta object literal for the '<em><b>Struct Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__STRUCT_TYPE = eINSTANCE.getQueryParameter_StructType();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PARAMETER__TYPE = eINSTANCE.getQueryParameter_Type();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyImpl <em>Query Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryProperty()
         * @generated
         */
		EClass QUERY_PROPERTY = eINSTANCE.getQueryProperty();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PROPERTY__VALUE = eINSTANCE.getQueryProperty_Value();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PROPERTY__NAME = eINSTANCE.getQueryProperty_Name();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyListImpl <em>Query Property List</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.QueryPropertyListImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryPropertyList()
         * @generated
         */
		EClass QUERY_PROPERTY_LIST = eINSTANCE.getQueryPropertyList();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_PROPERTY_LIST__MIXED = eINSTANCE.getQueryPropertyList_Mixed();

		/**
         * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference QUERY_PROPERTY_LIST__PROPERTY = eINSTANCE.getQueryPropertyList_Property();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ResourceImpl <em>Resource</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.ResourceImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getResource()
         * @generated
         */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESOURCE__MIXED = eINSTANCE.getResource_Mixed();

		/**
         * The meta object literal for the '<em><b>Call Query</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference RESOURCE__CALL_QUERY = eINSTANCE.getResource_CallQuery();

		/**
         * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESOURCE__METHOD = eINSTANCE.getResource_Method();

		/**
         * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESOURCE__PATH = eINSTANCE.getResource_Path();

		/**
         * The meta object literal for the '<em><b>Return Request Status</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESOURCE__RETURN_REQUEST_STATUS = eINSTANCE.getResource_ReturnRequestStatus();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl <em>Result Mapping</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.ResultMappingImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getResultMapping()
         * @generated
         */
		EClass RESULT_MAPPING = eINSTANCE.getResultMapping();

		/**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESULT_MAPPING__MIXED = eINSTANCE.getResultMapping_Mixed();

		/**
         * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference RESULT_MAPPING__ELEMENT = eINSTANCE.getResultMapping_Element();

		/**
         * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference RESULT_MAPPING__ATTRIBUTE = eINSTANCE.getResultMapping_Attribute();

		/**
         * The meta object literal for the '<em><b>Call Query</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference RESULT_MAPPING__CALL_QUERY = eINSTANCE.getResultMapping_CallQuery();

		/**
         * The meta object literal for the '<em><b>Default Namespace</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESULT_MAPPING__DEFAULT_NAMESPACE =
		                                               eINSTANCE.getResultMapping_DefaultNamespace();

		/**
         * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESULT_MAPPING__ELEMENT_NAME = eINSTANCE.getResultMapping_ElementName();

		/**
         * The meta object literal for the '<em><b>Row Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESULT_MAPPING__ROW_NAME = eINSTANCE.getResultMapping_RowName();

		/**
         * The meta object literal for the '<em><b>Use Column Numbers</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESULT_MAPPING__USE_COLUMN_NUMBERS =
		                                                eINSTANCE.getResultMapping_UseColumnNumbers();

		/**
         * The meta object literal for the '<em><b>Escape Non Printable Char</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR =
		                                                       eINSTANCE.getResultMapping_EscapeNonPrintableChar();

		/**
         * The meta object literal for the '<em><b>Xslt Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute RESULT_MAPPING__XSLT_PATH = eINSTANCE.getResultMapping_XsltPath();

		/**
         * The meta object literal for the '<em><b>Output Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESULT_MAPPING__OUTPUT_TYPE = eINSTANCE.getResultMapping_OutputType();

        /**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.SparqlImpl <em>Sparql</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.SparqlImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getSparql()
         * @generated
         */
		EClass SPARQL = eINSTANCE.getSparql();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SPARQL__VALUE = eINSTANCE.getSparql_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.SqlImpl <em>Sql</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.SqlImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getSql()
         * @generated
         */
		EClass SQL = eINSTANCE.getSql();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SQL__VALUE = eINSTANCE.getSql_Value();

		/**
         * The meta object literal for the '<em><b>Dialect</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SQL__DIALECT = eINSTANCE.getSql_Dialect();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.QueryExpressionImpl <em>Query Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.QueryExpressionImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getQueryExpression()
         * @generated
         */
		EClass QUERY_EXPRESSION = eINSTANCE.getQueryExpression();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute QUERY_EXPRESSION__VALUE = eINSTANCE.getQueryExpression_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.StartingRowImpl <em>Starting Row</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.StartingRowImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getStartingRow()
         * @generated
         */
		EClass STARTING_ROW = eINSTANCE.getStartingRow();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute STARTING_ROW__VALUE = eINSTANCE.getStartingRow_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.SubscriptionImpl <em>Subscription</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.SubscriptionImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getSubscription()
         * @generated
         */
		EClass SUBSCRIPTION = eINSTANCE.getSubscription();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SUBSCRIPTION__VALUE = eINSTANCE.getSubscription_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.TargetTopicImpl <em>Target Topic</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.TargetTopicImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getTargetTopic()
         * @generated
         */
		EClass TARGET_TOPIC = eINSTANCE.getTargetTopic();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TARGET_TOPIC__VALUE = eINSTANCE.getTargetTopic_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.WorkBookNameImpl <em>Work Book Name</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.WorkBookNameImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getWorkBookName()
         * @generated
         */
		EClass WORK_BOOK_NAME = eINSTANCE.getWorkBookName();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute WORK_BOOK_NAME__VALUE = eINSTANCE.getWorkBookName_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.WorkSheetNumberImpl <em>Work Sheet Number</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.WorkSheetNumberImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getWorkSheetNumber()
         * @generated
         */
		EClass WORK_SHEET_NUMBER = eINSTANCE.getWorkSheetNumber();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute WORK_SHEET_NUMBER__VALUE = eINSTANCE.getWorkSheetNumber_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.PolicyImpl <em>Policy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.PolicyImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getPolicy()
         * @generated
         */
		EClass POLICY = eINSTANCE.getPolicy();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute POLICY__KEY = eINSTANCE.getPolicy_Key();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.DataServiceParameterImpl <em>Data Service Parameter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.DataServiceParameterImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getDataServiceParameter()
         * @generated
         */
		EClass DATA_SERVICE_PARAMETER = eINSTANCE.getDataServiceParameter();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE_PARAMETER__NAME = eINSTANCE.getDataServiceParameter_Name();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DATA_SERVICE_PARAMETER__VALUE = eINSTANCE.getDataServiceParameter_Value();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.impl.RegistryKeyPropertyImpl <em>Registry Key Property</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.impl.RegistryKeyPropertyImpl
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getRegistryKeyProperty()
         * @generated
         */
		EClass REGISTRY_KEY_PROPERTY = eINSTANCE.getRegistryKeyProperty();

		/**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute REGISTRY_KEY_PROPERTY__KEY = eINSTANCE.getRegistryKeyProperty_Key();

		/**
         * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.ds.ServiceStatus <em>Service Status</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.ServiceStatus
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getServiceStatus()
         * @generated
         */
		EEnum SERVICE_STATUS = eINSTANCE.getServiceStatus();

		/**
         * The meta object literal for the '<em>Service Status Object</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.wso2.developerstudio.eclipse.ds.ServiceStatus
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getServiceStatusObject()
         * @generated
         */
		EDataType SERVICE_STATUS_OBJECT = eINSTANCE.getServiceStatusObject();

		/**
         * The meta object literal for the '<em>Map</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see java.util.Map
         * @see org.wso2.developerstudio.eclipse.ds.impl.DsPackageImpl#getMap()
         * @generated
         */
		EDataType MAP = eINSTANCE.getMap();

	}

} // DsPackage
