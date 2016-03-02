/*
 * Copyright (c) 2014-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.END_POINT__IN_LINE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DEFAULT_PROPERTY_VALUE_TEXT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.SEND_MEDIATOR_ICON_PATH;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGroupingShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SingleCompartmentComplexFiguredAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.SendMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.SendMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated NOT
 */
public class SendMediatorEditPart extends SingleCompartmentComplexFiguredAbstractMediator {

	public IFigure endpointOutputConnector;
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3515;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public SendMediatorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SendMediatorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new SendMediatorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case SendMediatorInputConnectorEditPart.VISUAL_ID:
				case SendMediatorOutputConnectorEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
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

	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		/*
		if(notification.getFeature() instanceof EReference){
		if("StaticReceivingSequence".equals(((EReference)notification.getFeature()).getName())){
			
			String oldValue=((RegistryKeyProperty) notification.getOldValue()).getKeyValue();
			String newValue=((RegistryKeyProperty) notification.getNewValue()).getKeyValue();
			if(!oldValue.equals(newValue)){

				IEditorPart activeEditor=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (activeEditor instanceof EsbMultiPageEditor) {
					IFile openedFile = ((IFileEditorInput)activeEditor.getEditorInput()).getFile();
			        ElementDuplicator endPointDuplicator = new ElementDuplicator(openedFile.getProject(),((EsbMultiPageEditor)activeEditor).getGraphicalEditor());        
			        endPointDuplicator.updateAssociatedDiagrams((EsbMultiPageEditor)activeEditor);
				}
			}
		}	
		}*/
		if (notification.getFeature() instanceof EAttribute) {
			if (EsbPackage.eINSTANCE.getSendMediator_SkipSerialization().equals(notification.getFeature())) {
				updateEndpointInlineProperty(notification);
			}
		}

	}

	/**
	 * Updates inlineProperty of endpoint when skip serialization property has changed
	 * @param notification
	 */
	private void updateEndpointInlineProperty(Notification notification) {
		if (notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
			IGraphicalEditPart mediatorFlow = getChildBySemanticHint(EsbVisualIDRegistry
					.getType(MediatorFlow19EditPart.VISUAL_ID));
			if (mediatorFlow != null) {
				IGraphicalEditPart mediatorFlowCompartment = mediatorFlow.getChildBySemanticHint(EsbVisualIDRegistry
						.getType(MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID));
				if (mediatorFlowCompartment != null) {
					Iterator<?> iterator = mediatorFlowCompartment.getChildren().iterator();
					while (iterator.hasNext()) {
						Object next = iterator.next();
						if (next instanceof AbstractEndpoint) {
							SetRequest reqSet = new SetRequest(getEditingDomain(),
									((View) ((AbstractEndpoint) next).getModel()).getElement(), END_POINT__IN_LINE,
									notification.getNewBooleanValue());
							SetValueCommand operation = new SetValueCommand(reqSet);
							if (operation.canExecute()) {
								getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(operation));
							}
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new SendMediatorFigure() {
			public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
				super.setBounds(rect);
				if ((!connected) && (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0)) {
					connectToMostSuitableElement();
					reAllocate(rect);
					connected = true;
				}
			};
		};
	}

	/**
	 * @generated
	 */
	public SendMediatorFigure getPrimaryShape() {
		return (SendMediatorFigure) primaryShape;
	}

	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof SendMediatorDescriptionEditPart) {
			((SendMediatorDescriptionEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureSendMediatorPropertyValue());
			return true;
		}
		if (childEditPart instanceof SendMediatorInputConnectorEditPart) {

			IFigure borderItemFigure = ((SendMediatorInputConnectorEditPart) childEditPart).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.WEST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;

		} else if (childEditPart instanceof SendMediatorOutputConnectorEditPart) {

			IFigure borderItemFigure = ((SendMediatorOutputConnectorEditPart) childEditPart).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.EAST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			borderItemFigure.setEnabled(false);

			return true;
		}
		if (childEditPart instanceof SendMediatorEndpointOutputConnectorEditPart) {
			endpointOutputConnector = ((SendMediatorEndpointOutputConnectorEditPart) childEditPart).getFigure();
			endpointOutputConnector.setEnabled(false);
		}
		/*if (childEditPart instanceof ScriptMediatorScriptLanguageEditPart) {
			((ScriptMediatorScriptLanguageEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureScriptMediatorPropertyValue());
			return true;
		}*/
		return false;
	}

	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SendMediatorDescriptionEditPart) {
			return true;
		}
		return false;
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
	protected NodeFigure createMainFigure() {
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

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

	/**
	 * @generated NOT
	 */
	//public class SendMediatorFigure extends SendMediatorGraphicalShape {

	public class SendMediatorFigure extends EsbGroupingShape {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSendMediatorPropertyValue;

		private WrappingLabel sendMediatorDescriptionLabel;

		/**
		 * @generated NOT
		 */
		public SendMediatorFigure() {

			/*			ToolbarLayout layoutThis = new ToolbarLayout();
			 layoutThis.setStretchMinorAxis(true);
			 layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			 layoutThis.setSpacing(0);
			 layoutThis.setVertical(false);

			 this.setLayoutManager(layoutThis);
			 this.setPreferredSize(new Dimension(getMapMode().DPtoLP(250),
			 getMapMode().DPtoLP(100)));
			 this.setOutline(true);*/
			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(false);

			this.setLayoutManager(layoutThis);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(170), getMapMode().DPtoLP(100)));
			this.setOutline(false);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/*		public void add(IFigure figure, Object constraint, int index) {
		 if (figure instanceof DefaultSizeNodeFigure) {
		 GridData layoutData = new GridData();
		 layoutData.grabExcessHorizontalSpace = true;
		 layoutData.grabExcessVerticalSpace = true;
		 layoutData.horizontalAlignment = GridData.FILL;
		 layoutData.verticalAlignment = GridData.FILL;
		 super.add(figure, layoutData, index);
		 } else if (figure instanceof RoundedRectangle) {
		 GridData layoutData = new GridData();
		 layoutData.grabExcessHorizontalSpace = true;
		 layoutData.grabExcessVerticalSpace = true;
		 layoutData.horizontalAlignment = GridData.FILL;
		 layoutData.verticalAlignment = GridData.FILL;
		 super.add(figure, layoutData, index);
		 }

		 else {
		 super.add(figure, constraint, index);
		 }
		 }*/

		public void add(IFigure figure, Object constraint, int index) {
			if (figure instanceof DefaultSizeNodeFigure) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			} else if (figure instanceof RoundedRectangle) {
				GridData layoutData = new GridData();
				layoutData.grabExcessHorizontalSpace = true;
				layoutData.grabExcessVerticalSpace = true;
				layoutData.horizontalAlignment = GridData.FILL;
				layoutData.verticalAlignment = GridData.FILL;
				super.add(figure, layoutData, index);
			}

			else {
				super.add(figure, constraint, index);
			}
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureSendMediatorPropertyValue = new WrappingLabel();
			fFigureSendMediatorPropertyValue
					.setText(DEFAULT_PROPERTY_VALUE_TEXT);
			fFigureSendMediatorPropertyValue.setAlignment(SWT.CENTER);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSendMediatorPropertyValue() {
			return fFigureSendMediatorPropertyValue;
		}

		public WrappingLabel getSendMediatorDescriptionLabel() {
			return sendMediatorDescriptionLabel;
		}

		public String getIconPath() {
			return SEND_MEDIATOR_ICON_PATH;
		}

		public String getNodeName() {
			return Messages.SendMediatorEditPart_NodeName;
		}

		public IFigure getToolTip() {
			if (StringUtils.isEmpty(toolTipMessage)) {
				return new Label(Messages.SendMediatorEditPart_ToolTipMessage);
			} else {
				return new Label(toolTipMessage);
			}
		}

	}

	/**
	 * @generated NOT
	 */
	static final Color THIS_BACK = new Color(null, 230, 230, 230);

}
