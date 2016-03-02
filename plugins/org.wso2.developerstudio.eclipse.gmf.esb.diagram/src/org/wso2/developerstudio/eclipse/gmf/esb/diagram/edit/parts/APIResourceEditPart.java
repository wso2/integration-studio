package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ProxyServiceGroupBox;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.APIResourceCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.APIResourceItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated NOT
 */
public class APIResourceEditPart extends AbstractBaseFigureEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3669;

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
	public APIResourceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new APIResourceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new APIResourceCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new CustomNonResizableEditPolicyEx()); //remove 8 corners
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case APIResourceInputConnectorEditPart.VISUAL_ID:
				case APIResourceOutputConnectorEditPart.VISUAL_ID:
				case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
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

	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getFeature() instanceof EAttributeImpl) {
			if (notification.getNotifier() instanceof BoundsImpl) {
				y = ((BoundsImpl) notification.getNotifier()).getY();
				alignLeft(((BoundsImpl) notification.getNotifier()).getY(),
						((BoundsImpl) notification.getNotifier()).getWidth(),
						((BoundsImpl) notification.getNotifier()).getHeight());
				FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
				canvas.getViewport().repaint();
			}
		}
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new APIResourceFigure() {
			public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
				super.setBounds(rect);
				if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
					alignLeft();
					x = this.getBounds().getLocation().x;
					y = this.getBounds().getLocation().y;
				}
				if (rect.width != 0 && rect.height != 0) {
					arrangeAPIResources(rect);
				}
			};
		};
	}

	private void alignLeft() {
		alignLeft(getFigure().getBounds().y, getFigure().getBounds().width, getFigure().getBounds().height);
	}

	private void alignLeft(int y, int width, int height) {
		Rectangle constraints = new Rectangle(0, y, width, height);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), constraints);
	}

	/**
	 * Arrange API Resources 
	 * @param rectangle
	 */
	private void arrangeAPIResources(Rectangle rectangle) {
		int noOfResources = getParent().getChildren().size();
		if (noOfResources > 1) {
			for (int i = 0; i < (noOfResources - 1); i++) {
				IFigure currentFigure = ((GraphicalEditPart) getParent().getChildren().get(i)).getFigure();
				Rectangle currentFigureBounds = currentFigure.getBounds();
				IFigure nextFigure = ((GraphicalEditPart) getParent().getChildren().get(i + 1)).getFigure();
				Rectangle nextFigureBounds = nextFigure.getBounds();
				int currentResourceBottomMargin = currentFigureBounds.y + currentFigureBounds.height;

				APIResourceEditPart editPart = (APIResourceEditPart) getParent().getChildren().get(i + 1);
				Rectangle constraints = new Rectangle(0, (currentResourceBottomMargin + 20), nextFigureBounds.width,
						nextFigureBounds.height);
				((GraphicalEditPart) getParent()).setLayoutConstraint(editPart, nextFigure, constraints);
				nextFigure.setBounds(constraints);
			}

		}
	}

	/**
	 * @generated
	 */
	public APIResourceFigure getPrimaryShape() {
		return (APIResourceFigure) primaryShape;
	}

	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof APIResourceOutputConnectorEditPart) {
			outputConnectorFigure = ((APIResourceOutputConnectorEditPart) childEditPart).getFigure();

			return false;
		}
		if (childEditPart instanceof APIResourceInputConnectorEditPart) {
			inputConnectorFigure = ((APIResourceInputConnectorEditPart) childEditPart).getFigure();

			return false;
		}

		if (childEditPart instanceof APIResourceOutSequenceOutputConnectorEditPart) {
			outSequenceOutputConnectorFigure = ((APIResourceOutSequenceOutputConnectorEditPart) childEditPart)
					.getFigure();
			return false;
		}

		if (childEditPart instanceof APIResourceFaultInputConnectorEditPart) {
			faultInputnputConnectorFigure = ((APIResourceFaultInputConnectorEditPart) childEditPart).getFigure();

			return false;
		}

		if (childEditPart instanceof APIResourceInSequenceInputConnectorEditPart) {
			inSequenceInputConnectorFigure = ((APIResourceInSequenceInputConnectorEditPart) childEditPart).getFigure();
			IFigure figure = ((GraphicalEditPart) ((GraphicalEditPart) ((GraphicalEditPart) getChildren().get(4))
					.getChildren().get(0)).getChildren().get(0)).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(
			/*(IFigure) ((IFigure) ((IFigure) (IFigure) getFigure()
			.getChildren().get(0)).getChildren().get(0))
			.getChildren().get(1)*/figure, inSequenceInputConnectorFigure, PositionConstants.EAST, 0.25);
			getBorderedFigure().getBorderItemContainer().add(inSequenceInputConnectorFigure, locator);
			return true;
		}

		return false;
	}

	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof APIResourceOutputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((APIResourceOutputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof APIResourceInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((APIResourceInputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof APIResourceInSequenceInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((APIResourceInSequenceInputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
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
	protected NodeFigure createMainFigure() {
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

	/**
	 * @generated NOT
	 */
	public class APIResourceFigure extends ProxyServiceGroupBox {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureAPIResourceNamePropertyLabel;

		/**
		 * @generated NOT
		 */
		public APIResourceFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layoutThis.setSpacing(0);
			layoutThis.setVertical(false);

			this.setLayoutManager(layoutThis);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(300), getMapMode().DPtoLP(400)));
			this.setOutline(false);
			this.setBackgroundColor(THIS_BACK);
			this.setForegroundColor(new Color(null, 0, 0, 0));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureAPIResourceNamePropertyLabel = new WrappingLabel();
			fFigureAPIResourceNamePropertyLabel.setText("<...>");
			fFigureAPIResourceNamePropertyLabel.setAlignment(SWT.CENTER);

		}

		public void add(IFigure figure, Object constraint, int index) {
			if (figure instanceof DefaultSizeNodeFigure) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			} else if (figure instanceof RoundedRectangle) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			}

			else {
				super.add(figure, constraint, index);
			}
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAPIResourceNamePropertyLabel() {
			return fFigureAPIResourceNamePropertyLabel;
		}

		public String getIconPath() {
			return "icons/ico20/apiResource.gif";
		}

		public String getNodeName() {
			return "Resource";
		}

		public Color getBackgroundColor() {
			return THIS_BACK;
		}

	}

	/**
	 * @generated NOT
	 */
	static final Color THIS_BACK = new Color(null, 255, 255, 255);

}
