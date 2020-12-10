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

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.mediators.Value;
import org.jaxen.JaxenException;
import org.wso2.carbon.mediator.event.EventMediator;
import org.wso2.carbon.mediator.event.xml.EventMediatorFactory;

public class EventMediatorExtFactory extends EventMediatorFactory {
    
    private static EventMediatorExtFactory instance;
    
    private EventMediatorExtFactory() {
    }
    
    public static synchronized EventMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new EventMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new EventMediator();
        OMAttribute topicAttr = omElement.getAttribute(new QName("topic"));
        if (topicAttr != null) {
            ValueFactory vf = new ValueFactory();
            Value value = vf.createValue("topic", omElement);

            ((EventMediator) mediator).setTopic(value);
        }

        OMAttribute expression = omElement.getAttribute(new QName("expression"));
        if (expression != null) {
            try {
                ((EventMediator) mediator)
                        .setExpression(SynapseXPathFactory.getSynapseXPath(omElement, new QName("expression")));
            } catch (JaxenException e) {
                // ignore
            }
        }
        addAllCommentChildrenToList(omElement, ((EventMediator) mediator).getCommentsList());

        return mediator;
    }

}
