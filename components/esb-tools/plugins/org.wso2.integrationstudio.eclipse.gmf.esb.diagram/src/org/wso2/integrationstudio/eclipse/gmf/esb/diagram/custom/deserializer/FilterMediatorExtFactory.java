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

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.AnonymousListMediator;
import org.apache.synapse.config.xml.AnonymousListMediatorFactory;
import org.apache.synapse.config.xml.FilterMediatorFactory;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.mediators.filters.FilterMediator;
import org.jaxen.JaxenException;

public class FilterMediatorExtFactory extends FilterMediatorFactory {
    
    private static FilterMediatorExtFactory instance;
    
    private FilterMediatorExtFactory() {
    }
    
    public static synchronized FilterMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new FilterMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new FilterMediator();

        QName THEN_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "then");
        QName ELSE_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "else");

        OMAttribute attXpath = omElement.getAttribute(ATT_XPATH);
        OMAttribute attSource = omElement.getAttribute(ATT_SOURCE);
        OMAttribute attRegex = omElement.getAttribute(ATT_REGEX);

        if (attXpath != null) {
            if (attXpath.getAttributeValue() != null && attXpath.getAttributeValue().trim().length() > 0) {
                try {
                    ((FilterMediator) mediator).setXpath(SynapsePathFactory.getSynapsePath(omElement, ATT_XPATH));
                } catch (JaxenException e) {
                    // ignore
                }
            }

        } else if (attSource != null && attRegex != null) {

            if ((attSource.getAttributeValue() != null && attSource.getAttributeValue().trim().length() > 0)
                    || (attRegex.getAttributeValue() != null && attRegex.getAttributeValue().trim().length() > 0)) {

                try {
                    ((FilterMediator) mediator).setSource(SynapsePathFactory.getSynapsePath(omElement, ATT_SOURCE));
                } catch (JaxenException e) {
                    // ignore
                }

                try {
                    ((FilterMediator) mediator).setRegex(Pattern.compile(attRegex.getAttributeValue()));
                } catch (PatternSyntaxException pse) {
                    // ignore
                }
            }

        }

        processAuditStatus(mediator, omElement);

        OMElement thenElem = omElement.getFirstChildWithName(THEN_Q);

        if (thenElem != null) {

            ((FilterMediator) mediator).setThenElementPresent(true);
            OMAttribute sequenceAttr = thenElem.getAttribute(ATT_SEQUENCE);

            if (sequenceAttr != null && sequenceAttr.getAttributeValue() != null) {
                ((FilterMediator) mediator).setThenKey(sequenceAttr.getAttributeValue());

            } else {
                addChildren(thenElem, (FilterMediator) mediator, null);
            }

            OMElement elseElem = omElement.getFirstChildWithName(ELSE_Q);
            if (elseElem != null) {

                sequenceAttr = elseElem.getAttribute(ATT_SEQUENCE);
                if (sequenceAttr != null && sequenceAttr.getAttributeValue() != null) {
                    ((FilterMediator) mediator).setElseKey(sequenceAttr.getAttributeValue());

                } else {
                    AnonymousListMediator listMediator = AnonymousListMediatorFactory
                            .createAnonymousListMediator(elseElem, null);
                    ((FilterMediator) mediator).setElseMediator(listMediator);
                }
            }

        } else {

            ((FilterMediator) mediator).setThenElementPresent(false);
            addChildren(omElement, (FilterMediator) mediator, null);
        }
        addAllCommentChildrenToList(omElement, ((FilterMediator) mediator).getCommentsList());
        
        return mediator;
    }

}
