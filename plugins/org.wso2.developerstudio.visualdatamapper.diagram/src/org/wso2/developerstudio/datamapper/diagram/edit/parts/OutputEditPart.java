/*
 * Copyright (c) 2014-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Output;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.util.TreeNodeUtils;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.ISchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.SchemaTransformerRegistry;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated
 */
public class OutputEditPart extends ShapeNodeEditPart {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final int X = 800;

	private static final int Y = 200;
	TreeNode outputRootTreeNode;
	private static final int LEAF_HEIGHT = 20;
	private static final int OUTPUT_BOX_WIDTH = 250;

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

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
	public OutputEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean canAttachNote() {
		return false;
	}

	public void activate() {
		super.activate();
	}

	public void resetOutputTreeFromFile(String filePath) {
		EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (this).getModel()).getElement();
		Output iip = (Output) parentContainer;

		DeleteCommand deleteComand = new DeleteCommand(getEditingDomain(), iip.getTreeNode());
		if (deleteComand.canExecute()) {
			getEditingDomain().getCommandStack().execute(deleteComand);
		}

		outputRootTreeNode = DataMapperFactory.eINSTANCE.createTreeNode();
		ISchemaTransformer schemaTransformer;
		try {
			schemaTransformer = SchemaTransformerRegistry.getInstance().getSchemaTransformer().newInstance();
			String content = schemaTransformer.getSchemaContentFromFile(filePath);
			generateTree(content, outputRootTreeNode);
		} catch (InstantiationException | IllegalAccessException e) {
			log.error(e);
		}

		AddCommand addTreeNodeCmd2 = new AddCommand(getEditingDomain(), parentContainer,
				DataMapperPackage.Literals.OUTPUT__TREE_NODE, outputRootTreeNode);
		if (addTreeNodeCmd2.canExecute()) {
			getEditingDomain().getCommandStack().execute(addTreeNodeCmd2);
		}
		getPrimaryShape().setPreferredSize(OUTPUT_BOX_WIDTH, 15);
		reposition();
	}

	/**
	 * Update GMF tree
	 * 
	 * @param content
	 * @param inputRootTreeNode
	 */
	private void generateTree(String content, TreeNode outputRootTreeNode) {
		outputRootTreeNode.setName(content);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
				org.wso2.developerstudio.datamapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.OutputItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.OutputCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());

		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
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
				reposition(((BoundsImpl) notification.getNotifier()).getX(),
						((BoundsImpl) notification.getNotifier()).getY(), OUTPUT_BOX_WIDTH,
						TreeNodeUtils.getTreeHeight(outputRootTreeNode, LEAF_HEIGHT));
				FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
				canvas.getViewport().repaint();
			}

		}

	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		super.addChildVisual(childEditPart, index);

		if (childEditPart.getParent() instanceof OutputEditPart) {
			OutputEditPart oep = (OutputEditPart) childEditPart.getParent();
			DataMapperRootEditPart rep = (DataMapperRootEditPart) oep.getParent();
			DataMapperRoot rootDiagram = (DataMapperRoot) ((DiagramImpl) rep.getModel()).getElement();
			outputRootTreeNode = rootDiagram.getOutput().getTreeNode().get(0);
			reposition();
		}
	}

	private void reposition(int x, int y, int width, int height) {
		if (y == 0) {
			y = Y;
			x = X;
		}
		Rectangle constraints = new Rectangle(x, y, width, height);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), constraints);
		FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
		canvas.getViewport().repaint();
	}

	private void reposition() {
		reposition(getFigure().getBounds().x, getFigure().getBounds().y, OUTPUT_BOX_WIDTH,
				TreeNodeUtils.getTreeHeight(outputRootTreeNode, LEAF_HEIGHT));
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new OutputFigure() {
			public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
				super.setBounds(rect);
				reposition();
			};
		};
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
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
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
	public class OutputFigure extends RectangleFigure {

		private WrappingLabel fFigureTargetNameFigure;

		/**
		 * @generated NOT
		 */
		@SuppressWarnings("deprecation")
		public OutputFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			layoutThis.setVertical(true);
			layoutThis.setSpacing(10);
			this.setLayoutManager(layoutThis);

			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(250), getMapMode().DPtoLP(400)));
			this.setOutline(true);

			TitleBarBorder titleBarBorder = new TitleBarBorder("Output");
			titleBarBorder.setPadding(6);
			titleBarBorder.setBackgroundColor(new Color(null, 0, 125, 133));
			titleBarBorder.setTextColor(new Color(null, 0, 0, 0));
			titleBarBorder.setFont(new Font(null, "Arial", 10, SWT.BOLD));
			CompoundBorder compoundBorder = new CompoundBorder(titleBarBorder, new LineBorder(new Color(null, 0, 125,
					133), 2, Graphics.LINE_SOLID));
			this.setBorder(compoundBorder);

		}

		/**
		 * @generated NOT
		 */
		@SuppressWarnings("unused")
		private void createContents() {

			fFigureTargetNameFigure = new WrappingLabel();

			fFigureTargetNameFigure.setText("Output");

			this.add(fFigureTargetNameFigure);

		}

	}

}