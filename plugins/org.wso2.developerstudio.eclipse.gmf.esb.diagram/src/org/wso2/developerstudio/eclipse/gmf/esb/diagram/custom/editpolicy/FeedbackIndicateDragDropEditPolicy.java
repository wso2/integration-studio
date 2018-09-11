/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy;

import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AdditionalOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EndpoinMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart.EastPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart.WestPointerFigure;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment11EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment5EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

/**
 * Installing <b>FeedbackIndicateDragDropEditPolicy</b> will indicate a feedback
 * when drag a node to the canvas from the tool palette
 */
public class FeedbackIndicateDragDropEditPolicy extends DragDropEditPolicy {

    private static IFigure feedbackFigureRed;
    private static Image feedbackImageRed;
    private static IFigure feedbackFigureGreen;
    private static Image feedbackImageGreen;
    private static IFigure feedBackFigureCurrent;

    private static Point currentFigureLocation = null;
    private static Point connectorFigureLocation = null;

    private static final String ALLOW_DROP_ICON_PATH = "/icons/custom/check.png";
    private static final String NOT_ALLOW_DROP_ICON_PATH = "/icons/custom/exclamation.png";
    private static final int WIDTH_OF_PROXYCONNECTOR = 82;

    /**
     * {@inheritDoc}
     */
    protected Command getDropCommand(ChangeBoundsRequest request) {

        if ((getHost() instanceof ShapeCompartmentEditPart)) {
            /* avoiding drag and drop nodes between compartments. */
            return null;
        }
        return super.getDragCommand(request);
    }

