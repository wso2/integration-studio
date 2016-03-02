/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractComplexEndpointCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractProxyServiceContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.DroppableElement;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.complexFiguredAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneTargetContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DropMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementAdviceContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementObligationsContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementOnAcceptContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementOnRejectContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbServerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterFailContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterPassContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointOnErrorSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlow6EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment10EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment11EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment18EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment21EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment22EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment23EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment24EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment25EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment26EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment29EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment4EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment5EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment6EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment7EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment8EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment9EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInSequenceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceContainer2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceFaultContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceSequenceAndEndpointContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchDefaultContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchDefaultParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleOnAcceptContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleOnRejectContainerEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;

public class XYRepossition {

	private static final int ARRWO_LENGTH = 40;
	private static final int CONNECTOR_LENGTH = 5;
	private static final int COMPLEX_MEDIATOR_COMPARTMENT_GAP = 5;

	private static final int DEFAULT_PROXY_CONTAINER_WIDTH = 204;
	private static final int DEFAULT_PROXY_AND_EP_CONTAINER_HEIGHT = 312;
	private static final int DEFAULT_FAULT_CONTAINER_HEIGHT = 84;
	private static int COMPLEX_MEDIATOR_LEFT_RECTANGLE_WIDTH = 100;
	
	private static EditPart mediatorFlowMediatorFlowCompartmentEditPart = null;

	public static void resizeContainers(IGraphicalEditPart editPart) {
		IGraphicalEditPart parent = editPart;

		while (!(parent instanceof EsbServerEditPart)) {
			if (parent != null) {
				resizeEditpart(parent);
				parent = (IGraphicalEditPart) parent.getParent();
			} else {
				break;
			}
		}
	}

	private static void resizeEditpart(IGraphicalEditPart parent) {
		if (parent instanceof AbstractMediatorFlowCompartmentEditPart) {
			if (parent instanceof MediatorFlowMediatorFlowCompartment5EditPart) {
				// Resize Sequences edit part.
				resizeSequences(parent);
			} else if (parent instanceof MediatorFlowMediatorFlowCompartmentEditPart
					|| parent instanceof MediatorFlowMediatorFlowCompartment6EditPart) {
				// Resize proxy service edit part.
				resizeProxyServiceEditPart(parent);
			} else {
				// Resize Complex mediator.
				resizeComplexMediator(parent);
			}
		} else if (parent instanceof MediatorFlowMediatorFlowCompartment18EditPart) {
			resizeComplexEndpointEditPart(parent);
		} else if (parent instanceof AbstractComplexEndpointCompartmentEditPart) {
            resizeComplexEndpointEditPart(parent);
		} else if (parent instanceof FixedSizedAbstractMediator) {
			resizeSimpleMediator(parent);
 		}
	}
	
	/**
	 * Resize mediator on description edit as the entire description is visible.
	 * 
	 * @param editpart
	 */
	private static void resizeSimpleMediator(IGraphicalEditPart editpart) {
		List children = editpart.getChildren();

		for (Object child : children) {
			if (child instanceof CompartmentEditPart) {
				WrappingLabel descriptionLabel = (WrappingLabel) ((CompartmentEditPart) child)
						.getFigure();
				Dimension dimension = descriptionLabel.getPreferredSize(-1, -1);
				Rectangle bounds = editpart.getFigure().getBounds();

				if (dimension.width >= FixedSizedAbstractMediator.FigureWidth) {
					// Resize mediator
					bounds.setWidth(dimension.width + 4);

				} else {
					bounds.setWidth(FixedSizedAbstractMediator.FigureWidth + 4);
				}

				editpart.getFigure().setBounds(bounds);
			}
		}
	}
	
	/**
	 * Resize complex endpoint editpart. 
	 * @param parent
	 */
	private static void resizeComplexEndpointEditPart(IGraphicalEditPart parent) {
		List<IGraphicalEditPart> endpointEditparts = ((ShapeCompartmentEditPart) parent).getChildren();
		Rectangle bounds = new Rectangle(0, 0, 500, 300);
		int endpointGap = 50;
		int newCompartmentHeight = 0;

		for (IGraphicalEditPart endpointEditpart : endpointEditparts) {
			newCompartmentHeight += endpointEditpart.getFigure().getBounds().height + endpointGap;
		}

		if (newCompartmentHeight > bounds.height) {
			bounds.setHeight(newCompartmentHeight);

			// Resize MediatorFlow18EditPart
			((GraphicalEditPart) parent.getParent().getParent()).getFigure().setBounds(
					bounds);
			((GraphicalEditPart) parent.getParent().getParent()).setLayoutConstraint(
					parent.getParent(), ((GraphicalEditPart) parent.getParent()).getFigure(), bounds);

			// Resize ComplexEndpointsEditPart
			((GraphicalEditPart) parent.getParent().getParent().getParent())
					.setLayoutConstraint(parent.getParent().getParent(),
							((GraphicalEditPart) parent.getParent().getParent())
									.getFigure(), bounds);
		}
	}

