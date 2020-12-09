/*
 * Copyright 2016 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.datamapper.diagram.edit.parts.custom;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.integrationstudio.datamapper.InNode;

public abstract class AbstractInNodeEditPart extends AbstractBorderItemEditPart{

	public AbstractInNodeEditPart(View view) {
		super(view);
	}
	
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getNotifier() instanceof Node) {
			if (((Node) notification.getNotifier()).getElement() instanceof InNode) {
				EditPart element = (EditPart) getViewer().getEditPartRegistry().get(
						notification.getNotifier());
				if (((AbstractInNodeEditPart) element).getTargetConnections().size() == 0) {
					if (((InNode) ((Node) notification.getNotifier()).getElement())
							.getIncomingLink().size() != 0) {
						Collection col = new ArrayList();
						col.add(((InNode) ((Node) notification.getNotifier()).getElement())
								.getIncomingLink().get(0));

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

}