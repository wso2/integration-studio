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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SlidingBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.SwitchMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartmentCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartmentItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory.NodeToolEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated NOT
 */
public class MediatorFlowMediatorFlowCompartmentEditPart extends AbstractMediatorFlowCompartmentEditPart {

	BorderedNodeFigure borderedNodeFigure;
	AbstractBorderItemEditPart sourceOutputConnector = null;
	AbstractBorderItemEditPart outputConnectorEditPart = null;
	ShapeNodeEditPart sourceEditPart = null;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7034;

	/**
	 * @generated
	 */
	public MediatorFlowMediatorFlowCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	public String getCompartmentName() {
		return null;
		//return Messages.MediatorFlowMediatorFlowCompartmentEditPart_title;
	}

	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(true);
		// Override default border.
		LineBorder border = new LineBorder(new Color(null, 224, 224, 224), 1, SWT.BORDER_SOLID);
		result.setBorder(border);
		borderedNodeFigure = new BorderedNodeFigure(result);
		result.setToolTip(getCompartmentName());
		//return result;
		return borderedNodeFigure;
	}

	public ResizableCompartmentFigure getCompartmentFigure() {
		return (ResizableCompartmentFigure) borderedNodeFigure.getMainFigure();
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();

		if (childEditPart instanceof AbstractEndpoint) {
			borderedNodeFigure.getBorderItemContainer().add(
					((AbstractEndpoint) childEditPart).getFigure(),
					new SlidingBorderItemLocator(borderedNodeFigure.getMainFigure(), ((AbstractEndpoint) childEditPart)
							.getFigure(), PositionConstants.EAST, 10, 5));
		}

		/*		if (childEditPart instanceof AddressEndPointEditPart) {
		 borderedNodeFigure.getBorderItemContainer()
		 .add(((AddressEndPointEditPart) childEditPart).getFigure(),
		 new SlidingBorderItemLocator(borderedNodeFigure
		 .getMainFigure(),
		 ((AddressEndPointEditPart) childEditPart)
		 .getFigure(),
		 PositionConstants.EAST, 10, 5));
		 } else if (childEditPart instanceof WSDLEndPointEditPart) {
		 borderedNodeFigure.getBorderItemContainer().add(
		 ((WSDLEndPointEditPart) childEditPart).getFigure(),
		 new SlidingBorderItemLocator(borderedNodeFigure
		 .getMainFigure(),
		 ((WSDLEndPointEditPart) childEditPart).getFigure(),
		 PositionConstants.EAST, 10, 5));
		 } else if (childEditPart instanceof DefaultEndPointEditPart) {
		 borderedNodeFigure.getBorderItemContainer()
		 .add(((DefaultEndPointEditPart) childEditPart).getFigure(),
		 new SlidingBorderItemLocator(borderedNodeFigure
		 .getMainFigure(),
		 ((DefaultEndPointEditPart) childEditPart)
		 .getFigure(),
		 PositionConstants.EAST, 10, 5));
		 } else if (childEditPart instanceof NamedEndpointEditPart) {
		 borderedNodeFigure.getBorderItemContainer()
		 .add(((NamedEndpointEditPart) childEditPart).getFigure(),
		 new SlidingBorderItemLocator(borderedNodeFigure
		 .getMainFigure(),
		 ((NamedEndpointEditPart) childEditPart)
		 .getFigure(),
		 PositionConstants.EAST, 10, 5));
		 }*/

		else {
			index = Math.min(getContentPane().getChildren().size(), index);
			getContentPane().add(child, index);
		}
	}

	protected void removeChildVisual(EditPart child) {
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		if ((child instanceof AbstractEndpoint)) {
			borderedNodeFigure.getBorderItemContainer().remove(childFigure);
		}
		/*		if ((child instanceof AddressEndPointEditPart)
		 || (child instanceof WSDLEndPointEditPart)
		 || (child instanceof DefaultEndPointEditPart)
		 || (child instanceof NamedEndpointEditPart)) {
		 borderedNodeFigure.getBorderItemContainer().remove(childFigure);
		 }*/else {
			getContentPane().remove(childFigure);
		}
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MediatorFlowMediatorFlowCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new MediatorFlowMediatorFlowCompartmentCanonicalEditPolicy());
	}

	private void addInSequenceInputConnector() {
		ProxyInSequenceInputConnector inSequenceInputConnector = EsbFactory.eINSTANCE
				.createProxyInSequenceInputConnector();
		AddCommand addCommand = new AddCommand(getEditingDomain(),
				((Node) EditorUtils.getProxy(this).getModel()).getElement(),
				EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS, inSequenceInputConnector);
		if (addCommand.canExecute()) {
			getEditingDomain().getCommandStack().execute(addCommand);
		}
	}

	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		if (child instanceof SendMediatorEditPart) {
			//addInSequenceInputConnector();
		}

		//Refresh connector's position.
		((MediatorFlowEditPart) child.getParent().getParent()).refreshConnector(child.getParent().getParent()
				.getParent().getParent().getParent());

		if (child instanceof AbstractMediator) {
			((AbstractMediator) child).reverse(child);
		}
		if (child instanceof SwitchMediatorEditPart) {
			SwitchMediatorEditPart switchMediatorEditPart = (SwitchMediatorEditPart) child;
			SwitchMediatorUtils.addCaseBranchInitially(switchMediatorEditPart, getEditingDomain());

		}
		/*		if (child instanceof SequenceEditPart) {
		 SequenceEditPart sequenceEditPart = (SequenceEditPart) child;
		 EditPart editpart = (EditPart) ((StructuredSelection) sequenceEditPart.getViewer()
		 .getEditDomain().getPaletteViewer().getSelection()).getFirstElement();
		 if (editpart instanceof ToolEntryEditPart) {
		 if (((ToolEntryEditPart) editpart).getModel() instanceof NodeToolEntry) {
		 String label = ((NodeToolEntry) ((ToolEntryEditPart) editpart).getModel())
		 .getLabel();
		 if ((!label.equals("")) && (!label.equals("Sequence"))) {
		 try {
		 ((Sequence) ((View) sequenceEditPart.getModel()).getElement())
		 .setName(label);
		 } catch (java.lang.IllegalStateException e) {
		 log.error("This is occured while undo operation..", e);
		 }
		 }
		 } else if (((ToolEntryEditPart) editpart).getModel() instanceof org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart.NodeToolEntry) {
		 String label = ((org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart.NodeToolEntry) ((ToolEntryEditPart) editpart)
		 .getModel()).getLabel();
		 if ((!label.equals("")) && (!label.equals("Sequence"))) {
		 ((Sequence) ((View) sequenceEditPart.getModel()).getElement())
		 .setName(label);
		 }
		 }
		 }
		 }*/

		if (child instanceof FailoverEndPointEditPart) {
			FailoverEndPointEditPart endpointEditPart = (FailoverEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			/*			if (((FailoverEndPoint) parentEndpoint).getOutputConnector().size() == 0) {
			 TransactionalEditingDomain domain = getEditingDomain();
			 for (int i = 0; i < 2; ++i) {
			 FailoverEndPointOutputConnector outputConnector = EsbFactory.eINSTANCE
			 .createFailoverEndPointOutputConnector();
			 AddCommand addCmd = new AddCommand(
			 domain,
			 parentEndpoint,
			 EsbPackage.Literals.FAILOVER_END_POINT__OUTPUT_CONNECTOR,
			 outputConnector);
			 if (addCmd.canExecute()) {
			 domain.getCommandStack().execute(addCmd);
			 }
			 }
			 }*/
			if (((FailoverEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((FailoverEndPoint) parentEndpoint).getWestOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createFailoverEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof LoadBalanceEndPointEditPart) {
			LoadBalanceEndPointEditPart endpointEditPart = (LoadBalanceEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			/*			if (((LoadBalanceEndPoint) parentEndpoint).getOutputConnector()
			 .size() == 0) {
			 TransactionalEditingDomain domain = getEditingDomain();
			 for (int i = 0; i < 2; ++i) {
			 LoadBalanceEndPointOutputConnector outputConnector = EsbFactory.eINSTANCE
			 .createLoadBalanceEndPointOutputConnector();
			 AddCommand addCmd = new AddCommand(
			 domain,
			 parentEndpoint,
			 EsbPackage.Literals.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR,
			 outputConnector);
			 if (addCmd.canExecute()) {
			 domain.getCommandStack().execute(addCmd);
			 }
			 }
			 }*/
			if (((LoadBalanceEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((LoadBalanceEndPoint) parentEndpoint).getWestOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createLoadBalanceEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}

		} else if (child instanceof DefaultEndPointEditPart) {
			DefaultEndPointEditPart endpointEditPart = (DefaultEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			if (((DefaultEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((DefaultEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.DEFAULT_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createDefaultEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof AddressEndPointEditPart) {
			AddressEndPointEditPart endpointEditPart = (AddressEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			if (((AddressEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((AddressEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.ADDRESS_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createAddressEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof WSDLEndPointEditPart) {
			WSDLEndPointEditPart endpointEditPart = (WSDLEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			if (((WSDLEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((WSDLEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.WSDL_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createWSDLEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof AddressingEndpointEditPart) {
			AddressingEndpointEditPart endpointEditPart = (AddressingEndpointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			if (((AddressingEndpoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((AddressingEndpoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.ADDRESSING_ENDPOINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createAddressingEndpointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof NamedEndpointEditPart) {
			NamedEndpointEditPart endpointEditPart = (NamedEndpointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			if (((NamedEndpoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((NamedEndpoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.NAMED_ENDPOINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createNamedEndpointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}

			NamedEndpointEditPart namedEndPointEditPart = (NamedEndpointEditPart) child;
			EditPart editpart = (EditPart) ((StructuredSelection) namedEndPointEditPart.getViewer().getEditDomain()
					.getPaletteViewer().getSelection()).getFirstElement();
			if (editpart instanceof ToolEntryEditPart) {
				if (((ToolEntryEditPart) editpart).getModel() instanceof NodeToolEntry) {
					String label = ((NodeToolEntry) ((ToolEntryEditPart) editpart).getModel()).getLabel();
					if ((!label.equals("")) && (!label.equals("Named EndPoint"))) {
						try {
							((NamedEndpoint) ((View) namedEndPointEditPart.getModel()).getElement()).setName(label);
						} catch (java.lang.IllegalStateException e) {
							log.error("This is occured while undo operation..", e);
						}
					}
				} /*
					 * else if (((ToolEntryEditPart) editpart).getModel() instanceof
					 * org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.
					 * SequenceEditPart.NodeToolEntry) { String label =
					 * ((org.wso2.developerstudio
					 * .eclipse.gmf.esb.diagram.edit.parts.
					 * SequenceEditPart.NodeToolEntry) ((ToolEntryEditPart)
					 * editpart) .getModel()).getLabel(); if ((!label.equals("")) &&
					 * (!label.equals("Sequence"))) { ((Sequence) ((View)
					 * namedEndPointEditPart.getModel())
					 * .getElement()).setName(label); } }
					 */
			}

		} else if (child instanceof RecipientListEndPointEditPart) {
			RecipientListEndPointEditPart endpointEditPart = (RecipientListEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();

			if (((RecipientListEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((RecipientListEndPoint) parentEndpoint).getWestOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.RECIPIENT_LIST_END_POINT__WEST_OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createRecipientListEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof TemplateEndpointEditPart) {
			TemplateEndpointEditPart endpointEditPart = (TemplateEndpointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			if (((TemplateEndpoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((TemplateEndpoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createTemplateEndpointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof HTTPEndpointEditPart) {
			HTTPEndpointEditPart endpointEditPart = (HTTPEndpointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel())
					.getElement();
			if (((HTTPEndpoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
				if (((HTTPEndpoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(getEditingDomain(), parentEndpoint,
							EsbPackage.Literals.HTTP_ENDPOINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE.createHTTPEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		}

	}

	protected void removeChild(EditPart child) {
		MediatorFlowEditPart mediatorFlow = (MediatorFlowEditPart) child.getParent().getParent();
		EditPart proxyservice = child.getParent().getParent().getParent().getParent().getParent().getParent()
				.getParent();
		super.removeChild(child);
		if (this.getChildren().size() == 0) {
			outputConnectorEditPart = null;
		}

		if (child instanceof SendMediatorEditPart) {
			/*			RemoveCommand removeCmd = new RemoveCommand(getEditingDomain(), ((Node)EditorUtils.getProxy(this).getModel()).getElement(),
			 EsbPackage.Literals.PROXY_SERVICE__IN_SEQUENCE_INPUT_CONNECTORS,
			 connectorAndEndpointMap.get(child));
			 if (removeCmd.canExecute()) {
			 editingDomain.getCommandStack().execute(removeCmd);
			 }*/
		}
		mediatorFlow.refreshConnector(proxyservice);
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	public void connectNormally(EditPart child) {
		AbstractBorderItemEditPart inputConnector = null;

		if ((child instanceof AbstractMediator) || (child instanceof AbstractEndpoint)) {

			for (int i = 0; i < child.getChildren().size(); ++i) {
				if (child.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
					inputConnector = (AbstractMediatorInputConnectorEditPart) child.getChildren().get(i);
				}
				if (child.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {
					sourceOutputConnector = (AbstractMediatorOutputConnectorEditPart) child.getChildren().get(i);
				}
				if (child.getChildren().get(i) instanceof AbstractEndpointInputConnectorEditPart) {
					inputConnector = (AbstractEndpointInputConnectorEditPart) child.getChildren().get(i);
				}
				if (child.getChildren().get(i) instanceof AbstractEndpointOutputConnectorEditPart) {
					sourceOutputConnector = (AbstractEndpointOutputConnectorEditPart) child.getChildren().get(i);
				}

			}
			if (outputConnectorEditPart == null) {
				outputConnectorEditPart = ((AbstractOutputConnectorEditPart) this.getParent().getParent().getParent()
						.getParent().getChildren().get(1));
			}
			if (sourceEditPart == null || sourceEditPart.getRoot() == null) {
				sourceEditPart = (AbstractBorderedShapeEditPart) this.getParent().getParent().getParent().getParent();
			}

			CompoundCommand cc = new CompoundCommand("Create Link");

			if (inputConnector != null) {
				ICommand createSubTopicsCmd = new DeferredCreateConnectionViewAndElementCommand(
						new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
								((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(),
								sourceEditPart.getDiagramPreferencesHint()), new EObjectAdapter(
								(EObject) outputConnectorEditPart.getModel()), new EObjectAdapter(
								(EObject) (inputConnector).getModel()), sourceEditPart.getViewer());

				cc.add(new ICommandProxy(createSubTopicsCmd));

				getDiagramEditDomain().getDiagramCommandStack().execute(cc);
			}

			outputConnectorEditPart = sourceOutputConnector;
			sourceEditPart = (ShapeNodeEditPart) child;

		}
	}

	public void setOutputConnectorEditPart(AbstractBorderItemEditPart outputConnectorEditPart) {
		this.outputConnectorEditPart = outputConnectorEditPart;
	}

	public void setSourceEditPart(ShapeNodeEditPart sourceEditPart) {
		this.sourceEditPart = sourceEditPart;
	}
}
