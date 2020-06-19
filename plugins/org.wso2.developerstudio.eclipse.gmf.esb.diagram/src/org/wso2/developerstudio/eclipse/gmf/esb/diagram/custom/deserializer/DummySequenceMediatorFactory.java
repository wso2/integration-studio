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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMComment;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.synapse.Mediator;
import org.apache.synapse.Nameable;
import org.apache.synapse.SequenceType;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.aspects.AspectConfigurable;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.CommentMediator;
import org.apache.synapse.util.CommentListUtil;
import org.apache.synapse.config.xml.ValueFactory;

import javax.xml.namespace.QName;

import java.util.Iterator;
import java.util.Properties;

public class DummySequenceMediatorFactory {

    protected static final QName ATT_NAME = new QName("name");
    protected static final QName ATT_VALUE = new QName("value");
    protected static final QName ATT_DESCRIPTION = new QName("description");
    protected static final QName ATT_XPATH = new QName("xpath");
    protected static final QName ATT_REGEX = new QName("regex");
    protected static final QName ATT_SEQUENCE = new QName("sequence");
    protected static final QName ATT_EXPRN = new QName("expression");
    protected static final QName ATT_KEY = new QName("key");
    protected static final QName ATT_SOURCE = new QName("source");
    protected static final QName ATT_TARGET = new QName("target");
    protected static final QName ATT_ONERROR = new QName("onError");
    protected static final QName ATT_EVAL = new QName("evaluator");
    protected static final QName ATT_STATS = new QName(XMLConfigConstants.STATISTICS_ATTRIB_NAME);
    protected static final QName PROP_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "property");
    protected static final QName FEATURE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "feature");
    protected static final QName TARGET_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");
    protected static final QName DESCRIPTION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "description");

    private static final QName SEQUENCE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "sequence");

    public QName getTagQName() {
        return SEQUENCE_Q;
    }

    public SequenceMediator createAnonymousSequence(OMElement elem, Properties properties) {
        SequenceMediator seqMediator = new SequenceMediator();
        OMAttribute e = elem.getAttribute(ATT_ONERROR);
        if (e != null) {
            seqMediator.setErrorHandler(e.getAttributeValue());
        }
        processAuditStatus(seqMediator, elem);
        OMElement descElem = elem.getFirstChildWithName(DESCRIPTION_Q);
        if (descElem != null) {
            seqMediator.setDescription(descElem.getText());
        }
        addChildren(elem, seqMediator, properties);
        seqMediator.setSequenceType(SequenceType.ANON);
        return seqMediator;
    }

    public Mediator createSpecificMediator(OMElement elem, Properties properties) {

        SequenceMediator seqMediator = new SequenceMediator();

        OMAttribute n = elem.getAttribute(ATT_NAME);
        OMAttribute e = elem.getAttribute(ATT_ONERROR);
        if (n != null) {
            seqMediator.setName(n.getAttributeValue());
            if (e != null) {
                seqMediator.setErrorHandler(e.getAttributeValue());
            }
            processAuditStatus(seqMediator, elem);
            addChildren(elem, seqMediator, properties);

        } else {
            n = elem.getAttribute(ATT_KEY);
            if (n != null) {
                // ValueFactory for creating dynamic or static Value
                ValueFactory keyFac = new ValueFactory();
                // create dynamic or static key based on OMElement
                Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, elem);
                // setKey
                seqMediator.setKey(generatedKey);

            }
        }
        CommentListUtil.populateComments(elem, seqMediator.getCommentsList());
        
        return seqMediator;
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
                if (!DESCRIPTION_Q.equals(((OMElement) child).getQName())) { // neglect the description tag
                    Mediator med = DummyMediatorFactoryFinder.getInstance().getMediator((OMElement) child, properties);
                    if (med != null) {
                        m.addChild(med);
                    } else {
                        String msg = "Unknown mediator : " + ((OMElement) child).getLocalName();
                        throw new SynapseException(msg);
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
