package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpoints;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpointsOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ConnectionUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SlidingBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.connections.ConnectionCalculator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment18CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment18ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;

/**
 * @generated
 */
public class MediatorFlowMediatorFlowCompartment18EditPart extends ShapeCompartmentEditPart {

	BorderedNodeFigure borderedNodeFigure;
	AbstractBorderItemEditPart sourceOutputConnector = null;
	AbstractBorderItemEditPart outputConnectorEditPart = null;
	ShapeNodeEditPart sourceEditPart = null;
	Map<ComplexEndpointsOutputConnector, AbstractEndpoint> connectorAndEndpointMap = new HashMap<ComplexEndpointsOutputConnector, AbstractEndpoint>();
	private ComplexEndpoints complexEndpoints;
	private MediatorFlowMediatorFlowCompartment18EditPart instance;

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7045;

	/**
	 * @generated
	 */
	public MediatorFlowMediatorFlowCompartment18EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	public String getCompartmentName() {
		//return Messages.MediatorFlowMediatorFlowCompartment18EditPart_title;
		return null;
	}

	protected IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(true);
		// Override default border.
		result.setBorder(new MarginBorder(0, 0, 0, 0));
		borderedNodeFigure = new BorderedNodeFigure(result);
		result.setToolTip(getCompartmentName());
		//return result;
		return borderedNodeFigure;
	}

	public ResizableCompartmentFigure getCompartmentFigure() {
		return (ResizableCompartmentFigure) borderedNodeFigure.getMainFigure();
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		if (childEditPart instanceof AbstractEndpoint) {
			addEndpointChildVisual((AbstractEndpoint) childEditPart);
		} else {
			index = Math.min(getContentPane().getChildren().size(), index);
			getContentPane().add(child, index);
		}
	}

	private <T extends AbstractEndpoint> void addEndpointChildVisual(T childEditPart) {
		borderedNodeFigure.getBorderItemContainer().add(
				((T) childEditPart).getFigure(),
				new SlidingBorderItemLocator(borderedNodeFigure.getMainFigure(),
						((T) childEditPart).getFigure(), PositionConstants.EAST, 10, 5));
	}

	protected void removeChildVisual(EditPart child) {
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		if ((child instanceof AbstractEndpoint)) {
			borderedNodeFigure.getBorderItemContainer().remove(childFigure);
		} else {
			getContentPane().remove(childFigure);
		}
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MediatorFlowMediatorFlowCompartment18ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				EsbVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new MediatorFlowMediatorFlowCompartment18CanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	protected void removeChild(EditPart child) {
		super.removeChild(child);
		EditingDomain editingDomain = TransactionUtil.getEditingDomain(complexEndpoints);
		RemoveCommand removeCmd = new RemoveCommand(editingDomain, complexEndpoints,
				EsbPackage.Literals.COMPLEX_ENDPOINTS__OUTPUT_CONNECTOR,
				connectorAndEndpointMap.get(child));
		if (removeCmd.canExecute()) {
			editingDomain.getCommandStack().execute(removeCmd);
		}

		Display.getCurrent().asyncExec(new Runnable() {
			@Override
			public void run() {
				XYRepossition.resizeContainers((IGraphicalEditPart) instance);
			}
		});
	}

	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		/*		((MediatorFlow18EditPart) child.getParent().getParent())
		 .refreshConnector(this.getParent().getParent());*/

		/*		if (this.getParent().getParent().getChildren().size() < 2) {
		 return;
		 }*/

		if (child instanceof AbstractEndpoint) {
			ComplexEndpointsEditPart complexEndpointsEditPart = (ComplexEndpointsEditPart) this
					.getParent().getParent();
			complexEndpoints = (ComplexEndpoints) ((Node) complexEndpointsEditPart.getModel())
					.getElement();
			if (EditorUtils.getEndpointInputConnector((AbstractEndpoint) child)
					.getTargetConnections().size() == 0) {
				addConnectorAndLink(child);
			}
		}

		/*		if (child instanceof FailoverEndPointEditPart) {
		 FailoverEndPointEditPart endpointEditPart = (FailoverEndPointEditPart) child;
		 EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
		 .getModel()).getElement();
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
		 addConnectorAndLink();
		 }
		 }
		 } else if (child instanceof LoadBalanceEndPointEditPart) {
		 LoadBalanceEndPointEditPart endpointEditPart = (LoadBalanceEndPointEditPart) child;
		 EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
		 .getModel()).getElement();
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
		 addConnectorAndLink();
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
		 addConnectorAndLink();
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
		 addConnectorAndLink();
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
		 addConnectorAndLink();
		 }
		 }
		 } else if (child instanceof NamedEndpointEditPart) {
		 NamedEndpointEditPart endpointEditPart = (NamedEndpointEditPart) child;
		 EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
		 .getModel()).getElement();
		 if (((NamedEndpoint) parentEndpoint).getInputConnector()
		 .getIncomingLinks().size() == 0) {
		 if (((NamedEndpoint) parentEndpoint).getOutputConnector() == null) {
		 SetCommand addCmd = new SetCommand(
		 getEditingDomain(),
		 parentEndpoint,
		 EsbPackage.Literals.NAMED_ENDPOINT__OUTPUT_CONNECTOR,
		 EsbFactory.eINSTANCE
		 .createNamedEndpointOutputConnector());
		 if (addCmd.canExecute()) {
		 getEditingDomain().getCommandStack().execute(addCmd);
		 }
		 addConnectorAndLink();
		 }
		 }
		 }*/

	}

	/*	public void connectNormally(EditPart child) {
	 AbstractBorderItemEditPart inputConnector = null;

	 if ((child instanceof AbstractMediator)
	 || (child instanceof AbstractEndpoint)) {

	 for (int i = 0; i < child.getChildren().size(); ++i) {
	 if (child.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
	 inputConnector = (AbstractMediatorInputConnectorEditPart) child
	 .getChildren().get(i);
	 }
	 if (child.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {
	 sourceOutputConnector = (AbstractMediatorOutputConnectorEditPart) child
	 .getChildren().get(i);
	 }
	 if (child.getChildren().get(i) instanceof AbstractEndpointInputConnectorEditPart) {
	 inputConnector = (AbstractEndpointInputConnectorEditPart) child
	 .getChildren().get(i);
	 }
	 if (child.getChildren().get(i) instanceof AbstractEndpointOutputConnectorEditPart) {
	 sourceOutputConnector = (AbstractEndpointOutputConnectorEditPart) child
	 .getChildren().get(i);
	 }

	 }
	 if (outputConnectorEditPart == null) {
	 outputConnectorEditPart = (AbstractOutputConnectorEditPart) this
	 .getParent().getParent().getChildren().get(2);
	 }
	 if (sourceEditPart == null || sourceEditPart.getRoot() == null) {
	 sourceEditPart = (AbstractBorderedShapeEditPart) this
	 .getParent().getParent();
	 }

	 CompoundCommand cc = new CompoundCommand("Create Link");

	 if (inputConnector != null) {
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
	 }

	 outputConnectorEditPart = sourceOutputConnector;
	 sourceEditPart = (ShapeNodeEditPart) child;

	 }
	 }*/

	private void addConnectorAndLink(EditPart child) {
		ComplexEndpointsOutputConnector connector = EsbFactory.eINSTANCE
				.createComplexEndpointsOutputConnector();
		EditingDomain editingDomain = ((IGraphicalEditPart) child).getEditingDomain();
		AddCommand addCmd = new AddCommand(editingDomain, complexEndpoints,
				EsbPackage.Literals.COMPLEX_ENDPOINTS__OUTPUT_CONNECTOR, connector);
		if (addCmd.canExecute()) {
			editingDomain.getCommandStack().execute(addCmd);
			connectorAndEndpointMap.put(connector, (AbstractEndpoint) child);
		}
	}
}
