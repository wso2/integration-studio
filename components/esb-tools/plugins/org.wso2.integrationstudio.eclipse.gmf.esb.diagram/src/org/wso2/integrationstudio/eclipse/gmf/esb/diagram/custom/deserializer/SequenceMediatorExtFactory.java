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

import java.util.Iterator;
import java.util.Properties;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMComment;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.synapse.Mediator;
import org.apache.synapse.SequenceType;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.CommentMediator;

public class SequenceMediatorExtFactory extends SequenceMediatorFactory {
    
    private static SequenceMediatorExtFactory instance;
    
    private SequenceMediatorExtFactory() {
    }
    
    public static synchronized SequenceMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new SequenceMediatorExtFactory();
        }
        return instance;
    }

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
                ValueFactoryExtended keyFac = new ValueFactoryExtended();
                Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);
                ((SequenceMediator) mediator).setKey(generatedKey);

            }
        }
        addAllCommentChildrenToList(omElement, ((SequenceMediator) mediator).getCommentsList());

        return mediator;
    }
    
    public SequenceMediator createAnonymousSequence(OMElement elem, Properties properties) {
        SequenceMediator seqMediator = new SequenceMediator();
        OMAttribute e = elem.getAttribute(ATT_ONERROR);
        if (e != null) {
            seqMediator.setErrorHandler(e.getAttributeValue());
        }
        processAuditStatus(seqMediator, elem);
        OMElement descElem = elem.getFirstChildWithName(DESCRIPTION_Q);
        if (descElem != null) {
            seqMediator.setDescription(descElem.getText());
        }
        addChildren(elem, seqMediator, properties);
        seqMediator.setSequenceType(SequenceType.ANON);
        return seqMediator;
    }
    
    protected static void addChildren(OMElement el, ListMediator m, Properties properties) {
        Iterator it = el.getChildren();

        while (it.hasNext()) {
            OMNode child = (OMNode) it.next();
            if (child instanceof OMElement) {
                if (!DESCRIPTION_Q.equals(((OMElement) child).getQName())) { // neglect the description tag
                    Mediator med = DummyMediatorFactoryFinder.getInstance().getMediator((OMElement) child, properties);
                    if (med != null) {
                        m.addChild(med);
                    } else {
                        String msg = "Unknown mediator : " + ((OMElement) child).getLocalName();
                        throw new SynapseException(msg);
                    }
                }
            } else if (child instanceof OMComment) {
                CommentMediator commendMediator = new CommentMediator();
                commendMediator.setCommentText(((OMComment) child).getValue());
                m.addChild(commendMediator);
            }
        }
    }
}
