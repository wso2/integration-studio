/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.codehaus.plexus.util.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.SynapseXPathExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.ValidationConstansts;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.LogMediator} model objects into
 * corresponding synapse artifact(s).
 */
public class EnrichMediatorTransformer extends AbstractEsbNodeTransformer {
    private static final String ENV = "envelope";
    private static final String BDY = "body";
    private static final String CUS = "custom";
    private static  final String PROP = "property";

    /**
     * {@inheritDoc}
     */
    public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
        try {
            info.getParentSequence().addChild(createEnrichMediator(subject, false));
            // Transform the log mediator output data flow path.
            doTransform(info, ((EnrichMediator) subject).getOutputConnector());
        } catch (JaxenException e) {
            throw new TransformerException(e);
        } catch (XMLStreamException e) {
            throw new TransformerException(e);
        }
    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        try {
            sequence.addChild(createEnrichMediator(subject, false));
            doTransformWithinSequence(information, ((EnrichMediator) subject).getOutputConnector().getOutgoingLink(),
                    sequence);
        } catch (JaxenException e) {
            throw new TransformerException(e);
        } catch (XMLStreamException e) {
            throw new TransformerException(e);
        }
    }

    public static org.apache.synapse.mediators.elementary.EnrichMediator createEnrichMediator(EsbNode subject, boolean isForValidation)
            throws XMLStreamException, JaxenException {
        // Check subject.
        Assert.isTrue(subject instanceof EnrichMediator, "Invalid subject.");
        EnrichMediator visualEnrich = (EnrichMediator) subject;

        // Configure Enrich mediator.

        org.apache.synapse.mediators.elementary.Source source = new org.apache.synapse.mediators.elementary.Source();
        org.apache.synapse.mediators.elementary.Target target = new org.apache.synapse.mediators.elementary.Target();
        org.apache.synapse.mediators.elementary.EnrichMediator enrichMediator = new org.apache.synapse.mediators.elementary.EnrichMediator();
        setCommonProperties(enrichMediator, visualEnrich);
        {
            // validate source/target types
            String sourceType = visualEnrich.getSourceType().getLiteral();
            String targetType = visualEnrich.getTargetType().getLiteral();
            if ((ENV.equals(sourceType) && !PROP.equals(targetType))
                    || (CUS.equals(sourceType) && ENV.equals(targetType))
                    || (BDY.equals(sourceType) && (ENV.equals(targetType) || BDY.equals(targetType)))) {
                throw new JaxenException("Target type \"" + targetType + "\" does not support source type \""
                        + sourceType + "\". Please change source/target types");
            }

            source.setClone(visualEnrich.isCloneSource());
            // source.setSourceType(visualEnrich.)
            // Log category.
            switch (visualEnrich.getSourceType()) {
            case BODY:
                source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.BODY);
                break;
            case ENVELOPE:
                source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.ENVELOPE);
                break;
            case PROPERTY:
                source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.PROPERTY);
                String prop = visualEnrich.getSourceProperty();
                if (prop != null)
                    source.setProperty(prop);
                break;
            case INLINE:
                source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.INLINE);
                switch (visualEnrich.getInlineType()) {
                case CONTENT:
                    String str = visualEnrich.getSourceXML();
                    if (str != null && str.trim().startsWith("<") && str.trim().endsWith(">")) {
                        source.setInlineOMNode(AXIOMUtil.stringToOM(str));
                    } else {
                        source.setInlineOMNode(OMAbstractFactory.getOMFactory().createOMText(str));
                    }
                    break;
                case KEY:
                    source.setInlineKey(visualEnrich.getInlineRegistryKey().getKeyValue());
                    break;
                }
                break;
            case CUSTOM:
                source.setSourceType(org.apache.synapse.mediators.elementary.EnrichMediator.CUSTOM);
                NamespacedProperty visualSourceXPath = visualEnrich.getSourceXpath();

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
                break;
            }

            // Target.
            switch (visualEnrich.getTargetType()) {
            case BODY:
                target.setTargetType(org.apache.synapse.mediators.elementary.EnrichMediator.BODY);
                break;
            case ENVELOPE:
                target.setTargetType(org.apache.synapse.mediators.elementary.EnrichMediator.ENVELOPE);
                break;
            case PROPERTY:
                target.setTargetType(org.apache.synapse.mediators.elementary.EnrichMediator.PROPERTY);
                String prop = visualEnrich.getTargetProperty();
                if (prop != null)
                    target.setProperty(prop);
                break;
            case CUSTOM:
                target.setTargetType(org.apache.synapse.mediators.elementary.EnrichMediator.CUSTOM);
                NamespacedProperty visualTargetXPath = visualEnrich.getTargetXpath();
                SynapseXPath xPath;
                if(!isForValidation && StringUtils.isEmpty(visualTargetXPath.getPropertyValue())) {
                    // Fill the XPath with a default values, so that we can use synapse serializer
                    xPath = new SynapseXPath(ValidationConstansts.DEFAULT_XPATH_FOR_VALIDATION);
                }
                else {
                    xPath = (SynapseXPath) SynapseXPathExt.createSynapsePath(visualTargetXPath.getPropertyValue());
                }
                Map<String, String> map = visualTargetXPath.getNamespaces();
                Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry<String, String> entry = entries.next();
                    xPath.addNamespace(entry.getKey(), entry.getValue());
                }
                target.setXpath(xPath);
                break;
            }

            switch (visualEnrich.getTargetAction()) {
            case CHILD:
                target.setAction(org.apache.synapse.mediators.elementary.Target.ACTION_ADD_CHILD);
                break;
            case SIBLING:
                target.setAction(org.apache.synapse.mediators.elementary.Target.ACTION_ADD_SIBLING);
                break;
            case REPLACE:
                target.setAction(org.apache.synapse.mediators.elementary.Target.ACTION_REPLACE);
                break;
            case REMOVE:
                target.setAction(org.apache.synapse.mediators.elementary.Target.ACTION_REMOVE);
                break;
            default:
                break;
            }

            enrichMediator.setSource(source);
            enrichMediator.setTarget(target);

        }
        return enrichMediator;
    }

}

