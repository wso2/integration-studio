/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMComment;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.synapse.Mediator;
import org.apache.synapse.Nameable;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.aspects.AspectConfigurable;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.AbstractListMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.builtin.CommentMediator;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.apache.synapse.mediators.template.TemplateParam;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

public class DummyTemplateMediatorFactory extends AbstractListMediatorFactory {

    private static final QName TEMPLATE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "template");
    private static final QName TEMPLATE_BODY_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "sequence");
    protected static final QName ATT_NAME = new QName("name");
    protected static final QName ATT_ONERROR = new QName("onError");
    protected static final QName ATT_STATS = new QName(XMLConfigConstants.STATISTICS_ATTRIB_NAME);
    protected static final QName DESCRIPTION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "description");

    /**
     * Element QName Definitions
     */
    public static final QName PARAMETER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "parameter");

    protected Mediator createSpecificMediator(OMElement elem, Properties properties) {
        TemplateMediator templateTemplateMediator = new TemplateMediator();
        OMAttribute nameAttr = elem.getAttribute(ATT_NAME);
        if (nameAttr != null) {
            templateTemplateMediator.setName(nameAttr.getAttributeValue());
        } else {
            templateTemplateMediator.setName("");
        }
        OMAttribute onErrorAttribute = elem.getAttribute(ATT_ONERROR);
        if (onErrorAttribute != null) {
            templateTemplateMediator.setErrorHandler(onErrorAttribute.getAttributeValue());
        }
        processAuditStatus(templateTemplateMediator, elem);
        initParameters(elem, templateTemplateMediator);
        OMElement templateBodyElem = elem.getFirstChildWithName(TEMPLATE_BODY_Q);
        addChildren(templateBodyElem, templateTemplateMediator, properties);
        return templateTemplateMediator;
    }

    private void initParameters(OMElement templateElem, TemplateMediator templateMediator) {
        Iterator subElements = templateElem.getChildElements();
        Collection<TemplateParam> paramNames = new ArrayList<TemplateParam>();
        while (subElements.hasNext()) {
            OMElement child = (OMElement) subElements.next();
            if (child.getQName().equals(PARAMETER_Q)) {
                OMAttribute paramNameAttr = child.getAttribute(ATT_NAME);
                if (paramNameAttr != null) {
                    TemplateParam tempParam = new TemplateParam(paramNameAttr.getAttributeValue(), false, "");
                    paramNames.add(tempParam);
                }
                // child.detach();
            }
        }
        templateMediator.setParameters(paramNames);
    }

    public QName getTagQName() {
        return TEMPLATE_Q;
    }

    protected void processAuditStatus(Mediator mediator, OMElement mediatorOmElement) {

        String name = null;
        if (mediator instanceof Nameable) {
            name = ((Nameable) mediator).getName();
        }
        if (name == null || "".equals(name)) {
            name = SynapseConstants.ANONYMOUS_SEQUENCE;
        }

        if (mediator instanceof AspectConfigurable) {
            AspectConfiguration configuration = new AspectConfiguration(name);
            ((AspectConfigurable) mediator).configure(configuration);

            OMAttribute statistics = mediatorOmElement.getAttribute(ATT_STATS);
            if (statistics != null) {
                String statisticsValue = statistics.getAttributeValue();
                if (statisticsValue != null) {
                    if (XMLConfigConstants.STATISTICS_ENABLE.equals(statisticsValue)) {
                        configuration.enableStatistics();
                    }
                }
            }

            OMAttribute trace = mediatorOmElement
                    .getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, XMLConfigConstants.TRACE_ATTRIB_NAME));
            if (trace != null) {
                String traceValue = trace.getAttributeValue();
                if (traceValue != null) {
                    if (traceValue.equals(XMLConfigConstants.TRACE_ENABLE)) {
                        configuration.enableTracing();
                    }
                }
            }
        }
    }

    protected static void addChildren(OMElement el, ListMediator m, Properties properties) {
        Iterator it = el.getChildren();
        while (it.hasNext()) {
            OMNode child = (OMNode) it.next();
            if (child instanceof OMElement) {
                if (!DESCRIPTION_Q.equals(((OMElement) child).getQName())) {
                    Mediator med = DummyMediatorFactoryFinder.getInstance().getMediator((OMElement) child, properties);
                    if (med != null) {
                        m.addChild(med);
                    }
                }
            } else if (child instanceof OMComment) {
                CommentMediator commendMediator = new CommentMediator();
                commendMediator.setCommentText(((OMComment) child).getValue());
                m.addChild(commendMediator);
            }
        }
    }
}
