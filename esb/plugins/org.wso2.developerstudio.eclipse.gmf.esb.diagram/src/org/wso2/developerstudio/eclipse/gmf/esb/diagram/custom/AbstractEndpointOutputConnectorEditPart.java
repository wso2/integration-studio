package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart.EastPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart.WestPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EastPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.WestPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;

public abstract class AbstractEndpointOutputConnectorEditPart extends AbstractOutputConnectorEditPart {

public NodeFigure figure_;
	
	protected IFigure primaryShapeForward;
	public IFigure primaryShapeReverse;
	
	public AbstractEndpointOutputConnectorEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}
	
	public IFigure createNodeShapeReverse() {
		return primaryShapeReverse = new EastPointerFigure();
	}

	public IFigure createNodeShapeForward() {
		return primaryShapeForward = new WestPointerFigure();
	}

	public WestPointerFigure getPrimaryShapeForward() {
		return (WestPointerFigure) primaryShapeForward;
	}

	public EastPointerFigure getPrimaryShapeReverse() {
		return (EastPointerFigure) primaryShapeReverse;
	}
	
	public NodeFigure getNodeFigureOutput() {
		return figure_;
	}
	
	public class EastPointerFigure extends RoundedRectangle {

		
		public EastPointerFigure() {

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
			this.setPreferredSize(new Dimension(30, 30));
			this.addMouseMotionListener(new MouseMotionListener() {

				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				public void mouseHover(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				public void mouseExited(MouseEvent arg0) {
					if (getEditDomain().getPaletteViewer().getActiveTool()
							.getId().equals("createEsbLink1CreationTool")) {
					getEditDomain().getPaletteViewer().setActiveTool(null);
					}

				}

				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub	
					if (getEditDomain().getPaletteViewer().getActiveTool()
							.getId().equals("selectionTool")) {
						getEditDomain()
								.getPaletteViewer()
								.setActiveTool(
										(ToolEntry) (((PaletteContainer) getEditDomain()
												.getPaletteViewer()
												.getPaletteRoot().getChildren()
												.get(4)).getChildren().get(0)));

					}
				}

				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
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

			ImageFigure img1 = EditPartDrawingHelper.getEastArrowIcon(30, 30);
			this.add(img1, constraintImageRectangle11);

		}

	}

	public class WestPointerFigure extends RoundedRectangle {

		public WestPointerFigure() {

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
			this.setPreferredSize(new Dimension(30, 30));
			this.addMouseMotionListener(new MouseMotionListener() {

				public void mouseMoved(MouseEvent me) {
					// TODO Auto-generated method stub

				}

				public void mouseHover(MouseEvent me) {
					// TODO Auto-generated method stub

				}

				public void mouseExited(MouseEvent me) {
					if (getEditDomain().getPaletteViewer().getActiveTool()
							.getId().equals("createEsbLink1CreationTool")) {
					getEditDomain().getPaletteViewer().setActiveTool(null);
					}

				}

				public void mouseEntered(MouseEvent me) {
					// TODO Auto-generated method stub
					if (getEditDomain().getPaletteViewer().getActiveTool()
							.getId().equals("selectionTool")) {
						getEditDomain()
								.getPaletteViewer()
								.setActiveTool(
										(ToolEntry) (((PaletteContainer) getEditDomain()
												.getPaletteViewer()
												.getPaletteRoot().getChildren()
												.get(4)).getChildren().get(0)));

					}
				}

				public void mouseDragged(MouseEvent me) {
					// TODO Auto-generated method stub

				}
			});
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

			ImageFigure img1 = EditPartDrawingHelper.getWestArrowIcon(30, 30);
			this.add(img1, constraintImageRectangle11);

		}

	}
	
	static final Color THIS_BACK = new Color(null, 50, 50, 50);

}
