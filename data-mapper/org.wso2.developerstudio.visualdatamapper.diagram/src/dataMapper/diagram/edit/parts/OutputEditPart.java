package dataMapper.diagram.edit.parts;



import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.FrameBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

import dataMapper.*;
import dataMapper.diagram.edit.parts.custom.CustomNonResizableEditPolicyEx;
import dataMapper.diagram.tree.generator.TestTreeModel;
import dataMapper.diagram.tree.generator.TreeFromAvro;
import dataMapper.diagram.tree.model.Tree;


/**
 * @generated
 */
public class OutputEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

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
	private boolean notActivated = true;

	public void activate() {

		super.activate();
		if (notActivated) {
			EObject parentContainer = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (this)
					.getModel()).getElement();
			TreeNode treeNode = DataMapperFactory.eINSTANCE.createTreeNode();

			Tree tree = new Tree();
			tree = (new TreeFromAvro()).generateOutputTree();
			convertTree(tree, treeNode);

			AddCommand addTreeNodeCmd = new AddCommand(getEditingDomain(),
					parentContainer,
					DataMapperPackage.Literals.OUTPUT__TREE_NODE, treeNode);
			if (addTreeNodeCmd.canExecute()) {
				getEditingDomain().getCommandStack().execute(addTreeNodeCmd);

			}
			getPrimaryShape().setPreferredSize(250, 15);
			notActivated = false;
		}

	}

	private void convertTree(Tree tree, TreeNode treeNode) {

		treeNode.setName(tree.getCount() + "," + tree.getName());

		if (!(tree.getElements().isEmpty())) {
			for (dataMapper.diagram.tree.model.Element element : tree.getElements()) {
				createElement(element, treeNode);
			}
		}
		if (!(tree.getAttributes().isEmpty())) {
			for (dataMapper.diagram.tree.model.Attribute attribute : tree.getAttributes()) {
				createAttribute(attribute, treeNode);
			}
		}
		if (!(tree.getTrees().isEmpty())) {
			for (Tree treeN : tree.getTrees()) {
				createTree(treeN, treeNode);
			}
		}

	}

	private void createElement(dataMapper.diagram.tree.model.Element element, TreeNode treeNode) {
		Element ele = DataMapperFactory.eINSTANCE.createElement();
		ele.setName(element.getCount() + "," + element.getName());
		treeNode.getElement().add(ele);
		if (!(element.getAttribute().isEmpty())) {
			for (dataMapper.diagram.tree.model.Attribute attribute : element.getAttribute()) {
				createAttribute(attribute, treeNode);
			}
		}
	}

	private void createAttribute(dataMapper.diagram.tree.model.Attribute attribute,
			TreeNode treeNode) {
		Attribute attr = DataMapperFactory.eINSTANCE.createAttribute();
		attr.setName(attribute.getCount() + "," + attribute.getName());
		treeNode.getAttribute().add(attr);
	}

	private void createTree(Tree treeN, TreeNode treeNode) {
		TreeNode treeNodeNew = DataMapperFactory.eINSTANCE.createTreeNode();
		treeNode.getNode().add(treeNodeNew);
		treeNodeNew.setName(treeN.getCount() + "," + treeN.getName());

		if (!(treeN.getElements().isEmpty())) {
			for (dataMapper.diagram.tree.model.Element element : treeN.getElements()) {
				createElement(element, treeNodeNew);
			}
		}
		if (!(treeN.getAttributes().isEmpty())) {
			for (dataMapper.diagram.tree.model.Attribute attribute : treeN.getAttributes()) {
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
						dataMapper.diagram.part.DataMapperVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new dataMapper.diagram.edit.policies.OutputItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new dataMapper.diagram.edit.policies.OutputCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new CustomNonResizableEditPolicyEx()); 
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
		return primaryShape = new OutputFigure();
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
		public OutputFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);
			this.setLayoutManager(layoutThis);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(250),
					getMapMode().DPtoLP(100)));

			this.setOutline(true);
			this.setFill(false);

			this.setBorder(new TitleBarBorder("Output"));

		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureTargetNameFigure = new WrappingLabel();

			fFigureTargetNameFigure.setText("Output");

			this.add(fFigureTargetNameFigure);

		}

	}

}
