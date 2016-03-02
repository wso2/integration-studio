package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnector.EastPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnector.WestPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EastPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.WestPointerShape;

public abstract class AbstractEndpointOutputConnector extends AbstractBorderItemEditPart {

public NodeFigure figure_;
	
	protected IFigure primaryShapeForward;
	public IFigure primaryShapeReverse;
	
	public AbstractEndpointOutputConnector(View view) {
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
	
	public class EastPointerFigure extends EastPointerShape {

		
		public EastPointerFigure() {

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(10)));
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
		}

	}

	public class WestPointerFigure extends WestPointerShape {

		public WestPointerFigure() {

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(10)));
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
		}

	}
	
	static final Color THIS_BACK = new Color(null, 50, 50, 50);

}
