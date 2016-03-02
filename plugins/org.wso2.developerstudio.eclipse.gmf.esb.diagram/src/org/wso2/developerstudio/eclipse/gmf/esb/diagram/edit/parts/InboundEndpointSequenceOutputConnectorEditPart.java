package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EastPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.LinkActivateListener;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointOnErrorSequenceOutputConnectorEditPart.EastPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.InboundEndpointSequenceOutputConnectorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;

/**
 * @generated NOT
 */
public class InboundEndpointSequenceOutputConnectorEditPart extends AbstractOutputConnectorEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3769;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	public NodeFigure figure_;

	protected IFigure primaryShapeForward;

	/**
	 * @generated
	 */
	public InboundEndpointSequenceOutputConnectorEditPart(View view) {
		super(view);
	}

	public NodeFigure getNodeFigureOutput() {
		return figure_;
	}

	public IFigure createNodeShapeReverse() {
		return null;
	}

	public IFigure createNodeShapeForward() {
		return primaryShapeForward = new EastPointerFigure();
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InboundEndpointSequenceOutputConnectorItemSemanticEditPolicy());
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new EastPointerFigure();
	}

	/**
	 * @generated
	 */
	public EastPointerFigure getPrimaryShape() {
		return (EastPointerFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(12, 10);

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
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
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		figure_ = figure;
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
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
	public class EastPointerFigure extends RoundedRectangle {

		/**
		 * @generated NOT
		 */
		public EastPointerFigure() {

			this.addMouseMotionListener(new LinkActivateListener(getEditDomain()));

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.marginHeight = 0;
			layoutThis.marginWidth = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(1, 1));
			this.setFill(false);
			this.setOutline(false);
			// this.setBackgroundColor(get);
			this.setPreferredSize(new Dimension(12, 9));
			createContents();
		}

		public void createContents() {
			GridData constraintImageRectangle11 = new GridData();
			constraintImageRectangle11.verticalAlignment = GridData.FILL;
			constraintImageRectangle11.horizontalAlignment = GridData.FILL;
			constraintImageRectangle11.horizontalIndent = 0;
			constraintImageRectangle11.horizontalSpan = 1;
			constraintImageRectangle11.verticalSpan = 2;
			constraintImageRectangle11.grabExcessHorizontalSpace = true;
			constraintImageRectangle11.grabExcessVerticalSpace = true;

			ImageDescriptor imgDesc1 = EsbDiagramEditorPlugin.getBundledImageDescriptor("icons/ico20/arrowEast.png");
			ImageFigure img1 = new ImageFigure(imgDesc1.createImage());
			img1.setSize(new Dimension(12, 9));

			RectangleFigure imageRectangle11 = new RectangleFigure();
			imageRectangle11.setOutline(false);
			imageRectangle11.setBackgroundColor(new Color(null, 255, 255, 255));
			imageRectangle11.setPreferredSize(new Dimension(12, 9));
			imageRectangle11.add(img1);

			this.add(imageRectangle11, constraintImageRectangle11);
		}

	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 50, 50, 50);

}
