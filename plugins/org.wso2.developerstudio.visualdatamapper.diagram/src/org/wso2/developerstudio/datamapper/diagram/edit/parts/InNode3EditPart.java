/*
 * Copyright (c) 2014 -2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import java.util.HashMap;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.custom.AbstractInNodeEditPart;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ImageHolder;

/** 
 * @generated NOT
 */
public class InNode3EditPart extends AbstractInNodeEditPart {
	/**
	 * @generated NOT
	 */
	@Override
	public boolean canAttachNote() {
		return false;
	}

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3015;

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
	public InNode3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new org.wso2.developerstudio.datamapper.diagram.edit.policies.InNode3ItemSemanticEditPolicy());
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
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new InNode3Figure();
	}

	/**
	 * @generated NOT
	 */
	public RectangleFigure getPrimaryShape() {
		return (RectangleFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		/*		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(10, 10);
		
		 //FIXME: workaround for #154536
		 result.getBounds().setSize(result.getPreferredSize());
		 //		return result;
		 */HashMap<String, PrecisionPoint> anchorLocations = new HashMap<String, PrecisionPoint>();
		// The anchor's location is a little bit on the left in order to be sure
		// that the edges will be horizontally oriented
		anchorLocations.put("CENTER", new PrecisionPoint(0.4d, 0.5d));
		CenteredAnchors result = new CenteredAnchors(10, 10, anchorLocations);
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

	class InNode3Figure extends RectangleFigure {
		/**
		 * @generated NOT
		 */
		public InNode3Figure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
			layoutThis.setSpacing(0);
			layoutThis.setVertical(false);
			this.setLayoutManager(layoutThis);
			this.setOpaque(false);
			this.setFill(false);
			this.setOutline(false);
			this.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent me) {
					getEditDomain().getPaletteViewer().setActiveTool(null);
				}

				@Override
				public void mousePressed(MouseEvent me) {
					getEditDomain().getPaletteViewer().setActiveTool((ToolEntry) (((PaletteContainer) getEditDomain()
							.getPaletteViewer().getPaletteRoot().getChildren().get(1)).getChildren().get(0)));
					if (getParent() instanceof TreeNode2EditPart) {
						TreeNode2EditPart treeNode2EditPart = (TreeNode2EditPart) getParent();
						treeNode2EditPart.highlightElementItem();
					}
				}

				@Override
				public void mouseDoubleClicked(MouseEvent me) {
					getEditDomain().getPaletteViewer().setActiveTool((ToolEntry) (((PaletteContainer) getEditDomain()
							.getPaletteViewer().getPaletteRoot().getChildren().get(1)).getChildren().get(0)));
				}
			});
			this.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent me) {
					highlightParentElem();

				}

				@Override
				public void mouseEntered(MouseEvent me) {
					highlightParentElem();
				}

				@Override
				public void mouseExited(MouseEvent me) {
					removeParentHighlight();
				}

				@Override
				public void mouseHover(MouseEvent me) {
					highlightParentElem();
				}

				@Override
				public void mouseMoved(MouseEvent me) {
				}

			});

			createContents();

		}

		/**
		 * @generated NOT
		 */
		private void createContents() {
			int nodeDimension = 10; // width for connection nodes

			ImageFigure mainImg = new ImageFigure(ImageHolder.getInstance().getArrowGreyImage());
			mainImg.setSize(new Dimension(nodeDimension, nodeDimension));
			RectangleFigure mainImageRectangle = new RectangleFigure();
			mainImageRectangle.setOutline(false);
			mainImageRectangle.setBackgroundColor(new Color(null, 255, 255, 255));
			mainImageRectangle.setPreferredSize(new Dimension(nodeDimension, nodeDimension));
			mainImageRectangle.add(mainImg);

			mainImageRectangle.setFill(false);
			mainImageRectangle.setOutline(false);
			this.add(mainImageRectangle);
			this.setOpaque(false);
			this.setOutline(false);
			this.setFill(false);

		}

		private void highlightParentElem() {
			IFigure treeFigure = (IFigure) ((DefaultSizeNodeFigure) ((BorderedNodeFigure) getParent().getParent()
					.getParent()).getChildren().get(0)).getChildren().get(0);
			if (treeFigure instanceof TreeNode2EditPart.TreeNodeFigure) {
				TreeNode2EditPart.TreeNodeFigure num = (TreeNode2EditPart.TreeNodeFigure) treeFigure;
				num.highlightElementOnSelection();
			}
			if (treeFigure instanceof TreeNodeEditPart.TreeNodeFigure) {
				TreeNodeEditPart.TreeNodeFigure num = (TreeNodeEditPart.TreeNodeFigure) treeFigure;
				num.highlightElementOnSelection();
			}
			if (treeFigure instanceof TreeNode3EditPart.TreeNodeFigure) {
				TreeNode3EditPart.TreeNodeFigure num = (TreeNode3EditPart.TreeNodeFigure) treeFigure;
				num.highlightElementOnSelection();
			}
		}

		private void removeParentHighlight() {
			IFigure treeFigure = (IFigure) ((DefaultSizeNodeFigure) ((BorderedNodeFigure) getParent().getParent()
					.getParent()).getChildren().get(0)).getChildren().get(0);
			if (treeFigure instanceof TreeNode2EditPart.TreeNodeFigure) {
				TreeNode2EditPart.TreeNodeFigure num = (TreeNode2EditPart.TreeNodeFigure) treeFigure;
				num.removeHighlight();
			}
			if (treeFigure instanceof TreeNodeEditPart.TreeNodeFigure) {
				TreeNodeEditPart.TreeNodeFigure num = (TreeNodeEditPart.TreeNodeFigure) treeFigure;
				num.removeHighlight();
			}
			if (treeFigure instanceof TreeNode3EditPart.TreeNodeFigure) {
				TreeNode3EditPart.TreeNodeFigure num = (TreeNode3EditPart.TreeNodeFigure) treeFigure;
				num.removeHighlight();
			}
		}
	}

	public void highlightElementItem() {
		//		((InNode3Figure) getPrimaryShape()).highlightElementOnSelection();
	}

}
