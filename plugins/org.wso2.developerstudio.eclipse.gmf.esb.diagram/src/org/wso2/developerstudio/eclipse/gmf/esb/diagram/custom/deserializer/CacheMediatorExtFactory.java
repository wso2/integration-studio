/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.CacheMediatorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.builtin.CacheMediator;
import org.wso2.caching.CachingConstants;

public class CacheMediatorExtFactory extends CacheMediatorFactory {
    private static final QName ATT_GENERATOR = new QName("hashGenerator");
    private static final QName CACHE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "cache");
    private static final QName ATT_ID = new QName("id");
    private static final QName ATT_COLLECTOR = new QName("collector");
    private static final QName ATT_MAX_MSG_SIZE = new QName("maxMessageSize");
    private static final QName ATT_TIMEOUT = new QName("timeout");
    private static final QName ATT_SCOPE = new QName("scope");
    private static final QName ATT_SEQUENCE = new QName("sequence");
    private static final QName ATT_TYPE = new QName("type");
    private static final QName ATT_SIZE = new QName("maxSize");
    private static final QName ON_CACHE_HIT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "onCacheHit");
    private static final QName IMPLEMENTATION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "implementation");
    private static final long DEFAULT_TIMEOUT = 5000L;
    private static final int DEFAULT_DISK_CACHE_SIZE = 200;

    public Mediator createSpecificMediator(OMElement elem, Properties properties) {

        if (!CACHE_Q.equals(elem.getQName())) {
            handleException(
                    "Unable to create the cache mediator. " + "Unexpected element as the cache mediator configuration");
        }

        CacheMediator cacheMediator = new CacheMediator();

        OMAttribute idAttr = elem.getAttribute(ATT_ID);
        if (idAttr != null && idAttr.getAttributeValue() != null) {
            cacheMediator.setId(idAttr.getAttributeValue());
        }

        OMAttribute scopeAttr = elem.getAttribute(ATT_SCOPE);
        if (scopeAttr != null && scopeAttr.getAttributeValue() != null
                && isValidScope(scopeAttr.getAttributeValue(), cacheMediator.getId())) {
            cacheMediator.setScope(scopeAttr.getAttributeValue());
        } else {
            cacheMediator.setScope(CachingConstants.SCOPE_PER_HOST);
        }

        OMAttribute collectorAttr = elem.getAttribute(ATT_COLLECTOR);
        if (collectorAttr != null && collectorAttr.getAttributeValue() != null
                && "true".equals(collectorAttr.getAttributeValue())) {

            cacheMediator.setCollector(true);
        } else {

            cacheMediator.setCollector(false);

            OMAttribute name = elem.getAttribute(ATT_GENERATOR);

            if (name != null) {
                org.wso2.caching.digest.DOMHASHGenerator domhashGenerator = new org.wso2.caching.digest.DOMHASHGenerator();
                cacheMediator.setDigestGenerator(domhashGenerator);
            }

            OMAttribute timeoutAttr = elem.getAttribute(ATT_TIMEOUT);
            if (timeoutAttr != null && timeoutAttr.getAttributeValue() != null) {
                cacheMediator.setTimeout(Long.parseLong(timeoutAttr.getAttributeValue()));
            } else {
                cacheMediator.setTimeout(DEFAULT_TIMEOUT);
            }

            OMAttribute maxMessageSizeAttr = elem.getAttribute(ATT_MAX_MSG_SIZE);
            if (maxMessageSizeAttr != null && maxMessageSizeAttr.getAttributeValue() != null) {
                cacheMediator.setMaxMessageSize(Integer.parseInt(maxMessageSizeAttr.getAttributeValue()));
            }

            OMElement onCacheHitElem = elem.getFirstChildWithName(ON_CACHE_HIT_Q);
            if (onCacheHitElem != null) {
                OMAttribute sequenceAttr = onCacheHitElem.getAttribute(ATT_SEQUENCE);
                if (sequenceAttr != null && sequenceAttr.getAttributeValue() != null) {
                    cacheMediator.setOnCacheHitRef(sequenceAttr.getAttributeValue());
                } else if (onCacheHitElem.getFirstElement() != null) {
                    cacheMediator.setOnCacheHitSequence(
                            new SequenceMediatorFactory().createAnonymousSequence(onCacheHitElem, properties));
                }
            }

            for (Iterator itr = elem.getChildrenWithName(IMPLEMENTATION_Q); itr.hasNext();) {
                OMElement implElem = (OMElement) itr.next();
                OMAttribute typeAttr = implElem.getAttribute(ATT_TYPE);
                OMAttribute sizeAttr = implElem.getAttribute(ATT_SIZE);
                if (typeAttr != null && typeAttr.getAttributeValue() != null) {
                    String type = typeAttr.getAttributeValue();
                    if (CachingConstants.TYPE_MEMORY.equals(type) && sizeAttr != null
                            && sizeAttr.getAttributeValue() != null) {
                        cacheMediator.setInMemoryCacheSize(Integer.parseInt(sizeAttr.getAttributeValue()));
                    } else if (CachingConstants.TYPE_DISK.equals(type)) {
                        if (sizeAttr != null && sizeAttr.getAttributeValue() != null) {
                            cacheMediator.setDiskCacheSize(Integer.parseInt(sizeAttr.getAttributeValue()));
                        } else {
                            cacheMediator.setDiskCacheSize(DEFAULT_DISK_CACHE_SIZE);
                        }
                    } else {
                        handleException("unknown implementation type for the Cache mediator");
                    }
                }
            }
        }

        addAllCommentChildrenToList(elem, cacheMediator.getCommentsList());

        return cacheMediator;
    }

    private boolean isValidScope(String scope, String id) {
        if (CachingConstants.SCOPE_PER_HOST.equals(scope)) {
            return true;
        } else if (CachingConstants.SCOPE_PER_MEDIATOR.equals(scope)) {
            if (id != null) {
                return true;
            } else {
                handleException("Id is required for a cache with scope : " + scope);
                return false;
            }
        } else if (CachingConstants.SCOPE_DISTRIBUTED.equals(scope)) {
            handleException("Scope distributed is not supported yet by the Cache mediator");
            return false;
        } else {
            handleException("Unknown scope " + scope + " for the Cache mediator");
            return false;
        }
    }
}