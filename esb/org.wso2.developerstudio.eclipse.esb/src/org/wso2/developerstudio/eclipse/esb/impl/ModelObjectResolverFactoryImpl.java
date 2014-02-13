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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.ModelObjectResolver;
import org.wso2.developerstudio.eclipse.esb.ModelObjectResolverFactory;
import org.wso2.developerstudio.eclipse.esb.ProxyService;
import org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration;
import org.wso2.developerstudio.eclipse.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.LogMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsFactory;
import org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;

/**
 * Default implementation of {@link ModelObjectResolverFactory} interface.
 */
public class ModelObjectResolverFactoryImpl implements
		ModelObjectResolverFactory {
	/**
	 * Singleton factory instance;
	 */
	private static ModelObjectResolverFactory singleton;

	/**
	 * DOM element local name to {@link ModelObjectResolver} map.
	 */
	private Map<String, ModelObjectResolver> localNameToResolverMap;

	/**
	 * Creates a new {@link ModelObjectResolverFactoryImpl} instance.
	 */
	private ModelObjectResolverFactoryImpl() {
		localNameToResolverMap = new HashMap<String, ModelObjectResolver>();
		initResolvers();
	}

	/**
	 * Utility method for obtaining a reference to the global factory instance.
	 * 
	 * @return global {@link ModelObjectResolverFactory} instance.
	 */
	public static ModelObjectResolverFactory getInstance() {
		if (null == singleton) {
			singleton = new ModelObjectResolverFactoryImpl();
		}

		return singleton;
	}

	/**
	 * {@inheritDoc}
	 */
	public ModelObjectResolver getResolver(String localName) {
		return localNameToResolverMap.get(localName);
	}

	/**
	 * Utility method for obtaining a reference to global {@link EsbFactory}
	 * instance.
	 * 
	 * @return global {@link EsbFactory} instance.
	 */
	private EsbFactory getEsbFactory() {
		return EsbFactory.eINSTANCE;
	}

	/**
	 * Utility method for obtaining a reference to global
	 * {@link MediatorsFactory} instance.
	 * 
	 * @return global {@link MediatorsFactory} instance.
	 */
	private MediatorsFactory getMediatorFactory() {
		return MediatorsFactory.eINSTANCE;
	}

	/**
	 * Initialize resolvers.
	 */
	private void initResolvers() {
		/**
		 * Resolver corresponding to <definitions/> tag.
		 */
		localNameToResolverMap.put("definitions", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getEsbFactory().createSynapseConfiguration();
			}
		});

		/**
		 * Resolver corresponding to <in/> tag.
		 */
		localNameToResolverMap.put("in", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createInMediator();
			}
		});

		/**
		 * Resolver corresponding to <input/> tag in smooks.
		 */
		localNameToResolverMap.put("input", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				if (parent instanceof SmooksMediator) {
					return getMediatorFactory().createSmooksInConfiguration();
				} else {
					return null;
				}
			}
		});

		/**
		 * Resolver corresponding to <output/> tag in smooks.
		 */
		localNameToResolverMap.put("output", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				if (parent instanceof SmooksMediator) {
					return getMediatorFactory().createSmooksOutConfiguration();
				} else {
					return null;
				}
			}
		});

		/**
		 * Resolver corresponding to <out/> tag.
		 */
		localNameToResolverMap.put("out", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createOutMediator();
			}
		});

		/**
		 * Resolver corresponding to <send/> tag.
		 */
		localNameToResolverMap.put("send", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createSendMediator();
			}
		});

		/**
		 * Resolver corresponding to <drop/> tag.
		 */
		localNameToResolverMap.put("drop", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createDropMediator();
			}
		});

		/**
		 * Resolver corresponding to <endpoint/> tag.
		 */
		localNameToResolverMap.put("endpoint", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (elem.hasAttribute("key-expression")) {
					obj = getEsbFactory().createXPathEndPointReference();
				} else if (elem.hasAttribute("key")) {
					obj = getEsbFactory().createRegistryKeyEndPointReference();
				} else if (EsbUtils.elementContainsChild(elem, "default")) {
					obj = getEsbFactory().createDefaultEndPoint();
				} else if (EsbUtils.elementContainsChild(elem, "address")) {
					obj = getEsbFactory().createAddressEndPoint();
				} else if (EsbUtils.elementContainsChild(elem, "wsdl")) {
					obj = getEsbFactory().createWsdlEndPoint();
				} else if (EsbUtils.elementContainsChild(elem, "failover")) {
					obj = getEsbFactory().createFailoverEndPoint();
				} else if (EsbUtils.elementContainsChild(elem, "loadbalance")) {
					obj = getEsbFactory().createLoadBalanceEndPoint();
				} else if (EsbUtils.elementContainsChild(elem,
						"dynamicLoadBalance")) {
					obj = getEsbFactory().createDynamicLoadBalanceEndPoint();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <log/> tag.
		 */
		localNameToResolverMap.put("log", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createLogMediator();
			}
		});

		/**
		 * Resolver corresponding to <property/> tag.
		 */
		localNameToResolverMap.put("property", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof LogMediator) {
					obj = getMediatorFactory().createLogProperty();
				} else if (parent instanceof ClassMediator) {
					obj = getMediatorFactory().createClassProperty();
				} else if (parent instanceof XSLTMediator) {
					obj = getMediatorFactory().createXSLTProperty();
				} else if (parent instanceof CommandMediator) {
					obj = getMediatorFactory().createCommandProperty();
				} else if (parent instanceof RuleSetConfiguration) {
					obj = getMediatorFactory().createRuleSetCreationProperty();
				} else if (parent instanceof RuleSessionConfiguration) {
					obj = getMediatorFactory().createRuleSessionProperty();
				} else if (parent instanceof DynamicLoadBalanceEndPoint) {
					obj = getEsbFactory().createDynamicLoadBalanceProperty();
				} else {
					obj = getMediatorFactory().createPropertyMediator();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <sequence/> tag.
		 */
		localNameToResolverMap.put("sequence", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (elem.hasAttribute("key")) {
					obj = getMediatorFactory().createSequenceMediator();
				} else {
					obj = getEsbFactory().createMediatorSequence();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <filter/> tag.
		 */
		localNameToResolverMap.put("filter", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createFilterMediator();
			}
		});

		/**
		 * Resolver corresponding to <then/> tag.
		 */
		localNameToResolverMap.put("then", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createFilterThenBranch();
			}
		});

		/**
		 * Resolver corresponding to <else/> tag.
		 */
		localNameToResolverMap.put("else", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createFilterElseBranch();
			}
		});

		/**
		 * Resolver corresponding to <switch/> tag.
		 */
		localNameToResolverMap.put("switch", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createSwitchMediator();
			}
		});

		/**
		 * Resolver corresponding to <case/> tag.
		 */
		localNameToResolverMap.put("case", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createSwitchCaseBranch();
			}
		});

		/**
		 * Resolver corresponding to <default/> tag.
		 */
		localNameToResolverMap.put("default", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createSwitchDefaultBranch();
			}
		});

		/**
		 * Resolver corresponding to <entitlementService/> tag.
		 */
		localNameToResolverMap.put("entitlementService",
				new ModelObjectResolver() {
					public ModelObject resolve(Element elem, ModelObject parent) {
						return getMediatorFactory().createEntitlementMediator();
					}
				});
		/**
		 * Resolver corresponding to <enqueue/> tag.
		 */
		localNameToResolverMap.put("enqueue", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createEnqueueMediator();
			}
		});

		/**
		 * Resolver corresponding to <class/> tag.
		 */
		localNameToResolverMap.put("class", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createClassMediator();
			}
		});

		/**
		 * Resolver corresponding to <spring/> tag.
		 */
		localNameToResolverMap.put("spring", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createSpringMediator();
			}
		});

		/**
		 * Resolver corresponding to <validate/> tag.
		 */
		localNameToResolverMap.put("validate", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createValidateMediator();
			}
		});

		/**
		 * Resolver corresponding to <on-fail/> tag.
		 */
		localNameToResolverMap.put("on-fail", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createValidateOnFailBranch();
			}
		});

		/**
		 * Resolver corresponding to <schema/> tag.
		 */
		localNameToResolverMap.put("schema", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createValidateSchema();
			}
		});

		/**
		 * Resolver corresponding to <feature/> tag.
		 */
		localNameToResolverMap.put("feature", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof ValidateMediator) {
					obj = getMediatorFactory().createValidateFeature();
				} else if (parent instanceof XSLTMediator) {
					obj = getMediatorFactory().createXSLTFeature();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <proxy/> tag.
		 */
		localNameToResolverMap.put("proxy", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getEsbFactory().createProxyService();
			}
		});

		/**
		 * Resolver corresponding to <policy/> tag.
		 */
		localNameToResolverMap.put("policy", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof ProxyService) {
					obj = getEsbFactory().createProxyServicePolicy();
				} else if (parent instanceof ThrottleMediator) {
					obj = getMediatorFactory()
							.createThrottlePolicyConfiguration();
				} else if (parent instanceof ThrottlePolicyConfiguration) {
					obj = getMediatorFactory().createThrottlePolicyEntry();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <Policy/> (With a capital 'P') tag.
		 */
		localNameToResolverMap.put("Policy", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof ThrottlePolicyConfiguration) {
					obj = getMediatorFactory().createThrottlePolicyEntry();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <parameter/> tag.
		 */
		localNameToResolverMap.put("parameter", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof ProxyService) {
					obj = getEsbFactory().createProxyServiceParameter();
				} else if (parent instanceof SqlStatement) {
					obj = getMediatorFactory().createSqlParameterDefinition();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <script/> tag.
		 */
		localNameToResolverMap.put("script", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createScriptMediator();
			}
		});

		/**
		 * Resolver corresponding to <resource/> tag.
		 */
		localNameToResolverMap.put("resource", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof ProxyWsdlConfiguration) {
					obj = getEsbFactory().createProxyWsdlResource();
				} else if (parent instanceof XSLTMediator) {
					obj = getMediatorFactory().createXSLTResource();
				}else if(parent instanceof ValidateMediator){
					obj = getMediatorFactory().createValidateResource();
				}else if(parent instanceof SynapseAPI){
					obj = getEsbFactory().createApiResource();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <smooks/> tag.
		 */
		localNameToResolverMap.put("smooks", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createSmooksMediator();
			}
		});

		/**
		 * Resolver corresponding to <enrich/> tag.
		 */
		localNameToResolverMap.put("enrich", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createEnrichMediator();
			}
		});

		/**
		 * Resolver corresponding to <target/> tag.
		 */
		localNameToResolverMap.put("target", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof RouterRoute) {
					obj = getMediatorFactory().createRouteTarget();
				} else if (parent instanceof CloneMediator) {
					obj = getMediatorFactory().createCloneTarget();
				} else if (parent instanceof IterateMediator) {
					obj = getMediatorFactory().createIterateTarget();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <makefault/> tag.
		 */
		localNameToResolverMap.put("makefault", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createFaultMediator();
			}
		});

		/**
		 * Resolver corresponding to <aggregate/> tag.
		 */
		localNameToResolverMap.put("aggregate", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createAggregateMediator();
			}
		});

		/**
		 * Resolver corresponding to <onComplete/> tag.
		 */
		localNameToResolverMap.put("onComplete", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createAggregateOnCompleteBranch();
			}
		});

		/**
		 * Resolver corresponding to <router/> tag.
		 */
		localNameToResolverMap.put("router", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRouterMediator();
			}
		});

		/**
		 * Resolver corresponding to <route/> tag.
		 */
		localNameToResolverMap.put("route", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRouterRoute();
			}
		});

		/**
		 * Resolver corresponding to <clone/> tag.
		 */
		localNameToResolverMap.put("clone", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createCloneMediator();
			}
		});

		/**
		 * Resolver corresponding to <cache/> tag.
		 */
		localNameToResolverMap.put("cache", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createCacheMediator();
			}
		});

		/**
		 * Resolver corresponding to <onCacheHit/> tag.
		 */
		localNameToResolverMap.put("onCacheHit", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createCacheOnHitBranch();
			}
		});

		/**
		 * Resolver corresponding to <xslt/> tag.
		 */
		localNameToResolverMap.put("xslt", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createXSLTMediator();
			}
		});

		/**
		 * Resolver corresponding to <xquery/> tag.
		 */
		localNameToResolverMap.put("xquery", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createXQueryMediator();
			}
		});

		/**
		 * Resolver corresponding to <variable/> tag.
		 */
		localNameToResolverMap.put("variable", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createXQueryVariable();
			}
		});

		/**
		 * Resolver corresponding to <callout/> tag.
		 */
		localNameToResolverMap.put("callout", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createCalloutMediator();
			}
		});

		/**
		 * Resolver corresponding to <iterate/> tag.
		 */
		localNameToResolverMap.put("iterate", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createIterateMediator();
			}
		});

		/**
		 * Resolver corresponding to <RMSequence/> tag.
		 */
		localNameToResolverMap.put("RMSequence", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRMSequenceMediator();
			}
		});

		/**
		 * Resolver corresponding to <transaction/> tag.
		 */
		localNameToResolverMap.put("transaction", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createTransactionMediator();
			}
		});

		/**
		 * Resolver corresponding to <oauthService/> tag.
		 */
		localNameToResolverMap.put("oauthService", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createOAuthMediator();
			}
		});

		/**
		 * Resolver corresponding to <autoscaleIn/> tag.
		 */
		localNameToResolverMap.put("autoscaleIn", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createAutoscaleInMediator();
			}
		});

		/**
		 * Resolver corresponding to <autoscaleOut/> tag.
		 */
		localNameToResolverMap.put("autoscaleOut", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createAutoscaleOutMediator();
			}
		});

		/**
		 * Resolver corresponding to <header/> tag.
		 */
		localNameToResolverMap.put("header", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createHeaderMediator();
			}
		});

		/**
		 * Resolver corresponding to <throttle/> tag.
		 */
		localNameToResolverMap.put("throttle", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createThrottleMediator();
			}
		});

		/**
		 * Resolver corresponding to <onAccept/> tag.
		 */
		localNameToResolverMap.put("onAccept", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createThrottleOnAcceptBranch();
			}
		});

		/**
		 * Resolver corresponding to <onReject/> tag.
		 */
		localNameToResolverMap.put("onReject", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createThrottleOnRejectBranch();
			}
		});

		/**
		 * Resolver corresponding to <pojoCommand/> tag.
		 */
		localNameToResolverMap.put("pojoCommand", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createCommandMediator();
			}
		});

		/**
		 * Resolver corresponding to <event/> tag.
		 */
		localNameToResolverMap.put("event", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createEventMediator();
			}
		});

		/**
		 * Resolver corresponding to <dblookup/> tag.
		 */
		localNameToResolverMap.put("dblookup", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createDBLookupMediator();
			}
		});

		/**
		 * Resolver corresponding to <dbreport/> tag.
		 */
		localNameToResolverMap.put("dbreport", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createDBReportMediator();
			}
		});

		/**
		 * Resolver corresponding to <result/> tag.
		 */
		localNameToResolverMap.put("result", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				ModelObject obj = null;
				if (parent instanceof SqlStatement) {
					obj = getMediatorFactory().createSqlResultMapping();
				} else if (parent instanceof RuleResultsConfiguration) {
					obj = getMediatorFactory().createRuleResult();
				}
				return obj;
			}
		});

		/**
		 * Resolver corresponding to <statement/> tag.
		 */
		localNameToResolverMap.put("statement", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createSqlStatement();
			}
		});

		/**
		 * Resolver corresponding to <rule/> tag.
		 */
		localNameToResolverMap.put("rule", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRuleMediator();
			}
		});

		/**
		 * Resolver corresponding to <ruleset/> tag.
		 */
		localNameToResolverMap.put("ruleset", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRuleSetConfiguration();
			}
		});

		/**
		 * Resolver corresponding to <session/> tag.
		 */
		localNameToResolverMap.put("session", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRuleSessionConfiguration();
			}
		});

		/**
		 * Resolver corresponding to <facts/> tag.
		 */
		localNameToResolverMap.put("facts", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRuleFactsConfiguration();
			}
		});

		/**
		 * Resolver corresponding to <fact/> tag.
		 */
		localNameToResolverMap.put("fact", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRuleFact();
			}
		});

		/**
		 * Resolver corresponding to <results/> tag.
		 */
		localNameToResolverMap.put("results", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createRuleResultsConfiguration();
			}
		});

		/**
		 * Resolver corresponding to <childMediators/> tag.
		 */
		localNameToResolverMap.put("childMediators", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory()
						.createRuleChildMediatorsConfiguration();
			}
		});

		/**
		 * Resolver corresponding to <builder/> tag.
		 */
		localNameToResolverMap.put("builder", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createBuilderMediator();
			}
		});

		/**
		 * Resolver corresponding to <messageBuilder/> tag.
		 */
		localNameToResolverMap.put("messageBuilder", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createMessageBuilder();
			}
		});

		/**
		 * Resolver corresponding to <localEntry/> tag.
		 */
		localNameToResolverMap.put("localEntry", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getEsbFactory().createLocalEntry();
			}
		});

		/**
		 * Resolver corresponding to <store/> tag.
		 */
		localNameToResolverMap.put("store", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createStoreMediator();
			}
		});

		/**
		 * Resolver corresponding to <conditionalRouter/> tag.
		 */

		localNameToResolverMap.put("conditionalRouter",
				new ModelObjectResolver() {
					public ModelObject resolve(Element elem, ModelObject parent) {
						return getMediatorFactory()
								.createConditionalRouterMediator();
					}
				});

		/**
		 * Resolver corresponding to <conditionalRoute/> tag.
		 */

		localNameToResolverMap.put("conditionalRoute",
				new ModelObjectResolver() {
					public ModelObject resolve(Element elem, ModelObject parent) {
						return getMediatorFactory()
								.createConditionalRouteBranch();
					}
				});
		
		/**
		 * Resolver corresponding to <rewrite/> tag.
		 */
		localNameToResolverMap.put("rewrite", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createURLRewriteMediator();
			}
		});
		
		/**
		 * Resolver corresponding to <rewriterule/> tag.
		 */
		localNameToResolverMap.put("rewriterule", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createURLRewriteRule();
			}
		});
		
		/**
		 * Resolver corresponding to <action/> tag.
		 */
		localNameToResolverMap.put("action", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createURLRewriteRuleAction();
			}
		});
		
		/**
		 * Resolver corresponding to <eventPublisher/> tag.
		 */
		localNameToResolverMap.put("eventPublisher", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createEventMediator();
			}
		});
		
		/**
		 * Resolver corresponding to <eventPublisher/> tag.
		 */
		localNameToResolverMap.put("eventPublisher", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createEventMediator();
			}
		});
		
		/**
		 * Resolver corresponding to <call-template/> tag.
		 */
		localNameToResolverMap.put("call-template", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createCallTemplateMediator();
			}
		});
		

		/**
		 * Resolver corresponding to <with-param/> tag.
		 */
		localNameToResolverMap.put("with-param", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createCallTemplateParameter();
			}
		});
		
		/**
		 * Resolver corresponding to <payloadFactory/> tag.
		 */
		localNameToResolverMap.put("payloadFactory", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createPayloadFactoryMediator();
			}
		});
		
		/**
		 * Resolver corresponding to <arg/> tag.
		 */
		localNameToResolverMap.put("arg", new ModelObjectResolver() {
			public ModelObject resolve(Element elem, ModelObject parent) {
				return getMediatorFactory().createPayloadFactoryArgument();
			}
		});
		
		/**
		 * Resolver corresponding to <description/> tag.
		 */
		localNameToResolverMap.put("description", new ModelObjectResolver() {			
			public ModelObject resolve(Element elem, ModelObject parent) {
			return getEsbFactory().createDescription();
			}
		});
		
		/**
		 * Resolver Corresponding to <task/> tag.
		 */
		localNameToResolverMap.put("task", new ModelObjectResolver() {			
			public ModelObject resolve(Element elem, ModelObject parent) {
			return getEsbFactory().createTask();
			}
		});
		
		/**
		 * Resolver Corresponding to <api/> tag.
		 */
		localNameToResolverMap.put("api", new ModelObjectResolver() {			
			public ModelObject resolve(Element elem, ModelObject parent) {
			return getEsbFactory().createSynapseAPI();
			}
		});
		
//		/**
//		 * Resolver Corresponding to <resource/> tag.
//		 */
//		localNameToResolverMap.put("resource", new ModelObjectResolver() {			
//			public ModelObject resolve(Element elem, ModelObject parent) {
//			return getEsbFactory().createApiResource();
//			}
//		});
		
		
	}
}
