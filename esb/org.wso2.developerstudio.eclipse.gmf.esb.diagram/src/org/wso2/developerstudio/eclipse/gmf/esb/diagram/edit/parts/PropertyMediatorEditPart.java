package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

/*
 * package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;
 * 
 * import org.eclipse.draw2d.IFigure;
 * import org.eclipse.draw2d.PositionConstants;
 * import org.eclipse.draw2d.Shape;
 * import org.eclipse.draw2d.StackLayout;
 * import org.eclipse.gef.EditPart;
 * import org.eclipse.gef.EditPolicy;
 * import org.eclipse.gef.Request;
 * import org.eclipse.gef.commands.Command;
 * import org.eclipse.gef.editpolicies.LayoutEditPolicy;
 * import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
 * import org.eclipse.gef.requests.CreateRequest;
 * import
 * org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
 * import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
 * import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
 * import
 * org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy
 * ;
 * import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
 * import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
 * import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
 * import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
 * import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
 * import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
 * import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
 * import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
 * import org.eclipse.gmf.runtime.notation.View;
 * import org.eclipse.swt.SWT;
 * import org.eclipse.swt.graphics.Color;
 * import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
 * import
 * org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
 * import
 * org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShape;
 * import
 * org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator
 * ;
 * import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.
 * ShowPropertyViewEditPolicy;
 * import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.
 * PropertyMediatorCanonicalEditPolicy;
 * import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.
 * PropertyMediatorItemSemanticEditPolicy;
 * import
 * org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
 *//**
 * @generated NOT
 */
/*
 * public class PropertyMediatorEditPart extends AbstractMediator {
 *//**
 * @generated
 */
/*
 * public static final int VISUAL_ID = 3032;
 *//**
 * @generated
 */
/*
 * protected IFigure contentPane;
 *//**
 * @generated
 */
/*
 * protected IFigure primaryShape;
 *//**
 * @generated
 */
/*
 * public PropertyMediatorEditPart(View view) {
 * super(view);
 * }
 *//**
 * @generated NOT
 */
/*
 * protected void createDefaultEditPolicies() {
 * installEditPolicy(EditPolicyRoles.CREATION_ROLE,
 * new CreationEditPolicy());
 * super.createDefaultEditPolicies();
 * installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
 * new PropertyMediatorItemSemanticEditPolicy());
 * installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
 * new DragDropEditPolicy());
 * installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
 * new PropertyMediatorCanonicalEditPolicy());
 * installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
 * // For handle Double click Event.
 * installEditPolicy(EditPolicyRoles.OPEN_ROLE,
 * new ShowPropertyViewEditPolicy());
 * // XXX need an SCR to runtime to have another abstract superclass that would
 * let children add reasonable editpolicies
 * //
 * removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles
 * .CONNECTION_HANDLES_ROLE);
 * }
 *//**
 * @generated
 */
/*
 * protected LayoutEditPolicy createLayoutEditPolicy() {
 * org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new
 * org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {
 * 
 * protected EditPolicy createChildEditPolicy(EditPart child) {
 * View childView = (View) child.getModel();
 * switch (EsbVisualIDRegistry.getVisualID(childView)) {
 * case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
 * case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
 * return new BorderItemSelectionEditPolicy();
 * }
 * EditPolicy result = child
 * .getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
 * if (result == null) {
 * result = new NonResizableEditPolicy();
 * }
 * return result;
 * }
 * 
 * protected Command getMoveChildrenCommand(Request request) {
 * return null;
 * }
 * 
 * protected Command getCreateCommand(CreateRequest request) {
 * return null;
 * }
 * };
 * return lep;
 * }
 *//**
 * @generated
 */
/*
 * protected IFigure createNodeShape() {
 * return primaryShape = new PropertyMediatorFigure();
 * }
 *//**
 * @generated
 */
/*
 * public PropertyMediatorFigure getPrimaryShape() {
 * return (PropertyMediatorFigure) primaryShape;
 * }
 *//**
 * @generated NOT
 * @customizations: fixed border locators for connectors
 */
/*
 * protected boolean addFixedChild(EditPart childEditPart) {
 * 
 * if (childEditPart instanceof PropertyMediatorInputConnectorEditPart) {
 * 
 * IFigure borderItemFigure = ((PropertyMediatorInputConnectorEditPart)
 * childEditPart)
 * .getFigure();
 * BorderItemLocator locator = new FixedBorderItemLocator(
 * getMainFigure(), borderItemFigure, PositionConstants.WEST,
 * 0.5);
 * getBorderedFigure().getBorderItemContainer().add(borderItemFigure,
 * locator);
 * return true;
 * 
 * } else if (childEditPart instanceof PropertyMediatorOutputConnectorEditPart)
 * {
 * 
 * IFigure borderItemFigure = ((PropertyMediatorOutputConnectorEditPart)
 * childEditPart)
 * .getFigure();
 * BorderItemLocator locator = new FixedBorderItemLocator(
 * getMainFigure(), borderItemFigure, PositionConstants.EAST,
 * 0.5);
 * getBorderedFigure().getBorderItemContainer().add(borderItemFigure,
 * locator);
 * 
 * return true;
 * }
 * if (childEditPart instanceof PropertyMediatorPropertyNameEditPart) {
 * ((PropertyMediatorPropertyNameEditPart) childEditPart)
 * .setLabel(getPrimaryShape()
 * .getFigurePropertyMediatorPropertyValueLabel());
 * return true;
 * }
 * return false;
 * }
 *//**
 * @generated
 */
