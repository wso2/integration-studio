/*package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.CustomDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.ProxyServiceInSequenceProxyServiceInSequenceCompartmentCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.ProxyServiceInSequenceProxyServiceInSequenceCompartmentItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

*//**
 * @generated
 *//*
public class ProxyServiceInSequenceProxyServiceInSequenceCompartmentEditPart
		extends ShapeCompartmentEditPart {

	*//**
	 * @generated
	 *//*
	public static final int VISUAL_ID = 7005;

	*//**
	 * @generated
	 *//*
	public ProxyServiceInSequenceProxyServiceInSequenceCompartmentEditPart(
			View view) {
		super(view);
	}

	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		// Override default border.
		result.setBorder(new MarginBorder(0, 0, 0, 0));
		result.setToolTip((String) null);

			result.setPreferredSize(new Dimension(getMapMode().DPtoLP(250),
					getMapMode().DPtoLP(130)));

		return result;
	}

	*//**
	 * @generated NOT
	 *//*
	public String getCompartmentName() {
		return Messages.ProxyServiceInSequenceProxyServiceInSequenceCompartmentEditPart_title;
		//return "";
	}

	*//**
	 * @generated NOT
	 *//*
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new ResizableCompartmentEditPolicy());
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new ProxyServiceInSequenceProxyServiceInSequenceCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new CustomDragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new ProxyServiceInSequenceProxyServiceInSequenceCompartmentCanonicalEditPolicy());
	}

	*//**
	 * @generated
	 *//*
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	public boolean isSelectable() {
		// TODO This or using ResizableEditpolicy?
		return false;
	}

	AbstractOutputConnector sourceOutputConnector = null;
	AbstractOutputConnector outputConnectorEditPart = null;
	AbstractBorderedShapeEditPart sourceEditPart = null;

	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		//Refresh connector's position.
		((ProxyServiceInSequenceEditPart)child.getParent().getParent()).refreshOutputConnector(child.getParent().getParent().getParent().getParent().getParent().getParent());
		AbstractInputConnector inputConnector = null;

		if (child instanceof AbstractMediator) {
			AbstractMediator mediator = (AbstractMediator) child;

			for (int i = 0; i < child.getChildren().size(); ++i) {
				if (child.getChildren().get(i) instanceof AbstractInputConnector) {
					inputConnector = (AbstractInputConnector) child
							.getChildren().get(i);
				}
				if (child.getChildren().get(i) instanceof AbstractOutputConnector) {
					sourceOutputConnector = (AbstractOutputConnector) child
							.getChildren().get(i);
				}

			}
			if (outputConnectorEditPart == null) {
				outputConnectorEditPart = ((AbstractOutputConnector) this
						.getParent().getParent().getParent().getParent()
						.getParent().getChildren().get(1));
			}
			if (sourceEditPart == null || sourceEditPart.getRoot() == null) {
				sourceEditPart = (AbstractBorderedShapeEditPart) this
						.getParent().getParent().getParent().getParent()
						.getParent();
			}

			//System.out.println(outputConnectorEditPart.getFigure().getClass());
			//((IFigure)(((IFigure)((IFigure)editPart.getFigure().getChildren().get(0)).getChildren().get(0))).getChildren().get(0)).getChildren().get(1);
			//System.out.println(((IFigure)(((IFigure)((IFigure)editPart.getFigure().getChildren().get(0)).getChildren().get(0))).getChildren().get(0)).getClass());
			//System.out.println(((ProxyServiceEditPart)this.getParent().getParent().getParent()));
			//	(IFigure) ((IFigure) ((IFigure) (IFigure) getFigure().getChildren().get(0)).getChildren().get(0))
			//	.getChildren().get(0)
			//System.out.println("Class parent  "+mediator.getFigure().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getChildren().get(1).getClass());

			CompoundCommand cc = new CompoundCommand("Create Link");

			ICommand createSubTopicsCmd = new DeferredCreateConnectionViewAndElementCommand(
					new CreateConnectionViewAndElementRequest(
							EsbElementTypes.EsbLink_4001,
							((IHintedType) EsbElementTypes.EsbLink_4001)
									.getSemanticHint(),
							sourceEditPart.getDiagramPreferencesHint()),
					new EObjectAdapter((EObject) outputConnectorEditPart
							.getModel()), new EObjectAdapter(
							(EObject) (inputConnector).getModel()),
					sourceEditPart.getViewer());

			cc.add(new ICommandProxy(createSubTopicsCmd));

			getDiagramEditDomain().getDiagramCommandStack().execute(cc);

			outputConnectorEditPart = sourceOutputConnector;
			sourceEditPart = (AbstractBorderedShapeEditPart) child;

		}
			if (child instanceof AbstractMediator) {
				((AbstractMediator) child).Reverse(child);
			}

	}

}
*/