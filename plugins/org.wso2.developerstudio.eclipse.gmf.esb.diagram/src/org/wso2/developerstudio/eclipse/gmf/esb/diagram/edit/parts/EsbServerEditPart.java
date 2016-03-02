package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SlidingBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbServerCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.EsbServerItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated
 */
public class EsbServerEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public EsbServerEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EsbServerItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EsbServerCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case MessageMediatorEditPart.VISUAL_ID:
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

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new EsbServerFigure();
	}

	/**
	 * @generated
	 */
	public EsbServerFigure getPrimaryShape() {
		return (EsbServerFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(300, 200);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		//Rectangle parentRect = ((EsbDiagramEditPart)this.getParent()).getChildrenBounds();
		//Rectangle rect = new Rectangle(50,5,parentRect.width-60, parentRect.height-10);
		//Rectangle rect = new Rectangle(50, 5, 600, 450);
		//System.out.println(parentRect);
		//SetBoundsCommand sbc = new SetBoundsCommand(this.getEditingDomain(),
		//		"change location", new EObjectAdapter((View) this.getModel()),
		//		rect);
		//getEditDomain().getCommandStack().execute(new ICommandProxy(sbc));
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
	 * {@inheritDoc}
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof ProxyServiceEditPart) {
			borderItemContainer.add(borderItemEditPart.getFigure(), new SlidingBorderItemLocator(getMainFigure(),
					borderItemEditPart.getFigure(), PositionConstants.WEST, 10, 5));
		} else if (borderItemEditPart instanceof MessageMediatorEditPart) {
			borderItemContainer.add(borderItemEditPart.getFigure(), new SlidingBorderItemLocator(getMainFigure(),
					borderItemEditPart.getFigure(), PositionConstants.WEST, 10, 5));
		} else if (borderItemEditPart instanceof DefaultEndPointEditPart) {
			borderItemContainer.add(borderItemEditPart.getFigure(), new SlidingBorderItemLocator(getMainFigure(),
					borderItemEditPart.getFigure(), PositionConstants.EAST, 10, 5));
		} else if (borderItemEditPart instanceof AddressEndPointEditPart) {
			borderItemContainer.add(borderItemEditPart.getFigure(), new SlidingBorderItemLocator(getMainFigure(),
					borderItemEditPart.getFigure(), PositionConstants.EAST, 10, 5));
		} else if (borderItemEditPart instanceof WSDLEndPointEditPart) {
			borderItemContainer.add(borderItemEditPart.getFigure(), new SlidingBorderItemLocator(getMainFigure(),
					borderItemEditPart.getFigure(), PositionConstants.EAST, 10, 5));
		}

		else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof ResizableCompartmentEditPart) {
			// Compartment should be added to the primary shape.
			return getPrimaryShape();
		} else {
			return super.getContentPaneFor(editPart);
		}
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
	 * @custom
	 * this will make sure esb server will automatically be resized
	 * according to added mediators
	 */
	public void optimizeBounds() {
		Rectangle bounds = this.getMainFigure().getClientArea().getCopy();
		bounds.setSize(bounds.getSize().width + 10, bounds.getSize().height + 10);

		SetBoundsCommand sbc = new SetBoundsCommand(this.getEditingDomain(), "change size", new EObjectAdapter(
				(View) this.getModel()), bounds);
		getEditDomain().getCommandStack().execute(new ICommandProxy(sbc));
	}

	/**
	 * @generated
	 */
	public class EsbServerFigure extends RoundedRectangle {

		/**
		 * @generated NOT
		 */
		public EsbServerFigure() {

			/*	ToolbarLayout layoutThis = new ToolbarLayout();
				layoutThis.setStretchMinorAxis(true);
				layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

				layoutThis.setSpacing(5);
				layoutThis.setVertical(false);

				this.setLayoutManager(layoutThis);*/

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			this.setBackgroundColor(THIS_BACK);

			this.setOutline(true);
			// TODO: review this:
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(3000), getMapMode().DPtoLP(1800)));

			// Leave more space on left and right for border item placement.
			MarginBorder marginBorder = new MarginBorder(-7, -10, -5, 20);
			this.setBorder(marginBorder);

		}

		/**
		 * {@inheritDoc}
		 */
		public void add(IFigure figure, Object constraint, int index) {
			if (figure instanceof ResizableCompartmentFigure) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			} else {
				super.add(figure, constraint, index);
			}
		}

		/**
		 * @generated NOT
		 */
		protected void fillShape(Graphics graphics) {
			// Backup the graphics colors
			Color bgColor = graphics.getBackgroundColor();
			Color fgColor = graphics.getForegroundColor();
			// Set the graphics color
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(ColorConstants.white);
			// Restore the original colors
			graphics.fillGradient(getBounds(), true);
			graphics.setBackgroundColor(bgColor);
			graphics.setForegroundColor(fgColor);
		}

	}

	public boolean isSelectable() {
		return false;
	}

	/**
	 * @generated NOT
	 */
	static final Color THIS_BACK = new Color(null, 255, 255, 255);//new Color(null, 255, 245, 247);

}
