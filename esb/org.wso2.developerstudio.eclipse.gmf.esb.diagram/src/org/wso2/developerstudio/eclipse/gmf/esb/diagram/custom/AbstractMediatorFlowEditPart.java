/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;

public abstract class AbstractMediatorFlowEditPart extends ShapeNodeEditPart {

	public AbstractMediatorFlowEditPart(View view) {
		super(view);
	}

	/**
	 * This method will return the associated output connector for the
	 * MediatorFlow Eg: 1.Filter mediator fail MediatorFlow should return
	 * FilterMediatorFailOutputConnector 2.Aggregate mediator on complete
	 * MediatorFlow should return AggregateMediatorOnCompleteOutputConnector
	 * etc.
	 * 
	 * @return OutputConnector
	 */
	public abstract AbstractOutputConnectorEditPart getAssociatedOutputConnector();

	/**
	 * This method will return the relevant output connector for a particular
	 * mediatorFlow when we have variable for mediator flow count in a mediator.
	 * Eg: Switch, Clone mediators
	 * 
	 * @param ContainerEditPart
	 * @param complexFiguredAbstractMediator
	 * @return
	 */
	protected AdditionalOutputConnector getAddtionalOutputConnector(ShapeNodeEditPart ContainerEditPart,
			complexFiguredAbstractMediator complexFiguredAbstractMediator) {
		List<AdditionalOutputConnector> targetOutputConnectorList = new ArrayList<AdditionalOutputConnector>();
		List<EditPart> children = complexFiguredAbstractMediator.getChildren();
		List<EditPart> targetlist = ContainerEditPart.getChildren();
		int targetIndex = 0;
		for (int x = 0; x < targetlist.size(); ++x) {
			if (targetlist.get(x).equals(this.getParent())) {
				targetIndex = x;
			}
		}
		for (int i = 0; i < children.size(); ++i) {
			if (children.get(i) instanceof AdditionalOutputConnector) {
				// Include all the target output connectors to a list
				AdditionalOutputConnector cloneMediatorTargetOutputConnectorEditPart = (AdditionalOutputConnector) children
						.get(i);
				targetOutputConnectorList.add(cloneMediatorTargetOutputConnectorEditPart);
			}
		}
		// Gets the relevant target output connector which matches with the
		// target container
		AdditionalOutputConnector relevantTargetOutputConnector = targetOutputConnectorList.get(targetIndex);
		return relevantTargetOutputConnector;
	}

}