	/**
	 * Resize proxy, api and main sequence editor.
	 * 
	 * @param parent
	 */
	private static void resizeProxyServiceEditPart(IGraphicalEditPart parent) {
		int constantY = 50;
		int x = 2 * CONNECTOR_LENGTH + ARRWO_LENGTH;

		int inSequenceHeight = 0;
		int outSequenceHeight = 0;

		int inOutSeqWidth = 0;
		int inOutSeqHeight = 0;

		int faultSequenceWidth = 0;
		int faultSequenceHeight = 0;

		int inSequenceWidth = 0;
		int outSequenceWidth = 0;

		int newWidth = 0;
		int newHeight = 0;

		int sendToEPDistance = 2 * x;

		boolean mainSequence = false;

		AbstractBaseFigureEditPart proxyServiceEditPart = null;
		AbstractProxyServiceContainerEditPart proxyServiceContainerEditPart = null;

		if (parent.getParent().getParent().getParent() instanceof ProxyServiceContainerEditPart) {
			proxyServiceContainerEditPart = (ProxyServiceContainerEditPart) parent.getParent()
					.getParent().getParent();
		} else {
			proxyServiceContainerEditPart = (ProxyServiceContainer2EditPart) parent.getParent()
					.getParent().getParent();
		}

		if (parent.getParent().getParent().getParent().getParent() instanceof APIResourceEditPart) {
			proxyServiceEditPart = (APIResourceEditPart) parent.getParent().getParent().getParent()
					.getParent();
		} else {
			proxyServiceEditPart = (ProxyServiceEditPart) parent.getParent().getParent()
					.getParent().getParent();
		}

		ProxyServiceSequenceAndEndpointContainerEditPart seqAndEPContainerEditPart = (ProxyServiceSequenceAndEndpointContainerEditPart) proxyServiceContainerEditPart
				.getChildren().get(0);
		MediatorFlowEditPart mediatorFlowEditPart = (MediatorFlowEditPart) seqAndEPContainerEditPart
				.getChildren().get(0);
		MediatorFlowMediatorFlowCompartmentEditPart inAndOutSeqEditPart = (MediatorFlowMediatorFlowCompartmentEditPart) mediatorFlowEditPart
				.getChildren().get(0);

		ProxyServiceFaultContainerEditPart proxyServiceFaultContainerEditPart = (ProxyServiceFaultContainerEditPart) proxyServiceContainerEditPart
				.getChildren().get(1);
		MediatorFlow6EditPart mediatorFlow6EditPart = (MediatorFlow6EditPart) proxyServiceFaultContainerEditPart
				.getChildren().get(0);
		MediatorFlowMediatorFlowCompartment6EditPart faulSeqEditPart = (MediatorFlowMediatorFlowCompartment6EditPart) mediatorFlow6EditPart
				.getChildren().get(0);

		IFigure faultContainerFigure = proxyServiceFaultContainerEditPart.getFigure();
		if (!faultContainerFigure.isVisible()) {
			mainSequence = true;
		}

		int inOutSeqChildren = inAndOutSeqEditPart.getChildren().size();
		int faultSeqChildren = faulSeqEditPart.getChildren().size();

		// Calculate width and height of the in&out sequences.
		for (int i = 0; i < inOutSeqChildren; ++i) {
			if (inAndOutSeqEditPart.getChildren().get(i) instanceof AbstractMediator) {
				Rectangle childBounds = ((GraphicalEditPart) inAndOutSeqEditPart.getChildren().get(
						i)).getFigure().getBounds();
				AbstractMediator childMediator = (AbstractMediator) inAndOutSeqEditPart
						.getChildren().get(i);
				if (!childMediator.reversed) {
					// In sequence.
					if (childBounds.height > inSequenceHeight) {
						inSequenceHeight = childBounds.height;
					}
					inSequenceWidth += ARRWO_LENGTH + childBounds.width + 2 * CONNECTOR_LENGTH;
				} else {
					// Out sequence.
					if (childBounds.height > outSequenceHeight) {
						outSequenceHeight = childBounds.height;
					}
					outSequenceWidth += ARRWO_LENGTH + childBounds.width + 2 * CONNECTOR_LENGTH;
				}
			}
		}

		if (!mainSequence) {
			// Calculate width and height of the fault sequence.
			for (int i = 0; i < faultSeqChildren; i++) {
				Rectangle childBounds = ((GraphicalEditPart) faulSeqEditPart.getChildren().get(i))
						.getFigure().getBounds();
				if (childBounds.height > faultSequenceHeight) {
					faultSequenceHeight = childBounds.height;
				}
				faultSequenceWidth += ARRWO_LENGTH + childBounds.width + 2 * CONNECTOR_LENGTH;
			}

			faultSequenceHeight = faultSequenceHeight + constantY;
		}

		if (inSequenceWidth > outSequenceWidth) {
			x += inSequenceWidth + sendToEPDistance;
		} else {
			x += outSequenceWidth + sendToEPDistance;
		}

		inOutSeqWidth = x;

		/*
		 * if (outSequenceHeight == 0 && inSequenceHeight > 0) {
		 * //outSequenceHeight = inSequenceHeight; outSequenceHeight =
		 * defaultProxyAndEPContainerHeight/2; } if(inSequenceHeight == 0 &&
		 * outSequenceHeight > 0) { //inSequenceHeight = outSequenceHeight;
		 * inSequenceHeight = defaultProxyAndEPContainerHeight/2; }
		 */

		/*
		 * Both in-sequence and out-sequence should be symmetric, otherwise
		 * arrows will be bend.
		 */
		if (inSequenceHeight > outSequenceHeight) {
			outSequenceHeight = inSequenceHeight;
		} else {
			inSequenceHeight = outSequenceHeight;
		}

		inOutSeqHeight = inSequenceHeight + outSequenceHeight + constantY * 2;

		if (faultSequenceWidth > inOutSeqWidth) {
			// Check whether fault sequence is longer than in & out sequences.
			newWidth = faultSequenceWidth + sendToEPDistance;
		} else {
			newWidth = inOutSeqWidth;
		}

		newHeight = inOutSeqHeight + faultSequenceHeight;

		if (inOutSeqChildren == 0 && faultSeqChildren == 0) {
			// In & Out sequences and Fault Sequence are empty.
			newWidth = DEFAULT_PROXY_CONTAINER_WIDTH;
			inOutSeqHeight = DEFAULT_PROXY_AND_EP_CONTAINER_HEIGHT;
			faultSequenceHeight = DEFAULT_FAULT_CONTAINER_HEIGHT;
			newHeight = inOutSeqHeight + faultSequenceHeight;

		} else if (inOutSeqChildren == 0 && faultSeqChildren > 0 && !mainSequence) {
			// In & Out sequences are empty Fault sequence is not empty.
			inOutSeqHeight = DEFAULT_PROXY_AND_EP_CONTAINER_HEIGHT;
			newHeight = inOutSeqHeight + faultSequenceHeight;

		} else if (inOutSeqChildren > 0 && faultSeqChildren == 0 && !mainSequence) {
			// In & Out sequences are not empty Fault sequence is empty.
			faultSequenceHeight = DEFAULT_FAULT_CONTAINER_HEIGHT;
			newHeight = inOutSeqHeight + faultSequenceHeight;
		}

		int positionY = 0;
		if (proxyServiceEditPart instanceof APIResourceEditPart) {
			positionY = ((APIResourceEditPart) proxyServiceEditPart).getY();
		} else if (proxyServiceEditPart instanceof ProxyServiceEditPart) {
			positionY = 100;
		}

		Rectangle mediatorFlowConstraints = new Rectangle(0, positionY, newWidth, inOutSeqHeight);
		Rectangle faultContainerConstraints = new Rectangle(0, positionY, newWidth,
				faultSequenceHeight);
		Rectangle proxyServiceContainerConstraints = new Rectangle(0, positionY, newWidth,
				newHeight);
		Rectangle proxyConstraints = new Rectangle(0, positionY,
				proxyServiceContainerConstraints.width() + COMPLEX_MEDIATOR_LEFT_RECTANGLE_WIDTH,
				proxyServiceContainerConstraints.height() + 4);

		// Resize MediatorFlowEditPart.
		((GraphicalEditPart) seqAndEPContainerEditPart).setLayoutConstraint(mediatorFlowEditPart,
				((GraphicalEditPart) mediatorFlowEditPart).getFigure(), mediatorFlowConstraints);
		((GraphicalEditPart) seqAndEPContainerEditPart).getFigure().setBounds(
				mediatorFlowConstraints);

		// Resize ProxyServiceSequenceAndEndpointContainerEditPart.
		((GraphicalEditPart) proxyServiceContainerEditPart).setLayoutConstraint(
				seqAndEPContainerEditPart,
				((GraphicalEditPart) seqAndEPContainerEditPart).getFigure(),
				mediatorFlowConstraints);
		seqAndEPContainerEditPart.getFigure().setMinimumSize(
				new Dimension(mediatorFlowConstraints.width, mediatorFlowConstraints.height));
		((GraphicalEditPart) proxyServiceContainerEditPart).getFigure().setBounds(
				mediatorFlowConstraints);

		if (!mainSequence) {
			// Resize MediatorFlow6EditPart (fault sequence).
			((GraphicalEditPart) proxyServiceFaultContainerEditPart).setLayoutConstraint(
					mediatorFlow6EditPart, ((GraphicalEditPart) mediatorFlow6EditPart).getFigure(),
					faultContainerConstraints);
			((GraphicalEditPart) proxyServiceFaultContainerEditPart).getFigure().setBounds(
					faultContainerConstraints);

			// Resize ProxyServiceFaultContainerEditPart (fault sequence).
			((GraphicalEditPart) proxyServiceContainerEditPart).setLayoutConstraint(
					proxyServiceFaultContainerEditPart,
					((GraphicalEditPart) proxyServiceFaultContainerEditPart).getFigure(),
					faultContainerConstraints);
			proxyServiceFaultContainerEditPart.getFigure()
			.setMinimumSize(
					new Dimension(faultContainerConstraints.width,
							faultContainerConstraints.height));
			((GraphicalEditPart) proxyServiceContainerEditPart).getFigure().setBounds(
					faultContainerConstraints);
		}

		// Resize ProxyServiceContainerEditPart.
		((GraphicalEditPart) proxyServiceEditPart).setLayoutConstraint(
				proxyServiceContainerEditPart,
				((GraphicalEditPart) proxyServiceContainerEditPart).getFigure(),
				proxyServiceContainerConstraints);

		// Resize ProxyServiceEditPart.
		((GraphicalEditPart) parent.getParent().getParent().getParent().getParent().getParent())
		.setLayoutConstraint(proxyServiceEditPart,
				((GraphicalEditPart) proxyServiceEditPart).getFigure(), proxyConstraints);

	}

