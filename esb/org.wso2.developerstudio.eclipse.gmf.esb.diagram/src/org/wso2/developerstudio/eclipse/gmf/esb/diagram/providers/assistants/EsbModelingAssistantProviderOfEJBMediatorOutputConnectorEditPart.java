package org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceFaultInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AddressEndPointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AddressEndPointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AddressingEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AggregateMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.BAMMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.BeanMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.BuilderMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CacheMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CallMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CallTemplateMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CalloutMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ClassMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorOperationInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CommandMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ConditionalRouterMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DBLookupMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DBReportMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DataMapperMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DefaultEndPointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DefaultEndPointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DropMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EJBMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EJBMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EnqueueMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EnrichMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EventMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FailoverEndPointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FailoverEndPointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FastXSLTMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FaultMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ForEachMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.HTTPEndPointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.HTTPEndPointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.HeaderMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointOnErrorSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.IterateMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LoadBalanceEndPointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LoadBalanceEndPointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LogMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LoopBackMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MergeNodeFirstInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MergeNodeSecondInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MessageInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.NamedEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.OAuthMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.PayloadFactoryMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.PropertyMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyFaultInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.PublishEventMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RMSequenceMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RecipientListEndPointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RecipientListEndPointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RespondMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RuleMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ScriptMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SmooksMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SpringMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.StoreMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.TemplateEndpointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.TemplateEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.TransactionMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.URLRewriteMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ValidateMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.WSDLEndPointInputConnector2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.WSDLEndPointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.XQueryMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.XSLTMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbModelingAssistantProvider;

/**
 * @generated
 */
