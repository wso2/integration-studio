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

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.EnrichMediatorFactory;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.elementary.EnrichMediator;
import org.apache.synapse.mediators.elementary.Source;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;

public class EnrichMediatorExtFactory extends EnrichMediatorFactory {

    private static final QName ATT_TYPE = new QName("type");
    private static final QName ATT_CLONE = new QName("clone");
    private static final QName ATT_ACTION = new QName("action");
    private static final QName ATT_PROPERTY = new QName("property");
    private static final QName ATT_XPATH = new QName("xpath");
    private static final QName ATT_KEY = new QName("key");
    
    private static EnrichMediatorExtFactory instance;
    
    private EnrichMediatorExtFactory() {
    }
    
    public static synchronized EnrichMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new EnrichMediatorExtFactory();
        }
        return instance;
    }
    
    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new EnrichMediator();

        QName SOURCE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "source");
        QName TARGET_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");

        processAuditStatus(mediator, omElement);

        OMElement sourceEle = omElement.getFirstChildWithName(SOURCE_Q);

        Source source = new Source();
        ((EnrichMediator) mediator).setSource(source);

        OMElement targetEle = omElement.getFirstChildWithName(TARGET_Q);
        org.apache.synapse.mediators.elementary.Target target = new org.apache.synapse.mediators.elementary.Target();
        ((EnrichMediator) mediator).setTarget(target);

        populateSource(source, sourceEle, mediator);
        populateTarget(target, targetEle, mediator);
        addAllCommentChildrenToList(omElement, ((EnrichMediator) mediator).getCommentsList());

        return mediator;
    }

    private void populateSource(Source source, OMElement sourceEle, Mediator mediator) {

        OMAttribute typeAttr = sourceEle.getAttribute(ATT_TYPE);
        if (typeAttr != null && typeAttr.getAttributeValue() != null) {
            source.setSourceType(convertTypeToInt(typeAttr.getAttributeValue()));
        }

        OMAttribute cloneAttr = sourceEle.getAttribute(ATT_CLONE);
        if (cloneAttr != null && cloneAttr.getAttributeValue() != null) {
            source.setClone(Boolean.parseBoolean(cloneAttr.getAttributeValue()));
        }

        if (source.getSourceType() == EnrichMediator.CUSTOM) {
            OMAttribute xpathAttr = sourceEle.getAttribute(ATT_XPATH);
            if (xpathAttr != null && xpathAttr.getAttributeValue() != null) {
                try {
                    source.setXpath(SynapseXPathFactory.getSynapseXPath(sourceEle, ATT_XPATH));
                } catch (JaxenException e) {
                    // If the xPath is not a valid synapse xpath this will add the invalid xpath to the model
                    source.setXpath(SynapseXPathExt.createSynapsePath(xpathAttr.getAttributeValue()));
                }
            }

        } else if (source.getSourceType() == EnrichMediator.PROPERTY) {
            OMAttribute propertyAttr = sourceEle.getAttribute(ATT_PROPERTY);
            if (propertyAttr != null && propertyAttr.getAttributeValue() != null) {
                source.setProperty(propertyAttr.getAttributeValue());
            }

        } else if (source.getSourceType() == EnrichMediator.INLINE) {
            OMElement inlineElem = null;
            if (sourceEle.getFirstElement() != null) {
                inlineElem = sourceEle.getFirstElement().cloneOMElement();
            }

            if (inlineElem != null) {
                source.setInlineOMNode(inlineElem);
            } else if (!StringUtils.isBlank(sourceEle.getText())) {
                source.setInlineOMNode(OMAbstractFactory.getOMFactory().createOMText(sourceEle.getText()));
            } else if (sourceEle.getAttributeValue(ATT_KEY) != null) {
                source.setInlineKey(sourceEle.getAttributeValue(ATT_KEY));
            }
        }
    }

    private void populateTarget(org.apache.synapse.mediators.elementary.Target target, OMElement sourceEle,
            Mediator mediator) {

        OMAttribute typeAttr = sourceEle.getAttribute(ATT_TYPE);
        OMAttribute actionAttr = sourceEle.getAttribute(ATT_ACTION);

        if (actionAttr != null && actionAttr.getAttributeValue() != null) {
            target.setAction(actionAttr.getAttributeValue());
        } else {
            target.setAction("replace");
        }

        if (typeAttr != null && typeAttr.getAttributeValue() != null) {
            int type = convertTypeToInt(typeAttr.getAttributeValue());
            if (type >= 0) {
                target.setTargetType(type);
            }
        }

        if (target.getTargetType() == EnrichMediator.CUSTOM) {
            OMAttribute xpathAttr = sourceEle.getAttribute(ATT_XPATH);
            if (xpathAttr != null && xpathAttr.getAttributeValue() != null) {
                try {
                    target.setXpath(SynapseXPathFactory.getSynapseXPath(sourceEle, ATT_XPATH));
                } catch (JaxenException e) {
                    // If the xPath is not a valid synapse xpath this will add the invalid xpath to the model
                    target.setXpath(SynapseXPathExt.createSynapsePath(xpathAttr.getAttributeValue()));
                }
            }
        } else if (target.getTargetType() == EnrichMediator.PROPERTY) {
            OMAttribute propertyAttr = sourceEle.getAttribute(ATT_PROPERTY);
            if (propertyAttr != null && propertyAttr.getAttributeValue() != null) {
                target.setProperty(propertyAttr.getAttributeValue());
            }
        }
    }

    private int convertTypeToInt(String type) {
        if (type.equals("envelope")) {
            return EnrichMediator.ENVELOPE;
        } else if (type.equals("body")) {
            return EnrichMediator.BODY;
        } else if (type.equals("property")) {
            return EnrichMediator.PROPERTY;
        } else if (type.equals("custom")) {
            return EnrichMediator.CUSTOM;
        } else if (type.equals("inline")) {
            return EnrichMediator.INLINE;
        }
        return -1;
    }

}