/*
 * protected boolean removeFixedChild(EditPart childEditPart) {
 * if (childEditPart instanceof PropertyMediatorPropertyNameEditPart) {
 * return true;
 * }
 * if (childEditPart instanceof PropertyMediatorInputConnectorEditPart) {
 * getBorderedFigure().getBorderItemContainer().remove(
 * ((PropertyMediatorInputConnectorEditPart) childEditPart)
 * .getFigure());
 * return true;
 * }
 * if (childEditPart instanceof PropertyMediatorOutputConnectorEditPart) {
 * getBorderedFigure().getBorderItemContainer().remove(
 * ((PropertyMediatorOutputConnectorEditPart) childEditPart)
 * .getFigure());
 * return true;
 * }
 * return false;
 * }
 *//**
 * @generated
 */
/*
 * protected void addChildVisual(EditPart childEditPart, int index) {
 * if (addFixedChild(childEditPart)) {
 * return;
 * }
 * super.addChildVisual(childEditPart, -1);
 * }
 *//**
 * @generated
 */
/*
 * protected void removeChildVisual(EditPart childEditPart) {
 * if (removeFixedChild(childEditPart)) {
 * return;
 * }
 * super.removeChildVisual(childEditPart);
 * }
 *//**
 * @generated
 */
/*
 * protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
 * if (editPart instanceof IBorderItemEditPart) {
 * return getBorderedFigure().getBorderItemContainer();
 * }
 * return getContentPane();
 * }
 *//**
 * @generated
 */
/*
 * protected NodeFigure createNodePlate() {
 * DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
 * return result;
 * }
 *//**
 * Creates figure for this edit part.
 * 
 * Body of this method does not depend on settings in generation model
 * so you may safely remove <i>generated</i> tag and modify it.
 * 
 * @generated
 */
/*
 * protected NodeFigure createMainFigure() {
 * NodeFigure figure = createNodePlate();
 * figure.setLayoutManager(new StackLayout());
 * IFigure shape = createNodeShape();
 * figure.add(shape);
 * contentPane = setupContentPane(shape);
 * return figure;
 * }
 *//**
 * Default implementation treats passed figure as content pane.
 * Respects layout one may have set for generated figure.
 * 
 * @param nodeShape
 *            instance of generated figure class
 * @generated
 */
/*
 * protected IFigure setupContentPane(IFigure nodeShape) {
 * if (nodeShape.getLayoutManager() == null) {
 * ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
 * layout.setSpacing(5);
 * nodeShape.setLayoutManager(layout);
 * }
 * return nodeShape; // use nodeShape itself as contentPane
 * }
 *//**
 * @generated
 */
/*
 * public IFigure getContentPane() {
 * if (contentPane != null) {
 * return contentPane;
 * }
 * return super.getContentPane();
 * }
 *//**
 * @generated
 */
/*
 * protected void setForegroundColor(Color color) {
 * if (primaryShape != null) {
 * primaryShape.setForegroundColor(color);
 * }
 * }
 *//**
 * @generated
 */
/*
 * protected void setBackgroundColor(Color color) {
 * if (primaryShape != null) {
 * primaryShape.setBackgroundColor(color);
 * }
 * }
 *//**
 * @generated
 */
/*
 * protected void setLineWidth(int width) {
 * if (primaryShape instanceof Shape) {
 * ((Shape) primaryShape).setLineWidth(width);
 * }
 * }
 *//**
 * @generated
 */
/*
 * protected void setLineType(int style) {
 * if (primaryShape instanceof Shape) {
 * ((Shape) primaryShape).setLineStyle(style);
 * }
 * }
 *//**
 * @generated
 */
/*
 * public EditPart getPrimaryChildEditPart() {
 * return getChildBySemanticHint(EsbVisualIDRegistry
 * .getType(PropertyMediatorPropertyNameEditPart.VISUAL_ID));
 * }
 *//**
 * @generated
 */
/*
 * public class PropertyMediatorFigure extends EsbGraphicalShape {
 *//**
 * @generated
 */
/*
 * private WrappingLabel fFigurePropertyMediatorPropertyValueLabel;
 *//**
 * @generated
 */