	/**
	 * Resize complex mediator.
	 * 
	 * @param parent
	 */
	private static void resizeComplexMediator(IGraphicalEditPart parent) {
		int constantY = 60;
		int x = 2 * CONNECTOR_LENGTH + ARRWO_LENGTH;
		int y = 0;
		int noOfChildren = parent.getChildren().size();
		int maxCompartmentWidth = 0;

		for (int i = 0; i < noOfChildren; ++i) {
			Rectangle bound = ((GraphicalEditPart) parent.getChildren().get(i)).getFigure()
					.getBounds();
			x = ARRWO_LENGTH + bound.width + 2 * CONNECTOR_LENGTH + x;
			if (bound.height > y) {
				y = bound.height;
			}
		}

		y = y + constantY;

		if (parent instanceof MediatorFlowMediatorFlowCompartment7EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment8EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment9EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment10EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment11EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment21EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment22EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment23EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment24EditPart) {

			maxCompartmentWidth = getMaxCompartmentWidth((GraphicalEditPart) parent.getParent()
					.getParent().getParent());

		} else if (parent instanceof MediatorFlowMediatorFlowCompartment2EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment4EditPart) {
			maxCompartmentWidth = getMaxCompartmentWidth((GraphicalEditPart) parent.getParent()
					.getParent().getParent().getParent());
		}

		if (maxCompartmentWidth > x) {
			x = maxCompartmentWidth;
		}

		Rectangle constraints = new Rectangle(0, 100, x, y);

		// Resize the Complex Mediator.
		((GraphicalEditPart) parent.getParent().getParent()).setLayoutConstraint(
				parent.getParent(), ((GraphicalEditPart) parent.getParent()).getFigure(),
				constraints);

		/*
		 * Set bounds since layout constraints are suppose to be applied in next
		 * UI update, this bounds will be used in rearranging elements.
		 */
		((GraphicalEditPart) parent.getParent().getParent()).getFigure().setBounds(constraints);

		int boundsWidth = x + COMPLEX_MEDIATOR_LEFT_RECTANGLE_WIDTH;
		int boundsHeight = y + 2 * COMPLEX_MEDIATOR_COMPARTMENT_GAP;
		AbstractMediator mediator = EditorUtils.getMediator(parent);

		if (mediator instanceof complexFiguredAbstractMediator) {
			if (mediator instanceof FilterMediatorEditPart
					|| mediator instanceof ThrottleMediatorEditPart
					|| mediator instanceof CloneMediatorEditPart
					|| mediator instanceof EntitlementMediatorEditPart) {

				boundsHeight = getMultipleCompartmentComplexMediatorHeight((GraphicalEditPart) parent
						.getParent().getParent().getParent())
						+ (2 * COMPLEX_MEDIATOR_COMPARTMENT_GAP);
				((GraphicalEditPart) parent.getParent().getParent()).getFigure().setMinimumSize(
						new Dimension(x, y));
				resizeCompartments((GraphicalEditPart) parent.getParent().getParent().getParent(),
						x);
			} else if (mediator instanceof SwitchMediatorEditPart) {
				boundsHeight = getMultipleCompartmentComplexMediatorHeight((GraphicalEditPart) parent
						.getParent().getParent().getParent().getParent())
						+ (2 * COMPLEX_MEDIATOR_COMPARTMENT_GAP);
				((GraphicalEditPart) parent.getParent().getParent()).getFigure().setMinimumSize(
						new Dimension(x, y));
				resizeCompartments((GraphicalEditPart) parent.getParent().getParent().getParent()
						.getParent(), x);
			} else {
				if (noOfChildren == 0) {
					/*
					 * Complex mediator doesn't contain any children, bring it
					 * to its initial size.
					 */
					boundsWidth = 170;
					boundsHeight = 100;
				}
			}

			// Set mediator bounds.
			((IGraphicalEditPart) mediator).getFigure().getBounds().setWidth(boundsWidth);
			((IGraphicalEditPart) mediator).getFigure().getBounds().setHeight(boundsHeight);
		}
	}

