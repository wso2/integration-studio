package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
//import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory.LinkToolEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EastPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.WestPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public abstract class AbstractOutputConnector extends AbstractBorderItemEditPart{

	public final boolean isInput=false;
	public static LinkToolEntry entry;
	
	public NodeFigure figure_;
	
	protected IFigure primaryShapeForward;

	public IFigure primaryShapeReverse;
	
	//abstract public IFigure getPrimaryShapeForward();
	//abstract public IFigure getPrimaryShapeReverse();	
	//abstract public NodeFigure getNodeFigureOutput();
	
	
	
	public IFigure createNodeShapeReverse() {
		return primaryShapeReverse = new WestPointerFigure();
	}

	public IFigure createNodeShapeForward() {
		return primaryShapeForward = new EastPointerFigure();
	}


	public EastPointerFigure getPrimaryShapeForward() {
		return (EastPointerFigure) primaryShapeForward;
	}

	public WestPointerFigure getPrimaryShapeReverse() {
		return (WestPointerFigure) primaryShapeReverse;
	}
	
	
	public AbstractOutputConnector(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}


	protected NodeFigure createNodeFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeFigure getNodeFigureOutput() {
		return figure_;
	}
	
	static{
	 entry = new LinkToolEntry(
			Messages.EsbLink1CreationTool_title,
			Messages.EsbLink1CreationTool_desc,
			Collections.singletonList(EsbElementTypes.EsbLink_4001));
	entry.setId("createEsbLink1CreationTool"); //$NON-NLS-1$
	entry.setSmallIcon(EsbElementTypes
			.getImageDescriptor(EsbElementTypes.EsbLink_4001));
	entry.setLargeIcon(entry.getSmallIcon());
	}
	

	
	public static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
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
	
	@Override
	public boolean isSelectable() {
		// TODO Auto-generated method stub
		return false;
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
