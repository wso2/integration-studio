/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SequenceType;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;

public class SequenceMediatorExtFactory extends SequenceMediatorFactory {

	protected Mediator createSpecificMediator(OMElement omElement) {
		
		Mediator mediator = new SequenceMediator();

		OMAttribute e = omElement.getAttribute(ATT_ONERROR);
		OMAttribute n = omElement.getAttribute(ATT_NAME);

		if (e != null) {
			((SequenceMediator) mediator).setErrorHandler(e.getAttributeValue());
		}
		processAuditStatus(mediator, omElement);

		OMElement descElem = omElement.getFirstChildWithName(DESCRIPTION_Q);
		if (descElem != null) {
			((SequenceMediator) mediator).setDescription(descElem.getText());
		}
		addChildren(omElement, ((SequenceMediator) mediator), null);
		((SequenceMediator) mediator).setSequenceType(SequenceType.ANON);

		if (n != null) {
			((SequenceMediator) mediator).setName(n.getAttributeValue());

		} else {
			n = omElement.getAttribute(ATT_KEY);
			if (n != null) {
				ValueFactory keyFac = new ValueFactory();
				Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);
				((SequenceMediator) mediator).setKey(generatedKey);

			}
		}
		
		return mediator;
	}
}
