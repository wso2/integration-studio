package org.wso2.developerstudio.datamapper.diagram.edit.parts;

import org.apache.avro.Schema;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
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
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.wso2.developerstudio.datamapper.Attribute;
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Output;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;
import org.wso2.developerstudio.datamapper.diagram.tree.generator.TreeFromAVSC;
import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;

/**
 * @generated
 */
public class OutputEditPart extends ShapeNodeEditPart {

	private static final int X = 800;

	private static final int Y = 200;

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

	public void activate() {
		super.activate();
	}

	public void resetOutputTreeFromFile(String filePath) {
		EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (this)
				.getModel()).getElement();
		Output iip = (Output) parentContainer;

		DeleteCommand deleteComand = new DeleteCommand(getEditingDomain(), iip.getTreeNode());
		if (deleteComand.canExecute()) {
			getEditingDomain().getCommandStack().execute(deleteComand);
		}

		TreeNode treeNode = DataMapperFactory.eINSTANCE.createTreeNode();
		Tree tree = TreeFromAVSC.generateInputTreeFromFile(filePath);
		convertTree(tree, treeNode);

		AddCommand addTreeNodeCmd2 = new AddCommand(getEditingDomain(), parentContainer,
				DataMapperPackage.Literals.OUTPUT__TREE_NODE, treeNode);
		if (addTreeNodeCmd2.canExecute()) {
			getEditingDomain().getCommandStack().execute(addTreeNodeCmd2);
		}
		getPrimaryShape().setPreferredSize(250, 15);

	}

	/**
	 * @param schema
	 *            Avro schema that is used to parse to tree
	 */
	public void resetOutputTreeFromSchema(Schema schema) {
		EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (this)
				.getModel()).getElement();
		Output iip = (Output) parentContainer;

		DeleteCommand deleteComand = new DeleteCommand(getEditingDomain(), iip.getTreeNode());
		if (deleteComand.canExecute()) {
			getEditingDomain().getCommandStack().execute(deleteComand);
		}

		TreeNode treeNode = DataMapperFactory.eINSTANCE.createTreeNode();
		Tree tree = TreeFromAVSC.generateInputTreeFromSchema(schema);
		convertTree(tree, treeNode);

		AddCommand addTreeNodeCmd2 = new AddCommand(getEditingDomain(), parentContainer,
				DataMapperPackage.Literals.OUTPUT__TREE_NODE, treeNode);
		if (addTreeNodeCmd2.canExecute()) {
			getEditingDomain().getCommandStack().execute(addTreeNodeCmd2);
		}
		getPrimaryShape().setPreferredSize(250, 15);
	}

	private void convertTree(Tree tree, TreeNode treeNode) {

		//treeNode.setName(tree.getCount() + "," + tree.getName());
		treeNode.setName(tree.getName());
		treeNode.setLevel(tree.getCount());
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
				treeNode.setSchemaDataType(SchemaDataType.RECORD);
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

		if (!(tree.getElements().isEmpty())) {
			for (org.wso2.developerstudio.datamapper.diagram.tree.model.Element element : tree
					.getElements()) {
				createElement(element, treeNode);
			}
		}
		if (!(tree.getAttributes().isEmpty())) {
			for (org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute attribute : tree
					.getAttributes()) {
				createAttribute(attribute, treeNode);
			}
		}
		if (!(tree.getTrees().isEmpty())) {
			for (Tree treeN : tree.getTrees()) {
				createTree(treeN, treeNode);
			}
		}

	}

	private void createElement(
			org.wso2.developerstudio.datamapper.diagram.tree.model.Element element,
			TreeNode treeNode) {
		Element ele = DataMapperFactory.eINSTANCE.createElement();
		//ele.setName(element.getCount() + "," + element.getName());
		ele.setName(element.getName());
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
				ele.setSchemaDataType(SchemaDataType.RECORD);
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
		if (!(element.getAttribute().isEmpty())) {
			for (org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute attribute : element
					.getAttribute()) {
				createAttribute(attribute, treeNode);
			}
		}
	}

	private void createAttribute(
			org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute attribute,
			TreeNode treeNode) {
		Attribute attr = DataMapperFactory.eINSTANCE.createAttribute();
		attr.setName(attribute.getCount() + "," + attribute.getName());
		treeNode.getAttribute().add(attr);
	}

	private void createTree(Tree treeN, TreeNode treeNode) {
		TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();
		//treeNodeNew.setName(treeN.getCount() + "," + treeN.getName());
		treeNodeNew.setName(treeN.getName());
		treeNodeNew.setLevel(treeN.getCount());
		if (treeN.getSchemaType() != null) {
			switch (treeN.getSchemaType()) {
			case ARRAY:
				treeNodeNew.setSchemaDataType(SchemaDataType.ARRAY);
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
				treeNodeNew.setSchemaDataType(SchemaDataType.RECORD);
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

		if (!(treeN.getElements().isEmpty())) {
			for (org.wso2.developerstudio.datamapper.diagram.tree.model.Element element : treeN
					.getElements()) {
				createElement(element, treeNodeNew);
			}
		}
		if (!(treeN.getAttributes().isEmpty())) {
			for (org.wso2.developerstudio.datamapper.diagram.tree.model.Attribute attribute : treeN
					.getAttributes()) {
				createAttribute(attribute, treeNodeNew);
			}
		}
		if (!(treeN.getTrees().isEmpty())) {
			for (Tree treeNew : treeN.getTrees()) {
				createTree(treeNew, treeNodeNew);
			}
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
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.OutputItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.OutputCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());

		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
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
						((BoundsImpl) notification.getNotifier()).getWidth(),
						((BoundsImpl) notification.getNotifier()).getHeight());
				FigureCanvas canvas = (FigureCanvas) getViewer().getControl();
				canvas.getViewport().repaint();
			}
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
				getFigure().getBounds().width, getFigure().getBounds().height);
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
			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);
			this.setLayoutManager(layoutThis);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(250), getMapMode().DPtoLP(100)));
			this.setOutline(true);

			TitleBarBorder titleBarBorder = new TitleBarBorder("Output");
			titleBarBorder.setBackgroundColor(new Color(null, 96, 148, 219));
			titleBarBorder.setTextColor(new Color(null, 0, 0, 0));
			titleBarBorder.setFont(new Font(null, "Arial", 10, SWT.NORMAL));
			this.setBorder(titleBarBorder);

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