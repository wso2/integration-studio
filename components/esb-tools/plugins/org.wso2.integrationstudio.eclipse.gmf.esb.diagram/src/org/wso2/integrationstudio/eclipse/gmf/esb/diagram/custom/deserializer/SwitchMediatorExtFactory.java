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
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AnonymousListMediatorFactory;
import org.apache.synapse.config.xml.SwitchCase;
import org.apache.synapse.config.xml.SwitchMediatorFactory;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.filters.SwitchMediator;
import org.jaxen.JaxenException;

public class SwitchMediatorExtFactory extends SwitchMediatorFactory {
    
    private static SwitchMediatorExtFactory instance;
    
    private SwitchMediatorExtFactory() {
    }
    
    public static synchronized SwitchMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new SwitchMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new SwitchMediator();

        QName CASE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "case");
        QName DEFAULT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "default");

        OMAttribute source = omElement.getAttribute(ATT_SOURCE);
        if (source != null) {
            try {
                ((SwitchMediator) mediator).setSource(SynapsePathFactory.getSynapsePath(omElement, ATT_SOURCE));

            } catch (JaxenException e) {
                // ignore
            }
        }

        processAuditStatus(mediator, omElement);
        Iterator iter = omElement.getChildrenWithName(CASE_Q);
        while (iter.hasNext()) {
            OMElement caseElem = (OMElement) iter.next();
            SwitchCase aCase = new SwitchCase();
            OMAttribute regex = caseElem.getAttribute(ATT_REGEX);
            if (regex != null) {

                try {
                    aCase.setRegex(Pattern.compile(regex.getAttributeValue()));
                } catch (PatternSyntaxException pse) {
                    // ignore
                }
            }
            aCase.setCaseMediator(AnonymousListMediatorFactory.createAnonymousListMediator(caseElem, null));
            ((SwitchMediator) mediator).addCase(aCase);
        }

        iter = omElement.getChildrenWithName(DEFAULT_Q);
        while (iter.hasNext()) {
            SwitchCase aCase = new SwitchCase();
            aCase.setCaseMediator(
                    AnonymousListMediatorFactory.createAnonymousListMediator((OMElement) iter.next(), null));
            ((SwitchMediator) mediator).setDefaultCase(aCase);
            break;
        }
        addAllCommentChildrenToList(omElement, ((SwitchMediator) mediator).getCommentsList());

        return mediator;

    }

}
