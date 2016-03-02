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

import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.bean.BeanConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.BeanMediatorExt;
import static org.apache.synapse.mediators.bean.BeanMediator.*;

public class BeanMediatorExtFactory extends AbstractMediatorFactory {

	private static final QName BEAN_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "bean");

	public Mediator createSpecificMediator(OMElement elem, Properties properties) {

		BeanMediatorExt mediator = new BeanMediatorExt();

		String attributeValue;

		attributeValue = elem.getAttributeValue(new QName(BeanConstants.VAR));
		if (attributeValue != null) {
			mediator.setVarName(attributeValue);
		} else {
			handleException("'var' attribute of Bean mediator is required.");
		}

		attributeValue = elem.getAttributeValue(new QName(BeanConstants.ACTION));
		if (attributeValue != null) {
			try {
				switch (Action.valueOf(attributeValue.toUpperCase())) {
				case CREATE:
					populateCreateBeanCase(mediator, elem);
					break;
				case REMOVE:
					mediator.setAction(Action.REMOVE);
					break;
				case SET_PROPERTY:
					populateSetPropertyCase(mediator, elem);
					break;
				case GET_PROPERTY:
					populateGetPropertyCase(mediator, elem);
					break;
				default:
					assert false;
				}
			} catch (IllegalArgumentException e) {
				handleException("'action' attribute of bean mediator must be set to 'CREATE', "
						+ "'REMOVE', 'SET_PROPERTY' or 'GET_PROPERTY'.");
			}
		} else {
			handleException("'action' attribute of Bean mediator is required.");
		}

		return mediator;
	}

	private void populateCreateBeanCase(BeanMediatorExt mediator, OMElement elem) {

		mediator.setAction(Action.CREATE);

		String attributeValue;

		attributeValue = elem.getAttributeValue(new QName(BeanConstants.CLASS));
		if (attributeValue != null) {
			mediator.setClassName(attributeValue.trim());
		} else {
			handleException("'class' attribute of Bean mediator is required when 'CREATE' action "
					+ "is set.");
		}

		attributeValue = elem.getAttributeValue(new QName(BeanConstants.REPLACE));
		if (attributeValue != null) {
			mediator.setReplace(Boolean.parseBoolean(attributeValue.trim()));
		}

	}

	private void populateSetPropertyCase(BeanMediatorExt mediator, OMElement elem) {

		mediator.setAction(Action.SET_PROPERTY);

		populatePropertyName(mediator, elem);

		if (elem.getAttributeValue(ATT_VALUE) != null) {
			mediator.setValue(new ValueFactory().createValue(BeanConstants.VALUE, elem));
		} else {
			handleException("'value' attribute of Bean mediator is required when 'SET_PROPERTY' "
					+ "action is set.");
		}
	}

	private void populateGetPropertyCase(BeanMediatorExt mediator, OMElement elem) {

		mediator.setAction(Action.GET_PROPERTY);

		populatePropertyName(mediator, elem);

		if (elem.getAttributeValue(new QName(BeanConstants.TARGET)) != null) {
			mediator.setTargetValue(new ValueFactory().createValue(BeanConstants.TARGET, elem));
		} else {
			handleException("'target' attribute of Bean mediator is required when 'GET_PROPERTY' "
					+ "action is set.");
		}
	}

	private void populatePropertyName(BeanMediatorExt mediator, OMElement elem) {

		String attributeValue;

		attributeValue = elem.getAttributeValue(new QName(BeanConstants.PROPERTY));
		if (attributeValue != null) {
			mediator.setPropertyName(attributeValue);
		} else {
			handleException("'property' attribute of Bean mediator is required when "
					+ "SET/GET_PROPERTY action is set.");
		}
	}

	public QName getTagQName() {
		return BEAN_Q;
	}

}
