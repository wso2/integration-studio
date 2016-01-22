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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.SynapseConfigUtils;
import org.apache.synapse.core.axis2.ProxyService;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.filters.InMediator;
import org.apache.synapse.mediators.filters.OutMediator;
import org.apache.synapse.util.PolicyInfo;
import org.apache.synapse.util.resolver.ResourceMap;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWSDLResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyWsdlType;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbNodeTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * {@link EsbNodeTransformer} responsible for transforming
 * {@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyService} model objects into
 * corresponding synapse artifact(s).
 */
public class ProxyServiceTransformer extends AbstractEsbNodeTransformer {
	/**
	 * {@inheritDoc}
	 */
	public void transform(TransformationInfo info, EsbNode subject)
			throws TransformerException {
		if(((org.wso2.developerstudio.eclipse.gmf.esb.ProxyService) subject).isMainSequence()){
			transformAsMainSequence(info,subject);
		}else{
			try {
				transformAsProxy(info,subject);
			} catch (URISyntaxException e) {
				throw new TransformerException(e);
			} catch (XMLStreamException e) {
				throw new TransformerException(e);
			}
		}
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}


	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		// TODO Auto-generated method stub
		
	}

	
	/*
	 * Should be Reviewed and should be altered.
	 */	
	private EsbNode getOriginNode(org.wso2.developerstudio.eclipse.gmf.esb.ProxyService visualService){
		EList<EsbElement> children= visualService.getContainer().getFaultContainer().getMediatorFlow().getChildren();
		for(int i=0; i<children.size();++i){
			if(children.get(i) instanceof AggregateMediator){
				if(((AggregateMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}					
			}else if(children.get(i) instanceof CacheMediator){
				if(((CacheMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof CalloutMediator){
				if(((CalloutMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof CallTemplateMediator){
				if(((CallTemplateMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof ClassMediator){
				if(((ClassMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof CloneMediator){
				if(((CloneMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof CommandMediator){
				if(((CommandMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof DBLookupMediator){
				if(((DBLookupMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof DBReportMediator){
				if(((DBReportMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof DropMediator){
				if(((DropMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0)
					return children.get(i);
			}else if(children.get(i) instanceof EnqueueMediator){
				if(((EnqueueMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof EnrichMediator){
				if(((EnrichMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof EntitlementMediator){
				if(((EntitlementMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof EventMediator){
				if(((EventMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof FaultMediator){
				if(((FaultMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof FilterMediator){
				if(((FilterMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof HeaderMediator){
				if(((HeaderMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof IterateMediator){
				if(((IterateMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof LogMediator){
				if(((LogMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof OAuthMediator){
				if(((OAuthMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof PayloadFactoryMediator){
				if(((PayloadFactoryMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof PropertyMediator){
				if(((PropertyMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof RMSequenceMediator){
				if(((RMSequenceMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof RuleMediator){
				if(((RuleMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof ScriptMediator){
				if(((ScriptMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof SendMediator){
				if(((SendMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof SmooksMediator){
				if(((SmooksMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof SpringMediator){
				if(((SpringMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof StoreMediator){
				if(((StoreMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof SwitchMediator){
				if(((SwitchMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof ThrottleMediator){
				if(((ThrottleMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof XQueryMediator){
				if(((XQueryMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof XSLTMediator){
				if(((XSLTMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof FastXSLTMediator){
				if(((FastXSLTMediator)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof BAMMediator){
				if(((BAMMediator)children.get(i)).getInputConnector().getIncomingLinks().size() == 0){
					return children.get(i);
				}
			}else if(children.get(i) instanceof Sequence){
				if(((Sequence)children.get(i)).getInputConnector().getIncomingLinks().size()==0){
					return children.get(i);
				}
			}else if (children.get(i) instanceof CallMediator) {
				if (((CallMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof LoopBackMediator) {
				if (((LoopBackMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof RespondMediator) {
				if (((RespondMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof ConditionalRouterMediator) {
				if (((ConditionalRouterMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof ValidateMediator) {
				if (((ValidateMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof BeanMediator) {
				if (((BeanMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof EJBMediator) {
				if (((EJBMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof URLRewriteMediator) {
				if (((URLRewriteMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof TransactionMediator) {
				if (((TransactionMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof ForEachMediator) {
				if (((ForEachMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof BuilderMediator) {
				if (((BuilderMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof PublishEventMediator) {
				if (((PublishEventMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}			
		}
		return null;
	}
	
	private boolean validateXML(String xmlString) {
		try {
			OMElement element = AXIOMUtil.stringToOM(xmlString);
			element.build();
		} catch (Exception e) {
			 //ignore. Then parameter value would be a string.
			return false;
		}
		return true;
	}
	
	private void transformAsProxy(TransformationInfo info, EsbNode subject) throws TransformerException, URISyntaxException, XMLStreamException{
		ArrayList<String> transports = new ArrayList<String>();
		List<String> pinnedServers = new ArrayList<String>();
		// Check subject.
		Assert.isTrue(
				subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.ProxyService,
				"Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.ProxyService visualService = (org.wso2.developerstudio.eclipse.gmf.esb.ProxyService) subject;

		// Check start.
		if (info.getTraversalDirection() == TransformationInfo.TRAVERSAL_DIRECTION_IN) {
			
			Assert.isTrue(StringUtils.isNotBlank(visualService.getName()), "Proxy name cannot be empty!");
			
			Assert.isTrue(
					info.getSynapseConfiguration().getProxyService(visualService.getName()) == null,
					"Circular reference detected while serializing proxy service!");

			ProxyService proxyService = new org.apache.synapse.core.axis2.ProxyService(
					visualService.getName());
			info.setCurrentProxy(proxyService);

			if (visualService.getServiceGroup() != null) {
				proxyService.setServiceGroup(visualService.getServiceGroup());
			}

			proxyService.setTraceState(visualService.isTraceEnabled() ? 1 : 0);
			proxyService.setWsSecEnabled(visualService.isSecurityEnabled());
			proxyService.setWsRMEnabled(visualService
					.isReliableMessagingEnabled());

			for (String a : visualService.getTransports().split(",")) {
				transports.add(a);
			}

			proxyService.setTransports(transports);
			switch (visualService.getWsdlType()) {
			case INLINE:
				OMNode node = SynapseConfigUtils.stringToOM(visualService.getWsdlXML());
				proxyService.setInLineWSDL(node);
				break;
			case SOURCE_URL:
				proxyService.setWsdlURI(new URI(visualService.getWsdlURL()));
				break;
			case REGISTRY_KEY:
				proxyService.setWSDLKey(visualService.getWsdlKey().getKeyValue());
				break;
			case ENDPOINT:
				 proxyService.setPublishWSDLEndpoint(visualService.getWsdlEndpoint().getKeyValue());
			case NONE:
				break;
			}
			
			if (visualService.getWsdlType()!=ProxyWsdlType.NONE && visualService.getWsdlType() != ProxyWsdlType.ENDPOINT) {
				proxyService.setResourceMap(new ResourceMap());
				for (ProxyWSDLResource wsdlResource : visualService.getWsdlResources()) {
					proxyService.getResourceMap().addResource(wsdlResource.getLocation(),wsdlResource.getKey().getKeyValue());
				}
			}
			String pinnedServerInfo = visualService.getPinnedServers();
			if (pinnedServerInfo != null && !pinnedServerInfo.equals("")) {
				for (String a : pinnedServerInfo.split(",")) {
					pinnedServers.add(a);
				}
			}
			if (pinnedServers.size() > 0)
				proxyService.setPinnedServers(pinnedServers);
			
		   //Fixing TOOLS-2735	
		   AspectConfiguration aspectConfiguration = new AspectConfiguration(visualService.getName());
		   proxyService.configure(aspectConfiguration);
		   if(visualService.isStatisticsEnabled()){
			   aspectConfiguration.enableStatistics();
		   }else{
			   aspectConfiguration.disableStatistics();
		   }
		   
			info.getSynapseConfiguration().addProxyService(
					visualService.getName(), proxyService);
			
			// startOnLoad attribute.
			proxyService.setStartOnLoad(visualService.isStartOnLoad());
			
			//Proxy Service Parameters.
			for(int i=0;i<visualService.getServiceParameters().size();++i){
				String value = visualService.getServiceParameters().get(i).getValue();
				if (validateXML(value)) {
					OMElement payload = AXIOMUtil.stringToOM(value);
					proxyService.addParameter(
							visualService.getServiceParameters().get(i).getName(), payload);
				} else {
					proxyService.addParameter(
							visualService.getServiceParameters().get(i).getName(), value);
				}
			}
			
			for(int i=0;i<visualService.getServicePolicies().size();++i){
				PolicyInfo policyInfo = new PolicyInfo(visualService.getServicePolicies().get(i).getPolicyKey().getKeyValue());
				proxyService.getPolicies().add(policyInfo);
			}
			

			// In sequence.
			SequenceMediator inSequence = new SequenceMediator();			
			switch (visualService.getInSequenceType()) {
			case ANONYMOUS:
				proxyService.setTargetInLineInSequence(inSequence);
				if (visualService.getInSequenceOnError() != null
						&& StringUtils.isNotBlank(visualService
								.getInSequenceOnError().getKeyValue())) {
					inSequence.setErrorHandler(visualService
							.getInSequenceOnError().getKeyValue());
				}
				break;
				
			case NAMED_REFERENCE:
				proxyService.setTargetInSequence(visualService.getInSequenceName());
				break;

			case REGISTRY_REFERENCE:
				proxyService.setTargetInSequence(visualService.getInSequenceKey().getKeyValue());
				break;
			}

			// Out sequence.
			SequenceMediator outSequence = new SequenceMediator();			
			switch (visualService.getOutSequenceType()) {
			case ANONYMOUS:
				proxyService.setTargetInLineOutSequence(outSequence);
				if (visualService.getOutSequenceOnError() != null
						&& StringUtils.isNotBlank(visualService
								.getOutSequenceOnError().getKeyValue())) {
					outSequence.setErrorHandler(visualService
							.getOutSequenceOnError().getKeyValue());
				}
				break;
			
			case NAMED_REFERENCE:
				proxyService.setTargetOutSequence(visualService.getOutSequenceName());
				break;

			case REGISTRY_REFERENCE:
				proxyService.setTargetOutSequence(visualService.getOutSequenceKey().getKeyValue());
				break;
			}
			
			//Endpoint						
			switch (visualService.getEndpointType()) {
			case ANONYMOUS:
				break;
			
			case NAMED_REFERENCE:
				proxyService.setTargetEndpoint(visualService.getEndpointName());
				break;

			case REGISTRY_REFERENCE:
				proxyService.setTargetEndpoint(visualService.getEndpointKey().getKeyValue());
				break;
			}

			info.setOriginInSequence(inSequence);
			info.setOriginOutSequence(outSequence);
			info.setParentSequence(inSequence);

			// Transform output data flow.
			doTransform(info, visualService.getOutputConnector());
			
			// Transform outSequence
			
			info.setParentSequence(info.getOriginOutSequence());
			info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
			doTransform(info, visualService.getOutSequenceOutputConnector());
			
			//Set Fault Sequence
			SequenceMediator faultSequence = new SequenceMediator();			
			switch (visualService.getFaultSequenceType()) {
			case ANONYMOUS:
				proxyService.setTargetInLineFaultSequence(faultSequence);
				if (visualService.getFaultSequenceOnError() != null
						&& StringUtils.isNotBlank(visualService
								.getFaultSequenceOnError().getKeyValue())) {
					faultSequence.setErrorHandler(visualService
							.getFaultSequenceOnError().getKeyValue());
				}
				break;
			
			case NAMED_REFERENCE:
				proxyService.setTargetFaultSequence(visualService.getFaultSequenceName());
				break;

			case REGISTRY_REFERENCE:
				proxyService.setTargetFaultSequence(visualService.getFaultSequenceKey().getKeyValue());
				break;
			}			
			
			TransformationInfo faultInfo =new TransformationInfo(); 
			faultInfo.setParentSequence(faultSequence);			
			faultInfo.setSynapseConfiguration(info.getSynapseConfiguration());
			doTransformFaultSequence(faultInfo,getOriginNode(visualService));
			
		} else {
			// Round-trip comlplete, send the message back to client.
			// TODO: Need to verify (either here or in the visual model) that
			// this is not a short-cricuit or an illegal message routing
			// operation (attempting to route one proxy service's messages to
			// another).
			// parentMediator.addChild(new SendMediator());
		}
	}
	
	private void transformAsMainSequence(TransformationInfo info, EsbNode subject) throws TransformerException{
		// Check subject.
		Assert.isTrue(
				subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.ProxyService,
				"Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.ProxyService visualService = (org.wso2.developerstudio.eclipse.gmf.esb.ProxyService) subject;

		// Check start.
		if (info.getTraversalDirection() == TransformationInfo.TRAVERSAL_DIRECTION_IN) {

			org.apache.synapse.mediators.base.SequenceMediator sequence =new SequenceMediator();
			sequence.setName("main");
			
			RegistryKeyProperty onErrorSeq = visualService.getOnError();
			if(onErrorSeq!=null){
				if(!StringUtils.isBlank(onErrorSeq.getKeyValue())){
					sequence.setErrorHandler(onErrorSeq.getKeyValue());
				}
			}
			
			InMediator inMediator=new InMediator();
			OutMediator outMediator=new OutMediator();
			
			sequence.addChild(inMediator);
			sequence.addChild(outMediator);
			
			info.setMainSequence(sequence);
			
			info.setOriginInSequence(inMediator);
			info.setOriginOutSequence(outMediator);
			info.setParentSequence(inMediator);
			
			doTransform(info, visualService.getOutputConnector());		
			
			// Transform outSequence
			
			info.setParentSequence(outMediator);
			info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
			doTransform(info, visualService.getOutSequenceOutputConnector());
		} 
	}

}