	/**
	 * Resize the sequences editor.
	 * 
	 * @param parent
	 */
	private static void resizeSequences(IGraphicalEditPart parent) {
		int constantY = 60;
		int x = 2 * CONNECTOR_LENGTH + ARRWO_LENGTH;
		int y = 0;
		int noOfChildren = parent.getChildren().size();

		for (int i = 0; i < noOfChildren; ++i) {
			Rectangle bound = ((GraphicalEditPart) parent.getChildren().get(i)).getFigure()
					.getBounds();
			x = ARRWO_LENGTH + bound.width + 2 * CONNECTOR_LENGTH + x;
			if (bound.height > y) {
				y = bound.height;
			}
		}

		y = y + constantY;

		Rectangle constraints = new Rectangle(0, 100, x, y);

		if (noOfChildren == 0) {
			/*
			 * Sequence doesn't contain any children, bring it to its initial
			 * size
			 */
			constraints.setHeight(125);
			constraints.setWidth(195);
		}

		/*
		 * Set bounds since layout constraints are suppose to be applied in next
		 * UI update, this bounds will be used in rearranging elements.
		 */
		((GraphicalEditPart) parent.getParent().getParent()).getFigure().setBounds(constraints);

		// Resize MediatorFlow5EditPart
		((GraphicalEditPart) parent.getParent().getParent()).setLayoutConstraint(
				parent.getParent(), ((GraphicalEditPart) parent.getParent()).getFigure(),
				constraints);

		// Resize SequencesEditPart
		((GraphicalEditPart) parent.getParent().getParent().getParent()).setLayoutConstraint(parent
				.getParent().getParent(), ((GraphicalEditPart) parent.getParent().getParent())
				.getFigure(), constraints);
	}

	public static void reArrange(IGraphicalEditPart editPart) {

		IGraphicalEditPart parent = editPart;
		while (!(parent instanceof EsbServerEditPart)) {
			if (parent != null) {
				rearrangeChildren(parent);
				if (parent instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
					mediatorFlowMediatorFlowCompartmentEditPart = parent;
					Display.getCurrent().asyncExec(new Runnable() {			
						@Override
						public void run() {	
							XYRepossition.arrangeInSequenceInputConnectors(mediatorFlowMediatorFlowCompartmentEditPart);
						}});
				}
				parent = (IGraphicalEditPart) parent.getParent();
			} else {
				break;
			}
		}
	}

