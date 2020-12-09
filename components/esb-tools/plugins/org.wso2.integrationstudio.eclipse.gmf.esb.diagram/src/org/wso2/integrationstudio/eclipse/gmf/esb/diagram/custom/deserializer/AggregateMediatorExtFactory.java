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
import org.apache.synapse.config.xml.AggregateMediatorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.DropMediator;
import org.apache.synapse.mediators.eip.aggregator.AggregateMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;

/**
 * This class is use to create a Aggregate mediator synapse object by 
 * skipping the synapse validations.
 * This is useful when building the synapse model from the source to the diagram.
 * (by skipping the exceptions if certain properties are empty by default)
 */
public class AggregateMediatorExtFactory extends AggregateMediatorFactory {
    
    private static AggregateMediatorExtFactory instance;
    
    private AggregateMediatorExtFactory() {
    }

    public static synchronized AggregateMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new AggregateMediatorExtFactory();
        }
        return instance;
    }
    
    protected Mediator createSpecificMediator(OMElement omElement) {
        Mediator mediator = new AggregateMediator();

        QName CORELATE_ON_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "correlateOn");
        QName COMPLETE_CONDITION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "completeCondition");
        QName MESSAGE_COUNT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "messageCount");
        QName ON_COMPLETE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "onComplete");

        QName EXPRESSION_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "expression");
        QName TIMEOUT_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "timeout");
        QName MIN_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "min");
        QName MAX_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "max");
        QName SEQUENCE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "sequence");
        QName ID_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "id");
        QName ENCLOSING_ELEMENT_PROPERTY = new QName(XMLConfigConstants.NULL_NAMESPACE, "enclosingElementProperty");

        processAuditStatus(mediator, omElement);

        OMAttribute id = omElement.getAttribute(ID_Q);
        if (id != null) {
            ((AggregateMediator) mediator).setId(id.getAttributeValue());
        }

        OMElement corelateOn = omElement.getFirstChildWithName(CORELATE_ON_Q);
        if (corelateOn != null) {
            OMAttribute corelateExpr = corelateOn.getAttribute(EXPRESSION_Q);
            if (corelateExpr != null) {
                try {
                    ((AggregateMediator) mediator)
                            .setCorrelateExpression(SynapseXPathFactory.getSynapseXPath(corelateOn, EXPRESSION_Q));
                } catch (JaxenException e) {
                    // If the xPath is not a valid synapse xpath this will add the invalid xpath to the model.
                    // This is useful when we use this extended class for create dummy synapse mediators with
                    // empty string properties for create model class objects for generating the design view
                    ((AggregateMediator) mediator).setCorrelateExpression(SynapseXPathExt
                            .createSynapsePath(corelateOn.getAttribute(EXPRESSION_Q).getAttributeValue()));                  
                }
            }
        }

        OMElement completeCond = omElement.getFirstChildWithName(COMPLETE_CONDITION_Q);
        if (completeCond != null) {
            OMAttribute completeTimeout = completeCond.getAttribute(TIMEOUT_Q);
            if (completeTimeout != null) {
                ((AggregateMediator) mediator)
                        .setCompletionTimeoutMillis(Long.parseLong(completeTimeout.getAttributeValue()) * 1000);
            }

            OMElement messageCount = completeCond.getFirstChildWithName(MESSAGE_COUNT_Q);
            if (messageCount != null) {
                OMAttribute min = messageCount.getAttribute(MIN_Q);
                if (min != null) {
                    ((AggregateMediator) mediator)
                            .setMinMessagesToComplete(new ValueFactoryExtended().createValue("min", messageCount));
                }

                OMAttribute max = messageCount.getAttribute(MAX_Q);
                if (max != null) {
                    ((AggregateMediator) mediator)
                            .setMaxMessagesToComplete(new ValueFactoryExtended().createValue("max", messageCount));
                }
            }
        }

        OMElement onComplete = omElement.getFirstChildWithName(ON_COMPLETE_Q);
        if (onComplete != null) {

            OMAttribute aggregateExpr = onComplete.getAttribute(EXPRESSION_Q);
            if (aggregateExpr != null) {
                try {
                    ((AggregateMediator) mediator)
                            .setAggregationExpression(SynapseXPathFactory.getSynapseXPath(onComplete, EXPRESSION_Q));
                } catch (JaxenException e) {
                    // If the xPath is not a valid synapse xpath this will add the invalid xpath to the model.
                    // This is useful when we use this extended class for create dummy synapse mediators with
                    // empty string properties for create model class objects for generating the design view
                    ((AggregateMediator) mediator).setAggregationExpression(SynapseXPathExt
                            .createSynapsePath(onComplete.getAttribute(EXPRESSION_Q).getAttributeValue()));
                }
            }

            OMAttribute enclosingElementPropertyName = onComplete.getAttribute(ENCLOSING_ELEMENT_PROPERTY);
            if (enclosingElementPropertyName != null) {
                ((AggregateMediator) mediator)
                        .setEnclosingElementPropertyName(enclosingElementPropertyName.getAttributeValue());
            }

            OMAttribute onCompleteSequence = onComplete.getAttribute(SEQUENCE_Q);
            if (onCompleteSequence != null) {
                ((AggregateMediator) mediator).setOnCompleteSequenceRef(onCompleteSequence.getAttributeValue());
            } else if (onComplete.getFirstElement() != null) {
                ((AggregateMediator) mediator).setOnCompleteSequence(
                        (new SequenceMediatorFactory()).createAnonymousSequence(onComplete, null));
            } else {
                SequenceMediator sequence = new SequenceMediator();
                sequence.addChild(new DropMediator());
                ((AggregateMediator) mediator).setOnCompleteSequence(sequence);
            }
        }

        addAllCommentChildrenToList(omElement, ((AggregateMediator) mediator).getCommentsList());

        return mediator;
    }

}
