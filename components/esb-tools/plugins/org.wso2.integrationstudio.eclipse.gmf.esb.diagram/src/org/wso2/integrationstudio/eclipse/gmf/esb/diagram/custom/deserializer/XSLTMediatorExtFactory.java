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

import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.MediatorPropertyFactory;
import org.apache.synapse.config.xml.ResourceMapFactory;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.XSLTMediatorFactory;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.builtin.LogMediator;
import org.apache.synapse.mediators.transform.XSLTMediator;
import org.jaxen.JaxenException;

public class XSLTMediatorExtFactory extends XSLTMediatorFactory {
    
    private static XSLTMediatorExtFactory instance;
    
    private XSLTMediatorExtFactory() {
    }
    
    public static synchronized XSLTMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new XSLTMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        XSLTMediator mediator = new XSLTMediator();

        QName ATTRIBUTE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "attribute");
        QName ATT_USECACHE = new QName("useCache");

        OMAttribute attXslt = omElement.getAttribute(ATT_KEY);
        OMAttribute attSource = omElement.getAttribute(ATT_SOURCE);
        OMAttribute attTarget = omElement.getAttribute(ATT_TARGET);
        OMAttribute attUseCache = omElement.getAttribute(ATT_USECACHE);

        if (attXslt != null) {
            ValueFactoryExtended keyFac = new ValueFactoryExtended();
            Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

            ((XSLTMediator) mediator).setXsltKey(generatedKey);
        } else {
            // ignore
        }

        if (attSource != null) {
            try {
                ((XSLTMediator) mediator).setSourceXPathString(attSource.getAttributeValue());
                ((XSLTMediator) mediator).setSource(SynapseXPathFactory.getSynapseXPath(omElement, ATT_SOURCE));

            } catch (JaxenException e) {
                // ignore
            }
        }

        if (attTarget != null) {
            ((XSLTMediator) mediator).setTargetPropertyName(attTarget.getAttributeValue());
        }

        if (attUseCache != null) {
            ((XSLTMediator) mediator).setUseCache(Boolean.parseBoolean(attUseCache.getAttributeValue()));
        }

        processAuditStatus(mediator, omElement);

        for (Map.Entry<String, String> entry : collectNameValuePairs(omElement, FEATURE_Q).entrySet()) {
            String value = entry.getValue();
            boolean isFeatureEnabled = "true".equals(value) ? true : false;
            ((XSLTMediator) mediator).addFeature(entry.getKey(), isFeatureEnabled);
        }

        for (Map.Entry<String, String> entry : collectNameValuePairs(omElement, ATTRIBUTE_Q).entrySet()) {
            ((XSLTMediator) mediator).addAttribute(entry.getKey(), entry.getValue());
        }

        ((XSLTMediator) mediator).addAllProperties(MediatorPropertyFactory.getMediatorProperties(omElement));

        ((XSLTMediator) mediator).setResourceMap(ResourceMapFactory.createResourceMap(omElement));
        addAllCommentChildrenToList(omElement, mediator.getCommentsList());

        return mediator;
    }

}
