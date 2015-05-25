package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.SwitchMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment11CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment11ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory.NodeToolEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated NOT
 */
public class MediatorFlowMediatorFlowCompartment11EditPart extends AbstractMediatorCompartmentEditPart {
	// clone target
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7032;

	/**
	 * @generated NOT
	 */
	protected static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * @generated NOT
	 */
	public MediatorFlowMediatorFlowCompartment11EditPart(View view) {
		super(view);
		complexity = Complexity.MULTIPLE;
	}

	/**
	 * @generated NOT
	 */
	public String getCompartmentName() {
		//return Messages.MediatorFlowMediatorFlowCompartment11EditPart_title;
		return null; //"Target";
	}

	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		// Override default border.
		LineBorder border = new LineBorder(new Color(null, 224, 224, 224), 1, SWT.BORDER_DASH);
		result.setBorder(border);
		result.setToolTip((String) null);
		return result;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MediatorFlowMediatorFlowCompartment11ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new MediatorFlowMediatorFlowCompartment11CanonicalEditPolicy());
	}

	@SuppressWarnings("restriction")
	protected void addChild(EditPart child, int index) {
		// TODO Auto-generated method stub
		super.addChild(child, index);

		if (child instanceof SwitchMediatorEditPart) {
			SwitchMediatorEditPart switchMediatorEditPart = (SwitchMediatorEditPart) child;
			SwitchMediatorUtils.addCaseBranchInitially(switchMediatorEditPart, getEditingDomain());
		}
		if (child instanceof NamedEndpointEditPart) {
			NamedEndpointEditPart namedEndPointEditPart = (NamedEndpointEditPart) child;
			EditPart editpart = (EditPart) ((StructuredSelection) namedEndPointEditPart.getViewer().getEditDomain()
					.getPaletteViewer().getSelection()).getFirstElement();
			if (editpart instanceof ToolEntryEditPart) {
				if (((ToolEntryEditPart) editpart).getModel() instanceof NodeToolEntry) {
					String label = ((NodeToolEntry) ((ToolEntryEditPart) editpart).getModel()).getLabel();
					if ((!label.equals("")) && (!label.equals("Named EndPoint"))) {
						try {
							((NamedEndpoint) ((View) namedEndPointEditPart.getModel()).getElement()).setName(label);
						} catch (java.lang.IllegalStateException e) {
							log.error("This is occured while undo operation..", e);
						}
					}
				}
			}
		}
	}

	public void connectNormally(EditPart child) {

		/*
		 * Get the previous mediator's index and check if it's and endpoint, if so replace with new one
		 */

		int count = this.getChildren().size();
		if (count > 1) {
			Object endpoint = this.getChildren().get(count - 2);
			if (endpoint instanceof AbstractEndpoint) {

				deleteExistingEndpointAndLink(endpoint);
			}
		}

		AbstractBorderItemEditPart inputConnector = null;
		AbstractBorderItemEditPart outputConnector = null;
		ShapeNodeEditPart sourceEditPart = null;

		if ((child instanceof AbstractMediator) || (child instanceof AbstractEndpoint)) {

			inputConnector = EditorUtils.getEndpointInputConnector((ShapeNodeEditPart) child);
			@SuppressWarnings("unchecked")
			List<EditPart> children = ((CloneMediatorEditPart) this.getParent().getParent().getParent().getParent())
					.getChildren();

			//FIXME
			// This is not a proper fix to get the target output connector. This fix has been made since clone target container and target output connector are in two different models
			CloneMediatorTargetOutputConnectorEditPart relevantTargetOutputConnector = getCloneMediatorTargetOutputConnector(children);

			outputConnector = (AbstractBorderItemEditPart) relevantTargetOutputConnector;

			sourceEditPart = (ShapeNodeEditPart) this.getParent().getParent().getParent().getParent();

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

	private CloneMediatorTargetOutputConnectorEditPart getCloneMediatorTargetOutputConnector(List<EditPart> children) {
		// Gets the target of the dropped Endpoint
		Object cloneTargetContainer = (CloneTargetContainerEditPart) this.getParent().getParent();
		CloneMediatorContainerEditPart cloneMediatorContainerEditPart = (CloneMediatorContainerEditPart) this
				.getParent().getParent().getParent();
		// List of all the targets in the mediator
		@SuppressWarnings("unchecked")
		List<EditPart> targetlist = cloneMediatorContainerEditPart.getChildren();
		List<CloneMediatorTargetOutputConnectorEditPart> targetOutputConnectorList = new ArrayList<CloneMediatorTargetOutputConnectorEditPart>();

		int targetIndex = 0;
		for (int x = 0; x < targetlist.size(); ++x) {
			if (targetlist.get(x).equals(cloneTargetContainer)) {
				targetIndex = x;
			}
		}

		for (int i = 0; i < children.size(); ++i) {
			if (children.get(i) instanceof CloneMediatorTargetOutputConnectorEditPart) {
				// Include all the target output connectors to a list
				CloneMediatorTargetOutputConnectorEditPart cloneMediatorTargetOutputConnectorEditPart = (CloneMediatorTargetOutputConnectorEditPart) children
						.get(i);
				targetOutputConnectorList.add(cloneMediatorTargetOutputConnectorEditPart);
			}

		}

		// Gets the relevant target output connector which matches with the target container
		CloneMediatorTargetOutputConnectorEditPart relevantTargetOutputConnector = targetOutputConnectorList
				.get(targetIndex);
		return relevantTargetOutputConnector;
	}

	private void deleteExistingEndpointAndLink(Object obj) {

		AbstractEditPart existingEndpoint = (AbstractEditPart) obj;
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

	@SuppressWarnings("unchecked")
	private void deleteESbLinkEditpart(EditingDomain editingDomain, AbstractEndpointInputConnectorEditPart inputConector) {
		EsbLinkEditPart linkEditPart;
		@SuppressWarnings("rawtypes")
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

	public boolean isSelectable() {
		// TODO This or using ResizableEditpolicy?
		return false;
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}
