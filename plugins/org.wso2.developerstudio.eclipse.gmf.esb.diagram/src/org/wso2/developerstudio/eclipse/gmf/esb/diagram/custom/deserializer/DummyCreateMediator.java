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
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.aspects.AspectConfigurable;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.CloneMediatorFactory;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.builtin.DropMediator;
import org.apache.synapse.mediators.builtin.LoopBackMediator;
import org.apache.synapse.mediators.builtin.RespondMediator;
import org.apache.synapse.mediators.db.AbstractDBMediator;
import org.apache.synapse.mediators.db.Statement;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class DummyCreateMediator {
    private static final QName ATT_NAME = new QName("name");
    private static final QName ATT_VALUE = new QName("value");
    private static final QName ATT_EXPRN = new QName("expression");
    private static final QName ATT_TYPE = new QName("type");
    public static final String FRAGMENT_PROTOCOL = "protocol";
    public static final String FRAGMENT_USER_INFO = "user";
    public static final String FRAGMENT_HOST = "host";
    public static final String FRAGMENT_PORT = "port";
    public static final String FRAGMENT_PATH = "path";
    public static final String FRAGMENT_QUERY = "query";
    public static final String FRAGMENT_REF = "ref";
    public static final String FRAGMENT_FULL_URI = "full";
    public static final String ACTION_SET = "set";
    public static final String ACTION_APPEND = "append";
    public static final String ACTION_PREPEND = "prepend";
    public static final String ACTION_REPLACE = "replace";
    public static final String ACTION_REMOVE = "remove";
    public static final QName URL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "url");
    static final QName DRIVER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "driver");
    static final QName USER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "user");
    static final QName PASS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "password");

    public static final QName DSNAME_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "dsName");
    static final QName ICCLASS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "icClass");

    static final QName STMNT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "statement");
    static final QName SQL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "sql");
    static final QName PARAM_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "parameter");
    static final QName RESULT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "result");
    public static final QName TYPE_QNAME = new QName("type");
    public static final QName DEFAULT_QNAME = new QName("defaultValue");

    static final QName ATT_COLUMN = new QName("column");

    private static Set<String> mediators = new HashSet<>(Arrays.asList("log", "call", "enqueue", "send", "loopback",
	    "respond", "event", "drop", "enrich", "property", "propertyGroup", "filter", "call-template", "sequence", "store", "switch",
	    "validate", "conditionalRouter", "bean", "class", "pojoCommand", "ejb", "script", "spring", "enrich",
	    "makefault", "header", "payloadFactory", "smooks", "rewrite", "xquery", "xslt", "datamapper", "fastXSLT",
	    "cache", "dbreport", "dblookup", "event", "throttle", "transaction", "aggregate", "callout", "clone",
	    "iterate", "foreach", "entitlementService", "oauthService", "builder", "rule", "bam", "publishEvent", "jsontransform"));
    
    private static CloneMediatorFactory cloneMediatorFactory;

    public Mediator createMediator(OMElement omElement, String localName) {

        if (mediators.contains(localName)) {
            return createMediatorObject(omElement, localName);
        }

        throw new SynapseException("No such mediator.");

    }

    private Mediator createMediatorObject(OMElement omElement, String localName) {
        Mediator mediator = null;

        if ("log".equals(localName)) {
	    LogMediatorExtFactory factory = LogMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("send".equals(localName)) {

	    SendMediatorExtFactory factory = SendMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("drop".equals(localName)) {

            mediator = new DropMediator();
            processAuditStatus(mediator, omElement);
            return mediator;

        } else if ("property".equals(localName)) {

	    PropertyMediatorExtFactory factory = PropertyMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);
	    
        } else if ("propertyGroup".equals(localName)) {

        PropertyGroupMediatorExtFactory factory = PropertyGroupMediatorExtFactory.getInstance();
        return factory.createSpecificMediator(omElement);

        } else if ("validate".equals(localName)) {

	    ValidateMediatorExtFactory factory = ValidateMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("payloadFactory".equals(localName)) {

	    PayloadFactoryMediatorExtFactory factory = PayloadFactoryMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("filter".equals(localName)) {
	    FilterMediatorExtFactory factory = FilterMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("call".equals(localName)) {

	    CallMediatorExtFactory factory = CallMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("respond".equals(localName)) {

            mediator = new RespondMediator();
            processAuditStatus(mediator, omElement);
            return mediator;

        } else if ("store".equals(localName)) {

	    StoreMediatorExtFactory factory = StoreMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("loopback".equals(localName)) {

            mediator = new LoopBackMediator();
            processAuditStatus(mediator, omElement);
            return mediator;

        } else if ("header".equals(localName)) {

	    HeaderMediatorExtFactory factory = HeaderMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);


        } else if ("class".equals(localName)) {

            ClassMediatorExtFactory factory = new ClassMediatorExtFactory();
            return factory.createMediator(omElement, null);

        } else if ("cache".equals(localName)) {

            CacheMediatorExtFactory factory = new CacheMediatorExtFactory();
            return factory.createSpecificMediator(omElement, null);

        } else if ("xslt".equals(localName)) {

	    XSLTMediatorExtFactory factory = XSLTMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("datamapper".equals(localName)) {

	    DataMapperMediatorExtFactory factory = DataMapperMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("aggregate".equals(localName)) {

	    AggregateMediatorExtFactory factory = AggregateMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("iterate".equals(localName)) {

	    IterateMediatorExtFactory factory = IterateMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("script".equals(localName)) {

	    ScriptMediatorExtFactory factory = ScriptMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("enrich".equals(localName)) {

	    EnrichMediatorExtFactory factory = EnrichMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);


        } else if ("ejb".equals(localName)) {

            EJBMediatorExtFactory factory = new EJBMediatorExtFactory();
            return factory.createMediator(omElement, null);

        } else if ("switch".equals(localName)) {

	    SwitchMediatorExtFactory factory = SwitchMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("xquery".equals(localName)) {

	    XQueryMediatorExtFactory factory = XQueryMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("clone".equals(localName)) {

	    if (cloneMediatorFactory == null) {
	        cloneMediatorFactory = new CloneMediatorFactory();
	    }
	    return cloneMediatorFactory.createMediator(omElement, null);

        } else if ("builder".equals(localName)) {

            BuilderMediatorExtFactory factory = new BuilderMediatorExtFactory();
            return factory.createMediator(omElement, null);

        } else if ("enqueue".equals(localName)) {

	    EnqueueMediatorExtFactory factory = EnqueueMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("event".equals(localName)) {

	    EventMediatorExtFactory factory = EventMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("call-template".equals(localName)) {

	    CallTemplateMediatorExtFactory factory = CallTemplateMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("conditionalRouter".equals(localName)) {

	    ConditionalRouterMediatorExtFactory factory = ConditionalRouterMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("bean".equals(localName)) {

            BeanMediatorExtFactory factory = new BeanMediatorExtFactory();
            return factory.createMediator(omElement, null);

        } else if ("sequence".equals(localName)) {

	    SequenceMediatorExtFactory factory = SequenceMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);
	    
        } else if ("pojoCommand".equals(localName)) {

            POJOCommandMediatorExtFactory factory = new POJOCommandMediatorExtFactory();
            return factory.createMediator(omElement, null);

        } else if ("spring".equals(localName)) {

	    SpringMediatorExtFactory factory = SpringMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("makefault".equals(localName)) {

	    MakefaultMediatorExtFactory factory = MakefaultMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("smooks".equals(localName)) {

	    SmooksMediatorExtFactory factory = SmooksMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("rewrite".equals(localName)) {

	    RewriteMediatorExtFactory factory = RewriteMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("fastXSLT".equals(localName)) {

	    FastXSLTMediatorExtFactory factory = FastXSLTMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("dbreport".equals(localName)) {

	    DbReportMediatorExtFactory factory = DbReportMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("dblookup".equals(localName)) {

	    DbLookupMediatorExtFactory factory = DbLookupMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);


        } else if ("throttle".equals(localName)) {

	    ThrottleMediatorExtFactory factory = ThrottleMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("transaction".equals(localName)) {

	    TransactionMediatorExtFactory factory = TransactionMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);
	    
        } else if ("callout".equals(localName)) {

            CalloutMediatorExtFactory factory = new CalloutMediatorExtFactory();
            return factory.createMediator(omElement, null);

        } else if ("entitlementService".equals(localName)) {

            EntitlementMediatorExtFactory factory = new EntitlementMediatorExtFactory();
            return factory.createSpecificMediator(omElement, null);

        } else if ("foreach".equals(localName)) {

	    ForEachMediatorExtFactory factory = ForEachMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

	} else if ("oauthService".equals(localName)) {
	    OAuthServiceMediatorExtFactory factory = OAuthServiceMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);

        } else if ("rule".equals(localName)) {

            RuleMediatorExtFactory factory = new RuleMediatorExtFactory();
            return factory.createMediator(omElement, null);

        } else if ("bam".equals(localName)) {

            BamMediatorExtFactory factory = new BamMediatorExtFactory();
            return factory.createSpecificMediator(omElement, null);

        } else if ("publishEvent".equals(localName)) {

	    PublishEventMediatorExtFactory factory = PublishEventMediatorExtFactory.getInstance();
	    return factory.createSpecificMediator(omElement);
	} else if ("jsontransform".equals(localName)) {
	    
	    JsonTransformMediatorExtFactory factory = JsonTransformMediatorExtFactory.getInstance();
	    return factory.createMediator(omElement, null);
	    
	}

        return mediator;
    }

    private void processAuditStatus(Mediator mediator, OMElement mediatorOmElement) {

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

            OMAttribute statistics = mediatorOmElement
                    .getAttribute(new QName(XMLConfigConstants.STATISTICS_ATTRIB_NAME));
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

    protected Map<String, String> collectNameValuePairs(OMElement elem, QName childElementName) {
        Map<String, String> result = new LinkedHashMap<String, String>();
        for (Iterator it = elem.getChildrenWithName(childElementName); it.hasNext();) {
            OMElement child = (OMElement) it.next();
            OMAttribute attName = child.getAttribute(ATT_NAME);
            OMAttribute attValue = child.getAttribute(ATT_VALUE);
            if (attName != null && attValue != null) {
                String name = attName.getAttributeValue().trim();
                String value = attValue.getAttributeValue().trim();
                if (!result.containsKey(name)) {
                    result.put(name, value);
                }
            }
        }
        return result;
    }

    protected static void addAllCommentChildrenToList(OMElement el, List<String> commentList) {
        Iterator it = el.getChildren();

        while (it.hasNext()) {
            OMNode child = (OMNode) it.next();

            if (child instanceof OMComment) {
                if (((OMComment) child).getValue() != null) {
                    commentList.add(((OMComment) child).getValue());
                }
            }
        }
    }

    protected void processStatements(OMElement elem, AbstractDBMediator mediator) {

        Iterator iter = elem.getChildrenWithName(STMNT_Q);
        while (iter.hasNext()) {

            OMElement stmntElt = (OMElement) iter.next();
            Statement statement = new Statement(getValue(stmntElt, SQL_Q));

            Iterator paramIter = stmntElt.getChildrenWithName(PARAM_Q);
            while (paramIter.hasNext()) {

                OMElement paramElt = (OMElement) paramIter.next();
                String xpath = getAttribute(paramElt, ATT_EXPRN);
                String value = getAttribute(paramElt, ATT_VALUE);

                if (xpath != null || value != null) {

                    SynapseXPath xp = null;
                    if (xpath != null) {
                        try {
                            xp = SynapseXPathFactory.getSynapseXPath(paramElt, ATT_EXPRN);

                        } catch (JaxenException e) {
                            // ignore
                        }
                    }
                    statement.addParameter(value, xp, getAttribute(paramElt, ATT_TYPE));
                }
            }

            Iterator resultIter = stmntElt.getChildrenWithName(RESULT_Q);
            while (resultIter.hasNext()) {
                OMElement resultElt = (OMElement) resultIter.next();
                if (getAttribute(resultElt, ATT_NAME) != null || getAttribute(resultElt, ATT_COLUMN) != null) {
                    statement.addResult(getAttribute(resultElt, ATT_NAME), getAttribute(resultElt, ATT_COLUMN));
                }
            }

            mediator.addStatement(statement);
        }
    }

    protected String getValue(OMElement elt, QName qName) {
        OMElement e = elt.getFirstChildWithName(qName);
        if (e != null) {
            return e.getText();
        }
        return null;
    }

    protected String getAttribute(OMElement elt, QName qName) {
        OMAttribute a = elt.getAttribute(qName);
        if (a != null) {
            return a.getAttributeValue();
        }
        return null;
    }

}
