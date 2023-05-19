package org.wso2.integrationstudio.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;
import org.eclipse.swt.graphics.Color;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.CustomNonResizableEditPolicyEx;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.EditPartDrawingHelper;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.policies.SynapseAPIItemSemanticEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.utils.DiagramCustomConstants;

/**
 * @generated
 */
public class SynapseAPIEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3668;

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
    public SynapseAPIEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SynapseAPIItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
        // Remove clickable corners to stop drag drop
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new CustomNonResizableEditPolicyEx());
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

    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        if (notification.getFeature() instanceof EAttributeImpl) {
            if (notification.getNotifier() instanceof BoundsImpl) {
                int y = ((BoundsImpl) notification.getNotifier()).getY();
                if (y == -1) {
                    y = +2;
                }
                alignLeft(y, ((BoundsImpl) notification.getNotifier()).getWidth(),
                        ((BoundsImpl) notification.getNotifier()).getHeight());
                FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
                canvas.getViewport().repaint();

            }
        }
    }
    
    private void alignLeft(int y, int width, int height) {
        y = 0;
        Rectangle constraints = new Rectangle(0, y, width, height);
        ((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), constraints);
    }
    
    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        primaryShape = new RectangleFigure();
        primaryShape.setPreferredSize(new Dimension(getMapMode().DPtoLP(600), getMapMode().DPtoLP(500)));
        primaryShape.setBackgroundColor(new Color(null, 250, 250, 250));
        return primaryShape;
    }

    /**
     * @generated
     */
    public RectangleFigure getPrimaryShape() {
        return (RectangleFigure) primaryShape;
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
     * @generated NOT
     */
    protected NodeFigure createNodeFigure() {

        ToolbarLayout apiToolbarLayout = new ToolbarLayout();
        apiToolbarLayout.setStretchMinorAxis(true);
        apiToolbarLayout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
        apiToolbarLayout.setSpacing(0);
        apiToolbarLayout.setHorizontal(true);

        ImageFigure apiIconImageFigure = EditPartDrawingHelper
                .getIconImageFigure(DiagramCustomConstants.API_ICON_LOCATION, 50, 50);

        // Left rectangle for API editor canvas
        RoundedRectangle apiLeftIconBox = new RoundedRectangle();
        apiLeftIconBox.setMaximumSize(new Dimension(50, 6000));
        apiLeftIconBox.setSize(new Dimension(50, 200));
        apiLeftIconBox.setBackgroundColor(new Color(null, 41, 128, 185));
        apiLeftIconBox.setLayoutManager(new StackLayout());
        apiLeftIconBox.add(apiIconImageFigure);

        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(apiToolbarLayout);
        figure.add(apiLeftIconBox);
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
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
     * @generated NOT
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            //            primaryShape.setBackgroundColor(color);
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

}
