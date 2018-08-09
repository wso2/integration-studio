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

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMComment;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMText;
import org.apache.axis2.util.JavaUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.Mediator;
import org.apache.synapse.MessageContext;
import org.apache.synapse.Nameable;
import org.apache.synapse.SequenceType;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.aspects.AspectConfigurable;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.aspects.flow.statistics.data.artifact.ArtifactHolder;
import org.apache.synapse.commons.evaluators.config.EvaluatorFactoryFinder;
import org.apache.synapse.config.xml.AggregateMediatorFactory;
import org.apache.synapse.config.xml.AnnotatedCommandMediatorFactory;
import org.apache.synapse.config.xml.AnonymousListMediator;
import org.apache.synapse.config.xml.AnonymousListMediatorFactory;
import org.apache.synapse.config.xml.BeanMediatorFactory;
import org.apache.synapse.config.xml.CallMediatorFactory;
import org.apache.synapse.config.xml.CalloutMediatorFactory;
import org.apache.synapse.config.xml.ClassMediatorFactory;
import org.apache.synapse.config.xml.CloneMediatorFactory;
import org.apache.synapse.config.xml.CommentMediatorFactory;
import org.apache.synapse.config.xml.ConditionalRouterMediatorFactory;
import org.apache.synapse.config.xml.DBLookupMediatorFactory;
import org.apache.synapse.config.xml.DBReportMediatorFactory;
import org.apache.synapse.config.xml.DropMediatorFactory;
import org.apache.synapse.config.xml.EJBMediatorFactory;
import org.apache.synapse.config.xml.EnqueueMediatorFactory;
import org.apache.synapse.config.xml.EnrichMediatorFactory;
import org.apache.synapse.config.xml.FaultMediatorFactory;
import org.apache.synapse.config.xml.FilterMediatorFactory;
import org.apache.synapse.config.xml.ForEachMediatorFactory;
import org.apache.synapse.config.xml.HeaderMediatorFactory;
import org.apache.synapse.config.xml.InMediatorFactory;
import org.apache.synapse.config.xml.InvokeMediatorFactory;
import org.apache.synapse.config.xml.IterateMediatorFactory;
import org.apache.synapse.config.xml.LogMediatorFactory;
import org.apache.synapse.config.xml.LoopBackMediatorFactory;
import org.apache.synapse.config.xml.MediatorFactoryFinder;
import org.apache.synapse.config.xml.MediatorPropertyFactory;
import org.apache.synapse.config.xml.MessageStoreMediatorFactory;
import org.apache.synapse.config.xml.OMElementUtils;
import org.apache.synapse.config.xml.OutMediatorFactory;
import org.apache.synapse.config.xml.POJOCommandMediatorFactory;
import org.apache.synapse.config.xml.PayloadFactoryMediatorFactory;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.config.xml.ResourceMapFactory;
import org.apache.synapse.config.xml.RespondMediatorFactory;
import org.apache.synapse.config.xml.SamplingThrottleMediatorFactory;
import org.apache.synapse.config.xml.SendMediatorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.SwitchCase;
import org.apache.synapse.config.xml.SwitchMediatorFactory;
import org.apache.synapse.config.xml.SynapseJsonPathFactory;
import org.apache.synapse.config.xml.SynapseMediatorFactory;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.config.xml.SynapseXPathFactory;
import org.apache.synapse.config.xml.TargetFactory;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.config.xml.TransactionMediatorFactory;
import org.apache.synapse.config.xml.URLRewriteMediatorFactory;
import org.apache.synapse.config.xml.ValidateMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.XSLTMediatorFactory;
import org.apache.synapse.config.xml.endpoints.AddressEndpointFactory;
import org.apache.synapse.config.xml.endpoints.ClassEndpointFactory;
import org.apache.synapse.config.xml.endpoints.DefaultEndpointFactory;
import org.apache.synapse.config.xml.endpoints.DynamicLoadbalanceEndpointFactory;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.config.xml.endpoints.FailoverEndpointFactory;
import org.apache.synapse.config.xml.endpoints.HTTPEndpointFactory;
import org.apache.synapse.config.xml.endpoints.IndirectEndpointFactory;
import org.apache.synapse.config.xml.endpoints.LoadbalanceEndpointFactory;
import org.apache.synapse.config.xml.endpoints.RecipientListEndpointFactory;
import org.apache.synapse.config.xml.endpoints.ResolvingEndpointFactory;
import org.apache.synapse.config.xml.endpoints.SALoadbalanceEndpointFactory;
import org.apache.synapse.config.xml.endpoints.ServiceDynamicLoadbalanceEndpointFactory;
import org.apache.synapse.config.xml.endpoints.TemplateEndpointFactory;
import org.apache.synapse.config.xml.endpoints.WSDLEndpointFactory;
import org.apache.synapse.config.xml.eventing.EventPublisherMediatorFactory;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.ClassEndpoint;
import org.apache.synapse.endpoints.DefaultEndpoint;
import org.apache.synapse.endpoints.DynamicLoadbalanceEndpoint;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.endpoints.SALoadbalanceEndpoint;
import org.apache.synapse.endpoints.ServiceDynamicLoadbalanceEndpoint;
import org.apache.synapse.endpoints.TemplateEndpoint;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.mediators.builtin.CallMediator;
import org.apache.synapse.mediators.builtin.CalloutMediator;
import org.apache.synapse.mediators.builtin.CommentMediator;
import org.apache.synapse.mediators.builtin.DropMediator;
import org.apache.synapse.mediators.builtin.EnqueueMediator;
import org.apache.synapse.mediators.builtin.LogMediator;
import org.apache.synapse.mediators.builtin.LoopBackMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.apache.synapse.mediators.builtin.RespondMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.mediators.builtin.ValidateMediator;
import org.apache.synapse.mediators.db.AbstractDBMediator;
import org.apache.synapse.mediators.db.DBLookupMediator;
import org.apache.synapse.mediators.db.DBReportMediator;
import org.apache.synapse.mediators.db.Statement;
import org.apache.synapse.mediators.eip.Target;
import org.apache.synapse.mediators.eip.aggregator.AggregateMediator;
import org.apache.synapse.mediators.eip.splitter.CloneMediator;
import org.apache.synapse.mediators.eip.splitter.IterateMediator;
import org.apache.synapse.mediators.elementary.EnrichMediator;
import org.apache.synapse.mediators.elementary.Source;
import org.apache.synapse.mediators.ext.ClassMediator;
import org.apache.synapse.mediators.filters.FilterMediator;
import org.apache.synapse.mediators.filters.SwitchMediator;
import org.apache.synapse.mediators.filters.router.ConditionalRoute;
import org.apache.synapse.mediators.filters.router.ConditionalRouterMediator;
import org.apache.synapse.mediators.spring.SpringMediator;
import org.apache.synapse.mediators.store.MessageStoreMediator;
import org.apache.synapse.mediators.template.InvokeMediator;
import org.apache.synapse.mediators.throttle.ThrottleMediator;
import org.apache.synapse.mediators.transaction.TransactionMediator;
import org.apache.synapse.mediators.transform.Argument;
import org.apache.synapse.mediators.transform.FaultMediator;
import org.apache.synapse.mediators.transform.HeaderMediator;
import org.apache.synapse.mediators.transform.PayloadFactoryMediator;
import org.apache.synapse.mediators.transform.XSLTMediator;
import org.apache.synapse.mediators.transform.url.RewriteAction;
import org.apache.synapse.mediators.transform.url.RewriteRule;
import org.apache.synapse.mediators.transform.url.URIFragments;
import org.apache.synapse.mediators.transform.url.URLRewriteMediator;
import org.apache.synapse.mediators.xquery.MediatorBaseVariable;
import org.apache.synapse.mediators.xquery.MediatorCustomVariable;
import org.apache.synapse.mediators.xquery.MediatorVariable;
import org.apache.synapse.mediators.xquery.XQueryMediator;
import org.apache.synapse.mediators.xquery.XQueryMediatorFactory;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.jaxen.JaxenException;
import org.wso2.carbon.mediator.bam.BamMediator;
import org.wso2.carbon.mediator.cache.CacheMediator;
import org.wso2.carbon.mediator.datamapper.DataMapperMediator;
import org.wso2.carbon.mediator.datamapper.config.xml.DataMapperMediatorConstants;
import org.wso2.carbon.mediator.event.EventMediator;
import org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator;
import org.wso2.carbon.mediator.publishevent.Property;
import org.wso2.carbon.mediator.publishevent.PublishEventMediator;
import org.wso2.carbon.mediator.transform.SmooksMediator;
import org.xml.sax.SAXException;
import org.apache.synapse.commons.datasource.DataSourceInformation;
import org.apache.synapse.commons.evaluators.Evaluator;
import org.apache.synapse.commons.evaluators.EvaluatorException;

import net.sf.saxon.s9api.ItemType;
import net.sf.saxon.s9api.XdmNodeKind;

import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.bsf.ScriptMediator;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.net.URI;
import org.wso2.carbon.mediator.transform.Input;
import org.wso2.carbon.mediator.transform.Output;
import javax.naming.Context;

