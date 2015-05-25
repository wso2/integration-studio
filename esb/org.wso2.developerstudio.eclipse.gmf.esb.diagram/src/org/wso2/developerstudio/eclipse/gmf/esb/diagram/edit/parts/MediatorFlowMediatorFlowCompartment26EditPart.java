package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment26CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment26ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated NOT
 */
public class MediatorFlowMediatorFlowCompartment26EditPart extends AbstractMediatorFlowCompartmentEditPart {

	//Inbound Endpoint On Error Sequence
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7053;

	BorderedNodeFigure borderedNodeFigure;

	/**
	 * @generated
	 */
	public MediatorFlowMediatorFlowCompartment26EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	public String getCompartmentName() {
		return "on Error Sequence";
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MediatorFlowMediatorFlowCompartment26ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				EsbVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new MediatorFlowMediatorFlowCompartment26CanonicalEditPolicy());
	}

	protected IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		/*
		 *  Override default border.
		 *  Hide title for fault sequence compartment and
		 *  distinguishes it by different border color. 
		 */
		LineBorder border = new LineBorder(new Color(null, 150, 0, 0), 1, SWT.BORDER_DASH);
		result.setBorder(border);
		result.setToolTip(getCompartmentName());
		return result;
	}

	/*	public ResizableCompartmentFigure getCompartmentFigure() {
	 return (ResizableCompartmentFigure) borderedNodeFigure.getMainFigure();
	 }*/

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	public boolean isSelectable() {
		// TODO This or using ResizableEditpolicy?
		return false;
	}

	public void connectNormally(EditPart child) {
		AbstractBorderItemEditPart inputConnector = null;
		AbstractBorderItemEditPart outputConnector = null;

		if ((child instanceof AbstractMediator) || (child instanceof AbstractEndpoint)) {

			for (int i = 0; i < child.getChildren().size(); ++i) {
				if (child.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
					inputConnector = (AbstractMediatorInputConnectorEditPart) child.getChildren().get(i);
				}
				if (child.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {
					outputConnector = (AbstractMediatorOutputConnectorEditPart) child.getChildren().get(i);
				}
			}

			CompoundCommand cc = new CompoundCommand("Create Link");

			if (inputConnector != null) {

				ShapeNodeEditPart sourceEditPart1 = (AbstractBorderedShapeEditPart) this.getParent().getParent()
						.getParent().getParent();
				AbstractBorderItemEditPart outputConnectorEditPart_ = EditorUtils.getOutputConnector(
						(ShapeNodeEditPart) this.getParent().getParent().getParent().getParent(),
						InboundEndpointOnErrorSequenceOutputConnectorEditPart.class);
				AbstractBorderItemEditPart inputConnectorEditPart_ = EditorUtils.getInputConnector(
						(ShapeNodeEditPart) this.getParent().getParent().getParent().getParent(),
						InboundEndpointOnErrorSequenceInputConnectorEditPart.class);

				ICommand createSubTopicsCmd = new DeferredCreateConnectionViewAndElementCommand(
						new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
								((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(),
								sourceEditPart1.getDiagramPreferencesHint()), new EObjectAdapter(
								(EObject) outputConnectorEditPart_.getModel()), new EObjectAdapter(
								(EObject) (inputConnector).getModel()), sourceEditPart1.getViewer());

				cc.add(new ICommandProxy(createSubTopicsCmd));

				if (outputConnector != null) {
					ICommand createSubTopicsCmd2 = new DeferredCreateConnectionViewAndElementCommand(
							new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
									((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(),
									((ShapeNodeEditPart) outputConnector.getParent()).getDiagramPreferencesHint()),
							new EObjectAdapter((EObject) outputConnector.getModel()), new EObjectAdapter(
									(EObject) (inputConnectorEditPart_).getModel()),
							((ShapeNodeEditPart) outputConnector.getParent()).getViewer());

					//cc.add(new ICommandProxy(createSubTopicsCmd));
					cc.add(new ICommandProxy(createSubTopicsCmd2));
				}

				getDiagramEditDomain().getDiagramCommandStack().execute(cc);
			}
		}
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == EsbElementTypes.DropMediator_3491) {
				return this;
			}
			if (type == EsbElementTypes.PropertyMediator_3492) {
				return this;
			}
			if (type == EsbElementTypes.ThrottleMediator_3493) {
				return this;
			}
			if (type == EsbElementTypes.FilterMediator_3494) {
				return this;
			}
			if (type == EsbElementTypes.LogMediator_3495) {
				return this;
			}
			if (type == EsbElementTypes.EnrichMediator_3496) {
				return this;
			}
			if (type == EsbElementTypes.XSLTMediator_3497) {
				return this;
			}
			if (type == EsbElementTypes.SwitchMediator_3498) {
				return this;
			}
			if (type == EsbElementTypes.Sequence_3503) {
				return this;
			}
			if (type == EsbElementTypes.EventMediator_3504) {
				return this;
			}
			if (type == EsbElementTypes.EntitlementMediator_3505) {
				return this;
			}
			if (type == EsbElementTypes.ClassMediator_3506) {
				return this;
			}
			if (type == EsbElementTypes.SpringMediator_3507) {
				return this;
			}
			if (type == EsbElementTypes.ScriptMediator_3508) {
				return this;
			}
			if (type == EsbElementTypes.FaultMediator_3509) {
				return this;
			}
			if (type == EsbElementTypes.XQueryMediator_3510) {
				return this;
			}
			if (type == EsbElementTypes.CommandMediator_3511) {
				return this;
			}
			if (type == EsbElementTypes.DBLookupMediator_3512) {
				return this;
			}
			if (type == EsbElementTypes.DBReportMediator_3513) {
				return this;
			}
			if (type == EsbElementTypes.SmooksMediator_3514) {
				return this;
			}
			if (type == EsbElementTypes.SendMediator_3515) {
				return this;
			}
			if (type == EsbElementTypes.HeaderMediator_3516) {
				return this;
			}
			if (type == EsbElementTypes.CloneMediator_3517) {
				return this;
			}
			if (type == EsbElementTypes.CacheMediator_3518) {
				return this;
			}
			if (type == EsbElementTypes.IterateMediator_3519) {
				return this;
			}
			if (type == EsbElementTypes.CalloutMediator_3520) {
				return this;
			}
			if (type == EsbElementTypes.TransactionMediator_3521) {
				return this;
			}
			if (type == EsbElementTypes.RMSequenceMediator_3522) {
				return this;
			}
			if (type == EsbElementTypes.RuleMediator_3523) {
				return this;
			}
			if (type == EsbElementTypes.OAuthMediator_3524) {
				return this;
			}
			if (type == EsbElementTypes.AggregateMediator_3525) {
				return this;
			}
			if (type == EsbElementTypes.StoreMediator_3588) {
				return this;
			}
			if (type == EsbElementTypes.BuilderMediator_3591) {
				return this;
			}
			if (type == EsbElementTypes.CallTemplateMediator_3594) {
				return this;
			}
			if (type == EsbElementTypes.PayloadFactoryMediator_3597) {
				return this;
			}
			if (type == EsbElementTypes.EnqueueMediator_3600) {
				return this;
			}
			if (type == EsbElementTypes.URLRewriteMediator_3620) {
				return this;
			}
			if (type == EsbElementTypes.ValidateMediator_3623) {
				return this;
			}
			if (type == EsbElementTypes.RouterMediator_3628) {
				return this;
			}
			if (type == EsbElementTypes.ConditionalRouterMediator_3635) {
				return this;
			}
			if (type == EsbElementTypes.BAMMediator_3680) {
				return this;
			}
			if (type == EsbElementTypes.BeanMediator_3683) {
				return this;
			}
			if (type == EsbElementTypes.EJBMediator_3686) {
				return this;
			}
			if (type == EsbElementTypes.DefaultEndPoint_3609) {
				return this;
			}
			if (type == EsbElementTypes.AddressEndPoint_3610) {
				return this;
			}
			if (type == EsbElementTypes.FailoverEndPoint_3611) {
				return this;
			}
			if (type == EsbElementTypes.RecipientListEndPoint_3692) {
				return this;
			}
			if (type == EsbElementTypes.WSDLEndPoint_3612) {
				return this;
			}
			if (type == EsbElementTypes.NamedEndpoint_3660) {
				return this;
			}
			if (type == EsbElementTypes.LoadBalanceEndPoint_3613) {
				return this;
			}
			if (type == EsbElementTypes.APIResourceEndpoint_3674) {
				return this;
			}
			if (type == EsbElementTypes.AddressingEndpoint_3689) {
				return this;
			}
			if (type == EsbElementTypes.HTTPEndpoint_3709) {
				return this;
			}
			if (type == EsbElementTypes.TemplateEndpoint_3716) {
				return this;
			}
			if (type == EsbElementTypes.CloudConnector_3719) {
				return this;
			}
			if (type == EsbElementTypes.CloudConnectorOperation_3722) {
				return this;
			}
			if (type == EsbElementTypes.LoopBackMediator_3736) {
				return this;
			}
			if (type == EsbElementTypes.RespondMediator_3739) {
				return this;
			}
			if (type == EsbElementTypes.CallMediator_3742) {
				return this;
			}
			if (type == EsbElementTypes.DataMapperMediator_3761) {
				return this;
			}
			if (type == EsbElementTypes.FastXSLTMediator_3764) {
				return this;
			}
			return getParent().getTargetEditPart(request);
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			return getParent().getTargetEditPart(request);
		}
		return super.getTargetEditPart(request);
	}

}
