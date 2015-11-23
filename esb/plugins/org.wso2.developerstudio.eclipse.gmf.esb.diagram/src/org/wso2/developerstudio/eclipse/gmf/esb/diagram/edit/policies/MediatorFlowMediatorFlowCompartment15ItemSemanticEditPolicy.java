package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.APIResourceEndpointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.AddressEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.AddressingEndpointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.AggregateMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.BAMMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.BeanMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.BuilderMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CacheMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CallMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CallTemplateMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CalloutMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ClassMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CloneMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CloudConnectorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CloudConnectorOperationCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.CommandMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ConditionalRouterMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.DBLookupMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.DBReportMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.DataMapperMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.DefaultEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.DropMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.EJBMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.EnqueueMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.EnrichMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.EntitlementMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.EventMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.FailoverEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.FastXSLTMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.FaultMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.FilterMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ForEachMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.HTTPEndpointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.HeaderMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.IterateMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.LoadBalanceEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.LogMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.LoopBackMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.NamedEndpointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.OAuthMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.PayloadFactoryMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.PropertyMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.PublishEventMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.RMSequenceMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.RecipientListEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.RespondMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.RouterMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.RuleMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ScriptMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.SendMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.SequenceCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.SmooksMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.SpringMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.StoreMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.SwitchMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.TemplateEndpointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ThrottleMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.TransactionMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.URLRewriteMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ValidateMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.WSDLEndPointCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.XQueryMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.XSLTMediatorCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class MediatorFlowMediatorFlowCompartment15ItemSemanticEditPolicy extends EsbBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MediatorFlowMediatorFlowCompartment15ItemSemanticEditPolicy() {
		super(EsbElementTypes.MediatorFlow_3634);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EsbElementTypes.DropMediator_3491 == req.getElementType()) {
			return getGEFWrapper(new DropMediatorCreateCommand(req));
		}
		if (EsbElementTypes.PropertyMediator_3492 == req.getElementType()) {
			return getGEFWrapper(new PropertyMediatorCreateCommand(req));
		}
		if (EsbElementTypes.ThrottleMediator_3493 == req.getElementType()) {
			return getGEFWrapper(new ThrottleMediatorCreateCommand(req));
		}
		if (EsbElementTypes.FilterMediator_3494 == req.getElementType()) {
			return getGEFWrapper(new FilterMediatorCreateCommand(req));
		}
		if (EsbElementTypes.LogMediator_3495 == req.getElementType()) {
			return getGEFWrapper(new LogMediatorCreateCommand(req));
		}
		if (EsbElementTypes.EnrichMediator_3496 == req.getElementType()) {
			return getGEFWrapper(new EnrichMediatorCreateCommand(req));
		}
		if (EsbElementTypes.XSLTMediator_3497 == req.getElementType()) {
			return getGEFWrapper(new XSLTMediatorCreateCommand(req));
		}
		if (EsbElementTypes.SwitchMediator_3498 == req.getElementType()) {
			return getGEFWrapper(new SwitchMediatorCreateCommand(req));
		}
		if (EsbElementTypes.Sequence_3503 == req.getElementType()) {
			return getGEFWrapper(new SequenceCreateCommand(req));
		}
		if (EsbElementTypes.EventMediator_3504 == req.getElementType()) {
			return getGEFWrapper(new EventMediatorCreateCommand(req));
		}
		if (EsbElementTypes.EntitlementMediator_3505 == req.getElementType()) {
			return getGEFWrapper(new EntitlementMediatorCreateCommand(req));
		}
		if (EsbElementTypes.ClassMediator_3506 == req.getElementType()) {
			return getGEFWrapper(new ClassMediatorCreateCommand(req));
		}
		if (EsbElementTypes.SpringMediator_3507 == req.getElementType()) {
			return getGEFWrapper(new SpringMediatorCreateCommand(req));
		}
		if (EsbElementTypes.ScriptMediator_3508 == req.getElementType()) {
			return getGEFWrapper(new ScriptMediatorCreateCommand(req));
		}
		if (EsbElementTypes.FaultMediator_3509 == req.getElementType()) {
			return getGEFWrapper(new FaultMediatorCreateCommand(req));
		}
		if (EsbElementTypes.XQueryMediator_3510 == req.getElementType()) {
			return getGEFWrapper(new XQueryMediatorCreateCommand(req));
		}
		if (EsbElementTypes.CommandMediator_3511 == req.getElementType()) {
			return getGEFWrapper(new CommandMediatorCreateCommand(req));
		}
		if (EsbElementTypes.DBLookupMediator_3512 == req.getElementType()) {
			return getGEFWrapper(new DBLookupMediatorCreateCommand(req));
		}
		if (EsbElementTypes.DBReportMediator_3513 == req.getElementType()) {
			return getGEFWrapper(new DBReportMediatorCreateCommand(req));
		}
		if (EsbElementTypes.SmooksMediator_3514 == req.getElementType()) {
			return getGEFWrapper(new SmooksMediatorCreateCommand(req));
		}
		if (EsbElementTypes.SendMediator_3515 == req.getElementType()) {
			return getGEFWrapper(new SendMediatorCreateCommand(req));
		}
		if (EsbElementTypes.HeaderMediator_3516 == req.getElementType()) {
			return getGEFWrapper(new HeaderMediatorCreateCommand(req));
		}
		if (EsbElementTypes.CloneMediator_3517 == req.getElementType()) {
			return getGEFWrapper(new CloneMediatorCreateCommand(req));
		}
		if (EsbElementTypes.CacheMediator_3518 == req.getElementType()) {
			return getGEFWrapper(new CacheMediatorCreateCommand(req));
		}
		if (EsbElementTypes.IterateMediator_3519 == req.getElementType()) {
			return getGEFWrapper(new IterateMediatorCreateCommand(req));
		}
		if (EsbElementTypes.CalloutMediator_3520 == req.getElementType()) {
			return getGEFWrapper(new CalloutMediatorCreateCommand(req));
		}
		if (EsbElementTypes.TransactionMediator_3521 == req.getElementType()) {
			return getGEFWrapper(new TransactionMediatorCreateCommand(req));
		}
		if (EsbElementTypes.RMSequenceMediator_3522 == req.getElementType()) {
			return getGEFWrapper(new RMSequenceMediatorCreateCommand(req));
		}
		if (EsbElementTypes.RuleMediator_3523 == req.getElementType()) {
			return getGEFWrapper(new RuleMediatorCreateCommand(req));
		}
		if (EsbElementTypes.OAuthMediator_3524 == req.getElementType()) {
			return getGEFWrapper(new OAuthMediatorCreateCommand(req));
		}
		if (EsbElementTypes.AggregateMediator_3525 == req.getElementType()) {
			return getGEFWrapper(new AggregateMediatorCreateCommand(req));
		}
		if (EsbElementTypes.StoreMediator_3588 == req.getElementType()) {
			return getGEFWrapper(new StoreMediatorCreateCommand(req));
		}
		if (EsbElementTypes.BuilderMediator_3591 == req.getElementType()) {
			return getGEFWrapper(new BuilderMediatorCreateCommand(req));
		}
		if (EsbElementTypes.CallTemplateMediator_3594 == req.getElementType()) {
			return getGEFWrapper(new CallTemplateMediatorCreateCommand(req));
		}
		if (EsbElementTypes.PayloadFactoryMediator_3597 == req.getElementType()) {
			return getGEFWrapper(new PayloadFactoryMediatorCreateCommand(req));
		}
		if (EsbElementTypes.EnqueueMediator_3600 == req.getElementType()) {
			return getGEFWrapper(new EnqueueMediatorCreateCommand(req));
		}
		if (EsbElementTypes.URLRewriteMediator_3620 == req.getElementType()) {
			return getGEFWrapper(new URLRewriteMediatorCreateCommand(req));
		}
		if (EsbElementTypes.ValidateMediator_3623 == req.getElementType()) {
			return getGEFWrapper(new ValidateMediatorCreateCommand(req));
		}
		if (EsbElementTypes.RouterMediator_3628 == req.getElementType()) {
			return getGEFWrapper(new RouterMediatorCreateCommand(req));
		}
		if (EsbElementTypes.ConditionalRouterMediator_3635 == req.getElementType()) {
			return getGEFWrapper(new ConditionalRouterMediatorCreateCommand(req));
		}
		if (EsbElementTypes.BAMMediator_3680 == req.getElementType()) {
			return getGEFWrapper(new BAMMediatorCreateCommand(req));
		}
		if (EsbElementTypes.BeanMediator_3683 == req.getElementType()) {
			return getGEFWrapper(new BeanMediatorCreateCommand(req));
		}
		if (EsbElementTypes.EJBMediator_3686 == req.getElementType()) {
			return getGEFWrapper(new EJBMediatorCreateCommand(req));
		}
		if (EsbElementTypes.DefaultEndPoint_3609 == req.getElementType()) {
			return getGEFWrapper(new DefaultEndPointCreateCommand(req));
		}
		if (EsbElementTypes.AddressEndPoint_3610 == req.getElementType()) {
			return getGEFWrapper(new AddressEndPointCreateCommand(req));
		}
		if (EsbElementTypes.FailoverEndPoint_3611 == req.getElementType()) {
			return getGEFWrapper(new FailoverEndPointCreateCommand(req));
		}
		if (EsbElementTypes.RecipientListEndPoint_3692 == req.getElementType()) {
			return getGEFWrapper(new RecipientListEndPointCreateCommand(req));
		}
		if (EsbElementTypes.WSDLEndPoint_3612 == req.getElementType()) {
			return getGEFWrapper(new WSDLEndPointCreateCommand(req));
		}
		if (EsbElementTypes.NamedEndpoint_3660 == req.getElementType()) {
			return getGEFWrapper(new NamedEndpointCreateCommand(req));
		}
		if (EsbElementTypes.LoadBalanceEndPoint_3613 == req.getElementType()) {
			return getGEFWrapper(new LoadBalanceEndPointCreateCommand(req));
		}
		if (EsbElementTypes.APIResourceEndpoint_3674 == req.getElementType()) {
			return getGEFWrapper(new APIResourceEndpointCreateCommand(req));
		}
		if (EsbElementTypes.AddressingEndpoint_3689 == req.getElementType()) {
			return getGEFWrapper(new AddressingEndpointCreateCommand(req));
		}
		if (EsbElementTypes.HTTPEndpoint_3709 == req.getElementType()) {
			return getGEFWrapper(new HTTPEndpointCreateCommand(req));
		}
		if (EsbElementTypes.TemplateEndpoint_3716 == req.getElementType()) {
			return getGEFWrapper(new TemplateEndpointCreateCommand(req));
		}
		if (EsbElementTypes.CloudConnector_3719 == req.getElementType()) {
			return getGEFWrapper(new CloudConnectorCreateCommand(req));
		}
		if (EsbElementTypes.CloudConnectorOperation_3722 == req.getElementType()) {
			return getGEFWrapper(new CloudConnectorOperationCreateCommand(req));
		}
		if (EsbElementTypes.LoopBackMediator_3736 == req.getElementType()) {
			return getGEFWrapper(new LoopBackMediatorCreateCommand(req));
		}
		if (EsbElementTypes.RespondMediator_3739 == req.getElementType()) {
			return getGEFWrapper(new RespondMediatorCreateCommand(req));
		}
		if (EsbElementTypes.CallMediator_3742 == req.getElementType()) {
			return getGEFWrapper(new CallMediatorCreateCommand(req));
		}
		if (EsbElementTypes.DataMapperMediator_3761 == req.getElementType()) {
			return getGEFWrapper(new DataMapperMediatorCreateCommand(req));
		}
		if (EsbElementTypes.FastXSLTMediator_3764 == req.getElementType()) {
			return getGEFWrapper(new FastXSLTMediatorCreateCommand(req));
		}
		if (EsbElementTypes.ForEachMediator_3780 == req.getElementType()) {
			return getGEFWrapper(new ForEachMediatorCreateCommand(req));
		}
		if (EsbElementTypes.PublishEventMediator_3785 == req.getElementType()) {
			return getGEFWrapper(new PublishEventMediatorCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
