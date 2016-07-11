package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorLeftContainer;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.OperatorRightContainer;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.OperatorRightContainerCanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.OperatorRightContainerItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.developerstudio.datamapper.impl.OperatorImpl;

/**
 * @generated
 */
public class OperatorRightContainerEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3016;

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
	public OperatorRightContainerEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean canAttachNote() {
		return false;
	}

	@Override
	public void activate() {

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				if (getParent().getParent().getModel() instanceof Node) {
					Node model = (Node) getParent().getParent().getModel();
					OperatorImpl operator = (OperatorImpl) model.getElement();
					int numberOfOutputs = operator.getDefaultOutputConnectors();
					EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
							.getElement();
					if (((OperatorRightContainer) parentContainer).getRightConnectors().size() == 0) {
						for (int i = 0; i < numberOfOutputs; i++) {
							OperatorRightConnector rightConnector = DataMapperFactory.eINSTANCE
									.createOperatorRightConnector();
							AddCommand addCaseConnectorCmd = new AddCommand(getEditingDomain(), parentContainer,
									DataMapperPackage.Literals.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS,
									rightConnector);
							if (addCaseConnectorCmd.canExecute()) {
								getEditingDomain().getCommandStack().execute(addCaseConnectorCmd);
							}
						}
					}
				}
			}// run end
		});

		super.activate();
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OperatorRightContainerItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new OperatorRightContainerCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new CustomNonResizableEditPolicyEx());
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
		primaryShape = new OperatorRightContainerFigure();
		return primaryShape;
	}

	/**
	 * @generated NOT
	 */
	public OperatorRightContainerFigure getPrimaryShape() {
		return (OperatorRightContainerFigure) primaryShape;
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
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
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

	public class OperatorRightContainerFigure extends RoundedRectangle {

		public OperatorRightContainerFigure() {

			// this.setBackgroundColor(THIS_BACK);
			// RoundedRectangleBorder border = new RoundedRectangleBorder(8, 8);
			// border.setColor(new Color(null, 255, 0, 0));
			// this.setBorder(border ); //TODO just for identification remove
			// once we are done

			ConstrainedToolbarLayout layoutThis = new ConstrainedToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setStretchMajorAxis(true);

			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layoutThis.setSpacing(0);
			layoutThis.setHorizontal(false);

			layoutThis.setMatchWidth(true);

			this.setLayoutManager(layoutThis);
			this.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent me) {

				}

				@Override
				public void mouseEntered(MouseEvent me) {
					getEditDomain().getPaletteViewer().setActiveTool((ToolEntry) (((PaletteContainer) getEditDomain()
							.getPaletteViewer().getPaletteRoot().getChildren().get(1)).getChildren().get(0)));

				}

				@Override
				public void mouseExited(MouseEvent me) {
					getEditDomain().getPaletteViewer().setActiveTool(null);

				}

				@Override
				public void mouseHover(MouseEvent me) {

				}

				@Override
				public void mouseMoved(MouseEvent me) {
				}

			});

		}

		public String getIconPath() {
			return "icons/ico20/log-mediator.gif";
		}

		public String getNodeName() {
			return "OperatorRightContainer";
		}

		public IFigure getToolTip() {
			return new Label("OperatorRightContainer");
		}

	}

	@Override
	public boolean isSelectable() {
		return false;
	}

}
