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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.ResourceMapFactory;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.config.xml.ValidateMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.builtin.ValidateMediator;
import org.jaxen.JaxenException;
import org.xml.sax.SAXException;

public class ValidateMediatorExtFactory extends ValidateMediatorFactory {
    
    private static ValidateMediatorExtFactory instance;
    
    private ValidateMediatorExtFactory() {
    }
    
    public static synchronized ValidateMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new ValidateMediatorExtFactory();
        }
        return instance;
    }

    protected Mediator createSpecificMediator(OMElement omElement) {

        Mediator mediator = new ValidateMediator();

        QName ON_FAIL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "on-fail");
        QName SCHEMA_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "schema");
        QName ATT_CACHE_SCHEMA = new QName("cache-schema");

        List<Value> schemaKeys = new ArrayList<Value>();
        Iterator schemas = omElement.getChildrenWithName(SCHEMA_Q);

        while (schemas.hasNext()) {
            Object o = schemas.next();
            if (o instanceof OMElement) {
                OMElement omElem = (OMElement) o;
                OMAttribute keyAtt = omElem.getAttribute(ATT_KEY);
                if (keyAtt != null) {
                    ValueFactory keyFac = new ValueFactory();
                    Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElem);
                    schemaKeys.add(generatedKey);
                }
            }
        }

        if (schemaKeys.size() != 0) {
            ((ValidateMediator) mediator).setSchemaKeys(schemaKeys);
        }

        OMAttribute attSource = omElement.getAttribute(ATT_SOURCE);

        if (attSource != null) {
            try {
                if (attSource.getAttributeValue() != null) {
                    ((ValidateMediator) mediator).setSource(SynapsePathFactory.getSynapsePath(omElement, ATT_SOURCE));
                }
            } catch (JaxenException e) {
                // ignore
            }
        }

        OMAttribute attSchemaCache = omElement.getAttribute(ATT_CACHE_SCHEMA);
        if (attSchemaCache != null) {
            final boolean cacheSchema = Boolean.parseBoolean(attSchemaCache.getAttributeValue());
            ((ValidateMediator) mediator).setCacheSchema(cacheSchema);
        }

        ((ValidateMediator) mediator).setResourceMap(ResourceMapFactory.createResourceMap(omElement));

        OMElement onFail = null;
        Iterator iterator = omElement.getChildrenWithName(ON_FAIL_Q);
        if (iterator.hasNext()) {
            onFail = (OMElement) iterator.next();
        }

        if (onFail != null && onFail.getChildElements().hasNext()) {
            addChildren(onFail, (ValidateMediator) mediator, null);
        }

        processAuditStatus(mediator, omElement);
        for (Map.Entry<String, String> entry : collectNameValuePairs(omElement,
                new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "feature")).entrySet()) {
            String value = entry.getValue();
            boolean isFeatureEnabled = "true".equals(value) ? true : false;
            String key = entry.getKey();
            if (XMLConstants.FEATURE_SECURE_PROCESSING.equals(key)) {
                try {
                    ((ValidateMediator) mediator).addFeature(key, isFeatureEnabled);
                } catch (SAXException e) {
                    // ignore
                }
            }
        }
        addAllCommentChildrenToList(omElement, ((ValidateMediator) mediator).getCommentsList());
        
        return mediator;
    }

}
