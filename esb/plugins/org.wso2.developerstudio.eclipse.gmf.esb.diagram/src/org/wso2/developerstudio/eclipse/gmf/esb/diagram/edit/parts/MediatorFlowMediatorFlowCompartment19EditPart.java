package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EndpoinMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment19CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment19ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated NOT
 */
public class MediatorFlowMediatorFlowCompartment19EditPart extends EndpoinMediatorFlowCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7046;

	/**
	 * @generated
	 */
	public MediatorFlowMediatorFlowCompartment19EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MediatorFlowMediatorFlowCompartment19ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				EsbVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new MediatorFlowMediatorFlowCompartment19CanonicalEditPolicy());
	}

	public void connectNormally(EditPart child) {
		if (this.getChildren().size() > 1) {
			deleteExistingEndpointAndLink();
		}
		AbstractBorderItemEditPart inputConnector = null;
		AbstractBorderItemEditPart outputConnector = null;
		ShapeNodeEditPart sourceEditPart = null;

		if ((child instanceof AbstractMediator) || (child instanceof AbstractEndpoint)) {

			inputConnector = EditorUtils.getEndpointInputConnector((ShapeNodeEditPart) child);
			List<EditPart> children = ((SendMediatorEditPart) this.getParent().getParent()).getChildren();
			for (int i = 0; i < children.size(); ++i) {
				if (children.get(i) instanceof SendMediatorEndpointOutputConnectorEditPart) {
					outputConnector = (AbstractBorderItemEditPart) children.get(i);
				}
			}

			sourceEditPart = (ShapeNodeEditPart) this.getParent().getParent();

			CompoundCommand cc = new CompoundCommand("Create Link");

			if (inputConnector != null) {
				ICommand createSubTopicsCmd = new DeferredCreateConnectionViewAndElementCommand(
						new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
								((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(),
								sourceEditPart.getDiagramPreferencesHint()), new EObjectAdapter(
								(EObject) outputConnector.getModel()), new EObjectAdapter(
								(EObject) (inputConnector).getModel()), sourceEditPart.getViewer());

				cc.add(new ICommandProxy(createSubTopicsCmd));

				getDiagramEditDomain().getDiagramCommandStack().execute(cc);
			}

		}
	}

	private void deleteExistingEndpointAndLink() {

		AbstractEditPart existingEndpoint = (AbstractEditPart) this.getChildren().get(0);
		EditingDomain editingDomain = ((GraphicalEditPart) existingEndpoint).getEditingDomain();

		AbstractEndpointInputConnectorEditPart inputConector = EditorUtils
				.getEndpointInputConnector((ShapeNodeEditPart) existingEndpoint);
		EsbLinkEditPart linkEditPart = null;
		if (inputConector.getTargetConnections().size() > 0) {
			linkEditPart = (EsbLinkEditPart) inputConector.getTargetConnections().get(0);
		}

		//Here we are deleteing the linkpart as well
		if (linkEditPart != null) {
			deleteESbLinkEditpart(editingDomain, inputConector);
		}

		deleteEndpoint(existingEndpoint);
	}

	private void deleteESbLinkEditpart(EditingDomain editingDomain, AbstractEndpointInputConnectorEditPart inputConector) {
		EsbLinkEditPart linkEditPart;
		Collection linkCollection = new ArrayList();
		linkEditPart = (EsbLinkEditPart) inputConector.getTargetConnections().get(0);
		linkCollection.add(((ConnectorImpl) linkEditPart.getModel()).getElement());

		org.eclipse.emf.edit.command.DeleteCommand modelDeleteCommand = new org.eclipse.emf.edit.command.DeleteCommand(
				editingDomain, linkCollection);
		if (modelDeleteCommand.canExecute()) {
			editingDomain.getCommandStack().execute(modelDeleteCommand);
		}

		org.eclipse.gef.commands.CompoundCommand ccView = new org.eclipse.gef.commands.CompoundCommand();
		DeleteCommand viewDeleteCommand = new DeleteCommand(linkEditPart.getNotationView());
		if (viewDeleteCommand.canExecute()) {
			ccView.add(new ICommandProxy(viewDeleteCommand));
		}
		if (ccView.canExecute()) {
			this.getDiagramEditDomain().getDiagramCommandStack().execute(ccView);
		}
	}

	private void deleteEndpoint(AbstractEditPart existingEndpoint) {
		RemoveCommand removeCmd = new RemoveCommand(((GraphicalEditPart) existingEndpoint).getEditingDomain(),
				((Node) existingEndpoint.getModel()).getElement().eContainer(),
				EsbPackage.Literals.MEDIATOR_FLOW__CHILDREN, ((Node) existingEndpoint.getModel()).getElement());

		if (removeCmd.canExecute()) {
			((GraphicalEditPart) existingEndpoint).getEditingDomain().getCommandStack().execute(removeCmd);
		}
	}

}
