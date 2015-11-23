/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class ConnectionUtils {

	public static boolean createConnection(AbstractConnectorEditPart target, AbstractConnectorEditPart source) {
		if (source != null && target != null && (source.getParent() instanceof ShapeNodeEditPart)) {
			CompoundCommand cc = new CompoundCommand("Create Link");
			if (((ShapeNodeEditPart) source.getParent()).getRoot() != null) {
				ICommand createSubTopicsCmd = new DeferredCreateConnectionViewAndElementCommand(
						new CreateConnectionViewAndElementRequest(EsbElementTypes.EsbLink_4001,
								((IHintedType) EsbElementTypes.EsbLink_4001).getSemanticHint(),
								((ShapeNodeEditPart) source.getParent()).getDiagramPreferencesHint()),
						new EObjectAdapter((EObject) source.getModel()),
						new EObjectAdapter((EObject) target.getModel()),
						((ShapeNodeEditPart) source.getParent()).getViewer());

				cc.add(new ICommandProxy(createSubTopicsCmd));
				if (target.getDiagramEditDomain() != null) {
					target.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
					return true;
				}
			}
		}
		return false;
	}
}
