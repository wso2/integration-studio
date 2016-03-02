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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediatorConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class FilterMediatorDeserializer extends
		AbstractEsbNodeDeserializer<AbstractMediator, FilterMediator> {

	@Override
	public FilterMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {

		Assert.isTrue(
				mediator instanceof org.apache.synapse.mediators.filters.FilterMediator,
				"Unsupported mediator passed in for deserialization at "+ this.getClass());

		org.apache.synapse.mediators.filters.FilterMediator filterMediator = (org.apache.synapse.mediators.filters.FilterMediator) mediator;

		FilterMediator visualFilter = (FilterMediator) DeserializerUtils.createNode(part, EsbElementTypes.FilterMediator_3494) ;
		setElementToEdit(visualFilter);
		setCommonProperties(filterMediator, visualFilter);
		refreshEditPartMap();

		if (filterMediator.getSource() != null && filterMediator.getRegex() != null) {
			//Setting type
			executeSetValueCommand(FILTER_MEDIATOR__CONDITION_TYPE, FilterMediatorConditionType.SOURCE_REGEX);
			// Setting source
			if(filterMediator.getSource()!=null){
				executeSetValueCommand(FILTER_MEDIATOR__SOURCE, createNamespacedProperty(filterMediator.getSource()));
			}
			// Setting regex
			if (filterMediator.getRegex() != null
					&& DeserializerUtils.isValidRegex(filterMediator.getRegex()
							.toString())) {
				executeSetValueCommand(FILTER_MEDIATOR__REGEX, filterMediator.getRegex().toString());
			}

		} else if (filterMediator.getXpath() != null) {
			//Setting type
			executeSetValueCommand(FILTER_MEDIATOR__CONDITION_TYPE, FilterMediatorConditionType.XPATH);
			//Setting XPath
			if(filterMediator.getXpath()!=null){
				executeSetValueCommand(FILTER_MEDIATOR__XPATH, createNamespacedProperty(filterMediator.getXpath()));
			}
		}
		if (filterMediator.getElseMediator() != null) {
			/* deserialize <else> flow */
			SequenceMediator sequence = new SequenceMediator();
			sequence.addAll(filterMediator.getElseMediator().getList());
			IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(
					visualFilter.getFilterContainer().getFailContainer().getMediatorFlow())
					.getChildren().get(0);
			deserializeSequence(compartment, sequence,
					visualFilter.getFailOutputConnector());
		}


		if (filterMediator.getList().size() > 0) {
			/* deserialize <if> flow */
			SequenceMediator sequence = new SequenceMediator();
			sequence.addAll(filterMediator.getList());
			IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(
					visualFilter.getFilterContainer().getPassContainer().getMediatorFlow())
					.getChildren().get(0);
			deserializeSequence(compartment, sequence,
					visualFilter.getPassOutputConnector());
		}

	
		return visualFilter;

	}

}
