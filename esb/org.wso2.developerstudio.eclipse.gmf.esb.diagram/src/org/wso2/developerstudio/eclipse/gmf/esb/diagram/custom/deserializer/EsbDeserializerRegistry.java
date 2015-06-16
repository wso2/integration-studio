/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.HashMap;
import java.util.Map;

import org.apache.synapse.config.Entry;
import org.apache.synapse.core.axis2.ProxyService;
import org.apache.synapse.endpoints.AddressEndpoint;
import org.apache.synapse.endpoints.DefaultEndpoint;
import org.apache.synapse.endpoints.FailoverEndpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.LoadbalanceEndpoint;
import org.apache.synapse.endpoints.RecipientListEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.endpoints.SALoadbalanceEndpoint;
import org.apache.synapse.endpoints.Template;
import org.apache.synapse.endpoints.TemplateEndpoint;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.bsf.ScriptMediator;
import org.apache.synapse.mediators.builtin.CallMediator;
import org.apache.synapse.mediators.builtin.CalloutMediator;
import org.apache.synapse.mediators.builtin.CommentMediator;
import org.apache.synapse.mediators.builtin.DropMediator;
import org.apache.synapse.mediators.builtin.EnqueueMediator;
import org.apache.synapse.mediators.builtin.ForEachMediator;
import org.apache.synapse.mediators.builtin.LogMediator;
import org.apache.synapse.mediators.builtin.LoopBackMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.apache.synapse.mediators.builtin.RespondMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.mediators.builtin.ValidateMediator;
import org.apache.synapse.mediators.builtin.CacheMediator;
import org.apache.synapse.mediators.db.DBLookupMediator;
import org.apache.synapse.mediators.db.DBReportMediator;
import org.apache.synapse.mediators.eip.aggregator.AggregateMediator;
import org.apache.synapse.mediators.eip.splitter.CloneMediator;
import org.apache.synapse.mediators.eip.splitter.IterateMediator;
import org.apache.synapse.mediators.elementary.EnrichMediator;
import org.apache.synapse.mediators.filters.FilterMediator;
import org.apache.synapse.mediators.filters.SwitchMediator;
import org.apache.synapse.mediators.filters.router.ConditionalRouterMediator;
import org.apache.synapse.mediators.spring.SpringMediator;
import org.apache.synapse.mediators.store.MessageStoreMediator;
import org.apache.synapse.mediators.template.InvokeMediator;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.apache.synapse.mediators.throttle.ThrottleMediator;
import org.apache.synapse.mediators.transaction.TransactionMediator;
import org.apache.synapse.mediators.transform.FaultMediator;
import org.apache.synapse.mediators.transform.HeaderMediator;
import org.apache.synapse.mediators.transform.PayloadFactoryMediator;
import org.apache.synapse.mediators.transform.XSLTMediator;
import org.apache.synapse.mediators.transform.url.URLRewriteMediator;
import org.apache.synapse.mediators.xquery.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageStore;
import org.apache.synapse.rest.API;
import org.apache.synapse.task.TaskDescription;
import org.wso2.carbon.identity.entitlement.mediator.EntitlementMediator;
import org.wso2.carbon.identity.oauth.mediator.OAuthMediator;
import org.wso2.carbon.mediator.bam.BamMediator;
import org.wso2.carbon.mediator.event.EventMediator;
import org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator;
import org.wso2.carbon.mediator.publishevent.PublishEventMediator;
import org.wso2.carbon.mediator.transform.SmooksMediator;
import org.wso2.carbon.mediators.router.impl.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.BeanMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.BuilderMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.ClassMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CloudConnectorOperationExt;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyMessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.EJBMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.EntitlementMediatorExt;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.POJOCommandMediatorExt;
import org.apache.synapse.message.store.impl.memory.InMemoryStore;
import org.wso2.carbon.mediator.datamapper.DataMapperMediator;


/**
 * A registry of synapse model to model object deserializers.
 */
public class EsbDeserializerRegistry {
	/**
	 * Singleton instance.
	 */
	private static EsbDeserializerRegistry singleton;
	