    /**
     * {@inheritDoc}
     */
    public void showTargetFeedback(Request request) {
        super.showTargetFeedback(request);
        if (request instanceof CreateUnspecifiedTypeRequest) {
            if (getHost() instanceof ShapeCompartmentEditPart) {
                ShapeCompartmentEditPart host = (ShapeCompartmentEditPart) getHost();
                Command command = host.getCommand(request);
                if (command != null) {
                    if (command.canExecute()) {
                        showFeedBackFigure(true);
                    } else {
                        showFeedBackFigure(false);
                    }
                } else {
                    showFeedBackFigure(false);
                }
            } else {
                if (getHost() instanceof AbstractEndpoint) {
                    showFeedBackFigure(true);
                } else {
                    showFeedBackFigure(false);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void eraseTargetFeedback(Request request) {

        if (feedBackFigureCurrent != null) {
            removeFeedback(feedBackFigureCurrent);
            feedBackFigureCurrent = null;
        }
        super.eraseTargetFeedback(request);
    }

    /**
     * Get feedback figure
     * 
     * @param allowDrop
     *            true if, host is acceptable area for a certain node.
     * @return
     */
    public IFigure getFeedbackFigure(boolean allowDrop) {

        if (feedBackFigureCurrent != null) {
            removeFeedback(feedBackFigureCurrent);
            feedBackFigureCurrent = null;
        }

        if (feedbackFigureGreen == null) {
            Image feedbackImage = SWTResourceManager.getImage(this.getClass(), ALLOW_DROP_ICON_PATH);
            IFigure figure = new ImageFigure(feedbackImage);
            this.feedbackImageGreen = feedbackImage;
            feedbackFigureGreen = figure;
        }
        if (feedbackFigureRed == null) {
            Image feedbackImage = SWTResourceManager.getImage(this.getClass(), NOT_ALLOW_DROP_ICON_PATH);
            IFigure figure = new ImageFigure(feedbackImage);
            this.feedbackImageRed = feedbackImage;
            feedbackFigureRed = figure;
        }

        feedBackFigureCurrent = (allowDrop) ? feedbackFigureGreen : feedbackFigureRed;
        addFeedback(feedBackFigureCurrent);
        return feedBackFigureCurrent;
    }

    /**
     * Show feedback figure in canvas
     * 
     * @param allowDrop
     *            true if, host is acceptable area for a certain node.
     */
    private void showFeedBackFigure(boolean allowDrop) {
        java.awt.Point pointer = MouseInfo.getPointerInfo().getLocation();
        IFigure feedbackFigure = getFeedbackFigure(allowDrop);
        int x = (int) pointer.getX();
        int y = (int) pointer.getY();
        Control ctrl = getHost().getViewer().getControl();
        FigureCanvas canvas = (FigureCanvas) ctrl;
        int horizontal = canvas.getHorizontalBar().getSelection();
        int vertical = canvas.getVerticalBar().getSelection();
        horizontal += 15;
        vertical -= 15;

        org.eclipse.swt.graphics.Point p = canvas.toDisplay(0, 0);
        if (allowDrop) {
            feedbackFigure.setBounds(new Rectangle((x - p.x) + horizontal, (y - p.y) + vertical,
                    feedbackImageGreen.getBounds().width, feedbackImageGreen.getBounds().height));
        } else {
            feedbackFigure.setBounds(new Rectangle((x - p.x) + horizontal, (y - p.y) + vertical,
                    feedbackImageRed.getBounds().width, feedbackImageRed.getBounds().height));
        }
    }

    /**
     * This will update the 'currentFigureLocation' variable to the given EditPart
     * with the current location of the canvas. This will be used for connectors
     * related calculations
     * 
     * @param childEditPart
     *            EditPart that contains the canvas information.
     */
    private static void updateCurrentStatesForConnectors(EditPart childEditPart) {

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        int offSetX = 0;
        int offSetY = 0;

        // MediatorFlowMediatorFlowCompartmentEditPart logic is written to use relative coordinates for calculations
        // So, the offset values are needed for mimic the locaion in the drag and drop policy
        if (childEditPart instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
            offSetX = ((MediatorFlowMediatorFlowCompartmentEditPart) childEditPart).getBorderedNodeFigure()
                    .getLocation().x;
            offSetY = ((MediatorFlowMediatorFlowCompartmentEditPart) childEditPart).getBorderedNodeFigure()
                    .getLocation().y;
        }

        Control ctrl = (childEditPart.getViewer().getControl());
        FigureCanvas canvas = (FigureCanvas) ctrl;
        int horizontal = canvas.getHorizontalBar().getSelection();
        int vertical = canvas.getVerticalBar().getSelection();

        EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) EditorUtils.getActiveEditor();
        double zoom = esbMultiPageEditor.getZoom();
        org.eclipse.swt.graphics.Point p = canvas.toDisplay(0, 0);

        currentFigureLocation = new Point((x + horizontal - p.x - offSetX) / zoom,
                (y + vertical - p.y - offSetY / zoom));
    }

    /**
     * This will update the 'currentFigureLocation' variable to the given EditPart
     * with the current location of the canvas. This will used for calculating
     * esbLink related calculations
     * 
     * @param childEditPart
     *            EditPart that contains the canvas information.
     */
    private static void updateCurrentStatesForLinks(EditPart childEditPart) {
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;

        Control ctrl = childEditPart.getViewer().getControl();
        FigureCanvas canvas = (FigureCanvas) ctrl;
        int horizontal = canvas.getHorizontalBar().getSelection();
        int vertical = canvas.getVerticalBar().getSelection();

        EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) EditorUtils.getActiveEditor();
        double zoom = esbMultiPageEditor.getZoom();

        org.eclipse.swt.graphics.Point p = canvas.toDisplay(0, 0);
        currentFigureLocation = new Point((((x - p.x) + horizontal) / zoom), (((y - p.y) + vertical) / zoom));
    }

    /**
     * This will update the 'connectorFigureLocation' variable to the EditPart's
     * location.
     * 
     * @param childEditPart
     *            EditPart that contains the location.
     */
    private static void updateCurrentStatesForGivenFigure(ShapeNodeEditPart childEditPart) {
        connectorFigureLocation = new Point(childEditPart.getLocation().x, childEditPart.getLocation().y);
    }

    /**
     * This will return true/false value indicating whether there is a nearest
     * connector for the given childEdit part is available in the given connectors
     * list
     * 
     * @param connectors
     *            ArrayList that contains AbstractConnectorEditParts of the
     *            connectors.
     * @param childEditPart
     *            The current edit part that is under the mouse pointer.
     * @return Boolean value indicating whether there are any near connectors
     *         available for given connectors and the childEdit parts
     * 
     */
    public static boolean isNearestConnectorAvailable(ArrayList<AbstractConnectorEditPart> connectors,
            EditPart childEditPart) {
        AbstractConnectorEditPart nearForwardConnector = null;
        AbstractConnectorEditPart nearReverseConnector = null;
        AbstractConnectorEditPart nearConnector = null;
        int yCurrent = 0, yDistance1 = 0, yDistance2 = 0;
        double EastDistance = 0, EastCurrent = 0, WestCurrent = 0, WestDistance = 0;

        if (childEditPart != null) {

            for (int i = 0; i < connectors.size(); ++i) {

                IFigure figure = (IFigure) ((DefaultSizeNodeFigure) connectors.get(i).getFigure()).getChildren().get(0);

                updateCurrentStatesForConnectors(childEditPart);
                updateCurrentStatesForGivenFigure(connectors.get(i));
                double actualCurrentPosition = currentFigureLocation.x;
                double xLeft = connectorFigureLocation.x;

                // If the current connector is East Pointer
                if ((figure instanceof EastPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart.EastPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutputConnectorEditPart.EastPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutputConnectorEditPart.EastPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesOutputConnectorEditPart.EastPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesInputConnectorEditPart.EastPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AdditionalOutputConnector.EastPointerFigure)) {

                    if ((figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutputConnectorEditPart.EastPointerFigure)
                            || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutputConnectorEditPart.EastPointerFigure)) {
                        // WIDH_OF_PROXYCONNECTOR is the x position of a proxy or API Connector . the
                        // inside container is
                        // starting from (0,0) but API and proxy compartments are at different container
                        xLeft = xLeft - WIDTH_OF_PROXYCONNECTOR;
                    }
                    EastDistance = Math.abs(xLeft - actualCurrentPosition);

                    if (((connectors.get(i) instanceof AbstractOutputConnectorEditPart)
                            && (xLeft < actualCurrentPosition))
                            || ((connectors.get(i) instanceof AbstractInputConnectorEditPart)
                                    && (xLeft > actualCurrentPosition))) {
                        if ((EastCurrent == 0) || (EastCurrent > EastDistance)) {

                            EastCurrent = EastDistance;
                            nearForwardConnector = connectors.get(i);
                        }
                    }

                    // If the current connector is West Pointer
                } else if ((figure instanceof WestPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart.WestPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInputConnectorEditPart.WestPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInputConnectorEditPart.WestPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointOutputConnectorEditPart.WestPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyFaultInputConnectorEditPart.WestPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutSequenceOutputConnectorEditPart.WestPointerFigure)
                        || (figure instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutSequenceOutputConnectorEditPart.WestPointerFigure)) {

                    WestDistance = Math.abs(xLeft - actualCurrentPosition);
                    if (((connectors.get(i) instanceof AbstractOutputConnectorEditPart)
                            && (xLeft > actualCurrentPosition))
                            || ((connectors.get(i) instanceof AbstractInputConnectorEditPart)
                                    && (xLeft < actualCurrentPosition))) {
                        if ((WestCurrent == 0) || (WestCurrent > WestDistance)) {

                            WestCurrent = WestDistance;
                            nearReverseConnector = connectors.get(i);
                        }
                    }
                }
            }
        }

        if (nearForwardConnector != null) {
            updateCurrentStatesForGivenFigure(nearForwardConnector);
            if ((nearForwardConnector.getParent() instanceof ProxyServiceEditPart)
                    || (nearForwardConnector.getParent() instanceof APIResourceEditPart)) {
                // ProxyServiceEditPart and APIResourceEditPart are in different container in
                // the canvas. So need to subtract the off set for the above two EditParts
                int parentY = ((AbstractBaseFigureEditPart) nearForwardConnector.getParent()).getLocation().y;
                yDistance1 = Math.abs(connectorFigureLocation.y - parentY - currentFigureLocation.y);
            } else {
                yDistance1 = Math.abs(connectorFigureLocation.y - currentFigureLocation.y);
            }
        }

        if (nearReverseConnector != null) {
            updateCurrentStatesForGivenFigure(nearReverseConnector);
            if ((nearReverseConnector.getParent() instanceof ProxyServiceEditPart)
                    || (nearReverseConnector.getParent() instanceof APIResourceEditPart)) {
                // ProxyServiceEditPart and APIResourceEditPart are in different container in
                // the canvas. So need
                // to subtract the off set for the above two EditParts
                int parentY = ((AbstractBaseFigureEditPart) nearReverseConnector.getParent()).getLocation().y;
                yDistance2 = Math.abs(connectorFigureLocation.y - parentY - currentFigureLocation.y);
            } else {
                yDistance2 = Math.abs(connectorFigureLocation.y - currentFigureLocation.y);
            }
        }

        if ((yDistance1 != 0) && ((yDistance2 == 0) || (yDistance1 < yDistance2))) {
            yCurrent = yDistance1;
            nearConnector = nearForwardConnector;
        } else {
            yCurrent = yDistance2;
            nearConnector = nearReverseConnector;
        }
        // This will restrict adding new connectors if the Y distance(in pixels) is more
        // than 35
        if (yCurrent > 35) {
            return false;
        }

        /*
         * If 'nearConnector' is null we have to check again whether dropped mediator is
         * the first element of a compartment of a complex mediator. If it is true we
         * have to use following logic to get nearest connection.
         */

        if (nearConnector == null) {
            if (childEditPart.getParent() instanceof AbstractMediatorFlowCompartmentEditPart) {
                int compartmentCenter_y = ((AbstractMediatorFlowCompartmentEditPart) childEditPart.getParent())
                        .getFigure().getBounds().getCenter().y;
                if (EditorUtils.getMediator(childEditPart.getParent()) != null) {
                    ArrayList<AdditionalOutputConnector> additionalConnectors = EditorUtils
                            .getMediatorAdditionalOutputConnectors(EditorUtils.getMediator(childEditPart.getParent()));
                    AdditionalOutputConnector temp = null;
                    int diff_temp = 0;
                    for (AdditionalOutputConnector con : additionalConnectors) {
                        int diff = Math.abs(con.getLocation().y - compartmentCenter_y);
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
        if (nearConnector == null) {
            return false;
        }
        return true;
    }

    /**
     * This will return true/false value indicating whether there is a nearest ESB
     * Link for the given childEdit part is available for the given ESB link list
     * 
     * @param links
     *            ArrayList that contains EsbLinkEditParts of the EsbLinks.
     * @param childEditPart
     *            The current edit part that is under the mouse pointer.
     * @return Boolean value indicating whether there are any near ESB links
     *         available for given links list
     */
    public static boolean isNearestEsbLinkAvailable(ArrayList<EsbLinkEditPart> links, EditPart childEditPart) {

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

                int xLeft = ((EsbLinkEditPart) links.get(i)).getFigure().getBounds().getLeft().x;
                int xRight = (((EsbLinkEditPart) links.get(i)).getFigure().getBounds().getRight().x);
                double actualCurrentPosition = currentFigureLocation.x;
                if ((xLeft < actualCurrentPosition) && (actualCurrentPosition < xRight)) {
                    nearLinks.add((EsbLinkEditPart) links.get(i));
                }
            }
        }

        for (int q = 0; q < nearLinks.size(); ++q) {
            if ((((nearLinks.get(q).getFigure().getBounds().getLeft().y) < ((currentFigureLocation.y) + (70 * zoom)))
                    && ((currentFigureLocation.y) < (nearLinks.get(q).getFigure().getBounds().getBottomLeft().y)))
                    || (((nearLinks.get(q).getFigure().getBounds().getLeft().y) > (currentFigureLocation.y
                            + (70 * zoom)))
                            && ((currentFigureLocation.y) > (nearLinks.get(q).getFigure().getBounds()
                                    .getBottomLeft().y)))) {
            }

            distanceToUpperLine = nearLinks.get(q).getFigure().getBounds().getLeft().y - currentFigureLocation.y;
            distanceToUpperLine = Math.abs(distanceToUpperLine);
            distanceToBottomLine = nearLinks.get(q).getFigure().getBounds().getBottomLeft().y - currentFigureLocation.y;
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
        // If the y distance between the current mouse pointer and nearest ESB Link is
        // more than 35
        // this will return false as the main calculation logic in the
        // ConnectionCalculator class
        if (current > (35 * zoom)) {
            return false;
        }

        // If the distance is 0.0 this will return false since there is no ESB Link from
        // above or below from
        // current mouse pointer
        if (distance == 0.0) {
            return false;
        }

        if (nearestLink == null) {
            return false;
        }
        return true;
    }

    /**
     * This will return true/false value indicating whether there is a nearest ESB
     * Link or nearest connector or not
     * 
     * @return Boolean value indicating whether the current item can be dropped into
     *         the canvas
     */
    public boolean isConnectable() {

        ArrayList<EsbLinkEditPart> esbLinkEditpartList = new ArrayList<EsbLinkEditPart>();
        ArrayList<AbstractConnectorEditPart> outputConnectorEditpartList = new ArrayList<>();

        // Traverse through all the EditParts to identify ESB links and Output
        // connectors
        for (int i = 0; i < getHost().getViewer().getEditPartRegistry().size(); ++i) {
            EditPart element = (EditPart) getHost().getViewer().getEditPartRegistry().values().toArray()[i];

            if (element instanceof EsbLinkEditPart) {
                esbLinkEditpartList.add((EsbLinkEditPart) element);
            }

            if (element instanceof AbstractOutputConnectorEditPart) {
                outputConnectorEditpartList.add((AbstractOutputConnectorEditPart) element);
            }
        }

        Control ctrl = getHost().getViewer().getControl();
        FigureCanvas canvas = (FigureCanvas) ctrl;
        int horizontal = canvas.getHorizontalBar().getSelection();
        int vertical = canvas.getVerticalBar().getSelection();
        canvas.getCursor();
        org.eclipse.swt.graphics.Point p = canvas.toDisplay(0, 0);

        // Check whether there is a near EsbLink available for the current mediator flow
        boolean isNearlinkAvailable = isNearestEsbLinkAvailable(esbLinkEditpartList, getHost());
        // Check whether there is a near connector edit part available for the current
        // mediator flow
        boolean isNearConnectorAvailable = isNearestConnectorAvailable(outputConnectorEditpartList, getHost());

        // return false if no near connector and no near ESB Link
        return (isNearConnectorAvailable || isNearlinkAvailable);
    }

    /**
     * {@inheritDoc}
     */
    public Command getCommand(Request request) {

        // If the new request is to create a new item in the canvas this will check
        // whether is is possible to add the mediator using the similar logic as
        // ConenctionCalcluator class.
        if (request instanceof CreateUnspecifiedTypeRequest) {
            if ((getHost() instanceof MediatorFlowMediatorFlowCompartment5EditPart)
                    || (getHost() instanceof MediatorFlowMediatorFlowCompartmentEditPart)) {
                if (!isConnectable()) {
                    // If the new addition of the mediator is not connectable to a nearest
                    // EsbLink or nearest connector edit part this will stop adding the current
                    // mediator
                    return UnexecutableCommand.INSTANCE;
                }
            }
        }

        if (request instanceof CreateUnspecifiedTypeRequest) {
            List<IElementType> endPointTypes = Arrays.asList(EsbElementTypes.AddressEndPoint_3610,
                    EsbElementTypes.AddressEndPoint_3646, EsbElementTypes.AddressingEndpoint_3689,
                    EsbElementTypes.DefaultEndPoint_3609, EsbElementTypes.DefaultEndPoint_3643,
                    EsbElementTypes.HTTPEndpoint_3709, EsbElementTypes.HTTPEndpoint_3712,
                    EsbElementTypes.WSDLEndPoint_3612, EsbElementTypes.WSDLEndPoint_3653,
                    EsbElementTypes.RecipientListEndPoint_3692, EsbElementTypes.RecipientListEndPoint_3696,
                    EsbElementTypes.TemplateEndpoint_3716, EsbElementTypes.TemplateEndpoint_3725,
                    EsbElementTypes.NamedEndpoint_3660, EsbElementTypes.LoadBalanceEndPoint_3613,
                    EsbElementTypes.LoadBalanceEndPoint_3656, EsbElementTypes.FailoverEndPoint_3611,
                    EsbElementTypes.FailoverEndPoint_3649);

            @SuppressWarnings("rawtypes")
            List<?> elementTypes = ((CreateUnspecifiedTypeRequest) request).getElementTypes();
            @SuppressWarnings("rawtypes")
            Iterator<?> types = elementTypes.iterator();
            while (types.hasNext()) {
                Object object = types.next();
                if (!(getHost() instanceof EndpoinMediatorFlowCompartmentEditPart)) {

                    /*
                     * Doesn't allow adding Endpoints in mediators other than Send and Call
                     */
                    if (!(getHost() instanceof MediatorFlowMediatorFlowCompartment11EditPart)) {
                        /*
                         * Allow adding Endpoints in Clone Mediator and not in other mediators
                         */
                        if (endPointTypes.contains(object)) {
                            return UnexecutableCommand.INSTANCE;
                        }
                    }
                    if (getHost() instanceof MediatorFlowMediatorFlowCompartment11EditPart) {

                        int count = getHost().getChildren().size();
                        if (count > 0) {
                            Object existingMediator = getHost().getChildren().get(count - 1);
                            if (existingMediator instanceof AbstractEndpoint) {
                                /*
                                 * If the last mediator is an Endpoint, then not allow to add other mediators
                                 */
                                if (!endPointTypes.contains(object)) {
                                    return UnexecutableCommand.INSTANCE;
                                }
                            } else if (existingMediator instanceof AbstractMediator) {
                                /*
                                 * If the last mediator is not an Endpoint and if it is another mediator, then
                                 * not allow to add endpoints without a Send
                                 */
                                if (endPointTypes.contains(object)) {

                                    return UnexecutableCommand.INSTANCE;
                                }
                            }
                        }
                    }
                } else {
                    /*
                     * Not allowing mediators in Send and Call mediator compartments.
                     */
                    if (!endPointTypes.contains(object)) {
                        return UnexecutableCommand.INSTANCE;
                    }
                }
            }
        }
        return super.getCommand(request);
    }
}
