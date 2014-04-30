package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// import jfb.examples.gmf.filesystem.Attribute;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.wso2.developerstudio.datamapper.*;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.AttributeCanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.AttributeItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class AttributeEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3004;

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
	public AttributeEditPart(View view) {
		super(view);
	}

	protected void addChild(EditPart child, int index) {
		// TODO Auto-generated method stub
		super.addChild(child, index);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(
				EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.AttributeItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.AttributeCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new CustomNonResizableEditPolicyEx());

		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (DataMapperVisualIDRegistry.getVisualID(childView)) {
				case InNodeEditPart.VISUAL_ID:
				case OutNodeEditPart.VISUAL_ID:
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
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new AttributeFigure();
	}

	/**
	 * @generated
	 */
	public RectangleFigure getPrimaryShape() {
		return (RectangleFigure) primaryShape;
	}

	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof InNode2EditPart || childEditPart instanceof InNodeEditPart) {

			EditPart temp = this.getParent();
			while ((!(temp instanceof DataMapperRootEditPart)) && (temp != null)) {
				// System.out.println("Node     " +temp);
				if (temp instanceof InputEditPart) {
					if (childEditPart instanceof InNodeEditPart) {
						NodeFigure figureInput = ((InNodeEditPart) childEditPart)
								.getNodeFigureOutput();
						figureInput.removeAll();
						Figure emptyFigure = new Figure();
						figureInput.add(emptyFigure);
						break;
					} else {
						NodeFigure figureInput = ((InNode2EditPart) childEditPart)
								.getNodeFigureOutput();
						figureInput.removeAll();
						Figure emptyFigure = new Figure();
						figureInput.add(emptyFigure);
						break;
					}
				}

				temp = temp.getParent();

			}

			if (childEditPart instanceof InNode2EditPart) {
				IFigure borderItemFigure = ((InNode2EditPart) childEditPart).getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
						borderItemFigure, PositionConstants.WEST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
				return true;
			}

			else {
				IFigure borderItemFigure = ((InNodeEditPart) childEditPart).getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
						borderItemFigure, PositionConstants.WEST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
				return true;
			}
		}

		if (childEditPart instanceof OutNode2EditPart || childEditPart instanceof OutNodeEditPart) {

			EditPart temp = this.getParent();
			while ((!(temp instanceof DataMapperRootEditPart)) && (temp != null)) {

				if (temp instanceof OutputEditPart) {
					if (childEditPart instanceof OutNodeEditPart) {
						NodeFigure figureInput = ((OutNodeEditPart) childEditPart)
								.getNodeFigureOutput();
						figureInput.removeAll();
						Figure emptyFigure = new Figure();
						figureInput.add(emptyFigure);
						break;
					}

					else {
						NodeFigure figureInput = ((OutNode2EditPart) childEditPart)
								.getNodeFigureOutput();
						figureInput.removeAll();
						Figure emptyFigure = new Figure();
						figureInput.add(emptyFigure);
						break;
					}
				}

				temp = temp.getParent();

			}

			if (childEditPart instanceof OutNodeEditPart) {
				IFigure borderItemFigure = ((OutNodeEditPart) childEditPart).getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
						borderItemFigure, PositionConstants.EAST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
				return true;
			}

			else {

				IFigure borderItemFigure = ((OutNode2EditPart) childEditPart).getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
						borderItemFigure, PositionConstants.EAST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
				return true;
			}
		}
		return false;
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#isSelectable
	 * ()
	 */
	@Override
	public boolean isSelectable() {
		return false;
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
	protected NodeFigure createMainFigure() {
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

	/**
	 * @generated NOT
	 */
	public class AttributeFigure extends RectangleFigure {

		/**
		 * @generated NOT
		 */
		public AttributeFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			layoutThis.setSpacing(0);
			layoutThis.setVertical(false);

			this.setLayoutManager(layoutThis);
			this.setOutline(false);
			this.setOpaque(false);
			this.setFill(false);

			this.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent me) {

				}

				@Override
				public void mouseEntered(MouseEvent me) {

					getEditDomain().getPaletteViewer().setActiveTool(
							(ToolEntry) (((PaletteContainer) getEditDomain().getPaletteViewer()
									.getPaletteRoot().getChildren().get(1)).getChildren().get(1)));

					setOutline(true);

				}

				@Override
				public void mouseExited(MouseEvent me) {

					getEditDomain().getPaletteViewer().setActiveTool(null);

					setOutline(false);

				}

				@Override
				public void mouseHover(MouseEvent me) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent me) {
					// TODO Auto-generated method stub

				}

			});

			createContents();

		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			RectangleFigure figure = new RectangleFigure();
			figure.setLayoutManager(new BorderLayout());
			figure.setBorder(new MarginBorder(4, 4, 4, 4));

			figure.setOpaque(true);
			figure.setFill(false);
			ImageDescriptor mainImgDesc = AbstractUIPlugin.imageDescriptorFromPlugin(
					"org.wso2.developerstudio.visualdatamapper.diagram",
					"icons/gmf/AttributeIcon.png");

			ImageFigure mainImg = new ImageFigure(mainImgDesc.createImage());
			mainImg.setSize(new Dimension(20, 10));
			RectangleFigure mainImageRectangle = new RectangleFigure();

			mainImageRectangle.setBackgroundColor(new Color(null, 255, 255, 255));
			mainImageRectangle.setPreferredSize(new Dimension(20, 10));

			mainImg.setOpaque(false);
			mainImageRectangle.add(mainImg);

			WrappingLabel fFigureFileNameFigure = new WrappingLabel();
			String name = (((Attribute) ((View) getModel()).getElement()).getName()).split(",")[1];
			int tabCount = Integer.parseInt((((Attribute) ((View) getModel()).getElement())
					.getName()).split(",")[0]);

			figure.setPreferredSize((tabCount - 1) * 30, 100);

			fFigureFileNameFigure.setText(name);
			fFigureFileNameFigure.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);

			fFigureFileNameFigure.setFont(new Font(null, "Arial", 10, SWT.BOLD));
			figure.setOutline(false);
			mainImageRectangle.setOutline(false);
			figure.setFill(false);
			mainImageRectangle.setFill(false);
			this.setFill(false);
			this.setOutline(false);
			this.add(figure);
			this.add(mainImageRectangle);
			this.add(fFigureFileNameFigure);
			this.setMinimumSize(new Dimension(100, 20));

		}

	}

}
