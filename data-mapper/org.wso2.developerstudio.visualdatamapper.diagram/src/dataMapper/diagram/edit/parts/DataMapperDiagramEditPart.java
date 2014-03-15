package dataMapper.diagram.edit.parts;

import javax.swing.border.LineBorder;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import dataMapper.diagram.edit.parts.custom.DataMapperDiagramBox;

/**
 * @generated
 */
public class DataMapperDiagramEditPart extends ShapeNodeEditPart {

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
	public DataMapperDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(
				EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						dataMapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
/*		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new dataMapper.diagram.edit.policies.DataMapperDiagramItemSemanticEditPolicy());*/
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
/*		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new dataMapper.diagram.edit.policies.DataMapperDiagramCanonicalEditPolicy());*/
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		// installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
		// CustomNonResizableEditPolicyEx()); //remove selection rectangle
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
		return primaryShape = new DataMapperDiagramFigure();
	}

	/**
	 * @generated
	 */
	public RectangleFigure getPrimaryShape() {
		return (RectangleFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(2000, 1000);
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
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		ToolbarLayout layout = new ToolbarLayout();

		layout.setHorizontal(true);
		layout.setSpacing(200);
		layout.setStretchMinorAxis(false); // don't resize children figures with

		StackLayout sLayout = new StackLayout();
		//		layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

		figure.setLayoutManager(sLayout);
		IFigure shape = createNodeShape();

		/*
		 * trst layout
		 */
		//		GridLayout gridL = new GridLayout();
		//		gridL.numColumns = 3;

		//		shape.setLayoutManager(layout);

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
	//	@Override
	//	protected void addChild(EditPart child, int index) {
	//		// TODO Auto-generated method stub
	//		super.addChild(child, index);
	//	}

	/**
	 * @author lali
	 *
	 */
	public class DataMapperDiagramFigure extends DataMapperDiagramBox {
		public DataMapperDiagramFigure() {
			////			RectangleFigure figure = new RectangleFigure();
			//			GridLayout layout = new GridLayout(3, true);
			////			figure.setLayoutManager(layout);
			////			figure.setOutline(false);
			////			this.add(figure);
			//			this.setLayoutManager(layout);
			//			
			//			this.setCornerDimensions(new Dimension(1, 1));
			//			this.setFill(false);
			//			this.setOutline(false);
			//
			//			this.setBorder(new org.eclipse.draw2d.LineBorder(new Color(null, 244, 244, 244), 2, SWT.BORDER_DASH));

			//			DataMapperDiagramFigure datamapperDiagramBox = new DataMapperDiagramFigure();
			//			this.add(datamapperDiagramBox);

			ToolbarLayout layoutThis = new ToolbarLayout();

			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			layoutThis.setSpacing(50);
			layoutThis.setHorizontal(true);

			this.setLayoutManager(layoutThis);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(300),
					getMapMode().DPtoLP(400)));
			this.setOutline(false);
			this.setBackgroundColor(new Color(null, 255, 255, 255));
			this.setForegroundColor(new Color(null, 0, 0, 0));
			layoutThis.setStretchMinorAxis(false);

		}

		public void add(IFigure figure, Object constraint, int index) {

			if (figure.getChildren().get(0).toString().substring(30, 40)
					.equalsIgnoreCase("Operations")) {
				ToolbarLayout layout = new ToolbarLayout();
				layout.setHorizontal(false);
				//				layout.setSpacing(5);

				//				figure.setBorder(new org.eclipse.draw2d.LineBorder(new Color(
				//						null, 244, 100, 144), 2, SWT.BORDER_DASH));
				super.add(figure, layout, 1);
			} else if (figure instanceof DefaultSizeNodeFigure) {
				GridData layoutData = new GridData();
				//				layoutData.grabExcessHorizontalSpace = true;
				//				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = SWT.CENTER;
				layoutData.verticalAlignment = SWT.CENTER;
				//				figure.setBorder(new org.eclipse.draw2d.LineBorder(new Color(
				//						null, 144, 144, 144), 2, SWT.BORDER_DASH));
				super.add(figure, layoutData, index);
			}

			else {
				ToolbarLayout layout = new ToolbarLayout();
				layout.setHorizontal(false);

				figure.setBorder(new org.eclipse.draw2d.LineBorder(new Color(
						null, 244, 100, 144), 2, SWT.BORDER_DASH));
				super.add(figure, layout, 1);
			}
		}
	}
}
