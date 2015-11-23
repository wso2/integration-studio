/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheScope;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class CacheMediatorDeserializer extends
		AbstractEsbNodeDeserializer<AbstractMediator, CacheMediator> {

	@Override
	public CacheMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof org.apache.synapse.mediators.builtin.CacheMediator,
				"Unsupported mediator passed in for deserialization");

		org.apache.synapse.mediators.builtin.CacheMediator mediator = (org.apache.synapse.mediators.builtin.CacheMediator) object;
		CacheMediator mediatorModel = (CacheMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.CacheMediator_3518);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);
		
		if (StringUtils.isNotBlank(mediator.getId())) {
			executeSetValueCommand(CACHE_MEDIATOR__CACHE_ID, mediator.getId());
		}
		
		if("per-mediator".equals(mediator.getScope())){
			executeSetValueCommand(CACHE_MEDIATOR__CACHE_SCOPE, CacheScope.PER_MEDIATOR);
		} else if ("per-host".equals(mediator.getScope())){
			executeSetValueCommand(CACHE_MEDIATOR__CACHE_SCOPE, CacheScope.PER_HOST);
		}	
		
		if (mediator.isCollector()) {
			executeSetValueCommand(CACHE_MEDIATOR__CACHE_ACTION, CacheAction.COLLECTOR);
		} else {
			executeSetValueCommand(CACHE_MEDIATOR__CACHE_ACTION, CacheAction.FINDER);
			executeSetValueCommand(CACHE_MEDIATOR__CACHE_TIMEOUT, (int) mediator.getTimeout());
			executeSetValueCommand(CACHE_MEDIATOR__MAX_MESSAGE_SIZE, (int) mediator.getMaxMessageSize());
			executeSetValueCommand(CACHE_MEDIATOR__MAX_ENTRY_COUNT, (int) mediator.getInMemoryCacheSize());

			if(mediator.getDigestGenerator()!=null){
				executeSetValueCommand(CACHE_MEDIATOR__HASH_GENERATOR, mediator.getDigestGenerator().getClass().getName());
			}
			
			String onCacheHitRef = mediator.getOnCacheHitRef();
			SequenceMediator onCacheHitSequence = mediator.getOnCacheHitSequence();
			
			if(onCacheHitSequence!= null){
				executeSetValueCommand(CACHE_MEDIATOR__SEQUENCE_TYPE, CacheSequenceType.ANONYMOUS);
				refreshEditPartMap();
				IGraphicalEditPart compartment = (IGraphicalEditPart) getEditpart(mediatorModel.getMediatorFlow()).getChildren().get(0);
				deserializeSequence(compartment, onCacheHitSequence, mediatorModel.getOnHitOutputConnector());
			} else if(onCacheHitRef != null && !onCacheHitRef.equals("")){
					executeSetValueCommand(CACHE_MEDIATOR__SEQUENCE_TYPE, CacheSequenceType.REGISTRY_REFERENCE);
					RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
					regkey.setKeyValue(onCacheHitRef);
					executeSetValueCommand(CACHE_MEDIATOR__SEQUENCE_KEY, regkey);
			}
		}
		
		return mediatorModel;
	}

}
