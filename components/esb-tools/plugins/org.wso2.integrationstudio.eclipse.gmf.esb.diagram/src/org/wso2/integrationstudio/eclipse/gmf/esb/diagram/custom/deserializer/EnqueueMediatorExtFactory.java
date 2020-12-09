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
import org.apache.synapse.config.xml.EnqueueMediatorFactory;
import org.apache.synapse.mediators.builtin.EnqueueMediator;

public class EnqueueMediatorExtFactory extends EnqueueMediatorFactory {
    
    private static EnqueueMediatorExtFactory instance;
    
    private EnqueueMediatorExtFactory() {
    }
    
    public static synchronized EnqueueMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new EnqueueMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new EnqueueMediator();

        QName SEQUENCE_ATT = new QName("sequence");
        QName PRIORITY_ATT = new QName("priority");
        QName QUEUE_ATT = new QName("executor");

        processAuditStatus(mediator, omElement);

        OMAttribute seqAtt = omElement.getAttribute(SEQUENCE_ATT);
        if (seqAtt != null && !"".equals(seqAtt.getAttributeValue())) {
            ((EnqueueMediator) mediator).setSequenceName(seqAtt.getAttributeValue());
        }

        OMAttribute priorityAtt = omElement.getAttribute(PRIORITY_ATT);
        if (priorityAtt != null && !"".equals(priorityAtt.getAttributeValue())) {
            ((EnqueueMediator) mediator).setPriority(Integer.parseInt(priorityAtt.getAttributeValue()));
        }

        OMAttribute queueAtt = omElement.getAttribute(QUEUE_ATT);
        if (queueAtt != null && !"".equals(queueAtt.getAttributeValue())) {
            ((EnqueueMediator) mediator).setExecutorName(queueAtt.getAttributeValue());
        }
        addAllCommentChildrenToList(omElement, ((EnqueueMediator) mediator).getCommentsList());

        return mediator;

    }

}
