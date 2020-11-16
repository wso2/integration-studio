/*
 * Copyright 2009-2015 WSO2, Inc. (http://wso2.com)
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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.codehaus.plexus.util.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.jaxen.XPathSyntaxException;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

public class CallMediatorTransformer extends AbstractEsbNodeTransformer {

    public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
        org.apache.synapse.mediators.builtin.CallMediator callMediator;
        try {
            callMediator = createCallMediator(subject, false);
            if (callMediator != null) {
                information.getParentSequence().addChild(callMediator);
            }

            TransformationInfo tmpInformation = new TransformationInfo();
            tmpInformation.setParentSequence(information.getParentSequence());
            tmpInformation.setTraversalDirection(information.getTraversalDirection());
            tmpInformation.setOriginInSequence(information.getOriginInSequence());
            tmpInformation.setOriginOutSequence(information.getOriginOutSequence());
            tmpInformation.setPreviousNode(information.getPreviouNode());
            tmpInformation.setSynapseConfiguration(information.getSynapseConfiguration());
            tmpInformation.setCurrentAPI(information.getCurrentAPI());
            tmpInformation.setCurrentProxy(information.getCurrentProxy());
            tmpInformation.setCurrentReferredSequence(information.getCurrentReferredSequence());
            tmpInformation.setMainSequence(information.getMainSequence());
            if (((CallMediator) subject).getEndpointType() == CallMediatorEndpointType.INLINE) {
                doTransform(tmpInformation, ((CallMediator) subject).getEndpointOutputConnector()); // to transform the
                                                                                                    // mediators inside
                                                                                                    // the mediator
            }
            doTransform(information, ((CallMediator) subject).getOutputConnector()); // continue in normal flow
        } catch (JaxenException e) {
            throw new TransformerException(e);
        } catch (XMLStreamException e) {
            throw new TransformerException(e);
        }
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {
        // TODO Auto-generated method stub

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        org.apache.synapse.mediators.builtin.CallMediator callMediator;
        try {
            callMediator = createCallMediator(subject, false);
            if (callMediator != null) {
                sequence.addChild(callMediator);
            }
            if (((CallMediator) subject).getEndpointType() == CallMediatorEndpointType.INLINE) {
                // to transform the mediators inside the mediator
                doTransformWithinSequence(information,
                        ((CallMediator) subject).getEndpointOutputConnector().getOutgoingLink(), sequence);
            }
            // to go in normal flow
            doTransformWithinSequence(information, ((CallMediator) subject).getOutputConnector().getOutgoingLink(),
                    sequence);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        } catch (XMLStreamException e) {
            throw new TransformerException(e);
        }
    }

    public static org.apache.synapse.mediators.builtin.CallMediator createCallMediator(EsbNode subject,
            boolean isForValidation) throws TransformerException, JaxenException, XMLStreamException {
        // Check subject.
        Assert.isTrue(subject instanceof CallMediator, "Invalid subject.");
        CallMediator visualCallMediator = (CallMediator) subject;

        // Configure call mediator.
        org.apache.synapse.mediators.builtin.CallMediator synapseCallMediator = new org.apache.synapse.mediators.builtin.CallMediator();
        setCommonProperties(synapseCallMediator, visualCallMediator);

        if (visualCallMediator.getEndpointType() == CallMediatorEndpointType.XPATH) {
            NamespacedProperty nameSpacedProperty = visualCallMediator.getEndpointXpath();
            Endpoint resolvingEndpoint = getEndpointFromXpath(nameSpacedProperty, isForValidation);
            synapseCallMediator.setEndpoint(resolvingEndpoint);
        } else if (visualCallMediator.getEndpointType() == CallMediatorEndpointType.REGISRTYKEY) {
            RegistryKeyProperty regKey = visualCallMediator.getEndpointRegistrykey();
            IndirectEndpoint indirectEndpoint = new IndirectEndpoint();
            indirectEndpoint.setKey(regKey.getKeyValue());
            synapseCallMediator.setEndpoint(indirectEndpoint);
        } else {
            synapseCallMediator.setEndpoint(null);
        }
        synapseCallMediator.setBlocking(visualCallMediator.isEnableBlockingCalls());
        
        org.apache.synapse.mediators.elementary.Source source = new org.apache.synapse.mediators.elementary.Source();
        org.apache.synapse.mediators.elementary.Target target = new org.apache.synapse.mediators.elementary.Target();
        String sourceType = visualCallMediator.getSourceType().getLiteral();
        String targetType = visualCallMediator.getTargetType().getLiteral();
        switch (visualCallMediator.getSourceType()) {
        case NONE: synapseCallMediator.setSourceAvailable(false); break;
        case BODY: source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.BODY);
        synapseCallMediator.setSourceAvailable(true);
        break;
        case PROPERTY:
            source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.PROPERTY);
            String prop = visualCallMediator.getSourceProperty();
            if (prop != null)
                source.setProperty(prop);
            synapseCallMediator.setSourceAvailable(true);
            break;
        case INLINE:
            source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.INLINE);
            String str = visualCallMediator.getSourcePayload();
            if (str != null && str.trim().startsWith("<") && str.trim().endsWith(">")) {
                source.setInlineOMNode(AXIOMUtil.stringToOM(str));
            } else {
                source.setInlineOMNode(OMAbstractFactory.getOMFactory().createOMText(str));
            }
            synapseCallMediator.setSourceAvailable(true);
            break;
        case CUSTOM:
            source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.CUSTOM);
            NamespacedProperty visualSourceXPath = visualCallMediator.getSourceXPath();

            SynapseXPath xPath;
            if(!isForValidation && StringUtils.isEmpty(visualSourceXPath.getPropertyValue())) {
                // Fill the XPath with a default values, so that we can use synapse serializer
                xPath = new SynapseXPath(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
            }
            else {
                xPath = (SynapseXPath) SynapseXPathExt.createSynapsePath(visualSourceXPath.getPropertyValue());
            }
            Map<String, String> map = visualSourceXPath.getNamespaces();
            Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                xPath.addNamespace(entry.getKey(), entry.getValue());
            }
            source.setXpath(xPath);
            synapseCallMediator.setSourceAvailable(true);
            break;
        }
        switch(visualCallMediator.getTargetType()) {
        case NONE: synapseCallMediator.setTargetAvailable(false);
        break;
        case BODY: target.setTargetType(org.apache.synapse.mediators.elementary.EnrichMediator.BODY);
        synapseCallMediator.setTargetAvailable(true);
        break;
        case PROPERTY:
            target.setTargetType(org.apache.synapse.mediators.elementary.EnrichMediator.PROPERTY);
            String prop = visualCallMediator.getTargetProperty();
            if (prop != null)
                target.setProperty(prop);
            synapseCallMediator.setTargetAvailable(true);
            break;
        }
        
        if(visualCallMediator.getContentType() != null) {
            synapseCallMediator.setSourceMessageType(visualCallMediator.getContentType());
        }
        synapseCallMediator.setSourceForOutboundPayload(source);
        synapseCallMediator.setTargetForInboundPayload(target);
        return synapseCallMediator;
    }

    public static ResolvingEndpoint getEndpointFromXpath(NamespacedProperty nameSpacedProperty, boolean isForValidation)
            throws JaxenException {
        SynapseXPath synapseXPath;
        ResolvingEndpoint resolvingEndpoint;
        if (StringUtils.isEmpty(nameSpacedProperty.getPropertyValue()) && !isForValidation) {
            synapseXPath = new SynapseXPath(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
            resolvingEndpoint = new ResolvingEndpoint();
            resolvingEndpoint.setKeyExpression(synapseXPath);
            return resolvingEndpoint;
        } else {
            synapseXPath = new SynapseXPath(nameSpacedProperty.getPropertyValue());
            for (int i = 0; i < nameSpacedProperty.getNamespaces().keySet().size(); ++i) {
                String prefix = (String) nameSpacedProperty.getNamespaces().keySet().toArray()[i];
                String namespaceUri = nameSpacedProperty.getNamespaces().get(prefix);
                synapseXPath.addNamespace(prefix, namespaceUri);
            }
            resolvingEndpoint = new ResolvingEndpoint();
            resolvingEndpoint.setKeyExpression(synapseXPath);
            return resolvingEndpoint;
        }
    }

}