/*
 * public PropertyMediatorFigure() {
 * 
 * this.setBackgroundColor(THIS_BACK);
 * createContents();
 * }
 *//**
 * @generated NOT
 */
/*
 * private void createContents() {
 * 
 * fFigurePropertyMediatorPropertyValueLabel = new WrappingLabel();
 * fFigurePropertyMediatorPropertyValueLabel.setText("<...>");
 * 
 * fFigurePropertyMediatorPropertyValueLabel.setAlignment(SWT.CENTER);
 * 
 * this.getPropertyValueRectangle1().add(
 * fFigurePropertyMediatorPropertyValueLabel);
 * }
 *//**
 * @generated
 */
/*
 * public WrappingLabel getFigurePropertyMediatorPropertyValueLabel() {
 * return fFigurePropertyMediatorPropertyValueLabel;
 * }
 * 
 * public String getIconPath() {
 * return "icons/ico20/property-mediator.gif";
 * }
 * 
 * public String getNodeName() {
 * return "Property";
 * }
 * 
 * }
 *//**
 * @generated
 */
/*
 * static final Color THIS_BACK = new Color(null, 230, 230, 230);
 * 
 * public boolean getIsForward() {
 * return isForward;
 * }
 * 
 * public void setIsForward(boolean isForward_) {
 * isForward = isForward_;
 * 
 * }
 * 
 * }
 */

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
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
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.PropertyMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.PropertyMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated NOT
 */
public class PropertyMediatorEditPart extends FixedSizedAbstractMediator {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3492;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public PropertyMediatorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PropertyMediatorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new PropertyMediatorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
				case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
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
		return primaryShape = new PropertyMediatorFigure() {
			public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
				super.setBounds(rect);
				if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
					connectToMostSuitableElement();
					reAllocate(rect);
				}
			};
		};
	}

	/**
	 * @generated
	 */
	public PropertyMediatorFigure getPrimaryShape() {
		return (PropertyMediatorFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PropertyMediatorPropertyNameEditPart) {
			((PropertyMediatorPropertyNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigurePropertyMediatorPropertyValueLabel());
			return true;
		}
		if (childEditPart instanceof PropertyMediatorDescriptionEditPart) {
			((PropertyMediatorDescriptionEditPart) childEditPart).setLabel(getPrimaryShape()
					.getPropertyMediatorDescriptionLabel());
			return true;
		}
		if (childEditPart instanceof PropertyMediatorInputConnectorEditPart) {
			IFigure borderItemFigure = ((PropertyMediatorInputConnectorEditPart) childEditPart)
					.getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
					borderItemFigure, PositionConstants.WEST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		if (childEditPart instanceof PropertyMediatorOutputConnectorEditPart) {
			IFigure borderItemFigure = ((PropertyMediatorOutputConnectorEditPart) childEditPart)
					.getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
					borderItemFigure, PositionConstants.EAST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PropertyMediatorPropertyNameEditPart) {
			return true;
		}
		if (childEditPart instanceof PropertyMediatorDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof PropertyMediatorInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((PropertyMediatorInputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof PropertyMediatorOutputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((PropertyMediatorOutputConnectorEditPart) childEditPart).getFigure());
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
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
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
		figure.setLayoutManager(new ToolbarLayout(true));
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

	/*	*//**
			 * @generated
			 */
	/*
	public EditPart getPrimaryChildEditPart() {
	return getChildBySemanticHint(EsbVisualIDRegistry
			.getType(PropertyMediatorPropertyNameEditPart.VISUAL_ID));
	}*/

	/**
	 * @generated
	 */
	public class PropertyMediatorFigure extends EsbGraphicalShapeWithLabel {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePropertyMediatorPropertyValueLabel;

		private WrappingLabel propertyMediatorDescriptionLabel;

		/**
		 * @generated
		 */
		public PropertyMediatorFigure() {

			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigurePropertyMediatorPropertyValueLabel = new WrappingLabel();
			fFigurePropertyMediatorPropertyValueLabel.setText("<...>");
			fFigurePropertyMediatorPropertyValueLabel.setAlignment(SWT.CENTER);
			//this.getPropertyValueRectangle1().add(fFigurePropertyMediatorPropertyValueLabel);

			propertyMediatorDescriptionLabel = getPropertyNameLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePropertyMediatorPropertyValueLabel() {
			return fFigurePropertyMediatorPropertyValueLabel;
		}

		public WrappingLabel getPropertyMediatorDescriptionLabel() {
			return propertyMediatorDescriptionLabel;
		}

		public String getIconPath() {
			return "icons/ico20/property-mediator.gif";
		}

		public String getNodeName() {
			return "Property";
		}

		public IFigure getToolTip() {
			return new Label("Set or remove properties associated with the message");
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 230, 230, 230);

}