package dataMapper.diagram.edit.parts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.border.CompoundBorder;

//import jfb.examples.gmf.filesystem.Element;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.SimpleRaisedBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.ui.parts.AbstractEditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
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
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.ui.*;

import dataMapper.*;
import dataMapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import dataMapper.diagram.edit.parts.custom.FixedBorderItemLocator;

import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @generated
 */
public class ElementEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3007;

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
	public ElementEditPart(View view) {
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
		// installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE., editPolicy)

		installEditPolicy(
				EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						dataMapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new dataMapper.diagram.edit.policies.ElementItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new dataMapper.diagram.edit.policies.ElementCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		/*
		 * installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
		 * CustomNonResizableEditPolicyEx());
		 * 
		 * NonResizableEditPolicy selectionPolicy = new
		 * CustomNonResizableEditPolicyEx();
		 * selectionPolicy.setDragAllowed(false);
		 * installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
		 * selectionPolicy);
		 */

		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE); // ballon remove
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy.);
	}

	/**
	 * @generated NOT
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (dataMapper.diagram.part.DataMapperVisualIDRegistry
						.getVisualID(childView)) {
					case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID :
					case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID :
						return new BorderItemSelectionEditPolicy();
				}
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		return primaryShape = new ElementFigure();
	}

	/**
	 * @generated
	 */
	public RectangleFigure getPrimaryShape() {
		return (RectangleFigure) primaryShape;
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

	/*
	 * add In/Out Nodes if Element is Input , dont add inNodes if Element is
	 * Output, dont add outNodes
	 */
	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof InNode2EditPart
				|| childEditPart instanceof InNodeEditPart) {

			EditPart temp = this.getParent();
			while ((!(temp instanceof DataMapperDiagramEditPart))
					&& (temp != null)) {

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
			/*
			 * Innodes for Output elements
			 */
			if (childEditPart instanceof InNode2EditPart) {
				IFigure borderItemFigure = ((InNode2EditPart) childEditPart)
						.getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(
						getMainFigure(), borderItemFigure,
						PositionConstants.WEST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(
						borderItemFigure, locator);
				return true;
			}

			else {
				IFigure borderItemFigure = ((InNodeEditPart) childEditPart)
						.getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(
						getMainFigure(), borderItemFigure,
						PositionConstants.WEST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(
						borderItemFigure, locator);
				return true;
			}
		}


		else if (childEditPart instanceof OutNode2EditPart
				|| childEditPart instanceof OutNodeEditPart) {

			EditPart temp = this.getParent();
			while ((!(temp instanceof DataMapperDiagramEditPart))
					&& (temp != null)) {

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
				IFigure borderItemFigure = ((OutNodeEditPart) childEditPart)
						.getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(
						getMainFigure(), borderItemFigure,
						PositionConstants.EAST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(
						borderItemFigure, locator);
				return true;
			}

			else {

				IFigure borderItemFigure = ((OutNode2EditPart) childEditPart)
						.getFigure();
				BorderItemLocator locator = new FixedBorderItemLocator(
						getMainFigure(), borderItemFigure,
						PositionConstants.EAST, 0.5);
				getBorderedFigure().getBorderItemContainer().add(
						borderItemFigure, locator);
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

	private Color getBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
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
	public class ElementFigure extends RectangleFigure {

		/**
		 * @generated NOT
		 */
		public ElementFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			layoutThis.setSpacing(5);
			layoutThis.setVertical(false);

			this.setLayoutManager(layoutThis);
			this.setOutline(false);
			this.setOpaque(false);
			this.setFill(false);

			/*
			 * draw rectangle when mosue hover enable Link tool when mouse hover
			 */
			this.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent me) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent me) {

					getEditDomain()
							.getPaletteViewer()
							.setActiveTool(
									(ToolEntry) (((PaletteContainer) getEditDomain()
											.getPaletteViewer()
											.getPaletteRoot().getChildren()
											.get(1)).getChildren().get(1)));
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

		private void setBackgroundPattern(Pattern pattern) {
			// TODO Auto-generated method stub

		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			RectangleFigure figure = new RectangleFigure();
			figure.setLayoutManager(new BorderLayout());

			figure.setOpaque(false);
			figure.setFill(false);

			ImageDescriptor mainImgDesc = AbstractUIPlugin
					.imageDescriptorFromPlugin(
							"org.wso2.developerstudio.visualdatamapper.diagram",
							"icons/gmf/symbol_element_of.gif");

			ImageFigure mainImg = new ImageFigure(mainImgDesc.createImage()); //elemet symbole figure 
			mainImg.setSize(new Dimension(20, 8));
	
			RectangleFigure mainImageRectangle = new RectangleFigure();

			mainImageRectangle
					.setBackgroundColor(new Color(null, 255, 255, 255));
			mainImageRectangle.setPreferredSize(new Dimension(20, 8));
			mainImageRectangle.add(mainImg);

			WrappingLabel fFigureFileNameFigure = new WrappingLabel(); // element nme holding rectangle
			String name = (((Element) ((View) getModel()).getElement())
					.getName()).split(",")[1];
			int tabCount = Integer.parseInt((((Element) ((View) getModel())
					.getElement()).getName()).split(",")[0]);

			figure.setPreferredSize((tabCount - 1) * 30, 100);

			fFigureFileNameFigure.setText(name);
			fFigureFileNameFigure.setForegroundColor(ColorConstants.black);
			fFigureFileNameFigure.setFont(new Font(null, "Arial", 12,
					SWT.NORMAL));

			figure.setOutline(false);
			mainImageRectangle.setOutline(false);
			mainImageRectangle.setFill(false);
			figure.setFill(false);
			this.setOutline(false);
			this.setFill(false);
			this.add(figure);
			this.add(mainImageRectangle);
			this.add(fFigureFileNameFigure);
			this.setMinimumSize(new Dimension(100, 20));

		}

	}

}
