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
package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

import java.util.HashMap;
import java.util.Map;

import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.APIResourceTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.AddresingEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.AddressEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.AggregateMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.BAMMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.BeanMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.BuilderMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.CacheMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.CallMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.CallTemplateMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.CalloutMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ClassMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.CloneMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.CloudConnectorOperationTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.CommandMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ConditionalRouterMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.DBLookupMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.DBReportMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.DataMapperMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.DefaultEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.DropMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.EJBMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.EnqueueMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.EnrichMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.EntitlementMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.EventMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.FailoverEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.FastXSLTMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.FaultMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.FilterMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ForEachMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.HTTPEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.HeaderMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.IterateMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.LoadBalanceEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.LogMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.LoopBackMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.MessageMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.NamedEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.OAuthMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.PayloadFactoryMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.PropertyMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ProxyServiceTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.PublishEventMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.RecipientListEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.RespondMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.RouterMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.RuleMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ScriptMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.SendMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.SequenceMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.SequenceTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.SmooksMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.SpringMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.StoreMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.SwitchMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.TemplateEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.TemplateTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ThrottleMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.TransactionMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.URLReWriterMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.ValidateMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.WSDLEndPointTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.XQueryMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.XSLTMediatorTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.MediatorSerializerRegister;

/**
 * A registry of visual model object transformers.
 */
public class EsbTransformerRegistry {
	/**
	 * Singleton instance.
	 */
	private static EsbTransformerRegistry singleton;		
	
	/**
	 * Visual model type to transformers map.
	 */
	private Map<Class<?>, EsbNodeTransformer> transformersMap;
	
