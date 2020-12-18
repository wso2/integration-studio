/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.gmf.esb.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.wso2.integrationstudio.gmf.esb.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage
 * @generated
 */
public class EsbAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static EsbPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EsbAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = EsbPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance
     * object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */

    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EsbSwitch<Adapter> modelSwitch = new EsbSwitch<Adapter>() {
            @Override
            public Adapter caseEsbDiagram(EsbDiagram object) {
                return createEsbDiagramAdapter();
            }
            @Override
            public Adapter caseEsbNode(EsbNode object) {
                return createEsbNodeAdapter();
            }
            @Override
            public Adapter caseEsbElement(EsbElement object) {
                return createEsbElementAdapter();
            }
            @Override
            public Adapter caseEsbServer(EsbServer object) {
                return createEsbServerAdapter();
            }
            @Override
            public Adapter caseMediator(Mediator object) {
                return createMediatorAdapter();
            }
            @Override
            public Adapter caseEsbConnector(EsbConnector object) {
                return createEsbConnectorAdapter();
            }
            @Override
            public Adapter caseInputConnector(InputConnector object) {
                return createInputConnectorAdapter();
            }
            @Override
            public Adapter caseOutputConnector(OutputConnector object) {
                return createOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAdditionalOutputConnector(AdditionalOutputConnector object) {
                return createAdditionalOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEsbLink(EsbLink object) {
                return createEsbLinkAdapter();
            }
            @Override
            public Adapter caseEndPoint(EndPoint object) {
                return createEndPointAdapter();
            }
            @Override
            public Adapter caseCallMediator(CallMediator object) {
                return createCallMediatorAdapter();
            }
            @Override
            public Adapter caseCallMediatorInputConnector(CallMediatorInputConnector object) {
                return createCallMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseCallMediatorOutputConnector(CallMediatorOutputConnector object) {
                return createCallMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseCallMediatorEndpointOutputConnector(CallMediatorEndpointOutputConnector object) {
                return createCallMediatorEndpointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEndPointProperty(EndPointProperty object) {
                return createEndPointPropertyAdapter();
            }
            @Override
            public Adapter caseProxyService(ProxyService object) {
                return createProxyServiceAdapter();
            }
            @Override
            public Adapter caseProxyOutputConnector(ProxyOutputConnector object) {
                return createProxyOutputConnectorAdapter();
            }
            @Override
            public Adapter caseProxyInputConnector(ProxyInputConnector object) {
                return createProxyInputConnectorAdapter();
            }
            @Override
            public Adapter caseProxyOutSequenceOutputConnector(ProxyOutSequenceOutputConnector object) {
                return createProxyOutSequenceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseProxyInSequenceInputConnector(ProxyInSequenceInputConnector object) {
                return createProxyInSequenceInputConnectorAdapter();
            }
            @Override
            public Adapter caseProxyWSDLResource(ProxyWSDLResource object) {
                return createProxyWSDLResourceAdapter();
            }
            @Override
            public Adapter caseProxyFaultInputConnector(ProxyFaultInputConnector object) {
                return createProxyFaultInputConnectorAdapter();
            }
            @Override
            public Adapter caseProxyServiceParameter(ProxyServiceParameter object) {
                return createProxyServiceParameterAdapter();
            }
            @Override
            public Adapter caseProxyServicePolicy(ProxyServicePolicy object) {
                return createProxyServicePolicyAdapter();
            }
            @Override
            public Adapter caseProxyServiceSequenceAndEndpointContainer(ProxyServiceSequenceAndEndpointContainer object) {
                return createProxyServiceSequenceAndEndpointContainerAdapter();
            }
            @Override
            public Adapter caseProxyServiceFaultContainer(ProxyServiceFaultContainer object) {
                return createProxyServiceFaultContainerAdapter();
            }
            @Override
            public Adapter caseProxyServiceContainer(ProxyServiceContainer object) {
                return createProxyServiceContainerAdapter();
            }
            @Override
            public Adapter caseMediatorFlow(MediatorFlow object) {
                return createMediatorFlowAdapter();
            }
            @Override
            public Adapter caseEndpointFlow(EndpointFlow object) {
                return createEndpointFlowAdapter();
            }
            @Override
            public Adapter caseAbstractEndPoint(AbstractEndPoint object) {
                return createAbstractEndPointAdapter();
            }
            @Override
            public Adapter caseMessageMediator(MessageMediator object) {
                return createMessageMediatorAdapter();
            }
            @Override
            public Adapter caseMessageInputConnector(MessageInputConnector object) {
                return createMessageInputConnectorAdapter();
            }
            @Override
            public Adapter caseMessageOutputConnector(MessageOutputConnector object) {
                return createMessageOutputConnectorAdapter();
            }
            @Override
            public Adapter caseDefaultEndPoint(DefaultEndPoint object) {
                return createDefaultEndPointAdapter();
            }
            @Override
            public Adapter caseDefaultEndPointInputConnector(DefaultEndPointInputConnector object) {
                return createDefaultEndPointInputConnectorAdapter();
            }
            @Override
            public Adapter caseDefaultEndPointOutputConnector(DefaultEndPointOutputConnector object) {
                return createDefaultEndPointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAddressEndPoint(AddressEndPoint object) {
                return createAddressEndPointAdapter();
            }
            @Override
            public Adapter caseAddressEndPointInputConnector(AddressEndPointInputConnector object) {
                return createAddressEndPointInputConnectorAdapter();
            }
            @Override
            public Adapter caseAddressEndPointOutputConnector(AddressEndPointOutputConnector object) {
                return createAddressEndPointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseTemplateEndpoint(TemplateEndpoint object) {
                return createTemplateEndpointAdapter();
            }
            @Override
            public Adapter caseTemplateEndpointInputConnector(TemplateEndpointInputConnector object) {
                return createTemplateEndpointInputConnectorAdapter();
            }
            @Override
            public Adapter caseTemplateEndpointOutputConnector(TemplateEndpointOutputConnector object) {
                return createTemplateEndpointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseTemplateEndpointParameter(TemplateEndpointParameter object) {
                return createTemplateEndpointParameterAdapter();
            }
            @Override
            public Adapter caseHTTPEndpoint(HTTPEndpoint object) {
                return createHTTPEndpointAdapter();
            }
            @Override
            public Adapter caseHTTPEndPointInputConnector(HTTPEndPointInputConnector object) {
                return createHTTPEndPointInputConnectorAdapter();
            }
            @Override
            public Adapter caseHTTPEndPointOutputConnector(HTTPEndPointOutputConnector object) {
                return createHTTPEndPointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseDropMediator(DropMediator object) {
                return createDropMediatorAdapter();
            }
            @Override
            public Adapter caseDropMediatorInputConnector(DropMediatorInputConnector object) {
                return createDropMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseFilterMediator(FilterMediator object) {
                return createFilterMediatorAdapter();
            }
            @Override
            public Adapter caseFilterContainer(FilterContainer object) {
                return createFilterContainerAdapter();
            }
            @Override
            public Adapter caseFilterPassContainer(FilterPassContainer object) {
                return createFilterPassContainerAdapter();
            }
            @Override
            public Adapter caseFilterFailContainer(FilterFailContainer object) {
                return createFilterFailContainerAdapter();
            }
            @Override
            public Adapter caseFilterMediatorInputConnector(FilterMediatorInputConnector object) {
                return createFilterMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseFilterMediatorOutputConnector(FilterMediatorOutputConnector object) {
                return createFilterMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseFilterMediatorPassOutputConnector(FilterMediatorPassOutputConnector object) {
                return createFilterMediatorPassOutputConnectorAdapter();
            }
            @Override
            public Adapter caseFilterMediatorFailOutputConnector(FilterMediatorFailOutputConnector object) {
                return createFilterMediatorFailOutputConnectorAdapter();
            }
            @Override
            public Adapter caseMergeNode(MergeNode object) {
                return createMergeNodeAdapter();
            }
            @Override
            public Adapter caseMergeNodeFirstInputConnector(MergeNodeFirstInputConnector object) {
                return createMergeNodeFirstInputConnectorAdapter();
            }
            @Override
            public Adapter caseMergeNodeSecondInputConnector(MergeNodeSecondInputConnector object) {
                return createMergeNodeSecondInputConnectorAdapter();
            }
            @Override
            public Adapter caseMergeNodeOutputConnector(MergeNodeOutputConnector object) {
                return createMergeNodeOutputConnectorAdapter();
            }
            @Override
            public Adapter caseLogMediator(LogMediator object) {
                return createLogMediatorAdapter();
            }
            @Override
            public Adapter caseLogMediatorInputConnector(LogMediatorInputConnector object) {
                return createLogMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseLogMediatorOutputConnector(LogMediatorOutputConnector object) {
                return createLogMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseLogProperty(LogProperty object) {
                return createLogPropertyAdapter();
            }
            @Override
            public Adapter casePublishEventMediator(PublishEventMediator object) {
                return createPublishEventMediatorAdapter();
            }
            @Override
            public Adapter casePublishEventMediatorInputConnector(PublishEventMediatorInputConnector object) {
                return createPublishEventMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter casePublishEventMediatorOutputConnector(PublishEventMediatorOutputConnector object) {
                return createPublishEventMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter casePublishEventMediatorAttribute(PublishEventMediatorAttribute object) {
                return createPublishEventMediatorAttributeAdapter();
            }
            @Override
            public Adapter caseAbstractNameValueExpressionAttribute(AbstractNameValueExpressionAttribute object) {
                return createAbstractNameValueExpressionAttributeAdapter();
            }
            @Override
            public Adapter caseBAMMediator(BAMMediator object) {
                return createBAMMediatorAdapter();
            }
            @Override
            public Adapter caseBAMMediatorInputConnector(BAMMediatorInputConnector object) {
                return createBAMMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseBAMMediatorOutputConnector(BAMMediatorOutputConnector object) {
                return createBAMMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseBeanMediator(BeanMediator object) {
                return createBeanMediatorAdapter();
            }
            @Override
            public Adapter caseBeanMediatorInputConnector(BeanMediatorInputConnector object) {
                return createBeanMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseBeanMediatorOutputConnector(BeanMediatorOutputConnector object) {
                return createBeanMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEJBMediator(EJBMediator object) {
                return createEJBMediatorAdapter();
            }
            @Override
            public Adapter caseEJBMediatorInputConnector(EJBMediatorInputConnector object) {
                return createEJBMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseEJBMediatorOutputConnector(EJBMediatorOutputConnector object) {
                return createEJBMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseMethodArgument(MethodArgument object) {
                return createMethodArgumentAdapter();
            }
            @Override
            public Adapter caseRegistryKeyProperty(RegistryKeyProperty object) {
                return createRegistryKeyPropertyAdapter();
            }
            @Override
            public Adapter casePropertyMediator(PropertyMediator object) {
                return createPropertyMediatorAdapter();
            }
            @Override
            public Adapter casePropertyMediatorInputConnector(PropertyMediatorInputConnector object) {
                return createPropertyMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter casePropertyMediatorOutputConnector(PropertyMediatorOutputConnector object) {
                return createPropertyMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter casePropertyGroupMediator(PropertyGroupMediator object) {
                return createPropertyGroupMediatorAdapter();
            }
            @Override
            public Adapter casePropertyGroupMediatorInputConnector(PropertyGroupMediatorInputConnector object) {
                return createPropertyGroupMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter casePropertyGroupMediatorOutputConnector(PropertyGroupMediatorOutputConnector object) {
                return createPropertyGroupMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseNamespacedProperty(NamespacedProperty object) {
                return createNamespacedPropertyAdapter();
            }
            @Override
            public Adapter caseEnrichMediator(EnrichMediator object) {
                return createEnrichMediatorAdapter();
            }
            @Override
            public Adapter caseEnrichMediatorInputConnector(EnrichMediatorInputConnector object) {
                return createEnrichMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseEnrichMediatorOutputConnector(EnrichMediatorOutputConnector object) {
                return createEnrichMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAbstractNameValueExpressionProperty(AbstractNameValueExpressionProperty object) {
                return createAbstractNameValueExpressionPropertyAdapter();
            }
            @Override
            public Adapter caseAbstractBooleanFeature(AbstractBooleanFeature object) {
                return createAbstractBooleanFeatureAdapter();
            }
            @Override
            public Adapter caseAbstractLocationKeyResource(AbstractLocationKeyResource object) {
                return createAbstractLocationKeyResourceAdapter();
            }
            @Override
            public Adapter caseXSLTMediator(XSLTMediator object) {
                return createXSLTMediatorAdapter();
            }
            @Override
            public Adapter caseXSLTProperty(XSLTProperty object) {
                return createXSLTPropertyAdapter();
            }
            @Override
            public Adapter caseXSLTFeature(XSLTFeature object) {
                return createXSLTFeatureAdapter();
            }
            @Override
            public Adapter caseXSLTResource(XSLTResource object) {
                return createXSLTResourceAdapter();
            }
            @Override
            public Adapter caseXSLTMediatorInputConnector(XSLTMediatorInputConnector object) {
                return createXSLTMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseXSLTMediatorOutputConnector(XSLTMediatorOutputConnector object) {
                return createXSLTMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSwitchMediator(SwitchMediator object) {
                return createSwitchMediatorAdapter();
            }
            @Override
            public Adapter caseSwitchCaseBranchOutputConnector(SwitchCaseBranchOutputConnector object) {
                return createSwitchCaseBranchOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSwitchDefaultBranchOutputConnector(SwitchDefaultBranchOutputConnector object) {
                return createSwitchDefaultBranchOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSwitchMediatorInputConnector(SwitchMediatorInputConnector object) {
                return createSwitchMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseSwitchMediatorOutputConnector(SwitchMediatorOutputConnector object) {
                return createSwitchMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSwitchMediatorContainer(SwitchMediatorContainer object) {
                return createSwitchMediatorContainerAdapter();
            }
            @Override
            public Adapter caseSwitchCaseParentContainer(SwitchCaseParentContainer object) {
                return createSwitchCaseParentContainerAdapter();
            }
            @Override
            public Adapter caseSwitchDefaultParentContainer(SwitchDefaultParentContainer object) {
                return createSwitchDefaultParentContainerAdapter();
            }
            @Override
            public Adapter caseSwitchCaseContainer(SwitchCaseContainer object) {
                return createSwitchCaseContainerAdapter();
            }
            @Override
            public Adapter caseSwitchDefaultContainer(SwitchDefaultContainer object) {
                return createSwitchDefaultContainerAdapter();
            }
            @Override
            public Adapter caseSequenceDiagram(SequenceDiagram object) {
                return createSequenceDiagramAdapter();
            }
            @Override
            public Adapter caseEsbSequence(EsbSequence object) {
                return createEsbSequenceAdapter();
            }
            @Override
            public Adapter caseEsbSequenceInput(EsbSequenceInput object) {
                return createEsbSequenceInputAdapter();
            }
            @Override
            public Adapter caseEsbSequenceOutput(EsbSequenceOutput object) {
                return createEsbSequenceOutputAdapter();
            }
            @Override
            public Adapter caseEsbSequenceInputConnector(EsbSequenceInputConnector object) {
                return createEsbSequenceInputConnectorAdapter();
            }
            @Override
            public Adapter caseEsbSequenceOutputConnector(EsbSequenceOutputConnector object) {
                return createEsbSequenceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSequence(Sequence object) {
                return createSequenceAdapter();
            }
            @Override
            public Adapter caseSequenceInputConnector(SequenceInputConnector object) {
                return createSequenceInputConnectorAdapter();
            }
            @Override
            public Adapter caseSequenceOutputConnector(SequenceOutputConnector object) {
                return createSequenceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEventMediator(EventMediator object) {
                return createEventMediatorAdapter();
            }
            @Override
            public Adapter caseEventMediatorInputConnector(EventMediatorInputConnector object) {
                return createEventMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseEventMediatorOutputConnector(EventMediatorOutputConnector object) {
                return createEventMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAbstractNameValueProperty(AbstractNameValueProperty object) {
                return createAbstractNameValuePropertyAdapter();
            }
            @Override
            public Adapter caseEntitlementMediator(EntitlementMediator object) {
                return createEntitlementMediatorAdapter();
            }
            @Override
            public Adapter caseEntitlementMediatorInputConnector(EntitlementMediatorInputConnector object) {
                return createEntitlementMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseEntitlementMediatorOutputConnector(EntitlementMediatorOutputConnector object) {
                return createEntitlementMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEntitlementMediatorOnRejectOutputConnector(EntitlementMediatorOnRejectOutputConnector object) {
                return createEntitlementMediatorOnRejectOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEntitlementMediatorOnAcceptOutputConnector(EntitlementMediatorOnAcceptOutputConnector object) {
                return createEntitlementMediatorOnAcceptOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEntitlementMediatorAdviceOutputConnector(EntitlementMediatorAdviceOutputConnector object) {
                return createEntitlementMediatorAdviceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEntitlementMediatorObligationsOutputConnector(EntitlementMediatorObligationsOutputConnector object) {
                return createEntitlementMediatorObligationsOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEntitlementContainer(EntitlementContainer object) {
                return createEntitlementContainerAdapter();
            }
            @Override
            public Adapter caseEntitlementOnRejectContainer(EntitlementOnRejectContainer object) {
                return createEntitlementOnRejectContainerAdapter();
            }
            @Override
            public Adapter caseEntitlementOnAcceptContainer(EntitlementOnAcceptContainer object) {
                return createEntitlementOnAcceptContainerAdapter();
            }
            @Override
            public Adapter caseEntitlementAdviceContainer(EntitlementAdviceContainer object) {
                return createEntitlementAdviceContainerAdapter();
            }
            @Override
            public Adapter caseEntitlementObligationsContainer(EntitlementObligationsContainer object) {
                return createEntitlementObligationsContainerAdapter();
            }
            @Override
            public Adapter caseEnqueueMediator(EnqueueMediator object) {
                return createEnqueueMediatorAdapter();
            }
            @Override
            public Adapter caseEnqueueMediatorInputConnector(EnqueueMediatorInputConnector object) {
                return createEnqueueMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseEnqueueMediatorOutputConnector(EnqueueMediatorOutputConnector object) {
                return createEnqueueMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseClassMediator(ClassMediator object) {
                return createClassMediatorAdapter();
            }
            @Override
            public Adapter caseClassMediatorInputConnector(ClassMediatorInputConnector object) {
                return createClassMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseClassMediatorOutputConnector(ClassMediatorOutputConnector object) {
                return createClassMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseClassProperty(ClassProperty object) {
                return createClassPropertyAdapter();
            }
            @Override
            public Adapter caseSpringMediator(SpringMediator object) {
                return createSpringMediatorAdapter();
            }
            @Override
            public Adapter caseSpringMediatorInputConnector(SpringMediatorInputConnector object) {
                return createSpringMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseSpringMediatorOutputConnector(SpringMediatorOutputConnector object) {
                return createSpringMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseScriptMediator(ScriptMediator object) {
                return createScriptMediatorAdapter();
            }
            @Override
            public Adapter caseScriptMediatorInputConnector(ScriptMediatorInputConnector object) {
                return createScriptMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseScriptMediatorOutputConnector(ScriptMediatorOutputConnector object) {
                return createScriptMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseFaultMediator(FaultMediator object) {
                return createFaultMediatorAdapter();
            }
            @Override
            public Adapter caseFaultMediatorInputConnector(FaultMediatorInputConnector object) {
                return createFaultMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseFaultMediatorOutputConnector(FaultMediatorOutputConnector object) {
                return createFaultMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAggregateMediator(AggregateMediator object) {
                return createAggregateMediatorAdapter();
            }
            @Override
            public Adapter caseAggregateMediatorInputConnector(AggregateMediatorInputConnector object) {
                return createAggregateMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseAggregateMediatorOutputConnector(AggregateMediatorOutputConnector object) {
                return createAggregateMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAggregateMediatorOnCompleteOutputConnector(AggregateMediatorOnCompleteOutputConnector object) {
                return createAggregateMediatorOnCompleteOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRouterMediator(RouterMediator object) {
                return createRouterMediatorAdapter();
            }
            @Override
            public Adapter caseRouterRoute(RouterRoute object) {
                return createRouterRouteAdapter();
            }
            @Override
            public Adapter caseRouterTarget(RouterTarget object) {
                return createRouterTargetAdapter();
            }
            @Override
            public Adapter caseRouterMediatorInputConnector(RouterMediatorInputConnector object) {
                return createRouterMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseRouterMediatorOutputConnector(RouterMediatorOutputConnector object) {
                return createRouterMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRouterMediatorTargetOutputConnector(RouterMediatorTargetOutputConnector object) {
                return createRouterMediatorTargetOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRouterMediatorContainer(RouterMediatorContainer object) {
                return createRouterMediatorContainerAdapter();
            }
            @Override
            public Adapter caseRouterTargetContainer(RouterTargetContainer object) {
                return createRouterTargetContainerAdapter();
            }
            @Override
            public Adapter caseCloneMediator(CloneMediator object) {
                return createCloneMediatorAdapter();
            }
            @Override
            public Adapter caseCloneTarget(CloneTarget object) {
                return createCloneTargetAdapter();
            }
            @Override
            public Adapter caseCloneMediatorInputConnector(CloneMediatorInputConnector object) {
                return createCloneMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseCloneMediatorOutputConnector(CloneMediatorOutputConnector object) {
                return createCloneMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseCloneMediatorTargetOutputConnector(CloneMediatorTargetOutputConnector object) {
                return createCloneMediatorTargetOutputConnectorAdapter();
            }
            @Override
            public Adapter caseCloneMediatorContainer(CloneMediatorContainer object) {
                return createCloneMediatorContainerAdapter();
            }
            @Override
            public Adapter caseCloneTargetContainer(CloneTargetContainer object) {
                return createCloneTargetContainerAdapter();
            }
            @Override
            public Adapter caseForEachMediator(ForEachMediator object) {
                return createForEachMediatorAdapter();
            }
            @Override
            public Adapter caseForEachMediatorInputConnector(ForEachMediatorInputConnector object) {
                return createForEachMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseForEachMediatorOutputConnector(ForEachMediatorOutputConnector object) {
                return createForEachMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseForEachMediatorTargetOutputConnector(ForEachMediatorTargetOutputConnector object) {
                return createForEachMediatorTargetOutputConnectorAdapter();
            }
            @Override
            public Adapter caseForEachTarget(ForEachTarget object) {
                return createForEachTargetAdapter();
            }
            @Override
            public Adapter caseIterateMediator(IterateMediator object) {
                return createIterateMediatorAdapter();
            }
            @Override
            public Adapter caseIterateMediatorInputConnector(IterateMediatorInputConnector object) {
                return createIterateMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseIterateMediatorOutputConnector(IterateMediatorOutputConnector object) {
                return createIterateMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseIterateMediatorTargetOutputConnector(IterateMediatorTargetOutputConnector object) {
                return createIterateMediatorTargetOutputConnectorAdapter();
            }
            @Override
            public Adapter caseIterateTarget(IterateTarget object) {
                return createIterateTargetAdapter();
            }
            @Override
            public Adapter caseAbstractCommonTarget(AbstractCommonTarget object) {
                return createAbstractCommonTargetAdapter();
            }
            @Override
            public Adapter caseMediatorSequence(MediatorSequence object) {
                return createMediatorSequenceAdapter();
            }
            @Override
            public Adapter caseCacheMediator(CacheMediator object) {
                return createCacheMediatorAdapter();
            }
            @Override
            public Adapter caseCacheMediatorInputConnector(CacheMediatorInputConnector object) {
                return createCacheMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseCacheMediatorOutputConnector(CacheMediatorOutputConnector object) {
                return createCacheMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseCacheMediatorOnHitOutputConnector(CacheMediatorOnHitOutputConnector object) {
                return createCacheMediatorOnHitOutputConnectorAdapter();
            }
            @Override
            public Adapter caseCacheOnHitBranch(CacheOnHitBranch object) {
                return createCacheOnHitBranchAdapter();
            }
            @Override
            public Adapter caseXQueryMediator(XQueryMediator object) {
                return createXQueryMediatorAdapter();
            }
            @Override
            public Adapter caseXQueryMediatorInputConnector(XQueryMediatorInputConnector object) {
                return createXQueryMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseXQueryMediatorOutputConnector(XQueryMediatorOutputConnector object) {
                return createXQueryMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseXQueryVariable(XQueryVariable object) {
                return createXQueryVariableAdapter();
            }
            @Override
            public Adapter caseCalloutMediator(CalloutMediator object) {
                return createCalloutMediatorAdapter();
            }
            @Override
            public Adapter caseCalloutMediatorInputConnector(CalloutMediatorInputConnector object) {
                return createCalloutMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseCalloutMediatorOutputConnector(CalloutMediatorOutputConnector object) {
                return createCalloutMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRMSequenceMediator(RMSequenceMediator object) {
                return createRMSequenceMediatorAdapter();
            }
            @Override
            public Adapter caseRMSequenceMediatorInputConnector(RMSequenceMediatorInputConnector object) {
                return createRMSequenceMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseRMSequenceMediatorOutputConnector(RMSequenceMediatorOutputConnector object) {
                return createRMSequenceMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseTransactionMediator(TransactionMediator object) {
                return createTransactionMediatorAdapter();
            }
            @Override
            public Adapter caseTransactionMediatorInputConnector(TransactionMediatorInputConnector object) {
                return createTransactionMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseTransactionMediatorOutputConnector(TransactionMediatorOutputConnector object) {
                return createTransactionMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseOAuthMediator(OAuthMediator object) {
                return createOAuthMediatorAdapter();
            }
            @Override
            public Adapter caseOAuthMediatorInputConnector(OAuthMediatorInputConnector object) {
                return createOAuthMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseOAuthMediatorOutputConnector(OAuthMediatorOutputConnector object) {
                return createOAuthMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAutoscaleInMediator(AutoscaleInMediator object) {
                return createAutoscaleInMediatorAdapter();
            }
            @Override
            public Adapter caseAutoscaleOutMediator(AutoscaleOutMediator object) {
                return createAutoscaleOutMediatorAdapter();
            }
            @Override
            public Adapter caseHeaderMediator(HeaderMediator object) {
                return createHeaderMediatorAdapter();
            }
            @Override
            public Adapter caseHeaderMediatorInputConnector(HeaderMediatorInputConnector object) {
                return createHeaderMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseHeaderMediatorOutputConnector(HeaderMediatorOutputConnector object) {
                return createHeaderMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseThrottleMediator(ThrottleMediator object) {
                return createThrottleMediatorAdapter();
            }
            @Override
            public Adapter caseThrottleMediatorInputConnector(ThrottleMediatorInputConnector object) {
                return createThrottleMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseThrottleMediatorOutputConnector(ThrottleMediatorOutputConnector object) {
                return createThrottleMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseThrottleMediatorOnAcceptOutputConnector(ThrottleMediatorOnAcceptOutputConnector object) {
                return createThrottleMediatorOnAcceptOutputConnectorAdapter();
            }
            @Override
            public Adapter caseThrottleMediatorOnRejectOutputConnector(ThrottleMediatorOnRejectOutputConnector object) {
                return createThrottleMediatorOnRejectOutputConnectorAdapter();
            }
            @Override
            public Adapter caseThrottlePolicyConfiguration(ThrottlePolicyConfiguration object) {
                return createThrottlePolicyConfigurationAdapter();
            }
            @Override
            public Adapter caseThrottlePolicyEntry(ThrottlePolicyEntry object) {
                return createThrottlePolicyEntryAdapter();
            }
            @Override
            public Adapter caseThrottleOnAcceptBranch(ThrottleOnAcceptBranch object) {
                return createThrottleOnAcceptBranchAdapter();
            }
            @Override
            public Adapter caseThrottleOnRejectBranch(ThrottleOnRejectBranch object) {
                return createThrottleOnRejectBranchAdapter();
            }
            @Override
            public Adapter caseThrottleContainer(ThrottleContainer object) {
                return createThrottleContainerAdapter();
            }
            @Override
            public Adapter caseThrottleOnAcceptContainer(ThrottleOnAcceptContainer object) {
                return createThrottleOnAcceptContainerAdapter();
            }
            @Override
            public Adapter caseThrottleOnRejectContainer(ThrottleOnRejectContainer object) {
                return createThrottleOnRejectContainerAdapter();
            }
            @Override
            public Adapter caseCommandMediator(CommandMediator object) {
                return createCommandMediatorAdapter();
            }
            @Override
            public Adapter caseCommandMediatorInputConnector(CommandMediatorInputConnector object) {
                return createCommandMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseCommandMediatorOutputConnector(CommandMediatorOutputConnector object) {
                return createCommandMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseCommandProperty(CommandProperty object) {
                return createCommandPropertyAdapter();
            }
            @Override
            public Adapter caseAbstractSqlExecutorMediator(AbstractSqlExecutorMediator object) {
                return createAbstractSqlExecutorMediatorAdapter();
            }
            @Override
            public Adapter caseSqlStatement(SqlStatement object) {
                return createSqlStatementAdapter();
            }
            @Override
            public Adapter caseSqlParameterDefinition(SqlParameterDefinition object) {
                return createSqlParameterDefinitionAdapter();
            }
            @Override
            public Adapter caseSqlResultMapping(SqlResultMapping object) {
                return createSqlResultMappingAdapter();
            }
            @Override
            public Adapter caseDBLookupMediator(DBLookupMediator object) {
                return createDBLookupMediatorAdapter();
            }
            @Override
            public Adapter caseDBLookupMediatorInputConnector(DBLookupMediatorInputConnector object) {
                return createDBLookupMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseDBLookupMediatorOutputConnector(DBLookupMediatorOutputConnector object) {
                return createDBLookupMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseDBReportMediator(DBReportMediator object) {
                return createDBReportMediatorAdapter();
            }
            @Override
            public Adapter caseDBReportMediatorInputConnector(DBReportMediatorInputConnector object) {
                return createDBReportMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseDBReportMediatorOutputConnector(DBReportMediatorOutputConnector object) {
                return createDBReportMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRuleMediator(RuleMediator object) {
                return createRuleMediatorAdapter();
            }
            @Override
            public Adapter caseRuleMediatorInputConnector(RuleMediatorInputConnector object) {
                return createRuleMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseRuleMediatorOutputConnector(RuleMediatorOutputConnector object) {
                return createRuleMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRuleMediatorChildMediatorsOutputConnector(RuleMediatorChildMediatorsOutputConnector object) {
                return createRuleMediatorChildMediatorsOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRuleSetCreationProperty(RuleSetCreationProperty object) {
                return createRuleSetCreationPropertyAdapter();
            }
            @Override
            public Adapter caseRuleSessionProperty(RuleSessionProperty object) {
                return createRuleSessionPropertyAdapter();
            }
            @Override
            public Adapter caseRuleFactsConfiguration(RuleFactsConfiguration object) {
                return createRuleFactsConfigurationAdapter();
            }
            @Override
            public Adapter caseRuleFact(RuleFact object) {
                return createRuleFactAdapter();
            }
            @Override
            public Adapter caseRuleResultsConfiguration(RuleResultsConfiguration object) {
                return createRuleResultsConfigurationAdapter();
            }
            @Override
            public Adapter caseRuleResult(RuleResult object) {
                return createRuleResultAdapter();
            }
            @Override
            public Adapter caseRuleChildMediatorsConfiguration(RuleChildMediatorsConfiguration object) {
                return createRuleChildMediatorsConfigurationAdapter();
            }
            @Override
            public Adapter caseCallTemplateParameter(CallTemplateParameter object) {
                return createCallTemplateParameterAdapter();
            }
            @Override
            public Adapter caseCallTemplateMediator(CallTemplateMediator object) {
                return createCallTemplateMediatorAdapter();
            }
            @Override
            public Adapter caseCallTemplateMediatorInputConnector(CallTemplateMediatorInputConnector object) {
                return createCallTemplateMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseCallTemplateMediatorOutputConnector(CallTemplateMediatorOutputConnector object) {
                return createCallTemplateMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseLoopBackMediator(LoopBackMediator object) {
                return createLoopBackMediatorAdapter();
            }
            @Override
            public Adapter caseLoopBackMediatorInputConnector(LoopBackMediatorInputConnector object) {
                return createLoopBackMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseLoopBackMediatorOutputConnector(LoopBackMediatorOutputConnector object) {
                return createLoopBackMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRespondMediator(RespondMediator object) {
                return createRespondMediatorAdapter();
            }
            @Override
            public Adapter caseRespondMediatorInputConnector(RespondMediatorInputConnector object) {
                return createRespondMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseRespondMediatorOutputConnector(RespondMediatorOutputConnector object) {
                return createRespondMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSmooksMediator(SmooksMediator object) {
                return createSmooksMediatorAdapter();
            }
            @Override
            public Adapter caseSmooksMediatorInputConnector(SmooksMediatorInputConnector object) {
                return createSmooksMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseSmooksMediatorOutputConnector(SmooksMediatorOutputConnector object) {
                return createSmooksMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseStoreMediator(StoreMediator object) {
                return createStoreMediatorAdapter();
            }
            @Override
            public Adapter caseStoreMediatorInputConnector(StoreMediatorInputConnector object) {
                return createStoreMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseStoreMediatorOutputConnector(StoreMediatorOutputConnector object) {
                return createStoreMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseBuilderMediator(BuilderMediator object) {
                return createBuilderMediatorAdapter();
            }
            @Override
            public Adapter caseBuilderMediatorInputConnector(BuilderMediatorInputConnector object) {
                return createBuilderMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseBuilderMediatorOutputConector(BuilderMediatorOutputConector object) {
                return createBuilderMediatorOutputConectorAdapter();
            }
            @Override
            public Adapter caseMessageBuilder(MessageBuilder object) {
                return createMessageBuilderAdapter();
            }
            @Override
            public Adapter casePayloadFactoryMediator(PayloadFactoryMediator object) {
                return createPayloadFactoryMediatorAdapter();
            }
            @Override
            public Adapter casePayloadFactoryMediatorInputConnector(PayloadFactoryMediatorInputConnector object) {
                return createPayloadFactoryMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter casePayloadFactoryMediatorOutputConnector(PayloadFactoryMediatorOutputConnector object) {
                return createPayloadFactoryMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter casePayloadFactoryArgument(PayloadFactoryArgument object) {
                return createPayloadFactoryArgumentAdapter();
            }
            @Override
            public Adapter caseConditionalRouteBranch(ConditionalRouteBranch object) {
                return createConditionalRouteBranchAdapter();
            }
            @Override
            public Adapter caseConditionalRouterMediator(ConditionalRouterMediator object) {
                return createConditionalRouterMediatorAdapter();
            }
            @Override
            public Adapter caseConditionalRouterMediatorInputConnector(ConditionalRouterMediatorInputConnector object) {
                return createConditionalRouterMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseConditionalRouterMediatorOutputConnector(ConditionalRouterMediatorOutputConnector object) {
                return createConditionalRouterMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseConditionalRouterMediatorAdditionalOutputConnector(ConditionalRouterMediatorAdditionalOutputConnector object) {
                return createConditionalRouterMediatorAdditionalOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSendMediator(SendMediator object) {
                return createSendMediatorAdapter();
            }
            @Override
            public Adapter caseSendContainer(SendContainer object) {
                return createSendContainerAdapter();
            }
            @Override
            public Adapter caseSendMediatorInputConnector(SendMediatorInputConnector object) {
                return createSendMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseSendMediatorOutputConnector(SendMediatorOutputConnector object) {
                return createSendMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSendMediatorEndpointOutputConnector(SendMediatorEndpointOutputConnector object) {
                return createSendMediatorEndpointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseFailoverEndPoint(FailoverEndPoint object) {
                return createFailoverEndPointAdapter();
            }
            @Override
            public Adapter caseFailoverEndPointInputConnector(FailoverEndPointInputConnector object) {
                return createFailoverEndPointInputConnectorAdapter();
            }
            @Override
            public Adapter caseFailoverEndPointOutputConnector(FailoverEndPointOutputConnector object) {
                return createFailoverEndPointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseFailoverEndPointWestOutputConnector(FailoverEndPointWestOutputConnector object) {
                return createFailoverEndPointWestOutputConnectorAdapter();
            }
            @Override
            public Adapter caseParentEndPoint(ParentEndPoint object) {
                return createParentEndPointAdapter();
            }
            @Override
            public Adapter caseWSDLEndPoint(WSDLEndPoint object) {
                return createWSDLEndPointAdapter();
            }
            @Override
            public Adapter caseWSDLEndPointInputConnector(WSDLEndPointInputConnector object) {
                return createWSDLEndPointInputConnectorAdapter();
            }
            @Override
            public Adapter caseWSDLEndPointOutputConnector(WSDLEndPointOutputConnector object) {
                return createWSDLEndPointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseLoadBalanceEndPoint(LoadBalanceEndPoint object) {
                return createLoadBalanceEndPointAdapter();
            }
            @Override
            public Adapter caseMember(Member object) {
                return createMemberAdapter();
            }
            @Override
            public Adapter caseLoadBalanceEndPointInputConnector(LoadBalanceEndPointInputConnector object) {
                return createLoadBalanceEndPointInputConnectorAdapter();
            }
            @Override
            public Adapter caseLoadBalanceEndPointOutputConnector(LoadBalanceEndPointOutputConnector object) {
                return createLoadBalanceEndPointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseLoadBalanceEndPointWestOutputConnector(LoadBalanceEndPointWestOutputConnector object) {
                return createLoadBalanceEndPointWestOutputConnectorAdapter();
            }
            @Override
            public Adapter caseLocalEntry(LocalEntry object) {
                return createLocalEntryAdapter();
            }
            @Override
            public Adapter caseSession(Session object) {
                return createSessionAdapter();
            }
            @Override
            public Adapter caseSequences(Sequences object) {
                return createSequencesAdapter();
            }
            @Override
            public Adapter caseSequencesOutputConnector(SequencesOutputConnector object) {
                return createSequencesOutputConnectorAdapter();
            }
            @Override
            public Adapter caseSequencesInputConnector(SequencesInputConnector object) {
                return createSequencesInputConnectorAdapter();
            }
            @Override
            public Adapter caseURLRewriteRuleAction(URLRewriteRuleAction object) {
                return createURLRewriteRuleActionAdapter();
            }
            @Override
            public Adapter caseURLRewriteRule(URLRewriteRule object) {
                return createURLRewriteRuleAdapter();
            }
            @Override
            public Adapter caseURLRewriteMediator(URLRewriteMediator object) {
                return createURLRewriteMediatorAdapter();
            }
            @Override
            public Adapter caseURLRewriteMediatorInputConnector(URLRewriteMediatorInputConnector object) {
                return createURLRewriteMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseURLRewriteMediatorOutputConnector(URLRewriteMediatorOutputConnector object) {
                return createURLRewriteMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEvaluatorExpressionProperty(EvaluatorExpressionProperty object) {
                return createEvaluatorExpressionPropertyAdapter();
            }
            @Override
            public Adapter caseValidateMediator(ValidateMediator object) {
                return createValidateMediatorAdapter();
            }
            @Override
            public Adapter caseValidateResource(ValidateResource object) {
                return createValidateResourceAdapter();
            }
            @Override
            public Adapter caseValidateFeature(ValidateFeature object) {
                return createValidateFeatureAdapter();
            }
            @Override
            public Adapter caseValidateSchema(ValidateSchema object) {
                return createValidateSchemaAdapter();
            }
            @Override
            public Adapter caseValidateMediatorInputConnector(ValidateMediatorInputConnector object) {
                return createValidateMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseValidateMediatorOutputConnector(ValidateMediatorOutputConnector object) {
                return createValidateMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseValidateMediatorOnFailOutputConnector(ValidateMediatorOnFailOutputConnector object) {
                return createValidateMediatorOnFailOutputConnectorAdapter();
            }
            @Override
            public Adapter caseEndpointDiagram(EndpointDiagram object) {
                return createEndpointDiagramAdapter();
            }
            @Override
            public Adapter caseNamedEndpoint(NamedEndpoint object) {
                return createNamedEndpointAdapter();
            }
            @Override
            public Adapter caseNamedEndpointInputConnector(NamedEndpointInputConnector object) {
                return createNamedEndpointInputConnectorAdapter();
            }
            @Override
            public Adapter caseNamedEndpointOutputConnector(NamedEndpointOutputConnector object) {
                return createNamedEndpointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseTemplate(Template object) {
                return createTemplateAdapter();
            }
            @Override
            public Adapter caseTemplateParameter(TemplateParameter object) {
                return createTemplateParameterAdapter();
            }
            @Override
            public Adapter caseTask(Task object) {
                return createTaskAdapter();
            }
            @Override
            public Adapter caseNameValueTypeProperty(NameValueTypeProperty object) {
                return createNameValueTypePropertyAdapter();
            }
            @Override
            public Adapter caseTaskProperty(TaskProperty object) {
                return createTaskPropertyAdapter();
            }
            @Override
            public Adapter caseSynapseAPI(SynapseAPI object) {
                return createSynapseAPIAdapter();
            }
            @Override
            public Adapter caseAPIResource(APIResource object) {
                return createAPIResourceAdapter();
            }
            @Override
            public Adapter caseAPIResourceInputConnector(APIResourceInputConnector object) {
                return createAPIResourceInputConnectorAdapter();
            }
            @Override
            public Adapter caseAPIResourceOutputConnector(APIResourceOutputConnector object) {
                return createAPIResourceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAPIResourceOutSequenceOutputConnector(APIResourceOutSequenceOutputConnector object) {
                return createAPIResourceOutSequenceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAPIResourceInSequenceInputConnector(APIResourceInSequenceInputConnector object) {
                return createAPIResourceInSequenceInputConnectorAdapter();
            }
            @Override
            public Adapter caseAPIResourceFaultInputConnector(APIResourceFaultInputConnector object) {
                return createAPIResourceFaultInputConnectorAdapter();
            }
            @Override
            public Adapter caseAPIResourceEndpoint(APIResourceEndpoint object) {
                return createAPIResourceEndpointAdapter();
            }
            @Override
            public Adapter caseAPIResourceEndpointInputConnector(APIResourceEndpointInputConnector object) {
                return createAPIResourceEndpointInputConnectorAdapter();
            }
            @Override
            public Adapter caseAPIResourceEndpointOutputConnector(APIResourceEndpointOutputConnector object) {
                return createAPIResourceEndpointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseComplexEndpoints(ComplexEndpoints object) {
                return createComplexEndpointsAdapter();
            }
            @Override
            public Adapter caseComplexEndpointsOutputConnector(ComplexEndpointsOutputConnector object) {
                return createComplexEndpointsOutputConnectorAdapter();
            }
            @Override
            public Adapter caseAddressingEndpoint(AddressingEndpoint object) {
                return createAddressingEndpointAdapter();
            }
            @Override
            public Adapter caseAddressingEndpointInputConnector(AddressingEndpointInputConnector object) {
                return createAddressingEndpointInputConnectorAdapter();
            }
            @Override
            public Adapter caseAddressingEndpointOutputConnector(AddressingEndpointOutputConnector object) {
                return createAddressingEndpointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRecipientListEndPoint(RecipientListEndPoint object) {
                return createRecipientListEndPointAdapter();
            }
            @Override
            public Adapter caseRecipientListEndPointInputConnector(RecipientListEndPointInputConnector object) {
                return createRecipientListEndPointInputConnectorAdapter();
            }
            @Override
            public Adapter caseRecipientListEndPointOutputConnector(RecipientListEndPointOutputConnector object) {
                return createRecipientListEndPointOutputConnectorAdapter();
            }
            @Override
            public Adapter caseRecipientListEndPointWestOutputConnector(RecipientListEndPointWestOutputConnector object) {
                return createRecipientListEndPointWestOutputConnectorAdapter();
            }
            @Override
            public Adapter caseMessageStoreParameter(MessageStoreParameter object) {
                return createMessageStoreParameterAdapter();
            }
            @Override
            public Adapter caseMessageStore(MessageStore object) {
                return createMessageStoreAdapter();
            }
            @Override
            public Adapter caseMessageProcessorParameter(MessageProcessorParameter object) {
                return createMessageProcessorParameterAdapter();
            }
            @Override
            public Adapter caseMessageProcessor(MessageProcessor object) {
                return createMessageProcessorAdapter();
            }
            @Override
            public Adapter caseAPIHandler(APIHandler object) {
                return createAPIHandlerAdapter();
            }
            @Override
            public Adapter caseAPIHandlerProperty(APIHandlerProperty object) {
                return createAPIHandlerPropertyAdapter();
            }
            @Override
            public Adapter caseCloudConnector(CloudConnector object) {
                return createCloudConnectorAdapter();
            }
            @Override
            public Adapter caseCloudConnectorInputConnector(CloudConnectorInputConnector object) {
                return createCloudConnectorInputConnectorAdapter();
            }
            @Override
            public Adapter caseCloudConnectorOutputConnector(CloudConnectorOutputConnector object) {
                return createCloudConnectorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseCloudConnectorOperation(CloudConnectorOperation object) {
                return createCloudConnectorOperationAdapter();
            }
            @Override
            public Adapter caseCloudConnectorOperationInputConnector(CloudConnectorOperationInputConnector object) {
                return createCloudConnectorOperationInputConnectorAdapter();
            }
            @Override
            public Adapter caseCloudConnectorOperationOutputConnector(CloudConnectorOperationOutputConnector object) {
                return createCloudConnectorOperationOutputConnectorAdapter();
            }
            @Override
            public Adapter caseDataMapperMediator(DataMapperMediator object) {
                return createDataMapperMediatorAdapter();
            }
            @Override
            public Adapter caseDataMapperMediatorInputConnector(DataMapperMediatorInputConnector object) {
                return createDataMapperMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseDataMapperMediatorOutputConnector(DataMapperMediatorOutputConnector object) {
                return createDataMapperMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseFastXSLTMediator(FastXSLTMediator object) {
                return createFastXSLTMediatorAdapter();
            }
            @Override
            public Adapter caseFastXSLTMediatorInputConnector(FastXSLTMediatorInputConnector object) {
                return createFastXSLTMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseFastXSLTMediatorOutputConnector(FastXSLTMediatorOutputConnector object) {
                return createFastXSLTMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseInboundEndpoint(InboundEndpoint object) {
                return createInboundEndpointAdapter();
            }
            @Override
            public Adapter caseInboundEndpointParameter(InboundEndpointParameter object) {
                return createInboundEndpointParameterAdapter();
            }
            @Override
            public Adapter caseInboundEndpointContainer(InboundEndpointContainer object) {
                return createInboundEndpointContainerAdapter();
            }
            @Override
            public Adapter caseInboundEndpointSequenceContainer(InboundEndpointSequenceContainer object) {
                return createInboundEndpointSequenceContainerAdapter();
            }
            @Override
            public Adapter caseInboundEndpointOnErrorSequenceContainer(InboundEndpointOnErrorSequenceContainer object) {
                return createInboundEndpointOnErrorSequenceContainerAdapter();
            }
            @Override
            public Adapter caseInboundEndpointSequenceInputConnector(InboundEndpointSequenceInputConnector object) {
                return createInboundEndpointSequenceInputConnectorAdapter();
            }
            @Override
            public Adapter caseInboundEndpointSequenceOutputConnector(InboundEndpointSequenceOutputConnector object) {
                return createInboundEndpointSequenceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseInboundEndpointOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector object) {
                return createInboundEndpointOnErrorSequenceOutputConnectorAdapter();
            }
            @Override
            public Adapter caseInboundEndpointOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector object) {
                return createInboundEndpointOnErrorSequenceInputConnectorAdapter();
            }
            @Override
            public Adapter caseCommentMediator(CommentMediator object) {
                return createCommentMediatorAdapter();
            }
            @Override
            public Adapter caseJsonTransformMediator(JsonTransformMediator object) {
                return createJsonTransformMediatorAdapter();
            }
            @Override
            public Adapter caseJsonTransformMediatorOutputConnector(JsonTransformMediatorOutputConnector object) {
                return createJsonTransformMediatorOutputConnectorAdapter();
            }
            @Override
            public Adapter caseJsonTransformMediatorInputConnector(JsonTransformMediatorInputConnector object) {
                return createJsonTransformMediatorInputConnectorAdapter();
            }
            @Override
            public Adapter caseJsonTransformMediatorProperty(JsonTransformMediatorProperty object) {
                return createJsonTransformMediatorPropertyAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */

    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbDiagram <em>Diagram</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbDiagram
     * @generated
     */
    public Adapter createEsbDiagramAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbNode
     * @generated
     */
    public Adapter createEsbNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbElement
     * @generated
     */
    public Adapter createEsbElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbServer <em>Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbServer
     * @generated
     */
    public Adapter createEsbServerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.Mediator <em>Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.Mediator
     * @generated
     */
    public Adapter createMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbConnector <em>Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbConnector
     * @generated
     */
    public Adapter createEsbConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InputConnector <em>Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InputConnector
     * @generated
     */
    public Adapter createInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.OutputConnector <em>Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.OutputConnector
     * @generated
     */
    public Adapter createOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AdditionalOutputConnector <em>Additional Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AdditionalOutputConnector
     * @generated
     */
    public Adapter createAdditionalOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbLink <em>Link</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbLink
     * @generated
     */
    public Adapter createEsbLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EndPoint <em>End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EndPoint
     * @generated
     */
    public Adapter createEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallMediator <em>Call Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallMediator
     * @generated
     */
    public Adapter createCallMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallMediatorInputConnector <em>Call Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallMediatorInputConnector
     * @generated
     */
    public Adapter createCallMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallMediatorOutputConnector <em>Call Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallMediatorOutputConnector
     * @generated
     */
    public Adapter createCallMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallMediatorEndpointOutputConnector <em>Call Mediator Endpoint Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallMediatorEndpointOutputConnector
     * @generated
     */
    public Adapter createCallMediatorEndpointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EndPointProperty <em>End Point Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EndPointProperty
     * @generated
     */
    public Adapter createEndPointPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyService <em>Proxy Service</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyService
     * @generated
     */
    public Adapter createProxyServiceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyOutputConnector <em>Proxy Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyOutputConnector
     * @generated
     */
    public Adapter createProxyOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyInputConnector <em>Proxy Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyInputConnector
     * @generated
     */
    public Adapter createProxyInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyOutSequenceOutputConnector <em>Proxy Out Sequence Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyOutSequenceOutputConnector
     * @generated
     */
    public Adapter createProxyOutSequenceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyInSequenceInputConnector <em>Proxy In Sequence Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyInSequenceInputConnector
     * @generated
     */
    public Adapter createProxyInSequenceInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyWSDLResource <em>Proxy WSDL Resource</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyWSDLResource
     * @generated
     */
    public Adapter createProxyWSDLResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyFaultInputConnector <em>Proxy Fault Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyFaultInputConnector
     * @generated
     */
    public Adapter createProxyFaultInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyServiceParameter <em>Proxy Service Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyServiceParameter
     * @generated
     */
    public Adapter createProxyServiceParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyServicePolicy <em>Proxy Service Policy</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyServicePolicy
     * @generated
     */
    public Adapter createProxyServicePolicyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyServiceSequenceAndEndpointContainer <em>Proxy Service Sequence And Endpoint Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyServiceSequenceAndEndpointContainer
     * @generated
     */
    public Adapter createProxyServiceSequenceAndEndpointContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyServiceFaultContainer <em>Proxy Service Fault Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyServiceFaultContainer
     * @generated
     */
    public Adapter createProxyServiceFaultContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ProxyServiceContainer <em>Proxy Service Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ProxyServiceContainer
     * @generated
     */
    public Adapter createProxyServiceContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MediatorFlow <em>Mediator Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MediatorFlow
     * @generated
     */
    public Adapter createMediatorFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EndpointFlow <em>Endpoint Flow</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EndpointFlow
     * @generated
     */
    public Adapter createEndpointFlowAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractEndPoint <em>Abstract End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractEndPoint
     * @generated
     */
    public Adapter createAbstractEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageMediator <em>Message Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageMediator
     * @generated
     */
    public Adapter createMessageMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageInputConnector <em>Message Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageInputConnector
     * @generated
     */
    public Adapter createMessageInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageOutputConnector <em>Message Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageOutputConnector
     * @generated
     */
    public Adapter createMessageOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DefaultEndPoint <em>Default End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DefaultEndPoint
     * @generated
     */
    public Adapter createDefaultEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DefaultEndPointInputConnector <em>Default End Point Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DefaultEndPointInputConnector
     * @generated
     */
    public Adapter createDefaultEndPointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DefaultEndPointOutputConnector <em>Default End Point Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DefaultEndPointOutputConnector
     * @generated
     */
    public Adapter createDefaultEndPointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AddressEndPoint <em>Address End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AddressEndPoint
     * @generated
     */
    public Adapter createAddressEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AddressEndPointInputConnector <em>Address End Point Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AddressEndPointInputConnector
     * @generated
     */
    public Adapter createAddressEndPointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AddressEndPointOutputConnector <em>Address End Point Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AddressEndPointOutputConnector
     * @generated
     */
    public Adapter createAddressEndPointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TemplateEndpoint <em>Template Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TemplateEndpoint
     * @generated
     */
    public Adapter createTemplateEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TemplateEndpointInputConnector <em>Template Endpoint Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TemplateEndpointInputConnector
     * @generated
     */
    public Adapter createTemplateEndpointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TemplateEndpointOutputConnector <em>Template Endpoint Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TemplateEndpointOutputConnector
     * @generated
     */
    public Adapter createTemplateEndpointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TemplateEndpointParameter <em>Template Endpoint Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TemplateEndpointParameter
     * @generated
     */
    public Adapter createTemplateEndpointParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint <em>HTTP Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.HTTPEndpoint
     * @generated
     */
    public Adapter createHTTPEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndPointInputConnector <em>HTTP End Point Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.HTTPEndPointInputConnector
     * @generated
     */
    public Adapter createHTTPEndPointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndPointOutputConnector <em>HTTP End Point Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.HTTPEndPointOutputConnector
     * @generated
     */
    public Adapter createHTTPEndPointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DropMediator <em>Drop Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DropMediator
     * @generated
     */
    public Adapter createDropMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DropMediatorInputConnector <em>Drop Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DropMediatorInputConnector
     * @generated
     */
    public Adapter createDropMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterMediator <em>Filter Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterMediator
     * @generated
     */
    public Adapter createFilterMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterContainer <em>Filter Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterContainer
     * @generated
     */
    public Adapter createFilterContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterPassContainer <em>Filter Pass Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterPassContainer
     * @generated
     */
    public Adapter createFilterPassContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterFailContainer <em>Filter Fail Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterFailContainer
     * @generated
     */
    public Adapter createFilterFailContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterMediatorInputConnector <em>Filter Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterMediatorInputConnector
     * @generated
     */
    public Adapter createFilterMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterMediatorOutputConnector <em>Filter Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterMediatorOutputConnector
     * @generated
     */
    public Adapter createFilterMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterMediatorPassOutputConnector <em>Filter Mediator Pass Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterMediatorPassOutputConnector
     * @generated
     */
    public Adapter createFilterMediatorPassOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FilterMediatorFailOutputConnector <em>Filter Mediator Fail Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FilterMediatorFailOutputConnector
     * @generated
     */
    public Adapter createFilterMediatorFailOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MergeNode <em>Merge Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MergeNode
     * @generated
     */
    public Adapter createMergeNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MergeNodeFirstInputConnector <em>Merge Node First Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MergeNodeFirstInputConnector
     * @generated
     */
    public Adapter createMergeNodeFirstInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MergeNodeSecondInputConnector <em>Merge Node Second Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MergeNodeSecondInputConnector
     * @generated
     */
    public Adapter createMergeNodeSecondInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MergeNodeOutputConnector <em>Merge Node Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MergeNodeOutputConnector
     * @generated
     */
    public Adapter createMergeNodeOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LogMediator <em>Log Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LogMediator
     * @generated
     */
    public Adapter createLogMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LogMediatorInputConnector <em>Log Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LogMediatorInputConnector
     * @generated
     */
    public Adapter createLogMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LogMediatorOutputConnector <em>Log Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LogMediatorOutputConnector
     * @generated
     */
    public Adapter createLogMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LogProperty <em>Log Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LogProperty
     * @generated
     */
    public Adapter createLogPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PublishEventMediator <em>Publish Event Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PublishEventMediator
     * @generated
     */
    public Adapter createPublishEventMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PublishEventMediatorInputConnector <em>Publish Event Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PublishEventMediatorInputConnector
     * @generated
     */
    public Adapter createPublishEventMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PublishEventMediatorOutputConnector <em>Publish Event Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PublishEventMediatorOutputConnector
     * @generated
     */
    public Adapter createPublishEventMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PublishEventMediatorAttribute <em>Publish Event Mediator Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PublishEventMediatorAttribute
     * @generated
     */
    public Adapter createPublishEventMediatorAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractNameValueExpressionAttribute <em>Abstract Name Value Expression Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractNameValueExpressionAttribute
     * @generated
     */
    public Adapter createAbstractNameValueExpressionAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BAMMediator <em>BAM Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BAMMediator
     * @generated
     */
    public Adapter createBAMMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BAMMediatorInputConnector <em>BAM Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BAMMediatorInputConnector
     * @generated
     */
    public Adapter createBAMMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BAMMediatorOutputConnector <em>BAM Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BAMMediatorOutputConnector
     * @generated
     */
    public Adapter createBAMMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BeanMediator <em>Bean Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BeanMediator
     * @generated
     */
    public Adapter createBeanMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BeanMediatorInputConnector <em>Bean Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BeanMediatorInputConnector
     * @generated
     */
    public Adapter createBeanMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BeanMediatorOutputConnector <em>Bean Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BeanMediatorOutputConnector
     * @generated
     */
    public Adapter createBeanMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EJBMediator <em>EJB Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EJBMediator
     * @generated
     */
    public Adapter createEJBMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EJBMediatorInputConnector <em>EJB Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EJBMediatorInputConnector
     * @generated
     */
    public Adapter createEJBMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EJBMediatorOutputConnector <em>EJB Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EJBMediatorOutputConnector
     * @generated
     */
    public Adapter createEJBMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MethodArgument <em>Method Argument</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MethodArgument
     * @generated
     */
    public Adapter createMethodArgumentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty <em>Registry Key Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RegistryKeyProperty
     * @generated
     */
    public Adapter createRegistryKeyPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PropertyMediator <em>Property Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PropertyMediator
     * @generated
     */
    public Adapter createPropertyMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PropertyMediatorInputConnector <em>Property Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PropertyMediatorInputConnector
     * @generated
     */
    public Adapter createPropertyMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PropertyMediatorOutputConnector <em>Property Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PropertyMediatorOutputConnector
     * @generated
     */
    public Adapter createPropertyMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PropertyGroupMediator <em>Property Group Mediator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PropertyGroupMediator
     * @generated
     */
	public Adapter createPropertyGroupMediatorAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PropertyGroupMediatorInputConnector <em>Property Group Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PropertyGroupMediatorInputConnector
     * @generated
     */
	public Adapter createPropertyGroupMediatorInputConnectorAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PropertyGroupMediatorOutputConnector <em>Property Group Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PropertyGroupMediatorOutputConnector
     * @generated
     */
	public Adapter createPropertyGroupMediatorOutputConnectorAdapter() {
        return null;
    }

				/**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.NamespacedProperty <em>Namespaced Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.NamespacedProperty
     * @generated
     */
    public Adapter createNamespacedPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EnrichMediator <em>Enrich Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EnrichMediator
     * @generated
     */
    public Adapter createEnrichMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EnrichMediatorInputConnector <em>Enrich Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EnrichMediatorInputConnector
     * @generated
     */
    public Adapter createEnrichMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EnrichMediatorOutputConnector <em>Enrich Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EnrichMediatorOutputConnector
     * @generated
     */
    public Adapter createEnrichMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractNameValueExpressionProperty <em>Abstract Name Value Expression Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractNameValueExpressionProperty
     * @generated
     */
    public Adapter createAbstractNameValueExpressionPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractBooleanFeature <em>Abstract Boolean Feature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractBooleanFeature
     * @generated
     */
    public Adapter createAbstractBooleanFeatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractLocationKeyResource <em>Abstract Location Key Resource</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractLocationKeyResource
     * @generated
     */
    public Adapter createAbstractLocationKeyResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XSLTMediator <em>XSLT Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XSLTMediator
     * @generated
     */
    public Adapter createXSLTMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XSLTProperty <em>XSLT Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XSLTProperty
     * @generated
     */
    public Adapter createXSLTPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XSLTFeature <em>XSLT Feature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XSLTFeature
     * @generated
     */
    public Adapter createXSLTFeatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XSLTResource <em>XSLT Resource</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XSLTResource
     * @generated
     */
    public Adapter createXSLTResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XSLTMediatorInputConnector <em>XSLT Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XSLTMediatorInputConnector
     * @generated
     */
    public Adapter createXSLTMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XSLTMediatorOutputConnector <em>XSLT Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XSLTMediatorOutputConnector
     * @generated
     */
    public Adapter createXSLTMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchMediator <em>Switch Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchMediator
     * @generated
     */
    public Adapter createSwitchMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchCaseBranchOutputConnector <em>Switch Case Branch Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchCaseBranchOutputConnector
     * @generated
     */
    public Adapter createSwitchCaseBranchOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchDefaultBranchOutputConnector <em>Switch Default Branch Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchDefaultBranchOutputConnector
     * @generated
     */
    public Adapter createSwitchDefaultBranchOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchMediatorInputConnector <em>Switch Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchMediatorInputConnector
     * @generated
     */
    public Adapter createSwitchMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchMediatorOutputConnector <em>Switch Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchMediatorOutputConnector
     * @generated
     */
    public Adapter createSwitchMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchMediatorContainer <em>Switch Mediator Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchMediatorContainer
     * @generated
     */
    public Adapter createSwitchMediatorContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchCaseParentContainer <em>Switch Case Parent Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchCaseParentContainer
     * @generated
     */
    public Adapter createSwitchCaseParentContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchDefaultParentContainer <em>Switch Default Parent Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchDefaultParentContainer
     * @generated
     */
    public Adapter createSwitchDefaultParentContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchCaseContainer <em>Switch Case Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchCaseContainer
     * @generated
     */
    public Adapter createSwitchCaseContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SwitchDefaultContainer <em>Switch Default Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SwitchDefaultContainer
     * @generated
     */
    public Adapter createSwitchDefaultContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SequenceDiagram <em>Sequence Diagram</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SequenceDiagram
     * @generated
     */
    public Adapter createSequenceDiagramAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbSequence <em>Sequence</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbSequence
     * @generated
     */
    public Adapter createEsbSequenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbSequenceInput <em>Sequence Input</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbSequenceInput
     * @generated
     */
    public Adapter createEsbSequenceInputAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbSequenceOutput <em>Sequence Output</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbSequenceOutput
     * @generated
     */
    public Adapter createEsbSequenceOutputAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbSequenceInputConnector <em>Sequence Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbSequenceInputConnector
     * @generated
     */
    public Adapter createEsbSequenceInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EsbSequenceOutputConnector <em>Sequence Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EsbSequenceOutputConnector
     * @generated
     */
    public Adapter createEsbSequenceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.Sequence <em>Sequence</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.Sequence
     * @generated
     */
    public Adapter createSequenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SequenceInputConnector <em>Sequence Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SequenceInputConnector
     * @generated
     */
    public Adapter createSequenceInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SequenceOutputConnector <em>Sequence Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SequenceOutputConnector
     * @generated
     */
    public Adapter createSequenceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EventMediator <em>Event Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EventMediator
     * @generated
     */
    public Adapter createEventMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EventMediatorInputConnector <em>Event Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EventMediatorInputConnector
     * @generated
     */
    public Adapter createEventMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EventMediatorOutputConnector <em>Event Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EventMediatorOutputConnector
     * @generated
     */
    public Adapter createEventMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractNameValueProperty <em>Abstract Name Value Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractNameValueProperty
     * @generated
     */
    public Adapter createAbstractNameValuePropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementMediator <em>Entitlement Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementMediator
     * @generated
     */
    public Adapter createEntitlementMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementMediatorInputConnector <em>Entitlement Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementMediatorInputConnector
     * @generated
     */
    public Adapter createEntitlementMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementMediatorOutputConnector <em>Entitlement Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementMediatorOutputConnector
     * @generated
     */
    public Adapter createEntitlementMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementMediatorOnRejectOutputConnector <em>Entitlement Mediator On Reject Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementMediatorOnRejectOutputConnector
     * @generated
     */
    public Adapter createEntitlementMediatorOnRejectOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementMediatorOnAcceptOutputConnector <em>Entitlement Mediator On Accept Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementMediatorOnAcceptOutputConnector
     * @generated
     */
    public Adapter createEntitlementMediatorOnAcceptOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementMediatorAdviceOutputConnector <em>Entitlement Mediator Advice Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementMediatorAdviceOutputConnector
     * @generated
     */
    public Adapter createEntitlementMediatorAdviceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementMediatorObligationsOutputConnector <em>Entitlement Mediator Obligations Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementMediatorObligationsOutputConnector
     * @generated
     */
    public Adapter createEntitlementMediatorObligationsOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementContainer <em>Entitlement Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementContainer
     * @generated
     */
    public Adapter createEntitlementContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementOnRejectContainer <em>Entitlement On Reject Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementOnRejectContainer
     * @generated
     */
    public Adapter createEntitlementOnRejectContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementOnAcceptContainer <em>Entitlement On Accept Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementOnAcceptContainer
     * @generated
     */
    public Adapter createEntitlementOnAcceptContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementAdviceContainer <em>Entitlement Advice Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementAdviceContainer
     * @generated
     */
    public Adapter createEntitlementAdviceContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EntitlementObligationsContainer <em>Entitlement Obligations Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EntitlementObligationsContainer
     * @generated
     */
    public Adapter createEntitlementObligationsContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EnqueueMediator <em>Enqueue Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EnqueueMediator
     * @generated
     */
    public Adapter createEnqueueMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EnqueueMediatorInputConnector <em>Enqueue Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EnqueueMediatorInputConnector
     * @generated
     */
    public Adapter createEnqueueMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EnqueueMediatorOutputConnector <em>Enqueue Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EnqueueMediatorOutputConnector
     * @generated
     */
    public Adapter createEnqueueMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ClassMediator <em>Class Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ClassMediator
     * @generated
     */
    public Adapter createClassMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ClassMediatorInputConnector <em>Class Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ClassMediatorInputConnector
     * @generated
     */
    public Adapter createClassMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ClassMediatorOutputConnector <em>Class Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ClassMediatorOutputConnector
     * @generated
     */
    public Adapter createClassMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ClassProperty <em>Class Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ClassProperty
     * @generated
     */
    public Adapter createClassPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SpringMediator <em>Spring Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SpringMediator
     * @generated
     */
    public Adapter createSpringMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SpringMediatorInputConnector <em>Spring Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SpringMediatorInputConnector
     * @generated
     */
    public Adapter createSpringMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SpringMediatorOutputConnector <em>Spring Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SpringMediatorOutputConnector
     * @generated
     */
    public Adapter createSpringMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ValidateMediator <em>Validate Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ValidateMediator
     * @generated
     */
    public Adapter createValidateMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ValidateResource <em>Validate Resource</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ValidateResource
     * @generated
     */
    public Adapter createValidateResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ValidateFeature <em>Validate Feature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ValidateFeature
     * @generated
     */
    public Adapter createValidateFeatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ValidateSchema <em>Validate Schema</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ValidateSchema
     * @generated
     */
    public Adapter createValidateSchemaAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ValidateMediatorInputConnector <em>Validate Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ValidateMediatorInputConnector
     * @generated
     */
    public Adapter createValidateMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ValidateMediatorOutputConnector <em>Validate Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ValidateMediatorOutputConnector
     * @generated
     */
    public Adapter createValidateMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ValidateMediatorOnFailOutputConnector <em>Validate Mediator On Fail Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ValidateMediatorOnFailOutputConnector
     * @generated
     */
    public Adapter createValidateMediatorOnFailOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EndpointDiagram <em>Endpoint Diagram</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EndpointDiagram
     * @generated
     */
    public Adapter createEndpointDiagramAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.NamedEndpoint <em>Named Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.NamedEndpoint
     * @generated
     */
    public Adapter createNamedEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.NamedEndpointInputConnector <em>Named Endpoint Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.NamedEndpointInputConnector
     * @generated
     */
    public Adapter createNamedEndpointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.NamedEndpointOutputConnector <em>Named Endpoint Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.NamedEndpointOutputConnector
     * @generated
     */
    public Adapter createNamedEndpointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.Template <em>Template</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.Template
     * @generated
     */
    public Adapter createTemplateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TemplateParameter <em>Template Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TemplateParameter
     * @generated
     */
    public Adapter createTemplateParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.Task <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.Task
     * @generated
     */
    public Adapter createTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.NameValueTypeProperty <em>Name Value Type Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.NameValueTypeProperty
     * @generated
     */
    public Adapter createNameValueTypePropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TaskProperty <em>Task Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TaskProperty
     * @generated
     */
    public Adapter createTaskPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SynapseAPI <em>Synapse API</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SynapseAPI
     * @generated
     */
    public Adapter createSynapseAPIAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResource <em>API Resource</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResource
     * @generated
     */
    public Adapter createAPIResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceInputConnector <em>API Resource Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceInputConnector
     * @generated
     */
    public Adapter createAPIResourceInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceOutputConnector <em>API Resource Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceOutputConnector
     * @generated
     */
    public Adapter createAPIResourceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceOutSequenceOutputConnector <em>API Resource Out Sequence Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceOutSequenceOutputConnector
     * @generated
     */
    public Adapter createAPIResourceOutSequenceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceInSequenceInputConnector <em>API Resource In Sequence Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceInSequenceInputConnector
     * @generated
     */
    public Adapter createAPIResourceInSequenceInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceFaultInputConnector <em>API Resource Fault Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceFaultInputConnector
     * @generated
     */
    public Adapter createAPIResourceFaultInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceEndpoint <em>API Resource Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceEndpoint
     * @generated
     */
    public Adapter createAPIResourceEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceEndpointInputConnector <em>API Resource Endpoint Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceEndpointInputConnector
     * @generated
     */
    public Adapter createAPIResourceEndpointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIResourceEndpointOutputConnector <em>API Resource Endpoint Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIResourceEndpointOutputConnector
     * @generated
     */
    public Adapter createAPIResourceEndpointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ComplexEndpoints <em>Complex Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ComplexEndpoints
     * @generated
     */
    public Adapter createComplexEndpointsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ComplexEndpointsOutputConnector <em>Complex Endpoints Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ComplexEndpointsOutputConnector
     * @generated
     */
    public Adapter createComplexEndpointsOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AddressingEndpoint <em>Addressing Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AddressingEndpoint
     * @generated
     */
    public Adapter createAddressingEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AddressingEndpointInputConnector <em>Addressing Endpoint Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AddressingEndpointInputConnector
     * @generated
     */
    public Adapter createAddressingEndpointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AddressingEndpointOutputConnector <em>Addressing Endpoint Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AddressingEndpointOutputConnector
     * @generated
     */
    public Adapter createAddressingEndpointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RecipientListEndPoint <em>Recipient List End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RecipientListEndPoint
     * @generated
     */
    public Adapter createRecipientListEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RecipientListEndPointInputConnector <em>Recipient List End Point Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RecipientListEndPointInputConnector
     * @generated
     */
    public Adapter createRecipientListEndPointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RecipientListEndPointOutputConnector <em>Recipient List End Point Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RecipientListEndPointOutputConnector
     * @generated
     */
    public Adapter createRecipientListEndPointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RecipientListEndPointWestOutputConnector <em>Recipient List End Point West Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RecipientListEndPointWestOutputConnector
     * @generated
     */
    public Adapter createRecipientListEndPointWestOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageStoreParameter <em>Message Store Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageStoreParameter
     * @generated
     */
    public Adapter createMessageStoreParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageStore <em>Message Store</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageStore
     * @generated
     */
    public Adapter createMessageStoreAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageProcessorParameter <em>Message Processor Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageProcessorParameter
     * @generated
     */
    public Adapter createMessageProcessorParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageProcessor <em>Message Processor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageProcessor
     * @generated
     */
    public Adapter createMessageProcessorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIHandler <em>API Handler</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIHandler
     * @generated
     */
    public Adapter createAPIHandlerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.APIHandlerProperty <em>API Handler Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.APIHandlerProperty
     * @generated
     */
    public Adapter createAPIHandlerPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloudConnector <em>Cloud Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloudConnector
     * @generated
     */
    public Adapter createCloudConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloudConnectorInputConnector <em>Cloud Connector Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloudConnectorInputConnector
     * @generated
     */
    public Adapter createCloudConnectorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloudConnectorOutputConnector <em>Cloud Connector Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloudConnectorOutputConnector
     * @generated
     */
    public Adapter createCloudConnectorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloudConnectorOperation <em>Cloud Connector Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloudConnectorOperation
     * @generated
     */
    public Adapter createCloudConnectorOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloudConnectorOperationInputConnector <em>Cloud Connector Operation Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloudConnectorOperationInputConnector
     * @generated
     */
    public Adapter createCloudConnectorOperationInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloudConnectorOperationOutputConnector <em>Cloud Connector Operation Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloudConnectorOperationOutputConnector
     * @generated
     */
    public Adapter createCloudConnectorOperationOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DataMapperMediator <em>Data Mapper Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DataMapperMediator
     * @generated
     */
    public Adapter createDataMapperMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DataMapperMediatorInputConnector <em>Data Mapper Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DataMapperMediatorInputConnector
     * @generated
     */
    public Adapter createDataMapperMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DataMapperMediatorOutputConnector <em>Data Mapper Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DataMapperMediatorOutputConnector
     * @generated
     */
    public Adapter createDataMapperMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FastXSLTMediator <em>Fast XSLT Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FastXSLTMediator
     * @generated
     */
    public Adapter createFastXSLTMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FastXSLTMediatorInputConnector <em>Fast XSLT Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FastXSLTMediatorInputConnector
     * @generated
     */
    public Adapter createFastXSLTMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FastXSLTMediatorOutputConnector <em>Fast XSLT Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FastXSLTMediatorOutputConnector
     * @generated
     */
    public Adapter createFastXSLTMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpoint <em>Inbound Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpoint
     * @generated
     */
    public Adapter createInboundEndpointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter <em>Inbound Endpoint Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter
     * @generated
     */
    public Adapter createInboundEndpointParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointContainer <em>Inbound Endpoint Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointContainer
     * @generated
     */
    public Adapter createInboundEndpointContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointSequenceContainer <em>Inbound Endpoint Sequence Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointSequenceContainer
     * @generated
     */
    public Adapter createInboundEndpointSequenceContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointOnErrorSequenceContainer <em>Inbound Endpoint On Error Sequence Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointOnErrorSequenceContainer
     * @generated
     */
    public Adapter createInboundEndpointOnErrorSequenceContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointSequenceInputConnector <em>Inbound Endpoint Sequence Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointSequenceInputConnector
     * @generated
     */
    public Adapter createInboundEndpointSequenceInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointSequenceOutputConnector <em>Inbound Endpoint Sequence Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointSequenceOutputConnector
     * @generated
     */
    public Adapter createInboundEndpointSequenceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointOnErrorSequenceOutputConnector <em>Inbound Endpoint On Error Sequence Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointOnErrorSequenceOutputConnector
     * @generated
     */
    public Adapter createInboundEndpointOnErrorSequenceOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointOnErrorSequenceInputConnector <em>Inbound Endpoint On Error Sequence Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.InboundEndpointOnErrorSequenceInputConnector
     * @generated
     */
    public Adapter createInboundEndpointOnErrorSequenceInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CommentMediator <em>Comment Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CommentMediator
     * @generated
     */
    public Adapter createCommentMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.JsonTransformMediator <em>Json Transform Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.JsonTransformMediator
     * @generated
     */
    public Adapter createJsonTransformMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.JsonTransformMediatorOutputConnector <em>Json Transform Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.JsonTransformMediatorOutputConnector
     * @generated
     */
    public Adapter createJsonTransformMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.JsonTransformMediatorInputConnector <em>Json Transform Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.JsonTransformMediatorInputConnector
     * @generated
     */
    public Adapter createJsonTransformMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.JsonTransformMediatorProperty <em>Json Transform Mediator Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.JsonTransformMediatorProperty
     * @generated
     */
    public Adapter createJsonTransformMediatorPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ScriptMediator <em>Script Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ScriptMediator
     * @generated
     */
    public Adapter createScriptMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ScriptMediatorInputConnector <em>Script Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ScriptMediatorInputConnector
     * @generated
     */
    public Adapter createScriptMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ScriptMediatorOutputConnector <em>Script Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ScriptMediatorOutputConnector
     * @generated
     */
    public Adapter createScriptMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FaultMediator <em>Fault Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FaultMediator
     * @generated
     */
    public Adapter createFaultMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FaultMediatorInputConnector <em>Fault Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FaultMediatorInputConnector
     * @generated
     */
    public Adapter createFaultMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FaultMediatorOutputConnector <em>Fault Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FaultMediatorOutputConnector
     * @generated
     */
    public Adapter createFaultMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AggregateMediator <em>Aggregate Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AggregateMediator
     * @generated
     */
    public Adapter createAggregateMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AggregateMediatorInputConnector <em>Aggregate Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AggregateMediatorInputConnector
     * @generated
     */
    public Adapter createAggregateMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AggregateMediatorOutputConnector <em>Aggregate Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AggregateMediatorOutputConnector
     * @generated
     */
    public Adapter createAggregateMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AggregateMediatorOnCompleteOutputConnector <em>Aggregate Mediator On Complete Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AggregateMediatorOnCompleteOutputConnector
     * @generated
     */
    public Adapter createAggregateMediatorOnCompleteOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterMediator <em>Router Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterMediator
     * @generated
     */
    public Adapter createRouterMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterRoute <em>Router Route</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterRoute
     * @generated
     */
    public Adapter createRouterRouteAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterTarget <em>Router Target</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterTarget
     * @generated
     */
    public Adapter createRouterTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterMediatorInputConnector <em>Router Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterMediatorInputConnector
     * @generated
     */
    public Adapter createRouterMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterMediatorOutputConnector <em>Router Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterMediatorOutputConnector
     * @generated
     */
    public Adapter createRouterMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterMediatorTargetOutputConnector <em>Router Mediator Target Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterMediatorTargetOutputConnector
     * @generated
     */
    public Adapter createRouterMediatorTargetOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterMediatorContainer <em>Router Mediator Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterMediatorContainer
     * @generated
     */
    public Adapter createRouterMediatorContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RouterTargetContainer <em>Router Target Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RouterTargetContainer
     * @generated
     */
    public Adapter createRouterTargetContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloneMediator <em>Clone Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloneMediator
     * @generated
     */
    public Adapter createCloneMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloneTarget <em>Clone Target</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloneTarget
     * @generated
     */
    public Adapter createCloneTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloneMediatorInputConnector <em>Clone Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloneMediatorInputConnector
     * @generated
     */
    public Adapter createCloneMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloneMediatorOutputConnector <em>Clone Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloneMediatorOutputConnector
     * @generated
     */
    public Adapter createCloneMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloneMediatorTargetOutputConnector <em>Clone Mediator Target Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloneMediatorTargetOutputConnector
     * @generated
     */
    public Adapter createCloneMediatorTargetOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloneMediatorContainer <em>Clone Mediator Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloneMediatorContainer
     * @generated
     */
    public Adapter createCloneMediatorContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CloneTargetContainer <em>Clone Target Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CloneTargetContainer
     * @generated
     */
    public Adapter createCloneTargetContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ForEachMediator <em>For Each Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ForEachMediator
     * @generated
     */
    public Adapter createForEachMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ForEachMediatorInputConnector <em>For Each Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ForEachMediatorInputConnector
     * @generated
     */
    public Adapter createForEachMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ForEachMediatorOutputConnector <em>For Each Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ForEachMediatorOutputConnector
     * @generated
     */
    public Adapter createForEachMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ForEachMediatorTargetOutputConnector <em>For Each Mediator Target Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ForEachMediatorTargetOutputConnector
     * @generated
     */
    public Adapter createForEachMediatorTargetOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ForEachTarget <em>For Each Target</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ForEachTarget
     * @generated
     */
    public Adapter createForEachTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.IterateMediator <em>Iterate Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.IterateMediator
     * @generated
     */
    public Adapter createIterateMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.IterateMediatorInputConnector <em>Iterate Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.IterateMediatorInputConnector
     * @generated
     */
    public Adapter createIterateMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.IterateMediatorOutputConnector <em>Iterate Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.IterateMediatorOutputConnector
     * @generated
     */
    public Adapter createIterateMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.IterateMediatorTargetOutputConnector <em>Iterate Mediator Target Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.IterateMediatorTargetOutputConnector
     * @generated
     */
    public Adapter createIterateMediatorTargetOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.IterateTarget <em>Iterate Target</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.IterateTarget
     * @generated
     */
    public Adapter createIterateTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractCommonTarget <em>Abstract Common Target</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractCommonTarget
     * @generated
     */
    public Adapter createAbstractCommonTargetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MediatorSequence <em>Mediator Sequence</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MediatorSequence
     * @generated
     */
    public Adapter createMediatorSequenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CacheMediator <em>Cache Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CacheMediator
     * @generated
     */
    public Adapter createCacheMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CacheMediatorInputConnector <em>Cache Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CacheMediatorInputConnector
     * @generated
     */
    public Adapter createCacheMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CacheMediatorOutputConnector <em>Cache Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CacheMediatorOutputConnector
     * @generated
     */
    public Adapter createCacheMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CacheMediatorOnHitOutputConnector <em>Cache Mediator On Hit Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CacheMediatorOnHitOutputConnector
     * @generated
     */
    public Adapter createCacheMediatorOnHitOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CacheOnHitBranch <em>Cache On Hit Branch</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CacheOnHitBranch
     * @generated
     */
    public Adapter createCacheOnHitBranchAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XQueryMediator <em>XQuery Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XQueryMediator
     * @generated
     */
    public Adapter createXQueryMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XQueryMediatorInputConnector <em>XQuery Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XQueryMediatorInputConnector
     * @generated
     */
    public Adapter createXQueryMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XQueryMediatorOutputConnector <em>XQuery Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XQueryMediatorOutputConnector
     * @generated
     */
    public Adapter createXQueryMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.XQueryVariable <em>XQuery Variable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.XQueryVariable
     * @generated
     */
    public Adapter createXQueryVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CalloutMediator <em>Callout Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CalloutMediator
     * @generated
     */
    public Adapter createCalloutMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CalloutMediatorInputConnector <em>Callout Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CalloutMediatorInputConnector
     * @generated
     */
    public Adapter createCalloutMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CalloutMediatorOutputConnector <em>Callout Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CalloutMediatorOutputConnector
     * @generated
     */
    public Adapter createCalloutMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RMSequenceMediator <em>RM Sequence Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RMSequenceMediator
     * @generated
     */
    public Adapter createRMSequenceMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RMSequenceMediatorInputConnector <em>RM Sequence Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RMSequenceMediatorInputConnector
     * @generated
     */
    public Adapter createRMSequenceMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RMSequenceMediatorOutputConnector <em>RM Sequence Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RMSequenceMediatorOutputConnector
     * @generated
     */
    public Adapter createRMSequenceMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TransactionMediator <em>Transaction Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TransactionMediator
     * @generated
     */
    public Adapter createTransactionMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TransactionMediatorInputConnector <em>Transaction Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TransactionMediatorInputConnector
     * @generated
     */
    public Adapter createTransactionMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.TransactionMediatorOutputConnector <em>Transaction Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.TransactionMediatorOutputConnector
     * @generated
     */
    public Adapter createTransactionMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.OAuthMediator <em>OAuth Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.OAuthMediator
     * @generated
     */
    public Adapter createOAuthMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.OAuthMediatorInputConnector <em>OAuth Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.OAuthMediatorInputConnector
     * @generated
     */
    public Adapter createOAuthMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.OAuthMediatorOutputConnector <em>OAuth Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.OAuthMediatorOutputConnector
     * @generated
     */
    public Adapter createOAuthMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AutoscaleInMediator <em>Autoscale In Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AutoscaleInMediator
     * @generated
     */
    public Adapter createAutoscaleInMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AutoscaleOutMediator <em>Autoscale Out Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AutoscaleOutMediator
     * @generated
     */
    public Adapter createAutoscaleOutMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.HeaderMediator <em>Header Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.HeaderMediator
     * @generated
     */
    public Adapter createHeaderMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.HeaderMediatorInputConnector <em>Header Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.HeaderMediatorInputConnector
     * @generated
     */
    public Adapter createHeaderMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.HeaderMediatorOutputConnector <em>Header Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.HeaderMediatorOutputConnector
     * @generated
     */
    public Adapter createHeaderMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleMediator <em>Throttle Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleMediator
     * @generated
     */
    public Adapter createThrottleMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleMediatorInputConnector <em>Throttle Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleMediatorInputConnector
     * @generated
     */
    public Adapter createThrottleMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleMediatorOutputConnector <em>Throttle Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleMediatorOutputConnector
     * @generated
     */
    public Adapter createThrottleMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleMediatorOnAcceptOutputConnector <em>Throttle Mediator On Accept Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleMediatorOnAcceptOutputConnector
     * @generated
     */
    public Adapter createThrottleMediatorOnAcceptOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleMediatorOnRejectOutputConnector <em>Throttle Mediator On Reject Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleMediatorOnRejectOutputConnector
     * @generated
     */
    public Adapter createThrottleMediatorOnRejectOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottlePolicyConfiguration <em>Throttle Policy Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottlePolicyConfiguration
     * @generated
     */
    public Adapter createThrottlePolicyConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottlePolicyEntry <em>Throttle Policy Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottlePolicyEntry
     * @generated
     */
    public Adapter createThrottlePolicyEntryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleOnAcceptBranch <em>Throttle On Accept Branch</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleOnAcceptBranch
     * @generated
     */
    public Adapter createThrottleOnAcceptBranchAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleOnRejectBranch <em>Throttle On Reject Branch</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleOnRejectBranch
     * @generated
     */
    public Adapter createThrottleOnRejectBranchAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleContainer <em>Throttle Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleContainer
     * @generated
     */
    public Adapter createThrottleContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleOnAcceptContainer <em>Throttle On Accept Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleOnAcceptContainer
     * @generated
     */
    public Adapter createThrottleOnAcceptContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ThrottleOnRejectContainer <em>Throttle On Reject Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ThrottleOnRejectContainer
     * @generated
     */
    public Adapter createThrottleOnRejectContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CommandMediator <em>Command Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CommandMediator
     * @generated
     */
    public Adapter createCommandMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CommandMediatorInputConnector <em>Command Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CommandMediatorInputConnector
     * @generated
     */
    public Adapter createCommandMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CommandMediatorOutputConnector <em>Command Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CommandMediatorOutputConnector
     * @generated
     */
    public Adapter createCommandMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CommandProperty <em>Command Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CommandProperty
     * @generated
     */
    public Adapter createCommandPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.AbstractSqlExecutorMediator <em>Abstract Sql Executor Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.AbstractSqlExecutorMediator
     * @generated
     */
    public Adapter createAbstractSqlExecutorMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SqlStatement <em>Sql Statement</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SqlStatement
     * @generated
     */
    public Adapter createSqlStatementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SqlParameterDefinition <em>Sql Parameter Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SqlParameterDefinition
     * @generated
     */
    public Adapter createSqlParameterDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SqlResultMapping <em>Sql Result Mapping</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SqlResultMapping
     * @generated
     */
    public Adapter createSqlResultMappingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DBLookupMediator <em>DB Lookup Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DBLookupMediator
     * @generated
     */
    public Adapter createDBLookupMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DBLookupMediatorInputConnector <em>DB Lookup Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DBLookupMediatorInputConnector
     * @generated
     */
    public Adapter createDBLookupMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DBLookupMediatorOutputConnector <em>DB Lookup Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DBLookupMediatorOutputConnector
     * @generated
     */
    public Adapter createDBLookupMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DBReportMediator <em>DB Report Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DBReportMediator
     * @generated
     */
    public Adapter createDBReportMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DBReportMediatorInputConnector <em>DB Report Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DBReportMediatorInputConnector
     * @generated
     */
    public Adapter createDBReportMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.DBReportMediatorOutputConnector <em>DB Report Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.DBReportMediatorOutputConnector
     * @generated
     */
    public Adapter createDBReportMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleMediator <em>Rule Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleMediator
     * @generated
     */
    public Adapter createRuleMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleMediatorInputConnector <em>Rule Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleMediatorInputConnector
     * @generated
     */
    public Adapter createRuleMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleMediatorOutputConnector <em>Rule Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleMediatorOutputConnector
     * @generated
     */
    public Adapter createRuleMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleMediatorChildMediatorsOutputConnector <em>Rule Mediator Child Mediators Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleMediatorChildMediatorsOutputConnector
     * @generated
     */
    public Adapter createRuleMediatorChildMediatorsOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleSetCreationProperty <em>Rule Set Creation Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleSetCreationProperty
     * @generated
     */
    public Adapter createRuleSetCreationPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleSessionProperty <em>Rule Session Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleSessionProperty
     * @generated
     */
    public Adapter createRuleSessionPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleFactsConfiguration <em>Rule Facts Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleFactsConfiguration
     * @generated
     */
    public Adapter createRuleFactsConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleFact <em>Rule Fact</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleFact
     * @generated
     */
    public Adapter createRuleFactAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleResultsConfiguration <em>Rule Results Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleResultsConfiguration
     * @generated
     */
    public Adapter createRuleResultsConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleResult <em>Rule Result</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleResult
     * @generated
     */
    public Adapter createRuleResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RuleChildMediatorsConfiguration <em>Rule Child Mediators Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RuleChildMediatorsConfiguration
     * @generated
     */
    public Adapter createRuleChildMediatorsConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallTemplateParameter <em>Call Template Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallTemplateParameter
     * @generated
     */
    public Adapter createCallTemplateParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallTemplateMediator <em>Call Template Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallTemplateMediator
     * @generated
     */
    public Adapter createCallTemplateMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallTemplateMediatorInputConnector <em>Call Template Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallTemplateMediatorInputConnector
     * @generated
     */
    public Adapter createCallTemplateMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.CallTemplateMediatorOutputConnector <em>Call Template Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.CallTemplateMediatorOutputConnector
     * @generated
     */
    public Adapter createCallTemplateMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LoopBackMediator <em>Loop Back Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LoopBackMediator
     * @generated
     */
    public Adapter createLoopBackMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LoopBackMediatorInputConnector <em>Loop Back Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LoopBackMediatorInputConnector
     * @generated
     */
    public Adapter createLoopBackMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LoopBackMediatorOutputConnector <em>Loop Back Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LoopBackMediatorOutputConnector
     * @generated
     */
    public Adapter createLoopBackMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RespondMediator <em>Respond Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RespondMediator
     * @generated
     */
    public Adapter createRespondMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RespondMediatorInputConnector <em>Respond Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RespondMediatorInputConnector
     * @generated
     */
    public Adapter createRespondMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.RespondMediatorOutputConnector <em>Respond Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.RespondMediatorOutputConnector
     * @generated
     */
    public Adapter createRespondMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SmooksMediator <em>Smooks Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SmooksMediator
     * @generated
     */
    public Adapter createSmooksMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SmooksMediatorInputConnector <em>Smooks Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SmooksMediatorInputConnector
     * @generated
     */
    public Adapter createSmooksMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SmooksMediatorOutputConnector <em>Smooks Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SmooksMediatorOutputConnector
     * @generated
     */
    public Adapter createSmooksMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.StoreMediator <em>Store Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.StoreMediator
     * @generated
     */
    public Adapter createStoreMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.StoreMediatorInputConnector <em>Store Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.StoreMediatorInputConnector
     * @generated
     */
    public Adapter createStoreMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.StoreMediatorOutputConnector <em>Store Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.StoreMediatorOutputConnector
     * @generated
     */
    public Adapter createStoreMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BuilderMediator <em>Builder Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BuilderMediator
     * @generated
     */
    public Adapter createBuilderMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BuilderMediatorInputConnector <em>Builder Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BuilderMediatorInputConnector
     * @generated
     */
    public Adapter createBuilderMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.BuilderMediatorOutputConector <em>Builder Mediator Output Conector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.BuilderMediatorOutputConector
     * @generated
     */
    public Adapter createBuilderMediatorOutputConectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.MessageBuilder <em>Message Builder</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.MessageBuilder
     * @generated
     */
    public Adapter createMessageBuilderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PayloadFactoryMediator <em>Payload Factory Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PayloadFactoryMediator
     * @generated
     */
    public Adapter createPayloadFactoryMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PayloadFactoryMediatorInputConnector <em>Payload Factory Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PayloadFactoryMediatorInputConnector
     * @generated
     */
    public Adapter createPayloadFactoryMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PayloadFactoryMediatorOutputConnector <em>Payload Factory Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PayloadFactoryMediatorOutputConnector
     * @generated
     */
    public Adapter createPayloadFactoryMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.PayloadFactoryArgument <em>Payload Factory Argument</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.PayloadFactoryArgument
     * @generated
     */
    public Adapter createPayloadFactoryArgumentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ConditionalRouteBranch <em>Conditional Route Branch</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ConditionalRouteBranch
     * @generated
     */
    public Adapter createConditionalRouteBranchAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediator <em>Conditional Router Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediator
     * @generated
     */
    public Adapter createConditionalRouterMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediatorInputConnector <em>Conditional Router Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediatorInputConnector
     * @generated
     */
    public Adapter createConditionalRouterMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediatorOutputConnector <em>Conditional Router Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediatorOutputConnector
     * @generated
     */
    public Adapter createConditionalRouterMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediatorAdditionalOutputConnector <em>Conditional Router Mediator Additional Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ConditionalRouterMediatorAdditionalOutputConnector
     * @generated
     */
    public Adapter createConditionalRouterMediatorAdditionalOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SendMediator <em>Send Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SendMediator
     * @generated
     */
    public Adapter createSendMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SendContainer <em>Send Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SendContainer
     * @generated
     */
    public Adapter createSendContainerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SendMediatorInputConnector <em>Send Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SendMediatorInputConnector
     * @generated
     */
    public Adapter createSendMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SendMediatorOutputConnector <em>Send Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SendMediatorOutputConnector
     * @generated
     */
    public Adapter createSendMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SendMediatorEndpointOutputConnector <em>Send Mediator Endpoint Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SendMediatorEndpointOutputConnector
     * @generated
     */
    public Adapter createSendMediatorEndpointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FailoverEndPoint <em>Failover End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FailoverEndPoint
     * @generated
     */
    public Adapter createFailoverEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FailoverEndPointInputConnector <em>Failover End Point Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FailoverEndPointInputConnector
     * @generated
     */
    public Adapter createFailoverEndPointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FailoverEndPointOutputConnector <em>Failover End Point Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FailoverEndPointOutputConnector
     * @generated
     */
    public Adapter createFailoverEndPointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.FailoverEndPointWestOutputConnector <em>Failover End Point West Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.FailoverEndPointWestOutputConnector
     * @generated
     */
    public Adapter createFailoverEndPointWestOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.ParentEndPoint <em>Parent End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.ParentEndPoint
     * @generated
     */
    public Adapter createParentEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.WSDLEndPoint <em>WSDL End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.WSDLEndPoint
     * @generated
     */
    public Adapter createWSDLEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.WSDLEndPointInputConnector <em>WSDL End Point Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.WSDLEndPointInputConnector
     * @generated
     */
    public Adapter createWSDLEndPointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.WSDLEndPointOutputConnector <em>WSDL End Point Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.WSDLEndPointOutputConnector
     * @generated
     */
    public Adapter createWSDLEndPointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPoint <em>Load Balance End Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPoint
     * @generated
     */
    public Adapter createLoadBalanceEndPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.Member <em>Member</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.Member
     * @generated
     */
    public Adapter createMemberAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPointInputConnector <em>Load Balance End Point Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPointInputConnector
     * @generated
     */
    public Adapter createLoadBalanceEndPointInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPointOutputConnector <em>Load Balance End Point Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPointOutputConnector
     * @generated
     */
    public Adapter createLoadBalanceEndPointOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPointWestOutputConnector <em>Load Balance End Point West Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LoadBalanceEndPointWestOutputConnector
     * @generated
     */
    public Adapter createLoadBalanceEndPointWestOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.LocalEntry <em>Local Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.LocalEntry
     * @generated
     */
    public Adapter createLocalEntryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.Session <em>Session</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.Session
     * @generated
     */
    public Adapter createSessionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.Sequences <em>Sequences</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.Sequences
     * @generated
     */
    public Adapter createSequencesAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SequencesOutputConnector <em>Sequences Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SequencesOutputConnector
     * @generated
     */
    public Adapter createSequencesOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.SequencesInputConnector <em>Sequences Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.SequencesInputConnector
     * @generated
     */
    public Adapter createSequencesInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.URLRewriteRuleAction <em>URL Rewrite Rule Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.URLRewriteRuleAction
     * @generated
     */
    public Adapter createURLRewriteRuleActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.URLRewriteRule <em>URL Rewrite Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.URLRewriteRule
     * @generated
     */
    public Adapter createURLRewriteRuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.URLRewriteMediator <em>URL Rewrite Mediator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.URLRewriteMediator
     * @generated
     */
    public Adapter createURLRewriteMediatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.URLRewriteMediatorInputConnector <em>URL Rewrite Mediator Input Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.URLRewriteMediatorInputConnector
     * @generated
     */
    public Adapter createURLRewriteMediatorInputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.URLRewriteMediatorOutputConnector <em>URL Rewrite Mediator Output Connector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.URLRewriteMediatorOutputConnector
     * @generated
     */
    public Adapter createURLRewriteMediatorOutputConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.gmf.esb.EvaluatorExpressionProperty <em>Evaluator Expression Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.wso2.integrationstudio.gmf.esb.EvaluatorExpressionProperty
     * @generated
     */
    public Adapter createEvaluatorExpressionPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // EsbAdapterFactory
