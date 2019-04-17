/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
  *      http://www.apache.org/licenses/LICENSE-2.0
  * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamException;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class PropertyGroupMediatorTransformer extends AbstractEsbNodeTransformer {

    @Override
    public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
        try {
            info.getParentSequence().addChild(createPropertyGroupMediator(subject, false));
            // Transform the property mediator output data flow path.
            doTransform(info, ((PropertyGroupMediator) subject).getOutputConnector());
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }

    @Override
    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {
        // TODO Auto-generated method stub
    }

    @Override
    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        try {
            sequence.addChild(createPropertyGroupMediator(subject, false));
            doTransformWithinSequence(information, ((PropertyGroupMediator) subject).getOutputConnector().getOutgoingLink(),
                    sequence);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
    }

    public static org.apache.synapse.mediators.builtin.PropertyGroupMediator createPropertyGroupMediator(
            EsbNode subject, boolean isForValidation) throws JaxenException {
        Assert.isTrue(subject instanceof PropertyGroupMediator, "Invalid subject.");
        org.apache.synapse.mediators.builtin.PropertyGroupMediator propertyGroupMediator = new org.apache.synapse.mediators.builtin.PropertyGroupMediator();
        PropertyGroupMediator visualProp = (PropertyGroupMediator) subject;
        setCommonProperties(propertyGroupMediator, visualProp);
        List<org.apache.synapse.mediators.builtin.PropertyMediator> propertyList = new ArrayList<>();
        {
            for (PropertyMediator propertyMediator : visualProp.getProperties()) {
                PropertyMediatorTransformer propertyMediatorTransformer = new PropertyMediatorTransformer();
                org.apache.synapse.mediators.builtin.PropertyMediator synapseProperty;
                try {
                    synapseProperty = propertyMediatorTransformer.createPropertyMediator(propertyMediator,
                            isForValidation);
                    propertyList.add(synapseProperty);
                } catch (XMLStreamException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (TransformerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            propertyGroupMediator.setPropGroupList(propertyList);
        }
        return propertyGroupMediator;
    }
}
