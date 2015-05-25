package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.SequenceInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbServerContentsCompartmentCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbServerContentsCompartmentItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class EsbServerContentsCompartmentEditPart extends ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;

	/**
	 * @generated
	 */
	public EsbServerContentsCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	public String getCompartmentName() {
		return "";
		//return Messages.EsbServerContentsCompartmentEditPart_title;
	}

	/**
	 * @generated NOT
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setFontColor(new Color(null, 200, 0, 0));
		result.setTitleVisibility(true);
		// Override default border.
		// result.setBorder(new MarginBorder(0, 0, 0, 0));
		result.setToolTip((String) null);
		return result;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EsbServerContentsCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EsbServerContentsCompartmentCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
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
			if (type == EsbElementTypes.ProxyService_3001) {
				return this;
			}
			if (type == EsbElementTypes.MergeNode_3013) {
				return this;
			}
			if (type == EsbElementTypes.Sequences_3614) {
				return this;
			}
			if (type == EsbElementTypes.LocalEntry_3663) {
				return this;
			}
			if (type == EsbElementTypes.Template_3664) {
				return this;
			}
			if (type == EsbElementTypes.Task_3667) {
				return this;
			}
			if (type == EsbElementTypes.SynapseAPI_3668) {
				return this;
			}
			if (type == EsbElementTypes.ComplexEndpoints_3677) {
				return this;
			}
			if (type == EsbElementTypes.MessageStore_3715) {
				return this;
			}
			if (type == EsbElementTypes.MessageProcessor_3701) {
				return this;
			}
			if (type == EsbElementTypes.InboundEndpoint_3767) {
				return this;
			}
			return getParent().getTargetEditPart(request);
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			return getParent().getTargetEditPart(request);
		}
		return super.getTargetEditPart(request);
	}

	public boolean isSelectable() {
		// TODO This or using ResizableEditpolicy?
		return false;
	}

	// when user drop the user defined Sequence mediator to the Compartment this
	// method will set the name of it.
	protected EditPart createChild(Object model) {
		if (!getEditDomain().getPaletteViewer().getActiveTool().getLabel().equals(SequenceInfo.SEQUENCE_LABEL)
				& !getEditDomain().getPaletteViewer().getActiveTool().getLabel().equals(SequenceInfo.SELECT)) {
			// Resource diagram;
			// if(((Sequence)((org.eclipse.gmf.runtime.notation.impl.NodeImpl)model).getElement()).getName().equals("")){

			String name = getEditDomain().getPaletteViewer().getActiveTool().getLabel();

			/*
			 * EditPart editPart=super.createChild(model); if(editPart
			 * instanceof SequenceEditPart){
			 * 
			 * diagram = EsbDiagramEditorUtil.createDiagram(
			 * URI.createURI("platform:/resource/testing/"
			 * +name+".sequence_diagram"),
			 * URI.createURI("platform:/resource/testing/" +name+".sequence"),
			 * new NullProgressMonitor()); }
			 */
			if (((org.eclipse.gmf.runtime.notation.impl.NodeImpl) model).getElement() instanceof Sequence) {
				Sequence sequence = (Sequence) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) model).getElement();
				TransactionalEditingDomain editingDomain = getEditingDomain();
				SetRequest setRequest = new SetRequest(editingDomain, sequence,
						EsbPackage.eINSTANCE.getSequence_Name(), name);
				SetValueCommand operation = new SetValueCommand(setRequest) {

					public boolean canUndo() {
						return true;
					}

					public boolean canRedo() {
						return true;
					}
				};

				ICommandProxy command = new ICommandProxy(operation);
				if (command.canExecute()) {
					getEditDomain().getCommandStack().execute(command);
				}
				((org.eclipse.gmf.runtime.notation.impl.NodeImpl) model).getChildren().size();

			}
		}
		return super.createChild(model);
	}

}
