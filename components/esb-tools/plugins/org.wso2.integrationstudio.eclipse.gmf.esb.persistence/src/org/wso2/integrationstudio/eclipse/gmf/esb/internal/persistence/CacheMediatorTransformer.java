/*
 * Copyright 2012-2018 WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.carbon.mediator.cache.CacheManager;
import org.wso2.carbon.mediator.cache.CachingConstants;
import org.wso2.carbon.mediator.cache.digest.DigestGenerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheMediatorType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheScopeType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.integrationstudio.eclipse.gmf.esb.CacheType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * Cache mediator transformer
 */
public class CacheMediatorTransformer extends AbstractEsbNodeTransformer {

    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {

        // Fixing DEVTOOLEI-1120
        information.getParentSequence().addChild(createNewCacheMediator(subject, information));

        /**
         * Transform the Cache Mediator output data flow path.
         */
        doTransform(information, ((CacheMediator) subject).getOutputConnector());
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {

        // Fixing DEVTOOLEI-1120
        sequence.addChild(createNewCacheMediator(subject, information));
        doTransformWithinSequence(information, ((CacheMediator) subject).getOutputConnector().getOutgoingLink(),
                sequence);

    }

    public static org.wso2.carbon.mediator.cache.CacheMediator createNewCacheMediator(EsbNode subject,
            TransformationInfo info) throws TransformerException {
        /*
         * Check subject.
         */
        Assert.isTrue(subject instanceof CacheMediator, "Invalid subject.");
        CacheMediator visualCache = (CacheMediator) subject;
        /*
         * Configure Cache mediator.
         */
        org.wso2.carbon.mediator.cache.CacheMediator cacheMediator = new org.wso2.carbon.mediator.cache.CacheMediator(
                new CacheManager());
        setCommonProperties(cacheMediator, visualCache);

        boolean isPreviousCacheImplementation = visualCache.getCacheMediatorImplementation()
                .equals(CacheMediatorType.COMPATIBILITY_611);

        if (isPreviousCacheImplementation) {
            cacheMediator.setPreviousCacheImplementation(true);
        }

        if (visualCache.getCacheType().equals(CacheType.FINDER)) {
            cacheMediator.setCollector(false);

            if (!isPreviousCacheImplementation) {
                // new implementation of cache mediator
                cacheMediator.setProtocolType(visualCache.getCacheProtocolType().getLiteral());
                if (CachingConstants.HTTP_PROTOCOL_TYPE.equals(visualCache.getCacheProtocolType().getLiteral())) {
                    if (StringUtils.isNotBlank(visualCache.getCacheProtocolMethods())) {
                        cacheMediator.setHTTPMethodsToCache(visualCache.getCacheProtocolMethods().split(","));
                    } else {
                        cacheMediator.setHTTPMethodsToCache("*");
                    }
                    if (StringUtils.isNotBlank(visualCache.getResponseCodes())) {
                        cacheMediator.setResponseCodes(visualCache.getResponseCodes());
                    } else {
                        cacheMediator.setResponseCodes(".*");
                    }
                    cacheMediator.setCacheControlEnabled(visualCache.isEnableCacheControl());

                    cacheMediator.setAddAgeHeaderEnabled(visualCache.isIncludeAgeHeader());
                    if (StringUtils.isNotBlank(visualCache.getHeadersToExcludeInHash())) {
                        cacheMediator.setHeadersToExcludeInHash(visualCache.getHeadersToExcludeInHash().split(","));
                    }
                }

                DigestGenerator httpRequestHashGenerator = null;
                if (visualCache.getHashGenerator()
                        .equals("org.wso2.carbon.mediator.cache.digest.HttpRequestHashGenerator")) {
                    httpRequestHashGenerator = new org.wso2.carbon.mediator.cache.digest.HttpRequestHashGenerator();
                } else if (visualCache.getHashGenerator().toLowerCase().contains("requesthashgenerator")) {
                    httpRequestHashGenerator = new org.wso2.carbon.mediator.cache.digest.REQUESTHASHGenerator();
                } else if (visualCache.getHashGenerator().toLowerCase().contains("domhashgenerator")) {
                    httpRequestHashGenerator = new org.wso2.carbon.mediator.cache.digest.DOMHASHGenerator();
                } else {
                    throw new TransformerException("Digest generator not found");
                }
                cacheMediator.setDigestGenerator(httpRequestHashGenerator);

            } else {
                // previous implementation of cache mediator
                cacheMediator.setId("");
                if (visualCache.getId() != null) {
                    cacheMediator.setId(visualCache.getId().trim());
                }

                if (visualCache.getScope().equals(CacheScopeType.PER_HOST)) {
                    cacheMediator.setScope("per-host");
                } else {
                    cacheMediator.setScope("per-mediator");
                    if (cacheMediator.getId().equals("")) {
                        throw new TransformerException("Cache ID cannot be empty since the cache scope is per-mediator.");
                    }
                }

                if (!visualCache.getHashGenerator().isEmpty()) {
                    cacheMediator.setHashGenerator(visualCache.getHashGeneratorAttribute());
                } else {
                    cacheMediator.setHashGenerator("org.wso2.carbon.mediator.cache.digest.DOMHASHGenerator");
                }

                cacheMediator.setImplementationType(visualCache.getImplementationType().getName());
            }

            cacheMediator.setMaxMessageSize(visualCache.getMaxMessageSize());
            cacheMediator.setTimeout(visualCache.getCacheTimeout());
            cacheMediator.setInMemoryCacheSize(visualCache.getMaxEntryCount());

        } else {
            cacheMediator.setCollector(true);
            if (isPreviousCacheImplementation) {
                if (visualCache.getScope().equals(CacheScopeType.PER_HOST)) {
                    cacheMediator.setScope("per-host");
                } else {
                    cacheMediator.setScope("per-mediator");
                }
            }
        }

        if (visualCache.getSequenceType().equals(CacheSequenceType.REGISTRY_REFERENCE)) {
            if (visualCache.getSequenceKey() != null) {

                RegistryKeyProperty regKeyProperty = visualCache.getSequenceKey();
                cacheMediator.setOnCacheHitRef(regKeyProperty.getKeyValue());
            }

        } else {
            SequenceMediator onCacheHitSequence = new SequenceMediator();
            TransformationInfo newOnCacheHitInfo = new TransformationInfo();
            newOnCacheHitInfo.setTraversalDirection(info.getTraversalDirection());
            newOnCacheHitInfo.setSynapseConfiguration(info.getSynapseConfiguration());
            newOnCacheHitInfo.setOriginInSequence(info.getOriginInSequence());
            newOnCacheHitInfo.setOriginOutSequence(info.getOriginOutSequence());
            newOnCacheHitInfo.setCurrentProxy(info.getCurrentProxy());
            newOnCacheHitInfo.setParentSequence(onCacheHitSequence);
            doTransform(newOnCacheHitInfo, visualCache.getOnHitOutputConnector());
            cacheMediator.setOnCacheHitSequence(onCacheHitSequence);
        }

        return cacheMediator;
    }
}
