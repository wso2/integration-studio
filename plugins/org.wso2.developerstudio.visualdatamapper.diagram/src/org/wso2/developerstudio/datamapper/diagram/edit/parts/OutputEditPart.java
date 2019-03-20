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

import java.io.IOException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MouseListener;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Output;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.action.AddNewRootAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.LoadInputSchemaAction;
import org.wso2.developerstudio.datamapper.diagram.custom.action.LoadOutputSchemaAction;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ImageHolder;
import org.wso2.developerstudio.datamapper.diagram.custom.util.TreeNodeUtils;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.OutputCanonicalEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.edit.policies.OutputItemSemanticEditPolicy;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.ISchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.SchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.SchemaTransformerRegistry;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated
 */
public class OutputEditPart extends ShapeNodeEditPart {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final int X = 600;

	private static final int Y = 200;
	TreeNode outputRootTreeNode;
	private static final int LEAF_HEIGHT = 20;
	private static final int LEAF_WIDTH = 3;
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
	protected OutputEditPart thisEditPart;

	/**
	 * @generated
	 */
	public OutputEditPart(View view) {
		super(view);
		thisEditPart = this;
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
		Figure fig = (Figure) primaryShape;

		EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (this).getModel()).getElement();
		Output iip = (Output) parentContainer;

		DeleteCommand deleteComand = new DeleteCommand(getEditingDomain(), iip.getTreeNode());
		if (deleteComand.canExecute()) {
			getEditingDomain().getCommandStack().execute(deleteComand);
		}

	    if (fig.getChildren() != null && !fig.getChildren().isEmpty()) {
	            fig.remove((IFigure) fig.getChildren().get(0));
	    }

