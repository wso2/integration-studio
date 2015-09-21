/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.wso2.developerstudio.eclipse.ds.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage
 * @generated
 */
public class DsSwitch<T> extends Switch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static DsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DsSwitch() {
        if (modelPackage == null) {
            modelPackage = DsPackage.eINSTANCE;
        }
    }

	/**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case DsPackage.ATTRIBUTE_MAPPING: {
                AttributeMapping attributeMapping = (AttributeMapping)theEObject;
                T result = caseAttributeMapping(attributeMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.CALL_QUERY: {
                CallQuery callQuery = (CallQuery)theEObject;
                T result = caseCallQuery(callQuery);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.CALL_QUERY_LIST: {
                CallQueryList callQueryList = (CallQueryList)theEObject;
                T result = caseCallQueryList(callQueryList);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.CONFIGURATION_PROPERTY: {
                ConfigurationProperty configurationProperty = (ConfigurationProperty)theEObject;
                T result = caseConfigurationProperty(configurationProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.CUSTOM_VALIDATOR: {
                CustomValidator customValidator = (CustomValidator)theEObject;
                T result = caseCustomValidator(customValidator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.DATA_SERVICE: {
                DataService dataService = (DataService)theEObject;
                T result = caseDataService(dataService);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.DATA_SOURCE_CONFIGURATION: {
                DataSourceConfiguration dataSourceConfiguration = (DataSourceConfiguration)theEObject;
                T result = caseDataSourceConfiguration(dataSourceConfiguration);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.DESCRIPTION: {
                Description description = (Description)theEObject;
                T result = caseDescription(description);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.DOCUMENT_ROOT: {
                DocumentRoot documentRoot = (DocumentRoot)theEObject;
                T result = caseDocumentRoot(documentRoot);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.DOUBLE_RANGE_VALIDATOR: {
                DoubleRangeValidator doubleRangeValidator = (DoubleRangeValidator)theEObject;
                T result = caseDoubleRangeValidator(doubleRangeValidator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.ELEMENT_MAPPING: {
                ElementMapping elementMapping = (ElementMapping)theEObject;
                T result = caseElementMapping(elementMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.EVENT_SUBSCRIPTION_LIST: {
                EventSubscriptionList eventSubscriptionList = (EventSubscriptionList)theEObject;
                T result = caseEventSubscriptionList(eventSubscriptionList);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.EVENT_TRIGGER: {
                EventTrigger eventTrigger = (EventTrigger)theEObject;
                T result = caseEventTrigger(eventTrigger);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.EXCEL_QUERY: {
                ExcelQuery excelQuery = (ExcelQuery)theEObject;
                T result = caseExcelQuery(excelQuery);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.EXPRESSION: {
                Expression expression = (Expression)theEObject;
                T result = caseExpression(expression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.GSPREAD_QUERY: {
                GSpreadQuery gSpreadQuery = (GSpreadQuery)theEObject;
                T result = caseGSpreadQuery(gSpreadQuery);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.HAS_HEADER: {
                HasHeader hasHeader = (HasHeader)theEObject;
                T result = caseHasHeader(hasHeader);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.LENGTH_VALIDATOR: {
                LengthValidator lengthValidator = (LengthValidator)theEObject;
                T result = caseLengthValidator(lengthValidator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.LONG_RANGE_VALIDATOR: {
                LongRangeValidator longRangeValidator = (LongRangeValidator)theEObject;
                T result = caseLongRangeValidator(longRangeValidator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.MAX_ROW_COUNT: {
                MaxRowCount maxRowCount = (MaxRowCount)theEObject;
                T result = caseMaxRowCount(maxRowCount);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.OPERATION: {
                Operation operation = (Operation)theEObject;
                T result = caseOperation(operation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.PARAMETER_MAPPING: {
                ParameterMapping parameterMapping = (ParameterMapping)theEObject;
                T result = caseParameterMapping(parameterMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.PATTERN_VALIDATOR: {
                PatternValidator patternValidator = (PatternValidator)theEObject;
                T result = casePatternValidator(patternValidator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.QUERY: {
                Query query = (Query)theEObject;
                T result = caseQuery(query);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.QUERY_PARAMETER: {
                QueryParameter queryParameter = (QueryParameter)theEObject;
                T result = caseQueryParameter(queryParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.QUERY_PROPERTY: {
                QueryProperty queryProperty = (QueryProperty)theEObject;
                T result = caseQueryProperty(queryProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.QUERY_PROPERTY_LIST: {
                QueryPropertyList queryPropertyList = (QueryPropertyList)theEObject;
                T result = caseQueryPropertyList(queryPropertyList);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.RESOURCE: {
                Resource resource = (Resource)theEObject;
                T result = caseResource(resource);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.RESULT_MAPPING: {
                ResultMapping resultMapping = (ResultMapping)theEObject;
                T result = caseResultMapping(resultMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.SPARQL: {
                Sparql sparql = (Sparql)theEObject;
                T result = caseSparql(sparql);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.SQL: {
                Sql sql = (Sql)theEObject;
                T result = caseSql(sql);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.QUERY_EXPRESSION: {
                QueryExpression queryExpression = (QueryExpression)theEObject;
                T result = caseQueryExpression(queryExpression);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.STARTING_ROW: {
                StartingRow startingRow = (StartingRow)theEObject;
                T result = caseStartingRow(startingRow);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.SUBSCRIPTION: {
                Subscription subscription = (Subscription)theEObject;
                T result = caseSubscription(subscription);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.TARGET_TOPIC: {
                TargetTopic targetTopic = (TargetTopic)theEObject;
                T result = caseTargetTopic(targetTopic);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.WORK_BOOK_NAME: {
                WorkBookName workBookName = (WorkBookName)theEObject;
                T result = caseWorkBookName(workBookName);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.WORK_SHEET_NUMBER: {
                WorkSheetNumber workSheetNumber = (WorkSheetNumber)theEObject;
                T result = caseWorkSheetNumber(workSheetNumber);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.POLICY: {
                Policy policy = (Policy)theEObject;
                T result = casePolicy(policy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.DATA_SERVICE_PARAMETER: {
                DataServiceParameter dataServiceParameter = (DataServiceParameter)theEObject;
                T result = caseDataServiceParameter(dataServiceParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DsPackage.REGISTRY_KEY_PROPERTY: {
                RegistryKeyProperty registryKeyProperty = (RegistryKeyProperty)theEObject;
                T result = caseRegistryKeyProperty(registryKeyProperty);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAttributeMapping(AttributeMapping object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Call Query</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCallQuery(CallQuery object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Call Query List</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Query List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCallQueryList(CallQueryList object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Configuration Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Configuration Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConfigurationProperty(ConfigurationProperty object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Custom Validator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Custom Validator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCustomValidator(CustomValidator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Data Service</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDataService(DataService object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Data Source Configuration</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Source Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDataSourceConfiguration(DataSourceConfiguration object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Description</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDescription(Description object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDocumentRoot(DocumentRoot object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Double Range Validator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Double Range Validator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDoubleRangeValidator(DoubleRangeValidator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Element Mapping</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseElementMapping(ElementMapping object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Event Subscription List</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Subscription List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEventSubscriptionList(EventSubscriptionList object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Event Trigger</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEventTrigger(EventTrigger object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Excel Query</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Excel Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExcelQuery(ExcelQuery object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExpression(Expression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>GSpread Query</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>GSpread Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseGSpreadQuery(GSpreadQuery object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Has Header</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Has Header</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseHasHeader(HasHeader object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Length Validator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Length Validator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLengthValidator(LengthValidator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Long Range Validator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Long Range Validator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLongRangeValidator(LongRangeValidator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Max Row Count</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Max Row Count</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMaxRowCount(MaxRowCount object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOperation(Operation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Mapping</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseParameterMapping(ParameterMapping object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Pattern Validator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Pattern Validator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePatternValidator(PatternValidator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQuery(Query object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Query Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQueryParameter(QueryParameter object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Query Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQueryProperty(QueryProperty object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Query Property List</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Property List</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQueryPropertyList(QueryPropertyList object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseResource(Resource object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Result Mapping</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Result Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseResultMapping(ResultMapping object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sparql</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sparql</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSparql(Sparql object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sql</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sql</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSql(Sql object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Query Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQueryExpression(QueryExpression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Starting Row</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Starting Row</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStartingRow(StartingRow object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Subscription</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Subscription</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSubscription(Subscription object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Target Topic</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Target Topic</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTargetTopic(TargetTopic object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Work Book Name</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Work Book Name</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseWorkBookName(WorkBookName object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Work Sheet Number</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Work Sheet Number</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseWorkSheetNumber(WorkSheetNumber object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Policy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Policy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePolicy(Policy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Data Service Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Service Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDataServiceParameter(DataServiceParameter object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Registry Key Property</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Registry Key Property</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRegistryKeyProperty(RegistryKeyProperty object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the
	 * last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	@Override
	public T defaultCase(EObject object) {
        return null;
    }

} // DsSwitch
