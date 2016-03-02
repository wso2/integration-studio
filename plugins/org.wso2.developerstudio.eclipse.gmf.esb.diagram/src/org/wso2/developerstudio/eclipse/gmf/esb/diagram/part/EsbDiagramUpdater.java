package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.wso2.developerstudio.eclipse.gmf.esb.*;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.*;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class EsbDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSemanticChildren(View view) {
		switch (EsbVisualIDRegistry.getVisualID(view)) {
		case EsbDiagramEditPart.VISUAL_ID:
			return getEsbDiagram_1000SemanticChildren(view);
		case EsbServerEditPart.VISUAL_ID:
			return getEsbServer_2001SemanticChildren(view);
		case ProxyServiceEditPart.VISUAL_ID:
			return getProxyService_3001SemanticChildren(view);
		case ProxyServiceContainerEditPart.VISUAL_ID:
			return getProxyServiceContainer_3486SemanticChildren(view);
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			return getProxyServiceSequenceAndEndpointContainer_3487SemanticChildren(view);
		case DropMediatorEditPart.VISUAL_ID:
			return getDropMediator_3491SemanticChildren(view);
		case PropertyMediatorEditPart.VISUAL_ID:
			return getPropertyMediator_3492SemanticChildren(view);
		case ThrottleMediatorEditPart.VISUAL_ID:
			return getThrottleMediator_3493SemanticChildren(view);
		case ThrottleContainerEditPart.VISUAL_ID:
			return getThrottleContainer_3583SemanticChildren(view);
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			return getThrottleOnAcceptContainer_3584SemanticChildren(view);
		case FilterMediatorEditPart.VISUAL_ID:
			return getFilterMediator_3494SemanticChildren(view);
		case FilterContainerEditPart.VISUAL_ID:
			return getFilterContainer_3531SemanticChildren(view);
		case FilterPassContainerEditPart.VISUAL_ID:
			return getFilterPassContainer_3535SemanticChildren(view);
		case LogMediatorEditPart.VISUAL_ID:
			return getLogMediator_3495SemanticChildren(view);
		case EnrichMediatorEditPart.VISUAL_ID:
			return getEnrichMediator_3496SemanticChildren(view);
		case XSLTMediatorEditPart.VISUAL_ID:
			return getXSLTMediator_3497SemanticChildren(view);
		case SwitchMediatorEditPart.VISUAL_ID:
			return getSwitchMediator_3498SemanticChildren(view);
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			return getSwitchMediatorContainer_3500SemanticChildren(view);
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			return getSwitchCaseParentContainer_3732SemanticChildren(view);
		case SwitchCaseContainerEditPart.VISUAL_ID:
			return getSwitchCaseContainer_3733SemanticChildren(view);
		case SequenceEditPart.VISUAL_ID:
			return getSequence_3503SemanticChildren(view);
		case EventMediatorEditPart.VISUAL_ID:
			return getEventMediator_3504SemanticChildren(view);
		case EntitlementMediatorEditPart.VISUAL_ID:
			return getEntitlementMediator_3505SemanticChildren(view);
		case EntitlementContainerEditPart.VISUAL_ID:
			return getEntitlementContainer_3752SemanticChildren(view);
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			return getEntitlementOnRejectContainer_3753SemanticChildren(view);
		case ClassMediatorEditPart.VISUAL_ID:
			return getClassMediator_3506SemanticChildren(view);
		case SpringMediatorEditPart.VISUAL_ID:
			return getSpringMediator_3507SemanticChildren(view);
		case ScriptMediatorEditPart.VISUAL_ID:
			return getScriptMediator_3508SemanticChildren(view);
		case FaultMediatorEditPart.VISUAL_ID:
			return getFaultMediator_3509SemanticChildren(view);
		case XQueryMediatorEditPart.VISUAL_ID:
			return getXQueryMediator_3510SemanticChildren(view);
		case CommandMediatorEditPart.VISUAL_ID:
			return getCommandMediator_3511SemanticChildren(view);
		case DBLookupMediatorEditPart.VISUAL_ID:
			return getDBLookupMediator_3512SemanticChildren(view);
		case DBReportMediatorEditPart.VISUAL_ID:
			return getDBReportMediator_3513SemanticChildren(view);
		case SmooksMediatorEditPart.VISUAL_ID:
			return getSmooksMediator_3514SemanticChildren(view);
		case SendMediatorEditPart.VISUAL_ID:
			return getSendMediator_3515SemanticChildren(view);
		case HeaderMediatorEditPart.VISUAL_ID:
			return getHeaderMediator_3516SemanticChildren(view);
		case CloneMediatorEditPart.VISUAL_ID:
			return getCloneMediator_3517SemanticChildren(view);
		case CloneMediatorContainerEditPart.VISUAL_ID:
			return getCloneMediatorContainer_3603SemanticChildren(view);
		case CloneTargetContainerEditPart.VISUAL_ID:
			return getCloneTargetContainer_3604SemanticChildren(view);
		case CacheMediatorEditPart.VISUAL_ID:
			return getCacheMediator_3518SemanticChildren(view);
		case IterateMediatorEditPart.VISUAL_ID:
			return getIterateMediator_3519SemanticChildren(view);
		case CalloutMediatorEditPart.VISUAL_ID:
			return getCalloutMediator_3520SemanticChildren(view);
		case TransactionMediatorEditPart.VISUAL_ID:
			return getTransactionMediator_3521SemanticChildren(view);
		case RMSequenceMediatorEditPart.VISUAL_ID:
			return getRMSequenceMediator_3522SemanticChildren(view);
		case RuleMediatorEditPart.VISUAL_ID:
			return getRuleMediator_3523SemanticChildren(view);
		case OAuthMediatorEditPart.VISUAL_ID:
			return getOAuthMediator_3524SemanticChildren(view);
		case AggregateMediatorEditPart.VISUAL_ID:
			return getAggregateMediator_3525SemanticChildren(view);
		case StoreMediatorEditPart.VISUAL_ID:
			return getStoreMediator_3588SemanticChildren(view);
		case BuilderMediatorEditPart.VISUAL_ID:
			return getBuilderMediator_3591SemanticChildren(view);
		case CallTemplateMediatorEditPart.VISUAL_ID:
			return getCallTemplateMediator_3594SemanticChildren(view);
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			return getPayloadFactoryMediator_3597SemanticChildren(view);
		case EnqueueMediatorEditPart.VISUAL_ID:
			return getEnqueueMediator_3600SemanticChildren(view);
		case URLRewriteMediatorEditPart.VISUAL_ID:
			return getURLRewriteMediator_3620SemanticChildren(view);
		case ValidateMediatorEditPart.VISUAL_ID:
			return getValidateMediator_3623SemanticChildren(view);
		case RouterMediatorEditPart.VISUAL_ID:
			return getRouterMediator_3628SemanticChildren(view);
		case RouterMediatorContainerEditPart.VISUAL_ID:
			return getRouterMediatorContainer_3632SemanticChildren(view);
		case RouterTargetContainerEditPart.VISUAL_ID:
			return getRouterTargetContainer_3633SemanticChildren(view);
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			return getConditionalRouterMediator_3635SemanticChildren(view);
		case BAMMediatorEditPart.VISUAL_ID:
			return getBAMMediator_3680SemanticChildren(view);
		case BeanMediatorEditPart.VISUAL_ID:
			return getBeanMediator_3683SemanticChildren(view);
		case EJBMediatorEditPart.VISUAL_ID:
			return getEJBMediator_3686SemanticChildren(view);
		case DefaultEndPointEditPart.VISUAL_ID:
			return getDefaultEndPoint_3609SemanticChildren(view);
		case AddressEndPointEditPart.VISUAL_ID:
			return getAddressEndPoint_3610SemanticChildren(view);
		case FailoverEndPointEditPart.VISUAL_ID:
			return getFailoverEndPoint_3611SemanticChildren(view);
		case RecipientListEndPointEditPart.VISUAL_ID:
			return getRecipientListEndPoint_3692SemanticChildren(view);
		case WSDLEndPointEditPart.VISUAL_ID:
			return getWSDLEndPoint_3612SemanticChildren(view);
		case NamedEndpointEditPart.VISUAL_ID:
			return getNamedEndpoint_3660SemanticChildren(view);
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3613SemanticChildren(view);
		case APIResourceEndpointEditPart.VISUAL_ID:
			return getAPIResourceEndpoint_3674SemanticChildren(view);
		case AddressingEndpointEditPart.VISUAL_ID:
			return getAddressingEndpoint_3689SemanticChildren(view);
		case HTTPEndpointEditPart.VISUAL_ID:
			return getHTTPEndpoint_3709SemanticChildren(view);
		case TemplateEndpointEditPart.VISUAL_ID:
			return getTemplateEndpoint_3716SemanticChildren(view);
		case CloudConnectorEditPart.VISUAL_ID:
			return getCloudConnector_3719SemanticChildren(view);
		case CloudConnectorOperationEditPart.VISUAL_ID:
			return getCloudConnectorOperation_3722SemanticChildren(view);
		case LoopBackMediatorEditPart.VISUAL_ID:
			return getLoopBackMediator_3736SemanticChildren(view);
		case RespondMediatorEditPart.VISUAL_ID:
			return getRespondMediator_3739SemanticChildren(view);
		case CallMediatorEditPart.VISUAL_ID:
			return getCallMediator_3742SemanticChildren(view);
		case DataMapperMediatorEditPart.VISUAL_ID:
			return getDataMapperMediator_3761SemanticChildren(view);
		case FastXSLTMediatorEditPart.VISUAL_ID:
			return getFastXSLTMediator_3764SemanticChildren(view);
		case ForEachMediatorEditPart.VISUAL_ID:
			return getForEachMediator_3780SemanticChildren(view);
		case PublishEventMediatorEditPart.VISUAL_ID:
			return getPublishEventMediator_3785SemanticChildren(view);
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			return getEntitlementOnAcceptContainer_3755SemanticChildren(view);
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			return getEntitlementAdviceContainer_3757SemanticChildren(view);
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			return getEntitlementObligationsContainer_3759SemanticChildren(view);
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			return getSwitchDefaultParentContainer_3734SemanticChildren(view);
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			return getSwitchDefaultContainer_3735SemanticChildren(view);
		case FilterFailContainerEditPart.VISUAL_ID:
			return getFilterFailContainer_3537SemanticChildren(view);
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			return getThrottleOnRejectContainer_3586SemanticChildren(view);
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			return getProxyServiceFaultContainer_3488SemanticChildren(view);
		case MessageMediatorEditPart.VISUAL_ID:
			return getMessageMediator_3045SemanticChildren(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3013SemanticChildren(view);
		case SequencesEditPart.VISUAL_ID:
			return getSequences_3614SemanticChildren(view);
		case DefaultEndPoint2EditPart.VISUAL_ID:
			return getDefaultEndPoint_3643SemanticChildren(view);
		case AddressEndPoint2EditPart.VISUAL_ID:
			return getAddressEndPoint_3646SemanticChildren(view);
		case FailoverEndPoint2EditPart.VISUAL_ID:
			return getFailoverEndPoint_3649SemanticChildren(view);
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			return getRecipientListEndPoint_3696SemanticChildren(view);
		case WSDLEndPoint2EditPart.VISUAL_ID:
			return getWSDLEndPoint_3653SemanticChildren(view);
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3656SemanticChildren(view);
		case HTTPEndpoint2EditPart.VISUAL_ID:
			return getHTTPEndpoint_3712SemanticChildren(view);
		case TemplateEndpoint2EditPart.VISUAL_ID:
			return getTemplateEndpoint_3725SemanticChildren(view);
		case Sequences2EditPart.VISUAL_ID:
			return getSequences_3665SemanticChildren(view);
		case APIResourceEditPart.VISUAL_ID:
			return getAPIResource_3669SemanticChildren(view);
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			return getProxyServiceContainer_3673SemanticChildren(view);
		case ComplexEndpointsEditPart.VISUAL_ID:
			return getComplexEndpoints_3677SemanticChildren(view);
		case InboundEndpointEditPart.VISUAL_ID:
			return getInboundEndpoint_3767SemanticChildren(view);
		case InboundEndpointContainerEditPart.VISUAL_ID:
			return getInboundEndpointContainer_3772SemanticChildren(view);
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointSequenceContainer_3773SemanticChildren(view);
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceContainer_3775SemanticChildren(view);
		case EsbServerContentsCompartmentEditPart.VISUAL_ID:
			return getEsbServerContentsCompartment_7001SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7034SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7030SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7022SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7015SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7048SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7046SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7032SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7036SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7033SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7040SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7016SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7037SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7038SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7039SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7047SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7057SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7049SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7050SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7051SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7017SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7023SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7031SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7019SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7035SemanticChildren(view);
		case EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID:
			return getEndpointDiagramEndpointCompartment_7041SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7054SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7055SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7056SemanticChildren(view);
		case TemplateTemplateCompartmentEditPart.VISUAL_ID:
			return getTemplateTemplateCompartment_7043SemanticChildren(view);
		case EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID:
			return getEndpointDiagramEndpointCompartment_7042SemanticChildren(view);
		case SynapseAPIAPICompartmentEditPart.VISUAL_ID:
			return getSynapseAPIAPICompartment_7044SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7045SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7052SemanticChildren(view);
		case MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID:
			return getMediatorFlowMediatorFlowCompartment_7053SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEsbServer_2001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EsbServer modelElement = (EsbServer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MessageMediator childElement = modelElement.getMessageMediator();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MessageMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EndpointDiagramEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getProxyService_3001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ProxyService modelElement = (ProxyService) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ProxyOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ProxyInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ProxyOutSequenceOutputConnector childElement = modelElement.getOutSequenceOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ProxyFaultInputConnector childElement = modelElement.getFaultInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyFaultInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ProxyServiceContainer childElement = modelElement.getContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyServiceContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getInSequenceInputConnectors().iterator(); it.hasNext();) {
			ProxyInSequenceInputConnector childElement = (ProxyInSequenceInputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyInSequenceInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getProxyServiceContainer_3486SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ProxyServiceContainer modelElement = (ProxyServiceContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ProxyServiceSequenceAndEndpointContainer childElement = modelElement.getSequenceAndEndpointContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ProxyServiceFaultContainer childElement = modelElement.getFaultContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyServiceFaultContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getProxyServiceSequenceAndEndpointContainer_3487SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ProxyServiceSequenceAndEndpointContainer modelElement = (ProxyServiceSequenceAndEndpointContainer) view
				.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlowEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getDropMediator_3491SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DropMediator modelElement = (DropMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			DropMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getPropertyMediator_3492SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		PropertyMediator modelElement = (PropertyMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			PropertyMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PropertyMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			PropertyMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PropertyMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getThrottleMediator_3493SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ThrottleMediator modelElement = (ThrottleMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ThrottleMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ThrottleMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ThrottleMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ThrottleMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ThrottleMediatorOnAcceptOutputConnector childElement = modelElement.getOnAcceptOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ThrottleMediatorOnRejectOutputConnector childElement = modelElement.getOnRejectOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ThrottleContainer childElement = modelElement.getThrottleContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ThrottleContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getThrottleContainer_3583SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ThrottleContainer modelElement = (ThrottleContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ThrottleOnAcceptContainer childElement = modelElement.getOnAcceptContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ThrottleOnAcceptContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ThrottleOnRejectContainer childElement = modelElement.getOnRejectContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ThrottleOnRejectContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getThrottleOnAcceptContainer_3584SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ThrottleOnAcceptContainer modelElement = (ThrottleOnAcceptContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow9EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFilterMediator_3494SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FilterMediator modelElement = (FilterMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			FilterMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FilterMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			FilterMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FilterMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			FilterMediatorPassOutputConnector childElement = modelElement.getPassOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FilterMediatorPassOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			FilterMediatorFailOutputConnector childElement = modelElement.getFailOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FilterMediatorFailOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			FilterContainer childElement = modelElement.getFilterContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FilterContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFilterContainer_3531SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FilterContainer modelElement = (FilterContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			FilterPassContainer childElement = modelElement.getPassContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FilterPassContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			FilterFailContainer childElement = modelElement.getFailContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FilterFailContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFilterPassContainer_3535SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FilterPassContainer modelElement = (FilterPassContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow7EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getLogMediator_3495SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		LogMediator modelElement = (LogMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			LogMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LogMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			LogMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LogMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEnrichMediator_3496SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EnrichMediator modelElement = (EnrichMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EnrichMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EnrichMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EnrichMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EnrichMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getXSLTMediator_3497SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		XSLTMediator modelElement = (XSLTMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			XSLTMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == XSLTMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			XSLTMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == XSLTMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSwitchMediator_3498SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SwitchMediator modelElement = (SwitchMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			SwitchMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SwitchMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getCaseBranches().iterator(); it.hasNext();) {
			SwitchCaseBranchOutputConnector childElement = (SwitchCaseBranchOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			SwitchDefaultBranchOutputConnector childElement = modelElement.getDefaultBranch();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SwitchMediatorContainer childElement = modelElement.getSwitchContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchMediatorContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSwitchMediatorContainer_3500SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SwitchMediatorContainer modelElement = (SwitchMediatorContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			SwitchCaseParentContainer childElement = modelElement.getSwitchCaseParentContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchCaseParentContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SwitchDefaultParentContainer childElement = modelElement.getSwitchDefaultParentContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchDefaultParentContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSwitchCaseParentContainer_3732SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SwitchCaseParentContainer modelElement = (SwitchCaseParentContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSwitchCaseContainer().iterator(); it.hasNext();) {
			SwitchCaseContainer childElement = (SwitchCaseContainer) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchCaseContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSwitchCaseContainer_3733SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SwitchCaseContainer modelElement = (SwitchCaseContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSequence_3503SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Sequence modelElement = (Sequence) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			SequenceInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SequenceInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			SequenceOutputConnector childElement = (SequenceOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SequenceOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEventMediator_3504SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EventMediator modelElement = (EventMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EventMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EventMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EventMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EventMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEntitlementMediator_3505SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EntitlementMediator modelElement = (EntitlementMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EntitlementMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementMediatorOnRejectOutputConnector childElement = modelElement.getOnRejectOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementMediatorOnAcceptOutputConnector childElement = modelElement.getOnAcceptOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementMediatorAdviceOutputConnector childElement = modelElement.getAdviceOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementMediatorObligationsOutputConnector childElement = modelElement.getObligationsOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementContainer childElement = modelElement.getEntitlementContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEntitlementContainer_3752SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EntitlementContainer modelElement = (EntitlementContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EntitlementOnRejectContainer childElement = modelElement.getOnRejectContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementOnRejectContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementOnAcceptContainer childElement = modelElement.getOnAcceptContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementOnAcceptContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementAdviceContainer childElement = modelElement.getAdviceContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementAdviceContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EntitlementObligationsContainer childElement = modelElement.getObligationsContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EntitlementObligationsContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEntitlementOnRejectContainer_3753SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EntitlementOnRejectContainer modelElement = (EntitlementOnRejectContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow21EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getClassMediator_3506SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ClassMediator modelElement = (ClassMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ClassMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ClassMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ClassMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ClassMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSpringMediator_3507SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SpringMediator modelElement = (SpringMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			SpringMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SpringMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SpringMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SpringMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getScriptMediator_3508SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ScriptMediator modelElement = (ScriptMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ScriptMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ScriptMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ScriptMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ScriptMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFaultMediator_3509SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FaultMediator modelElement = (FaultMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			FaultMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FaultMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			FaultMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FaultMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getXQueryMediator_3510SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		XQueryMediator modelElement = (XQueryMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			XQueryMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == XQueryMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			XQueryMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == XQueryMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCommandMediator_3511SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CommandMediator modelElement = (CommandMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CommandMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CommandMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CommandMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CommandMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getDBLookupMediator_3512SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DBLookupMediator modelElement = (DBLookupMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			DBLookupMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DBLookupMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			DBLookupMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DBLookupMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getDBReportMediator_3513SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DBReportMediator modelElement = (DBReportMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			DBReportMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DBReportMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			DBReportMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DBReportMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSmooksMediator_3514SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SmooksMediator modelElement = (SmooksMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			SmooksMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SmooksMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SmooksMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SmooksMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSendMediator_3515SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SendMediator modelElement = (SendMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			SendMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SendMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SendMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SendMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SendMediatorEndpointOutputConnector childElement = modelElement.getEndpointOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow19EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getHeaderMediator_3516SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		HeaderMediator modelElement = (HeaderMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			HeaderMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HeaderMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			HeaderMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HeaderMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCloneMediator_3517SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CloneMediator modelElement = (CloneMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CloneMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloneMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CloneMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloneMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getTargetsOutputConnector().iterator(); it.hasNext();) {
			CloneMediatorTargetOutputConnector childElement = (CloneMediatorTargetOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			CloneMediatorContainer childElement = modelElement.getCloneContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloneMediatorContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCloneMediatorContainer_3603SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CloneMediatorContainer modelElement = (CloneMediatorContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getCloneTargetContainer().iterator(); it.hasNext();) {
			CloneTargetContainer childElement = (CloneTargetContainer) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloneTargetContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCloneTargetContainer_3604SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CloneTargetContainer modelElement = (CloneTargetContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow11EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCacheMediator_3518SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CacheMediator modelElement = (CacheMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CacheMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CacheMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CacheMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CacheMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CacheMediatorOnHitOutputConnector childElement = modelElement.getOnHitOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow13EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getIterateMediator_3519SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		IterateMediator modelElement = (IterateMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			IterateMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == IterateMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			IterateMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == IterateMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			IterateMediatorTargetOutputConnector childElement = modelElement.getTargetOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow12EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCalloutMediator_3520SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CalloutMediator modelElement = (CalloutMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CalloutMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CalloutMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CalloutMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CalloutMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getTransactionMediator_3521SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TransactionMediator modelElement = (TransactionMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			TransactionMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TransactionMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			TransactionMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TransactionMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRMSequenceMediator_3522SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RMSequenceMediator modelElement = (RMSequenceMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			RMSequenceMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RMSequenceMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			RMSequenceMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRuleMediator_3523SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RuleMediator modelElement = (RuleMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			RuleMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RuleMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			RuleMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RuleMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			RuleMediatorChildMediatorsOutputConnector childElement = modelElement.getChildMediatorsOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow17EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getOAuthMediator_3524SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		OAuthMediator modelElement = (OAuthMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			OAuthMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OAuthMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			OAuthMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OAuthMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getAggregateMediator_3525SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AggregateMediator modelElement = (AggregateMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			AggregateMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AggregateMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			AggregateMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AggregateMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			AggregateMediatorOnCompleteOutputConnector childElement = modelElement.getOnCompleteOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow3EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getStoreMediator_3588SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		StoreMediator modelElement = (StoreMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			StoreMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == StoreMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			StoreMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == StoreMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getBuilderMediator_3591SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		BuilderMediator modelElement = (BuilderMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			BuilderMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BuilderMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			BuilderMediatorOutputConector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BuilderMediatorOutputConectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCallTemplateMediator_3594SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CallTemplateMediator modelElement = (CallTemplateMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CallTemplateMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CallTemplateMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CallTemplateMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getPayloadFactoryMediator_3597SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		PayloadFactoryMediator modelElement = (PayloadFactoryMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			PayloadFactoryMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			PayloadFactoryMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEnqueueMediator_3600SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EnqueueMediator modelElement = (EnqueueMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EnqueueMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EnqueueMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EnqueueMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EnqueueMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getURLRewriteMediator_3620SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		URLRewriteMediator modelElement = (URLRewriteMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			URLRewriteMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == URLRewriteMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			URLRewriteMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getValidateMediator_3623SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ValidateMediator modelElement = (ValidateMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ValidateMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ValidateMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ValidateMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ValidateMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ValidateMediatorOnFailOutputConnector childElement = modelElement.getOnFailOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow14EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRouterMediator_3628SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RouterMediator modelElement = (RouterMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			RouterMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RouterMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			RouterMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RouterMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getTargetOutputConnector().iterator(); it.hasNext();) {
			RouterMediatorTargetOutputConnector childElement = (RouterMediatorTargetOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			RouterMediatorContainer childElement = modelElement.getRouterContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RouterMediatorContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRouterMediatorContainer_3632SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RouterMediatorContainer modelElement = (RouterMediatorContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRouterTargetContainer().iterator(); it.hasNext();) {
			RouterTargetContainer childElement = (RouterTargetContainer) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RouterTargetContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRouterTargetContainer_3633SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RouterTargetContainer modelElement = (RouterTargetContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow15EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getConditionalRouterMediator_3635SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ConditionalRouterMediator modelElement = (ConditionalRouterMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ConditionalRouterMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ConditionalRouterMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ConditionalRouterMediatorAdditionalOutputConnector childElement = modelElement
					.getAdditionalOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow16EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getBAMMediator_3680SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		BAMMediator modelElement = (BAMMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			BAMMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BAMMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			BAMMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BAMMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getBeanMediator_3683SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		BeanMediator modelElement = (BeanMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			BeanMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BeanMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			BeanMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == BeanMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEJBMediator_3686SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EJBMediator modelElement = (EJBMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EJBMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EJBMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			EJBMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EJBMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getDefaultEndPoint_3609SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DefaultEndPoint modelElement = (DefaultEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			DefaultEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DefaultEndPointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			DefaultEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DefaultEndPointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getAddressEndPoint_3610SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AddressEndPoint modelElement = (AddressEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			AddressEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AddressEndPointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			AddressEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AddressEndPointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFailoverEndPoint_3611SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FailoverEndPoint modelElement = (FailoverEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			FailoverEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FailoverEndPointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			FailoverEndPointOutputConnector childElement = (FailoverEndPointOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FailoverEndPointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			FailoverEndPointWestOutputConnector childElement = modelElement.getWestOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRecipientListEndPoint_3692SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RecipientListEndPoint modelElement = (RecipientListEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			RecipientListEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RecipientListEndPointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			RecipientListEndPointOutputConnector childElement = (RecipientListEndPointOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RecipientListEndPointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			RecipientListEndPointWestOutputConnector childElement = modelElement.getWestOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getWSDLEndPoint_3612SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		WSDLEndPoint modelElement = (WSDLEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			WSDLEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == WSDLEndPointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			WSDLEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == WSDLEndPointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getNamedEndpoint_3660SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		NamedEndpoint modelElement = (NamedEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			NamedEndpointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == NamedEndpointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			NamedEndpointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == NamedEndpointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getLoadBalanceEndPoint_3613SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		LoadBalanceEndPoint modelElement = (LoadBalanceEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			LoadBalanceEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			LoadBalanceEndPointOutputConnector childElement = (LoadBalanceEndPointOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			LoadBalanceEndPointWestOutputConnector childElement = modelElement.getWestOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getAPIResourceEndpoint_3674SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		APIResourceEndpoint modelElement = (APIResourceEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			APIResourceEndpointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceEndpointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			APIResourceEndpointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceEndpointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getAddressingEndpoint_3689SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AddressingEndpoint modelElement = (AddressingEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			AddressingEndpointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AddressingEndpointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			AddressingEndpointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AddressingEndpointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getHTTPEndpoint_3709SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		HTTPEndpoint modelElement = (HTTPEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			HTTPEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HTTPEndPointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			HTTPEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HTTPEndPointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getTemplateEndpoint_3716SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TemplateEndpoint modelElement = (TemplateEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			TemplateEndpointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TemplateEndpointInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			TemplateEndpointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TemplateEndpointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCloudConnector_3719SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CloudConnector modelElement = (CloudConnector) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CloudConnectorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloudConnectorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CloudConnectorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloudConnectorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCloudConnectorOperation_3722SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CloudConnectorOperation modelElement = (CloudConnectorOperation) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CloudConnectorOperationInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloudConnectorOperationInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CloudConnectorOperationOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getLoopBackMediator_3736SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		LoopBackMediator modelElement = (LoopBackMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			LoopBackMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoopBackMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			LoopBackMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoopBackMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRespondMediator_3739SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RespondMediator modelElement = (RespondMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			RespondMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RespondMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			RespondMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RespondMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getCallMediator_3742SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		CallMediator modelElement = (CallMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			CallMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CallMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CallMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CallMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			CallMediatorEndpointOutputConnector childElement = modelElement.getEndpointOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow20EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getDataMapperMediator_3761SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DataMapperMediator modelElement = (DataMapperMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			DataMapperMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DataMapperMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			DataMapperMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DataMapperMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFastXSLTMediator_3764SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FastXSLTMediator modelElement = (FastXSLTMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			FastXSLTMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FastXSLTMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			FastXSLTMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getForEachMediator_3780SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ForEachMediator modelElement = (ForEachMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ForEachMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ForEachMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ForEachMediatorOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ForEachMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ForEachMediatorTargetOutputConnector childElement = modelElement.getTargetOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow30EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getPublishEventMediator_3785SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		PublishEventMediator modelElement = (PublishEventMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			PublishEventMediatorInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PublishEventMediatorInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			PublishEventMediatorOutputConnector childElement = modelElement.getOutputconnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PublishEventMediatorOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEntitlementOnAcceptContainer_3755SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EntitlementOnAcceptContainer modelElement = (EntitlementOnAcceptContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow22EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEntitlementAdviceContainer_3757SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EntitlementAdviceContainer modelElement = (EntitlementAdviceContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow23EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEntitlementObligationsContainer_3759SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EntitlementObligationsContainer modelElement = (EntitlementObligationsContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow24EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSwitchDefaultParentContainer_3734SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SwitchDefaultParentContainer modelElement = (SwitchDefaultParentContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			SwitchDefaultContainer childElement = modelElement.getSwitchDefaultContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SwitchDefaultContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSwitchDefaultContainer_3735SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SwitchDefaultContainer modelElement = (SwitchDefaultContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow4EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFilterFailContainer_3537SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FilterFailContainer modelElement = (FilterFailContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow8EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getThrottleOnRejectContainer_3586SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ThrottleOnRejectContainer modelElement = (ThrottleOnRejectContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow10EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getProxyServiceFaultContainer_3488SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ProxyServiceFaultContainer modelElement = (ProxyServiceFaultContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow6EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMessageMediator_3045SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		MessageMediator modelElement = (MessageMediator) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MessageInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MessageInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MessageOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MessageOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMergeNode_3013SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		MergeNode modelElement = (MergeNode) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MergeNodeFirstInputConnector childElement = modelElement.getFirstInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MergeNodeFirstInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MergeNodeSecondInputConnector childElement = modelElement.getSecondInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MergeNodeSecondInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MergeNodeOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MergeNodeOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSequences_3614SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Sequences modelElement = (Sequences) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow5EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SequencesInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SequencesInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SequencesOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SequencesOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getDefaultEndPoint_3643SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		DefaultEndPoint modelElement = (DefaultEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			DefaultEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DefaultEndPointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			DefaultEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DefaultEndPointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getAddressEndPoint_3646SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AddressEndPoint modelElement = (AddressEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			AddressEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AddressEndPointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			AddressEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AddressEndPointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getFailoverEndPoint_3649SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		FailoverEndPoint modelElement = (FailoverEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			FailoverEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FailoverEndPointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			FailoverEndPointOutputConnector childElement = (FailoverEndPointOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FailoverEndPointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			FailoverEndPointWestOutputConnector childElement = modelElement.getWestOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow27EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getRecipientListEndPoint_3696SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		RecipientListEndPoint modelElement = (RecipientListEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			RecipientListEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RecipientListEndPointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			RecipientListEndPointOutputConnector childElement = (RecipientListEndPointOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RecipientListEndPointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			RecipientListEndPointWestOutputConnector childElement = modelElement.getWestOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow28EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getWSDLEndPoint_3653SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		WSDLEndPoint modelElement = (WSDLEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			WSDLEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == WSDLEndPointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			WSDLEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == WSDLEndPointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getLoadBalanceEndPoint_3656SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		LoadBalanceEndPoint modelElement = (LoadBalanceEndPoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			LoadBalanceEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			LoadBalanceEndPointOutputConnector childElement = (LoadBalanceEndPointOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			LoadBalanceEndPointWestOutputConnector childElement = modelElement.getWestOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow29EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getHTTPEndpoint_3712SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		HTTPEndpoint modelElement = (HTTPEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			HTTPEndPointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HTTPEndPointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			HTTPEndPointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == HTTPEndPointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getTemplateEndpoint_3725SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TemplateEndpoint modelElement = (TemplateEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			TemplateEndpointInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TemplateEndpointInputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			TemplateEndpointOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TemplateEndpointOutputConnector2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSequences_3665SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Sequences modelElement = (Sequences) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow5EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SequencesInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SequencesInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			SequencesOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SequencesOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getAPIResource_3669SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		APIResource modelElement = (APIResource) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			APIResourceInputConnector childElement = modelElement.getInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			APIResourceOutputConnector childElement = modelElement.getOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			APIResourceOutSequenceOutputConnector childElement = modelElement.getOutSequenceOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			APIResourceFaultInputConnector childElement = modelElement.getFaultInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceFaultInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ProxyServiceContainer childElement = modelElement.getContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyServiceContainer2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getInSequenceInputConnectors().iterator(); it.hasNext();) {
			APIResourceInSequenceInputConnector childElement = (APIResourceInSequenceInputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceInSequenceInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getProxyServiceContainer_3673SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ProxyServiceContainer modelElement = (ProxyServiceContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			ProxyServiceSequenceAndEndpointContainer childElement = modelElement.getSequenceAndEndpointContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			ProxyServiceFaultContainer childElement = modelElement.getFaultContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyServiceFaultContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getComplexEndpoints_3677SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ComplexEndpoints modelElement = (ComplexEndpoints) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow18EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		for (Iterator<?> it = modelElement.getOutputConnector().iterator(); it.hasNext();) {
			ComplexEndpointsOutputConnector childElement = (ComplexEndpointsOutputConnector) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ComplexEndpointsOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getInboundEndpoint_3767SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		InboundEndpoint modelElement = (InboundEndpoint) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			InboundEndpointSequenceInputConnector childElement = modelElement.getSequenceInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			InboundEndpointSequenceOutputConnector childElement = modelElement.getSequenceOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			InboundEndpointOnErrorSequenceInputConnector childElement = modelElement.getOnErrorSequenceInputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			InboundEndpointOnErrorSequenceOutputConnector childElement = modelElement
					.getOnErrorSequenceOutputConnector();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			InboundEndpointContainer childElement = modelElement.getContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InboundEndpointContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getInboundEndpointContainer_3772SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		InboundEndpointContainer modelElement = (InboundEndpointContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			InboundEndpointSequenceContainer childElement = modelElement.getSequenceContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InboundEndpointSequenceContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		{
			InboundEndpointOnErrorSequenceContainer childElement = modelElement.getOnErrorSequenceContainer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getInboundEndpointSequenceContainer_3773SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		InboundEndpointSequenceContainer modelElement = (InboundEndpointSequenceContainer) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow25EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getInboundEndpointOnErrorSequenceContainer_3775SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		InboundEndpointOnErrorSequenceContainer modelElement = (InboundEndpointOnErrorSequenceContainer) view
				.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			MediatorFlow childElement = modelElement.getMediatorFlow();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MediatorFlow26EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEsbServerContentsCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		EsbServer modelElement = (EsbServer) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ProxyServiceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MergeNodeEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequencesEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LocalEntryEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TaskEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SynapseAPIEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ComplexEndpointsEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MessageStoreEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MessageProcessorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InboundEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7034SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7030SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7022SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7015SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7048SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7046SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7032SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7036SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7033SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7040SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7016SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7037SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7038SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7039SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7047SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7057SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7049SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7050SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7051SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7017SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7023SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7031SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7019SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7035SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEndpointDiagramEndpointCompartment_7041SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		EndpointDiagram modelElement = (EndpointDiagram) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EndPoint childElement = modelElement.getChild();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DefaultEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == AddressEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == FailoverEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == RecipientListEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == WSDLEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == LoadBalanceEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == HTTPEndpoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == TemplateEndpoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7054SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7055SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7056SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getTemplateTemplateCompartment_7043SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Template modelElement = (Template) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EsbElement childElement = modelElement.getChild();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Sequences2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == EndpointDiagram2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEndpointDiagramEndpointCompartment_7042SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		EndpointDiagram modelElement = (EndpointDiagram) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EndPoint childElement = modelElement.getChild();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DefaultEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == AddressEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == FailoverEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == RecipientListEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == WSDLEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == LoadBalanceEndPoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == HTTPEndpoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
			if (visualID == TemplateEndpoint2EditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getSynapseAPIAPICompartment_7044SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		SynapseAPI modelElement = (SynapseAPI) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getResources().iterator(); it.hasNext();) {
			APIResource childElement = (APIResource) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == APIResourceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7045SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7052SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getMediatorFlowMediatorFlowCompartment_7053SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		MediatorFlow modelElement = (MediatorFlow) containerView.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		for (Iterator<?> it = modelElement.getChildren().iterator(); it.hasNext();) {
			EsbElement childElement = (EsbElement) it.next();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DropMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ThrottleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FilterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LogMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnrichMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SwitchMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SequenceEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EntitlementMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ClassMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SpringMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ScriptMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FaultMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XQueryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommandMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBLookupMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DBReportMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SmooksMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SendMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HeaderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloneMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CacheMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IterateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CalloutMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TransactionMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RMSequenceMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RuleMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OAuthMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AggregateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BuilderMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallTemplateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PayloadFactoryMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnqueueMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == URLRewriteMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ValidateMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConditionalRouterMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BAMMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BeanMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EJBMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DefaultEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FailoverEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RecipientListEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WSDLEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NamedEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadBalanceEndPointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == APIResourceEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AddressingEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == HTTPEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TemplateEndpointEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CloudConnectorOperationEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoopBackMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RespondMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CallMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataMapperMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FastXSLTMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ForEachMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PublishEventMediatorEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbNodeDescriptor> getEsbDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		EsbDiagram modelElement = (EsbDiagram) view.getElement();
		LinkedList<EsbNodeDescriptor> result = new LinkedList<EsbNodeDescriptor>();
		{
			EsbServer childElement = modelElement.getServer();
			int visualID = EsbVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == EsbServerEditPart.VISUAL_ID) {
				result.add(new EsbNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getContainedLinks(View view) {
		switch (EsbVisualIDRegistry.getVisualID(view)) {
		case EsbDiagramEditPart.VISUAL_ID:
			return getEsbDiagram_1000ContainedLinks(view);
		case EsbServerEditPart.VISUAL_ID:
			return getEsbServer_2001ContainedLinks(view);
		case ProxyServiceEditPart.VISUAL_ID:
			return getProxyService_3001ContainedLinks(view);
		case ProxyOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutputConnector_3002ContainedLinks(view);
		case ProxyInputConnectorEditPart.VISUAL_ID:
			return getProxyInputConnector_3003ContainedLinks(view);
		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutSequenceOutputConnector_3729ContainedLinks(view);
		case ProxyFaultInputConnectorEditPart.VISUAL_ID:
			return getProxyFaultInputConnector_3489ContainedLinks(view);
		case ProxyServiceContainerEditPart.VISUAL_ID:
			return getProxyServiceContainer_3486ContainedLinks(view);
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			return getProxyServiceSequenceAndEndpointContainer_3487ContainedLinks(view);
		case MediatorFlowEditPart.VISUAL_ID:
			return getMediatorFlow_3608ContainedLinks(view);
		case DropMediatorEditPart.VISUAL_ID:
			return getDropMediator_3491ContainedLinks(view);
		case DropMediatorInputConnectorEditPart.VISUAL_ID:
			return getDropMediatorInputConnector_3008ContainedLinks(view);
		case PropertyMediatorEditPart.VISUAL_ID:
			return getPropertyMediator_3492ContainedLinks(view);
		case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorInputConnector_3033ContainedLinks(view);
		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorOutputConnector_3034ContainedLinks(view);
		case ThrottleMediatorEditPart.VISUAL_ID:
			return getThrottleMediator_3493ContainedLinks(view);
		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorInputConnector_3121ContainedLinks(view);
		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOutputConnector_3122ContainedLinks(view);
		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnAcceptOutputConnector_3581ContainedLinks(view);
		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnRejectOutputConnector_3582ContainedLinks(view);
		case ThrottleContainerEditPart.VISUAL_ID:
			return getThrottleContainer_3583ContainedLinks(view);
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			return getThrottleOnAcceptContainer_3584ContainedLinks(view);
		case MediatorFlow9EditPart.VISUAL_ID:
			return getMediatorFlow_3585ContainedLinks(view);
		case FilterMediatorEditPart.VISUAL_ID:
			return getFilterMediator_3494ContainedLinks(view);
		case FilterMediatorInputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorInputConnector_3010ContainedLinks(view);
		case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorOutputConnector_3534ContainedLinks(view);
		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorPassOutputConnector_3011ContainedLinks(view);
		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorFailOutputConnector_3012ContainedLinks(view);
		case FilterContainerEditPart.VISUAL_ID:
			return getFilterContainer_3531ContainedLinks(view);
		case FilterPassContainerEditPart.VISUAL_ID:
			return getFilterPassContainer_3535ContainedLinks(view);
		case MediatorFlow7EditPart.VISUAL_ID:
			return getMediatorFlow_3536ContainedLinks(view);
		case LogMediatorEditPart.VISUAL_ID:
			return getLogMediator_3495ContainedLinks(view);
		case LogMediatorInputConnectorEditPart.VISUAL_ID:
			return getLogMediatorInputConnector_3018ContainedLinks(view);
		case LogMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLogMediatorOutputConnector_3019ContainedLinks(view);
		case EnrichMediatorEditPart.VISUAL_ID:
			return getEnrichMediator_3496ContainedLinks(view);
		case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorInputConnector_3036ContainedLinks(view);
		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorOutputConnector_3037ContainedLinks(view);
		case XSLTMediatorEditPart.VISUAL_ID:
			return getXSLTMediator_3497ContainedLinks(view);
		case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorInputConnector_3039ContainedLinks(view);
		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorOutputConnector_3040ContainedLinks(view);
		case SwitchMediatorEditPart.VISUAL_ID:
			return getSwitchMediator_3498ContainedLinks(view);
		case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorInputConnector_3042ContainedLinks(view);
		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorOutputConnector_3499ContainedLinks(view);
		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchCaseBranchOutputConnector_3043ContainedLinks(view);
		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchDefaultBranchOutputConnector_3044ContainedLinks(view);
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			return getSwitchMediatorContainer_3500ContainedLinks(view);
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			return getSwitchCaseParentContainer_3732ContainedLinks(view);
		case SwitchCaseContainerEditPart.VISUAL_ID:
			return getSwitchCaseContainer_3733ContainedLinks(view);
		case MediatorFlow2EditPart.VISUAL_ID:
			return getMediatorFlow_3502ContainedLinks(view);
		case SequenceEditPart.VISUAL_ID:
			return getSequence_3503ContainedLinks(view);
		case SequenceInputConnectorEditPart.VISUAL_ID:
			return getSequenceInputConnector_3049ContainedLinks(view);
		case SequenceOutputConnectorEditPart.VISUAL_ID:
			return getSequenceOutputConnector_3050ContainedLinks(view);
		case EventMediatorEditPart.VISUAL_ID:
			return getEventMediator_3504ContainedLinks(view);
		case EventMediatorInputConnectorEditPart.VISUAL_ID:
			return getEventMediatorInputConnector_3052ContainedLinks(view);
		case EventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEventMediatorOutputConnector_3053ContainedLinks(view);
		case EntitlementMediatorEditPart.VISUAL_ID:
			return getEntitlementMediator_3505ContainedLinks(view);
		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorInputConnector_3055ContainedLinks(view);
		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOutputConnector_3056ContainedLinks(view);
		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnRejectOutputConnector_3748ContainedLinks(view);
		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnAcceptOutputConnector_3749ContainedLinks(view);
		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorAdviceOutputConnector_3750ContainedLinks(view);
		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorObligationsOutputConnector_3751ContainedLinks(view);
		case EntitlementContainerEditPart.VISUAL_ID:
			return getEntitlementContainer_3752ContainedLinks(view);
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			return getEntitlementOnRejectContainer_3753ContainedLinks(view);
		case MediatorFlow21EditPart.VISUAL_ID:
			return getMediatorFlow_3754ContainedLinks(view);
		case ClassMediatorEditPart.VISUAL_ID:
			return getClassMediator_3506ContainedLinks(view);
		case ClassMediatorInputConnectorEditPart.VISUAL_ID:
			return getClassMediatorInputConnector_3058ContainedLinks(view);
		case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
			return getClassMediatorOutputConnector_3059ContainedLinks(view);
		case SpringMediatorEditPart.VISUAL_ID:
			return getSpringMediator_3507ContainedLinks(view);
		case SpringMediatorInputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorInputConnector_3061ContainedLinks(view);
		case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorOutputConnector_3062ContainedLinks(view);
		case ScriptMediatorEditPart.VISUAL_ID:
			return getScriptMediator_3508ContainedLinks(view);
		case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorInputConnector_3064ContainedLinks(view);
		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorOutputConnector_3065ContainedLinks(view);
		case FaultMediatorEditPart.VISUAL_ID:
			return getFaultMediator_3509ContainedLinks(view);
		case FaultMediatorInputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorInputConnector_3067ContainedLinks(view);
		case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorOutputConnector_3068ContainedLinks(view);
		case XQueryMediatorEditPart.VISUAL_ID:
			return getXQueryMediator_3510ContainedLinks(view);
		case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorInputConnector_3070ContainedLinks(view);
		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorOutputConnector_3071ContainedLinks(view);
		case CommandMediatorEditPart.VISUAL_ID:
			return getCommandMediator_3511ContainedLinks(view);
		case CommandMediatorInputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorInputConnector_3073ContainedLinks(view);
		case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorOutputConnector_3074ContainedLinks(view);
		case DBLookupMediatorEditPart.VISUAL_ID:
			return getDBLookupMediator_3512ContainedLinks(view);
		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorInputConnector_3076ContainedLinks(view);
		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorOutputConnector_3077ContainedLinks(view);
		case DBReportMediatorEditPart.VISUAL_ID:
			return getDBReportMediator_3513ContainedLinks(view);
		case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorInputConnector_3079ContainedLinks(view);
		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorOutputConnector_3080ContainedLinks(view);
		case SmooksMediatorEditPart.VISUAL_ID:
			return getSmooksMediator_3514ContainedLinks(view);
		case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorInputConnector_3082ContainedLinks(view);
		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorOutputConnector_3083ContainedLinks(view);
		case SendMediatorEditPart.VISUAL_ID:
			return getSendMediator_3515ContainedLinks(view);
		case SendMediatorInputConnectorEditPart.VISUAL_ID:
			return getSendMediatorInputConnector_3085ContainedLinks(view);
		case SendMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorOutputConnector_3086ContainedLinks(view);
		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorEndpointOutputConnector_3539ContainedLinks(view);
		case MediatorFlow19EditPart.VISUAL_ID:
			return getMediatorFlow_3728ContainedLinks(view);
		case HeaderMediatorEditPart.VISUAL_ID:
			return getHeaderMediator_3516ContainedLinks(view);
		case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorInputConnector_3100ContainedLinks(view);
		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorOutputConnector_3101ContainedLinks(view);
		case CloneMediatorEditPart.VISUAL_ID:
			return getCloneMediator_3517ContainedLinks(view);
		case CloneMediatorInputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorInputConnector_3103ContainedLinks(view);
		case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorOutputConnector_3104ContainedLinks(view);
		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorTargetOutputConnector_3133ContainedLinks(view);
		case CloneMediatorContainerEditPart.VISUAL_ID:
			return getCloneMediatorContainer_3603ContainedLinks(view);
		case CloneTargetContainerEditPart.VISUAL_ID:
			return getCloneTargetContainer_3604ContainedLinks(view);
		case MediatorFlow11EditPart.VISUAL_ID:
			return getMediatorFlow_3605ContainedLinks(view);
		case CacheMediatorEditPart.VISUAL_ID:
			return getCacheMediator_3518ContainedLinks(view);
		case CacheMediatorInputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorInputConnector_3106ContainedLinks(view);
		case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOutputConnector_3107ContainedLinks(view);
		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOnHitOutputConnector_3618ContainedLinks(view);
		case MediatorFlow13EditPart.VISUAL_ID:
			return getMediatorFlow_3619ContainedLinks(view);
		case IterateMediatorEditPart.VISUAL_ID:
			return getIterateMediator_3519ContainedLinks(view);
		case IterateMediatorInputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorInputConnector_3109ContainedLinks(view);
		case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorOutputConnector_3110ContainedLinks(view);
		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorTargetOutputConnector_3606ContainedLinks(view);
		case MediatorFlow12EditPart.VISUAL_ID:
			return getMediatorFlow_3607ContainedLinks(view);
		case CalloutMediatorEditPart.VISUAL_ID:
			return getCalloutMediator_3520ContainedLinks(view);
		case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorInputConnector_3115ContainedLinks(view);
		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorOutputConnector_3116ContainedLinks(view);
		case TransactionMediatorEditPart.VISUAL_ID:
			return getTransactionMediator_3521ContainedLinks(view);
		case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorInputConnector_3118ContainedLinks(view);
		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorOutputConnector_3119ContainedLinks(view);
		case RMSequenceMediatorEditPart.VISUAL_ID:
			return getRMSequenceMediator_3522ContainedLinks(view);
		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorInputConnector_3124ContainedLinks(view);
		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorOutputConnector_3125ContainedLinks(view);
		case RuleMediatorEditPart.VISUAL_ID:
			return getRuleMediator_3523ContainedLinks(view);
		case RuleMediatorInputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorInputConnector_3127ContainedLinks(view);
		case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorOutputConnector_3128ContainedLinks(view);
		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorChildMediatorsOutputConnector_3640ContainedLinks(view);
		case MediatorFlow17EditPart.VISUAL_ID:
			return getMediatorFlow_3641ContainedLinks(view);
		case OAuthMediatorEditPart.VISUAL_ID:
			return getOAuthMediator_3524ContainedLinks(view);
		case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorInputConnector_3130ContainedLinks(view);
		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorOutputConnector_3131ContainedLinks(view);
		case AggregateMediatorEditPart.VISUAL_ID:
			return getAggregateMediator_3525ContainedLinks(view);
		case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorInputConnector_3112ContainedLinks(view);
		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOutputConnector_3113ContainedLinks(view);
		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOnCompleteOutputConnector_3132ContainedLinks(view);
		case MediatorFlow3EditPart.VISUAL_ID:
			return getMediatorFlow_3526ContainedLinks(view);
		case StoreMediatorEditPart.VISUAL_ID:
			return getStoreMediator_3588ContainedLinks(view);
		case StoreMediatorInputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorInputConnector_3589ContainedLinks(view);
		case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorOutputConnector_3590ContainedLinks(view);
		case BuilderMediatorEditPart.VISUAL_ID:
			return getBuilderMediator_3591ContainedLinks(view);
		case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
			return getBuilderMediatorInputConnector_3592ContainedLinks(view);
		case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
			return getBuilderMediatorOutputConector_3593ContainedLinks(view);
		case CallTemplateMediatorEditPart.VISUAL_ID:
			return getCallTemplateMediator_3594ContainedLinks(view);
		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorInputConnector_3595ContainedLinks(view);
		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorOutputConnector_3596ContainedLinks(view);
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			return getPayloadFactoryMediator_3597ContainedLinks(view);
		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorInputConnector_3598ContainedLinks(view);
		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorOutputConnector_3599ContainedLinks(view);
		case EnqueueMediatorEditPart.VISUAL_ID:
			return getEnqueueMediator_3600ContainedLinks(view);
		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorInputConnector_3601ContainedLinks(view);
		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorOutputConnector_3602ContainedLinks(view);
		case URLRewriteMediatorEditPart.VISUAL_ID:
			return getURLRewriteMediator_3620ContainedLinks(view);
		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorInputConnector_3621ContainedLinks(view);
		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorOutputConnector_3622ContainedLinks(view);
		case ValidateMediatorEditPart.VISUAL_ID:
			return getValidateMediator_3623ContainedLinks(view);
		case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorInputConnector_3624ContainedLinks(view);
		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOutputConnector_3625ContainedLinks(view);
		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOnFailOutputConnector_3626ContainedLinks(view);
		case MediatorFlow14EditPart.VISUAL_ID:
			return getMediatorFlow_3627ContainedLinks(view);
		case RouterMediatorEditPart.VISUAL_ID:
			return getRouterMediator_3628ContainedLinks(view);
		case RouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorInputConnector_3629ContainedLinks(view);
		case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorOutputConnector_3630ContainedLinks(view);
		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorTargetOutputConnector_3631ContainedLinks(view);
		case RouterMediatorContainerEditPart.VISUAL_ID:
			return getRouterMediatorContainer_3632ContainedLinks(view);
		case RouterTargetContainerEditPart.VISUAL_ID:
			return getRouterTargetContainer_3633ContainedLinks(view);
		case MediatorFlow15EditPart.VISUAL_ID:
			return getMediatorFlow_3634ContainedLinks(view);
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			return getConditionalRouterMediator_3635ContainedLinks(view);
		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorInputConnector_3636ContainedLinks(view);
		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorOutputConnector_3637ContainedLinks(view);
		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorAdditionalOutputConnector_3638ContainedLinks(view);
		case MediatorFlow16EditPart.VISUAL_ID:
			return getMediatorFlow_3639ContainedLinks(view);
		case BAMMediatorEditPart.VISUAL_ID:
			return getBAMMediator_3680ContainedLinks(view);
		case BAMMediatorInputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorInputConnector_3681ContainedLinks(view);
		case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorOutputConnector_3682ContainedLinks(view);
		case BeanMediatorEditPart.VISUAL_ID:
			return getBeanMediator_3683ContainedLinks(view);
		case BeanMediatorInputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorInputConnector_3684ContainedLinks(view);
		case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorOutputConnector_3685ContainedLinks(view);
		case EJBMediatorEditPart.VISUAL_ID:
			return getEJBMediator_3686ContainedLinks(view);
		case EJBMediatorInputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorInputConnector_3687ContainedLinks(view);
		case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorOutputConnector_3688ContainedLinks(view);
		case DefaultEndPointEditPart.VISUAL_ID:
			return getDefaultEndPoint_3609ContainedLinks(view);
		case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3021ContainedLinks(view);
		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3022ContainedLinks(view);
		case AddressEndPointEditPart.VISUAL_ID:
			return getAddressEndPoint_3610ContainedLinks(view);
		case AddressEndPointInputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3030ContainedLinks(view);
		case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3031ContainedLinks(view);
		case FailoverEndPointEditPart.VISUAL_ID:
			return getFailoverEndPoint_3611ContainedLinks(view);
		case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3088ContainedLinks(view);
		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3090ContainedLinks(view);
		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3097ContainedLinks(view);
		case RecipientListEndPointEditPart.VISUAL_ID:
			return getRecipientListEndPoint_3692ContainedLinks(view);
		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3693ContainedLinks(view);
		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3694ContainedLinks(view);
		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3695ContainedLinks(view);
		case WSDLEndPointEditPart.VISUAL_ID:
			return getWSDLEndPoint_3612ContainedLinks(view);
		case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3092ContainedLinks(view);
		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3093ContainedLinks(view);
		case NamedEndpointEditPart.VISUAL_ID:
			return getNamedEndpoint_3660ContainedLinks(view);
		case NamedEndpointInputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointInputConnector_3661ContainedLinks(view);
		case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointOutputConnector_3662ContainedLinks(view);
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3613ContainedLinks(view);
		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3095ContainedLinks(view);
		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3096ContainedLinks(view);
		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3098ContainedLinks(view);
		case APIResourceEndpointEditPart.VISUAL_ID:
			return getAPIResourceEndpoint_3674ContainedLinks(view);
		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointInputConnector_3675ContainedLinks(view);
		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointOutputConnector_3676ContainedLinks(view);
		case AddressingEndpointEditPart.VISUAL_ID:
			return getAddressingEndpoint_3689ContainedLinks(view);
		case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointInputConnector_3690ContainedLinks(view);
		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointOutputConnector_3691ContainedLinks(view);
		case HTTPEndpointEditPart.VISUAL_ID:
			return getHTTPEndpoint_3709ContainedLinks(view);
		case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3710ContainedLinks(view);
		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3711ContainedLinks(view);
		case TemplateEndpointEditPart.VISUAL_ID:
			return getTemplateEndpoint_3716ContainedLinks(view);
		case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3717ContainedLinks(view);
		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3718ContainedLinks(view);
		case CloudConnectorEditPart.VISUAL_ID:
			return getCloudConnector_3719ContainedLinks(view);
		case CloudConnectorInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorInputConnector_3720ContainedLinks(view);
		case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOutputConnector_3721ContainedLinks(view);
		case CloudConnectorOperationEditPart.VISUAL_ID:
			return getCloudConnectorOperation_3722ContainedLinks(view);
		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationInputConnector_3723ContainedLinks(view);
		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationOutputConnector_3724ContainedLinks(view);
		case LoopBackMediatorEditPart.VISUAL_ID:
			return getLoopBackMediator_3736ContainedLinks(view);
		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorInputConnector_3737ContainedLinks(view);
		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorOutputConnector_3738ContainedLinks(view);
		case RespondMediatorEditPart.VISUAL_ID:
			return getRespondMediator_3739ContainedLinks(view);
		case RespondMediatorInputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorInputConnector_3740ContainedLinks(view);
		case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorOutputConnector_3741ContainedLinks(view);
		case CallMediatorEditPart.VISUAL_ID:
			return getCallMediator_3742ContainedLinks(view);
		case CallMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallMediatorInputConnector_3743ContainedLinks(view);
		case CallMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorOutputConnector_3744ContainedLinks(view);
		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorEndpointOutputConnector_3745ContainedLinks(view);
		case MediatorFlow20EditPart.VISUAL_ID:
			return getMediatorFlow_3746ContainedLinks(view);
		case DataMapperMediatorEditPart.VISUAL_ID:
			return getDataMapperMediator_3761ContainedLinks(view);
		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorInputConnector_3762ContainedLinks(view);
		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorOutputConnector_3763ContainedLinks(view);
		case FastXSLTMediatorEditPart.VISUAL_ID:
			return getFastXSLTMediator_3764ContainedLinks(view);
		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorInputConnector_3765ContainedLinks(view);
		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorOutputConnector_3766ContainedLinks(view);
		case ForEachMediatorEditPart.VISUAL_ID:
			return getForEachMediator_3780ContainedLinks(view);
		case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorInputConnector_3781ContainedLinks(view);
		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorOutputConnector_3782ContainedLinks(view);
		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorTargetOutputConnector_3783ContainedLinks(view);
		case MediatorFlow30EditPart.VISUAL_ID:
			return getMediatorFlow_3784ContainedLinks(view);
		case PublishEventMediatorEditPart.VISUAL_ID:
			return getPublishEventMediator_3785ContainedLinks(view);
		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorInputConnector_3786ContainedLinks(view);
		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorOutputConnector_3787ContainedLinks(view);
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			return getEntitlementOnAcceptContainer_3755ContainedLinks(view);
		case MediatorFlow22EditPart.VISUAL_ID:
			return getMediatorFlow_3756ContainedLinks(view);
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			return getEntitlementAdviceContainer_3757ContainedLinks(view);
		case MediatorFlow23EditPart.VISUAL_ID:
			return getMediatorFlow_3758ContainedLinks(view);
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			return getEntitlementObligationsContainer_3759ContainedLinks(view);
		case MediatorFlow24EditPart.VISUAL_ID:
			return getMediatorFlow_3760ContainedLinks(view);
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			return getSwitchDefaultParentContainer_3734ContainedLinks(view);
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			return getSwitchDefaultContainer_3735ContainedLinks(view);
		case MediatorFlow4EditPart.VISUAL_ID:
			return getMediatorFlow_3528ContainedLinks(view);
		case FilterFailContainerEditPart.VISUAL_ID:
			return getFilterFailContainer_3537ContainedLinks(view);
		case MediatorFlow8EditPart.VISUAL_ID:
			return getMediatorFlow_3538ContainedLinks(view);
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			return getThrottleOnRejectContainer_3586ContainedLinks(view);
		case MediatorFlow10EditPart.VISUAL_ID:
			return getMediatorFlow_3587ContainedLinks(view);
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			return getProxyServiceFaultContainer_3488ContainedLinks(view);
		case MediatorFlow6EditPart.VISUAL_ID:
			return getMediatorFlow_3530ContainedLinks(view);
		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
			return getProxyInSequenceInputConnector_3731ContainedLinks(view);
		case MessageMediatorEditPart.VISUAL_ID:
			return getMessageMediator_3045ContainedLinks(view);
		case MessageInputConnectorEditPart.VISUAL_ID:
			return getMessageInputConnector_3046ContainedLinks(view);
		case MessageOutputConnectorEditPart.VISUAL_ID:
			return getMessageOutputConnector_3047ContainedLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3013ContainedLinks(view);
		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeFirstInputConnector_3014ContainedLinks(view);
		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeSecondInputConnector_3015ContainedLinks(view);
		case MergeNodeOutputConnectorEditPart.VISUAL_ID:
			return getMergeNodeOutputConnector_3016ContainedLinks(view);
		case SequencesEditPart.VISUAL_ID:
			return getSequences_3614ContainedLinks(view);
		case MediatorFlow5EditPart.VISUAL_ID:
			return getMediatorFlow_3615ContainedLinks(view);
		case SequencesInputConnectorEditPart.VISUAL_ID:
			return getSequencesInputConnector_3616ContainedLinks(view);
		case SequencesOutputConnectorEditPart.VISUAL_ID:
			return getSequencesOutputConnector_3617ContainedLinks(view);
		case EndpointDiagramEditPart.VISUAL_ID:
			return getEndpointDiagram_3642ContainedLinks(view);
		case DefaultEndPoint2EditPart.VISUAL_ID:
			return getDefaultEndPoint_3643ContainedLinks(view);
		case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3644ContainedLinks(view);
		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3645ContainedLinks(view);
		case AddressEndPoint2EditPart.VISUAL_ID:
			return getAddressEndPoint_3646ContainedLinks(view);
		case AddressEndPointInputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3647ContainedLinks(view);
		case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3648ContainedLinks(view);
		case FailoverEndPoint2EditPart.VISUAL_ID:
			return getFailoverEndPoint_3649ContainedLinks(view);
		case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3650ContainedLinks(view);
		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3651ContainedLinks(view);
		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3652ContainedLinks(view);
		case MediatorFlow27EditPart.VISUAL_ID:
			return getMediatorFlow_3777ContainedLinks(view);
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			return getRecipientListEndPoint_3696ContainedLinks(view);
		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3697ContainedLinks(view);
		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3698ContainedLinks(view);
		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3699ContainedLinks(view);
		case MediatorFlow28EditPart.VISUAL_ID:
			return getMediatorFlow_3778ContainedLinks(view);
		case WSDLEndPoint2EditPart.VISUAL_ID:
			return getWSDLEndPoint_3653ContainedLinks(view);
		case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3654ContainedLinks(view);
		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3655ContainedLinks(view);
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3656ContainedLinks(view);
		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3657ContainedLinks(view);
		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3658ContainedLinks(view);
		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3659ContainedLinks(view);
		case MediatorFlow29EditPart.VISUAL_ID:
			return getMediatorFlow_3779ContainedLinks(view);
		case HTTPEndpoint2EditPart.VISUAL_ID:
			return getHTTPEndpoint_3712ContainedLinks(view);
		case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3713ContainedLinks(view);
		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3714ContainedLinks(view);
		case TemplateEndpoint2EditPart.VISUAL_ID:
			return getTemplateEndpoint_3725ContainedLinks(view);
		case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3726ContainedLinks(view);
		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3727ContainedLinks(view);
		case LocalEntryEditPart.VISUAL_ID:
			return getLocalEntry_3663ContainedLinks(view);
		case TemplateEditPart.VISUAL_ID:
			return getTemplate_3664ContainedLinks(view);
		case Sequences2EditPart.VISUAL_ID:
			return getSequences_3665ContainedLinks(view);
		case EndpointDiagram2EditPart.VISUAL_ID:
			return getEndpointDiagram_3666ContainedLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3667ContainedLinks(view);
		case SynapseAPIEditPart.VISUAL_ID:
			return getSynapseAPI_3668ContainedLinks(view);
		case APIResourceEditPart.VISUAL_ID:
			return getAPIResource_3669ContainedLinks(view);
		case APIResourceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInputConnector_3670ContainedLinks(view);
		case APIResourceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutputConnector_3671ContainedLinks(view);
		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutSequenceOutputConnector_3730ContainedLinks(view);
		case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceFaultInputConnector_3672ContainedLinks(view);
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			return getProxyServiceContainer_3673ContainedLinks(view);
		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInSequenceInputConnector_3747ContainedLinks(view);
		case ComplexEndpointsEditPart.VISUAL_ID:
			return getComplexEndpoints_3677ContainedLinks(view);
		case MediatorFlow18EditPart.VISUAL_ID:
			return getMediatorFlow_3678ContainedLinks(view);
		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
			return getComplexEndpointsOutputConnector_3679ContainedLinks(view);
		case MessageStoreEditPart.VISUAL_ID:
			return getMessageStore_3715ContainedLinks(view);
		case MessageProcessorEditPart.VISUAL_ID:
			return getMessageProcessor_3701ContainedLinks(view);
		case InboundEndpointEditPart.VISUAL_ID:
			return getInboundEndpoint_3767ContainedLinks(view);
		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceInputConnector_3768ContainedLinks(view);
		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceOutputConnector_3769ContainedLinks(view);
		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceInputConnector_3770ContainedLinks(view);
		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceOutputConnector_3771ContainedLinks(view);
		case InboundEndpointContainerEditPart.VISUAL_ID:
			return getInboundEndpointContainer_3772ContainedLinks(view);
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointSequenceContainer_3773ContainedLinks(view);
		case MediatorFlow25EditPart.VISUAL_ID:
			return getMediatorFlow_3774ContainedLinks(view);
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceContainer_3775ContainedLinks(view);
		case MediatorFlow26EditPart.VISUAL_ID:
			return getMediatorFlow_3776ContainedLinks(view);
		case EsbLinkEditPart.VISUAL_ID:
			return getEsbLink_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIncomingLinks(View view) {
		switch (EsbVisualIDRegistry.getVisualID(view)) {
		case EsbServerEditPart.VISUAL_ID:
			return getEsbServer_2001IncomingLinks(view);
		case ProxyServiceEditPart.VISUAL_ID:
			return getProxyService_3001IncomingLinks(view);
		case ProxyOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutputConnector_3002IncomingLinks(view);
		case ProxyInputConnectorEditPart.VISUAL_ID:
			return getProxyInputConnector_3003IncomingLinks(view);
		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutSequenceOutputConnector_3729IncomingLinks(view);
		case ProxyFaultInputConnectorEditPart.VISUAL_ID:
			return getProxyFaultInputConnector_3489IncomingLinks(view);
		case ProxyServiceContainerEditPart.VISUAL_ID:
			return getProxyServiceContainer_3486IncomingLinks(view);
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			return getProxyServiceSequenceAndEndpointContainer_3487IncomingLinks(view);
		case MediatorFlowEditPart.VISUAL_ID:
			return getMediatorFlow_3608IncomingLinks(view);
		case DropMediatorEditPart.VISUAL_ID:
			return getDropMediator_3491IncomingLinks(view);
		case DropMediatorInputConnectorEditPart.VISUAL_ID:
			return getDropMediatorInputConnector_3008IncomingLinks(view);
		case PropertyMediatorEditPart.VISUAL_ID:
			return getPropertyMediator_3492IncomingLinks(view);
		case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorInputConnector_3033IncomingLinks(view);
		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorOutputConnector_3034IncomingLinks(view);
		case ThrottleMediatorEditPart.VISUAL_ID:
			return getThrottleMediator_3493IncomingLinks(view);
		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorInputConnector_3121IncomingLinks(view);
		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOutputConnector_3122IncomingLinks(view);
		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnAcceptOutputConnector_3581IncomingLinks(view);
		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnRejectOutputConnector_3582IncomingLinks(view);
		case ThrottleContainerEditPart.VISUAL_ID:
			return getThrottleContainer_3583IncomingLinks(view);
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			return getThrottleOnAcceptContainer_3584IncomingLinks(view);
		case MediatorFlow9EditPart.VISUAL_ID:
			return getMediatorFlow_3585IncomingLinks(view);
		case FilterMediatorEditPart.VISUAL_ID:
			return getFilterMediator_3494IncomingLinks(view);
		case FilterMediatorInputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorInputConnector_3010IncomingLinks(view);
		case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorOutputConnector_3534IncomingLinks(view);
		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorPassOutputConnector_3011IncomingLinks(view);
		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorFailOutputConnector_3012IncomingLinks(view);
		case FilterContainerEditPart.VISUAL_ID:
			return getFilterContainer_3531IncomingLinks(view);
		case FilterPassContainerEditPart.VISUAL_ID:
			return getFilterPassContainer_3535IncomingLinks(view);
		case MediatorFlow7EditPart.VISUAL_ID:
			return getMediatorFlow_3536IncomingLinks(view);
		case LogMediatorEditPart.VISUAL_ID:
			return getLogMediator_3495IncomingLinks(view);
		case LogMediatorInputConnectorEditPart.VISUAL_ID:
			return getLogMediatorInputConnector_3018IncomingLinks(view);
		case LogMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLogMediatorOutputConnector_3019IncomingLinks(view);
		case EnrichMediatorEditPart.VISUAL_ID:
			return getEnrichMediator_3496IncomingLinks(view);
		case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorInputConnector_3036IncomingLinks(view);
		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorOutputConnector_3037IncomingLinks(view);
		case XSLTMediatorEditPart.VISUAL_ID:
			return getXSLTMediator_3497IncomingLinks(view);
		case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorInputConnector_3039IncomingLinks(view);
		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorOutputConnector_3040IncomingLinks(view);
		case SwitchMediatorEditPart.VISUAL_ID:
			return getSwitchMediator_3498IncomingLinks(view);
		case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorInputConnector_3042IncomingLinks(view);
		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorOutputConnector_3499IncomingLinks(view);
		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchCaseBranchOutputConnector_3043IncomingLinks(view);
		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchDefaultBranchOutputConnector_3044IncomingLinks(view);
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			return getSwitchMediatorContainer_3500IncomingLinks(view);
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			return getSwitchCaseParentContainer_3732IncomingLinks(view);
		case SwitchCaseContainerEditPart.VISUAL_ID:
			return getSwitchCaseContainer_3733IncomingLinks(view);
		case MediatorFlow2EditPart.VISUAL_ID:
			return getMediatorFlow_3502IncomingLinks(view);
		case SequenceEditPart.VISUAL_ID:
			return getSequence_3503IncomingLinks(view);
		case SequenceInputConnectorEditPart.VISUAL_ID:
			return getSequenceInputConnector_3049IncomingLinks(view);
		case SequenceOutputConnectorEditPart.VISUAL_ID:
			return getSequenceOutputConnector_3050IncomingLinks(view);
		case EventMediatorEditPart.VISUAL_ID:
			return getEventMediator_3504IncomingLinks(view);
		case EventMediatorInputConnectorEditPart.VISUAL_ID:
			return getEventMediatorInputConnector_3052IncomingLinks(view);
		case EventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEventMediatorOutputConnector_3053IncomingLinks(view);
		case EntitlementMediatorEditPart.VISUAL_ID:
			return getEntitlementMediator_3505IncomingLinks(view);
		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorInputConnector_3055IncomingLinks(view);
		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOutputConnector_3056IncomingLinks(view);
		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnRejectOutputConnector_3748IncomingLinks(view);
		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnAcceptOutputConnector_3749IncomingLinks(view);
		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorAdviceOutputConnector_3750IncomingLinks(view);
		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorObligationsOutputConnector_3751IncomingLinks(view);
		case EntitlementContainerEditPart.VISUAL_ID:
			return getEntitlementContainer_3752IncomingLinks(view);
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			return getEntitlementOnRejectContainer_3753IncomingLinks(view);
		case MediatorFlow21EditPart.VISUAL_ID:
			return getMediatorFlow_3754IncomingLinks(view);
		case ClassMediatorEditPart.VISUAL_ID:
			return getClassMediator_3506IncomingLinks(view);
		case ClassMediatorInputConnectorEditPart.VISUAL_ID:
			return getClassMediatorInputConnector_3058IncomingLinks(view);
		case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
			return getClassMediatorOutputConnector_3059IncomingLinks(view);
		case SpringMediatorEditPart.VISUAL_ID:
			return getSpringMediator_3507IncomingLinks(view);
		case SpringMediatorInputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorInputConnector_3061IncomingLinks(view);
		case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorOutputConnector_3062IncomingLinks(view);
		case ScriptMediatorEditPart.VISUAL_ID:
			return getScriptMediator_3508IncomingLinks(view);
		case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorInputConnector_3064IncomingLinks(view);
		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorOutputConnector_3065IncomingLinks(view);
		case FaultMediatorEditPart.VISUAL_ID:
			return getFaultMediator_3509IncomingLinks(view);
		case FaultMediatorInputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorInputConnector_3067IncomingLinks(view);
		case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorOutputConnector_3068IncomingLinks(view);
		case XQueryMediatorEditPart.VISUAL_ID:
			return getXQueryMediator_3510IncomingLinks(view);
		case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorInputConnector_3070IncomingLinks(view);
		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorOutputConnector_3071IncomingLinks(view);
		case CommandMediatorEditPart.VISUAL_ID:
			return getCommandMediator_3511IncomingLinks(view);
		case CommandMediatorInputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorInputConnector_3073IncomingLinks(view);
		case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorOutputConnector_3074IncomingLinks(view);
		case DBLookupMediatorEditPart.VISUAL_ID:
			return getDBLookupMediator_3512IncomingLinks(view);
		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorInputConnector_3076IncomingLinks(view);
		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorOutputConnector_3077IncomingLinks(view);
		case DBReportMediatorEditPart.VISUAL_ID:
			return getDBReportMediator_3513IncomingLinks(view);
		case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorInputConnector_3079IncomingLinks(view);
		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorOutputConnector_3080IncomingLinks(view);
		case SmooksMediatorEditPart.VISUAL_ID:
			return getSmooksMediator_3514IncomingLinks(view);
		case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorInputConnector_3082IncomingLinks(view);
		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorOutputConnector_3083IncomingLinks(view);
		case SendMediatorEditPart.VISUAL_ID:
			return getSendMediator_3515IncomingLinks(view);
		case SendMediatorInputConnectorEditPart.VISUAL_ID:
			return getSendMediatorInputConnector_3085IncomingLinks(view);
		case SendMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorOutputConnector_3086IncomingLinks(view);
		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorEndpointOutputConnector_3539IncomingLinks(view);
		case MediatorFlow19EditPart.VISUAL_ID:
			return getMediatorFlow_3728IncomingLinks(view);
		case HeaderMediatorEditPart.VISUAL_ID:
			return getHeaderMediator_3516IncomingLinks(view);
		case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorInputConnector_3100IncomingLinks(view);
		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorOutputConnector_3101IncomingLinks(view);
		case CloneMediatorEditPart.VISUAL_ID:
			return getCloneMediator_3517IncomingLinks(view);
		case CloneMediatorInputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorInputConnector_3103IncomingLinks(view);
		case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorOutputConnector_3104IncomingLinks(view);
		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorTargetOutputConnector_3133IncomingLinks(view);
		case CloneMediatorContainerEditPart.VISUAL_ID:
			return getCloneMediatorContainer_3603IncomingLinks(view);
		case CloneTargetContainerEditPart.VISUAL_ID:
			return getCloneTargetContainer_3604IncomingLinks(view);
		case MediatorFlow11EditPart.VISUAL_ID:
			return getMediatorFlow_3605IncomingLinks(view);
		case CacheMediatorEditPart.VISUAL_ID:
			return getCacheMediator_3518IncomingLinks(view);
		case CacheMediatorInputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorInputConnector_3106IncomingLinks(view);
		case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOutputConnector_3107IncomingLinks(view);
		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOnHitOutputConnector_3618IncomingLinks(view);
		case MediatorFlow13EditPart.VISUAL_ID:
			return getMediatorFlow_3619IncomingLinks(view);
		case IterateMediatorEditPart.VISUAL_ID:
			return getIterateMediator_3519IncomingLinks(view);
		case IterateMediatorInputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorInputConnector_3109IncomingLinks(view);
		case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorOutputConnector_3110IncomingLinks(view);
		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorTargetOutputConnector_3606IncomingLinks(view);
		case MediatorFlow12EditPart.VISUAL_ID:
			return getMediatorFlow_3607IncomingLinks(view);
		case CalloutMediatorEditPart.VISUAL_ID:
			return getCalloutMediator_3520IncomingLinks(view);
		case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorInputConnector_3115IncomingLinks(view);
		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorOutputConnector_3116IncomingLinks(view);
		case TransactionMediatorEditPart.VISUAL_ID:
			return getTransactionMediator_3521IncomingLinks(view);
		case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorInputConnector_3118IncomingLinks(view);
		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorOutputConnector_3119IncomingLinks(view);
		case RMSequenceMediatorEditPart.VISUAL_ID:
			return getRMSequenceMediator_3522IncomingLinks(view);
		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorInputConnector_3124IncomingLinks(view);
		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorOutputConnector_3125IncomingLinks(view);
		case RuleMediatorEditPart.VISUAL_ID:
			return getRuleMediator_3523IncomingLinks(view);
		case RuleMediatorInputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorInputConnector_3127IncomingLinks(view);
		case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorOutputConnector_3128IncomingLinks(view);
		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorChildMediatorsOutputConnector_3640IncomingLinks(view);
		case MediatorFlow17EditPart.VISUAL_ID:
			return getMediatorFlow_3641IncomingLinks(view);
		case OAuthMediatorEditPart.VISUAL_ID:
			return getOAuthMediator_3524IncomingLinks(view);
		case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorInputConnector_3130IncomingLinks(view);
		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorOutputConnector_3131IncomingLinks(view);
		case AggregateMediatorEditPart.VISUAL_ID:
			return getAggregateMediator_3525IncomingLinks(view);
		case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorInputConnector_3112IncomingLinks(view);
		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOutputConnector_3113IncomingLinks(view);
		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOnCompleteOutputConnector_3132IncomingLinks(view);
		case MediatorFlow3EditPart.VISUAL_ID:
			return getMediatorFlow_3526IncomingLinks(view);
		case StoreMediatorEditPart.VISUAL_ID:
			return getStoreMediator_3588IncomingLinks(view);
		case StoreMediatorInputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorInputConnector_3589IncomingLinks(view);
		case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorOutputConnector_3590IncomingLinks(view);
		case BuilderMediatorEditPart.VISUAL_ID:
			return getBuilderMediator_3591IncomingLinks(view);
		case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
			return getBuilderMediatorInputConnector_3592IncomingLinks(view);
		case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
			return getBuilderMediatorOutputConector_3593IncomingLinks(view);
		case CallTemplateMediatorEditPart.VISUAL_ID:
			return getCallTemplateMediator_3594IncomingLinks(view);
		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorInputConnector_3595IncomingLinks(view);
		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorOutputConnector_3596IncomingLinks(view);
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			return getPayloadFactoryMediator_3597IncomingLinks(view);
		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorInputConnector_3598IncomingLinks(view);
		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorOutputConnector_3599IncomingLinks(view);
		case EnqueueMediatorEditPart.VISUAL_ID:
			return getEnqueueMediator_3600IncomingLinks(view);
		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorInputConnector_3601IncomingLinks(view);
		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorOutputConnector_3602IncomingLinks(view);
		case URLRewriteMediatorEditPart.VISUAL_ID:
			return getURLRewriteMediator_3620IncomingLinks(view);
		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorInputConnector_3621IncomingLinks(view);
		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorOutputConnector_3622IncomingLinks(view);
		case ValidateMediatorEditPart.VISUAL_ID:
			return getValidateMediator_3623IncomingLinks(view);
		case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorInputConnector_3624IncomingLinks(view);
		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOutputConnector_3625IncomingLinks(view);
		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOnFailOutputConnector_3626IncomingLinks(view);
		case MediatorFlow14EditPart.VISUAL_ID:
			return getMediatorFlow_3627IncomingLinks(view);
		case RouterMediatorEditPart.VISUAL_ID:
			return getRouterMediator_3628IncomingLinks(view);
		case RouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorInputConnector_3629IncomingLinks(view);
		case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorOutputConnector_3630IncomingLinks(view);
		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorTargetOutputConnector_3631IncomingLinks(view);
		case RouterMediatorContainerEditPart.VISUAL_ID:
			return getRouterMediatorContainer_3632IncomingLinks(view);
		case RouterTargetContainerEditPart.VISUAL_ID:
			return getRouterTargetContainer_3633IncomingLinks(view);
		case MediatorFlow15EditPart.VISUAL_ID:
			return getMediatorFlow_3634IncomingLinks(view);
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			return getConditionalRouterMediator_3635IncomingLinks(view);
		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorInputConnector_3636IncomingLinks(view);
		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorOutputConnector_3637IncomingLinks(view);
		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorAdditionalOutputConnector_3638IncomingLinks(view);
		case MediatorFlow16EditPart.VISUAL_ID:
			return getMediatorFlow_3639IncomingLinks(view);
		case BAMMediatorEditPart.VISUAL_ID:
			return getBAMMediator_3680IncomingLinks(view);
		case BAMMediatorInputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorInputConnector_3681IncomingLinks(view);
		case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorOutputConnector_3682IncomingLinks(view);
		case BeanMediatorEditPart.VISUAL_ID:
			return getBeanMediator_3683IncomingLinks(view);
		case BeanMediatorInputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorInputConnector_3684IncomingLinks(view);
		case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorOutputConnector_3685IncomingLinks(view);
		case EJBMediatorEditPart.VISUAL_ID:
			return getEJBMediator_3686IncomingLinks(view);
		case EJBMediatorInputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorInputConnector_3687IncomingLinks(view);
		case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorOutputConnector_3688IncomingLinks(view);
		case DefaultEndPointEditPart.VISUAL_ID:
			return getDefaultEndPoint_3609IncomingLinks(view);
		case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3021IncomingLinks(view);
		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3022IncomingLinks(view);
		case AddressEndPointEditPart.VISUAL_ID:
			return getAddressEndPoint_3610IncomingLinks(view);
		case AddressEndPointInputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3030IncomingLinks(view);
		case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3031IncomingLinks(view);
		case FailoverEndPointEditPart.VISUAL_ID:
			return getFailoverEndPoint_3611IncomingLinks(view);
		case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3088IncomingLinks(view);
		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3090IncomingLinks(view);
		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3097IncomingLinks(view);
		case RecipientListEndPointEditPart.VISUAL_ID:
			return getRecipientListEndPoint_3692IncomingLinks(view);
		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3693IncomingLinks(view);
		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3694IncomingLinks(view);
		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3695IncomingLinks(view);
		case WSDLEndPointEditPart.VISUAL_ID:
			return getWSDLEndPoint_3612IncomingLinks(view);
		case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3092IncomingLinks(view);
		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3093IncomingLinks(view);
		case NamedEndpointEditPart.VISUAL_ID:
			return getNamedEndpoint_3660IncomingLinks(view);
		case NamedEndpointInputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointInputConnector_3661IncomingLinks(view);
		case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointOutputConnector_3662IncomingLinks(view);
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3613IncomingLinks(view);
		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3095IncomingLinks(view);
		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3096IncomingLinks(view);
		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3098IncomingLinks(view);
		case APIResourceEndpointEditPart.VISUAL_ID:
			return getAPIResourceEndpoint_3674IncomingLinks(view);
		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointInputConnector_3675IncomingLinks(view);
		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointOutputConnector_3676IncomingLinks(view);
		case AddressingEndpointEditPart.VISUAL_ID:
			return getAddressingEndpoint_3689IncomingLinks(view);
		case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointInputConnector_3690IncomingLinks(view);
		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointOutputConnector_3691IncomingLinks(view);
		case HTTPEndpointEditPart.VISUAL_ID:
			return getHTTPEndpoint_3709IncomingLinks(view);
		case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3710IncomingLinks(view);
		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3711IncomingLinks(view);
		case TemplateEndpointEditPart.VISUAL_ID:
			return getTemplateEndpoint_3716IncomingLinks(view);
		case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3717IncomingLinks(view);
		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3718IncomingLinks(view);
		case CloudConnectorEditPart.VISUAL_ID:
			return getCloudConnector_3719IncomingLinks(view);
		case CloudConnectorInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorInputConnector_3720IncomingLinks(view);
		case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOutputConnector_3721IncomingLinks(view);
		case CloudConnectorOperationEditPart.VISUAL_ID:
			return getCloudConnectorOperation_3722IncomingLinks(view);
		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationInputConnector_3723IncomingLinks(view);
		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationOutputConnector_3724IncomingLinks(view);
		case LoopBackMediatorEditPart.VISUAL_ID:
			return getLoopBackMediator_3736IncomingLinks(view);
		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorInputConnector_3737IncomingLinks(view);
		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorOutputConnector_3738IncomingLinks(view);
		case RespondMediatorEditPart.VISUAL_ID:
			return getRespondMediator_3739IncomingLinks(view);
		case RespondMediatorInputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorInputConnector_3740IncomingLinks(view);
		case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorOutputConnector_3741IncomingLinks(view);
		case CallMediatorEditPart.VISUAL_ID:
			return getCallMediator_3742IncomingLinks(view);
		case CallMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallMediatorInputConnector_3743IncomingLinks(view);
		case CallMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorOutputConnector_3744IncomingLinks(view);
		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorEndpointOutputConnector_3745IncomingLinks(view);
		case MediatorFlow20EditPart.VISUAL_ID:
			return getMediatorFlow_3746IncomingLinks(view);
		case DataMapperMediatorEditPart.VISUAL_ID:
			return getDataMapperMediator_3761IncomingLinks(view);
		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorInputConnector_3762IncomingLinks(view);
		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorOutputConnector_3763IncomingLinks(view);
		case FastXSLTMediatorEditPart.VISUAL_ID:
			return getFastXSLTMediator_3764IncomingLinks(view);
		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorInputConnector_3765IncomingLinks(view);
		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorOutputConnector_3766IncomingLinks(view);
		case ForEachMediatorEditPart.VISUAL_ID:
			return getForEachMediator_3780IncomingLinks(view);
		case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorInputConnector_3781IncomingLinks(view);
		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorOutputConnector_3782IncomingLinks(view);
		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorTargetOutputConnector_3783IncomingLinks(view);
		case MediatorFlow30EditPart.VISUAL_ID:
			return getMediatorFlow_3784IncomingLinks(view);
		case PublishEventMediatorEditPart.VISUAL_ID:
			return getPublishEventMediator_3785IncomingLinks(view);
		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorInputConnector_3786IncomingLinks(view);
		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorOutputConnector_3787IncomingLinks(view);
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			return getEntitlementOnAcceptContainer_3755IncomingLinks(view);
		case MediatorFlow22EditPart.VISUAL_ID:
			return getMediatorFlow_3756IncomingLinks(view);
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			return getEntitlementAdviceContainer_3757IncomingLinks(view);
		case MediatorFlow23EditPart.VISUAL_ID:
			return getMediatorFlow_3758IncomingLinks(view);
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			return getEntitlementObligationsContainer_3759IncomingLinks(view);
		case MediatorFlow24EditPart.VISUAL_ID:
			return getMediatorFlow_3760IncomingLinks(view);
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			return getSwitchDefaultParentContainer_3734IncomingLinks(view);
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			return getSwitchDefaultContainer_3735IncomingLinks(view);
		case MediatorFlow4EditPart.VISUAL_ID:
			return getMediatorFlow_3528IncomingLinks(view);
		case FilterFailContainerEditPart.VISUAL_ID:
			return getFilterFailContainer_3537IncomingLinks(view);
		case MediatorFlow8EditPart.VISUAL_ID:
			return getMediatorFlow_3538IncomingLinks(view);
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			return getThrottleOnRejectContainer_3586IncomingLinks(view);
		case MediatorFlow10EditPart.VISUAL_ID:
			return getMediatorFlow_3587IncomingLinks(view);
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			return getProxyServiceFaultContainer_3488IncomingLinks(view);
		case MediatorFlow6EditPart.VISUAL_ID:
			return getMediatorFlow_3530IncomingLinks(view);
		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
			return getProxyInSequenceInputConnector_3731IncomingLinks(view);
		case MessageMediatorEditPart.VISUAL_ID:
			return getMessageMediator_3045IncomingLinks(view);
		case MessageInputConnectorEditPart.VISUAL_ID:
			return getMessageInputConnector_3046IncomingLinks(view);
		case MessageOutputConnectorEditPart.VISUAL_ID:
			return getMessageOutputConnector_3047IncomingLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3013IncomingLinks(view);
		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeFirstInputConnector_3014IncomingLinks(view);
		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeSecondInputConnector_3015IncomingLinks(view);
		case MergeNodeOutputConnectorEditPart.VISUAL_ID:
			return getMergeNodeOutputConnector_3016IncomingLinks(view);
		case SequencesEditPart.VISUAL_ID:
			return getSequences_3614IncomingLinks(view);
		case MediatorFlow5EditPart.VISUAL_ID:
			return getMediatorFlow_3615IncomingLinks(view);
		case SequencesInputConnectorEditPart.VISUAL_ID:
			return getSequencesInputConnector_3616IncomingLinks(view);
		case SequencesOutputConnectorEditPart.VISUAL_ID:
			return getSequencesOutputConnector_3617IncomingLinks(view);
		case EndpointDiagramEditPart.VISUAL_ID:
			return getEndpointDiagram_3642IncomingLinks(view);
		case DefaultEndPoint2EditPart.VISUAL_ID:
			return getDefaultEndPoint_3643IncomingLinks(view);
		case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3644IncomingLinks(view);
		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3645IncomingLinks(view);
		case AddressEndPoint2EditPart.VISUAL_ID:
			return getAddressEndPoint_3646IncomingLinks(view);
		case AddressEndPointInputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3647IncomingLinks(view);
		case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3648IncomingLinks(view);
		case FailoverEndPoint2EditPart.VISUAL_ID:
			return getFailoverEndPoint_3649IncomingLinks(view);
		case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3650IncomingLinks(view);
		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3651IncomingLinks(view);
		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3652IncomingLinks(view);
		case MediatorFlow27EditPart.VISUAL_ID:
			return getMediatorFlow_3777IncomingLinks(view);
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			return getRecipientListEndPoint_3696IncomingLinks(view);
		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3697IncomingLinks(view);
		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3698IncomingLinks(view);
		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3699IncomingLinks(view);
		case MediatorFlow28EditPart.VISUAL_ID:
			return getMediatorFlow_3778IncomingLinks(view);
		case WSDLEndPoint2EditPart.VISUAL_ID:
			return getWSDLEndPoint_3653IncomingLinks(view);
		case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3654IncomingLinks(view);
		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3655IncomingLinks(view);
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3656IncomingLinks(view);
		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3657IncomingLinks(view);
		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3658IncomingLinks(view);
		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3659IncomingLinks(view);
		case MediatorFlow29EditPart.VISUAL_ID:
			return getMediatorFlow_3779IncomingLinks(view);
		case HTTPEndpoint2EditPart.VISUAL_ID:
			return getHTTPEndpoint_3712IncomingLinks(view);
		case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3713IncomingLinks(view);
		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3714IncomingLinks(view);
		case TemplateEndpoint2EditPart.VISUAL_ID:
			return getTemplateEndpoint_3725IncomingLinks(view);
		case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3726IncomingLinks(view);
		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3727IncomingLinks(view);
		case LocalEntryEditPart.VISUAL_ID:
			return getLocalEntry_3663IncomingLinks(view);
		case TemplateEditPart.VISUAL_ID:
			return getTemplate_3664IncomingLinks(view);
		case Sequences2EditPart.VISUAL_ID:
			return getSequences_3665IncomingLinks(view);
		case EndpointDiagram2EditPart.VISUAL_ID:
			return getEndpointDiagram_3666IncomingLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3667IncomingLinks(view);
		case SynapseAPIEditPart.VISUAL_ID:
			return getSynapseAPI_3668IncomingLinks(view);
		case APIResourceEditPart.VISUAL_ID:
			return getAPIResource_3669IncomingLinks(view);
		case APIResourceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInputConnector_3670IncomingLinks(view);
		case APIResourceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutputConnector_3671IncomingLinks(view);
		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutSequenceOutputConnector_3730IncomingLinks(view);
		case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceFaultInputConnector_3672IncomingLinks(view);
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			return getProxyServiceContainer_3673IncomingLinks(view);
		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInSequenceInputConnector_3747IncomingLinks(view);
		case ComplexEndpointsEditPart.VISUAL_ID:
			return getComplexEndpoints_3677IncomingLinks(view);
		case MediatorFlow18EditPart.VISUAL_ID:
			return getMediatorFlow_3678IncomingLinks(view);
		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
			return getComplexEndpointsOutputConnector_3679IncomingLinks(view);
		case MessageStoreEditPart.VISUAL_ID:
			return getMessageStore_3715IncomingLinks(view);
		case MessageProcessorEditPart.VISUAL_ID:
			return getMessageProcessor_3701IncomingLinks(view);
		case InboundEndpointEditPart.VISUAL_ID:
			return getInboundEndpoint_3767IncomingLinks(view);
		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceInputConnector_3768IncomingLinks(view);
		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceOutputConnector_3769IncomingLinks(view);
		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceInputConnector_3770IncomingLinks(view);
		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceOutputConnector_3771IncomingLinks(view);
		case InboundEndpointContainerEditPart.VISUAL_ID:
			return getInboundEndpointContainer_3772IncomingLinks(view);
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointSequenceContainer_3773IncomingLinks(view);
		case MediatorFlow25EditPart.VISUAL_ID:
			return getMediatorFlow_3774IncomingLinks(view);
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceContainer_3775IncomingLinks(view);
		case MediatorFlow26EditPart.VISUAL_ID:
			return getMediatorFlow_3776IncomingLinks(view);
		case EsbLinkEditPart.VISUAL_ID:
			return getEsbLink_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOutgoingLinks(View view) {
		switch (EsbVisualIDRegistry.getVisualID(view)) {
		case EsbServerEditPart.VISUAL_ID:
			return getEsbServer_2001OutgoingLinks(view);
		case ProxyServiceEditPart.VISUAL_ID:
			return getProxyService_3001OutgoingLinks(view);
		case ProxyOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutputConnector_3002OutgoingLinks(view);
		case ProxyInputConnectorEditPart.VISUAL_ID:
			return getProxyInputConnector_3003OutgoingLinks(view);
		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutSequenceOutputConnector_3729OutgoingLinks(view);
		case ProxyFaultInputConnectorEditPart.VISUAL_ID:
			return getProxyFaultInputConnector_3489OutgoingLinks(view);
		case ProxyServiceContainerEditPart.VISUAL_ID:
			return getProxyServiceContainer_3486OutgoingLinks(view);
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			return getProxyServiceSequenceAndEndpointContainer_3487OutgoingLinks(view);
		case MediatorFlowEditPart.VISUAL_ID:
			return getMediatorFlow_3608OutgoingLinks(view);
		case DropMediatorEditPart.VISUAL_ID:
			return getDropMediator_3491OutgoingLinks(view);
		case DropMediatorInputConnectorEditPart.VISUAL_ID:
			return getDropMediatorInputConnector_3008OutgoingLinks(view);
		case PropertyMediatorEditPart.VISUAL_ID:
			return getPropertyMediator_3492OutgoingLinks(view);
		case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorInputConnector_3033OutgoingLinks(view);
		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorOutputConnector_3034OutgoingLinks(view);
		case ThrottleMediatorEditPart.VISUAL_ID:
			return getThrottleMediator_3493OutgoingLinks(view);
		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorInputConnector_3121OutgoingLinks(view);
		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOutputConnector_3122OutgoingLinks(view);
		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnAcceptOutputConnector_3581OutgoingLinks(view);
		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnRejectOutputConnector_3582OutgoingLinks(view);
		case ThrottleContainerEditPart.VISUAL_ID:
			return getThrottleContainer_3583OutgoingLinks(view);
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			return getThrottleOnAcceptContainer_3584OutgoingLinks(view);
		case MediatorFlow9EditPart.VISUAL_ID:
			return getMediatorFlow_3585OutgoingLinks(view);
		case FilterMediatorEditPart.VISUAL_ID:
			return getFilterMediator_3494OutgoingLinks(view);
		case FilterMediatorInputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorInputConnector_3010OutgoingLinks(view);
		case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorOutputConnector_3534OutgoingLinks(view);
		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorPassOutputConnector_3011OutgoingLinks(view);
		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorFailOutputConnector_3012OutgoingLinks(view);
		case FilterContainerEditPart.VISUAL_ID:
			return getFilterContainer_3531OutgoingLinks(view);
		case FilterPassContainerEditPart.VISUAL_ID:
			return getFilterPassContainer_3535OutgoingLinks(view);
		case MediatorFlow7EditPart.VISUAL_ID:
			return getMediatorFlow_3536OutgoingLinks(view);
		case LogMediatorEditPart.VISUAL_ID:
			return getLogMediator_3495OutgoingLinks(view);
		case LogMediatorInputConnectorEditPart.VISUAL_ID:
			return getLogMediatorInputConnector_3018OutgoingLinks(view);
		case LogMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLogMediatorOutputConnector_3019OutgoingLinks(view);
		case EnrichMediatorEditPart.VISUAL_ID:
			return getEnrichMediator_3496OutgoingLinks(view);
		case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorInputConnector_3036OutgoingLinks(view);
		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorOutputConnector_3037OutgoingLinks(view);
		case XSLTMediatorEditPart.VISUAL_ID:
			return getXSLTMediator_3497OutgoingLinks(view);
		case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorInputConnector_3039OutgoingLinks(view);
		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorOutputConnector_3040OutgoingLinks(view);
		case SwitchMediatorEditPart.VISUAL_ID:
			return getSwitchMediator_3498OutgoingLinks(view);
		case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorInputConnector_3042OutgoingLinks(view);
		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorOutputConnector_3499OutgoingLinks(view);
		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchCaseBranchOutputConnector_3043OutgoingLinks(view);
		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchDefaultBranchOutputConnector_3044OutgoingLinks(view);
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			return getSwitchMediatorContainer_3500OutgoingLinks(view);
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			return getSwitchCaseParentContainer_3732OutgoingLinks(view);
		case SwitchCaseContainerEditPart.VISUAL_ID:
			return getSwitchCaseContainer_3733OutgoingLinks(view);
		case MediatorFlow2EditPart.VISUAL_ID:
			return getMediatorFlow_3502OutgoingLinks(view);
		case SequenceEditPart.VISUAL_ID:
			return getSequence_3503OutgoingLinks(view);
		case SequenceInputConnectorEditPart.VISUAL_ID:
			return getSequenceInputConnector_3049OutgoingLinks(view);
		case SequenceOutputConnectorEditPart.VISUAL_ID:
			return getSequenceOutputConnector_3050OutgoingLinks(view);
		case EventMediatorEditPart.VISUAL_ID:
			return getEventMediator_3504OutgoingLinks(view);
		case EventMediatorInputConnectorEditPart.VISUAL_ID:
			return getEventMediatorInputConnector_3052OutgoingLinks(view);
		case EventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEventMediatorOutputConnector_3053OutgoingLinks(view);
		case EntitlementMediatorEditPart.VISUAL_ID:
			return getEntitlementMediator_3505OutgoingLinks(view);
		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorInputConnector_3055OutgoingLinks(view);
		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOutputConnector_3056OutgoingLinks(view);
		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnRejectOutputConnector_3748OutgoingLinks(view);
		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnAcceptOutputConnector_3749OutgoingLinks(view);
		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorAdviceOutputConnector_3750OutgoingLinks(view);
		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorObligationsOutputConnector_3751OutgoingLinks(view);
		case EntitlementContainerEditPart.VISUAL_ID:
			return getEntitlementContainer_3752OutgoingLinks(view);
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			return getEntitlementOnRejectContainer_3753OutgoingLinks(view);
		case MediatorFlow21EditPart.VISUAL_ID:
			return getMediatorFlow_3754OutgoingLinks(view);
		case ClassMediatorEditPart.VISUAL_ID:
			return getClassMediator_3506OutgoingLinks(view);
		case ClassMediatorInputConnectorEditPart.VISUAL_ID:
			return getClassMediatorInputConnector_3058OutgoingLinks(view);
		case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
			return getClassMediatorOutputConnector_3059OutgoingLinks(view);
		case SpringMediatorEditPart.VISUAL_ID:
			return getSpringMediator_3507OutgoingLinks(view);
		case SpringMediatorInputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorInputConnector_3061OutgoingLinks(view);
		case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorOutputConnector_3062OutgoingLinks(view);
		case ScriptMediatorEditPart.VISUAL_ID:
			return getScriptMediator_3508OutgoingLinks(view);
		case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorInputConnector_3064OutgoingLinks(view);
		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorOutputConnector_3065OutgoingLinks(view);
		case FaultMediatorEditPart.VISUAL_ID:
			return getFaultMediator_3509OutgoingLinks(view);
		case FaultMediatorInputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorInputConnector_3067OutgoingLinks(view);
		case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorOutputConnector_3068OutgoingLinks(view);
		case XQueryMediatorEditPart.VISUAL_ID:
			return getXQueryMediator_3510OutgoingLinks(view);
		case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorInputConnector_3070OutgoingLinks(view);
		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorOutputConnector_3071OutgoingLinks(view);
		case CommandMediatorEditPart.VISUAL_ID:
			return getCommandMediator_3511OutgoingLinks(view);
		case CommandMediatorInputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorInputConnector_3073OutgoingLinks(view);
		case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorOutputConnector_3074OutgoingLinks(view);
		case DBLookupMediatorEditPart.VISUAL_ID:
			return getDBLookupMediator_3512OutgoingLinks(view);
		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorInputConnector_3076OutgoingLinks(view);
		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorOutputConnector_3077OutgoingLinks(view);
		case DBReportMediatorEditPart.VISUAL_ID:
			return getDBReportMediator_3513OutgoingLinks(view);
		case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorInputConnector_3079OutgoingLinks(view);
		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorOutputConnector_3080OutgoingLinks(view);
		case SmooksMediatorEditPart.VISUAL_ID:
			return getSmooksMediator_3514OutgoingLinks(view);
		case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorInputConnector_3082OutgoingLinks(view);
		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorOutputConnector_3083OutgoingLinks(view);
		case SendMediatorEditPart.VISUAL_ID:
			return getSendMediator_3515OutgoingLinks(view);
		case SendMediatorInputConnectorEditPart.VISUAL_ID:
			return getSendMediatorInputConnector_3085OutgoingLinks(view);
		case SendMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorOutputConnector_3086OutgoingLinks(view);
		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorEndpointOutputConnector_3539OutgoingLinks(view);
		case MediatorFlow19EditPart.VISUAL_ID:
			return getMediatorFlow_3728OutgoingLinks(view);
		case HeaderMediatorEditPart.VISUAL_ID:
			return getHeaderMediator_3516OutgoingLinks(view);
		case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorInputConnector_3100OutgoingLinks(view);
		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorOutputConnector_3101OutgoingLinks(view);
		case CloneMediatorEditPart.VISUAL_ID:
			return getCloneMediator_3517OutgoingLinks(view);
		case CloneMediatorInputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorInputConnector_3103OutgoingLinks(view);
		case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorOutputConnector_3104OutgoingLinks(view);
		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorTargetOutputConnector_3133OutgoingLinks(view);
		case CloneMediatorContainerEditPart.VISUAL_ID:
			return getCloneMediatorContainer_3603OutgoingLinks(view);
		case CloneTargetContainerEditPart.VISUAL_ID:
			return getCloneTargetContainer_3604OutgoingLinks(view);
		case MediatorFlow11EditPart.VISUAL_ID:
			return getMediatorFlow_3605OutgoingLinks(view);
		case CacheMediatorEditPart.VISUAL_ID:
			return getCacheMediator_3518OutgoingLinks(view);
		case CacheMediatorInputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorInputConnector_3106OutgoingLinks(view);
		case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOutputConnector_3107OutgoingLinks(view);
		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOnHitOutputConnector_3618OutgoingLinks(view);
		case MediatorFlow13EditPart.VISUAL_ID:
			return getMediatorFlow_3619OutgoingLinks(view);
		case IterateMediatorEditPart.VISUAL_ID:
			return getIterateMediator_3519OutgoingLinks(view);
		case IterateMediatorInputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorInputConnector_3109OutgoingLinks(view);
		case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorOutputConnector_3110OutgoingLinks(view);
		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorTargetOutputConnector_3606OutgoingLinks(view);
		case MediatorFlow12EditPart.VISUAL_ID:
			return getMediatorFlow_3607OutgoingLinks(view);
		case CalloutMediatorEditPart.VISUAL_ID:
			return getCalloutMediator_3520OutgoingLinks(view);
		case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorInputConnector_3115OutgoingLinks(view);
		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorOutputConnector_3116OutgoingLinks(view);
		case TransactionMediatorEditPart.VISUAL_ID:
			return getTransactionMediator_3521OutgoingLinks(view);
		case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorInputConnector_3118OutgoingLinks(view);
		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorOutputConnector_3119OutgoingLinks(view);
		case RMSequenceMediatorEditPart.VISUAL_ID:
			return getRMSequenceMediator_3522OutgoingLinks(view);
		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorInputConnector_3124OutgoingLinks(view);
		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorOutputConnector_3125OutgoingLinks(view);
		case RuleMediatorEditPart.VISUAL_ID:
			return getRuleMediator_3523OutgoingLinks(view);
		case RuleMediatorInputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorInputConnector_3127OutgoingLinks(view);
		case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorOutputConnector_3128OutgoingLinks(view);
		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorChildMediatorsOutputConnector_3640OutgoingLinks(view);
		case MediatorFlow17EditPart.VISUAL_ID:
			return getMediatorFlow_3641OutgoingLinks(view);
		case OAuthMediatorEditPart.VISUAL_ID:
			return getOAuthMediator_3524OutgoingLinks(view);
		case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorInputConnector_3130OutgoingLinks(view);
		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorOutputConnector_3131OutgoingLinks(view);
		case AggregateMediatorEditPart.VISUAL_ID:
			return getAggregateMediator_3525OutgoingLinks(view);
		case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorInputConnector_3112OutgoingLinks(view);
		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOutputConnector_3113OutgoingLinks(view);
		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOnCompleteOutputConnector_3132OutgoingLinks(view);
		case MediatorFlow3EditPart.VISUAL_ID:
			return getMediatorFlow_3526OutgoingLinks(view);
		case StoreMediatorEditPart.VISUAL_ID:
			return getStoreMediator_3588OutgoingLinks(view);
		case StoreMediatorInputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorInputConnector_3589OutgoingLinks(view);
		case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorOutputConnector_3590OutgoingLinks(view);
		case BuilderMediatorEditPart.VISUAL_ID:
			return getBuilderMediator_3591OutgoingLinks(view);
		case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
			return getBuilderMediatorInputConnector_3592OutgoingLinks(view);
		case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
			return getBuilderMediatorOutputConector_3593OutgoingLinks(view);
		case CallTemplateMediatorEditPart.VISUAL_ID:
			return getCallTemplateMediator_3594OutgoingLinks(view);
		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorInputConnector_3595OutgoingLinks(view);
		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorOutputConnector_3596OutgoingLinks(view);
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			return getPayloadFactoryMediator_3597OutgoingLinks(view);
		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorInputConnector_3598OutgoingLinks(view);
		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorOutputConnector_3599OutgoingLinks(view);
		case EnqueueMediatorEditPart.VISUAL_ID:
			return getEnqueueMediator_3600OutgoingLinks(view);
		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorInputConnector_3601OutgoingLinks(view);
		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorOutputConnector_3602OutgoingLinks(view);
		case URLRewriteMediatorEditPart.VISUAL_ID:
			return getURLRewriteMediator_3620OutgoingLinks(view);
		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorInputConnector_3621OutgoingLinks(view);
		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorOutputConnector_3622OutgoingLinks(view);
		case ValidateMediatorEditPart.VISUAL_ID:
			return getValidateMediator_3623OutgoingLinks(view);
		case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorInputConnector_3624OutgoingLinks(view);
		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOutputConnector_3625OutgoingLinks(view);
		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOnFailOutputConnector_3626OutgoingLinks(view);
		case MediatorFlow14EditPart.VISUAL_ID:
			return getMediatorFlow_3627OutgoingLinks(view);
		case RouterMediatorEditPart.VISUAL_ID:
			return getRouterMediator_3628OutgoingLinks(view);
		case RouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorInputConnector_3629OutgoingLinks(view);
		case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorOutputConnector_3630OutgoingLinks(view);
		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorTargetOutputConnector_3631OutgoingLinks(view);
		case RouterMediatorContainerEditPart.VISUAL_ID:
			return getRouterMediatorContainer_3632OutgoingLinks(view);
		case RouterTargetContainerEditPart.VISUAL_ID:
			return getRouterTargetContainer_3633OutgoingLinks(view);
		case MediatorFlow15EditPart.VISUAL_ID:
			return getMediatorFlow_3634OutgoingLinks(view);
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			return getConditionalRouterMediator_3635OutgoingLinks(view);
		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorInputConnector_3636OutgoingLinks(view);
		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorOutputConnector_3637OutgoingLinks(view);
		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorAdditionalOutputConnector_3638OutgoingLinks(view);
		case MediatorFlow16EditPart.VISUAL_ID:
			return getMediatorFlow_3639OutgoingLinks(view);
		case BAMMediatorEditPart.VISUAL_ID:
			return getBAMMediator_3680OutgoingLinks(view);
		case BAMMediatorInputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorInputConnector_3681OutgoingLinks(view);
		case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorOutputConnector_3682OutgoingLinks(view);
		case BeanMediatorEditPart.VISUAL_ID:
			return getBeanMediator_3683OutgoingLinks(view);
		case BeanMediatorInputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorInputConnector_3684OutgoingLinks(view);
		case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorOutputConnector_3685OutgoingLinks(view);
		case EJBMediatorEditPart.VISUAL_ID:
			return getEJBMediator_3686OutgoingLinks(view);
		case EJBMediatorInputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorInputConnector_3687OutgoingLinks(view);
		case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorOutputConnector_3688OutgoingLinks(view);
		case DefaultEndPointEditPart.VISUAL_ID:
			return getDefaultEndPoint_3609OutgoingLinks(view);
		case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3021OutgoingLinks(view);
		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3022OutgoingLinks(view);
		case AddressEndPointEditPart.VISUAL_ID:
			return getAddressEndPoint_3610OutgoingLinks(view);
		case AddressEndPointInputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3030OutgoingLinks(view);
		case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3031OutgoingLinks(view);
		case FailoverEndPointEditPart.VISUAL_ID:
			return getFailoverEndPoint_3611OutgoingLinks(view);
		case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3088OutgoingLinks(view);
		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3090OutgoingLinks(view);
		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3097OutgoingLinks(view);
		case RecipientListEndPointEditPart.VISUAL_ID:
			return getRecipientListEndPoint_3692OutgoingLinks(view);
		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3693OutgoingLinks(view);
		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3694OutgoingLinks(view);
		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3695OutgoingLinks(view);
		case WSDLEndPointEditPart.VISUAL_ID:
			return getWSDLEndPoint_3612OutgoingLinks(view);
		case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3092OutgoingLinks(view);
		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3093OutgoingLinks(view);
		case NamedEndpointEditPart.VISUAL_ID:
			return getNamedEndpoint_3660OutgoingLinks(view);
		case NamedEndpointInputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointInputConnector_3661OutgoingLinks(view);
		case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointOutputConnector_3662OutgoingLinks(view);
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3613OutgoingLinks(view);
		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3095OutgoingLinks(view);
		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3096OutgoingLinks(view);
		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3098OutgoingLinks(view);
		case APIResourceEndpointEditPart.VISUAL_ID:
			return getAPIResourceEndpoint_3674OutgoingLinks(view);
		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointInputConnector_3675OutgoingLinks(view);
		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointOutputConnector_3676OutgoingLinks(view);
		case AddressingEndpointEditPart.VISUAL_ID:
			return getAddressingEndpoint_3689OutgoingLinks(view);
		case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointInputConnector_3690OutgoingLinks(view);
		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointOutputConnector_3691OutgoingLinks(view);
		case HTTPEndpointEditPart.VISUAL_ID:
			return getHTTPEndpoint_3709OutgoingLinks(view);
		case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3710OutgoingLinks(view);
		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3711OutgoingLinks(view);
		case TemplateEndpointEditPart.VISUAL_ID:
			return getTemplateEndpoint_3716OutgoingLinks(view);
		case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3717OutgoingLinks(view);
		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3718OutgoingLinks(view);
		case CloudConnectorEditPart.VISUAL_ID:
			return getCloudConnector_3719OutgoingLinks(view);
		case CloudConnectorInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorInputConnector_3720OutgoingLinks(view);
		case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOutputConnector_3721OutgoingLinks(view);
		case CloudConnectorOperationEditPart.VISUAL_ID:
			return getCloudConnectorOperation_3722OutgoingLinks(view);
		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationInputConnector_3723OutgoingLinks(view);
		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationOutputConnector_3724OutgoingLinks(view);
		case LoopBackMediatorEditPart.VISUAL_ID:
			return getLoopBackMediator_3736OutgoingLinks(view);
		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorInputConnector_3737OutgoingLinks(view);
		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorOutputConnector_3738OutgoingLinks(view);
		case RespondMediatorEditPart.VISUAL_ID:
			return getRespondMediator_3739OutgoingLinks(view);
		case RespondMediatorInputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorInputConnector_3740OutgoingLinks(view);
		case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorOutputConnector_3741OutgoingLinks(view);
		case CallMediatorEditPart.VISUAL_ID:
			return getCallMediator_3742OutgoingLinks(view);
		case CallMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallMediatorInputConnector_3743OutgoingLinks(view);
		case CallMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorOutputConnector_3744OutgoingLinks(view);
		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorEndpointOutputConnector_3745OutgoingLinks(view);
		case MediatorFlow20EditPart.VISUAL_ID:
			return getMediatorFlow_3746OutgoingLinks(view);
		case DataMapperMediatorEditPart.VISUAL_ID:
			return getDataMapperMediator_3761OutgoingLinks(view);
		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorInputConnector_3762OutgoingLinks(view);
		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorOutputConnector_3763OutgoingLinks(view);
		case FastXSLTMediatorEditPart.VISUAL_ID:
			return getFastXSLTMediator_3764OutgoingLinks(view);
		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorInputConnector_3765OutgoingLinks(view);
		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorOutputConnector_3766OutgoingLinks(view);
		case ForEachMediatorEditPart.VISUAL_ID:
			return getForEachMediator_3780OutgoingLinks(view);
		case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorInputConnector_3781OutgoingLinks(view);
		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorOutputConnector_3782OutgoingLinks(view);
		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorTargetOutputConnector_3783OutgoingLinks(view);
		case MediatorFlow30EditPart.VISUAL_ID:
			return getMediatorFlow_3784OutgoingLinks(view);
		case PublishEventMediatorEditPart.VISUAL_ID:
			return getPublishEventMediator_3785OutgoingLinks(view);
		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorInputConnector_3786OutgoingLinks(view);
		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorOutputConnector_3787OutgoingLinks(view);
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			return getEntitlementOnAcceptContainer_3755OutgoingLinks(view);
		case MediatorFlow22EditPart.VISUAL_ID:
			return getMediatorFlow_3756OutgoingLinks(view);
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			return getEntitlementAdviceContainer_3757OutgoingLinks(view);
		case MediatorFlow23EditPart.VISUAL_ID:
			return getMediatorFlow_3758OutgoingLinks(view);
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			return getEntitlementObligationsContainer_3759OutgoingLinks(view);
		case MediatorFlow24EditPart.VISUAL_ID:
			return getMediatorFlow_3760OutgoingLinks(view);
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			return getSwitchDefaultParentContainer_3734OutgoingLinks(view);
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			return getSwitchDefaultContainer_3735OutgoingLinks(view);
		case MediatorFlow4EditPart.VISUAL_ID:
			return getMediatorFlow_3528OutgoingLinks(view);
		case FilterFailContainerEditPart.VISUAL_ID:
			return getFilterFailContainer_3537OutgoingLinks(view);
		case MediatorFlow8EditPart.VISUAL_ID:
			return getMediatorFlow_3538OutgoingLinks(view);
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			return getThrottleOnRejectContainer_3586OutgoingLinks(view);
		case MediatorFlow10EditPart.VISUAL_ID:
			return getMediatorFlow_3587OutgoingLinks(view);
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			return getProxyServiceFaultContainer_3488OutgoingLinks(view);
		case MediatorFlow6EditPart.VISUAL_ID:
			return getMediatorFlow_3530OutgoingLinks(view);
		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
			return getProxyInSequenceInputConnector_3731OutgoingLinks(view);
		case MessageMediatorEditPart.VISUAL_ID:
			return getMessageMediator_3045OutgoingLinks(view);
		case MessageInputConnectorEditPart.VISUAL_ID:
			return getMessageInputConnector_3046OutgoingLinks(view);
		case MessageOutputConnectorEditPart.VISUAL_ID:
			return getMessageOutputConnector_3047OutgoingLinks(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3013OutgoingLinks(view);
		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeFirstInputConnector_3014OutgoingLinks(view);
		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeSecondInputConnector_3015OutgoingLinks(view);
		case MergeNodeOutputConnectorEditPart.VISUAL_ID:
			return getMergeNodeOutputConnector_3016OutgoingLinks(view);
		case SequencesEditPart.VISUAL_ID:
			return getSequences_3614OutgoingLinks(view);
		case MediatorFlow5EditPart.VISUAL_ID:
			return getMediatorFlow_3615OutgoingLinks(view);
		case SequencesInputConnectorEditPart.VISUAL_ID:
			return getSequencesInputConnector_3616OutgoingLinks(view);
		case SequencesOutputConnectorEditPart.VISUAL_ID:
			return getSequencesOutputConnector_3617OutgoingLinks(view);
		case EndpointDiagramEditPart.VISUAL_ID:
			return getEndpointDiagram_3642OutgoingLinks(view);
		case DefaultEndPoint2EditPart.VISUAL_ID:
			return getDefaultEndPoint_3643OutgoingLinks(view);
		case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3644OutgoingLinks(view);
		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3645OutgoingLinks(view);
		case AddressEndPoint2EditPart.VISUAL_ID:
			return getAddressEndPoint_3646OutgoingLinks(view);
		case AddressEndPointInputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3647OutgoingLinks(view);
		case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3648OutgoingLinks(view);
		case FailoverEndPoint2EditPart.VISUAL_ID:
			return getFailoverEndPoint_3649OutgoingLinks(view);
		case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3650OutgoingLinks(view);
		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3651OutgoingLinks(view);
		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3652OutgoingLinks(view);
		case MediatorFlow27EditPart.VISUAL_ID:
			return getMediatorFlow_3777OutgoingLinks(view);
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			return getRecipientListEndPoint_3696OutgoingLinks(view);
		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3697OutgoingLinks(view);
		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3698OutgoingLinks(view);
		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3699OutgoingLinks(view);
		case MediatorFlow28EditPart.VISUAL_ID:
			return getMediatorFlow_3778OutgoingLinks(view);
		case WSDLEndPoint2EditPart.VISUAL_ID:
			return getWSDLEndPoint_3653OutgoingLinks(view);
		case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3654OutgoingLinks(view);
		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3655OutgoingLinks(view);
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3656OutgoingLinks(view);
		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3657OutgoingLinks(view);
		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3658OutgoingLinks(view);
		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3659OutgoingLinks(view);
		case MediatorFlow29EditPart.VISUAL_ID:
			return getMediatorFlow_3779OutgoingLinks(view);
		case HTTPEndpoint2EditPart.VISUAL_ID:
			return getHTTPEndpoint_3712OutgoingLinks(view);
		case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3713OutgoingLinks(view);
		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3714OutgoingLinks(view);
		case TemplateEndpoint2EditPart.VISUAL_ID:
			return getTemplateEndpoint_3725OutgoingLinks(view);
		case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3726OutgoingLinks(view);
		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3727OutgoingLinks(view);
		case LocalEntryEditPart.VISUAL_ID:
			return getLocalEntry_3663OutgoingLinks(view);
		case TemplateEditPart.VISUAL_ID:
			return getTemplate_3664OutgoingLinks(view);
		case Sequences2EditPart.VISUAL_ID:
			return getSequences_3665OutgoingLinks(view);
		case EndpointDiagram2EditPart.VISUAL_ID:
			return getEndpointDiagram_3666OutgoingLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3667OutgoingLinks(view);
		case SynapseAPIEditPart.VISUAL_ID:
			return getSynapseAPI_3668OutgoingLinks(view);
		case APIResourceEditPart.VISUAL_ID:
			return getAPIResource_3669OutgoingLinks(view);
		case APIResourceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInputConnector_3670OutgoingLinks(view);
		case APIResourceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutputConnector_3671OutgoingLinks(view);
		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutSequenceOutputConnector_3730OutgoingLinks(view);
		case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceFaultInputConnector_3672OutgoingLinks(view);
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			return getProxyServiceContainer_3673OutgoingLinks(view);
		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInSequenceInputConnector_3747OutgoingLinks(view);
		case ComplexEndpointsEditPart.VISUAL_ID:
			return getComplexEndpoints_3677OutgoingLinks(view);
		case MediatorFlow18EditPart.VISUAL_ID:
			return getMediatorFlow_3678OutgoingLinks(view);
		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
			return getComplexEndpointsOutputConnector_3679OutgoingLinks(view);
		case MessageStoreEditPart.VISUAL_ID:
			return getMessageStore_3715OutgoingLinks(view);
		case MessageProcessorEditPart.VISUAL_ID:
			return getMessageProcessor_3701OutgoingLinks(view);
		case InboundEndpointEditPart.VISUAL_ID:
			return getInboundEndpoint_3767OutgoingLinks(view);
		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceInputConnector_3768OutgoingLinks(view);
		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceOutputConnector_3769OutgoingLinks(view);
		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceInputConnector_3770OutgoingLinks(view);
		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceOutputConnector_3771OutgoingLinks(view);
		case InboundEndpointContainerEditPart.VISUAL_ID:
			return getInboundEndpointContainer_3772OutgoingLinks(view);
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointSequenceContainer_3773OutgoingLinks(view);
		case MediatorFlow25EditPart.VISUAL_ID:
			return getMediatorFlow_3774OutgoingLinks(view);
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceContainer_3775OutgoingLinks(view);
		case MediatorFlow26EditPart.VISUAL_ID:
			return getMediatorFlow_3776OutgoingLinks(view);
		case EsbLinkEditPart.VISUAL_ID:
			return getEsbLink_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEsbDiagram_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEsbServer_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyService_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyOutputConnector_3002ContainedLinks(View view) {
		ProxyOutputConnector modelElement = (ProxyOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyInputConnector_3003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyFaultInputConnector_3489ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyInSequenceInputConnector_3731ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceContainer_3486ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceSequenceAndEndpointContainer_3487ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3608ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDropMediator_3491ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageMediator_3045ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageInputConnector_3046ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageOutputConnector_3047ContainedLinks(View view) {
		MessageOutputConnector modelElement = (MessageOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDropMediatorInputConnector_3008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediator_3492ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorInputConnector_3010ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorOutputConnector_3534ContainedLinks(View view) {
		FilterMediatorOutputConnector modelElement = (FilterMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorPassOutputConnector_3011ContainedLinks(View view) {
		FilterMediatorPassOutputConnector modelElement = (FilterMediatorPassOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorFailOutputConnector_3012ContainedLinks(View view) {
		FilterMediatorFailOutputConnector modelElement = (FilterMediatorFailOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterContainer_3531ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterPassContainer_3535ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3536ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediator_3495ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNode_3013ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeFirstInputConnector_3014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeSecondInputConnector_3015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeOutputConnector_3016ContainedLinks(View view) {
		MergeNodeOutputConnector modelElement = (MergeNodeOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequences_3614ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3615ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequencesInputConnector_3616ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequencesOutputConnector_3617ContainedLinks(View view) {
		SequencesOutputConnector modelElement = (SequencesOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEndpointDiagram_3642ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPoint_3643ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointInputConnector_3644ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointOutputConnector_3645ContainedLinks(View view) {
		DefaultEndPointOutputConnector modelElement = (DefaultEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPoint_3646ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointInputConnector_3647ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointOutputConnector_3648ContainedLinks(View view) {
		AddressEndPointOutputConnector modelElement = (AddressEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPoint_3649ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointInputConnector_3650ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointOutputConnector_3651ContainedLinks(View view) {
		FailoverEndPointOutputConnector modelElement = (FailoverEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointWestOutputConnector_3652ContainedLinks(View view) {
		FailoverEndPointWestOutputConnector modelElement = (FailoverEndPointWestOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3777ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPoint_3696ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointInputConnector_3697ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointOutputConnector_3698ContainedLinks(View view) {
		RecipientListEndPointOutputConnector modelElement = (RecipientListEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointWestOutputConnector_3699ContainedLinks(View view) {
		RecipientListEndPointWestOutputConnector modelElement = (RecipientListEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3778ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPoint_3653ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointInputConnector_3654ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointOutputConnector_3655ContainedLinks(View view) {
		WSDLEndPointOutputConnector modelElement = (WSDLEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPoint_3656ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointInputConnector_3657ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointOutputConnector_3658ContainedLinks(View view) {
		LoadBalanceEndPointOutputConnector modelElement = (LoadBalanceEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointWestOutputConnector_3659ContainedLinks(View view) {
		LoadBalanceEndPointWestOutputConnector modelElement = (LoadBalanceEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3779ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndpoint_3712ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointInputConnector_3713ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointOutputConnector_3714ContainedLinks(View view) {
		HTTPEndPointOutputConnector modelElement = (HTTPEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpoint_3725ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointInputConnector_3726ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointOutputConnector_3727ContainedLinks(View view) {
		TemplateEndpointOutputConnector modelElement = (TemplateEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLocalEntry_3663ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplate_3664ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequences_3665ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEndpointDiagram_3666ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTask_3667ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSynapseAPI_3668ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResource_3669ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceInputConnector_3670ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceOutputConnector_3671ContainedLinks(View view) {
		APIResourceOutputConnector modelElement = (APIResourceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceOutSequenceOutputConnector_3730ContainedLinks(View view) {
		APIResourceOutSequenceOutputConnector modelElement = (APIResourceOutSequenceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceFaultInputConnector_3672ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceContainer_3673ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceInSequenceInputConnector_3747ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getComplexEndpoints_3677ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3678ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getComplexEndpointsOutputConnector_3679ContainedLinks(View view) {
		ComplexEndpointsOutputConnector modelElement = (ComplexEndpointsOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageStore_3715ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageProcessor_3701ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpoint_3767ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceInputConnector_3768ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceOutputConnector_3769ContainedLinks(View view) {
		InboundEndpointSequenceOutputConnector modelElement = (InboundEndpointSequenceOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceInputConnector_3770ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceOutputConnector_3771ContainedLinks(View view) {
		InboundEndpointOnErrorSequenceOutputConnector modelElement = (InboundEndpointOnErrorSequenceOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointContainer_3772ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceContainer_3773ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3774ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceContainer_3775ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3776ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediatorInputConnector_3018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediatorOutputConnector_3019ContainedLinks(View view) {
		LogMediatorOutputConnector modelElement = (LogMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediator_3496ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediatorInputConnector_3033ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediatorOutputConnector_3034ContainedLinks(View view) {
		PropertyMediatorOutputConnector modelElement = (PropertyMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediator_3493ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediatorInputConnector_3036ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediatorOutputConnector_3037ContainedLinks(View view) {
		EnrichMediatorOutputConnector modelElement = (EnrichMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediator_3497ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediatorInputConnector_3039ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediatorOutputConnector_3040ContainedLinks(View view) {
		XSLTMediatorOutputConnector modelElement = (XSLTMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediator_3498ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorInputConnector_3042ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseBranchOutputConnector_3043ContainedLinks(View view) {
		SwitchCaseBranchOutputConnector modelElement = (SwitchCaseBranchOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultBranchOutputConnector_3044ContainedLinks(View view) {
		SwitchDefaultBranchOutputConnector modelElement = (SwitchDefaultBranchOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorOutputConnector_3499ContainedLinks(View view) {
		SwitchMediatorOutputConnector modelElement = (SwitchMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorContainer_3500ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseParentContainer_3732ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseContainer_3733ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3502ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequence_3503ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequenceInputConnector_3049ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequenceOutputConnector_3050ContainedLinks(View view) {
		SequenceOutputConnector modelElement = (SequenceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediator_3504ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediatorInputConnector_3052ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediatorOutputConnector_3053ContainedLinks(View view) {
		EventMediatorOutputConnector modelElement = (EventMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediator_3505ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorInputConnector_3055ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOutputConnector_3056ContainedLinks(View view) {
		EntitlementMediatorOutputConnector modelElement = (EntitlementMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOnRejectOutputConnector_3748ContainedLinks(View view) {
		EntitlementMediatorOnRejectOutputConnector modelElement = (EntitlementMediatorOnRejectOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOnAcceptOutputConnector_3749ContainedLinks(View view) {
		EntitlementMediatorOnAcceptOutputConnector modelElement = (EntitlementMediatorOnAcceptOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorAdviceOutputConnector_3750ContainedLinks(View view) {
		EntitlementMediatorAdviceOutputConnector modelElement = (EntitlementMediatorAdviceOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorObligationsOutputConnector_3751ContainedLinks(View view) {
		EntitlementMediatorObligationsOutputConnector modelElement = (EntitlementMediatorObligationsOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementContainer_3752ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementOnRejectContainer_3753ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3754ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediator_3506ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediatorInputConnector_3058ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediatorOutputConnector_3059ContainedLinks(View view) {
		ClassMediatorOutputConnector modelElement = (ClassMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediator_3507ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediatorInputConnector_3061ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediatorOutputConnector_3062ContainedLinks(View view) {
		SpringMediatorOutputConnector modelElement = (SpringMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediator_3508ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediatorInputConnector_3064ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediatorOutputConnector_3065ContainedLinks(View view) {
		ScriptMediatorOutputConnector modelElement = (ScriptMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediator_3509ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediatorInputConnector_3067ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediatorOutputConnector_3068ContainedLinks(View view) {
		FaultMediatorOutputConnector modelElement = (FaultMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediator_3510ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediatorInputConnector_3070ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediatorOutputConnector_3071ContainedLinks(View view) {
		XQueryMediatorOutputConnector modelElement = (XQueryMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediator_3511ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediatorInputConnector_3073ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediatorOutputConnector_3074ContainedLinks(View view) {
		CommandMediatorOutputConnector modelElement = (CommandMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediator_3512ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediatorInputConnector_3076ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediatorOutputConnector_3077ContainedLinks(View view) {
		DBLookupMediatorOutputConnector modelElement = (DBLookupMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediator_3513ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediatorInputConnector_3079ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediatorOutputConnector_3080ContainedLinks(View view) {
		DBReportMediatorOutputConnector modelElement = (DBReportMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediator_3514ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediatorInputConnector_3082ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediatorOutputConnector_3083ContainedLinks(View view) {
		SmooksMediatorOutputConnector modelElement = (SmooksMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediator_3515ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorInputConnector_3085ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorOutputConnector_3086ContainedLinks(View view) {
		SendMediatorOutputConnector modelElement = (SendMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorEndpointOutputConnector_3539ContainedLinks(View view) {
		SendMediatorEndpointOutputConnector modelElement = (SendMediatorEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3728ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediator_3516ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointInputConnector_3088ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointOutputConnector_3090ContainedLinks(View view) {
		FailoverEndPointOutputConnector modelElement = (FailoverEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointWestOutputConnector_3097ContainedLinks(View view) {
		FailoverEndPointWestOutputConnector modelElement = (FailoverEndPointWestOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPoint_3692ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointInputConnector_3693ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointOutputConnector_3694ContainedLinks(View view) {
		RecipientListEndPointOutputConnector modelElement = (RecipientListEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointWestOutputConnector_3695ContainedLinks(View view) {
		RecipientListEndPointWestOutputConnector modelElement = (RecipientListEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPoint_3612ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointInputConnector_3092ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointOutputConnector_3093ContainedLinks(View view) {
		WSDLEndPointOutputConnector modelElement = (WSDLEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpoint_3660ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpointInputConnector_3661ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpointOutputConnector_3662ContainedLinks(View view) {
		NamedEndpointOutputConnector modelElement = (NamedEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPoint_3613ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointInputConnector_3095ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointOutputConnector_3096ContainedLinks(View view) {
		LoadBalanceEndPointOutputConnector modelElement = (LoadBalanceEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointWestOutputConnector_3098ContainedLinks(View view) {
		LoadBalanceEndPointWestOutputConnector modelElement = (LoadBalanceEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpoint_3674ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpointInputConnector_3675ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpointOutputConnector_3676ContainedLinks(View view) {
		APIResourceEndpointOutputConnector modelElement = (APIResourceEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpoint_3689ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpointInputConnector_3690ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpointOutputConnector_3691ContainedLinks(View view) {
		AddressingEndpointOutputConnector modelElement = (AddressingEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndpoint_3709ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointInputConnector_3710ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointOutputConnector_3711ContainedLinks(View view) {
		HTTPEndPointOutputConnector modelElement = (HTTPEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpoint_3716ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointInputConnector_3717ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointOutputConnector_3718ContainedLinks(View view) {
		TemplateEndpointOutputConnector modelElement = (TemplateEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnector_3719ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorInputConnector_3720ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOutputConnector_3721ContainedLinks(View view) {
		CloudConnectorOutputConnector modelElement = (CloudConnectorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperation_3722ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperationInputConnector_3723ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperationOutputConnector_3724ContainedLinks(View view) {
		CloudConnectorOperationOutputConnector modelElement = (CloudConnectorOperationOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediator_3736ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediatorInputConnector_3737ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediatorOutputConnector_3738ContainedLinks(View view) {
		LoopBackMediatorOutputConnector modelElement = (LoopBackMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediator_3739ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediatorInputConnector_3740ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediatorOutputConnector_3741ContainedLinks(View view) {
		RespondMediatorOutputConnector modelElement = (RespondMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediator_3742ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorInputConnector_3743ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorOutputConnector_3744ContainedLinks(View view) {
		CallMediatorOutputConnector modelElement = (CallMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorEndpointOutputConnector_3745ContainedLinks(View view) {
		CallMediatorEndpointOutputConnector modelElement = (CallMediatorEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3746ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediator_3761ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediatorInputConnector_3762ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediatorOutputConnector_3763ContainedLinks(View view) {
		DataMapperMediatorOutputConnector modelElement = (DataMapperMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediator_3764ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediatorInputConnector_3765ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediatorOutputConnector_3766ContainedLinks(View view) {
		FastXSLTMediatorOutputConnector modelElement = (FastXSLTMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediator_3780ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorInputConnector_3781ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorOutputConnector_3782ContainedLinks(View view) {
		ForEachMediatorOutputConnector modelElement = (ForEachMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorTargetOutputConnector_3783ContainedLinks(View view) {
		ForEachMediatorTargetOutputConnector modelElement = (ForEachMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3784ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediator_3785ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediatorInputConnector_3786ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediatorOutputConnector_3787ContainedLinks(View view) {
		PublishEventMediatorOutputConnector modelElement = (PublishEventMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementOnAcceptContainer_3755ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3756ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementAdviceContainer_3757ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3758ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementObligationsContainer_3759ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3760ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultParentContainer_3734ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultContainer_3735ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceFaultContainer_3488ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3530ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyOutSequenceOutputConnector_3729ContainedLinks(View view) {
		ProxyOutSequenceOutputConnector modelElement = (ProxyOutSequenceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediatorInputConnector_3100ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediatorOutputConnector_3101ContainedLinks(View view) {
		HeaderMediatorOutputConnector modelElement = (HeaderMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediator_3517ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorInputConnector_3103ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorOutputConnector_3104ContainedLinks(View view) {
		CloneMediatorOutputConnector modelElement = (CloneMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorTargetOutputConnector_3133ContainedLinks(View view) {
		CloneMediatorTargetOutputConnector modelElement = (CloneMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorContainer_3603ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneTargetContainer_3604ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3605ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediator_3518ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorInputConnector_3106ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorOutputConnector_3107ContainedLinks(View view) {
		CacheMediatorOutputConnector modelElement = (CacheMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorOnHitOutputConnector_3618ContainedLinks(View view) {
		CacheMediatorOnHitOutputConnector modelElement = (CacheMediatorOnHitOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3619ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediator_3519ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorInputConnector_3109ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorOutputConnector_3110ContainedLinks(View view) {
		IterateMediatorOutputConnector modelElement = (IterateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorTargetOutputConnector_3606ContainedLinks(View view) {
		IterateMediatorTargetOutputConnector modelElement = (IterateMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3607ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediator_3520ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorInputConnector_3112ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorOutputConnector_3113ContainedLinks(View view) {
		AggregateMediatorOutputConnector modelElement = (AggregateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorOnCompleteOutputConnector_3132ContainedLinks(View view) {
		AggregateMediatorOnCompleteOutputConnector modelElement = (AggregateMediatorOnCompleteOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3526ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediator_3588ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediatorInputConnector_3589ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediatorOutputConnector_3590ContainedLinks(View view) {
		StoreMediatorOutputConnector modelElement = (StoreMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediator_3591ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediatorInputConnector_3592ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediatorOutputConector_3593ContainedLinks(View view) {
		BuilderMediatorOutputConector modelElement = (BuilderMediatorOutputConector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediator_3594ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediatorInputConnector_3595ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediatorOutputConnector_3596ContainedLinks(View view) {
		CallTemplateMediatorOutputConnector modelElement = (CallTemplateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediator_3597ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediatorInputConnector_3598ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediatorOutputConnector_3599ContainedLinks(View view) {
		PayloadFactoryMediatorOutputConnector modelElement = (PayloadFactoryMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediator_3600ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediatorInputConnector_3601ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediatorOutputConnector_3602ContainedLinks(View view) {
		EnqueueMediatorOutputConnector modelElement = (EnqueueMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediator_3620ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediatorInputConnector_3621ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediatorOutputConnector_3622ContainedLinks(View view) {
		URLRewriteMediatorOutputConnector modelElement = (URLRewriteMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediator_3623ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorInputConnector_3624ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorOutputConnector_3625ContainedLinks(View view) {
		ValidateMediatorOutputConnector modelElement = (ValidateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorOnFailOutputConnector_3626ContainedLinks(View view) {
		ValidateMediatorOnFailOutputConnector modelElement = (ValidateMediatorOnFailOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3627ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediator_3628ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorInputConnector_3629ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorOutputConnector_3630ContainedLinks(View view) {
		RouterMediatorOutputConnector modelElement = (RouterMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorTargetOutputConnector_3631ContainedLinks(View view) {
		RouterMediatorTargetOutputConnector modelElement = (RouterMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorContainer_3632ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterTargetContainer_3633ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3634ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediator_3635ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorInputConnector_3636ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorOutputConnector_3637ContainedLinks(View view) {
		ConditionalRouterMediatorOutputConnector modelElement = (ConditionalRouterMediatorOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorAdditionalOutputConnector_3638ContainedLinks(
			View view) {
		ConditionalRouterMediatorAdditionalOutputConnector modelElement = (ConditionalRouterMediatorAdditionalOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3639ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediator_3680ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediatorInputConnector_3681ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediatorOutputConnector_3682ContainedLinks(View view) {
		BAMMediatorOutputConnector modelElement = (BAMMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediator_3683ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediatorInputConnector_3684ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediatorOutputConnector_3685ContainedLinks(View view) {
		BeanMediatorOutputConnector modelElement = (BeanMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediator_3686ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediatorInputConnector_3687ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediatorOutputConnector_3688ContainedLinks(View view) {
		EJBMediatorOutputConnector modelElement = (EJBMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPoint_3609ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3528ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterFailContainer_3537ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3538ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleOnRejectContainer_3586ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3587ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediatorInputConnector_3115ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediatorOutputConnector_3116ContainedLinks(View view) {
		CalloutMediatorOutputConnector modelElement = (CalloutMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediator_3521ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediatorInputConnector_3118ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediatorOutputConnector_3119ContainedLinks(View view) {
		TransactionMediatorOutputConnector modelElement = (TransactionMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediator_3522ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorInputConnector_3121ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOutputConnector_3122ContainedLinks(View view) {
		ThrottleMediatorOutputConnector modelElement = (ThrottleMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOnAcceptOutputConnector_3581ContainedLinks(View view) {
		ThrottleMediatorOnAcceptOutputConnector modelElement = (ThrottleMediatorOnAcceptOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOnRejectOutputConnector_3582ContainedLinks(View view) {
		ThrottleMediatorOnRejectOutputConnector modelElement = (ThrottleMediatorOnRejectOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleContainer_3583ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleOnAcceptContainer_3584ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3585ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediator_3494ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediatorInputConnector_3124ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediatorOutputConnector_3125ContainedLinks(View view) {
		RMSequenceMediatorOutputConnector modelElement = (RMSequenceMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediator_3523ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorInputConnector_3127ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorOutputConnector_3128ContainedLinks(View view) {
		RuleMediatorOutputConnector modelElement = (RuleMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorChildMediatorsOutputConnector_3640ContainedLinks(View view) {
		RuleMediatorChildMediatorsOutputConnector modelElement = (RuleMediatorChildMediatorsOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3641ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediator_3524ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediatorInputConnector_3130ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediatorOutputConnector_3131ContainedLinks(View view) {
		OAuthMediatorOutputConnector modelElement = (OAuthMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediator_3525ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointInputConnector_3021ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointOutputConnector_3022ContainedLinks(View view) {
		DefaultEndPointOutputConnector modelElement = (DefaultEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPoint_3610ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointInputConnector_3030ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointOutputConnector_3031ContainedLinks(View view) {
		AddressEndPointOutputConnector modelElement = (AddressEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPoint_3611ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEsbLink_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEsbServer_2001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyService_3001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyOutputConnector_3002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyInputConnector_3003IncomingLinks(View view) {
		ProxyInputConnector modelElement = (ProxyInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyFaultInputConnector_3489IncomingLinks(View view) {
		ProxyFaultInputConnector modelElement = (ProxyFaultInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyInSequenceInputConnector_3731IncomingLinks(View view) {
		ProxyInSequenceInputConnector modelElement = (ProxyInSequenceInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceContainer_3486IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceSequenceAndEndpointContainer_3487IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3608IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDropMediator_3491IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageMediator_3045IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageInputConnector_3046IncomingLinks(View view) {
		MessageInputConnector modelElement = (MessageInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageOutputConnector_3047IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDropMediatorInputConnector_3008IncomingLinks(View view) {
		DropMediatorInputConnector modelElement = (DropMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediator_3492IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorInputConnector_3010IncomingLinks(View view) {
		FilterMediatorInputConnector modelElement = (FilterMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorOutputConnector_3534IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorPassOutputConnector_3011IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorFailOutputConnector_3012IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterContainer_3531IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterPassContainer_3535IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3536IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediator_3495IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNode_3013IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeFirstInputConnector_3014IncomingLinks(View view) {
		MergeNodeFirstInputConnector modelElement = (MergeNodeFirstInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeSecondInputConnector_3015IncomingLinks(View view) {
		MergeNodeSecondInputConnector modelElement = (MergeNodeSecondInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeOutputConnector_3016IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequences_3614IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3615IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequencesInputConnector_3616IncomingLinks(View view) {
		SequencesInputConnector modelElement = (SequencesInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequencesOutputConnector_3617IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEndpointDiagram_3642IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPoint_3643IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointInputConnector_3644IncomingLinks(View view) {
		DefaultEndPointInputConnector modelElement = (DefaultEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointOutputConnector_3645IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPoint_3646IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointInputConnector_3647IncomingLinks(View view) {
		AddressEndPointInputConnector modelElement = (AddressEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointOutputConnector_3648IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPoint_3649IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointInputConnector_3650IncomingLinks(View view) {
		FailoverEndPointInputConnector modelElement = (FailoverEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointOutputConnector_3651IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointWestOutputConnector_3652IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3777IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPoint_3696IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointInputConnector_3697IncomingLinks(View view) {
		RecipientListEndPointInputConnector modelElement = (RecipientListEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointOutputConnector_3698IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointWestOutputConnector_3699IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3778IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPoint_3653IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointInputConnector_3654IncomingLinks(View view) {
		WSDLEndPointInputConnector modelElement = (WSDLEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointOutputConnector_3655IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPoint_3656IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointInputConnector_3657IncomingLinks(View view) {
		LoadBalanceEndPointInputConnector modelElement = (LoadBalanceEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointOutputConnector_3658IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointWestOutputConnector_3659IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3779IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndpoint_3712IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointInputConnector_3713IncomingLinks(View view) {
		HTTPEndPointInputConnector modelElement = (HTTPEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointOutputConnector_3714IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpoint_3725IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointInputConnector_3726IncomingLinks(View view) {
		TemplateEndpointInputConnector modelElement = (TemplateEndpointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointOutputConnector_3727IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLocalEntry_3663IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplate_3664IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequences_3665IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEndpointDiagram_3666IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTask_3667IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSynapseAPI_3668IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResource_3669IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceInputConnector_3670IncomingLinks(View view) {
		APIResourceInputConnector modelElement = (APIResourceInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceOutputConnector_3671IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceOutSequenceOutputConnector_3730IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceFaultInputConnector_3672IncomingLinks(View view) {
		APIResourceFaultInputConnector modelElement = (APIResourceFaultInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceContainer_3673IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceInSequenceInputConnector_3747IncomingLinks(View view) {
		APIResourceInSequenceInputConnector modelElement = (APIResourceInSequenceInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getComplexEndpoints_3677IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3678IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getComplexEndpointsOutputConnector_3679IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageStore_3715IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageProcessor_3701IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpoint_3767IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceInputConnector_3768IncomingLinks(View view) {
		InboundEndpointSequenceInputConnector modelElement = (InboundEndpointSequenceInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceOutputConnector_3769IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceInputConnector_3770IncomingLinks(View view) {
		InboundEndpointOnErrorSequenceInputConnector modelElement = (InboundEndpointOnErrorSequenceInputConnector) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceOutputConnector_3771IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointContainer_3772IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceContainer_3773IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3774IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceContainer_3775IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3776IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediatorInputConnector_3018IncomingLinks(View view) {
		LogMediatorInputConnector modelElement = (LogMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediatorOutputConnector_3019IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediator_3496IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediatorInputConnector_3033IncomingLinks(View view) {
		PropertyMediatorInputConnector modelElement = (PropertyMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediatorOutputConnector_3034IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediator_3493IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediatorInputConnector_3036IncomingLinks(View view) {
		EnrichMediatorInputConnector modelElement = (EnrichMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediatorOutputConnector_3037IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediator_3497IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediatorInputConnector_3039IncomingLinks(View view) {
		XSLTMediatorInputConnector modelElement = (XSLTMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediatorOutputConnector_3040IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediator_3498IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorInputConnector_3042IncomingLinks(View view) {
		SwitchMediatorInputConnector modelElement = (SwitchMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseBranchOutputConnector_3043IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultBranchOutputConnector_3044IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorOutputConnector_3499IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorContainer_3500IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseParentContainer_3732IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseContainer_3733IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3502IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequence_3503IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequenceInputConnector_3049IncomingLinks(View view) {
		SequenceInputConnector modelElement = (SequenceInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequenceOutputConnector_3050IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediator_3504IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediatorInputConnector_3052IncomingLinks(View view) {
		EventMediatorInputConnector modelElement = (EventMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediatorOutputConnector_3053IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediator_3505IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorInputConnector_3055IncomingLinks(View view) {
		EntitlementMediatorInputConnector modelElement = (EntitlementMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOutputConnector_3056IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOnRejectOutputConnector_3748IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOnAcceptOutputConnector_3749IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorAdviceOutputConnector_3750IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorObligationsOutputConnector_3751IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementContainer_3752IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementOnRejectContainer_3753IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3754IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediator_3506IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediatorInputConnector_3058IncomingLinks(View view) {
		ClassMediatorInputConnector modelElement = (ClassMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediatorOutputConnector_3059IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediator_3507IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediatorInputConnector_3061IncomingLinks(View view) {
		SpringMediatorInputConnector modelElement = (SpringMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediatorOutputConnector_3062IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediator_3508IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediatorInputConnector_3064IncomingLinks(View view) {
		ScriptMediatorInputConnector modelElement = (ScriptMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediatorOutputConnector_3065IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediator_3509IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediatorInputConnector_3067IncomingLinks(View view) {
		FaultMediatorInputConnector modelElement = (FaultMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediatorOutputConnector_3068IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediator_3510IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediatorInputConnector_3070IncomingLinks(View view) {
		XQueryMediatorInputConnector modelElement = (XQueryMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediatorOutputConnector_3071IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediator_3511IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediatorInputConnector_3073IncomingLinks(View view) {
		CommandMediatorInputConnector modelElement = (CommandMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediatorOutputConnector_3074IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediator_3512IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediatorInputConnector_3076IncomingLinks(View view) {
		DBLookupMediatorInputConnector modelElement = (DBLookupMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediatorOutputConnector_3077IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediator_3513IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediatorInputConnector_3079IncomingLinks(View view) {
		DBReportMediatorInputConnector modelElement = (DBReportMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediatorOutputConnector_3080IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediator_3514IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediatorInputConnector_3082IncomingLinks(View view) {
		SmooksMediatorInputConnector modelElement = (SmooksMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediatorOutputConnector_3083IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediator_3515IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorInputConnector_3085IncomingLinks(View view) {
		SendMediatorInputConnector modelElement = (SendMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorOutputConnector_3086IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorEndpointOutputConnector_3539IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3728IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediator_3516IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointInputConnector_3088IncomingLinks(View view) {
		FailoverEndPointInputConnector modelElement = (FailoverEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointOutputConnector_3090IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointWestOutputConnector_3097IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPoint_3692IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointInputConnector_3693IncomingLinks(View view) {
		RecipientListEndPointInputConnector modelElement = (RecipientListEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointOutputConnector_3694IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointWestOutputConnector_3695IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPoint_3612IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointInputConnector_3092IncomingLinks(View view) {
		WSDLEndPointInputConnector modelElement = (WSDLEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointOutputConnector_3093IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpoint_3660IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpointInputConnector_3661IncomingLinks(View view) {
		NamedEndpointInputConnector modelElement = (NamedEndpointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpointOutputConnector_3662IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPoint_3613IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointInputConnector_3095IncomingLinks(View view) {
		LoadBalanceEndPointInputConnector modelElement = (LoadBalanceEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointOutputConnector_3096IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointWestOutputConnector_3098IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpoint_3674IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpointInputConnector_3675IncomingLinks(View view) {
		APIResourceEndpointInputConnector modelElement = (APIResourceEndpointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpointOutputConnector_3676IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpoint_3689IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpointInputConnector_3690IncomingLinks(View view) {
		AddressingEndpointInputConnector modelElement = (AddressingEndpointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpointOutputConnector_3691IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndpoint_3709IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointInputConnector_3710IncomingLinks(View view) {
		HTTPEndPointInputConnector modelElement = (HTTPEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointOutputConnector_3711IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpoint_3716IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointInputConnector_3717IncomingLinks(View view) {
		TemplateEndpointInputConnector modelElement = (TemplateEndpointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointOutputConnector_3718IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnector_3719IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorInputConnector_3720IncomingLinks(View view) {
		CloudConnectorInputConnector modelElement = (CloudConnectorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOutputConnector_3721IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperation_3722IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperationInputConnector_3723IncomingLinks(View view) {
		CloudConnectorOperationInputConnector modelElement = (CloudConnectorOperationInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperationOutputConnector_3724IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediator_3736IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediatorInputConnector_3737IncomingLinks(View view) {
		LoopBackMediatorInputConnector modelElement = (LoopBackMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediatorOutputConnector_3738IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediator_3739IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediatorInputConnector_3740IncomingLinks(View view) {
		RespondMediatorInputConnector modelElement = (RespondMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediatorOutputConnector_3741IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediator_3742IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorInputConnector_3743IncomingLinks(View view) {
		CallMediatorInputConnector modelElement = (CallMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorOutputConnector_3744IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorEndpointOutputConnector_3745IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3746IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediator_3761IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediatorInputConnector_3762IncomingLinks(View view) {
		DataMapperMediatorInputConnector modelElement = (DataMapperMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediatorOutputConnector_3763IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediator_3764IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediatorInputConnector_3765IncomingLinks(View view) {
		FastXSLTMediatorInputConnector modelElement = (FastXSLTMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediatorOutputConnector_3766IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediator_3780IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorInputConnector_3781IncomingLinks(View view) {
		ForEachMediatorInputConnector modelElement = (ForEachMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorOutputConnector_3782IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorTargetOutputConnector_3783IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3784IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediator_3785IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediatorInputConnector_3786IncomingLinks(View view) {
		PublishEventMediatorInputConnector modelElement = (PublishEventMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediatorOutputConnector_3787IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementOnAcceptContainer_3755IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3756IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementAdviceContainer_3757IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3758IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementObligationsContainer_3759IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3760IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultParentContainer_3734IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultContainer_3735IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceFaultContainer_3488IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3530IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyOutSequenceOutputConnector_3729IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediatorInputConnector_3100IncomingLinks(View view) {
		HeaderMediatorInputConnector modelElement = (HeaderMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediatorOutputConnector_3101IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediator_3517IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorInputConnector_3103IncomingLinks(View view) {
		CloneMediatorInputConnector modelElement = (CloneMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorOutputConnector_3104IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorTargetOutputConnector_3133IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorContainer_3603IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneTargetContainer_3604IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3605IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediator_3518IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorInputConnector_3106IncomingLinks(View view) {
		CacheMediatorInputConnector modelElement = (CacheMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorOutputConnector_3107IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorOnHitOutputConnector_3618IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3619IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediator_3519IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorInputConnector_3109IncomingLinks(View view) {
		IterateMediatorInputConnector modelElement = (IterateMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorOutputConnector_3110IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorTargetOutputConnector_3606IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3607IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediator_3520IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorInputConnector_3112IncomingLinks(View view) {
		AggregateMediatorInputConnector modelElement = (AggregateMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorOutputConnector_3113IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorOnCompleteOutputConnector_3132IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3526IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediator_3588IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediatorInputConnector_3589IncomingLinks(View view) {
		StoreMediatorInputConnector modelElement = (StoreMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediatorOutputConnector_3590IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediator_3591IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediatorInputConnector_3592IncomingLinks(View view) {
		BuilderMediatorInputConnector modelElement = (BuilderMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediatorOutputConector_3593IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediator_3594IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediatorInputConnector_3595IncomingLinks(View view) {
		CallTemplateMediatorInputConnector modelElement = (CallTemplateMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediatorOutputConnector_3596IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediator_3597IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediatorInputConnector_3598IncomingLinks(View view) {
		PayloadFactoryMediatorInputConnector modelElement = (PayloadFactoryMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediatorOutputConnector_3599IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediator_3600IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediatorInputConnector_3601IncomingLinks(View view) {
		EnqueueMediatorInputConnector modelElement = (EnqueueMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediatorOutputConnector_3602IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediator_3620IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediatorInputConnector_3621IncomingLinks(View view) {
		URLRewriteMediatorInputConnector modelElement = (URLRewriteMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediatorOutputConnector_3622IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediator_3623IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorInputConnector_3624IncomingLinks(View view) {
		ValidateMediatorInputConnector modelElement = (ValidateMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorOutputConnector_3625IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorOnFailOutputConnector_3626IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3627IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediator_3628IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorInputConnector_3629IncomingLinks(View view) {
		RouterMediatorInputConnector modelElement = (RouterMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorOutputConnector_3630IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorTargetOutputConnector_3631IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorContainer_3632IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterTargetContainer_3633IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3634IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediator_3635IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorInputConnector_3636IncomingLinks(View view) {
		ConditionalRouterMediatorInputConnector modelElement = (ConditionalRouterMediatorInputConnector) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorOutputConnector_3637IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorAdditionalOutputConnector_3638IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3639IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediator_3680IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediatorInputConnector_3681IncomingLinks(View view) {
		BAMMediatorInputConnector modelElement = (BAMMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediatorOutputConnector_3682IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediator_3683IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediatorInputConnector_3684IncomingLinks(View view) {
		BeanMediatorInputConnector modelElement = (BeanMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediatorOutputConnector_3685IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediator_3686IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediatorInputConnector_3687IncomingLinks(View view) {
		EJBMediatorInputConnector modelElement = (EJBMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediatorOutputConnector_3688IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPoint_3609IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3528IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterFailContainer_3537IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3538IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleOnRejectContainer_3586IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3587IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediatorInputConnector_3115IncomingLinks(View view) {
		CalloutMediatorInputConnector modelElement = (CalloutMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediatorOutputConnector_3116IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediator_3521IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediatorInputConnector_3118IncomingLinks(View view) {
		TransactionMediatorInputConnector modelElement = (TransactionMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediatorOutputConnector_3119IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediator_3522IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorInputConnector_3121IncomingLinks(View view) {
		ThrottleMediatorInputConnector modelElement = (ThrottleMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOutputConnector_3122IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOnAcceptOutputConnector_3581IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOnRejectOutputConnector_3582IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleContainer_3583IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleOnAcceptContainer_3584IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3585IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediator_3494IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediatorInputConnector_3124IncomingLinks(View view) {
		RMSequenceMediatorInputConnector modelElement = (RMSequenceMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediatorOutputConnector_3125IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediator_3523IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorInputConnector_3127IncomingLinks(View view) {
		RuleMediatorInputConnector modelElement = (RuleMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorOutputConnector_3128IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorChildMediatorsOutputConnector_3640IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3641IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediator_3524IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediatorInputConnector_3130IncomingLinks(View view) {
		OAuthMediatorInputConnector modelElement = (OAuthMediatorInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediatorOutputConnector_3131IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediator_3525IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointInputConnector_3021IncomingLinks(View view) {
		DefaultEndPointInputConnector modelElement = (DefaultEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointOutputConnector_3022IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPoint_3610IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointInputConnector_3030IncomingLinks(View view) {
		AddressEndPointInputConnector modelElement = (AddressEndPointInputConnector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_EsbLink_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointOutputConnector_3031IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPoint_3611IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEsbLink_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEsbServer_2001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyService_3001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyOutputConnector_3002OutgoingLinks(View view) {
		ProxyOutputConnector modelElement = (ProxyOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyInputConnector_3003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyFaultInputConnector_3489OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyInSequenceInputConnector_3731OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceContainer_3486OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceSequenceAndEndpointContainer_3487OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3608OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDropMediator_3491OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageMediator_3045OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageInputConnector_3046OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageOutputConnector_3047OutgoingLinks(View view) {
		MessageOutputConnector modelElement = (MessageOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDropMediatorInputConnector_3008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediator_3492OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorInputConnector_3010OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorOutputConnector_3534OutgoingLinks(View view) {
		FilterMediatorOutputConnector modelElement = (FilterMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorPassOutputConnector_3011OutgoingLinks(View view) {
		FilterMediatorPassOutputConnector modelElement = (FilterMediatorPassOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediatorFailOutputConnector_3012OutgoingLinks(View view) {
		FilterMediatorFailOutputConnector modelElement = (FilterMediatorFailOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterContainer_3531OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterPassContainer_3535OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3536OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediator_3495OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNode_3013OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeFirstInputConnector_3014OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeSecondInputConnector_3015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMergeNodeOutputConnector_3016OutgoingLinks(View view) {
		MergeNodeOutputConnector modelElement = (MergeNodeOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequences_3614OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3615OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequencesInputConnector_3616OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequencesOutputConnector_3617OutgoingLinks(View view) {
		SequencesOutputConnector modelElement = (SequencesOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEndpointDiagram_3642OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPoint_3643OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointInputConnector_3644OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointOutputConnector_3645OutgoingLinks(View view) {
		DefaultEndPointOutputConnector modelElement = (DefaultEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPoint_3646OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointInputConnector_3647OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointOutputConnector_3648OutgoingLinks(View view) {
		AddressEndPointOutputConnector modelElement = (AddressEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPoint_3649OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointInputConnector_3650OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointOutputConnector_3651OutgoingLinks(View view) {
		FailoverEndPointOutputConnector modelElement = (FailoverEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointWestOutputConnector_3652OutgoingLinks(View view) {
		FailoverEndPointWestOutputConnector modelElement = (FailoverEndPointWestOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3777OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPoint_3696OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointInputConnector_3697OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointOutputConnector_3698OutgoingLinks(View view) {
		RecipientListEndPointOutputConnector modelElement = (RecipientListEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointWestOutputConnector_3699OutgoingLinks(View view) {
		RecipientListEndPointWestOutputConnector modelElement = (RecipientListEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3778OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPoint_3653OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointInputConnector_3654OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointOutputConnector_3655OutgoingLinks(View view) {
		WSDLEndPointOutputConnector modelElement = (WSDLEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPoint_3656OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointInputConnector_3657OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointOutputConnector_3658OutgoingLinks(View view) {
		LoadBalanceEndPointOutputConnector modelElement = (LoadBalanceEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointWestOutputConnector_3659OutgoingLinks(View view) {
		LoadBalanceEndPointWestOutputConnector modelElement = (LoadBalanceEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3779OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndpoint_3712OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointInputConnector_3713OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointOutputConnector_3714OutgoingLinks(View view) {
		HTTPEndPointOutputConnector modelElement = (HTTPEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpoint_3725OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointInputConnector_3726OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointOutputConnector_3727OutgoingLinks(View view) {
		TemplateEndpointOutputConnector modelElement = (TemplateEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLocalEntry_3663OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplate_3664OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequences_3665OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEndpointDiagram_3666OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTask_3667OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSynapseAPI_3668OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResource_3669OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceInputConnector_3670OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceOutputConnector_3671OutgoingLinks(View view) {
		APIResourceOutputConnector modelElement = (APIResourceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceOutSequenceOutputConnector_3730OutgoingLinks(View view) {
		APIResourceOutSequenceOutputConnector modelElement = (APIResourceOutSequenceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceFaultInputConnector_3672OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceContainer_3673OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceInSequenceInputConnector_3747OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getComplexEndpoints_3677OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3678OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getComplexEndpointsOutputConnector_3679OutgoingLinks(View view) {
		ComplexEndpointsOutputConnector modelElement = (ComplexEndpointsOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageStore_3715OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMessageProcessor_3701OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpoint_3767OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceInputConnector_3768OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceOutputConnector_3769OutgoingLinks(View view) {
		InboundEndpointSequenceOutputConnector modelElement = (InboundEndpointSequenceOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceInputConnector_3770OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceOutputConnector_3771OutgoingLinks(View view) {
		InboundEndpointOnErrorSequenceOutputConnector modelElement = (InboundEndpointOnErrorSequenceOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointContainer_3772OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointSequenceContainer_3773OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3774OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getInboundEndpointOnErrorSequenceContainer_3775OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3776OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediatorInputConnector_3018OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLogMediatorOutputConnector_3019OutgoingLinks(View view) {
		LogMediatorOutputConnector modelElement = (LogMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediator_3496OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediatorInputConnector_3033OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPropertyMediatorOutputConnector_3034OutgoingLinks(View view) {
		PropertyMediatorOutputConnector modelElement = (PropertyMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediator_3493OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediatorInputConnector_3036OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnrichMediatorOutputConnector_3037OutgoingLinks(View view) {
		EnrichMediatorOutputConnector modelElement = (EnrichMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediator_3497OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediatorInputConnector_3039OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXSLTMediatorOutputConnector_3040OutgoingLinks(View view) {
		XSLTMediatorOutputConnector modelElement = (XSLTMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediator_3498OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorInputConnector_3042OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseBranchOutputConnector_3043OutgoingLinks(View view) {
		SwitchCaseBranchOutputConnector modelElement = (SwitchCaseBranchOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultBranchOutputConnector_3044OutgoingLinks(View view) {
		SwitchDefaultBranchOutputConnector modelElement = (SwitchDefaultBranchOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorOutputConnector_3499OutgoingLinks(View view) {
		SwitchMediatorOutputConnector modelElement = (SwitchMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchMediatorContainer_3500OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseParentContainer_3732OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchCaseContainer_3733OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3502OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequence_3503OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequenceInputConnector_3049OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSequenceOutputConnector_3050OutgoingLinks(View view) {
		SequenceOutputConnector modelElement = (SequenceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediator_3504OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediatorInputConnector_3052OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEventMediatorOutputConnector_3053OutgoingLinks(View view) {
		EventMediatorOutputConnector modelElement = (EventMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediator_3505OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorInputConnector_3055OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOutputConnector_3056OutgoingLinks(View view) {
		EntitlementMediatorOutputConnector modelElement = (EntitlementMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOnRejectOutputConnector_3748OutgoingLinks(View view) {
		EntitlementMediatorOnRejectOutputConnector modelElement = (EntitlementMediatorOnRejectOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorOnAcceptOutputConnector_3749OutgoingLinks(View view) {
		EntitlementMediatorOnAcceptOutputConnector modelElement = (EntitlementMediatorOnAcceptOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorAdviceOutputConnector_3750OutgoingLinks(View view) {
		EntitlementMediatorAdviceOutputConnector modelElement = (EntitlementMediatorAdviceOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementMediatorObligationsOutputConnector_3751OutgoingLinks(View view) {
		EntitlementMediatorObligationsOutputConnector modelElement = (EntitlementMediatorObligationsOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementContainer_3752OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementOnRejectContainer_3753OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3754OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediator_3506OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediatorInputConnector_3058OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getClassMediatorOutputConnector_3059OutgoingLinks(View view) {
		ClassMediatorOutputConnector modelElement = (ClassMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediator_3507OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediatorInputConnector_3061OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSpringMediatorOutputConnector_3062OutgoingLinks(View view) {
		SpringMediatorOutputConnector modelElement = (SpringMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediator_3508OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediatorInputConnector_3064OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getScriptMediatorOutputConnector_3065OutgoingLinks(View view) {
		ScriptMediatorOutputConnector modelElement = (ScriptMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediator_3509OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediatorInputConnector_3067OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFaultMediatorOutputConnector_3068OutgoingLinks(View view) {
		FaultMediatorOutputConnector modelElement = (FaultMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediator_3510OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediatorInputConnector_3070OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getXQueryMediatorOutputConnector_3071OutgoingLinks(View view) {
		XQueryMediatorOutputConnector modelElement = (XQueryMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediator_3511OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediatorInputConnector_3073OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCommandMediatorOutputConnector_3074OutgoingLinks(View view) {
		CommandMediatorOutputConnector modelElement = (CommandMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediator_3512OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediatorInputConnector_3076OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBLookupMediatorOutputConnector_3077OutgoingLinks(View view) {
		DBLookupMediatorOutputConnector modelElement = (DBLookupMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediator_3513OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediatorInputConnector_3079OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDBReportMediatorOutputConnector_3080OutgoingLinks(View view) {
		DBReportMediatorOutputConnector modelElement = (DBReportMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediator_3514OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediatorInputConnector_3082OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSmooksMediatorOutputConnector_3083OutgoingLinks(View view) {
		SmooksMediatorOutputConnector modelElement = (SmooksMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediator_3515OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorInputConnector_3085OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorOutputConnector_3086OutgoingLinks(View view) {
		SendMediatorOutputConnector modelElement = (SendMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSendMediatorEndpointOutputConnector_3539OutgoingLinks(View view) {
		SendMediatorEndpointOutputConnector modelElement = (SendMediatorEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3728OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediator_3516OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointInputConnector_3088OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointOutputConnector_3090OutgoingLinks(View view) {
		FailoverEndPointOutputConnector modelElement = (FailoverEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPointWestOutputConnector_3097OutgoingLinks(View view) {
		FailoverEndPointWestOutputConnector modelElement = (FailoverEndPointWestOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPoint_3692OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointInputConnector_3693OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointOutputConnector_3694OutgoingLinks(View view) {
		RecipientListEndPointOutputConnector modelElement = (RecipientListEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRecipientListEndPointWestOutputConnector_3695OutgoingLinks(View view) {
		RecipientListEndPointWestOutputConnector modelElement = (RecipientListEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPoint_3612OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointInputConnector_3092OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getWSDLEndPointOutputConnector_3093OutgoingLinks(View view) {
		WSDLEndPointOutputConnector modelElement = (WSDLEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpoint_3660OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpointInputConnector_3661OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getNamedEndpointOutputConnector_3662OutgoingLinks(View view) {
		NamedEndpointOutputConnector modelElement = (NamedEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPoint_3613OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointInputConnector_3095OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointOutputConnector_3096OutgoingLinks(View view) {
		LoadBalanceEndPointOutputConnector modelElement = (LoadBalanceEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoadBalanceEndPointWestOutputConnector_3098OutgoingLinks(View view) {
		LoadBalanceEndPointWestOutputConnector modelElement = (LoadBalanceEndPointWestOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpoint_3674OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpointInputConnector_3675OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAPIResourceEndpointOutputConnector_3676OutgoingLinks(View view) {
		APIResourceEndpointOutputConnector modelElement = (APIResourceEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpoint_3689OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpointInputConnector_3690OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressingEndpointOutputConnector_3691OutgoingLinks(View view) {
		AddressingEndpointOutputConnector modelElement = (AddressingEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndpoint_3709OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointInputConnector_3710OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHTTPEndPointOutputConnector_3711OutgoingLinks(View view) {
		HTTPEndPointOutputConnector modelElement = (HTTPEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpoint_3716OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointInputConnector_3717OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTemplateEndpointOutputConnector_3718OutgoingLinks(View view) {
		TemplateEndpointOutputConnector modelElement = (TemplateEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnector_3719OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorInputConnector_3720OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOutputConnector_3721OutgoingLinks(View view) {
		CloudConnectorOutputConnector modelElement = (CloudConnectorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperation_3722OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperationInputConnector_3723OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloudConnectorOperationOutputConnector_3724OutgoingLinks(View view) {
		CloudConnectorOperationOutputConnector modelElement = (CloudConnectorOperationOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediator_3736OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediatorInputConnector_3737OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getLoopBackMediatorOutputConnector_3738OutgoingLinks(View view) {
		LoopBackMediatorOutputConnector modelElement = (LoopBackMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediator_3739OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediatorInputConnector_3740OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRespondMediatorOutputConnector_3741OutgoingLinks(View view) {
		RespondMediatorOutputConnector modelElement = (RespondMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediator_3742OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorInputConnector_3743OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorOutputConnector_3744OutgoingLinks(View view) {
		CallMediatorOutputConnector modelElement = (CallMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallMediatorEndpointOutputConnector_3745OutgoingLinks(View view) {
		CallMediatorEndpointOutputConnector modelElement = (CallMediatorEndpointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3746OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediator_3761OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediatorInputConnector_3762OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDataMapperMediatorOutputConnector_3763OutgoingLinks(View view) {
		DataMapperMediatorOutputConnector modelElement = (DataMapperMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediator_3764OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediatorInputConnector_3765OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFastXSLTMediatorOutputConnector_3766OutgoingLinks(View view) {
		FastXSLTMediatorOutputConnector modelElement = (FastXSLTMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediator_3780OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorInputConnector_3781OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorOutputConnector_3782OutgoingLinks(View view) {
		ForEachMediatorOutputConnector modelElement = (ForEachMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getForEachMediatorTargetOutputConnector_3783OutgoingLinks(View view) {
		ForEachMediatorTargetOutputConnector modelElement = (ForEachMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3784OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediator_3785OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediatorInputConnector_3786OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPublishEventMediatorOutputConnector_3787OutgoingLinks(View view) {
		PublishEventMediatorOutputConnector modelElement = (PublishEventMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementOnAcceptContainer_3755OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3756OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementAdviceContainer_3757OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3758OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEntitlementObligationsContainer_3759OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3760OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultParentContainer_3734OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getSwitchDefaultContainer_3735OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyServiceFaultContainer_3488OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3530OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getProxyOutSequenceOutputConnector_3729OutgoingLinks(View view) {
		ProxyOutSequenceOutputConnector modelElement = (ProxyOutSequenceOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediatorInputConnector_3100OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getHeaderMediatorOutputConnector_3101OutgoingLinks(View view) {
		HeaderMediatorOutputConnector modelElement = (HeaderMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediator_3517OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorInputConnector_3103OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorOutputConnector_3104OutgoingLinks(View view) {
		CloneMediatorOutputConnector modelElement = (CloneMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorTargetOutputConnector_3133OutgoingLinks(View view) {
		CloneMediatorTargetOutputConnector modelElement = (CloneMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneMediatorContainer_3603OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCloneTargetContainer_3604OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3605OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediator_3518OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorInputConnector_3106OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorOutputConnector_3107OutgoingLinks(View view) {
		CacheMediatorOutputConnector modelElement = (CacheMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCacheMediatorOnHitOutputConnector_3618OutgoingLinks(View view) {
		CacheMediatorOnHitOutputConnector modelElement = (CacheMediatorOnHitOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3619OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediator_3519OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorInputConnector_3109OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorOutputConnector_3110OutgoingLinks(View view) {
		IterateMediatorOutputConnector modelElement = (IterateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getIterateMediatorTargetOutputConnector_3606OutgoingLinks(View view) {
		IterateMediatorTargetOutputConnector modelElement = (IterateMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3607OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediator_3520OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorInputConnector_3112OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorOutputConnector_3113OutgoingLinks(View view) {
		AggregateMediatorOutputConnector modelElement = (AggregateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediatorOnCompleteOutputConnector_3132OutgoingLinks(View view) {
		AggregateMediatorOnCompleteOutputConnector modelElement = (AggregateMediatorOnCompleteOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3526OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediator_3588OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediatorInputConnector_3589OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getStoreMediatorOutputConnector_3590OutgoingLinks(View view) {
		StoreMediatorOutputConnector modelElement = (StoreMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediator_3591OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediatorInputConnector_3592OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBuilderMediatorOutputConector_3593OutgoingLinks(View view) {
		BuilderMediatorOutputConector modelElement = (BuilderMediatorOutputConector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediator_3594OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediatorInputConnector_3595OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCallTemplateMediatorOutputConnector_3596OutgoingLinks(View view) {
		CallTemplateMediatorOutputConnector modelElement = (CallTemplateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediator_3597OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediatorInputConnector_3598OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getPayloadFactoryMediatorOutputConnector_3599OutgoingLinks(View view) {
		PayloadFactoryMediatorOutputConnector modelElement = (PayloadFactoryMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediator_3600OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediatorInputConnector_3601OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEnqueueMediatorOutputConnector_3602OutgoingLinks(View view) {
		EnqueueMediatorOutputConnector modelElement = (EnqueueMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediator_3620OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediatorInputConnector_3621OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getURLRewriteMediatorOutputConnector_3622OutgoingLinks(View view) {
		URLRewriteMediatorOutputConnector modelElement = (URLRewriteMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediator_3623OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorInputConnector_3624OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorOutputConnector_3625OutgoingLinks(View view) {
		ValidateMediatorOutputConnector modelElement = (ValidateMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getValidateMediatorOnFailOutputConnector_3626OutgoingLinks(View view) {
		ValidateMediatorOnFailOutputConnector modelElement = (ValidateMediatorOnFailOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3627OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediator_3628OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorInputConnector_3629OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorOutputConnector_3630OutgoingLinks(View view) {
		RouterMediatorOutputConnector modelElement = (RouterMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorTargetOutputConnector_3631OutgoingLinks(View view) {
		RouterMediatorTargetOutputConnector modelElement = (RouterMediatorTargetOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterMediatorContainer_3632OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRouterTargetContainer_3633OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3634OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediator_3635OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorInputConnector_3636OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorOutputConnector_3637OutgoingLinks(View view) {
		ConditionalRouterMediatorOutputConnector modelElement = (ConditionalRouterMediatorOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getConditionalRouterMediatorAdditionalOutputConnector_3638OutgoingLinks(
			View view) {
		ConditionalRouterMediatorAdditionalOutputConnector modelElement = (ConditionalRouterMediatorAdditionalOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3639OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediator_3680OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediatorInputConnector_3681OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBAMMediatorOutputConnector_3682OutgoingLinks(View view) {
		BAMMediatorOutputConnector modelElement = (BAMMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediator_3683OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediatorInputConnector_3684OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getBeanMediatorOutputConnector_3685OutgoingLinks(View view) {
		BeanMediatorOutputConnector modelElement = (BeanMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediator_3686OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediatorInputConnector_3687OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEJBMediatorOutputConnector_3688OutgoingLinks(View view) {
		EJBMediatorOutputConnector modelElement = (EJBMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPoint_3609OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3528OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterFailContainer_3537OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3538OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleOnRejectContainer_3586OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3587OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediatorInputConnector_3115OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getCalloutMediatorOutputConnector_3116OutgoingLinks(View view) {
		CalloutMediatorOutputConnector modelElement = (CalloutMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediator_3521OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediatorInputConnector_3118OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getTransactionMediatorOutputConnector_3119OutgoingLinks(View view) {
		TransactionMediatorOutputConnector modelElement = (TransactionMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediator_3522OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorInputConnector_3121OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOutputConnector_3122OutgoingLinks(View view) {
		ThrottleMediatorOutputConnector modelElement = (ThrottleMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOnAcceptOutputConnector_3581OutgoingLinks(View view) {
		ThrottleMediatorOnAcceptOutputConnector modelElement = (ThrottleMediatorOnAcceptOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleMediatorOnRejectOutputConnector_3582OutgoingLinks(View view) {
		ThrottleMediatorOnRejectOutputConnector modelElement = (ThrottleMediatorOnRejectOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleContainer_3583OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getThrottleOnAcceptContainer_3584OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3585OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFilterMediator_3494OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediatorInputConnector_3124OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRMSequenceMediatorOutputConnector_3125OutgoingLinks(View view) {
		RMSequenceMediatorOutputConnector modelElement = (RMSequenceMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediator_3523OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorInputConnector_3127OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorOutputConnector_3128OutgoingLinks(View view) {
		RuleMediatorOutputConnector modelElement = (RuleMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getRuleMediatorChildMediatorsOutputConnector_3640OutgoingLinks(View view) {
		RuleMediatorChildMediatorsOutputConnector modelElement = (RuleMediatorChildMediatorsOutputConnector) view
				.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getMediatorFlow_3641OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediator_3524OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediatorInputConnector_3130OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getOAuthMediatorOutputConnector_3131OutgoingLinks(View view) {
		OAuthMediatorOutputConnector modelElement = (OAuthMediatorOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAggregateMediator_3525OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointInputConnector_3021OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getDefaultEndPointOutputConnector_3022OutgoingLinks(View view) {
		DefaultEndPointOutputConnector modelElement = (DefaultEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPoint_3610OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointInputConnector_3030OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getAddressEndPointOutputConnector_3031OutgoingLinks(View view) {
		AddressEndPointOutputConnector modelElement = (AddressEndPointOutputConnector) view.getElement();
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_EsbLink_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getFailoverEndPoint_3611OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EsbLinkDescriptor> getEsbLink_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<EsbLinkDescriptor> getContainedTypeModelFacetLinks_EsbLink_4001(OutputConnector container) {
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		EsbLink link = container.getOutgoingLink();
		if (EsbLinkEditPart.VISUAL_ID != EsbVisualIDRegistry.getLinkWithClassVisualID(link)) {
			return result;
		}
		InputConnector dst = link.getTarget();
		OutputConnector src = link.getSource();
		result.add(new EsbLinkDescriptor(src, dst, link, EsbElementTypes.EsbLink_4001, EsbLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EsbLinkDescriptor> getIncomingTypeModelFacetLinks_EsbLink_4001(InputConnector target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != EsbPackage.eINSTANCE.getEsbLink_Target()
					|| false == setting.getEObject() instanceof EsbLink) {
				continue;
			}
			EsbLink link = (EsbLink) setting.getEObject();
			if (EsbLinkEditPart.VISUAL_ID != EsbVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			OutputConnector src = link.getSource();
			result.add(new EsbLinkDescriptor(src, target, link, EsbElementTypes.EsbLink_4001, EsbLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EsbLinkDescriptor> getOutgoingTypeModelFacetLinks_EsbLink_4001(OutputConnector source) {
		OutputConnector container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof OutputConnector) {
				container = (OutputConnector) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<EsbLinkDescriptor> result = new LinkedList<EsbLinkDescriptor>();
		EsbLink link = container.getOutgoingLink();
		if (EsbLinkEditPart.VISUAL_ID != EsbVisualIDRegistry.getLinkWithClassVisualID(link)) {
			return result;
		}
		InputConnector dst = link.getTarget();
		OutputConnector src = link.getSource();
		if (src != source) {
			return result;
		}
		result.add(new EsbLinkDescriptor(src, dst, link, EsbElementTypes.EsbLink_4001, EsbLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */

		public List<EsbNodeDescriptor> getSemanticChildren(View view) {
			return EsbDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */

		public List<EsbLinkDescriptor> getContainedLinks(View view) {
			return EsbDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */

		public List<EsbLinkDescriptor> getIncomingLinks(View view) {
			return EsbDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */

		public List<EsbLinkDescriptor> getOutgoingLinks(View view) {
			return EsbDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
