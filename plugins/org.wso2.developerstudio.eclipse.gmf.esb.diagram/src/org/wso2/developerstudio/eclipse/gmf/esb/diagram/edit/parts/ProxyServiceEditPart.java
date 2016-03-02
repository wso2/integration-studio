package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import java.beans.PropertyChangeListener;
import java.util.ListIterator;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ProxyServiceGroupBox;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.ProxyServiceCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.ProxyServiceItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;

/**
 * @generated NOT
 */
public class ProxyServiceEditPart extends AbstractBaseFigureEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * figure update status
	 */
	private boolean figureUpdated;

	/**
	 * @generated
	 */
	public ProxyServiceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ProxyServiceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ProxyServiceCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new CustomNonResizableEditPolicyEx()); //remove 8 corners
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case ProxyOutputConnectorEditPart.VISUAL_ID:
				case ProxyInputConnectorEditPart.VISUAL_ID:
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

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new ProxyServiceFigure() {
			public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
				super.setBounds(rect);
				if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
					alignLeft();
				}
				if (!figureUpdated) {
					updateFigure();
				}

			};
		};
	}

	private void updateFigure() {
		ProxyService proxyService = (ProxyService) (((View) getModel()).getElement());
		if (proxyService.isMainSequence()) {
			OUTER: for (ListIterator<?> i = getChildren().listIterator(); i.hasNext();) {
				Object next = i.next();
				if (next instanceof ProxyServiceContainerEditPart) {
					ProxyServiceContainerEditPart proxyContainerEP = (ProxyServiceContainerEditPart) next;
					for (ListIterator<?> j = proxyContainerEP.getChildren().listIterator(); j.hasNext();) {
						Object nextChild = j.next();
						if (nextChild instanceof ProxyServiceFaultContainerEditPart) {
							ProxyServiceFaultContainerEditPart faultContainerEP = (ProxyServiceFaultContainerEditPart) nextChild;
							IFigure faultContainerFigure = faultContainerEP.getFigure();

							faultContainerFigure.setPreferredSize(new Dimension(0, 0));
							faultContainerFigure.setMaximumSize(new Dimension(0, 0));
							faultContainerFigure.setMinimumSize(new Dimension(0, 0));
							faultContainerFigure.setVisible(false);

							break OUTER;
						}
					}

				}
			}
			AbstractInputConnectorEditPart faultInputConnector = EditorUtils.getProxyFaultInputConnector(this);
			if (faultInputConnector != null) {
				removeChildVisual(faultInputConnector);
			}
			figureUpdated = true;
		}
	}

	private void alignLeft() {
		alignLeft(getFigure().getBounds().y, getFigure().getBounds().width, getFigure().getBounds().height);
	}

	private void alignLeft(int y, int width, int height) {
		y = 100;
		Rectangle constraints = new Rectangle(0, y, width, height);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), constraints);
	}

	/**
	 * @generated
	 */
	public ProxyServiceFigure getPrimaryShape() {
		return (ProxyServiceFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ProxyServiceNameEditPart) {
			((ProxyServiceNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureProxyNamePropertyLabel());
			return true;
		}
		if (childEditPart instanceof ProxyOutputConnectorEditPart) {
			outputConnectorFigure = ((ProxyOutputConnectorEditPart) childEditPart).getFigure();
			/*			BorderItemLocator locator = new FixedBorderItemLocator(
			 (IFigure) ((IFigure) ((IFigure) (IFigure) getFigure()
			 .getChildren().get(0)).getChildren().get(0))
			 .getChildren().get(0), outputConnectorFigure,
			 PositionConstants.EAST, 0.25);
			 getBorderedFigure().getBorderItemContainer().add(outputConnectorFigure,
			 locator);*/

			return false;
		}
		if (childEditPart instanceof ProxyInputConnectorEditPart) {
			inputConnectorFigure = ((ProxyInputConnectorEditPart) childEditPart).getFigure();
			/*
			 BorderItemLocator locator = new FixedBorderItemLocator(
			 (IFigure) ((IFigure) ((IFigure) (IFigure) getFigure()
			 .getChildren().get(0)).getChildren().get(0))
			 .getChildren().get(0), inputConnectorFigure,
			 PositionConstants.EAST, 0.75);
			 getBorderedFigure().getBorderItemContainer().add(inputConnectorFigure,
			 locator);*/

			return false;
		}
		if (childEditPart instanceof ProxyOutSequenceOutputConnectorEditPart) {
			outSequenceOutputConnectorFigure = ((ProxyOutSequenceOutputConnectorEditPart) childEditPart).getFigure();
			return false;
		}

		if (childEditPart instanceof ProxyFaultInputConnectorEditPart) {
			faultInputnputConnectorFigure = ((ProxyFaultInputConnectorEditPart) childEditPart).getFigure();

			return false;
		}

		if (childEditPart instanceof ProxyInSequenceInputConnectorEditPart) {
			inSequenceInputConnectorFigure = ((ProxyInSequenceInputConnectorEditPart) childEditPart).getFigure();
			IFigure figure = ((GraphicalEditPart) ((GraphicalEditPart) ((GraphicalEditPart) getChildren().get(5))
					.getChildren().get(0)).getChildren().get(0)).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(
			/*(IFigure) ((IFigure) ((IFigure) (IFigure) getFigure()
			.getChildren().get(0)).getChildren().get(0))
			.getChildren().get(1)*/figure, inSequenceInputConnectorFigure, PositionConstants.EAST, 0.25);
			getBorderedFigure().getBorderItemContainer().add(inSequenceInputConnectorFigure, locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated NOT
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ProxyServiceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ProxyOutputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((ProxyOutputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ProxyInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((ProxyInputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ProxyInSequenceInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((ProxyInSequenceInputConnectorEditPart) childEditPart).getFigure());
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
	protected NodeFigure createMainFigure() {
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
		return getChildBySemanticHint(EsbVisualIDRegistry.getType(ProxyServiceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public class ProxyServiceFigure extends ProxyServiceGroupBox {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureProxyNamePropertyLabel;

		/**
		 * @generated NOT
		 */
		public ProxyServiceFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layoutThis.setSpacing(0);
			layoutThis.setVertical(false);

			this.setLayoutManager(layoutThis);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(300), getMapMode().DPtoLP(400)));
			this.setOutline(false);
			this.setBackgroundColor(THIS_BACK);
			this.setForegroundColor(new Color(null, 0, 0, 0));
			createContents();
		}

		public void addPropertyChangeListener(PropertyChangeListener listener) {
			// TODO Auto-generated method stub
			super.addPropertyChangeListener(listener);
		}

		public void add(IFigure figure, Object constraint, int index) {
			if (figure instanceof DefaultSizeNodeFigure) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			} else if (figure instanceof RoundedRectangle) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			}

			else {
				super.add(figure, constraint, index);
			}
		}

		/**
		 * @generated NOT
		 * @customizations add the property label to parent figure
		 */
		private void createContents() {
			fFigureProxyNamePropertyLabel = getProxyNameLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureProxyNamePropertyLabel() {
			return fFigureProxyNamePropertyLabel;
		}

		public String getIconPath() {
			return "icons/ico20/proxy.gif";
		}

		public String getNodeName() {
			return "Proxy";
		}

		public Color getBackgroundColor() {
			return THIS_BACK;
		}

		public Color getLabelBackColor() {
			return THIS_LABEL_BACK;
		}
	}

	/**
	 * @generated NOT
	 */
	static final Color THIS_BACK = new Color(null, 255, 255, 255);
	//static final Color THIS_BACK = new Color(null, 60, 120, 60);
	static final Color THIS_LABEL_BACK = new Color(null, 0, 0, 0);
}
