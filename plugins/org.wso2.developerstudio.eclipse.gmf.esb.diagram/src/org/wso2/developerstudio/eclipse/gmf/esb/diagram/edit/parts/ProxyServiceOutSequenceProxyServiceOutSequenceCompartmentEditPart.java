/*package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.CustomDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;

*//**
 * @generated
 *//*
public class ProxyServiceOutSequenceProxyServiceOutSequenceCompartmentEditPart
		extends ShapeCompartmentEditPart {

	*//**
	 * @generated
	 *//*
	public static final int VISUAL_ID = 7006;

	*//**
	 * @generated
	 *//*
	public ProxyServiceOutSequenceProxyServiceOutSequenceCompartmentEditPart(
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
		return Messages.ProxyServiceOutSequenceProxyServiceOutSequenceCompartmentEditPart_title;
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
				new ProxyServiceOutSequenceProxyServiceOutSequenceCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new CustomDragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new ProxyServiceOutSequenceProxyServiceOutSequenceCompartmentCanonicalEditPolicy());
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

	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		//Refresh connector's position. Hardcoded. Should be altered.
		((ProxyServiceOutSequenceEditPart)child.getParent().getParent()).refreshInputConnector(child.getParent().getParent().getParent().getParent().getParent().getParent());
		((ProxyServiceInSequenceEditPart)child.getParent().getParent().getParent().getChildren().get(0)).refreshOutputConnector(child.getParent().getParent().getParent().getParent().getParent().getParent());
		if(((ProxyServiceContainerEditPart)child.getParent().getParent().getParent().getParent().getParent().getParent().getChildren().get(4)).getChildren().size()==2)		
		((ProxyServiceFaultContainerEditPart)((ProxyServiceContainerEditPart)child.getParent().getParent().getParent().getParent().getParent().getParent().getChildren().get(4)).getChildren().get(1)).refreshInputConnector(child.getParent().getParent().getParent().getParent().getParent().getParent());
		
				AbstractInputConnector inputConnector=null;
		 if (child instanceof AbstractMediator) {
		 AbstractMediator mediator=(AbstractMediator)child;
		
		 for(int i=0;i<child.getChildren().size();++i){
		 if(child.getChildren().get(i) instanceof AbstractInputConnector){
		 inputConnector=(AbstractInputConnector)child.getChildren().get(i);
		 }
		 }
		 ProxyServiceEditPart proxyServiceEditPart=(ProxyServiceEditPart)this.getParent().getParent().getParent();
		 ProxyOutputConnectorEditPart outputConnectorEditPart=((ProxyOutputConnectorEditPart)this.getParent().getParent().getParent().getChildren().get(1));
		 System.out.println(outputConnectorEditPart.getFigure().getClass());
		 //((IFigure)(((IFigure)((IFigure)editPart.getFigure().getChildren().get(0)).getChildren().get(0))).getChildren().get(0)).getChildren().get(1);
		 //System.out.println(((IFigure)(((IFigure)((IFigure)editPart.getFigure().getChildren().get(0)).getChildren().get(0))).getChildren().get(0)).getClass());
		 //System.out.println(((ProxyServiceEditPart)this.getParent().getParent().getParent()));
		 //	(IFigure) ((IFigure) ((IFigure) (IFigure) getFigure().getChildren().get(0)).getChildren().get(0))
		 //	.getChildren().get(0)
		 //System.out.println("Class parent  "+mediator.getFigure().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getChildren().get(1).getClass());
		
		 CompoundCommand cc = new CompoundCommand("Create Link");
		
		 ICommand createSubTopicsCmd = new DeferredCreateConnectionViewAndElementCommand(new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
		 ((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(), proxyServiceEditPart.getDiagramPreferencesHint()), new EObjectAdapter((EObject) outputConnectorEditPart.getModel()),
		 new EObjectAdapter((EObject) (inputConnector).getModel()), proxyServiceEditPart.getViewer());

		 cc.add(new ICommandProxy(createSubTopicsCmd));
		
		 getEditDomain().getCommandStack().execute(cc);
		
		 }
		 if (child instanceof AbstractMediator) {
		 ((AbstractMediator) child).Reverse(child);
		 }
		 

	}

}
*/