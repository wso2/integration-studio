package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.connections;

import java.awt.MouseInfo;
import java.util.ArrayList;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart.EastPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart.WestPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AdditionalOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DropMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;

/*
 * This class is used to handle automatic connection creation stuffs. 
 * 
 */
public class ConnectionCalculator {

	private static Point currentFigureLocation = null;
	private static Point connectorFigureLocation = null;

	public static EsbLinkEditPart getNearestLinkEditPart(ArrayList links,
			AbstractBorderedShapeEditPart childEditPart) {
		double current = 0.0;
		ArrayList<EsbLinkEditPart> nearLinks = new ArrayList<EsbLinkEditPart>();
		double distance = 0.0;
		double distanceToUpperLine = 0.0;
		double distanceToBottomLine = 0.0;
		EsbLinkEditPart nearestLink = null;
		EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) EditorUtils.getActiveEditor();
		double zoom = esbMultiPageEditor.getZoom();

		if (childEditPart != null) {
			updateCurrentStatesForLinks(childEditPart);

			for (int i = 0; i < links.size(); ++i) {
				if (!links.get(i).equals(childEditPart)) {

					int xLeft = ((EsbLinkEditPart) links.get(i)).getFigure()
							.getBounds().getLeft().x;
					int xRight = (((EsbLinkEditPart) links.get(i)).getFigure()
							.getBounds().getRight().x);
					double actualCurrentPosition = currentFigureLocation.x;
					if ((xLeft < actualCurrentPosition)
							&& (actualCurrentPosition < xRight)) {
						nearLinks.add((EsbLinkEditPart) links.get(i));						
					}
				}
			}
		}
		for (int q = 0; q < nearLinks.size(); ++q) {
			if ((((nearLinks.get(q).getFigure().getBounds().getLeft().y) < ((currentFigureLocation.y) + (70*zoom))) && ((currentFigureLocation.y) < (nearLinks
					.get(q).getFigure().getBounds().getBottomLeft().y)))
					|| (((nearLinks.get(q).getFigure().getBounds().getLeft().y) > (currentFigureLocation.y + (70*zoom))) && ((currentFigureLocation.y) > (nearLinks
							.get(q).getFigure().getBounds().getBottomLeft().y)))) {
				return (EsbLinkEditPart) nearLinks.get(q);
			}

			distanceToUpperLine = nearLinks.get(q).getFigure().getBounds()
					.getLeft().y
					- currentFigureLocation.y;

			distanceToUpperLine = Math.abs(distanceToUpperLine);
			distanceToBottomLine = nearLinks.get(q).getFigure().getBounds()
					.getBottomLeft().y
					- currentFigureLocation.y;
			distanceToBottomLine = Math.abs(distanceToBottomLine);

			if (distanceToUpperLine > distanceToBottomLine) {
				distance = distanceToBottomLine;
			} else {
				distance = distanceToUpperLine;
			}
			if (current == 0.0) {
				current = distance;
				nearestLink = (EsbLinkEditPart) nearLinks.get(q);
			} else if (distance < current) {
				current = distance;
				nearestLink = (EsbLinkEditPart) nearLinks.get(q);
			}
		}
		if (current > (35*zoom)) {
			return null;
		}
		return nearestLink;
	}

	public static ShapeNodeEditPart getNearestConnectorEditPart(
			ArrayList<AbstractConnectorEditPart> connectors,
			ShapeNodeEditPart childEditPart) {
		AbstractConnectorEditPart nearForwardConnector = null;
		AbstractConnectorEditPart nearReverseConnector = null;
		AbstractConnectorEditPart nearConnector = null;
		AbstractConnectorEditPart currentConnector = null;
		int yCurrent = 0, yDistance1 = 0, yDistance2 = 0;
		double EastDistance = 0, EastCurrent = 0, WestCurrent = 0, WestDistance = 0;

		if (childEditPart != null) {

			if ((connectors.size() != 0)) {
				if (connectors.get(0) instanceof AbstractInputConnectorEditPart) {
					currentConnector = EditorUtils
							.getInputConnector(childEditPart);
				} else {
					currentConnector = EditorUtils
							.getOutputConnector(childEditPart);
				}
			}
			
			/*
			 * Drop mediator doesn't have an Output connector. 
			 */
			if(childEditPart instanceof DropMediatorEditPart){
				currentConnector = EditorUtils
						.getInputConnector(childEditPart);
			}

			for (int i = 0; i < connectors.size(); ++i) {

				IFigure figure = (IFigure) ((DefaultSizeNodeFigure) connectors
						.get(i).getFigure()).getChildren().get(0);

				if ((currentConnector!=null)&&(!connectors.get(i).equals(currentConnector))
						&& (!connectors.get(i).getParent()
								.equals(currentConnector.getParent()))) {
					
					updateCurrentStatesForConnectors(currentConnector);
					updateCurrentStatesForGivenFigure(connectors.get(i));
				
					double xLeft=connectorFigureLocation.x;
					double actualCurrentPosition = currentFigureLocation.x;					
					if ((figure instanceof EastPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart.EastPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutputConnectorEditPart.EastPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutputConnectorEditPart.EastPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesOutputConnectorEditPart.EastPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesInputConnectorEditPart.EastPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AdditionalOutputConnector.EastPointerFigure)) {

						if((figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutputConnectorEditPart.EastPointerFigure)
								||(figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutputConnectorEditPart.EastPointerFigure)){
							xLeft=xLeft-82;
						}
						EastDistance = Math.abs(xLeft - actualCurrentPosition);
						if (((connectors.get(i) instanceof AbstractOutputConnectorEditPart) && (xLeft < actualCurrentPosition))
								|| ((connectors.get(i) instanceof AbstractInputConnectorEditPart) && (xLeft > actualCurrentPosition))) {
							if ((EastCurrent == 0)
									|| (EastCurrent > EastDistance)) {
								EastCurrent = EastDistance;
								nearForwardConnector = connectors.get(i);
							}
						}
					} else if ((figure instanceof WestPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart.WestPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInputConnectorEditPart.WestPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInputConnectorEditPart.WestPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointOutputConnectorEditPart.WestPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyFaultInputConnectorEditPart.WestPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutSequenceOutputConnectorEditPart.WestPointerFigure)
							|| (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutSequenceOutputConnectorEditPart.WestPointerFigure)) {

						WestDistance = Math.abs(xLeft - actualCurrentPosition);
						if (((connectors.get(i) instanceof AbstractOutputConnectorEditPart) && (xLeft > actualCurrentPosition))
								|| ((connectors.get(i) instanceof AbstractInputConnectorEditPart) && (xLeft < actualCurrentPosition))) {
							if ((WestCurrent == 0)
									|| (WestCurrent > WestDistance)) {
								WestCurrent = WestDistance;
								nearReverseConnector = connectors.get(i);
							}
						}
					}
				}
			}
		}
		if (nearForwardConnector != null) {
			updateCurrentStatesForGivenFigure(nearForwardConnector);
			if((nearForwardConnector.getParent() instanceof ProxyServiceEditPart)
					||(nearForwardConnector.getParent() instanceof APIResourceEditPart)){
				int parentY=((AbstractBaseFigureEditPart)nearForwardConnector.getParent()).getLocation().y;
				yDistance1 = Math
						.abs(connectorFigureLocation.y-parentY
								- currentFigureLocation.y);
			}else{
				yDistance1 = Math
				.abs(connectorFigureLocation.y
						- currentFigureLocation.y);
			}
		}
		if (nearReverseConnector != null) {
			updateCurrentStatesForGivenFigure(nearReverseConnector);
			if((nearReverseConnector.getParent() instanceof ProxyServiceEditPart)
					||(nearReverseConnector.getParent() instanceof APIResourceEditPart)){
				int parentY=((AbstractBaseFigureEditPart)nearReverseConnector.getParent()).getLocation().y;
				yDistance2 = Math
				.abs(connectorFigureLocation.y-parentY
						- currentFigureLocation.y);
			}else{
				yDistance2 = Math
						.abs(connectorFigureLocation.y
								- currentFigureLocation.y);
			}
			
		}
		if ((yDistance1 != 0)
				&& ((yDistance2 == 0) || (yDistance1 < yDistance2))) {
			yCurrent = yDistance1;
			nearConnector = nearForwardConnector;
		} else {
			yCurrent = yDistance2;
			nearConnector = nearReverseConnector;
		}
		if (yCurrent > 35) {
			nearConnector = null;
		}
				
		/*
		 * If 'nearConnector' is null we have to check again whether dropped
		 * mediator is the first element of a compartment of a complex mediator.
		 * If it is true we have to use following logic to get nearest
		 * connection.
		 */
		
		if (nearConnector == null) {
			if (childEditPart.getParent() instanceof AbstractMediatorFlowCompartmentEditPart) {
				int compartmentCenter_y = ((AbstractMediatorFlowCompartmentEditPart) childEditPart
						.getParent()).getFigure().getBounds().getCenter().y;
				if (EditorUtils.getMediator(childEditPart.getParent()) != null) {
					ArrayList<AdditionalOutputConnector> additionalConnectors = EditorUtils
							.getMediatorAdditionalOutputConnectors(EditorUtils
									.getMediator(childEditPart.getParent()));
					AdditionalOutputConnector temp = null;
					int diff_temp = 0;
					for (AdditionalOutputConnector con : additionalConnectors) {
						int diff = Math.abs(con.getLocation().y
								- compartmentCenter_y);
						if (diff_temp == 0) {
							temp = con;
							diff_temp = diff;
						} else if (diff < diff_temp) {
							temp = con;
							diff_temp = diff;
						}
					}
					if (connectors.get(0) instanceof AbstractOutputConnectorEditPart) {
						nearConnector = temp;
					}
				}
			}
		}			
		return nearConnector;
	}

	private static void updateCurrentStatesForLinks(
			ShapeNodeEditPart childEditPart) {
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;

		Control ctrl = childEditPart.getViewer().getControl();
		FigureCanvas canvas = (FigureCanvas) ctrl;
		int horizontal = canvas.getHorizontalBar().getSelection();
		int vertical = canvas.getVerticalBar().getSelection();

		EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) EditorUtils.getActiveEditor();
		double zoom = esbMultiPageEditor.getZoom();
		/*
		 * Commented following two line of codes to get rid of the issue - When
		 * element is dropped inside the compartment of a complex
		 * mediator(Aggregate etc.) at the border of it, it is connected to
		 * outer mediator flow but resides inside the compartment.
		 */
		//horizontal += 20;
		//vertical += 30;
		org.eclipse.swt.graphics.Point p = canvas.toDisplay(0, 0);	
		currentFigureLocation = new Point((((x - p.x) + horizontal)/zoom), (((y - p.y)
				+ vertical)/zoom));
	}	
	
	private static void updateCurrentStatesForGivenFigure(
			ShapeNodeEditPart childEditPart) {
		connectorFigureLocation = new Point(
				childEditPart.getLocation().x, childEditPart.getLocation().y);
	}

	private static void updateCurrentStatesForConnectors(
			ShapeNodeEditPart childEditPart) {
		currentFigureLocation = new Point(
				childEditPart.getLocation().x, childEditPart.getLocation().y);
	}
}
