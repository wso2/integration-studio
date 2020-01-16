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

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.jaxen.JaxenException;
import org.wso2.carbon.mediator.transform.Input;
import org.wso2.carbon.mediator.transform.Output;
import org.wso2.carbon.mediator.transform.SmooksMediator;
import org.wso2.carbon.mediator.transform.xml.SmooksMediatorFactory;

public class SmooksMediatorExtFactory extends SmooksMediatorFactory {

    private static SmooksMediatorExtFactory instance;

    private SmooksMediatorExtFactory() {
    }

    public static synchronized SmooksMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new SmooksMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new SmooksMediator();

        QName CONFIG_KEY = new QName("config-key");
        QName PERSISTENCE_UNIT = new QName("persistence-unit");

        OMAttribute configFileAttr = omElement.getAttribute(CONFIG_KEY);

        if (configFileAttr != null) {
            ((SmooksMediator) mediator).setConfigKey(configFileAttr.getAttributeValue());
        }

        OMAttribute persistenceUnitAttr = omElement.getAttribute(PERSISTENCE_UNIT);
        if (persistenceUnitAttr != null) {
            ((SmooksMediator) mediator).setPersistenceUnitAttr(persistenceUnitAttr.getAttributeValue());
        }

        OMElement inputElement = omElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "input"));
        if (inputElement != null) {
            ((SmooksMediator) mediator).setInput(createInput(inputElement));
        } else {
            ((SmooksMediator) mediator).setInput(new Input());
        }

        OMElement outputElement = omElement
                .getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "output"));
        if (inputElement != null) {
            ((SmooksMediator) mediator).setOutput(createOutput(outputElement));
        } else {
            ((SmooksMediator) mediator).setOutput(new Output());
        }
        addAllCommentChildrenToList(omElement, ((SmooksMediator) mediator).getCommentsList());

        return mediator;
    }

    private Input createInput(OMElement input) {
        Input in = new Input();

        OMAttribute typeAttr = input.getAttribute(new QName("type"));
        String typeValue = "";
        if (typeAttr != null) {
            typeValue = typeAttr.getAttributeValue();
        }

        if (typeValue.equals("xml")) {
            in.setType(SmooksMediator.TYPES.XML);
        } else {
            in.setType(SmooksMediator.TYPES.TEXT);
        }

        if (input.getAttribute(new QName("expression")) != null) {
            try {
                in.setExpression(SynapseXPathFactory.getSynapseXPath(input, new QName("expression")));
            } catch (JaxenException e) {
                // ignore
            }
        }

        return in;
    }

    private Output createOutput(OMElement output) {
        Output in = new Output();

        OMAttribute typeAttr = output.getAttribute(new QName("type"));
        String typeValue = "";
        if (typeAttr != null) {
            typeValue = typeAttr.getAttributeValue();
        }

        if (typeValue.equals("xml")) {
            in.setType(SmooksMediator.TYPES.XML);
        } else if (typeValue.equals("java")) {
            in.setType(SmooksMediator.TYPES.JAVA);
        } else {
            in.setType(SmooksMediator.TYPES.TEXT);
        }

        if (output.getAttribute(new QName("expression")) != null) {
            try {
                in.setExpression(SynapseXPathFactory.getSynapseXPath(output, new QName("expression")));
            } catch (JaxenException e) {
                // ignore
            }
        }

        OMAttribute actionAttr = output.getAttribute(new QName("action"));
        if (actionAttr != null && actionAttr.getAttributeValue() != null) {
            in.setAction(actionAttr.getAttributeValue());
        }

        OMAttribute propertyAttr = output.getAttribute(new QName("property"));
        if (propertyAttr != null && propertyAttr.getAttributeValue() != null) {
            in.setProperty(propertyAttr.getAttributeValue());
        }

        return in;
    }

}