public class EsbModelingAssistantProviderOfEJBMediatorOutputConnectorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((EJBMediatorOutputConnectorEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(EJBMediatorOutputConnectorEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(EsbElementTypes.EsbLink_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((EJBMediatorOutputConnectorEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(EJBMediatorOutputConnectorEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ProxyInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ProxyFaultInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof DropMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof PropertyMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ThrottleMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof FilterMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof LogMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof EnrichMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof XSLTMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof SwitchMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof SequenceInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof EventMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof EntitlementMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ClassMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof SpringMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ScriptMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof FaultMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof XQueryMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CommandMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof DBLookupMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof DBReportMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof SmooksMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof SendMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof HeaderMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CloneMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CacheMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof IterateMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CalloutMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof TransactionMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof RMSequenceMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof RuleMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof OAuthMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof AggregateMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof StoreMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof BuilderMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CallTemplateMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof PayloadFactoryMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof EnqueueMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof URLRewriteMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ValidateMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof RouterMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ConditionalRouterMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof BAMMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof BeanMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof EJBMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof DefaultEndPointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof AddressEndPointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof FailoverEndPointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof RecipientListEndPointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof WSDLEndPointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof NamedEndpointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof LoadBalanceEndPointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof APIResourceEndpointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof AddressingEndpointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof HTTPEndPointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof TemplateEndpointInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CloudConnectorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CloudConnectorOperationInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof LoopBackMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof RespondMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof CallMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof DataMapperMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof FastXSLTMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ForEachMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof PublishEventMediatorInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof ProxyInSequenceInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof MessageInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof MergeNodeFirstInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof MergeNodeSecondInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof SequencesInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof DefaultEndPointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof AddressEndPointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof FailoverEndPointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof RecipientListEndPointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof WSDLEndPointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof LoadBalanceEndPointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof HTTPEndPointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof TemplateEndpointInputConnector2EditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof APIResourceInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof APIResourceFaultInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof APIResourceInSequenceInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof InboundEndpointSequenceInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		if (targetEditPart instanceof InboundEndpointOnErrorSequenceInputConnectorEditPart) {
			types.add(EsbElementTypes.EsbLink_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((EJBMediatorOutputConnectorEditPart) sourceEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(EJBMediatorOutputConnectorEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == EsbElementTypes.EsbLink_4001) {
			types.add(EsbElementTypes.ProxyInputConnector_3003);
			types.add(EsbElementTypes.ProxyFaultInputConnector_3489);
			types.add(EsbElementTypes.DropMediatorInputConnector_3008);
			types.add(EsbElementTypes.PropertyMediatorInputConnector_3033);
			types.add(EsbElementTypes.ThrottleMediatorInputConnector_3121);
			types.add(EsbElementTypes.FilterMediatorInputConnector_3010);
			types.add(EsbElementTypes.LogMediatorInputConnector_3018);
			types.add(EsbElementTypes.EnrichMediatorInputConnector_3036);
			types.add(EsbElementTypes.XSLTMediatorInputConnector_3039);
			types.add(EsbElementTypes.SwitchMediatorInputConnector_3042);
			types.add(EsbElementTypes.SequenceInputConnector_3049);
			types.add(EsbElementTypes.EventMediatorInputConnector_3052);
			types.add(EsbElementTypes.EntitlementMediatorInputConnector_3055);
			types.add(EsbElementTypes.ClassMediatorInputConnector_3058);
			types.add(EsbElementTypes.SpringMediatorInputConnector_3061);
			types.add(EsbElementTypes.ScriptMediatorInputConnector_3064);
			types.add(EsbElementTypes.FaultMediatorInputConnector_3067);
			types.add(EsbElementTypes.XQueryMediatorInputConnector_3070);
			types.add(EsbElementTypes.CommandMediatorInputConnector_3073);
			types.add(EsbElementTypes.DBLookupMediatorInputConnector_3076);
			types.add(EsbElementTypes.DBReportMediatorInputConnector_3079);
			types.add(EsbElementTypes.SmooksMediatorInputConnector_3082);
			types.add(EsbElementTypes.SendMediatorInputConnector_3085);
			types.add(EsbElementTypes.HeaderMediatorInputConnector_3100);
			types.add(EsbElementTypes.CloneMediatorInputConnector_3103);
			types.add(EsbElementTypes.CacheMediatorInputConnector_3106);
			types.add(EsbElementTypes.IterateMediatorInputConnector_3109);
			types.add(EsbElementTypes.CalloutMediatorInputConnector_3115);
			types.add(EsbElementTypes.TransactionMediatorInputConnector_3118);
			types.add(EsbElementTypes.RMSequenceMediatorInputConnector_3124);
			types.add(EsbElementTypes.RuleMediatorInputConnector_3127);
			types.add(EsbElementTypes.OAuthMediatorInputConnector_3130);
			types.add(EsbElementTypes.AggregateMediatorInputConnector_3112);
			types.add(EsbElementTypes.StoreMediatorInputConnector_3589);
			types.add(EsbElementTypes.BuilderMediatorInputConnector_3592);
			types.add(EsbElementTypes.CallTemplateMediatorInputConnector_3595);
			types.add(EsbElementTypes.PayloadFactoryMediatorInputConnector_3598);
			types.add(EsbElementTypes.EnqueueMediatorInputConnector_3601);
			types.add(EsbElementTypes.URLRewriteMediatorInputConnector_3621);
			types.add(EsbElementTypes.ValidateMediatorInputConnector_3624);
			types.add(EsbElementTypes.RouterMediatorInputConnector_3629);
			types.add(EsbElementTypes.ConditionalRouterMediatorInputConnector_3636);
			types.add(EsbElementTypes.BAMMediatorInputConnector_3681);
			types.add(EsbElementTypes.BeanMediatorInputConnector_3684);
			types.add(EsbElementTypes.EJBMediatorInputConnector_3687);
			types.add(EsbElementTypes.DefaultEndPointInputConnector_3021);
			types.add(EsbElementTypes.AddressEndPointInputConnector_3030);
			types.add(EsbElementTypes.FailoverEndPointInputConnector_3088);
			types.add(EsbElementTypes.RecipientListEndPointInputConnector_3693);
			types.add(EsbElementTypes.WSDLEndPointInputConnector_3092);
			types.add(EsbElementTypes.NamedEndpointInputConnector_3661);
			types.add(EsbElementTypes.LoadBalanceEndPointInputConnector_3095);
			types.add(EsbElementTypes.APIResourceEndpointInputConnector_3675);
			types.add(EsbElementTypes.AddressingEndpointInputConnector_3690);
			types.add(EsbElementTypes.HTTPEndPointInputConnector_3710);
			types.add(EsbElementTypes.TemplateEndpointInputConnector_3717);
			types.add(EsbElementTypes.CloudConnectorInputConnector_3720);
			types.add(EsbElementTypes.CloudConnectorOperationInputConnector_3723);
			types.add(EsbElementTypes.LoopBackMediatorInputConnector_3737);
			types.add(EsbElementTypes.RespondMediatorInputConnector_3740);
			types.add(EsbElementTypes.CallMediatorInputConnector_3743);
			types.add(EsbElementTypes.DataMapperMediatorInputConnector_3762);
			types.add(EsbElementTypes.FastXSLTMediatorInputConnector_3765);
			types.add(EsbElementTypes.ForEachMediatorInputConnector_3781);
			types.add(EsbElementTypes.PublishEventMediatorInputConnector_3786);
			types.add(EsbElementTypes.ProxyInSequenceInputConnector_3731);
			types.add(EsbElementTypes.MessageInputConnector_3046);
			types.add(EsbElementTypes.MergeNodeFirstInputConnector_3014);
			types.add(EsbElementTypes.MergeNodeSecondInputConnector_3015);
			types.add(EsbElementTypes.SequencesInputConnector_3616);
			types.add(EsbElementTypes.DefaultEndPointInputConnector_3644);
			types.add(EsbElementTypes.AddressEndPointInputConnector_3647);
			types.add(EsbElementTypes.FailoverEndPointInputConnector_3650);
			types.add(EsbElementTypes.RecipientListEndPointInputConnector_3697);
			types.add(EsbElementTypes.WSDLEndPointInputConnector_3654);
			types.add(EsbElementTypes.LoadBalanceEndPointInputConnector_3657);
			types.add(EsbElementTypes.HTTPEndPointInputConnector_3713);
			types.add(EsbElementTypes.TemplateEndpointInputConnector_3726);
			types.add(EsbElementTypes.APIResourceInputConnector_3670);
			types.add(EsbElementTypes.APIResourceFaultInputConnector_3672);
			types.add(EsbElementTypes.APIResourceInSequenceInputConnector_3747);
			types.add(EsbElementTypes.InboundEndpointSequenceInputConnector_3768);
			types.add(EsbElementTypes.InboundEndpointOnErrorSequenceInputConnector_3770);
		}
		return types;
	}

}
