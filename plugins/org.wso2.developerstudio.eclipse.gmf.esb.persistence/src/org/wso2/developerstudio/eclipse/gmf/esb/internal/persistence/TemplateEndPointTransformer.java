/*
 * Copyright 2013 WSO2, Inc. (http://wso2.com)
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

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.TemplateEndPointFormPage;

public class TemplateEndPointTransformer extends AbstractEndpointTransformer {

    public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
        // Check subject.
        Assert.isTrue(subject instanceof TemplateEndpoint, "Invalid subject");
        TemplateEndpoint visualEndPoint = (TemplateEndpoint) subject;
        Endpoint synapseEP = create(visualEndPoint, visualEndPoint.getEndPointName());
        setEndpointToSendCallOrProxy(info, visualEndPoint, synapseEP);

        if (!info.isEndPointFound) {
            info.isEndPointFound = true;
            info.firstEndPoint = visualEndPoint;
        }

        if (visualEndPoint.getOutputConnector() != null) {
            if (visualEndPoint.getOutputConnector().getOutgoingLink() != null) {
                InputConnector nextInputConnector = visualEndPoint.getOutputConnector().getOutgoingLink().getTarget();
                if ((!(nextInputConnector instanceof SequenceInputConnector))
                        || ((((Sequence) nextInputConnector.eContainer()).getOutputConnector().get(0)
                                .getOutgoingLink() != null)
                                && (!(((Sequence) nextInputConnector.eContainer()).getOutputConnector().get(0)
                                        .getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))) {
                    info.setParentSequence(info.getOriginOutSequence());
                    info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
                } else if ((visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource()
                        .eContainer() instanceof Sequence)) {
                    info.setParentSequence(info.getCurrentReferredSequence());
                }
            }
        }

        List<EsbNode> transformedMediators = info.getTransformedMediators();
        if (visualEndPoint.getOutputConnector() != null
                && visualEndPoint.getOutputConnector().getOutgoingLink() != null) {
            EsbNode nextElement = (EsbNode) visualEndPoint.getOutputConnector().getOutgoingLink().getTarget()
                    .eContainer();
            if (transformedMediators.contains(nextElement)) {
                return;
            }
            transformedMediators.add(nextElement);
        }

        // Transform endpoint output data flow.
        doTransform(info, visualEndPoint.getOutputConnector());
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {

        Assert.isTrue(subject instanceof TemplateEndpoint, "Invalid subject");
        TemplateEndpoint templateEndPoint = (TemplateEndpoint) subject;
        org.apache.synapse.endpoints.TemplateEndpoint synapseTemplateEP = new org.apache.synapse.endpoints.TemplateEndpoint();

        try {
            createAdvanceOptions(templateEndPoint, synapseTemplateEP);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
        for (TemplateEndpointParameter parameter : templateEndPoint.getParameters()) {
            synapseTemplateEP.addParameter(parameter.getParameterName(), parameter.getParameterValue());
        }
        synapseTemplateEP.setTemplate(templateEndPoint.getTargetTemplate());
        Endpoint endPoint = (Endpoint) synapseTemplateEP;
        endPoints.add(endPoint);

        // Next node may be a Failover endPoint. So that this should be edited
        // to be compatible with that also.
        /*
         * info.setParentSequence(info.getOriginOutSequence());
         * info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
         */

        // Transform endpoint output data flow.

        transformEndpointOutflow(info);

    }

    public org.apache.synapse.endpoints.TemplateEndpoint create(TemplateEndpoint visualEndPoint, String name)
            throws TransformerException {
        TemplateEndpoint templateEndPoint = visualEndPoint;
        org.apache.synapse.endpoints.TemplateEndpoint synapseTemplateEP = new org.apache.synapse.endpoints.TemplateEndpoint();

        if (StringUtils.isNotBlank(name)) {
            synapseTemplateEP.setName(name);
        } else if (StringUtils.isNotBlank(templateEndPoint.getEndPointName())) {
        	synapseTemplateEP.setName(templateEndPoint.getEndPointName());
        }

        try {
            createAdvanceOptions(templateEndPoint, synapseTemplateEP);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        }
        for (TemplateEndpointParameter parameter : templateEndPoint.getParameters()) {
            if (StringUtils.isNotBlank(parameter.getParameterName())
                    && StringUtils.isNotBlank(parameter.getParameterValue())) {
                synapseTemplateEP.addParameter(parameter.getParameterName(), parameter.getParameterValue());
            }
        }
        if (synapseTemplateEP.getAddress() != null && StringUtils.isNotBlank(synapseTemplateEP.getAddress())) {
        	synapseTemplateEP.addParameter("uri", synapseTemplateEP.getAddress());
        }
        synapseTemplateEP.setTemplate(templateEndPoint.getTargetTemplate());

        return synapseTemplateEP;
    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {

        Assert.isTrue(subject instanceof TemplateEndpoint, "Invalid subject");
        TemplateEndpoint visualEndPoint = (TemplateEndpoint) subject;
        Endpoint synapseEP = create(visualEndPoint, visualEndPoint.getEndPointName());
        setEndpointToSendOrCallMediator(sequence, synapseEP);

    }

    public org.apache.synapse.endpoints.TemplateEndpoint create(TemplateEndPointFormPage tempFormPage)
            throws NumberFormatException, JaxenException {
        org.apache.synapse.endpoints.TemplateEndpoint synapseTemplateEP = new org.apache.synapse.endpoints.TemplateEndpoint();

        if (StringUtils.isNotEmpty(tempFormPage.getName())) {
            synapseTemplateEP.setName(tempFormPage.getName());
        }

        createAdvanceOptions(tempFormPage, synapseTemplateEP);

        if (tempFormPage.templateParameterList != null && tempFormPage.templateParameterList.size() > 0) {
            for (TemplateEndpointParameter parameter : tempFormPage.templateParameterList) {
                if (StringUtils.isNotEmpty(parameter.getParameterName())
                        && StringUtils.isNotEmpty(parameter.getParameterValue())) {
                    synapseTemplateEP.addParameter(parameter.getParameterName(), parameter.getParameterValue());
                }
            }
        }

        synapseTemplateEP.setTemplate(tempFormPage.getTempEP_TargetTemp().getText());
        synapseTemplateEP.setDescription(tempFormPage.getTempEP_Description().getText());

        return synapseTemplateEP;

    }

}
