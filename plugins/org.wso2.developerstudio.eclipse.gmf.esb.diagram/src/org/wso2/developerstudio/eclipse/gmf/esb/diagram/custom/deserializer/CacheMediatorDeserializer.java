/*
 * Copyright 2012-2017 WSO2, Inc. (http://wso2.com)
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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__CACHE_ACTION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__CACHE_TIMEOUT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__HASH_GENERATOR;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__MAX_ENTRY_COUNT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__MAX_MESSAGE_SIZE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__SEQUENCE_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__SEQUENCE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__CACHE_PROTOCOL_METHODS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__CACHE_PROTOCOL_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__RESPONSE_CODES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__ENABLE_CACHE_CONTROL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__INCLUDE_AGE_HEADER;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CACHE_MEDIATOR__HEADERS_TO_EXCLUDE_IN_HASH;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.carbon.mediator.cache.CacheMediatorFactory;
import org.wso2.carbon.mediator.cache.CachingConstants;

public class CacheMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CacheMediator> {

	@Override
	public CacheMediator createNode(IGraphicalEditPart part, AbstractMediator object) throws DeserializerException {
		Assert.isTrue(object instanceof org.wso2.carbon.mediator.cache.CacheMediator,
				"Unsupported mediator passed in for deserialization");
		CacheMediator mediatorModel = (CacheMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.CacheMediator_3518);
		// Fixing DEVTOOLEI-1120
		if (object instanceof org.wso2.carbon.mediator.cache.CacheMediator) {
			org.wso2.carbon.mediator.cache.CacheMediator mediator = (org.wso2.carbon.mediator.cache.CacheMediator) object;

			setElementToEdit(mediatorModel);
			setCommonProperties(mediator, mediatorModel);


            if (mediator.isCollector()) {
                executeSetValueCommand(CACHE_MEDIATOR__CACHE_ACTION, CacheAction.COLLECTOR);
            } else {
                if (CachingConstants.HTTP_PROTOCOL_TYPE.equals(mediator.getProtocolType())) {
                    String[] methods = mediator.getHTTPMethodsToCache();
                    if (methods != null && methods.length != 0 && !methods[0].isEmpty()) {
                        StringBuilder method = new StringBuilder();
                        for (int i = 0; i < methods.length - 1; i++) {
                            method.append(methods[i]).append(", ");
                        }
                        method.append(methods[methods.length - 1]);
                        executeSetValueCommand(CACHE_MEDIATOR__CACHE_PROTOCOL_METHODS, method.toString());
                    }
                    String[] headerstoExclude = mediator.getHeadersToExcludeInHash();
                    StringBuilder header = new StringBuilder();
                    for (int i = 0; i < headerstoExclude.length - 1; i++) {
                        header.append(headerstoExclude[i]).append(", ");
                    }
                    header.append(headerstoExclude[headerstoExclude.length - 1]);
                    executeSetValueCommand(CACHE_MEDIATOR__HEADERS_TO_EXCLUDE_IN_HASH, header.toString());
                    executeSetValueCommand(CACHE_MEDIATOR__RESPONSE_CODES, mediator.getResponseCodes());
                    executeSetValueCommand(CACHE_MEDIATOR__ENABLE_CACHE_CONTROL, mediator.isCacheControlEnabled());
                    executeSetValueCommand(CACHE_MEDIATOR__INCLUDE_AGE_HEADER, mediator.isAddAgeHeaderEnabled());
                }
                executeSetValueCommand(CACHE_MEDIATOR__CACHE_PROTOCOL_TYPE, mediator.getProtocolType());
                executeSetValueCommand(CACHE_MEDIATOR__MAX_MESSAGE_SIZE, mediator.getMaxMessageSize());
                executeSetValueCommand(CACHE_MEDIATOR__CACHE_ACTION, CacheAction.FINDER);
                executeSetValueCommand(CACHE_MEDIATOR__CACHE_TIMEOUT, (int) mediator.getTimeout());
                executeSetValueCommand(CACHE_MEDIATOR__MAX_ENTRY_COUNT, (int) mediator.getInMemoryCacheSize());

                if (mediator.getDigestGenerator() != null) {
                    executeSetValueCommand(CACHE_MEDIATOR__HASH_GENERATOR,
                            mediator.getDigestGenerator().getClass().getName());
                }

                String onCacheHitRef = mediator.getOnCacheHitRef();
                SequenceMediator onCacheHitSequence = mediator.getOnCacheHitSequence();

                if (onCacheHitSequence != null) {
                    executeSetValueCommand(CACHE_MEDIATOR__SEQUENCE_TYPE, CacheSequenceType.ANONYMOUS);
                    refreshEditPartMap();
                    IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(mediatorModel.getMediatorFlow())
                            .getChildren().get(0);
                    deserializeSequence(compartment, onCacheHitSequence, mediatorModel.getOnHitOutputConnector());
                } else if (onCacheHitRef != null && !onCacheHitRef.equals("")) {
                    executeSetValueCommand(CACHE_MEDIATOR__SEQUENCE_TYPE, CacheSequenceType.REGISTRY_REFERENCE);
                    RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                    regkey.setKeyValue(onCacheHitRef);
                    executeSetValueCommand(CACHE_MEDIATOR__SEQUENCE_KEY, regkey);
                }
            }
        }
        return mediatorModel;
    }

}