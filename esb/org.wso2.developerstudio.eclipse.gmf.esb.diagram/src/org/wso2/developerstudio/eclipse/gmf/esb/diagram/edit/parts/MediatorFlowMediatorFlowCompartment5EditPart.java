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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.internal.ui.palette.editparts.ToolEntryEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
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
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpointOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SlidingBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.layout.XYRepossition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.SwitchMediatorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment5CanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlowMediatorFlowCompartment5ItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory.NodeToolEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * @generated NOT
 */
public class MediatorFlowMediatorFlowCompartment5EditPart extends AbstractMediatorFlowCompartmentEditPart {

	/* 	Sequences  */

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7035;

	BorderedNodeFigure borderedNodeFigure;
	AbstractBorderItemEditPart sourceOutputConnector = null;
	AbstractBorderItemEditPart outputConnectorEditPart = null;
	ShapeNodeEditPart sourceEditPart = null;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * @generated
	 */
	public MediatorFlowMediatorFlowCompartment5EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	public String getCompartmentName() {
		return null;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MediatorFlowMediatorFlowCompartment5ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new MediatorFlowMediatorFlowCompartment5CanonicalEditPolicy());
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		// Override default border.
		result.setBorder(new MarginBorder(0, 0, 0, 0));
		borderedNodeFigure = new BorderedNodeFigure(result);
		result.setToolTip(getCompartmentName());
		//return result;
		return borderedNodeFigure;
	}

	public ResizableCompartmentFigure getCompartmentFigure() {
		return (ResizableCompartmentFigure) borderedNodeFigure.getMainFigure();
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		if (childEditPart instanceof AbstractEndpoint) {
			addEndpointChildVisual((AbstractEndpoint) childEditPart);
		} else {
			index = Math.min(getContentPane().getChildren().size(), index);
			getContentPane().add(child, index);
		}
	}

	private <T extends AbstractEndpoint> void addEndpointChildVisual(T childEditPart) {
		borderedNodeFigure.getBorderItemContainer().add(
				((T) childEditPart).getFigure(),
				new SlidingBorderItemLocator(borderedNodeFigure.getMainFigure(), ((T) childEditPart).getFigure(),
						PositionConstants.EAST, 10, 5));
	}

	protected void removeChildVisual(EditPart child) {
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		if ((child instanceof AbstractEndpoint)) {
			borderedNodeFigure.getBorderItemContainer().remove(childFigure);
		} else {
			getContentPane().remove(childFigure);
		}
	}

	protected void removeChild(EditPart child) {
		super.removeChild(child);
		if (child instanceof AbstractEndpoint) {
			InputConnector connector = (InputConnector) ((Node) EditorUtils.getInputConnector(
					(ShapeNodeEditPart) this.getParent().getParent()).getModel()).getElement();
			if (connector.getIncomingLinks().isEmpty()) {
				if (borderedNodeFigure.getBorderItemContainer().getChildren().size() == 0) {
					SequencesInputConnectorEditPart inputConnectorEditPart = (SequencesInputConnectorEditPart) EditorUtils
							.getInputConnector((ShapeNodeEditPart) this.getParent().getParent());
					NodeFigure figureInput = inputConnectorEditPart.getNodeFigure();
					figureInput.removeAll();
					figureInput.add(inputConnectorEditPart.getPrimaryShape());
				}
			}
		}
	}

	protected void addChild(EditPart child, int index) {
		super.addChild(child, index);
		((MediatorFlow5EditPart) child.getParent().getParent()).refreshConnector(this.getParent().getParent());
		/*AbstractInputConnector inputConnector = null;*/

		if (this.getParent().getParent().getChildren().size() < 2) {
			return;
		}

		/*		if (child instanceof AbstractMediator) {
		 for (int i = 0; i < child.getChildren().size(); ++i) {
		 if (child.getChildren().get(i) instanceof AbstractInputConnector) {
		 inputConnector = (AbstractInputConnector) child
		 .getChildren().get(i);
		 }
		 if (child.getChildren().get(i) instanceof AbstractOutputConnector) {
		 sourceOutputConnector = (AbstractOutputConnector) child
		 .getChildren().get(i);
		 }
		 }
		 if (outputConnectorEditPart == null) {
		 outputConnectorEditPart = ((AbstractOutputConnector) this
		 .getParent().getParent().getChildren().get(2));
		 }
		 if (sourceEditPart == null || sourceEditPart.getRoot() == null) {
		 sourceEditPart = (AbstractBorderedShapeEditPart) this
		 .getParent().getParent();
		 }

		 CompoundCommand compoundCommand = new CompoundCommand();

		 ICommand createLinkCommand = new DeferredCreateConnectionViewAndElementCommand(
		 new CreateConnectionViewAndElementRequest(
		 EsbElementTypes.EsbLink_4001,
		 ((IHintedType) EsbElementTypes.EsbLink_4001)
		 .getSemanticHint(),
		 sourceEditPart.getDiagramPreferencesHint()),
		 new EObjectAdapter((EObject) outputConnectorEditPart
		 .getModel()), new EObjectAdapter(
		 (EObject) (inputConnector).getModel()),
		 sourceEditPart.getViewer());

		 compoundCommand.add(new ICommandProxy(createLinkCommand));

		 getDiagramEditDomain().getDiagramCommandStack().execute(
		 compoundCommand);

		 outputConnectorEditPart = sourceOutputConnector;
		 sourceEditPart = (AbstractBorderedShapeEditPart) child;

		 }*/
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
		 ((Sequence) ((View) sequenceEditPart.getModel()).getElement())
		 .setName(label);
		 }
		 } else if (((ToolEntryEditPart) editpart).getModel() instanceof SequenceEditPart.NodeToolEntry) {
		 String label = ((SequenceEditPart.NodeToolEntry) ((ToolEntryEditPart) editpart)
		 .getModel()).getLabel();
		 if ((!label.equals("")) && (!label.equals("Sequence"))) {
		 ((Sequence) ((View) sequenceEditPart.getModel()).getElement())
		 .setName(label);
		 }
		 }
		 }
		 }*/

		if (child instanceof AbstractEndpoint) {
			SequencesInputConnectorEditPart inputConnectorEditPart = (SequencesInputConnectorEditPart) EditorUtils
					.getInputConnector((ShapeNodeEditPart) this.getParent().getParent());
			NodeFigure figureInput = inputConnectorEditPart.getNodeFigure();
			figureInput.removeAll();
			Figure emptyFigure = new Figure();
			figureInput.add(emptyFigure);
		}

		if (child instanceof NamedEndpointEditPart) {
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
							log.error("This is occured while set name operation..", e);
						}
					}
				}
			}
		}

		/*if (child instanceof FailoverEndPointEditPart) {
			FailoverEndPointEditPart endpointEditPart = (FailoverEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((FailoverEndPoint) parentEndpoint).getOutputConnector().size() == 0) {
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
			}
			if (((FailoverEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((FailoverEndPoint) parentEndpoint)
						.getWestOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createFailoverEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof LoadBalanceEndPointEditPart) {
			LoadBalanceEndPointEditPart endpointEditPart = (LoadBalanceEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((LoadBalanceEndPoint) parentEndpoint).getOutputConnector()
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
			}
			if (((LoadBalanceEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((LoadBalanceEndPoint) parentEndpoint)
						.getWestOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createLoadBalanceEndPointWestOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}

		} else if (child instanceof DefaultEndPointEditPart) {
			DefaultEndPointEditPart endpointEditPart = (DefaultEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((DefaultEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((DefaultEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.DEFAULT_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createDefaultEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof AddressEndPointEditPart) {
			AddressEndPointEditPart endpointEditPart = (AddressEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((AddressEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((AddressEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.ADDRESS_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createAddressEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}

		} else if (child instanceof WSDLEndPointEditPart) {
			WSDLEndPointEditPart endpointEditPart = (WSDLEndPointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((WSDLEndPoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((WSDLEndPoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.WSDL_END_POINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createWSDLEndPointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		} else if (child instanceof NamedEndpointEditPart) {
			NamedEndpointEditPart endpointEditPart = (NamedEndpointEditPart) child;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart)
					.getModel()).getElement();
			if (((NamedEndpoint) parentEndpoint).getInputConnector()
					.getIncomingLinks().size() == 0) {
				if (((NamedEndpoint) parentEndpoint).getOutputConnector() == null) {
					SetCommand addCmd = new SetCommand(
							getEditingDomain(),
							parentEndpoint,
							EsbPackage.Literals.NAMED_ENDPOINT__OUTPUT_CONNECTOR,
							EsbFactory.eINSTANCE
									.createNamedEndpointOutputConnector());
					if (addCmd.canExecute()) {
						getEditingDomain().getCommandStack().execute(addCmd);
					}
				}
			}
		}*/
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
		AbstractBorderItemEditPart outputConnector = null;

		if ((child instanceof AbstractMediator) || (child instanceof AbstractEndpoint)) {

			for (int i = 0; i < child.getChildren().size(); ++i) {
				if (child.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
					inputConnector = (AbstractMediatorInputConnectorEditPart) child.getChildren().get(i);
				}
				if (child.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {
					outputConnector = (AbstractMediatorOutputConnectorEditPart) child.getChildren().get(i);
				}
			}

			CompoundCommand cc = new CompoundCommand("Create Link");

			if (inputConnector != null) {

				ShapeNodeEditPart sourceEditPart1 = (AbstractBorderedShapeEditPart) this.getParent().getParent();
				AbstractBorderItemEditPart outputConnectorEditPart_ = EditorUtils
						.getOutputConnector((ShapeNodeEditPart) this.getParent().getParent());
				AbstractBorderItemEditPart inputConnectorEditPart_ = EditorUtils
						.getInputConnector((ShapeNodeEditPart) this.getParent().getParent());

				ICommand createSubTopicsCmd = new DeferredCreateConnectionViewAndElementCommand(
						new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
								((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(),
								sourceEditPart1.getDiagramPreferencesHint()), new EObjectAdapter(
								(EObject) outputConnectorEditPart_.getModel()), new EObjectAdapter(
								(EObject) (inputConnector).getModel()), sourceEditPart1.getViewer());

				cc.add(new ICommandProxy(createSubTopicsCmd));

				if (outputConnector != null) {
					ICommand createSubTopicsCmd2 = new DeferredCreateConnectionViewAndElementCommand(
							new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
									((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(),
									((ShapeNodeEditPart) outputConnector.getParent()).getDiagramPreferencesHint()),
							new EObjectAdapter((EObject) outputConnector.getModel()), new EObjectAdapter(
									(EObject) (inputConnectorEditPart_).getModel()),
							((ShapeNodeEditPart) outputConnector.getParent()).getViewer());

					//cc.add(new ICommandProxy(createSubTopicsCmd));
					cc.add(new ICommandProxy(createSubTopicsCmd2));
				}

				getDiagramEditDomain().getDiagramCommandStack().execute(cc);
			}
		}
	}

	/*	public void connectNormally(EditPart child) {
	 AbstractBorderItemEditPart inputConnector = null;

	 if ((child instanceof AbstractMediator) || (child instanceof AbstractEndpoint)) {

	 for (int i = 0; i < child.getChildren().size(); ++i) {
	 if (child.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
	 inputConnector = (AbstractMediatorInputConnectorEditPart) child.getChildren()
	 .get(i);
	 }
	 if (child.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {
	 sourceOutputConnector = (AbstractMediatorOutputConnectorEditPart) child
	 .getChildren().get(i);
	 }
	 if (child.getChildren().get(i) instanceof AbstractEndpointInputConnectorEditPart) {
	 inputConnector = (AbstractEndpointInputConnectorEditPart) child.getChildren()
	 .get(i);
	 }
	 if (child.getChildren().get(i) instanceof AbstractEndpointOutputConnectorEditPart) {
	 sourceOutputConnector = (AbstractEndpointOutputConnectorEditPart) child
	 .getChildren().get(i);
	 }

	 }
	 if (outputConnectorEditPart == null) {
	 outputConnectorEditPart = EditorUtils.getOutputConnector((ShapeNodeEditPart) this
	 .getParent().getParent());
	 outputConnectorEditPart = (AbstractOutputConnectorEditPart) this
	 .getParent().getParent().getChildren().get(2);
	 }
	 if (sourceEditPart == null || sourceEditPart.getRoot() == null) {
	 sourceEditPart = (AbstractBorderedShapeEditPart) this.getParent().getParent();
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
	 }*/

	public void setOutputConnectorEditPart(AbstractBorderItemEditPart outputConnectorEditPart) {
		this.outputConnectorEditPart = outputConnectorEditPart;
	}

	public void setSourceEditPart(ShapeNodeEditPart sourceEditPart) {
		this.sourceEditPart = sourceEditPart;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (//notification.getEventType() == Notification.ADD
			//|| notification.getEventType() == Notification.ADD_MANY
			//||
		notification.getEventType() == Notification.REMOVE || notification.getEventType() == Notification.REMOVE_MANY) {
			Rectangle bounds = getContentPane().getBounds().getCopy();
			IGraphicalEditPart owner = (IGraphicalEditPart) ((IGraphicalEditPart) getParent()).getParent();
			Dimension preferredSize = owner.getFigure().getPreferredSize();
			/*			if (preferredSize.width < bounds.width || preferredSize.height < bounds.height) {
			 SetBoundsCommand sbc = new SetBoundsCommand(owner.getEditingDomain(),
			 "change location", new EObjectAdapter((View) owner.getModel()),
			 new Rectangle(-1, -1, bounds.width + 75, -1));
			 owner.getDiagramEditDomain().getDiagramCommandStack()
			 .execute(new ICommandProxy(sbc));
			 }*/

			//XYRepossition.reArrange(this);
		}
	}
	/*	
	 @Override
	 protected void handleNotificationEvent(Notification notification) {
	 if (notification.getEventType() == Notification.ADD
	 || notification.getEventType() == Notification.ADD_MANY
	 || notification.getEventType() == Notification.REMOVE
	 || notification.getEventType() == Notification.REMOVE_MANY) {
	 Rectangle bounds = getContentPane().getBounds().getCopy();
	 IGraphicalEditPart owner = (IGraphicalEditPart) ((IGraphicalEditPart) getParent())
	 .getParent();
	 Dimension preferredSize = owner.getFigure().getPreferredSize();
	 if (preferredSize.width < bounds.width || preferredSize.height < bounds.height) {
	 SetBoundsCommand sbc = new SetBoundsCommand(owner.getEditingDomain(),
	 "change location", new EObjectAdapter((View) owner.getModel()),
	 new Rectangle(-1, -1, bounds.width + 75, -1));
	 owner.getDiagramEditDomain().getDiagramCommandStack()
	 .execute(new ICommandProxy(sbc));
	 }
	 }
	 super.handleNotificationEvent(notification);
	 }*/

}