		outputRootTreeNode = DataMapperFactory.eINSTANCE.createTreeNode();
		ISchemaTransformer schemaTransformer;
		try {
			schemaTransformer = SchemaTransformerRegistry.getInstance().getSchemaTransformer().newInstance();
			if (schemaTransformer instanceof SchemaTransformer) {
				String content = schemaTransformer.getSchemaContentFromFile(filePath);
				outputRootTreeNode = schemaTransformer.generateTree(content, outputRootTreeNode);
			} else {
				Tree tree = schemaTransformer.generateTreeFromFile(filePath);
				convertTree(tree, outputRootTreeNode);
			}

		} catch (InstantiationException | IllegalAccessException | NullPointerException | IllegalArgumentException
				| IOException e) {
			log.error("Error in generating the tree", e);
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
	 * @generated NOT
	 */
	private void convertTree(Tree tree, TreeNode treeNode) {

		// treeNode.setName(tree.getCount() + "," + tree.getName());
		treeNode.setName(tree.getName());
		treeNode.setLevel(tree.getCount());
		/*
		 * treeNode.setNamespace(tree.getNamespace());
		 * treeNode.setDoc(tree.getDoc());
		 * treeNode.getAliases().addAll(tree.getAliases());
		 */
		if (tree.getSchemaType() != null) {
			switch (tree.getSchemaType()) {
			case ARRAY:
				treeNode.setSchemaDataType(SchemaDataType.ARRAY);
				break;
			case BOOLEAN:
				treeNode.setSchemaDataType(SchemaDataType.BOOLEAN);
				break;
			case BYTES:
				treeNode.setSchemaDataType(SchemaDataType.BYTES);
				break;
			case DOUBLE:
				treeNode.setSchemaDataType(SchemaDataType.DOUBLE);
				break;
			case ENUM:
				treeNode.setSchemaDataType(SchemaDataType.ENUM);
				break;
			case FIXED:
				treeNode.setSchemaDataType(SchemaDataType.FIXED);
				break;
			case FLOAT:
				treeNode.setSchemaDataType(SchemaDataType.FLOAT);
				break;
			case INT:
				treeNode.setSchemaDataType(SchemaDataType.INT);
				break;
			case LONG:
				treeNode.setSchemaDataType(SchemaDataType.LONG);
				break;
			case MAP:
				treeNode.setSchemaDataType(SchemaDataType.MAP);
				break;
			case NULL:
				treeNode.setSchemaDataType(SchemaDataType.NULL);
				break;
			case RECORD:
				treeNode.setSchemaDataType(SchemaDataType.OBJECT);
				break;
			case STRING:
				treeNode.setSchemaDataType(SchemaDataType.STRING);
				break;
			case UNION:
				treeNode.setSchemaDataType(SchemaDataType.UNION);
				break;
			default:
				break;
			}
		}

		if (!(tree.getTrees().isEmpty())) {
			for (Tree treeN : tree.getTrees()) {
				createTree(treeN, treeNode);
			}
		}

		/*
		 * if (!(tree.getAttributes().isEmpty())) { for
		 * (org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute
		 * attribute : tree .getAttributes()) { createAttribute(attribute,
		 * treeNode); } }
		 */

		if (!(tree.getElements().isEmpty())) {
			for (org.wso2.developerstudio.datamapper.diagram.tree.model.Element element : tree.getElements()) {
				createElement(element, treeNode);
			}
		}

	}

	/**
	 * @generated NOT
	 */
	private void createElement(org.wso2.developerstudio.datamapper.diagram.tree.model.Element element,
			TreeNode treeNode) {
		Element ele = DataMapperFactory.eINSTANCE.createElement();
		// ele.setName(element.getCount() + "," + element.getName());
		ele.setName(element.getName());
		// ele.setDoc(element.getDoc());
		/*
		 * if(element.getOrder() != null){
		 * ele.setOrder(element.getOrder().toString()); }
		 * if(element.getDefault() != null){
		 * ele.setDefault(element.getDefault().toString()); }
		 * ele.getAliases().addAll(element.getAliases());
		 */
		ele.setLevel(element.getCount());
		if (element.getSchemaType() != null) {
			switch (element.getSchemaType()) {
			case ARRAY:
				ele.setSchemaDataType(SchemaDataType.ARRAY);
				break;
			case BOOLEAN:
				ele.setSchemaDataType(SchemaDataType.BOOLEAN);
				break;
			case BYTES:
				ele.setSchemaDataType(SchemaDataType.BYTES);
				break;
			case DOUBLE:
				ele.setSchemaDataType(SchemaDataType.DOUBLE);
				break;
			case ENUM:
				ele.setSchemaDataType(SchemaDataType.ENUM);
				break;
			case FIXED:
				ele.setSchemaDataType(SchemaDataType.FIXED);
				break;
			case FLOAT:
				ele.setSchemaDataType(SchemaDataType.FLOAT);
				break;
			case INT:
				ele.setSchemaDataType(SchemaDataType.INT);
				break;
			case LONG:
				ele.setSchemaDataType(SchemaDataType.LONG);
				break;
			case MAP:
				ele.setSchemaDataType(SchemaDataType.MAP);
				break;
			case NULL:
				ele.setSchemaDataType(SchemaDataType.NULL);
				break;
			case RECORD:
				ele.setSchemaDataType(SchemaDataType.OBJECT);
				break;
			case STRING:
				ele.setSchemaDataType(SchemaDataType.STRING);
				break;
			case UNION:
				ele.setSchemaDataType(SchemaDataType.UNION);
				break;
			default:
				break;
			}
		}
		treeNode.getElement().add(ele);
		/*
		 * if (!(element.getAttribute().isEmpty())) { for
		 * (org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute
		 * attribute : element .getAttribute()) { createAttribute(attribute,
		 * treeNode); } }
		 */
	}

	/**
	 * @generated NOT
	 */
	/*
	 * private void createAttribute(
	 * org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute
	 * attribute, TreeNode treeNode) { Attribute attr =
	 * DataMapperFactory.eINSTANCE.createAttribute();
	 * attr.setName(attribute.getCount() + "," + attribute.getName());
	 * attr.setDoc(attribute.getDoc()); treeNode.getAttribute().add(attr); }
	 */

	private void createTree(Tree treeN, TreeNode treeNode) {
		TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();

		if (treeN.getSchemaType() != null) {
			switch (treeN.getSchemaType()) {
			case ARRAY:
				treeNodeNew.setSchemaDataType(SchemaDataType.ARRAY);
				treeNodeNew.setName(treeN.getName());
				treeNodeNew.setLevel(treeN.getCount());
				break;
			case BOOLEAN:
				treeNodeNew.setSchemaDataType(SchemaDataType.BOOLEAN);
				break;
			case BYTES:
				treeNodeNew.setSchemaDataType(SchemaDataType.BYTES);
				break;
			case DOUBLE:
				treeNodeNew.setSchemaDataType(SchemaDataType.DOUBLE);
				break;
			case ENUM:
				treeNodeNew.setSchemaDataType(SchemaDataType.ENUM);
				break;
			case FIXED:
				treeNodeNew.setSchemaDataType(SchemaDataType.FIXED);
				break;
			case FLOAT:
				treeNodeNew.setSchemaDataType(SchemaDataType.FLOAT);
				break;
			case INT:
				treeNodeNew.setSchemaDataType(SchemaDataType.INT);
				break;
			case LONG:
				treeNodeNew.setSchemaDataType(SchemaDataType.LONG);
				break;
			case MAP:
				treeNodeNew.setSchemaDataType(SchemaDataType.MAP);
				break;
			case NULL:
				treeNodeNew.setSchemaDataType(SchemaDataType.NULL);
				break;
			case RECORD:
				treeNodeNew.setSchemaDataType(SchemaDataType.OBJECT);
				treeNodeNew.setName(treeN.getName());
				treeNodeNew.setLevel(treeN.getCount());
				/*
				 * treeNodeNew.setNamespace(treeN.getNamespace());
				 * treeNodeNew.setDoc(treeN.getDoc());
				 * treeNodeNew.getAliases().addAll(treeN.getAliases());
				 */
				break;
			case STRING:
				treeNodeNew.setSchemaDataType(SchemaDataType.STRING);
				break;
			case UNION:
				treeNodeNew.setSchemaDataType(SchemaDataType.UNION);
				break;
			default:
				break;
			}
		}
		treeNode.getNode().add(treeNodeNew);

		if (!(treeN.getTrees().isEmpty())) {
			for (Tree treeNew : treeN.getTrees()) {
				createTree(treeNew, treeNodeNew);
			}
			reposition();
		}

		if (!(treeN.getElements().isEmpty())) {
			for (org.wso2.developerstudio.datamapper.diagram.tree.model.Element element : treeN.getElements()) {
				createElement(element, treeNodeNew);
			}
		}
		/*
		 * if (!(treeN.getAttributes().isEmpty())) { for
		 * (org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute
		 * attribute : treeN .getAttributes()) { createAttribute(attribute,
		 * treeNodeNew); } }
		 */

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
						((BoundsImpl) notification.getNotifier()).getY(),
						TreeNodeUtils.getTreeWidth(outputRootTreeNode, LEAF_WIDTH),
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
		reposition(getFigure().getBounds().x, getFigure().getBounds().y,
				TreeNodeUtils.getTreeWidth(outputRootTreeNode, LEAF_WIDTH),
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
			LineBorder border = new LineBorder(DataMapperColorConstants.borderColor, 1, Graphics.LINE_SOLID);
			this.setBorder(border);

			TitleBarBorder titleBarBorder = new TitleBarBorder("Output");
			titleBarBorder.setTextAlignment(PositionConstants.CENTER);
			titleBarBorder.setPadding(6);
			titleBarBorder.setBackgroundColor(DataMapperColorConstants.outputTitleBarColor);
			titleBarBorder.setTextColor(DataMapperColorConstants.color_white);
			titleBarBorder.setFont(new Font(null, "Arial", 10, SWT.BOLD));
			this.setBorder(titleBarBorder);

            if (!(this.getChildren() != null && this.getChildren().size() > 1)) {
                int nodeDimension = 64; // width for connection nodes
                ImageFigure addContentImg = new ImageFigure(ImageHolder.getInstance().getAddOutputContentImage());
                ImageFigure addRootImg = new ImageFigure(ImageHolder.getInstance().getAddRootImage());
                addContentImg.setSize(new Dimension(nodeDimension, nodeDimension));
                addRootImg.setSize(new Dimension(nodeDimension, nodeDimension));
                addContentImg.setBounds(new Rectangle(X + 35, Y + 30, 180, 60));
                addRootImg.setBounds(new Rectangle(X + 35, Y + 94, 180, 60));
                addContentImg.setToolTip(new Label("Load Output"));
                addRootImg.setToolTip(new Label("Add new Root Element"));
                RectangleFigure rf = new RectangleFigure();
                rf.setOpaque(true);
                rf.setBounds(new Rectangle(X, Y + 25, TreeNodeUtils.getTreeWidth(outputRootTreeNode, LEAF_WIDTH),
                                TreeNodeUtils.getTreeHeight(outputRootTreeNode, LEAF_HEIGHT) - 25));
                rf.add(addContentImg);
                rf.add(addRootImg);
                this.add(rf);
                addContentImg.addMouseListener(new MouseListener() {
                        @Override
                        public void mousePressed(org.eclipse.draw2d.MouseEvent me) {
                                IWorkbenchPart iwbp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
                                                .getActivePart();
                                LoadOutputSchemaAction losa = new LoadOutputSchemaAction(iwbp);
                                losa.doRun(new NullProgressMonitor());
                        }

                        @Override
                        public void mouseReleased(org.eclipse.draw2d.MouseEvent me) {
                        }

                        @Override
                        public void mouseDoubleClicked(org.eclipse.draw2d.MouseEvent me) {
                        }
                });
                addRootImg.addMouseListener(new MouseListener() {
                        @Override
                        public void mousePressed(org.eclipse.draw2d.MouseEvent me) {
                                IWorkbenchPart iwbp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
                                                .getActivePart();
                                EditPart selectedEP = getSelectedEditPart(iwbp);
                                AddNewRootAction anra = new AddNewRootAction(iwbp, selectedEP);
                               anra.doRun(new NullProgressMonitor());
                        }

                        @Override
                        public void mouseReleased(org.eclipse.draw2d.MouseEvent me) {
                        }

                        @Override
                        public void mouseDoubleClicked(org.eclipse.draw2d.MouseEvent me) {
                        }
                });
            }

		}

		private EditPart getSelectedEditPart(IWorkbenchPart iwbp) {
			IStructuredSelection selection = getStructuredSelection(iwbp);
			if (selection.size() == 1) {
				Object selectedEP = selection.getFirstElement();
				if (selectedEP instanceof DataMapperRootEditPart) {
					return (EditPart)((EditPart) selectedEP).getChildren().get(1);
				}
			}
			// In case of selecting the wrong editpart
			return null;
		}

		private IStructuredSelection getStructuredSelection(IWorkbenchPart iwbp) {
	        ISelection selection = getSelection(iwbp);
	        return (selection instanceof StructuredSelection) ? (StructuredSelection) selection
	            : StructuredSelection.EMPTY;
	    }

		private ISelection getSelection(IWorkbenchPart iwbp) {
	        ISelection selection = null;
	        ISelectionService selectionService = null;
	        if (iwbp != null && iwbp.getSite().getWorkbenchWindow() != null) {
	            selectionService = iwbp.getSite()
	                .getWorkbenchWindow().getSelectionService();
	        }

	        if (selectionService != null) {
	            selection = selectionService.getSelection();
	        }

	        return (selection != null) ? selection
	            : StructuredSelection.EMPTY;
	    }

		/**
		 * @generated NOT
		 */
		protected void fillShape(Graphics graphics) {
			// Backup the graphics colors
			Color bgColor = graphics.getBackgroundColor();
			Color fgColor = graphics.getForegroundColor();
			// Set the graphics color
			graphics.setBackgroundColor(DataMapperColorConstants.outputBoxFillColor);
			graphics.setForegroundColor(DataMapperColorConstants.outputBoxFillColor);
			// Restore the original colors
			graphics.fillGradient(getBounds(), true);
			graphics.setBackgroundColor(bgColor);
			graphics.setForegroundColor(fgColor);
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