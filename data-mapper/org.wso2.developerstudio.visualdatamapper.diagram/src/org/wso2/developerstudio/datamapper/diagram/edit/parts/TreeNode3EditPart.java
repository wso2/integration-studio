package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MarginBorder;
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
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
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
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.TreeNode3CanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.TreeNode3ItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;

/**
 * @generated
 */
public class TreeNode3EditPart extends ShapeNodeEditPart {

	/**
	 * @generated NOT
	 */
	List<IFigure> childrenIFigure;
	/**
	 * @generated NOT
	 */
	boolean isActivated = false;
	/**
	 * @generated NOT
	 */
	NodeFigure figure;
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3011;

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
	public TreeNode3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void activate() {

		super.activate();
		if (!isActivated) {
			List<IFigure> figures = new ArrayList<IFigure>();
			childrenIFigure = new ArrayList<IFigure>();
			int count = getPrimaryShape().getChildren().size();

			for (int i = 0; i < count; i++) {
				IFigure figure = (IFigure) getPrimaryShape().getChildren().get(0);
				figures.add(figure);
				childrenIFigure.add(figure);
				getPrimaryShape().getChildren().remove(figure);
			}
			for (int i = 0; i < count; i++) {
				getPrimaryShape().getChildren().add(figures.get(i));
			}
			((Figure) (getPrimaryShape().getChildren().get(0))).setPreferredSize(100, 20);
			childrenIFigure.remove(childrenIFigure.size() - 1);
			isActivated = true;
		}

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
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.TreeNode3ItemSemanticEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.TreeNode3CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		/* Disable dragging and resizing */
		NonResizableEditPolicy selectionPolicy = new CustomNonResizableEditPolicyEx();
		selectionPolicy.setDragAllowed(false);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, selectionPolicy);

		/* remove balloon */
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#isSelectable()
	 * 
	 */
	@Override
	public boolean isSelectable() {
		return true;
	}

	/**
	 * @generated NOT
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
		return primaryShape = new TreeNodeFigure();
	}

	/**
	 * @generated
	 */
	public TreeNodeFigure getPrimaryShape() {
		return (TreeNodeFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TreeNodeName3EditPart) {
			((TreeNodeName3EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureTreeNodeNameFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof TreeNodeName3EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
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

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(DataMapperVisualIDRegistry
				.getType(TreeNodeName3EditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public class TreeNodeFigure extends RectangleFigure {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureTreeNodeNameFigure;

		/**
		 * @generated NOT
		 */
		boolean isExpanded = true;

		/**
		 * @generated NOT
		 */
		ClickNode clickNode;

		/**
		 * @generated NOT
		 */
		public TreeNodeFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			//layoutThis.setSpacing(1);
			layoutThis.setVertical(true);
			this.setLayoutManager(layoutThis);
			this.setOpaque(false);
			this.setFill(false);
			this.setOutline(false);
			createContents();

		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			RectangleFigure figure = new RectangleFigure();
			ToolbarLayout l = new ToolbarLayout();
			l.setVertical(false);
			figure.setLayoutManager(l);
			//figure.setPreferredSize(10, 10);
			figure.setBorder(null);

			figure.setOpaque(true);

			RectangleFigure figure2 = new RectangleFigure();
			figure2.setBorder(null);
			figure2.setOpaque(true);

			ImageDescriptor mainImgDescCollapse = AbstractUIPlugin.imageDescriptorFromPlugin(
					"org.wso2.developerstudio.visualdatamapper.diagram", "icons/gmf/plus.gif");
			ImageDescriptor mainImgDescExpand = AbstractUIPlugin.imageDescriptorFromPlugin(
					"org.wso2.developerstudio.visualdatamapper.diagram", "icons/gmf/minus.gif");

			final ImageFigure mainImg = new ImageFigure(mainImgDescCollapse.createImage());
			final ImageFigure mainExpand = new ImageFigure(mainImgDescExpand.createImage());
			mainImg.setSize(new Dimension(10, 8));
			RectangleFigure mainImageRectangle = new RectangleFigure();
			mainImageRectangle.setOutline(false);
			mainImageRectangle.setBackgroundColor(new Color(null, 255, 255, 255));
			mainImageRectangle.setPreferredSize(new Dimension(10, 5));
			mainImageRectangle.add(mainImg);
			mainImageRectangle.setBorder(new MarginBorder(1, 1, 1, 1));

			fFigureTreeNodeNameFigure = new WrappingLabel();

			/*String name = (((TreeNode) ((View) getModel()).getElement()).getName()).split(",")[1];
			int count = Integer.parseInt((((TreeNode) ((View) getModel()).getElement()).getName())
					.split(",")[0]);*/
			String name = (((TreeNode) ((View) getModel()).getElement()).getName());
			int count = ((TreeNode) ((View) getModel()).getElement()).getLevel();
			fFigureTreeNodeNameFigure.setText(name);
			fFigureTreeNodeNameFigure.setForegroundColor(ColorConstants.black);
			fFigureTreeNodeNameFigure.setFont(new Font(null, "Arial", 10, SWT.BOLD));
			clickNode = new ClickNode(mainExpand);
			clickNode.setEnabled(true);
			clickNode.setPreferredSize(20, 8);

			clickNode.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					if (!isExpanded) {
						repaint(isExpanded, mainExpand);

					} else {
						repaint(isExpanded, mainImg);

					}
				}

			});

			figure2.setPreferredSize((count - 1) * 30, 1);

			figure.setOutline(false);
			figure2.setOutline(false);
			figure.setFill(false);
			figure2.setFill(false);
			mainImageRectangle.setFill(false);
			mainImageRectangle.setOutline(false);
			this.setFill(false);

			this.setOutline(false);
			figure.add(figure2);
			figure.add(clickNode);
			figure.add(fFigureTreeNodeNameFigure);

			this.add(figure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTreeNodeNameFigure() {
			return fFigureTreeNodeNameFigure;
		}

		/**
		 * @generated NOT
		 */
		public void repaint(boolean Expanded, ImageFigure image) {
			if (!Expanded) {
				clickNode.setContents(image);
				isExpanded = true;
				for (int i = childrenIFigure.size() - 1; i >= 0; i--) {
					getPrimaryShape().getChildren().add(childrenIFigure.get(i));
				}
			} else {
				clickNode.setContents(image);
				isExpanded = false;

				for (int i = 0; i < childrenIFigure.size(); i++) {
					getPrimaryShape().getChildren().remove(childrenIFigure.get(i));
				}
			}
		}

		/**
		 * @generated NOT
		 */
		public class ClickNode extends Clickable {
			public ClickNode(ImageFigure image) {
				this.setContents(image);
			}

			@Override
			protected void setContents(IFigure contents) {
				super.setContents(contents);
			}
		}
	}

}