	/**
	 * DeveloperStudio logger
	 * */
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	/**
	 * synapse model type to deserializers map.
	 */
	@SuppressWarnings("rawtypes")
	private Map<Class<?>, IEsbNodeDeserializer> deserializersMap;
	
	private EsbDiagramEditor diagramEditor;
	
	/**
	 * Creates a new deserialize registry.
	 */
	@SuppressWarnings("rawtypes")
	private EsbDeserializerRegistry(){
		MediatorFactoryUtils.registerFactories(); /* register custom factories */
		deserializersMap = new HashMap<Class<?>, IEsbNodeDeserializer>();
		addDeserializer(LogMediator.class,new LogMediatorDeserializer());
		addDeserializer(PropertyMediator.class,new PropertyMediatorDeserializer());
		addDeserializer(ProxyService.class, new ProxyServiceDeserializer());
		addDeserializer(SendMediator.class, new SendMediatorDeserializer());
		addDeserializer(CloneMediator.class, new CloneMediatorDeserializer());
		addDeserializer(DropMediator.class, new DropMediatorDeserializer());
		addDeserializer(EnrichMediator.class, new EnrichMediatorDeserializer());
		addDeserializer(EventMediator.class, new EventMediatorDeserializer());
		addDeserializer(EnqueueMediator.class, new EnqueueMediatorDeserializer());
		addDeserializer(ValidateMediator.class, new ValidateMediatorDeserializer());
		addDeserializer(AggregateMediator.class, new AggregateMediatorDeserializer());
		addDeserializer(FilterMediator.class,new FilterMediatorDeserializer());
		addDeserializer(SwitchMediator.class, new SwitchMediatorDeserializer());
		addDeserializer(SequenceMediator.class, new SequenceDeserializer());
		addDeserializer(API.class, new APIDeserializer());
		addDeserializer(XSLTMediator.class, new XSLTMediatorDeserializer());
		addDeserializer(FastXSLTMediator.class, new FastXSLTMediatorDeserializer());
		addDeserializer(XQueryMediator.class, new XQueryMediatorDeserializer());
		addDeserializer(HeaderMediator.class, new HeaderMediatorDeserializer());
		addDeserializer(FaultMediator.class, new FaultMediatorDeserializer());
		addDeserializer(URLRewriteMediator.class, new URLRewriteMediatorDeserializer());
		addDeserializer(CalloutMediator.class, new CalloutMediatorDeserializer());
		addDeserializer(DBLookupMediator.class, new DBLookupMediatorDeserializer());
		addDeserializer(DBReportMediator.class, new DBReportMediatorDeserializer());
		addDeserializer(EntitlementMediatorExt.class, new EntitlementMediatorDeserializer());
		addDeserializer(TransactionMediator.class, new TransactionMediatorDeserializer());
		addDeserializer(OAuthMediator.class, new OAuthMediatorDeserializer());
		addDeserializer(MessageStoreMediator.class, new StoreMediatorDeserializer());
		addDeserializer(BuilderMediatorExt.class, new BuilderMediatorDeserializer());
		addDeserializer(SpringMediator.class, new SpringMediatorDeserializer());
		addDeserializer(ScriptMediator.class, new ScriptMediatorDeserializer());
		addDeserializer(SmooksMediator.class, new SmooksMediatorDeserializer());
		addDeserializer(RouterMediator.class, new RouterMediatorDeserializer());
		addDeserializer(ClassMediatorExt.class, new ClassMediatorDeserializer());
		addDeserializer(POJOCommandMediatorExt.class, new POJOCommandMediatorDeserializer());
		addDeserializer(PayloadFactoryMediator.class, new PayloadFactoryMediatorDeserializer());
		addDeserializer(InvokeMediator.class, new CallTemplateMediatorDeserializer());
		addDeserializer(CacheMediator.class, new CacheMediatorDeserializer());
		addDeserializer(IterateMediator.class, new IterateMediatorDeserializer());
		addDeserializer(DefaultEndpoint.class, new DefaultEndpointDeserializer());
		addDeserializer(AddressEndpoint.class, new AddressEndpointDeserializer());
		addDeserializer(WSDLEndpoint.class, new WSDLEndpointDeserializer());
		addDeserializer(FailoverEndpoint.class, new FailoverEndpointDeserializer());
		addDeserializer(LoadbalanceEndpoint.class, new LoadBalanceEndpointDeserializer());
		addDeserializer(SALoadbalanceEndpoint.class, new LoadBalanceEndpointDeserializer());
		addDeserializer(ConditionalRouterMediator.class, new ConditionalRouterMediatorDeserializer());
		addDeserializer(ThrottleMediator.class, new ThrottleMediatorDeserializer());
		addDeserializer(RuleMediatorExt.class, new RuleMediatorDeserializer());
		addDeserializer(TemplateMediator.class, new SequenceTemplateDeserializer());
		addDeserializer(Template.class, new EndPointTemplateDeserializer());
		addDeserializer(EndpointWrapper.class, new EndPointDeserializer());
		addDeserializer(TaskDescription.class, new TaskDeserializer());
		addDeserializer(Entry.class, new LocalEntryDeserializer());
		addDeserializer(EJBMediatorExt.class, new EJBMediatorDeserializer());
		addDeserializer(BeanMediatorExt.class, new BeanMediatorDeserializer());
		addDeserializer(BamMediator.class, new BAMMediatorDeserializer());
		addDeserializer(IndirectEndpoint.class, new IndirectEndpointDeserializer());
		addDeserializer(ResolvingEndpoint.class, new ResolvingEndpointDeserializer());
		addDeserializer(RecipientListEndpoint.class, new RecipientListEndpointDeserializer());
		addDeserializer(InMemoryStore.class , new MessageStoreDeserializer());
		addDeserializer(DummyMessageStore.class , new MessageStoreDeserializer());
		addDeserializer(DummyMessageProcessor.class, new MessageProcessorDeserializer());
		addDeserializer(HTTPEndpoint.class, new HTTPEndpointDeserializer());
		addDeserializer(TemplateEndpoint.class, new TemplateEndpointDeserializer());
		addDeserializer(LoopBackMediator.class, new LoopBackMediatorDeserializer());
		addDeserializer(RespondMediator.class, new RespondMediatorDeserializer());
		addDeserializer(CallMediator.class, new CallMediatorDeserializer());
		addDeserializer(CloudConnectorOperationExt.class, new CloudConnectorOperationDeserializer());
		addDeserializer(DataMapperMediator.class, new DataMapperMediatorDeserializer());
		addDeserializer(InboundEndpoint.class, new InboundEndpointDeserializer());
		addDeserializer(ForEachMediator.class, new ForEachMediatorDeserializer());
		addDeserializer(CommentMediator.class, new CommentMediatorDeserializer());
		addDeserializer(PublishEventMediator.class, new PublishEventMediatorDeserializer());
	}
	
