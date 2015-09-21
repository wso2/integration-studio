/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.wso2.developerstudio.eclipse.ds.AttributeMapping;
import org.wso2.developerstudio.eclipse.ds.CallQuery;
import org.wso2.developerstudio.eclipse.ds.CallQueryList;
import org.wso2.developerstudio.eclipse.ds.ConfigurationProperty;
import org.wso2.developerstudio.eclipse.ds.CustomValidator;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.DataServiceParameter;
import org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration;
import org.wso2.developerstudio.eclipse.ds.Description;
import org.wso2.developerstudio.eclipse.ds.DocumentRoot;
import org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.ElementMapping;
import org.wso2.developerstudio.eclipse.ds.EventSubscriptionList;
import org.wso2.developerstudio.eclipse.ds.EventTrigger;
import org.wso2.developerstudio.eclipse.ds.ExcelQuery;
import org.wso2.developerstudio.eclipse.ds.Expression;
import org.wso2.developerstudio.eclipse.ds.GSpreadQuery;
import org.wso2.developerstudio.eclipse.ds.HasHeader;
import org.wso2.developerstudio.eclipse.ds.LengthValidator;
import org.wso2.developerstudio.eclipse.ds.LongRangeValidator;
import org.wso2.developerstudio.eclipse.ds.MaxRowCount;
import org.wso2.developerstudio.eclipse.ds.Operation;
import org.wso2.developerstudio.eclipse.ds.ParameterMapping;
import org.wso2.developerstudio.eclipse.ds.PatternValidator;
import org.wso2.developerstudio.eclipse.ds.Policy;
import org.wso2.developerstudio.eclipse.ds.Query;
import org.wso2.developerstudio.eclipse.ds.QueryExpression;
import org.wso2.developerstudio.eclipse.ds.QueryParameter;
import org.wso2.developerstudio.eclipse.ds.QueryProperty;
import org.wso2.developerstudio.eclipse.ds.QueryPropertyList;
import org.wso2.developerstudio.eclipse.ds.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.ds.Resource;
import org.wso2.developerstudio.eclipse.ds.ResultMapping;
import org.wso2.developerstudio.eclipse.ds.ServiceStatus;
import org.wso2.developerstudio.eclipse.ds.Sparql;
import org.wso2.developerstudio.eclipse.ds.Sql;
import org.wso2.developerstudio.eclipse.ds.StartingRow;
import org.wso2.developerstudio.eclipse.ds.Subscription;
import org.wso2.developerstudio.eclipse.ds.TargetTopic;
import org.wso2.developerstudio.eclipse.ds.WorkBookName;
import org.wso2.developerstudio.eclipse.ds.WorkSheetNumber;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DsPackageImpl extends EPackageImpl implements DsPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass attributeMappingEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass callQueryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass callQueryListEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass configurationPropertyEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass customValidatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass dataServiceEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass dataSourceConfigurationEClass = null;

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
	private EClass documentRootEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass doubleRangeValidatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass elementMappingEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass eventSubscriptionListEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass eventTriggerEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass excelQueryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass expressionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass gSpreadQueryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass hasHeaderEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass lengthValidatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass longRangeValidatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass maxRowCountEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass operationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass parameterMappingEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass patternValidatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass queryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass queryParameterEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass queryPropertyEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass queryPropertyListEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass resourceEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass resultMappingEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass sparqlEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass sqlEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass queryExpressionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass startingRowEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass subscriptionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass targetTopicEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass workBookNameEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass workSheetNumberEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass policyEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass dataServiceParameterEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass registryKeyPropertyEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum serviceStatusEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType serviceStatusObjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType mapEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DsPackageImpl() {
        super(eNS_URI, DsFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link DsPackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DsPackage init() {
        if (isInited) return (DsPackage)EPackage.Registry.INSTANCE.getEPackage(DsPackage.eNS_URI);

        // Obtain or create and register package
        DsPackageImpl theDsPackage = (DsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DsPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theDsPackage.createPackageContents();

        // Initialize created meta-data
        theDsPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theDsPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(DsPackage.eNS_URI, theDsPackage);
        return theDsPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAttributeMapping() {
        return attributeMappingEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeMapping_Column() {
        return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeMapping_Name() {
        return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeMapping_RequiredRoles() {
        return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeMapping_XsdType() {
        return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAttributeMapping_Optional() {
        return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCallQuery() {
        return callQueryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCallQuery_Mixed() {
        return (EAttribute)callQueryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCallQuery_WithParam() {
        return (EReference)callQueryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCallQuery_Href() {
        return (EAttribute)callQueryEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCallQueryList() {
        return callQueryListEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCallQueryList_Mixed() {
        return (EAttribute)callQueryListEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCallQueryList_CallQuery() {
        return (EReference)callQueryListEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getConfigurationProperty() {
        return configurationPropertyEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConfigurationProperty_Value() {
        return (EAttribute)configurationPropertyEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getConfigurationProperty_Name() {
        return (EAttribute)configurationPropertyEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCustomValidator() {
        return customValidatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCustomValidator_Class() {
        return (EAttribute)customValidatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDataService() {
        return dataServiceEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_Mixed() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_Description() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_Config() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_Query() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_EventTrigger() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_Operation() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_Resource() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_BaseURI() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_EnableBatchRequests() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_EnableBoxcarring() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(9);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_EnableDTP() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(10);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_Name() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(11);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_ServiceGroup() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(12);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_ServiceNamespace() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(13);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_ServiceStatus() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(14);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_DisableStreaming() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(15);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_EnableSec() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(16);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_Policy() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(17);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataService_Transports() {
        return (EAttribute)dataServiceEClass.getEStructuralFeatures().get(18);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataService_FeatureAllowRoles() {
        return (EReference)dataServiceEClass.getEStructuralFeatures().get(19);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDataSourceConfiguration() {
        return dataSourceConfigurationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataSourceConfiguration_Mixed() {
        return (EAttribute)dataSourceConfigurationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataSourceConfiguration_Property() {
        return (EReference)dataSourceConfigurationEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataSourceConfiguration_Id() {
        return (EAttribute)dataSourceConfigurationEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getDescription_Value() {
        return (EAttribute)descriptionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDocumentRoot() {
        return documentRootEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_CallQuery() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Data() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Hasheader() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Maxrowcount() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Property() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Sql() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDocumentRoot_Startingrow() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDoubleRangeValidator() {
        return doubleRangeValidatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDoubleRangeValidator_Maximum() {
        return (EAttribute)doubleRangeValidatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDoubleRangeValidator_Minimum() {
        return (EAttribute)doubleRangeValidatorEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getElementMapping() {
        return elementMappingEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_Mixed() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_Column() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_Export() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_Name() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_RequiredRoles() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_ExportType() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_Namespace() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_XsdType() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getElementMapping_Element() {
        return (EReference)elementMappingEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getElementMapping_Attribute() {
        return (EReference)elementMappingEClass.getEStructuralFeatures().get(9);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getElementMapping_CallQuery() {
        return (EReference)elementMappingEClass.getEStructuralFeatures().get(10);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_IsComplexType() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(11);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_QueryParam() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(12);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_Value() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(13);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_Optional() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(14);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getElementMapping_ArrayName() {
        return (EAttribute)elementMappingEClass.getEStructuralFeatures().get(15);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEventSubscriptionList() {
        return eventSubscriptionListEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEventSubscriptionList_Mixed() {
        return (EAttribute)eventSubscriptionListEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEventSubscriptionList_Subscription() {
        return (EReference)eventSubscriptionListEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEventTrigger() {
        return eventTriggerEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEventTrigger_Mixed() {
        return (EAttribute)eventTriggerEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEventTrigger_Expression() {
        return (EReference)eventTriggerEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEventTrigger_TargetTopic() {
        return (EReference)eventTriggerEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEventTrigger_Subscriptions() {
        return (EReference)eventTriggerEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEventTrigger_Id() {
        return (EAttribute)eventTriggerEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEventTrigger_Language() {
        return (EAttribute)eventTriggerEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getExcelQuery() {
        return excelQueryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getExcelQuery_Mixed() {
        return (EAttribute)excelQueryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExcelQuery_Workbookname() {
        return (EReference)excelQueryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExcelQuery_Hasheader() {
        return (EReference)excelQueryEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExcelQuery_Startingrow() {
        return (EReference)excelQueryEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExcelQuery_Maxrowcount() {
        return (EReference)excelQueryEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getExpression() {
        return expressionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getExpression_Value() {
        return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getGSpreadQuery() {
        return gSpreadQueryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getGSpreadQuery_Mixed() {
        return (EAttribute)gSpreadQueryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGSpreadQuery_Worksheetnumber() {
        return (EReference)gSpreadQueryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGSpreadQuery_Startingrow() {
        return (EReference)gSpreadQueryEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGSpreadQuery_Maxrowcount() {
        return (EReference)gSpreadQueryEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getGSpreadQuery_Hasheader() {
        return (EReference)gSpreadQueryEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getHasHeader() {
        return hasHeaderEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getHasHeader_Value() {
        return (EAttribute)hasHeaderEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLengthValidator() {
        return lengthValidatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLengthValidator_Maximum() {
        return (EAttribute)lengthValidatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLengthValidator_Minimum() {
        return (EAttribute)lengthValidatorEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLongRangeValidator() {
        return longRangeValidatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLongRangeValidator_Maximum() {
        return (EAttribute)longRangeValidatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLongRangeValidator_Minimum() {
        return (EAttribute)longRangeValidatorEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMaxRowCount() {
        return maxRowCountEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMaxRowCount_Value() {
        return (EAttribute)maxRowCountEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOperation() {
        return operationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOperation_Mixed() {
        return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperation_CallQuery() {
        return (EReference)operationEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperation_CallQueryGroup() {
        return (EReference)operationEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOperation_DisableStreaming() {
        return (EAttribute)operationEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOperation_ReturnRequestStatus() {
        return (EAttribute)operationEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOperation_Name() {
        return (EAttribute)operationEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getParameterMapping() {
        return parameterMappingEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getParameterMapping_Column() {
        return (EAttribute)parameterMappingEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getParameterMapping_Name() {
        return (EAttribute)parameterMappingEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getParameterMapping_QueryParam() {
        return (EAttribute)parameterMappingEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPatternValidator() {
        return patternValidatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPatternValidator_Pattern() {
        return (EAttribute)patternValidatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getQuery() {
        return queryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQuery_Mixed() {
        return (EAttribute)queryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Expression() {
        return (EReference)queryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Sql() {
        return (EReference)queryEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Sparql() {
        return (EReference)queryEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Properties() {
        return (EReference)queryEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Result() {
        return (EReference)queryEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Excel() {
        return (EReference)queryEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Gspread() {
        return (EReference)queryEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQuery_Param() {
        return (EReference)queryEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQuery_Id() {
        return (EAttribute)queryEClass.getEStructuralFeatures().get(9);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQuery_InputEventTrigger() {
        return (EAttribute)queryEClass.getEStructuralFeatures().get(10);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQuery_OutputEventTrigger() {
        return (EAttribute)queryEClass.getEStructuralFeatures().get(11);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQuery_ReturnGeneratedKeys() {
        return (EAttribute)queryEClass.getEStructuralFeatures().get(12);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQuery_UseConfig() {
        return (EAttribute)queryEClass.getEStructuralFeatures().get(13);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQuery_KeyColumns() {
        return (EAttribute)queryEClass.getEStructuralFeatures().get(14);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getQueryParameter() {
        return queryParameterEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_Mixed() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQueryParameter_ValidateLongRange() {
        return (EReference)queryParameterEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQueryParameter_ValidateDoubleRange() {
        return (EReference)queryParameterEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQueryParameter_ValidateLength() {
        return (EReference)queryParameterEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQueryParameter_ValidatePattern() {
        return (EReference)queryParameterEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQueryParameter_ValidateCustom() {
        return (EReference)queryParameterEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_DefaultValue() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_Name() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_Ordinal() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_ParamType() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(9);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_SqlType() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(10);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_StructType() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(11);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryParameter_Type() {
        return (EAttribute)queryParameterEClass.getEStructuralFeatures().get(12);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getQueryProperty() {
        return queryPropertyEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryProperty_Value() {
        return (EAttribute)queryPropertyEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryProperty_Name() {
        return (EAttribute)queryPropertyEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getQueryPropertyList() {
        return queryPropertyListEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryPropertyList_Mixed() {
        return (EAttribute)queryPropertyListEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getQueryPropertyList_Property() {
        return (EReference)queryPropertyListEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getResource() {
        return resourceEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResource_Mixed() {
        return (EAttribute)resourceEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getResource_CallQuery() {
        return (EReference)resourceEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResource_Method() {
        return (EAttribute)resourceEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResource_Path() {
        return (EAttribute)resourceEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResource_ReturnRequestStatus() {
        return (EAttribute)resourceEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getResultMapping() {
        return resultMappingEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResultMapping_Mixed() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getResultMapping_Element() {
        return (EReference)resultMappingEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getResultMapping_Attribute() {
        return (EReference)resultMappingEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getResultMapping_CallQuery() {
        return (EReference)resultMappingEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResultMapping_DefaultNamespace() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResultMapping_ElementName() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResultMapping_RowName() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResultMapping_UseColumnNumbers() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResultMapping_EscapeNonPrintableChar() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getResultMapping_XsltPath() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(9);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getResultMapping_OutputType() {
        return (EAttribute)resultMappingEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSparql() {
        return sparqlEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSparql_Value() {
        return (EAttribute)sparqlEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSql() {
        return sqlEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSql_Value() {
        return (EAttribute)sqlEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSql_Dialect() {
        return (EAttribute)sqlEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getQueryExpression() {
        return queryExpressionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getQueryExpression_Value() {
        return (EAttribute)queryExpressionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getStartingRow() {
        return startingRowEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getStartingRow_Value() {
        return (EAttribute)startingRowEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSubscription() {
        return subscriptionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSubscription_Value() {
        return (EAttribute)subscriptionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTargetTopic() {
        return targetTopicEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTargetTopic_Value() {
        return (EAttribute)targetTopicEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getWorkBookName() {
        return workBookNameEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getWorkBookName_Value() {
        return (EAttribute)workBookNameEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getWorkSheetNumber() {
        return workSheetNumberEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getWorkSheetNumber_Value() {
        return (EAttribute)workSheetNumberEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPolicy() {
        return policyEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPolicy_Key() {
        return (EAttribute)policyEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDataServiceParameter() {
        return dataServiceParameterEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataServiceParameter_Name() {
        return (EAttribute)dataServiceParameterEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDataServiceParameter_Value() {
        return (EAttribute)dataServiceParameterEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRegistryKeyProperty() {
        return registryKeyPropertyEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRegistryKeyProperty_Key() {
        return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getServiceStatus() {
        return serviceStatusEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getServiceStatusObject() {
        return serviceStatusObjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getMap() {
        return mapEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DsFactory getDsFactory() {
        return (DsFactory)getEFactoryInstance();
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
        attributeMappingEClass = createEClass(ATTRIBUTE_MAPPING);
        createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__COLUMN);
        createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__NAME);
        createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__REQUIRED_ROLES);
        createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__XSD_TYPE);
        createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__OPTIONAL);

        callQueryEClass = createEClass(CALL_QUERY);
        createEAttribute(callQueryEClass, CALL_QUERY__MIXED);
        createEReference(callQueryEClass, CALL_QUERY__WITH_PARAM);
        createEAttribute(callQueryEClass, CALL_QUERY__HREF);

        callQueryListEClass = createEClass(CALL_QUERY_LIST);
        createEAttribute(callQueryListEClass, CALL_QUERY_LIST__MIXED);
        createEReference(callQueryListEClass, CALL_QUERY_LIST__CALL_QUERY);

        configurationPropertyEClass = createEClass(CONFIGURATION_PROPERTY);
        createEAttribute(configurationPropertyEClass, CONFIGURATION_PROPERTY__VALUE);
        createEAttribute(configurationPropertyEClass, CONFIGURATION_PROPERTY__NAME);

        customValidatorEClass = createEClass(CUSTOM_VALIDATOR);
        createEAttribute(customValidatorEClass, CUSTOM_VALIDATOR__CLASS);

        dataServiceEClass = createEClass(DATA_SERVICE);
        createEAttribute(dataServiceEClass, DATA_SERVICE__MIXED);
        createEReference(dataServiceEClass, DATA_SERVICE__DESCRIPTION);
        createEReference(dataServiceEClass, DATA_SERVICE__CONFIG);
        createEReference(dataServiceEClass, DATA_SERVICE__QUERY);
        createEReference(dataServiceEClass, DATA_SERVICE__EVENT_TRIGGER);
        createEReference(dataServiceEClass, DATA_SERVICE__OPERATION);
        createEReference(dataServiceEClass, DATA_SERVICE__RESOURCE);
        createEAttribute(dataServiceEClass, DATA_SERVICE__BASE_URI);
        createEAttribute(dataServiceEClass, DATA_SERVICE__ENABLE_BATCH_REQUESTS);
        createEAttribute(dataServiceEClass, DATA_SERVICE__ENABLE_BOXCARRING);
        createEAttribute(dataServiceEClass, DATA_SERVICE__ENABLE_DTP);
        createEAttribute(dataServiceEClass, DATA_SERVICE__NAME);
        createEAttribute(dataServiceEClass, DATA_SERVICE__SERVICE_GROUP);
        createEAttribute(dataServiceEClass, DATA_SERVICE__SERVICE_NAMESPACE);
        createEAttribute(dataServiceEClass, DATA_SERVICE__SERVICE_STATUS);
        createEAttribute(dataServiceEClass, DATA_SERVICE__DISABLE_STREAMING);
        createEAttribute(dataServiceEClass, DATA_SERVICE__ENABLE_SEC);
        createEReference(dataServiceEClass, DATA_SERVICE__POLICY);
        createEAttribute(dataServiceEClass, DATA_SERVICE__TRANSPORTS);
        createEReference(dataServiceEClass, DATA_SERVICE__FEATURE_ALLOW_ROLES);

        dataSourceConfigurationEClass = createEClass(DATA_SOURCE_CONFIGURATION);
        createEAttribute(dataSourceConfigurationEClass, DATA_SOURCE_CONFIGURATION__MIXED);
        createEReference(dataSourceConfigurationEClass, DATA_SOURCE_CONFIGURATION__PROPERTY);
        createEAttribute(dataSourceConfigurationEClass, DATA_SOURCE_CONFIGURATION__ID);

        descriptionEClass = createEClass(DESCRIPTION);
        createEAttribute(descriptionEClass, DESCRIPTION__VALUE);

        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__CALL_QUERY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__DATA);
        createEReference(documentRootEClass, DOCUMENT_ROOT__HASHEADER);
        createEReference(documentRootEClass, DOCUMENT_ROOT__MAXROWCOUNT);
        createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY);
        createEReference(documentRootEClass, DOCUMENT_ROOT__SQL);
        createEReference(documentRootEClass, DOCUMENT_ROOT__STARTINGROW);

        doubleRangeValidatorEClass = createEClass(DOUBLE_RANGE_VALIDATOR);
        createEAttribute(doubleRangeValidatorEClass, DOUBLE_RANGE_VALIDATOR__MAXIMUM);
        createEAttribute(doubleRangeValidatorEClass, DOUBLE_RANGE_VALIDATOR__MINIMUM);

        elementMappingEClass = createEClass(ELEMENT_MAPPING);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__MIXED);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__COLUMN);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__EXPORT);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__NAME);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__REQUIRED_ROLES);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__EXPORT_TYPE);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__NAMESPACE);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__XSD_TYPE);
        createEReference(elementMappingEClass, ELEMENT_MAPPING__ELEMENT);
        createEReference(elementMappingEClass, ELEMENT_MAPPING__ATTRIBUTE);
        createEReference(elementMappingEClass, ELEMENT_MAPPING__CALL_QUERY);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__IS_COMPLEX_TYPE);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__QUERY_PARAM);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__VALUE);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__OPTIONAL);
        createEAttribute(elementMappingEClass, ELEMENT_MAPPING__ARRAY_NAME);

        eventSubscriptionListEClass = createEClass(EVENT_SUBSCRIPTION_LIST);
        createEAttribute(eventSubscriptionListEClass, EVENT_SUBSCRIPTION_LIST__MIXED);
        createEReference(eventSubscriptionListEClass, EVENT_SUBSCRIPTION_LIST__SUBSCRIPTION);

        eventTriggerEClass = createEClass(EVENT_TRIGGER);
        createEAttribute(eventTriggerEClass, EVENT_TRIGGER__MIXED);
        createEReference(eventTriggerEClass, EVENT_TRIGGER__EXPRESSION);
        createEReference(eventTriggerEClass, EVENT_TRIGGER__TARGET_TOPIC);
        createEReference(eventTriggerEClass, EVENT_TRIGGER__SUBSCRIPTIONS);
        createEAttribute(eventTriggerEClass, EVENT_TRIGGER__ID);
        createEAttribute(eventTriggerEClass, EVENT_TRIGGER__LANGUAGE);

        excelQueryEClass = createEClass(EXCEL_QUERY);
        createEAttribute(excelQueryEClass, EXCEL_QUERY__MIXED);
        createEReference(excelQueryEClass, EXCEL_QUERY__WORKBOOKNAME);
        createEReference(excelQueryEClass, EXCEL_QUERY__HASHEADER);
        createEReference(excelQueryEClass, EXCEL_QUERY__STARTINGROW);
        createEReference(excelQueryEClass, EXCEL_QUERY__MAXROWCOUNT);

        expressionEClass = createEClass(EXPRESSION);
        createEAttribute(expressionEClass, EXPRESSION__VALUE);

        gSpreadQueryEClass = createEClass(GSPREAD_QUERY);
        createEAttribute(gSpreadQueryEClass, GSPREAD_QUERY__MIXED);
        createEReference(gSpreadQueryEClass, GSPREAD_QUERY__WORKSHEETNUMBER);
        createEReference(gSpreadQueryEClass, GSPREAD_QUERY__STARTINGROW);
        createEReference(gSpreadQueryEClass, GSPREAD_QUERY__MAXROWCOUNT);
        createEReference(gSpreadQueryEClass, GSPREAD_QUERY__HASHEADER);

        hasHeaderEClass = createEClass(HAS_HEADER);
        createEAttribute(hasHeaderEClass, HAS_HEADER__VALUE);

        lengthValidatorEClass = createEClass(LENGTH_VALIDATOR);
        createEAttribute(lengthValidatorEClass, LENGTH_VALIDATOR__MAXIMUM);
        createEAttribute(lengthValidatorEClass, LENGTH_VALIDATOR__MINIMUM);

        longRangeValidatorEClass = createEClass(LONG_RANGE_VALIDATOR);
        createEAttribute(longRangeValidatorEClass, LONG_RANGE_VALIDATOR__MAXIMUM);
        createEAttribute(longRangeValidatorEClass, LONG_RANGE_VALIDATOR__MINIMUM);

        maxRowCountEClass = createEClass(MAX_ROW_COUNT);
        createEAttribute(maxRowCountEClass, MAX_ROW_COUNT__VALUE);

        operationEClass = createEClass(OPERATION);
        createEAttribute(operationEClass, OPERATION__MIXED);
        createEReference(operationEClass, OPERATION__CALL_QUERY);
        createEReference(operationEClass, OPERATION__CALL_QUERY_GROUP);
        createEAttribute(operationEClass, OPERATION__DISABLE_STREAMING);
        createEAttribute(operationEClass, OPERATION__RETURN_REQUEST_STATUS);
        createEAttribute(operationEClass, OPERATION__NAME);

        parameterMappingEClass = createEClass(PARAMETER_MAPPING);
        createEAttribute(parameterMappingEClass, PARAMETER_MAPPING__COLUMN);
        createEAttribute(parameterMappingEClass, PARAMETER_MAPPING__NAME);
        createEAttribute(parameterMappingEClass, PARAMETER_MAPPING__QUERY_PARAM);

        patternValidatorEClass = createEClass(PATTERN_VALIDATOR);
        createEAttribute(patternValidatorEClass, PATTERN_VALIDATOR__PATTERN);

        queryEClass = createEClass(QUERY);
        createEAttribute(queryEClass, QUERY__MIXED);
        createEReference(queryEClass, QUERY__EXPRESSION);
        createEReference(queryEClass, QUERY__SQL);
        createEReference(queryEClass, QUERY__SPARQL);
        createEReference(queryEClass, QUERY__PROPERTIES);
        createEReference(queryEClass, QUERY__RESULT);
        createEReference(queryEClass, QUERY__EXCEL);
        createEReference(queryEClass, QUERY__GSPREAD);
        createEReference(queryEClass, QUERY__PARAM);
        createEAttribute(queryEClass, QUERY__ID);
        createEAttribute(queryEClass, QUERY__INPUT_EVENT_TRIGGER);
        createEAttribute(queryEClass, QUERY__OUTPUT_EVENT_TRIGGER);
        createEAttribute(queryEClass, QUERY__RETURN_GENERATED_KEYS);
        createEAttribute(queryEClass, QUERY__USE_CONFIG);
        createEAttribute(queryEClass, QUERY__KEY_COLUMNS);

        queryParameterEClass = createEClass(QUERY_PARAMETER);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__MIXED);
        createEReference(queryParameterEClass, QUERY_PARAMETER__VALIDATE_LONG_RANGE);
        createEReference(queryParameterEClass, QUERY_PARAMETER__VALIDATE_DOUBLE_RANGE);
        createEReference(queryParameterEClass, QUERY_PARAMETER__VALIDATE_LENGTH);
        createEReference(queryParameterEClass, QUERY_PARAMETER__VALIDATE_PATTERN);
        createEReference(queryParameterEClass, QUERY_PARAMETER__VALIDATE_CUSTOM);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__DEFAULT_VALUE);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__NAME);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__ORDINAL);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__PARAM_TYPE);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__SQL_TYPE);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__STRUCT_TYPE);
        createEAttribute(queryParameterEClass, QUERY_PARAMETER__TYPE);

        queryPropertyEClass = createEClass(QUERY_PROPERTY);
        createEAttribute(queryPropertyEClass, QUERY_PROPERTY__VALUE);
        createEAttribute(queryPropertyEClass, QUERY_PROPERTY__NAME);

        queryPropertyListEClass = createEClass(QUERY_PROPERTY_LIST);
        createEAttribute(queryPropertyListEClass, QUERY_PROPERTY_LIST__MIXED);
        createEReference(queryPropertyListEClass, QUERY_PROPERTY_LIST__PROPERTY);

        resourceEClass = createEClass(RESOURCE);
        createEAttribute(resourceEClass, RESOURCE__MIXED);
        createEReference(resourceEClass, RESOURCE__CALL_QUERY);
        createEAttribute(resourceEClass, RESOURCE__METHOD);
        createEAttribute(resourceEClass, RESOURCE__PATH);
        createEAttribute(resourceEClass, RESOURCE__RETURN_REQUEST_STATUS);

        resultMappingEClass = createEClass(RESULT_MAPPING);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__MIXED);
        createEReference(resultMappingEClass, RESULT_MAPPING__ELEMENT);
        createEReference(resultMappingEClass, RESULT_MAPPING__ATTRIBUTE);
        createEReference(resultMappingEClass, RESULT_MAPPING__CALL_QUERY);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__DEFAULT_NAMESPACE);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__ELEMENT_NAME);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__ROW_NAME);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__USE_COLUMN_NUMBERS);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__ESCAPE_NON_PRINTABLE_CHAR);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__XSLT_PATH);
        createEAttribute(resultMappingEClass, RESULT_MAPPING__OUTPUT_TYPE);

        sparqlEClass = createEClass(SPARQL);
        createEAttribute(sparqlEClass, SPARQL__VALUE);

        sqlEClass = createEClass(SQL);
        createEAttribute(sqlEClass, SQL__VALUE);
        createEAttribute(sqlEClass, SQL__DIALECT);

        queryExpressionEClass = createEClass(QUERY_EXPRESSION);
        createEAttribute(queryExpressionEClass, QUERY_EXPRESSION__VALUE);

        startingRowEClass = createEClass(STARTING_ROW);
        createEAttribute(startingRowEClass, STARTING_ROW__VALUE);

        subscriptionEClass = createEClass(SUBSCRIPTION);
        createEAttribute(subscriptionEClass, SUBSCRIPTION__VALUE);

        targetTopicEClass = createEClass(TARGET_TOPIC);
        createEAttribute(targetTopicEClass, TARGET_TOPIC__VALUE);

        workBookNameEClass = createEClass(WORK_BOOK_NAME);
        createEAttribute(workBookNameEClass, WORK_BOOK_NAME__VALUE);

        workSheetNumberEClass = createEClass(WORK_SHEET_NUMBER);
        createEAttribute(workSheetNumberEClass, WORK_SHEET_NUMBER__VALUE);

        policyEClass = createEClass(POLICY);
        createEAttribute(policyEClass, POLICY__KEY);

        dataServiceParameterEClass = createEClass(DATA_SERVICE_PARAMETER);
        createEAttribute(dataServiceParameterEClass, DATA_SERVICE_PARAMETER__NAME);
        createEAttribute(dataServiceParameterEClass, DATA_SERVICE_PARAMETER__VALUE);

        registryKeyPropertyEClass = createEClass(REGISTRY_KEY_PROPERTY);
        createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__KEY);

        // Create enums
        serviceStatusEEnum = createEEnum(SERVICE_STATUS);

        // Create data types
        serviceStatusObjectEDataType = createEDataType(SERVICE_STATUS_OBJECT);
        mapEDataType = createEDataType(MAP);
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

        // Create type parameters
        addETypeParameter(mapEDataType, "K");
        addETypeParameter(mapEDataType, "V");

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(attributeMappingEClass, AttributeMapping.class, "AttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttributeMapping_Column(), theXMLTypePackage.getString(), "column", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeMapping_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeMapping_RequiredRoles(), theXMLTypePackage.getString(), "requiredRoles", null, 0, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeMapping_XsdType(), theXMLTypePackage.getString(), "xsdType", null, 0, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeMapping_Optional(), ecorePackage.getEBoolean(), "optional", "false", 0, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(callQueryEClass, CallQuery.class, "CallQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCallQuery_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, CallQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCallQuery_WithParam(), this.getParameterMapping(), null, "withParam", null, 0, -1, CallQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getCallQuery_Href(), theXMLTypePackage.getString(), "href", null, 1, 1, CallQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(callQueryListEClass, CallQueryList.class, "CallQueryList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCallQueryList_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, CallQueryList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCallQueryList_CallQuery(), this.getCallQuery(), null, "callQuery", null, 1, -1, CallQueryList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(configurationPropertyEClass, ConfigurationProperty.class, "ConfigurationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConfigurationProperty_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ConfigurationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConfigurationProperty_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ConfigurationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(customValidatorEClass, CustomValidator.class, "CustomValidator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCustomValidator_Class(), theXMLTypePackage.getString(), "class", null, 1, 1, CustomValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataServiceEClass, DataService.class, "DataService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDataService_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_Description(), this.getDescription(), null, "description", null, 1, 1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_Config(), this.getDataSourceConfiguration(), null, "config", null, 0, -1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_Query(), this.getQuery(), null, "query", null, 0, -1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_EventTrigger(), this.getEventTrigger(), null, "eventTrigger", null, 0, -1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_Operation(), this.getOperation(), null, "operation", null, 0, -1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_Resource(), this.getResource(), null, "resource", null, 0, -1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_BaseURI(), theXMLTypePackage.getString(), "baseURI", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_EnableBatchRequests(), theXMLTypePackage.getBoolean(), "enableBatchRequests", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_EnableBoxcarring(), theXMLTypePackage.getBoolean(), "enableBoxcarring", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_EnableDTP(), theXMLTypePackage.getBoolean(), "enableDTP", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_ServiceGroup(), theXMLTypePackage.getString(), "serviceGroup", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_ServiceNamespace(), theXMLTypePackage.getString(), "serviceNamespace", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_ServiceStatus(), this.getServiceStatus(), "serviceStatus", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_DisableStreaming(), theXMLTypePackage.getBoolean(), "disableStreaming", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_EnableSec(), theXMLTypePackage.getBoolean(), "enableSec", null, 0, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_Policy(), this.getRegistryKeyProperty(), null, "policy", null, 1, 1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataService_Transports(), theXMLTypePackage.getString(), "transports", null, 1, 1, DataService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataService_FeatureAllowRoles(), this.getDataServiceParameter(), null, "featureAllowRoles", null, 1, 1, DataService.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(dataSourceConfigurationEClass, DataSourceConfiguration.class, "DataSourceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDataSourceConfiguration_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, DataSourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDataSourceConfiguration_Property(), this.getConfigurationProperty(), null, "property", null, 1, -1, DataSourceConfiguration.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataSourceConfiguration_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, DataSourceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDescription_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_CallQuery(), this.getCallQuery(), null, "callQuery", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Data(), this.getDataService(), null, "data", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Hasheader(), this.getHasHeader(), null, "hasheader", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Maxrowcount(), this.getMaxRowCount(), null, "maxrowcount", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Property(), this.getConfigurationProperty(), null, "property", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Sql(), this.getSql(), null, "sql", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Startingrow(), this.getStartingRow(), null, "startingrow", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(doubleRangeValidatorEClass, DoubleRangeValidator.class, "DoubleRangeValidator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDoubleRangeValidator_Maximum(), theXMLTypePackage.getDouble(), "maximum", null, 0, 1, DoubleRangeValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDoubleRangeValidator_Minimum(), theXMLTypePackage.getDouble(), "minimum", null, 0, 1, DoubleRangeValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(elementMappingEClass, ElementMapping.class, "ElementMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getElementMapping_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_Column(), theXMLTypePackage.getString(), "column", null, 1, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_Export(), theXMLTypePackage.getString(), "export", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_RequiredRoles(), theXMLTypePackage.getString(), "requiredRoles", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_ExportType(), theXMLTypePackage.getString(), "exportType", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_Namespace(), theXMLTypePackage.getString(), "namespace", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_XsdType(), theXMLTypePackage.getString(), "xsdType", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getElementMapping_Element(), this.getElementMapping(), null, "element", null, 0, -1, ElementMapping.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getElementMapping_Attribute(), this.getAttributeMapping(), null, "attribute", null, 0, -1, ElementMapping.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getElementMapping_CallQuery(), this.getCallQuery(), null, "callQuery", null, 0, 1, ElementMapping.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_IsComplexType(), ecorePackage.getEBoolean(), "isComplexType", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_QueryParam(), theXMLTypePackage.getString(), "queryParam", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_Optional(), ecorePackage.getEBoolean(), "optional", "false", 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getElementMapping_ArrayName(), theXMLTypePackage.getString(), "arrayName", null, 0, 1, ElementMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eventSubscriptionListEClass, EventSubscriptionList.class, "EventSubscriptionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEventSubscriptionList_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, EventSubscriptionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEventSubscriptionList_Subscription(), this.getSubscription(), null, "subscription", null, 1, -1, EventSubscriptionList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(eventTriggerEClass, EventTrigger.class, "EventTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEventTrigger_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, EventTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEventTrigger_Expression(), this.getExpression(), null, "expression", null, 1, 1, EventTrigger.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getEventTrigger_TargetTopic(), this.getTargetTopic(), null, "targetTopic", null, 1, 1, EventTrigger.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getEventTrigger_Subscriptions(), this.getEventSubscriptionList(), null, "subscriptions", null, 1, 1, EventTrigger.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getEventTrigger_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, EventTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEventTrigger_Language(), theXMLTypePackage.getString(), "language", null, 0, 1, EventTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(excelQueryEClass, ExcelQuery.class, "ExcelQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExcelQuery_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ExcelQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getExcelQuery_Workbookname(), this.getWorkBookName(), null, "workbookname", null, 1, 1, ExcelQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getExcelQuery_Hasheader(), this.getHasHeader(), null, "hasheader", null, 1, 1, ExcelQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getExcelQuery_Startingrow(), this.getStartingRow(), null, "startingrow", null, 1, 1, ExcelQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getExcelQuery_Maxrowcount(), this.getMaxRowCount(), null, "maxrowcount", null, 1, 1, ExcelQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExpression_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(gSpreadQueryEClass, GSpreadQuery.class, "GSpreadQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getGSpreadQuery_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, GSpreadQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getGSpreadQuery_Worksheetnumber(), this.getWorkSheetNumber(), null, "worksheetnumber", null, 1, 1, GSpreadQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getGSpreadQuery_Startingrow(), this.getStartingRow(), null, "startingrow", null, 1, 1, GSpreadQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getGSpreadQuery_Maxrowcount(), this.getMaxRowCount(), null, "maxrowcount", null, 1, 1, GSpreadQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getGSpreadQuery_Hasheader(), this.getHasHeader(), null, "hasheader", null, 1, 1, GSpreadQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(hasHeaderEClass, HasHeader.class, "HasHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHasHeader_Value(), theXMLTypePackage.getBoolean(), "value", null, 0, 1, HasHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(lengthValidatorEClass, LengthValidator.class, "LengthValidator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLengthValidator_Maximum(), theXMLTypePackage.getLong(), "maximum", null, 0, 1, LengthValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLengthValidator_Minimum(), theXMLTypePackage.getLong(), "minimum", null, 0, 1, LengthValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(longRangeValidatorEClass, LongRangeValidator.class, "LongRangeValidator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLongRangeValidator_Maximum(), theXMLTypePackage.getLong(), "maximum", null, 0, 1, LongRangeValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLongRangeValidator_Minimum(), theXMLTypePackage.getLong(), "minimum", null, 0, 1, LongRangeValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(maxRowCountEClass, MaxRowCount.class, "MaxRowCount", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMaxRowCount_Value(), theXMLTypePackage.getLong(), "value", null, 0, 1, MaxRowCount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperation_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperation_CallQuery(), this.getCallQuery(), null, "callQuery", null, 0, 1, Operation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getOperation_CallQueryGroup(), this.getCallQueryList(), null, "callQueryGroup", null, 0, 1, Operation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperation_DisableStreaming(), theXMLTypePackage.getBoolean(), "disableStreaming", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperation_ReturnRequestStatus(), theXMLTypePackage.getBoolean(), "returnRequestStatus", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOperation_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(parameterMappingEClass, ParameterMapping.class, "ParameterMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getParameterMapping_Column(), theXMLTypePackage.getString(), "column", null, 0, 1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParameterMapping_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParameterMapping_QueryParam(), theXMLTypePackage.getString(), "queryParam", null, 0, 1, ParameterMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(patternValidatorEClass, PatternValidator.class, "PatternValidator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPatternValidator_Pattern(), theXMLTypePackage.getString(), "pattern", null, 1, 1, PatternValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(queryEClass, Query.class, "Query", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQuery_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Expression(), this.getQueryExpression(), null, "expression", null, 0, -1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Sql(), this.getSql(), null, "sql", null, 0, -1, Query.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Sparql(), this.getSparql(), null, "sparql", null, 0, -1, Query.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Properties(), this.getQueryPropertyList(), null, "properties", null, 0, -1, Query.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Result(), this.getResultMapping(), null, "result", null, 0, 1, Query.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Excel(), this.getExcelQuery(), null, "excel", null, 0, -1, Query.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Gspread(), this.getGSpreadQuery(), null, "gspread", null, 0, -1, Query.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQuery_Param(), this.getQueryParameter(), null, "param", null, 0, -1, Query.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getQuery_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQuery_InputEventTrigger(), theXMLTypePackage.getString(), "inputEventTrigger", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQuery_OutputEventTrigger(), theXMLTypePackage.getString(), "outputEventTrigger", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQuery_ReturnGeneratedKeys(), theXMLTypePackage.getBoolean(), "returnGeneratedKeys", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQuery_UseConfig(), theXMLTypePackage.getString(), "useConfig", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQuery_KeyColumns(), theXMLTypePackage.getString(), "keyColumns", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(queryParameterEClass, QueryParameter.class, "QueryParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQueryParameter_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getQueryParameter_ValidateLongRange(), this.getLongRangeValidator(), null, "validateLongRange", null, 0, 1, QueryParameter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQueryParameter_ValidateDoubleRange(), this.getDoubleRangeValidator(), null, "validateDoubleRange", null, 0, 1, QueryParameter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQueryParameter_ValidateLength(), this.getLengthValidator(), null, "validateLength", null, 0, 1, QueryParameter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQueryParameter_ValidatePattern(), this.getPatternValidator(), null, "validatePattern", null, 0, -1, QueryParameter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getQueryParameter_ValidateCustom(), this.getCustomValidator(), null, "validateCustom", null, 0, -1, QueryParameter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryParameter_DefaultValue(), theXMLTypePackage.getString(), "defaultValue", null, 0, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryParameter_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryParameter_Ordinal(), theXMLTypePackage.getInt(), "ordinal", null, 0, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryParameter_ParamType(), theXMLTypePackage.getString(), "paramType", null, 0, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryParameter_SqlType(), theXMLTypePackage.getString(), "sqlType", null, 1, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryParameter_StructType(), theXMLTypePackage.getString(), "structType", null, 0, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryParameter_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, QueryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(queryPropertyEClass, QueryProperty.class, "QueryProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQueryProperty_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, QueryProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryProperty_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, QueryProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(queryPropertyListEClass, QueryPropertyList.class, "QueryPropertyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQueryPropertyList_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, QueryPropertyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getQueryPropertyList_Property(), this.getQueryProperty(), null, "property", null, 0, 5, QueryPropertyList.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getResource_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResource_CallQuery(), this.getCallQuery(), null, "callQuery", null, 1, 1, Resource.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getResource_Method(), theXMLTypePackage.getString(), "method", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResource_Path(), theXMLTypePackage.getString(), "path", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResource_ReturnRequestStatus(), theXMLTypePackage.getBoolean(), "returnRequestStatus", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resultMappingEClass, ResultMapping.class, "ResultMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getResultMapping_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResultMapping_Element(), this.getElementMapping(), null, "element", null, 0, -1, ResultMapping.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getResultMapping_Attribute(), this.getAttributeMapping(), null, "attribute", null, 0, -1, ResultMapping.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getResultMapping_CallQuery(), this.getCallQuery(), null, "callQuery", null, 0, -1, ResultMapping.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getResultMapping_DefaultNamespace(), theXMLTypePackage.getString(), "defaultNamespace", null, 0, 1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResultMapping_ElementName(), theXMLTypePackage.getString(), "elementName", null, 1, 1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResultMapping_RowName(), theXMLTypePackage.getString(), "rowName", null, 1, 1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResultMapping_UseColumnNumbers(), theXMLTypePackage.getBoolean(), "useColumnNumbers", null, 0, 1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResultMapping_EscapeNonPrintableChar(), theXMLTypePackage.getBoolean(), "escapeNonPrintableChar", null, 0, 1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResultMapping_XsltPath(), theXMLTypePackage.getString(), "xsltPath", null, 0, 1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getResultMapping_OutputType(), theXMLTypePackage.getString(), "outputType", "", 0, 1, ResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(sparqlEClass, Sparql.class, "Sparql", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSparql_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Sparql.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(sqlEClass, Sql.class, "Sql", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSql_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Sql.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSql_Dialect(), theXMLTypePackage.getString(), "dialect", null, 0, 1, Sql.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(queryExpressionEClass, QueryExpression.class, "QueryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQueryExpression_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, QueryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(startingRowEClass, StartingRow.class, "StartingRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStartingRow_Value(), theXMLTypePackage.getLong(), "value", null, 0, 1, StartingRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(subscriptionEClass, Subscription.class, "Subscription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSubscription_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Subscription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(targetTopicEClass, TargetTopic.class, "TargetTopic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTargetTopic_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TargetTopic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(workBookNameEClass, WorkBookName.class, "WorkBookName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWorkBookName_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, WorkBookName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(workSheetNumberEClass, WorkSheetNumber.class, "WorkSheetNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWorkSheetNumber_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, WorkSheetNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(policyEClass, Policy.class, "Policy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPolicy_Key(), theXMLTypePackage.getString(), "key", null, 1, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataServiceParameterEClass, DataServiceParameter.class, "DataServiceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDataServiceParameter_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, DataServiceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataServiceParameter_Value(), theXMLTypePackage.getString(), "value", null, 1, 1, DataServiceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(registryKeyPropertyEClass, RegistryKeyProperty.class, "RegistryKeyProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRegistryKeyProperty_Key(), ecorePackage.getEString(), "key", null, 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(serviceStatusEEnum, ServiceStatus.class, "ServiceStatus");
        addEEnumLiteral(serviceStatusEEnum, ServiceStatus.ACTIVE);
        addEEnumLiteral(serviceStatusEEnum, ServiceStatus.INACTIVE);

        // Initialize data types
        initEDataType(serviceStatusObjectEDataType, ServiceStatus.class, "ServiceStatusObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
        initEDataType(mapEDataType, Map.class, "Map", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
          (this, 
           source, 
           new String[] {
             "qualified", "false"
           });	
        addAnnotation
          (attributeMappingEClass, 
           source, 
           new String[] {
             "name", "attribute_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getAttributeMapping_Column(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "column",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getAttributeMapping_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getAttributeMapping_RequiredRoles(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "requiredRoles",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getAttributeMapping_XsdType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xsdType",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getAttributeMapping_Optional(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "optional",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (callQueryEClass, 
           source, 
           new String[] {
             "name", "call-query_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getCallQuery_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getCallQuery_WithParam(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "with-param",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getCallQuery_Href(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "href",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (callQueryListEClass, 
           source, 
           new String[] {
             "name", "call-query-group_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getCallQueryList_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getCallQueryList_CallQuery(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "call-query",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (configurationPropertyEClass, 
           source, 
           new String[] {
             "name", "property_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getConfigurationProperty_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (getConfigurationProperty_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (customValidatorEClass, 
           source, 
           new String[] {
             "name", "validateCustom_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getCustomValidator_Class(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "class",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (dataServiceEClass, 
           source, 
           new String[] {
             "name", "data_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getDataService_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getDataService_Description(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "description",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_Config(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "config",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_Query(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "query",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_EventTrigger(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "event-trigger",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_Operation(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "operation",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_Resource(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "resource",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_BaseURI(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "baseURI",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_EnableBatchRequests(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "enableBatchRequests",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_EnableBoxcarring(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "enableBoxcarring",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_EnableDTP(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "enableDTP",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_ServiceGroup(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "serviceGroup",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_ServiceNamespace(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "serviceNamespace",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_ServiceStatus(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "serviceStatus",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_EnableSec(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "enableSec"
           });	
        addAnnotation
          (getDataService_Policy(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "policy",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataService_Transports(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "transports"
           });	
        addAnnotation
          (getDataService_FeatureAllowRoles(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "parameter",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (dataSourceConfigurationEClass, 
           source, 
           new String[] {
             "name", "config_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getDataSourceConfiguration_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getDataSourceConfiguration_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataSourceConfiguration_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (descriptionEClass, 
           source, 
           new String[] {
             "name", "description_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getDescription_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (documentRootEClass, 
           source, 
           new String[] {
             "name", "",
             "kind", "mixed"
           });	
        addAnnotation
          (getDocumentRoot_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getDocumentRoot_XMLNSPrefixMap(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xmlns:prefix"
           });	
        addAnnotation
          (getDocumentRoot_XSISchemaLocation(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xsi:schemaLocation"
           });	
        addAnnotation
          (getDocumentRoot_CallQuery(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "call-query",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Data(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "data",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Hasheader(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "hasheader",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Maxrowcount(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "maxrowcount",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Sql(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "sql",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDocumentRoot_Startingrow(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "startingrow",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (doubleRangeValidatorEClass, 
           source, 
           new String[] {
             "name", "validateDoubleRange_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getDoubleRangeValidator_Maximum(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "maximum",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDoubleRangeValidator_Minimum(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "minimum",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (elementMappingEClass, 
           source, 
           new String[] {
             "name", "element_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getElementMapping_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getElementMapping_Column(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "column",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_Export(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "export",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_RequiredRoles(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "requiredRoles",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_ExportType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "exportType",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_Namespace(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "namespace",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_XsdType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xsdType",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_Element(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "element",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_Attribute(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_CallQuery(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "call-query",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_IsComplexType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "isComplexType",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_QueryParam(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "query-param",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_Value(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "value",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_Optional(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "optional",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getElementMapping_ArrayName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "arrayName",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (eventSubscriptionListEClass, 
           source, 
           new String[] {
             "name", "subscriptions_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getEventSubscriptionList_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getEventSubscriptionList_Subscription(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "subscription",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (eventTriggerEClass, 
           source, 
           new String[] {
             "name", "event-trigger_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getEventTrigger_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getEventTrigger_Expression(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "expression",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getEventTrigger_TargetTopic(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "target-topic",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getEventTrigger_Subscriptions(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "subscriptions",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getEventTrigger_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getEventTrigger_Language(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "language",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (excelQueryEClass, 
           source, 
           new String[] {
             "name", "excel_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getExcelQuery_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getExcelQuery_Workbookname(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "workbookname",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getExcelQuery_Hasheader(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "hasheader",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getExcelQuery_Startingrow(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "startingrow",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getExcelQuery_Maxrowcount(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "maxrowcount",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (expressionEClass, 
           source, 
           new String[] {
             "name", "expression_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getExpression_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (gSpreadQueryEClass, 
           source, 
           new String[] {
             "name", "gspread_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getGSpreadQuery_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getGSpreadQuery_Worksheetnumber(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "worksheetnumber",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getGSpreadQuery_Startingrow(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "startingrow",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getGSpreadQuery_Maxrowcount(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "maxrowcount",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getGSpreadQuery_Hasheader(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "hasheader",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (hasHeaderEClass, 
           source, 
           new String[] {
             "name", "hasheader_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getHasHeader_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (lengthValidatorEClass, 
           source, 
           new String[] {
             "name", "validateLength_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getLengthValidator_Maximum(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "maximum",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getLengthValidator_Minimum(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "minimum",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (longRangeValidatorEClass, 
           source, 
           new String[] {
             "name", "validateLongRange_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getLongRangeValidator_Maximum(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "maximum",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getLongRangeValidator_Minimum(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "minimum",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (maxRowCountEClass, 
           source, 
           new String[] {
             "name", "maxrowcount_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getMaxRowCount_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (operationEClass, 
           source, 
           new String[] {
             "name", "operation_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getOperation_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getOperation_CallQuery(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "call-query",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getOperation_CallQueryGroup(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "call-query-group",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getOperation_DisableStreaming(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "disableStreaming",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getOperation_ReturnRequestStatus(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "returnRequestStatus",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getOperation_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (parameterMappingEClass, 
           source, 
           new String[] {
             "name", "with-param_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getParameterMapping_Column(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "column",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getParameterMapping_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getParameterMapping_QueryParam(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "query-param",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (patternValidatorEClass, 
           source, 
           new String[] {
             "name", "validatePattern_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getPatternValidator_Pattern(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "pattern",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (queryEClass, 
           source, 
           new String[] {
             "name", "query_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getQuery_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getQuery_Sql(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "sql",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_Sparql(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "sparql",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_Properties(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "properties",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_Result(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "result",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_Excel(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "excel",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_Gspread(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "gspread",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_Param(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "param",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_InputEventTrigger(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "input-event-trigger",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_OutputEventTrigger(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "output-event-trigger",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_ReturnGeneratedKeys(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "returnGeneratedKeys",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_UseConfig(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "useConfig",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQuery_KeyColumns(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "keyColumns",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (queryParameterEClass, 
           source, 
           new String[] {
             "name", "param_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getQueryParameter_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getQueryParameter_ValidateLongRange(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validateLongRange",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_ValidateDoubleRange(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validateDoubleRange",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_ValidateLength(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validateLength",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_ValidatePattern(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validatePattern",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_ValidateCustom(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validateCustom",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_DefaultValue(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "defaultValue",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_Ordinal(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "ordinal",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_ParamType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "paramType",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_SqlType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "sqlType",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_StructType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "structType",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getQueryParameter_Type(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "type",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (queryPropertyEClass, 
           source, 
           new String[] {
             "name", "property_._1_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getQueryProperty_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (getQueryProperty_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (queryPropertyListEClass, 
           source, 
           new String[] {
             "name", "properties_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getQueryPropertyList_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getQueryPropertyList_Property(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "property",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (resourceEClass, 
           source, 
           new String[] {
             "name", "resource_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getResource_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getResource_CallQuery(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "call-query",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResource_Method(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "method",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResource_Path(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "path",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResource_ReturnRequestStatus(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "returnRequestStatus",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (resultMappingEClass, 
           source, 
           new String[] {
             "name", "result_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getResultMapping_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getResultMapping_Element(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "element",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResultMapping_Attribute(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "attribute",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResultMapping_CallQuery(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "call-query",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResultMapping_DefaultNamespace(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "defaultNamespace",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResultMapping_ElementName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "element",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResultMapping_RowName(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "rowName",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResultMapping_UseColumnNumbers(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "useColumnNumbers",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getResultMapping_XsltPath(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xsltPath",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (serviceStatusEEnum, 
           source, 
           new String[] {
             "name", "serviceStatus_._type"
           });	
        addAnnotation
          (serviceStatusObjectEDataType, 
           source, 
           new String[] {
             "name", "serviceStatus_._type:Object",
             "baseType", "serviceStatus_._type"
           });	
        addAnnotation
          (sparqlEClass, 
           source, 
           new String[] {
             "name", "sparql_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getSparql_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (sqlEClass, 
           source, 
           new String[] {
             "name", "sql_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getSql_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (getSql_Dialect(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "dialect",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (queryExpressionEClass, 
           source, 
           new String[] {
             "name", "queryExpression_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getQueryExpression_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (startingRowEClass, 
           source, 
           new String[] {
             "name", "startingrow_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getStartingRow_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (subscriptionEClass, 
           source, 
           new String[] {
             "name", "subscription_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getSubscription_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (targetTopicEClass, 
           source, 
           new String[] {
             "name", "target-topic_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getTargetTopic_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (workBookNameEClass, 
           source, 
           new String[] {
             "name", "workbookname_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getWorkBookName_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (workSheetNumberEClass, 
           source, 
           new String[] {
             "name", "worksheetnumber_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getWorkSheetNumber_Value(), 
           source, 
           new String[] {
             "name", ":0",
             "kind", "simple"
           });	
        addAnnotation
          (policyEClass, 
           source, 
           new String[] {
             "name", "policy_._type",
             "kind", "mixed"
           });	
        addAnnotation
          (getPolicy_Key(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "key",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (dataServiceParameterEClass, 
           source, 
           new String[] {
             "name", "parameter_._type",
             "kind", "simple"
           });	
        addAnnotation
          (getDataServiceParameter_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (getDataServiceParameter_Value(), 
           source, 
           new String[] {
             "kind", "simple",
             "name", ":0"
           });
    }

} // DsPackageImpl
