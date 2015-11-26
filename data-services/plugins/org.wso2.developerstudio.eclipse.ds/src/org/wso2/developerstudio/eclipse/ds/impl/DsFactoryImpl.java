/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.wso2.developerstudio.eclipse.ds.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DsFactoryImpl extends EFactoryImpl implements DsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DsFactory init() {
        try {
            DsFactory theDsFactory = (DsFactory)EPackage.Registry.INSTANCE.getEFactory(DsPackage.eNS_URI);
            if (theDsFactory != null) {
                return theDsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DsFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */

	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case DsPackage.ATTRIBUTE_MAPPING: return createAttributeMapping();
            case DsPackage.CALL_QUERY: return createCallQuery();
            case DsPackage.CALL_QUERY_LIST: return createCallQueryList();
            case DsPackage.CONFIGURATION_PROPERTY: return createConfigurationProperty();
            case DsPackage.CUSTOM_VALIDATOR: return createCustomValidator();
            case DsPackage.DATA_SERVICE: return createDataService();
            case DsPackage.DATA_SOURCE_CONFIGURATION: return createDataSourceConfiguration();
            case DsPackage.DESCRIPTION: return createDescription();
            case DsPackage.DOCUMENT_ROOT: return createDocumentRoot();
            case DsPackage.DOUBLE_RANGE_VALIDATOR: return createDoubleRangeValidator();
            case DsPackage.ELEMENT_MAPPING: return createElementMapping();
            case DsPackage.EVENT_SUBSCRIPTION_LIST: return createEventSubscriptionList();
            case DsPackage.EVENT_TRIGGER: return createEventTrigger();
            case DsPackage.EXCEL_QUERY: return createExcelQuery();
            case DsPackage.EXPRESSION: return createExpression();
            case DsPackage.GSPREAD_QUERY: return createGSpreadQuery();
            case DsPackage.HAS_HEADER: return createHasHeader();
            case DsPackage.LENGTH_VALIDATOR: return createLengthValidator();
            case DsPackage.LONG_RANGE_VALIDATOR: return createLongRangeValidator();
            case DsPackage.MAX_ROW_COUNT: return createMaxRowCount();
            case DsPackage.OPERATION: return createOperation();
            case DsPackage.PARAMETER_MAPPING: return createParameterMapping();
            case DsPackage.PATTERN_VALIDATOR: return createPatternValidator();
            case DsPackage.QUERY: return createQuery();
            case DsPackage.QUERY_PARAMETER: return createQueryParameter();
            case DsPackage.QUERY_PROPERTY: return createQueryProperty();
            case DsPackage.QUERY_PROPERTY_LIST: return createQueryPropertyList();
            case DsPackage.RESOURCE: return createResource();
            case DsPackage.RESULT_MAPPING: return createResultMapping();
            case DsPackage.SPARQL: return createSparql();
            case DsPackage.SQL: return createSql();
            case DsPackage.QUERY_EXPRESSION: return createQueryExpression();
            case DsPackage.STARTING_ROW: return createStartingRow();
            case DsPackage.SUBSCRIPTION: return createSubscription();
            case DsPackage.TARGET_TOPIC: return createTargetTopic();
            case DsPackage.WORK_BOOK_NAME: return createWorkBookName();
            case DsPackage.WORK_SHEET_NUMBER: return createWorkSheetNumber();
            case DsPackage.POLICY: return createPolicy();
            case DsPackage.DATA_SERVICE_PARAMETER: return createDataServiceParameter();
            case DsPackage.REGISTRY_KEY_PROPERTY: return createRegistryKeyProperty();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */

	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case DsPackage.SERVICE_STATUS:
                return createServiceStatusFromString(eDataType, initialValue);
            case DsPackage.SERVICE_STATUS_OBJECT:
                return createServiceStatusObjectFromString(eDataType, initialValue);
            case DsPackage.MAP:
                return createMapFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */

	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case DsPackage.SERVICE_STATUS:
                return convertServiceStatusToString(eDataType, instanceValue);
            case DsPackage.SERVICE_STATUS_OBJECT:
                return convertServiceStatusObjectToString(eDataType, instanceValue);
            case DsPackage.MAP:
                return convertMapToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AttributeMapping createAttributeMapping() {
        AttributeMappingImpl attributeMapping = new AttributeMappingImpl();
        return attributeMapping;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CallQuery createCallQuery() {
        CallQueryImpl callQuery = new CallQueryImpl();
        return callQuery;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CallQueryList createCallQueryList() {
        CallQueryListImpl callQueryList = new CallQueryListImpl();
        return callQueryList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConfigurationProperty createConfigurationProperty() {
        ConfigurationPropertyImpl configurationProperty = new ConfigurationPropertyImpl();
        return configurationProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CustomValidator createCustomValidator() {
        CustomValidatorImpl customValidator = new CustomValidatorImpl();
        return customValidator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataService createDataService() {
        DataServiceImpl dataService = new DataServiceImpl();
        return dataService;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataSourceConfiguration createDataSourceConfiguration() {
        DataSourceConfigurationImpl dataSourceConfiguration = new DataSourceConfigurationImpl();
        return dataSourceConfiguration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Description createDescription() {
        DescriptionImpl description = new DescriptionImpl();
        return description;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DocumentRoot createDocumentRoot() {
        DocumentRootImpl documentRoot = new DocumentRootImpl();
        return documentRoot;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DoubleRangeValidator createDoubleRangeValidator() {
        DoubleRangeValidatorImpl doubleRangeValidator = new DoubleRangeValidatorImpl();
        return doubleRangeValidator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ElementMapping createElementMapping() {
        ElementMappingImpl elementMapping = new ElementMappingImpl();
        return elementMapping;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventSubscriptionList createEventSubscriptionList() {
        EventSubscriptionListImpl eventSubscriptionList = new EventSubscriptionListImpl();
        return eventSubscriptionList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventTrigger createEventTrigger() {
        EventTriggerImpl eventTrigger = new EventTriggerImpl();
        return eventTrigger;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExcelQuery createExcelQuery() {
        ExcelQueryImpl excelQuery = new ExcelQueryImpl();
        return excelQuery;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression createExpression() {
        ExpressionImpl expression = new ExpressionImpl();
        return expression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GSpreadQuery createGSpreadQuery() {
        GSpreadQueryImpl gSpreadQuery = new GSpreadQueryImpl();
        return gSpreadQuery;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public HasHeader createHasHeader() {
        HasHeaderImpl hasHeader = new HasHeaderImpl();
        return hasHeader;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LengthValidator createLengthValidator() {
        LengthValidatorImpl lengthValidator = new LengthValidatorImpl();
        return lengthValidator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LongRangeValidator createLongRangeValidator() {
        LongRangeValidatorImpl longRangeValidator = new LongRangeValidatorImpl();
        return longRangeValidator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MaxRowCount createMaxRowCount() {
        MaxRowCountImpl maxRowCount = new MaxRowCountImpl();
        return maxRowCount;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Operation createOperation() {
        OperationImpl operation = new OperationImpl();
        return operation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterMapping createParameterMapping() {
        ParameterMappingImpl parameterMapping = new ParameterMappingImpl();
        return parameterMapping;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PatternValidator createPatternValidator() {
        PatternValidatorImpl patternValidator = new PatternValidatorImpl();
        return patternValidator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Query createQuery() {
        QueryImpl query = new QueryImpl();
        return query;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryParameter createQueryParameter() {
        QueryParameterImpl queryParameter = new QueryParameterImpl();
        return queryParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryProperty createQueryProperty() {
        QueryPropertyImpl queryProperty = new QueryPropertyImpl();
        return queryProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryPropertyList createQueryPropertyList() {
        QueryPropertyListImpl queryPropertyList = new QueryPropertyListImpl();
        return queryPropertyList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Resource createResource() {
        ResourceImpl resource = new ResourceImpl();
        return resource;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ResultMapping createResultMapping() {
        ResultMappingImpl resultMapping = new ResultMappingImpl();
        return resultMapping;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Sparql createSparql() {
        SparqlImpl sparql = new SparqlImpl();
        return sparql;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Sql createSql() {
        SqlImpl sql = new SqlImpl();
        return sql;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryExpression createQueryExpression() {
        QueryExpressionImpl queryExpression = new QueryExpressionImpl();
        return queryExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StartingRow createStartingRow() {
        StartingRowImpl startingRow = new StartingRowImpl();
        return startingRow;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Subscription createSubscription() {
        SubscriptionImpl subscription = new SubscriptionImpl();
        return subscription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TargetTopic createTargetTopic() {
        TargetTopicImpl targetTopic = new TargetTopicImpl();
        return targetTopic;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public WorkBookName createWorkBookName() {
        WorkBookNameImpl workBookName = new WorkBookNameImpl();
        return workBookName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public WorkSheetNumber createWorkSheetNumber() {
        WorkSheetNumberImpl workSheetNumber = new WorkSheetNumberImpl();
        return workSheetNumber;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Policy createPolicy() {
        PolicyImpl policy = new PolicyImpl();
        return policy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataServiceParameter createDataServiceParameter() {
        DataServiceParameterImpl dataServiceParameter = new DataServiceParameterImpl();
        return dataServiceParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RegistryKeyProperty createRegistryKeyProperty() {
        RegistryKeyPropertyImpl registryKeyProperty = new RegistryKeyPropertyImpl();
        return registryKeyProperty;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceStatus createServiceStatusFromString(EDataType eDataType, String initialValue) {
        ServiceStatus result = ServiceStatus.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertServiceStatusToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ServiceStatus createServiceStatusObjectFromString(EDataType eDataType,
	                                                         String initialValue) {
        return createServiceStatusFromString(DsPackage.Literals.SERVICE_STATUS, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertServiceStatusObjectToString(EDataType eDataType, Object instanceValue) {
        return convertServiceStatusToString(DsPackage.Literals.SERVICE_STATUS, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
        return (Map<?, ?>)super.createFromString(initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertMapToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DsPackage getDsPackage() {
        return (DsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static DsPackage getPackage() {
        return DsPackage.eINSTANCE;
    }

} // DsFactoryImpl
