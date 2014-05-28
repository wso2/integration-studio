package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
//import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorLeftContainer;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.OperatorLeftContainerCanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.OperatorLeftContainerItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class OperatorLeftContainerEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3013;

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
	public OperatorLeftContainerEditPart(View view) {
		super(view);
	}

	@Override
	public void activate() {

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {

				if (getParent().getParent() instanceof SplitEditPart
						|| getParent().getParent() instanceof LowerCaseEditPart
						|| getParent().getParent() instanceof UpperCaseEditPart) {
					EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
							.getElement();
					if (((OperatorLeftContainer) parentContainer).getLeftConnectors().size() == 0) {
						OperatorLeftConnector peratorLeftConnector = DataMapperFactory.eINSTANCE
								.createOperatorLeftConnector();
						AddCommand addCaseConnectorCmd = new AddCommand(
								getEditingDomain(),
								parentContainer,
								DataMapperPackage.Literals.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS,
								peratorLeftConnector);
						if (addCaseConnectorCmd.canExecute()) {
							getEditingDomain().getCommandStack().execute(addCaseConnectorCmd);
						}

					}
				}

				else if (getParent().getParent() instanceof EqualEditPart
						|| getParent().getParent() instanceof ConcatEditPart
						|| getParent().getParent() instanceof ContainsEditPart) {
					EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
							.getElement();
					if (((OperatorLeftContainer) parentContainer).getLeftConnectors().size() == 0) {
						OperatorLeftConnector leftConnector1 = DataMapperFactory.eINSTANCE
								.createOperatorLeftConnector();
						OperatorLeftConnector leftConnector2 = DataMapperFactory.eINSTANCE
								.createOperatorLeftConnector();
						AddCommand addCaseConnectorCmd1 = new AddCommand(
								getEditingDomain(),
								parentContainer,
								DataMapperPackage.Literals.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS,
								leftConnector1);
						if (addCaseConnectorCmd1.canExecute()) {
							getEditingDomain().getCommandStack().execute(addCaseConnectorCmd1);
						}

						AddCommand addCaseConnectorCmd2 = new AddCommand(
								getEditingDomain(),
								parentContainer,
								DataMapperPackage.Literals.OPERATOR_LEFT_CONTAINER__LEFT_CONNECTORS,
								leftConnector2);
						if (addCaseConnectorCmd2.canExecute()) {
							getEditingDomain().getCommandStack().execute(addCaseConnectorCmd2);
						}

					}
				}

			}// runend
		});

		super.activate();
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new OperatorLeftContainerItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new OperatorLeftContainerCanonicalEditPolicy());
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
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		primaryShape = new OperatorLeftContainerFigure();
		return primaryShape;
	}

	/**
	 * @generated NOT
	 */
	public OperatorLeftContainerFigure getPrimaryShape() {
		return (OperatorLeftContainerFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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

	public class OperatorLeftContainerFigure extends RoundedRectangle {

		public OperatorLeftContainerFigure() {

			//			this.setBackgroundColor(THIS_BACK);
			// RoundedRectangleBorder border = new RoundedRectangleBorder(8, 8);
			// border.setColor(new Color(null, 255, 0, 0));
			// this.setBorder(border); //TODO just for identification remove
			// once we are done

			ConstrainedToolbarLayout layoutThis = new ConstrainedToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setStretchMajorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layoutThis.setSpacing(0);
			// layoutThis.setHorizontal(true);
			layoutThis.setMatchWidth(true);
			this.setLayoutManager(layoutThis);

		}

		public String getIconPath() {
			return "icons/ico20/log-mediator.gif";
		}

		public String getNodeName() {
			return "OperatorLeftContainer";
		}

		public IFigure getToolTip() {
			return new Label("OperatorLeftContainer");
		}

	}

	static final Color THIS_BACK = new Color(null, 230, 230, 230);

}
