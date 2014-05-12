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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.BeanMediatorSerializer;
import org.apache.synapse.config.xml.ValueSerializer;
import org.apache.synapse.mediators.bean.BeanConstants;
import org.apache.synapse.mediators.bean.BeanMediator;

public class BeanMediatorExtSerializer extends BeanMediatorSerializer {
	

    private static final String BEAN = "bean";

    public OMElement serializeSpecificMediator(Mediator m) {

        if (!(m instanceof BeanMediatorExt)) {
            handleException("Unsupported mediator was passed in for serialization: " + m.getType());
            return null;
        }

        BeanMediatorExt mediator = (BeanMediatorExt) m;

		OMElement mediatorElem = fac.createOMElement(BEAN, synNS);
		saveTracingState(mediatorElem, mediator);

		if (null != mediator.getAction()) { // Never becomes empty
			mediatorElem.addAttribute(fac.createOMAttribute(BeanConstants.ACTION, nullNS, mediator
					.getAction().toString()));
		} else {
			handleException();
		}

		if (StringUtils.isNotBlank(mediator.getVarName())) {
			mediatorElem.addAttribute(fac.createOMAttribute(BeanConstants.VAR, nullNS,
					mediator.getVarName()));
		} else {
			handleException();
		}

        switch (mediator.getAction()) {
            case CREATE:
                serializeCreateBeanCase(mediatorElem, mediator);
                break;
            case SET_PROPERTY:
                serializeSetPropertyCase(mediatorElem, mediator);
                break;
            case GET_PROPERTY:
                serializeGetPropertyCase(mediatorElem, mediator);
                break;
            default:
                assert false;
        }

        return mediatorElem;
    }

    private void serializeCreateBeanCase(OMElement mediatorElem, BeanMediatorExt mediator) {

		if (StringUtils.isNotBlank(mediator.getClassName())) {
			mediatorElem.addAttribute(fac.createOMAttribute(BeanConstants.CLASS, nullNS,
					mediator.getClassName()));
        } else {
            handleException();
        }

        if (!mediator.isReplace()) {
            mediatorElem.addAttribute(fac.createOMAttribute(
                    BeanConstants.REPLACE, nullNS, Boolean.toString(false)));
        }
    }

    private void serializeSetPropertyCase(OMElement mediatorElem, BeanMediatorExt mediator) {

		serializePropertyName(mediatorElem, mediator);

		if (null != mediator.getValue()) {
			// Check either value literal or expression is not null and not
			// empty
			if (StringUtils.isNotBlank(mediator.getValue().getKeyValue())
					|| StringUtils.isNotBlank(mediator.getValue().getExpression().getExpression())) {
				new ValueSerializer().serializeValue(mediator.getValue(), BeanConstants.VALUE,
						mediatorElem);
			}
			
        } else {
            handleException();
        }
    }

    private void serializeGetPropertyCase(OMElement mediatorElem, BeanMediatorExt mediator) {

        serializePropertyName(mediatorElem, mediator);

		if (null != mediator.getTargetValue()) {
			// Check either value literal or expression is not null and not
			// empty
			if (StringUtils.isNotBlank(mediator.getTargetValue().getKeyValue())
					|| StringUtils.isNotBlank(mediator.getTargetValue().getExpression()
							.getExpression())) {
				new ValueSerializer().serializeValue(mediator.getTargetValue(),
						BeanConstants.TARGET, mediatorElem);
			}
        	 
        } else {
            handleException();
        }
    }

    private void serializePropertyName(OMElement mediatorElem, BeanMediator mediator) {

		if (StringUtils.isNotBlank(mediator.getPropertyName())) {
            mediatorElem.addAttribute(fac.createOMAttribute(
                    BeanConstants.PROPERTY, nullNS, mediator.getPropertyName()));
        } else {
            handleException();
        }
    }

    public String getMediatorClassName() {
        return BeanMediatorExt.class.getName();
    }

    private void handleException() {
        handleException("Invalid bean mediator was passed in for serialization");
    }

}
