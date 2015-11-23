/*package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.CustomDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EndpointFlowEndpointCompartment2CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EndpointFlowEndpointCompartment2ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;

*//**
 * @generated
 *//*
public class EndpointFlowEndpointCompartment2EditPart extends
		ShapeCompartmentEditPart {

	*//**
	 * @generated
	 *//*
	public static final int VISUAL_ID = 7029;

	*//**
	 * @generated
	 *//*
	public EndpointFlowEndpointCompartment2EditPart(View view) {
		super(view);
	}

	*//**
	 * @generated
	 *//*
	public String getCompartmentName() {
		return Messages.EndpointFlowEndpointCompartment2EditPart_title;
	}

	*//**
	 * @generated NOT
	 *//*
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new EndpointFlowEndpointCompartment2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new CustomDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new EndpointFlowEndpointCompartment2CanonicalEditPolicy());
	}

	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		// Override default border.
		result.setBorder(new MarginBorder(0, 0, 0, 0));
		result.setToolTip((String) null);
		return result;
	}

	public boolean isSelectable() {
		// TODO This or using ResizableEditpolicy?
		return false;
	}

	*//**
	 * @generated
	 *//*
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		if (child instanceof FailoverEndPointEditPart) {
			FailoverEndPointEditPart endpointEditPart = (FailoverEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((FailoverEndPoint) parentEndpoint).getOutputConnector().size() == 0) {
				TransactionalEditingDomain domain = getEditingDomain();
				for (int i = 0; i < 2; ++i) {
					FailoverEndPointOutputConnector outputConnector = EsbFactory.eINSTANCE
							.createFailoverEndPointOutputConnector();
					AddCommand addCmd = new AddCommand(
							domain,
							parentEndpoint,
							EsbPackage.Literals.FAILOVER_END_POINT__OUTPUT_CONNECTOR,
							outputConnector);
					if (addCmd.canExecute()) {
						domain.getCommandStack().execute(addCmd);
					}
				}
			}
			if (((FailoverEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((FailoverEndPoint) parentEndpoint)
						.getWestOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createFailoverEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof LoadBalanceEndPointEditPart) {
			LoadBalanceEndPointEditPart endpointEditPart = (LoadBalanceEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((LoadBalanceEndPoint) parentEndpoint).getOutputConnector()
					.size() == 0) {
				TransactionalEditingDomain domain = getEditingDomain();
				for (int i = 0; i < 2; ++i) {
					LoadBalanceEndPointOutputConnector outputConnector = EsbFactory.eINSTANCE
							.createLoadBalanceEndPointOutputConnector();
					AddCommand addCmd = new AddCommand(
							domain,
							parentEndpoint,
							EsbPackage.Literals.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR,
							outputConnector);
					if (addCmd.canExecute()) {
						domain.getCommandStack().execute(addCmd);
					}
				}
			}
			if (((LoadBalanceEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((LoadBalanceEndPoint) parentEndpoint)
						.getWestOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createLoadBalanceEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}

		} else if (child instanceof DefaultEndPointEditPart) {
			DefaultEndPointEditPart endpointEditPart = (DefaultEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((DefaultEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((DefaultEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.DEFAULT_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createDefaultEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof AddressEndPointEditPart) {
			AddressEndPointEditPart endpointEditPart = (AddressEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((AddressEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((AddressEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.ADDRESS_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createAddressEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof WSDLEndPointEditPart) {
			WSDLEndPointEditPart endpointEditPart = (WSDLEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((WSDLEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((WSDLEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.WSDL_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createWSDLEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		}

	}

}
*/