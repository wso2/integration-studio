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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.FaultMediatorFactory;
import org.apache.synapse.config.xml.OMElementUtils;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.transform.FaultMediator;
import org.jaxen.JaxenException;

public class MakefaultMediatorExtFactory extends FaultMediatorFactory {
    
    private static MakefaultMediatorExtFactory instance;
    
    private MakefaultMediatorExtFactory() {
    }
    
    public static synchronized MakefaultMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new MakefaultMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new FaultMediator();

        QName ATT_VERSION_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "version");
        QName ATT_RESPONSE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "response");
        QName CODE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "code");
        QName REASON_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "reason");
        QName NODE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "node");
        QName ROLE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "role");
        QName DETAIL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "detail");

        String SOAP11 = "soap11";
        String SOAP12 = "soap12";
        String POX = "pox";

        OMAttribute version = omElement.getAttribute(ATT_VERSION_Q);
        if (version != null) {
            if (SOAP11.equals(version.getAttributeValue())) {
                ((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP11);
            } else if (SOAP12.equals(version.getAttributeValue())) {
                ((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP12);
            } else if (POX.equals(version.getAttributeValue())) {
                ((FaultMediator) mediator).setSoapVersion(FaultMediator.POX);
            } else {
                ((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP11);
            }
        } else {

            ((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP11);
        }

        OMAttribute response = omElement.getAttribute(ATT_RESPONSE_Q);
        if (response != null) {
            if ("true".equals(response.getAttributeValue())) {
                ((FaultMediator) mediator).setMarkAsResponse(true);
            } else {
                ((FaultMediator) mediator).setMarkAsResponse(false);
            }
            ((FaultMediator) mediator).setSerializeResponse(true);
        }

        OMElement code = omElement.getFirstChildWithName(CODE_Q);
        if (code != null) {
            OMAttribute value = code.getAttribute(ATT_VALUE);
            OMAttribute expression = code.getAttribute(ATT_EXPRN);

            if (value != null) {
                String strValue = value.getAttributeValue();
                String prefix = null;
                String name = null;
                if (strValue.indexOf(":") != -1) {
                    prefix = strValue.substring(0, strValue.indexOf(":"));
                    name = strValue.substring(strValue.indexOf(":") + 1);
                }
                String namespaceURI = OMElementUtils.getNameSpaceWithPrefix(prefix, code);
                if (namespaceURI != null) {
                    ((FaultMediator) mediator).setFaultCodeValue(new QName(namespaceURI, name, prefix));
                }

            } else if (expression != null) {
                try {
                    ((FaultMediator) mediator).setFaultCodeExpr(SynapseXPathFactory.getSynapseXPath(code, ATT_EXPRN));
                } catch (JaxenException je) {
                    // ignore
                }
            }

        }

        OMElement reason = omElement.getFirstChildWithName(REASON_Q);
        if (reason != null) {
            OMAttribute value = reason.getAttribute(ATT_VALUE);
            OMAttribute expression = reason.getAttribute(ATT_EXPRN);

            if (value != null) {
                ((FaultMediator) mediator).setFaultReasonValue(value.getAttributeValue());
            } else if (expression != null) {
                try {
                    ((FaultMediator) mediator)
                            .setFaultReasonExpr(SynapseXPathFactory.getSynapseXPath(reason, ATT_EXPRN));
                } catch (JaxenException je) {
                    // ignore
                }
            }

        }
        processAuditStatus(mediator, omElement);

        OMElement node = omElement.getFirstChildWithName(NODE_Q);
        if (node != null && node.getText() != null && !SOAP11.equals(version.getAttributeValue())) {
            try {
                ((FaultMediator) mediator).setFaultNode(new URI(node.getText()));
            } catch (URISyntaxException e) {
                // ignore
            }
        }

        OMElement role = omElement.getFirstChildWithName(ROLE_Q);
        if (role != null && role.getText() != null) {
            try {
                ((FaultMediator) mediator).setFaultRole(new URI(role.getText()));
            } catch (URISyntaxException e) {
                // ignore
            }
        }

        OMElement detail = omElement.getFirstChildWithName(DETAIL_Q);
        if (detail != null) {
            OMAttribute detailExpr = detail.getAttribute(ATT_EXPRN);
            if (detailExpr != null && detailExpr.getAttributeValue() != null) {
                try {
                    ((FaultMediator) mediator)
                            .setFaultDetailExpr(SynapseXPathFactory.getSynapseXPath(detail, ATT_EXPRN));
                } catch (JaxenException e) {
                    // ignore
                }

            } else if (detail.getChildElements().hasNext()) {
                Iterator it = detail.getChildElements();
                while (it.hasNext()) {
                    OMElement child = (OMElement) it.next();
                    if (child != null) {
                        ((FaultMediator) mediator).addFaultDetailElement(child);
                    }
                }

            } else if (detail.getText() != null) {
                ((FaultMediator) mediator).setFaultDetail(detail.getText());

            } else {
                ((FaultMediator) mediator).setFaultDetail("");
            }
        }

        return mediator;

    }

}
