package org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbModelingAssistantProvider;

/**
 * @generated
 */
public class EsbModelingAssistantProviderOfProxyInputConnectorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((ProxyInputConnectorEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(ProxyInputConnectorEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(EsbElementTypes.EsbLink_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((ProxyInputConnectorEditPart) targetEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(ProxyInputConnectorEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == EsbElementTypes.EsbLink_4001) {
			types.add(EsbElementTypes.ProxyOutputConnector_3002);
			types.add(EsbElementTypes.ProxyOutSequenceOutputConnector_3729);
			types.add(EsbElementTypes.PropertyMediatorOutputConnector_3034);
			types.add(EsbElementTypes.ThrottleMediatorOutputConnector_3122);
			types.add(EsbElementTypes.ThrottleMediatorOnAcceptOutputConnector_3581);
			types.add(EsbElementTypes.ThrottleMediatorOnRejectOutputConnector_3582);
			types.add(EsbElementTypes.FilterMediatorOutputConnector_3534);
			types.add(EsbElementTypes.FilterMediatorPassOutputConnector_3011);
			types.add(EsbElementTypes.FilterMediatorFailOutputConnector_3012);
			types.add(EsbElementTypes.LogMediatorOutputConnector_3019);
			types.add(EsbElementTypes.EnrichMediatorOutputConnector_3037);
			types.add(EsbElementTypes.XSLTMediatorOutputConnector_3040);
			types.add(EsbElementTypes.SwitchMediatorOutputConnector_3499);
			types.add(EsbElementTypes.SwitchCaseBranchOutputConnector_3043);
			types.add(EsbElementTypes.SwitchDefaultBranchOutputConnector_3044);
			types.add(EsbElementTypes.SequenceOutputConnector_3050);
			types.add(EsbElementTypes.EventMediatorOutputConnector_3053);
			types.add(EsbElementTypes.EntitlementMediatorOutputConnector_3056);
			types.add(EsbElementTypes.EntitlementMediatorOnRejectOutputConnector_3748);
			types.add(EsbElementTypes.EntitlementMediatorOnAcceptOutputConnector_3749);
			types.add(EsbElementTypes.EntitlementMediatorAdviceOutputConnector_3750);
			types.add(EsbElementTypes.EntitlementMediatorObligationsOutputConnector_3751);
			types.add(EsbElementTypes.ClassMediatorOutputConnector_3059);
			types.add(EsbElementTypes.SpringMediatorOutputConnector_3062);
			types.add(EsbElementTypes.ScriptMediatorOutputConnector_3065);
			types.add(EsbElementTypes.FaultMediatorOutputConnector_3068);
			types.add(EsbElementTypes.XQueryMediatorOutputConnector_3071);
			types.add(EsbElementTypes.CommandMediatorOutputConnector_3074);
			types.add(EsbElementTypes.DBLookupMediatorOutputConnector_3077);
			types.add(EsbElementTypes.DBReportMediatorOutputConnector_3080);
			types.add(EsbElementTypes.SmooksMediatorOutputConnector_3083);
			types.add(EsbElementTypes.SendMediatorOutputConnector_3086);
			types.add(EsbElementTypes.SendMediatorEndpointOutputConnector_3539);
			types.add(EsbElementTypes.HeaderMediatorOutputConnector_3101);
			types.add(EsbElementTypes.CloneMediatorOutputConnector_3104);
			types.add(EsbElementTypes.CloneMediatorTargetOutputConnector_3133);
			types.add(EsbElementTypes.CacheMediatorOutputConnector_3107);
			types.add(EsbElementTypes.CacheMediatorOnHitOutputConnector_3618);
			types.add(EsbElementTypes.IterateMediatorOutputConnector_3110);
			types.add(EsbElementTypes.IterateMediatorTargetOutputConnector_3606);
			types.add(EsbElementTypes.CalloutMediatorOutputConnector_3116);
			types.add(EsbElementTypes.TransactionMediatorOutputConnector_3119);
			types.add(EsbElementTypes.RMSequenceMediatorOutputConnector_3125);
			types.add(EsbElementTypes.RuleMediatorOutputConnector_3128);
			types.add(EsbElementTypes.RuleMediatorChildMediatorsOutputConnector_3640);
			types.add(EsbElementTypes.OAuthMediatorOutputConnector_3131);
			types.add(EsbElementTypes.AggregateMediatorOutputConnector_3113);
			types.add(EsbElementTypes.AggregateMediatorOnCompleteOutputConnector_3132);
			types.add(EsbElementTypes.StoreMediatorOutputConnector_3590);
			types.add(EsbElementTypes.BuilderMediatorOutputConector_3593);
			types.add(EsbElementTypes.CallTemplateMediatorOutputConnector_3596);
			types.add(EsbElementTypes.PayloadFactoryMediatorOutputConnector_3599);
			types.add(EsbElementTypes.EnqueueMediatorOutputConnector_3602);
			types.add(EsbElementTypes.URLRewriteMediatorOutputConnector_3622);
			types.add(EsbElementTypes.ValidateMediatorOutputConnector_3625);
			types.add(EsbElementTypes.ValidateMediatorOnFailOutputConnector_3626);
			types.add(EsbElementTypes.RouterMediatorOutputConnector_3630);
			types.add(EsbElementTypes.RouterMediatorTargetOutputConnector_3631);
			types.add(EsbElementTypes.ConditionalRouterMediatorOutputConnector_3637);
			types.add(EsbElementTypes.ConditionalRouterMediatorAdditionalOutputConnector_3638);
			types.add(EsbElementTypes.BAMMediatorOutputConnector_3682);
			types.add(EsbElementTypes.BeanMediatorOutputConnector_3685);
			types.add(EsbElementTypes.EJBMediatorOutputConnector_3688);
			types.add(EsbElementTypes.DefaultEndPointOutputConnector_3022);
			types.add(EsbElementTypes.AddressEndPointOutputConnector_3031);
			types.add(EsbElementTypes.FailoverEndPointOutputConnector_3090);
			types.add(EsbElementTypes.FailoverEndPointWestOutputConnector_3097);
			types.add(EsbElementTypes.RecipientListEndPointOutputConnector_3694);
			types.add(EsbElementTypes.RecipientListEndPointWestOutputConnector_3695);
			types.add(EsbElementTypes.WSDLEndPointOutputConnector_3093);
			types.add(EsbElementTypes.NamedEndpointOutputConnector_3662);
			types.add(EsbElementTypes.LoadBalanceEndPointOutputConnector_3096);
			types.add(EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3098);
			types.add(EsbElementTypes.APIResourceEndpointOutputConnector_3676);
			types.add(EsbElementTypes.AddressingEndpointOutputConnector_3691);
			types.add(EsbElementTypes.HTTPEndPointOutputConnector_3711);
			types.add(EsbElementTypes.TemplateEndpointOutputConnector_3718);
			types.add(EsbElementTypes.CloudConnectorOutputConnector_3721);
			types.add(EsbElementTypes.CloudConnectorOperationOutputConnector_3724);
			types.add(EsbElementTypes.LoopBackMediatorOutputConnector_3738);
			types.add(EsbElementTypes.RespondMediatorOutputConnector_3741);
			types.add(EsbElementTypes.CallMediatorOutputConnector_3744);
			types.add(EsbElementTypes.CallMediatorEndpointOutputConnector_3745);
			types.add(EsbElementTypes.DataMapperMediatorOutputConnector_3763);
			types.add(EsbElementTypes.FastXSLTMediatorOutputConnector_3766);
			types.add(EsbElementTypes.ForEachMediatorOutputConnector_3782);
			types.add(EsbElementTypes.ForEachMediatorTargetOutputConnector_3783);
			types.add(EsbElementTypes.PublishEventMediatorOutputConnector_3787);
			types.add(EsbElementTypes.MessageOutputConnector_3047);
			types.add(EsbElementTypes.MergeNodeOutputConnector_3016);
			types.add(EsbElementTypes.SequencesOutputConnector_3617);
			types.add(EsbElementTypes.DefaultEndPointOutputConnector_3645);
			types.add(EsbElementTypes.AddressEndPointOutputConnector_3648);
			types.add(EsbElementTypes.FailoverEndPointOutputConnector_3651);
			types.add(EsbElementTypes.FailoverEndPointWestOutputConnector_3652);
			types.add(EsbElementTypes.RecipientListEndPointOutputConnector_3698);
			types.add(EsbElementTypes.RecipientListEndPointWestOutputConnector_3699);
			types.add(EsbElementTypes.WSDLEndPointOutputConnector_3655);
			types.add(EsbElementTypes.LoadBalanceEndPointOutputConnector_3658);
			types.add(EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3659);
			types.add(EsbElementTypes.HTTPEndPointOutputConnector_3714);
			types.add(EsbElementTypes.TemplateEndpointOutputConnector_3727);
			types.add(EsbElementTypes.APIResourceOutputConnector_3671);
			types.add(EsbElementTypes.APIResourceOutSequenceOutputConnector_3730);
			types.add(EsbElementTypes.ComplexEndpointsOutputConnector_3679);
			types.add(EsbElementTypes.InboundEndpointSequenceOutputConnector_3769);
			types.add(EsbElementTypes.InboundEndpointOnErrorSequenceOutputConnector_3771);
		}
		return types;
	}

}
