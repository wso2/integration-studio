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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;

public abstract class AbstractInputConnectorEditPart extends AbstractConnectorEditPart{

	abstract protected IFigure createNodeShape();
	
	public AbstractInputConnectorEditPart(View view) {
		super(view);
	}
	
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getNotifier() instanceof Node) {
			if (((Node) notification.getNotifier()).getElement() instanceof InputConnector) {
				EditPart element = (EditPart) getViewer().getEditPartRegistry().get(
						notification.getNotifier());
				if (((AbstractInputConnectorEditPart) element).getTargetConnections().size() == 0) {
					if (((InputConnector) ((Node) notification.getNotifier()).getElement())
							.getIncomingLinks().size() != 0) {
						Collection col = new ArrayList();
						col.add(((InputConnector) ((Node) notification.getNotifier()).getElement())
								.getIncomingLinks().get(0));

						org.eclipse.emf.edit.command.DeleteCommand del = new org.eclipse.emf.edit.command.DeleteCommand(
								getEditingDomain(), col);
						if (del.canExecute()) {
							getEditingDomain().getCommandStack().execute(del);
						}
					}
				}
			}
		}
	}
	
	protected void toggleVisibility(InputConnector inputConnector){		
		if (inputConnector.getIncomingLinks().size() != 0) {
			/*
			 * This will remove the arrow head of output connector if it is
			 * connected to any other input connector.
			 */
			NodeFigure figureInput = this.getNodeFigure();
			figureInput.removeAll();
			Figure emptyFigure = new Figure();
			figureInput.add(emptyFigure);
		} else {
			/*
			 * This will add the arrow head of output connector if it is not
			 * connected to any other input connector.
			 */
			NodeFigure figureInput = this.getNodeFigure();
			figureInput.removeAll();
			figureInput.add(createNodeShape());
		}		
	}
	
	@Override
	public Command getCommand(Request request) {
		if (request instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest req = (CreateConnectionViewAndElementRequest) request;
			EditPart target = req.getTargetEditPart();
			EditPart sourceConnection = req.getSourceEditPart();
			if (sourceConnection instanceof AbstractOutputConnectorEditPart) {
				EditPart source = sourceConnection.getParent();
				if (target instanceof AbstractInputConnectorEditPart) {
					EditPart parent = target.getParent();
					if(parent!=null){
/*						if (EditorUtils.hasCycle(source, parent)) {
							return UnexecutableCommand.INSTANCE;
						}*/
						/* please improve EditorUtils.isConnectableTarget */
						if(!EditorUtils.isConnectableTarget(source, parent)){
							return UnexecutableCommand.INSTANCE;
						}
					}
				} else if (target instanceof EditPart){
/*					if (EditorUtils.hasCycle(source, target)) {
						return UnexecutableCommand.INSTANCE;
					}*/
					/* please improve EditorUtils.isConnectableTarget */
					if(!EditorUtils.isConnectableTarget(source, target)){
						return UnexecutableCommand.INSTANCE;
					}
				}
			}
		}
		return super.getCommand(request);
	}

}
