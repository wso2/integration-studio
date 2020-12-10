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

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.ForEachMediatorFactory;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.CallMediator;
import org.apache.synapse.mediators.builtin.CalloutMediator;
import org.apache.synapse.mediators.builtin.ForEachMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.jaxen.JaxenException;

public class ForEachMediatorExtFactory extends ForEachMediatorFactory {

    private static final QName ID_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "id");
    
    private static ForEachMediatorExtFactory instance;
    
    private ForEachMediatorExtFactory() {
    }
    
    public static synchronized ForEachMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new ForEachMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        ForEachMediator mediator = new ForEachMediator();
        processAuditStatus(mediator, omElement);

        OMAttribute id = omElement.getAttribute(ID_Q);
        if (id != null) {
            mediator.setId(id.getAttributeValue());
        }

        OMAttribute expression = omElement.getAttribute(ATT_EXPRN);
        if (expression != null) {
            try {
                mediator.setExpression(SynapsePathFactory.getSynapsePath(omElement, ATT_EXPRN));
            } catch (JaxenException e) {
                // ignore
            }
        }

        OMAttribute sequenceAttr = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "sequence"));
        OMElement sequence;

        if (sequenceAttr != null && sequenceAttr.getAttributeValue() != null) {
            mediator.setSequenceRef(sequenceAttr.getAttributeValue());

        } else if ((sequence = omElement
                .getFirstChildWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "sequence"))) != null) {
            SequenceMediatorExtFactory fac = SequenceMediatorExtFactory.getInstance();
            SequenceMediator sequenceMediator = fac.createAnonymousSequence(sequence, null);

            if (validateSequence(sequenceMediator)) {
                mediator.setSequence(sequenceMediator);
            }
        }
        addAllCommentChildrenToList(omElement, mediator.getCommentsList());

        return mediator;
    }

    private boolean validateSequence(SequenceMediator sequence) {
        if (sequence != null) {
            List<Mediator> mediators = sequence.getList();
            for (Mediator m : mediators) {
                if (m instanceof CallMediator || m instanceof CalloutMediator || m instanceof SendMediator) {
                    return false;
                }
            }
        }
        return true;
    }

}