public class DummyCreateMediator {
	private static final QName ATT_NAME = new QName("name");
	private static final QName ATT_VALUE = new QName("value");
	private static final QName ATT_DESCRIPTION = new QName("description");
	private static final QName ATT_XPATH = new QName("xpath");
	private static final QName ATT_REGEX = new QName("regex");
	private static final QName ATT_SEQUENCE = new QName("sequence");
	private static final QName ATT_EXPRN = new QName("expression");
	private static final QName ATT_KEY = new QName("key");
	private static final QName ATT_SOURCE = new QName("source");
	private static final QName ATT_TARGET = new QName("target");
	private static final QName ATT_ONERROR = new QName("onError");
	private static final QName ATT_EVAL = new QName("evaluator");
	private static final QName ATT_STATS = new QName(XMLConfigConstants.STATISTICS_ATTRIB_NAME);
	private static final QName PROP_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "property");
	private static final QName FEATURE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "feature");
	private static final QName TARGET_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");
	private static final QName DESCRIPTION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "description");
	private static final QName INCLUDE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "include");
	private static final QName ATT_TYPE = new QName("type");
	private static final QName ATT_CLONE = new QName("clone");
	private static final QName ATT_ACTION = new QName("action");
	private static final QName ATT_PROPERTY = new QName("property");
	private static final QName REWRITE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "rewrite");
	private static final QName RULE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "rewriterule");
	private static final QName CONDITION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "condition");
	private static final QName ACTION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "action");
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
	private static final QName ATT_FRAGMENT = new QName("fragment");
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
			"respond", "event", "drop", "enrich", "property", "filter", "call-template", "sequence", "store", "switch",
			"validate", "conditionalRouter", "bean", "class", "pojoCommand", "ejb", "script", "spring", "enrich",
			"makefault", "header", "payloadFactory", "smooks", "rewrite", "xquery", "xslt", "datamapper", "fastXSLT",
			"cache", "dbreport", "dblookup", "event", "throttle", "transaction", "aggregate", "callout", "clone",
			"iterate", "foreach", "entitlementService", "oauthService", "builder", "rule", "bam", "publishEvent"));

	/**
	 * SequenceMediatorFactory.class, SendMediatorFactory.class (add for error
	 * persistency), HeaderMediatorFactory.class, FaultMediatorFactory.class,
	 * SwitchMediatorFactory.class, InMediatorFactory.class,
	 * OutMediatorFactory.class, ClassMediatorFactory.class,
	 * ValidateMediatorFactory.class, XSLTMediatorFactory.class,
	 * AnnotatedCommandMediatorFactory.class, POJOCommandMediatorFactory.class,
	 * CloneMediatorFactory.class, IterateMediatorFactory.class,
	 * AggregateMediatorFactory.class, DBReportMediatorFactory.class,
	 * DBLookupMediatorFactory.class, CalloutMediatorFactory.class,
	 * EventPublisherMediatorFactory.class, TransactionMediatorFactory.class,
	 * EnqueueMediatorFactory.class, ConditionalRouterMediatorFactory.class,
	 * SamplingThrottleMediatorFactory.class, URLRewriteMediatorFactory.class,
	 * EnrichMediatorFactory.class, MessageStoreMediatorFactory.class,
	 * TemplateMediatorFactory.class, InvokeMediatorFactory.class,
	 * BeanMediatorFactory.class, EJBMediatorFactory.class,
	 * CallMediatorFactory.class, LoopBackMediatorFactory.class,
	 * RespondMediatorFactory.class, CommentMediatorFactory.class,
	 * ForEachMediatorFactory.class
	 */
	public Mediator createMediator(OMElement omElement, String localName) {
		Mediator mediator = null;

		if (mediators.contains(localName)) {
			return createMEdiator(omElement, localName);
		}

		if (mediator == null) {
			throw new SynapseException("No such mediator.");
		}

		return mediator;
	}

	private Mediator createMEdiator(OMElement omElement, String localName) {
		Mediator mediator = null;

		if ("log".equals(localName)) {

			mediator = new LogMediator();

			OMAttribute level = omElement.getAttribute(new QName("level"));
			OMAttribute category = omElement.getAttribute(new QName("category"));
			OMAttribute separator = omElement.getAttribute(new QName("separator"));

			processAuditStatus(mediator, omElement);

			if (level != null) {
				String levelstr = level.getAttributeValue();
				if ("simple".equals(levelstr)) {
					((LogMediator) mediator).setLogLevel(LogMediator.SIMPLE);
				} else if ("headers".equals(levelstr)) {
					((LogMediator) mediator).setLogLevel(LogMediator.HEADERS);
				} else if ("full".equals(levelstr)) {
					((LogMediator) mediator).setLogLevel(LogMediator.FULL);
				} else if ("custom".equals(levelstr)) {
					((LogMediator) mediator).setLogLevel(LogMediator.CUSTOM);
				} else {
					((LogMediator) mediator).setLogLevel(LogMediator.CUSTOM);
				}
			}

			if (category != null) {
				String catstr = category.getAttributeValue().trim().toUpperCase();
				if ("INFO".equals(catstr)) {
					((LogMediator) mediator).setCategory(LogMediator.CATEGORY_INFO);
				} else if ("TRACE".equals(catstr)) {
					((LogMediator) mediator).setCategory(LogMediator.CATEGORY_TRACE);
				} else if ("DEBUG".equals(catstr)) {
					((LogMediator) mediator).setCategory(LogMediator.CATEGORY_DEBUG);
				} else if ("WARN".equals(catstr)) {
					((LogMediator) mediator).setCategory(LogMediator.CATEGORY_WARN);
				} else if ("ERROR".equals(catstr)) {
					((LogMediator) mediator).setCategory(LogMediator.CATEGORY_ERROR);
				} else if ("FATAL".equals(catstr)) {
					((LogMediator) mediator).setCategory(LogMediator.CATEGORY_FATAL);
				} else {
					((LogMediator) mediator).setCategory(LogMediator.CATEGORY_DEBUG);
				}
			}

			if (separator != null) {
				((LogMediator) mediator).setSeparator(separator.getAttributeValue());
			}

		} else if ("send".equals(localName)) {

			// TODO add setting values for specific endpoints
			mediator = new SendMediator();

			QName SEND_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "send");
			QName ENDPOINT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "endpoint");
			QName RECEIVING_SEQUENCE = new QName(XMLConfigConstants.RECEIVE);
			QName BUILD_MESSAGE = new QName("buildmessage");

			processAuditStatus(mediator, omElement);

			OMElement epElement = omElement.getFirstChildWithName(ENDPOINT_Q);

			if (epElement != null) {

				Endpoint endpoint = null;
				try {
					endpoint = EndpointFactory.getEndpointFromElement(epElement, true, null);
				} catch (Exception e) {

					if (omElement.getAttribute(ATT_KEY) != null) {
						endpoint = new IndirectEndpoint();
					}

					if (omElement.getAttribute(new QName("key-expression")) != null) {
						endpoint = new ResolvingEndpoint();
					}

					if (omElement.getAttribute(new QName("template")) != null) {
						endpoint = new TemplateEndpoint();
					}

					if (omElement
							.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "address")) != null) {
						endpoint = new AddressEndpoint();
					}

					if (omElement
							.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "wsdl")) != null) {
						endpoint = new WSDLEndpoint();
					}

					if (omElement
							.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "default")) != null) {
						endpoint = new DefaultEndpoint();
					}

					if (omElement.getFirstChildWithName(
							new QName(SynapseConstants.SYNAPSE_NAMESPACE, "loadbalance")) != null) {

						if (omElement.getFirstChildWithName(
								new QName(SynapseConstants.SYNAPSE_NAMESPACE, "session")) != null) {
							endpoint = new SALoadbalanceEndpoint();
						} else {
							endpoint = new LoadbalanceEndpoint();
						}
					}

					if (omElement.getFirstChildWithName(
							new QName(SynapseConstants.SYNAPSE_NAMESPACE, "dynamicLoadbalance")) != null) {
						endpoint = new DynamicLoadbalanceEndpoint();
					}

					if (omElement.getFirstChildWithName(
							new QName(SynapseConstants.SYNAPSE_NAMESPACE, "serviceDynamicLoadbalance")) != null) {
						// Enable after synapse fix
						/// endpoint = new ServiceDynamicLoadbalanceEndpoint();
					}

					OMElement foElement = omElement
							.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "failover"));
					if (foElement != null) {
						endpoint = new FailoverEndpoint();
					}

					OMElement rcplElement = omElement
							.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "recipientlist"));
					if (rcplElement != null) {
						endpoint = new RecipientListEndpoint();
					}

					OMElement httpElement = omElement
							.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "http"));
					if (httpElement != null) {
						endpoint = new HTTPEndpoint();
					}

					OMElement classElement = omElement
							.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "class"));
					if (classElement != null) {
						endpoint = new ClassEndpoint();
					}
				}

				if (endpoint != null) {
					((SendMediator) mediator).setEndpoint(endpoint);
				} else {
					endpoint = new AddressEndpoint();
				}
			}

			String receivingSequence = omElement.getAttributeValue(RECEIVING_SEQUENCE);
			if (receivingSequence != null) {
				ValueFactory valueFactory = new ValueFactory();
				Value value = valueFactory.createValue(XMLConfigConstants.RECEIVE, omElement);

				((SendMediator) mediator).setReceivingSequence(value);
			}
			String buildMessage = omElement.getAttributeValue(BUILD_MESSAGE);

			if ("true".equals(buildMessage)) {
				((SendMediator) mediator).setBuildMessage(true);
			}

		} else if ("drop".equals(localName)) {

			mediator = new DropMediator();
			processAuditStatus(mediator, omElement);

		} else if ("property".equals(localName)) {

			QName ATT_SCOPE = new QName("scope");
			QName ATT_ACTION = new QName("action");
			QName ATT_TYPE = new QName("type");
			QName ATT_PATTERN = new QName("pattern");
			QName ATT_GROUP = new QName("group");

			mediator = new PropertyMediator();

			OMAttribute name = omElement.getAttribute(ATT_NAME);
			OMAttribute value = omElement.getAttribute(ATT_VALUE);
			OMAttribute expression = omElement.getAttribute(ATT_EXPRN);
			OMAttribute scope = omElement.getAttribute(ATT_SCOPE);
			OMAttribute action = omElement.getAttribute(ATT_ACTION);
			OMAttribute type = omElement.getAttribute(ATT_TYPE);
			OMAttribute pattern = omElement.getAttribute(ATT_PATTERN);
			OMAttribute group = omElement.getAttribute(ATT_GROUP);

			OMElement valueElement = omElement.getFirstElement();

			if (name != null) {
				((PropertyMediator) mediator).setName(name.getAttributeValue());
			}

			String dataType = null;
			if (type != null) {
				dataType = type.getAttributeValue();
			}

			if (value != null) {
				((PropertyMediator) mediator).setValue(value.getAttributeValue(), dataType);

			} else if (valueElement != null) {
				((PropertyMediator) mediator).setValueElement(valueElement.cloneOMElement());

			} else if (expression != null) {
				try {
					((PropertyMediator) mediator).setExpression(SynapsePathFactory.getSynapsePath(omElement, ATT_EXPRN),
							dataType);
				} catch (JaxenException e) {
					// ignore
				}
			}

			if (pattern != null) {
				((PropertyMediator) mediator).setPattern(Pattern.compile(pattern.getAttributeValue()));
				if (group != null) {
					int groupValue = Integer.parseInt(group.getAttributeValue());
					if (groupValue >= 0) {
						((PropertyMediator) mediator).setGroup(groupValue);
					}
				}
			}

			if (action != null && "remove".equals(action.getAttributeValue())) {
				((PropertyMediator) mediator).setAction(PropertyMediator.ACTION_REMOVE);
			}

			if (scope != null) {
				((PropertyMediator) mediator).setScope(scope.getAttributeValue());
			}

			processAuditStatus(mediator, omElement);

		} else if ("validate".equals(localName)) {

			QName VALIDATE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "validate");
			QName ON_FAIL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "on-fail");
			QName SCHEMA_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "schema");
			QName ATT_CACHE_SCHEMA = new QName("cache-schema");

			mediator = new ValidateMediator();

			List<Value> schemaKeys = new ArrayList<Value>();
			Iterator schemas = omElement.getChildrenWithName(SCHEMA_Q);

			while (schemas.hasNext()) {
				Object o = schemas.next();
				if (o instanceof OMElement) {
					OMElement omElem = (OMElement) o;
					OMAttribute keyAtt = omElem.getAttribute(ATT_KEY);
					if (keyAtt != null) {
						ValueFactory keyFac = new ValueFactory();
						Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElem);
						schemaKeys.add(generatedKey);
					}
				}
			}

			if (schemaKeys.size() != 0) {
				((ValidateMediator) mediator).setSchemaKeys(schemaKeys);
			}

			OMAttribute attSource = omElement.getAttribute(ATT_SOURCE);

			if (attSource != null) {
				try {
					if (attSource.getAttributeValue() != null) {
						((ValidateMediator) mediator)
								.setSource(SynapsePathFactory.getSynapsePath(omElement, ATT_SOURCE));
					}
				} catch (JaxenException e) {
					// ignore
				}
			}

			OMAttribute attSchemaCache = omElement.getAttribute(ATT_CACHE_SCHEMA);
			if (attSchemaCache != null) {
				final boolean cacheSchema = Boolean.parseBoolean(attSchemaCache.getAttributeValue());
				((ValidateMediator) mediator).setCacheSchema(cacheSchema);
			}

			((ValidateMediator) mediator).setResourceMap(ResourceMapFactory.createResourceMap(omElement));

			OMElement onFail = null;
			Iterator iterator = omElement.getChildrenWithName(ON_FAIL_Q);
			if (iterator.hasNext()) {
				onFail = (OMElement) iterator.next();
			}

			if (onFail != null && onFail.getChildElements().hasNext()) {
				addChildren(onFail, (ValidateMediator) mediator, null);
			}

			processAuditStatus(mediator, omElement);
			for (Map.Entry<String, String> entry : collectNameValuePairs(omElement,
					new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "feature")).entrySet()) {
				String value = entry.getValue();
				boolean isFeatureEnabled = true;
				if ("true".equals(value)) {
					isFeatureEnabled = true;
				} else if ("false".equals(value)) {
					isFeatureEnabled = false;
				}
				try {
					((ValidateMediator) mediator).addFeature(entry.getKey(), isFeatureEnabled);
				} catch (SAXException e) {
					// ignore
				}
			}

		} else if ("payloadFactory".equals(localName)) {

			QName PAYLOAD_FACTORY_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "payloadFactory");

			QName FORMAT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "format");
			QName ARGS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "args");
			QName ATT_LITERAL = new QName("literal");

			QName TYPE_Q = new QName("media-type");

			String JSON_TYPE = "json";
			String XML_TYPE = "xml";
			String TEXT_TYPE = "text";

			mediator = new PayloadFactoryMediator();

			processAuditStatus(mediator, omElement);
			String mediaTypeValue = omElement.getAttributeValue(TYPE_Q);

			if (mediaTypeValue != null) {
				((PayloadFactoryMediator) mediator).setType(mediaTypeValue);
			} else {
				((PayloadFactoryMediator) mediator).setType(XML_TYPE);
			}

			OMElement formatElem = omElement.getFirstChildWithName(FORMAT_Q);
			if (formatElem != null) {
				OMAttribute n = formatElem.getAttribute(ATT_KEY);
				if (n == null) {
					OMElement copy = formatElem.cloneOMElement();
					removeIndentations(copy);

					if (mediaTypeValue != null
							&& (mediaTypeValue.contains(JSON_TYPE) || mediaTypeValue.contains(TEXT_TYPE))) {
						((PayloadFactoryMediator) mediator).setFormat(copy.getText());
					} else {
						((PayloadFactoryMediator) mediator).setFormat(copy.getFirstElement().toString());
					}

				} else {
					ValueFactory keyFac = new ValueFactory();
					Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, formatElem);
					((PayloadFactoryMediator) mediator).setFormatKey(generatedKey);
					((PayloadFactoryMediator) mediator).setFormatDynamic(true);

				}
			}

			OMElement argumentsElem = omElement.getFirstChildWithName(ARGS_Q);

			if (argumentsElem != null) {

				Iterator itr = argumentsElem.getChildElements();

				while (itr.hasNext()) {
					OMElement argElem = (OMElement) itr.next();
					Argument arg = new Argument();
					String value;

					boolean isLiteral = false;
					String isLiteralString = argElem.getAttributeValue(ATT_LITERAL);
					if (isLiteralString != null) {
						isLiteral = Boolean.parseBoolean(isLiteralString);

					}
					arg.setLiteral(isLiteral);

					if ((value = argElem.getAttributeValue(ATT_VALUE)) != null) {

						arg.setValue(value);
						arg.setExpression(null);
						((PayloadFactoryMediator) mediator).addPathArgument(arg);

					} else if ((value = argElem.getAttributeValue(ATT_EXPRN)) != null) {

						if (value.trim().length() > 0) {

							try {

								String evaluator = argElem.getAttributeValue(new QName("evaluator"));
								if (evaluator != null && evaluator.equals(JSON_TYPE)) {
									if (value.startsWith("json-eval(")) {
										value = value.substring(10, value.length() - 1);
									}
									arg.setExpression(SynapseJsonPathFactory.getSynapseJsonPath(value));

									arg.getExpression().setPathType(SynapsePath.JSON_PATH);
									((PayloadFactoryMediator) mediator).addPathArgument(arg);
								} else {
									SynapseXPath sxp = SynapseXPathFactory.getSynapseXPath(argElem, ATT_EXPRN);
									sxp.setForceDisableStreamXpath(Boolean.TRUE);
									arg.setExpression(sxp);
									arg.getExpression().setPathType(SynapsePath.X_PATH);
									((PayloadFactoryMediator) mediator).addPathArgument(arg);
								}
							} catch (JaxenException e) {
								// ignore
							}

						}
					}
				}

			}

		} else if ("filter".equals(localName)) {

			mediator = new FilterMediator();

			QName THEN_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "then");
			QName ELSE_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "else");

			OMAttribute attXpath = omElement.getAttribute(ATT_XPATH);
			OMAttribute attSource = omElement.getAttribute(ATT_SOURCE);
			OMAttribute attRegex = omElement.getAttribute(ATT_REGEX);

			if (attXpath != null) {
				if (attXpath.getAttributeValue() != null && attXpath.getAttributeValue().trim().length() > 0) {
					try {
						((FilterMediator) mediator).setXpath(SynapsePathFactory.getSynapsePath(omElement, ATT_XPATH));
					} catch (JaxenException e) {
						// ignore
					}
				}

			} else if (attSource != null && attRegex != null) {

				if ((attSource.getAttributeValue() != null && attSource.getAttributeValue().trim().length() > 0)
						|| (attRegex.getAttributeValue() != null && attRegex.getAttributeValue().trim().length() > 0)) {

					try {
						((FilterMediator) mediator).setSource(SynapsePathFactory.getSynapsePath(omElement, ATT_SOURCE));
					} catch (JaxenException e) {
						// ignore
					}

					try {
						((FilterMediator) mediator).setRegex(Pattern.compile(attRegex.getAttributeValue()));
					} catch (PatternSyntaxException pse) {
						// ignore
					}
				}

			}

			processAuditStatus(mediator, omElement);

			OMElement thenElem = omElement.getFirstChildWithName(THEN_Q);

			if (thenElem != null) {

				((FilterMediator) mediator).setThenElementPresent(true);
				OMAttribute sequenceAttr = thenElem.getAttribute(ATT_SEQUENCE);

				if (sequenceAttr != null && sequenceAttr.getAttributeValue() != null) {
					((FilterMediator) mediator).setThenKey(sequenceAttr.getAttributeValue());

				} else {
					addChildren(thenElem, (FilterMediator) mediator, null);
				}

				OMElement elseElem = omElement.getFirstChildWithName(ELSE_Q);
				if (elseElem != null) {

					sequenceAttr = elseElem.getAttribute(ATT_SEQUENCE);
					if (sequenceAttr != null && sequenceAttr.getAttributeValue() != null) {
						((FilterMediator) mediator).setElseKey(sequenceAttr.getAttributeValue());

					} else {
						AnonymousListMediator listMediator = AnonymousListMediatorFactory
								.createAnonymousListMediator(elseElem, null);
						((FilterMediator) mediator).setElseMediator(listMediator);
					}
				}

			} else {

				((FilterMediator) mediator).setThenElementPresent(false);
				addChildren(omElement, (FilterMediator) mediator, null);
			}

		} else if ("call".equals(localName)) {

			mediator = new CallMediator();

			QName ENDPOINT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "endpoint");
			QName BLOCKING_Q = new QName("blocking");
			QName ATT_INIT_AXIS2_CLIENT_OPTIONS = new QName("initAxis2ClientOptions");
			QName ATT_AXIS2XML = new QName("axis2xml");
			QName ATT_REPOSITORY = new QName("repository");

			processAuditStatus(mediator, omElement);

			OMElement epElement = omElement.getFirstChildWithName(ENDPOINT_Q);
			if (epElement != null) {
				Endpoint endpoint = EndpointFactory.getEndpointFromElement(epElement, true, null);
				if (endpoint != null) {
					((CallMediator) mediator).setEndpoint(endpoint);
				}
			}

			OMAttribute blockingAtt = omElement.getAttribute(BLOCKING_Q);
			if (blockingAtt != null) {

				((CallMediator) mediator).setBlocking(Boolean.parseBoolean(blockingAtt.getAttributeValue()));
				if (((CallMediator) mediator).isBlocking()) {
					OMAttribute initAxis2ClientOptions = omElement.getAttribute(ATT_INIT_AXIS2_CLIENT_OPTIONS);
					OMAttribute axis2xmlAttr = omElement.getAttribute(ATT_AXIS2XML);
					OMAttribute repoAttr = omElement.getAttribute(ATT_REPOSITORY);

					if (initAxis2ClientOptions != null) {
						((CallMediator) mediator)
								.setInitClientOptions(Boolean.parseBoolean(initAxis2ClientOptions.getAttributeValue()));
					}

					if (axis2xmlAttr != null && axis2xmlAttr.getAttributeValue() != null) {
						File axis2xml = new File(axis2xmlAttr.getAttributeValue());
						if (axis2xml.exists() && axis2xml.isFile()) {
							((CallMediator) mediator).setAxis2xml(axis2xmlAttr.getAttributeValue());
						} else {
							// ignore
						}
					}

					if (repoAttr != null && repoAttr.getAttributeValue() != null) {
						File repo = new File(repoAttr.getAttributeValue());
						if (repo.exists() && repo.isDirectory()) {
							((CallMediator) mediator).setClientRepository(repoAttr.getAttributeValue());
						} else {
							// ignore
						}
					}
				}
			}

		} else if ("respond".equals(localName)) {

			mediator = new RespondMediator();
			processAuditStatus(mediator, omElement);

		} else if ("store".equals(localName)) {

			mediator = new MessageStoreMediator();

			QName STORE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "store");
			QName ATT_MESSAGE_STORE = new QName("messageStore");
			QName ATT_SEQUENCE = new QName("sequence");

			processAuditStatus(mediator, omElement);

			OMAttribute nameAtt = omElement.getAttribute(ATT_NAME);
			if (nameAtt != null) {
				((MessageStoreMediator) mediator).setName(nameAtt.getAttributeValue());
			}

			OMAttribute messageStoreNameAtt = omElement.getAttribute(ATT_MESSAGE_STORE);

			if (messageStoreNameAtt != null) {
				if (checkForExpression(messageStoreNameAtt)) {
					String path = messageStoreNameAtt.getAttributeValue().substring(1,
							messageStoreNameAtt.getAttributeValue().length() - 1);
					try {
						((MessageStoreMediator) mediator)
								.setMessageStoreExp(SynapsePathFactory.getSynapsePath(omElement, path));
					} catch (JaxenException e) {
						// ignore
					}
				} else {
					((MessageStoreMediator) mediator).setMessageStoreName(messageStoreNameAtt.getAttributeValue());
				}
			} else {
				// ignore
			}

			OMAttribute sequenceAtt = omElement.getAttribute(ATT_SEQUENCE);

			if (sequenceAtt != null) {
				((MessageStoreMediator) mediator).setOnStoreSequence(sequenceAtt.getAttributeValue());
			}

		} else if ("loopback".equals(localName)) {

			mediator = new LoopBackMediator();
			processAuditStatus(mediator, omElement);

		} else if ("header".equals(localName)) {

			QName HEADER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "header");
			QName ATT_ACTION = new QName("action");
			QName ATT_SCOPE = new QName("scope");

			mediator = new HeaderMediator();

			OMAttribute name = omElement.getAttribute(ATT_NAME);
			OMAttribute value = omElement.getAttribute(ATT_VALUE);
			OMAttribute exprn = omElement.getAttribute(ATT_EXPRN);
			OMAttribute action = omElement.getAttribute(ATT_ACTION);
			OMAttribute scope = omElement.getAttribute(ATT_SCOPE);

			if (name != null || name.getAttributeValue() != null) {
				if (scope == null || scope.getAttributeValue().equals(XMLConfigConstants.SCOPE_DEFAULT)) {
					String nameAtt = name.getAttributeValue();
					int colonPos = nameAtt.indexOf(":");
					if (colonPos != -1) {
						String prefix = nameAtt.substring(0, colonPos);
						String namespaceURI = OMElementUtils.getNameSpaceWithPrefix(prefix, omElement);
						if (namespaceURI != null) {
							((HeaderMediator) mediator)
									.setQName(new QName(namespaceURI, nameAtt.substring(colonPos + 1), prefix));
						}
					} else {
						if (SynapseConstants.HEADER_TO.equals(nameAtt) || SynapseConstants.HEADER_FROM.equals(nameAtt)
								|| SynapseConstants.HEADER_ACTION.equals(nameAtt)
								|| SynapseConstants.HEADER_FAULT.equals(nameAtt)
								|| SynapseConstants.HEADER_REPLY_TO.equals(nameAtt)
								|| SynapseConstants.HEADER_RELATES_TO.equals(nameAtt)) {

							((HeaderMediator) mediator).setQName(new QName(nameAtt));
						}
					}
				} else {
					((HeaderMediator) mediator).setQName(new QName(name.getAttributeValue()));
				}
			}

			if (scope != null) {
				String valueStr = scope.getAttributeValue();
				((HeaderMediator) mediator).setScope(valueStr);
			}

			processAuditStatus(mediator, omElement);

			if (action != null && "remove".equals(action.getAttributeValue())) {
				((HeaderMediator) mediator).setAction(HeaderMediator.ACTION_REMOVE);
			}

			if (value != null && value.getAttributeValue() != null) {
				((HeaderMediator) mediator).setValue(value.getAttributeValue());

			} else if (exprn != null && exprn.getAttributeValue() != null) {
				try {
					((HeaderMediator) mediator)
							.setExpression(SynapseXPathFactory.getSynapseXPath(omElement, ATT_EXPRN));
				} catch (JaxenException je) {
					// ignore
				}

			} else if (((HeaderMediator) mediator).isImplicit()) {
				Iterator i = omElement.getChildElements();
				if (i != null) {
					for (; i.hasNext();) {
						((HeaderMediator) mediator).addEmbeddedXml((OMElement) i.next());
					}
				}
			}

		} else if ("class".equals(localName)) {

			ClassMediatorExtFactory factory = new ClassMediatorExtFactory();
			mediator = factory.createMediator(omElement, null);

		} else if ("cache".equals(localName)) {

			CacheMediatorExtFactory factory = new CacheMediatorExtFactory();
			mediator = factory.createSpecificMediator(omElement, null);

		} else if ("xslt".equals(localName)) {

			mediator = new XSLTMediator();

			QName TAG_NAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "xslt");
			QName ATTRIBUTE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "attribute");
			QName ATT_USECACHE = new QName("useCache");

			OMAttribute attXslt = omElement.getAttribute(ATT_KEY);
			OMAttribute attSource = omElement.getAttribute(ATT_SOURCE);
			OMAttribute attTarget = omElement.getAttribute(ATT_TARGET);
			OMAttribute attUseCache = omElement.getAttribute(ATT_USECACHE);

			if (attXslt != null) {
				ValueFactory keyFac = new ValueFactory();
				Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

				((XSLTMediator) mediator).setXsltKey(generatedKey);
			} else {
				// ignore
			}

			if (attSource != null) {
				try {
					((XSLTMediator) mediator).setSourceXPathString(attSource.getAttributeValue());
					((XSLTMediator) mediator).setSource(SynapseXPathFactory.getSynapseXPath(omElement, ATT_SOURCE));

				} catch (JaxenException e) {
					// ignore
				}
			}

			if (attTarget != null) {
				((XSLTMediator) mediator).setTargetPropertyName(attTarget.getAttributeValue());
			}

			if (attUseCache != null) {
				((XSLTMediator) mediator).setUseCache(Boolean.parseBoolean(attUseCache.getAttributeValue()));
			}

			processAuditStatus(mediator, omElement);

			for (Map.Entry<String, String> entry : collectNameValuePairs(omElement, FEATURE_Q).entrySet()) {
				String value = entry.getValue();
				boolean isFeatureEnabled;
				if ("true".equals(value)) {
					isFeatureEnabled = true;
				} else {
					isFeatureEnabled = false;
				}
				((XSLTMediator) mediator).addFeature(entry.getKey(), isFeatureEnabled);
			}

			for (Map.Entry<String, String> entry : collectNameValuePairs(omElement, ATTRIBUTE_Q).entrySet()) {
				((XSLTMediator) mediator).addAttribute(entry.getKey(), entry.getValue());
			}

			((XSLTMediator) mediator).addAllProperties(MediatorPropertyFactory.getMediatorProperties(omElement));

			((XSLTMediator) mediator).setResourceMap(ResourceMapFactory.createResourceMap(omElement));

		} else if ("datamapper".equals(localName)) {

			mediator = new DataMapperMediator();

			OMAttribute configKeyAttribute = omElement.getAttribute(new QName(DataMapperMediatorConstants.CONFIG));
			OMAttribute inputSchemaKeyAttribute = omElement
					.getAttribute(new QName(DataMapperMediatorConstants.INPUT_SCHEMA));
			OMAttribute outputSchemaKeyAttribute = omElement
					.getAttribute(new QName(DataMapperMediatorConstants.OUTPUT_SCHEMA));
			OMAttribute inputTypeAttribute = omElement.getAttribute(new QName(DataMapperMediatorConstants.INPUT_TYPE));
			OMAttribute outputTypeAttribute = omElement
					.getAttribute(new QName(DataMapperMediatorConstants.OUTPUT_TYPE));

			ValueFactory keyFac = new ValueFactory();

			if (configKeyAttribute != null) {
				Value configKeyValue = keyFac.createValue(configKeyAttribute.getLocalName(), omElement);
				((DataMapperMediator) mediator).setMappingConfigurationKey(configKeyValue);
			} else {
				// ignore
			}

			if (inputSchemaKeyAttribute != null) {
				Value inputSchemaKeyValue = keyFac.createValue(inputSchemaKeyAttribute.getLocalName(), omElement);
				((DataMapperMediator) mediator).setInputSchemaKey(inputSchemaKeyValue);
			} else {
				// ignore
			}

			if (outputSchemaKeyAttribute != null) {
				Value outputSchemaKeyValue = keyFac.createValue(outputSchemaKeyAttribute.getLocalName(), omElement);
				((DataMapperMediator) mediator).setOutputSchemaKey(outputSchemaKeyValue);
			} else {
				// ignore
			}

			if (inputTypeAttribute != null) {
				((DataMapperMediator) mediator).setInputType(inputTypeAttribute.getAttributeValue());
			} else {
				// ignore
			}

			if (outputTypeAttribute != null) {
				((DataMapperMediator) mediator).setOutputType(outputTypeAttribute.getAttributeValue());
			} else {
				// ignore
			}

			processAuditStatus(mediator, omElement);

		} else if ("aggregate".equals(localName)) {

			mediator = new AggregateMediator();

			QName AGGREGATE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "aggregate");
			QName CORELATE_ON_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "correlateOn");
			QName COMPLETE_CONDITION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "completeCondition");
			QName MESSAGE_COUNT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "messageCount");
			QName ON_COMPLETE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "onComplete");

			QName EXPRESSION_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "expression");
			QName TIMEOUT_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "timeout");
			QName MIN_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "min");
			QName MAX_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "max");
			QName SEQUENCE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "sequence");
			QName ID_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "id");
			QName ENCLOSING_ELEMENT_PROPERTY = new QName(XMLConfigConstants.NULL_NAMESPACE, "enclosingElementProperty");

			processAuditStatus(mediator, omElement);

			OMAttribute id = omElement.getAttribute(ID_Q);
			if (id != null) {
				((AggregateMediator) mediator).setId(id.getAttributeValue());
			}

			OMElement corelateOn = omElement.getFirstChildWithName(CORELATE_ON_Q);
			if (corelateOn != null) {
				OMAttribute corelateExpr = corelateOn.getAttribute(EXPRESSION_Q);
				if (corelateExpr != null) {
					try {
						((AggregateMediator) mediator)
								.setCorrelateExpression(SynapseXPathFactory.getSynapseXPath(corelateOn, EXPRESSION_Q));
					} catch (JaxenException e) {
						// ignore
					}
				}
			}

			OMElement completeCond = omElement.getFirstChildWithName(COMPLETE_CONDITION_Q);
			if (completeCond != null) {
				OMAttribute completeTimeout = completeCond.getAttribute(TIMEOUT_Q);
				if (completeTimeout != null) {
					((AggregateMediator) mediator)
							.setCompletionTimeoutMillis(Long.parseLong(completeTimeout.getAttributeValue()) * 1000);
				}

				OMElement messageCount = completeCond.getFirstChildWithName(MESSAGE_COUNT_Q);
				if (messageCount != null) {
					OMAttribute min = messageCount.getAttribute(MIN_Q);
					if (min != null) {
						((AggregateMediator) mediator)
								.setMinMessagesToComplete(new ValueFactory().createValue("min", messageCount));
					}

					OMAttribute max = messageCount.getAttribute(MAX_Q);
					if (max != null) {
						((AggregateMediator) mediator)
								.setMaxMessagesToComplete(new ValueFactory().createValue("max", messageCount));
					}
				}
			}

			OMElement onComplete = omElement.getFirstChildWithName(ON_COMPLETE_Q);
			if (onComplete != null) {

				OMAttribute aggregateExpr = onComplete.getAttribute(EXPRESSION_Q);
				if (aggregateExpr != null) {
					try {
						((AggregateMediator) mediator).setAggregationExpression(
								SynapseXPathFactory.getSynapseXPath(onComplete, EXPRESSION_Q));
					} catch (JaxenException e) {
						// ignore
					}
				}

				OMAttribute enclosingElementPropertyName = onComplete.getAttribute(ENCLOSING_ELEMENT_PROPERTY);
				if (enclosingElementPropertyName != null) {
					((AggregateMediator) mediator)
							.setEnclosingElementPropertyName(enclosingElementPropertyName.getAttributeValue());
				}

				OMAttribute onCompleteSequence = onComplete.getAttribute(SEQUENCE_Q);
				if (onCompleteSequence != null) {
					((AggregateMediator) mediator).setOnCompleteSequenceRef(onCompleteSequence.getAttributeValue());
				} else if (onComplete.getFirstElement() != null) {
					((AggregateMediator) mediator).setOnCompleteSequence(
							(new SequenceMediatorFactory()).createAnonymousSequence(onComplete, null));
				} else {
					SequenceMediator sequence = new SequenceMediator();
					sequence.addChild(new DropMediator());
					((AggregateMediator) mediator).setOnCompleteSequence(sequence);
				}
			}

			addAllCommentChildrenToList(omElement, ((AggregateMediator) mediator).getCommentsList());

		} else if ("iterate".equals(localName)) {

			mediator = new IterateMediator();

			QName ITERATE_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "iterate");
			QName ATT_CONTPAR = new QName("continueParent");
			QName ATT_PREPLD = new QName("preservePayload");
			QName ATT_ATTACHPATH = new QName("attachPath");
			QName ATT_SEQUENCIAL = new QName("sequential");
			QName ID_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "id");

			processAuditStatus(mediator, omElement);

			OMAttribute id = omElement.getAttribute(ID_Q);
			if (id != null) {
				((IterateMediator) mediator).setId(id.getAttributeValue());
			}

			OMAttribute continueParent = omElement.getAttribute(ATT_CONTPAR);
			if (continueParent != null) {
				((IterateMediator) mediator).setContinueParent(Boolean.valueOf(continueParent.getAttributeValue()));
			}

			OMAttribute preservePayload = omElement.getAttribute(ATT_PREPLD);
			if (preservePayload != null) {
				((IterateMediator) mediator).setPreservePayload(Boolean.valueOf(preservePayload.getAttributeValue()));
			}

			OMAttribute expression = omElement.getAttribute(ATT_EXPRN);
			if (expression != null) {
				try {
					((IterateMediator) mediator)
							.setExpression(SynapseXPathFactory.getSynapseXPath(omElement, ATT_EXPRN));
				} catch (JaxenException e) {
					// ignore
				}
			}

			OMAttribute attachPath = omElement.getAttribute(ATT_ATTACHPATH);
			String attachPathValue = ".";
			if (attachPath != null) {
				attachPathValue = attachPath.getAttributeValue();
			}

			try {
				SynapseXPath xp = new SynapseXPath(attachPathValue);
				Log log = LogFactory.getLog(IterateMediatorFactory.class);
				OMElementUtils.addNameSpaces(xp, omElement, log);
				((IterateMediator) mediator).setAttachPath(xp);
			} catch (JaxenException e) {
				// ignore
			}

			boolean asynchronous = true;
			OMAttribute asynchronousAttr = omElement.getAttribute(ATT_SEQUENCIAL);
			if (asynchronousAttr != null && asynchronousAttr.getAttributeValue().equals("true")) {
				asynchronous = false;
			}

			OMElement targetElement = omElement.getFirstChildWithName(TARGET_Q);
			if (targetElement != null) {
				Target target = TargetFactory.createTarget(targetElement, null);
				if (target != null) {
					target.setAsynchronous(asynchronous);
					((IterateMediator) mediator).setTarget(target);
				}
			}

			addAllCommentChildrenToList(omElement, ((IterateMediator) mediator).getCommentsList());

		} else if ("script".equals(localName)) {

			OMAttribute keyAtt = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
			OMAttribute langAtt = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "language"));
			OMAttribute functionAtt = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "function"));

			Map<Value, Object> includeKeysMap = getIncludeKeysMap(omElement);

			if (keyAtt != null && langAtt != null) {

				ValueFactory keyFac = new ValueFactory();
				Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

				String functionName = (functionAtt == null ? null : functionAtt.getAttributeValue());
				mediator = new ScriptMediator(langAtt.getAttributeValue(), includeKeysMap, generatedKey, functionName,
						null);
			} else if (langAtt != null) {
				mediator = new ScriptMediator(langAtt.getAttributeValue(), omElement.getText(), null);
			} else {
				mediator = new ScriptMediator("javascript", omElement.getText(), null);
			}

			processAuditStatus(mediator, omElement);

		} else if ("enrich".equals(localName)) {

			mediator = new EnrichMediator();

			QName SOURCE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "source");
			QName TARGET_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");

			processAuditStatus(mediator, omElement);

			OMElement sourceEle = omElement.getFirstChildWithName(SOURCE_Q);

			Source source = new Source();
			((EnrichMediator) mediator).setSource(source);

			OMElement targetEle = omElement.getFirstChildWithName(TARGET_Q);
			org.apache.synapse.mediators.elementary.Target target = new org.apache.synapse.mediators.elementary.Target();
			((EnrichMediator) mediator).setTarget(target);

			populateSource(source, sourceEle);
			populateTarget(target, targetEle);

		} else if ("ejb".equals(localName)) {

			EJBMediatorExtFactory factory = new EJBMediatorExtFactory();
			mediator = factory.createMediator(omElement, null);

		} else if ("switch".equals(localName)) {

			mediator = new SwitchMediator();

			QName SWITCH_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "switch");
			QName CASE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "case");
			QName DEFAULT_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "default");

			OMAttribute source = omElement.getAttribute(ATT_SOURCE);
			if (source != null) {
				try {
					((SwitchMediator) mediator).setSource(SynapsePathFactory.getSynapsePath(omElement, ATT_SOURCE));

				} catch (JaxenException e) {
					// ignore
				}
			}

			processAuditStatus(mediator, omElement);
			Iterator iter = omElement.getChildrenWithName(CASE_Q);
			while (iter.hasNext()) {
				OMElement caseElem = (OMElement) iter.next();
				SwitchCase aCase = new SwitchCase();
				OMAttribute regex = caseElem.getAttribute(ATT_REGEX);
				if (regex != null) {

					try {
						aCase.setRegex(Pattern.compile(regex.getAttributeValue()));
					} catch (PatternSyntaxException pse) {
						// ignore
					}
				}
				aCase.setCaseMediator(AnonymousListMediatorFactory.createAnonymousListMediator(caseElem, null));
				((SwitchMediator) mediator).addCase(aCase);
			}

			iter = omElement.getChildrenWithName(DEFAULT_Q);
			while (iter.hasNext()) {
				SwitchCase aCase = new SwitchCase();
				aCase.setCaseMediator(
						AnonymousListMediatorFactory.createAnonymousListMediator((OMElement) iter.next(), null));
				((SwitchMediator) mediator).setDefaultCase(aCase);
				break;
			}

		} else if ("xquery".equals(localName)) {
			mediator = new XQueryMediator();

			QName TAG_NAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "xquery");
			QName ATT_NAME_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "name");
			QName ATT_VALUE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "value");
			QName ATT_EXPR_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "expression");
			QName ATT_KEY_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "key");
			QName ATT_TYPE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "type");

			OMAttribute xqueryKey = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
			OMAttribute attrTarget = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "target"));

			if (xqueryKey != null) {
				ValueFactory keyFac = new ValueFactory();
				Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

				if (generatedKey != null) {
					((XQueryMediator) mediator).setQueryKey(generatedKey);
				}
			}

			if (attrTarget != null) {
				String targetValue = attrTarget.getAttributeValue();
				if (targetValue != null && !"".equals(targetValue)) {
					try {
						((XQueryMediator) mediator)
								.setTarget(SynapseXPathFactory.getSynapseXPath(omElement, ATT_TARGET));
					} catch (JaxenException e) {
						// ignore
					}
				}
			}

			processAuditStatus(mediator, omElement);
			OMElement dataSource = omElement
					.getFirstChildWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "dataSource"));
			if (dataSource != null) {
				((XQueryMediator) mediator)
						.addAllDataSourceProperties(MediatorPropertyFactory.getMediatorProperties(dataSource));
			}

			Iterator it = omElement.getChildrenWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "variable"));
			while (it.hasNext()) {
				OMElement variableOM = (OMElement) it.next();
				String name = variableOM.getAttributeValue(ATT_NAME_Q);
				if (name != null && !"".equals(name)) {
					String type = variableOM.getAttributeValue(ATT_TYPE_Q);
					if (type != null && !"".equals(type)) {
						String value = variableOM.getAttributeValue(ATT_VALUE_Q);
						MediatorVariable variable;
						if (value != null && !"".equals(value)) {
							variable = new MediatorBaseVariable(new QName(name.trim()));
							variable.setValue(value.trim());
						} else {
							String key = variableOM.getAttributeValue(ATT_KEY_Q);
							String expr = variableOM.getAttributeValue(ATT_EXPR_Q);
							variable = new MediatorCustomVariable(new QName(name.trim()));
							if (key != null) {
								((MediatorCustomVariable) variable).setRegKey(key.trim());
							}
							if (expr != null && !"".equals(expr)) {
								try {
									SynapseXPath xpath = new SynapseXPath(expr);
									Log log = LogFactory.getLog(XQueryMediatorFactory.class);
									OMElementUtils.addNameSpaces(xpath, variableOM, log);
									((MediatorCustomVariable) variable).setExpression(xpath);

								} catch (JaxenException e) {
									// ignore
								}
							}
						}
						if ("INT".equals(type.trim())) {
							variable.setType(ItemType.INT);
						} else if ("INTEGER".equals(type.trim())) {
							variable.setType(ItemType.INTEGER);
						} else if ("BOOLEAN".equals(type.trim())) {
							variable.setType(ItemType.BOOLEAN);
						} else if ("BYTE".equals(type.trim())) {
							variable.setType(ItemType.BYTE);
						} else if ("DOUBLE".equals(type.trim())) {
							variable.setType(ItemType.DOUBLE);
						} else if ("SHORT".equals(type.trim())) {
							variable.setType(ItemType.SHORT);
						} else if ("LONG".equals(type.trim())) {
							variable.setType(ItemType.LONG);
						} else if ("FLOAT".equals(type.trim())) {
							variable.setType(ItemType.FLOAT);
						} else if ("STRING".equals(type.trim())) {
							variable.setType(ItemType.STRING);
						} else if ("DOCUMENT".equals(type.trim())) {
							variable.setNodeKind(XdmNodeKind.DOCUMENT);
						} else if ("ELEMENT".equals(type.trim())) {
							variable.setNodeKind(XdmNodeKind.ELEMENT);
						} else {
							variable.setType(ItemType.STRING);
						}
						((XQueryMediator) mediator).addVariable(variable);
					}
				}
			}

		} else if ("clone".equals(localName)) {

			CloneMediatorFactory factory = new CloneMediatorFactory();
			mediator = factory.createMediator(omElement, null);

		} else if ("builder".equals(localName)) {

			BuilderMediatorExtFactory factory = new BuilderMediatorExtFactory();
			mediator = factory.createMediator(omElement, null);

		} else if ("enqueue".equals(localName)) {

			mediator = new EnqueueMediator();

			QName SEQUENCE_ATT = new QName("sequence");
			QName PRIORITY_ATT = new QName("priority");
			QName QUEUE_ATT = new QName("executor");

			processAuditStatus(mediator, omElement);

			OMAttribute seqAtt = omElement.getAttribute(SEQUENCE_ATT);
			if (seqAtt != null && !"".equals(seqAtt.getAttributeValue())) {
				((EnqueueMediator) mediator).setSequenceName(seqAtt.getAttributeValue());
			}

			OMAttribute priorityAtt = omElement.getAttribute(PRIORITY_ATT);
			if (priorityAtt != null && !"".equals(priorityAtt.getAttributeValue())) {
				((EnqueueMediator) mediator).setPriority(Integer.parseInt(priorityAtt.getAttributeValue()));
			}

			OMAttribute queueAtt = omElement.getAttribute(QUEUE_ATT);
			if (queueAtt != null && !"".equals(queueAtt.getAttributeValue())) {
				((EnqueueMediator) mediator).setExecutorName(queueAtt.getAttributeValue());
			}

		} else if ("event".equals(localName)) {

			mediator = new EventMediator();
			OMAttribute topicAttr = omElement.getAttribute(new QName("topic"));
			if (topicAttr != null) {
				ValueFactory vf = new ValueFactory();
				Value value = vf.createValue("topic", omElement);

				((EventMediator) mediator).setTopic(value);
			}

			OMAttribute expression = omElement.getAttribute(new QName("expression"));
			if (expression != null) {
				try {
					((EventMediator) mediator)
							.setExpression(SynapseXPathFactory.getSynapseXPath(omElement, new QName("expression")));
				} catch (JaxenException e) {
					// ignore
				}
			}

		} else if ("call-template".equals(localName)) {

			mediator = new InvokeMediator();

			QName WITH_PARAM_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "with-param");
			QName WITH_PARAM_DYNAMIC_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "parameter");

			processAuditStatus(mediator, omElement);
			OMAttribute targetTemplateAttr = omElement.getAttribute(ATT_TARGET);
			if (targetTemplateAttr != null) {
				((InvokeMediator) mediator).setTargetTemplate(targetTemplateAttr.getAttributeValue());
				buildParameters(omElement, (InvokeMediator) mediator);
			}

		} else if ("conditionalRouter".equals(localName)) {

			mediator = new ConditionalRouterMediator();

			QName CONDITIONAL_ROUTER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "conditionalRouter");
			QName ROUTE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "conditionalRoute");
			QName CONDITION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "condition");
			QName TARGET_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");

			QName CONTINUE_AFTER_ATTR = new QName(XMLConfigConstants.NULL_NAMESPACE, "continueAfter");
			QName BREAK_ROUTE_ATTR = new QName(XMLConfigConstants.NULL_NAMESPACE, "breakRoute");
			QName ASYNCHRONOUS_ATTR = new QName(XMLConfigConstants.NULL_NAMESPACE, "asynchronous");

			processAuditStatus(mediator, omElement);

			if (omElement.getAttribute(CONTINUE_AFTER_ATTR) != null) {
				if (JavaUtils.isTrueExplicitly(omElement.getAttributeValue(CONTINUE_AFTER_ATTR).trim())) {
					((ConditionalRouterMediator) mediator).setContinueAfter(true);
				} else {
					((ConditionalRouterMediator) mediator).setContinueAfter(false);
				}
			}

			Iterator itr = omElement.getChildrenWithName(ROUTE_Q);
			while (itr.hasNext()) {
				OMElement routeElem = (OMElement) itr.next();
				ConditionalRoute conditionalRoute = new ConditionalRoute();

				if (routeElem.getAttribute(BREAK_ROUTE_ATTR) != null) {
					if (JavaUtils.isTrueExplicitly(routeElem.getAttributeValue(BREAK_ROUTE_ATTR).trim())) {

						conditionalRoute.setBreakRoute(true);
					} else {

						conditionalRoute.setBreakRoute(false);
					}
				}

				OMElement conditionElem = routeElem.getFirstChildWithName(CONDITION_Q);
				if (conditionElem != null) {

					try {
						Evaluator evaluator = EvaluatorFactoryFinder.getInstance()
								.getEvaluator(conditionElem.getFirstElement());
						conditionalRoute.setEvaluator(evaluator);
					} catch (EvaluatorException ee) {
						// ignore
					}
				}

				OMElement targetElem = routeElem.getFirstChildWithName(TARGET_Q);
				Target target = TargetFactory.createTarget(targetElem, null);
				if (JavaUtils.isTrueExplicitly(routeElem.getAttributeValue(ASYNCHRONOUS_ATTR))) {
					target.setAsynchronous(true);
				} else {
					target.setAsynchronous(false);
				}
				conditionalRoute.setTarget(target);
				((ConditionalRouterMediator) mediator).addRoute(conditionalRoute);

			}

		} else if ("bean".equals(localName)) {

			BeanMediatorExtFactory factory = new BeanMediatorExtFactory();
			mediator = factory.createMediator(omElement, null);

		} else if ("sequence".equals(localName)) {

			mediator = new SequenceMediator();

			OMAttribute e = omElement.getAttribute(ATT_ONERROR);
			OMAttribute n = omElement.getAttribute(ATT_NAME);

			if (e != null) {
				((SequenceMediator) mediator).setErrorHandler(e.getAttributeValue());
			}
			processAuditStatus(mediator, omElement);

			OMElement descElem = omElement.getFirstChildWithName(DESCRIPTION_Q);
			if (descElem != null) {
				((SequenceMediator) mediator).setDescription(descElem.getText());
			}
			addChildren(omElement, ((SequenceMediator) mediator), null);
			((SequenceMediator) mediator).setSequenceType(SequenceType.ANON);

			if (n != null) {
				((SequenceMediator) mediator).setName(n.getAttributeValue());

			} else {
				n = omElement.getAttribute(ATT_KEY);
				if (n != null) {
					ValueFactory keyFac = new ValueFactory();
					Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);
					((SequenceMediator) mediator).setKey(generatedKey);

				}
			}

		} else if ("pojoCommand".equals(localName)) {

			POJOCommandMediatorExtFactory factory = new POJOCommandMediatorExtFactory();
			mediator = factory.createMediator(omElement, null);

		} else if ("spring".equals(localName)) {

			mediator = new SpringMediator();
			OMAttribute bean = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "bean"));
			OMAttribute key = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));

			processAuditStatus(mediator, omElement);
			((SpringMediator) mediator).setBeanName(bean.getAttributeValue());
			((SpringMediator) mediator).setConfigKey(key.getAttributeValue());

		} else if ("makefault".equals(localName)) {

			mediator = new FaultMediator();

			QName ATT_VERSION_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "version");
			QName ATT_RESPONSE_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "response");
			QName CODE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "code");
			QName REASON_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "reason");
			QName NODE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "node");
			QName ROLE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "role");
			QName DETAIL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "detail");

			String SOAP11 = "soap11";
			String SOAP12 = "soap12";
			String POX = "pox";

			OMAttribute version = omElement.getAttribute(ATT_VERSION_Q);
			if (version != null) {
				if (SOAP11.equals(version.getAttributeValue())) {
					((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP11);
				} else if (SOAP12.equals(version.getAttributeValue())) {
					((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP12);
				} else if (POX.equals(version.getAttributeValue())) {
					((FaultMediator) mediator).setSoapVersion(FaultMediator.POX);
				} else {
					((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP11);
				}
			} else {

				((FaultMediator) mediator).setSoapVersion(FaultMediator.SOAP11);
			}

			OMAttribute response = omElement.getAttribute(ATT_RESPONSE_Q);
			if (response != null) {
				if ("true".equals(response.getAttributeValue())) {
					((FaultMediator) mediator).setMarkAsResponse(true);
				} else {
					((FaultMediator) mediator).setMarkAsResponse(false);
				}
				((FaultMediator) mediator).setSerializeResponse(true);
			}

			OMElement code = omElement.getFirstChildWithName(CODE_Q);
			if (code != null) {
				OMAttribute value = code.getAttribute(ATT_VALUE);
				OMAttribute expression = code.getAttribute(ATT_EXPRN);

				if (value != null) {
					String strValue = value.getAttributeValue();
					String prefix = null;
					String name = null;
					if (strValue.indexOf(":") != -1) {
						prefix = strValue.substring(0, strValue.indexOf(":"));
						name = strValue.substring(strValue.indexOf(":") + 1);
					}
					String namespaceURI = OMElementUtils.getNameSpaceWithPrefix(prefix, code);
					if (namespaceURI != null) {
						((FaultMediator) mediator).setFaultCodeValue(new QName(namespaceURI, name, prefix));
					}

				} else if (expression != null) {
					try {
						((FaultMediator) mediator)
								.setFaultCodeExpr(SynapseXPathFactory.getSynapseXPath(code, ATT_EXPRN));
					} catch (JaxenException je) {
						// ignore
					}
				}

			}

			OMElement reason = omElement.getFirstChildWithName(REASON_Q);
			if (reason != null) {
				OMAttribute value = reason.getAttribute(ATT_VALUE);
				OMAttribute expression = reason.getAttribute(ATT_EXPRN);

				if (value != null) {
					((FaultMediator) mediator).setFaultReasonValue(value.getAttributeValue());
				} else if (expression != null) {
					try {
						((FaultMediator) mediator)
								.setFaultReasonExpr(SynapseXPathFactory.getSynapseXPath(reason, ATT_EXPRN));
					} catch (JaxenException je) {
						// ignore
					}
				}

			}
			processAuditStatus(mediator, omElement);

			OMElement node = omElement.getFirstChildWithName(NODE_Q);
			if (node != null && node.getText() != null && !SOAP11.equals(version.getAttributeValue())) {
				try {
					((FaultMediator) mediator).setFaultNode(new URI(node.getText()));
				} catch (URISyntaxException e) {
					// ignore
				}
			}

			OMElement role = omElement.getFirstChildWithName(ROLE_Q);
			if (role != null && role.getText() != null) {
				try {
					((FaultMediator) mediator).setFaultRole(new URI(role.getText()));
				} catch (URISyntaxException e) {
					// ignore
				}
			}

			OMElement detail = omElement.getFirstChildWithName(DETAIL_Q);
			if (detail != null) {
				OMAttribute detailExpr = detail.getAttribute(ATT_EXPRN);
				if (detailExpr != null && detailExpr.getAttributeValue() != null) {
					try {
						((FaultMediator) mediator)
								.setFaultDetailExpr(SynapseXPathFactory.getSynapseXPath(detail, ATT_EXPRN));
					} catch (JaxenException e) {
						// ignore
					}

				} else if (detail.getChildElements().hasNext()) {
					Iterator it = detail.getChildElements();
					while (it.hasNext()) {
						OMElement child = (OMElement) it.next();
						if (child != null) {
							((FaultMediator) mediator).addFaultDetailElement(child);
						}
					}

				} else if (detail.getText() != null) {
					((FaultMediator) mediator).setFaultDetail(detail.getText());

				} else {
					((FaultMediator) mediator).setFaultDetail("");
				}
			}

		} else if ("smooks".equals(localName)) {

			mediator = new SmooksMediator();

			QName CONFIG_KEY = new QName("config-key");
			QName PERSISTENCE_UNIT = new QName("persistence-unit");

			OMAttribute configFileAttr = omElement.getAttribute(CONFIG_KEY);

			if (configFileAttr != null) {
				((SmooksMediator) mediator).setConfigKey(configFileAttr.getAttributeValue());
			}

			OMAttribute persistenceUnitAttr = omElement.getAttribute(PERSISTENCE_UNIT);
			if (persistenceUnitAttr != null) {
				((SmooksMediator) mediator).setPersistenceUnitAttr(persistenceUnitAttr.getAttributeValue());
			}

			OMElement inputElement = omElement
					.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "input"));
			if (inputElement != null) {
				((SmooksMediator) mediator).setInput(createInput(inputElement));
			} else {
				((SmooksMediator) mediator).setInput(new Input());
			}

			OMElement outputElement = omElement
					.getFirstChildWithName(new QName(SynapseConstants.SYNAPSE_NAMESPACE, "output"));
			if (inputElement != null) {
				((SmooksMediator) mediator).setOutput(createOutput(outputElement));
			} else {
				((SmooksMediator) mediator).setOutput(new Output());
			}

		} else if ("rewrite".equals(localName)) {

			mediator = new URLRewriteMediator();

			QName RULE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "rewriterule");
			QName CONDITION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "condition");
			QName ACTION_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "action");

			QName ATT_IN_PROPERTY = new QName("inProperty");
			QName ATT_OUT_PROPERTY = new QName("outProperty");
			QName ATT_TYPE = new QName("type");
			QName ATT_FRAGMENT = new QName("fragment");

			String ACTION_SET = "set";
			String ACTION_APPEND = "append";
			String ACTION_PREPEND = "prepend";
			String ACTION_REPLACE = "replace";
			String ACTION_REMOVE = "remove";

			String FRAGMENT_PROTOCOL = "protocol";
			String FRAGMENT_USER_INFO = "user";
			String FRAGMENT_HOST = "host";
			String FRAGMENT_PORT = "port";
			String FRAGMENT_PATH = "path";
			String FRAGMENT_QUERY = "query";
			String FRAGMENT_REF = "ref";
			String FRAGMENT_FULL_URI = "full";

			Iterator rules = omElement.getChildrenWithName(RULE_Q);
			String inputProperty = omElement.getAttributeValue(ATT_IN_PROPERTY);
			String outputProperty = omElement.getAttributeValue(ATT_OUT_PROPERTY);

			if (inputProperty != null) {
				((URLRewriteMediator) mediator).setInputProperty(inputProperty);
			}
			if (outputProperty != null) {
				((URLRewriteMediator) mediator).setOutputProperty(outputProperty);
			}

			while (rules.hasNext()) {
				((URLRewriteMediator) mediator).addRule(parseRule((OMElement) rules.next()));
			}

			processAuditStatus(mediator, omElement);

		} else if ("fastXSLT".equals(localName)) {

			mediator = new FastXSLTMediator();

			OMAttribute attXslt = omElement.getAttribute(ATT_KEY);

			if (attXslt != null) {
				ValueFactory keyFac = new ValueFactory();
				Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElement);

				((FastXSLTMediator) mediator).setXsltKey(generatedKey);
			}

			processAuditStatus(mediator, omElement);

		} else if ("dbreport".equals(localName)) {

			mediator = new DBReportMediator();
			QName DBREPORT_USE_TX = new QName("useTransaction");

			processAuditStatus(mediator, omElement);

			OMAttribute useTx = omElement.getAttribute(DBREPORT_USE_TX);
			if (useTx != null && useTx.getAttributeValue() != null) {
				String useTxValue = useTx.getAttributeValue();
				if (useTxValue.equals("true")) {
					((DBReportMediator) mediator).setUseTransaction(true);
				} else {
					((DBReportMediator) mediator).setUseTransaction(false);
				}
			}
			buildDataSource(omElement, (DBReportMediator) mediator);
			processStatements(omElement, (DBReportMediator) mediator);

		} else if ("dblookup".equals(localName)) {

			mediator = new DBLookupMediator();
			processAuditStatus(mediator, omElement);
			buildDataSource(omElement, (DBLookupMediator) mediator);
			processStatements(omElement, (DBLookupMediator) mediator);

		} else if ("throttle".equals(localName)) {

			mediator = new ThrottleMediator();
			OMElement policy = omElement
					.getFirstChildWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "policy"));
			if (policy != null) {
				OMAttribute key = policy.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));
				if (key != null) {
					String keyValue = key.getAttributeValue();
					if (keyValue != null && !"".equals(keyValue)) {
						((ThrottleMediator) mediator).setPolicyKey(keyValue);
					}
				} else {
					OMElement inLine = policy.getFirstElement();
					if (inLine != null) {
						((ThrottleMediator) mediator).setInLinePolicy(inLine);
					}
				}
			}

			processAuditStatus(mediator, omElement);

			String id = omElement.getAttributeValue(new QName(XMLConfigConstants.NULL_NAMESPACE, "id"));
			if (id != null && !"".equals(id)) {
				((ThrottleMediator) mediator).setId(id.trim());
			}

			SequenceMediatorFactory mediatorFactory = new SequenceMediatorFactory();
			OMAttribute onReject = omElement
					.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, XMLConfigConstants.ONREJECT));
			if (onReject != null) {
				String onRejectValue = onReject.getAttributeValue();
				if (onRejectValue != null) {
					((ThrottleMediator) mediator).setOnRejectSeqKey(onRejectValue.trim());
				}
			} else {
				OMElement onRejectMediatorElement = omElement.getFirstChildWithName(
						new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, XMLConfigConstants.ONREJECT));
				if (onRejectMediatorElement != null) {
					((ThrottleMediator) mediator).setOnRejectMediator(
							mediatorFactory.createAnonymousSequence(onRejectMediatorElement, null));
				}
			}
			OMAttribute onAccept = omElement
					.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, XMLConfigConstants.ONACCEPT));
			if (onAccept != null) {
				String onAcceptValue = onAccept.getAttributeValue();
				if (onAcceptValue != null) {
					((ThrottleMediator) mediator).setOnAcceptSeqKey(onAcceptValue);
				}
			} else {
				OMElement onAcceptMediatorElement = omElement.getFirstChildWithName(
						new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, XMLConfigConstants.ONACCEPT));
				if (onAcceptMediatorElement != null) {
					((ThrottleMediator) mediator).setOnAcceptMediator(
							mediatorFactory.createAnonymousSequence(onAcceptMediatorElement, null));
				}
			}

		} else if ("transaction".equals(localName)) {

			mediator = new TransactionMediator();
			OMAttribute action = omElement.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "action"));
			processAuditStatus(mediator, omElement);
			if (action != null) {
				((TransactionMediator) mediator).setAction(action.getAttributeValue());
			}

		} else if ("callout".equals(localName)) {

			QName TAG_NAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "callout");
			QName ATT_URL = new QName("serviceURL");
			QName ATT_ENDPOINT = new QName("endpointKey");
			QName ATT_ACTION = new QName("action");
			QName ATT_AXIS2XML = new QName("axis2xml");
			QName ATT_USESERVERCONFIG = new QName("useServerConfig");
			QName ATT_REPOSITORY = new QName("repository");
			QName ATT_INIT_AXI2_CLIENT_OPTIONS = new QName("initAxis2ClientOptions");
			QName Q_CONFIG = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "configuration");
			QName Q_SOURCE = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "source");
			QName Q_TARGET = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "target");
			QName ATT_SOURCE_TYPE = new QName(XMLConfigConstants.NULL_NAMESPACE, "type");
			QName Q_SEC = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "enableSec");
			QName ATT_POLICY = new QName(XMLConfigConstants.NULL_NAMESPACE, "policy");
			QName ATT_OUTBOUND_SEC_POLICY = new QName(XMLConfigConstants.NULL_NAMESPACE, "outboundPolicy");
			QName ATT_INBOUND_SEC_POLICY = new QName(XMLConfigConstants.NULL_NAMESPACE, "inboundPolicy");
			QName Q_ENDPOINT = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "endpoint");

			mediator = new CalloutMediator();
			processAuditStatus(mediator, omElement);

			OMAttribute attServiceURL = omElement.getAttribute(ATT_URL);
			OMAttribute attEndpoint = omElement.getAttribute(ATT_ENDPOINT);
			OMAttribute attAction = omElement.getAttribute(ATT_ACTION);
			OMAttribute attUseServerConfig = omElement.getAttribute(ATT_USESERVERCONFIG);
			OMAttribute initAxis2ClientOptions = omElement.getAttribute(ATT_INIT_AXI2_CLIENT_OPTIONS);
			OMElement configElt = omElement.getFirstChildWithName(Q_CONFIG);
			OMElement epElement = omElement.getFirstChildWithName(Q_ENDPOINT);
			OMElement sourceElt = omElement.getFirstChildWithName(Q_SOURCE);
			OMElement targetElt = omElement.getFirstChildWithName(Q_TARGET);
			OMElement wsSec = omElement.getFirstChildWithName(Q_SEC);

			if (attServiceURL != null) {
				((CalloutMediator) mediator).setServiceURL(attServiceURL.getAttributeValue());
			} else if (attEndpoint != null) {
				((CalloutMediator) mediator).setEndpointKey(attEndpoint.getAttributeValue());
			}

			if (epElement != null) {
				Endpoint endpoint = EndpointFactory.getEndpointFromElement(epElement, true, null);
				if (endpoint != null) {
					((CalloutMediator) mediator).setEndpoint(endpoint);
				}
			}

			if (attAction != null) {
				((CalloutMediator) mediator).setAction(attAction.getAttributeValue());
			}

			if (attUseServerConfig != null) {
				((CalloutMediator) mediator).setUseServerConfig(attUseServerConfig.getAttributeValue());
			}

			if (initAxis2ClientOptions != null) {
				if ("true".equals(initAxis2ClientOptions.getAttributeValue().toLowerCase())) {
					((CalloutMediator) mediator).setInitClientOptions(true);
				} else {
					((CalloutMediator) mediator).setInitClientOptions(false);
				}
			}

			if (configElt != null) {

				OMAttribute axis2xmlAttr = configElt.getAttribute(ATT_AXIS2XML);
				OMAttribute repoAttr = configElt.getAttribute(ATT_REPOSITORY);

				if (axis2xmlAttr != null) {
					((CalloutMediator) mediator).setAxis2xml(axis2xmlAttr.getAttributeValue());
				}

				if (repoAttr != null) {
					((CalloutMediator) mediator).setClientRepository(repoAttr.getAttributeValue());
				}
			}

			if (sourceElt != null) {
				OMAttribute sourceType = sourceElt.getAttribute(ATT_SOURCE_TYPE);

				if (sourceType != null && sourceType.getAttributeValue().equals("envelope")) {
					((CalloutMediator) mediator).setUseEnvelopeAsSource(true);
				} else if (sourceElt.getAttribute(ATT_XPATH) != null) {
					try {
						((CalloutMediator) mediator)
								.setRequestXPath(SynapseXPathFactory.getSynapseXPath(sourceElt, ATT_XPATH));
					} catch (JaxenException e) {
						// ignore
					}
				} else if (sourceElt.getAttribute(ATT_KEY) != null) {
					((CalloutMediator) mediator).setRequestKey(sourceElt.getAttributeValue(ATT_KEY));
				}
			} else {
				((CalloutMediator) mediator).setUseEnvelopeAsSource(true);
			}

			if (targetElt != null) {
				if (targetElt.getAttribute(ATT_XPATH) != null) {
					try {
						((CalloutMediator) mediator)
								.setTargetXPath(SynapseXPathFactory.getSynapseXPath(targetElt, ATT_XPATH));
					} catch (JaxenException e) {
						// ignore
					}
				} else if (targetElt.getAttribute(ATT_KEY) != null) {
					((CalloutMediator) mediator).setTargetKey(targetElt.getAttributeValue(ATT_KEY));
				}
			}

			if (wsSec != null) {
				((CalloutMediator) mediator).setSecurityOn(true);
				OMAttribute policyKey = wsSec.getAttribute(ATT_POLICY);
				OMAttribute outboundPolicyKey = wsSec.getAttribute(ATT_OUTBOUND_SEC_POLICY);
				OMAttribute inboundPolicyKey = wsSec.getAttribute(ATT_INBOUND_SEC_POLICY);
				if (policyKey != null) {
					((CalloutMediator) mediator).setWsSecPolicyKey(policyKey.getAttributeValue());
				} else if (outboundPolicyKey != null || inboundPolicyKey != null) {
					if (outboundPolicyKey != null) {
						((CalloutMediator) mediator).setOutboundWsSecPolicyKey(outboundPolicyKey.getAttributeValue());
					}
					if (inboundPolicyKey != null) {
						((CalloutMediator) mediator).setInboundWsSecPolicyKey(inboundPolicyKey.getAttributeValue());
					}
				} else {
					((CalloutMediator) mediator).setSecurityOn(false);

				}
			}

		} else if ("entitlementService".equals(localName)) {
			// TODO

		} else if ("foreach".equals(localName)) {
			// TODO

		} else if ("oauthService".equals(localName)) {
			// TODO

		} else if ("rule".equals(localName)) {

			RuleMediatorExtFactory factory = new RuleMediatorExtFactory();
			factory.createMediator(omElement, null);

		} else if ("bam".equals(localName)) {
			// TODO
			mediator = new BamMediator();

		} else if ("publishEvent".equals(localName)) {

			mediator = new PublishEventMediator();

			QName PUBLISH_EVENT_QNAME = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "publishEvent");
			QName EVENT_SINK_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "eventSink");
			QName STREAM_NAME_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "streamName");
			QName STREAM_VERSION_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "streamVersion");
			QName ATTRIBUTES_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "attributes");
			QName ATTRIBUTE_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "attribute");
			QName META_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "meta");
			QName CORRELATION_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "correlation");
			QName PAYLOAD_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "payload");
			QName ARBITRARY_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "arbitrary");
			QName TYPE_QNAME = new QName("type");
			QName DEFAULT_QNAME = new QName("defaultValue");
			QName ATT_ASYNC = new QName("async");
			QName ATT_ASYNC_TIMEOUT = new QName("timeout");

			OMAttribute isAsync = omElement.getAttribute(ATT_ASYNC);
			if ((isAsync != null && !Boolean.parseBoolean(isAsync.getAttributeValue()))) {
				((PublishEventMediator) mediator).setAsync(false);
			} else {
				OMAttribute asyncTimeout = omElement.getAttribute(ATT_ASYNC_TIMEOUT);
				if (asyncTimeout != null) {
					try {
						long timeout = Long.parseLong(asyncTimeout.getAttributeValue());
						if (timeout > 0) {
							((PublishEventMediator) mediator).setAsyncTimeout(timeout);
						}
					} catch (NumberFormatException e) {
						// ignore
					}
				}
			}

			OMElement streamName = omElement.getFirstChildWithName(STREAM_NAME_QNAME);
			if (streamName != null) {
				((PublishEventMediator) mediator).setStreamName(streamName.getText());
			}

			OMElement streamVersion = omElement.getFirstChildWithName(STREAM_VERSION_QNAME);
			if (streamVersion != null) {
				((PublishEventMediator) mediator).setStreamVersion(streamVersion.getText());
			}

			OMElement attributes = omElement.getFirstChildWithName(ATTRIBUTES_QNAME);
			if (attributes != null) {

				OMElement meta = attributes.getFirstChildWithName(META_QNAME);
				if (meta != null) {
					Iterator<OMElement> iterator = meta.getChildrenWithName(ATTRIBUTE_QNAME);
					List<Property> propertyList = generatePropertyList(iterator);
					((PublishEventMediator) mediator).setMetaProperties(propertyList);
				}
				OMElement correlation = attributes.getFirstChildWithName(CORRELATION_QNAME);
				if (correlation != null) {
					Iterator<OMElement> iterator = correlation.getChildrenWithName(ATTRIBUTE_QNAME);
					List<Property> propertyList = generatePropertyList(iterator);
					((PublishEventMediator) mediator).setCorrelationProperties(propertyList);
				}
				OMElement payload = attributes.getFirstChildWithName(PAYLOAD_QNAME);
				if (payload != null) {
					Iterator<OMElement> iterator = payload.getChildrenWithName(ATTRIBUTE_QNAME);
					List<Property> propertyList = generatePropertyList(iterator);
					((PublishEventMediator) mediator).setPayloadProperties(propertyList);
				}
				OMElement arbitrary = attributes.getFirstChildWithName(ARBITRARY_QNAME);
				if (arbitrary != null) {
					Iterator<OMElement> iterator = arbitrary.getChildrenWithName(ATTRIBUTE_QNAME);
					List<Property> propertyList = generatePropertyList(iterator);

					((PublishEventMediator) mediator).setArbitraryProperties(propertyList);
				}
			}

			OMElement eventSinkElement = omElement.getFirstChildWithName(EVENT_SINK_QNAME);
			if (eventSinkElement != null) {
				((PublishEventMediator) mediator).setEventSinkName(eventSinkElement.getText());
			}

		}

		return mediator;
	}

	private void addChildren(OMElement el, ListMediator m, Properties properties) {
		Iterator it = el.getChildren();

		while (it.hasNext()) {
			OMNode child = (OMNode) it.next();
			if (child instanceof OMElement) {
				if (!new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "description")
						.equals(((OMElement) child).getQName())) {
					Mediator med = MediatorFactoryFinder.getInstance().getMediator((OMElement) child, properties);
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

	private void removeIndentations(OMElement element) {
		List<OMText> removables = new ArrayList<OMText>();
		removeIndentations(element, removables);
		for (OMText node : removables) {
			node.detach();
		}
	}

	private void removeIndentations(OMElement element, List<OMText> removables) {
		Iterator children = element.getChildren();
		while (children.hasNext()) {
			Object next = children.next();
			if (next instanceof OMText) {
				OMText text = (OMText) next;
				if (text.getText().trim().equals("")) {
					removables.add(text);
				}
			} else if (next instanceof OMElement) {
				removeIndentations((OMElement) next, removables);
			}
		}
	}

	private boolean checkForExpression(OMAttribute atr) {
		return ((atr.getAttributeValue().startsWith("{")) && (atr.getAttributeValue().endsWith("}")));
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

	private Map<Value, Object> getIncludeKeysMap(OMElement elem) {

		Map<Value, Object> includeKeysMap = new LinkedHashMap<Value, Object>();
		Iterator itr = elem.getChildrenWithName(INCLUDE_Q);
		while (itr.hasNext()) {
			OMElement includeElem = (OMElement) itr.next();
			OMAttribute key = includeElem.getAttribute(new QName(XMLConfigConstants.NULL_NAMESPACE, "key"));

			ValueFactory keyFac = new ValueFactory();

			Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, includeElem);

			if (key == null) {
				throw new SynapseException(
						"Cannot use 'include' element without 'key'" + " attribute for a script mediator");
			}

			includeKeysMap.put(generatedKey, null);
		}

		return includeKeysMap;
	}

	private void populateSource(Source source, OMElement sourceEle) {

		OMAttribute typeAttr = sourceEle.getAttribute(ATT_TYPE);
		if (typeAttr != null && typeAttr.getAttributeValue() != null) {
			source.setSourceType(convertTypeToInt(typeAttr.getAttributeValue()));
		}

		OMAttribute cloneAttr = sourceEle.getAttribute(ATT_CLONE);
		if (cloneAttr != null && cloneAttr.getAttributeValue() != null) {
			source.setClone(Boolean.parseBoolean(cloneAttr.getAttributeValue()));
		}

		if (source.getSourceType() == EnrichMediator.CUSTOM) {
			OMAttribute xpathAttr = sourceEle.getAttribute(ATT_XPATH);
			if (xpathAttr != null && xpathAttr.getAttributeValue() != null) {
				try {
					source.setXpath(SynapseXPathFactory.getSynapseXPath(sourceEle, ATT_XPATH));
				} catch (JaxenException e) {
					// ignore
				}
			}

		} else if (source.getSourceType() == EnrichMediator.PROPERTY) {
			OMAttribute propertyAttr = sourceEle.getAttribute(ATT_PROPERTY);
			if (propertyAttr != null && propertyAttr.getAttributeValue() != null) {
				source.setProperty(propertyAttr.getAttributeValue());
			}

		} else if (source.getSourceType() == EnrichMediator.INLINE) {
			OMElement inlineElem = null;
			if (sourceEle.getFirstElement() != null) {
				inlineElem = sourceEle.getFirstElement().cloneOMElement();
			}

			if (inlineElem != null) {
				source.setInlineOMNode(inlineElem);
			} else if (!StringUtils.isBlank(sourceEle.getText())) {
				source.setInlineOMNode(OMAbstractFactory.getOMFactory().createOMText(sourceEle.getText()));
			} else if (sourceEle.getAttributeValue(ATT_KEY) != null) {
				source.setInlineKey(sourceEle.getAttributeValue(ATT_KEY));
			}
		}
	}

	private void populateTarget(org.apache.synapse.mediators.elementary.Target target, OMElement sourceEle) {

		OMAttribute typeAttr = sourceEle.getAttribute(ATT_TYPE);
		OMAttribute actionAttr = sourceEle.getAttribute(ATT_ACTION);

		if (actionAttr != null && actionAttr.getAttributeValue() != null) {
			target.setAction(actionAttr.getAttributeValue());
		} else {
			target.setAction("replace");
		}

		if (typeAttr != null && typeAttr.getAttributeValue() != null) {
			int type = convertTypeToInt(typeAttr.getAttributeValue());
			if (type >= 0) {
				target.setTargetType(type);
			}
		}

		if (target.getTargetType() == EnrichMediator.CUSTOM) {
			OMAttribute xpathAttr = sourceEle.getAttribute(ATT_XPATH);
			if (xpathAttr != null && xpathAttr.getAttributeValue() != null) {
				try {
					target.setXpath(SynapseXPathFactory.getSynapseXPath(sourceEle, ATT_XPATH));
				} catch (JaxenException e) {
					// ignore
				}
			}
		} else if (target.getTargetType() == EnrichMediator.PROPERTY) {
			OMAttribute propertyAttr = sourceEle.getAttribute(ATT_PROPERTY);
			if (propertyAttr != null && propertyAttr.getAttributeValue() != null) {
				target.setProperty(propertyAttr.getAttributeValue());
			}
		}
	}

	private int convertTypeToInt(String type) {
		if (type.equals("envelope")) {
			return EnrichMediator.ENVELOPE;
		} else if (type.equals("body")) {
			return EnrichMediator.BODY;
		} else if (type.equals("property")) {
			return EnrichMediator.PROPERTY;
		} else if (type.equals("custom")) {
			return EnrichMediator.CUSTOM;
		} else if (type.equals("inline")) {
			return EnrichMediator.INLINE;
		}
		return -1;
	}

	private void buildParameters(OMElement elem, InvokeMediator invoker) {
		Iterator subElements = elem.getChildElements();
		while (subElements.hasNext()) {
			OMElement child = (OMElement) subElements.next();
			if (child.getQName().equals(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "with-param"))) {
				OMAttribute paramNameAttr = child.getAttribute(ATT_NAME);
				Value paramValue = new ValueFactory().createValue("value", child);
				if (paramNameAttr != null) {
					invoker.addExpressionForParamName(paramNameAttr.getAttributeValue(), paramValue);
				}
			}
		}
	}

	private Input createInput(OMElement input) {
		Input in = new Input();

		OMAttribute typeAttr = input.getAttribute(new QName("type"));
		String typeValue = "";
		if (typeAttr != null) {
			typeValue = typeAttr.getAttributeValue();
		}

		if (typeValue.equals("xml")) {
			in.setType(SmooksMediator.TYPES.XML);
		} else {
			in.setType(SmooksMediator.TYPES.TEXT);
		}

		if (input.getAttribute(new QName("expression")) != null) {
			try {
				in.setExpression(SynapseXPathFactory.getSynapseXPath(input, new QName("expression")));
			} catch (JaxenException e) {
				// ignore
			}
		}

		return in;
	}

	private Output createOutput(OMElement output) {
		Output in = new Output();

		OMAttribute typeAttr = output.getAttribute(new QName("type"));
		String typeValue = "";
		if (typeAttr != null) {
			typeValue = typeAttr.getAttributeValue();
		}

		if (typeValue.equals("xml")) {
			in.setType(SmooksMediator.TYPES.XML);
		} else if (typeValue.equals("java")) {
			in.setType(SmooksMediator.TYPES.JAVA);
		} else {
			in.setType(SmooksMediator.TYPES.TEXT);
		}

		if (output.getAttribute(new QName("expression")) != null) {
			try {
				in.setExpression(SynapseXPathFactory.getSynapseXPath(output, new QName("expression")));
			} catch (JaxenException e) {
				// ignore
			}
		}

		OMAttribute actionAttr = output.getAttribute(new QName("action"));
		if (actionAttr != null && actionAttr.getAttributeValue() != null) {
			in.setAction(actionAttr.getAttributeValue());
		}

		OMAttribute propertyAttr = output.getAttribute(new QName("property"));
		if (propertyAttr != null && propertyAttr.getAttributeValue() != null) {
			in.setProperty(propertyAttr.getAttributeValue());
		}

		return in;
	}

	private RewriteRule parseRule(OMElement ruleElement) {
		Iterator actions = ruleElement.getChildrenWithName(ACTION_Q);

		RewriteRule rule = new RewriteRule();
		while (actions.hasNext()) {
			rule.addRewriteAction(parseAction((OMElement) actions.next()));
		}

		OMElement condition = ruleElement.getFirstChildWithName(CONDITION_Q);
		if (condition != null) {
			OMElement child = condition.getFirstElement();
			if (child != null) {
				try {
					Evaluator eval = EvaluatorFactoryFinder.getInstance().getEvaluator(child);
					rule.setCondition(eval);
				} catch (EvaluatorException e) {
					// ignore
				}
			}
		}

		return rule;
	}

	private RewriteAction parseAction(OMElement actionElement) {
		String value = actionElement.getAttributeValue(ATT_VALUE);
		String xpath = actionElement.getAttributeValue(ATT_XPATH);
		String type = actionElement.getAttributeValue(ATT_TYPE);
		QName xpath_Q = new QName(XMLConfigConstants.NULL_NAMESPACE, "xpath");

		RewriteAction action = new RewriteAction();
		if (xpath != null) {
			try {
				action.setXpath(SynapseXPathFactory.getSynapseXPath(actionElement, xpath_Q));
			} catch (JaxenException e) {
				// ignore
			}
		} else if (value != null) {
			action.setValue(value);
		}

		String fragment = actionElement.getAttributeValue(ATT_FRAGMENT);
		if (fragment != null) {
			if (FRAGMENT_PROTOCOL.equals(fragment)) {
				action.setFragmentIndex(URIFragments.PROTOCOL);
			} else if (FRAGMENT_USER_INFO.equals(fragment)) {
				action.setFragmentIndex(URIFragments.USER_INFO);
			} else if (FRAGMENT_HOST.equals(fragment)) {
				action.setFragmentIndex(URIFragments.HOST);
			} else if (FRAGMENT_PORT.equals(fragment)) {
				action.setFragmentIndex(URIFragments.PORT);
			} else if (FRAGMENT_PATH.equals(fragment)) {
				action.setFragmentIndex(URIFragments.PATH);
			} else if (FRAGMENT_QUERY.equals(fragment)) {
				action.setFragmentIndex(URIFragments.QUERY);
			} else if (FRAGMENT_REF.equals(fragment)) {
				action.setFragmentIndex(URIFragments.REF);
			} else if (FRAGMENT_FULL_URI.equals(fragment)) {
				action.setFragmentIndex(URIFragments.FULL_URI);
			}
		}

		if (type != null) {
			if (ACTION_SET.equals(type)) {
				action.setActionType(RewriteAction.ACTION_SET);
			} else if (ACTION_APPEND.equals(type)) {
				action.setActionType(RewriteAction.ACTION_APPEND);
			} else if (ACTION_PREPEND.equals(type)) {
				action.setActionType(RewriteAction.ACTION_PREPEND);
			} else if (ACTION_REPLACE.equals(type)) {
				action.setActionType(RewriteAction.ACTION_REPLACE);
				String regex = actionElement.getAttributeValue(ATT_REGEX);
				if (regex != null) {
					action.setRegex(regex);
				}
			} else if (ACTION_REMOVE.equals(type)) {
				action.setActionType(RewriteAction.ACTION_REMOVE);
			} else {
				action.setActionType(RewriteAction.ACTION_SET);
			}
		}

		return action;
	}

	protected void buildDataSource(OMElement elem, AbstractDBMediator mediator) {

		OMElement pool;

		try {
			SynapseXPath xpath = new SynapseXPath("self::node()/syn:connection/syn:pool");
			xpath.addNamespace("syn", XMLConfigConstants.SYNAPSE_NAMESPACE);
			pool = (OMElement) xpath.selectSingleNode(elem);
			if (pool.getFirstChildWithName(DSNAME_Q) != null) {
				readLookupConfig(mediator, pool);
			} else if (pool.getFirstChildWithName(DRIVER_Q) != null) {
				readCustomDataSourceConfig(pool, mediator);
			}
		} catch (JaxenException e) {
			// ignore
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

	private void readLookupConfig(AbstractDBMediator mediator, OMElement pool) {
		String dataSourceName = getValue(pool, DSNAME_Q);
		mediator.setDataSourceName(dataSourceName);
		saveElementConfig(pool, DSNAME_Q, mediator);

		if (pool.getFirstChildWithName(ICCLASS_Q) != null) {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, getValue(pool, ICCLASS_Q));
			props.put(Context.PROVIDER_URL, getValue(pool, URL_Q));
			props.put(Context.SECURITY_PRINCIPAL, getValue(pool, USER_Q));
			props.put(Context.SECURITY_CREDENTIALS, getValue(pool, PASS_Q));
			mediator.setJndiProperties(props);

			saveElementConfig(pool, ICCLASS_Q, mediator);
			saveElementConfig(pool, URL_Q, mediator);
			saveElementConfig(pool, USER_Q, mediator);
			saveElementConfig(pool, PASS_Q, mediator);
		}

	}

	private void readCustomDataSourceConfig(OMElement pool, AbstractDBMediator mediator) {

		// TODO import secure vault
		DataSourceInformation dataSourceInformation = new DataSourceInformation();

		String driver = getKey(pool, DRIVER_Q);
		if (driver != null) {
			mediator.setRegistryBasedDriverConfig(true);
		} else {
			driver = getValue(pool, DRIVER_Q);
		}
		dataSourceInformation.setDriver(driver);
		mediator.addDataSourceProperty(DRIVER_Q, driver);

		String url = getKey(pool, URL_Q);
		if (url != null) {
			mediator.setRegistryBasedUrlConfig(true);
		} else {
			url = getValue(pool, URL_Q);
		}
		dataSourceInformation.setUrl(url);
		mediator.addDataSourceProperty(URL_Q, url);

		// SecretInformation secretInformation = new SecretInformation();

		String user = getKey(pool, USER_Q);
		if (user != null) {
			mediator.setRegistryBasedUserConfig(true);
		} else {
			user = getValue(pool, USER_Q);
		}
		// secretInformation.setUser(user);
		mediator.addDataSourceProperty(USER_Q, user);

		String password = getKey(pool, PASS_Q);
		if (password != null) {
			mediator.setRegistryBasedPassConfig(true);
		} else {
			password = getValue(pool, PASS_Q);
		}
		// secretInformation.setAliasSecret(password);
		mediator.addDataSourceProperty(PASS_Q, password);

		// dataSourceInformation.setSecretInformation(secretInformation);

		mediator.setDataSourceInformation(dataSourceInformation);
	}

	private void saveElementConfig(OMElement element, QName qname, AbstractDBMediator mediator) {
		mediator.addDataSourceProperty(qname, getValue(element, qname));
	}

	private String getKey(OMElement pool, QName qName) {
		OMElement ele = pool.getFirstChildWithName(qName);
		if (ele != null) {
			return ele.getAttributeValue(ATT_KEY);
		}
		return null;
	}

	private List<Property> generatePropertyList(Iterator<OMElement> iterator) {

		List<Property> propertyList = new ArrayList<Property>();
		while (iterator.hasNext()) {
			OMElement element = iterator.next();
			Property property = new Property();
			OMAttribute nameAttr = element.getAttribute(ATT_NAME);
			if (nameAttr != null) {
				property.setKey(nameAttr.getAttributeValue());
			}

			OMAttribute typeAttr = element.getAttribute(TYPE_QNAME);
			if (typeAttr != null) {
				property.setType(typeAttr.getAttributeValue());
			}

			OMAttribute valueAttr = element.getAttribute(ATT_VALUE);

			if (valueAttr != null) {
				property.setValue(valueAttr.getAttributeValue());
			} else {
				try {
					property.setExpression(SynapseXPathFactory.getSynapseXPath(element, ATT_EXPRN));
				} catch (JaxenException e) {
					// ignore
				}
			}

			OMAttribute defaultAtr = element.getAttribute(DEFAULT_QNAME);
			if (defaultAtr != null) {
				property.setDefaultValue(defaultAtr.getAttributeValue());
			}

			propertyList.add(property);
		}
		return propertyList;
	}

}