	/**
	 * Rearrange child mediators.
	 * 
	 * @param editPart
	 */
	private static void rearrangeChildren(IGraphicalEditPart editPart) {

		if (editPart instanceof AbstractMediatorFlowCompartmentEditPart) {
			int verticalSpacing = 0;
			int arrowAndtwoConnectorsLength = ARRWO_LENGTH + (2 * CONNECTOR_LENGTH);
			int x = arrowAndtwoConnectorsLength - CONNECTOR_LENGTH;
			int i = 0;

			boolean reversed = false;

			ShapeNodeEditPart node = getLeftMostNodeFromEditPart(editPart);

			/*
			 * In sequence is empty of the proxy, api or main sequence editor,
			 * but out sequence is not empty.
			 */
			if (editPart instanceof MediatorFlowMediatorFlowCompartmentEditPart && node == null
					&& editPart.getChildren().size() > 0) {
				// Started to traverse out sequence.
/*				node = getRightMostNodeOfOutSequence(editPart);
				x = ((IGraphicalEditPart) editPart.getParent().getParent()).getFigure().getBounds().width
						- arrowAndtwoConnectorsLength * 2;*/
				node = getLeftMostNodeOfOutSequence(editPart);
				x = arrowAndtwoConnectorsLength - CONNECTOR_LENGTH;
				reversed = true;
			}

			while (node instanceof AbstractMediator || node instanceof AbstractEndpoint) {
				int y = 0;

				if (editPart instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
					y = ((IGraphicalEditPart) editPart.getParent().getParent()).getFigure()
							.getBounds().height / (2 * 2);
				} else {
					y = ((IGraphicalEditPart) editPart.getParent().getParent()).getFigure()
							.getBounds().height / 2;
				}

				if (editPart instanceof MediatorFlowMediatorFlowCompartment5EditPart) {
					// Title bar width of the sequences editor.
					verticalSpacing = 20;
				} else if ((editPart instanceof MediatorFlowMediatorFlowCompartment25EditPart) || (editPart instanceof MediatorFlowMediatorFlowCompartment26EditPart)) {
					verticalSpacing = 0;
				} else {
					verticalSpacing = 10;
				}

				y = y - node.getFigure().getBounds().height / 2 - verticalSpacing;

				IFigure nodeFigure = ((GraphicalEditPart) node).getFigure();
				int nodeFigureWdith = nodeFigure.getBounds().width;
				int nodeFigureHeight = nodeFigure.getBounds().height;

				if (node instanceof DroppableElement) {
					DroppableElement droppableElement = (DroppableElement) node;
					Rectangle constraints = null;

					if (node instanceof AbstractMediator
							&& !((AbstractMediator) droppableElement).reversed
							|| node instanceof AbstractEndpoint) {
						// In sequence mediators
						droppableElement.setX(x);
						droppableElement.setY(y);
						constraints = new Rectangle(x, y, nodeFigureWdith, nodeFigureHeight);
						x = x + arrowAndtwoConnectorsLength + nodeFigureWdith;

					} else {
						if (editPart instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
							// In&out sequence mediator.
							y = ((IGraphicalEditPart) editPart.getParent().getParent()).getFigure()
									.getBounds().height * 3 / 4;
							y = y - node.getFigure().getBounds().height / 2 - verticalSpacing;						

							droppableElement.setX(x);
							droppableElement.setY(y);
							constraints = new Rectangle(x, y, nodeFigureWdith, nodeFigureHeight);
							x = x + arrowAndtwoConnectorsLength + nodeFigureWdith;
						} else if (editPart instanceof MediatorFlowMediatorFlowCompartment6EditPart) {
							// Mediators in fault sequence.
							droppableElement.setX(x);
							droppableElement.setY(y);
							constraints = new Rectangle(x, y, nodeFigureWdith, nodeFigureHeight);
							x = x + arrowAndtwoConnectorsLength + nodeFigureWdith;

						} else {
							/*
							 * Mediators inside complex mediator in the out
							 * sequence
							 */
							if (i == 0) {
								if (editPart instanceof MediatorFlowMediatorFlowCompartment7EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment8EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment9EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment10EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment11EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment21EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment22EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment23EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment24EditPart) {
									x = ((IGraphicalEditPart) editPart.getParent().getParent()
											.getParent().getParent()).getFigure().getBounds().width
											- COMPLEX_MEDIATOR_LEFT_RECTANGLE_WIDTH
											- arrowAndtwoConnectorsLength - nodeFigureWdith;

								} else if (editPart instanceof MediatorFlowMediatorFlowCompartment2EditPart
										|| editPart instanceof MediatorFlowMediatorFlowCompartment4EditPart) {
									x = ((IGraphicalEditPart) editPart.getParent().getParent()
											.getParent().getParent().getParent()).getFigure()
											.getBounds().width
											- COMPLEX_MEDIATOR_LEFT_RECTANGLE_WIDTH
											- arrowAndtwoConnectorsLength - nodeFigureWdith;
								} else {
									x = ((IGraphicalEditPart) editPart.getParent().getParent())
											.getFigure().getBounds().width
											- COMPLEX_MEDIATOR_LEFT_RECTANGLE_WIDTH
											- arrowAndtwoConnectorsLength - nodeFigureWdith;
								}

							} else {
								x = x - arrowAndtwoConnectorsLength - nodeFigureWdith;
							}

							droppableElement.setX(x);
							droppableElement.setY(y);
							constraints = new Rectangle(x, y, nodeFigureWdith, nodeFigureHeight);
							i++;
						}
					}

					GraphicalEditPart nodeParent = (GraphicalEditPart) ((GraphicalEditPart) node)
							.getParent();
					node.getFigure().setBounds(constraints);
					nodeParent.setLayoutConstraint(node, nodeFigure, constraints);
				}

				AbstractOutputConnectorEditPart nodeOPconector = null;
				AbstractMediatorInputConnectorEditPart nodeInputConnector = null;
				List sourceConnections = null;
				List targetConnections = null;

				if (editPart instanceof MediatorFlowMediatorFlowCompartment6EditPart) {
					// fault sequence.
					nodeInputConnector = EditorUtils.getMediatorInputConnector(node);
					targetConnections = nodeInputConnector.getTargetConnections();

					if (targetConnections != null) {
						if (targetConnections.size() != 0) {
							node = (ShapeNodeEditPart) ((EsbLinkEditPart) nodeInputConnector
									.getTargetConnections().get(0)).getSource().getParent();
						} else {
							break;
						}
					}

				} else if ((editPart instanceof MediatorFlowMediatorFlowCompartmentEditPart)
						&& reversed) {
					
					nodeInputConnector = EditorUtils.getMediatorInputConnector(node);
					targetConnections = nodeInputConnector.getTargetConnections();

					if (targetConnections != null) {
						if (targetConnections.size() != 0) {
							node = (ShapeNodeEditPart) ((EsbLinkEditPart) nodeInputConnector
									.getTargetConnections().get(0)).getSource().getParent();
						} else {
							break;
						}
					}			
					
				}else {
					nodeOPconector = EditorUtils.getMediatorOutputConnector(node);

					if (nodeOPconector != null) {
						sourceConnections = nodeOPconector.getSourceConnections();

						if (sourceConnections != null) {
							if (sourceConnections.size() != 0
									&& !((((EsbLinkEditPart) sourceConnections.get(0)).getTarget() instanceof ProxyInSequenceInputConnectorEditPart) || (((EsbLinkEditPart) sourceConnections
											.get(0)).getTarget() instanceof APIResourceInSequenceInputConnectorEditPart))) {
								EsbLinkEditPart linkPart = (EsbLinkEditPart) sourceConnections
										.get(0);
								node = (ShapeNodeEditPart) linkPart.getTarget().getParent();
							} else {
								if (editPart instanceof MediatorFlowMediatorFlowCompartmentEditPart
										&& !reversed) {
									// Started to traverse out sequence.
/*									node = getRightMostNodeOfOutSequence(editPart);
									x = ((IGraphicalEditPart) editPart.getParent().getParent())
											.getFigure().getBounds().width
											- arrowAndtwoConnectorsLength * 2;*/
									node = getLeftMostNodeOfOutSequence(editPart);
									x = arrowAndtwoConnectorsLength - CONNECTOR_LENGTH;
									reversed = true;
								} else {
									break;
								}
							}
						}
					} else if (nodeOPconector == null && node instanceof DropMediatorEditPart) {
						// Last mediator of in sequence is Drop mediator,
						if (editPart instanceof MediatorFlowMediatorFlowCompartmentEditPart
								&& !reversed) {
							// Started to traverse out sequence.
/*							node = getRightMostNodeOfOutSequence(editPart);
							x = ((IGraphicalEditPart) editPart.getParent().getParent())
									.getFigure().getBounds().width
									- arrowAndtwoConnectorsLength * 2;*/
							node = getLeftMostNodeOfOutSequence(editPart);
							x = arrowAndtwoConnectorsLength - CONNECTOR_LENGTH;
							reversed = true;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
		} 
	}

	private static ShapeNodeEditPart getLeftMostNodeFromEditPart(IGraphicalEditPart parent) {
		ShapeNodeEditPart first = null;
		if (parent instanceof MediatorFlowMediatorFlowCompartmentEditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment6EditPart 
				|| parent instanceof MediatorFlowMediatorFlowCompartment25EditPart
				|| parent instanceof MediatorFlowMediatorFlowCompartment26EditPart) {
			first = (ShapeNodeEditPart) parent.getParent().getParent().getParent().getParent();
		} else {
			first = (ShapeNodeEditPart) parent.getParent().getParent();
		}

		ShapeNodeEditPart node = null;
		AbstractOutputConnectorEditPart firstOutputConnector = null;
		AbstractInputConnectorEditPart faultInputConnector = null;

		if (first instanceof FilterPassContainerEditPart
				|| first instanceof FilterFailContainerEditPart
				|| first instanceof ThrottleOnAcceptContainerEditPart
				|| first instanceof ThrottleOnRejectContainerEditPart
				|| first instanceof SwitchCaseContainerEditPart
				|| first instanceof SwitchDefaultContainerEditPart
				|| first instanceof CloneTargetContainerEditPart				
				|| first instanceof EntitlementOnRejectContainerEditPart
				|| first instanceof EntitlementOnAcceptContainerEditPart
				|| first instanceof EntitlementAdviceContainerEditPart
				|| first instanceof EntitlementObligationsContainerEditPart) {

			int editPartIndex = getEditPartIndexFromParent(first);
			ShapeNodeEditPart mediatorEditPart = null;
			if (first instanceof SwitchCaseContainerEditPart) {
				mediatorEditPart = (ShapeNodeEditPart) first.getParent().getParent().getParent();
				if (editPartIndex > 0) {
					editPartIndex += 1;
				}
				firstOutputConnector = EditorUtils.getMediatorAdditionalOutputConnectors(
						mediatorEditPart).get(editPartIndex);
			} else if (first instanceof SwitchDefaultContainerEditPart) {
				mediatorEditPart = (ShapeNodeEditPart) first.getParent().getParent().getParent();
				firstOutputConnector = EditorUtils.getMediatorAdditionalOutputConnectors(
						mediatorEditPart).get(1);
			} else {
				mediatorEditPart = (ShapeNodeEditPart) first.getParent().getParent();
				firstOutputConnector = EditorUtils.getMediatorAdditionalOutputConnectors(
						mediatorEditPart).get(editPartIndex);
			}

		} else {
			if (parent instanceof MediatorFlowMediatorFlowCompartment6EditPart) {
				faultInputConnector = EditorUtils.getProxyFaultInputConnector(first);
			} else if(parent instanceof MediatorFlowMediatorFlowCompartment25EditPart){
				//Get the InboundEndpointSequenceOutputConnectorEditPart from InboundEndpointEditPart
				firstOutputConnector = EditorUtils.getOutputConnector(first,InboundEndpointSequenceOutputConnectorEditPart.class);
			} else if(parent instanceof MediatorFlowMediatorFlowCompartment26EditPart){
				//Get the InboundEndpointOnErrorSequenceOutputConnectorEditPart from InboundEndpointEditPart
				firstOutputConnector = EditorUtils.getOutputConnector(first,InboundEndpointOnErrorSequenceOutputConnectorEditPart.class);
			} else {
				if (EditorUtils.getMediatorAdditionalOutputConnectors(first).size() == 0) {
					firstOutputConnector = EditorUtils.getOutputConnector(first);
				} else {
					firstOutputConnector = EditorUtils.getMediatorAdditionalOutputConnectors(first)
							.get(0);
				}
			}
		}

		if (parent instanceof MediatorFlowMediatorFlowCompartment6EditPart) {
			if (faultInputConnector != null) {
				if (faultInputConnector.getTargetConnections() != null) {
					if (faultInputConnector.getTargetConnections().size() != 0) {
						node = (ShapeNodeEditPart) ((EsbLinkEditPart) faultInputConnector
								.getTargetConnections().get(0)).getSource().getParent();
					}
				}
			}
		} else {
			if (firstOutputConnector != null) {
				if (firstOutputConnector.getSourceConnections() != null) {
					if (firstOutputConnector.getSourceConnections().size() != 0) {
						node = (ShapeNodeEditPart) ((EsbLinkEditPart) firstOutputConnector
								.getSourceConnections().get(0)).getTarget().getParent();
					}
				}
			}
		}

		return node;
	}

	/**
	 * Get right most node of the out sequence of a proxy, api or main sequence.
	 * 
	 * @param parent
	 * @return
	 */
	private static ShapeNodeEditPart getRightMostNodeOfOutSequence(IGraphicalEditPart parent) {
		ShapeNodeEditPart first = null;
		ShapeNodeEditPart node = null;

		AbstractOutputConnectorEditPart outSequenceOutputConnector = null;

		if (parent instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
			first = (ShapeNodeEditPart) parent.getParent().getParent().getParent().getParent();

			outSequenceOutputConnector = EditorUtils.getProxyOutSequenceOutputConnector(first);

			if (outSequenceOutputConnector != null
					&& outSequenceOutputConnector.getSourceConnections().size() > 0) {
				node = (ShapeNodeEditPart) ((EsbLinkEditPart) outSequenceOutputConnector
						.getSourceConnections().get(0)).getTarget().getParent();
			}
		}

		return node;
	}
	
	/**
	 * Get left most node of the out sequence of a proxy, api or main sequence.
	 * 
	 * @param parent
	 * @return
	 */
	private static ShapeNodeEditPart getLeftMostNodeOfOutSequence(IGraphicalEditPart parent) {
		ShapeNodeEditPart first = null;
		ShapeNodeEditPart node = null;
		ShapeNodeEditPart target = null;
	 
		AbstractInputConnectorEditPart outSequenceInputConnector = null;

		if (parent instanceof MediatorFlowMediatorFlowCompartmentEditPart) {
			first = (ShapeNodeEditPart) parent.getParent().getParent().getParent().getParent();

			outSequenceInputConnector = EditorUtils.getBaseFigureInputConnector(first);

			if (outSequenceInputConnector != null
					&& outSequenceInputConnector.getTargetConnections().size() > 0) {
				node = (ShapeNodeEditPart) ((EsbLinkEditPart) outSequenceInputConnector
						.getTargetConnections().get(0)).getSource().getParent();
			} else {
				/*
				 * If there is a drop mediator at the end of the outSequence or
				 * the last link has been removed due to unexpected reason.
				 */
				AbstractOutputConnectorEditPart outputConnector = null;
				first = (ShapeNodeEditPart) parent.getParent().getParent().getParent().getParent();
				outputConnector = EditorUtils.getProxyOutSequenceOutputConnector(first);
				if(outputConnector.getSourceConnections().size()>0){
	
					while (outputConnector != null && outputConnector.getSourceConnections().size() > 0) {						
						target = (ShapeNodeEditPart) ((EsbLinkEditPart) outputConnector
								.getSourceConnections().get(0)).getTarget().getParent();
						if(!(target instanceof AbstractBaseFigureEditPart)){
							node=target;
							outputConnector = EditorUtils.getMediatorOutputConnector(node);
						}else{
							break;
						}						
					}
				}
			}
		}

		return node;
	}

	private static int getEditPartIndexFromParent(ShapeNodeEditPart first) {
		List<EditPart> siblings = first.getParent().getChildren();
		int index = 0;
		int editPartIndex = 0;
		for (EditPart sibling : siblings) {
			if (sibling.equals(first)) {
				editPartIndex = index;
			}
			index++;
		}
		return editPartIndex;
	}

	private static int getTotalYFromChildren(ShapeNodeEditPart first) {
		List<EditPart> children = first.getParent().getChildren();
		int y = 0;
		for (EditPart child : children) {
			y += getMaximumY((IGraphicalEditPart) child);
		}
		return y;
	}

	private static int getMaximumY(IGraphicalEditPart parent) {
		int y = 0;
		IGraphicalEditPart mediatorFlow = (IGraphicalEditPart) parent.getChildren().get(0);
		IGraphicalEditPart mediatorFlowCompartment = (IGraphicalEditPart) mediatorFlow
				.getChildren().get(0);
		if (mediatorFlowCompartment.getChildren().size() >= 1) {
			for (int i = 0; i < mediatorFlowCompartment.getChildren().size(); ++i) {
				GraphicalEditPart gep = (GraphicalEditPart) mediatorFlowCompartment.getChildren()
						.get(i);
				Rectangle bound = gep.getFigure().getBounds();
				if (bound.height > y) {
					y = bound.height;
				}
			}
		} else {
			y = 60;
		}
		return y;
	}

	private static int getTotalChildCount(ShapeNodeEditPart first) {
		List<EditPart> children = first.getParent().getChildren();
		int childCount = 0;
		for (EditPart child : children) {
			childCount += getChildCount((IGraphicalEditPart) child);
		}
		return childCount;
	}

	private static int getChildCount(IGraphicalEditPart parent) {
		IGraphicalEditPart mediatorFlow = (IGraphicalEditPart) parent.getChildren().get(0);
		IGraphicalEditPart mediatorFlowCompartment = (IGraphicalEditPart) mediatorFlow
				.getChildren().get(0);
		int childCount = mediatorFlowCompartment.getChildren().size();
		return childCount;
	}

	/**
	 * Get the maximum compartment width of the
	 * MultipleCompartmentComplexFiguredAbstractMediator
	 * 
	 * @param mainContainer
	 * @return
	 */
	private static int getMaxCompartmentWidth(GraphicalEditPart mainContainer) {
		int maxWidth = 0;
		int compartmentWidth = 2 * CONNECTOR_LENGTH + ARRWO_LENGTH;
		List<EditPart> children = new ArrayList<EditPart>();
		if (mainContainer instanceof SwitchMediatorContainerEditPart) {
			List<EditPart> caseEditParts = ((SwitchCaseParentContainerEditPart) mainContainer
					.getChildren().get(0)).getChildren();
			List<EditPart> defaultEditParts = ((SwitchDefaultParentContainerEditPart) mainContainer
					.getChildren().get(1)).getChildren();
			for (EditPart caseEditPart : caseEditParts) {
				children.add(caseEditPart);
			}
			for (EditPart defaultEditPart : defaultEditParts) {
				children.add(defaultEditPart);
			}
		} else {
			children = mainContainer.getChildren();
		}

		for (EditPart child : children) {
			List<EditPart> childMediatorEditparts = ((GraphicalEditPart) ((GraphicalEditPart) child
					.getChildren().get(0)).getChildren().get(0)).getChildren();
			compartmentWidth = 2 * CONNECTOR_LENGTH + ARRWO_LENGTH;
			for (EditPart mediatorEditpart : childMediatorEditparts) {
				compartmentWidth += ((IGraphicalEditPart) mediatorEditpart).getFigure().getBounds().width
						+ ARRWO_LENGTH + 2 * CONNECTOR_LENGTH;
			}
			if (compartmentWidth > maxWidth) {
				maxWidth = compartmentWidth;
			}
		}

		return maxWidth;
	}

	/**
	 * Get the height of the MultipleCompartmentComplexFiguredAbstractMediator
	 * 
	 * @param mainContainer
	 * @return
	 */
	private static int getMultipleCompartmentComplexMediatorHeight(GraphicalEditPart mainContainer) {
		int height = 0;

		List<EditPart> children = new ArrayList<EditPart>();
		if (mainContainer instanceof SwitchMediatorContainerEditPart) {
			List<EditPart> caseEditParts = ((SwitchCaseParentContainerEditPart) mainContainer
					.getChildren().get(0)).getChildren();
			List<EditPart> defaultEditParts = ((SwitchDefaultParentContainerEditPart) mainContainer
					.getChildren().get(1)).getChildren();
			for (EditPart caseEditPart : caseEditParts) {
				children.add(caseEditPart);
			}
			for (EditPart defaultEditPart : defaultEditParts) {
				children.add(defaultEditPart);
			}
		} else {
			children = mainContainer.getChildren();
		}

		for (EditPart child : children) {
			height += ((IGraphicalEditPart) child).getFigure().getBounds().height;
		}

		return height;
	}

	/**
	 * Resize all compartments of the
	 * MultipleCompartmentComplexFiguredAbstractMediator
	 * 
	 * @param mainContainer
	 * @param maxWidth
	 */
	private static void resizeCompartments(GraphicalEditPart mainContainer, int maxWidth) {
		int compartmentHeight = 0;
		if (maxWidth <= 60) {
			maxWidth = 100;
		}

		List<EditPart> children = new ArrayList<EditPart>();
		if (mainContainer instanceof SwitchMediatorContainerEditPart) {
			List<EditPart> caseEditParts = ((SwitchCaseParentContainerEditPart) mainContainer
					.getChildren().get(0)).getChildren();
			List<EditPart> defaultEditParts = ((SwitchDefaultParentContainerEditPart) mainContainer
					.getChildren().get(1)).getChildren();
			for (EditPart caseEditPart : caseEditParts) {
				children.add(caseEditPart);
			}
			for (EditPart defaultEditPart : defaultEditParts) {
				children.add(defaultEditPart);
			}
		} else {
			children = mainContainer.getChildren();
		}

		for (EditPart child : children) {
			compartmentHeight = ((IGraphicalEditPart) child).getFigure().getMinimumSize().height;
			((GraphicalEditPart) child).getFigure().setMinimumSize(
					new Dimension(maxWidth, compartmentHeight));
		}
	}
	
	/**
	 * Arrange proxy/api in sequence input connector links as they parallel to
	 * each other.
	 * 
	 * @param mediatorFlowMediatorFlowCompartmentEditPart
	 */
	private static void arrangeInSequenceInputConnectors(
			EditPart mediatorFlowMediatorFlowCompartmentEditPart) {
		if (mediatorFlowMediatorFlowCompartmentEditPart == null) {
			return;
		}

		AbstractBaseFigureEditPart baseFigureEditpart = (AbstractBaseFigureEditPart) mediatorFlowMediatorFlowCompartmentEditPart
				.getParent().getParent().getParent().getParent();
		List children = baseFigureEditpart.getChildren();
		GraphicalEditPart mediatorFlowEditpart = (GraphicalEditPart) mediatorFlowMediatorFlowCompartmentEditPart
				.getParent();

		Rectangle mediatorFlowBounds = mediatorFlowEditpart.getFigure().getBounds().getCopy();
		((GraphicalEditPart) mediatorFlowMediatorFlowCompartmentEditPart.getParent()).getFigure()
				.translateToAbsolute(mediatorFlowBounds);

		for (Object child : children) {
			if (child instanceof ProxyInSequenceInputConnectorEditPart
					|| child instanceof APIResourceInSequenceInputConnectorEditPart) {
				AbstractBaseFigureInputConnectorEditPart inSequenceInputConnector = (AbstractBaseFigureInputConnectorEditPart) child;

				if (inSequenceInputConnector.getTargetConnections().size() > 0) {
				EsbLinkEditPart targetConnection = (EsbLinkEditPart) inSequenceInputConnector
						.getTargetConnections().get(0);
				
				AbstractConnectorEditPart source = (AbstractConnectorEditPart) targetConnection
						.getSource();
				
				Rectangle sendMediatorOutputConnectorBounds = source.getFigure().getBounds()
						.getCopy();
				source.getFigure().translateToAbsolute(sendMediatorOutputConnectorBounds);
			
				double locationScale = ((double) (sendMediatorOutputConnectorBounds.y - mediatorFlowBounds.y))
						/ mediatorFlowBounds.height;
				locationScale = Math.round(locationScale * 10000.0) / 10000.0;

				BorderItemLocator inputLocator = new FixedBorderItemLocator(
						mediatorFlowEditpart.getFigure(), inSequenceInputConnector.getFigure(),
						PositionConstants.EAST, locationScale);

				((AbstractBorderedShapeEditPart) baseFigureEditpart).getBorderedFigure()
						.getBorderItemContainer()
						.add(inSequenceInputConnector.getFigure(), inputLocator);
				}
			}
		}
	}
}