package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.datamapper.impl.ConstantImpl;
import org.wso2.developerstudio.datamapper.impl.OperatorImpl;
import org.wso2.developerstudio.datamapper.impl.PropertiesImpl;

/**
 * @generated NOT
 */
public class OperatorRightConnectorEditPart extends AbstractBorderedShapeEditPart {

	private Label connectorLabel;

	NodeFigure figure;
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3017;

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
	public OperatorRightConnectorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean canAttachNote() {
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.OperatorRightConnectorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.OperatorRightConnectorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		/* Disable dragging and resizing */
		NonResizableEditPolicy selectionPolicy = new CustomNonResizableEditPolicyEx();
		selectionPolicy.setDragAllowed(false);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, selectionPolicy);
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

	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof OutNode3EditPart) {
			IFigure borderItemFigure = ((OutNode3EditPart) childEditPart).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.EAST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof OutNode3EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((OutNode3EditPart) childEditPart).getFigure());
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
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {

		RectangleFigure primaryShape = new RectangleFigure();
		primaryShape.setBorder(new LineBorder(ColorConstants.black, 1, Graphics.LINE_SOLID));
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 20);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createMainFigure() {
		figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		shape.setBorder(null);
		figure.add(shape);
		figure.setBorder(null);
		addRightConnectorLabel();
		contentPane = setupContentPane(shape);
		return figure;
	}

	public boolean addRightConnectorLabel() {
		EditPart parentEditPart = this.getParent().getParent().getParent();
		OperatorImpl operator = (OperatorImpl) ((View) parentEditPart.getModel()).getElement();
		String outputLabel = getOutputLabel(operator);
		if (operator instanceof ConstantImpl) {
			ConstantImpl constantImpl = (ConstantImpl) operator;
			if (constantImpl.getType() != null && constantImpl.getConstantValue() != null) {
				if (figure != null) {
					connectorLabel = new Label(outputLabel + " [" + constantImpl.getType().getLiteral() + "] ");
					figure.add(connectorLabel);
					return true;
				}
			} else {
				if (figure != null) {
					connectorLabel = new Label(outputLabel + " " + getPossibleOutputVariableTypes(operator) + " ");
					figure.add(connectorLabel);
					return true;
				}
			}
		} else {
			if (figure != null) {
				connectorLabel = new Label(outputLabel + " " + getPossibleOutputVariableTypes(operator) + " ");
				figure.add(connectorLabel);
				return true;
			}
		}
		return false;
	}

	private String getPossibleOutputVariableTypes(OperatorImpl operator) {
		int connectorIndex = operator.getRightConnectorCount();
		if (operator.getOutputVariableTypes().containsKey(connectorIndex)) {
			return operator.getOutputVariableTypes().get(connectorIndex).toString();
		} else {
			while (connectorIndex > 0) {
				--connectorIndex;
				if (operator.getOutputVariableTypes().containsKey(connectorIndex)) {
					return operator.getOutputVariableTypes().get(connectorIndex).toString();
				}
			}
		}
		throw new IllegalArgumentException("Target connector not found in Operator " + operator.getOperatorType()
				+ " output variable Map : " + operator.getOutputVariableTypes().keySet());
	}

	private String getOutputLabel(OperatorImpl operator) {
		List<String> outputLabels = operator.getOutputLabelList();
		if (outputLabels.size() == 1) {
			return formatLabel(outputLabels.get(0));
		} else if (outputLabels.size() > 1) {
			int rightConnectorIndex = operator.getRightConnectorCount();
			operator.setRightConnectorCount(rightConnectorIndex + 1);
			return formatLabel(outputLabels.get(rightConnectorIndex));
		}
		return "";
	}

	private String formatLabel(String inputLabel) {
		return " " + inputLabel + " :";
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

	public void setConstantTypeInConnector(SchemaDataType constantType) {
		if (figure != null) {
			figure.remove(connectorLabel);
			connectorLabel = new Label("Const :" + " [" + constantType.getLiteral() + "] ");
			figure.add(connectorLabel);
		}
	}

	public void setPropertyTypeInConnector(SchemaDataType constantType) {
		if (figure != null) {
			figure.remove(connectorLabel);
			connectorLabel = new Label("Value :" + " [" + constantType.getLiteral() + "] ");
			figure.add(connectorLabel);
		}
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

}