	/**
	 * Creates a new transformer registry.
	 */
	private EsbTransformerRegistry() {
		MediatorSerializerRegister.registerSerializers(); /* Register Custom serializers */
		transformersMap = new HashMap<Class<?>, EsbNodeTransformer>();
		addTransformer(ProxyService.class, new ProxyServiceTransformer());
		addTransformer(DefaultEndPoint.class, new DefaultEndPointTransformer());
		addTransformer(AddressEndPoint.class, new AddressEndPointTransformer());
		addTransformer(DropMediator.class, new DropMediatorTransformer());
		addTransformer(FilterMediator.class, new FilterMediatorTransformer());
		addTransformer(LogMediator.class, new LogMediatorTransformer());
		addTransformer(PropertyMediator.class, new PropertyMediatorTransformer());
		addTransformer(EnrichMediator.class, new EnrichMediatorTransformer());
		addTransformer(XSLTMediator.class, new XSLTMediatorTransformer());
		addTransformer(FastXSLTMediator.class, new FastXSLTMediatorTransformer());
		addTransformer(SwitchMediator.class, new SwitchMediatorTransformer());
		addTransformer(MessageMediator.class, new MessageMediatorTransformer());
		addTransformer(ClassMediator.class, new ClassMediatorTransformer());
		addTransformer(FaultMediator.class, new FaultMediatorTransformer());
		addTransformer(EventMediator.class, new EventMediatorTransformer());
		addTransformer(FailoverEndPoint.class, new FailoverEndPointTransformer());
		addTransformer(WSDLEndPoint.class, new WSDLEndPointTransformer());
		addTransformer(LoadBalanceEndPoint.class, new LoadBalanceEndPointTransformer());
		addTransformer(XQueryMediator.class, new XQueryMediatorTransformer());
		addTransformer(Sequence.class, new SequenceMediatorTransformer());
		addTransformer(DBLookupMediator.class, new DBLookupMediatorTransformer());
		addTransformer(DBReportMediator.class, new DBReportMediatorTransformer());
		addTransformer(HeaderMediator.class, new HeaderMediatorTransformer());
		addTransformer(CacheMediator.class, new CacheMediatorTransformer());
		addTransformer(AggregateMediator.class, new AggregateMediatorTransformer());
		addTransformer(CalloutMediator.class, new CalloutMediatorTransformer());
		addTransformer(TransactionMediator.class, new TransactionMediatorTransformer());
		addTransformer(IterateMediator.class, new IterateMediatorTransformer());
		addTransformer(CloneMediator.class, new CloneMediatorTransformer());
		addTransformer(ThrottleMediator.class, new ThrottleMediatorTransformer());
		addTransformer(OAuthMediator.class, new OAuthMediatorTransformer());
		addTransformer(RuleMediator.class, new RuleMediatorTransformer());
		addTransformer(SendMediator.class, new SendMediatorTransformer());
		addTransformer(SpringMediator.class, new SpringMediatorTransformer());
		addTransformer(ScriptMediator.class, new ScriptMediatorTransformer());
		addTransformer(SmooksMediator.class, new SmooksMediatorTransformer());
		addTransformer(EntitlementMediator.class, new EntitlementMediatorTransformer());
		addTransformer(CommandMediator.class, new CommandMediatorTransformer());
		addTransformer(StoreMediator.class, new StoreMediatorTransformer());
		addTransformer(EnqueueMediator.class, new EnqueueMediatorTransformer());
		addTransformer(PayloadFactoryMediator.class, new PayloadFactoryMediatorTransformer());
		addTransformer(CallTemplateMediator.class, new CallTemplateMediatorTransformer());
		addTransformer(RouterMediator.class, new RouterMediatorTransformer());
		addTransformer(ConditionalRouterMediator.class, new ConditionalRouterMediatorTransformer());
		addTransformer(ValidateMediator.class, new ValidateMediatorTransformer());
		addTransformer(URLRewriteMediator.class, new URLReWriterMediatorTransformer());
		addTransformer(BuilderMediator.class, new BuilderMediatorTransformer());
		addTransformer(NamedEndpoint.class, new NamedEndPointTransformer());
		addTransformer(APIResource.class, new APIResourceTransformer());
		addTransformer(Template.class, new TemplateTransformer());
		addTransformer(BAMMediator.class, new BAMMediatorTransformer());
		addTransformer(EJBMediator.class, new EJBMediatorTransformer());
		addTransformer(BeanMediator.class, new BeanMediatorTransformer());
		addTransformer(Sequences.class, new SequenceTransformer());
		addTransformer(AddressingEndpoint.class, new AddresingEndPointTransformer());
		addTransformer(RecipientListEndPoint.class, new RecipientListEndPointTransformer());
		addTransformer(HTTPEndpoint.class, new HTTPEndPointTransformer());
		addTransformer(TemplateEndpoint.class, new TemplateEndPointTransformer());
		addTransformer(CloudConnectorOperation.class, new CloudConnectorOperationTransformer());
		addTransformer(LoopBackMediator.class, new LoopBackMediatorTransformer());
		addTransformer(RespondMediator.class, new RespondMediatorTransformer());
		addTransformer(CallMediator.class, new CallMediatorTransformer());
		addTransformer(DataMapperMediator.class, new DataMapperMediatorTransformer());
		addTransformer(ForEachMediator.class, new ForEachMediatorTransformer());
		addTransformer(PublishEventMediator.class, new PublishEventMediatorTransformer());
	}
	
	/**
	 * @return singleton instance.
	 */
	public static EsbTransformerRegistry getInstance() {
		if (null == singleton) {
			singleton = new EsbTransformerRegistry();
		}
		return singleton;
	}
	
	/**
	 * Adds a new transformer into this registry.
	 * 
	 * @param <K>
	 * @param visualModelClass
	 * @param transformer
	 */
	public <K extends EsbNode>  void addTransformer(Class<K> visualModelClass, EsbNodeTransformer transformer) {
		transformersMap.put(visualModelClass, transformer);
	}
	
	/**
	 * Attempts to locate a transformer corresponding to the specified visual model object.
	 * 
	 * @param <K>
	 * @param esbNode
	 * @return
	 */
	public <K extends EsbNode>  EsbNodeTransformer getTransformer(K esbNode) {
		return transformersMap.get(esbNode.eClass().getInstanceClass());
	}
}
