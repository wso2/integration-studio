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

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.HeaderMediatorFactory;
import org.apache.synapse.config.xml.OMElementUtils;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.transform.HeaderMediator;
import org.jaxen.JaxenException;

public class HeaderMediatorExtFactory extends HeaderMediatorFactory {
    
    private static HeaderMediatorExtFactory instance;
    
    private HeaderMediatorExtFactory() {
    }
    
    public static synchronized HeaderMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new HeaderMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        QName ATT_ACTION = new QName("action");
        QName ATT_SCOPE = new QName("scope");

        Mediator mediator = new HeaderMediator();

        OMAttribute name = omElement.getAttribute(ATT_NAME);
        OMAttribute value = omElement.getAttribute(ATT_VALUE);
        OMAttribute exprn = omElement.getAttribute(ATT_EXPRN);
        OMAttribute action = omElement.getAttribute(ATT_ACTION);
        OMAttribute scope = omElement.getAttribute(ATT_SCOPE);

        if (name != null && name.getAttributeValue() != null) {
            if (scope == null || scope.getAttributeValue().equals(XMLConfigConstants.SCOPE_DEFAULT)) {
                String nameAtt = name.getAttributeValue();
                int colonPos = nameAtt.indexOf(":");
                if (colonPos != -1) {
                    String prefix = nameAtt.substring(0, colonPos);
                    String namespaceURI = OMElementUtils.getNameSpaceWithPrefix(prefix, omElement);
                    if (namespaceURI != null) {
                        ((HeaderMediator) mediator)
                                .setQName(new QName(namespaceURI, nameAtt.substring(colonPos + 1), prefix));
                    }
                } else {
                    if (SynapseConstants.HEADER_TO.equals(nameAtt) || SynapseConstants.HEADER_FROM.equals(nameAtt)
                            || SynapseConstants.HEADER_ACTION.equals(nameAtt)
                            || SynapseConstants.HEADER_FAULT.equals(nameAtt)
                            || SynapseConstants.HEADER_REPLY_TO.equals(nameAtt)
                            || SynapseConstants.HEADER_RELATES_TO.equals(nameAtt)) {

                        ((HeaderMediator) mediator).setQName(new QName(nameAtt));
                    }
                }
            } else {
                ((HeaderMediator) mediator).setQName(new QName(name.getAttributeValue()));
            }
        }

        if (scope != null) {
            String valueStr = scope.getAttributeValue();
            ((HeaderMediator) mediator).setScope(valueStr);
        }

        processAuditStatus(mediator, omElement);

        if (action != null && "remove".equals(action.getAttributeValue())) {
            ((HeaderMediator) mediator).setAction(HeaderMediator.ACTION_REMOVE);
        }

        if (value != null && value.getAttributeValue() != null) {
            ((HeaderMediator) mediator).setValue(value.getAttributeValue());

        } else if (exprn != null && exprn.getAttributeValue() != null) {
            try {
                ((HeaderMediator) mediator).setExpression(SynapsePathFactory.getSynapsePath(omElement, ATT_EXPRN));
            } catch (JaxenException je) {
                // ignore
            }

        } else if (((HeaderMediator) mediator).isImplicit()) {
            Iterator i = omElement.getChildElements();
            if (i != null) {
                for (; i.hasNext();) {
                    ((HeaderMediator) mediator).addEmbeddedXml((OMElement) i.next());
                }
            }
        }
        addAllCommentChildrenToList(omElement, ((HeaderMediator) mediator).getCommentsList());

        return mediator;
    }

}
