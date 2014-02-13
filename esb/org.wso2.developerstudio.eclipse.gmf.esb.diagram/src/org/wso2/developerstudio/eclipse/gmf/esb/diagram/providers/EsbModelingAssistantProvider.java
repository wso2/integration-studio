package org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.*;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;

/**
 * @generated
 */
public class EsbModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof EsbDiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.EsbServer_2001);
			return types;
		}
		if (editPart instanceof EsbServerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.MessageMediator_3045);
			types.add(EsbElementTypes.EndpointDiagram_3642);
			return types;
		}
		if (editPart instanceof ProxyServiceEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(EsbElementTypes.ProxyOutputConnector_3002);
			types.add(EsbElementTypes.ProxyInputConnector_3003);
			types.add(EsbElementTypes.ProxyOutSequenceOutputConnector_3729);
			types.add(EsbElementTypes.ProxyFaultInputConnector_3489);
			types.add(EsbElementTypes.ProxyServiceContainer_3486);
			types.add(EsbElementTypes.ProxyInSequenceInputConnector_3731);
			return types;
		}
		if (editPart instanceof ProxyServiceContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.ProxyServiceSequenceAndEndpointContainer_3487);
			types.add(EsbElementTypes.ProxyServiceFaultContainer_3488);
			return types;
		}
		if (editPart instanceof ProxyServiceSequenceAndEndpointContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3608);
			return types;
		}
		if (editPart instanceof DropMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.DropMediatorInputConnector_3008);
			return types;
		}
		if (editPart instanceof PropertyMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.PropertyMediatorInputConnector_3033);
			types.add(EsbElementTypes.PropertyMediatorOutputConnector_3034);
			return types;
		}
		if (editPart instanceof ThrottleMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(EsbElementTypes.ThrottleMediatorInputConnector_3121);
			types.add(EsbElementTypes.ThrottleMediatorOutputConnector_3122);
			types.add(EsbElementTypes.ThrottleMediatorOnAcceptOutputConnector_3581);
			types.add(EsbElementTypes.ThrottleMediatorOnRejectOutputConnector_3582);
			types.add(EsbElementTypes.ThrottleContainer_3583);
			return types;
		}
		if (editPart instanceof ThrottleContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.ThrottleOnAcceptContainer_3584);
			types.add(EsbElementTypes.ThrottleOnRejectContainer_3586);
			return types;
		}
		if (editPart instanceof ThrottleOnAcceptContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3585);
			return types;
		}
		if (editPart instanceof FilterMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(EsbElementTypes.FilterMediatorInputConnector_3010);
			types.add(EsbElementTypes.FilterMediatorOutputConnector_3534);
			types.add(EsbElementTypes.FilterMediatorPassOutputConnector_3011);
			types.add(EsbElementTypes.FilterMediatorFailOutputConnector_3012);
			types.add(EsbElementTypes.FilterContainer_3531);
			return types;
		}
		if (editPart instanceof FilterContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.FilterPassContainer_3535);
			types.add(EsbElementTypes.FilterFailContainer_3537);
			return types;
		}
		if (editPart instanceof FilterPassContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3536);
			return types;
		}
		if (editPart instanceof LogMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.LogMediatorInputConnector_3018);
			types.add(EsbElementTypes.LogMediatorOutputConnector_3019);
			return types;
		}
		if (editPart instanceof EnrichMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.EnrichMediatorInputConnector_3036);
			types.add(EsbElementTypes.EnrichMediatorOutputConnector_3037);
			return types;
		}
		if (editPart instanceof XSLTMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.XSLTMediatorInputConnector_3039);
			types.add(EsbElementTypes.XSLTMediatorOutputConnector_3040);
			return types;
		}
		if (editPart instanceof SwitchMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(EsbElementTypes.SwitchMediatorInputConnector_3042);
			types.add(EsbElementTypes.SwitchMediatorOutputConnector_3499);
			types.add(EsbElementTypes.SwitchCaseBranchOutputConnector_3043);
			types.add(EsbElementTypes.SwitchDefaultBranchOutputConnector_3044);
			types.add(EsbElementTypes.SwitchMediatorContainer_3500);
			return types;
		}
		if (editPart instanceof SwitchMediatorContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.SwitchCaseParentContainer_3732);
			types.add(EsbElementTypes.SwitchDefaultParentContainer_3734);
			return types;
		}
		if (editPart instanceof SwitchCaseParentContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.SwitchCaseContainer_3733);
			return types;
		}
		if (editPart instanceof SwitchCaseContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3502);
			return types;
		}
		if (editPart instanceof SequenceEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.SequenceInputConnector_3049);
			types.add(EsbElementTypes.SequenceOutputConnector_3050);
			return types;
		}
		if (editPart instanceof EventMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.EventMediatorInputConnector_3052);
			types.add(EsbElementTypes.EventMediatorOutputConnector_3053);
			return types;
		}
		if (editPart instanceof EntitlementMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(7);
			types.add(EsbElementTypes.EntitlementMediatorInputConnector_3055);
			types.add(EsbElementTypes.EntitlementMediatorOutputConnector_3056);
			types.add(EsbElementTypes.EntitlementMediatorOnRejectOutputConnector_3748);
			types.add(EsbElementTypes.EntitlementMediatorOnAcceptOutputConnector_3749);
			types.add(EsbElementTypes.EntitlementMediatorAdviceOutputConnector_3750);
			types.add(EsbElementTypes.EntitlementMediatorObligationsOutputConnector_3751);
			types.add(EsbElementTypes.EntitlementContainer_3752);
			return types;
		}
		if (editPart instanceof EntitlementContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.EntitlementOnRejectContainer_3753);
			types.add(EsbElementTypes.EntitlementOnAcceptContainer_3755);
			types.add(EsbElementTypes.EntitlementAdviceContainer_3757);
			types.add(EsbElementTypes.EntitlementObligationsContainer_3759);
			return types;
		}
		if (editPart instanceof EntitlementOnRejectContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3754);
			return types;
		}
		if (editPart instanceof ClassMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.ClassMediatorInputConnector_3058);
			types.add(EsbElementTypes.ClassMediatorOutputConnector_3059);
			return types;
		}
		if (editPart instanceof SpringMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.SpringMediatorInputConnector_3061);
			types.add(EsbElementTypes.SpringMediatorOutputConnector_3062);
			return types;
		}
		if (editPart instanceof ScriptMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.ScriptMediatorInputConnector_3064);
			types.add(EsbElementTypes.ScriptMediatorOutputConnector_3065);
			return types;
		}
		if (editPart instanceof FaultMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.FaultMediatorInputConnector_3067);
			types.add(EsbElementTypes.FaultMediatorOutputConnector_3068);
			return types;
		}
		if (editPart instanceof XQueryMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.XQueryMediatorInputConnector_3070);
			types.add(EsbElementTypes.XQueryMediatorOutputConnector_3071);
			return types;
		}
		if (editPart instanceof CommandMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.CommandMediatorInputConnector_3073);
			types.add(EsbElementTypes.CommandMediatorOutputConnector_3074);
			return types;
		}
		if (editPart instanceof DBLookupMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.DBLookupMediatorInputConnector_3076);
			types.add(EsbElementTypes.DBLookupMediatorOutputConnector_3077);
			return types;
		}
		if (editPart instanceof DBReportMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.DBReportMediatorInputConnector_3079);
			types.add(EsbElementTypes.DBReportMediatorOutputConnector_3080);
			return types;
		}
		if (editPart instanceof SmooksMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.SmooksMediatorInputConnector_3082);
			types.add(EsbElementTypes.SmooksMediatorOutputConnector_3083);
			return types;
		}
		if (editPart instanceof SendMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.SendMediatorInputConnector_3085);
			types.add(EsbElementTypes.SendMediatorOutputConnector_3086);
			types.add(EsbElementTypes.SendMediatorEndpointOutputConnector_3539);
			types.add(EsbElementTypes.MediatorFlow_3728);
			return types;
		}
		if (editPart instanceof HeaderMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.HeaderMediatorInputConnector_3100);
			types.add(EsbElementTypes.HeaderMediatorOutputConnector_3101);
			return types;
		}
		if (editPart instanceof CloneMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.CloneMediatorInputConnector_3103);
			types.add(EsbElementTypes.CloneMediatorOutputConnector_3104);
			types.add(EsbElementTypes.CloneMediatorTargetOutputConnector_3133);
			types.add(EsbElementTypes.CloneMediatorContainer_3603);
			return types;
		}
		if (editPart instanceof CloneMediatorContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.CloneTargetContainer_3604);
			return types;
		}
		if (editPart instanceof CloneTargetContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3605);
			return types;
		}
		if (editPart instanceof CacheMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.CacheMediatorInputConnector_3106);
			types.add(EsbElementTypes.CacheMediatorOutputConnector_3107);
			types.add(EsbElementTypes.CacheMediatorOnHitOutputConnector_3618);
			types.add(EsbElementTypes.MediatorFlow_3619);
			return types;
		}
		if (editPart instanceof IterateMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.IterateMediatorInputConnector_3109);
			types.add(EsbElementTypes.IterateMediatorOutputConnector_3110);
			types.add(EsbElementTypes.IterateMediatorTargetOutputConnector_3606);
			types.add(EsbElementTypes.MediatorFlow_3607);
			return types;
		}
		if (editPart instanceof CalloutMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.CalloutMediatorInputConnector_3115);
			types.add(EsbElementTypes.CalloutMediatorOutputConnector_3116);
			return types;
		}
		if (editPart instanceof TransactionMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.TransactionMediatorInputConnector_3118);
			types.add(EsbElementTypes.TransactionMediatorOutputConnector_3119);
			return types;
		}
		if (editPart instanceof RMSequenceMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.RMSequenceMediatorInputConnector_3124);
			types.add(EsbElementTypes.RMSequenceMediatorOutputConnector_3125);
			return types;
		}
		if (editPart instanceof RuleMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.RuleMediatorInputConnector_3127);
			types.add(EsbElementTypes.RuleMediatorOutputConnector_3128);
			types.add(EsbElementTypes.RuleMediatorChildMediatorsOutputConnector_3640);
			types.add(EsbElementTypes.MediatorFlow_3641);
			return types;
		}
		if (editPart instanceof OAuthMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.OAuthMediatorInputConnector_3130);
			types.add(EsbElementTypes.OAuthMediatorOutputConnector_3131);
			return types;
		}
		if (editPart instanceof AggregateMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.AggregateMediatorInputConnector_3112);
			types.add(EsbElementTypes.AggregateMediatorOutputConnector_3113);
			types.add(EsbElementTypes.AggregateMediatorOnCompleteOutputConnector_3132);
			types.add(EsbElementTypes.MediatorFlow_3526);
			return types;
		}
		if (editPart instanceof StoreMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.StoreMediatorInputConnector_3589);
			types.add(EsbElementTypes.StoreMediatorOutputConnector_3590);
			return types;
		}
		if (editPart instanceof BuilderMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.BuilderMediatorInputConnector_3592);
			types.add(EsbElementTypes.BuilderMediatorOutputConector_3593);
			return types;
		}
		if (editPart instanceof CallTemplateMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.CallTemplateMediatorInputConnector_3595);
			types.add(EsbElementTypes.CallTemplateMediatorOutputConnector_3596);
			return types;
		}
		if (editPart instanceof PayloadFactoryMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.PayloadFactoryMediatorInputConnector_3598);
			types.add(EsbElementTypes.PayloadFactoryMediatorOutputConnector_3599);
			return types;
		}
		if (editPart instanceof EnqueueMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.EnqueueMediatorInputConnector_3601);
			types.add(EsbElementTypes.EnqueueMediatorOutputConnector_3602);
			return types;
		}
		if (editPart instanceof URLRewriteMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.URLRewriteMediatorInputConnector_3621);
			types.add(EsbElementTypes.URLRewriteMediatorOutputConnector_3622);
			return types;
		}
		if (editPart instanceof ValidateMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.ValidateMediatorInputConnector_3624);
			types.add(EsbElementTypes.ValidateMediatorOutputConnector_3625);
			types.add(EsbElementTypes.ValidateMediatorOnFailOutputConnector_3626);
			types.add(EsbElementTypes.MediatorFlow_3627);
			return types;
		}
		if (editPart instanceof RouterMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.RouterMediatorInputConnector_3629);
			types.add(EsbElementTypes.RouterMediatorOutputConnector_3630);
			types.add(EsbElementTypes.RouterMediatorTargetOutputConnector_3631);
			types.add(EsbElementTypes.RouterMediatorContainer_3632);
			return types;
		}
		if (editPart instanceof RouterMediatorContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.RouterTargetContainer_3633);
			return types;
		}
		if (editPart instanceof RouterTargetContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3634);
			return types;
		}
		if (editPart instanceof ConditionalRouterMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.ConditionalRouterMediatorInputConnector_3636);
			types.add(EsbElementTypes.ConditionalRouterMediatorOutputConnector_3637);
			types.add(EsbElementTypes.ConditionalRouterMediatorAdditionalOutputConnector_3638);
			types.add(EsbElementTypes.MediatorFlow_3639);
			return types;
		}
		if (editPart instanceof BAMMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.BAMMediatorInputConnector_3681);
			types.add(EsbElementTypes.BAMMediatorOutputConnector_3682);
			return types;
		}
		if (editPart instanceof BeanMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.BeanMediatorInputConnector_3684);
			types.add(EsbElementTypes.BeanMediatorOutputConnector_3685);
			return types;
		}
		if (editPart instanceof EJBMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.EJBMediatorInputConnector_3687);
			types.add(EsbElementTypes.EJBMediatorOutputConnector_3688);
			return types;
		}
		if (editPart instanceof DefaultEndPointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.DefaultEndPointInputConnector_3021);
			types.add(EsbElementTypes.DefaultEndPointOutputConnector_3022);
			return types;
		}
		if (editPart instanceof AddressEndPointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.AddressEndPointInputConnector_3030);
			types.add(EsbElementTypes.AddressEndPointOutputConnector_3031);
			return types;
		}
		if (editPart instanceof FailoverEndPointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.FailoverEndPointInputConnector_3088);
			types.add(EsbElementTypes.FailoverEndPointOutputConnector_3090);
			types.add(EsbElementTypes.FailoverEndPointWestOutputConnector_3097);
			return types;
		}
		if (editPart instanceof RecipientListEndPointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.RecipientListEndPointInputConnector_3693);
			types.add(EsbElementTypes.RecipientListEndPointOutputConnector_3694);
			types.add(EsbElementTypes.RecipientListEndPointWestOutputConnector_3695);
			return types;
		}
		if (editPart instanceof WSDLEndPointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.WSDLEndPointInputConnector_3092);
			types.add(EsbElementTypes.WSDLEndPointOutputConnector_3093);
			return types;
		}
		if (editPart instanceof NamedEndpointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.NamedEndpointInputConnector_3661);
			types.add(EsbElementTypes.NamedEndpointOutputConnector_3662);
			return types;
		}
		if (editPart instanceof LoadBalanceEndPointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.LoadBalanceEndPointInputConnector_3095);
			types.add(EsbElementTypes.LoadBalanceEndPointOutputConnector_3096);
			types.add(EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3098);
			return types;
		}
		if (editPart instanceof APIResourceEndpointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.APIResourceEndpointInputConnector_3675);
			types.add(EsbElementTypes.APIResourceEndpointOutputConnector_3676);
			return types;
		}
		if (editPart instanceof AddressingEndpointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.AddressingEndpointInputConnector_3690);
			types.add(EsbElementTypes.AddressingEndpointOutputConnector_3691);
			return types;
		}
		if (editPart instanceof HTTPEndpointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.HTTPEndPointInputConnector_3710);
			types.add(EsbElementTypes.HTTPEndPointOutputConnector_3711);
			return types;
		}
		if (editPart instanceof TemplateEndpointEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.TemplateEndpointInputConnector_3717);
			types.add(EsbElementTypes.TemplateEndpointOutputConnector_3718);
			return types;
		}
		if (editPart instanceof CloudConnectorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.CloudConnectorInputConnector_3720);
			types.add(EsbElementTypes.CloudConnectorOutputConnector_3721);
			return types;
		}
		if (editPart instanceof CloudConnectorOperationEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.CloudConnectorOperationInputConnector_3723);
			types.add(EsbElementTypes.CloudConnectorOperationOutputConnector_3724);
			return types;
		}
		if (editPart instanceof LoopBackMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.LoopBackMediatorInputConnector_3737);
			types.add(EsbElementTypes.LoopBackMediatorOutputConnector_3738);
			return types;
		}
		if (editPart instanceof RespondMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.RespondMediatorInputConnector_3740);
			types.add(EsbElementTypes.RespondMediatorOutputConnector_3741);
			return types;
		}
		if (editPart instanceof CallMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(EsbElementTypes.CallMediatorInputConnector_3743);
			types.add(EsbElementTypes.CallMediatorOutputConnector_3744);
			types.add(EsbElementTypes.CallMediatorEndpointOutputConnector_3745);
			types.add(EsbElementTypes.MediatorFlow_3746);
			return types;
		}
		if (editPart instanceof EntitlementOnAcceptContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3756);
			return types;
		}
		if (editPart instanceof EntitlementAdviceContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3758);
			return types;
		}
		if (editPart instanceof EntitlementObligationsContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3760);
			return types;
		}
		if (editPart instanceof SwitchDefaultParentContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.SwitchDefaultContainer_3735);
			return types;
		}
		if (editPart instanceof SwitchDefaultContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3528);
			return types;
		}
		if (editPart instanceof FilterFailContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3538);
			return types;
		}
		if (editPart instanceof ThrottleOnRejectContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3587);
			return types;
		}
		if (editPart instanceof ProxyServiceFaultContainerEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.MediatorFlow_3530);
			return types;
		}
		if (editPart instanceof MessageMediatorEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.MessageInputConnector_3046);
			types.add(EsbElementTypes.MessageOutputConnector_3047);
			return types;
		}
		if (editPart instanceof MergeNodeEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.MergeNodeFirstInputConnector_3014);
			types.add(EsbElementTypes.MergeNodeSecondInputConnector_3015);
			types.add(EsbElementTypes.MergeNodeOutputConnector_3016);
			return types;
		}
		if (editPart instanceof SequencesEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.MediatorFlow_3615);
			types.add(EsbElementTypes.SequencesInputConnector_3616);
			types.add(EsbElementTypes.SequencesOutputConnector_3617);
			return types;
		}
		if (editPart instanceof DefaultEndPoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.DefaultEndPointInputConnector_3644);
			types.add(EsbElementTypes.DefaultEndPointOutputConnector_3645);
			return types;
		}
		if (editPart instanceof AddressEndPoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.AddressEndPointInputConnector_3647);
			types.add(EsbElementTypes.AddressEndPointOutputConnector_3648);
			return types;
		}
		if (editPart instanceof FailoverEndPoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.FailoverEndPointInputConnector_3650);
			types.add(EsbElementTypes.FailoverEndPointOutputConnector_3651);
			types.add(EsbElementTypes.FailoverEndPointWestOutputConnector_3652);
			return types;
		}
		if (editPart instanceof RecipientListEndPoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.RecipientListEndPointInputConnector_3697);
			types.add(EsbElementTypes.RecipientListEndPointOutputConnector_3698);
			types.add(EsbElementTypes.RecipientListEndPointWestOutputConnector_3699);
			return types;
		}
		if (editPart instanceof WSDLEndPoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.WSDLEndPointInputConnector_3654);
			types.add(EsbElementTypes.WSDLEndPointOutputConnector_3655);
			return types;
		}
		if (editPart instanceof LoadBalanceEndPoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.LoadBalanceEndPointInputConnector_3657);
			types.add(EsbElementTypes.LoadBalanceEndPointOutputConnector_3658);
			types.add(EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3659);
			return types;
		}
		if (editPart instanceof HTTPEndpoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.HTTPEndPointInputConnector_3713);
			types.add(EsbElementTypes.HTTPEndPointOutputConnector_3714);
			return types;
		}
		if (editPart instanceof TemplateEndpoint2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.TemplateEndpointInputConnector_3726);
			types.add(EsbElementTypes.TemplateEndpointOutputConnector_3727);
			return types;
		}
		if (editPart instanceof Sequences2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(EsbElementTypes.MediatorFlow_3615);
			types.add(EsbElementTypes.SequencesInputConnector_3616);
			types.add(EsbElementTypes.SequencesOutputConnector_3617);
			return types;
		}
		if (editPart instanceof APIResourceEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(EsbElementTypes.APIResourceInputConnector_3670);
			types.add(EsbElementTypes.APIResourceOutputConnector_3671);
			types.add(EsbElementTypes.APIResourceOutSequenceOutputConnector_3730);
			types.add(EsbElementTypes.APIResourceFaultInputConnector_3672);
			types.add(EsbElementTypes.ProxyServiceContainer_3673);
			types.add(EsbElementTypes.APIResourceInSequenceInputConnector_3747);
			return types;
		}
		if (editPart instanceof ProxyServiceContainer2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.ProxyServiceSequenceAndEndpointContainer_3487);
			types.add(EsbElementTypes.ProxyServiceFaultContainer_3488);
			return types;
		}
		if (editPart instanceof ComplexEndpointsEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.MediatorFlow_3678);
			types.add(EsbElementTypes.ComplexEndpointsOutputConnector_3679);
			return types;
		}
		if (editPart instanceof EsbServerContentsCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(EsbElementTypes.ProxyService_3001);
			types.add(EsbElementTypes.MergeNode_3013);
			types.add(EsbElementTypes.Sequences_3614);
			types.add(EsbElementTypes.LocalEntry_3663);
			types.add(EsbElementTypes.Template_3664);
			types.add(EsbElementTypes.Task_3667);
			types.add(EsbElementTypes.SynapseAPI_3668);
			types.add(EsbElementTypes.ComplexEndpoints_3677);
			types.add(EsbElementTypes.MessageStore_3715);
			types.add(EsbElementTypes.MessageProcessor_3701);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment9EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment7EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment21EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment19EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment11EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment13EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment12EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment17EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment3EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment14EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment15EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment16EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment20EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment22EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment23EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment24EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment4EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment8EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment10EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment6EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment5EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		if (editPart instanceof EndpointDiagramEndpointCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(EsbElementTypes.DefaultEndPoint_3643);
			types.add(EsbElementTypes.AddressEndPoint_3646);
			types.add(EsbElementTypes.FailoverEndPoint_3649);
			types.add(EsbElementTypes.RecipientListEndPoint_3696);
			types.add(EsbElementTypes.WSDLEndPoint_3653);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3656);
			types.add(EsbElementTypes.HTTPEndpoint_3712);
			types.add(EsbElementTypes.TemplateEndpoint_3725);
			return types;
		}
		if (editPart instanceof TemplateTemplateCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(EsbElementTypes.Sequences_3665);
			types.add(EsbElementTypes.EndpointDiagram_3666);
			return types;
		}
		if (editPart instanceof EndpointDiagramEndpointCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(EsbElementTypes.DefaultEndPoint_3643);
			types.add(EsbElementTypes.AddressEndPoint_3646);
			types.add(EsbElementTypes.FailoverEndPoint_3649);
			types.add(EsbElementTypes.RecipientListEndPoint_3696);
			types.add(EsbElementTypes.WSDLEndPoint_3653);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3656);
			types.add(EsbElementTypes.HTTPEndpoint_3712);
			types.add(EsbElementTypes.TemplateEndpoint_3725);
			return types;
		}
		if (editPart instanceof SynapseAPIAPICompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EsbElementTypes.APIResource_3669);
			return types;
		}
		if (editPart instanceof MediatorFlowMediatorFlowCompartment18EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(59);
			types.add(EsbElementTypes.DropMediator_3491);
			types.add(EsbElementTypes.PropertyMediator_3492);
			types.add(EsbElementTypes.ThrottleMediator_3493);
			types.add(EsbElementTypes.FilterMediator_3494);
			types.add(EsbElementTypes.LogMediator_3495);
			types.add(EsbElementTypes.EnrichMediator_3496);
			types.add(EsbElementTypes.XSLTMediator_3497);
			types.add(EsbElementTypes.SwitchMediator_3498);
			types.add(EsbElementTypes.Sequence_3503);
			types.add(EsbElementTypes.EventMediator_3504);
			types.add(EsbElementTypes.EntitlementMediator_3505);
			types.add(EsbElementTypes.ClassMediator_3506);
			types.add(EsbElementTypes.SpringMediator_3507);
			types.add(EsbElementTypes.ScriptMediator_3508);
			types.add(EsbElementTypes.FaultMediator_3509);
			types.add(EsbElementTypes.XQueryMediator_3510);
			types.add(EsbElementTypes.CommandMediator_3511);
			types.add(EsbElementTypes.DBLookupMediator_3512);
			types.add(EsbElementTypes.DBReportMediator_3513);
			types.add(EsbElementTypes.SmooksMediator_3514);
			types.add(EsbElementTypes.SendMediator_3515);
			types.add(EsbElementTypes.HeaderMediator_3516);
			types.add(EsbElementTypes.CloneMediator_3517);
			types.add(EsbElementTypes.CacheMediator_3518);
			types.add(EsbElementTypes.IterateMediator_3519);
			types.add(EsbElementTypes.CalloutMediator_3520);
			types.add(EsbElementTypes.TransactionMediator_3521);
			types.add(EsbElementTypes.RMSequenceMediator_3522);
			types.add(EsbElementTypes.RuleMediator_3523);
			types.add(EsbElementTypes.OAuthMediator_3524);
			types.add(EsbElementTypes.AggregateMediator_3525);
			types.add(EsbElementTypes.StoreMediator_3588);
			types.add(EsbElementTypes.BuilderMediator_3591);
			types.add(EsbElementTypes.CallTemplateMediator_3594);
			types.add(EsbElementTypes.PayloadFactoryMediator_3597);
			types.add(EsbElementTypes.EnqueueMediator_3600);
			types.add(EsbElementTypes.URLRewriteMediator_3620);
			types.add(EsbElementTypes.ValidateMediator_3623);
			types.add(EsbElementTypes.RouterMediator_3628);
			types.add(EsbElementTypes.ConditionalRouterMediator_3635);
			types.add(EsbElementTypes.BAMMediator_3680);
			types.add(EsbElementTypes.BeanMediator_3683);
			types.add(EsbElementTypes.EJBMediator_3686);
			types.add(EsbElementTypes.DefaultEndPoint_3609);
			types.add(EsbElementTypes.AddressEndPoint_3610);
			types.add(EsbElementTypes.FailoverEndPoint_3611);
			types.add(EsbElementTypes.RecipientListEndPoint_3692);
			types.add(EsbElementTypes.WSDLEndPoint_3612);
			types.add(EsbElementTypes.NamedEndpoint_3660);
			types.add(EsbElementTypes.LoadBalanceEndPoint_3613);
			types.add(EsbElementTypes.APIResourceEndpoint_3674);
			types.add(EsbElementTypes.AddressingEndpoint_3689);
			types.add(EsbElementTypes.HTTPEndpoint_3709);
			types.add(EsbElementTypes.TemplateEndpoint_3716);
			types.add(EsbElementTypes.CloudConnector_3719);
			types.add(EsbElementTypes.CloudConnectorOperation_3722);
			types.add(EsbElementTypes.LoopBackMediator_3736);
			types.add(EsbElementTypes.RespondMediator_3739);
			types.add(EsbElementTypes.CallMediator_3742);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ProxyOutputConnectorEditPart) {
			return ((ProxyOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ProxyOutSequenceOutputConnectorEditPart) {
			return ((ProxyOutSequenceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PropertyMediatorOutputConnectorEditPart) {
			return ((PropertyMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ThrottleMediatorOutputConnectorEditPart) {
			return ((ThrottleMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ThrottleMediatorOnAcceptOutputConnectorEditPart) {
			return ((ThrottleMediatorOnAcceptOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ThrottleMediatorOnRejectOutputConnectorEditPart) {
			return ((ThrottleMediatorOnRejectOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FilterMediatorOutputConnectorEditPart) {
			return ((FilterMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FilterMediatorPassOutputConnectorEditPart) {
			return ((FilterMediatorPassOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FilterMediatorFailOutputConnectorEditPart) {
			return ((FilterMediatorFailOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LogMediatorOutputConnectorEditPart) {
			return ((LogMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EnrichMediatorOutputConnectorEditPart) {
			return ((EnrichMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof XSLTMediatorOutputConnectorEditPart) {
			return ((XSLTMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SwitchMediatorOutputConnectorEditPart) {
			return ((SwitchMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SwitchCaseBranchOutputConnectorEditPart) {
			return ((SwitchCaseBranchOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SwitchDefaultBranchOutputConnectorEditPart) {
			return ((SwitchDefaultBranchOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SequenceOutputConnectorEditPart) {
			return ((SequenceOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EventMediatorOutputConnectorEditPart) {
			return ((EventMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EntitlementMediatorOutputConnectorEditPart) {
			return ((EntitlementMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EntitlementMediatorOnRejectOutputConnectorEditPart) {
			return ((EntitlementMediatorOnRejectOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EntitlementMediatorOnAcceptOutputConnectorEditPart) {
			return ((EntitlementMediatorOnAcceptOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EntitlementMediatorAdviceOutputConnectorEditPart) {
			return ((EntitlementMediatorAdviceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EntitlementMediatorObligationsOutputConnectorEditPart) {
			return ((EntitlementMediatorObligationsOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ClassMediatorOutputConnectorEditPart) {
			return ((ClassMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SpringMediatorOutputConnectorEditPart) {
			return ((SpringMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ScriptMediatorOutputConnectorEditPart) {
			return ((ScriptMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FaultMediatorOutputConnectorEditPart) {
			return ((FaultMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof XQueryMediatorOutputConnectorEditPart) {
			return ((XQueryMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommandMediatorOutputConnectorEditPart) {
			return ((CommandMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DBLookupMediatorOutputConnectorEditPart) {
			return ((DBLookupMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DBReportMediatorOutputConnectorEditPart) {
			return ((DBReportMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SmooksMediatorOutputConnectorEditPart) {
			return ((SmooksMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SendMediatorOutputConnectorEditPart) {
			return ((SendMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SendMediatorEndpointOutputConnectorEditPart) {
			return ((SendMediatorEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof HeaderMediatorOutputConnectorEditPart) {
			return ((HeaderMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CloneMediatorOutputConnectorEditPart) {
			return ((CloneMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CloneMediatorTargetOutputConnectorEditPart) {
			return ((CloneMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CacheMediatorOutputConnectorEditPart) {
			return ((CacheMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CacheMediatorOnHitOutputConnectorEditPart) {
			return ((CacheMediatorOnHitOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof IterateMediatorOutputConnectorEditPart) {
			return ((IterateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof IterateMediatorTargetOutputConnectorEditPart) {
			return ((IterateMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CalloutMediatorOutputConnectorEditPart) {
			return ((CalloutMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof TransactionMediatorOutputConnectorEditPart) {
			return ((TransactionMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RMSequenceMediatorOutputConnectorEditPart) {
			return ((RMSequenceMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RuleMediatorOutputConnectorEditPart) {
			return ((RuleMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RuleMediatorChildMediatorsOutputConnectorEditPart) {
			return ((RuleMediatorChildMediatorsOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof OAuthMediatorOutputConnectorEditPart) {
			return ((OAuthMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AggregateMediatorOutputConnectorEditPart) {
			return ((AggregateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AggregateMediatorOnCompleteOutputConnectorEditPart) {
			return ((AggregateMediatorOnCompleteOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StoreMediatorOutputConnectorEditPart) {
			return ((StoreMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof BuilderMediatorOutputConectorEditPart) {
			return ((BuilderMediatorOutputConectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CallTemplateMediatorOutputConnectorEditPart) {
			return ((CallTemplateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PayloadFactoryMediatorOutputConnectorEditPart) {
			return ((PayloadFactoryMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EnqueueMediatorOutputConnectorEditPart) {
			return ((EnqueueMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof URLRewriteMediatorOutputConnectorEditPart) {
			return ((URLRewriteMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ValidateMediatorOutputConnectorEditPart) {
			return ((ValidateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ValidateMediatorOnFailOutputConnectorEditPart) {
			return ((ValidateMediatorOnFailOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RouterMediatorOutputConnectorEditPart) {
			return ((RouterMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RouterMediatorTargetOutputConnectorEditPart) {
			return ((RouterMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConditionalRouterMediatorOutputConnectorEditPart) {
			return ((ConditionalRouterMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConditionalRouterMediatorAdditionalOutputConnectorEditPart) {
			return ((ConditionalRouterMediatorAdditionalOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof BAMMediatorOutputConnectorEditPart) {
			return ((BAMMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof BeanMediatorOutputConnectorEditPart) {
			return ((BeanMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EJBMediatorOutputConnectorEditPart) {
			return ((EJBMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DefaultEndPointOutputConnectorEditPart) {
			return ((DefaultEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AddressEndPointOutputConnectorEditPart) {
			return ((AddressEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FailoverEndPointOutputConnectorEditPart) {
			return ((FailoverEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FailoverEndPointWestOutputConnectorEditPart) {
			return ((FailoverEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RecipientListEndPointOutputConnectorEditPart) {
			return ((RecipientListEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RecipientListEndPointWestOutputConnectorEditPart) {
			return ((RecipientListEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof WSDLEndPointOutputConnectorEditPart) {
			return ((WSDLEndPointOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NamedEndpointOutputConnectorEditPart) {
			return ((NamedEndpointOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoadBalanceEndPointOutputConnectorEditPart) {
			return ((LoadBalanceEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoadBalanceEndPointWestOutputConnectorEditPart) {
			return ((LoadBalanceEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof APIResourceEndpointOutputConnectorEditPart) {
			return ((APIResourceEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AddressingEndpointOutputConnectorEditPart) {
			return ((AddressingEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof HTTPEndPointOutputConnectorEditPart) {
			return ((HTTPEndPointOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof TemplateEndpointOutputConnectorEditPart) {
			return ((TemplateEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CloudConnectorOutputConnectorEditPart) {
			return ((CloudConnectorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CloudConnectorOperationOutputConnectorEditPart) {
			return ((CloudConnectorOperationOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoopBackMediatorOutputConnectorEditPart) {
			return ((LoopBackMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RespondMediatorOutputConnectorEditPart) {
			return ((RespondMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CallMediatorOutputConnectorEditPart) {
			return ((CallMediatorOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CallMediatorEndpointOutputConnectorEditPart) {
			return ((CallMediatorEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof MessageOutputConnectorEditPart) {
			return ((MessageOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof MergeNodeOutputConnectorEditPart) {
			return ((MergeNodeOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SequencesOutputConnectorEditPart) {
			return ((SequencesOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DefaultEndPointOutputConnector2EditPart) {
			return ((DefaultEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof AddressEndPointOutputConnector2EditPart) {
			return ((AddressEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FailoverEndPointOutputConnector2EditPart) {
			return ((FailoverEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FailoverEndPointWestOutputConnector2EditPart) {
			return ((FailoverEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RecipientListEndPointOutputConnector2EditPart) {
			return ((RecipientListEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RecipientListEndPointWestOutputConnector2EditPart) {
			return ((RecipientListEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof WSDLEndPointOutputConnector2EditPart) {
			return ((WSDLEndPointOutputConnector2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoadBalanceEndPointOutputConnector2EditPart) {
			return ((LoadBalanceEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoadBalanceEndPointWestOutputConnector2EditPart) {
			return ((LoadBalanceEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof HTTPEndPointOutputConnector2EditPart) {
			return ((HTTPEndPointOutputConnector2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof TemplateEndpointOutputConnector2EditPart) {
			return ((TemplateEndpointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof APIResourceOutputConnectorEditPart) {
			return ((APIResourceOutputConnectorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof APIResourceOutSequenceOutputConnectorEditPart) {
			return ((APIResourceOutSequenceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ComplexEndpointsOutputConnectorEditPart) {
			return ((ComplexEndpointsOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ProxyInputConnectorEditPart) {
			return ((ProxyInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ProxyFaultInputConnectorEditPart) {
			return ((ProxyFaultInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DropMediatorInputConnectorEditPart) {
			return ((DropMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PropertyMediatorInputConnectorEditPart) {
			return ((PropertyMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ThrottleMediatorInputConnectorEditPart) {
			return ((ThrottleMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FilterMediatorInputConnectorEditPart) {
			return ((FilterMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LogMediatorInputConnectorEditPart) {
			return ((LogMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EnrichMediatorInputConnectorEditPart) {
			return ((EnrichMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof XSLTMediatorInputConnectorEditPart) {
			return ((XSLTMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SwitchMediatorInputConnectorEditPart) {
			return ((SwitchMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SequenceInputConnectorEditPart) {
			return ((SequenceInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EventMediatorInputConnectorEditPart) {
			return ((EventMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EntitlementMediatorInputConnectorEditPart) {
			return ((EntitlementMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ClassMediatorInputConnectorEditPart) {
			return ((ClassMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SpringMediatorInputConnectorEditPart) {
			return ((SpringMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ScriptMediatorInputConnectorEditPart) {
			return ((ScriptMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FaultMediatorInputConnectorEditPart) {
			return ((FaultMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof XQueryMediatorInputConnectorEditPart) {
			return ((XQueryMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommandMediatorInputConnectorEditPart) {
			return ((CommandMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DBLookupMediatorInputConnectorEditPart) {
			return ((DBLookupMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DBReportMediatorInputConnectorEditPart) {
			return ((DBReportMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SmooksMediatorInputConnectorEditPart) {
			return ((SmooksMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SendMediatorInputConnectorEditPart) {
			return ((SendMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof HeaderMediatorInputConnectorEditPart) {
			return ((HeaderMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CloneMediatorInputConnectorEditPart) {
			return ((CloneMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CacheMediatorInputConnectorEditPart) {
			return ((CacheMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof IterateMediatorInputConnectorEditPart) {
			return ((IterateMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CalloutMediatorInputConnectorEditPart) {
			return ((CalloutMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof TransactionMediatorInputConnectorEditPart) {
			return ((TransactionMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RMSequenceMediatorInputConnectorEditPart) {
			return ((RMSequenceMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RuleMediatorInputConnectorEditPart) {
			return ((RuleMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof OAuthMediatorInputConnectorEditPart) {
			return ((OAuthMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AggregateMediatorInputConnectorEditPart) {
			return ((AggregateMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StoreMediatorInputConnectorEditPart) {
			return ((StoreMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof BuilderMediatorInputConnectorEditPart) {
			return ((BuilderMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CallTemplateMediatorInputConnectorEditPart) {
			return ((CallTemplateMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PayloadFactoryMediatorInputConnectorEditPart) {
			return ((PayloadFactoryMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EnqueueMediatorInputConnectorEditPart) {
			return ((EnqueueMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof URLRewriteMediatorInputConnectorEditPart) {
			return ((URLRewriteMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ValidateMediatorInputConnectorEditPart) {
			return ((ValidateMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RouterMediatorInputConnectorEditPart) {
			return ((RouterMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ConditionalRouterMediatorInputConnectorEditPart) {
			return ((ConditionalRouterMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof BAMMediatorInputConnectorEditPart) {
			return ((BAMMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof BeanMediatorInputConnectorEditPart) {
			return ((BeanMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EJBMediatorInputConnectorEditPart) {
			return ((EJBMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DefaultEndPointInputConnectorEditPart) {
			return ((DefaultEndPointInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AddressEndPointInputConnectorEditPart) {
			return ((AddressEndPointInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FailoverEndPointInputConnectorEditPart) {
			return ((FailoverEndPointInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RecipientListEndPointInputConnectorEditPart) {
			return ((RecipientListEndPointInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof WSDLEndPointInputConnectorEditPart) {
			return ((WSDLEndPointInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof NamedEndpointInputConnectorEditPart) {
			return ((NamedEndpointInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LoadBalanceEndPointInputConnectorEditPart) {
			return ((LoadBalanceEndPointInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof APIResourceEndpointInputConnectorEditPart) {
			return ((APIResourceEndpointInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AddressingEndpointInputConnectorEditPart) {
			return ((AddressingEndpointInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof HTTPEndPointInputConnectorEditPart) {
			return ((HTTPEndPointInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof TemplateEndpointInputConnectorEditPart) {
			return ((TemplateEndpointInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CloudConnectorInputConnectorEditPart) {
			return ((CloudConnectorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CloudConnectorOperationInputConnectorEditPart) {
			return ((CloudConnectorOperationInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LoopBackMediatorInputConnectorEditPart) {
			return ((LoopBackMediatorInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RespondMediatorInputConnectorEditPart) {
			return ((RespondMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CallMediatorInputConnectorEditPart) {
			return ((CallMediatorInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ProxyInSequenceInputConnectorEditPart) {
			return ((ProxyInSequenceInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof MessageInputConnectorEditPart) {
			return ((MessageInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof MergeNodeFirstInputConnectorEditPart) {
			return ((MergeNodeFirstInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof MergeNodeSecondInputConnectorEditPart) {
			return ((MergeNodeSecondInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SequencesInputConnectorEditPart) {
			return ((SequencesInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DefaultEndPointInputConnector2EditPart) {
			return ((DefaultEndPointInputConnector2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AddressEndPointInputConnector2EditPart) {
			return ((AddressEndPointInputConnector2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FailoverEndPointInputConnector2EditPart) {
			return ((FailoverEndPointInputConnector2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RecipientListEndPointInputConnector2EditPart) {
			return ((RecipientListEndPointInputConnector2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof WSDLEndPointInputConnector2EditPart) {
			return ((WSDLEndPointInputConnector2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LoadBalanceEndPointInputConnector2EditPart) {
			return ((LoadBalanceEndPointInputConnector2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof HTTPEndPointInputConnector2EditPart) {
			return ((HTTPEndPointInputConnector2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof TemplateEndpointInputConnector2EditPart) {
			return ((TemplateEndpointInputConnector2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof APIResourceInputConnectorEditPart) {
			return ((APIResourceInputConnectorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof APIResourceFaultInputConnectorEditPart) {
			return ((APIResourceFaultInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof APIResourceInSequenceInputConnectorEditPart) {
			return ((APIResourceInSequenceInputConnectorEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ProxyOutputConnectorEditPart) {
			return ((ProxyOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ProxyOutSequenceOutputConnectorEditPart) {
			return ((ProxyOutSequenceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PropertyMediatorOutputConnectorEditPart) {
			return ((PropertyMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ThrottleMediatorOutputConnectorEditPart) {
			return ((ThrottleMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ThrottleMediatorOnAcceptOutputConnectorEditPart) {
			return ((ThrottleMediatorOnAcceptOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ThrottleMediatorOnRejectOutputConnectorEditPart) {
			return ((ThrottleMediatorOnRejectOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FilterMediatorOutputConnectorEditPart) {
			return ((FilterMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FilterMediatorPassOutputConnectorEditPart) {
			return ((FilterMediatorPassOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FilterMediatorFailOutputConnectorEditPart) {
			return ((FilterMediatorFailOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LogMediatorOutputConnectorEditPart) {
			return ((LogMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EnrichMediatorOutputConnectorEditPart) {
			return ((EnrichMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof XSLTMediatorOutputConnectorEditPart) {
			return ((XSLTMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SwitchMediatorOutputConnectorEditPart) {
			return ((SwitchMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SwitchCaseBranchOutputConnectorEditPart) {
			return ((SwitchCaseBranchOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SwitchDefaultBranchOutputConnectorEditPart) {
			return ((SwitchDefaultBranchOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SequenceOutputConnectorEditPart) {
			return ((SequenceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EventMediatorOutputConnectorEditPart) {
			return ((EventMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EntitlementMediatorOutputConnectorEditPart) {
			return ((EntitlementMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EntitlementMediatorOnRejectOutputConnectorEditPart) {
			return ((EntitlementMediatorOnRejectOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EntitlementMediatorOnAcceptOutputConnectorEditPart) {
			return ((EntitlementMediatorOnAcceptOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EntitlementMediatorAdviceOutputConnectorEditPart) {
			return ((EntitlementMediatorAdviceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EntitlementMediatorObligationsOutputConnectorEditPart) {
			return ((EntitlementMediatorObligationsOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ClassMediatorOutputConnectorEditPart) {
			return ((ClassMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SpringMediatorOutputConnectorEditPart) {
			return ((SpringMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ScriptMediatorOutputConnectorEditPart) {
			return ((ScriptMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FaultMediatorOutputConnectorEditPart) {
			return ((FaultMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof XQueryMediatorOutputConnectorEditPart) {
			return ((XQueryMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommandMediatorOutputConnectorEditPart) {
			return ((CommandMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DBLookupMediatorOutputConnectorEditPart) {
			return ((DBLookupMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DBReportMediatorOutputConnectorEditPart) {
			return ((DBReportMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SmooksMediatorOutputConnectorEditPart) {
			return ((SmooksMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SendMediatorOutputConnectorEditPart) {
			return ((SendMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SendMediatorEndpointOutputConnectorEditPart) {
			return ((SendMediatorEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof HeaderMediatorOutputConnectorEditPart) {
			return ((HeaderMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CloneMediatorOutputConnectorEditPart) {
			return ((CloneMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CloneMediatorTargetOutputConnectorEditPart) {
			return ((CloneMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CacheMediatorOutputConnectorEditPart) {
			return ((CacheMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CacheMediatorOnHitOutputConnectorEditPart) {
			return ((CacheMediatorOnHitOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof IterateMediatorOutputConnectorEditPart) {
			return ((IterateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof IterateMediatorTargetOutputConnectorEditPart) {
			return ((IterateMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CalloutMediatorOutputConnectorEditPart) {
			return ((CalloutMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof TransactionMediatorOutputConnectorEditPart) {
			return ((TransactionMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RMSequenceMediatorOutputConnectorEditPart) {
			return ((RMSequenceMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RuleMediatorOutputConnectorEditPart) {
			return ((RuleMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RuleMediatorChildMediatorsOutputConnectorEditPart) {
			return ((RuleMediatorChildMediatorsOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof OAuthMediatorOutputConnectorEditPart) {
			return ((OAuthMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AggregateMediatorOutputConnectorEditPart) {
			return ((AggregateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AggregateMediatorOnCompleteOutputConnectorEditPart) {
			return ((AggregateMediatorOnCompleteOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StoreMediatorOutputConnectorEditPart) {
			return ((StoreMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof BuilderMediatorOutputConectorEditPart) {
			return ((BuilderMediatorOutputConectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CallTemplateMediatorOutputConnectorEditPart) {
			return ((CallTemplateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PayloadFactoryMediatorOutputConnectorEditPart) {
			return ((PayloadFactoryMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EnqueueMediatorOutputConnectorEditPart) {
			return ((EnqueueMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof URLRewriteMediatorOutputConnectorEditPart) {
			return ((URLRewriteMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ValidateMediatorOutputConnectorEditPart) {
			return ((ValidateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ValidateMediatorOnFailOutputConnectorEditPart) {
			return ((ValidateMediatorOnFailOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RouterMediatorOutputConnectorEditPart) {
			return ((RouterMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RouterMediatorTargetOutputConnectorEditPart) {
			return ((RouterMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ConditionalRouterMediatorOutputConnectorEditPart) {
			return ((ConditionalRouterMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ConditionalRouterMediatorAdditionalOutputConnectorEditPart) {
			return ((ConditionalRouterMediatorAdditionalOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof BAMMediatorOutputConnectorEditPart) {
			return ((BAMMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof BeanMediatorOutputConnectorEditPart) {
			return ((BeanMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EJBMediatorOutputConnectorEditPart) {
			return ((EJBMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DefaultEndPointOutputConnectorEditPart) {
			return ((DefaultEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AddressEndPointOutputConnectorEditPart) {
			return ((AddressEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FailoverEndPointOutputConnectorEditPart) {
			return ((FailoverEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FailoverEndPointWestOutputConnectorEditPart) {
			return ((FailoverEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RecipientListEndPointOutputConnectorEditPart) {
			return ((RecipientListEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RecipientListEndPointWestOutputConnectorEditPart) {
			return ((RecipientListEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof WSDLEndPointOutputConnectorEditPart) {
			return ((WSDLEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NamedEndpointOutputConnectorEditPart) {
			return ((NamedEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointOutputConnectorEditPart) {
			return ((LoadBalanceEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointWestOutputConnectorEditPart) {
			return ((LoadBalanceEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof APIResourceEndpointOutputConnectorEditPart) {
			return ((APIResourceEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AddressingEndpointOutputConnectorEditPart) {
			return ((AddressingEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof HTTPEndPointOutputConnectorEditPart) {
			return ((HTTPEndPointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof TemplateEndpointOutputConnectorEditPart) {
			return ((TemplateEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CloudConnectorOutputConnectorEditPart) {
			return ((CloudConnectorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CloudConnectorOperationOutputConnectorEditPart) {
			return ((CloudConnectorOperationOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoopBackMediatorOutputConnectorEditPart) {
			return ((LoopBackMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RespondMediatorOutputConnectorEditPart) {
			return ((RespondMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CallMediatorOutputConnectorEditPart) {
			return ((CallMediatorOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CallMediatorEndpointOutputConnectorEditPart) {
			return ((CallMediatorEndpointOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof MessageOutputConnectorEditPart) {
			return ((MessageOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof MergeNodeOutputConnectorEditPart) {
			return ((MergeNodeOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SequencesOutputConnectorEditPart) {
			return ((SequencesOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DefaultEndPointOutputConnector2EditPart) {
			return ((DefaultEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof AddressEndPointOutputConnector2EditPart) {
			return ((AddressEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FailoverEndPointOutputConnector2EditPart) {
			return ((FailoverEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FailoverEndPointWestOutputConnector2EditPart) {
			return ((FailoverEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RecipientListEndPointOutputConnector2EditPart) {
			return ((RecipientListEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RecipientListEndPointWestOutputConnector2EditPart) {
			return ((RecipientListEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof WSDLEndPointOutputConnector2EditPart) {
			return ((WSDLEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointOutputConnector2EditPart) {
			return ((LoadBalanceEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointWestOutputConnector2EditPart) {
			return ((LoadBalanceEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof HTTPEndPointOutputConnector2EditPart) {
			return ((HTTPEndPointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof TemplateEndpointOutputConnector2EditPart) {
			return ((TemplateEndpointOutputConnector2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof APIResourceOutputConnectorEditPart) {
			return ((APIResourceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof APIResourceOutSequenceOutputConnectorEditPart) {
			return ((APIResourceOutSequenceOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ComplexEndpointsOutputConnectorEditPart) {
			return ((ComplexEndpointsOutputConnectorEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ProxyInputConnectorEditPart) {
			return ((ProxyInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ProxyFaultInputConnectorEditPart) {
			return ((ProxyFaultInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DropMediatorInputConnectorEditPart) {
			return ((DropMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PropertyMediatorInputConnectorEditPart) {
			return ((PropertyMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ThrottleMediatorInputConnectorEditPart) {
			return ((ThrottleMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FilterMediatorInputConnectorEditPart) {
			return ((FilterMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LogMediatorInputConnectorEditPart) {
			return ((LogMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EnrichMediatorInputConnectorEditPart) {
			return ((EnrichMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof XSLTMediatorInputConnectorEditPart) {
			return ((XSLTMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SwitchMediatorInputConnectorEditPart) {
			return ((SwitchMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SequenceInputConnectorEditPart) {
			return ((SequenceInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EventMediatorInputConnectorEditPart) {
			return ((EventMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EntitlementMediatorInputConnectorEditPart) {
			return ((EntitlementMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ClassMediatorInputConnectorEditPart) {
			return ((ClassMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SpringMediatorInputConnectorEditPart) {
			return ((SpringMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ScriptMediatorInputConnectorEditPart) {
			return ((ScriptMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FaultMediatorInputConnectorEditPart) {
			return ((FaultMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof XQueryMediatorInputConnectorEditPart) {
			return ((XQueryMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommandMediatorInputConnectorEditPart) {
			return ((CommandMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DBLookupMediatorInputConnectorEditPart) {
			return ((DBLookupMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DBReportMediatorInputConnectorEditPart) {
			return ((DBReportMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SmooksMediatorInputConnectorEditPart) {
			return ((SmooksMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SendMediatorInputConnectorEditPart) {
			return ((SendMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof HeaderMediatorInputConnectorEditPart) {
			return ((HeaderMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CloneMediatorInputConnectorEditPart) {
			return ((CloneMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CacheMediatorInputConnectorEditPart) {
			return ((CacheMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof IterateMediatorInputConnectorEditPart) {
			return ((IterateMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CalloutMediatorInputConnectorEditPart) {
			return ((CalloutMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof TransactionMediatorInputConnectorEditPart) {
			return ((TransactionMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RMSequenceMediatorInputConnectorEditPart) {
			return ((RMSequenceMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RuleMediatorInputConnectorEditPart) {
			return ((RuleMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof OAuthMediatorInputConnectorEditPart) {
			return ((OAuthMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AggregateMediatorInputConnectorEditPart) {
			return ((AggregateMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StoreMediatorInputConnectorEditPart) {
			return ((StoreMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof BuilderMediatorInputConnectorEditPart) {
			return ((BuilderMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CallTemplateMediatorInputConnectorEditPart) {
			return ((CallTemplateMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PayloadFactoryMediatorInputConnectorEditPart) {
			return ((PayloadFactoryMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EnqueueMediatorInputConnectorEditPart) {
			return ((EnqueueMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof URLRewriteMediatorInputConnectorEditPart) {
			return ((URLRewriteMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ValidateMediatorInputConnectorEditPart) {
			return ((ValidateMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RouterMediatorInputConnectorEditPart) {
			return ((RouterMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ConditionalRouterMediatorInputConnectorEditPart) {
			return ((ConditionalRouterMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof BAMMediatorInputConnectorEditPart) {
			return ((BAMMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof BeanMediatorInputConnectorEditPart) {
			return ((BeanMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EJBMediatorInputConnectorEditPart) {
			return ((EJBMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DefaultEndPointInputConnectorEditPart) {
			return ((DefaultEndPointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AddressEndPointInputConnectorEditPart) {
			return ((AddressEndPointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FailoverEndPointInputConnectorEditPart) {
			return ((FailoverEndPointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RecipientListEndPointInputConnectorEditPart) {
			return ((RecipientListEndPointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof WSDLEndPointInputConnectorEditPart) {
			return ((WSDLEndPointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof NamedEndpointInputConnectorEditPart) {
			return ((NamedEndpointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LoadBalanceEndPointInputConnectorEditPart) {
			return ((LoadBalanceEndPointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof APIResourceEndpointInputConnectorEditPart) {
			return ((APIResourceEndpointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AddressingEndpointInputConnectorEditPart) {
			return ((AddressingEndpointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof HTTPEndPointInputConnectorEditPart) {
			return ((HTTPEndPointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof TemplateEndpointInputConnectorEditPart) {
			return ((TemplateEndpointInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CloudConnectorInputConnectorEditPart) {
			return ((CloudConnectorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CloudConnectorOperationInputConnectorEditPart) {
			return ((CloudConnectorOperationInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LoopBackMediatorInputConnectorEditPart) {
			return ((LoopBackMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RespondMediatorInputConnectorEditPart) {
			return ((RespondMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CallMediatorInputConnectorEditPart) {
			return ((CallMediatorInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ProxyInSequenceInputConnectorEditPart) {
			return ((ProxyInSequenceInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof MessageInputConnectorEditPart) {
			return ((MessageInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof MergeNodeFirstInputConnectorEditPart) {
			return ((MergeNodeFirstInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof MergeNodeSecondInputConnectorEditPart) {
			return ((MergeNodeSecondInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SequencesInputConnectorEditPart) {
			return ((SequencesInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DefaultEndPointInputConnector2EditPart) {
			return ((DefaultEndPointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AddressEndPointInputConnector2EditPart) {
			return ((AddressEndPointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FailoverEndPointInputConnector2EditPart) {
			return ((FailoverEndPointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RecipientListEndPointInputConnector2EditPart) {
			return ((RecipientListEndPointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof WSDLEndPointInputConnector2EditPart) {
			return ((WSDLEndPointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LoadBalanceEndPointInputConnector2EditPart) {
			return ((LoadBalanceEndPointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof HTTPEndPointInputConnector2EditPart) {
			return ((HTTPEndPointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof TemplateEndpointInputConnector2EditPart) {
			return ((TemplateEndpointInputConnector2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof APIResourceInputConnectorEditPart) {
			return ((APIResourceInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof APIResourceFaultInputConnectorEditPart) {
			return ((APIResourceFaultInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof APIResourceInSequenceInputConnectorEditPart) {
			return ((APIResourceInSequenceInputConnectorEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ProxyOutputConnectorEditPart) {
			return ((ProxyOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ProxyOutSequenceOutputConnectorEditPart) {
			return ((ProxyOutSequenceOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PropertyMediatorOutputConnectorEditPart) {
			return ((PropertyMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ThrottleMediatorOutputConnectorEditPart) {
			return ((ThrottleMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ThrottleMediatorOnAcceptOutputConnectorEditPart) {
			return ((ThrottleMediatorOnAcceptOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ThrottleMediatorOnRejectOutputConnectorEditPart) {
			return ((ThrottleMediatorOnRejectOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FilterMediatorOutputConnectorEditPart) {
			return ((FilterMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FilterMediatorPassOutputConnectorEditPart) {
			return ((FilterMediatorPassOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FilterMediatorFailOutputConnectorEditPart) {
			return ((FilterMediatorFailOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LogMediatorOutputConnectorEditPart) {
			return ((LogMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EnrichMediatorOutputConnectorEditPart) {
			return ((EnrichMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof XSLTMediatorOutputConnectorEditPart) {
			return ((XSLTMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SwitchMediatorOutputConnectorEditPart) {
			return ((SwitchMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SwitchCaseBranchOutputConnectorEditPart) {
			return ((SwitchCaseBranchOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SwitchDefaultBranchOutputConnectorEditPart) {
			return ((SwitchDefaultBranchOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SequenceOutputConnectorEditPart) {
			return ((SequenceOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EventMediatorOutputConnectorEditPart) {
			return ((EventMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EntitlementMediatorOutputConnectorEditPart) {
			return ((EntitlementMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EntitlementMediatorOnRejectOutputConnectorEditPart) {
			return ((EntitlementMediatorOnRejectOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EntitlementMediatorOnAcceptOutputConnectorEditPart) {
			return ((EntitlementMediatorOnAcceptOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EntitlementMediatorAdviceOutputConnectorEditPart) {
			return ((EntitlementMediatorAdviceOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EntitlementMediatorObligationsOutputConnectorEditPart) {
			return ((EntitlementMediatorObligationsOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ClassMediatorOutputConnectorEditPart) {
			return ((ClassMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SpringMediatorOutputConnectorEditPart) {
			return ((SpringMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ScriptMediatorOutputConnectorEditPart) {
			return ((ScriptMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FaultMediatorOutputConnectorEditPart) {
			return ((FaultMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof XQueryMediatorOutputConnectorEditPart) {
			return ((XQueryMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommandMediatorOutputConnectorEditPart) {
			return ((CommandMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DBLookupMediatorOutputConnectorEditPart) {
			return ((DBLookupMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DBReportMediatorOutputConnectorEditPart) {
			return ((DBReportMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SmooksMediatorOutputConnectorEditPart) {
			return ((SmooksMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SendMediatorOutputConnectorEditPart) {
			return ((SendMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SendMediatorEndpointOutputConnectorEditPart) {
			return ((SendMediatorEndpointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof HeaderMediatorOutputConnectorEditPart) {
			return ((HeaderMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CloneMediatorOutputConnectorEditPart) {
			return ((CloneMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CloneMediatorTargetOutputConnectorEditPart) {
			return ((CloneMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CacheMediatorOutputConnectorEditPart) {
			return ((CacheMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CacheMediatorOnHitOutputConnectorEditPart) {
			return ((CacheMediatorOnHitOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof IterateMediatorOutputConnectorEditPart) {
			return ((IterateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof IterateMediatorTargetOutputConnectorEditPart) {
			return ((IterateMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CalloutMediatorOutputConnectorEditPart) {
			return ((CalloutMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof TransactionMediatorOutputConnectorEditPart) {
			return ((TransactionMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RMSequenceMediatorOutputConnectorEditPart) {
			return ((RMSequenceMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RuleMediatorOutputConnectorEditPart) {
			return ((RuleMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RuleMediatorChildMediatorsOutputConnectorEditPart) {
			return ((RuleMediatorChildMediatorsOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof OAuthMediatorOutputConnectorEditPart) {
			return ((OAuthMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AggregateMediatorOutputConnectorEditPart) {
			return ((AggregateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AggregateMediatorOnCompleteOutputConnectorEditPart) {
			return ((AggregateMediatorOnCompleteOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StoreMediatorOutputConnectorEditPart) {
			return ((StoreMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof BuilderMediatorOutputConectorEditPart) {
			return ((BuilderMediatorOutputConectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CallTemplateMediatorOutputConnectorEditPart) {
			return ((CallTemplateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PayloadFactoryMediatorOutputConnectorEditPart) {
			return ((PayloadFactoryMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EnqueueMediatorOutputConnectorEditPart) {
			return ((EnqueueMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof URLRewriteMediatorOutputConnectorEditPart) {
			return ((URLRewriteMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ValidateMediatorOutputConnectorEditPart) {
			return ((ValidateMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ValidateMediatorOnFailOutputConnectorEditPart) {
			return ((ValidateMediatorOnFailOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RouterMediatorOutputConnectorEditPart) {
			return ((RouterMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RouterMediatorTargetOutputConnectorEditPart) {
			return ((RouterMediatorTargetOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ConditionalRouterMediatorOutputConnectorEditPart) {
			return ((ConditionalRouterMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ConditionalRouterMediatorAdditionalOutputConnectorEditPart) {
			return ((ConditionalRouterMediatorAdditionalOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof BAMMediatorOutputConnectorEditPart) {
			return ((BAMMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof BeanMediatorOutputConnectorEditPart) {
			return ((BeanMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EJBMediatorOutputConnectorEditPart) {
			return ((EJBMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DefaultEndPointOutputConnectorEditPart) {
			return ((DefaultEndPointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AddressEndPointOutputConnectorEditPart) {
			return ((AddressEndPointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FailoverEndPointOutputConnectorEditPart) {
			return ((FailoverEndPointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FailoverEndPointWestOutputConnectorEditPart) {
			return ((FailoverEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RecipientListEndPointOutputConnectorEditPart) {
			return ((RecipientListEndPointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RecipientListEndPointWestOutputConnectorEditPart) {
			return ((RecipientListEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof WSDLEndPointOutputConnectorEditPart) {
			return ((WSDLEndPointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NamedEndpointOutputConnectorEditPart) {
			return ((NamedEndpointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointOutputConnectorEditPart) {
			return ((LoadBalanceEndPointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointWestOutputConnectorEditPart) {
			return ((LoadBalanceEndPointWestOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof APIResourceEndpointOutputConnectorEditPart) {
			return ((APIResourceEndpointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AddressingEndpointOutputConnectorEditPart) {
			return ((AddressingEndpointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof HTTPEndPointOutputConnectorEditPart) {
			return ((HTTPEndPointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof TemplateEndpointOutputConnectorEditPart) {
			return ((TemplateEndpointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CloudConnectorOutputConnectorEditPart) {
			return ((CloudConnectorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CloudConnectorOperationOutputConnectorEditPart) {
			return ((CloudConnectorOperationOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoopBackMediatorOutputConnectorEditPart) {
			return ((LoopBackMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RespondMediatorOutputConnectorEditPart) {
			return ((RespondMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CallMediatorOutputConnectorEditPart) {
			return ((CallMediatorOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CallMediatorEndpointOutputConnectorEditPart) {
			return ((CallMediatorEndpointOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof MessageOutputConnectorEditPart) {
			return ((MessageOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof MergeNodeOutputConnectorEditPart) {
			return ((MergeNodeOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SequencesOutputConnectorEditPart) {
			return ((SequencesOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DefaultEndPointOutputConnector2EditPart) {
			return ((DefaultEndPointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof AddressEndPointOutputConnector2EditPart) {
			return ((AddressEndPointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FailoverEndPointOutputConnector2EditPart) {
			return ((FailoverEndPointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FailoverEndPointWestOutputConnector2EditPart) {
			return ((FailoverEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RecipientListEndPointOutputConnector2EditPart) {
			return ((RecipientListEndPointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RecipientListEndPointWestOutputConnector2EditPart) {
			return ((RecipientListEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof WSDLEndPointOutputConnector2EditPart) {
			return ((WSDLEndPointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointOutputConnector2EditPart) {
			return ((LoadBalanceEndPointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoadBalanceEndPointWestOutputConnector2EditPart) {
			return ((LoadBalanceEndPointWestOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof HTTPEndPointOutputConnector2EditPart) {
			return ((HTTPEndPointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof TemplateEndpointOutputConnector2EditPart) {
			return ((TemplateEndpointOutputConnector2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof APIResourceOutputConnectorEditPart) {
			return ((APIResourceOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof APIResourceOutSequenceOutputConnectorEditPart) {
			return ((APIResourceOutSequenceOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ComplexEndpointsOutputConnectorEditPart) {
			return ((ComplexEndpointsOutputConnectorEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(EsbDiagramEditorPlugin
				.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.EsbModelingAssistantProviderMessage);
		dialog.setTitle(Messages.EsbModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
