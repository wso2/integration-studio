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

import java.util.Iterator;
import java.util.Properties;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.ClassMediatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.ClassMediatorExt;

public class ClassMediatorExtFactory extends ClassMediatorFactory {

	public Mediator createSpecificMediator(OMElement elem, Properties properties) {

		OMAttribute name = elem.getAttribute(ATT_NAME);
		if (name == null) {
			String msg = "The name of the actual mediator class is a required attribute";
			throw new SynapseException(msg);
		}

		ClassMediatorExt classMediator = new ClassMediatorExt(name.getAttributeValue());

		for (@SuppressWarnings("rawtypes")
		Iterator it = elem.getChildrenWithName(PROP_Q); it.hasNext();) {
			OMElement child = (OMElement) it.next();

			String propName = child.getAttribute(ATT_NAME).getAttributeValue();
			if (propName == null) {
				handleException("A Class mediator property must specify the name attribute");
			} else {
				if (child.getAttribute(ATT_VALUE) != null) {
					String value = child.getAttribute(ATT_VALUE).getAttributeValue();
					classMediator.addProperty(propName, value);
				} else {
					OMNode omElt = child.getFirstElement();
					if (omElt != null) {
						classMediator.addProperty(propName, omElt);
					} else {
						handleException("A Class mediator property must specify "
								+ "name and value attributes, or a name and a child XML fragment");
					}
				}
			}
		}

		processAuditStatus(classMediator, elem);

		return classMediator;
	}
}
