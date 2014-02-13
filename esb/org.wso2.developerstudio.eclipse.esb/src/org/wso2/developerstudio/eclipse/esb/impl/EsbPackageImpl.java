/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.wso2.developerstudio.eclipse.esb.AbstractBooleanFeature;
import org.wso2.developerstudio.eclipse.esb.AbstractCommonTarget;
import org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint;
import org.wso2.developerstudio.eclipse.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource;
import org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.AbstractNameValueProperty;
import org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.esb.ApiFaultSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ApiInSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ApiOutSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ApiResource;
import org.wso2.developerstudio.eclipse.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.esb.Comment;
import org.wso2.developerstudio.eclipse.esb.ConfigurationElement;
import org.wso2.developerstudio.eclipse.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.esb.Description;
import org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceProperty;
import org.wso2.developerstudio.eclipse.esb.EndPoint;
import org.wso2.developerstudio.eclipse.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.esb.EndPointAttachmentOptimization;
import org.wso2.developerstudio.eclipse.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.esb.EndPointMessageFormatRestType;
import org.wso2.developerstudio.eclipse.esb.EndPointReference;
import org.wso2.developerstudio.eclipse.esb.EndPointTimeOutAction;
import org.wso2.developerstudio.eclipse.esb.EndPointWsdlType;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.EsbVersion;
import org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceAlgorithm;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.esb.LoadBalanceSessionType;
import org.wso2.developerstudio.eclipse.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.esb.LocalEntryValueType;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.MediatorBranch;
import org.wso2.developerstudio.eclipse.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty;
import org.wso2.developerstudio.eclipse.esb.Namespace;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.ParentEndPoint;
import org.wso2.developerstudio.eclipse.esb.ParentMediator;
import org.wso2.developerstudio.eclipse.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyEndpointType;
import org.wso2.developerstudio.eclipse.esb.ProxyFaultSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyInSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyOutSequenceConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxySequenceType;
import org.wso2.developerstudio.eclipse.esb.ProxyService;
import org.wso2.developerstudio.eclipse.esb.ProxyServiceParameter;
import org.wso2.developerstudio.eclipse.esb.ProxyServicePolicy;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlResource;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlType;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyEndPointReference;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.esb.SynapseConfiguration;
import org.wso2.developerstudio.eclipse.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.esb.Task;
import org.wso2.developerstudio.eclipse.esb.TaskImplementation;
import org.wso2.developerstudio.eclipse.esb.TaskProperty;
import org.wso2.developerstudio.eclipse.esb.TaskPropertyType;
import org.wso2.developerstudio.eclipse.esb.TaskTriggerType;
import org.wso2.developerstudio.eclipse.esb.UnknownObject;
import org.wso2.developerstudio.eclipse.esb.WsdlEndPoint;
import org.wso2.developerstudio.eclipse.esb.XPathEndPointReference;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EsbPackageImpl extends EPackageImpl implements EsbPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synapseConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum endPointAddressingVersionEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum endPointTimeOutActionEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum endPointMessageFormatEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum endPointAttachmentOptimizationEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum endPointWsdlTypeEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum loadBalanceAlgorithmEEnum = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum loadBalanceSessionTypeEEnum = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespacedPropertyEClass = null;

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
	private EClass proxyServiceEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyWsdlConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyWsdlResourceEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServiceParameterEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyServicePolicyEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractProxySequenceConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyInSequenceConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyEndpointConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyOutSequenceConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyFaultSequenceConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localEntryEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluatorExpressionPropertyEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskImplementationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskPropertyEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiInSequenceConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiOutSequenceConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiFaultSequenceConfigurationEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass apiResourceEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synapseAPIEClass = null;

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum modelObjectStateEEnum = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum taskPropertyTypeEEnum = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyValueTypeEEnum = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediatorEClass = null;

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
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediatorSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass endPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass unknownObjectEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass abstractEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass abstractDefaultEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass defaultEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass addressEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass wsdlEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass parentEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass failoverEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass loadBalanceEndPointEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicLoadBalanceEndPointEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicLoadBalancePropertyEClass = null;

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass endPointReferenceEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass xPathEndPointReferenceEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registryKeyEndPointReferenceEClass = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNameValuePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNameValueExpressionPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameValueTypePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractBooleanFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLocationKeyResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCommonTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mediatorBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum proxyWsdlTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum proxySequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum proxyEndpointTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum localEntryValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum esbVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum endPointMessageFormatRestTypeEEnum = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum taskTriggerTypeEEnum = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum apiResourceUrlStyleEEnum = null;

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum targetSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum targetEndpointTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mapEDataType = null;

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
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EsbPackageImpl() {
		super(eNS_URI, EsbFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EsbPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EsbPackage init() {
		if (isInited) return (EsbPackage)EPackage.Registry.INSTANCE.getEPackage(EsbPackage.eNS_URI);

		// Obtain or create and register package
		EsbPackageImpl theEsbPackage = (EsbPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EsbPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EsbPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MediatorsPackageImpl theMediatorsPackage = (MediatorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MediatorsPackage.eNS_URI) instanceof MediatorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MediatorsPackage.eNS_URI) : MediatorsPackage.eINSTANCE);

		// Create package meta-data objects
		theEsbPackage.createPackageContents();
		theMediatorsPackage.createPackageContents();

		// Initialize created meta-data
		theEsbPackage.initializePackageContents();
		theMediatorsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEsbPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EsbPackage.eNS_URI, theEsbPackage);
		return theEsbPackage;
	}
 
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelObject() {
		return modelObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getModelObject_ObjectState() {
		return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getModelObject_SourceText() {
		return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelObject_DefaultNamespace() {
		return (EReference)modelObjectEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelObject_AdditionalNamespaces() {
		return (EReference)modelObjectEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelObject_CurrentEsbVersion() {
		return (EAttribute)modelObjectEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelObject_Comment() {
		return (EReference)modelObjectEClass.getEStructuralFeatures().get(5);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespace() {
		return namespaceEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespace_Prefix() {
		return (EAttribute)namespaceEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespace_Uri() {
		return (EAttribute)namespaceEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynapseConfiguration() {
		return synapseConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynapseConfiguration_ConfigurationElements() {
		return (EReference)synapseConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseConfiguration_SchemaLocation() {
		return (EAttribute)synapseConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationElement() {
		return configurationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespacedProperty() {
		return namespacedPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_PrettyName() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_PropertyName() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_PropertyValue() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamespacedProperty_Namespaces() {
		return (EAttribute)namespacedPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getEndPointAddressingVersion() {
		return endPointAddressingVersionEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getEndPointTimeOutAction() {
		return endPointTimeOutActionEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getEndPointMessageFormat() {
		return endPointMessageFormatEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getEndPointAttachmentOptimization() {
		return endPointAttachmentOptimizationEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getEndPointWsdlType() {
		return endPointWsdlTypeEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getLoadBalanceAlgorithm() {
		return loadBalanceAlgorithmEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getLoadBalanceSessionType() {
		return loadBalanceSessionTypeEEnum;
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
	public EAttribute getRegistryKeyProperty_PrettyName() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryKeyProperty_KeyName() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryKeyProperty_KeyValue() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistryKeyProperty_Filters() {
		return (EAttribute)registryKeyPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyService() {
		return proxyServiceEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_Name() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_ServiceGroup() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_PinnedServers() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_TraceEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_StatisticsEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_Transports() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(5);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_ReliableMessagingEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(6);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyService_SecurityEnabled() {
		return (EAttribute)proxyServiceEClass.getEStructuralFeatures().get(7);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_WsdlConfiguration() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(8);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_InSequenceConfiguration() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(9);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_EndpointConfiguration() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(10);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_OutSequenceConfiguration() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(11);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_FaultSequenceConfiguration() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(12);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_ServiceParameters() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(13);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyService_ServicePolicies() {
		return (EReference)proxyServiceEClass.getEStructuralFeatures().get(14);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyWsdlResource() {
		return proxyWsdlResourceEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyServiceParameter() {
		return proxyServiceParameterEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyServiceParameter_Name() {
		return (EAttribute)proxyServiceParameterEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyServiceParameter_Value() {
		return (EAttribute)proxyServiceParameterEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyServicePolicy() {
		return proxyServicePolicyEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyServicePolicy_PolicyKey() {
		return (EReference)proxyServicePolicyEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractProxySequenceConfiguration() {
		return abstractProxySequenceConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractProxySequenceConfiguration_SequenceType() {
		return (EAttribute)abstractProxySequenceConfigurationEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractProxySequenceConfiguration_InlineSequence() {
		return (EReference)abstractProxySequenceConfigurationEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractProxySequenceConfiguration_SequenceKey() {
		return (EReference)abstractProxySequenceConfigurationEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractProxySequenceConfiguration_SequenceName() {
		return (EAttribute)abstractProxySequenceConfigurationEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyInSequenceConfiguration() {
		return proxyInSequenceConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyEndpointConfiguration() {
		return proxyEndpointConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyEndpointConfiguration_EndpointType() {
		return (EAttribute)proxyEndpointConfigurationEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyEndpointConfiguration_InlineEndpoint() {
		return (EReference)proxyEndpointConfigurationEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyEndpointConfiguration_EndpointKey() {
		return (EReference)proxyEndpointConfigurationEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyEndpointConfiguration_EndpointName() {
		return (EAttribute)proxyEndpointConfigurationEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyOutSequenceConfiguration() {
		return proxyOutSequenceConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyFaultSequenceConfiguration() {
		return proxyFaultSequenceConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalEntry() {
		return localEntryEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_EntryName() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_ValueType() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_ValueLiteral() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_ValueXML() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalEntry_ValueURL() {
		return (EAttribute)localEntryEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluatorExpressionProperty() {
		return evaluatorExpressionPropertyEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluatorExpressionProperty_PrettyName() {
		return (EAttribute)evaluatorExpressionPropertyEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluatorExpressionProperty_EvaluatorName() {
		return (EAttribute)evaluatorExpressionPropertyEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvaluatorExpressionProperty_EvaluatorValue() {
		return (EAttribute)evaluatorExpressionPropertyEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskImplementation() {
		return taskImplementationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskImplementation_TaskImplementation() {
		return (EAttribute)taskImplementationEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskImplementation_TaskProperties() {
		return (EReference)taskImplementationEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskProperty() {
		return taskPropertyEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_TaskName() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_TaskGroup() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_TaskImplementationClass() {
		return (EReference)taskEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_TriggerType() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Count() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Interval() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(5);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Cron() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(6);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_PinnedServers() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(7);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApiInSequenceConfiguration() {
		return apiInSequenceConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApiOutSequenceConfiguration() {
		return apiOutSequenceConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApiFaultSequenceConfiguration() {
		return apiFaultSequenceConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApiResource() {
		return apiResourceEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApiResource_InSequenceConfiguration() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApiResource_OutSequenceConfiguration() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApiResource_FaultSequenceConfiguration() {
		return (EReference)apiResourceEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_UrlStyle() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_UriTemplate() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_UrlMapping() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(5);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_AllowGet() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(6);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_AllowPost() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(7);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_AllowPut() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(8);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_AllowDelete() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(9);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApiResource_AllowOptions() {
		return (EAttribute)apiResourceEClass.getEStructuralFeatures().get(10);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynapseAPI() {
		return synapseAPIEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_ApiName() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_Context() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_Hostname() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynapseAPI_Port() {
		return (EAttribute)synapseAPIEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynapseAPI_Resources() {
		return (EReference)synapseAPIEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyWsdlConfiguration() {
		return proxyWsdlConfigurationEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyWsdlConfiguration_WsdlType() {
		return (EAttribute)proxyWsdlConfigurationEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyWsdlConfiguration_WsdlXML() {
		return (EAttribute)proxyWsdlConfigurationEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProxyWsdlConfiguration_WsdlURL() {
		return (EAttribute)proxyWsdlConfigurationEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyWsdlConfiguration_WsdlResources() {
		return (EReference)proxyWsdlConfigurationEClass.getEStructuralFeatures().get(4);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getModelObjectState() {
		return modelObjectStateEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTaskPropertyType() {
		return taskPropertyTypeEEnum;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyValueType() {
		return propertyValueTypeEEnum;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediatorBranch() {
		return mediatorBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediatorBranch_Children() {
		return (EReference)mediatorBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediator() {
		return mediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediator_Description() {
		return (EReference)mediatorEClass.getEStructuralFeatures().get(0);
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
	public EClass getComment() {
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComment_Value() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComment_Position() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMediatorSequence() {
		return mediatorSequenceEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediatorSequence_Anonymous() {
		return (EAttribute)mediatorSequenceEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMediatorSequence_SequenceName() {
		return (EAttribute)mediatorSequenceEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediatorSequence_Mediators() {
		return (EReference)mediatorSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediatorSequence_OnError() {
		return (EReference)mediatorSequenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMediatorSequence_Description() {
		return (EReference)mediatorSequenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentMediator() {
		return parentMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParentMediator_Children() {
		return (EReference)parentMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNameValueProperty() {
		return abstractNameValuePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueProperty_PropertyName() {
		return (EAttribute)abstractNameValuePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueProperty_PropertyValue() {
		return (EAttribute)abstractNameValuePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNameValueExpressionProperty() {
		return abstractNameValueExpressionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionProperty_PropertyName() {
		return (EAttribute)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionProperty_PropertyValueType() {
		return (EAttribute)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNameValueExpressionProperty_PropertyValue() {
		return (EAttribute)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractNameValueExpressionProperty_PropertyExpression() {
		return (EReference)abstractNameValueExpressionPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameValueTypeProperty() {
		return nameValueTypePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameValueTypeProperty_PropertyName() {
		return (EAttribute)nameValueTypePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameValueTypeProperty_PropertyType() {
		return (EAttribute)nameValueTypePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameValueTypeProperty_PropertyValue() {
		return (EAttribute)nameValueTypePropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractBooleanFeature() {
		return abstractBooleanFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractBooleanFeature_FeatureName() {
		return (EAttribute)abstractBooleanFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractBooleanFeature_FeatureEnabled() {
		return (EAttribute)abstractBooleanFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLocationKeyResource() {
		return abstractLocationKeyResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLocationKeyResource_Location() {
		return (EAttribute)abstractLocationKeyResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLocationKeyResource_Key() {
		return (EReference)abstractLocationKeyResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractCommonTarget() {
		return abstractCommonTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractCommonTarget_SequenceType() {
		return (EAttribute)abstractCommonTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_Sequence() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_SequenceKey() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractCommonTarget_EndpointType() {
		return (EAttribute)abstractCommonTargetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_Endpoint() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCommonTarget_EndpointKey() {
		return (EReference)abstractCommonTargetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getEndPoint() {
		return endPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPoint_Anonymous() {
		return (EAttribute)endPointEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndPoint_EndpointName() {
		return (EAttribute)endPointEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getUnknownObject() {
		return unknownObjectEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getAbstractEndPoint() {
		return abstractEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_ReliableMessagingEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getAbstractEndPoint_ReliableMessagingPolicy() {
		return (EReference)abstractEndPointEClass.getEStructuralFeatures().get(14);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_SecurityEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getAbstractEndPoint_SecurityPolicy() {
		return (EReference)abstractEndPointEClass.getEStructuralFeatures().get(15);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getAbstractDefaultEndPoint() {
		return abstractDefaultEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractDefaultEndPoint_MessageFormat() {
		return (EAttribute)abstractDefaultEndPointEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractDefaultEndPoint_AttachmentOptimization() {
		return (EAttribute)abstractDefaultEndPointEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractDefaultEndPoint_Encoding() {
		return (EAttribute)abstractDefaultEndPointEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractDefaultEndPoint_StatisticsEnabled() {
		return (EAttribute)abstractDefaultEndPointEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractDefaultEndPoint_TraceEnabled() {
		return (EAttribute)abstractDefaultEndPointEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractDefaultEndPoint_RestType() {
		return (EAttribute)abstractDefaultEndPointEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getDefaultEndPoint() {
		return defaultEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_AddressingEnabled() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_AddressingVersion() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_AddressingSeparateListener() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_TimeOutDuration() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_TimeOutAction() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_RetryErrorCodes() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(7);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_RetryCount() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(8);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_RetryDelay() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(9);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_SuspendErrorCodes() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(10);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_SuspendInitialDuration() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(11);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_SuspendMaximumDuration() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(12);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAbstractEndPoint_SuspendProgressionFactor() {
		return (EAttribute)abstractEndPointEClass.getEStructuralFeatures().get(13);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getAddressEndPoint() {
		return addressEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getAddressEndPoint_Uri() {
		return (EAttribute)addressEndPointEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getWsdlEndPoint() {
		return wsdlEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getWsdlEndPoint_WsdlType() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getWsdlEndPoint_WsdlURI() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getWsdlEndPoint_WsdlXML() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getWsdlEndPoint_Service() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getWsdlEndPoint_Port() {
		return (EAttribute)wsdlEndPointEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getParentEndPoint() {
		return parentEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getParentEndPoint_Children() {
		return (EReference)parentEndPointEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getFailoverEndPoint() {
		return failoverEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getLoadBalanceEndPoint() {
		return loadBalanceEndPointEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getLoadBalanceEndPoint_Algorithm() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getLoadBalanceEndPoint_SessionType() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getLoadBalanceEndPoint_SessionTimeout() {
		return (EAttribute)loadBalanceEndPointEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicLoadBalanceEndPoint() {
		return dynamicLoadBalanceEndPointEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicLoadBalanceEndPoint_Algorithm() {
		return (EAttribute)dynamicLoadBalanceEndPointEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicLoadBalanceEndPoint_FailoverEnabled() {
		return (EAttribute)dynamicLoadBalanceEndPointEClass.getEStructuralFeatures().get(1);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicLoadBalanceEndPoint_MembershipHandlerClass() {
		return (EAttribute)dynamicLoadBalanceEndPointEClass.getEStructuralFeatures().get(2);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicLoadBalanceEndPoint_Properties() {
		return (EReference)dynamicLoadBalanceEndPointEClass.getEStructuralFeatures().get(3);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicLoadBalanceProperty() {
		return dynamicLoadBalancePropertyEClass;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getEndPointReference() {
		return endPointReferenceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getXPathEndPointReference() {
		return xPathEndPointReferenceEClass;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXPathEndPointReference_EndpointXpath() {
		return (EReference)xPathEndPointReferenceEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistryKeyEndPointReference() {
		return registryKeyEndPointReferenceEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistryKeyEndPointReference_EndpointKey() {
		return (EReference)registryKeyEndPointReferenceEClass.getEStructuralFeatures().get(0);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProxyWsdlType() {
		return proxyWsdlTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProxySequenceType() {
		return proxySequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProxyEndpointType() {
		return proxyEndpointTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLocalEntryValueType() {
		return localEntryValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEsbVersion() {
		return esbVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getEndPointMessageFormatRestType() {
		return endPointMessageFormatRestTypeEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTaskTriggerType() {
		return taskTriggerTypeEEnum;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getApiResourceUrlStyle() {
		return apiResourceUrlStyleEEnum;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTargetSequenceType() {
		return targetSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTargetEndpointType() {
		return targetEndpointTypeEEnum;
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
	public EsbFactory getEsbFactory() {
		return (EsbFactory)getEFactoryInstance();
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
		modelObjectEClass = createEClass(MODEL_OBJECT);
		createEAttribute(modelObjectEClass, MODEL_OBJECT__OBJECT_STATE);
		createEAttribute(modelObjectEClass, MODEL_OBJECT__SOURCE_TEXT);
		createEReference(modelObjectEClass, MODEL_OBJECT__DEFAULT_NAMESPACE);
		createEReference(modelObjectEClass, MODEL_OBJECT__ADDITIONAL_NAMESPACES);
		createEAttribute(modelObjectEClass, MODEL_OBJECT__CURRENT_ESB_VERSION);
		createEReference(modelObjectEClass, MODEL_OBJECT__COMMENT);

		namespaceEClass = createEClass(NAMESPACE);
		createEAttribute(namespaceEClass, NAMESPACE__PREFIX);
		createEAttribute(namespaceEClass, NAMESPACE__URI);

		synapseConfigurationEClass = createEClass(SYNAPSE_CONFIGURATION);
		createEReference(synapseConfigurationEClass, SYNAPSE_CONFIGURATION__CONFIGURATION_ELEMENTS);
		createEAttribute(synapseConfigurationEClass, SYNAPSE_CONFIGURATION__SCHEMA_LOCATION);

		configurationElementEClass = createEClass(CONFIGURATION_ELEMENT);

		mediatorEClass = createEClass(MEDIATOR);
		createEReference(mediatorEClass, MEDIATOR__DESCRIPTION);

		descriptionEClass = createEClass(DESCRIPTION);
		createEAttribute(descriptionEClass, DESCRIPTION__VALUE);

		commentEClass = createEClass(COMMENT);
		createEAttribute(commentEClass, COMMENT__VALUE);
		createEAttribute(commentEClass, COMMENT__POSITION);

		endPointReferenceEClass = createEClass(END_POINT_REFERENCE);

		endPointEClass = createEClass(END_POINT);
		createEAttribute(endPointEClass, END_POINT__ANONYMOUS);
		createEAttribute(endPointEClass, END_POINT__ENDPOINT_NAME);

		unknownObjectEClass = createEClass(UNKNOWN_OBJECT);

		mediatorSequenceEClass = createEClass(MEDIATOR_SEQUENCE);
		createEAttribute(mediatorSequenceEClass, MEDIATOR_SEQUENCE__ANONYMOUS);
		createEAttribute(mediatorSequenceEClass, MEDIATOR_SEQUENCE__SEQUENCE_NAME);
		createEReference(mediatorSequenceEClass, MEDIATOR_SEQUENCE__MEDIATORS);
		createEReference(mediatorSequenceEClass, MEDIATOR_SEQUENCE__ON_ERROR);
		createEReference(mediatorSequenceEClass, MEDIATOR_SEQUENCE__DESCRIPTION);

		mediatorBranchEClass = createEClass(MEDIATOR_BRANCH);
		createEReference(mediatorBranchEClass, MEDIATOR_BRANCH__CHILDREN);

		parentMediatorEClass = createEClass(PARENT_MEDIATOR);
		createEReference(parentMediatorEClass, PARENT_MEDIATOR__CHILDREN);

		namespacedPropertyEClass = createEClass(NAMESPACED_PROPERTY);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__PRETTY_NAME);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__PROPERTY_NAME);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__PROPERTY_VALUE);
		createEAttribute(namespacedPropertyEClass, NAMESPACED_PROPERTY__NAMESPACES);

		registryKeyPropertyEClass = createEClass(REGISTRY_KEY_PROPERTY);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__PRETTY_NAME);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__KEY_NAME);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__KEY_VALUE);
		createEAttribute(registryKeyPropertyEClass, REGISTRY_KEY_PROPERTY__FILTERS);

		abstractNameValuePropertyEClass = createEClass(ABSTRACT_NAME_VALUE_PROPERTY);
		createEAttribute(abstractNameValuePropertyEClass, ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_NAME);
		createEAttribute(abstractNameValuePropertyEClass, ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_VALUE);

		abstractNameValueExpressionPropertyEClass = createEClass(ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY);
		createEAttribute(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME);
		createEAttribute(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE);
		createEAttribute(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE);
		createEReference(abstractNameValueExpressionPropertyEClass, ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION);

		nameValueTypePropertyEClass = createEClass(NAME_VALUE_TYPE_PROPERTY);
		createEAttribute(nameValueTypePropertyEClass, NAME_VALUE_TYPE_PROPERTY__PROPERTY_NAME);
		createEAttribute(nameValueTypePropertyEClass, NAME_VALUE_TYPE_PROPERTY__PROPERTY_TYPE);
		createEAttribute(nameValueTypePropertyEClass, NAME_VALUE_TYPE_PROPERTY__PROPERTY_VALUE);

		abstractBooleanFeatureEClass = createEClass(ABSTRACT_BOOLEAN_FEATURE);
		createEAttribute(abstractBooleanFeatureEClass, ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME);
		createEAttribute(abstractBooleanFeatureEClass, ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED);

		abstractLocationKeyResourceEClass = createEClass(ABSTRACT_LOCATION_KEY_RESOURCE);
		createEAttribute(abstractLocationKeyResourceEClass, ABSTRACT_LOCATION_KEY_RESOURCE__LOCATION);
		createEReference(abstractLocationKeyResourceEClass, ABSTRACT_LOCATION_KEY_RESOURCE__KEY);

		abstractCommonTargetEClass = createEClass(ABSTRACT_COMMON_TARGET);
		createEAttribute(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__SEQUENCE);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__SEQUENCE_KEY);
		createEAttribute(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__ENDPOINT);
		createEReference(abstractCommonTargetEClass, ABSTRACT_COMMON_TARGET__ENDPOINT_KEY);

		abstractEndPointEClass = createEClass(ABSTRACT_END_POINT);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SECURITY_ENABLED);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__ADDRESSING_ENABLED);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__ADDRESSING_VERSION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__TIME_OUT_DURATION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__TIME_OUT_ACTION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RETRY_ERROR_CODES);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RETRY_COUNT);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__RETRY_DELAY);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_ERROR_CODES);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION);
		createEAttribute(abstractEndPointEClass, ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR);
		createEReference(abstractEndPointEClass, ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY);
		createEReference(abstractEndPointEClass, ABSTRACT_END_POINT__SECURITY_POLICY);

		abstractDefaultEndPointEClass = createEClass(ABSTRACT_DEFAULT_END_POINT);
		createEAttribute(abstractDefaultEndPointEClass, ABSTRACT_DEFAULT_END_POINT__MESSAGE_FORMAT);
		createEAttribute(abstractDefaultEndPointEClass, ABSTRACT_DEFAULT_END_POINT__ATTACHMENT_OPTIMIZATION);
		createEAttribute(abstractDefaultEndPointEClass, ABSTRACT_DEFAULT_END_POINT__ENCODING);
		createEAttribute(abstractDefaultEndPointEClass, ABSTRACT_DEFAULT_END_POINT__STATISTICS_ENABLED);
		createEAttribute(abstractDefaultEndPointEClass, ABSTRACT_DEFAULT_END_POINT__TRACE_ENABLED);
		createEAttribute(abstractDefaultEndPointEClass, ABSTRACT_DEFAULT_END_POINT__REST_TYPE);

		defaultEndPointEClass = createEClass(DEFAULT_END_POINT);

		addressEndPointEClass = createEClass(ADDRESS_END_POINT);
		createEAttribute(addressEndPointEClass, ADDRESS_END_POINT__URI);

		wsdlEndPointEClass = createEClass(WSDL_END_POINT);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__WSDL_TYPE);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__WSDL_URI);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__WSDL_XML);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__SERVICE);
		createEAttribute(wsdlEndPointEClass, WSDL_END_POINT__PORT);

		parentEndPointEClass = createEClass(PARENT_END_POINT);
		createEReference(parentEndPointEClass, PARENT_END_POINT__CHILDREN);

		failoverEndPointEClass = createEClass(FAILOVER_END_POINT);

		loadBalanceEndPointEClass = createEClass(LOAD_BALANCE_END_POINT);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__ALGORITHM);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__SESSION_TYPE);
		createEAttribute(loadBalanceEndPointEClass, LOAD_BALANCE_END_POINT__SESSION_TIMEOUT);

		dynamicLoadBalanceEndPointEClass = createEClass(DYNAMIC_LOAD_BALANCE_END_POINT);
		createEAttribute(dynamicLoadBalanceEndPointEClass, DYNAMIC_LOAD_BALANCE_END_POINT__ALGORITHM);
		createEAttribute(dynamicLoadBalanceEndPointEClass, DYNAMIC_LOAD_BALANCE_END_POINT__FAILOVER_ENABLED);
		createEAttribute(dynamicLoadBalanceEndPointEClass, DYNAMIC_LOAD_BALANCE_END_POINT__MEMBERSHIP_HANDLER_CLASS);
		createEReference(dynamicLoadBalanceEndPointEClass, DYNAMIC_LOAD_BALANCE_END_POINT__PROPERTIES);

		dynamicLoadBalancePropertyEClass = createEClass(DYNAMIC_LOAD_BALANCE_PROPERTY);

		xPathEndPointReferenceEClass = createEClass(XPATH_END_POINT_REFERENCE);
		createEReference(xPathEndPointReferenceEClass, XPATH_END_POINT_REFERENCE__ENDPOINT_XPATH);

		registryKeyEndPointReferenceEClass = createEClass(REGISTRY_KEY_END_POINT_REFERENCE);
		createEReference(registryKeyEndPointReferenceEClass, REGISTRY_KEY_END_POINT_REFERENCE__ENDPOINT_KEY);

		proxyServiceEClass = createEClass(PROXY_SERVICE);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__NAME);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__PINNED_SERVERS);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__SERVICE_GROUP);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__TRACE_ENABLED);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__STATISTICS_ENABLED);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__TRANSPORTS);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__RELIABLE_MESSAGING_ENABLED);
		createEAttribute(proxyServiceEClass, PROXY_SERVICE__SECURITY_ENABLED);
		createEReference(proxyServiceEClass, PROXY_SERVICE__WSDL_CONFIGURATION);
		createEReference(proxyServiceEClass, PROXY_SERVICE__IN_SEQUENCE_CONFIGURATION);
		createEReference(proxyServiceEClass, PROXY_SERVICE__ENDPOINT_CONFIGURATION);
		createEReference(proxyServiceEClass, PROXY_SERVICE__OUT_SEQUENCE_CONFIGURATION);
		createEReference(proxyServiceEClass, PROXY_SERVICE__FAULT_SEQUENCE_CONFIGURATION);
		createEReference(proxyServiceEClass, PROXY_SERVICE__SERVICE_PARAMETERS);
		createEReference(proxyServiceEClass, PROXY_SERVICE__SERVICE_POLICIES);

		proxyWsdlConfigurationEClass = createEClass(PROXY_WSDL_CONFIGURATION);
		createEAttribute(proxyWsdlConfigurationEClass, PROXY_WSDL_CONFIGURATION__WSDL_TYPE);
		createEAttribute(proxyWsdlConfigurationEClass, PROXY_WSDL_CONFIGURATION__WSDL_XML);
		createEAttribute(proxyWsdlConfigurationEClass, PROXY_WSDL_CONFIGURATION__WSDL_URL);
		createEReference(proxyWsdlConfigurationEClass, PROXY_WSDL_CONFIGURATION__WSDL_KEY);
		createEReference(proxyWsdlConfigurationEClass, PROXY_WSDL_CONFIGURATION__WSDL_RESOURCES);

		proxyWsdlResourceEClass = createEClass(PROXY_WSDL_RESOURCE);

		proxyServiceParameterEClass = createEClass(PROXY_SERVICE_PARAMETER);
		createEAttribute(proxyServiceParameterEClass, PROXY_SERVICE_PARAMETER__NAME);
		createEAttribute(proxyServiceParameterEClass, PROXY_SERVICE_PARAMETER__VALUE);

		proxyServicePolicyEClass = createEClass(PROXY_SERVICE_POLICY);
		createEReference(proxyServicePolicyEClass, PROXY_SERVICE_POLICY__POLICY_KEY);

		abstractProxySequenceConfigurationEClass = createEClass(ABSTRACT_PROXY_SEQUENCE_CONFIGURATION);
		createEAttribute(abstractProxySequenceConfigurationEClass, ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_TYPE);
		createEReference(abstractProxySequenceConfigurationEClass, ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__INLINE_SEQUENCE);
		createEReference(abstractProxySequenceConfigurationEClass, ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_KEY);
		createEAttribute(abstractProxySequenceConfigurationEClass, ABSTRACT_PROXY_SEQUENCE_CONFIGURATION__SEQUENCE_NAME);

		proxyInSequenceConfigurationEClass = createEClass(PROXY_IN_SEQUENCE_CONFIGURATION);

		proxyEndpointConfigurationEClass = createEClass(PROXY_ENDPOINT_CONFIGURATION);
		createEAttribute(proxyEndpointConfigurationEClass, PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_TYPE);
		createEReference(proxyEndpointConfigurationEClass, PROXY_ENDPOINT_CONFIGURATION__INLINE_ENDPOINT);
		createEReference(proxyEndpointConfigurationEClass, PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_KEY);
		createEAttribute(proxyEndpointConfigurationEClass, PROXY_ENDPOINT_CONFIGURATION__ENDPOINT_NAME);

		proxyOutSequenceConfigurationEClass = createEClass(PROXY_OUT_SEQUENCE_CONFIGURATION);

		proxyFaultSequenceConfigurationEClass = createEClass(PROXY_FAULT_SEQUENCE_CONFIGURATION);

		localEntryEClass = createEClass(LOCAL_ENTRY);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__ENTRY_NAME);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__VALUE_TYPE);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__VALUE_LITERAL);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__VALUE_XML);
		createEAttribute(localEntryEClass, LOCAL_ENTRY__VALUE_URL);

		evaluatorExpressionPropertyEClass = createEClass(EVALUATOR_EXPRESSION_PROPERTY);
		createEAttribute(evaluatorExpressionPropertyEClass, EVALUATOR_EXPRESSION_PROPERTY__PRETTY_NAME);
		createEAttribute(evaluatorExpressionPropertyEClass, EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_NAME);
		createEAttribute(evaluatorExpressionPropertyEClass, EVALUATOR_EXPRESSION_PROPERTY__EVALUATOR_VALUE);

		taskImplementationEClass = createEClass(TASK_IMPLEMENTATION);
		createEAttribute(taskImplementationEClass, TASK_IMPLEMENTATION__TASK_IMPLEMENTATION);
		createEReference(taskImplementationEClass, TASK_IMPLEMENTATION__TASK_PROPERTIES);

		taskPropertyEClass = createEClass(TASK_PROPERTY);

		taskEClass = createEClass(TASK);
		createEAttribute(taskEClass, TASK__TASK_NAME);
		createEAttribute(taskEClass, TASK__TASK_GROUP);
		createEReference(taskEClass, TASK__TASK_IMPLEMENTATION_CLASS);
		createEAttribute(taskEClass, TASK__TRIGGER_TYPE);
		createEAttribute(taskEClass, TASK__COUNT);
		createEAttribute(taskEClass, TASK__INTERVAL);
		createEAttribute(taskEClass, TASK__CRON);
		createEAttribute(taskEClass, TASK__PINNED_SERVERS);

		apiInSequenceConfigurationEClass = createEClass(API_IN_SEQUENCE_CONFIGURATION);

		apiOutSequenceConfigurationEClass = createEClass(API_OUT_SEQUENCE_CONFIGURATION);

		apiFaultSequenceConfigurationEClass = createEClass(API_FAULT_SEQUENCE_CONFIGURATION);

		apiResourceEClass = createEClass(API_RESOURCE);
		createEReference(apiResourceEClass, API_RESOURCE__IN_SEQUENCE_CONFIGURATION);
		createEReference(apiResourceEClass, API_RESOURCE__OUT_SEQUENCE_CONFIGURATION);
		createEReference(apiResourceEClass, API_RESOURCE__FAULT_SEQUENCE_CONFIGURATION);
		createEAttribute(apiResourceEClass, API_RESOURCE__URL_STYLE);
		createEAttribute(apiResourceEClass, API_RESOURCE__URI_TEMPLATE);
		createEAttribute(apiResourceEClass, API_RESOURCE__URL_MAPPING);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_GET);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_POST);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_PUT);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_DELETE);
		createEAttribute(apiResourceEClass, API_RESOURCE__ALLOW_OPTIONS);

		synapseAPIEClass = createEClass(SYNAPSE_API);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__API_NAME);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__CONTEXT);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__HOSTNAME);
		createEAttribute(synapseAPIEClass, SYNAPSE_API__PORT);
		createEReference(synapseAPIEClass, SYNAPSE_API__RESOURCES);

		// Create enums
		modelObjectStateEEnum = createEEnum(MODEL_OBJECT_STATE);
		taskPropertyTypeEEnum = createEEnum(TASK_PROPERTY_TYPE);
		propertyValueTypeEEnum = createEEnum(PROPERTY_VALUE_TYPE);
		targetSequenceTypeEEnum = createEEnum(TARGET_SEQUENCE_TYPE);
		targetEndpointTypeEEnum = createEEnum(TARGET_ENDPOINT_TYPE);
		endPointAddressingVersionEEnum = createEEnum(END_POINT_ADDRESSING_VERSION);
		endPointTimeOutActionEEnum = createEEnum(END_POINT_TIME_OUT_ACTION);
		endPointMessageFormatEEnum = createEEnum(END_POINT_MESSAGE_FORMAT);
		endPointAttachmentOptimizationEEnum = createEEnum(END_POINT_ATTACHMENT_OPTIMIZATION);
		endPointWsdlTypeEEnum = createEEnum(END_POINT_WSDL_TYPE);
		loadBalanceAlgorithmEEnum = createEEnum(LOAD_BALANCE_ALGORITHM);
		loadBalanceSessionTypeEEnum = createEEnum(LOAD_BALANCE_SESSION_TYPE);
		proxyWsdlTypeEEnum = createEEnum(PROXY_WSDL_TYPE);
		proxySequenceTypeEEnum = createEEnum(PROXY_SEQUENCE_TYPE);
		proxyEndpointTypeEEnum = createEEnum(PROXY_ENDPOINT_TYPE);
		localEntryValueTypeEEnum = createEEnum(LOCAL_ENTRY_VALUE_TYPE);
		esbVersionEEnum = createEEnum(ESB_VERSION);
		endPointMessageFormatRestTypeEEnum = createEEnum(END_POINT_MESSAGE_FORMAT_REST_TYPE);
		taskTriggerTypeEEnum = createEEnum(TASK_TRIGGER_TYPE);
		apiResourceUrlStyleEEnum = createEEnum(API_RESOURCE_URL_STYLE);

		// Create data types
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

		// Create type parameters
		addETypeParameter(mapEDataType, "K");
		addETypeParameter(mapEDataType, "V");

		// Set bounds for type parameters

		// Add supertypes to classes
		synapseConfigurationEClass.getESuperTypes().add(this.getModelObject());
		configurationElementEClass.getESuperTypes().add(this.getModelObject());
		mediatorEClass.getESuperTypes().add(this.getConfigurationElement());
		descriptionEClass.getESuperTypes().add(this.getModelObject());
		endPointReferenceEClass.getESuperTypes().add(this.getModelObject());
		endPointEClass.getESuperTypes().add(this.getConfigurationElement());
		unknownObjectEClass.getESuperTypes().add(this.getConfigurationElement());
		unknownObjectEClass.getESuperTypes().add(this.getEndPoint());
		unknownObjectEClass.getESuperTypes().add(this.getMediator());
		mediatorSequenceEClass.getESuperTypes().add(this.getConfigurationElement());
		mediatorBranchEClass.getESuperTypes().add(this.getModelObject());
		parentMediatorEClass.getESuperTypes().add(this.getMediator());
		namespacedPropertyEClass.getESuperTypes().add(this.getModelObject());
		registryKeyPropertyEClass.getESuperTypes().add(this.getModelObject());
		abstractNameValuePropertyEClass.getESuperTypes().add(this.getModelObject());
		abstractNameValueExpressionPropertyEClass.getESuperTypes().add(this.getModelObject());
		nameValueTypePropertyEClass.getESuperTypes().add(this.getModelObject());
		abstractBooleanFeatureEClass.getESuperTypes().add(this.getModelObject());
		abstractLocationKeyResourceEClass.getESuperTypes().add(this.getModelObject());
		abstractCommonTargetEClass.getESuperTypes().add(this.getModelObject());
		abstractEndPointEClass.getESuperTypes().add(this.getEndPoint());
		abstractDefaultEndPointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		defaultEndPointEClass.getESuperTypes().add(this.getAbstractDefaultEndPoint());
		addressEndPointEClass.getESuperTypes().add(this.getAbstractDefaultEndPoint());
		wsdlEndPointEClass.getESuperTypes().add(this.getAbstractEndPoint());
		parentEndPointEClass.getESuperTypes().add(this.getEndPoint());
		failoverEndPointEClass.getESuperTypes().add(this.getParentEndPoint());
		loadBalanceEndPointEClass.getESuperTypes().add(this.getParentEndPoint());
		dynamicLoadBalanceEndPointEClass.getESuperTypes().add(this.getEndPoint());
		dynamicLoadBalancePropertyEClass.getESuperTypes().add(this.getAbstractNameValueProperty());
		xPathEndPointReferenceEClass.getESuperTypes().add(this.getEndPointReference());
		registryKeyEndPointReferenceEClass.getESuperTypes().add(this.getEndPointReference());
		proxyServiceEClass.getESuperTypes().add(this.getConfigurationElement());
		proxyWsdlConfigurationEClass.getESuperTypes().add(this.getModelObject());
		proxyWsdlResourceEClass.getESuperTypes().add(this.getAbstractLocationKeyResource());
		proxyServiceParameterEClass.getESuperTypes().add(this.getModelObject());
		proxyServicePolicyEClass.getESuperTypes().add(this.getModelObject());
		abstractProxySequenceConfigurationEClass.getESuperTypes().add(this.getModelObject());
		proxyInSequenceConfigurationEClass.getESuperTypes().add(this.getAbstractProxySequenceConfiguration());
		proxyEndpointConfigurationEClass.getESuperTypes().add(this.getModelObject());
		proxyOutSequenceConfigurationEClass.getESuperTypes().add(this.getAbstractProxySequenceConfiguration());
		proxyFaultSequenceConfigurationEClass.getESuperTypes().add(this.getAbstractProxySequenceConfiguration());
		localEntryEClass.getESuperTypes().add(this.getConfigurationElement());
		evaluatorExpressionPropertyEClass.getESuperTypes().add(this.getModelObject());
		taskImplementationEClass.getESuperTypes().add(this.getModelObject());
		taskPropertyEClass.getESuperTypes().add(this.getNameValueTypeProperty());
		taskEClass.getESuperTypes().add(this.getConfigurationElement());
		apiInSequenceConfigurationEClass.getESuperTypes().add(this.getAbstractProxySequenceConfiguration());
		apiOutSequenceConfigurationEClass.getESuperTypes().add(this.getAbstractProxySequenceConfiguration());
		apiFaultSequenceConfigurationEClass.getESuperTypes().add(this.getAbstractProxySequenceConfiguration());
		apiResourceEClass.getESuperTypes().add(this.getModelObject());
		synapseAPIEClass.getESuperTypes().add(this.getConfigurationElement());

		// Initialize classes and features; add operations and parameters
		initEClass(modelObjectEClass, ModelObject.class, "ModelObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelObject_ObjectState(), this.getModelObjectState(), "objectState", "NORMAL", 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelObject_SourceText(), ecorePackage.getEString(), "sourceText", null, 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelObject_DefaultNamespace(), this.getNamespace(), null, "defaultNamespace", null, 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelObject_AdditionalNamespaces(), this.getNamespace(), null, "additionalNamespaces", null, 0, -1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelObject_CurrentEsbVersion(), this.getEsbVersion(), "currentEsbVersion", null, 0, 1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelObject_Comment(), this.getComment(), null, "comment", null, 0, -1, ModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namespaceEClass, Namespace.class, "Namespace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamespace_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, Namespace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamespace_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Namespace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(synapseConfigurationEClass, SynapseConfiguration.class, "SynapseConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSynapseConfiguration_ConfigurationElements(), this.getConfigurationElement(), null, "configurationElements", null, 1, -1, SynapseConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynapseConfiguration_SchemaLocation(), ecorePackage.getEString(), "schemaLocation", "default_location", 0, 1, SynapseConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationElementEClass, ConfigurationElement.class, "ConfigurationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mediatorEClass, Mediator.class, "Mediator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMediator_Description(), this.getDescription(), null, "description", null, 0, 1, Mediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescription_Value(), ecorePackage.getEString(), "value", null, 0, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComment_Value(), ecorePackage.getEString(), "value", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComment_Position(), ecorePackage.getEInt(), "position", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endPointReferenceEClass, EndPointReference.class, "EndPointReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEndPoint_Anonymous(), ecorePackage.getEBoolean(), "anonymous", "false", 0, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndPoint_EndpointName(), ecorePackage.getEString(), "endpointName", "endpoint_name", 0, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unknownObjectEClass, UnknownObject.class, "UnknownObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mediatorSequenceEClass, MediatorSequence.class, "MediatorSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMediatorSequence_Anonymous(), ecorePackage.getEBoolean(), "anonymous", "false", 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMediatorSequence_SequenceName(), ecorePackage.getEString(), "sequenceName", "sequence_name", 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediatorSequence_Mediators(), this.getMediator(), null, "mediators", null, 0, -1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediatorSequence_OnError(), this.getRegistryKeyProperty(), null, "onError", null, 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMediatorSequence_Description(), this.getDescription(), null, "description", null, 0, 1, MediatorSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mediatorBranchEClass, MediatorBranch.class, "MediatorBranch", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMediatorBranch_Children(), this.getMediator(), null, "children", null, 0, -1, MediatorBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parentMediatorEClass, ParentMediator.class, "ParentMediator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParentMediator_Children(), this.getMediator(), null, "children", null, 0, -1, ParentMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namespacedPropertyEClass, NamespacedProperty.class, "NamespacedProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamespacedProperty_PrettyName(), ecorePackage.getEString(), "prettyName", "Namespaced Property", 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamespacedProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "propertyName", 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamespacedProperty_PropertyValue(), ecorePackage.getEString(), "propertyValue", null, 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getNamespacedProperty_Namespaces(), g1, "namespaces", null, 0, 1, NamespacedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registryKeyPropertyEClass, RegistryKeyProperty.class, "RegistryKeyProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegistryKeyProperty_PrettyName(), ecorePackage.getEString(), "prettyName", "Registry Key", 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistryKeyProperty_KeyName(), ecorePackage.getEString(), "keyName", "keyName", 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistryKeyProperty_KeyValue(), ecorePackage.getEString(), "keyValue", null, 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getRegistryKeyProperty_Filters(), g1, "filters", null, 0, 1, RegistryKeyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractNameValuePropertyEClass, AbstractNameValueProperty.class, "AbstractNameValueProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractNameValueProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "property_name", 0, 1, AbstractNameValueProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueProperty_PropertyValue(), ecorePackage.getEString(), "propertyValue", "property_value", 0, 1, AbstractNameValueProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractNameValueExpressionPropertyEClass, AbstractNameValueExpressionProperty.class, "AbstractNameValueExpressionProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractNameValueExpressionProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "property_name", 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueExpressionProperty_PropertyValueType(), this.getPropertyValueType(), "propertyValueType", "VALUE", 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractNameValueExpressionProperty_PropertyValue(), ecorePackage.getEString(), "propertyValue", "property_value", 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractNameValueExpressionProperty_PropertyExpression(), this.getNamespacedProperty(), null, "propertyExpression", null, 0, 1, AbstractNameValueExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameValueTypePropertyEClass, NameValueTypeProperty.class, "NameValueTypeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameValueTypeProperty_PropertyName(), ecorePackage.getEString(), "PropertyName", null, 1, 1, NameValueTypeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNameValueTypeProperty_PropertyType(), this.getTaskPropertyType(), "PropertyType", null, 1, 1, NameValueTypeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNameValueTypeProperty_PropertyValue(), ecorePackage.getEString(), "PropertyValue", null, 1, 1, NameValueTypeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractBooleanFeatureEClass, AbstractBooleanFeature.class, "AbstractBooleanFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractBooleanFeature_FeatureName(), ecorePackage.getEString(), "featureName", "feature_name", 0, 1, AbstractBooleanFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractBooleanFeature_FeatureEnabled(), ecorePackage.getEBoolean(), "featureEnabled", "true", 0, 1, AbstractBooleanFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractLocationKeyResourceEClass, AbstractLocationKeyResource.class, "AbstractLocationKeyResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractLocationKeyResource_Location(), ecorePackage.getEString(), "location", "default_location", 0, 1, AbstractLocationKeyResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractLocationKeyResource_Key(), this.getRegistryKeyProperty(), null, "key", null, 0, 1, AbstractLocationKeyResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractCommonTargetEClass, AbstractCommonTarget.class, "AbstractCommonTarget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractCommonTarget_SequenceType(), this.getTargetSequenceType(), "sequenceType", "NONE", 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_Sequence(), this.getMediatorSequence(), null, "sequence", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractCommonTarget_EndpointType(), this.getTargetEndpointType(), "endpointType", "NONE", 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_Endpoint(), this.getEndPoint(), null, "endpoint", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractCommonTarget_EndpointKey(), this.getRegistryKeyProperty(), null, "endpointKey", null, 0, 1, AbstractCommonTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractEndPointEClass, AbstractEndPoint.class, "AbstractEndPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractEndPoint_ReliableMessagingEnabled(), ecorePackage.getEBoolean(), "reliableMessagingEnabled", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SecurityEnabled(), ecorePackage.getEBoolean(), "securityEnabled", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_AddressingEnabled(), ecorePackage.getEBoolean(), "addressingEnabled", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_AddressingVersion(), this.getEndPointAddressingVersion(), "addressingVersion", "final", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_AddressingSeparateListener(), ecorePackage.getEBoolean(), "addressingSeparateListener", "false", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_TimeOutDuration(), ecorePackage.getELong(), "timeOutDuration", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_TimeOutAction(), this.getEndPointTimeOutAction(), "timeOutAction", "discard", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_RetryErrorCodes(), ecorePackage.getEString(), "retryErrorCodes", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_RetryCount(), ecorePackage.getEInt(), "retryCount", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_RetryDelay(), ecorePackage.getELong(), "retryDelay", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendErrorCodes(), ecorePackage.getEString(), "suspendErrorCodes", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendInitialDuration(), ecorePackage.getELong(), "suspendInitialDuration", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendMaximumDuration(), ecorePackage.getELong(), "suspendMaximumDuration", "0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractEndPoint_SuspendProgressionFactor(), ecorePackage.getEFloat(), "suspendProgressionFactor", "1.0", 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractEndPoint_ReliableMessagingPolicy(), this.getRegistryKeyProperty(), null, "reliableMessagingPolicy", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractEndPoint_SecurityPolicy(), this.getRegistryKeyProperty(), null, "securityPolicy", null, 0, 1, AbstractEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractDefaultEndPointEClass, AbstractDefaultEndPoint.class, "AbstractDefaultEndPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractDefaultEndPoint_MessageFormat(), this.getEndPointMessageFormat(), "messageFormat", "LEAVE_AS_IS", 0, 1, AbstractDefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractDefaultEndPoint_AttachmentOptimization(), this.getEndPointAttachmentOptimization(), "attachmentOptimization", "LEAVE_AS_IS", 0, 1, AbstractDefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractDefaultEndPoint_Encoding(), ecorePackage.getEString(), "encoding", "UTF-8", 0, 1, AbstractDefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractDefaultEndPoint_StatisticsEnabled(), ecorePackage.getEBoolean(), "statisticsEnabled", "false", 0, 1, AbstractDefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractDefaultEndPoint_TraceEnabled(), ecorePackage.getEBoolean(), "traceEnabled", "false", 0, 1, AbstractDefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractDefaultEndPoint_RestType(), this.getEndPointMessageFormatRestType(), "restType", "get", 0, 1, AbstractDefaultEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultEndPointEClass, DefaultEndPoint.class, "DefaultEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressEndPointEClass, AddressEndPoint.class, "AddressEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddressEndPoint_Uri(), ecorePackage.getEString(), "uri", "http://default/address/endpoint/uri", 0, 1, AddressEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wsdlEndPointEClass, WsdlEndPoint.class, "WsdlEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWsdlEndPoint_WsdlType(), this.getEndPointWsdlType(), "wsdlType", "URI", 0, 1, WsdlEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWsdlEndPoint_WsdlURI(), ecorePackage.getEString(), "wsdlURI", "http://default/wsdl/uri", 0, 1, WsdlEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWsdlEndPoint_WsdlXML(), ecorePackage.getEString(), "wsdlXML", "<definitions/>", 0, 1, WsdlEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWsdlEndPoint_Service(), ecorePackage.getEString(), "service", "Service", 0, 1, WsdlEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWsdlEndPoint_Port(), ecorePackage.getEString(), "port", "Port", 0, 1, WsdlEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parentEndPointEClass, ParentEndPoint.class, "ParentEndPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParentEndPoint_Children(), this.getEndPoint(), null, "children", null, 0, -1, ParentEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(failoverEndPointEClass, FailoverEndPoint.class, "FailoverEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadBalanceEndPointEClass, LoadBalanceEndPoint.class, "LoadBalanceEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadBalanceEndPoint_Algorithm(), this.getLoadBalanceAlgorithm(), "algorithm", "org.apache.synapse.endpoints.algorithms.RoundRobin", 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadBalanceEndPoint_SessionType(), this.getLoadBalanceSessionType(), "sessionType", "NONE", 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadBalanceEndPoint_SessionTimeout(), ecorePackage.getELong(), "sessionTimeout", "0", 0, 1, LoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicLoadBalanceEndPointEClass, DynamicLoadBalanceEndPoint.class, "DynamicLoadBalanceEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicLoadBalanceEndPoint_Algorithm(), this.getLoadBalanceAlgorithm(), "algorithm", "ROUND_ROBIN", 0, 1, DynamicLoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDynamicLoadBalanceEndPoint_FailoverEnabled(), ecorePackage.getEBoolean(), "failoverEnabled", "true", 0, 1, DynamicLoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDynamicLoadBalanceEndPoint_MembershipHandlerClass(), ecorePackage.getEString(), "membershipHandlerClass", "class_name", 0, 1, DynamicLoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicLoadBalanceEndPoint_Properties(), this.getDynamicLoadBalanceProperty(), null, "properties", null, 0, -1, DynamicLoadBalanceEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicLoadBalancePropertyEClass, DynamicLoadBalanceProperty.class, "DynamicLoadBalanceProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xPathEndPointReferenceEClass, XPathEndPointReference.class, "XPathEndPointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXPathEndPointReference_EndpointXpath(), this.getNamespacedProperty(), null, "endpointXpath", null, 0, 1, XPathEndPointReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registryKeyEndPointReferenceEClass, RegistryKeyEndPointReference.class, "RegistryKeyEndPointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistryKeyEndPointReference_EndpointKey(), this.getRegistryKeyProperty(), null, "endpointKey", null, 0, 1, RegistryKeyEndPointReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyServiceEClass, ProxyService.class, "ProxyService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProxyService_Name(), ecorePackage.getEString(), "name", "service_name", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_PinnedServers(), ecorePackage.getEString(), "pinnedServers", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_ServiceGroup(), ecorePackage.getEString(), "serviceGroup", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_TraceEnabled(), ecorePackage.getEBoolean(), "traceEnabled", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_StatisticsEnabled(), ecorePackage.getEBoolean(), "statisticsEnabled", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_Transports(), ecorePackage.getEString(), "transports", "https,http", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_ReliableMessagingEnabled(), ecorePackage.getEBoolean(), "reliableMessagingEnabled", "false", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyService_SecurityEnabled(), ecorePackage.getEBoolean(), "securityEnabled", "false", 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_WsdlConfiguration(), this.getProxyWsdlConfiguration(), null, "wsdlConfiguration", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_InSequenceConfiguration(), this.getProxyInSequenceConfiguration(), null, "inSequenceConfiguration", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_EndpointConfiguration(), this.getProxyEndpointConfiguration(), null, "endpointConfiguration", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_OutSequenceConfiguration(), this.getProxyOutSequenceConfiguration(), null, "outSequenceConfiguration", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_FaultSequenceConfiguration(), this.getProxyFaultSequenceConfiguration(), null, "faultSequenceConfiguration", null, 0, 1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_ServiceParameters(), this.getProxyServiceParameter(), null, "serviceParameters", null, 0, -1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyService_ServicePolicies(), this.getProxyServicePolicy(), null, "servicePolicies", null, 0, -1, ProxyService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyWsdlConfigurationEClass, ProxyWsdlConfiguration.class, "ProxyWsdlConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProxyWsdlConfiguration_WsdlType(), this.getProxyWsdlType(), "wsdlType", "NONE", 0, 1, ProxyWsdlConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyWsdlConfiguration_WsdlXML(), ecorePackage.getEString(), "wsdlXML", "<definitions/>", 0, 1, ProxyWsdlConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyWsdlConfiguration_WsdlURL(), ecorePackage.getEString(), "wsdlURL", "http://default/wsdl/url", 0, 1, ProxyWsdlConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyWsdlConfiguration_WsdlKey(), this.getRegistryKeyProperty(), null, "wsdlKey", null, 0, 1, ProxyWsdlConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyWsdlConfiguration_WsdlResources(), this.getProxyWsdlResource(), null, "wsdlResources", null, 0, -1, ProxyWsdlConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyWsdlResourceEClass, ProxyWsdlResource.class, "ProxyWsdlResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyServiceParameterEClass, ProxyServiceParameter.class, "ProxyServiceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProxyServiceParameter_Name(), ecorePackage.getEString(), "name", "parameter_name", 0, 1, ProxyServiceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyServiceParameter_Value(), ecorePackage.getEString(), "value", "parameter_value", 0, 1, ProxyServiceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyServicePolicyEClass, ProxyServicePolicy.class, "ProxyServicePolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProxyServicePolicy_PolicyKey(), this.getRegistryKeyProperty(), null, "policyKey", null, 0, 1, ProxyServicePolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractProxySequenceConfigurationEClass, AbstractProxySequenceConfiguration.class, "AbstractProxySequenceConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractProxySequenceConfiguration_SequenceType(), this.getProxySequenceType(), "sequenceType", "ANONYMOUS", 0, 1, AbstractProxySequenceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProxySequenceConfiguration_InlineSequence(), this.getMediatorSequence(), null, "inlineSequence", null, 0, 1, AbstractProxySequenceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProxySequenceConfiguration_SequenceKey(), this.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, AbstractProxySequenceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractProxySequenceConfiguration_SequenceName(), ecorePackage.getEString(), "sequenceName", "sequence_name", 0, 1, AbstractProxySequenceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyInSequenceConfigurationEClass, ProxyInSequenceConfiguration.class, "ProxyInSequenceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyEndpointConfigurationEClass, ProxyEndpointConfiguration.class, "ProxyEndpointConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProxyEndpointConfiguration_EndpointType(), this.getProxyEndpointType(), "endpointType", "ANONYMOUS", 0, 1, ProxyEndpointConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyEndpointConfiguration_InlineEndpoint(), this.getEndPoint(), null, "inlineEndpoint", null, 0, 1, ProxyEndpointConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProxyEndpointConfiguration_EndpointKey(), this.getRegistryKeyProperty(), null, "endpointKey", null, 0, 1, ProxyEndpointConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProxyEndpointConfiguration_EndpointName(), ecorePackage.getEString(), "endpointName", "endpoint_name", 0, 1, ProxyEndpointConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyOutSequenceConfigurationEClass, ProxyOutSequenceConfiguration.class, "ProxyOutSequenceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(proxyFaultSequenceConfigurationEClass, ProxyFaultSequenceConfiguration.class, "ProxyFaultSequenceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localEntryEClass, LocalEntry.class, "LocalEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalEntry_EntryName(), ecorePackage.getEString(), "entryName", "entry_name", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_ValueType(), this.getLocalEntryValueType(), "valueType", "LITERAL", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "entry_value", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_ValueXML(), ecorePackage.getEString(), "valueXML", "<value/>", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocalEntry_ValueURL(), ecorePackage.getEString(), "valueURL", "file:/path/to/resource.ext", 0, 1, LocalEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evaluatorExpressionPropertyEClass, EvaluatorExpressionProperty.class, "EvaluatorExpressionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvaluatorExpressionProperty_PrettyName(), ecorePackage.getEString(), "prettyName", null, 0, 1, EvaluatorExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvaluatorExpressionProperty_EvaluatorName(), ecorePackage.getEString(), "evaluatorName", null, 0, 1, EvaluatorExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvaluatorExpressionProperty_EvaluatorValue(), ecorePackage.getEString(), "evaluatorValue", null, 0, 1, EvaluatorExpressionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskImplementationEClass, TaskImplementation.class, "TaskImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaskImplementation_TaskImplementation(), ecorePackage.getEString(), "TaskImplementation", "org.apache.synapse.startup.tasks.MessageInjector", 1, 1, TaskImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTaskImplementation_TaskProperties(), this.getTaskProperty(), null, "TaskProperties", null, 0, -1, TaskImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskPropertyEClass, TaskProperty.class, "TaskProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTask_TaskName(), ecorePackage.getEString(), "TaskName", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_TaskGroup(), ecorePackage.getEString(), "TaskGroup", "synapse.simple.quartz", 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_TaskImplementationClass(), this.getTaskImplementation(), null, "TaskImplementationClass", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_TriggerType(), this.getTaskTriggerType(), "TriggerType", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Count(), ecorePackage.getELong(), "Count", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Interval(), ecorePackage.getELong(), "Interval", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Cron(), ecorePackage.getEString(), "Cron", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_PinnedServers(), ecorePackage.getEString(), "PinnedServers", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(apiInSequenceConfigurationEClass, ApiInSequenceConfiguration.class, "ApiInSequenceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiOutSequenceConfigurationEClass, ApiOutSequenceConfiguration.class, "ApiOutSequenceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiFaultSequenceConfigurationEClass, ApiFaultSequenceConfiguration.class, "ApiFaultSequenceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(apiResourceEClass, ApiResource.class, "ApiResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApiResource_InSequenceConfiguration(), this.getApiInSequenceConfiguration(), null, "inSequenceConfiguration", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApiResource_OutSequenceConfiguration(), this.getApiOutSequenceConfiguration(), null, "outSequenceConfiguration", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApiResource_FaultSequenceConfiguration(), this.getApiFaultSequenceConfiguration(), null, "faultSequenceConfiguration", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_UrlStyle(), this.getApiResourceUrlStyle(), "urlStyle", "0", 1, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_UriTemplate(), ecorePackage.getEString(), "uriTemplate", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_UrlMapping(), ecorePackage.getEString(), "urlMapping", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_AllowGet(), ecorePackage.getEBoolean(), "allowGet", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_AllowPost(), ecorePackage.getEBoolean(), "allowPost", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_AllowPut(), ecorePackage.getEBoolean(), "allowPut", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_AllowDelete(), ecorePackage.getEBoolean(), "allowDelete", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApiResource_AllowOptions(), ecorePackage.getEBoolean(), "allowOptions", null, 0, 1, ApiResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(synapseAPIEClass, SynapseAPI.class, "SynapseAPI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSynapseAPI_ApiName(), ecorePackage.getEString(), "apiName", "api_name", 1, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynapseAPI_Context(), ecorePackage.getEString(), "context", "/context", 1, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynapseAPI_Hostname(), ecorePackage.getEString(), "hostname", null, 0, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynapseAPI_Port(), ecorePackage.getEInt(), "port", null, 0, 1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynapseAPI_Resources(), this.getApiResource(), null, "resources", null, 0, -1, SynapseAPI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(modelObjectStateEEnum, ModelObjectState.class, "ModelObjectState");
		addEEnumLiteral(modelObjectStateEEnum, ModelObjectState.NORMAL);
		addEEnumLiteral(modelObjectStateEEnum, ModelObjectState.WORKING);
		addEEnumLiteral(modelObjectStateEEnum, ModelObjectState.INCOMPLETE);
		addEEnumLiteral(modelObjectStateEEnum, ModelObjectState.INVALID);

		initEEnum(taskPropertyTypeEEnum, TaskPropertyType.class, "TaskPropertyType");
		addEEnumLiteral(taskPropertyTypeEEnum, TaskPropertyType.LITERAL);
		addEEnumLiteral(taskPropertyTypeEEnum, TaskPropertyType.XML);

		initEEnum(propertyValueTypeEEnum, PropertyValueType.class, "PropertyValueType");
		addEEnumLiteral(propertyValueTypeEEnum, PropertyValueType.VALUE);
		addEEnumLiteral(propertyValueTypeEEnum, PropertyValueType.EXPRESSION);

		initEEnum(targetSequenceTypeEEnum, TargetSequenceType.class, "TargetSequenceType");
		addEEnumLiteral(targetSequenceTypeEEnum, TargetSequenceType.NONE);
		addEEnumLiteral(targetSequenceTypeEEnum, TargetSequenceType.ANONYMOUS);
		addEEnumLiteral(targetSequenceTypeEEnum, TargetSequenceType.REGISTRY_REFERENCE);

		initEEnum(targetEndpointTypeEEnum, TargetEndpointType.class, "TargetEndpointType");
		addEEnumLiteral(targetEndpointTypeEEnum, TargetEndpointType.NONE);
		addEEnumLiteral(targetEndpointTypeEEnum, TargetEndpointType.ANONYMOUS);
		addEEnumLiteral(targetEndpointTypeEEnum, TargetEndpointType.REGISTRY_REFERENCE);

		initEEnum(endPointAddressingVersionEEnum, EndPointAddressingVersion.class, "EndPointAddressingVersion");
		addEEnumLiteral(endPointAddressingVersionEEnum, EndPointAddressingVersion.FINAL);
		addEEnumLiteral(endPointAddressingVersionEEnum, EndPointAddressingVersion.SUBMISSION);

		initEEnum(endPointTimeOutActionEEnum, EndPointTimeOutAction.class, "EndPointTimeOutAction");
		addEEnumLiteral(endPointTimeOutActionEEnum, EndPointTimeOutAction.DISCARD);
		addEEnumLiteral(endPointTimeOutActionEEnum, EndPointTimeOutAction.FAULT);

		initEEnum(endPointMessageFormatEEnum, EndPointMessageFormat.class, "EndPointMessageFormat");
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.LEAVE_AS_IS);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.SOAP_11);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.SOAP_12);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.POX);
		addEEnumLiteral(endPointMessageFormatEEnum, EndPointMessageFormat.GET);

		initEEnum(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.class, "EndPointAttachmentOptimization");
		addEEnumLiteral(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.LEAVE_AS_IS);
		addEEnumLiteral(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.MTOM);
		addEEnumLiteral(endPointAttachmentOptimizationEEnum, EndPointAttachmentOptimization.SWA);

		initEEnum(endPointWsdlTypeEEnum, EndPointWsdlType.class, "EndPointWsdlType");
		addEEnumLiteral(endPointWsdlTypeEEnum, EndPointWsdlType.URI);
		addEEnumLiteral(endPointWsdlTypeEEnum, EndPointWsdlType.INLINE);

		initEEnum(loadBalanceAlgorithmEEnum, LoadBalanceAlgorithm.class, "LoadBalanceAlgorithm");
		addEEnumLiteral(loadBalanceAlgorithmEEnum, LoadBalanceAlgorithm.ROUND_ROBIN);

		initEEnum(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.class, "LoadBalanceSessionType");
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.NONE);
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.TRANSPORT);
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.SOAP);
		addEEnumLiteral(loadBalanceSessionTypeEEnum, LoadBalanceSessionType.CLIENT_ID);

		initEEnum(proxyWsdlTypeEEnum, ProxyWsdlType.class, "ProxyWsdlType");
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.NONE);
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.INLINE);
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.SOURCE_URL);
		addEEnumLiteral(proxyWsdlTypeEEnum, ProxyWsdlType.REGISTRY_KEY);

		initEEnum(proxySequenceTypeEEnum, ProxySequenceType.class, "ProxySequenceType");
		addEEnumLiteral(proxySequenceTypeEEnum, ProxySequenceType.NONE);
		addEEnumLiteral(proxySequenceTypeEEnum, ProxySequenceType.ANONYMOUS);
		addEEnumLiteral(proxySequenceTypeEEnum, ProxySequenceType.REGISTRY_REFERENCE);
		addEEnumLiteral(proxySequenceTypeEEnum, ProxySequenceType.NAMED_REFERENCE);

		initEEnum(proxyEndpointTypeEEnum, ProxyEndpointType.class, "ProxyEndpointType");
		addEEnumLiteral(proxyEndpointTypeEEnum, ProxyEndpointType.NONE);
		addEEnumLiteral(proxyEndpointTypeEEnum, ProxyEndpointType.ANONYMOUS);
		addEEnumLiteral(proxyEndpointTypeEEnum, ProxyEndpointType.REGISTRY_REFERENCE);
		addEEnumLiteral(proxyEndpointTypeEEnum, ProxyEndpointType.NAMED_REFERENCE);

		initEEnum(localEntryValueTypeEEnum, LocalEntryValueType.class, "LocalEntryValueType");
		addEEnumLiteral(localEntryValueTypeEEnum, LocalEntryValueType.LITERAL);
		addEEnumLiteral(localEntryValueTypeEEnum, LocalEntryValueType.XML);
		addEEnumLiteral(localEntryValueTypeEEnum, LocalEntryValueType.URL);

		initEEnum(esbVersionEEnum, EsbVersion.class, "EsbVersion");
		addEEnumLiteral(esbVersionEEnum, EsbVersion.ESB301);
		addEEnumLiteral(esbVersionEEnum, EsbVersion.ESB400);

		initEEnum(endPointMessageFormatRestTypeEEnum, EndPointMessageFormatRestType.class, "EndPointMessageFormatRestType");
		addEEnumLiteral(endPointMessageFormatRestTypeEEnum, EndPointMessageFormatRestType.GET);
		addEEnumLiteral(endPointMessageFormatRestTypeEEnum, EndPointMessageFormatRestType.POST);

		initEEnum(taskTriggerTypeEEnum, TaskTriggerType.class, "TaskTriggerType");
		addEEnumLiteral(taskTriggerTypeEEnum, TaskTriggerType.SIMPLE);
		addEEnumLiteral(taskTriggerTypeEEnum, TaskTriggerType.CRON);

		initEEnum(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.class, "ApiResourceUrlStyle");
		addEEnumLiteral(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.NONE);
		addEEnumLiteral(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.URI_TEMPLATE);
		addEEnumLiteral(apiResourceUrlStyleEEnum, ApiResourceUrlStyle.URL_MAPPING);

		// Initialize data types
		initEDataType(mapEDataType, Map.class, "Map", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
	
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProxyWsdlConfiguration_WsdlKey() {
		return (EReference)proxyWsdlConfigurationEClass.getEStructuralFeatures().get(3);
	}

} //SequencePackageImpl
