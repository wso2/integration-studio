package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EastPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.AddressEndPointInputConnector2ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated NOT
 */
public class AddressEndPointInputConnector2EditPart extends AbstractEndpointInputConnectorEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3647;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public AddressEndPointInputConnector2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AddressEndPointInputConnector2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new EastPointerFigure();
	}

	/**
	 * @generated
	 */
	public EastPointerFigure getPrimaryShape() {
		return (EastPointerFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(12, 10);

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShapeForward();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		figure_ = figure;
		createNodeShapeReverse();
		DefaultSizeNodeFigure emptyFigure = new DefaultSizeNodeFigure(0, 0);
		return emptyFigure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(EsbElementTypes.EsbLink_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == EsbElementTypes.EsbLink_4001) {
			types.add(EsbElementTypes.ProxyOutputConnector_3002);
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
			types.add(EsbElementTypes.SwitchCaseBranchOutputConnector_3043);
			types.add(EsbElementTypes.SwitchDefaultBranchOutputConnector_3044);
			types.add(EsbElementTypes.SwitchMediatorOutputConnector_3499);
			types.add(EsbElementTypes.SequenceOutputConnector_3050);
			types.add(EsbElementTypes.EventMediatorOutputConnector_3053);
			types.add(EsbElementTypes.EntitlementMediatorOutputConnector_3056);
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
			types.add(EsbElementTypes.DefaultEndPointOutputConnector_3022);
			types.add(EsbElementTypes.AddressEndPointOutputConnector_3031);
			types.add(EsbElementTypes.FailoverEndPointOutputConnector_3090);
			types.add(EsbElementTypes.FailoverEndPointWestOutputConnector_3097);
			types.add(EsbElementTypes.WSDLEndPointOutputConnector_3093);
			types.add(EsbElementTypes.LoadBalanceEndPointOutputConnector_3096);
			types.add(EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3098);
			types.add(EsbElementTypes.MessageOutputConnector_3047);
			types.add(EsbElementTypes.MergeNodeOutputConnector_3016);
			types.add(EsbElementTypes.SequencesOutputConnector_3617);
			types.add(EsbElementTypes.DefaultEndPointOutputConnector_3645);
			types.add(EsbElementTypes.AddressEndPointOutputConnector_3648);
			types.add(EsbElementTypes.FailoverEndPointOutputConnector_3651);
			types.add(EsbElementTypes.FailoverEndPointWestOutputConnector_3652);
			types.add(EsbElementTypes.WSDLEndPointOutputConnector_3655);
			types.add(EsbElementTypes.LoadBalanceEndPointOutputConnector_3658);
			types.add(EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3659);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class EastPointerFigure extends EastPointerShape {

		/**
		 * @generated
		 */
		public EastPointerFigure() {

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(10)));
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 50, 50, 50);

}
