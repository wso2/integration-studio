/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.StoreMediatorSpecifyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

public class StoreMediatorTransformer extends AbstractEsbNodeTransformer {

    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        try {
            information.getParentSequence().addChild(createStoreMediator(subject, false));
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
        doTransform(information, ((StoreMediator) subject).getOutputConnector());

    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        try {
            sequence.addChild(createStoreMediator(subject, false));
            doTransformWithinSequence(information, ((StoreMediator) subject).getOutputConnector().getOutgoingLink(),
                    sequence);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }

    public static org.apache.synapse.mediators.store.MessageStoreMediator createStoreMediator(EsbNode subject, boolean isForValidation)
            throws JaxenException {
        Assert.isTrue(subject instanceof StoreMediator, "Invalid subject.");
        StoreMediator visualStore = (StoreMediator) subject;
        org.apache.synapse.mediators.store.MessageStoreMediator storeMediator = new org.apache.synapse.mediators.store.MessageStoreMediator();
        setCommonProperties(storeMediator, visualStore);
        if (null != visualStore.getOnStoreSequence()
                && StringUtils.isNotBlank(visualStore.getOnStoreSequence().getKeyValue())) {
            storeMediator.setOnStoreSequence(visualStore.getOnStoreSequence().getKeyValue());
        }
        if (visualStore.getSpecifyAs() == StoreMediatorSpecifyType.VALUE) {
            if (!isForValidation && StringUtils.isEmpty(visualStore.getMessageStore())) {
                storeMediator.setMessageStoreName(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
            } else {
                storeMediator.setMessageStoreName(visualStore.getMessageStore());
            }
        } else if (visualStore.getSpecifyAs() == StoreMediatorSpecifyType.EXPRESSION) {
            NamespacedProperty payLoadExp = visualStore.getExpression();
            if (payLoadExp != null) {
                SynapseXPath xpath = null;
                // If the value of the expression is empty the fill the xpath with default values for synapse
                // serialization
                if (!isForValidation && StringUtils.isEmpty(payLoadExp.getPropertyValue())) {
                    xpath = (SynapseXPath) SynapseXPathExt
                            .createSynapsePath(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
                } else {
                    xpath = new SynapseXPath(payLoadExp.getPropertyValue());
                }
                Map<String, String> nameSpaceMap = payLoadExp.getNamespaces();
                for (String key : nameSpaceMap.keySet()) {
                    xpath.addNamespace(key, nameSpaceMap.get(key));
                }
                storeMediator.setMessageStoreExp(xpath);
            }
        }
        return storeMediator;
    }

}
