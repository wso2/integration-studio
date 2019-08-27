/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.SynapseArtifact;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerUtils;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.FailoverEndpointFormPage;

public class FailoverEndPointTransformer extends AbstractEndpointTransformer {

    public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {

        Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject.");
        FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
        FailoverEndpoint synapseEP = create(info, visualEndPoint, visualEndPoint.getName(), null);
        setEndpointToSendCallOrProxy(info, visualEndPoint, synapseEP);

        if (!info.isEndPointFound) {
            info.isEndPointFound = true;
            info.firstEndPoint = visualEndPoint;
        }

        if (visualEndPoint.getWestOutputConnector() != null) {
            if (visualEndPoint.getWestOutputConnector().getOutgoingLink() != null) {
                InputConnector nextInputConnector = visualEndPoint.getWestOutputConnector().getOutgoingLink()
                        .getTarget();
                if ((!(nextInputConnector instanceof SequenceInputConnector))
                        || ((((Sequence) nextInputConnector.eContainer()).getOutputConnector().get(0)
                                .getOutgoingLink() != null)
                                && (!(((Sequence) nextInputConnector.eContainer()).getOutputConnector().get(0)
                                        .getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))) {
                    info.setParentSequence(info.getOriginOutSequence());
                    info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
                } else if (visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource()
                        .eContainer() instanceof Sequence) {
                    info.setParentSequence(info.getCurrentReferredSequence());
                }
            }
        }

        List<EsbNode> transformedMediators = info.getTransformedMediators();
        if (visualEndPoint.getOutputConnector() != null && visualEndPoint.getWestOutputConnector() != null
                && visualEndPoint.getWestOutputConnector().getOutgoingLink() != null) {
            EsbNode nextElement = (EsbNode) visualEndPoint.getWestOutputConnector().getOutgoingLink().getTarget()
                    .eContainer();
            if (transformedMediators.contains(nextElement)) {
                return;
            }
            doTransform(info, visualEndPoint.getWestOutputConnector());
            transformedMediators.add(nextElement);
        }

    }

    @Override
    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {

        Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject.");
        FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
        endPoints.add(create(info, visualEndPoint, visualEndPoint.getEndPointName(), endPoints));

    }

    @Override
    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        Assert.isTrue(subject instanceof FailoverEndPoint, "Invalid subject");
        FailoverEndPoint visualEndPoint = (FailoverEndPoint) subject;
        Endpoint synapseEP = create(information, visualEndPoint, visualEndPoint.getEndPointName(), null);
        setEndpointToSendOrCallMediator(sequence, synapseEP);
    }

    public FailoverEndpoint create(TransformationInfo info, FailoverEndPoint visualEndPoint, String name,
            List<Endpoint> endPoints) throws TransformerException {

        FailoverEndpoint synapseFailEP = new FailoverEndpoint();

        if (StringUtils.isNotBlank(name)) {
            synapseFailEP.setName(name);
        } else if (StringUtils.isNotBlank(visualEndPoint.getEndPointName())) {
            synapseFailEP.setName(visualEndPoint.getEndPointName());
        }
        synapseFailEP.setBuildMessageAtt(visualEndPoint.isBuildMessage());
        EndpointDefinition synapseEPDef = new EndpointDefinition();

        List<Endpoint> synapseChildren = new ArrayList<>();
        if (visualEndPoint.getChildren() != null && visualEndPoint.getChildren().size() > 0) {
            for (org.wso2.developerstudio.eclipse.gmf.esb.EndPoint viEndpoint : visualEndPoint.getChildren()) {
                synapseChildren.add(TransformerUtils.getSynapseEndpoint(viEndpoint));
            }
        }

        synapseFailEP.setChildren(synapseChildren);
        synapseFailEP.setDefinition(synapseEPDef);
        saveProperties(visualEndPoint, synapseFailEP);

        if (info != null && !info.isEndPointFound) {
            info.isEndPointFound = true;
            info.firstEndPoint = visualEndPoint;
        }

        return synapseFailEP;
    }
    
    public SynapseArtifact create(FailoverEndpointFormPage formPage) throws NumberFormatException, JaxenException {

        FailoverEndpoint synapseFailoverEP = new FailoverEndpoint();
        if (StringUtils.isNotBlank(formPage.getEndpointName().getText())) {
            synapseFailoverEP.setName(formPage.getEndpointName().getText());
        }

        if (formPage.getEndpointBuildMessage().getText().equals("True")) {
            synapseFailoverEP.setBuildMessageAtt(true);
        } else {
            synapseFailoverEP.setBuildMessageAtt(false);
        }

        // set endPointsList
        if (formPage.getSynapseEndpointList().size() > 0) {
            synapseFailoverEP.setChildren(formPage.getSynapseEndpointList());

        }
        
        synapseFailoverEP.setDescription(formPage.getEP_Description().getText());

        List<MediatorProperty> mediatorProperties = new ArrayList<>();
        List<EndPointProperty> endpointProp = formPage.getEndPointPropertyList();
        if (endpointProp != null) {
            for (int i = 0; i < endpointProp.size(); i++) {
                EndPointProperty uiMediatorProp = endpointProp.get(i);
                MediatorProperty tempMediatorProperty = new MediatorProperty();
                tempMediatorProperty.setName(uiMediatorProp.getName());
                tempMediatorProperty.setScope(uiMediatorProp.getScope().getLiteral());
                if (uiMediatorProp.getValue() != null && !uiMediatorProp.getValue().isEmpty()) {
                    tempMediatorProperty.setValue(uiMediatorProp.getValue());
                } else {
                    // add expression support
                }
                mediatorProperties.add(tempMediatorProperty);
            }
        }
        synapseFailoverEP.addProperties(mediatorProperties);

        return synapseFailoverEP;
    }
    
}
