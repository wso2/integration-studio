package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.RowLayout;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractSequencesEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlow5ItemSemanticEditPolicy;

/**
 * @generated NOT
 */
public class MediatorFlow5EditPart extends AbstractMediatorFlowEditPart {

	/* Sequences */

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3615;

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
	public MediatorFlow5EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new MediatorFlow5ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new MediatorFlowFigure();
	}

	/**
	 * @generated
	 */
	public MediatorFlowFigure getPrimaryShape() {
		return (MediatorFlowFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	public void refreshConnector(EditPart childEditPart) {
		if (childEditPart instanceof AbstractSequencesEditPart) {
			AbstractSequencesEditPart sequencesEditPart = (AbstractSequencesEditPart) childEditPart;
			if (null == sequencesEditPart.outputConnectorFigure)
				return;
			BorderItemLocator outputLocator = new FixedBorderItemLocator(this.getFigure(),
					sequencesEditPart.outputConnectorFigure, PositionConstants.WEST, 0.5);
			sequencesEditPart.getBorderedFigure().getBorderItemContainer()
					.add(sequencesEditPart.outputConnectorFigure, outputLocator);

			BorderItemLocator inputLocator = new FixedBorderItemLocator(this.getFigure(),
					sequencesEditPart.inputConnectorFigure, PositionConstants.EAST, 0.5);
			sequencesEditPart.getBorderedFigure().getBorderItemContainer()
					.add(sequencesEditPart.inputConnectorFigure, inputLocator);
		} else {
			// Should handle properly.
			throw new ClassCastException();
		}
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		refreshConnector(((AbstractSequencesEditPart) childEditPart.getParent().getParent()));
		super.addChildVisual(childEditPart, -1);
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

	public boolean isSelectable() {
		return false;
	}

	@Override
	public AbstractOutputConnectorEditPart getAssociatedOutputConnector() {
		return EditorUtils.getOutputConnector((ShapeNodeEditPart) this.getParent(),
				SequencesOutputConnectorEditPart.class);
	}

	/**
	 * @generated NOT
	 */
	public class MediatorFlowFigure extends RoundedRectangle {

		/**
		 * @generated NOT
		 */
		public MediatorFlowFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginHeight = 1;
			layoutThis.marginWidth = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			// Create top rectangle.
			RoundedRectangle topRectangle = new RoundedRectangle();
			topRectangle.setCornerDimensions(new Dimension(0, 0));
			topRectangle.setOutline(false);
			topRectangle.setBackgroundColor(new Color(null, 0, 125, 133));
			topRectangle.setPreferredSize(new Dimension(195, 20));
			topRectangle.setMinimumSize(new Dimension(195, 20));

			GridLayout topRectangleLayout = new GridLayout();
			topRectangleLayout.numColumns = 1;
			topRectangleLayout.horizontalSpacing = 0;
			topRectangleLayout.verticalSpacing = 0;
			topRectangleLayout.marginHeight = 0;
			topRectangleLayout.marginWidth = 0;
			topRectangle.setLayoutManager(topRectangleLayout);
			// topRectangle.setLayoutManager(new ToolbarLayout(true));

			GridData topRectangleGridData = new GridData();
			topRectangleGridData.verticalAlignment = GridData.FILL;
			topRectangleGridData.horizontalAlignment = GridData.FILL;
			topRectangleGridData.horizontalIndent = 1;
			topRectangleGridData.horizontalSpan = 1;
			topRectangleGridData.verticalAlignment = 1;
			topRectangleGridData.verticalSpan = 1;
			topRectangleGridData.grabExcessHorizontalSpace = true;
			topRectangleGridData.grabExcessVerticalSpace = false;

			this.add(topRectangle, topRectangleGridData);

			GridData constraintEsbNodeTypeNameRectangle = new GridData();
			constraintEsbNodeTypeNameRectangle.verticalAlignment = GridData.CENTER;
			constraintEsbNodeTypeNameRectangle.horizontalAlignment = GridData.BEGINNING;
			constraintEsbNodeTypeNameRectangle.horizontalIndent = 2;
			constraintEsbNodeTypeNameRectangle.horizontalSpan = 1;
			constraintEsbNodeTypeNameRectangle.verticalSpan = 1;
			constraintEsbNodeTypeNameRectangle.grabExcessHorizontalSpace = true;
			constraintEsbNodeTypeNameRectangle.grabExcessVerticalSpace = true;

			WrappingLabel sequenceNameLabel = new WrappingLabel();
			// TODO set the sequence name here. 
			sequenceNameLabel.setText("");
			sequenceNameLabel.setForegroundColor(new Color(null, 0, 0, 0));
			sequenceNameLabel.setFont(new Font(null, "Arial", 10, SWT.NONE));
			sequenceNameLabel.setAlignment(SWT.CENTER);
			sequenceNameLabel.setPreferredSize(new Dimension(64, 20));

			topRectangle.add(sequenceNameLabel, constraintEsbNodeTypeNameRectangle);

			this.setCornerDimensions(new Dimension(1, 1));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(195), getMapMode().DPtoLP(125)));
			this.setLineStyle(Graphics.LINE_DASH);
			this.setLineWidth(2);
			this.setLineDashOffset(2.0f);
			this.setForegroundColor(new Color(null, 0, 0, 0));
		}

		public void add(IFigure figure, Object constraint, int index) {
			if (figure instanceof BorderedNodeFigure) {
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

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 255, 255);

}