	/**
	 * @return singleton instance.
	 */
	public static EsbDeserializerRegistry getInstance() {
		if (null == singleton) {
			singleton = new EsbDeserializerRegistry();
		}
		return singleton;
	}
	
	/**
	 * initialize registry
	 */
	public void init(EsbDiagramEditor diagramEditor){
		this.diagramEditor = diagramEditor;
	}
	
	/**
	 * Adds a new deserializer into this registry.
	 * 
	 * @param synapseModelClass
	 * @param transformer
	 */
	@SuppressWarnings("rawtypes")
	public void addDeserializer(Class<?> synapseModelClass, IEsbNodeDeserializer deserializer) {
		deserializersMap.put(synapseModelClass, deserializer);
	}
	
	/**
	 * Attempts to locate a deserializer corresponding to the specified synapse model object.
	 * @param synapseModel
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public IEsbNodeDeserializer getDeserializer(Object synapseModel) {
		IEsbNodeDeserializer nodeDeserializer = deserializersMap.get(synapseModel.getClass());
		if(nodeDeserializer!=null){
			nodeDeserializer.setDiagramEditor(getDiagramEditor());
		} else{
			log.error("Can not find deserializer for synapse object " + synapseModel.getClass());
		}
		
		return nodeDeserializer;
	}
	
	/**
	 * Get active diagram editor 
	 * @return
	 */
	public EsbDiagramEditor getDiagramEditor() {
		return diagramEditor;
	}

}
