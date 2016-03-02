/*package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
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

*//**
 * @generated
 *//*
public class ProxyServiceEndpointContainerEndpointCompartmentEditPart extends
                                                                     ShapeCompartmentEditPart {

	*//**
	 * @generated
	 *//*
	public static final int VISUAL_ID = 7011;

	*//**
	 * @generated
	 *//*
	public ProxyServiceEndpointContainerEndpointCompartmentEditPart(View view) {
		super(view);
	}

	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(true);
		// Override default border.
		result.setBorder(new MarginBorder(0, 0, 0, 0));
		result.setToolTip((String) null);
		result.addMouseMotionListener(new MouseMotionListener() {

			public void mouseMoved(MouseEvent me) {
				// TODO Auto-generated method stub

			}

			public void mouseHover(MouseEvent me) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent me) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent me) {
				// TODO Auto-generated method stub

			}

			public void mouseDragged(MouseEvent me) {
				// TODO Auto-generated method stub

			}
		});

		result.setPreferredSize(new Dimension(getMapMode().DPtoLP(250),
				getMapMode().DPtoLP(130)));

		return result;
	}

	*//**
	 * @generated NOT
	 *//*
	public String getCompartmentName() {
		//return Messages.ProxyServiceEndpointContainerEndpointCompartmentEditPart_title;
		return "EndPoints";
	}

	*//**
	 * @generated 
	 *//*
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
		                  new ProxyServiceEndpointContainerEndpointCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
		                  new ProxyServiceEndpointContainerEndpointCompartmentCanonicalEditPolicy());
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
		if (child instanceof FailoverEndPoint2EditPart) {
			FailoverEndPoint2EditPart endpointEditPart = (FailoverEndPoint2EditPart) child;
			EObject parentEndpoint =
			                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
			if (((FailoverEndPoint) parentEndpoint).getOutputConnector().size() == 0) {
				TransactionalEditingDomain domain = getEditingDomain();
				for (int i = 0; i < 2; ++i) {
					FailoverEndPointOutputConnector outputConnector =
					                                                  EsbFactory.eINSTANCE.createFailoverEndPointOutputConnector();
					AddCommand addCmd =
					                    new AddCommand(
					                                   domain,
					                                   parentEndpoint,
					                                   EsbPackage.Literals.FAILOVER_END_POINT__OUTPUT_CONNECTOR,
					                                   outputConnector);
					if (addCmd.canExecute()) {
						domain.getCommandStack().execute(addCmd);
					}
				}
			}
			if (((FailoverEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((FailoverEndPoint) parentEndpoint).getWestOutputConnector() == null) {
					SetCommand addCmd =
					                    new SetCommand(
					                                   getEditingDomain(),
					                                   parentEndpoint,
					                                   EsbPackage.Literals.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR,
					                                   EsbFactory.eINSTANCE.createFailoverEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof LoadBalanceEndPoint2EditPart) {
			LoadBalanceEndPoint2EditPart endpointEditPart = (LoadBalanceEndPoint2EditPart) child;
			EObject parentEndpoint =
			                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
			if (((LoadBalanceEndPoint) parentEndpoint).getOutputConnector().size() == 0) {
				TransactionalEditingDomain domain = getEditingDomain();
				for (int i = 0; i < 2; ++i) {
					LoadBalanceEndPointOutputConnector outputConnector =
					                                                     EsbFactory.eINSTANCE.createLoadBalanceEndPointOutputConnector();
					AddCommand addCmd =
					                    new AddCommand(
					                                   domain,
					                                   parentEndpoint,
					                                   EsbPackage.Literals.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR,
					                                   outputConnector);
					if (addCmd.canExecute()) {
						domain.getCommandStack().execute(addCmd);
					}
				}
			}
			if (((LoadBalanceEndPoint) parentEndpoint).getInputConnector().getIncomingLinks()
			                                          .size() == 0) {
				if (((LoadBalanceEndPoint) parentEndpoint).getWestOutputConnector() == null) {
					SetCommand addCmd =
					                    new SetCommand(
					                                   getEditingDomain(),
					                                   parentEndpoint,
					                                   EsbPackage.Literals.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR,
					                                   EsbFactory.eINSTANCE.createLoadBalanceEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}

		} else if (child instanceof DefaultEndPoint2EditPart) {
			DefaultEndPoint2EditPart endpointEditPart = (DefaultEndPoint2EditPart) child;
			EObject parentEndpoint =
			                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
			if (((DefaultEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((DefaultEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd =
					                    new SetCommand(
					                                   getEditingDomain(),
					                                   parentEndpoint,
					                                   EsbPackage.Literals.DEFAULT_END_POINT__OUTPUT_CONNECTOR,
					                                   EsbFactory.eINSTANCE.createDefaultEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof AddressEndPoint2EditPart) {
			AddressEndPoint2EditPart endpointEditPart = (AddressEndPoint2EditPart) child;
			EObject parentEndpoint =
			                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
			if (((AddressEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((AddressEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd =
					                    new SetCommand(
					                                   getEditingDomain(),
					                                   parentEndpoint,
					                                   EsbPackage.Literals.ADDRESS_END_POINT__OUTPUT_CONNECTOR,
					                                   EsbFactory.eINSTANCE.createAddressEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof WSDLEndPoint2EditPart) {
			WSDLEndPoint2EditPart endpointEditPart = (WSDLEndPoint2EditPart) child;
			EObject parentEndpoint =
			                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
			if (((WSDLEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((WSDLEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd =
					                    new SetCommand(
					                                   getEditingDomain(),
					                                   parentEndpoint,
					                                   EsbPackage.Literals.WSDL_END_POINT__OUTPUT_CONNECTOR,
					                                   EsbFactory.eINSTANCE.createWSDLEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		}

	}

}
*/