package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
//import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory.LinkToolEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EastPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.WestPointerShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public abstract class AbstractMediatorOutputConnectorEditPart extends AbstractOutputConnectorEditPart{

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
	
	public AbstractMediatorOutputConnectorEditPart(View view) {
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
			this.setPreferredSize(new Dimension(22, 18));
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

			ImageFigure img1 = EditPartDrawingHelper.getEastArrowIcon(22, 18);
			this.add(img1, constraintImageRectangle11);

		}

	}
	
	@Override
	public boolean isSelectable() {
		// TODO Auto-generated method stub
		return false;
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
			this.setPreferredSize(new Dimension(22, 18));			
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

			ImageFigure img1 = EditPartDrawingHelper.getWestArrowIcon(22, 18);
			this.add(img1, constraintImageRectangle11);

		}

	}
	static final Color THIS_BACK = new Color(null, 50, 50, 50);
	
	

}
